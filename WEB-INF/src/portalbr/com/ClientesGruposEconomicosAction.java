package portalbr.com;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.egen.util.jdbc.*;
import com.egen.util.text.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 09/08/2006 15:03:12
 * Last Modify Date 31/10/2019 16:45:50
 */

public class ClientesGruposEconomicosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/ClientesGruposEconomicos_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_grupos_economicos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return actionForward;
  }
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    ClientesGruposEconomicosActionForm f = (ClientesGruposEconomicosActionForm) form;
    portalbr.dbobj.view.Jw_clientes_grupos_economicos table = new portalbr.dbobj.view.Jw_clientes_grupos_economicos();
    boolean filtraPerfil = false;
    StringBuilder parametros = new StringBuilder();
    acesso.Sessao sessao = new acesso.Sessao(session);
    if (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) {
      filtraPerfil = true;
      parametros.append(" AND cr.codigo_representante = '"+sessao.getChave() + "' ");
    }
    if (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")) {
      filtraPerfil = true;
      parametros.append(" AND cr.codigo_representante = '"+sessao.getChave() + "' ");
    }
    if (sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")) {
      filtraPerfil = true;
      parametros.append(" AND ger.codigo_gerente = "+sessao.getChave());
    }
    if (sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) {
      filtraPerfil = true;
      parametros.append(" AND reg.codigo_regional = "+sessao.getChave());
    }

    if (f.getSituacao_cliente_representante() != "") {
      parametros.append("    AND NVL(cr.situacao, NULL) = '"+f.getSituacao_cliente_representante() + "' ");
    }

    if (f.getGre_grupo() != "") {
      parametros.append(" AND g.gre_grupo = "+f.getGre_grupo());
    }
    if (f.getCli_cdgo() != "") {
      parametros.append(" AND c.cli_cdgo = "+f.getCli_cdgo());
    }
    if (f.getRazao_social() != "") {
      parametros.append(" AND upper(c.cli_rzao) like upper('"+f.getRazao_social() + "') ");
    }
    if (f.getDescricao_grupo() != "") {
      parametros.append(" AND upper(g.gre_descricao) like upper('"+f.getDescricao_grupo() + "') ");
    }
    if (f.getSituacao_cliente() != "") {
      parametros.append(" AND c.cli_situ = '"+f.getSituacao_cliente() + "' ");
    }
    if (f.getSituacao_cliente_grupo() != "") {
      parametros.append(" AND g.status = '"+f.getSituacao_cliente_grupo() + "' ");
    }

    StringBuilder sb = new StringBuilder();
    if (!filtraPerfil) {
      sb.append(" SELECT distinct g.gre_grupo ");
      sb.append("      , g.gre_descricao ");
      sb.append("      , c.cli_cdgo ");
      sb.append("      , c.cli_nome ");
      sb.append("      , c.cli_rzao ");
      sb.append("      , c.cli_situ ");
      sb.append("      , g.status ");
      sb.append("      , cr.situacao ");
      sb.append("      , cr.codigo_sequencial ");
      sb.append("      , (select ecl_cdad || ' / ' || ecl.est_unifed from ecl where ecl.cli_cdgo = c.cli_cdgo AND ecl.esc_seqn = cr.codigo_sequencial and rownum = 1) cidade ");
      sb.append("   FROM grupo_economico g ");
      sb.append("      , cli c ");
      sb.append("      , cliente_representante cr ");
      sb.append("  WHERE g.cli_cdgo = c.cli_cdgo ");
      sb.append("    and cr.codigo_cliente = c.cli_cdgo ");
      sb.append(parametros);
      sb.append("  ORDER BY 2,4 ");
    } else {
      sb.append(" SELECT DISTINCT g.gre_grupo ");
      sb.append("      , g.gre_descricao ");
      sb.append("      , c.cli_cdgo ");
      sb.append("      , c.cli_nome ");
      sb.append("      , c.cli_rzao ");
      sb.append("      , c.cli_situ ");
      sb.append("      , g.status ");
      sb.append("      , cr.situacao ");
      sb.append("      , cr.codigo_sequencial ");
      sb.append("      , (select ecl_cdad || ' / ' || ecl.est_unifed from ecl where ecl.cli_cdgo = c.cli_cdgo AND ecl.esc_seqn = cr.codigo_sequencial and rownum = 1) cidade ");
      sb.append("   FROM grupo_economico g ");
      sb.append("      , cli c ");
      sb.append("      , cliente_representante cr ");
      sb.append("      , rep rep       ");
      sb.append("      , regionais_vendas reg ");
      sb.append("      , gerentes_regionais_vendas ger       ");
      sb.append("  WHERE g.cli_cdgo = c.cli_cdgo ");
      sb.append(parametros);
      sb.append("    AND cr.codigo_cliente = c.cli_cdgo  ");
      sb.append("    AND cr.codigo_representante = rep.rep_cdgo    ");
      sb.append("    AND ger.codigo_regional = reg.codigo_regional ");
      sb.append("    AND reg.codigo_regional = rep.codigo_regional ");
      sb.append("  ORDER BY gre_descricao ");
      sb.append("          ,cli_nome ");
    }

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }
    Vector res_Jw_clientes_grupos_economicos = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_clientes_grupos_economicos",res_Jw_clientes_grupos_economicos);
    if (!(res_Jw_clientes_grupos_economicos != null && res_Jw_clientes_grupos_economicos.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ClientesGruposEconomicosActionForm f = (ClientesGruposEconomicosActionForm) form;
      session.removeAttribute("res_Jw_clientes_grupos_economicos");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_grupos_economicos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_select2_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select2_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_grupos_economicos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return actionForward;
  }
  private void select2_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    ClientesGruposEconomicosActionForm f = (ClientesGruposEconomicosActionForm) form;

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception("Query não disponível! Relatório utilizado: ClientesGrupoEconomico.jasper");
    }
    util.file.GeraPDF g = new util.file.GeraPDF(request);
    g.setRelatorio("ClientesGrupoEconomico.jasper");
    if (f.getCli_cdgo() != "") {
      g.setParametro("P_CLI_CDGO",f.getCli_cdgo());
    }
    if (f.getGre_grupo() != "") {
      g.setParametro("P_GRE_GRUPO",f.getGre_grupo());
    }
    if (f.getRazao_social() != "") {
      g.setParametro("P_RAZAO_SOCIAL",f.getRazao_social().toUpperCase());
    }
    if (f.getDescricao_grupo() != "") {
      g.setParametro("P_DESCRICAO_GRUPO",f.getDescricao_grupo().toUpperCase());
    }

    g.gerar();

    if ((f.getAbre_automaticamente() + "").equals("checked")) {
      request.setAttribute("abre_automaticamente","S");
    } else {
      request.setAttribute("abre_automaticamente","N");
    }
    session.setAttribute(mapping.getName(), form);
  }




  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ClientesGruposEconomicosActionForm f = (ClientesGruposEconomicosActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_grupos_economicos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}

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
 * Creation Date 29/09/2011 08:23:59
 * Last Modify Date 23/06/2015 08:31:53
 */

public class FichaClienteAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      FichaClienteActionForm f = (FichaClienteActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_ficha_cliente", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    FichaClienteActionForm f = (FichaClienteActionForm) form;
    Jw_clientes_ficha_cliente table = new Jw_clientes_ficha_cliente();
    StringBuilder parametros = new StringBuilder();
    util.consultas.Query query = new util.consultas.Query();
    if ((f.getCli_cdgo1().equals("")) && (f.getCnpj().equals("")) && (f.getRazao_social().equals("")) && (f.getCidade().equals("")) && (f.getGre_grupo().equals("")) && (f.getCodigo_regional().equals("")) && (f.getRep_cdgo().equals(""))) {
      throw new Exception("Um dos campos obrigatórios deve ser informado!");
    }

    int numeroDias = Integer.parseInt(query.retorna(j, "SELECT to_date('"+f.getData_final() + "','dd/mm/yyyy') - to_date('"+f.getData_inicial() + "','dd/mm/yyyy') FROM dual"));
    if (numeroDias > 365) {
      throw new Exception("O intervalo de datas não pode ser maior que 12 meses!");
    }

    if (f.getData_inicial() != "") {
      parametros.append("  AND p.ped_daem >= to_date('"+f.getData_inicial() + "','dd/mm/yyyy') ");
      session.setAttribute("DATA_INICIAL",f.getData_inicial());
    }

    if (f.getData_final() != "") {
      parametros.append("  AND p.ped_daem <= to_date('"+f.getData_final() + "','dd/mm/yyyy') ");
      session.setAttribute("DATA_FINAL",f.getData_final());
    }

    if (f.getCodigo_regional() != "") {
      parametros.append(" AND nvl(r.codigo_regional,NULL) = " + f.getCodigo_regional());
    }

    if (f.getRep_cdgo() != "") {
      parametros.append(" AND nvl(p.rep_cdgo,NULL) = '" + f.getRep_cdgo() + "' ");
    }

    if (f.getGre_grupo() != "") {
      parametros.append(" AND nvl(ge.gre_grupo,NULL) = " + f.getGre_grupo());
    }

    if (f.getCli_cdgo1() != "") {
      parametros.append(" AND c.cli_cdgo = " + f.getCli_cdgo1());
    }

    if (f.getCnpj() != "") {
      if (f.getCnpj().indexOf("%") != -1) {
        parametros.append(" AND e.esc_cgc like ('" + f.getCnpj() + "')");
      } else {
        parametros.append(" AND e.esc_cgc = " + f.getCnpj());
      }
    }

    if (f.getRazao_social() != "") {
      parametros.append(" AND upper(c.cli_rzao) like UPPER('"+f.getRazao_social() + "') ");
    }

    if (f.getCidade() != "") {
      parametros.append(" AND upper(l.ecl_cdad) like UPPER('"+f.getCidade() + "') ");
    }

    if (f.getLin_cdgo() != "") {
      parametros.append(" AND i.lin_cdgo = " + f.getLin_cdgo());
    }

    if (f.getMarca() != "") {
      parametros.append(" AND i.codigo_marca = " + f.getMarca());
    }

    if (f.getLimite_inicial() != "") {
      parametros.append(" AND nvl(c.cli_valor_credito_analista,0) >= " + f.getLimite_inicial());
    }

    if (f.getLimite_final() != "") {
      parametros.append(" AND nvl(c.cli_valor_credito_analista,0) <= " + f.getLimite_final());
    }

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT DISTINCT  ");
    sb.append("         ge.gre_grupo ");
    sb.append("        ,ge.gre_descricao ");
    sb.append("        ,c.cli_cdgo ");
    sb.append("        ,e.esc_seqn ");
    sb.append("        ,c.cli_rzao ");
    sb.append("        ,fct_formata_cnpj(e.esc_cgc) cnpj ");
    sb.append("        ,l.ecl_cdad || ' - ' || l.est_unifed cidade ");
    sb.append("    FROM ped p ");
    sb.append("        ,rep r ");
    sb.append("        ,ite i ");
    sb.append("        ,cli c ");
    sb.append("        ,cliente_representante cr ");
    sb.append("        ,esc e ");
    sb.append("        ,ecl l ");
    sb.append("        ,regionais_vendas rv ");
    sb.append("        ,grupo_economico ge ");
    sb.append("        ,representante_marca rm ");
    sb.append("        ,rep re ");
    sb.append("   WHERE p.ped_nmro = i.ped_nmro ");
    sb.append("     AND re.rep_cdgo = p.rep_cdgo ");
    sb.append("     AND cr.codigo_cliente = p.cli_cdgo ");
    sb.append("     AND cr.codigo_sequencial = p.esc_seqn ");
    sb.append("     AND cr.codigo_representante = p.rep_cdgo ");
    sb.append("     AND rm.codigo_representante = r.rep_cdgo ");
    sb.append("     AND rm.marca_produto = i.codigo_marca ");
    sb.append("     AND p.cli_cdgo = c.cli_cdgo ");
    sb.append("     AND e.esc_seqn = p.esc_seqn ");
    sb.append("     AND e.cli_cdgo = p.cli_cdgo ");
    sb.append("     AND r.rep_cdgo = p.rep_cdgo ");
    sb.append("     AND l.cli_cdgo = e.cli_cdgo ");
    sb.append("     AND l.esc_seqn = e.esc_seqn ");
    sb.append("     AND rv.codigo_regional = r.codigo_regional ");
    sb.append("     AND ge.cli_cdgo (+) = c.cli_cdgo ");
    sb.append("     AND l.ned_cdgo IN ('ENT', 'UNI') ");
    sb.append("     AND nvl(p.ped_substituicao,'N') <> 'S' ");
    sb.append("     AND p.ped_stat <> 'C' ");
    sb.append("     AND nvl(c.cli_situ,NULL) = '"+f.getSituacao_cliente() + "' ");
    sb.append("     AND p.ped_amostra_brinde IS NULL ");
    sb.append("     AND re.rep_situ = decode('"+f.getSituacao_cliente() + "','I',re.rep_situ,'A') ");
    sb.append("     AND cr.situacao = decode('"+f.getSituacao_cliente() + "','I',cr.situacao,'A') ");
    sb.append("     AND rm.situacao = decode('"+f.getSituacao_cliente() + "','I',cr.situacao,'A') ");
    sb.append(parametros);
    sb.append("   ORDER BY ge.gre_grupo, cli_cdgo, esc_seqn ");

    if (false) {
      throw new Exception(sb.toString());
    }



    Vector res_Jw_clientes_ficha_cliente = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_clientes_ficha_cliente",res_Jw_clientes_ficha_cliente);
    if (!(res_Jw_clientes_ficha_cliente != null && res_Jw_clientes_ficha_cliente.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_ficha_cliente", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      FichaClienteActionForm f = (FichaClienteActionForm) form;
      session.removeAttribute("res_Jw_clientes_ficha_cliente");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_ficha_cliente", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}

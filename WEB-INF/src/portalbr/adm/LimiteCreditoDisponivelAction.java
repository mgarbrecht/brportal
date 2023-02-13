package portalbr.adm;

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
 * Creation Date 05/04/2006 10:25:38
 * Last Modify Date 22/06/2015 14:22:25
 */

public class LimiteCreditoDisponivelAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-----------------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 05/04/2006
    // Objetivo          : Executa uma consulta na java view:
    //                     portalbr.dbobj.view.Jw_limite_credito_disponivel,
    //                     redirecionando para a tela de relatório com os valores retornados pela consulta:
    //                     /adm/LimiteCreditoDisponivel_rForm.jsp
    //------------------------------------------------------------------------------------------------------
    // Data de Alteração : 13/09/2006
    // Descrição         : Os valores "valor_analista", "valor_saldo" e "disponível" passaram a ser
    //                     retornados através das procedures PRC_CTR_PEDIDOS_LIMI e PRC_CTR_PENDENCIA_CL
    //------------------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      LimiteCreditoDisponivelActionForm f = (LimiteCreditoDisponivelActionForm) form;
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      if (f.getCb_totalizar_grupo_economico() != null) {
        actionForward = new ActionForward("/adm/LimiteCreditoDisponivel_rgForm.jsp",true);
      } else {
        actionForward = new ActionForward("/adm/LimiteCreditoDisponivel_rForm.jsp",true);
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_limite_credito_disponivel", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LimiteCreditoDisponivelActionForm f = (LimiteCreditoDisponivelActionForm) form;
    StringBuilder parametros = new StringBuilder();
    String regional = "";
    String representante = "";
    //----------------------------------------------
    String codigo_regional = "";
    String codigo_representante = "";
    String tipo = "";
    acesso.Usuario u = new acesso.Usuario();
    u = (acesso.Usuario) session.getAttribute("User");
    acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
    acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

    if (!(u.getEntidadeNegocio() == null)) {
      ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
      tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
      tipo = tipoent.getTipo() + "";
      if (tipo.equals("REGIONAL DE VENDA")) {
        codigo_regional = ent.getChave() + "";
      }
      if ((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))) {
        codigo_representante = ent.getChave() + "";
      }
    }

    //--- Se o usuário logado for administrador ---
    if (codigo_regional.equals("") && codigo_representante.equals("")) {
      if ((f.getReg() == "") && (f.getRep_cdgo() == "")) {
        // se for administrador, não precisa informar    throw new Exception("Informe a regional e/ou o representante!");
      }
      if ((!(f.getReg().equals("")))) {
        parametros.append(" and r.codigo_regional = ").append(f.getReg());
        regional = f.getReg();
      }
      if ((!(f.getRep_cdgo().equals("")))) {
        parametros.append(" and r.rep_cdgo = ").append(f.getRep_cdgo());
        representante = f.getRep_cdgo();
      }
    }
    //------- Se o usuário logado for regional -----------
    if ((!(f.getCodigo_regional().equals("")))) {
      parametros.append(" and r.codigo_regional = ").append(f.getCodigo_regional());
      regional = f.getCodigo_regional();
      if ((!(f.getRep_cdgo().equals("")))) {
        parametros.append(" and r.rep_cdgo = ").append(f.getRep_cdgo());
        representante = f.getRep_cdgo();
      }
    }

    //-------Se o usuário logado for representante -------
    if ((!(codigo_representante.equals("")))) {
      representante = codigo_representante;
      parametros.append(" and r.rep_cdgo = ").append(codigo_representante);
    }

    //-------Monta parâmetros se o limite for informado-------
    if ((!(f.getLimite_inicial().equals("")))) {
      parametros.append(" AND fnc_ctr_saldo_limite(c.cli_cdgo,'01') >= ").append(f.getLimite_inicial().replace(".", "").replace(",", "."));
    }
    if ((!(f.getLimite_final().equals("")))) {
      parametros.append(" AND fnc_ctr_saldo_limite(c.cli_cdgo,'01') <= ").append(f.getLimite_final().replace(".", "").replace(",", "."));
    }


    //----------------------------------------------------
    portalbr.dbobj.view.Jw_limite_credito_disponivel table = new portalbr.dbobj.view.Jw_limite_credito_disponivel();
    StringBuilder query = new StringBuilder();
    query.append(" SELECT DISTINCT                  ");
    query.append("        c.cli_cdgo cli_codigo    ");
    query.append("      , c.cli_rzao               ");
    query.append("      , ( SELECT DISTINCT gre_grupo || decode(gre_grupo,null,'',' - ') ||gre_descricao ");
    query.append("            FROM ( ");
    query.append("                 SELECT DISTINCT ");
    query.append("                        cli_cdgo ");
    query.append("                      , gre_grupo ");
    query.append("                      , gre_descricao ");
    query.append("                      , status ");
    query.append("                   FROM grupo_economico ");
    query.append("                  WHERE status = 'A' ");
    query.append("                  UNION ");
    query.append("                 SELECT DISTINCT ");
    query.append("                        cli_cdgo ");
    query.append("                      , gre_grupo ");
    query.append("                      , gre_descricao ");
    query.append("                      , status ");
    query.append("                   FROM grupo_economico ");
    query.append("                  WHERE status = 'I' ");
    query.append("                  ORDER BY status ASC ");
    query.append("                 ) ");
    query.append("           WHERE cli_cdgo = c.cli_cdgo ");
    query.append("             AND rownum = 1 ) grupo_economico ");
    query.append("      , 0 valor_analista         ");
    query.append("      , 0 valor_saldo            ");
    query.append("      , 0 disponivel             ");
    query.append("      , 0 perc                   ");
    query.append("      , '' rep_cdgo              ");
    query.append("      , '' rep_rzao              ");
    query.append("      , '' codigo_regional       ");
    query.append("      , '' nome_regional          ");
    query.append("   FROM cli                   c  ");
    query.append("      , cliente_representante cr ");
    query.append("      , rep                   r   ");
    query.append("  WHERE c.cli_cdgo            = cr.codigo_cliente       ");
    query.append("    AND r.rep_cdgo            = cr.codigo_representante ");
    query.append("    AND c.cli_situ            = 'A'                     ");
    query.append("    AND cr.situacao           = 'A'                     ");
    query.append(parametros.toString());

    if (f.getCb_totalizar_grupo_economico() != null) {
      query.append("  ORDER BY 3, c.cli_rzao asc ");
    } else {
      query.append("  ORDER BY c.cli_rzao asc ");
    }


    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(query.toString());
    }

    Vector res_Jw_limite_credito_disponivel = j.select(table, query.toString(), null);

    if (f.getQuantidade() != "") {
      if (Integer.parseInt(f.getQuantidade()) <= res_Jw_limite_credito_disponivel.size()) {
        res_Jw_limite_credito_disponivel.setSize(Integer.parseInt(f.getQuantidade()));
      }
    }


    portalbr.dbobj.procedure.Prc_ctr_pedidos_limi proc = new portalbr.dbobj.procedure.Prc_ctr_pedidos_limi();
    portalbr.dbobj.procedure.Prc_ctr_pendencia_cl proc2 = new portalbr.dbobj.procedure.Prc_ctr_pendencia_cl();

    for (int x = 0; x < res_Jw_limite_credito_disponivel.size(); x++) {
      portalbr.dbobj.view.Jw_limite_credito_disponivel r = (portalbr.dbobj.view.Jw_limite_credito_disponivel) res_Jw_limite_credito_disponivel.elementAt(x);
      proc.setP_cli(com.egen.util.text.FormatNumber.parseDouble(r.getCli_codigo()));
      proc.setP_emp_empresa("01");
      proc2.setP_cli(com.egen.util.text.FormatNumber.parseDouble(r.getCli_codigo()));
      proc2.setP_emp_empresa("01");
      proc = (portalbr.dbobj.procedure.Prc_ctr_pedidos_limi) j.execute(proc);
      proc2 = (portalbr.dbobj.procedure.Prc_ctr_pendencia_cl) j.execute(proc2);
      if (proc != null) {
        r.setValor_analista(proc.getP_limite());
        r.setValor_saldo(proc2.getP_vlr_tot_ger() + proc.getP_vlr_ped_abe_lib());
        r.setDisponivel(proc.getP_saldo());
        if (proc.getP_limite() > 0) {
          r.setPerc(((proc.getP_vlr_ped_abe_lib() + proc2.getP_vlr_tot_ger()) / proc.getP_limite()) * 100);
        } else {
          r.setPerc(0);
        }
      }
    }


    //-------------------
    if ((!(regional.equals("")))) {
      portalbr.dbobj.table.Regionais_vendas db_object = new portalbr.dbobj.table.Regionais_vendas();
      Object[][] where = { {"codigo_regional","=",com.egen.util.text.FormatNumber.toInt(regional)} };
      String[] order = null;
      java.util.Vector results = j.select(db_object, where, order);
      if (results != null && results.size() > 0) {
        db_object = (portalbr.dbobj.table.Regionais_vendas) results.elementAt(0);
        for (int x = 0; x < res_Jw_limite_credito_disponivel.size(); x++) {
          portalbr.dbobj.view.Jw_limite_credito_disponivel r = (portalbr.dbobj.view.Jw_limite_credito_disponivel) res_Jw_limite_credito_disponivel.elementAt(x);
          r.setCodigo_regional(regional);
          r.setNome_regional((db_object.getNome_regional() != null) ? db_object.getNome_regional() + "":"");
        }
      }
    }
    //-------------------
    if ((!(representante.equals("")))) {
      portalbr.dbobj.table.Rep db_object = new portalbr.dbobj.table.Rep();
      Object[][] where = { {"rep_cdgo","like",representante} };
      String[] order = null;
      java.util.Vector results = j.select(db_object, where, order);
      if (results != null && results.size() > 0) {
        db_object = (portalbr.dbobj.table.Rep) results.elementAt(0);
        for (int x = 0; x < res_Jw_limite_credito_disponivel.size(); x++) {
          portalbr.dbobj.view.Jw_limite_credito_disponivel r = (portalbr.dbobj.view.Jw_limite_credito_disponivel) res_Jw_limite_credito_disponivel.elementAt(x);
          r.setRep_cdgo(representante);
          r.setRep_rzao((db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":"");
        }
      }
    }
    //-------------------
    session.setAttribute("res_Jw_limite_credito_disponivel",res_Jw_limite_credito_disponivel);
    if (!(res_Jw_limite_credito_disponivel != null && res_Jw_limite_credito_disponivel.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LimiteCreditoDisponivelActionForm f = (LimiteCreditoDisponivelActionForm) form;
      session.removeAttribute("res_Jw_limite_credito_disponivel");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_limite_credito_disponivel", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}

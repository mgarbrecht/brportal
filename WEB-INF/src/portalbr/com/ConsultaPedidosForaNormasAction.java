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
 * Creation Date 07/03/2006 15:03:23
 * Last Modify Date 27/01/2017 15:07:46
 */

public class ConsultaPedidosForaNormasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    ConsultaPedidosForaNormasActionForm f = (ConsultaPedidosForaNormasActionForm) form;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/ConsultaPedidosForaNormas_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ConsultaPedidosForaNormasActionForm f = (ConsultaPedidosForaNormasActionForm) form;
    portalbr.dbobj.view.Jw_pedidos_fora_normas table = new portalbr.dbobj.view.Jw_pedidos_fora_normas();
    //-------------------------------------------------------------------------
    if (f.getEsc_cgc() != "") {
      portalbr.dbobj.view.Jw_clientes_cgc table_cgc = new portalbr.dbobj.view.Jw_clientes_cgc();
      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT b.esc_seqn ");
      sb.append("      , b.cli_cdgo ");
      sb.append("   FROM esc b ");
      sb.append("      , ecl c ");
      sb.append("  WHERE b.esc_cgc    =  ").append(f.getEsc_cgc());
      sb.append("    AND b.esc_seqn   =  c.esc_seqn ");
      sb.append("    AND b.esc_seqn   >  0 ");
      sb.append("    AND b.cli_cdgo   =  c.cli_cdgo ");
      sb.append("    AND (c.ned_cdgo  =  'UNI' or c.ned_cdgo = 'ENT') ");

      Vector res_Jw_clientes_cgc = j.select(table_cgc, sb.toString(), null);

      if (res_Jw_clientes_cgc != null && res_Jw_clientes_cgc.size() > 0) {
        portalbr.dbobj.view.Jw_clientes_cgc r = (portalbr.dbobj.view.Jw_clientes_cgc) res_Jw_clientes_cgc.elementAt(0);
        f.setCli_cdgo(r.getCli_cdgo());
        f.setSeq(r.getEsc_seqn());
      }
    }
    //-------------------------------------------------------------------------
    String parametros = "";
    String parametros2 = "";
    if (f.getCli_cdgo() != "") {
      parametros2 += " AND ped.cli_cdgo = "+f.getCli_cdgo();
      parametros += " AND codigo_cliente = "+f.getCli_cdgo();
    }

    if (f.getSeq() != "") {
      parametros += " AND codigo_sequencial = "+f.getSeq();
    }

    if (f.getLin_cdgo() != "") {
      parametros2 += " AND ite.lin_cdgo = "+f.getLin_cdgo();
    }

    if (f.getRef_cdgo() != "") {
      parametros2 += " AND ite.ref_cdgo = "+f.getRef_cdgo();
    }

    //--- se o usuário logado for administrador ---
    if ((f.getRepresentante().equals("")) && (f.getRegional().equals(""))) {
      if (f.getRep_cdgo() != "") {
        parametros2 += " AND ped.rep_cdgo = '"+f.getRep_cdgo() + "'";
        parametros += " AND codigo_representante = '"+f.getRep_cdgo() + "'";
      }
    }
    //------- Se o usuário logado for regional -----------
    if ((!(f.getRegional().equals("")))) {
      parametros += " AND r.codigo_regional = nvl("+f.getRegional() + ",r.codigo_regional)";
      if ((!(f.getRep_cdgo().equals("")))) {
        parametros += " AND rep_cdgo = '"+f.getRep_cdgo() + "' ";
      }
    }
    //-------Se o usuário logado for representante --------
    if ((!(f.getRepresentante().equals("")))) {
      parametros2 += " and ped.rep_cdgo = '"+f.getRepresentante() + "'";
      parametros += " and codigo_representante = '"+f.getRepresentante() + "'";
    }

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT /*+ all_rows */ DISTINCT ");
    sb.append("        ped.ped_nmro ped_nmro ");
    sb.append("      , ped.ped_nped ped_rep ");
    sb.append("      , decode(ped.ped_stat,'F','Faturado','C','Cancelado','Aberto') ped_stat ");
    sb.append("    , decode(ped.ped_stat,'A','Liber.Prod','B','Em Análise', ");
    sb.append("                          'C','Cancelado','F','Faturado','L','Liberado','P','Bloq.Cred.', ");
    sb.append("                    'PF','Parc.Fat','T','Bloq.Com') ped_stat_real ");
    sb.append("      , ped.ped_dadg ped_data ");
    sb.append("      , ped.ped_det ped_det ");
    sb.append("      , ped.ped_emba ped_emb ");
    sb.append("    , ped.rep_cdgo rep_codigo ");
    sb.append("      , ite.lin_cdgo cod_lin ");
    sb.append("      , lin.lin_nome nome_lin ");
    sb.append("   FROM ped ");
    sb.append("      , situacoes_pedidos sp ");
    sb.append("      , ite ");
    sb.append("      , lin ");
    sb.append("  WHERE ped.rep_cdgo      IN    (SELECT DISTINCT codigo_representante rep_cod ");
    sb.append("                                   FROM cliente_representante ");
    sb.append("                                      , rep r ");
    sb.append("                                  WHERE codigo_representante = r.rep_cdgo ");
    sb.append(parametros);
    sb.append("                                    AND situacao             = 'A') ");

    sb.append("    AND ped.ped_nmro = sp.ped_nmro ");
    sb.append("    AND NVL(sp.ts_codigo_situacao, NULL) = 36 ");

    sb.append("    AND ped.ped_dadg              >= to_date('").append(f.getDt_inicial()).append("','dd/mm/yyyy') ");
    sb.append("    AND ped.ped_dadg              <  to_date('").append(f.getDt_final()).append("','dd/mm/yyyy') ");
    sb.append("    AND ite.lin_cdgo              =  lin.lin_cdgo ");
    sb.append("    AND ite.ped_nmro           =  ped.ped_nmro ");
    sb.append("    AND ite.ped_nmro              >  0 ");
    sb.append(parametros2);

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");

    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }

    Vector res_Jw_pedidos_fora_normas = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_pedidos_fora_normas",res_Jw_pedidos_fora_normas);
    if (!(res_Jw_pedidos_fora_normas != null && res_Jw_pedidos_fora_normas.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaPedidosForaNormasActionForm f = (ConsultaPedidosForaNormasActionForm) form;
      session.removeAttribute("res_Jw_consulta_pedidos");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_select3_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaPedidosForaNormasActionForm f = (ConsultaPedidosForaNormasActionForm) form;
      tg_select3_action(mapping, form, request, response);
      actionForward = new ActionForward("/com/ConsultaPedidos_iForm.do?select_action=&pedido_beira_rio="+f.getNr_pedido1(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {

    }
    return actionForward;
  }
  private void tg_select3_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaPedidosForaNormasActionForm f = (ConsultaPedidosForaNormasActionForm) form;
      String representante = "null";
      String regional = "null";

      if (f.getRep() != "") {
        representante = f.getRep();
      }

      if (f.getReg() != "") {
        regional = f.getReg();
      }

      portalbr.dbobj.view.Jw_pedidos_fora_normas table_2 = new portalbr.dbobj.view.Jw_pedidos_fora_normas();
      StringBuilder query = new StringBuilder();
      query.append(" SELECT DISTINCT ");
      query.append("        ped.ped_nmro ped_nmro, ");
      query.append("        ped.ped_nped ped_rep, ");
      query.append("        decode(ped.ped_stat,'F','Faturado','C','Cancelado','Aberto') ped_stat, ");
      query.append("   decode(ped.ped_stat,'A','Liber.Prod','B','Bloq.Imp', ");
      query.append("                 'C','Cancelado','F','Faturado','L','Liberado','P','Bloq.Cred.', ");
      query.append("                'PF','Parc.Fat','T','Bloq.Com') ped_stat_real, ");
      query.append("        ped.ped_dadg ped_data, ");
      query.append("        ped.ped_det ped_det, ");
      query.append("        ped.ped_emba ped_emb, ");
      query.append("        ped.rep_cdgo rep_codigo, ");
      query.append("        ite.lin_cdgo cod_lin, ");
      query.append("        lin.lin_nome nome_lin ");
      query.append("   FROM ped, ");
      query.append("        ite, ");
      query.append("        lin ");
      query.append("  WHERE ped.rep_cdgo      IN    (SELECT DISTINCT ");
      query.append("                                        codigo_representante rep_cod ");
      query.append("                                   FROM cliente_representante, ");
      query.append("                                        rep r ");
      query.append("                                  WHERE codigo_representante = r.rep_cdgo ");
      query.append("                                    AND r.codigo_regional    = nvl(").append(regional).append(",r.codigo_regional) ");
      query.append("                                    AND situacao             = 'A') ");
      query.append("    AND ped.ped_stat              <> 'C' ");
      query.append("    AND ped.ped_devolver_repres   = 'X' ");
      query.append("    AND ped.ped_nmro              = ").append(f.getNr_pedido1());
      query.append("    AND ite.lin_cdgo              = lin.lin_cdgo ");
      query.append("    AND ite.ped_nmro        = ped.ped_nmro ");
      query.append("    AND nvl(ped.rep_cdgo,null)    = decode(").append(representante).append(",null,ped.rep_cdgo,").append(representante).append(") ");

      Vector res_Jw_pedidos_fora_normas_2 = j.select(table_2, query.toString(), null);

      if (!(res_Jw_pedidos_fora_normas_2 != null && res_Jw_pedidos_fora_normas_2.size() > 0)) {
        throw new Exception("Pedido não encontrado!");
      }

      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
  }

}

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
 * Creation Date 11/04/2006 15:43:26
 * Last Modify Date 21/08/2013 12:15:12
 */

public class TitulosCLDAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //---------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 11/04/2006
    // Objetivo          : Executa uma consulta na visão portalbr.dbobj.view.Jw_titulos_cld,
    //                     redirecionando para a tela de relatório:
    //                     /adm/TitulosCLD_rForm
    //----------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //----------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      TitulosCLDActionForm f = (TitulosCLDActionForm) form;
      session.setAttribute("parametro1",f.getDt_inicial());
      session.setAttribute("parametro2",f.getDt_final());
      actionForward = new ActionForward("/adm/TitulosCLD_rForm.jsp?&dt_inicial="+f.getDt_inicial() + "&dt_final="+f.getDt_final(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_titulos_cld", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    TitulosCLDActionForm f = (TitulosCLDActionForm) form;
    String rep = "null";
    String regional = "null";
    StringBuilder parametros = new StringBuilder();
    if (f.getCli_cdgo() != "") {
      parametros.append(" and c.cli_cdgo = "+f.getCli_cdgo());
    }
    //------------------------------------------------------------------------------------
    //-- Monta os parâmetros para a query
    //------------------------------------------------------------------------------------
    //-- se o usuário logado for administrador -------------------------------------------
    if ((f.getRep().equals("")) && (f.getReg().equals(""))) {
      if ((!(f.getCodigo_regional().equals("")))) {
        regional = f.getCodigo_regional();
      }
      if ((!(f.getRep_cdgo().equals("")))) {
        rep = f.getRep_cdgo();
      }
    }
    //------- Se o usuário logado for regional -----------
    if ((!(f.getReg().equals("")))) {
      regional = f.getReg();
      if ((!(f.getRep_cdgo().equals("")))) {
        rep = f.getRep_cdgo();
      }
    }
    //-------Se o usuário logado for representante --------
    if ((!(f.getRep().equals("")))) {
      rep = f.getRep();
    }
    //-----------------------------------------------------------------------------------
    StringBuilder query = new StringBuilder();
    portalbr.dbobj.view.Jw_titulos_cld table = new portalbr.dbobj.view.Jw_titulos_cld();
    query.append(" SELECT DISTINCT ");
    query.append("        ger.codigo_regional codigo_reg ");
    query.append("      , rv.nome_regional ");
    query.append("      , rep_cdgo ");
    query.append("      , rep.rep_rzao ");
    query.append("      , ger.codigo_gerente codigo_analista ");
    query.append("      , ger.nome_gerente nome_analista ");
    query.append("      , c.cli_cdgo ");
    query.append("      , c.cli_rzao ");
    query.append("      , tit.tit_codigo titulo ");
    query.append("      , tit.tit_datemi data_emissao ");
    query.append("      , tit.tit_datvenc data_venc ");
    query.append("      , sum(tit.tit_valor) valor_cld ");
    query.append("      , sum(nvl(tit.tit_vlpcp,0)) vlpcp ");
    query.append("      , sum(nvl(tit.tit_vldeb,0)) vldeb ");
    query.append("      , (sum(tit.tit_valor) - (sum(nvl(tit.tit_vlpcp,0)) + sum(nvl(tit.tit_vldeb,0)))) saldo ");
    query.append("   FROM titulos                    tit ");
    query.append("      , rep                        rep ");
    query.append("      , gerentes_regionais_vendas  ger ");
    query.append("      , cli                        c ");
    query.append("      , regionais_vendas           rv ");
    query.append("  WHERE tit.tip_codigo           = 'NTC' ");
    query.append("    AND rv.codigo_regional       = ger.codigo_regional ");
    query.append("    AND trunc(tit.tit_datemi)    BETWEEN to_date('").append(f.getDt_inicial()).append("','dd/mm/yyyy')  ");
    query.append("                                     AND to_date('").append(f.getDt_final()).append("','dd/mm/yyyy') ");
    query.append("    AND nvl(tit.tit_status,'X')  = 'A' ");
    query.append("    AND tit.rep_codigo           = rep.rep_cdgo ");
    query.append("    AND tit.cli_codigo           = c.cli_cdgo ");
    query.append("    AND rep.rep_cdgo             = nvl(").append(rep).append(",rep_cdgo) ");
    query.append(parametros.toString());
    query.append("    AND ger.codigo_gerente       IN (SELECT DISTINCT ger.codigo_gerente codigo_ger ");
    query.append("                                       FROM gerentes_regionais_vendas   ger ");
    query.append("                                          , regionais_vendas            reg ");
    query.append("                                      WHERE ger.codigo_regional  = nvl(").append(regional).append(",ger.codigo_regional) ");
    query.append("                                        AND reg.codigo_regional  = ger.codigo_regional) ");
    query.append("    AND rep.rep_gerente_antigo   = ger.codigo_gerente ");
    query.append("    AND (tit.emp_empresa, tit.fil_filial, ");
    query.append("        tit.tip_codigo , tit.tit_codigo)  NOT IN ");
    query.append("                                          (SELECT m.emp_empresa ");
    query.append("                                                , m.fil_filial ");
    query.append("                                                , m.tip_codigo ");
    query.append("                                                , m.tit_codigo ");
    query.append("                                             FROM mov_receber m ");
    query.append("                                            WHERE nvl(m.emp_empresa,null)  = nvl(tit.emp_empresa,null) ");
    query.append("                                              AND nvl(m.fil_filial,null)   = nvl(tit.fil_filial,null) ");
    query.append("                                              AND nvl(m.tip_codigo,null)   = nvl(tit.tip_codigo,null) ");
    query.append("                                              AND m.tit_codigo            = nvl(tit.tit_codigo,null) ");
    query.append("                                              AND nvl(m.trn_codigo,null) in ('DIS','TNC','CON','FAL','NEG','PNE') ");
    query.append("                                              AND trunc(mov_data)          <= to_date('").append(f.getDt_final()).append("','dd/mm/yyyy') ");
    query.append("                                              AND nvl(m.mov_data,null)          <= to_date('").append(f.getDt_final()).append("','dd/mm/yyyy') ");
    query.append("                                              AND nvl(m.mov_sequencia,0)  = 0 ");
    query.append("                                              AND rownum = 1 ) ");
    query.append("  GROUP BY tit.tit_codigo ");
    query.append("         , tit.tit_datvenc ");
    query.append("         , tit.tit_datemi ");
    query.append("         , tit.tit_valor ");
    query.append("         , tit.tit_vlpcp ");
    query.append("         , tit.tit_vldeb ");
    query.append("         , rep_cdgo ");
    query.append("         , rep.rep_rzao ");
    query.append("         , c.cli_cdgo ");
    query.append("         , c.cli_rzao ");
    query.append("         , ger.codigo_regional ");
    query.append("         , ger.codigo_gerente ");
    query.append("         , ger.nome_gerente ");
    query.append("         , rv.nome_regional ");
    query.append("  ORDER BY ger.codigo_regional ");
    query.append("         , rep.rep_cdgo ");
    query.append("         , c.cli_cdgo ");
    query.append("         , tit.tit_codigo ");

    Vector res_Jw_titulos_cld = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_titulos_cld",res_Jw_titulos_cld);
    if (!(res_Jw_titulos_cld != null && res_Jw_titulos_cld.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    request.setAttribute("dt_inicial",f.getDt_inicial());
    request.setAttribute("dt_final",f.getDt_final());
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      TitulosCLDActionForm f = (TitulosCLDActionForm) form;
      session.removeAttribute("res_Jw_titulos_cld");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_titulos_cld", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}

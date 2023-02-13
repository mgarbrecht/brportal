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
 * Creation Date 11/04/2006 10:27:55
 * Last Modify Date 18/12/2014 09:46:18
 */

public class ChequesCLDAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-----------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 11/04/2006
    // Objetivo          : Executa uma consulta na view Jw_cheques_cld, após a consulta, redireciona
    //                     para a tela de relatório:
    //                     /adm/ChequesCLD_rForm.jsp
    //-----------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-----------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      ChequesCLDActionForm f = (ChequesCLDActionForm) form;
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      StringBuilder path = new StringBuilder();
      path.append("/adm/ChequesCLD_rForm.jsp?&dt_inicial=").append(f.getDt_inicial());
      path.append("&dt_final=").append(f.getDt_final());
      session.setAttribute("parametros", f.getDt_inicial() + " - "+f.getDt_final());
      actionForward = new ActionForward(path.toString(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cheques_cld", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ChequesCLDActionForm f = (ChequesCLDActionForm) form;
    StringBuilder regional = new StringBuilder();
    StringBuilder representante = new StringBuilder();

    //--- Monta os parâmetros para a query -----------------------------------------------------
    //--- se o usuário logado for administrador ---
    if ((f.getRep().equals("")) && (f.getReg().equals(""))) {
      regional = new StringBuilder();
      if ((!(f.getCodigo_regional().equals("")))) {
        regional.append(f.getCodigo_regional());
      } else {
        regional = new StringBuilder();
        regional.append("null");
      }
    }
    //------- Se o usuário logado for regional -----------
    if ((!(f.getReg().equals("")))) {
      regional = new StringBuilder();
      regional.append(f.getReg());
    } else {
      regional = new StringBuilder();
      if (f.getCodigo_regional().equals("")) {
        regional.append("null");
      } else {
        regional.append(f.getCodigo_regional());
      }
    }

    //-------Se o usuário logado for representante --------
    if ((!(f.getRep().equals("")))) {
      representante = new StringBuilder();
      representante.append(f.getRep());
    } else {
      representante.append("null");
    }
    //------------------------------------------------------------------------------------------


    portalbr.dbobj.view.Jw_cheques_cld table = new portalbr.dbobj.view.Jw_cheques_cld();
    StringBuilder query = new StringBuilder();
    query.append(" SELECT rv.codigo_regional ");
    query.append("      , rv.nome_regional ");
    query.append("      , che.numero_do_cheque numero ");
    query.append("      , che.age_codigo agencia ");
    query.append("      , che.prt_codigo_banco portador ");
    query.append("      , che.rep_cdgo cod_repres ");
    query.append("      , rep.rep_rzao rep_razao ");
    query.append("      , cli.cli_cdgo cliente ");
    query.append("      , cli.cli_rzao nome ");
    query.append("      , che.tip_codigo tipo ");
    query.append("      , ger.codigo_gerente ");
    query.append("      , sum(nvl(che.valor_do_cheque,0)) valor_pcp ");
    query.append("      , sum(nvl(che.che_vldeb,0)) valor_deb ");
    query.append("      , (sum(mov.valor_principal) - sum(nvl(che.che_vlpcp,0)) - sum(nvl(che.che_vldeb,0))) saldo  ");
    query.append("   FROM cheques che ");
    query.append("      , cli cli ");
    query.append("      , rep rep ");
    query.append("      , movimentos_cheque mov ");
    query.append("      , gerentes_regionais_vendas ger ");
    query.append("      , regionais_vendas rv ");
    query.append("      , (SELECT DISTINCT ");
    query.append("                rep.rep_cdgo cod_repres ");
    query.append("              , rep.codigo_regional ");
    query.append("           FROM cheques che ");
    query.append("              , cli cli ");
    query.append("              , rep rep ");
    query.append("              , movimentos_cheque mov ");
    query.append("              , gerentes_regionais_vendas ger ");
    query.append("              , (SELECT rep_cdgo rep_cdgo ");
    query.append("                      , rep.codigo_regional ");
    query.append("                   FROM rep rep ");
    query.append("                  WHERE rep.codigo_regional = decode(").append(regional.toString()).append(",null,rep.codigo_regional,").append(regional.toString()).append(") ");
    query.append("                    AND rep.rep_cdgo        = decode(").append(representante.toString()).append(",null,rep.rep_cdgo,").append(representante.toString()).append(") ");
    query.append("                ) representante ");
    query.append("          WHERE che.emp_empresa            =  mov.emp_empresa ");
    query.append("            AND che.fil_filial                   =  mov.fil_filial ");
    query.append("            AND che.tip_codigo                   =  mov.tip_codigo ");
    query.append("            AND che.cli_cdgo                   =  mov.cli_cdgo ");
    query.append("            AND che.prt_codigo_banco             =  mov.prt_codigo_banco ");
    query.append("            AND che.age_codigo                   =  mov.age_codigo ");
    query.append("            AND che.numero_do_cheque             =  mov.che_numero_do_cheque ");
    query.append("            AND cli.cli_cdgo                     =  che.cli_cdgo ");
    query.append("            AND rep.rep_cdgo                     =  che.rep_cdgo ");
    query.append("            AND ger.codigo_gerente           =  rep.rep_gerente_antigo ");
    query.append("            AND nvl(che.rep_cdgo,null)           =  representante.rep_cdgo  ");
    query.append("            AND ger.codigo_regional              =  representante.codigo_regional ");
    query.append("            AND che.emp_empresa                  =  '01' ");
    query.append("            AND che.sit_codigo_situacao_titulo   =  '7' ");
    query.append("            AND trunc(mov.data_do_movimento)    >=  to_date(?,'dd/mm/yyyy') ");
    query.append("            AND trunc(mov.data_do_movimento)    <=  to_date(?,'dd/mm/yyyy') ");
    query.append("            AND mov.trn_codigo            =  'CLD') representante ");
    query.append("  WHERE che.emp_empresa            =  mov.emp_empresa ");
    query.append("    AND rv.codigo_regional              =  rep.codigo_regional ");
    query.append("    AND che.fil_filial            =  mov.fil_filial ");
    query.append("    AND che.tip_codigo            =  mov.tip_codigo ");
    query.append("    AND che.cli_cdgo             =  mov.cli_cdgo ");
    query.append("    AND che.prt_codigo_banco            =  mov.prt_codigo_banco ");
    query.append("    AND che.age_codigo                  =  mov.age_codigo ");
    query.append("    AND che.numero_do_cheque            =  mov.che_numero_do_cheque  ");
    query.append("    AND cli.cli_cdgo                    =  che.cli_cdgo ");
    query.append("    AND rep.rep_cdgo                    =  che.rep_cdgo ");
    query.append("    AND ger.codigo_gerente              =  rep.rep_gerente_antigo  ");
    query.append("    AND che.emp_empresa                 =  '01' ");
    query.append("    AND che.sit_codigo_situacao_titulo  =  '7' ");
    query.append("    AND rep.codigo_regional             =  representante.codigo_regional ");
    query.append("    AND rep.rep_cdgo                    =  decode(representante.cod_repres,null,rep.rep_cdgo,representante.cod_repres)  ");
    query.append("    AND mov.trn_codigo                  =  'CLD'  ");
    query.append("    AND rv.codigo_regional              >  0 ");
    query.append("  GROUP BY rv.codigo_regional ");
    query.append("         , rv.nome_regional ");
    query.append("         , che.numero_do_cheque ");
    query.append("         , che.age_codigo ");
    query.append("         , che.prt_codigo_banco ");
    query.append("         , che.rep_cdgo ");
    query.append("         , rep.rep_rzao ");
    query.append("         , cli.cli_cdgo ");
    query.append("         , cli.cli_rzao ");
    query.append("   , che.tip_codigo ");
    query.append("         , ger.codigo_gerente ");
    query.append("         , che.che_vlpcp ");
    query.append("         , che.che_vldeb ");
    query.append("         , cli.cli_rzao ");
    query.append("  ORDER BY che.rep_cdgo ");

    Object[] placeholder = {f.getDt_inicial(), f.getDt_final()};

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(query.toString());
    }

    if (false) {
      throw new Exception(query.toString());
    }

    Vector res_Jw_cheques_cld = j.select(table , query.toString(), placeholder);

    session.setAttribute("res_Jw_cheques_cld",res_Jw_cheques_cld);
    if (!(res_Jw_cheques_cld != null && res_Jw_cheques_cld.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ChequesCLDActionForm f = (ChequesCLDActionForm) form;
      session.removeAttribute("res_Jw_cheques_cld");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cheques_cld", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}

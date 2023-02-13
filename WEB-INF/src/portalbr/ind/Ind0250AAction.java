package portalbr.ind;

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
 * Creation Date 23/08/2018 16:57:51
 * Last Modify Date 22/08/2019 10:32:21
 */

public class Ind0250AAction extends com.egen.util.struts.AbstractAction {


  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      com.beirario.brportal.util.DateUtil dateUtil = new com.beirario.brportal.util.DateUtil();
      Ind0250AActionForm f = (Ind0250AActionForm) form;
      boolean informouDataBotas = true;

      if (f.getP_data_inicial_ant_botas() != null && f.getP_data_inicial_ant_botas().equals("__/__/____")) {
        f.setP_data_inicial_ant_botas("");
      }

      if (f.getP_data_final_ant_botas() != null && f.getP_data_final_ant_botas().equals("__/__/____")) {
        f.setP_data_final_ant_botas("");
      }

      if (f.getP_data_inicial_ant_botas() != "") {
        if (f.getP_data_final_ant_botas().equals("")) {
          throw new Exception("A Dt. Final Botas deve ser informada!");
        }
      }

      if (f.getP_data_final_ant_botas() != "") {
        if (f.getP_data_inicial_ant_botas().equals("")) {
          throw new Exception("A Dt. Inicial Botas deve ser informada!");
        }
      }


      if (f.getP_data_inicial_ant_botas().equals("") || f.getP_data_final_ant_botas().equals("")) {
        informouDataBotas = false;
      }

      java.sql.CallableStatement call = null;
      try {
        call = j.getConn().prepareCall("{ call pck_ind0250.gerar_dados_laminas(?, ?, ?, ?) }");
        call.setDate(1, new java.sql.Date(dateUtil.parseDate(("01/" + f.getDt_inicial())).getTime()));
        call.setDate(2, new java.sql.Date(dateUtil.parseDate(("01/" + f.getDt_final())).getTime()));
        if (f.getP_data_inicial_ant_botas() != "") {
          call.setDate(3, new java.sql.Date(dateUtil.parseDate(f.getP_data_inicial_ant_botas()).getTime()));
        } else {
          call.setDate(3, null);
        }
        if (f.getP_data_final_ant_botas() != "") {
          call.setDate(4, new java.sql.Date(dateUtil.parseDate(f.getP_data_final_ant_botas()).getTime()));
        } else {
          call.setDate(4, null);
        }
        call.execute();
      } catch (Exception e) {
        e.printStackTrace(System.out);
      } finally {
        call.close();
      }
      util.file.GeraPPTX g = new util.file.GeraPPTX(request);
      g.setRelatorio("IND0250_A.jasper");
      g.setParametro("IMAGE_FOLDER", "/opt/tomcat/webapps/brportal/img/");
      g.setParametro("p_data_inicial", dateUtil.parseDate(("01/"+f.getDt_inicial())));
      g.setParametro("p_data_final", dateUtil.parseDate(("01/"+f.getDt_final())));
      if (informouDataBotas) {
        g.setParametro("p_imprimir_sem_botas", "N");
      } else {
        g.setParametro("p_imprimir_sem_botas", "S");
      }
      if (f.getCodigo_marca() != "") {
        g.setParametro("p_codigo_marca", new java.math.BigDecimal(f.getCodigo_marca()));
      }
      g.gerar();
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dual", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Ind0250AActionForm f = (Ind0250AActionForm) form;
      tg_resetfull_action(mapping, form, request, response);
      session.removeAttribute("res_Dual");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dual", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void tg_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    request.setAttribute("resetou", true);
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

}

package portalbr.lov;

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
 * Creation Date 30/11/2007 11:01:43
 * Last Modify Date 07/03/2008 14:26:12
 */

public class LvFiliaisAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvFiliaisActionForm[]_ge_grid_array = (LvFiliaisActionForm[])_ge_grid.get("bl_form_Filial_lines");

      String filiais = "";
      java.util.Vector vetor = new java.util.Vector();
      if (_ge_grid_array != null) {
        LvFiliaisActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];


          java.sql.PreparedStatement pstm = j.getConn().prepareStatement("   select fil_razsoc from filial where fil_filial = ? ");
          pstm.setString(1, f.getFil_filial());
          java.sql.ResultSet rset = pstm.executeQuery();
          if (rset.next()) {
            f.setFil_razsoc(rset.getString(1));
          }
          rset.close();
          pstm.close();


          if (filiais.equals("")) {
            if ((!(f.getFil_filial().equals("")))) {
              vetor.addElement(f.getFil_filial() + "-"+f.getFil_razsoc());
              filiais = "x"+f.getFil_filial() + "x";
            }
          } else {
            if ((!(f.getFil_filial().equals("")))) {
              vetor.addElement(f.getFil_filial() + "-"+f.getFil_razsoc());
              filiais += ",x"+f.getFil_filial() + "x";
            }
          }

        }
        f = _ge_grid_array[0];
      }
      session.setAttribute("filiais_selecionadas",vetor);
      request.setAttribute("filiais",filiais);

      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Filial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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



  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      LvFiliaisActionForm[]_ge_grid_array = (LvFiliaisActionForm[])_ge_grid.get("bl_form_Filial_lines");
      LvFiliaisActionForm f = _ge_grid_array[0];
      session.removeAttribute("res_Filial");
      com.egen.util.struts.AbstractActionHelper.resetForm("bl_form_Filial_lines", mapping, form, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Filial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}

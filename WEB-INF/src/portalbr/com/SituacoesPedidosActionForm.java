package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 24/08/2007 17:46:11
 * Last Modify Date 20/08/2013 08:08:34
 */

public class SituacoesPedidosActionForm extends org.apache.struts.action.ActionForm
{
  public String ped_nmro;
  private boolean valida = false;
  public SituacoesPedidosActionForm() {
  }
  /**
    * PED_NMRO: Method to get the field value.
    */
  public String getPed_nmro() {
    return ped_nmro;
  }
  /**
    * PED_NMRO: Method to set the field value.
    */
  public void setPed_nmro(String PARAM) {
    ped_nmro = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    ped_nmro = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
      if (com.egen.util.text.Validate.isNull(ped_nmro)) {
        errors.add("ped_nmro", new ActionMessage("error.validate.notnull",java.util.ResourceBundle.getBundle("ComercialResources").getString("SituacoesPedidos.ped_nmro"), "ped_nmro","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(ped_nmro, "^[0-9]*$")) {
        errors.add("ped_nmro", new ActionMessage("error.validate.regex",java.util.ResourceBundle.getBundle("ComercialResources").getString("SituacoesPedidos.ped_nmro"), "ped_nmro","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

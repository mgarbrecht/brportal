package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 06/06/2011 17:07:05
 * Last Modify Date 07/06/2011 09:51:56
 */

public class PedidosShowRoom_aActionForm extends org.apache.struts.action.ActionForm
{
  public String id_showroom;
  public String dt_showroom;
  public String ped_nmro;
  private boolean valida = false;
  public PedidosShowRoom_aActionForm() {
  }
  /**
    * ID_SHOWROOM: Method to get the field value.
    */
  public String getId_showroom() {
    return id_showroom;
  }
  /**
    * ID_SHOWROOM: Method to set the field value.
    */
  public void setId_showroom(String PARAM) {
    id_showroom = PARAM;
  }
  /**
    * DT_SHOWROOM: Method to get the field value.
    */
  public String getDt_showroom() {
    return dt_showroom;
  }
  /**
    * DT_SHOWROOM: Method to set the field value.
    */
  public void setDt_showroom(String PARAM) {
    dt_showroom = PARAM;
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
    id_showroom = null;
    dt_showroom = null;
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
    if (!com.egen.util.struts.Token.isTokenValid(mapping, request)) {
      errors.add("Warning", new ActionMessage("token.error","<br>","","",""));
    }
    com.egen.util.struts.Token.saveToken(mapping, request);

    if (com.egen.util.text.Validate.isValidate("insert_action,delete_action,", request)) {
      if (com.egen.util.text.Validate.isNull(ped_nmro)) {
        errors.add("ped_nmro", new ActionMessage("error.validate.notnull","Pedido","ped_nmro","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

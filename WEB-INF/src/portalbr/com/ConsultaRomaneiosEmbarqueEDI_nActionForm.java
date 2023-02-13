package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 27/04/2007 14:47:47
 * Last Modify Date 22/10/2015 14:33:24
 */

public class ConsultaRomaneiosEmbarqueEDI_nActionForm extends org.apache.struts.action.ActionForm
{
  public String nro_romaneio_embarque;
  private boolean valida = false;
  public ConsultaRomaneiosEmbarqueEDI_nActionForm() {
  }
  /**
    * NRO_ROMANEIO_EMBARQUE: Method to get the field value.
    */
  public String getNro_romaneio_embarque() {
    return nro_romaneio_embarque;
  }
  /**
    * NRO_ROMANEIO_EMBARQUE: Method to set the field value.
    */
  public void setNro_romaneio_embarque(String PARAM) {
    nro_romaneio_embarque = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    nro_romaneio_embarque = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

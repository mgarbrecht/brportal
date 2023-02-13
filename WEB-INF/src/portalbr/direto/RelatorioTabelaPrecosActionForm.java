package portalbr.direto;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 06/02/2013 15:39:12
 * Last Modify Date 21/08/2014 09:06:52
 */

public class RelatorioTabelaPrecosActionForm extends org.apache.struts.action.ActionForm
{
  public String usuario;
  public String codigo_marca;
  private boolean valida = false;
  public RelatorioTabelaPrecosActionForm() {
  }
  /**
    * USUARIO: Method to get the field value.
    */
  public String getUsuario() {
    return usuario;
  }
  /**
    * USUARIO: Method to set the field value.
    */
  public void setUsuario(String PARAM) {
    usuario = PARAM;
  }
  /**
    * CODIGO_MARCA: Method to get the field value.
    */
  public String getCodigo_marca() {
    return codigo_marca;
  }
  /**
    * CODIGO_MARCA: Method to set the field value.
    */
  public void setCodigo_marca(String PARAM) {
    codigo_marca = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    usuario = null;
    codigo_marca = null;
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

package portalbr.direto;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 29/08/2017 10:45:00
 * Last Modify Date 01/09/2017 11:25:57
 */

public class ImagensPedidoActionForm extends org.apache.struts.action.ActionForm
{
  public String chave;
  public String pedido;
  private boolean valida = false;
  public ImagensPedidoActionForm() {
  }
  /**
    * CHAVE: Method to get the field value.
    */
  public String getChave() {
    return chave;
  }
  /**
    * CHAVE: Method to set the field value.
    */
  public void setChave(String PARAM) {
    chave = PARAM;
  }
  /**
    * PEDIDO: Method to get the field value.
    */
  public String getPedido() {
    return pedido;
  }
  /**
    * PEDIDO: Method to set the field value.
    */
  public void setPedido(String PARAM) {
    pedido = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    chave = null;
    pedido = null;
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

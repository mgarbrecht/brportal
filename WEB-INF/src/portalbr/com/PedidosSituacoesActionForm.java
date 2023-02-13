package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 09/03/2006 17:21:27
 * Last Modify Date 10/12/2009 17:32:25
 */

public class PedidosSituacoesActionForm extends org.apache.struts.action.ActionForm
{
  public String pedido_beira_rio;
  private boolean valida = false;
  public PedidosSituacoesActionForm() {
  }
  /**
    * PEDIDO_BEIRA_RIO: Method to get the field value.
    */
  public String getPedido_beira_rio() {
    return pedido_beira_rio;
  }
  /**
    * PEDIDO_BEIRA_RIO: Method to set the field value.
    */
  public void setPedido_beira_rio(String PARAM) {
    pedido_beira_rio = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    pedido_beira_rio = null;
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

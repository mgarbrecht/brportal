package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 29/04/2015 09:28:47
 * Last Modify Date 07/05/2015 10:52:57
 */

public class VerificacaoCaixasIndividuaisCorrugadosActionForm extends org.apache.struts.action.ActionForm
{
  public String rotulo;
  public String mensagem;
  private boolean valida = false;
  public VerificacaoCaixasIndividuaisCorrugadosActionForm() {
  }
  /**
    * ROTULO: Method to get the field value.
    */
  public String getRotulo() {
    return rotulo;
  }
  /**
    * ROTULO: Method to set the field value.
    */
  public void setRotulo(String PARAM) {
    rotulo = PARAM;
  }
  /**
    * MENSAGEM: Method to get the field value.
    */
  public String getMensagem() {
    return mensagem;
  }
  /**
    * MENSAGEM: Method to set the field value.
    */
  public void setMensagem(String PARAM) {
    mensagem = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    rotulo = null;
    mensagem = null;
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

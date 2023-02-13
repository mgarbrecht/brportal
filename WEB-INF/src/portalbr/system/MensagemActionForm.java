package portalbr.system;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 28/06/2012 14:24:50
 * Last Modify Date 20/12/2016 12:30:16
 */

public class MensagemActionForm extends org.apache.struts.action.ActionForm
{
  public String aceito;
  private boolean valida = false;
  public MensagemActionForm() {
  }
  /**
    * ACEITO: Método Gets para este campo
    */
  public String getAceito() {
    return aceito;
  }
  /**
    * ACEITO: Método Sets pára este campo.
    */
  public void setAceito(String PARAM) {
    aceito = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    aceito = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
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

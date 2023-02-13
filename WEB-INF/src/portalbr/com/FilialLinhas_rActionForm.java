package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Creation Date 11/09/2006 11:51:31
 * Last Modify Date 12/09/2006 13:32:41
 */

public class FilialLinhas_rActionForm extends org.apache.struts.action.ActionForm
{
  private boolean valida = false;
  public FilialLinhas_rActionForm() {
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
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

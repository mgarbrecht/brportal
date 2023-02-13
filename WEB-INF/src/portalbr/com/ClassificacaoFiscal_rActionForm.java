package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Creation Date 08/09/2006 11:23:38
 * Last Modify Date 08/09/2006 11:24:37
 */

public class ClassificacaoFiscal_rActionForm extends org.apache.struts.action.ActionForm
{
  private boolean valida = false;
  public ClassificacaoFiscal_rActionForm() {
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

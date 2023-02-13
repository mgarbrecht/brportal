package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 14/08/2009 09:55:06
 * Last Modify Date 18/08/2009 09:31:46
 */

public class PendenciasRegionais_rcActionForm extends org.apache.struts.action.ActionForm
{
  private boolean valida = false;
  public PendenciasRegionais_rcActionForm() {
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
    if (!com.egen.util.struts.Token.isTokenValid(mapping, request)) {
      errors.add("Warning", new ActionMessage("token.error","<br>","","",""));
    }
    com.egen.util.struts.Token.saveToken(mapping, request);

    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

package portalbr.system;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 28/01/2011 07:43:49
 * Last Modify Date 02/04/2013 16:11:23
 */

public class TrocaSenhaDiretaActionForm extends org.apache.struts.action.ActionForm
{
  public String chave;
  private boolean valida = false;
  public TrocaSenhaDiretaActionForm() {
  }
  /**
    * CHAVE: Método Gets para este campo
    */
  public String getChave() {
    return chave;
  }
  /**
    * CHAVE: Método Sets pára este campo.
    */
  public void setChave(String PARAM) {
    chave = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    chave = null;
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

package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 28/06/2006 08:23:57
 * Last Modify Date 16/09/2009 14:10:51
 */

public class PlusClientes_rActionForm extends org.apache.struts.action.ActionForm
{
  public String cod;
  private boolean valida = false;
  public PlusClientes_rActionForm() {
  }
  /**
    * COD: Método Gets para este campo
    */
  public String getCod() {
    return cod;
  }
  /**
    * COD: Método Sets pára este campo.
    */
  public void setCod(String PARAM) {
    cod = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    cod = null;
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

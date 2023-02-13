package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 12/04/2006 17:08:06
 * Last Modify Date 26/03/2013 15:41:44
 */

public class AdministradorPedidos_rActionForm extends org.apache.struts.action.ActionForm
{
  public String quebra;
  private boolean valida = false;
  public AdministradorPedidos_rActionForm() {
  }
  /**
    * QUEBRA: Método Gets para este campo
    */
  public String getQuebra() {
    return quebra;
  }
  /**
    * QUEBRA: Método Sets pára este campo.
    */
  public void setQuebra(String PARAM) {
    quebra = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    quebra = null;
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

package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 23/01/2015 11:28:34
 * Last Modify Date 23/01/2015 11:36:58
 */

public class LvAtelierActionForm extends org.apache.struts.action.ActionForm
{
  public String fo_codigo;
  public String fo_razsoc;
  private boolean valida = false;
  public LvAtelierActionForm() {
  }
  /**
    * FO_CODIGO: Método Gets para este campo
    */
  public String getFo_codigo() {
    return fo_codigo;
  }
  /**
    * FO_CODIGO: Método Sets pára este campo.
    */
  public void setFo_codigo(String PARAM) {
    fo_codigo = PARAM;
  }
  /**
    * FO_RAZSOC: Método Gets para este campo
    */
  public String getFo_razsoc() {
    return fo_razsoc;
  }
  /**
    * FO_RAZSOC: Método Sets pára este campo.
    */
  public void setFo_razsoc(String PARAM) {
    fo_razsoc = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    fo_codigo = null;
    fo_razsoc = null;
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

package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 20/06/2006 14:19:15
 * Last Modify Date 05/04/2013 08:53:35
 */

public class NormasVenda_rActionForm extends org.apache.struts.action.ActionForm
{
  public String pos;
  public String lidi_id;
  public String lidi_caminho;
  private boolean valida = false;
  public NormasVenda_rActionForm() {
  }
  /**
    * POS: Método Gets para este campo
    */
  public String getPos() {
    return pos;
  }
  /**
    * POS: Método Sets pára este campo.
    */
  public void setPos(String PARAM) {
    pos = PARAM;
  }
  /**
    * LIDI_ID: Método Gets para este campo
    */
  public String getLidi_id() {
    return lidi_id;
  }
  /**
    * LIDI_ID: Método Sets pára este campo.
    */
  public void setLidi_id(String PARAM) {
    lidi_id = PARAM;
  }
  /**
    * LIDI_CAMINHO: Método Gets para este campo
    */
  public String getLidi_caminho() {
    return lidi_caminho;
  }
  /**
    * LIDI_CAMINHO: Método Sets pára este campo.
    */
  public void setLidi_caminho(String PARAM) {
    lidi_caminho = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    pos = null;
    lidi_id = null;
    lidi_caminho = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("delete_action,", request)) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 30/11/2007 11:01:43
 * Last Modify Date 29/02/2008 13:40:57
 */

public class LvFiliaisActionForm extends org.apache.struts.action.ActionForm
{
  public String fil_filial;
  public String fil_razsoc;
  public String return0;
  public String return03;
  private boolean valida = false;
  public LvFiliaisActionForm() {
  }
  /**
    * FIL_FILIAL: Método Gets para este campo
    */
  public String getFil_filial() {
    return fil_filial;
  }
  /**
    * FIL_FILIAL: Método Sets pára este campo.
    */
  public void setFil_filial(String PARAM) {
    fil_filial = PARAM;
  }
  /**
    * FIL_RAZSOC: Método Gets para este campo
    */
  public String getFil_razsoc() {
    return fil_razsoc;
  }
  /**
    * FIL_RAZSOC: Método Sets pára este campo.
    */
  public void setFil_razsoc(String PARAM) {
    fil_razsoc = PARAM;
  }
  /**
    * RETURN0: Método Gets para este campo
    */
  public String getReturn0() {
    return return0;
  }
  /**
    * RETURN0: Método Sets pára este campo.
    */
  public void setReturn0(String PARAM) {
    return0 = PARAM;
  }
  /**
    * RETURN03: Método Gets para este campo
    */
  public String getReturn03() {
    return return03;
  }
  /**
    * RETURN03: Método Sets pára este campo.
    */
  public void setReturn03(String PARAM) {
    return03 = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    fil_filial = null;
    fil_razsoc = null;
    return0 = null;
    return03 = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
//    if (get()) {
//    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

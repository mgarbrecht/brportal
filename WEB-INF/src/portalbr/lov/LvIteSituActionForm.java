package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 12/09/2013 08:46:26
 * Last Modify Date 14/06/2019 11:45:07
 */

public class LvIteSituActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String return0;
  public String rv_low_value;
  public String rv_meaning;
  private boolean valida = false;
  public LvIteSituActionForm() {
  }
  /**
    * GRIDCHECKFIELD: Método Gets para este campo
    */
  public boolean getGridCheckField() {
    return gridCheckField;
  }
  /**
    * GRIDCHECKFIELD: Método Sets pára este campo.
    */
  public void setGridCheckField(boolean PARAM) {
    gridCheckField = PARAM;
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
    * RV_LOW_VALUE: Método Gets para este campo
    */
  public String getRv_low_value() {
    return rv_low_value;
  }
  /**
    * RV_LOW_VALUE: Método Sets pára este campo.
    */
  public void setRv_low_value(String PARAM) {
    rv_low_value = PARAM;
  }
  /**
    * RV_MEANING: Método Gets para este campo
    */
  public String getRv_meaning() {
    return rv_meaning;
  }
  /**
    * RV_MEANING: Método Sets pára este campo.
    */
  public void setRv_meaning(String PARAM) {
    rv_meaning = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    return0 = null;
    rv_low_value = null;
    rv_meaning = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (getGridCheckField()) {
      if (com.egen.util.text.Validate.isValidate("selecionar_action,", request)) {
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

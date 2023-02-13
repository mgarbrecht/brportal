package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 20/01/2006 10:54:49
 * Last Modify Date 20/03/2009 09:27:27
 */

public class LvEmpresaActionForm extends org.apache.struts.action.ActionForm
{
  public String emp_empresa;
  public String return0;
  public String emp_razsoc;
  private boolean valida = false;
  public LvEmpresaActionForm() {
  }
  /**
    * EMP_EMPRESA: Method to get the field value.
    */
  public String getEmp_empresa() {
    return emp_empresa;
  }
  /**
    * EMP_EMPRESA: Method to set the field value.
    */
  public void setEmp_empresa(String PARAM) {
    emp_empresa = PARAM;
  }
  /**
    * RETURN0: Method to get the field value.
    */
  public String getReturn0() {
    return return0;
  }
  /**
    * RETURN0: Method to set the field value.
    */
  public void setReturn0(String PARAM) {
    return0 = PARAM;
  }
  /**
    * EMP_RAZSOC: Method to get the field value.
    */
  public String getEmp_razsoc() {
    return emp_razsoc;
  }
  /**
    * EMP_RAZSOC: Method to set the field value.
    */
  public void setEmp_razsoc(String PARAM) {
    emp_razsoc = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    emp_empresa = null;
    return0 = null;
    emp_razsoc = null;
  }
  /**
    * Validate fields and return errors.
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

package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 20/03/2006 15:30:01
 * Last Modify Date 10/08/2015 15:18:31
 */

public class ImpressaoDuplicatasClientesActionForm extends org.apache.struts.action.ActionForm
{
  public String dt_venc;
  public String situacao;
  public String emp_empresa;
  private boolean valida = false;
  public ImpressaoDuplicatasClientesActionForm() {
  }
  /**
    * DT_VENC: Method to get the field value.
    */
  public String getDt_venc() {
    return dt_venc;
  }
  /**
    * DT_VENC: Method to set the field value.
    */
  public void setDt_venc(String PARAM) {
    dt_venc = PARAM;
  }
  /**
    * SITUACAO: Method to get the field value.
    */
  public String getSituacao() {
    return situacao;
  }
  /**
    * SITUACAO: Method to set the field value.
    */
  public void setSituacao(String PARAM) {
    situacao = PARAM;
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
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    dt_venc = null;
    situacao = null;
    emp_empresa = null;
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

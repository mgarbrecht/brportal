package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 20/03/2006 15:30:01
 * Last Modify Date 21/09/2018 15:55:24
 */

public class ImpressaoDuplicatasClientesNVActionForm extends org.apache.struts.action.ActionForm
{
  public String dt_venc;
  public String situacao;
  public String emp_empresa;
  public String dt_venc_final;
  private boolean valida = false;
  public ImpressaoDuplicatasClientesNVActionForm() {
  }
  /**
    * DT_VENC: M�todo Gets para este campo
    */
  public String getDt_venc() {
    return dt_venc;
  }
  /**
    * DT_VENC: M�todo Sets p�ra este campo.
    */
  public void setDt_venc(String PARAM) {
    dt_venc = PARAM;
  }
  /**
    * SITUACAO: M�todo Gets para este campo
    */
  public String getSituacao() {
    return situacao;
  }
  /**
    * SITUACAO: M�todo Sets p�ra este campo.
    */
  public void setSituacao(String PARAM) {
    situacao = PARAM;
  }
  /**
    * EMP_EMPRESA: M�todo Gets para este campo
    */
  public String getEmp_empresa() {
    return emp_empresa;
  }
  /**
    * EMP_EMPRESA: M�todo Sets p�ra este campo.
    */
  public void setEmp_empresa(String PARAM) {
    emp_empresa = PARAM;
  }
  /**
    * DT_VENC_FINAL: M�todo Gets para este campo
    */
  public String getDt_venc_final() {
    return dt_venc_final;
  }
  /**
    * DT_VENC_FINAL: M�todo Sets p�ra este campo.
    */
  public void setDt_venc_final(String PARAM) {
    dt_venc_final = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    dt_venc = null;
    situacao = null;
    emp_empresa = null;
    dt_venc_final = null;
  }
  /**
    * Valida��o dos campos, retornando um ActionErrors.
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

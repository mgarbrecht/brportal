package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 24/01/2019 09:45:34
 * Last Modify Date 10/09/2021 12:25:13
 */

public class AnaliseCredito_cgActionForm extends org.apache.struts.action.ActionForm
{
  public String data_inicial;
  public String data_final;
  public String p_cli_cdgo;
  public String p_clientes;
  public String p_grupo_economico;
  public String p_emp;
  private boolean valida = false;
  public AnaliseCredito_cgActionForm() {
  }
  /**
    * DATA_INICIAL: Método Gets para este campo
    */
  public String getData_inicial() {
    return data_inicial;
  }
  /**
    * DATA_INICIAL: Método Sets pára este campo.
    */
  public void setData_inicial(String PARAM) {
    data_inicial = PARAM;
  }
  /**
    * DATA_FINAL: Método Gets para este campo
    */
  public String getData_final() {
    return data_final;
  }
  /**
    * DATA_FINAL: Método Sets pára este campo.
    */
  public void setData_final(String PARAM) {
    data_final = PARAM;
  }
  /**
    * P_CLI_CDGO: Método Gets para este campo
    */
  public String getP_cli_cdgo() {
    return p_cli_cdgo;
  }
  /**
    * P_CLI_CDGO: Método Sets pára este campo.
    */
  public void setP_cli_cdgo(String PARAM) {
    p_cli_cdgo = PARAM;
  }
  /**
    * P_CLIENTES: Método Gets para este campo
    */
  public String getP_clientes() {
    return p_clientes;
  }
  /**
    * P_CLIENTES: Método Sets pára este campo.
    */
  public void setP_clientes(String PARAM) {
    p_clientes = PARAM;
  }
  /**
    * P_GRUPO_ECONOMICO: Método Gets para este campo
    */
  public String getP_grupo_economico() {
    return p_grupo_economico;
  }
  /**
    * P_GRUPO_ECONOMICO: Método Sets pára este campo.
    */
  public void setP_grupo_economico(String PARAM) {
    p_grupo_economico = PARAM;
  }
  /**
    * P_EMP: Método Gets para este campo
    */
  public String getP_emp() {
    return p_emp;
  }
  /**
    * P_EMP: Método Sets pára este campo.
    */
  public void setP_emp(String PARAM) {
    p_emp = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    data_inicial = null;
    data_final = null;
    p_cli_cdgo = null;
    p_clientes = null;
    p_grupo_economico = null;
    p_emp = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (!com.egen.util.struts.Token.isTokenValid(mapping, request)) {
      errors.add("Warning", new ActionMessage("token.error","<br>","","",""));
    }
    com.egen.util.struts.Token.saveToken(mapping, request);

    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
      if (com.egen.util.text.Validate.isNull(data_inicial)) {
        errors.add("data_inicial", new ActionMessage("error.validate.notnull","Data Inicial","data_inicial","0"));
      }
      if (com.egen.util.text.Validate.isNull(data_final)) {
        errors.add("data_final", new ActionMessage("error.validate.notnull","Data Final","data_final","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

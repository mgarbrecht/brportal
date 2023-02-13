package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 11/05/2006 10:18:42
 * Last Modify Date 21/10/2016 12:30:48
 */

public class TrocaSenhaActionForm extends org.apache.struts.action.ActionForm
{
  public String usua_id;
  public String usua_senha;
  public String forcasenha;
  public String usua_senha_confirma;
  public String observacao;
  public String fl;
  private boolean valida = false;
  public TrocaSenhaActionForm() {
  }
  /**
    * USUA_ID: Method to get the field value.
    */
  public String getUsua_id() {
    return usua_id;
  }
  /**
    * USUA_ID: Method to set the field value.
    */
  public void setUsua_id(String PARAM) {
    usua_id = PARAM;
  }
  /**
    * USUA_SENHA: Method to get the field value.
    */
  public String getUsua_senha() {
    return usua_senha;
  }
  /**
    * USUA_SENHA: Method to set the field value.
    */
  public void setUsua_senha(String PARAM) {
    usua_senha = PARAM;
  }
  /**
    * FORCASENHA: Method to get the field value.
    */
  public String getForcasenha() {
    return forcasenha;
  }
  /**
    * FORCASENHA: Method to set the field value.
    */
  public void setForcasenha(String PARAM) {
    forcasenha = PARAM;
  }
  /**
    * USUA_SENHA_CONFIRMA: Method to get the field value.
    */
  public String getUsua_senha_confirma() {
    return usua_senha_confirma;
  }
  /**
    * USUA_SENHA_CONFIRMA: Method to set the field value.
    */
  public void setUsua_senha_confirma(String PARAM) {
    usua_senha_confirma = PARAM;
  }
  /**
    * OBSERVACAO: Method to get the field value.
    */
  public String getObservacao() {
    return observacao;
  }
  /**
    * OBSERVACAO: Method to set the field value.
    */
  public void setObservacao(String PARAM) {
    observacao = PARAM;
  }
  /**
    * FL: Method to get the field value.
    */
  public String getFl() {
    return fl;
  }
  /**
    * FL: Method to set the field value.
    */
  public void setFl(String PARAM) {
    fl = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    usua_id = null;
    usua_senha = null;
    forcasenha = null;
    usua_senha_confirma = null;
    observacao = null;
    fl = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("update_action,", request)) {
      if (com.egen.util.text.Validate.isNull(usua_senha)) {
        errors.add("usua_senha", new ActionMessage("error.validate.notnull",java.util.ResourceBundle.getBundle("AcessoResources").getString("TrocaSenha.usua_senha"), "usua_senha","0"));
      }
      if (!com.egen.util.text.Validate.isMaxlength(usua_senha, 32)) {
        errors.add("usua_senha", new ActionMessage("error.validate.maxlength",java.util.ResourceBundle.getBundle("AcessoResources").getString("TrocaSenha.usua_senha"), "usua_senha","32","0"));
      }
      if (com.egen.util.text.Validate.isNull(usua_senha_confirma)) {
        errors.add("usua_senha_confirma", new ActionMessage("error.validate.notnull",java.util.ResourceBundle.getBundle("AcessoResources").getString("TrocaSenha.usua_senha_confirma"), "usua_senha_confirma","0"));
      }
      if (!com.egen.util.text.Validate.isMaxlength(usua_senha_confirma, 32)) {
        errors.add("usua_senha_confirma", new ActionMessage("error.validate.maxlength",java.util.ResourceBundle.getBundle("AcessoResources").getString("TrocaSenha.usua_senha_confirma"), "usua_senha_confirma","32","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

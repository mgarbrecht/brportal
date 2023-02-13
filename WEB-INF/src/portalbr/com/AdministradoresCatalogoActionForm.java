package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 01/11/2011 08:50:03
 * Last Modify Date 02/04/2013 13:44:08
 */

public class AdministradoresCatalogoActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo_usuario;
  public String nome_usuario;
  public String senha_usuario;
  public String codigo_regional;
  public String email;
  public String pos;
  private boolean valida = false;
  public AdministradoresCatalogoActionForm() {
  }
  /**
    * CODIGO_USUARIO: Method to get the field value.
    */
  public String getCodigo_usuario() {
    return codigo_usuario;
  }
  /**
    * CODIGO_USUARIO: Method to set the field value.
    */
  public void setCodigo_usuario(String PARAM) {
    codigo_usuario = PARAM;
  }
  /**
    * NOME_USUARIO: Method to get the field value.
    */
  public String getNome_usuario() {
    return nome_usuario;
  }
  /**
    * NOME_USUARIO: Method to set the field value.
    */
  public void setNome_usuario(String PARAM) {
    nome_usuario = PARAM;
  }
  /**
    * SENHA_USUARIO: Method to get the field value.
    */
  public String getSenha_usuario() {
    return senha_usuario;
  }
  /**
    * SENHA_USUARIO: Method to set the field value.
    */
  public void setSenha_usuario(String PARAM) {
    senha_usuario = PARAM;
  }
  /**
    * CODIGO_REGIONAL: Method to get the field value.
    */
  public String getCodigo_regional() {
    return codigo_regional;
  }
  /**
    * CODIGO_REGIONAL: Method to set the field value.
    */
  public void setCodigo_regional(String PARAM) {
    codigo_regional = PARAM;
  }
  /**
    * EMAIL: Method to get the field value.
    */
  public String getEmail() {
    return email;
  }
  /**
    * EMAIL: Method to set the field value.
    */
  public void setEmail(String PARAM) {
    email = PARAM;
  }
  /**
    * POS: Method to get the field value.
    */
  public String getPos() {
    return pos;
  }
  /**
    * POS: Method to set the field value.
    */
  public void setPos(String PARAM) {
    pos = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo_usuario = null;
    nome_usuario = null;
    senha_usuario = null;
    codigo_regional = null;
    email = null;
    pos = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,update_action,delete_action,", request)) {
      if (com.egen.util.text.Validate.isNull(codigo_usuario)) {
        errors.add("codigo_usuario", new ActionMessage("error.validate.notnull","Código Usuário","codigo_usuario","0"));
      }
      if (com.egen.util.text.Validate.isNull(nome_usuario)) {
        errors.add("nome_usuario", new ActionMessage("error.validate.notnull","Nome","nome_usuario","0"));
      }
      if (com.egen.util.text.Validate.isNull(senha_usuario)) {
        errors.add("senha_usuario", new ActionMessage("error.validate.notnull","Senha","senha_usuario","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

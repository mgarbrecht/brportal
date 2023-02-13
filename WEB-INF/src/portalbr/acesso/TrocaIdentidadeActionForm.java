package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 28/08/2006 15:48:36
 * Last Modify Date 14/12/2017 11:33:13
 */

public class TrocaIdentidadeActionForm extends org.apache.struts.action.ActionForm
{
  public String usua_id;
  public String usua_usuario;
  public String usua_nome;
  private boolean valida = false;
  public TrocaIdentidadeActionForm() {
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
    * USUA_USUARIO: Method to get the field value.
    */
  public String getUsua_usuario() {
    return usua_usuario;
  }
  /**
    * USUA_USUARIO: Method to set the field value.
    */
  public void setUsua_usuario(String PARAM) {
    usua_usuario = PARAM;
  }
  /**
    * USUA_NOME: Method to get the field value.
    */
  public String getUsua_nome() {
    String fieldRelationValue = "";
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (usua_usuario != null && usua_usuario.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Usuarios db_object = new portalbr.dbobj.table.Usuarios();
        Object[][] where = { {"usua_usuario","like",usua_usuario} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Usuarios) results.elementAt(0);
          fieldRelationValue = (db_object.getUsua_nome() != null) ? db_object.getUsua_nome() + "":"";
        }
      }
    } catch (Exception e) {
      fieldRelationValue = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    usua_nome = fieldRelationValue;
    return usua_nome;
  }
  /**
    * USUA_NOME: Method to set the field value.
    */
  public void setUsua_nome(String PARAM) {
    usua_nome = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    usua_id = null;
    usua_usuario = null;
    usua_nome = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
      if (com.egen.util.text.Validate.isNull(usua_usuario)) {
        errors.add("usua_usuario", new ActionMessage("error.validate.notnull","Usuário","usua_usuario","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

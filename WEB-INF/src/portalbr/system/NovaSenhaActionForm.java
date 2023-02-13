package portalbr.system;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 27/01/2011 11:30:20
 * Last Modify Date 04/03/2015 08:24:40
 */

public class NovaSenhaActionForm extends org.apache.struts.action.ActionForm
{
  public String mostrausuario;
  public String email;
  public String usuario;
  private boolean valida = false;
  public NovaSenhaActionForm() {
  }
  /**
    * MOSTRAUSUARIO: Método Gets para este campo
    */
  public String getMostrausuario() {
    return mostrausuario;
  }
  /**
    * MOSTRAUSUARIO: Método Sets pára este campo.
    */
  public void setMostrausuario(String PARAM) {
    mostrausuario = PARAM;
  }
  /**
    * EMAIL: Método Gets para este campo
    */
  public String getEmail() {
    return email;
  }
  /**
    * EMAIL: Método Sets pára este campo.
    */
  public void setEmail(String PARAM) {
    email = PARAM;
  }
  /**
    * USUARIO: Método Gets para este campo
    */
  public String getUsuario() {
    return usuario;
  }
  /**
    * USUARIO: Método Sets pára este campo.
    */
  public void setUsuario(String PARAM) {
    usuario = PARAM;
  }
  private Vector usuarioList = new Vector(10, 10);
  public void setUsuarioList(java.util.Vector VECTOR) {
    usuarioList = VECTOR;
  }
  public java.util.Vector getUsuarioList() {
    usuarioList = new Vector(10, 10);
    usuarioLabelList = new Vector(10, 10);
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (mostrausuario.equals("S")) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_usuarios_troca_senha db_object = new Jw_usuarios_troca_senha();
        String[][] select = null;
        Object[][] where = {{"usua_email","=", email}};
        String[] order = {"usua_usuario"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Jw_usuarios_troca_senha) results.elementAt(i);
          usuarioList.addElement(""+db_object.getUsua_id());
          usuarioLabelList.addElement(""+db_object.getUsua_usuario() + " - "+db_object.getUsua_nome());
        }
      }
    } catch (Exception e) {
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return usuarioList;
  }
  private java.util.Vector usuarioLabelList = new Vector(10, 10);
  public void setUsuarioLabelList(java.util.Vector VECTOR) {
    usuarioLabelList = VECTOR;
  }
  public java.util.Vector getUsuarioLabelList() {
    return usuarioLabelList;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    mostrausuario = null;
    email = null;
    usuario = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,", request)) {
      if (com.egen.util.text.Validate.isNull(email)) {
        errors.add("email", new ActionMessage("error.validate.notnull","Email","email","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

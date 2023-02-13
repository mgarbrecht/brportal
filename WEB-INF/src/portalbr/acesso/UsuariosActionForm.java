package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 17/01/2006 11:12:40
 * Last Modify Date 22/06/2015 14:55:33
 */

public class UsuariosActionForm extends org.apache.struts.action.ActionForm
{
  public String usua_usuario;
  public String usua_nome;
  public String tien_tipo;
  public String usua_super;
  private boolean valida = false;
  public UsuariosActionForm() {
  }
  /**
    * USUA_USUARIO: Método Gets para este campo
    */
  public String getUsua_usuario() {
    return usua_usuario;
  }
  /**
    * USUA_USUARIO: Método Sets pára este campo.
    */
  public void setUsua_usuario(String PARAM) {
    usua_usuario = PARAM;
  }
  /**
    * USUA_NOME: Método Gets para este campo
    */
  public String getUsua_nome() {
    return usua_nome;
  }
  /**
    * USUA_NOME: Método Sets pára este campo.
    */
  public void setUsua_nome(String PARAM) {
    usua_nome = PARAM;
  }
  /**
    * TIEN_TIPO: Método Gets para este campo
    */
  public String getTien_tipo() {
    return tien_tipo;
  }
  /**
    * TIEN_TIPO: Método Sets pára este campo.
    */
  public void setTien_tipo(String PARAM) {
    tien_tipo = PARAM;
  }
  private Vector tien_tipoList = new Vector(10, 10);
  public void setTien_tipoList(java.util.Vector VECTOR) {
    tien_tipoList = VECTOR;
  }
  public java.util.Vector getTien_tipoList() {
    tien_tipoList = new Vector(10, 10);
    tien_tipoLabelList = new Vector(10, 10);
    tien_tipoList.addElement("");
    tien_tipoLabelList.addElement("Todos");
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      portalbr.dbobj.table.Tipos_entidade_negocio db_object = new portalbr.dbobj.table.Tipos_entidade_negocio();
      String[][] select = null;
      Object[][] where = null;
      String[] order = {"tien_tipo"};
      Vector results = j.select(db_object, select, where, null, null, order);
      for (int i = 0; i < results.size(); i++) {
        db_object = (portalbr.dbobj.table.Tipos_entidade_negocio) results.elementAt(i);
        tien_tipoList.addElement(""+db_object.getTien_tipo());
        tien_tipoLabelList.addElement(""+db_object.getTien_tipo());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "Usuarios.", e);
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return tien_tipoList;
  }
  private java.util.Vector tien_tipoLabelList = new Vector(10, 10);
  public void setTien_tipoLabelList(java.util.Vector VECTOR) {
    tien_tipoLabelList = VECTOR;
  }
  public java.util.Vector getTien_tipoLabelList() {
    return tien_tipoLabelList;
  }
  /**
    * USUA_SUPER: Método Gets para este campo
    */
  public String getUsua_super() {
    return usua_super;
  }
  /**
    * USUA_SUPER: Método Sets pára este campo.
    */
  public void setUsua_super(String PARAM) {
    usua_super = PARAM;
  }
  Vector usua_superList = new Vector(10, 1);
  public java.util.Vector getUsua_superList() {
    if (usua_superList == null || usua_superList.size() == 0) {
      usua_superList.addElement("");
      usua_superLabelList.addElement("Todos");
      usua_superList.addElement("S");
      usua_superLabelList.addElement("Sim");
      usua_superList.addElement("N");
      usua_superLabelList.addElement("Não");
    }
    java.util.Vector list = usua_superList;
    return list;
  }
  java.util.Vector usua_superLabelList = new Vector(10, 1);
  public java.util.Vector getUsua_superLabelList() {
    java.util.Vector list = usua_superLabelList;
    return list;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    usua_usuario = null;
    usua_nome = null;
    tien_tipo = null;
    usua_super = null;
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
      if (usua_usuario != null && usua_usuario.length() > 0) {
        this.setUsua_usuario(usua_usuario.toUpperCase());
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 12/04/2006 12:00:31
 * Last Modify Date 28/10/2013 09:34:31
 */

public class EntidadeNegocioChaveActionForm extends org.apache.struts.action.ActionForm
{
  public String enne_tien_id;
  public String enne_chave;
  public String enne_id;
  public String enne_descricao;
  private boolean valida = false;
  public EntidadeNegocioChaveActionForm() {
  }
  /**
    * ENNE_TIEN_ID: Método Gets para este campo
    */
  public String getEnne_tien_id() {
    return enne_tien_id;
  }
  /**
    * ENNE_TIEN_ID: Método Sets pára este campo.
    */
  public void setEnne_tien_id(String PARAM) {
    enne_tien_id = PARAM;
  }
  private Vector enne_tien_idList = new Vector(10, 10);
  public void setEnne_tien_idList(java.util.Vector VECTOR) {
    enne_tien_idList = VECTOR;
  }
  public java.util.Vector getEnne_tien_idList() {
    enne_tien_idList = new Vector(10, 10);
    enne_tien_idLabelList = new Vector(10, 10);
    enne_tien_idList.addElement("");
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
    enne_tien_idLabelList.addElement(bundle.getString("jsp.pleaseselect"));
    //    enne_tien_idLabelList.addElement("Selecionar");
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      portalbr.dbobj.table.Tipos_entidade_negocio db_object = new portalbr.dbobj.table.Tipos_entidade_negocio();
      String[][] select = null;
      Object[][] where = null;
      String[] order = {"tien_tipo"};
      String[] groupby = null;
      String[] having = null;
      Vector results = j.select(db_object, select, where, groupby, having, order);
      for (int i = 0; i < results.size(); i++) {
        db_object = (portalbr.dbobj.table.Tipos_entidade_negocio) results.elementAt(i);
        enne_tien_idList.addElement(""+db_object.getTien_id());
        enne_tien_idLabelList.addElement(""+db_object.getTien_tipo());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "EntidadeNegocioChave.", e);
    } finally {
      if (j != null) {
        j.close();
      }
      j = null;
    }
    return enne_tien_idList;
  }
  private java.util.Vector enne_tien_idLabelList = new Vector(10, 10);
  public void setEnne_tien_idLabelList(java.util.Vector VECTOR) {
    enne_tien_idLabelList = VECTOR;
  }
  public java.util.Vector getEnne_tien_idLabelList() {
    return enne_tien_idLabelList;
  }
  /**
    * ENNE_CHAVE: Método Gets para este campo
    */
  public String getEnne_chave() {
    return enne_chave;
  }
  /**
    * ENNE_CHAVE: Método Sets pára este campo.
    */
  public void setEnne_chave(String PARAM) {
    enne_chave = PARAM;
  }
  /**
    * ENNE_ID: Método Gets para este campo
    */
  public String getEnne_id() {
    return enne_id;
  }
  /**
    * ENNE_ID: Método Sets pára este campo.
    */
  public void setEnne_id(String PARAM) {
    enne_id = PARAM;
  }
  /**
    * ENNE_DESCRICAO: Método Gets para este campo
    */
  public String getEnne_descricao() {
    return enne_descricao;
  }
  /**
    * ENNE_DESCRICAO: Método Sets pára este campo.
    */
  public void setEnne_descricao(String PARAM) {
    enne_descricao = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    enne_tien_id = null;
    enne_chave = null;
    enne_id = null;
    enne_descricao = null;
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
      if (com.egen.util.text.Validate.isNull(enne_tien_id)) {
        errors.add("enne_tien_id", new ActionMessage("error.validate.notnull","Tipo","enne_tien_id","0"));
      }
      if (com.egen.util.text.Validate.isNull(enne_chave)) {
        errors.add("enne_chave", new ActionMessage("error.validate.notnull","Chave","enne_chave","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

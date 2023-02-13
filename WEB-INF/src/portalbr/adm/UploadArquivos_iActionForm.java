package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 06/02/2014 13:53:43
 * Last Modify Date 26/02/2014 13:29:39
 */

import org.apache.struts.upload.FormFile;

public class UploadArquivos_iActionForm extends org.apache.struts.action.ActionForm
{
  public String lidi_tien_id;
  public String lidi_id;
  public String lidi_titulo;
  public String lidi_descricao;
  public String lidi_caminho;
  public String lidi_marca;
  public String lidi_tipo;
  public String arq;
  public FormFile arquivo;
  private boolean valida = false;
  public UploadArquivos_iActionForm() {
  }
  /**
    * LIDI_TIEN_ID: Method to get the field value.
    */
  public String getLidi_tien_id() {
    return lidi_tien_id;
  }
  /**
    * LIDI_TIEN_ID: Method to set the field value.
    */
  public void setLidi_tien_id(String PARAM) {
    lidi_tien_id = PARAM;
  }
  private Vector lidi_tien_idList = new Vector(10, 10);
  public void setLidi_tien_idList(java.util.Vector VECTOR) {
    lidi_tien_idList = VECTOR;
  }
  public java.util.Vector getLidi_tien_idList() {
    lidi_tien_idList = new Vector(10, 10);
    lidi_tien_idLabelList = new Vector(10, 10);
    lidi_tien_idList.addElement("");
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
    lidi_tien_idLabelList.addElement("Todos");
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Jw_tipos_usuarios db_object = new Jw_tipos_usuarios();
      String[][] select = {{"codigo", null},{"descricao", null}};
      Object[][] where = null;
      String[] order = {"tipo"};
      String[] groupby = null;
      String[] having = null;
      Vector results = j.select(db_object, select, where, groupby, having, order);
      for (int i = 0; i < results.size(); i++) {
        db_object = (Jw_tipos_usuarios) results.elementAt(i);
        lidi_tien_idList.addElement(""+db_object.getCodigo());
        lidi_tien_idLabelList.addElement(""+db_object.getDescricao());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "UploadArquivos_i.", e);
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return lidi_tien_idList;
  }
  private java.util.Vector lidi_tien_idLabelList = new Vector(10, 10);
  public void setLidi_tien_idLabelList(java.util.Vector VECTOR) {
    lidi_tien_idLabelList = VECTOR;
  }
  public java.util.Vector getLidi_tien_idLabelList() {
    return lidi_tien_idLabelList;
  }
  /**
    * LIDI_ID: Method to get the field value.
    */
  public String getLidi_id() {
    return lidi_id;
  }
  /**
    * LIDI_ID: Method to set the field value.
    */
  public void setLidi_id(String PARAM) {
    lidi_id = PARAM;
  }
  /**
    * LIDI_TITULO: Method to get the field value.
    */
  public String getLidi_titulo() {
    return lidi_titulo;
  }
  /**
    * LIDI_TITULO: Method to set the field value.
    */
  public void setLidi_titulo(String PARAM) {
    lidi_titulo = PARAM;
  }
  /**
    * LIDI_DESCRICAO: Method to get the field value.
    */
  public String getLidi_descricao() {
    return lidi_descricao;
  }
  /**
    * LIDI_DESCRICAO: Method to set the field value.
    */
  public void setLidi_descricao(String PARAM) {
    lidi_descricao = PARAM;
  }
  /**
    * LIDI_CAMINHO: Method to get the field value.
    */
  public String getLidi_caminho() {
    return lidi_caminho;
  }
  /**
    * LIDI_CAMINHO: Method to set the field value.
    */
  public void setLidi_caminho(String PARAM) {
    lidi_caminho = PARAM;
  }
  /**
    * LIDI_MARCA: Method to get the field value.
    */
  public String getLidi_marca() {
    return lidi_marca;
  }
  /**
    * LIDI_MARCA: Method to set the field value.
    */
  public void setLidi_marca(String PARAM) {
    lidi_marca = PARAM;
  }
  /**
    * LIDI_TIPO: Method to get the field value.
    */
  public String getLidi_tipo() {
    return lidi_tipo;
  }
  /**
    * LIDI_TIPO: Method to set the field value.
    */
  public void setLidi_tipo(String PARAM) {
    lidi_tipo = PARAM;
  }
  /**
    * ARQ: Method to get the field value.
    */
  public String getArq() {
    return arq;
  }
  /**
    * ARQ: Method to set the field value.
    */
  public void setArq(String PARAM) {
    arq = PARAM;
  }
  /**
    * ARQUIVO: Method to get the field value.
    */
  public FormFile getArquivo() {
    return arquivo;
  }
  /**
    * ARQUIVO: Method to set the field value.
    */
  public void setArquivo(FormFile PARAM) {
    arquivo = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    lidi_tien_id = null;
    lidi_id = null;
    lidi_titulo = null;
    lidi_descricao = null;
    lidi_caminho = null;
    lidi_marca = null;
    lidi_tipo = null;
    arq = null;
    arquivo = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,", request)) {
      if (com.egen.util.text.Validate.isNull(lidi_titulo)) {
        errors.add("lidi_titulo", new ActionMessage("error.validate.notnull","Título","lidi_titulo","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

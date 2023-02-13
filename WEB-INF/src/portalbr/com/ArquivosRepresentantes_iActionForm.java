package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 20/06/2006 14:20:14
 * Last Modify Date 06/11/2009 15:40:11
 */

import org.apache.struts.upload.FormFile;

public class ArquivosRepresentantes_iActionForm extends org.apache.struts.action.ActionForm
{
  public String lidi_id;
  public String lidi_marca;
  public String lidi_titulo;
  public String lidi_caminho;
  public String arq;
  public String lidi_tipo;
  public FormFile arquivo;
  private boolean valida = false;
  public ArquivosRepresentantes_iActionForm() {
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
  private Vector lidi_marcaList = new Vector(10, 10);
  public void setLidi_marcaList(java.util.Vector VECTOR) {
    lidi_marcaList = VECTOR;
  }
  public java.util.Vector getLidi_marcaList() {
    if (lidi_marcaList == null || lidi_marcaList.size() == 0) {
      lidi_marcaList = new Vector(10, 10);
      lidi_marcaLabelList = new Vector(10, 10);
      lidi_marcaList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      lidi_marcaLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_marcas db_object = new Jw_marcas();
        String[][] select = {{"codigo_marca", null},{"descricao_marca", null}};
        Object[][] where = null;
        String[] order = {"descricao_marca"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Jw_marcas) results.elementAt(i);
          lidi_marcaList.addElement(""+db_object.getCodigo_marca());
          lidi_marcaLabelList.addElement(""+db_object.getDescricao_marca());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "ArquivosRepresentantes_i.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return lidi_marcaList;
  }
  private java.util.Vector lidi_marcaLabelList = new Vector(10, 10);
  public void setLidi_marcaLabelList(java.util.Vector VECTOR) {
    lidi_marcaLabelList = VECTOR;
  }
  public java.util.Vector getLidi_marcaLabelList() {
    return lidi_marcaLabelList;
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
    lidi_id = null;
    lidi_marca = null;
    lidi_titulo = null;
    lidi_caminho = null;
    arq = null;
    lidi_tipo = null;
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
      if (com.egen.util.text.Validate.isNull(lidi_marca)) {
        errors.add("lidi_marca", new ActionMessage("error.validate.notnull","Marca","lidi_marca","0"));
      }
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

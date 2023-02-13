package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 20/06/2006 14:14:20
 * Last Modify Date 26/01/2011 06:11:14
 */

public class NormasVenda_mActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo_marca;
  public String lidi_tipo;
  public String lidi_id;
  public String lidi_titulo;
  public String lidi_descricao;
  private boolean valida = false;
  public NormasVenda_mActionForm() {
  }
  /**
    * CODIGO_MARCA: Method to get the field value.
    */
  public String getCodigo_marca() {
    return codigo_marca;
  }
  /**
    * CODIGO_MARCA: Method to set the field value.
    */
  public void setCodigo_marca(String PARAM) {
    codigo_marca = PARAM;
  }
  private Vector codigo_marcaList = new Vector(10, 10);
  public void setCodigo_marcaList(java.util.Vector VECTOR) {
    codigo_marcaList = VECTOR;
  }
  public java.util.Vector getCodigo_marcaList() {
    codigo_marcaList = new Vector(10, 10);
    codigo_marcaLabelList = new Vector(10, 10);
    codigo_marcaList.addElement("");
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
    codigo_marcaLabelList.addElement("Todas");
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
        codigo_marcaList.addElement(""+db_object.getCodigo_marca());
        codigo_marcaLabelList.addElement(""+db_object.getDescricao_marca());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "NormasVenda_m.", e);
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return codigo_marcaList;
  }
  private java.util.Vector codigo_marcaLabelList = new Vector(10, 10);
  public void setCodigo_marcaLabelList(java.util.Vector VECTOR) {
    codigo_marcaLabelList = VECTOR;
  }
  public java.util.Vector getCodigo_marcaLabelList() {
    return codigo_marcaLabelList;
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
  Vector lidi_tipoList = new Vector(10, 1);
  public java.util.Vector getLidi_tipoList() {
    if (lidi_tipoList == null || lidi_tipoList.size() == 0) {
      lidi_tipoList.addElement("");
      lidi_tipoLabelList.addElement("Todos");
      lidi_tipoList.addElement("N");
      lidi_tipoLabelList.addElement("Normal");
      lidi_tipoList.addElement("C");
      lidi_tipoLabelList.addElement("Clientes");
    }
    java.util.Vector list = lidi_tipoList;
    return list;
  }
  java.util.Vector lidi_tipoLabelList = new Vector(10, 1);
  public java.util.Vector getLidi_tipoLabelList() {
    java.util.Vector list = lidi_tipoLabelList;
    return list;
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
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo_marca = null;
    lidi_tipo = null;
    lidi_id = null;
    lidi_titulo = null;
    lidi_descricao = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,insert_action,", request)) {
      if (!com.egen.util.text.Validate.isNumber(codigo_marca)) {
        errors.add("codigo_marca", new ActionMessage("error.validate.number","Marca","codigo_marca","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

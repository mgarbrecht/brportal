package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 27/10/2011 14:09:40
 * Last Modify Date 02/04/2013 17:26:22
 */

import org.apache.struts.upload.FormFile;

public class MaterialMidiaAFVActionForm extends org.apache.struts.action.ActionForm
{
  public String codmarketing;
  public String codtipomarketing;
  public String marca;
  public String titulo;
  public String descricao;
  public String tipo_arquivo;
  public FormFile arquivo;
  private boolean valida = false;
  public MaterialMidiaAFVActionForm() {
  }
  /**
    * CODMARKETING: Method to get the field value.
    */
  public String getCodmarketing() {
    return codmarketing;
  }
  /**
    * CODMARKETING: Method to set the field value.
    */
  public void setCodmarketing(String PARAM) {
    codmarketing = PARAM;
  }
  /**
    * CODTIPOMARKETING: Method to get the field value.
    */
  public String getCodtipomarketing() {
    return codtipomarketing;
  }
  /**
    * CODTIPOMARKETING: Method to set the field value.
    */
  public void setCodtipomarketing(String PARAM) {
    codtipomarketing = PARAM;
  }
  Vector codtipomarketingList = new Vector(10, 1);
  public java.util.Vector getCodtipomarketingList() {
    if (codtipomarketingList == null || codtipomarketingList.size() == 0) {
      codtipomarketingList.addElement("1");
      codtipomarketingLabelList.addElement("Institucional");
      codtipomarketingList.addElement("2");
      codtipomarketingLabelList.addElement("Midia");
      codtipomarketingList.addElement("3");
      codtipomarketingLabelList.addElement("Materiais PDV");
      codtipomarketingList.addElement("4");
      codtipomarketingLabelList.addElement("Editoriais de Moda");
    }
    java.util.Vector list = codtipomarketingList;
    return list;
  }
  java.util.Vector codtipomarketingLabelList = new Vector(10, 1);
  public java.util.Vector getCodtipomarketingLabelList() {
    java.util.Vector list = codtipomarketingLabelList;
    return list;
  }
  /**
    * MARCA: Method to get the field value.
    */
  public String getMarca() {
    return marca;
  }
  /**
    * MARCA: Method to set the field value.
    */
  public void setMarca(String PARAM) {
    marca = PARAM;
  }
  private Vector marcaList = new Vector(10, 10);
  public void setMarcaList(java.util.Vector VECTOR) {
    marcaList = VECTOR;
  }
  public java.util.Vector getMarcaList() {
    marcaList = new Vector(10, 10);
    marcaLabelList = new Vector(10, 10);
    marcaList.addElement("");
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
    marcaLabelList.addElement(bundle.getString("jsp.pleaseselect"));
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
        marcaList.addElement(""+db_object.getCodigo_marca());
        marcaLabelList.addElement(""+db_object.getDescricao_marca());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "MaterialMidiaAFV.", e);
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return marcaList;
  }
  private java.util.Vector marcaLabelList = new Vector(10, 10);
  public void setMarcaLabelList(java.util.Vector VECTOR) {
    marcaLabelList = VECTOR;
  }
  public java.util.Vector getMarcaLabelList() {
    return marcaLabelList;
  }
  /**
    * TITULO: Method to get the field value.
    */
  public String getTitulo() {
    return titulo;
  }
  /**
    * TITULO: Method to set the field value.
    */
  public void setTitulo(String PARAM) {
    titulo = PARAM;
  }
  /**
    * DESCRICAO: Method to get the field value.
    */
  public String getDescricao() {
    return descricao;
  }
  /**
    * DESCRICAO: Method to set the field value.
    */
  public void setDescricao(String PARAM) {
    descricao = PARAM;
  }
  /**
    * TIPO_ARQUIVO: Method to get the field value.
    */
  public String getTipo_arquivo() {
    return tipo_arquivo;
  }
  /**
    * TIPO_ARQUIVO: Method to set the field value.
    */
  public void setTipo_arquivo(String PARAM) {
    tipo_arquivo = PARAM;
  }
  Vector tipo_arquivoList = new Vector(10, 1);
  public java.util.Vector getTipo_arquivoList() {
    if (tipo_arquivoList == null || tipo_arquivoList.size() == 0) {
      tipo_arquivoList.addElement("I");
      tipo_arquivoLabelList.addElement("Arquivos Ícones");
      tipo_arquivoList.addElement("G");
      tipo_arquivoLabelList.addElement("Arquivos Grandes");
    }
    java.util.Vector list = tipo_arquivoList;
    return list;
  }
  java.util.Vector tipo_arquivoLabelList = new Vector(10, 1);
  public java.util.Vector getTipo_arquivoLabelList() {
    java.util.Vector list = tipo_arquivoLabelList;
    return list;
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
    codmarketing = null;
    codtipomarketing = null;
    marca = null;
    titulo = null;
    descricao = null;
    tipo_arquivo = null;
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
    if (!com.egen.util.struts.Token.isTokenValid(mapping, request)) {
      errors.add("Warning", new ActionMessage("token.error","<br>","","",""));
    }
    com.egen.util.struts.Token.saveToken(mapping, request);

    if (com.egen.util.text.Validate.isValidate("blank_action,", request)) {
      if (com.egen.util.text.Validate.isNull(codmarketing)) {
        errors.add("codmarketing", new ActionMessage("error.validate.notnull","CODMARKETING","codmarketing","0"));
      }
      if (com.egen.util.text.Validate.isNull(codtipomarketing)) {
        errors.add("codtipomarketing", new ActionMessage("error.validate.notnull","Tipo","codtipomarketing","0"));
      }
      if (com.egen.util.text.Validate.isNull(marca)) {
        errors.add("marca", new ActionMessage("error.validate.notnull","Marca","marca","0"));
      }
      if (com.egen.util.text.Validate.isNull(titulo)) {
        errors.add("titulo", new ActionMessage("error.validate.notnull","Título","titulo","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 14/04/2010 15:56:08
 * Last Modify Date 22/06/2015 13:19:57
 */

public class ClientesMidiasActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo_marca;
  public String codigo_regional;
  public String abre_automaticamente;
  public String mensagem;
  private boolean valida = false;
  public ClientesMidiasActionForm() {
  }
  /**
    * CODIGO_MARCA: Método Gets para este campo
    */
  public String getCodigo_marca() {
    return codigo_marca;
  }
  /**
    * CODIGO_MARCA: Método Sets pára este campo.
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
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "ClientesMidias.", e);
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
    * CODIGO_REGIONAL: Método Gets para este campo
    */
  public String getCodigo_regional() {
    return codigo_regional;
  }
  /**
    * CODIGO_REGIONAL: Método Sets pára este campo.
    */
  public void setCodigo_regional(String PARAM) {
    codigo_regional = PARAM;
  }
  private Vector codigo_regionalList = new Vector(10, 10);
  public void setCodigo_regionalList(java.util.Vector VECTOR) {
    codigo_regionalList = VECTOR;
  }
  public java.util.Vector getCodigo_regionalList() {
    codigo_regionalList = new Vector(10, 10);
    codigo_regionalLabelList = new Vector(10, 10);
    codigo_regionalList.addElement("");
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
    codigo_regionalLabelList.addElement("Todas");
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Regionais_vendas db_object = new Regionais_vendas();
      String[][] select = {{"codigo_regional", null},{"nome_regional", null}};
      Object[][] where = null;
      String[] order = {"nome_regional"};
      String[] groupby = null;
      String[] having = null;
      Vector results = j.select(db_object, select, where, groupby, having, order);
      for (int i = 0; i < results.size(); i++) {
        db_object = (Regionais_vendas) results.elementAt(i);
        codigo_regionalList.addElement(""+db_object.getCodigo_regional());
        codigo_regionalLabelList.addElement(""+db_object.getNome_regional());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "ClientesMidias.", e);
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return codigo_regionalList;
  }
  private java.util.Vector codigo_regionalLabelList = new Vector(10, 10);
  public void setCodigo_regionalLabelList(java.util.Vector VECTOR) {
    codigo_regionalLabelList = VECTOR;
  }
  public java.util.Vector getCodigo_regionalLabelList() {
    return codigo_regionalLabelList;
  }
  /**
    * ABRE_AUTOMATICAMENTE: Método Gets para este campo
    */
  public String getAbre_automaticamente() {
    return abre_automaticamente;
  }
  /**
    * ABRE_AUTOMATICAMENTE: Método Sets pára este campo.
    */
  public void setAbre_automaticamente(String PARAM) {
    abre_automaticamente = PARAM;
  }
  /**
    * MENSAGEM: Método Gets para este campo
    */
  public String getMensagem() {
    return mensagem;
  }
  /**
    * MENSAGEM: Método Sets pára este campo.
    */
  public void setMensagem(String PARAM) {
    mensagem = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo_marca = null;
    codigo_regional = null;
    abre_automaticamente = null;
    mensagem = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
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

    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 10/08/2006 15:11:28
 * Last Modify Date 19/01/2015 09:44:39
 */

public class ClientesSemRepresentanteActionForm extends org.apache.struts.action.ActionForm
{
  public String est_descri;
  public String cli_rzao;
  public String estado;
  public String tipo;
  public String abre_automaticamente;
  public String mensagem;
  private boolean valida = false;
  public ClientesSemRepresentanteActionForm() {
  }
  /**
    * EST_DESCRI: Método Gets para este campo
    */
  public String getEst_descri() {
    return est_descri;
  }
  /**
    * EST_DESCRI: Método Sets pára este campo.
    */
  public void setEst_descri(String PARAM) {
    est_descri = PARAM;
  }
  private Vector est_descriList = new Vector(10, 10);
  public void setEst_descriList(java.util.Vector VECTOR) {
    est_descriList = VECTOR;
  }
  public java.util.Vector getEst_descriList() {
    est_descriList = new Vector(10, 10);
    est_descriLabelList = new Vector(10, 10);
    est_descriList.addElement("");
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
    est_descriLabelList.addElement(bundle.getString("jsp.pleaseselect"));
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      portalbr.dbobj.table.Estados db_object = new portalbr.dbobj.table.Estados();
      String[][] select = null;
      Object[][] where = null;
      String[] order = {"est_descri"};
      String[] groupby = null;
      String[] having = null;
      Vector results = j.select(db_object, select, where, groupby, having, order);
      for (int i = 0; i < results.size(); i++) {
        db_object = (portalbr.dbobj.table.Estados) results.elementAt(i);
        est_descriList.addElement(""+db_object.getEst_unifed());
        est_descriLabelList.addElement(""+db_object.getEst_unifed() + " - "+db_object.getEst_descri());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "ClientesSemRepresentante.", e);
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return est_descriList;
  }
  private java.util.Vector est_descriLabelList = new Vector(10, 10);
  public void setEst_descriLabelList(java.util.Vector VECTOR) {
    est_descriLabelList = VECTOR;
  }
  public java.util.Vector getEst_descriLabelList() {
    return est_descriLabelList;
  }
  /**
    * CLI_RZAO: Método Gets para este campo
    */
  public String getCli_rzao() {
    return cli_rzao;
  }
  /**
    * CLI_RZAO: Método Sets pára este campo.
    */
  public void setCli_rzao(String PARAM) {
    cli_rzao = PARAM;
  }
  /**
    * ESTADO: Método Gets para este campo
    */
  public String getEstado() {
    return estado;
  }
  /**
    * ESTADO: Método Sets pára este campo.
    */
  public void setEstado(String PARAM) {
    estado = PARAM;
  }
  /**
    * TIPO: Método Gets para este campo
    */
  public String getTipo() {
    return tipo;
  }
  /**
    * TIPO: Método Sets pára este campo.
    */
  public void setTipo(String PARAM) {
    tipo = PARAM;
  }
  Vector tipoList = new Vector(10, 1);
  public java.util.Vector getTipoList() {
    if (tipoList == null || tipoList.size() == 0) {
      tipoList.addElement("html");
      tipoLabelList.addElement("HTML");
      tipoList.addElement("pdf");
      tipoLabelList.addElement("PDF");
    }
    java.util.Vector list = tipoList;
    return list;
  }
  java.util.Vector tipoLabelList = new Vector(10, 1);
  public java.util.Vector getTipoLabelList() {
    java.util.Vector list = tipoLabelList;
    return list;
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
    est_descri = null;
    cli_rzao = null;
    estado = null;
    tipo = null;
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
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

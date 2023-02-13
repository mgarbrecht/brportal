package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 09/03/2011 15:57:48
 * Last Modify Date 22/06/2015 15:34:10
 */

public class SolicitacaoMailingActionForm extends org.apache.struts.action.ActionForm
{
  public String id_solicitacao;
  public String data_envio;
  public String data_envio_final;
  public String situacao;
  public String observacoes;
  public String assunto;
  private boolean valida = false;
  public SolicitacaoMailingActionForm() {
  }
  /**
    * ID_SOLICITACAO: Method to get the field value.
    */
  public String getId_solicitacao() {
    return id_solicitacao;
  }
  /**
    * ID_SOLICITACAO: Method to set the field value.
    */
  public void setId_solicitacao(String PARAM) {
    id_solicitacao = PARAM;
  }
  /**
    * DATA_ENVIO: Method to get the field value.
    */
  public String getData_envio() {
    return data_envio;
  }
  /**
    * DATA_ENVIO: Method to set the field value.
    */
  public void setData_envio(String PARAM) {
    data_envio = PARAM;
  }
  /**
    * DATA_ENVIO_FINAL: Method to get the field value.
    */
  public String getData_envio_final() {
    return data_envio_final;
  }
  /**
    * DATA_ENVIO_FINAL: Method to set the field value.
    */
  public void setData_envio_final(String PARAM) {
    data_envio_final = PARAM;
  }
  /**
    * SITUACAO: Method to get the field value.
    */
  public String getSituacao() {
    return situacao;
  }
  /**
    * SITUACAO: Method to set the field value.
    */
  public void setSituacao(String PARAM) {
    situacao = PARAM;
  }
  private Vector situacaoList = new Vector(10, 10);
  public void setSituacaoList(java.util.Vector VECTOR) {
    situacaoList = VECTOR;
  }
  public java.util.Vector getSituacaoList() {
    situacaoList = new Vector(10, 10);
    situacaoLabelList = new Vector(10, 10);
    situacaoList.addElement("");
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
    situacaoLabelList.addElement(bundle.getString("jsp.pleaseselect"));
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Cg_ref_codes db_object = new Cg_ref_codes();
      String[][] select = {{"rv_low_value", null},{"rv_abbreviation", null}};
      Object[][] where = {{"RV_DOMAIN","=","STATUS_MAILING_MARKETING"}};
      String[] order = {"rv_abbreviation"};
      String[] groupby = null;
      String[] having = null;
      Vector results = j.select(db_object, select, where, groupby, having, order);
      for (int i = 0; i < results.size(); i++) {
        db_object = (Cg_ref_codes) results.elementAt(i);
        situacaoList.addElement(""+db_object.getRv_low_value());
        situacaoLabelList.addElement(""+db_object.getRv_abbreviation());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "SolicitacaoMailing.", e);
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return situacaoList;
  }
  private java.util.Vector situacaoLabelList = new Vector(10, 10);
  public void setSituacaoLabelList(java.util.Vector VECTOR) {
    situacaoLabelList = VECTOR;
  }
  public java.util.Vector getSituacaoLabelList() {
    return situacaoLabelList;
  }
  /**
    * OBSERVACOES: Method to get the field value.
    */
  public String getObservacoes() {
    return observacoes;
  }
  /**
    * OBSERVACOES: Method to set the field value.
    */
  public void setObservacoes(String PARAM) {
    observacoes = PARAM;
  }
  /**
    * ASSUNTO: Method to get the field value.
    */
  public String getAssunto() {
    return assunto;
  }
  /**
    * ASSUNTO: Method to set the field value.
    */
  public void setAssunto(String PARAM) {
    assunto = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    id_solicitacao = null;
    data_envio = null;
    data_envio_final = null;
    situacao = null;
    observacoes = null;
    assunto = null;
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
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

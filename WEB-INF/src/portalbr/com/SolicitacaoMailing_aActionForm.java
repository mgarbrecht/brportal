package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 11/03/2011 11:24:29
 * Last Modify Date 03/04/2013 13:05:44
 */

import org.apache.struts.upload.FormFile;

public class SolicitacaoMailing_aActionForm extends org.apache.struts.action.ActionForm
{
  public String id_solicitacao;
  public String data_envio;
  public String assunto;
  public String email_retorno;
  public String nome_arquivo;
  public FormFile arquivo;
  public String situacao;
  public String situacao_desc;
  public String observacoes;
  public String listas_selecionadas;
  private boolean valida = false;
  public SolicitacaoMailing_aActionForm() {
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
    * EMAIL_RETORNO: Method to get the field value.
    */
  public String getEmail_retorno() {
    return email_retorno;
  }
  /**
    * EMAIL_RETORNO: Method to set the field value.
    */
  public void setEmail_retorno(String PARAM) {
    email_retorno = PARAM;
  }
  /**
    * NOME_ARQUIVO: Method to get the field value.
    */
  public String getNome_arquivo() {
    return nome_arquivo;
  }
  /**
    * NOME_ARQUIVO: Method to set the field value.
    */
  public void setNome_arquivo(String PARAM) {
    nome_arquivo = PARAM;
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
  /**
    * SITUACAO_DESC: Method to get the field value.
    */
  public String getSituacao_desc() {
    return situacao_desc;
  }
  /**
    * SITUACAO_DESC: Method to set the field value.
    */
  public void setSituacao_desc(String PARAM) {
    situacao_desc = PARAM;
  }
  private Vector situacao_descList = new Vector(10, 10);
  public void setSituacao_descList(java.util.Vector VECTOR) {
    situacao_descList = VECTOR;
  }
  public java.util.Vector getSituacao_descList() {
    if (situacao_descList == null || situacao_descList.size() == 0) {
      situacao_descList = new Vector(10, 10);
      situacao_descLabelList = new Vector(10, 10);
      situacao_descList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      situacao_descLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cg_ref_codes db_object = new Cg_ref_codes();
        String[][] select = {{"rv_low_value", null},{"rv_abbreviation", null}};
        Object[][] where = {{"RV_DOMAIN","=", "STATUS_MAILING_MARKETING"}};
        String[] order = {"rv_abbreviation"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Cg_ref_codes) results.elementAt(i);
          situacao_descList.addElement(""+db_object.getRv_low_value());
          situacao_descLabelList.addElement(""+db_object.getRv_abbreviation());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "SolicitacaoMailing_a.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return situacao_descList;
  }
  private java.util.Vector situacao_descLabelList = new Vector(10, 10);
  public void setSituacao_descLabelList(java.util.Vector VECTOR) {
    situacao_descLabelList = VECTOR;
  }
  public java.util.Vector getSituacao_descLabelList() {
    return situacao_descLabelList;
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
    * LISTAS_SELECIONADAS: Method to get the field value.
    */
  public String getListas_selecionadas() {
    return listas_selecionadas;
  }
  /**
    * LISTAS_SELECIONADAS: Method to set the field value.
    */
  public void setListas_selecionadas(String PARAM) {
    listas_selecionadas = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    id_solicitacao = null;
    data_envio = null;
    assunto = null;
    email_retorno = null;
    nome_arquivo = null;
    arquivo = null;
    situacao = null;
    situacao_desc = null;
    observacoes = null;
    listas_selecionadas = null;
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

    if (com.egen.util.text.Validate.isValidate("update_action,delete_action,", request)) {
      if (com.egen.util.text.Validate.isNull(id_solicitacao)) {
        errors.add("id_solicitacao", new ActionMessage("error.validate.notnull","Solicitação","id_solicitacao","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(id_solicitacao)) {
        errors.add("id_solicitacao", new ActionMessage("error.validate.number","Solicitação","id_solicitacao","0"));
      }
      if (com.egen.util.text.Validate.isNull(data_envio)) {
        errors.add("data_envio", new ActionMessage("error.validate.notnull","Data Envio","data_envio","0"));
      }
      if (!com.egen.util.text.Validate.isDate(data_envio)) {
        errors.add("data_envio", new ActionMessage("error.validate.date","Data Envio","data_envio","0"));
      }
      if (com.egen.util.text.Validate.isNull(assunto)) {
        errors.add("assunto", new ActionMessage("error.validate.notnull","Assunto","assunto","0"));
      }
      if (com.egen.util.text.Validate.isNull(email_retorno)) {
        errors.add("email_retorno", new ActionMessage("error.validate.notnull","Email Retorno","email_retorno","0"));
      }
      if (com.egen.util.text.Validate.isNull(situacao)) {
        errors.add("situacao", new ActionMessage("error.validate.notnull","Situação","situacao","0"));
      }
      if (com.egen.util.text.Validate.isNull(listas_selecionadas)) {
        errors.add("listas_selecionadas", new ActionMessage("error.validate.notnull","Listas","listas_selecionadas","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

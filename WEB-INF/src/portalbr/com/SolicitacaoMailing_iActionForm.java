package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 11/03/2011 10:17:19
 * Last Modify Date 14/03/2011 12:51:16
 */

import org.apache.struts.upload.FormFile;

public class SolicitacaoMailing_iActionForm extends org.apache.struts.action.ActionForm
{
  public String id_solicitacao;
  public String data_envio;
  public String assunto;
  public String situacao;
  public String email_retorno;
  public FormFile nome_arquivo;
  public String observacoes;
  public String listas_selecionadas;
  private boolean valida = false;
  public SolicitacaoMailing_iActionForm() {
  }
  /**
    * ID_SOLICITACAO: Método Gets para este campo
    */
  public String getId_solicitacao() {
    return id_solicitacao;
  }
  /**
    * ID_SOLICITACAO: Método Sets pára este campo.
    */
  public void setId_solicitacao(String PARAM) {
    id_solicitacao = PARAM;
  }
  /**
    * DATA_ENVIO: Método Gets para este campo
    */
  public String getData_envio() {
    return data_envio;
  }
  /**
    * DATA_ENVIO: Método Sets pára este campo.
    */
  public void setData_envio(String PARAM) {
    data_envio = PARAM;
  }
  /**
    * ASSUNTO: Método Gets para este campo
    */
  public String getAssunto() {
    return assunto;
  }
  /**
    * ASSUNTO: Método Sets pára este campo.
    */
  public void setAssunto(String PARAM) {
    assunto = PARAM;
  }
  /**
    * SITUACAO: Método Gets para este campo
    */
  public String getSituacao() {
    return situacao;
  }
  /**
    * SITUACAO: Método Sets pára este campo.
    */
  public void setSituacao(String PARAM) {
    situacao = PARAM;
  }
  /**
    * EMAIL_RETORNO: Método Gets para este campo
    */
  public String getEmail_retorno() {
    return email_retorno;
  }
  /**
    * EMAIL_RETORNO: Método Sets pára este campo.
    */
  public void setEmail_retorno(String PARAM) {
    email_retorno = PARAM;
  }
  /**
    * NOME_ARQUIVO: Método Gets para este campo
    */
  public FormFile getNome_arquivo() {
    return nome_arquivo;
  }
  /**
    * NOME_ARQUIVO: Método Sets pára este campo.
    */
  public void setNome_arquivo(FormFile PARAM) {
    nome_arquivo = PARAM;
  }
  /**
    * OBSERVACOES: Método Gets para este campo
    */
  public String getObservacoes() {
    return observacoes;
  }
  /**
    * OBSERVACOES: Método Sets pára este campo.
    */
  public void setObservacoes(String PARAM) {
    observacoes = PARAM;
  }
  /**
    * LISTAS_SELECIONADAS: Método Gets para este campo
    */
  public String getListas_selecionadas() {
    return listas_selecionadas;
  }
  /**
    * LISTAS_SELECIONADAS: Método Sets pára este campo.
    */
  public void setListas_selecionadas(String PARAM) {
    listas_selecionadas = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    id_solicitacao = null;
    data_envio = null;
    assunto = null;
    situacao = null;
    email_retorno = null;
    nome_arquivo = null;
    observacoes = null;
    listas_selecionadas = null;
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
      if (com.egen.util.text.Validate.isNull(data_envio)) {
        errors.add("data_envio", new ActionMessage("error.validate.notnull","Data Envio","data_envio","0"));
      }
      if (!com.egen.util.text.Validate.isDate(data_envio)) {
        errors.add("data_envio", new ActionMessage("error.validate.date","Data Envio","data_envio","0"));
      }
      if (com.egen.util.text.Validate.isNull(assunto)) {
        errors.add("assunto", new ActionMessage("error.validate.notnull","Assunto","assunto","0"));
      }
      if (com.egen.util.text.Validate.isNull(listas_selecionadas)) {
        errors.add("listas_selecionadas", new ActionMessage("error.validate.notnull","Listas","listas_selecionadas","0"));
      }
      if (com.egen.util.text.Validate.isNull(email_retorno)) {
        errors.add("email_retorno", new ActionMessage("error.validate.notnull","Email Retorno","email_retorno","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(email_retorno, "^[A-Za-z0-9_\\-\\.]+@([A-Za-z0-9_\\-]+.){1,3}[a-zA-Z]{2,3}$")) {
        errors.add("email_retorno", new ActionMessage("error.validate.regex","Email Retorno","email_retorno","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

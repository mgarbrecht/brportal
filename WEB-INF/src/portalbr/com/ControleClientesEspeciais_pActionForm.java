package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 20/02/2017 16:53:50
 * Last Modify Date 19/01/2022 16:25:24
 */

public class ControleClientesEspeciais_pActionForm extends org.apache.struts.action.ActionForm
{
  public String tipo;
  public String dt_agendamento;
  public String etiqueta;
  public String observacao;
  public String semana_agendamento;
  public String hora;
  public String senha;
  public String certificado_origem;
  public String dt_inspecao;
  public String dt_solicitacao_alarme;
  public String filial_faturamento;
  public String modelo_alarme;
  private boolean valida = false;
  public ControleClientesEspeciais_pActionForm() {
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
  /**
    * DT_AGENDAMENTO: Método Gets para este campo
    */
  public String getDt_agendamento() {
    return dt_agendamento;
  }
  /**
    * DT_AGENDAMENTO: Método Sets pára este campo.
    */
  public void setDt_agendamento(String PARAM) {
    dt_agendamento = PARAM;
  }
  /**
    * ETIQUETA: Método Gets para este campo
    */
  public String getEtiqueta() {
    return etiqueta;
  }
  /**
    * ETIQUETA: Método Sets pára este campo.
    */
  public void setEtiqueta(String PARAM) {
    etiqueta = PARAM;
  }
  /**
    * OBSERVACAO: Método Gets para este campo
    */
  public String getObservacao() {
    return observacao;
  }
  /**
    * OBSERVACAO: Método Sets pára este campo.
    */
  public void setObservacao(String PARAM) {
    observacao = PARAM;
  }
  /**
    * SEMANA_AGENDAMENTO: Método Gets para este campo
    */
  public String getSemana_agendamento() {
    return semana_agendamento;
  }
  /**
    * SEMANA_AGENDAMENTO: Método Sets pára este campo.
    */
  public void setSemana_agendamento(String PARAM) {
    semana_agendamento = PARAM;
  }
  /**
    * HORA: Método Gets para este campo
    */
  public String getHora() {
    return hora;
  }
  /**
    * HORA: Método Sets pára este campo.
    */
  public void setHora(String PARAM) {
    hora = PARAM;
  }
  /**
    * SENHA: Método Gets para este campo
    */
  public String getSenha() {
    return senha;
  }
  /**
    * SENHA: Método Sets pára este campo.
    */
  public void setSenha(String PARAM) {
    senha = PARAM;
  }
  /**
    * CERTIFICADO_ORIGEM: Método Gets para este campo
    */
  public String getCertificado_origem() {
    return certificado_origem;
  }
  /**
    * CERTIFICADO_ORIGEM: Método Sets pára este campo.
    */
  public void setCertificado_origem(String PARAM) {
    certificado_origem = PARAM;
  }
  /**
    * DT_INSPECAO: Método Gets para este campo
    */
  public String getDt_inspecao() {
    return dt_inspecao;
  }
  /**
    * DT_INSPECAO: Método Sets pára este campo.
    */
  public void setDt_inspecao(String PARAM) {
    dt_inspecao = PARAM;
  }
  /**
    * DT_SOLICITACAO_ALARME: Método Gets para este campo
    */
  public String getDt_solicitacao_alarme() {
    return dt_solicitacao_alarme;
  }
  /**
    * DT_SOLICITACAO_ALARME: Método Sets pára este campo.
    */
  public void setDt_solicitacao_alarme(String PARAM) {
    dt_solicitacao_alarme = PARAM;
  }
  /**
    * FILIAL_FATURAMENTO: Método Gets para este campo
    */
  public String getFilial_faturamento() {
    return filial_faturamento;
  }
  /**
    * FILIAL_FATURAMENTO: Método Sets pára este campo.
    */
  public void setFilial_faturamento(String PARAM) {
    filial_faturamento = PARAM;
  }
  /**
    * MODELO_ALARME: Método Gets para este campo
    */
  public String getModelo_alarme() {
    return modelo_alarme;
  }
  /**
    * MODELO_ALARME: Método Sets pára este campo.
    */
  public void setModelo_alarme(String PARAM) {
    modelo_alarme = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    tipo = null;
    dt_agendamento = null;
    etiqueta = null;
    observacao = null;
    semana_agendamento = null;
    hora = null;
    senha = null;
    certificado_origem = null;
    dt_inspecao = null;
    dt_solicitacao_alarme = null;
    filial_faturamento = null;
    modelo_alarme = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("update_action,", request)) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

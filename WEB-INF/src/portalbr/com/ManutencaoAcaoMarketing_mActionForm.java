package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 24/11/2010 06:26:08
 * Last Modify Date 02/04/2013 15:24:37
 */

public class ManutencaoAcaoMarketing_mActionForm extends org.apache.struts.action.ActionForm
{
  public String acao_inicial;
  public String acao_final;
  public String acoes;
  public boolean gridCheckField;
  public String data_entrega;
  public String data_entrada;
  public String nome_regional;
  public String acao;
  public String situacao;
  public String observacao;
  public String desc_material;
  public String email;
  public String descricao_marca;
  public String cracha_usuario;
  private boolean valida = false;
  public ManutencaoAcaoMarketing_mActionForm() {
  }
  /**
    * ACAO_INICIAL: Method to get the field value.
    */
  public String getAcao_inicial() {
    return acao_inicial;
  }
  /**
    * ACAO_INICIAL: Method to set the field value.
    */
  public void setAcao_inicial(String PARAM) {
    acao_inicial = PARAM;
  }
  /**
    * ACAO_FINAL: Method to get the field value.
    */
  public String getAcao_final() {
    return acao_final;
  }
  /**
    * ACAO_FINAL: Method to set the field value.
    */
  public void setAcao_final(String PARAM) {
    acao_final = PARAM;
  }
  /**
    * ACOES: Method to get the field value.
    */
  public String getAcoes() {
    return acoes;
  }
  /**
    * ACOES: Method to set the field value.
    */
  public void setAcoes(String PARAM) {
    acoes = PARAM;
  }
  /**
    * GRIDCHECKFIELD: Method to get the field value.
    */
  public boolean getGridCheckField() {
    return gridCheckField;
  }
  /**
    * GRIDCHECKFIELD: Method to set the field value.
    */
  public void setGridCheckField(boolean PARAM) {
    gridCheckField = PARAM;
  }
  /**
    * DATA_ENTREGA: Method to get the field value.
    */
  public String getData_entrega() {
    return data_entrega;
  }
  /**
    * DATA_ENTREGA: Method to set the field value.
    */
  public void setData_entrega(String PARAM) {
    data_entrega = PARAM;
  }
  /**
    * DATA_ENTRADA: Method to get the field value.
    */
  public String getData_entrada() {
    return data_entrada;
  }
  /**
    * DATA_ENTRADA: Method to set the field value.
    */
  public void setData_entrada(String PARAM) {
    data_entrada = PARAM;
  }
  /**
    * NOME_REGIONAL: Method to get the field value.
    */
  public String getNome_regional() {
    return nome_regional;
  }
  /**
    * NOME_REGIONAL: Method to set the field value.
    */
  public void setNome_regional(String PARAM) {
    nome_regional = PARAM;
  }
  /**
    * ACAO: Method to get the field value.
    */
  public String getAcao() {
    return acao;
  }
  /**
    * ACAO: Method to set the field value.
    */
  public void setAcao(String PARAM) {
    acao = PARAM;
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
    * OBSERVACAO: Method to get the field value.
    */
  public String getObservacao() {
    return observacao;
  }
  /**
    * OBSERVACAO: Method to set the field value.
    */
  public void setObservacao(String PARAM) {
    observacao = PARAM;
  }
  /**
    * DESC_MATERIAL: Method to get the field value.
    */
  public String getDesc_material() {
    return desc_material;
  }
  /**
    * DESC_MATERIAL: Method to set the field value.
    */
  public void setDesc_material(String PARAM) {
    desc_material = PARAM;
  }
  /**
    * EMAIL: Method to get the field value.
    */
  public String getEmail() {
    return email;
  }
  /**
    * EMAIL: Method to set the field value.
    */
  public void setEmail(String PARAM) {
    email = PARAM;
  }
  /**
    * DESCRICAO_MARCA: Method to get the field value.
    */
  public String getDescricao_marca() {
    return descricao_marca;
  }
  /**
    * DESCRICAO_MARCA: Method to set the field value.
    */
  public void setDescricao_marca(String PARAM) {
    descricao_marca = PARAM;
  }
  /**
    * CRACHA_USUARIO: Method to get the field value.
    */
  public String getCracha_usuario() {
    return cracha_usuario;
  }
  /**
    * CRACHA_USUARIO: Method to set the field value.
    */
  public void setCracha_usuario(String PARAM) {
    cracha_usuario = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    acao_inicial = null;
    acao_final = null;
    acoes = null;
    gridCheckField = false;
    data_entrega = null;
    data_entrada = null;
    nome_regional = null;
    acao = null;
    situacao = null;
    observacao = null;
    desc_material = null;
    email = null;
    descricao_marca = null;
    cracha_usuario = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (getGridCheckField()) {
      if (com.egen.util.text.Validate.isValidate("desmarcar_action,update_action,", request)) {
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

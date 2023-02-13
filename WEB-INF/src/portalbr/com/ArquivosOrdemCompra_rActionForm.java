package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 19/08/2015 15:48:36
 * Last Modify Date 18/07/2022 16:24:37
 */

public class ArquivosOrdemCompra_rActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String forn_codigo;
  public String interface_arq_compra_id;
  public String oco_numero;
  public String fil_filial;
  public String data_emissao;
  public String cond_pagto;
  public String arquivo_edi;
  public String descricao_situacao;
  public String data_entrega;
  public String forn_razsoc;
  public String amostra;
  public String data_entrega_fornecedor;
  public String situacao_ordem_compra;
  public String alterado;
  private boolean valida = false;
  public ArquivosOrdemCompra_rActionForm() {
  }
  /**
    * GRIDCHECKFIELD: Método Gets para este campo
    */
  public boolean getGridCheckField() {
    return gridCheckField;
  }
  /**
    * GRIDCHECKFIELD: Método Sets pára este campo.
    */
  public void setGridCheckField(boolean PARAM) {
    gridCheckField = PARAM;
  }
  /**
    * FORN_CODIGO: Método Gets para este campo
    */
  public String getForn_codigo() {
    return forn_codigo;
  }
  /**
    * FORN_CODIGO: Método Sets pára este campo.
    */
  public void setForn_codigo(String PARAM) {
    forn_codigo = PARAM;
  }
  /**
    * INTERFACE_ARQ_COMPRA_ID: Método Gets para este campo
    */
  public String getInterface_arq_compra_id() {
    return interface_arq_compra_id;
  }
  /**
    * INTERFACE_ARQ_COMPRA_ID: Método Sets pára este campo.
    */
  public void setInterface_arq_compra_id(String PARAM) {
    interface_arq_compra_id = PARAM;
  }
  /**
    * OCO_NUMERO: Método Gets para este campo
    */
  public String getOco_numero() {
    return oco_numero;
  }
  /**
    * OCO_NUMERO: Método Sets pára este campo.
    */
  public void setOco_numero(String PARAM) {
    oco_numero = PARAM;
  }
  /**
    * FIL_FILIAL: Método Gets para este campo
    */
  public String getFil_filial() {
    return fil_filial;
  }
  /**
    * FIL_FILIAL: Método Sets pára este campo.
    */
  public void setFil_filial(String PARAM) {
    fil_filial = PARAM;
  }
  /**
    * DATA_EMISSAO: Método Gets para este campo
    */
  public String getData_emissao() {
    return data_emissao;
  }
  /**
    * DATA_EMISSAO: Método Sets pára este campo.
    */
  public void setData_emissao(String PARAM) {
    data_emissao = PARAM;
  }
  /**
    * COND_PAGTO: Método Gets para este campo
    */
  public String getCond_pagto() {
    return cond_pagto;
  }
  /**
    * COND_PAGTO: Método Sets pára este campo.
    */
  public void setCond_pagto(String PARAM) {
    cond_pagto = PARAM;
  }
  /**
    * ARQUIVO_EDI: Método Gets para este campo
    */
  public String getArquivo_edi() {
    return arquivo_edi;
  }
  /**
    * ARQUIVO_EDI: Método Sets pára este campo.
    */
  public void setArquivo_edi(String PARAM) {
    arquivo_edi = PARAM;
  }
  /**
    * DESCRICAO_SITUACAO: Método Gets para este campo
    */
  public String getDescricao_situacao() {
    return descricao_situacao;
  }
  /**
    * DESCRICAO_SITUACAO: Método Sets pára este campo.
    */
  public void setDescricao_situacao(String PARAM) {
    descricao_situacao = PARAM;
  }
  /**
    * DATA_ENTREGA: Método Gets para este campo
    */
  public String getData_entrega() {
    return data_entrega;
  }
  /**
    * DATA_ENTREGA: Método Sets pára este campo.
    */
  public void setData_entrega(String PARAM) {
    data_entrega = PARAM;
  }
  /**
    * FORN_RAZSOC: Método Gets para este campo
    */
  public String getForn_razsoc() {
    return forn_razsoc;
  }
  /**
    * FORN_RAZSOC: Método Sets pára este campo.
    */
  public void setForn_razsoc(String PARAM) {
    forn_razsoc = PARAM;
  }
  /**
    * AMOSTRA: Método Gets para este campo
    */
  public String getAmostra() {
    return amostra;
  }
  /**
    * AMOSTRA: Método Sets pára este campo.
    */
  public void setAmostra(String PARAM) {
    amostra = PARAM;
  }
  /**
    * DATA_ENTREGA_FORNECEDOR: Método Gets para este campo
    */
  public String getData_entrega_fornecedor() {
    return data_entrega_fornecedor;
  }
  /**
    * DATA_ENTREGA_FORNECEDOR: Método Sets pára este campo.
    */
  public void setData_entrega_fornecedor(String PARAM) {
    data_entrega_fornecedor = PARAM;
  }
  /**
    * SITUACAO_ORDEM_COMPRA: Método Gets para este campo
    */
  public String getSituacao_ordem_compra() {
    return situacao_ordem_compra;
  }
  /**
    * SITUACAO_ORDEM_COMPRA: Método Sets pára este campo.
    */
  public void setSituacao_ordem_compra(String PARAM) {
    situacao_ordem_compra = PARAM;
  }
  /**
    * ALTERADO: Método Gets para este campo
    */
  public String getAlterado() {
    return alterado;
  }
  /**
    * ALTERADO: Método Sets pára este campo.
    */
  public void setAlterado(String PARAM) {
    alterado = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    forn_codigo = null;
    interface_arq_compra_id = null;
    oco_numero = null;
    fil_filial = null;
    data_emissao = null;
    cond_pagto = null;
    arquivo_edi = null;
    descricao_situacao = null;
    data_entrega = null;
    forn_razsoc = null;
    amostra = null;
    data_entrega_fornecedor = null;
    situacao_ordem_compra = null;
    alterado = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (getGridCheckField()) {
      if (com.egen.util.text.Validate.isValidate("update_action,update1_action,update2_action,update3_action,", request)) {
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

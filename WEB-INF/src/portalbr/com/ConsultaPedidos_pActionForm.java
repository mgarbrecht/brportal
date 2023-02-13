package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 09/03/2006 10:50:00
 * Last Modify Date 07/10/2022 16:26:31
 */

public class ConsultaPedidos_pActionForm extends org.apache.struts.action.ActionForm
{
  public String ped_;
  public String codigo;
  public String razao_social;
  public String cid_uf;
  public String cliente1;
  public String marca;
  public String tipo_pedido;
  public boolean gridCheckField;
  public String pedido_beira_rio;
  public String qtde_pares;
  public String pedido_cliente;
  public String remessa;
  public String rep;
  public String status;
  public String pt;
  public String dt_digitacao;
  public String dt_entrega1;
  public String dt_embarque;
  public String nome_linha;
  public String marca1;
  public String filial_pedido;
  public String cliente2;
  public String emp_empresa;
  public String ped_tipo;
  public String periodo_entrega;
  public String previsao_faturamento;
  public String valor_pedido;
  public String recolocado;
  public String fora_normas;
  public String valor_indenizado;
  public String valor_bruto;
  public String valor_nota;
  public String condicao_pagamento;
  public String descricao_livro;
  public String cod;
  public String seqn;
  public String situacao;
  public String dt_entrega;
  public String cliente;
  public String ped_ped_cliente;
  private boolean valida = false;
  public ConsultaPedidos_pActionForm() {
  }
  /**
    * PED_: Método Gets para este campo
    */
  public String getPed_() {
    return ped_;
  }
  /**
    * PED_: Método Sets pára este campo.
    */
  public void setPed_(String PARAM) {
    ped_ = PARAM;
  }
  /**
    * CODIGO: Método Gets para este campo
    */
  public String getCodigo() {
    return codigo;
  }
  /**
    * CODIGO: Método Sets pára este campo.
    */
  public void setCodigo(String PARAM) {
    codigo = PARAM;
  }
  /**
    * RAZAO_SOCIAL: Método Gets para este campo
    */
  public String getRazao_social() {
    return razao_social;
  }
  /**
    * RAZAO_SOCIAL: Método Sets pára este campo.
    */
  public void setRazao_social(String PARAM) {
    razao_social = PARAM;
  }
  /**
    * CID_UF: Método Gets para este campo
    */
  public String getCid_uf() {
    return cid_uf;
  }
  /**
    * CID_UF: Método Sets pára este campo.
    */
  public void setCid_uf(String PARAM) {
    cid_uf = PARAM;
  }
  /**
    * CLIENTE1: Método Gets para este campo
    */
  public String getCliente1() {
    return cliente1;
  }
  /**
    * CLIENTE1: Método Sets pára este campo.
    */
  public void setCliente1(String PARAM) {
    cliente1 = PARAM;
  }
  /**
    * MARCA: Método Gets para este campo
    */
  public String getMarca() {
    return marca;
  }
  /**
    * MARCA: Método Sets pára este campo.
    */
  public void setMarca(String PARAM) {
    marca = PARAM;
  }
  /**
    * TIPO_PEDIDO: Método Gets para este campo
    */
  public String getTipo_pedido() {
    return tipo_pedido;
  }
  /**
    * TIPO_PEDIDO: Método Sets pára este campo.
    */
  public void setTipo_pedido(String PARAM) {
    tipo_pedido = PARAM;
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
    * PEDIDO_BEIRA_RIO: Método Gets para este campo
    */
  public String getPedido_beira_rio() {
    return pedido_beira_rio;
  }
  /**
    * PEDIDO_BEIRA_RIO: Método Sets pára este campo.
    */
  public void setPedido_beira_rio(String PARAM) {
    pedido_beira_rio = PARAM;
  }
  /**
    * QTDE_PARES: Método Gets para este campo
    */
  public String getQtde_pares() {
    return qtde_pares;
  }
  /**
    * QTDE_PARES: Método Sets pára este campo.
    */
  public void setQtde_pares(String PARAM) {
    qtde_pares = PARAM;
  }
  /**
    * PEDIDO_CLIENTE: Método Gets para este campo
    */
  public String getPedido_cliente() {
    return pedido_cliente;
  }
  /**
    * PEDIDO_CLIENTE: Método Sets pára este campo.
    */
  public void setPedido_cliente(String PARAM) {
    pedido_cliente = PARAM;
  }
  /**
    * REMESSA: Método Gets para este campo
    */
  public String getRemessa() {
    return remessa;
  }
  /**
    * REMESSA: Método Sets pára este campo.
    */
  public void setRemessa(String PARAM) {
    remessa = PARAM;
  }
  /**
    * REP: Método Gets para este campo
    */
  public String getRep() {
    return rep;
  }
  /**
    * REP: Método Sets pára este campo.
    */
  public void setRep(String PARAM) {
    rep = PARAM;
  }
  /**
    * STATUS: Método Gets para este campo
    */
  public String getStatus() {
    return status;
  }
  /**
    * STATUS: Método Sets pára este campo.
    */
  public void setStatus(String PARAM) {
    status = PARAM;
  }
  /**
    * PT: Método Gets para este campo
    */
  public String getPt() {
    return pt;
  }
  /**
    * PT: Método Sets pára este campo.
    */
  public void setPt(String PARAM) {
    pt = PARAM;
  }
  /**
    * DT_DIGITACAO: Método Gets para este campo
    */
  public String getDt_digitacao() {
    return dt_digitacao;
  }
  /**
    * DT_DIGITACAO: Método Sets pára este campo.
    */
  public void setDt_digitacao(String PARAM) {
    dt_digitacao = PARAM;
  }
  /**
    * DT_ENTREGA1: Método Gets para este campo
    */
  public String getDt_entrega1() {
    return dt_entrega1;
  }
  /**
    * DT_ENTREGA1: Método Sets pára este campo.
    */
  public void setDt_entrega1(String PARAM) {
    dt_entrega1 = PARAM;
  }
  /**
    * DT_EMBARQUE: Método Gets para este campo
    */
  public String getDt_embarque() {
    return dt_embarque;
  }
  /**
    * DT_EMBARQUE: Método Sets pára este campo.
    */
  public void setDt_embarque(String PARAM) {
    dt_embarque = PARAM;
  }
  /**
    * NOME_LINHA: Método Gets para este campo
    */
  public String getNome_linha() {
    return nome_linha;
  }
  /**
    * NOME_LINHA: Método Sets pára este campo.
    */
  public void setNome_linha(String PARAM) {
    nome_linha = PARAM;
  }
  /**
    * MARCA1: Método Gets para este campo
    */
  public String getMarca1() {
    return marca1;
  }
  /**
    * MARCA1: Método Sets pára este campo.
    */
  public void setMarca1(String PARAM) {
    marca1 = PARAM;
  }
  /**
    * FILIAL_PEDIDO: Método Gets para este campo
    */
  public String getFilial_pedido() {
    return filial_pedido;
  }
  /**
    * FILIAL_PEDIDO: Método Sets pára este campo.
    */
  public void setFilial_pedido(String PARAM) {
    filial_pedido = PARAM;
  }
  /**
    * CLIENTE2: Método Gets para este campo
    */
  public String getCliente2() {
    return cliente2;
  }
  /**
    * CLIENTE2: Método Sets pára este campo.
    */
  public void setCliente2(String PARAM) {
    cliente2 = PARAM;
  }
  /**
    * EMP_EMPRESA: Método Gets para este campo
    */
  public String getEmp_empresa() {
    return emp_empresa;
  }
  /**
    * EMP_EMPRESA: Método Sets pára este campo.
    */
  public void setEmp_empresa(String PARAM) {
    emp_empresa = PARAM;
  }
  /**
    * PED_TIPO: Método Gets para este campo
    */
  public String getPed_tipo() {
    return ped_tipo;
  }
  /**
    * PED_TIPO: Método Sets pára este campo.
    */
  public void setPed_tipo(String PARAM) {
    ped_tipo = PARAM;
  }
  /**
    * PERIODO_ENTREGA: Método Gets para este campo
    */
  public String getPeriodo_entrega() {
    return periodo_entrega;
  }
  /**
    * PERIODO_ENTREGA: Método Sets pára este campo.
    */
  public void setPeriodo_entrega(String PARAM) {
    periodo_entrega = PARAM;
  }
  /**
    * PREVISAO_FATURAMENTO: Método Gets para este campo
    */
  public String getPrevisao_faturamento() {
    return previsao_faturamento;
  }
  /**
    * PREVISAO_FATURAMENTO: Método Sets pára este campo.
    */
  public void setPrevisao_faturamento(String PARAM) {
    previsao_faturamento = PARAM;
  }
  /**
    * VALOR_PEDIDO: Método Gets para este campo
    */
  public String getValor_pedido() {
    return valor_pedido;
  }
  /**
    * VALOR_PEDIDO: Método Sets pára este campo.
    */
  public void setValor_pedido(String PARAM) {
    valor_pedido = PARAM;
  }
  /**
    * RECOLOCADO: Método Gets para este campo
    */
  public String getRecolocado() {
    return recolocado;
  }
  /**
    * RECOLOCADO: Método Sets pára este campo.
    */
  public void setRecolocado(String PARAM) {
    recolocado = PARAM;
  }
  /**
    * FORA_NORMAS: Método Gets para este campo
    */
  public String getFora_normas() {
    return fora_normas;
  }
  /**
    * FORA_NORMAS: Método Sets pára este campo.
    */
  public void setFora_normas(String PARAM) {
    fora_normas = PARAM;
  }
  /**
    * VALOR_INDENIZADO: Método Gets para este campo
    */
  public String getValor_indenizado() {
    return valor_indenizado;
  }
  /**
    * VALOR_INDENIZADO: Método Sets pára este campo.
    */
  public void setValor_indenizado(String PARAM) {
    valor_indenizado = PARAM;
  }
  /**
    * VALOR_BRUTO: Método Gets para este campo
    */
  public String getValor_bruto() {
    return valor_bruto;
  }
  /**
    * VALOR_BRUTO: Método Sets pára este campo.
    */
  public void setValor_bruto(String PARAM) {
    valor_bruto = PARAM;
  }
  /**
    * VALOR_NOTA: Método Gets para este campo
    */
  public String getValor_nota() {
    return valor_nota;
  }
  /**
    * VALOR_NOTA: Método Sets pára este campo.
    */
  public void setValor_nota(String PARAM) {
    valor_nota = PARAM;
  }
  /**
    * CONDICAO_PAGAMENTO: Método Gets para este campo
    */
  public String getCondicao_pagamento() {
    return condicao_pagamento;
  }
  /**
    * CONDICAO_PAGAMENTO: Método Sets pára este campo.
    */
  public void setCondicao_pagamento(String PARAM) {
    condicao_pagamento = PARAM;
  }
  /**
    * DESCRICAO_LIVRO: Método Gets para este campo
    */
  public String getDescricao_livro() {
    return descricao_livro;
  }
  /**
    * DESCRICAO_LIVRO: Método Sets pára este campo.
    */
  public void setDescricao_livro(String PARAM) {
    descricao_livro = PARAM;
  }
  /**
    * COD: Método Gets para este campo
    */
  public String getCod() {
    return cod;
  }
  /**
    * COD: Método Sets pára este campo.
    */
  public void setCod(String PARAM) {
    cod = PARAM;
  }
  /**
    * SEQN: Método Gets para este campo
    */
  public String getSeqn() {
    return seqn;
  }
  /**
    * SEQN: Método Sets pára este campo.
    */
  public void setSeqn(String PARAM) {
    seqn = PARAM;
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
    * DT_ENTREGA: Método Gets para este campo
    */
  public String getDt_entrega() {
    return dt_entrega;
  }
  /**
    * DT_ENTREGA: Método Sets pára este campo.
    */
  public void setDt_entrega(String PARAM) {
    dt_entrega = PARAM;
  }
  /**
    * CLIENTE: Método Gets para este campo
    */
  public String getCliente() {
    return cliente;
  }
  /**
    * CLIENTE: Método Sets pára este campo.
    */
  public void setCliente(String PARAM) {
    cliente = PARAM;
  }
  /**
    * PED_PED_CLIENTE: Método Gets para este campo
    */
  public String getPed_ped_cliente() {
    return ped_ped_cliente;
  }
  /**
    * PED_PED_CLIENTE: Método Sets pára este campo.
    */
  public void setPed_ped_cliente(String PARAM) {
    ped_ped_cliente = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    ped_ = null;
    codigo = null;
    razao_social = null;
    cid_uf = null;
    cliente1 = null;
    marca = null;
    tipo_pedido = null;
    gridCheckField = false;
    pedido_beira_rio = null;
    qtde_pares = null;
    pedido_cliente = null;
    remessa = null;
    rep = null;
    status = null;
    pt = null;
    dt_digitacao = null;
    dt_entrega1 = null;
    dt_embarque = null;
    nome_linha = null;
    marca1 = null;
    filial_pedido = null;
    cliente2 = null;
    emp_empresa = null;
    ped_tipo = null;
    periodo_entrega = null;
    previsao_faturamento = null;
    valor_pedido = null;
    recolocado = null;
    fora_normas = null;
    valor_indenizado = null;
    valor_bruto = null;
    valor_nota = null;
    condicao_pagamento = null;
    descricao_livro = null;
    cod = null;
    seqn = null;
    situacao = null;
    dt_entrega = null;
    cliente = null;
    ped_ped_cliente = null;
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
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

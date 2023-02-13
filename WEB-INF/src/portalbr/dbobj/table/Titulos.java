package portalbr.dbobj.table;

/** DataBase Object from table BRCONREC.Titulos
  * @version 02/07/2015 10:48:39
  */
public class Titulos implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.String emp_empresa;
  private java.lang.String fil_filial;
  private java.lang.String tip_codigo;
  private java.lang.String tit_codigo;
  private java.lang.Integer cli_codigo;
  private java.lang.Integer esc_seqn;
  private java.lang.String trn_codigo;
  private java.lang.String prt_codigo;
  private java.lang.String rep_codigo;
  private java.lang.String car_codigo;
  private java.sql.Timestamp tit_datemi;
  private java.sql.Timestamp tit_datvenc;
  private java.lang.Double tit_valor;
  private java.lang.Double tit_dsante;
  private java.lang.Double tit_dspont;
  private java.lang.Double tit_vlrec;
  private java.lang.Double tit_abatim;
  private java.lang.Double tit_vldesc;
  private java.lang.Double tit_vljuro;
  private java.lang.String tit_status;
  private java.lang.String tit_envcob;
  private java.lang.String tit_cheque;
  private java.lang.String tit_altvct;
  private java.lang.String tit_condes;
  private java.lang.String tit_cobjur;
  private java.sql.Timestamp tit_datrec;
  private java.sql.Timestamp tit_datcre;
  private java.lang.String tit_agecob;
  private java.sql.Timestamp tit_dtutrans;
  private java.lang.String tit_numbco;
  private java.lang.String tit_observa;
  private java.lang.Double tit_vlcor;
  private java.lang.Double tit_outval;
  private java.sql.Timestamp tit_dt_emissao_triplicata;
  private java.sql.Timestamp tit_dt_emissao_anuencia;
  private java.lang.String tit_representante_antigo;
  private java.lang.String tit_ageced;
  private java.lang.String tit_quality;
  private java.sql.Timestamp tit_dt_emissao_ins_protesto;
  private java.sql.Timestamp tit_dt_receb_protesto;
  private java.lang.Double tit_vlpcp;
  private java.lang.Double tit_vldeb;
  private java.lang.Double tit_vlliq;
  private java.lang.String tipo_de_mercado;
  private java.lang.String sit_codigo_situacao_titulo;
  private java.sql.Timestamp data_de_vencimento_original;
  private java.lang.String protestar;
  private java.lang.Integer numero_dias_para_protesto;
  private java.lang.Double valor_despesa_bancaria;
  private java.lang.Double valor_atualizacao_cambial;
  private java.lang.Double valor_variacao_cambial;
  private java.lang.Integer rev_codigo_regional;
  private java.lang.Integer grv_codigo_gerente;
  private java.lang.Double taxa_de_juros;
  private java.sql.Timestamp data_log_afv;
  private java.lang.Double percentual_comissao_venda;
  private java.lang.Double percentual_comissao_fat;
  private java.lang.Double percentual_comissao_neg_tit;
  private java.lang.Double percentual_comissao_bonif;
  private java.lang.String prt_codigo_cobranca;
  private java.lang.Double cob_numero_da_conta_bancaria;
  private java.lang.String cob_digito_da_conta_bancaria;
  private java.lang.String prt_codigo_pagamento;
  private java.lang.String tic_codigo;
  private java.lang.String variacao;
  private java.lang.Integer cac_sequencia;
  private java.lang.Integer numero_da_remessa;
  private java.lang.Double taxa_vendor_comprador;
  private java.lang.Integer numero_do_bordero;
  private java.lang.Double valor_titulo_vencimento;
  private java.lang.String digito_num_bco;
  private java.lang.String codigo_barras;
  private java.lang.Integer codigo_marca;
  private java.lang.Double multa_atraso;
  private java.lang.String empresa_fatura_proforma;
  private java.lang.Integer ano_fatura_proforma;
  private java.lang.Integer numero_fatura_proforma;
  private java.lang.Integer tab_codigo;

  public Titulos() {
  }

  public java.lang.String getEmp_empresa() {
    return emp_empresa;
  }

  public void setEmp_empresa(java.lang.String PARAM) {
    this.emp_empresa = PARAM;
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.lang.String getTip_codigo() {
    return tip_codigo;
  }

  public void setTip_codigo(java.lang.String PARAM) {
    this.tip_codigo = PARAM;
  }

  public java.lang.String getTit_codigo() {
    return tit_codigo;
  }

  public void setTit_codigo(java.lang.String PARAM) {
    this.tit_codigo = PARAM;
  }

  public java.lang.Integer getCli_codigo() {
    return cli_codigo;
  }

  public void setCli_codigo(java.lang.Integer PARAM) {
    this.cli_codigo = PARAM;
  }

  public java.lang.Integer getEsc_seqn() {
    return esc_seqn;
  }

  public void setEsc_seqn(java.lang.Integer PARAM) {
    this.esc_seqn = PARAM;
  }

  public java.lang.String getTrn_codigo() {
    return trn_codigo;
  }

  public void setTrn_codigo(java.lang.String PARAM) {
    this.trn_codigo = PARAM;
  }

  public java.lang.String getPrt_codigo() {
    return prt_codigo;
  }

  public void setPrt_codigo(java.lang.String PARAM) {
    this.prt_codigo = PARAM;
  }

  public java.lang.String getRep_codigo() {
    return rep_codigo;
  }

  public void setRep_codigo(java.lang.String PARAM) {
    this.rep_codigo = PARAM;
  }

  public java.lang.String getCar_codigo() {
    return car_codigo;
  }

  public void setCar_codigo(java.lang.String PARAM) {
    this.car_codigo = PARAM;
  }

  public java.sql.Timestamp getTit_datemi() {
    return tit_datemi;
  }

  public void setTit_datemi(java.sql.Timestamp PARAM) {
    this.tit_datemi = PARAM;
  }

  public java.sql.Timestamp getTit_datvenc() {
    return tit_datvenc;
  }

  public void setTit_datvenc(java.sql.Timestamp PARAM) {
    this.tit_datvenc = PARAM;
  }

  public java.lang.Double getTit_valor() {
    return tit_valor;
  }

  public void setTit_valor(java.lang.Double PARAM) {
    this.tit_valor = PARAM;
  }

  public java.lang.Double getTit_dsante() {
    return tit_dsante;
  }

  public void setTit_dsante(java.lang.Double PARAM) {
    this.tit_dsante = PARAM;
  }

  public java.lang.Double getTit_dspont() {
    return tit_dspont;
  }

  public void setTit_dspont(java.lang.Double PARAM) {
    this.tit_dspont = PARAM;
  }

  public java.lang.Double getTit_vlrec() {
    return tit_vlrec;
  }

  public void setTit_vlrec(java.lang.Double PARAM) {
    this.tit_vlrec = PARAM;
  }

  public java.lang.Double getTit_abatim() {
    return tit_abatim;
  }

  public void setTit_abatim(java.lang.Double PARAM) {
    this.tit_abatim = PARAM;
  }

  public java.lang.Double getTit_vldesc() {
    return tit_vldesc;
  }

  public void setTit_vldesc(java.lang.Double PARAM) {
    this.tit_vldesc = PARAM;
  }

  public java.lang.Double getTit_vljuro() {
    return tit_vljuro;
  }

  public void setTit_vljuro(java.lang.Double PARAM) {
    this.tit_vljuro = PARAM;
  }

  public java.lang.String getTit_status() {
    return tit_status;
  }

  public void setTit_status(java.lang.String PARAM) {
    this.tit_status = PARAM;
  }

  public java.lang.String getTit_envcob() {
    return tit_envcob;
  }

  public void setTit_envcob(java.lang.String PARAM) {
    this.tit_envcob = PARAM;
  }

  public java.lang.String getTit_cheque() {
    return tit_cheque;
  }

  public void setTit_cheque(java.lang.String PARAM) {
    this.tit_cheque = PARAM;
  }

  public java.lang.String getTit_altvct() {
    return tit_altvct;
  }

  public void setTit_altvct(java.lang.String PARAM) {
    this.tit_altvct = PARAM;
  }

  public java.lang.String getTit_condes() {
    return tit_condes;
  }

  public void setTit_condes(java.lang.String PARAM) {
    this.tit_condes = PARAM;
  }

  public java.lang.String getTit_cobjur() {
    return tit_cobjur;
  }

  public void setTit_cobjur(java.lang.String PARAM) {
    this.tit_cobjur = PARAM;
  }

  public java.sql.Timestamp getTit_datrec() {
    return tit_datrec;
  }

  public void setTit_datrec(java.sql.Timestamp PARAM) {
    this.tit_datrec = PARAM;
  }

  public java.sql.Timestamp getTit_datcre() {
    return tit_datcre;
  }

  public void setTit_datcre(java.sql.Timestamp PARAM) {
    this.tit_datcre = PARAM;
  }

  public java.lang.String getTit_agecob() {
    return tit_agecob;
  }

  public void setTit_agecob(java.lang.String PARAM) {
    this.tit_agecob = PARAM;
  }

  public java.sql.Timestamp getTit_dtutrans() {
    return tit_dtutrans;
  }

  public void setTit_dtutrans(java.sql.Timestamp PARAM) {
    this.tit_dtutrans = PARAM;
  }

  public java.lang.String getTit_numbco() {
    return tit_numbco;
  }

  public void setTit_numbco(java.lang.String PARAM) {
    this.tit_numbco = PARAM;
  }

  public java.lang.String getTit_observa() {
    return tit_observa;
  }

  public void setTit_observa(java.lang.String PARAM) {
    this.tit_observa = PARAM;
  }

  public java.lang.Double getTit_vlcor() {
    return tit_vlcor;
  }

  public void setTit_vlcor(java.lang.Double PARAM) {
    this.tit_vlcor = PARAM;
  }

  public java.lang.Double getTit_outval() {
    return tit_outval;
  }

  public void setTit_outval(java.lang.Double PARAM) {
    this.tit_outval = PARAM;
  }

  public java.sql.Timestamp getTit_dt_emissao_triplicata() {
    return tit_dt_emissao_triplicata;
  }

  public void setTit_dt_emissao_triplicata(java.sql.Timestamp PARAM) {
    this.tit_dt_emissao_triplicata = PARAM;
  }

  public java.sql.Timestamp getTit_dt_emissao_anuencia() {
    return tit_dt_emissao_anuencia;
  }

  public void setTit_dt_emissao_anuencia(java.sql.Timestamp PARAM) {
    this.tit_dt_emissao_anuencia = PARAM;
  }

  public java.lang.String getTit_representante_antigo() {
    return tit_representante_antigo;
  }

  public void setTit_representante_antigo(java.lang.String PARAM) {
    this.tit_representante_antigo = PARAM;
  }

  public java.lang.String getTit_ageced() {
    return tit_ageced;
  }

  public void setTit_ageced(java.lang.String PARAM) {
    this.tit_ageced = PARAM;
  }

  public java.lang.String getTit_quality() {
    return tit_quality;
  }

  public void setTit_quality(java.lang.String PARAM) {
    this.tit_quality = PARAM;
  }

  public java.sql.Timestamp getTit_dt_emissao_ins_protesto() {
    return tit_dt_emissao_ins_protesto;
  }

  public void setTit_dt_emissao_ins_protesto(java.sql.Timestamp PARAM) {
    this.tit_dt_emissao_ins_protesto = PARAM;
  }

  public java.sql.Timestamp getTit_dt_receb_protesto() {
    return tit_dt_receb_protesto;
  }

  public void setTit_dt_receb_protesto(java.sql.Timestamp PARAM) {
    this.tit_dt_receb_protesto = PARAM;
  }

  public java.lang.Double getTit_vlpcp() {
    return tit_vlpcp;
  }

  public void setTit_vlpcp(java.lang.Double PARAM) {
    this.tit_vlpcp = PARAM;
  }

  public java.lang.Double getTit_vldeb() {
    return tit_vldeb;
  }

  public void setTit_vldeb(java.lang.Double PARAM) {
    this.tit_vldeb = PARAM;
  }

  public java.lang.Double getTit_vlliq() {
    return tit_vlliq;
  }

  public void setTit_vlliq(java.lang.Double PARAM) {
    this.tit_vlliq = PARAM;
  }

  public java.lang.String getTipo_de_mercado() {
    return tipo_de_mercado;
  }

  public void setTipo_de_mercado(java.lang.String PARAM) {
    this.tipo_de_mercado = PARAM;
  }

  public java.lang.String getSit_codigo_situacao_titulo() {
    return sit_codigo_situacao_titulo;
  }

  public void setSit_codigo_situacao_titulo(java.lang.String PARAM) {
    this.sit_codigo_situacao_titulo = PARAM;
  }

  public java.sql.Timestamp getData_de_vencimento_original() {
    return data_de_vencimento_original;
  }

  public void setData_de_vencimento_original(java.sql.Timestamp PARAM) {
    this.data_de_vencimento_original = PARAM;
  }

  public java.lang.String getProtestar() {
    return protestar;
  }

  public void setProtestar(java.lang.String PARAM) {
    this.protestar = PARAM;
  }

  public java.lang.Integer getNumero_dias_para_protesto() {
    return numero_dias_para_protesto;
  }

  public void setNumero_dias_para_protesto(java.lang.Integer PARAM) {
    this.numero_dias_para_protesto = PARAM;
  }

  public java.lang.Double getValor_despesa_bancaria() {
    return valor_despesa_bancaria;
  }

  public void setValor_despesa_bancaria(java.lang.Double PARAM) {
    this.valor_despesa_bancaria = PARAM;
  }

  public java.lang.Double getValor_atualizacao_cambial() {
    return valor_atualizacao_cambial;
  }

  public void setValor_atualizacao_cambial(java.lang.Double PARAM) {
    this.valor_atualizacao_cambial = PARAM;
  }

  public java.lang.Double getValor_variacao_cambial() {
    return valor_variacao_cambial;
  }

  public void setValor_variacao_cambial(java.lang.Double PARAM) {
    this.valor_variacao_cambial = PARAM;
  }

  public java.lang.Integer getRev_codigo_regional() {
    return rev_codigo_regional;
  }

  public void setRev_codigo_regional(java.lang.Integer PARAM) {
    this.rev_codigo_regional = PARAM;
  }

  public java.lang.Integer getGrv_codigo_gerente() {
    return grv_codigo_gerente;
  }

  public void setGrv_codigo_gerente(java.lang.Integer PARAM) {
    this.grv_codigo_gerente = PARAM;
  }

  public java.lang.Double getTaxa_de_juros() {
    return taxa_de_juros;
  }

  public void setTaxa_de_juros(java.lang.Double PARAM) {
    this.taxa_de_juros = PARAM;
  }

  public java.sql.Timestamp getData_log_afv() {
    return data_log_afv;
  }

  public void setData_log_afv(java.sql.Timestamp PARAM) {
    this.data_log_afv = PARAM;
  }

  public java.lang.Double getPercentual_comissao_venda() {
    return percentual_comissao_venda;
  }

  public void setPercentual_comissao_venda(java.lang.Double PARAM) {
    this.percentual_comissao_venda = PARAM;
  }

  public java.lang.Double getPercentual_comissao_fat() {
    return percentual_comissao_fat;
  }

  public void setPercentual_comissao_fat(java.lang.Double PARAM) {
    this.percentual_comissao_fat = PARAM;
  }

  public java.lang.Double getPercentual_comissao_neg_tit() {
    return percentual_comissao_neg_tit;
  }

  public void setPercentual_comissao_neg_tit(java.lang.Double PARAM) {
    this.percentual_comissao_neg_tit = PARAM;
  }

  public java.lang.Double getPercentual_comissao_bonif() {
    return percentual_comissao_bonif;
  }

  public void setPercentual_comissao_bonif(java.lang.Double PARAM) {
    this.percentual_comissao_bonif = PARAM;
  }

  public java.lang.String getPrt_codigo_cobranca() {
    return prt_codigo_cobranca;
  }

  public void setPrt_codigo_cobranca(java.lang.String PARAM) {
    this.prt_codigo_cobranca = PARAM;
  }

  public java.lang.Double getCob_numero_da_conta_bancaria() {
    return cob_numero_da_conta_bancaria;
  }

  public void setCob_numero_da_conta_bancaria(java.lang.Double PARAM) {
    this.cob_numero_da_conta_bancaria = PARAM;
  }

  public java.lang.String getCob_digito_da_conta_bancaria() {
    return cob_digito_da_conta_bancaria;
  }

  public void setCob_digito_da_conta_bancaria(java.lang.String PARAM) {
    this.cob_digito_da_conta_bancaria = PARAM;
  }

  public java.lang.String getPrt_codigo_pagamento() {
    return prt_codigo_pagamento;
  }

  public void setPrt_codigo_pagamento(java.lang.String PARAM) {
    this.prt_codigo_pagamento = PARAM;
  }

  public java.lang.String getTic_codigo() {
    return tic_codigo;
  }

  public void setTic_codigo(java.lang.String PARAM) {
    this.tic_codigo = PARAM;
  }

  public java.lang.String getVariacao() {
    return variacao;
  }

  public void setVariacao(java.lang.String PARAM) {
    this.variacao = PARAM;
  }

  public java.lang.Integer getCac_sequencia() {
    return cac_sequencia;
  }

  public void setCac_sequencia(java.lang.Integer PARAM) {
    this.cac_sequencia = PARAM;
  }

  public java.lang.Integer getNumero_da_remessa() {
    return numero_da_remessa;
  }

  public void setNumero_da_remessa(java.lang.Integer PARAM) {
    this.numero_da_remessa = PARAM;
  }

  public java.lang.Double getTaxa_vendor_comprador() {
    return taxa_vendor_comprador;
  }

  public void setTaxa_vendor_comprador(java.lang.Double PARAM) {
    this.taxa_vendor_comprador = PARAM;
  }

  public java.lang.Integer getNumero_do_bordero() {
    return numero_do_bordero;
  }

  public void setNumero_do_bordero(java.lang.Integer PARAM) {
    this.numero_do_bordero = PARAM;
  }

  public java.lang.Double getValor_titulo_vencimento() {
    return valor_titulo_vencimento;
  }

  public void setValor_titulo_vencimento(java.lang.Double PARAM) {
    this.valor_titulo_vencimento = PARAM;
  }

  public java.lang.String getDigito_num_bco() {
    return digito_num_bco;
  }

  public void setDigito_num_bco(java.lang.String PARAM) {
    this.digito_num_bco = PARAM;
  }

  public java.lang.String getCodigo_barras() {
    return codigo_barras;
  }

  public void setCodigo_barras(java.lang.String PARAM) {
    this.codigo_barras = PARAM;
  }

  public java.lang.Integer getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(java.lang.Integer PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.Double getMulta_atraso() {
    return multa_atraso;
  }

  public void setMulta_atraso(java.lang.Double PARAM) {
    this.multa_atraso = PARAM;
  }

  public java.lang.String getEmpresa_fatura_proforma() {
    return empresa_fatura_proforma;
  }

  public void setEmpresa_fatura_proforma(java.lang.String PARAM) {
    this.empresa_fatura_proforma = PARAM;
  }

  public java.lang.Integer getAno_fatura_proforma() {
    return ano_fatura_proforma;
  }

  public void setAno_fatura_proforma(java.lang.Integer PARAM) {
    this.ano_fatura_proforma = PARAM;
  }

  public java.lang.Integer getNumero_fatura_proforma() {
    return numero_fatura_proforma;
  }

  public void setNumero_fatura_proforma(java.lang.Integer PARAM) {
    this.numero_fatura_proforma = PARAM;
  }

  public java.lang.Integer getTab_codigo() {
    return tab_codigo;
  }

  public void setTab_codigo(java.lang.Integer PARAM) {
    this.tab_codigo = PARAM;
  }

}

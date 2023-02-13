package portalbr.dbobj.table;

/** DataBase Object from table CPG.Dom_obrigacao
  * @version 08/05/2012 16:03:59
  */
public class Dom_obrigacao implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.String nm_obri;
  private java.lang.String cd_enti;
  private java.lang.String cd_tipo;
  private java.lang.String codi_tipo_ender;
  private java.lang.Integer centro_codigo;
  private java.lang.String emp_empresa;
  private java.lang.String fil_filial;
  private java.lang.String unn_codigo;
  private java.lang.String cd_tiob;
  private java.lang.Double vl_abatim;
  private java.lang.Integer cd_docto;
  private java.sql.Date dt_vcto;
  private java.lang.Double vl_cred;
  private java.lang.Double vl_desp;
  private java.lang.Double vl_face;
  private java.lang.Double vl_obri;
  private java.lang.Double vl_pago;
  private java.sql.Timestamp dt_emis;
  private java.lang.String cd_situ;
  private java.lang.Integer codi_moeda;
  private java.lang.String cd_loco;
  private java.lang.Double vl_juro;
  private java.lang.Double vl_dsc_pr;
  private java.lang.Double vl_desc;
  private java.lang.Double vl_corr;
  private java.lang.Integer codi_banco;
  private java.lang.String cd_mepa;
  private java.lang.String cd_recu;
  private java.lang.String cd_age_cob;
  private java.lang.String cd_bancario;
  private java.lang.String cd_status;
  private java.sql.Timestamp dt_pgto;
  private java.lang.String te_observ;
  private java.sql.Timestamp dt_vct_ant;
  private java.sql.Timestamp dt_prot;
  private java.sql.Timestamp dt_lim_dsc;
  private java.lang.String in_repa;
  private java.lang.Integer nu_repa;
  private java.sql.Timestamp dt_entrada;
  private java.lang.Integer cco_codigo;
  private java.lang.Integer cd_motjuro;
  private java.lang.String intr_juro_desc;
  private java.lang.Integer poi_codigo;
  private java.lang.String area;
  private java.lang.Integer codigo_departamento;
  private java.lang.Double vl_previsao_inicial;
  private java.lang.Integer subgrupo_poi;
  private java.lang.String situacao_pgto_escritural;
  private java.lang.String nro_pagamento;
  private java.lang.String codigo_barra;
  private java.lang.String cod_carteira;
  private java.lang.String cod_seu_numero;
  private java.lang.String cod_nosso_numero;
  private java.lang.String conta_corrente_fornecedor;
  private java.lang.Integer cap_sequencia;
  private java.lang.Double oco_numero;

  public Dom_obrigacao() {
  }

  public java.lang.String getNm_obri() {
    return nm_obri;
  }

  public void setNm_obri(java.lang.String PARAM) {
    this.nm_obri = PARAM;
  }

  public java.lang.String getCd_enti() {
    return cd_enti;
  }

  public void setCd_enti(java.lang.String PARAM) {
    this.cd_enti = PARAM;
  }

  public java.lang.String getCd_tipo() {
    return cd_tipo;
  }

  public void setCd_tipo(java.lang.String PARAM) {
    this.cd_tipo = PARAM;
  }

  public java.lang.String getCodi_tipo_ender() {
    return codi_tipo_ender;
  }

  public void setCodi_tipo_ender(java.lang.String PARAM) {
    this.codi_tipo_ender = PARAM;
  }

  public java.lang.Integer getCentro_codigo() {
    return centro_codigo;
  }

  public void setCentro_codigo(java.lang.Integer PARAM) {
    this.centro_codigo = PARAM;
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

  public java.lang.String getUnn_codigo() {
    return unn_codigo;
  }

  public void setUnn_codigo(java.lang.String PARAM) {
    this.unn_codigo = PARAM;
  }

  public java.lang.String getCd_tiob() {
    return cd_tiob;
  }

  public void setCd_tiob(java.lang.String PARAM) {
    this.cd_tiob = PARAM;
  }

  public java.lang.Double getVl_abatim() {
    return vl_abatim;
  }

  public void setVl_abatim(java.lang.Double PARAM) {
    this.vl_abatim = PARAM;
  }

  public java.lang.Integer getCd_docto() {
    return cd_docto;
  }

  public void setCd_docto(java.lang.Integer PARAM) {
    this.cd_docto = PARAM;
  }

  public java.sql.Date getDt_vcto() {
    return dt_vcto;
  }

  public void setDt_vcto(java.sql.Date PARAM) {
    this.dt_vcto = PARAM;
  }

  public java.lang.Double getVl_cred() {
    return vl_cred;
  }

  public void setVl_cred(java.lang.Double PARAM) {
    this.vl_cred = PARAM;
  }

  public java.lang.Double getVl_desp() {
    return vl_desp;
  }

  public void setVl_desp(java.lang.Double PARAM) {
    this.vl_desp = PARAM;
  }

  public java.lang.Double getVl_face() {
    return vl_face;
  }

  public void setVl_face(java.lang.Double PARAM) {
    this.vl_face = PARAM;
  }

  public java.lang.Double getVl_obri() {
    return vl_obri;
  }

  public void setVl_obri(java.lang.Double PARAM) {
    this.vl_obri = PARAM;
  }

  public java.lang.Double getVl_pago() {
    return vl_pago;
  }

  public void setVl_pago(java.lang.Double PARAM) {
    this.vl_pago = PARAM;
  }

  public java.sql.Timestamp getDt_emis() {
    return dt_emis;
  }

  public void setDt_emis(java.sql.Timestamp PARAM) {
    this.dt_emis = PARAM;
  }

  public java.lang.String getCd_situ() {
    return cd_situ;
  }

  public void setCd_situ(java.lang.String PARAM) {
    this.cd_situ = PARAM;
  }

  public java.lang.Integer getCodi_moeda() {
    return codi_moeda;
  }

  public void setCodi_moeda(java.lang.Integer PARAM) {
    this.codi_moeda = PARAM;
  }

  public java.lang.String getCd_loco() {
    return cd_loco;
  }

  public void setCd_loco(java.lang.String PARAM) {
    this.cd_loco = PARAM;
  }

  public java.lang.Double getVl_juro() {
    return vl_juro;
  }

  public void setVl_juro(java.lang.Double PARAM) {
    this.vl_juro = PARAM;
  }

  public java.lang.Double getVl_dsc_pr() {
    return vl_dsc_pr;
  }

  public void setVl_dsc_pr(java.lang.Double PARAM) {
    this.vl_dsc_pr = PARAM;
  }

  public java.lang.Double getVl_desc() {
    return vl_desc;
  }

  public void setVl_desc(java.lang.Double PARAM) {
    this.vl_desc = PARAM;
  }

  public java.lang.Double getVl_corr() {
    return vl_corr;
  }

  public void setVl_corr(java.lang.Double PARAM) {
    this.vl_corr = PARAM;
  }

  public java.lang.Integer getCodi_banco() {
    return codi_banco;
  }

  public void setCodi_banco(java.lang.Integer PARAM) {
    this.codi_banco = PARAM;
  }

  public java.lang.String getCd_mepa() {
    return cd_mepa;
  }

  public void setCd_mepa(java.lang.String PARAM) {
    this.cd_mepa = PARAM;
  }

  public java.lang.String getCd_recu() {
    return cd_recu;
  }

  public void setCd_recu(java.lang.String PARAM) {
    this.cd_recu = PARAM;
  }

  public java.lang.String getCd_age_cob() {
    return cd_age_cob;
  }

  public void setCd_age_cob(java.lang.String PARAM) {
    this.cd_age_cob = PARAM;
  }

  public java.lang.String getCd_bancario() {
    return cd_bancario;
  }

  public void setCd_bancario(java.lang.String PARAM) {
    this.cd_bancario = PARAM;
  }

  public java.lang.String getCd_status() {
    return cd_status;
  }

  public void setCd_status(java.lang.String PARAM) {
    this.cd_status = PARAM;
  }

  public java.sql.Timestamp getDt_pgto() {
    return dt_pgto;
  }

  public void setDt_pgto(java.sql.Timestamp PARAM) {
    this.dt_pgto = PARAM;
  }

  public java.lang.String getTe_observ() {
    return te_observ;
  }

  public void setTe_observ(java.lang.String PARAM) {
    this.te_observ = PARAM;
  }

  public java.sql.Timestamp getDt_vct_ant() {
    return dt_vct_ant;
  }

  public void setDt_vct_ant(java.sql.Timestamp PARAM) {
    this.dt_vct_ant = PARAM;
  }

  public java.sql.Timestamp getDt_prot() {
    return dt_prot;
  }

  public void setDt_prot(java.sql.Timestamp PARAM) {
    this.dt_prot = PARAM;
  }

  public java.sql.Timestamp getDt_lim_dsc() {
    return dt_lim_dsc;
  }

  public void setDt_lim_dsc(java.sql.Timestamp PARAM) {
    this.dt_lim_dsc = PARAM;
  }

  public java.lang.String getIn_repa() {
    return in_repa;
  }

  public void setIn_repa(java.lang.String PARAM) {
    this.in_repa = PARAM;
  }

  public java.lang.Integer getNu_repa() {
    return nu_repa;
  }

  public void setNu_repa(java.lang.Integer PARAM) {
    this.nu_repa = PARAM;
  }

  public java.sql.Timestamp getDt_entrada() {
    return dt_entrada;
  }

  public void setDt_entrada(java.sql.Timestamp PARAM) {
    this.dt_entrada = PARAM;
  }

  public java.lang.Integer getCco_codigo() {
    return cco_codigo;
  }

  public void setCco_codigo(java.lang.Integer PARAM) {
    this.cco_codigo = PARAM;
  }

  public java.lang.Integer getCd_motjuro() {
    return cd_motjuro;
  }

  public void setCd_motjuro(java.lang.Integer PARAM) {
    this.cd_motjuro = PARAM;
  }

  public java.lang.String getIntr_juro_desc() {
    return intr_juro_desc;
  }

  public void setIntr_juro_desc(java.lang.String PARAM) {
    this.intr_juro_desc = PARAM;
  }

  public java.lang.Integer getPoi_codigo() {
    return poi_codigo;
  }

  public void setPoi_codigo(java.lang.Integer PARAM) {
    this.poi_codigo = PARAM;
  }

  public java.lang.String getArea() {
    return area;
  }

  public void setArea(java.lang.String PARAM) {
    this.area = PARAM;
  }

  public java.lang.Integer getCodigo_departamento() {
    return codigo_departamento;
  }

  public void setCodigo_departamento(java.lang.Integer PARAM) {
    this.codigo_departamento = PARAM;
  }

  public java.lang.Double getVl_previsao_inicial() {
    return vl_previsao_inicial;
  }

  public void setVl_previsao_inicial(java.lang.Double PARAM) {
    this.vl_previsao_inicial = PARAM;
  }

  public java.lang.Integer getSubgrupo_poi() {
    return subgrupo_poi;
  }

  public void setSubgrupo_poi(java.lang.Integer PARAM) {
    this.subgrupo_poi = PARAM;
  }

  public java.lang.String getSituacao_pgto_escritural() {
    return situacao_pgto_escritural;
  }

  public void setSituacao_pgto_escritural(java.lang.String PARAM) {
    this.situacao_pgto_escritural = PARAM;
  }

  public java.lang.String getNro_pagamento() {
    return nro_pagamento;
  }

  public void setNro_pagamento(java.lang.String PARAM) {
    this.nro_pagamento = PARAM;
  }

  public java.lang.String getCodigo_barra() {
    return codigo_barra;
  }

  public void setCodigo_barra(java.lang.String PARAM) {
    this.codigo_barra = PARAM;
  }

  public java.lang.String getCod_carteira() {
    return cod_carteira;
  }

  public void setCod_carteira(java.lang.String PARAM) {
    this.cod_carteira = PARAM;
  }

  public java.lang.String getCod_seu_numero() {
    return cod_seu_numero;
  }

  public void setCod_seu_numero(java.lang.String PARAM) {
    this.cod_seu_numero = PARAM;
  }

  public java.lang.String getCod_nosso_numero() {
    return cod_nosso_numero;
  }

  public void setCod_nosso_numero(java.lang.String PARAM) {
    this.cod_nosso_numero = PARAM;
  }

  public java.lang.String getConta_corrente_fornecedor() {
    return conta_corrente_fornecedor;
  }

  public void setConta_corrente_fornecedor(java.lang.String PARAM) {
    this.conta_corrente_fornecedor = PARAM;
  }

  public java.lang.Integer getCap_sequencia() {
    return cap_sequencia;
  }

  public void setCap_sequencia(java.lang.Integer PARAM) {
    this.cap_sequencia = PARAM;
  }

  public java.lang.Double getOco_numero() {
    return oco_numero;
  }

  public void setOco_numero(java.lang.Double PARAM) {
    this.oco_numero = PARAM;
  }

}

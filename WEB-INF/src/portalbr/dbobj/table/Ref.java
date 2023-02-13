package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ref
  * @version 11/08/2014 10:27:18
  */
public class Ref implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer lin_cdgo;
  private java.lang.Integer ref_cdgo;
  private java.lang.Integer ipi_codred;
  private java.lang.String ref_desc;
  private java.lang.String ref_tipo;
  private java.lang.String ref_status;
  private java.lang.Double ref_pesbru;
  private java.lang.Double ref_pesliq;
  private java.lang.String ref_lista_rel;
  private java.lang.String ref_revenda;
  private java.lang.String ref_descricao_exportacao;
  private java.lang.String ref_produto_estoque;
  private java.lang.Integer gpr_codigo;
  private java.lang.Integer sol_codigo;
  private java.lang.Integer codigo_marca;
  private java.lang.Integer lin_cdgo_mestre;
  private java.lang.Integer ref_cdgo_mestre;
  private java.lang.Integer ref_grupo_fabril;
  private java.lang.Integer ref_grupo_posicao_fab;
  private java.lang.Double cncm_codigo_ncm;
  private java.sql.Timestamp data_log_afv;
  private java.lang.String ref_ref_cli;
  private java.lang.String ref_venda_exportacao;
  private java.lang.String ref_libera_pp_afv;
  private java.lang.String ref_indicador_site;
  private java.lang.Integer ref_class_segmento;
  private java.lang.Integer ref_tipo_material_predominante;
  private java.lang.Integer ref_partal;
  private java.lang.Integer ref_parrem;
  private java.lang.Integer ref_minimo;
  private java.lang.Integer ref_dias_almoxarifado;
  private java.lang.Integer ref_dias_costura;
  private java.lang.Integer ref_dias_montagem;
  private java.lang.Integer ref_dias_expedicao;
  private java.lang.Integer codigo_mini_fabs;
  private java.lang.String destaque_site;
  private java.lang.Integer ref_cdgo_pai;
  private java.lang.String lin_path_img;
  private java.lang.String engenharia_atm;
  private java.lang.Double investimento;
  private java.lang.Double p_equilibrio;
  private java.lang.Double peso_embalagem;
  private java.lang.Double altura_embalagem;
  private java.lang.Double largura_embalagem;
  private java.lang.Double comprimento_embalagem;
  private java.lang.String incluso_sapato;
  private java.lang.String incluso_vareta;
  private java.lang.String incluso_presilha;
  private java.lang.String incluso_papel_bucha;
  private java.lang.String incluso_papel_seda;
  private java.lang.String incluso_bula;
  private java.lang.String incluso_silica_gel;
  private java.lang.String incluso_gancho;
  private java.lang.String incluso_saco_plastico;
  private java.lang.String incluso_protetor_bucha;
  private java.lang.String incluso_pino_anel;
  private java.lang.String usuario_alteracao_med_emb;
  private java.sql.Timestamp data_alteracao_med_emb;
  private java.lang.Double versao_alteracao_med_emb;
  private java.lang.String usuario_alteracao_num;
  private java.sql.Timestamp data_alteracao_num;
  private java.lang.Double versao_alteracao_num;
  private java.lang.String usuario_alteracao_corrug;
  private java.sql.Timestamp data_alteracao_corrug;
  private java.lang.Double versao_alteracao_corrug;
  private java.sql.Timestamp data_embarque;

  public Ref() {
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.Integer getRef_cdgo() {
    return ref_cdgo;
  }

  public void setRef_cdgo(java.lang.Integer PARAM) {
    this.ref_cdgo = PARAM;
  }

  public java.lang.Integer getIpi_codred() {
    return ipi_codred;
  }

  public void setIpi_codred(java.lang.Integer PARAM) {
    this.ipi_codred = PARAM;
  }

  public java.lang.String getRef_desc() {
    return ref_desc;
  }

  public void setRef_desc(java.lang.String PARAM) {
    this.ref_desc = PARAM;
  }

  public java.lang.String getRef_tipo() {
    return ref_tipo;
  }

  public void setRef_tipo(java.lang.String PARAM) {
    this.ref_tipo = PARAM;
  }

  public java.lang.String getRef_status() {
    return ref_status;
  }

  public void setRef_status(java.lang.String PARAM) {
    this.ref_status = PARAM;
  }

  public java.lang.Double getRef_pesbru() {
    return ref_pesbru;
  }

  public void setRef_pesbru(java.lang.Double PARAM) {
    this.ref_pesbru = PARAM;
  }

  public java.lang.Double getRef_pesliq() {
    return ref_pesliq;
  }

  public void setRef_pesliq(java.lang.Double PARAM) {
    this.ref_pesliq = PARAM;
  }

  public java.lang.String getRef_lista_rel() {
    return ref_lista_rel;
  }

  public void setRef_lista_rel(java.lang.String PARAM) {
    this.ref_lista_rel = PARAM;
  }

  public java.lang.String getRef_revenda() {
    return ref_revenda;
  }

  public void setRef_revenda(java.lang.String PARAM) {
    this.ref_revenda = PARAM;
  }

  public java.lang.String getRef_descricao_exportacao() {
    return ref_descricao_exportacao;
  }

  public void setRef_descricao_exportacao(java.lang.String PARAM) {
    this.ref_descricao_exportacao = PARAM;
  }

  public java.lang.String getRef_produto_estoque() {
    return ref_produto_estoque;
  }

  public void setRef_produto_estoque(java.lang.String PARAM) {
    this.ref_produto_estoque = PARAM;
  }

  public java.lang.Integer getGpr_codigo() {
    return gpr_codigo;
  }

  public void setGpr_codigo(java.lang.Integer PARAM) {
    this.gpr_codigo = PARAM;
  }

  public java.lang.Integer getSol_codigo() {
    return sol_codigo;
  }

  public void setSol_codigo(java.lang.Integer PARAM) {
    this.sol_codigo = PARAM;
  }

  public java.lang.Integer getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(java.lang.Integer PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.Integer getLin_cdgo_mestre() {
    return lin_cdgo_mestre;
  }

  public void setLin_cdgo_mestre(java.lang.Integer PARAM) {
    this.lin_cdgo_mestre = PARAM;
  }

  public java.lang.Integer getRef_cdgo_mestre() {
    return ref_cdgo_mestre;
  }

  public void setRef_cdgo_mestre(java.lang.Integer PARAM) {
    this.ref_cdgo_mestre = PARAM;
  }

  public java.lang.Integer getRef_grupo_fabril() {
    return ref_grupo_fabril;
  }

  public void setRef_grupo_fabril(java.lang.Integer PARAM) {
    this.ref_grupo_fabril = PARAM;
  }

  public java.lang.Integer getRef_grupo_posicao_fab() {
    return ref_grupo_posicao_fab;
  }

  public void setRef_grupo_posicao_fab(java.lang.Integer PARAM) {
    this.ref_grupo_posicao_fab = PARAM;
  }

  public java.lang.Double getCncm_codigo_ncm() {
    return cncm_codigo_ncm;
  }

  public void setCncm_codigo_ncm(java.lang.Double PARAM) {
    this.cncm_codigo_ncm = PARAM;
  }

  public java.sql.Timestamp getData_log_afv() {
    return data_log_afv;
  }

  public void setData_log_afv(java.sql.Timestamp PARAM) {
    this.data_log_afv = PARAM;
  }

  public java.lang.String getRef_ref_cli() {
    return ref_ref_cli;
  }

  public void setRef_ref_cli(java.lang.String PARAM) {
    this.ref_ref_cli = PARAM;
  }

  public java.lang.String getRef_venda_exportacao() {
    return ref_venda_exportacao;
  }

  public void setRef_venda_exportacao(java.lang.String PARAM) {
    this.ref_venda_exportacao = PARAM;
  }

  public java.lang.String getRef_libera_pp_afv() {
    return ref_libera_pp_afv;
  }

  public void setRef_libera_pp_afv(java.lang.String PARAM) {
    this.ref_libera_pp_afv = PARAM;
  }

  public java.lang.String getRef_indicador_site() {
    return ref_indicador_site;
  }

  public void setRef_indicador_site(java.lang.String PARAM) {
    this.ref_indicador_site = PARAM;
  }

  public java.lang.Integer getRef_class_segmento() {
    return ref_class_segmento;
  }

  public void setRef_class_segmento(java.lang.Integer PARAM) {
    this.ref_class_segmento = PARAM;
  }

  public java.lang.Integer getRef_tipo_material_predominante() {
    return ref_tipo_material_predominante;
  }

  public void setRef_tipo_material_predominante(java.lang.Integer PARAM) {
    this.ref_tipo_material_predominante = PARAM;
  }

  public java.lang.Integer getRef_partal() {
    return ref_partal;
  }

  public void setRef_partal(java.lang.Integer PARAM) {
    this.ref_partal = PARAM;
  }

  public java.lang.Integer getRef_parrem() {
    return ref_parrem;
  }

  public void setRef_parrem(java.lang.Integer PARAM) {
    this.ref_parrem = PARAM;
  }

  public java.lang.Integer getRef_minimo() {
    return ref_minimo;
  }

  public void setRef_minimo(java.lang.Integer PARAM) {
    this.ref_minimo = PARAM;
  }

  public java.lang.Integer getRef_dias_almoxarifado() {
    return ref_dias_almoxarifado;
  }

  public void setRef_dias_almoxarifado(java.lang.Integer PARAM) {
    this.ref_dias_almoxarifado = PARAM;
  }

  public java.lang.Integer getRef_dias_costura() {
    return ref_dias_costura;
  }

  public void setRef_dias_costura(java.lang.Integer PARAM) {
    this.ref_dias_costura = PARAM;
  }

  public java.lang.Integer getRef_dias_montagem() {
    return ref_dias_montagem;
  }

  public void setRef_dias_montagem(java.lang.Integer PARAM) {
    this.ref_dias_montagem = PARAM;
  }

  public java.lang.Integer getRef_dias_expedicao() {
    return ref_dias_expedicao;
  }

  public void setRef_dias_expedicao(java.lang.Integer PARAM) {
    this.ref_dias_expedicao = PARAM;
  }

  public java.lang.Integer getCodigo_mini_fabs() {
    return codigo_mini_fabs;
  }

  public void setCodigo_mini_fabs(java.lang.Integer PARAM) {
    this.codigo_mini_fabs = PARAM;
  }

  public java.lang.String getDestaque_site() {
    return destaque_site;
  }

  public void setDestaque_site(java.lang.String PARAM) {
    this.destaque_site = PARAM;
  }

  public java.lang.Integer getRef_cdgo_pai() {
    return ref_cdgo_pai;
  }

  public void setRef_cdgo_pai(java.lang.Integer PARAM) {
    this.ref_cdgo_pai = PARAM;
  }

  public java.lang.String getLin_path_img() {
    return lin_path_img;
  }

  public void setLin_path_img(java.lang.String PARAM) {
    this.lin_path_img = PARAM;
  }

  public java.lang.String getEngenharia_atm() {
    return engenharia_atm;
  }

  public void setEngenharia_atm(java.lang.String PARAM) {
    this.engenharia_atm = PARAM;
  }

  public java.lang.Double getInvestimento() {
    return investimento;
  }

  public void setInvestimento(java.lang.Double PARAM) {
    this.investimento = PARAM;
  }

  public java.lang.Double getP_equilibrio() {
    return p_equilibrio;
  }

  public void setP_equilibrio(java.lang.Double PARAM) {
    this.p_equilibrio = PARAM;
  }

  public java.lang.Double getPeso_embalagem() {
    return peso_embalagem;
  }

  public void setPeso_embalagem(java.lang.Double PARAM) {
    this.peso_embalagem = PARAM;
  }

  public java.lang.Double getAltura_embalagem() {
    return altura_embalagem;
  }

  public void setAltura_embalagem(java.lang.Double PARAM) {
    this.altura_embalagem = PARAM;
  }

  public java.lang.Double getLargura_embalagem() {
    return largura_embalagem;
  }

  public void setLargura_embalagem(java.lang.Double PARAM) {
    this.largura_embalagem = PARAM;
  }

  public java.lang.Double getComprimento_embalagem() {
    return comprimento_embalagem;
  }

  public void setComprimento_embalagem(java.lang.Double PARAM) {
    this.comprimento_embalagem = PARAM;
  }

  public java.lang.String getIncluso_sapato() {
    return incluso_sapato;
  }

  public void setIncluso_sapato(java.lang.String PARAM) {
    this.incluso_sapato = PARAM;
  }

  public java.lang.String getIncluso_vareta() {
    return incluso_vareta;
  }

  public void setIncluso_vareta(java.lang.String PARAM) {
    this.incluso_vareta = PARAM;
  }

  public java.lang.String getIncluso_presilha() {
    return incluso_presilha;
  }

  public void setIncluso_presilha(java.lang.String PARAM) {
    this.incluso_presilha = PARAM;
  }

  public java.lang.String getIncluso_papel_bucha() {
    return incluso_papel_bucha;
  }

  public void setIncluso_papel_bucha(java.lang.String PARAM) {
    this.incluso_papel_bucha = PARAM;
  }

  public java.lang.String getIncluso_papel_seda() {
    return incluso_papel_seda;
  }

  public void setIncluso_papel_seda(java.lang.String PARAM) {
    this.incluso_papel_seda = PARAM;
  }

  public java.lang.String getIncluso_bula() {
    return incluso_bula;
  }

  public void setIncluso_bula(java.lang.String PARAM) {
    this.incluso_bula = PARAM;
  }

  public java.lang.String getIncluso_silica_gel() {
    return incluso_silica_gel;
  }

  public void setIncluso_silica_gel(java.lang.String PARAM) {
    this.incluso_silica_gel = PARAM;
  }

  public java.lang.String getIncluso_gancho() {
    return incluso_gancho;
  }

  public void setIncluso_gancho(java.lang.String PARAM) {
    this.incluso_gancho = PARAM;
  }

  public java.lang.String getIncluso_saco_plastico() {
    return incluso_saco_plastico;
  }

  public void setIncluso_saco_plastico(java.lang.String PARAM) {
    this.incluso_saco_plastico = PARAM;
  }

  public java.lang.String getIncluso_protetor_bucha() {
    return incluso_protetor_bucha;
  }

  public void setIncluso_protetor_bucha(java.lang.String PARAM) {
    this.incluso_protetor_bucha = PARAM;
  }

  public java.lang.String getIncluso_pino_anel() {
    return incluso_pino_anel;
  }

  public void setIncluso_pino_anel(java.lang.String PARAM) {
    this.incluso_pino_anel = PARAM;
  }

  public java.lang.String getUsuario_alteracao_med_emb() {
    return usuario_alteracao_med_emb;
  }

  public void setUsuario_alteracao_med_emb(java.lang.String PARAM) {
    this.usuario_alteracao_med_emb = PARAM;
  }

  public java.sql.Timestamp getData_alteracao_med_emb() {
    return data_alteracao_med_emb;
  }

  public void setData_alteracao_med_emb(java.sql.Timestamp PARAM) {
    this.data_alteracao_med_emb = PARAM;
  }

  public java.lang.Double getVersao_alteracao_med_emb() {
    return versao_alteracao_med_emb;
  }

  public void setVersao_alteracao_med_emb(java.lang.Double PARAM) {
    this.versao_alteracao_med_emb = PARAM;
  }

  public java.lang.String getUsuario_alteracao_num() {
    return usuario_alteracao_num;
  }

  public void setUsuario_alteracao_num(java.lang.String PARAM) {
    this.usuario_alteracao_num = PARAM;
  }

  public java.sql.Timestamp getData_alteracao_num() {
    return data_alteracao_num;
  }

  public void setData_alteracao_num(java.sql.Timestamp PARAM) {
    this.data_alteracao_num = PARAM;
  }

  public java.lang.Double getVersao_alteracao_num() {
    return versao_alteracao_num;
  }

  public void setVersao_alteracao_num(java.lang.Double PARAM) {
    this.versao_alteracao_num = PARAM;
  }

  public java.lang.String getUsuario_alteracao_corrug() {
    return usuario_alteracao_corrug;
  }

  public void setUsuario_alteracao_corrug(java.lang.String PARAM) {
    this.usuario_alteracao_corrug = PARAM;
  }

  public java.sql.Timestamp getData_alteracao_corrug() {
    return data_alteracao_corrug;
  }

  public void setData_alteracao_corrug(java.sql.Timestamp PARAM) {
    this.data_alteracao_corrug = PARAM;
  }

  public java.lang.Double getVersao_alteracao_corrug() {
    return versao_alteracao_corrug;
  }

  public void setVersao_alteracao_corrug(java.lang.Double PARAM) {
    this.versao_alteracao_corrug = PARAM;
  }

  public java.sql.Timestamp getData_embarque() {
    return data_embarque;
  }

  public void setData_embarque(java.sql.Timestamp PARAM) {
    this.data_embarque = PARAM;
  }

}

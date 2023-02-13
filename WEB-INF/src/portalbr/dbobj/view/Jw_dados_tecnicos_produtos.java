package portalbr.dbobj.view;

/** DataBase Object from table .Jw_dados_tecnicos_produtos
  * @version 19/01/2022 11:53:24
  */
public class Jw_dados_tecnicos_produtos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer ped_nmro;
  private java.lang.String ped_ped_cliente;
  private java.lang.Integer lin_cdgo;
  private java.lang.Integer ref_cdgo;
  private java.lang.Integer cab_cdgo;
  private java.lang.String cab_desc;
  private java.lang.Integer cor_cdgo;
  private java.lang.String descricao_cor;
  private java.lang.String desc_produto;
  private java.lang.String qtp_nume;
  private java.lang.Integer qtp_pars;
  private java.lang.Double ite_prco;
  private java.lang.String id_produto;
  private java.lang.Integer marca;
  private java.lang.String marca_descricao;
  private java.lang.String filial;
  private java.lang.Long cnpj;
  private java.lang.Long ean13;
  private java.lang.String dun14;
  private java.lang.String classificacao_fiscal;
  private java.lang.String comp_larg_alt_embalagem;
  private java.lang.Double peso_embalamgem;
  private java.lang.Double peso_sapato;
  private java.lang.String ra_fornecedor;
  private java.lang.String razao_social;
  private java.lang.String ref_fechamento_sapato;
  private java.lang.String ref_tipo_salto;
  private java.lang.String ref_bota_possui_elastico;
  private java.lang.Integer ref_tip_mat_cdgo_palmilha;
  private java.lang.String tip_mat_palmilha_descricao;
  private java.lang.Integer ref_tip_mat_cdgo_entresola;
  private java.lang.String tip_mat_entresola_descricao;
  private java.lang.Integer ref_tip_mat_cdgo_salto;
  private java.lang.String tip_mat_salto_descricao;
  private java.lang.Integer ref_tip_mat_cdgo_meiapata;
  private java.lang.String tip_mat_meiapata_descricao;
  private java.lang.String ref_dimensao_cx_individual;
  private java.lang.String dimensao_caixa_descricao;
  private java.lang.String observacao;
  private java.lang.Double ref_largura_interna_pe;
  private java.lang.Double ref_compr_interno_pe;
  private java.lang.Double ref_altura_sapato;
  private java.lang.Double ref_largura_ext_sapato;
  private java.lang.Double ref_compr_ext_sapato;
  private java.lang.Double ref_altura_salto;
  private java.lang.Double ref_altura_meiapata;
  private java.lang.Double ref_altura_canobota;
  private java.lang.Double ref_diametro_boca_bota;
  private java.lang.String grupo_posicao_fabrica;
  private java.lang.String tipo_material_predominante;
  private java.lang.String tipo_material_solado;
  private java.lang.String tipo_material_forro;
  private java.lang.Double ref_perc_cabedal;
  private java.lang.Double ref_perc_solado;
  private java.lang.String fci;
  private java.lang.String cst;
  private java.lang.String tipo_material_palmilha;
  private java.lang.String tem_etiqueta;
  private java.lang.String ref_dimensao_cx_individual_descricao;
  private java.lang.String mix_produtos;
  private java.lang.String numero_exterior;
  private java.lang.Double preco_pdv;
  private java.lang.Double comprimento_embalagem;
  private java.lang.Double largura_embalagem;
  private java.lang.Double altura_embalagem;
  private java.lang.String comprimento_caixa;
  private java.lang.String largura_caixa;
  private java.lang.String altura_caixa;
  private java.lang.String altura_alca;
  private java.lang.String altura_bolsa;
  private java.lang.String bolso_interno;
  private java.lang.String fechamento_bolsa;
  private java.lang.String largura_bolsa;
  private java.lang.String peso_bolsa;
  private java.lang.String profundidade_bolsa;
  private java.lang.String quantidade_bolsos;
  private java.lang.String regulagem;
  private java.lang.String tipo_alca;
  private java.lang.Integer ite_seqn;

  public Jw_dados_tecnicos_produtos() {
  }

  public java.lang.Integer getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(java.lang.Integer PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.String getPed_ped_cliente() {
    return ped_ped_cliente;
  }

  public void setPed_ped_cliente(java.lang.String PARAM) {
    this.ped_ped_cliente = PARAM;
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

  public java.lang.Integer getCab_cdgo() {
    return cab_cdgo;
  }

  public void setCab_cdgo(java.lang.Integer PARAM) {
    this.cab_cdgo = PARAM;
  }

  public java.lang.String getCab_desc() {
    return cab_desc;
  }

  public void setCab_desc(java.lang.String PARAM) {
    this.cab_desc = PARAM;
  }

  public java.lang.Integer getCor_cdgo() {
    return cor_cdgo;
  }

  public void setCor_cdgo(java.lang.Integer PARAM) {
    this.cor_cdgo = PARAM;
  }

  public java.lang.String getDescricao_cor() {
    return descricao_cor;
  }

  public void setDescricao_cor(java.lang.String PARAM) {
    this.descricao_cor = PARAM;
  }

  public java.lang.String getDesc_produto() {
    return desc_produto;
  }

  public void setDesc_produto(java.lang.String PARAM) {
    this.desc_produto = PARAM;
  }

  public java.lang.String getQtp_nume() {
    return qtp_nume;
  }

  public void setQtp_nume(java.lang.String PARAM) {
    this.qtp_nume = PARAM;
  }

  public java.lang.Integer getQtp_pars() {
    return qtp_pars;
  }

  public void setQtp_pars(java.lang.Integer PARAM) {
    this.qtp_pars = PARAM;
  }

  public java.lang.Double getIte_prco() {
    return ite_prco;
  }

  public void setIte_prco(java.lang.Double PARAM) {
    this.ite_prco = PARAM;
  }

  public java.lang.String getId_produto() {
    return id_produto;
  }

  public void setId_produto(java.lang.String PARAM) {
    this.id_produto = PARAM;
  }

  public java.lang.Integer getMarca() {
    return marca;
  }

  public void setMarca(java.lang.Integer PARAM) {
    this.marca = PARAM;
  }

  public java.lang.String getMarca_descricao() {
    return marca_descricao;
  }

  public void setMarca_descricao(java.lang.String PARAM) {
    this.marca_descricao = PARAM;
  }

  public java.lang.String getFilial() {
    return filial;
  }

  public void setFilial(java.lang.String PARAM) {
    this.filial = PARAM;
  }

  public java.lang.Long getCnpj() {
    return cnpj;
  }

  public void setCnpj(java.lang.Long PARAM) {
    this.cnpj = PARAM;
  }

  public java.lang.Long getEan13() {
    return ean13;
  }

  public void setEan13(java.lang.Long PARAM) {
    this.ean13 = PARAM;
  }

  public java.lang.String getDun14() {
    return dun14;
  }

  public void setDun14(java.lang.String PARAM) {
    this.dun14 = PARAM;
  }

  public java.lang.String getClassificacao_fiscal() {
    return classificacao_fiscal;
  }

  public void setClassificacao_fiscal(java.lang.String PARAM) {
    this.classificacao_fiscal = PARAM;
  }

  public java.lang.String getComp_larg_alt_embalagem() {
    return comp_larg_alt_embalagem;
  }

  public void setComp_larg_alt_embalagem(java.lang.String PARAM) {
    this.comp_larg_alt_embalagem = PARAM;
  }

  public java.lang.Double getPeso_embalamgem() {
    return peso_embalamgem;
  }

  public void setPeso_embalamgem(java.lang.Double PARAM) {
    this.peso_embalamgem = PARAM;
  }

  public java.lang.Double getPeso_sapato() {
    return peso_sapato;
  }

  public void setPeso_sapato(java.lang.Double PARAM) {
    this.peso_sapato = PARAM;
  }

  public java.lang.String getRa_fornecedor() {
    return ra_fornecedor;
  }

  public void setRa_fornecedor(java.lang.String PARAM) {
    this.ra_fornecedor = PARAM;
  }

  public java.lang.String getRazao_social() {
    return razao_social;
  }

  public void setRazao_social(java.lang.String PARAM) {
    this.razao_social = PARAM;
  }

  public java.lang.String getRef_fechamento_sapato() {
    return ref_fechamento_sapato;
  }

  public void setRef_fechamento_sapato(java.lang.String PARAM) {
    this.ref_fechamento_sapato = PARAM;
  }

  public java.lang.String getRef_tipo_salto() {
    return ref_tipo_salto;
  }

  public void setRef_tipo_salto(java.lang.String PARAM) {
    this.ref_tipo_salto = PARAM;
  }

  public java.lang.String getRef_bota_possui_elastico() {
    return ref_bota_possui_elastico;
  }

  public void setRef_bota_possui_elastico(java.lang.String PARAM) {
    this.ref_bota_possui_elastico = PARAM;
  }

  public java.lang.Integer getRef_tip_mat_cdgo_palmilha() {
    return ref_tip_mat_cdgo_palmilha;
  }

  public void setRef_tip_mat_cdgo_palmilha(java.lang.Integer PARAM) {
    this.ref_tip_mat_cdgo_palmilha = PARAM;
  }

  public java.lang.String getTip_mat_palmilha_descricao() {
    return tip_mat_palmilha_descricao;
  }

  public void setTip_mat_palmilha_descricao(java.lang.String PARAM) {
    this.tip_mat_palmilha_descricao = PARAM;
  }

  public java.lang.Integer getRef_tip_mat_cdgo_entresola() {
    return ref_tip_mat_cdgo_entresola;
  }

  public void setRef_tip_mat_cdgo_entresola(java.lang.Integer PARAM) {
    this.ref_tip_mat_cdgo_entresola = PARAM;
  }

  public java.lang.String getTip_mat_entresola_descricao() {
    return tip_mat_entresola_descricao;
  }

  public void setTip_mat_entresola_descricao(java.lang.String PARAM) {
    this.tip_mat_entresola_descricao = PARAM;
  }

  public java.lang.Integer getRef_tip_mat_cdgo_salto() {
    return ref_tip_mat_cdgo_salto;
  }

  public void setRef_tip_mat_cdgo_salto(java.lang.Integer PARAM) {
    this.ref_tip_mat_cdgo_salto = PARAM;
  }

  public java.lang.String getTip_mat_salto_descricao() {
    return tip_mat_salto_descricao;
  }

  public void setTip_mat_salto_descricao(java.lang.String PARAM) {
    this.tip_mat_salto_descricao = PARAM;
  }

  public java.lang.Integer getRef_tip_mat_cdgo_meiapata() {
    return ref_tip_mat_cdgo_meiapata;
  }

  public void setRef_tip_mat_cdgo_meiapata(java.lang.Integer PARAM) {
    this.ref_tip_mat_cdgo_meiapata = PARAM;
  }

  public java.lang.String getTip_mat_meiapata_descricao() {
    return tip_mat_meiapata_descricao;
  }

  public void setTip_mat_meiapata_descricao(java.lang.String PARAM) {
    this.tip_mat_meiapata_descricao = PARAM;
  }

  public java.lang.String getRef_dimensao_cx_individual() {
    return ref_dimensao_cx_individual;
  }

  public void setRef_dimensao_cx_individual(java.lang.String PARAM) {
    this.ref_dimensao_cx_individual = PARAM;
  }

  public java.lang.String getDimensao_caixa_descricao() {
    return dimensao_caixa_descricao;
  }

  public void setDimensao_caixa_descricao(java.lang.String PARAM) {
    this.dimensao_caixa_descricao = PARAM;
  }

  public java.lang.String getObservacao() {
    return observacao;
  }

  public void setObservacao(java.lang.String PARAM) {
    this.observacao = PARAM;
  }

  public java.lang.Double getRef_largura_interna_pe() {
    return ref_largura_interna_pe;
  }

  public void setRef_largura_interna_pe(java.lang.Double PARAM) {
    this.ref_largura_interna_pe = PARAM;
  }

  public java.lang.Double getRef_compr_interno_pe() {
    return ref_compr_interno_pe;
  }

  public void setRef_compr_interno_pe(java.lang.Double PARAM) {
    this.ref_compr_interno_pe = PARAM;
  }

  public java.lang.Double getRef_altura_sapato() {
    return ref_altura_sapato;
  }

  public void setRef_altura_sapato(java.lang.Double PARAM) {
    this.ref_altura_sapato = PARAM;
  }

  public java.lang.Double getRef_largura_ext_sapato() {
    return ref_largura_ext_sapato;
  }

  public void setRef_largura_ext_sapato(java.lang.Double PARAM) {
    this.ref_largura_ext_sapato = PARAM;
  }

  public java.lang.Double getRef_compr_ext_sapato() {
    return ref_compr_ext_sapato;
  }

  public void setRef_compr_ext_sapato(java.lang.Double PARAM) {
    this.ref_compr_ext_sapato = PARAM;
  }

  public java.lang.Double getRef_altura_salto() {
    return ref_altura_salto;
  }

  public void setRef_altura_salto(java.lang.Double PARAM) {
    this.ref_altura_salto = PARAM;
  }

  public java.lang.Double getRef_altura_meiapata() {
    return ref_altura_meiapata;
  }

  public void setRef_altura_meiapata(java.lang.Double PARAM) {
    this.ref_altura_meiapata = PARAM;
  }

  public java.lang.Double getRef_altura_canobota() {
    return ref_altura_canobota;
  }

  public void setRef_altura_canobota(java.lang.Double PARAM) {
    this.ref_altura_canobota = PARAM;
  }

  public java.lang.Double getRef_diametro_boca_bota() {
    return ref_diametro_boca_bota;
  }

  public void setRef_diametro_boca_bota(java.lang.Double PARAM) {
    this.ref_diametro_boca_bota = PARAM;
  }

  public java.lang.String getGrupo_posicao_fabrica() {
    return grupo_posicao_fabrica;
  }

  public void setGrupo_posicao_fabrica(java.lang.String PARAM) {
    this.grupo_posicao_fabrica = PARAM;
  }

  public java.lang.String getTipo_material_predominante() {
    return tipo_material_predominante;
  }

  public void setTipo_material_predominante(java.lang.String PARAM) {
    this.tipo_material_predominante = PARAM;
  }

  public java.lang.String getTipo_material_solado() {
    return tipo_material_solado;
  }

  public void setTipo_material_solado(java.lang.String PARAM) {
    this.tipo_material_solado = PARAM;
  }

  public java.lang.String getTipo_material_forro() {
    return tipo_material_forro;
  }

  public void setTipo_material_forro(java.lang.String PARAM) {
    this.tipo_material_forro = PARAM;
  }

  public java.lang.Double getRef_perc_cabedal() {
    return ref_perc_cabedal;
  }

  public void setRef_perc_cabedal(java.lang.Double PARAM) {
    this.ref_perc_cabedal = PARAM;
  }

  public java.lang.Double getRef_perc_solado() {
    return ref_perc_solado;
  }

  public void setRef_perc_solado(java.lang.Double PARAM) {
    this.ref_perc_solado = PARAM;
  }

  public java.lang.String getFci() {
    return fci;
  }

  public void setFci(java.lang.String PARAM) {
    this.fci = PARAM;
  }

  public java.lang.String getCst() {
    return cst;
  }

  public void setCst(java.lang.String PARAM) {
    this.cst = PARAM;
  }

  public java.lang.String getTipo_material_palmilha() {
    return tipo_material_palmilha;
  }

  public void setTipo_material_palmilha(java.lang.String PARAM) {
    this.tipo_material_palmilha = PARAM;
  }

  public java.lang.String getTem_etiqueta() {
    return tem_etiqueta;
  }

  public void setTem_etiqueta(java.lang.String PARAM) {
    this.tem_etiqueta = PARAM;
  }

  public java.lang.String getRef_dimensao_cx_individual_descricao() {
    return ref_dimensao_cx_individual_descricao;
  }

  public void setRef_dimensao_cx_individual_descricao(java.lang.String PARAM) {
    this.ref_dimensao_cx_individual_descricao = PARAM;
  }

  public java.lang.String getMix_produtos() {
    return mix_produtos;
  }

  public void setMix_produtos(java.lang.String PARAM) {
    this.mix_produtos = PARAM;
  }

  public java.lang.String getNumero_exterior() {
    return numero_exterior;
  }

  public void setNumero_exterior(java.lang.String PARAM) {
    this.numero_exterior = PARAM;
  }

  public java.lang.Double getPreco_pdv() {
    return preco_pdv;
  }

  public void setPreco_pdv(java.lang.Double PARAM) {
    this.preco_pdv = PARAM;
  }

  public java.lang.Double getComprimento_embalagem() {
    return comprimento_embalagem;
  }

  public void setComprimento_embalagem(java.lang.Double PARAM) {
    this.comprimento_embalagem = PARAM;
  }

  public java.lang.Double getLargura_embalagem() {
    return largura_embalagem;
  }

  public void setLargura_embalagem(java.lang.Double PARAM) {
    this.largura_embalagem = PARAM;
  }

  public java.lang.Double getAltura_embalagem() {
    return altura_embalagem;
  }

  public void setAltura_embalagem(java.lang.Double PARAM) {
    this.altura_embalagem = PARAM;
  }

  public java.lang.String getComprimento_caixa() {
    return comprimento_caixa;
  }

  public void setComprimento_caixa(java.lang.String PARAM) {
    this.comprimento_caixa = PARAM;
  }

  public java.lang.String getLargura_caixa() {
    return largura_caixa;
  }

  public void setLargura_caixa(java.lang.String PARAM) {
    this.largura_caixa = PARAM;
  }

  public java.lang.String getAltura_caixa() {
    return altura_caixa;
  }

  public void setAltura_caixa(java.lang.String PARAM) {
    this.altura_caixa = PARAM;
  }

  public java.lang.String getAltura_alca() {
    return altura_alca;
  }

  public void setAltura_alca(java.lang.String PARAM) {
    this.altura_alca = PARAM;
  }

  public java.lang.String getAltura_bolsa() {
    return altura_bolsa;
  }

  public void setAltura_bolsa(java.lang.String PARAM) {
    this.altura_bolsa = PARAM;
  }

  public java.lang.String getBolso_interno() {
    return bolso_interno;
  }

  public void setBolso_interno(java.lang.String PARAM) {
    this.bolso_interno = PARAM;
  }

  public java.lang.String getFechamento_bolsa() {
    return fechamento_bolsa;
  }

  public void setFechamento_bolsa(java.lang.String PARAM) {
    this.fechamento_bolsa = PARAM;
  }

  public java.lang.String getLargura_bolsa() {
    return largura_bolsa;
  }

  public void setLargura_bolsa(java.lang.String PARAM) {
    this.largura_bolsa = PARAM;
  }

  public java.lang.String getPeso_bolsa() {
    return peso_bolsa;
  }

  public void setPeso_bolsa(java.lang.String PARAM) {
    this.peso_bolsa = PARAM;
  }

  public java.lang.String getProfundidade_bolsa() {
    return profundidade_bolsa;
  }

  public void setProfundidade_bolsa(java.lang.String PARAM) {
    this.profundidade_bolsa = PARAM;
  }

  public java.lang.String getQuantidade_bolsos() {
    return quantidade_bolsos;
  }

  public void setQuantidade_bolsos(java.lang.String PARAM) {
    this.quantidade_bolsos = PARAM;
  }

  public java.lang.String getRegulagem() {
    return regulagem;
  }

  public void setRegulagem(java.lang.String PARAM) {
    this.regulagem = PARAM;
  }

  public java.lang.String getTipo_alca() {
    return tipo_alca;
  }

  public void setTipo_alca(java.lang.String PARAM) {
    this.tipo_alca = PARAM;
  }

  public java.lang.Integer getIte_seqn() {
    return ite_seqn;
  }

  public void setIte_seqn(java.lang.Integer PARAM) {
    this.ite_seqn = PARAM;
  }

}

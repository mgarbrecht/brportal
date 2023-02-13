package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ref_combinacao_especial
  * @version 05/11/2020 09:45:13
  */
public class Jw_ref_combinacao_especial implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer id_solicitacao;
  private java.lang.String usuario_solicitacao;
  private java.sql.Timestamp data_solicitacao;
  private java.lang.Integer codigo_marca;
  private java.lang.String nome_marca;
  private java.lang.String nova_combinacao;
  private java.lang.String alteracao_modelo;
  private java.lang.String amostra;
  private java.sql.Timestamp data_entrega_prevista;
  private java.sql.Timestamp data_entrega_solicitada;
  private java.sql.Timestamp data_entrega_amostra;
  private java.lang.Integer lin_cdgo;
  private java.lang.String lin_nome;
  private java.lang.Integer ref_cdgo;
  private java.lang.String ref_desc;
  private java.lang.Integer cab_cdgo;
  private java.lang.String cab_desc;
  private java.lang.Integer cor_cdgo;
  private java.lang.String cor_desc;
  private java.lang.String observacao;
  private java.lang.String material_cor1;
  private java.lang.String material_cor2;
  private java.lang.String material_cor3;
  private java.lang.String biqueira_debrum;
  private java.lang.String capa_palmilha;
  private java.lang.String cacharel;
  private java.lang.String forro;
  private java.lang.String metais;
  private java.lang.String taloneira;
  private java.lang.String salto;
  private java.lang.String enfeite;
  private java.lang.String carimbo_etiqueta;
  private java.lang.Integer cli_cdgo;
  private java.lang.String cli_rzao;
  private java.lang.Integer gre_grupo;
  private java.lang.String gre_descricao;
  private java.lang.String rep_cdgo;
  private java.lang.String rep_rzao;
  private java.lang.String regional;
  private java.lang.Integer prs_negociacao;
  private java.lang.Integer pares_linha;
  private java.lang.Integer pares_alteracao;
  private java.lang.Double preco_liguido;
  private java.lang.Double ll_alteracao_solicitada;
  private java.lang.String situacao_solicitacao;
  private java.lang.String situacao_solicitacao_desc;
  private java.sql.Date data_aceite;
  private java.lang.String usuario_aceite;
  private java.lang.String imagem_produto;
  private java.lang.String imagem;
  private java.lang.String cliente_grupo_economico;
  private java.lang.String desenvolvimento;
  private java.sql.Timestamp data_desenvolvimento;
  private java.lang.String fora_mix;
  private java.sql.Timestamp data_fora_mix;
  private java.lang.String manipulacao;
  private java.sql.Timestamp data_manipulacao;
  private java.lang.String modelo_exclusivo;
  private java.lang.String tipo_solicitacao_comb_especial;
  private java.lang.String subtipo_solicitacao_comb_espec;
  private java.lang.String desc_solicitacao_comb_especial;
  private java.lang.String desc_subtipo_comb_espec;
  private java.lang.String descricao;
  private java.sql.Timestamp data_aprovacao;
  private java.lang.String material;
  private java.lang.Double valor_fabricacao;
  private java.lang.Double valor_pdv;
  private java.lang.Double ll_0;
  private java.lang.Double ll_1;
  private java.lang.Double ll_2;
  private java.lang.Double ll_3;
  private java.lang.Double preco_vendor;
  private java.lang.Integer pares_vendidos;

  public Jw_ref_combinacao_especial() {
  }

  public java.lang.Integer getId_solicitacao() {
    return id_solicitacao;
  }

  public void setId_solicitacao(java.lang.Integer PARAM) {
    this.id_solicitacao = PARAM;
  }

  public java.lang.String getUsuario_solicitacao() {
    return usuario_solicitacao;
  }

  public void setUsuario_solicitacao(java.lang.String PARAM) {
    this.usuario_solicitacao = PARAM;
  }

  public java.sql.Timestamp getData_solicitacao() {
    return data_solicitacao;
  }

  public void setData_solicitacao(java.sql.Timestamp PARAM) {
    this.data_solicitacao = PARAM;
  }

  public java.lang.Integer getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(java.lang.Integer PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.String getNome_marca() {
    return nome_marca;
  }

  public void setNome_marca(java.lang.String PARAM) {
    this.nome_marca = PARAM;
  }

  public java.lang.String getNova_combinacao() {
    return nova_combinacao;
  }

  public void setNova_combinacao(java.lang.String PARAM) {
    this.nova_combinacao = PARAM;
  }

  public java.lang.String getAlteracao_modelo() {
    return alteracao_modelo;
  }

  public void setAlteracao_modelo(java.lang.String PARAM) {
    this.alteracao_modelo = PARAM;
  }

  public java.lang.String getAmostra() {
    return amostra;
  }

  public void setAmostra(java.lang.String PARAM) {
    this.amostra = PARAM;
  }

  public java.sql.Timestamp getData_entrega_prevista() {
    return data_entrega_prevista;
  }

  public void setData_entrega_prevista(java.sql.Timestamp PARAM) {
    this.data_entrega_prevista = PARAM;
  }

  public java.sql.Timestamp getData_entrega_solicitada() {
    return data_entrega_solicitada;
  }

  public void setData_entrega_solicitada(java.sql.Timestamp PARAM) {
    this.data_entrega_solicitada = PARAM;
  }

  public java.sql.Timestamp getData_entrega_amostra() {
    return data_entrega_amostra;
  }

  public void setData_entrega_amostra(java.sql.Timestamp PARAM) {
    this.data_entrega_amostra = PARAM;
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.String getLin_nome() {
    return lin_nome;
  }

  public void setLin_nome(java.lang.String PARAM) {
    this.lin_nome = PARAM;
  }

  public java.lang.Integer getRef_cdgo() {
    return ref_cdgo;
  }

  public void setRef_cdgo(java.lang.Integer PARAM) {
    this.ref_cdgo = PARAM;
  }

  public java.lang.String getRef_desc() {
    return ref_desc;
  }

  public void setRef_desc(java.lang.String PARAM) {
    this.ref_desc = PARAM;
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

  public java.lang.String getCor_desc() {
    return cor_desc;
  }

  public void setCor_desc(java.lang.String PARAM) {
    this.cor_desc = PARAM;
  }

  public java.lang.String getObservacao() {
    return observacao;
  }

  public void setObservacao(java.lang.String PARAM) {
    this.observacao = PARAM;
  }

  public java.lang.String getMaterial_cor1() {
    return material_cor1;
  }

  public void setMaterial_cor1(java.lang.String PARAM) {
    this.material_cor1 = PARAM;
  }

  public java.lang.String getMaterial_cor2() {
    return material_cor2;
  }

  public void setMaterial_cor2(java.lang.String PARAM) {
    this.material_cor2 = PARAM;
  }

  public java.lang.String getMaterial_cor3() {
    return material_cor3;
  }

  public void setMaterial_cor3(java.lang.String PARAM) {
    this.material_cor3 = PARAM;
  }

  public java.lang.String getBiqueira_debrum() {
    return biqueira_debrum;
  }

  public void setBiqueira_debrum(java.lang.String PARAM) {
    this.biqueira_debrum = PARAM;
  }

  public java.lang.String getCapa_palmilha() {
    return capa_palmilha;
  }

  public void setCapa_palmilha(java.lang.String PARAM) {
    this.capa_palmilha = PARAM;
  }

  public java.lang.String getCacharel() {
    return cacharel;
  }

  public void setCacharel(java.lang.String PARAM) {
    this.cacharel = PARAM;
  }

  public java.lang.String getForro() {
    return forro;
  }

  public void setForro(java.lang.String PARAM) {
    this.forro = PARAM;
  }

  public java.lang.String getMetais() {
    return metais;
  }

  public void setMetais(java.lang.String PARAM) {
    this.metais = PARAM;
  }

  public java.lang.String getTaloneira() {
    return taloneira;
  }

  public void setTaloneira(java.lang.String PARAM) {
    this.taloneira = PARAM;
  }

  public java.lang.String getSalto() {
    return salto;
  }

  public void setSalto(java.lang.String PARAM) {
    this.salto = PARAM;
  }

  public java.lang.String getEnfeite() {
    return enfeite;
  }

  public void setEnfeite(java.lang.String PARAM) {
    this.enfeite = PARAM;
  }

  public java.lang.String getCarimbo_etiqueta() {
    return carimbo_etiqueta;
  }

  public void setCarimbo_etiqueta(java.lang.String PARAM) {
    this.carimbo_etiqueta = PARAM;
  }

  public java.lang.Integer getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.Integer PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.String getCli_rzao() {
    return cli_rzao;
  }

  public void setCli_rzao(java.lang.String PARAM) {
    this.cli_rzao = PARAM;
  }

  public java.lang.Integer getGre_grupo() {
    return gre_grupo;
  }

  public void setGre_grupo(java.lang.Integer PARAM) {
    this.gre_grupo = PARAM;
  }

  public java.lang.String getGre_descricao() {
    return gre_descricao;
  }

  public void setGre_descricao(java.lang.String PARAM) {
    this.gre_descricao = PARAM;
  }

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

  public java.lang.String getRep_rzao() {
    return rep_rzao;
  }

  public void setRep_rzao(java.lang.String PARAM) {
    this.rep_rzao = PARAM;
  }

  public java.lang.String getRegional() {
    return regional;
  }

  public void setRegional(java.lang.String PARAM) {
    this.regional = PARAM;
  }

  public java.lang.Integer getPrs_negociacao() {
    return prs_negociacao;
  }

  public void setPrs_negociacao(java.lang.Integer PARAM) {
    this.prs_negociacao = PARAM;
  }

  public java.lang.Integer getPares_linha() {
    return pares_linha;
  }

  public void setPares_linha(java.lang.Integer PARAM) {
    this.pares_linha = PARAM;
  }

  public java.lang.Integer getPares_alteracao() {
    return pares_alteracao;
  }

  public void setPares_alteracao(java.lang.Integer PARAM) {
    this.pares_alteracao = PARAM;
  }

  public java.lang.Double getPreco_liguido() {
    return preco_liguido;
  }

  public void setPreco_liguido(java.lang.Double PARAM) {
    this.preco_liguido = PARAM;
  }

  public java.lang.Double getLl_alteracao_solicitada() {
    return ll_alteracao_solicitada;
  }

  public void setLl_alteracao_solicitada(java.lang.Double PARAM) {
    this.ll_alteracao_solicitada = PARAM;
  }

  public java.lang.String getSituacao_solicitacao() {
    return situacao_solicitacao;
  }

  public void setSituacao_solicitacao(java.lang.String PARAM) {
    this.situacao_solicitacao = PARAM;
  }

  public java.lang.String getSituacao_solicitacao_desc() {
    return situacao_solicitacao_desc;
  }

  public void setSituacao_solicitacao_desc(java.lang.String PARAM) {
    this.situacao_solicitacao_desc = PARAM;
  }

  public java.sql.Date getData_aceite() {
    return data_aceite;
  }

  public void setData_aceite(java.sql.Date PARAM) {
    this.data_aceite = PARAM;
  }

  public java.lang.String getUsuario_aceite() {
    return usuario_aceite;
  }

  public void setUsuario_aceite(java.lang.String PARAM) {
    this.usuario_aceite = PARAM;
  }

  public java.lang.String getImagem_produto() {
    return imagem_produto;
  }

  public void setImagem_produto(java.lang.String PARAM) {
    this.imagem_produto = PARAM;
  }

  public java.lang.String getImagem() {
    return imagem;
  }

  public void setImagem(java.lang.String PARAM) {
    this.imagem = PARAM;
  }

  public java.lang.String getCliente_grupo_economico() {
    return cliente_grupo_economico;
  }

  public void setCliente_grupo_economico(java.lang.String PARAM) {
    this.cliente_grupo_economico = PARAM;
  }

  public java.lang.String getDesenvolvimento() {
    return desenvolvimento;
  }

  public void setDesenvolvimento(java.lang.String PARAM) {
    this.desenvolvimento = PARAM;
  }

  public java.sql.Timestamp getData_desenvolvimento() {
    return data_desenvolvimento;
  }

  public void setData_desenvolvimento(java.sql.Timestamp PARAM) {
    this.data_desenvolvimento = PARAM;
  }

  public java.lang.String getFora_mix() {
    return fora_mix;
  }

  public void setFora_mix(java.lang.String PARAM) {
    this.fora_mix = PARAM;
  }

  public java.sql.Timestamp getData_fora_mix() {
    return data_fora_mix;
  }

  public void setData_fora_mix(java.sql.Timestamp PARAM) {
    this.data_fora_mix = PARAM;
  }

  public java.lang.String getManipulacao() {
    return manipulacao;
  }

  public void setManipulacao(java.lang.String PARAM) {
    this.manipulacao = PARAM;
  }

  public java.sql.Timestamp getData_manipulacao() {
    return data_manipulacao;
  }

  public void setData_manipulacao(java.sql.Timestamp PARAM) {
    this.data_manipulacao = PARAM;
  }

  public java.lang.String getModelo_exclusivo() {
    return modelo_exclusivo;
  }

  public void setModelo_exclusivo(java.lang.String PARAM) {
    this.modelo_exclusivo = PARAM;
  }

  public java.lang.String getTipo_solicitacao_comb_especial() {
    return tipo_solicitacao_comb_especial;
  }

  public void setTipo_solicitacao_comb_especial(java.lang.String PARAM) {
    this.tipo_solicitacao_comb_especial = PARAM;
  }

  public java.lang.String getSubtipo_solicitacao_comb_espec() {
    return subtipo_solicitacao_comb_espec;
  }

  public void setSubtipo_solicitacao_comb_espec(java.lang.String PARAM) {
    this.subtipo_solicitacao_comb_espec = PARAM;
  }

  public java.lang.String getDesc_solicitacao_comb_especial() {
    return desc_solicitacao_comb_especial;
  }

  public void setDesc_solicitacao_comb_especial(java.lang.String PARAM) {
    this.desc_solicitacao_comb_especial = PARAM;
  }

  public java.lang.String getDesc_subtipo_comb_espec() {
    return desc_subtipo_comb_espec;
  }

  public void setDesc_subtipo_comb_espec(java.lang.String PARAM) {
    this.desc_subtipo_comb_espec = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.sql.Timestamp getData_aprovacao() {
    return data_aprovacao;
  }

  public void setData_aprovacao(java.sql.Timestamp PARAM) {
    this.data_aprovacao = PARAM;
  }

  public java.lang.String getMaterial() {
    return material;
  }

  public void setMaterial(java.lang.String PARAM) {
    this.material = PARAM;
  }

  public java.lang.Double getValor_fabricacao() {
    return valor_fabricacao;
  }

  public void setValor_fabricacao(java.lang.Double PARAM) {
    this.valor_fabricacao = PARAM;
  }

  public java.lang.Double getValor_pdv() {
    return valor_pdv;
  }

  public void setValor_pdv(java.lang.Double PARAM) {
    this.valor_pdv = PARAM;
  }

  public java.lang.Double getLl_0() {
    return ll_0;
  }

  public void setLl_0(java.lang.Double PARAM) {
    this.ll_0 = PARAM;
  }

  public java.lang.Double getLl_1() {
    return ll_1;
  }

  public void setLl_1(java.lang.Double PARAM) {
    this.ll_1 = PARAM;
  }

  public java.lang.Double getLl_2() {
    return ll_2;
  }

  public void setLl_2(java.lang.Double PARAM) {
    this.ll_2 = PARAM;
  }

  public java.lang.Double getLl_3() {
    return ll_3;
  }

  public void setLl_3(java.lang.Double PARAM) {
    this.ll_3 = PARAM;
  }

  public java.lang.Double getPreco_vendor() {
    return preco_vendor;
  }

  public void setPreco_vendor(java.lang.Double PARAM) {
    this.preco_vendor = PARAM;
  }

  public java.lang.Integer getPares_vendidos() {
    return pares_vendidos;
  }

  public void setPares_vendidos(java.lang.Integer PARAM) {
    this.pares_vendidos = PARAM;
  }

}

package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Controle_clientes_especiais_vw
  * @version 09/09/2022 13:23:54
  */
public class Controle_clientes_especiais_vw implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer ped_nmro;
  private java.lang.Double ped_boni;
  private java.lang.Double ped_boni2;
  private java.lang.Double ped_desc;
  private java.lang.String cnd_cdgo;
  private java.lang.String oc;
  private java.lang.String modelos;
  private java.lang.String etiquetas;
  private java.lang.String obse_adicionais;
  private java.lang.Integer prs;
  private java.lang.String remessa;
  private java.lang.String filial_prd;
  private java.lang.String fil_filial_fat;
  private java.sql.Date dt_emiss;
  private java.sql.Date dt_digit;
  private java.sql.Date dt_fatur;
  private java.sql.Date dt_fatur_filial;
  private java.lang.String marca;
  private java.lang.String carimbo;
  private java.lang.String rotulos;
  private java.lang.String ped_amostra;
  private java.sql.Date dt_envio_amostras;
  private java.lang.String agendamento_cdgo;
  private java.sql.Date data_efetiva;
  private java.lang.Integer codigo_regional;
  private java.lang.String nome_regional;
  private java.lang.String rep_cdgo;
  private java.lang.Integer cli_cdgo;
  private java.lang.Integer esc_seqn;
  private java.lang.Integer codigo_marca;
  private java.lang.String ped_stat;
  private java.lang.String existe;
  private java.lang.String hora;
  private java.lang.String senha;
  private java.sql.Timestamp dt_emissao;
  private java.lang.String filial;
  private java.lang.String notafiscal;
  private java.lang.String volumes;
  private java.lang.String rep_rzao;
  private double valor_pedido;
  private java.lang.String cli_rzao;
  private java.lang.String grupo_economico;
  private java.lang.String grupo_descricao;
  private java.sql.Date dt_inspecao;
  private java.sql.Date dt_entrega_etiqueta;
  private java.sql.Date dt_montagem;
  private java.lang.String dados_cadastrados;
  private java.lang.String possui_carimbo;
  private java.lang.String somente_etiqueta;
  private java.lang.String situacao;
  private java.lang.String cabide;
  private java.lang.String amostra;
  private java.lang.String tipo_amostra;
  private java.lang.String pedido_prod;
  private java.sql.Date dt_ent_amostra_comercial;
  private java.sql.Date dt_ent_amostra_pcp;
  private java.lang.String encarte;
  private java.lang.String ped_amostra_brinde;
  private java.lang.String ped_obse;
  private java.lang.String portao;
  private java.lang.String cd_entrega;
  private java.sql.Date data_entrega_cliente;
  private java.lang.String ped_tipo;
  private java.sql.Date dt_rec_etiqueta_filial;
  private java.lang.String prioridade_embarque;
  private java.lang.String atacado;
  private java.lang.String alerta;
  private java.lang.String ped_especie_pedido;
  private java.lang.Integer nro_normativa_cliente;
  private java.lang.String descricao_normativa_cliente;
  private java.lang.String min_fabr;
  private java.lang.String bloqueio_49;
  private java.lang.String loja;
  private java.lang.String cidade;
  private java.lang.String ped_invoice;
  private java.lang.String ocorrencia;
  private java.sql.Date data_bloqueio;
  private java.sql.Date data_prevista_desbloqueio;
  private java.sql.Date dt_solicitacao_alarme;
  private java.sql.Date dt_rec_alarme_pcp;
  private java.sql.Date dt_rec_alarme_filial;
  private java.lang.Integer nfe_numero;
  private java.lang.Integer existe_log_ped_inf_add;
  private java.lang.String distribuicao;
  private java.lang.String livro;
  private java.lang.String ref_cliente_por_pedido;
  private java.lang.Integer tra_cdgo;
  private java.lang.String tra_rzao;
  private java.sql.Date dt_corte;
  private java.lang.String bloqueado_credito;
  private java.lang.String preco_pdv;
  private java.lang.String certificado_origem;
  private java.lang.String gerar_requisicao;
  private java.lang.Integer les_codigo;
  private java.lang.String tes_codigo;
  private java.sql.Date data_etiquetagem;
  private java.lang.String descricao_modelos;
  private java.lang.String liberado_faturar;
  private java.lang.String descricao_situacao;
  private java.lang.String descricao_embalagem;
  private java.lang.String cnpj;
  private java.lang.String numero_romaneio;
  private java.lang.String data_finalizacao_romaneio;
  private java.lang.String modelo_alarme;
  private java.lang.String grades_corrugados;
  private java.lang.String filial_local_estoque;
  private java.lang.String bloqueio_oc;
  private java.lang.String bloqueio_distribuicao;
  private java.lang.String bloqueio_cliente;
  private java.lang.String bloqueio_sku;
  private java.lang.String bloqueio_credito;
  private java.lang.String bloqueio_suframa;

  public Controle_clientes_especiais_vw() {
  }

  public java.lang.Integer getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(java.lang.Integer PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.Double getPed_boni() {
    return ped_boni;
  }

  public void setPed_boni(java.lang.Double PARAM) {
    this.ped_boni = PARAM;
  }

  public java.lang.Double getPed_boni2() {
    return ped_boni2;
  }

  public void setPed_boni2(java.lang.Double PARAM) {
    this.ped_boni2 = PARAM;
  }

  public java.lang.Double getPed_desc() {
    return ped_desc;
  }

  public void setPed_desc(java.lang.Double PARAM) {
    this.ped_desc = PARAM;
  }

  public java.lang.String getCnd_cdgo() {
    return cnd_cdgo;
  }

  public void setCnd_cdgo(java.lang.String PARAM) {
    this.cnd_cdgo = PARAM;
  }

  public java.lang.String getOc() {
    return oc;
  }

  public void setOc(java.lang.String PARAM) {
    this.oc = PARAM;
  }

  public java.lang.String getModelos() {
    return modelos;
  }

  public void setModelos(java.lang.String PARAM) {
    this.modelos = PARAM;
  }

  public java.lang.String getEtiquetas() {
    return etiquetas;
  }

  public void setEtiquetas(java.lang.String PARAM) {
    this.etiquetas = PARAM;
  }

  public java.lang.String getObse_adicionais() {
    return obse_adicionais;
  }

  public void setObse_adicionais(java.lang.String PARAM) {
    this.obse_adicionais = PARAM;
  }

  public java.lang.Integer getPrs() {
    return prs;
  }

  public void setPrs(java.lang.Integer PARAM) {
    this.prs = PARAM;
  }

  public java.lang.String getRemessa() {
    return remessa;
  }

  public void setRemessa(java.lang.String PARAM) {
    this.remessa = PARAM;
  }

  public java.lang.String getFilial_prd() {
    return filial_prd;
  }

  public void setFilial_prd(java.lang.String PARAM) {
    this.filial_prd = PARAM;
  }

  public java.lang.String getFil_filial_fat() {
    return fil_filial_fat;
  }

  public void setFil_filial_fat(java.lang.String PARAM) {
    this.fil_filial_fat = PARAM;
  }

  public java.sql.Date getDt_emiss() {
    return dt_emiss;
  }

  public void setDt_emiss(java.sql.Date PARAM) {
    this.dt_emiss = PARAM;
  }

  public java.sql.Date getDt_digit() {
    return dt_digit;
  }

  public void setDt_digit(java.sql.Date PARAM) {
    this.dt_digit = PARAM;
  }

  public java.sql.Date getDt_fatur() {
    return dt_fatur;
  }

  public void setDt_fatur(java.sql.Date PARAM) {
    this.dt_fatur = PARAM;
  }

  public java.sql.Date getDt_fatur_filial() {
    return dt_fatur_filial;
  }

  public void setDt_fatur_filial(java.sql.Date PARAM) {
    this.dt_fatur_filial = PARAM;
  }

  public java.lang.String getMarca() {
    return marca;
  }

  public void setMarca(java.lang.String PARAM) {
    this.marca = PARAM;
  }

  public java.lang.String getCarimbo() {
    return carimbo;
  }

  public void setCarimbo(java.lang.String PARAM) {
    this.carimbo = PARAM;
  }

  public java.lang.String getRotulos() {
    return rotulos;
  }

  public void setRotulos(java.lang.String PARAM) {
    this.rotulos = PARAM;
  }

  public java.lang.String getPed_amostra() {
    return ped_amostra;
  }

  public void setPed_amostra(java.lang.String PARAM) {
    this.ped_amostra = PARAM;
  }

  public java.sql.Date getDt_envio_amostras() {
    return dt_envio_amostras;
  }

  public void setDt_envio_amostras(java.sql.Date PARAM) {
    this.dt_envio_amostras = PARAM;
  }

  public java.lang.String getAgendamento_cdgo() {
    return agendamento_cdgo;
  }

  public void setAgendamento_cdgo(java.lang.String PARAM) {
    this.agendamento_cdgo = PARAM;
  }

  public java.sql.Date getData_efetiva() {
    return data_efetiva;
  }

  public void setData_efetiva(java.sql.Date PARAM) {
    this.data_efetiva = PARAM;
  }

  public java.lang.Integer getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.Integer PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getNome_regional() {
    return nome_regional;
  }

  public void setNome_regional(java.lang.String PARAM) {
    this.nome_regional = PARAM;
  }

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

  public java.lang.Integer getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.Integer PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.Integer getEsc_seqn() {
    return esc_seqn;
  }

  public void setEsc_seqn(java.lang.Integer PARAM) {
    this.esc_seqn = PARAM;
  }

  public java.lang.Integer getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(java.lang.Integer PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.String getPed_stat() {
    return ped_stat;
  }

  public void setPed_stat(java.lang.String PARAM) {
    this.ped_stat = PARAM;
  }

  public java.lang.String getExiste() {
    return existe;
  }

  public void setExiste(java.lang.String PARAM) {
    this.existe = PARAM;
  }

  public java.lang.String getHora() {
    return hora;
  }

  public void setHora(java.lang.String PARAM) {
    this.hora = PARAM;
  }

  public java.lang.String getSenha() {
    return senha;
  }

  public void setSenha(java.lang.String PARAM) {
    this.senha = PARAM;
  }

  public java.sql.Timestamp getDt_emissao() {
    return dt_emissao;
  }

  public void setDt_emissao(java.sql.Timestamp PARAM) {
    this.dt_emissao = PARAM;
  }

  public java.lang.String getFilial() {
    return filial;
  }

  public void setFilial(java.lang.String PARAM) {
    this.filial = PARAM;
  }

  public java.lang.String getNotafiscal() {
    return notafiscal;
  }

  public void setNotafiscal(java.lang.String PARAM) {
    this.notafiscal = PARAM;
  }

  public java.lang.String getVolumes() {
    return volumes;
  }

  public void setVolumes(java.lang.String PARAM) {
    this.volumes = PARAM;
  }

  public java.lang.String getRep_rzao() {
    return rep_rzao;
  }

  public void setRep_rzao(java.lang.String PARAM) {
    this.rep_rzao = PARAM;
  }

  public double getValor_pedido() {
    return valor_pedido;
  }

  public void setValor_pedido(double PARAM) {
    this.valor_pedido = PARAM;
  }

  public java.lang.String getCli_rzao() {
    return cli_rzao;
  }

  public void setCli_rzao(java.lang.String PARAM) {
    this.cli_rzao = PARAM;
  }

  public java.lang.String getGrupo_economico() {
    return grupo_economico;
  }

  public void setGrupo_economico(java.lang.String PARAM) {
    this.grupo_economico = PARAM;
  }

  public java.lang.String getGrupo_descricao() {
    return grupo_descricao;
  }

  public void setGrupo_descricao(java.lang.String PARAM) {
    this.grupo_descricao = PARAM;
  }

  public java.sql.Date getDt_inspecao() {
    return dt_inspecao;
  }

  public void setDt_inspecao(java.sql.Date PARAM) {
    this.dt_inspecao = PARAM;
  }

  public java.sql.Date getDt_entrega_etiqueta() {
    return dt_entrega_etiqueta;
  }

  public void setDt_entrega_etiqueta(java.sql.Date PARAM) {
    this.dt_entrega_etiqueta = PARAM;
  }

  public java.sql.Date getDt_montagem() {
    return dt_montagem;
  }

  public void setDt_montagem(java.sql.Date PARAM) {
    this.dt_montagem = PARAM;
  }

  public java.lang.String getDados_cadastrados() {
    return dados_cadastrados;
  }

  public void setDados_cadastrados(java.lang.String PARAM) {
    this.dados_cadastrados = PARAM;
  }

  public java.lang.String getPossui_carimbo() {
    return possui_carimbo;
  }

  public void setPossui_carimbo(java.lang.String PARAM) {
    this.possui_carimbo = PARAM;
  }

  public java.lang.String getSomente_etiqueta() {
    return somente_etiqueta;
  }

  public void setSomente_etiqueta(java.lang.String PARAM) {
    this.somente_etiqueta = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

  public java.lang.String getCabide() {
    return cabide;
  }

  public void setCabide(java.lang.String PARAM) {
    this.cabide = PARAM;
  }

  public java.lang.String getAmostra() {
    return amostra;
  }

  public void setAmostra(java.lang.String PARAM) {
    this.amostra = PARAM;
  }

  public java.lang.String getTipo_amostra() {
    return tipo_amostra;
  }

  public void setTipo_amostra(java.lang.String PARAM) {
    this.tipo_amostra = PARAM;
  }

  public java.lang.String getPedido_prod() {
    return pedido_prod;
  }

  public void setPedido_prod(java.lang.String PARAM) {
    this.pedido_prod = PARAM;
  }

  public java.sql.Date getDt_ent_amostra_comercial() {
    return dt_ent_amostra_comercial;
  }

  public void setDt_ent_amostra_comercial(java.sql.Date PARAM) {
    this.dt_ent_amostra_comercial = PARAM;
  }

  public java.sql.Date getDt_ent_amostra_pcp() {
    return dt_ent_amostra_pcp;
  }

  public void setDt_ent_amostra_pcp(java.sql.Date PARAM) {
    this.dt_ent_amostra_pcp = PARAM;
  }

  public java.lang.String getEncarte() {
    return encarte;
  }

  public void setEncarte(java.lang.String PARAM) {
    this.encarte = PARAM;
  }

  public java.lang.String getPed_amostra_brinde() {
    return ped_amostra_brinde;
  }

  public void setPed_amostra_brinde(java.lang.String PARAM) {
    this.ped_amostra_brinde = PARAM;
  }

  public java.lang.String getPed_obse() {
    return ped_obse;
  }

  public void setPed_obse(java.lang.String PARAM) {
    this.ped_obse = PARAM;
  }

  public java.lang.String getPortao() {
    return portao;
  }

  public void setPortao(java.lang.String PARAM) {
    this.portao = PARAM;
  }

  public java.lang.String getCd_entrega() {
    return cd_entrega;
  }

  public void setCd_entrega(java.lang.String PARAM) {
    this.cd_entrega = PARAM;
  }

  public java.sql.Date getData_entrega_cliente() {
    return data_entrega_cliente;
  }

  public void setData_entrega_cliente(java.sql.Date PARAM) {
    this.data_entrega_cliente = PARAM;
  }

  public java.lang.String getPed_tipo() {
    return ped_tipo;
  }

  public void setPed_tipo(java.lang.String PARAM) {
    this.ped_tipo = PARAM;
  }

  public java.sql.Date getDt_rec_etiqueta_filial() {
    return dt_rec_etiqueta_filial;
  }

  public void setDt_rec_etiqueta_filial(java.sql.Date PARAM) {
    this.dt_rec_etiqueta_filial = PARAM;
  }

  public java.lang.String getPrioridade_embarque() {
    return prioridade_embarque;
  }

  public void setPrioridade_embarque(java.lang.String PARAM) {
    this.prioridade_embarque = PARAM;
  }

  public java.lang.String getAtacado() {
    return atacado;
  }

  public void setAtacado(java.lang.String PARAM) {
    this.atacado = PARAM;
  }

  public java.lang.String getAlerta() {
    return alerta;
  }

  public void setAlerta(java.lang.String PARAM) {
    this.alerta = PARAM;
  }

  public java.lang.String getPed_especie_pedido() {
    return ped_especie_pedido;
  }

  public void setPed_especie_pedido(java.lang.String PARAM) {
    this.ped_especie_pedido = PARAM;
  }

  public java.lang.Integer getNro_normativa_cliente() {
    return nro_normativa_cliente;
  }

  public void setNro_normativa_cliente(java.lang.Integer PARAM) {
    this.nro_normativa_cliente = PARAM;
  }

  public java.lang.String getDescricao_normativa_cliente() {
    return descricao_normativa_cliente;
  }

  public void setDescricao_normativa_cliente(java.lang.String PARAM) {
    this.descricao_normativa_cliente = PARAM;
  }

  public java.lang.String getMin_fabr() {
    return min_fabr;
  }

  public void setMin_fabr(java.lang.String PARAM) {
    this.min_fabr = PARAM;
  }

  public java.lang.String getBloqueio_49() {
    return bloqueio_49;
  }

  public void setBloqueio_49(java.lang.String PARAM) {
    this.bloqueio_49 = PARAM;
  }

  public java.lang.String getLoja() {
    return loja;
  }

  public void setLoja(java.lang.String PARAM) {
    this.loja = PARAM;
  }

  public java.lang.String getCidade() {
    return cidade;
  }

  public void setCidade(java.lang.String PARAM) {
    this.cidade = PARAM;
  }

  public java.lang.String getPed_invoice() {
    return ped_invoice;
  }

  public void setPed_invoice(java.lang.String PARAM) {
    this.ped_invoice = PARAM;
  }

  public java.lang.String getOcorrencia() {
    return ocorrencia;
  }

  public void setOcorrencia(java.lang.String PARAM) {
    this.ocorrencia = PARAM;
  }

  public java.sql.Date getData_bloqueio() {
    return data_bloqueio;
  }

  public void setData_bloqueio(java.sql.Date PARAM) {
    this.data_bloqueio = PARAM;
  }

  public java.sql.Date getData_prevista_desbloqueio() {
    return data_prevista_desbloqueio;
  }

  public void setData_prevista_desbloqueio(java.sql.Date PARAM) {
    this.data_prevista_desbloqueio = PARAM;
  }

  public java.sql.Date getDt_solicitacao_alarme() {
    return dt_solicitacao_alarme;
  }

  public void setDt_solicitacao_alarme(java.sql.Date PARAM) {
    this.dt_solicitacao_alarme = PARAM;
  }

  public java.sql.Date getDt_rec_alarme_pcp() {
    return dt_rec_alarme_pcp;
  }

  public void setDt_rec_alarme_pcp(java.sql.Date PARAM) {
    this.dt_rec_alarme_pcp = PARAM;
  }

  public java.sql.Date getDt_rec_alarme_filial() {
    return dt_rec_alarme_filial;
  }

  public void setDt_rec_alarme_filial(java.sql.Date PARAM) {
    this.dt_rec_alarme_filial = PARAM;
  }

  public java.lang.Integer getNfe_numero() {
    return nfe_numero;
  }

  public void setNfe_numero(java.lang.Integer PARAM) {
    this.nfe_numero = PARAM;
  }

  public java.lang.Integer getExiste_log_ped_inf_add() {
    return existe_log_ped_inf_add;
  }

  public void setExiste_log_ped_inf_add(java.lang.Integer PARAM) {
    this.existe_log_ped_inf_add = PARAM;
  }

  public java.lang.String getDistribuicao() {
    return distribuicao;
  }

  public void setDistribuicao(java.lang.String PARAM) {
    this.distribuicao = PARAM;
  }

  public java.lang.String getLivro() {
    return livro;
  }

  public void setLivro(java.lang.String PARAM) {
    this.livro = PARAM;
  }

  public java.lang.String getRef_cliente_por_pedido() {
    return ref_cliente_por_pedido;
  }

  public void setRef_cliente_por_pedido(java.lang.String PARAM) {
    this.ref_cliente_por_pedido = PARAM;
  }

  public java.lang.Integer getTra_cdgo() {
    return tra_cdgo;
  }

  public void setTra_cdgo(java.lang.Integer PARAM) {
    this.tra_cdgo = PARAM;
  }

  public java.lang.String getTra_rzao() {
    return tra_rzao;
  }

  public void setTra_rzao(java.lang.String PARAM) {
    this.tra_rzao = PARAM;
  }

  public java.sql.Date getDt_corte() {
    return dt_corte;
  }

  public void setDt_corte(java.sql.Date PARAM) {
    this.dt_corte = PARAM;
  }

  public java.lang.String getBloqueado_credito() {
    return bloqueado_credito;
  }

  public void setBloqueado_credito(java.lang.String PARAM) {
    this.bloqueado_credito = PARAM;
  }

  public java.lang.String getPreco_pdv() {
    return preco_pdv;
  }

  public void setPreco_pdv(java.lang.String PARAM) {
    this.preco_pdv = PARAM;
  }

  public java.lang.String getCertificado_origem() {
    return certificado_origem;
  }

  public void setCertificado_origem(java.lang.String PARAM) {
    this.certificado_origem = PARAM;
  }

  public java.lang.String getGerar_requisicao() {
    return gerar_requisicao;
  }

  public void setGerar_requisicao(java.lang.String PARAM) {
    this.gerar_requisicao = PARAM;
  }

  public java.lang.Integer getLes_codigo() {
    return les_codigo;
  }

  public void setLes_codigo(java.lang.Integer PARAM) {
    this.les_codigo = PARAM;
  }

  public java.lang.String getTes_codigo() {
    return tes_codigo;
  }

  public void setTes_codigo(java.lang.String PARAM) {
    this.tes_codigo = PARAM;
  }

  public java.sql.Date getData_etiquetagem() {
    return data_etiquetagem;
  }

  public void setData_etiquetagem(java.sql.Date PARAM) {
    this.data_etiquetagem = PARAM;
  }

  public java.lang.String getDescricao_modelos() {
    return descricao_modelos;
  }

  public void setDescricao_modelos(java.lang.String PARAM) {
    this.descricao_modelos = PARAM;
  }

  public java.lang.String getLiberado_faturar() {
    return liberado_faturar;
  }

  public void setLiberado_faturar(java.lang.String PARAM) {
    this.liberado_faturar = PARAM;
  }

  public java.lang.String getDescricao_situacao() {
    return descricao_situacao;
  }

  public void setDescricao_situacao(java.lang.String PARAM) {
    this.descricao_situacao = PARAM;
  }

  public java.lang.String getDescricao_embalagem() {
    return descricao_embalagem;
  }

  public void setDescricao_embalagem(java.lang.String PARAM) {
    this.descricao_embalagem = PARAM;
  }

  public java.lang.String getCnpj() {
    return cnpj;
  }

  public void setCnpj(java.lang.String PARAM) {
    this.cnpj = PARAM;
  }

  public java.lang.String getNumero_romaneio() {
    return numero_romaneio;
  }

  public void setNumero_romaneio(java.lang.String PARAM) {
    this.numero_romaneio = PARAM;
  }

  public java.lang.String getData_finalizacao_romaneio() {
    return data_finalizacao_romaneio;
  }

  public void setData_finalizacao_romaneio(java.lang.String PARAM) {
    this.data_finalizacao_romaneio = PARAM;
  }

  public java.lang.String getModelo_alarme() {
    return modelo_alarme;
  }

  public void setModelo_alarme(java.lang.String PARAM) {
    this.modelo_alarme = PARAM;
  }

  public java.lang.String getGrades_corrugados() {
    return grades_corrugados;
  }

  public void setGrades_corrugados(java.lang.String PARAM) {
    this.grades_corrugados = PARAM;
  }

  public java.lang.String getFilial_local_estoque() {
    return filial_local_estoque;
  }

  public void setFilial_local_estoque(java.lang.String PARAM) {
    this.filial_local_estoque = PARAM;
  }

  public java.lang.String getBloqueio_oc() {
    return bloqueio_oc;
  }

  public void setBloqueio_oc(java.lang.String PARAM) {
    this.bloqueio_oc = PARAM;
  }

  public java.lang.String getBloqueio_distribuicao() {
    return bloqueio_distribuicao;
  }

  public void setBloqueio_distribuicao(java.lang.String PARAM) {
    this.bloqueio_distribuicao = PARAM;
  }

  public java.lang.String getBloqueio_cliente() {
    return bloqueio_cliente;
  }

  public void setBloqueio_cliente(java.lang.String PARAM) {
    this.bloqueio_cliente = PARAM;
  }

  public java.lang.String getBloqueio_sku() {
    return bloqueio_sku;
  }

  public void setBloqueio_sku(java.lang.String PARAM) {
    this.bloqueio_sku = PARAM;
  }

  public java.lang.String getBloqueio_credito() {
    return bloqueio_credito;
  }

  public void setBloqueio_credito(java.lang.String PARAM) {
    this.bloqueio_credito = PARAM;
  }

  public java.lang.String getBloqueio_suframa() {
    return bloqueio_suframa;
  }

  public void setBloqueio_suframa(java.lang.String PARAM) {
    this.bloqueio_suframa = PARAM;
  }

}

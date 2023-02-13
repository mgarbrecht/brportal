package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ped
  * @version 21/08/2013 11:32:21
  */
public class Ped implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int ped_nmro;
  private java.lang.String ped_nped;
  private int cli_cdgo;
  private int esc_seqn;
  private int cnd_cdgo;
  private int tra_cdgo;
  private int liv_codigo;
  private java.sql.Timestamp ped_daem;
  private java.sql.Timestamp ped_dadg;
  private java.sql.Timestamp ped_det;
  private java.lang.String ped_stat;
  private double ped_boni;
  private java.sql.Timestamp ped_emba;
  private java.lang.String ped_tipo;
  private double ped_desc;
  private double ped_comr;
  private java.lang.String ped_roma;
  private java.lang.String ped_frepag;
  private java.lang.String ped_obse;
  private int ped_cons;
  private double ped_boni2;
  private java.lang.String ped_usulib;
  private java.sql.Timestamp ped_datlib;
  private java.sql.Timestamp ped_datpro;
  private java.sql.Timestamp ped_datant;
  private java.lang.String ped_redg;
  private java.lang.String rep_cdgo;
  private java.lang.String ped_pedido_consignado;
  private java.sql.Timestamp ped_data_faturamento;
  private java.lang.String ped_invoice;
  private int ped_recolocado;
  private java.lang.String ped_pino_anel;
  private java.lang.String ped_ped_cliente;
  private int ped_tipo_corrugado;
  private int ped_forma_embalagem;
  private java.lang.String moe_codigo;
  private int tipcob_codigo;
  private java.lang.String fil_filial;
  private java.lang.String prt_codigo;
  private java.lang.String emp_empresa;
  private java.lang.String ped_refaturamento;
  private java.sql.Timestamp ped_det_ant;
  private java.lang.String ped_liberacao_credito;
  private java.lang.String ped_indicador_credito;
  private java.sql.Timestamp ped_data_prev_ind;
  private java.sql.Timestamp ped_data_entra_tonel;
  private java.lang.String ped_observacoes_nf;
  private java.lang.String ped_especie_pedido;
  private java.lang.String ped_proximo_tonel;
  private java.sql.Timestamp ped_data_aproximada_fatur;
  private int ped_total_pares;
  private java.lang.String ped_devolver_repres;
  private java.lang.String ped_enviado_repres;
  private double ped_peso_liquido;
  private double ped_peso_bruto;
  private int codigo_atendente;
  private java.lang.String ped_marca_segmento;
  private java.lang.String ped_bloqueio_frete;
  private java.lang.String ped_substituicao;
  private java.lang.String ped_pacote;
  private int oco_numero;
  private int cod_min_fabr;
  private java.lang.String ped_indic_super;
  private java.sql.Timestamp ped_data_solicitada_cliente;
  private java.sql.Timestamp data_impressao_carta;
  private java.sql.Timestamp data_embarque_porto;
  private java.lang.String codigo_representante_adicional;
  private double percentual_comissao_adicional;
  private java.lang.String ped_usuario_liber_credito;
  private java.lang.String ped_libera_bonif;
  private java.lang.String ped_empenho_direto;
  private java.lang.String ped_amostra_brinde;
  private int les_codigo;
  private java.lang.String nf_ind_edi;
  private int ano_carta_credito;
  private java.lang.String numero_carta_credito;
  private java.lang.String ped_carta_credito;
  private double mark_up;
  private java.sql.Timestamp alteracao_sadig;
  private int tipo_expositor1;
  private int quantidade_expositor1;
  private int tipo_expositor2;
  private int quantidade_expositor2;
  private java.lang.String ped_sequencial_maquina;
  private java.lang.String ped_flag_credito;
  private java.lang.String ped_flag_tonel;
  private java.lang.String ped_flag_estoque;
  private java.lang.String ped_flag_cotas;
  private java.sql.Timestamp data_log_afv;
  private java.lang.String sinaliza_compra;
  private double percentual_comissao_venda;
  private double percentual_comissao_fat;
  private double percentual_comissao_neg_tit;
  private java.lang.String ped_codigo_vendedor;
  private java.lang.String ped_forma_pagamento;
  private double ped_valor_bloqueto;
  private double percentual_comissao_bonif;
  private double taxa_vendor_comprador;
  private java.lang.String tipo_kit;
  private java.sql.Timestamp data_entrega_cliente;
  private int tra_cdgo_internar;

  public Ped() {
  }

  public int getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(int PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.String getPed_nped() {
    return ped_nped;
  }

  public void setPed_nped(java.lang.String PARAM) {
    this.ped_nped = PARAM;
  }

  public int getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(int PARAM) {
    this.cli_cdgo = PARAM;
  }

  public int getEsc_seqn() {
    return esc_seqn;
  }

  public void setEsc_seqn(int PARAM) {
    this.esc_seqn = PARAM;
  }

  public int getCnd_cdgo() {
    return cnd_cdgo;
  }

  public void setCnd_cdgo(int PARAM) {
    this.cnd_cdgo = PARAM;
  }

  public int getTra_cdgo() {
    return tra_cdgo;
  }

  public void setTra_cdgo(int PARAM) {
    this.tra_cdgo = PARAM;
  }

  public int getLiv_codigo() {
    return liv_codigo;
  }

  public void setLiv_codigo(int PARAM) {
    this.liv_codigo = PARAM;
  }

  public java.sql.Timestamp getPed_daem() {
    return ped_daem;
  }

  public void setPed_daem(java.sql.Timestamp PARAM) {
    this.ped_daem = PARAM;
  }

  public java.sql.Timestamp getPed_dadg() {
    return ped_dadg;
  }

  public void setPed_dadg(java.sql.Timestamp PARAM) {
    this.ped_dadg = PARAM;
  }

  public java.sql.Timestamp getPed_det() {
    return ped_det;
  }

  public void setPed_det(java.sql.Timestamp PARAM) {
    this.ped_det = PARAM;
  }

  public java.lang.String getPed_stat() {
    return ped_stat;
  }

  public void setPed_stat(java.lang.String PARAM) {
    this.ped_stat = PARAM;
  }

  public double getPed_boni() {
    return ped_boni;
  }

  public void setPed_boni(double PARAM) {
    this.ped_boni = PARAM;
  }

  public java.sql.Timestamp getPed_emba() {
    return ped_emba;
  }

  public void setPed_emba(java.sql.Timestamp PARAM) {
    this.ped_emba = PARAM;
  }

  public java.lang.String getPed_tipo() {
    return ped_tipo;
  }

  public void setPed_tipo(java.lang.String PARAM) {
    this.ped_tipo = PARAM;
  }

  public double getPed_desc() {
    return ped_desc;
  }

  public void setPed_desc(double PARAM) {
    this.ped_desc = PARAM;
  }

  public double getPed_comr() {
    return ped_comr;
  }

  public void setPed_comr(double PARAM) {
    this.ped_comr = PARAM;
  }

  public java.lang.String getPed_roma() {
    return ped_roma;
  }

  public void setPed_roma(java.lang.String PARAM) {
    this.ped_roma = PARAM;
  }

  public java.lang.String getPed_frepag() {
    return ped_frepag;
  }

  public void setPed_frepag(java.lang.String PARAM) {
    this.ped_frepag = PARAM;
  }

  public java.lang.String getPed_obse() {
    return ped_obse;
  }

  public void setPed_obse(java.lang.String PARAM) {
    this.ped_obse = PARAM;
  }

  public int getPed_cons() {
    return ped_cons;
  }

  public void setPed_cons(int PARAM) {
    this.ped_cons = PARAM;
  }

  public double getPed_boni2() {
    return ped_boni2;
  }

  public void setPed_boni2(double PARAM) {
    this.ped_boni2 = PARAM;
  }

  public java.lang.String getPed_usulib() {
    return ped_usulib;
  }

  public void setPed_usulib(java.lang.String PARAM) {
    this.ped_usulib = PARAM;
  }

  public java.sql.Timestamp getPed_datlib() {
    return ped_datlib;
  }

  public void setPed_datlib(java.sql.Timestamp PARAM) {
    this.ped_datlib = PARAM;
  }

  public java.sql.Timestamp getPed_datpro() {
    return ped_datpro;
  }

  public void setPed_datpro(java.sql.Timestamp PARAM) {
    this.ped_datpro = PARAM;
  }

  public java.sql.Timestamp getPed_datant() {
    return ped_datant;
  }

  public void setPed_datant(java.sql.Timestamp PARAM) {
    this.ped_datant = PARAM;
  }

  public java.lang.String getPed_redg() {
    return ped_redg;
  }

  public void setPed_redg(java.lang.String PARAM) {
    this.ped_redg = PARAM;
  }

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

  public java.lang.String getPed_pedido_consignado() {
    return ped_pedido_consignado;
  }

  public void setPed_pedido_consignado(java.lang.String PARAM) {
    this.ped_pedido_consignado = PARAM;
  }

  public java.sql.Timestamp getPed_data_faturamento() {
    return ped_data_faturamento;
  }

  public void setPed_data_faturamento(java.sql.Timestamp PARAM) {
    this.ped_data_faturamento = PARAM;
  }

  public java.lang.String getPed_invoice() {
    return ped_invoice;
  }

  public void setPed_invoice(java.lang.String PARAM) {
    this.ped_invoice = PARAM;
  }

  public int getPed_recolocado() {
    return ped_recolocado;
  }

  public void setPed_recolocado(int PARAM) {
    this.ped_recolocado = PARAM;
  }

  public java.lang.String getPed_pino_anel() {
    return ped_pino_anel;
  }

  public void setPed_pino_anel(java.lang.String PARAM) {
    this.ped_pino_anel = PARAM;
  }

  public java.lang.String getPed_ped_cliente() {
    return ped_ped_cliente;
  }

  public void setPed_ped_cliente(java.lang.String PARAM) {
    this.ped_ped_cliente = PARAM;
  }

  public int getPed_tipo_corrugado() {
    return ped_tipo_corrugado;
  }

  public void setPed_tipo_corrugado(int PARAM) {
    this.ped_tipo_corrugado = PARAM;
  }

  public int getPed_forma_embalagem() {
    return ped_forma_embalagem;
  }

  public void setPed_forma_embalagem(int PARAM) {
    this.ped_forma_embalagem = PARAM;
  }

  public java.lang.String getMoe_codigo() {
    return moe_codigo;
  }

  public void setMoe_codigo(java.lang.String PARAM) {
    this.moe_codigo = PARAM;
  }

  public int getTipcob_codigo() {
    return tipcob_codigo;
  }

  public void setTipcob_codigo(int PARAM) {
    this.tipcob_codigo = PARAM;
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.lang.String getPrt_codigo() {
    return prt_codigo;
  }

  public void setPrt_codigo(java.lang.String PARAM) {
    this.prt_codigo = PARAM;
  }

  public java.lang.String getEmp_empresa() {
    return emp_empresa;
  }

  public void setEmp_empresa(java.lang.String PARAM) {
    this.emp_empresa = PARAM;
  }

  public java.lang.String getPed_refaturamento() {
    return ped_refaturamento;
  }

  public void setPed_refaturamento(java.lang.String PARAM) {
    this.ped_refaturamento = PARAM;
  }

  public java.sql.Timestamp getPed_det_ant() {
    return ped_det_ant;
  }

  public void setPed_det_ant(java.sql.Timestamp PARAM) {
    this.ped_det_ant = PARAM;
  }

  public java.lang.String getPed_liberacao_credito() {
    return ped_liberacao_credito;
  }

  public void setPed_liberacao_credito(java.lang.String PARAM) {
    this.ped_liberacao_credito = PARAM;
  }

  public java.lang.String getPed_indicador_credito() {
    return ped_indicador_credito;
  }

  public void setPed_indicador_credito(java.lang.String PARAM) {
    this.ped_indicador_credito = PARAM;
  }

  public java.sql.Timestamp getPed_data_prev_ind() {
    return ped_data_prev_ind;
  }

  public void setPed_data_prev_ind(java.sql.Timestamp PARAM) {
    this.ped_data_prev_ind = PARAM;
  }

  public java.sql.Timestamp getPed_data_entra_tonel() {
    return ped_data_entra_tonel;
  }

  public void setPed_data_entra_tonel(java.sql.Timestamp PARAM) {
    this.ped_data_entra_tonel = PARAM;
  }

  public java.lang.String getPed_observacoes_nf() {
    return ped_observacoes_nf;
  }

  public void setPed_observacoes_nf(java.lang.String PARAM) {
    this.ped_observacoes_nf = PARAM;
  }

  public java.lang.String getPed_especie_pedido() {
    return ped_especie_pedido;
  }

  public void setPed_especie_pedido(java.lang.String PARAM) {
    this.ped_especie_pedido = PARAM;
  }

  public java.lang.String getPed_proximo_tonel() {
    return ped_proximo_tonel;
  }

  public void setPed_proximo_tonel(java.lang.String PARAM) {
    this.ped_proximo_tonel = PARAM;
  }

  public java.sql.Timestamp getPed_data_aproximada_fatur() {
    return ped_data_aproximada_fatur;
  }

  public void setPed_data_aproximada_fatur(java.sql.Timestamp PARAM) {
    this.ped_data_aproximada_fatur = PARAM;
  }

  public int getPed_total_pares() {
    return ped_total_pares;
  }

  public void setPed_total_pares(int PARAM) {
    this.ped_total_pares = PARAM;
  }

  public java.lang.String getPed_devolver_repres() {
    return ped_devolver_repres;
  }

  public void setPed_devolver_repres(java.lang.String PARAM) {
    this.ped_devolver_repres = PARAM;
  }

  public java.lang.String getPed_enviado_repres() {
    return ped_enviado_repres;
  }

  public void setPed_enviado_repres(java.lang.String PARAM) {
    this.ped_enviado_repres = PARAM;
  }

  public double getPed_peso_liquido() {
    return ped_peso_liquido;
  }

  public void setPed_peso_liquido(double PARAM) {
    this.ped_peso_liquido = PARAM;
  }

  public double getPed_peso_bruto() {
    return ped_peso_bruto;
  }

  public void setPed_peso_bruto(double PARAM) {
    this.ped_peso_bruto = PARAM;
  }

  public int getCodigo_atendente() {
    return codigo_atendente;
  }

  public void setCodigo_atendente(int PARAM) {
    this.codigo_atendente = PARAM;
  }

  public java.lang.String getPed_marca_segmento() {
    return ped_marca_segmento;
  }

  public void setPed_marca_segmento(java.lang.String PARAM) {
    this.ped_marca_segmento = PARAM;
  }

  public java.lang.String getPed_bloqueio_frete() {
    return ped_bloqueio_frete;
  }

  public void setPed_bloqueio_frete(java.lang.String PARAM) {
    this.ped_bloqueio_frete = PARAM;
  }

  public java.lang.String getPed_substituicao() {
    return ped_substituicao;
  }

  public void setPed_substituicao(java.lang.String PARAM) {
    this.ped_substituicao = PARAM;
  }

  public java.lang.String getPed_pacote() {
    return ped_pacote;
  }

  public void setPed_pacote(java.lang.String PARAM) {
    this.ped_pacote = PARAM;
  }

  public int getOco_numero() {
    return oco_numero;
  }

  public void setOco_numero(int PARAM) {
    this.oco_numero = PARAM;
  }

  public int getCod_min_fabr() {
    return cod_min_fabr;
  }

  public void setCod_min_fabr(int PARAM) {
    this.cod_min_fabr = PARAM;
  }

  public java.lang.String getPed_indic_super() {
    return ped_indic_super;
  }

  public void setPed_indic_super(java.lang.String PARAM) {
    this.ped_indic_super = PARAM;
  }

  public java.sql.Timestamp getPed_data_solicitada_cliente() {
    return ped_data_solicitada_cliente;
  }

  public void setPed_data_solicitada_cliente(java.sql.Timestamp PARAM) {
    this.ped_data_solicitada_cliente = PARAM;
  }

  public java.sql.Timestamp getData_impressao_carta() {
    return data_impressao_carta;
  }

  public void setData_impressao_carta(java.sql.Timestamp PARAM) {
    this.data_impressao_carta = PARAM;
  }

  public java.sql.Timestamp getData_embarque_porto() {
    return data_embarque_porto;
  }

  public void setData_embarque_porto(java.sql.Timestamp PARAM) {
    this.data_embarque_porto = PARAM;
  }

  public java.lang.String getCodigo_representante_adicional() {
    return codigo_representante_adicional;
  }

  public void setCodigo_representante_adicional(java.lang.String PARAM) {
    this.codigo_representante_adicional = PARAM;
  }

  public double getPercentual_comissao_adicional() {
    return percentual_comissao_adicional;
  }

  public void setPercentual_comissao_adicional(double PARAM) {
    this.percentual_comissao_adicional = PARAM;
  }

  public java.lang.String getPed_usuario_liber_credito() {
    return ped_usuario_liber_credito;
  }

  public void setPed_usuario_liber_credito(java.lang.String PARAM) {
    this.ped_usuario_liber_credito = PARAM;
  }

  public java.lang.String getPed_libera_bonif() {
    return ped_libera_bonif;
  }

  public void setPed_libera_bonif(java.lang.String PARAM) {
    this.ped_libera_bonif = PARAM;
  }

  public java.lang.String getPed_empenho_direto() {
    return ped_empenho_direto;
  }

  public void setPed_empenho_direto(java.lang.String PARAM) {
    this.ped_empenho_direto = PARAM;
  }

  public java.lang.String getPed_amostra_brinde() {
    return ped_amostra_brinde;
  }

  public void setPed_amostra_brinde(java.lang.String PARAM) {
    this.ped_amostra_brinde = PARAM;
  }

  public int getLes_codigo() {
    return les_codigo;
  }

  public void setLes_codigo(int PARAM) {
    this.les_codigo = PARAM;
  }

  public java.lang.String getNf_ind_edi() {
    return nf_ind_edi;
  }

  public void setNf_ind_edi(java.lang.String PARAM) {
    this.nf_ind_edi = PARAM;
  }

  public int getAno_carta_credito() {
    return ano_carta_credito;
  }

  public void setAno_carta_credito(int PARAM) {
    this.ano_carta_credito = PARAM;
  }

  public java.lang.String getNumero_carta_credito() {
    return numero_carta_credito;
  }

  public void setNumero_carta_credito(java.lang.String PARAM) {
    this.numero_carta_credito = PARAM;
  }

  public java.lang.String getPed_carta_credito() {
    return ped_carta_credito;
  }

  public void setPed_carta_credito(java.lang.String PARAM) {
    this.ped_carta_credito = PARAM;
  }

  public double getMark_up() {
    return mark_up;
  }

  public void setMark_up(double PARAM) {
    this.mark_up = PARAM;
  }

  public java.sql.Timestamp getAlteracao_sadig() {
    return alteracao_sadig;
  }

  public void setAlteracao_sadig(java.sql.Timestamp PARAM) {
    this.alteracao_sadig = PARAM;
  }

  public int getTipo_expositor1() {
    return tipo_expositor1;
  }

  public void setTipo_expositor1(int PARAM) {
    this.tipo_expositor1 = PARAM;
  }

  public int getQuantidade_expositor1() {
    return quantidade_expositor1;
  }

  public void setQuantidade_expositor1(int PARAM) {
    this.quantidade_expositor1 = PARAM;
  }

  public int getTipo_expositor2() {
    return tipo_expositor2;
  }

  public void setTipo_expositor2(int PARAM) {
    this.tipo_expositor2 = PARAM;
  }

  public int getQuantidade_expositor2() {
    return quantidade_expositor2;
  }

  public void setQuantidade_expositor2(int PARAM) {
    this.quantidade_expositor2 = PARAM;
  }

  public java.lang.String getPed_sequencial_maquina() {
    return ped_sequencial_maquina;
  }

  public void setPed_sequencial_maquina(java.lang.String PARAM) {
    this.ped_sequencial_maquina = PARAM;
  }

  public java.lang.String getPed_flag_credito() {
    return ped_flag_credito;
  }

  public void setPed_flag_credito(java.lang.String PARAM) {
    this.ped_flag_credito = PARAM;
  }

  public java.lang.String getPed_flag_tonel() {
    return ped_flag_tonel;
  }

  public void setPed_flag_tonel(java.lang.String PARAM) {
    this.ped_flag_tonel = PARAM;
  }

  public java.lang.String getPed_flag_estoque() {
    return ped_flag_estoque;
  }

  public void setPed_flag_estoque(java.lang.String PARAM) {
    this.ped_flag_estoque = PARAM;
  }

  public java.lang.String getPed_flag_cotas() {
    return ped_flag_cotas;
  }

  public void setPed_flag_cotas(java.lang.String PARAM) {
    this.ped_flag_cotas = PARAM;
  }

  public java.sql.Timestamp getData_log_afv() {
    return data_log_afv;
  }

  public void setData_log_afv(java.sql.Timestamp PARAM) {
    this.data_log_afv = PARAM;
  }

  public java.lang.String getSinaliza_compra() {
    return sinaliza_compra;
  }

  public void setSinaliza_compra(java.lang.String PARAM) {
    this.sinaliza_compra = PARAM;
  }

  public double getPercentual_comissao_venda() {
    return percentual_comissao_venda;
  }

  public void setPercentual_comissao_venda(double PARAM) {
    this.percentual_comissao_venda = PARAM;
  }

  public double getPercentual_comissao_fat() {
    return percentual_comissao_fat;
  }

  public void setPercentual_comissao_fat(double PARAM) {
    this.percentual_comissao_fat = PARAM;
  }

  public double getPercentual_comissao_neg_tit() {
    return percentual_comissao_neg_tit;
  }

  public void setPercentual_comissao_neg_tit(double PARAM) {
    this.percentual_comissao_neg_tit = PARAM;
  }

  public java.lang.String getPed_codigo_vendedor() {
    return ped_codigo_vendedor;
  }

  public void setPed_codigo_vendedor(java.lang.String PARAM) {
    this.ped_codigo_vendedor = PARAM;
  }

  public java.lang.String getPed_forma_pagamento() {
    return ped_forma_pagamento;
  }

  public void setPed_forma_pagamento(java.lang.String PARAM) {
    this.ped_forma_pagamento = PARAM;
  }

  public double getPed_valor_bloqueto() {
    return ped_valor_bloqueto;
  }

  public void setPed_valor_bloqueto(double PARAM) {
    this.ped_valor_bloqueto = PARAM;
  }

  public double getPercentual_comissao_bonif() {
    return percentual_comissao_bonif;
  }

  public void setPercentual_comissao_bonif(double PARAM) {
    this.percentual_comissao_bonif = PARAM;
  }

  public double getTaxa_vendor_comprador() {
    return taxa_vendor_comprador;
  }

  public void setTaxa_vendor_comprador(double PARAM) {
    this.taxa_vendor_comprador = PARAM;
  }

  public java.lang.String getTipo_kit() {
    return tipo_kit;
  }

  public void setTipo_kit(java.lang.String PARAM) {
    this.tipo_kit = PARAM;
  }

  public java.sql.Timestamp getData_entrega_cliente() {
    return data_entrega_cliente;
  }

  public void setData_entrega_cliente(java.sql.Timestamp PARAM) {
    this.data_entrega_cliente = PARAM;
  }

  public int getTra_cdgo_internar() {
    return tra_cdgo_internar;
  }

  public void setTra_cdgo_internar(int PARAM) {
    this.tra_cdgo_internar = PARAM;
  }

}

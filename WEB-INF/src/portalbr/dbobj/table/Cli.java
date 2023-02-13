package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Cli
  * @version 21/08/2013 11:10:47
  */
public class Cli implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int cli_cdgo;
  private java.lang.String cla_cdgo;
  private int seg_cdgo;
  private java.lang.String cli_situ;
  private java.lang.String cli_rzao;
  private java.lang.String cli_nome;
  private java.sql.Timestamp cli_dtin;
  private java.lang.String cli_tipo;
  private java.sql.Timestamp cli_dult;
  private double cli_vlor;
  private double cli_mvlo;
  private int cli_dias;
  private double cli_totv;
  private double cli_tott;
  private int cli_totq;
  private int cli_prot;
  private double cli_tota;
  private double cli_toqt;
  private java.lang.String niv_cdgo;
  private double cli_limcre;
  private java.sql.Timestamp cli_pricom;
  private java.sql.Timestamp cli_ultpro;
  private double cli_maicom;
  private double cli_dupve5;
  private double cli_dupvm5;
  private double cli_pagpon;
  private double cli_pagatr;
  private double cli_pagcar;
  private double cli_protes;
  private double cli_devolu;
  private double cli_debrep;
  private double cli_atra15;
  private double cli_atrm15;
  private double cli_chqdel;
  private double cli_chqabe;
  private double cli_totpag;
  private double cli_totfat;
  private java.lang.String cli_conta;
  private int cli_qtpagpon;
  private int cli_qtpagatr;
  private int cli_qtpagcar;
  private int cli_qtprotes;
  private int cli_qtdevolu;
  private int cli_qtdebrep;
  private int cli_qtatra15;
  private int cli_qtatrm15;
  private int cli_qtdupve5;
  private int cli_qtdupvm5;
  private int cli_qtchqdev;
  private int cli_qtchqabe;
  private int cli_qtdupabe;
  private double cli_vlultcom;
  private double cli_vlpricom;
  private java.sql.Timestamp cli_dtmaicom;
  private double cli_valor_credito_analista;
  private java.lang.String cli_ind_credito_bloqueado;
  private int blo_codigo_bloqueio;
  private int cli_nro_dias_atraso_credito;
  private java.lang.String cli_banco_obrigatorio;
  private java.lang.String cli_compra_consignada;
  private int cli_dias_tolerancia_atraso;
  private java.lang.String cli_emissao_bloquete;
  private java.lang.String cli_exige_pc;
  private java.lang.String cli_aceita_antecipacao;
  private int cli_dia_vencimento_1;
  private int cli_dia_vencimento_2;
  private int cli_dia_vencimento_3;
  private int cli_dia_vencimento_4;
  private int cli_dia_vencimento_5;
  private java.sql.Timestamp cli_data_recadastramento;
  private java.lang.String emp_empresa;
  private java.lang.String cli_observacao;
  private java.lang.String cli_bloqueio_credito;
  private java.lang.String cli_aceita_antecipacao_allegro;
  private java.lang.String codigo_representante_abertura;
  private java.lang.String cli_carta_cobranca;
  private java.lang.String cli_agrupa_notas;
  private java.lang.String cli_tipo_mercado;
  private double cli_desconto;
  private java.lang.String cli_obsfatura;
  private java.lang.String cli_obspack;
  private int cli_qtpedcanc;
  private double cli_vlpedcanc;
  private int cli_qtcheliq;
  private double cli_vlcheliq;
  private double cpf_proprietario;
  private java.lang.String cli_aceita_antecipacao_riva;
  private int codigo_motivo;
  private java.sql.Timestamp data_ultima_alteracao;
  private java.sql.Date cli_data_reativacao;

  public Cli() {
  }

  public int getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(int PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.String getCla_cdgo() {
    return cla_cdgo;
  }

  public void setCla_cdgo(java.lang.String PARAM) {
    this.cla_cdgo = PARAM;
  }

  public int getSeg_cdgo() {
    return seg_cdgo;
  }

  public void setSeg_cdgo(int PARAM) {
    this.seg_cdgo = PARAM;
  }

  public java.lang.String getCli_situ() {
    return cli_situ;
  }

  public void setCli_situ(java.lang.String PARAM) {
    this.cli_situ = PARAM;
  }

  public java.lang.String getCli_rzao() {
    return cli_rzao;
  }

  public void setCli_rzao(java.lang.String PARAM) {
    this.cli_rzao = PARAM;
  }

  public java.lang.String getCli_nome() {
    return cli_nome;
  }

  public void setCli_nome(java.lang.String PARAM) {
    this.cli_nome = PARAM;
  }

  public java.sql.Timestamp getCli_dtin() {
    return cli_dtin;
  }

  public void setCli_dtin(java.sql.Timestamp PARAM) {
    this.cli_dtin = PARAM;
  }

  public java.lang.String getCli_tipo() {
    return cli_tipo;
  }

  public void setCli_tipo(java.lang.String PARAM) {
    this.cli_tipo = PARAM;
  }

  public java.sql.Timestamp getCli_dult() {
    return cli_dult;
  }

  public void setCli_dult(java.sql.Timestamp PARAM) {
    this.cli_dult = PARAM;
  }

  public double getCli_vlor() {
    return cli_vlor;
  }

  public void setCli_vlor(double PARAM) {
    this.cli_vlor = PARAM;
  }

  public double getCli_mvlo() {
    return cli_mvlo;
  }

  public void setCli_mvlo(double PARAM) {
    this.cli_mvlo = PARAM;
  }

  public int getCli_dias() {
    return cli_dias;
  }

  public void setCli_dias(int PARAM) {
    this.cli_dias = PARAM;
  }

  public double getCli_totv() {
    return cli_totv;
  }

  public void setCli_totv(double PARAM) {
    this.cli_totv = PARAM;
  }

  public double getCli_tott() {
    return cli_tott;
  }

  public void setCli_tott(double PARAM) {
    this.cli_tott = PARAM;
  }

  public int getCli_totq() {
    return cli_totq;
  }

  public void setCli_totq(int PARAM) {
    this.cli_totq = PARAM;
  }

  public int getCli_prot() {
    return cli_prot;
  }

  public void setCli_prot(int PARAM) {
    this.cli_prot = PARAM;
  }

  public double getCli_tota() {
    return cli_tota;
  }

  public void setCli_tota(double PARAM) {
    this.cli_tota = PARAM;
  }

  public double getCli_toqt() {
    return cli_toqt;
  }

  public void setCli_toqt(double PARAM) {
    this.cli_toqt = PARAM;
  }

  public java.lang.String getNiv_cdgo() {
    return niv_cdgo;
  }

  public void setNiv_cdgo(java.lang.String PARAM) {
    this.niv_cdgo = PARAM;
  }

  public double getCli_limcre() {
    return cli_limcre;
  }

  public void setCli_limcre(double PARAM) {
    this.cli_limcre = PARAM;
  }

  public java.sql.Timestamp getCli_pricom() {
    return cli_pricom;
  }

  public void setCli_pricom(java.sql.Timestamp PARAM) {
    this.cli_pricom = PARAM;
  }

  public java.sql.Timestamp getCli_ultpro() {
    return cli_ultpro;
  }

  public void setCli_ultpro(java.sql.Timestamp PARAM) {
    this.cli_ultpro = PARAM;
  }

  public double getCli_maicom() {
    return cli_maicom;
  }

  public void setCli_maicom(double PARAM) {
    this.cli_maicom = PARAM;
  }

  public double getCli_dupve5() {
    return cli_dupve5;
  }

  public void setCli_dupve5(double PARAM) {
    this.cli_dupve5 = PARAM;
  }

  public double getCli_dupvm5() {
    return cli_dupvm5;
  }

  public void setCli_dupvm5(double PARAM) {
    this.cli_dupvm5 = PARAM;
  }

  public double getCli_pagpon() {
    return cli_pagpon;
  }

  public void setCli_pagpon(double PARAM) {
    this.cli_pagpon = PARAM;
  }

  public double getCli_pagatr() {
    return cli_pagatr;
  }

  public void setCli_pagatr(double PARAM) {
    this.cli_pagatr = PARAM;
  }

  public double getCli_pagcar() {
    return cli_pagcar;
  }

  public void setCli_pagcar(double PARAM) {
    this.cli_pagcar = PARAM;
  }

  public double getCli_protes() {
    return cli_protes;
  }

  public void setCli_protes(double PARAM) {
    this.cli_protes = PARAM;
  }

  public double getCli_devolu() {
    return cli_devolu;
  }

  public void setCli_devolu(double PARAM) {
    this.cli_devolu = PARAM;
  }

  public double getCli_debrep() {
    return cli_debrep;
  }

  public void setCli_debrep(double PARAM) {
    this.cli_debrep = PARAM;
  }

  public double getCli_atra15() {
    return cli_atra15;
  }

  public void setCli_atra15(double PARAM) {
    this.cli_atra15 = PARAM;
  }

  public double getCli_atrm15() {
    return cli_atrm15;
  }

  public void setCli_atrm15(double PARAM) {
    this.cli_atrm15 = PARAM;
  }

  public double getCli_chqdel() {
    return cli_chqdel;
  }

  public void setCli_chqdel(double PARAM) {
    this.cli_chqdel = PARAM;
  }

  public double getCli_chqabe() {
    return cli_chqabe;
  }

  public void setCli_chqabe(double PARAM) {
    this.cli_chqabe = PARAM;
  }

  public double getCli_totpag() {
    return cli_totpag;
  }

  public void setCli_totpag(double PARAM) {
    this.cli_totpag = PARAM;
  }

  public double getCli_totfat() {
    return cli_totfat;
  }

  public void setCli_totfat(double PARAM) {
    this.cli_totfat = PARAM;
  }

  public java.lang.String getCli_conta() {
    return cli_conta;
  }

  public void setCli_conta(java.lang.String PARAM) {
    this.cli_conta = PARAM;
  }

  public int getCli_qtpagpon() {
    return cli_qtpagpon;
  }

  public void setCli_qtpagpon(int PARAM) {
    this.cli_qtpagpon = PARAM;
  }

  public int getCli_qtpagatr() {
    return cli_qtpagatr;
  }

  public void setCli_qtpagatr(int PARAM) {
    this.cli_qtpagatr = PARAM;
  }

  public int getCli_qtpagcar() {
    return cli_qtpagcar;
  }

  public void setCli_qtpagcar(int PARAM) {
    this.cli_qtpagcar = PARAM;
  }

  public int getCli_qtprotes() {
    return cli_qtprotes;
  }

  public void setCli_qtprotes(int PARAM) {
    this.cli_qtprotes = PARAM;
  }

  public int getCli_qtdevolu() {
    return cli_qtdevolu;
  }

  public void setCli_qtdevolu(int PARAM) {
    this.cli_qtdevolu = PARAM;
  }

  public int getCli_qtdebrep() {
    return cli_qtdebrep;
  }

  public void setCli_qtdebrep(int PARAM) {
    this.cli_qtdebrep = PARAM;
  }

  public int getCli_qtatra15() {
    return cli_qtatra15;
  }

  public void setCli_qtatra15(int PARAM) {
    this.cli_qtatra15 = PARAM;
  }

  public int getCli_qtatrm15() {
    return cli_qtatrm15;
  }

  public void setCli_qtatrm15(int PARAM) {
    this.cli_qtatrm15 = PARAM;
  }

  public int getCli_qtdupve5() {
    return cli_qtdupve5;
  }

  public void setCli_qtdupve5(int PARAM) {
    this.cli_qtdupve5 = PARAM;
  }

  public int getCli_qtdupvm5() {
    return cli_qtdupvm5;
  }

  public void setCli_qtdupvm5(int PARAM) {
    this.cli_qtdupvm5 = PARAM;
  }

  public int getCli_qtchqdev() {
    return cli_qtchqdev;
  }

  public void setCli_qtchqdev(int PARAM) {
    this.cli_qtchqdev = PARAM;
  }

  public int getCli_qtchqabe() {
    return cli_qtchqabe;
  }

  public void setCli_qtchqabe(int PARAM) {
    this.cli_qtchqabe = PARAM;
  }

  public int getCli_qtdupabe() {
    return cli_qtdupabe;
  }

  public void setCli_qtdupabe(int PARAM) {
    this.cli_qtdupabe = PARAM;
  }

  public double getCli_vlultcom() {
    return cli_vlultcom;
  }

  public void setCli_vlultcom(double PARAM) {
    this.cli_vlultcom = PARAM;
  }

  public double getCli_vlpricom() {
    return cli_vlpricom;
  }

  public void setCli_vlpricom(double PARAM) {
    this.cli_vlpricom = PARAM;
  }

  public java.sql.Timestamp getCli_dtmaicom() {
    return cli_dtmaicom;
  }

  public void setCli_dtmaicom(java.sql.Timestamp PARAM) {
    this.cli_dtmaicom = PARAM;
  }

  public double getCli_valor_credito_analista() {
    return cli_valor_credito_analista;
  }

  public void setCli_valor_credito_analista(double PARAM) {
    this.cli_valor_credito_analista = PARAM;
  }

  public java.lang.String getCli_ind_credito_bloqueado() {
    return cli_ind_credito_bloqueado;
  }

  public void setCli_ind_credito_bloqueado(java.lang.String PARAM) {
    this.cli_ind_credito_bloqueado = PARAM;
  }

  public int getBlo_codigo_bloqueio() {
    return blo_codigo_bloqueio;
  }

  public void setBlo_codigo_bloqueio(int PARAM) {
    this.blo_codigo_bloqueio = PARAM;
  }

  public int getCli_nro_dias_atraso_credito() {
    return cli_nro_dias_atraso_credito;
  }

  public void setCli_nro_dias_atraso_credito(int PARAM) {
    this.cli_nro_dias_atraso_credito = PARAM;
  }

  public java.lang.String getCli_banco_obrigatorio() {
    return cli_banco_obrigatorio;
  }

  public void setCli_banco_obrigatorio(java.lang.String PARAM) {
    this.cli_banco_obrigatorio = PARAM;
  }

  public java.lang.String getCli_compra_consignada() {
    return cli_compra_consignada;
  }

  public void setCli_compra_consignada(java.lang.String PARAM) {
    this.cli_compra_consignada = PARAM;
  }

  public int getCli_dias_tolerancia_atraso() {
    return cli_dias_tolerancia_atraso;
  }

  public void setCli_dias_tolerancia_atraso(int PARAM) {
    this.cli_dias_tolerancia_atraso = PARAM;
  }

  public java.lang.String getCli_emissao_bloquete() {
    return cli_emissao_bloquete;
  }

  public void setCli_emissao_bloquete(java.lang.String PARAM) {
    this.cli_emissao_bloquete = PARAM;
  }

  public java.lang.String getCli_exige_pc() {
    return cli_exige_pc;
  }

  public void setCli_exige_pc(java.lang.String PARAM) {
    this.cli_exige_pc = PARAM;
  }

  public java.lang.String getCli_aceita_antecipacao() {
    return cli_aceita_antecipacao;
  }

  public void setCli_aceita_antecipacao(java.lang.String PARAM) {
    this.cli_aceita_antecipacao = PARAM;
  }

  public int getCli_dia_vencimento_1() {
    return cli_dia_vencimento_1;
  }

  public void setCli_dia_vencimento_1(int PARAM) {
    this.cli_dia_vencimento_1 = PARAM;
  }

  public int getCli_dia_vencimento_2() {
    return cli_dia_vencimento_2;
  }

  public void setCli_dia_vencimento_2(int PARAM) {
    this.cli_dia_vencimento_2 = PARAM;
  }

  public int getCli_dia_vencimento_3() {
    return cli_dia_vencimento_3;
  }

  public void setCli_dia_vencimento_3(int PARAM) {
    this.cli_dia_vencimento_3 = PARAM;
  }

  public int getCli_dia_vencimento_4() {
    return cli_dia_vencimento_4;
  }

  public void setCli_dia_vencimento_4(int PARAM) {
    this.cli_dia_vencimento_4 = PARAM;
  }

  public int getCli_dia_vencimento_5() {
    return cli_dia_vencimento_5;
  }

  public void setCli_dia_vencimento_5(int PARAM) {
    this.cli_dia_vencimento_5 = PARAM;
  }

  public java.sql.Timestamp getCli_data_recadastramento() {
    return cli_data_recadastramento;
  }

  public void setCli_data_recadastramento(java.sql.Timestamp PARAM) {
    this.cli_data_recadastramento = PARAM;
  }

  public java.lang.String getEmp_empresa() {
    return emp_empresa;
  }

  public void setEmp_empresa(java.lang.String PARAM) {
    this.emp_empresa = PARAM;
  }

  public java.lang.String getCli_observacao() {
    return cli_observacao;
  }

  public void setCli_observacao(java.lang.String PARAM) {
    this.cli_observacao = PARAM;
  }

  public java.lang.String getCli_bloqueio_credito() {
    return cli_bloqueio_credito;
  }

  public void setCli_bloqueio_credito(java.lang.String PARAM) {
    this.cli_bloqueio_credito = PARAM;
  }

  public java.lang.String getCli_aceita_antecipacao_allegro() {
    return cli_aceita_antecipacao_allegro;
  }

  public void setCli_aceita_antecipacao_allegro(java.lang.String PARAM) {
    this.cli_aceita_antecipacao_allegro = PARAM;
  }

  public java.lang.String getCodigo_representante_abertura() {
    return codigo_representante_abertura;
  }

  public void setCodigo_representante_abertura(java.lang.String PARAM) {
    this.codigo_representante_abertura = PARAM;
  }

  public java.lang.String getCli_carta_cobranca() {
    return cli_carta_cobranca;
  }

  public void setCli_carta_cobranca(java.lang.String PARAM) {
    this.cli_carta_cobranca = PARAM;
  }

  public java.lang.String getCli_agrupa_notas() {
    return cli_agrupa_notas;
  }

  public void setCli_agrupa_notas(java.lang.String PARAM) {
    this.cli_agrupa_notas = PARAM;
  }

  public java.lang.String getCli_tipo_mercado() {
    return cli_tipo_mercado;
  }

  public void setCli_tipo_mercado(java.lang.String PARAM) {
    this.cli_tipo_mercado = PARAM;
  }

  public double getCli_desconto() {
    return cli_desconto;
  }

  public void setCli_desconto(double PARAM) {
    this.cli_desconto = PARAM;
  }

  public java.lang.String getCli_obsfatura() {
    return cli_obsfatura;
  }

  public void setCli_obsfatura(java.lang.String PARAM) {
    this.cli_obsfatura = PARAM;
  }

  public java.lang.String getCli_obspack() {
    return cli_obspack;
  }

  public void setCli_obspack(java.lang.String PARAM) {
    this.cli_obspack = PARAM;
  }

  public int getCli_qtpedcanc() {
    return cli_qtpedcanc;
  }

  public void setCli_qtpedcanc(int PARAM) {
    this.cli_qtpedcanc = PARAM;
  }

  public double getCli_vlpedcanc() {
    return cli_vlpedcanc;
  }

  public void setCli_vlpedcanc(double PARAM) {
    this.cli_vlpedcanc = PARAM;
  }

  public int getCli_qtcheliq() {
    return cli_qtcheliq;
  }

  public void setCli_qtcheliq(int PARAM) {
    this.cli_qtcheliq = PARAM;
  }

  public double getCli_vlcheliq() {
    return cli_vlcheliq;
  }

  public void setCli_vlcheliq(double PARAM) {
    this.cli_vlcheliq = PARAM;
  }

  public double getCpf_proprietario() {
    return cpf_proprietario;
  }

  public void setCpf_proprietario(double PARAM) {
    this.cpf_proprietario = PARAM;
  }

  public java.lang.String getCli_aceita_antecipacao_riva() {
    return cli_aceita_antecipacao_riva;
  }

  public void setCli_aceita_antecipacao_riva(java.lang.String PARAM) {
    this.cli_aceita_antecipacao_riva = PARAM;
  }

  public int getCodigo_motivo() {
    return codigo_motivo;
  }

  public void setCodigo_motivo(int PARAM) {
    this.codigo_motivo = PARAM;
  }

  public java.sql.Timestamp getData_ultima_alteracao() {
    return data_ultima_alteracao;
  }

  public void setData_ultima_alteracao(java.sql.Timestamp PARAM) {
    this.data_ultima_alteracao = PARAM;
  }

  public java.sql.Date getCli_data_reativacao() {
    return cli_data_reativacao;
  }

  public void setCli_data_reativacao(java.sql.Date PARAM) {
    this.cli_data_reativacao = PARAM;
  }

}

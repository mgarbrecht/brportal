package portalbr.dbobj.view;

/** DataBase Object from table .Jw_limite_credito_disponivel
  * @version 03/04/2013 09:26:30
  */
public class Jw_limite_credito_disponivel implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String cli_codigo;
  private java.lang.String cli_rzao;
  private java.lang.String grupo_economico;
  private double valor_analista;
  private double valor_saldo;
  private double disponivel;
  private double perc;
  private java.lang.String rep_cdgo;
  private java.lang.String rep_rzao;
  private java.lang.String codigo_regional;
  private java.lang.String nome_regional;

  public Jw_limite_credito_disponivel() {
  }

  public java.lang.String getCli_codigo() {
    return cli_codigo;
  }

  public void setCli_codigo(java.lang.String PARAM) {
    this.cli_codigo = PARAM;
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

  public double getValor_analista() {
    return valor_analista;
  }

  public void setValor_analista(double PARAM) {
    this.valor_analista = PARAM;
  }

  public double getValor_saldo() {
    return valor_saldo;
  }

  public void setValor_saldo(double PARAM) {
    this.valor_saldo = PARAM;
  }

  public double getDisponivel() {
    return disponivel;
  }

  public void setDisponivel(double PARAM) {
    this.disponivel = PARAM;
  }

  public double getPerc() {
    return perc;
  }

  public void setPerc(double PARAM) {
    this.perc = PARAM;
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

  public java.lang.String getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.String PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getNome_regional() {
    return nome_regional;
  }

  public void setNome_regional(java.lang.String PARAM) {
    this.nome_regional = PARAM;
  }

}

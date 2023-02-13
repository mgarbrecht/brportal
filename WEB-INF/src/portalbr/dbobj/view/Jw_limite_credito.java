package portalbr.dbobj.view;

/** DataBase Object from table .Jw_limite_credito
  * @version 19/12/2016 09:34:52
  */
public class Jw_limite_credito implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo_regional;
  private java.lang.String nome_regional;
  private java.lang.String rep_cdgo;
  private java.lang.String rep_rzao;
  private java.lang.Integer cli_cdgo;
  private java.lang.String cli_rzao;
  private double limite;
  private java.lang.String situacao;
  private java.lang.String situacao_cr;

  public Jw_limite_credito() {
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

  public java.lang.String getRep_rzao() {
    return rep_rzao;
  }

  public void setRep_rzao(java.lang.String PARAM) {
    this.rep_rzao = PARAM;
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

  public double getLimite() {
    return limite;
  }

  public void setLimite(double PARAM) {
    this.limite = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

  public java.lang.String getSituacao_cr() {
    return situacao_cr;
  }

  public void setSituacao_cr(java.lang.String PARAM) {
    this.situacao_cr = PARAM;
  }

}

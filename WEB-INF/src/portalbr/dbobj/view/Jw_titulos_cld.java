package portalbr.dbobj.view;

/** DataBase Object from table .Jw_titulos_cld
  * @version 05/07/2010 07:07:51
  */
public class Jw_titulos_cld implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String codigo_reg;
  private java.lang.String nome_regional;
  private java.lang.String rep_cdgo;
  private java.lang.String rep_rzao;
  private java.lang.String codigo_analista;
  private java.lang.String nome_analista;
  private java.lang.String cli_cdgo;
  private java.lang.String cli_rzao;
  private java.lang.String titulo;
  private java.sql.Timestamp data_venc;
  private java.sql.Timestamp data_emissao;
  private double valor_cld;
  private double vlpcp;
  private double vldeb;
  private double saldo;

  public Jw_titulos_cld() {
  }

  public java.lang.String getCodigo_reg() {
    return codigo_reg;
  }

  public void setCodigo_reg(java.lang.String PARAM) {
    this.codigo_reg = PARAM;
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

  public java.lang.String getCodigo_analista() {
    return codigo_analista;
  }

  public void setCodigo_analista(java.lang.String PARAM) {
    this.codigo_analista = PARAM;
  }

  public java.lang.String getNome_analista() {
    return nome_analista;
  }

  public void setNome_analista(java.lang.String PARAM) {
    this.nome_analista = PARAM;
  }

  public java.lang.String getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.String PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.String getCli_rzao() {
    return cli_rzao;
  }

  public void setCli_rzao(java.lang.String PARAM) {
    this.cli_rzao = PARAM;
  }

  public java.lang.String getTitulo() {
    return titulo;
  }

  public void setTitulo(java.lang.String PARAM) {
    this.titulo = PARAM;
  }

  public java.sql.Timestamp getData_venc() {
    return data_venc;
  }

  public void setData_venc(java.sql.Timestamp PARAM) {
    this.data_venc = PARAM;
  }

  public java.sql.Timestamp getData_emissao() {
    return data_emissao;
  }

  public void setData_emissao(java.sql.Timestamp PARAM) {
    this.data_emissao = PARAM;
  }

  public double getValor_cld() {
    return valor_cld;
  }

  public void setValor_cld(double PARAM) {
    this.valor_cld = PARAM;
  }

  public double getVlpcp() {
    return vlpcp;
  }

  public void setVlpcp(double PARAM) {
    this.vlpcp = PARAM;
  }

  public double getVldeb() {
    return vldeb;
  }

  public void setVldeb(double PARAM) {
    this.vldeb = PARAM;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double PARAM) {
    this.saldo = PARAM;
  }

}

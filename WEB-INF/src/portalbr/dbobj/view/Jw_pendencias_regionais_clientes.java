package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pendencias_regionais_clientes
  * @version 03/04/2013 09:18:52
  */
public class Jw_pendencias_regionais_clientes implements java.io.Serializable, com.egen.util.jdbc.View {
  private int codigo_regional;
  private java.lang.String nome_regional;
  private java.lang.String rep_cdgo;
  private java.lang.String rep_nome;
  private java.lang.String rep_situ;
  private int cli_cdgo;
  private java.lang.String cli_rzao;
  private double vencido;
  private double vencer;
  private double percentual;

  public Jw_pendencias_regionais_clientes() {
  }

  public int getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(int PARAM) {
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

  public java.lang.String getRep_nome() {
    return rep_nome;
  }

  public void setRep_nome(java.lang.String PARAM) {
    this.rep_nome = PARAM;
  }

  public java.lang.String getRep_situ() {
    return rep_situ;
  }

  public void setRep_situ(java.lang.String PARAM) {
    this.rep_situ = PARAM;
  }

  public int getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(int PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.String getCli_rzao() {
    return cli_rzao;
  }

  public void setCli_rzao(java.lang.String PARAM) {
    this.cli_rzao = PARAM;
  }

  public double getVencido() {
    return vencido;
  }

  public void setVencido(double PARAM) {
    this.vencido = PARAM;
  }

  public double getVencer() {
    return vencer;
  }

  public void setVencer(double PARAM) {
    this.vencer = PARAM;
  }

  public double getPercentual() {
    return percentual;
  }

  public void setPercentual(double PARAM) {
    this.percentual = PARAM;
  }

}

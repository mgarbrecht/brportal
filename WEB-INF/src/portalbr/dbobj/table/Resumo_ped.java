package portalbr.dbobj.table;

/** DataBase Object from table ACESSO.Resumo_ped
  * @version 05/08/2014 12:03:36
  */
public class Resumo_ped implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int cli_cdgo;
  private int esc_seqn;
  private java.lang.String rep_cdgo;
  private java.sql.Timestamp data_dig;
  private int codigo_marca;
  private double pares;
  private double valor;
  private int codigo_regional;
  private int lin_cdgo;
  private int ref_cdgo;
  private java.lang.String ped_tipo;

  public Resumo_ped() {
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

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

  public java.sql.Timestamp getData_dig() {
    return data_dig;
  }

  public void setData_dig(java.sql.Timestamp PARAM) {
    this.data_dig = PARAM;
  }

  public int getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(int PARAM) {
    this.codigo_marca = PARAM;
  }

  public double getPares() {
    return pares;
  }

  public void setPares(double PARAM) {
    this.pares = PARAM;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double PARAM) {
    this.valor = PARAM;
  }

  public int getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(int PARAM) {
    this.codigo_regional = PARAM;
  }

  public int getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(int PARAM) {
    this.lin_cdgo = PARAM;
  }

  public int getRef_cdgo() {
    return ref_cdgo;
  }

  public void setRef_cdgo(int PARAM) {
    this.ref_cdgo = PARAM;
  }

  public java.lang.String getPed_tipo() {
    return ped_tipo;
  }

  public void setPed_tipo(java.lang.String PARAM) {
    this.ped_tipo = PARAM;
  }

}

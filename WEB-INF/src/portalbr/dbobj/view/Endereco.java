package portalbr.dbobj.view;

/** DataBase Object from table .Endereco
  * @version 03/05/2018 10:07:09
  */
public class Endereco implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String cli_cdgo;
  private java.lang.String esc_seqn;
  private java.lang.String ecl_cdad;
  private java.lang.String cnpj;
  private java.lang.String endereco;

  public Endereco() {
  }

  public java.lang.String getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.String PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.String getEsc_seqn() {
    return esc_seqn;
  }

  public void setEsc_seqn(java.lang.String PARAM) {
    this.esc_seqn = PARAM;
  }

  public java.lang.String getEcl_cdad() {
    return ecl_cdad;
  }

  public void setEcl_cdad(java.lang.String PARAM) {
    this.ecl_cdad = PARAM;
  }

  public java.lang.String getCnpj() {
    return cnpj;
  }

  public void setCnpj(java.lang.String PARAM) {
    this.cnpj = PARAM;
  }

  public java.lang.String getEndereco() {
    return endereco;
  }

  public void setEndereco(java.lang.String PARAM) {
    this.endereco = PARAM;
  }

}

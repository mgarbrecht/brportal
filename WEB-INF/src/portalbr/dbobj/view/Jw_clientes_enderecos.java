package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_enderecos
  * @version 06/03/2018 10:34:27
  */
public class Jw_clientes_enderecos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String cli_cdgo;
  private java.lang.String esc_seqn;
  private java.lang.String ned_cdgo;
  private java.lang.String endereco;
  private java.lang.String cep;
  private java.lang.String bairro_cidade;
  private java.lang.String pais;

  public Jw_clientes_enderecos() {
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

  public java.lang.String getNed_cdgo() {
    return ned_cdgo;
  }

  public void setNed_cdgo(java.lang.String PARAM) {
    this.ned_cdgo = PARAM;
  }

  public java.lang.String getEndereco() {
    return endereco;
  }

  public void setEndereco(java.lang.String PARAM) {
    this.endereco = PARAM;
  }

  public java.lang.String getCep() {
    return cep;
  }

  public void setCep(java.lang.String PARAM) {
    this.cep = PARAM;
  }

  public java.lang.String getBairro_cidade() {
    return bairro_cidade;
  }

  public void setBairro_cidade(java.lang.String PARAM) {
    this.bairro_cidade = PARAM;
  }

  public java.lang.String getPais() {
    return pais;
  }

  public void setPais(java.lang.String PARAM) {
    this.pais = PARAM;
  }

}

package portalbr.dbobj.view;

/** DataBase Object from table .Jw_poi
  * @version 03/04/2013 09:18:10
  */
public class Jw_poi implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo_regional;
  private java.lang.String nome_regional;
  private java.lang.Integer codigo_gerente;
  private java.lang.String nome_gerente;
  private java.lang.String endereco;
  private java.lang.String estado_gerente;
  private java.lang.String unidade_negocio;
  private java.lang.String unn_descri;

  public Jw_poi() {
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

  public java.lang.Integer getCodigo_gerente() {
    return codigo_gerente;
  }

  public void setCodigo_gerente(java.lang.Integer PARAM) {
    this.codigo_gerente = PARAM;
  }

  public java.lang.String getNome_gerente() {
    return nome_gerente;
  }

  public void setNome_gerente(java.lang.String PARAM) {
    this.nome_gerente = PARAM;
  }

  public java.lang.String getEndereco() {
    return endereco;
  }

  public void setEndereco(java.lang.String PARAM) {
    this.endereco = PARAM;
  }

  public java.lang.String getEstado_gerente() {
    return estado_gerente;
  }

  public void setEstado_gerente(java.lang.String PARAM) {
    this.estado_gerente = PARAM;
  }

  public java.lang.String getUnidade_negocio() {
    return unidade_negocio;
  }

  public void setUnidade_negocio(java.lang.String PARAM) {
    this.unidade_negocio = PARAM;
  }

  public java.lang.String getUnn_descri() {
    return unn_descri;
  }

  public void setUnn_descri(java.lang.String PARAM) {
    this.unn_descri = PARAM;
  }

}

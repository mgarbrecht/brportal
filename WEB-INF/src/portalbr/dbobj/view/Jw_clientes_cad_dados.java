package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_cad_dados
  * @version 03/04/2013 09:47:04
  */
public class Jw_clientes_cad_dados implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String codigo_representante;
  private java.lang.String representante;
  private java.lang.String marca;
  private java.lang.String sit_cli_rep;
  private java.lang.String marcas;

  public Jw_clientes_cad_dados() {
  }

  public java.lang.String getCodigo_representante() {
    return codigo_representante;
  }

  public void setCodigo_representante(java.lang.String PARAM) {
    this.codigo_representante = PARAM;
  }

  public java.lang.String getRepresentante() {
    return representante;
  }

  public void setRepresentante(java.lang.String PARAM) {
    this.representante = PARAM;
  }

  public java.lang.String getMarca() {
    return marca;
  }

  public void setMarca(java.lang.String PARAM) {
    this.marca = PARAM;
  }

  public java.lang.String getSit_cli_rep() {
    return sit_cli_rep;
  }

  public void setSit_cli_rep(java.lang.String PARAM) {
    this.sit_cli_rep = PARAM;
  }

  public java.lang.String getMarcas() {
    return marcas;
  }

  public void setMarcas(java.lang.String PARAM) {
    this.marcas = PARAM;
  }

}

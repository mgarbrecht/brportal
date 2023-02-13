package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_representantes
  * @version 03/04/2013 09:42:47
  */
public class Jw_clientes_representantes implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String codigo_cliente;
  private java.lang.String codigo_representante;
  private java.lang.String representante;
  private java.lang.String rep_nome;
  private java.lang.String marca;
  private java.lang.String telefone;

  public Jw_clientes_representantes() {
  }

  public java.lang.String getCodigo_cliente() {
    return codigo_cliente;
  }

  public void setCodigo_cliente(java.lang.String PARAM) {
    this.codigo_cliente = PARAM;
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

  public java.lang.String getRep_nome() {
    return rep_nome;
  }

  public void setRep_nome(java.lang.String PARAM) {
    this.rep_nome = PARAM;
  }

  public java.lang.String getMarca() {
    return marca;
  }

  public void setMarca(java.lang.String PARAM) {
    this.marca = PARAM;
  }

  public java.lang.String getTelefone() {
    return telefone;
  }

  public void setTelefone(java.lang.String PARAM) {
    this.telefone = PARAM;
  }

}

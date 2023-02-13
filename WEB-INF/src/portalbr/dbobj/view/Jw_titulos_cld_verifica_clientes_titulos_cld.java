package portalbr.dbobj.view;

/** DataBase Object from table .Jw_titulos_cld_verifica_clientes_titulos_cld
  * @version 05/07/2010 07:07:24
  */
public class Jw_titulos_cld_verifica_clientes_titulos_cld implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String cod_cliente;
  private java.lang.String cliente;

  public Jw_titulos_cld_verifica_clientes_titulos_cld() {
  }

  public java.lang.String getCod_cliente() {
    return cod_cliente;
  }

  public void setCod_cliente(java.lang.String PARAM) {
    this.cod_cliente = PARAM;
  }

  public java.lang.String getCliente() {
    return cliente;
  }

  public void setCliente(java.lang.String PARAM) {
    this.cliente = PARAM;
  }

}

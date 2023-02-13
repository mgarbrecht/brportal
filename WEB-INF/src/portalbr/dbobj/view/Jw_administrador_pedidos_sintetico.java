package portalbr.dbobj.view;

/** DataBase Object from table .Jw_administrador_pedidos_sintetico
  * @version 29/08/2022 12:42:35
  */
public class Jw_administrador_pedidos_sintetico implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer lin_cdgo;
  private java.lang.String lin_nome;
  private java.sql.Date data_inicial;

  public Jw_administrador_pedidos_sintetico() {
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.String getLin_nome() {
    return lin_nome;
  }

  public void setLin_nome(java.lang.String PARAM) {
    this.lin_nome = PARAM;
  }

  public java.sql.Date getData_inicial() {
    return data_inicial;
  }

  public void setData_inicial(java.sql.Date PARAM) {
    this.data_inicial = PARAM;
  }

}

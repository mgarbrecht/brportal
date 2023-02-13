package portalbr.dbobj.view;

/** DataBase Object from table .Jw_data_ultima_compra
  * @version 03/04/2013 09:31:35
  */
public class Jw_data_ultima_compra implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.sql.Timestamp data_ultima_compra;

  public Jw_data_ultima_compra() {
  }

  public java.sql.Timestamp getData_ultima_compra() {
    return data_ultima_compra;
  }

  public void setData_ultima_compra(java.sql.Timestamp PARAM) {
    this.data_ultima_compra = PARAM;
  }

}

package portalbr.dbobj.view;

/** DataBase Object from table .Jw_orders_status
  * @version 05/07/2010 07:20:01
  */
public class Jw_orders_status implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String orders_status_id;
  private java.lang.String language_id;
  private java.lang.String orders_status_name;

  public Jw_orders_status() {
  }

  public java.lang.String getOrders_status_id() {
    return orders_status_id;
  }

  public void setOrders_status_id(java.lang.String PARAM) {
    this.orders_status_id = PARAM;
  }

  public java.lang.String getLanguage_id() {
    return language_id;
  }

  public void setLanguage_id(java.lang.String PARAM) {
    this.language_id = PARAM;
  }

  public java.lang.String getOrders_status_name() {
    return orders_status_name;
  }

  public void setOrders_status_name(java.lang.String PARAM) {
    this.orders_status_name = PARAM;
  }

}

package portalbr.dbobj.view;

/** DataBase Object from table .Jw_orders_customers
  * @version 05/07/2010 07:20:12
  */
public class Jw_orders_customers implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String orders_id;
  private java.lang.String customers_id;
  private java.lang.String customers_name;
  private java.lang.String cracha;
  private java.lang.String filial;
  private java.lang.String orders_status;

  public Jw_orders_customers() {
  }

  public java.lang.String getOrders_id() {
    return orders_id;
  }

  public void setOrders_id(java.lang.String PARAM) {
    this.orders_id = PARAM;
  }

  public java.lang.String getCustomers_id() {
    return customers_id;
  }

  public void setCustomers_id(java.lang.String PARAM) {
    this.customers_id = PARAM;
  }

  public java.lang.String getCustomers_name() {
    return customers_name;
  }

  public void setCustomers_name(java.lang.String PARAM) {
    this.customers_name = PARAM;
  }

  public java.lang.String getCracha() {
    return cracha;
  }

  public void setCracha(java.lang.String PARAM) {
    this.cracha = PARAM;
  }

  public java.lang.String getFilial() {
    return filial;
  }

  public void setFilial(java.lang.String PARAM) {
    this.filial = PARAM;
  }

  public java.lang.String getOrders_status() {
    return orders_status;
  }

  public void setOrders_status(java.lang.String PARAM) {
    this.orders_status = PARAM;
  }

}

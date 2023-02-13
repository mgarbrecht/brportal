package portalbr.dbobj.view;

/** DataBase Object from table .Jw_transacao
  * @version 05/07/2010 07:05:59
  */
public class Jw_transacao implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String trn_codigo;
  private java.sql.Timestamp mov_data;

  public Jw_transacao() {
  }

  public java.lang.String getTrn_codigo() {
    return trn_codigo;
  }

  public void setTrn_codigo(java.lang.String PARAM) {
    this.trn_codigo = PARAM;
  }

  public java.sql.Timestamp getMov_data() {
    return mov_data;
  }

  public void setMov_data(java.sql.Timestamp PARAM) {
    this.mov_data = PARAM;
  }

}

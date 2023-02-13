package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Log_acessos_usuarios
  * @version 05/07/2010 07:03:07
  */
public class Log_acessos_usuarios implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int usua_id;
  private java.lang.String ip;
  private java.sql.Timestamp data_acesso;

  public Log_acessos_usuarios() {
  }

  public int getUsua_id() {
    return usua_id;
  }

  public void setUsua_id(int PARAM) {
    this.usua_id = PARAM;
  }

  public java.lang.String getIp() {
    return ip;
  }

  public void setIp(java.lang.String PARAM) {
    this.ip = PARAM;
  }

  public java.sql.Timestamp getData_acesso() {
    return data_acesso;
  }

  public void setData_acesso(java.sql.Timestamp PARAM) {
    this.data_acesso = PARAM;
  }

}

package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Hotspotbr
  * @version 03/03/2017 09:53:23
  */
public class Hotspotbr implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.sql.Timestamp data;
  private java.lang.String senha;

  public Hotspotbr() {
  }

  public java.sql.Timestamp getData() {
    return data;
  }

  public void setData(java.sql.Timestamp PARAM) {
    this.data = PARAM;
  }

  public java.lang.String getSenha() {
    return senha;
  }

  public void setSenha(java.lang.String PARAM) {
    this.senha = PARAM;
  }

}

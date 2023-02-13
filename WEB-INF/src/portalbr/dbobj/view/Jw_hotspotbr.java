package portalbr.dbobj.view;

/** DataBase Object from table .Jw_hotspotbr
  * @version 03/03/2017 10:00:40
  */
public class Jw_hotspotbr implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.sql.Timestamp data;
  private java.lang.String senha;

  public Jw_hotspotbr() {
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

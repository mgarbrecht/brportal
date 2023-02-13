package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Acessos_troca_identidade
  * @version 12/12/2017 12:21:29
  */
public class Acessos_troca_identidade implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int atid_usua_id;
  private int atid_tien_id;

  public Acessos_troca_identidade() {
  }

  public int getAtid_usua_id() {
    return atid_usua_id;
  }

  public void setAtid_usua_id(int PARAM) {
    this.atid_usua_id = PARAM;
  }

  public int getAtid_tien_id() {
    return atid_tien_id;
  }

  public void setAtid_tien_id(int PARAM) {
    this.atid_tien_id = PARAM;
  }

}

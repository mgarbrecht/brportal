package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acessos_troca_identidade
  * @version 12/12/2017 12:47:09
  */
public class Jw_acessos_troca_identidade implements java.io.Serializable, com.egen.util.jdbc.View {
  private int atid_usua_id;
  private java.lang.String usua_usuario;
  private java.lang.String usua_nome;
  private int atid_tien_id;
  private java.lang.String tien_tipo;

  public Jw_acessos_troca_identidade() {
  }

  public int getAtid_usua_id() {
    return atid_usua_id;
  }

  public void setAtid_usua_id(int PARAM) {
    this.atid_usua_id = PARAM;
  }

  public java.lang.String getUsua_usuario() {
    return usua_usuario;
  }

  public void setUsua_usuario(java.lang.String PARAM) {
    this.usua_usuario = PARAM;
  }

  public java.lang.String getUsua_nome() {
    return usua_nome;
  }

  public void setUsua_nome(java.lang.String PARAM) {
    this.usua_nome = PARAM;
  }

  public int getAtid_tien_id() {
    return atid_tien_id;
  }

  public void setAtid_tien_id(int PARAM) {
    this.atid_tien_id = PARAM;
  }

  public java.lang.String getTien_tipo() {
    return tien_tipo;
  }

  public void setTien_tipo(java.lang.String PARAM) {
    this.tien_tipo = PARAM;
  }

}

package portalbr.dbobj.view;

/** DataBase Object from table .Jw_log_acessos_usuarios
  * @version 03/04/2013 09:24:55
  */
public class Jw_log_acessos_usuarios implements java.io.Serializable, com.egen.util.jdbc.View {
  private int tien_id;
  private java.lang.String tien_tipo;
  private int enne_id;
  private java.lang.String enne_descricao;
  private int usua_id;
  private java.lang.String usua_usuario;
  private java.lang.String usua_nome;
  private java.lang.String situacao;
  private java.sql.Timestamp data_acesso;
  private java.lang.String ip;

  public Jw_log_acessos_usuarios() {
  }

  public int getTien_id() {
    return tien_id;
  }

  public void setTien_id(int PARAM) {
    this.tien_id = PARAM;
  }

  public java.lang.String getTien_tipo() {
    return tien_tipo;
  }

  public void setTien_tipo(java.lang.String PARAM) {
    this.tien_tipo = PARAM;
  }

  public int getEnne_id() {
    return enne_id;
  }

  public void setEnne_id(int PARAM) {
    this.enne_id = PARAM;
  }

  public java.lang.String getEnne_descricao() {
    return enne_descricao;
  }

  public void setEnne_descricao(java.lang.String PARAM) {
    this.enne_descricao = PARAM;
  }

  public int getUsua_id() {
    return usua_id;
  }

  public void setUsua_id(int PARAM) {
    this.usua_id = PARAM;
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

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

  public java.sql.Timestamp getData_acesso() {
    return data_acesso;
  }

  public void setData_acesso(java.sql.Timestamp PARAM) {
    this.data_acesso = PARAM;
  }

  public java.lang.String getIp() {
    return ip;
  }

  public void setIp(java.lang.String PARAM) {
    this.ip = PARAM;
  }

}

package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Usuarios
  * @version 02/03/2015 12:16:08
  */
public class Usuarios implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer usua_id;
  private java.lang.String usua_nome;
  private java.lang.String usua_email;
  private java.lang.String usua_usuario;
  private java.lang.String usua_senha;
  private java.lang.String usua_super;
  private java.lang.Integer usua_enne_id;
  private java.sql.Timestamp usua_dt_senha;
  private java.lang.Integer usua_acessos;
  private java.sql.Timestamp usua_dt_ultimo_acesso;
  private java.lang.String situacao;
  private java.lang.Integer dias_consulta_retroativa;
  private java.lang.String usua_expira_senha;
  private java.sql.Timestamp dthr_inclusao;
  private java.sql.Timestamp dthr_alteracao;
  private java.lang.String usuario_inclusao;
  private java.lang.String usuario_alteracao;

  public Usuarios() {
  }

  public java.lang.Integer getUsua_id() {
    return usua_id;
  }

  public void setUsua_id(java.lang.Integer PARAM) {
    this.usua_id = PARAM;
  }

  public java.lang.String getUsua_nome() {
    return usua_nome;
  }

  public void setUsua_nome(java.lang.String PARAM) {
    this.usua_nome = PARAM;
  }

  public java.lang.String getUsua_email() {
    return usua_email;
  }

  public void setUsua_email(java.lang.String PARAM) {
    this.usua_email = PARAM;
  }

  public java.lang.String getUsua_usuario() {
    return usua_usuario;
  }

  public void setUsua_usuario(java.lang.String PARAM) {
    this.usua_usuario = PARAM;
  }

  public java.lang.String getUsua_senha() {
    return usua_senha;
  }

  public void setUsua_senha(java.lang.String PARAM) {
    this.usua_senha = PARAM;
  }

  public java.lang.String getUsua_super() {
    return usua_super;
  }

  public void setUsua_super(java.lang.String PARAM) {
    this.usua_super = PARAM;
  }

  public java.lang.Integer getUsua_enne_id() {
    return usua_enne_id;
  }

  public void setUsua_enne_id(java.lang.Integer PARAM) {
    this.usua_enne_id = PARAM;
  }

  public java.sql.Timestamp getUsua_dt_senha() {
    return usua_dt_senha;
  }

  public void setUsua_dt_senha(java.sql.Timestamp PARAM) {
    this.usua_dt_senha = PARAM;
  }

  public java.lang.Integer getUsua_acessos() {
    return usua_acessos;
  }

  public void setUsua_acessos(java.lang.Integer PARAM) {
    this.usua_acessos = PARAM;
  }

  public java.sql.Timestamp getUsua_dt_ultimo_acesso() {
    return usua_dt_ultimo_acesso;
  }

  public void setUsua_dt_ultimo_acesso(java.sql.Timestamp PARAM) {
    this.usua_dt_ultimo_acesso = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

  public java.lang.Integer getDias_consulta_retroativa() {
    return dias_consulta_retroativa;
  }

  public void setDias_consulta_retroativa(java.lang.Integer PARAM) {
    this.dias_consulta_retroativa = PARAM;
  }

  public java.lang.String getUsua_expira_senha() {
    return usua_expira_senha;
  }

  public void setUsua_expira_senha(java.lang.String PARAM) {
    this.usua_expira_senha = PARAM;
  }

  public java.sql.Timestamp getDthr_inclusao() {
    return dthr_inclusao;
  }

  public void setDthr_inclusao(java.sql.Timestamp PARAM) {
    this.dthr_inclusao = PARAM;
  }

  public java.sql.Timestamp getDthr_alteracao() {
    return dthr_alteracao;
  }

  public void setDthr_alteracao(java.sql.Timestamp PARAM) {
    this.dthr_alteracao = PARAM;
  }

  public java.lang.String getUsuario_inclusao() {
    return usuario_inclusao;
  }

  public void setUsuario_inclusao(java.lang.String PARAM) {
    this.usuario_inclusao = PARAM;
  }

  public java.lang.String getUsuario_alteracao() {
    return usuario_alteracao;
  }

  public void setUsuario_alteracao(java.lang.String PARAM) {
    this.usuario_alteracao = PARAM;
  }

}

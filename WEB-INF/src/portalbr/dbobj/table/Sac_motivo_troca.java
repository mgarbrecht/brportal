package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Sac_motivo_troca
  * @version 05/12/2019 13:21:56
  */
public class Sac_motivo_troca implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer codigo;
  private java.lang.String descricao;
  private java.lang.Integer codigo_grupo;
  private java.lang.String status;
  private java.sql.Timestamp data_cadastro;
  private java.lang.String usuario_cadastro;
  private java.sql.Timestamp data_alteracao;
  private java.lang.String usuario_alteracao;

  public Sac_motivo_troca() {
  }

  public java.lang.Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.Integer PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.Integer getCodigo_grupo() {
    return codigo_grupo;
  }

  public void setCodigo_grupo(java.lang.Integer PARAM) {
    this.codigo_grupo = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

  public java.sql.Timestamp getData_cadastro() {
    return data_cadastro;
  }

  public void setData_cadastro(java.sql.Timestamp PARAM) {
    this.data_cadastro = PARAM;
  }

  public java.lang.String getUsuario_cadastro() {
    return usuario_cadastro;
  }

  public void setUsuario_cadastro(java.lang.String PARAM) {
    this.usuario_cadastro = PARAM;
  }

  public java.sql.Timestamp getData_alteracao() {
    return data_alteracao;
  }

  public void setData_alteracao(java.sql.Timestamp PARAM) {
    this.data_alteracao = PARAM;
  }

  public java.lang.String getUsuario_alteracao() {
    return usuario_alteracao;
  }

  public void setUsuario_alteracao(java.lang.String PARAM) {
    this.usuario_alteracao = PARAM;
  }

}

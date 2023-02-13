package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Grupo_economico
  * @version 21/08/2013 11:20:49
  */
public class Grupo_economico implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int gre_grupo;
  private java.lang.String gre_descricao;
  private int gre_seqn;
  private int cli_cdgo;
  private int for_codigo;
  private java.lang.String gre_tipo;
  private java.sql.Timestamp data_cad;
  private java.lang.String usuario_cad;
  private java.lang.String controla_producao;
  private java.sql.Timestamp data_log_afv;
  private java.sql.Timestamp data_inativacao;
  private java.lang.String usuario_inativacao;
  private java.lang.String status;

  public Grupo_economico() {
  }

  public int getGre_grupo() {
    return gre_grupo;
  }

  public void setGre_grupo(int PARAM) {
    this.gre_grupo = PARAM;
  }

  public java.lang.String getGre_descricao() {
    return gre_descricao;
  }

  public void setGre_descricao(java.lang.String PARAM) {
    this.gre_descricao = PARAM;
  }

  public int getGre_seqn() {
    return gre_seqn;
  }

  public void setGre_seqn(int PARAM) {
    this.gre_seqn = PARAM;
  }

  public int getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(int PARAM) {
    this.cli_cdgo = PARAM;
  }

  public int getFor_codigo() {
    return for_codigo;
  }

  public void setFor_codigo(int PARAM) {
    this.for_codigo = PARAM;
  }

  public java.lang.String getGre_tipo() {
    return gre_tipo;
  }

  public void setGre_tipo(java.lang.String PARAM) {
    this.gre_tipo = PARAM;
  }

  public java.sql.Timestamp getData_cad() {
    return data_cad;
  }

  public void setData_cad(java.sql.Timestamp PARAM) {
    this.data_cad = PARAM;
  }

  public java.lang.String getUsuario_cad() {
    return usuario_cad;
  }

  public void setUsuario_cad(java.lang.String PARAM) {
    this.usuario_cad = PARAM;
  }

  public java.lang.String getControla_producao() {
    return controla_producao;
  }

  public void setControla_producao(java.lang.String PARAM) {
    this.controla_producao = PARAM;
  }

  public java.sql.Timestamp getData_log_afv() {
    return data_log_afv;
  }

  public void setData_log_afv(java.sql.Timestamp PARAM) {
    this.data_log_afv = PARAM;
  }

  public java.sql.Timestamp getData_inativacao() {
    return data_inativacao;
  }

  public void setData_inativacao(java.sql.Timestamp PARAM) {
    this.data_inativacao = PARAM;
  }

  public java.lang.String getUsuario_inativacao() {
    return usuario_inativacao;
  }

  public void setUsuario_inativacao(java.lang.String PARAM) {
    this.usuario_inativacao = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

}

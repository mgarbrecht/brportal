package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Grupo_posicao_fabrica
  * @version 03/04/2013 09:55:38
  */
public class Grupo_posicao_fabrica implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer codigo_grupo;
  private java.lang.String descricao_grupo;
  private java.sql.Timestamp data_cadastro_grupo;
  private java.lang.String usuario_grupo;
  private java.lang.String tipo_produto_ncm;
  private java.lang.String unm_codigo;

  public Grupo_posicao_fabrica() {
  }

  public java.lang.Integer getCodigo_grupo() {
    return codigo_grupo;
  }

  public void setCodigo_grupo(java.lang.Integer PARAM) {
    this.codigo_grupo = PARAM;
  }

  public java.lang.String getDescricao_grupo() {
    return descricao_grupo;
  }

  public void setDescricao_grupo(java.lang.String PARAM) {
    this.descricao_grupo = PARAM;
  }

  public java.sql.Timestamp getData_cadastro_grupo() {
    return data_cadastro_grupo;
  }

  public void setData_cadastro_grupo(java.sql.Timestamp PARAM) {
    this.data_cadastro_grupo = PARAM;
  }

  public java.lang.String getUsuario_grupo() {
    return usuario_grupo;
  }

  public void setUsuario_grupo(java.lang.String PARAM) {
    this.usuario_grupo = PARAM;
  }

  public java.lang.String getTipo_produto_ncm() {
    return tipo_produto_ncm;
  }

  public void setTipo_produto_ncm(java.lang.String PARAM) {
    this.tipo_produto_ncm = PARAM;
  }

  public java.lang.String getUnm_codigo() {
    return unm_codigo;
  }

  public void setUnm_codigo(java.lang.String PARAM) {
    this.unm_codigo = PARAM;
  }

}

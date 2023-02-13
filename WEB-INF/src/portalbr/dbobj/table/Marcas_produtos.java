package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Marcas_produtos
  * @version 05/07/2010 07:02:44
  */
public class Marcas_produtos implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int codigo_marca;
  private java.lang.String descricao_marca;
  private java.sql.Timestamp data_cadastro;
  private java.lang.String usuario;

  public Marcas_produtos() {
  }

  public int getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(int PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.String getDescricao_marca() {
    return descricao_marca;
  }

  public void setDescricao_marca(java.lang.String PARAM) {
    this.descricao_marca = PARAM;
  }

  public java.sql.Timestamp getData_cadastro() {
    return data_cadastro;
  }

  public void setData_cadastro(java.sql.Timestamp PARAM) {
    this.data_cadastro = PARAM;
  }

  public java.lang.String getUsuario() {
    return usuario;
  }

  public void setUsuario(java.lang.String PARAM) {
    this.usuario = PARAM;
  }

}

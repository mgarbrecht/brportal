package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Tipos_argumentos
  * @version 03/04/2013 09:07:05
  */
public class Tipos_argumentos implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int codigo_argumento;
  private java.lang.String descricao_argumento;
  private java.lang.String usuario_argumento;
  private java.sql.Date data_argumento;

  public Tipos_argumentos() {
  }

  public int getCodigo_argumento() {
    return codigo_argumento;
  }

  public void setCodigo_argumento(int PARAM) {
    this.codigo_argumento = PARAM;
  }

  public java.lang.String getDescricao_argumento() {
    return descricao_argumento;
  }

  public void setDescricao_argumento(java.lang.String PARAM) {
    this.descricao_argumento = PARAM;
  }

  public java.lang.String getUsuario_argumento() {
    return usuario_argumento;
  }

  public void setUsuario_argumento(java.lang.String PARAM) {
    this.usuario_argumento = PARAM;
  }

  public java.sql.Date getData_argumento() {
    return data_argumento;
  }

  public void setData_argumento(java.sql.Date PARAM) {
    this.data_argumento = PARAM;
  }

}

package portalbr.dbobj.table;

/** DataBase Object from table DEV.Situacoes_devolucoes
  * @version 05/07/2010 06:58:29
  */
public class Situacoes_devolucoes implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int codigo;
  private java.lang.String descricao;
  private java.sql.Date data_cad;
  private java.lang.String usuario_cad;

  public Situacoes_devolucoes() {
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.sql.Date getData_cad() {
    return data_cad;
  }

  public void setData_cad(java.sql.Date PARAM) {
    this.data_cad = PARAM;
  }

  public java.lang.String getUsuario_cad() {
    return usuario_cad;
  }

  public void setUsuario_cad(java.lang.String PARAM) {
    this.usuario_cad = PARAM;
  }

}

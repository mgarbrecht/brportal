package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Tipo_ocorrencia
  * @version 03/04/2013 09:07:14
  */
public class Tipo_ocorrencia implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int codigo;
  private java.lang.String descricao;
  private java.lang.String desconsiderar;

  public Tipo_ocorrencia() {
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

  public java.lang.String getDesconsiderar() {
    return desconsiderar;
  }

  public void setDesconsiderar(java.lang.String PARAM) {
    this.desconsiderar = PARAM;
  }

}

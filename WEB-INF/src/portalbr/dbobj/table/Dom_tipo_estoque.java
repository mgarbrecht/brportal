package portalbr.dbobj.table;

/** DataBase Object from table EST.Dom_tipo_estoque
  * @version 03/04/2013 09:59:31
  */
public class Dom_tipo_estoque implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int codigo;
  private java.lang.String descricao;
  private java.lang.String tipo_fisico;
  private java.lang.String tipo_cm;
  private java.lang.String tipo_oficial;
  private java.lang.String indicador_lancamento_manual;

  public Dom_tipo_estoque() {
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

  public java.lang.String getTipo_fisico() {
    return tipo_fisico;
  }

  public void setTipo_fisico(java.lang.String PARAM) {
    this.tipo_fisico = PARAM;
  }

  public java.lang.String getTipo_cm() {
    return tipo_cm;
  }

  public void setTipo_cm(java.lang.String PARAM) {
    this.tipo_cm = PARAM;
  }

  public java.lang.String getTipo_oficial() {
    return tipo_oficial;
  }

  public void setTipo_oficial(java.lang.String PARAM) {
    this.tipo_oficial = PARAM;
  }

  public java.lang.String getIndicador_lancamento_manual() {
    return indicador_lancamento_manual;
  }

  public void setIndicador_lancamento_manual(java.lang.String PARAM) {
    this.indicador_lancamento_manual = PARAM;
  }

}

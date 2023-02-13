package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Corrugados
  * @version 03/04/2013 10:00:26
  */
public class Corrugados implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer codigo;
  private java.lang.String descricao;
  private java.lang.Integer qt_par_corrug;
  private java.lang.String ativo;

  public Corrugados() {
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

  public java.lang.Integer getQt_par_corrug() {
    return qt_par_corrug;
  }

  public void setQt_par_corrug(java.lang.Integer PARAM) {
    this.qt_par_corrug = PARAM;
  }

  public java.lang.String getAtivo() {
    return ativo;
  }

  public void setAtivo(java.lang.String PARAM) {
    this.ativo = PARAM;
  }

}

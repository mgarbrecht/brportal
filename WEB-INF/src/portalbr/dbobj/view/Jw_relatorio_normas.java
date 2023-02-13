package portalbr.dbobj.view;

/** DataBase Object from table .Jw_relatorio_normas
  * @version 03/04/2013 09:13:20
  */
public class Jw_relatorio_normas implements java.io.Serializable, com.egen.util.jdbc.View {
  private int codigo_marca;
  private java.lang.String descricao_marca;
  private int lin_cdgo;
  private java.lang.String lin_nome;

  public Jw_relatorio_normas() {
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

  public int getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(int PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.String getLin_nome() {
    return lin_nome;
  }

  public void setLin_nome(java.lang.String PARAM) {
    this.lin_nome = PARAM;
  }

}

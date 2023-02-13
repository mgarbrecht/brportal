package portalbr.dbobj.view;

/** DataBase Object from table .Jw_afv_marketing
  * @version 03/04/2013 09:51:45
  */
public class Jw_afv_marketing implements java.io.Serializable, com.egen.util.jdbc.View {
  private int codmarketing;
  private int codtipomarketing;
  private java.lang.String titulo;
  private java.lang.String descricao;
  private java.lang.String tipoarquivo;

  public Jw_afv_marketing() {
  }

  public int getCodmarketing() {
    return codmarketing;
  }

  public void setCodmarketing(int PARAM) {
    this.codmarketing = PARAM;
  }

  public int getCodtipomarketing() {
    return codtipomarketing;
  }

  public void setCodtipomarketing(int PARAM) {
    this.codtipomarketing = PARAM;
  }

  public java.lang.String getTitulo() {
    return titulo;
  }

  public void setTitulo(java.lang.String PARAM) {
    this.titulo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.String getTipoarquivo() {
    return tipoarquivo;
  }

  public void setTipoarquivo(java.lang.String PARAM) {
    this.tipoarquivo = PARAM;
  }

}

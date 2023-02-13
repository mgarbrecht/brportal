package portalbr.dbobj.view;

/** DataBase Object from table .Jw_paises
  * @version 16/10/2015 12:18:00
  */
public class Jw_paises implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String descricao;
  private java.lang.String sigla;

  public Jw_paises() {
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.String getSigla() {
    return sigla;
  }

  public void setSigla(java.lang.String PARAM) {
    this.sigla = PARAM;
  }

}

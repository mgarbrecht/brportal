package portalbr.dbobj.view;

/** DataBase Object from table .Jw_grupos_ativos
  * @version 03/04/2013 09:27:19
  */
public class Jw_grupos_ativos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String gre_grupo;
  private java.lang.String gre_descricao;

  public Jw_grupos_ativos() {
  }

  public java.lang.String getGre_grupo() {
    return gre_grupo;
  }

  public void setGre_grupo(java.lang.String PARAM) {
    this.gre_grupo = PARAM;
  }

  public java.lang.String getGre_descricao() {
    return gre_descricao;
  }

  public void setGre_descricao(java.lang.String PARAM) {
    this.gre_descricao = PARAM;
  }

}

package portalbr.dbobj.view;

/** DataBase Object from table .Jw_tmp_mapa_diario_msn
  * @version 19/07/2016 10:52:03
  */
public class Jw_tmp_mapa_diario_msn implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String texto;
  private int ordem;

  public Jw_tmp_mapa_diario_msn() {
  }

  public java.lang.String getTexto() {
    return texto;
  }

  public void setTexto(java.lang.String PARAM) {
    this.texto = PARAM;
  }

  public int getOrdem() {
    return ordem;
  }

  public void setOrdem(int PARAM) {
    this.ordem = PARAM;
  }

}

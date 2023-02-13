package portalbr.dbobj.view;

/** DataBase Object from table .Propriedades
  * @version 05/07/2010 06:59:52
  */
public class Propriedades implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String chave;
  private java.lang.String valor;

  public Propriedades() {
  }

  public java.lang.String getChave() {
    return chave;
  }

  public void setChave(java.lang.String PARAM) {
    this.chave = PARAM;
  }

  public java.lang.String getValor() {
    return valor;
  }

  public void setValor(java.lang.String PARAM) {
    this.valor = PARAM;
  }

}

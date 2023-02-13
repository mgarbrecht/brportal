package portalbr.dbobj.view;

/** DataBase Object from table .Jw_circulares
  * @version 03/04/2013 09:49:01
  */
public class Jw_circulares implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String numero;
  private java.sql.Timestamp data;
  private java.lang.String remetente;
  private java.lang.String assunto;
  private java.lang.String dest;

  public Jw_circulares() {
  }

  public java.lang.String getNumero() {
    return numero;
  }

  public void setNumero(java.lang.String PARAM) {
    this.numero = PARAM;
  }

  public java.sql.Timestamp getData() {
    return data;
  }

  public void setData(java.sql.Timestamp PARAM) {
    this.data = PARAM;
  }

  public java.lang.String getRemetente() {
    return remetente;
  }

  public void setRemetente(java.lang.String PARAM) {
    this.remetente = PARAM;
  }

  public java.lang.String getAssunto() {
    return assunto;
  }

  public void setAssunto(java.lang.String PARAM) {
    this.assunto = PARAM;
  }

  public java.lang.String getDest() {
    return dest;
  }

  public void setDest(java.lang.String PARAM) {
    this.dest = PARAM;
  }

}

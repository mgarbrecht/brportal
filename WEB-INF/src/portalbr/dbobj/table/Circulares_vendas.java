package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Circulares_vendas
  * @version 03/04/2013 10:05:55
  */
public class Circulares_vendas implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.String numero;
  private java.sql.Timestamp data;
  private java.lang.String remetente;
  private int destinatario;
  private java.lang.String assunto;
  private java.lang.String texto;
  private java.lang.String status;

  public Circulares_vendas() {
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

  public int getDestinatario() {
    return destinatario;
  }

  public void setDestinatario(int PARAM) {
    this.destinatario = PARAM;
  }

  public java.lang.String getAssunto() {
    return assunto;
  }

  public void setAssunto(java.lang.String PARAM) {
    this.assunto = PARAM;
  }

  public java.lang.String getTexto() {
    return texto;
  }

  public void setTexto(java.lang.String PARAM) {
    this.texto = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

}

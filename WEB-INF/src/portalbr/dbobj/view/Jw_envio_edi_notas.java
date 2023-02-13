package portalbr.dbobj.view;

/** DataBase Object from table .Jw_envio_edi_notas
  * @version 03/04/2013 09:30:35
  */
public class Jw_envio_edi_notas implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String transportadora;
  private double qtd_notas;

  public Jw_envio_edi_notas() {
  }

  public java.lang.String getTransportadora() {
    return transportadora;
  }

  public void setTransportadora(java.lang.String PARAM) {
    this.transportadora = PARAM;
  }

  public double getQtd_notas() {
    return qtd_notas;
  }

  public void setQtd_notas(double PARAM) {
    this.qtd_notas = PARAM;
  }

}

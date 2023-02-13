package portalbr.dbobj.view;

/** DataBase Object from table .Jw_log_mapa_diario
  * @version 18/11/2014 12:50:59
  */
public class Jw_log_mapa_diario implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String ocorrencia;
  private java.lang.String data_ocorrencia;
  private java.lang.Integer sequencia;

  public Jw_log_mapa_diario() {
  }

  public java.lang.String getOcorrencia() {
    return ocorrencia;
  }

  public void setOcorrencia(java.lang.String PARAM) {
    this.ocorrencia = PARAM;
  }

  public java.lang.String getData_ocorrencia() {
    return data_ocorrencia;
  }

  public void setData_ocorrencia(java.lang.String PARAM) {
    this.data_ocorrencia = PARAM;
  }

  public java.lang.Integer getSequencia() {
    return sequencia;
  }

  public void setSequencia(java.lang.Integer PARAM) {
    this.sequencia = PARAM;
  }

}

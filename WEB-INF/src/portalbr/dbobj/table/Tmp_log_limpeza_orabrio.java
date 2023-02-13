package portalbr.dbobj.table;

/** DataBase Object from table UBIRATAN.Tmp_log_limpeza_orabrio
  * @version 19/02/2015 08:19:10
  */
public class Tmp_log_limpeza_orabrio implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.String ocorrencia;
  private java.lang.String data;
  private java.lang.Integer sequencia;

  public Tmp_log_limpeza_orabrio() {
  }

  public java.lang.String getOcorrencia() {
    return ocorrencia;
  }

  public void setOcorrencia(java.lang.String PARAM) {
    this.ocorrencia = PARAM;
  }

  public java.lang.String getData() {
    return data;
  }

  public void setData(java.lang.String PARAM) {
    this.data = PARAM;
  }

  public java.lang.Integer getSequencia() {
    return sequencia;
  }

  public void setSequencia(java.lang.Integer PARAM) {
    this.sequencia = PARAM;
  }

}

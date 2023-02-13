package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Comunicacao_retornos
  * @version 03/04/2013 10:01:13
  */
public class Comunicacao_retornos implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int sequencia;
  private int sequencia_retornos;
  private java.sql.Clob descricao_retorno;
  private java.sql.Timestamp data_retorno;
  private java.lang.String usuario_retorno;

  public Comunicacao_retornos() {
  }

  public int getSequencia() {
    return sequencia;
  }

  public void setSequencia(int PARAM) {
    this.sequencia = PARAM;
  }

  public int getSequencia_retornos() {
    return sequencia_retornos;
  }

  public void setSequencia_retornos(int PARAM) {
    this.sequencia_retornos = PARAM;
  }

  public java.sql.Clob getDescricao_retorno() {
    return descricao_retorno;
  }

  public void setDescricao_retorno(java.sql.Clob PARAM) {
    this.descricao_retorno = PARAM;
  }

  public java.sql.Timestamp getData_retorno() {
    return data_retorno;
  }

  public void setData_retorno(java.sql.Timestamp PARAM) {
    this.data_retorno = PARAM;
  }

  public java.lang.String getUsuario_retorno() {
    return usuario_retorno;
  }

  public void setUsuario_retorno(java.lang.String PARAM) {
    this.usuario_retorno = PARAM;
  }

}

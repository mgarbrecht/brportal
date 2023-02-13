package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Cliente_representante
  * @version 03/04/2013 10:04:13
  */
public class Cliente_representante implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int codigo_cliente;
  private int codigo_sequencial;
  private java.lang.String codigo_representante;
  private java.sql.Timestamp data_cadastro;
  private java.lang.String usuario;
  private java.lang.String sequencia_visita;
  private java.lang.String situacao;
  private java.lang.String observacao;
  private java.lang.String sequencia_visita2;
  private java.lang.String sequencia_visita3;
  private java.lang.String sequencia_visita4;
  private java.lang.String codigo_representante_adicional;
  private double percentual_adicional;
  private java.sql.Timestamp data_log_afv;

  public Cliente_representante() {
  }

  public int getCodigo_cliente() {
    return codigo_cliente;
  }

  public void setCodigo_cliente(int PARAM) {
    this.codigo_cliente = PARAM;
  }

  public int getCodigo_sequencial() {
    return codigo_sequencial;
  }

  public void setCodigo_sequencial(int PARAM) {
    this.codigo_sequencial = PARAM;
  }

  public java.lang.String getCodigo_representante() {
    return codigo_representante;
  }

  public void setCodigo_representante(java.lang.String PARAM) {
    this.codigo_representante = PARAM;
  }

  public java.sql.Timestamp getData_cadastro() {
    return data_cadastro;
  }

  public void setData_cadastro(java.sql.Timestamp PARAM) {
    this.data_cadastro = PARAM;
  }

  public java.lang.String getUsuario() {
    return usuario;
  }

  public void setUsuario(java.lang.String PARAM) {
    this.usuario = PARAM;
  }

  public java.lang.String getSequencia_visita() {
    return sequencia_visita;
  }

  public void setSequencia_visita(java.lang.String PARAM) {
    this.sequencia_visita = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

  public java.lang.String getObservacao() {
    return observacao;
  }

  public void setObservacao(java.lang.String PARAM) {
    this.observacao = PARAM;
  }

  public java.lang.String getSequencia_visita2() {
    return sequencia_visita2;
  }

  public void setSequencia_visita2(java.lang.String PARAM) {
    this.sequencia_visita2 = PARAM;
  }

  public java.lang.String getSequencia_visita3() {
    return sequencia_visita3;
  }

  public void setSequencia_visita3(java.lang.String PARAM) {
    this.sequencia_visita3 = PARAM;
  }

  public java.lang.String getSequencia_visita4() {
    return sequencia_visita4;
  }

  public void setSequencia_visita4(java.lang.String PARAM) {
    this.sequencia_visita4 = PARAM;
  }

  public java.lang.String getCodigo_representante_adicional() {
    return codigo_representante_adicional;
  }

  public void setCodigo_representante_adicional(java.lang.String PARAM) {
    this.codigo_representante_adicional = PARAM;
  }

  public double getPercentual_adicional() {
    return percentual_adicional;
  }

  public void setPercentual_adicional(double PARAM) {
    this.percentual_adicional = PARAM;
  }

  public java.sql.Timestamp getData_log_afv() {
    return data_log_afv;
  }

  public void setData_log_afv(java.sql.Timestamp PARAM) {
    this.data_log_afv = PARAM;
  }

}

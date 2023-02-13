package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Abastecimento
  * @version 20/02/2008 10:51:31
  */
public class Abastecimento implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int nro_documento;
  private java.sql.Timestamp data_abastecimento;
  private java.lang.String usuario;
  private int les_codigo_ori;
  private int les_codigo_des;
  private java.lang.String set_cdgo;
  private java.lang.String observacao;
  private java.lang.String status;
  private int tes_codigo;
  private java.lang.String usuario_geracao;
  private int tes_codigo_des;

  public Abastecimento() {
  }

  public int getNro_documento() {
    return nro_documento;
  }

  public void setNro_documento(int PARAM) {
    this.nro_documento = PARAM;
  }

  public java.sql.Timestamp getData_abastecimento() {
    return data_abastecimento;
  }

  public void setData_abastecimento(java.sql.Timestamp PARAM) {
    this.data_abastecimento = PARAM;
  }

  public java.lang.String getUsuario() {
    return usuario;
  }

  public void setUsuario(java.lang.String PARAM) {
    this.usuario = PARAM;
  }

  public int getLes_codigo_ori() {
    return les_codigo_ori;
  }

  public void setLes_codigo_ori(int PARAM) {
    this.les_codigo_ori = PARAM;
  }

  public int getLes_codigo_des() {
    return les_codigo_des;
  }

  public void setLes_codigo_des(int PARAM) {
    this.les_codigo_des = PARAM;
  }

  public java.lang.String getSet_cdgo() {
    return set_cdgo;
  }

  public void setSet_cdgo(java.lang.String PARAM) {
    this.set_cdgo = PARAM;
  }

  public java.lang.String getObservacao() {
    return observacao;
  }

  public void setObservacao(java.lang.String PARAM) {
    this.observacao = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

  public int getTes_codigo() {
    return tes_codigo;
  }

  public void setTes_codigo(int PARAM) {
    this.tes_codigo = PARAM;
  }

  public java.lang.String getUsuario_geracao() {
    return usuario_geracao;
  }

  public void setUsuario_geracao(java.lang.String PARAM) {
    this.usuario_geracao = PARAM;
  }

  public int getTes_codigo_des() {
    return tes_codigo_des;
  }

  public void setTes_codigo_des(int PARAM) {
    this.tes_codigo_des = PARAM;
  }

}

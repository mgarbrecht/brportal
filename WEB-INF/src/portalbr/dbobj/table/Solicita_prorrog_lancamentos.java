package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Solicita_prorrog_lancamentos
  * @version 16/01/2012 15:29:36
  */
public class Solicita_prorrog_lancamentos implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer id_solicitacao;
  private java.lang.Integer id_lancamento;
  private java.lang.Double valor_lancamento;
  private java.sql.Timestamp data_lancamento;
  private java.lang.String usuario_lancamento;
  private java.lang.String motivo;

  public Solicita_prorrog_lancamentos() {
  }

  public java.lang.Integer getId_solicitacao() {
    return id_solicitacao;
  }

  public void setId_solicitacao(java.lang.Integer PARAM) {
    this.id_solicitacao = PARAM;
  }

  public java.lang.Integer getId_lancamento() {
    return id_lancamento;
  }

  public void setId_lancamento(java.lang.Integer PARAM) {
    this.id_lancamento = PARAM;
  }

  public java.lang.Double getValor_lancamento() {
    return valor_lancamento;
  }

  public void setValor_lancamento(java.lang.Double PARAM) {
    this.valor_lancamento = PARAM;
  }

  public java.sql.Timestamp getData_lancamento() {
    return data_lancamento;
  }

  public void setData_lancamento(java.sql.Timestamp PARAM) {
    this.data_lancamento = PARAM;
  }

  public java.lang.String getUsuario_lancamento() {
    return usuario_lancamento;
  }

  public void setUsuario_lancamento(java.lang.String PARAM) {
    this.usuario_lancamento = PARAM;
  }

  public java.lang.String getMotivo() {
    return motivo;
  }

  public void setMotivo(java.lang.String PARAM) {
    this.motivo = PARAM;
  }

}

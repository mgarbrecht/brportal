package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ped_amostra_situacoes_estagios
  * @version 08/09/2011 10:35:51
  */
public class Ped_amostra_situacoes_estagios implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int id_situacao;
  private int ped_nmro;
  private int estagio;
  private java.lang.String observacao;
  private java.lang.String usuario_inclusao;
  private java.sql.Date data_inclusao;
  private java.lang.String obs_atendente;

  public Ped_amostra_situacoes_estagios() {
  }

  public int getId_situacao() {
    return id_situacao;
  }

  public void setId_situacao(int PARAM) {
    this.id_situacao = PARAM;
  }

  public int getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(int PARAM) {
    this.ped_nmro = PARAM;
  }

  public int getEstagio() {
    return estagio;
  }

  public void setEstagio(int PARAM) {
    this.estagio = PARAM;
  }

  public java.lang.String getObservacao() {
    return observacao;
  }

  public void setObservacao(java.lang.String PARAM) {
    this.observacao = PARAM;
  }

  public java.lang.String getUsuario_inclusao() {
    return usuario_inclusao;
  }

  public void setUsuario_inclusao(java.lang.String PARAM) {
    this.usuario_inclusao = PARAM;
  }

  public java.sql.Date getData_inclusao() {
    return data_inclusao;
  }

  public void setData_inclusao(java.sql.Date PARAM) {
    this.data_inclusao = PARAM;
  }

  public java.lang.String getObs_atendente() {
    return obs_atendente;
  }

  public void setObs_atendente(java.lang.String PARAM) {
    this.obs_atendente = PARAM;
  }

}

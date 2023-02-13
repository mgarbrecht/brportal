package portalbr.dbobj.view;

/** DataBase Object from table .Jw_situacoes_pedido
  * @version 03/04/2013 09:09:46
  */
public class Jw_situacoes_pedido implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String dt;
  private java.lang.String hora;
  private java.lang.String nome;
  private java.lang.String descricao;
  private java.lang.String obs_sit;
  private java.lang.String obs_lib;

  public Jw_situacoes_pedido() {
  }

  public java.lang.String getDt() {
    return dt;
  }

  public void setDt(java.lang.String PARAM) {
    this.dt = PARAM;
  }

  public java.lang.String getHora() {
    return hora;
  }

  public void setHora(java.lang.String PARAM) {
    this.hora = PARAM;
  }

  public java.lang.String getNome() {
    return nome;
  }

  public void setNome(java.lang.String PARAM) {
    this.nome = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.String getObs_sit() {
    return obs_sit;
  }

  public void setObs_sit(java.lang.String PARAM) {
    this.obs_sit = PARAM;
  }

  public java.lang.String getObs_lib() {
    return obs_lib;
  }

  public void setObs_lib(java.lang.String PARAM) {
    this.obs_lib = PARAM;
  }

}

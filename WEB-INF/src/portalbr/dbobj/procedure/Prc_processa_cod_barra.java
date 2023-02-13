package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_processa_cod_barra
  * @version 26/02/2018 09:23:09
  */
public class Prc_processa_cod_barra implements java.io.Serializable, com.egen.util.jdbc.Procedure {
  private java.lang.String p_codigo_barra;
  private java.lang.String p_setor;
  private java.lang.String p_usuario;
  private java.lang.Integer p_rem_nro;
  private java.lang.Integer p_tal_nro;
  private java.lang.String p_set_cdgo;
  private java.lang.String p_mensagem;

  public Prc_processa_cod_barra() {
  }

  public java.lang.String getP_codigo_barra() {
    return p_codigo_barra;
  }

  public void setP_codigo_barra(java.lang.String PARAM) {
    this.p_codigo_barra = PARAM;
  }

  public java.lang.String getP_setor() {
    return p_setor;
  }

  public void setP_setor(java.lang.String PARAM) {
    this.p_setor = PARAM;
  }

  public java.lang.String getP_usuario() {
    return p_usuario;
  }

  public void setP_usuario(java.lang.String PARAM) {
    this.p_usuario = PARAM;
  }

  public java.lang.Integer getP_rem_nro() {
    return p_rem_nro;
  }

  public void setP_rem_nro(java.lang.Integer PARAM) {
    this.p_rem_nro = PARAM;
  }

  public java.lang.Integer getP_tal_nro() {
    return p_tal_nro;
  }

  public void setP_tal_nro(java.lang.Integer PARAM) {
    this.p_tal_nro = PARAM;
  }

  public java.lang.String getP_set_cdgo() {
    return p_set_cdgo;
  }

  public void setP_set_cdgo(java.lang.String PARAM) {
    this.p_set_cdgo = PARAM;
  }

  public java.lang.String getP_mensagem() {
    return p_mensagem;
  }

  public void setP_mensagem(java.lang.String PARAM) {
    this.p_mensagem = PARAM;
  }

}

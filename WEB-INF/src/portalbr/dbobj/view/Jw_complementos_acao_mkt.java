package portalbr.dbobj.view;

/** DataBase Object from table .Jw_complementos_acao_mkt
  * @version 03/04/2013 09:41:41
  */
public class Jw_complementos_acao_mkt implements java.io.Serializable, com.egen.util.jdbc.View {
  private int acao;
  private java.lang.String tipo_complemento;
  private java.lang.String complemento;

  public Jw_complementos_acao_mkt() {
  }

  public int getAcao() {
    return acao;
  }

  public void setAcao(int PARAM) {
    this.acao = PARAM;
  }

  public java.lang.String getTipo_complemento() {
    return tipo_complemento;
  }

  public void setTipo_complemento(java.lang.String PARAM) {
    this.tipo_complemento = PARAM;
  }

  public java.lang.String getComplemento() {
    return complemento;
  }

  public void setComplemento(java.lang.String PARAM) {
    this.complemento = PARAM;
  }

}

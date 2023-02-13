package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Acao_marketing_estagios
  * @version 03/04/2013 10:08:49
  */
public class Acao_marketing_estagios implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer estagio_cdgo;
  private java.lang.String descricao;
  private java.lang.Integer ordem;

  public Acao_marketing_estagios() {
  }

  public java.lang.Integer getEstagio_cdgo() {
    return estagio_cdgo;
  }

  public void setEstagio_cdgo(java.lang.Integer PARAM) {
    this.estagio_cdgo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.Integer getOrdem() {
    return ordem;
  }

  public void setOrdem(java.lang.Integer PARAM) {
    this.ordem = PARAM;
  }

}

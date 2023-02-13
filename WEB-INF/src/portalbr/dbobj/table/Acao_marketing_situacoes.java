package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Acao_marketing_situacoes
  * @version 03/04/2013 10:08:35
  */
public class Acao_marketing_situacoes implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer codigo;
  private java.lang.String descricao;

  public Acao_marketing_situacoes() {
  }

  public java.lang.Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.Integer PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

}

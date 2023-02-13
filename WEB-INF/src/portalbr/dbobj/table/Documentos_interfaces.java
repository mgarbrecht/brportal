package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Documentos_interfaces
  * @version 03/04/2013 10:00:16
  */
public class Documentos_interfaces implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer doin_id;
  private java.lang.String doin_nome;
  private java.lang.String doin_descricao;

  public Documentos_interfaces() {
  }

  public java.lang.Integer getDoin_id() {
    return doin_id;
  }

  public void setDoin_id(java.lang.Integer PARAM) {
    this.doin_id = PARAM;
  }

  public java.lang.String getDoin_nome() {
    return doin_nome;
  }

  public void setDoin_nome(java.lang.String PARAM) {
    this.doin_nome = PARAM;
  }

  public java.lang.String getDoin_descricao() {
    return doin_descricao;
  }

  public void setDoin_descricao(java.lang.String PARAM) {
    this.doin_descricao = PARAM;
  }

}

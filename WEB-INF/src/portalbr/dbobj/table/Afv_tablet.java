package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Afv_tablet
  * @version 03/04/2013 10:07:26
  */
public class Afv_tablet implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer id;
  private java.lang.String nome_equipamento;
  private java.lang.String vers�o_so;

  public Afv_tablet() {
  }

  public java.lang.Integer getId() {
    return id;
  }

  public void setId(java.lang.Integer PARAM) {
    this.id = PARAM;
  }

  public java.lang.String getNome_equipamento() {
    return nome_equipamento;
  }

  public void setNome_equipamento(java.lang.String PARAM) {
    this.nome_equipamento = PARAM;
  }

  public java.lang.String getVers�o_so() {
    return vers�o_so;
  }

  public void setVers�o_so(java.lang.String PARAM) {
    this.vers�o_so = PARAM;
  }

}

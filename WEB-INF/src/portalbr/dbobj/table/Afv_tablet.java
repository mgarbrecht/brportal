package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Afv_tablet
  * @version 03/04/2013 10:07:26
  */
public class Afv_tablet implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer id;
  private java.lang.String nome_equipamento;
  private java.lang.String versão_so;

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

  public java.lang.String getVersão_so() {
    return versão_so;
  }

  public void setVersão_so(java.lang.String PARAM) {
    this.versão_so = PARAM;
  }

}

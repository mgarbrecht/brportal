package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Acao_mkt_mailing_listas
  * @version 03/04/2013 10:08:28
  */
public class Acao_mkt_mailing_listas implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int id_lista;
  private java.lang.String nome_lista;
  private java.lang.String situacao_lista;

  public Acao_mkt_mailing_listas() {
  }

  public int getId_lista() {
    return id_lista;
  }

  public void setId_lista(int PARAM) {
    this.id_lista = PARAM;
  }

  public java.lang.String getNome_lista() {
    return nome_lista;
  }

  public void setNome_lista(java.lang.String PARAM) {
    this.nome_lista = PARAM;
  }

  public java.lang.String getSituacao_lista() {
    return situacao_lista;
  }

  public void setSituacao_lista(java.lang.String PARAM) {
    this.situacao_lista = PARAM;
  }

}

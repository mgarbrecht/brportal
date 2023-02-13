package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Acao_mkt_solic_listas
  * @version 03/04/2013 10:08:10
  */
public class Acao_mkt_solic_listas implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int id_solicitacao;
  private int id_lista;

  public Acao_mkt_solic_listas() {
  }

  public int getId_solicitacao() {
    return id_solicitacao;
  }

  public void setId_solicitacao(int PARAM) {
    this.id_solicitacao = PARAM;
  }

  public int getId_lista() {
    return id_lista;
  }

  public void setId_lista(int PARAM) {
    this.id_lista = PARAM;
  }

}

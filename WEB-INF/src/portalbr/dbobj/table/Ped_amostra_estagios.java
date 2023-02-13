package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ped_amostra_estagios
  * @version 27/12/2010 08:54:21
  */
public class Ped_amostra_estagios implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int estagio_cdgo;
  private java.lang.String descricao;
  private int ordem;

  public Ped_amostra_estagios() {
  }

  public int getEstagio_cdgo() {
    return estagio_cdgo;
  }

  public void setEstagio_cdgo(int PARAM) {
    this.estagio_cdgo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public int getOrdem() {
    return ordem;
  }

  public void setOrdem(int PARAM) {
    this.ordem = PARAM;
  }

}

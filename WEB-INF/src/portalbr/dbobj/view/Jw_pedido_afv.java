package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pedido_afv
  * @version 03/04/2013 09:19:57
  */
public class Jw_pedido_afv implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer ped_nmro;
  private java.lang.String ped_sequencial_maquina;

  public Jw_pedido_afv() {
  }

  public java.lang.Integer getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(java.lang.Integer PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.String getPed_sequencial_maquina() {
    return ped_sequencial_maquina;
  }

  public void setPed_sequencial_maquina(java.lang.String PARAM) {
    this.ped_sequencial_maquina = PARAM;
  }

}

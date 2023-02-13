package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_peso_cubagem_pedido
  * @version 14/12/2010 07:47:03
  */
public class Prc_peso_cubagem_pedido implements java.io.Serializable, com.egen.util.jdbc.Procedure {
  private double p_ped_nmro;
  private double p_peso_bruto;
  private double p_peso_liquido;
  private double p_cubagem;
  private double p_volumes;

  public Prc_peso_cubagem_pedido() {
  }

  public double getP_ped_nmro() {
    return p_ped_nmro;
  }

  public void setP_ped_nmro(double PARAM) {
    this.p_ped_nmro = PARAM;
  }

  public double getP_peso_bruto() {
    return p_peso_bruto;
  }

  public void setP_peso_bruto(double PARAM) {
    this.p_peso_bruto = PARAM;
  }

  public double getP_peso_liquido() {
    return p_peso_liquido;
  }

  public void setP_peso_liquido(double PARAM) {
    this.p_peso_liquido = PARAM;
  }

  public double getP_cubagem() {
    return p_cubagem;
  }

  public void setP_cubagem(double PARAM) {
    this.p_cubagem = PARAM;
  }

  public double getP_volumes() {
    return p_volumes;
  }

  public void setP_volumes(double PARAM) {
    this.p_volumes = PARAM;
  }

}

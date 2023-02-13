package portalbr.dbobj.view;

/** DataBase Object from table .Jw_titulos_cld_verifica_titulos_cld
  * @version 05/07/2010 07:06:58
  */
public class Jw_titulos_cld_verifica_titulos_cld implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String titulo;
  private java.sql.Timestamp data_venc;
  private double valor_cld;
  private double vlpcp;
  private double vldeb;
  private double saldo;

  public Jw_titulos_cld_verifica_titulos_cld() {
  }

  public java.lang.String getTitulo() {
    return titulo;
  }

  public void setTitulo(java.lang.String PARAM) {
    this.titulo = PARAM;
  }

  public java.sql.Timestamp getData_venc() {
    return data_venc;
  }

  public void setData_venc(java.sql.Timestamp PARAM) {
    this.data_venc = PARAM;
  }

  public double getValor_cld() {
    return valor_cld;
  }

  public void setValor_cld(double PARAM) {
    this.valor_cld = PARAM;
  }

  public double getVlpcp() {
    return vlpcp;
  }

  public void setVlpcp(double PARAM) {
    this.vlpcp = PARAM;
  }

  public double getVldeb() {
    return vldeb;
  }

  public void setVldeb(double PARAM) {
    this.vldeb = PARAM;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double PARAM) {
    this.saldo = PARAM;
  }

}

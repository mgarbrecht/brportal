package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_novos_antigos_total_representante
  * @version 16/05/2014 09:03:23
  */
public class Jw_clientes_novos_antigos_total_representante implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String rep_cdgo;
  private java.lang.String rep_rzao;
  private java.lang.String status;
  private int qtde;
  private int pares;
  private double valor;

  public Jw_clientes_novos_antigos_total_representante() {
  }

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

  public java.lang.String getRep_rzao() {
    return rep_rzao;
  }

  public void setRep_rzao(java.lang.String PARAM) {
    this.rep_rzao = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

  public int getQtde() {
    return qtde;
  }

  public void setQtde(int PARAM) {
    this.qtde = PARAM;
  }

  public int getPares() {
    return pares;
  }

  public void setPares(int PARAM) {
    this.pares = PARAM;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double PARAM) {
    this.valor = PARAM;
  }

}

package portalbr.dbobj.view;

/** DataBase Object from table .Jw_apontamento_caixas_corrugadas_resumo
  * @version 23/09/2022 12:25:15
  */
public class Jw_apontamento_caixas_corrugadas_resumo implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer lin_cdgo;
  private java.lang.Integer total_caixas;
  private java.lang.Integer caixas_pendentes;

  public Jw_apontamento_caixas_corrugadas_resumo() {
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.Integer getTotal_caixas() {
    return total_caixas;
  }

  public void setTotal_caixas(java.lang.Integer PARAM) {
    this.total_caixas = PARAM;
  }

  public java.lang.Integer getCaixas_pendentes() {
    return caixas_pendentes;
  }

  public void setCaixas_pendentes(java.lang.Integer PARAM) {
    this.caixas_pendentes = PARAM;
  }

}

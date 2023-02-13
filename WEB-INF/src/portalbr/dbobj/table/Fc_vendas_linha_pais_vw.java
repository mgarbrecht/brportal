package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Fc_vendas_linha_pais_vw
  * @version 21/08/2013 11:19:04
  */
public class Fc_vendas_linha_pais_vw implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer mes;
  private java.lang.Integer ano;
  private java.lang.Integer cli_cdgo;
  private java.lang.Double lin_cdgo;
  private java.lang.Double qtd;
  private java.lang.Double vlr;

  public Fc_vendas_linha_pais_vw() {
  }

  public java.lang.Integer getMes() {
    return mes;
  }

  public void setMes(java.lang.Integer PARAM) {
    this.mes = PARAM;
  }

  public java.lang.Integer getAno() {
    return ano;
  }

  public void setAno(java.lang.Integer PARAM) {
    this.ano = PARAM;
  }

  public java.lang.Integer getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.Integer PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.Double getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Double PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.Double getQtd() {
    return qtd;
  }

  public void setQtd(java.lang.Double PARAM) {
    this.qtd = PARAM;
  }

  public java.lang.Double getVlr() {
    return vlr;
  }

  public void setVlr(java.lang.Double PARAM) {
    this.vlr = PARAM;
  }

}

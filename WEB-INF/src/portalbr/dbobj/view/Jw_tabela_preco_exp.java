package portalbr.dbobj.view;

/** DataBase Object from table .Jw_tabela_preco_exp
  * @version 16/10/2015 10:32:14
  */
public class Jw_tabela_preco_exp implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String imagem;
  private java.lang.String marca;
  private java.lang.String modelo;
  private java.lang.String cabedal;
  private java.lang.String cor;
  private java.sql.Timestamp versao_tabela_tp;
  private java.lang.String nro_ini_brasil;
  private java.lang.String nro_ini_europa;
  private java.lang.String nro_fin_brasil;
  private java.lang.String nro_fin_europa;
  private double preco;
  private java.lang.String moeda;
  private java.lang.String cab_cdgo;

  public Jw_tabela_preco_exp() {
  }

  public java.lang.String getImagem() {
    return imagem;
  }

  public void setImagem(java.lang.String PARAM) {
    this.imagem = PARAM;
  }

  public java.lang.String getMarca() {
    return marca;
  }

  public void setMarca(java.lang.String PARAM) {
    this.marca = PARAM;
  }

  public java.lang.String getModelo() {
    return modelo;
  }

  public void setModelo(java.lang.String PARAM) {
    this.modelo = PARAM;
  }

  public java.lang.String getCabedal() {
    return cabedal;
  }

  public void setCabedal(java.lang.String PARAM) {
    this.cabedal = PARAM;
  }

  public java.lang.String getCor() {
    return cor;
  }

  public void setCor(java.lang.String PARAM) {
    this.cor = PARAM;
  }

  public java.sql.Timestamp getVersao_tabela_tp() {
    return versao_tabela_tp;
  }

  public void setVersao_tabela_tp(java.sql.Timestamp PARAM) {
    this.versao_tabela_tp = PARAM;
  }

  public java.lang.String getNro_ini_brasil() {
    return nro_ini_brasil;
  }

  public void setNro_ini_brasil(java.lang.String PARAM) {
    this.nro_ini_brasil = PARAM;
  }

  public java.lang.String getNro_ini_europa() {
    return nro_ini_europa;
  }

  public void setNro_ini_europa(java.lang.String PARAM) {
    this.nro_ini_europa = PARAM;
  }

  public java.lang.String getNro_fin_brasil() {
    return nro_fin_brasil;
  }

  public void setNro_fin_brasil(java.lang.String PARAM) {
    this.nro_fin_brasil = PARAM;
  }

  public java.lang.String getNro_fin_europa() {
    return nro_fin_europa;
  }

  public void setNro_fin_europa(java.lang.String PARAM) {
    this.nro_fin_europa = PARAM;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double PARAM) {
    this.preco = PARAM;
  }

  public java.lang.String getMoeda() {
    return moeda;
  }

  public void setMoeda(java.lang.String PARAM) {
    this.moeda = PARAM;
  }

  public java.lang.String getCab_cdgo() {
    return cab_cdgo;
  }

  public void setCab_cdgo(java.lang.String PARAM) {
    this.cab_cdgo = PARAM;
  }

}

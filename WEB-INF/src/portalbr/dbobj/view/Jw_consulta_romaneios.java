package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_romaneios
  * @version 22/10/2015 14:28:53
  */
public class Jw_consulta_romaneios implements java.io.Serializable, com.egen.util.jdbc.View {
  private double nro_romaneio_embarque;
  private double nfs_nmro;
  private java.lang.String nfs_serie;
  private java.sql.Date nfs_dtemis;
  private double nfs_vltot;
  private java.lang.String fil_filial;
  private java.lang.String cliente;
  private java.lang.String cidade;
  private java.lang.String uf;
  private java.lang.Integer nfs_qtdvol;
  private java.lang.Integer nfs_total_pares;
  private java.lang.String conhecimentos;
  private java.lang.String ped_nmro;

  public Jw_consulta_romaneios() {
  }

  public double getNro_romaneio_embarque() {
    return nro_romaneio_embarque;
  }

  public void setNro_romaneio_embarque(double PARAM) {
    this.nro_romaneio_embarque = PARAM;
  }

  public double getNfs_nmro() {
    return nfs_nmro;
  }

  public void setNfs_nmro(double PARAM) {
    this.nfs_nmro = PARAM;
  }

  public java.lang.String getNfs_serie() {
    return nfs_serie;
  }

  public void setNfs_serie(java.lang.String PARAM) {
    this.nfs_serie = PARAM;
  }

  public java.sql.Date getNfs_dtemis() {
    return nfs_dtemis;
  }

  public void setNfs_dtemis(java.sql.Date PARAM) {
    this.nfs_dtemis = PARAM;
  }

  public double getNfs_vltot() {
    return nfs_vltot;
  }

  public void setNfs_vltot(double PARAM) {
    this.nfs_vltot = PARAM;
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.lang.String getCliente() {
    return cliente;
  }

  public void setCliente(java.lang.String PARAM) {
    this.cliente = PARAM;
  }

  public java.lang.String getCidade() {
    return cidade;
  }

  public void setCidade(java.lang.String PARAM) {
    this.cidade = PARAM;
  }

  public java.lang.String getUf() {
    return uf;
  }

  public void setUf(java.lang.String PARAM) {
    this.uf = PARAM;
  }

  public java.lang.Integer getNfs_qtdvol() {
    return nfs_qtdvol;
  }

  public void setNfs_qtdvol(java.lang.Integer PARAM) {
    this.nfs_qtdvol = PARAM;
  }

  public java.lang.Integer getNfs_total_pares() {
    return nfs_total_pares;
  }

  public void setNfs_total_pares(java.lang.Integer PARAM) {
    this.nfs_total_pares = PARAM;
  }

  public java.lang.String getConhecimentos() {
    return conhecimentos;
  }

  public void setConhecimentos(java.lang.String PARAM) {
    this.conhecimentos = PARAM;
  }

  public java.lang.String getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(java.lang.String PARAM) {
    this.ped_nmro = PARAM;
  }

}

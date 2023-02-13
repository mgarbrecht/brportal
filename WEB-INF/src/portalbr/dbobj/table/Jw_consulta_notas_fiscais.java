package portalbr.dbobj.table;

/** DataBase Object from table .Jw_consulta_notas_fiscais
  * @version 27/05/2010 10:16:09
  */
public class Jw_consulta_notas_fiscais implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.String nota;
  private java.lang.String fil_filial;
  private java.lang.String cc;
  private java.lang.String ecl_cdad;
  private java.lang.String est_unifed;
  private java.lang.String linha;
  private java.sql.Timestamp nfs_dtemis;
  private java.lang.Integer nfs_nmro;
  private java.lang.String nfs_serie;
  private java.lang.Double nfs_valicm;
  private java.lang.Integer nfs_qtdvol;
  private java.lang.Integer qtde_de_notas;
  private java.lang.Double nfs_vltot;
  private java.lang.String sigla_trans;
  private java.lang.String nro_romaneio_embarque;
  private java.sql.Timestamp finalizacao_romaneio;
  private java.lang.String conhecimentos;
  private double nfs_total_pares;

  public Jw_consulta_notas_fiscais() {
  }

  public java.lang.String getNota() {
    return nota;
  }

  public void setNota(java.lang.String PARAM) {
    this.nota = PARAM;
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.lang.String getCc() {
    return cc;
  }

  public void setCc(java.lang.String PARAM) {
    this.cc = PARAM;
  }

  public java.lang.String getEcl_cdad() {
    return ecl_cdad;
  }

  public void setEcl_cdad(java.lang.String PARAM) {
    this.ecl_cdad = PARAM;
  }

  public java.lang.String getEst_unifed() {
    return est_unifed;
  }

  public void setEst_unifed(java.lang.String PARAM) {
    this.est_unifed = PARAM;
  }

  public java.lang.String getLinha() {
    return linha;
  }

  public void setLinha(java.lang.String PARAM) {
    this.linha = PARAM;
  }

  public java.sql.Timestamp getNfs_dtemis() {
    return nfs_dtemis;
  }

  public void setNfs_dtemis(java.sql.Timestamp PARAM) {
    this.nfs_dtemis = PARAM;
  }

  public java.lang.Integer getNfs_nmro() {
    return nfs_nmro;
  }

  public void setNfs_nmro(java.lang.Integer PARAM) {
    this.nfs_nmro = PARAM;
  }

  public java.lang.String getNfs_serie() {
    return nfs_serie;
  }

  public void setNfs_serie(java.lang.String PARAM) {
    this.nfs_serie = PARAM;
  }

  public java.lang.Double getNfs_valicm() {
    return nfs_valicm;
  }

  public void setNfs_valicm(java.lang.Double PARAM) {
    this.nfs_valicm = PARAM;
  }

  public java.lang.Integer getNfs_qtdvol() {
    return nfs_qtdvol;
  }

  public void setNfs_qtdvol(java.lang.Integer PARAM) {
    this.nfs_qtdvol = PARAM;
  }

  public java.lang.Integer getQtde_de_notas() {
    return qtde_de_notas;
  }

  public void setQtde_de_notas(java.lang.Integer PARAM) {
    this.qtde_de_notas = PARAM;
  }

  public java.lang.Double getNfs_vltot() {
    return nfs_vltot;
  }

  public void setNfs_vltot(java.lang.Double PARAM) {
    this.nfs_vltot = PARAM;
  }

  public java.lang.String getSigla_trans() {
    return sigla_trans;
  }

  public void setSigla_trans(java.lang.String PARAM) {
    this.sigla_trans = PARAM;
  }

  public java.lang.String getNro_romaneio_embarque() {
    return nro_romaneio_embarque;
  }

  public void setNro_romaneio_embarque(java.lang.String PARAM) {
    this.nro_romaneio_embarque = PARAM;
  }

  public java.sql.Timestamp getFinalizacao_romaneio() {
    return finalizacao_romaneio;
  }

  public void setFinalizacao_romaneio(java.sql.Timestamp PARAM) {
    this.finalizacao_romaneio = PARAM;
  }

  public java.lang.String getConhecimentos() {
    return conhecimentos;
  }

  public void setConhecimentos(java.lang.String PARAM) {
    this.conhecimentos = PARAM;
  }

  public double getNfs_total_pares() {
    return nfs_total_pares;
  }

  public void setNfs_total_pares(double PARAM) {
    this.nfs_total_pares = PARAM;
  }

}

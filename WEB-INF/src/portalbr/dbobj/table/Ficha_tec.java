package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ficha_tec
  * @version 05/08/2014 09:51:14
  */
public class Ficha_tec implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int lin_cdgo;
  private int ref_cdgo;
  private int cab_cdgo;
  private int fit_versao;
  private java.sql.Timestamp fit_implan;
  private java.lang.Integer mat_nro;
  private java.lang.String fil_filial;
  private java.lang.String emp_empresa;
  private java.lang.String fit_status;
  private java.lang.Integer cod_peca;
  private int cor_cdgo;
  private java.lang.Double qtde_formula;
  private java.lang.String forma;
  private java.lang.String fit_imagem;
  private java.lang.String fit_liberada;
  private java.lang.String tipo_material_forro;
  private java.sql.Date fit_data_liberada;

  public Ficha_tec() {
  }

  public int getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(int PARAM) {
    this.lin_cdgo = PARAM;
  }

  public int getRef_cdgo() {
    return ref_cdgo;
  }

  public void setRef_cdgo(int PARAM) {
    this.ref_cdgo = PARAM;
  }

  public int getCab_cdgo() {
    return cab_cdgo;
  }

  public void setCab_cdgo(int PARAM) {
    this.cab_cdgo = PARAM;
  }

  public int getFit_versao() {
    return fit_versao;
  }

  public void setFit_versao(int PARAM) {
    this.fit_versao = PARAM;
  }

  public java.sql.Timestamp getFit_implan() {
    return fit_implan;
  }

  public void setFit_implan(java.sql.Timestamp PARAM) {
    this.fit_implan = PARAM;
  }

  public java.lang.Integer getMat_nro() {
    return mat_nro;
  }

  public void setMat_nro(java.lang.Integer PARAM) {
    this.mat_nro = PARAM;
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.lang.String getEmp_empresa() {
    return emp_empresa;
  }

  public void setEmp_empresa(java.lang.String PARAM) {
    this.emp_empresa = PARAM;
  }

  public java.lang.String getFit_status() {
    return fit_status;
  }

  public void setFit_status(java.lang.String PARAM) {
    this.fit_status = PARAM;
  }

  public java.lang.Integer getCod_peca() {
    return cod_peca;
  }

  public void setCod_peca(java.lang.Integer PARAM) {
    this.cod_peca = PARAM;
  }

  public int getCor_cdgo() {
    return cor_cdgo;
  }

  public void setCor_cdgo(int PARAM) {
    this.cor_cdgo = PARAM;
  }

  public java.lang.Double getQtde_formula() {
    return qtde_formula;
  }

  public void setQtde_formula(java.lang.Double PARAM) {
    this.qtde_formula = PARAM;
  }

  public java.lang.String getForma() {
    return forma;
  }

  public void setForma(java.lang.String PARAM) {
    this.forma = PARAM;
  }

  public java.lang.String getFit_imagem() {
    return fit_imagem;
  }

  public void setFit_imagem(java.lang.String PARAM) {
    this.fit_imagem = PARAM;
  }

  public java.lang.String getFit_liberada() {
    return fit_liberada;
  }

  public void setFit_liberada(java.lang.String PARAM) {
    this.fit_liberada = PARAM;
  }

  public java.lang.String getTipo_material_forro() {
    return tipo_material_forro;
  }

  public void setTipo_material_forro(java.lang.String PARAM) {
    this.tipo_material_forro = PARAM;
  }

  public java.sql.Date getFit_data_liberada() {
    return fit_data_liberada;
  }

  public void setFit_data_liberada(java.sql.Date PARAM) {
    this.fit_data_liberada = PARAM;
  }

}

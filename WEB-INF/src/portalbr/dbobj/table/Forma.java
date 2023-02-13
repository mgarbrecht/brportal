package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Forma
  * @version 03/04/2013 09:56:23
  */
public class Forma implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer mat_nro;
  private java.lang.String fma_cdgo;
  private java.lang.String fma_nchave;
  private java.lang.String fma_espec;
  private java.lang.String fma_obs;
  private java.lang.Integer fma_tipo_material_cdgo;
  private java.lang.Integer fma_tipo_forma_cdgo;
  private java.sql.Date vigencia_inicial;
  private java.sql.Date vigencia_final;
  private java.sql.Date data_cadastro;
  private java.lang.String usuario_cadastro;
  private java.lang.String fma_altura_salto;
  private java.lang.String fma_imagem;
  private java.lang.String fma_altura_bico;
  private java.lang.String fma_base;
  private java.lang.Integer for_codigo;

  public Forma() {
  }

  public java.lang.Integer getMat_nro() {
    return mat_nro;
  }

  public void setMat_nro(java.lang.Integer PARAM) {
    this.mat_nro = PARAM;
  }

  public java.lang.String getFma_cdgo() {
    return fma_cdgo;
  }

  public void setFma_cdgo(java.lang.String PARAM) {
    this.fma_cdgo = PARAM;
  }

  public java.lang.String getFma_nchave() {
    return fma_nchave;
  }

  public void setFma_nchave(java.lang.String PARAM) {
    this.fma_nchave = PARAM;
  }

  public java.lang.String getFma_espec() {
    return fma_espec;
  }

  public void setFma_espec(java.lang.String PARAM) {
    this.fma_espec = PARAM;
  }

  public java.lang.String getFma_obs() {
    return fma_obs;
  }

  public void setFma_obs(java.lang.String PARAM) {
    this.fma_obs = PARAM;
  }

  public java.lang.Integer getFma_tipo_material_cdgo() {
    return fma_tipo_material_cdgo;
  }

  public void setFma_tipo_material_cdgo(java.lang.Integer PARAM) {
    this.fma_tipo_material_cdgo = PARAM;
  }

  public java.lang.Integer getFma_tipo_forma_cdgo() {
    return fma_tipo_forma_cdgo;
  }

  public void setFma_tipo_forma_cdgo(java.lang.Integer PARAM) {
    this.fma_tipo_forma_cdgo = PARAM;
  }

  public java.sql.Date getVigencia_inicial() {
    return vigencia_inicial;
  }

  public void setVigencia_inicial(java.sql.Date PARAM) {
    this.vigencia_inicial = PARAM;
  }

  public java.sql.Date getVigencia_final() {
    return vigencia_final;
  }

  public void setVigencia_final(java.sql.Date PARAM) {
    this.vigencia_final = PARAM;
  }

  public java.sql.Date getData_cadastro() {
    return data_cadastro;
  }

  public void setData_cadastro(java.sql.Date PARAM) {
    this.data_cadastro = PARAM;
  }

  public java.lang.String getUsuario_cadastro() {
    return usuario_cadastro;
  }

  public void setUsuario_cadastro(java.lang.String PARAM) {
    this.usuario_cadastro = PARAM;
  }

  public java.lang.String getFma_altura_salto() {
    return fma_altura_salto;
  }

  public void setFma_altura_salto(java.lang.String PARAM) {
    this.fma_altura_salto = PARAM;
  }

  public java.lang.String getFma_imagem() {
    return fma_imagem;
  }

  public void setFma_imagem(java.lang.String PARAM) {
    this.fma_imagem = PARAM;
  }

  public java.lang.String getFma_altura_bico() {
    return fma_altura_bico;
  }

  public void setFma_altura_bico(java.lang.String PARAM) {
    this.fma_altura_bico = PARAM;
  }

  public java.lang.String getFma_base() {
    return fma_base;
  }

  public void setFma_base(java.lang.String PARAM) {
    this.fma_base = PARAM;
  }

  public java.lang.Integer getFor_codigo() {
    return for_codigo;
  }

  public void setFor_codigo(java.lang.Integer PARAM) {
    this.for_codigo = PARAM;
  }

}

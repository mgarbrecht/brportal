package portalbr.dbobj.view;

/** DataBase Object from table .Jw_arquivos_talao
  * @version 22/09/2016 16:04:18
  */
public class Jw_arquivos_talao implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer forn_codigo;
  private java.lang.Integer interface_arq_compra_id;
  private java.lang.Integer oco_numero;
  private java.lang.Integer rem_nro;
  private java.lang.String fil_filial;
  private java.lang.String arquivo_edi;
  private java.lang.String situacao;
  private java.lang.String descricao_situacao;
  private java.lang.String forn_razsoc;
  private java.sql.Date data_compra;
  private java.lang.Integer lin_cdgo;
  private java.lang.String lin_nome;

  public Jw_arquivos_talao() {
  }

  public java.lang.Integer getForn_codigo() {
    return forn_codigo;
  }

  public void setForn_codigo(java.lang.Integer PARAM) {
    this.forn_codigo = PARAM;
  }

  public java.lang.Integer getInterface_arq_compra_id() {
    return interface_arq_compra_id;
  }

  public void setInterface_arq_compra_id(java.lang.Integer PARAM) {
    this.interface_arq_compra_id = PARAM;
  }

  public java.lang.Integer getOco_numero() {
    return oco_numero;
  }

  public void setOco_numero(java.lang.Integer PARAM) {
    this.oco_numero = PARAM;
  }

  public java.lang.Integer getRem_nro() {
    return rem_nro;
  }

  public void setRem_nro(java.lang.Integer PARAM) {
    this.rem_nro = PARAM;
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.lang.String getArquivo_edi() {
    return arquivo_edi;
  }

  public void setArquivo_edi(java.lang.String PARAM) {
    this.arquivo_edi = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

  public java.lang.String getDescricao_situacao() {
    return descricao_situacao;
  }

  public void setDescricao_situacao(java.lang.String PARAM) {
    this.descricao_situacao = PARAM;
  }

  public java.lang.String getForn_razsoc() {
    return forn_razsoc;
  }

  public void setForn_razsoc(java.lang.String PARAM) {
    this.forn_razsoc = PARAM;
  }

  public java.sql.Date getData_compra() {
    return data_compra;
  }

  public void setData_compra(java.sql.Date PARAM) {
    this.data_compra = PARAM;
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.String getLin_nome() {
    return lin_nome;
  }

  public void setLin_nome(java.lang.String PARAM) {
    this.lin_nome = PARAM;
  }

}

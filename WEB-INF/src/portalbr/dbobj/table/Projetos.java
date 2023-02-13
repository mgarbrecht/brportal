package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Projetos
  * @version 22/11/2010 11:41:05
  */
public class Projetos implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.String projeto_cdgo;
  private java.lang.String projeto_desc;
  private java.lang.Integer codigo_colecao;
  private java.lang.Integer codigo_marca;
  private java.lang.Integer lin_cdgo;
  private java.sql.Date data_inicio;
  private java.sql.Date data_fim;
  private java.lang.Integer tipo_cdgo;
  private java.lang.Integer nro_modelos;
  private java.lang.String status;
  private java.sql.Date data_criacao;
  private java.lang.Integer codigo_subdivisao;
  private java.lang.String fma_cdgo;

  public Projetos() {
  }

  public java.lang.String getProjeto_cdgo() {
    return projeto_cdgo;
  }

  public void setProjeto_cdgo(java.lang.String PARAM) {
    this.projeto_cdgo = PARAM;
  }

  public java.lang.String getProjeto_desc() {
    return projeto_desc;
  }

  public void setProjeto_desc(java.lang.String PARAM) {
    this.projeto_desc = PARAM;
  }

  public java.lang.Integer getCodigo_colecao() {
    return codigo_colecao;
  }

  public void setCodigo_colecao(java.lang.Integer PARAM) {
    this.codigo_colecao = PARAM;
  }

  public java.lang.Integer getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(java.lang.Integer PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.sql.Date getData_inicio() {
    return data_inicio;
  }

  public void setData_inicio(java.sql.Date PARAM) {
    this.data_inicio = PARAM;
  }

  public java.sql.Date getData_fim() {
    return data_fim;
  }

  public void setData_fim(java.sql.Date PARAM) {
    this.data_fim = PARAM;
  }

  public java.lang.Integer getTipo_cdgo() {
    return tipo_cdgo;
  }

  public void setTipo_cdgo(java.lang.Integer PARAM) {
    this.tipo_cdgo = PARAM;
  }

  public java.lang.Integer getNro_modelos() {
    return nro_modelos;
  }

  public void setNro_modelos(java.lang.Integer PARAM) {
    this.nro_modelos = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

  public java.sql.Date getData_criacao() {
    return data_criacao;
  }

  public void setData_criacao(java.sql.Date PARAM) {
    this.data_criacao = PARAM;
  }

  public java.lang.Integer getCodigo_subdivisao() {
    return codigo_subdivisao;
  }

  public void setCodigo_subdivisao(java.lang.Integer PARAM) {
    this.codigo_subdivisao = PARAM;
  }

  public java.lang.String getFma_cdgo() {
    return fma_cdgo;
  }

  public void setFma_cdgo(java.lang.String PARAM) {
    this.fma_cdgo = PARAM;
  }

}

package portalbr.dbobj.table;

/** DataBase Object from table EXP.Tabela_preco_mercado_externo
  * @version 05/08/2014 12:07:03
  */
public class Tabela_preco_mercado_externo implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer codigo_livro;
  private java.lang.Integer codigo_pais;
  private java.sql.Timestamp versao_tabela;
  private java.lang.Integer codigo_linha;
  private java.lang.Integer codigo_referencia;
  private java.lang.Double preco_unitario;
  private java.lang.String status;
  private java.lang.Integer codigo_cabedal;

  public Tabela_preco_mercado_externo() {
  }

  public java.lang.Integer getCodigo_livro() {
    return codigo_livro;
  }

  public void setCodigo_livro(java.lang.Integer PARAM) {
    this.codigo_livro = PARAM;
  }

  public java.lang.Integer getCodigo_pais() {
    return codigo_pais;
  }

  public void setCodigo_pais(java.lang.Integer PARAM) {
    this.codigo_pais = PARAM;
  }

  public java.sql.Timestamp getVersao_tabela() {
    return versao_tabela;
  }

  public void setVersao_tabela(java.sql.Timestamp PARAM) {
    this.versao_tabela = PARAM;
  }

  public java.lang.Integer getCodigo_linha() {
    return codigo_linha;
  }

  public void setCodigo_linha(java.lang.Integer PARAM) {
    this.codigo_linha = PARAM;
  }

  public java.lang.Integer getCodigo_referencia() {
    return codigo_referencia;
  }

  public void setCodigo_referencia(java.lang.Integer PARAM) {
    this.codigo_referencia = PARAM;
  }

  public java.lang.Double getPreco_unitario() {
    return preco_unitario;
  }

  public void setPreco_unitario(java.lang.Double PARAM) {
    this.preco_unitario = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

  public java.lang.Integer getCodigo_cabedal() {
    return codigo_cabedal;
  }

  public void setCodigo_cabedal(java.lang.Integer PARAM) {
    this.codigo_cabedal = PARAM;
  }

}

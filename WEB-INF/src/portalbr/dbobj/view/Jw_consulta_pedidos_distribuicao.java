package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_pedidos_distribuicao
  * @version 29/10/2021 10:45:09
  */
public class Jw_consulta_pedidos_distribuicao implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer ped_nmro;
  private java.lang.Integer item;
  private java.lang.Integer quantidade_pares;
  private java.lang.Integer grade;
  private java.lang.Integer codigo_corrugado;
  private java.lang.Integer qt_par_corrug;
  private java.lang.Integer total_caixas;
  private java.lang.String descricao_corrugado;
  private java.lang.Integer qtde_caixas_distribuidas;
  private java.lang.String ite_situ;
  private java.lang.String ite_stat;

  public Jw_consulta_pedidos_distribuicao() {
  }

  public java.lang.Integer getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(java.lang.Integer PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.Integer getItem() {
    return item;
  }

  public void setItem(java.lang.Integer PARAM) {
    this.item = PARAM;
  }

  public java.lang.Integer getQuantidade_pares() {
    return quantidade_pares;
  }

  public void setQuantidade_pares(java.lang.Integer PARAM) {
    this.quantidade_pares = PARAM;
  }

  public java.lang.Integer getGrade() {
    return grade;
  }

  public void setGrade(java.lang.Integer PARAM) {
    this.grade = PARAM;
  }

  public java.lang.Integer getCodigo_corrugado() {
    return codigo_corrugado;
  }

  public void setCodigo_corrugado(java.lang.Integer PARAM) {
    this.codigo_corrugado = PARAM;
  }

  public java.lang.Integer getQt_par_corrug() {
    return qt_par_corrug;
  }

  public void setQt_par_corrug(java.lang.Integer PARAM) {
    this.qt_par_corrug = PARAM;
  }

  public java.lang.Integer getTotal_caixas() {
    return total_caixas;
  }

  public void setTotal_caixas(java.lang.Integer PARAM) {
    this.total_caixas = PARAM;
  }

  public java.lang.String getDescricao_corrugado() {
    return descricao_corrugado;
  }

  public void setDescricao_corrugado(java.lang.String PARAM) {
    this.descricao_corrugado = PARAM;
  }

  public java.lang.Integer getQtde_caixas_distribuidas() {
    return qtde_caixas_distribuidas;
  }

  public void setQtde_caixas_distribuidas(java.lang.Integer PARAM) {
    this.qtde_caixas_distribuidas = PARAM;
  }

  public java.lang.String getIte_situ() {
    return ite_situ;
  }

  public void setIte_situ(java.lang.String PARAM) {
    this.ite_situ = PARAM;
  }

  public java.lang.String getIte_stat() {
    return ite_stat;
  }

  public void setIte_stat(java.lang.String PARAM) {
    this.ite_stat = PARAM;
  }

}

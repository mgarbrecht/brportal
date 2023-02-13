package portalbr.dbobj.view;

/** DataBase Object from table .Jw_fluxo_representante
  * @version 25/03/2020 16:16:22
  */
public class Jw_fluxo_representante implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo_regional;
  private java.lang.String nome_regional;
  private java.lang.String rep_cdgo;
  private java.lang.String rep_rzao;
  private java.lang.Integer quantidade_meses;
  private java.lang.String descricao_quantidade_meses;
  private java.lang.Integer clientes;

  public Jw_fluxo_representante() {
  }

  public java.lang.Integer getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.Integer PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getNome_regional() {
    return nome_regional;
  }

  public void setNome_regional(java.lang.String PARAM) {
    this.nome_regional = PARAM;
  }

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

  public java.lang.String getRep_rzao() {
    return rep_rzao;
  }

  public void setRep_rzao(java.lang.String PARAM) {
    this.rep_rzao = PARAM;
  }

  public java.lang.Integer getQuantidade_meses() {
    return quantidade_meses;
  }

  public void setQuantidade_meses(java.lang.Integer PARAM) {
    this.quantidade_meses = PARAM;
  }

  public java.lang.String getDescricao_quantidade_meses() {
    return descricao_quantidade_meses;
  }

  public void setDescricao_quantidade_meses(java.lang.String PARAM) {
    this.descricao_quantidade_meses = PARAM;
  }

  public java.lang.Integer getClientes() {
    return clientes;
  }

  public void setClientes(java.lang.Integer PARAM) {
    this.clientes = PARAM;
  }

}

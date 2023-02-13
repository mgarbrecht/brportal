package portalbr.dbobj.view;

/** DataBase Object from table .Jw_poi_aberto_representante
  * @version 03/04/2013 09:17:19
  */
public class Jw_poi_aberto_representante implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String rep_cdgo;
  private java.lang.String rep_rzao;
  private java.lang.String desc_marca;
  private java.lang.Integer codigo_regional;
  private java.lang.String nome_regional;
  private java.lang.Integer codigo_gerente;
  private java.lang.String nome_gerente;
  private java.lang.String endereco;
  private java.lang.String estado_gerente;

  public Jw_poi_aberto_representante() {
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

  public java.lang.String getDesc_marca() {
    return desc_marca;
  }

  public void setDesc_marca(java.lang.String PARAM) {
    this.desc_marca = PARAM;
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

  public java.lang.Integer getCodigo_gerente() {
    return codigo_gerente;
  }

  public void setCodigo_gerente(java.lang.Integer PARAM) {
    this.codigo_gerente = PARAM;
  }

  public java.lang.String getNome_gerente() {
    return nome_gerente;
  }

  public void setNome_gerente(java.lang.String PARAM) {
    this.nome_gerente = PARAM;
  }

  public java.lang.String getEndereco() {
    return endereco;
  }

  public void setEndereco(java.lang.String PARAM) {
    this.endereco = PARAM;
  }

  public java.lang.String getEstado_gerente() {
    return estado_gerente;
  }

  public void setEstado_gerente(java.lang.String PARAM) {
    this.estado_gerente = PARAM;
  }

}

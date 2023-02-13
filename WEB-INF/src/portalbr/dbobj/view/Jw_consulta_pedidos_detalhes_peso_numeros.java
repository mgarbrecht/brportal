package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_pedidos_detalhes_peso_numeros
  * @version 03/04/2013 09:33:27
  */
public class Jw_consulta_pedidos_detalhes_peso_numeros implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo;
  private java.lang.String descricao;
  private java.lang.String numero;
  private java.lang.Double peso_embalagem;
  private java.lang.Double peso_sapato;
  private java.lang.Double peso_adicional;
  private java.lang.Integer lin_cdgo;
  private java.lang.Integer ref_cdgo;
  private java.lang.Integer codigo_embalagem;

  public Jw_consulta_pedidos_detalhes_peso_numeros() {
  }

  public java.lang.Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.Integer PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.String getNumero() {
    return numero;
  }

  public void setNumero(java.lang.String PARAM) {
    this.numero = PARAM;
  }

  public java.lang.Double getPeso_embalagem() {
    return peso_embalagem;
  }

  public void setPeso_embalagem(java.lang.Double PARAM) {
    this.peso_embalagem = PARAM;
  }

  public java.lang.Double getPeso_sapato() {
    return peso_sapato;
  }

  public void setPeso_sapato(java.lang.Double PARAM) {
    this.peso_sapato = PARAM;
  }

  public java.lang.Double getPeso_adicional() {
    return peso_adicional;
  }

  public void setPeso_adicional(java.lang.Double PARAM) {
    this.peso_adicional = PARAM;
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.Integer getRef_cdgo() {
    return ref_cdgo;
  }

  public void setRef_cdgo(java.lang.Integer PARAM) {
    this.ref_cdgo = PARAM;
  }

  public java.lang.Integer getCodigo_embalagem() {
    return codigo_embalagem;
  }

  public void setCodigo_embalagem(java.lang.Integer PARAM) {
    this.codigo_embalagem = PARAM;
  }

}

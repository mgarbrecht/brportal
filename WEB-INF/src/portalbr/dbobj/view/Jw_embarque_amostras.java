package portalbr.dbobj.view;

/** DataBase Object from table .Jw_embarque_amostras
  * @version 03/04/2013 09:31:07
  */
public class Jw_embarque_amostras implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer marca;
  private java.lang.String descricao_marca;
  private java.lang.String tipo_linha;
  private java.lang.String ind_aberto_fechado;
  private java.lang.String fil_filial;
  private java.sql.Date data_embarque;
  private java.lang.Integer lin_cdgo;
  private java.lang.Integer ref_cdgo;
  private java.lang.Double preco;

  public Jw_embarque_amostras() {
  }

  public java.lang.Integer getMarca() {
    return marca;
  }

  public void setMarca(java.lang.Integer PARAM) {
    this.marca = PARAM;
  }

  public java.lang.String getDescricao_marca() {
    return descricao_marca;
  }

  public void setDescricao_marca(java.lang.String PARAM) {
    this.descricao_marca = PARAM;
  }

  public java.lang.String getTipo_linha() {
    return tipo_linha;
  }

  public void setTipo_linha(java.lang.String PARAM) {
    this.tipo_linha = PARAM;
  }

  public java.lang.String getInd_aberto_fechado() {
    return ind_aberto_fechado;
  }

  public void setInd_aberto_fechado(java.lang.String PARAM) {
    this.ind_aberto_fechado = PARAM;
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.sql.Date getData_embarque() {
    return data_embarque;
  }

  public void setData_embarque(java.sql.Date PARAM) {
    this.data_embarque = PARAM;
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

  public java.lang.Double getPreco() {
    return preco;
  }

  public void setPreco(java.lang.Double PARAM) {
    this.preco = PARAM;
  }

}

package portalbr.dbobj.view;

/** DataBase Object from table .Jw_interface_arq_compra
  * @version 18/08/2015 14:16:00
  */
public class Jw_interface_arq_compra implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer interface_arq_compra_id;
  private java.lang.Integer forn_codigo;
  private java.lang.String nome_arquivo;
  private java.lang.String situacao;
  private java.lang.String descricao_situacao;

  public Jw_interface_arq_compra() {
  }

  public java.lang.Integer getInterface_arq_compra_id() {
    return interface_arq_compra_id;
  }

  public void setInterface_arq_compra_id(java.lang.Integer PARAM) {
    this.interface_arq_compra_id = PARAM;
  }

  public java.lang.Integer getForn_codigo() {
    return forn_codigo;
  }

  public void setForn_codigo(java.lang.Integer PARAM) {
    this.forn_codigo = PARAM;
  }

  public java.lang.String getNome_arquivo() {
    return nome_arquivo;
  }

  public void setNome_arquivo(java.lang.String PARAM) {
    this.nome_arquivo = PARAM;
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

}

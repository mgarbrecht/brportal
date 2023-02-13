package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ref_combinacao_especial_img
  * @version 09/06/2015 16:04:20
  */
public class Ref_combinacao_especial_img implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer id_solicitacao;
  private java.lang.Integer id_imagem;
  private java.lang.String imagem;
  private java.lang.String descricao_imagem;

  public Ref_combinacao_especial_img() {
  }

  public java.lang.Integer getId_solicitacao() {
    return id_solicitacao;
  }

  public void setId_solicitacao(java.lang.Integer PARAM) {
    this.id_solicitacao = PARAM;
  }

  public java.lang.Integer getId_imagem() {
    return id_imagem;
  }

  public void setId_imagem(java.lang.Integer PARAM) {
    this.id_imagem = PARAM;
  }

  public java.lang.String getImagem() {
    return imagem;
  }

  public void setImagem(java.lang.String PARAM) {
    this.imagem = PARAM;
  }

  public java.lang.String getDescricao_imagem() {
    return descricao_imagem;
  }

  public void setDescricao_imagem(java.lang.String PARAM) {
    this.descricao_imagem = PARAM;
  }

}

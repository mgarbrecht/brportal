package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_cad_dados_clientes
  * @version 16/05/2014 08:54:02
  */
public class Jw_clientes_cad_dados_clientes implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String endereco;
  private java.lang.String cgc;
  private java.lang.String inscricao;
  private java.lang.String pessoa;
  private java.lang.String classificacao;
  private java.lang.String ind_prote;
  private java.lang.String nro_dias_prote;

  public Jw_clientes_cad_dados_clientes() {
  }

  public java.lang.String getEndereco() {
    return endereco;
  }

  public void setEndereco(java.lang.String PARAM) {
    this.endereco = PARAM;
  }

  public java.lang.String getCgc() {
    return cgc;
  }

  public void setCgc(java.lang.String PARAM) {
    this.cgc = PARAM;
  }

  public java.lang.String getInscricao() {
    return inscricao;
  }

  public void setInscricao(java.lang.String PARAM) {
    this.inscricao = PARAM;
  }

  public java.lang.String getPessoa() {
    return pessoa;
  }

  public void setPessoa(java.lang.String PARAM) {
    this.pessoa = PARAM;
  }

  public java.lang.String getClassificacao() {
    return classificacao;
  }

  public void setClassificacao(java.lang.String PARAM) {
    this.classificacao = PARAM;
  }

  public java.lang.String getInd_prote() {
    return ind_prote;
  }

  public void setInd_prote(java.lang.String PARAM) {
    this.ind_prote = PARAM;
  }

  public java.lang.String getNro_dias_prote() {
    return nro_dias_prote;
  }

  public void setNro_dias_prote(java.lang.String PARAM) {
    this.nro_dias_prote = PARAM;
  }

}

package portalbr.dbobj.view;

/** DataBase Object from table .Jw_plus_clientes_sequenciais
  * @version 03/04/2013 09:18:20
  */
public class Jw_plus_clientes_sequenciais implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String codigo;
  private java.lang.String razao_social;
  private java.lang.String cidade_uf;
  private java.lang.String seqn;
  private java.lang.String cod;

  public Jw_plus_clientes_sequenciais() {
  }

  public java.lang.String getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.String PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getRazao_social() {
    return razao_social;
  }

  public void setRazao_social(java.lang.String PARAM) {
    this.razao_social = PARAM;
  }

  public java.lang.String getCidade_uf() {
    return cidade_uf;
  }

  public void setCidade_uf(java.lang.String PARAM) {
    this.cidade_uf = PARAM;
  }

  public java.lang.String getSeqn() {
    return seqn;
  }

  public void setSeqn(java.lang.String PARAM) {
    this.seqn = PARAM;
  }

  public java.lang.String getCod() {
    return cod;
  }

  public void setCod(java.lang.String PARAM) {
    this.cod = PARAM;
  }

}

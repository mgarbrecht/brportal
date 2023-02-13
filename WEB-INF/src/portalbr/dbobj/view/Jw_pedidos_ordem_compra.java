package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pedidos_ordem_compra
  * @version 24/08/2016 15:13:38
  */
public class Jw_pedidos_ordem_compra implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer numero;
  private java.lang.String cliente;
  private java.lang.String sequencial;
  private java.lang.Integer grupo;
  private java.lang.String oc;
  private java.lang.String cli_rzao;
  private java.lang.String nome_grupo;
  private java.lang.String rep_cdgo;
  private java.lang.String regional;

  public Jw_pedidos_ordem_compra() {
  }

  public java.lang.Integer getNumero() {
    return numero;
  }

  public void setNumero(java.lang.Integer PARAM) {
    this.numero = PARAM;
  }

  public java.lang.String getCliente() {
    return cliente;
  }

  public void setCliente(java.lang.String PARAM) {
    this.cliente = PARAM;
  }

  public java.lang.String getSequencial() {
    return sequencial;
  }

  public void setSequencial(java.lang.String PARAM) {
    this.sequencial = PARAM;
  }

  public java.lang.Integer getGrupo() {
    return grupo;
  }

  public void setGrupo(java.lang.Integer PARAM) {
    this.grupo = PARAM;
  }

  public java.lang.String getOc() {
    return oc;
  }

  public void setOc(java.lang.String PARAM) {
    this.oc = PARAM;
  }

  public java.lang.String getCli_rzao() {
    return cli_rzao;
  }

  public void setCli_rzao(java.lang.String PARAM) {
    this.cli_rzao = PARAM;
  }

  public java.lang.String getNome_grupo() {
    return nome_grupo;
  }

  public void setNome_grupo(java.lang.String PARAM) {
    this.nome_grupo = PARAM;
  }

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

  public java.lang.String getRegional() {
    return regional;
  }

  public void setRegional(java.lang.String PARAM) {
    this.regional = PARAM;
  }

}

package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_novos_antigos
  * @version 16/05/2014 08:58:11
  */
public class Jw_clientes_novos_antigos implements java.io.Serializable, com.egen.util.jdbc.View {
  private int codigo_regional;
  private java.lang.String nome_regional;
  private int cli_cdgo;
  private java.lang.String cli_nome;
  private java.lang.String status;
  private int qtde;
  private double valor_total;

  public Jw_clientes_novos_antigos() {
  }

  public int getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(int PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getNome_regional() {
    return nome_regional;
  }

  public void setNome_regional(java.lang.String PARAM) {
    this.nome_regional = PARAM;
  }

  public int getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(int PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.String getCli_nome() {
    return cli_nome;
  }

  public void setCli_nome(java.lang.String PARAM) {
    this.cli_nome = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

  public int getQtde() {
    return qtde;
  }

  public void setQtde(int PARAM) {
    this.qtde = PARAM;
  }

  public double getValor_total() {
    return valor_total;
  }

  public void setValor_total(double PARAM) {
    this.valor_total = PARAM;
  }

}

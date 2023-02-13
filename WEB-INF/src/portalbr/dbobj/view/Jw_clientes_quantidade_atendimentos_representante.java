package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_quantidade_atendimentos_representante
  * @version 10/12/2020 15:06:25
  */
public class Jw_clientes_quantidade_atendimentos_representante implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer atendimentos;
  private java.lang.Integer clientes;
  private java.lang.Integer codigo_regional;
  private java.lang.String nome_regional;
  private java.lang.String rep_cdgo;
  private java.lang.String rep_rzao;

  public Jw_clientes_quantidade_atendimentos_representante() {
  }

  public java.lang.Integer getAtendimentos() {
    return atendimentos;
  }

  public void setAtendimentos(java.lang.Integer PARAM) {
    this.atendimentos = PARAM;
  }

  public java.lang.Integer getClientes() {
    return clientes;
  }

  public void setClientes(java.lang.Integer PARAM) {
    this.clientes = PARAM;
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

}

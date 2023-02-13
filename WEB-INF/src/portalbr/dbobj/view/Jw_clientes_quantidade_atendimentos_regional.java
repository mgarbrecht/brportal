package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_quantidade_atendimentos_regional
  * @version 10/12/2020 15:01:02
  */
public class Jw_clientes_quantidade_atendimentos_regional implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer atendimentos;
  private java.lang.Integer clientes;
  private java.lang.Integer codigo_regional;
  private java.lang.String nome_regional;

  public Jw_clientes_quantidade_atendimentos_regional() {
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

}

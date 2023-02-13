package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ficha_cliente_notas
  * @version 03/04/2013 09:29:33
  */
public class Jw_ficha_cliente_notas implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String empresa;
  private java.lang.Integer nota;
  private java.lang.String titulo;
  private java.sql.Date data_emissao;
  private java.sql.Date data_vencimento;
  private java.lang.Integer dias_vencido;
  private java.lang.Double valor;

  public Jw_ficha_cliente_notas() {
  }

  public java.lang.String getEmpresa() {
    return empresa;
  }

  public void setEmpresa(java.lang.String PARAM) {
    this.empresa = PARAM;
  }

  public java.lang.Integer getNota() {
    return nota;
  }

  public void setNota(java.lang.Integer PARAM) {
    this.nota = PARAM;
  }

  public java.lang.String getTitulo() {
    return titulo;
  }

  public void setTitulo(java.lang.String PARAM) {
    this.titulo = PARAM;
  }

  public java.sql.Date getData_emissao() {
    return data_emissao;
  }

  public void setData_emissao(java.sql.Date PARAM) {
    this.data_emissao = PARAM;
  }

  public java.sql.Date getData_vencimento() {
    return data_vencimento;
  }

  public void setData_vencimento(java.sql.Date PARAM) {
    this.data_vencimento = PARAM;
  }

  public java.lang.Integer getDias_vencido() {
    return dias_vencido;
  }

  public void setDias_vencido(java.lang.Integer PARAM) {
    this.dias_vencido = PARAM;
  }

  public java.lang.Double getValor() {
    return valor;
  }

  public void setValor(java.lang.Double PARAM) {
    this.valor = PARAM;
  }

}

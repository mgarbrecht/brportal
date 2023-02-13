package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acompanhamento_diario_vendas_total_marcas
  * @version 03/10/2019 15:41:08
  */
public class Jw_acompanhamento_diario_vendas_total_marcas implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo_regional;
  private java.lang.Integer codigo_marca;
  private java.lang.Integer cli_atend_marca_ano;
  private java.lang.Integer cli_atend_marca_ant;

  public Jw_acompanhamento_diario_vendas_total_marcas() {
  }

  public java.lang.Integer getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.Integer PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.Integer getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(java.lang.Integer PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.Integer getCli_atend_marca_ano() {
    return cli_atend_marca_ano;
  }

  public void setCli_atend_marca_ano(java.lang.Integer PARAM) {
    this.cli_atend_marca_ano = PARAM;
  }

  public java.lang.Integer getCli_atend_marca_ant() {
    return cli_atend_marca_ant;
  }

  public void setCli_atend_marca_ant(java.lang.Integer PARAM) {
    this.cli_atend_marca_ant = PARAM;
  }

}

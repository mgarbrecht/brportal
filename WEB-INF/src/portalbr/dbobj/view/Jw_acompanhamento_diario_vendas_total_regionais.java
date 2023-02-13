package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acompanhamento_diario_vendas_total_regionais
  * @version 26/01/2016 07:52:47
  */
public class Jw_acompanhamento_diario_vendas_total_regionais implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo_regional;
  private java.lang.Integer cli_atend_regional_ano;
  private java.lang.Integer cli_atend_regional_ant;

  public Jw_acompanhamento_diario_vendas_total_regionais() {
  }

  public java.lang.Integer getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.Integer PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.Integer getCli_atend_regional_ano() {
    return cli_atend_regional_ano;
  }

  public void setCli_atend_regional_ano(java.lang.Integer PARAM) {
    this.cli_atend_regional_ano = PARAM;
  }

  public java.lang.Integer getCli_atend_regional_ant() {
    return cli_atend_regional_ant;
  }

  public void setCli_atend_regional_ant(java.lang.Integer PARAM) {
    this.cli_atend_regional_ant = PARAM;
  }

}

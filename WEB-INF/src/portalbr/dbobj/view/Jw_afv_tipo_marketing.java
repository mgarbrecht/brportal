package portalbr.dbobj.view;

/** DataBase Object from table .Jw_afv_tipo_marketing
  * @version 03/04/2013 09:51:36
  */
public class Jw_afv_tipo_marketing implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codtipomarketing;
  private java.lang.String descricao;
  private java.lang.String ctrloperacao;
  private java.sql.Timestamp ctrldataoperacao;
  private double id;
  private double idexterno;

  public Jw_afv_tipo_marketing() {
  }

  public java.lang.Integer getCodtipomarketing() {
    return codtipomarketing;
  }

  public void setCodtipomarketing(java.lang.Integer PARAM) {
    this.codtipomarketing = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.String getCtrloperacao() {
    return ctrloperacao;
  }

  public void setCtrloperacao(java.lang.String PARAM) {
    this.ctrloperacao = PARAM;
  }

  public java.sql.Timestamp getCtrldataoperacao() {
    return ctrldataoperacao;
  }

  public void setCtrldataoperacao(java.sql.Timestamp PARAM) {
    this.ctrldataoperacao = PARAM;
  }

  public double getId() {
    return id;
  }

  public void setId(double PARAM) {
    this.id = PARAM;
  }

  public double getIdexterno() {
    return idexterno;
  }

  public void setIdexterno(double PARAM) {
    this.idexterno = PARAM;
  }

}

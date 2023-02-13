package portalbr.dbobj.table;

/** DataBase Object from table EST.Dom_local_estoque
  * @version 21/08/2013 11:16:38
  */
public class Dom_local_estoque implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int codigo;
  private java.lang.String descricao;
  private java.lang.Integer cli_cdgo;
  private java.lang.Integer les_codigo;
  private java.lang.String emp_empresa;
  private java.lang.String fil_filial;
  private java.lang.Integer for_codigo;
  private java.lang.Integer les_codigo2;

  public Dom_local_estoque() {
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.Integer getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.Integer PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.Integer getLes_codigo() {
    return les_codigo;
  }

  public void setLes_codigo(java.lang.Integer PARAM) {
    this.les_codigo = PARAM;
  }

  public java.lang.String getEmp_empresa() {
    return emp_empresa;
  }

  public void setEmp_empresa(java.lang.String PARAM) {
    this.emp_empresa = PARAM;
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.lang.Integer getFor_codigo() {
    return for_codigo;
  }

  public void setFor_codigo(java.lang.Integer PARAM) {
    this.for_codigo = PARAM;
  }

  public java.lang.Integer getLes_codigo2() {
    return les_codigo2;
  }

  public void setLes_codigo2(java.lang.Integer PARAM) {
    this.les_codigo2 = PARAM;
  }

}

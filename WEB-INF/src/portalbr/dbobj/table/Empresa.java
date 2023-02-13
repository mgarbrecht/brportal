package portalbr.dbobj.table;

/** DataBase Object from table TCONTAB.Empresa
  * @version 03/04/2013 09:59:05
  */
public class Empresa implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.String emp_empresa;
  private java.lang.String est_unifed;
  private java.lang.String emp_razsoc;
  private java.lang.String emp_fantas;
  private java.lang.String emp_endereco;
  private java.lang.String emp_bairro;
  private java.lang.String emp_cidade;
  private java.lang.String emp_cep;
  private double emp_cgc;
  private java.lang.String emp_insest;

  public Empresa() {
  }

  public java.lang.String getEmp_empresa() {
    return emp_empresa;
  }

  public void setEmp_empresa(java.lang.String PARAM) {
    this.emp_empresa = PARAM;
  }

  public java.lang.String getEst_unifed() {
    return est_unifed;
  }

  public void setEst_unifed(java.lang.String PARAM) {
    this.est_unifed = PARAM;
  }

  public java.lang.String getEmp_razsoc() {
    return emp_razsoc;
  }

  public void setEmp_razsoc(java.lang.String PARAM) {
    this.emp_razsoc = PARAM;
  }

  public java.lang.String getEmp_fantas() {
    return emp_fantas;
  }

  public void setEmp_fantas(java.lang.String PARAM) {
    this.emp_fantas = PARAM;
  }

  public java.lang.String getEmp_endereco() {
    return emp_endereco;
  }

  public void setEmp_endereco(java.lang.String PARAM) {
    this.emp_endereco = PARAM;
  }

  public java.lang.String getEmp_bairro() {
    return emp_bairro;
  }

  public void setEmp_bairro(java.lang.String PARAM) {
    this.emp_bairro = PARAM;
  }

  public java.lang.String getEmp_cidade() {
    return emp_cidade;
  }

  public void setEmp_cidade(java.lang.String PARAM) {
    this.emp_cidade = PARAM;
  }

  public java.lang.String getEmp_cep() {
    return emp_cep;
  }

  public void setEmp_cep(java.lang.String PARAM) {
    this.emp_cep = PARAM;
  }

  public double getEmp_cgc() {
    return emp_cgc;
  }

  public void setEmp_cgc(double PARAM) {
    this.emp_cgc = PARAM;
  }

  public java.lang.String getEmp_insest() {
    return emp_insest;
  }

  public void setEmp_insest(java.lang.String PARAM) {
    this.emp_insest = PARAM;
  }

}

package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ref_comb_especial_grade
  * @version 06/02/2012 14:42:35
  */
public class Ref_comb_especial_grade implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer id_solicitacao;
  private java.lang.String numeracao;
  private java.lang.Integer qtp_pars;

  public Ref_comb_especial_grade() {
  }

  public java.lang.Integer getId_solicitacao() {
    return id_solicitacao;
  }

  public void setId_solicitacao(java.lang.Integer PARAM) {
    this.id_solicitacao = PARAM;
  }

  public java.lang.String getNumeracao() {
    return numeracao;
  }

  public void setNumeracao(java.lang.String PARAM) {
    this.numeracao = PARAM;
  }

  public java.lang.Integer getQtp_pars() {
    return qtp_pars;
  }

  public void setQtp_pars(java.lang.Integer PARAM) {
    this.qtp_pars = PARAM;
  }

}

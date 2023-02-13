package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ultimo_acesso_analista
  * @version 05/07/2010 07:05:33
  */
public class Jw_ultimo_acesso_analista implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String divisao_gerente;
  private java.lang.String rep_cdgo;
  private java.lang.String rep_rzao;
  private java.sql.Timestamp data_ultimo_acesso;
  private java.lang.String rep_situ;

  public Jw_ultimo_acesso_analista() {
  }

  public java.lang.String getDivisao_gerente() {
    return divisao_gerente;
  }

  public void setDivisao_gerente(java.lang.String PARAM) {
    this.divisao_gerente = PARAM;
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

  public java.sql.Timestamp getData_ultimo_acesso() {
    return data_ultimo_acesso;
  }

  public void setData_ultimo_acesso(java.sql.Timestamp PARAM) {
    this.data_ultimo_acesso = PARAM;
  }

  public java.lang.String getRep_situ() {
    return rep_situ;
  }

  public void setRep_situ(java.lang.String PARAM) {
    this.rep_situ = PARAM;
  }

}

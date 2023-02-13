package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ultimo_acesso_rep
  * @version 05/07/2010 07:05:20
  */
public class Jw_ultimo_acesso_rep implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo_regional;
  private java.lang.String nome_regional;
  private java.lang.String codigo;
  private java.lang.String nome;
  private java.sql.Timestamp usua_dt_ultimo_acesso;
  private java.lang.String rep_situ;

  public Jw_ultimo_acesso_rep() {
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

  public java.lang.String getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.String PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getNome() {
    return nome;
  }

  public void setNome(java.lang.String PARAM) {
    this.nome = PARAM;
  }

  public java.sql.Timestamp getUsua_dt_ultimo_acesso() {
    return usua_dt_ultimo_acesso;
  }

  public void setUsua_dt_ultimo_acesso(java.sql.Timestamp PARAM) {
    this.usua_dt_ultimo_acesso = PARAM;
  }

  public java.lang.String getRep_situ() {
    return rep_situ;
  }

  public void setRep_situ(java.lang.String PARAM) {
    this.rep_situ = PARAM;
  }

}

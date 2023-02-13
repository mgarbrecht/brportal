package portalbr.dbobj.view;

/** DataBase Object from table .Jw_controle_clientes_especiais_log
  * @version 04/05/2016 12:46:43
  */
public class Jw_controle_clientes_especiais_log implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.sql.Timestamp data_log;
  private java.lang.String usuario;
  private java.lang.String acao;
  private java.lang.String nome_coluna;
  private java.lang.String old_value;
  private java.lang.String new_value;

  public Jw_controle_clientes_especiais_log() {
  }

  public java.sql.Timestamp getData_log() {
    return data_log;
  }

  public void setData_log(java.sql.Timestamp PARAM) {
    this.data_log = PARAM;
  }

  public java.lang.String getUsuario() {
    return usuario;
  }

  public void setUsuario(java.lang.String PARAM) {
    this.usuario = PARAM;
  }

  public java.lang.String getAcao() {
    return acao;
  }

  public void setAcao(java.lang.String PARAM) {
    this.acao = PARAM;
  }

  public java.lang.String getNome_coluna() {
    return nome_coluna;
  }

  public void setNome_coluna(java.lang.String PARAM) {
    this.nome_coluna = PARAM;
  }

  public java.lang.String getOld_value() {
    return old_value;
  }

  public void setOld_value(java.lang.String PARAM) {
    this.old_value = PARAM;
  }

  public java.lang.String getNew_value() {
    return new_value;
  }

  public void setNew_value(java.lang.String PARAM) {
    this.new_value = PARAM;
  }

}

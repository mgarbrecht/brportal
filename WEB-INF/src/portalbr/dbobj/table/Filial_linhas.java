package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Filial_linhas
  * @version 05/08/2014 09:56:05
  */
public class Filial_linhas implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.String cod_empresa;
  private java.lang.String cod_filial;
  private int lin_codigo;
  private int ref_codigo;
  private int indicador;
  private int capacidade;
  private java.lang.String ativa;
  private java.lang.String cod_filial_gerencial;
  private java.lang.String ativa_gerencial;
  private java.sql.Timestamp data_cadastro;
  private java.lang.String usuario;
  private java.lang.String suprimentos;

  public Filial_linhas() {
  }

  public java.lang.String getCod_empresa() {
    return cod_empresa;
  }

  public void setCod_empresa(java.lang.String PARAM) {
    this.cod_empresa = PARAM;
  }

  public java.lang.String getCod_filial() {
    return cod_filial;
  }

  public void setCod_filial(java.lang.String PARAM) {
    this.cod_filial = PARAM;
  }

  public int getLin_codigo() {
    return lin_codigo;
  }

  public void setLin_codigo(int PARAM) {
    this.lin_codigo = PARAM;
  }

  public int getRef_codigo() {
    return ref_codigo;
  }

  public void setRef_codigo(int PARAM) {
    this.ref_codigo = PARAM;
  }

  public int getIndicador() {
    return indicador;
  }

  public void setIndicador(int PARAM) {
    this.indicador = PARAM;
  }

  public int getCapacidade() {
    return capacidade;
  }

  public void setCapacidade(int PARAM) {
    this.capacidade = PARAM;
  }

  public java.lang.String getAtiva() {
    return ativa;
  }

  public void setAtiva(java.lang.String PARAM) {
    this.ativa = PARAM;
  }

  public java.lang.String getCod_filial_gerencial() {
    return cod_filial_gerencial;
  }

  public void setCod_filial_gerencial(java.lang.String PARAM) {
    this.cod_filial_gerencial = PARAM;
  }

  public java.lang.String getAtiva_gerencial() {
    return ativa_gerencial;
  }

  public void setAtiva_gerencial(java.lang.String PARAM) {
    this.ativa_gerencial = PARAM;
  }

  public java.sql.Timestamp getData_cadastro() {
    return data_cadastro;
  }

  public void setData_cadastro(java.sql.Timestamp PARAM) {
    this.data_cadastro = PARAM;
  }

  public java.lang.String getUsuario() {
    return usuario;
  }

  public void setUsuario(java.lang.String PARAM) {
    this.usuario = PARAM;
  }

  public java.lang.String getSuprimentos() {
    return suprimentos;
  }

  public void setSuprimentos(java.lang.String PARAM) {
    this.suprimentos = PARAM;
  }

}

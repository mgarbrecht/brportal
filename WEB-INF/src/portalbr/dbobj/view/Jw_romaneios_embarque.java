package portalbr.dbobj.view;

/** DataBase Object from table .Jw_romaneios_embarque
  * @version 30/07/2021 10:55:49
  */
public class Jw_romaneios_embarque implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String emp_empresa;
  private java.lang.String fil_filial;
  private java.lang.String numero;
  private java.sql.Date data_emissao;
  private java.sql.Timestamp data_finalizacao;
  private java.lang.String tra_cdgo;
  private java.lang.String tra_nome;
  private java.lang.String filial;
  private java.lang.String situacao;
  private java.sql.Timestamp data_envio;
  private java.lang.String usuario_inclusao;
  private java.lang.String qtde_notas;

  public Jw_romaneios_embarque() {
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

  public java.lang.String getNumero() {
    return numero;
  }

  public void setNumero(java.lang.String PARAM) {
    this.numero = PARAM;
  }

  public java.sql.Date getData_emissao() {
    return data_emissao;
  }

  public void setData_emissao(java.sql.Date PARAM) {
    this.data_emissao = PARAM;
  }

  public java.sql.Timestamp getData_finalizacao() {
    return data_finalizacao;
  }

  public void setData_finalizacao(java.sql.Timestamp PARAM) {
    this.data_finalizacao = PARAM;
  }

  public java.lang.String getTra_cdgo() {
    return tra_cdgo;
  }

  public void setTra_cdgo(java.lang.String PARAM) {
    this.tra_cdgo = PARAM;
  }

  public java.lang.String getTra_nome() {
    return tra_nome;
  }

  public void setTra_nome(java.lang.String PARAM) {
    this.tra_nome = PARAM;
  }

  public java.lang.String getFilial() {
    return filial;
  }

  public void setFilial(java.lang.String PARAM) {
    this.filial = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

  public java.sql.Timestamp getData_envio() {
    return data_envio;
  }

  public void setData_envio(java.sql.Timestamp PARAM) {
    this.data_envio = PARAM;
  }

  public java.lang.String getUsuario_inclusao() {
    return usuario_inclusao;
  }

  public void setUsuario_inclusao(java.lang.String PARAM) {
    this.usuario_inclusao = PARAM;
  }

  public java.lang.String getQtde_notas() {
    return qtde_notas;
  }

  public void setQtde_notas(java.lang.String PARAM) {
    this.qtde_notas = PARAM;
  }

}

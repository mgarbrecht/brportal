package portalbr.dbobj.view;

/** DataBase Object from table .Jw_coletas_solicitacoes
  * @version 27/03/2019 10:09:40
  */
public class Jw_coletas_solicitacoes implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer id_solicitacao_coleta;
  private java.sql.Timestamp data_solicitacao;
  private java.lang.String solicitante;
  private java.sql.Timestamp data_atendi_solicitacao;
  private java.lang.String emp_empresa;
  private java.lang.String emp_razsoc;
  private java.lang.String fil_filial;
  private java.lang.String fil_filial_descricao;
  private java.lang.String fil_filial_destino;
  private java.lang.String fil_filial_destino_descricao;
  private java.lang.Integer tra_cdgo;
  private java.lang.String tra_nome;
  private double quantidade_volumes;
  private double quantidade_cubica;
  private java.lang.String especie;
  private java.lang.String tipo_caminhao;
  private java.lang.String observacoes;
  private java.lang.String usuario_inclusao;
  private java.sql.Timestamp dthr_inclusao;
  private java.lang.String usuario_alteracao;
  private java.sql.Timestamp dthr_alteracao;
  private java.lang.String tipo_solicitacao;
  private java.lang.String descricao_tipo_solicitacao;
  private java.lang.String status;
  private java.lang.String status_descricao;
  private java.lang.String email_enviado;
  private java.lang.String email_enviado_descricao;

  public Jw_coletas_solicitacoes() {
  }

  public java.lang.Integer getId_solicitacao_coleta() {
    return id_solicitacao_coleta;
  }

  public void setId_solicitacao_coleta(java.lang.Integer PARAM) {
    this.id_solicitacao_coleta = PARAM;
  }

  public java.sql.Timestamp getData_solicitacao() {
    return data_solicitacao;
  }

  public void setData_solicitacao(java.sql.Timestamp PARAM) {
    this.data_solicitacao = PARAM;
  }

  public java.lang.String getSolicitante() {
    return solicitante;
  }

  public void setSolicitante(java.lang.String PARAM) {
    this.solicitante = PARAM;
  }

  public java.sql.Timestamp getData_atendi_solicitacao() {
    return data_atendi_solicitacao;
  }

  public void setData_atendi_solicitacao(java.sql.Timestamp PARAM) {
    this.data_atendi_solicitacao = PARAM;
  }

  public java.lang.String getEmp_empresa() {
    return emp_empresa;
  }

  public void setEmp_empresa(java.lang.String PARAM) {
    this.emp_empresa = PARAM;
  }

  public java.lang.String getEmp_razsoc() {
    return emp_razsoc;
  }

  public void setEmp_razsoc(java.lang.String PARAM) {
    this.emp_razsoc = PARAM;
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.lang.String getFil_filial_descricao() {
    return fil_filial_descricao;
  }

  public void setFil_filial_descricao(java.lang.String PARAM) {
    this.fil_filial_descricao = PARAM;
  }

  public java.lang.String getFil_filial_destino() {
    return fil_filial_destino;
  }

  public void setFil_filial_destino(java.lang.String PARAM) {
    this.fil_filial_destino = PARAM;
  }

  public java.lang.String getFil_filial_destino_descricao() {
    return fil_filial_destino_descricao;
  }

  public void setFil_filial_destino_descricao(java.lang.String PARAM) {
    this.fil_filial_destino_descricao = PARAM;
  }

  public java.lang.Integer getTra_cdgo() {
    return tra_cdgo;
  }

  public void setTra_cdgo(java.lang.Integer PARAM) {
    this.tra_cdgo = PARAM;
  }

  public java.lang.String getTra_nome() {
    return tra_nome;
  }

  public void setTra_nome(java.lang.String PARAM) {
    this.tra_nome = PARAM;
  }

  public double getQuantidade_volumes() {
    return quantidade_volumes;
  }

  public void setQuantidade_volumes(double PARAM) {
    this.quantidade_volumes = PARAM;
  }

  public double getQuantidade_cubica() {
    return quantidade_cubica;
  }

  public void setQuantidade_cubica(double PARAM) {
    this.quantidade_cubica = PARAM;
  }

  public java.lang.String getEspecie() {
    return especie;
  }

  public void setEspecie(java.lang.String PARAM) {
    this.especie = PARAM;
  }

  public java.lang.String getTipo_caminhao() {
    return tipo_caminhao;
  }

  public void setTipo_caminhao(java.lang.String PARAM) {
    this.tipo_caminhao = PARAM;
  }

  public java.lang.String getObservacoes() {
    return observacoes;
  }

  public void setObservacoes(java.lang.String PARAM) {
    this.observacoes = PARAM;
  }

  public java.lang.String getUsuario_inclusao() {
    return usuario_inclusao;
  }

  public void setUsuario_inclusao(java.lang.String PARAM) {
    this.usuario_inclusao = PARAM;
  }

  public java.sql.Timestamp getDthr_inclusao() {
    return dthr_inclusao;
  }

  public void setDthr_inclusao(java.sql.Timestamp PARAM) {
    this.dthr_inclusao = PARAM;
  }

  public java.lang.String getUsuario_alteracao() {
    return usuario_alteracao;
  }

  public void setUsuario_alteracao(java.lang.String PARAM) {
    this.usuario_alteracao = PARAM;
  }

  public java.sql.Timestamp getDthr_alteracao() {
    return dthr_alteracao;
  }

  public void setDthr_alteracao(java.sql.Timestamp PARAM) {
    this.dthr_alteracao = PARAM;
  }

  public java.lang.String getTipo_solicitacao() {
    return tipo_solicitacao;
  }

  public void setTipo_solicitacao(java.lang.String PARAM) {
    this.tipo_solicitacao = PARAM;
  }

  public java.lang.String getDescricao_tipo_solicitacao() {
    return descricao_tipo_solicitacao;
  }

  public void setDescricao_tipo_solicitacao(java.lang.String PARAM) {
    this.descricao_tipo_solicitacao = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

  public java.lang.String getStatus_descricao() {
    return status_descricao;
  }

  public void setStatus_descricao(java.lang.String PARAM) {
    this.status_descricao = PARAM;
  }

  public java.lang.String getEmail_enviado() {
    return email_enviado;
  }

  public void setEmail_enviado(java.lang.String PARAM) {
    this.email_enviado = PARAM;
  }

  public java.lang.String getEmail_enviado_descricao() {
    return email_enviado_descricao;
  }

  public void setEmail_enviado_descricao(java.lang.String PARAM) {
    this.email_enviado_descricao = PARAM;
  }

}

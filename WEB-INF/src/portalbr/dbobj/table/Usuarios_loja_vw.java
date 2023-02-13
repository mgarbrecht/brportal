package portalbr.dbobj.table;

/** DataBase Object from table LOJA.Usuarios_loja_vw
  * @version 03/04/2013 09:05:33
  */
public class Usuarios_loja_vw implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int id;
  private java.lang.String empresa;
  private java.lang.String cracha;
  private java.lang.String nome;
  private java.sql.Date data_inicio_compra;
  private java.sql.Date data_fim_compra;
  private java.lang.String tipo_acesso;
  private double limite_credito;
  private int limite_pares;
  private java.lang.String senha;
  private java.lang.String email;
  private java.lang.String telefone;
  private java.lang.String telefonecelular;
  private java.lang.String telefonerecados;
  private java.lang.String acesso;
  private java.lang.String apelido;
  private java.lang.String msg_pessoal;
  private java.lang.String img_pessoal;

  public Usuarios_loja_vw() {
  }

  public int getId() {
    return id;
  }

  public void setId(int PARAM) {
    this.id = PARAM;
  }

  public java.lang.String getEmpresa() {
    return empresa;
  }

  public void setEmpresa(java.lang.String PARAM) {
    this.empresa = PARAM;
  }

  public java.lang.String getCracha() {
    return cracha;
  }

  public void setCracha(java.lang.String PARAM) {
    this.cracha = PARAM;
  }

  public java.lang.String getNome() {
    return nome;
  }

  public void setNome(java.lang.String PARAM) {
    this.nome = PARAM;
  }

  public java.sql.Date getData_inicio_compra() {
    return data_inicio_compra;
  }

  public void setData_inicio_compra(java.sql.Date PARAM) {
    this.data_inicio_compra = PARAM;
  }

  public java.sql.Date getData_fim_compra() {
    return data_fim_compra;
  }

  public void setData_fim_compra(java.sql.Date PARAM) {
    this.data_fim_compra = PARAM;
  }

  public java.lang.String getTipo_acesso() {
    return tipo_acesso;
  }

  public void setTipo_acesso(java.lang.String PARAM) {
    this.tipo_acesso = PARAM;
  }

  public double getLimite_credito() {
    return limite_credito;
  }

  public void setLimite_credito(double PARAM) {
    this.limite_credito = PARAM;
  }

  public int getLimite_pares() {
    return limite_pares;
  }

  public void setLimite_pares(int PARAM) {
    this.limite_pares = PARAM;
  }

  public java.lang.String getSenha() {
    return senha;
  }

  public void setSenha(java.lang.String PARAM) {
    this.senha = PARAM;
  }

  public java.lang.String getEmail() {
    return email;
  }

  public void setEmail(java.lang.String PARAM) {
    this.email = PARAM;
  }

  public java.lang.String getTelefone() {
    return telefone;
  }

  public void setTelefone(java.lang.String PARAM) {
    this.telefone = PARAM;
  }

  public java.lang.String getTelefonecelular() {
    return telefonecelular;
  }

  public void setTelefonecelular(java.lang.String PARAM) {
    this.telefonecelular = PARAM;
  }

  public java.lang.String getTelefonerecados() {
    return telefonerecados;
  }

  public void setTelefonerecados(java.lang.String PARAM) {
    this.telefonerecados = PARAM;
  }

  public java.lang.String getAcesso() {
    return acesso;
  }

  public void setAcesso(java.lang.String PARAM) {
    this.acesso = PARAM;
  }

  public java.lang.String getApelido() {
    return apelido;
  }

  public void setApelido(java.lang.String PARAM) {
    this.apelido = PARAM;
  }

  public java.lang.String getMsg_pessoal() {
    return msg_pessoal;
  }

  public void setMsg_pessoal(java.lang.String PARAM) {
    this.msg_pessoal = PARAM;
  }

  public java.lang.String getImg_pessoal() {
    return img_pessoal;
  }

  public void setImg_pessoal(java.lang.String PARAM) {
    this.img_pessoal = PARAM;
  }

}

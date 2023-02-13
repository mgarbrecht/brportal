package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acao_marketing_usuarios
  * @version 03/04/2013 09:53:12
  */
public class Jw_acao_marketing_usuarios implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String cracha;
  private java.lang.String nome;
  private java.lang.String email;
  private java.lang.String situacao;
  private int marca;
  private java.lang.String tipo;
  private java.lang.String dono_marca;
  private java.lang.String coordenador;

  public Jw_acao_marketing_usuarios() {
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

  public java.lang.String getEmail() {
    return email;
  }

  public void setEmail(java.lang.String PARAM) {
    this.email = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

  public int getMarca() {
    return marca;
  }

  public void setMarca(int PARAM) {
    this.marca = PARAM;
  }

  public java.lang.String getTipo() {
    return tipo;
  }

  public void setTipo(java.lang.String PARAM) {
    this.tipo = PARAM;
  }

  public java.lang.String getDono_marca() {
    return dono_marca;
  }

  public void setDono_marca(java.lang.String PARAM) {
    this.dono_marca = PARAM;
  }

  public java.lang.String getCoordenador() {
    return coordenador;
  }

  public void setCoordenador(java.lang.String PARAM) {
    this.coordenador = PARAM;
  }

}

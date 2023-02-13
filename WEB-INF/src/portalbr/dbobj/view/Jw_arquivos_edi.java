package portalbr.dbobj.view;

/** DataBase Object from table .Jw_arquivos_edi
  * @version 11/02/2019 10:17:54
  */
public class Jw_arquivos_edi implements java.io.Serializable, com.egen.util.jdbc.View {
  private int codigo;
  private java.lang.String nome;
  private java.lang.String caminho;
  private java.lang.String caminho_link;

  public Jw_arquivos_edi() {
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getNome() {
    return nome;
  }

  public void setNome(java.lang.String PARAM) {
    this.nome = PARAM;
  }

  public java.lang.String getCaminho() {
    return caminho;
  }

  public void setCaminho(java.lang.String PARAM) {
    this.caminho = PARAM;
  }

  public java.lang.String getCaminho_link() {
    return caminho_link;
  }

  public void setCaminho_link(java.lang.String PARAM) {
    this.caminho_link = PARAM;
  }

}

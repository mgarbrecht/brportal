package portalbr.dbobj.view;

/** DataBase Object from table .Jw_fotos_linhas_cliente
  * @version 03/04/2013 09:28:07
  */
public class Jw_fotos_linhas_cliente implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String lin_cdgo;
  private java.lang.String lin_nome;
  private java.lang.String nome;

  public Jw_fotos_linhas_cliente() {
  }

  public java.lang.String getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.String PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.String getLin_nome() {
    return lin_nome;
  }

  public void setLin_nome(java.lang.String PARAM) {
    this.lin_nome = PARAM;
  }

  public java.lang.String getNome() {
    return nome;
  }

  public void setNome(java.lang.String PARAM) {
    this.nome = PARAM;
  }

}

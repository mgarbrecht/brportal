package portalbr.dbobj.view;

/** DataBase Object from table .Jw_localestoque
  * @version 03/04/2013 09:25:05
  */
public class Jw_localestoque implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String fil_filial;
  private int codigo;
  private java.lang.String descricao;

  public Jw_localestoque() {
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

}

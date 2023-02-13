package portalbr.dbobj.view;

/** DataBase Object from table .Jw_titulos_cld_usuarios
  * @version 05/07/2010 07:07:38
  */
public class Jw_titulos_cld_usuarios implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String codigo_reg;
  private java.lang.String nome_reg;
  private java.lang.String codigo_ger;
  private java.lang.String nome_ger;

  public Jw_titulos_cld_usuarios() {
  }

  public java.lang.String getCodigo_reg() {
    return codigo_reg;
  }

  public void setCodigo_reg(java.lang.String PARAM) {
    this.codigo_reg = PARAM;
  }

  public java.lang.String getNome_reg() {
    return nome_reg;
  }

  public void setNome_reg(java.lang.String PARAM) {
    this.nome_reg = PARAM;
  }

  public java.lang.String getCodigo_ger() {
    return codigo_ger;
  }

  public void setCodigo_ger(java.lang.String PARAM) {
    this.codigo_ger = PARAM;
  }

  public java.lang.String getNome_ger() {
    return nome_ger;
  }

  public void setNome_ger(java.lang.String PARAM) {
    this.nome_ger = PARAM;
  }

}

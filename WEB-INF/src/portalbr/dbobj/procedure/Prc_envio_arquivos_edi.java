package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_envio_arquivos_edi
  * @version 01/06/2011 15:55:26
  */
public class Prc_envio_arquivos_edi implements java.io.Serializable, com.egen.util.jdbc.Procedure {
  private java.lang.String p_tipo;
  private java.lang.String p_filial;
  private java.sql.Date p_data;
  private java.lang.String p_erro;

  public Prc_envio_arquivos_edi() {
  }

  public java.lang.String getP_tipo() {
    return p_tipo;
  }

  public void setP_tipo(java.lang.String PARAM) {
    this.p_tipo = PARAM;
  }

  public java.lang.String getP_filial() {
    return p_filial;
  }

  public void setP_filial(java.lang.String PARAM) {
    this.p_filial = PARAM;
  }

  public java.sql.Date getP_data() {
    return p_data;
  }

  public void setP_data(java.sql.Date PARAM) {
    this.p_data = PARAM;
  }

  public java.lang.String getP_erro() {
    return p_erro;
  }

  public void setP_erro(java.lang.String PARAM) {
    this.p_erro = PARAM;
  }

}

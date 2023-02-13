package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ac_cliente
  * @version 16/05/2014 08:32:06
  */
public class Jw_ac_cliente implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String cod;
  private java.lang.String seq;
  private java.lang.String enome;
  private java.lang.String cnpj;
  private java.lang.String desc_bloqueio;
  private java.lang.String contador;

  public Jw_ac_cliente() {
  }

  public java.lang.String getCod() {
    return cod;
  }

  public void setCod(java.lang.String PARAM) {
    this.cod = PARAM;
  }

  public java.lang.String getSeq() {
    return seq;
  }

  public void setSeq(java.lang.String PARAM) {
    this.seq = PARAM;
  }

  public java.lang.String getEnome() {
    return enome;
  }

  public void setEnome(java.lang.String PARAM) {
    this.enome = PARAM;
  }

  public java.lang.String getCnpj() {
    return cnpj;
  }

  public void setCnpj(java.lang.String PARAM) {
    this.cnpj = PARAM;
  }

  public java.lang.String getDesc_bloqueio() {
    return desc_bloqueio;
  }

  public void setDesc_bloqueio(java.lang.String PARAM) {
    this.desc_bloqueio = PARAM;
  }

  public java.lang.String getContador() {
    return contador;
  }

  public void setContador(java.lang.String PARAM) {
    this.contador = PARAM;
  }

}

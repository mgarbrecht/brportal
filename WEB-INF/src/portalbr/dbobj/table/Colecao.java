package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Colecao
  * @version 03/04/2013 10:01:52
  */
public class Colecao implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int codigo;
  private java.lang.String descricao;
  private int mes_lcto;
  private java.lang.String descr_lcto;
  private int mes_inicio;
  private int mes_final;

  public Colecao() {
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

  public int getMes_lcto() {
    return mes_lcto;
  }

  public void setMes_lcto(int PARAM) {
    this.mes_lcto = PARAM;
  }

  public java.lang.String getDescr_lcto() {
    return descr_lcto;
  }

  public void setDescr_lcto(java.lang.String PARAM) {
    this.descr_lcto = PARAM;
  }

  public int getMes_inicio() {
    return mes_inicio;
  }

  public void setMes_inicio(int PARAM) {
    this.mes_inicio = PARAM;
  }

  public int getMes_final() {
    return mes_final;
  }

  public void setMes_final(int PARAM) {
    this.mes_final = PARAM;
  }

}

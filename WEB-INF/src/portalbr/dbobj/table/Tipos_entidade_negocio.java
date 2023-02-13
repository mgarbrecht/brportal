package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Tipos_entidade_negocio
  * @version 03/04/2013 09:06:54
  */
public class Tipos_entidade_negocio implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer tien_id;
  private java.lang.String tien_tipo;
  private java.lang.String tien_tabela;
  private java.lang.String tien_campos_descr;
  private java.lang.String tien_campos_chave;
  private java.lang.String tien_condicional;
  private int tien_dias_consulta_retroativa;

  public Tipos_entidade_negocio() {
  }

  public java.lang.Integer getTien_id() {
    return tien_id;
  }

  public void setTien_id(java.lang.Integer PARAM) {
    this.tien_id = PARAM;
  }

  public java.lang.String getTien_tipo() {
    return tien_tipo;
  }

  public void setTien_tipo(java.lang.String PARAM) {
    this.tien_tipo = PARAM;
  }

  public java.lang.String getTien_tabela() {
    return tien_tabela;
  }

  public void setTien_tabela(java.lang.String PARAM) {
    this.tien_tabela = PARAM;
  }

  public java.lang.String getTien_campos_descr() {
    return tien_campos_descr;
  }

  public void setTien_campos_descr(java.lang.String PARAM) {
    this.tien_campos_descr = PARAM;
  }

  public java.lang.String getTien_campos_chave() {
    return tien_campos_chave;
  }

  public void setTien_campos_chave(java.lang.String PARAM) {
    this.tien_campos_chave = PARAM;
  }

  public java.lang.String getTien_condicional() {
    return tien_condicional;
  }

  public void setTien_condicional(java.lang.String PARAM) {
    this.tien_condicional = PARAM;
  }

  public int getTien_dias_consulta_retroativa() {
    return tien_dias_consulta_retroativa;
  }

  public void setTien_dias_consulta_retroativa(int PARAM) {
    this.tien_dias_consulta_retroativa = PARAM;
  }

}

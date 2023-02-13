package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_atendidos_segmentos
  * @version 27/05/2014 16:03:33
  */
public class Jw_clientes_atendidos_segmentos implements java.io.Serializable, com.egen.util.jdbc.View {
  private int seg_cdgo;
  private java.lang.String seg_desc;
  private int pequenos;
  private int medios;
  private int grandes;
  private int todos;

  public Jw_clientes_atendidos_segmentos() {
  }

  public int getSeg_cdgo() {
    return seg_cdgo;
  }

  public void setSeg_cdgo(int PARAM) {
    this.seg_cdgo = PARAM;
  }

  public java.lang.String getSeg_desc() {
    return seg_desc;
  }

  public void setSeg_desc(java.lang.String PARAM) {
    this.seg_desc = PARAM;
  }

  public int getPequenos() {
    return pequenos;
  }

  public void setPequenos(int PARAM) {
    this.pequenos = PARAM;
  }

  public int getMedios() {
    return medios;
  }

  public void setMedios(int PARAM) {
    this.medios = PARAM;
  }

  public int getGrandes() {
    return grandes;
  }

  public void setGrandes(int PARAM) {
    this.grandes = PARAM;
  }

  public int getTodos() {
    return todos;
  }

  public void setTodos(int PARAM) {
    this.todos = PARAM;
  }

}

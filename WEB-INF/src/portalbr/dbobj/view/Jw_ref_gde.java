package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ref_gde
  * @version 03/04/2013 09:13:57
  */
public class Jw_ref_gde implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String grade;
  private java.lang.String no_inicial;
  private java.lang.String no_final;

  public Jw_ref_gde() {
  }

  public java.lang.String getGrade() {
    return grade;
  }

  public void setGrade(java.lang.String PARAM) {
    this.grade = PARAM;
  }

  public java.lang.String getNo_inicial() {
    return no_inicial;
  }

  public void setNo_inicial(java.lang.String PARAM) {
    this.no_inicial = PARAM;
  }

  public java.lang.String getNo_final() {
    return no_final;
  }

  public void setNo_final(java.lang.String PARAM) {
    this.no_final = PARAM;
  }

}

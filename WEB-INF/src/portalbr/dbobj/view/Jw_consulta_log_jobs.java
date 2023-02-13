package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_log_jobs
  * @version 26/01/2022 14:20:20
  */
public class Jw_consulta_log_jobs implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String data;
  private java.lang.String owner;
  private java.lang.String job;
  private java.lang.String status;
  private java.lang.String errors;

  public Jw_consulta_log_jobs() {
  }

  public java.lang.String getData() {
    return data;
  }

  public void setData(java.lang.String PARAM) {
    this.data = PARAM;
  }

  public java.lang.String getOwner() {
    return owner;
  }

  public void setOwner(java.lang.String PARAM) {
    this.owner = PARAM;
  }

  public java.lang.String getJob() {
    return job;
  }

  public void setJob(java.lang.String PARAM) {
    this.job = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

  public java.lang.String getErrors() {
    return errors;
  }

  public void setErrors(java.lang.String PARAM) {
    this.errors = PARAM;
  }

}

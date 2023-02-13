package portalbr.dbobj.procedure;

/** DataBase Object from table BRIO.Prc_send_email_job
  * @version 05/07/2010 07:00:39
  */
public class Prc_send_email_job implements java.io.Serializable, com.egen.util.jdbc.Procedure {
  private java.lang.String p_module_name;
  private java.lang.String p_from;
  private java.lang.String p_to;
  private java.lang.String p_subject;
  private java.lang.String p_message_body;
  private java.lang.String p_message_style;
  private java.lang.String p_error;
  private java.lang.String p_send_error_to;

  public Prc_send_email_job() {
  }

  public java.lang.String getP_module_name() {
    return p_module_name;
  }

  public void setP_module_name(java.lang.String PARAM) {
    this.p_module_name = PARAM;
  }

  public java.lang.String getP_from() {
    return p_from;
  }

  public void setP_from(java.lang.String PARAM) {
    this.p_from = PARAM;
  }

  public java.lang.String getP_to() {
    return p_to;
  }

  public void setP_to(java.lang.String PARAM) {
    this.p_to = PARAM;
  }

  public java.lang.String getP_subject() {
    return p_subject;
  }

  public void setP_subject(java.lang.String PARAM) {
    this.p_subject = PARAM;
  }

  public java.lang.String getP_message_body() {
    return p_message_body;
  }

  public void setP_message_body(java.lang.String PARAM) {
    this.p_message_body = PARAM;
  }

  public java.lang.String getP_message_style() {
    return p_message_style;
  }

  public void setP_message_style(java.lang.String PARAM) {
    this.p_message_style = PARAM;
  }

  public java.lang.String getP_error() {
    return p_error;
  }

  public void setP_error(java.lang.String PARAM) {
    this.p_error = PARAM;
  }

  public java.lang.String getP_send_error_to() {
    return p_send_error_to;
  }

  public void setP_send_error_to(java.lang.String PARAM) {
    this.p_send_error_to = PARAM;
  }

}

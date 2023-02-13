package portalbr.dbobj.view;

/** DataBase Object from table .Jw_processo_fab_sub_processo 
  * @version 17/08/2015 09:46:33
  */
public class Jw_processo_fab_sub_processo  implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer pro_numero;
  private java.lang.Integer pro_numero_sub_processo;
  private java.lang.String pro_nome;

  public Jw_processo_fab_sub_processo () {
  }

  public java.lang.Integer getPro_numero() {
    return pro_numero;
  }

  public void setPro_numero(java.lang.Integer PARAM) {
    this.pro_numero = PARAM;
  }

  public java.lang.Integer getPro_numero_sub_processo() {
    return pro_numero_sub_processo;
  }

  public void setPro_numero_sub_processo(java.lang.Integer PARAM) {
    this.pro_numero_sub_processo = PARAM;
  }

  public java.lang.String getPro_nome() {
    return pro_nome;
  }

  public void setPro_nome(java.lang.String PARAM) {
    this.pro_nome = PARAM;
  }

}

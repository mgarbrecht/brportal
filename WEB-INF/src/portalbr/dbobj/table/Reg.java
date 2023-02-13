package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Reg
  * @version 10/08/2017 14:35:52
  */
public class Reg implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.String reg_cdgo;
  private java.lang.String reg_nome;
  private java.lang.String reg_cdgo_macro;

  public Reg() {
  }

  public java.lang.String getReg_cdgo() {
    return reg_cdgo;
  }

  public void setReg_cdgo(java.lang.String PARAM) {
    this.reg_cdgo = PARAM;
  }

  public java.lang.String getReg_nome() {
    return reg_nome;
  }

  public void setReg_nome(java.lang.String PARAM) {
    this.reg_nome = PARAM;
  }

  public java.lang.String getReg_cdgo_macro() {
    return reg_cdgo_macro;
  }

  public void setReg_cdgo_macro(java.lang.String PARAM) {
    this.reg_cdgo_macro = PARAM;
  }

}

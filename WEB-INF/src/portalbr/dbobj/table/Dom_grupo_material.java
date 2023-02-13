package portalbr.dbobj.table;

/** DataBase Object from table EST.Dom_grupo_material
  * @version 09/08/2013 10:45:49
  */
public class Dom_grupo_material implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer gpo_mater_cdgo;
  private java.lang.String gpo_mater_desc;
  private java.lang.String senha;

  public Dom_grupo_material() {
  }

  public java.lang.Integer getGpo_mater_cdgo() {
    return gpo_mater_cdgo;
  }

  public void setGpo_mater_cdgo(java.lang.Integer PARAM) {
    this.gpo_mater_cdgo = PARAM;
  }

  public java.lang.String getGpo_mater_desc() {
    return gpo_mater_desc;
  }

  public void setGpo_mater_desc(java.lang.String PARAM) {
    this.gpo_mater_desc = PARAM;
  }

  public java.lang.String getSenha() {
    return senha;
  }

  public void setSenha(java.lang.String PARAM) {
    this.senha = PARAM;
  }

}

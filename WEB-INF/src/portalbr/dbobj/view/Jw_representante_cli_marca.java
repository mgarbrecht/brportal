package portalbr.dbobj.view;

/** DataBase Object from table .Jw_representante_cli_marca
  * @version 08/03/2023 13:18:15
  */
public class Jw_representante_cli_marca implements java.io.Serializable, com.egen.util.jdbc.View {
  private int cli_cdgo;
  private java.lang.String cli_rzao;
  private int codigo_marca;
  private java.lang.String rep_cdgo;
  private java.lang.String rep_rzao;
  private int ref_grupo_posicao_fab;

  public Jw_representante_cli_marca() {
  }

  public int getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(int PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.String getCli_rzao() {
    return cli_rzao;
  }

  public void setCli_rzao(java.lang.String PARAM) {
    this.cli_rzao = PARAM;
  }

  public int getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(int PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

  public java.lang.String getRep_rzao() {
    return rep_rzao;
  }

  public void setRep_rzao(java.lang.String PARAM) {
    this.rep_rzao = PARAM;
  }

  public int getRef_grupo_posicao_fab() {
    return ref_grupo_posicao_fab;
  }

  public void setRef_grupo_posicao_fab(int PARAM) {
    this.ref_grupo_posicao_fab = PARAM;
  }

}

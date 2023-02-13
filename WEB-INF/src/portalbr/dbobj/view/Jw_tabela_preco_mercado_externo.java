package portalbr.dbobj.view;

/** DataBase Object from table .Jw_tabela_preco_mercado_externo
  * @version 09/10/2015 10:07:01
  */
public class Jw_tabela_preco_mercado_externo implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo_livro;
  private java.sql.Timestamp versao_tabela;

  public Jw_tabela_preco_mercado_externo() {
  }

  public java.lang.Integer getCodigo_livro() {
    return codigo_livro;
  }

  public void setCodigo_livro(java.lang.Integer PARAM) {
    this.codigo_livro = PARAM;
  }

  public java.sql.Timestamp getVersao_tabela() {
    return versao_tabela;
  }

  public void setVersao_tabela(java.sql.Timestamp PARAM) {
    this.versao_tabela = PARAM;
  }

}

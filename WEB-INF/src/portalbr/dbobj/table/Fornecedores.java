package portalbr.dbobj.table;

/** DataBase Object from table CTB.Fornecedores
  * @version 03/04/2013 09:55:59
  */
public class Fornecedores implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int codigo;
  private java.lang.String nome;

  public Fornecedores() {
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getNome() {
    return nome;
  }

  public void setNome(java.lang.String PARAM) {
    this.nome = PARAM;
  }

}

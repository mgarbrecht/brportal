package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_contatos
  * @version 03/04/2013 09:46:14
  */
public class Jw_clientes_contatos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String pec_nome;
  private java.lang.String pec_cpf;

  public Jw_clientes_contatos() {
  }

  public java.lang.String getPec_nome() {
    return pec_nome;
  }

  public void setPec_nome(java.lang.String PARAM) {
    this.pec_nome = PARAM;
  }

  public java.lang.String getPec_cpf() {
    return pec_cpf;
  }

  public void setPec_cpf(java.lang.String PARAM) {
    this.pec_cpf = PARAM;
  }

}

package vendas;

public class Regional {

  protected int codigo;
  protected String nome;
  protected String email;
  
  public int getCodigo() {
    return codigo;
  }
  
  public String getNome() {
    return nome;
  }
  
  public String getEMail() {
    return email;
  }
  
  public void setNome(String nome) {
    this.nome = nome;
  }
  
  public void setEMail(String email) {
    this.email = email;
  }
  
}
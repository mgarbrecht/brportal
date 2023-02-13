package vendas;

public class Cliente {

  protected int codigo;
  protected String nome;
  protected String razao;
  protected String situacao;	

  public int getCodigo() {
    return this.codigo;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }

  public void setRazaoSocial(String razao) {
    this.razao = razao;
  }

  public String getRazaoSocial() {
    return this.razao;
  }

  public void Ativa() {
    this.situacao = "A";
  }

  public void Inativa() {
    this.situacao = "I";
  }

  public boolean isAtivo() {
    return (this.situacao.equals("A"));
  }

}
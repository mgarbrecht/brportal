package vendas;

public class Representante {

  protected String codigo;
  protected String razao;
  protected String situacao = "A";
  protected Regional regional;

  public String getCodigo() {
    return this.codigo;
  }
  
  public String getRazaoSocial() {
    return this.razao;
  }
	
  public boolean isAtivo() {
	  return (this.situacao.equals("A"));
  }
  
  public Regional getRegional() {
    return this.regional;
  }

  public void setRazaoSocial(String razao) {
    this.razao = razao;
  }
  
  public void Ativa() {
    this.situacao = "A";
  }
  
  public void Inativa() {
	  this.situacao = "N";
  }
  
  public void setRegional(Regional regional) {
    this.regional = regional;
  }	  

}
package acesso;

public class Menu {
  
	protected int id;
	protected String nome;
	protected String texto;
	protected Menu menuPai;
	  
	public int getId() {
		return this.id;
	}
  
	public String getNome() {
		return this.nome;
	}
  
	public String getTexto() {
		return this.texto;
	}
  
	public Menu getMenuPai() {
		return this.menuPai;
	}
  
	public void setNome(String nome) {
		this.nome = nome;
	}
  
	public void setTexto(String texto) {
		this.texto = texto;
	}	
  
	public void setMenuPai(Menu menuPai) {
		this.menuPai = menuPai;
	}
  
}
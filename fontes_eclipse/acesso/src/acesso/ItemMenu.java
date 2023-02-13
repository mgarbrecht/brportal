package acesso;

public class ItemMenu {
  
	protected int id;
	protected String nome;
	protected String texto;
	protected String comando;
	protected Menu menu;
	protected DocumentoInterface documentoInterface;
	  
	public int getId() {
		return this.id;
	}
  
	public Menu getMenu() {
		return this.menu;
	}
  
	public DocumentoInterface getDocumentoInterface() {
		return this.documentoInterface;
	}
  
	public String getNome() {
		return this.nome;
	}
  
	public String getTexto() {
		return this.texto;
	}
  
	public String getComando() {
		return this.comando;
	}
  
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
  
	public void setNome(String nome) {
		this.nome = nome;
	}
  
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setDocumentoInterface(DocumentoInterface documentoInterface) {
		this.documentoInterface = documentoInterface;
	}
  
	public void setComando(String comando) {
		this.comando = comando;
	}
  
}
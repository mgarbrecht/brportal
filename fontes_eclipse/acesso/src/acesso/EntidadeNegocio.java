package acesso;

public class EntidadeNegocio {

	protected int id = 0;
	protected String descricao;
	protected String chave;
	protected TipoEntidadeNegocio tien;
  
	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getChave() {
		return chave;
	}

	public TipoEntidadeNegocio getTipoEntidadeNegocio() {
		return tien;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
  
	public void setChave(String chave) {
		this.chave = chave;
	}

	public void setTipoEntidadeNegocio(TipoEntidadeNegocio tien) {
		this.tien = tien;
	}

}
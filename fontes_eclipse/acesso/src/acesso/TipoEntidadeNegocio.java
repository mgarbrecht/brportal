package acesso;

public class TipoEntidadeNegocio {

	protected int id = 0;
	protected String tipo;
	protected String tabela;
	protected String camposDescr;
	protected String camposChave;
	protected String condicao;	
	protected int diasConsultaRetroativa;


	public int getId() {
		return id;
	}
  
	public String getTipo() {
		return tipo;
	}
  
	public String getTabela() {
		return tabela;
	}

	public String getCamposDescricao() {
		return camposDescr;
	}

	public String getCamposChave() {
		return camposChave;
	}
  
	public String getCondicao() {
		return condicao;
	}
	
	public int getDiasConsultaRetroativa() {
		return diasConsultaRetroativa;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
  
	public void setTabela(String tabela) {
		this.tabela = tabela;
	}
  
	public void setCamposDescricao(String camposDescr) {
		this.camposDescr = camposDescr;
	}
  
	public void setCamposChave(String camposChave) {
		this.camposChave = camposChave;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}
	
	public void setDiasConsultaRetroativa(int diasConsultaRetroativa) {
		this.diasConsultaRetroativa = diasConsultaRetroativa;
	}	
	

}
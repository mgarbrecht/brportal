package acesso;

public class AcessoDocumentoInterface {

	protected int id;
	protected DocumentoInterface documentoInterface;
	protected Usuario usuario;
	protected Integer diasConsultaRetroativa;
	protected boolean favorito;

	public int getId() {
		return this.id;
	}

	public DocumentoInterface getDocumentoInterface() {
		return this.documentoInterface;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public boolean isFavorito() {
		return this.favorito;
	}

	public void setDocumentoInterface(DocumentoInterface documentoInterface) {
		this.documentoInterface = documentoInterface;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getDiasConsultaRetroativa() {
		return diasConsultaRetroativa;
	}

	public void setDiasConsultaRetroativa(Integer diasConsultaRetroativa) {
		this.diasConsultaRetroativa = diasConsultaRetroativa;
	}

}
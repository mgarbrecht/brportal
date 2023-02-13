package acesso;

public class AutorizacaoDocumentoInterface {

	protected int id;
	private ClassificadorAcesso tipo;
	private DocumentoInterface documento;
	private TipoEntidadeNegocio tipoEntidade;
	private EntidadeNegocio entidade;
	private Usuario usuario;
	private Integer diasConsultaRetroativa; 
	private boolean negarAcessoUsuario;
    
	public enum ClassificadorAcesso {
		TIPO_ENTIDADE_NEGOCIO,
		ENTIDADE_NEGOCIO,
		USUARIO
	}

	public int getId() {
		return this.id; 
	}
  
	public void setDocumentoInterface(DocumentoInterface documento) {
		this.documento = documento;
	}

	public DocumentoInterface getDocumentoInterface() {
		return this.documento;
	}

	public void setTipoEntidadeNegocio(TipoEntidadeNegocio tipoEntidade) {
		this.tipoEntidade = tipoEntidade;
		this.tipo = ClassificadorAcesso.TIPO_ENTIDADE_NEGOCIO;
		this.entidade = null;
		this.usuario = null;
	}

	public TipoEntidadeNegocio getTipoEntidadeNegocio() {
		return this.tipoEntidade;
	}

	public void setEntidadeNegocio(EntidadeNegocio entidade) {
		this.entidade = entidade;
		this.tipo = ClassificadorAcesso.ENTIDADE_NEGOCIO;
		this.tipoEntidade = null;
		this.usuario = null;
	}

	public EntidadeNegocio getEntidadeNegocio() {
		return this.entidade;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		this.tipo = ClassificadorAcesso.USUARIO;
		this.tipoEntidade = null;
		this.entidade = null;
	}
  
	public Usuario getUsuario() {
		return usuario;
	}
  
	public boolean isUsuarioAutorizado() {
		return ! this.negarAcessoUsuario;
	}
  
	public void autorizarUsuario() {
		this.negarAcessoUsuario = false;
	}
  
	public void revogarUsuario() {
		this.negarAcessoUsuario = true;
	}
  
	public ClassificadorAcesso getClassificadorAcesso() {
		return tipo;
	}
  
	public boolean isClassificadorAcesso(ClassificadorAcesso tipo) {
		return (this.tipo == tipo);
	}

	public Integer getDiasConsultaRetroativa() {
		return diasConsultaRetroativa;
	}

	public void setDiasConsultaRetroativa(Integer diasConsultaRetroativa) {
		this.diasConsultaRetroativa = diasConsultaRetroativa;
	}
  
}
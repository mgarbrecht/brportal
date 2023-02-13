package acesso;

import javax.servlet.http.*;

public class Sessao {

	private HttpSession se;
	private Usuario user;

	public Sessao(HttpSession session) {
		se = session;
		user = new Usuario();
		user = (Usuario) this.se.getAttribute("User");
	}

	public boolean isSuperUsuario() {
		return this.user.isSuperUsuario();
	}

	public String getTipoEntidadeNegocio() {
		String tipo = "";
		try {
			EntidadeNegocio ent = new EntidadeNegocio();
			TipoEntidadeNegocio tipoent = new TipoEntidadeNegocio();
			if (!(this.user.getEntidadeNegocio() == null)) {
				ent = (EntidadeNegocio) this.user.getEntidadeNegocio();
				tipoent = (TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
				tipo = tipoent.getTipo();
			} else {
				tipo = "";
			}
		} catch (Exception e) {
		}
		return tipo;
	}

	public Integer getTipoEntidadeNegocioId() {
		Integer retorno = null;
		try {
			EntidadeNegocio ent = new EntidadeNegocio();
			if (!(this.user.getEntidadeNegocio() == null)) {
				ent = (EntidadeNegocio) this.user.getEntidadeNegocio();
				retorno = ent.getTipoEntidadeNegocio().getId();
			} else {
				retorno = null;
			}
		} catch (Exception e) {
		}
		return retorno;
	}

	public String getEntidadeNegocio() {
		String retorno = "";
		try {
			EntidadeNegocio ent = new EntidadeNegocio();
			if (!(this.user.getEntidadeNegocio() == null)) {
				ent = (EntidadeNegocio) this.user.getEntidadeNegocio();
				retorno = ent.getDescricao();
			} else {
				retorno = "";
			}
		} catch (Exception e) {
		}
		return retorno;
	}

	public Integer getEntidadeNegocioId() {
		Integer retorno = null;
		try {
			EntidadeNegocio ent = new EntidadeNegocio();
			if (!(this.user.getEntidadeNegocio() == null)) {
				ent = (EntidadeNegocio) this.user.getEntidadeNegocio();
				retorno = ent.getId();
			} else {
				retorno = null;
			}
		} catch (Exception e) {
		}
		return retorno;
	}

	public String getChave() {
		String chave = null;
		try {
			EntidadeNegocio ent = new EntidadeNegocio();
			if (!(this.user.getEntidadeNegocio() == null)) {
				ent = (EntidadeNegocio) this.user.getEntidadeNegocio();
				chave = ent.getChave();
			} else {
				chave = "";
			}
		} catch (Exception e) {
		}
		return chave;
	}

	public Integer getId() {
		Integer id = null;
		try {
			id = this.user.getId();
		} catch (Exception e) {
		}
		return id;
	}

	public String getDescricao() {
		String descricao = null;
		try {
			EntidadeNegocio ent = new EntidadeNegocio();
			if (!(this.user.getEntidadeNegocio() == null)) {
				ent = (EntidadeNegocio) this.user.getEntidadeNegocio();
				descricao = ent.getDescricao();
			} else {
				descricao = "";
			}
		} catch (Exception e) {
			descricao = null;
		}
		return descricao;
	}

	public String getUsuario() {
		String usuario = null;
		try {
			usuario = this.user.getUsuario();
		} catch (Exception e) {
			usuario = null;
		}
		return usuario;
	}

	public boolean isFornecedor() {
		boolean retorno = false;
		try {
			if (getEntidadeNegocio().equalsIgnoreCase("FORNECEDOR")) {
				retorno = true;
			}
		} catch (Exception e) {
		}
		return retorno;
	}

	public boolean isAtelier() {
		boolean retorno = false;
		try {
			if (getEntidadeNegocio().equalsIgnoreCase("ATELIER")) {
				retorno = true;
			}
		} catch (Exception e) {
		}
		return retorno;
	}

	public boolean isFornecedorAtelier() {
		boolean retorno = false;
		try {
			if (getTipoEntidadeNegocio().equalsIgnoreCase("ATELIER")
					|| getTipoEntidadeNegocio().equalsIgnoreCase("FORNECEDOR")) {
				retorno = true;
			}
		} catch (Exception e) {
		}
		return retorno;
	}
	
	public boolean isRepresentante() {
		boolean retorno = false;
		try {
			if (getEntidadeNegocio().equalsIgnoreCase("REPRESENTANTE COMERCIAL")) {
				retorno = true;
			}
		} catch (Exception e) {
		}
		return retorno;
	}

}

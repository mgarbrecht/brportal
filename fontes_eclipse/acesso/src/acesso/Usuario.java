package acesso;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.ArrayList;

public class Usuario {
	protected int id;
	protected String nome;
	protected String usuario;
	protected byte senha[];
	protected java.sql.Date dataSenha;
	protected String superUsuario;
	protected String situacao;
	protected Integer diasConsultaRetroativa;
	protected String expiraSenha;
	protected String email;
	protected String usuarioInclusao;
	protected String usuarioAlteracao;
	protected int acessos;
	protected ArrayList<Integer> permissoes = new ArrayList<Integer>();
	protected boolean query;
	protected boolean usuarioInativar;

	EntidadeNegocio enne;

	public Usuario() {
		superUsuario = "N";
		situacao = "A";
		acessos = 0;
		query = false;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public Integer getDiasConsultaRetroativa() {
		return diasConsultaRetroativa;
	}

	public String getExpiraSenha() {
		return expiraSenha;
	}

	public byte[] getSenha() {
		return senha;
	}

	public java.sql.Date getDataSenha() {
		return dataSenha;
	}

	public int getAcessos() {
		return acessos;
	}

	public String getSituacao() {
		return situacao;
	}

	public EntidadeNegocio getEntidadeNegocio() {
		return enne;
	}

	public void incrementAcessos() {
		acessos++;
	}

	public boolean isTipo(String tipo) {
		boolean bReturn = false;
		if (enne != null) {
			bReturn = enne.getTipoEntidadeNegocio().getTipo().equalsIgnoreCase(tipo);
		}
		return bReturn;
	}

	public boolean isAutorizado(int id) {
		boolean autorizado = false;
		if (permissoes.contains(id)) {
			autorizado = true;
		}
		return autorizado;
	}

	public boolean isSuperUsuario() {
		return superUsuario.equals("S");
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDiasConsultaRetroativa(Integer diasConsultaRetroativa) {
		this.diasConsultaRetroativa = diasConsultaRetroativa;
	}

	public void setExpiraSenha(String expiraSenha) {
		this.expiraSenha = expiraSenha;
	}

	public String getEmail() {
		return email;
	}

	public boolean isUsuarioInativar() {
		return usuarioInativar;
	}

	public void setUsuarioInativar(boolean usuarioInativar) {
		this.usuarioInativar = usuarioInativar;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setSenha(byte senha[]) {
		try {
			MessageDigest msd = MessageDigest.getInstance("MD5");
			msd.update(senha);
			this.senha = msd.digest();
		} catch (NoSuchAlgorithmException err) {
			this.senha = senha;
		} finally {
			java.util.Date data = new java.util.Date();
			this.dataSenha = new Date(data.getTime());
		}
	}

	public void setEntidadeNegocio(EntidadeNegocio enne) {
		this.enne = enne;
	}

	public void setDataSenha(java.sql.Date dataSenha) {
		this.dataSenha = dataSenha;
	}

	public void setAcessos(int acessos) {
		this.acessos = acessos;
	}

	public boolean isQuery() {
		return query;
	}

	public void setQuery(boolean query) {
		this.query = query;
	}

	public void setSuperUsuario(boolean superUsuario) {
		if (superUsuario) {
			this.superUsuario = "S";
		} else {
			this.superUsuario = "N";
		}
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public boolean mostraQuery() {
		return this.query;
	}

	public String getUsuarioInclusao() {
		return usuarioInclusao;
	}

	public void setUsuarioInclusao(String usuarioInclusao) {
		this.usuarioInclusao = usuarioInclusao;
	}

	public String getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(String usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

}

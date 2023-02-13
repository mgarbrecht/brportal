package util.bloqueio;

import javax.servlet.http.HttpServletRequest;

import acesso.Usuario;

public class BloqueioUtil {

	private HttpServletRequest request;
	private Usuario usuario;
	private Integer doinId;
	private String[] filiaisUsuario;

	public BloqueioUtil(HttpServletRequest request) {
		this.request = request;
		usuario = (Usuario) request.getSession().getAttribute("User");
		buscaFiliaisUsuario();
	}

	public BloqueioUtil(Integer doinId, HttpServletRequest request) {
		this.doinId = doinId;
		this.request = request;
		usuario = (Usuario) request.getSession().getAttribute("User");
		buscaFiliaisUsuario();
	}

	public Integer getDoinId() {
		return doinId;
	}

	public void setDoinId(Integer doinId) {
		this.doinId = doinId;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String tipoBloqueio(int doinId, String nomeComponente) throws Exception {
		return buscaTipoBloqueio(doinId, nomeComponente);
	}

	public String tipoBloqueio(String nomeComponente) throws Exception {
		return buscaTipoBloqueio(this.doinId, nomeComponente);
	}

	public String buscaTipoBloqueio(int doinId, String nomeComponente) throws Exception {
		String retorno = "";
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			util.consultas.Query query = new util.consultas.Query();
			j = new com.egen.util.jdbc.JdbcUtil();
			// --- Se for administrador libera o acesso ---
			if (this.usuario.isSuperUsuario()) {
				retorno = "";
			} else {
				// --- Efetua os testes para os usuários normais ---
				// --- Testa se possui bloqueio normais para o usuário ---
				StringBuilder sbr = new StringBuilder();
				sbr.append(" SELECT tipo_bloqueio ");
				sbr.append("   FROM bloqueio_documentos_interfaces ");
				sbr.append("  WHERE doin_id = ").append(doinId);
				sbr.append("    AND nome_componente = '").append(nomeComponente.toUpperCase()).append("' ");
				sbr.append("    AND usua_id = ").append(this.usuario.getId());
				sbr.append("    AND status = 'A' ");
				sbr.append("    AND excecao = 'N' ");
				sbr.append("    AND tipo_bloqueio IS NOT NULL ");
				String retornoUsuario = query.retorna(j, sbr.toString());
				if (!retornoUsuario.equals("")) {
					retorno = retornoUsuario;
				} else {
					// --- Testa se existe bloqueio para a entidade de negócio
					// do usuário ---
					if (this.usuario.getEntidadeNegocio() != null) {
						StringBuilder sbre = new StringBuilder();
						sbre.append(" SELECT tipo_bloqueio ");
						sbre.append("   FROM bloqueio_documentos_interfaces ");
						sbre.append("  WHERE doin_id = ").append(doinId);
						sbre.append("    AND nome_componente = '").append(nomeComponente.toUpperCase()).append("' ");
						sbre.append("    AND enne_id = ").append(this.usuario.getEntidadeNegocio().getId());
						sbre.append("    AND status = 'A' ");
						sbre.append("    AND excecao = 'N' ");
						sbre.append("    AND tipo_bloqueio IS NOT NULL ");
						String retornoEntidadeNegocio = query.retorna(j, sbre.toString());
						if (!retornoEntidadeNegocio.equals("")) {
							retorno = retornoEntidadeNegocio;
						} else {
							// --- Testa se existe bloqueio para o tipo de
							// entidade de negócio do usuário ---
							StringBuilder sbrt = new StringBuilder();
							sbrt.append(" SELECT tipo_bloqueio ");
							sbrt.append("   FROM bloqueio_documentos_interfaces ");
							sbrt.append("  WHERE doin_id = ").append(doinId);
							sbrt.append("    AND nome_componente = '").append(nomeComponente.toUpperCase()).append("' ");
							sbrt.append("    AND tien_id = ").append(this.usuario.getEntidadeNegocio().getTipoEntidadeNegocio().getId());
							sbrt.append("    AND status = 'A' ");
							sbrt.append("    AND excecao = 'N' ");
							sbrt.append("    AND tipo_bloqueio IS NOT NULL ");
							String retornoTipoEntidadeNegocio = query.retorna(j, sbrt.toString());
							if (!retornoTipoEntidadeNegocio.equals("")) {
								retorno = retornoTipoEntidadeNegocio;
							}
						}
					}
				}
				// --- Testa se possui bloqueios gerais para o usuário ---
				StringBuilder sbrug = new StringBuilder();
				sbrug.append(" SELECT tipo_bloqueio ");
				sbrug.append("   FROM bloqueio_documentos_interfaces ");
				sbrug.append("  WHERE doin_id = ").append(doinId);
				sbrug.append("    AND nome_componente = '").append(nomeComponente.toUpperCase()).append("'");
				sbrug.append("    AND usua_id <> ").append(this.usuario.getId());
				sbrug.append("    AND status = 'A' ");
				sbrug.append("    AND excecao = 'S'");
				sbrug.append("    AND tipo_bloqueio IS NOT NULL ");
				String retornoUsuarioGeral = query.retorna(j, sbrug.toString());
				if (!retornoUsuarioGeral.equals("")) {
					retorno = retornoUsuarioGeral;
				} else {
					// --- Testa se existe bloqueio para a entidade de negócio
					// do usuário ---
					StringBuilder sben = new StringBuilder();
					sben.append(" SELECT tipo_bloqueio ");
					sben.append("   FROM bloqueio_documentos_interfaces ");
					sben.append("  WHERE doin_id = ").append(doinId);
					sben.append("    AND nome_componente = '").append(nomeComponente.toUpperCase()).append("' ");
					sben.append("    AND enne_id <> ").append(this.usuario.getEntidadeNegocio().getId());
					sben.append("    AND status = 'A' ");
					sben.append("    AND excecao = 'S'");
					sben.append("    AND tipo_bloqueio IS NOT NULL ");
					if (this.usuario.getEntidadeNegocio() != null) {
						String retornoEntidadeNegocioGeral = query.retorna(j, sben.toString());
						if (!retornoEntidadeNegocioGeral.equals("")) {
							retorno = retornoEntidadeNegocioGeral;
						} else {
							// --- Testa se existe bloqueio para o tipo de
							// entidade de negócio do usuário ---
							StringBuilder sbten = new StringBuilder();
							sbten.append(" SELECT tipo_bloqueio ");
							sbten.append("   FROM bloqueio_documentos_interfaces ");
							sbten.append("  WHERE doin_id = ").append(doinId);
							sbten.append("    AND nome_componente = '").append(nomeComponente.toUpperCase()).append("' ");
							sbten.append("    AND tien_id <> ").append(this.usuario.getEntidadeNegocio().getTipoEntidadeNegocio().getId());
							sbten.append("    AND status = 'A' ");
							sbten.append("    AND excecao = 'S'");
							sbten.append("    AND tipo_bloqueio IS NOT NULL ");
							String retornoTipoEntidadeNegocioGeral = query.retorna(j, sbten.toString());
							if (!retornoTipoEntidadeNegocioGeral.equals("")) {
								retorno = retornoTipoEntidadeNegocioGeral;
							}
						}
					}
				}
			}
			return retorno;
		} finally {
			if (j != null) {
				j.close();
			}
		}
	}

	private void buscaFiliaisUsuario() {
		util.consultas.Query query = new util.consultas.Query();
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			if (this.usuario.getEntidadeNegocio() != null && this.usuario.getEntidadeNegocio().getId() == 2048) {
				StringBuilder sb = new StringBuilder();
				sb.append(" SELECT username_oracle ");
				sb.append("   FROM  sca_usuarios ");
				sb.append("  WHERE username_oracle = '").append(this.usuario.getUsuario().toUpperCase()).append("'");
				String usernameOracle = query.retorna(j, sb.toString());
				j = new com.egen.util.jdbc.JdbcUtil();
				StringBuilder sbw = new StringBuilder();
				if (usernameOracle == null) {
					sbw.append(" SELECT rowtocol('SELECT uf.fil_filial ");
					sbw.append("                    FROM wbrio.usuarios us ");
					sbw.append("                       , usuarios_filial uf ");
					sbw.append("                   WHERE us.usua_enne_id = 2048 ");
					sbw.append("                     AND us.usua_usuario = ''").append(this.usuario.getUsuario()).append("'' ");
					sbw.append("                     AND TO_CHAR(uf.contrato) = us.usua_usuario') FROM dual ");
				} else {
					sbw.append(" SELECT rowtocol('SELECT uf.fil_filial ");
					sbw.append("                    FROM wbrio.usuarios  us ");
					sbw.append("                       , usuarios_filial uf ");
					sbw.append("                       , sca_usuarios    scu ");
					sbw.append("                   WHERE us.usua_enne_id = 2048 ");
					sbw.append("                     AND scu.username_oracle = us.usua_usuario ");
					sbw.append("                     AND scu.codigo_do_usuario = uf.codigo_do_usuario ");
					sbw.append("                     AND scu.username_oracle = ''").append(usernameOracle).append("''') FROM dual ");
				}
				StringBuilder sbu = new StringBuilder();
				sbu.append(" SELECT rowtocol('SELECT uf.fil_filial ");
				sbu.append("                    FROM usuarios_filial uf ");
				sbu.append("                       , sca_usuarios sca ");
				sbu.append("                   WHERE sca.codigo_do_usuario = uf.codigo_do_usuario ");
				sbu.append("                     AND sca.username_oracle = ''").append(this.usuario.getUsuario()).append("''') FROM dual ");
				String filiaisUsuario = query.retorna(j, sbw.toString());

				this.filiaisUsuario = filiaisUsuario.split(",");
				if (this.filiaisUsuario.length == 0 || (filiaisUsuario + "").equalsIgnoreCase("null")) {
					filiaisUsuario = query.retorna(j, sbu.toString());
					this.filiaisUsuario = filiaisUsuario.split(",");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (j != null) {
				j.close();
			}
		}
	}

	public boolean pertenceFilial(String filial) {
		if (this.usuario.getEntidadeNegocio() != null && this.usuario.getEntidadeNegocio().getId() == 2048) {
			if (this.filiaisUsuario != null && this.filiaisUsuario.length > 0) {
				for (String fl : this.filiaisUsuario) {
					if (fl.equalsIgnoreCase(filial)) {
						return true;
					}
				}
			}
			return false;
		} else {
			return true;
		}
	}

	public boolean isLiberado(String nomeComponente) throws Exception {
		boolean retorno = false;
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			util.consultas.Query query = new util.consultas.Query();
			j = new com.egen.util.jdbc.JdbcUtil();
			// --- Se for administrador libera o acesso ---
			if (this.usuario.isSuperUsuario()) {
				retorno = true;
			} else {
				// --- Efetua os testes para os usuários normais ---
				// --- Testa se possui liberacoes normais para os usuários ---
				StringBuilder sbr = new StringBuilder();
				sbr.append(" SELECT 'S' ");
				sbr.append("   FROM bloqueio_documentos_interfaces ");
				sbr.append("  WHERE doin_id = ").append(doinId);
				sbr.append("    AND nome_componente = '").append(nomeComponente.toUpperCase()).append("' ");
				sbr.append("    AND usua_id = ").append(this.usuario.getId());
				sbr.append("    AND status = 'A' ");
				sbr.append("    AND excecao = 'N' ");
				sbr.append("    AND tipo_bloqueio IS NULL ");
				String retornoUsuario = query.retorna(j, sbr.toString());
				if (!retornoUsuario.equals("")) {
					retorno = true;
				} else {
					// --- Testa se existe liberacao para a entidade de negócio
					// do usuário ---
					if (this.usuario.getEntidadeNegocio() != null) {
						StringBuilder sbre = new StringBuilder();
						sbre.append(" SELECT 'S' ");
						sbre.append("   FROM bloqueio_documentos_interfaces ");
						sbre.append("  WHERE doin_id = ").append(doinId);
						sbre.append("    AND nome_componente = '").append(nomeComponente.toUpperCase()).append("' ");
						sbre.append("    AND enne_id = ").append(this.usuario.getEntidadeNegocio().getId());
						sbre.append("    AND status = 'A' ");
						sbre.append("    AND excecao = 'N' ");
						sbre.append("    AND tipo_bloqueio IS NULL ");
						String retornoEntidadeNegocio = query.retorna(j, sbre.toString());
						if (!retornoEntidadeNegocio.equals("")) {
							retorno = true;
						} else {
							// --- Testa se existe liberacao para o tipo de
							// entidade de negócio do usuário ---
							StringBuilder sbrt = new StringBuilder();
							sbrt.append(" SELECT 'S' ");
							sbrt.append("   FROM bloqueio_documentos_interfaces ");
							sbrt.append("  WHERE doin_id = ").append(doinId);
							sbrt.append("    AND nome_componente = '").append(nomeComponente.toUpperCase()).append("' ");
							sbrt.append("    AND tien_id = ").append(this.usuario.getEntidadeNegocio().getTipoEntidadeNegocio().getId());
							sbrt.append("    AND status = 'A' ");
							sbrt.append("    AND excecao = 'N' ");
							sbrt.append("    AND tipo_bloqueio IS NULL ");
							String retornoTipoEntidadeNegocio = query.retorna(j, sbrt.toString());
							if (!retornoTipoEntidadeNegocio.equals("")) {
								retorno = true;
							}
						}
					}
				}
			}
			return retorno;
		} finally {
			if (j != null) {
				j.close();
			}
		}
	}
	
	
	public boolean possuiExcecaoByTipo(String nomeComponente, String tipoBloqueio) throws Exception {
		boolean retorno = false;
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			util.consultas.Query query = new util.consultas.Query();
			j = new com.egen.util.jdbc.JdbcUtil();
			StringBuilder sbr = new StringBuilder();
			sbr.append(" SELECT 'S' ");
			sbr.append("   FROM bloqueio_documentos_interfaces ");
			sbr.append("  WHERE doin_id = ").append(doinId);
			sbr.append("    AND nome_componente = '").append(nomeComponente.toUpperCase()).append("' ");
			sbr.append("    AND usua_id = ").append(this.usuario.getId());
			sbr.append("    AND status = 'A' ");
			sbr.append("    AND excecao = 'S' ");
			sbr.append("    AND tipo_bloqueio = '").append(tipoBloqueio).append("'");
			String retornoUsuario = query.retorna(j, sbr.toString());
			if (!retornoUsuario.equals("")) {
				retorno = true;
			} else {
				if (this.usuario.getEntidadeNegocio() != null) {
					StringBuilder sbre = new StringBuilder();
					sbre.append(" SELECT 'S' ");
					sbre.append("   FROM bloqueio_documentos_interfaces ");
					sbre.append("  WHERE doin_id = ").append(doinId);
					sbre.append("    AND nome_componente = '").append(nomeComponente.toUpperCase()).append("' ");
					sbre.append("    AND enne_id = ").append(this.usuario.getEntidadeNegocio().getId());
					sbre.append("    AND status = 'A' ");
					sbre.append("    AND excecao = 'S' ");
					sbre.append("    AND tipo_bloqueio = '").append(tipoBloqueio).append("'");
					String retornoEntidadeNegocio = query.retorna(j, sbre.toString());
					if (!retornoEntidadeNegocio.equals("")) {
						retorno = true;
					} else {
						StringBuilder sbrt = new StringBuilder();
						sbrt.append(" SELECT 'S' ");
						sbrt.append("   FROM bloqueio_documentos_interfaces ");
						sbrt.append("  WHERE doin_id = ").append(doinId);
						sbrt.append("    AND nome_componente = '").append(nomeComponente.toUpperCase()).append("' ");
						sbrt.append("    AND tien_id = ").append(this.usuario.getEntidadeNegocio().getTipoEntidadeNegocio().getId());
						sbrt.append("    AND status = 'A' ");
						sbrt.append("    AND excecao = 'S' ");
						sbrt.append("    AND tipo_bloqueio = '").append(tipoBloqueio).append("'");
						String retornoTipoEntidadeNegocio = query.retorna(j, sbrt.toString());
						if (!retornoTipoEntidadeNegocio.equals("")) {
							retorno = true;
						}
					}
				}
			}

			return retorno;
		} finally {
			if (j != null) {
				j.close();
			}
		}
	}

}

package acesso;

import java.util.TreeMap;
import java.util.Vector;
import portalbr.dbobj.table.*;
import util.consultas.Sequence;

@SuppressWarnings("unchecked")
public class Autorizacoes {

	private String tipoGeracao;
	private Integer tienId;
	private Integer enneId;
	private Integer usuaId;
	private Integer doinId;

	public String getTipoGeracao() {
		return tipoGeracao;
	}

	public void setTipoGeracao(String tipoGeracao) {
		this.tipoGeracao = tipoGeracao;
	}

	public Integer getTienId() {
		return tienId;
	}

	public void setTienId(Integer tienId) {
		this.tienId = tienId;
	}

	public Integer getEnneId() {
		return enneId;
	}

	public void setEnneId(Integer enneId) {
		this.enneId = enneId;
	}

	public Integer getUsuaId() {
		return usuaId;
	}

	public void setUsuaId(Integer usuaId) {
		this.usuaId = usuaId;
	}

	public Integer getDoinId() {
		return doinId;
	}

	public void setDoinId(Integer doinId) {
		this.doinId = doinId;
	}

	private void generateByTienId(Integer tienId, Integer doinId) {
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			Entidades_negocio tableEntidadeNegocio = new Entidades_negocio();
			Usuarios tableUsuarios = new Usuarios();
			String[][] select = null;
			Object[][] where = { { "enne_tien_id", "=", tienId } };
			Vector<Entidades_negocio> res_Entidades_negocio = j.select(tableEntidadeNegocio, select, where, null, null, null);
			for (int ie = 0; ie < res_Entidades_negocio.size(); ie++) {
				Entidades_negocio entidadeNegocio = res_Entidades_negocio.get(ie);
				String[][] selectUsuarios = null;
				Object[][] whereUsuarios = { { "usua_enne_id", "=", entidadeNegocio.getEnne_id() } };
				Vector<Usuarios> res_Usuarios = j.select(tableUsuarios, selectUsuarios, whereUsuarios, null, null, null);
				for (int iu = 0; iu < res_Usuarios.size(); iu++) {
					Usuarios usuario = res_Usuarios.get(iu);
					generateByUsuaId(usuario.getUsua_id(), doinId);
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			if (j != null) {
				j.close();
			}
		}
	}

	private void generateByEnneId(Integer enneId, Integer doinId) {
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			Entidades_negocio tableEntidadeNegocio = new Entidades_negocio();
			Usuarios tableUsuarios = new Usuarios();
			String[][] select = null;
			Object[][] where = { { "enne_id", "=", enneId } };
			Vector<Entidades_negocio> res_Entidades_negocio = j.select(tableEntidadeNegocio, select, where, null, null, null);
			for (int ie = 0; ie < res_Entidades_negocio.size(); ie++) {
				Entidades_negocio entidadeNegocio = res_Entidades_negocio.get(ie);
				String[][] selectUsuarios = null;
				Object[][] whereUsuarios = { { "usua_enne_id", "=", entidadeNegocio.getEnne_id() } };
				Vector<Usuarios> res_Usuarios = j.select(tableUsuarios, selectUsuarios, whereUsuarios, null, null, null);
				for (int iu = 0; iu < res_Usuarios.size(); iu++) {
					Usuarios usuario = res_Usuarios.get(iu);
					generateByUsuaId(usuario.getUsua_id(), doinId);
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			if (j != null) {
				j.close();
			}
		}
	}

	private void generateByDoinId(Integer doinId) {
		com.egen.util.jdbc.JdbcUtil j = null;
		Acessos_documentos_interfaces tableAcessosDocumentosInterfaces = new Acessos_documentos_interfaces();
		Acessos_tipos_ent_negocio_vw tableAcessosTiposEntNegocioVw = new Acessos_tipos_ent_negocio_vw();
		Acessos_ent_negocio_vw tableAcessosEntNegocioVw = new Acessos_ent_negocio_vw();
		Acessos_usuarios_vw tableAcessosUsuariosVw = new Acessos_usuarios_vw();
		Sequence sequence = new Sequence();
		TreeMap<Integer, Autorizacao> tmapAutorizacoes = new TreeMap<Integer, Autorizacao>();
		TreeMap<Integer, Autorizacao> tmapAutorizacoesExistentes = new TreeMap<Integer, Autorizacao>();
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			// --- Autorizacoes Existentes ---
			String[][] selectAcessosDocumentosInterfaces = null;
			Object[][] whereAcessosDocumentosInterfaces = { { "acdi_doin_id", "=", doinId } };
			Vector<Acessos_documentos_interfaces> resAcessosDocumentosInterfaces = j.select(tableAcessosDocumentosInterfaces, selectAcessosDocumentosInterfaces, whereAcessosDocumentosInterfaces, null, null, null);
			for (int iadi = 0; iadi < resAcessosDocumentosInterfaces.size(); iadi++) {
				Acessos_documentos_interfaces adi = resAcessosDocumentosInterfaces.get(iadi);
				tmapAutorizacoesExistentes.put(adi.getAcdi_usua_id(), new Autorizacao(adi.getAcdi_usua_id(), adi.getAcdi_doin_id(), adi.getAcdi_dias_consulta_retroativa(), "N"));

				// --- Novas Autorizacoes ---
				String[][] selectAcessosTiposEntNegocioVw = null;
				Object[][] whereAcessosTiposEntNegocioVw = { { "doin_id", "=",doinId } };
				Vector<Acessos_tipos_ent_negocio_vw> resAcessosTiposEntNegocioVw = j.select(tableAcessosTiposEntNegocioVw, selectAcessosTiposEntNegocioVw, whereAcessosTiposEntNegocioVw, null, null, null);
				for (int iaten = 0; iaten < resAcessosDocumentosInterfaces.size(); iaten++) {
					Acessos_tipos_ent_negocio_vw tipo = resAcessosTiposEntNegocioVw.get(iaten);
					tmapAutorizacoes.put(tipo.getUsua_id(), new Autorizacao(tipo.getUsua_id(), tipo.getDoin_id(), tipo.getDias_consulta_retroativa(), "N"));
				}
				String[][] selectAcessosEntNegocioVw = null;
				Object[][] whereAcessosEntNegocioVw = { { "doin_id", "=", doinId } };
				Vector<Acessos_ent_negocio_vw> resAcessosEntNegocioVw = j.select(tableAcessosEntNegocioVw, selectAcessosEntNegocioVw, whereAcessosEntNegocioVw, null, null, null);
				for (int iaen = 0; iaen < resAcessosDocumentosInterfaces.size(); iaen++) {
					Acessos_ent_negocio_vw entidade = resAcessosEntNegocioVw.get(iaen);
					tmapAutorizacoes.put(entidade.getUsua_id(), new Autorizacao(entidade.getUsua_id(), entidade.getDoin_id(), entidade.getDias_consulta_retroativa(), "N"));
				}
				String[][] selectAcessosUsuariosVw = null;
				Object[][] whereAcessosUsuariosVw = { { "doin_id", "=", doinId } };
				Vector<Acessos_usuarios_vw> resAcessosUsuariosVw = j.select(tableAcessosUsuariosVw, selectAcessosUsuariosVw, whereAcessosUsuariosVw, null, null, null);
				for (int iaus = 0; iaus < resAcessosDocumentosInterfaces.size(); iaus++) {Acessos_usuarios_vw usuario = resAcessosUsuariosVw.get(iaus);
					tmapAutorizacoes.put(usuario.getUsua_id(), new Autorizacao(usuario.getUsua_id(), usuario.getDoin_id(), usuario.getDias_consulta_retroativa(), usuario.getNegar_acesso()));
				}

				// --- Atualiza os acessos com base nas permissões cadastradas
				for (Autorizacao aut : tmapAutorizacoes.values()) {
					if (tmapAutorizacoesExistentes.containsKey(aut.getUsuaId())) {
						if (aut.getNegarAcesso().equalsIgnoreCase("S")) {
							Acessos_documentos_interfaces table = new Acessos_documentos_interfaces();
							String[][] select = null;
							Object[][] where = {
									{ "acdi_doin_id", "=", aut.getDoinId() },
									{ "acdi_usua_id", "=", aut.getUsuaId() } };
							Vector<Acessos_documentos_interfaces> res_Acessos_documentos_interfaces = j.select(table, select, where, null, null, null);
							if (res_Acessos_documentos_interfaces != null && res_Acessos_documentos_interfaces.size() > 0) {
								Acessos_documentos_interfaces acessosDocumentosInterfaces = (Acessos_documentos_interfaces) res_Acessos_documentos_interfaces.elementAt(0);
								j.delete(acessosDocumentosInterfaces);
							}
						} else {
							if (!aut.getDiasConsultaRetroativa().equals(tmapAutorizacoesExistentes.get(aut.getUsuaId()).getDiasConsultaRetroativa())) {
								Acessos_documentos_interfaces table = new Acessos_documentos_interfaces();
								String[][] select = null;
								Object[][] where = {
										{ "acdi_doin_id", "=", aut.getDoinId() },
										{ "acdi_usua_id", "=", aut.getUsuaId() } };
								Vector<Acessos_documentos_interfaces> res_Acessos_documentos_interfaces = j.select(table, select, where, null, null, null);
								if (res_Acessos_documentos_interfaces != null && res_Acessos_documentos_interfaces.size() > 0) {
									Acessos_documentos_interfaces acessosDocumentosInterfaces = (Acessos_documentos_interfaces) res_Acessos_documentos_interfaces.elementAt(0);
									acessosDocumentosInterfaces.setAcdi_dias_consulta_retroativa(aut.getDiasConsultaRetroativa());
									j.update(acessosDocumentosInterfaces);
								}
							}
						}
					} else {
						if (aut.getNegarAcesso().equalsIgnoreCase("N")) {
							int id = sequence.nextValue("acessos_documentos_interfaces", "acdi_id");
							Acessos_documentos_interfaces adin = new Acessos_documentos_interfaces();
							adin.setAcdi_id(id);
							adin.setAcdi_doin_id(aut.getDoinId());
							adin.setAcdi_usua_id(aut.getUsuaId());
							adin.setAcdi_favorito("N");
							adin.setAcdi_dias_consulta_retroativa(aut.getDiasConsultaRetroativa());
							j.insert(adin);
						}
					}
				}

				// --- Remove os acessos existentes que não estão autorizados
				for (Autorizacao aut : tmapAutorizacoesExistentes.values()) {
					if (!tmapAutorizacoes.containsKey(aut.getUsuaId())) {
						Acessos_documentos_interfaces table = new Acessos_documentos_interfaces();
						String[][] select = null;
						Object[][] where = {
								{ "acdi_doin_id", "=", aut.getDoinId() },
								{ "acdi_usua_id", "=", aut.getUsuaId() } };
						Vector<Acessos_documentos_interfaces> res_Acessos_documentos_interfaces = j.select(table, select, where, null, null, null);
						if (res_Acessos_documentos_interfaces != null && res_Acessos_documentos_interfaces.size() > 0) {
							Acessos_documentos_interfaces acessosDocumentosInterfaces = (Acessos_documentos_interfaces) res_Acessos_documentos_interfaces.elementAt(0);
							j.delete(acessosDocumentosInterfaces);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			if (j != null) {
				j.close();
			}
		}
	}

	private void generateByUsuaId(Integer usuaId, Integer doinId) {
		Acessos_documentos_interfaces tableAcessosDocumentosInterfaces = new Acessos_documentos_interfaces();
		Acessos_tipos_ent_negocio_vw tableAcessosTiposEntNegocioVw = new Acessos_tipos_ent_negocio_vw();
		Acessos_ent_negocio_vw tableAcessosEntNegocioVw = new Acessos_ent_negocio_vw();
		Acessos_usuarios_vw tableAcessosUsuariosVw = new Acessos_usuarios_vw();
		Sequence sequence = new Sequence();
		TreeMap<Integer, Autorizacao> tmapAutorizacoes = new TreeMap<Integer, Autorizacao>();
		TreeMap<Integer, Autorizacao> tmapAutorizacoesExistentes = new TreeMap<Integer, Autorizacao>();
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			String[][] selectAcessosDocumentosInterfaces = null;
			Object[][] whereAcessosDocumentosInterfaces = {
					{ "acdi_usua_id", "=", usuaId },
					{ "acdi_doin_id", "=", doinId != null ? doinId : "" } };

			String[][] selectAcessosTiposEntNegocioVw = null;
			Object[][] whereAcessosTiposEntNegocioVw = {
					{ "usua_id", "=", usuaId },
					{ "doin_id", "=", doinId != null ? doinId : "" } };

			String[][] selectAcessosEntNegocioVw = null;
			Object[][] whereAcessosEntNegocioVw = { { "usua_id", "=", usuaId },
					{ "doin_id", "=", doinId != null ? doinId : "" } };

			String[][] selectAcessosUsuariosVw = null;
			Object[][] whereAcessosUsuariosVw = { { "usua_id", "=", usuaId },
					{ "doin_id", "=", doinId != null ? doinId : "" } };

			// --- Autorizacoes Existentes ---
			Vector<Acessos_documentos_interfaces> resAcessosDocumentosInterfaces = j.select(tableAcessosDocumentosInterfaces, selectAcessosDocumentosInterfaces, whereAcessosDocumentosInterfaces, null, null, null);
			for (int iadi = 0; iadi < resAcessosDocumentosInterfaces.size(); iadi++) {
				Acessos_documentos_interfaces adi = resAcessosDocumentosInterfaces.get(iadi);
				tmapAutorizacoesExistentes.put(adi.getAcdi_doin_id(), new Autorizacao(adi.getAcdi_usua_id(), adi.getAcdi_doin_id(), adi.getAcdi_dias_consulta_retroativa(), "N"));
			}

			// --- Novas Autorizacoes ---
			Vector<Acessos_tipos_ent_negocio_vw> resAcessosTiposEntNegocioVw = j.select(tableAcessosTiposEntNegocioVw,selectAcessosTiposEntNegocioVw,whereAcessosTiposEntNegocioVw, null, null, null);
			for (int iaten = 0; iaten < resAcessosTiposEntNegocioVw.size(); iaten++) {
				Acessos_tipos_ent_negocio_vw tipo = resAcessosTiposEntNegocioVw.get(iaten);
				tmapAutorizacoes.put(tipo.getDoin_id(),new Autorizacao(tipo.getUsua_id(), tipo.getDoin_id(),tipo.getDias_consulta_retroativa(), "N"));
			}

			Vector<Acessos_ent_negocio_vw> resAcessosEntNegocioVw = j.select(tableAcessosEntNegocioVw, selectAcessosEntNegocioVw,whereAcessosEntNegocioVw, null, null, null);
			for (int iaen = 0; iaen < resAcessosEntNegocioVw.size(); iaen++) {
				Acessos_ent_negocio_vw entidade = resAcessosEntNegocioVw.get(iaen);
				tmapAutorizacoes.put(entidade.getDoin_id(),new Autorizacao(entidade.getUsua_id(), entidade.getDoin_id(), entidade.getDias_consulta_retroativa(), "N"));
			}

			Vector<Acessos_usuarios_vw> resAcessosUsuariosVw = j.select(tableAcessosUsuariosVw, selectAcessosUsuariosVw,whereAcessosUsuariosVw, null, null, null);
			for (int iaus = 0; iaus < resAcessosUsuariosVw.size(); iaus++) {
				Acessos_usuarios_vw usuario = resAcessosUsuariosVw.get(iaus);
				tmapAutorizacoes.put(usuario.getDoin_id(),new Autorizacao(usuario.getUsua_id(), usuario.getDoin_id(), usuario.getDias_consulta_retroativa(), usuario.getNegar_acesso()));
			}

			// --- Atualiza os acessos com base nas permissões cadastradas ---
			for (Autorizacao aut : tmapAutorizacoes.values()) {
				if (tmapAutorizacoesExistentes.containsKey(aut.getDoinId())) {
					if (aut.getNegarAcesso().equalsIgnoreCase("S")) {
						Acessos_documentos_interfaces table = new Acessos_documentos_interfaces();
						String[][] select = null;
						Object[][] where = {
								{ "acdi_doin_id", "=", aut.getDoinId() },
								{ "acdi_usua_id", "=", aut.getUsuaId() } };
						Vector<Acessos_documentos_interfaces> res_Acessos_documentos_interfaces = j.select(table, select, where, null, null, null);
						if (res_Acessos_documentos_interfaces != null && res_Acessos_documentos_interfaces.size() > 0) {
							Acessos_documentos_interfaces acessosDocumentosInterfaces = (Acessos_documentos_interfaces) res_Acessos_documentos_interfaces.elementAt(0);
							j.delete(acessosDocumentosInterfaces);
						}
					} else {
						if (!aut.getDiasConsultaRetroativa().equals(tmapAutorizacoesExistentes.get(aut.getDoinId()).getDiasConsultaRetroativa())) {
							Acessos_documentos_interfaces table = new Acessos_documentos_interfaces();
							String[][] select = null;
							Object[][] where = {
									{ "acdi_doin_id", "=", aut.getDoinId() },
									{ "acdi_usua_id", "=", aut.getUsuaId() } };
							Vector<Acessos_documentos_interfaces> res_Acessos_documentos_interfaces = j.select(table, select, where, null, null,null);
							if (res_Acessos_documentos_interfaces != null && res_Acessos_documentos_interfaces.size() > 0) {
								Acessos_documentos_interfaces acessosDocumentosInterfaces = (Acessos_documentos_interfaces) res_Acessos_documentos_interfaces.elementAt(0);
								acessosDocumentosInterfaces.setAcdi_dias_consulta_retroativa(aut.getDiasConsultaRetroativa());
								j.update(acessosDocumentosInterfaces);
							}
						}
					}
				} else {
					if (aut.getNegarAcesso().equalsIgnoreCase("N")) {
						int id = sequence.nextValue("acessos_documentos_interfaces", "acdi_id");
						Acessos_documentos_interfaces adin = new Acessos_documentos_interfaces();
						adin.setAcdi_id(id);
						adin.setAcdi_doin_id(aut.getDoinId());
						adin.setAcdi_usua_id(aut.getUsuaId());
						adin.setAcdi_favorito("N");
						adin.setAcdi_dias_consulta_retroativa(aut.getDiasConsultaRetroativa());
						j.insert(adin);
					}
				}
			}

			// --- Remove os acessos existentes que não estão autorizados ---
			for (Autorizacao aut : tmapAutorizacoesExistentes.values()) {
				if (!tmapAutorizacoes.containsKey(aut.getDoinId())) {
					Acessos_documentos_interfaces table = new Acessos_documentos_interfaces();
					String[][] select = null;
					Object[][] where = {
							{ "acdi_doin_id", "=", aut.getDoinId() },
							{ "acdi_usua_id", "=", aut.getUsuaId() } };
					Vector<Acessos_documentos_interfaces> res_Acessos_documentos_interfaces = j.select(table, select, where, null, null, null);
					if (res_Acessos_documentos_interfaces != null && res_Acessos_documentos_interfaces.size() > 0) {
						Acessos_documentos_interfaces acessosDocumentosInterfaces = (Acessos_documentos_interfaces) res_Acessos_documentos_interfaces.elementAt(0);
						j.delete(acessosDocumentosInterfaces);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			if (j != null) {
				j.close();
			}
		}
	}

	public String gerar() {
		boolean validou = true;
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			if (this.doinId != null) {
				Documentos_interfaces table = new Documentos_interfaces();
				String[][] select = null;
				Object[][] where = { { "doin_id", "=", this.doinId } };
				Vector<Documentos_interfaces> res_Documentos_interfaces = j.select(table, select, where, null, null, null);
				if (res_Documentos_interfaces != null && res_Documentos_interfaces.size() == 0) {
					validou = false;
					return("Documento/interface inválido!");
				}
			}
			if (validou) {
				if (tipoGeracao.equalsIgnoreCase("T")) {
					if (this.tienId == null) {
						return("É necessário informar o tipo de entidade!");
					} else {
						Tipos_entidade_negocio table = new Tipos_entidade_negocio();
						String[][] select = null;
						Object[][] where = { { "tien_id", "=", this.tienId } };
						Vector<Tipos_entidade_negocio> res_Tipos_entidade_negocio = j.select(table, select, where, null, null, null);
						if (res_Tipos_entidade_negocio != null && res_Tipos_entidade_negocio.size() == 0) {
							return("Tipo de entidade inválida!");
						} else {
							generateByTienId(this.tienId, this.doinId);
							return("Autorizações geradas com sucesso!");
						}
					}
				} else if (tipoGeracao.equalsIgnoreCase("E")) {
					if (this.enneId == null) {
						return("É necessário informar a entidade de negócio!");
					} else {
						Entidades_negocio table = new Entidades_negocio();
						String[][] select = null;
						Object[][] where = { { "enne_id", "=", this.enneId } };
						Vector<Entidades_negocio> res_Entidades_negocio = j.select(table, select, where, null, null, null);
						if (res_Entidades_negocio != null && res_Entidades_negocio.size() == 0) {
							return("Entidade de negócio inválida!");
						} else {
							generateByEnneId(this.enneId, this.doinId);
							return("Autorizações geradas com sucesso!");
						}
					}
				} else if (tipoGeracao.equalsIgnoreCase("U")) {
					if (this.usuaId == null) {
						return("É necessário informar o usuário!");
					} else {
						Usuarios table = new Usuarios();
						String[][] select = null;
						Object[][] where = { { "usua_id", "=", this.usuaId } };
						Vector<Usuarios> res_Usuarios = j.select(table, select, where, null, null, null);
						if (res_Usuarios != null && res_Usuarios.size() == 0) {
							return("Usuário inválido!");
						} else {
							generateByUsuaId(this.usuaId, this.doinId);
							return("Autorizações geradas com sucesso!");
						}
					}
				} else if (tipoGeracao.equalsIgnoreCase("D")) {
					if (this.doinId == null) {
						return("É necessário informar o documento/interface!");
					} else {
						generateByDoinId(this.doinId);
						return("Autorizações geradas com sucesso!");
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			if (j != null) {
				j.close();
			}
		}
		return null;
	}

}
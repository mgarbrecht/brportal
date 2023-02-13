package acesso;

import java.sql.*;

public class ItemMenuAPI extends ItemMenu {

	private Connection conn;
	private ItemMenu old;

	public ItemMenuAPI(Connection conn) {
		this.conn = conn;
	}

	public ItemMenuAPI(Connection conn, int id) throws SQLException {
		this(conn);
		select(id);
	}

	public boolean autorizado(Usuario usua) {
		if (usua.isSuperUsuario() || documentoInterface == null) {
			return true;
		}
		try {
			DocumentoInterfaceAPI doin = new DocumentoInterfaceAPI(conn, documentoInterface.getId());
			return doin.autorizado(usua);
		} catch (SQLException er) {
			return false;
		}
	}

	public AcessoDocumentoInterface getAcesso(Usuario usua) {
		AcessoDocumentoInterface acdi = null;
		try {
			if (documentoInterface != null) {
				DocumentoInterfaceAPI doin = new DocumentoInterfaceAPI(conn, documentoInterface.getId());
				acdi = doin.getAcesso(usua);
			}
		} catch (SQLException er) {
			return acdi = null;
		}
		return acdi;
	}

	public String getComando(String contextPath) {
		String comando;
		if (documentoInterface == null) {
			comando = super.getComando();
		} else {
			comando = super.getComando().replaceAll("<doc_interface>", documentoInterface.getNome());
		}
		comando = comando.replaceAll("<app_context>", contextPath);
		return comando;
	}

	public void setNome(String nome) {
		super.setNome(nome.trim().toUpperCase());
	}

	private void validate() throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			StringBuilder emsg = new StringBuilder();
			if (nome == null || nome.equals("")) {
				emsg.append("O nome deve ser informado.\n");
			} else if (nome.length() > 80) {
				emsg.append("O nome possui mais de 80 caracteres.\n");
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append(" SELECT /*+ all_rows */ itme_id ");
				sb.append("   FROM itens_menus ");
				sb.append("  WHERE itme_nome = ? ");
				sb.append("    AND itme_id != ? ");
				sb.append("    AND itme_menu_codigo_sistema = 'BRNET' ");
				pstm = conn.prepareStatement(sb.toString());
				pstm.setString(1, nome);
				pstm.setInt(2, id);
				rset = pstm.executeQuery();
				if (rset.next()) {
					emsg.append("Item de menu j\341 cadastrado.\n");
				}
			}
			if (texto == null || texto.equals("")) {
				emsg.append("O texto do item de menu deve ser informado.\n");
			} else if (texto.length() > 255) {
				emsg.append("O texto do item de menu n\343o pode ter mais de 255 caracteres.\n");
			}
			if (comando == null || comando.equals("")) {
				emsg.append("O comando do item de menu deve ser informado.\n");
			} else if (comando.length() > 255) {
				emsg.append("O comando do item de menu n\343o pode ter mais de 255 caracteres.\n");
			}
			if (menu == null) {
				emsg.append("O menu ao qual o item deve ser adicionado n\343o foi informado.\n");
			} else if (menu.getId() == 0) {
				emsg.append("Menu n\343o cadastrado.\n");
			}
			if (documentoInterface != null) {
				if (documentoInterface.getId() == 0) {
					emsg.append("Documento/Interface n\343o cadastrado.\n");
				} else if (comando.indexOf("<doc_interface>") == -1) {
					emsg.append("A tag <doc_interface> n\343o foi inclu\355da no comando.\n");
				}
			}
			if (emsg.length() > 0) {
				throw new SQLException(emsg.toString());
			} else {
				return;
			}
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		}
	}

	public void select(int id) throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT /*+ all_rows */ itme_nome ");
			sb.append("      , itme_texto ");
			sb.append("      , itme_comando ");
			sb.append("      , itme_menu_id ");
			sb.append("      , itme_doin_id ");
			sb.append("   FROM itens_menus ");
			sb.append("  WHERE itme_id = ? ");
			sb.append("    AND itme_menu_codigo_sistema = 'BRNET' ");
			pstm = conn.prepareStatement(sb.toString());
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			if (rset.next()) {
				nome = rset.getString(1);
				texto = rset.getString(2);
				comando = rset.getString(3);
				MenuAPI menu = new MenuAPI(conn);
				menu.select(rset.getInt(4));
				this.menu = menu;
				int i_doin = rset.getInt(5);
				if (i_doin == 0) {
					documentoInterface = null;
				} else {
					DocumentoInterfaceAPI doin = new DocumentoInterfaceAPI(conn);
					doin.select(i_doin);
					documentoInterface = doin;
				}
				this.id = id;
				old = this;
			} else {
				throw new SQLException("Item de menu n\343o cadastrado.");
			}
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		}
	}

	public void insert() throws SQLException {
		//Sequence sequence = new Sequence();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			if (id == 0) {
				validate();
				pstm = this.conn.prepareStatement("SELECT nvl(max(itme_id)+1,1) FROM itenS_menus");
				rset = pstm.executeQuery();
				rset.next();
				int newId = rset.getInt(1);
				//newId = sequence.nextValue("menus", "menu_id");
				rset.close();
				pstm.close();				
				//int newId = sequence.nextValue("itens_menus", "itme_id");
				StringBuilder sb = new StringBuilder();
				sb.append(" INSERT INTO itens_menus ");
				sb.append("        ( itme_id ");
				sb.append("        , itme_nome ");
				sb.append("        , itme_texto ");
				sb.append("        , itme_comando ");
				sb.append("        , itme_menu_id ");
				sb.append("        , itme_doin_id ");
				sb.append("        , itme_menu_codigo_sistema )");
				sb.append(" VALUES (?, ?, ?, ?, ?, ?, 'BRNET')");
				pstm = conn.prepareStatement(sb.toString());
				pstm.setInt(1, newId);
				pstm.setString(2, nome);
				pstm.setString(3, texto);
				pstm.setString(4, comando);
				pstm.setInt(5, menu.getId());
				if (documentoInterface == null) {
					pstm.setString(6, "");
				} else {
					pstm.setInt(6, documentoInterface.getId());
				}
				pstm.executeUpdate();
				pstm.close();
				select(newId);
			} else {
				throw new SQLException("Item de menu j\341 cadastrado.\n");
			}
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		}
	}

	public void update() throws SQLException {
		PreparedStatement pstm = null;
		try {
			if (old != null && id == old.id) {
				validate();
				StringBuilder sb = new StringBuilder();
				sb.append(" UPDATE itens_menus ");
				sb.append("    SET itme_nome = ? ");
				sb.append("      , itme_texto = ? ");
				sb.append("      , itme_comando = ? ");
				sb.append("      , itme_menu_id = ? ");
				sb.append("      , itme_doin_id = ? ");
				sb.append("  WHERE itme_id = ?");
				pstm = conn.prepareStatement(sb.toString());
				pstm.setString(1, nome);
				pstm.setString(2, texto);
				pstm.setString(3, comando);
				pstm.setInt(4, menu.getId());
				if (documentoInterface == null) {
					pstm.setString(5, "");
				} else {
					pstm.setInt(5, documentoInterface.getId());
				}
				pstm.setInt(6, id);
				pstm.executeUpdate();
				select(id);
			} else {
				throw new SQLException("Item de menu n\343o cadastrado.");
			}
		} finally {
			if (pstm != null) {
				pstm.close();
			}
		}
	}

	public void delete() throws SQLException {
		PreparedStatement pstm = null;
		try {
			if (old != null && id == old.id) {
				pstm = conn.prepareStatement(new StringBuilder(
						" DELETE itens_menus ").append("  WHERE itme_id = ?")
						.toString());
				pstm.setInt(1, id);
				pstm.executeUpdate();
				id = 0;
			} else {
				throw new SQLException("Item de menu n\343o cadastrado.");
			}
		} finally {
			if (pstm != null) {
				pstm.close();
			}
		}
	}

}

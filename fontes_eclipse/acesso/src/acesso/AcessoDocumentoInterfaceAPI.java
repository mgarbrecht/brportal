package acesso;

import java.sql.*;
import java.util.TreeMap;

public class AcessoDocumentoInterfaceAPI extends AcessoDocumentoInterface {

	private Connection conn;
	private AcessoDocumentoInterface old;

	public AcessoDocumentoInterfaceAPI(Connection conn) {
		super();
		this.conn = conn;
	}

	public AcessoDocumentoInterfaceAPI(Connection conn, int id) throws SQLException {
		this(conn);
		select(id);
	}

	public AcessoDocumentoInterfaceAPI(Connection conn, int usua_id, int doin_id) throws SQLException {
		this(conn);
		select(usua_id, doin_id);
	}

	public int exists() throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		int id = 0;
		try {
			if (this.documentoInterface != null && this.usuario != null) {
				StringBuilder sb = new StringBuilder();
				sb.append(" SELECT /*+ all_rows */ ");
				sb.append("        acdi_id ");
				sb.append("   FROM acessos_documentos_interfaces ");
				sb.append("  WHERE acdi_doin_id = ? ");
				sb.append("    AND acdi_usua_id = ? ");
				sb.append("    AND acdi_id     != ? ");
				pstm = this.conn.prepareStatement(sb.toString());
				pstm.setInt(1, this.documentoInterface.getId());
				pstm.setInt(2, this.usuario.getId());
				pstm.setInt(3, this.id);
				rset = pstm.executeQuery();
				if (rset.next()) {
					id = rset.getInt(1);
				}
			}
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		}
		return id;
	}

	private void validate() throws SQLException {
		StringBuilder emsg = new StringBuilder();
		if (this.documentoInterface == null) {
			emsg.append("O documento/interface deve ser informado.\n");
		} else if (this.documentoInterface.getId() == 0) {
			emsg.append("Documento/Interface não cadastrado.\n");
		}
		if (this.usuario == null) {
			emsg.append("O usuário deve ser informado.\n");
		} else if (this.usuario.getId() == 0) {
			emsg.append("Usuário não cadastrado.\n");
		}
		if (exists() != 0) {
			emsg.append("Acesso a documento/interface já cadastrado.\n");
		}
		if (emsg.length() > 0) {
			throw new SQLException(emsg.toString());
		}
	}

	public void insert(int dias) throws SQLException {
		if (this.id == 0) {
			PreparedStatement pstm = null;
			ResultSet rset = null;
			int newId;
			try {
				util.consultas.Sequence sequence = new util.consultas.Sequence();
				newId = sequence.nextValue("acessos_documentos_interfaces", "acdi_id");
				validate();

				StringBuilder sb = new StringBuilder();
				sb.append(" INSERT INTO acessos_documentos_interfaces");
				sb.append("        ( acdi_id ");
				sb.append("        , acdi_doin_id ");
				sb.append("        , acdi_usua_id ");
				sb.append("        , acdi_favorito ");
				sb.append("        , acdi_dias_consulta_retroativa ) ");
				sb.append(" VALUES ( ?,?,?,?,?) ");

				pstm = conn.prepareStatement(sb.toString());
				pstm.setInt(1, newId);
				pstm.setInt(2, this.documentoInterface.getId());
				pstm.setInt(3, this.usuario.getId());
				if (isFavorito()) {
					pstm.setString(4, "S");
				} else {
					pstm.setString(4, "N");
				}
				if (dias == 0) {
					pstm.setString(5, "");
				} else {
					pstm.setInt(5, dias);
				}
				pstm.executeUpdate();
				pstm.close();
			} finally {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
			}
			select(newId);
		} else {
			throw new SQLException("Acesso a documento/interface já cadastrado.");
		}

	}

	public void select(int id) throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT /*+ all_rows */ ");
			sb.append("        acdi_id ");
			sb.append("      , acdi_doin_id ");
			sb.append("      , acdi_usua_id ");
			sb.append("      , acdi_favorito ");
			sb.append("      , acdi_dias_consulta_retroativa ");
			sb.append("   FROM acessos_documentos_interfaces ");
			sb.append("  WHERE acdi_id = ?");
			pstm = this.conn.prepareStatement(sb.toString());
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			if (rset.next()) {
				UsuarioAPI usua;
				DocumentoInterfaceAPI doin;
				this.id = rset.getInt(1);
				doin = new DocumentoInterfaceAPI(this.conn);
				doin.select(rset.getInt(2));
				this.documentoInterface = (DocumentoInterface) doin;
				usua = new UsuarioAPI(this.conn);
				usua.select(rset.getInt(3));
				this.usuario = (Usuario) usua;
				setFavorito(rset.getString(4).equals("S"));
				this.diasConsultaRetroativa = rset.getInt(5);
				pstm.close();
				this.old = (AcessoDocumentoInterface) this;
			} else {
				throw new SQLException("Usuário não cadastrado.");
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

	public void select(int usua_id, int doin_id) throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT /*+ all_rows */ ");
			sb.append("        acdi_id ");
			sb.append("      , acdi_doin_id ");
			sb.append("      , acdi_usua_id ");
			sb.append("      , acdi_favorito ");
			sb.append("      , acdi_dias_consulta_retroativa ");
			sb.append("   FROM acessos_documentos_interfaces ");
			sb.append("  WHERE acdi_usua_id = ? ");
			sb.append("    AND acdi_doin_id = ? ");
			pstm = this.conn.prepareStatement(sb.toString());
			pstm.setInt(1, usua_id);
			pstm.setInt(2, doin_id);
			rset = pstm.executeQuery();
			if (rset.next()) {
				UsuarioAPI usua;
				DocumentoInterfaceAPI doin;
				this.id = rset.getInt(1);
				doin = new DocumentoInterfaceAPI(this.conn);
				doin.select(rset.getInt(2));
				this.documentoInterface = (DocumentoInterface) doin;
				usua = new UsuarioAPI(this.conn);
				usua.select(rset.getInt(3));
				this.usuario = (Usuario) usua;
				setFavorito(rset.getString(4).equals("S"));
				this.diasConsultaRetroativa = rset.getInt(5);
				pstm.close();
				this.old = (AcessoDocumentoInterface) this;
			} else {
				throw new SQLException("Usuário não cadastrado.");
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
		if (this.old != null && this.id == this.old.id) {
			PreparedStatement pstm = null;
			try {
				validate();
				StringBuilder sb = new StringBuilder();
				sb.append(" UPDATE acessos_documentos_interfaces ");
				sb.append("    SET acdi_doin_id  = ? ");
				sb.append("      , acdi_usua_id  = ? ");
				sb.append("      , acdi_favorito = ? ");
				sb.append("      , acdi_dias_consulta_retroativa = ? ");
				sb.append("  WHERE acdi_id       = ? ");
				pstm = this.conn.prepareStatement(sb.toString());
				pstm.setInt(1, this.documentoInterface.getId());
				pstm.setInt(2, this.usuario.getId());
				if (isFavorito()) {
					pstm.setString(3, "S");
				} else {
					pstm.setString(3, "N");
				}
				if (this.diasConsultaRetroativa == 0) {
					pstm.setString(4, "");
				} else {
					pstm.setInt(4, this.diasConsultaRetroativa);
				}
				pstm.setInt(5, this.id);
				pstm.executeUpdate();
				select(this.id);
			} finally {
				if (pstm != null) {
					pstm.close();
				}
			}
		} else {
			throw new SQLException("Acesso a documento interface não cadastrado.");
		}
	}

	public void delete() throws SQLException {
		if (this.old != null && this.id == this.old.id) {
			PreparedStatement pstm = this.conn
					.prepareStatement(new StringBuilder(
							" DELETE acessos_documentos_interfaces ").append(
							"  WHERE acdi_id = ?").toString());
			pstm.setInt(1, this.id);
			pstm.executeUpdate();
			pstm.close();
			this.id = 0;
		} else {
			throw new SQLException("Acesso a documento interface não cadastrado.");
		}
	}

	public TreeMap<Integer, UsuarioAPI> getUsuariosAcessos(int doin_id)
			throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		TreeMap<Integer, UsuarioAPI> tmap = new TreeMap<Integer, UsuarioAPI>();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT /*+ all_rows */ ");
			sb.append("        acdi_usua_id ");
			sb.append("   FROM acessos_documentos_interfaces ");
			sb.append("  WHERE acdi_doin_id = ? ");
			pstm = this.conn.prepareStatement(sb.toString());
			pstm.setInt(1, doin_id);
			rset = pstm.executeQuery();
			while (rset.next()) {
				tmap.put(new Integer(rset.getInt(1)), new UsuarioAPI(this.conn,
						rset.getInt(1)));
			}
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		}
		return tmap;
	}

	public TreeMap<Integer, UsuarioAPI> getUsuariosAcessosTiposEntidadesNegocio(
			int doin_id) throws SQLException {
		TreeMap<Integer, UsuarioAPI> tmap = new TreeMap<Integer, UsuarioAPI>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT /*+ all_rows */ ");
			sb.append("        DISTINCT ");
			sb.append("        us.usua_id ");
			sb.append("      , aen.aten_dias_consulta_retroativa ");
			sb.append("   FROM acessos_tipos_entidade_negocio aen ");
			sb.append("      , entidades_negocio              en ");
			sb.append("      , usuarios                       us ");
			sb.append("  WHERE aen.aten_doin_id  = ? ");
			sb.append("    AND en.enne_tien_id   = aen.aten_tien_id ");
			sb.append("    AND us.usua_enne_id   = en.enne_id ");
			pstm = this.conn.prepareStatement(sb.toString());
			pstm.setInt(1, doin_id);
			rset = pstm.executeQuery();
			while (rset.next()) {
				tmap.put(new Integer(rset.getInt(1)), new UsuarioAPI(this.conn,
						rset.getInt(1), rset.getInt(2)));
			}
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		}

		return tmap;
	}

	public TreeMap<Integer, UsuarioAPI> getUsuariosAcessosEntidadesNegocio(
			int doin_id) throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		TreeMap<Integer, UsuarioAPI> tmap = new TreeMap<Integer, UsuarioAPI>();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT /*+ all_rows */ ");
			sb.append("        DISTINCT ");
			sb.append("        us.usua_id ");
			sb.append("      , aen.acen_dias_consulta_retroativa ");
			sb.append("   FROM acessos_entidades_negocio aen ");
			sb.append("      , usuarios 				 us ");
			sb.append("  WHERE aen.acen_doin_id = ? ");
			sb.append("    AND us.usua_enne_id  = aen.acen_enne_id");
			pstm = this.conn.prepareStatement(sb.toString());
			pstm.setInt(1, doin_id);
			rset = pstm.executeQuery();
			while (rset.next()) {
				tmap.put(new Integer(rset.getInt(1)), new UsuarioAPI(this.conn,
						rset.getInt(1), rset.getInt(2)));
			}
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		}
		return tmap;
	}

	public TreeMap<Integer, UsuarioAPI> getUsuariosAcessosUsuarios(int doin_id)
			throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		TreeMap<Integer, UsuarioAPI> tmap = new TreeMap<Integer, UsuarioAPI>();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT /*+ all_rows */ ");
			sb.append("        a.acus_usua_id ");
			sb.append("      , a.acus_dias_consulta_retroativa ");
			sb.append("   FROM acessos_usuarios a ");
			sb.append("  WHERE a.acus_doin_id      = ? ");
			sb.append("    AND a.acus_negar_acesso = 'N'");
			pstm = this.conn.prepareStatement(sb.toString());
			pstm.setInt(1, doin_id);
			rset = pstm.executeQuery();
			while (rset.next()) {
				tmap.put(new Integer(rset.getInt(1)), new UsuarioAPI(this.conn,
						rset.getInt(1), rset.getInt(2)));
			}
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		}
		return tmap;
	}

	public TreeMap<Integer, UsuarioAPI> getUsuariosAcessosNegadosUsuarios(
			int doin_id) throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		TreeMap<Integer, UsuarioAPI> tmap = new TreeMap<Integer, UsuarioAPI>();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT /*+ all_rows */ ");
			sb.append("        acus_usua_id ");
			sb.append("      , acus_dias_consulta_retroativa ");
			sb.append("   FROM acessos_usuarios ");
			sb.append("  WHERE acus_doin_id      = ? ");
			sb.append("    AND acus_negar_acesso = 'S' ");
			pstm = this.conn.prepareStatement(sb.toString());
			pstm.setInt(1, doin_id);
			rset = pstm.executeQuery();
			while (rset.next()) {
				tmap.put(new Integer(rset.getInt(1)), new UsuarioAPI(this.conn,
						rset.getInt(1)));
			}
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		}
		return tmap;
	}

	public void geraAutorizacoesUsuario(int usua_id) throws SQLException {
		int id = 0;
		util.consultas.Sequence sequence = new util.consultas.Sequence();
		// ---------------------- Usuário -----------------------
		PreparedStatement pstm;
		ResultSet rset;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT /*+ all_rows */ ");
		sb.append("        aus.acus_doin_id ");
		sb.append("      , aus.acus_dias_consulta_retroativa ");
		sb.append("      , aus.acus_negar_acesso ");
		sb.append("   FROM usuarios u ");
		sb.append("      , acessos_usuarios aus ");
		sb.append("  WHERE aus.acus_usua_id = u.usua_id ");
		sb.append("    AND u.usua_id        = ? ");
		pstm = this.conn.prepareStatement(sb.toString());
		pstm.setInt(1, usua_id);
		rset = pstm.executeQuery();
		while (rset.next()) {
			PreparedStatement pstm_verifica;
			ResultSet rset_verifica;
			StringBuilder sbi = new StringBuilder();
			sbi.append(" SELECT /*+ all_rows */ ");
			sbi.append("        acdi_id ");
			sbi.append("      , acdi_doin_id ");
			sbi.append("      , acdi_usua_id ");
			sbi.append("      , acdi_favorito ");
			sbi.append("      , acdi_dias_consulta_retroativa ");
			sbi.append("   FROM acessos_documentos_interfaces ");
			sbi.append("  WHERE acdi_usua_id       = ? ");
			sbi.append("    AND acdi_doin_id       = ? ");
			pstm_verifica = this.conn.prepareStatement(sbi.toString());
			pstm_verifica.setInt(1, usua_id);
			pstm_verifica.setInt(2, rset.getInt(1));
			rset_verifica = pstm_verifica.executeQuery();
			PreparedStatement pstm_atualiza;
			if (rset_verifica.next()) {
				pstm_atualiza = this.conn.prepareStatement(new StringBuilder(
						" update acessos_documentos_interfaces ")
						.append(" set acdi_dias_consulta_retroativa = ")
						.append(rset.getInt(2))
						.append("  where acdi_doin_id = ")
						.append(rset_verifica.getInt(2))
						.append("    and acdi_usua_id = ")
						.append(rset_verifica.getInt(3)).toString());
				pstm_atualiza.executeUpdate();
				pstm_atualiza.close();
			} else {
				id = sequence.nextValue("acessos_documentos_interfaces", "acdi_id");
				pstm_atualiza = this.conn.prepareStatement(new StringBuilder(
						" INSERT INTO acessos_documentos_interfaces ")
						.append(" VALUES ("+id)
						.append("        ,").append(rset.getInt(1))
						.append("        ,").append(usua_id)
						.append("        ,'N'").append("        ,")
						.append(rset.getInt(2)).append("        )").toString());
				pstm_atualiza.executeUpdate();
				pstm_atualiza.close();
			}
			rset_verifica.close();
			pstm_verifica.close();
		}
		rset.close();
		pstm.close();

		// ------------------ Entidade de Negócio ---------------------------
		PreparedStatement pstm_en;
		ResultSet rset_en;
		pstm_en = this.conn
				.prepareStatement(new StringBuilder(" SELECT /*+ all_rows */ aen.acen_doin_id ")
						.append("      , aen.acen_dias_consulta_retroativa ")
						.append("   FROM entidades_negocio e ")
						.append("      , usuarios u ")
						.append("      , acessos_entidades_negocio aen ")
						.append("  WHERE e.enne_id        = u.usua_enne_id ")
						.append("    AND aen.acen_enne_id = e.enne_id ")
						.append("    AND u.usua_id        = ? ")
						.append("    AND aen.acen_doin_id not in ")
						.append("              ( SELECT aus.acus_doin_id ")
						.append("    	     	     FROM usuarios us ")
						.append("                     , acessos_usuarios aus ")
						.append("                 WHERE aus.acus_usua_id  = us.usua_id ")
						.append("                   AND us.usua_id        = u.usua_id ) ")
						.toString());

		pstm_en.setInt(1, usua_id);
		rset_en = pstm_en.executeQuery();
		while (rset_en.next()) {
			PreparedStatement pstm_verifica;
			ResultSet rset_verifica;
			pstm_verifica = this.conn.prepareStatement(
					new StringBuilder(" SELECT /*+ all_rows */ acdi_id ")
							  .append("      , acdi_doin_id ")
							  .append("      , acdi_usua_id ")
							  .append("      , acdi_favorito ")
							  .append("      , acdi_dias_consulta_retroativa ")
							  .append("   FROM acessos_documentos_interfaces ")
							  .append("  WHERE acdi_usua_id       = ? ")
							  .append("    AND acdi_doin_id       = ? ").toString());
			pstm_verifica.setInt(1, usua_id);
			pstm_verifica.setInt(2, rset_en.getInt(1));
			rset_verifica = pstm_verifica.executeQuery();
			PreparedStatement pstm_atualiza;

			if (rset_verifica.next()) {
				pstm_atualiza = this.conn.prepareStatement(new StringBuilder(
						" UPDATE acessos_documentos_interfaces ")
						.append("    SET acdi_dias_consulta_retroativa = ")
						.append(rset_en.getInt(2))
						.append("  WHERE acdi_doin_id = ")
						.append(rset_verifica.getInt(2))
						.append("    AND acdi_usua_id = ")
						.append(rset_verifica.getInt(3)).toString());
				pstm_atualiza.executeUpdate();
				pstm_atualiza.close();
			} else {
				id = sequence.nextValue("acessos_documentos_interfaces", "acdi_id");
				pstm_atualiza = this.conn.prepareStatement(new StringBuilder(
						" INSERT INTO acessos_documentos_interfaces ")
						.append(" VALUES ("+id+", ")
						.append("         ").append(rset_en.getInt(1))
						.append(",").append("         ").append(usua_id)
						.append(",").append("         'N',")
						.append("         ").append(rset_en.getInt(2))
						.append(")").toString());
				pstm_atualiza.executeUpdate();
				pstm_atualiza.close();
			}
			rset_verifica.close();
			pstm_verifica.close();
		}
		rset_en.close();
		pstm_en.close();

		// ------------------ Tipo Entidade de Negócio
		// ---------------------------
		PreparedStatement pstm_tien;
		ResultSet rset_tien;
		pstm_tien = this.conn.prepareStatement(new StringBuilder(
				" SELECT /*+ all_rows */ aten.aten_doin_id ")
				.append("      , aten.aten_dias_consulta_retroativa ")
				.append("   FROM tipos_entidade_negocio tien ")
				.append("      , entidades_negocio e ")
				.append("      , usuarios u ")
				.append("      , acessos_tipos_entidade_negocio aten ")
				.append("  WHERE tien.tien_id      = e.enne_tien_id ")
				.append("    AND e.enne_id         = u.usua_enne_id ")
				.append("    AND aten.aten_tien_id = tien.tien_id ")
				.append("    AND u.usua_id         = ? ")
				.append("    AND aten.aten_doin_id not in ")
				.append("          ( SELECT aen.acen_doin_id ")
				.append("              FROM acessos_entidades_negocio aen ")
				.append("             WHERE aen.acen_enne_id = e.enne_id ")
				.append("             UNION ")
				.append("            SELECT aus.acus_doin_id ")
				.append("              FROM usuarios us ")
				.append("                 , acessos_usuarios aus ")
				.append("             WHERE aus.acus_usua_id  = us.usua_id ")
				.append("               AND us.usua_id        = u.usua_id ) ")
				.toString());

		pstm_tien.setInt(1, usua_id);
		rset_tien = pstm_tien.executeQuery();
		while (rset_tien.next()) {

			PreparedStatement pstm_verifica;
			ResultSet rset_verifica;
			pstm_verifica = this.conn.prepareStatement(new StringBuilder(
					" SELECT /*+ all_rows */ acdi_id ").append("      , acdi_doin_id ")
					.append("      , acdi_usua_id ")
					.append("      , acdi_favorito ")
					.append("      , acdi_dias_consulta_retroativa ")
					.append("   FROM acessos_documentos_interfaces ")
					.append("  WHERE acdi_usua_id       = ? ")
					.append("    AND acdi_doin_id       = ? ").toString());
			pstm_verifica.setInt(1, usua_id);
			pstm_verifica.setInt(2, rset_tien.getInt(1));
			rset_verifica = pstm_verifica.executeQuery();
			PreparedStatement pstm_atualiza2;
			if (rset_verifica.next()) {
				pstm_atualiza2 = this.conn.prepareStatement(new StringBuilder(
						" UPDATE acessos_documentos_interfaces ")
						.append("    SET acdi_dias_consulta_retroativa = ")
						.append(rset_tien.getInt(2))
						.append("  WHERE acdi_doin_id = ")
						.append(rset_verifica.getInt(2))
						.append("    AND acdi_usua_id = ")
						.append(rset_verifica.getInt(3)).toString());
				pstm_atualiza2.executeUpdate();
				pstm_atualiza2.close();
			} else {
				id = sequence.nextValue("acessos_documentos_interfaces", "acdi_id");
				pstm_atualiza2 = this.conn.prepareStatement(new StringBuilder(
						" INSERT INTO acessos_documentos_interfaces ")
						.append(" VALUES ("+id+", ")
						.append("         ").append(rset_tien.getInt(1))
						.append(",").append("         ").append(usua_id)
						.append(",").append("         'N',")
						.append("         ").append(rset_tien.getInt(2))
						.append("         ) ").toString());
				pstm_atualiza2.executeUpdate();
				pstm_atualiza2.close();

			}
			rset_verifica.close();
			pstm_verifica.close();
		}
		rset_tien.close();
		pstm_tien.close();

		// ----------------------- Apagar ----------------------------
		PreparedStatement pstm_apagar;
		ResultSet rset_apagar;
		pstm_apagar = this.conn.prepareStatement(new StringBuilder(
				" SELECT /*+ all_rows */ au.acus_doin_id ")
				.append("      , au.acus_dias_consulta_retroativa ")
				.append("      , au.acus_negar_acesso ")
				.append("   FROM usuarios u ")
				.append("      , acessos_usuarios au ")
				.append("  WHERE au.acus_usua_id      = u.usua_id ")
				.append("    AND u.usua_id            = ? ")
				.append("    AND au.acus_negar_acesso = 'S' ").toString());

		pstm_apagar.setInt(1, usua_id);
		rset_apagar = pstm_apagar.executeQuery();
		while (rset_apagar.next()) {
			PreparedStatement pstm_verifica;
			ResultSet rset_verifica;
			pstm_verifica = this.conn.prepareStatement(new StringBuilder(
					" SELECT /*+ all_rows */ acdi_id ").append("      , acdi_doin_id ")
					.append("      , acdi_usua_id ")
					.append("      , acdi_favorito ")
					.append("      , acdi_dias_consulta_retroativa ")
					.append("   FROM acessos_documentos_interfaces ")
					.append("  WHERE acdi_usua_id       = ? ")
					.append("    AND acdi_doin_id       = ? ").toString());
			pstm_verifica.setInt(1, usua_id);
			pstm_verifica.setInt(2, rset_apagar.getInt(1));
			rset_verifica = pstm_verifica.executeQuery();
			PreparedStatement pstm_atualiza;
			if (rset_verifica.next()) {
				pstm_atualiza = this.conn.prepareStatement(new StringBuilder(
						" DELETE FROM acessos_documentos_interfaces ")
						.append("  WHERE acdi_doin_id = ")
						.append(rset_verifica.getInt(2))
						.append("    AND acdi_usua_id = ")
						.append(rset_verifica.getInt(3)).toString());
				pstm_atualiza.executeUpdate();
				pstm_atualiza.close();
			}
			rset_verifica.close();
			pstm_verifica.close();
		}
		rset_apagar.close();
		pstm_apagar.close();
	}

	public void geraAutorizacoes(int doin_id) throws SQLException {
		TreeMap<Integer, UsuarioAPI> tmap_old = new TreeMap<Integer, UsuarioAPI>();
		TreeMap<Integer, UsuarioAPI> tmap_new = new TreeMap<Integer, UsuarioAPI>();
		AcessoDocumentoInterfaceAPI acdi;
		tmap_new.putAll(getUsuariosAcessosTiposEntidadesNegocio(doin_id));
		tmap_new.putAll(getUsuariosAcessosEntidadesNegocio(doin_id));
		tmap_new.putAll(getUsuariosAcessosUsuarios(doin_id));
		tmap_old.putAll(getUsuariosAcessosNegadosUsuarios(doin_id));

		if (!tmap_old.isEmpty()) {
			int acdi_id;
			acdi = new AcessoDocumentoInterfaceAPI(this.conn);
			for (UsuarioAPI usua : tmap_old.values()) {
				tmap_new.remove(new Integer(usua.getId()));
				acdi.setDocumentoInterface(new DocumentoInterfaceAPI(this.conn,
						doin_id));
				acdi.setUsuario(usua);
				acdi_id = acdi.exists();
				if (acdi_id != 0) {
					acdi.select(acdi_id);
					acdi.delete();
				}
			}
			tmap_old.clear();
		}
		tmap_old.putAll(getUsuariosAcessos(doin_id));

		if (!tmap_new.isEmpty()) {
			for (UsuarioAPI usua : tmap_new.values()) {
				if (tmap_old.containsKey(new Integer(usua.getId()))) {
					AcessoDocumentoInterfaceAPI p = new AcessoDocumentoInterfaceAPI(
							this.conn);
					p.setDocumentoInterface(new DocumentoInterfaceAPI(
							this.conn, doin_id));
					p.setUsuario(usua);
					p.select(usua.getId(), doin_id);
					if ((!(p.getDiasConsultaRetroativa().equals(usua
							.getDiasConsultaRetroativa())))) {
						p.setDiasConsultaRetroativa(usua
								.getDiasConsultaRetroativa());
						PreparedStatement pstm;
						pstm = this.conn
								.prepareStatement(new StringBuilder(
										" UPDATE acessos_documentos_interfaces ")
										.append("    SET acdi_dias_consulta_retroativa = ? ")
										.append("  WHERE acdi_usua_id = ? ")
										.append("    AND acdi_doin_id = ? ")
										.toString());
						pstm.setInt(1, usua.getDiasConsultaRetroativa());
						pstm.setInt(2, usua.getId());
						pstm.setInt(3, doin_id);
						pstm.executeUpdate();
						pstm.close();
					}
					tmap_old.remove(new Integer(usua.getId()));
				} else {
					acdi = new AcessoDocumentoInterfaceAPI(this.conn);
					acdi.setDocumentoInterface(new DocumentoInterfaceAPI(
							this.conn, doin_id));
					acdi.setUsuario(usua);
					acdi.insert(usua.getDiasConsultaRetroativa());
				}
			}
		}

		if (!tmap_old.isEmpty()) {
			int acdi_id;
			acdi = new AcessoDocumentoInterfaceAPI(this.conn);
			for (UsuarioAPI usua : tmap_old.values()) {
				acdi.setDocumentoInterface(new DocumentoInterfaceAPI(this.conn,
						doin_id));
				acdi.setUsuario(usua);
				acdi_id = acdi.exists();
				if (acdi_id != 0) {
					acdi.select(acdi_id);
					acdi.delete();
				}
			}
		}
	}

}

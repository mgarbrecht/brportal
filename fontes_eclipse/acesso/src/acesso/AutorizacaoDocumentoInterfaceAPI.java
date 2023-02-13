package acesso;
import java.sql.*;
import util.consultas.*;

public class AutorizacaoDocumentoInterfaceAPI extends AutorizacaoDocumentoInterface {

	private Connection conn;
	private AutorizacaoDocumentoInterface old;
  
	public AutorizacaoDocumentoInterfaceAPI(Connection conn) {
		this.conn = conn;
	}

	public AutorizacaoDocumentoInterfaceAPI(Connection conn, ClassificadorAcesso tipo,
			int id) throws SQLException {
		this(conn);
		select(tipo, id);
	}

	private void instanciaTipoEntidadeNegocio(int id) throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT /*+ all_rows */ aten_tien_id ");
			sb.append("      , aten_doin_id ");
			sb.append("      , nvl(aten_dias_consulta_retroativa,0) ");
			sb.append("   FROM acessos_tipos_entidade_negocio ");
			sb.append("  WHERE aten_id = ?");	  
			pstm = this.conn.prepareStatement(sb.toString());
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			if (rset.next()) {
				setDocumentoInterface((DocumentoInterface) new DocumentoInterfaceAPI(
				 	  this.conn, rset.getInt(2)));
				autorizarUsuario();
				setTipoEntidadeNegocio((TipoEntidadeNegocio) new TipoEntidadeNegocioAPI(
					  this.conn, rset.getInt(1)));
				setDiasConsultaRetroativa(rset.getInt(3));
				pstm.close();
				this.id = id;
			} else {
				pstm.close();
				throw new SQLException("Autorização não cadastrada.");
			}			
		} finally {
			if(rset!=null){
				rset.close();
			}
			if(pstm!=null){
				pstm.close();
			}
		}
	}

	private void instanciaEntidadeNegocio(int id) throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT /*+ all_rows */ acen_enne_id ");
			sb.append("      , acen_doin_id ");
			sb.append("      , nvl(acen_dias_consulta_retroativa,0) ");
			sb.append("   FROM acessos_entidades_negocio ");
			sb.append("  WHERE acen_id = ?");    
			pstm = this.conn.prepareStatement(sb.toString());
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			if (rset.next()) {
				setDocumentoInterface((DocumentoInterface) new DocumentoInterfaceAPI(
						this.conn, rset.getInt(2)));
				setEntidadeNegocio((EntidadeNegocio) new EntidadeNegocioAPI(this.conn,
						rset.getInt(1)));
				setDiasConsultaRetroativa(rset.getInt(3));
				autorizarUsuario();
				pstm.close();
				this.id = id;
			} else {
				pstm.close();
				throw new SQLException("Autorização não cadastrada.");
			}			
		} finally {
			if(rset!=null){
				rset.close();
			}
			if(pstm!=null){
				pstm.close();
			}
		}
	}

	private void instanciaUsuario(int id) throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT /*+ all_rows */ acus_usua_id ");
			sb.append("      , acus_doin_id ");
			sb.append("      , acus_negar_acesso ");
			sb.append("      , nvl(acus_dias_consulta_retroativa,0) ");
			sb.append("   FROM acessos_usuarios ");
			sb.append("  WHERE acus_id = ?");    
			pstm = this.conn.prepareStatement(sb.toString());
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			if (rset.next()) {
				setDocumentoInterface((DocumentoInterface) new DocumentoInterfaceAPI(
						this.conn, rset.getInt(2)));
				this.id = id;
				if (rset.getString(3).equalsIgnoreCase("S")){
					revogarUsuario();
				} else {
					autorizarUsuario();
				}
				setDiasConsultaRetroativa(rset.getInt(4));
				setUsuario((Usuario) new UsuarioAPI(this.conn, rset.getInt(1)));
				pstm.close();
			} else {
				pstm.close();
				throw new SQLException("Autorização não cadastrada.");
			}			
		} finally {
			if(rset!=null){
				rset.close();
			}
			if(pstm!=null){
				pstm.close();
			}
		}
	}

	public void select(ClassificadorAcesso tipo, int id) throws SQLException {
		if (tipo == ClassificadorAcesso.TIPO_ENTIDADE_NEGOCIO) {
			instanciaTipoEntidadeNegocio(id);    	
		}
		else if (tipo == ClassificadorAcesso.ENTIDADE_NEGOCIO) {
			instanciaEntidadeNegocio(id);    	
		}
		else if (tipo == ClassificadorAcesso.USUARIO) {
			instanciaUsuario(id);    	
		}
		this.old = (AutorizacaoDocumentoInterface) this;
	}

	public void insert() throws SQLException {
		Sequence sequence = new Sequence();
		if (this.id == 0) {
			PreparedStatement pstm;
			pstm = null;
			int newId = 0;
			validate();
			if (isClassificadorAcesso(ClassificadorAcesso.TIPO_ENTIDADE_NEGOCIO)) {
				newId = sequence.nextValue("acessos_tipos_entidade_negocio", "aten_id");
				StringBuilder sb = new StringBuilder();
				sb.append(" INSERT INTO acessos_tipos_entidade_negocio ");
				sb.append("        ( aten_id ");
				sb.append("        , aten_tien_id ");
				sb.append("        , aten_doin_id ");
				sb.append("        , aten_dias_consulta_retroativa ) ");
				sb.append(" VALUES ( ?, ?, ?, ?)");        
				pstm = this.conn.prepareStatement(sb.toString());
				pstm.setInt(2, getTipoEntidadeNegocio().getId());
				if(getDiasConsultaRetroativa()==null){
					pstm.setString(4, "");        	
				} else if(getDiasConsultaRetroativa()==0){	
					pstm.setString(4, "");
				} else {
					pstm.setInt(4, getDiasConsultaRetroativa());        	
				}
			}
			else if (isClassificadorAcesso(ClassificadorAcesso.ENTIDADE_NEGOCIO)) {    	
				newId = sequence.nextValue("acessos_entidades_negocio", "acen_id");
				StringBuilder sb = new StringBuilder();
				sb.append(" INSERT INTO acessos_entidades_negocio ");
				sb.append("        ( acen_id ");
				sb.append("        , acen_enne_id ");
				sb.append("        , acen_doin_id ");
				sb.append("        , acen_dias_consulta_retroativa ) "); 
				sb.append(" VALUES ( ?, ?, ?, ? )");        
				pstm = this.conn.prepareStatement(sb.toString());
				pstm.setInt(2, getEntidadeNegocio().getId());
				if(getDiasConsultaRetroativa()==null){
					pstm.setString(4, "");        	
				} else if(getDiasConsultaRetroativa()==0){	
					pstm.setString(4, "");
				} else {
					pstm.setInt(4, getDiasConsultaRetroativa());        	
				}
			}
			
			else if (isClassificadorAcesso(ClassificadorAcesso.USUARIO)) {  
				newId = sequence.nextValue("acessos_usuarios", "acus_id");
				StringBuilder sb = new StringBuilder();
				sb.append(" INSERT INTO acessos_usuarios ");
				sb.append("        ( acus_id ");
				sb.append("        , acus_usua_id ");
				sb.append("        , acus_doin_id ");
				sb.append("        , acus_negar_acesso ");
				sb.append("        , acus_dias_consulta_retroativa ");
				sb.append("        ) ");
				sb.append(" VALUES (?, ?, ?, ?, ? )");
				pstm = this.conn.prepareStatement(sb.toString());
				pstm.setInt(2, getUsuario().getId());
				pstm.setString(4, isUsuarioAutorizado() ? "N" : "S");
				if(getDiasConsultaRetroativa()==null){
					pstm.setString(5, "");        	
				}
				else if(getDiasConsultaRetroativa()==0){	
					pstm.setString(5, "");
				} else {
					pstm.setInt(5, getDiasConsultaRetroativa());        	
				}
			}

			pstm.setInt(1, newId);
			pstm.setInt(3, getDocumentoInterface().getId());
			pstm.executeUpdate();
			pstm.close();
			select(getClassificadorAcesso(), newId);
		}
		else {
			throw new SQLException("Autorização já cadastrada.");
		}
	}

  /* Update desabilitado temporariamente.
  public void update() throws SQLException {
    if (this.old != null && this.id == this.old.id) {
      PreparedStatement pstm;
      validate();
      if (isClassificadorAcesso(ClassificadorAcesso.TIPO_ENTIDADE_NEGOCIO)) {
        pstm = this.conn.prepareStatement(
              " update acessos_tipos_entidade_negocio "
            + "    set aten_tien_id = ? "
            + "      , aten_doin_id = ? "
            + "  where aten_id = ?");
        pstm.setInt(1, getTipoEntidadeNegocio().getId());
        pstm.setInt(3, this.id);
      }
      else if (isClassificadorAcesso(ClassificadorAcesso.ENTIDADE_NEGOCIO)) {
        pstm = this.conn.prepareStatement(
              " update acessos_entidades_negocio "
            + "    set acen_enne_id = ? "
            + "      , acen_doin_id = ? "
            + "  where acen_id = ?");
        pstm.setInt(1, getEntidadeNegocio().getId());
        pstm.setInt(3, this.id);
      }
      else { // if (isClassificadorAcesso(Classificador.USUARIO)) {
        pstm = this.conn.prepareStatement(
              " update acessos_usuarios  "
            + "     set acus_usua_id = ? "
            + "       , acus_doin_id = ? "
            + "       , acus_negar_acesso = ? "
            + "   where acus_id = ?");
        pstm.setInt(1, getUsuario().getId());
        pstm.setString(3, isUsuarioAutorizado() ? "N" : "S");
        pstm.setInt(4, this.id);
      }
      pstm.setInt(2, getDocumentoInterface().getId());
      pstm.executeUpdate();
      pstm.close();
      select(getClassificadorAcesso(), this.id);
    }
    else
      throw new SQLException("Autorização não cadastrada.");
  }
  */

	public void delete() throws SQLException {
		if (this.old != null && this.id == this.old.id) {
			PreparedStatement pstm = null;
			try {
				StringBuilder sb = new StringBuilder();
				if (isClassificadorAcesso(ClassificadorAcesso.TIPO_ENTIDADE_NEGOCIO)) {
					sb.append(" DELETE FROM acessos_tipos_entidade_negocio ");
					sb.append("  WHERE aten_id = ?");
					pstm = this.conn.prepareStatement(sb.toString());
				} else if (isClassificadorAcesso(ClassificadorAcesso.ENTIDADE_NEGOCIO)) {
					sb.append(" DELETE FROM acessos_entidades_negocio ");
					sb.append("  WHERE acen_id = ?");
					pstm = this.conn.prepareStatement(sb.toString());
				} else {
					sb.append(" DELETE FROM acessos_usuarios ");
					sb.append("  WHERE acus_id = ?");
					pstm = this.conn.prepareStatement(sb.toString());
				}
				pstm.setInt(1,this.id);
				pstm.execute();
				this.id = 0;
			} finally {
				if(pstm!=null){
					pstm.close();
				}
			}
		} else {
			throw new SQLException("Autorização não cadastrada.");    	
		}
	}

	public void validate() throws SQLException {
		StringBuilder emsg = new StringBuilder();
		if (getDocumentoInterface() == null) {
			emsg.append("Nenhum documento/interface foi informado.");
		}
		if (getClassificadorAcesso() == null) {
			emsg.append("Classificador de acesso indefinido.");
		}
		if (emsg.length() != 0) {
			throw new SQLException(emsg.toString());    	
		}
	}
}
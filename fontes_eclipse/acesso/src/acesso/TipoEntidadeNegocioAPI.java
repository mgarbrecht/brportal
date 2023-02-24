package acesso;

import java.sql.*;
import util.consultas.*;
import java.util.*;
 
public class TipoEntidadeNegocioAPI extends TipoEntidadeNegocio {

	private Connection conn;
	private ArrayList<EntidadeNegocioAPI> entidades;
	private TipoEntidadeNegocio old;
	  
	public TipoEntidadeNegocioAPI(Connection conn) {
		this.conn = conn;
	}

	public TipoEntidadeNegocioAPI(Connection conn, int id) throws SQLException {
		this(conn);
		select(id);
	}

	public ArrayList<EntidadeNegocioAPI> getEntidadesNegocio() throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			if (this.entidades == null) {
				this.entidades = new ArrayList<EntidadeNegocioAPI>();
				StringBuilder sb = new StringBuilder();
				sb.append(" SELECT /*+ all_rows */ ");
				sb.append("        DISTINCT ");
				sb.append("        enne_id ");
				sb.append("   FROM entidades_negocio e ");
				sb.append("      , usuarios u ");
				sb.append("  WHERE enne_tien_id  = ? ");
				sb.append("    AND e.enne_id     = u.usua_enne_id (+) ");
				sb.append("    and e.enne_id > 500 ");
				sb.append("    AND u.situacao    = 'A' ");      
				pstm = this.conn.prepareStatement(sb.toString());
				pstm.setInt(1, this.id);
				rset = pstm.executeQuery();
				while (rset.next()) {
					this.entidades.add(new EntidadeNegocioAPI(this.conn, rset.getInt(1)));
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
		return this.entidades;
	}

	
	public String getSQL() throws SQLException {
		StringBuilder sql;
		if (this.id == 0)
			throw new SQLException("Tipo de entidade não cadastrado.");
		else {
			validate();
			sql = new StringBuilder();
			sql.append(" SELECT ");
			sql.append(this.camposDescr.replace(",", "||','||"));
			sql.append(" descricao,");
			sql.append(this.camposChave.replace(",", "||','||"));
			sql.append(" chave from ");
			sql.append(this.tabela);
			if (this.condicao != null && !this.condicao.trim().equals("")) {
				sql.append(" where ");
				sql.append(this.condicao);
			}
		}
		return sql.toString();
	}

	public void setTipo(String tipo) {
		super.setTipo(tipo.trim().toUpperCase());
	}
	
	private void validate() throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			StringBuilder emsg = new StringBuilder();
			if (tipo.equals("")){
				emsg.append("O tipo deve ser informado.\n");
			} else if (tipo.length() > 40) {
				emsg.append("O tipo possui mais de 40 caracteres.\n");
			}
			if (tabela.equals("")){
				emsg.append("A tabela deve ser informada.\n");			
			} else if (tabela.length() > 30) {
				emsg.append("A tabela possui mais de 30 caracteres.\n");			
			}			
			if (camposDescr.equals("")) {
				emsg.append("Nenhum campo para a descrição foi informado.\n");
			} else if (camposDescr.length() > 255) {
				emsg.append("Os campos para a descrição possuem mais de 255 caracteres.\n");			
			}
			if (camposChave.equals("")) {
				emsg.append("Nenhum campo para a chave foi informado.\n");			
			} else if (camposChave.length() > 255) {
				emsg.append("Os campos para a chave possuem mais de 255 caracteres.\n");			
			}
			if (condicao != null && condicao.length() > 255) {
				emsg.append("A condição possui mais de 255 caracteres.\n");			
			}
				
			pstm = conn.prepareStatement(
					new StringBuilder(" SELECT /*+ all_rows */ tien_id ")
						      .append("   FROM tipos_entidade_negocio ")
	                          .append("  WHERE tien_tipo = ? ")
	                          .append("    AND tien_id  != ? ").toString());
			pstm.setString(1, tipo);
			pstm.setInt(2, id);
			rset = pstm.executeQuery();
			if (rset.next()){
				emsg.append("Tipo de entidade de negócio já cadastrado.\n");    	
			}
			rset.close();
			pstm.close();
			if (old != null) {
				if (!old.tabela.equals(tabela) || !old.camposChave.equals(camposChave)) {
					pstm = conn.prepareStatement(
							new StringBuilder(" SELECT id ")
	                                  .append("   FROM entidades_negocio ")
	                                  .append("  WHERE enne_tien_id = ?").toString());
					pstm.setInt(1, id);
					rset = pstm.executeQuery();
					if (rset.next()){
						emsg.append("A tabela ou os campos chave não podem ser alterados ");
						emsg.append("em um tipo referenciado por entidades de negócio.\n");
					}
				}
			}
			if (emsg.length() > 0){
				throw new SQLException(emsg.toString());			
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

	
  public void insert() throws SQLException {
	  Sequence sequence = new Sequence();
	  PreparedStatement pstm = null;
	  ResultSet rset = null;
	  try {
		  if (this.id == 0) {
			  int newId;
			  validate();
			  newId = sequence.nextValue("tipos_entidade_negocio", "tien_id");
			  StringBuilder sb = new StringBuilder();
			  sb.append(" INSERT INTO ");
			  sb.append("        tipos_entidade_negocio ");
			  sb.append("        ( tien_id ");
			  sb.append("        , tien_tipo ");
			  sb.append("        , tien_tabela ");
			  sb.append("        , tien_campos_descr ");
			  sb.append("        , tien_campos_chave ");
			  sb.append("        , tien_condicional ");
			  sb.append("        , tien_dias_consulta_retroativa ) ");
			  sb.append(" VALUES (?, ?, ?, ?, ?, ?, ?)");
			  pstm = this.conn.prepareStatement(sb.toString());
			  pstm.setInt(1, newId);
			  pstm.setString(2, this.tipo);
			  pstm.setString(3, this.tabela);
			  pstm.setString(4, this.camposDescr);
			  pstm.setString(5, this.camposChave);
			  pstm.setString(6, this.condicao);
			  pstm.setInt(7, this.diasConsultaRetroativa);
			  pstm.executeUpdate();
			  pstm.close();
			  select(newId);
		  } else {
			  throw new SQLException("Tipo de entidade de negócio cadastrado.");		  
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

  
  	public void select(int id) throws SQLException {
  		PreparedStatement pstm = null;
  		ResultSet rset = null;
  		try {
  			
  	  		StringBuilder sb = new StringBuilder();
  	  		sb.append(" SELECT /*+ all_rows */ tien_id            ");
  	  		sb.append("      , tien_tipo          ");
  	  		sb.append("      , tien_tabela        ");
  	  		sb.append("      , tien_campos_descr  ");
  	  		sb.append("      , tien_campos_chave  ");
  	  		sb.append("      , tien_condicional   ");
  	  		sb.append("      , tien_dias_consulta_retroativa ");
  	  		sb.append("   FROM tipos_entidade_negocio ");
  	  		sb.append("  WHERE tien_id = ? ");	
  	  		pstm = this.conn.prepareStatement(sb.toString());
  	  		pstm.setInt(1, id);
  	  		rset = pstm.executeQuery();
  	  		if (rset.next()) {
  	  			this.id = rset.getInt(1);
  	  			this.tipo = rset.getString(2);
  	  			this.tabela = rset.getString(3);
  	  			this.camposDescr = rset.getString(4);
  	  			this.camposChave = rset.getString(5);
  	  			this.condicao = rset.getString(6);
  	  			this.diasConsultaRetroativa = rset.getInt(7);
  	  			rset.close();
  	  			pstm.close();
  	  			this.old = (TipoEntidadeNegocio) this;
  	  		} else {
  	  			throw new SQLException("Tipo de entidade de negócio não cadastrado.");
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
  	  		validate();
  	  		if (this.old != null && this.id == this.old.id) {
  	  			StringBuilder sb = new StringBuilder();
  	  			sb.append(" UPDATE tipos_entidade_negocio ");
  	  			sb.append("    SET tien_tipo         = ?  ");
  	  			sb.append("      , tien_tabela       = ?  ");
  	  			sb.append("      , tien_campos_descr = ?  ");
  	  			sb.append("      , tien_campos_chave = ?  ");
  	  			sb.append("      , tien_condicional  = ?  ");
  	  			sb.append("      , tien_dias_consulta_retroativa = ? ");
  	  			sb.append("  WHERE tien_id = ?");
  	  			pstm = this.conn.prepareStatement(sb.toString());
  	  			pstm.setString(1, this.tipo);
  	  			pstm.setString(2, this.tabela);
  	  			pstm.setString(3, this.camposDescr);
  	  			pstm.setString(4, this.camposChave);
  	  			pstm.setString(5, this.condicao);
  	  			pstm.setInt(6, this.diasConsultaRetroativa);
  	  			pstm.setInt(7, this.id);
  	  			pstm.executeUpdate();
  	  			pstm.close();
  	  			select(this.id);
  	  		}
  	  		else {
  	  			throw new SQLException("Tipo de entidade de negócio não cadastrado.");  			
  	  		}  			
  		} finally {
  			if(pstm!=null){
  				pstm.close();
  			}
  		}
  	}

  	public void delete() throws SQLException {
  		PreparedStatement pstm = null;
  		ResultSet rset = null;
  		try {
  	  		if (this.old != null && this.id == this.old.id) {
  	  			pstm = this.conn.prepareStatement(
  	  					new StringBuilder(" SELECT /*+ all_rows */ enne_id ")
  	  							  .append("   FROM entidades_negocio ")
  	  							  .append("  WHERE enne_tien_id = ? ").toString());
  	  			pstm.setInt(1, this.id);
  	  			rset = pstm.executeQuery();
  	  			if (rset.next()) {
  	  				rset.close();
  	  				throw new SQLException("Não é permitido excluir um tipo referenciado por uma ou mais entidades de negócio.");
  	  			}
  	  			pstm.close();
  	  			pstm = this.conn.prepareStatement(
  	  					new StringBuilder(" DELETE FROM from tipos_entidade_negocio ")
  	  						      .append("  WHERE tien_id = ?").toString());
  	  			pstm.setInt(1, this.id);
  	  			pstm.executeUpdate();
  	  			pstm.close();
  	  			this.id = 0;
  	  		} else {
  	  			throw new SQLException("Tipo de entidade de negócio não cadastrado.");  			
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
}


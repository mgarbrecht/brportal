package acesso;
import java.sql.*;
import util.consultas.*;
import java.util.*;

public class EntidadeNegocioAPI extends EntidadeNegocio {

  private Connection conn;
  private ArrayList<UsuarioAPI> usuarios;
  private EntidadeNegocio old;
  
  public EntidadeNegocioAPI(Connection conn) {
	  this.conn = conn;
  }

  public EntidadeNegocioAPI(Connection conn, int id) throws SQLException {
	  this(conn);
	  select(id);
  }

  public void setDescricao(String descricao) {
	  super.setDescricao(descricao.trim().toUpperCase().replace("'", "´"));
  }

  private void validate() throws SQLException {
	  StringBuilder emsg = new StringBuilder();
	  PreparedStatement pstm = null;
	  ResultSet rset = null;
	  try {
		  if (this.chave == null || this.chave.equals("")) {
			  emsg.append("A chave da entidade deve ser informada.\n");
		  } else if (this.chave.length() > 255) {
			  emsg.append("A chave da entidade possui mais de 255 caracteres.\n");
		  } if (this.tien == null) {
			  emsg.append("O tipo da entidade deve ser informado.\n");
		  } else {
			  
			  if (this.tien.getId() == 0) {
				  emsg.append("Tipo de entidade não cadastrado.\n");
			  }
			  else if (this.old != null && this.tien.getId() != this.old.tien.getId()) {
				  emsg.append("Não é permitido alterar o tipo da entidade de negocio.\n");			  
			  }
			  else if (this.chave != null && ! this.chave.equals("") &&
	     		      (this.descricao == null || this.descricao.equals(""))) {
				  try {
					  TipoEntidadeNegocioAPI tienAPI = new TipoEntidadeNegocioAPI(this.conn, this.tien.getId());
					  pstm = this.conn.prepareStatement(new StringBuilder(" select descricao from (").append(tienAPI.getSQL()).append(") where chave = ?").toString());
					  pstm.setString(1, this.chave);
					  rset = pstm.executeQuery();
					  if (rset.next()) {
						  this.descricao = rset.getString(1);  
					  } else {
						  emsg.append("Chave inválida para este tipo de entidade.\n");
					  }
					  pstm.close();
				  }
			      catch (SQLException e) {
				      emsg.append(e.getMessage() + "\n");
			      }
			  } else {
				  if (this.descricao == null || this.descricao.equals("")) {
					  emsg.append("A descrição da entidade deve ser informada.\n");
				  } else if (this.descricao.length() > 255) {
					  emsg.append("A descrição da entidade possui mais de 255 caracteres.\n");
				  } else {
					  StringBuilder sb = new StringBuilder();
					  sb.append(" SELECT /*+ all_rows */ enne_id ");
					  sb.append("   FROM entidades_negocio  ");
					  sb.append("  WHERE enne_descricao = ? ");
					  sb.append("    AND enne_id       != ? ");		  
					  pstm = this.conn.prepareStatement(sb.toString());
					  pstm.setString(1, this.descricao);
					  pstm.setInt(2, this.id);
					  rset = pstm.executeQuery();
					  if (rset.next()) {
						  emsg.append("Entidade de negócio ");
						  emsg.append(this.descricao);
						  emsg.append(" já cadastrada.\n");
					  }
					  pstm.close();
				  }			  
			  }
		  }	  
		  
		  if (emsg.length() > 0) {
			  throw new SQLException(emsg.toString());
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
	  Sequence sequence = new Sequence();
	  PreparedStatement pstm = null;
      ResultSet rset = null;
	  try {
		  if (this.id == 0) {
		      int newId;
		      validate();
              newId = sequence.nextValue("entidades_negocio", "enne_id");
		      //pstm = this.conn.prepareStatement(
		    	//	" SELECT entidades_negocio_seq.nextval FROM sys.dual");
		      //rset = pstm.executeQuery();
		      //rset.next();
		      //newId = rset.getInt(1);
		      //pstm.close();
		      StringBuilder sb = new StringBuilder();
			  sb.append(" INSERT INTO entidades_negocio ");
			  sb.append("        ( enne_id              ");
			  sb.append("        , enne_descricao       ");
		      sb.append("        , enne_chave           ");
		      sb.append("        , enne_tien_id )       ");
		      sb.append(" VALUES ( ?, ?, ?, ? )");
		      pstm = this.conn.prepareStatement(sb.toString());
		      pstm.setInt(1, newId);
		      pstm.setString(2, this.descricao);
		      pstm.setString(3, this.chave);
		      pstm.setInt(4, this.tien.getId());
		      pstm.executeUpdate();
		      pstm.close();
		      select(newId);
		    }
		    else {
		    	throw new SQLException("Entidade de negócio já cadastrada.");    	
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
		  sb.append(" SELECT /*+ all_rows */ enne_id           ");
		  sb.append("      , fct_remov_carac_espec(enne_descricao) enne_descricao    ");
		  sb.append("      , enne_chave        ");
		  sb.append("      , enne_tien_id      ");
		  sb.append("   FROM entidades_negocio ");
		  sb.append("  WHERE enne_id = ? ");	
		  pstm = this.conn.prepareStatement(sb.toString());
		  pstm.setInt(1, id);
		  rset = pstm.executeQuery();
		  if (rset.next()) {
			  this.id = rset.getInt(1);
			  this.descricao = rset.getString(2);
			  this.chave = rset.getString(3);
			  TipoEntidadeNegocioAPI tipo = new TipoEntidadeNegocioAPI(conn);
			  tipo.select(rset.getInt(4));
			  this.tien = (TipoEntidadeNegocio) tipo;
			  this.old = (EntidadeNegocio) this;
		  } else {
			  throw new SQLException("Entidade de negócio não cadastrada.");
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
		  if (this.old != null && this.id == this.old.id) {
			  validate();
			  StringBuilder sb = new StringBuilder();
			  sb.append(" UPDATE entidades_negocio    ");
			  sb.append("    SET enne_descricao  = ?  ");
			  sb.append("      , enne_chave      = ?  ");
			  sb.append("      , enne_tien_id    = ?  ");
			  sb.append("  WHERE enne_id         = ?  ");      
			  pstm = this.conn.prepareStatement(sb.toString());
			  pstm.setString(1, this.descricao);
			  pstm.setString(2, this.chave);
			  pstm.setInt(3, this.tien.getId());
			  pstm.setInt(4, this.id);
			  pstm.executeUpdate();
			  select(this.id);
		  } else {
			  throw new SQLException("Entidade de negócio não cadastrada.");		  
		  }		  
	  } finally {
		  if(pstm!=null){
			  pstm.close();
		  }
	  }
  }

  
  public void delete() throws SQLException {
	  PreparedStatement pstm = null;
	  try {
		  if (id != 0) {
			  pstm = conn.prepareStatement(
					  new StringBuilder(" DELETE FROM entidades_negocio ")
	                  	        .append("  WHERE enne_id = ?").toString());
			  pstm.setInt(1, this.id);
			  pstm.executeUpdate();
			  this.id = 0;
		  } else {
			  throw new SQLException("Entidade de negócio não cadastrada.");    	
		  }		  
	  } finally {
		  if(pstm!=null){
			  pstm.close();
		  }
	  }
  }

  
  public void atualiza(TipoEntidadeNegocioAPI tien) throws SQLException {
    PreparedStatement pstm = this.conn.prepareStatement(
    new StringBuilder(" SELECT /*+ all_rows */ enne_id ")
              .append("   FROM entidades_negocio ")
              .append("  WHERE enne_tien_id = ? ").toString()
    );
    pstm.setInt(1, tien.getId());
    ResultSet enne_set = pstm.executeQuery();
    Vector<Integer> enne_ids = new Vector<Integer>();
    while (enne_set.next()) {
    	enne_ids.add(enne_ids.size(), enne_set.getInt(1));
    }
    pstm.close();
    Statement stm = this.conn.createStatement();
    enne_set = stm.executeQuery(tien.getSQL());
    Vector<EntidadeNegocio> ennes = new Vector<EntidadeNegocio>();
    while (enne_set.next()) {
    	EntidadeNegocio enne = new EntidadeNegocio();
        enne.setDescricao(enne_set.getString(1));
        enne.chave = enne_set.getString(2);
        ennes.add(ennes.size(), enne);
    }
    stm.close();
    
    for (EntidadeNegocio enne : ennes) {
    	StringBuilder sb = new StringBuilder();
    	sb.append(" SELECT /*+ all_rows */ enne_id ");
    	sb.append("   FROM entidades_negocio   ");
    	sb.append("  WHERE enne_tien_id    = ? ");
    	sb.append("    AND enne_chave      = ? ");      
    	pstm = this.conn.prepareStatement(sb.toString());
    	pstm.setInt(1, tien.getId());
    	pstm.setString(2, enne.getChave());
    	ResultSet rset = pstm.executeQuery();
    	if (rset.next()) {
    		this.select(rset.getInt(1));
    		this.setDescricao(enne.getDescricao());
    		this.update();
    		Integer obj = new Integer(this.id);
    		enne_ids.remove(obj);
    	} else {
    		this.id = 0;
    		this.setDescricao(enne.getDescricao());
    		this.chave = enne.getChave();
    		this.setTipoEntidadeNegocio(tien);
    		this.insert();
    	}
    	pstm.close();
	}
    ennes.clear();
    for (int e = 0; (e < enne_ids.size()); e++) {
    	Integer eId = (Integer) enne_ids.get(e);
    	this.select(eId.intValue());
    	this.delete();
    }
    enne_ids.clear();
  }
  
  
  
  public ArrayList<UsuarioAPI> getUsuarios() throws SQLException {
	  PreparedStatement pstm = null;
      ResultSet rset = null;
	  try {
		    if (this.usuarios == null) {
		        this.usuarios = new ArrayList<UsuarioAPI>();
		        pstm = this.conn.prepareStatement(
		        		new StringBuilder(" SELECT /*+ all_rows */ usua_id ")
		        				  .append("   FROM usuarios ")
		     	                  .append("  WHERE usua_enne_id = ? ").toString()
		     	        );
		        pstm.setInt(1, this.id);
		        rset = pstm.executeQuery();
		        while (rset.next()) {
		        	this.usuarios.add(new UsuarioAPI(this.conn, rset.getInt(1)));
		        }
		    }
		    return this.usuarios;		  
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


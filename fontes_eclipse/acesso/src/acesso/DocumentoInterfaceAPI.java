package acesso;
import java.sql.*;
import util.consultas.*;

public class DocumentoInterfaceAPI extends DocumentoInterface {
	private Connection conn;
    private DocumentoInterface old;

    public DocumentoInterfaceAPI(Connection conn) {
        this.conn = conn;
    }

    public DocumentoInterfaceAPI(Connection conn, int id) throws SQLException {
        this(conn);
        select(id);
    }   

    public boolean autorizado(Usuario usua) {
        boolean retorno;
        if(usua.isSuperUsuario()) {
            retorno = true;
        } else { 
            retorno = getAcesso(usua) != null;
        }
        return retorno;
    }

    public AcessoDocumentoInterface getAcesso(Usuario usua) {
        AcessoDocumentoInterfaceAPI acdi = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
        	StringBuilder sb = new StringBuilder();
        	sb.append(" SELECT /*+ all_rows */ acdi.acdi_id ");
        	sb.append("   FROM acessos_documentos_interfaces acdi ");
        	sb.append("  WHERE acdi.acdi_doin_id = ? ");
        	sb.append("    AND acdi.acdi_usua_id = ?");        	
            pstm = conn.prepareStatement(sb.toString());
            pstm.setInt(1, getId());
            pstm.setInt(2, usua.getId());
            rset = pstm.executeQuery();
            if(rset.next()) {
                acdi = new AcessoDocumentoInterfaceAPI(conn, rset.getInt(1));
            }
        } catch(SQLException er) {
            acdi = null;
        } finally {
        	if(rset!=null){
        		try {
					rset.close();
				} catch (SQLException e) {}
        	}
        	if(pstm!=null){
                try {
					pstm.close();
				} catch (SQLException e) {}        		
        	}
        }
        return acdi;
    }

    
    public void setNome(String nome) {
        super.setNome(nome.trim());
    }

    
    private void validate() throws SQLException {
        StringBuilder emsg = new StringBuilder();
        if(nome == null || nome.equals("")) {
            emsg.append("O nome deve ser informado.\n");
        } else if(nome.length() > 80) {
            emsg.append("O nome possui mais de 80 caracteres.\n");
        } else {
        	PreparedStatement pstm = null;
        	ResultSet rset = null;
        	try {
        		StringBuilder sb = new StringBuilder();
                sb.append(" SELECT /*+ all_rows */ doin_id ");
               	sb.append("   FROM documentos_interfaces ");
               	sb.append("  WHERE doin_nome = ? ");
               	sb.append("    AND doin_id  != ?");
            	pstm = conn.prepareStatement(sb.toString());
                pstm.setString(1, nome);
                pstm.setInt(2, id);
                rset = pstm.executeQuery();
                if(rset.next()) {
                    emsg.append("Documento/Interface j\341 cadastrado.\n");
                }
                pstm.close();        		
        	} finally {
        		if(rset!=null){
        			rset.close();
        		}
        		if(pstm!=null){
        			pstm.close();
        		}
        	}
        }
        if(descricao != null && descricao.length() > 512) {
            emsg.append("A descric\343o possui mais de 512 caracteres.\n");
        }
        if(emsg.length() > 0) {
            throw new SQLException(emsg.toString());
        } else {
            return;
        }
    }

    public void insert() throws SQLException {
    	Sequence sequence = new Sequence();
        if(id == 0) {
        	PreparedStatement pstm = null;
        	ResultSet rset = null;
        	try {
        		int newId = 0;
                validate();
                newId = sequence.nextValue("documentos_interfaces", "doin_id");                
                StringBuilder sb = new StringBuilder();
        		sb.append(" INSERT INTO documentos_interfaces ");
        		sb.append("        ( doin_id ");
        		sb.append("        , doin_nome ");
        		sb.append("        , doin_descricao ");
        		sb.append("        , doin_data_cadastro )");
        	    sb.append(" VALUES ( ?, ?, ?, sysdate ) ");            
                pstm = conn.prepareStatement(sb.toString());
                pstm.setInt(1, newId);
                pstm.setString(2, nome);
                pstm.setString(3, descricao);
                pstm.executeUpdate();
                pstm.close();
                select(newId);        		
        	} finally {
        		if(rset!=null){
        			rset.close();
        		}
        		if(pstm!=null){
        			pstm.close();
        		}
        	}
        } else {
            throw new SQLException("Documento/Interface j\341 cadastrado.");
        }
    } 

    public void select(int id) throws SQLException {
    	PreparedStatement pstm = null;
    	ResultSet rset = null;
    	try {
        	StringBuilder sb = new StringBuilder();
        	sb.append(" SELECT /*+ all_rows */ doin_nome ");
        	sb.append("      , doin_descricao ");
        	sb.append("   FROM documentos_interfaces ");
        	sb.append("  WHERE doin_id = ?");    	
            pstm = conn.prepareStatement(sb.toString());
            pstm.setInt(1, id);
            rset = pstm.executeQuery();
            if(rset.next()) {
                nome = rset.getString(1);
                descricao = rset.getString(1);
                this.id = id;
                old = this;
                pstm.close();
            } else {
                pstm.close();
                throw new SQLException("Documento/Interface n\343o cadastrado.");
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

    public void update() throws SQLException {
        if(old != null && id == old.id) {
        	PreparedStatement pstm = null;
        	try {
                validate();
                StringBuilder sb = new StringBuilder();
            	sb.append(" UPDATE documentos_interfaces ");
            	sb.append("    SET doin_nome      = ? ");
            	sb.append("      , doin_descricao = ? ");
            	sb.append("  WHERE doin_id        = ? ");            
                pstm = conn.prepareStatement(sb.toString());
                pstm.setString(1, nome);
                pstm.setString(2, descricao);
                pstm.setInt(3, id);
                pstm.executeUpdate();
                select(id);        		
        	} finally {
        		if(pstm!=null){
        			pstm.close();
        		}
        	}
        } else {
            throw new SQLException("Documento/Interface n\343o cadastrado.");
        }
    } 

    public void delete() throws SQLException {
        if(old != null && id == old.id) {
        	PreparedStatement pstm = null;
        	try {
                pstm = conn.prepareStatement(
                        new StringBuilder(" DELETE documentos_interfaces ")
                                  .append("  WHERE doin_id = ? ").toString());
                pstm.setInt(1, id);
                pstm.executeUpdate();
                id = 0;        		
        	} finally {
        		if(pstm!=null){
        			pstm.close();
        		}
        	}
        } else {
            throw new SQLException("Documento/Interface n\343o cadastrado.");
        }
    }
}

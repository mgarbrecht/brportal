package acesso;
import java.sql.*;

import util.consultas.*;

public class UsuarioAPI extends Usuario {
	
    private Connection conn;
    private Usuario old;
    private boolean senhaMudou;

	public UsuarioAPI(Connection conn) {
		this.conn = conn;
	}

	public UsuarioAPI(Connection conn, int id) throws SQLException {
		this(conn);
		select(id);
	}

	public UsuarioAPI(Connection conn, int id, int dias) throws SQLException {
		this(conn);
		select(id, dias);
	}

    public void setEmail(String email){
    	super.setEmail(email.toLowerCase());
    }
    
    public void setNome(String nome) {
        super.setNome(nome.trim().toUpperCase().replace("'", "´"));        
    }

    public void setUsuario(String usuario) {
        super.setUsuario(usuario.trim().toUpperCase());
    }

    public void setSenha(byte senha[]) {
        super.setSenha(senha);
        senhaMudou = true;
    }

    private void setaPermissoes() throws SQLException {
    	PreparedStatement pstm = null;
    	ResultSet rset = null;
    	try {
    		pstm = conn.prepareStatement(
            		new StringBuilder(" SELECT /*+ all_rows */ ")
            		          .append("        i.acdi_doin_id ")
            		          .append("   FROM acessos_documentos_interfaces i ")
            		          .append("      , usuarios u ")
            		          .append("  WHERE i.acdi_usua_id = u.usua_id ")
            		          .append("    AND u.usua_id = ?" ).toString());
            pstm.setInt(1, this.id);
            rset = pstm.executeQuery();
            while(rset.next()) {
            	super.permissoes.add(rset.getInt(1));
            }
    	} catch (SQLException e) {
    	} finally {
            if(rset!=null){
            	rset.close();
            }
            if(pstm!=null){
            	pstm.close();    		
            }
    	}
    }
    
    private void validate() throws SQLException {
    	PreparedStatement pstm = null;
    	ResultSet rset = null;
    	try {
            StringBuilder emsg = new StringBuilder();
            if(nome.equals("")) {
                emsg.append("O nome deve ser informado.\n");
            } else if(nome.length() > 40) {
                emsg.append("O nome possui mais de 40 caracteres.\n");
            }
            if(usuario.equals("")) {
                emsg.append("O nome deve ser informado.\n");
            } else if(usuario.length() > 30) {
                emsg.append("O nome possui mais de 30 caracteres.\n");
            }
            if(senha == null || senha.length == 0) {
                emsg.append("A senha deve ser informada.\n");
            } else if(senha.length > 32) {
                emsg.append("A senha possui mais de 32 caracteres.\n");
            }
            if(dataSenha == null) {
                emsg.append("A data de manuten\347\343o da senha deve ser informada.\n");
            }

            StringBuilder sb2 = new StringBuilder();
    		sb2.append(" SELECT /*+ all_rows */ usua_id ");
    		sb2.append("   FROM usuarios ");
    		sb2.append("  WHERE usua_usuario = ? ");
    		sb2.append("    AND usua_id != ? ");        
            pstm = conn.prepareStatement(sb2.toString());
            pstm.setString(1, usuario);
            pstm.setInt(2, id);
            rset = pstm.executeQuery();        
            if(rset.next()) {
                emsg.append("Usu\341rio j\341 cadastrado.\n");
            }
            rset.close();
            pstm.close();
            
            if(enne != null) {
                pstm = conn.prepareStatement(
                   new StringBuilder(" SELECT /*+ all_rows */ enne_id ")
                             .append("   FROM entidades_negocio ")
                             .append("  WHERE enne_id = ?").toString());
                pstm.setInt(1, enne.getId());
                rset = pstm.executeQuery();
                if(!rset.next()) {
                    emsg.append("Entidade de neg\363cio n\343o cadastrada.\n");
                }
                rset.close();
                pstm.close();
            }
            if(emsg.length() > 0) {
                throw new SQLException(emsg.toString());
            } else {
                return;
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
        	if(id == 0) {
                validate();
                int newId = sequence.nextValue("usuarios", "usua_id");
                StringBuilder sb = new StringBuilder();
            	sb.append(" INSERT INTO usuarios ");
            	sb.append("        ( usua_id ");
            	sb.append("        , usua_nome ");
            	sb.append("        , usua_usuario ");
            	sb.append("        , usua_senha ");
            	sb.append("        , usua_dt_senha ");
            	sb.append("        , usua_super ");
            	sb.append("        , usua_enne_id ");
            	sb.append("        , usua_acessos ");
            	sb.append("        , situacao ");
            	sb.append("        , dias_consulta_retroativa ");
            	sb.append("        , usua_expira_senha ");
            	sb.append("        , usua_email ");
            	sb.append("        , dthr_inclusao ");
            	sb.append("        , dthr_alteracao ");
            	sb.append("        , usuario_inclusao ");
            	sb.append("        , usuario_alteracao) ");            	
            	sb.append(" VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, null, ?, null) ");            
                
            	pstm = conn.prepareStatement(sb.toString());
                pstm.setInt(1, newId);
                pstm.setString(2, nome);
                pstm.setString(3, usuario);
                pstm.setBytes(4, senha);
                pstm.setDate(5, dataSenha);
                pstm.setString(6, superUsuario);
                if(enne == null) {
                    pstm.setString(7, "");
                } else {
                    pstm.setInt(7, enne.getId());
                }
                pstm.setInt(8, acessos);
                pstm.setString(9, situacao);
                if(diasConsultaRetroativa == null) {
                	pstm.setString(10, "");
                } else {
                	pstm.setInt(10, diasConsultaRetroativa);
                }
                pstm.setString(11, expiraSenha);
                pstm.setString(12, email);
                pstm.setString(13, usuarioInclusao);
                pstm.executeUpdate();
                pstm.close();
                //-------------
                pstm = conn.prepareStatement(
                 	   new StringBuilder(" INSERT INTO wbrio.ultimas_senhas_usuarios ")
                 	             .append(" VALUES (?,?,sysdate) ").toString());
                pstm.setInt(1, newId);
                pstm.setBytes(2, senha);
                pstm.executeUpdate();
                pstm.close();
                //-------------
                select(newId);
            } else {
                throw new SQLException("Usu\341rio j\341 cadastrado.");
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
        	sb.append(" SELECT /*+ all_rows */ ");
        	sb.append("        usua_id ");
        	sb.append("      , usua_nome ");
        	sb.append("      , usua_usuario ");
        	sb.append("      , usua_senha ");
        	sb.append("      , usua_dt_senha ");
        	sb.append("      , usua_super ");
        	sb.append("      , usua_enne_id ");
        	sb.append("      , usua_acessos ");
        	sb.append("      , situacao ");
        	sb.append("      , dias_consulta_retroativa ");
        	sb.append("      , usua_expira_senha ");
        	sb.append("      , usua_email ");
        	sb.append("   FROM wbrio.usuarios u ");
        	sb.append("  WHERE usua_id = ? ");   
            pstm = conn.prepareStatement(sb.toString());
            pstm.setInt(1, id);
            rset = pstm.executeQuery();
            if(rset.next()){
                this.id = rset.getInt(1);
                this.nome = rset.getString(2);
                this.usuario = rset.getString(3);
                this.senha = rset.getBytes(4);
                this.dataSenha = rset.getDate(5);
                this.superUsuario = rset.getString(6);
                int enne_id = rset.getInt(7);
                this.acessos = rset.getInt(8);
                this.situacao = rset.getString(9);
                this.diasConsultaRetroativa = rset.getInt(10);
                this.expiraSenha = rset.getString(11);
				this.email = rset.getString(12);
				if (enne_id != 0) {
					EntidadeNegocioAPI enti = new EntidadeNegocioAPI(this.conn);
					enti.select(enne_id);
					this.enne = enti;
					TipoEntidadeNegocioAPI tienAPI = new TipoEntidadeNegocioAPI(this.conn,this.enne.getTipoEntidadeNegocio().getId());
					Query query = new Query();
					try {
						String descricao = query.select("SELECT descricao from (" + tienAPI.getSQL()+ ") where chave = '" + this.enne.getChave() + "'");
						if (descricao.equals("") && this.superUsuario.equalsIgnoreCase("N")) {
							this.usuarioInativar = true;
						}
					} catch (Exception e) {
					}
					//------
					if(enti.getTipoEntidadeNegocio().getId() == 2194) {
						try {
						String situacao = query.select("SELECT cli_situ from cli where cli_cdgo = " + this.enne.getChave());
						if(situacao.equals("I")) {
							String enneId = query.select("SELECT enne_id FROM wbrio.entidades_negocio WHERE enne_chave = '"+this.enne.getChave()+"' AND enne_tien_id = 4");
				             if(enneId.equals("")){
				                acesso.EntidadeNegocioAPI entidade = new acesso.EntidadeNegocioAPI(this.conn);
				                acesso.TipoEntidadeNegocioAPI tipoentidade = new acesso.TipoEntidadeNegocioAPI(this.conn, 4);
				                entidade.setChave(this.enne.getChave());
				                entidade.setTipoEntidadeNegocio(tipoentidade);
				                entidade.insert();
				                enneId = query.select("SELECT enne_id FROM wbrio.entidades_negocio WHERE enne_chave = '"+this.enne.getChave()+"' AND enne_tien_id = 4");
				             }
				             
				             acesso.EntidadeNegocioAPI enne = new acesso.EntidadeNegocioAPI(this.conn);
				             enne.select(Integer.parseInt(enneId));
				             this.setEntidadeNegocio((acesso.EntidadeNegocio) enne);
				             this.setSituacao("A");
				             this.old = this;
				             update();
				             select(this.id);
				             removerAutorizacoes();
				             acesso.AcessoDocumentoInterfaceAPI adi = new acesso.AcessoDocumentoInterfaceAPI(this.conn);
				             adi.geraAutorizacoesUsuario(this.getId());
				             this.usuarioInativar = false; 
						}
						} catch (Exception e) {
							e.printStackTrace(System.err);
						}
					}
				
				} else {
					this.enne = null;
				}
                this.senhaMudou = false;
                this.old = this;
                setaPermissoes();
            } else {
                throw new SQLException("Usu\341rio n\343o cadastrado.");
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
    
    public void select(int id, int dias) throws SQLException {
    	PreparedStatement pstm = null;
    	ResultSet rset = null;
    	try {
        	StringBuilder sb = new StringBuilder();
        	sb.append(" SELECT /*+ all_rows */ ");
        	sb.append("        usua_id ");
        	sb.append("      , usua_nome ");
        	sb.append("      , usua_usuario ");
        	sb.append("      , usua_senha ");
        	sb.append("      , usua_dt_senha ");
        	sb.append("      , usua_super ");
        	sb.append("      , usua_enne_id ");
        	sb.append("      , usua_acessos ");
        	sb.append("      , situacao ");
        	sb.append("      , dias_consulta_retroativa ");
        	sb.append("      , usua_expira_senha ");
        	sb.append("      , usua_email ");
        	sb.append("   FROM wbrio.usuarios ");
        	sb.append("  WHERE usua_id = ? ");    
        	pstm = conn.prepareStatement(sb.toString());
        	pstm.setInt(1, id);
        	rset = pstm.executeQuery();
        	if(rset.next()) {
        		this.id = rset.getInt(1);
        		nome = rset.getString(2);
        		usuario = rset.getString(3);
        		senha = rset.getBytes(4);
        		dataSenha = rset.getDate(5);
        		superUsuario = rset.getString(6);
        		int enne_id = rset.getInt(7);
        		acessos = rset.getInt(8);
        		situacao = rset.getString(9);
        		diasConsultaRetroativa = dias;
        		expiraSenha = rset.getString(11);
        		email = rset.getString(12);
        		if(enne_id != 0) {
        			EntidadeNegocioAPI enti = new EntidadeNegocioAPI(conn);
        			enti.select(enne_id);
        			enne = enti;
        		} else {
        			enne = null;
        		}
        		senhaMudou = false;
        		old = this;
                setaPermissoes();
        	} else {
        		throw new SQLException("Usu\341rio n\343o cadastrado.");
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
   
	public void atualizaUltimoAcesso(String usuaUsuario) {
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(
		       new StringBuilder(" UPDATE usuarios ")
				  	     .append("    SET usua_dt_ultimo_acesso = sysdate ")
					     .append("  WHERE usua_usuario = ?").toString());
			pstm.setString(1, usuaUsuario);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			try {
				pstm.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}
    
    public void update() throws SQLException {
    	PreparedStatement pstm = null;
    	try {
        	if(old != null && id == old.id) {
                validate();
                if(senhaMudou) {
                	StringBuilder sb = new StringBuilder();
                	sb.append(" UPDATE usuarios ");
                	sb.append("    SET usua_nome = ? ");
                	sb.append("      , usua_usuario = ? ");
                	sb.append("      , usua_dt_senha = nvl(sysdate, ?)  ");
                	sb.append("      , usua_super = ? ");
                	sb.append("      , usua_enne_id = ? ");
                	sb.append("      , dias_consulta_retroativa = ? ");
                	sb.append("      , usua_acessos = ? ");
                	sb.append("      , usua_senha = ? ");
                	sb.append("      , situacao = ? ");
                	sb.append("      , usua_expira_senha = ? ");
                	sb.append("      , usua_email = ? ");
                	sb.append("      , dthr_alteracao = sysdate ");
                	sb.append("      , usuario_alteracao = ? ");
                	sb.append("  WHERE usua_id = ? ");            	
                    pstm = conn.prepareStatement(sb.toString());
                    pstm.setBytes(8, senha);
                    pstm.setString(9, situacao);
                    pstm.setString(10, expiraSenha);
                    pstm.setString(11, email);
                    pstm.setString(12, usuarioAlteracao);
                    pstm.setInt(13, id);
                } else {
                	StringBuilder sb = new StringBuilder();
                	sb.append(" UPDATE usuarios ");
                	sb.append("    SET usua_nome = ? ");
                	sb.append("      , usua_usuario = ? ");
                	sb.append("      , usua_dt_senha = ? ");
                	sb.append("      , usua_super = ? ");
                	sb.append("      , usua_enne_id = ? ");
                	sb.append("      , dias_consulta_retroativa = ? ");
                	sb.append("      , usua_acessos = ? ");
                	sb.append("      , situacao = ? ");
                	sb.append("      , usua_expira_senha = ? ");
                	sb.append("      , usua_email = ? ");
                	sb.append("      , dthr_alteracao = sysdate ");
                	sb.append("      , usuario_alteracao = ? ");                	
                	sb.append("  WHERE usua_id = ? ");            	
                    pstm = conn.prepareStatement(sb.toString());
                    pstm.setString(8, situacao);
                    pstm.setString(9, expiraSenha);
                    pstm.setString(10, email);
                    pstm.setString(11, usuarioAlteracao);
                    pstm.setInt(12, id);
                }
                
                pstm.setString(1, nome);
                pstm.setString(2, usuario);
                pstm.setDate(3, dataSenha);
                pstm.setString(4, superUsuario);
                if(enne == null){
                    pstm.setString(5, "");
                } else {
                    pstm.setInt(5, enne.getId());
                }
                if(diasConsultaRetroativa == null){
                    pstm.setString(6, "");
                } else {
                    pstm.setInt(6, diasConsultaRetroativa);
                }
                pstm.setInt(7, acessos);
                pstm.executeUpdate();
                pstm.close();

                if(senhaMudou){
                pstm = conn.prepareStatement(
                        new StringBuilder(" DELETE FROM wbrio.ultimas_senhas_usuarios x ")
                                  .append("  WHERE EXISTS (SELECT rowid ")
                                  .append("           FROM (SELECT usua_dt_senha, ")
                                  .append("                        rank() OVER(PARTITION BY u.usua_id ORDER BY u.usua_dt_senha desc) seq ")
                                  .append("                   FROM wbrio.ultimas_senhas_usuarios u ")
                                  .append("                  WHERE u.usua_id = ?) ")
                                  .append("          WHERE seq >= ( SELECT valor ")
                                  .append("                           FROM wbrio.parametros p ")
                                  .append("                          WHERE p.nome = 'quantidade_senhas_armazenadas' ")
                                  .append("                            AND p.par_sist_codigo = 'BRNET' ) ")
                                  .append("            AND rowid = x.rowid) ").toString());
                
                     pstm.setInt(1, id);
                     pstm.executeUpdate();
                     pstm.close();       
                     //-------------
                     try {
                    	 pstm = conn.prepareStatement(
                    			 new StringBuilder(" INSERT INTO wbrio.ultimas_senhas_usuarios ")
                    			 		   .append(" VALUES (?,?,sysdate) ").toString());
                    	 pstm.setInt(1, id);
                    	 pstm.setBytes(2, senha);
                    	 pstm.executeUpdate();
                     } catch (Exception e){
                     } finally {
                    	 pstm.close();
                     }
                     //-------------                 
                }
                select(id);
            } else {
                throw new SQLException("Usu\341rio n\343o cadastrado.");
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
        	if(old != null && id == old.id) {
                pstm = conn.prepareStatement(
                		new StringBuilder(" DELETE FROM acessos_documentos_interfaces ")
                				  .append("  WHERE acdi_usua_id = ?").toString()); 
                pstm.setInt(1, id);
                pstm.executeUpdate();
                pstm.close();
                //---------------            
                pstm = conn.prepareStatement(
                		new StringBuilder(" DELETE FROM acessos_usuarios ")
            		      	      .append("  WHERE acus_usua_id = ?").toString()); 
                pstm.setInt(1, id);
                pstm.executeUpdate();
                pstm.close();
                //---------------
                pstm = conn.prepareStatement(
                		new StringBuilder(" DELETE FROM wbrio.ultimas_senhas_usuarios ")
                                  .append("  WHERE usua_id = ?").toString()); 
                pstm.setInt(1, id);
                pstm.executeUpdate();
                pstm.close(); 
                //---------------
                pstm = conn.prepareStatement(
                        new StringBuilder(" DELETE FROM wbrio.log_acessos_usuarios ")
                                  .append("  WHERE usua_id = ?").toString()); 
                     pstm.setInt(1, id);
                     pstm.executeUpdate();
                     pstm.close(); 
				// ---------------
				pstm = conn.prepareStatement(
						new StringBuilder(" DELETE FROM wbrio.acessos_troca_identidade ")
								  .append(" WHERE atid_usua_id = ?").toString());
				pstm.setInt(1, id);
				pstm.executeUpdate();
				pstm.close();
				// ---------------
                pstm = conn.prepareStatement(
                		new StringBuilder(" DELETE FROM usuarios ")
                                  .append("  WHERE usua_id = ?").toString()); 
                pstm.setInt(1, id);
                pstm.executeUpdate();
                pstm.close();
                //---------------            
                id = 0;
            } else {
                throw new SQLException("Usu\341rio n\343o cadastrado.");
            }
        } finally {
        	if(pstm!=null){
        		pstm.close();
        	}
        }
    }
    
    public void removerAutorizacoes() throws SQLException {
    	PreparedStatement pstm = null;
    	try {
                pstm = conn.prepareStatement(
                		new StringBuilder(" DELETE FROM acessos_documentos_interfaces ")
                				  .append("  WHERE acdi_usua_id = ?").toString()); 
                pstm.setInt(1, id);
                pstm.executeUpdate();
                pstm.close();
                //---------------            
                pstm = conn.prepareStatement(
                		new StringBuilder(" DELETE FROM acessos_usuarios ")
            		      	      .append("  WHERE acus_usua_id = ?").toString()); 
                pstm.setInt(1, id);
                pstm.executeUpdate();
                pstm.close();
                //---------------
				pstm = conn.prepareStatement(
						new StringBuilder(" DELETE FROM wbrio.acessos_troca_identidade ")
								  .append(" WHERE atid_usua_id = ?").toString());
				pstm.setInt(1, id);
				pstm.executeUpdate();
				pstm.close();
				// ---------------
           
        } finally {
        	if(pstm!=null){
        		pstm.close();
        	}
        }
    }    
    
    public boolean isNovoClienteMercadoInterno(String codigo) throws SQLException {
    	PreparedStatement pstm = null;
    	ResultSet rset = null;
    	boolean retorno = false;
    	StringBuilder sb = new StringBuilder();
    	try {
    		sb.append(" SELECT /*+ all_rows */ ");
    		sb.append("        DISTINCT c.cli_cdgo ");
    		sb.append("   FROM cli c ");
    		sb.append("  WHERE to_char(c.cli_cdgo) = ? "); 
    		sb.append("    AND c.cli_situ = 'A' ");
    	    sb.append("    AND c.cli_cdgo <> 40000 ");
    	    sb.append("    AND c.cli_tipo_mercado = 'MI' ");
    		sb.append("    AND NOT EXISTS ( SELECT 1 ");
    		sb.append("                       FROM wbrio.tipos_entidade_negocio t ");
    		sb.append("   	                     , wbrio.entidades_negocio e ");
    		sb.append("    	                     , wbrio.usuarios u ");
    		sb.append("    	                 WHERE t.tien_id           = e.enne_tien_id ");
    		sb.append("    	                   AND e.enne_id           = u.usua_enne_id ");
    		sb.append("    	                   AND t.tien_id           = 2194 ");
    		sb.append("    	                   AND to_char(c.cli_cdgo) = u.usua_usuario ");
    		sb.append("    	               ) ");   
        	pstm = conn.prepareStatement(sb.toString());
        	pstm.setString(1, codigo);
			rset = pstm.executeQuery();
			if (rset.next()) {
				retorno = true;
			}
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		}
		return retorno;
    }
}


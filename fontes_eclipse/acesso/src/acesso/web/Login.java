package acesso.web;
import acesso.UsuarioAPI;
import java.io.*;
import java.security.*;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import util.consultas.Query;

public class Login extends HttpServlet implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public Login(){}

    private void showError(HttpServletRequest req, HttpServletResponse res, String error)
        throws IOException, ServletException {
        HttpSession se = req.getSession();
        se.setAttribute("Error", error);
        doGet(req, res);
    }

    public final void doGet(HttpServletRequest req, HttpServletResponse res)
        throws IOException, ServletException {
    	
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        HttpSession se = req.getSession();
        String user = req.getParameter("usuario");
//------------------ Seta a linguagem padrão para Português "pt_BR" -----------------------------------------                    
        java.util.Locale locale = null;
        locale = new java.util.Locale("pt","BR");
        se.setAttribute("locale1","pt");
        se.setAttribute("locale2","BR");        
	    Locale.setDefault(locale);
        se.setAttribute(org.apache.struts.Globals.LOCALE_KEY, locale);
//-----------------------------------------------------------------------------------------------------------        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>BR Portal</title>");
        out.println("<link rel='stylesheet' href='../css/style.css' charset='ISO-8859-1' type='text/css'>");
        out.println("  <script type=\"text/javascript\" src=\"../script/jquery.js\"></script>");
        out.println("  <script type=\"text/javascript\" src=\"../script/util.js\"></script>");
        out.println("  <script type=\"text/javascript\" src=\"../script/thickbox-compressed.js\"></script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table border='0' width='100%'>");
        out.println("<tr><td>");
        out.println("</table>");
        out.println("<table border='0' align='center' style='width:100%' cellpadding='0' cellspacing='0' >");
        out.println("</td></tr>");
        out.println("<tr><td align='center'><br><br><br><br><br><br><br><br>");
        out.println("     <fieldset style='width:700'>");
        out.println("     <legend><img src='../img/logo_login.jpg' border='0'></legend>");
        out.println("      <form name=frmMain action=login method=post>");
        out.println("      <table border='0' style='width:700'cellpadding='0' cellspacing='0'>");
        out.println("        <tr><td><center>");
        out.println("          <table style=width:640;margin-top:0;>");
        out.println("            <tr>");
        out.println("              <td background='../img/screen_bar_beirario.png';>");
        out.println("              <big><b>Sistema BR Portal</b></big>");
        out.println("              </td>");
        out.println("            </tr>");
        out.println("            <html:errors/>");
        out.println("          </table>");
        out.println("");
        out.println("          <table style=width:640;margin-top:10; ><tr><td style=font-size:12px;>");
        if((((String)se.getAttribute("novo_cliente"))+"").equals("s")){
        	out.println("            <tr><td  style=text-align:right;width:250;font-family: Verdana, Arial, sans-serif;font-size:12px>Informe seu CNPJ:</td><td><input type='text' name='cgc'></td></tr>");
        } else {
           if(user == null) {
               out.println("            <tr><td  style=text-align:right;width:250;font-family: Verdana, Arial, sans-serif;font-size:12px>Usu\341rio&nbsp</td><td><input type='text' name='usuario'></td></tr>");
           } else {
               out.println((new StringBuilder("            <tr><td style=text-align:right;width:250;font-family: Verdana, Arial, sans-serif;font-size:14px>Usu\341rio&nbsp</td><td><input type='text' name='usuario' value='")).append(user).append("'></td></tr>").toString());
           }
           out.println("            <tr><td style=text-align:right;width:250;font-family: Verdana, Arial, sans-serif;font-size:14px>Senha&nbsp</td><td><input type='password' name='senha'></td></tr>");
        }           
        out.println("          <tr><td><BR>");
        out.println("          </td></tr>");
        out.println("            <td align='center' colspan='2' style='font-size:14px'>");
        out.println("              <a href='../system/NovaSenhaForm.do?resetfull_action=?keepThis=true&TB_iframe=true&height=160&width=600' title='Receber Nova Senha Por Email' class='thickbox'>");
        //out.println("                <b><font color='#8D0000'>Esqueci minha senha</font></b>");
        out.println("                  <button style='margin-right: 3px; background-color: #FF5353; padding: 5px 5px 5px 5px; border: 0px solid #FF5353 !IMPORTANT; color: #ffffff;  font-size: 14px; font-weight: bold; letter-spacing: 1px; cursor: pointer; height: auto; vertical-align: middle;' value='' type=button><font color=#ffffff style='font-family:Arial,Verdana; font-size:14px' name='esqueciminhasenha'>Esqueci minha senha!</font></button> ");
        out.println("              </a>");
        out.println("            </td>");
        out.println("          </table>");
        out.println("          <table style=width:640; class=buttonTable>");
        out.println("            <tr class=buttonTr>");
        out.println("              <td class=buttonTdLogin>");
        if((((String)se.getAttribute("novo_cliente"))+"").equals("s")){
        	out.println("                <button style='margin-right: 3px; padding: 0 5px 0 5px; background: url(../img/button-back.gif) repeat-x; border: 0px solid #f9ebd8 !IMPORTANT; color: #ffffff;  font-size: 11px; font-weight: bold; letter-spacing: 1px; cursor: pointer; height: auto; vertical-align: middle;' value='' type=submit><font color=#ffffff style='font-family:Arial,Verdana; font-size:13px' > Confirmar CNPJ</font></button>&nbsp");        	
        } else {
        	out.println("                <button style='margin-right: 3px; padding: 0 5px 0 5px; background: url(../img/button-back.gif) repeat-x; border: 0px solid #f9ebd8 !IMPORTANT; color: #ffffff;  font-size: 11px; font-weight: bold; letter-spacing: 1px; cursor: pointer; height: auto; vertical-align: middle;' value='' type=submit><font color=#ffffff style='font-family:Arial,Verdana; font-size:13px' name='entrar' > Entrar</font></button>&nbsp");
        	out.println("                <button style='margin-right: 3px; padding: 0 5px 0 5px; background: url(../img/button-back.gif) repeat-x; border: 0px solid #f9ebd8 !IMPORTANT; color: #ffffff;  font-size: 11px; font-weight: bold; letter-spacing: 1px; cursor: pointer; height: auto; vertical-align: middle;' value='' type=reset><font color=#ffffff style='font-family:Arial,Verdana; font-size:13px' > Limpar</font></button>");
        	out.println("                <button style='margin-right: 3px; padding: 0 5px 0 5px; background: url(../img/button-back.gif) repeat-x; border: 0px solid #f9ebd8 !IMPORTANT; color: #ffffff;  font-size: 11px; font-weight: bold; letter-spacing: 1px; cursor: pointer; height: auto; vertical-align: middle;' value='' type=button><font color=#ffffff style='font-family:Arial,Verdana; font-size:13px' onclick=\"wopen('../acesso/SolicitacaoUsuarioForm.jsp','_blank',640,300)\"> Sou Lojista e quero me cadastrar</font></button>");
        }
        out.println("              </td>");
        out.println("            </tr>");
        out.println("          </table>");
        out.println(" <input type='text' class='myhidden' name='width'>");
        out.println(" <input type='text' class='myhidden' name='height'>");
        out.println("<script>document.forms[0].width.value=screen.width-100;</script>");
        out.println("<script>document.forms[0].height.value=screen.height-250;</script>");    
        out.println("");
        out.println("          </html:form>");
        out.println("        </center></td></tr>");
        out.println("      </table>");
        out.println("      </form>");
        out.println("</table>");
        String error = (String)se.getAttribute("Error");
        if(error != null) {
            out.println("<center>");
            out.println("<table style=width:640;margin-top:0;>");
            out.println("<tr><td width=70% align='left'><font color=red>");
            out.println((new StringBuilder("<font color=red><b>Erro: ")).append(error).append("</b></font>").toString());
            out.println("</font></td></tr>");
            out.println("</table>");
            out.println("</center>");
            se.removeAttribute("Error");
        }
        out.println("</body>");
        out.println("<script>");
        if((((String)se.getAttribute("novo_cliente"))+"").equals("s")){
        	out.println("document.forms[0].cgc.focus();");
        } else {
        	out.println("document.forms[0].usuario.focus();");
        }
        out.println("</script>");
        out.println("</html>");
        se.setAttribute("novo_cliente", "n");
    }

    public final void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        HttpSession se = req.getSession();
        PreparedStatement pstm = null;
        ResultSet rset = null;
        String user = null;
        String pswd = null;
        String cgc = null;
        com.egen.util.jdbc.JdbcUtil j = null;
        try {
        	j = new com.egen.util.jdbc.JdbcUtil();
        	se.setAttribute("width", req.getParameter("width"));
        	se.setAttribute("height", req.getParameter("height"));
        	javax.servlet.ServletContext context = req.getSession().getServletContext();
        	System.setProperty("realpathbrportal", context.getRealPath(""));
            cgc = req.getParameter("cgc")+"";
            if(cgc.equals("null")){   
            if(se.getAttribute("User") != null) {
                se.removeAttribute("User");
            }
            user = req.getParameter("usuario").toUpperCase();
            pswd = req.getParameter("senha");
            if(user == null || pswd == null) {
                showError(req, res, "O usu\341rio e a senha devem ser informados.");
                return;
            }
//---- Testa se o usuário é um cliente "Mercado Interno" sem usuário no sistema ----
        UsuarioAPI usuario_cliente = new UsuarioAPI(j.getConn());
        if(usuario_cliente.isNovoClienteMercadoInterno(user)){
        	se.setAttribute("novo_cliente","s");
        	se.setAttribute("novo_cliente_cli", user);
        	res.sendRedirect("../"); 
        } else {
//----------------------------------------------------------------------------------            
        	pstm = j.getConn().prepareStatement(
            	new StringBuilder(" SELECT usua_id ")
            	          .append("      , situacao ")
            	          .append("   FROM usuarios ")
            	          .append("  WHERE usua_usuario = ? ").toString());
            	        //  .append("  WHERE usua_usuario = ? ")
            	        //  .append("    AND situacao = 'A' ").toString());
            pstm.setString(1, user);
            rset = pstm.executeQuery();
            if(rset.next()) {
            	
            	if(rset.getString(2).equals("I")){
                   showError(req, res, "Usu\341rio bloqueado.");
                   return;
            	}
                UsuarioAPI usuario = new UsuarioAPI(j.getConn(), rset.getInt(1));
                if(usuario.isUsuarioInativar()) {
                	usuario.setSituacao("I");
                	usuario.update();
                	showError(req, res, "Usu\341rio n\343o reconhecido."); 
                	return;
                }
                pstm.close();
                fecharConexoes(rset, pstm);
                MessageDigest mdig = MessageDigest.getInstance("MD5");
                mdig.update(pswd.getBytes());
                pstm = j.getConn().prepareStatement("select ? from sys.dual");
                pstm.setBytes(1, mdig.digest());
                rset = pstm.executeQuery();
                if(rset.next()) {
                    pswd = rset.getString(1);
                }
                rset.close();
                pstm.close();
                if(MessageDigest.isEqual(usuario.getSenha(), pswd.getBytes())) {
                	
//------ Se a senha for "beirario", obriga a troca --------------------------------------------
                     if((req.getParameter("senha").equalsIgnoreCase("beirario"))
                       &&(!(req.getParameter("usuario").equals("40000")))){
                         usuario.setAcessos(0);
                     }
//---------------------------------------------------------------------------------------------
                     if(usuario.getAcessos()>0){
                    	 String venceu = null;
                    	 String dt_vencimento = null;
                    	 String aviso =  null;
                    	 String usua_super = null;
                    	 String usua_expira_senha = null;
                    	 int dias = 0;
                    	 pstm = j.getConn().prepareStatement(
                    			 new StringBuilder(" SELECT to_char(trunc(usua_dt_senha)+p.valor,'dd/mm/yyyy') dt_expira ")
                    			 	       .append("      , to_char(trunc(usua_dt_senha)+p2.valor,'dd/mm/yyyy') dt_aviso ")
                    			 	       .append("      , case when trunc(usua_dt_senha)+p.valor <= trunc(sysdate) then 'S' end dt_expirou ")
                    			 	       .append("      , case when trunc(usua_dt_senha)+p2.valor <= trunc(sysdate) then 'S' end dt_aviso ")
                    			 	       .append("      , nvl(trunc(usua_dt_senha)+p.valor - trunc(sysdate),0) dias ")
                    			 	       .append("      , usua_super ")
                    			 	       .append("      , usua_expira_senha ")
                    			 	       .append("   FROM wbrio.usuarios ")
                    			 	       .append("      , wbrio.parametros p ")
                    			 	       .append("      , wbrio.parametros p2 ")
                    			 	       .append("  WHERE p.nome = 'dias_expiracao_senha' ")
                    			 	       .append("    AND p2.nome = 'dias_aviso_expiracao_senha' ")
                    			 	       .append("    AND usua_usuario = ?" ).toString());
                              	pstm.setString(1,user);
                              	rset = pstm.executeQuery();
                              	if(rset.next()) {
                              		dt_vencimento = rset.getString(1)+"";
                              		venceu = rset.getString(3)+"";
                              		aviso = rset.getString(4)+"";
                              		dias  = rset.getInt(5);
                              		usua_super = rset.getString(6);
                              		usua_expira_senha = rset.getString(7);
                              	}
                              	rset.close();
                              	pstm.close();
								if (venceu.equals("S") && (!user.equals("40000")) && (!usua_super.equals("S"))
										&& (usua_expira_senha.equals("S"))) {
									se.setAttribute("senha_venceu", "S");
								} else {
									se.setAttribute("senha_venceu", "N");
								}
								if (aviso.equals("S") && usua_expira_senha.equals("S") && usua_super.equals("N")
										&& (!user.equals("40000"))) {
									se.setAttribute("data_vencimento", dt_vencimento);
									se.setAttribute("dias_vencimento", dias);
								}                        
                     }
//-------------------------------------------------------------------------------------------------------                     
							se.setAttribute("User", usuario);
							acesso.Sessao sessao = new acesso.Sessao(se);
							if (sessao.getTipoEntidadeNegocio().equals("CLIENTE MERCADO INTERNO")) {
								se.setAttribute("abre_menu", "s");
							} else {
								se.setAttribute("abre_menu", "n");
							}
                     
//------------------ Se for FORNECEDOR mostra a cartilha ---------------------------------
							if (sessao.getTipoEntidadeNegocio().equals("FORNECEDOR")) {
								se.setAttribute("mostracartilha", "s");
							}
//------------------ Se mostra a mensagem 3 bilhoes ---------------------------------
							try {
							Query query = new Query();	
							String superUsuario = query.retorna("SELECT usua_super FROM wbrio.usuarios WHERE usua_id = " + sessao.getId());
							if (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")
									||sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")
									||sessao.getTipoEntidadeNegocio().equals("AREAS")
									||superUsuario.equalsIgnoreCase("S")
									) {
								String retorno = query.retorna("SELECT valor FROM wbrio.parametros WHERE par_sist_codigo = 'BRPORTAL' AND nome = 'mensagem_3_bilhoes'");
								if(retorno.equalsIgnoreCase("S")){
									se.setAttribute("mostra3bilhoes", "s");
								}
							} 
							} catch (Exception e){
								e.printStackTrace(System.err);
							}

//------------------ Atualiza a data de último acesso do Usuário ----------------------------------------
							pstm = j.getConn().prepareStatement(
						  new StringBuilder(" UPDATE usuarios ")
									.append("    SET usua_dt_ultimo_acesso = sysdate ")
									.append("      , usua_acessos = usua_acessos + 1 ")
									.append("  WHERE usua_usuario = ?").toString());
							pstm.setString(1, user);
							pstm.executeUpdate();
							pstm.close();
//------------------ Registra o acesso ------------------------------------------------------------------
                    boolean existe = false;
                    pstm = j.getConn().prepareStatement(
                            new StringBuilder(" SELECT 1 ")
                                      .append("   FROM wbrio.log_acessos_usuarios ")
                                      .append("  WHERE usua_id = ? ")
                                      .append("    AND ip      = ?").toString());

                             pstm.setInt(1, usuario.getId());
                             pstm.setString(2, req.getRemoteAddr());
                             
                             rset = pstm.executeQuery();
                             if(rset.next()) {
                            	 existe = true;
                             }
                             rset.close();
                             pstm.close();
                    try {
                    	String sql = null;
                    	if(existe){
                    		sql = new StringBuilder(" UPDATE wbrio.log_acessos_usuarios ")
                    			            .append("    SET data_acesso = sysdate ")
                    			            .append("  WHERE usua_id = "+usuario.getId())
                    			            .append("    AND ip = '"+req.getRemoteAddr()+"'").toString();
                    	} else {
                    		sql = new StringBuilder(" INSERT INTO wbrio.log_acessos_usuarios ")
                    			            .append(" VALUES ("+usuario.getId())
                    			            .append("        , '"+req.getRemoteAddr()+"'")
                    			            .append("        , sysdate )").toString();
                    	}
                    	pstm = j.getConn().prepareStatement(sql);
                    	pstm.executeUpdate();
                    } catch (Exception e){
                    	e.printStackTrace();
                    } finally {
                    	pstm.close();	
                    }

                    String sURL = (String)se.getAttribute("URL");
                    if(sURL == null) {
                        sURL = req.getRequestURL().toString();
                        int iHost = sURL.indexOf("/", 7);
                        String sHostURL;
                        if(iHost > 6) {
                            sHostURL = sURL.substring(0, iHost);
                        } else {
                            sHostURL = sURL;
                        }
                        sURL = (new StringBuilder(String.valueOf(sHostURL))).append(req.getContextPath()).toString();
                    } else {
                        se.removeAttribute("URL");
                    }

                    if(usuario.getAcessos() == 0) {
                        res.sendRedirect((new StringBuilder(String.valueOf(req.getContextPath()))).append("/acesso/TrocaSenhaForm.jsp").toString());
                    } else {
                    	String tipo = null;
                        acesso.Usuario u = new acesso.Usuario();
                        u = (acesso.Usuario)se.getAttribute("User");
                        acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
                        acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
                        if(!(u.getEntidadeNegocio()==null)){
                             ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                             tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
                             tipo = tipoent.getTipo().toString();
                             if(tipo.equals("CLIENTE MERCADO EXTERNO")){
                            	 sURL = "../system/language.jsp";
                             }
                        }
                        res.sendRedirect(sURL);
                    }

                } else {
                    showError(req, res, "Senha inv\341lida!");
                }
            } else {
                pstm.close();
                showError(req, res, "Usu\341rio n\343o reconhecido.");
            }
        } // clientes novos MI
        
        
            } else {   
            	 // teste cgc
                 StringBuilder sb = new StringBuilder();
             	 sb.append(" SELECT /*+ all_rows */ 1 ");
   			     sb.append("   FROM cli c ");
           	     sb.append("      , esc e ");
           	     sb.append("  WHERE c.cli_cdgo = e.cli_cdgo ");
           	     sb.append("    AND c.cli_cdgo = ? ");
           	     sb.append("    AND lpad(to_char(esc_cgc),14,0) = lpad(?,14,0) ");
           	     sb.append("    AND rownum     = 1 ");       
            	 pstm = j.getConn().prepareStatement(sb.toString());
                 pstm.setString(1, (String)se.getAttribute("novo_cliente_cli"));
                 pstm.setString(2, cgc);
                 rset = pstm.executeQuery();
                 if(rset.next()) {
              	    UsuarioAPI usuario_novo = cadastraClienteMercadoInterno((String)se.getAttribute("novo_cliente_cli"), cgc);
                    se.setAttribute("User", usuario_novo);
                    se.setAttribute("abre_menu","s");
                    res.sendRedirect((new StringBuilder(String.valueOf(req.getContextPath()))).append("/acesso/TrocaSenhaForm.jsp").toString());                    	 
                 } else {
                	 showError(req, res, "CNPJ inv\341lido!");
                 }
            }
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (j != null) {
				j.close();
				j = null;
			}
		}
	}

    private UsuarioAPI cadastraClienteMercadoInterno(String cliente, String cgc) throws Exception {
    	util.consultas.Query query = new util.consultas.Query();
    	int id_usuario = 0;
    	PreparedStatement pstm = null;
        ResultSet rset = null;
        PreparedStatement pstm1 = null;
        ResultSet rset1 = null;
        PreparedStatement pstm2 = null;
        ResultSet rset2 = null;
        UsuarioAPI usuario_cadastrado = null;
        com.egen.util.jdbc.JdbcUtil j = null;
    	try {
    		j = new com.egen.util.jdbc.JdbcUtil();
            StringBuilder sb = new StringBuilder();
    	    sb.append(" select e.enne_id ");
    	    sb.append("   from wbrio.entidades_negocio e "); 
    	    sb.append("  where e.enne_tien_id = 2194 ");
    	    sb.append("    and e.enne_chave   = ? ");       
       	    pstm = j.getConn().prepareStatement(sb.toString()); 
       	    pstm.setString(1, cliente);
            rset = pstm.executeQuery();
            if(!rset.next()) {
                acesso.EntidadeNegocioAPI entidade = new acesso.EntidadeNegocioAPI(j.getConn());
                acesso.TipoEntidadeNegocioAPI tipoentidade = new acesso.TipoEntidadeNegocioAPI(j.getConn(),Integer.parseInt("2194"));
                entidade.setChave(cliente);
                entidade.setDescricao("");
                entidade.setTipoEntidadeNegocio(tipoentidade);
                entidade.insert();
            }
            StringBuilder sb2 = new StringBuilder();
    	    sb2.append(" select e.enne_id ");
    	    sb2.append("      , substr(c.cli_nome,0,40) cli_nome ");
            sb2.append("  from wbrio.entidades_negocio e ");
            sb2.append("     , cli c ");
            sb2.append(" where c.cli_cdgo     = ? "); 
            sb2.append("   and e.enne_tien_id = 2194 ");
            sb2.append("   and to_char(c.cli_cdgo) = e.enne_chave ");
       	    pstm1 = j.getConn().prepareStatement(sb2.toString()); 
       	    pstm1.setString(1, cliente);
            rset1 = pstm1.executeQuery();
            if(rset1.next()) {
                acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn());
                acesso.EntidadeNegocioAPI enne = new acesso.EntidadeNegocioAPI(j.getConn());
                enne.select(Integer.parseInt(rset1.getString(1)));
                usuario.setEntidadeNegocio((acesso.EntidadeNegocio) enne);
                usuario.setNome(rset1.getString(2).toUpperCase());
                usuario.setUsuario(cliente);
                usuario.setUsuarioInclusao(cliente);
                usuario.setSenha("beirario".getBytes());
                usuario.setExpiraSenha("S");
                usuario.setSuperUsuario(false);
                usuario.setDiasConsultaRetroativa(0);
                usuario.setEmail(query.retorna("SELECT esc_email FROM esc WHERE esc_situacao = 'A' AND esc_cgc = " + cgc));
                usuario.setAcessos(1);
                usuario.insert();
                pstm2 = j.getConn().prepareStatement(" select usua_id from wbrio.usuarios where usua_usuario = upper('"+cliente+"') ");
                rset2 = pstm2.executeQuery();
                if (rset2.next()) {
                	id_usuario = rset2.getInt(1);
          	    }                
                acesso.AcessoDocumentoInterfaceAPI adi = new acesso.AcessoDocumentoInterfaceAPI(j.getConn());
                adi.geraAutorizacoesUsuario(id_usuario);
                usuario_cadastrado = new UsuarioAPI(j.getConn(), id_usuario);
            }       	                
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (rset1 != null) {
				rset1.close();
			}
			if (pstm1 != null) {
				pstm1.close();
			}
			if (rset2 != null) {
				rset2.close();
			}
			if (pstm2 != null) {
				pstm2.close();
			}
			if (j != null) {
				j.close();
				j = null;
			}
		}
    	return usuario_cadastrado;
    }
    
    private void fecharConexoes(ResultSet rs, PreparedStatement pm) {
 		if (rs != null) {
 			try {
 				rs.close();
 			} catch (SQLException e) {
 				e.printStackTrace();
 			}
 		}
 		if (pm != null) {
 			try {
 				pm.close();
 			} catch (SQLException e) {
 				e.printStackTrace();
 			}
 		}
 	}
    
	public static String getClientIpAddr(final HttpServletRequest request) {
		final String unknown = "unknown";
		String ipAddress = request.getHeader("X-Forwarded-For");
		if (ipAddress == null || ipAddress.length() == 0 || unknown.equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || unknown.equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || unknown.equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || unknown.equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ipAddress == null || ipAddress.length() == 0 || unknown.equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
		}
		return ipAddress;
	}

}

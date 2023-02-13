package acesso.web;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

//import br.com.pontosoft.acesso.bean.UsuarioPonto;

public class GeraMenu {

	public static String gera(HttpServletRequest request) throws Exception {
		//HttpSession sessao = request.getSession();
		//UsuarioPonto usuario = (UsuarioPonto) sessao.getAttribute("usuario");
		StringBuilder menu = new StringBuilder();
		java.sql.ResultSet rset = null;
		java.sql.PreparedStatement pstm = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			pstm = j.getConn().prepareStatement(
					new StringBuilder(" SELECT menu_id, menu_nome, menu_texto FROM wbrio.menus  WHERE menu_pai_menu_id IS NULL ORDER BY menu_nome ASC ").toString());  							  
//			pstm.setString(1, usuario.getAdministrador());
//			pstm.setString(2, usuario.getUsuario());
			rset = pstm.executeQuery();
			menu.append("<ul>");
			while(rset.next()){
			   menu.append("<li>");
               menu.append(rset.getString(3));
               geraSubMenu(j, menu, rset.getInt(1)/*, usuario*/);
               menu.append("</li>");
			}
			menu.append("</ul>");
			if(rset!=null){rset.close();}
			if(pstm!=null){pstm.close();}
			} finally {
			if(j!=null){
				j.close();
			}
		}
		
		return menu.toString();
			
	}
	
	public static void geraSubMenu(com.egen.util.jdbc.JdbcUtil j,StringBuilder menu, int menuPai/*, UsuarioPonto usuario*/) throws SQLException{
		java.sql.ResultSet rset = null;
		java.sql.PreparedStatement pstm = null;
		try {
			pstm = j.getConn().prepareStatement(
					
					new StringBuilder(" SELECT menu_id, menu_nome, menu_texto FROM wbrio.menus  WHERE menu_pai_menu_id = ? ORDER BY menu_nome ASC ").toString());							  
			pstm.setInt(1, menuPai);
//			pstm.setString(2, usuario.getAdministrador());
//			pstm.setString(3, usuario.getUsuario());
			rset = pstm.executeQuery();
			while(rset.next()){
			   menu.append("<ul><li>");
			   //if((rset.getString(4)+"").equals("null")){
				   menu.append(rset.getString(2));
			   //} else {
				 //  menu.append("<a href=\"/insoft/cadastros/"+rset.getString(4)+"WFForm.jsp\" target=\"main\">"+rset.getString(2)+"</a>");
			   //}
			   geraSubMenu(j, menu, rset.getInt(1)/*, usuario*/);
               menu.append("</li></ul>");
			}			
		} finally {
			if(rset!=null){
				rset.close();
			}
			if(pstm!=null){
				rset.close();
			}
		}
	}
	
	
}

					
					
package acesso.web;

import acesso.*;

import java.sql.*;

public class TreeMenuBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Connection conn;
	private String contextPath;
	private StringBuilder out;

	public void setConnection(Connection conn) {
		this.conn = conn; 
	}

	public void setContextPath(String context) {
		this.contextPath = context;
	}

	public void showMenu(MenuAPI menu) throws SQLException {
		Menu menuPai = menu.getMenuPai();
		if (menuPai == null) {
			out.append("d.add(").append(menu.getId()).append(", 0, '").append(menu.getTexto()).append("', '");
			out.append(this.contextPath).append("/acesso/NavegacaoForm.do?select_action=&menu_id=");
			out.append(menu.getId()).append("', null, null, '").append(this.contextPath);
			out.append("/img/folder.gif', '").append(this.contextPath).append("/img/folderopen.gif');");
		} else {
			out.append("d.add(").append(menu.getId()).append(", ").append(menuPai.getId()).append(", '");
			out.append(menu.getTexto()).append("', '").append(this.contextPath);
			out.append("/acesso/NavegacaoForm.do?select_action=&menu_id=").append(menu.getId());
			out.append("', null, null, '").append(this.contextPath).append("/img/folder.gif', '");
			out.append(this.contextPath).append("/img/folderopen.gif');");
		}
		for (ItemMenuAPI itemMenu : menu.getItens()) {
			out.append("d.add(").append(itemMenu.getId()).append(", ").append(menu.getId()).append(", '");
			out.append(itemMenu.getTexto()).append("', '").append(this.contextPath);
			out.append("/acesso/ItemNavegacaoForm.do?select_action=&itme_id=");
			out.append(itemMenu.getId()).append("');");
		}
		for (MenuAPI subMenu : menu.getSubMenus()){
			showMenu(subMenu);
		}
	}

	public String toString() {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			this.out = new StringBuilder();
			this.out.append("<link rel=\"StyleSheet\" href=\"").append(this.contextPath).append("/css/dtree.css\" type=\"text/css\" />");
			this.out.append("<script type=\"text/javascript\" src=\"").append(this.contextPath).append("/script/dtree.js\"></script>");
			this.out.append("<div id=\"menu_acesso\" class=\"dtree\">");
			this.out.append("<p><a href=\"javascript:d.openAll();\">Expandir tudo</a> | <a href=\"javascript:d.closeAll();\">Fechar tudo</a></p>");
			this.out.append("<script type=\"text/javascript\">");
			this.out.append("d = new dTree('d');");
			this.out.append("d.add(0,-1,'BR Portal');");
			if (this.conn == null){
				throw new SQLException("A conexão com o banco não foi passada.");
			}
			pstm = this.conn.prepareStatement(
					new StringBuilder(" SELECT menu_id ")
							  .append("   FROM menus ")
							  .append("  WHERE menu_pai_menu_id IS NULL ")
							  .append("    AND menu_codigo_sistema = 'BRNET' ")
							  .append("  ORDER BY menu_texto ").toString()
					);
			rset = pstm.executeQuery();
			MenuAPI menu;
			while (rset.next()) {
				menu = new MenuAPI(this.conn);
				menu.select(rset.getInt(1));
				showMenu(menu);
			}
			this.out.append("document.write(d);");
			this.out.append("</script>");
			this.out.append("</div>");

		}
		catch (SQLException e) {
			this.out.append(e.getMessage());
		} finally {
			try {
				if(rset!=null){
					rset.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstm!=null){
					pstm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return this.out.toString();
	}
}

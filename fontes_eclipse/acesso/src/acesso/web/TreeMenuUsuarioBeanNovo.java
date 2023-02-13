package acesso.web;

import acesso.*;

import java.sql.*;
import java.util.Iterator;
import java.util.MissingResourceException;

public class TreeMenuUsuarioBeanNovo implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Connection conn;
    private Usuario usuario;
    private String contextPath;
    private StringBuilder out;

    public TreeMenuUsuarioBeanNovo() {}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setConnection(Connection conn) {
        this.conn = conn;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setContextPath(String context) {
        contextPath = context;
    }

    private int addItens(MenuAPI menu, StringBuilder buf) throws SQLException {
        int itens = 0;
        for(Iterator<?> iterator = menu.getItens().iterator(); iterator.hasNext();) {
            ItemMenuAPI itemMenu = (ItemMenuAPI)iterator.next();
            if(itemMenu.autorizado(usuario)) {
                AcessoDocumentoInterface acdi = itemMenu.getAcesso(usuario);
                if(acdi == null || !acdi.isFavorito()) {
                	buf.append((new StringBuilder("d.add(")).append(itemMenu.getId()).append(", ").append(menu.getId()).append(", '<a href=\"").append(itemMenu.getComando(contextPath)).append("\">").append(getTexto(itemMenu)).append("</a>&nbsp;&nbsp;").append("<a href=\"javascript:favoritos.addFavorit(").append(itemMenu.getDocumentoInterface().getId()).append(", \\'").append(itemMenu.getComando(contextPath)).append("\\', \\'").append(getTexto(itemMenu)).append("\\')\"><img src=\"").append(contextPath).append("/img/list_favoritos.gif\" title=\"").append(java.util.ResourceBundle.getBundle("ApplicationResources").getString("header.adicionarfavoritos")).append("\" height=\"16\" border=\"0\"></a>").append("', null, null, '_top');").toString());
                } else {
                    buf.append((new StringBuilder("d.add(")).append(itemMenu.getId()).append(", ").append(menu.getId()).append(", '<a href=\"").append(itemMenu.getComando(contextPath)).append("\">").append(getTexto(itemMenu)).append("</a>").append("', null, null, '_top');").toString());
                }
                itens++;
            }
        }
        return itens;
    }

    private String getTexto(ItemMenuAPI item){
    	String retorno = null;
    	try {
    		retorno = java.util.ResourceBundle.getBundle("ItensMenuResources").getString(((Integer)item.getId()).toString());
    	//} catch (MissingResourceException e){
    	} catch (Exception e){
    		retorno = item.getTexto();
    	}
    	return retorno;
    }

    private int addMenus(MenuAPI menu, StringBuilder buf) throws SQLException {
        StringBuilder mBuf = new StringBuilder();
        int menus = 0;
        int itens = 0;
        for(Iterator<?> iterator = menu.getSubMenus().iterator(); iterator.hasNext();) {
            MenuAPI subMenu = (MenuAPI)iterator.next();
            if(addMenus(subMenu, mBuf) > 0) {
                menus++;
            }
        }

        Menu menuPai = menu.getMenuPai();
        String pai = "0";
        if ((!(menuPai == null))){
        	pai = menuPai.getId()+"";
        }

        itens = addItens(menu, mBuf);
        if(itens + menus > 0) {
        	buf.append((new StringBuilder("d.add(")).append(menu.getId()).append(", ").append(pai).append(", '").append(java.util.ResourceBundle.getBundle("MenuResources").getString(((Integer)menu.getId()).toString())).append("', null, null, null, '").append(contextPath).append("/img/folder.gif', '").append(contextPath).append("/img/folderopen.gif');").toString());        	
        	buf.append(mBuf.toString());
            menus++;
        }
        return menus;
    }

    public String toString() {
    	PreparedStatement pstm = null;
    	ResultSet rset = null;
        try {
            out = new StringBuilder();
            out.append((new StringBuilder("<link rel=\"StyleSheet\" href=\"")).append(contextPath).append("/css/dtree.css\" type=\"text/css\" />").toString());
            out.append((new StringBuilder("<script type=\"text/javascript\" src=\"")).append(contextPath).append("/script/dtree.js\"></script>").toString());
           // out.append((new StringBuilder("<script type=\"text/javascript\" src=\"")).append(contextPath).append("/script/favoritos.js\"></script>").toString());
            out.append("<table width=\"100%\"><tr valign=\"top\"><td>");
            out.append("<div id=\"menu_acesso\" class=\"dtree\">");
            out.append("<p><a href=\"javascript:d.openAll();\">").append(java.util.ResourceBundle.getBundle("ApplicationResources").getString("jsp.openall")).append("</a> | <a href=\"javascript:d.closeAll();\">").append(java.util.ResourceBundle.getBundle("ApplicationResources").getString("jsp.closeall")).append("</a></p>");
            out.append("<script type=\"text/javascript\">");
            //out.append((new StringBuilder("favoritos = new FavoritList('favoritos', '")).append(contextPath).append("/img','").append(java.util.ResourceBundle.getBundle("ApplicationResources").getString("header.favoritos")).append("','").append(java.util.ResourceBundle.getBundle("ApplicationResources").getString("header.removerfavoritos")).append("');").toString());
            out.append("d = new dTree('d');");
            out.append("d.add(0,-1,'BR Portal');");
            
            if(conn == null) {
                throw new SQLException("A conex\343o com o banco n\343o foi passada.");
            }
            
            StringBuilder sb2 = new StringBuilder();
    		sb2.append(" SELECT menu_id ");
    		sb2.append("   FROM menus ");
    		sb2.append("  WHERE menu_pai_menu_id is null ");
    		sb2.append("  ORDER BY menu_texto ");
            pstm = conn.prepareStatement(sb2.toString());
            MenuAPI menu;
            for(rset = pstm.executeQuery(); rset.next(); addMenus(menu, out)) {
                menu = new MenuAPI(conn);
                menu.select(rset.getInt(1));
            }
            rset.close();
            pstm.close();
            out.append("document.write(d);");
            out.append("</script>");
            out.append("</div></td><td align=\"right\">");
            out.append("<script type=\"text/javascript\">");
            //createFavortList();
            //out.append("document.write(favoritos);");
            out.append((new StringBuilder("favoritos.setAddURL('")).append(contextPath).append("/HttpServletFavoritos?action=add&doin_id=<id>');").toString());
            out.append((new StringBuilder("favoritos.setDelURL('")).append(contextPath).append("/HttpServletFavoritos?action=del&doin_id=<id>');").toString());
            out.append("</script>");
            out.append("</td></tr></table>");
        }
        catch(SQLException e){
            out.append(e.getMessage());
        } finally {
        	if(rset!=null){
        		try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	}
        	if(pstm!=null){
        		try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	}
        }
        return out.toString();
    }
}

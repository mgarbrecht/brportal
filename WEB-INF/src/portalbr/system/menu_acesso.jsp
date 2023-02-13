<%@ page import="acesso.*, java.util.*, java.io.*, java.sql.*"%>
<%@ page extends="acesso.web.HttpJspSessao"%>
<%@ page errorPage="/err/errorpage.jsp"%><jsp:useBean id="menuGeral" scope="request" class="acesso.web.MenuBean">
	<jsp:setProperty name="menuGeral" property="connection" value="<%= (Connection) session.getAttribute("ConnectionJDBC") %>" />
	<jsp:setProperty name="menuGeral" property="usuario" value="<%= (Usuario) session.getAttribute("User") %>" />
</jsp:useBean>
<%!
  public void showSubMenus(MenuAPI menu, HttpServletRequest req, JspWriter out)
    throws SQLException, IOException {
    Menu menuPai = menu.getMenuPai();
    if (menuPai == null)
      out.println("d.add(" + menu.getId() + ", 0, '" + menu.getTexto() + "', '" + req.getContextPath()
          + "/acesso/NavegacaoForm.do?select_action=&menu_id=" + menu.getId() + "', null, null, '"
          + req.getContextPath() + "/img/folder.gif', '"
          + req.getContextPath() + "/img/folderopen.gif');");
    else
      out.println("d.add(" + menu.getId() + ", " + menuPai.getId() + ", '" + menu.getTexto() + "', '" + req.getContextPath()
          + "/acesso/NavegacaoForm.do?select_action=&menu_id=" + menu.getId() + "', null, null, '"
          + req.getContextPath() + "/img/folder.gif', '"
          + req.getContextPath() + "/img/folderopen.gif');");
    for (ItemMenuAPI itemMenu : menu.getItens())
      out.println("d.add(" + itemMenu.getId() + ", " + menu.getId() + ", '" + itemMenu.getTexto() + "', '" + req.getContextPath()
          + "/acesso/ItemNavegacaoForm.do?select_action=&itme_id=" + itemMenu.getId() + "');");
    for (MenuAPI subMenu : menu.getSubMenus())
      showSubMenus(subMenu, req, out);
  }
%>
<link rel="StyleSheet" href="<%= request.getContextPath() %>/css/dtree.css" type="text/css" />
<script type="text/javascript" src="<%= request.getContextPath() %>/script/dtree.js"></script>
<div id="menu_acesso" class="dtree">
<script type="text/javascript">
  d = new dTree('d');
  d.add(0,-1,'BR Portal');
<%
  ArrayList<MenuAPI> menus = menuGeral.getMenus();
  for (MenuAPI menu : menus)
    showSubMenus(menu, request, out);
%>
  document.write(d);
</script>
</div>
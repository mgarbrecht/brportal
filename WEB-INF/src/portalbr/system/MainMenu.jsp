<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page  extends='acesso.web.HttpJspSessao' %>
<html>
  <head>

    <title>
      Menu de Acesso
    </title>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
    <SCRIPT>
      function right(e) {
        if (navigator.appName == 'Netscape' && (e.which == 3 || e.which == 2))
        return false;
        else if (navigator.appName == 'Microsoft Internet Explorer' && (event.button == 2 || event.button == 3)) {
          alert("Permissão negada.");
          return false;
        }
        return true;
      }
      document.onmousedown=right;
      document.onmouseup=right;
      if (document.layers) window.captureEvents(Event.MOUSEDOWN);
      if (document.layers) window.captureEvents(Event.MOUSEUP);
      window.onmousedown=right;
      window.onmouseup=right;
    </SCRIPT>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:99%;'>
        <tr>
          <td>
            <table   class="headerTable" style="width:99%" >
              <tr>
                <td class='td10'>
                  <%@ include file="../system/header_menu.jsp" %>
                </td>
              </tr>
            </table>
            <html:form action="system/MainMenu.do" method="POST" styleClass="baseForm">
              <html:submit value="logout" styleClass="myhidden" property="logout_action">
              </html:submit>
            </html:form>

            <form class="baseForm">
              <table style=width:100%;margin-top:10;>
                <tr>
                  <td>
                    <link rel="StyleSheet" href="../css/dtree.css" type="text/css" />
                    <script type="text/javascript" src="../script/dtree.js">
                    </script>
                    <div class="dtree">
                      <p>
                        <a href="javascript: bl_menu.openAll();">
                          <bean:message key="jsp.openall"/>
                        </a>
                        |
                        <a href="javascript: bl_menu.closeAll();">
                          <bean:message key="jsp.closeall"/>
                        </a>
                      </p>
                      <script type="text/javascript">
                        bl_menu = new dTree('bl_menu');
                        bl_menu.add(0,-1,'');

                        bl_menu.add(1,0,'Acesso','','');

                        bl_menu.add(2,1,'Tipos de Entidade de Negócio','../acesso/TiposEntidadeNegocioForm.jsp','','_self','');
                        bl_menu.add(3,1,'Entidades de Negócio','../acesso/EntidadesNegocioForm.jsp','','_self','');
                        bl_menu.add(4,1,'Usuários','../acesso/UsuariosForm.jsp','','_self','');
                        bl_menu.add(5,0,'Relatórios','','');

                        bl_menu.add(6,5,'Clientes Ativos','../adm/Clientes_atendidosForm.jsp','','_self','');
                        document.write(bl_menu);
                      </script>
                    </div>
                  </td>
                </tr>
              </table>
            </form>
          </td>
        </tr>
      </table>
    </body>
  </center>
</html>

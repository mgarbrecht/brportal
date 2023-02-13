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
                  <%@ include file="../adm/header_menu.jsp" %>
                </td>
              </tr>
            </table>
            <html:form action="system/MainMenu.do" method="POST" styleClass="baseForm">
              <html:submit value="logout" styleClass="myhidden" property="logout_action">
              </html:submit>
            </html:form>

          </td>
        </tr>
      </table>
    </body>
  </center>
</html>

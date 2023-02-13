<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <title>
      <bean:message key="page.title"/>
    </title>

    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
    <script type="text/javascript">
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
    </script>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:780px;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable">
              <tr class="headerTr">
                <td class="headerTd">
                  <bean:message key="page.title"/>
                </td>
                <td>
                  <div class='div10'>
                    <jsp:useBean id="now" class="java.util.Date" />
                    <fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss" value="${now}" />
                  </div>
                </td>
              </tr>
            </table>

            <html:form action="system/LogonForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="bannerTable" style="width:780px;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    <bean:message bundle="ApplicationResources" key="login.title"/>

                  </td>
                </tr>
              </table>

              <table class="messageTable" style='width:780px;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:780px;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ApplicationResources" key="login.username"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="username" styleClass="baseField" size="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ApplicationResources" key="login.password"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:password property="password" styleClass="baseField" size="30"/>
                  </td>
                </tr>

                <html:hidden property="language"/>
              </table>

              <table class="buttonTable" style='width:780px;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit styleClass="baseButton" property="logon_action">
                      <bean:message bundle="ApplicationResources" key="login.login"/>
                    </html:submit>
                    <html:submit styleClass="baseButton" property="logout_action">
                      <bean:message bundle="ApplicationResources" key="login.logout"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="a" value="mostra" styleClass="baseButton" property="mostra_query_action">
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["username"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

          </td>
        </tr>
      </table>

    </body>
  </center>
</html>

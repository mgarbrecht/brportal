<%@ include file="../system/HeaderStrutsForm.jsp"%>
<html>
  <head>
    <title>
      <bean:message key="page.title"/>
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
            <table class="headerTable">
              <tr>
                <td class='td10'>
                  <bean:message key="page.title"/>
                </td>
                <td>
                  <div class='div10'>
                    <%= com.egen.util.text.FormatDate.getTimestamp() %>
                  </div>
                </td>
              </tr>
            </table>
            <html:form action="system/LogonForm.do" method="POST" scope="session" styleClass="baseForm" target="_self">
              <table class="bannerTable" style='width:99%;'>
                <tr>
                  <td class=tableHeader>
                    <bean:message bundle="ApplicationResources" key="login.title"/>

                  </td>
                </tr>
              </table>
              <table class="messageTable" style='width:99%;'>
                <tr>
                  <td class="messageHeader">
                    <html:errors/>
                  </td>
                </tr>
              </table>
              <table class="itemTable" style='width:99%;'>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      <bean:message bundle="ApplicationResources" key="login.username"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="username" styleClass="baseField" size="30"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      <bean:message bundle="ApplicationResources" key="login.password"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:password property="password" styleClass="baseField" size="30"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      jsp.language
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="language" styleClass="baseField" value="<%= (String)session.getAttribute("org.apache.struts.action.LOCALE") %>"/>
                  </td>
                </tr>
              </table>
              <table class="buttonTable" style='width:99%;'>
                <tr>
                  <td class="buttonItem">
                    <html:submit styleClass="baseButton" property="logon_action">
                      <bean:message bundle="ApplicationResources" key="login.login"/>
                    </html:submit>
                    <html:submit styleClass="baseButton" property="logout_action">
                      <bean:message bundle="ApplicationResources" key="login.logout"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                  </td>
                </tr>
              </table>
            </html:form>
            <script type="text/javascript" language="JavaScript">
              <!--
              var focusControl = document.forms[0].elements["username"];
              if (focusControl.type != "hidden") {
                focusControl.focus();
              }
            // -->
            </script>

          </td>
        </tr>
      </table>
    </body>
  </center>
</html>

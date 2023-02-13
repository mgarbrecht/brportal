<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Troca de Identidade
    </title>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                </td>

              </tr>

            </table>

            <html:form action="acesso/DirectForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Usuarios"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <html:hidden property="usua_usuario"/>
                <html:hidden property="usua_id"/>
                <html:hidden property="usua_senha"/>
                <html:hidden property="usua_tipo"/>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <%
                    if (session.getAttribute("usuarioInexistente") == null) {
                      %>
                      <html:submit accesskey="s" value="Logar" styleClass="myhidden" property="select_action">
                      </html:submit>
                      <%
                    }
                    %>
                    <%
                    if (session.getAttribute("usuarioInexistente") == null) {
                      %>
                      <html:submit accesskey="r" styleClass="myhidden" property="resetfull_action">
                        <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:submit>
                      <%
                    }
                    %>
                    <%
                    if (session.getAttribute("usuarioInexistente") == null) {
                      %>
                      <html:submit accesskey="p" styleClass="myhidden" property="select1_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <%
                    }
                    %>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["usua_usuario"];
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

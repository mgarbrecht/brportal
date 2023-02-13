<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:100%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="com/DownloadImagens_eForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:100%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="email"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:100%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Email
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="email" styleId="email" styleClass="baseField" size="80"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:100%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit value="Enviar email" styleClass="baseButton" property="enviar_email_action">
                    </html:submit>
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["email"];
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

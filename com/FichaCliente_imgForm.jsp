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
            <html:form action="com/FichaCliente_imgForm.do" method="post" styleClass="baseForm">


              <table  style='width:100%;'>
                <tr >
                  <td >
                    <center>
                      <img src='../imagens/grandes/<%= request.getAttribute("imagem") %>' />
                    </center>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:100%;">
                <html:hidden property="linha"/>
                <html:hidden property="referencia"/>
              </table>

              <table class="buttonTable" style='width:100%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" property="select_action" styleClass="myhidden">
                      <bean:message bundle="ApplicationResources" key="jsp.select" />
                    </html:submit>
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                  </td>
                </tr>
              </table>

            </html:form>
          </td>
        </tr>
      </table>

    </body>
  </center>
</html>

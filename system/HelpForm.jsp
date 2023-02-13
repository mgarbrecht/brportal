<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:640;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="system/HelpForm.do" method="POST" styleClass="baseForm">
              <table class="itemTable" style='width:;'>
              </table>
              <table class="separatorTable">
                <tr class="separatorTr">
                  <td colspan="2" class="separatorTd" align="center">
                    <b>
                      Ajuda
                    </b>
                  </td>
                </tr>
                <tr>
                  <td>
                    <img src="c:/ajuda2.jpg">
                  </td>
                </tr>
              </table>
              <table class="itemTable" style='width:100%;'>
              </table>
            </html:form>

          </td>
        </tr>
      </table>

    </body>
  </center>
</html>

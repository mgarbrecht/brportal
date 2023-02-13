<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <title>
      <bean:message key="page.title"/>
    </title>

    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
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

            <table class="footerTable">
              <tr class="footerTr">
                <td class="footerTd">
                  <bean:message key="div.print"/>
                </td>
              </tr>

            </table>

          </td>
        </tr>
      </table>

    </body>
  </center>
</html>

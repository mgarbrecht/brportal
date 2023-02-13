<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:10%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="system/TrocaSenhaDiretaForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <html:hidden property="chave"/>
                <table class="buttonTable" style='width:10%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
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

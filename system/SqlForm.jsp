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
            <html:form action="system/SqlForm.do" method="post" styleClass="baseForm">


              <table>
                <html:hidden property="query"/>
                <%
                if(request.getAttribute("retorno")!=null){
                  out.println((String)request.getAttribute("retorno"));
                }  else {
                }
                %>
              </table>


              <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                <bean:message bundle="ApplicationResources" key="jsp.select"/>
              </html:submit>


            </html:form>
          </td>
        </tr>
      </table>

    </body>
  </center>
</html>

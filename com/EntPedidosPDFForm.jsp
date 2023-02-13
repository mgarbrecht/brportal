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
            <html:form action="com/EntPedidosPDFForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <%
                if((String)request.getAttribute("abre_automaticamente")=="N"){
                  %>
                  <table style=width:100%;margin-top:10;>
                    <tr>
                      <td class=columHeader style="text-align:center;">
                        <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                          <bean:message key="report.downloadpdf"/>
                        </a>
                      </td>
                    </tr>
                  </table>
                  <%
                }
                %>
                <table class="buttonTable" style='width:100%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:button accesskey="f" onclick="parent.tb_remove();" styleClass="baseButton" property="close_action">
                        <bean:message bundle="ApplicationResources" key="jsp.close"/>
                      </html:button>
                      <html:submit styleClass="myhidden" property="select_action">
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Download Arquivos
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

            <html:form action="com/ArquivosOrdemCompra_gForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_ordem_compra"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <html:hidden property="interface_arq_compra_id"/>
                <%
                if(request.getAttribute("arquivo")!=null){
                  String arquivo = (String)request.getAttribute("arquivo");
                  %>
                  <table style=width:100%;margin-top:10;>
                    <tr>
                      <td class=columHeader style="text-align:center;">
                        <%
                        if(arquivo.indexOf(".zip")!=-1){
                          %>
                          <a href="<%= arquivo %>" target="_blank" onclick="window.close();">
                            Clique para baixar o arquivo
                            <img src="../img/rar.gif" />
                          </a>
                          <%
                        } else {
                          %>
                          <a href="<%= arquivo %>" target="_blank" onclick="jQuery.post('ArquivosOrdemCompra_gForm.do?update_action=&tipo=v',function(){window.close();})">
                            <bean:message key="report.downloadpdf"/>
                          </a>
                          <%
                        }
                        %>
                      </td>
                    </tr>
                  </table>
                  <%
                }
                %>


                <html:hidden property="tipo"/>
                <html:hidden property="arquivo"/>
                <html:hidden property="oco_numero"/>
                <html:hidden property="forn_codigo"/>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                    <html:submit accesskey="a" styleClass="myhidden" property="update_action">
                      <bean:message bundle="ApplicationResources" key="jsp.update"/>
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

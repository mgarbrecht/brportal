<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>

  <center>
    <body>
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>
                  <%@ include file="../system/header_blank.jsp" %>
                <td>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(208)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            {
              %>

              <%
              java.util.List<String> res_Imagens = (java.util.List<String>)session.getAttribute("lista_imagens_inexistentes");
              %>

              <form  name="bl_report_Dual" id="bl_report_Dual" class="baseForm" method="post" >

                <%
                if (res_Imagens!=null && res_Imagens.size()>0) {
                  %>

                  <table id="TRbl_report_Dual"  class="reportTable"   style="width:99%;" border="1"  >

                    <tr class="reportHeader3">
                      <td class="columnTdHeader" style="text-align: center; font-size:14px; padding:10px" >
                        As imagens abaixo não estão disponíveis em alta resolução. Continuar o download no tamanho grande?
                      </td>
                    </tr>
                   
                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Imagem
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Imagem = 0;
                    for (String imagem : (java.util.List<String>)res_Imagens) {
                      String style_bl_report_Imagem="";
                      if (!((i_bl_report_Imagem%2)!=0)) {
                        style_bl_report_Imagem="rowColor";
                      } else {
                        style_bl_report_Imagem="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Imagem %>' id="TRbl_report_Dual<%=i_bl_report_Imagem%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= imagem %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Imagem++;
                    }
                    %>

                  </table>

                  <%
                }
                %>

              </form>
              <%
            }
            %>

            <html:form action="com/DownloadImagens_iForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="a" onclick="opener.document.forms[0].download_alta_action.click(); javascript:window.close();" value="Continuar" styleClass="baseButton" property="update_action" >
                    </html:button>
                    <html:submit accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Documentos Interface
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
                  <%@ include file="../system/header_sem_ajuda.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(41)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Documentos_interfaces" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Documentos_interfaces=0;
              {
                portalbr.dbobj.table.Documentos_interfaces t_documentos_interfaces = new portalbr.dbobj.table.Documentos_interfaces();
                java.util.Vector res_Documentos_interfaces = (java.util.Vector)session.getAttribute("res_Documentos_interfaces");
                if (res_Documentos_interfaces!=null && res_Documentos_interfaces.size()>0) {
                  java.lang.Integer doin_id             =  null;
                  java.lang.String doin_nome            =  null;
                  java.lang.String doin_descricao       =  null;
                  int i_bl_report_Documentos_interfaces =  0;

                  t_documentos_interfaces = (portalbr.dbobj.table.Documentos_interfaces)res_Documentos_interfaces.elementAt(i_bl_report_Documentos_interfaces);
                  doin_id        = t_documentos_interfaces.getDoin_id();
                  doin_nome      = t_documentos_interfaces.getDoin_nome()==null?"":t_documentos_interfaces.getDoin_nome();
                  doin_descricao = t_documentos_interfaces.getDoin_descricao()==null?"":t_documentos_interfaces.getDoin_descricao();
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:right;">
                      Id
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Nome
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Descrição
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Documentos_interfaces<res_Documentos_interfaces.size()){
                    counterbl_report_Documentos_interfaces++;
                    String style="";
                    if (!((i_bl_report_Documentos_interfaces%2)!=0)) {
                      style="rowColor";
                    } else {
                      style="rowBlank";
                    }
                    %>
                    <tr class=<%= style %> id='TRbl_report_Document.os_interfaces<%=counterbl_report_Documentos_interfaces%>'  >
                      <td class="reportColumn" style="text-align:right;">
                        <%= doin_id %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <a href="../acesso/DocumentosInterfaces_aForm.do?pop_action=&pos=<%=i_bl_report_Documentos_interfaces %>&doin_id=<%= doin_id %>&doin_nome=<%= doin_nome %>&doin_descricao=<%= doin_descricao %>" target="_self" STYLE="cursor:hand">
                          <%= doin_nome %>
                        </a>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= doin_descricao %>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Documentos_interfaces >= res_Documentos_interfaces.size()) {
                      break;
                    }
                    t_documentos_interfaces = (portalbr.dbobj.table.Documentos_interfaces)res_Documentos_interfaces.elementAt(i_bl_report_Documentos_interfaces);
                    doin_id        = t_documentos_interfaces.getDoin_id();
                    doin_nome      = t_documentos_interfaces.getDoin_nome()==null?"":t_documentos_interfaces.getDoin_nome();
                    doin_descricao = t_documentos_interfaces.getDoin_descricao()==null?"":t_documentos_interfaces.getDoin_descricao();
                  }
                }
              }
              %>
            </table>
            <html:form action="acesso/ListaDocumentosInterfacesForm.do" method="post" styleClass="baseForm">
              <table class="buttonTable" style='width:;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:submit>
                    <html:button value="Gerar Autorização" onclick="this.disabled=true;gerar_autorizacao_action.click();" styleClass="baseButton" property="gerar1_action">
                    </html:button>
                    <html:submit value="Gerar Autorização" styleClass="myhidden" property="gerar_autorizacao_action">
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

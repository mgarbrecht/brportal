<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Geração de Romaneio
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
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(15)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ArquivosFornecedoresOc_rGrid.do" method="post" styleClass="baseForm">
              <%
              if (request.getAttribute("arquivo")!=null){
                %>
                <table style=width:100%;margin-top:10;>
                  <tr>
                    <td class=columHeader style="text-align:center;">
                      <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                        Clique para baixar o arquivo
                        <img src="../img/rar.gif" />
                      </a>
                    </td>
                  </tr>
                </table>
                <%
              }
              %>

              <%
              java.util.Vector res_Jw_interface_arq_compra = null;
              if(session.getAttribute("res_Jw_interface_arq_compra")!=null){
                res_Jw_interface_arq_compra = (java.util.Vector)session.getAttribute("res_Jw_interface_arq_compra");
              }
              if(res_Jw_interface_arq_compra!=null && res_Jw_interface_arq_compra.size() >0){
                %>
                <table class="messageTable" style='width:99%;'>
                  <tr class="messageTr" >
                    <td class="messageTd">
                      <html:errors property="gridCheckField"/>
                      <html:errors property="interface_arq_compra_id"/>
                      <html:errors property="forn_codigo"/>
                      <html:errors property="nome_arquivo"/>
                      <html:errors property="situacao"/>
                      <html:errors property="descricao_situacao"/>
                      <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_interface_arq_compra"/>
                    </td>
                  </tr>
                </table>


                <table id="TRbl_report_Jw_interface_arq_compra" class="reportTable" style=width:99%;  border=1  frame=box>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align: center;" >
                    </td>
                    <td class="columnTdHeader" style="text-align: center;" >
                      ID
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Fornecedor
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Arquivo
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Situação
                    </td>
                  </tr>


                  <%
                  String style="";
                  int contador = 0;
                  %>

                  <logic:iterate id="bl_form_Jw_interface_arq_compra_lines" name="ArquivosFornecedoresOc_rGridActionForm" property="bl_form_Jw_interface_arq_compra_lines" indexId="indexId">
                    <%
                    Jw_interface_arq_compra consultaOc = null;
                    consultaOc = (Jw_interface_arq_compra)res_Jw_interface_arq_compra.elementAt(contador);
                    if (!((contador%2)!=0)) {
                      style="rowColor";
                    } else {
                      style="rowBlank";
                    }
                    %>
                    <tr class=<%= style %> >
                      <td class="reportColumn" style="text-align:center;">
                        <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_interface_arq_compra_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align:center;">
                        <html:hidden property="interface_arq_compra_id" name="bl_form_Jw_interface_arq_compra_lines" indexed="true" styleId="interface_arq_compra_id"/>
                        <%= consultaOc.getInterface_arq_compra_id() %>
                      </td>

                      <td class="reportColumn" style="text-align:left;">
                        <html:hidden property="forn_codigo" name="bl_form_Jw_interface_arq_compra_lines" indexed="true" styleId="forn_codigo"/>
                        <%= consultaOc.getForn_codigo() %>
                      </td>

                      <td class="reportColumn" style="text-align:left;">
                        <html:hidden property="nome_arquivo" name="bl_form_Jw_interface_arq_compra_lines" indexed="true" styleId="nome_arquivo"/>
                        <%= consultaOc.getNome_arquivo() %>
                      </td>

                      <td class="reportColumn" style="text-align:center;">
                        <html:hidden property="descricao_situacao" name="bl_form_Jw_interface_arq_compra_lines" indexed="true" styleId="descricao_situacao"/>
                        <%= consultaOc.getDescricao_situacao() %>
                      </td>

                    </tr>
                    <%
                    contador ++;
                    %>

                  </logic:iterate>

                </table>

                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:submit accesskey="a" value="Gerar Arquivo TXT" styleClass="baseButton" property="update_action">
                      </html:submit>
                      <html:submit accesskey="a" value="Gerar Arquivo PDF" styleClass="baseButton" property="update1_action">
                      </html:submit>
                      <html:submit value="Marcar Todos" styleClass="baseButton" property="marcar_todos_action">
                      </html:submit>
                      <html:submit value="Desmarcar Todos" styleClass="baseButton" property="desmarcar_todos_action">
                      </html:submit>
                      <html:submit accesskey="a" value="Voltar" styleClass="baseButton" property="back_action">
                      </html:submit>
                    </td>
                  </tr>
                </table>

                <%
              }
              %>

            </html:form>
          </td>
        </tr>
      </table>

    </body>
  </center>
</html>

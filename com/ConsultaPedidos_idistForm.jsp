<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<%
   boolean liberaEdicaoDistribuicao = false;
   if(session.getAttribute("liberaEdicaoDistribuicao")!=null){
      liberaEdicaoDistribuicao = true;   
   }
%>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Distribuição de caixas
    </title>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">

            <html:form action="com/ConsultaPedidos_idistForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <% if(liberaEdicaoDistribuicao){ %>
                       <bean:message key="div.campos*"/>
                    <% } %>
                    <html:errors property="total_caixas"/>
                    <html:errors property="qtde_caixas_distribuidas"/>
                    <html:errors property="loja"/>
                    <html:errors property="caixas"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_distribuicao"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <html:hidden property="ped_nmro" value="<%= (String)session.getAttribute("distribuicao_ped_nmro") %>"/>
                <html:hidden property="item" value="<%= (String)session.getAttribute("distribuicao_item") %>"/>
                <html:hidden property="quantidade_pares"/>
                <html:hidden property="grade"/>
                <html:hidden property="codigo_corrugado"/>
                <html:hidden property="qt_par_corrug"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Qtd. Caixas do Item
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="total_caixas" styleId="total_caixas" styleClass="disabled" tabindex="-1" readonly="true" value="<%= (String)session.getAttribute("quantidade_caixas_item") %>" size="5" maxlength="5"/>
                  </td>
                </tr>

                <html:hidden property="descricao_corrugado"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Qtd. Caixas Distribuídas
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="qtde_caixas_distribuidas" styleId="qtde_caixas_distribuidas" styleClass="disabled" tabindex="-1" readonly="true" value="<%= (String)session.getAttribute("quantidade_caixas_distribuidas") %>" size="5" maxlength="5"/>
                  </td>
                </tr>

                <html:hidden property="index"/>

                <% if(liberaEdicaoDistribuicao){ %>

                   <tr class="itemTr">
                     <td class="formLabel">
                       <span class="spamFormLabel">
                         Loja
                       </span>
                       <bean:message key="jsp.fieldnotnull"/>
                     </td>
                     <td class="formField">
                       <html:text property="loja" styleId="loja" styleClass="baseField" size="25" maxlength="20"/>
                     </td>
                   </tr>

                   <tr class="itemTr">
                     <td class="formLabel">
                       <span class="spamFormLabel">
                         Caixas
                       </span>
                       <bean:message key="jsp.fieldnotnull"/>
                     </td>
                     <td class="formField">
                       <html:text property="caixas" styleId="caixas" styleClass="baseField" size="5"/>
                     </td>
                   </tr>
                 
                <% } else { %>

                <html:hidden property="loja"/>
                <html:hidden property="caixas"/>

                <% } %>

                <%
                if(request.getAttribute("fechar")!=null ){
                  %>

                  <script>
                    opener.document.forms[0].refresh_action.click();
                  </script>

                  <%
                }
                %>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                  
                    <%
                    if(liberaEdicaoDistribuicao){
                       java.util.Vector res_Ite_distribuicao_cliente = (java.util.Vector)session.getAttribute("res_Ite_distribuicao_cliente");
                       if(res_Ite_distribuicao_cliente!=null && res_Ite_distribuicao_cliente.size()>0) {
                       %>
                          <html:submit accesskey="a" value="Salvar Distribuição" styleClass="baseButton" property="update_action">
                          </html:submit>
                       <%
                       }
                    }
                    %>
                    <% if(liberaEdicaoDistribuicao){ %> 
                       <html:submit value="Adicionar Item" styleClass="baseButton" property="adicionar_item_action">
                       </html:submit>
                    <% } %>
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="a" styleClass="myhidden" property="delete_action">
                      <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                    </html:submit>
                    <html:button accesskey="f" onclick="fechar();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["loja"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Ite_distribuicao_cliente = (java.util.Vector)session.getAttribute("res_Ite_distribuicao_cliente");
              %>

              <form  name="bl_report_Ite_distribuicao_cliente" id="bl_report_Ite_distribuicao_cliente" class="baseForm" method="post" >
                <%
                if (res_Ite_distribuicao_cliente!=null && res_Ite_distribuicao_cliente.size()>0) {
                  %>

                  <table id="TRbl_report_Ite_distribuicao_cliente"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Integer ped_nmro =  null;
                    java.lang.Integer ite_seqn =  null;
                    java.lang.String cliente =  null;
                    java.lang.Integer qtd_caixas =  null;
                    java.lang.String excluir =  null;
                    int sum_qtd_caixas_0 = 0;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Cliente
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Caixas
                      </td>

                      <% if(liberaEdicaoDistribuicao) { %>
                         <td class="columnTdHeader" style="text-align:center; " >
                         </td>
                      <% } %>

                    </tr>

                    <%
                    int i_bl_report_Ite_distribuicao_cliente = 0;
                    while (i_bl_report_Ite_distribuicao_cliente<res_Ite_distribuicao_cliente.size()) {
                      portalbr.dbobj.table.Ite_distribuicao_cliente t_ite_distribuicao_cliente = (portalbr.dbobj.table.Ite_distribuicao_cliente)res_Ite_distribuicao_cliente.elementAt(i_bl_report_Ite_distribuicao_cliente);
                      ped_nmro = t_ite_distribuicao_cliente.getPed_nmro();
                      ite_seqn = t_ite_distribuicao_cliente.getIte_seqn();
                      cliente = t_ite_distribuicao_cliente.getCliente()==null?"":t_ite_distribuicao_cliente.getCliente();
                      qtd_caixas = t_ite_distribuicao_cliente.getQtd_caixas();
                      sum_qtd_caixas_0 += ((qtd_caixas!=null)?qtd_caixas.intValue():0);
                      String style_bl_report_Ite_distribuicao_cliente="";
                      if (!((i_bl_report_Ite_distribuicao_cliente%2)!=0)) {
                        style_bl_report_Ite_distribuicao_cliente="rowColor";
                      } else {
                        style_bl_report_Ite_distribuicao_cliente="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Ite_distribuicao_cliente %>' id="TRbl_report_Ite_distribuicao_cliente<%=i_bl_report_Ite_distribuicao_cliente%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= cliente %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((qtd_caixas!=null)?qtd_caixas.toString():"") %>
                        </td>

                        <% if(liberaEdicaoDistribuicao) { %>
                           <td class="reportColumn" style="text-align: center; width: 1%" >
                             <a href="../com/ConsultaPedidos_idistForm.do?delete_action=&index=<%= i_bl_report_Ite_distribuicao_cliente %>" style="cursor:hand">
                               <input type="button" value="Excluir" />
                             </a>
                           </td>
                        <% } %>

                      </tr>

                      <%
                      i_bl_report_Ite_distribuicao_cliente++;
                      if (i_bl_report_Ite_distribuicao_cliente<res_Ite_distribuicao_cliente.size()) {
                        t_ite_distribuicao_cliente = (portalbr.dbobj.table.Ite_distribuicao_cliente)res_Ite_distribuicao_cliente.elementAt(i_bl_report_Ite_distribuicao_cliente);
                        ped_nmro = t_ite_distribuicao_cliente.getPed_nmro();
                        ite_seqn = t_ite_distribuicao_cliente.getIte_seqn();
                        cliente = t_ite_distribuicao_cliente.getCliente()==null?"":t_ite_distribuicao_cliente.getCliente();
                        qtd_caixas = t_ite_distribuicao_cliente.getQtd_caixas();
                      } else {
                      }
                    }
                    %>

                    <tr class="totalColumn">
                      <td>
                         
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                           Total : 
                           <%= sum_qtd_caixas_0 + "" %>
                        </b>
                      </td>

                      <% if(liberaEdicaoDistribuicao) { %>
                      <td>
                      </td>
                      <% } %>

                    </tr>

                    <%
                    %>

                  </table>

                  <%
                }
                %>

              </form>
              <%
            }
            %>

          </td>
        </tr>
      </table>

<script>
function fechar(){
  javascript:window.close();
  <% if(request.getAttribute("fechar")!=null ){ %>
     opener.document.forms[0].refresh_action.click();
  <% } %>
}
</script>
    </body>
  </center>
</html>

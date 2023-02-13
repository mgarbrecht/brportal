<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Vincular Ordem de Compra ao Pedido
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(210)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/CadastroOrdemCompra_rForm.do" method="post" styleClass="baseForm">


              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Informe o pedido/ordem compra do cliente
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="oc1" styleId="oc1" styleClass="baseField"/>
                    <html:button value="Alterar OC´s" styleClass="baseButton" property="alterar_oc_action" onclick="processar_action.click();">
                    </html:button>
                    <html:button value="Limpar" onclick="document.forms[0].oc1.value=''" styleClass="baseButton" property="limpar_action">
                    </html:button>
                  </td>
                </tr>

              </table>

              <table style='width:99%;'>
                <tr>
                  <td class="buttonTd">
                    <html:submit value="Processar Todos" styleClass="myhidden" property="processar_action">
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="resetfull1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["oc1"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            java.util.Vector res_Jw_pedidos_ordem_compra = (java.util.Vector)session.getAttribute("res_Jw_pedidos_ordem_compra");
            %>

            <html:form action="com/CadastroOrdemCompra_rGrid.do" method="post" styleClass="baseForm">

              <%
              if (res_Jw_pedidos_ordem_compra != null && res_Jw_pedidos_ordem_compra.size() > 20) {
                %>

                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit value="Pos" styleClass="myhidden" property="pos_action">
                      </html:submit>
                      <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:submit value="Marcar Todos" styleClass="baseButton" property="marcar_todos_action">
                      </html:submit>
                      <html:submit value="Desmarcar Todos" styleClass="baseButton" property="desmarcar_todos_action">
                      </html:submit>
                      <html:submit value="Alterar Pedidos Selecionados" accesskey="a" styleClass="baseButton" property="update_action">
                      </html:submit>
                      <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                        <bean:message bundle="ApplicationResources" key="jsp.back"/>
                      </html:submit>
                      <html:submit value="processar_todos" styleClass="myhidden" property="processar_todos_action">
                      </html:submit>
                      <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                        <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:submit>
                    </td>
                  </tr>
                </table>


                <%
              }
              %>



              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="gridCheckField"/>
                    <html:errors property="numero"/>
                    <html:errors property="cliente"/>
                    <html:errors property="sequencial"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="grupo"/>
                    <html:errors property="nome_grupo"/>
                    <html:errors property="oc"/>
                    <html:errors property="oc_nova"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_ordem_compra"/>
                  </td>
                </tr>
              </table>

              <table class="itemGridTable" style='width:99%;'>
                <tr class="trGridLabel">
                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Pedido
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Cliente
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Grupo Econômico
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Ordem Compra
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      OC Nova
                    </span>
                  </td>

                </tr>

                <logic:iterate id="bl_form_Jw_pedidos_ordem_compra_lines" name="CadastroOrdemCompra_rGridActionForm" property="bl_form_Jw_pedidos_ordem_compra_lines" indexId="indexId">
                  <tr class="trGridField">
                    <td class="tdGridField">
                      <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_pedidos_ordem_compra_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="numero" styleId="numero" styleClass="disabled" tabindex="-1" readonly="true" size="22" maxlength="22" name="bl_form_Jw_pedidos_ordem_compra_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="cliente" styleId="cliente" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="4000" name="bl_form_Jw_pedidos_ordem_compra_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="sequencial" styleId="sequencial" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="10" name="bl_form_Jw_pedidos_ordem_compra_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="cli_rzao" styleId="cli_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="42" maxlength="4000" name="bl_form_Jw_pedidos_ordem_compra_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="grupo" styleId="grupo" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22" name="bl_form_Jw_pedidos_ordem_compra_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="nome_grupo" styleId="nome_grupo" styleClass="disabled" tabindex="-1" readonly="true" size="42" maxlength="4000" name="bl_form_Jw_pedidos_ordem_compra_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="oc" styleId="oc" styleClass="disabled" tabindex="-1" readonly="true" value="<%= (String)request.getAttribute("oc") %>" size="20" maxlength="20" name="bl_form_Jw_pedidos_ordem_compra_lines" indexed="true"/>
                    </td>

                    <html:hidden property="pos" name="bl_form_Jw_pedidos_ordem_compra_lines" indexed="true" styleId="pos"/>
                    <td class="tdGridField">
                      <html:text property="oc_nova" styleId="oc_nova" styleClass="baseField" name="bl_form_Jw_pedidos_ordem_compra_lines" indexed="true"/>
                    </td>

                  </tr>

                </logic:iterate>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit value="Pos" styleClass="myhidden" property="pos_action">
                    </html:submit>
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit value="Marcar Todos" styleClass="baseButton" property="marcar_todos_action">
                    </html:submit>
                    <html:submit value="Desmarcar Todos" styleClass="baseButton" property="desmarcar_todos_action">
                    </html:submit>
                    <html:submit value="Alterar Pedidos Selecionados" accesskey="a" styleClass="baseButton" property="update_action">
                    </html:submit>
                    <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:submit>
                    <html:submit value="processar_todos" styleClass="myhidden" property="processar_todos_action">
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[1].elements["gridCheckField"][0];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

          </td>
        </tr>
      </table>

    </body>
  </center>
</html>

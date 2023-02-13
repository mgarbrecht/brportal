<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body onload="if('<%= (String)request.getAttribute("tipos_pedidos_selecionados") %>' != 'null'){opener.document.forms[0].refresh_action.click(); window.close();}">
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvTipoPedidoGrdGrid.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>

                    </div>
                    <html:errors property="gridCheckField"/>
                    <html:errors property="tipo_pedido"/>
                    <html:errors property="descricao_tipo_pedido"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipo_pedido"/>
                  </td>
                </tr>
              </table>

              <table class="itemGridTable" style='width:500;'>
                <tr class="trGridLabel">
                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Tipo
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>

                </tr>

                <logic:iterate id="bl_form_Jw_tipo_pedido_lines" name="LvTipoPedidoGrdGridActionForm" property="bl_form_Jw_tipo_pedido_lines" indexId="indexId">
                  <tr class="trGridField">
                    <td class="tdGridField">
                      <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_tipo_pedido_lines" indexed="true"/>
                    </td>

                    <html:hidden property="return0" value="<%= request.getParameter("return0") %>" name="bl_form_Jw_tipo_pedido_lines" indexed="true" styleId="return0"/>
                    <td class="tdGridField">
                      <html:text property="tipo_pedido" styleId="tipo_pedido" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10" name="bl_form_Jw_tipo_pedido_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="descricao_tipo_pedido" styleId="descricao_tipo_pedido" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="40" name="bl_form_Jw_tipo_pedido_lines" indexed="true"/>
                    </td>

                  </tr>

                </logic:iterate>

              </table>

              <table class="buttonTable" style='width:500;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="a" value="Selecionar" styleClass="baseButton" property="update_action">
                    </html:submit>
                    <html:submit value="Marcar Todos" styleClass="baseButton" property="marcar_todos_action">
                    </html:submit>
                    <html:submit value="Desmarcar Todos" styleClass="baseButton" property="desmarcar_todos_action">
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

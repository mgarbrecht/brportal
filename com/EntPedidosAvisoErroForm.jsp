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
            <html:form action="com/EntPedidosAvisoErroForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:100%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="descricao_erro"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Emula_itens_faturas_proformas"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:100%;">
                <html:hidden property="numero_pedido"/>
                <html:hidden property="numero_item"/>
                <tr>
                  <td align="center">
                    <html:textarea property="descricao_erro" styleId="descricao_erro" styleClass="baseField" tabindex="-1" readonly="true" cols="60" rows="5"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:100%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:button accesskey="f" onclick="parent.tb_remove();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
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

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
            <html:form action="com/FichaCliente_ifForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:100%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:100%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Limite
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="limite" styleId="limite" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Saldo
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="saldo" styleId="saldo" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Pedidos Abertos
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="paresPedLiberados" styleId="paresPedLiberados" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="8"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="valorPedLiberados" styleId="valorPedLiberados" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Ped. Aberto Não Lib.
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="paresPedNaoLiberados" styleId="paresPedNaoLiberados" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="8"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="valorPedNaoLiberados" styleId="valorPedNaoLiberados" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Valor Vencido
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="valorVencido" styleId="valorVencido" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Dias Vencido
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="diasVencido" styleId="diasVencido" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:100%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit value="Execute" styleClass="myhidden" property="execute_action">
                    </html:submit>
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                    <html:button accesskey="p" value="Notas Vencidas" onclick="wopen('../com/FichaCliente_nForm.do?select_action=','_blank',800,500)" styleClass="baseButton" property="notas_action">
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

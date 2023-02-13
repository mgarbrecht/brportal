<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body onload="if('<%= (String)request.getAttribute("situacoes_selecionadas") %>' != 'null'){opener.document.forms[0].refresh_action.click();window.close();}">
      <table class="mainTable" style='width:600;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvSituacaoSolicitacaoCombEspecGrdGrid.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:600;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="itemGridTable" style='width:600;'>
                <tr class="trGridLabel">
                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Situação
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>

                </tr>

                <logic:iterate id="bl_form_Jw_situacao_solicitacao_comb_espec_lines" name="LvSituacaoSolicitacaoCombEspecGrdGridActionForm" property="bl_form_Jw_situacao_solicitacao_comb_espec_lines" indexId="indexId">
                  <tr class="trGridField">
                    <td class="tdGridField">
                      <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_situacao_solicitacao_comb_espec_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="codigo_situacao" styleId="codigo_situacao" styleClass="disabled" tabindex="-1" readonly="true" size="2" maxlength="240" name="bl_form_Jw_situacao_solicitacao_comb_espec_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="descricao_situacao" styleId="descricao_situacao" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="240" name="bl_form_Jw_situacao_solicitacao_comb_espec_lines" indexed="true"/>
                    </td>

                  </tr>

                </logic:iterate>

              </table>

              <table class="buttonTable" style='width:600;'>
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
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
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

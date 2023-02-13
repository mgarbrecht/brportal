<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body onload="if('<%= (String)request.getAttribute("marcas_selecionadas") %>' != 'null'){	opener.document.forms[0].refresh_action.click(); window.close();}">
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvMarcaGrdGrid.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="gridCheckField"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="descricao_marca"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Marcas_produtos"/>
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
                      Código
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>

                </tr>

                <logic:iterate id="bl_form_Marcas_produtos_lines" name="LvMarcaGrdGridActionForm" property="bl_form_Marcas_produtos_lines" indexId="indexId">
                  <tr class="trGridField">
                    <td class="tdGridField">
                      <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Marcas_produtos_lines" indexed="true"/>
                    </td>

                    <html:hidden property="return0" value="<%= request.getParameter("return0") %>" name="bl_form_Marcas_produtos_lines" indexed="true" styleId="return0"/>
                    <td class="tdGridField">
                      <html:text property="codigo_marca" styleId="codigo_marca" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="3" name="bl_form_Marcas_produtos_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="descricao_marca" styleId="descricao_marca" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="30" name="bl_form_Marcas_produtos_lines" indexed="true"/>
                    </td>

                  </tr>

                </logic:iterate>

              </table>

              <table class="buttonTable" style='width:500;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit value="Marcar Todos" styleClass="baseButton" property="marcar_todos_action">
                    </html:submit>
                    <html:submit value="Desmarcar Todos" styleClass="baseButton" property="desmarcar_todos_action">
                    </html:submit>
                  </td>
                </tr>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="a" value="Selecionar Marcados" styleClass="baseButton" property="update_action">
                    </html:submit>
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
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

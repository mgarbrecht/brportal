<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body onload="if('<%= (String)request.getAttribute("ite_situ") %>' != 'null'){	opener.document.forms[0].refresh_action.click();	window.close();}">
      <table class="mainTable" style='width:600;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvIteSituGrid.do" method="post" styleClass="baseForm">
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

                <logic:iterate id="bl_form_Cg_ref_codes_lines" name="LvIteSituGridActionForm" property="bl_form_Cg_ref_codes_lines" indexId="indexId">
                  <tr class="trGridField">
                    <td class="tdGridField">
                      <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Cg_ref_codes_lines" indexed="true"/>
                    </td>

                    <html:hidden property="return0" value="<%= request.getParameter("return0") %>" name="bl_form_Cg_ref_codes_lines" indexed="true" styleId="return0"/>
                    <td class="tdGridField">
                      <html:text property="rv_low_value" styleId="rv_low_value" styleClass="disabled" tabindex="-1" readonly="true" size="1" maxlength="240" name="bl_form_Cg_ref_codes_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="rv_meaning" styleId="rv_meaning" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="240" name="bl_form_Cg_ref_codes_lines" indexed="true"/>
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
                    <html:submit accesskey="a" value="Selecionar" styleClass="baseButton" property="selecionar_action">
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

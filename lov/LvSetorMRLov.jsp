<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvSetorMRGrid.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
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
                      Set_cdgo
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Set_nome
                    </span>
                  </td>

                </tr>

                <logic:iterate id="bl_form_Setor_lines" name="LvSetorMRGridActionForm" property="bl_form_Setor_lines" indexId="indexId">
                  <tr class="trGridField">
                    <td class="tdGridField">
                      <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Setor_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="set_cdgo" styleId="set_cdgo" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="5" name="bl_form_Setor_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="set_nome" styleId="set_nome" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="40" name="bl_form_Setor_lines" indexed="true"/>
                    </td>

                    <html:hidden property="return0" value="<%= request.getParameter("return0") %>" name="bl_form_Setor_lines" indexed="true" styleId="return0"/>
                  </tr>

                </logic:iterate>

              </table>

              <table class="buttonTable" style='width:500;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit value="Selecionar" styleClass="baseButton" property="selecionar_action">
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                  </td>
                </tr>
              </table>

              <%
              if(session.getAttribute("setouSetores")!=null){
                session.removeAttribute("setouSetores");
                %>
                <script>
                  document.forms[0].close_action.click();
                  opener.document.forms[0].refresh_action.click();
                </script>

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

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
            <%
            if(session.getAttribute("selecionou_grupos") != null ){
              session.removeAttribute("selecionou_grupos");
              %>
              <script>
                opener.document.forms[0].refresh_action.click();
                window.close();
              </script>
              <%
            }
            %>


            <html:form action="lov/LvGrupoMaterialGrdGrid.do" method="post" styleClass="baseForm">
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
                      Grupo Material
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Descri��o
                    </span>
                  </td>

                </tr>

                <logic:iterate id="bl_form_Dom_grupo_material_lines" name="LvGrupoMaterialGrdGridActionForm" property="bl_form_Dom_grupo_material_lines" indexId="indexId">
                  <tr class="trGridField">
                    <td class="tdGridField">
                      <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Dom_grupo_material_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="gpo_mater_cdgo" styleId="gpo_mater_cdgo" styleClass="disabled" tabindex="-1" readonly="true" size="6" maxlength="6" name="bl_form_Dom_grupo_material_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="gpo_mater_desc" styleId="gpo_mater_desc" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="40" name="bl_form_Dom_grupo_material_lines" indexed="true"/>
                    </td>

                    <html:hidden property="return0" value="<%= request.getParameter("return0") %>" name="bl_form_Dom_grupo_material_lines" indexed="true" styleId="return0"/>
                  </tr>

                </logic:iterate>

              </table>

              <table class="buttonTable" style='width:500;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
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

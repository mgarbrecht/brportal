<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
  <bean:message key="page.script"/>
</head>
<center>
  <body onload="if('<%= (String)request.getAttribute("cod_estoque") %>' != 'null'){	opener.document.forms[0].refresh_action.click();	window.close();}">
    <table class="mainTable" style='width:500;'>
      <tr class="mainTr">
        <td class="mainTd">
          <table class="headerTable" style="width:500" >
            <tr>

              <td class="td10">
              </td>

            </tr>

          </table>

          <html:form action="lov/LvTipoEstoqueGrdGrid.do" method="post" styleClass="baseForm">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  <b>
                    Tipo Estoque
                  </b>

                </td>

              </tr>

            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <div style=font-size:11px;font-weight:normal;>
                    Lista de Valores - Tipo Estoque
                  </div>
                  <html:errors property="gridCheckField"/>
                  <html:errors property="codigo"/>
                  <html:errors property="descricao"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipo_estoque"/>
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
                  </span>
                </td>

                <td class="tdGridlabel">
                  <span class="spamFormLabel">
                  </span>
                </td>

              </tr>

              <logic:iterate id="bl_form_Jw_tipo_estoque_lines" name="LvTipoEstoqueGrdGridActionForm" property="bl_form_Jw_tipo_estoque_lines" indexId="indexId">
                <tr class="trGridField">
                  <td class="tdGridField">
                    <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_tipo_estoque_lines" indexed="true"/>
                  </td>

                  <td class="tdGridField">
                    <html:text property="codigo" styleId="codigo" styleClass="baseField" readonly="true" size="4" maxlength="22" name="bl_form_Jw_tipo_estoque_lines" indexed="true"/>
                  </td>

                  <td class="tdGridField">
                    <html:text property="descricao" styleId="descricao" styleClass="baseField" readonly="true" size="40" maxlength="40" name="bl_form_Jw_tipo_estoque_lines" indexed="true"/>
                  </td>

                  <html:hidden property="return0" value="<%= request.getParameter("return0") %>" name="bl_form_Jw_tipo_estoque_lines" indexed="true" styleId="return0"/>
                  <html:hidden property="opener" name="bl_form_Jw_tipo_estoque_lines" indexed="true" styleId="opener"/>
                </tr>

              </logic:iterate>

            </table>

            <table class="buttonTable" style='width:500;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:submit accesskey="p" value="Selecionar" styleClass="baseButton" property="select1_action">
                  </html:submit>
                  <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                  </html:submit>
                  <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                    <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:submit>
                  <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                    <bean:message bundle="ApplicationResources" key="jsp.close"/>
                  </html:button>
                  <html:submit accesskey="l" styleClass="baseButton" property="refresh_action">
                    <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
                  </html:submit>
                </td>
              </tr>
            </table>

          </html:form>
          <script type="text/javascript">
            var focusControl = document.forms[0].elements["gridCheckField"][0];
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

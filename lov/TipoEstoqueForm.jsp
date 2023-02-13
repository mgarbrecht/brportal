<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
  <bean:message key="page.script"/>
</head>
<center>
  <body onload="if('<%= (String)request.getAttribute("clientes") %>' != 'null'){	opener.document.forms[0].clientes.value='<%= (String)request.getAttribute("clientes") %>';	opener.document.forms[0].refresh_action.click();	window.close();}">
    <table class="mainTable" style='width:99%;'>
      <tr class="mainTr">
        <td class="mainTd">
          <table class="headerTable" style="width:99%" >
            <tr>

              <td class="td10">
              </td>

            </tr>

          </table>

          <html:form action="lov/TipoEstoqueGrid.do" method="post" styleClass="baseForm">
            <table class="bannerTable" style="width:99%;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  <b>
                    Tipos de Estoque
                  </b>

                </td>

              </tr>

            </table>

            <table class="messageTable" style='width:99%;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="codigo"/>
                  <html:errors property="descricao"/>
                  <html:errors property="gridCheckField"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipoestoque"/>
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
                  </span>
                </td>

                <td class="tdGridlabel">
                  <span class="spamFormLabel">
                  </span>
                </td>

              </tr>

              <logic:iterate id="bl_form_Jw_tipoestoque_lines" name="TipoEstoqueGridActionForm" property="bl_form_Jw_tipoestoque_lines" indexId="indexId">
                <tr class="trGridField">
                  <td class="tdGridField">
                    <html:text property="codigo" disabled="true" styleId="codigo" styleClass="baseField" readonly="true" size="4" maxlength="22" name="bl_form_Jw_tipoestoque_lines" indexed="true"/>
                  </td>

                  <td class="tdGridField">
                    <html:text property="descricao" disabled="true" styleId="descricao" styleClass="baseField" readonly="true" size="50" maxlength="50" name="bl_form_Jw_tipoestoque_lines" indexed="true"/>
                  </td>

                  <html:hidden property="clientes" name="bl_form_Jw_tipoestoque_lines" indexed="true" styleId="clientes"/>
                  <td class="tdGridField">
                    <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_tipoestoque_lines" indexed="true"/>
                  </td>

                </tr>

              </logic:iterate>

            </table>

            <table class="buttonTable" style='width:99%;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:submit accesskey="s" value="Selecionar" styleClass="baseButton" property="select1_action">
                  </html:submit>
                  <html:submit accesskey="s" styleClass="baseButton" property="select_action">
                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                  </html:submit>
                  <html:submit accesskey="r" styleClass="baseButton" property="resetfull_action">
                    <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:submit>
                </td>
              </tr>
            </table>

          </html:form>
          <table class="footerTable">
            <tr class="footerTr">
              <td class="footerTd">
                <bean:message key="div.print"/>
              </td>
            </tr>

          </table>

        </td>
      </tr>
    </table>

  </body>
</center>
</html>

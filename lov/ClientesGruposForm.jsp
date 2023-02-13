<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
  <bean:message key="page.script"/>
</head>
<center>
  <body onload="if('<%= (String)request.getAttribute("clientes") %>' != 'null'){opener.document.forms[0].clientes.value='<%= (String)request.getAttribute("clientes") %>';opener.document.forms[0].refresh_action.click();window.close();}">
    <table class="mainTable" style='width:99%;'>
      <tr class="mainTr">
        <td class="mainTd">
          <table class="headerTable" style="width:99%" >
            <tr>

              <td class="td10">
              </td>

            </tr>

          </table>

          <html:form action="lov/ClientesGruposGrid.do" method="post" styleClass="baseForm">
            <table class="bannerTable" style="width:99%;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Clientes do Grupo
                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:99%;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="cli_cdgo"/>
                  <html:errors property="cli_rzao"/>
                  <html:errors property="cli_situ"/>
                  <html:errors property="gridCheckField"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_grupos_economicos"/>
                </td>
              </tr>
            </table>

            <table class="itemGridTable" style='width:99%;'>
              <tr class="trGridLabel">
                <td class="tdGridlabel">
                  <span class="spamFormLabel">
                    Código
                  </span>
                </td>

                <td class="tdGridlabel">
                  <span class="spamFormLabel">
                    Razão Social
                  </span>
                </td>

                <td class="tdGridlabel">
                  <span class="spamFormLabel">
                    Situação
                  </span>
                </td>

                <td class="tdGridlabel">
                  <span class="spamFormLabel">
                  </span>
                </td>

              </tr>

              <logic:iterate id="bl_form_Jw_clientes_grupos_economicos_lines" name="ClientesGruposGridActionForm" property="bl_form_Jw_clientes_grupos_economicos_lines" indexId="indexId">
                <tr class="trGridField">
                  <html:hidden property="gre_grupo" name="bl_form_Jw_clientes_grupos_economicos_lines" indexed="true" styleId="gre_grupo"/>
                  <html:hidden property="gre_descricao" name="bl_form_Jw_clientes_grupos_economicos_lines" indexed="true" styleId="gre_descricao"/>
                  <td class="tdGridField">
                    <html:text property="cli_cdgo" style="background-color:#d8d8d8; border-color:gray; text-align:start;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22" name="bl_form_Jw_clientes_grupos_economicos_lines" indexed="true" styleId="cli_cdgo"/>
                  </td>

                  <html:hidden property="cli_nome" name="bl_form_Jw_clientes_grupos_economicos_lines" indexed="true" styleId="cli_nome"/>
                  <td class="tdGridField">
                    <html:text property="cli_rzao" style="background-color:#d8d8d8; border-color:gray; text-align:start;" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35" name="bl_form_Jw_clientes_grupos_economicos_lines" indexed="true" styleId="cli_rzao"/>
                  </td>

                  <td class="tdGridField">
                    <html:text property="cli_situ" style="background-color:#d8d8d8; border-color:gray; text-align:start;" styleClass="disabled" tabindex="-1" readonly="true" size="1" maxlength="1" name="bl_form_Jw_clientes_grupos_economicos_lines" indexed="true" styleId="cli_situ"/>
                  </td>

                  <html:hidden property="clientes" name="bl_form_Jw_clientes_grupos_economicos_lines" indexed="true" styleId="clientes"/>
                  <td class="tdGridField">
                    <html:checkbox property="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_clientes_grupos_economicos_lines" indexed="true" styleId="gridCheckField"/>
                  </td>

                  <html:hidden property="pos" name="bl_form_Jw_clientes_grupos_economicos_lines" indexed="true" styleId="pos"/>
                </tr>

              </logic:iterate>

            </table>

            <table class="itemTable" style='width:99%;'>
              <%
              {
                %>
                <%
                java.util.Vector res_Jw_clientes_grupos_economicos = (java.util.Vector)session.getAttribute("res_Jw_clientes_grupos_economicos");
                %>
                <%
                String pos = "0";
                if (res_Jw_clientes_grupos_economicos!=null) {
                  pos = "" + res_Jw_clientes_grupos_economicos.size();
                }
                %>
              </table>
              <table class="navigatorTable" style="width:99%;">
                <tr class="navigatorTr" >
                  <td class="navigatorTd" >
                    <img border="0" style="cursor:pointer" src="../img/first.gif" title="Primeiro" onclick="javascript:new_pos0('1');" />
                    &nbsp;
                    <img border="0" style="cursor:pointer" src="../img/prev_group.gif" title="Anterior" onclick="javascript:new_pos0(parseInt(document.forms[0].navigation_pos0.value)-10);" accesskey="m" />
                    &nbsp;
                    <img border="0" style="cursor:pointer" src="../img/prev.gif" title="Anterior" onclick="javascript:new_pos0(parseInt(document.forms[0].navigation_pos0.value)-1);" accesskey="," />
                    &nbsp;
                    <input type="text" name="navigation_pos0" size="5" class="navigatorInput" >
                    &nbsp;
                    <img border="0" style="cursor:pointer" src="../img/next.gif" title="Próximo"  onclick="javascript:new_pos0(parseInt(document.forms[0].navigation_pos0.value)+1);" accesskey="." />
                    &nbsp;
                    <img border="0" style="cursor:pointer" src="../img/next_group.gif" title="Próximo"  onclick="javascript:new_pos0(parseInt(document.forms[0].navigation_pos0.value)+10);" accesskey=";" />
                    &nbsp;
                    <img border="0" style="cursor:pointer" src="../img/last.gif" title="Último" onclick="javascript:new_pos0(document.forms[0].navigation_max0.value);">
                    &nbsp;
                    <bean:message key="jsp.navigator.register"/>
                    :
                    <input type="text" name="navigation_max0" value="<%= pos %>" size="5" class="navigatorInput" >
                  </td>
                </tr>
                <script type="text/javascript">
                  if (document.forms[0].pos[0].value!="") {
                    document.forms[0].navigation_pos0.value= parseInt(document.forms[0].pos[0].value) + 1;
                  }
                  function new_pos0(POS) {
                    if (POS>0 && POS<=document.forms[0].navigation_max0.value ) {
                      document.forms[0].navigation_pos0.value=POS;
                      document.forms[0].pos[0].value=parseInt(document.forms[0].navigation_pos0.value) - 1;
                      document.forms[0].pos_action.click();
                    } else {
                      alert("<bean:message key="jsp.endregistries"/>");
                    }
                  }
                </script>
                <%}%>
                </table>

                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="p" value="Selecionar" styleClass="baseButton" property="select1_action">
                      </html:submit>
                      <html:submit styleClass="myhidden" property="select_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:submit styleClass="myhidden" property="resetfull_action">
                        <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:submit>
                      <html:submit value="Pos" styleClass="myhidden" property="pos_action">
                      </html:submit>
                    </td>
                  </tr>
                </table>

                <script type="text/javascript">
                  function setLov(CLIENTES) {
                    opener.document.forms[0].clientes.value =  CLIENTES;
                    window.close();
                  }
                </script>
              </html:form>
            </td>
          </tr>
        </table>

      </body>
    </center>
  </html>

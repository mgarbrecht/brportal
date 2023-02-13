<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Cadastro de Dispositivos Móveis
    </title>
  </head>
</head>
<center>
  <body>
    <table class="mainTable" style='width:99%;'>
      <tr class="mainTr">
        <td class="mainTd">
          <table class="headerTable" style="width:99%" >
            <tr>

              <td class="td10">
                <%@ include file="../system/header.jsp" %>
                <%
                if(!user.isSuperUsuario() && !user.isAutorizado(197)){
                  response.sendRedirect("../system/Error.jsp");
                }
                %>
              </td>

            </tr>

          </table>

          <html:form action="com/DispositivosMoveis_rGrid.do" method="post" styleClass="baseForm">
            <table class="messageTable" style='width:99%;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="codigo_usuario"/>
                  <html:errors property="nome_usuario"/>
                  <html:errors property="id_tablet"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Usuarios_sistema_afv"/>
                </td>
              </tr>
            </table>

            <table class="itemGridTable" style='width:99%;'>
              <tr class="trGridLabel">
                <td class="tdGridlabel">
                  <span class="spamFormLabel">
                    Código Usuário
                  </span>
                </td>

                <td class="tdGridlabel">
                  <span class="spamFormLabel">
                    Nome Usuário
                  </span>
                </td>

                <td class="tdGridlabel">
                  <span class="spamFormLabel">
                    Tablet
                  </span>
                </td>

              </tr>

              <logic:iterate id="bl_form_Usuarios_sistema_afv_lines" name="DispositivosMoveis_rGridActionForm" property="bl_form_Usuarios_sistema_afv_lines" indexId="indexId">
                <tr class="trGridField">
                  <td class="tdGridField">
                    <html:text property="codigo_usuario" styleId="codigo_usuario" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="30" name="bl_form_Usuarios_sistema_afv_lines" indexed="true"/>
                  </td>

                  <td class="tdGridField">
                    <html:text property="nome_usuario" styleId="nome_usuario" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="30" name="bl_form_Usuarios_sistema_afv_lines" indexed="true"/>
                  </td>

                  <td class="tdGridField">
                    <html:select property="id_tablet" styleId="id_tablet" styleClass="baseField" size="1" name="bl_form_Usuarios_sistema_afv_lines" indexed="true">
                      <html:options property="id_tabletList" labelProperty="id_tabletLabelList" styleClass="baseOptions" name="bl_form_Usuarios_sistema_afv_lines" labelName="bl_form_Usuarios_sistema_afv_lines"/>
                    </html:select>
                  </td>

                </tr>

              </logic:iterate>

            </table>

            <table class="buttonTable" style='width:99%;'>
              <tr class="buttonTr">
                <td class="buttonTd">

                  <div id="botao">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>

                    <html:submit accesskey="a" value="Salvar Alterações" onclick="jQuery('#aguarde').show();jQuery('#botao').hide();" styleClass="baseButton" property="update_action">
                    </html:submit>

                    <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:submit>
                  </div>

                  <div id="aguarde" style="display:none">
                    <img src="../img/loading_pequeno.gif"/>
                    <b>
                      Aguarde, salvando as alterações
                    </b>
                  </div>
                </td>
              </tr>
            </table>

          </html:form>
          <script type="text/javascript">
            var focusControl = document.forms[0].elements["id_tablet"][0];
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

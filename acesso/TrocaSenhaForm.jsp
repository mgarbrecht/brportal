<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      <bean:message bundle="AcessoResources" key="TrocaSenha.titulo"/>
    </title>
  </head>
  <center>
    <body onload="document.forms[0].usua_senha.value='';document.forms[0].usua_senha_confirma.value='';">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header_trocar_senha.jsp" %>
                </td>

              </tr>

            </table>

            <html:form action="acesso/TrocaSenhaForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="usua_senha"/>
                    <html:errors property="forcasenha"/>
                    <html:errors property="usua_senha_confirma"/>
                    <html:errors property="observacao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String id = "";
                acesso.Usuario u = new acesso.Usuario();
                u = (acesso.Usuario)session.getAttribute("User");
                id = u.getId()+"";
                %>
                <html:hidden property="usua_id" value="<%= id %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="AcessoResources" key="TrocaSenha.usua_senha"/>
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:password property="usua_senha" onkeyup="testPassword(this.value)" styleClass="baseField" maxlength="32"/>
                    <span class="spamFormLabel">
                      Força da Senha
                    </span>
                    <html:text property="forcasenha" styleId="forcasenha" style="font-size:12; font-weight:bold; text-align:center;" styleClass="baseField" tabindex="-1" readonly="true" size="13"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="AcessoResources" key="TrocaSenha.usua_senha_confirma"/>
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:password property="usua_senha_confirma" styleClass="baseField" maxlength="32"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="observacao" styleId="observacao" style="background-color:transparent; border-style:none; color:red; background-color:transparent; border-style:none; cursor:default; text-align:start;" styleClass="baseField" size="100"/>
                  </td>
                </tr>

                <html:hidden property="fl"/>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="a" styleClass="baseButton" property="update_action">
                      <bean:message bundle="AcessoResources" key="TrocaSenha.update_action"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="p" value="pop" styleClass="myhidden" property="pop_action">
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["usua_senha"];
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

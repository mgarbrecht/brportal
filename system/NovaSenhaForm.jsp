<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:100%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="system/NovaSenhaForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:100%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <%= (String)session.getAttribute("mensagem_nova_senha") %>
                    </div>
                    <html:errors property="email"/>
                    <html:errors property="usuario"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:100%;">
                <script>
                  jQuery("#email").focus();
                </script>
                <%
                portalbr.system.NovaSenhaActionForm novaSenha = (portalbr.system.NovaSenhaActionForm) session.getAttribute("NovaSenhaActionForm");
                String mostra = novaSenha.getMostrausuario()+"";
                %>
                <html:hidden property="mostrausuario"/>
                <%
                if(mostra.equals("S")){
                  %>

                  <html:hidden property="email" />

                  <%
                } else {
                  %>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Email
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="email" styleId="email" styleClass="baseField" onblur="javascript:toLowerCase(this);" onchange="javascript:toLowerCase(this);" size="60"/>
                    </td>
                  </tr>

                  <%
                }
                %>
                <%
                if(mostra.equals("S")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Usuário
                      </span>
                    </td>
                    <td class="formField">
                      <html:select property="usuario" styleId="usuario" styleClass="baseField" size="1">
                        <html:options property="usuarioList" labelProperty="usuarioLabelList" styleClass="baseOptions"/>
                      </html:select>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <%
                }
                %>

              </table>

              <table class="buttonTable" style='width:100%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <%
                    if(!mostra.equals("S")){
                      %>
                      <html:submit accesskey="i" value="Receber Nova Senha" styleClass="baseButton" property="insert_action">
                      </html:submit>
                      <%
                    }
                    %>
                    <%
                    if(mostra.equals("S")){
                      %>
                      <html:submit value="Confirmar" styleClass="baseButton" property="confirmar_action">
                      </html:submit>
                      <%
                    }
                    %>
                    <html:button accesskey="f" onclick="parent.tb_remove();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                    <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
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

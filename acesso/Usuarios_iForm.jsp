<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Usuários - Inclusão
    </title>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header_sem_ajuda.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(39)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="acesso/Usuarios_iForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="usua_usuario"/>
                    <html:errors property="usua_nome"/>
                    <html:errors property="usua_email"/>
                    <html:errors property="usua_senha"/>
                    <html:errors property="confirma_nova_senha"/>
                    <html:errors property="usua_enne_id"/>
                    <html:errors property="tien_tipo"/>
                    <html:errors property="tipo_entidade"/>
                    <html:errors property="chave"/>
                    <html:errors property="dias_consulta_retroativa"/>
                    <html:errors property="usua_expira_senha"/>
                    <html:errors property="usua_super"/>
                    <html:errors property="gerar_autorizacao"/>
                    <html:errors property="copiar_acessos"/>
                    <html:errors property="usua_pai"/>
                    <html:errors property="usua_pai_nome"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Usuarios"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <html:hidden property="usua_id"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Usuário
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="usua_usuario" styleClass="baseField" size="30" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nome
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="usua_nome" styleClass="baseField" size="40" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Email
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="usua_email" styleId="usua_email" styleClass="baseField" size="100" maxlength="100"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Senha
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:password property="usua_senha" styleClass="baseField"/>
                    <span class="spamFormLabel">
                      Confirma Nova Senha
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                    <html:password property="confirma_nova_senha" styleClass="baseField"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Entidade Negócio
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="usua_enne_id" onblur="if(this.value==''){tien_tipo.value='';}" styleClass="baseField" size="10" maxlength="10"/>
                    <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_usua_enne_id()"  >
                    <script type="text/javascript">
                      function lov_open_usua_enne_id() {
                        window.open('../lov/LvEntidadeNegocioLov.do?resetfull_action=&returnBlock=0&return0=usua_enne_id&return1=tien_tipo&return3=dias_consulta_retroativa','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="tien_tipo" styleClass="disabled" tabindex="-1" readonly="true" size="60"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo Entidade
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo_entidade" styleId="tipo_entidade" styleClass="baseField" size="1">
                      <html:options property="tipo_entidadeList" labelProperty="tipo_entidadeLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Chave
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="chave" styleId="chave" styleClass="baseField"/>
                  </td>
                </tr>

                <html:hidden property="usua_dt_senha"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Dias Consulta Retroativa
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dias_consulta_retroativa" styleClass="baseField" size="4" maxlength="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Expira Senha
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:select property="usua_expira_senha" styleId="usua_expira_senha" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="S">
                        Sim
                      </html:option>
                      <html:option styleClass="baseOption" value="N">
                        Não
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Super
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:select property="usua_super" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="N">
                        Não
                      </html:option>
                      <html:option styleClass="baseOption" value="S">
                        Sim
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Gera Autorizações
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="gerar_autorizacao" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="S\"selected='selected'">
                        Sim
                      </html:option>
                      <html:option styleClass="baseOption" value="N">
                        Não
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Copiar Acessos
                      <br>
                      de Outro Usuário
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="copiar_acessos" onclick="refresh_action.click();" styleClass="baseField" value="1"/>
                  </td>
                </tr>

                <%
                portalbr.acesso.Usuarios_iActionForm usuarios = (portalbr.acesso.Usuarios_iActionForm) session.getAttribute("Usuarios_iActionForm");
                String opcao = usuarios.getCopiar_acessos()+"";
                if(opcao.equals("1")) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Usuário Pai
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="usua_pai" styleClass="baseField" size="15"/>
                      <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_usua_pai()"  >
                      <script type="text/javascript">
                        function lov_open_usua_pai() {
                          window.open('../lov/LvUsuarioLov.do?resetfull_action=&returnBlock=0&return0=usua_pai_id&return1=usua_pai_nome&return2=usua_pai','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="usua_pai_nome" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="40"/>
                    </td>
                  </tr>

                  <html:hidden property="usua_pai_id"/>
                  <%
                } else {
                  %>
                  <html:hidden property="usua_pai"/>
                  <html:hidden property="usua_pai_nome"/>
                  <html:hidden property="usua_pai_id"/>
                  <%
                }
                %>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" value="pop" styleClass="myhidden" property="pop_action">
                    </html:submit>
                    <html:submit value="Incluir" onclick="if(usua_senha.value==''){alert('A senha deve ser informada!');return false;}if(confirma_nova_senha.value==''){alert('A confirmação da senha deve ser informada!');return false;}if(usua_senha.value!=confirma_nova_senha.value){alert('Confirmação diferente da senha!');return false;}" styleClass="baseButton" property="incluir_action">
                    </html:submit>
                    <html:submit accesskey="r" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="b" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="refresh_action">
                      <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["usua_usuario"];
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

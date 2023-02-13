<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Usuários - Alteração
    </title>
  </head>
  <center>
    <body onload="if(document.forms[0].usua_enne_id.value=='null'){document.forms[0].usua_enne_id.value='';}">
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

            <html:form action="acesso/Usuarios_aForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="usua_usuario"/>
                    <html:errors property="usua_nome"/>
                    <html:errors property="usua_email"/>
                    <html:errors property="usua_senha"/>
                    <html:errors property="confirma_senha"/>
                    <html:errors property="forca_senha_check"/>
                    <html:errors property="usua_enne_id"/>
                    <html:errors property="enne_descricao"/>
                    <html:errors property="dias_consulta_retroativa"/>
                    <html:errors property="usua_super"/>
                    <html:errors property="usua_expira_senha"/>
                    <html:errors property="situacao"/>
                    <html:errors property="usuario_inclusao"/>
                    <html:errors property="dthr_inclusao"/>
                    <html:errors property="usuario_alteracao"/>
                    <html:errors property="dthr_alteracao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios"/>
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
                      Nova Senha
                    </span>
                  </td>
                  <td class="formField">
                    <html:password property="usua_senha" styleClass="baseField"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Confirma
                      <br>
                      Senha
                    </span>
                  </td>
                  <td class="formField">
                    <html:password property="confirma_senha" styleClass="baseField"/>
                    <span class="spamFormLabel">
                      Forçar Troca de Senha?
                    </span>
                    <html:checkbox property="forca_senha_check" onclick="forca_senha.value=forca_senha_check.checked;" styleClass="baseField" value="1"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Entidade Negócio
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="usua_enne_id" onblur="if(this.value==''){enne_descricao.value='';}" styleClass="baseField" size="10" maxlength="10"/>
                    <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_usua_enne_id()"  >
                    <script type="text/javascript">
                      function lov_open_usua_enne_id() {
                        if (window.showModalDialog) {
                          window.showModalDialog('../lov/LvEntidadeNegocioLov.do?resetfull_action=&returnBlock=0&return0=usua_enne_id&return1=enne_descricao&return3=dias_consulta_retroativa','','scroll=yes;dialogHeight=510px;dialogWidth=600px;dialogTop=0;dialogLeft=0;');
                        } else {
                          window.open('../lov/LvEntidadeNegocioLov.do?resetfull_action=&returnBlock=0&return0=usua_enne_id&return1=enne_descricao&return3=dias_consulta_retroativa','','scrollbars=yes,height=510px,width=600px,top=0,left=0,modal=yes');
                        }
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="enne_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="60" maxlength="255"/>
                  </td>
                </tr>

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
                      Expira Senha
                    </span>
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

                <html:hidden property="pos"/>
                <html:hidden property="chamador"/>
                <html:hidden property="forca_senha"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Bloqueado
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="situacao" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="I">
                        Sim
                      </html:option>
                      <html:option styleClass="baseOption" value="A">
                        Não
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Usuário Inclusão
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="usuario_inclusao" styleId="usuario_inclusao" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="100"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Dt. Hora Inclusão
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dthr_inclusao" styleId="dthr_inclusao" styleClass="disabled" tabindex="-1" readonly="true" size="19" maxlength="19"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Usuário Alteração
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="usuario_alteracao" styleId="usuario_alteracao" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="100"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Dt. Hora Alteração
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dthr_alteracao" styleId="dthr_alteracao" styleClass="disabled" tabindex="-1" readonly="true" size="19" maxlength="19"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="u" onclick="if(usua_senha.value!=confirma_nova_senha.value){alert('Confirmação diferente da senha!');return false;}" styleClass="baseButton" property="update_action">
                      <bean:message bundle="ApplicationResources" key="jsp.update"/>
                    </html:submit>
                    <html:submit accesskey="d" styleClass="baseButton" property="delete_action">
                      <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                    </html:submit>
                    <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body onload="if(document.getElementById('controla_usua_id').value!='' && document.getElementById('controla_usua_id').value!='C'){document.getElementById('usua_id').className='disabled';document.getElementById('usua_nome').focus();document.getElementById('usua_id').readOnly = true;document.forms[0].copiar_action.disabled=false;}if(document.getElementById('controla_usua_id').value=='C'){document.forms[0].update_action.disabled=true;document.forms[0].delete_action.disabled=true;document.forms[0].copiar_action.disabled=true;document.getElementById('usua_id').readOnly = false;document.getElementById('usua_id').focus(); }">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="adm/FiltroPadraoForm.do" method="post" styleClass="baseForm">
              <table class="bannerTable" style="width:99%;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Change Title
                  </td>
                </tr>
              </table>

              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="usua_id"/>
                    <html:errors property="usua_nome"/>
                    <html:errors property="usua_usuario"/>
                    <html:errors property="usua_senha"/>
                    <html:errors property="usua_super"/>
                    <html:errors property="usua_enne_id"/>
                    <html:errors property="usua_dt_senha"/>
                    <html:errors property="usua_acessos"/>
                    <html:errors property="usua_dt_ultimo_acesso"/>
                    <html:errors property="situacao"/>
                    <html:errors property="dias_consulta_retroativa"/>
                    <html:errors property="usua_expira_senha"/>
                    <html:errors property="controla_usua_id"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Usuarios"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      usua_id
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="usua_id" styleId="usua_id" styleClass="baseField" size="10" maxlength="10"/>
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
                    <html:text property="usua_nome" styleId="usua_nome" styleClass="baseField" size="40" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Usuário
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="usua_usuario" styleId="usua_usuario" styleClass="baseField" size="30" maxlength="30"/>
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
                    <html:text property="usua_senha" styleId="usua_senha" styleClass="baseField" size="32" maxlength="32"/>
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
                    <html:text property="usua_super" styleId="usua_super" styleClass="baseField" size="1" maxlength="1"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="usua_enne_id" styleId="usua_enne_id" styleClass="baseField" size="10" maxlength="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      usua_dt_senha
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="usua_dt_senha" styleId="usua_dt_senha" styleClass="baseField" size="22" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      usua_acessos
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="usua_acessos" styleId="usua_acessos" styleClass="baseField" size="10" maxlength="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      usua_dt_ultimo_acesso
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="usua_dt_ultimo_acesso" styleId="usua_dt_ultimo_acesso" styleClass="baseField" size="22" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      situacao
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="situacao" styleId="situacao" styleClass="baseField" size="1" maxlength="1"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      dias_consulta_retroativa
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dias_consulta_retroativa" styleId="dias_consulta_retroativa" styleClass="baseField" size="4" maxlength="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Usua_expira_senha
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="usua_expira_senha" styleId="usua_expira_senha" styleClass="baseField" size="1" maxlength="1"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      usua_id
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="controla_usua_id" styleId="controla_usua_id" styleClass="baseField" size="10" maxlength="10"/>
                  </td>
                </tr>

                <html:hidden property="pos"/>
                <%
                {
                  %>
                  <%
                  java.util.Vector res_Usuarios = (java.util.Vector)session.getAttribute("res_Usuarios");
                  %>
                  <%
                  String pos = "0";
                  if (res_Usuarios!=null) {
                    pos = "" + res_Usuarios.size();
                  }
                  %>
                </table>
                <table class="navigatorTable" style="width:99%;">
                  <tr class="navigatorTr" >
                    <td class="navigatorTd" >
                      <img border="0" style="cursor:pointer" src="../img/first.gif" title="Primeiro" onclick="javascript:new_pos0('1');" />
                      &nbsp;
                      <img border="0" style="cursor:pointer" src="../img/prev.gif" title="Anterior" onclick="javascript:new_pos0(parseInt(document.forms[0].navigation_pos0.value)-1);" accesskey="," />
                      &nbsp;
                      <input type="text" name="navigation_pos0" size="5" class="navigatorInput" >
                      &nbsp;
                      <img border="0" style="cursor:pointer" src="../img/next.gif" title="Próximo"  onclick="javascript:new_pos0(parseInt(document.forms[0].navigation_pos0.value)+1);" accesskey="." />
                      &nbsp;
                      <img border="0" style="cursor:pointer" src="../img/last.gif" title="Último" onclick="javascript:new_pos0(document.forms[0].navigation_max0.value);">
                      &nbsp;
                      <bean:message key="jsp.navigator.register"/>
                      :
                      <input type="text" name="navigation_max0" value="<%= pos %>" size="5" class="navigatorInput" >
                    </td>
                  </tr>
                  <script type="text/javascript">
                    if (document.forms[0].pos.value!="") {
                      document.forms[0].navigation_pos0.value= parseInt(document.forms[0].pos.value) + 1;
                    }
                    function new_pos0(POS) {
                      if (POS>0 && POS<=document.forms[0].navigation_max0.value ) {
                        document.forms[0].navigation_pos0.value=POS;
                        document.forms[0].pos.value=parseInt(document.forms[0].navigation_pos0.value) - 1;
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
                        <html:submit value="Pos" styleClass="myhidden" property="pos_action">
                        </html:submit>
                        <html:submit accesskey="s" styleClass="baseButton" property="select_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:submit>
                        <html:submit accesskey="i" styleClass="baseButton" property="insert_action">
                          <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                        </html:submit>
                        <html:submit accesskey="u" styleClass="baseButton" property="update_action">
                          <bean:message bundle="ApplicationResources" key="jsp.update"/>
                        </html:submit>
                        <html:submit accesskey="d" onclick="return confirmSubmit('');" styleClass="baseButton" property="delete_action">
                          <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                        </html:submit>
                        <html:submit accesskey="r" styleClass="baseButton" property="resetfull_action">
                          <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                        </html:submit>
                        <html:button value="copiar" onclick="update_action.disabled=true;delete_action.disabled=true;copiar_action.disabled=true;document.getElementById('usua_id').readOnly = false;document.getElementById('usua_id').focus();document.getElementById('usua_id').className='';document.getElementById('usua_id').value='';document.getElementById('controla_usua_id').value='C';" styleClass="baseButton" property="copiar_action">
                        </html:button>
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/TrocaSenhaPadraoActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = TrocaSenhaPadraoActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("usua_id","Usu�rio");
    hashMapLabel.set("usua_usuario","Usu�rio");
    hashMapLabel.set("usua_nome","");
    hashMapLabel.set("situacao","Situa��o");
    hashMapLabel.set("usua_email","Novo Email");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Troca Senha Padr�o / Email
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(180)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="acesso/TrocaSenhaPadraoForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="usua_usuario"/>
                    <html:errors property="usua_nome"/>
                    <html:errors property="situacao"/>
                    <html:errors property="usua_email"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Usuarios"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <html:hidden property="usua_id"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Usu�rio
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="usua_usuario" onblur="fillFields(0,new Array('usua_usuario'),'TrocaSenhaPadraoActionForm.getUsua_nome_Ajax',new Array('usua_nome','usua_id'));" styleClass="baseField" size="15" maxlength="30"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_usua_usuario()"  >
                    <script type="text/javascript">
                      function lov_open_usua_usuario() {
                        window.open('../lov/LvUsuarioLov.do?resetfull_action=&returnBlock=0&return1=usua_nome&return0=usua_id&return2=usua_usuario&return3=situacao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="usua_nome" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>
                    <span class="spamFormLabel">
                      Situa��o
                    </span>
                    <html:text property="situacao" styleId="situacao" onblur="fillFields(0,new Array('usua_usuario','situacao'),'TrocaSenhaPadraoActionForm.getUsua_nome_Ajax',new Array('usua_nome','usua_id'));" styleClass="disabled" tabindex="-1" readonly="true" size="11"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Novo Email
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="usua_email" styleId="usua_email" styleClass="baseField" size="80" maxlength="100"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="r" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="s" value="Senha Padr�o" styleClass="baseButton" property="select_action">
                    </html:submit>
                    <html:submit accesskey="a" value="Alterar Email" styleClass="baseButton" property="update_action">
                    </html:submit>
                    <html:submit value="Desbloquear" styleClass="baseButton" property="desbloquear_action">
                    </html:submit>
                    <html:submit value="Bloquear" styleClass="baseButton" property="bloquear_action">
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

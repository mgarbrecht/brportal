<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Cadastro de administradores do Catalogo
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
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(198)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/AdministradoresCatalogoForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="codigo_usuario"/>
                    <html:errors property="nome_usuario"/>
                    <html:errors property="senha_usuario"/>
                    <html:errors property="codigo_regional"/>
                    <html:errors property="email"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios_tablets"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Código Usuário
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_usuario" styleId="codigo_usuario" styleClass="baseField" size="40" maxlength="40"/>
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
                    <html:text property="nome_usuario" styleId="nome_usuario" styleClass="baseField" size="30" maxlength="30"/>
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
                    <html:text property="senha_usuario" styleId="senha_usuario" styleClass="baseField" size="30" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Regional
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_regional" styleId="codigo_regional" styleClass="baseField" size="3" maxlength="3"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Email
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="email" styleId="email" styleClass="baseField" size="50" maxlength="50"/>
                  </td>
                </tr>

                <html:hidden property="pos"/>
                <%
                {
                  %>
                  <%
                  java.util.Vector res_Jw_usuarios_tablets = (java.util.Vector)session.getAttribute("res_Jw_usuarios_tablets");
                  %>
                  <%
                  String pos = "0";
                  if (res_Jw_usuarios_tablets!=null) {
                    pos = "" + res_Jw_usuarios_tablets.size();
                  }
                  %>
                </table>
                <table class="navigatorTable" style="width:99%;">
                  <tr class="navigatorTr" >
                    <td class="navigatorTd" >
                      <img border="0" style="cursor:pointer" src="../img/first.gif" title="First" onclick="javascript:new_pos0('1');" />
                      &nbsp;
                      <img border="0" style="cursor:pointer" src="../img/prev.gif" title="Previous" onclick="javascript:new_pos0(parseInt(document.forms[0].navigation_pos0.value)-1);" accesskey="," />
                      &nbsp;
                      <input type="text" name="navigation_pos0" size="5" class="navigatorInput" >
                      &nbsp;
                      <img border="0" style="cursor:pointer" src="../img/next.gif" title="Next"  onclick="javascript:new_pos0(parseInt(document.forms[0].navigation_pos0.value)+1);" accesskey="." />
                      &nbsp;
                      <img border="0" style="cursor:pointer" src="../img/last.gif" title="Last" onclick="javascript:new_pos0(document.forms[0].navigation_max0.value);">
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
                        <html:submit accesskey="p" styleClass="baseButton" property="select_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:submit>
                        <html:submit accesskey="i" styleClass="baseButton" property="insert_action">
                          <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                        </html:submit>
                        <html:submit accesskey="a" styleClass="baseButton" property="update_action">
                          <bean:message bundle="ApplicationResources" key="jsp.update"/>
                        </html:submit>
                        <html:submit accesskey="a" onclick="return confirmSubmit('');" styleClass="baseButton" property="delete_action">
                          <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                        </html:submit>
                        <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                          <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                        </html:submit>
                      </td>
                    </tr>
                  </table>

                </html:form>
                <script type="text/javascript">
                  var focusControl = document.forms[0].elements["codigo_usuario"];
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

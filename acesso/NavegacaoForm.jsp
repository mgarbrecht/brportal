<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Cadastro de Menu
    </title>
  </head>
  <center>
    <body >
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header_sem_ajuda.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(47)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <table class="positionTable" width="100%">
              <tr class="positionTr">
                <td align="left" valign="top"  >
                  <html:form action="acesso/NavegacaoForm.do" method="POST" styleClass="baseForm">
                    <table class="itemTable" style='width:;'>
                      <tr>
                        <td align="left">
                          <jsp:include page="../system/menu_acesso.jsp"/>
                        </td>
                      </tr>
                    </table>
                  </html:form>

                </td>
                <td class="positionTd">
                  <html:form action="acesso/NavegacaoForm.do" method="post" styleClass="baseForm" target="_self">
                    <table class="messageTable" style='width:99%;'>
                      <tr class="messageTr" >
                        <td class="messageTd">
                          <bean:message key="div.campos*"/>
                          <html:errors property="menu_nome"/>
                          <html:errors property="menu_texto"/>
                          <html:errors property="menu_pai_menu_id"/>
                          <html:errors property="menu_nome_pai"/>
                          <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Menus"/>
                        </td>
                      </tr>
                    </table>

                    <table class="itemTable"  style="width:99%;">
                      <html:hidden property="menu_id"/>
                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Nome
                          </span>
                          <bean:message key="jsp.fieldnotnull"/>
                        </td>
                        <td class="formField">
                          <html:text property="menu_nome" onblur="javascript:toUpperCase(this);" onkeyup="javascript:toUpperCase(this);" styleClass="baseField" size="80" maxlength="80"/>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Texto
                          </span>
                          <bean:message key="jsp.fieldnotnull"/>
                        </td>
                        <td class="formField">
                          <html:text property="menu_texto" styleClass="baseField" size="80" maxlength="255"/>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Pai
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="menu_pai_menu_id" onblur="if(this.value==''){menu_nome_pai.value='';}" styleClass="baseField" size="10" maxlength="10"/>
                          <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_menu_pai_menu_id()"  >
                          <script type="text/javascript">
                            function lov_open_menu_pai_menu_id() {
                              window.open('../lov/LvNavegacaoLov.do?resetfull_action=&returnBlock=1&return0=menu_pai_menu_id&return1=menu_nome_pai','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                            }
                          </script>
                          <span class="spamFormLabel">
                          </span>
                          <html:text property="menu_nome_pai" styleId="menu_nome_pai" styleClass="disabled" title="-1" readonly="true" size="50"/>
                        </td>
                      </tr>

                      <html:hidden property="pos"/>
                    </table>

                    <table class="buttonTable" style='width:99%;'>
                      <tr class="buttonTr">
                        <td class="buttonTd">
                          <html:submit accesskey="i" styleClass="baseButton" property="insert_action">
                            <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                          </html:submit>
                          <html:submit accesskey="p" value="pop" styleClass="myhidden" property="pop_action">
                          </html:submit>
                          <html:submit accesskey="u" styleClass="baseButton" property="update_action">
                            <bean:message bundle="ApplicationResources" key="jsp.update"/>
                          </html:submit>
                          <html:submit accesskey="d" styleClass="baseButton" property="delete_action">
                            <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                          </html:submit>
                          <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                            <bean:message bundle="ApplicationResources" key="jsp.select"/>
                          </html:submit>
                          <html:submit value="Incluir Item" styleClass="baseButton" property="incluir_item_action">
                          </html:submit>
                        </td>
                      </tr>
                    </table>

                  </html:form>
                  <script type="text/javascript">
                    var focusControl = document.forms[1].elements["menu_nome"];
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ItemNavegacaoActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ItemNavegacaoActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("itme_id","itme_id");
    hashMapLabel.set("itme_nome","Nome");
    hashMapLabel.set("itme_texto","Texto");
    hashMapLabel.set("itme_comando","Comando");
    hashMapLabel.set("itme_menu_id","Menu");
    hashMapLabel.set("menu_nome","");
    hashMapLabel.set("itme_doin_id","Documento/<br>Interface");
    hashMapLabel.set("doin_nome","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Cadastro de Item de Menu
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(46)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <table class="positionTable" width="100%">
              <tr class="positionTr">
                <td align="left" valign="top" >
                  <html:form action="acesso/ItemNavegacaoForm.do" method="POST" styleClass="baseForm">
                    <table class="itemTable" style='width:;' >
                      <tr>
                        <td align="left">
                          <jsp:include page="../system/menu_acesso.jsp"/>
                        </td>
                      </tr>
                    </table>
                  </html:form>
                </td>
                <td class="positionTd">
                  <html:form action="acesso/ItemNavegacaoForm.do" method="post" styleClass="baseForm" target="_self">
                    <table class="messageTable" style='width:99%;'>
                      <tr class="messageTr" >
                        <td class="messageTd">
                          <bean:message key="div.campos*"/>
                          <html:errors property="itme_nome"/>
                          <html:errors property="itme_texto"/>
                          <html:errors property="itme_comando"/>
                          <html:errors property="itme_menu_id"/>
                          <html:errors property="menu_nome"/>
                          <html:errors property="itme_doin_id"/>
                          <html:errors property="doin_nome"/>
                          <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Itens_menus"/>
                        </td>
                      </tr>
                    </table>

                    <table class="itemTable"  style="width:99%;">
                      <html:hidden property="itme_id"/>
                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Nome
                          </span>
                          <bean:message key="jsp.fieldnotnull"/>
                        </td>
                        <td class="formField">
                          <html:text property="itme_nome" styleClass="baseField" size="80" maxlength="80"/>
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
                          <html:text property="itme_texto" styleClass="baseField" size="60" maxlength="255"/>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Comando
                          </span>
                          <bean:message key="jsp.fieldnotnull"/>
                        </td>
                        <td class="formField">
                          <html:text property="itme_comando" styleClass="baseField" size="60" maxlength="255"/>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Menu
                          </span>
                          <bean:message key="jsp.fieldnotnull"/>
                        </td>
                        <td class="formField">
                          <html:text property="itme_menu_id" onblur="if(this.value!=''){fillFields(1,new Array('itme_menu_id'),'ItemNavegacaoActionForm.getMenu_nome_Ajax',new Array('menu_nome'))}else{menu_nome.value=''};" styleClass="baseField" size="10" maxlength="10"/>
                          <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_itme_menu_id()"  >
                          <script type="text/javascript">
                            function lov_open_itme_menu_id() {
                              window.open('../lov/LvNavegacaoLov.do?resetfull_action=&returnBlock=1&return0=itme_menu_id&return1=menu_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                            }
                          </script>
                          <span class="spamFormLabel">
                          </span>
                          <html:text property="menu_nome" styleId="menu_nome" styleClass="disabled" tabindex="-1" readonly="true" size="60" maxlength="60"/>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Documento/
                            <br>
                            Interface
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="itme_doin_id" onblur="if(this.value!=''){fillFields(1,new Array('itme_doin_id'),'ItemNavegacaoActionForm.getDoin_nome_Ajax',new Array('doin_nome'))}else{doin_nome.value=''};" styleClass="baseField" size="10" maxlength="10"/>
                          <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_itme_doin_id()"  >
                          <script type="text/javascript">
                            function lov_open_itme_doin_id() {
                              window.open('../lov/LvDocumentoInterfaceLov.do?resetfull_action=&returnBlock=1&return0=itme_doin_id&return1=doin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                            }
                          </script>
                          <span class="spamFormLabel">
                          </span>
                          <html:text property="doin_nome" styleId="doin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="60" maxlength="80"/>
                        </td>
                      </tr>

                    </table>

                    <table class="buttonTable" style='width:99%;'>
                      <tr class="buttonTr">
                        <td class="buttonTd">
                          <html:submit accesskey="i" styleClass="baseButton" property="insert_action">
                            <bean:message bundle="ApplicationResources" key="jsp.insert"/>
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
                          <html:submit accesskey="p" value="pop" styleClass="myhidden" property="pop_action">
                          </html:submit>
                        </td>
                      </tr>
                    </table>

                    <script type="text/javascript">
                      function validar() {
                        regras[0] = new Regra('Nome',document.forms[0].itme_nome.value,'');
                        regras[1] = new Regra('Texto',document.forms[0].itme_texto.value,'');
                        regras[2] = new Regra('Comando',document.forms[0].itme_comando.value,'');
                        regras[3] = new Regra('Menu',document.forms[0].itme_menu_id.value,'');
                        return validate(regras);
                      }
                    </script>
                  </html:form>
                  <script type="text/javascript">
                    var focusControl = document.forms[1].elements["itme_nome"];
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

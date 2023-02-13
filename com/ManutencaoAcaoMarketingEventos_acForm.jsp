<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ManutencaoAcaoMarketingEventos_acActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ManutencaoAcaoMarketingEventos_acActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("cracha","Usuário");
    hashMapLabel.set("nome","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Alteração Usuário
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
                  <%
                  acesso.Usuario user = (acesso.Usuario) session.getAttribute("User");
                  if(!user.isSuperUsuario() && !user.isAutorizado(160)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ManutencaoAcaoMarketingEventos_acForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="cracha"/>
                    <html:errors property="nome"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing_usuarios"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Usuário
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="cracha" styleId="cracha" onblur="if(this.value!=''){fillFields(0,new Array('cracha'),'ManutencaoAcaoMarketingEventos_acActionForm.getNome_Ajax',new Array('nome'));}else{nome.value='';}" styleClass="baseField" size="10" maxlength="22"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cracha()"  >
                    <script type="text/javascript">
                      function lov_open_cracha() {
                        window.open('..//lov/LvAcaoMarketingUsuariosLov.do?resetfull_action=&returnBlock=0&return0=cracha&return1=nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="nome" styleId="nome" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="40"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="a" onclick="if(document.forms[0].cracha.value==''){return false;}opener.document.forms[1].cracha_alterar.value=document.forms[0].cracha.value;opener.document.forms[1].trocar_cracha_action.click();window.close();" styleClass="baseButton" property="update_action">
                      <bean:message bundle="ApplicationResources" key="jsp.update"/>
                    </html:button>
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["cracha"];
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

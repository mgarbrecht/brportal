<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/AcessosTrocaIdentidadeActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = AcessosTrocaIdentidadeActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("atid_usua_id","Usuário");
    hashMapLabel.set("usua_nome","");
    hashMapLabel.set("atid_tien_id","Tipo Entidade");
    hashMapLabel.set("tien_tipo","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Troca de Identidade - Liberação de Acessos
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(282)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="acesso/AcessosTrocaIdentidadeForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="atid_usua_id"/>
                    <html:errors property="usua_nome"/>
                    <html:errors property="atid_tien_id"/>
                    <html:errors property="tien_tipo"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_acessos_troca_identidade"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Usuário
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="atid_usua_id" styleId="atid_usua_id" onblur="fillFields(0,new Array('atid_usua_id'),'AcessosTrocaIdentidadeActionForm.getUsua_nome_Ajax',new Array('usua_nome'));" styleClass="baseField" size="10" maxlength="23"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_atid_usua_id()"  >
                    <script type="text/javascript">
                      function lov_open_atid_usua_id() {
                        window.open('..//lov/LvUsuarioLov.do?resetfull_action=&returnBlock=0&return0=atid_usua_id&return1=usua_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="usua_nome" styleId="usua_nome" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="240"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo Entidade
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="atid_tien_id" styleId="atid_tien_id" onblur="fillFields(0,new Array('atid_tien_id'),'AcessosTrocaIdentidadeActionForm.getTien_tipo_Ajax',new Array('tien_tipo'));" styleClass="baseField" size="10" maxlength="11"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_atid_tien_id()"  >
                    <script type="text/javascript">
                      function lov_open_atid_tien_id() {
                        window.open('..//lov/LvTipoEntidadeNegocioLov.do?resetfull_action=&returnBlock=0&return0=atid_tien_id&return1=tien_tipo','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="tien_tipo" styleId="tien_tipo" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="240"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="baseButton" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="i" value="Cadastrar Novo Acesso" styleClass="baseButton" property="insert_action">
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["atid_usua_id"];
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

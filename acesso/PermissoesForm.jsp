<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/PermissoesActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = PermissoesActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("tien_id","Tipo de Entidade<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("tien_tipo","");
    hashMapLabel.set("enne_id","Entidade Negócio<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("enne_descricao","");
    hashMapLabel.set("usua_id","Usuário<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("usua_nome","");
    hashMapLabel.set("doin_id","Documento/Interface<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("doin_nome","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Consulta de Permissões
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
                  if(!user.isSuperUsuario()){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="acesso/PermissoesForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <div class\='div10l'>
                        Um dos campos com
                        <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        deve ser preenchido.
                      </div>
                    </div>
                    <html:errors property="tien_id"/>
                    <html:errors property="tien_tipo"/>
                    <html:errors property="enne_id"/>
                    <html:errors property="enne_descricao"/>
                    <html:errors property="usua_id"/>
                    <html:errors property="usua_nome"/>
                    <html:errors property="doin_id"/>
                    <html:errors property="doin_nome"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_permissoes"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo de Entidade
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="tien_id" styleId="tien_id" onblur="if(this.value!=''){fillFields(0,new Array('tien_id'),'PermissoesActionForm.getTien_tipo_Ajax',new Array('tien_tipo'))}{document.forms[0].tien_tipo.value='';};" styleClass="baseField" size="10" maxlength="10"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_tien_id()"  >
                    <script type="text/javascript">
                      function lov_open_tien_id() {
                        window.open('..//lov/LvTipoEntidadeNegocioLov.do?resetfull_action=&returnBlock=0&return0=tien_id&return1=tien_tipo','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="tien_tipo" styleId="tien_tipo" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Entidade Negócio
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="enne_id" styleId="enne_id" onblur="if(this.value!=''){fillFields(0,new Array('enne_id'),'PermissoesActionForm.getEnne_descricao_Ajax',new Array('enne_descricao'))}else{document.forms[0].enne_descricao.value='';};" styleClass="baseField" size="10" maxlength="10"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_enne_id()"  >
                    <script type="text/javascript">
                      function lov_open_enne_id() {
                        window.open('..//lov/LvEntidadeNegocioLov.do?resetfull_action=&returnBlock=0&return0=enne_id&return1=enne_descricao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="enne_descricao" styleId="enne_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="60" maxlength="255"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Usuário
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="usua_id" styleId="usua_id" onblur="if(this.value!=''){fillFields(0,new Array('usua_id'),'PermissoesActionForm.getUsua_nome_Ajax',new Array('usua_nome'))}else{document.forms[0].usua_nome.value='';};" styleClass="baseField" size="10" maxlength="22"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_usua_id()"  >
                    <script type="text/javascript">
                      function lov_open_usua_id() {
                        window.open('..//lov/LvUsuarioLov.do?resetfull_action=&returnBlock=0&return0=usua_id&return1=usua_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="usua_nome" styleId="usua_nome" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Documento/Interface
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="doin_id" styleId="doin_id" onblur="fillFields(0,new Array('doin_id'),'PermissoesActionForm.getDoin_nome_Ajax',new Array('doin_nome'));" styleClass="baseField" size="10"/>
                    <input type="button" class="lovButton"  value="..." tabindex="-1" onclick="javascript:lov_open_doin_id()"  >
                    <script type="text/javascript">
                      function lov_open_doin_id() {
                        window.open('..//lov/LvDocumentoInterfaceLov.do?resetfull_action=&returnBlock=0&return0=doin_id&return1=doin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="doin_nome" styleId="doin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="80"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" onclick="bloqueia();" styleClass="baseButton" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["tien_id"];
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

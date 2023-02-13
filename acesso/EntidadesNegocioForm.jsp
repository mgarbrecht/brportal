<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/EntidadesNegocioActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = EntidadesNegocioActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("enne_descricao","Descrição");
    hashMapLabel.set("enne_tien_id","Tipo");
    hashMapLabel.set("tien_tipo","");
    hashMapLabel.set("enne_chave","Chave");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Entidades de Negócio
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
                  if(!user.isSuperUsuario()){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="acesso/EntidadesNegocioForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="enne_descricao"/>
                    <html:errors property="enne_tien_id"/>
                    <html:errors property="tien_tipo"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Entidades_negocio"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="enne_descricao" styleClass="baseField" size="60" maxlength="255"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="enne_tien_id" onblur="if(this.value!=''){fillFields(0,new Array('enne_tien_id'),'EntidadesNegocioActionForm.getTien_tipo_Ajax',new Array('tien_tipo'))}else{tien_tipo.value=''};" styleClass="baseField" size="10" maxlength="10"/>
                    <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_enne_tien_id()"  >
                    <script type="text/javascript">
                      function lov_open_enne_tien_id() {
                        window.open('../lov/LvTipoEntidadeNegocioLov.do?resetfull_action=&returnBlock=0&return0=enne_tien_id&return1=tien_tipo','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="tien_tipo" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="40"/>
                  </td>
                </tr>

                <html:hidden property="enne_chave"/>
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
              var focusControl = document.forms[0].elements["enne_descricao"];
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

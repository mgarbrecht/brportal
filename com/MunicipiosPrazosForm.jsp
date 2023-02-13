<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/MunicipiosPrazosActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = MunicipiosPrazosActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("est_unifed","UF");
    hashMapLabel.set("codigo","Município");
    hashMapLabel.set("descricao_municipio","");
    hashMapLabel.set("descricao","Desc. Municipio");
    hashMapLabel.set("distrito","Desc. Distrito");
    hashMapLabel.set("codigo_ibge","Cód. IBGE");
    hashMapLabel.set("cep_inicial","CEP Inicial");
    hashMapLabel.set("cep_final","CEP Final");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Prazos de Entrega por Município
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(11)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/MunicipiosPrazosForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="est_unifed"/>
                    <html:errors property="codigo"/>
                    <html:errors property="descricao_municipio"/>
                    <html:errors property="descricao"/>
                    <html:errors property="distrito"/>
                    <html:errors property="codigo_ibge"/>
                    <html:errors property="cep_inicial"/>
                    <html:errors property="cep_final"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_prazos_municipios"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      UF
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="est_unifed" styleId="est_unifed" onblur="fillFields(0,new Array('codigo','est_unifed'),'MunicipiosPrazosActionForm.getDescricao_municipio_Ajax',new Array());" styleClass="baseField" size="1">
                      <html:options property="est_unifedList" labelProperty="est_unifedLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Município
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo" styleId="codigo" onblur="if(this.value!=''){fillFields(0,new Array('codigo','est_unifed'),'MunicipiosPrazosActionForm.getDescricao_municipio_Ajax',new Array());}else{descricao_municipio.value='';}" styleClass="baseField" size="6" maxlength="22"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo()"  >
                    <script type="text/javascript">
                      function lov_open_codigo() {
                        window.open('..//lov/LvMunicipiosLov.do?resetfull_action=&returnBlock=0&return0=codigo&return1=descricao_municipio','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="descricao_municipio" styleId="descricao_municipio" styleClass="disabled" tabindex="-1" readonly="true" size="60"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Desc. Municipio
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="descricao" styleId="descricao" onblur="javascript:toUpperCase(this);" styleClass="baseField" size="60" maxlength="120"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Desc. Distrito
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="distrito" styleId="distrito" styleClass="baseField" size="60" maxlength="120"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cód. IBGE
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_ibge" styleId="codigo_ibge" styleClass="baseField" size="10" maxlength="20"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      CEP Inicial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cep_inicial" styleId="cep_inicial" styleClass="baseField" size="8" maxlength="8"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      CEP Final
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cep_final" styleId="cep_final" styleClass="baseField" size="8" maxlength="8"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="p" onclick="bloqueia();resetfull1_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:button>
                    <script>
                      function getKeySite(keyStroke) {
                        isNetscape=(document.layers);
                        eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                        which = String.fromCharCode(eventChooser).toLowerCase();
                        keyBuffer = which;
                        if(eventChooser == 13){ bloqueia();
                      if(document.forms[0].select1_action.disabled==true){return false;}
                      document.forms[0].select1_action.disabled=true;
                      document.forms[0].resetfull1_action.disabled=true;
                      document.forms[0].select_action.click();
                    }
                  }
                </script>
                <SCRIPT>
                  document.onkeypress = getKeySite;
                  </SCRIPT><html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                  <html:submit accesskey="p" styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                  <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form><script type="text/javascript">
                  var focusControl = document.forms[0].elements["codigo"];
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

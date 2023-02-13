<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/MunicipiosPrazos_acActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = MunicipiosPrazos_acActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("id","Id");
    hashMapLabel.set("codigo","Município");
    hashMapLabel.set("descricao_municipio","");
    hashMapLabel.set("codigo_ibge","Código IBGE");
    hashMapLabel.set("est_unifed","UF");
    hashMapLabel.set("descricao","Descrição Distrito");
    hashMapLabel.set("prazo_entrega","Prazo Entrega");
    hashMapLabel.set("sigla_transportadora","Sigla_transportadora");
    hashMapLabel.set("segunda","Segunda");
    hashMapLabel.set("terca","Terça");
    hashMapLabel.set("quarda","Quarta");
    hashMapLabel.set("quinta","Quinta");
    hashMapLabel.set("sexta","Sexta");
    hashMapLabel.set("sabado","Sábado");
    hashMapLabel.set("domingo","Domingo");
    hashMapLabel.set("dthr_inclusao","Dthr_inclusao");
    hashMapLabel.set("usuario_inclusao","Usuario_inclusao");
    hashMapLabel.set("dthr_alteracao","Dthr_alteracao");
    hashMapLabel.set("usuario_alteracao","Usuario_alteracao");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Cadastro de Prazos de Entrega por Município
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(14)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/MunicipiosPrazos_acForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="codigo"/>
                    <html:errors property="descricao_municipio"/>
                    <html:errors property="codigo_ibge"/>
                    <html:errors property="est_unifed"/>
                    <html:errors property="descricao"/>
                    <html:errors property="prazo_entrega"/>
                    <html:errors property="segunda"/>
                    <html:errors property="terca"/>
                    <html:errors property="quarda"/>
                    <html:errors property="quinta"/>
                    <html:errors property="sexta"/>
                    <html:errors property="sabado"/>
                    <html:errors property="domingo"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Municipios_prazos"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <html:hidden property="id"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Município
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="codigo" styleId="codigo" onblur="fillFields(0,new Array('codigo'),'MunicipiosPrazos_acActionForm.getDescricao_municipio_Ajax',new Array('descricao_municipio','codigo_ibge'));" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="20"/>
                    <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_codigo()"  >
                    <script type="text/javascript">
                      function lov_open_codigo() {
                        window.open('..//lov/LvMunicipiosLov.do?resetfull_action=&returnBlock=0&return0=codigo&return1=descricao_municipio&return2=codigo_ibge&return3=est_unifed','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="descricao_municipio" styleId="descricao_municipio" styleClass="disabled" tabindex="-1" readonly="true" size="65"/>
                    <span class="spamFormLabel">
                      Código IBGE
                    </span>
                    <html:text property="codigo_ibge" styleId="codigo_ibge" styleClass="disabled" tabindex="-1" readonly="true" size="7" maxlength="20"/>
                    <span class="spamFormLabel">
                      UF
                    </span>
                    <html:text property="est_unifed" styleId="est_unifed" styleClass="disabled" tabindex="-1" readonly="true" size="2"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descrição Distrito
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="descricao" styleId="descricao" styleClass="baseField" size="60" maxlength="60"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Prazo Entrega
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="prazo_entrega" styleId="prazo_entrega" styleClass="baseField" size="4" maxlength="20"/>
                  </td>
                </tr>

                <html:hidden property="sigla_transportadora"/>
                <tr class="itemTr">
                  <td class="formLabel">
                  </td>
                  <td class="formField">
                    <table border="1">
                      <tr style="background-color: lightblue">
                        <td style="text-align: center; font-weight: bold">
                          &nbsp;Segunda&nbsp;
                        </td>
                        <td style="text-align: center; font-weight: bold">
                          &nbsp;Terça&nbsp;
                        </td>
                        <td style="text-align: center; font-weight: bold">
                          &nbsp;Quarta&nbsp;
                        </td>
                        <td style="text-align: center; font-weight: bold">
                          &nbsp;Quinta&nbsp;
                        </td>
                        <td style="text-align: center; font-weight: bold">
                          &nbsp;Sexta&nbsp;
                        </td>
                        <td style="text-align: center; font-weight: bold">
                          &nbsp;Sábado&nbsp;
                        </td>
                        <td style="text-align: center; font-weight: bold">
                          &nbsp;Domingo&nbsp;
                        </td>
                      </tr>
                      <tr>
                        <td style="text-align: center">
                          <html:checkbox property="segunda" styleId="segunda" styleClass="baseField" value="S"/>
                        </td>
                        <td style="text-align: center">
                          <html:checkbox property="terca" styleId="terca" styleClass="baseField" value="S"/>
                        </td>
                        <td style="text-align: center">
                          <html:checkbox property="quarda" styleId="quarda" styleClass="baseField" value="S"/>
                        </td>
                        <td style="text-align: center">
                          <html:checkbox property="quinta" styleId="quinta" styleClass="baseField" value="S"/>
                        </td>
                        <td style="text-align: center">
                          <html:checkbox property="sexta" styleId="sexta" styleClass="baseField" value="S"/>
                        </td>
                        <td style="text-align: center">
                          <html:checkbox property="sabado" styleId="sabado" styleClass="baseField" value="S"/>
                        </td>
                        <td style="text-align: center">
                          <html:checkbox property="domingo" styleId="domingo" styleClass="baseField" value="S"/>
                        </td>
                      </tr>
                    </table>
                  </td>
                </tr>

                <html:hidden property="dthr_inclusao"/>
                <html:hidden property="usuario_inclusao"/>
                <html:hidden property="dthr_alteracao"/>
                <html:hidden property="usuario_alteracao"/>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="i" styleClass="baseButton" property="insert_action">
                      <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["descricao"];
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

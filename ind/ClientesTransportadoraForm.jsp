<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ClientesTransportadoraActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ClientesTransportadoraActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("codigo_transportadora","Transportadora");
    hashMapLabel.set("razao_transportadora","");
    hashMapLabel.set("codigo_cliente","Cliente");
    hashMapLabel.set("razao_social","");
    hashMapLabel.set("consignatarios","Consignatários");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Clientes por Transportadora
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(35)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/ClientesTransportadoraForm.do" method="post" styleClass="baseForm">
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
                    <html:errors property="codigo_transportadora"/>
                    <html:errors property="razao_transportadora"/>
                    <html:errors property="codigo_cliente"/>
                    <html:errors property="razao_social"/>
                    <html:errors property="consignatarios"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_transportadora"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String transportadora = "";
                acesso.Sessao sessao = new acesso.Sessao(session);
                if(sessao.getTipoEntidadeNegocio().equals("TRANSPORTADORA")){
                  transportadora = sessao.getChave();
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Transportadora
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">

                    <%
                    if(transportadora.equals("")){
                      %>
                      <html:text property="codigo_transportadora" styleId="codigo_transportadora" onblur="fillFields(0,new Array('codigo_transportadora'),'ClientesTransportadoraActionForm.getRazao_transportadora_Ajax',new Array('razao_transportadora'));" styleClass="baseField" size="10" maxlength="10"/>
                      <input type="button" class="lovButton"  value="..." tabindex="-1" onclick="javascript:lov_open_codigo_transportadora()"  >

                      <%
                    } else {
                      %>

                      <html:text property="codigo_transportadora" styleId="codigo_transportadora" value="<%= transportadora %>" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10"/>
                      <input type="button" class="lovButton" disabled="true" value="..." tabindex="-1" onclick="javascript:lov_open_codigo_transportadora()"  >

                      <%
                    }
                    %>
                    <script type="text/javascript">
                      function lov_open_codigo_transportadora() {
                        window.open('..//lov/LvTransportadoraLov.do?resetfull_action=&returnBlock=0&return0=codigo_transportadora&return1=razao_transportadora','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="razao_transportadora" styleId="razao_transportadora" styleClass="disabled" tabindex="-1" readonly="true" size="50" maxlength="100"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cliente
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_cliente" styleId="codigo_cliente" onblur="fillFields(0,new Array('codigo_cliente'),'ClientesTransportadoraActionForm.getRazao_social_Ajax',new Array('razao_social'));" styleClass="baseField" size="10" maxlength="10"/>
                    <input type="button" class="lovButton"  value="..." tabindex="-1" onclick="javascript:lov_open_codigo_cliente()"  >
                    <script type="text/javascript">
                      function lov_open_codigo_cliente() {
                        window.open('..//lov/LvClienteLov.do?resetfull_action=&returnBlock=0&return0=codigo_cliente&return1=razao_social','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="razao_social" styleId="razao_social" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="100"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Consignatários
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="consignatarios" styleId="consignatarios" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="S">
                        Sim
                      </html:option>
                      <html:option styleClass="baseOption" value="N">
                        Não
                      </html:option>
                    </html:select>
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
                  <html:submit accesskey="s" styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                  <html:submit accesskey="r" styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form><script type="text/javascript">
                  var focusControl = document.forms[0].elements["codigo_transportadora"];
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

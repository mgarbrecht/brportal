<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ClientesGruposEconomicosActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ClientesGruposEconomicosActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("gre_grupo","Grupo");
    hashMapLabel.set("gre_descricao","");
    hashMapLabel.set("cli_cdgo","Cliente");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("cli_nome","cli_nome");
    hashMapLabel.set("razao_social","Raz�o Social");
    hashMapLabel.set("descricao_grupo","Descri��o Grupo");
    hashMapLabel.set("situacao_cliente","Situa��o Cliente");
    hashMapLabel.set("situacao_cliente_grupo","Situa��o Cliente/Grupo Econ�mico");
    hashMapLabel.set("situacao_cliente_representante","Situa��o Cliente/Representante");
    hashMapLabel.set("tipo","Tipo");
    hashMapLabel.set("abre_automaticamente","Abre o Relat�rio Automaticamente");
    hashMapLabel.set("mensagem","");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Clientes por Grupo Econ�mico
    </title>
  </head>
  <center>
    <body onload="if('<%= (String)request.getAttribute("arquivo") %>' == 'null'){if(document.forms[0].tipo.value=='pdf'){document.forms[0].abre_automaticamente.checked=false;document.forms[0].mensagem.value='';}}if(document.forms[0].tipo.value=='pdf'){if(document.forms[0].abre_automaticamente.checked==true){if('<%= (String)request.getAttribute("arquivo") %>' != 'null'){window.open('<%= (String)request.getAttribute("arquivo") %>','_blank');}}}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(116)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ClientesGruposEconomicosForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="gre_grupo"/>
                    <html:errors property="gre_descricao"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="razao_social"/>
                    <html:errors property="descricao_grupo"/>
                    <html:errors property="situacao_cliente"/>
                    <html:errors property="situacao_cliente_grupo"/>
                    <html:errors property="situacao_cliente_representante"/>
                    <html:errors property="abre_automaticamente"/>
                    <html:errors property="mensagem"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_grupos_economicos"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Grupo
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="gre_grupo" onblur="fillFields(0,new Array('gre_grupo'),'ClientesGruposEconomicosActionForm.getGre_descricao_Ajax',new Array('gre_descricao'));" styleClass="baseField" size="6" maxlength="6"/>
                    <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_gre_grupo()"  >
                    <script type="text/javascript">
                      function lov_open_gre_grupo() {
                        window.open('../lov/LvGrupoEconomicoLov.do?resetfull_action=&returnBlock=0&return0=gre_grupo&return1=gre_descricao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="gre_descricao" styleId="gre_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cliente
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_cdgo" onblur="fillFields(0,new Array('cli_cdgo'),'ClientesGruposEconomicosActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));" styleClass="baseField" size="10" maxlength="22"/>
                    <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_cli_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_cli_cdgo() {
                        window.open('../lov/LvClienteLov.do?resetfull_action=&returnBlock=0&return0=cli_cdgo&return1=cli_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cli_rzao" styleId="cli_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                  </td>
                </tr>

                <html:hidden property="cli_nome"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Raz�o Social
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="razao_social" styleClass="baseField"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descri��o Grupo
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="descricao_grupo" styleClass="baseField"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situa��o Cliente
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="situacao_cliente" styleId="situacao_cliente" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="A">
                        Ativos
                      </html:option>
                      <html:option styleClass="baseOption" value="I">
                        Inativos
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situa��o Cliente/Grupo Econ�mico
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="situacao_cliente_grupo" styleId="situacao_cliente_grupo" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="A">
                        Ativos
                      </html:option>
                      <html:option styleClass="baseOption" value="I">
                        Inativos
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situa��o Cliente/Representante
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="situacao_cliente_representante" styleId="situacao_cliente_representante" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="A">
                        Ativos
                      </html:option>
                      <html:option styleClass="baseOption" value="I">
                        Inativos
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <html:hidden property="tipo" value="html"/>
                <%
                portalbr.com.ClientesGruposEconomicosActionForm clientes = (portalbr.com.ClientesGruposEconomicosActionForm) session.getAttribute("ClientesGruposEconomicosActionForm");
                if((clientes.getTipo()+"").equals("pdf")) {
                  %>
                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Abre o Relat�rio Automaticamente
                      </span>
                    </td>
                    <td class="formField">
                      <html:checkbox property="abre_automaticamente" onclick="if(this.checked==true){mensagem.value='Obs.: Uma nova janela ser� aberta para a visualiza��o do relat�rio.';}else{mensagem.value='';}" styleClass="baseField" value="checked"/>
                      <%
                    } else {
                      %>
                      <html:hidden property="abre_automaticamente" value="checked"/>
                      <%
                    }
                    %>
                    <%
                    portalbr.com.ClientesGruposEconomicosActionForm clientes_mensagem = (portalbr.com.ClientesGruposEconomicosActionForm) session.getAttribute("ClientesGruposEconomicosActionForm");
                    if((clientes_mensagem.getTipo()+"").equals("pdf")) {
                      %>
                      <span class="spamFormLabel" >
                      </span>
                      <html:text property="mensagem" style="background-color:transparent; border-style:none; color:red; background-color:transparent; border-style:none;  text-align:start;" styleClass="baseField" size="80"/>
                    </td>
                  </tr>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                      </span>
                    </td>
                    <td class="formField">

                      <%
                    } else {
                      %>
                      <html:hidden property="mensagem" />
                      <%
                    }
                    %>
                    <%
                    if((String)request.getAttribute("abre_automaticamente")=="N"){
                      %>
                      <table style=width:100%;margin-top:10;>
                        <tr>
                          <td class=columHeader style="text-align:center;">
                            <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                              <bean:message key="report.downloadpdf"/>
                            </a>
                          </td>
                        </tr>
                      </table>
                      <%
                    }
                    %>
                  </table>

                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:button accesskey="p" onclick="bloqueia();resetfull1_action.disabled=true;this.disabled=true;if(document.forms[0].tipo.value=='html'){select_action.click();}else{select2_action.click();}" styleClass="baseButton" property="select1_action">
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
                          if(document.forms[0].tipo.value=='html'){
                            document.forms[0].select_action.click();
                          }else{
                            document.forms[0].select2_action.click();
                          }
                        }
                      }
                    </script>
                    <SCRIPT>
                      document.onkeypress = getKeySite;
                      </SCRIPT>
                      <html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:button>
                      <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:submit styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:submit>
                      <html:submit styleClass="myhidden" property="select2_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:submit styleClass="myhidden" property="refresh_action">
                      <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
                      </html:submit>
                      </td>
                      </tr>
                      </table>

                      </html:form>
                      <script type="text/javascript">
                      var focusControl = document.forms[0].elements["gre_grupo"];
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

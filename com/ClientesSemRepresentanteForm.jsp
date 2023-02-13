<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Clientes Ativos Sem Representante
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(117)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ClientesSemRepresentanteForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="est_descri"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="estado"/>
                    <html:errors property="tipo"/>
                    <html:errors property="abre_automaticamente"/>
                    <html:errors property="mensagem"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_sem_representante"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Estado
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="est_descri" styleClass="baseField" size="1">
                      <html:options property="est_descriList" labelProperty="est_descriLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Razão Social
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_rzao" styleClass="baseField" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Quebra por Estado
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="estado" styleClass="baseField" value="1"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo" onchange="refresh_action.click();" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="html">
                        HTML
                      </html:option>
                      <html:option styleClass="baseOption" value="pdf">
                        PDF
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <%
                portalbr.com.ClientesSemRepresentanteActionForm clientes = (portalbr.com.ClientesSemRepresentanteActionForm) session.getAttribute("ClientesSemRepresentanteActionForm");
                if((clientes.getTipo()+"").equals("pdf")) {
                  %>
                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Abre o Relatório Automaticamente
                      </span>
                    </td>
                    <td class="formField">
                      <html:checkbox property="abre_automaticamente" onclick="if(this.checked==true){mensagem.value='Obs.: Uma nova janela será aberta para a visualização do relatório.';}else{mensagem.value='';}" styleClass="baseField" value="checked"/>
                      <%
                    } else {
                      %>
                      <html:hidden property="abre_automaticamente" value="checked"/>
                      <%
                    }
                    %>
                    <%
                    portalbr.com.ClientesSemRepresentanteActionForm clientes_mensagem = (portalbr.com.ClientesSemRepresentanteActionForm) session.getAttribute("ClientesSemRepresentanteActionForm");
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
                        <html:button accesskey="p" onclick="bloqueia();resetfull1_action.disabled=true;this.disabled=true;if(document.forms[0].tipo.value=='html'){document.forms[0].select_action.click();}else{document.forms[0].select2_action.click();}" styleClass="baseButton" property="select1_action">
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
                          }else {
                            document.forms[0].select2_action.click();
                          }
                        }
                      }
                    </script>
                    <SCRIPT>
                      document.onkeypress = getKeySite;
                      </SCRIPT><html:button onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                      <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                      <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                      <html:submit styleClass="myhidden" property="select2_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                      <html:submit styleClass="myhidden" property="refresh_action"><bean:message bundle="ApplicationResources" key="jsp.refresh"/></html:submit>
                      </td>
                      </tr>
                      </table>

                      </html:form><script type="text/javascript">
                      var focusControl = document.forms[0].elements["cli_rzao"];
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

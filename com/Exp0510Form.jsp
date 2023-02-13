<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/Exp0510ActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = Exp0510ActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("emp_empresa","Empresa");
    hashMapLabel.set("emp_razsoc","");
    hashMapLabel.set("ano_fatura","Ano da Fatura");
    hashMapLabel.set("nr_fatura","Nr. da Fatura");
    hashMapLabel.set("abrir_numeracao","Abrir Numeração");
    hashMapLabel.set("amostra","Fatura de Amostra");
    hashMapLabel.set("mostrar_comprimento_interno","Mostrar Comp. Int.");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Composição do Produto Exportação - Planilha
    </title>
  </head>
  <center>
    <body onload="document.forms[0].ano_fatura.focus();">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(169)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/Exp0510Form.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="emp_empresa"/>
                    <html:errors property="emp_razsoc"/>
                    <html:errors property="ano_fatura"/>
                    <html:errors property="nr_fatura"/>
                    <html:errors property="abrir_numeracao"/>
                    <html:errors property="amostra"/>
                    <html:errors property="mostrar_comprimento_interno"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                portalbr.com.Exp0510ActionForm exp0510ActionForm = (portalbr.com.Exp0510ActionForm)session.getAttribute("Exp0510ActionForm");
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Empresa
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="emp_empresa" styleId="emp_empresa" onblur="if(this.value!=''){fillFields(0,new Array('emp_empresa'),'Exp0510ActionForm.getEmp_razsoc_Ajax',new Array('emp_razsoc'));}else{emp_razsoc.value='';}" styleClass="baseField" value="01" size="3" maxlength="3"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_emp_empresa()"  >
                    <script type="text/javascript">
                      function lov_open_emp_empresa() {
                        window.open('..//lov/LvEmpresaLov.do?resetfull_action=&returnBlock=0&return0=emp_empresa&return1=emp_razsoc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="emp_razsoc" styleId="emp_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="50" maxlength="50"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Ano da Fatura
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="ano_fatura" styleId="ano_fatura" styleClass="baseField" size="4" maxlength="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nr. da Fatura
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="nr_fatura" styleId="nr_fatura" styleClass="baseField" size="4" maxlength="4"/>
                  </td>
                </tr>

                <%
                if((exp0510ActionForm.getAmostra()+"").equalsIgnoreCase("N")
                ||exp0510ActionForm.getAmostra()==null
                ) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Abrir Numeração
                      </span>
                    </td>
                    <td class="formField">
                      <html:select property="abrir_numeracao" styleId="abrir_numeracao" styleClass="baseField" size="1">
                        <html:option styleClass="baseOption" value="N">
                          Não
                        </html:option>
                        <html:option styleClass="baseOption" value="S">
                          Sim
                        </html:option>
                      </html:select>
                    </td>
                  </tr>
                  <%
                } else {
                  %>
                  <html:hidden property="abrir_numeracao" value="N"/>
                  <%
                }
                %>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Fatura de Amostra
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="amostra" styleId="amostra" onchange="refresh_action.click();" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="N">
                        Não
                      </html:option>
                      <html:option styleClass="baseOption" value="S">
                        Sim
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <%
                if((exp0510ActionForm.getAmostra()+"").equalsIgnoreCase("N") || exp0510ActionForm.getAmostra()==null
                ) {
                  %>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Mostrar Comp. Int.
                      </span>
                    </td>
                    <td class="formField">
                      <html:select property="mostrar_comprimento_interno" styleId="mostrar_comprimento_interno" styleClass="baseField" size="1">
                        <html:option styleClass="baseOption" value="N">
                          Não
                        </html:option>
                        <html:option styleClass="baseOption" value="S">
                          Sim
                        </html:option>
                      </html:select>
                    </td>
                  </tr>

                  <%
                } else {
                  %>


                  <html:hidden property="mostrar_comprimento_interno" value="N"/>

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
                          <bean:message key="report.downloadxls"/>
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
                    <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
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
                  <html:submit accesskey="l" styleClass="myhidden" property="refresh_action"><bean:message bundle="ApplicationResources" key="jsp.refresh"/></html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form><script type="text/javascript">
                  var focusControl = document.forms[0].elements["emp_empresa"];
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

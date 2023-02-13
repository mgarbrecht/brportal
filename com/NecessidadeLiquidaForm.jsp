<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page  extends='acesso.web.HttpJspSessao' %>
<html>
  <head>
    <title>
      Consulta Necessidade Líquida
    </title>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
    <bean:message key="page.scriptcalendar"/>

  </head>
  <center>

    <body onload="if(document.forms[0].fornecedor.value=='null'){document.forms[0].for_codigo.focus();}">
      <table class="mainTable" style='width:99%;'>
        <tr>
          <td>
            <table   class="headerTable" style="width:99%" >
              <tr>
                <td class='td10'>
                  <%@ include file="../system/header.jsp" %>
                </td>
              </tr>
            </table>

<%
acesso.Sessao sessao = new acesso.Sessao(session);
if(!user.isSuperUsuario() && !user.isAutorizado(112)){
   response.sendRedirect("../system/Error.jsp");
}
%>

            <html:form action="com/NecessidadeLiquidaForm.do" method="POST" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr">
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_NecessidadeLiquida"/>
                  </td>
                </tr>
              </table>
              <table class="itemTable" style='width:99%;'>
                <%
                portalbr.com.NecessidadeLiquidaActionForm NecessidadeLiquidaActionForm = (portalbr.com.NecessidadeLiquidaActionForm)session.getAttribute("NecessidadeLiquidaActionForm");
                java.util.Date dataatual = new java.util.Date();
                java.text.SimpleDateFormat fData2 = new java.text.SimpleDateFormat("dd/MM/yyyy");
                String pedido_inicial = "";
                String pedido_final = "";

                if((NecessidadeLiquidaActionForm.getPedido_inicial()+"").equals("null")){
                     pedido_inicial = fData2.format(dataatual);
                } else {
                     pedido_inicial = NecessidadeLiquidaActionForm.getPedido_inicial()+"";
                }
                if((NecessidadeLiquidaActionForm.getPedido_final()+"").equals("null")){
                     pedido_final = fData2.format(dataatual);
                } else {
                     pedido_final = NecessidadeLiquidaActionForm.getPedido_final()+"";
                }

                String chave = "";
                String tipo  = "";
                acesso.Usuario u = new acesso.Usuario();
                u = (acesso.Usuario)session.getAttribute("User");
                acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
                acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

                if(!(u.getEntidadeNegocio()==null)){
                  ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                  tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
                  tipo = tipoent.getTipo()+"";
                  if(tipo.equals("FORNECEDOR")){
                    chave = ent.getChave()+"";
                  }
                }
                %>
                <html:hidden property="fornecedor" value="<%= ent.getChave()+"" %>"/>
                <%
                if(chave.equals("")){
                  %>
                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Fornecedor
                      </span>
                      <bean:message key="jsp.fieldnotnull"/>
                    </td>
                    <td class="formField">
                      <html:text property="for_codigo" styleClass="baseField" size="9" maxlength="9"/>
                      <input type="button" class="lovButton" value="..." tabindex="-1" onclick="window.open('../lov/LvFornecedorLov.do?resetfull_action=&returnBlock=0&return0=for_codigo&return1=for_razsoc','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                      <span class="spamFormLabel" >
                      </span>
                      <html:text property="for_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="40"/>
                    </td>
                  </tr>
                  <%
                }
                %>

                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Item
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ies_codigo" styleClass="baseField" size="21" maxlength="21"/>
                    <input type="button" class="lovButton" value="..." tabindex="-1" onclick="if(document.forms[0].fornecedor.value==''){document.forms[0].fornecedor.value=document.forms[0].for_codigo.value;}window.open('../lov/ItemLov.do?resetfull_action=&returnBlock=0&return0=ies_codigo','','scrollbars,height=500,width=580,top=0,left=0,')"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Cor
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cor_cdgo" styleClass="baseField" size="21" maxlength="21"/>
                    <input type="button" class="lovButton" value="..." tabindex="-1" onclick="if(document.forms[0].fornecedor.value==''){document.forms[0].fornecedor.value=document.forms[0].for_codigo.value;}window.open('../lov/LvCorFornecedorLov.do?resetfull_action=&returnBlock=0&return0=cor_cdgo','','scrollbars,height=500,width=580,top=0,left=0,')"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Necess. maior que zero?
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="necessidade" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="-999999999">
                        Não
                      </html:option>
                      <html:option styleClass="baseOption" value="0">
                        Sim
                      </html:option>
                    </html:select>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Entr. de Pedido Inicial
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="pedido_inicial" onkeypress="FormataData(this,event);" styleClass="baseField" value="<%= pedido_inicial %>" size="10" maxlength="10"/>
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['pedido_inicial']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" border="0">
                    </a>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Entr. de Pedido Final
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="pedido_final" onkeypress="FormataData(this,event);" styleClass="baseField" value="<%= pedido_final %>" size="10" maxlength="10"/>
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['pedido_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" border="0">
                    </a>
                  </td>
                </tr>
                <%
                if(!tipo.equals("FORNECEDOR")) {
                  %>
                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Tipo
                      </span>
                    </td>
                    <td class="formField">
                      <html:select property="tipo" styleClass="baseField" size="1">
                        <html:option styleClass="baseOption" value="s">
                          Sintético
                        </html:option>
                        <html:option styleClass="baseOption" value="a">
                          Analítico
                        </html:option>
                      </html:select>
                    </td>
                  </tr>
                  <%
                } else {
                  %>
                  <html:hidden property="tipo" value="s"/>
                  <%
                }
                %>


              </table>
              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="p" styleClass="baseButton" property="select1_action" onclick="if(document.forms[0].fornecedor.value==''){document.forms[0].fornecedor.value=document.forms[0].for_codigo.value;}resetfull1_action.disabled=true;bloqueia();this.disabled=true;bloqueia();document.forms[0].select_action.click();">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:button>
                    <script>
                      function getKeySite(keyStroke) {
                        isNetscape=(document.layers);
                        eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                        which = String.fromCharCode(eventChooser).toLowerCase();
                        keyBuffer = which;
                        if(eventChooser == 13){
                        bloqueia();
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
                    <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                    <html:submit styleClass="myhidden" property="refresh_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                    <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                    </td></tr></table>
                    </html:form>
                    <script type="text/javascript" language="JavaScript">
                    <!--
                    var focusControl = document.forms[0].elements["ies_codigo"];
                    if (focusControl.type != "hidden") {
                      focusControl.focus();
                    }
                  // -->
                  </script>
                </td>
              </tr>
            </table>
          </body>
        </center>
   <div id="question" style="display:none; cursor: default; color: #8D0000; font-size: 14px;">
      <img src="../img/loading.gif" />
      <br>
      <b>Por favor, aguarde...</b>
   </div>
      </html>

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Baixa de Arquivos Transportadoras
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(146)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/BaixaArquivosTransportadorasForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="codigo"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_edi"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String transportadora="";
                acesso.Sessao se = new acesso.Sessao(session);
                String tipo = se.getTipoEntidadeNegocio();
                if(tipo.equals("TRANSPORTADORA")){
                  transportadora = se.getChave();
                  %>
                  <script>
                    top.location='../com/BaixaArquivosTransportadorasForm.do?select_action=';
                  </script>
                  <%
                }
                %>
                <%
                if(transportadora.equals("")){
                  %>
                  <%
                  if(transportadora.equals("")){
                    %>
                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Transportadora
                        </span>
                        <bean:message key="jsp.fieldnotnull"/>
                      </td>
                      <td class="formField">
                        <html:select property="codigo" styleId="codigo" styleClass="baseField" size="1">
                          <html:options property="codigoList" labelProperty="codigoLabelList" styleClass="baseOptions"/>
                        </html:select>
                      </td>
                    </tr>
                    <%
                  }
                  %>

                  <%
                }
                %>
                <html:hidden property="nome"/>
                <html:hidden property="caminho"/>
                <html:hidden property="data_envio"/>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="p" onclick="resetfull1_action.disabled=true;bloqueia();this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:button>
                    <script>
                      function getKeySite(keyStroke) {
                        isNetscape=(document.layers);
                        eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                        which = String.fromCharCode(eventChooser).toLowerCase();
                        keyBuffer = which;
                        if(eventChooser == 13){
                        if(document.forms[0].select1_action.disabled==true){return false;}
                        document.forms[0].select1_action.disabled=true;
                        document.forms[0].resetfull1_action.disabled=true;
                        bloqueia();
                        document.forms[0].select_action.click();
                      }
                    }
                  </script>
                  <SCRIPT>
    document.onkeypress = getKeySite;
</SCRIPT><%
  if(transportadora.equals("")){
%>
<html:submit accesskey="l" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
<% 
  } else {
%>
<html:submit accesskey="l" styleClass="myhidden" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
<% } %>

<html:submit accesskey="p" styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
<html:submit accesskey="l" styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
</td> 
</tr>
</table>

</html:form>
</td> 
</tr>
</table>

</body>
</center>
</html>

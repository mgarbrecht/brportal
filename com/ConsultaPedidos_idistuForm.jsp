<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
<%
   boolean liberaEdicaoDistribuicao = false;
   if(session.getAttribute("liberaEdicaoDistribuicao")!=null){
      liberaEdicaoDistribuicao = true;   
   }
%>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Distribuição única de caixas
    </title>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
    
            <html:form action="com/ConsultaPedidos_idistuForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="ped_nmro"/>
                    <html:errors property="loja"/>
                    <html:errors property="distribuicao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_distribuicao"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Pedido
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ped_nmro" styleId="ped_nmro" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Loja
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="loja" styleId="loja" styleClass="baseField"/>
                    <span class="spamFormLabel">
                    </span>

                    <%
                    if(session.getAttribute("possui_distribuicao")!=null){
                      %>
                      <html:text property="distribuicao" styleId="distribuicao" styleClass="disabled" tabindex="-1" readonly="true" value="Já existe distribuição para esse pedido!" size="35"/>
                      <%
                    } else {
                      %>
                      <html:hidden property="distribuicao" styleId="distribuicao" />
                      <%
                    }
                    %>

                  </td>
                </tr>

              </table>

              <% if(liberaEdicaoDistribuicao){ %>
              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="a" value="Distribuir" styleClass="baseButton" property="update_action">
                    </html:submit>
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                  </td>
                </tr>
              </table>
              <% } %>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["loja"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

          </td>
        </tr>
      </table>


<% if(request.getAttribute("atualizou")!=null){ %>

<script>
opener.document.forms[0].refresh_action.click();
</script>

<% } %>

    </body>
  </center>
</html>

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Visita de Cliente - Inclusão
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(60)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/AgendaVisitasClientes_iForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="agvi_rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="agvi_dt_inicial"/>
                    <html:errors property="agvi_dt_final"/>
                    <html:errors property="agvc_cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="agvc_tipo"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Agenda_visitas_clientes"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Representante
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="agvi_rep_cdgo" styleClass="disabled" readonly="true" value="<%= request.getParameter("agvi_rep_cdgo") %>" size="5" maxlength="5"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" value="<%= request.getParameter("rep_rzao") %>" size="40" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Inicial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="agvi_dt_inicial" styleClass="disabled" readonly="true" value="<%= request.getParameter("agvi_dt_inicial") %>" size="10" maxlength="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Final
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="agvi_dt_final" styleClass="disabled" readonly="true" value="<%= request.getParameter("agvi_dt_final") %>" size="10" maxlength="10"/>
                  </td>
                </tr>

                <html:hidden property="agvc_id"/>
                <html:hidden property="agvc_agvi_id" value="<%= request.getParameter("agvc_agvi_id") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cliente
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="agvc_cli_cdgo" styleClass="baseField" size="10" maxlength="22"/>
                    <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_agvc_cli_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_agvc_cli_cdgo() {
                        window.open('../lov/LvClienteLov.do?resetfull_action=&returnBlock=0&return0=agvc_cli_cdgo&return1=cli_rzao','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cli_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:select property="agvc_tipo" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="R">
                        Reposição
                      </html:option>
                      <html:option styleClass="baseOption" value="V">
                        Venda
                      </html:option>
                      <html:option styleClass="baseOption" value="A">
                        Venda e Reposição
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <html:hidden property="agvi_id" value="<%= (String)request.getParameter("agvi_id") %>"/>
                <html:hidden property="pos" value="<%= (String)request.getParameter("pos") %>"/>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="i" styleClass="baseButton" property="insert_action">
                      <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                    </html:submit>
                    <html:submit accesskey="r" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:submit>
                    <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["agvc_cli_cdgo"];
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

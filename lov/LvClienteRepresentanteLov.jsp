<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
  <bean:message key="page.script"/>
</head>
<center>
  <body onload="document.forms[0].codigo_representante.value=opener.document.forms[0].rep_cdgo.value">
    <table class="mainTable" style='width:500;'>
      <tr class="mainTr">
        <td class="mainTd">
          <table class="headerTable" style="width:500" >
            <tr>

              <td class="td10">
              </td>

            </tr>

          </table>

          <html:form action="lov/LvClienteRepresentanteLov.do" method="post" styleClass="baseForm" target="_self">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Lista de Valores - Clientes / Representante
                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="codigo_cliente"/>
                  <html:errors property="cli_rzao"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_cliente_representante"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Cliente
                  </span>
                </td>
                <td class="formField">
                  <html:text property="codigo_cliente" styleClass="baseField" size="21" maxlength="21"/>
                </td>
              </tr>

              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Razão Social
                  </span>
                </td>
                <td class="formField">
                  <html:text property="cli_rzao" styleClass="baseField" size="35" maxlength="35"/>
                </td>
              </tr>

              <html:hidden property="codigo_representante"/>
            </table>

            <table class="buttonTable" style='width:500;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:submit accesskey="p" styleClass="baseButton" property="select_action">
                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                  </html:submit>
                  <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                    <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:submit>
                  <html:button accesskey="f" onclick="javascript:window.close();" styleClass="myhidden" property="close_action">
                    <bean:message bundle="ApplicationResources" key="jsp.close"/>
                  </html:button>
                </td>
              </tr>
            </table>

          </html:form>
          <script type="text/javascript">
            var focusControl = document.forms[0].elements["codigo_cliente"];
            if (focusControl.type != "hidden"){
              focusControl.focus();
            }
          </script>

          <%
          {
            %>

            <%
            java.util.Vector res_Jw_cliente_representante = (java.util.Vector)session.getAttribute("res_Jw_cliente_representante");
            %>

            <form  name="bl_report_Jw_cliente_representante" id="bl_report_Jw_cliente_representante" class="baseForm" method="post" >
              <%
              if (res_Jw_cliente_representante!=null && res_Jw_cliente_representante.size()>0) {
                %>

                <table id="TRbl_report_Jw_cliente_representante"  class="reportTable"   style="width:500; "  >
                  <%
                  java.lang.String codigo_cliente =  null;
                  java.lang.String cli_rzao =  null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:left;" >
                      Código
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Razão Social
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Jw_cliente_representante = 0;
                  while (i_bl_report_Jw_cliente_representante<res_Jw_cliente_representante.size()) {
                    portalbr.dbobj.view.Jw_cliente_representante t_jw_cliente_representante = (portalbr.dbobj.view.Jw_cliente_representante)res_Jw_cliente_representante.elementAt(i_bl_report_Jw_cliente_representante);
                    codigo_cliente = t_jw_cliente_representante.getCodigo_cliente()==null?"":t_jw_cliente_representante.getCodigo_cliente();
                    cli_rzao = t_jw_cliente_representante.getCli_rzao()==null?"":t_jw_cliente_representante.getCli_rzao();
                    String style_bl_report_Jw_cliente_representante="";
                    if (!((i_bl_report_Jw_cliente_representante%2)!=0)) {
                      style_bl_report_Jw_cliente_representante="rowColor";
                    } else {
                      style_bl_report_Jw_cliente_representante="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Jw_cliente_representante %>' id="TRbl_report_Jw_cliente_representante<%=i_bl_report_Jw_cliente_representante%>" >
                      <td class="reportColumn" style="text-align:left;" >
                        <%= codigo_cliente %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <a href="javascript:setLov('<%= codigo_cliente %>','<%= cli_rzao %>')" style="cursor:hand">
                          <%= cli_rzao %>
                        </a>

                      </td>

                    </tr>

                    <%
                    i_bl_report_Jw_cliente_representante++;
                    if (i_bl_report_Jw_cliente_representante<res_Jw_cliente_representante.size()) {
                      t_jw_cliente_representante = (portalbr.dbobj.view.Jw_cliente_representante)res_Jw_cliente_representante.elementAt(i_bl_report_Jw_cliente_representante);
                      codigo_cliente = t_jw_cliente_representante.getCodigo_cliente()==null?"":t_jw_cliente_representante.getCodigo_cliente();
                      cli_rzao = t_jw_cliente_representante.getCli_rzao()==null?"":t_jw_cliente_representante.getCli_rzao();
                    } else {
                    }
                  }
                  %>

                </table>

                <%
              }
              %>

              <script type="text/javascript">
                function setLov(CODIGO_CLIENTE,CLI_RZAO) {
                  <% {
                    String returnBlock = "0";
                    String return0 = null;
                    String return1 = null;
                    if (request.getParameter("returnBlock")!=null) {
                      returnBlock = request.getParameter("returnBlock");
                      session.setAttribute("returnBlock",returnBlock);
                      return0 = ((request.getParameter("return0")!=null)?request.getParameter("return0"):null);
                      session.setAttribute("return0",return0);
                      return1 = ((request.getParameter("return1")!=null)?request.getParameter("return1"):null);
                      session.setAttribute("return1",return1);
                      session.setAttribute("ge_LovPage", "LvClienteRepresentanteLov");
                    } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvClienteRepresentanteLov")) {
                      returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                      return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                      return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                    }
                    %>
                    returnBlock = <%= returnBlock %>;
                    <% if (return0!=null && return0.length()>0) {%>
                    if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CODIGO_CLIENTE; };
                    <%}%>
                    <% if (return1!=null && return1.length()>0) {%>
                    if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=CLI_RZAO; };
                    <%}%>
                    window.close();
                  }
                  <% } %>
                </script>

              </form>
              <%
            }
            %>

          </td>
        </tr>
      </table>

    </body>
  </center>
</html>

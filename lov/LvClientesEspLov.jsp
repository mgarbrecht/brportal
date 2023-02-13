<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
  <bean:message key="page.script"/>
</head>
<center>
  <body onload="document.forms[0].codigo_regional.value=opener.document.forms[0].codigo_regional.value;document.forms[0].rep_cdgo.value=opener.document.forms[0].rep_cdgo.value">
    <table class="mainTable" style='width:500;'>
      <tr class="mainTr">
        <td class="mainTd">
          <table class="headerTable" style="width:500" >
            <tr>

              <td class="td10">
              </td>

            </tr>

          </table>

          <html:form action="lov/LvClientesEspLov.do" method="post" styleClass="baseForm" target="_self">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">

                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="codigo"/>
                  <html:errors property="cliente"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Cliesp_clientes"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Código
                  </span>
                </td>
                <td class="formField">
                  <html:text property="codigo" styleClass="baseField" size="6" maxlength="6"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Cliente
                  </span>
                </td>
                <td class="formField">
                  <html:text property="cliente" styleClass="baseField" size="60" maxlength="100"/>
                </td>
              </tr>

              <html:hidden property="codigo_regional"/>
              <html:hidden property="rep_cdgo"/>
              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
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
                  <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                    <bean:message bundle="ApplicationResources" key="jsp.close"/>
                  </html:button>
                </td>
              </tr>
            </table>

          </html:form>
          <script type="text/javascript">
            var focusControl = document.forms[0].elements["codigo"];
            if (focusControl.type != "hidden"){
              focusControl.focus();
            }
          </script>

          <%
          {
            %>

            <%
            java.util.Vector res_Cliesp_clientes = (java.util.Vector)session.getAttribute("res_Cliesp_clientes");
            %>

            <form  name="bl_report_Cliesp_clientes" id="bl_report_Cliesp_clientes" class="baseForm" method="post" >
              <%
              if (res_Cliesp_clientes!=null && res_Cliesp_clientes.size()>0) {
                %>

                <table id="TRbl_report_Cliesp_clientes"  class="reportTable"   style="width:500; "  >
                  <%
                  int codigo =  0;
                  java.lang.String cliente =  null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:right;" >
                      Código
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Cliente
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Cliesp_clientes = 0;
                  while (i_bl_report_Cliesp_clientes<res_Cliesp_clientes.size()) {
                    portalbr.dbobj.table.Cliesp_clientes t_cliesp_clientes = (portalbr.dbobj.table.Cliesp_clientes)res_Cliesp_clientes.elementAt(i_bl_report_Cliesp_clientes);
                    codigo = t_cliesp_clientes.getCodigo();
                    cliente = t_cliesp_clientes.getCliente()==null?"":t_cliesp_clientes.getCliente();
                    String style_bl_report_Cliesp_clientes="";
                    if (!((i_bl_report_Cliesp_clientes%2)!=0)) {
                      style_bl_report_Cliesp_clientes="rowColor";
                    } else {
                      style_bl_report_Cliesp_clientes="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Cliesp_clientes %>' id="TRbl_report_Cliesp_clientes<%=i_bl_report_Cliesp_clientes%>" >
                      <td class="reportColumn" style="text-align:right;" >
                        <%= codigo %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <a href="javascript:setLov('<%= codigo %>','<%= cliente %>')" style="cursor:hand">
                          <%= cliente %>
                        </a>

                      </td>

                    </tr>

                    <%
                    i_bl_report_Cliesp_clientes++;
                    if (i_bl_report_Cliesp_clientes<res_Cliesp_clientes.size()) {
                      t_cliesp_clientes = (portalbr.dbobj.table.Cliesp_clientes)res_Cliesp_clientes.elementAt(i_bl_report_Cliesp_clientes);
                      codigo = t_cliesp_clientes.getCodigo();
                      cliente = t_cliesp_clientes.getCliente()==null?"":t_cliesp_clientes.getCliente();
                    } else {
                    }
                  }
                  %>

                </table>

                <%
              }
              %>

              <script type="text/javascript">
                function setLov(CODIGO,CLIENTE) {
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
                      session.setAttribute("ge_LovPage", "LvClientesEspLov");
                    } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvClientesEspLov")) {
                      returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                      return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                      return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                    }
                    %>
                    returnBlock = <%= returnBlock %>;
                    <% if (return0!=null && return0.length()>0) {%>
                    if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CODIGO; };
                    <%}%>
                    <% if (return1!=null && return1.length()>0) {%>
                    if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=CLIENTE; };
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

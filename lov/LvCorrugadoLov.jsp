<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
  <bean:message key="page.script"/>
</head>
<center>
  <body>
    <table class="mainTable" style='width:500;'>
      <tr class="mainTr">
        <td class="mainTd">
          <table class="headerTable" style="width:500" >
            <tr>

              <td class="td10">
              </td>

            </tr>

          </table>

          <html:form action="lov/LvCorrugadoLov.do" method="post" styleClass="baseForm">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Lista de Valores - Corrugados
                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Código
                  </span>
                </td>
                <td class="formField">
                  <html:text property="codigo" styleId="codigo" styleClass="baseField" size="2" maxlength="2"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Descrição
                  </span>
                </td>
                <td class="formField">
                  <html:text property="descricao" styleId="descricao" styleClass="baseField" size="30" maxlength="30"/>
                </td>
              </tr>

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
            java.util.Vector res_Corrugados = (java.util.Vector)session.getAttribute("res_Corrugados");
            %>

            <form  name="bl_report_Corrugados" id="bl_report_Corrugados" class="baseForm" method="post" >
              <table class="bannerTable" style="width:500;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Corrugados
                  </td>
                </tr>
              </table>

              <%
              if (res_Corrugados!=null && res_Corrugados.size()>0) {
                %>

                <table id="TRbl_report_Corrugados"  class="reportTable"   style="width:500; "  >
                  <%
                  java.lang.Integer codigo =  null;
                  java.lang.String descricao =  null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:right;" >
                      Código
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Descrição
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Corrugados = 0;
                  while (i_bl_report_Corrugados<res_Corrugados.size()) {
                    portalbr.dbobj.table.Corrugados t_corrugados = (portalbr.dbobj.table.Corrugados)res_Corrugados.elementAt(i_bl_report_Corrugados);
                    codigo = t_corrugados.getCodigo();
                    descricao = t_corrugados.getDescricao()==null?"":t_corrugados.getDescricao();
                    String style_bl_report_Corrugados="";
                    if (!((i_bl_report_Corrugados%2)!=0)) {
                      style_bl_report_Corrugados="rowColor";
                    } else {
                      style_bl_report_Corrugados="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Corrugados %>' id="TRbl_report_Corrugados<%=i_bl_report_Corrugados%>" >
                      <td class="reportColumn" style="text-align:right;" >
                        <%= ((codigo!=null)?codigo.toString():"") %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <a href="javascript:setLov('<%= codigo %>','<%= descricao %>')" style="cursor:hand">
                          <%= descricao %>
                        </a>

                      </td>

                    </tr>

                    <%
                    i_bl_report_Corrugados++;
                    if (i_bl_report_Corrugados<res_Corrugados.size()) {
                      t_corrugados = (portalbr.dbobj.table.Corrugados)res_Corrugados.elementAt(i_bl_report_Corrugados);
                      codigo = t_corrugados.getCodigo();
                      descricao = t_corrugados.getDescricao()==null?"":t_corrugados.getDescricao();
                    } else {
                    }
                  }
                  %>

                </table>

                <%
              }
              %>

              <script type="text/javascript">
                function setLov(CODIGO,DESCRICAO) {
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
                      session.setAttribute("ge_LovPage", "LvCorrugadoLov");
                    } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvCorrugadoLov")) {
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
                    if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=DESCRICAO; };
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

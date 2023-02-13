<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvCorrugadoExp0400Lov.do" method="post" styleClass="baseForm">
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
                      Corrugado
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_corrug" styleId="codigo_corrug" styleClass="baseField" size="22" maxlength="22"/>
                  </td>
                </tr>

                <html:hidden property="lin_cdgo" value="<%= request.getParameter("lin_cdgo") %>"/>
                <html:hidden property="ref_cdgo" value="<%= request.getParameter("ref_cdgo") %>"/>
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
              var focusControl = document.forms[0].elements["codigo_corrug"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Peso_corrugados = (java.util.Vector)session.getAttribute("res_Peso_corrugados");
              %>

              <form  name="bl_report_Peso_corrugados" id="bl_report_Peso_corrugados" class="baseForm" method="post" >
                <%
                if (res_Peso_corrugados!=null && res_Peso_corrugados.size()>0) {
                  %>

                  <table id="TRbl_report_Peso_corrugados"  class="reportTable"   style="width:500; "  >
                    <%
                    int Corrugado =  0;
                    java.lang.Integer qt_par_corrug =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Corrugado
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Quantidade de Pares
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Peso_corrugados = 0;
                    while (i_bl_report_Peso_corrugados<res_Peso_corrugados.size()) {
                      portalbr.dbobj.table.Peso_corrugados t_peso_corrugados = (portalbr.dbobj.table.Peso_corrugados)res_Peso_corrugados.elementAt(i_bl_report_Peso_corrugados);
                      Corrugado = t_peso_corrugados.getCodigo_corrug();
                      qt_par_corrug = t_peso_corrugados.getQt_par_corrug();
                      String style_bl_report_Peso_corrugados="";
                      if (!((i_bl_report_Peso_corrugados%2)!=0)) {
                        style_bl_report_Peso_corrugados="rowColor";
                      } else {
                        style_bl_report_Peso_corrugados="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Peso_corrugados %>' id="TRbl_report_Peso_corrugados<%=i_bl_report_Peso_corrugados%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <a href="javascript:setLov('<%= Corrugado %>','<%= qt_par_corrug %>')" style="cursor:hand">
                            <%= Corrugado %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((qt_par_corrug!=null)?qt_par_corrug.toString():"") %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Peso_corrugados++;
                      if (i_bl_report_Peso_corrugados<res_Peso_corrugados.size()) {
                        t_peso_corrugados = (portalbr.dbobj.table.Peso_corrugados)res_Peso_corrugados.elementAt(i_bl_report_Peso_corrugados);
                        Corrugado = t_peso_corrugados.getCodigo_corrug();
                        qt_par_corrug = t_peso_corrugados.getQt_par_corrug();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(CORRUGADO,QT_PAR_CORRUG) {
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
                        session.setAttribute("ge_LovPage", "LvCorrugadoExp0400Lov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvCorrugadoExp0400Lov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CORRUGADO; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=QT_PAR_CORRUG; };
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

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
            <html:form action="lov/LvAgendamentosClientesLov.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="id_agendamento"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Agendamento_clientes"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Agendamento
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="id_agendamento" styleId="id_agendamento" styleClass="baseField" size="5" maxlength="5"/>
                  </td>
                </tr>

                <html:hidden property="cli_cdgo" value="<%= request.getParameter("cli_cdgo") %>"/>
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
              var focusControl = document.forms[0].elements["id_agendamento"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Agendamento_clientes = (java.util.Vector)session.getAttribute("res_Agendamento_clientes");
              %>

              <form  name="bl_report_Agendamento_clientes" id="bl_report_Agendamento_clientes" class="baseForm" method="post" >
                <%
                if (res_Agendamento_clientes!=null && res_Agendamento_clientes.size()>0) {
                  %>

                  <table id="TRbl_report_Agendamento_clientes"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.Integer id_agendamento =  null;
                    java.lang.Integer cli_cdgo =  null;
                    java.lang.Integer nro_semana =  null;
                    java.sql.Date dt_inicial =  null;
                    java.sql.Date dt_final =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Agendamento
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Semana
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Dt. Inicial
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Dt. Final
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Agendamento_clientes = 0;
                    while (i_bl_report_Agendamento_clientes<res_Agendamento_clientes.size()) {
                      portalbr.dbobj.table.Agendamento_clientes t_agendamento_clientes = (portalbr.dbobj.table.Agendamento_clientes)res_Agendamento_clientes.elementAt(i_bl_report_Agendamento_clientes);
                      id_agendamento = t_agendamento_clientes.getId_agendamento();
                      cli_cdgo = t_agendamento_clientes.getCli_cdgo();
                      nro_semana = t_agendamento_clientes.getNro_semana();
                      dt_inicial = (java.sql.Date)t_agendamento_clientes.getDt_inicial();
                      dt_final = (java.sql.Date)t_agendamento_clientes.getDt_final();
                      String style_bl_report_Agendamento_clientes="";
                      if (!((i_bl_report_Agendamento_clientes%2)!=0)) {
                        style_bl_report_Agendamento_clientes="rowColor";
                      } else {
                        style_bl_report_Agendamento_clientes="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Agendamento_clientes %>' id="TRbl_report_Agendamento_clientes<%=i_bl_report_Agendamento_clientes%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <a href="javascript:setLov('<%= id_agendamento %>','<%= nro_semana %>','<%= com.egen.util.text.FormatDate.format(dt_inicial, "dd/MM/yyyy") %> a <%= com.egen.util.text.FormatDate.format(dt_final, "dd/MM/yyyy") %>')" style="cursor:hand">
                            <%= ((id_agendamento!=null)?id_agendamento.toString():"") %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((nro_semana!=null)?nro_semana.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(dt_inicial, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(dt_final, "dd/MM/yyyy") %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Agendamento_clientes++;
                      if (i_bl_report_Agendamento_clientes<res_Agendamento_clientes.size()) {
                        t_agendamento_clientes = (portalbr.dbobj.table.Agendamento_clientes)res_Agendamento_clientes.elementAt(i_bl_report_Agendamento_clientes);
                        id_agendamento = t_agendamento_clientes.getId_agendamento();
                        cli_cdgo = t_agendamento_clientes.getCli_cdgo();
                        nro_semana = t_agendamento_clientes.getNro_semana();
                        dt_inicial = (java.sql.Date)t_agendamento_clientes.getDt_inicial();
                        dt_final = (java.sql.Date)t_agendamento_clientes.getDt_final();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(ID_AGENDAMENTO,NRO_SEMANA,DT_INICIAL,DT_FINAL) {
                    <% {
                      String returnBlock = "0";
                      String return0 = null;
                      String return1 = null;
                      String return2 = null;
                      String return3 = null;
                      if (request.getParameter("returnBlock")!=null) {
                        returnBlock = request.getParameter("returnBlock");
                        session.setAttribute("returnBlock",returnBlock);
                        return0 = ((request.getParameter("return0")!=null)?request.getParameter("return0"):null);
                        session.setAttribute("return0",return0);
                        return1 = ((request.getParameter("return1")!=null)?request.getParameter("return1"):null);
                        session.setAttribute("return1",return1);
                        return2 = ((request.getParameter("return2")!=null)?request.getParameter("return2"):null);
                        session.setAttribute("return2",return2);
                        return3 = ((request.getParameter("return3")!=null)?request.getParameter("return3"):null);
                        session.setAttribute("return3",return3);
                        session.setAttribute("ge_LovPage", "LvAgendamentosClientesLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvAgendamentosClientesLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                        return2 = ((session.getAttribute("return2")!=null)?(String)session.getAttribute("return2"):null);
                        return3 = ((session.getAttribute("return3")!=null)?(String)session.getAttribute("return3"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=ID_AGENDAMENTO;
                      valueChanged(opener.document.forms[returnBlock].<%= return0 %>);
                      };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=NRO_SEMANA; };
                      <%}%>
                      <% if (return2!=null && return2.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return2%>!=null) { opener.document.forms[returnBlock].<%= return2 %>.value=DT_INICIAL; };
                      <%}%>
                      <% if (return3!=null && return3.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return3%>!=null) {
                        opener.document.forms[returnBlock].<%= return3 %>.value=DT_FINAL;
                        };
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

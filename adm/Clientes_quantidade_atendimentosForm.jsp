<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Sumário de Clientes
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
                  <%@ include file="../system/header_data.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(58)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Clientes_quantidade_atendimentos" class="reportTable" style=width:99%; border=1 >
              <%
              //  int counterbl_report_Clientes_quantidade_atendimentos=0;
              try {
                portalbr.dbobj.view.Jw_clientes_quantidade_atendimentos t_clientes_quantidade_atendimentos = new portalbr.dbobj.view.Jw_clientes_quantidade_atendimentos();
                java.util.Vector res_Clientes_quantidade_atendimentos = (java.util.Vector)session.getAttribute("res_Clientes_quantidade_atendimentos");
                if (res_Clientes_quantidade_atendimentos!=null && res_Clientes_quantidade_atendimentos.size()>0) {
                  java.lang.Integer atendimentos = null;
                  java.lang.Integer clientes = null;
                  int i_bl_report_clientes_quantidade_atendimentos = 0;
                  t_clientes_quantidade_atendimentos = (portalbr.dbobj.view.Jw_clientes_quantidade_atendimentos)res_Clientes_quantidade_atendimentos.elementAt(i_bl_report_clientes_quantidade_atendimentos);
                  atendimentos = t_clientes_quantidade_atendimentos.getAtendimentos();
                  clientes = t_clientes_quantidade_atendimentos.getClientes();
                  {
                    %>
                    <tr class="reportHeader" valign="bottom">

                      <td class="columnTdHeader" style="text-align: left;">
                        <br/>
                        Atendimentos
                      </td>


                      <td class="columnTdHeader" style="text-align:center;">
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <img style=cursor:pointer src=../img/ballhelp.gif border=0 onmouseout="this.src='../img/ballhelp.gif'" onmouseover="this.src='../img/ballhelp_c.gif'" onclick="javascript:window.open('../lov/HelpForm.jsp?help=Clientes atendidos','def','scrollbars,height=400,width=340,TOP=0,LEFT=0')">
                          <%
                        }
                        %>
                        <br/>
                        Clientes
                      </td>

                      <%
                    }
                    %>


                  </tr>

                  <%
                  while (i_bl_report_clientes_quantidade_atendimentos<res_Clientes_quantidade_atendimentos.size()){
                    //          counterbl_report_clientes_quantidade_atendimentos++;
                    String style="";
                    if (!((i_bl_report_clientes_quantidade_atendimentos%2)!=0)) {
                      style="rowColor";
                    } else {
                      style="rowBlank";
                    }
                    %>
                    <tr class=<%= style %>  >
                      <td class="reportColumn" style="text-align: left;">
                        <%= com.egen.util.text.FormatNumber.format(atendimentos, "#,##0.##") %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" title="Clientes Compras">
                        <a href="../adm/Clientes_atend_quantidadeForm.do?select_action=&atendimentos=<%= atendimentos %>" target="_self" STYLE="cursor:hand">
                          <%= com.egen.util.text.FormatNumber.format(clientes, "#,##0.##") %>
                        </a>
                      </td>

                    </tr>
                    <%
                    if (++i_bl_report_clientes_quantidade_atendimentos >= res_Clientes_quantidade_atendimentos.size()) {
                      break;
                    }
                    t_clientes_quantidade_atendimentos = (portalbr.dbobj.view.Jw_clientes_quantidade_atendimentos)res_Clientes_quantidade_atendimentos.elementAt(i_bl_report_clientes_quantidade_atendimentos);
                    atendimentos = t_clientes_quantidade_atendimentos.getAtendimentos();
                    clientes = t_clientes_quantidade_atendimentos.getClientes();
                  }}
                  %>

                  <%
                } catch (Exception e) {
                  session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                } finally {

                }
                %>
              </table>
              <html:form action="adm/Clientes_quantidade_atendimentosForm.do" method="post" styleClass="baseForm">
                <table class="itemTable"  style=" width:;">
                  <html:hidden property="dt_inicial"/>
                  <html:hidden property="dt_final"/>
                  <html:hidden property="codigo_regional"/>
                  <html:hidden property="codigo_marca"/>
                  <html:hidden property="lin_cdgo"/>
                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                            <bean:message bundle="ApplicationResources" key="jsp.select"/>
                          </html:submit>
                          <%
                        }
                        %>
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <html:submit accesskey="r" styleClass="myhidden" property="resetfull_action">
                            <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                          </html:submit>
                          <%
                        }
                        %>
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <html:submit accesskey="b" styleClass="baseButton" property="back_action">
                            <bean:message bundle="ApplicationResources" key="jsp.back"/>
                          </html:submit>
                          <%
                        }
                        %>
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

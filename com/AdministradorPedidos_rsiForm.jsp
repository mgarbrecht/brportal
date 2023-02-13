<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Administrador de Pedidos - Previsto / Capacidade - Sintético
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
                  <%@ include file="../system/header_excel.jsp" %>
                </td>

              </tr>

            </table>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_administrador_pedidos_sintetico = (java.util.Vector)session.getAttribute("res_Jw_administrador_pedidos_sintetico");
              %>

              <form  name="bl_report_Jw_administrador_pedidos_sintetico" id="bl_report_Jw_administrador_pedidos_sintetico" class="baseForm" method="post" >
                <%
                if (res_Jw_administrador_pedidos_sintetico!=null && res_Jw_administrador_pedidos_sintetico.size()>0) {
                  if ( ((String)request.getParameter("_ordered"))!=null && ((String)request.getParameter("_ordered")).length()>0 ) {
                    boolean reverse = false;
                    if ( ((String)request.getParameter("_reverse"))!=null && ((String)request.getParameter("_reverse")).equals("true") ){
                      reverse = true;
                    }
                    try {
                      res_Jw_administrador_pedidos_sintetico = com.egen.util.text.Sort.execute(res_Jw_administrador_pedidos_sintetico,((String)request.getParameter("_ordered")),reverse);
                      session.setAttribute("res_Jw_administrador_pedidos_sintetico", res_Jw_administrador_pedidos_sintetico);
                    } catch (Exception e) {}
                  }
                  %>

                  <table id="TRbl_report_Jw_administrador_pedidos_sintetico"  class="reportTable"   style="width:99%; "  border="1"  frame="box">
                    <%
                    java.lang.Integer lin_cdgo =  null;
                    java.lang.String lin_nome1 =  null;
                    java.sql.Date data_inicial =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Linha
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='AdministradorPedidos_rsiForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","lin_cdgo")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='AdministradorPedidos_rsiForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","lin_cdgo")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Nome
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Data de Disponibilidade
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='AdministradorPedidos_rsiForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","data_inicial")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='AdministradorPedidos_rsiForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","data_inicial")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_administrador_pedidos_sintetico = 0;
                    while (i_bl_report_Jw_administrador_pedidos_sintetico<res_Jw_administrador_pedidos_sintetico.size()) {
                      portalbr.dbobj.view.Jw_administrador_pedidos_sintetico t_jw_administrador_pedidos_sintetico = (portalbr.dbobj.view.Jw_administrador_pedidos_sintetico)res_Jw_administrador_pedidos_sintetico.elementAt(i_bl_report_Jw_administrador_pedidos_sintetico);
                      lin_cdgo = t_jw_administrador_pedidos_sintetico.getLin_cdgo();
                      lin_nome1 = t_jw_administrador_pedidos_sintetico.getLin_nome()==null?"":t_jw_administrador_pedidos_sintetico.getLin_nome();
                      data_inicial = (java.sql.Date)t_jw_administrador_pedidos_sintetico.getData_inicial();
                      String style_bl_report_Jw_administrador_pedidos_sintetico="";
                      if (!((i_bl_report_Jw_administrador_pedidos_sintetico%2)!=0)) {
                        style_bl_report_Jw_administrador_pedidos_sintetico="rowColor";
                      } else {
                        style_bl_report_Jw_administrador_pedidos_sintetico="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_administrador_pedidos_sintetico %>' id="TRbl_report_Jw_administrador_pedidos_sintetico<%=i_bl_report_Jw_administrador_pedidos_sintetico%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((lin_cdgo!=null)?lin_cdgo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= lin_nome1 %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_inicial, "dd/MM/yyyy") %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_administrador_pedidos_sintetico++;
                      if (i_bl_report_Jw_administrador_pedidos_sintetico<res_Jw_administrador_pedidos_sintetico.size()) {
                        t_jw_administrador_pedidos_sintetico = (portalbr.dbobj.view.Jw_administrador_pedidos_sintetico)res_Jw_administrador_pedidos_sintetico.elementAt(i_bl_report_Jw_administrador_pedidos_sintetico);
                        lin_cdgo = t_jw_administrador_pedidos_sintetico.getLin_cdgo();
                        lin_nome1 = t_jw_administrador_pedidos_sintetico.getLin_nome()==null?"":t_jw_administrador_pedidos_sintetico.getLin_nome();
                        data_inicial = (java.sql.Date)t_jw_administrador_pedidos_sintetico.getData_inicial();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

              </form>
              <%
            }
            %>

            <html:form action="com/AdministradorPedidos_rsiForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <html:hidden property="quebra"/>
                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                        <bean:message bundle="ApplicationResources" key="jsp.back"/>
                      </html:submit>
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Clientes por Transportadora
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
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(35)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_clientes_transportadora = (java.util.Vector)session.getAttribute("res_Jw_clientes_transportadora");
              %>

              <form  name="bl_report_Jw_clientes_transportadora" id="bl_report_Jw_clientes_transportadora" class="baseForm" method="post" >
                <%
                if (res_Jw_clientes_transportadora!=null && res_Jw_clientes_transportadora.size()>0) {
                  if ( ((String)request.getParameter("_ordered"))!=null && ((String)request.getParameter("_ordered")).length()>0 ) {
                    boolean reverse = false;
                    if ( ((String)request.getParameter("_reverse"))!=null && ((String)request.getParameter("_reverse")).equals("true") ){
                      reverse = true;
                    }
                    try {
                      res_Jw_clientes_transportadora = com.egen.util.text.Sort.execute(res_Jw_clientes_transportadora,((String)request.getParameter("_ordered")),reverse);
                      session.setAttribute("res_Jw_clientes_transportadora", res_Jw_clientes_transportadora);
                    } catch (Exception e) {}
                  }
                  %>

                  <table id="TRbl_report_Jw_clientes_transportadora"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Integer codigo_transportadora =  null;
                    java.lang.String razao_transportadora =  null;
                    java.lang.Integer codigo_cliente =  null;
                    java.lang.String razao_social =  null;
                    java.lang.String cidade =  null;
                    java.lang.String uf =  null;
                    java.lang.String consignatario =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Transportadora
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='ClientesTransportadora_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","codigo_transportadora")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='ClientesTransportadora_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","codigo_transportadora")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Razão Social Transportadora
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='ClientesTransportadora_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","razao_transportadora")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='ClientesTransportadora_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","razao_transportadora")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Cliente
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='ClientesTransportadora_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","codigo_cliente")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='ClientesTransportadora_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","codigo_cliente")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Razão Social
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='ClientesTransportadora_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","razao_social")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='ClientesTransportadora_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","razao_social")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Cidade
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='ClientesTransportadora_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","cidade")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='ClientesTransportadora_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","cidade")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        UF
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='ClientesTransportadora_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","uf")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='ClientesTransportadora_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","uf")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Consignatário
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='ClientesTransportadora_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","consignatario")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='ClientesTransportadora_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","consignatario")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_clientes_transportadora = 0;
                    while (i_bl_report_Jw_clientes_transportadora<res_Jw_clientes_transportadora.size()) {
                      portalbr.dbobj.view.Jw_clientes_transportadora t_jw_clientes_transportadora = (portalbr.dbobj.view.Jw_clientes_transportadora)res_Jw_clientes_transportadora.elementAt(i_bl_report_Jw_clientes_transportadora);
                      codigo_transportadora = t_jw_clientes_transportadora.getCodigo_transportadora();
                      razao_transportadora = t_jw_clientes_transportadora.getRazao_transportadora()==null?"":t_jw_clientes_transportadora.getRazao_transportadora();
                      codigo_cliente = t_jw_clientes_transportadora.getCodigo_cliente();
                      razao_social = t_jw_clientes_transportadora.getRazao_social()==null?"":t_jw_clientes_transportadora.getRazao_social();
                      cidade = t_jw_clientes_transportadora.getCidade()==null?"":t_jw_clientes_transportadora.getCidade();
                      uf = t_jw_clientes_transportadora.getUf()==null?"":t_jw_clientes_transportadora.getUf();
                      consignatario = t_jw_clientes_transportadora.getConsignatario()==null?"":t_jw_clientes_transportadora.getConsignatario();
                      String style_bl_report_Jw_clientes_transportadora="";
                      if (!((i_bl_report_Jw_clientes_transportadora%2)!=0)) {
                        style_bl_report_Jw_clientes_transportadora="rowColor";
                      } else {
                        style_bl_report_Jw_clientes_transportadora="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_clientes_transportadora %>' id="TRbl_report_Jw_clientes_transportadora<%=i_bl_report_Jw_clientes_transportadora%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((codigo_transportadora!=null)?codigo_transportadora.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= razao_transportadora %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((codigo_cliente!=null)?codigo_cliente.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= razao_social %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cidade %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= uf %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= consignatario.equals("S")?"Sim":"Não" %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_clientes_transportadora++;
                      if (i_bl_report_Jw_clientes_transportadora<res_Jw_clientes_transportadora.size()) {
                        t_jw_clientes_transportadora = (portalbr.dbobj.view.Jw_clientes_transportadora)res_Jw_clientes_transportadora.elementAt(i_bl_report_Jw_clientes_transportadora);
                        codigo_transportadora = t_jw_clientes_transportadora.getCodigo_transportadora();
                        razao_transportadora = t_jw_clientes_transportadora.getRazao_transportadora()==null?"":t_jw_clientes_transportadora.getRazao_transportadora();
                        codigo_cliente = t_jw_clientes_transportadora.getCodigo_cliente();
                        razao_social = t_jw_clientes_transportadora.getRazao_social()==null?"":t_jw_clientes_transportadora.getRazao_social();
                        cidade = t_jw_clientes_transportadora.getCidade()==null?"":t_jw_clientes_transportadora.getCidade();
                        uf = t_jw_clientes_transportadora.getUf()==null?"":t_jw_clientes_transportadora.getUf();
                        consignatario = t_jw_clientes_transportadora.getConsignatario()==null?"":t_jw_clientes_transportadora.getConsignatario();
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

            <html:form action="ind/ClientesTransportadora_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

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

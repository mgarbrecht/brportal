<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta Log Limpeza Banco de Dados
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(137)){
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
              java.util.Vector res_Tmp_log_limpeza_orabrio = null;
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                j = new com.egen.util.jdbc.JdbcUtil();
                portalbr.dbobj.table.Tmp_log_limpeza_orabrio t_tmp_log_limpeza_orabrio = new portalbr.dbobj.table.Tmp_log_limpeza_orabrio();
                String[][] select = {{"ocorrencia",null},{"data",null},{"sequencia",null},};
                Object[][] where = null;
                String[] groupby =  null;
                String[] having =  null;
                String[] order = {"sequencia"};
                res_Tmp_log_limpeza_orabrio = j.select(t_tmp_log_limpeza_orabrio,select,where,groupby,having,order);
              } catch (Exception e){
                session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                %>
                <jsp:forward page="/system/ErrorPage.jsp"/>
                <%
              } finally {
              if(j!=null){j.close();}
            }
            %>

            <form  name="bl_report_Tmp_log_limpeza_orabrio" id="bl_report_Tmp_log_limpeza_orabrio" class="baseForm" method="post" >
              <%
              if (res_Tmp_log_limpeza_orabrio!=null && res_Tmp_log_limpeza_orabrio.size()>0) {
                if ( ((String)request.getParameter("_ordered"))!=null && ((String)request.getParameter("_ordered")).length()>0 ) {
                  boolean reverse = false;
                  if ( ((String)request.getParameter("_reverse"))!=null && ((String)request.getParameter("_reverse")).equals("true") ){
                    reverse = true;
                  }
                  try {
                    res_Tmp_log_limpeza_orabrio = com.egen.util.text.Sort.execute(res_Tmp_log_limpeza_orabrio,((String)request.getParameter("_ordered")),reverse);
                  } catch (Exception e) {}
                }
                %>

                <table id="TRbl_report_Tmp_log_limpeza_orabrio"  class="reportTable"   style="width:99%; "  border="1" >
                  <%
                  java.lang.String ocorrencia =  null;
                  java.lang.String datax =  null;
                  java.lang.Integer sequencia =  null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:left;" >
                      Ocorrência
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ConsultaLogLimpezaBancoDadosForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","ocorrencia")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ConsultaLogLimpezaBancoDadosForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","ocorrencia")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Data
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ConsultaLogLimpezaBancoDadosForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","data")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ConsultaLogLimpezaBancoDadosForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","data")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Sequencia
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ConsultaLogLimpezaBancoDadosForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","sequencia")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ConsultaLogLimpezaBancoDadosForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","sequencia")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Tmp_log_limpeza_orabrio = 0;
                  while (i_bl_report_Tmp_log_limpeza_orabrio<res_Tmp_log_limpeza_orabrio.size()) {
                    portalbr.dbobj.table.Tmp_log_limpeza_orabrio t_tmp_log_limpeza_orabrio = (portalbr.dbobj.table.Tmp_log_limpeza_orabrio)res_Tmp_log_limpeza_orabrio.elementAt(i_bl_report_Tmp_log_limpeza_orabrio);
                    ocorrencia = t_tmp_log_limpeza_orabrio.getOcorrencia()==null?"":t_tmp_log_limpeza_orabrio.getOcorrencia();
                    datax = t_tmp_log_limpeza_orabrio.getData()==null?"":t_tmp_log_limpeza_orabrio.getData();
                    sequencia = t_tmp_log_limpeza_orabrio.getSequencia();
                    String style_bl_report_Tmp_log_limpeza_orabrio="";
                    if (!((i_bl_report_Tmp_log_limpeza_orabrio%2)!=0)) {
                      style_bl_report_Tmp_log_limpeza_orabrio="rowColor";
                    } else {
                      style_bl_report_Tmp_log_limpeza_orabrio="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Tmp_log_limpeza_orabrio %>' id="TRbl_report_Tmp_log_limpeza_orabrio<%=i_bl_report_Tmp_log_limpeza_orabrio%>" >
                      <td class="reportColumn" style="text-align:left;" >
                        <%= ocorrencia %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= datax %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= ((sequencia!=null)?sequencia.toString():"") %>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Tmp_log_limpeza_orabrio++;
                    if (i_bl_report_Tmp_log_limpeza_orabrio<res_Tmp_log_limpeza_orabrio.size()) {
                      t_tmp_log_limpeza_orabrio = (portalbr.dbobj.table.Tmp_log_limpeza_orabrio)res_Tmp_log_limpeza_orabrio.elementAt(i_bl_report_Tmp_log_limpeza_orabrio);
                      ocorrencia = t_tmp_log_limpeza_orabrio.getOcorrencia()==null?"":t_tmp_log_limpeza_orabrio.getOcorrencia();
                      datax = t_tmp_log_limpeza_orabrio.getData()==null?"":t_tmp_log_limpeza_orabrio.getData();
                      sequencia = t_tmp_log_limpeza_orabrio.getSequencia();
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

        </td>
      </tr>
    </table>

  </body>
</center>
</html>

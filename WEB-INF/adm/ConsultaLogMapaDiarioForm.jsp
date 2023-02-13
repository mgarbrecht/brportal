<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta Log Mapa Diário
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(38)){
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
              java.util.Vector res_Jw_log_mapa_diario = null;
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                j = new com.egen.util.jdbc.JdbcUtil();
                portalbr.dbobj.view.Jw_log_mapa_diario t_jw_log_mapa_diario = new portalbr.dbobj.view.Jw_log_mapa_diario();
                String[][] select = {{"ocorrencia",null},{"data_ocorrencia",null},{"sequencia",null},};
                Object[][] where = null;
                String[] groupby =  null;
                String[] having =  null;
                String[] order =  null;
                res_Jw_log_mapa_diario = j.select(t_jw_log_mapa_diario,select,where,groupby,having,order);
              } catch (Exception e){
                session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                %>
                <jsp:forward page="/system/ErrorPage.jsp"/>
                <%
              } finally {
              if(j!=null){j.close();}
            }
            %>

            <form  name="bl_report_Jw_log_mapa_diario" id="bl_report_Jw_log_mapa_diario" class="baseForm" method="post" >
              <%
              if (res_Jw_log_mapa_diario!=null && res_Jw_log_mapa_diario.size()>0) {
                if ( ((String)request.getParameter("_ordered"))!=null && ((String)request.getParameter("_ordered")).length()>0 ) {
                  boolean reverse = false;
                  if ( ((String)request.getParameter("_reverse"))!=null && ((String)request.getParameter("_reverse")).equals("true") ){
                    reverse = true;
                  }
                  try {
                    res_Jw_log_mapa_diario = com.egen.util.text.Sort.execute(res_Jw_log_mapa_diario,((String)request.getParameter("_ordered")),reverse);
                  } catch (Exception e) {}
                }
                %>

                <table id="TRbl_report_Jw_log_mapa_diario"  class="reportTable"   style="width:99%; "  border="1" >
                  <%
                  java.lang.String ocorrencia =  null;
                  java.lang.String data_ocorrencia =  null;
                  java.lang.Integer sequencia =  null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:left;" >
                      Ocorrência
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ConsultaLogMapaDiarioForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","ocorrencia")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ConsultaLogMapaDiarioForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","ocorrencia")%>' class="reportOrder">
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
                        <a href='ConsultaLogMapaDiarioForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","data_ocorrencia")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ConsultaLogMapaDiarioForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","data_ocorrencia")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Sequência
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ConsultaLogMapaDiarioForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","sequencia")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ConsultaLogMapaDiarioForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","sequencia")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Jw_log_mapa_diario = 0;
                  while (i_bl_report_Jw_log_mapa_diario<res_Jw_log_mapa_diario.size()) {
                    portalbr.dbobj.view.Jw_log_mapa_diario t_jw_log_mapa_diario = (portalbr.dbobj.view.Jw_log_mapa_diario)res_Jw_log_mapa_diario.elementAt(i_bl_report_Jw_log_mapa_diario);
                    ocorrencia = t_jw_log_mapa_diario.getOcorrencia()==null?"":t_jw_log_mapa_diario.getOcorrencia();
                    data_ocorrencia = t_jw_log_mapa_diario.getData_ocorrencia()==null?"":t_jw_log_mapa_diario.getData_ocorrencia();
                    sequencia = t_jw_log_mapa_diario.getSequencia();
                    String style_bl_report_Jw_log_mapa_diario="";
                    if (!((i_bl_report_Jw_log_mapa_diario%2)!=0)) {
                      style_bl_report_Jw_log_mapa_diario="rowColor";
                    } else {
                      style_bl_report_Jw_log_mapa_diario="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Jw_log_mapa_diario %>' id="TRbl_report_Jw_log_mapa_diario<%=i_bl_report_Jw_log_mapa_diario%>" >
                      <td class="reportColumn" style="text-align:left;" >
                        <%= ocorrencia %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= data_ocorrencia %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= ((sequencia!=null)?sequencia.toString():"") %>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Jw_log_mapa_diario++;
                    if (i_bl_report_Jw_log_mapa_diario<res_Jw_log_mapa_diario.size()) {
                      t_jw_log_mapa_diario = (portalbr.dbobj.view.Jw_log_mapa_diario)res_Jw_log_mapa_diario.elementAt(i_bl_report_Jw_log_mapa_diario);
                      ocorrencia = t_jw_log_mapa_diario.getOcorrencia()==null?"":t_jw_log_mapa_diario.getOcorrencia();
                      data_ocorrencia = t_jw_log_mapa_diario.getData_ocorrencia()==null?"":t_jw_log_mapa_diario.getData_ocorrencia();
                      sequencia = t_jw_log_mapa_diario.getSequencia();
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

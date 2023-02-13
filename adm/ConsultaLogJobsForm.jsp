<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta Log Jobs
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(327)){
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
              java.util.Vector res_Jw_consulta_log_jobs = null;
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                j = new com.egen.util.jdbc.JdbcUtil();
                portalbr.dbobj.view.Jw_consulta_log_jobs t_jw_consulta_log_jobs = new portalbr.dbobj.view.Jw_consulta_log_jobs();
                String[][] select = {{"data",null},{"owner",null},{"job",null},{"status",null},{"errors",null},};
                Object[][] where = null;
                String[] groupby =  null;
                String[] having =  null;
                String[] order =  null;
                res_Jw_consulta_log_jobs = j.select(t_jw_consulta_log_jobs,select,where,groupby,having,order);
              } catch (Exception e){
                session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                %>
                <jsp:forward page="/system/ErrorPage.jsp"/>
                <%
              } finally {
              if(j!=null){j.close();}
            }
            %>

            <form  name="bl_report_Jw_consulta_log_jobs" id="bl_report_Jw_consulta_log_jobs" class="baseForm" method="post" >
              <%
              if (res_Jw_consulta_log_jobs!=null && res_Jw_consulta_log_jobs.size()>0) {
                if ( ((String)request.getParameter("_ordered"))!=null && ((String)request.getParameter("_ordered")).length()>0 ) {
                  boolean reverse = false;
                  if ( ((String)request.getParameter("_reverse"))!=null && ((String)request.getParameter("_reverse")).equals("true") ){
                    reverse = true;
                  }
                  try {
                    res_Jw_consulta_log_jobs = com.egen.util.text.Sort.execute(res_Jw_consulta_log_jobs,((String)request.getParameter("_ordered")),reverse);
                  } catch (Exception e) {}
                }
                %>

                <table id="TRbl_report_Jw_consulta_log_jobs"  class="reportTable"   style="width:99%; "  border="1"  frame="box">
                  <%
                  java.lang.String data =  null;
                  java.lang.String owner =  null;
                  java.lang.String job =  null;
                  java.lang.String status =  null;
                  java.lang.String errors =  null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:left;" >
                      Data
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ConsultaLogJobsForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","data")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ConsultaLogJobsForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","data")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Owner
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ConsultaLogJobsForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","owner")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ConsultaLogJobsForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","owner")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Job
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ConsultaLogJobsForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","job")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ConsultaLogJobsForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","job")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Status
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ConsultaLogJobsForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","status")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ConsultaLogJobsForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","status")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Errors
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ConsultaLogJobsForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","errors")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ConsultaLogJobsForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","errors")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Jw_consulta_log_jobs = 0;
                  while (i_bl_report_Jw_consulta_log_jobs<res_Jw_consulta_log_jobs.size()) {
                    portalbr.dbobj.view.Jw_consulta_log_jobs t_jw_consulta_log_jobs = (portalbr.dbobj.view.Jw_consulta_log_jobs)res_Jw_consulta_log_jobs.elementAt(i_bl_report_Jw_consulta_log_jobs);
                    data = t_jw_consulta_log_jobs.getData()==null?"":t_jw_consulta_log_jobs.getData();
                    owner = t_jw_consulta_log_jobs.getOwner()==null?"":t_jw_consulta_log_jobs.getOwner();
                    job = t_jw_consulta_log_jobs.getJob()==null?"":t_jw_consulta_log_jobs.getJob();
                    status = t_jw_consulta_log_jobs.getStatus()==null?"":t_jw_consulta_log_jobs.getStatus();
                    errors = t_jw_consulta_log_jobs.getErrors()==null?"":t_jw_consulta_log_jobs.getErrors();
                    String style_bl_report_Jw_consulta_log_jobs="";
                    if (!((i_bl_report_Jw_consulta_log_jobs%2)!=0)) {
                      style_bl_report_Jw_consulta_log_jobs="rowColor";
                    } else {
                      style_bl_report_Jw_consulta_log_jobs="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Jw_consulta_log_jobs %>' id="TRbl_report_Jw_consulta_log_jobs<%=i_bl_report_Jw_consulta_log_jobs%>" >
                      <td class="reportColumn" style="text-align:left;" >
                        <%= data %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= owner %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= job %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= status %>
                      </td>

                      <td class="reportColumn" style="text-align:left;width:50%;" >
                        <%= errors %>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Jw_consulta_log_jobs++;
                    if (i_bl_report_Jw_consulta_log_jobs<res_Jw_consulta_log_jobs.size()) {
                      t_jw_consulta_log_jobs = (portalbr.dbobj.view.Jw_consulta_log_jobs)res_Jw_consulta_log_jobs.elementAt(i_bl_report_Jw_consulta_log_jobs);
                      data = t_jw_consulta_log_jobs.getData()==null?"":t_jw_consulta_log_jobs.getData();
                      owner = t_jw_consulta_log_jobs.getOwner()==null?"":t_jw_consulta_log_jobs.getOwner();
                      job = t_jw_consulta_log_jobs.getJob()==null?"":t_jw_consulta_log_jobs.getJob();
                      status = t_jw_consulta_log_jobs.getStatus()==null?"":t_jw_consulta_log_jobs.getStatus();
                      errors = t_jw_consulta_log_jobs.getErrors()==null?"":t_jw_consulta_log_jobs.getErrors();
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

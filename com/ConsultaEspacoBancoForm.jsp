<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta Espaço Banco
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
                  if(!user.isSuperUsuario()){
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
              java.util.Vector res_Jw_consulta_espaco_banco = null;
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                j = new com.egen.util.jdbc.JdbcUtil();
                portalbr.dbobj.view.Jw_consulta_espaco_banco t_jw_consulta_espaco_banco = new portalbr.dbobj.view.Jw_consulta_espaco_banco();
                String[][] select = {{"dg_name",null},{"dg_state",null},{"dg_free_mb",null},{"dg_total_mb",null},{"perc_free",null},{"dt_data",null},};
                Object[][] where = null;
                String[] groupby =  null;
                String[] having =  null;
                String[] order =  null;
                res_Jw_consulta_espaco_banco = j.select(t_jw_consulta_espaco_banco,select,where,groupby,having,order);
              } catch (Exception e){
                session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                %>
                <jsp:forward page="/system/ErrorPage.jsp"/>
                <%
              } finally {
              if(j!=null){j.close();}
            }
            %>

            <form  name="bl_report_Jw_consulta_espaco_banco" id="bl_report_Jw_consulta_espaco_banco" class="baseForm" method="post" >
              <%
              if (res_Jw_consulta_espaco_banco!=null && res_Jw_consulta_espaco_banco.size()>0) {
                %>

                <table id="TRbl_report_Jw_consulta_espaco_banco"  class="reportTable"   style="width:99%; "  border="1" >
                  <%
                  java.lang.String dg_name =  null;
                  java.lang.String dg_state =  null;
                  double dg_free_mb =  0;
                  double dg_total_mb =  0;
                  double perc_free =  0;
                  java.lang.String dt_data =  null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:left;" >
                      dg_name
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      dg_state
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      dg_free_mb
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      dg_total_mb
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      perc_free
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      data
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Jw_consulta_espaco_banco = 0;
                  while (i_bl_report_Jw_consulta_espaco_banco<res_Jw_consulta_espaco_banco.size()) {
                    portalbr.dbobj.view.Jw_consulta_espaco_banco t_jw_consulta_espaco_banco = (portalbr.dbobj.view.Jw_consulta_espaco_banco)res_Jw_consulta_espaco_banco.elementAt(i_bl_report_Jw_consulta_espaco_banco);
                    dg_name = t_jw_consulta_espaco_banco.getDg_name()==null?"":t_jw_consulta_espaco_banco.getDg_name();
                    dg_state = t_jw_consulta_espaco_banco.getDg_state()==null?"":t_jw_consulta_espaco_banco.getDg_state();
                    dg_free_mb = t_jw_consulta_espaco_banco.getDg_free_mb();
                    dg_total_mb = t_jw_consulta_espaco_banco.getDg_total_mb();
                    perc_free = t_jw_consulta_espaco_banco.getPerc_free();
                    dt_data = t_jw_consulta_espaco_banco.getDt_data()==null?"":t_jw_consulta_espaco_banco.getDt_data();
                    String style_bl_report_Jw_consulta_espaco_banco="";
                    if (!((i_bl_report_Jw_consulta_espaco_banco%2)!=0)) {
                      style_bl_report_Jw_consulta_espaco_banco="rowColor";
                    } else {
                      style_bl_report_Jw_consulta_espaco_banco="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Jw_consulta_espaco_banco %>' id="TRbl_report_Jw_consulta_espaco_banco<%=i_bl_report_Jw_consulta_espaco_banco%>" >
                      <td class="reportColumn" style="text-align:left;" >
                        <%= dg_name %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= dg_state %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= com.egen.util.text.FormatNumber.format(dg_free_mb, "##,##0.00") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= com.egen.util.text.FormatNumber.format(dg_total_mb, "##,##0.00") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= com.egen.util.text.FormatNumber.format(perc_free, "##,##0.00") %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= dt_data %>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Jw_consulta_espaco_banco++;
                    if (i_bl_report_Jw_consulta_espaco_banco<res_Jw_consulta_espaco_banco.size()) {
                      t_jw_consulta_espaco_banco = (portalbr.dbobj.view.Jw_consulta_espaco_banco)res_Jw_consulta_espaco_banco.elementAt(i_bl_report_Jw_consulta_espaco_banco);
                      dg_name = t_jw_consulta_espaco_banco.getDg_name()==null?"":t_jw_consulta_espaco_banco.getDg_name();
                      dg_state = t_jw_consulta_espaco_banco.getDg_state()==null?"":t_jw_consulta_espaco_banco.getDg_state();
                      dg_free_mb = t_jw_consulta_espaco_banco.getDg_free_mb();
                      dg_total_mb = t_jw_consulta_espaco_banco.getDg_total_mb();
                      perc_free = t_jw_consulta_espaco_banco.getPerc_free();
                      dt_data = t_jw_consulta_espaco_banco.getDt_data()==null?"":t_jw_consulta_espaco_banco.getDt_data();
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

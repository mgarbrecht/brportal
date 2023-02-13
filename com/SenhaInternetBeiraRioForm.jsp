<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Senha Internet Beira Rio
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(270)){
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
              java.util.Vector res_Jw_hotspotbr = null;
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                j = new com.egen.util.jdbc.JdbcUtil();
                portalbr.dbobj.view.Jw_hotspotbr t_jw_hotspotbr = new portalbr.dbobj.view.Jw_hotspotbr();
                String[][] select = {{"data",null},{"senha",null},};
                Object[][] where = null;
                String[] groupby =  null;
                String[] having =  null;
                String[] order =  null;
                res_Jw_hotspotbr = j.select(t_jw_hotspotbr,select,where,groupby,having,order);
              } catch (Exception e){
                session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                %>
                <jsp:forward page="/system/ErrorPage.jsp"/>
                <%
              } finally {
              if(j!=null){j.close();}
            }
            %>

            <form  name="bl_report_Jw_hotspotbr" id="bl_report_Jw_hotspotbr" class="baseForm" method="post" >
              <%
              if (res_Jw_hotspotbr!=null && res_Jw_hotspotbr.size()>0) {
                %>

                <center>
                  <br>
                  <br>
                  <table id="TRbl_report_Jw_hotspotbr"  class="reportTable"   style="width:60%; " border="1"  >
                    <%
                    java.sql.Timestamp data =  null;
                    java.lang.String senha =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:center; font-size: 24px; width:50%" >
                        Data
                      </td>

                      <td class="columnTdHeader" style="text-align:center; font-size: 24px" >
                        Senha Diária
                        <br>
                        (toda em minúscula)
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_hotspotbr = 0;
                    while (i_bl_report_Jw_hotspotbr<res_Jw_hotspotbr.size()) {
                      portalbr.dbobj.view.Jw_hotspotbr t_jw_hotspotbr = (portalbr.dbobj.view.Jw_hotspotbr)res_Jw_hotspotbr.elementAt(i_bl_report_Jw_hotspotbr);
                      data = (java.sql.Timestamp)t_jw_hotspotbr.getData();
                      senha = t_jw_hotspotbr.getSenha()==null?"":t_jw_hotspotbr.getSenha();
                      String style_bl_report_Jw_hotspotbr="";
                      if (!((i_bl_report_Jw_hotspotbr%2)!=0)) {
                        style_bl_report_Jw_hotspotbr="rowColor";
                      } else {
                        style_bl_report_Jw_hotspotbr="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_hotspotbr %>' id="TRbl_report_Jw_hotspotbr<%=i_bl_report_Jw_hotspotbr%>" >
                        <td class="reportColumn" style="text-align:center; font-size: 24px" >
                          <%= com.egen.util.text.FormatDate.format(data, "dd/MM/yyyy") %>
                        </td>
                        <td class="reportColumn" style="text-align:center; font-size: 24px" >
                          <%= senha %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_hotspotbr++;
                      if (i_bl_report_Jw_hotspotbr<res_Jw_hotspotbr.size()) {
                        t_jw_hotspotbr = (portalbr.dbobj.view.Jw_hotspotbr)res_Jw_hotspotbr.elementAt(i_bl_report_Jw_hotspotbr);
                        data = (java.sql.Timestamp)t_jw_hotspotbr.getData();
                        senha = t_jw_hotspotbr.getSenha()==null?"":t_jw_hotspotbr.getSenha();
                      } else {
                      }
                    }
                    %>

                  </table>
                </center>

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

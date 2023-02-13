<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page  extends='acesso.web.HttpJspSessao' %>
<html>
  <head>

    <title>
      Grupos Ativos
      <%= request.getParameter("grupo") %>
    </title>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:99%;'>
        <tr>
          <td>
            <table   class="headerTable" style="width:99%" >
              <tr>
                <td class='td10'>
                  <%@ include file="../system/header_data.jsp" %>
                </td>
              </tr>
            </table>
            <%
            {
              %>
              <form class="baseForm" >
                <table id="TRbl_report_Jw_grupos_ativos" class="reportTable" style=width:99%;  border=1  frame=box>
                  <%
                  int counterbl_report_Jw_grupos_ativos=0;
                  {
                    portalbr.dbobj.view.Jw_grupos_ativos t_jw_grupos_ativos = new portalbr.dbobj.view.Jw_grupos_ativos();
                    java.util.Vector res_Jw_grupos_ativos = (java.util.Vector)session.getAttribute("res_Jw_grupos_ativos");
                    if (res_Jw_grupos_ativos!=null && res_Jw_grupos_ativos.size()>0) {
                      java.lang.String gre_grupo       =  null;
                      java.lang.String gre_descricao   =  null;
                      int i_bl_report_Jw_grupos_ativos =  0;

                      t_jw_grupos_ativos = (portalbr.dbobj.view.Jw_grupos_ativos)res_Jw_grupos_ativos.elementAt(i_bl_report_Jw_grupos_ativos);
                      gre_grupo     = t_jw_grupos_ativos.getGre_grupo()==null?"":t_jw_grupos_ativos.getGre_grupo();
                      gre_descricao = t_jw_grupos_ativos.getGre_descricao()==null?"":t_jw_grupos_ativos.getGre_descricao();
                      %>
                      <tr class="reportHeader3" >
                        <td class="columnTdHeader" style="text-align:left;">
                          Código
                        </td>
                        <td class="columnTdHeader" style="text-align:left;">
                          Descrição
                        </td>
                      </tr>
                      <%
                      while (i_bl_report_Jw_grupos_ativos<res_Jw_grupos_ativos.size()){
                        counterbl_report_Jw_grupos_ativos++;
                        String style="";
                        if (!((i_bl_report_Jw_grupos_ativos%2)!=0)) {
                          style="class=rowColor";
                        } else {
                          style="class=rowBlank";
                        }
                        %>
                        <tr <%= style %> id='TRbl_report_Jw_grupos_ativos<%=counterbl_report_Jw_grupos_ativos%>' >
                          <td class="reportColumn" style="text-align:left;">
                            <%= gre_grupo %>
                          </td>
                          <td class="reportColumn" style="text-align:left;">
                            <a href="../adm/GruposAtivos_cForm.do?select_action=&gre_grupo=<%= gre_grupo %>&grupo=<%= gre_grupo %>-<%= gre_descricao %>" target="_self" STYLE="cursor:hand">
                              <%= gre_descricao %>
                            </a>
                          </td>
                        </tr>
                        <%
                        if (++i_bl_report_Jw_grupos_ativos >= res_Jw_grupos_ativos.size()) {
                          break;
                        }
                        t_jw_grupos_ativos = (portalbr.dbobj.view.Jw_grupos_ativos)res_Jw_grupos_ativos.elementAt(i_bl_report_Jw_grupos_ativos);
                        gre_grupo     = t_jw_grupos_ativos.getGre_grupo()==null?"":t_jw_grupos_ativos.getGre_grupo();
                        gre_descricao = t_jw_grupos_ativos.getGre_descricao()==null?"":t_jw_grupos_ativos.getGre_descricao();
                      }
                    }
                  }
                  %>
                </table>
              </form>
              <%
            }
            %>
            <html:form action="adm/GruposAtivosForm.do" method="POST" styleClass="baseForm">
              <table class="itemTable" style='width:;'>
                <%
                com.egen.util.jdbc.JdbcUtil connection = null;
                try {
                  if(!user.isSuperUsuario()){
                    connection = new com.egen.util.jdbc.JdbcUtil("wbrio","wbrio",util.rdb.ConnectionJDBC.getJdbcURL("orasco"),util.rdb.ConnectionJDBC.getJdbcDriver("orasco"));
                    portalbr.dbobj.view.Jw_permissoes table = new portalbr.dbobj.view.Jw_permissoes();
                    String[][] select = null;
                    Object[][] where = {
                      {"Usua_usuario","like", user.getUsuario()},
                    {"Acdi_doin_id","=","58"}
                    };
                    Vector res_Jw_permissoes = connection.select(table, select, where, null, null, null);
                    if (res_Jw_permissoes != null && res_Jw_permissoes.size() == 0) {
                      %>
                      <script>
                        top.location='../system/Error.jsp';
                      </script>
                      <%
                    }
                  }

                } catch (Exception e) {
                  throw e;
                } finally {
                  if (connection != null) {
                    connection.close();
                  }
                }
                %>
                <html:hidden property="cod_marca"/>
                <html:hidden property="cod_regional"/>
                <html:hidden property="cod_rep"/>
                <html:hidden property="grupo"/>
              </table>
              <table class="buttonTable" style='width:99%;'>
                <tr>
                  <td class="buttonItem">
                    <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:button accesskey="b" onclick="history.go(-1);" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:button>
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

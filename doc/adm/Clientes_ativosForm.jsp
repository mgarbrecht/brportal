<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page  extends='acesso.web.HttpJspSessao' %>
<html>
  <head>

    <title>
      Clientes Ativos
      <%= request.getParameter("cab") %>
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
                <table id="TRbl_report_Jw_clientes_ativos" class="reportTable" style=width:99%;  border=1  frame=box>
                  <%
                  int counterbl_report_Jw_clientes_ativos=0;
                  %>
                  <%
                  {
                    portalbr.dbobj.view.Jw_clientes_ativos t_jw_clientes_ativos = new portalbr.dbobj.view.Jw_clientes_ativos();
                    java.util.Vector res_Jw_clientes_ativos = (java.util.Vector)session.getAttribute("res_Jw_clientes_ativos");
                    if (res_Jw_clientes_ativos!=null && res_Jw_clientes_ativos.size()>0) {
                      java.lang.String cli_cdgo =  null;
                      java.lang.String cli_nome =  null;
                      java.lang.String cli_rzao =  null;
                      java.lang.String cidade =  null;
                      int i_bl_report_Jw_clientes_ativos = 0;
                      t_jw_clientes_ativos = (portalbr.dbobj.view.Jw_clientes_ativos)res_Jw_clientes_ativos.elementAt(i_bl_report_Jw_clientes_ativos);
                      cli_cdgo = t_jw_clientes_ativos.getCli_cdgo()==null?"":t_jw_clientes_ativos.getCli_cdgo();
                      cli_nome = t_jw_clientes_ativos.getCli_nome()==null?"":t_jw_clientes_ativos.getCli_nome();
                      cli_rzao = t_jw_clientes_ativos.getCli_rzao()==null?"":t_jw_clientes_ativos.getCli_rzao();
                      cidade = t_jw_clientes_ativos.getCidade()==null?"":t_jw_clientes_ativos.getCidade();
                      %>
                      <tr class="reportHeader3" >
                        <td class="columnTdHeader" style="text-align:left;">
                          Código
                        </td>
                        <td class="columnTdHeader" style="text-align:left;">
                          Nome
                        </td>
                        <td class="columnTdHeader" style="text-align:left;">
                          Razão Social
                        </td>
                        <td class="columnTdHeader" style="text-align:left;">
                          Cidade
                        </td>
                      </tr>
                      <%
                      while (i_bl_report_Jw_clientes_ativos<res_Jw_clientes_ativos.size()){
                        counterbl_report_Jw_clientes_ativos++;
                        String style="";
                        if (!((i_bl_report_Jw_clientes_ativos%2)!=0)) {
                          style="class=rowColor";
                        } else {
                          style="class=rowBlank";
                        }
                        %>
                        <tr <%= style %> id='TRbl_report_Jw_clientes_ativos<%=counterbl_report_Jw_clientes_ativos%>' >
                          <td class="reportColumn" style="text-align:left;">
                            <%= cli_cdgo %>
                          </td>
                          <td class="reportColumn" style="text-align:left;">
                            <%= cli_nome %>
                          </td>
                          <td class="reportColumn" style="text-align:left;">
                            <%= cli_rzao %>
                          </td>
                          <td class="reportColumn" style="text-align:left;">
                            <%= cidade %>
                          </td>
                        </tr>
                        <%
                        if (++i_bl_report_Jw_clientes_ativos >= res_Jw_clientes_ativos.size()) {
                          break;
                        }
                        t_jw_clientes_ativos = (portalbr.dbobj.view.Jw_clientes_ativos)res_Jw_clientes_ativos.elementAt(i_bl_report_Jw_clientes_ativos);
                        cli_cdgo = t_jw_clientes_ativos.getCli_cdgo()==null?"":t_jw_clientes_ativos.getCli_cdgo();
                        cli_nome = t_jw_clientes_ativos.getCli_nome()==null?"":t_jw_clientes_ativos.getCli_nome();
                        cli_rzao = t_jw_clientes_ativos.getCli_rzao()==null?"":t_jw_clientes_ativos.getCli_rzao();
                        cidade = t_jw_clientes_ativos.getCidade()==null?"":t_jw_clientes_ativos.getCidade();
                      }
                    }
                  }
                  %>
                </table>
              </form>
              <%
            }
            %>
            <html:form action="adm/Clientes_ativosForm.do" method="POST" styleClass="baseForm">
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
                <html:hidden property="cli_cdgo"/>
                <html:hidden property="rep_cdgo"/>
                <html:hidden property="codigo_regional"/>
                <html:hidden property="codigo_marca"/>
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

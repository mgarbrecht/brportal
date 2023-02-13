<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page  extends='acesso.web.HttpJspSessao' %>
<html>
  <head>

    <title>
      Clientes Não Atendidos
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
                <table id="TRbl_report_Jw_clientes_nao_atendidos" class="reportTable" style=width:99%;  border=1  frame=box>
                  <%
                  int counterbl_report_Jw_clientes_nao_atendidos=0;
                  %>
                  <%
                  {
                    portalbr.dbobj.view.Jw_clientes_nao_atendidos t_jw_clientes_nao_atendidos = new portalbr.dbobj.view.Jw_clientes_nao_atendidos();
                    java.util.Vector res_Jw_clientes_nao_atendidos = (java.util.Vector)session.getAttribute("res_Jw_clientes_nao_atendidos");
                    if (res_Jw_clientes_nao_atendidos!=null && res_Jw_clientes_nao_atendidos.size()>0) {
                      java.lang.String cli_cdgo =  null;
                      java.lang.String cli_nome =  null;
                      java.lang.String cli_rzao =  null;
                      java.lang.String cidade =  null;
                      java.sql.Timestamp cli_dult =  null;
                      int i_bl_report_Jw_clientes_nao_atendidos = 0;
                      t_jw_clientes_nao_atendidos = (portalbr.dbobj.view.Jw_clientes_nao_atendidos)res_Jw_clientes_nao_atendidos.elementAt(i_bl_report_Jw_clientes_nao_atendidos);
                      cli_cdgo = t_jw_clientes_nao_atendidos.getCli_cdgo()==null?"":t_jw_clientes_nao_atendidos.getCli_cdgo();
                      cli_nome = t_jw_clientes_nao_atendidos.getCli_nome()==null?"":t_jw_clientes_nao_atendidos.getCli_nome();
                      cli_rzao = t_jw_clientes_nao_atendidos.getCli_rzao()==null?"":t_jw_clientes_nao_atendidos.getCli_rzao();
                      cidade = t_jw_clientes_nao_atendidos.getCidade()==null?"":t_jw_clientes_nao_atendidos.getCidade();
                      cli_dult = (java.sql.Timestamp)t_jw_clientes_nao_atendidos.getCli_dult();
                      %>
                      <tr class="reportHeader3" valign="bottom">
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
                        <td class="columnTdHeader" style="text-align:center;">
                          <img style=cursor:pointer src=../img/ballhelp.gif border=0 onmouseout="this.src='../img/ballhelp.gif'" onmouseover="this.src='../img/ballhelp_c.gif'" onclick="javascript:window.open('../lov/HelpForm.jsp?help=Data da última compra do cliente, com base na data de digitação dos pedidos, levando em consideração apenas os pedidos que não estejam cancelados.','def','scrollbars,height=400,width=340,TOP=0,LEFT=0')">
                          <br>
                          Data Última Compra
                        </td>
                      </tr>
                      <%
                      while (i_bl_report_Jw_clientes_nao_atendidos<res_Jw_clientes_nao_atendidos.size()){
                        counterbl_report_Jw_clientes_nao_atendidos++;
                        String style="";
                        if (!((i_bl_report_Jw_clientes_nao_atendidos%2)!=0)) {
                          style="class=rowColor";
                        } else {
                          style="class=rowBlank";
                        }
                        %>
                        <tr <%= style %> id='TRbl_report_Jw_clientes_nao_atendidos<%=counterbl_report_Jw_clientes_nao_atendidos%>' >
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
                          <td class="reportColumn" style="text-align:center;">
                            <%= com.egen.util.text.FormatDate.format(cli_dult, "dd/MM/yyyy") %>
                          </td>
                        </tr>
                        <%
                        if (++i_bl_report_Jw_clientes_nao_atendidos >= res_Jw_clientes_nao_atendidos.size()) {
                          break;
                        }
                        t_jw_clientes_nao_atendidos = (portalbr.dbobj.view.Jw_clientes_nao_atendidos)res_Jw_clientes_nao_atendidos.elementAt(i_bl_report_Jw_clientes_nao_atendidos);
                        cli_cdgo = t_jw_clientes_nao_atendidos.getCli_cdgo()==null?"":t_jw_clientes_nao_atendidos.getCli_cdgo();
                        cli_nome = t_jw_clientes_nao_atendidos.getCli_nome()==null?"":t_jw_clientes_nao_atendidos.getCli_nome();
                        cli_rzao = t_jw_clientes_nao_atendidos.getCli_rzao()==null?"":t_jw_clientes_nao_atendidos.getCli_rzao();
                        cidade = t_jw_clientes_nao_atendidos.getCidade()==null?"":t_jw_clientes_nao_atendidos.getCidade();
                        cli_dult = (java.sql.Timestamp)t_jw_clientes_nao_atendidos.getCli_dult();
                      }
                    }
                  }
                  %>
                </table>
              </form>
              <%
            }
            %>
            <html:form action="adm/Clientes_nao_atendidosForm.do" method="POST" styleClass="baseForm">
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
                <html:hidden property="rep_cdgo"/>
                <html:hidden property="codigo_marca"/>
                <html:hidden property="codigo_regional"/>
              </table>
              <table class="buttonTable" style='width:99%;'>
                <tr>
                  <td class="buttonItem">
                    <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:button onclick="history.go(-1);" styleClass="baseButton" property="back_action">
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

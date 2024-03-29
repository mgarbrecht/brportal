<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page  extends='acesso.web.HttpJspSessao' %>
<html>
  <head>

    <title>
      Clientes Atendidos
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
                <table id="TRbl_report_Jw_clientes_atendidos" class="reportTable" style=width:99%;  border=1  frame=box>
                  <%
                  int counterbl_report_Jw_clientes_atendidos=0;
                  %>
                  <%
                  {
                    portalbr.dbobj.view.Jw_clientes_atendidos t_jw_clientes_atendidos = new portalbr.dbobj.view.Jw_clientes_atendidos();
                    java.util.Vector res_Jw_clientes_atendidos = (java.util.Vector)session.getAttribute("res_Jw_clientes_atendidos");
                    if (res_Jw_clientes_atendidos!=null && res_Jw_clientes_atendidos.size()>0) {
                      java.lang.String cli_cdgo =  null;
                      java.lang.String cli_nome =  null;
                      java.lang.String cli_rzao =  null;
                      java.lang.String cidade =  null;
                      java.sql.Timestamp cli_dult =  null;
                      int pares =  0;
                      int total_pares = 0;
                      double valor =  0;
                      double total_valor = 0;
                      int i_bl_report_Jw_clientes_atendidos = 0;
                      t_jw_clientes_atendidos = (portalbr.dbobj.view.Jw_clientes_atendidos)res_Jw_clientes_atendidos.elementAt(i_bl_report_Jw_clientes_atendidos);
                      cli_cdgo = t_jw_clientes_atendidos.getCli_cdgo()==null?"":t_jw_clientes_atendidos.getCli_cdgo();
                      cli_nome = t_jw_clientes_atendidos.getCli_nome()==null?"":t_jw_clientes_atendidos.getCli_nome();
                      cli_rzao = t_jw_clientes_atendidos.getCli_rzao()==null?"":t_jw_clientes_atendidos.getCli_rzao();
                      cidade = t_jw_clientes_atendidos.getCidade()==null?"":t_jw_clientes_atendidos.getCidade();
                      cli_dult = (java.sql.Timestamp)t_jw_clientes_atendidos.getCli_dult();
                      pares = t_jw_clientes_atendidos.getPares();
                      valor = t_jw_clientes_atendidos.getValor();
                      %>
                      <tr class="reportHeader3" valign="bottom">
                        <td class="columnTdHeader" style="text-align:left;">
                          C�digo
                        </td>
                        <td class="columnTdHeader" style="text-align:left;">
                          Nome
                        </td>
                        <td class="columnTdHeader" style="text-align:left;">
                          Raz�o Social
                        </td>
                        <td class="columnTdHeader" style="text-align:left;">
                          Cidade
                        </td>
                        <td class="columnTdHeader" style="text-align:center;">
                          <img style=cursor:pointer src=../img/ballhelp.gif border=0 onmouseout="this.src='../img/ballhelp.gif'" onmouseover="this.src='../img/ballhelp_c.gif'" onclick="javascript:window.open('../lov/HelpForm.jsp?help=Data da �ltima compra do cliente no per�odo, marca e linha informados; levando em considera��o apenas os pedidos que n�o estejam cancelados. (Per�odo com base na data de digita��o dos pedidos).','def','scrollbars,height=400,width=340,TOP=0,LEFT=0')">
                          <br>
                          Data �ltima Compra
                        </td>
                        <td class="columnTdHeader" style="text-align:right;">
                          Pares
                        </td>
                        <td class="columnTdHeader" style="text-align:right;">
                          Valor
                        </td>
                      </tr>
                      <%
                      while (i_bl_report_Jw_clientes_atendidos<res_Jw_clientes_atendidos.size()){
                        counterbl_report_Jw_clientes_atendidos++;
                        String style="";
                        if (!((i_bl_report_Jw_clientes_atendidos%2)!=0)) {
                          style="class=rowColor";
                        } else {
                          style="class=rowBlank";
                        }
                        %>
                        <tr <%= style %> id='TRbl_report_Jw_clientes_atendidos<%=counterbl_report_Jw_clientes_atendidos%>' >
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
                          <td class="reportColumn" style="text-align:center;" >
                            <%= com.egen.util.text.FormatDate.format(cli_dult, "dd/MM/yyyy") %>
                          </td>
                          <td class="reportColumn" style="text-align:right;">
                            <%
                            total_pares += pares;
                            total_valor += valor;
                            %>
                            <%= pares %>
                          </td>
                          <td class="reportColumn" style="text-align:right;">
                            <%= com.egen.util.text.FormatNumber.format(valor, "##,##0.00") %>
                          </td>
                        </tr>
                        <%
                        if (++i_bl_report_Jw_clientes_atendidos >= res_Jw_clientes_atendidos.size()) {
                          break;
                        }
                        t_jw_clientes_atendidos = (portalbr.dbobj.view.Jw_clientes_atendidos)res_Jw_clientes_atendidos.elementAt(i_bl_report_Jw_clientes_atendidos);
                        cli_cdgo = t_jw_clientes_atendidos.getCli_cdgo()==null?"":t_jw_clientes_atendidos.getCli_cdgo();
                        cli_nome = t_jw_clientes_atendidos.getCli_nome()==null?"":t_jw_clientes_atendidos.getCli_nome();
                        cli_rzao = t_jw_clientes_atendidos.getCli_rzao()==null?"":t_jw_clientes_atendidos.getCli_rzao();
                        cidade = t_jw_clientes_atendidos.getCidade()==null?"":t_jw_clientes_atendidos.getCidade();
                        cli_dult = (java.sql.Timestamp)t_jw_clientes_atendidos.getCli_dult();
                        pares = t_jw_clientes_atendidos.getPares();
                        valor = t_jw_clientes_atendidos.getValor();
                      }
                      %>
                      <td class="reportColumn" style="text-align:right;" colspan=5>
                        <b>
                          Total:
                        </b>
                      </td>
                      <td class="reportColumn" style="text-align:right;" >
                        <b>
                          <%= total_pares %>
                        </b>
                      </td>
                      <td class="reportColumn" style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(total_valor, "##,##0.00") %>
                        </b>
                      </td>

                      <%
                    }
                  }
                  %>
                </table>
              </form>
              <%
            }
            %>
            <html:form action="adm/Clientes_atendForm.do" method="POST" styleClass="baseForm">
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
                <html:hidden property="codigo_regional"/>
                <html:hidden property="codigo_marca"/>
              </table>
              <table class="buttonTable" style='width:99%;'>
                <tr>
                  <td class="buttonItem">
                    <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:button accesskey="a" onclick="history.go(-1);" styleClass="baseButton" property="back_action">
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

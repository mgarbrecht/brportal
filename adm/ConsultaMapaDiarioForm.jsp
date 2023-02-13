<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta Mapa Diário
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(154)){
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
              java.util.Vector res_Jw_consulta_mapa_diario = null;
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                j = new com.egen.util.jdbc.JdbcUtil();
                portalbr.dbobj.view.Jw_consulta_mapa_diario t_jw_consulta_mapa_diario = new portalbr.dbobj.view.Jw_consulta_mapa_diario();
                String[][] select = {{"data_tmp",null},{"entrada_dia_valor",null},{"entrada_dia_ant_valor",null},{"faturamento_dia_valor",null},{"faturamento_dia_ant",null},};
                Object[][] where = null;
                String[] groupby =  null;
                String[] having =  null;
                String[] order =  null;
                res_Jw_consulta_mapa_diario = j.select(t_jw_consulta_mapa_diario,select,where,groupby,having,order);
              } catch (Exception e){
                session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                %>
                <jsp:forward page="/system/ErrorPage.jsp"/>
                <%
              } finally {
              if(j!=null){j.close();}
            }
            %>

            <form  name="bl_report_Jw_consulta_mapa_diario" id="bl_report_Jw_consulta_mapa_diario" class="baseForm" method="post" >
              <%
              if (res_Jw_consulta_mapa_diario!=null && res_Jw_consulta_mapa_diario.size()>0) {
                %>

                <table id="TRbl_report_Jw_consulta_mapa_diario"  class="reportTable"   style="width:99%; "  border="1" >
                  <%
                  java.sql.Timestamp data_tmp =  null;
                  double entrada_dia_valor =  0;
                  double entrada_dia_ant_valor =  0;
                  double faturamento_dia_valor =  0;
                  double faturamento_dia_ant =  0;
                  double sum_entrada_dia_valor_0 = 0;
                  double sum_entrada_dia_ant_valor_0 = 0;
                  double sum_faturamento_dia_valor_0 = 0;
                  double sum_faturamento_dia_ant_0 = 0;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:center;" >
                      Data
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Entrada
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Entrada Ant.
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Faturamento
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Faturamento Ant.
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Jw_consulta_mapa_diario = 0;
                  while (i_bl_report_Jw_consulta_mapa_diario<res_Jw_consulta_mapa_diario.size()) {
                    portalbr.dbobj.view.Jw_consulta_mapa_diario t_jw_consulta_mapa_diario = (portalbr.dbobj.view.Jw_consulta_mapa_diario)res_Jw_consulta_mapa_diario.elementAt(i_bl_report_Jw_consulta_mapa_diario);
                    data_tmp = (java.sql.Timestamp)t_jw_consulta_mapa_diario.getData_tmp();
                    entrada_dia_valor = t_jw_consulta_mapa_diario.getEntrada_dia_valor();
                    entrada_dia_ant_valor = t_jw_consulta_mapa_diario.getEntrada_dia_ant_valor();
                    faturamento_dia_valor = t_jw_consulta_mapa_diario.getFaturamento_dia_valor();
                    faturamento_dia_ant = t_jw_consulta_mapa_diario.getFaturamento_dia_ant();
                    sum_entrada_dia_valor_0 += entrada_dia_valor;
                    sum_entrada_dia_ant_valor_0 += entrada_dia_ant_valor;
                    sum_faturamento_dia_valor_0 += faturamento_dia_valor;
                    sum_faturamento_dia_ant_0 += faturamento_dia_ant;
                    String style_bl_report_Jw_consulta_mapa_diario="";
                    if (!((i_bl_report_Jw_consulta_mapa_diario%2)!=0)) {
                      style_bl_report_Jw_consulta_mapa_diario="rowColor";
                    } else {
                      style_bl_report_Jw_consulta_mapa_diario="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Jw_consulta_mapa_diario %>' id="TRbl_report_Jw_consulta_mapa_diario<%=i_bl_report_Jw_consulta_mapa_diario%>" >
                      <td class="reportColumn" style="text-align:center;width:20%;" >
                        <%= com.egen.util.text.FormatDate.format(data_tmp, "dd/MM/yyyy") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;width:20%;" >
                        <%= com.egen.util.text.FormatNumber.format(entrada_dia_valor, "##,##0.00") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;width:20%;" >
                        <%= com.egen.util.text.FormatNumber.format(entrada_dia_ant_valor, "##,##0.00") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;width:20%;" >
                        <%= com.egen.util.text.FormatNumber.format(faturamento_dia_valor, "##,##0.00") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;width:20%;" >
                        <%= com.egen.util.text.FormatNumber.format(faturamento_dia_ant, "##,##0.00") %>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Jw_consulta_mapa_diario++;
                    if (i_bl_report_Jw_consulta_mapa_diario<res_Jw_consulta_mapa_diario.size()) {
                      t_jw_consulta_mapa_diario = (portalbr.dbobj.view.Jw_consulta_mapa_diario)res_Jw_consulta_mapa_diario.elementAt(i_bl_report_Jw_consulta_mapa_diario);
                      data_tmp = (java.sql.Timestamp)t_jw_consulta_mapa_diario.getData_tmp();
                      entrada_dia_valor = t_jw_consulta_mapa_diario.getEntrada_dia_valor();
                      entrada_dia_ant_valor = t_jw_consulta_mapa_diario.getEntrada_dia_ant_valor();
                      faturamento_dia_valor = t_jw_consulta_mapa_diario.getFaturamento_dia_valor();
                      faturamento_dia_ant = t_jw_consulta_mapa_diario.getFaturamento_dia_ant();
                    } else {
                    }
                  }
                  %>

                  <tr class="totalColumn">
                    <td class="totalTdColumn"  style="text-align:left; width:20%;" >
                      <b>
                        Mês Atual
                      </b>
                    </td>
                    <td class="totalTdColumn"  style="text-align:right; width:20%;" >
                      <b>
                        <%= com.egen.util.text.FormatNumber.format(sum_entrada_dia_valor_0, "##,##0.00") %>
                      </b>
                    </td>
                    <td class="totalTdColumn"  style="text-align:right; width:20%;" >
                      <b>
                        <%= com.egen.util.text.FormatNumber.format(sum_entrada_dia_ant_valor_0, "#,##0.##") %>
                      </b>
                    </td>
                    <td class="totalTdColumn"  style="text-align:right; width:20%;" >
                      <b>
                        <%= com.egen.util.text.FormatNumber.format(sum_faturamento_dia_valor_0, "##,##0.00") %>
                      </b>
                    </td>
                    <td class="totalTdColumn"  style="text-align:right; width:20%;" >
                      <b>
                        <%= com.egen.util.text.FormatNumber.format(sum_faturamento_dia_ant_0, "##,##0.00") %>
                      </b>
                    </td>
                  </tr>

                  <%
                  %>



                  <%
                  java.util.Vector res_Jw_consulta_mapa_diario_anterior = null;
                  com.egen.util.jdbc.JdbcUtil j2 = null;
                  try {
                    j2 = new com.egen.util.jdbc.JdbcUtil();
                    portalbr.dbobj.view.Jw_consulta_mapa_diario_anterior t_jw_consulta_mapa_diario_anterior = new portalbr.dbobj.view.Jw_consulta_mapa_diario_anterior();
                    String[][] select = {{"entrada_mes_ant_valor",null},{"variacao_entrada_valor",null},{"faturamento_mes_ant",null},{"variacao_faturamento_valor",null},};
                    Object[][] where = null;
                    String[] groupby =  null;
                    String[] having =  null;
                    String[] order =  null;
                    res_Jw_consulta_mapa_diario_anterior = j2.select(t_jw_consulta_mapa_diario_anterior,select,where,groupby,having,order);
                  } catch (Exception e){
                    e.printStackTrace();
                    session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                    %>
                    <jsp:forward page="/system/ErrorPage.jsp"/>
                    <%
                  } finally {
                  if(j2!=null){j2.close();}
                }
                %>





                <%
                if (res_Jw_consulta_mapa_diario_anterior!=null && res_Jw_consulta_mapa_diario_anterior.size()>0) {
                  %>

                  <%
                  java.lang.String label =  null;
                  double entrada_mes_ant_valor =  0;
                  double variacao_entrada_valor =  0;
                  double faturamento_mes_ant =  0;
                  double variacao_faturamento_valor =  0;
                  %>

                  <%
                  int i_bl_report_Jw_consulta_mapa_diario_anterior = 0;
                  while (i_bl_report_Jw_consulta_mapa_diario_anterior<res_Jw_consulta_mapa_diario_anterior.size()) {
                    portalbr.dbobj.view.Jw_consulta_mapa_diario_anterior t_jw_consulta_mapa_diario_anterior = (portalbr.dbobj.view.Jw_consulta_mapa_diario_anterior)res_Jw_consulta_mapa_diario_anterior.elementAt(i_bl_report_Jw_consulta_mapa_diario_anterior);
                    entrada_mes_ant_valor = t_jw_consulta_mapa_diario_anterior.getEntrada_mes_ant_valor();
                    variacao_entrada_valor = t_jw_consulta_mapa_diario_anterior.getVariacao_entrada_valor();
                    faturamento_mes_ant = t_jw_consulta_mapa_diario_anterior.getFaturamento_mes_ant();
                    variacao_faturamento_valor = t_jw_consulta_mapa_diario_anterior.getVariacao_faturamento_valor();
                    String style_bl_report_Jw_consulta_mapa_diario_anterior="";
                    if (!((i_bl_report_Jw_consulta_mapa_diario_anterior%2)!=0)) {
                      style_bl_report_Jw_consulta_mapa_diario_anterior="rowColor";
                    } else {
                      style_bl_report_Jw_consulta_mapa_diario_anterior="rowBlank";
                    }
                    %>

                    <tr class="totalColumn">
                      <td class="totalTdColumn" style="text-align:left;width:20%;" >
                        <b>
                          Ano Anterior
                        </b>
                      </td>

                      <td class="totalTdColumn" style="text-align:right;width:20%;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(entrada_mes_ant_valor, "##,##0.00") %>
                        </b>
                      </td>

                      <td class="totalTdColumn" style="text-align:right;width:20%;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(variacao_entrada_valor, "##,##0.00") %>
                        </b>
                      </td>

                      <td class="totalTdColumn" style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(faturamento_mes_ant, "##,##0.00") %>
                        </b>
                      </td>

                      <td class="totalTdColumn" style="text-align:right;width:20%;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(variacao_faturamento_valor, "##,##0.00") %>
                        </b>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Jw_consulta_mapa_diario_anterior++;
                    if (i_bl_report_Jw_consulta_mapa_diario_anterior<res_Jw_consulta_mapa_diario_anterior.size()) {
                      t_jw_consulta_mapa_diario_anterior = (portalbr.dbobj.view.Jw_consulta_mapa_diario_anterior)res_Jw_consulta_mapa_diario_anterior.elementAt(i_bl_report_Jw_consulta_mapa_diario_anterior);
                      entrada_mes_ant_valor = t_jw_consulta_mapa_diario_anterior.getEntrada_mes_ant_valor();
                      variacao_entrada_valor = t_jw_consulta_mapa_diario_anterior.getVariacao_entrada_valor();
                      faturamento_mes_ant = t_jw_consulta_mapa_diario_anterior.getFaturamento_mes_ant();
                      variacao_faturamento_valor = t_jw_consulta_mapa_diario_anterior.getVariacao_faturamento_valor();
                    } else {
                    }
                  }
                  %>


                  <%
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


































        <%
        {
          %>

          <%
          java.util.Vector res_Jw_consulta_mapa_diario_totais = null;
          com.egen.util.jdbc.JdbcUtil j = null;
          try {
            j = new com.egen.util.jdbc.JdbcUtil();
            portalbr.dbobj.view.Jw_consulta_mapa_diario_totais t_jw_consulta_mapa_diario_totais = new portalbr.dbobj.view.Jw_consulta_mapa_diario_totais();
            String[][] select = {{"total_para_mes_valor",null},{"carteira_atual_valor",null},{"carteira_anterior_valor",null},{"variacao_carteira_valor",null},};
            Object[][] where = null;
            String[] groupby =  null;
            String[] having =  null;
            String[] order =  null;
            res_Jw_consulta_mapa_diario_totais = j.select(t_jw_consulta_mapa_diario_totais,select,where,groupby,having,order);
          } catch (Exception e){
            session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
            %>
            <jsp:forward page="/system/ErrorPage.jsp"/>
            <%
          } finally {
          if(j!=null){j.close();}
        }
        %>

        <form  name="bl_report_Jw_consulta_mapa_diario_totais" id="bl_report_Jw_consulta_mapa_diario_totais" class="baseForm" method="post" >
          <%
          if (res_Jw_consulta_mapa_diario_totais!=null && res_Jw_consulta_mapa_diario_totais.size()>0) {
            %>

            <table id="TRbl_report_Jw_consulta_mapa_diario_totais"  class="reportTable"   style="width:99%; "  border="1" >
              <%
              double total_para_mes_valor =  0;
              double carteira_atual_valor =  0;
              double carteira_anterior_valor =  0;
              double variacao_carteira_valor =  0;
              %>

              <%
              int i_bl_report_Jw_consulta_mapa_diario_totais = 0;
              while (i_bl_report_Jw_consulta_mapa_diario_totais<res_Jw_consulta_mapa_diario_totais.size()) {
                portalbr.dbobj.view.Jw_consulta_mapa_diario_totais t_jw_consulta_mapa_diario_totais = (portalbr.dbobj.view.Jw_consulta_mapa_diario_totais)res_Jw_consulta_mapa_diario_totais.elementAt(i_bl_report_Jw_consulta_mapa_diario_totais);
                total_para_mes_valor = t_jw_consulta_mapa_diario_totais.getTotal_para_mes_valor();
                carteira_atual_valor = t_jw_consulta_mapa_diario_totais.getCarteira_atual_valor();
                carteira_anterior_valor = t_jw_consulta_mapa_diario_totais.getCarteira_anterior_valor();
                variacao_carteira_valor = t_jw_consulta_mapa_diario_totais.getVariacao_carteira_valor();
                String style_bl_report_Jw_consulta_mapa_diario_totais="";
                if (!((i_bl_report_Jw_consulta_mapa_diario_totais%2)!=0)) {
                  style_bl_report_Jw_consulta_mapa_diario_totais="rowColor";
                } else {
                  style_bl_report_Jw_consulta_mapa_diario_totais="rowBlank";
                }
                %>

                <tr class="rowColor" >
                  <td class="reportColumn" style="text-align:left; width:20%">
                    <b>
                      Total para mês
                    </b>
                  </td>
                  <td class="reportColumn" style="text-align:left">
                    <b>
                      <%= com.egen.util.text.FormatNumber.format(total_para_mes_valor, "##,##0.00") %>
                    </b>
                  </td>
                </tr>

                <tr class="rowColor" >
                  <td class="reportColumn" style="text-align:left; width:20%">
                    <b>
                      Carteira Atual
                    </b>
                  </td>
                  <td class="reportColumn" style="text-align:left;" >
                    <b>
                      <%= com.egen.util.text.FormatNumber.format(carteira_atual_valor, "##,##0.00") %>
                    </b>
                  </td>
                </tr>


                <tr class="rowColor" >
                  <td class="reportColumn" style="text-align:left; width:20%">
                    <b>
                      Carteira Anterior
                    </b>
                  </td>
                  <td class="reportColumn" style="text-align:left;" >
                    <b>
                      <%= com.egen.util.text.FormatNumber.format(carteira_anterior_valor, "##,##0.00") %>
                    </b>
                  </td>
                </tr>

                <tr class="rowColor" >
                  <td class="reportColumn" style="text-align:left; width:20%">
                    <b>
                      Variação (%)
                    </b>
                  </td>
                  <td class="reportColumn" style="text-align:left;" >
                    <b>
                      <%= com.egen.util.text.FormatNumber.format(variacao_carteira_valor, "##,##0.00") %>
                    </b>
                  </td>
                </tr>


                <%
                i_bl_report_Jw_consulta_mapa_diario_totais++;
                if (i_bl_report_Jw_consulta_mapa_diario_totais<res_Jw_consulta_mapa_diario_totais.size()) {
                  t_jw_consulta_mapa_diario_totais = (portalbr.dbobj.view.Jw_consulta_mapa_diario_totais)res_Jw_consulta_mapa_diario_totais.elementAt(i_bl_report_Jw_consulta_mapa_diario_totais);
                  total_para_mes_valor = t_jw_consulta_mapa_diario_totais.getTotal_para_mes_valor();
                  carteira_atual_valor = t_jw_consulta_mapa_diario_totais.getCarteira_atual_valor();
                  carteira_anterior_valor = t_jw_consulta_mapa_diario_totais.getCarteira_anterior_valor();
                  variacao_carteira_valor = t_jw_consulta_mapa_diario_totais.getVariacao_carteira_valor();
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
      <%
      {
        %>

        <%
        java.util.Vector res_Jw_tmp_mapa_diario_msn = null;
        com.egen.util.jdbc.JdbcUtil j = null;
        try {
          j = new com.egen.util.jdbc.JdbcUtil();
          portalbr.dbobj.view.Jw_tmp_mapa_diario_msn t_jw_tmp_mapa_diario_msn = new portalbr.dbobj.view.Jw_tmp_mapa_diario_msn();
          String[][] select = {{"texto",null},};
          Object[][] where = null;
          String[] groupby =  null;
          String[] having =  null;
          String[] order =  null;
          res_Jw_tmp_mapa_diario_msn = j.select(t_jw_tmp_mapa_diario_msn,select,where,groupby,having,order);
        } catch (Exception e){
          session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
          %>
          <jsp:forward page="/system/ErrorPage.jsp"/>
          <%
        } finally {
        if(j!=null){j.close();}
      }
      %>

      <form  name="bl_report_Jw_tmp_mapa_diario_msn" id="bl_report_Jw_tmp_mapa_diario_msn" class="baseForm" method="post" >
        <%
        if (res_Jw_tmp_mapa_diario_msn!=null && res_Jw_tmp_mapa_diario_msn.size()>0) {
          %>

          <table id="TRbl_report_Jw_tmp_mapa_diario_msn"  class="reportTable"   style="width:99%; "  border="1" >
            <%
            java.lang.String texto =  null;
            %>

            <tr class="reportTr">
              <td class="columnTdHeader" style="text-align:left;" >
                MSG
              </td>

            </tr>

            <%
            int i_bl_report_Jw_tmp_mapa_diario_msn = 0;
            while (i_bl_report_Jw_tmp_mapa_diario_msn<res_Jw_tmp_mapa_diario_msn.size()) {
              portalbr.dbobj.view.Jw_tmp_mapa_diario_msn t_jw_tmp_mapa_diario_msn = (portalbr.dbobj.view.Jw_tmp_mapa_diario_msn)res_Jw_tmp_mapa_diario_msn.elementAt(i_bl_report_Jw_tmp_mapa_diario_msn);
              texto = t_jw_tmp_mapa_diario_msn.getTexto()==null?"":t_jw_tmp_mapa_diario_msn.getTexto();
              String style_bl_report_Jw_tmp_mapa_diario_msn="";
              if (!((i_bl_report_Jw_tmp_mapa_diario_msn%2)!=0)) {
                style_bl_report_Jw_tmp_mapa_diario_msn="rowColor";
              } else {
                style_bl_report_Jw_tmp_mapa_diario_msn="rowBlank";
              }
              %>

              <tr class='<%= style_bl_report_Jw_tmp_mapa_diario_msn %>' id="TRbl_report_Jw_tmp_mapa_diario_msn<%=i_bl_report_Jw_tmp_mapa_diario_msn%>" >
                <td class="reportColumn" style="text-align:left;" >
                  <%= texto %>
                </td>

              </tr>

              <%
              i_bl_report_Jw_tmp_mapa_diario_msn++;
              if (i_bl_report_Jw_tmp_mapa_diario_msn<res_Jw_tmp_mapa_diario_msn.size()) {
                t_jw_tmp_mapa_diario_msn = (portalbr.dbobj.view.Jw_tmp_mapa_diario_msn)res_Jw_tmp_mapa_diario_msn.elementAt(i_bl_report_Jw_tmp_mapa_diario_msn);
                texto = t_jw_tmp_mapa_diario_msn.getTexto()==null?"":t_jw_tmp_mapa_diario_msn.getTexto();
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

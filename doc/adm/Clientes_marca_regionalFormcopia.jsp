<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page  extends='acesso.web.HttpJspSessao' %>
<html>
  <head>

    <title>
      Sumário de Clientes
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
                <table id="TRbl_report_Clientes_marca_regional" class="reportTable" style=width:99%;  border=1  frame=box>
                  <%
                  int counterbl_report_Clientes_marca_regional=0;
                  %>
                  <%
                  try {
                    portalbr.dbobj.view.Clientes_marca_regional t_clientes_marca_regional = new portalbr.dbobj.view.Clientes_marca_regional();
                    java.util.Vector res_Clientes_marca_regional = (java.util.Vector)session.getAttribute("res_Clientes_marca_regional");
                    if (res_Clientes_marca_regional!=null && res_Clientes_marca_regional.size()>0) {
                      java.lang.String marca =  null;
                      java.lang.String codigo_marca =  null;
                      java.lang.String codigo_regional =  null;
                      java.lang.String regional =  null;
                      java.lang.Integer clientes_ativos =  null;
                      java.lang.Integer clientes_atendidos =  null;
                      java.lang.Integer clientes_nao_atendidos =  null;
                      java.lang.Integer cidades_ativas =  null;
                      java.lang.Integer cidades_atendidas =  null;
                      java.lang.Integer cidades_nao_atendidas =  null;
                      int total_pares = 0;
                      double total_valor = 0;
                      int pares =  0;
                      double valor =  0;
                      int i_bl_report_Clientes_marca_regional = 0;
                      t_clientes_marca_regional = (portalbr.dbobj.view.Clientes_marca_regional)res_Clientes_marca_regional.elementAt(i_bl_report_Clientes_marca_regional);
                      marca = t_clientes_marca_regional.getMarca()==null?"":t_clientes_marca_regional.getMarca();
                      codigo_marca = t_clientes_marca_regional.getCodigo_marca()==null?"":t_clientes_marca_regional.getCodigo_marca();
                      codigo_regional = t_clientes_marca_regional.getCodigo_regional()==null?"":t_clientes_marca_regional.getCodigo_regional();
                      regional = t_clientes_marca_regional.getRegional()==null?"":t_clientes_marca_regional.getRegional();
                      clientes_ativos = t_clientes_marca_regional.getClientes_ativos();
                      clientes_atendidos = t_clientes_marca_regional.getClientes_atendidos();
                      clientes_nao_atendidos = t_clientes_marca_regional.getClientes_nao_atendidos();
                      cidades_ativas = t_clientes_marca_regional.getCidades_ativas();
                      cidades_atendidas = t_clientes_marca_regional.getCidades_atendidas();
                      cidades_nao_atendidas = t_clientes_marca_regional.getCidades_nao_atendidas();
                      pares                  =  Integer.parseInt(t_clientes_marca_regional.getPares()+"");
                      valor                  =  Double.parseDouble(t_clientes_marca_regional.getValor()+"");


                      java.lang.String b0_marca =  null;
                      while (i_bl_report_Clientes_marca_regional<res_Clientes_marca_regional.size()){
                        counterbl_report_Clientes_marca_regional++;
                        %>
                        <tr class="reportHeader" >
                          <td colspan=9>
                            Marca :
                            <%= marca %>
                          </td>
                        </tr>
                        <%
                        int sum_pares_0 = 0;
                        double sum_valor_0 = 0;
                        b0_marca = marca;
                        %>
                        <tr class="reportHeader3" >
                          <td class="columnTdHeader" style="text-align:left;">
                            Regional
                          </td>
                          <td class="columnTdHeader" style="text-align:center;">
                            Clientes
                            <br>
                            Ativos
                          </td>
                          <td class="columnTdHeader" style="text-align:center;">
                            Clientes
                            <br>
                            Atendidos
                          </td>
                          <td class="columnTdHeader" style="text-align:center;">
                            Clientes
                            <br>
                            Não Atendidos
                          </td>
                          <td class="columnTdHeader" style="text-align:center;">
                            Cidades
                            <br>
                            Ativas
                          </td>
                          <td class="columnTdHeader" style="text-align:center;">
                            Cidades
                            <br>
                            Atendidas
                          </td>
                          <td class="columnTdHeader" style="text-align:center;">
                            Cidades
                            <br>
                            Não Atendidas
                          </td>
                          <td class="columnTdHeader" style="text-align:right;">
                            Pares
                          </td>
                          <td class="columnTdHeader" style="text-align:right;">
                            Valor
                          </td>
                        </tr>
                        <%
                        while (i_bl_report_Clientes_marca_regional<res_Clientes_marca_regional.size() &&  (b0_marca==null?"":b0_marca).equals((marca==null?"":marca))){
                          counterbl_report_Clientes_marca_regional++;
                          String style="";
                          if (!((i_bl_report_Clientes_marca_regional%2)!=0)) {
                            style="class=rowColor";
                          } else {
                            style="class=rowBlank";
                          }
                          %>
                          <tr <%= style %> id='TRbl_report_Clientes_marca_regional<%=counterbl_report_Clientes_marca_regional%>' >
                            <td class="reportColumn" style="text-align:left;">
                              <%= regional %>
                            </td>
                            <td class="reportColumn" style="text-align:center;">
                              <%
                              if(Integer.parseInt(clientes_ativos+"")>0) {
                                %>
                                <a href="../adm/Clientes_ativos_marca_regionaisForm.do?select_action=&codigo_marca=<%= codigo_marca %>&codigo_regional=<%= codigo_regional %>&regional=<%= regional %>" target="_self" STYLE="cursor:hand">
                                  <%= clientes_ativos %>
                                </a>
                                <%
                              } else {
                                %>
                                0
                                <%
                              }
                              %>
                            </td>
                            <td class="reportColumn" style="text-align:center;">
                              <a href="../adm/Clientes_atendidos_marca_regionalForm.do?select_action=&codigo_marca=<%= codigo_marca %>&codigo_regional=<%= codigo_regional %>&regional=<%= regional %>" target="_self" STYLE="cursor:hand">
                                <%= clientes_atendidos %>
                              </a>
                            </td>
                            <td class="reportColumn" style="text-align:center;">
                              <%
                              if(Integer.parseInt(clientes_nao_atendidos+"")>0) {
                                %>
                                <a href="../adm/Clientes_nao_atendidos_marca_regionaisForm.do?select_action=&codigo_marca=<%= codigo_marca %>&codigo_regional=<%= codigo_regional %>&regional=<%= regional %>" target="_self" STYLE="cursor:hand">
                                  <%= clientes_nao_atendidos %>
                                </a>
                                <%
                              } else {
                                %>
                                0
                                <%
                              }
                              %>
                            </td>
                            <td class="reportColumn" style="text-align:center;">
                              <%
                              if(Integer.parseInt(cidades_ativas+"")>0)   {
                                %>
                                <a href="../adm/Cidades_ativasForm.do?select_action=&codigo_regional=<%= codigo_regional %>&codigo_marca=<%= codigo_marca %>&cab_cidade=da Regional : <%= regional %>&chamador=/adm/Clientes_marca_regionalForm.jsp" target="_self" STYLE="cursor:hand">
                                  <%= cidades_ativas %>
                                  <%
                                } else {
                                  %>
                                  0
                                  <%
                                }
                                %>


                              </td>
                              <td class="reportColumn" style="text-align:center;">
                                <a href="../adm/Cidades_atendidasForm.do?select_action=&codigo_regional=<%= codigo_regional %>&codigo_marca=<%= codigo_marca %>&cab_cidade=da Regional : <%= regional %>&chamador=/adm/Clientes_marca_regionalForm.jsp" target="_self" STYLE="cursor:hand">
                                  <%= cidades_atendidas %>
                                </a>
                              </td>
                              <td class="reportColumn" style="text-align:center;">
                                <%
                                if(Integer.parseInt(cidades_nao_atendidas+"")>0){
                                  %>
                                  <a href="../adm/Cidades_nao_atendidasForm.do?select_action=&codigo_regional=<%= codigo_regional %>&codigo_marca=<%= codigo_marca %>&cab_cidade=da Regional : <%= regional %>&chamador=/adm/Clientes_marca_regionalForm.jsp" target="_self" STYLE="cursor:hand">
                                    <%= cidades_nao_atendidas %>
                                    <%
                                  }else {
                                    %>
                                    0
                                    <%
                                  }
                                  %>
                                </td>


                                <td class="reportColumn" style="text-align:right;">
                                  <%= com.egen.util.text.FormatNumber.format(pares, "##,##0.##")  %>
                                </td>
                                <td class="reportColumn" style="text-align:right;">
                                  <%= com.egen.util.text.FormatNumber.format(valor, "##,##0.00") %>
                                </td>
                              </tr>
                              <%
                              sum_pares_0 += pares;
                              sum_valor_0 += valor;
                              total_pares += pares;
                              total_valor += valor;
                              if (++i_bl_report_Clientes_marca_regional >= res_Clientes_marca_regional.size()) {
                                break;
                              }
                              t_clientes_marca_regional = (portalbr.dbobj.view.Clientes_marca_regional)res_Clientes_marca_regional.elementAt(i_bl_report_Clientes_marca_regional);
                              marca = t_clientes_marca_regional.getMarca()==null?"":t_clientes_marca_regional.getMarca();
                              codigo_marca = t_clientes_marca_regional.getCodigo_marca()==null?"":t_clientes_marca_regional.getCodigo_marca();
                              codigo_regional = t_clientes_marca_regional.getCodigo_regional()==null?"":t_clientes_marca_regional.getCodigo_regional();
                              regional = t_clientes_marca_regional.getRegional()==null?"":t_clientes_marca_regional.getRegional();
                              clientes_ativos = t_clientes_marca_regional.getClientes_ativos();
                              clientes_atendidos = t_clientes_marca_regional.getClientes_atendidos();
                              clientes_nao_atendidos = t_clientes_marca_regional.getClientes_nao_atendidos();
                              cidades_ativas = t_clientes_marca_regional.getCidades_ativas();
                              cidades_atendidas = t_clientes_marca_regional.getCidades_atendidas();
                              cidades_nao_atendidas = t_clientes_marca_regional.getCidades_nao_atendidas();
                              pares    =  Integer.parseInt(t_clientes_marca_regional.getPares()+"");
                              valor    =  Double.parseDouble(t_clientes_marca_regional.getValor()+"");




                            }
                            %>
                            <tr class="totalColumn">
                              <td colspan=6>
                              </td>
                              <td class="totalTdColumn"  style="text-align:right;">
                                <b>
                                  Total:
                                  <b>
                                  </td>
                                  <td class="totalTdColumn"  style="text-align:right;">
                                    <%= com.egen.util.text.FormatNumber.format(sum_pares_0, "#,##0.##") %>
                                  </td>
                                  <td class="totalTdColumn"  style="text-align:right;">
                                    <%= com.egen.util.text.FormatNumber.format(sum_valor_0, "##,##0.00") %>
                                  </td>
                                </tr>
                                <%
                              }
                              %>
                              <tr class="totalColumn">
                                <td colspan=6>
                                </td>
                                <td class="totalTdColumn"  style="text-align:right;">
                                  <b>
                                    Total Geral:
                                    <b>
                                    </td>
                                    <td class="totalTdColumn"  style="text-align:right;">
                                      <%= com.egen.util.text.FormatNumber.format(total_pares, "#,##0.##") %>
                                    </td>
                                    <td class="totalTdColumn"  style="text-align:right;">
                                      <%= com.egen.util.text.FormatNumber.format(total_valor, "##,##0.00") %>
                                    </td>
                                  </tr>
                                  <%
                                }
                              } catch (Exception e) {
                                session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                                %>
                                <jsp:forward page="/system/ErrorPage.jsp"/>
                                <%
                              } finally {
                              }
                              %>
                            </table>
                          </form>
                          <%
                        }
                        %>
                        <html:form action="adm/Clientes_marca_regionalForm.do" method="POST" styleClass="baseForm">
                          <table class="buttonTable" style='width:;'>
                            <tr>
                              <td class="buttonItem">
                                <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                                  <bean:message bundle="ApplicationResources" key="jsp.select"/>
                                </html:submit>
                                <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                                  <bean:message bundle="ApplicationResources" key="jsp.back"/>
                                </html:submit>
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

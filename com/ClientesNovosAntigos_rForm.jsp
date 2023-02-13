<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta de Clientes Novos/Antigos/Reativados
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
                  <%@ include file="../system/header_excel.jsp" %>
                </td>

              </tr>

            </table>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_clientes_novos_antigos_normal = (java.util.Vector)session.getAttribute("res_Jw_clientes_novos_antigos_normal");
              %>

              <form  name="bl_report_Jw_clientes_novos_antigos_normal" id="bl_report_Jw_clientes_novos_antigos_normal" class="baseForm" method="post" >


                <%
                if (res_Jw_clientes_novos_antigos_normal!=null && res_Jw_clientes_novos_antigos_normal.size()>0) {
                  %>
                  <table border=1 width="100%">
                    <tr align="center" width="100%">
                      <td align="left">
                        <font color="" size=2>
                          <font color="">
                            <b>
                              Marca:
                            </b>
                          </font>
                          <font color="#C40000" size=1>
                            <b>
                              <%= session.getAttribute("parametro1")==null?"Todas":session.getAttribute("parametro1") %>
                            </b>
                          </font>
                          <font color="">
                            <br>
                            <b>
                              Regional:
                            </b>
                          </font>
                          <font color="#C40000" size=1>
                            <b>
                              <%= session.getAttribute("parametro2")==null?"Todas":session.getAttribute("parametro2") %>
                            </b>
                          </font>
                          <font color="">
                            <br>
                            <b>
                              Representante:
                            </b>
                          </font>
                          <font color="#C40000" size=1>
                            <b>
                              <%= session.getAttribute("parametro3")==null?"Todos":session.getAttribute("parametro3") %>
                            </b>
                          </font>
                        </td>
                      </tr>
                    </table>
                    <table id="TRbl_report_Jw_clientes_novos_antigos_normal"  class="reportTable"   style="width:99%; "  border="1" >
                      <%
                      java.lang.String status4 =  null;
                      int cli_cdgo2 =  0;
                      java.lang.String cli_nome2 =  null;
                      int pares3 =  0;
                      double valor3 =  0;
                      String _b0_control = "__";
                      int count_cli_cdgo2_0 = 0;
                      int count_cli_cdgo2_1 = 0;
                      int sum_pares3_0 = 0;
                      int sum_pares3_1 = 0;
                      double sum_valor3_0 = 0;
                      double sum_valor3_1 = 0;
                      int i_bl_report_Jw_clientes_novos_antigos_normal = 0;
                      while (i_bl_report_Jw_clientes_novos_antigos_normal<res_Jw_clientes_novos_antigos_normal.size()) {
                        portalbr.dbobj.view.Jw_clientes_novos_antigos_normal t_jw_clientes_novos_antigos_normal = (portalbr.dbobj.view.Jw_clientes_novos_antigos_normal)res_Jw_clientes_novos_antigos_normal.elementAt(i_bl_report_Jw_clientes_novos_antigos_normal);
                        status4 = t_jw_clientes_novos_antigos_normal.getStatus()==null?"":t_jw_clientes_novos_antigos_normal.getStatus();
                        cli_cdgo2 = t_jw_clientes_novos_antigos_normal.getCli_cdgo();
                        cli_nome2 = t_jw_clientes_novos_antigos_normal.getCli_nome()==null?"":t_jw_clientes_novos_antigos_normal.getCli_nome();
                        pares3 = t_jw_clientes_novos_antigos_normal.getPares();
                        valor3 = t_jw_clientes_novos_antigos_normal.getValor();
                        count_cli_cdgo2_0++;
                        count_cli_cdgo2_1++;
                        sum_pares3_0 += pares3;
                        sum_pares3_1 += pares3;
                        sum_valor3_0 += valor3;
                        sum_valor3_1 += valor3;
                        String _b0_value = (status4==null?"":status4);
                        if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                          %>
                          <tr class="reportHeader2">
                            <td colspan="4">
                              <span class="columnTdHeader" style="text-align:left;" >
                                <font color="black">
                                  <big>
                                    Clientes :
                                    <%= status4 %>
                                  </big>
                                </font>
                              </span>
                            </td>
                          </tr>
                          <%
                          %>

                          <tr class="reportTr">
                            <td class="columnTdHeader" style="text-align:left;" colspan="2">
                              Cliente
                            </td>

                            <td class="columnTdHeader" style="text-align:right;" >
                              Qtde.
                            </td>

                            <td class="columnTdHeader" style="text-align:right;" >
                              Valor
                            </td>

                          </tr>

                          <%
                        }
                        String style_bl_report_Jw_clientes_novos_antigos_normal="";
                        if (!((i_bl_report_Jw_clientes_novos_antigos_normal%2)!=0)) {
                          style_bl_report_Jw_clientes_novos_antigos_normal="rowColor";
                        } else {
                          style_bl_report_Jw_clientes_novos_antigos_normal="rowBlank";
                        }
                        %>

                        <tr class='<%= style_bl_report_Jw_clientes_novos_antigos_normal %>' id="TRbl_report_Jw_clientes_novos_antigos_normal<%=i_bl_report_Jw_clientes_novos_antigos_normal%>" >
                          <td class="reportColumn" style="text-align:left;" colspan="2" >
                            <%= cli_cdgo2 %>
                            -
                            <%= cli_nome2 %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= pares3 %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(valor3, "##,##0.00") %>
                          </td>

                        </tr>

                        <%
                        _b0_control = _b0_value;
                        i_bl_report_Jw_clientes_novos_antigos_normal++;
                        if (i_bl_report_Jw_clientes_novos_antigos_normal<res_Jw_clientes_novos_antigos_normal.size()) {
                          t_jw_clientes_novos_antigos_normal = (portalbr.dbobj.view.Jw_clientes_novos_antigos_normal)res_Jw_clientes_novos_antigos_normal.elementAt(i_bl_report_Jw_clientes_novos_antigos_normal);
                          status4 = t_jw_clientes_novos_antigos_normal.getStatus()==null?"":t_jw_clientes_novos_antigos_normal.getStatus();
                          cli_cdgo2 = t_jw_clientes_novos_antigos_normal.getCli_cdgo();
                          cli_nome2 = t_jw_clientes_novos_antigos_normal.getCli_nome()==null?"":t_jw_clientes_novos_antigos_normal.getCli_nome();
                          pares3 = t_jw_clientes_novos_antigos_normal.getPares();
                          valor3 = t_jw_clientes_novos_antigos_normal.getValor();
                          _b0_value = (status4==null?"":status4);
                        } else {
                          _b0_control = "__";
                        }
                        if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                          %>

                          <tr class="totalColumn">
                            <td class="totalTdColumn"  style="text-align:right;" colspan="2" >
                              <b>
                                Qtde. Clientes:
                              </b>
                              <b>
                                <%= com.egen.util.text.FormatNumber.format(count_cli_cdgo2_1, "##,##0") %>
                              </b>
                            </td>
                            <td class="totalTdColumn"  style="text-align:right;" >
                              <b>
                                Total:
                              </b>
                              <b>
                                <%= com.egen.util.text.FormatNumber.format(sum_pares3_1, "##,##0") %>
                              </b>
                            </td>
                            <td class="totalTdColumn"  style="text-align:right;" >
                              <b>
                                Total:
                              </b>
                              <b>
                                <%= com.egen.util.text.FormatNumber.format(sum_valor3_1, "##,##0.00") %>
                              </b>
                            </td>
                          </tr>

                          <%
                          count_cli_cdgo2_1 = 0;
                          sum_pares3_1 = 0;
                          sum_valor3_1 = 0;
                        }
                      }
                      %>

                      <tr class="totalColumn">
                        <td class="totalTdColumn"  style="text-align:right;" colspan="2" >
                          <b>
                            Qtde. Clientes:
                          </b>
                          <b>
                            <%= com.egen.util.text.FormatNumber.format(count_cli_cdgo2_0, "##,##0") %>
                          </b>
                        </td>

                        <td class="totalTdColumn"  style="text-align:right;" >
                          <b>
                            Total:
                          </b>
                          <b>
                            <%= com.egen.util.text.FormatNumber.format(sum_pares3_0, "##,##0") %>
                          </b>
                        </td>
                        <td class="totalTdColumn"  style="text-align:right;" >
                          <b>
                            Total:
                          </b>
                          <b>
                            <%= com.egen.util.text.FormatNumber.format(sum_valor3_0, "##,##0.00") %>
                          </b>
                        </td>
                      </tr>

                      <%
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
                java.util.Vector res_Jw_clientes_novos_antigos = (java.util.Vector)session.getAttribute("res_Jw_clientes_novos_antigos");
                %>
                <form  name="bl_report_Jw_clientes_novos_antigos" id="bl_report_Jw_clientes_novos_antigos" class="baseForm" method="post" >
                  <%
                  if (res_Jw_clientes_novos_antigos!=null && res_Jw_clientes_novos_antigos.size()>0) {
                    %>
                    <table border=1 width="100%">
                      <tr align="center" width="100%">
                        <td align="left">
                          <font color="" size=2>
                            <font color="">
                              <b>
                                Marca:
                              </b>
                            </font>
                            <font color="#C40000" size=1>
                              <b>
                                <%= session.getAttribute("parametro1")==null?"Todas":session.getAttribute("parametro1") %>
                              </b>
                            </font>
                            <font color="">
                              <br>
                              <b>
                                Regional:
                              </b>
                            </font>
                            <font color="#C40000" size=1>
                              <b>
                                <%= session.getAttribute("parametro2")==null?"Todas":session.getAttribute("parametro2") %>
                              </b>
                            </font>
                            <font color="">
                              <br>
                              <b>
                                Representante:
                              </b>
                            </font>
                            <font color="#C40000" size=1>
                              <b>
                                <%= session.getAttribute("parametro3")==null?"Todos":session.getAttribute("parametro3") %>
                              </b>
                            </font>
                          </td>
                        </tr>
                      </table>
                      <%
                      int codigo_regional =  0;
                      java.lang.String nome_regional =  null;
                      java.lang.String cliente_antigo =  null;
                      int cli_cdgo =  0;
                      java.lang.String cli_nome =  null;
                      int qtde =  0;
                      double valor_total =  0;
                      String _b0_control = "__";
                      String _b1_control = "__";
                      int count_cli_cdgo_0 = 0;
                      int count_cli_cdgo_1 = 0;
                      int count_cli_cdgo_2 = 0;
                      int sum_qtde_0 = 0;
                      int sum_qtde_1 = 0;
                      int sum_qtde_2 = 0;
                      double sum_valor_total_0 = 0;
                      double sum_valor_total_1 = 0;
                      double sum_valor_total_2 = 0;
                      int i_bl_report_Jw_clientes_novos_antigos = 0;
                      while (i_bl_report_Jw_clientes_novos_antigos<res_Jw_clientes_novos_antigos.size()) {
                        portalbr.dbobj.view.Jw_clientes_novos_antigos t_jw_clientes_novos_antigos = (portalbr.dbobj.view.Jw_clientes_novos_antigos)res_Jw_clientes_novos_antigos.elementAt(i_bl_report_Jw_clientes_novos_antigos);
                        codigo_regional = t_jw_clientes_novos_antigos.getCodigo_regional();
                        nome_regional = t_jw_clientes_novos_antigos.getNome_regional()==null?"":t_jw_clientes_novos_antigos.getNome_regional();
                        cliente_antigo = t_jw_clientes_novos_antigos.getStatus()==null?"":t_jw_clientes_novos_antigos.getStatus();
                        cli_cdgo = t_jw_clientes_novos_antigos.getCli_cdgo();
                        cli_nome = t_jw_clientes_novos_antigos.getCli_nome()==null?"":t_jw_clientes_novos_antigos.getCli_nome();
                        qtde = t_jw_clientes_novos_antigos.getQtde();
                        valor_total = t_jw_clientes_novos_antigos.getValor_total();
                        count_cli_cdgo_0++;
                        count_cli_cdgo_1++;
                        count_cli_cdgo_2++;
                        sum_qtde_0 += qtde;
                        sum_qtde_1 += qtde;
                        sum_qtde_2 += qtde;
                        sum_valor_total_0 += valor_total;
                        sum_valor_total_1 += valor_total;
                        sum_valor_total_2 += valor_total;
                        String _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional);
                        if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                          %>
                          <table id="TRbl_report_Jw_clientes_novos_antigos"  class="reportTable"   style="width:99%; "  border="1" >
                            <tr class="reportHeader3">
                              <td colspan="3">
                                <span class="columnTdHeader" style="text-align:right;" >
                                  <big>
                                    Regional :
                                  </big>
                                </span>
                                <span class="columnTdHeader" style="text-align:right;" >
                                  <big>
                                    <%= codigo_regional %>
                                    -
                                    <%= nome_regional %>
                                  </big>
                                </span>
                              </td>
                            </tr>
                            <%
                          }
                          String _b1_value = com.egen.util.text.FormatNumber.format(codigo_regional) + "_" + (cliente_antigo==null?"":cliente_antigo);
                          if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                            %>
                            <tr class="reportHeader2">
                              <td colspan="3">
                                <span class="columnTdHeader" style="text-align:left;" >
                                  <big>
                                    <font color="black">
                                      Clientes :
                                    </font>
                                  </big>
                                </span>
                                <span class="columnTdHeader" style="text-align:left;" >
                                  <big>
                                    <font color="black">
                                      <%= cliente_antigo %>
                                    </font>
                                  </big>
                                </span>
                              </td>
                            </tr>
                            <%
                            %>

                            <tr class="reportTr">
                              <td class="columnTdHeader" style="text-align:left;" >
                                Cliente
                              </td>
                              <td class="columnTdHeader" style="text-align:right;" >
                                Qtde.
                              </td>
                              <td class="columnTdHeader" style="text-align:right;" >
                                Valor
                              </td>
                            </tr>
                            <%
                          }
                          String style_bl_report_Jw_clientes_novos_antigos="";
                          if (!((i_bl_report_Jw_clientes_novos_antigos%2)!=0)) {
                            style_bl_report_Jw_clientes_novos_antigos="rowColor";
                          } else {
                            style_bl_report_Jw_clientes_novos_antigos="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Jw_clientes_novos_antigos %>' id="TRbl_report_Jw_clientes_novos_antigos<%=i_bl_report_Jw_clientes_novos_antigos%>" >
                            <td class="reportColumn" style="text-align:left;" >
                              <%= cli_cdgo %>
                              -
                              <%= cli_nome %>
                            </td>
                            <td class="reportColumn" style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(qtde, "##,##0") %>
                            </td>
                            <td class="reportColumn" style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(valor_total, "##,##0.00") %>
                            </td>
                          </tr>
                          <%
                          _b0_control = _b0_value;
                          _b1_control = _b1_value;
                          i_bl_report_Jw_clientes_novos_antigos++;
                          if (i_bl_report_Jw_clientes_novos_antigos<res_Jw_clientes_novos_antigos.size()) {
                            t_jw_clientes_novos_antigos = (portalbr.dbobj.view.Jw_clientes_novos_antigos)res_Jw_clientes_novos_antigos.elementAt(i_bl_report_Jw_clientes_novos_antigos);
                            codigo_regional = t_jw_clientes_novos_antigos.getCodigo_regional();
                            nome_regional = t_jw_clientes_novos_antigos.getNome_regional()==null?"":t_jw_clientes_novos_antigos.getNome_regional();
                            cliente_antigo = t_jw_clientes_novos_antigos.getStatus()==null?"":t_jw_clientes_novos_antigos.getStatus();
                            cli_cdgo = t_jw_clientes_novos_antigos.getCli_cdgo();
                            cli_nome = t_jw_clientes_novos_antigos.getCli_nome()==null?"":t_jw_clientes_novos_antigos.getCli_nome();
                            qtde = t_jw_clientes_novos_antigos.getQtde();
                            valor_total = t_jw_clientes_novos_antigos.getValor_total();
                            _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional);
                            _b1_value = com.egen.util.text.FormatNumber.format(codigo_regional) + "_" + (cliente_antigo==null?"":cliente_antigo);
                          } else {
                            _b0_control = "__";
                            _b1_control = "__";
                          }
                          if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                            %>

                            <tr class="totalColumn">
                              <td class="totalTdColumn"  style="text-align:right;" >
                                <b>
                                  Qtde. Clientes:
                                </b>
                                <%= com.egen.util.text.FormatNumber.format(count_cli_cdgo_1, "##,##0") %>
                              </td>

                              <td class="totalTdColumn"  style="text-align:right;" >
                                <b>
                                  Total:
                                </b>
                                <%= com.egen.util.text.FormatNumber.format(sum_qtde_1, "##,##0.00") %>
                              </td>
                              <td class="totalTdColumn"  style="text-align:right;" >
                                <b>
                                  Total:
                                </b>
                                <%= com.egen.util.text.FormatNumber.format(sum_valor_total_1, "##,##0.00") %>
                              </td>
                            </tr>

                            <%
                            count_cli_cdgo_1 = 0;
                            sum_qtde_1 = 0;
                            sum_valor_total_1 = 0;
                          }
                          if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                            %>

                            <tr class="totalColumn">
                              <td class="totalTdColumn"  style="text-align:right;" >
                                <b>
                                  Qtde. Clientes Regional:
                                </b>
                                <%= com.egen.util.text.FormatNumber.format(count_cli_cdgo_2, "##,##0") %>
                              </td>

                              <td class="totalTdColumn"  style="text-align:right;" >
                                <b>
                                  Total Regional:
                                </b>
                                <%= com.egen.util.text.FormatNumber.format(sum_qtde_2, "##,##0.00") %>
                              </td>
                              <td class="totalTdColumn"  style="text-align:right;" >
                                <b>
                                  Total Regional:
                                </b>
                                <%= com.egen.util.text.FormatNumber.format(sum_valor_total_2, "##,##0.00") %>
                              </td>
                            </tr>

                            <%
                            count_cli_cdgo_2 = 0;
                            sum_qtde_2 = 0;
                            sum_valor_total_2 = 0;
                          }
                        }
                        %>

                        <tr class="totalColumn">
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              Qtde. Clientes Geral:
                            </b>
                            <%= com.egen.util.text.FormatNumber.format(count_cli_cdgo_0, "##,##0") %>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              Total Geral:
                            </b>
                            <%= com.egen.util.text.FormatNumber.format(sum_qtde_0, "##,##0.00") %>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              Total Geral:
                            </b>
                            <%= com.egen.util.text.FormatNumber.format(sum_valor_total_0, "##,##0.00") %>
                          </td>
                        </tr>

                        <%
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
                  java.util.Vector res_Jw_clientes_novos_antigos_total_geral = (java.util.Vector)session.getAttribute("res_Jw_clientes_novos_antigos_total_geral");
                  %>

                  <form  name="bl_report_Jw_clientes_novos_antigos_total_geral" id="bl_report_Jw_clientes_novos_antigos_total_geral" class="baseForm" method="post" >
                    <%
                    if (res_Jw_clientes_novos_antigos_total_geral!=null && res_Jw_clientes_novos_antigos_total_geral.size()>0) {
                      %>

                      <table id="TRbl_report_Jw_clientes_novos_antigos_total_geral"  class="reportTable"   style="width:60%; "  align="center" border="2" >
                        <%
                        java.lang.String status =  null;
                        int qtde1 =  0;
                        int pares =  0;
                        double valor =  0;
                        int sum_qtde1_0 = 0;
                        int sum_pares_0 = 0;
                        double sum_valor_0 = 0;
                        %>

                        <tr class="reportHeader3">
                          <td class="columnTdHeader" style="text-align:left;" colspan="4">
                            <big>
                              Resumo Geral
                            </big>
                          </td>
                        </tr>
                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:left;" >
                            Clientes
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Qtde.
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Pares
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Valor
                          </td>

                        </tr>

                        <%
                        int i_bl_report_Jw_clientes_novos_antigos_total_geral = 0;
                        while (i_bl_report_Jw_clientes_novos_antigos_total_geral<res_Jw_clientes_novos_antigos_total_geral.size()) {
                          portalbr.dbobj.view.Jw_clientes_novos_antigos_total_geral t_jw_clientes_novos_antigos_total_geral = (portalbr.dbobj.view.Jw_clientes_novos_antigos_total_geral)res_Jw_clientes_novos_antigos_total_geral.elementAt(i_bl_report_Jw_clientes_novos_antigos_total_geral);
                          status = t_jw_clientes_novos_antigos_total_geral.getStatus()==null?"":t_jw_clientes_novos_antigos_total_geral.getStatus();
                          qtde1 = t_jw_clientes_novos_antigos_total_geral.getQtde();
                          pares = t_jw_clientes_novos_antigos_total_geral.getPares();
                          valor = t_jw_clientes_novos_antigos_total_geral.getValor();
                          sum_qtde1_0 += qtde1;
                          sum_pares_0 += pares;
                          sum_valor_0 += valor;
                          String style_bl_report_Jw_clientes_novos_antigos_total_geral="";
                          if (!((i_bl_report_Jw_clientes_novos_antigos_total_geral%2)!=0)) {
                            style_bl_report_Jw_clientes_novos_antigos_total_geral="rowColor";
                          } else {
                            style_bl_report_Jw_clientes_novos_antigos_total_geral="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Jw_clientes_novos_antigos_total_geral %>' id="TRbl_report_Jw_clientes_novos_antigos_total_geral<%=i_bl_report_Jw_clientes_novos_antigos_total_geral%>" >
                            <td class="reportColumn" style="text-align:left;" >
                              <%= status %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(qtde1, "##,##0") %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(pares, "##,##0") %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(valor, "##,##0.00") %>
                            </td>

                          </tr>

                          <%
                          i_bl_report_Jw_clientes_novos_antigos_total_geral++;
                          if (i_bl_report_Jw_clientes_novos_antigos_total_geral<res_Jw_clientes_novos_antigos_total_geral.size()) {
                            t_jw_clientes_novos_antigos_total_geral = (portalbr.dbobj.view.Jw_clientes_novos_antigos_total_geral)res_Jw_clientes_novos_antigos_total_geral.elementAt(i_bl_report_Jw_clientes_novos_antigos_total_geral);
                            status = t_jw_clientes_novos_antigos_total_geral.getStatus()==null?"":t_jw_clientes_novos_antigos_total_geral.getStatus();
                            qtde1 = t_jw_clientes_novos_antigos_total_geral.getQtde();
                            pares = t_jw_clientes_novos_antigos_total_geral.getPares();
                            valor = t_jw_clientes_novos_antigos_total_geral.getValor();
                          } else {
                          }
                        }
                        %>

                        <tr class="totalColumn">
                          <td>
                             
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              Total:
                            </b>
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_qtde1_0, "##,##0") %>
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_pares_0, "##,##0") %>
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_valor_0, "##,##0.00") %>
                            </b>
                          </td>
                        </tr>

                        <%
                        %>

                      </table>
                      <br>
                      <br>
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
                  java.util.Vector res_Jw_clientes_novos_antigos_total_marca = (java.util.Vector)session.getAttribute("res_Jw_clientes_novos_antigos_total_marca");
                  %>

                  <form  name="bl_report_Jw_clientes_novos_antigos_total_marca" id="bl_report_Jw_clientes_novos_antigos_total_marca" class="baseForm" method="post" >


                    <%
                    if (res_Jw_clientes_novos_antigos_total_marca!=null && res_Jw_clientes_novos_antigos_total_marca.size()>0) {
                      %>

                      <table id="TRbl_report_Jw_clientes_novos_antigos_total_marca"  class="reportTable"   style="width:60%; "  border="2" >
                        <tr class="reportHeader3">
                          <td colspan="4">
                            <span class="columnTdHeader" style="text-align:left;" >
                              <big>
                                Resumo p/ Marca
                              </big>
                            </span>
                          </td>
                        </tr>
                        <%
                        int codigo_marca =  0;
                        java.lang.String descricao_marca =  null;
                        java.lang.String status1 =  null;
                        int qtde2 =  0;
                        int pares1 =  0;
                        double valor1 =  0;
                        String _b0_control = "__";
                        int sum_qtde2_0 = 0;
                        int sum_qtde2_1 = 0;
                        int sum_pares1_0 = 0;
                        int sum_pares1_1 = 0;
                        double sum_valor1_0 = 0;
                        double sum_valor1_1 = 0;
                        int i_bl_report_Jw_clientes_novos_antigos_total_marca = 0;
                        while (i_bl_report_Jw_clientes_novos_antigos_total_marca<res_Jw_clientes_novos_antigos_total_marca.size()) {
                          portalbr.dbobj.view.Jw_clientes_novos_antigos_total_marca t_jw_clientes_novos_antigos_total_marca = (portalbr.dbobj.view.Jw_clientes_novos_antigos_total_marca)res_Jw_clientes_novos_antigos_total_marca.elementAt(i_bl_report_Jw_clientes_novos_antigos_total_marca);
                          codigo_marca = t_jw_clientes_novos_antigos_total_marca.getCodigo_marca();
                          descricao_marca = t_jw_clientes_novos_antigos_total_marca.getDescricao_marca()==null?"":t_jw_clientes_novos_antigos_total_marca.getDescricao_marca();
                          status1 = t_jw_clientes_novos_antigos_total_marca.getStatus()==null?"":t_jw_clientes_novos_antigos_total_marca.getStatus();
                          qtde2 = t_jw_clientes_novos_antigos_total_marca.getQtde();
                          pares1 = t_jw_clientes_novos_antigos_total_marca.getPares();
                          valor1 = t_jw_clientes_novos_antigos_total_marca.getValor();
                          sum_qtde2_0 += qtde2;
                          sum_qtde2_1 += qtde2;
                          sum_pares1_0 += pares1;
                          sum_pares1_1 += pares1;
                          sum_valor1_0 += valor1;
                          sum_valor1_1 += valor1;
                          String _b0_value = com.egen.util.text.FormatNumber.format(codigo_marca);
                          if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                            %>
                            <tr class="reportHeader2">
                              <td colspan="4">
                                <span class="columnTdHeader" style="text-align:right;" >
                                  <font color="black">
                                    Marca :
                                    <%= codigo_marca %>
                                    -
                                    <%= descricao_marca %>
                                  </font>
                                </span>
                              </td>
                            </tr>
                            <%
                            %>

                            <tr class="reportTr">
                              <td class="columnTdHeader" style="text-align:left;" >
                                Clientes
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" >
                                Qtde.
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" >
                                Pares
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" >
                                Valor
                              </td>

                            </tr>

                            <%
                          }
                          String style_bl_report_Jw_clientes_novos_antigos_total_marca="";
                          if (!((i_bl_report_Jw_clientes_novos_antigos_total_marca%2)!=0)) {
                            style_bl_report_Jw_clientes_novos_antigos_total_marca="rowColor";
                          } else {
                            style_bl_report_Jw_clientes_novos_antigos_total_marca="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Jw_clientes_novos_antigos_total_marca %>' id="TRbl_report_Jw_clientes_novos_antigos_total_marca<%=i_bl_report_Jw_clientes_novos_antigos_total_marca%>" >
                            <td class="reportColumn" style="text-align:left;" >
                              <%= status1 %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(qtde2, "##,##0") %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(pares1, "##,##0") %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(valor1, "##,##0.00") %>
                            </td>

                          </tr>

                          <%
                          _b0_control = _b0_value;
                          i_bl_report_Jw_clientes_novos_antigos_total_marca++;
                          if (i_bl_report_Jw_clientes_novos_antigos_total_marca<res_Jw_clientes_novos_antigos_total_marca.size()) {
                            t_jw_clientes_novos_antigos_total_marca = (portalbr.dbobj.view.Jw_clientes_novos_antigos_total_marca)res_Jw_clientes_novos_antigos_total_marca.elementAt(i_bl_report_Jw_clientes_novos_antigos_total_marca);
                            codigo_marca = t_jw_clientes_novos_antigos_total_marca.getCodigo_marca();
                            descricao_marca = t_jw_clientes_novos_antigos_total_marca.getDescricao_marca()==null?"":t_jw_clientes_novos_antigos_total_marca.getDescricao_marca();
                            status1 = t_jw_clientes_novos_antigos_total_marca.getStatus()==null?"":t_jw_clientes_novos_antigos_total_marca.getStatus();
                            qtde2 = t_jw_clientes_novos_antigos_total_marca.getQtde();
                            pares1 = t_jw_clientes_novos_antigos_total_marca.getPares();
                            valor1 = t_jw_clientes_novos_antigos_total_marca.getValor();
                            _b0_value = com.egen.util.text.FormatNumber.format(codigo_marca);
                          } else {
                            _b0_control = "__";
                          }
                          if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                            %>

                            <tr class="totalColumn">
                              <td>
                                 
                              </td>
                              <td class="totalTdColumn"  style="text-align:right;" >
                                <b>
                                  Total:
                                </b>
                                <b>
                                  <%= com.egen.util.text.FormatNumber.format(sum_qtde2_1, "##,##0") %>
                                </b>
                              </td>
                              <td class="totalTdColumn"  style="text-align:right;" >
                                <b>
                                  <%= com.egen.util.text.FormatNumber.format(sum_pares1_1, "##,##0") %>
                                </b>

                              </td>
                              <td class="totalTdColumn"  style="text-align:right;" >
                                <b>
                                  <%= com.egen.util.text.FormatNumber.format(sum_valor1_1, "##,##0.00") %>
                                </b>
                              </td>
                            </tr>

                            <%
                            sum_qtde2_1 = 0;
                            sum_pares1_1 = 0;
                            sum_valor1_1 = 0;
                          }
                        }
                        %>

                        <tr class="totalColumn">
                          <td>
                             
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              Total Geral:
                            </b>
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_qtde2_0, "##,##0") %>
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_pares1_0, "##,##0") %>
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_valor1_0, "##,##0.00") %>
                            </b>
                          </td>
                        </tr>

                        <%
                        %>

                      </table>
                      <br>
                      <br>
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
                  java.util.Vector res_Jw_clientes_novos_antigos_total_regional = (java.util.Vector)session.getAttribute("res_Jw_clientes_novos_antigos_total_regional");
                  %>

                  <form  name="bl_report_Jw_clientes_novos_antigos_total_regional" id="bl_report_Jw_clientes_novos_antigos_total_regional" class="baseForm" method="post" >

                    <%
                    if (res_Jw_clientes_novos_antigos_total_regional!=null && res_Jw_clientes_novos_antigos_total_regional.size()>0) {
                      %>

                      <table id="TRbl_report_Jw_clientes_novos_antigos_total_regional"  class="reportTable"   style="width:60%; "  border="2" >
                        <tr class="reportHeader3">
                          <td colspan="4">
                            <big>
                              Resumo p/ Regional
                            </big>
                          </td>
                        </tr>
                        <%
                        int codigo_regional1 =  0;
                        java.lang.String nome_regional1 =  null;
                        java.lang.String status2 =  null;
                        int qtde3 =  0;
                        int pares2 =  0;
                        double valor2 =  0;
                        String _b0_control = "__";
                        int sum_qtde3_0 = 0;
                        int sum_qtde3_1 = 0;
                        int sum_pares2_0 = 0;
                        int sum_pares2_1 = 0;
                        double sum_valor2_0 = 0;
                        double sum_valor2_1 = 0;
                        int i_bl_report_Jw_clientes_novos_antigos_total_regional = 0;
                        while (i_bl_report_Jw_clientes_novos_antigos_total_regional<res_Jw_clientes_novos_antigos_total_regional.size()) {
                          portalbr.dbobj.view.Jw_clientes_novos_antigos_total_regional t_jw_clientes_novos_antigos_total_regional = (portalbr.dbobj.view.Jw_clientes_novos_antigos_total_regional)res_Jw_clientes_novos_antigos_total_regional.elementAt(i_bl_report_Jw_clientes_novos_antigos_total_regional);
                          codigo_regional1 = t_jw_clientes_novos_antigos_total_regional.getCodigo_regional();
                          nome_regional1 = t_jw_clientes_novos_antigos_total_regional.getNome_regional()==null?"":t_jw_clientes_novos_antigos_total_regional.getNome_regional();
                          status2 = t_jw_clientes_novos_antigos_total_regional.getStatus()==null?"":t_jw_clientes_novos_antigos_total_regional.getStatus();
                          qtde3 = t_jw_clientes_novos_antigos_total_regional.getQtde();
                          pares2 = t_jw_clientes_novos_antigos_total_regional.getPares();
                          valor2 = t_jw_clientes_novos_antigos_total_regional.getValor();
                          sum_qtde3_0 += qtde3;
                          sum_qtde3_1 += qtde3;
                          sum_pares2_0 += pares2;
                          sum_pares2_1 += pares2;
                          sum_valor2_0 += valor2;
                          sum_valor2_1 += valor2;
                          String _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional1);
                          if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                            %>
                            <tr class="reportHeader2">
                              <td colspan="4">
                                <span class="columnTdHeader" style="text-align:right;" >
                                  <font color="black">
                                    Regional :
                                    <%= codigo_regional1 %>
                                    -
                                    <%= nome_regional1 %>
                                  </font>
                                </span>

                              </td>
                            </tr>
                            <%
                            %>

                            <tr class="reportTr">
                              <td class="columnTdHeader" style="text-align:left;" >
                                Clientes
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" >
                                Qtde.
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" >
                                Pares
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" >
                                Valor
                              </td>

                            </tr>

                            <%
                          }
                          String style_bl_report_Jw_clientes_novos_antigos_total_regional="";
                          if (!((i_bl_report_Jw_clientes_novos_antigos_total_regional%2)!=0)) {
                            style_bl_report_Jw_clientes_novos_antigos_total_regional="rowColor";
                          } else {
                            style_bl_report_Jw_clientes_novos_antigos_total_regional="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Jw_clientes_novos_antigos_total_regional %>' id="TRbl_report_Jw_clientes_novos_antigos_total_regional<%=i_bl_report_Jw_clientes_novos_antigos_total_regional%>" >
                            <td class="reportColumn" style="text-align:left;" >
                              <%= status2 %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(qtde3, "##,##0") %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(pares2, "##,##0") %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(valor2, "##,##0.00") %>
                            </td>

                          </tr>

                          <%
                          _b0_control = _b0_value;
                          i_bl_report_Jw_clientes_novos_antigos_total_regional++;
                          if (i_bl_report_Jw_clientes_novos_antigos_total_regional<res_Jw_clientes_novos_antigos_total_regional.size()) {
                            t_jw_clientes_novos_antigos_total_regional = (portalbr.dbobj.view.Jw_clientes_novos_antigos_total_regional)res_Jw_clientes_novos_antigos_total_regional.elementAt(i_bl_report_Jw_clientes_novos_antigos_total_regional);
                            codigo_regional1 = t_jw_clientes_novos_antigos_total_regional.getCodigo_regional();
                            nome_regional1 = t_jw_clientes_novos_antigos_total_regional.getNome_regional()==null?"":t_jw_clientes_novos_antigos_total_regional.getNome_regional();
                            status2 = t_jw_clientes_novos_antigos_total_regional.getStatus()==null?"":t_jw_clientes_novos_antigos_total_regional.getStatus();
                            qtde3 = t_jw_clientes_novos_antigos_total_regional.getQtde();
                            pares2 = t_jw_clientes_novos_antigos_total_regional.getPares();
                            valor2 = t_jw_clientes_novos_antigos_total_regional.getValor();
                            _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional1);
                          } else {
                            _b0_control = "__";
                          }
                          if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                            %>

                            <tr class="totalColumn">
                              <td>
                                 
                              </td>
                              <td class="totalTdColumn"  style="text-align:right;" >
                                <b>
                                  Total:
                                </b>
                                <b>
                                  <%= com.egen.util.text.FormatNumber.format(sum_qtde3_1, "##,##0") %>
                                </b>
                              </td>
                              <td class="totalTdColumn"  style="text-align:right;" >
                                <b>
                                  <%= com.egen.util.text.FormatNumber.format(sum_pares2_1, "##,##0") %>
                                </b>
                              </td>
                              <td class="totalTdColumn"  style="text-align:right;" >
                                <b>
                                  <%= com.egen.util.text.FormatNumber.format(sum_valor2_1, "##,##0.00") %>
                                </b>
                              </td>
                            </tr>

                            <%
                            sum_qtde3_1 = 0;
                            sum_pares2_1 = 0;
                            sum_valor2_1 = 0;
                          }
                        }
                        %>

                        <tr class="totalColumn">
                          <td>
                             
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              Total Geral:
                            </b>
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_qtde3_0, "##,##0") %>
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_pares2_0, "##,##0") %>
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_valor2_0, "##,##0.00") %>
                            </b>
                          </td>
                        </tr>

                        <%
                        %>

                      </table>
                      <br>
                      <br>
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
                  java.util.Vector res_Jw_clientes_novos_antigos_total_representante = (java.util.Vector)session.getAttribute("res_Jw_clientes_novos_antigos_total_representante");
                  %>

                  <form  name="bl_report_Jw_clientes_novos_antigos_total_representante" id="bl_report_Jw_clientes_novos_antigos_total_representante" class="baseForm" method="post" >
                    <%
                    if (res_Jw_clientes_novos_antigos_total_representante!=null && res_Jw_clientes_novos_antigos_total_representante.size()>0) {
                      %>

                      <table id="TRbl_report_Jw_clientes_novos_antigos_total_representante"  class="reportTable"   style="width:99%; "  border="1" >
                        <tr class="reportHeader3">
                          <td colspan="4">
                            <big>
                              Resumo p/ Representante
                            </big>
                          </td>
                        </tr>
                        <%
                        java.lang.String rep_cdgo =  null;
                        java.lang.String rep_rzao =  null;
                        java.lang.String status3 =  null;
                        int qtde4 =  0;
                        int pares4 =  0;
                        double valor4 =  0;
                        String _b0_control = "__";
                        int sum_qtde4_0 = 0;
                        int sum_qtde4_1 = 0;
                        int sum_pares4_0 = 0;
                        int sum_pares4_1 = 0;
                        double sum_valor4_0 = 0;
                        double sum_valor4_1 = 0;
                        int i_bl_report_Jw_clientes_novos_antigos_total_representante = 0;
                        while (i_bl_report_Jw_clientes_novos_antigos_total_representante<res_Jw_clientes_novos_antigos_total_representante.size()) {
                          portalbr.dbobj.view.Jw_clientes_novos_antigos_total_representante t_jw_clientes_novos_antigos_total_representante = (portalbr.dbobj.view.Jw_clientes_novos_antigos_total_representante)res_Jw_clientes_novos_antigos_total_representante.elementAt(i_bl_report_Jw_clientes_novos_antigos_total_representante);
                          rep_cdgo = t_jw_clientes_novos_antigos_total_representante.getRep_cdgo()==null?"":t_jw_clientes_novos_antigos_total_representante.getRep_cdgo();
                          rep_rzao = t_jw_clientes_novos_antigos_total_representante.getRep_rzao()==null?"":t_jw_clientes_novos_antigos_total_representante.getRep_rzao();
                          status3 = t_jw_clientes_novos_antigos_total_representante.getStatus()==null?"":t_jw_clientes_novos_antigos_total_representante.getStatus();
                          qtde4 = t_jw_clientes_novos_antigos_total_representante.getQtde();
                          pares4 = t_jw_clientes_novos_antigos_total_representante.getPares();
                          valor4 = t_jw_clientes_novos_antigos_total_representante.getValor();
                          sum_qtde4_0 += qtde4;
                          sum_qtde4_1 += qtde4;
                          sum_pares4_0 += pares4;
                          sum_pares4_1 += pares4;
                          sum_valor4_0 += valor4;
                          sum_valor4_1 += valor4;
                          String _b0_value = (rep_cdgo==null?"":rep_cdgo);
                          if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                            %>
                            <tr class="reportHeader2">
                              <td colspan="4">
                                <span class="columnTdHeader" style="text-align:left;" >
                                  <font color ="black">
                                    Representante :
                                    <%= rep_cdgo %>
                                    -
                                    <%= rep_rzao %>
                                  </font>
                                </span>
                              </td>
                            </tr>
                            <%
                            %>

                            <tr class="reportTr">
                              <td class="columnTdHeader" style="text-align:left;" >
                                Clientes
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" >
                                Qtde.
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" >
                                Pares
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" >
                                Valor
                              </td>

                            </tr>

                            <%
                          }
                          String style_bl_report_Jw_clientes_novos_antigos_total_representante="";
                          if (!((i_bl_report_Jw_clientes_novos_antigos_total_representante%2)!=0)) {
                            style_bl_report_Jw_clientes_novos_antigos_total_representante="rowColor";
                          } else {
                            style_bl_report_Jw_clientes_novos_antigos_total_representante="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Jw_clientes_novos_antigos_total_representante %>' id="TRbl_report_Jw_clientes_novos_antigos_total_representante<%=i_bl_report_Jw_clientes_novos_antigos_total_representante%>" >
                            <td class="reportColumn" style="text-align:left;" >
                              <%= status3 %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(qtde4, "##,##0") %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(pares4, "##,##0") %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(valor4, "##,##0.00") %>
                            </td>

                          </tr>

                          <%
                          _b0_control = _b0_value;
                          i_bl_report_Jw_clientes_novos_antigos_total_representante++;
                          if (i_bl_report_Jw_clientes_novos_antigos_total_representante<res_Jw_clientes_novos_antigos_total_representante.size()) {
                            t_jw_clientes_novos_antigos_total_representante = (portalbr.dbobj.view.Jw_clientes_novos_antigos_total_representante)res_Jw_clientes_novos_antigos_total_representante.elementAt(i_bl_report_Jw_clientes_novos_antigos_total_representante);
                            rep_cdgo = t_jw_clientes_novos_antigos_total_representante.getRep_cdgo()==null?"":t_jw_clientes_novos_antigos_total_representante.getRep_cdgo();
                            rep_rzao = t_jw_clientes_novos_antigos_total_representante.getRep_rzao()==null?"":t_jw_clientes_novos_antigos_total_representante.getRep_rzao();
                            status3 = t_jw_clientes_novos_antigos_total_representante.getStatus()==null?"":t_jw_clientes_novos_antigos_total_representante.getStatus();
                            qtde4 = t_jw_clientes_novos_antigos_total_representante.getQtde();
                            pares4 = t_jw_clientes_novos_antigos_total_representante.getPares();
                            valor4 = t_jw_clientes_novos_antigos_total_representante.getValor();
                            _b0_value = (rep_cdgo==null?"":rep_cdgo);
                          } else {
                            _b0_control = "__";
                          }
                          if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                            %>

                            <tr class="totalColumn">
                              <td>
                                 
                              </td>
                              <td class="totalTdColumn"  style="text-align:right;" >
                                <b>
                                  Total:
                                </b>
                                <b>
                                  <%= com.egen.util.text.FormatNumber.format(sum_qtde4_1, "##,##0") %>
                                </b>
                              </td>
                              <td class="totalTdColumn"  style="text-align:right;" >
                                <b>
                                  <%= com.egen.util.text.FormatNumber.format(sum_pares4_1, "##,##0") %>
                                </b>
                              </td>
                              <td class="totalTdColumn"  style="text-align:right;" >
                                <b>
                                  <%= com.egen.util.text.FormatNumber.format(sum_valor4_1, "##,##0.00") %>
                                </b>

                              </td>
                            </tr>

                            <%
                            sum_qtde4_1 = 0;
                            sum_pares4_1 = 0;
                            sum_valor4_1 = 0;
                          }
                        }
                        %>

                        <tr class="totalColumn">
                          <td>
                             
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              Total Geral:
                            </b>
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_qtde4_0, "##,##0") %>
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_pares4_0, "##,##0.00") %>
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_valor4_0, "##,##0.00") %>
                            </b>
                          </td>
                        </tr>

                        <%
                        %>

                      </table>

                      <%
                    }
                    %>

                  </form>
                  <%
                }
                %>

                <html:form action="com/ClientesNovosAntigos_rForm.do" method="post" styleClass="baseForm">
                  <table class="messageTable" style='width:99%;'>
                    <tr class="messageTr" >
                      <td class="messageTd">
                      </td>
                    </tr>
                  </table>

                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                            <bean:message bundle="ApplicationResources" key="jsp.back"/>
                          </html:submit>
                          <%
                        }
                        %>
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

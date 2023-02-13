<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Pendências de Clientes
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
                </td>

              </tr>

            </table>

            <%
            {
              java.util.Vector res_Jw_pendencias_regionais_clientes = (java.util.Vector)session.getAttribute("res_Jw_pendencias_regionais_clientes");
              %>
              <form  name="bl_report_Jw_pendencias_regionais_clientes" id="bl_report_Jw_pendencias_regionais_clientes" class="baseForm" method="post" >
                <%
                if (res_Jw_pendencias_regionais_clientes!=null && res_Jw_pendencias_regionais_clientes.size()>0) {
                  %>
                  <table id="TRbl_report_Jw_pendencias_regionais_clientes"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    int codigo_regional =  0;
                    java.lang.String nome_regional =  null;
                    java.lang.String rep_cdgo =  null;
                    java.lang.String rep_nome =  null;
                    java.lang.String rep_situ =  null;
                    int cli_cdgo =  0;
                    java.lang.String cli_rzao =  null;
                    double vencido =  0;
                    double vencer =  0;
                    double percentual =  0;
                    String _b0_control = "__";
                    String _b1_control = "__";
                    double sum_vencido_1 = 0;
                    double sum_vencido_0 = 0;
                    double sum_vencido_2 = 0;
                    double sum_vencer_1 = 0;
                    double sum_vencer_2 = 0;
                    double sum_vencer_0 = 0;
                    double sum_percentual_1 = 0;
                    double sum_percentual_0 = 0;
                    double sum_percentual_2 = 0;
                    int i_bl_report_Jw_pendencias_regionais_clientes = 0;
                    while (i_bl_report_Jw_pendencias_regionais_clientes<res_Jw_pendencias_regionais_clientes.size()) {
                      portalbr.dbobj.view.Jw_pendencias_regionais_clientes t_jw_pendencias_regionais_clientes = (portalbr.dbobj.view.Jw_pendencias_regionais_clientes)res_Jw_pendencias_regionais_clientes.elementAt(i_bl_report_Jw_pendencias_regionais_clientes);
                      codigo_regional = t_jw_pendencias_regionais_clientes.getCodigo_regional();
                      nome_regional = t_jw_pendencias_regionais_clientes.getNome_regional()==null?"":t_jw_pendencias_regionais_clientes.getNome_regional();
                      rep_cdgo = t_jw_pendencias_regionais_clientes.getRep_cdgo()==null?"":t_jw_pendencias_regionais_clientes.getRep_cdgo();
                      rep_nome = t_jw_pendencias_regionais_clientes.getRep_nome()==null?"":t_jw_pendencias_regionais_clientes.getRep_nome();
                      rep_situ = t_jw_pendencias_regionais_clientes.getRep_situ().equals("A")?"Ativo":"Inativo";
                      cli_cdgo = t_jw_pendencias_regionais_clientes.getCli_cdgo();
                      cli_rzao = t_jw_pendencias_regionais_clientes.getCli_rzao()==null?"":t_jw_pendencias_regionais_clientes.getCli_rzao();
                      vencido = t_jw_pendencias_regionais_clientes.getVencido();
                      vencer = t_jw_pendencias_regionais_clientes.getVencer();
                      percentual = t_jw_pendencias_regionais_clientes.getPercentual();
                      sum_vencido_1 += vencido;
                      sum_vencido_0 += vencido;
                      sum_vencido_2 += vencido;
                      sum_vencer_1 += vencer;
                      sum_vencer_2 += vencer;
                      sum_vencer_0 += vencer;
                      sum_percentual_1 += percentual;
                      sum_percentual_0 += percentual;
                      sum_percentual_2 += percentual;
                      String _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional);
                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                        %>
                        <tr class="reportHeader3">
                          <td colspan="5">
                            <span class="columnTdHeader" style="text-align:right;" >
                              Regional :
                            </span>
                            <span class="columnTdHeader" style="text-align:right;" >
                              <%= codigo_regional %>
                            </span>
                            <span class="columnTdHeader" style="text-align:left;" >
                              -
                            </span>
                            <span class="columnTdHeader" style="text-align:left;" >
                              <%= nome_regional %>
                            </span>
                          </td>
                        </tr>
                        <%
                      }
                      String _b1_value = com.egen.util.text.FormatNumber.format(codigo_regional) + "_" + (rep_cdgo==null?"":rep_cdgo);
                      if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                        %>
                        <tr class="reportHeader2">
                          <td colspan="5">
                            <span class="reportColumn" style="text-align:left;" >
                              Representante :
                            </span>
                            <span class="reportColumn" style="text-align:left;" >
                              <%= rep_cdgo %>
                            </span>
                            <span class="reportColumn" style="text-align:left;" >
                              -
                            </span>
                            <span class="reportColumn" style="text-align:left;" >
                              <%= rep_nome %>
                            </span>
                            <span class="reportColumn" style="text-align:left;" >
                              Situação :
                            </span>
                            <span class="reportColumn" style="text-align:left;" >
                              <%= rep_situ %>
                            </span>
                          </td>
                        </tr>
                        <%
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:right;" >
                            Cliente
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Razão Social
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Vencido
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            A Vencer
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            % Pendência
                          </td>

                        </tr>

                        <%
                      }
                      String style_bl_report_Jw_pendencias_regionais_clientes="";
                      if (!((i_bl_report_Jw_pendencias_regionais_clientes%2)!=0)) {
                        style_bl_report_Jw_pendencias_regionais_clientes="rowColor";
                      } else {
                        style_bl_report_Jw_pendencias_regionais_clientes="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_pendencias_regionais_clientes %>' id="TRbl_report_Jw_pendencias_regionais_clientes<%=i_bl_report_Jw_pendencias_regionais_clientes%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= cli_cdgo %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cli_rzao %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(vencido, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(vencer, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(percentual, "##,##0.00") %>
                        </td>

                      </tr>

                      <%
                      _b0_control = _b0_value;
                      _b1_control = _b1_value;
                      i_bl_report_Jw_pendencias_regionais_clientes++;
                      if (i_bl_report_Jw_pendencias_regionais_clientes<res_Jw_pendencias_regionais_clientes.size()) {
                        t_jw_pendencias_regionais_clientes = (portalbr.dbobj.view.Jw_pendencias_regionais_clientes)res_Jw_pendencias_regionais_clientes.elementAt(i_bl_report_Jw_pendencias_regionais_clientes);
                        codigo_regional = t_jw_pendencias_regionais_clientes.getCodigo_regional();
                        nome_regional = t_jw_pendencias_regionais_clientes.getNome_regional()==null?"":t_jw_pendencias_regionais_clientes.getNome_regional();
                        rep_cdgo = t_jw_pendencias_regionais_clientes.getRep_cdgo()==null?"":t_jw_pendencias_regionais_clientes.getRep_cdgo();
                        rep_nome = t_jw_pendencias_regionais_clientes.getRep_nome()==null?"":t_jw_pendencias_regionais_clientes.getRep_nome();
                        rep_situ = t_jw_pendencias_regionais_clientes.getRep_situ().equals("A")?"Ativo":"Inativo";
                        cli_cdgo = t_jw_pendencias_regionais_clientes.getCli_cdgo();
                        cli_rzao = t_jw_pendencias_regionais_clientes.getCli_rzao()==null?"":t_jw_pendencias_regionais_clientes.getCli_rzao();
                        vencido = t_jw_pendencias_regionais_clientes.getVencido();
                        vencer = t_jw_pendencias_regionais_clientes.getVencer();
                        percentual = t_jw_pendencias_regionais_clientes.getPercentual();
                        _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional);
                        _b1_value = com.egen.util.text.FormatNumber.format(codigo_regional) + "_" + (rep_cdgo==null?"":rep_cdgo);
                      } else {
                        _b0_control = "__";
                        _b1_control = "__";
                      }
                      if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                        %>

                        <tr class="totalColumn">
                          <td>
                             
                          </td>
                          <td align="right">
                            <b>
                              Total Representante :
                            </b>
                             
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_vencido_1, "##,##0.00") %>
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_vencer_1, "##,##0.00") %>
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(((sum_vencido_1 * 100)/(sum_vencido_1 + sum_vencer_1)),"##,##0.00") %>
                            </b>
                          </td>

                        </tr>

                        <%
                        sum_vencido_1 = 0;
                        sum_vencer_1 = 0;
                        sum_percentual_1 = 0;
                      }
                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                        %>

                        <tr class="totalColumn">
                          <td>

                          </td>
                          <td align="right">
                             
                            <b>
                              Total Regional : 
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_vencido_2, "##,##0.00") %>
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_vencer_2, "##,##0.00") %>
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(((sum_vencido_2 * 100)/(sum_vencido_2 + sum_vencer_2)),"##,##0.00") %>
                            </b>
                          </td>
                        </tr>

                        <%
                        sum_vencido_2 = 0;
                        sum_vencer_2 = 0;
                        sum_percentual_2 = 0;
                      }
                    }
                    %>

                    <tr class="totalColumn">
                      <td>

                      </td>
                      <td align="right">
                        <b>
                          Total Geral :
                        </b>
                         
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(sum_vencido_0, "##,##0.00") %>
                        </b>
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(sum_vencer_0, "##,##0.00") %>
                        </b>
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(((sum_vencido_0 * 100)/(sum_vencido_0 + sum_vencer_0)),"##,##0.00") %>
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

            <html:form action="adm/PendenciasRegionais_rcForm.do" method="post" styleClass="baseForm">
              <table class="buttonTable" style='width:;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Acompanhamento Diário de Vendas
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
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(31)){
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
              util.consultas.com.AcompanhamentoDiarioVendas acompanhamentoDiarioVendas = new util.consultas.com.AcompanhamentoDiarioVendas();
              acesso.Sessao sessao = new acesso.Sessao(session);
              java.util.Vector res_Jw_acompanhamento_diario_vendas = (java.util.Vector)session.getAttribute("res_Jw_acompanhamento_diario_vendas");
              java.util.Vector res_Jw_acompanhamento_diario_vendas_total_marcas = (java.util.Vector)session.getAttribute("res_Jw_acompanhamento_diario_vendas_total_marcas");
              java.util.Vector res_Jw_acompanhamento_diario_vendas_total_regionais = (java.util.Vector)session.getAttribute("res_Jw_acompanhamento_diario_vendas_total_regionais");
              java.util.Vector res_Jw_acompanhamento_diario_vendas_total_geral = (java.util.Vector)session.getAttribute("res_Jw_acompanhamento_diario_vendas_total_geral");
              %>

              <form  name="bl_report_Jw_acompanhamento_diario_vendas" id="bl_report_Jw_acompanhamento_diario_vendas" class="baseForm" method="post" >
                <%
                if (res_Jw_acompanhamento_diario_vendas!=null && res_Jw_acompanhamento_diario_vendas.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_acompanhamento_diario_vendas"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.String periodo =  null;
                    java.lang.String periodo_ano_anterior =  null;
                    java.lang.Integer codigo_regional =  null;
                    java.lang.String nome_regional =  null;
                    java.lang.Integer codigo_marca =  null;
                    java.lang.String descricao_marca =  null;
                    java.lang.String rep_cdgo =  null;
                    java.lang.String rep_rzao =  null;
                    java.lang.Integer pares_previsto_ano =  0;
                    java.lang.Integer pares_realizado_ano =  0;
                    java.lang.Integer pares_realizado_ant =  0;
                    java.lang.Double reais_previsto_ano =  0d;
                    java.lang.Double reais_realizado_ano =  0d;
                    java.lang.Double reais_realizado_ant =  0d;
                    java.lang.Integer cli_atend_ant =  0;
                    java.lang.Integer cli_atend_ano =  0;
                    java.lang.Integer dif_cli_atend =  0;

                    java.lang.Double dif_pares_ano = 0d;
                    java.lang.Double dif_reais_ano = 0d;
                    java.lang.Double dif_pares_realizado = 0d;
                    java.lang.Double dif_reais_realizado = 0d;
                    java.lang.Double dif_clientes_atendidos = 0d;

                    java.lang.Integer cli_atend_marca_ano =  0;
                    java.lang.Integer cli_atend_marca_ant =  0;
                    java.lang.Integer dif_cli_marca_atend =  0;

                    java.lang.Integer cli_atend_regional_ano =  0;
                    java.lang.Integer cli_atend_regional_ant =  0;
                    java.lang.Integer dif_cli_regional_atend =  0;

                    java.lang.Double valor_meta =  0d;
                    java.lang.Double valor_ano_ant =  0d;
                    String _b0_control = "__";
                    String _b1_control = "__";
                    String _b2_control = "__";
                    int sum_pares_previsto_ano_0 = 0;
                    int sum_pares_previsto_ano_1 = 0;
                    int sum_pares_previsto_ano_2 = 0;
                    int sum_pares_realizado_ano_0 = 0;
                    int sum_pares_realizado_ano_1 = 0;
                    int sum_pares_realizado_ano_2 = 0;
                    int sum_pares_realizado_ant_0 = 0;
                    int sum_pares_realizado_ant_1 = 0;
                    int sum_pares_realizado_ant_2 = 0;
                    double sum_reais_previsto_ano_0 = 0;
                    double sum_reais_previsto_ano_1 = 0;
                    double sum_reais_previsto_ano_2 = 0;
                    double sum_reais_realizado_ano_0 = 0;
                    double sum_reais_realizado_ano_1 = 0;
                    double sum_reais_realizado_ano_2 = 0;
                    double sum_reais_realizado_ant_0 = 0;
                    double sum_reais_realizado_ant_1 = 0;
                    double sum_reais_realizado_ant_2 = 0;
                    double sum_valor_meta_0 = 0;
                    double sum_valor_ano_anterior_0 = 0;
                    double sum_valor_meta_1 = 0;
                    double sum_valor_ano_anterior_1 = 0;
                    double sum_valor_meta_2 = 0;
                    double sum_valor_ano_anterior_2 = 0;
                    int i_bl_report_Jw_acompanhamento_diario_vendas = 0;
                    while (i_bl_report_Jw_acompanhamento_diario_vendas<res_Jw_acompanhamento_diario_vendas.size()) {
                      portalbr.dbobj.view.Jw_acompanhamento_diario_vendas t_jw_acompanhamento_diario_vendas = (portalbr.dbobj.view.Jw_acompanhamento_diario_vendas)res_Jw_acompanhamento_diario_vendas.elementAt(i_bl_report_Jw_acompanhamento_diario_vendas);
                      periodo = t_jw_acompanhamento_diario_vendas.getPeriodo();
                      periodo_ano_anterior = t_jw_acompanhamento_diario_vendas.getPeriodo_ano_anterior();
                      codigo_regional = t_jw_acompanhamento_diario_vendas.getCodigo_regional();
                      nome_regional = t_jw_acompanhamento_diario_vendas.getNome_regional()==null?"":t_jw_acompanhamento_diario_vendas.getNome_regional();
                      codigo_marca = t_jw_acompanhamento_diario_vendas.getCodigo_marca();
                      descricao_marca = t_jw_acompanhamento_diario_vendas.getDescricao_marca()==null?"":t_jw_acompanhamento_diario_vendas.getDescricao_marca();
                      rep_cdgo = t_jw_acompanhamento_diario_vendas.getRep_cdgo()==null?"":t_jw_acompanhamento_diario_vendas.getRep_cdgo();
                      rep_rzao = t_jw_acompanhamento_diario_vendas.getRep_rzao()==null?"":t_jw_acompanhamento_diario_vendas.getRep_rzao();
                      pares_previsto_ano = t_jw_acompanhamento_diario_vendas.getPares_previsto_ano();
                      pares_realizado_ano = t_jw_acompanhamento_diario_vendas.getPares_realizado_ano();
                      pares_realizado_ant = t_jw_acompanhamento_diario_vendas.getPares_realizado_ant();
                      reais_previsto_ano = t_jw_acompanhamento_diario_vendas.getReais_previsto_ano();
                      reais_realizado_ano = t_jw_acompanhamento_diario_vendas.getReais_realizado_ano();
                      reais_realizado_ant = t_jw_acompanhamento_diario_vendas.getReais_realizado_ant();

                      dif_pares_ano = t_jw_acompanhamento_diario_vendas.getDif_pares_ano();
                      dif_reais_ano = t_jw_acompanhamento_diario_vendas.getDif_reais_ano();
                      dif_pares_realizado = t_jw_acompanhamento_diario_vendas.getDif_pares_realizado();
                      dif_reais_realizado = t_jw_acompanhamento_diario_vendas.getDif_reais_realizado();
                      dif_clientes_atendidos = t_jw_acompanhamento_diario_vendas.getDif_clientes_atendidos();

                      cli_atend_ant = t_jw_acompanhamento_diario_vendas.getCli_atend_ant();
                      cli_atend_ano = t_jw_acompanhamento_diario_vendas.getCli_atend_ano();
                      dif_cli_atend = t_jw_acompanhamento_diario_vendas.getDif_cli_atend();
                      valor_meta = t_jw_acompanhamento_diario_vendas.getValor_meta();
                      valor_ano_ant = t_jw_acompanhamento_diario_vendas.getValor_ano_ant();
                      sum_pares_previsto_ano_0 += ((pares_previsto_ano!=null)?pares_previsto_ano.intValue():0);
                      sum_pares_previsto_ano_1 += ((pares_previsto_ano!=null)?pares_previsto_ano.intValue():0);
                      sum_pares_previsto_ano_2 += ((pares_previsto_ano!=null)?pares_previsto_ano.intValue():0);
                      sum_pares_realizado_ano_0 += ((pares_realizado_ano!=null)?pares_realizado_ano.intValue():0);
                      sum_pares_realizado_ano_1 += ((pares_realizado_ano!=null)?pares_realizado_ano.intValue():0);
                      sum_pares_realizado_ano_2 += ((pares_realizado_ano!=null)?pares_realizado_ano.intValue():0);
                      sum_pares_realizado_ant_0 += ((pares_realizado_ant!=null)?pares_realizado_ant.intValue():0);
                      sum_pares_realizado_ant_1 += ((pares_realizado_ant!=null)?pares_realizado_ant.intValue():0);
                      sum_pares_realizado_ant_2 += ((pares_realizado_ant!=null)?pares_realizado_ant.intValue():0);
                      sum_reais_previsto_ano_0 += ((reais_previsto_ano!=null)?reais_previsto_ano.doubleValue():0);
                      sum_reais_previsto_ano_1 += ((reais_previsto_ano!=null)?reais_previsto_ano.doubleValue():0);
                      sum_reais_previsto_ano_2 += ((reais_previsto_ano!=null)?reais_previsto_ano.doubleValue():0);
                      sum_reais_realizado_ano_0 += ((reais_realizado_ano!=null)?reais_realizado_ano.doubleValue():0);
                      sum_reais_realizado_ano_1 += ((reais_realizado_ano!=null)?reais_realizado_ano.doubleValue():0);
                      sum_reais_realizado_ano_2 += ((reais_realizado_ano!=null)?reais_realizado_ano.doubleValue():0);
                      sum_reais_realizado_ant_0 += ((reais_realizado_ant!=null)?reais_realizado_ant.doubleValue():0);
                      sum_reais_realizado_ant_1 += ((reais_realizado_ant!=null)?reais_realizado_ant.doubleValue():0);
                      sum_reais_realizado_ant_2 += ((reais_realizado_ant!=null)?reais_realizado_ant.doubleValue():0);


                      sum_valor_meta_0 += ((valor_meta!=null)?valor_meta.doubleValue():0);
                      sum_valor_ano_anterior_0 += ((valor_ano_ant!=null)?valor_ano_ant.doubleValue():0);
                      sum_valor_meta_1 += ((valor_meta!=null)?valor_meta.doubleValue():0);
                      sum_valor_ano_anterior_1 += ((valor_ano_ant!=null)?valor_ano_ant.doubleValue():0);
                      sum_valor_meta_2 += ((valor_meta!=null)?valor_meta.doubleValue():0);
                      sum_valor_ano_anterior_2 += ((valor_ano_ant!=null)?valor_ano_ant.doubleValue():0);


                      String _b0_value = periodo;
                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                        %>
                        <tr class="reportHeader3">
                          <td colspan="17">
                            <span class="columnTdHeader" style="text-align:center;" >
                              Período ano atual:
                              <%= periodo %>
                            </span>
                          </td>
                        </tr>
                        <tr class="reportHeader3">
                          <td colspan="17">
                            <span class="columnTdHeader" style="text-align:center;" >
                              Período ano anterior:
                              <%= periodo_ano_anterior %>
                            </span>
                          </td>
                        </tr>
                        <%
                      }
                      String _b1_value = periodo + "_" + com.egen.util.text.FormatNumber.format(codigo_regional);
                      if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                        %>
                        <tr class="reportHeader3">
                          <td colspan="17">
                            <span class="columnTdHeader" style="text-align:right;">
                              <%
                              int i_bl_report_Jw_acompanhamento_diario_vendas_total_regionais = 0;
                              while (i_bl_report_Jw_acompanhamento_diario_vendas_total_regionais <res_Jw_acompanhamento_diario_vendas_total_regionais.size()) {
                                portalbr.dbobj.view.Jw_acompanhamento_diario_vendas_total_regionais t_jw_acompanhamento_diario_vendas_total_regionais = (portalbr.dbobj.view.Jw_acompanhamento_diario_vendas_total_regionais)res_Jw_acompanhamento_diario_vendas_total_regionais.elementAt(i_bl_report_Jw_acompanhamento_diario_vendas_total_regionais);
                                if(codigo_regional.intValue() == t_jw_acompanhamento_diario_vendas_total_regionais.getCodigo_regional().intValue()){
                                  cli_atend_regional_ano = t_jw_acompanhamento_diario_vendas_total_regionais.getCli_atend_regional_ano();
                                  cli_atend_regional_ant = t_jw_acompanhamento_diario_vendas_total_regionais.getCli_atend_regional_ant();
                                  dif_cli_regional_atend = cli_atend_regional_ano  - cli_atend_regional_ant;
                                }
                                i_bl_report_Jw_acompanhamento_diario_vendas_total_regionais++;
                              }
                              %>
                              Regional:
                              <%= ((codigo_regional!=null)?codigo_regional.toString():"") %>
                              -
                              <%= nome_regional %>
                            </span>
                          </td>
                        </tr>
                        <%
                      }
                      String _b2_value = periodo + "_" + com.egen.util.text.FormatNumber.format(codigo_regional) + "_" + com.egen.util.text.FormatNumber.format(codigo_marca);
                      if (_b2_control != null && !_b2_control.equals(_b2_value)) {
                        %>
                        <tr class="reportHeader2">
                          <td colspan="17">
                            <span class="columnTdHeader" style="color: black; text-align:right;" >
                              <%
                              int i_bl_report_Jw_acompanhamento_diario_vendas_total_marcas = 0;
                              while (i_bl_report_Jw_acompanhamento_diario_vendas_total_marcas <res_Jw_acompanhamento_diario_vendas_total_marcas.size()) {
                                portalbr.dbobj.view.Jw_acompanhamento_diario_vendas_total_marcas t_jw_acompanhamento_diario_vendas_total_marcas = (portalbr.dbobj.view.Jw_acompanhamento_diario_vendas_total_marcas)res_Jw_acompanhamento_diario_vendas_total_marcas.elementAt(i_bl_report_Jw_acompanhamento_diario_vendas_total_marcas);
                                if(codigo_marca.intValue() == t_jw_acompanhamento_diario_vendas_total_marcas.getCodigo_marca().intValue()){
                                  cli_atend_marca_ano = t_jw_acompanhamento_diario_vendas_total_marcas.getCli_atend_marca_ano();
                                  cli_atend_marca_ant = t_jw_acompanhamento_diario_vendas_total_marcas.getCli_atend_marca_ant();
                                  dif_cli_marca_atend = cli_atend_marca_ano  - cli_atend_marca_ant;
                                }
                                i_bl_report_Jw_acompanhamento_diario_vendas_total_marcas++;
                              }
                              %>
                              Marca:
                              <%= ((codigo_marca!=null)?codigo_marca.toString():"") %>
                              -
                              <%= descricao_marca %>
                            </span>
                          </td>
                        </tr>
                        <%
                        %>


                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:left;" >
                          </td>
                          <td class="columnTdHeader" style="text-align: center;" colspan="3" >
                            Pares
                          </td>
                          <td class="columnTdHeader" style="text-align: center;" colspan="3" >
                            Reais
                          </td>
                          <td class="columnTdHeader" style="text-align: center;" colspan="4" >
                            Realizado Ano Anterior
                          </td>
                          <td class="columnTdHeader" style="text-align: center;" colspan="4" >
                            Clientes Atendidos
                          </td>
                          <td class="columnTdHeader" style="text-align: center;" colspan="2" >
                            Faltam
                          </td>
                        </tr>





                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:left;" >
                            Representante
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Previsto
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Realizado
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            %
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Previsto
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Realizado
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            %
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Pares
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            %
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Reais
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            %
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Ano Anterior
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Ano Atual
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Dif.
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            %
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            R$ Meta
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            R$ Ano Ant.
                          </td>




                        </tr>

                        <%
                      }
                      String style_bl_report_Jw_acompanhamento_diario_vendas="";
                      if (!((i_bl_report_Jw_acompanhamento_diario_vendas%2)!=0)) {
                        style_bl_report_Jw_acompanhamento_diario_vendas="rowColor";
                      } else {
                        style_bl_report_Jw_acompanhamento_diario_vendas="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_acompanhamento_diario_vendas %>' id="TRbl_report_Jw_acompanhamento_diario_vendas<%=i_bl_report_Jw_acompanhamento_diario_vendas%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= rep_cdgo %>
                          -
                          <%= rep_rzao %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(pares_previsto_ano, "#,##0.##") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(pares_realizado_ano, "#,##0.##") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(dif_pares_ano, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(reais_previsto_ano, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(reais_realizado_ano, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(dif_reais_ano, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(pares_realizado_ant, "#,##0.##") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(dif_pares_realizado, "##,##0.00") %>
                        </td>


                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(reais_realizado_ant, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(dif_reais_realizado, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((cli_atend_ant!=null)?cli_atend_ant.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((cli_atend_ano!=null)?cli_atend_ano.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((dif_cli_atend!=null)?dif_cli_atend.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(dif_clientes_atendidos, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(valor_meta, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(valor_ano_ant, "##,##0.00") %>
                        </td>




                      </tr>

                      <%
                      _b0_control = _b0_value;
                      _b1_control = _b1_value;
                      _b2_control = _b2_value;
                      i_bl_report_Jw_acompanhamento_diario_vendas++;
                      if (i_bl_report_Jw_acompanhamento_diario_vendas<res_Jw_acompanhamento_diario_vendas.size()) {
                        t_jw_acompanhamento_diario_vendas = (portalbr.dbobj.view.Jw_acompanhamento_diario_vendas)res_Jw_acompanhamento_diario_vendas.elementAt(i_bl_report_Jw_acompanhamento_diario_vendas);
                        periodo = t_jw_acompanhamento_diario_vendas.getPeriodo();
                        periodo_ano_anterior = t_jw_acompanhamento_diario_vendas.getPeriodo_ano_anterior();
                        codigo_regional = t_jw_acompanhamento_diario_vendas.getCodigo_regional();
                        nome_regional = t_jw_acompanhamento_diario_vendas.getNome_regional()==null?"":t_jw_acompanhamento_diario_vendas.getNome_regional();
                        codigo_marca = t_jw_acompanhamento_diario_vendas.getCodigo_marca();
                        descricao_marca = t_jw_acompanhamento_diario_vendas.getDescricao_marca()==null?"":t_jw_acompanhamento_diario_vendas.getDescricao_marca();
                        rep_cdgo = t_jw_acompanhamento_diario_vendas.getRep_cdgo()==null?"":t_jw_acompanhamento_diario_vendas.getRep_cdgo();
                        rep_rzao = t_jw_acompanhamento_diario_vendas.getRep_rzao()==null?"":t_jw_acompanhamento_diario_vendas.getRep_rzao();
                        pares_previsto_ano = t_jw_acompanhamento_diario_vendas.getPares_previsto_ano();
                        pares_realizado_ano = t_jw_acompanhamento_diario_vendas.getPares_realizado_ano();
                        pares_realizado_ant = t_jw_acompanhamento_diario_vendas.getPares_realizado_ant();
                        reais_previsto_ano = t_jw_acompanhamento_diario_vendas.getReais_previsto_ano();
                        reais_realizado_ano = t_jw_acompanhamento_diario_vendas.getReais_realizado_ano();
                        reais_realizado_ant = t_jw_acompanhamento_diario_vendas.getReais_realizado_ant();
                        cli_atend_ant = t_jw_acompanhamento_diario_vendas.getCli_atend_ant();
                        cli_atend_ano = t_jw_acompanhamento_diario_vendas.getCli_atend_ano();
                        dif_cli_atend = t_jw_acompanhamento_diario_vendas.getDif_cli_atend();
                        dif_pares_ano = t_jw_acompanhamento_diario_vendas.getDif_pares_ano();
                        dif_reais_ano = t_jw_acompanhamento_diario_vendas.getDif_reais_ano();
                        dif_clientes_atendidos = t_jw_acompanhamento_diario_vendas.getDif_clientes_atendidos();
                        dif_pares_realizado = t_jw_acompanhamento_diario_vendas.getDif_pares_realizado();
                        dif_reais_realizado = t_jw_acompanhamento_diario_vendas.getDif_reais_realizado();
                        valor_meta = t_jw_acompanhamento_diario_vendas.getValor_meta();
                        valor_ano_ant = t_jw_acompanhamento_diario_vendas.getValor_ano_ant();
                        _b0_value = periodo;
                        _b1_value = periodo + "_" + com.egen.util.text.FormatNumber.format(codigo_regional);
                        _b2_value = periodo + "_" + com.egen.util.text.FormatNumber.format(codigo_regional) + "_" + com.egen.util.text.FormatNumber.format(codigo_marca);
                      } else {
                        _b0_control = "__";
                        _b1_control = "__";
                        _b2_control = "__";
                      }
                      if (_b2_control != null && !_b2_control.equals(_b2_value)) {
                        %>

                        <tr class="totalColumn">
                          <td>
                             
                            <b>
                              Total Marca:
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_pares_previsto_ano_1, "#,##0.##") %>
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_pares_realizado_ano_1, "#,##0.##") %>
                            </b>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <b>
                              <%= acompanhamentoDiarioVendas.diferencaParesAno(sum_pares_previsto_ano_1,sum_pares_realizado_ano_1) %>
                            </b>
                          </td>

                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_reais_previsto_ano_1, "##,##0.00") %>
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_reais_realizado_ano_1, "##,##0.00") %>
                            </b>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <b>
                              <%= acompanhamentoDiarioVendas.diferencaReaisAno(sum_reais_previsto_ano_1,sum_reais_realizado_ano_1) %>
                            </b>
                          </td>

                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_pares_realizado_ant_1, "#,##0.##") %>
                            </b>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <b>
                              <%= acompanhamentoDiarioVendas.diferencaAnoAtualAnterior(sum_pares_realizado_ano_1,sum_pares_realizado_ant_1) %>
                            </b>
                          </td>

                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_reais_realizado_ant_1, "##,##0.00") %>
                            </b>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <b>
                              <%= acompanhamentoDiarioVendas.diferencaAnoAtualAnterior(sum_reais_realizado_ano_1,sum_reais_realizado_ant_1) %>
                            </b>
                          </td>

                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(cli_atend_marca_ant , "#,##0.##") %>
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(cli_atend_marca_ano , "#,##0.##") %>
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(dif_cli_marca_atend , "#,##0.##") %>
                            </b>
                          </td>
                          <td class="reportColumn" style="text-align:right;" >
                            <b>
                              <%= acompanhamentoDiarioVendas.diferencaAnoAtualAnterior(cli_atend_marca_ano,cli_atend_marca_ant) %>
                            </b>
                          </td>

                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_reais_previsto_ano_1 - sum_reais_realizado_ano_1, "##,##0.00") %>
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_reais_realizado_ano_1 - sum_reais_realizado_ant_1, "##,##0.00") %>
                            </b>
                          </td>
                        </tr>

                        <%
                        sum_pares_previsto_ano_1 = 0;
                        sum_pares_realizado_ano_1 = 0;
                        sum_pares_realizado_ant_1 = 0;
                        sum_reais_previsto_ano_1 = 0;
                        sum_reais_realizado_ano_1 = 0;
                        sum_reais_realizado_ant_1 = 0;
                        sum_valor_meta_1 = 0;
                        sum_valor_ano_anterior_1 = 0;
                      }
                      if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                        %>
                        <%
                        if(!(sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")||
                        sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL"))){
                          %>


                          <tr class="totalColumn">
                            <td>
                               
                              <b>
                                Total Regional:
                              </b>
                            </td>
                            <td class="totalTdColumn"  style="text-align:right;" >
                              <b>
                                <%= com.egen.util.text.FormatNumber.format(sum_pares_previsto_ano_2, "#,##0.##") %>
                              </b>
                            </td>
                            <td class="totalTdColumn"  style="text-align:right;" >
                              <b>
                                <%= com.egen.util.text.FormatNumber.format(sum_pares_realizado_ano_2, "#,##0.##") %>
                              </b>
                            </td>
                            <td class="reportColumn" style="text-align:right;" >
                              <b>
                                <%= acompanhamentoDiarioVendas.diferencaParesAno(sum_pares_previsto_ano_2,sum_pares_realizado_ano_2) %>
                              </b>
                            </td>
                            <td class="totalTdColumn"  style="text-align:right;" >
                              <b>
                                <%= com.egen.util.text.FormatNumber.format(sum_reais_previsto_ano_2, "##,##0.00") %>
                              </b>
                            </td>
                            <td class="totalTdColumn"  style="text-align:right;" >
                              <b>
                                <%= com.egen.util.text.FormatNumber.format(sum_reais_realizado_ano_2, "##,##0.00") %>
                              </b>
                            </td>
                            <td class="reportColumn" style="text-align:right;" >
                              <b>
                                <%= acompanhamentoDiarioVendas.diferencaReaisAno(sum_reais_previsto_ano_2,sum_reais_realizado_ano_2) %>
                              </b>
                            </td>
                            <td class="totalTdColumn"  style="text-align:right;" >
                              <b>
                                <%= com.egen.util.text.FormatNumber.format(sum_pares_realizado_ant_2, "#,##0.##") %>
                              </b>
                            </td>
                            <td class="reportColumn" style="text-align:right;" >
                              <b>
                                <%= acompanhamentoDiarioVendas.diferencaAnoAtualAnterior(sum_pares_realizado_ano_2,sum_pares_realizado_ant_2) %>
                              </b>
                            </td>
                            <td class="totalTdColumn"  style="text-align:right;" >
                              <b>
                                <%= com.egen.util.text.FormatNumber.format(sum_reais_realizado_ant_2, "##,##0.00") %>
                              </b>
                            </td>
                            <td class="reportColumn" style="text-align:right;" >
                              <b>
                                <%= acompanhamentoDiarioVendas.diferencaAnoAtualAnterior(sum_reais_realizado_ano_2,sum_reais_realizado_ant_2) %>
                              </b>
                            </td>
                            <td class="totalTdColumn"  style="text-align:right;" >

                              <%
                              {
                                /*
                                int i_bl_report_Jw_acompanhamento_diario_vendas_total_regionais = 0;
                                while (i_bl_report_Jw_acompanhamento_diario_vendas_total_regionais <res_Jw_acompanhamento_diario_vendas_total_regionais.size()) {
                                  portalbr.dbobj.view.Jw_acompanhamento_diario_vendas_total_regionais t_jw_acompanhamento_diario_vendas_total_regionais = (portalbr.dbobj.view.Jw_acompanhamento_diario_vendas_total_regionais)res_Jw_acompanhamento_diario_vendas_total_regionais.elementAt(i_bl_report_Jw_acompanhamento_diario_vendas_total_regionais);
                                  if(codigo_regional.intValue() == t_jw_acompanhamento_diario_vendas_total_regionais.getCodigo_regional().intValue()){
                                    cli_atend_regional_ano = t_jw_acompanhamento_diario_vendas_total_regionais.getCli_atend_regional_ano();
                                    cli_atend_regional_ant = t_jw_acompanhamento_diario_vendas_total_regionais.getCli_atend_regional_ant();
                                    dif_cli_regional_atend = cli_atend_regional_ano  - cli_atend_regional_ant;
                                  }
                                  i_bl_report_Jw_acompanhamento_diario_vendas_total_regionais++;
                                }
                                */
                              }
                              %>


                              <b>
                                <%= com.egen.util.text.FormatNumber.format(cli_atend_regional_ant , "#,##0.##") %>
                              </b>
                            </td>
                            <td class="totalTdColumn"  style="text-align:right;" >
                              <b>
                                <%= com.egen.util.text.FormatNumber.format(cli_atend_regional_ano , "#,##0.##") %>
                              </b>
                            </td>
                            <td class="totalTdColumn"  style="text-align:right;" >
                              <b>
                                <%= com.egen.util.text.FormatNumber.format(dif_cli_regional_atend , "#,##0.##") %>
                              </b>
                            </td>
                            <td class="reportColumn" style="text-align:right;" >
                              <b>
                                <%= acompanhamentoDiarioVendas.diferencaAnoAtualAnterior(cli_atend_regional_ano,cli_atend_regional_ant) %>
                              </b>
                            </td>

                            <td class="totalTdColumn"  style="text-align:right;" >
                              <b>
                                <%= com.egen.util.text.FormatNumber.format(sum_reais_previsto_ano_2 - sum_reais_realizado_ano_2 , "##,##0.00") %>
                              </b>
                            </td>
                            <td class="totalTdColumn"  style="text-align:right;" >
                              <b>
                                <%= com.egen.util.text.FormatNumber.format(sum_reais_realizado_ano_2 - sum_reais_realizado_ant_2, "##,##0.00") %>
                              </b>
                            </td>
                          </tr>

                          <%
                        }
                        %>


                        <%
                        sum_pares_previsto_ano_2 = 0;
                        sum_pares_realizado_ano_2 = 0;
                        sum_pares_realizado_ant_2 = 0;
                        sum_reais_previsto_ano_2 = 0;
                        sum_reais_realizado_ano_2 = 0;
                        sum_reais_realizado_ant_2 = 0;
                        sum_valor_meta_2 = 0;
                        sum_valor_ano_anterior_2 = 0;
                      }
                    }

                    portalbr.dbobj.view.Jw_acompanhamento_diario_vendas_total_regionais t_jw_acompanhamento_diario_vendas_total_geral = (portalbr.dbobj.view.Jw_acompanhamento_diario_vendas_total_regionais)res_Jw_acompanhamento_diario_vendas_total_geral.elementAt(0);
                    %>

                    <tr class="totalColumn">
                      <td>
                         
                        <b>
                          Total Geral:
                        </b>
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(sum_pares_previsto_ano_0, "#,##0.##") %>
                        </b>
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(sum_pares_realizado_ano_0, "#,##0.##") %>
                        </b>
                      </td>
                      <td class="reportColumn" style="text-align:right;" >
                        <b>
                          <%= acompanhamentoDiarioVendas.diferencaParesAno(sum_pares_previsto_ano_0,sum_pares_realizado_ano_0) %>
                        </b>
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(sum_reais_previsto_ano_0, "##,##0.00") %>
                        </b>
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(sum_reais_realizado_ano_0, "##,##0.00") %>
                        </b>
                      </td>
                      <td class="reportColumn" style="text-align:right;" >
                        <b>
                          <%= acompanhamentoDiarioVendas.diferencaReaisAno(sum_reais_previsto_ano_0,sum_reais_realizado_ano_0) %>
                        </b>
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(sum_pares_realizado_ant_0, "#,##0.##") %>
                        </b>
                      </td>
                      <td class="reportColumn" style="text-align:right;" >
                        <b>
                          <%= acompanhamentoDiarioVendas.diferencaAnoAtualAnterior(sum_pares_realizado_ano_0,sum_pares_realizado_ant_0) %>
                        </b>
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(sum_reais_realizado_ant_0, "##,##0.00") %>
                        </b>
                      </td>
                      <td class="reportColumn" style="text-align:right;" >
                        <b>
                          <%= acompanhamentoDiarioVendas.diferencaAnoAtualAnterior(sum_reais_realizado_ano_0,sum_reais_realizado_ant_0) %>
                        </b>
                      </td>
                      <td class="reportColumn" style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(t_jw_acompanhamento_diario_vendas_total_geral.getCli_atend_regional_ant(), "#,##0.##") %>
                        </b>
                      </td>
                      <td class="reportColumn" style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(t_jw_acompanhamento_diario_vendas_total_geral.getCli_atend_regional_ano(), "#,##0.##") %>
                        </b>
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(t_jw_acompanhamento_diario_vendas_total_geral.getCli_atend_regional_ano()-t_jw_acompanhamento_diario_vendas_total_geral.getCli_atend_regional_ant(), "#,##0.##") %>
                        </b>
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          <%= acompanhamentoDiarioVendas.diferencaAnoAtualAnterior(t_jw_acompanhamento_diario_vendas_total_geral.getCli_atend_regional_ano(),t_jw_acompanhamento_diario_vendas_total_geral.getCli_atend_regional_ant()) %>
                        </b>
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(sum_reais_previsto_ano_0 - sum_reais_realizado_ano_0 , "##,##0.00") %>
                        </b>
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(sum_reais_realizado_ano_0 - sum_reais_realizado_ant_0, "##,##0.00") %>
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
            <html:form action="com/AcompanhamentoDiarioVendas_rForm.do" method="post" styleClass="baseForm">
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

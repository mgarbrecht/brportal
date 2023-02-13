<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      <%= (String)session.getAttribute("PoiAbertoRepEntradaPedidos_tipo") %>
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
              java.util.Vector res_Jw_poi_aberto_rep_entrada_pedidos = (java.util.Vector)session.getAttribute("res_Jw_poi_aberto_rep_entrada_pedidos");
              util.consultas.com.PoiAbertoRepresentanteEntradaPedidos poiAbertoRepresentanteEntradaPedidos = new util.consultas.com.PoiAbertoRepresentanteEntradaPedidos();
              %>

              <form  name="bl_report_Jw_poi_aberto_rep_entrada_pedidos" id="bl_report_Jw_poi_aberto_rep_entrada_pedidos" class="baseForm" method="post" >
                <%
                if (res_Jw_poi_aberto_rep_entrada_pedidos!=null && res_Jw_poi_aberto_rep_entrada_pedidos.size()>0) {
                  %>

                  <%
                  int codigo_regional1 =  0;
                  java.lang.String nome_regional1 =  null;
                  int codigo_gerente1 =  0;
                  java.lang.String nome_gerente1 =  null;
                  java.lang.String endereco1 =  null;
                  java.lang.String estado_gerente1 =  null;
                  int codigo_marca =  0;
                  java.lang.String descricao_marca =  null;
                  java.lang.String codigo_representante =  null;
                  java.lang.String rep_rzao =  null;
                  double preco_previsto =  0;
                  double preco_realizado =  0;
                  double dif_preco =  0;
                  double reais_previsto =  0;
                  double reais_realizado =  0;
                  double dif_reais =  0;
                  double reais_faturado =  0;
                  double reais_a_faturar =  0;
                  int pares_previsto =  0;
                  int pares_realizado =  0;
                  double dif_pares =  0;
                  int pares_faturado =  0;
                  int pares_a_faturar =  0;
                  String _b0_control = "__";
                  String _b1_control = "__";
                  int sum_pares_previsto_0 = 0;
                  double sum_reais_previsto_0 = 0;
                  double sum_reais_realizado_0 = 0;
                  double sum_reais_faturado_0 = 0;
                  double sum_reais_a_faturar_0 = 0;
                  int sum_pares_realizado_0 = 0;
                  int sum_pares_faturado_0 = 0;
                  int sum_pares_a_faturar_0 = 0;
                  int sum_pares_previsto_1 = 0;
                  double sum_reais_previsto_1 = 0;
                  double sum_reais_realizado_1 = 0;
                  double sum_reais_faturado_1 = 0;
                  double sum_reais_a_faturar_1 = 0;
                  int sum_pares_realizado_1 = 0;
                  int sum_pares_faturado_1 = 0;
                  int sum_pares_a_faturar_1 = 0;
                  int sum_pares_previsto_2 = 0;
                  double sum_reais_previsto_2 = 0;
                  double sum_reais_realizado_2 = 0;
                  double sum_reais_faturado_2 = 0;
                  double sum_reais_a_faturar_2 = 0;
                  int sum_pares_realizado_2 = 0;
                  int sum_pares_faturado_2 = 0;
                  int sum_pares_a_faturar_2 = 0;

                  double pm_previsto_0 = 0;
                  double pm_realizado_0 = 0;
                  double pm_dif_0 = 0;
                  double perc_reais_0 = 0;
                  double perc_pares_0 = 0;
                  double pm_dif_pos_0 = 0;
                  double perc_pos_reais_0 = 0;
                  double perc_pos_pares_0 = 0;

                  double pm_previsto_1 = 0;
                  double pm_realizado_1 = 0;
                  double pm_dif_1 = 0;
                  double perc_reais_1 = 0;
                  double perc_pares_1 = 0;
                  double pm_dif_pos_1 = 0;
                  double perc_pos_reais_1 = 0;
                  double perc_pos_pares_1 = 0;

                  double pm_previsto_2 = 0;
                  double pm_realizado_2 = 0;
                  double pm_dif_2 = 0;
                  double perc_reais_2 = 0;
                  double perc_pares_2 = 0;
                  double pm_dif_pos_2 = 0;
                  double perc_pos_reais_2 = 0;
                  double perc_pos_pares_2 = 0;

                  int i_bl_report_Jw_poi_aberto_rep_entrada_pedidos = 0;
                  while (i_bl_report_Jw_poi_aberto_rep_entrada_pedidos<res_Jw_poi_aberto_rep_entrada_pedidos.size()) {
                    portalbr.dbobj.view.Jw_poi_aberto_rep_entrada_pedidos t_jw_poi_aberto_rep_entrada_pedidos = (portalbr.dbobj.view.Jw_poi_aberto_rep_entrada_pedidos)res_Jw_poi_aberto_rep_entrada_pedidos.elementAt(i_bl_report_Jw_poi_aberto_rep_entrada_pedidos);
                    codigo_regional1 = t_jw_poi_aberto_rep_entrada_pedidos.getCodigo_regional();
                    nome_regional1 = t_jw_poi_aberto_rep_entrada_pedidos.getNome_regional()==null?"":t_jw_poi_aberto_rep_entrada_pedidos.getNome_regional();
                    codigo_gerente1 = t_jw_poi_aberto_rep_entrada_pedidos.getCodigo_gerente();
                    nome_gerente1 = t_jw_poi_aberto_rep_entrada_pedidos.getNome_gerente()==null?"":t_jw_poi_aberto_rep_entrada_pedidos.getNome_gerente();
                    endereco1 = t_jw_poi_aberto_rep_entrada_pedidos.getEndereco()==null?"":t_jw_poi_aberto_rep_entrada_pedidos.getEndereco();
                    estado_gerente1 = t_jw_poi_aberto_rep_entrada_pedidos.getEstado_gerente()==null?"":t_jw_poi_aberto_rep_entrada_pedidos.getEstado_gerente();
                    codigo_marca = t_jw_poi_aberto_rep_entrada_pedidos.getCodigo_marca();
                    descricao_marca = t_jw_poi_aberto_rep_entrada_pedidos.getDescricao_marca()==null?"":t_jw_poi_aberto_rep_entrada_pedidos.getDescricao_marca();
                    codigo_representante = t_jw_poi_aberto_rep_entrada_pedidos.getCodigo_representante()==null?"":t_jw_poi_aberto_rep_entrada_pedidos.getCodigo_representante();
                    rep_rzao = t_jw_poi_aberto_rep_entrada_pedidos.getRep_rzao()==null?"":t_jw_poi_aberto_rep_entrada_pedidos.getRep_rzao();
                    preco_previsto = t_jw_poi_aberto_rep_entrada_pedidos.getPreco_previsto();
                    preco_realizado = t_jw_poi_aberto_rep_entrada_pedidos.getPreco_realizado();
                    dif_preco = t_jw_poi_aberto_rep_entrada_pedidos.getDif_preco();
                    reais_previsto = t_jw_poi_aberto_rep_entrada_pedidos.getReais_previsto();
                    reais_realizado = t_jw_poi_aberto_rep_entrada_pedidos.getReais_realizado();
                    dif_reais = t_jw_poi_aberto_rep_entrada_pedidos.getDif_reais();
                    reais_faturado = t_jw_poi_aberto_rep_entrada_pedidos.getReais_faturado();
                    reais_a_faturar = t_jw_poi_aberto_rep_entrada_pedidos.getReais_a_faturar();
                    pares_previsto = t_jw_poi_aberto_rep_entrada_pedidos.getPares_previsto();
                    pares_realizado = t_jw_poi_aberto_rep_entrada_pedidos.getPares_realizado();
                    dif_pares = t_jw_poi_aberto_rep_entrada_pedidos.getDif_pares();
                    pares_faturado = t_jw_poi_aberto_rep_entrada_pedidos.getPares_faturado();
                    pares_a_faturar = t_jw_poi_aberto_rep_entrada_pedidos.getPares_a_faturar();
                    sum_pares_previsto_0 += pares_previsto;
                    sum_reais_previsto_0 += reais_previsto;
                    sum_reais_realizado_0 += reais_realizado;
                    sum_reais_faturado_0 += reais_faturado;
                    sum_reais_a_faturar_0 += reais_a_faturar;
                    sum_pares_realizado_0 += pares_realizado;
                    sum_pares_faturado_0 += pares_faturado;
                    sum_pares_a_faturar_0 += pares_a_faturar;
                    sum_pares_previsto_1 += pares_previsto;
                    sum_reais_previsto_1 += reais_previsto;
                    sum_reais_realizado_1 += reais_realizado;
                    sum_reais_faturado_1 += reais_faturado;
                    sum_reais_a_faturar_1 += reais_a_faturar;
                    sum_pares_realizado_1 += pares_realizado;
                    sum_pares_faturado_1 += pares_faturado;
                    sum_pares_a_faturar_1 += pares_a_faturar;
                    sum_pares_previsto_2 += pares_previsto;
                    sum_reais_previsto_2 += reais_previsto;
                    sum_reais_realizado_2 += reais_realizado;
                    sum_reais_faturado_2 += reais_faturado;
                    sum_reais_a_faturar_2 += reais_a_faturar;
                    sum_pares_realizado_2 += pares_realizado;
                    sum_pares_faturado_2 += pares_faturado;
                    sum_pares_a_faturar_2 += pares_a_faturar;
                    String _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional1);
                    String _b1_value = com.egen.util.text.FormatNumber.format(codigo_regional1) + "_" + com.egen.util.text.FormatNumber.format(codigo_marca);
                    if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                      %>

                      <table id="TRbl_report_Jw_poi_aberto_rep_entrada_pedidos"  class="reportTable"   style="width:99%; " border=1;  frame=box >
                        <tr class="reportHeader3">
                          <td colspan="4" align="rigth">
                            Regional :
                            <%= codigo_regional1 %>
                            -
                            <%= nome_regional1 %>
                          </td>
                        </tr>
                        <tr class="reportHeader3">
                          <td colspan=4>
                            Período : de
                            <%= (String)session.getAttribute("PoiAbertoRepEntradaPedidos_mes") %>
                            /
                            <%= (String)session.getAttribute("PoiAbertoRepEntradaPedidos_ano") %>
                            a
                            <%= (String)session.getAttribute("PoiAbertoRepEntradaPedidos_mes_final") %>
                            /
                            <%= (String)session.getAttribute("PoiAbertoRepEntradaPedidos_ano_final") %>
                          </td>
                        </tr>
                      </table>

                      <%
                      if(((String)session.getAttribute("PoiAbertoRepEntradaPedidos_rep")=="N")){
                        %>
                        <table id="TRbl_report_Jw_poi_aberto_rep_entrada_pedidos"  class="reportTable"   style="width:99%; " border=1;  frame=box >
                          <tr class="reportHeader2">
                            <td colspan="15">
                              <font color="black">
                                <big>
                                  Resumo Marcas
                                </big>
                              </font>
                            </td>
                          </tr>
                          <%
                          %>
                          <tr class="reportTr">
                            <td class="columnTdHeader" style="text-align:left;" >
                            </td>
                            <td class="columnTdHeader" style="text-align:center;" colspan="4">
                              Pares
                            </td>
                            <td class="columnTdHeader" style="text-align:center;" colspan="4">
                              Reais
                            </td>
                            <td class="columnTdHeader" style="text-align:center;" colspan="4" >
                              Preço Médio
                            </td>
                          </tr>
                          <tr class="reportTr">
                            <td class="columnTdHeader" style="text-align:left;" >
                              Marca
                            </td>

                            <td class="columnTdHeader" style="text-align:right;" colspan="1">
                              Previsto
                            </td>

                            <td class="columnTdHeader" style="text-align:right;" colspan="1">
                              Realizado
                            </td>

                            <td class="columnTdHeader" style="text-align:right;" colspan="2">
                              %
                            </td>

                            <td class="columnTdHeader" style="text-align:right;" colspan="1">
                              Previsto
                            </td>

                            <td class="columnTdHeader" style="text-align:right;" colspan="1">
                              Realizado
                            </td>

                            <td class="columnTdHeader" style="text-align:right;" colspan="2">
                              %
                            </td>

                            <td class="columnTdHeader" style="text-align:right;" colspan="1">
                              Previsto
                            </td>

                            <td class="columnTdHeader" style="text-align:right;" colspan="1">
                              Realizado
                            </td>

                            <td class="columnTdHeader" style="text-align:right;" colspan="2">
                              %
                            </td>

                          </tr>

                          <%
                        } else {
                          %>
                          <table id="TRbl_report_Jw_poi_aberto_rep_entrada_pedidos"  class="reportTable"   style="width:99%; " border=1;  frame=box >
                            <tr class="reportHeader2">
                              <td colspan="15">
                                <font color="black">
                                  <big>
                                    Resumo Marcas
                                  </big>
                                </font>
                              </td>
                            </tr>
                            <%
                            %>
                            <tr class="reportTr">
                              <td class="columnTdHeader" style="text-align:left;" >
                              </td>
                              <td class="columnTdHeader" style="text-align:center;" colspan="4">
                                Pares
                              </td>
                              <td class="columnTdHeader" style="text-align:center;" colspan="4">
                                Reais
                              </td>
                              <td class="columnTdHeader" style="text-align:center;" colspan="4" >
                                Preço Médio
                              </td>
                            </tr>
                            <tr class="reportTr">
                              <td class="columnTdHeader" style="text-align:left;" >
                                Marca
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" colspan="1">
                                Previsto
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" colspan="1">
                                Realizado
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" colspan="2">
                                %
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" colspan="1">
                                Previsto
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" colspan="1">
                                Realizado
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" colspan="2">
                                %
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" colspan="1">
                                Previsto
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" colspan="1">
                                Realizado
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" colspan="2">
                                %
                              </td>

                            </tr>


                            <%
                          }
                          %>




                          <%
                        }
                        %>


                        <%
                        String style_bl_report_Jw_poi_aberto_rep_entrada_pedidos="";
                        if (!((i_bl_report_Jw_poi_aberto_rep_entrada_pedidos%2)!=0)) {
                          style_bl_report_Jw_poi_aberto_rep_entrada_pedidos="rowColor";
                        } else {
                          style_bl_report_Jw_poi_aberto_rep_entrada_pedidos="rowBlank";
                        }
                        if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                          %>
                          <tr class='<%= style_bl_report_Jw_poi_aberto_rep_entrada_pedidos %>' id="TRbl_report_Jw_poi_aberto_rep_entrada_pedidos<%=i_bl_report_Jw_poi_aberto_rep_entrada_pedidos%>" >
                            <td class="totalTdColumn"  style="text-align:left;" >
                              <%= codigo_marca %>
                              -
                              <%= descricao_marca %>
                            </td>

                            <%
                          }
                          %>

                          <%
                          _b0_control = _b0_value;
                          _b1_control = _b1_value;
                          i_bl_report_Jw_poi_aberto_rep_entrada_pedidos++;
                          if (i_bl_report_Jw_poi_aberto_rep_entrada_pedidos<res_Jw_poi_aberto_rep_entrada_pedidos.size()) {
                            t_jw_poi_aberto_rep_entrada_pedidos = (portalbr.dbobj.view.Jw_poi_aberto_rep_entrada_pedidos)res_Jw_poi_aberto_rep_entrada_pedidos.elementAt(i_bl_report_Jw_poi_aberto_rep_entrada_pedidos);
                            codigo_regional1 = t_jw_poi_aberto_rep_entrada_pedidos.getCodigo_regional();
                            nome_regional1 = t_jw_poi_aberto_rep_entrada_pedidos.getNome_regional()==null?"":t_jw_poi_aberto_rep_entrada_pedidos.getNome_regional();
                            codigo_gerente1 = t_jw_poi_aberto_rep_entrada_pedidos.getCodigo_gerente();
                            nome_gerente1 = t_jw_poi_aberto_rep_entrada_pedidos.getNome_gerente()==null?"":t_jw_poi_aberto_rep_entrada_pedidos.getNome_gerente();
                            endereco1 = t_jw_poi_aberto_rep_entrada_pedidos.getEndereco()==null?"":t_jw_poi_aberto_rep_entrada_pedidos.getEndereco();
                            estado_gerente1 = t_jw_poi_aberto_rep_entrada_pedidos.getEstado_gerente()==null?"":t_jw_poi_aberto_rep_entrada_pedidos.getEstado_gerente();
                            codigo_marca = t_jw_poi_aberto_rep_entrada_pedidos.getCodigo_marca();
                            descricao_marca = t_jw_poi_aberto_rep_entrada_pedidos.getDescricao_marca()==null?"":t_jw_poi_aberto_rep_entrada_pedidos.getDescricao_marca();
                            codigo_representante = t_jw_poi_aberto_rep_entrada_pedidos.getCodigo_representante()==null?"":t_jw_poi_aberto_rep_entrada_pedidos.getCodigo_representante();
                            rep_rzao = t_jw_poi_aberto_rep_entrada_pedidos.getRep_rzao()==null?"":t_jw_poi_aberto_rep_entrada_pedidos.getRep_rzao();
                            preco_previsto = t_jw_poi_aberto_rep_entrada_pedidos.getPreco_previsto();
                            preco_realizado = t_jw_poi_aberto_rep_entrada_pedidos.getPreco_realizado();
                            dif_preco = t_jw_poi_aberto_rep_entrada_pedidos.getDif_preco();
                            reais_previsto = t_jw_poi_aberto_rep_entrada_pedidos.getReais_previsto();
                            reais_realizado = t_jw_poi_aberto_rep_entrada_pedidos.getReais_realizado();
                            dif_reais = t_jw_poi_aberto_rep_entrada_pedidos.getDif_reais();
                            reais_faturado = t_jw_poi_aberto_rep_entrada_pedidos.getReais_faturado();
                            reais_a_faturar = t_jw_poi_aberto_rep_entrada_pedidos.getReais_a_faturar();
                            pares_previsto = t_jw_poi_aberto_rep_entrada_pedidos.getPares_previsto();
                            pares_realizado = t_jw_poi_aberto_rep_entrada_pedidos.getPares_realizado();
                            dif_pares = t_jw_poi_aberto_rep_entrada_pedidos.getDif_pares();
                            pares_faturado = t_jw_poi_aberto_rep_entrada_pedidos.getPares_faturado();
                            pares_a_faturar = t_jw_poi_aberto_rep_entrada_pedidos.getPares_a_faturar();
                            _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional1);
                            _b1_value = com.egen.util.text.FormatNumber.format(codigo_regional1) + "_" + com.egen.util.text.FormatNumber.format(codigo_marca);
                          } else {
                            _b0_control = "__";
                            _b1_control = "__";
                          }
                          if (_b1_control != null && !_b1_control.equals(_b1_value)) {

                            pm_previsto_1 = sum_reais_previsto_1 / (sum_pares_previsto_1==0?1:sum_pares_previsto_1);
                            pm_realizado_1 = sum_reais_realizado_1 / (sum_pares_realizado_1==0?1:sum_pares_realizado_1);

                            pm_dif_1 =  ((pm_realizado_1 * 100.00) / (pm_previsto_1==0?1:pm_previsto_1)-100);
                          if(pm_realizado_1==0 && pm_previsto_1>0){pm_dif_1=-100;}
                        if(pm_realizado_1>0 && pm_previsto_1==0){pm_dif_1=0;}

                        perc_reais_1 = ((sum_reais_realizado_1 * 100) / (sum_reais_previsto_1==0?1:sum_reais_previsto_1)-100);
                      if(sum_reais_realizado_1==0 && sum_reais_previsto_1>0){perc_reais_1=-100;}
                    if(sum_reais_realizado_1>0 && sum_reais_previsto_1==0){perc_reais_1=0;}

                    perc_pares_1 = (( (double) sum_pares_realizado_1 * 100.00) / ((double) sum_pares_previsto_1==0?1:sum_pares_previsto_1)-100);
                  if(sum_pares_realizado_1==0 && sum_pares_previsto_1>0){perc_pares_1=-100;}
                if(sum_pares_realizado_1>0 && sum_pares_previsto_1==0){perc_pares_1=0;}

                pm_dif_pos_1 = ((pm_realizado_1 * 100.00) / (pm_previsto_1==0?1:pm_previsto_1));
              if(pm_realizado_1==0 && pm_previsto_1>0){pm_dif_pos_1=0;}
            if(pm_realizado_1>0 && pm_previsto_1==0){pm_dif_pos_1=100;}

            perc_pos_reais_1 = ((sum_reais_realizado_1 * 100) / (sum_reais_previsto_1==0?1:sum_reais_previsto_1));
          if(sum_reais_realizado_1==0 && sum_reais_previsto_1>0){perc_pos_reais_1=0;}
        if(sum_reais_realizado_1>0 && sum_reais_previsto_1==0){perc_pos_reais_1=100;}

        perc_pos_pares_1 = (( (double) sum_pares_realizado_1 * 100.00) / ((double) sum_pares_previsto_1==0?1:sum_pares_previsto_1));
      if(sum_pares_realizado_1==0 && sum_pares_previsto_1>0){perc_pos_pares_1=0;}
    if(sum_pares_realizado_1>0 && sum_pares_previsto_1==0){perc_pos_pares_1=100;}
    %>

    <%
    if(((String)session.getAttribute("PoiAbertoRepEntradaPedidos_rep")=="N")){
      %>
      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(sum_pares_previsto_1, "##,##0") %>
      </td>

      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(sum_pares_realizado_1, "##,##0") %>
      </td>


      <%
    } else{
      %>
      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(sum_pares_previsto_1, "##,##0") %>
      </td>
      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(sum_pares_realizado_1, "##,##0") %>
      </td>
      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(perc_pos_pares_1, "##,##0.00") %>
      </td>
      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(perc_pares_1, "##,##0.00") %>
      </td>
      <%
    }
    %>

    <%
    if(((String)session.getAttribute("PoiAbertoRepEntradaPedidos_rep")=="N")){
      %>
      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(perc_pos_pares_1, "##,##0.00") %>
      </td>

      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(perc_pares_1, "##,##0.00") %>
      </td>

      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(sum_reais_previsto_1, "##,##0.00") %>
      </td>

      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(sum_reais_realizado_1, "##,##0.00") %>
      </td>

      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(perc_pos_reais_1, "##,##0.00") %>
      </td>

      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(perc_reais_1, "##,##0.00") %>
      </td>

      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(pm_previsto_1, "##,##0.00") %>
      </td>

      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(pm_realizado_1, "##,##0.00") %>
      </td>

      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(pm_dif_pos_1, "##,##0.00") %>
      </td>

      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(pm_dif_1, "##,##0.00") %>
      </td>

      <%
    }else {
      %>
      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(sum_reais_previsto_1, "##,##0.00") %>
      </td>

      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(sum_reais_realizado_1, "##,##0.00") %>
      </td>

      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(perc_pos_reais_1, "##,##0.00") %>
      </td>

      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(perc_reais_1, "##,##0.00") %>
      </td>

      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(pm_previsto_1, "##,##0.00") %>
      </td>

      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(pm_realizado_1, "##,##0.00") %>
      </td>

      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(pm_dif_pos_1, "##,##0.00") %>
      </td>

      <td class="totalTdColumn"  style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(pm_dif_1, "##,##0.00") %>
      </td>

      <%
    }
    %>

  </tr>




  <%
  //----------------------- TOTAL REGIONAL -----------------------------------------------------
  if (_b0_control != null && !_b0_control.equals(_b0_value)) {

    pm_previsto_2 = sum_reais_previsto_2 / (sum_pares_previsto_2==0?1:sum_pares_previsto_2);
    pm_realizado_2 = sum_reais_realizado_2 / (sum_pares_realizado_2==0?1:sum_pares_realizado_2);

    pm_dif_2 = (((pm_realizado_2 * 100) / (pm_previsto_2==0?1:pm_previsto_2 ))-100);
  if(pm_realizado_2==0 && pm_previsto_2>0){pm_dif_2=-100;}
if(pm_realizado_2>0 && pm_previsto_2==0){pm_dif_2=0;}

perc_reais_2 = ((sum_reais_realizado_2 * 100) / (sum_reais_previsto_2==0?1:sum_reais_previsto_2)-100);
if(sum_reais_realizado_2==0 && sum_reais_previsto_2>0){perc_reais_2=-100;}
if(sum_reais_realizado_2>0 && sum_reais_previsto_2==0){perc_reais_2=0;}

perc_pares_2 = (((double) sum_pares_realizado_2 * 100.00) / ((double) sum_pares_previsto_2==0?1:sum_pares_previsto_2)-100);
if(sum_pares_realizado_2==0 && sum_pares_previsto_2>0){perc_pares_2=-100;}
if(sum_pares_realizado_2>0 && sum_pares_previsto_2==0){perc_pares_2=0;}

pm_dif_pos_2 = ((pm_realizado_2 * 100.00) / (pm_previsto_2==0?1:pm_previsto_2));
if(pm_realizado_2==0 && pm_previsto_2>0){pm_dif_2=0;}
if(pm_realizado_2>0 && pm_previsto_2==0){pm_dif_2=100;}

perc_pos_reais_2 = ((sum_reais_realizado_2 * 100) / (sum_reais_previsto_2==0?1:sum_reais_previsto_2));
if(sum_reais_realizado_2==0 && sum_reais_previsto_2>0){perc_reais_2=0;}
if(sum_reais_realizado_2>0 && sum_reais_previsto_2==0){perc_reais_2=100;}

perc_pos_pares_2 = (( (double) sum_pares_realizado_2 * 100.00) / ((double) sum_pares_previsto_2==0?1:sum_pares_previsto_2));
if(sum_pares_realizado_2==0 && sum_pares_previsto_2>0){perc_pos_pares_2=0;}
if(sum_pares_realizado_2>0 && sum_pares_previsto_2==0){perc_pos_pares_2=100;}
%>

<tr class="totalColumn">
<td class="totalTdColumn"  style="text-align:left;" >
<b>
Total Regional :
</b>
</td>

<%
if(((String)session.getAttribute("PoiAbertoRepEntradaPedidos_rep")=="N")){
  %>
  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(sum_pares_previsto_2, "##,##0") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(sum_pares_realizado_2, "##,##0") %>
    </b>
  </td>

  <%
} else{
  %>
  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(sum_pares_previsto_2, "##,##0") %>
    </b>
  </td>
  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(sum_pares_realizado_2, "##,##0") %>
    </b>
  </td>
  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(poiAbertoRepresentanteEntradaPedidos.retornaPercentualPos(sum_pares_previsto_2 ,sum_pares_realizado_2 ), "##,##0.00") %>
    </b>
  </td>
  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(poiAbertoRepresentanteEntradaPedidos.retornaPercentual(sum_pares_previsto_2 ,sum_pares_realizado_2 ), "##,##0.00") %>
    </b>
  </td>
  <%
}
%>

<%
if(((String)session.getAttribute("PoiAbertoRepEntradaPedidos_rep")=="N")){
  %>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(poiAbertoRepresentanteEntradaPedidos.retornaPercentualPos(sum_pares_previsto_2,sum_pares_realizado_2), "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(poiAbertoRepresentanteEntradaPedidos.retornaPercentual(sum_pares_previsto_2,sum_pares_realizado_2), "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(sum_reais_previsto_2, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(sum_reais_realizado_2, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(poiAbertoRepresentanteEntradaPedidos.retornaPercentualPos(sum_reais_previsto_2 ,sum_reais_realizado_2 ), "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(poiAbertoRepresentanteEntradaPedidos.retornaPercentual(sum_reais_previsto_2 ,sum_reais_realizado_2 ), "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(pm_previsto_2, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(pm_realizado_2, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(poiAbertoRepresentanteEntradaPedidos.retornaPercentualPrecoPos(poiAbertoRepresentanteEntradaPedidos.retornaPrecoMedio(sum_reais_previsto_2,sum_pares_previsto_2),sum_reais_realizado_2,sum_pares_realizado_2), "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(poiAbertoRepresentanteEntradaPedidos.retornaPercentualPreco(poiAbertoRepresentanteEntradaPedidos.retornaPrecoMedio(sum_reais_previsto_2,sum_pares_previsto_2),sum_reais_realizado_2,sum_pares_realizado_2), "##,##0.00") %>
    </b>
  </td>

  <%
}else {
  %>
  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(sum_reais_previsto_2, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(sum_reais_realizado_2, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(perc_pos_reais_2, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(perc_reais_2, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(pm_previsto_2, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(pm_realizado_2, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(pm_dif_pos_2, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(pm_dif_2, "##,##0.00") %>
    </b>
  </td>

  <%
}
%>

</tr>

<%
sum_pares_previsto_2 = 0;
sum_reais_previsto_2 = 0;
sum_reais_realizado_2 = 0;
sum_reais_faturado_2 = 0;
sum_reais_a_faturar_2 = 0;
sum_pares_realizado_2 = 0;
sum_pares_faturado_2 = 0;
sum_pares_a_faturar_2 = 0;
}
//--------------------- FIM TOTAL REGIONAL ---------------------------------------------------
%>


<%
sum_pares_previsto_1 = 0;
sum_reais_previsto_1 = 0;
sum_reais_realizado_1 = 0;
sum_reais_faturado_1 = 0;
sum_reais_a_faturar_1 = 0;
sum_pares_realizado_1 = 0;
sum_pares_faturado_1 = 0;
sum_pares_a_faturar_1 = 0;
}
%>


<%
}
%>




<%
//----------------------- TOTAL GERAL -----------------------------------------------------

pm_previsto_0 = sum_reais_previsto_0 / (sum_pares_previsto_0==0?1:sum_pares_previsto_0);
pm_realizado_0 = sum_reais_realizado_0 / (sum_pares_realizado_0==0?1:sum_pares_realizado_0);

pm_dif_0 =  ((pm_realizado_0 * 100.00) / (pm_previsto_0==0?1:pm_previsto_0)-100);
if(pm_realizado_0==0 && pm_previsto_0>0){pm_dif_0=-100;}
if(pm_realizado_0>0 && pm_previsto_0==0){pm_dif_0=0;}

perc_reais_0 = ((sum_reais_realizado_0 * 100) / (sum_reais_previsto_0==0?1:sum_reais_previsto_0)-100);
if(sum_reais_realizado_0==0 && sum_reais_previsto_0>0){perc_reais_0=-100;}
if(sum_reais_realizado_0>0 && sum_reais_previsto_0==0){perc_reais_0=0;}

perc_pares_0 = (( (double) sum_pares_realizado_0 * 100.00) / ((double) sum_pares_previsto_0==0?1:sum_pares_previsto_0)-100);
if(sum_pares_realizado_0==0 && sum_pares_previsto_0>0){perc_pares_0=-100;}
if(sum_pares_realizado_0>0 && sum_pares_previsto_0==0){perc_pares_0=0;}

pm_dif_pos_0 = ((pm_realizado_0 * 100) / (pm_previsto_0==0?1:pm_previsto_0 ));
if(pm_realizado_0==0 && pm_previsto_0>0){pm_dif_pos_0=0;}
if(pm_realizado_0>0 && pm_previsto_0==0){pm_dif_pos_0=100;}

perc_pos_reais_0 = ((sum_reais_realizado_0 * 100) / (sum_reais_previsto_0==0?1:sum_reais_previsto_0));
if(sum_reais_realizado_0==0 && sum_reais_previsto_0>0){perc_pos_reais_0=0;}
if(sum_reais_realizado_0>0 && sum_reais_previsto_0==0){perc_pos_reais_0=100;}

perc_pos_pares_0 = (((double) sum_pares_realizado_0 * 100.00) / ((double) sum_pares_previsto_0==0?1:sum_pares_previsto_0));
if(sum_pares_realizado_0==0 && sum_pares_previsto_0>0){perc_pos_pares_0=0;}
if(sum_pares_realizado_0>0 && sum_pares_previsto_0==0){perc_pos_pares_0=100;}
%>

<tr class="totalColumn">
<td class="totalTdColumn"  style="text-align:left;" >
<b>
Total Geral :
</b>
</td>

<%
if(((String)session.getAttribute("PoiAbertoRepEntradaPedidos_rep")=="N")){
  %>
  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(sum_pares_previsto_0, "##,##0") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(sum_pares_realizado_0, "##,##0") %>
    </b>
  </td>

  <%
} else{
  %>
  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(sum_pares_previsto_0, "##,##0") %>
    </b>
  </td>
  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(sum_pares_realizado_0, "##,##0") %>
    </b>
  </td>
  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(perc_pos_pares_0, "##,##0.00") %>
    </b>
  </td>
  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(perc_pares_0, "##,##0.00") %>
    </b>
  </td>
  <%
}
%>

<%
if(((String)session.getAttribute("PoiAbertoRepEntradaPedidos_rep")=="N")){
  %>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(perc_pos_pares_0, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(perc_pares_0, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(sum_reais_previsto_0, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(sum_reais_realizado_0, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(perc_pos_reais_0, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(perc_reais_0, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(pm_previsto_0, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(pm_realizado_0, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(pm_dif_pos_0, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(pm_dif_0, "##,##0.00") %>
    </b>
  </td>

  <%
}else {
  %>
  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(sum_reais_previsto_0, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(sum_reais_realizado_0, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(perc_pos_reais_0, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(perc_reais_0, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(pm_previsto_0, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(pm_realizado_0, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(pm_dif_pos_0, "##,##0.00") %>
    </b>
  </td>

  <td class="totalTdColumn"  style="text-align:right;" colspan="1">
    <b>
      <%= com.egen.util.text.FormatNumber.format(pm_dif_0, "##,##0.00") %>
    </b>
  </td>

  <%
}
%>

</tr>

<%
//--------------------- FIM TOTAL GERAL ---------------------------------------------------
%>




<%
}
%>


</table>
</form>
<%
}
%>

<%
/*   portalbr.com.PoiAbertoRepEntradaPedidos_rActionForm PoiAbertoRepEntradaPedidos_rActionForm = (portalbr.com.PoiAbertoRepEntradaPedidos_rActionForm)session.getAttribute("PoiAbertoRepEntradaPedidos_rActionForm");
String tipo="";
acesso.Usuario u = new acesso.Usuario();
u = (acesso.Usuario)session.getAttribute("User");
acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

if(!(u.getEntidadeNegocio()==null)){
ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
tipo = tipoent.getTipo()+"";
}

portalbr.dbobj.view.Jw_poi_aberto_rep_r t_jw_poi_registros = new portalbr.dbobj.view.Jw_poi_aberto_rep_r();
java.util.Vector res_Jw_poi_registros = null;
//-------------------------------------------
int faturado       = 0;
int contador       = 0;
double cotas       = 0;
double prev_cotas  = 0;
double teste2      = 0;
double preco_dif   = 0;
double reais_perc  = 0;
double pares_perc  = 0;
int contador_marca = 0;
String nome_marca              = "";
String nome_marca_anterior     = "";
double previsto_reais          = 0;
double total_reais_faturado    = 0;
double total_reais_a_faturar   = 0;
double total_reais_realizado   = 0;
double total_pares_a_faturar   = 0;
double total_pares_realizado   = 0;
double total_media_dia         = 0;
double total_media_rep         = 0;
//-----------------------------------------------
double total_media_dia_u       = 0;
double total_media_rep_u       = 0;
double faturado_u              = 0;
double previsto_reais_u        = 0;
double cotas_u                 = 0;
double total_pares_a_faturar_u = 0;
double total_reais_faturado_u  = 0;
double total_reais_a_faturar_u = 0;
double total_reais_realizado_u = 0;
double total_pares_realizado_u = 0;
double teste_u      = 0;
double teste2_u     = 0;
double preco_dif_u  = 0;
double reais_perc_u = 0;
double pares_perc_u = 0;

//-----------------------------------------------
int counterbl_report_Jw_poi=0;
com.egen.util.jdbc.JdbcUtil j = null;
java.util.Vector res_Jw_poi_marcas2 = null;
portalbr.dbobj.view.Jw_poi_marcas t_jw_poi_marcas = new portalbr.dbobj.view.Jw_poi_marcas();

String codigo_regional_f="";
String codigo_representante_f="";
String codigo_analista_f="";
String tipo_f="";
String cliente_f="";
acesso.Usuario u_f = new acesso.Usuario();
u_f = (acesso.Usuario)session.getAttribute("User");
acesso.EntidadeNegocio ent_f = new acesso.EntidadeNegocio();
acesso.TipoEntidadeNegocio tipoent_f = new acesso.TipoEntidadeNegocio();

if(!(u_f.getEntidadeNegocio()==null)){
ent_f = (acesso.EntidadeNegocio) u_f.getEntidadeNegocio();
tipoent_f = (acesso.TipoEntidadeNegocio) ent_f.getTipoEntidadeNegocio();
tipo_f = tipoent_f.getTipo()+"";
if(tipo_f.equals("REGIONAL DE VENDA")){
  PoiAbertoRepEntradaPedidos_rActionForm.setCodigo_regional(ent_f.getChave()+"");
}
if((tipo_f.equals("REPRESENTANTE COMERCIAL")) || (tipo_f.equals("REPRESENTANTE EXPORTACAO"))){
  PoiAbertoRepEntradaPedidos_rActionForm.setRep_cdgo(ent_f.getChave()+"");
}
if(tipo.equals("ANALISTA REGIONAL")){
  codigo_analista_f = ent_f.getChave()+"";
}
if(tipo.equals("CLIENTE MERCADO EXTERNO")){
  cliente_f = ent_f.getChave()+"";
}
if(tipo.equals("CLIENTE MERCADO INTERNO")){
  cliente_f = ent_f.getChave()+"";
}
}

if(tipo_f.equals("ANALISTA REGIONAL")){
com.egen.util.jdbc.JdbcUtil j2 = null;
try{
  java.util.Vector res_Jw_regional_analista = null;
  j2 = new com.egen.util.jdbc.JdbcUtil();
  portalbr.dbobj.view.Jw_regional_analista table = new portalbr.dbobj.view.Jw_regional_analista();
  String[][] select = null;
  Object[][] where = {
  {"codigo_gerente","=",codigo_analista_f}
  };

  res_Jw_regional_analista = j2.select(table, select, where, null, null, null);


  if (res_Jw_regional_analista != null && res_Jw_regional_analista.size() > 0) {
    portalbr.dbobj.view.Jw_regional_analista r_f = (portalbr.dbobj.view.Jw_regional_analista) res_Jw_regional_analista.elementAt(0);
    codigo_regional_f = r_f.getCodigo_regional();
  }

} finally {
  if(j2!=null) {
    j2.close();
    j2 = null;
  }
}
}

String rep_rzao      = "";
String regional      = "null";
String representante = "";
String pmarca        = "";
String mes = PoiAbertoRepEntradaPedidos_rActionForm.getMes();
String ano = PoiAbertoRepEntradaPedidos_rActionForm.getAno();

if(PoiAbertoRepEntradaPedidos_rActionForm.getCodigo_regional()!=""){
regional = PoiAbertoRepEntradaPedidos_rActionForm.getCodigo_regional();
}
if(PoiAbertoRepEntradaPedidos_rActionForm.getRep_cdgo()!="" &&
PoiAbertoRepEntradaPedidos_rActionForm.getRep_cdgo()!="null"){
representante = " and  rep.rep_cdgo in("+PoiAbertoRepEntradaPedidos_rActionForm.getRep_cdgo()+") ";
}
if(PoiAbertoRepEntradaPedidos_rActionForm.getCodigo_marca()!="" &&
PoiAbertoRepEntradaPedidos_rActionForm.getCodigo_marca()!="null"){
pmarca = " and t.codigo_marca = "+ PoiAbertoRepEntradaPedidos_rActionForm.getCodigo_marca();
}


try {
j = new com.egen.util.jdbc.JdbcUtil();
//-----------------------------------------------
if(PoiAbertoRepEntradaPedidos_rActionForm.getRep_cdgo()!=""){
  portalbr.dbobj.table.Rep db_object = new portalbr.dbobj.table.Rep();
  Object[][] where = {
  {"rep_cdgo","like", PoiAbertoRepEntradaPedidos_rActionForm.getRep_cdgo()}
  };
  java.util.Vector results = j.select(db_object, where, null);
  if (results!=null && results.size()>0) {
    db_object = (portalbr.dbobj.table.Rep)results.elementAt(0);
    rep_rzao = (db_object.getRep_rzao()!=null)?db_object.getRep_rzao()+"":"";
  }
}
//-----------------------------------------------
portalbr.dbobj.view.Jw_poi_aberto t_jw_poi = new portalbr.dbobj.view.Jw_poi_aberto();
java.util.Vector res_Jw_poi = (java.util.Vector)session.getAttribute("res_Jw_poi");
if (res_Jw_poi!=null && res_Jw_poi.size()>0) { // if if777
java.lang.Integer codigo_regional    =  null;
java.lang.String nome_regional       =  null;
java.lang.Integer codigo_gerente     =  null;
java.lang.String nome_gerente        =  null;
java.lang.String endereco            =  null;
java.lang.String estado_gerente      =  null;
java.lang.String unidade_negocio     =  null;
java.lang.String unn_descri          =  null;
java.lang.Integer b0_codigo_regional =  null;
java.lang.String b2_unidade_negocio  =  null;
java.lang.String desc_marca          =  "";
int i_bl_report_Jw_poi = 0;
t_jw_poi = (portalbr.dbobj.view.Jw_poi_aberto)res_Jw_poi.elementAt(i_bl_report_Jw_poi);
codigo_regional = t_jw_poi.getCodigo_regional();
nome_regional   = t_jw_poi.getNome_regional()==null?"":t_jw_poi.getNome_regional();
codigo_gerente  = t_jw_poi.getCodigo_gerente();
nome_gerente    = t_jw_poi.getNome_gerente()==null?"":t_jw_poi.getNome_gerente();
endereco        = t_jw_poi.getEndereco()==null?"":t_jw_poi.getEndereco();
estado_gerente  = t_jw_poi.getEstado_gerente()==null?"":t_jw_poi.getEstado_gerente();
unidade_negocio = t_jw_poi.getUnidade_negocio()==null?"":t_jw_poi.getUnidade_negocio();
unn_descri      = t_jw_poi.getUnn_descri()==null?"":t_jw_poi.getUnn_descri();
Integer cdGerenteOld = null;
while (i_bl_report_Jw_poi<res_Jw_poi.size()){ // while w1
if(cdGerenteOld == null || cdGerenteOld.intValue() != codigo_gerente.intValue() ){
  %>
  <table id="TRbl_report_Jw_poi" class="reportTable" style="width:99%";  border=1;  frame=box>
    <tr class="reportHeader3" >
      <td colspan=4>
        Regional :
        <%= ((codigo_regional!=null)?codigo_regional.toString():"") %>
        -
        <%= nome_regional %>
      </td>
    </tr>
    <%
    b0_codigo_regional = codigo_regional;
    %>
    <%
    if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
      %>
      <tr class="reportHeader3" >
        <td colspan=2>
          Analista :
          <%= ((codigo_gerente!=null)?codigo_gerente.toString():"") %>
          -
          <%= nome_gerente %>
        </td>
        <td>
          Endereço :
          <%= endereco %>
        </td>
        <td>
          UF :
          <%= estado_gerente %>
        </td>
      </tr>
      <%
    }
    %>
    <%
    if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
      %>
      <%
      if(PoiAbertoRepEntradaPedidos_rActionForm.getRep_cdgo()!=""){  //if if13
      %>
      <tr class="reportHeader3" >
        <td colspan=4>
          Representante :
          <%= PoiAbertoRepEntradaPedidos_rActionForm.getRep_cdgo() %>
          -
          <%= rep_rzao %>
        </td>
      </tr>
      <%
    }
    %>
    <%
  }
  %>
  <tr class="reportHeader3">
    <td  colspan=4>
      Período : de
      <%= PoiAbertoRepEntradaPedidos_rActionForm.getMes() %>
      /
      <%= PoiAbertoRepEntradaPedidos_rActionForm.getAno() %>
      a
      <%= PoiAbertoRepEntradaPedidos_rActionForm.getMes_final() %>
      /
      <%= PoiAbertoRepEntradaPedidos_rActionForm.getAno_final() %>
    </td>
  </tr>
</table>
<%
}
counterbl_report_Jw_poi++;
desc_marca = t_jw_poi.getDesc_marca()==null?"":t_jw_poi.getDesc_marca();
%>

<table id="TRbl_report_Jw_poi" class="reportTable" style="width:99%";  border=1; frame=box;>
<!--
  foi tirada a unidade de negócio 08/2007 <tr class="reportHeader2"> <td class="reportColumn" style="text-align:left;"> Unidade : <%= unidade_negocio %> - <%= unn_descri %> </td> </tr>
-->
<tr class="reportHeader2">
  <td class="reportColumn" style="text-align:left;">
    <big>
      Marca :
      <%= desc_marca %>
    </big>
  </td>
</tr>
<table id="TRbl_report_Jw_poi_registros" class="reportTable" style="width:99%"; border=1; >
  <%
  int counterbl_report_Jw_poi_registros=0;
  try {
    StringBuilder query = new StringBuilder();

    query.append(" SELECT t.codigo_representante ");
    query.append("      , r.rep_rzao ");
    query.append("      ,  mp.codigo_marca || '-' || mp.descricao_marca marca ");
    query.append("      , '' unidade_negocio ");
    query.append("      , 0 media_dia ");
    query.append("      , 0 media_rep ");
    query.append("      , sum(t.total_reais_previsto) / ");
    query.append("                decode(sum(t.total_pares_previsto), 0, 1, ");
    query.append("                sum(t.total_pares_previsto)) preco_previsto ");
    query.append("      , (sum(realizado.vlr_fat) + sum(realizado.vlr_a_fat)) / ");
    query.append("                decode((sum(realizado.qtde_fat) + sum(realizado.qtde_a_fat)), 0, 1, ");
    query.append("                sum(realizado.qtde_fat) + sum(realizado.qtde_a_fat)) preco_realizado ");
    query.append("      , round(((sum(realizado.vlr_fat) + sum(realizado.vlr_a_fat)) /  ");
    query.append("                decode(sum(realizado.qtde_fat) +  sum(realizado.qtde_a_fat),  ");
    query.append("                0, 1, sum(realizado.qtde_fat) + sum(realizado.qtde_a_fat)) * 100) /  ");
    query.append("                (decode(sum(t.total_reais_previsto),0, 1, sum(t.total_reais_previsto)) /  ");
    query.append("                decode(sum(t.total_pares_previsto), 0,1,sum(t.total_pares_previsto))) - 100) dif_preco ");
    query.append("      , sum(realizado.vlr_fat) reais_faturado ");
    query.append("      , sum(realizado.vlr_a_fat) - sum(t.total_reais_atraso) reais_a_faturar ");
    query.append("      , sum(t.total_reais_previsto) reais_previsto ");
    query.append("      , sum(realizado.vlr_fat) + sum(realizado.vlr_a_fat) - sum(t.total_reais_atraso)  reais_realizado ");
    query.append("    , ((sum(realizado.vlr_fat) + sum(realizado.vlr_a_fat) - sum(t.total_reais_atraso)) * 100) / ");
    query.append("                (decode(sum(t.total_reais_previsto),0,1, sum(t.total_reais_previsto))) dif_reais ");
    query.append("      , sum(realizado.qtde_fat) pares_faturado ");
    query.append("      , sum(t.total_pares_previsto) pares_previsto ");
    query.append("      , sum(realizado.qtde_fat) + sum(realizado.qtde_a_fat) pares_realizado ");
    query.append("      , sum(realizado.qtde_a_fat) pares_a_faturar ");
    query.append("      , ((sum(realizado.qtde_fat) + sum(realizado.qtde_a_fat)) * 100) / ");
    query.append("                decode(sum(t.total_pares_previsto), 0, 1, sum(t.total_pares_previsto)) dif_pares ");
    query.append("      , avg(prazo_medio) prazo_medio ");
    query.append("   FROM brio.cotas_linhas_reais_entrada t ");
    query.append("      , brio.marcas_produtos mp ");
    query.append("      , brio.rep ");
    query.append("      , rep r ");
    query.append("      ,( select codigo_marca ");
    query.append("              , rep_cdgo ");
    query.append("              , sum(vlr_fat) vlr_fat ");
    query.append("              , sum(vlr_a_fat) vlr_a_fat ");
    query.append("              , sum(qtde_fat) qtde_fat ");
    query.append("              , sum(qtde_a_fat) qtde_a_fat ");
    query.append("           from ( select p.rep_cdgo rep_cdgo ");
    query.append("                       , fct_marca_produto(i.lin_cdgo, i.ref_cdgo) codigo_marca ");
    query.append("                       , sum(fct_valor_pedido(i.ped_nmro, i.ite_seqn)) vlr_fat ");
    query.append("                       , 0 vlr_a_fat ");
    query.append("                       , sum(i.ite_qtde) qtde_fat ");
    query.append("                       , 0 qtde_a_fat ");
    query.append("                  from ped p ");
    query.append("                     , ite i ");
    query.append("                 where p.ped_nmro = i.ped_nmro ");
    query.append("                   and nvl(p.ped_stat,null) = 'F' ");
    query.append("                   and i.ite_situ = '9' ");
    query.append("                   and NVL(p.ped_amostra_brinde, 'X') <> 'B' ");
    query.append("                   AND p.ped_stat <> 'C' ");
    query.append("                   AND NVL(p.ped_substituicao, 'N') <> 'S' ");
    query.append("                   AND NVL(p.ped_especie_pedido, NULL) IN ('N', 'X', 'F', 'P') ");
    query.append("                   AND NVL(p.cli_cdgo, NULL) <> 40000 ");
    query.append("                   AND p.ped_dadg between to_date('"+com.egen.util.text.FormatNumber.format(Integer.parseInt(PoiAbertoRepEntradaPedidos_rActionForm.getMes()), "00")+PoiAbertoRepEntradaPedidos_rActionForm.getAno()+"','mm/yyyy') ");
    query.append("                                      and last_day(to_date('"+com.egen.util.text.FormatNumber.format(Integer.parseInt(PoiAbertoRepEntradaPedidos_rActionForm.getMes_final()), "00")+PoiAbertoRepEntradaPedidos_rActionForm.getAno_final()+ "','mm/yyyy')) ");
    query.append("                 group by p.rep_cdgo ");
    query.append("                        , fct_marca_produto(i.lin_cdgo, i.ref_cdgo) ");
    query.append("                 union all ");
    query.append("                select p.rep_cdgo rep_cdgo ");
    query.append("                     , fct_marca_produto(i.lin_cdgo, i.ref_cdgo) codigo_marca ");
    query.append("                     , 0 vlr_fat ");
    query.append("                     , sum(fct_valor_pedido(i.ped_nmro, i.ite_seqn)) vlr_a_fat ");
    query.append("                     , 0 qtde_fat ");
    query.append("                     , sum(i.ite_qtde) qtde_a_fat ");
    query.append("                  from ped p ");
    query.append("                     , ite i ");
    query.append("                 where p.ped_nmro = i.ped_nmro ");
    query.append("                   and p.ped_stat not in ('C','F') ");
    query.append("                   and i.ite_situ not in ('8','9') ");
    query.append("                   AND NVL(p.ped_amostra_brinde, 'X') <> 'B' ");
    query.append("                   AND p.ped_stat <> 'C' ");
    query.append("                   AND NVL(p.ped_substituicao, 'N') <> 'S' ");
    query.append("                   AND NVL(p.ped_especie_pedido, NULL) IN ('N', 'X', 'F', 'P') ");
    query.append("                   AND NVL(p.cli_cdgo, NULL) <> 40000 ");
    query.append("                   AND p.ped_dadg between to_date('"+com.egen.util.text.FormatNumber.format(Integer.parseInt(PoiAbertoRepEntradaPedidos_rActionForm.getMes()), "00")+PoiAbertoRepEntradaPedidos_rActionForm.getAno()+"','mm/yyyy') ");
    query.append("                                      and last_day(to_date('"+com.egen.util.text.FormatNumber.format(Integer.parseInt(PoiAbertoRepEntradaPedidos_rActionForm.getMes_final()), "00")+PoiAbertoRepEntradaPedidos_rActionForm.getAno_final()+ "','mm/yyyy')) ");
    query.append("                 group by p.rep_cdgo ");
    query.append("                        , fct_marca_produto(i.lin_cdgo, i.ref_cdgo) ");
    query.append("               ) ");
    query.append("           group by rep_cdgo ");
    query.append("                  , codigo_marca ");
    query.append(" )      realizado ");
    query.append("  WHERE rep.rep_cdgo             = t.codigo_representante ");
    query.append("    AND rep.codigo_gerente         = nvl("+ codigo_gerente +", rep.codigo_gerente) ");
    query.append("    AND ((t.mes_venda_reais  >= ").append(PoiAbertoRepEntradaPedidos_rActionForm.getMes()).append(" and t.ano_venda_reais >= ").append(PoiAbertoRepEntradaPedidos_rActionForm.getAno()).append(") ");
    query.append("          AND ");
    query.append("         (t.mes_venda_reais  <= ").append(PoiAbertoRepEntradaPedidos_rActionForm.getMes_final()).append(" and t.ano_venda_reais <= ").append(PoiAbertoRepEntradaPedidos_rActionForm.getAno_final()).append(")) ");
    query.append(representante);
    query.append(pmarca);
    query.append("    AND t.codigo_marca           = mp.codigo_marca ");
    query.append("    AND t.codigo_marca           = "+desc_marca.substring(0,desc_marca.lastIndexOf("-")));
    query.append("    AND r.rep_cdgo               = t.codigo_representante ");
    query.append("    and realizado.rep_cdgo (+) = t.codigo_representante ");
    query.append("    and realizado.codigo_marca (+)  = t.codigo_marca ");
    query.append("  GROUP BY mp.codigo_marca ");
    query.append("         , mp.descricao_marca ");
    query.append("         , t.codigo_representante ");
    query.append("         , r.rep_rzao ");
    query.append("  ORDER BY mp.descricao_marca ");


    res_Jw_poi_registros = j.select(t_jw_poi_registros,
    query.toString(),
    null);

  } catch (Exception e){
    session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
  }

  if (res_Jw_poi_registros!=null && res_Jw_poi_registros.size()>0) { // if if77
  java.lang.String marca =  null;
  java.lang.String unidade_negocio1       =  null;
  java.lang.String codigo_representante_r =  "";

  java.lang.String rep_rzao_r =  "";
  double preco_previsto  =  0;
  double preco_realizado =  0;
  double dif_preco       =  0;
  double reais_faturado  =  0;
  double reais_a_faturar =  0;
  double reais_previsto  =  0;
  double reais_realizado =  0;
  double dif_reais       =  0;
  double pares_faturado  =  0;
  double pares_previsto  =  0;
  double pares_realizado =  0;
  double pares_a_faturar =  0;
  double dif_pares       =  0;
  double prazo_medio     =  0;
  double media_dia       =  0;
  double media_rep       =  0;
  int i_bl_report_Jw_poi_registros = 0;
  t_jw_poi_registros = (portalbr.dbobj.view.Jw_poi_aberto_rep_r)res_Jw_poi_registros.elementAt(i_bl_report_Jw_poi_registros);
  marca = t_jw_poi_registros.getMarca()==null?"":t_jw_poi_registros.getMarca();
  unidade_negocio1        = t_jw_poi_registros.getUnidade_negocio()==null?"":t_jw_poi_registros.getUnidade_negocio();
  preco_previsto          = t_jw_poi_registros.getPreco_previsto();
  preco_realizado         = t_jw_poi_registros.getPreco_realizado();
  dif_preco               = t_jw_poi_registros.getDif_preco();
  reais_faturado          = t_jw_poi_registros.getReais_faturado();
  reais_a_faturar         = t_jw_poi_registros.getReais_a_faturar();
  reais_previsto          = t_jw_poi_registros.getReais_previsto();
  reais_realizado         = t_jw_poi_registros.getReais_realizado();
  dif_reais               = t_jw_poi_registros.getDif_reais();
  pares_faturado          = t_jw_poi_registros.getPares_faturado();
  pares_previsto          = t_jw_poi_registros.getPares_previsto();
  pares_realizado         = t_jw_poi_registros.getPares_realizado();
  pares_a_faturar         = t_jw_poi_registros.getPares_a_faturar();
  dif_pares               = t_jw_poi_registros.getDif_pares();
  prazo_medio             = t_jw_poi_registros.getPrazo_medio();
  media_dia               = t_jw_poi_registros.getMedia_dia();
  media_rep               = t_jw_poi_registros.getMedia_rep();
  codigo_representante_r  = t_jw_poi_registros.getCodigo_representante();
  rep_rzao_r              = t_jw_poi_registros.getRep_rzao();
  nome_marca              = marca;
  nome_marca_anterior     = marca;
  total_media_dia        += media_dia;
  total_media_rep        += media_rep;
  faturado               += pares_faturado;
  previsto_reais         += reais_previsto;
  cotas                  += pares_previsto;
  total_reais_faturado   += reais_faturado;
  total_reais_a_faturar  += reais_a_faturar;
  total_reais_realizado  += reais_realizado;
  total_pares_a_faturar  += pares_a_faturar;
  total_pares_realizado  += pares_realizado;
  //-----------------------------------------------
  total_media_dia_u       += media_dia;
  total_media_rep_u       += media_rep;
  faturado_u              += pares_faturado;
  previsto_reais_u        += reais_previsto;
  cotas_u                 += pares_previsto;
  total_pares_a_faturar_u += pares_a_faturar;
  total_reais_faturado_u  += reais_faturado;
  total_reais_a_faturar_u += reais_a_faturar;
  total_reais_realizado_u += reais_realizado;
  total_pares_realizado_u += pares_realizado;
  //-----------------------------------------------
  contador_marca ++;
  %>
  <%
  if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
    %>
    <tr class="reportHeader" >
      <td>
      </td>
      <td colspan=3 align="center">
        <b>
          Preço Médio
        </b>
      </td>
      <td colspan=5 align="center">
        <b>
          Reais
        </b>
      </td>
      <%
      if(PoiAbertoRepEntradaPedidos_rActionForm.getRep_cdgo()==""){
        %>
        <td colspan=8 align="center">
          <b>
            Pares
          </b>
        </td>
        <%}else { %>
          <td colspan=6 align="center">
            <b>
              Pares
            </b>
          </td>
          <%
        }
        %>
      </tr>
      <%
    } else {
      %>
      <tr class="reportHeader" >
        <td>
        </td>
        <td colspan=3 align="center">
          <b>
            Reais
          </b>
        </td>
        <td colspan=3 align="center">
          <b>
            Pares
          </b>
        </td>
      </tr>
      <%
    }
    %>
    <tr class="reportHeader">
      <td class="columnTdHeader" style="text-align:left;">
        <%
        if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
          %>
          Representante
          <%
        } else {
          %>
          Empresa de Representação
          <%
        }
        %>
      </td>
      <%
      if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
        %>
        <td class="columnTdHeader" style="text-align:right;">
          Prev.
        </td>
        <td class="columnTdHeader" style="text-align:right;">
          Real.
        </td>
        <td class="columnTdHeader" style="text-align:right;">
          Dif.
        </td>
        <td class="columnTdHeader" style="text-align:right;">
          Prev.
        </td>
        <%
      }
      %>
      <td class="columnTdHeader" style="text-align:right;">
        Realizado
      </td>
      <%
      if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
        %>
        <td class="columnTdHeader" style="text-align:right;">
          Perc.
        </td>
        <%
      }
      %>
      <td class="columnTdHeader" style="text-align:right;">
        Faturado
      </td>
      <td class="columnTdHeader" style="text-align:right;">
        A Fatur.
      </td>

      <%
      if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
        %>

        <td class="columnTdHeader" style="text-align:right;">
          Prev.
        </td>
        <%
      }
      %>
      <td class="columnTdHeader" style="text-align:right;">
        Realizado
      </td>
      <%
      if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
        %>
        <td class="columnTdHeader" style="text-align:right;">
          Perc.
        </td>
        <%
      }
      %>
      <td class="columnTdHeader" style="text-align:right;">
        Faturado
      </td>
      <td class="columnTdHeader" style="text-align:right;">
        A Fatur.
      </td>

    </tr>
    <%
    while (i_bl_report_Jw_poi_registros<res_Jw_poi_registros.size()){ //w4
    counterbl_report_Jw_poi_registros++;
    String style="";
    if (!((i_bl_report_Jw_poi_registros%2)!=0)) {
      style="class=rowColor";

    } else {
      style="class=rowBlank";
    }
    %>
    <tr <%= style %> id='TRbl_report_Jw_poi_registros<%=counterbl_report_Jw_poi_registros%>' >
      <td class="reportColumn" style="text-align:left;">
        <%= codigo_representante_r %>
        -
        <%= rep_rzao_r %>
      </td>
      <%
      if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
        %>
        <td class="reportColumn" style="text-align:right;">
          <%= com.egen.util.text.FormatNumber.format(preco_previsto, "##,##0.00") %>
        </td>
        <td class="reportColumn" style="text-align:right;">
          <%= com.egen.util.text.FormatNumber.format(preco_realizado, "##,##0.00") %>
        </td>
        <td class="reportColumn" style="text-align:right;">
          <%= com.egen.util.text.FormatNumber.format(dif_preco, "0")+"%" %>
        </td>
        <td class="reportColumn" style="text-align:right;">
          <%= com.egen.util.text.FormatNumber.format(reais_previsto, "##,##0.00") %>
        </td>
        <%
      }
      %>
      <td class="reportColumn" style="text-align:right;">
        <%=com.egen.util.text.FormatNumber.format(reais_realizado,"##,##0.00")%>
      </td>
      <%
      if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
        %>
        <%
        if(reais_previsto==0) {
          %>
          <td class="reportColumn" style="text-align:right;">
            100.00%
          </td>
          <%} else { %>
            <td class="reportColumn" style="text-align:right;">
              <%= com.egen.util.text.FormatNumber.format(dif_reais, "##,##0.00")+"%" %>
            </td>
            <%
          }
          %>
          <%
        }
        %>
        <td class="reportColumn" style="text-align:right;">
          <%= com.egen.util.text.FormatNumber.format(reais_faturado, "##,##0.00") %>
        </td>
        <td class="reportColumn" style="text-align:right;">
          <%= com.egen.util.text.FormatNumber.format(reais_a_faturar, "##,##0.00") %>
        </td>
        <%
        if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
          %>
          <td class="reportColumn" style="text-align:right;">
            <%= com.egen.util.text.FormatNumber.format(pares_previsto, "0") %>
          </td>
          <%
        }
        %>
        <td class="reportColumn" style="text-align:right;">
          <%= com.egen.util.text.FormatNumber.format(pares_realizado, "0") %>
        </td>
        <%
        if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
          %>
          <%
          if(pares_previsto==0){
            %>
            <td class="reportColumn" style="text-align:right;">
              100.00%
            </td>
            <%
          } else {
            %>
            <td class="reportColumn" style="text-align:right;">
              <%= com.egen.util.text.FormatNumber.format(dif_pares, "##,##0.00")+"%" %>
            </td>
            <%
          }
          %>
          <%
        }
        %>
        <td class="reportColumn" style="text-align:right;">
          <%= com.egen.util.text.FormatNumber.format(pares_faturado, "0") %>
        </td>
        <td class="reportColumn" style="text-align:right;">
          <%= com.egen.util.text.FormatNumber.format(pares_a_faturar, "0") %>
        </td>

      </tr>
      <%
      // ------------------ TOTAL POR MARCA -------------------------------------------------------------------------------
      if((contador_marca==res_Jw_poi_registros.size())){ // if contador_marca
      contador_marca=0;
      teste_u      = previsto_reais_u / cotas_u;
      teste2_u     = total_reais_realizado_u/total_pares_realizado_u;
      preco_dif_u  = Math.round((teste2_u * 100) / teste_u) -100;
      reais_perc_u =  (total_reais_realizado_u * 100) / previsto_reais_u;
      pares_perc_u =  (total_pares_realizado_u * 100) / cotas_u;
      %>

      <%
      if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
        %>
        <tr class="reportHeader2">
          <td class="reportColumn" style="text-align:left;">
            Total
            <br>
            da Marca
          </td>
          <%
          if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
            %>
            <td class="reportColumn" style="text-align:right;">
              <%= com.egen.util.text.FormatNumber.format(teste_u, "##,##0.00") %>
            </td>
            <td class="reportColumn" style="text-align:right;">
              <%= com.egen.util.text.FormatNumber.format(teste2_u, "##,##0.00") %>
            </td>
            <td class="reportColumn" style="text-align:right;">
            </td>
            <td class="reportColumn" style="text-align:right;">
              <%= com.egen.util.text.FormatNumber.format(previsto_reais_u, "##,##0.00") %>
            </td>
            <%
          }
          %>
          <td class="reportColumn" style="text-align:right;">
            <%= com.egen.util.text.FormatNumber.format(total_reais_realizado_u, "##,##0.00") %>
          </td>
          <td class="reportColumn" style="text-align:right;">
            <%= com.egen.util.text.FormatNumber.format(reais_perc_u, "##,##0.00")+"%" %>
          </td>
          <td class="reportColumn" style="text-align:right;">
            <%= com.egen.util.text.FormatNumber.format(total_reais_faturado_u, "##,##0.00") %>
          </td>
          <%
          if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
            %>
            <td class="reportColumn" style="text-align:right;">
              <%= com.egen.util.text.FormatNumber.format(total_reais_a_faturar_u, "##,##0.00") %>
            </td>
            <td class="reportColumn" style="text-align:right;">
              <%= com.egen.util.text.FormatNumber.format(cotas_u, "0") %>
            </td>
            <%
          }
          %>
          <td class="reportColumn" style="text-align:right;">
            <%= com.egen.util.text.FormatNumber.format(total_pares_realizado_u, "0") %>
          </td>
          <%
          if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
            %>
            <td class="reportColumn" style="text-align:right;">
              <%= com.egen.util.text.FormatNumber.format(pares_perc_u, "##,##0.00")+"%" %>
            </td>
            <%
          }
          %>
          <td class="reportColumn" style="text-align:right;">
            <%= com.egen.util.text.FormatNumber.format(faturado_u, "0") %>
          </td>
          <td class="reportColumn" style="text-align:right;">
            <%= com.egen.util.text.FormatNumber.format(total_pares_a_faturar_u, "0") %>
          </td>


        </tr>
        <%
      }
      %>
      <%
      total_media_dia_u       = 0;
      total_media_rep_u       = 0;
      faturado_u              = 0;
      previsto_reais_u        = 0;
      cotas_u                 = 0;
      total_pares_a_faturar_u = 0;
      total_reais_faturado_u  = 0;
      total_reais_a_faturar_u = 0;
      total_reais_realizado_u = 0;
      total_pares_realizado_u = 0;
    }

    if (++i_bl_report_Jw_poi_registros >= res_Jw_poi_registros.size()) {
      break;
    }
    t_jw_poi_registros = (portalbr.dbobj.view.Jw_poi_aberto_rep_r)res_Jw_poi_registros.elementAt(i_bl_report_Jw_poi_registros);
    marca = t_jw_poi_registros.getMarca()==null?"":t_jw_poi_registros.getMarca();
    unidade_negocio1         = t_jw_poi_registros.getUnidade_negocio()==null?"":t_jw_poi_registros.getUnidade_negocio();
    preco_previsto           = t_jw_poi_registros.getPreco_previsto();
    preco_realizado          = t_jw_poi_registros.getPreco_realizado();
    dif_preco                = t_jw_poi_registros.getDif_preco();
    reais_faturado           = t_jw_poi_registros.getReais_faturado();
    reais_a_faturar          = t_jw_poi_registros.getReais_a_faturar();
    reais_previsto           = t_jw_poi_registros.getReais_previsto();
    reais_realizado          = t_jw_poi_registros.getReais_realizado();
    dif_reais                = t_jw_poi_registros.getDif_reais();
    pares_faturado           = t_jw_poi_registros.getPares_faturado();
    pares_previsto           = t_jw_poi_registros.getPares_previsto();
    pares_realizado          = t_jw_poi_registros.getPares_realizado();
    pares_a_faturar          = t_jw_poi_registros.getPares_a_faturar();
    dif_pares                = t_jw_poi_registros.getDif_pares();
    prazo_medio              = t_jw_poi_registros.getPrazo_medio();
    codigo_representante_r   = t_jw_poi_registros.getCodigo_representante();
    rep_rzao_r               = t_jw_poi_registros.getRep_rzao();
    total_media_dia         += media_dia;
    total_media_rep         += media_rep;
    faturado                += pares_faturado;
    previsto_reais          += reais_previsto;
    cotas                   += pares_previsto;
    total_pares_a_faturar   += pares_a_faturar;
    total_reais_faturado    += reais_faturado;
    total_reais_a_faturar   += reais_a_faturar;
    total_reais_realizado   += reais_realizado;
    total_pares_realizado   += pares_realizado;
    //-----------------------------------------------
    total_media_dia_u       += media_dia;
    total_media_rep_u       += media_rep;
    faturado_u              += pares_faturado;
    previsto_reais_u        += reais_previsto;
    cotas_u                 += pares_previsto;
    total_pares_a_faturar_u += pares_a_faturar;
    total_reais_faturado_u  += reais_faturado;
    total_reais_a_faturar_u += reais_a_faturar;
    total_reais_realizado_u += reais_realizado;
    total_pares_realizado_u += pares_realizado;
    //-----------------------------------------------
    contador_marca ++;
    }//fim if contador_marca
    } // fim while w4


    if(++contador == res_Jw_poi.size()) {
      prev_cotas = previsto_reais / cotas;
      teste2     = total_reais_realizado/total_pares_realizado;
      preco_dif = Math.round((teste2 * 100) / prev_cotas) -100;
      reais_perc =  (total_reais_realizado * 100) / previsto_reais;
      pares_perc =  (total_pares_realizado * 100) / cotas;
      %>
      <%
      if(tipo.equals("AREAS") || tipo.equals("")){
        %>
        <tr class="reportHeader2">
          <td class="reportColumn" style="text-align:left;">
            Total
            <br>
            <%
            if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
              %>
              da Regional
              <%
            } else {
              %>
              da Emp. Representação
              <%
            }
            %>
          </td>
          <%
          if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
            %>
            <td class="reportColumn" style="text-align:right;">
              <%= com.egen.util.text.FormatNumber.format(prev_cotas, "##,##0.00") %>
            </td>
            <td class="reportColumn" style="text-align:right;">
              <%= com.egen.util.text.FormatNumber.format(teste2, "##,##0.00") %>
            </td>
            <td class="reportColumn" style="text-align:right;">
            </td>
            <td class="reportColumn" style="text-align:right;">
              <%= com.egen.util.text.FormatNumber.format(previsto_reais, "##,##0.00") %>
            </td>
            <%
          }
          %>
          <td class="reportColumn" style="text-align:right;">
            <%= com.egen.util.text.FormatNumber.format(total_reais_realizado, "##,##0.00") %>
          </td>
          <%
          if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
            %>
            <td class="reportColumn" style="text-align:right;">
              <%= com.egen.util.text.FormatNumber.format(reais_perc, "##,##0.00")+"%" %>
            </td>
            <%
          }
          %>
          <td class="reportColumn" style="text-align:right;">
            <%= com.egen.util.text.FormatNumber.format(total_reais_faturado, "##,##0.00") %>
          </td>
          <td class="reportColumn" style="text-align:right;">
            <%= com.egen.util.text.FormatNumber.format(total_reais_a_faturar, "##,##0.00") %>
          </td>
          <%
          if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
            %>
            <td class="reportColumn" style="text-align:right;">
              <%= com.egen.util.text.FormatNumber.format(cotas, "0") %>
            </td>
            <%
          }
          %>
          <td class="reportColumn" style="text-align:right;">
            <%= com.egen.util.text.FormatNumber.format(total_pares_realizado, "0") %>
          </td>
          <%
          if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
            %>
            <td class="reportColumn" style="text-align:right;">
              <%= com.egen.util.text.FormatNumber.format(pares_perc, "##,##0.00")+"%" %>
            </td>
            <%
          }
          %>
          <td class="reportColumn" style="text-align:right;">
            <%= com.egen.util.text.FormatNumber.format(faturado, "0") %>
          </td>
          <td class="reportColumn" style="text-align:right;">
            <%= com.egen.util.text.FormatNumber.format(total_pares_a_faturar, "0") %>
          </td>


        </tr>
        <%
      }
      %>
      <%
      } //// fim if ++contador
      %>
    </table>
  </table>
  <%
  if (++i_bl_report_Jw_poi >= res_Jw_poi.size()) {
    break;
  }
  t_jw_poi = (portalbr.dbobj.view.Jw_poi_aberto)res_Jw_poi.elementAt(i_bl_report_Jw_poi);
  codigo_regional = t_jw_poi.getCodigo_regional();
  nome_regional   = t_jw_poi.getNome_regional()==null?"":t_jw_poi.getNome_regional();
  cdGerenteOld = codigo_gerente;
  codigo_gerente  = t_jw_poi.getCodigo_gerente();
  nome_gerente    = t_jw_poi.getNome_gerente()==null?"":t_jw_poi.getNome_gerente();
  endereco        = t_jw_poi.getEndereco()==null?"":t_jw_poi.getEndereco();
  estado_gerente  = t_jw_poi.getEstado_gerente()==null?"":t_jw_poi.getEstado_gerente();
  unidade_negocio = t_jw_poi.getUnidade_negocio()==null?"":t_jw_poi.getUnidade_negocio();
  unn_descri      = t_jw_poi.getUnn_descri()==null?"":t_jw_poi.getUnn_descri();
}
}
} finally {
if(j!=null) {
j.close();
j = null;
}
}
*/
%>
</table>
<html:form action="com/PoiAbertoRepEntradaPedidosResumo_rForm.do" method="post" styleClass="baseForm">
  <table class="itemTable"  style=" width:;">
    <html:hidden property="ano"/>
    <html:hidden property="mes"/>
    <html:hidden property="rep_cdgo"/>
    <html:hidden property="codigo_regional"/>
    <html:hidden property="rep_rzao"/>
    <html:hidden property="flag"/>
    <html:hidden property="tipo"/>
    <html:hidden property="situacao_gerente"/>
    <html:hidden property="ano_final"/>
    <html:hidden property="mes_final"/>
    <html:hidden property="codigo_marca"/>
    <table class="buttonTable" style='width:99%;'>
      <tr class="buttonTr">
        <td class="buttonTd">
          <%
          if(!(request.getParameter("excel")+"").equals("true")){
            %>
            <html:submit accesskey="p" value="pop" styleClass="myhidden" property="pop_action">
            </html:submit>
            <%
          }
          %>
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

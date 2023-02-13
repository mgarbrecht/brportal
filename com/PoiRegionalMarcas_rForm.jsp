<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      <%= (String)request.getParameter("tipo") %>
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(96)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            portalbr.com.PoiRegionalMarcas_rActionForm PoiRegionalMarcas_rActionForm = (portalbr.com.PoiRegionalMarcas_rActionForm)session.getAttribute("PoiRegionalMarcas_rActionForm");
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

            portalbr.dbobj.view.Jw_poi_registros t_jw_poi_registros = new portalbr.dbobj.view.Jw_poi_registros();
            java.util.Vector res_Jw_poi_registros = null;
            double prev_cotas            		= 0;
            int faturado                 		= 0;
            int contador                 		= 0;
            double cotas                 		= 0;
            int contador_marca           		= 0;
            double previsto_reais        		= 0;
            double total_reais_faturado  		= 0;
            double total_reais_a_faturar 		= 0;
            double total_reais_realizado 		= 0;
            double total_pares_a_faturar 		= 0;
            double total_pares_realizado 		= 0;
            double total_media_dia      		= 0;
            double total_media_rep       		= 0;
            int counterbl_report_Jw_poi         = 0;
            com.egen.util.jdbc.JdbcUtil j       = null;
            java.util.Vector res_Jw_poi_marcas2 = null;

            portalbr.dbobj.view.Jw_poi_marcas t_jw_poi_marcas = new portalbr.dbobj.view.Jw_poi_marcas();
            String rep_rzao      = "";
            String regional      = "null";
            String marca_p       = "null";
            String representante = "null";
            String gerente       = "null";
            String mes = PoiRegionalMarcas_rActionForm.getMes();
            String ano = PoiRegionalMarcas_rActionForm.getAno();
            if(PoiRegionalMarcas_rActionForm.getCodigo_regional()!="" &&
            (!(PoiRegionalMarcas_rActionForm.getCodigo_regional().equals("0")))) {
              regional = PoiRegionalMarcas_rActionForm.getCodigo_regional();
            }
            if(PoiRegionalMarcas_rActionForm.getMarca()!="") {
              marca_p = PoiRegionalMarcas_rActionForm.getMarca();
            }

            if(PoiRegionalMarcas_rActionForm.getRep_cdgo()!="") {
              representante = "'"+PoiRegionalMarcas_rActionForm.getRep_cdgo()+"'";
            }
            regional = "null";
            try {
              j = new com.egen.util.jdbc.JdbcUtil();
              //-----------------------------------------------
              if(PoiRegionalMarcas_rActionForm.getRep_cdgo()!=""){
                portalbr.dbobj.table.Rep db_object = new portalbr.dbobj.table.Rep();
                Object[][] where = {
                {"rep_cdgo","like", PoiRegionalMarcas_rActionForm.getRep_cdgo()}
                };
                String[] order  = null;
                java.util.Vector results = j.select(db_object, where, order);
                if (results!=null && results.size()>0) {
                  db_object = (portalbr.dbobj.table.Rep)results.elementAt(0);
                  rep_rzao = (db_object.getRep_rzao()!=null)?db_object.getRep_rzao()+"":"";
                }
              }

              portalbr.dbobj.view.Jw_poi t_jw_poi = new portalbr.dbobj.view.Jw_poi();
              java.util.Vector res_Jw_poi = (java.util.Vector)session.getAttribute("res_Jw_poi");
              if (res_Jw_poi!=null && res_Jw_poi.size()>0) { //if ifres_Jw_poi
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
              int i_bl_report_Jw_poi               =  0;
              t_jw_poi = (portalbr.dbobj.view.Jw_poi)res_Jw_poi.elementAt(i_bl_report_Jw_poi);
              codigo_regional = t_jw_poi.getCodigo_regional();
              nome_regional   = t_jw_poi.getNome_regional()==null?"":t_jw_poi.getNome_regional();
              codigo_gerente  = t_jw_poi.getCodigo_gerente();
              nome_gerente    = t_jw_poi.getNome_gerente()==null?"":t_jw_poi.getNome_gerente();
              endereco        = t_jw_poi.getEndereco()==null?"":t_jw_poi.getEndereco();
              estado_gerente  = t_jw_poi.getEstado_gerente()==null?"":t_jw_poi.getEstado_gerente();
              unidade_negocio = t_jw_poi.getUnidade_negocio()==null?"":t_jw_poi.getUnidade_negocio();
              unn_descri      = t_jw_poi.getUnn_descri()==null?"":t_jw_poi.getUnn_descri();
              Integer cdGerenteOld = null;

              while (i_bl_report_Jw_poi < res_Jw_poi.size() ) { // while ww1
              if(cdGerenteOld == null || cdGerenteOld.intValue() != codigo_gerente.intValue() ) { //if gerenteOld
              %>
              <table id="TRbl_report_Jw_poi" class="reportTable" style=width:99%;  border=1;  frame=box>
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
                <!--
                  <tr class="reportHeader3" > <td colspan=2> Analista : <%= ((codigo_gerente!=null)?codigo_gerente.toString():"") %> - <%= nome_gerente %> </td> <td> Endereço : <%= endereco %> </td> <td> UF : <%= estado_gerente %> </td> </tr>
                -->
                <%
                if(PoiRegionalMarcas_rActionForm.getRep_cdgo()!=""){
                  %>
                  <tr class="reportHeader3" >
                    <td colspan=4>
                      Representante :
                      <%= PoiRegionalMarcas_rActionForm.getRep_cdgo() %>
                      -
                      <%= rep_rzao %>
                    </td>
                  </tr>
                  <%
                }
                %>
                <tr class="reportHeader3">
                  <td  colspan=4>
                    Período : de
                    <%= PoiRegionalMarcas_rActionForm.getMes() %>
                    /
                    <%= PoiRegionalMarcas_rActionForm.getAno() %>
                    a
                    <%= PoiRegionalMarcas_rActionForm.getMes_final() %>
                    /
                    <%= PoiRegionalMarcas_rActionForm.getAno_final() %>
                  </td>
                </tr>
              </table>
              <%
            }
            counterbl_report_Jw_poi++;
            %>
            <table id="TRbl_report_Jw_poi" class="reportTable" style="width:99%";  border=1; frame=box;>
              <!--
                <tr class="reportHeader2"> <td class="reportColumn" style="text-align:left;"> Unidade : <%= unidade_negocio %> - <%= unn_descri %> </td> </tr>
              -->
              <table id="TRbl_report_Jw_poi_registros" class="reportTable" style="width:99%"; border=1; >
                <%
                //ss
                int counterbl_report_Jw_poi_registros = 0;

                try {

                  StringBuilder query = new StringBuilder();
                  query.append(" SELECT mp.codigo_marca || '-' || mp.descricao_marca marca ");
                  query.append("      , '' unidade_negocio ");
                  query.append("      , 0 media_dia ");
                  query.append("      , 0 medi_rep ");
                  query.append("      , sum(t.total_reais_previsto) / ");
                  query.append("                decode(sum(t.total_pares_previsto), 0, 1, ");
                  query.append("                sum(t.total_pares_previsto)) preco_previsto ");
                  query.append("      , (sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar)) / ");
                  //ATRASO                            query.append("      , (sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar) - sum(t.total_reais_atraso)) / ");
                  query.append("                decode((sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)), 0, 1, ");
                  query.append("                sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)) preco_realizado ");
                  query.append("      , round(decode(sum(t.total_reais_previsto) / decode(sum(t.total_pares_previsto), 0,1,sum(t.total_pares_previsto)) ");
                  query.append("                ,0,0,(( sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar) ) / ");
                  query.append("                decode(sum(t.total_pares_faturado) +  sum(t.total_pares_a_faturar), ");
                  query.append("                0, 1, sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)) * 100) ");
                  query.append("                / ( sum(t.total_reais_previsto) / decode(sum(t.total_pares_previsto), ");
                  query.append("                0,1,sum(t.total_pares_previsto)) )-100 )) dif_preco ");
                  query.append("      , sum(t.total_reais_faturado) reais_faturado ");
                  query.append("      , sum(t.total_reais_a_faturar)-sum(t.total_reais_atraso) reais_a_faturar ");
                  query.append("      , sum(t.total_reais_previsto) reais_previsto ");
                  query.append("      , sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar) - sum(t.total_reais_atraso) reais_realizado ");
                  query.append("      , decode(sum(t.total_reais_previsto),0,0,((sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar)- sum(t.total_reais_atraso)) * 100) / sum(t.total_reais_previsto)) dif_reais ");
                  query.append("      , sum(t.total_pares_faturado) pares_faturado ");
                  query.append("      , sum(t.total_pares_previsto) pares_previsto ");
                  query.append("      , sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar) pares_realizado ");
                  query.append("      , sum(t.total_pares_a_faturar) pares_a_faturar ");
                  query.append("      , decode(sum(t.total_pares_previsto), 0, 0, ((sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)) * 100) /sum(t.total_pares_previsto)) dif_pares ");
                  query.append("      , avg(prazo_medio) prazo_medio ");
                  query.append("   FROM brio.cotas_linhas_reais t ");
                  query.append("      , brio.marcas_produtos mp ");
                  query.append("      , brio.rep  ");
                  query.append("  WHERE t.codigo_linha     = 999 ");
                  query.append("    AND t.emp_empresa      = '01' ");
                  query.append("    AND rep.rep_cdgo       = t.codigo_representante    ");
                  query.append("    AND t.codigo_gerente   = nvl(" + codigo_gerente+""+",t.codigo_gerente)");
                  query.append("    AND ( ");
                  query.append("          (t.mes_venda_reais  >= ").append(PoiRegionalMarcas_rActionForm.getMes()).append(" and t.ano_venda_reais >= ").append(PoiRegionalMarcas_rActionForm.getAno()).append(") ");
                  query.append("          and ");
                  query.append("          (t.mes_venda_reais  <= ").append(PoiRegionalMarcas_rActionForm.getMes_final()).append(" and t.ano_venda_reais <= ").append(PoiRegionalMarcas_rActionForm.getAno_final()).append(") ");
                  query.append("        ) ");
                  query.append("    AND rep.rep_cdgo       = nvl("+representante+",rep.rep_cdgo) ");
                  query.append("    AND mp.codigo_marca    = nvl("+marca_p+",mp.codigo_marca) ");
                  query.append("    AND t.codigo_marca     = mp.codigo_marca ");
                  query.append("  GROUP BY t.codigo_marca ");
                  query.append("         , mp.codigo_marca ");
                  query.append("         , mp.descricao_marca ");



                  res_Jw_poi_registros = j.select( t_jw_poi_registros
                  , query.toString()
                  , null);

                } catch (Exception e){
                  session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                }
                if (res_Jw_poi_registros!=null && res_Jw_poi_registros.size()>0) { // if if7
                java.lang.String marca            =  null;
                java.lang.String unidade_negocio1 =  null;
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

                t_jw_poi_registros = (portalbr.dbobj.view.Jw_poi_registros)res_Jw_poi_registros.elementAt(i_bl_report_Jw_poi_registros);
                marca = t_jw_poi_registros.getMarca()==null?"":t_jw_poi_registros.getMarca();
                unidade_negocio1 = t_jw_poi_registros.getUnidade_negocio()==null?"":t_jw_poi_registros.getUnidade_negocio();
                preco_previsto   = t_jw_poi_registros.getPreco_previsto();
                preco_realizado  = t_jw_poi_registros.getPreco_realizado();

                dif_preco        = t_jw_poi_registros.getDif_preco();
                reais_faturado   = t_jw_poi_registros.getReais_faturado();
                reais_a_faturar  = t_jw_poi_registros.getReais_a_faturar();
                reais_previsto   = t_jw_poi_registros.getReais_previsto();
                reais_realizado  = t_jw_poi_registros.getReais_realizado();
                dif_reais        = t_jw_poi_registros.getDif_reais();
                pares_faturado   = t_jw_poi_registros.getPares_faturado();
                pares_previsto   = t_jw_poi_registros.getPares_previsto();
                pares_realizado  = t_jw_poi_registros.getPares_realizado();
                pares_a_faturar  = t_jw_poi_registros.getPares_a_faturar();
                dif_pares        = t_jw_poi_registros.getDif_pares();
                prazo_medio      = t_jw_poi_registros.getPrazo_medio();
                media_dia        = t_jw_poi_registros.getMedia_dia();
                media_rep        = t_jw_poi_registros.getMedia_rep();
                total_media_dia       += media_dia;
                total_media_rep       += media_rep;
                faturado              += pares_faturado;
                previsto_reais        += reais_previsto;
                cotas                 += pares_previsto;
                total_reais_faturado  += reais_faturado;
                total_reais_a_faturar += reais_a_faturar;
                total_reais_realizado += reais_realizado;
                total_pares_a_faturar += pares_a_faturar;
                total_pares_realizado += pares_realizado;
                %>
                <tr class="reportHeader" >
                  <td>
                  </td>
                  <%
                  if(PoiRegionalMarcas_rActionForm.getRep_cdgo()==""){
                    %>
                    <td align="center" colspan="5">
                      <b>
                        Pares
                      </b>
                    </td>
                    <%}else { %>
                      <td align="center" colspan="5">
                        <b>
                          Pares
                        </b>
                      </td>
                      <%} %>
                        <td align="center" colspan="5">
                          <b>
                            Reais
                          </b>
                        </td>
                        <td align="center" colspan="3">
                          <b>
                            Preço Médio
                          </b>
                        </td>
                      </tr>
                      <tr class="reportHeader" >
                        <td class="columnTdHeader" style="text-align:left;">
                          Marca
                        </td>
                        <td class="columnTdHeader" style="text-align:right;" colspan="1">
                          Prev.
                        </td>
                        <td class="columnTdHeader" style="text-align:right;" colspan="1">
                          Real.
                        </td>
                        <td class="columnTdHeader" style="text-align:right;" colspan="1">
                          %
                        </td>
                        <td class="columnTdHeader" style="text-align:right;" colspan="1">
                          Fatur.
                        </td>
                        <td class="columnTdHeader" style="text-align:right;" colspan="1">
                          A Fatur.
                        </td>
                        <td class="columnTdHeader" style="text-align:right;" colspan="1">
                          Prev.
                        </td>
                        <td class="columnTdHeader" style="text-align:right;" colspan="1">
                          Real.
                        </td>
                        <td class="columnTdHeader" style="text-align:right;" colspan="1">
                          %
                        </td>
                        <td class="columnTdHeader" style="text-align:right;" colspan="1">
                          Fatur.
                        </td>
                        <td class="columnTdHeader" style="text-align:right;" colspan="1">
                          A Fatur.
                        </td>
                        <td class="columnTdHeader" style="text-align:right;" colspan="1">
                          Prev.
                        </td>
                        <td class="columnTdHeader" style="text-align:right;" colspan="1">
                          Real.
                        </td>
                        <td class="columnTdHeader" style="text-align:right;" colspan="1">
                          %
                        </td>
                        <!--
                          <% if(PoiRegionalMarcas_rActionForm.getRep_cdgo()==""){ %> <td class="columnTdHeader" style="text-align:right;" colspan="1"> Média Dia </td> <td class="columnTdHeader" style="text-align:right;" colspan="1"> Média <br> Repres. </td> <%} %> <td class="columnTdHeader" style="text-align:right;" colspan="1"> Prazo </td>
                        -->
                      </tr>
                      <%
                      while (i_bl_report_Jw_poi_registros<res_Jw_poi_registros.size()) { //while ww4
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
                          <%= marca %>
                        </td>
                        <td class="reportColumn" style="text-align:right;" colspan="1">
                          <%= com.egen.util.text.FormatNumber.format(pares_previsto, "##,##0") %>
                        </td>
                        <td class="reportColumn" style="text-align:right;" colspan="1">
                          <%= com.egen.util.text.FormatNumber.format(pares_realizado, "##,##0") %>
                        </td>
                        <td class="reportColumn" style="text-align:right;" colspan="1">
                          <%
                          dif_pares-=100;
                        if(pares_previsto==0 && pares_realizado>0){dif_pares=100;}
                      if(pares_previsto>0 && pares_realizado==0){dif_pares=0;}
                    if(pares_previsto==0 && pares_realizado==0){dif_pares=0;}
                    %>
                    <%= com.egen.util.text.FormatNumber.format(dif_pares, "##,##0.00") %>
                  </td>
                  <td class="reportColumn" style="text-align:right;" colspan="1">
                    <%= com.egen.util.text.FormatNumber.format(pares_faturado, "##,##0") %>
                  </td>
                  <td class="reportColumn" style="text-align:right;" colspan="1">
                    <%= com.egen.util.text.FormatNumber.format(pares_a_faturar, "##,##0") %>
                  </td>
                  <td class="reportColumn" style="text-align:right;" colspan="1">
                    <%= com.egen.util.text.FormatNumber.format(reais_previsto, "##,##0.00") %>
                  </td>
                  <td class="reportColumn" style="text-align:right;" colspan="1">
                    <%=com.egen.util.text.FormatNumber.format(reais_realizado,"##,##0.00") %>
                  </td>
                  <td class="reportColumn" style="text-align:right;" colspan="1">
                    <%
                    dif_reais-=100;
                  if(reais_previsto==0 && reais_realizado>0){dif_reais=100;}
                if(reais_previsto>0 && reais_realizado==0){dif_reais=0;}
              if(reais_previsto==0 && reais_realizado==0){dif_reais=0;}
              %>
              <%= com.egen.util.text.FormatNumber.format(dif_reais, "##,##0.00") %>
            </td>
            <td class="reportColumn" style="text-align:right;" colspan="1">
              <%= com.egen.util.text.FormatNumber.format(reais_faturado, "##,##0.00") %>
            </td>
            <td class="reportColumn" style="text-align:right;" colspan="1">
              <%= com.egen.util.text.FormatNumber.format(reais_a_faturar, "##,##0.00") %>
            </td>
            <td class="reportColumn" style="text-align:right;" colspan="1">
              <%= com.egen.util.text.FormatNumber.format(preco_previsto, "##,##0.00") %>
            </td>
            <td class="reportColumn" style="text-align:right;" colspan="1">
              <%= com.egen.util.text.FormatNumber.format(preco_realizado, "##,##0.00") %>
            </td>
            <td class="reportColumn" style="text-align:right;" colspan="1">
              <%
              dif_preco = (100 * (double)(preco_realizado / preco_previsto))-100;
              %>
              <%
            if(preco_previsto==0 && preco_realizado>0){dif_preco=100;}
          if(preco_previsto>0 && preco_realizado==0){dif_preco=0;}
          %>
          <%= com.egen.util.text.FormatNumber.format(dif_preco, "##,##0.00") %>
        </td>

        <!--
          <% if(PoiRegionalMarcas_rActionForm.getRep_cdgo()==""){ %> <td class="reportColumn" style="text-align:right;" colspan="1"> <%= com.egen.util.text.FormatNumber.format(media_dia, "##,##0.00") %> 0.00 </td> <td class="reportColumn" style="text-align:right;" colspan="1"> <%= com.egen.util.text.FormatNumber.format(media_rep, "##,##0.00") %> 0.00 </td> <%}%> <td class="reportColumn" style="text-align:right;" colspan="1"> <%= com.egen.util.text.FormatNumber.format(prazo_medio, "##,##0.00") %> </td>
        -->

      </tr>
      <%
      if (++i_bl_report_Jw_poi_registros >= res_Jw_poi_registros.size()) {
        break;
      }
      t_jw_poi_registros = (portalbr.dbobj.view.Jw_poi_registros)res_Jw_poi_registros.elementAt(i_bl_report_Jw_poi_registros);
      marca = t_jw_poi_registros.getMarca()==null?"":t_jw_poi_registros.getMarca();
      unidade_negocio1 = t_jw_poi_registros.getUnidade_negocio()==null?"":t_jw_poi_registros.getUnidade_negocio();
      preco_previsto   = t_jw_poi_registros.getPreco_previsto();
      preco_realizado  = t_jw_poi_registros.getPreco_realizado();
      dif_preco        = t_jw_poi_registros.getDif_preco();
      reais_faturado   = t_jw_poi_registros.getReais_faturado();
      reais_a_faturar  = t_jw_poi_registros.getReais_a_faturar();
      reais_previsto   = t_jw_poi_registros.getReais_previsto();
      reais_realizado  = t_jw_poi_registros.getReais_realizado();
      dif_reais        = t_jw_poi_registros.getDif_reais();
      pares_faturado   = t_jw_poi_registros.getPares_faturado();
      pares_previsto   = t_jw_poi_registros.getPares_previsto();
      pares_realizado  = t_jw_poi_registros.getPares_realizado();
      pares_a_faturar  = t_jw_poi_registros.getPares_a_faturar();
      dif_pares        = t_jw_poi_registros.getDif_pares();
      prazo_medio      = t_jw_poi_registros.getPrazo_medio();
      total_media_dia       += media_dia;
      total_media_rep       += media_rep;
      faturado              += pares_faturado;
      previsto_reais        += reais_previsto;
      cotas                 += pares_previsto;
      total_pares_a_faturar += pares_a_faturar;
      total_reais_faturado  += reais_faturado;
      total_reais_a_faturar += reais_a_faturar;
      total_reais_realizado += reais_realizado;
      total_pares_realizado += pares_realizado;

      } //fim while ww4

      // if(++contador == res_Jw_poi.size()) { // if if++contador
      if(true){

        prev_cotas      = previsto_reais / (cotas==0?1:cotas);

        double total_realizado     = total_reais_realizado/total_pares_realizado;

        double preco_dif  = ((total_realizado * 100) / (prev_cotas==0?1:prev_cotas))-100;

      if(prev_cotas==0 && total_realizado>0){preco_dif=100;}
    if(prev_cotas>0 && total_realizado==0){preco_dif=0;}
  if(prev_cotas==0 && total_realizado==0){preco_dif=0;}

  double reais_perc =  (total_reais_realizado * 100) / previsto_reais;
  double pares_perc =  (total_pares_realizado * 100) / cotas;
  %>

  <%
  if(tipo.equals("AREAS") || tipo.equals("")){
    %>
    <tr class="reportHeader2">
      <td class="reportColumn" style="text-align:left;">
        Total
        <br>
        <%
        if((PoiRegionalMarcas_rActionForm.getAgrupa_regionais()+"").equals("S")){
          %>
          Geral
          <%
        } else {
          %>
          <%
          if(PoiRegionalMarcas_rActionForm.getFlag().equals("1")) {
            %>
            da Regional
            <%
          } else {
            %>
            do Representante
            <%
          }
          %>
          <%
        }
        %>
      </td>
      <%
      if(PoiRegionalMarcas_rActionForm.getFlag().equals("1")
      ||
      PoiRegionalMarcas_rActionForm.getFlag().equals("3")
      ) {
        %>
        <td class="reportColumn" style="text-align:right;" colspan="1">
          <%= com.egen.util.text.FormatNumber.format(cotas, "##,##0") %>
        </td>
        <td class="reportColumn" style="text-align:right;" colspan="1">
          <%= com.egen.util.text.FormatNumber.format(total_pares_realizado, "##,##0") %>
        </td>
        <td class="reportColumn" style="text-align:right;" colspan="1">
          <%
          pares_perc-=100;
        if(cotas==0 && total_pares_realizado>0){pares_perc=100;}
      if(cotas>0 && total_pares_realizado==0){pares_perc=0;}
    if(cotas==0 && total_pares_realizado==0){pares_perc=0;}
    %>
    <%= com.egen.util.text.FormatNumber.format(pares_perc, "##,##0.00") %>
  </td>
  <td class="reportColumn" style="text-align:right;" colspan="1">
    <%= com.egen.util.text.FormatNumber.format(faturado, "##,##0") %>
  </td>
  <td class="reportColumn" style="text-align:right;" colspan="1">
    <%= com.egen.util.text.FormatNumber.format(total_pares_a_faturar, "##,##0") %>
  </td>
  <td class="reportColumn" style="text-align:right;" colspan="1">
    <%= com.egen.util.text.FormatNumber.format(previsto_reais, "##,##0.00") %>
  </td>
  <td class="reportColumn" style="text-align:right;" colspan="1">
    <%= com.egen.util.text.FormatNumber.format(total_reais_realizado, "##,##0.00") %>
  </td>
  <td class="reportColumn" style="text-align:right;" colspan="1">
    <%
    reais_perc-=100;
  if(previsto_reais==0 && total_reais_realizado>0){reais_perc=100;}
if(previsto_reais>0 && total_reais_realizado==0){reais_perc=0;}
if(previsto_reais==0 && total_reais_realizado==0){reais_perc=0;}
%>
<%= com.egen.util.text.FormatNumber.format(reais_perc, "##,##0.00") %>
</td>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(total_reais_faturado, "##,##0.00") %>
</td>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(total_reais_a_faturar, "##,##0.00") %>
</td>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(prev_cotas, "##,##0.00") %>
</td>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(total_realizado, "##,##0.00") %>
</td>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(preco_dif, "##,##0.00") %>

</td>
<%
} else {
%>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(0, "0") %>
</td>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(0, "0") %>
</td>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(0, "##,##0.00") %>
</td>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(0, "0") %>
</td>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(0, "0") %>
</td>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(0, "##,##0.00") %>
</td>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(0, "##,##0.00") %>
</td>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(0, "##,##0.00") %>
</td>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(0, "##,##0.00") %>
</td>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(100, "##,##0.00") %>
</td>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(0, "##,##0.00") %>
</td>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(0, "##,##0.00") %>
</td>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(100, "##,##0.00") %>
</td>
<%
}
%>
<!--
<% if(PoiRegionalMarcas_rActionForm.getRep_cdgo()==""){ %> <td class="reportColumn" style="text-align:right;" colspan="1"> <%= com.egen.util.text.FormatNumber.format(total_media_dia, "##,##0.00") %> 0 </td> <td class="reportColumn" style="text-align:right;" colspan="1"> <%= com.egen.util.text.FormatNumber.format(total_media_rep, "##,##0.00") %> 0 </td> <% } %> <td class="reportColumn" style="text-align:right;" colspan="1"> </td>
-->
</tr>
<%
}
%>
<%
total_media_dia       = 0;
total_media_rep       = 0;
faturado              = 0;
previsto_reais        = 0;
cotas                 = 0;
total_pares_a_faturar = 0;
total_reais_faturado  = 0;
total_reais_a_faturar = 0;
total_reais_realizado = 0;
total_pares_realizado = 0;
%>
<%
} //fim do if++contador
}
%>
</table>
</table>
<%
if (++i_bl_report_Jw_poi >= res_Jw_poi.size()) {
  break;
}
t_jw_poi = (portalbr.dbobj.view.Jw_poi)res_Jw_poi.elementAt(i_bl_report_Jw_poi);
codigo_regional = t_jw_poi.getCodigo_regional();
nome_regional   = t_jw_poi.getNome_regional()==null?"":t_jw_poi.getNome_regional();
cdGerenteOld    = codigo_gerente;
codigo_gerente  = t_jw_poi.getCodigo_gerente();
nome_gerente    = t_jw_poi.getNome_gerente()==null?"":t_jw_poi.getNome_gerente();
endereco        = t_jw_poi.getEndereco()==null?"":t_jw_poi.getEndereco();
estado_gerente  = t_jw_poi.getEstado_gerente()==null?"":t_jw_poi.getEstado_gerente();
unidade_negocio = t_jw_poi.getUnidade_negocio()==null?"":t_jw_poi.getUnidade_negocio();
unn_descri      = t_jw_poi.getUnn_descri()==null?"":t_jw_poi.getUnn_descri();

}  //fim do while ww1
}//if ifres_Jw_poi
} catch (Exception e){
e.printStackTrace();
} finally {
if(j!=null) {
  j.close();
  j = null;
}
}
%>
</table>
<!-- primeira table dentro do ww1-->

<html:form action="com/PoiRegionalMarcas_rForm.do" method="post" styleClass="baseForm">
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
    <html:hidden property="marca"/>
    <html:hidden property="agrupa_regionais"/>
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
            <html:button accesskey="a" onclick="history.go(-1);" styleClass="baseButton" property="back1_action">
              <bean:message bundle="ApplicationResources" key="jsp.back"/>
            </html:button>
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

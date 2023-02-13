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
                </td>

              </tr>

            </table>

            <%
            portalbr.com.PoiAbertoRepresentanteRep_rActionForm PoiAbertoRepresentanteRep_rActionForm = (portalbr.com.PoiAbertoRepresentanteRep_rActionForm)session.getAttribute("PoiAbertoRepresentanteRep_rActionForm");
            java.util.Vector res_Jw_poi = (java.util.Vector)session.getAttribute("res_Jw_poi_aberto_representante");
            if (res_Jw_poi!=null && res_Jw_poi.size()>0) {

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
              portalbr.dbobj.view.Jw_poi_aberto_rep_r t_jw_total_rep = new portalbr.dbobj.view.Jw_poi_aberto_rep_r();
              java.util.Vector res_Jw_poi_registros = null;
              java.util.Vector res = null;
              java.util.Vector res_total_rep = null;
              java.util.Vector res_teste = null;
              int contador_rep   = 0;
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
              String rep_cdgo_anterior       = "";
              String nome_marca_anterior     = "";
              double previsto_reais          = 0;
              double total_reais_faturado    = 0;
              double total_reais_a_faturar   = 0;
              double total_reais_realizado   = 0;
              double total_pares_a_faturar   = 0;
              double total_pares_realizado   = 0;
              double total_media_dia         = 0;
              double total_media_rep         = 0;
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
              int counterbl_report_Jw_poi=0;

              com.egen.util.jdbc.JdbcUtil j = null;
              java.util.Vector res_Jw_poi_marcas2 = null;
              portalbr.dbobj.view.Jw_poi_marcas t_jw_poi_marcas = new portalbr.dbobj.view.Jw_poi_marcas();
              String rep_rzao_cab  = "";
              String regional      = "null";
              String representante = "";
              String pmarca         = "";
              String mes = PoiAbertoRepresentanteRep_rActionForm.getMes();
              String ano = PoiAbertoRepresentanteRep_rActionForm.getAno();

              if(PoiAbertoRepresentanteRep_rActionForm.getCodigo_regional()!=""){
                regional = PoiAbertoRepresentanteRep_rActionForm.getCodigo_regional();
              }
              if(PoiAbertoRepresentanteRep_rActionForm.getRep_cdgo()!="" &&
              PoiAbertoRepresentanteRep_rActionForm.getRep_cdgo()!="null"){
                representante = " and  r.rep_cdgo in("+PoiAbertoRepresentanteRep_rActionForm.getRep_cdgo()+") ";
              }

              if(PoiAbertoRepresentanteRep_rActionForm.getCodigo_marca()!="" &&
              PoiAbertoRepresentanteRep_rActionForm.getCodigo_marca()!="null"){
                pmarca = " and  t.codigo_marca = " + PoiAbertoRepresentanteRep_rActionForm.getCodigo_marca();
              }
              try{
                j = new com.egen.util.jdbc.JdbcUtil();
                if(PoiAbertoRepresentanteRep_rActionForm.getRep_cdgo()!=""){
                  portalbr.dbobj.table.Rep db_object = new portalbr.dbobj.table.Rep();
                  Object[][] where = {
                  {"rep_cdgo","like", PoiAbertoRepresentanteRep_rActionForm.getRep_cdgo()}
                  };
                  java.util.Vector results = j.select(db_object, where, null);
                  if (results!=null && results.size()>0) {
                    db_object = (portalbr.dbobj.table.Rep)results.elementAt(0);
                    rep_rzao_cab = (db_object.getRep_rzao()!=null)?db_object.getRep_rzao()+"":"";
                  }
                }

                portalbr.dbobj.view.Jw_poi_aberto_representante t_jw_poi = new portalbr.dbobj.view.Jw_poi_aberto_representante();
                if (res_Jw_poi!=null && res_Jw_poi.size()>0) {
                  java.lang.Integer codigo_regional    =  null;
                  java.lang.String nome_regional       =  null;
                  java.lang.Integer codigo_gerente     =  null;
                  java.lang.String nome_gerente        =  null;
                  java.lang.String endereco            =  null;
                  java.lang.String estado_gerente      =  null;
                  java.lang.String rep_cdgo            =  null;
                  java.lang.String rep_rzao            =  null;
                  java.lang.Integer b0_codigo_regional =  null;
                  java.lang.String b2_unidade_negocio  =  null;
                  java.lang.String desc_marca          =  "";
                  int i_bl_report_Jw_poi = 0;
                  t_jw_poi = (portalbr.dbobj.view.Jw_poi_aberto_representante)res_Jw_poi.elementAt(i_bl_report_Jw_poi);
                  codigo_regional = t_jw_poi.getCodigo_regional();
                  nome_regional   = t_jw_poi.getNome_regional()==null?"":t_jw_poi.getNome_regional();
                  codigo_gerente  = t_jw_poi.getCodigo_gerente();
                  nome_gerente    = t_jw_poi.getNome_gerente()==null?"":t_jw_poi.getNome_gerente();
                  endereco        = t_jw_poi.getEndereco()==null?"":t_jw_poi.getEndereco();
                  estado_gerente  = t_jw_poi.getEstado_gerente()==null?"":t_jw_poi.getEstado_gerente();
                  rep_cdgo        = t_jw_poi.getRep_cdgo()==null?"":t_jw_poi.getRep_cdgo();
                  rep_rzao        = t_jw_poi.getRep_rzao()==null?"":t_jw_poi.getRep_rzao();

                  Integer cdGerenteOld = null;
                  while (i_bl_report_Jw_poi<res_Jw_poi.size()) {
                    if(cdGerenteOld == null || cdGerenteOld.intValue() != codigo_gerente.intValue()) {
                      %>
                      <table id="TRbl_report_Jw_poi" class="reportTable" style="width:99%"; border=1; frame=box>
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
                        if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                          %>
                          <!--
                            <tr class="reportHeader3" > <td colspan=2> Analista : <%= ((codigo_gerente!=null)?codigo_gerente.toString():"") %> - <%= nome_gerente %> </td> <td> Endereço : <%= endereco %> </td> <td> UF : <%= estado_gerente %> </td> </tr>
                          -->
                          <%
                        }
                        if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                          if(PoiAbertoRepresentanteRep_rActionForm.getRep_cdgo()!="") {
                            %>
                            <tr class="reportHeader3" >
                              <td colspan=4>
                                Representante :
                                <%= PoiAbertoRepresentanteRep_rActionForm.getRep_cdgo() %>
                                -
                                <%= rep_rzao_cab %>
                              </td>
                            </tr>
                            <%
                          }
                        }
                        %>
                        <tr class="reportHeader3">
                          <td  colspan=4>
                            Período : de
                            <%= PoiAbertoRepresentanteRep_rActionForm.getMes() %>
                            /
                            <%= PoiAbertoRepresentanteRep_rActionForm.getAno() %>
                            a
                            <%= PoiAbertoRepresentanteRep_rActionForm.getMes_final() %>
                            /
                            <%= PoiAbertoRepresentanteRep_rActionForm.getAno_final() %>
                          </td>
                        </tr>
                      </table>
                      <%
                      }  counterbl_report_Jw_poi++;  desc_marca = t_jw_poi.getDesc_marca()==null?"":t_jw_poi.getDesc_marca();
                      %>
                      <table id="TRbl_report_Jw_poi" class="reportTable" style="width:99%";  border=1; frame=box;>
                        <%
                        if((!(rep_cdgo_anterior.equals(rep_cdgo)))) {
                          contador_rep = 0;
                          StringBuilder query = new StringBuilder();
                          query.append(" SELECT t.codigo_representante ");
                          query.append("      , r.rep_rzao ");
                          query.append("      , mp.codigo_marca || '-' || mp.descricao_marca marca ");
                          query.append("      , t.unidade_negocio || ' - ' || unn_descri unidade_negocio ");
                          query.append("      , 0 media_dia ");
                          query.append("      , 0 media_rep ");
                          query.append("      , sum(t.total_reais_previsto) / ");
                          query.append("                decode(sum(t.total_pares_previsto), 0, 1, ");
                          query.append("                sum(t.total_pares_previsto)) preco_previsto ");
                          query.append("      , (sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar)) / ");
                          //ATRASO             query.append("      , (sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar) - sum(t.total_reais_atraso)) / ");
                          query.append("                decode((sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)), 0, 1, ");
                          query.append("                sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)) preco_realizado ");
                          query.append("      , (((sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar)) / ");
                          query.append("           decode(sum(t.total_pares_faturado) +  sum(t.total_pares_a_faturar), ");
                          query.append("           0, 1, sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)) * 100) / ");
                          query.append("           (decode(sum(t.total_reais_previsto),0, 1, sum(t.total_reais_previsto)) / ");
                          query.append("           decode(sum(t.total_pares_previsto), 0,1,sum(t.total_pares_previsto))) - 100) dif_preco ");
                          query.append("      , sum(t.total_reais_faturado) reais_faturado ");
                          query.append("      , sum(t.total_reais_a_faturar)- sum(t.total_reais_atraso) reais_a_faturar ");
                          query.append("      , sum(t.total_reais_previsto) reais_previsto ");
                          query.append("      , sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar) - sum(t.total_reais_atraso)  reais_realizado ");
                          query.append("      , ((sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar)- sum(t.total_reais_atraso)) * 100) / ");
                          query.append("                (decode(sum(t.total_reais_previsto),0,1, sum(t.total_reais_previsto))) dif_reais ");
                          query.append("      , sum(t.total_pares_faturado) pares_faturado ");
                          query.append("      , sum(t.total_pares_previsto) pares_previsto ");
                          query.append("      , sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar) pares_realizado ");
                          query.append("      , sum(t.total_pares_a_faturar) pares_a_faturar ");
                          query.append("      , ((sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)) * 100) / ");
                          query.append("                decode(sum(t.total_pares_previsto), 0, 1, sum(t.total_pares_previsto)) dif_pares ");
                          query.append("      , avg(prazo_medio) prazo_medio ");
                          query.append("   FROM cotas_linhas_reais t ");
                          query.append("      , marcas_produtos    mp ");
                          query.append("      , uni_negocio        u ");
                          query.append("      , rep r ");
                          query.append("  WHERE t.codigo_linha           = 999 ");
                          query.append("    AND t.emp_empresa            = '01' ");
                          query.append("    AND t.unidade_negocio        = u.unn_codigo ");
                          query.append("    AND t.codigo_gerente         = nvl(").append(codigo_gerente).append(", t.codigo_gerente)  ");
                          query.append("    AND ((t.mes_venda_reais  >= ").append(PoiAbertoRepresentanteRep_rActionForm.getMes()).append(" and t.ano_venda_reais >= ").append(PoiAbertoRepresentanteRep_rActionForm.getAno()).append(") ");
                          query.append("          and ");
                          query.append("        (t.mes_venda_reais  <= ").append(PoiAbertoRepresentanteRep_rActionForm.getMes_final()).append(" and t.ano_venda_reais <= ").append(PoiAbertoRepresentanteRep_rActionForm.getAno_final()).append(")) ");
                          query.append("    AND t.unidade_negocio        = nvl(").append(PoiAbertoRepresentanteRep_rActionForm.getUnidade()).append(",t.unidade_negocio)  ");
                          query.append("    AND r.rep_cdgo               = nvl(").append(rep_cdgo).append(",r.rep_cdgo) ");
                          query.append("    AND t.codigo_marca           = mp.codigo_marca ");
                          query.append("    AND r.rep_cdgo               = t.codigo_representante ");
                          query.append(pmarca);
                          query.append("  GROUP BY t.unidade_negocio || ' - ' || unn_descri ");
                          query.append("         , t.codigo_marca ");
                          query.append("         , mp.codigo_marca ");
                          query.append("         , mp.descricao_marca ");
                          query.append("         , t.codigo_representante ");
                          query.append("         , r.rep_rzao ");
                          query.append("  ORDER BY t.unidade_negocio || ' - ' || unn_descri ");
                          query.append("         , mp.descricao_marca ");

                          res = j.select(t_jw_poi_registros,
                          query.toString(),
                          null);
                          //--------------------------------------------
                          rep_cdgo_anterior = rep_cdgo;
                          %>
                          <tr class="reportHeader3">
                            <td class="reportColumn" style="text-align:left;">
                              <big>
                                Representante :
                                <%= rep_cdgo %>
                                -
                                <%= rep_rzao %>
                              </big>
                            </td>
                          </tr>
                          <%
                        }
                        %>
                        <tr class="reportHeader2">
                          <td class="reportColumn" style="text-align:left;">
                            Marca :
                            <%= desc_marca %>
                          </td>
                        </tr>
                        <table id="TRbl_report_Jw_poi_registros" class="reportTable" style="width:99%"; border=1; >
                          <%
                          int counterbl_report_Jw_poi_registros=0;
                          try {
                            StringBuilder query2 = new StringBuilder();
                            query2.append(" SELECT t.codigo_representante ");
                            query2.append("      , r.rep_rzao ");
                            query2.append("      , mp.codigo_marca || '-' || mp.descricao_marca marca ");
                            query2.append("      , t.unidade_negocio || ' - ' || unn_descri unidade_negocio ");
                            query2.append("      , 0 media_dia ");
                            query2.append("      , 0 media_rep ");
                            query2.append("      , sum(t.total_reais_previsto) / ");
                            query2.append("                decode(sum(t.total_pares_previsto), 0, 1, ");
                            query2.append("                sum(t.total_pares_previsto)) preco_previsto ");
                            query2.append("      , (sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar)) / ");
                            //ATRASO                query2.append("      , (sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar) - sum(t.total_reais_atraso)) / ");
                            query2.append("                decode((sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)), 0, 1, ");
                            query2.append("                sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)) preco_realizado ");
                            query2.append("      , (((sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar)) / ");
                            query2.append("           decode(sum(t.total_pares_faturado) +  sum(t.total_pares_a_faturar), ");
                            query2.append("           0, 1, sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)) * 100) /   ");
                            query2.append("           (decode(sum(t.total_reais_previsto),0, 1, sum(t.total_reais_previsto)) /   ");
                            query2.append("           decode(sum(t.total_pares_previsto), 0,1,sum(t.total_pares_previsto))) - 100) dif_preco ");
                            query2.append("      , sum(t.total_reais_faturado) reais_faturado ");
                            query2.append("      , sum(t.total_reais_a_faturar)- sum(t.total_reais_atraso) reais_a_faturar ");
                            query2.append("      , sum(t.total_reais_previsto) reais_previsto ");
                            query2.append("      , sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar) - sum(t.total_reais_atraso) reais_realizado ");
                            query2.append("      , ((sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar)- sum(t.total_reais_atraso)) * 100) / ");
                            query2.append("                (decode(sum(t.total_reais_previsto),0,1, sum(t.total_reais_previsto))) dif_reais ");
                            query2.append("      , sum(t.total_pares_faturado) pares_faturado ");
                            query2.append("      , sum(t.total_pares_previsto) pares_previsto ");
                            query2.append("      , sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar) pares_realizado ");
                            query2.append("      , sum(t.total_pares_a_faturar) pares_a_faturar ");
                            query2.append("      , ((sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)) * 100) / ");
                            query2.append("                decode(sum(t.total_pares_previsto), 0, 1, sum(t.total_pares_previsto)) dif_pares ");
                            query2.append("      , avg(prazo_medio) prazo_medio ");
                            query2.append("   FROM brio.cotas_linhas_reais t ");
                            query2.append("      , brio.marcas_produtos mp ");
                            query2.append("      , uni_negocio u ");
                            query2.append("      , rep r ");
                            query2.append("  WHERE t.codigo_linha           = 999    ");
                            query2.append("    AND t.emp_empresa            = '01'    ");
                            query2.append("    AND t.unidade_negocio        = u.unn_codigo ");
                            query2.append("    AND t.codigo_gerente         = nvl(").append(codigo_gerente).append(", t.codigo_gerente) ");
                            query2.append("    AND ((t.mes_venda_reais  >= ").append(PoiAbertoRepresentanteRep_rActionForm.getMes()).append(" and t.ano_venda_reais >= ").append(PoiAbertoRepresentanteRep_rActionForm.getAno()).append(") ");
                            query2.append("        and ");
                            query2.append("        (t.mes_venda_reais  <= ").append(PoiAbertoRepresentanteRep_rActionForm.getMes_final()).append(" and t.ano_venda_reais <= ").append(PoiAbertoRepresentanteRep_rActionForm.getAno_final()).append(")) ");
                            query2.append("    AND t.unidade_negocio        = nvl(").append(PoiAbertoRepresentanteRep_rActionForm.getUnidade()).append(",t.unidade_negocio) ");
                            query2.append("    AND r.rep_cdgo               = nvl(").append(rep_cdgo).append(",r.rep_cdgo) ");
                            query2.append("    AND t.codigo_marca           = mp.codigo_marca ");
                            query2.append("    AND t.codigo_marca           = ").append(desc_marca.substring(0,desc_marca.lastIndexOf("-")));
                            query2.append("    AND r.rep_cdgo               = t.codigo_representante ");
                            query2.append(pmarca);
                            query2.append("  GROUP BY t.unidade_negocio || ' - ' || unn_descri ");
                            query2.append("         , t.codigo_marca ");
                            query2.append("         , mp.codigo_marca ");
                            query2.append("         , mp.descricao_marca ");
                            query2.append("         , t.codigo_representante ");
                            query2.append("         , r.rep_rzao ");
                            query2.append("  ORDER BY t.unidade_negocio || ' - ' || unn_descri ");
                            query2.append("         , mp.descricao_marca ");

                            res_Jw_poi_registros = j.select(t_jw_poi_registros,
                            query2.toString(),
                            null);

                            StringBuilder queryt = new StringBuilder();
                            queryt.append(" SELECT t.codigo_representante ");
                            queryt.append("      , r.rep_rzao ");
                            queryt.append("      , mp.codigo_marca || '-' || mp.descricao_marca marca ");
                            queryt.append("      , t.unidade_negocio || ' - ' || unn_descri unidade_negocio ");
                            queryt.append("      , 0 media_dia ");
                            queryt.append("      , 0 media_rep ");
                            queryt.append("      , sum(t.total_reais_previsto) / ");
                            queryt.append("                decode(sum(t.total_pares_previsto), 0, 1, ");
                            queryt.append("                sum(t.total_pares_previsto)) preco_previsto ");
                            queryt.append("      , (sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar)) / ");
                            //ATRASO                queryt.append("      , (sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar) - sum(t.total_reais_atraso)) / ");
                            queryt.append("                decode((sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)), 0, 1, ");
                            queryt.append("                sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)) preco_realizado ");
                            queryt.append("      , (((sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar)) / ");
                            queryt.append("           decode(sum(t.total_pares_faturado) +  sum(t.total_pares_a_faturar), ");
                            queryt.append("           0, 1, sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)) * 100) / ");
                            queryt.append("           (decode(sum(t.total_reais_previsto),0, 1, sum(t.total_reais_previsto)) / ");
                            queryt.append("           decode(sum(t.total_pares_previsto), 0,1,sum(t.total_pares_previsto))) - 100) dif_preco ");
                            queryt.append("      , sum(t.total_reais_faturado) reais_faturado ");
                            queryt.append("      , sum(t.total_reais_a_faturar) reais_a_faturar ");
                            queryt.append("      , sum(t.total_reais_previsto) reais_previsto ");
                            queryt.append("      , sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar) - sum(t.total_reais_atraso) reais_realizado ");
                            queryt.append("      , ((sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar) - sum(t.total_reais_atraso)) * 100) / ");
                            queryt.append("                (decode(sum(t.total_reais_previsto),0,1, sum(t.total_reais_previsto))) dif_reais ");
                            queryt.append("      , sum(t.total_pares_faturado) pares_faturado ");
                            queryt.append("      , sum(t.total_pares_previsto) pares_previsto ");
                            queryt.append("      , sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar) - ");
                            queryt.append("                sum(t.total_pares_atraso) pares_realizado ");
                            queryt.append("      , sum(t.total_pares_a_faturar) pares_a_faturar ");
                            queryt.append("      , ((sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)) * 100) / ");
                            queryt.append("                decode(sum(t.total_pares_previsto), 0, 1, sum(t.total_pares_previsto)) dif_pares ");
                            queryt.append("      , avg(prazo_medio) prazo_medio ");
                            queryt.append("   FROM brio.cotas_linhas_reais t ");
                            queryt.append("      , brio.marcas_produtos mp ");
                            queryt.append("      , uni_negocio u ");
                            queryt.append("      , rep r ");
                            queryt.append("  WHERE t.codigo_linha     = 999 ");
                            queryt.append("    AND t.emp_empresa      = '01' ");
                            queryt.append("    AND t.unidade_negocio  = u.unn_codigo ");
                            queryt.append("    AND t.codigo_gerente   = nvl(").append(codigo_gerente).append(", t.codigo_gerente) ");
                            queryt.append("    AND ((t.mes_venda_reais  >= ").append(PoiAbertoRepresentanteRep_rActionForm.getMes()).append(" and t.ano_venda_reais >= ").append(PoiAbertoRepresentanteRep_rActionForm.getAno()).append(") ");
                            queryt.append("        AND ");
                            queryt.append("        (t.mes_venda_reais  <= ").append(PoiAbertoRepresentanteRep_rActionForm.getMes_final()).append(" and t.ano_venda_reais <= ").append(PoiAbertoRepresentanteRep_rActionForm.getAno_final()).append(")) ");
                            queryt.append("    AND t.unidade_negocio  = nvl(").append(PoiAbertoRepresentanteRep_rActionForm.getUnidade()).append(", t.unidade_negocio) ");
                            queryt.append("    AND r.rep_cdgo         = nvl(").append(rep_cdgo).append(",r.rep_cdgo) ");
                            queryt.append("    AND t.codigo_marca     = mp.codigo_marca ");
                            queryt.append("    AND t.codigo_marca     = ").append(desc_marca.substring(0,desc_marca.lastIndexOf("-")));
                            queryt.append("    AND r.rep_cdgo         = t.codigo_representante ");
                            queryt.append(pmarca);
                            queryt.append("  GROUP BY t.unidade_negocio || ' - ' || unn_descri ");
                            queryt.append("         , t.codigo_marca ");
                            queryt.append("         , mp.codigo_marca ");
                            queryt.append("         , mp.descricao_marca ");
                            queryt.append("         , t.codigo_representante ");
                            queryt.append("         , r.rep_rzao ");
                            queryt.append("  ORDER BY t.unidade_negocio || ' - ' || unn_descri ");
                            queryt.append("         , mp.descricao_marca ");

                            res_teste = j.select(t_jw_poi_registros,
                            queryt.toString(),
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
                          if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                            %>
                            <tr class="reportHeader" >
                              <td>
                              </td>
                              <%
                              if(PoiAbertoRepresentanteRep_rActionForm.getRep_cdgo()==""){
                                %>
                                <td colspan=5 align="center">
                                  <b>
                                    Pares
                                  </b>
                                </td>
                                <%
                              } else {
                                %>
                                <td colspan=5 align="center">
                                  <b>
                                    Pares
                                  </b>
                                </td>
                                <%
                              }
                              %>
                              <td colspan=5 align="center">
                                <b>
                                  Reais
                                </b>
                              </td>
                              <td colspan=3 align="center">
                                <b>
                                  Preço Médio
                                </b>
                              </td>
                            </tr>
                            <%
                          } else {
                            %>
                            <tr class="reportHeader" >
                              <td>
                              </td>
                              <td colspan=3 align="center">
                                <b>
                                  Pares
                                </b>
                              </td>
                              <td colspan=3 align="center">
                                <b>
                                  Reais
                                </b>
                              </td>
                            </tr>
                            <%
                          }
                          %>
                          <tr class="reportHeader">
                            <td class="columnTdHeader" style="text-align:left;">
                              Unidade
                            </td>
                            <%
                            if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                              %>
                              <td class="columnTdHeader" style="text-align:right;" colspan="1">
                                Prev.
                              </td>
                              <%
                            }
                            %>
                            <td class="columnTdHeader" style="text-align:right;" colspan="1">
                              Real.
                            </td>
                            <%
                            if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                              %>
                              <td class="columnTdHeader" style="text-align:right;" colspan="1">
                                %
                              </td>
                              <%
                            }
                            %>
                            <td class="columnTdHeader" style="text-align:right;" colspan="1">
                              Fatur.
                            </td>
                            <td class="columnTdHeader" style="text-align:right;" colspan="1">
                              A Fatur.
                            </td>
                            <%
                            if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                              %>
                              <td class="columnTdHeader" style="text-align:right;" colspan="1">
                                Prev.
                              </td>
                              <%
                            }
                            %>
                            <td class="columnTdHeader" style="text-align:right;" colspan="1">
                              Real.
                            </td>
                            <%
                            if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                              %>
                              <td class="columnTdHeader" style="text-align:right;" colspan="1">
                                %
                              </td>
                              <%
                            }
                            %>
                            <td class="columnTdHeader" style="text-align:right;" colspan="1">
                              Fatur.
                            </td>
                            <td class="columnTdHeader" style="text-align:right;" colspan="1">
                              A Fatur.
                            </td>
                            <%
                            if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                              %>
                              <td class="columnTdHeader" style="text-align:right;" colspan="1">
                                Prev.
                              </td>
                              <td class="columnTdHeader" style="text-align:right;" colspan="1">
                                Real.
                              </td>
                              <td class="columnTdHeader" style="text-align:right;" colspan="1">
                                %
                              </td>
                              <%
                            }
                            %>
                          </tr>
                          <%
                          while (i_bl_report_Jw_poi_registros<res_Jw_poi_registros.size()){ //w4
                          contador_rep ++;
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
                              <%= unidade_negocio1 %>
                            </td>
                            <%
                            if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                              %>
                              <td class="reportColumn" style="text-align:right;" colspan="1">
                                <%= com.egen.util.text.FormatNumber.format(pares_previsto, "##,##0") %>
                              </td>
                              <%
                            }
                            %>
                            <td class="reportColumn" style="text-align:right;" colspan="1">
                              <%= com.egen.util.text.FormatNumber.format(pares_realizado, "##,##0") %>
                            </td>
                            <%
                            if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                              %>
                              <%
                            if(pares_previsto==0 && pares_realizado>0){dif_pares=100;}
                          if(pares_previsto>0 && pares_realizado==0){dif_pares=0;}
                          %>
                          <td class="reportColumn" style="text-align:right;" colspan="1">
                            <%= com.egen.util.text.FormatNumber.format(dif_pares, "##,##0.00") %>
                          </td>
                          <%
                        }
                        %>
                        <td class="reportColumn" style="text-align:right;" colspan="1">
                          <%= com.egen.util.text.FormatNumber.format(pares_faturado, "##,##0") %>
                        </td>
                        <td class="reportColumn" style="text-align:right;" colspan="1">
                          <%= com.egen.util.text.FormatNumber.format(pares_a_faturar, "##,##0") %>
                        </td>
                        <%
                        if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                          %>
                          <td class="reportColumn" style="text-align:right;" colspan="1">
                            <%= com.egen.util.text.FormatNumber.format(reais_previsto, "##,##0.00") %>
                          </td>
                          <%
                        }
                        %>
                        <td class="reportColumn" style="text-align:right;" colspan="1">
                          <%=com.egen.util.text.FormatNumber.format(reais_realizado,"##,##0.00") %>
                        </td>
                        <%
                        if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                          %>
                          <%
                        if(reais_previsto==0 && reais_realizado>0){dif_reais=100;}
                      if(reais_previsto>0 && reais_realizado==0){dif_reais=0;}
                      %>
                      <td class="reportColumn" style="text-align:right;" colspan="1">
                        <%= com.egen.util.text.FormatNumber.format(dif_reais, "##,##0.00") %>
                      </td>
                      <%
                    }
                    %>
                    <td class="reportColumn" style="text-align:right;" colspan="1">
                      <%= com.egen.util.text.FormatNumber.format(reais_faturado, "##,##0.00") %>
                    </td>
                    <td class="reportColumn" style="text-align:right;" colspan="1">
                      <%= com.egen.util.text.FormatNumber.format(reais_a_faturar, "##,##0.00") %>
                    </td>
                    <%
                    if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                      %>
                      <td class="reportColumn" style="text-align:right;" colspan="1">
                        <%= com.egen.util.text.FormatNumber.format(preco_previsto, "##,##0.00") %>
                      </td>
                      <td class="reportColumn" style="text-align:right;" colspan="1">
                        <%= com.egen.util.text.FormatNumber.format(preco_realizado, "##,##0.00") %>
                      </td>
                      <td class="reportColumn" style="text-align:right;" colspan="1">
                        <%
                      if(preco_previsto==0 && preco_realizado>0){dif_preco=100;}
                    if(preco_previsto>0 && preco_realizado==0){dif_preco=0;}
                    %>
                    <%= com.egen.util.text.FormatNumber.format(dif_preco, "##,##0.00") %>
                  </td>
                  <%
                }
                %>
              </tr>
              <%
              if((contador_marca==res_teste.size())){ // if contador_marca
              contador_marca=0;
              teste_u      = previsto_reais_u / cotas_u;
              teste2_u     = total_reais_realizado_u/total_pares_realizado_u;
              preco_dif_u  = Math.round((teste2_u * 100) / teste_u) -100;
              reais_perc_u = ((total_reais_realizado_u * 100) / previsto_reais_u)-100;
              pares_perc_u = ((total_pares_realizado_u * 100) / cotas_u)-100;
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
                  <td class="reportColumn" style="text-align:right;" colspan="1">
                    <%= com.egen.util.text.FormatNumber.format(cotas_u, "##,##0") %>
                  </td>
                  <%
                }
                %>
                <td class="reportColumn" style="text-align:right;"colspan="1">
                  <%= com.egen.util.text.FormatNumber.format(total_pares_realizado_u, "##,##0") %>
                </td>
                <%
                if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                  %>
                  <td class="reportColumn" style="text-align:right;"colspan="1">
                    <%
                  if(cotas_u==0 && total_pares_realizado_u>0){pares_perc_u=100;}
                if(cotas_u>0 && total_pares_realizado_u==0){pares_perc_u=0;}
                %>
                <%= com.egen.util.text.FormatNumber.format(pares_perc_u, "##,##0.00") %>
              </td>
              <%
            }
            %>
            <td class="reportColumn" style="text-align:right;"colspan="1">
              <%= com.egen.util.text.FormatNumber.format(faturado_u, "##,##0") %>
            </td>
            <td class="reportColumn" style="text-align:right;"colspan="1">
              <%= com.egen.util.text.FormatNumber.format(total_pares_a_faturar_u, "##,##0") %>
            </td>
            <%
            if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
              %>
              <td class="reportColumn" style="text-align:right;" colspan="1">
                <%= com.egen.util.text.FormatNumber.format(previsto_reais_u, "##,##0.00") %>
              </td>
              <%
            }
            %>
            <td class="reportColumn" style="text-align:right;" colspan="1">
              <%= com.egen.util.text.FormatNumber.format(total_reais_realizado_u, "##,##0.00") %>
            </td>
            <td class="reportColumn" style="text-align:right;" colspan="1">
              <%
            if(previsto_reais_u==0 && total_reais_realizado_u>0){reais_perc_u=100;}
          if(previsto_reais_u>0 && total_reais_realizado_u==0){reais_perc_u=0;}
          %>
          <%= com.egen.util.text.FormatNumber.format(reais_perc_u, "##,##0.00") %>
        </td>
        <td class="reportColumn" style="text-align:right;" colspan="1">
          <%= com.egen.util.text.FormatNumber.format(total_reais_faturado_u, "##,##0.00") %>
        </td>
        <%
        if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
          %>
          <td class="reportColumn" style="text-align:right;"colspan="1">
            <%= com.egen.util.text.FormatNumber.format(total_reais_a_faturar_u, "##,##0.00") %>
          </td>
          <%
        }
        %>
        <%
        if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
          %>
          <td class="reportColumn" style="text-align:right;" colspan="1">
            <%= com.egen.util.text.FormatNumber.format(teste_u, "##,##0.00") %>
          </td>
          <td class="reportColumn" style="text-align:right;" colspan="1">
            <%= com.egen.util.text.FormatNumber.format(teste2_u, "##,##0.00") %>
          </td>
          <td class="reportColumn" style="text-align:right;" colspan="1">
            <%= com.egen.util.text.FormatNumber.format(((teste2_u / teste_u) * 100) - 100, "##,##0.00") %>
          </td>
          <%
        }
        %>
      </tr>
      <%
      if(contador_rep==res.size()) {
        //--------------------------------------------
        StringBuilder queryfi = new StringBuilder();
        queryfi.append(" SELECT t.codigo_representante ");
        queryfi.append("      , r.rep_rzao ");
        queryfi.append("      , '' marca ");
        queryfi.append("      , '' unidade_negocio ");
        queryfi.append("      , 0 media_dia ");
        queryfi.append("      , 0 media_rep ");
        queryfi.append("      , sum(t.total_reais_previsto) / ");
        queryfi.append("                decode(sum(t.total_pares_previsto), 0, 1, ");
        queryfi.append("                sum(t.total_pares_previsto)) preco_previsto ");
        queryfi.append("      , (sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar)) / ");
        //ATRASO                queryfi.append("      , (sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar) - sum(t.total_reais_atraso)) / ");
        queryfi.append("                decode((sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)), 0, 1, ");
        queryfi.append("                sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)) preco_realizado ");
        queryfi.append("      , (((sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar)) / ");
        queryfi.append("           decode(sum(t.total_pares_faturado) +  sum(t.total_pares_a_faturar), ");
        queryfi.append("           0, 1, sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)) * 100) / ");
        queryfi.append("           (decode(sum(t.total_reais_previsto),0, 1, sum(t.total_reais_previsto)) / ");
        queryfi.append("           decode(sum(t.total_pares_previsto), 0,1,sum(t.total_pares_previsto))) - 100) dif_preco ");
        queryfi.append("      , sum(t.total_reais_faturado) reais_faturado ");
        queryfi.append("      , sum(t.total_reais_a_faturar)- sum(t.total_reais_atraso) reais_a_faturar ");
        queryfi.append("      , sum(t.total_reais_previsto) reais_previsto ");
        queryfi.append("      , sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar) - sum(t.total_reais_atraso) reais_realizado ");
        queryfi.append("      , (((sum(t.total_reais_faturado) + sum(t.total_reais_a_faturar)- sum(t.total_reais_atraso)) * 100) / ");
        queryfi.append("                (decode(sum(t.total_reais_previsto),0,1, sum(t.total_reais_previsto))))-100 dif_reais ");
        queryfi.append("      , sum(t.total_pares_faturado) pares_faturado ");
        queryfi.append("      , sum(t.total_pares_previsto) pares_previsto ");
        queryfi.append("      , sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar) pares_realizado ");
        queryfi.append("      , sum(t.total_pares_a_faturar) pares_a_faturar ");
        queryfi.append("      , (((sum(t.total_pares_faturado) + sum(t.total_pares_a_faturar)) * 100) / ");
        queryfi.append("                decode(sum(t.total_pares_previsto), 0, 1, sum(t.total_pares_previsto)))-100 dif_pares ");
        queryfi.append("      , avg(prazo_medio) prazo_medio ");
        queryfi.append("   FROM brio.cotas_linhas_reais t ");
        queryfi.append("      , brio.marcas_produtos mp ");
        queryfi.append("      , uni_negocio u ");
        queryfi.append("      , rep r ");
        queryfi.append("  WHERE t.codigo_linha           = 999    ");
        queryfi.append("    AND t.emp_empresa            = '01'    ");
        queryfi.append("    AND t.unidade_negocio        = u.unn_codigo ");
        queryfi.append("    AND r.rep_cdgo               = t.codigo_representante ");
        queryfi.append("    AND t.codigo_gerente         = nvl(").append(codigo_gerente).append(", t.codigo_gerente) ");
        queryfi.append("    AND ((t.mes_venda_reais  >= ").append(PoiAbertoRepresentanteRep_rActionForm.getMes()).append(" and t.ano_venda_reais >= ").append(PoiAbertoRepresentanteRep_rActionForm.getAno()).append(") ");
        queryfi.append("        AND ");
        queryfi.append("        (t.mes_venda_reais  <= ").append(PoiAbertoRepresentanteRep_rActionForm.getMes_final()).append(" and t.ano_venda_reais <= ").append(PoiAbertoRepresentanteRep_rActionForm.getAno_final()).append(")) ");
        queryfi.append("    AND r.rep_cdgo               = nvl(").append(rep_cdgo).append(",r.rep_cdgo) ");
        queryfi.append("    AND t.codigo_marca           = mp.codigo_marca ");
        queryfi.append(pmarca);
        queryfi.append("  GROUP BY t.codigo_representante ");
        queryfi.append("         , r.rep_rzao ");
        queryfi.append("  ORDER BY t.codigo_representante ");

        java.sql.PreparedStatement pstm = null;
        java.sql.ResultSet rset = null;
        try {
          pstm = j.getConn().prepareStatement(queryfi.toString());
          rset = pstm.executeQuery();
          if(rset.next()) {
            %>
            <tr class="reportHeader2">
              <td class="reportColumn" style="text-align:left;">
                Total
                <br>
                do Rep.
              </td>
              <%
              if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                %>
                <td class="reportColumn" style="text-align:right;" colspan="1">
                  <%= com.egen.util.text.FormatNumber.format(rset.getDouble(16) , "##,##0") %>
                </td>
                <%
              }
              %>
              <td class="reportColumn" style="text-align:right;" colspan="1">
                <%= com.egen.util.text.FormatNumber.format(rset.getDouble(17),  "##,##0") %>
              </td>
              <%
              if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                %>
                <td class="reportColumn" style="text-align:right;">
                  <%= com.egen.util.text.FormatNumber.format(rset.getDouble(19), "##,##0.00") %>
                </td>
                <%
              }
              %>
              <td class="reportColumn" style="text-align:right;" colspan="1">
                <%= com.egen.util.text.FormatNumber.format(rset.getDouble(15) , "##,##0") %>
              </td>
              <td class="reportColumn" style="text-align:right;" colspan="1">
                <%= com.egen.util.text.FormatNumber.format(rset.getDouble(18),  "##,##0") %>
              </td>
              <%
              if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                %>
                <td class="reportColumn" style="text-align:right;" colspan="1">
                  <%= com.egen.util.text.FormatNumber.format(rset.getDouble(12), "##,##0.00") %>
                </td>
                <%
              }
              %>
              <td class="reportColumn" style="text-align:right;" colspan="1">
                <%= com.egen.util.text.FormatNumber.format(rset.getDouble(13), "##,##0.00") %>
              </td>
              <td class="reportColumn" style="text-align:right;" colspan="1">
                <%= com.egen.util.text.FormatNumber.format(rset.getDouble(14),  "##,##0.00") %>
              </td>
              <td class="reportColumn" style="text-align:right;" colspan="1">
                <%= com.egen.util.text.FormatNumber.format(rset.getDouble(10),  "##,##0.00") %>
              </td>
              <%
              if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                %>
                <td class="reportColumn" style="text-align:right;" colspan="1">
                  <%= com.egen.util.text.FormatNumber.format(rset.getDouble(11),  "##,##0.00") %>
                </td>
                <%
              }
              %>
              <%
              if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                %>
                <td class="reportColumn" style="text-align:right;" colspan="1">
                  <%= com.egen.util.text.FormatNumber.format(rset.getDouble(7), "##,##0.00") %>
                </td>
                <td class="reportColumn" style="text-align:right;" colspan="1">
                  <%= com.egen.util.text.FormatNumber.format(rset.getDouble(8), "##,##0.00") %>
                </td>
                <td class="reportColumn" style="text-align:right;" colspan="1">
                  <%= com.egen.util.text.FormatNumber.format(rset.getDouble(9), "##,##0.00") %>
                </td>
                <%
              }
              %>
            </tr>
            <%
          }
        } finally {
          if (rset != null){
            rset.close();
          }
          if (pstm != null){
            pstm.close();
          }

        }

      }
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
  }
}

if(++contador == res_Jw_poi.size()) {
  prev_cotas = previsto_reais / cotas;
  teste2     = total_reais_realizado/total_pares_realizado;
  preco_dif  = Math.round((teste2 * 100) / prev_cotas) -100;
  reais_perc =  ((total_reais_realizado * 100) / previsto_reais)-100;
  pares_perc =  ((total_pares_realizado * 100) / cotas)-100;
  %>
  <%
  if(tipo.equals("AREAS") || tipo.equals("")) {
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
        <td class="reportColumn" style="text-align:right;" colspan="1">
          <%= com.egen.util.text.FormatNumber.format(cotas, "##,##0") %>
        </td>
        <%
      }
      %>
      <td class="reportColumn" style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(faturado, "##,##0") %>
      </td>
      <%
      if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
        %>
        <td class="reportColumn" style="text-align:right;" colspan="1">
          <%= com.egen.util.text.FormatNumber.format(pares_perc, "##,##0.00") %>
        </td>
        <%
      }
      %>
      <td class="reportColumn" style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(total_pares_a_faturar, "##,##0") %>
      </td>
      <td class="reportColumn" style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(total_pares_realizado, "##,##0") %>
      </td>
      <%
      if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
        %>
        <td class="reportColumn" style="text-align:right;" colspan="1">
          <%= com.egen.util.text.FormatNumber.format(previsto_reais, "##,##0.00") %>
        </td>
        <%
      }
      %>
      <td class="reportColumn" style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(total_reais_realizado, "##,##0.00") %>
      </td>
      <%
      if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
        %>
        <td class="reportColumn" style="text-align:right;" colspan="1">
          <%= com.egen.util.text.FormatNumber.format(reais_perc, "##,##0.00") %>
        </td>
        <%
      }
      %>
      <td class="reportColumn" style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(total_reais_faturado, "##,##0.00") %>
      </td>
      <td class="reportColumn" style="text-align:right;" colspan="1">
        <%= com.egen.util.text.FormatNumber.format(total_reais_a_faturar, "##,##0.00") %>
      </td>
      <%
      if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
        %>
        <td class="reportColumn" style="text-align:right;" colspan="1">
          <%= com.egen.util.text.FormatNumber.format(prev_cotas, "##,##0.00") %>
        </td>
        <td class="reportColumn" style="text-align:right;" colspan="1">
          <%= com.egen.util.text.FormatNumber.format(teste2, "##,##0.00") %>
        </td>
        <td class="reportColumn" style="text-align:right;" colspan="1">
          <%= com.egen.util.text.FormatNumber.format(((teste2 / prev_cotas) * 100) - 100, "##,##0.00") %>
        </td>
        <%
      }
      %>
    </tr>
    <%
  }
  %>
  <%
}
%>
</table>
</table>
<%
if (++i_bl_report_Jw_poi >= res_Jw_poi.size()) {
  break;
}
t_jw_poi = (portalbr.dbobj.view.Jw_poi_aberto_representante)res_Jw_poi.elementAt(i_bl_report_Jw_poi);
codigo_regional = t_jw_poi.getCodigo_regional();
nome_regional   = t_jw_poi.getNome_regional()==null?"":t_jw_poi.getNome_regional();
cdGerenteOld    = codigo_gerente;
codigo_gerente  = t_jw_poi.getCodigo_gerente();
nome_gerente    = t_jw_poi.getNome_gerente()==null?"":t_jw_poi.getNome_gerente();
endereco        = t_jw_poi.getEndereco()==null?"":t_jw_poi.getEndereco();
estado_gerente  = t_jw_poi.getEstado_gerente()==null?"":t_jw_poi.getEstado_gerente();
rep_cdgo        = t_jw_poi.getRep_cdgo()==null?"":t_jw_poi.getRep_cdgo();
rep_rzao        = t_jw_poi.getRep_rzao()==null?"":t_jw_poi.getRep_rzao();
}
}
}
finally {
if(j!=null) {
j.close();
j = null;
}
}

}
%>
</table>
<html:form action="com/PoiAbertoRepresentanteRep_rForm.do" method="post" styleClass="baseForm">
  <table class="itemTable"  style=" width:;">
    <html:hidden property="ano"/>
    <html:hidden property="mes"/>
    <html:hidden property="rep_cdgo"/>
    <html:hidden property="codigo_regional"/>
    <html:hidden property="rep_rzao"/>
    <html:hidden property="flag"/>
    <html:hidden property="tipo"/>
    <html:hidden property="situacao_gerente"/>
    <html:hidden property="unidade"/>
    <html:hidden property="ano_final"/>
    <html:hidden property="mes_final"/>
    <html:hidden property="codigo_marca"/>
    <table class="buttonTable" style='width:99%;'>
      <tr class="buttonTr">
        <td class="buttonTd">
          <%
          if(!(request.getParameter("excel")+"").equals("true")){
            %>
            <html:button accesskey="b" onclick="history.go(-1);" styleClass="baseButton" property="back_action">
              <bean:message bundle="ApplicationResources" key="jsp.back"/>
            </html:button>
            <%
          }
          %>
          <%
          if(!(request.getParameter("excel")+"").equals("true")){
            %>
            <html:submit accesskey="p" value="pop" styleClass="myhidden" property="pop_action">
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

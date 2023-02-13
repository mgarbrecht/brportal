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
            portalbr.com.PoiAbertoRepresentante_rActionForm PoiAbertoRepresentante_rActionForm = (portalbr.com.PoiAbertoRepresentante_rActionForm)session.getAttribute("PoiAbertoRepresentante_rActionForm");
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
            boolean mostrar_todos_gerentes = false;
            if(session.getAttribute("poi_situacao_gerente") != null) {
              String situacao_gerente = (String)session.getAttribute("poi_situacao_gerente");
              if(situacao_gerente.equalsIgnoreCase("T")) {
                mostrar_todos_gerentes = true;
              }
            }
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
            double total_reais_realizado_anterior   = 0;
            double total_pares_a_faturar   = 0;
            double total_pares_realizado   = 0;
            double total_pares_realizado_anterior   = 0;
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
            double total_reais_realizado_anterior_u = 0;
            double total_pares_realizado_anterior_u = 0;
            double teste_u      = 0;
            double teste2_u     = 0;
            double preco_dif_u  = 0;
            double reais_perc_u = 0;
            double pares_perc_u = 0;
            double perc_preco_medio_marca = 0;
            double perc_preco_medio_regional = 0;

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
                PoiAbertoRepresentante_rActionForm.setCodigo_regional(ent_f.getChave()+"");
              }
              if((tipo_f.equals("REPRESENTANTE COMERCIAL")) || (tipo_f.equals("REPRESENTANTE EXPORTACAO"))){
                PoiAbertoRepresentante_rActionForm.setRep_cdgo(ent_f.getChave()+"");
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
            String mes = PoiAbertoRepresentante_rActionForm.getMes();
            String ano = PoiAbertoRepresentante_rActionForm.getAno();

            if(PoiAbertoRepresentante_rActionForm.getCodigo_regional()!=""){
              regional = PoiAbertoRepresentante_rActionForm.getCodigo_regional();
            }
            if(PoiAbertoRepresentante_rActionForm.getRep_cdgo()!="" &&
            PoiAbertoRepresentante_rActionForm.getRep_cdgo()!="null"){
              representante = " and  rep.rep_cdgo in("+PoiAbertoRepresentante_rActionForm.getRep_cdgo()+") ";
            }
            if(PoiAbertoRepresentante_rActionForm.getCodigo_marca()!="" &&
            PoiAbertoRepresentante_rActionForm.getCodigo_marca()!="null"){
              pmarca = " and t.codigo_marca = "+ PoiAbertoRepresentante_rActionForm.getCodigo_marca();
            }


            try {
              j = new com.egen.util.jdbc.JdbcUtil();
              //-----------------------------------------------
              if(PoiAbertoRepresentante_rActionForm.getRep_cdgo()!=""){
                portalbr.dbobj.table.Rep db_object = new portalbr.dbobj.table.Rep();
                Object[][] where = {
                {"rep_cdgo","like", PoiAbertoRepresentante_rActionForm.getRep_cdgo()}
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
                    <!--
                      <tr class="reportHeader3" > <td colspan=2> Analista : <%= ((codigo_gerente!=null)?codigo_gerente.toString():"") %> - <%= nome_gerente %> </td> <td> Endereço : <%= endereco %> </td> <td> UF : <%= estado_gerente %> </td> </tr>
                    -->
                    <%
                  }
                  %>
                  <%
                  if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                    %>
                    <%
                    if(PoiAbertoRepresentante_rActionForm.getRep_cdgo()!=""){  //if if13
                    %>
                    <tr class="reportHeader3" >
                      <td colspan=4>
                        Representante :
                        <%= PoiAbertoRepresentante_rActionForm.getRep_cdgo() %>
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
                    <%= PoiAbertoRepresentante_rActionForm.getMes() %>
                    /
                    <%= PoiAbertoRepresentante_rActionForm.getAno() %>
                    a
                    <%= PoiAbertoRepresentante_rActionForm.getMes_final() %>
                    /
                    <%= PoiAbertoRepresentante_rActionForm.getAno_final() %>
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
                  query.append(" SELECT codigo_representante ");
                  query.append("       ,rep_rzao ");
                  query.append("       ,marca ");
                  query.append("       ,'' unidade_negocio ");
                  query.append("       ,media_dia ");
                  query.append("       ,media_rep ");
                  query.append("       ,preco_previsto ");
                  query.append("       ,preco_realizado ");
                  query.append("       ,dif_preco ");
                  query.append("       ,reais_faturado ");
                  query.append("       ,reais_a_faturar ");
                  query.append("       ,reais_previsto ");
                  query.append("       ,reais_realizado ");
                  query.append("       ,dif_reais ");
                  query.append("       ,pares_faturado ");
                  query.append("       ,pares_previsto ");
                  query.append("       ,pares_realizado ");
                  query.append("       ,pares_a_faturar ");
                  query.append("       ,dif_pares ");
                  query.append("       ,prazo_medio ");
                  query.append("       ,reais_realizado_anterior       ");
                  query.append("       ,pares_realizado_anterior       ");
                  query.append("   FROM (SELECT codigo_representante ");
                  query.append("               ,rep_rzao ");
                  query.append("               ,codigo_marca || '-' || descricao_marca marca ");
                  query.append("               ,'' unidade_negocio ");
                  query.append("               ,0 media_dia ");
                  query.append("               ,0 media_rep ");
                  query.append("               ,SUM(total_reais_previsto) / ");
                  query.append("                DECODE(SUM(total_pares_previsto), 0, 1, SUM(total_pares_previsto)) preco_previsto ");
                  query.append("               ,(SUM(total_reais_faturado) + SUM(total_reais_a_faturar)) / ");
                  query.append("                DECODE((SUM(total_pares_faturado) + ");
                  query.append("                       SUM(total_pares_a_faturar)), 0, 1, SUM(total_pares_faturado) + ");
                  query.append("                        SUM(total_pares_a_faturar)) preco_realizado ");
                  query.append("               ,(((SUM(total_reais_faturado) + SUM(total_reais_a_faturar)) / ");
                  query.append("                DECODE(SUM(total_pares_faturado) + ");
                  query.append("                         SUM(total_pares_a_faturar), 0, 1, SUM(total_pares_faturado) + ");
                  query.append("                          SUM(total_pares_a_faturar)) * 100) / ");
                  query.append("                (DECODE(SUM(total_reais_previsto), 0, 1, SUM(total_reais_previsto)) / ");
                  query.append("                DECODE(SUM(total_pares_previsto), 0, 1, SUM(total_pares_previsto))) - 100) dif_preco ");
                  query.append("               ,SUM(total_reais_faturado) reais_faturado ");
                  query.append("               ,SUM(total_reais_a_faturar) - SUM(total_reais_atraso) reais_a_faturar ");
                  query.append("               ,SUM(total_reais_previsto) reais_previsto ");
                  query.append("               ,SUM(total_reais_faturado) + SUM(total_reais_a_faturar) - ");
                  query.append("                SUM(total_reais_atraso) reais_realizado ");
                  query.append("               ,SUM(total_reais_faturado_anterior) + ");
                  query.append("                SUM(total_reais_a_faturar_anterior) - ");
                  query.append("                SUM(total_reais_atraso_anterior) reais_realizado_anterior ");
                  query.append("               ,((SUM(total_reais_faturado) + SUM(total_reais_a_faturar) - ");
                  query.append("                SUM(total_reais_atraso)) * 100) / ");
                  query.append("                (DECODE(SUM(total_reais_previsto), 0, 1, SUM(total_reais_previsto))) dif_reais ");
                  query.append("               ,SUM(total_pares_faturado) pares_faturado ");
                  query.append("               ,SUM(total_pares_previsto) pares_previsto ");
                  query.append("               ,SUM(total_pares_faturado) + SUM(total_pares_a_faturar) pares_realizado ");
                  query.append("               ,SUM(total_pares_faturado_anterior) + ");
                  query.append("                SUM(total_pares_a_faturar_anterior) pares_realizado_anterior ");
                  query.append("               ,SUM(total_pares_a_faturar) pares_a_faturar ");
                  query.append("               ,((SUM(total_pares_faturado) + SUM(total_pares_a_faturar)) * 100) / ");
                  query.append("                DECODE(SUM(total_pares_previsto), 0, 1, SUM(total_pares_previsto)) dif_pares ");
                  query.append("               ,AVG(prazo_medio) prazo_medio ");
                  query.append("           FROM (SELECT t.codigo_representante ");
                  query.append("                       ,r.rep_rzao ");
                  query.append("                       ,mp.codigo_marca || '-' || mp.descricao_marca marca ");
                  query.append("                       ,'' unidade_negocio ");
                  query.append("                       ,0 media_dia ");
                  query.append("                       ,0 media_rep ");
                  query.append("                       ,t.total_reais_previsto ");
                  query.append("                       ,t.total_pares_previsto ");
                  query.append("                       ,t.total_pares_a_faturar ");
                  query.append("                       ,0 total_pares_a_faturar_anterior ");
                  query.append("                       ,t.total_pares_faturado ");
                  query.append("                       ,0 total_pares_faturado_anterior ");
                  query.append("                       ,t.total_reais_atraso ");
                  query.append("                       ,0 total_reais_atraso_anterior ");
                  query.append("                       ,t.total_reais_a_faturar ");
                  query.append("                       ,0 total_reais_a_faturar_anterior ");
                  query.append("                       ,t.total_reais_faturado ");
                  query.append("                       ,0 total_reais_faturado_anterior ");
                  query.append("                       ,mp.descricao_marca ");
                  query.append("                       ,mp.codigo_marca ");
                  query.append("                       ,prazo_medio ");
                  query.append("                   FROM brio.cotas_linhas_reais t ");
                  query.append("                       ,brio.marcas_produtos    mp ");
                  query.append("                       ,brio.rep ");
                  query.append("                       ,rep                     r ");
                  query.append("                  WHERE t.codigo_linha = 999 ");
                  query.append("                    AND t.emp_empresa = '01' ");
                  query.append("                    AND rep.rep_cdgo = t.codigo_representante ");
                  if(!mostrar_todos_gerentes) {
                    query.append("                 AND t.codigo_gerente         = nvl("+codigo_gerente+", t.codigo_gerente) ");
                  } else {
                    query.append(" and pck_representante.get_regional(t.codigo_representante) = (select codigo_regional from gerentes_regionais_vendas g where codigo_gerente = "+codigo_gerente+") ");
                  }
                  query.append("    AND ((t.mes_venda_reais  >= ").append(PoiAbertoRepresentante_rActionForm.getMes()).append(" and t.ano_venda_reais >= ").append(PoiAbertoRepresentante_rActionForm.getAno()).append(") ");
                  query.append("          AND ");
                  query.append("         (t.mes_venda_reais  <= ").append(PoiAbertoRepresentante_rActionForm.getMes_final()).append(" and t.ano_venda_reais <= ").append(PoiAbertoRepresentante_rActionForm.getAno_final()).append(")) ");
                  query.append(representante);
                  query.append(pmarca);
                  query.append("                    AND t.codigo_marca = mp.codigo_marca ");
                  query.append("                    AND t.codigo_marca           = "+desc_marca.substring(0,desc_marca.lastIndexOf("-")));
                  query.append("                    AND r.rep_cdgo = t.codigo_representante ");
                  query.append("                 UNION ALL ");
                  query.append("                 SELECT t.codigo_representante ");
                  query.append("                       ,r.rep_rzao ");
                  query.append("                       ,mp.codigo_marca || '-' || mp.descricao_marca marca ");
                  query.append("                       ,'' unidade_negocio ");
                  query.append("                       ,0 media_dia ");
                  query.append("                       ,0 media_rep ");
                  query.append("                       ,0 total_reais_previsto ");
                  query.append("                       ,0 total_pares_previsto ");
                  query.append("                       ,0 total_pares_a_faturar ");
                  query.append("                       ,t.total_pares_a_faturar total_pares_a_faturar_anterior ");
                  query.append("                       ,0 total_pares_faturado ");
                  query.append("                       ,total_pares_faturado total_pares_faturado_anterior ");
                  query.append("                       ,0 total_reais_atraso ");
                  query.append("                       ,t.total_reais_atraso total_reais_atraso_anterior ");
                  query.append("                       ,0 total_reais_a_faturar ");
                  query.append("                       ,t.total_reais_a_faturar total_reais_a_faturar_anterior ");
                  query.append("                       ,0 total_reais_faturado ");
                  query.append("                       ,t.total_reais_faturado total_reais_faturado_anterior ");
                  query.append("                       ,mp.descricao_marca ");
                  query.append("                       ,mp.codigo_marca ");
                  query.append("                       ,0 prazo_medio ");
                  query.append("                   FROM brio.cotas_linhas_reais t ");
                  query.append("                       ,brio.marcas_produtos    mp ");
                  query.append("                       ,brio.rep ");
                  query.append("                       ,rep                     r ");
                  query.append("                  WHERE t.codigo_linha = 999 ");
                  query.append("                    AND t.emp_empresa = '01' ");
                  query.append("                    AND rep.rep_cdgo = t.codigo_representante ");
                  if(!mostrar_todos_gerentes) {
                    query.append("                 AND t.codigo_gerente         = nvl("+codigo_gerente+", t.codigo_gerente) ");
                  } else {
                    query.append(" and pck_representante.get_regional(t.codigo_representante) = (select codigo_regional from gerentes_regionais_vendas g where codigo_gerente = "+codigo_gerente+") ");
                  }
                  query.append("          AND ((t.mes_venda_reais  >= ").append(PoiAbertoRepresentante_rActionForm.getMes()).append(" and t.ano_venda_reais >= ").append(Integer.parseInt(PoiAbertoRepresentante_rActionForm.getAno())-1).append(") ");
                  query.append("          AND ");
                  query.append("         (t.mes_venda_reais  <= ").append(PoiAbertoRepresentante_rActionForm.getMes_final()).append(" and t.ano_venda_reais <= ").append(Integer.parseInt(PoiAbertoRepresentante_rActionForm.getAno_final())-1).append(")) ");
                  query.append(representante);
                  query.append(pmarca);
                  query.append("                    AND t.codigo_marca = mp.codigo_marca ");
                  query.append("    AND t.codigo_marca           = "+desc_marca.substring(0,desc_marca.lastIndexOf("-")));
                  query.append("                    AND r.rep_cdgo = t.codigo_representante ");
                  query.append("                  ORDER BY descricao_marca) ");
                  query.append("          GROUP BY codigo_marca ");
                  query.append("                  ,codigo_marca ");
                  query.append("                  ,descricao_marca ");
                  query.append("                  ,codigo_representante ");
                  query.append("                  ,rep_rzao ");
                  query.append("          ORDER BY codigo_marca ");
                  query.append("                  ,TO_NUMBER(regexp_substr(codigo_representante, '[[:digit:]]+', 1, 1))) ");
                  query.append("  WHERE (reais_realizado > 0 OR reais_previsto > 0) ");

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
                double reais_realizado_anterior =  0;
                double dif_reais       =  0;
                double pares_faturado  =  0;
                double pares_previsto  =  0;
                double pares_realizado =  0;
                double pares_realizado_anterior =  0;
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
                reais_realizado_anterior = t_jw_poi_registros.getReais_realizado_anterior();
                dif_reais               = t_jw_poi_registros.getDif_reais();
                pares_faturado          = t_jw_poi_registros.getPares_faturado();
                pares_previsto          = t_jw_poi_registros.getPares_previsto();
                pares_realizado         = t_jw_poi_registros.getPares_realizado();
                pares_realizado_anterior = t_jw_poi_registros.getPares_realizado_anterior();
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
                total_reais_realizado_anterior  += reais_realizado_anterior;
                total_pares_a_faturar  += pares_a_faturar;
                total_pares_realizado  += pares_realizado;
                total_pares_realizado_anterior  += pares_realizado_anterior;
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
                total_reais_realizado_anterior_u += reais_realizado_anterior;
                total_pares_realizado_anterior_u += pares_realizado_anterior;
                //-----------------------------------------------
                contador_marca ++;
                %>
                <%
                if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                  %>
                  <tr class="reportHeader" >
                    <td>
                    </td>
                    <%
                    if(PoiAbertoRepresentante_rActionForm.getRep_cdgo()==""){
                      %>
                      <td align="center" colspan=6>
                        <b>
                          Pares
                        </b>
                      </td>
                      <%}else { %>
                        <td align="center" colspan=6>
                          <b>
                            Pares
                          </b>
                        </td>
                        <%
                      }
                      %>
                      <td align="center" colspan=6>
                        <b>
                          Reais
                        </b>
                      </td>
                      <td align="center" colspan=3>
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
                      <td colspan=4 align="center">
                        <b>
                          Pares
                        </b>
                      </td>
                      <td colspan=4 align="center">
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
                      <td class="columnTdHeader" style="text-align:right;" colspan="1">
                        Prev.
                      </td>
                      <%
                    }
                    %>
                    <td class="columnTdHeader" style="text-align:right;" colspan="1">
                      Real.
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" colspan="1">
                      Real. Ano Anterior
                    </td>

                    <%
                    if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                      %>
                      <td class="columnTdHeader" style="text-align:right;" colspan="1">
                        %
                      </td>
                      <td class="columnTdHeader" style="text-align:right;" colspan="1">
                        Fatur.
                      </td>
                      <td class="columnTdHeader" style="text-align:right;" colspan="1">
                        A Fatur.
                      </td>
                      <%
                    } else {
                      %>
                      <td class="columnTdHeader" style="text-align:right;" colspan="1">
                        Fatur.
                      </td>
                      <td class="columnTdHeader" style="text-align:right;" colspan="1">
                        A Fatur.
                      </td>
                      <%
                    }
                    %>
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
                        Real. Ano Anterior
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" colspan="1">
                        %
                      </td>
                      <%
                    } else {
                      %>
                      <td class="columnTdHeader" style="text-align:right;" colspan="1">
                        Real.
                      </td>
                      <td class="columnTdHeader" style="text-align:right;" colspan="1">
                        Real. Ano Anterior
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
                      <td class="reportColumn" style="text-align:right;" colspan="1">
                        <%= com.egen.util.text.FormatNumber.format(pares_previsto, "##,##0") %>
                      </td>
                      <%
                    }
                    %>
                    <td class="reportColumn" style="text-align:right;" colspan="1">
                      <%= com.egen.util.text.FormatNumber.format(pares_realizado, "##,##0") %>
                    </td>

                    <td class="reportColumn" style="text-align:right;" colspan="1">
                      <%= com.egen.util.text.FormatNumber.format(pares_realizado_anterior, "##,##0") %>
                    </td>

                    <%
                    if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                      %>
                      <td class="reportColumn" style="text-align:right;" colspan="1">
                        <%
                        dif_pares-=100;
                      if(pares_previsto==0 && pares_realizado>0){dif_pares=100;}
                    if(pares_previsto>0 && pares_realizado==0){dif_pares=0;}
                    %>
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
                  <%=com.egen.util.text.FormatNumber.format(reais_realizado,"##,##0.00")%>
                </td>
                <td class="reportColumn" style="text-align:right;" colspan="1">
                  <%=com.egen.util.text.FormatNumber.format(reais_realizado_anterior,"##,##0.00")%>
                </td>
                <%
                if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                  %>
                  <%
                  dif_reais-=100;
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
      // ------------------ TOTAL POR MARCA -------------------------------------------------------------------------------
      if((contador_marca==res_Jw_poi_registros.size())){
        contador_marca=0;
        teste_u      = previsto_reais_u / (cotas_u==0?1:cotas_u);
        teste2_u     = total_reais_realizado_u/total_pares_realizado_u;
        preco_dif_u  = Math.round((teste2_u * 100) / (teste_u==0?1:teste_u)) -100;
        reais_perc_u =  ((total_reais_realizado_u * 100) / previsto_reais_u)-100;
        pares_perc_u =  ((total_pares_realizado_u * 100) / cotas_u)-100;
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
              <td class="reportColumn" style="text-align:right;" colspan="1">
                <%= com.egen.util.text.FormatNumber.format(cotas_u, "##,##0") %>
              </td>
              <%
            }
            %>
            <td class="reportColumn" style="text-align:right;" colspan="1">
              <%= com.egen.util.text.FormatNumber.format(total_pares_realizado_u, "##,##0") %>
            </td>
            <td class="reportColumn" style="text-align:right;" colspan="1">
              <%= com.egen.util.text.FormatNumber.format(total_pares_realizado_anterior_u, "##,##0") %>
            </td>
            <%
            if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
              %>
              <td class="reportColumn" style="text-align:right;" colspan="1">
                <%
              if(cotas_u==0 && total_pares_realizado_u>0){pares_perc_u=100;}
            if(cotas_u>0 && total_pares_realizado==0){pares_perc_u=0;}
            %>
            <%= com.egen.util.text.FormatNumber.format(pares_perc_u, "##,##0.00") %>
          </td>
          <%
        }
        %>
        <td class="reportColumn" style="text-align:right;" colspan="1">
          <%= com.egen.util.text.FormatNumber.format(faturado_u, "##,##0") %>
        </td>
        <td class="reportColumn" style="text-align:right;" colspan="1">
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
          <%= com.egen.util.text.FormatNumber.format(total_reais_realizado_anterior_u, "##,##0.00") %>
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
      <td class="reportColumn" style="text-align:right;" colspan="1">
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
        <%
        perc_preco_medio_marca = ((teste2_u / (teste_u==0?1:teste_u))* 100.00)- 100.00;
      if(teste_u==0 && teste2_u>0){perc_preco_medio_marca=100;}
    if(teste_u>0 && teste2_u==0){perc_preco_medio_marca=0;}
    %>
    <%= com.egen.util.text.FormatNumber.format(perc_preco_medio_marca, "##,##0.00") %>
  </td>
  <%
}
%>
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
total_reais_realizado_anterior_u = 0; //xxxxxxxxxxxxxxxxxxxxx
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
reais_realizado_anterior = t_jw_poi_registros.getReais_realizado_anterior();
dif_reais                = t_jw_poi_registros.getDif_reais();
pares_faturado           = t_jw_poi_registros.getPares_faturado();
pares_previsto           = t_jw_poi_registros.getPares_previsto();
pares_realizado          = t_jw_poi_registros.getPares_realizado();
pares_realizado_anterior = t_jw_poi_registros.getPares_realizado_anterior();
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
total_reais_realizado_anterior   += reais_realizado_anterior;
total_pares_realizado_anterior   += pares_realizado_anterior;
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
total_reais_realizado_anterior_u += reais_realizado_anterior;
total_pares_realizado_anterior_u += pares_realizado_anterior;
//-----------------------------------------------
contador_marca ++;
}//fim if contador_marca
} // fim while w4


if(++contador == res_Jw_poi.size()) {
prev_cotas = previsto_reais / (cotas==0?1:cotas);
teste2     = total_reais_realizado/(total_pares_realizado==0?1:total_pares_realizado);
preco_dif = Math.round((teste2 * 100) / prev_cotas) -100;
reais_perc =  ((total_reais_realizado * 100) / previsto_reais)-100;
pares_perc =  ((total_pares_realizado * 100) / cotas)-100;
%>
<%
// if(tipo.equals("AREAS") || tipo.equals("")){
%>
<%
if(true) {
  %>
  <tr class="reportHeader2">
    <td class="reportColumn" style="text-align:left;">

      Total Geral
      <%
      if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
        %>

        <%
      } else {
        %>

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
      <%= com.egen.util.text.FormatNumber.format(total_pares_realizado, "##,##0") %>
    </td>
    <td class="reportColumn" style="text-align:right;" colspan="1">
      <%= com.egen.util.text.FormatNumber.format(total_pares_realizado_anterior, "##,##0") %>
    </td>
    <%
    if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
      %>
      <td class="reportColumn" style="text-align:right;" colspan="1">
        <%
      if(cotas==0 && total_pares_realizado>0){pares_perc=100;}
    if(cotas>0 && total_pares_realizado==0){pares_perc=0;}
    %>
    <%= com.egen.util.text.FormatNumber.format(pares_perc, "##,##0.00") %>
  </td>
  <%
}
%>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(faturado, "##,##0") %>
</td>
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(total_pares_a_faturar, "##,##0") %>
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
<td class="reportColumn" style="text-align:right;" colspan="1">
  <%= com.egen.util.text.FormatNumber.format(total_reais_realizado_anterior, "##,##0.00") %>
</td>
<%
if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
  %>
  <%
if(previsto_reais==0 && total_reais_realizado>0){reais_perc=100;}
if(previsto_reais>0 && total_reais_realizado==0){reais_perc=0;}
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
    <%
    //                  perc_preco_medio_regional = ((teste2_u / (teste_u==0?1:teste_u))* 100.00)- 100.00;
    perc_preco_medio_regional = ((teste2 / (prev_cotas==0?1:prev_cotas))* 100.00)- 100.00;
  if(prev_cotas==0 && teste2>0){perc_preco_medio_regional=100;}
if(prev_cotas>0 && teste2==0){perc_preco_medio_regional=0;}
%>
<%= com.egen.util.text.FormatNumber.format(perc_preco_medio_regional, "##,##0.00") %>
</td>
<%
}
%>
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
%>
</table>
<html:form action="com/PoiAbertoRepresentante_rForm.do" method="post" styleClass="baseForm">
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

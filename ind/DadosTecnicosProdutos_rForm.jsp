<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta Dados Técnicos dos Produtos
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(228)){
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
              boolean consultaPorPedido = false;
              boolean mostrarPedidoItem = false;
              boolean consultaPorFatura = false;
              if(session.getAttribute("tipo_relatorio_dados_tecnicos_fatura")!=null){
                consultaPorFatura = true;
              }
              if(session.getAttribute("mostrar_pedido_item")!=null){
                mostrarPedidoItem = true;
              }
              if(session.getAttribute("dados_tecnicos_produtos_consulta_por_pedido")!=null){
                consultaPorPedido = true;
              }
              java.util.Vector res_Jw_dados_tecnicos_produtos = (java.util.Vector)session.getAttribute("res_Jw_dados_tecnicos_produtos");
              %>

              <form  name="bl_report_Jw_dados_tecnicos_produtos" id="bl_report_Jw_dados_tecnicos_produtos" class="baseForm" method="post" >
                <%
                if (res_Jw_dados_tecnicos_produtos!=null && res_Jw_dados_tecnicos_produtos.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_dados_tecnicos_produtos"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Integer lin_cdgo = null;
                    java.lang.Integer ref_cdgo = null;
                    java.lang.Integer cab_cdgo = null;
                    java.lang.String cab_desc = null;
                    java.lang.Integer cor_cdgo = null;
                    java.lang.String descricao_cor = null;
                    java.lang.String desc_produto = null;
                    java.lang.String mix_produtos = null;
                    java.lang.String qtp_nume = null;
                    //jefe
                    java.lang.String qtp_pars = null;
                    java.lang.Double ite_prco = null;
                    java.lang.String id_produto = null;
                    java.lang.Integer marca = null;
                    java.lang.String marca_descricao = null;
                    java.lang.String filial = null;
                    java.lang.Long cnpj = null;
                    java.lang.Long ean13 = null;
                    java.lang.String dun14 = null;
                    java.lang.String classificacao_fiscal = null;
                    java.lang.String comp_larg_alt_embalagem = null;
                    java.lang.Double peso_embalamgem = null;
                    java.lang.Double peso_sapato = null;
                    java.lang.String ra_fornecedor = null;
                    java.lang.String razao_social = null;
                    java.lang.String ref_fechamento_sapato = null;
                    java.lang.String ref_tipo_salto = null;
                    java.lang.String ref_bota_possui_elastico = null;
                    java.lang.Integer ref_tip_mat_cdgo_palmilha = null;
                    java.lang.String tip_mat_palmilha_descricao = null;
                    java.lang.Integer ref_tip_mat_cdgo_entresola = null;
                    java.lang.String tip_mat_entresola_descricao = null;
                    java.lang.Integer ref_tip_mat_cdgo_salto = null;
                    java.lang.String tip_mat_salto_descricao = null;
                    java.lang.Integer ref_tip_mat_cdgo_meiapata = null;
                    java.lang.String tip_mat_meiapata_descricao = null;
                    java.lang.String ref_dimensao_cx_individual = null;
                    java.lang.String dimensao_caixa_descricao = null;
                    java.lang.String observacao = null;
                    java.lang.Double ref_largura_interna_pe = null;
                    java.lang.Double ref_compr_interno_pe = null;
                    java.lang.Double ref_altura_sapato = null;
                    java.lang.Double ref_largura_ext_sapato = null;
                    java.lang.Double ref_compr_ext_sapato = null;
                    java.lang.Double ref_altura_salto = null;
                    java.lang.Double ref_altura_meiapata = null;

                    java.lang.Double comprimento_embalagem = null;
                    java.lang.Double largura_embalagem = null;
                    java.lang.Double altura_embalagem = null;

                    java.lang.String comprimento_caixa = null;
                    java.lang.String largura_caixa = null;
                    java.lang.String altura_caixa = null;

                    java.lang.Double ref_altura_canobota = null;
                    java.lang.Double ref_diametro_boca_bota = null;
                    java.lang.String grupo_posicao_fabrica = null;
                    java.lang.String tipo_material_predominante = null;
                    java.lang.String tipo_material_solado = null;
                    java.lang.String tipo_material_forro = null;
                    java.lang.Double ref_perc_cabedal = null;
                    java.lang.Double ref_perc_solado = null;
                    java.lang.String fci = null;
                    java.lang.String cst = null;
                    java.lang.String tipo_material_palmilha = null;
                    java.lang.Integer ped_nmro = null;
                    java.lang.Integer ite_seqn = null;
                    java.lang.String tem_etiqueta = null;
                    java.lang.String numero_exterior = null;
                    java.lang.Double preco_pdv = null;
                    java.lang.String ped_ped_cliente = null;
                    java.lang.String altura_alca = null;
                    java.lang.String altura_bolsa = null;
                    java.lang.String bolso_interno = null;
                    java.lang.String fechamento_bolsa = null;
                    java.lang.String largura_bolsa = null;
                    java.lang.String peso_bolsa = null;
                    java.lang.String profundidade_bolsa = null;
                    java.lang.String quantidade_bolsos = null;
                    java.lang.String regulagem = null;
                    java.lang.String tipo_alca = null;
                    %>

                    <tr class="reportTr">

                      <%
                      if(consultaPorPedido){
                        %>
                        <td class="columnTdHeader" style="text-align:center;" >
                          Etiqueta
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Pedido
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          OC
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Linha
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Ref.
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Cab.
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Cab. Desc.
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Cor
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Mat. Predo. Palmilha
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Tipo Material Predominante
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Tipo Material Solado
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Tipo Material Forro
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Mix Produtos
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Preço PDV
                        </td>




                        <%
                      } else {
                        %>
                        <td class="columnTdHeader" style="text-align:center;" >
                          Etiqueta
                        </td>
                        <%
                        if(mostrarPedidoItem) {
                          %>
                          <td class="columnTdHeader" style="text-align:center;" >
                            Pedido
                          </td>

                          <td class="columnTdHeader" style="text-align:center;" >
                            OC
                          </td>

                          <td class="columnTdHeader" style="text-align:center;" >
                            Item
                          </td>
                          <%
                        }
                        %>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Linha
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Ref.
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Cab.
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Cab. Desc.
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Cor
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Produto
                        </td>

                        <%
                        if(consultaPorFatura){
                          %>
                          <td class="columnTdHeader" style="text-align:center;" >
                            Número Brasil
                          </td>
                          <td class="columnTdHeader" style="text-align:center;" >
                            Número
                          </td>
                          <%
                        } else {
                          %>
                          <td class="columnTdHeader" style="text-align:center;" >
                            Número
                          </td>
                          <%
                        }
                        %>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Qtd. Pares
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Item Preço
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          ID Item
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Marca
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Filial
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          CNPJ
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          EAN13
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          DUN14
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Classif. Fiscal
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Comp. da Embalagem (m)
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Larg. da Embalagem (m)
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Alt. da Embalagem (m)
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Peso Embalagem
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Peso Sapato
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Ref. Fornec.
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Razão Social
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Fecham. Sapato
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Tipo Salto
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Elástico
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Mat. Predo. Palmilha
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Mat. Predo. Sola
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Mat. Predo. Salto
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Mat. Predo. Meiapata
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Comp. Caixa (cm)
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Larg. Caixa (cm)
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Alt. Caixa (cm)
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Observação
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Larg. Int.
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Comp. Int.
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Alt. Sapato
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Larg. Ext.
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Comp. Ext.
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Alt. Salto
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Alt. Meia.
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Alt. Cano.
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Diam. Boca.
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Tipo de Produto
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Tipo Material Predominante
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Tipo Material Solado
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Tipo Material Forro
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Perc. Cabedal
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Perc. Solado
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          FCI
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          CST
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Mix Produtos
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Preço PDV
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Altura Alça
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Altura Bolsa
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Bolso Interno
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Fechamento Bolsa
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Largura Bolsa
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Peso Bolsa
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Profundidade Bolsa
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Quantidade Bolsos
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Regulagem
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Tipo Alça
                        </td>

                        <%
                      }
                      %>

                    </tr>



                    <%
                    int i_bl_report_Jw_dados_tecnicos_produtos = 0;
                    while (i_bl_report_Jw_dados_tecnicos_produtos<res_Jw_dados_tecnicos_produtos.size()) {
                      portalbr.dbobj.view.Jw_dados_tecnicos_produtos t_jw_dados_tecnicos_produtos = (portalbr.dbobj.view.Jw_dados_tecnicos_produtos)res_Jw_dados_tecnicos_produtos.elementAt(i_bl_report_Jw_dados_tecnicos_produtos);
                      lin_cdgo = t_jw_dados_tecnicos_produtos.getLin_cdgo();
                      ref_cdgo = t_jw_dados_tecnicos_produtos.getRef_cdgo();
                      cab_cdgo = t_jw_dados_tecnicos_produtos.getCab_cdgo();
                      cor_cdgo = t_jw_dados_tecnicos_produtos.getCor_cdgo();
                      descricao_cor = t_jw_dados_tecnicos_produtos.getDescricao_cor()==null?"":t_jw_dados_tecnicos_produtos.getDescricao_cor();
                      desc_produto = t_jw_dados_tecnicos_produtos.getDesc_produto()==null?"":t_jw_dados_tecnicos_produtos.getDesc_produto();
                      qtp_nume = t_jw_dados_tecnicos_produtos.getQtp_nume()==null?"":t_jw_dados_tecnicos_produtos.getQtp_nume();
                      qtp_pars = t_jw_dados_tecnicos_produtos.getQtp_pars()==null?"":t_jw_dados_tecnicos_produtos.getQtp_pars()+"";
                      ite_prco = t_jw_dados_tecnicos_produtos.getIte_prco();
                      id_produto = t_jw_dados_tecnicos_produtos.getId_produto()==null?"":t_jw_dados_tecnicos_produtos.getId_produto();
                      marca = t_jw_dados_tecnicos_produtos.getMarca();
                      marca_descricao = t_jw_dados_tecnicos_produtos.getMarca_descricao()==null?"":t_jw_dados_tecnicos_produtos.getMarca_descricao();
                      cab_desc = t_jw_dados_tecnicos_produtos.getCab_desc()==null?"":t_jw_dados_tecnicos_produtos.getCab_desc();
                      filial = t_jw_dados_tecnicos_produtos.getFilial()==null?"":t_jw_dados_tecnicos_produtos.getFilial();
                      mix_produtos = t_jw_dados_tecnicos_produtos.getMix_produtos()==null?"":t_jw_dados_tecnicos_produtos.getMix_produtos();
                      cnpj = t_jw_dados_tecnicos_produtos.getCnpj();
                      ean13 = t_jw_dados_tecnicos_produtos.getEan13();
                      dun14 = t_jw_dados_tecnicos_produtos.getDun14();
                      classificacao_fiscal = t_jw_dados_tecnicos_produtos.getClassificacao_fiscal()==null?"":t_jw_dados_tecnicos_produtos.getClassificacao_fiscal();
                      comp_larg_alt_embalagem = t_jw_dados_tecnicos_produtos.getComp_larg_alt_embalagem()==null?"":t_jw_dados_tecnicos_produtos.getComp_larg_alt_embalagem();
                      peso_embalamgem = t_jw_dados_tecnicos_produtos.getPeso_embalamgem();
                      peso_sapato = t_jw_dados_tecnicos_produtos.getPeso_sapato();
                      ra_fornecedor = t_jw_dados_tecnicos_produtos.getRa_fornecedor()==null?"":t_jw_dados_tecnicos_produtos.getRa_fornecedor();
                      razao_social = t_jw_dados_tecnicos_produtos.getRazao_social()==null?"":t_jw_dados_tecnicos_produtos.getRazao_social();
                      ref_fechamento_sapato = t_jw_dados_tecnicos_produtos.getRef_fechamento_sapato()==null?"":t_jw_dados_tecnicos_produtos.getRef_fechamento_sapato();
                      ref_tipo_salto = t_jw_dados_tecnicos_produtos.getRef_tipo_salto()==null?"":t_jw_dados_tecnicos_produtos.getRef_tipo_salto();
                      ref_bota_possui_elastico = t_jw_dados_tecnicos_produtos.getRef_bota_possui_elastico()==null?"":t_jw_dados_tecnicos_produtos.getRef_bota_possui_elastico();
                      ref_tip_mat_cdgo_palmilha = t_jw_dados_tecnicos_produtos.getRef_tip_mat_cdgo_palmilha();
                      tip_mat_palmilha_descricao = t_jw_dados_tecnicos_produtos.getTip_mat_palmilha_descricao()==null?"":t_jw_dados_tecnicos_produtos.getTip_mat_palmilha_descricao();
                      ref_tip_mat_cdgo_entresola = t_jw_dados_tecnicos_produtos.getRef_tip_mat_cdgo_entresola();
                      tip_mat_entresola_descricao = t_jw_dados_tecnicos_produtos.getTip_mat_entresola_descricao()==null?"":t_jw_dados_tecnicos_produtos.getTip_mat_entresola_descricao();
                      ref_tip_mat_cdgo_salto = t_jw_dados_tecnicos_produtos.getRef_tip_mat_cdgo_salto();
                      tip_mat_salto_descricao = t_jw_dados_tecnicos_produtos.getTip_mat_salto_descricao()==null?"":t_jw_dados_tecnicos_produtos.getTip_mat_salto_descricao();
                      ref_tip_mat_cdgo_meiapata = t_jw_dados_tecnicos_produtos.getRef_tip_mat_cdgo_meiapata();
                      tip_mat_meiapata_descricao = t_jw_dados_tecnicos_produtos.getTip_mat_meiapata_descricao()==null?"":t_jw_dados_tecnicos_produtos.getTip_mat_meiapata_descricao();
                      ref_dimensao_cx_individual = t_jw_dados_tecnicos_produtos.getRef_dimensao_cx_individual();
                      dimensao_caixa_descricao = t_jw_dados_tecnicos_produtos.getDimensao_caixa_descricao()==null?"":t_jw_dados_tecnicos_produtos.getDimensao_caixa_descricao();
                      observacao = t_jw_dados_tecnicos_produtos.getObservacao()==null?"":t_jw_dados_tecnicos_produtos.getObservacao();
                      ref_largura_interna_pe = t_jw_dados_tecnicos_produtos.getRef_largura_interna_pe();
                      ref_compr_interno_pe = t_jw_dados_tecnicos_produtos.getRef_compr_interno_pe();
                      ref_altura_sapato = t_jw_dados_tecnicos_produtos.getRef_altura_sapato();
                      ref_largura_ext_sapato = t_jw_dados_tecnicos_produtos.getRef_largura_ext_sapato();
                      ref_compr_ext_sapato = t_jw_dados_tecnicos_produtos.getRef_compr_ext_sapato();
                      ref_altura_salto = t_jw_dados_tecnicos_produtos.getRef_altura_salto();
                      ref_altura_meiapata = t_jw_dados_tecnicos_produtos.getRef_altura_meiapata();
                      ref_altura_canobota = t_jw_dados_tecnicos_produtos.getRef_altura_canobota();

                      comprimento_embalagem = t_jw_dados_tecnicos_produtos.getComprimento_embalagem();
                      largura_embalagem = t_jw_dados_tecnicos_produtos.getLargura_embalagem();
                      altura_embalagem = t_jw_dados_tecnicos_produtos.getAltura_embalagem();

                      comprimento_caixa = t_jw_dados_tecnicos_produtos.getComprimento_caixa();
                      largura_caixa = t_jw_dados_tecnicos_produtos.getLargura_caixa();
                      altura_caixa = t_jw_dados_tecnicos_produtos.getAltura_caixa();

                      ref_diametro_boca_bota = t_jw_dados_tecnicos_produtos.getRef_diametro_boca_bota();
                      grupo_posicao_fabrica = t_jw_dados_tecnicos_produtos.getGrupo_posicao_fabrica()==null?"":t_jw_dados_tecnicos_produtos.getGrupo_posicao_fabrica();
                      tipo_material_predominante = t_jw_dados_tecnicos_produtos.getTipo_material_predominante()==null?"":t_jw_dados_tecnicos_produtos.getTipo_material_predominante();
                      tipo_material_solado = t_jw_dados_tecnicos_produtos.getTipo_material_solado()==null?"":t_jw_dados_tecnicos_produtos.getTipo_material_solado();
                      tipo_material_forro = t_jw_dados_tecnicos_produtos.getTipo_material_forro()==null?"":t_jw_dados_tecnicos_produtos.getTipo_material_forro();
                      ref_perc_cabedal = t_jw_dados_tecnicos_produtos.getRef_perc_cabedal();
                      ref_perc_solado = t_jw_dados_tecnicos_produtos.getRef_perc_solado();
                      numero_exterior = t_jw_dados_tecnicos_produtos.getNumero_exterior()==null?"":t_jw_dados_tecnicos_produtos.getNumero_exterior();
                      preco_pdv = t_jw_dados_tecnicos_produtos.getPreco_pdv();
                      fci = t_jw_dados_tecnicos_produtos.getFci()==null?"":t_jw_dados_tecnicos_produtos.getFci();
                      cst = t_jw_dados_tecnicos_produtos.getCst()==null?"":t_jw_dados_tecnicos_produtos.getCst();
                      tipo_material_palmilha = t_jw_dados_tecnicos_produtos.getTipo_material_palmilha()==null?"":t_jw_dados_tecnicos_produtos.getTipo_material_palmilha();
                      ped_nmro = t_jw_dados_tecnicos_produtos.getPed_nmro();
                      ite_seqn = t_jw_dados_tecnicos_produtos.getIte_seqn();
                      ped_ped_cliente = t_jw_dados_tecnicos_produtos.getPed_ped_cliente()==null?"":t_jw_dados_tecnicos_produtos.getPed_ped_cliente();
                      altura_alca = t_jw_dados_tecnicos_produtos.getAltura_alca()==null?"":t_jw_dados_tecnicos_produtos.getAltura_alca();
                      altura_bolsa = t_jw_dados_tecnicos_produtos.getAltura_bolsa()==null?"":t_jw_dados_tecnicos_produtos.getAltura_bolsa();
                      bolso_interno = t_jw_dados_tecnicos_produtos.getBolso_interno()==null?"":t_jw_dados_tecnicos_produtos.getBolso_interno();
                      fechamento_bolsa = t_jw_dados_tecnicos_produtos.getFechamento_bolsa()==null?"":t_jw_dados_tecnicos_produtos.getFechamento_bolsa();
                      largura_bolsa = t_jw_dados_tecnicos_produtos.getLargura_bolsa()==null?"":t_jw_dados_tecnicos_produtos.getLargura_bolsa();
                      peso_bolsa = t_jw_dados_tecnicos_produtos.getPeso_bolsa()==null?"":t_jw_dados_tecnicos_produtos.getPeso_bolsa();
                      profundidade_bolsa = t_jw_dados_tecnicos_produtos.getProfundidade_bolsa()==null?"":t_jw_dados_tecnicos_produtos.getProfundidade_bolsa();
                      quantidade_bolsos = t_jw_dados_tecnicos_produtos.getQuantidade_bolsos()==null?"":t_jw_dados_tecnicos_produtos.getQuantidade_bolsos();
                      regulagem = t_jw_dados_tecnicos_produtos.getRegulagem()==null?"":t_jw_dados_tecnicos_produtos.getRegulagem();
                      tipo_alca = t_jw_dados_tecnicos_produtos.getTipo_alca()==null?"":t_jw_dados_tecnicos_produtos.getTipo_alca();
                      tem_etiqueta = t_jw_dados_tecnicos_produtos.getTem_etiqueta();
                      String style_bl_report_Jw_dados_tecnicos_produtos="";
                      if (!((i_bl_report_Jw_dados_tecnicos_produtos%2)!=0)) {
                        style_bl_report_Jw_dados_tecnicos_produtos="rowColor";
                      } else {
                        style_bl_report_Jw_dados_tecnicos_produtos="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_dados_tecnicos_produtos %>' id="TRbl_report_Jw_dados_tecnicos_produtos<%=i_bl_report_Jw_dados_tecnicos_produtos%>" >


                        <%
                        if(consultaPorPedido){
                          %>
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <td class="reportColumn" style="text-align:center;" >
                              <%
                              if(tem_etiqueta.equalsIgnoreCase("S")){
                                %>
                                <img src="../img/green.gif" />
                                <%
                              } else {
                                %>
                                <img src="../img/gray.gif" />
                                <%
                              }
                              %>
                            </td>
                            <%
                          } else {
                            %>
                            <td class="reportColumn" style="text-align:center;" >
                              <%
                              if(tem_etiqueta.equalsIgnoreCase("S")){
                                %>
                                Sim
                                <%
                              } else {
                                %>
                                Não
                                <%
                              }
                              %>
                            </td>
                            <%
                          }
                          %>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= ped_nmro %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= ped_ped_cliente %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= ((lin_cdgo!=null)?lin_cdgo.toString():"") %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= ((ref_cdgo!=null)?ref_cdgo.toString():"") %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= ((cab_cdgo!=null)?cab_cdgo.toString():"") %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= ((cab_desc!=null)?cab_desc:"") %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= ((cor_cdgo!=null)?cor_cdgo.toString():"") %>
                            -
                            <%= descricao_cor %>
                          </td>

                          <td class="reportColumn" style="text-align: left;" >
                            <!--
                              <%= ((ref_tip_mat_cdgo_palmilha!=null)?ref_tip_mat_cdgo_palmilha.toString():"") %> <%= ref_tip_mat_cdgo_palmilha!=null?"-":""%> <%= tip_mat_palmilha_descricao %>
                            -->
                            <%= tipo_material_palmilha %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= tipo_material_predominante %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= tipo_material_solado %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= tipo_material_forro %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= mix_produtos %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= ((preco_pdv!=null)?preco_pdv.toString():"") %>
                          </td>

                          <%
                        } else {
                          %>
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <td class="reportColumn" style="text-align:center;" >
                              <%
                              if(tem_etiqueta.equalsIgnoreCase("S")){
                                %>
                                <img src="../img/green.gif" />
                                <%
                              } else {
                                %>
                                <img src="../img/gray.gif" />
                                <%
                              }
                              %>
                            </td>
                            <%
                          }else{
                            %>
                            <td class="reportColumn" style="text-align:center;" >
                              <%
                              if(tem_etiqueta.equalsIgnoreCase("S")){
                                %>
                                Sim
                                <%
                              } else {
                                %>
                                Não
                                <%
                              }
                              %>
                            </td>
                            <%
                          }
                          %>

                          <%
                          if(mostrarPedidoItem) {
                            %>

                            <td class="reportColumn" style="text-align:center;" >
                              <%= ((ped_nmro!=null)?ped_nmro.toString():"") %>
                            </td>

                            <td class="reportColumn" style="text-align:center;" >
                              <%= ped_ped_cliente %>
                            </td>

                            <td class="reportColumn" style="text-align:center;" >
                              <%= ((ite_seqn!=null)?ite_seqn.toString():"") %>
                            </td>

                            <%
                          }
                          %>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= ((lin_cdgo!=null)?lin_cdgo.toString():"") %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= ((ref_cdgo!=null)?ref_cdgo.toString():"") %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= ((cab_cdgo!=null)?cab_cdgo.toString():"") %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= ((cab_desc!=null)?cab_desc:"") %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= ((cor_cdgo!=null)?cor_cdgo.toString():"") %>
                            -
                            <%= descricao_cor %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= desc_produto %>
                          </td>

                          <%
                          if(consultaPorFatura){
                            %>
                            <td class="reportColumn" style="text-align:center;" >
                              <%= qtp_nume %>
                            </td>
                            <td class="reportColumn" style="text-align:center;" >
                              <%= numero_exterior %>
                            </td>
                            <%
                          } else {
                            %>
                            <td class="reportColumn" style="text-align:center;" >
                              <%= qtp_nume %>
                            </td>
                            <%
                          }
                          %>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= qtp_pars %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%="R$"+ ite_prco%>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= id_produto %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= ((marca!=null)?marca.toString():"") %>
                            -
                            <%= marca_descricao %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= filial %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= " " + ((cnpj!=null)?cnpj.toString():"")+" " %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= ((ean13!=null)?ean13.toString():"") %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= ((dun14!=null)?dun14:"") %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= classificacao_fiscal %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= comprimento_embalagem %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= largura_embalagem %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= altura_embalagem %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(peso_embalamgem, "##,##0.00") %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(peso_sapato, "##,##0.00") %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= ra_fornecedor %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= razao_social %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= ref_fechamento_sapato %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= ref_tipo_salto %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= ref_bota_possui_elastico %>
                          </td>

                          <!--
                            <td class="reportColumn" style="text-align:right;" > <%= ((ref_tip_mat_cdgo_palmilha!=null)?ref_tip_mat_cdgo_palmilha.toString():"") %> <%= ref_tip_mat_cdgo_palmilha!=null?"-":""%> <%= tip_mat_palmilha_descricao %> </td>
                          -->
                          <td class="reportColumn" style="text-align:right;" >
                            <%= tipo_material_palmilha %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= ((ref_tip_mat_cdgo_entresola!=null)?ref_tip_mat_cdgo_entresola.toString():"") %>
                            <%= ref_tip_mat_cdgo_entresola!=null?"-":"" %>
                            <%= tip_mat_entresola_descricao %>
                          </td>
                          <td class="reportColumn" style="text-align:left;" >
                            <%= ((ref_tip_mat_cdgo_salto!=null)?ref_tip_mat_cdgo_salto.toString():"") %>
                            <%= ref_tip_mat_cdgo_salto!=null?"-":"" %>
                            <%= tip_mat_salto_descricao %>
                          </td>
                          <td class="reportColumn" style="text-align:left;" >
                            <%= ((ref_tip_mat_cdgo_meiapata!=null)?ref_tip_mat_cdgo_meiapata.toString():"") %>
                            <%= ref_tip_mat_cdgo_meiapata!=null?"-":"" %>
                            <%= tip_mat_meiapata_descricao %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= comprimento_caixa %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= largura_caixa %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= altura_caixa %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= observacao %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(ref_largura_interna_pe, "##,##0.00") %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(ref_compr_interno_pe, "##,##0.00") %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(ref_altura_sapato, "##,##0.00") %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(ref_largura_ext_sapato, "##,##0.00") %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(ref_compr_ext_sapato, "##,##0.00") %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(ref_altura_salto, "##,##0.00") %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(ref_altura_meiapata, "##,##0.00") %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(ref_altura_canobota, "##,##0.00") %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(ref_diametro_boca_bota, "##,##0.00") %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= grupo_posicao_fabrica %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= tipo_material_predominante %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= tipo_material_solado %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= tipo_material_forro %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= ((ref_perc_cabedal!=null)?ref_perc_cabedal.toString():"") %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= ((ref_perc_solado!=null)?ref_perc_solado.toString():"") %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= fci %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= cst %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= mix_produtos %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= ((preco_pdv!=null)?preco_pdv.toString():"") %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= altura_alca %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= altura_bolsa %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= bolso_interno %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= fechamento_bolsa %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= largura_bolsa %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= peso_bolsa %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= profundidade_bolsa %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= quantidade_bolsos %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= regulagem %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= tipo_alca %>
                          </td>

                          <%
                        }
                        %>

                      </tr>

                      <%
                      i_bl_report_Jw_dados_tecnicos_produtos++;
                      if (i_bl_report_Jw_dados_tecnicos_produtos<res_Jw_dados_tecnicos_produtos.size()) {
                        t_jw_dados_tecnicos_produtos = (portalbr.dbobj.view.Jw_dados_tecnicos_produtos)res_Jw_dados_tecnicos_produtos.elementAt(i_bl_report_Jw_dados_tecnicos_produtos);
                        lin_cdgo = t_jw_dados_tecnicos_produtos.getLin_cdgo();
                        ref_cdgo = t_jw_dados_tecnicos_produtos.getRef_cdgo();
                        cab_cdgo = t_jw_dados_tecnicos_produtos.getCab_cdgo();
                        cor_cdgo = t_jw_dados_tecnicos_produtos.getCor_cdgo();
                        ite_seqn = t_jw_dados_tecnicos_produtos.getIte_seqn();
                        descricao_cor = t_jw_dados_tecnicos_produtos.getDescricao_cor()==null?"":t_jw_dados_tecnicos_produtos.getDescricao_cor();
                        desc_produto = t_jw_dados_tecnicos_produtos.getDesc_produto()==null?"":t_jw_dados_tecnicos_produtos.getDesc_produto();
                        qtp_nume = t_jw_dados_tecnicos_produtos.getQtp_nume()==null?"":t_jw_dados_tecnicos_produtos.getQtp_nume();
                        qtp_pars = t_jw_dados_tecnicos_produtos.getQtp_pars()==null?"":t_jw_dados_tecnicos_produtos.getQtp_pars()+"";
                        ite_prco = t_jw_dados_tecnicos_produtos.getIte_prco();
                        id_produto = t_jw_dados_tecnicos_produtos.getId_produto()==null?"":t_jw_dados_tecnicos_produtos.getId_produto();
                        marca = t_jw_dados_tecnicos_produtos.getMarca();
                        marca_descricao = t_jw_dados_tecnicos_produtos.getMarca_descricao()==null?"":t_jw_dados_tecnicos_produtos.getMarca_descricao();
                        cab_desc = t_jw_dados_tecnicos_produtos.getCab_desc()==null?"":t_jw_dados_tecnicos_produtos.getCab_desc();
                        filial = t_jw_dados_tecnicos_produtos.getFilial()==null?"":t_jw_dados_tecnicos_produtos.getFilial();
                        mix_produtos = t_jw_dados_tecnicos_produtos.getMix_produtos()==null?"":t_jw_dados_tecnicos_produtos.getMix_produtos();
                        cnpj = t_jw_dados_tecnicos_produtos.getCnpj();
                        ean13 = t_jw_dados_tecnicos_produtos.getEan13();
                        dun14 = t_jw_dados_tecnicos_produtos.getDun14();
                        classificacao_fiscal = t_jw_dados_tecnicos_produtos.getClassificacao_fiscal()==null?"":t_jw_dados_tecnicos_produtos.getClassificacao_fiscal();
                        comp_larg_alt_embalagem = t_jw_dados_tecnicos_produtos.getComp_larg_alt_embalagem()==null?"":t_jw_dados_tecnicos_produtos.getComp_larg_alt_embalagem();
                        peso_embalamgem = t_jw_dados_tecnicos_produtos.getPeso_embalamgem();
                        peso_sapato = t_jw_dados_tecnicos_produtos.getPeso_sapato();
                        ra_fornecedor = t_jw_dados_tecnicos_produtos.getRa_fornecedor()==null?"":t_jw_dados_tecnicos_produtos.getRa_fornecedor();
                        razao_social = t_jw_dados_tecnicos_produtos.getRazao_social()==null?"":t_jw_dados_tecnicos_produtos.getRazao_social();
                        ref_fechamento_sapato = t_jw_dados_tecnicos_produtos.getRef_fechamento_sapato()==null?"":t_jw_dados_tecnicos_produtos.getRef_fechamento_sapato();
                        ref_tipo_salto = t_jw_dados_tecnicos_produtos.getRef_tipo_salto()==null?"":t_jw_dados_tecnicos_produtos.getRef_tipo_salto();
                        ref_bota_possui_elastico = t_jw_dados_tecnicos_produtos.getRef_bota_possui_elastico()==null?"":t_jw_dados_tecnicos_produtos.getRef_bota_possui_elastico();
                        ref_tip_mat_cdgo_palmilha = t_jw_dados_tecnicos_produtos.getRef_tip_mat_cdgo_palmilha();
                        tip_mat_palmilha_descricao = t_jw_dados_tecnicos_produtos.getTip_mat_palmilha_descricao()==null?"":t_jw_dados_tecnicos_produtos.getTip_mat_palmilha_descricao();
                        ref_tip_mat_cdgo_entresola = t_jw_dados_tecnicos_produtos.getRef_tip_mat_cdgo_entresola();
                        tip_mat_entresola_descricao = t_jw_dados_tecnicos_produtos.getTip_mat_entresola_descricao()==null?"":t_jw_dados_tecnicos_produtos.getTip_mat_entresola_descricao();
                        ref_tip_mat_cdgo_salto = t_jw_dados_tecnicos_produtos.getRef_tip_mat_cdgo_salto();
                        tip_mat_salto_descricao = t_jw_dados_tecnicos_produtos.getTip_mat_salto_descricao()==null?"":t_jw_dados_tecnicos_produtos.getTip_mat_salto_descricao();
                        ref_tip_mat_cdgo_meiapata = t_jw_dados_tecnicos_produtos.getRef_tip_mat_cdgo_meiapata();
                        tip_mat_meiapata_descricao = t_jw_dados_tecnicos_produtos.getTip_mat_meiapata_descricao()==null?"":t_jw_dados_tecnicos_produtos.getTip_mat_meiapata_descricao();
                        ref_dimensao_cx_individual = t_jw_dados_tecnicos_produtos.getRef_dimensao_cx_individual();
                        dimensao_caixa_descricao = t_jw_dados_tecnicos_produtos.getDimensao_caixa_descricao()==null?"":t_jw_dados_tecnicos_produtos.getDimensao_caixa_descricao();
                        observacao = t_jw_dados_tecnicos_produtos.getObservacao()==null?"":t_jw_dados_tecnicos_produtos.getObservacao();
                        ref_largura_interna_pe = t_jw_dados_tecnicos_produtos.getRef_largura_interna_pe();
                        ref_compr_interno_pe = t_jw_dados_tecnicos_produtos.getRef_compr_interno_pe();
                        ref_altura_sapato = t_jw_dados_tecnicos_produtos.getRef_altura_sapato();
                        ref_largura_ext_sapato = t_jw_dados_tecnicos_produtos.getRef_largura_ext_sapato();
                        ref_compr_ext_sapato = t_jw_dados_tecnicos_produtos.getRef_compr_ext_sapato();
                        ref_altura_salto = t_jw_dados_tecnicos_produtos.getRef_altura_salto();
                        ref_altura_meiapata = t_jw_dados_tecnicos_produtos.getRef_altura_meiapata();
                        comprimento_embalagem = t_jw_dados_tecnicos_produtos.getComprimento_embalagem();
                        largura_embalagem = t_jw_dados_tecnicos_produtos.getLargura_embalagem();
                        altura_embalagem = t_jw_dados_tecnicos_produtos.getAltura_embalagem();
                        comprimento_caixa = t_jw_dados_tecnicos_produtos.getComprimento_caixa();
                        largura_caixa = t_jw_dados_tecnicos_produtos.getLargura_caixa();
                        altura_caixa = t_jw_dados_tecnicos_produtos.getAltura_caixa();
                        ref_altura_canobota = t_jw_dados_tecnicos_produtos.getRef_altura_canobota();
                        ref_diametro_boca_bota = t_jw_dados_tecnicos_produtos.getRef_diametro_boca_bota();
                        grupo_posicao_fabrica = t_jw_dados_tecnicos_produtos.getGrupo_posicao_fabrica()==null?"":t_jw_dados_tecnicos_produtos.getGrupo_posicao_fabrica();
                        tipo_material_predominante = t_jw_dados_tecnicos_produtos.getTipo_material_predominante()==null?"":t_jw_dados_tecnicos_produtos.getTipo_material_predominante();
                        tipo_material_solado = t_jw_dados_tecnicos_produtos.getTipo_material_solado()==null?"":t_jw_dados_tecnicos_produtos.getTipo_material_solado();
                        tipo_material_forro = t_jw_dados_tecnicos_produtos.getTipo_material_forro()==null?"":t_jw_dados_tecnicos_produtos.getTipo_material_forro();
                        ref_perc_cabedal = t_jw_dados_tecnicos_produtos.getRef_perc_cabedal();
                        ref_perc_solado = t_jw_dados_tecnicos_produtos.getRef_perc_solado();
                        numero_exterior = t_jw_dados_tecnicos_produtos.getNumero_exterior()==null?"":t_jw_dados_tecnicos_produtos.getNumero_exterior();
                        preco_pdv = t_jw_dados_tecnicos_produtos.getPreco_pdv();
                        fci = t_jw_dados_tecnicos_produtos.getFci()==null?"":t_jw_dados_tecnicos_produtos.getFci();
                        cst = t_jw_dados_tecnicos_produtos.getCst()==null?"":t_jw_dados_tecnicos_produtos.getCst();
                        tipo_material_palmilha = t_jw_dados_tecnicos_produtos.getTipo_material_palmilha()==null?"":t_jw_dados_tecnicos_produtos.getTipo_material_palmilha();
                        ped_nmro = t_jw_dados_tecnicos_produtos.getPed_nmro();
                        ped_ped_cliente = t_jw_dados_tecnicos_produtos.getPed_ped_cliente()==null?"":t_jw_dados_tecnicos_produtos.getPed_ped_cliente();
                        altura_alca = t_jw_dados_tecnicos_produtos.getAltura_alca()==null?"":t_jw_dados_tecnicos_produtos.getAltura_alca();
                        altura_bolsa = t_jw_dados_tecnicos_produtos.getAltura_bolsa()==null?"":t_jw_dados_tecnicos_produtos.getAltura_bolsa();
                        bolso_interno = t_jw_dados_tecnicos_produtos.getBolso_interno()==null?"":t_jw_dados_tecnicos_produtos.getBolso_interno();
                        fechamento_bolsa = t_jw_dados_tecnicos_produtos.getFechamento_bolsa()==null?"":t_jw_dados_tecnicos_produtos.getFechamento_bolsa();
                        largura_bolsa = t_jw_dados_tecnicos_produtos.getLargura_bolsa()==null?"":t_jw_dados_tecnicos_produtos.getLargura_bolsa();
                        peso_bolsa = t_jw_dados_tecnicos_produtos.getPeso_bolsa()==null?"":t_jw_dados_tecnicos_produtos.getPeso_bolsa();
                        profundidade_bolsa = t_jw_dados_tecnicos_produtos.getProfundidade_bolsa()==null?"":t_jw_dados_tecnicos_produtos.getProfundidade_bolsa();
                        quantidade_bolsos = t_jw_dados_tecnicos_produtos.getQuantidade_bolsos()==null?"":t_jw_dados_tecnicos_produtos.getQuantidade_bolsos();
                        regulagem = t_jw_dados_tecnicos_produtos.getRegulagem()==null?"":t_jw_dados_tecnicos_produtos.getRegulagem();
                        tipo_alca = t_jw_dados_tecnicos_produtos.getTipo_alca()==null?"":t_jw_dados_tecnicos_produtos.getTipo_alca();
                        tem_etiqueta = t_jw_dados_tecnicos_produtos.getTem_etiqueta();
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
            <html:form action="ind/DadosTecnicosProdutos_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="buttonTable" style='width:99%;'>
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

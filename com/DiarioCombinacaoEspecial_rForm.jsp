<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Diário de Combinações Especiais
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(138)){
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
              java.util.Vector res_Jw_ref_combinacao_especial = (java.util.Vector)session.getAttribute("res_Jw_ref_combinacao_especial");
              %>

              <form  name="bl_report_Jw_ref_combinacao_especial" id="bl_report_Jw_ref_combinacao_especial" class="baseForm" method="post" >
                <%
                if (res_Jw_ref_combinacao_especial!=null && res_Jw_ref_combinacao_especial.size()>0) {
                  if ( ((String)request.getParameter("_ordered"))!=null && ((String)request.getParameter("_ordered")).length()>0 ) {
                    boolean reverse = false;
                    if ( ((String)request.getParameter("_reverse"))!=null && ((String)request.getParameter("_reverse")).equals("true") ){
                      reverse = true;
                    }
                    try {
                      res_Jw_ref_combinacao_especial = com.egen.util.text.Sort.execute(res_Jw_ref_combinacao_especial,((String)request.getParameter("_ordered")),reverse);
                      session.setAttribute("res_Jw_ref_combinacao_especial", res_Jw_ref_combinacao_especial);
                    } catch (Exception e) {}
                  }
                  %>

                  <table id="TRbl_report_Jw_ref_combinacao_especial"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Integer id_solicitacao =  null;
                    java.lang.String usuario_solicitacao =  null;
                    java.sql.Timestamp data_solicitacao =  null;
                    java.lang.Integer codigo_marca =  null;
                    java.lang.String nome_marca =  null;
                    java.sql.Timestamp data_entrega_prevista =  null;
                    java.sql.Timestamp data_entrega_solicitada =  null;
                    java.sql.Timestamp data_entrega_amostra =  null;
                    java.lang.Integer lin_cdgo =  null;
                    java.lang.String lin_nome =  null;
                    java.lang.Integer ref_cdgo =  null;
                    java.lang.String ref_desc =  null;
                    java.lang.Integer cli_cdgo =  null;
                    java.lang.String cliente_grupo_economico =  null;
                    java.lang.Integer pares_alteracao =  null;
                    java.lang.String situacao_solicitacao_desc =  null;
                    java.lang.Integer cab_cdgo =  null;
                    java.lang.String cab_desc =  null;
                    java.lang.Integer cor_cdgo =  null;
                    java.lang.String cor_desc =  null;
                    java.lang.String descricao =  null;
                    java.lang.String observacao =  null;
                    java.lang.String material_cor1 =  null;
                    java.lang.String material_cor2 =  null;
                    java.lang.String material_cor3 =  null;
                    java.lang.String biqueira_debrum =  null;
                    java.lang.String capa_palmilha =  null;
                    java.lang.String cacharel =  null;
                    java.lang.String forro =  null;
                    java.lang.String metais =  null;
                    java.lang.String taloneira =  null;
                    java.lang.String salto =  null;
                    java.lang.String enfeite =  null;
                    java.lang.String carimbo_etiqueta =  null;
                    java.lang.String cli_rzao =  null;
                    java.lang.Integer prs_negociacao =  null;
                    java.lang.Integer pares_linha =  null;
                    java.lang.Double ll_alteracao_solicitada =  null;
                    java.lang.String situacao_solicitacao =  null;
                    java.lang.Double preco_liguido =  null;
                    java.sql.Date data_aceite =  null;
                    java.lang.String usuario_aceite =  null;
                    java.lang.String nova_combinacao =  null;
                    java.lang.String alteracao_modelo =  null;
                    java.lang.String amostra =  null;
                    java.lang.String tipo_solicitacao =  null;
                    java.lang.String desc_solicitacao_comb_especial =  null;
                    java.lang.String desenvolvimento =  null;
                    java.lang.String fora_mix =  null;
                    java.lang.String manipulacao =  null;
                    java.lang.String modelo_exclusivo =  null;
                    java.lang.Double valor_fabricacao =  null;
                    java.lang.Double valor_pdv =  null;
                    java.lang.Double ll_0 =  null;
                    java.lang.Double ll_1 =  null;
                    java.lang.Double ll_2 =  null;
                    java.lang.Double ll_3 =  null;
                    java.lang.Double preco_vendor =  null;
                    int sum_pares_alteracao_0 = 0;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:center;" >
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          ID
                          <%
                          if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                            %>
                            <a href='DiarioCombinacaoEspecial_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","id_solicitacao")%>' class="reportOrder">
                              <bean:message key="report.orderedasc"/>
                            </a>
                            <%
                          } else {
                            %>
                            <a href='DiarioCombinacaoEspecial_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","id_solicitacao")%>' class="reportOrder">
                              <bean:message key="report.ordereddesc"/>
                            </a>
                            <%
                          }
                          %>
                          <%
                        } else {
                          %>
                          ID
                          <%
                        }
                        %>
                      </td>
                      <td  class="columnTdHeader" style="text-align:center;" >
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          Data
                          <%
                          if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                            %>
                            <a href='DiarioCombinacaoEspecial_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","data_solicitacao")%>' class="reportOrder">
                              <bean:message key="report.orderedasc"/>
                            </a>
                            <%
                          } else {
                            %>
                            <a href='DiarioCombinacaoEspecial_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","data_solicitacao")%>' class="reportOrder">
                              <bean:message key="report.ordereddesc"/>
                            </a>
                            <%
                          }
                          %>
                          <%
                        } else {
                          %>
                          Data
                          <%
                        }
                        %>
                      </td>
                      <td class="columnTdHeader" style="text-align:center;" >
                        Marca
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Linha
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Ref.
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Cliente / Grupo Econômico
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        CTF
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        PV
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_ref_combinacao_especial = 0;
                    while (i_bl_report_Jw_ref_combinacao_especial<res_Jw_ref_combinacao_especial.size()) {
                      portalbr.dbobj.view.Jw_ref_combinacao_especial t_jw_ref_combinacao_especial = (portalbr.dbobj.view.Jw_ref_combinacao_especial)res_Jw_ref_combinacao_especial.elementAt(i_bl_report_Jw_ref_combinacao_especial);
                      id_solicitacao = t_jw_ref_combinacao_especial.getId_solicitacao();
                      usuario_solicitacao = t_jw_ref_combinacao_especial.getUsuario_solicitacao()==null?"":t_jw_ref_combinacao_especial.getUsuario_solicitacao();
                      data_solicitacao = (java.sql.Timestamp)t_jw_ref_combinacao_especial.getData_solicitacao();
                      codigo_marca = t_jw_ref_combinacao_especial.getCodigo_marca();
                      nome_marca = t_jw_ref_combinacao_especial.getNome_marca()==null?"":t_jw_ref_combinacao_especial.getNome_marca();
                      data_entrega_prevista = (java.sql.Timestamp)t_jw_ref_combinacao_especial.getData_entrega_prevista();
                      data_entrega_solicitada = (java.sql.Timestamp)t_jw_ref_combinacao_especial.getData_entrega_solicitada();
                      data_entrega_amostra = (java.sql.Timestamp)t_jw_ref_combinacao_especial.getData_entrega_amostra();
                      lin_cdgo = t_jw_ref_combinacao_especial.getLin_cdgo();
                      lin_nome = t_jw_ref_combinacao_especial.getLin_nome()==null?"":t_jw_ref_combinacao_especial.getLin_nome();
                      ref_cdgo = t_jw_ref_combinacao_especial.getRef_cdgo();
                      ref_desc = t_jw_ref_combinacao_especial.getRef_desc()==null?"":t_jw_ref_combinacao_especial.getRef_desc();
                      cli_cdgo = t_jw_ref_combinacao_especial.getCli_cdgo();
                      cliente_grupo_economico = t_jw_ref_combinacao_especial.getCliente_grupo_economico()==null?"":t_jw_ref_combinacao_especial.getCliente_grupo_economico();
                      pares_alteracao = t_jw_ref_combinacao_especial.getPares_alteracao();
                      situacao_solicitacao_desc = t_jw_ref_combinacao_especial.getSituacao_solicitacao_desc()==null?"":t_jw_ref_combinacao_especial.getSituacao_solicitacao_desc();
                      cab_cdgo = t_jw_ref_combinacao_especial.getCab_cdgo();
                      cab_desc = t_jw_ref_combinacao_especial.getCab_desc()==null?"":t_jw_ref_combinacao_especial.getCab_desc();
                      cor_cdgo = t_jw_ref_combinacao_especial.getCor_cdgo();
                      cor_desc = t_jw_ref_combinacao_especial.getCor_desc()==null?"":t_jw_ref_combinacao_especial.getCor_desc();
                      descricao = t_jw_ref_combinacao_especial.getDescricao()==null?"":t_jw_ref_combinacao_especial.getDescricao();
                      observacao = t_jw_ref_combinacao_especial.getObservacao()==null?"":t_jw_ref_combinacao_especial.getObservacao();
                      material_cor1 = t_jw_ref_combinacao_especial.getMaterial_cor1()==null?"":t_jw_ref_combinacao_especial.getMaterial_cor1();
                      material_cor2 = t_jw_ref_combinacao_especial.getMaterial_cor2()==null?"":t_jw_ref_combinacao_especial.getMaterial_cor2();
                      material_cor3 = t_jw_ref_combinacao_especial.getMaterial_cor3()==null?"":t_jw_ref_combinacao_especial.getMaterial_cor3();
                      biqueira_debrum = t_jw_ref_combinacao_especial.getBiqueira_debrum()==null?"":t_jw_ref_combinacao_especial.getBiqueira_debrum();
                      capa_palmilha = t_jw_ref_combinacao_especial.getCapa_palmilha()==null?"":t_jw_ref_combinacao_especial.getCapa_palmilha();
                      cacharel = t_jw_ref_combinacao_especial.getCacharel()==null?"":t_jw_ref_combinacao_especial.getCacharel();
                      forro = t_jw_ref_combinacao_especial.getForro()==null?"":t_jw_ref_combinacao_especial.getForro();
                      metais = t_jw_ref_combinacao_especial.getMetais()==null?"":t_jw_ref_combinacao_especial.getMetais();
                      taloneira = t_jw_ref_combinacao_especial.getTaloneira()==null?"":t_jw_ref_combinacao_especial.getTaloneira();
                      salto = t_jw_ref_combinacao_especial.getSalto()==null?"":t_jw_ref_combinacao_especial.getSalto();
                      enfeite = t_jw_ref_combinacao_especial.getEnfeite()==null?"":t_jw_ref_combinacao_especial.getEnfeite();
                      carimbo_etiqueta = t_jw_ref_combinacao_especial.getCarimbo_etiqueta()==null?"":t_jw_ref_combinacao_especial.getCarimbo_etiqueta();
                      cli_rzao = t_jw_ref_combinacao_especial.getCli_rzao()==null?"":t_jw_ref_combinacao_especial.getCli_rzao();
                      prs_negociacao = t_jw_ref_combinacao_especial.getPrs_negociacao();
                      pares_linha = t_jw_ref_combinacao_especial.getPares_linha();
                      ll_alteracao_solicitada = t_jw_ref_combinacao_especial.getLl_alteracao_solicitada();
                      situacao_solicitacao = t_jw_ref_combinacao_especial.getSituacao_solicitacao()==null?"":t_jw_ref_combinacao_especial.getSituacao_solicitacao();
                      preco_liguido = t_jw_ref_combinacao_especial.getPreco_liguido();
                      data_aceite = (java.sql.Date)t_jw_ref_combinacao_especial.getData_aceite();
                      usuario_aceite = t_jw_ref_combinacao_especial.getUsuario_aceite()==null?"":t_jw_ref_combinacao_especial.getUsuario_aceite();
                      nova_combinacao = t_jw_ref_combinacao_especial.getNova_combinacao()==null?"":t_jw_ref_combinacao_especial.getNova_combinacao();
                      alteracao_modelo = t_jw_ref_combinacao_especial.getAlteracao_modelo()==null?"":t_jw_ref_combinacao_especial.getAlteracao_modelo();
                      amostra = t_jw_ref_combinacao_especial.getAmostra()==null?"":t_jw_ref_combinacao_especial.getAmostra();
                      desc_solicitacao_comb_especial = t_jw_ref_combinacao_especial.getDesc_solicitacao_comb_especial()==null?"":t_jw_ref_combinacao_especial.getDesc_solicitacao_comb_especial();
                      desenvolvimento = t_jw_ref_combinacao_especial.getDesenvolvimento()==null?"":t_jw_ref_combinacao_especial.getDesenvolvimento();
                      fora_mix = t_jw_ref_combinacao_especial.getFora_mix()==null?"":t_jw_ref_combinacao_especial.getFora_mix();
                      manipulacao = t_jw_ref_combinacao_especial.getManipulacao()==null?"":t_jw_ref_combinacao_especial.getManipulacao();
                      modelo_exclusivo = t_jw_ref_combinacao_especial.getModelo_exclusivo()==null?"":t_jw_ref_combinacao_especial.getModelo_exclusivo();
                      valor_fabricacao = t_jw_ref_combinacao_especial.getValor_fabricacao();
                      valor_pdv = t_jw_ref_combinacao_especial.getValor_pdv();
                      ll_0 = t_jw_ref_combinacao_especial.getLl_0();
                      ll_1 = t_jw_ref_combinacao_especial.getLl_1();
                      ll_2 = t_jw_ref_combinacao_especial.getLl_2();
                      ll_3 = t_jw_ref_combinacao_especial.getLl_3();
                      preco_vendor = t_jw_ref_combinacao_especial.getPreco_vendor();
                      sum_pares_alteracao_0 += ((pares_alteracao!=null)?pares_alteracao.intValue():0);
                      String style_bl_report_Jw_ref_combinacao_especial="";
                      if (!((i_bl_report_Jw_ref_combinacao_especial%2)!=0)) {
                        style_bl_report_Jw_ref_combinacao_especial="rowColor";
                      } else {
                        style_bl_report_Jw_ref_combinacao_especial="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_ref_combinacao_especial %>' id="TRbl_report_Jw_ref_combinacao_especial<%=i_bl_report_Jw_ref_combinacao_especial%>" >
                        <td class="reportColumn" style="text-align:center;" >
                          <a href="../com/DiarioCombinacaoEspecial_aForm.do?select_action=&id_solicitacao=<%= id_solicitacao %>" style="cursor:hand" onclick="bloqueia();">
                            <%= ((id_solicitacao!=null)?id_solicitacao.toString():"") %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_solicitacao, "dd/MM/yyyy HH:mm:ss") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= nome_marca %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((lin_cdgo!=null)?lin_cdgo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((ref_cdgo!=null)?ref_cdgo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;width:350px;" >
                          <%= cliente_grupo_economico %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= descricao %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(valor_fabricacao, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(preco_vendor, "##,##0.00") %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_ref_combinacao_especial++;
                      if (i_bl_report_Jw_ref_combinacao_especial<res_Jw_ref_combinacao_especial.size()) {
                        t_jw_ref_combinacao_especial = (portalbr.dbobj.view.Jw_ref_combinacao_especial)res_Jw_ref_combinacao_especial.elementAt(i_bl_report_Jw_ref_combinacao_especial);
                        id_solicitacao = t_jw_ref_combinacao_especial.getId_solicitacao();
                        usuario_solicitacao = t_jw_ref_combinacao_especial.getUsuario_solicitacao()==null?"":t_jw_ref_combinacao_especial.getUsuario_solicitacao();
                        data_solicitacao = (java.sql.Timestamp)t_jw_ref_combinacao_especial.getData_solicitacao();
                        codigo_marca = t_jw_ref_combinacao_especial.getCodigo_marca();
                        nome_marca = t_jw_ref_combinacao_especial.getNome_marca()==null?"":t_jw_ref_combinacao_especial.getNome_marca();
                        data_entrega_prevista = (java.sql.Timestamp)t_jw_ref_combinacao_especial.getData_entrega_prevista();
                        data_entrega_solicitada = (java.sql.Timestamp)t_jw_ref_combinacao_especial.getData_entrega_solicitada();
                        data_entrega_amostra = (java.sql.Timestamp)t_jw_ref_combinacao_especial.getData_entrega_amostra();
                        lin_cdgo = t_jw_ref_combinacao_especial.getLin_cdgo();
                        lin_nome = t_jw_ref_combinacao_especial.getLin_nome()==null?"":t_jw_ref_combinacao_especial.getLin_nome();
                        ref_cdgo = t_jw_ref_combinacao_especial.getRef_cdgo();
                        ref_desc = t_jw_ref_combinacao_especial.getRef_desc()==null?"":t_jw_ref_combinacao_especial.getRef_desc();
                        cli_cdgo = t_jw_ref_combinacao_especial.getCli_cdgo();
                        cliente_grupo_economico = t_jw_ref_combinacao_especial.getCliente_grupo_economico()==null?"":t_jw_ref_combinacao_especial.getCliente_grupo_economico();
                        pares_alteracao = t_jw_ref_combinacao_especial.getPares_alteracao();
                        situacao_solicitacao_desc = t_jw_ref_combinacao_especial.getSituacao_solicitacao_desc()==null?"":t_jw_ref_combinacao_especial.getSituacao_solicitacao_desc();
                        cab_cdgo = t_jw_ref_combinacao_especial.getCab_cdgo();
                        cab_desc = t_jw_ref_combinacao_especial.getCab_desc()==null?"":t_jw_ref_combinacao_especial.getCab_desc();
                        cor_cdgo = t_jw_ref_combinacao_especial.getCor_cdgo();
                        cor_desc = t_jw_ref_combinacao_especial.getCor_desc()==null?"":t_jw_ref_combinacao_especial.getCor_desc();
                        descricao = t_jw_ref_combinacao_especial.getDescricao()==null?"":t_jw_ref_combinacao_especial.getDescricao();
                        observacao = t_jw_ref_combinacao_especial.getObservacao()==null?"":t_jw_ref_combinacao_especial.getObservacao();
                        material_cor1 = t_jw_ref_combinacao_especial.getMaterial_cor1()==null?"":t_jw_ref_combinacao_especial.getMaterial_cor1();
                        material_cor2 = t_jw_ref_combinacao_especial.getMaterial_cor2()==null?"":t_jw_ref_combinacao_especial.getMaterial_cor2();
                        material_cor3 = t_jw_ref_combinacao_especial.getMaterial_cor3()==null?"":t_jw_ref_combinacao_especial.getMaterial_cor3();
                        biqueira_debrum = t_jw_ref_combinacao_especial.getBiqueira_debrum()==null?"":t_jw_ref_combinacao_especial.getBiqueira_debrum();
                        capa_palmilha = t_jw_ref_combinacao_especial.getCapa_palmilha()==null?"":t_jw_ref_combinacao_especial.getCapa_palmilha();
                        cacharel = t_jw_ref_combinacao_especial.getCacharel()==null?"":t_jw_ref_combinacao_especial.getCacharel();
                        forro = t_jw_ref_combinacao_especial.getForro()==null?"":t_jw_ref_combinacao_especial.getForro();
                        metais = t_jw_ref_combinacao_especial.getMetais()==null?"":t_jw_ref_combinacao_especial.getMetais();
                        taloneira = t_jw_ref_combinacao_especial.getTaloneira()==null?"":t_jw_ref_combinacao_especial.getTaloneira();
                        salto = t_jw_ref_combinacao_especial.getSalto()==null?"":t_jw_ref_combinacao_especial.getSalto();
                        enfeite = t_jw_ref_combinacao_especial.getEnfeite()==null?"":t_jw_ref_combinacao_especial.getEnfeite();
                        carimbo_etiqueta = t_jw_ref_combinacao_especial.getCarimbo_etiqueta()==null?"":t_jw_ref_combinacao_especial.getCarimbo_etiqueta();
                        cli_rzao = t_jw_ref_combinacao_especial.getCli_rzao()==null?"":t_jw_ref_combinacao_especial.getCli_rzao();
                        prs_negociacao = t_jw_ref_combinacao_especial.getPrs_negociacao();
                        pares_linha = t_jw_ref_combinacao_especial.getPares_linha();
                        ll_alteracao_solicitada = t_jw_ref_combinacao_especial.getLl_alteracao_solicitada();
                        situacao_solicitacao = t_jw_ref_combinacao_especial.getSituacao_solicitacao()==null?"":t_jw_ref_combinacao_especial.getSituacao_solicitacao();
                        preco_liguido = t_jw_ref_combinacao_especial.getPreco_liguido();
                        data_aceite = (java.sql.Date)t_jw_ref_combinacao_especial.getData_aceite();
                        usuario_aceite = t_jw_ref_combinacao_especial.getUsuario_aceite()==null?"":t_jw_ref_combinacao_especial.getUsuario_aceite();
                        nova_combinacao = t_jw_ref_combinacao_especial.getNova_combinacao()==null?"":t_jw_ref_combinacao_especial.getNova_combinacao();
                        alteracao_modelo = t_jw_ref_combinacao_especial.getAlteracao_modelo()==null?"":t_jw_ref_combinacao_especial.getAlteracao_modelo();
                        amostra = t_jw_ref_combinacao_especial.getAmostra()==null?"":t_jw_ref_combinacao_especial.getAmostra();
                        desc_solicitacao_comb_especial = t_jw_ref_combinacao_especial.getDesc_solicitacao_comb_especial()==null?"":t_jw_ref_combinacao_especial.getDesc_solicitacao_comb_especial();
                        desenvolvimento = t_jw_ref_combinacao_especial.getDesenvolvimento()==null?"":t_jw_ref_combinacao_especial.getDesenvolvimento();
                        fora_mix = t_jw_ref_combinacao_especial.getFora_mix()==null?"":t_jw_ref_combinacao_especial.getFora_mix();
                        manipulacao = t_jw_ref_combinacao_especial.getManipulacao()==null?"":t_jw_ref_combinacao_especial.getManipulacao();
                        modelo_exclusivo = t_jw_ref_combinacao_especial.getModelo_exclusivo()==null?"":t_jw_ref_combinacao_especial.getModelo_exclusivo();
                        valor_fabricacao = t_jw_ref_combinacao_especial.getValor_fabricacao();
                        valor_pdv = t_jw_ref_combinacao_especial.getValor_pdv();
                        ll_0 = t_jw_ref_combinacao_especial.getLl_0();
                        ll_1 = t_jw_ref_combinacao_especial.getLl_1();
                        ll_2 = t_jw_ref_combinacao_especial.getLl_2();
                        ll_3 = t_jw_ref_combinacao_especial.getLl_3();
                        preco_vendor = t_jw_ref_combinacao_especial.getPreco_vendor();
                      } else {
                      }
                    }
                    %>

                    <tr class="totalColumn">
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
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

            <html:form action="com/DiarioCombinacaoEspecial_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
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

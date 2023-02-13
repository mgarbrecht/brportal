<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta de Notas Fiscais
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(72)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <style>
              .text {mso-number-format:"\@" }
            </style>
            <%
            int counterbl_report_Jw_consulta_notas_fiscais=0;
            portalbr.com.ConsultaNotaFiscal_rActionForm ConsultaNotaFiscal_rActionForm = (portalbr.com.ConsultaNotaFiscal_rActionForm)session.getAttribute("ConsultaNotaFiscal_rActionForm");
            int    total_notas = 0;
            int    total_qtde  = 0;
            double total_valor = 0d;
            String despachante = null;
            try{
              Vector res_Jw_consulta_notas_fiscais_linhas = null;
              portalbr.dbobj.view.Jw_consulta_notas_fiscais_linhas table = new portalbr.dbobj.view.Jw_consulta_notas_fiscais_linhas();
              portalbr.dbobj.view.Jw_consulta_notas_fiscais t_jw_consulta_notas_fiscais = new portalbr.dbobj.view.Jw_consulta_notas_fiscais();
              java.util.Vector res_Jw_consulta_notas_fiscais = (java.util.Vector)session.getAttribute("res_Jw_consulta_notas_fiscais");
              if (res_Jw_consulta_notas_fiscais!=null && res_Jw_consulta_notas_fiscais.size()>0) {
                java.lang.String nota            =  null;
                java.lang.String placa_veiculo   =  null;
                java.lang.String fil_filial      =  null;
                java.lang.String fil_prod        =  null;
                java.lang.String emp_empresa     =  null;
                java.lang.String cc              =  null;
                java.lang.String ecl_cdad        =  null;
                java.lang.String est_unifed      =  null;
                java.lang.String linha           =  null;
                java.lang.Integer linha_cdgo     =  null;
                java.lang.Integer ref_cdgo       =  null;
                java.sql.Timestamp nfs_dtemis    =  null;
                java.lang.Integer nfs_nmro       =  null;
                java.lang.Integer tra_cdgo       =  null;
                java.lang.String nfs_serie       =  null;
                java.lang.Integer nfs_qtdvol     =  null;
                java.lang.Integer qtde_de_notas  =  null;
                java.lang.String ped_nmro        =  null;
                java.lang.Double nfs_vltot       =  null;
                java.lang.Double taxa_dolar      =  null;
                java.lang.String sigla_trans     =  null;
                java.lang.String romaneio        =  null;
                java.lang.String chave_nfe       =  null;
                java.lang.String cons            =  null;
                java.lang.String ocorrencia      =  null;
                java.lang.String fil_cgc         =  null;
                java.sql.Timestamp data_romaneio =  null;
                java.lang.String[] conhecimentos =  null;
                java.lang.String conhecimento    =  "";
                java.lang.String peso            =  "";
                java.lang.String valor_frete     =  "";
                java.lang.Double nfs_pesbru      =  null;
                java.lang.Double nfs_pesliq      =  null;
                Double total_peso                = 0d;
                Double total_peso_liquido        = 0d;
                Double total_peso_bruto          = 0d;
                Double total_vlr_frete           = 0d;
                Double nfs_total_pares           = 0d;
                Double cubagem                   = 0d;
                Double total_cubagem             = 0d;
                Double total_nfs_total_pares     = 0d;
                Integer total_nfs_qtdvol         = 0;
                String[] pedidos = null;

                //acesso.Sessao sessao = new acesso.Sessao(session);
                //if(sessao.getTipoEntidadeNegocio().equals("DESPACHANTE")){
                  //despachante = sessao.getChave();
                //}

                int i_bl_report_Jw_consulta_notas_fiscais = 0;
                java.lang.String tra_desc      = (String)session.getAttribute("descricao_transportadora");
                t_jw_consulta_notas_fiscais = (portalbr.dbobj.view.Jw_consulta_notas_fiscais)res_Jw_consulta_notas_fiscais.elementAt(i_bl_report_Jw_consulta_notas_fiscais);
                nota            = t_jw_consulta_notas_fiscais.getNota()==null?"":t_jw_consulta_notas_fiscais.getNota();
                fil_filial      = t_jw_consulta_notas_fiscais.getFil_filial()==null?"":t_jw_consulta_notas_fiscais.getFil_filial();
                fil_prod        = t_jw_consulta_notas_fiscais.getFil_prod()==null?"":t_jw_consulta_notas_fiscais.getFil_prod();
                emp_empresa     = t_jw_consulta_notas_fiscais.getEmp_empresa()==null?"":t_jw_consulta_notas_fiscais.getEmp_empresa();
                cc              = t_jw_consulta_notas_fiscais.getCc()==null?"":t_jw_consulta_notas_fiscais.getCc();
                ecl_cdad        = t_jw_consulta_notas_fiscais.getEcl_cdad()==null?"":t_jw_consulta_notas_fiscais.getEcl_cdad();
                est_unifed      = t_jw_consulta_notas_fiscais.getEst_unifed()==null?"":t_jw_consulta_notas_fiscais.getEst_unifed();
                nfs_dtemis      = (java.sql.Timestamp)t_jw_consulta_notas_fiscais.getNfs_dtemis();
                nfs_nmro        = t_jw_consulta_notas_fiscais.getNfs_nmro();
                tra_cdgo        = t_jw_consulta_notas_fiscais.getTra_cdgo();
                linha           = t_jw_consulta_notas_fiscais.getLinha();
                linha_cdgo      = t_jw_consulta_notas_fiscais.getLinha_cdgo();
                ref_cdgo        = t_jw_consulta_notas_fiscais.getRef_cdgo();
                nfs_serie       = t_jw_consulta_notas_fiscais.getNfs_serie()==null?"":t_jw_consulta_notas_fiscais.getNfs_serie();
                nfs_qtdvol      = t_jw_consulta_notas_fiscais.getNfs_qtdvol();
                qtde_de_notas   = t_jw_consulta_notas_fiscais.getQtde_de_notas();
                nfs_vltot       = t_jw_consulta_notas_fiscais.getNfs_vltot();
                nfs_pesbru      = t_jw_consulta_notas_fiscais.getNfs_pesbru();
                nfs_pesliq      = t_jw_consulta_notas_fiscais.getNfs_pesliq();
                taxa_dolar      = t_jw_consulta_notas_fiscais.getTaxa_dolar();
                fil_cgc         = t_jw_consulta_notas_fiscais.getFil_cgc()==null?"":t_jw_consulta_notas_fiscais.getFil_cgc();
                chave_nfe       = t_jw_consulta_notas_fiscais.getChave_nfe()==null?"":t_jw_consulta_notas_fiscais.getChave_nfe();
                sigla_trans     = t_jw_consulta_notas_fiscais.getSigla_trans()==null?"":t_jw_consulta_notas_fiscais.getSigla_trans();
                romaneio        = t_jw_consulta_notas_fiscais.getNro_romaneio_embarque()==null?"":t_jw_consulta_notas_fiscais.getNro_romaneio_embarque();
                data_romaneio   = (java.sql.Timestamp)t_jw_consulta_notas_fiscais.getFinalizacao_romaneio();
                conhecimentos   = t_jw_consulta_notas_fiscais.getConhecimentos()==null?null:t_jw_consulta_notas_fiscais.getConhecimentos().split("#");
                nfs_total_pares = t_jw_consulta_notas_fiscais.getNfs_total_pares();
                placa_veiculo   = t_jw_consulta_notas_fiscais.getPlaca_veiculo()==null?"":t_jw_consulta_notas_fiscais.getPlaca_veiculo();
                cubagem         = t_jw_consulta_notas_fiscais.getCubagem();
                cons            = t_jw_consulta_notas_fiscais.getCons()==null?"":t_jw_consulta_notas_fiscais.getCons();
                ocorrencia      = t_jw_consulta_notas_fiscais.getOcorrencia()==null?"":t_jw_consulta_notas_fiscais.getOcorrencia();
                ped_nmro        = t_jw_consulta_notas_fiscais.getPed_nmro()==null?"":t_jw_consulta_notas_fiscais.getPed_nmro();
                try {
                  pedidos = (ped_nmro+"").split(",");
                } catch (Exception e){
                  e.printStackTrace();
                }
                total_cubagem += cubagem!=null?cubagem:0d;
                total_notas += 1;
                total_qtde += nfs_qtdvol!=null?nfs_qtdvol:0;
                total_valor += nfs_vltot!=null?nfs_vltot:0d;
                total_nfs_qtdvol += nfs_qtdvol!=null?nfs_qtdvol:0;
                total_nfs_total_pares += nfs_total_pares!=null?nfs_total_pares:0;
                total_peso_liquido += nfs_pesliq;
                total_peso_bruto += nfs_pesbru;


                if(conhecimentos != null){
                  conhecimento = conhecimentos[0];
                  peso         = com.egen.util.text.FormatNumber.format(Double.parseDouble(conhecimentos[1].replace(",",".")),"0.00");
                  valor_frete  = com.egen.util.text.FormatNumber.format(Double.parseDouble(conhecimentos[2].replace(",",".")),"#0.00");
                  total_vlr_frete += Double.parseDouble(conhecimentos[2].replace(",","."));
                  total_peso      += Double.parseDouble(conhecimentos[1].replace(",","."));
                }else{
                  conhecimento = " ";
                  peso         = " ";
                  valor_frete  = " ";
                }

                if(ConsultaNotaFiscal_rActionForm.getPar().equals("0")){
                  %>
                  <%
                  if(despachante==null) {
                    %>
                    <table id="TRbl_report_Jw_consulta_notas_fiscais" class="reportTable" style=width:100%;  border=1  frame=box>
                      <tr class="reportHeader2" >
                        <td class="columnTdHeader" style="text-align:left;" >
                          <%
                          if(!tra_desc.equals("")){
                            %>
                            Transportadora:
                            <%= tra_desc %>
                            <%
                          }else if(request.getParameter("grupo_economico")=="" || request.getParameter("grupo_economico")=="null"){
                            %>
                            Cliente :
                            <%= cc %>
                            <%
                          } else {
                            %>
                            Grupo Econômico :
                            <%= (String)request.getParameter("grupo_economico") %>
                            <%
                          }
                          %>
                        </td>
                      </tr>
                    </table>
                    <%
                  }
                  %>
                  <%
                }
                %>
                <%
                if(despachante==null) {
                  %>
                  <table id="TRbl_report_Jw_consulta_notas_fiscais" class="reportTable" style="width:3500px"  border=1  frame=box>
                    <%
                  } else {
                    %>
                    <table id="TRbl_report_Jw_consulta_notas_fiscais" class="reportTable"  border=1  frame=box>
                      <%
                    }
                    %>
                    <tr class="reportHeader" >
                      <td class="columnTdHeader" style="text-align:left;">
                        Número            
                      </td>

                      <%
                      if(despachante!=null) {
                        %>
                        <td class="columnTdHeader" style="text-align:center;">
                          Série
                        </td>
                        <%
                      }
                      %>

                      <%
                      if(despachante==null) {
                        %>
                        <td class="columnTdHeader" style="text-align:center;">
                          Pedido
                        </td>
                        <%
                      }
                      %>

                      <%
                      if(despachante==null) {
                        %>
                        <td class="columnTdHeader" style="text-align:center;">
                          Emp.
                        </td>
                        <td class="columnTdHeader" style="text-align:center;">
                          Fil.
                        </td>
                        <td class="columnTdHeader" style="text-align:center;">
                          Fil Prod.
                        </td>
                        <%
                      }
                      %>

                      <%
                      if(despachante==null) {
                        %>
                        <td class="columnTdHeader" style="text-align:left;" width="1%">
                          Sigla Trans.
                        </td>
                        <%
                      }
                      %>

                      <%
                      if(despachante==null) {
                        %>
                        <td class="columnTdHeader" style="text-align:left;">
                          Cliente
                        </td>
                        <%
                      }
                      %>

                      <%
                      if(despachante==null) {
                        %>
                        <td class="columnTdHeader" style="text-align:left;">
                          Cidade
                        </td>
                        <td class="columnTdHeader" style="text-align:left;">
                          UF
                        </td>
                        <td class="columnTdHeader" style="text-align:left;">
                          Linha
                        </td>
                        <%
                      }
                      %>

                      <%
                      if(despachante!=null) {
                        %>

                        <td class="columnTdHeader" style="text-align:left;">
                          Código Linha
                        </td>
                        <td class="columnTdHeader" style="text-align:left;">
                          Código Referência
                        </td>

                        <%
                      }
                      %>

                      <td class="columnTdHeader" style="text-align:center;">
                        Emissão
                      </td>
                      <td class="columnTdHeader" style="text-align:center;" width="5%">
                        Qtd. Vol
                      </td>

                      <%
                      if(despachante==null) {
                        %>
                        <td class="columnTdHeader" style="text-align:center;" width="5%">
                          Qtde Notas
                        </td>
                        <%
                      }
                      %>


                      <td class="columnTdHeader" style="text-align:center;" width="5%">
                        Vlr. Nota
                      </td>

                      <%
                      if(despachante!=null) {
                        %>
                        <td class="columnTdHeader" style="text-align:center;" width="5%">
                          Vlr. Liq.
                        </td>
                        <%
                      }
                      %>

                      <%
                      if(despachante==null) {
                        %>
                        <td class="columnTdHeader" style="text-align:center;" width="5%">
                          Nro Romaneio
                        </td>
                        <td class="columnTdHeader" style="text-align:center;" width="5%">
                          Data Finalização Romaneio
                        </td>
                        <td class="columnTdHeader" style="text-align:center;" width="5%">
                          Conhecimento
                        </td>
                        <td class="columnTdHeader" style="text-align:center;" width="500px" >
                          Ocorrência
                        </td>
                        <td class="columnTdHeader" style="text-align:center;" width="5%">
                          Peso Conhec.
                        </td>
                        <td class="columnTdHeader" style="text-align:center;" width="5%">
                          Peso Liq. Nota
                        </td>
                        <td class="columnTdHeader" style="text-align:center;" width="5%">
                          Peso Bruto Nota
                        </td>
                        <td class="columnTdHeader" style="text-align:center;" width="5%">
                          Vlr Frete
                        </td>
                        <%
                      }
                      %>

                      <td class="columnTdHeader" style="text-align:center;" width="5%">
                        Total Pares
                      </td>

                      <%
                      if(despachante==null) {
                        %>
                        <td class="columnTdHeader" style="text-align:center;" width="5%">
                          Placa Veículo
                        </td>
                        <td class="columnTdHeader" style="text-align:right;" width="5%">
                          Cubagem
                        </td>
                        <td class="columnTdHeader" style="text-align:left;">
                          Consignatário
                        </td>
                        <td class="columnTdHeader" style="text-align:left;" width="1%">
                          Obs.
                        </td>
                        <%
                      }
                      %>

                      <%
                      if(despachante!=null){
                        %>
                        <td class="columnTdHeader" style="text-align:left;" width="1%">
                          Tx. Dólar
                        </td>
                        <%
                      }
                      %>


                      <td class="columnTdHeader" style="text-align:left;" width="1%">
                        Chave NFE
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" width="1%">
                        Rastreamento
                      </td>

                    </tr>
                    <%
                    while (i_bl_report_Jw_consulta_notas_fiscais<res_Jw_consulta_notas_fiscais.size()){
                      counterbl_report_Jw_consulta_notas_fiscais++;
                      String style="";
                      if (!((i_bl_report_Jw_consulta_notas_fiscais%2)!=0)) {
                        style="rowColor";
                      } else {
                        style="rowBlank";
                      }
                      %>
                      <tr class=<%= style %> id='TRbl_report_Jw_consulta_notas_fiscais<%=counterbl_report_Jw_consulta_notas_fiscais%>' >
                        <td class="reportColumn" style="text-align:left;" title="Consulta Nota Fiscal: <%= nota %>">

                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>

                            <a href="../com/NotaFiscalForm.do?select_action=&emp_empresa=<%= emp_empresa %>&fil_filial=<%= fil_filial %>&nf_nmro=<%= nfs_nmro %>&nf_serie=<%= nfs_serie %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                              <%
                              if(despachante!=null) {
                                %>
                                <%= nfs_nmro %>
                                <%
                              } else {
                                %>
                                <%= nota %>
                                <%
                              }
                              %>
                            </a>

                            <%
                          } else {
                            %>

                            <%
                            if(despachante!=null) {
                              %>
                              <%= nfs_nmro %>
                              <%
                            } else {
                              %>
                              <%= nota %>
                              <%
                            }
                            %>


                            <%
                          }
                          %>

                        </td>

                        <%
                        if(despachante!=null) {
                          %>
                          <td class="reportColumn" style="text-align:center;">
                            <%= nfs_serie %>
                          </td>
                          <%
                        }
                        %>

                        <%
                        if(despachante==null) {
                          %>

                          <td class="reportColumn" style="text-align:center;">
                            <%
                            if(!(request.getParameter("excel")+"").equals("true")){
                              %>
                              <%
                              if(pedidos!=null){
                                for(String ped : pedidos){
                                  %>
                                  <a href="../com/ConsultaPedidos_iForm.do?select_action=&pedido_beira_rio=<%= ped %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                    <%= ped %>
                                  </a>
                                  <br>
                                  <%
                                }}
                                %>
                                <%
                              } else {
                                %>
                                <%
                                if(pedidos!=null){
                                  for(String ped : pedidos){
                                    %>
                                    <%= ped %>
                                    <br>
                                    <%
                                  }}
                                  %>
                                  <%
                                }
                                %>
                              </td>

                              <%
                            }
                            %>

                            <%
                            if(despachante==null) {
                              %>
                              <td class="reportColumn" style="text-align:center;">
                                <%= emp_empresa %>
                              </td>
                              <td class="reportColumn" style="text-align:center;">
                                <%= fil_filial %>
                              </td>
                              <td class="reportColumn" style="text-align:center;">
                                <%= fil_prod %>
                              </td>
                              <%
                            }
                            %>

                            <%
                            if(despachante==null) {
                              %>
                              <td class="reportColumn" style="text-align:left;">
                                <%= sigla_trans %>
                              </td>
                              <%
                            }
                            %>

                            <%
                            if(despachante==null) {
                              %>
                              <td class="reportColumn" style="text-align:left;">
                                <%= cc %>
                              </td>
                              <%
                            }
                            %>

                            <%
                            if(despachante==null) {
                              %>

                              <td class="reportColumn" style="text-align:left;">
                                <%= ecl_cdad %>
                              </td>
                              <td class="reportColumn" style="text-align:left;">
                                <%= est_unifed %>
                              </td>
                              <td class="reportColumn" style="text-align:left;">
                                <%= ((linha!=null)?linha.toString():"") %>
                              </td>

                              <%
                            }
                            %>

                            <%
                            if(despachante!=null) {
                              %>

                              <td class="reportColumn" style="text-align:left;">
                                <%= ((linha_cdgo!=null)?linha_cdgo.toString():"") %>
                              </td>
                              <td class="reportColumn" style="text-align:left;">
                                <%= ((ref_cdgo!=null)?ref_cdgo.toString():"") %>
                              </td>

                              <%
                            }
                            %>

                            <td class="reportColumn" style="text-align:center;">
                              <%= com.egen.util.text.FormatDate.format(nfs_dtemis, "dd/MM/yyyy") %>
                            </td>
                            <td class="reportColumn" style="text-align:center;">
                              <%
                              if(nfs_qtdvol != null) {
                                %>
                                <%= nfs_qtdvol %>
                                <%
                              }
                              %>
                            </td>

                            <%
                            if(despachante==null) {
                              %>
                              <td class="reportColumn" style="text-align:center;">
                                <%= qtde_de_notas %>
                              </td>
                              <%
                            }
                            %>
                            <td class="reportColumn" style="text-align:center;">
                              <%= com.egen.util.text.FormatNumber.format(nfs_vltot,"#0.00") %>
                            </td>

                            <%
                            if(despachante!=null) {
                              %>
                              <td class="reportColumn" style="text-align:center;">
                                <%= com.egen.util.text.FormatNumber.format(nfs_vltot,"#0.00") %>
                              </td>
                              <%
                            }
                            %>

                            <%
                            if(despachante==null) {
                              %>
                              <td class="reportColumn" style="text-align:center;">
                                <%= romaneio %>
                              </td>
                              <td class="reportColumn" style="text-align:center;">
                                <%= com.egen.util.text.FormatDate.format(data_romaneio,"dd/MM/yyyy HH:mm:ss") %>
                              </td>
                              <td class="reportColumn" style="text-align:center;">
                                <div id="<%= conhecimento %>">
                                  <%= conhecimento %>
                                  <%
                                  String aguarde = conhecimento + "aguarde";
                                  %>
                                  <%
                                  if(!conhecimento.equals("-")) {
                                    %>
                                    <%
                                    String arquivo = util.rand.Palavra.geraPalavra()+".pdf";
                                    %>
                                    <img src="../img/viewmag.png" style="cursor:hand" onclick="jQuery('#<%= conhecimento %>').hide();jQuery('#<%= aguarde %>').show();jQuery.post('ConsultaNotaFiscal_rForm.do?gera_conhecimento_action=&conhecimento=<%= conhecimento %>&arquivo=<%= arquivo %>', function(){window.open('../temp/<%= arquivo %>','_blank');jQuery('#<%= conhecimento %>').show();jQuery('#<%= aguarde %>').hide();});" >
                                    <%
                                  }
                                  %>
                                </div>
                                <div id="<%= aguarde %>" style="display: none" >
                                  aguarde...
                                </div>
                              </td>

                              <td class="reportColumn" style="text-align:center;">
                                <small>
                                  <%= ocorrencia %>
                                </small>
                                <%
                                if(ocorrencia!= null && !ocorrencia.equals("")) {
                                  %>
                                  <img src="../img/viewmag.png" style="cursor:hand" onclick="wopen('../com/ConsultaNotaFiscal_oForm.do?select_action=&emp_empresa=<%= emp_empresa %>&fil_filial=<%= fil_filial %>&nfs_nmro=<%= nfs_nmro %>&nfs_serie=<%= nfs_serie %>','_blank',700,500)" >
                                  <%
                                }
                                %>
                              </td>

                              <td class="reportColumn" style="text-align:center;">
                                <%= peso %>
                              </td>
                              <td class="reportColumn" style="text-align:center;">
                                <%= com.egen.util.text.FormatNumber.format(nfs_pesliq ,"##,##0.000") %>
                              </td>
                              <td class="reportColumn" style="text-align:center;">
                                <%= com.egen.util.text.FormatNumber.format(nfs_pesbru ,"##,##0.000") %>
                              </td>
                              <td class="reportColumn" style="text-align:center;">
                                <%= valor_frete %>
                              </td>

                              <%
                            }
                            %>


                            <td class="reportColumn" style="text-align:center;">
                              <%= com.egen.util.text.FormatNumber.format(nfs_total_pares,"0") %>
                            </td>

                            <%
                            if(despachante==null) {
                              %>

                              <td class="reportColumn" style="text-align:center;">
                                <%= placa_veiculo %>
                              </td>
                              <td class="reportColumn" style="text-align:right;">
                                <%
                                if(cubagem>0){
                                  %>
                                  <%= com.egen.util.text.FormatNumber.format(cubagem ,"##,##0.0000") %>
                                  <%
                                }
                                %>
                              </td>
                              <td class="reportColumn" style="text-align:left;">
                                <%= cons %>
                              </td>
                              <td class="columnTdHeader" style="text-align: center;">
                                <a href="#" onclick="wopen('../com/ConsultaNotaFiscal_obsForm.do?select_action=&emp_empresa=<%= emp_empresa %>&fil_filial=<%= fil_filial %>&nfs_nmro=<%= nfs_nmro %>&nfs_serie=<%= nfs_serie %>','_blank',700,500)"  onclick="bloqueia();">
                                  <img src="../img/viewmag.png" style="cursor:hand"/>
                                </a>
                              </td>


                              <%
                            }
                            %>

                            <%
                            if(despachante!=null){
                              %>
                              <td class="reportColumn" style="text-align:right;">
                                <%= com.egen.util.text.FormatNumber.format(taxa_dolar,"##,##0.0000") %>
                              </td>
                              <%
                            }
                            %>


                            <%
                            if(!(request.getParameter("excel")+"").equals("true")){
                              %>
                              <td class="reportColumn" style="text-align:center;">
                                <%= chave_nfe %>
                              </td>
                              <%
                            } else {
                              %>
                              <td class="text">
                                <%= chave_nfe %>
                              </td>
                              <%
                            }
                            %>

                            <td class="reportColumn" style="text-align:center;">
                              <%
                              if((tra_cdgo+"").equals("29")){
                                %>
                                <img src="../img/viewmag.png" style="cursor:hand" onclick="wopen('https://radar.tntbrasil.com.br/radar/public/eventoNotaFiscalCliente/<%= fil_cgc %>/<%= nfs_nmro %>-<%= nfs_serie %>','_blank',1024,450)" >
                                <%
                              }
                              %>
                            </td>

                          </tr>
                          <%
                          if (++i_bl_report_Jw_consulta_notas_fiscais >= res_Jw_consulta_notas_fiscais.size()) {
                            break;
                          }
                          t_jw_consulta_notas_fiscais = (portalbr.dbobj.view.Jw_consulta_notas_fiscais)res_Jw_consulta_notas_fiscais.elementAt(i_bl_report_Jw_consulta_notas_fiscais);
                          nota            = t_jw_consulta_notas_fiscais.getNota()==null?"":t_jw_consulta_notas_fiscais.getNota();
                          emp_empresa     = t_jw_consulta_notas_fiscais.getEmp_empresa()==null?"":t_jw_consulta_notas_fiscais.getEmp_empresa();
                          fil_filial      = t_jw_consulta_notas_fiscais.getFil_filial()==null?"":t_jw_consulta_notas_fiscais.getFil_filial();
                          fil_prod        = t_jw_consulta_notas_fiscais.getFil_prod()==null?"":t_jw_consulta_notas_fiscais.getFil_prod();
                          cc              = t_jw_consulta_notas_fiscais.getCc()==null?"":t_jw_consulta_notas_fiscais.getCc();
                          ecl_cdad        = t_jw_consulta_notas_fiscais.getEcl_cdad()==null?"":t_jw_consulta_notas_fiscais.getEcl_cdad();
                          est_unifed      = t_jw_consulta_notas_fiscais.getEst_unifed()==null?"":t_jw_consulta_notas_fiscais.getEst_unifed();        nfs_dtemis    = (java.sql.Timestamp)t_jw_consulta_notas_fiscais.getNfs_dtemis();
                          nfs_nmro        = t_jw_consulta_notas_fiscais.getNfs_nmro();
                          tra_cdgo        = t_jw_consulta_notas_fiscais.getTra_cdgo();
                          taxa_dolar      = t_jw_consulta_notas_fiscais.getTaxa_dolar();
                          chave_nfe       = t_jw_consulta_notas_fiscais.getChave_nfe()==null?"":t_jw_consulta_notas_fiscais.getChave_nfe();
                          linha           = t_jw_consulta_notas_fiscais.getLinha();
                          linha_cdgo      = t_jw_consulta_notas_fiscais.getLinha_cdgo();
                          ref_cdgo        = t_jw_consulta_notas_fiscais.getRef_cdgo();
                          fil_cgc         = t_jw_consulta_notas_fiscais.getFil_cgc()==null?"":t_jw_consulta_notas_fiscais.getFil_cgc();
                          nfs_serie       = t_jw_consulta_notas_fiscais.getNfs_serie()==null?"":t_jw_consulta_notas_fiscais.getNfs_serie();
                          nfs_qtdvol      = t_jw_consulta_notas_fiscais.getNfs_qtdvol();
                          qtde_de_notas   = t_jw_consulta_notas_fiscais.getQtde_de_notas();
                          nfs_vltot       = t_jw_consulta_notas_fiscais.getNfs_vltot();
                          sigla_trans     = t_jw_consulta_notas_fiscais.getSigla_trans()==null?"":t_jw_consulta_notas_fiscais.getSigla_trans();
                          romaneio        = t_jw_consulta_notas_fiscais.getNro_romaneio_embarque()==null?"":t_jw_consulta_notas_fiscais.getNro_romaneio_embarque();
                          data_romaneio   = (java.sql.Timestamp)t_jw_consulta_notas_fiscais.getFinalizacao_romaneio();
                          conhecimentos   = t_jw_consulta_notas_fiscais.getConhecimentos()==null?null:t_jw_consulta_notas_fiscais.getConhecimentos().split("#");
                          nfs_total_pares = t_jw_consulta_notas_fiscais.getNfs_total_pares();
                          placa_veiculo   = t_jw_consulta_notas_fiscais.getPlaca_veiculo()==null?"":t_jw_consulta_notas_fiscais.getPlaca_veiculo();
                          cubagem         = t_jw_consulta_notas_fiscais.getCubagem();
                          nfs_pesbru      = t_jw_consulta_notas_fiscais.getNfs_pesbru();
                          nfs_pesliq      = t_jw_consulta_notas_fiscais.getNfs_pesliq();
                          cons            = t_jw_consulta_notas_fiscais.getCons()==null?"":t_jw_consulta_notas_fiscais.getCons();
                          ocorrencia      = t_jw_consulta_notas_fiscais.getOcorrencia()==null?"":t_jw_consulta_notas_fiscais.getOcorrencia();
                          ped_nmro        = t_jw_consulta_notas_fiscais.getPed_nmro()==null?"":t_jw_consulta_notas_fiscais.getPed_nmro();
                          try {
                            pedidos  = (ped_nmro+"").split(",");
                          } catch (Exception e){
                            e.printStackTrace();
                          }
                          total_cubagem += cubagem!=null?cubagem:0d;
                          total_notas += 1;
                          total_qtde += nfs_qtdvol!=null?nfs_qtdvol:0;
                          total_valor += nfs_vltot!=null?nfs_vltot:0d;
                          total_nfs_qtdvol += nfs_qtdvol!=null?nfs_qtdvol:0;
                          total_nfs_total_pares += nfs_total_pares;
                          total_peso_liquido += nfs_pesliq;
                          total_peso_bruto += nfs_pesbru;

                          if(conhecimentos != null){
                            conhecimento = conhecimentos[0];
                            peso         = com.egen.util.text.FormatNumber.format(Double.parseDouble(conhecimentos[1].replace(",",".")),"0.00");
                            valor_frete  = com.egen.util.text.FormatNumber.format(Double.parseDouble(conhecimentos[2].replace(",",".")),"#0.00");
                            total_vlr_frete += Double.parseDouble(conhecimentos[2].replace(",","."));
                            total_peso      += Double.parseDouble(conhecimentos[1].replace(",","."));
                          }else{
                            conhecimento = " ";
                            peso         = " ";
                            valor_frete  = " ";
                          }

                        }
                        %>

                        <%
                        if(despachante==null) {
                          %>
                          <tr class="reportHeader" style="border:0px solid #FFFFFF;">
                            <td class="columnTdHeader" style="text-align:left;">
                              Total:
                            </td>
                            <td class="columnTdHeader" style="text-align:center;" colspan="10">
                            </td>
                            <td class="columnTdHeader" style="text-align:center;">
                              <%= total_nfs_qtdvol %>
                            </td>
                            <td class="columnTdHeader" style="text-align:center;">
                              <%= total_notas %>
                            </td>
                            <td class="columnTdHeader" style="text-align:center;">
                              <%= com.egen.util.text.FormatNumber.format(total_valor,"##,##0.00") %>
                            </td>
                            <td class="columnTdHeader" style="text-align:center;">
                            </td>
                            <td class="columnTdHeader" style="text-align:center;">
                            </td>
                            <td class="columnTdHeader" style="text-align:center;" colspan="2">
                            </td>
                            <td class="columnTdHeader" style="text-align:center;">
                              <%= com.egen.util.text.FormatNumber.format(total_peso,"0.00") %>
                            </td>
                            <td class="columnTdHeader" style="text-align:center;">
                              <%= com.egen.util.text.FormatNumber.format(total_peso_liquido,"##,##0.000") %>
                            </td>
                            <td class="columnTdHeader" style="text-align:center;">
                              <%= com.egen.util.text.FormatNumber.format(total_peso_bruto,"##,##0.000") %>
                            </td>
                            <td class="columnTdHeader" style="text-align:center;">
                              <%= com.egen.util.text.FormatNumber.format(total_vlr_frete,"##,##0.00") %>
                            </td>
                            <td class="columnTdHeader" style="text-align:center;" >
                              <%= com.egen.util.text.FormatNumber.format(total_nfs_total_pares,"0") %>
                            </td>
                            <td class="columnTdHeader" style="text-align:center;" >
                            </td>
                            <td class="columnTdHeader" style="text-align:right;">
                              <%= com.egen.util.text.FormatNumber.format(total_cubagem,"##,##0.0000") %>
                            </td>
                            <td class="columnTdHeader" style="text-align:center;">
                            </td>
                            <td class="columnTdHeader" style="text-align:center;">
                            </td>
                            <%
                            if(despachante!=null){
                              %>
                              <td class="columnTdHeader" style="text-align:center;">
                              </td>
                              <%
                            }
                            %>
                            <td class="columnTdHeader" style="text-align:center;">
                            </td>
                            <td class="columnTdHeader" style="text-align:center;">
                            </td>
                          </tr>
                          <%
                        }
                        %>

                        <%
                      }
                    } catch (Exception e){
                      e.printStackTrace();
                    } finally {
                    }
                    %>
                  </table>
                  <html:form action="com/ConsultaNotaFiscal_rForm.do" method="post" styleClass="baseForm">
                    <table class="itemTable"  style=" width:;">
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <html:hidden property="par"/>
                        <%
                      }
                      %>
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <html:hidden property="grupo_economico"/>
                        <%
                      }
                      %>
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <tr class="itemTr">
                          <td class="formLabel">
                            <span class="spamFormLabel">
                            </span>
                          </td>
                          <td class="formField">
                            <html:text property="conhecimento" styleId="conhecimento" styleClass="myhidden"/>
                          </td>
                        </tr>
                        <%
                      }
                      %>

                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <html:hidden property="arquivo"/>
                        <%
                      }
                      %>
                      <table class="buttonTable" style='width:99%;'>
                        <tr class="buttonTr">
                          <td class="buttonTd">
                            <%
                            if(!(request.getParameter("excel")+"").equals("true")){
                              %>
                              <html:submit accesskey="b" styleClass="baseButton" property="back_action">
                                <bean:message bundle="ApplicationResources" key="jsp.back"/>
                              </html:submit>
                              <%
                            }
                            %>
                            <%
                            if(!(request.getParameter("excel")+"").equals("true")){
                              %>
                              <html:submit value="Blank" styleClass="myhidden" property="gera_conhecimento_action">
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ControleClientesEspeciais_mActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ControleClientesEspeciais_mActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("gridCheckField","");
    hashMapLabel.set("banco","");
    hashMapLabel.set("alterado","");
    hashMapLabel.set("ped_nmro","Pedido BR");
    hashMapLabel.set("ped_boni","Ped_boni");
    hashMapLabel.set("ped_boni2","Ped_boni2");
    hashMapLabel.set("ped_desc","Ped_desc");
    hashMapLabel.set("cnd_cdgo","cnd_cdgo");
    hashMapLabel.set("oc","OC");
    hashMapLabel.set("modelos","Linha");
    hashMapLabel.set("etiquetas","Etiquetas");
    hashMapLabel.set("dt_entrega_etiqueta","Dt_entrega_etiqueta");
    hashMapLabel.set("obse_adicionais","Obs.");
    hashMapLabel.set("prs","Pares");
    hashMapLabel.set("remessa","Rem.");
    hashMapLabel.set("filial_prd","Fl. Prod.");
    hashMapLabel.set("fil_filial_fat","Fl. Fat.");
    hashMapLabel.set("dt_digit","Digit.");
    hashMapLabel.set("dt_fatur","Fat. Cli.");
    hashMapLabel.set("dt_fatur_filial","Fat. BR.");
    hashMapLabel.set("marca","Marca");
    hashMapLabel.set("carimbo","Carimbo");
    hashMapLabel.set("rotulos","Rótulos");
    hashMapLabel.set("ped_amostra","Ped. Amostra");
    hashMapLabel.set("dt_envio_amostras","Dt. Envio");
    hashMapLabel.set("agendamento_cdgo","Agend.");
    hashMapLabel.set("dezena","Dezena");
    hashMapLabel.set("dia","Dia");
    hashMapLabel.set("data_efetiva","Dt. Efetiva");
    hashMapLabel.set("codigo_regional","Codigo_regional");
    hashMapLabel.set("rep_cdgo","Rep_cdgo");
    hashMapLabel.set("cli_cdgo","");
    hashMapLabel.set("codigo_marca","Codigo_marca");
    hashMapLabel.set("ped_stat","Ped_stat");
    hashMapLabel.set("bloqueia_navegador","");
    hashMapLabel.set("hora","Hora");
    hashMapLabel.set("senha","Senha");
    hashMapLabel.set("dt_emissao","Emissão");
    hashMapLabel.set("filial","Filial");
    hashMapLabel.set("notafiscal","NF");
    hashMapLabel.set("volumes","Volumes");
    hashMapLabel.set("dt_inspecao","Dt_inspecao");
    hashMapLabel.set("dt_montagem","Dt_montagem");
    hashMapLabel.set("grupo_economico","Grupo_economico");
    hashMapLabel.set("cli_rzao","Cli_rzao");
    hashMapLabel.set("situacao","Situação");
    hashMapLabel.set("cabide","Cabide");
    hashMapLabel.set("amostra","amostra");
    hashMapLabel.set("tipo_amostra","tipo_amostra");
    hashMapLabel.set("pedido_prod","pedido_prod");
    hashMapLabel.set("encarte","encarte");
    hashMapLabel.set("dt_ent_amostra_comercial","Dt_ent_amostra_comercial");
    hashMapLabel.set("dt_ent_amostra_pcp","Dt_ent_amostra_pcp");
    hashMapLabel.set("portao","Portão de Entrega");
    hashMapLabel.set("cd_entrega","CD de Entrega");
    hashMapLabel.set("data_entrega_cliente","Dt_digit");
    hashMapLabel.set("ped_amostra_brinde","ped_amostra_brinde");
    hashMapLabel.set("esc_seqn","Esc_seqn");
    hashMapLabel.set("nome_regional","Nome_regional");
    hashMapLabel.set("rep_rzao","Rep_rzao");
    hashMapLabel.set("ped_tipo","Ped_tipo");
    hashMapLabel.set("dt_rec_etiqueta_filial","Dt_rec_etiqueta_filial");
    hashMapLabel.set("encarte1","Encarte");
    hashMapLabel.set("prioridade_embarque","Prioridade_embarque");
    hashMapLabel.set("atacado","Atacado");
    hashMapLabel.set("alerta","Alerta");
    hashMapLabel.set("ped_especie_pedido","Ped_especie_pedido");
    hashMapLabel.set("ped_obse","Observação Pedido");
    hashMapLabel.set("dt_emiss","Dt_emiss");
    hashMapLabel.set("nro_normativa_cliente","Nro_normativa_cliente");
    hashMapLabel.set("descricao_normativa_cliente","Descricao_normativa_cliente");
    hashMapLabel.set("min_fabr","Min_fabr");
    hashMapLabel.set("bloqueio_49","Bloqueio_49");
    hashMapLabel.set("loja","Loja");
    hashMapLabel.set("cidade","Cidade");
    hashMapLabel.set("ped_invoice","Ped_invoice");
    hashMapLabel.set("ocorrencia","ocorrencia");
    hashMapLabel.set("data_bloqueio","data_bloqueio");
    hashMapLabel.set("data_prevista_desbloqueio","data_prevista_desbloqueio");
    hashMapLabel.set("dt_solicitacao_alarme","dt_solicitacao_alarme");
    hashMapLabel.set("dt_rec_alarme_pcp","dt_rec_alarme_pcp");
    hashMapLabel.set("dt_rec_alarme_filial","dt_rec_alarme_filial");
    hashMapLabel.set("nfe_numero","Nfe_numero");
    hashMapLabel.set("valor_pedido","double");
    hashMapLabel.set("distribuicao","Distribuição");
    hashMapLabel.set("livro","Livro");
    hashMapLabel.set("ref_cliente_por_pedido","Ref_cliente_por_pedido");
    hashMapLabel.set("tra_cdgo","Tra_cdgo");
    hashMapLabel.set("tra_rzao","Tra_rzao");
    hashMapLabel.set("dt_corte","Dt_corte");
    hashMapLabel.set("preco_pdv","Preco_pdv");
    hashMapLabel.set("certificado_origem","Certificado_origem");
    hashMapLabel.set("gerar_requisicao","gerar_requisicao");
    hashMapLabel.set("tes_codigo","tes_codigo");
    hashMapLabel.set("les_codigo","les_codigo");
    hashMapLabel.set("data_etiquetagem","Data_etiquetagem");
    hashMapLabel.set("descricao_modelos","Descrição");
    hashMapLabel.set("liberado_faturar","liberado_faturar");
    hashMapLabel.set("descricao_situacao","descricao_situacao");
    hashMapLabel.set("descricao_embalagem","descricao_embalagem");
    hashMapLabel.set("cnpj","Cnpj");
    hashMapLabel.set("numero_romaneio","Numero_romaneio");
    hashMapLabel.set("data_finalizacao_romaneio","Data_finalizacao_romaneio");
    hashMapLabel.set("modelo_alarme","Modelo_alarme");
    hashMapLabel.set("grades_corrugados","Grades_corrugados");
    hashMapLabel.set("filial_local_estoque","Filial_local_estoque");
    hashMapLabel.set("bloqueio_oc","");
    hashMapLabel.set("bloqueio_distribuicao","");
    hashMapLabel.set("bloqueio_cliente","");
    hashMapLabel.set("bloqueio_sku","");
    hashMapLabel.set("bloqueio_credito","");
    hashMapLabel.set("bloqueio_suframa","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Controle de Clientes Especiais
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(186)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <style>
              .dotGreen { height: 20px; width: 20px; background-color: #86af49; border-radius: 50%; display: inline-block; } .dotRed { height: 20px; width: 20px; background-color: #c94c4c; border-radius: 50%; display: inline-block; } .dotGrey { height: 20px; width: 20px; background-color: #b2b2b2; border-radius: 50%; display: inline-block; } .dotYellow { height: 20px; width: 20px; background-color: #ffef96; border-radius: 50%; display: inline-block; }
            </style>
            <%
            util.consultas.com.ControleClientesEspeciais controleClientesEspeciais = new util.consultas.com.ControleClientesEspeciais();
            String styleNormativa = "";
            boolean gerou_planilha = false;
            boolean somente_consulta = false;
            java.util.List<String> listaDesconsiderarBloqueioFilialFat = controleClientesEspeciais.retornaDesconsiderarBloqueioFilialFat();
            if(session.getAttribute("somente_consulta")!=null){
              somente_consulta = true;
            }
            if(session.getAttribute("gerar_planilha")!=null){
              gerou_planilha = true;
            }
            if(session.getAttribute("gerar_planilha_subtotal")!=null){
              gerou_planilha = true;
            }
            if(gerou_planilha){
              %>
              <table style=width:100%;margin-top:10;>
                <tr>
                  <td class=columHeader style="text-align:center;">
                    <a href="<%= (String)session.getAttribute("arquivo") %>" target="_blank">
                      <bean:message key="report.downloadxls"/>
                    </a>
                  </td>
                </tr>
              </table>
              <html:form action="com/ControleClientesEspeciais_mGrid.do" method="post" styleClass="baseForm">
                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit styleClass="baseButton" property="back_action">
                        <bean:message bundle="ApplicationResources" key="jsp.back"/>
                      </html:submit>
                    </td>
                  </tr>
                </table>
              </html:form>
              <%
              session.removeAttribute("arquivo");
            } else {
              %>

              <style>
                .text {mso-number-format:"\@" }
              </style>

              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw"/>
                  </td>
                </tr>
              </table>

              <%
              acesso.Sessao sessao = new acesso.Sessao(session);
              boolean representante = false;
              util.bloqueio.BloqueioUtil bloqueio = new util.bloqueio.BloqueioUtil(186, request);
              boolean bloqueiaSalvarAlteracoes = false;
              boolean bloqueiaEtiquetas = false;
              boolean bloqueiaDtEntregaEtiqueta = false;
              boolean bloqueiaObseAdicionais = false;
              boolean bloqueiaCertificadoOrigem = false;
              boolean bloqueiaFilFilialFat = false;
              boolean bloqueiaDtFaturFilial = false;
              boolean bloqueiaCabide = false;
              boolean bloqueiaCarimbo = false;
              boolean bloqueiaRotulos = false;
              boolean bloqueiaDtEnvioAmostras = false;
              boolean bloqueiaAgendamentoCdgo = false;
              boolean bloqueiaDataEfetiva = false;
              boolean bloqueiaHora = false;
              boolean bloqueiaSenha = false;
              boolean bloqueiaPortao = false;
              boolean bloqueiaDtInspecao = false;
              boolean bloqueiaDtRecEtiquetaFilial = false;
              boolean bloqueiaEncarte = false;
              boolean bloqueiaPrioridadeEmbarque = false;
              boolean bloqueiaAtacado = false;
              boolean bloqueiaNfeNumero = false;
              String styleControle = "";
              String grupoEconomicoAtual = null;
              String descricaoGrupoEconomicoAtual = null;
              String grupoEconomicoAnterior = null;
              String descricaoGrupoEconomicoAnterior = null;
              String bloqueioOc = null;
              String bloqueioDistribuicao = null;
              String bloqueioCliente = null;
              String bloqueioSku = null;
              String bloqueioCredito = null;
              String bloqueioSuframa = null;

              int pares = 0;
              int paresTotal = 0;
              if(bloqueio.tipoBloqueio("SALVAR_ALTERACOES").equals("E")){
                bloqueiaSalvarAlteracoes = true;
              }
              if(somente_consulta){
                bloqueiaSalvarAlteracoes = true;
              }
              if(bloqueio.tipoBloqueio("DT_REC_ETIQUETA_FILIAL").equals("D")){
                bloqueiaDtRecEtiquetaFilial = true;
              }
              if(bloqueio.tipoBloqueio("ETIQUETAS").equals("D")){
                bloqueiaEtiquetas = true;
              }
              if(bloqueio.tipoBloqueio("DT_ENTREGA_ETIQUETA").equals("D")){
                bloqueiaDtEntregaEtiqueta = true;
              }
              if(bloqueio.tipoBloqueio("OBSE_ADICIONAIS").equals("D")){
                bloqueiaObseAdicionais = true;
              }
              if(bloqueio.tipoBloqueio("CERTIFICADO_ORIGEM").equals("D")){
                bloqueiaCertificadoOrigem = true;
              }
              if(bloqueio.tipoBloqueio("FIL_FILIAL_FAT").equals("D")){
                bloqueiaFilFilialFat = true;
              }
              if(bloqueio.tipoBloqueio("DT_FATUR_FILIAL").equals("D")){
                bloqueiaDtFaturFilial = true;
              }
              if(bloqueio.tipoBloqueio("CABIDE").equals("D")){
                bloqueiaCabide = true;
              }
              if(bloqueio.tipoBloqueio("CARIMBO").equals("D")){
                bloqueiaCarimbo = true;
              }
              if(bloqueio.tipoBloqueio("NFE_NUMERO").equals("D")){
                bloqueiaNfeNumero = true;
              }
              if(bloqueio.tipoBloqueio("ROTULOS").equals("D")){
                bloqueiaRotulos = true;
              }
              if(bloqueio.tipoBloqueio("DT_ENVIO_AMOSTRAS").equals("D")){
                bloqueiaDtEnvioAmostras = true;
              }
              if(bloqueio.tipoBloqueio("AGENDAMENTO_CDGO").equals("D")){
                bloqueiaAgendamentoCdgo = true;
              }
              if(bloqueio.tipoBloqueio("DATA_EFETIVA").equals("D")){
                bloqueiaDataEfetiva = true;
              }
              if(bloqueio.tipoBloqueio("HORA").equals("D")){
                bloqueiaHora = true;
              }
              if(bloqueio.tipoBloqueio("SENHA").equals("D")){
                bloqueiaSenha = true;
              }
              if(bloqueio.tipoBloqueio("PORTAO").equals("D")){
                bloqueiaPortao = true;
              }
              if(bloqueio.tipoBloqueio("DT_INSPECAO").equals("D")){
                bloqueiaDtInspecao = true;
              }
              if(bloqueio.tipoBloqueio("ENCARTE").equals("D")){
                bloqueiaEncarte = true;
              }
              if(bloqueio.tipoBloqueio("PRIORIDADE_EMBARQUE").equals("D")){
                bloqueiaPrioridadeEmbarque = true;
              }
              if(bloqueio.tipoBloqueio("ATACADO").equals("D")){
                bloqueiaAtacado = true;
              }
              java.util.Vector res_Controle_clientes_especiais_vw = (java.util.Vector)session.getAttribute("res_Controle_clientes_especiais_vw");
              int i = 0;
              %>
              <html:form action="com/ControleClientesEspeciais_mGrid.do" method="post" styleClass="baseForm">

                <%
                if(res_Controle_clientes_especiais_vw != null && res_Controle_clientes_especiais_vw.size()>0){
                  %>
                  <%
                  if(!(request.getParameter("excel")+"").equals("true")){
                    %>
                    <%
                    if((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO"))){
                      representante = true;
                    }
                    %>
                    <table class="messageTable" style='width:99%;'>
                      <tr class="messageTr" >
                        <td class="messageTd">
                          <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw"/>
                        </td>
                      </tr>
                    </table>
                    <%
                  }
                  %>

                  <%
                  if(!(request.getParameter("excel")+"").equals("true")){
                    %>
                    <table class="reportTable" style='width:7000px;' border="1">

                      <%
                    } else {
                      %>
                      <table class="reportTable" style='width:7000px;' border="1">
                        <%
                      }
                      %>
                      <tr class="reportTr">
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Bloq.
                            <br/>
                            49
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Preço
                            <br/>
                            Pdv
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Bloq.
                            <br/>
                            UF
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Alerta
                            <br>
                            Etiqueta
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Bloq.
                            <br/>
                            Crédito
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Bloq.
                            <br/>
                            OC
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Bloq.
                            <br/>
                            Distr.
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Bloq.
                            <br/>
                            Cli.
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Bloq.
                            <br/>
                            SKU
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Bloq.
                            <br/>
                            Suframa
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Antecipação
                            <br/>
                            Não Permitida
                          </td>
                          <td class="columnTdHeader" style="text-align: left; width: 200px">
                            Regional
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Sit.
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Tipo
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Espécie
                          </td>
                          <td class="columnTdHeader" style="text-align: center;">
                            Pedido BR
                          </td>
                          <td class="columnTdHeader" style="text-align: center;">
                            Desc. Com.
                          </td>
                          <td class="columnTdHeader" style="text-align: center;">
                            Desc. Prom.
                          </td>
                          <td class="columnTdHeader" style="text-align: center;">
                            Desc Pont.
                          </td>
                          <td class="columnTdHeader" style="text-align: center;">
                            Cond. Pagto.
                          </td>
                          <td class="columnTdHeader" style="text-align: center;">
                            Livro
                          </td>
                          <td class="columnTdHeader" style="text-align: center;">
                            Invoice
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            OC
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Linha
                          </td>
                          <td class="columnTdHeader" style="text-align: left">
                            Descrição
                          </td>
                          <td class="columnTdHeader" style="text-align: left">
                            Tipo da Embalagem
                          </td>
                          <td class="columnTdHeader" style="text-align: left; width: 1%">
                            Obs.
                            <br>
                            <input type="button" value="Informar Observação" styleClass="baseButton" onclick="wopen('../com/ControleClientesEspeciais_pForm.do?resetfull_action=&tipo=observacao','_blank',500,100)" />
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Etiquetas
                            <br>
                            <input type="button" value="Informar Etiqueta" styleClass="baseButton" onclick="wopen('../com/ControleClientesEspeciais_pForm.do?resetfull_action=&tipo=etiqueta','_blank',500,100)" />
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Dt. Entrega
                            <br>
                            Etiqueta
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Dt. Rec.
                            <br>
                            Etiqueta Filial
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Dt. Etiquetagem
                          </td>
                          <td class="columnTdHeader" style="text-align: left; width: 1%">
                            Certificado Origem
                            <br>
                            <input type="button" value="Informar Certificado" styleClass="baseButton" onclick="wopen('../com/ControleClientesEspeciais_pForm.do?resetfull_action=&tipo=certificado_origem','_blank',500,100)" />
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Carimbo
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Normativa
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Pares
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Valor
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Grades/Corrugados
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Mini-Fábrica
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Rem.
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Fl. Prod.
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Local Estoque
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Tipo Estoque
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Fl. Fat.
                            <input type="button" value="Informar Filial" styleClass="baseButton" onclick="wopen('../com/ControleClientesEspeciais_pForm.do?resetfull_action=&tipo=filial_faturamento','_blank',500,100)" />
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Dt. Emissão Pedido
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Dt. Digit.
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Dt. Montagem
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Dt. Corte
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            <%
                            if(!(request.getParameter("excel")+"").equals("true")){
                              %>
                              <img style=cursor:pointer src=../img/ballhelp.gif border=0 onmouseout="this.src='../img/ballhelp.gif'" onmouseover="this.src='../img/ballhelp_c.gif'" onclick="javascript:window.open('../lov/HelpForm.jsp?help=Data de entrega do pedido.','def','scrollbars,height=400,width=340,TOP=0,LEFT=0')">
                              <br>
                              <%
                            }
                            %>
                            Prev. Faturamento
                          </td>
                          <td class="tdGridlabel" style="text-align: center">
                            Marca
                          </td>
                          <td class="columnTdHeader" style="text-align: center">
                            Semana
                            <br>
                            Agendamento
                            <br>
                            <input type="button" value="Informar Semana" styleClass="baseButton" onclick="wopen('../com/ControleClientesEspeciais_pForm.do?resetfull_action=&tipo=semana_agendamento','_blank',500,100)" />
                          </td>
                          <td class="columnTdHeader" style="text-align: center;">
                            Data
                            <br>
                            Agendamento
                            <br>
                            <input type="button" value="Informar Data" styleClass="baseButton" onclick="wopen('../com/ControleClientesEspeciais_pForm.do?resetfull_action=&tipo=data_agendamento','_blank',500,100)" />
                          </td>
                          <td class="tdGridlabel">
                            <span class="spamFormLabel">
                            </span>
                          </td>
                          <td class="columnTdHeader" style="text-align: center;">
                            Hora
                            <br>
                            <input type="button" value="Informar Hora" styleClass="baseButton" onclick="wopen('../com/ControleClientesEspeciais_pForm.do?resetfull_action=&tipo=hora','_blank',500,100)" />
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Senha
                            <br>
                            <input type="button" value="Informar Senha" styleClass="baseButton" onclick="wopen('../com/ControleClientesEspeciais_pForm.do?resetfull_action=&tipo=senha','_blank',500,100)" />
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Portão de Entrega (doca)
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            CD de Entrega
                          </td>
                          <%
                        } else {
                          %>

                          <%
                          if(session.getAttribute("cb_bloqueio_49")!=null) {
                            %>
                            <td class="tdGridlabel">
                              <span class="spamFormLabel">
                                Bloqueio 49
                              </span>
                            </td>
                            <%
                          }
                          %>

                          <%
                          if(session.getAttribute("preco_pdv")!=null) {
                            %>
                            <td class="tdGridlabel">
                              <span class="spamFormLabel">
                                Preco Pdv
                              </span>
                            </td>
                            <%
                          }
                          %>

                          <%
                          if(session.getAttribute("cb_bloqueio_uf")!=null) {
                            %>
                            <td class="tdGridlabel">
                              <span class="spamFormLabel">
                                Bloqueio UF
                              </span>
                            </td>
                            <%
                          }
                          %>

                          <%
                          if(session.getAttribute("cb_alerta_etiqueta")!=null) {
                            %>
                            <td class="tdGridlabel">
                              <span class="spamFormLabel">
                                Alerta Etiqueta
                              </span>
                            </td>
                            <%
                          }
                          %>
                          <%
                          if(session.getAttribute("cb_bloqueado_credito")!=null) {
                            %>
                            <td class="tdGridlabel">
                              <span class="spamFormLabel">
                                Bloqueado no crédito
                              </span>
                            </td>
                            <%
                          }
                          %>


                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Bloq. OC
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Bloq. Distr.
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Bloq. Cli.
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Bloq. SKU
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Bloq. Suframa
                          </td>
                          <td class="columnTdHeader" style="text-align: center; width: 1%">
                            Antecipação Não Permitida
                          </td>


                          <%
                          if(session.getAttribute("cb_regional")!=null) {
                            %>
                            <td class="tdGridlabel">
                              <span class="spamFormLabel">
                                Regional
                              </span>
                            </td>
                            <%
                          }
                          %>
                          <%
                          if(session.getAttribute("cb_situacao")!=null) {
                            %>
                            <td class="tdGridlabel" style="width: 1%">
                              <span class="spamFormLabel">
                                Sit.
                              </span>
                            </td>
                            <%
                          }
                          %>
                          <%
                          if(session.getAttribute("cb_tipo_pedido")!=null) {
                            %>

                            <td class="tdGridlabel" style="width: 1%">
                              <span class="spamFormLabel">
                                Tipo
                              </span>
                            </td>
                            <%
                          }
                          %>
                          <%
                          if(session.getAttribute("cb_especie")!=null) {
                            %>

                            <td class="tdGridlabel" style="width: 1%">
                              <span class="spamFormLabel">
                                Espécie
                              </span>
                            </td>

                            <%
                          }
                          %>
                          <%
                          if(session.getAttribute("cb_pedido")!=null) {
                            %>
                            <td class="tdGridlabel">
                              <span class="spamFormLabel">
                                Pedido BR
                              </span>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_desc_com")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Desc. Com.
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_desc_prom")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Desc. Prom.
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_desc_pont")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Desc. Pont.
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_cnd_cdgo")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Cond. Pag.
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_livro")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Livro
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_invoice")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Invoice
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_oc")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  OC
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_linha")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Linha
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_descricao_item")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Descrição
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_descricao_embalagem")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Tipo da Embalagem
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_obs")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Obs.
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_etiquetas")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Etiquetas
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_dt_entrega_etiqueta")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Dt. Entrega Etiqueta
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_dt_rec_etiqueta_filial")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Dt. Rec. Etiqueta Filial
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_data_etiquetagem")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Data Etiquetagem
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_certificado_origem")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Certificado Origem
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_carimbo")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Carimbo
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_cabide")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Normativa
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_pares")!=null) {
                              %>
                              <td class="reportColumn" style="text-align: center">
                                Pares
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_valor")!=null) {
                              %>
                              <td class="reportColumn" style="text-align: center">
                                Valor
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_grade_corrugado")!=null) {
                              %>
                              <td class="reportColumn" style="text-align: center">
                                Grades/Corrugados
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_mini_fabrica")!=null) {
                              %>
                              <td class="reportColumn" style="text-align: center">
                                Mini-Fábrica
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_rem")!=null) {
                              %>
                              <td class="reportColumn" style="text-align: center">
                                Rem.
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_fl_prod")!=null) {
                              %>
                              <td class="reportColumn" style="text-align: center">
                                Fl. Prod.
                              </td>
                              <%
                            }
                            %>
                            <td class="reportColumn" style="text-align: center">
                              Local Estoque
                            </td>

                            <%
                            if(session.getAttribute("cb_tipo_estoque")!=null) {
                              %>
                              <td class="reportColumn" style="text-align: center">
                                Tipo Estoque
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_fl_fat")!=null) {
                              %>
                              <td class="reportColumn" style="text-align: center">
                                Fl. Fat.
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_emiss")!=null) {
                              %>
                              <td class="reportColumn" style="text-align: center">
                                Dt. Emissão Pedido
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_digit")!=null) {
                              %>
                              <td class="reportColumn" style="text-align: center">
                                Dt. Digit.
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_dt_montagem")!=null) {
                              %>
                              <td class="reportColumn" style="text-align: center">
                                Dt. Montagem
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_dt_corte")!=null) {
                              %>
                              <td class="reportColumn" style="text-align: center">
                                Dt. Corte
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_fat_cli")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Prev. Faturamento
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_marca")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Marca
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_agenda")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Semana
                                  <br>
                                  Agendamento
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_dt_efetiva")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Data
                                  <br>
                                  Agendamento
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_hora")!=null) {
                              %>
                              <td>
                              </td>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Hora
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_senha")!=null) {
                              %>
                              <td class="tdGridlabel" style="text-align: center">
                                Senha
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_portao_entrega")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Portão de Entrega (doca)
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_cd_entrega")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  CD de Entrega
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                          }
                          %>
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <td class="columnTdHeader" style="text-align: center;">
                              <%
                              if(!(request.getParameter("excel")+"").equals("true")){
                                %>
                                <img style=cursor:pointer src=../img/ballhelp.gif border=0 onmouseout="this.src='../img/ballhelp.gif'" onmouseover="this.src='../img/ballhelp_c.gif'" onclick="javascript:window.open('../lov/HelpForm.jsp?help=Data de emissão da nota fiscal.','def','scrollbars,height=400,width=340,TOP=0,LEFT=0')">
                                <br>
                                <%
                              }
                              %>
                              Dt. Faturamento
                            </td>
                            <td class="columnTdHeader" style="text-align: center;">
                              Filial NF
                            </td>
                            <td class="columnTdHeader" style="text-align: center;">
                              NF
                            </td>
                            <td class="columnTdHeader" style="text-align: center;">
                              Volumes
                            </td>
                            <%
                            if(true) {
                              %>
                              <td class="columnTdHeader" style="text-align: center;">
                                Número Romaneio
                              </td>
                              <td class="columnTdHeader" style="text-align: center;">
                                Data Finalização Romaneio
                              </td>
                              <%
                            }
                            %>
                            <td class="columnTdHeader" style="text-align: center;">
                              Dt. Inspeção
                              <br/>
                              <input type="button" value="Informar Dt. Inspeção" styleClass="baseButton" onclick="wopen('../com/ControleClientesEspeciais_pForm.do?resetfull_action=&tipo=data_inspecao','_blank',500,100)" />
                            </td>
                            <%
                          } else {
                            %>
                            <%
                            if(session.getAttribute("cb_emissao")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Dt. Faturamento
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_filial")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  Filial NF
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_nf")!=null) {
                              %>
                              <td class="tdGridlabel">
                                <span class="spamFormLabel">
                                  NF
                                </span>
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_volumes")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: center;">
                                Volumes
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_romaneio")!=null) {
                              %>

                              <td class="columnTdHeader" style="text-align: center;">
                                Número Romaneio
                              </td>

                              <td class="columnTdHeader" style="text-align: center;">
                                Data Finalização Romaneio
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_dt_inspecao")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: center;">
                                Dt. Inspeção
                              </td>
                              <%
                            }
                            %>
                            <%
                          }
                          %>

                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <td class="columnTdHeader" style="text-align: center;">
                              Previsão
                              <br>
                              Dt. Entrega Cliente
                            </td>
                            <td class="columnTdHeader" style="text-align: center;">
                              Dt. Última Ocorrência
                            </td>
                            <td class="columnTdHeader" style="text-align: center;">
                              Encarte
                            </td>
                            <td class="columnTdHeader" style="text-align: center;">
                              Prioridade
                              <br>
                              Embarque
                            </td>
                            <td class="columnTdHeader" style="text-align: center;">
                              Atacado
                            </td>
                            <td class="columnTdHeader" style="text-align: left;">
                              Grupo Econômico
                            </td>
                            <td class="columnTdHeader" style="text-align: center;">
                              Cliente
                            </td>
                            <td class="columnTdHeader" style="text-align: center;">
                              Seq.
                            </td>
                            <td class="columnTdHeader" style="text-align: left; width: 250px">
                              Razão Social
                            </td>
                            <td class="columnTdHeader" style="text-align: left;">
                              Cnpj
                            </td>
                            <td class="columnTdHeader" style="text-align: left;">
                              Cidade
                            </td>
                            <td class="columnTdHeader" style="text-align: center; width: 1%">
                              Loja
                            </td>
                            <td class="columnTdHeader" style="text-align: left;">
                              Normativa
                            </td>
                            <td class="columnTdHeader" style="text-align: left;">
                              Representante
                            </td>
                            <td class="columnTdHeader" style="text-align: left; width: 300px">
                              Obs. Pedido
                            </td>
                            <td class="columnTdHeader" style="text-align: left; width: 300px">
                              Data Bloqueio
                            </td>
                            <td class="columnTdHeader" style="text-align: left; width: 300px">
                              Data prevista
                              <br>
                              desbloqueio
                            </td>
                            <td class="columnTdHeader" style="text-align: left; width: 300px">
                              Data Solicitação
                              <br>
                              alarme
                              <br/>
                              <input type="button" value="Informar Dt. Solicitação Alarme" styleClass="baseButton" onclick="wopen('../com/ControleClientesEspeciais_pForm.do?resetfull_action=&tipo=data_solicitacao_alarme','_blank',500,100)" />
                            </td>
                            <td class="columnTdHeader" style="text-align: left; width: 300px">
                              Data Recebimento
                              <br>
                              alarme PCP
                            </td>
                            <td class="columnTdHeader" style="text-align: left; width: 300px">
                              Data Recebimento
                              <br>
                              alarme filial
                            </td>
                            <%
                            if(!bloqueiaNfeNumero){
                              %>
                              <td class="columnTdHeader" style="text-align: left;">
                                Nota Fiscal Alarme
                              </td>
                              <%
                            }
                            %>
                            <td class="columnTdHeader" style="text-align: left; width: 300px">
                              Modelo Alarme
                              <br>
                              <input type="button" value="Informar Modelo Alarme" styleClass="baseButton" onclick="wopen('../com/ControleClientesEspeciais_pForm.do?resetfull_action=&tipo=modelo_alarme','_blank',500,100)" />
                            </td>
                            <td class="columnTdHeader" style="text-align: center;">
                              Distribuição
                            </td>
                            <td class="columnTdHeader" style="text-align: left;">
                              Transportadora
                            </td>
                            <td class="columnTdHeader" style="text-align: center">
                              Gerar Requisição
                              <br/>
                              <input type="button" value="Marcar/Desmarcar Todos" styleClass="baseButton" onclick="marcar_desmarcar_gerar_requisicao_action.click()" />
                            </td>
                            <%
                          } else {
                            %>

                            <%
                            if(session.getAttribute("cb_dt_entrega")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: center;">
                                Previsão
                                <br>
                                Dt. Entrega Cliente
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_dt_ultima_ocorrencia")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: center;">
                                Dt. Última Ocorrência
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_encarte")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: center;">
                                Encarte
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_prioridade_embarque")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: center;">
                                Prioridade
                                <br>
                                Embarque
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_atacado")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: center;">
                                Atacado
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_grupo_economico")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: left;">
                                Grupo Econômico
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_cliente")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: center;">
                                Cliente
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_seq")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: center;">
                                Seq.
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_razao_social")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: left; width: 250px">
                                Razão Social
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_cnpj")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: left;">
                                Cnpj
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_cidade")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: left;">
                                Cidade
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_loja")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: center; width: 1%">
                                Loja
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_normativa_cliente")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: left;">
                                Normativa
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_representante")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: left;">
                                Representante
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_obs_pedido")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: left; width: 300px">
                                Obs. Pedido
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_data_bloqueio")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: left; width: 300px">
                                Data Bloqueio
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_data_prevista_desbloqueio")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: left; width: 300px">
                                Data prevista
                                <br>
                                desbloqueio
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_dt_solicitacao_alarme")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: left; width: 300px">
                                Data Solicitação
                                <br>
                                alarme
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_dt_recebimento_alarme")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: left; width: 300px">
                                Data Recebimento
                                <br>
                                alarme PCP
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_dt_recebimento_alarme_filial")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: left; width: 300px">
                                Data Recebimento
                                <br>
                                alarme filial
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(!bloqueiaNfeNumero){
                              %>
                              <%
                              if(session.getAttribute("cb_nota_fiscal_alarme")!=null) {
                                %>
                                <td class="columnTdHeader" style="text-align: left;">
                                  Nota Fiscal Alarme
                                </td>
                                <%
                              }
                              %>
                              <%
                            }
                            %>

                            <%
                            if(true) {
                              %>
                              <td class="columnTdHeader" style="text-align: left;">
                                Modelo Alarme
                              </td>
                              <%
                            }
                            %>

                            <%
                            if(session.getAttribute("cb_distribuicao")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: center;">
                                Distribuição
                              </td>
                              <%
                            }
                            %>

                            <%
                            if(session.getAttribute("cb_tra_cdgo")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: left;">
                                Transportadora
                              </td>
                              <%
                            }
                            %>
                            <%
                            if(session.getAttribute("cb_gerar_requisicao")!=null) {
                              %>
                              <td class="columnTdHeader" style="text-align: center">
                                Gerar Requisição
                              </td>
                              <%
                            }
                            %>
                            <%
                          }
                          %>
                        </tr>
                        <logic:iterate id="bl_form_Controle_clientes_especiais_vw_lines" name="ControleClientesEspeciais_mGridActionForm" property="bl_form_Controle_clientes_especiais_vw_lines" indexId="indexId">
                          <%
                          Controle_clientes_especiais_vw controle = (Controle_clientes_especiais_vw)res_Controle_clientes_especiais_vw.elementAt(i);
                          if (!((i%2)!=0)) {
                            styleControle="rowColor";
                          } else {
                            styleControle="rowBlank";
                          }
                          %>
                          <%
                          if(grupoEconomicoAtual == null){
                            grupoEconomicoAtual = controle.getGrupo_economico();
                            descricaoGrupoEconomicoAtual = controle.getGrupo_descricao();
                          }
                          if(!controle.getGrupo_economico().equals(grupoEconomicoAtual)){
                            grupoEconomicoAnterior = grupoEconomicoAtual;
                            descricaoGrupoEconomicoAnterior = descricaoGrupoEconomicoAtual;
                            grupoEconomicoAtual = controle.getGrupo_economico();
                            descricaoGrupoEconomicoAtual = controle.getGrupo_descricao();
                          }
                          %>

                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if(session.getAttribute("subtotal_grupo_economico")!=null) {
                              %>
                              <%
                              if((!grupoEconomicoAtual.equals(grupoEconomicoAnterior+"")) && grupoEconomicoAnterior != null){
                                %>
                                <tr>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn" style="text-align: center; font-weight: bold; color: red">
                                    Total
                                    <%= descricaoGrupoEconomicoAnterior %>
                                  </td>
                                  <td class="reportColumn" style="text-align: center; font-weight: bold; color: red">
                                    <%= com.egen.util.text.FormatNumber.format(pares, "#,##0.##") %>
                                  </td>
                                  <td class="reportColumn" style="text-align: center"/>
                                  <td class="reportColumn" style="text-align: center"/>
                                  <td class="reportColumn" style="text-align: center"/>
                                  <td class="reportColumn" style="text-align: center"/>
                                  <td class="reportColumn" style="text-align: center"/>
                                  <td class="reportColumn" style="text-align: center"/>
                                  <td class="reportColumn" style="text-align: center"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn" style="text-align: center"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn"/>
                                  <td class="reportColumn" style="text-align: center"/>
                                  <td class="reportColumn" style="text-align: center"/>
                                  <td class="reportColumn" style="text-align: center"/>
                                  <td class="reportColumn" style="text-align: center"/>
                                  <td class="reportColumn" style="text-align: center"/>
                                  <td class="reportColumn" style="text-align: center"/>
                                  <td class="reportColumn" style="text-align: left"/>
                                  <td class="reportColumn" style="text-align: center"/>
                                  <td class="reportColumn" style="text-align: center"/>
                                  <td class="reportColumn" style="text-align: center"/>
                                  <td class="reportColumn" style="text-align: left"/>
                                  <td class="reportColumn" style="text-align: left width: 300px"/>
                                </tr>

                                <%
                                pares = 0;
                              }
                              %>

                              <%
                              grupoEconomicoAnterior  = grupoEconomicoAtual;
                              grupoEconomicoAtual = controle.getGrupo_economico();

                            }
                            pares += controle.getPrs();
                            paresTotal += controle.getPrs();
                            %>


                            <tr class="<%= styleControle %>">
                              <html:hidden property="gridCheckField" value="true" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true" styleId="gridCheckField"/>
                              <html:hidden property="banco" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true" styleId="banco"/>
                              <html:hidden property="alterado" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true" styleId="alterado"/>

                              <td class="reportColumn" style="text-align: center; width=1%">
                                <%
                                if(controle.getBloqueio_49().equalsIgnoreCase("S")){
                                  %>
                                  <span class="dotRed" />
                                  <%
                                } else {
                                  %>
                                  <span class="dotGreen" />
                                  <%
                                }
                                %>
                              </td>

                              <td class="reportColumn" style="text-align: center; width=1%">
                                <%
                                if(controle.getPreco_pdv().equalsIgnoreCase("N")){
                                  %>
                                  <span class="dotRed" />
                                  <%
                                } else {
                                  %>
                                  <span class="dotGreen" />
                                  <%
                                }
                                %>
                              </td>
                              <td class="reportColumn" style="text-align: center; width=1%">
                                <%
                                if(controle.getLiberado_faturar().equalsIgnoreCase("0")){
                                  %>
                                  <span class="dotRed" />
                                  <%
                                } else {
                                  %>
                                  <span class="dotGreen" />
                                  <%
                                }
                                %>
                              </td>
                              <td class="reportColumn" style="text-align: center; width=1%">
                                <%
                                if(controle.getAlerta().equalsIgnoreCase("1")){
                                  %>
                                  <span class="dotGreen" />
                                  <%
                                } else if(controle.getAlerta().equalsIgnoreCase("2")){
                                  %>
                                  <span class="dotYellow" />
                                  <%
                                } else if(controle.getAlerta().equalsIgnoreCase("3")){
                                  %>
                                  <span class="dotRed" />
                                  <%
                                } else {
                                  %>
                                  <span class="dotGrey" />
                                  <%
                                }
                                %>
                              </td>
                              <td class="reportColumn" style="text-align: center; width=1%">
                                <%
                                if(controle.getBloqueado_credito().equalsIgnoreCase("S")){
                                  %>
                                  <span class="dotRed" />
                                  <%
                                } else {
                                  %>
                                  <span class="dotGrey" />
                                  <%
                                }
                                %>
                              </td>

                              <td style="text-align: center; width=1%">
                                <span class="<%= controle.getBloqueio_oc() %>"/>
                              </td>

                              <td style="text-align: center; width=1%">
                                <span class="<%= controle.getBloqueio_distribuicao() %>"/>
                              </td>

                              <td style="text-align: center; width=1%">
                                <%
                                if(controle.getBloqueio_cliente().equals("I")) {
                                  %>
                                  <span class="dotRed" />
                                  <%
                                } else {
                                  %>
                                  <span class="dotGreen"/>
                                  <%
                                }
                                %>
                              </td>

                              <td style="text-align: center; width=1%">
                                <span class="<%= controle.getBloqueio_sku() %>"/>
                              </td>

                              <td style="text-align: center; width=1%">
                                <span class="<%= controle.getBloqueio_suframa() %>"/>
                              </td>

                              <td style="text-align: center; width=1%">
                                <span class="<%= controle.getBloqueio_antecipacao() %>"/>
                              </td>

                              <td class="reportColumn" style="text-align: left">
                                <html:hidden property="codigo_regional" value="<%= controle.getCodigo_regional()!=null?(controle.getCodigo_regional() + " - " + controle.getNome_regional()):""  %>" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                <%= controle.getCodigo_regional()!=null?(controle.getCodigo_regional() + " - " + controle.getNome_regional()):""  %>
                              </td>
                              <td class="reportColumn" style="text-align: center">
                                <html:hidden property="situacao" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                <%= controle.getSituacao() %>
                                -
                                <%= controle.getDescricao_situacao() %>
                              </td>
                              <td class="reportColumn" style="text-align: center">
                                <html:hidden property="ped_tipo" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                <%= controle.getPed_tipo() %>
                              </td>
                              <td class="reportColumn" style="text-align: center">
                                <html:hidden property="ped_especie_pedido" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                <%= controle.getPed_especie_pedido() %>
                              </td>
                              <td class="reportColumn" style="text-align: center">
                                <html:hidden property="ped_nmro" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                <%= controle.getPed_nmro() %>
                                <%
                                if(controle.getExiste_log_ped_inf_add()==1) {
                                  %>
                                  <img src="../img/viewmag.png" onmouseover="this.src='../img/viewmag_s.png'" onmouseout="this.src='../img/viewmag.png'"  style="cursor:hand" onclick="wopen('../com/ControleClientesEspeciais_lForm.do?select_action=&ped_nmro=<%= controle.getPed_nmro() %>','_blank',800,500)"/>
                                  <%
                                }
                                %>
                              </td>
                              <td class="reportColumn" style="text-align: center">
                                <html:hidden property="ped_boni" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                <%= controle.getPed_boni()!=null ? controle.getPed_boni() : "" %>
                              </td>
                              <td class="reportColumn" style="text-align: center">
                                <html:hidden property="ped_boni2" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                <%= controle.getPed_boni2()!=null ? controle.getPed_boni2() : "" %>
                              </td>
                              <td class="reportColumn" style="text-align: center">
                                <html:hidden property="ped_desc" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                <%= controle.getPed_desc()!=null ? controle.getPed_desc() : "" %>
                              </td>
                              <td class="reportColumn" style="text-align: center">
                                <html:hidden property="cnd_cdgo" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                <%= controle.getCnd_cdgo()!=null ? controle.getCnd_cdgo() : "" %>
                              </td>
                              <td class="reportColumn" style="text-align: center">
                                <html:hidden property="livro" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                <%= controle.getLivro()!=null ? controle.getLivro() : "" %>
                              </td>
                              <td class="reportColumn" style="text-align: center">
                                <html:hidden property="ped_nmro" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                <%= controle.getPed_invoice()!=null ? controle.getPed_invoice() : "" %>
                              </td>
                              <td class="reportColumn" style="text-align: center">
                                <html:hidden property="oc" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                <%= controle.getOc() != null ? controle.getOc() : "" %>
                              </td>
                              <td class="reportColumn" style="text-align: center">
                                <html:hidden property="modelos" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                <%= controle.getModelos() != null ? controle.getModelos().replace("-","<br>") : "" %>
                              </td>
                              <td class="reportColumn" style="text-align: left; min-width: 300px">
                                <html:hidden property="descricao_modelos" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                <%= controle.getDescricao_modelos() != null ? controle.getDescricao_modelos().replace("-","<br>") : "" %>
                              </td>
                              <td class="reportColumn" style="text-align: left">
                                <html:hidden property="descricao_embalagem" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                <%= controle.getDescricao_embalagem() != null ? controle.getDescricao_embalagem() : "" %>
                              </td>
                              <td class="reportColumn" style="width: 1%">
                                <%
                                if(somente_consulta) {
                                  %>
                                  <html:hidden property="obse_adicionais" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                  <%= controle.getObse_adicionais() != null ? controle.getObse_adicionais() : "" %>
                                  <%
                                } else {
                                  %>
                                  <%
                                  if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaObseAdicionais ){
                                    %>
                                    <html:text property="obse_adicionais" styleId="obse_adicionais" styleClass="disabled" tabindex="-1"  size="50" readonly="true" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                    <%
                                  } else {
                                    %>

                                    <%
                                    if(controle.getObse_adicionais()!=null && controle.getObse_adicionais().indexOf("!")!=-1) {
                                      %>
                                      <html:text property="obse_adicionais" styleId="obse_adicionais" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " style="background-color:red;color:white;font-weight:bold" styleClass="baseField" size="50" maxlength="400" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                      <%
                                    } else {
                                      %>
                                      <html:text property="obse_adicionais" styleId="obse_adicionais" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="50" maxlength="400" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                      <%
                                    }
                                    %>
                                    <%
                                  }
                                  %>
                                  <%
                                }
                                %>
                              </td>
                              <td class="reportColumn">
                                <%
                                if(somente_consulta) {
                                  %>
                                  <html:hidden property="etiquetas" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                  <%= controle.getEtiquetas() != null ? controle.getEtiquetas() : "" %>
                                  <%
                                } else {
                                  %>
                                  <%
                                  if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaEtiquetas || controle.getSituacao().indexOf("F")!=-1 || controle.getSituacao().indexOf("L")!=-1 || controle.getSituacao().indexOf("C")!=-1){
                                    %>
                                    <html:text property="etiquetas" styleId="etiquetas" styleClass="disabled" readonly="true" size="10" maxlength="200" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                    <%
                                  } else {
                                    %>
                                    <html:text property="etiquetas" styleId="etiquetas" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="10" maxlength="200" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                    <%
                                  }
                                  %>
                                  <%
                                }
                                %>
                              </td>
                              <%
                              if(somente_consulta) {
                                %>
                                <td class="reportColumn" style="text-align: center">
                                  <html:hidden property="dt_entrega_etiqueta" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                  <%= com.egen.util.text.FormatDate.format(controle.getDt_entrega_etiqueta(), "dd/MM/yyyy") %>
                                </td>
                                <%
                              } else {
                                %>
                                <%
                                if(controle.getDt_entrega_etiqueta()==null) {
                                  %>

                                  <td class="reportColumn" style="text-align: center">
                                    <%
                                    if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaDtEntregaEtiqueta || controle.getSituacao().indexOf("F")!=-1 || controle.getSituacao().indexOf("L")!=-1 || controle.getSituacao().indexOf("C")!=-1){
                                      %>
                                      <html:text property="dt_entrega_etiqueta" styleId="dt_entrega_etiqueta" styleClass="disabled" readonly="true" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                      <%
                                    } else {
                                      %>
                                      <html:text property="dt_entrega_etiqueta" styleId="dt_entrega_etiqueta" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                      <%
                                      if(res_Controle_clientes_especiais_vw.size()==1) {
                                        %>
                                        <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_entrega_etiqueta']); cal1.year_scroll = true; cal1.popup();">
                                          <%
                                        } else {
                                          %>
                                          <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_entrega_etiqueta'][<%= indexId %>]); cal1.year_scroll = true; cal1.popup();">
                                            <%
                                          }
                                          %>
                                          <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                                        </a>
                                        <%
                                      }
                                      %>
                                    </td>
                                    <%
                                  } else {
                                    %>
                                    <td class="reportColumn" style="text-align: center">
                                      <html:text property="dt_entrega_etiqueta" styleId="dt_entrega_etiqueta" styleClass="disabled" readonly="true" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                    </td>
                                    <%
                                  }
                                  %>

                                  <%
                                }
                                %>

                                <td class="reportColumn" style="text-align: center">
                                  <%
                                  if(somente_consulta) {
                                    %>
                                    <html:hidden property="dt_rec_etiqueta_filial" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                    <%= com.egen.util.text.FormatDate.format(controle.getDt_rec_etiqueta_filial(), "dd/MM/yyyy") %>
                                    <%
                                  } else {
                                    %>

                                    <%
                                    if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaDtRecEtiquetaFilial || controle.getSituacao().indexOf("F")!=-1 || controle.getSituacao().indexOf("L")!=-1 || controle.getSituacao().indexOf("C")!=-1){
                                      %>
                                      <html:text property="dt_rec_etiqueta_filial" styleId="dt_rec_etiqueta_filial" styleClass="disabled" readonly="true" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                      <%
                                    } else {
                                      %>
                                      <html:text property="dt_rec_etiqueta_filial" styleId="dt_rec_etiqueta_filial" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                      <%
                                      if(res_Controle_clientes_especiais_vw.size()==1) {
                                        %>
                                        <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_rec_etiqueta_filial']); cal1.year_scroll = true; cal1.popup();">
                                          <%
                                        } else {
                                          %>
                                          <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_rec_etiqueta_filial'][<%= indexId %>]); cal1.year_scroll = true; cal1.popup();">
                                            <%
                                          }
                                          %>
                                          <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                                        </a>
                                        <%
                                      }
                                      %>

                                      <%
                                    }
                                    %>
                                  </td>

                                  <td class="reportColumn" style="text-align: center">
                                    <%
                                    if(somente_consulta) {
                                      %>
                                      <html:hidden property="data_etiquetagem" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                      <%= com.egen.util.text.FormatDate.format(controle.getData_etiquetagem(), "dd/MM/yyyy") %>
                                      <%
                                    } else {
                                      %>

                                      <%
                                      if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaDtRecEtiquetaFilial || controle.getSituacao().indexOf("F")!=-1 || controle.getSituacao().indexOf("L")!=-1 || controle.getSituacao().indexOf("C")!=-1){
                                        %>
                                        <html:text property="data_etiquetagem" styleId="data_etiquetagem" styleClass="disabled" readonly="true" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                        <%
                                      } else {
                                        %>
                                        <html:text property="data_etiquetagem" styleId="data_etiquetagem" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                        <%
                                        if(res_Controle_clientes_especiais_vw.size()==1) {
                                          %>
                                          <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_etiquetagem']); cal1.year_scroll = true; cal1.popup();">
                                            <%
                                          } else {
                                            %>
                                            <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_etiquetagem'][<%= indexId %>]); cal1.year_scroll = true; cal1.popup();">
                                              <%
                                            }
                                            %>
                                            <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                                          </a>
                                          <%
                                        }
                                        %>

                                        <%
                                      }
                                      %>
                                    </td>

                                    <td class="reportColumn" style="text-align: center">
                                      <html:text property="certificado_origem" styleId="certificado_origem" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="10" maxlength="200" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                    </td>

                                    <%
                                    if(somente_consulta) {
                                      %>
                                      <td class="reportColumn" style="text-align: center">
                                        <html:hidden property="carimbo" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                        <%= controle.getCarimbo() != null ? controle.getCarimbo() : "" %>
                                      </td>
                                      <%
                                    } else {
                                      %>


                                      <%
                                      // if(controle.getCarimbo()==null) {
                                        if(true){
                                          %>
                                          <td class="reportColumn" style="text-align: center">
                                            <%
                                            if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaCarimbo || controle.getSituacao().indexOf("F")!=-1 || controle.getSituacao().indexOf("L")!=-1 || controle.getSituacao().indexOf("C")!=-1){
                                              %>
                                              <html:text property="carimbo" styleId="carimbo" styleClass="disabled" readonly="true" size="10" maxlength="200" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                              <%
                                            } else {
                                              %>
                                              <%
                                              if((controle.getCarimbo()==null && controle.getPossui_carimbo().equals("S"))){
                                                %>
                                                <img src="../img/aviso.gif" />
                                                <%
                                              } else {
                                                %>
                                                <img src="../img/aviso_white.gif"  />
                                                <%
                                              }
                                              %>
                                              <html:text property="carimbo" styleId="carimbo" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="10" maxlength="200" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                              <%
                                            }
                                            %>
                                            <%
                                          } else {
                                            %>
                                            <td class="reportColumn">
                                              <html:text property="carimbo" styleId="carimbo" styleClass="disabled" readonly="true" size="10" maxlength="200" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                              <%
                                            }
                                            %>
                                          </td>
                                          <%
                                        }
                                        %>

                                        <%
                                        if((controle.getCabide()+"").indexOf("!")!=-1){
                                          styleNormativa = "background-color:red;color:white;font-weight:bold";
                                        } else {
                                          styleNormativa = "";
                                        }
                                        %>
                                        <td class="reportColumn" style="text-align: center">
                                          <%
                                          if(somente_consulta) {
                                            %>
                                            <html:hidden property="cabide" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                            <%= controle.getCabide() != null ? controle.getCabide() : "" %>
                                            <%
                                          } else {
                                            %>
                                            <%
                                            if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaCabide ){
                                              %>
                                              <html:text property="cabide" styleId="cabide" style="<%= styleNormativa %>" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="200" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                              <%
                                            } else {
                                              %>
                                              <html:text property="cabide" styleId="cabide" style="<%= styleNormativa %>" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="40" maxlength="200" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                              <%
                                            }
                                            %>
                                            <%
                                          }
                                          %>
                                        </td>

                                        <td class="reportColumn" style="text-align: center">
                                          <html:hidden property="prs" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                          <%= controle.getPrs() != null ? com.egen.util.text.FormatNumber.format(controle.getPrs(), "#,##0.##") : "" %>
                                        </td>
                                        <td class="reportColumn" style="text-align: center">
                                          <html:hidden property="valor_pedido" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                          <%= com.egen.util.text.FormatNumber.format(controle.getValor_pedido(), "#,##0.00") %>
                                        </td>
                                        <td class="reportColumn" style="text-align: center">
                                          <html:hidden property="grades_corrugados" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                          <%= controle.getGrades_corrugados()!=null?controle.getGrades_corrugados():"" %>
                                        </td>
                                        <td class="reportColumn" style="text-align: center">
                                          <html:hidden property="min_fabr" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                          <%= controle.getMin_fabr()!=null?controle.getMin_fabr():"" %>
                                        </td>
                                        <td class="reportColumn" style="text-align: center">
                                          <html:hidden property="remessa" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                          <%= controle.getRemessa() != null ? controle.getRemessa() : "" %>
                                        </td>
                                        <%
                                        if((!controle.getFilial_prd().equals(controle.getFilial_local_estoque()))&& controle.getFilial_local_estoque()!=null) {
                                          %>
                                          <td class="reportColumn" style="text-align: center; color: red">
                                            <%
                                          } else {
                                            %>
                                            <td class="reportColumn" style="text-align: center">
                                              <%
                                            }
                                            %>
                                            <html:hidden property="filial_prd" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                            <%= controle.getFilial_prd() != null ? controle.getFilial_prd().replace("#","<br>") : "" %>
                                          </td>

                                          <%
                                          if((!controle.getFilial_prd().equals(controle.getFilial_local_estoque()))&& controle.getFilial_local_estoque()!=null) {
                                            %>
                                            <td class="reportColumn" style="text-align: center; color: red">
                                              <%
                                            } else {
                                              %>
                                              <td class="reportColumn" style="text-align: center">
                                                <%
                                              }
                                              %>
                                              <html:hidden property="les_codigo" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                              <%= controle.getLes_codigo() != null ? controle.getLes_codigo() : "" %>
                                            </td>

                                            <td class="reportColumn" style="text-align: center">
                                              <html:hidden property="tes_codigo" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                              <%= controle.getTes_codigo() != null ? controle.getTes_codigo() : "" %>
                                            </td>
                                            <td class="reportColumn" style="text-align: center">
                                              <%
                                              if(somente_consulta) {
                                                %>
                                                <html:hidden property="fil_filial_fat" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                <%= controle.getFil_filial_fat() != null ? controle.getFil_filial_fat() : "" %>
                                                <%
                                              } else {
                                                %>
                                                <%
                                                if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaFilFilialFat || controle.getSituacao().indexOf("F")!=-1 || controle.getSituacao().indexOf("L")!=-1 || controle.getSituacao().indexOf("C")!=-1){
                                                  %>
                                                  <html:text property="fil_filial_fat" styleId="fil_filial_fat" styleClass="disabled" readonly="true" size="4" maxlength="4" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%
                                                } else {
                                                  %>
                                                  <%
                                                  if((controle.getRef_cliente_por_pedido().equalsIgnoreCase("N")) && (!listaDesconsiderarBloqueioFilialFat.contains((controle.getCli_cdgo()+"")))) {
                                                    %>
                                                    <img style=cursor:pointer src=../img/ballhelp.gif border=0 onmouseout="this.src='../img/ballhelp.gif'" onmouseover="this.src='../img/ballhelp_c.gif'" onclick="javascript:window.open('../lov/HelpForm.jsp?help=Não existe o cadastro da filial ativo por pedido para o cliente <%= controle.getCli_cdgo() %> - <%= controle.getCli_rzao()%>','def','scrollbars,height=400,width=340,TOP=0,LEFT=0')">
                                                    <html:text property="fil_filial_fat" styleId="fil_filial_fat" styleClass="disabled" readonly="true" size="4" maxlength="4" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                    <%
                                                  } else {
                                                    %>
                                                    <html:text property="fil_filial_fat" styleId="fil_filial_fat" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="4" maxlength="4" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                    <%
                                                  }
                                                  %>
                                                  <%
                                                }
                                                %>
                                                <%
                                              }
                                              %>
                                            </td>


                                            <td class="reportColumn" style="text-align: center">
                                              <html:hidden property="dt_emiss" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                              <%= com.egen.util.text.FormatDate.format(controle.getDt_emiss(), "dd/MM/yyyy") %>
                                            </td>

                                            <td class="reportColumn" style="text-align: center">
                                              <html:hidden property="dt_digit" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                              <%= com.egen.util.text.FormatDate.format(controle.getDt_digit(), "dd/MM/yyyy") %>
                                            </td>

                                            <td class="reportColumn" style="text-align: center">
                                              <html:hidden property="dt_montagem" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                              <%= com.egen.util.text.FormatDate.format(controle.getDt_montagem(), "dd/MM/yyyy") %>
                                            </td>

                                            <td class="reportColumn" style="text-align: center">
                                              <html:hidden property="dt_corte" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                              <%= com.egen.util.text.FormatDate.format(controle.getDt_corte(), "dd/MM/yyyy") %>
                                            </td>

                                            <td class="reportColumn" style="text-align: center">
                                              <html:hidden property="dt_fatur" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                              <%= com.egen.util.text.FormatDate.format(controle.getDt_fatur(), "dd/MM/yyyy") %>
                                            </td>

                                            <html:hidden property="dt_fatur_filial" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                            <!--
                                              <td class="reportColumn" style="text-align: center"> <% if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaDtFaturFilial || controle.getSituacao().indexOf("F")!=-1 || controle.getSituacao().indexOf("L")!=-1 || controle.getSituacao().indexOf("C")!=-1){ %> <html:text property="dt_fatur_filial" styleId="dt_fatur_filial" styleClass="disabled" readonly="true" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/> <% } else { %> <html:text property="dt_fatur_filial" styleId="dt_fatur_filial" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/> <% if(res_Controle_clientes_especiais_vw.size()==1) { %> <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_fatur_filial']); cal1.year_scroll = true; cal1.popup();"> <% } else { %> <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_fatur_filial'][<%= indexId %>]); cal1.year_scroll = true; cal1.popup();"> <% } %> <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" /> </a> <% } %> </td>
                                            -->


                                            <td class="reportColumn" style="text-align: center">
                                              <html:hidden property="marca" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                              <%= controle.getMarca() %>
                                            </td>


                                            <td class="reportColumn" style="text-align: center">
                                              <%
                                              if(somente_consulta) {
                                                %>
                                                <html:hidden property="agendamento_cdgo" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                <%= controle.getAgendamento_cdgo() != null ? controle.getAgendamento_cdgo() : "" %>
                                                <%
                                              } else {
                                                %>
                                                <%
                                                if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaAgendamentoCdgo ){
                                                  %>
                                                  <html:text property="agendamento_cdgo" styleId="agendamento_cdgo" styleClass="disabled" readonly="true" size="20" maxlength="20" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%
                                                } else {
                                                  %>
                                                  <html:text property="agendamento_cdgo" styleId="agendamento_cdgo" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="20" maxlength="20" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%
                                                }
                                                %>
                                                <%
                                              }
                                              %>
                                            </td>


                                            <td class="reportColumn" style="text-align: center">
                                              <%
                                              if(somente_consulta) {
                                                %>
                                                <html:hidden property="data_efetiva" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                <%= com.egen.util.text.FormatDate.format(controle.getData_efetiva(), "dd/MM/yyyy") %>
                                                <%
                                              } else {
                                                %>
                                                <%
                                                if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || ((controle.getCli_cdgo()+"").equals("6743") && (controle.getEsc_seqn()+"").equals("75") && (controle.getSituacao().indexOf("F")!=-1 || controle.getSituacao().indexOf("L")!=-1 || controle.getSituacao().indexOf("C")!=-1)) || bloqueiaDataEfetiva || controle.getSituacao().indexOf("F")==0 || controle.getSituacao().indexOf("L")==0 || controle.getSituacao().indexOf("C")==0 || (controle.getPrioridade_embarque()!=null && controle.getPrioridade_embarque().equals("S")) ){
                                                  %>
                                                  <html:text property="data_efetiva" styleId="data_efetiva" styleClass="disabled" readonly="true" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%
                                                } else {
                                                  %>
                                                  <html:text property="data_efetiva" styleId="data_efetiva" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseFieldData" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%
                                                  if(res_Controle_clientes_especiais_vw.size()==1) {
                                                    %>
                                                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_efetiva']); cal1.year_scroll = true; cal1.popup();">
                                                      <%
                                                    } else {
                                                      %>
                                                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_efetiva'][<%= indexId %>]); cal1.year_scroll = true; cal1.popup();">
                                                        <%
                                                      }
                                                      %>
                                                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                                                    </a>
                                                    <%
                                                  }
                                                  %>
                                                  <%
                                                }
                                                %>
                                              </td>

                                              <html:hidden property="codigo_regional" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true" styleId="codigo_regional"/>
                                              <html:hidden property="rep_cdgo" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true" styleId="rep_cdgo"/>
                                              <td class="reportColumn">
                                                <html:text property="cli_cdgo" styleClass="myhidden" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true" styleId="cli_cdgo"/>
                                              </td>

                                              <html:hidden property="codigo_marca" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true" styleId="codigo_marca"/>
                                              <html:hidden property="ped_stat" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true" styleId="ped_stat"/>
                                              <html:hidden property="bloqueia_navegador" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true" styleId="bloqueia_navegador"/>

                                              <td class="reportColumn">
                                                <%
                                                if(somente_consulta) {
                                                  %>
                                                  <html:hidden property="hora" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= controle.getHora() != null ? controle.getHora() : "" %>
                                                  <%
                                                } else {
                                                  %>
                                                  <%
                                                  if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaHora ){
                                                    %>
                                                    <html:text property="hora" styleId="hora" styleClass="disabled" readonly="true" size="6" maxlength="20" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                    <%
                                                  } else {
                                                    %>
                                                    <html:text property="hora" styleId="hora" onchange="setarAlterado(this.name, 0, event); " styleClass="baseField" size="6" maxlength="20" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                    <%
                                                  }
                                                  %>
                                                  <%
                                                }
                                                %>
                                              </td>

                                              <td class="reportColumn">
                                                <%
                                                if(somente_consulta) {
                                                  %>
                                                  <html:hidden property="senha" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= controle.getSenha() != null ? controle.getSenha() : "" %>
                                                  <%
                                                } else {
                                                  %>
                                                  <%
                                                  if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaSenha ){
                                                    %>
                                                    <html:text property="senha" styleId="senha" styleClass="disabled" readonly="true" size="10" maxlength="20" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                    <%
                                                  } else {
                                                    %>
                                                    <html:text property="senha" styleId="senha" onchange="setarAlterado(this.name, 0, event); " styleClass="baseField" size="10" maxlength="20" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                    <%
                                                  }
                                                  %>
                                                  <%
                                                }
                                                %>
                                              </td>


                                              <%
                                              if(somente_consulta) {
                                                %>
                                                <td class="reportColumn">
                                                  <html:hidden property="portao" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= controle.getPortao() != null ? controle.getPortao() : "" %>
                                                </td>
                                                <td class="reportColumn">
                                                  <html:hidden property="cd_entrega" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= controle.getCd_entrega() != null ? controle.getCd_entrega() : "" %>
                                                </td>
                                                <%
                                              } else {
                                                %>

                                                <%
                                                if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaPortao){
                                                  %>
                                                  <td class="reportColumn">
                                                    <html:text property="portao" styleId="portao" styleClass="disabled" tabindex="-1" readonly="true" maxlength="60" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  </td>
                                                  <td class="reportColumn">
                                                    <html:text property="cd_entrega" styleId="cd_entrega" styleClass="disabled" tabindex="-1" readonly="true" maxlength="60" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  </td>
                                                  <%
                                                } else {
                                                  %>
                                                  <td class="reportColumn">
                                                    <html:text property="portao" styleId="portao" onchange="setarAlterado(this.name, 0, event); "styleClass="baseField" size="20" maxlength="60" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  </td>
                                                  <td class="reportColumn">
                                                    <html:text property="cd_entrega" styleId="cd_entrega" onchange="setarAlterado(this.name, 0, event); " styleClass="baseField" size="20" maxlength="60" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  </td>
                                                  <%
                                                }
                                                %>

                                                <%
                                              }
                                              %>

                                              <html:hidden property="rotulos" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                              <html:hidden property="ped_amostra" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                              <html:hidden property="dt_envio_amostras" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                              <!--
                                                <td class="reportColumn" style="text-align: center"> <% if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaRotulos || controle.getSituacao().indexOf("F")!=-1 || controle.getSituacao().indexOf("L")!=-1 || controle.getSituacao().indexOf("C")!=-1){ %> <html:text property="rotulos" styleId="rotulos" styleClass="disabled" readonly="true" size="10" maxlength="200" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/> <% } else { %> <html:text property="rotulos" styleId="rotulos" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="10" maxlength="200" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/> <% } %> </td> <td class="reportColumn" style="text-align: center"> <html:hidden property="ped_amostra" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/> <%= controle.getPed_amostra()!=null ? controle.getPed_amostra() : "" %> </td> <td class="reportColumn" style="text-align: center"> <% if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaDtEnvioAmostras || controle.getSituacao().indexOf("F")!=-1 || controle.getSituacao().indexOf("L")!=-1 || controle.getSituacao().indexOf("C")!=-1){ %> <html:text property="dt_envio_amostras" styleId="dt_envio_amostras" styleClass="disabled" readonly="true" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/> <% } else { %> <html:text property="dt_envio_amostras" styleId="dt_envio_amostras" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/> <% if(res_Controle_clientes_especiais_vw.size()==1) { %> <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_envio_amostras']); cal1.year_scroll = true; cal1.popup();"> <% } else { %> <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_envio_amostras'][<%= indexId %>]); cal1.year_scroll = true; cal1.popup();"> <% } %> <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" /> </a> <% } %> </td>
                                              -->

                                              <td class="reportColumn" style="text-align: center">
                                                <html:hidden property="dt_emissao" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                <%= com.egen.util.text.FormatDate.format(controle.getDt_emissao(), "dd/MM/yyyy HH:mm:ss") %>
                                              </td>
                                              <td class="reportColumn" style="text-align: center">
                                                <html:hidden property="filial" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                <%= controle.getFilial()!=null ? controle.getFilial() : "" %>
                                              </td>
                                              <td class="reportColumn" style="text-align: center">
                                                <html:hidden property="notafiscal" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                <%= controle.getNotafiscal()!=null ? controle.getNotafiscal() : "" %>
                                              </td>
                                              <td class="reportColumn" style="text-align: center">
                                                <html:hidden property="volumes" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                <%= controle.getVolumes()!=null ? controle.getVolumes() : "" %>
                                              </td>

                                              <%
                                              if(true) {
                                                %>
                                                <td class="reportColumn" style="text-align: center">
                                                  <%= controle.getNumero_romaneio() != null ? controle.getNumero_romaneio() : "" %>
                                                </td>
                                                <td class="reportColumn" style="text-align: center">
                                                  <%= controle.getData_finalizacao_romaneio() != null ? controle.getData_finalizacao_romaneio() : "" %>
                                                </td>

                                                <%
                                              }
                                              %>

                                              <td class="reportColumn" style="text-align: center">
                                                <%
                                                if(somente_consulta) {
                                                  %>
                                                  <html:hidden property="dt_inspecao" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= com.egen.util.text.FormatDate.format(controle.getDt_inspecao(), "dd/MM/yyyy") %>
                                                  <%
                                                } else {
                                                  %>
                                                  <%
                                                  if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaDtInspecao || controle.getSituacao().indexOf("F")!=-1 || controle.getSituacao().indexOf("L")!=-1 || controle.getSituacao().indexOf("C")!=-1){
                                                    %>
                                                    <html:text property="dt_inspecao" styleId="dt_inspecao" styleClass="disabled" readonly="true" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                    <%
                                                  } else {
                                                    %>
                                                    <html:text property="dt_inspecao" styleId="dt_inspecao" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                    <%
                                                    if(res_Controle_clientes_especiais_vw.size()==1) {
                                                      %>
                                                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_inspecao']); cal1.year_scroll = true; cal1.popup();">
                                                        <%
                                                      } else {
                                                        %>
                                                        <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_inspecao'][<%= indexId %>]); cal1.year_scroll = true; cal1.popup();">
                                                          <%
                                                        }
                                                        %>
                                                        <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                                                      </a>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                  }
                                                  %>
                                                </td>

                                                <td class="reportColumn" style="text-align: center">
                                                  <html:hidden property="data_entrega_cliente" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= com.egen.util.text.FormatDate.format(controle.getData_entrega_cliente(), "dd/MM/yyyy") %>
                                                </td>

                                                <html:hidden property="ped_amostra_brinde" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                <!--
                                                  <td class="reportColumn" style="text-align: center;"> <html:hidden property="ped_amostra_brinde" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/> <%= controle.getPed_amostra_brinde()!=null ? controle.getPed_amostra_brinde() : "" %> </td>
                                                -->

                                                <td class="reportColumn" style="text-align: center;">
                                                  <html:hidden property="ocorrencia" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= controle.getOcorrencia()!=null ? controle.getOcorrencia() : "" %>
                                                </td>
                                                <td class="reportColumn" style="text-align: center">
                                                  <%
                                                  if(somente_consulta) {
                                                    %>
                                                    <html:hidden property="encarte" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                    <%= controle.getEncarte() != null ? controle.getEncarte() : "" %>
                                                    <%
                                                  } else {
                                                    %>
                                                    <%
                                                    if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaEncarte  || controle.getSituacao().indexOf("F")!=-1 || controle.getSituacao().indexOf("L")!=-1 || controle.getSituacao().indexOf("C")!=-1 || (Integer.parseInt(controle.getSituacao().substring(1,2))>3)){
                                                      %>
                                                      <html:text property="encarte" styleId="encarte" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="400" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                      <%
                                                    } else {
                                                      %>
                                                      <html:text property="encarte" styleId="encarte" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="20" maxlength="4000" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                  }
                                                  %>
                                                </td>
                                                <td class="reportColumn" style="text-align: center">
                                                  <%
                                                  if(somente_consulta) {
                                                    %>
                                                    <html:hidden property="prioridade_embarque" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                    <%= controle.getPrioridade_embarque() != null ? controle.getPrioridade_embarque() : "" %>
                                                    <%
                                                  } else {
                                                    %>
                                                    <%
                                                    if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaPrioridadeEmbarque  || controle.getSituacao().indexOf("F")!=-1 || controle.getSituacao().indexOf("L")!=-1 || controle.getSituacao().indexOf("C")!=-1 || controle.getData_efetiva()!=null){
                                                      %>
                                                      <html:checkbox property="prioridade_embarque" styleId="prioridade_embarque" styleClass="baseField" disabled="true" value="true" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                      <%
                                                    } else {
                                                      %>
                                                      <html:checkbox property="prioridade_embarque" styleId="prioridade_embarque" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" value="true" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                  }
                                                  %>
                                                </td>
                                                <td class="reportColumn" style="text-align: center;">
                                                  <html:hidden property="atacado" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= controle.getAtacado()!=null ? controle.getAtacado() : "" %>
                                                </td>
                                                <td class="reportColumn" style="text-align: left">
                                                  <html:hidden property="grupo_economico" value="<%= controle.getGrupo_economico()!=null?(controle.getGrupo_economico() + " - " + controle.getGrupo_descricao()):""  %>" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%
                                                  if(!controle.getGrupo_economico().equals("9999999999")){
                                                    %>
                                                    <%= controle.getGrupo_economico()!=null?(controle.getGrupo_economico() + " - " + controle.getGrupo_descricao()):""  %>
                                                    <%
                                                  }
                                                  %>
                                                </td>
                                                <td class="reportColumn" style="text-align: center">
                                                  <html:hidden property="cli_cdgo" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= controle.getCli_cdgo() %>
                                                </td>
                                                <td class="reportColumn" style="text-align: center">
                                                  <html:hidden property="esc_seqn" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= controle.getEsc_seqn() %>
                                                </td>
                                                <td class="reportColumn" style="text-align: left">
                                                  <html:hidden property="cli_rzao" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= controle.getCli_rzao() %>
                                                </td>
                                                <td class="reportColumn" style="text-align: left">
                                                  <html:hidden property="cnpj" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= controle.getCnpj() %>
                                                </td>
                                                <td class="reportColumn" style="text-align: left">
                                                  <html:hidden property="cidade" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= controle.getCidade() %>
                                                </td>
                                                <td class="reportColumn" style="text-align: left">
                                                  <html:hidden property="loja" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= controle.getLoja()!=null?controle.getLoja():"" %>
                                                </td>
                                                <td class="reportColumn" style="text-align: left">
                                                  <html:hidden property="nro_normativa_cliente" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <html:hidden property="descricao_normativa_cliente" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= controle.getNro_normativa_cliente()!=null?controle.getNro_normativa_cliente():"" %>
                                                  -
                                                  <%= controle.getDescricao_normativa_cliente()!=null?controle.getDescricao_normativa_cliente():"" %>
                                                </td>
                                                <td class="reportColumn" style="text-align: left">
                                                  <html:hidden property="rep_cdgo" value="<%= controle.getRep_cdgo()!=null?(controle.getRep_cdgo() + " - " + controle.getRep_rzao()):""  %>" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= controle.getRep_cdgo()!=null?(controle.getRep_cdgo() + " - " + controle.getRep_rzao()):""  %>
                                                </td>
                                                <td class="reportColumn" style="text-align: left;width: 300px">
                                                  <html:hidden property="ped_obse" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= controle.getPed_obse()!=null?controle.getPed_obse():"" %>
                                                </td>
                                                <td class="reportColumn" style="text-align: left;width: 300px">
                                                  <html:hidden property="data_bloqueio" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= controle.getData_bloqueio()!=null?com.egen.util.text.FormatDate.format(controle.getData_bloqueio(), "dd/MM/yyyy"):"" %>
                                                </td>
                                                <td class="reportColumn" style="text-align: left;width: 300px">
                                                  <html:hidden property="data_prevista_desbloqueio" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= controle.getData_prevista_desbloqueio()!=null?com.egen.util.text.FormatDate.format(controle.getData_prevista_desbloqueio(), "dd/MM/yyyy"):"" %>
                                                </td>
                                                <td class="reportColumn" style="text-align: left;width: 300px">
                                                  <%
                                                  if(somente_consulta) {
                                                    %>
                                                    <html:hidden property="dt_solicitacao_alarme" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                    <%= com.egen.util.text.FormatDate.format(controle.getDt_solicitacao_alarme(), "dd/MM/yyyy") %>
                                                    <%
                                                  } else {
                                                    %>
                                                    <%
                                                    if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaEtiquetas || controle.getSituacao().indexOf("F")!=-1 || controle.getSituacao().indexOf("L")!=-1 || controle.getSituacao().indexOf("C")!=-1){
                                                      %>
                                                      <html:text property="dt_solicitacao_alarme" styleId="dt_solicitacao_alarme" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                      <%
                                                    } else {
                                                      %>
                                                      <html:text property="dt_solicitacao_alarme" styleId="dt_solicitacao_alarme" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_solicitacao_alarme'][<%= indexId %>]); cal1.year_scroll = true; cal1.popup();">
                                                        <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                                                      </a>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                  }
                                                  %>
                                                </td>
                                                <td class="reportColumn" style="text-align: left;width: 300px">
                                                  <%
                                                  if(somente_consulta) {
                                                    %>
                                                    <html:hidden property="dt_rec_alarme_pcp" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                    <%= com.egen.util.text.FormatDate.format(controle.getDt_rec_alarme_pcp(), "dd/MM/yyyy") %>
                                                    <%
                                                  } else {
                                                    %>
                                                    <%
                                                    if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaDtEntregaEtiqueta || controle.getSituacao().indexOf("F")!=-1 || controle.getSituacao().indexOf("L")!=-1 || controle.getSituacao().indexOf("C")!=-1){
                                                      %>
                                                      <html:text property="dt_rec_alarme_pcp" styleId="dt_rec_alarme_pcp" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                      <%
                                                    } else {
                                                      %>
                                                      <html:text property="dt_rec_alarme_pcp" styleId="dt_rec_alarme_pcp" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_rec_alarme_pcp'][<%= indexId %>]); cal1.year_scroll = true; cal1.popup();">
                                                        <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                                                      </a>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                  }
                                                  %>
                                                </td>
                                                <td class="reportColumn" style="text-align: left;width: 300px">
                                                  <%
                                                  if(somente_consulta) {
                                                    %>
                                                    <html:hidden property="dt_rec_alarme_filial" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                    <%= com.egen.util.text.FormatDate.format(controle.getDt_rec_alarme_filial(), "dd/MM/yyyy") %>
                                                    <%
                                                  } else {
                                                    %>
                                                    <%
                                                    if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaDtRecEtiquetaFilial || controle.getSituacao().indexOf("F")!=-1 || controle.getSituacao().indexOf("L")!=-1 || controle.getSituacao().indexOf("C")!=-1){
                                                      %>
                                                      <html:text property="dt_rec_alarme_filial" styleId="dt_rec_alarme_filial" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                      <%
                                                    } else {
                                                      %>
                                                      <html:text property="dt_rec_alarme_filial" styleId="dt_rec_alarme_filial" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_rec_alarme_filial'][<%= indexId %>]); cal1.year_scroll = true; cal1.popup();">
                                                        <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                                                      </a>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                  }
                                                  %>
                                                </td>

                                                <%
                                                if(bloqueiaNfeNumero){
                                                  %>
                                                  <html:hidden property="nfe_numero" styleId="nfe_numero" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%
                                                } else {
                                                  %>
                                                  <td class="reportColumn" style="text-align: left;">
                                                    <%
                                                    if(somente_consulta) {
                                                      %>
                                                      <html:hidden property="nfe_numero" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                      <%= controle.getNfe_numero() != null ? controle.getNfe_numero() : "" %>
                                                      <%
                                                    } else {
                                                      %>
                                                      <%
                                                      if(sessao.getEntidadeNegocio().equalsIgnoreCase("INDUSTRIAL")){
                                                        %>
                                                        <html:text property="nfe_numero" styleId="nfe_numero" styleClass="disabled" size="20" maxlength="60" tabindex="-1" readonly="true" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                        <%
                                                      } else {
                                                        %>
                                                        <html:text property="nfe_numero" styleId="nfe_numero" onchange="setarAlterado(this.name, 0, event); "styleClass="baseField" size="20" maxlength="60" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                        <%
                                                      }
                                                      %>
                                                      <%
                                                    }
                                                    %>
                                                  </td>
                                                  <%
                                                }
                                                %>

                                                <%
                                                if(bloqueiaNfeNumero){
                                                  %>
                                                  <html:hidden property="modelo_alarme" styleId="modelo_alarme" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%
                                                } else {
                                                  %>
                                                  <td class="reportColumn" style="text-align: left;">
                                                    <%
                                                    if(somente_consulta) {
                                                      %>
                                                      <html:hidden property="modelo_alarme" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                      <%= controle.getModelo_alarme() != null ? controle.getModelo_alarme() : "" %>
                                                      <%
                                                    } else {
                                                      %>
                                                      <%
                                                      if(sessao.getEntidadeNegocio().equalsIgnoreCase("INDUSTRIAL")){
                                                        %>
                                                        <html:text property="modelo_alarme" styleId="modelo_alarme" styleClass="disabled" size="20" maxlength="60" tabindex="-1" readonly="true" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                        <%
                                                      } else {
                                                        %>
                                                        <html:text property="modelo_alarme" styleId="modelo_alarme" onchange="setarAlterado(this.name, 0, event); "styleClass="baseField" size="20" maxlength="200" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                        <%
                                                      }
                                                      %>
                                                      <%
                                                    }
                                                    %>
                                                  </td>
                                                  <%
                                                }
                                                %>
                                                <td class="reportColumn" style="text-align: center">
                                                  <html:hidden property="distribuicao" value="<%= controle.getDistribuicao() %>" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= controle.getDistribuicao() %>
                                                </td>
                                                <td class="reportColumn" style="text-align: left">
                                                  <html:hidden property="tra_cdgo" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <html:hidden property="tra_rzao" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                  <%= controle.getTra_cdgo() %>
                                                  -
                                                  <%= controle.getTra_rzao() %>
                                                </td>
                                                <td class="reportColumn" style="text-align: center">
                                                  <html:checkbox property="gerar_requisicao" styleId="gerar_requisicao" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" value="S" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                </td>
                                              </tr>
                                              <%
                                            } else {
                                              %>

                                              <%
                                              if(session.getAttribute("subtotal_grupo_economico")!=null) {
                                                %>

                                                <%
                                                if((!grupoEconomicoAtual.equals(grupoEconomicoAnterior+"")) && grupoEconomicoAnterior != null){
                                                  %>
                                                  <tr>
                                                    <td class="reportColumn">
                                                    </td>

                                                    <%
                                                    if(session.getAttribute("cb_regional")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>

                                                    <%
                                                    if(session.getAttribute("cb_situacao")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_tipo_pedido")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_especie")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>

                                                    <%
                                                    if(session.getAttribute("cb_pedido")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <td class="reportColumn"/>
                                                      <td class="reportColumn"/>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_oc")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_linha")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_obs")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_etiquetas")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_dt_entrega_etiqueta")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_dt_rec_etiqueta_filial")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_data_etiquetagem")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_certificado_origem")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_carimbo")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_cabide")!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: center; font-weight: bold; color: red">
                                                        Total
                                                        <%= descricaoGrupoEconomicoAnterior %>
                                                      </td>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_pares")!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: center; font-weight: bold; color: red">
                                                        <%= com.egen.util.text.FormatNumber.format(pares, "#,##0.##") %>
                                                      </td>
                                                      <%
                                                    }
                                                    %>
                                                    <td class="reportColumn" style="text-align: center"/>
                                                    <%
                                                    if(session.getAttribute("cb_rem")!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: center"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_fl_prod")!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: center"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_fl_fat")!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: center"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_emiss")!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: center"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_digit")!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: center"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_dt_montagem")!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: center"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_dt_corte")!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: center"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_fat_cli")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_fat_br")!=null) {
                                                      %>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_marca")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_agenda")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_dt_efetiva")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_hora")!=null) {
                                                      %>
                                                      <td>
                                                      </td>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_senha")!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: center"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_portao_entrega")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_cd_entrega")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_rotulos")!=null) {
                                                      %>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_ped_amostra")!=null) {
                                                      %>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_dt_envio")!=null) {
                                                      %>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_emissao")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_filial")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_nf")!=null) {
                                                      %>
                                                      <td class="reportColumn"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_volumes")!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: center"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_dt_inspecao")!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: center"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_dt_entrega")!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: center"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_amostra_brinde")!=null) {
                                                      %>
                                                      <%
                                                    }
                                                    %>
                                                    <td class="reportColumn" style="text-align: center"/>
                                                    <%
                                                    if(session.getAttribute("cb_encarte")!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: center"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_prioridade_embarque")!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: center"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_atacado")!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: center"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_grupo_economico")!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: left"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(session.getAttribute("cb_cliente")!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: center"/>
                                                      <td class="reportColumn" style="text-align: center/">
                                                        <td class="reportColumn" style="text-align: center"/>
                                                        <%
                                                      }
                                                      %>
                                                      <%
                                                      if(session.getAttribute("cb_representante")!=null) {
                                                        %>
                                                        <td class="reportColumn" style="text-align: left"/>
                                                        <%
                                                      }
                                                      %>
                                                      <%
                                                      if(session.getAttribute("cb_pedido")!=null) {
                                                        %>
                                                        <td class="reportColumn" style="text-align: left"/>
                                                        <%
                                                      }
                                                      %>
                                                    </tr>
                                                    <%
                                                    pares = 0;
                                                  }
                                                  %>

                                                  <%
                                                  grupoEconomicoAnterior  = grupoEconomicoAtual;
                                                  grupoEconomicoAtual = controle.getGrupo_economico();
                                                }
                                                pares += controle.getPrs();
                                                paresTotal += controle.getPrs();
                                                %>
                                                <tr class="trGridField">

                                                  <%
                                                  if(session.getAttribute("cb_bloqueio_49")!=null) {
                                                    %>
                                                    <td class="reportColumn" style="text-align: center">
                                                      <%= controle.getBloqueio_49() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>
                                                  <%
                                                  if(session.getAttribute("preco_pdv")!=null) {
                                                    %>
                                                    <td class="reportColumn" style="text-align: center">
                                                      <%= controle.getPreco_pdv() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>
                                                  <%
                                                  if(session.getAttribute("cb_bloqueio_uf")!=null) {
                                                    %>
                                                    <td class="reportColumn" style="text-align: center">
                                                      <%= controle.getLiberado_faturar().equals("0") ? "S" : "N" %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>
                                                  <%
                                                  if(session.getAttribute("cb_alerta_etiqueta")!=null) {
                                                    %>
                                                    <td class="reportColumn" style="text-align: center">
                                                      <%= controle.getAlerta() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>
                                                  <%
                                                  if(session.getAttribute("cb_bloqueado_credito")!=null) {
                                                    %>
                                                    <td class="reportColumn" style="text-align: center">
                                                      <%= controle.getBloqueado_credito() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>


                                                  <td class="reportColumn" style="text-align: center; width: 1%">
                                                    <%= controle.getBloqueio_oc().equals("red.gif")?"S":"N" %>
                                                  </td>
                                                  <td class="reportColumn" style="text-align: center; width: 1%">
                                                    <%= controle.getBloqueio_distribuicao().equals("red.gif")?"S":"N" %>
                                                  </td>
                                                  <td class="reportColumn" style="text-align: center; width: 1%">
                                                    <%= controle.getBloqueio_cliente().equals("I")?"S":"N" %>
                                                  </td>
                                                  <td class="reportColumn" style="text-align: center; width: 1%">
                                                    <%= controle.getBloqueio_sku().equals("red.gif")?"S":"N" %>
                                                  </td>
                                                  <td class="reportColumn" style="text-align: center; width: 1%">
                                                    <%= controle.getBloqueio_suframa().equals("dotRed")?"S":"N" %>
                                                  </td>
                                                  <td class="reportColumn" style="text-align: center; width: 1%">
                                                    <%= controle.getBloqueio_antecipacao().equals("dotRed")?"S":"N" %>
                                                  </td>




                                                  <%
                                                  if(session.getAttribute("cb_regional")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getCodigo_regional() %>
                                                      -
                                                      <%= controle.getNome_regional() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>
                                                  <%
                                                  if(session.getAttribute("cb_situacao")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getSituacao() %>
                                                      -
                                                      <%= controle.getDescricao_situacao() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_tipo_pedido")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getPed_tipo() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>
                                                  <%
                                                  if(session.getAttribute("cb_especie")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getPed_especie_pedido() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>
                                                  <%
                                                  if(session.getAttribute("cb_pedido")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getPed_nmro() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_desc_com")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getPed_boni()!=null ? controle.getPed_boni() : "" %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_desc_prom")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getPed_boni2()!=null ? controle.getPed_boni2() : "" %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_desc_pont")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getPed_desc()!=null ? controle.getPed_desc() : "" %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_cnd_cdgo")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getCnd_cdgo()!=null ? controle.getCnd_cdgo() : "" %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_livro")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getLivro()!=null ? controle.getLivro() : "" %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_invoice")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getPed_invoice()!=null ? controle.getPed_invoice() : "" %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_oc")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getOc()==null?"":controle.getOc() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_linha")!=null) {
                                                    %>
                                                    <td class="text">
                                                      <%= controle.getModelos()==null?"":controle.getModelos() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_descricao_item")!=null) {
                                                    %>
                                                    <td class="text">
                                                      <%= controle.getDescricao_modelos()==null?"":controle.getDescricao_modelos() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_descricao_embalagem")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getDescricao_embalagem()==null?"":controle.getDescricao_embalagem() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_obs")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getObse_adicionais()==null?"":controle.getObse_adicionais() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_etiquetas")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getEtiquetas()==null?"":controle.getEtiquetas() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_dt_entrega_etiqueta")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getDt_entrega_etiqueta()==null?"":controle.getDt_entrega_etiqueta() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_dt_rec_etiqueta_filial")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getDt_rec_etiqueta_filial()==null?"":controle.getDt_rec_etiqueta_filial() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_data_etiquetagem")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getData_etiquetagem()==null?"":(com.egen.util.text.FormatDate.format(controle.getData_etiquetagem(), "dd/MM/yyyy")) %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>


                                                  <%
                                                  if(session.getAttribute("cb_certificado_origem")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getCertificado_origem()==null?"":controle.getCertificado_origem() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_carimbo")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getCarimbo()==null?"":controle.getCarimbo() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>


                                                  <%
                                                  if(session.getAttribute("cb_cabide")!=null) {
                                                    %>
                                                    <td class="reportColumn">
                                                      <%= controle.getCabide()==null?"":controle.getCabide() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_pares")!=null) {
                                                    %>
                                                    <td class="reportColumn" style="text-align: center">
                                                      <%= controle.getPrs()==null?"":controle.getPrs() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_valor")!=null) {
                                                    %>
                                                    <td class="reportColumn" style="text-align: center">
                                                      <%= com.egen.util.text.FormatNumber.format(controle.getValor_pedido(), "#,##0.00") %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_grade_corrugado")!=null) {
                                                    %>
                                                    <td class="reportColumn" style="text-align: center">
                                                      <%= controle.getGrades_corrugados()==null?"":controle.getGrades_corrugados() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_mini_fabrica")!=null) {
                                                    %>
                                                    <td class="reportColumn" style="text-align: center">
                                                      <%= controle.getMin_fabr()==null?"":controle.getMin_fabr() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>


                                                  <%
                                                  if(session.getAttribute("cb_rem")!=null) {
                                                    %>
                                                    <td class="reportColumn" style="text-align: center">
                                                      <%= controle.getRemessa()==null?"":controle.getRemessa() %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(session.getAttribute("cb_fl_prod")!=null) {
                                                    %>
                                                    <%
                                                    if((!controle.getFilial_prd().equals(controle.getFilial_local_estoque()))&& controle.getFilial_local_estoque()!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: center; color: red">
                                                        <%
                                                      } else {
                                                        %>
                                                        <td class="reportColumn" style="text-align: center">
                                                          <%
                                                        }
                                                        %>
                                                        <%= controle.getFilial_prd()==null?"":controle.getFilial_prd().replace("#","<br>") %>
                                                      </td>
                                                      <%
                                                    }
                                                    %>

                                                    <%
                                                    if((!controle.getFilial_prd().equals(controle.getFilial_local_estoque()))&& controle.getFilial_local_estoque()!=null) {
                                                      %>
                                                      <td class="reportColumn" style="text-align: center; color: red">
                                                        <%
                                                      } else {
                                                        %>
                                                        <td class="reportColumn" style="text-align: center">
                                                          <%
                                                        }
                                                        %>
                                                        <html:hidden property="les_codigo" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                        <%= controle.getLes_codigo() != null ? controle.getLes_codigo() : "" %>
                                                      </td>

                                                      <%
                                                      if(session.getAttribute("cb_tipo_estoque")!=null) {
                                                        %>
                                                        <td class="reportColumn" style="text-align: center">
                                                          <html:hidden property="tes_codigo" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                          <%= controle.getTes_codigo() != null ? controle.getTes_codigo() : "" %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_fl_fat")!=null) {
                                                        %>
                                                        <td class="tdGridField">
                                                          <%= controle.getFil_filial_fat()==null?"":controle.getFil_filial_fat() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_emiss")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getDt_emiss()==null?"":controle.getDt_emiss() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>
                                                      <%
                                                      if(session.getAttribute("cb_digit")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getDt_digit()==null?"":controle.getDt_digit() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_dt_montagem")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getDt_montagem()==null?"":controle.getDt_montagem() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_dt_corte")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getDt_corte()==null?"":controle.getDt_corte() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_fat_cli")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getDt_fatur()==null?"":controle.getDt_fatur() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_marca")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getMarca()==null?"":controle.getMarca() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_agenda")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getAgendamento_cdgo()==null?"":controle.getAgendamento_cdgo() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_dt_efetiva")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getData_efetiva()==null?"":controle.getData_efetiva() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_hora")!=null) {
                                                        %>
                                                        <td>
                                                        </td>
                                                        <td class="reportColumn">
                                                          <%= controle.getHora()==null?"":controle.getHora() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_senha")!=null) {
                                                        %>
                                                        <td class="text">
                                                          <%= controle.getSenha()==null?"":controle.getSenha() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_portao_entrega")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getPortao()==null?"":controle.getPortao() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_cd_entrega")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getCd_entrega()==null?"":controle.getCd_entrega() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>




                                                      <%
                                                      if(session.getAttribute("cb_emissao")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= com.egen.util.text.FormatDate.format(controle.getDt_emissao(), "dd/MM/yyyy HH:mm:ss") %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_filial")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getFilial()==null?"":controle.getFilial() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>


                                                      <%
                                                      if(session.getAttribute("cb_nf")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getNotafiscal()==null?"":controle.getNotafiscal() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_volumes")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getVolumes()==null?"":controle.getVolumes() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_romaneio")!=null) {
                                                        %>
                                                        <td class="reportColumn" style="text-align: center">
                                                          <%= controle.getNumero_romaneio() != null ? controle.getNumero_romaneio() : "" %>
                                                        </td>
                                                        <td class="reportColumn" style="text-align: center">
                                                          <%= controle.getData_finalizacao_romaneio() != null ? controle.getData_finalizacao_romaneio() : "" %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_dt_inspecao")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= com.egen.util.text.FormatDate.format(controle.getDt_inspecao(), "dd/MM/yyyy") %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_dt_entrega")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= com.egen.util.text.FormatDate.format(controle.getData_entrega_cliente(), "dd/MM/yyyy") %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_dt_ultima_ocorrencia")!=null) {
                                                        %>
                                                        <td class="reportColumn" style="text-align: center;">
                                                          <%= controle.getOcorrencia()!=null ? controle.getOcorrencia() : "" %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_encarte")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getEncarte()!=null ? controle.getEncarte() : "" %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>


                                                      <%
                                                      if(session.getAttribute("cb_prioridade_embarque")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getPrioridade_embarque()!=null ? controle.getPrioridade_embarque() : "" %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>


                                                      <%
                                                      if(session.getAttribute("cb_atacado")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getAtacado()!=null ? controle.getAtacado() : "" %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>


                                                      <%
                                                      if(session.getAttribute("cb_grupo_economico")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%
                                                          if(!controle.getGrupo_economico().equals("9999999999")){
                                                            %>
                                                            <%= controle.getGrupo_economico() %>
                                                            -
                                                            <%= controle.getGrupo_descricao() %>
                                                            <%
                                                          }
                                                          %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>


                                                      <%
                                                      if(session.getAttribute("cb_cliente")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getCli_cdgo() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_seq")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getEsc_seqn() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_razao_social")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getCli_rzao() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_cnpj")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getCnpj() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_cidade")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getCidade() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_loja")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getLoja()!=null?controle.getLoja():"" %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_normativa_cliente")!=null) {
                                                        %>
                                                        <td>
                                                          <%= controle.getNro_normativa_cliente()!=null?controle.getNro_normativa_cliente():"" %>
                                                          -
                                                          <%= controle.getDescricao_normativa_cliente()!=null?controle.getDescricao_normativa_cliente():"" %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_representante")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getRep_cdgo() + "-" + controle.getRep_rzao() %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_obs_pedido")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getPed_obse()!=null?controle.getPed_obse():"" %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_data_bloqueio")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getData_bloqueio()!=null?com.egen.util.text.FormatDate.format(controle.getData_bloqueio(), "dd/MM/yyyy"):"" %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_data_prevista_desbloqueio")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getData_prevista_desbloqueio()!=null?com.egen.util.text.FormatDate.format(controle.getData_prevista_desbloqueio(), "dd/MM/yyyy"):"" %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_dt_solicitacao_alarme")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getDt_solicitacao_alarme()!=null?com.egen.util.text.FormatDate.format(controle.getDt_solicitacao_alarme(), "dd/MM/yyyy"):"" %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_dt_recebimento_alarme")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getDt_rec_alarme_pcp()!=null?com.egen.util.text.FormatDate.format(controle.getDt_rec_alarme_pcp(), "dd/MM/yyyy"):"" %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(session.getAttribute("cb_dt_recebimento_alarme_filial")!=null) {
                                                        %>
                                                        <td class="reportColumn">
                                                          <%= controle.getDt_rec_alarme_filial()!=null?com.egen.util.text.FormatDate.format(controle.getDt_rec_alarme_filial(), "dd/MM/yyyy"):"" %>
                                                        </td>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(!bloqueiaNfeNumero){
                                                        %>
                                                        <%
                                                        if(session.getAttribute("cb_nota_fiscal_alarme")!=null) {
                                                          %>
                                                          <td class="reportColumn">
                                                            <%= controle.getNfe_numero()!=null?controle.getNfe_numero():"" %>
                                                          </td>
                                                          <%
                                                        }
                                                        %>
                                                        <%
                                                      }
                                                      %>

                                                      <%
                                                      if(true) {
                                                        // if(session.getAttribute("cb_distribuicao")!=null) {
                                                          %>
                                                          <td class="reportColumn" style="text-align: center">
                                                            <html:hidden property="modelo_alarme" value="<%= controle.getModelo_alarme() %>" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                            <%= controle.getModelo_alarme() %>
                                                          </td>
                                                          <%
                                                        }
                                                        %>

                                                        <%
                                                        if(session.getAttribute("cb_distribuicao")!=null) {
                                                          %>
                                                          <td class="reportColumn" style="text-align: center">
                                                            <html:hidden property="distribuicao" value="<%= controle.getDistribuicao() %>" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                                            <%= controle.getDistribuicao() %>
                                                          </td>
                                                          <%
                                                        }
                                                        %>

                                                        <%
                                                        if(session.getAttribute("cb_tra_cdgo")!=null) {
                                                          %>
                                                          <td class="reportColumn" style="text-align: center">
                                                            <%= controle.getTra_cdgo() %>
                                                            -
                                                            <%= controle.getTra_rzao() %>
                                                          </td>
                                                          <%
                                                        }
                                                        %>

                                                        <%
                                                        if(session.getAttribute("cb_gerar_requisicao")!=null) {
                                                          %>
                                                          <td class="reportColumn" style="text-align: center">
                                                            <%= controle.getGerar_requisicao() %>
                                                          </td>
                                                          <%
                                                        }
                                                        %>

                                                      </tr>





                                                      <%
                                                      if((!grupoEconomicoAtual.equals(grupoEconomicoAnterior+"")) && grupoEconomicoAnterior != null){
                                                        %>


                                                        <%
                                                        if(session.getAttribute("subtotal_grupo_economico")!=null) {
                                                          %>

                                                          <tr class="trGridField">

                                                            <td class="reportColumn">
                                                            </td>

                                                            <%
                                                            if(session.getAttribute("cb_regional")!=null) {
                                                              %>
                                                              <td class="reportColumn">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_situacao")!=null) {
                                                              %>
                                                              <td class="reportColumn" >
                                                              </td>
                                                              <%
                                                            }
                                                            %>


                                                            <%
                                                            if(session.getAttribute("cb_tipo_pedido")!=null) {
                                                              %>
                                                              <td class="reportColumn" >
                                                              </td>

                                                              <td class="reportColumn" >
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_pedido")!=null) {
                                                              %>
                                                              <td class="reportColumn">
                                                              </td>

                                                              <td class="reportColumn">
                                                              </td>

                                                              <td class="reportColumn">
                                                              </td>

                                                              <td class="reportColumn">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_oc")!=null) {
                                                              %>
                                                              <td class="reportColumn">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_linha")!=null) {
                                                              %>
                                                              <td class="reportColumn">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_obs")!=null) {
                                                              %>
                                                              <td class="reportColumn">
                                                              </td>
                                                              <%
                                                            }
                                                            %>


                                                            <%
                                                            if(session.getAttribute("cb_etiquetas")!=null) {
                                                              %>
                                                              <td class="reportColumn">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_dt_entrega_etiqueta")!=null) {
                                                              %>
                                                              <td class="reportColumn">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_dt_rec_etiqueta_filial")!=null) {
                                                              %>
                                                              <td class="reportColumn">

                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_certificado_origem")!=null) {
                                                              %>
                                                              <td class="reportColumn">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_carimbo")!=null) {
                                                              %>
                                                              <td class="reportColumn">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_cabide")!=null) {
                                                              %>
                                                              <td class="reportColumn">

                                                              </td>
                                                              <%
                                                            }
                                                            %>


                                                            <%
                                                            if(session.getAttribute("cb_pares")!=null) {
                                                              %>
                                                              <td class="reportColumn" style="text-align: center; font-weight: bold; color: red">
                                                                <%= com.egen.util.text.FormatNumber.format(pares, "#,##0.##") %>
                                                              </td>
                                                              <%
                                                            }
                                                            %>
                                                            <td class="reportColumn" style="text-align: center">
                                                            </td>

                                                            <%
                                                            if(session.getAttribute("cb_rem")!=null) {
                                                              %>
                                                              <td class="reportColumn" style="text-align: center">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_fl_prod")!=null) {
                                                              %>
                                                              <td class="reportColumn" style="text-align: center">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_fl_fat")!=null) {
                                                              %>
                                                              <td class="reportColumn" style="text-align: center">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_digit")!=null) {
                                                              %>
                                                              <td class="reportColumn" style="text-align: center">
                                                              </td>
                                                              <td class="reportColumn" style="text-align: center">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_dt_montagem")!=null) {
                                                              %>
                                                              <td class="reportColumn" style="text-align: center">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_dt_corte")!=null) {
                                                              %>
                                                              <td class="reportColumn" style="text-align: center">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_fat_cli")!=null) {
                                                              %>
                                                              <td class="reportColumn">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_fat_br")!=null) {
                                                              %>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_marca")!=null) {
                                                              %>
                                                              <td class="reportColumn">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_agenda")!=null) {
                                                              %>
                                                              <td class="reportColumn">
                                                              </td>
                                                              <%
                                                            }
                                                            %>


                                                            <%
                                                            if(session.getAttribute("cb_dt_efetiva")!=null) {
                                                              %>
                                                              <td class="reportColumn">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_hora")!=null) {
                                                              %>
                                                              <td>
                                                              </td>
                                                              <td class="reportColumn">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_senha")!=null) {
                                                              %>
                                                              <td class="reportColumn" style="text-align: center">
                                                              </td>
                                                              <%
                                                            }
                                                            %>


                                                            <%
                                                            if(session.getAttribute("cb_portao_entrega")!=null) {
                                                              %>
                                                              <td class="reportColumn">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_cd_entrega")!=null) {
                                                              %>
                                                              <td class="reportColumn">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_rotulos")!=null) {
                                                              %>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_ped_amostra")!=null) {
                                                              %>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_dt_envio")!=null) {
                                                              %>
                                                              <%
                                                            }
                                                            %>


                                                            <%
                                                            if(session.getAttribute("cb_emissao")!=null) {
                                                              %>
                                                              <td class="reportColumn">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_filial")!=null) {
                                                              %>
                                                              <td class="reportColumn">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_nf")!=null) {
                                                              %>
                                                              <td class="reportColumn">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_volumes")!=null) {
                                                              %>
                                                              <td class="reportColumn" style="text-align: center;">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_dt_inspecao")!=null) {
                                                              %>
                                                              <td class="reportColumn" style="text-align: center;">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_dt_entrega")!=null) {
                                                              %>
                                                              <td class="reportColumn" style="text-align: center;">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_amostra_brinde")!=null) {
                                                              %>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_encarte")!=null) {
                                                              %>
                                                              <td class="reportColumn" style="text-align: center;">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_prioridade_embarque")!=null) {
                                                              %>
                                                              <td class="reportColumn" style="text-align: center;">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_atacado")!=null) {
                                                              %>
                                                              <td class="reportColumn" style="text-align: center;">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_grupo_economico")!=null) {
                                                              %>
                                                              <td class="reportColumn" style="text-align: left;">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_cliente")!=null) {
                                                              %>
                                                              <td class="reportColumn" style="text-align: center;">
                                                              </td>
                                                              <td class="reportColumn" style="text-align: center;">
                                                              </td>
                                                              <td class="reportColumn" style="text-align: center;">
                                                              </td>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_representante")!=null) {
                                                              %>
                                                              <td class="reportColumn" style="text-align: left"/>
                                                              <%
                                                            }
                                                            %>

                                                            <%
                                                            if(session.getAttribute("cb_pedido")!=null) {
                                                              %>
                                                              <td class="reportColumn" style="text-align: left"/>
                                                              <%
                                                            }
                                                            %>
                                                          </tr>

                                                          <%
                                                          grupoEconomicoAnterior = null;
                                                        }
                                                        %>
                                                        <%
                                                      }
                                                      %>
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    i++;
                                                    %>

                                                  </logic:iterate>

                                                  <%
                                                  if(session.getAttribute("subtotal_grupo_economico")!=null) {
                                                    %>
                                                    <%
                                                    if(!(request.getParameter("excel")+"").equals("true")){
                                                      %>
                                                      <tr>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn" style="text-align: center; font-weight: bold; color: red">
                                                          Total
                                                          <%= descricaoGrupoEconomicoAtual %>
                                                        </td>

                                                        <td class="reportColumn" style="text-align: center; font-weight: bold; color: red">
                                                          <%= com.egen.util.text.FormatNumber.format(pares, "#,##0.##") %>
                                                        </td>

                                                        <td class="reportColumn" style="text-align: center">

                                                        </td>
                                                        <td class="reportColumn" style="text-align: center"/>
                                                        <td class="reportColumn" style="text-align: center"/>
                                                        <td class="reportColumn" style="text-align: center"/>
                                                        <td class="reportColumn" style="text-align: center"/>
                                                        <td class="reportColumn" style="text-align: center"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td>
                                                        </td>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn" style="text-align: center"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn"/>
                                                        <td class="reportColumn" style="text-align: center/">
                                                          <td class="reportColumn" style="text-align: center/">
                                                            <td class="reportColumn" style="text-align: center/">
                                                              <td class="reportColumn" style="text-align: center/">
                                                                <td class="reportColumn" style="text-align: center/">
                                                                  <td class="reportColumn" style="text-align: center"/>

                                                                  <td class="reportColumn" style="text-align: left;">
                                                                  </td>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <td class="reportColumn" style="text-align: left"/>
                                                                  <td class="reportColumn" style="text-align: left; width: 300px"/>
                                                                </tr>

                                                                <tr>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn" style="text-align: center; font-weight: bold; color: red">
                                                                    Total Geral
                                                                  </td>

                                                                  <td class="reportColumn" style="text-align: center; font-weight: bold; color: red">
                                                                    <%= com.egen.util.text.FormatNumber.format(paresTotal, "#,##0.##") %>
                                                                  </td>

                                                                  <td class="reportColumn" style="text-align: center">

                                                                  </td>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td>
                                                                  </td>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn"/>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <td class="reportColumn" style="text-align: left"/>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <td class="reportColumn" style="text-align: left"/>
                                                                  <td class="reportColumn" style="text-align: left; width: 300px"/>
                                                                </tr>
                                                                <%
                                                              } else {
                                                                %>
                                                                <tr class="trGridField">
                                                                  <td class="reportColumn"/>
                                                                  <%
                                                                  if(session.getAttribute("cb_regional")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_situacao")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_tipo_pedido")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_pedido")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <td class="reportColumn"/>
                                                                    <td class="reportColumn"/>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_oc")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_linha")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_obs")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_etiquetas")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_dt_entrega_etiqueta")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_dt_rec_etiqueta_filial")!=null) {
                                                                    %>
                                                                    <td class="reportColumn">

                                                                    </td>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_certificado_origem")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_carimbo")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_cabide")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center; font-weight: bold; color: red">
                                                                      Total3
                                                                      <%= descricaoGrupoEconomicoAtual %>
                                                                    </td>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_pares")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center; font-weight: bold; color: red">
                                                                      <%= com.egen.util.text.FormatNumber.format(pares, "#,##0.##") %>
                                                                    </td>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <%
                                                                  if(session.getAttribute("cb_rem")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_fl_prod")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_fl_fat")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_digit")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_dt_montagem")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_dt_corte")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_fat_cli")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_fat_br")!=null) {
                                                                    %>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_marca")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_agenda")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_dt_efetiva")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_hora")!=null) {
                                                                    %>
                                                                    <td>
                                                                    </td>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_senha")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_portao_entrega")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_cd_entrega")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_rotulos")!=null) {
                                                                    %>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_ped_amostra")!=null) {
                                                                    %>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_dt_envio")!=null) {
                                                                    %>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_emissao")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_filial")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_nf")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_volumes")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_dt_inspecao")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_dt_entrega")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_amostra_brinde")!=null) {
                                                                    %>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <%
                                                                  if(session.getAttribute("cb_encarte")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_prioridade_embarque")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_atacado")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_grupo_economico")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: left"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_cliente")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_representante")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: left"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_pedido")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: left"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                </tr>
                                                                <tr class="trGridField">
                                                                  <td class="reportColumn"/>
                                                                  <%
                                                                  if(session.getAttribute("cb_regional")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_situacao")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_tipo_pedido")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_especie")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_pedido")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_oc")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_linha")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_obs")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_etiquetas")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_dt_entrega_etiqueta")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_dt_rec_etiqueta_filial")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_certificado_origem")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_carimbo")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_cabide")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center; font-weight: bold; color: red">
                                                                      Total Geral
                                                                    </td>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_pares")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center; font-weight: bold; color: red">
                                                                      <%= com.egen.util.text.FormatNumber.format(paresTotal, "#,##0.##") %>
                                                                    </td>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <td class="reportColumn" style="text-align: center"/>
                                                                  <%
                                                                  if(session.getAttribute("cb_rem")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_fl_prod")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_fl_fat")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_emiss")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_digit")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_dt_montagem")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_dt_corte")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_fat_cli")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_fat_br")!=null) {
                                                                    %>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_marca")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_agenda")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_dt_efetiva")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_hora")!=null) {
                                                                    %>
                                                                    <td>
                                                                    </td>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_senha")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_portao_entrega")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_cd_entrega")!=null) {
                                                                    %>
                                                                    <td class="reportColumn">
                                                                    </td>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_rotulos")!=null) {
                                                                    %>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_ped_amostra")!=null) {
                                                                    %>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_dt_envio")!=null) {
                                                                    %>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <%
                                                                  if(session.getAttribute("cb_emissao")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_filial")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_nf")!=null) {
                                                                    %>
                                                                    <td class="reportColumn"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_volumes")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_dt_inspecao")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_dt_entrega")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_amostra_brinde")!=null) {
                                                                    %>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_encarte")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_prioridade_embarque")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_atacado")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_grupo_economico")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: left"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_cliente")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <td class="reportColumn" style="text-align: center"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_representante")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: left"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                  <%
                                                                  if(session.getAttribute("cb_pedido")!=null) {
                                                                    %>
                                                                    <td class="reportColumn" style="text-align: left"/>
                                                                    <%
                                                                  }
                                                                  %>

                                                                </tr>
                                                                <%
                                                              }
                                                              %>
                                                              <%
                                                            pares = 0; }
                                                            %>
                                                          </table>

                                                          <%
                                                          if(!(request.getParameter("excel")+"").equals("true")){
                                                            %>
                                                            <table class="buttonTable" style='width:99%;'>
                                                              <tr class="buttonTr">
                                                                <td class="buttonTd">
                                                                  <div id="botao">
                                                                    <html:submit styleClass="myhidden" property="select_action">
                                                                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                                                                    </html:submit>
                                                                    <html:submit styleClass="myhidden" property="marcar_desmarcar_gerar_requisicao_action">
                                                                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                                                                    </html:submit>
                                                                    <%
                                                                    if(bloqueiaSalvarAlteracoes){
                                                                      %>
                                                                      <html:submit accesskey="a" value="Salvar Alterações" styleClass="myhidden" property="update_action"/>
                                                                      <%
                                                                    } else {
                                                                      %>
                                                                      <html:submit accesskey="a" value="Salvar Alterações" onclick="jQuery('#aguarde').show();jQuery('#botao').hide();" styleClass="baseButton" property="update_action"/>
                                                                      <%
                                                                    }
                                                                    %>
                                                                    <html:submit styleClass="baseButton" property="back_action">
                                                                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                                                                    </html:submit>
                                                                    <html:submit styleClass="myhidden" property="refresh_action"/>
                                                                  </div>
                                                                  <div id="aguarde" style="display:none">
                                                                    <img src="../img/loading_pequeno.gif"/>
                                                                    <b>
                                                                      Aguarde, salvando as alterações
                                                                    </b>
                                                                  </div>
                                                                </td>
                                                              </tr>
                                                            </table>
                                                            <%
                                                          }
                                                          %>
                                                          <%
                                                        } else {
                                                          %>
                                                          <br>
                                                          <div align="center">
                                                            <big>
                                                              <b>
                                                                Nenhum registro encontrado!
                                                              </b>
                                                            </big>
                                                          </div>
                                                          <%
                                                          if(!(request.getParameter("excel")+"").equals("true")){
                                                            %>
                                                            <table class="buttonTable" style='width:99%;'>
                                                              <tr class="buttonTr">
                                                                <td class="buttonTd">
                                                                  <html:submit styleClass="myhidden" property="select_action">
                                                                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                                                                  </html:submit>
                                                                  <html:submit accesskey="a" value="Salvar Alterações" styleClass="myhidden" property="update_action"/>
                                                                  <html:submit styleClass="baseButton" property="back_action">
                                                                    <bean:message bundle="ApplicationResources" key="jsp.back"/>
                                                                  </html:submit>
                                                                </td>
                                                              </tr>
                                                            </table>

                                                            <%
                                                          }
                                                          %>
                                                          <%
                                                        }
                                                        %>
                                                        <script>
                                                          jQuery(document).ready(function($) {
                                                            $(".baseFieldData").mask("99/99/9999");
                                                            });
                                                          </script>

                                                        </html:form>

                                                        <%
                                                      }
                                                      %>
                                                    </td>
                                                  </tr>
                                                </table>

                                              </body>
                                            </center>
                                          </html>

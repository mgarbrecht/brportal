<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ControleClientesEspeciaisActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ControleClientesEspeciaisActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("codigo_regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("cli_cdgo","Cliente");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("esc_seqn","Seq.");
    hashMapLabel.set("nro_normativa","Normativa");
    hashMapLabel.set("descricao","");
    hashMapLabel.set("gre_grupo","Grupo Econômico");
    hashMapLabel.set("gre_descricao","");
    hashMapLabel.set("ped_nmro","Pedido");
    hashMapLabel.set("ano_fatura","Ano da Fatura");
    hashMapLabel.set("numero_fatura","Número da Fatura");
    hashMapLabel.set("nf_numero","");
    hashMapLabel.set("nf_serie","");
    hashMapLabel.set("ped_ped_cliente","Pedido Cliente");
    hashMapLabel.set("fil_filial","Filial");
    hashMapLabel.set("fil_razsoc","");
    hashMapLabel.set("local_estoque","local_estoque");
    hashMapLabel.set("locais_estoque","Locais de Estoque");
    hashMapLabel.set("codigo_marca","Marca");
    hashMapLabel.set("especie","Espécie Pedido");
    hashMapLabel.set("tipo_produto","Tipo de Produto");
    hashMapLabel.set("tipo_pedido","Tipo de Pedido");
    hashMapLabel.set("ped_stat","Situação Pedido");
    hashMapLabel.set("tipo_mercado","Tipo Mercado");
    hashMapLabel.set("dt_inicial","Data Digitação Inicial");
    hashMapLabel.set("dt_final","Data Digitação Final");
    hashMapLabel.set("dt_ent_inicial","Data Entrega Inicial");
    hashMapLabel.set("dt_ent_final","Data Entrega Final");
    hashMapLabel.set("ordem","Ordenar Por");
    hashMapLabel.set("cb_regional","");
    hashMapLabel.set("cb_grupo_economico","cb_grupo_economico");
    hashMapLabel.set("cb_cliente","cb_cliente");
    hashMapLabel.set("cb_representante","");
    hashMapLabel.set("cb_pedido","cb_pedido");
    hashMapLabel.set("cb_situacao","");
    hashMapLabel.set("cb_tipo_pedido","");
    hashMapLabel.set("cb_oc","cb_oc");
    hashMapLabel.set("cb_linha","cb_linha");
    hashMapLabel.set("cb_etiquetas","cb_etiquetas");
    hashMapLabel.set("cb_obs","cb_obs");
    hashMapLabel.set("cb_pares","cb_pares");
    hashMapLabel.set("cb_rem","cb_rem");
    hashMapLabel.set("cb_fl_prod","cb_fl_prod");
    hashMapLabel.set("cb_fl_fat","cb_fl_fat");
    hashMapLabel.set("cb_digit","cb_digit");
    hashMapLabel.set("cb_fat_cli","cb_fat_cli");
    hashMapLabel.set("cb_fat_br","cb_fat_br");
    hashMapLabel.set("cb_marca","cb_marca");
    hashMapLabel.set("cb_carimbo","cb_carimbo");
    hashMapLabel.set("cb_rotulos","cb_rotulos");
    hashMapLabel.set("cb_ped_amostra","cb_ped_amostra");
    hashMapLabel.set("cb_dt_envio","cb_dt_envio");
    hashMapLabel.set("cb_agenda","cb_agenda");
    hashMapLabel.set("cb_dezena","");
    hashMapLabel.set("cb_dia","");
    hashMapLabel.set("cb_dt_efetiva","cb_dt_efetiva");
    hashMapLabel.set("cb_hora","cb_hora");
    hashMapLabel.set("cb_senha","cb_senha");
    hashMapLabel.set("cb_emissao","cb_emissao");
    hashMapLabel.set("cb_filial","cb_filial");
    hashMapLabel.set("cb_nf","cb_nf");
    hashMapLabel.set("cb_volumes","cb_volumes");
    hashMapLabel.set("cb_dt_inspecao","cb_dt_inspecao");
    hashMapLabel.set("cb_dt_montagem","");
    hashMapLabel.set("cb_dt_entrega_etiqueta","");
    hashMapLabel.set("cb_especie","");
    hashMapLabel.set("possui_dados","Possui Dados Cadastrados");
    hashMapLabel.set("cb_possui_carimbo","Carimbo");
    hashMapLabel.set("cb_somente_etiqueta","Somente Etiqueta");
    hashMapLabel.set("cb_etiquetas_pendentes","");
    hashMapLabel.set("cb_somente_amostra","");
    hashMapLabel.set("dt_nf_inicial","");
    hashMapLabel.set("dt_nf_final","");
    hashMapLabel.set("cb_empenhado_completo","Somente Pedidos Empenhados Completo");
    hashMapLabel.set("etiquetas","Etiquetas");
    hashMapLabel.set("remessa","Remessa");
    hashMapLabel.set("cb_portao_entrega","");
    hashMapLabel.set("cb_cd_entrega","");
    hashMapLabel.set("cb_dt_entrega","");
    hashMapLabel.set("cb_amostra_brinde","");
    hashMapLabel.set("cb_encarte","");
    hashMapLabel.set("cb_prioridade_embarque","");
    hashMapLabel.set("cb_dt_rec_etiqueta_filial","");
    hashMapLabel.set("cb_cabide","");
    hashMapLabel.set("cb_atacado","");
    hashMapLabel.set("atacado","");
    hashMapLabel.set("dt_agend_inicial","");
    hashMapLabel.set("dt_agend_final","");
    hashMapLabel.set("tra_cdgo","");
    hashMapLabel.set("tra_nome","");
    hashMapLabel.set("cb_etiquetas_pendentes_industrial","cb_etiquetas_pendentes_industrial");
    hashMapLabel.set("ite_situ","Situação do Pedido");
    hashMapLabel.set("linha","Linha");
    hashMapLabel.set("cb_subtotal_grupo_economico","Subtotal por Grupo Econômico");
    hashMapLabel.set("dt_emiss_ini","Data Emissão Inicial");
    hashMapLabel.set("dt_emiss_fim","Data Emissão Final");
    hashMapLabel.set("gerar_planilha","Gerar Planilha");
    hashMapLabel.set("gerar_planilha_subtotal","Gerar Planilha");
    hashMapLabel.set("dt_corte_inicial","Data Corte");
    hashMapLabel.set("dt_corte_final","");
    hashMapLabel.set("somente_consulta","Somente Consulta");
    hashMapLabel.set("distribuicao","Distribuição");
    hashMapLabel.set("cb_desc_com","");
    hashMapLabel.set("cb_desc_prom","");
    hashMapLabel.set("cb_desc_pont","");
    hashMapLabel.set("cb_cnd_cdgo","");
    hashMapLabel.set("cb_invoice","");
    hashMapLabel.set("cb_valor","");
    hashMapLabel.set("cb_mini_fabrica","");
    hashMapLabel.set("cb_portao_embarque","");
    hashMapLabel.set("cb_dt_faturamento","");
    hashMapLabel.set("cb_volumes1","");
    hashMapLabel.set("cb_previsao","");
    hashMapLabel.set("cb_dt_ultima_ocorrencia","");
    hashMapLabel.set("cb_atacado1","");
    hashMapLabel.set("cb_seq","");
    hashMapLabel.set("cb_razao_social","");
    hashMapLabel.set("cb_cidade","");
    hashMapLabel.set("cb_loja","");
    hashMapLabel.set("cb_obs_pedido","");
    hashMapLabel.set("cb_data_bloqueio","");
    hashMapLabel.set("cb_data_prevista_desbloqueio","");
    hashMapLabel.set("cb_dt_solicitacao_alarme","");
    hashMapLabel.set("cb_dt_recebimento_alarme","");
    hashMapLabel.set("cb_dt_recebimento_alarme_filial","");
    hashMapLabel.set("cb_nota_fiscal_alarme","");
    hashMapLabel.set("cb_distribuicao","");
    hashMapLabel.set("cb_normativa_cliente","");
    hashMapLabel.set("cb_emiss","");
    hashMapLabel.set("cb_bloqueio_49","");
    hashMapLabel.set("cb_alerta_etiqueta","");
    hashMapLabel.set("cb_livro","Livro");
    hashMapLabel.set("cb_tra_cdgo","");
    hashMapLabel.set("cb_dt_corte","Data Corte");
    hashMapLabel.set("cb_bloqueado_credito","cb_bloqueado_credito");
    hashMapLabel.set("preco_pdv","Preco_pdv");
    hashMapLabel.set("cb_certificado_origem","cb_certificado_origem");
    hashMapLabel.set("referencia","referencia");
    hashMapLabel.set("cb_descricao_item","");
    hashMapLabel.set("cb_bloqueio_uf","Bloqueio UF");
    hashMapLabel.set("cb_tipo_estoque","Tipo Estoque");
    hashMapLabel.set("cb_data_etiquetagem","Data etiquetagem");
    hashMapLabel.set("cb_gerar_requisicao","Gerar Requisicao");
    hashMapLabel.set("cb_local_estoque","Local Estoque");
    hashMapLabel.set("cb_descricao","Descrição");
    hashMapLabel.set("descricao_embalagem","descricao_embalagem");
    hashMapLabel.set("cb_descricao_embalagem","cb_descricao_embalagem");
    hashMapLabel.set("cb_cnpj","");
    hashMapLabel.set("cb_romaneio","");
    hashMapLabel.set("mostrar_filiais_producao","Mostrar Todas Filiais de Produção");
    hashMapLabel.set("cb_grade_corrugado","");
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
    <body >
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(186)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            acesso.Sessao sessao = new acesso.Sessao(session);
            %>

            <html:form action="com/ControleClientesEspeciaisForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <div class\='div10l'>
                        Um dos campos com
                        <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        deve ser preenchido.
                      </div>
                      <div class\='div10l'>
                        Todos os campos com
                        <img src='../img/required.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        devem ser preenchidos.
                      </div>
                    </div>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="esc_seqn"/>
                    <html:errors property="gre_grupo"/>
                    <html:errors property="gre_descricao"/>
                    <html:errors property="ped_nmro"/>
                    <html:errors property="ped_ped_cliente"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="fil_razsoc"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="ped_stat"/>
                    <html:errors property="dt_inicial"/>
                    <html:errors property="dt_final"/>
                    <html:errors property="ordem"/>
                    <html:errors property="cb_regional"/>
                    <html:errors property="cb_grupo_economico"/>
                    <html:errors property="cb_cliente"/>
                    <html:errors property="cb_representante"/>
                    <html:errors property="cb_pedido"/>
                    <html:errors property="cb_oc"/>
                    <html:errors property="cb_linha"/>
                    <html:errors property="cb_etiquetas"/>
                    <html:errors property="cb_etiquetas_pendentes"/>
                    <html:errors property="cb_etiquetas_pendentes_industrial"/>
                    <html:errors property="cb_obs"/>
                    <html:errors property="cb_pares"/>
                    <html:errors property="cb_rem"/>
                    <html:errors property="cb_cabide"/>
                    <html:errors property="cb_fl_prod"/>
                    <html:errors property="cb_fl_fat"/>
                    <html:errors property="cb_digit"/>
                    <html:errors property="cb_fat_cli"/>
                    <html:errors property="cb_fat_br"/>
                    <html:errors property="cb_marca"/>
                    <html:errors property="cb_carimbo"/>
                    <html:errors property="cb_rotulos"/>
                    <html:errors property="cb_ped_amostra"/>
                    <html:errors property="cb_dt_envio"/>
                    <html:errors property="cb_dt_corte"/>
                    <html:errors property="cb_agenda"/>
                    <html:errors property="cb_dezena"/>
                    <html:errors property="cb_dia"/>
                    <html:errors property="cb_dt_efetiva"/>
                    <html:errors property="cb_hora"/>
                    <html:errors property="cb_senha"/>
                    <html:errors property="cb_portao_entrega"/>
                    <html:errors property="cb_cd_entrega"/>
                    <html:errors property="cb_emissao"/>
                    <html:errors property="cb_filial"/>
                    <html:errors property="cb_nf"/>
                    <html:errors property="cb_volumes"/>
                    <html:errors property="cb_dt_inspecao"/>
                    <html:errors property="possui_dados"/>
                    <html:errors property="cb_atacado"/>
                    <html:errors property="cb_certificado_origem"/>
                    <html:errors property="cb_descricao_embalagem"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">


                <%
                if(!sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL") && !sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Representante
                      </span>
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="rep_cdgo" styleId="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'ControleClientesEspeciaisActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="5" maxlength="5"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_rep_cdgo() {
                        window.open('..//lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                  </td>
                </tr>
                <%
              } else {
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Representante
                    </span>
                  </span>
                  <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                </td>
                <td class="formField">
                  <html:text property="rep_cdgo" styleId="rep_cdgo" styleClass="disabled" size="5" maxlength="5" readonly="true" tabindex="-1" value="<%= sessao.getChave() %>"/>
                  <input type="button" class="lovButton" tabindex="-1" value="..." disabled="true"  >
                  <span class="spamFormLabel">
                  </span>
                  <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                </td>
              </tr>
              <%
            }
            %>


            <tr class="itemTr">
              <td class="formLabel">
                <span class="spamFormLabel">
                  Regional
                </span>
                <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
              </td>
              <td class="formField">
                <html:text property="codigo_regional" styleId="codigo_regional" onblur="fillFields(0,new Array('codigo_regional'),'ControleClientesEspeciaisActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="baseField" size="3"/>
                <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_regional()"  >
                <script type="text/javascript">
                  function lov_open_codigo_regional() {
                    window.open('..//lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=codigo_regional&return1=nome_regional','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                  }
                </script>
                <span class="spamFormLabel">
                </span>
                <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
              </td>
            </tr>



            <tr class="itemTr">
              <td class="formLabel">
                <span class="spamFormLabel">
                  Cliente
                </span>
              </span>
              <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
            </td>
            <td class="formField">
              <html:text property="cli_cdgo" styleId="cli_cdgo" onblur="fillFields(0,new Array('cli_cdgo'),'ControleClientesEspeciaisActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));" styleClass="baseField" size="10" maxlength="22"/>
              <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cli_cdgo()"  >
              <script type="text/javascript">
                function lov_open_cli_cdgo() {
                  window.open('..//lov/LvClienteLov.do?resetfull_action=&returnBlock=0&return0=cli_cdgo&return1=cli_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                }
              </script>
              <span class="spamFormLabel">
              </span>
              <html:text property="cli_rzao" styleId="cli_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="55" maxlength="50"/>
            </td>
          </tr>

          <tr class="itemTr">
            <td class="formLabel">
              <span class="spamFormLabel">
                Sequencial
              </span>
            </span>
          </td>
          <td class="formField">
            <html:text property="esc_seqn" styleId="esc_seqn" styleClass="baseField" size="5" maxlength="5"/>
          </td>
        </tr>

        <tr class="itemTr">
          <td class="formLabel">
            <span class="spamFormLabel">
              Normativa
            </span>
          </td>
          <td class="formField">
            <html:text property="nro_normativa" styleId="nro_normativa" onblur="fillFields(0,new Array('nro_normativa'),'ControleClientesEspeciaisActionForm.getDescricao_Ajax',new Array('descricao'));" styleClass="baseField" size="5"/>
            <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_nro_normativa()"  >
            <script type="text/javascript">
              function lov_open_nro_normativa() {
                window.open('..//lov/LvNormativaLov.do?resetfull_action=&returnBlock=0&return0=nro_normativa&return1=descricao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
              }
            </script>
            <html:text property="descricao" styleId="descricao" styleClass="disabled" tabindex="-1" readonly="true" size="80"/>
          </td>
        </tr>


        <tr class="itemTr">
          <td class="formLabel">
            <span class="spamFormLabel">
              Grupo Econômico
            </span>
            <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
          </td>
          <td class="formField">
            <html:text property="gre_grupo" styleId="gre_grupo" onblur="fillFields(0,new Array('gre_grupo'),'ControleClientesEspeciaisActionForm.getGre_descricao_Ajax',new Array('gre_descricao'));" styleClass="baseField" size="6" maxlength="6"/>
            <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_gre_grupo()"  >
            <script type="text/javascript">
              function lov_open_gre_grupo() {
                window.open('..//lov/LvGrupoEconomicoLov.do?resetfull_action=&returnBlock=0&return0=gre_grupo&return1=gre_descricao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
              }
            </script>
            <span class="spamFormLabel">
            </span>
            <html:text property="gre_descricao" styleId="gre_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="30"/>
          </td>
        </tr>



        <%
        if(!sessao.getTipoEntidadeNegocio().equals("TRANSPORTADORA") ){
          %>


          <tr class="itemTr">
            <td class="formLabel">
              <span class="spamFormLabel">
                Transportadora
              </span>
              <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
            </td>
            <td class="formField">
              <html:text property="tra_cdgo" styleId="tra_cdgo" onblur="fillFields(0,new Array('tra_cdgo'),'ControleClientesEspeciaisActionForm.getTra_nome_Ajax',new Array('tra_nome'));" styleClass="baseField" size="6"/>
              <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_tra_cdgo()"  >
              <script type="text/javascript">
                function lov_open_tra_cdgo() {
                  window.open('..//lov/LvTransportadoraLov.do?resetfull_action=&returnBlock=0&return0=tra_cdgo&return1=tra_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                }
              </script>
              <span class="spamFormLabel">
              </span>
              <html:text property="tra_nome" styleId="tra_nome" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
            </td>
          </tr>



          <%
        } else {
          %>

          <html:hidden property="tra_cdgo" value="<%= sessao.getChave() %>"/>
          <html:hidden property="tra_nome" />

          <%
        }
        %>

        <tr class="itemTr">
          <td class="formLabel">
            <span class="spamFormLabel">
              Ano da fatura
            </span>
            <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
          </td>
          <td class="formField">
            <html:text property="ano_fatura" styleId="ano_fatura" styleClass="baseField" size="4"/>
          </td>
        </tr>


        <tr class="itemTr">
          <td class="formLabel">
            <span class="spamFormLabel">
              Número da fatura
            </span>
            <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
          </td>
          <td class="formField">
            <html:text property="numero_fatura" styleId="numero_fatura" styleClass="baseField" size="4"/>
          </td>
        </tr>




        <tr class="itemTr">
          <td class="formLabel">
            <span class="spamFormLabel">
              Pedido
            </span>
            <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
          </td>
          <td class="formField">
            <html:textarea property="ped_nmro" styleId="ped_nmro" styleClass="baseField" cols="60" rows="4"/>
          </td>
        </tr>

        <tr class="itemTr">
          <td class="formLabel">
            <span class="spamFormLabel">
              Remessa
            </span>
            <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
          </td>
          <td class="formField">
            <html:textarea property="remessa" styleId="remessa" styleClass="baseField" cols="60" rows="4"/>
          </td>
        </tr>

        <tr class="itemTr">
          <td class="formLabel">
            <span class="spamFormLabel">
              Pedido Cliente
            </span>
            <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
          </td>
          <td class="formField">
            <html:textarea property="ped_ped_cliente" styleId="ped_ped_cliente" styleClass="baseField" cols="60" rows="4"/>
          </td>
        </tr>

        <tr class="itemTr">
          <td class="formLabel">
            <span class="spamFormLabel">
              Nota Fiscal
            </span>
            <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
          </td>
          <td class="formField">
            <html:textarea property="nf_numero" styleId="nf_numero" styleClass="baseField" cols="60" rows="4"/>
          </td>
        </tr>

        <tr class="itemTr">
          <td class="formLabel">
            <span class="spamFormLabel">
              Série da Nota
            </span>
          </td>
          <td class="formField">
            <html:text property="nf_serie" styleId="nf_serie" styleClass="baseField" size="3"/>
          </td>
        </tr>


        <tr class="itemTr">
          <td class="formLabel">
            <span class="spamFormLabel">
              Filial
            </span>
          </td>
          <td class="formField">
            <html:text property="fil_filial" styleId="fil_filial" onblur="fillFields(0,new Array('fil_filial'),'ControleClientesEspeciaisActionForm.getFil_razsoc_Ajax',new Array('fil_razsoc'));" styleClass="baseField" size="3"/>
            <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fil_filial()"  >
            <script type="text/javascript">
              function lov_open_fil_filial() {
                window.open('..//lov/LvFilialLov.do?resetfull_action=&returnBlock=0&return0=fil_filial&return1=fil_razsoc','','scrollbars=yes,height=510,width=730,top=0,left=0,');
              }
            </script>
            <span class="spamFormLabel">
            </span>
            <html:text property="fil_razsoc" styleId="fil_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="50"/>
          </td>
        </tr>


        <tr class="itemTr">
          <td class="formLabel">
            <span class="spamFormLabel">
              Local de Estoque
            </span>
          </td>
          <td class="formField">
            <html:hidden property="local_estoque" value="<%= session.getAttribute("codigos_locais_selecionados") !=null ? (String)session.getAttribute("codigos_locais_selecionados") : "" %>"/>
            <input type="button" class="lovButton"  value="Selecionar Locais"  onclick="javascript:lov_open_locais_estoque()"  >
            <script type="text/javascript">
              function lov_open_locais_estoque() {
                window.open('..//lov/LvLocalEstoqueGrdGrid.do?select_action','','scrollbars=yes,height=600,width=730,top=0,left=0,');
              }
            </script>
          </td>
        </tr>




        <tr>
          <td class="formLabel">
            <span class="spamFormLabel" >
            </span>
          </td>
          <td class="formField">
            <%
            {
              int counterbl_report_status =0;
              int i_bl_report_Jw_status =0;
              java.util.Vector res_Jw_status = (java.util.Vector)session.getAttribute("locais_selecionados");
              if (res_Jw_status !=null && res_Jw_status.size()>0) {
                %>
                <table id="TRbl_report_Jw_tipos_produtos" class="reportTable" style=width:400px; border=1;  >
                  <tr class="reportHeader" >
                    <td align="center">
                      Locais de Estoque Selecionados
                    </td>
                  </tr>
                  <%
                  for (int x=0;x<res_Jw_status.size(); x++){
                    counterbl_report_status++;
                    String style="";
                    if (!((i_bl_report_Jw_status%2)!=0)) {
                      style="class=rowColor";
                    } else {
                      style="class=rowBlank";
                    }
                    %>
                    <tr <%= style %> id='TRbl_report_Jw_tipos_produtos<%= counterbl_report_status %>' >
                      <td class="reportColumn" style="text-align:left;">
                        <%= res_Jw_status.elementAt(x) %>
                      </td>
                    </tr>
                    <%
                  }
                  %>
                </table>
                <%
              }
            }
            %>



          </td>
        </tr>












        <tr class="itemTr">
          <td class="formLabel">
            <span class="spamFormLabel">
              Marca
            </span>
          </td>
          <td class="formField">

            <html:hidden property="codigo_marca" value="<%= session.getAttribute("est102_marcas_selecionadas_codigos") !=null ? (String)session.getAttribute("est102_marcas_selecionadas_codigos") : "" %>"/>
            <input type="button" class="lovButton"  value="Selecionar Marcas" onclick="javascript:lov_open_marcas()">
            <script type="text/javascript">
              function lov_open_marcas() {
                window.open('..//lov/LvMarcaGrdGrid.do?select_action','','scrollbars=yes,height=510,width=730,top=0,left=0,');
              }
            </script>

          </td>
        </td>
      </tr>




      <tr>
        <td class="formLabel">
          <span class="spamFormLabel" >
          </span>
        </td>
        <td class="formField">
          <%
          {
            int counterbl_report_status =0;
            int i_bl_report_Jw_status =0;
            java.util.Vector res_Jw_status = (java.util.Vector)session.getAttribute("est102_marcas_selecionadas_vetor");
            if (res_Jw_status !=null && res_Jw_status.size()>0) {
              %>
              <table id="TRbl_report_Jw_tipos_produtos" class="reportTable" style=width:340px; border=1;  >
                <tr class="reportHeader" >
                  <td align="center">
                    Marcas Selecionadas
                  </td>
                </tr>
                <%
                for (int x=0;x<res_Jw_status.size(); x++){
                  counterbl_report_status++;
                  String style="";
                  if (!((i_bl_report_Jw_status%2)!=0)) {
                    style="class=rowColor";
                  } else {
                    style="class=rowBlank";
                  }
                  %>
                  <tr <%= style %> id='TRbl_report_Jw_tipos_produtos<%= counterbl_report_status %>' >
                    <td class="reportColumn" style="text-align:left;">
                      <%= res_Jw_status.elementAt(x) %>
                    </td>
                  </tr>
                  <%
                }
                %>
              </table>
              <%
            }
          }
          %>



        </td>
      </tr>










      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Linha
          </span>
        </td>
        <td class="formField">
          <html:text property="linha" styleId="linha" styleClass="baseField" size="10"/>
        </td>
      </tr>


      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Referência
          </span>
        </td>
        <td class="formField">
          <html:text property="referencia" styleId="referencia" styleClass="baseField" size="10"/>
        </td>
      </tr>

      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Tipo de Pedido
          </span>
        </td>
        <td class="formField">
          <html:select property="tipo_pedido" styleId="tipo_pedido" styleClass="baseField" size="1">
            <html:option styleClass="baseOption" value="T">
              Todos
            </html:option>
            <html:option styleClass="baseOption" value="PG">
              PG-Programado
            </html:option>
            <html:option styleClass="baseOption" value="PP">
              PP-Produto Pronto
            </html:option>
            <html:option styleClass="baseOption" value="EX">
              EX-Exportação
            </html:option>
          </html:select>
        </td>
      </tr>







      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Distribuição
          </span>
        </td>
        <td class="formField">
          <html:select property="distribuicao" styleId="distribuicao" styleClass="baseField" size="1">
            <html:option styleClass="baseOption" value="T">
              Todos
            </html:option>
            <html:option styleClass="baseOption" value="S">
              Com distribuição
            </html:option>
            <html:option styleClass="baseOption" value="N">
              Sem distribuição
            </html:option>
          </html:select>
        </td>
      </tr>


      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Tipo de Produto
          </span>
        </td>
        <td class="formField">
          <!--
            <html:select property="tipo_produto" styleId="tipo_produto" styleClass="baseField" size="1"> <html:options property="tipo_produtoList" labelProperty="tipo_produtoLabelList" styleClass="baseOptions"/> </html:select>
          -->
          <html:hidden property="tipo_produto" value="<%= session.getAttribute("tipos_produtos_selecionados_codigos") !=null ? (String)session.getAttribute("tipos_produtos_selecionados_codigos") : "" %>" />

          <input type="button" class="lovButton"  value="Selecionar Tipos de Produto"  onclick="javascript:lov_open_tipos_produto()">
          <script type="text/javascript">
            function lov_open_tipos_produto() {
              window.open('..//lov/LvTipoProdutoGrdGrid.do?select_action','','scrollbars=yes,height=600,width=730,top=0,left=0,');
            }
          </script>

        </td>
      </tr>






      <tr>
        <td class="formLabel">
          <span class="spamFormLabel" >
          </span>
        </td>
        <td class="formField">
          <%
          int counterbl_report_Jw_tipos_produtos_selecionados =0;
          int i_bl_report_Jw_tipos_produtos_selecionados =0;
          java.util.Vector res_Jw_tipos_produtos_selecionados = (java.util.Vector)session.getAttribute("tipos_produtos_selecionados_vetor");
          if (res_Jw_tipos_produtos_selecionados !=null && res_Jw_tipos_produtos_selecionados.size()>0) {
            %>
            <table id="TRbl_report_Jw_tipos_produtos_selecionados" class="reportTable" style=width:340px; border=1;  >
              <tr class="reportHeader" >
                <td align="center">
                  Tipos de Produtos Selecionados
                </td>
              </tr>
              <%
              for (int x=0;x<res_Jw_tipos_produtos_selecionados.size(); x++){
                counterbl_report_Jw_tipos_produtos_selecionados++;
                String style="";
                if (!((i_bl_report_Jw_tipos_produtos_selecionados%2)!=0)) {
                  style="class=rowColor";
                } else {
                  style="class=rowBlank";
                }
                %>
                <tr <%= style %> >
                  <td class="reportColumn" style="text-align:left;">
                    <%= res_Jw_tipos_produtos_selecionados.elementAt(x) %>
                  </td>
                </tr>
                <%
              }
              %>
            </table>
            <%
          }
          %>



        </td>
      </tr>




















      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Espécie Pedido
          </span>
          <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
        </td>
        <td class="formField">
          <input type="button" class="lovButton" tabindex="-1" value="Selecionar Espécies"  onclick="javascript:lov_open_especie()"  >

          <script type="text/javascript">
            function lov_open_especie() {
              window.open('..//lov/LvEspeciePedidoGrid.do?select_action=','','scrollbars=yes,height=510,width=600,top=0,left=0,');
            }
          </script>
        </td>
      </tr>


      <tr>
        <td class="formLabel">
          <span class="spamFormLabel" >
          </span>
        </td>
        <td class="formField">
          <%
          int counterbl_report_Jw_tipos_produtos2 =0;
          int i_bl_report_Jw_tipos_produtos2 =0;
          java.util.Vector res_Jw_especies = (java.util.Vector)session.getAttribute("listaEspecies");
          if (res_Jw_especies !=null && res_Jw_especies.size()>0) {
            %>
            <table id="TRbl_report_Jw_tipos_produtos" class="reportTable" style=width:340px; border=1;  >
              <tr class="reportHeader" >
                <td align="center">
                  Espécies Selecionadas
                </td>
              </tr>
              <%
              for (int x=0;x<res_Jw_especies.size(); x++){
                counterbl_report_Jw_tipos_produtos2++;
                String style="";
                if (!((i_bl_report_Jw_tipos_produtos2%2)!=0)) {
                  style="class=rowColor";
                } else {
                  style="class=rowBlank";
                }
                %>
                <tr <%= style %> >
                  <td class="reportColumn" style="text-align:left;">
                    <%= res_Jw_especies.elementAt(x) %>
                  </td>
                </tr>
                <%
              }
              %>
            </table>
            <%
          }
          %>



        </td>
      </tr>









      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Status do Pedido
          </span>
          <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
        </td>
        <td class="formField">

          <html:hidden property="ped_stat" value="<%= session.getAttribute("consulta_pedidos_status_pedido") !=null ? (String)session.getAttribute("consulta_pedidos_status_pedido") : "" %>"/>
          <input type="button" class="lovButton"  value="Selecionar Status" onclick="javascript:lov_open_status()">
          <script type="text/javascript">
            function lov_open_status() {
              window.open('..//lov/LvStatusPedidoGrdGrid.do?select_action','','scrollbars=yes,height=510,width=730,top=0,left=0,');
            }
          </script>
        </td>
      </tr>


      <tr>
        <td class="formLabel">
          <span class="spamFormLabel" >
          </span>
        </td>
        <td class="formField">
          <%
          int counterbl_report_status =0;
          int i_bl_report_Jw_status =0;
          java.util.Vector res_Jw_status = (java.util.Vector)session.getAttribute("res_status_pedido");
          if (res_Jw_status !=null && res_Jw_status.size()>0) {
            %>
            <table id="TRbl_report_Jw_tipos_produtos" class="reportTable" style=width:340px; border=1;  >
              <tr class="reportHeader" >
                <td align="center">
                  Status Selecionados
                </td>
              </tr>
              <%
              for (int x=0;x<res_Jw_status.size(); x++){
                counterbl_report_status++;
                String style="";
                if (!((i_bl_report_Jw_status%2)!=0)) {
                  style="class=rowColor";
                } else {
                  style="class=rowBlank";
                }
                %>
                <tr <%= style %> id='TRbl_report_Jw_tipos_produtos<%= counterbl_report_status %>' >
                  <td class="reportColumn" style="text-align:left;">
                    <%= res_Jw_status.elementAt(x) %>
                  </td>
                </tr>
                <%
              }
              %>
            </table>
            <%
          }
          %>



        </td>
      </tr>



















      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Situações do Pedido
          </span>
          <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
        </td>
        <td class="formField">
          <input type="button" class="lovButton"  value="Selecionar Situações"  onclick="javascript:lov_open_situacoes()"  >
          <script type="text/javascript">
            function lov_open_situacoes() {
              window.open('..//lov/LvIteSituGrid.do?select_action','','scrollbars=yes,height=510,width=730,top=0,left=0,');
            }
          </script>
        </td>
      </tr>





      <tr>
        <td class="formLabel">
          <span class="spamFormLabel" >
          </span>
        </td>
        <td class="formField">
          <%
          int counterbl_report_Jw_tipos_produtos =0;
          int i_bl_report_Jw_tipos_produtos =0;
          java.util.Vector res_Jw_situacoes = (java.util.Vector)session.getAttribute("listaSituacoes");
          if (res_Jw_situacoes!=null && res_Jw_situacoes.size()>0) {
            %>
            <table id="TRbl_report_Jw_tipos_produtos" class="reportTable" style=width:340px; border=1;  >
              <tr class="reportHeader" >
                <td align="center">
                  Situações Selecionadas
                </td>
              </tr>
              <%
              for (int x=0;x<res_Jw_situacoes.size(); x++){
                counterbl_report_Jw_tipos_produtos++;
                String style="";
                if (!((i_bl_report_Jw_tipos_produtos%2)!=0)) {
                  style="class=rowColor";
                } else {
                  style="class=rowBlank";
                }
                %>
                <tr <%= style %> id='TRbl_report_Jw_tipos_produtos<%=counterbl_report_Jw_tipos_produtos%>' >
                  <td class="reportColumn" style="text-align:left;">
                    <%= res_Jw_situacoes.elementAt(x) %>
                  </td>
                </tr>
                <%
              }
              %>
            </table>
            <%
          }
          %>



        </td>
      </tr>

















      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Status/Situações do Pedido
          </span>
          <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
        </td>
        <td class="formField">
          <input type="button" class="lovButton"  value="Selecionar Status/Situações"  onclick="javascript:lov_open_status_situacoes()"  >
          <script type="text/javascript">
            function lov_open_status_situacoes() {
              window.open('..//lov/LvStatusSituacoesGrid.do?select_action','','scrollbars=yes,height=510,width=730,top=0,left=0,');
            }
          </script>
        </td>
      </tr>





      <tr>
        <td class="formLabel">
          <span class="spamFormLabel" >
          </span>
        </td>
        <td class="formField">
          <%
          int counterbl_report_Jw_status_situacoes =0;
          int i_bl_report_Jw_status_situacoes =0;
          java.util.Vector res_Jw_status_situacoes = (java.util.Vector)session.getAttribute("res_status_situacoes");
          if (res_Jw_status_situacoes !=null && res_Jw_status_situacoes.size()>0) {
            %>
            <table id="TRbl_report_Jw_tipos_produtos" class="reportTable" style=width:340px; border=1;  >
              <tr class="reportHeader" >
                <td align="center">
                  Status/Situações Selecionados
                </td>
              </tr>
              <%
              for (int x=0;x<res_Jw_status_situacoes.size(); x++){
                counterbl_report_Jw_status_situacoes++;
                String style="";
                if (!((i_bl_report_Jw_status_situacoes%2)!=0)) {
                  style="class=rowColor";
                } else {
                  style="class=rowBlank";
                }
                %>
                <tr <%= style %> id='TRbl_report_Jw_tipos_produtos<%=counterbl_report_Jw_status_situacoes %>' >
                  <td class="reportColumn" style="text-align:left;">
                    <%= res_Jw_status_situacoes.elementAt(x) %>
                  </td>
                </tr>
                <%
              }
              %>
            </table>
            <%
          }
          %>



        </td>
      </tr>


















      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Tipo Mercado
          </span>
        </td>
        <td class="formField">
          <html:select property="tipo_mercado" styleId="tipo_mercado" styleClass="baseField" size="1">
            <html:option styleClass="baseOption" value="T">
              Todos
            </html:option>
            <html:option styleClass="baseOption" value="MI">
              Mercado Interno
            </html:option>
            <html:option styleClass="baseOption" value="ME">
              Mercado Externo
            </html:option>
          </html:select>
        </td>
      </tr>


      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Data de Emissão do Pedido
          </span>
          <bean:message key="jsp.fieldnotnull"/>
        </td>
        <td class="formField">
          <html:text property="dt_emiss_ini" styleId="dt_emiss_ini" styleClass="baseField" size="10" maxlength="10"/>
          <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_emiss_ini']); cal1.year_scroll = true; cal1.popup();">
            <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
          </a>
          <html:text property="dt_emiss_fim" styleId="dt_emiss_fim" styleClass="baseField" size="10"/>
          <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_emiss_fim']); cal1.year_scroll = true; cal1.popup();">
            <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
          </a>
        </td>
      </tr>


      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Data de Digitação do Pedido
          </span>
          <bean:message key="jsp.fieldnotnull"/>
        </td>
        <td class="formField">
          <html:text property="dt_inicial" styleId="dt_inicial" styleClass="baseField" size="10" maxlength="10"/>
          <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_inicial']); cal1.year_scroll = true; cal1.popup();">
            <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
          </a>
          <html:text property="dt_final" styleId="dt_final" styleClass="baseField" size="10"/>
          <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_final']); cal1.year_scroll = true; cal1.popup();">
            <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
          </a>
        </td>
      </tr>

      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Data Entrega do Pedido
          </span>
          <bean:message key="jsp.fieldnotnull"/>
        </td>
        <td class="formField">
          <html:text property="dt_ent_inicial" styleId="dt_ent_inicial" styleClass="baseField" size="10" maxlength="10"/>
          <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_ent_inicial']); cal1.year_scroll = true; cal1.popup();">
            <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
          </a>
          <html:text property="dt_ent_final" styleId="dt_ent_final" styleClass="baseField" size="10" maxlength="10"/>
          <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_ent_final']); cal1.year_scroll = true; cal1.popup();">
            <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
          </a>
        </td>
      </tr>

      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Data Emissão da Nota Fiscal
          </span>
          <bean:message key="jsp.fieldnotnull"/>
        </td>
        <td class="formField">
          <html:text property="dt_nf_inicial" styleId="dt_nf_inicial" styleClass="baseField" size="10" maxlength="10"/>
          <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_nf_inicial']); cal1.year_scroll = true; cal1.popup();">
            <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
          </a>
          <html:text property="dt_nf_final" styleId="dt_nf_final" styleClass="baseField" size="10" maxlength="10"/>
          <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_nf_final']); cal1.year_scroll = true; cal1.popup();">
            <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
          </a>
        </td>
      </tr>

      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Data Agendamento
          </span>
          <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
        </td>
        <td class="formField">
          <html:text property="dt_agend_inicial" styleId="dt_agend_inicial" styleClass="baseField" size="10" maxlength="10"/>
          <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_agend_inicial']); cal1.year_scroll = true; cal1.popup();">
            <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
          </a>
          <html:text property="dt_agend_final" styleId="dt_agend_final" styleClass="baseField" size="10" maxlength="10"/>
          <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_agend_final']); cal1.year_scroll = true; cal1.popup();">
            <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
          </a>
        </td>
      </tr>





      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Data de Corte
          </span>
          <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
        </td>
        <td class="formField">
          <html:text property="dt_corte_inicial" styleId="dt_corte_inicial" styleClass="baseField" size="10" maxlength="10"/>
          <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_corte_inicial']); cal1.year_scroll = true; cal1.popup();">
            <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
          </a>
          <html:text property="dt_corte_final" styleId="dt_corte_final" styleClass="baseField" size="10" maxlength="10"/>
          <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_corte_final']); cal1.year_scroll = true; cal1.popup();">
            <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
          </a>
        </td>
      </tr>




      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Ordenar Por
          </span>
        </td>
        <td class="formField">
          <html:select property="ordem" styleId="ordem" styleClass="baseField" size="1">
            <html:option styleClass="baseOption" value="d">
              Data Faturamento
            </html:option>
            <html:option styleClass="baseOption" value="a">
              Data Agendamento
            </html:option>
            <html:option styleClass="baseOption" value="sa">
              Semana Agendamento
            </html:option>
            <html:option styleClass="baseOption" value="f">
              Filial
            </html:option>
            <html:option styleClass="baseOption" value="o">
              Ordem de Compra
            </html:option>
            <html:option styleClass="baseOption" value="c">
              Cliente
            </html:option>
            <html:option styleClass="baseOption" value="g">
              Grupo Econômico
            </html:option>
          </html:select>
        </td>
      </tr>


      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Somente Pedidos Empenhados Completo
          </span>
        </td>
        <td class="formField">
          <html:checkbox property="cb_empenhado_completo" styleId="cb_empenhado_completo" styleClass="baseField" value="0"/>
        </td>
      </tr>


      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Etiquetas Pendentes Comercial
          </span>
        </td>
        <td class="formField">
          <html:checkbox property="cb_etiquetas_pendentes" styleId="cb_etiquetas_pendentes" styleClass="baseField" value="S"/>
        </td>
      </tr>


      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Etiquetas Pendentes Industrial
          </span>
        </td>
        <td class="formField">
          <html:checkbox property="cb_etiquetas_pendentes_industrial" styleId="cb_etiquetas_pendentes_industrial" styleClass="baseField" value="S"/>
        </td>
      </tr>


      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Somente Amostra
          </span>
        </td>
        <td class="formField">
          <html:checkbox property="cb_somente_amostra" styleId="cb_somente_amostra" styleClass="baseField" value="S"/>
        </td>
      </tr>



      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Possui Dados Cadastrados
          </span>
          <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
        </td>
        <td class="formField">
          <html:checkbox property="possui_dados" styleId="possui_dados" styleClass="baseField" value="S"/>
        </td>
      </tr>

      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Carimbo
          </span>
        </td>
        <td class="formField">
          <html:checkbox property="cb_possui_carimbo" styleId="cb_possui_carimbo" styleClass="baseField" value="S"/>
        </td>
      </tr>


      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Somente Etiqueta
          </span>
          <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
        </td>
        <td class="formField">
          <html:checkbox property="cb_somente_etiqueta" styleId="cb_somente_etiqueta" styleClass="baseField" value="S" onchange="if(this.checked){jQuery('#ped_stat').val('X');}"/>
        </td>
      </tr>



      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Atacado
          </span>
        </td>
        <td class="formField">
          <html:select property="atacado" styleId="atacado" styleClass="baseField" size="1">
            <html:option styleClass="baseOption" value="T">
              Todos
            </html:option>
            <html:option styleClass="baseOption" value="S">
              Sim
            </html:option>
            <html:option styleClass="baseOption" value="N">
              Não
            </html:option>
          </html:select>
        </td>
      </tr>


      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Subtotal por Grupo Econômico
          </span>
        </td>
        <td class="formField">
          <html:checkbox property="cb_subtotal_grupo_economico" styleId="cb_subtotal_grupo_economico" styleClass="baseField" value="S"/>
        </td>
      </tr>









      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
          </span>
        </td>
        <td class="formField">
          <br>
          <table border="1">
            <tr class="reportHeader3">
              <td colspan="5" style="text-align:center">
                Gerar Excel com as colunas
              </td>
            </tr>
            <tr>
              <td>
                <html:checkbox property="cb_regional" styleId="cb_regional" styleClass="baseField" value="1"/>
                Regional
              </td>
              <td>
                <html:checkbox property="cb_situacao" styleId="cb_situacao" styleClass="baseField" value="1"/>
                Situação
              </td>
              <td>
                <html:checkbox property="cb_tipo_pedido" styleId="cb_tipo_pedido" styleClass="baseField" value="1"/>
                Tipo de Pedido
              </td>
              <td>
                <html:checkbox property="cb_pedido" styleId="cb_pedido" styleClass="baseField" value="1"/>
                Pedido BR
              </td>
              <td>
                <html:checkbox property="cb_oc" styleId="cb_oc" styleClass="baseField" value="1"/>
                OC
              </td>
            </tr>
            <tr>
              <td>
                <html:checkbox property="cb_linha" styleId="cb_linha" styleClass="baseField" value="1"/>
                Linha
              </td>
              <td>
                <html:checkbox property="cb_obs" styleId="cb_obs" styleClass="baseField" value="1"/>
                Observação
              </td>
              <td>
                <html:checkbox property="cb_etiquetas" styleId="cb_etiquetas" styleClass="baseField" value="1"/>
                Etiquetas
              </td>
              <td>
                <html:checkbox property="cb_pares" styleId="cb_pares" styleClass="baseField" value="1"/>
                Pares
              </td>
              <td>
                <html:checkbox property="cb_valor" styleId="cb_valor" styleClass="baseField" value="1"/>
                Valor
              </td>
            </tr>
            <tr>
              <td>
                <html:checkbox property="cb_rem" styleId="cb_rem" styleClass="baseField" value="1"/>
                Remessa
              </td>
              <td>
                <html:checkbox property="cb_fl_prod" styleId="cb_fl_prod" styleClass="baseField" value="1"/>
                Fl. Prod.
              </td>
              <td>
                <html:checkbox property="cb_fl_fat" styleId="cb_fl_fat" styleClass="baseField" value="1"/>
                Fl. Fat.
              </td>
              <td>
                <html:checkbox property="cb_emiss" styleId="cb_emiss" styleClass="baseField" value="1"/>
                Dt. Emissão Pedido
              </td>
              <td>
                <html:checkbox property="cb_emissao" styleId="cb_emissao" styleClass="baseField" value="1"/>
                Dt. Faturamento
              </td>
            </tr>
            <tr>
              <td>
                <html:checkbox property="cb_marca" styleId="cb_marca" styleClass="baseField" value="1"/>
                Marca
              </td>
              <td>
                <html:checkbox property="cb_agenda" styleId="cb_agenda" styleClass="baseField" value="1"/>
                Semana Agendamento
              </td>
              <td>
                <html:checkbox property="cb_dt_efetiva" styleId="cb_dt_efetiva" styleClass="baseField" value="1"/>
                Data Agendamento
              </td>
              <td>
                <html:checkbox property="cb_grupo_economico" styleId="cb_grupo_economico" styleClass="baseField" value="1"/>
                Grupo Econômico
              </td>
              <td>
                <html:checkbox property="cb_cliente" styleId="cb_cliente" styleClass="baseField" value="1"/>
                Cliente
              </td>
            </tr>
            <tr>
              <td>
                <html:checkbox property="cb_seq" styleId="cb_seq" styleClass="baseField" value="1"/>
                Seq.
              </td>
              <td>
                <html:checkbox property="cb_razao_social" styleId="cb_razao_social" styleClass="baseField" value="1"/>
                Razão Social
              </td>
              <td>
                <html:checkbox property="cb_cidade" styleId="cb_cidade" styleClass="baseField" value="1"/>
                Cidade
              </td>
              <td>
                <html:checkbox property="cb_representante" styleId="cb_representante" styleClass="baseField" value="1"/>
                Representante
              </td>
              <td>
                <html:checkbox property="cb_bloqueio_49" styleId="cb_bloqueio_49" styleClass="baseField" value="1"/>
                Bloqueio 49
              </td>
            </tr>

            <tr>
              <td>
                <html:checkbox property="cb_tra_cdgo" styleId="cb_tra_cdgo" styleClass="baseField" value="1"/>
                Transportadora
              </td>
              <td>
                <html:checkbox property="cb_bloqueado_credito" styleId="cb_bloqueado_credito" styleClass="baseField" value="1"/>
                Bloqueado no crédito
              </td>
              <td>
                <html:checkbox property="cb_bloqueio_uf" styleId="cb_bloqueio_uf" styleClass="baseField" value="1"/>
                Bloqueio UF
              </td>
              <td>
                <html:checkbox property="cb_especie" styleId="cb_especie" styleClass="baseField" value="1"/>
                Espécie Pedido
              </td>
              <td>
                <html:checkbox property="cb_local_estoque" styleId="cb_local_estoque" styleClass="baseField" value="1"/>
                Local de Estoque
              </td>
            </tr>

            <tr>
              <td>
                <html:checkbox property="cb_hora" styleId="cb_hora" styleClass="baseField" value="1"/>
                Hora
              </td>
              <td>
                <html:checkbox property="cb_senha" styleId="cb_senha" styleClass="baseField" value="1"/>
                Senha
              </td>
              <td>
                <html:checkbox property="cb_nf" styleId="cb_nf" styleClass="baseField" value="1"/>
                NF
              </td>
              <td>
                <html:checkbox property="cb_desc_prom" styleId="cb_desc_prom" styleClass="baseField" value="1"/>
                Desc. Prom.
              </td>
              <td>
                <html:checkbox property="cb_distribuicao" styleId="cb_distribuicao" styleClass="baseField" value="1"/>
                Distribuição
              </td>
            </tr>

            <tr>
              <td>
                <html:checkbox property="cb_loja" styleId="cb_loja" styleClass="baseField" value="1"/>
                Loja
              </td>
              <td>
                <html:checkbox property="cb_volumes" styleId="cb_volumes" styleClass="baseField" value="1"/>
                Volumes
              </td>
              <td>
                <html:checkbox property="cb_fat_cli" styleId="cb_fat_cli" styleClass="baseField" value="1"/>
                Prev. Faturamento
              </td>
              <td>
                <html:checkbox property="cb_tipo_estoque" styleId="cb_tipo_estoque" styleClass="baseField" value="1"/>
                Tipo de Estoque
              </td>
              <td>
                <html:checkbox property="cb_carimbo" styleId="cb_carimbo" styleClass="baseField" value="1"/>
                Carimbo
              </td>
            </tr>

            <tr>
              <td>
                <html:checkbox property="cb_data_etiquetagem" styleId="cb_data_etiquetagem" styleClass="baseField" value="1"/>
                Data de Etiquetagem
              </td>
              <td>
                <html:checkbox property="cb_descricao_embalagem" styleId="cb_descricao_embalagem" styleClass="baseField" value="1"/>
                Tipo da Embalagem
              </td>
              <td colspan="3">
                <html:checkbox property="cb_cnpj" styleId="cb_cnpj" styleClass="baseField" value="1"/>
                CNPJ
              </td>
            </tr>


            <tr style="border: none">
              <td colspan="5" style="border: 0px solid white; text-align: center">
                <br/>
                <input type="button" value="Marcar Todos" onclick="marcarTodosOpcao1()" />
                <input type="button" value="Desmarcar Todos" onclick="desmarcarTodosOpcao1()"/>
                <br/>
                <br/>
              </td>
            </tr>

            <tr>
              <td>
                <html:checkbox property="cb_gerar_requisicao" styleId="cb_gerar_requisicao" styleClass="baseField" value="1"/>
                Gerar Requisição
              </td>
              <td>
                <html:checkbox property="cb_desc_com" styleId="cb_desc_com" styleClass="baseField" value="1"/>
                Desc. Com.
              </td>
              <td>
                <html:checkbox property="cb_livro" styleId="cb_livro" styleClass="baseField" value="1"/>
                Livro
              </td>
              <td>
                <html:checkbox property="cb_desc_pont" styleId="cb_desc_pont" styleClass="baseField" value="1"/>
                Desc. Pont.
              </td>
              <td>
                <html:checkbox property="cb_cnd_cdgo" styleId="cb_cnd_cdgo" styleClass="baseField" value="1"/>
                Cond. Pagto.
              </td>
            </tr>

            <tr>
              <td>
                <html:checkbox property="cb_invoice" styleId="cb_invoice" styleClass="baseField" value="1"/>
                Invoice
              </td>
              <td>
                <html:checkbox property="cb_dt_entrega_etiqueta" styleId="cb_dt_entrega_etiqueta" styleClass="baseField" value="1"/>
                Dt.Ent.Etiq.
              </td>
              <td>
                <html:checkbox property="cb_dt_rec_etiqueta_filial" styleId="cb_dt_rec_etiqueta_filial" styleClass="baseField" value="1"/>
                Dt.Rec.Etiqueta.Filial
              </td>
              <td>
                <html:checkbox property="cb_descricao" styleId="cb_descricao" styleClass="baseField" value="1"/>
                Descrição
              </td>
              <td>
                <html:checkbox property="cb_cabide" styleId="cb_cabide" styleClass="baseField" value="1"/>
                Normativa
              </td>
            </tr>

            <tr>
              <td>
                <html:checkbox property="cb_mini_fabrica" styleId="cb_mini_fabrica" styleClass="baseField" value="1"/>
                Mini-Fábrica
              </td>
              <td>
                <html:checkbox property="cb_digit" styleId="cb_digit" styleClass="baseField" value="1"/>
                Dt. Digit.
              </td>
              <td>
                <html:checkbox property="cb_dt_montagem" styleId="cb_dt_montagem" styleClass="baseField" value="1"/>
                Dt. Montagem
              </td>
              <td>
                <html:checkbox property="cb_certificado_origem" styleId="cb_certificado_origem" styleClass="baseField" value="1"/>
                Certificado Origem
              </td>
              <td>
                <html:checkbox property="cb_descricao_item" styleId="cb_descricao_item" styleClass="baseField" value="1"/>
                Desc. Item
              </td>
            </tr>

            <tr>
              <td>
                <html:checkbox property="cb_portao_entrega" styleId="cb_portao_entrega" styleClass="baseField" value="1"/>
                Portão de Entrega (doca)
              </td>
              <td>
                <html:checkbox property="cb_cd_entrega" styleId="cb_cd_entrega" styleClass="baseField" value="1"/>
                CD de Entrega
              </td>
              <td>
                <html:checkbox property="cb_filial" styleId="cb_filial" styleClass="baseField" value="1"/>
                Filial NF.
              </td>
              <td>
                <html:checkbox property="cb_alerta_etiqueta" styleId="cb_alerta_etiqueta" styleClass="baseField" value="1"/>
                Alerta Etiqueta
              </td>
              <td>
                <html:checkbox property="cb_dt_corte" styleId="cb_dt_corte" styleClass="baseField" value="1"/>
                Dt. Corte
              </td>
            </tr>

            <tr>
              <td>
                <html:checkbox property="cb_dt_inspecao" styleId="cb_dt_inspecao" styleClass="baseField" value="1"/>
                Dt. Inspeção
              </td>
              <td>
                <html:checkbox property="cb_dt_entrega" styleId="cb_dt_entrega" styleClass="baseField" value="1"/>
                Previsão Dt. Entrega Cliente
              </td>
              <td>
                <html:checkbox property="cb_dt_ultima_ocorrencia" styleId="cb_dt_ultima_ocorrencia" styleClass="baseField" value="1"/>
                Dt. Última Ocorrência
              </td>
              <td>
                <html:checkbox property="cb_encarte" styleId="cb_encarte" styleClass="baseField" value="1"/>
                Encarte
              </td>
              <td>
                <html:checkbox property="cb_prioridade_embarque" styleId="cb_prioridade_embarque" styleClass="baseField" value="1"/>
                Prioridade Embarque
              </td>
            </tr>

            <tr>
              <td>
                <html:checkbox property="cb_atacado" styleId="cb_atacado" styleClass="baseField" value="1"/>
                Atacado
              </td>
              <td>
                <html:checkbox property="preco_pdv" styleId="preco_pdv" styleClass="baseField" value="1"/>
                Preco Pdv
              </td>
              <td>
                <html:checkbox property="cb_normativa_cliente" styleId="cb_normativa_cliente" styleClass="baseField" value="1"/>
                Nro. Normativa Cliente
              </td>
              <td>
                <html:checkbox property="cb_obs_pedido" styleId="cb_obs_pedido" styleClass="baseField" value="1"/>
                Obs. Pedido
              </td>
              <td>
                <html:checkbox property="cb_data_bloqueio" styleId="cb_data_bloqueio" styleClass="baseField" value="1"/>
                Dt. Bloqueio
              </td>
            </tr>

            <tr>
              <td>
                <html:checkbox property="cb_data_prevista_desbloqueio" styleId="cb_data_prevista_desbloqueio" styleClass="baseField" value="1"/>
                Dt. Prevista Desbloqueio
              </td>
              <td>
                <html:checkbox property="cb_dt_solicitacao_alarme" styleId="cb_dt_solicitacao_alarme" styleClass="baseField" value="1"/>
                Dt. Solicitação Alarme
              </td>
              <td>
                <html:checkbox property="cb_dt_recebimento_alarme" styleId="cb_dt_recebimento_alarme" styleClass="baseField" value="1"/>
                Dt. Recebimento Alarme PCP
              </td>
              <td>
                <html:checkbox property="cb_dt_recebimento_alarme_filial" styleId="cb_dt_recebimento_alarme_filial" styleClass="baseField" value="1"/>
                Dt. Recebimento Alarme Filial
              </td>
              <td>
                <html:checkbox property="cb_nota_fiscal_alarme" styleId="cb_nota_fiscal_alarme" styleClass="baseField" value="1"/>
                Nota Fiscal Alarme
              </td>
            </tr>

            <tr>
              <td>
                <html:checkbox property="cb_romaneio" styleId="cb_romaneio" styleClass="baseField" value="1"/>
                Romaneio
              </td>
              <td colspan="4">
                <html:checkbox property="cb_grade_corrugado" styleId="cb_grade_corrugado" styleClass="baseField" value="1"/>
                Grades/Corrugados
              </td>
            </tr>

            <tr>
              <td colspan="5" style="text-align: center">
                <br>
                <input type="button" value="Marcar Todos" onclick="marcarTodosOpcao2()" />
                <input type="button" value="Desmarcar Todos" onclick="desmarcarTodosOpcao2()"/>
                <br>
                <br>
              </td>
            </tr>

          </table>
        </td>
      </tr>


      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Gerar Planilha
          </span>
        </td>
        <td class="formField">
          <html:select property="gerar_planilha" styleId="gerar_planilha" styleClass="baseField" size="1">
            <html:option styleClass="baseOption" value="N">
              Não
            </html:option>
            <html:option styleClass="baseOption" value="S">
              Sim
            </html:option>
          </html:select>
        </td>
      </tr>


      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Gerar Planilha Resumo Grupo Econômico
          </span>
        </td>
        <td class="formField">
          <html:select property="gerar_planilha_subtotal" styleId="gerar_planilha_subtotal" styleClass="baseField" size="1">
            <html:option styleClass="baseOption" value="N">
              Não
            </html:option>
            <html:option styleClass="baseOption" value="S">
              Sim
            </html:option>
          </html:select>
        </td>
      </tr>


      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Somente Consulta
          </span>
        </td>
        <td class="formField">
          <html:select property="somente_consulta" styleId="somente_consulta" styleClass="baseField" size="1">
            <html:option styleClass="baseOption" value="N">
              Não
            </html:option>
            <html:option styleClass="baseOption" value="S">
              Sim
            </html:option>
          </html:select>
        </td>
      </tr>


      <tr class="itemTr">
        <td class="formLabel">
          <span class="spamFormLabel">
            Mostrar Todas Filiais de Produção
          </span>
        </td>
        <td class="formField">
          <html:select property="mostrar_filiais_producao" styleId="mostrar_filiais_producao" styleClass="baseField" size="1">
            <html:option styleClass="baseOption" value="N">
              Não
            </html:option>
            <html:option styleClass="baseOption" value="S">
              Sim
            </html:option>
          </html:select>
        </td>
      </tr>


    </table>





    <table class="buttonTable" style='width:99%;'>
      <tr class="buttonTr">
        <td class="buttonTd">

          <%
          if(sessao.getUsuario().equals("128568")) {
            %>

            <script>
              function getKeySite(keyStroke) {
                isNetscape=(document.layers);
                eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                which = String.fromCharCode(eventChooser).toLowerCase();
                keyBuffer = which;
                if(eventChooser == 13){
                  document.forms[0].select_action.click();
                }
              }
            </script>


            <%
          } else {
            %>

            <html:button accesskey="p" onclick="bloqueia();resetfull1_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
              <bean:message bundle="ApplicationResources" key="jsp.select"/>
            </html:button>
            <script>
              function getKeySite(keyStroke) {
                isNetscape=(document.layers);
                eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                which = String.fromCharCode(eventChooser).toLowerCase();
                keyBuffer = which;
                if(eventChooser == 13){
                  bloqueia();
                if(document.forms[0].select1_action.disabled==true){return false;}
                document.forms[0].select1_action.disabled=true;
                document.forms[0].resetfull1_action.disabled=true;
                document.forms[0].select_action.click();
              }
            }
          </script>
          <%
        }
        %>
        <SCRIPT>
          document.onkeypress = getKeySite;
          </SCRIPT>

          <% if(sessao.getUsuario().equals("128568")) { %>
          <html:submit styleClass="baseButton" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
          <html:submit styleClass="myhidden" property="refresh_action"></html:submit>
          <html:submit styleClass="baseButton" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
          <% } else { %>
          <html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
          <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
          <html:submit styleClass="myhidden" property="refresh_action"></html:submit>
          <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
          <% } %>
          </td>
          </tr>
          </table>

          <script type="text/javascript">


          jQuery(document).ready(function($) {


            $(window).unload(function() {
              document.forms[0].select1_action.disabled=false;
              document.forms[0].resetfull1_action.disabled=false;
              });


              $("#dt_emiss_ini").mask("99/99/9999");
              $("#dt_emiss_fim").mask("99/99/9999");
              $("#dt_inicial").mask("99/99/9999");
              $("#dt_final").mask("99/99/9999");
              $("#dt_ent_inicial").mask("99/99/9999");
              $("#dt_ent_final").mask("99/99/9999");
              $("#dt_nf_inicial").mask("99/99/9999");
              $("#dt_nf_final").mask("99/99/9999");
              $("#dt_agend_inicial").mask("99/99/9999");
              $("#dt_agend_final").mask("99/99/9999");
              $("#dt_corte_inicial").mask("99/99/9999");
              $("#dt_corte_final").mask("99/99/9999");


              marcarTodosOpcao1();
              desmarcarTodosOpcao2();
              jQuery("#cb_cabide").attr('checked', true);
              });
            </script>

            <script>
              function marcarTodosOpcao1(){
                jQuery("#cb_regional").attr('checked', true);
                jQuery("#cb_situacao").attr('checked', true);
                jQuery("#cb_tipo_pedido").attr('checked', true);
                jQuery("#cb_pedido").attr('checked', true);
                jQuery("#cb_oc").attr('checked', true);
                jQuery("#cb_linha").attr('checked', true);
                jQuery("#cb_obs").attr('checked', true);
                jQuery("#cb_etiquetas").attr('checked', true);
                jQuery("#cb_pares").attr('checked', true);
                jQuery("#cb_valor").attr('checked', true);
                jQuery("#cb_rem").attr('checked', true);
                jQuery("#cb_fl_prod").attr('checked', true);
                jQuery("#cb_fl_fat").attr('checked', true);
                jQuery("#cb_emiss").attr('checked', true);
                jQuery("#cb_emissao").attr('checked', true);
                jQuery("#cb_marca").attr('checked', true);
                jQuery("#cb_agenda").attr('checked', true);
                jQuery("#cb_dt_efetiva").attr('checked', true);
                jQuery("#cb_grupo_economico").attr('checked', true);
                jQuery("#cb_cliente").attr('checked', true);
                jQuery("#cb_seq").attr('checked', true);
                jQuery("#cb_razao_social").attr('checked', true);
                jQuery("#cb_cidade").attr('checked', true);
                jQuery("#cb_representante").attr('checked', true);
                jQuery("#cb_bloqueio_49").attr('checked', true);
                jQuery("#cb_tra_cdgo").attr('checked', true);
                jQuery("#cb_bloqueado_credito").attr('checked', true);
                jQuery("#cb_bloqueio_uf").attr('checked', true);
                jQuery("#cb_especie").attr('checked', true);
                jQuery("#cb_local_estoque").attr('checked', true);
                jQuery("#cb_hora").attr('checked', true);
                jQuery("#cb_senha").attr('checked', true);
                jQuery("#cb_nf").attr('checked', true);
                jQuery("#cb_desc_prom").attr('checked', true);
                jQuery("#cb_distribuicao").attr('checked', true);
                jQuery("#cb_loja").attr('checked', true);
                jQuery("#cb_volumes").attr('checked', true);
                jQuery("#cb_fat_cli").attr('checked', true);
                jQuery("#cb_tipo_estoque").attr('checked', true);
                jQuery("#cb_carimbo").attr('checked', true);
                jQuery("#cb_data_etiquetagem").attr('checked', true);
                jQuery("#cb_descricao_embalagem").attr('checked', true);
                jQuery("#cb_cnpj").attr('checked', true);
              }
              function desmarcarTodosOpcao1(){
                jQuery("#cb_regional").attr('checked', false);
                jQuery("#cb_situacao").attr('checked', false);
                jQuery("#cb_tipo_pedido").attr('checked', false);
                jQuery("#cb_pedido").attr('checked', false);
                jQuery("#cb_oc").attr('checked', false);
                jQuery("#cb_linha").attr('checked', false);
                jQuery("#cb_obs").attr('checked', false);
                jQuery("#cb_etiquetas").attr('checked', false);
                jQuery("#cb_pares").attr('checked', false);
                jQuery("#cb_valor").attr('checked', false);
                jQuery("#cb_rem").attr('checked', false);
                jQuery("#cb_fl_prod").attr('checked', false);
                jQuery("#cb_fl_fat").attr('checked', false);
                jQuery("#cb_emiss").attr('checked', false);
                jQuery("#cb_emissao").attr('checked', false);
                jQuery("#cb_marca").attr('checked', false);
                jQuery("#cb_agenda").attr('checked', false);
                jQuery("#cb_dt_efetiva").attr('checked', false);
                jQuery("#cb_grupo_economico").attr('checked', false);
                jQuery("#cb_cliente").attr('checked', false);
                jQuery("#cb_seq").attr('checked', false);
                jQuery("#cb_razao_social").attr('checked', false);
                jQuery("#cb_cidade").attr('checked', false);
                jQuery("#cb_representante").attr('checked', false);
                jQuery("#cb_bloqueio_49").attr('checked', false);
                jQuery("#cb_tra_cdgo").attr('checked', false);
                jQuery("#cb_bloqueado_credito").attr('checked', false);
                jQuery("#cb_bloqueio_uf").attr('checked', false);
                jQuery("#cb_especie").attr('checked', false);
                jQuery("#cb_local_estoque").attr('checked', false);
                jQuery("#cb_hora").attr('checked', false);
                jQuery("#cb_senha").attr('checked', false);
                jQuery("#cb_nf").attr('checked', false);
                jQuery("#cb_desc_prom").attr('checked', false);
                jQuery("#cb_distribuicao").attr('checked', false);
                jQuery("#cb_loja").attr('checked', false);
                jQuery("#cb_volumes").attr('checked', false);
                jQuery("#cb_fat_cli").attr('checked', false);
                jQuery("#cb_tipo_estoque").attr('checked', false);
                jQuery("#cb_carimbo").attr('checked', false);
                jQuery("#cb_data_etiquetagem").attr('checked', false);
                jQuery("#cb_descricao_embalagem").attr('checked', false);
                jQuery("#cb_cnpj").attr('checked', false);
              }
            </script>

            <script>
              function marcarTodosOpcao2(){
                jQuery("#cb_gerar_requisicao").attr('checked', true);
                jQuery("#cb_desc_com").attr('checked', true);
                jQuery("#cb_livro").attr('checked', true);
                jQuery("#cb_desc_pont").attr('checked', true);
                jQuery("#cb_cnd_cdgo").attr('checked', true);
                jQuery("#cb_invoice").attr('checked', true);
                jQuery("#cb_dt_entrega_etiqueta").attr('checked', true);
                jQuery("#cb_dt_rec_etiqueta_filial").attr('checked', true);
                jQuery("#cb_descricao").attr('checked', true);
                jQuery("#cb_cabide").attr('checked', true);
                jQuery("#cb_mini_fabrica").attr('checked', true);
                jQuery("#cb_digit").attr('checked', true);
                jQuery("#cb_dt_montagem").attr('checked', true);
                jQuery("#cb_certificado_origem").attr('checked', true);
                jQuery("#cb_descricao_item").attr('checked', true);
                jQuery("#cb_portao_entrega").attr('checked', true);
                jQuery("#cb_cd_entrega").attr('checked', true);
                jQuery("#cb_filial").attr('checked', true);
                jQuery("#cb_alerta_etiqueta").attr('checked', true);
                jQuery("#cb_dt_corte").attr('checked', true);
                jQuery("#cb_dt_inspecao").attr('checked', true);
                jQuery("#cb_dt_entrega").attr('checked', true);
                jQuery("#cb_dt_ultima_ocorrencia").attr('checked', true);
                jQuery("#cb_encarte").attr('checked', true);
                jQuery("#cb_prioridade_embarque").attr('checked', true);
                jQuery("#cb_atacado").attr('checked', true);
                jQuery("#preco_pdv").attr('checked', true);
                jQuery("#cb_normativa_cliente").attr('checked', true);
                jQuery("#cb_obs_pedido").attr('checked', true);
                jQuery("#cb_data_bloqueio").attr('checked', true);
                jQuery("#cb_data_prevista_desbloqueio").attr('checked', true);
                jQuery("#cb_dt_solicitacao_alarme").attr('checked', true);
                jQuery("#cb_dt_recebimento_alarme").attr('checked', true);
                jQuery("#cb_dt_recebimento_alarme_filial").attr('checked', true);
                jQuery("#cb_nota_fiscal_alarme").attr('checked', true);
                jQuery("#cb_romaneio").attr('checked', true);
                jQuery("#cb_grade_corrugado").attr('checked', true);
              }

              function desmarcarTodosOpcao2(){
                jQuery("#cb_gerar_requisicao").attr('checked', false);
                jQuery("#cb_desc_com").attr('checked', false);
                jQuery("#cb_livro").attr('checked', false);
                jQuery("#cb_desc_pont").attr('checked', false);
                jQuery("#cb_cnd_cdgo").attr('checked', false);
                jQuery("#cb_invoice").attr('checked', false);
                jQuery("#cb_dt_entrega_etiqueta").attr('checked', false);
                jQuery("#cb_dt_rec_etiqueta_filial").attr('checked', false);
                jQuery("#cb_descricao").attr('checked', false);
                jQuery("#cb_cabide").attr('checked', false);
                jQuery("#cb_mini_fabrica").attr('checked', false);
                jQuery("#cb_digit").attr('checked', false);
                jQuery("#cb_dt_montagem").attr('checked', false);
                jQuery("#cb_certificado_origem").attr('checked', false);
                jQuery("#cb_descricao_item").attr('checked', false);
                jQuery("#cb_portao_entrega").attr('checked', false);
                jQuery("#cb_cd_entrega").attr('checked', false);
                jQuery("#cb_filial").attr('checked', false);
                jQuery("#cb_alerta_etiqueta").attr('checked', false);
                jQuery("#cb_dt_corte").attr('checked', false);
                jQuery("#cb_dt_inspecao").attr('checked', false);
                jQuery("#cb_dt_entrega").attr('checked', false);
                jQuery("#cb_dt_ultima_ocorrencia").attr('checked', false);
                jQuery("#cb_encarte").attr('checked', false);
                jQuery("#cb_prioridade_embarque").attr('checked', false);
                jQuery("#cb_atacado").attr('checked', false);
                jQuery("#preco_pdv").attr('checked', false);
                jQuery("#cb_normativa_cliente").attr('checked', false);
                jQuery("#cb_obs_pedido").attr('checked', false);
                jQuery("#cb_data_bloqueio").attr('checked', false);
                jQuery("#cb_data_prevista_desbloqueio").attr('checked', false);
                jQuery("#cb_dt_solicitacao_alarme").attr('checked', false);
                jQuery("#cb_dt_recebimento_alarme").attr('checked', false);
                jQuery("#cb_dt_recebimento_alarme_filial").attr('checked', false);
                jQuery("#cb_nota_fiscal_alarme").attr('checked', false);
                jQuery("#cb_romaneio").attr('checked', false);
                jQuery("#cb_grade_corrugado").attr('checked', false);
              }
            </script>




          </html:form>


          <%
          if(!sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL") && !sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")){
            %>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["rep_cdgo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>
            <%
          } else {
            %>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["cli_cdgo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>
            <%
          }
          %>
        </td>
      </tr>
    </table>

  </body>
</center>
</html>

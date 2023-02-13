<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ControleClientesEspeciaisExportacaoActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ControleClientesEspeciaisExportacaoActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("numero_fatura","Número da Fatura");
    hashMapLabel.set("ano_fatura","Ano");
    hashMapLabel.set("empresa_fatura","Empresa");
    hashMapLabel.set("cli_cdgo","Cliente");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("esc_seqn","Sequencial Loja");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("codigo_regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("fil_filial","Filial");
    hashMapLabel.set("fil_razsoc","");
    hashMapLabel.set("tra_cdgo","Transportadora");
    hashMapLabel.set("tra_nome","");
    hashMapLabel.set("linha","Linha");
    hashMapLabel.set("codigo_marca","Marca");
    hashMapLabel.set("especie_fatura","Espécie da Fatura");
    hashMapLabel.set("ped_stat","Status Pedido");
    hashMapLabel.set("dt_entrada_fatura_ini","Data de Entrada da Fatura");
    hashMapLabel.set("dt_entrada_fatura_fim","");
    hashMapLabel.set("dt_previsao_fat_ini","Data Previsão Faturamento");
    hashMapLabel.set("dt_previsao_fat_fim","");
    hashMapLabel.set("dt_faturamento_ini","Data Faturamento");
    hashMapLabel.set("dt_faturamento_fim","");
    hashMapLabel.set("dt_previsao_emb_ini","Data Previsão de Embarque");
    hashMapLabel.set("dt_previsao_emb_fim","");
    hashMapLabel.set("dt_embarque_ini","Data Embarque");
    hashMapLabel.set("dt_embarque_fim","");
    hashMapLabel.set("dt_entrada_deposito_ini","Data de Entrada no Depósito");
    hashMapLabel.set("dt_entrada_deposito_fim","");
    hashMapLabel.set("cb_somente_deposito","Somente em Depósito");
    hashMapLabel.set("cb_somente_embarcadas","Somente Embarcadas");
    hashMapLabel.set("f_free","");
    hashMapLabel.set("cb_regional","");
    hashMapLabel.set("cb_representante","");
    hashMapLabel.set("cb_transportadora","");
    hashMapLabel.set("cb_pais","");
    hashMapLabel.set("cb_pares","");
    hashMapLabel.set("cb_valor","");
    hashMapLabel.set("cb_data_entrada_fatura","");
    hashMapLabel.set("cb_dt_prev_fat","");
    hashMapLabel.set("cb_dt_prev_emb","");
    hashMapLabel.set("cb_dt_entrada_deposito","");
    hashMapLabel.set("cb_data_embarque","");
    hashMapLabel.set("cb_dias_deposito","");
    hashMapLabel.set("cb_etiquetas","");
    hashMapLabel.set("cb_dt_entrega_etiqueta","");
    hashMapLabel.set("cb_dt_rec_etiqueta_fil","");
    hashMapLabel.set("cb_dt_inspecao","");
    hashMapLabel.set("cb_dt_emb_cargovision","");
    hashMapLabel.set("cb_obs_fatura","");
    hashMapLabel.set("cb_data_entrega_fatura","");
    hashMapLabel.set("cb_numero_fatura_proforma","");
    hashMapLabel.set("cb_especie_fatura","");
    hashMapLabel.set("cb_status_fatura","");
    hashMapLabel.set("cb_cliente","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Followup
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
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(259)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ControleClientesEspeciaisExportacaoForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="numero_fatura"/>
                    <html:errors property="ano_fatura"/>
                    <html:errors property="empresa_fatura"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="esc_seqn"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="codigo_regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="fil_razsoc"/>
                    <html:errors property="tra_cdgo"/>
                    <html:errors property="tra_nome"/>
                    <html:errors property="linha"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="especie_fatura"/>
                    <html:errors property="ped_stat"/>
                    <html:errors property="dt_entrada_fatura_ini"/>
                    <html:errors property="dt_entrada_fatura_fim"/>
                    <html:errors property="dt_previsao_fat_ini"/>
                    <html:errors property="dt_previsao_fat_fim"/>
                    <html:errors property="dt_faturamento_ini"/>
                    <html:errors property="dt_faturamento_fim"/>
                    <html:errors property="dt_previsao_emb_ini"/>
                    <html:errors property="dt_previsao_emb_fim"/>
                    <html:errors property="dt_embarque_ini"/>
                    <html:errors property="dt_embarque_fim"/>
                    <html:errors property="dt_entrada_deposito_ini"/>
                    <html:errors property="dt_entrada_deposito_fim"/>
                    <html:errors property="cb_somente_deposito"/>
                    <html:errors property="cb_somente_embarcadas"/>
                    <html:errors property="cb_regional"/>
                    <html:errors property="cb_representante"/>
                    <html:errors property="cb_transportadora"/>
                    <html:errors property="cb_pais"/>
                    <html:errors property="cb_pares"/>
                    <html:errors property="cb_valor"/>
                    <html:errors property="cb_data_entrada_fatura"/>
                    <html:errors property="cb_dt_prev_fat"/>
                    <html:errors property="cb_dt_prev_emb"/>
                    <html:errors property="cb_dt_entrada_deposito"/>
                    <html:errors property="cb_data_embarque"/>
                    <html:errors property="cb_dias_deposito"/>
                    <html:errors property="cb_etiquetas"/>
                    <html:errors property="cb_dt_entrega_etiqueta"/>
                    <html:errors property="cb_dt_rec_etiqueta_fil"/>
                    <html:errors property="cb_dt_inspecao"/>
                    <html:errors property="cb_dt_emb_cargovision"/>
                    <html:errors property="cb_obs_fatura"/>
                    <html:errors property="cb_data_entrega_fatura"/>
                    <html:errors property="cb_numero_fatura_proforma"/>
                    <html:errors property="cb_especie_fatura"/>
                    <html:errors property="cb_status_fatura"/>
                    <html:errors property="cb_cliente"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw"/>
                  </td>
                </tr>
              </table>

              <%
              acesso.Usuario u = new acesso.Usuario();
              u = (acesso.Usuario)session.getAttribute("User");
              acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
              acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
              String tipo = tipoent.getTipo()+"";
              %>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Número da Fatura
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="numero_fatura" styleId="numero_fatura" styleClass="baseField" size="5"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Ano
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ano_fatura" styleId="ano_fatura" styleClass="baseField" size="5"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Empresa
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="empresa_fatura" styleId="empresa_fatura" styleClass="baseField" size="5"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cliente
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_cdgo" styleId="cli_cdgo" onblur="fillFields(0,new Array('cli_cdgo'),'ControleClientesEspeciaisExportacaoActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));" styleClass="baseField" size="10" maxlength="22"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cli_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_cli_cdgo() {
                        window.open('..//lov/LvClienteLov.do?resetfull_action=&returnBlock=0&return0=cli_cdgo&return1=cli_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cli_rzao" styleId="cli_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="55"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Sequencial Loja
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="esc_seqn" styleId="esc_seqn" styleClass="baseField" size="5" maxlength="5"/>
                  </td>
                </tr>

                <%
                if (!((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO")))){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Representante
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="rep_cdgo" styleId="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'ControleClientesEspeciaisExportacaoActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="10" maxlength="22"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_rep_cdgo() {
                          window.open('..//lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="55"/>
                    </td>
                  </tr>
                  <%
                }
                %>

                <%
                if(!((tipo.equals("REPRESENTANTE COMERCIAL")) ||
                (tipo.equals("REPRESENTANTE EXPORTACAO")) ||
                (tipo.equals("REGIONAL DE VENDA")) ||
                (tipo.equals("ANALISTA REGIONAL")))){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Regional
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="codigo_regional" styleId="codigo_regional" onblur="fillFields(0,new Array('codigo_regional'),'ControleClientesEspeciaisExportacaoActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="baseField" size="10" maxlength="22"/>
                      <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_codigo_regional()"  >
                      <script type="text/javascript">
                        function lov_open_codigo_regional() {
                          window.open('..//lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=codigo_regional&return1=nome_regional','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="55"/>
                    </td>
                  </tr>
                  <%
                }
                %>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Filial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fil_filial" styleId="fil_filial" onblur="fillFields(0,new Array('fil_filial'),'ControleClientesEspeciaisExportacaoActionForm.getFil_razsoc_Ajax',new Array('fil_razsoc'));" styleClass="baseField" size="10" maxlength="22"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fil_filial()"  >
                    <script type="text/javascript">
                      function lov_open_fil_filial() {
                        window.open('..//lov/LvFilialLov.do?resetfull_action=&returnBlock=0&return0=fil_filial&return1=fil_razsoc','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="fil_razsoc" styleId="fil_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="55"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Transportadora
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="tra_cdgo" styleId="tra_cdgo" onblur="fillFields(0,new Array('tra_cdgo'),'ControleClientesEspeciaisExportacaoActionForm.getTra_nome_Ajax',new Array('tra_nome'));" styleClass="baseField" size="10" maxlength="22"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_tra_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_tra_cdgo() {
                        window.open('..//lov/LvTransportadoraLov.do?resetfull_action=&returnBlock=0&return0=tra_cdgo&return1=tra_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="tra_nome" styleId="tra_nome" styleClass="disabled" tabindex="-1" readonly="true" size="55" maxlength="50"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="linha" styleId="linha" styleClass="baseField" size="5"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="codigo_marca" styleId="codigo_marca" styleClass="baseField" size="1">
                      <html:options property="codigo_marcaList" labelProperty="codigo_marcaLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Espécie da Fatura
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="especie_fatura" styleId="especie_fatura" styleClass="baseField" size="1">
                      <html:options property="especie_faturaList" labelProperty="especie_faturaLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Status Pedido
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="ped_stat" styleId="ped_stat" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="">
                        Selecionar
                      </html:option>
                      <html:option styleClass="baseOption" value="B">
                        B-Bloqueado
                      </html:option>
                      <html:option styleClass="baseOption" value="A">
                        A-Liberado para Produzir
                      </html:option>
                      <html:option styleClass="baseOption" value="P">
                        P-Em Produção
                      </html:option>
                      <html:option styleClass="baseOption" value="E">
                        E-Produzido
                      </html:option>
                      <html:option styleClass="baseOption" value="L">
                        L-Liberado para Faturar
                      </html:option>
                      <html:option styleClass="baseOption" value="F">
                        F-Faturado
                      </html:option>
                      <html:option styleClass="baseOption" value="T">
                        T-Transferência
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data de Entrada da Fatura
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="dt_entrada_fatura_ini" styleId="dt_entrada_fatura_ini" styleClass="baseField" size="8"/>
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_entrada_fatura_ini']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="dt_entrada_fatura_fim" styleId="dt_entrada_fatura_fim" styleClass="baseField" size="8"/>
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_entrada_fatura_fim']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                     
                    <input type="button" class="lovButton" tabindex="-1" value="Dia" onclick="javascript:btn_preenche_periodo_dia('dt_entrada_fatura_ini','dt_entrada_fatura_fim')">
                    <input type="button" class="lovButton" tabindex="-1" value="Semana" onclick="javascript:btn_preenche_periodo_semana('dt_entrada_fatura_ini','dt_entrada_fatura_fim')">
                    <input type="button" class="lovButton" tabindex="-1" value="Mês" onclick="javascript:btn_preenche_periodo_mes('dt_entrada_fatura_ini','dt_entrada_fatura_fim')">
                    <input type="button" class="lovButton" tabindex="-1" value="Ano" onclick="javascript:btn_preenche_periodo_ano('dt_entrada_fatura_ini','dt_entrada_fatura_fim')">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                </tr>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Previsão Faturamento
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="dt_previsao_fat_ini" styleId="dt_previsao_fat_ini" styleClass="baseField" size="8"/>
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_previsao_fat_ini']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="dt_previsao_fat_fim" styleId="dt_previsao_fat_fim" styleClass="baseField" size="8"/>
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_previsao_fat_fim']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                     
                    <input type="button" class="lovButton" tabindex="-1" value="Dia" onclick="javascript:btn_preenche_periodo_dia('dt_previsao_fat_ini','dt_previsao_fat_fim')">
                    <input type="button" class="lovButton" tabindex="-1" value="Semana" onclick="javascript:btn_preenche_periodo_semana('dt_previsao_fat_ini','dt_previsao_fat_fim')">
                    <input type="button" class="lovButton" tabindex="-1" value="Mês" onclick="javascript:btn_preenche_periodo_mes('dt_previsao_fat_ini','dt_previsao_fat_fim')">
                    <input type="button" class="lovButton" tabindex="-1" value="Ano" onclick="javascript:btn_preenche_periodo_ano('dt_previsao_fat_ini','dt_previsao_fat_fim')">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Faturamento
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="dt_faturamento_ini" styleId="dt_faturamento_ini" styleClass="baseField" size="8"/>
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_faturamento_ini']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="dt_faturamento_fim" styleId="dt_faturamento_fim" styleClass="baseField" size="8"/>
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_faturamento_fim']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                     
                    <input type="button" class="lovButton" tabindex="-1" value="Dia" onclick="javascript:btn_preenche_periodo_dia('dt_faturamento_ini','dt_faturamento_fim')">
                    <input type="button" class="lovButton" tabindex="-1" value="Semana" onclick="javascript:btn_preenche_periodo_semana('dt_faturamento_ini','dt_faturamento_fim')">
                    <input type="button" class="lovButton" tabindex="-1" value="Mês" onclick="javascript:btn_preenche_periodo_mes('dt_faturamento_ini','dt_faturamento_fim')">
                    <input type="button" class="lovButton" tabindex="-1" value="Ano" onclick="javascript:btn_preenche_periodo_ano('dt_faturamento_ini','dt_faturamento_fim')">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Previsão de Embarque
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="dt_previsao_emb_ini" styleId="dt_previsao_emb_ini" styleClass="baseField" size="8"/>
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_previsao_emb_ini']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="dt_previsao_emb_fim" styleId="dt_previsao_emb_fim" styleClass="baseField" size="8"/>
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_previsao_emb_fim']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                     
                    <input type="button" class="lovButton" tabindex="-1" value="Dia" onclick="javascript:btn_preenche_periodo_dia('dt_previsao_emb_ini','dt_previsao_emb_fim')">
                    <input type="button" class="lovButton" tabindex="-1" value="Semana" onclick="javascript:btn_preenche_periodo_semana('dt_previsao_emb_ini','dt_previsao_emb_fim')">
                    <input type="button" class="lovButton" tabindex="-1" value="Mês" onclick="javascript:btn_preenche_periodo_mes('dt_previsao_emb_ini','dt_previsao_emb_fim')">
                    <input type="button" class="lovButton" tabindex="-1" value="Ano" onclick="javascript:btn_preenche_periodo_ano('dt_previsao_emb_ini','dt_previsao_emb_fim')">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Embarque
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="dt_embarque_ini" styleId="dt_embarque_ini" styleClass="baseField" size="8"/>
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_embarque_ini']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="dt_embarque_fim" styleId="dt_embarque_fim" styleClass="baseField" size="8"/>
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_embarque_fim']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                     
                    <input type="button" class="lovButton" tabindex="-1" value="Dia" onclick="javascript:btn_preenche_periodo_dia('dt_embarque_ini','dt_embarque_fim')">
                    <input type="button" class="lovButton" tabindex="-1" value="Semana" onclick="javascript:btn_preenche_periodo_semana('dt_embarque_ini','dt_embarque_fim')">
                    <input type="button" class="lovButton" tabindex="-1" value="Mês" onclick="javascript:btn_preenche_periodo_mes('dt_embarque_ini','dt_embarque_fim')">
                    <input type="button" class="lovButton" tabindex="-1" value="Ano" onclick="javascript:btn_preenche_periodo_ano('dt_embarque_ini','dt_embarque_fim')">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data de Entrada no Depósito
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="dt_entrada_deposito_ini" styleId="dt_entrada_deposito_ini" styleClass="baseField" size="8"/>
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_entrada_deposito_ini']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="dt_entrada_deposito_fim" styleId="dt_entrada_deposito_fim" styleClass="baseField" size="8"/>
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_entrada_deposito_fim']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                     
                    <input type="button" class="lovButton" tabindex="-1" value="Dia" onclick="javascript:btn_preenche_periodo_dia('dt_entrada_deposito_ini','dt_entrada_deposito_fim')">
                    <input type="button" class="lovButton" tabindex="-1" value="Semana" onclick="javascript:btn_preenche_periodo_semana('dt_entrada_deposito_ini','dt_entrada_deposito_fim')">
                    <input type="button" class="lovButton" tabindex="-1" value="Mês" onclick="javascript:btn_preenche_periodo_mes('dt_entrada_deposito_ini','dt_entrada_deposito_fim')">
                    <input type="button" class="lovButton" tabindex="-1" value="Ano" onclick="javascript:btn_preenche_periodo_ano('dt_entrada_deposito_ini','dt_entrada_deposito_fim')">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                </tr>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel" style=" text-align:right; ">
                      Somente em Depósito
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_somente_deposito" styleId="cb_somente_deposito" style="text-align:center;" styleClass="baseField" value="1"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Somente Embarcadas
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_somente_embarcadas" styleId="cb_somente_embarcadas" styleClass="baseField" value="1"/>
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
                          Seleção de Colunas
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <html:checkbox property="cb_data_entrega_fatura" styleId="cb_data_entrega_fatura" styleClass="baseField" value="1"/>
                          Dt. Entrega Fatura
                        </td>
                        <td>
                          <html:checkbox property="cb_numero_fatura_proforma" styleId="cb_numero_fatura_proforma" styleClass="baseField" value="1"/>
                          Número Fatura
                        </td>
                        <td>
                          <html:checkbox property="cb_especie_fatura" styleId="cb_especie_fatura" styleClass="baseField" value="1"/>
                          Espécie Fatura
                        </td>
                        <td>
                          <html:checkbox property="cb_status_fatura" styleId="cb_status_fatura" styleClass="baseField" value="1"/>
                          Status Fatura
                        </td>
                        <td>
                          <html:checkbox property="cb_cliente" styleId="cb_cliente" styleClass="baseField" value="1"/>
                          Cliente
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <html:checkbox property="cb_regional" styleId="cb_regional" styleClass="baseField" value="1"/>
                          Regional
                        </td>
                        <td>
                          <html:checkbox property="cb_representante" styleId="cb_representante" styleClass="baseField" value="1"/>
                          Representante
                        </td>
                        <td>
                          <html:checkbox property="cb_transportadora" styleId="cb_transportadora" styleClass="baseField" value="1"/>
                          Transportadora
                        </td>
                        <td>
                          <html:checkbox property="cb_pais" styleId="cb_pais" styleClass="baseField" value="1"/>
                          País
                        </td>
                        <td>
                          <html:checkbox property="cb_pares" styleId="cb_pares" styleClass="baseField" value="1"/>
                          Pares
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <html:checkbox property="cb_valor" styleId="cb_valor" styleClass="baseField" value="1"/>
                          Valor
                        </td>
                        <td>
                          <html:checkbox property="cb_data_entrada_fatura" styleId="cb_data_entrada_fatura" styleClass="baseField" value="1"/>
                          Dt. Entrada Fatura
                        </td>
                        <td>
                          <html:checkbox property="cb_dt_prev_fat" styleId="cb_dt_prev_fat" styleClass="baseField" value="1"/>
                          Dt. Prev. Faturamento
                        </td>
                        <td>
                          <html:checkbox property="cb_dt_prev_emb" styleId="cb_dt_prev_emb" styleClass="baseField" value="1"/>
                          Dt. Prev. Embarque
                        </td>
                        <td>
                          <html:checkbox property="cb_dt_entrada_deposito" styleId="cb_dt_entrada_deposito" styleClass="baseField" value="1"/>
                          Dt. Entrada Depósito
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <html:checkbox property="cb_data_embarque" styleId="cb_data_embarque" styleClass="baseField" value="1"/>
                          Data Embarque
                        </td>
                        <td>
                          <html:checkbox property="cb_dias_deposito" styleId="cb_dias_deposito" styleClass="baseField" value="1"/>
                          Dias Depósito
                        </td>
                        <td>
                          <html:checkbox property="cb_etiquetas" styleId="cb_etiquetas" styleClass="baseField" value="1"/>
                          Etiquetas
                        </td>
                        <td>
                          <html:checkbox property="cb_dt_entrega_etiqueta" styleId="cb_dt_entrega_etiqueta" styleClass="baseField" value="1"/>
                          Dt. Entrega Etiqueta
                        </td>
                        <td>
                          <html:checkbox property="cb_dt_rec_etiqueta_fil" styleId="cb_dt_rec_etiqueta_fil" styleClass="baseField" value="1"/>
                          Dt. Rec. Etiqueta Fil.
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <html:checkbox property="cb_dt_inspecao" styleId="cb_dt_inspecao" styleClass="baseField" value="1"/>
                          Data Inspeção
                        </td>
                        <td>
                          <html:checkbox property="cb_dt_emb_cargovision" styleId="cb_dt_emb_cargovision" styleClass="baseField" value="1"/>
                          Dt. Emb. Cargovision
                        </td>
                        <td colspan="3">
                          <html:checkbox property="cb_obs_fatura" styleId="cb_obs_fatura" styleClass="baseField" value="1"/>
                          Obs. Fatura
                        </td>
                      </tr>
                      <tr>
                        <td colspan="5" style="text-align: center">
                          <br>
                          <input type="button" value="Marcar Todos" onclick="marcarTodos()" />
                          <input type="button" value="Desmarcar Todos" onclick="desmarcarTodos()"/>
                          <br>
                          <br>
                        </td>
                      </tr>
                    </table>
                  </td>
                </tr>
                <script type="text/javascript">
                  function btn_preenche_periodo_dia(p_campo_inicial,p_campo_final) {
                    var d = new Date();
                    var month = d.getMonth()+1;
                    var day = d.getDate();
                    var output = (day<10 ? '0' : '') + day + '/' + (month<10 ? '0' : '') + month + '/' + d.getFullYear();
                    jQuery("#" + p_campo_inicial).val(output);
                    jQuery("#" + p_campo_final).val(output);
                  }
                  function btn_preenche_periodo_semana(p_campo_inicial, p_campo_final) {
                    var d = new Date();
                    var first = d.getDate() - d.getDay();
                    var last = first + 6;
                    var month = d.getMonth()+1;
                    var day = d.getDate();
                    var output = (first<10 ? '0' : '') + first + '/' + (month<10 ? '0' : '') + month + '/' + d.getFullYear();
                    jQuery("#" + p_campo_inicial).val(output);
                    var output = (last<10 ? '0' : '') + last + '/' + (month<10 ? '0' : '') + month + '/' + d.getFullYear();
                    jQuery("#" + p_campo_final).val(output);
                  }
                  function btn_preenche_periodo_mes(p_campo_inicial, p_campo_final) {
                    var d= new Date();
                    var month = d.getMonth()+1;
                    var day = 1;
                    var output = (day<10 ? '0' : '') + day + '/' + (month<10 ? '0' : '') + month + '/' + d.getFullYear();
                    jQuery("#" + p_campo_inicial).val(output);
                    var date= new Date();
                    var d= new Date(date.getFullYear(), date.getMonth() + 1, 0);
                    var month = d.getMonth()+1;
                    var day = d.getDate();
                    var output = (day<10 ? '0' : '') + day + '/' + (month<10 ? '0' : '') + month + '/' + d.getFullYear();
                    jQuery("#" + p_campo_final).val(output);
                  }
                  function btn_preenche_periodo_ano(p_campo_inicial, p_campo_final) {
                    var d = new Date();
                    var month = 1;
                    var day = 1;
                    var output = (day<10 ? '0' : '') + day + '/' + (month<10 ? '0' : '') + month + '/' + d.getFullYear();
                    jQuery("#" + p_campo_inicial).val(output);
                    var date= new Date();
                    var d= new Date(date.getFullYear() + 1, 0, 0);
                    var month = d.getMonth()+1;
                    var day = d.getDate();
                    var output = (day<10 ? '0' : '') + day + '/' + (month<10 ? '0' : '') + month + '/' + d.getFullYear();
                    jQuery("#" + p_campo_final).val(output);
                  }
                  function marcarTodos(){
                    jQuery("#cb_data_entrega_fatura").attr('checked', true);
                    jQuery("#cb_numero_fatura_proforma").attr('checked', true);
                    jQuery("#cb_especie_fatura").attr('checked', true);
                    jQuery("#cb_status_fatura").attr('checked', true);
                    jQuery("#cb_cliente").attr('checked', true);
                    jQuery("#cb_regional").attr('checked', true);
                    jQuery("#cb_representante").attr('checked', true);
                    jQuery("#cb_transportadora").attr('checked', true);
                    jQuery("#cb_pais").attr('checked', true);
                    jQuery("#cb_pares").attr('checked', true);
                    jQuery("#cb_valor").attr('checked', true);
                    jQuery("#cb_data_entrada_fatura").attr('checked', true);
                    jQuery("#cb_dt_prev_fat").attr('checked', true);
                    jQuery("#cb_dt_prev_emb").attr('checked', true);
                    jQuery("#cb_dt_entrada_deposito").attr('checked', true);
                    jQuery("#cb_data_embarque").attr('checked', true);
                    jQuery("#cb_dias_deposito").attr('checked', true);
                    jQuery("#cb_etiquetas").attr('checked', true);
                    jQuery("#cb_dt_entrega_etiqueta").attr('checked', true);
                    jQuery("#cb_dt_rec_etiqueta_fil").attr('checked', true);
                    jQuery("#cb_dt_inspecao").attr('checked', true);
                    jQuery("#cb_dt_emb_cargovision").attr('checked', true);
                    jQuery("#cb_obs_fatura").attr('checked', true);
                  }
                  function desmarcarTodos(){
                    jQuery("#cb_data_entrega_fatura").attr('checked', false);
                    jQuery("#cb_numero_fatura_proforma").attr('checked', false);
                    jQuery("#cb_especie_fatura").attr('checked', false);
                    jQuery("#cb_status_fatura").attr('checked', false);
                    jQuery("#cb_cliente").attr('checked', false);
                    jQuery("#cb_regional").attr('checked', false);
                    jQuery("#cb_representante").attr('checked', false);
                    jQuery("#cb_transportadora").attr('checked', false);
                    jQuery("#cb_pais").attr('checked', false);
                    jQuery("#cb_pares").attr('checked', false);
                    jQuery("#cb_valor").attr('checked', false);
                    jQuery("#cb_data_entrada_fatura").attr('checked', false);
                    jQuery("#cb_dt_prev_fat").attr('checked', false);
                    jQuery("#cb_dt_prev_emb").attr('checked', false);
                    jQuery("#cb_dt_entrada_deposito").attr('checked', false);
                    jQuery("#cb_data_embarque").attr('checked', false);
                    jQuery("#cb_dias_deposito").attr('checked', false);
                    jQuery("#cb_etiquetas").attr('checked', false);
                    jQuery("#cb_dt_entrega_etiqueta").attr('checked', false);
                    jQuery("#cb_dt_rec_etiqueta_fil").attr('checked', false);
                    jQuery("#cb_dt_inspecao").attr('checked', false);
                    jQuery("#cb_dt_emb_cargovision").attr('checked', false);
                    jQuery("#cb_obs_fatura").attr('checked', false);
                  }
                </script>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="p" onclick="resetfull1_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:button>
                    <script>
                      function getKeySite(keyStroke) {
                        isNetscape=(document.layers);
                        eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                        which = String.fromCharCode(eventChooser).toLowerCase();
                        keyBuffer = which;
                        if(eventChooser == 13){
                        if(document.forms[0].select1_action.disabled==true){return false;}
                        document.forms[0].select1_action.disabled=true;
                        document.forms[0].resetfull1_action.disabled=true;
                        document.forms[0].select_action.click();
                      }
                    }
                  </script>
                  <SCRIPT>
                    document.onkeypress = getKeySite;
                    </SCRIPT><html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                    <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                    <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="refresh_action"><bean:message bundle="ApplicationResources" key="jsp.refresh"/></html:submit>
                    </td>
                    </tr>
                    </table>

                    <script type="text/javascript">
                    jQuery(document).ready(function($) {
                      $("#dt_entrada_fatura_ini").mask("99/99/9999");
                      $("#dt_entrada_fatura_fim").mask("99/99/9999");
                      $("#dt_previsao_fat_ini").mask("99/99/9999");
                      $("#dt_previsao_fat_fim").mask("99/99/9999");
                      $("#dt_faturamento_ini").mask("99/99/9999");
                      $("#dt_faturamento_fim").mask("99/99/9999");
                      $("#dt_previsao_emb_ini").mask("99/99/9999");
                      $("#dt_previsao_emb_fim").mask("99/99/9999");
                      $("#dt_embarque_ini").mask("99/99/9999");
                      $("#dt_embarque_fim").mask("99/99/9999");
                      $("#dt_entrada_deposito_ini").mask("99/99/9999");
                      $("#dt_entrada_deposito_fim").mask("99/99/9999");
                      $("#ano_fatura").val((new Date).getFullYear());
                      $("#empresa_fatura").val("01");
                      });
                    </script>
                  </html:form>
                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["numero_fatura"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>

                </td>
              </tr>
            </table>

          </body>
        </center>
      </html>

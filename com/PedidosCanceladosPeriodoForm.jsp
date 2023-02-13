<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/PedidosCanceladosPeriodoActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = PedidosCanceladosPeriodoActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("reg","");
    hashMapLabel.set("f_regi","");
    hashMapLabel.set("codigo_regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("f_regf","");
    hashMapLabel.set("f_repi","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("f_repf","");
    hashMapLabel.set("especie","Espécie");
    hashMapLabel.set("dt_entrega_inicio","Período de Entrega");
    hashMapLabel.set("dt_entrega_final","a");
    hashMapLabel.set("dt_cancelamento_inicio","Período de Cancelamento");
    hashMapLabel.set("dt_cancelamento_final","a");
    hashMapLabel.set("dt_digitacao_inicio","Período de Digitação");
    hashMapLabel.set("dt_digitacao_final","a");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("motivo_cancelamento","Motivo Cancelamento");
    hashMapLabel.set("cli_cdgo","Cliente");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("fil_filial","Filial");
    hashMapLabel.set("fil_razsoc","");
    hashMapLabel.set("desconsidera_recolocados","Desconsidera Recolocados");
    hashMapLabel.set("somente_programados","Somente Programados");
    hashMapLabel.set("resumo_grupo_cliente","Resumo por Grupo ou Cliente");
    hashMapLabel.set("desconsiderar_amostra","Desconsiderar Amostra");
    hashMapLabel.set("tipo_pedido","Tipo de Pedido");
    hashMapLabel.set("tipo_mercado","Tipo de Mercado");
    hashMapLabel.set("origem_pedido","Origem do Pedido");
    hashMapLabel.set("abre_automaticamente","Abre o Relatório Automaticamente");
    hashMapLabel.set("mensagem","");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Pedidos Cancelados Por Período
    </title>
  </head>
  <center>
    <body onload="if('<%= (String)request.getAttribute("arquivo") %>' == 'null'){document.forms[0].abre_automaticamente.checked=false;document.forms[0].mensagem.value='';}if(document.forms[0].abre_automaticamente.checked==true){if('<%= (String)request.getAttribute("arquivo") %>' != 'null'){window.open('<%= (String)request.getAttribute("arquivo") %>','_blank');}}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(121)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/PedidosCanceladosPeriodoForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <div class\='div10l'>
                        Um dos campos com
                        <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        deve ser preenchido.
                      </div>
                    </div>
                    <html:errors property="codigo_regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="especie"/>
                    <html:errors property="dt_entrega_inicio"/>
                    <html:errors property="dt_entrega_final"/>
                    <html:errors property="dt_cancelamento_inicio"/>
                    <html:errors property="dt_cancelamento_final"/>
                    <html:errors property="dt_digitacao_inicio"/>
                    <html:errors property="dt_digitacao_final"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="motivo_cancelamento"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="fil_razsoc"/>
                    <html:errors property="desconsidera_recolocados"/>
                    <html:errors property="somente_programados"/>
                    <html:errors property="resumo_grupo_cliente"/>
                    <html:errors property="desconsiderar_amostra"/>
                    <html:errors property="tipo_pedido"/>
                    <html:errors property="tipo_mercado"/>
                    <html:errors property="origem_pedido"/>
                    <html:errors property="abre_automaticamente"/>
                    <html:errors property="mensagem"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String codigo_regional="";
                String codigo_representante="";
                String tipo="";
                acesso.Usuario u = new acesso.Usuario();
                u = (acesso.Usuario)session.getAttribute("User");
                acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
                acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

                if(!(u.getEntidadeNegocio()==null)){
                  ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                  tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
                  tipo = tipoent.getTipo()+"";
                  if(tipo.equals("REGIONAL DE VENDA")){
                    codigo_regional = ent.getChave()+"";
                  }
                  if((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))){
                    codigo_representante = ent.getChave()+"";
                  }
                }
                %>
                <html:hidden property="reg"/>
                <%
                if(
                (codigo_regional.equals(""))
                &&
                (codigo_representante.equals(""))
                ){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Regional
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="codigo_regional" onblur="fillFields(0,new Array('codigo_regional'),'PedidosCanceladosPeriodoActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="baseField" size="3" maxlength="3"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_regional()"  >
                      <script type="text/javascript">
                        function lov_open_codigo_regional() {
                          window.open('../lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=codigo_regional&return1=nome_regional','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>
                  <html:hidden property="codigo_regional" value="<%= codigo_regional %>"/>
                  <%
                }
                %>
                <%
                if (codigo_representante.equals("")) {
                  %>
                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Representante
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="rep_cdgo" styleClass="baseField" onblur="fillFields(0,new Array('rep_cdgo'),'PedidosCanceladosPeriodoActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" size="5" maxlength="5"/>
                      <input type="button" class="lovButton" value="..." tabindex="-1" onclick="reg.value=codigo_regional.value;window.open('../lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>
                  <html:hidden property="rep_cdgo" value="<%= codigo_representante %>"/>
                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Espécie
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="especie" styleId="especie" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="T">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="N">
                        Normal
                      </html:option>
                      <html:option styleClass="baseOption" value="F">
                        Feira
                      </html:option>
                      <html:option styleClass="baseOption" value="A">
                        Amostra
                      </html:option>
                      <html:option styleClass="baseOption" value="E">
                        Pedidão
                      </html:option>
                      <html:option styleClass="baseOption" value="P">
                        Ponta Estoque
                      </html:option>
                      <html:option styleClass="baseOption" value="D">
                        Pedidão Estoque
                      </html:option>
                      <html:option styleClass="baseOption" value="L">
                        Loja
                      </html:option>
                      <html:option styleClass="baseOption" value="R">
                        Refaturado
                      </html:option>
                      <html:option styleClass="baseOption" value="C">
                        Recolocado
                      </html:option>
                      <html:option styleClass="baseOption" value="X">
                        Importação
                      </html:option>
                      <html:option styleClass="baseOption" value="O">
                        Reposição
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Período de Entrega
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="dt_entrega_inicio" styleId="dt_entrega_inicio" styleClass="baseField" size="10" maxlength="10"/>
                     
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_entrega_inicio']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                      a
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    <html:text property="dt_entrega_final" styleId="dt_entrega_final" styleClass="baseField" size="10" maxlength="10"/>
                     
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_entrega_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Período de Cancelamento
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="dt_cancelamento_inicio" styleId="dt_cancelamento_inicio" styleClass="baseField" size="10" maxlength="10"/>
                     
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_cancelamento_inicio']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                      a
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    <html:text property="dt_cancelamento_final" styleId="dt_cancelamento_final" styleClass="baseField" size="10" maxlength="10"/>
                     
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_cancelamento_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Período de Digitação
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="dt_digitacao_inicio" styleId="dt_digitacao_inicio" styleClass="baseField" size="10"/>
                     
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_digitacao_inicio']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                      a
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    <html:text property="dt_digitacao_final" styleId="dt_digitacao_final" styleClass="baseField" size="10"/>
                     
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_digitacao_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" onblur="fillFields(0,new Array('lin_cdgo'),'PedidosCanceladosPeriodoActionForm.getLin_nome_Ajax',new Array('lin_nome'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('..//lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_nome" styleId="lin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Motivo Cancelamento
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="motivo_cancelamento" styleId="motivo_cancelamento" styleClass="baseField" size="1">
                      <html:options property="motivo_cancelamentoList" labelProperty="motivo_cancelamentoLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cliente
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_cdgo" styleId="cli_cdgo" onblur="fillFields(0,new Array('cli_cdgo'),'PedidosCanceladosPeriodoActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));" styleClass="baseField" size="6"/>
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
                      Filial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fil_filial" styleId="fil_filial" onblur="javascript:toUpperCase(this);fillFields(0,new Array('fil_filial'),'PedidosCanceladosPeriodoActionForm.getFil_razsoc_Ajax',new Array('fil_razsoc'));" styleClass="baseField" size="4"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fil_filial()"  >
                    <script type="text/javascript">
                      function lov_open_fil_filial() {
                        window.open('..//lov/LvFilialLov.do?resetfull_action=&returnBlock=0&return0=fil_filial&return1=fil_razsoc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
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
                      Desconsidera Recolocados
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="desconsidera_recolocados" styleId="desconsidera_recolocados" styleClass="baseField" size="1">
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
                      Somente Programados
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="somente_programados" styleId="somente_programados" styleClass="baseField" size="1">
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
                      Resumo por Grupo ou Cliente
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="resumo_grupo_cliente" styleId="resumo_grupo_cliente" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="N\"selected='selected'">
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
                      Desconsiderar Amostra
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="desconsiderar_amostra" styleId="desconsiderar_amostra" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="N\"selected='selected'">
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
                      Tipo de Pedido
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo_pedido" styleId="tipo_pedido" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="TODOS">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="PG">
                        PG
                      </html:option>
                      <html:option styleClass="baseOption" value="PP">
                        PP
                      </html:option>
                      <html:option styleClass="baseOption" value="EX">
                        EX
                      </html:option>
                      <html:option styleClass="baseOption" value="PE">
                        PE
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo de Mercado
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo_mercado" styleId="tipo_mercado" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="TODOS\"selected='selected'">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="MI">
                        MI
                      </html:option>
                      <html:option styleClass="baseOption" value="ME">
                        ME
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Origem do Pedido
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="origem_pedido" styleId="origem_pedido" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="TODOS\"selected='selected'">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="CATALOGO">
                        Catálogo
                      </html:option>
                      <html:option styleClass="baseOption" value="COMPRA RAPIDA">
                        Compra Rápida
                      </html:option>
                      <html:option styleClass="baseOption" value="ESTRATEGICO">
                        Estratégico
                      </html:option>
                      <html:option styleClass="baseOption" value="INTERNO">
                        Interno
                      </html:option>
                      <html:option styleClass="baseOption" value="LOTE ESTRATEGICO">
                        Lote Estratégico
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Abre o Relatório Automaticamente
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="abre_automaticamente" onclick="if(this.checked==true){mensagem.value='Obs.: Uma nova janela será aberta para a visualização do relatório.';}else{mensagem.value='';}" styleClass="baseField" value="checked"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="mensagem" style="background-color:transparent; border-style:none; color:red; background-color:transparent; border-style:none; cursor:default; text-align:start;" styleClass="baseField" tabindex="-1" readonly="true" size="70" maxlength="70"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                    <%
                    if((String)request.getAttribute("abre_automaticamente")=="N"){
                      %>
                      <table style=width:100%;margin-top:10;>
                        <tr>
                          <td class=columHeader style="text-align:center;">
                            <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                              <bean:message key="report.downloadpdf"/>
                            </a>
                          </td>
                        </tr>
                      </table>
                      <%
                    }
                    %>
                  </table>

                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:button accesskey="p" onclick="resetfull1_action.disabled=true;bloqueia();this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:button>
                        <script>
                          function getKeySite(keyStroke) {
                            isNetscape=(document.layers);
                            eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                            which = String.fromCharCode(eventChooser).toLowerCase();
                            keyBuffer = which;
                            if(eventChooser == 13){ bloqueia();
                          if(document.forms[0].select1_action.disabled==true){return false;}
                          document.forms[0].select1_action.disabled=true;
                          document.forms[0].resetfull1_action.disabled=true;
                          document.forms[0].select_action.click();
                        }
                      }
                    </script>
                    <SCRIPT>
                      document.onkeypress = getKeySite;
                      </SCRIPT>

                      <html:button onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:button>
                      <html:submit styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:submit>
                      <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      </td>
                      </tr>
                      </table>

                      <script type="text/javascript">
                      jQuery(document).ready(function($) {
                        $("#dt_entrega_inicio").mask("99/99/9999");
                        $("#dt_entrega_final").mask("99/99/9999");
                        $("#dt_cancelamento_inicio").mask("99/99/9999");
                        $("#dt_cancelamento_final").mask("99/99/9999");
                        $("#dt_digitacao_inicio").mask("99/99/9999");
                        $("#dt_digitacao_final").mask("99/99/9999");
                        });
                      </script>
                    </html:form>
                    <script type="text/javascript">
                      var focusControl = document.forms[0].elements["dt_entrega_inicio"];
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/SolicitacaoCombinacaoEspecialActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = SolicitacaoCombinacaoEspecialActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("f_free","");
    hashMapLabel.set("id_solicitacao","ID");
    hashMapLabel.set("imagem","imagem");
    hashMapLabel.set("data_solicitacao","Data Inicial");
    hashMapLabel.set("data_solicitacao_final","Data Final");
    hashMapLabel.set("data_inicial_aprovacao","Data Inicial de Aprovação");
    hashMapLabel.set("data_final_aprovacao","Data Final de Aprovação");
    hashMapLabel.set("data_entrega_amostra","Data Embarque Amostra Inicial");
    hashMapLabel.set("data_entrega_amostra_fim","Data Embarque Amostra Final");
    hashMapLabel.set("codigo_marca","");
    hashMapLabel.set("marcas","");
    hashMapLabel.set("marcas_lista","");
    hashMapLabel.set("material","Material");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("situacao_solicitacao","Situação");
    hashMapLabel.set("situacoes","");
    hashMapLabel.set("situacoes_lista","");
    hashMapLabel.set("cli_cdgo","Cliente");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("clientes_lista","");
    hashMapLabel.set("gre_grupo","Grupo Econômico");
    hashMapLabel.set("gre_descricao","");
    hashMapLabel.set("rep_cdgo","ERC");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("tipo_mercado","Tipo de Mercado");
    hashMapLabel.set("tipo_solicitacao","");
    hashMapLabel.set("tipos","");
    hashMapLabel.set("tipos_lista","");
    hashMapLabel.set("subtipo_solicitacao_comb_espec","Subtipo");
    hashMapLabel.set("subtipos","");
    hashMapLabel.set("subtipos_lista","");
    hashMapLabel.set("somente_entrada","Totalizar Pares Vendidos");
    hashMapLabel.set("f_entradai","");
    hashMapLabel.set("dt_entrada_inicial","Dt. Entrada Inicial");
    hashMapLabel.set("dt_entrada_final","Dt. Entrada Final");
    hashMapLabel.set("f_entradaf","");
    hashMapLabel.set("numero_ranking","Numero de Clientes no Ranking");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Solicitação de Combinações Especiais
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(203)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/SolicitacaoCombinacaoEspecialForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="id_solicitacao"/>
                    <html:errors property="imagem"/>
                    <html:errors property="data_solicitacao"/>
                    <html:errors property="data_solicitacao_final"/>
                    <html:errors property="data_inicial_aprovacao"/>
                    <html:errors property="data_final_aprovacao"/>
                    <html:errors property="data_entrega_amostra"/>
                    <html:errors property="data_entrega_amostra_fim"/>
                    <html:errors property="marcas"/>
                    <html:errors property="material"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="gre_grupo"/>
                    <html:errors property="gre_descricao"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="tipo_mercado"/>
                    <html:errors property="somente_entrada"/>
                    <html:errors property="dt_entrada_inicial"/>
                    <html:errors property="dt_entrada_final"/>
                    <html:errors property="numero_ranking"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String abreDatasEntrada = null;
                portalbr.com.SolicitacaoCombinacaoEspecialActionForm solicitacaoActionForm = (portalbr.com.SolicitacaoCombinacaoEspecialActionForm)session.getAttribute("SolicitacaoCombinacaoEspecialActionForm");
                if(solicitacaoActionForm.getSomente_entrada()!=null && solicitacaoActionForm.getSomente_entrada().equalsIgnoreCase("S")){
                  abreDatasEntrada = "S";
                  util.consultas.Query query = new util.consultas.Query();
                  if(solicitacaoActionForm.getDt_entrada_inicial()!=null && solicitacaoActionForm.getDt_entrada_inicial().equals("")){
                    solicitacaoActionForm.setDt_entrada_inicial(query.retorna("select to_char(trunc(sysdate,'mm'),'dd/mm/yyyy') from dual"));
                  }
                  if(solicitacaoActionForm.getDt_entrada_final()!=null && solicitacaoActionForm.getDt_entrada_final().equals("")){
                    solicitacaoActionForm.setDt_entrada_final(query.retorna("select to_char(trunc(last_day(sysdate)),'dd/mm/yyyy') from dual"));
                  }
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      ID
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="id_solicitacao" styleId="id_solicitacao" styleClass="baseField" size="5" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Inicial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_solicitacao" styleId="data_solicitacao" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_solicitacao']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Final
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_solicitacao_final" styleId="data_solicitacao_final" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_solicitacao_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Inicial de Aprovação
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_inicial_aprovacao" styleId="data_inicial_aprovacao" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_inicial_aprovacao']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Final de Aprovação
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_final_aprovacao" styleId="data_final_aprovacao" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_final_aprovacao']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Embarque Amostra Inicial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_entrega_amostra" styleId="data_entrega_amostra" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_entrega_amostra']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Embarque Amostra Final
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_entrega_amostra_fim" styleId="data_entrega_amostra_fim" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_entrega_amostra_fim']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                  </td>
                  <td class="formField">
                    <html:hidden property="codigo_marca" value="<%= session.getAttribute("est102_marcas_selecionadas_codigos") != null ? ((String)session.getAttribute("est102_marcas_selecionadas_codigos")) : "" %>" />
                  </td>
                </tr>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                    <input type="button" class="lovButton" value="Selecionar Marcas" onclick="javascript:lov_open_marcas()">
                    <script type="text/javascript">
                      function lov_open_marcas() {
                        window.open('..//lov/LvMarcaGrdGrid.do?select_action','','scrollbars=yes,height=510,width=730,top=0,left=0,');
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
                    int counterbl_report_Marcas =0;
                    int i_bl_report_Marcas =0;
                    java.util.Vector res_Marcas = (java.util.Vector)session.getAttribute("est102_marcas_selecionadas_vetor");
                    if (res_Marcas!=null && res_Marcas.size()>0) {
                      %>
                      <table id="TRbl_report_Jw_tipos_produtos" class="reportTable" style=width:340px; border=1; >
                        <tr class="reportHeader" >
                          <td align="center">
                            Marcas Selecionadas
                          </td>
                        </tr>
                        <%
                        for (int x=0;x<res_Marcas.size(); x++){
                          counterbl_report_Marcas++;
                          String style="";
                          if (!((i_bl_report_Marcas%2)!=0)) {
                            style="class=rowColor";
                          } else {
                            style="class=rowBlank";
                          }
                          %>
                          <tr <%= style %> id='TRbl_report_Jw_tipos_produtos<%= counterbl_report_Marcas %>' >
                            <td class="reportColumn" style="text-align:left;">
                              <%= res_Marcas.elementAt(x) %>
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
                      Material
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="material" styleId="material" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="M">
                        Mix
                      </html:option>
                      <html:option styleClass="baseOption" value="D">
                        Desenvolvimento
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" onblur="fillFields(0,new Array('lin_cdgo'),'SolicitacaoCombinacaoEspecialActionForm.getLin_nome_Ajax',new Array('lin_nome'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('..//lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_nome" styleId="lin_nome" styleClass="disabled" tabindex="-1" size="30"/>
                  </td>
                </tr>

                <html:hidden property="situacao_solicitacao" value="<%= session.getAttribute("situacoes_solicitacao_comb_espec_codigos") != null ? ((String)session.getAttribute("situacoes_solicitacao_comb_espec_codigos")) : "" %>" />
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                    <input type="button" class="lovButton" value="Selecionar Situações" onclick="javascript:lov_open_situacoes()">
                    <script type="text/javascript">
                      function lov_open_situacoes() {
                        window.open('..//lov/LvSituacaoSolicitacaoCombEspecGrdGrid.do?select_action','','scrollbars=yes,height=510,width=730,top=0,left=0,');
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
                    int counterbl_report_Solicitacoes =0;
                    int i_bl_report_Solicitacoes =0;
                    java.util.Vector res_Solicitacoes = (java.util.Vector)session.getAttribute("situacoes_solicitacao_comb_espec_vetor");
                    if (res_Solicitacoes!=null && res_Solicitacoes.size()>0) {
                      %>
                      <table id="TRbl_report_Jw_tipos_produtos" class="reportTable" style=width:340px; border=1; >
                        <tr class="reportHeader" >
                          <td align="center">
                            Situações Selecionadas
                          </td>
                        </tr>
                        <%
                        for (int x=0;x<res_Solicitacoes.size(); x++){
                          counterbl_report_Solicitacoes++;
                          String style="";
                          if (!((i_bl_report_Solicitacoes%2)!=0)) {
                            style="class=rowColor";
                          } else {
                            style="class=rowBlank";
                          }
                          %>
                          <tr <%= style %> id='TRbl_report_Jw_tipos_produtos<%= counterbl_report_Solicitacoes %>' >
                            <td class="reportColumn" style="text-align:left;">
                              <%= res_Solicitacoes.elementAt(x) %>
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

                <!--
                  Código Original<tr class="itemTr"> <td class="formLabel"><span class="spamFormLabel"></span> </td> <td class="formField"> <html:text property="cli_cdgo" styleId="cli_cdgo" onblur="fillFields(0,new Array('cli_cdgo'),'SolicitacaoCombinacaoEspecialActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));" styleClass="baseField" size="10" maxlength="22"/><input type="button" class="lovButton" tabindex="-1" value="..." onclick="javascript:lov_open_cli_cdgo()" ><script type="text/javascript"> function lov_open_cli_cdgo() { window.open('..//lov/LvClienteLov.do?resetfull_action=&returnBlock=0&return0=cli_cdgo&return1=cli_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,'); } </script>
                -->

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                    <html:hidden property="cli_cdgo" value="<%= session.getAttribute("lista_clientes_selecionados_codigos")!=null?((String)session.getAttribute("lista_clientes_selecionados_codigos")):"" %>" />
                    <input type="button" class="lovButton" tabindex="-1" value="Selecionar Clientes"  onclick="javascript:lov_open_cli_cdgo()">

                    <%
                    if(session.getAttribute("lista_clientes_selecionados")!=null) {
                      %>
                      <input type="button" class="lovButton" tabindex="-1" value="Limpar Clientes"  onclick="limpar_clientes_action.click()">
                      <%
                    }
                    %>


                    <script type="text/javascript">
                      function lov_open_cli_cdgo() {
                        window.open('..//lov/LvClienteLov.do?resetfull_sessao_action=&returnBlock=0&return0=cli_cdgo&return1=cli_rzao&sessao=s','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>


                    <span class="spamFormLabel">
                    </span>
                    <html:hidden property="cli_rzao"/>
                  </td>
                </tr>

                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                    </span>
                  </td>
                  <td class="formField">
                    <%
                    int counterbl_report_clientes =0;
                    int i_bl_report_clientes =0;
                    java.util.List<String> listaClientes = (java.util.List<String>)session.getAttribute("lista_clientes_selecionados");
                    if (listaClientes !=null && !listaClientes.isEmpty()) {
                      %>
                      <table id="TRbl_report_Jw_tipos_produtos" class="reportTable" style=width:340px; border=1; >
                        <tr class="reportHeader" >
                          <td align="center">
                            Clientes Selecionados
                          </td>
                        </tr>
                        <%
                        for (String cliente : listaClientes){
                          counterbl_report_clientes++;
                          String style="";
                          if (!((i_bl_report_clientes%2)!=0)) {
                            style="class=rowColor";
                          } else {
                            style="class=rowBlank";
                          }
                          i_bl_report_clientes++;
                          %>
                          <tr <%= style %> id='TRbl_report_Jw_tipos_produtos<%= counterbl_report_clientes %>' >
                            <td class="reportColumn" style="text-align:left;">
                              <%= cliente %>
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
                      Grupo Econômico
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="gre_grupo" styleId="gre_grupo" onblur="fillFields(0,new Array('gre_grupo'),'SolicitacaoCombinacaoEspecialActionForm.getGre_descricao_Ajax',new Array('gre_descricao'));" styleClass="baseField" size="6" maxlength="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_gre_grupo()"  >
                    <script type="text/javascript">
                      function lov_open_gre_grupo() {
                        window.open('..//lov/LvGrupoEconomicoLov.do?resetfull_action=&returnBlock=0&return0=gre_grupo&return1=gre_descricao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="gre_descricao" styleId="gre_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      ERC
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="rep_cdgo" styleId="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo','rep_rzao'),'SolicitacaoCombinacaoEspecialActionForm.getRep_rzao_Ajax',new Array());" styleClass="baseField" size="6" maxlength="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_rep_cdgo() {
                        window.open('..//lov/LvRepresentante2Lov.jsp?returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="rep_rzao" styleId="rep_rzao" onblur="fillFields(0,new Array('rep_cdgo','rep_rzao'),'SolicitacaoCombinacaoEspecialActionForm.getRep_rzao_Ajax',new Array());" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Regional
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="regional" styleId="regional" onblur="fillFields(0,new Array('regional','nome_regional'),'SolicitacaoCombinacaoEspecialActionForm.getNome_regional_Ajax',new Array());" styleClass="baseField" size="6" maxlength="6"/>
                    <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_regional()"  >
                    <script type="text/javascript">
                      function lov_open_regional() {
                        window.open('../lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=regional&return1=nome_regional','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="nome_regional" styleId="nome_regional" onblur="fillFields(0,new Array('regional','nome_regional'),'SolicitacaoCombinacaoEspecialActionForm.getNome_regional_Ajax',new Array());" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="30"/>
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
                      <html:option styleClass="baseOption" value="T">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="MI">
                        Mercado Interno
                      </html:option>
                      <html:option styleClass="baseOption" value="EX">
                        Mercado Externo
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <html:hidden property="tipo_solicitacao" value="<%= session.getAttribute("tipos_solicitacao_comb_espec_codigos") != null ? ((String)session.getAttribute("tipos_solicitacao_comb_espec_codigos")) : "" %>" />
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                    <input type="button" class="lovButton" value="Selecionar Tipos de Solicitação" onclick="javascript:lov_open_tipos()">
                    <script type="text/javascript">
                      function lov_open_tipos() {
                        window.open('..//lov/LvTipoSolicitacaoCombEspecGrdGrid.do?select_action','','scrollbars=yes,height=510,width=730,top=0,left=0,');
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
                    int counterbl_report_Tipos =0;
                    int i_bl_report_Tipos =0;
                    java.util.Vector res_Tipos = (java.util.Vector)session.getAttribute("tipos_solicitacao_comb_espec_vetor");
                    if (res_Tipos!=null && res_Tipos.size()>0) {
                      %>
                      <table id="TRbl_report_Jw_tipos_produtos" class="reportTable" style=width:340px; border=1; >
                        <tr class="reportHeader" >
                          <td align="center">
                            Tipos Selecionados
                          </td>
                        </tr>
                        <%
                        for (int x=0;x<res_Tipos.size(); x++){
                          counterbl_report_Tipos++;
                          String style="";
                          if (!((i_bl_report_Tipos%2)!=0)) {
                            style="class=rowColor";
                          } else {
                            style="class=rowBlank";
                          }
                          %>
                          <tr <%= style %> id='TRbl_report_Jw_tipos_produtos<%= counterbl_report_Tipos %>' >
                            <td class="reportColumn" style="text-align:left;">
                              <%= res_Tipos.elementAt(x) %>
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




                <html:hidden property="subtipo_solicitacao_comb_espec" value="<%= session.getAttribute("subtipos_solicitacao_comb_espec_codigos") != null ? ((String)session.getAttribute("subtipos_solicitacao_comb_espec_codigos")) : "" %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                    <input type="button" class="lovButton" value="Selecionar Subtipos" onclick="javascript:lov_open_subtipos()">
                    <script type="text/javascript">
                      function lov_open_subtipos() {
                        window.open('..//lov/LvSubtipoSolicitacaoCombEspecGrdGrid.do?select_action','','scrollbars=yes,height=510,width=730,top=0,left=0,');
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
                    int counterbl_report_Subtipos =0;
                    int i_bl_report_Subtipos =0;
                    java.util.Vector res_Subtipos = (java.util.Vector)session.getAttribute("subtipos_solicitacao_comb_espec_vetor");
                    if (res_Subtipos!=null && res_Subtipos.size()>0) {
                      %>
                      <table id="TRbl_report_Jw_tipos_produtos" class="reportTable" style=width:340px; border=1; >
                        <tr class="reportHeader" >
                          <td align="center">
                            Tipos Selecionados
                          </td>
                        </tr>
                        <%
                        for (int x=0;x<res_Subtipos.size(); x++){
                          counterbl_report_Subtipos++;
                          String style="";
                          if (!((i_bl_report_Subtipos%2)!=0)) {
                            style="class=rowColor";
                          } else {
                            style="class=rowBlank";
                          }
                          %>
                          <tr <%= style %> id='TRbl_report_Jw_tipos_produtos<%= counterbl_report_Subtipos %>' >
                            <td class="reportColumn" style="text-align:left;">
                              <%= res_Subtipos.elementAt(x) %>
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
                      Totalizar Pares Vendidos
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="somente_entrada" styleId="somente_entrada" onchange="refresh_action.click();" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="N">
                        Não
                      </html:option>
                      <html:option styleClass="baseOption" value="S">
                        Sim
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <%
                if(abreDatasEntrada!=null && abreDatasEntrada.equalsIgnoreCase("S")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Dt. Entrada Inicial
                      </span>
                      <bean:message key="jsp.fieldnotnull"/>
                    </td>
                    <td class="formField">
                      <html:text property="dt_entrada_inicial" styleId="dt_entrada_inicial" styleClass="baseField" size="10"/>
                       
                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_entrada_inicial']); cal1.year_scroll = true; cal1.popup();">
                        <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                      </a>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Dt. Entrada Final
                      </span>
                      <bean:message key="jsp.fieldnotnull"/>
                    </td>
                    <td class="formField">
                      <html:text property="dt_entrada_final" styleId="dt_entrada_final" styleClass="baseField" size="10"/>
                      &nbsp;
                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_entrada_final']); cal1.year_scroll = true; cal1.popup();">
                        <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                      </a>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="dt_entrada_inicial" />
                  <html:hidden property="dt_entrada_final" />

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Numero de Clientes no Ranking
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="numero_ranking" styleId="numero_ranking" styleClass="baseField" size="5"/>
                  </td>
                </tr>

                <%
                if(request.getAttribute("arquivo")!=null){
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
                    <html:submit accesskey="p" onclick="bloqueia();" styleClass="baseButton" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="i" value="Cadastrar Nova Solicitação" styleClass="baseButton" property="insert_action">
                    </html:submit>
                    <html:submit accesskey="p" styleClass="myhidden" property="select2_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit value="Gerar Relatório" styleClass="baseButton" property="gerar_relatorio_action">
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="refresh_action">
                      <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
                    </html:submit>
                    <html:submit value="Gerar Resumo por Marca" styleClass="baseButton" property="gerar_relatorio_resumo_action">
                    </html:submit>
                    <html:submit accesskey="s" value="Gerar Ranking" styleClass="baseButton" property="gerar_relatorio_ranking_action">
                    </html:submit>
                    <html:submit accesskey="p" styleClass="myhidden" property="select3_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit value="limpar_clientes" styleClass="myhidden" property="limpar_clientes_action">
                    </html:submit>
                  </td>
                </tr>
              </table>

              <script type="text/javascript">
                jQuery(document).ready(function($) {
                  $("#data_solicitacao").mask("99/99/9999");
                  $("#data_solicitacao_final").mask("99/99/9999");
                  $("#nova_combinacao").attr('checked', true);
                  $("#amostra").attr('checked', true);
                  $("#desenvolvimento").attr('checked', true);
                  $("#alteracao_modelo").attr('checked', true);
                  $("#fora_mix").attr('checked', true);
                  $("#manipulacao").attr('checked', true);
                  $("#modelo_exclusivo").attr('checked', true);
                  $("#dt_entrada_inicial").mask("99/99/9999");
                  $("#dt_entrada_final").mask("99/99/9999");
                  $("#data_entrega_amostra").mask("99/99/9999");
                  });
                </script>
              </html:form>
              <script type="text/javascript">
                var focusControl = document.forms[0].elements["id_solicitacao"];
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

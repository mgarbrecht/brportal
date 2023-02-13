<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ControleClientesEspeciaisAmostra_mActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ControleClientesEspeciaisAmostra_mActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("gridCheckField","");
    hashMapLabel.set("banco","");
    hashMapLabel.set("alterado","");
    hashMapLabel.set("ped_nmro","Pedido BR");
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
    hashMapLabel.set("ped_amostra_brinde","ped_amostra_brinde");
    hashMapLabel.set("valor_pedido","double");
    hashMapLabel.set("ped_obse","Observação Pedido");
    hashMapLabel.set("ped_tipo","Ped_tipo");
    hashMapLabel.set("dt_rec_etiqueta_filial","Dt_rec_etiqueta_filial");
    hashMapLabel.set("encarte1","Encarte");
    hashMapLabel.set("dt_emiss","Dt_emiss");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Controle de Clientes Especiais - Amostras
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

            <%
            acesso.Sessao sessao = new acesso.Sessao(session);
            util.bloqueio.BloqueioUtil bloqueio = new util.bloqueio.BloqueioUtil(186, request);
            boolean bloqueiaSalvarAlteracoes = false;
            boolean bloqueiaDtEntAmostraComercial = false;
            boolean bloqueiaDtEntAmostraPcp = false;
            boolean bloqueiaDataEfetiva = false;
            boolean bloqueiaEncarte = false;
            boolean bloqueiaEtiquetas = false;
            boolean bloqueiaCarimbo = false;
            String styleControle ="";

            if(bloqueio.tipoBloqueio("SALVAR_ALTERACOES").equals("E")){
              bloqueiaSalvarAlteracoes= true;
            }
            if(bloqueio.tipoBloqueio("DT_ENT_AMOSTRA_COMERCIAL").equals("D")){
              bloqueiaDtEntAmostraComercial = true;
            }
            if(bloqueio.tipoBloqueio("DT_ENT_AMOSTRA_PCP").equals("D")){
              bloqueiaDtEntAmostraPcp = true;
            }
            if(bloqueio.tipoBloqueio("DATA_EFETIVA").equals("D")){
              bloqueiaDataEfetiva = true;
            }
            if(bloqueio.tipoBloqueio("ENCARTE").equals("D")){
              bloqueiaEncarte = true;
            }
            if(bloqueio.tipoBloqueio("ETIQUETAS").equals("D")){
              bloqueiaEtiquetas = true;
            }
            if(bloqueio.tipoBloqueio("CARIMBO").equals("D")){
              bloqueiaCarimbo = true;
            }
            if(bloqueio.tipoBloqueio("ENCARTE").equals("D")){
              bloqueiaEncarte = true;
            }
            %>
            <%
            java.util.Vector res_Controle_clientes_especiais_vw = (java.util.Vector)session.getAttribute("res_Controle_clientes_especiais_vw");
            int i = 0;
            %>

            <html:form action="com/ControleClientesEspeciaisAmostra_mGrid.do" method="post" styleClass="baseForm">

              <%
              if(res_Controle_clientes_especiais_vw != null && res_Controle_clientes_especiais_vw.size()>0){
                %>

                <%
                if(!(request.getParameter("excel")+"").equals("true")){
                  %>


                  <table class="messageTable" style='width:99%;'>
                    <tr class="messageTr" >
                      <td class="messageTd">
                        <html:errors property="ped_nmro"/>
                        <html:errors property="oc"/>
                        <html:errors property="modelos"/>
                        <html:errors property="etiquetas"/>
                        <html:errors property="dt_entrega_etiqueta"/>
                        <html:errors property="obse_adicionais"/>
                        <html:errors property="prs"/>
                        <html:errors property="remessa"/>
                        <html:errors property="filial_prd"/>
                        <html:errors property="fil_filial_fat"/>
                        <html:errors property="dt_digit"/>
                        <html:errors property="dt_fatur"/>
                        <html:errors property="dt_fatur_filial"/>
                        <html:errors property="marca"/>
                        <html:errors property="carimbo"/>
                        <html:errors property="rotulos"/>
                        <html:errors property="ped_amostra"/>
                        <html:errors property="dt_envio_amostras"/>
                        <html:errors property="agendamento_cdgo"/>
                        <html:errors property="dezena"/>
                        <html:errors property="dia"/>
                        <html:errors property="data_efetiva"/>
                        <html:errors property="cli_cdgo"/>
                        <html:errors property="hora"/>
                        <html:errors property="senha"/>
                        <html:errors property="dt_emissao"/>
                        <html:errors property="filial"/>
                        <html:errors property="notafiscal"/>
                        <html:errors property="volumes"/>
                        <html:errors property="dt_inspecao"/>
                        <html:errors property="dt_montagem"/>
                        <html:errors property="grupo_economico"/>
                        <html:errors property="cli_rzao"/>
                        <html:errors property="situacao"/>
                        <html:errors property="cabide"/>
                        <html:errors property="ped_amostra_brinde"/>
                        <html:errors property="valor_pedido"/>
                        <html:errors property="encarte"/>
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
                  <table class="itemGridTable" style='width:4500px;' border="1">
                    <%
                  } else {
                    %>
                    <table class="itemGridTable" style='width:4500px;' border="1">
                      <%
                    }
                    %>

                    <tr class="reportTr">

                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>

                        <td class="columnTdHeader" style="text-align: left">
                          Regional
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          Pedido BR
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          Linha
                        </td>

                        <td class="columnTdHeader" style="text-align: center; width: 1%">
                          Sit.
                        </td>

                        <td class="columnTdHeader" style="text-align: center; width: 1%">
                          Tipo
                        </td>

                        <td class="columnTdHeader" style="text-align: left">
                          Grupo Econômico
                        </td>

                        <td class="columnTdHeader" style="text-align: left">
                          Cliente
                        </td>

                        <td class="columnTdHeader" style="text-align: left">
                          Razão Social
                        </td>

                        <td class="columnTdHeader" style="text-align: left">
                          Representante
                        </td>

                        <td class="columnTdHeader" style="text-align: left">
                          Observação Pedido
                        </td>

                        <td class="columnTdHeader" style="text-align: right">
                          Pares
                        </td>

                        <td class="columnTdHeader" style="text-align: right">
                          Valor
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          Remessa
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          Filial
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          Dt. Entrega
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          Dt. Digit.
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          Dt. Ent. Cliente
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          Dt. Prev. PCP
                        </td>

                        <td class="columnTdHeader" style="text-align: left">
                          Obs.
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          Tipo Amostra
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          Forma de Pgto.
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          Agend.
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          Encarte
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          Etiquetas
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          OC
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          Pedido Prod.
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          Marca
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          Carimbo
                        </td>



                        <%
                      } else {
                        %>

                        <%
                        if(true) {
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
                        if(session.getAttribute("cb_pedido")!=null) {
                          %>
                          <td class="columnTdHeader">
                            Pedido BR
                          </td>
                          <%
                        }
                        %>

                        <td class="columnTdHeader">
                          Linha
                        </td>


                        <%
                        if(session.getAttribute("cb_situacao")!=null) {
                          %>
                          <td class="columnTdHeader" style="width: 1%">
                            Sit.
                          </td>
                          <%
                        }
                        %>




                        <%
                        if(session.getAttribute("cb_pedido")!=null) {
                          %>
                          <td class="columnTdHeader" style="width: 1%">
                            Tipo
                          </td>
                          <%
                        }
                        %>


                        <%
                        if(session.getAttribute("cb_grupo_economico")!=null) {
                          %>
                          <td class="columnTdHeader">
                            Grupo Econômico
                          </td>
                          <%
                        }
                        %>

                        <%
                        if(session.getAttribute("cb_cliente")!=null) {
                          %>
                          <td class="columnTdHeader">
                            Cliente
                          </td>
                          <td class="columnTdHeader">
                            Razão Social
                          </td>
                          <%
                        }
                        %>

                        <%
                        if(session.getAttribute("cb_pedido")!=null) {
                          %>
                          <td class="columnTdHeader">
                            Representante
                          </td>
                          <%
                        }
                        %>


                        <td class="columnTdHeader">
                          Observação Pedido
                        </td>

                        <%
                        if(session.getAttribute("cb_pares")!=null) {
                          %>
                          <td class="columnTdHeader">
                            Pares
                          </td>
                          <%
                        }
                        %>

                        <%
                        if(session.getAttribute("cb_pares")!=null) {
                          %>
                          <td class="columnTdHeader">
                            Valor
                          </td>
                          <%
                        }
                        %>

                        <td class="columnTdHeader">
                          Remessa
                        </td>

                        <%
                        if(session.getAttribute("cb_fl_prod")!=null) {
                          %>
                          <td class="columnTdHeader">
                            Filial Prod.
                          </td>
                          <%
                        }
                        %>

                        <%
                        if(session.getAttribute("cb_digit")!=null) {
                          %>
                          <td class="columnTdHeader">
                            Dt. Entrega
                          </td>
                          <td class="columnTdHeader">
                            Dt. Digit.
                          </td>
                          <td class="columnTdHeader">
                            Dt. Ent. Cliente
                          </td>
                          <td class="columnTdHeader">
                            Dt. Prev. PCP
                          </td>
                          <%
                        }
                        %>

                        <%
                        if(session.getAttribute("cb_obs")!=null) {
                          %>
                          <td class="columnTdHeader">
                            Obs.
                          </td>
                          <td class="columnTdHeader">
                            Tipo Amostra
                          </td>
                          <td class="columnTdHeader">
                            Forma Pgto.
                          </td>
                          <%
                        }
                        %>

                        <%
                        if(session.getAttribute("cb_agenda")!=null) {
                          %>
                          <td class="columnTdHeader">
                            Agend.
                          </td>
                          <%
                        }
                        %>

                        <td class="columnTdHeader">
                          Encarte
                        </td>

                        <%
                        if(session.getAttribute("cb_etiquetas")!=null) {
                          %>
                          <td class="columnTdHeader">
                            Etiquetas
                          </td>
                          <%
                        }
                        %>

                        <%
                        if(session.getAttribute("cb_oc")!=null) {
                          %>
                          <td class="columnTdHeader">
                            OC
                          </td>
                          <%
                        }
                        %>


                        <%
                        if(session.getAttribute("cb_marca")!=null) {
                          %>
                          <td class="columnTdHeader">
                            Marca
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


                        <td class="columnTdHeader">
                          Pedido Prod.
                        </td>


                        <%
                      }
                      %>


                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>

                        <td class="columnTdHeader" style="text-align: center">
                          Dt. Faturamento
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          Filial
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          NF
                        </td>

                        <td class="columnTdHeader" style="text-align: center">
                          Volumes
                        </td>


                        <%
                      } else {
                        %>



                        <%
                        if(session.getAttribute("cb_emissao")!=null) {
                          %>
                          <td class="columnTdHeader">
                            Dt. Faturamento
                          </td>
                          <%
                        }
                        %>

                        <%
                        if(session.getAttribute("cb_nf")!=null) {
                          %>
                          <td class="columnTdHeader">
                            Filial
                          </td>
                          <%
                        }
                        %>

                        <%
                        if(session.getAttribute("cb_nf")!=null) {
                          %>
                          <td class="columnTdHeader">
                            NF
                          </td>
                          <%
                        }
                        %>

                        <%
                        if(session.getAttribute("cb_volumes")!=null) {
                          %>
                          <td class="columnTdHeader">
                            Volumes
                          </td>
                          <%
                        }
                        %>


                        <%
                      }
                      %>

                    </tr>

                    <logic:iterate id="bl_form_Controle_clientes_especiais_vw_lines" name="ControleClientesEspeciaisAmostra_mGridActionForm" property="bl_form_Controle_clientes_especiais_vw_lines" indexId="indexId">
                      <%
                      Controle_clientes_especiais_vw controle = (Controle_clientes_especiais_vw)res_Controle_clientes_especiais_vw.elementAt(i);
                      if (!((i%2)!=0)) {
                        styleControle="rowColor";
                      } else {
                        styleControle="rowBlank";
                      }
                      %>

                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>

                        <tr class="<%= styleControle %>">
                          <html:hidden property="gridCheckField" value="true" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true" styleId="gridCheckField"/>
                          <html:hidden property="banco" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true" styleId="banco"/>
                          <html:hidden property="alterado" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true" styleId="alterado"/>

                          <html:hidden property="bloqueia_navegador" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true" styleId="bloqueia_navegador"/>

                          <td class="reportColumn" style="text-align: left">
                            <html:hidden property="codigo_regional" value="<%= controle.getCodigo_regional()!=null?(controle.getCodigo_regional() + " - " + controle.getNome_regional()):""  %>" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                            <%= controle.getCodigo_regional()!=null?(controle.getCodigo_regional() + " - " + controle.getNome_regional()):""  %>
                          </td>

                          <td class="reportColumn" style="text-align: center">
                            <html:hidden property="ped_nmro" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                            <%= controle.getPed_nmro() %>
                          </td>

                          <td class="reportColumn" style="text-align: center">
                            <%= controle.getModelos() != null ? controle.getModelos().replace("-","<br>") : "" %>
                          </td>

                          <td class="reportColumn" style="text-align: center">
                            <html:hidden property="situacao" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                            <%= controle.getSituacao()!=null ? controle.getSituacao() : "" %>
                          </td>

                          <td class="reportColumn" style="text-align: center">
                            <html:hidden property="ped_tipo" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                            <%= controle.getPed_tipo()!=null ? controle.getPed_tipo() : "" %>
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

                          <td class="reportColumn" style="text-align: left">
                            <html:hidden property="cli_rzao" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                            <%= controle.getCli_rzao() %>
                          </td>

                          <td class="reportColumn" style="text-align: left">
                            <html:hidden property="rep_cdgo" value="<%= controle.getRep_cdgo()!=null?(controle.getRep_cdgo() + " - " + controle.getRep_rzao()):""  %>" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                            <%= controle.getRep_cdgo()!=null?(controle.getRep_cdgo() + " - " + controle.getRep_rzao()):""  %>
                          </td>

                          <td class="reportColumn" style="text-align: left">
                            <html:hidden property="ped_obse" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                            <%= controle.getPed_obse()!=null ? controle.getPed_obse() : "" %>
                          </td>

                          <td class="reportColumn">
                            <html:hidden property="prs" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                            <%= controle.getPrs()!=null ? controle.getPrs() : "" %>
                          </td>

                          <td class="reportColumn">
                            <html:hidden property="valor_pedido" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                            <%= controle.getValor_pedido() %>
                          </td>

                          <td class="reportColumn" style="text-align: center">
                            <html:hidden property="remessa" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                            <%= controle.getRemessa()!=null ? controle.getRemessa() : "" %>
                          </td>

                          <td class="reportColumn" style="text-align: center">
                            <html:hidden property="filial_prd" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                            <%= controle.getFilial_prd()!=null ? controle.getFilial_prd() : "" %>
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
                            <%
                            if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaDtEntAmostraComercial  || controle.getSituacao().indexOf("F")!=-1){
                              %>
                              <html:text property="dt_ent_amostra_comercial" styleId="dt_ent_amostra_comercial" styleClass="disabled" readonly="true" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                              <%
                            } else {
                              %>
                              <html:text property="dt_ent_amostra_comercial" styleId="dt_ent_amostra_comercial" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                              <%
                              if(res_Controle_clientes_especiais_vw.size()==1) {
                                %>
                                <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_ent_amostra_comercial']); cal1.year_scroll = true; cal1.popup();">
                                  <%
                                } else {
                                  %>
                                  <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_ent_amostra_comercial'][<%= indexId %>]); cal1.year_scroll = true; cal1.popup();">
                                    <%
                                  }
                                  %>
                                  <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                                </a>
                                <%
                              }
                              %>
                            </td>



                            <td class="reportColumn" style="text-align: center">
                              <%
                              if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaDtEntAmostraPcp  || controle.getSituacao().indexOf("F")!=-1){
                                %>
                                <html:text property="dt_ent_amostra_pcp" styleId="dt_ent_amostra_pcp" styleClass="disabled" readonly="true" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                <%
                              } else {
                                %>
                                <html:text property="dt_ent_amostra_pcp" styleId="dt_ent_amostra_pcp" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                <%
                                if(res_Controle_clientes_especiais_vw.size()==1) {
                                  %>
                                  <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_ent_amostra_pcp']); cal1.year_scroll = true; cal1.popup();">
                                    <%
                                  } else {
                                    %>
                                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_ent_amostra_pcp'][<%= indexId %>]); cal1.year_scroll = true; cal1.popup();">
                                      <%
                                    }
                                    %>
                                    <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                                  </a>
                                  <%
                                }
                                %>
                              </td>




                              <td class="reportColumn" style="text-align: left">

                                <%
                                if(controle.getObse_adicionais()!= null && controle.getObse_adicionais().indexOf("!")!=-1) {
                                  %>
                                  <html:text property="obse_adicionais" styleId="obse_adicionais" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " style="background-color:red;color:white;font-weight:bold" styleClass="baseField" size="50" maxlength="400" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                  <%
                                } else {
                                  %>
                                  <html:text property="obse_adicionais" styleId="obse_adicionais" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="50" maxlength="400" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                  <%
                                }
                                %>


                              </td>

                              <td class="reportColumn" style="text-align: center">
                                <html:hidden property="tipo_amostra" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                <%= controle.getTipo_amostra()!=null ? controle.getTipo_amostra() : "" %>
                              </td>

                              <td class="reportColumn" style="text-align: center">
                                <html:hidden property="ped_amostra_brinde" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                <%= controle.getPed_amostra_brinde()!=null ? controle.getPed_amostra_brinde() : "" %>
                              </td>



                              <td class="reportColumn" style="text-align: center">
                                <%
                                if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaDataEfetiva  || controle.getSituacao().indexOf("F")!=-1){
                                  %>
                                  <html:text property="data_efetiva" styleId="data_efetiva" styleClass="disabled" readonly="true" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                  <%
                                } else {
                                  %>
                                  <html:text property="data_efetiva" styleId="data_efetiva" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
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
                                </td>




                                <td class="reportColumn" style="text-align: center">
                                  <%
                                  if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaEncarte  || controle.getSituacao().indexOf("F")!=-1 || (Integer.parseInt(controle.getSituacao().substring(1,2))>3)){
                                    %>
                                    <html:text property="encarte" styleId="encarte" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="4000" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                    <%
                                  } else {
                                    %>
                                    <html:text property="encarte" styleId="encarte" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="40" maxlength="4000" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                    <%
                                  }
                                  %>
                                </td>

                                <td class="reportColumn" style="text-align: center">
                                  <%
                                  if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaEtiquetas  || controle.getSituacao().indexOf("F")!=-1){
                                    %>
                                    <html:text property="etiquetas" styleId="etiquetas" styleClass="disabled" readonly="true" tabindex="-1" size="10" maxlength="200" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                    <%
                                  } else {
                                    %>
                                    <html:text property="etiquetas" styleId="etiquetas" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="10" maxlength="200" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                    <%
                                  }
                                  %>
                                </td>


                                <td class="reportColumn" style="text-align: center">
                                  <html:hidden property="oc" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                  <%= controle.getOc()!=null ? controle.getOc() : "" %>
                                </td>

                                <td class="reportColumn" style="text-align: center">
                                  <html:hidden property="pedido_prod" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                  <%= controle.getPedido_prod()!=null ? controle.getPedido_prod() : "" %>
                                </td>


                                <td class="reportColumn" style="text-align: center">
                                  <html:hidden property="marca" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                  <%= controle.getMarca()!=null ? controle.getMarca() : "" %>
                                </td>


                                <%
                                if(controle.getCarimbo()==null) {
                                  %>
                                  <td class="reportColumn" style="text-align: center">
                                    <%
                                    if((!bloqueio.pertenceFilial(controle.getFilial_prd())) || bloqueiaCarimbo  || controle.getSituacao().indexOf("F")!=-1){
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


                                  <td class="reportColumn" style="text-align: center">
                                    <html:hidden property="dt_emissao" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                                    <%= com.egen.util.text.FormatDate.format(controle.getDt_emissao(), "dd/MM/yyyy") %>
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

                                </tr>

                                <%
                              } else {
                                %>


                                <tr class="trGridField">

                                  <%
                                  if(true) {
                                    %>
                                    <td class="reportColumn">
                                      <%= controle.getCodigo_regional()!=null?(controle.getCodigo_regional()+"-"):"" %>
                                      <%= controle.getNome_regional()!=null?controle.getNome_regional():"" %>
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

                                  <td class="reportColumn">
                                    <%= controle.getModelos()==null?"":controle.getModelos() %>
                                  </td>

                                  <%
                                  if(session.getAttribute("cb_situacao")!=null) {
                                    %>
                                    <td class="reportColumn">
                                      <%= controle.getSituacao() %>
                                    </td>
                                    <%
                                  }
                                  %>

                                  <%
                                  if(session.getAttribute("cb_pedido")!=null) {
                                    %>
                                    <td class="reportColumn">
                                      <%= controle.getPed_tipo() %>
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
                                        <%= controle.getGrupo_economico()!=null?(controle.getGrupo_economico()+"-"):"" %>
                                        <%= controle.getGrupo_descricao()!=null?controle.getGrupo_descricao():"" %>
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

                                    <td class="reportColumn">
                                      <%= controle.getCli_rzao() %>
                                    </td>
                                    <td class="reportColumn">
                                      <%= controle.getRep_cdgo()+"-"+controle.getRep_rzao() %>
                                    </td>
                                    <%
                                  }
                                  %>

                                  <%
                                  if(session.getAttribute("cb_situacao")!=null) {
                                    %>
                                    <td class="reportColumn">
                                      <%= controle.getPed_obse()!=null?controle.getPed_obse():"" %>
                                    </td>
                                    <%
                                  }
                                  %>


                                  <%
                                  if(session.getAttribute("cb_pares")!=null) {
                                    %>
                                    <td class="reportColumn">
                                      <%= controle.getPrs()==null?"":controle.getPrs() %>
                                    </td>
                                    <td class="reportColumn">
                                      <%= controle.getValor_pedido() %>
                                    </td>
                                    <td class="reportColumn">
                                      <%= controle.getRemessa()!=null?controle.getRemessa():"" %>
                                    </td>
                                    <%
                                  }
                                  %>

                                  <%
                                  if(session.getAttribute("cb_fl_prod")!=null) {
                                    %>
                                    <td class="reportColumn">
                                      <%= controle.getFilial_prd()==null?"":controle.getFilial_prd() %>
                                    </td>
                                    <%
                                  }
                                  %>

                                  <%
                                  if(session.getAttribute("cb_digit")!=null) {
                                    %>
                                    <td class="reportColumn">
                                      <%= controle.getDt_emiss()==null?"":controle.getDt_emiss() %>
                                    </td>
                                    <td class="reportColumn">
                                      <%= controle.getDt_digit()==null?"":controle.getDt_digit() %>
                                    </td>
                                    <td class="reportColumn">
                                      <%= controle.getDt_ent_amostra_comercial()==null?"":controle.getDt_ent_amostra_comercial() %>
                                    </td>
                                    <td class="reportColumn">
                                      <%= controle.getDt_ent_amostra_pcp()==null?"":controle.getDt_ent_amostra_pcp() %>
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

                                  <td class="reportColumn">
                                    <%= controle.getTipo_amostra()==null?"":controle.getTipo_amostra() %>
                                  </td>

                                  <td class="reportColumn">
                                    <%= controle.getPed_amostra_brinde()==null?"":controle.getPed_amostra_brinde() %>
                                  </td>

                                  <%
                                  if(session.getAttribute("cb_dt_efetiva")!=null) {
                                    %>
                                    <td class="reportColumn">
                                      <%= controle.getData_efetiva()==null?"":controle.getData_efetiva() %>
                                    </td>
                                    <%
                                  }
                                  %>

                                  <td class="reportColumn">
                                    <%= controle.getEncarte()==null?"":controle.getEncarte() %>
                                  </td>

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
                                  if(session.getAttribute("cb_oc")!=null) {
                                    %>
                                    <td class="reportColumn">
                                      <%= controle.getOc()==null?"":controle.getOc() %>
                                    </td>
                                    <%
                                  }
                                  %>

                                  <td class="reportColumn">
                                    <%= controle.getPedido_prod()==null?"":controle.getPedido_prod() %>
                                  </td>

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
                                  if(session.getAttribute("cb_carimbo")!=null) {
                                    %>
                                    <td class="reportColumn">
                                      <%= controle.getCarimbo()==null?"":controle.getCarimbo() %>
                                    </td>
                                    <%
                                  }
                                  %>


                                  <%
                                  if(session.getAttribute("cb_ped_amostra")!=null) {
                                    %>
                                    <td class="reportColumn">
                                      <%= controle.getPed_amostra()==null?"":controle.getPed_amostra() %>
                                    </td>
                                    <%
                                  }
                                  %>


                                  <%
                                  if(session.getAttribute("cb_emissao")!=null) {
                                    %>
                                    <td class="reportColumn">
                                      <%= controle.getDt_emissao()==null?"":controle.getDt_emissao() %>
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


                                </tr>





                                <%
                              }
                              %>

                              <%
                              i++;
                              %>

                            </logic:iterate>

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
                                    <html:submit styleClass="baseButton" property="back_action">
                                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                                    </html:submit>


                                    <%
                                    if(bloqueiaSalvarAlteracoes){
                                      %>
                                      <html:submit value="Salvar Alterações" styleClass="myhidden" property="blank1_action" />
                                      <%
                                    } else {
                                      %>
                                      <html:submit value="Salvar Alterações" onclick="jQuery('#aguarde').show();jQuery('#botao').hide();" styleClass="baseButton" property="blank1_action" />
                                      <%
                                    }
                                    %>

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
                                  <html:submit accesskey="a" value="Salvar Alterações" styleClass="myhidden" property="blank1_action">
                                  </html:submit>
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


                      </html:form>
                    </td>
                  </tr>
                </table>

              </body>
            </center>
          </html>

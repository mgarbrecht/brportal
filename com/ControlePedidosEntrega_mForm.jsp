<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ControlePedidosEntrega_mActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ControlePedidosEntrega_mActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("gridCheckField","");
    hashMapLabel.set("banco","");
    hashMapLabel.set("alterado","");
    hashMapLabel.set("ped_nmro","Pedido BR");
    hashMapLabel.set("oc","OC");
    hashMapLabel.set("modelos","Linha");
    hashMapLabel.set("etiquetas","Etiquetas");
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
    hashMapLabel.set("cli_rzao","Cli_rzao");
    hashMapLabel.set("valor_pedido","double");
    hashMapLabel.set("esc_seqn","Esc_seqn");
    hashMapLabel.set("rep_rzao","Rep_rzao");
    hashMapLabel.set("cliente","");
    hashMapLabel.set("ped_amostra_brinde","ped_amostra_brinde");
    hashMapLabel.set("data_entrega_cliente","Dt_digit");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Controle de Pedidos p/ Entrega
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(189)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ControlePedidosEntrega_mGrid.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="ped_nmro"/>
                    <html:errors property="oc"/>
                    <html:errors property="modelos"/>
                    <html:errors property="etiquetas"/>
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
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw"/>
                  </td>
                </tr>
              </table>

              <table class="itemGridTable" style='width:1600px;' >
                <tr class="trGridLabel">

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Cliente
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Filial
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Rep.
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Cd. Loja
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Pedido
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Dia Pedido
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Data PCP
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Dia Entrega
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      NF
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Remessa
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Pares
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Valor
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Amostra Brinde
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Data Entrega
                    </span>
                  </td>


                </tr>

                <logic:iterate id="bl_form_Controle_clientes_especiais_vw_lines" name="ControlePedidosEntrega_mGridActionForm" property="bl_form_Controle_clientes_especiais_vw_lines" indexId="indexId">
                  <tr class="trGridField">
                    <html:hidden property="gridCheckField" value="true" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true" styleId="gridCheckField"/>
                    <html:hidden property="banco" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true" styleId="banco"/>
                    <html:hidden property="alterado" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true" styleId="alterado"/>

                    <td class="tdGridField">
                      <html:text property="cliente" styleId="cliente" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="7" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="filial_prd" styleId="filial_prd" styleClass="disabled" tabindex="-1" readonly="true" size="4" maxlength="4" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="rep_cdgo" styleId="rep_cdgo" styleClass="disabled" tabindex="-1" readonly="true" size="4" maxlength="4" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="esc_seqn" styleId="esc_seqn" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="3" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="marca" styleId="marca" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="200" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="modelos" styleId="modelos" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="4000" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="ped_nmro" styleId="ped_nmro" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="dt_digit" styleId="dt_digit" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="dt_fatur_filial" styleId="dt_fatur_filial" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event); " styleClass="baseField" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                       
                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_fatur_filial'][<%= indexId %>]); cal1.year_scroll = true; cal1.popup();">
                        <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                      </a>
                    </td>

                    <td class="tdGridField">
                      <html:text property="dt_fatur" styleId="dt_fatur" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="notafiscal" styleId="notafiscal" styleClass="disabled" tabindex="-1" readonly="true" size="15" maxlength="20" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="remessa" styleId="remessa" styleClass="disabled" tabindex="-1" readonly="true" size="6" maxlength="6" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="prs" styleId="prs" styleClass="disabled" tabindex="-1" readonly="true" size="6" maxlength="22" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="valor_pedido" styleId="valor_pedido" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true"/>
                    </td>


                    <html:hidden property="bloqueia_navegador" name="bl_form_Controle_clientes_especiais_vw_lines" indexed="true" styleId="bloqueia_navegador"/>

                  </tr>

                </logic:iterate>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit styleClass="myhidden" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:submit>
                    <html:submit accesskey="a" value="Salvar Alterações" styleClass="baseButton" property="update_action">
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

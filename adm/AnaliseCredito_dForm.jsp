<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Análise de Crédito
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
                  <%@ include file="../system/header_sem_ajuda.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(61)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="adm/AnaliseCredito_dForm.do" method="POST" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr>
                  <td class="messageHeader">
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Prc_ctr_his_pgtos_an"/>
                  </td>
                </tr>
              </table>
              <table class="itemTable" style='width:99%;'>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Cliente
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_cdgo" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10"/>
                    <html:text property="cli_rzao" style="text-align:left;" styleClass="disabled" tabindex="-1" readonly="true" size="43" maxlength="35"/>
                    <span class="spamFormLabel" >
                    </span>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Meses
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_meses_atras" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10"/>
                    <span class="spamFormLabel" >
                    </span>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Grupo Econômico
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="gre_grupo" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10"/>
                    <html:text property="gre_descricao" style="text-align:left;" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                    <span class="spamFormLabel" >
                    </span>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Empresa
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="emp_empresa" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10"/>
                    <html:text property="emp_razsoc" style="text-align:left;" styleClass="disabled" tabindex="-1" readonly="true" size="50" maxlength="50"/>
                    <span class="spamFormLabel" >
                    </span>

                    <html:button value="Consulta Gerencial" style="color: white" styleClass="baseButton" property="next_action" onclick="wopen('../adm/AnaliseCredito_cgForm.do?inicializa_action=&p_cli_cdgo='+document.forms[0].p_cli_cdgo.value+'&p_clientes='+document.forms[0].p_clientes.value+'&p_grupo_economico='+document.forms[0].p_grupo_economico.value+'&p_emp='+document.forms[0].p_emp.value+'','_blank',1000,380)">
                    </html:button>


                  </td>
                </tr>
              </table>


              <table class="separatorTable">
                <tr class="separatorTr">
                  <td colspan="4" class="separatorTd" align="center">
                    <big>
                      <b>
                        Informações de Crédito
                      </b>
                    </big>
                  </td>
                </tr>

                <html:hidden property="p_clientes"/>
                <html:hidden property="p_grupo_economico"/>
                <html:hidden property="p_meses_atras"/>
                <html:hidden property="p_cli_cdgo"/>
                <html:hidden property="p_emp"/>

                <!--
                  Clientes<html:text property="p_clientes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10"/> Grupo Economico<html:text property="p_grupo_economico" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10"/>
                -->

                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Prim. Compra
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_pri_compra" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_pri_compra" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                  </td>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Devoluções
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_dev" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_dev" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                    <html:text property="p_perc_dev" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="8" maxlength="22"/>
                    <span class="spamFormLabel" >
                      %
                    </span>
                  </td>
                </tr>

                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Últ. Compra
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_ult_compra" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_ult_compra" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                  </td>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Prorrogações
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_pro" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_pro" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                    <html:text property="p_perc_pro" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="8" maxlength="22"/>
                    <span class="spamFormLabel" >
                      %
                    </span>
                  </td>
                </tr>

                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Maior Compra
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_mai_compra" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_mai_compra" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                  </td>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      NEG OK
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_neg_ok" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_neg_ok" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                    <html:text property="p_perc_neg_ok" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="8" maxlength="22"/>
                    <span class="spamFormLabel" >
                      %
                    </span>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Fatur. 12 M
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_12" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_12" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                  </td>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      NEG Enc.
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_neg_enc" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_neg_enc" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                    <html:text property="p_perc_neg_enc" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="8" maxlength="22"/>
                    <span class="spamFormLabel" >
                      %
                    </span>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Fatur. 6 M
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_6" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_6" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                  </td>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      NEG Abertas
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_neg_abe" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_neg_abe" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Pontual 0-2
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_02" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_02" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                    <html:text property="p_perc_02" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="8" maxlength="22"/>
                    <span class="spamFormLabel" >
                      %
                    </span>
                  </td>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      CHD Liq.
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_chd_liq" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_chd_liq" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Pgto 3-6
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_36" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_36" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                    <html:text property="p_perc_36" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="8" maxlength="22"/>
                    <span class="spamFormLabel" >
                      %
                    </span>
                  </td>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      CHD Abertos
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_chd_abe" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_chd_abe" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Pgto 7-20
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_720" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_720" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                    <html:text property="p_perc_720" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="8" maxlength="22"/>
                    <span class="spamFormLabel" >
                      %
                    </span>
                  </td>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      PRO Aberto
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_pro_abe" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_pro_abe" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Pgto 21-30
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_2130" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_2130" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                    <html:text property="p_perc_2130" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="8" maxlength="22"/>
                    <span class="spamFormLabel" >
                      %
                    </span>
                  </td>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      DIS em Aberto
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_dis_abe" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_dis_abe" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Pgto +30
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_a30" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_a30" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                    <html:text property="p_perc_a30" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="8" maxlength="22"/>
                    <span class="spamFormLabel" >
                      %
                    </span>
                  </td>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Fora Pend.
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_fora_pend" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_fora_pend" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="22"/>
                  </td>
                </tr>

                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Cartório
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_car" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_car" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                    <html:text property="p_perc_car" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="8" maxlength="22"/>
                    <span class="spamFormLabel" >
                      %
                    </span>
                  </td>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      TIT em Aberto
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_tit_abe" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_tit_abe" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="22"/>
                  </td>
                </tr>


                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                    </span>
                  </td>
                  <td class="formField">
                  </td>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Neg. DDN
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ddn_qtde" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="ddn_valor" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="22"/>
                  </td>
                </tr>

                <tr>
                  <td colspan=4 align="center">
                    <table id="TRbl_report_Jw_clientes_bloqueios" class="reportTable" style=width:70%; border=1; >
                      <%
                      int counterbl_report_Jw_clientes_bloqueios=0;
                      {
                        portalbr.dbobj.view.Jw_clientes_bloqueios t_jw_clientes_bloqueios = new portalbr.dbobj.view.Jw_clientes_bloqueios();
                        java.util.Vector res_Jw_clientes_bloqueios = null;
                        portalbr.adm.AnaliseCredito_dActionForm AnaliseCredito_dActionForm = (portalbr.adm.AnaliseCredito_dActionForm)session.getAttribute("AnaliseCredito_dActionForm");
                        if(true){
                          //AnaliseCredito_dActionForm!=null && (AnaliseCredito_dActionForm.getP_clientes()!=null && AnaliseCredito_dActionForm.getP_clientes().length()>0)) {
                            com.egen.util.jdbc.JdbcUtil j = null;
                            try {
                              String parametros = "";
                              if(AnaliseCredito_dActionForm.getP_clientes()!=""){
                                parametros = AnaliseCredito_dActionForm.getP_clientes();
                              }else {
                                parametros = AnaliseCredito_dActionForm.getP_cli_cdgo();
                              }
                              j = new com.egen.util.jdbc.JdbcUtil();
                              StringBuilder sb = new StringBuilder();
                              sb.append(" SELECT cli_cdgo, ");
                              sb.append("        bloq.blo_codigo_bloqueio codigo_bloqueio, ");
                              sb.append("        blo_descricao_bloqueio descricao_bloqueio, ");
                              sb.append("        cli_bloq.data_inclusao ");
                              sb.append("   FROM bloqueio bloq, ");
                              sb.append("        cli_bloqueio cli_bloq ");
                              sb.append("  WHERE NVL(data_inclusao, NULL) = (SELECT  MAX(cb.data_inclusao) ");
                              sb.append("                                      FROM  cli_bloqueio cb ");
                              sb.append("                                     WHERE  cb.cli_cdgo = cli_bloq.cli_cdgo ");
                              sb.append("                                       AND  blo_codigo_bloqueio <> 999) ");
                              sb.append("    AND bloq.blo_codigo_bloqueio = cli_bloq.blo_codigo_bloqueio ");
                              sb.append("    AND  bloq.blo_codigo_bloqueio <> 999 ");
                              sb.append("    AND  cli_bloq.cli_cdgo in (").append(parametros).append(") ");
                              res_Jw_clientes_bloqueios = j.select(t_jw_clientes_bloqueios,
                              sb.toString(),
                              null);
                            } catch (Exception e){
                              res_Jw_clientes_bloqueios = null;
                            } finally {
                            if(j!=null){j.close();}
                          }
                        } else {
                          res_Jw_clientes_bloqueios = null;
                        }
                        if (res_Jw_clientes_bloqueios!=null && res_Jw_clientes_bloqueios.size()>0) {
                          java.lang.String cli_cdgo =  null;
                          java.lang.String codigo_bloqueio =  null;
                          java.lang.String descricao_bloqueio =  null;
                          java.sql.Timestamp data_inclusao =  null;
                          int i_bl_report_Jw_clientes_bloqueios = 0;
                          t_jw_clientes_bloqueios = (portalbr.dbobj.view.Jw_clientes_bloqueios)res_Jw_clientes_bloqueios.elementAt(i_bl_report_Jw_clientes_bloqueios);
                          cli_cdgo = t_jw_clientes_bloqueios.getCli_cdgo()==null?"":t_jw_clientes_bloqueios.getCli_cdgo();
                          codigo_bloqueio = t_jw_clientes_bloqueios.getCodigo_bloqueio()==null?"":t_jw_clientes_bloqueios.getCodigo_bloqueio();
                          descricao_bloqueio = t_jw_clientes_bloqueios.getDescricao_bloqueio()==null?"":t_jw_clientes_bloqueios.getDescricao_bloqueio();
                          data_inclusao = (java.sql.Timestamp)t_jw_clientes_bloqueios.getData_inclusao();
                          %>
                          <tr class="reportHeader2">
                            <td colspan=4 align="center">
                              <big>
                                <b>
                                  Bloqueios
                                </b>
                              </big>
                            </td>
                          </tr>
                          <tr class="reportHeader" >
                            <td class="columnTdHeader" style="text-align:left;">
                              Cliente
                            </td>
                            <td class="columnTdHeader" style="text-align:left;">
                              Bloqueio
                            </td>
                            <td class="columnTdHeader" style="text-align:left;">
                              Descrição
                            </td>
                            <td class="columnTdHeader" style="text-align:center;">
                              Data Inclusão
                            </td>
                          </tr>
                          <%
                          while (i_bl_report_Jw_clientes_bloqueios<res_Jw_clientes_bloqueios.size()){
                            counterbl_report_Jw_clientes_bloqueios++;
                            String style="";
                            if (!((i_bl_report_Jw_clientes_bloqueios%2)!=0)) {
                              style="class=rowColor";
                            } else {
                              style="class=rowBlank";
                            }
                            %>
                            <tr <%= style %> id='TRbl_report_Jw_clientes_bloqueios<%=counterbl_report_Jw_clientes_bloqueios%>' >
                              <td class="reportColumn" style="text-align:left;">
                                <%= cli_cdgo %>
                              </td>
                              <td class="reportColumn" style="text-align:left;">
                                <%= codigo_bloqueio %>
                              </td>
                              <td class="reportColumn" style="text-align:left;">
                                <%= descricao_bloqueio %>
                              </td>
                              <td class="reportColumn" style="text-align:center;">
                                <%= com.egen.util.text.FormatDate.format(data_inclusao, "dd/MM/yyyy HH:mm") %>
                              </td>
                            </tr>
                            <%
                            if (++i_bl_report_Jw_clientes_bloqueios >= res_Jw_clientes_bloqueios.size()) {
                              break;
                            }
                            t_jw_clientes_bloqueios = (portalbr.dbobj.view.Jw_clientes_bloqueios)res_Jw_clientes_bloqueios.elementAt(i_bl_report_Jw_clientes_bloqueios);
                            cli_cdgo = t_jw_clientes_bloqueios.getCli_cdgo()==null?"":t_jw_clientes_bloqueios.getCli_cdgo();
                            codigo_bloqueio = t_jw_clientes_bloqueios.getCodigo_bloqueio()==null?"":t_jw_clientes_bloqueios.getCodigo_bloqueio();
                            descricao_bloqueio = t_jw_clientes_bloqueios.getDescricao_bloqueio()==null?"":t_jw_clientes_bloqueios.getDescricao_bloqueio();
                            data_inclusao = (java.sql.Timestamp)t_jw_clientes_bloqueios.getData_inclusao();
                          }
                        }
                      }
                      %>
                    </table>

                  </td>
                </tr>
              </table>
              <table class="itemTable" style='width:100%;'>
              </table>
              <table class="separatorTable" border=0>
                <tr class="separatorTr">
                  <td colspan="5" class="separatorTd" align="center">
                    <big>
                      <b>
                        Totais Títulos
                      </b>
                    </big>
                  </td>
                </tr>
                <tr align="center">
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                    </span>
                  </td>
                  <td class="formField" align="center">
                    <b>
                      A Vencer
                    </b>
                  </td>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                    </span>
                  </td>
                  <td class="formField" align="center">
                    <b>
                      Vencidos
                    </b>
                  </td>
                </tr>


                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Até
                      <html:text property="ate20_1" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      Dias
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_ap_ate" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_ap_ate" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="15" maxlength="22"/>
                  </td>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Até
                      <html:text property="ate20_2" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      Dias
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_ve_ate" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_ve_ate" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="15" maxlength="22"/>
                  </td>
                  <td>
                    <html:button value="Detalhes" styleClass="baseButton" property="next_action" onclick="wopen('../adm/AnaliseCredito_deForm.do?execute_action=&p_cli_cdgo='+document.forms[0].p_cli_cdgo.value+'&p_clientes='+document.forms[0].p_clientes.value+'&p_grupo_economico='+document.forms[0].p_grupo_economico.value+'&p_emp='+document.forms[0].p_emp.value+'','_blank',1000,380)">
                    </html:button>
                  </td>
                </tr>

                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Após
                      <html:text property="ate20_3" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      Dias
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_ap_apo" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_ap_apo" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="15" maxlength="22"/>
                  </td>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Após
                      <html:text property="ate20_4" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      Dias
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_ve_apo" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_ve_apo" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="15" maxlength="22"/>
                  </td>
                </tr>


                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      <b>
                        Total a Vencer
                      </b>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_tot_ave" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_tot_ave" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="15" maxlength="22"/>
                  </td>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      <b>
                        Total Vencidos
                      </b>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_tot_ven" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_tot_ven" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="15" maxlength="22"/>
                    <html:text property="p_perc_ven" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="8" maxlength="22"/>
                    <span class="spamFormLabel" >
                      %
                    </span>
                  </td>
                </tr>
                <tr>
                  <td  colspan=3 align="right">
                    <b>
                      Total Geral
                    </b>
                  </td>
                  <td class="formField" >
                    <html:text property="p_qtd_tot_ger" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_tot_ger" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="15" maxlength="22"/>
                  </td>
                </tr>
              </table>
              <table class="itemTable" style='width:100%;'>
              </table>
              <table class="separatorTable">
                <tr class="separatorTr">
                  <td colspan="4" class="separatorTd" align="center">
                    <big>
                      <b>
                        Pedidos e Saldos
                      </b>
                    </big>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Ped. Aberto Não Lib.
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_ped_abe_nlib" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_ped_abe_nlib" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="22" maxlength="22"/>
                    <html:img src="../img/viewmag.png" title="Pedidos Bloqueados" onmouseover="this.src='../img/viewmag_s.png'" onmouseout="this.src='../img/viewmag.png'" style="cursor:hand" onclick="window.open('../adm/PedidosBloqueadosForm.do?select_action=','_self')"/>
                  </td>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Pedidos Abertos
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_qtd_ped_abe_lib" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="p_vlr_ped_abe_lib" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="22" maxlength="22"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Lim. Crédito Analista
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_limite" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="35"/>
                  </td>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Saldo
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="p_saldo" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="35"/>
                  </td>
                </tr>
                <html:hidden property="p_erro"/>
              </table>
              <table class="itemTable" style='width:100%;'>
              </table>
              <table class="buttonTable" style='width:99%;'>
                <tr>
                  <td class="buttonItem">
                    <html:submit accesskey="e" styleClass="myhidden" property="execute_action">
                      <bean:message bundle="ApplicationResources" key="jsp.execute"/>
                    </html:submit>
                    <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:submit>
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
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

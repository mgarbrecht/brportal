<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.titulo"/>
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
                </td>

              </tr>

            </table>

            <html:form action="com/ConsultaDuplicataForm.do" method="POST" styleClass="baseForm">
              <html:hidden property="serie"/>
              <html:hidden property="emp_empresa"/>
              <html:hidden property="fil_filial"/>
              <html:hidden property="tip"/>
              <table class="itemTable" style='width:76%;'>

                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.cliente"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cliente" size="70" styleClass="disabled" tabindex="-1" readonly="true"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      CNPJ
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cnpj" size="20" styleClass="disabled" tabindex="-1" readonly="true"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.duplicata"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="duplicata" styleClass="disabled" tabindex="-1" readonly="true"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.pedido"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="pedido" styleClass="disabled" tabindex="-1" readonly="true"/>
                    <%
                    portalbr.com.ConsultaDuplicataActionForm ConsultaDuplicataActionForm = (portalbr.com.ConsultaDuplicataActionForm)session.getAttribute("ConsultaDuplicataActionForm");
                    if((!((ConsultaDuplicataActionForm.getExiste()+"").equals("0")))
                    && ((!(ConsultaDuplicataActionForm.getPedido().equals(""))))
                    ){
                      %>
                      <html:img src="../img/viewmag.png" onmouseover="this.src='../img/viewmag_s.png'" onmouseout="this.src='../img/viewmag.png'" style="cursor:hand" onclick="window.open('../com/ConsultaPedidos_iForm.do?select_action=&pedido_beira_rio='+document.forms[0].pedido.value,'_self')"/>
                      <%
                    }
                    %>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.nf"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="nf" styleClass="disabled" tabindex="-1" readonly="true"/>
                    <%
                    if((!(ConsultaDuplicataActionForm.getNf().equals("")))){
                      %>
                      <html:img src="../img/viewmag.png" onmouseover="this.src='../img/viewmag_s.png'" onmouseout="this.src='../img/viewmag.png'" style="cursor:hand" onclick="window.open('../com/NotaFiscalForm.do?select_action=&nf_nmro='+document.forms[0].nf.value+'&nf_serie='+document.forms[0].serie.value+'&fil_filial='+document.forms[1].filial.value+'&emp_empresa='+document.forms[0].emp_empresa.value,'_self')"/>
                      <%
                    }
                    %>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.rep"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="rep" size="70" styleClass="disabled" tabindex="-1" readonly="true"/>
                  </td>
                </tr>
              </table>
            </html:form>
            <html:form action="com/ConsultaDuplicataForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="empresa"/>
                    <html:errors property="status"/>
                    <html:errors property="dt_emissao"/>
                    <html:errors property="dt_venc"/>
                    <html:errors property="dt_pagamento"/>
                    <html:errors property="triplic"/>
                    <html:errors property="anuencia"/>
                    <html:errors property="ins_prot"/>
                    <html:errors property="nr_banco"/>
                    <html:errors property="desc_pontualidade"/>
                    <html:errors property="desc_antecipacao"/>
                    <html:errors property="juros"/>
                    <html:errors property="valor_receb"/>
                    <html:errors property="valor_abatim"/>
                    <html:errors property="desconto"/>
                    <html:errors property="cartorio"/>
                    <html:errors property="desban"/>
                    <html:errors property="saldo"/>
                    <html:errors property="valor"/>
                    <html:errors property="encargos"/>
                    <html:errors property="valor_vendor"/>
                    <html:errors property="carteira"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_duplicata"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style=" width:;">
                <tr class="itemTr" >
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Empresa
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="empresa" styleClass="disabled" tabindex="-1" readonly="true" size="60"/>
                  </td>

                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.status"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="status" styleClass="disabled" tabindex="-1" readonly="true" size="9" maxlength="9"/>
                  </td>

                </tr>

                <tr class="itemTr" >
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.dt_emissao"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_emissao" styleClass="disabled" tabindex="-1" readonly="true" size="22" maxlength="22"/>
                  </td>

                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.dt_venc"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_venc" styleClass="disabled" tabindex="-1" readonly="true" size="22" maxlength="22"/>
                  </td>

                </tr>

                <html:hidden property="cli_cdgo"/>
                <html:hidden property="esc_seqn"/>
                <tr class="itemTr" >
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.dt_pagamento"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_pagamento" styleClass="disabled" tabindex="-1" readonly="true" size="22" maxlength="22"/>
                  </td>

                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.triplic"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="triplic" styleClass="disabled" tabindex="-1" readonly="true" size="22" maxlength="22"/>
                  </td>

                </tr>

                <tr class="itemTr" >
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.anuencia"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="anuencia" styleClass="disabled" tabindex="-1" readonly="true" size="22" maxlength="22"/>
                  </td>

                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.ins_prot"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ins_prot" styleClass="disabled" tabindex="-1" readonly="true" size="22" maxlength="22"/>
                  </td>

                </tr>

                <td class="formLabel">
                  <span class="spamFormLabel">
                    <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.nr_banco"/>
                  </span>
                </td>
                <td class="formField">

                  <html:text property="nr_banco" styleClass="disabled" tabindex="-1" readonly="true" size="18" maxlength="12"/>

                  <html:img src="../img/viewmag.png" onmouseover="this.src='../img/viewmag_s.png'" onmouseout="this.src='../img/viewmag.png'" style="cursor:hand" onclick="window.open(document.forms[1].link.value,'_blank')"/>

                </td>
              </tr>



              <td class="formLabel">
                <span class="spamFormLabel">
                  <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.desc_pontualidade"/>
                </span>
              </td>
              <td class="formField">
                <html:text property="desc_pontualidade" styleClass="disabled" tabindex="-1" readonly="true" size="25" maxlength="25"/>
              </td>

            </tr>

            <tr class="itemTr" >
              <td class="formLabel">
                <span class="spamFormLabel">
                  <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.desc_antecipacao"/>
                </span>
              </td>
              <td class="formField">
                <html:text property="desc_antecipacao" styleClass="disabled" tabindex="-1" readonly="true" size="25" maxlength="25"/>
              </td>

              <td class="formLabel">
                <span class="spamFormLabel">
                  <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.juros"/>
                </span>
              </td>
              <td class="formField">
                <html:text property="juros" styleClass="disabled" tabindex="-1" readonly="true" size="23" maxlength="23"/>
              </td>

            </tr>

            <tr class="itemTr" >
              <td class="formLabel">
                <span class="spamFormLabel">
                  <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.valor_receb"/>
                </span>
              </td>
              <td class="formField">
                <html:text property="valor_receb" styleClass="disabled" tabindex="-1" readonly="true" size="23" maxlength="23"/>
              </td>

              <td class="formLabel">
                <span class="spamFormLabel">
                  <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.valor_abatim"/>
                </span>
              </td>
              <td class="formField">
                <html:text property="valor_abatim" styleClass="disabled" tabindex="-1" readonly="true" size="23" maxlength="23"/>
              </td>

            </tr>

            <tr class="itemTr" >
              <td class="formLabel">
                <span class="spamFormLabel">
                  <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.desconto"/>
                </span>
              </td>
              <td class="formField">
                <html:text property="desconto" styleClass="disabled" tabindex="-1" readonly="true" size="23" maxlength="23"/>
              </td>

              <td class="formLabel">
                <span class="spamFormLabel">
                  <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.cartorio"/>
                </span>
              </td>
              <td class="formField">
                <html:text property="cartorio" styleClass="disabled" tabindex="-1" readonly="true" size="21" maxlength="21"/>
              </td>

            </tr>

            <tr class="itemTr" >
              <td class="formLabel">
                <span class="spamFormLabel">
                  <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.desban"/>
                </span>
              </td>
              <td class="formField">
                <html:text property="desban" styleClass="disabled" tabindex="-1" readonly="true" size="21" maxlength="21"/>
              </td>

              <td class="formLabel">
                <span class="spamFormLabel">
                  <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.saldo"/>
                </span>
              </td>
              <td class="formField">
                <html:text property="saldo" styleClass="disabled" tabindex="-1" readonly="true" size="21" maxlength="21"/>
              </td>

            </tr>

            <html:hidden property="filial"/>
            <html:hidden property="tip_codigo"/>
            <html:hidden property="titulo"/>
            <html:hidden property="rep_codigo"/>
            <html:hidden property="rec_prot"/>
            <tr class="itemTr" >
              <td class="formLabel">
                <span class="spamFormLabel">
                  <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.valor"/>
                </span>
              </td>
              <td class="formField">
                <html:text property="valor" styleClass="disabled" tabindex="-1" readonly="true" size="23" maxlength="23"/>
              </td>

              <td class="formLabel">
                <span class="spamFormLabel">
                  <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.encargos"/>
                </span>
              </td>
              <td class="formField">
                <html:text property="encargos" styleClass="disabled" tabindex="-1" readonly="true"/>
              </td>

            </tr>

            <tr class="itemTr" >
              <td class="formLabel">
                <span class="spamFormLabel">
                  <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.valor_vendor"/>
                </span>
              </td>
              <td class="formField">
                <html:text property="valor_vendor" styleClass="disabled" tabindex="-1" readonly="true"/>
              </td>

              <td class="formLabel">
                <span class="spamFormLabel">
                  <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.carteira"/>
                </span>
              </td>
              <td class="formField">
                <html:text property="carteira" styleClass="disabled" tabindex="-1" readonly="true" size="60" maxlength="60"/>
              </td>

            </tr>

            <html:hidden property="link"/>
          </table>

          <table class="buttonTable" style='width:99%;'>
            <tr class="buttonTr">
              <td class="buttonTd">
                <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                  <bean:message bundle="ApplicationResources" key="jsp.select"/>
                </html:submit>
              </td>
            </tr>
          </table>

        </html:form>
        <%
        String tipo="";
        acesso.Usuario u = new acesso.Usuario();
        u = (acesso.Usuario)session.getAttribute("User");
        acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
        acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
        if(!(u.getEntidadeNegocio()==null)){
          ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
          tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
          tipo = tipoent.getTipo()+"";
        }
        if(!(tipo.equals("CLIENTE MERCADO INTERNO"))){
          %>

          <table id="TRbl_report_Jw_consulta_duplicata_transacoes" class="reportTable" style=width:99%;  border=1  frame=box>
            <%
            int counterbl_report_Jw_consulta_duplicata_transacoes=0;
            {
              portalbr.dbobj.view.Jw_consulta_duplicata_transacoes t_jw_consulta_duplicata_transacoes = new portalbr.dbobj.view.Jw_consulta_duplicata_transacoes();
              java.util.Vector res_Jw_consulta_duplicata_transacoes = null;
              portalbr.com.ConsultaDuplicataActionForm ConsultaDuplicataActionForm = (portalbr.com.ConsultaDuplicataActionForm)session.getAttribute("ConsultaDuplicataActionForm");
              if(ConsultaDuplicataActionForm!=null && (ConsultaDuplicataActionForm.getTitulo()!=null && ConsultaDuplicataActionForm.getTitulo().length()>0)) {
                com.egen.util.jdbc.JdbcUtil j = null;
                try {
                  j = new com.egen.util.jdbc.JdbcUtil();
                  StringBuilder query = new StringBuilder();
                  query.append(" SELECT tit_codigo ");
                  query.append("      , r.prt_codigo   port ");
                  query.append("      , t.trn_codigo ");
                  query.append("      , t.trn_descri   transacao ");
                  query.append("      , r.mov_data dt ");
                  query.append("      , r.mov_datvenc  venc_ant ");
                  query.append("      , r.mov_valor    valor_anterior ");
                  query.append("   FROM mov_receber    r ");
                  query.append("      , trans_rec      t ");
                  query.append("  WHERE tit_codigo     = '").append(ConsultaDuplicataActionForm.getTitulo()).append("' ");
                  query.append("    and r.tip_codigo   = '").append(ConsultaDuplicataActionForm.getTip()).append("' ");
                  query.append("    and r.emp_empresa  = '").append(ConsultaDuplicataActionForm.getEmp_empresa()).append("' ");
                  query.append("    and r.fil_filial   = '").append(ConsultaDuplicataActionForm.getFil_filial()).append("' ");
                  query.append("    AND r.trn_codigo   = t.trn_codigo  ");
                  query.append("  ORDER BY ");
                  query.append("        mov_data desc, ");
                  query.append("        sequencia ");

                  res_Jw_consulta_duplicata_transacoes = j.select(t_jw_consulta_duplicata_transacoes,
                  query.toString(),
                  null);

                } catch (Exception e){
                  res_Jw_consulta_duplicata_transacoes = null;
                } finally {
                  if(j!=null){
                    j.close();
                    j = null;
                  }
                }
              } else {
                res_Jw_consulta_duplicata_transacoes = null;
              }
              if (res_Jw_consulta_duplicata_transacoes!=null && res_Jw_consulta_duplicata_transacoes.size()>0) {
                java.lang.String port       =  null;
                java.lang.String transacao  =  null;
                java.lang.String trn_codigo =  null;
                java.sql.Timestamp dt       =  null;
                java.sql.Timestamp venc_ant =  null;
                java.lang.String tit_codigo =  null;
                double valor_anterior       =  0;
                int i_bl_report_Jw_consulta_duplicata_transacoes = 0;

                t_jw_consulta_duplicata_transacoes = (portalbr.dbobj.view.Jw_consulta_duplicata_transacoes)res_Jw_consulta_duplicata_transacoes.elementAt(i_bl_report_Jw_consulta_duplicata_transacoes);
                port           = t_jw_consulta_duplicata_transacoes.getPort()==null?"":t_jw_consulta_duplicata_transacoes.getPort();
                trn_codigo     = t_jw_consulta_duplicata_transacoes.getTrn_codigo()==null?"":t_jw_consulta_duplicata_transacoes.getTrn_codigo();
                transacao      = t_jw_consulta_duplicata_transacoes.getTransacao()==null?"":t_jw_consulta_duplicata_transacoes.getTransacao();
                dt             = (java.sql.Timestamp)t_jw_consulta_duplicata_transacoes.getDt();
                venc_ant       = (java.sql.Timestamp)t_jw_consulta_duplicata_transacoes.getVenc_ant();
                valor_anterior = t_jw_consulta_duplicata_transacoes.getValor_anterior();
                tit_codigo     = t_jw_consulta_duplicata_transacoes.getTit_codigo()==null?"":t_jw_consulta_duplicata_transacoes.getTit_codigo();
                %>
                <tr class="reportHeader" >
                  <td class="columnTdHeader" style="text-align:left;">
                    <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.port"/>
                  </td>
                  <td class="columnTdHeader" style="text-align:center;">
                    <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.trn"/>
                  </td>
                  <td class="columnTdHeader" style="text-align:left;">
                    <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.transacao"/>
                  </td>
                  <td class="columnTdHeader" style="text-align:center;">
                    <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.data"/>
                  </td>
                  <td class="columnTdHeader" style="text-align:center;">
                    <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.venc_ant"/>
                  </td>
                  <td class="columnTdHeader" style="text-align:right;">
                    <bean:message bundle="ComercialResources" key="ConsultaDuplicataForm.valor_anterior"/>
                  </td>
                </tr>
                <%
                while (i_bl_report_Jw_consulta_duplicata_transacoes<res_Jw_consulta_duplicata_transacoes.size()){
                  counterbl_report_Jw_consulta_duplicata_transacoes++;
                  String style="";
                  if (!((i_bl_report_Jw_consulta_duplicata_transacoes%2)!=0)) {
                    style="class=rowColor";
                  } else {
                    style="class=rowBlank";
                  }
                  %>
                  <tr <%= style %> id='TRbl_report_Jw_consulta_duplicata_transacoes<%=counterbl_report_Jw_consulta_duplicata_transacoes%>' >
                    <td class="reportColumn" style="text-align:left;">
                      <%= port %>
                    </td>
                    <td class="reportColumn" style="text-align:center;">
                      <%= trn_codigo %>
                    </td>
                    <td class="reportColumn" style="text-align:left;">
                      <%= transacao %>
                    </td>
                    <td class="reportColumn" style="text-align:center;">
                      <%= com.egen.util.text.FormatDate.format(dt, "dd/MM/yyyy") %>
                    </td>
                    <td class="reportColumn" style="text-align:center;">
                      <%= com.egen.util.text.FormatDate.format(venc_ant, "dd/MM/yyyy") %>
                    </td>
                    <td class="reportColumn" style="text-align:right;">
                      <%= com.egen.util.text.FormatNumber.format(valor_anterior, "##,##0.00") %>
                    </td>
                  </tr>
                  <%
                  if (++i_bl_report_Jw_consulta_duplicata_transacoes >= res_Jw_consulta_duplicata_transacoes.size()) {
                    break;
                  }
                  t_jw_consulta_duplicata_transacoes = (portalbr.dbobj.view.Jw_consulta_duplicata_transacoes)res_Jw_consulta_duplicata_transacoes.elementAt(i_bl_report_Jw_consulta_duplicata_transacoes);
                  port           = t_jw_consulta_duplicata_transacoes.getPort()==null?"":t_jw_consulta_duplicata_transacoes.getPort();
                  trn_codigo     = t_jw_consulta_duplicata_transacoes.getTrn_codigo()==null?"":t_jw_consulta_duplicata_transacoes.getTrn_codigo();
                  transacao      = t_jw_consulta_duplicata_transacoes.getTransacao()==null?"":t_jw_consulta_duplicata_transacoes.getTransacao();
                  dt             = (java.sql.Timestamp)t_jw_consulta_duplicata_transacoes.getDt();
                  venc_ant       = (java.sql.Timestamp)t_jw_consulta_duplicata_transacoes.getVenc_ant();
                  valor_anterior = t_jw_consulta_duplicata_transacoes.getValor_anterior();
                  tit_codigo     = t_jw_consulta_duplicata_transacoes.getTit_codigo()==null?"":t_jw_consulta_duplicata_transacoes.getTit_codigo();
                }
              }
            }
            %>
          </table>


          <%
        }
        %>
        <html:form action="com/ConsultaDuplicataForm.do" method="post" styleClass="baseForm">
          <table class="buttonTable" style='width:;'>
            <tr class="buttonTr">
              <td class="buttonTd">
                <html:button onclick="history.go(-1);" styleClass="baseButton" property="back_action">
                  <bean:message bundle="ApplicationResources" key="jsp.back"/>
                </html:button>
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

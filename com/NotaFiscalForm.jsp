<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      <bean:message bundle="ComercialResources" key="NotaFiscal.titulo"/>
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

            <html:form action="com/NotaFiscalForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="nmro_serie"/>
                    <html:errors property="empresa"/>
                    <html:errors property="filial"/>
                    <html:errors property="cliente"/>
                    <html:errors property="status"/>
                    <html:errors property="data_emissao"/>
                    <html:errors property="valor_total"/>
                    <html:errors property="requisicao"/>
                    <html:errors property="rep"/>
                    <html:errors property="transportadora"/>
                    <html:errors property="cons_desc"/>
                    <html:errors property="bonif1"/>
                    <html:errors property="bonif2"/>
                    <html:errors property="desc_pont"/>
                    <html:errors property="peso_bruto"/>
                    <html:errors property="peso_liq"/>
                    <html:errors property="nfs_icms"/>
                    <html:errors property="nfs_valicm"/>
                    <html:errors property="nfs_qtdvol"/>
                    <html:errors property="chave_nfe"/>
                    <html:errors property="natoper_codigo"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_nf"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <html:hidden property="nf_nmro"/>
                <html:hidden property="emp_empresa"/>
                <html:hidden property="fil_filial"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="NotaFiscal.nmro_serie"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="nmro_serie" styleClass="disabled" tabindex="-1" readonly="true" size="12" maxlength="12"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="NotaFiscal.empresa"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="empresa" styleClass="disabled" tabindex="-1" readonly="true" size="56" maxlength="56"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="NotaFiscal.filial"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="filial" styleClass="disabled" tabindex="-1" readonly="true" size="57" maxlength="57"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="NotaFiscal.cliente"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cliente" styleClass="disabled" tabindex="-1" readonly="true" size="50" maxlength="50"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="NotaFiscal.status"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="status" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="NotaFiscal.data_emissao"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_emissao" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="NotaFiscal.valor_total"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="valor_total" styleClass="disabled" tabindex="-1" readonly="true" size="43" maxlength="43"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="NotaFiscal.requisicao"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="requisicao" styleClass="disabled" tabindex="-1" readonly="true" size="8" maxlength="8"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="NotaFiscal.rep"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="rep" styleClass="disabled" tabindex="-1" readonly="true" size="50" maxlength="45"/>
                  </td>
                </tr>

                <html:hidden property="comissao"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="NotaFiscal.transportadora"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="transportadora" styleClass="disabled" tabindex="-1" readonly="true" size="70" maxlength="78"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Consignatário
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cons_desc" styleId="cons_desc" styleClass="disabled" tabindex="-1" readonly="true" size="70"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="NotaFiscal.bonif1"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="bonif1" styleClass="disabled" tabindex="-1" readonly="true" size="9" maxlength="9"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="NotaFiscal.bonif2"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="bonif2" styleClass="disabled" tabindex="-1" readonly="true" size="9" maxlength="9"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="NotaFiscal.desc_pont"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="desc_pont" styleClass="disabled" tabindex="-1" readonly="true" size="9" maxlength="9"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="NotaFiscal.peso_bruto"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="peso_bruto" styleClass="disabled" tabindex="-1" readonly="true" size="18" maxlength="18"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="NotaFiscal.peso_liq"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="peso_liq" styleClass="disabled" tabindex="-1" readonly="true" size="18" maxlength="18"/>
                  </td>
                </tr>

                <html:hidden property="cs"/>
                <html:hidden property="prt_codigo"/>
                <html:hidden property="nfs_serie"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="NotaFiscal.nfs_icms"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="nfs_icms" styleClass="disabled" tabindex="-1" readonly="true" size="24" maxlength="24"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="NotaFiscal.nfs_valicm"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="nfs_valicm" styleClass="disabled" tabindex="-1" readonly="true" size="26" maxlength="26"/>
                  </td>
                </tr>

                <html:hidden property="nf_serie"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="NotaFiscal.nfs_qtdvol"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="nfs_qtdvol" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Chave NF-e
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="chave_nfe" styleId="chave_nfe" styleClass="disabled" tabindex="-1" readonly="true" size="51" maxlength="44"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Natureza
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="natoper_codigo" styleId="natoper_codigo" styleClass="disabled" tabindex="-1" readonly="true" size="51"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
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
            %>
            <div align="center">
              <table id="TRbl_report_Jw_consulta_nf_dup" class="reportTable" style=width:30%; border=1;   >
                <%
                int counterbl_report_Jw_consulta_nf_dup = 0;
                java.util.Vector res_Jw_consulta_nf_dup = null;
                portalbr.com.NotaFiscalActionForm NotaFiscalActionForm = (portalbr.com.NotaFiscalActionForm)session.getAttribute("NotaFiscalActionForm");
                {
                  portalbr.dbobj.view.Jw_consulta_nf_dup t_jw_consulta_nf_dup = new portalbr.dbobj.view.Jw_consulta_nf_dup();
                  com.egen.util.jdbc.JdbcUtil j = null;
                  try {
                    j = new com.egen.util.jdbc.JdbcUtil();
                    StringBuilder query = new StringBuilder();
                    query.append(" SELECT t.tit_codigo duplicatas ");
                    query.append("      , t.tip_codigo ");
                    query.append("      , v.ped_nmro   ");
                    query.append("      , t.emp_empresa ");
                    query.append("      , t.fil_filial ");
                    query.append("      , t.nsa_numero ");
                    query.append("      , t.nsa_serie  ");
                    query.append("      , nvl(p.ped_nmro,0) pedido ");
                    query.append("      , to_char(tit.tit_datvenc,'dd/mm/yyyy') data_vencimento ");
                    query.append("   FROM tit_nf t ");
                    query.append("      , titulos tit ");
                    query.append("      , notas_fiscais_saida_ped_venda v ");
                    query.append("      , ped p ");
                    query.append("  WHERE t.nsa_numero  = ").append(NotaFiscalActionForm.getNf_nmro());
                    query.append("    AND p.ped_nmro (+)= v.ped_nmro ");
                    query.append("    AND t.nsa_serie   = '").append(NotaFiscalActionForm.getNfs_serie()).append("'");
                    query.append("    AND t.emp_empresa = '"+NotaFiscalActionForm.getEmp_empresa()+"' ");
                    query.append("    AND t.fil_filial  = '").append(NotaFiscalActionForm.getFil_filial()).append("'");
                    query.append("    AND tit.emp_empresa = t.emp_empresa ");
                    query.append("    AND tit.fil_filial = t.fil_filial ");
                    query.append("    AND tit.tip_codigo = t.tip_codigo ");
                    query.append("    AND tit.tit_codigo = t.tit_codigo ");
                    query.append("    AND v.nfs_nmro    (+) = t.nsa_numero ");
                    query.append("    AND v.nfs_serie   (+) = t.nsa_serie ");
                    query.append("    AND v.fil_filial  (+) = t.fil_filial ");
                    query.append("    AND v.emp_empresa (+) = t.emp_empresa ");
                    query.append("    AND t.nsa_numero  > 0");

                    res_Jw_consulta_nf_dup = j.select(t_jw_consulta_nf_dup,
                    query.toString(),
                    null);

                  } catch (Exception e){
                    session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                    %>
                    <jsp:forward page="/system/ErrorPage.jsp"/>
                    <%
                  } finally {
                    if(j!=null) {
                      j.close();
                      j = null;
                    }
                  }
                  if (res_Jw_consulta_nf_dup!=null && res_Jw_consulta_nf_dup.size()>0) {
                    java.lang.String duplicatas        =  null;
                    java.lang.Integer ped_nmro         =  null;
                    java.lang.String fil_filial        =  null;
                    java.lang.Integer nsa_numero       =  null;
                    java.lang.String nsa_serie         =  null;
                    java.lang.String pedido            =  null;
                    java.lang.String emp_empresa       =  null;
                    java.lang.String tip_codigo        =  null;
                    java.lang.String data_vencimento   =  null;

                    int i_bl_report_Jw_consulta_nf_dup =  0;

                    t_jw_consulta_nf_dup = (portalbr.dbobj.view.Jw_consulta_nf_dup)res_Jw_consulta_nf_dup.elementAt(i_bl_report_Jw_consulta_nf_dup);
                    duplicatas  = t_jw_consulta_nf_dup.getDuplicatas()==null?"":t_jw_consulta_nf_dup.getDuplicatas();
                    ped_nmro    = t_jw_consulta_nf_dup.getPed_nmro();
                    fil_filial  = t_jw_consulta_nf_dup.getFil_filial()==null?"":t_jw_consulta_nf_dup.getFil_filial();
                    nsa_numero  = t_jw_consulta_nf_dup.getNsa_numero();
                    nsa_serie   = t_jw_consulta_nf_dup.getNsa_serie()==null?"":t_jw_consulta_nf_dup.getNsa_serie();
                    pedido      = t_jw_consulta_nf_dup.getPedido()==null?"":t_jw_consulta_nf_dup.getPedido();
                    emp_empresa = t_jw_consulta_nf_dup.getEmp_empresa()==null?"":t_jw_consulta_nf_dup.getEmp_empresa();
                    tip_codigo  = t_jw_consulta_nf_dup.getTip_codigo()==null?"":t_jw_consulta_nf_dup.getTip_codigo();
                    data_vencimento = t_jw_consulta_nf_dup.getData_vencimento()==null?"":t_jw_consulta_nf_dup.getData_vencimento();
                    %>
                    <tr class="reportHeader" >
                      <%
                      if(!(tipo.equals("CLIENTE MERCADO INTERNO"))){
                        %>
                        <td class="columnTdHeader" style="text-align:left;">
                          <bean:message bundle="ComercialResources" key="NotaFiscal.duplicatas"/>
                        </td>
                        <%
                      }
                      %>
                      <td class="columnTdHeader" style="text-align:right;">
                        <bean:message bundle="ComercialResources" key="NotaFiscal.pedidos"/>
                      </td>
                      <%
                      if(!(tipo.equals("CLIENTE MERCADO INTERNO"))){
                        %>
                        <td class="columnTdHeader" style="text-align:center;">
                          Data Vencimento
                        </td>
                        <%
                      }
                      %>
                    </tr>
                    <%
                    while (i_bl_report_Jw_consulta_nf_dup<res_Jw_consulta_nf_dup.size()){
                      counterbl_report_Jw_consulta_nf_dup++;
                      String style="";
                      if (!((i_bl_report_Jw_consulta_nf_dup%2)!=0)) {
                        style="rowColor";
                      } else {
                        style="rowBlank";
                      }
                      %>
                      <tr class=<%= style %> id='TRbl_report_Jw_consulta_nf_dup<%=counterbl_report_Jw_consulta_nf_dup%>' >
                        <%
                        if(!(tipo.equals("CLIENTE MERCADO INTERNO"))){
                          %>
                          <td class="reportColumn" style="text-align:left;">
                            <a href="../com/ConsultaDuplicataForm.do?select_action=&titulo=<%= duplicatas %>&nf=<%= nsa_numero %>&serie=<%= nsa_serie %>&rep=<%= NotaFiscalActionForm.getRep() %>&duplicata=<%= duplicatas %>&pedido=<%= ((ped_nmro+"").equals("null"))?"":ped_nmro %>&existe=<%= pedido %>&emp_empresa=<%= emp_empresa %>&fil_filial=<%= fil_filial %>&tip=<%= tip_codigo%>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                              <%= duplicatas %>
                            </a>
                          </td>
                          <%
                        }
                        %>
                        <td class="reportColumn" style="text-align:right;">
                          <%
                          if(pedido.equals("0")) {
                            %>
                            <%= ((ped_nmro!=null)?ped_nmro.toString():"") %>
                            <%
                          } else {
                            %>
                            <a href="../com/ConsultaPedidos_iForm.do?select_action=&pedido_beira_rio=<%= ped_nmro %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                              <%= ((ped_nmro!=null)?ped_nmro.toString():"") %>

                              <%
                            }
                            %>
                          </td>


                          <%
                          if(!(tipo.equals("CLIENTE MERCADO INTERNO"))){
                            %>
                            <td class="reportColumn" style="text-align: center">
                              <%= data_vencimento %>
                            </td>
                            <%
                          }
                          %>



                        </tr>
                        <%
                        if (++i_bl_report_Jw_consulta_nf_dup >= res_Jw_consulta_nf_dup.size()) {
                          break;
                        }
                        t_jw_consulta_nf_dup = (portalbr.dbobj.view.Jw_consulta_nf_dup)res_Jw_consulta_nf_dup.elementAt(i_bl_report_Jw_consulta_nf_dup);
                        duplicatas  = t_jw_consulta_nf_dup.getDuplicatas()==null?"":t_jw_consulta_nf_dup.getDuplicatas();
                        ped_nmro    = t_jw_consulta_nf_dup.getPed_nmro();
                        fil_filial  = t_jw_consulta_nf_dup.getFil_filial()==null?"":t_jw_consulta_nf_dup.getFil_filial();
                        nsa_numero  = t_jw_consulta_nf_dup.getNsa_numero();
                        nsa_serie   = t_jw_consulta_nf_dup.getNsa_serie()==null?"":t_jw_consulta_nf_dup.getNsa_serie();
                        pedido      = t_jw_consulta_nf_dup.getPedido()==null?"":t_jw_consulta_nf_dup.getPedido();
                        emp_empresa = t_jw_consulta_nf_dup.getEmp_empresa()==null?"":t_jw_consulta_nf_dup.getEmp_empresa();
                        tip_codigo  = t_jw_consulta_nf_dup.getTip_codigo()==null?"":t_jw_consulta_nf_dup.getTip_codigo();
                        data_vencimento = t_jw_consulta_nf_dup.getData_vencimento()==null?"":t_jw_consulta_nf_dup.getData_vencimento();
                      }
                    }
                  }
                  %>
                </table>
              </div>




              <html:form action="com/NotaFiscalForm.do" method="post" styleClass="baseForm">
                <table class="buttonTable" style='width:;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:button accesskey="b" onclick="history.go(-1);" styleClass="baseButton" property="back_action">
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

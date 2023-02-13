<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta de Talões a Enviar/Receber por Fornecedor
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(151)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/Pse0053_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="tipo"/>
                    <html:errors property="filial"/>
                    <html:errors property="dt_inicial"/>
                    <html:errors property="dt_final"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="tipo" styleId="tipo" styleClass="disabled" readonly="true" value="<%= (String)session.getAttribute("pse0053_r_tipo") %>" size="10" maxlength="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Filial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="filial" styleId="filial" styleClass="disabled" readonly="true" value="<%= (String)session.getAttribute("pse0053_r_filial") %>" size="60" maxlength="60"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Período de
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_inicial" styleId="dt_inicial" style="text-align:center;" styleClass="disabled" readonly="true" value="<%= (String)session.getAttribute("pse0053_dt_inicial") %>" size="11" maxlength="11"/>
                    <span class="spamFormLabel">
                      a
                    </span>
                    <html:text property="dt_final" styleId="dt_final" style="text-align:center;" styleClass="disabled" readonly="true" value="<%= (String)session.getAttribute("pse0053_dt_final") %>" size="11" maxlength="11"/>
                  </td>
                </tr>

              </table>

            </html:form>
            <%
            %>

            <%
            java.util.Vector res_Jw_pse0053_forn = (java.util.Vector)session.getAttribute("res_Jw_pse0053_forn");
            java.util.Vector res_Jw_pse0053_ref = (java.util.Vector)session.getAttribute("res_Jw_pse0053_ref");
            int tamanho_ref = res_Jw_pse0053_ref.size();
            int total_pares = 0;
            double valorTotalNota = 0;
            brportal.ind.Pse0053 p = new brportal.ind.Pse0053();
            int quantidade = 0;
            int quantidade_total = 0;
            java.lang.String fil_filial =  null;
            int for_codigo =  0;
            int pro_numero =  0;
            java.util.Vector res_Jw_pse0053_total_preco = null;
            java.util.Vector res_Jw_pse0053_total_preco_aberto = null;
            java.util.Vector res_Jw_pse0053_notas_fiscais = null;
            String data_inicial = (String)session.getAttribute("pse0053_dt_inicial");
            String data_final = (String)session.getAttribute("pse0053_dt_final");
            String tipo = (String)session.getAttribute("pse0053_tipo");
            %>

            <form  name="bl_report_Jw_pse0053_forn" id="bl_report_Jw_pse0053_forn" class="baseForm" method="post" >


              <%
              if (res_Jw_pse0053_forn!=null && res_Jw_pse0053_forn.size()>0) {
                %>

                <table id="TRbl_report_Jw_pse0053_forn"  class="reportTable"   style="width:99%; " border=1;  >
                  <%
                  %>
                  <!-- <tr class="reportTr"> -->
                  <tr class="reportHeader3">
                    <td colspan=2>
                    </td>
                    <%
                    int i_bl_report_Jw_pse0053_ref2 = 0;
                    while (i_bl_report_Jw_pse0053_ref2<res_Jw_pse0053_ref.size()) {
                      portalbr.dbobj.view.Jw_pse0053_ref t_jw_pse0053_ref = (portalbr.dbobj.view.Jw_pse0053_ref)res_Jw_pse0053_ref.elementAt(i_bl_report_Jw_pse0053_ref2);
                      %>
                      <td style="text-align:right;" >
                        <%= t_jw_pse0053_ref.getRef_cdgo() %>
                      </br>
                    </td>
                    <%
                    i_bl_report_Jw_pse0053_ref2++;
                  }
                  %>
                  <td>
                  </td>
                  <td>
                  </td>
                </tr>
                <tr class="reportTr">
                  <td colspan=2>
                  </td>
                  <%
                  i_bl_report_Jw_pse0053_ref2 = 0;
                  while (i_bl_report_Jw_pse0053_ref2<res_Jw_pse0053_ref.size()) {
                    portalbr.dbobj.view.Jw_pse0053_ref t_jw_pse0053_ref = (portalbr.dbobj.view.Jw_pse0053_ref)res_Jw_pse0053_ref.elementAt(i_bl_report_Jw_pse0053_ref2);
                    %>
                    <td style="text-align:right;" >
                      <%= com.egen.util.text.FormatNumber.format(t_jw_pse0053_ref.getPreco(), "##,##0.00") %>
                    </td>
                    <%
                    i_bl_report_Jw_pse0053_ref2++;
                  }
                  %>
                  <td>
                  </td>
                  <td>
                  </td>
                </tr>

                <tr class="reportTr">
                  <td class="columnTdHeader" style="text-align:center;" width=1; >
                    Filial
                  </td>
                  <!--
                    <td class="columnTdHeader" style="text-align:right;" > Fornec. </td>
                  -->

                  <td class="columnTdHeader" style="text-align:center;" width=1; >
                    Proc.
                  </td>
                  <td class="columnTdHeader" colspan= <%= tamanho_ref %>>
                  </td>
                  <td class="columnTdHeader" style="text-align:right;" >
                    <b>
                      Total
                    </b>
                  </td>
                  <td>
                    Rem./Talões
                  </td>




                </tr>

                <%
                int i_bl_report_Jw_pse0053_forn = 0;
                while (i_bl_report_Jw_pse0053_forn<res_Jw_pse0053_forn.size()) {
                  portalbr.dbobj.view.Jw_pse0053_forn t_jw_pse0053_forn = (portalbr.dbobj.view.Jw_pse0053_forn)res_Jw_pse0053_forn.elementAt(i_bl_report_Jw_pse0053_forn);
                  fil_filial = t_jw_pse0053_forn.getFil_filial()==null?"":t_jw_pse0053_forn.getFil_filial();
                  for_codigo = t_jw_pse0053_forn.getFor_codigo();
                  pro_numero = t_jw_pse0053_forn.getPro_numero();
                  String style_bl_report_Jw_pse0053_forn="";
                  if (!((i_bl_report_Jw_pse0053_forn%2)!=0)) {
                    style_bl_report_Jw_pse0053_forn="rowColor";
                  } else {
                    style_bl_report_Jw_pse0053_forn="rowColor";
                  }
                  %>

                  <tr class='<%= style_bl_report_Jw_pse0053_forn %>' id="TRbl_report_Jw_pse0053_forn<%=i_bl_report_Jw_pse0053_forn%>" >
                    <td class="reportColumn" style="text-align:center;" >
                      <%= fil_filial %>
                    </td>
                    <!--
                      <td class="reportColumn" style="text-align:right;" > <%= for_codigo %> </td>
                    -->

                    <td class="reportColumn" style="text-align:center;" >
                      <%= pro_numero %>
                    </td>

                    <%
                    int i_bl_report_Jw_pse0053_ref = 0;
                    while (i_bl_report_Jw_pse0053_ref<res_Jw_pse0053_ref.size()) {
                      portalbr.dbobj.view.Jw_pse0053_ref t_ref = (portalbr.dbobj.view.Jw_pse0053_ref)res_Jw_pse0053_ref.elementAt(i_bl_report_Jw_pse0053_ref);
                      %>

                      <td style="text-align:right;" >
                        <%
                        quantidade = p.getTotal_ref(fil_filial+"" , for_codigo+"", pro_numero+"", t_ref.getRef_cdgo()+"", (String)session.getAttribute("pse0053_dt_inicial"), (String)session.getAttribute("pse0053_dt_final"), (String)session.getAttribute("pse0053_tipo"), t_ref.getPreco());
                        quantidade_total += quantidade;
                        if(quantidade>0) {
                          %>
                          <%= com.egen.util.text.FormatNumber.format(quantidade, "##,##0") %>
                          <%
                        } else {
                          %>
                          <font color="gray">
                            0
                          </font>
                          <%
                        }
                        %>
                      </td>

                      <%
                      i_bl_report_Jw_pse0053_ref++;
                    }
                    %>

                    <td class="reportColumn" style="text-align:right;" >
                      <b>
                        <%= com.egen.util.text.FormatNumber.format(quantidade_total, "##,##0") %>
                      </b>

                      <%
                      total_pares += quantidade_total;
                      quantidade_total = 0;
                      %>
                    </td>
                    <td class="reportColumn" style="text-align:center;" width="5%"; title="Remessas/Talões">
                      <img src="../img/viewmag.png" name="imagem" onmouseover="this.src='../img/viewmag_s.png'" onmouseout="this.src='../img/viewmag.png'" onclick="wopen('../ind/Pse0053_mGrid.do?select_action=&pro_numero=<%= pro_numero %>&fil_filial=<%= fil_filial %>','_blank',700,500)" STYLE="cursor:hand">
                    </td>
                  </tr>

                  <tr>


                    <td colspan= <%= tamanho_ref+4 %>>
                      <table border="0" width="45%">
                        <tr valign="top" align="left">
                          <td >

                            <%
                            com.egen.util.jdbc.JdbcUtil j = null;
                            try {
                              j = new com.egen.util.jdbc.JdbcUtil();
                              portalbr.dbobj.view.Jw_pse0053_total_preco t_jw_pse0053_total_preco = new portalbr.dbobj.view.Jw_pse0053_total_preco();
                              String[][] select = {{"pares",null},{"preco",null},{"total",null},};
                              StringBuilder sb = new StringBuilder();
                              sb.append("select pares, preco, pares*preco total from ( ");
                              sb.append(" SELECT SUM(tal_pares) pares, ");
                              sb.append("  pck_atelier.get_preco(a.emp_empresa,a.fil_filial,pck_filial.get_unn_codigo(a.fil_filial,a.emp_empresa),a.lin_cdgo,a.ref_cdgo,null,a.pro_numero,a.for_codigo,a.fen_seq) preco ");
                              sb.append("   FROM atelier_pre_envio a ");
                              sb.append("   WHERE a.fil_filial = '"+fil_filial+"' ");
                              sb.append("     AND a.for_codigo = "+for_codigo+"");
                              sb.append("     AND a.pro_numero = "+pro_numero+" ");
                              sb.append("     AND a.data_pre_envio >= to_date('"+data_inicial+"','dd/mm/yyyy') ");
                              sb.append("     AND a.data_pre_envio < to_date('"+data_final+"','dd/mm/yyyy') + 1 ");
                              sb.append("     AND (('"+tipo+"' = 'E' AND a.status IS NULL) OR ('"+tipo+"' = 'R' AND a.status_consiste_atelier = 'C' AND status_retorno IS NULL)) ");
                              sb.append("group by pck_atelier.get_preco(a.emp_empresa,a.fil_filial,pck_filial.get_unn_codigo(a.fil_filial,a.emp_empresa),a.lin_cdgo,a.ref_cdgo,null,a.pro_numero,a.for_codigo,a.fen_seq)) order by preco ");


                              res_Jw_pse0053_total_preco = j.select(t_jw_pse0053_total_preco, sb.toString(), null);



                              portalbr.dbobj.view.Jw_pse0053_total_preco_aberto t_jw_pse0053_total_preco_aberto = new portalbr.dbobj.view.Jw_pse0053_total_preco_aberto();
                              StringBuilder sbaberto = new StringBuilder();
                              sbaberto.append(" SELECT 0 pro_numero ");
                              sbaberto.append("       ,t.lin_cdgo ");
                              sbaberto.append("       ,t.ref_cdgo ");
                              sbaberto.append("       ,t.cab_cdgo ");
                              sbaberto.append("       ,(SELECT DISTINCT preco_unidade ");
                              sbaberto.append("           FROM tab_preco_atelier t2 ");
                              sbaberto.append("          WHERE t.emp_empresa = t2.emp_empresa ");
                              sbaberto.append("            AND t.fil_filial = t2.fil_filial ");
                              sbaberto.append("            AND t.unn_codigo = t2.unn_codigo ");
                              sbaberto.append("            AND t.lin_cdgo = t2.lin_cdgo ");
                              sbaberto.append("            AND t.ref_cdgo = t2.ref_cdgo ");
                              sbaberto.append("            AND t.cab_cdgo = t2.cab_cdgo ");
                              sbaberto.append("            AND t.pro_numero = t2.pro_numero ");
                              sbaberto.append("            AND t.pro_tipo = t2.pro_tipo ");
                              sbaberto.append("            AND t.for_codigo = t2.for_codigo ");
                              sbaberto.append("            AND t.fen_seq = t2.fen_seq ");
                              sbaberto.append("            AND t.codigo_cond_pgto = t2.codigo_cond_pgto ");
                              sbaberto.append("            AND t.data_validade = t2.data_ini_validade) preco ");
                              sbaberto.append("       ,tal_pares pares ");
                              sbaberto.append("   FROM (SELECT t.emp_empresa ");
                              sbaberto.append("               ,t.fil_filial ");
                              sbaberto.append("               ,t.unn_codigo ");
                              sbaberto.append("               ,t.lin_cdgo ");
                              sbaberto.append("               ,t.ref_cdgo ");
                              sbaberto.append("               ,t.cab_cdgo ");
                              sbaberto.append("               ,t.pro_numero ");
                              sbaberto.append("               ,t.pro_tipo ");
                              sbaberto.append("               ,t.for_codigo ");
                              sbaberto.append("               ,t.fen_seq ");
                              sbaberto.append("               ,t.codigo_cond_pgto ");
                              sbaberto.append("               ,MAX(data_ini_validade) data_validade ");
                              sbaberto.append("               ,SUM(ta.tal_pares) tal_pares ");
                              sbaberto.append("           FROM tab_preco_atelier t ");
                              sbaberto.append("               ,atelier_pre_envio a ");
                              sbaberto.append("               ,talao ta ");
                              sbaberto.append("          WHERE a.fil_filial = '"+fil_filial+"' ");
                              sbaberto.append("            AND a.for_codigo = "+for_codigo);
                              sbaberto.append("            AND a.pro_numero = "+pro_numero);
                              sbaberto.append("            AND a.data_pre_envio >= TO_DATE('"+data_inicial+"', 'dd/mm/yyyy') ");
                              sbaberto.append("            AND a.data_pre_envio < TO_DATE('"+data_final+"', 'dd/mm/yyyy') + 1 ");
                              sbaberto.append("            AND ta.rem_nro = a.rem_nro ");
                              sbaberto.append("            AND ta.tal_nro = a.tal_nro ");
                              sbaberto.append("            AND t.emp_empresa = a.emp_empresa ");
                              sbaberto.append("            AND t.fil_filial = a.fil_filial ");
                              sbaberto.append("            AND t.for_codigo = a.for_codigo ");
                              sbaberto.append("            AND t.pro_numero = a.pro_numero ");
                              sbaberto.append("            AND t.lin_cdgo = a.lin_cdgo ");
                              sbaberto.append("            AND t.ref_cdgo = a.ref_cdgo ");
                              sbaberto.append("            AND unn_codigo = pck_filial.get_unn_codigo(t.fil_filial, t.emp_empresa) ");
                              sbaberto.append("            AND (('"+tipo+"' = 'E' AND a.status IS NULL) OR ('"+tipo+"' = 'R' AND a.status_consiste_atelier = 'C' AND status_retorno IS NULL)) ");
                              sbaberto.append("          GROUP BY t.emp_empresa ");
                              sbaberto.append("                  ,t.fil_filial ");
                              sbaberto.append("                  ,t.unn_codigo ");
                              sbaberto.append("                  ,t.lin_cdgo ");
                              sbaberto.append("                  ,t.ref_cdgo ");
                              sbaberto.append("                  ,t.cab_cdgo ");
                              sbaberto.append("                  ,t.pro_numero ");
                              sbaberto.append("                  ,t.pro_tipo ");
                              sbaberto.append("                  ,t.for_codigo ");
                              sbaberto.append("                  ,t.fen_seq ");
                              sbaberto.append("                  ,t.codigo_cond_pgto) t ");
                              res_Jw_pse0053_total_preco_aberto = j.select(t_jw_pse0053_total_preco_aberto, sbaberto.toString(), null);



                              portalbr.dbobj.view.Jw_pse0053_notas_fiscais t_jw_pse0053_notas_fiscais = new portalbr.dbobj.view.Jw_pse0053_notas_fiscais();
                              StringBuilder sbnf = new StringBuilder();
                              sbnf.append(" SELECT DISTINCT n.fil_filial ");
                              sbnf.append("                ,n.nfs_serie ");
                              sbnf.append("                ,n.nfs_nmro ");
                              sbnf.append("   FROM atelier_pre_envio a ");
                              sbnf.append("      , cpr.dom_item_ordem_item_requisicao i ");
                              sbnf.append("      , atelier_rem_taloes_oc o ");
                              sbnf.append("      , fat.notas_fiscais_saida_requis n ");
                              sbnf.append("  WHERE a.fil_filial = '"+fil_filial+"' ");
                              sbnf.append("    AND a.for_codigo = "+for_codigo);
                              sbnf.append("    AND a.pro_numero = "+pro_numero);
                              sbnf.append("    AND a.data_pre_envio >= TO_DATE('"+data_inicial+"', 'dd/mm/yyyy') ");
                              sbnf.append("    AND a.data_pre_envio < TO_DATE('"+data_final+"', 'dd/mm/yyyy') + 1 ");
                              sbnf.append("    AND a.rem_nro = o.aroc_rem_nro ");
                              sbnf.append("    AND a.tal_nro = o.tal_nro ");
                              sbnf.append("    AND a.pro_numero = o.pro_numero ");
                              sbnf.append("    AND a.for_codigo = o.for_codigo ");
                              sbnf.append("    AND o.aroc_oco_numero = i.oco_numero ");
                              sbnf.append("    AND i.reqnf_numero = n.reqnf_numero ");


                              res_Jw_pse0053_notas_fiscais = j.select(t_jw_pse0053_notas_fiscais, sbnf.toString(), null);



                            } catch (Exception e){
                            } finally {
                            if(j!=null){j.close();}
                          }
                          %>

                          <form  name="bl_report_Jw_pse0053_total_preco" id="bl_report_Jw_pse0053_total_preco" class="baseForm" method="post"  >


                            <%
                            if (res_Jw_pse0053_total_preco!=null && res_Jw_pse0053_total_preco.size()>0) {
                              %>

                              <table id="TRbl_report_Jw_pse0053_total_preco"  class="reportTable"   style="width:95%;" border=1;  >
                                <%
                                int pares =  0;
                                double preco =  0;
                                double total =  0;
                                %>

                                <tr class="reportHeader2">
                                  <td class="columnTdHeader" style="text-align:right;" >
                                    <font color="black">
                                      Pares
                                    </font>
                                  </td>

                                  <td class="columnTdHeader" style="text-align:right;" >
                                    <font color="black">
                                      Preço MO.
                                    </font>
                                  </td>

                                  <td class="columnTdHeader" style="text-align:right;" >
                                    <font color="black">
                                      Total
                                    </font>
                                  </td>

                                </tr>

                                <%
                                int i_bl_report_Jw_pse0053_total_preco = 0;
                                while (i_bl_report_Jw_pse0053_total_preco<res_Jw_pse0053_total_preco.size()) {
                                  portalbr.dbobj.view.Jw_pse0053_total_preco t_jw_pse0053_total_preco = (portalbr.dbobj.view.Jw_pse0053_total_preco)res_Jw_pse0053_total_preco.elementAt(i_bl_report_Jw_pse0053_total_preco);
                                  pares = t_jw_pse0053_total_preco.getPares();
                                  preco = t_jw_pse0053_total_preco.getPreco();
                                  total = t_jw_pse0053_total_preco.getTotal();
                                  String style_bl_report_Jw_pse0053_total_preco="";
                                  if (!((i_bl_report_Jw_pse0053_total_preco%2)!=0)) {
                                    style_bl_report_Jw_pse0053_total_preco="rowColor";
                                  } else {
                                    style_bl_report_Jw_pse0053_total_preco="rowBlank";
                                  }
                                  %>

                                  <tr class='<%= style_bl_report_Jw_pse0053_total_preco %>' id="TRbl_report_Jw_pse0053_total_preco<%=i_bl_report_Jw_pse0053_total_preco%>" >
                                    <td class="reportColumn" style="text-align:right;" >
                                      <%= com.egen.util.text.FormatNumber.format(pares, "##,##0") %>
                                    </td>

                                    <td class="reportColumn" style="text-align:right;" >
                                      <%= com.egen.util.text.FormatNumber.format(preco, "##,##0.00") %>
                                    </td>

                                    <td class="reportColumn" style="text-align:right;" >
                                      <%= com.egen.util.text.FormatNumber.format(total, "##,##0.00") %>
                                      <%
                                      valorTotalNota += total;
                                      %>
                                    </td>

                                  </tr>

                                  <%
                                  i_bl_report_Jw_pse0053_total_preco++;
                                  if (i_bl_report_Jw_pse0053_total_preco<res_Jw_pse0053_total_preco.size()) {
                                    t_jw_pse0053_total_preco = (portalbr.dbobj.view.Jw_pse0053_total_preco)res_Jw_pse0053_total_preco.elementAt(i_bl_report_Jw_pse0053_total_preco);
                                    pares = t_jw_pse0053_total_preco.getPares();
                                    preco = t_jw_pse0053_total_preco.getPreco();
                                    total = t_jw_pse0053_total_preco.getTotal();
                                  } else {
                                  }
                                }
                                %>

                              </table>



                              <%
                            }
                            %>

                          </form>




                        </td>
                        <td>
                          <table class="reportTable"   style="width:95%;" border=1;  >
                            <tr class="reportHeader2">
                              <td class="columnTdHeader" style="text-align:right;" >
                                <font color="black">
                                  Pares
                                </font>
                              </td>
                              <td class="columnTdHeader" style="text-align:right;" >
                                <font color="black">
                                  Valor Processo
                                </font>
                              </td>
                              <td class="columnTdHeader" style="text-align:right;" >
                                <font color="black">
                                  Total
                                </font>
                              </td>
                            </tr>
                            <tr class='rowColor' >
                              <td class="reportColumn" style="text-align:right;" >
                                <%= com.egen.util.text.FormatNumber.format(total_pares, "##,##0") %>
                              </td>
                              <td class="reportColumn" style="text-align:right;" >
                                <%= com.egen.util.text.FormatNumber.format(p.getProcesso_fab_custo(pro_numero+"",fil_filial), "##,##0.00") %>
                              </td>
                              <td class="reportColumn" style="text-align:right;" >
                                <%= com.egen.util.text.FormatNumber.format((total_pares * p.getProcesso_fab_custo(pro_numero+"",fil_filial)), "##,##0.00") %>
                                <%
                                valorTotalNota += (total_pares * p.getProcesso_fab_custo(pro_numero+"",fil_filial));
                                %>
                                <%
                                total_pares = 0;
                                %>
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>




                      <%
                      if (res_Jw_pse0053_total_preco_aberto!=null && res_Jw_pse0053_total_preco_aberto.size()>0) {
                        %>
                        <tr>
                          <td>

                            <table id="TRbl_report_Jw_pse0053_total_preco"  class="reportTable"   style="width:95%;" border=1;  >
                              <%
                              java.lang.Integer linha = null;
                              java.lang.Integer referencia = null;
                              java.lang.Integer cabedal = null;
                              int pares =  0;
                              double preco =  0;
                              double total =  0;
                              %>

                              <tr class="reportHeader2">
                                <td class="columnTdHeader" style="text-align: left;" >
                                  <font color="black">
                                    Linha
                                  </font>
                                </td>
                                <td class="columnTdHeader" style="text-align: left;" >
                                  <font color="black">
                                    Ref.
                                  </font>
                                </td>
                                <td class="columnTdHeader" style="text-align: left;" >
                                  <font color="black">
                                    Cab.
                                  </font>
                                </td>
                                <td class="columnTdHeader" style="text-align: right;" >
                                  <font color="black">
                                    Pares
                                  </font>
                                </td>

                                <td class="columnTdHeader" style="text-align: right;" >
                                  <font color="black">
                                    Preço MO.
                                  </font>
                                </td>

                                <td class="columnTdHeader" style="text-align: right;" >
                                  <font color="black">
                                    Total
                                  </font>
                                </td>

                              </tr>

                              <%
                              int i_bl_report_Jw_pse0053_total_preco_aberto = 0;
                              while (i_bl_report_Jw_pse0053_total_preco_aberto < res_Jw_pse0053_total_preco_aberto.size()) {
                                portalbr.dbobj.view.Jw_pse0053_total_preco_aberto t_jw_pse0053_total_preco_aberto = (portalbr.dbobj.view.Jw_pse0053_total_preco_aberto)res_Jw_pse0053_total_preco_aberto.elementAt(i_bl_report_Jw_pse0053_total_preco_aberto);
                                linha = t_jw_pse0053_total_preco_aberto.getLin_cdgo();
                                referencia = t_jw_pse0053_total_preco_aberto.getRef_cdgo();
                                cabedal = t_jw_pse0053_total_preco_aberto.getCab_cdgo();
                                pares = t_jw_pse0053_total_preco_aberto.getPares();
                                preco = t_jw_pse0053_total_preco_aberto.getPreco();
                                total = preco * pares;

                                String style_bl_report_Jw_pse0053_total_preco_aberto="";
                                if (!((i_bl_report_Jw_pse0053_total_preco_aberto%2)!=0)) {
                                  style_bl_report_Jw_pse0053_total_preco_aberto="rowColor";
                                } else {
                                  style_bl_report_Jw_pse0053_total_preco_aberto="rowBlank";
                                }
                                %>

                                <tr class='<%= style_bl_report_Jw_pse0053_total_preco_aberto %>' id="TRbl_report_Jw_pse0053_total_preco_aberto<%=i_bl_report_Jw_pse0053_total_preco_aberto%>" >
                                  <td class="reportColumn" style="text-align: left;" >
                                    <%= linha %>
                                  </td>
                                  <td class="reportColumn" style="text-align: left;" >
                                    <%= referencia %>
                                  </td>
                                  <td class="reportColumn" style="text-align: left;" >
                                    <%= cabedal!=null?cabedal:"" %>
                                  </td>
                                  <td class="reportColumn" style="text-align:right;" >
                                    <%= com.egen.util.text.FormatNumber.format(pares, "##,##0") %>
                                  </td>

                                  <td class="reportColumn" style="text-align:right;" >
                                    <%= com.egen.util.text.FormatNumber.format(preco, "##,##0.00") %>
                                  </td>

                                  <td class="reportColumn" style="text-align:right;" >
                                    <%= com.egen.util.text.FormatNumber.format(total, "##,##0.00") %>
                                  </td>

                                </tr>

                                <%
                                i_bl_report_Jw_pse0053_total_preco_aberto++;
                                if (i_bl_report_Jw_pse0053_total_preco_aberto<res_Jw_pse0053_total_preco_aberto.size()) {
                                  t_jw_pse0053_total_preco_aberto = (portalbr.dbobj.view.Jw_pse0053_total_preco_aberto)res_Jw_pse0053_total_preco_aberto.elementAt(i_bl_report_Jw_pse0053_total_preco_aberto);
                                  linha = t_jw_pse0053_total_preco_aberto.getLin_cdgo();
                                  referencia = t_jw_pse0053_total_preco_aberto.getRef_cdgo();
                                  cabedal = t_jw_pse0053_total_preco_aberto.getCab_cdgo();
                                  pares = t_jw_pse0053_total_preco_aberto.getPares();
                                  preco = t_jw_pse0053_total_preco_aberto.getPreco();
                                  total = preco * pares;
                                } else {
                                }
                              }
                              %>

                            </table>

                          </td>
                        </tr>



                        <%
                      }
                      %>






                      <%
                      if (res_Jw_pse0053_notas_fiscais!=null && res_Jw_pse0053_notas_fiscais.size()>0) {
                        %>
                        <tr>
                          <td>

                            <table id="TRbl_report_Jw_pse0053_notas_fiscais"  class="reportTable"   style="width:95%;" border=1;  >
                              <%
                              java.lang.String nfs_fil_filial = null;
                              java.lang.String nfs_serie= null;
                              java.lang.Integer nfs_nmro= null;
                              %>

                              <tr class="reportHeader2">
                                <td class="columnTdHeader" style="text-align: center;" >
                                  <font color="black">
                                    Filial
                                  </font>
                                </td>
                                <td class="columnTdHeader" style="text-align: center;" >
                                  <font color="black">
                                    Número
                                  </font>
                                </td>
                                <td class="columnTdHeader" style="text-align: center;" >
                                  <font color="black">
                                    Série
                                  </font>
                                </td>

                              </tr>

                              <%
                              int i_bl_report_Jw_pse0053_notas_fiscais = 0;
                              while (i_bl_report_Jw_pse0053_notas_fiscais < res_Jw_pse0053_notas_fiscais.size()) {
                                portalbr.dbobj.view.Jw_pse0053_notas_fiscais t_jw_pse0053_notas_fiscais = (portalbr.dbobj.view.Jw_pse0053_notas_fiscais)res_Jw_pse0053_notas_fiscais.elementAt(i_bl_report_Jw_pse0053_notas_fiscais);
                                nfs_fil_filial = t_jw_pse0053_notas_fiscais.getFil_filial();
                                nfs_nmro = t_jw_pse0053_notas_fiscais.getNfs_nmro();
                                nfs_serie = t_jw_pse0053_notas_fiscais.getNfs_serie();

                                String style_bl_report_Jw_pse0053_notas_fiscais="";
                                if (!((i_bl_report_Jw_pse0053_notas_fiscais%2)!=0)) {
                                  style_bl_report_Jw_pse0053_notas_fiscais="rowColor";
                                } else {
                                  style_bl_report_Jw_pse0053_notas_fiscais="rowBlank";
                                }
                                %>

                                <tr class='<%= style_bl_report_Jw_pse0053_notas_fiscais %>' id="TRbl_report_Jw_pse0053_notas_fiscais<%=i_bl_report_Jw_pse0053_notas_fiscais%>" >
                                  <td class="reportColumn" style="text-align: center;" >
                                    <%= nfs_fil_filial %>
                                  </td>
                                  <td class="reportColumn" style="text-align: center;" >
                                    <%= nfs_nmro %>
                                  </td>
                                  <td class="reportColumn" style="text-align: center;" >
                                    <%= nfs_serie %>
                                  </td>

                                </tr>

                                <%
                                i_bl_report_Jw_pse0053_notas_fiscais++;
                                if (i_bl_report_Jw_pse0053_notas_fiscais<res_Jw_pse0053_notas_fiscais.size()) {
                                  t_jw_pse0053_notas_fiscais = (portalbr.dbobj.view.Jw_pse0053_notas_fiscais)res_Jw_pse0053_notas_fiscais.elementAt(i_bl_report_Jw_pse0053_notas_fiscais);
                                  nfs_fil_filial = t_jw_pse0053_notas_fiscais.getFil_filial();
                                  nfs_nmro = t_jw_pse0053_notas_fiscais.getNfs_nmro();
                                  nfs_serie = t_jw_pse0053_notas_fiscais.getNfs_serie();
                                } else {
                                }
                              }
                              %>

                            </table>

                          </td>
                        </tr>



                        <%
                      }
                      %>







                      <tr>
                        <td>
                          <big>
                            <b>
                              Total Nota :
                              <%= com.egen.util.text.FormatNumber.format(valorTotalNota, "##,##0.00") %>
                            </b>
                          </big>
                        </td>
                      </tr>
                    </table>


                  </td>

                </tr>


                <%
                i_bl_report_Jw_pse0053_forn++;
                if (i_bl_report_Jw_pse0053_forn<res_Jw_pse0053_forn.size()) {
                  t_jw_pse0053_forn = (portalbr.dbobj.view.Jw_pse0053_forn)res_Jw_pse0053_forn.elementAt(i_bl_report_Jw_pse0053_forn);
                  fil_filial = t_jw_pse0053_forn.getFil_filial()==null?"":t_jw_pse0053_forn.getFil_filial();
                  for_codigo = t_jw_pse0053_forn.getFor_codigo();
                  pro_numero = t_jw_pse0053_forn.getPro_numero();
                } else {
                }
              }
              %>

            </table>


            <%
          }
          %>

        </form>
        <%
        %>
        <html:form action="ind/Pse0053_rForm.do" method="post" styleClass="baseForm">
          <table class="messageTable" style='width:99%;'>
            <tr class="messageTr" >
              <td class="messageTd">
              </td>
            </tr>
          </table>

          <table class="buttonTable" style='width:99%;'>
            <tr class="buttonTr">
              <td class="buttonTd">
                <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                  <bean:message bundle="ApplicationResources" key="jsp.back"/>
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

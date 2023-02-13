<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <%
            {
              %>

              <%
              java.util.Vector res_Jw_dom_obri_abatimentos = (java.util.Vector)session.getAttribute("res_Jw_dom_obri_abatimentos");
              %>

              <form  name="bl_report_Jw_dom_obri_abatimentos" id="bl_report_Jw_dom_obri_abatimentos" class="baseForm" method="post" >
                <%
                if (res_Jw_dom_obri_abatimentos!=null && res_Jw_dom_obri_abatimentos.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_dom_obri_abatimentos"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.String nm_obri =  null;
                    java.lang.String cd_enti =  null;
                    java.lang.String codi_tipo_ender =  null;
                    java.lang.String cd_tipo =  null;
                    java.lang.String cd_tran =  null;
                    java.lang.String nm_descri =  null;
                    java.sql.Timestamp dt_moob =  null;
                    double vl_pago =  0;
                    java.lang.String te_observ =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Transação
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Data Abatimento
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Valor
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Obervação
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_dom_obri_abatimentos = 0;
                    while (i_bl_report_Jw_dom_obri_abatimentos<res_Jw_dom_obri_abatimentos.size()) {
                      portalbr.dbobj.view.Jw_dom_obri_abatimentos t_jw_dom_obri_abatimentos = (portalbr.dbobj.view.Jw_dom_obri_abatimentos)res_Jw_dom_obri_abatimentos.elementAt(i_bl_report_Jw_dom_obri_abatimentos);
                      nm_obri = t_jw_dom_obri_abatimentos.getNm_obri()==null?"":t_jw_dom_obri_abatimentos.getNm_obri();
                      cd_enti = t_jw_dom_obri_abatimentos.getCd_enti()==null?"":t_jw_dom_obri_abatimentos.getCd_enti();
                      codi_tipo_ender = t_jw_dom_obri_abatimentos.getCodi_tipo_ender()==null?"":t_jw_dom_obri_abatimentos.getCodi_tipo_ender();
                      cd_tipo = t_jw_dom_obri_abatimentos.getCd_tipo()==null?"":t_jw_dom_obri_abatimentos.getCd_tipo();
                      cd_tran = t_jw_dom_obri_abatimentos.getCd_tran()==null?"":t_jw_dom_obri_abatimentos.getCd_tran();
                      nm_descri = t_jw_dom_obri_abatimentos.getNm_descri()==null?"":t_jw_dom_obri_abatimentos.getNm_descri();
                      dt_moob = (java.sql.Timestamp)t_jw_dom_obri_abatimentos.getDt_moob();
                      vl_pago = t_jw_dom_obri_abatimentos.getVl_pago();
                      te_observ = t_jw_dom_obri_abatimentos.getTe_observ()==null?"":t_jw_dom_obri_abatimentos.getTe_observ();
                      String style_bl_report_Jw_dom_obri_abatimentos="";
                      if (!((i_bl_report_Jw_dom_obri_abatimentos%2)!=0)) {
                        style_bl_report_Jw_dom_obri_abatimentos="rowColor";
                      } else {
                        style_bl_report_Jw_dom_obri_abatimentos="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_dom_obri_abatimentos %>' id="TRbl_report_Jw_dom_obri_abatimentos<%=i_bl_report_Jw_dom_obri_abatimentos%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= cd_tran %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= nm_descri %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(dt_moob, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(vl_pago, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= te_observ %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_dom_obri_abatimentos++;
                      if (i_bl_report_Jw_dom_obri_abatimentos<res_Jw_dom_obri_abatimentos.size()) {
                        t_jw_dom_obri_abatimentos = (portalbr.dbobj.view.Jw_dom_obri_abatimentos)res_Jw_dom_obri_abatimentos.elementAt(i_bl_report_Jw_dom_obri_abatimentos);
                        nm_obri = t_jw_dom_obri_abatimentos.getNm_obri()==null?"":t_jw_dom_obri_abatimentos.getNm_obri();
                        cd_enti = t_jw_dom_obri_abatimentos.getCd_enti()==null?"":t_jw_dom_obri_abatimentos.getCd_enti();
                        codi_tipo_ender = t_jw_dom_obri_abatimentos.getCodi_tipo_ender()==null?"":t_jw_dom_obri_abatimentos.getCodi_tipo_ender();
                        cd_tipo = t_jw_dom_obri_abatimentos.getCd_tipo()==null?"":t_jw_dom_obri_abatimentos.getCd_tipo();
                        cd_tran = t_jw_dom_obri_abatimentos.getCd_tran()==null?"":t_jw_dom_obri_abatimentos.getCd_tran();
                        nm_descri = t_jw_dom_obri_abatimentos.getNm_descri()==null?"":t_jw_dom_obri_abatimentos.getNm_descri();
                        dt_moob = (java.sql.Timestamp)t_jw_dom_obri_abatimentos.getDt_moob();
                        vl_pago = t_jw_dom_obri_abatimentos.getVl_pago();
                        te_observ = t_jw_dom_obri_abatimentos.getTe_observ()==null?"":t_jw_dom_obri_abatimentos.getTe_observ();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>
                <br/>
                <table style="width:50%;" border="1">
                  <!--
                    <tr class="reportHeader3"> <td colspan="2" style="text-align: center"> Legenda </td> </tr>
                  -->
                  <tr class="reportHeader">
                    <td style="text-align: center">
                      Transação
                    </td>
                    <td style="text-align: left">
                      Descrição
                    </td>
                  </tr>
                  <tr>
                    <td style="text-align: center">
                      LDI
                    </td>
                    <td style="text-align: left">
                      Abatimentos diversos (Tarifa bancária e outros)
                    </td>
                  </tr>
                  <tr>
                    <td style="text-align: center">
                      LDS
                    </td>
                    <td style="text-align: left">
                      Abatimentos diversos (Tarifa bancária e outros)
                    </td>
                  </tr>
                  <tr>
                    <td style="text-align: center">
                      LBA
                    </td>
                    <td style="text-align: left">
                      Baixa valor principal parcela empréstimo
                    </td>
                  </tr>
                  <tr>
                    <td style="text-align: center">
                      IOF
                    </td>
                    <td style="text-align: left">
                      Baixa valor IOF parcela empréstimo
                    </td>
                  </tr>
                  <tr>
                    <td style="text-align: center">
                      LJE
                    </td>
                    <td style="text-align: left">
                      Baixa valor juros parcela empréstimo
                    </td>
                  </tr>
                  <tr>
                    <td style="text-align: center">
                      LEC
                    </td>
                    <td style="text-align: left">
                      Abatimento referente a vendas (Máquinas, feirão e outros)
                    </td>
                  </tr>
                  <tr>
                    <td style="text-align: center">
                      LDE
                    </td>
                    <td style="text-align: left">
                      Abatimento referente a Nf. de devolução
                    </td>
                  </tr>
                </table>

              </form>
              <%
            }
            %>

            <html:form action="adm/ConsultaPagamentoFornecedores_aForm.do" method="post" styleClass="baseForm">

              <table style="width:99%;">
                <html:hidden property="nm_obri"/>
                <html:hidden property="cd_enti"/>
                <html:hidden property="codi_tipo_ender"/>
                <html:hidden property="cd_tipo"/>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
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

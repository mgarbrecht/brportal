<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page  extends='acesso.web.HttpJspSessao' %>
<html>
  <head>

    <title>
      Detalhes
    </title>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:99%;'>
        <tr>
          <td>
            <table   class="headerTable" style="width:99%" >
              <tr>
                <td class='td10'>
                </td>
              </tr>
            </table>
            <html:form action="adm/AnaliseCredito_deForm.do" method="POST" styleClass="baseForm">
              <title>
                Detalhes
              </title>
              <table class="itemTable" style='width:99%;'>
              </table>
              <table class="separatorTable" >
                <tr class="separatorTr">
                  <td colspan="5" class="separatorTd" align="center">
                    <b>
                      <big>
                        Pagamentos
                      </big>
                    </b>
                  </td>
                </tr>
                <html:hidden property="p_clientes"/>
                <html:hidden property="p_cli_cdgo"/>
                <html:hidden property="p_grupo_economico"/>
                <html:hidden property="p_emp"/>
                <html:hidden property="p_dias1"/>
                <html:hidden property="p_dias2"/>
                <tr>
                  <td  align="center">
                  </td>
                  <td  align="center">
                    <b>
                      Três Meses antes de
                    </b>
                  </td>
                  <td  align="center">
                    <html:text property="p_mes_1" style="Font-Weight: bold; text-align:center; background-color:transparent; border-style:none;  background-color:transparent; border-style:none;  " tabindex="-1" readonly="true" size="10" maxlength="10"/>
                  </td>
                  <td  align="center">
                    <html:text property="p_mes_2" style="Font-Weight: bold; text-align:center; background-color:transparent; border-style:none;  background-color:transparent; border-style:none;  "  tabindex="-1" readonly="true" size="10" maxlength="10"/>
                  </td>
                  <td  align="center">
                    <html:text property="p_mes_3" style="Font-Weight: bold; text-align:center; background-color:transparent; border-style:none;  background-color:transparent; border-style:none;  "  tabindex="-1" readonly="true" size="10" maxlength="10"/>
                  </td>
                </tr>



                <tr>
                  <td align="right">
                    <b>
                      Pontuais
                    </b>
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_em_dia_3ma" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_em_dia_3ma" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_em_dia_1mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_em_dia_1mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_em_dia_2mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_em_dia_2mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_em_dia_3mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_em_dia_3mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                </tr>



                <tr>
                  <td align="right">
                    <b>
                      Até
                      <html:text property="p_dias1" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      Dias
                    </b>
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_atr_me30d_3ma" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_atr_me30d_3ma" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_ate_1mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_ate_1mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_ate_2mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_ate_2mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_ate_3mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_ate_3mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                </tr>



                <tr>
                  <td align="right">
                    <b>
                      Acima
                      <html:text property="p_dias1" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      Dias
                    </b>
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_atr_ma30d_3ma" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_atr_ma30d_3ma" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_acima_1mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_acima_1mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_acima_2mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_acima_2mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_acima_3mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_acima_3mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                </tr>



                <tr>
                  <td align="right">
                    <b>
                      Totais Pagamentos
                    </b>
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_tot_3ma" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_tot_3ma" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_tot_1mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_tot_1mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_tot_2mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_tot_2mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_tot_3mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_tot_3mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                </tr>



                <tr>
                  <td align="right">
                    <b>
                      Venc. em Aberto
                    </b>
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_vct_ab_3ma" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_vct_ab_3ma" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_vct_ab_1mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_vct_ab_1mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_vct_ab_2mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_vct_ab_2mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_vct_ab_3mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_vct_ab_3mes" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                </tr>

                <tr>
                  <td colspan=5>
                    <br>
                  </td>
                </tr>


                <tr>
                  <td class="formField">
                  </td>
                  <td class="formField">
                    <b>
                      Vencidos
                    </b>
                  </td>
                  <td class="formField">
                    <b>
                      A Vencer
                    </b>
                  </td>
                  <td class="formField">
                    <b>
                      Pagamentos
                    </b>
                  </td>
                  <td class="formField">
                  </td>
                </tr>



                <tr>
                  <td align="right">
                    <b>
                      No Mês Corrente
                    </b>
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_venc_mes_corrente" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_venc_mes_corrente" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_avenc_mes_corrente" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_avenc_mes_corrente" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_vlr_pag_mes_corrente" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                    <html:text property="p_pag_mes_corrente" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                  </td>
                </tr>


                <tr>
                  <td colspan=5>
                    <br>
                  </td>
                </tr>



                <tr>
                  <td align="right">
                    <b>
                      A Vencer
                    </b>
                  </td>
                  <td class="formField">
                    <html:text property="p_mes1" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="3"/>
                    <html:text property="p_vlr_avenc_m1" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="14" maxlength="14"/>
                    <html:text property="p_avenc_m1" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_mes2" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="3"/>
                    <html:text property="p_vlr_avenc_m2" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="14" maxlength="14"/>
                    <html:text property="p_avenc_m2" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_mes3" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="3"/>
                    <html:text property="p_vlr_avenc_m3" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="14" maxlength="14"/>
                    <html:text property="p_avenc_m3" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_mes4" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="3"/>
                    <html:text property="p_vlr_avenc_m4" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="14" maxlength="14"/>
                    <html:text property="p_avenc_m4" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                </tr>




                <tr>
                  <td align="right">
                    <b>
                      A Vencer
                    </b>
                  </td>
                  <td class="formField">
                    <html:text property="p_mes5" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="3"/>
                    <html:text property="p_vlr_avenc_m5" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="14" maxlength="14"/>
                    <html:text property="p_avenc_m5" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_mes6" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="3"/>
                    <html:text property="p_vlr_avenc_m6" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="14" maxlength="14"/>
                    <html:text property="p_avenc_m6" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_mes7" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="3"/>
                    <html:text property="p_vlr_avenc_m7" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="14" maxlength="14"/>
                    <html:text property="p_avenc_m7" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                  <td class="formField">
                    <html:text property="p_mes8" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="3"/>
                    <html:text property="p_vlr_avenc_m8" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="14" maxlength="14"/>
                    <html:text property="p_avenc_m8" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                    %
                  </td>
                </tr>


              </table>
              <table class="itemTable" style='width:100%;'>
              </table>
              <table class="buttonTable" style='width:99%;'>
                <tr>
                  <td class="buttonItem">
                    <html:submit accesskey="e" styleClass="myhidden" property="execute_action">
                      <bean:message bundle="ApplicationResources" key="jsp.execute"/>
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

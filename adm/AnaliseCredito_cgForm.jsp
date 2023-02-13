<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Consulta Gerencial
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
                </td>

              </tr>

            </table>

            <html:form action="adm/AnaliseCredito_cgForm.do" method="post" styleClass="baseForm">
              <table class="separatorTable" >
                <tr class="separatorTr">
                  <td colspan="5" class="separatorTd" align="center">
                    <b>
                      <big>
                        Consulta Gerencial
                      </big>
                    </b>
                  </td>
                </tr>
              </table>

              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="data_inicial"/>
                    <html:errors property="data_final"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_analise_credito_gerencial"/>
                  </td>
                </tr>
              </table>

              <html:hidden property="p_cli_cdgo" />
              <html:hidden property="p_clientes" />
              <html:hidden property="p_grupo_economico" />
              <html:hidden property="p_emp" />


              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Inicial
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="data_inicial" styleId="data_inicial" styleClass="baseField" size="11" maxlength="10"/>
                     
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_inicial']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Final
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="data_final" styleId="data_final" styleClass="baseField" size="11" maxlength="10"/>
                     
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="baseButton" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                    <html:submit value="inicializa" styleClass="myhidden" property="inicializa_action">
                    </html:submit>
                  </td>
                </tr>
              </table>

              <script type="text/javascript">
                jQuery(document).ready(function($) {
                  $("#data_inicial").mask("99/99/9999");
                  $("#data_final").mask("99/99/9999");
                  });
                </script>
              </html:form>
              <script type="text/javascript">
                var focusControl = document.forms[0].elements["data_inicial"];
                if (focusControl.type != "hidden"){
                  focusControl.focus();
                }
              </script>

              <%
              {
                %>

                <%
                java.util.Vector res_Jw_analise_credito_gerencial = (java.util.Vector)session.getAttribute("res_Jw_analise_credito_gerencial");
                %>

                <form  name="bl_report_Jw_analise_credito_gerencial" id="bl_report_Jw_analise_credito_gerencial" class="baseForm" method="post" >
                  <%
                  if (res_Jw_analise_credito_gerencial!=null && res_Jw_analise_credito_gerencial.size()>0) {
                    %>

                    <table id="TRbl_report_Jw_analise_credito_gerencial"  class="reportTable"   style="width:99%; "  border="1" >
                      <%
                      java.lang.String mes_ano = null;
                      java.lang.String pag_mercado = null;
                      java.lang.Double vlr_faturado = null;
                      java.lang.Double vlr_liquidado = null;
                      java.lang.Double vlr_pror_a = null;
                      java.lang.Double vlr_pror_l = null;
                      double sum_vlr_faturado_0 = 0;
                      double sum_vlr_liquidado_0 = 0;
                      double sum_vlr_pror_a_0 = 0;
                      double sum_vlr_pror_l_0 = 0;
                      %>


                      <tr class="reportTr" style="border: none !important">
                        <td colspan="4" style="border: none !important; " >

                        </td>

                        <td class="columnTdHeader" style="text-align:center;" colspan="2" >
                          Prorrogados
                        </td>

                      </tr>


                      <tr class="reportTr">
                        <td class="columnTdHeader" style="text-align:center;" >
                          Meses
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Faturado
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Liquidado
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Pag. Mercado
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Abertos
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Liquidados
                        </td>

                      </tr>

                      <%
                      int i_bl_report_Jw_analise_credito_gerencial = 0;
                      while (i_bl_report_Jw_analise_credito_gerencial<res_Jw_analise_credito_gerencial.size()) {
                        portalbr.dbobj.view.Jw_analise_credito_gerencial t_jw_analise_credito_gerencial = (portalbr.dbobj.view.Jw_analise_credito_gerencial)res_Jw_analise_credito_gerencial.elementAt(i_bl_report_Jw_analise_credito_gerencial);
                        mes_ano = t_jw_analise_credito_gerencial.getMes_ano()==null?"":t_jw_analise_credito_gerencial.getMes_ano();
                        pag_mercado = t_jw_analise_credito_gerencial.getPag_mercado()==null?"":t_jw_analise_credito_gerencial.getPag_mercado();
                        vlr_faturado = t_jw_analise_credito_gerencial.getVlr_faturado();
                        vlr_liquidado = t_jw_analise_credito_gerencial.getVlr_liquidado();
                        vlr_pror_a = t_jw_analise_credito_gerencial.getVlr_pror_a();
                        vlr_pror_l = t_jw_analise_credito_gerencial.getVlr_pror_l();
                        sum_vlr_faturado_0 += ((vlr_faturado!=null)?vlr_faturado.doubleValue():0);
                        sum_vlr_liquidado_0 += ((vlr_liquidado!=null)?vlr_liquidado.doubleValue():0);
                        sum_vlr_pror_a_0 += ((vlr_pror_a!=null)?vlr_pror_a.doubleValue():0);
                        sum_vlr_pror_l_0 += ((vlr_pror_l!=null)?vlr_pror_l.doubleValue():0);
                        String style_bl_report_Jw_analise_credito_gerencial="";
                        if (!((i_bl_report_Jw_analise_credito_gerencial%2)!=0)) {
                          style_bl_report_Jw_analise_credito_gerencial="rowColor";
                        } else {
                          style_bl_report_Jw_analise_credito_gerencial="rowBlank";
                        }
                        %>


                        <tr class='<%= style_bl_report_Jw_analise_credito_gerencial %>' id="TRbl_report_Jw_analise_credito_gerencial<%=i_bl_report_Jw_analise_credito_gerencial%>" >
                          <td class="reportColumn" style="text-align:center;" >
                            <%= mes_ano %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(vlr_faturado, "##,##0.00") %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(vlr_liquidado, "##,##0.00") %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= pag_mercado %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(vlr_pror_a, "##,##0.00") %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(vlr_pror_l, "##,##0.00") %>
                          </td>

                        </tr>

                        <%
                        i_bl_report_Jw_analise_credito_gerencial++;
                        if (i_bl_report_Jw_analise_credito_gerencial<res_Jw_analise_credito_gerencial.size()) {
                          t_jw_analise_credito_gerencial = (portalbr.dbobj.view.Jw_analise_credito_gerencial)res_Jw_analise_credito_gerencial.elementAt(i_bl_report_Jw_analise_credito_gerencial);
                          mes_ano = t_jw_analise_credito_gerencial.getMes_ano()==null?"":t_jw_analise_credito_gerencial.getMes_ano();
                          pag_mercado = t_jw_analise_credito_gerencial.getPag_mercado()==null?"":t_jw_analise_credito_gerencial.getPag_mercado();
                          vlr_faturado = t_jw_analise_credito_gerencial.getVlr_faturado();
                          vlr_liquidado = t_jw_analise_credito_gerencial.getVlr_liquidado();
                          vlr_pror_a = t_jw_analise_credito_gerencial.getVlr_pror_a();
                          vlr_pror_l = t_jw_analise_credito_gerencial.getVlr_pror_l();
                        } else {
                        }
                      }
                      %>

                      <tr class="totalColumn">
                        <td>
                           
                        </td>
                        <td class="totalTdColumn"  style="text-align:right; font-weight: bold" >
                          <%= com.egen.util.text.FormatNumber.format(sum_vlr_faturado_0 , "##,##0.00") %>
                        </td>
                        <td class="totalTdColumn"  style="text-align:right; font-weight: bold" >
                          <%= com.egen.util.text.FormatNumber.format(sum_vlr_liquidado_0 , "##,##0.00") %>
                        </td>
                        <td class="totalTdColumn"  style="text-align:right; font-weight: bold" >
                        </td>
                        <td class="totalTdColumn"  style="text-align:right; font-weight: bold" >
                          <%= com.egen.util.text.FormatNumber.format(sum_vlr_pror_a_0 , "##,##0.00") %>
                        </td>
                        <td class="totalTdColumn"  style="text-align:right; font-weight: bold" >
                          <%= com.egen.util.text.FormatNumber.format(sum_vlr_pror_l_0 , "##,##0.00") %>
                        </td>
                      </tr>

                      <%
                      %>

                    </table>

                    <%
                  }
                  %>

                </form>
                <%
              }
              %>

            </td>
          </tr>
        </table>

      </body>
    </center>
  </html>

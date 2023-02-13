<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Pendências de Clientes
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
                </td>

              </tr>

            </table>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_pendencias_regionais = (java.util.Vector)session.getAttribute("res_Jw_pendencias_regionais");
              %>

              <form  name="bl_report_Jw_pendencias_regionais" id="bl_report_Jw_pendencias_regionais" class="baseForm" method="post" >
                <%
                if (res_Jw_pendencias_regionais!=null && res_Jw_pendencias_regionais.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_pendencias_regionais"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    int codigo_regional =  0;
                    java.lang.String nome_regional =  null;
                    java.lang.String rep_cdgo =  null;
                    java.lang.String rep_nome =  null;
                    java.lang.String rep_situ =  null;
                    double vencido =  0;
                    double vencer =  0;
                    double percentual =  0;
                    String _b0_control = "__";
                    double sum_vencido_1 = 0;
                    double sum_vencer_1 = 0;
                    double sum_vencido = 0;
                    double sum_vencer = 0;
                    int i_bl_report_Jw_pendencias_regionais = 0;
                    while (i_bl_report_Jw_pendencias_regionais<res_Jw_pendencias_regionais.size()) {
                      portalbr.dbobj.view.Jw_pendencias_regionais t_jw_pendencias_regionais = (portalbr.dbobj.view.Jw_pendencias_regionais)res_Jw_pendencias_regionais.elementAt(i_bl_report_Jw_pendencias_regionais);
                      codigo_regional = t_jw_pendencias_regionais.getCodigo_regional();
                      nome_regional = t_jw_pendencias_regionais.getNome_regional()==null?"":t_jw_pendencias_regionais.getNome_regional();
                      rep_cdgo = t_jw_pendencias_regionais.getRep_cdgo()==null?"":t_jw_pendencias_regionais.getRep_cdgo();
                      rep_nome = t_jw_pendencias_regionais.getRep_nome()==null?"":t_jw_pendencias_regionais.getRep_nome();
                      rep_situ = t_jw_pendencias_regionais.getRep_situ()==null?"":t_jw_pendencias_regionais.getRep_situ();
                      vencido = t_jw_pendencias_regionais.getVencido();
                      vencer = t_jw_pendencias_regionais.getVencer();
                      percentual = t_jw_pendencias_regionais.getPercentual();
                      sum_vencido_1 += vencido;
                      sum_vencer_1 += vencer;
                      sum_vencido += vencido;
                      sum_vencer += vencer;
                      String _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional);
                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                        %>
                        <tr class="reportHeader2">
                          <td colspan="5">
                            <span class="reportColumn" style="text-align:right;" >
                              Regional
                            </span>
                            <span class="reportColumn" style="text-align:right;" >
                              <%= codigo_regional %>
                            </span>
                            <span class="reportColumn" style="text-align:left;" >
                              -
                            </span>
                            <span class="reportColumn" style="text-align:left;" >
                              <%= nome_regional %>
                            </span>
                            <span class="columnTdHeader" style="text-align:left;" >
                            </span>
                            <span class="reportColumn" style="text-align:left;" >

                            </span>
                          </td>
                        </tr>
                        <%
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:right;" >
                            Cód.
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Representante
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Vencido
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            A Vencer
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            % Pendência
                          </td>

                        </tr>

                        <%
                      }
                      String style_bl_report_Jw_pendencias_regionais="";
                      if (!((i_bl_report_Jw_pendencias_regionais%2)!=0)) {
                        style_bl_report_Jw_pendencias_regionais="rowColor";
                      } else {
                        style_bl_report_Jw_pendencias_regionais="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_pendencias_regionais %>' id="TRbl_report_Jw_pendencias_regionais<%=i_bl_report_Jw_pendencias_regionais%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= rep_cdgo %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= rep_nome %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(vencido, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(vencer, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(percentual, "##,##0.00") %>
                        </td>

                      </tr>

                      <%
                      _b0_control = _b0_value;
                      i_bl_report_Jw_pendencias_regionais++;
                      if (i_bl_report_Jw_pendencias_regionais<res_Jw_pendencias_regionais.size()) {
                        t_jw_pendencias_regionais = (portalbr.dbobj.view.Jw_pendencias_regionais)res_Jw_pendencias_regionais.elementAt(i_bl_report_Jw_pendencias_regionais);
                        codigo_regional = t_jw_pendencias_regionais.getCodigo_regional();
                        nome_regional = t_jw_pendencias_regionais.getNome_regional()==null?"":t_jw_pendencias_regionais.getNome_regional();
                        rep_cdgo = t_jw_pendencias_regionais.getRep_cdgo()==null?"":t_jw_pendencias_regionais.getRep_cdgo();
                        rep_nome = t_jw_pendencias_regionais.getRep_nome()==null?"":t_jw_pendencias_regionais.getRep_nome();
                        rep_situ = t_jw_pendencias_regionais.getRep_situ()==null?"":t_jw_pendencias_regionais.getRep_situ();
                        vencido = t_jw_pendencias_regionais.getVencido();
                        vencer = t_jw_pendencias_regionais.getVencer();
                        percentual = t_jw_pendencias_regionais.getPercentual();
                        _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional);
                      } else {
                        _b0_control = "__";
                      }
                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                        %>

                        <tr class="totalColumn">
                          <td class="totalTdColumn"  style="text-align:right;" colspan=2>
                            <b>
                              Total :
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_vencido_1, "##,##0.00") %>
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(sum_vencer_1, "##,##0.00") %>
                            </b>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(((sum_vencido_1 * 100)/(sum_vencido_1 + sum_vencer_1)),"##,##0.00") %>
                            </b>
                          </td>



                        </tr>

                        <%
                        sum_vencido_1 = 0;
                        sum_vencer_1 = 0;
                      }
                    }
                    %>

                    <tr class="totalColumn">
                      <td class="totalTdColumn"  style="text-align:right;" colspan=2>
                        <b>
                          Total Geral :
                        </b>
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(sum_vencido, "##,##0.00") %>
                        </b>
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(sum_vencer, "##,##0.00") %>
                        </b>
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(((sum_vencido * 100)/(sum_vencido + sum_vencer)),"##,##0.00") %>
                        </b>
                      </td>
                    </tr>
                  </table>

                  <%
                }
                %>

              </form>
              <%
            }
            %>


            <html:form action="adm/PendenciasRegionais_rForm.do" method="post" styleClass="baseForm">
              <table class="buttonTable" style='width:;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <%
                    if(!(request.getParameter("excel")+"").equals("true")){
                      %>
                      <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                        <bean:message bundle="ApplicationResources" key="jsp.back"/>
                      </html:submit>
                      <%
                    }
                    %>
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

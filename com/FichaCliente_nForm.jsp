<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:100%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <%
            {
              %>

              <%
              java.util.Vector res_Jw_ficha_cliente_notas = (java.util.Vector)session.getAttribute("res_Jw_ficha_cliente_notas");
              %>

              <form  name="bl_report_Jw_ficha_cliente_notas" id="bl_report_Jw_ficha_cliente_notas" class="baseForm" method="post" >
                <%
                if (res_Jw_ficha_cliente_notas!=null && res_Jw_ficha_cliente_notas.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_ficha_cliente_notas"  class="reportTable"   style="width:100%; "  border="1" >
                    <%
                    java.lang.String empresa =  null;
                    java.lang.Integer nota =  null;
                    java.lang.String titulo =  null;
                    java.sql.Date data_emissao =  null;
                    java.sql.Date data_vencimento =  null;
                    java.lang.Integer dias_vencido =  null;
                    java.lang.Double valor =  null;
                    double sum_valor_0 = 0;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Empresa
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Nota
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Título
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Data Emissão
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Data Vencimento
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Dias Vencido
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Valor
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_ficha_cliente_notas = 0;
                    while (i_bl_report_Jw_ficha_cliente_notas<res_Jw_ficha_cliente_notas.size()) {
                      portalbr.dbobj.view.Jw_ficha_cliente_notas t_jw_ficha_cliente_notas = (portalbr.dbobj.view.Jw_ficha_cliente_notas)res_Jw_ficha_cliente_notas.elementAt(i_bl_report_Jw_ficha_cliente_notas);
                      empresa = t_jw_ficha_cliente_notas.getEmpresa()==null?"":t_jw_ficha_cliente_notas.getEmpresa();
                      nota = t_jw_ficha_cliente_notas.getNota();
                      titulo = t_jw_ficha_cliente_notas.getTitulo()==null?"":t_jw_ficha_cliente_notas.getTitulo();
                      data_emissao = (java.sql.Date)t_jw_ficha_cliente_notas.getData_emissao();
                      data_vencimento = (java.sql.Date)t_jw_ficha_cliente_notas.getData_vencimento();
                      dias_vencido = t_jw_ficha_cliente_notas.getDias_vencido();
                      valor = t_jw_ficha_cliente_notas.getValor();
                      sum_valor_0 += ((valor!=null)?valor.doubleValue():0);
                      String style_bl_report_Jw_ficha_cliente_notas="";
                      if (!((i_bl_report_Jw_ficha_cliente_notas%2)!=0)) {
                        style_bl_report_Jw_ficha_cliente_notas="rowColor";
                      } else {
                        style_bl_report_Jw_ficha_cliente_notas="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_ficha_cliente_notas %>' id="TRbl_report_Jw_ficha_cliente_notas<%=i_bl_report_Jw_ficha_cliente_notas%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= empresa %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((nota!=null)?nota.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= titulo %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_emissao, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_vencimento, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((dias_vencido!=null)?dias_vencido.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(valor, "##,##0.00") %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_ficha_cliente_notas++;
                      if (i_bl_report_Jw_ficha_cliente_notas<res_Jw_ficha_cliente_notas.size()) {
                        t_jw_ficha_cliente_notas = (portalbr.dbobj.view.Jw_ficha_cliente_notas)res_Jw_ficha_cliente_notas.elementAt(i_bl_report_Jw_ficha_cliente_notas);
                        empresa = t_jw_ficha_cliente_notas.getEmpresa()==null?"":t_jw_ficha_cliente_notas.getEmpresa();
                        nota = t_jw_ficha_cliente_notas.getNota();
                        titulo = t_jw_ficha_cliente_notas.getTitulo()==null?"":t_jw_ficha_cliente_notas.getTitulo();
                        data_emissao = (java.sql.Date)t_jw_ficha_cliente_notas.getData_emissao();
                        data_vencimento = (java.sql.Date)t_jw_ficha_cliente_notas.getData_vencimento();
                        dias_vencido = t_jw_ficha_cliente_notas.getDias_vencido();
                        valor = t_jw_ficha_cliente_notas.getValor();
                      } else {
                      }
                    }
                    %>

                    <tr class="totalColumn">
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        Total
                        <%= com.egen.util.text.FormatNumber.format(sum_valor_0, "##,##0.00") %>
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

            <html:form action="com/FichaCliente_nForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:100%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_ficha_cliente_notas"/>
                  </td>
                </tr>
              </table>

              <table class="buttonTable" style='width:100%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
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

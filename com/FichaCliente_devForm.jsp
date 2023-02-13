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
              java.util.Vector res_Jw_ficha_cliente_devolucoes = (java.util.Vector)session.getAttribute("res_Jw_ficha_cliente_devolucoes_dev");
              %>

              <form  name="bl_report_Jw_ficha_cliente_devolucoes" id="bl_report_Jw_ficha_cliente_devolucoes" class="baseForm" method="post" >
                <%
                if (res_Jw_ficha_cliente_devolucoes!=null && res_Jw_ficha_cliente_devolucoes.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_ficha_cliente_devolucoes"  class="reportTable"   style="width:100%; "  border="1" >
                    <%
                    int tamanho = 0;
                    java.lang.Integer ordem =  null;
                    java.sql.Timestamp data_cad =  null;
                    java.lang.Integer nfs_nmro =  null;
                    java.lang.Integer pares =  null;
                    java.lang.Double valor =  null;
                    int sum_pares_0 = 0;
                    double sum_valor_0 = 0;

                    if(res_Jw_ficha_cliente_devolucoes.size()>5){
                      tamanho = res_Jw_ficha_cliente_devolucoes.size();
                      //           tamanho = 5;
                    } else {
                      tamanho = res_Jw_ficha_cliente_devolucoes.size();
                    }
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:center;" >
                        Data
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Nota Fiscal
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Pares
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Valor
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_ficha_cliente_devolucoes = 0;
                    while (i_bl_report_Jw_ficha_cliente_devolucoes<tamanho) {
                      portalbr.dbobj.view.Jw_ficha_cliente_devolucoes t_jw_ficha_cliente_devolucoes = (portalbr.dbobj.view.Jw_ficha_cliente_devolucoes)res_Jw_ficha_cliente_devolucoes.elementAt(i_bl_report_Jw_ficha_cliente_devolucoes);
                      ordem = t_jw_ficha_cliente_devolucoes.getOrdem();
                      data_cad = (java.sql.Timestamp)t_jw_ficha_cliente_devolucoes.getData_cad();
                      nfs_nmro = t_jw_ficha_cliente_devolucoes.getNfs_nmro();
                      pares = t_jw_ficha_cliente_devolucoes.getPares();
                      valor = t_jw_ficha_cliente_devolucoes.getValor();
                      sum_pares_0 += ((pares!=null)?pares.intValue():0);
                      sum_valor_0 += ((valor!=null)?valor.doubleValue():0);
                      String style_bl_report_Jw_ficha_cliente_devolucoes="";
                      if (!((i_bl_report_Jw_ficha_cliente_devolucoes%2)!=0)) {
                        style_bl_report_Jw_ficha_cliente_devolucoes="rowColor";
                      } else {
                        style_bl_report_Jw_ficha_cliente_devolucoes="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_ficha_cliente_devolucoes %>' id="TRbl_report_Jw_ficha_cliente_devolucoes<%=i_bl_report_Jw_ficha_cliente_devolucoes%>" >
                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_cad, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((nfs_nmro!=null)?nfs_nmro.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((pares!=null)?pares.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(valor, "##,##0.00") %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_ficha_cliente_devolucoes++;
                      if (i_bl_report_Jw_ficha_cliente_devolucoes<tamanho) {
                        t_jw_ficha_cliente_devolucoes = (portalbr.dbobj.view.Jw_ficha_cliente_devolucoes)res_Jw_ficha_cliente_devolucoes.elementAt(i_bl_report_Jw_ficha_cliente_devolucoes);
                        ordem = t_jw_ficha_cliente_devolucoes.getOrdem();
                        data_cad = (java.sql.Timestamp)t_jw_ficha_cliente_devolucoes.getData_cad();
                        nfs_nmro = t_jw_ficha_cliente_devolucoes.getNfs_nmro();
                        pares = t_jw_ficha_cliente_devolucoes.getPares();
                        valor = t_jw_ficha_cliente_devolucoes.getValor();
                      } else {
                      }
                    }
                    %>

                    <tr class="totalColumn">
                      <td>
                         
                      </td>
                      <td>
                         
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          Total:
                          <%= com.egen.util.text.FormatNumber.format(sum_pares_0, "##,##0") %>
                        </b>
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          Total:
                          <%= com.egen.util.text.FormatNumber.format(sum_valor_0, "##,##0.00") %>
                        </b>
                      </td>
                    </tr>


                    <!--
                      <tr class="totalColumn"> <td colspan="4" style="text-align:right;"> Mostrando <%= tamanho %> de <%= res_Jw_ficha_cliente_devolucoes.size() %> notas </td> </tr>
                    -->


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
            <html:form action="com/FichaCliente_devForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:100%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="buttonTable" style='width:100%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="p" styleClass="myhidden" property="select1_action">
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

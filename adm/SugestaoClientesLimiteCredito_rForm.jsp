<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Sugestão de Clientes com Limite de Crédito Disponível para Venda
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
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(168)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            com.egen.util.jdbc.JdbcUtil j = null;
            util.consultas.Query query = new util.consultas.Query();
            try {
              j = new com.egen.util.jdbc.JdbcUtil();
              %>

              <%
              java.util.Vector res_Jw_maiores_clientes_limite_credito = (java.util.Vector)session.getAttribute("res_Jw_maiores_clientes_limite_credito");
              %>

              <form  name="bl_report_Jw_maiores_clientes_limite_credito" id="bl_report_Jw_maiores_clientes_limite_credito" class="baseForm" method="post" >
                <%
                if (res_Jw_maiores_clientes_limite_credito!=null && res_Jw_maiores_clientes_limite_credito.size()>0) {
                  if ( ((String)request.getParameter("_ordered"))!=null && ((String)request.getParameter("_ordered")).length()>0 ) {
                    boolean reverse = false;
                    if ( ((String)request.getParameter("_reverse"))!=null && ((String)request.getParameter("_reverse")).equals("true") ){
                      reverse = true;
                    }
                    try {
                      res_Jw_maiores_clientes_limite_credito = com.egen.util.text.Sort.execute(res_Jw_maiores_clientes_limite_credito,((String)request.getParameter("_ordered")),reverse);
                      session.setAttribute("res_Jw_maiores_clientes_limite_credito", res_Jw_maiores_clientes_limite_credito);
                    } catch (Exception e) {}
                  }
                  %>

                  <table id="TRbl_report_Jw_maiores_clientes_limite_credito"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Integer codigo =  null;
                    java.lang.String razao =  null;
                    java.lang.String tipo =  null;
                    double limite =  0;
                    double pedidos_producao =  0;
                    double pedidos_nao_liberados =  0;
                    double saldo =  0;
                    double p_qtd_vencer =  0;
                    double p_vlr_vencer =  0;
                    double p_qtd_vencido =  0;
                    double p_vlr_vencido =  0;
                    double percentual_pontualidade =  0;
                    double total_vencer = 0;
                    double total_vencido = 0;
                    double total_percentual = 0;
                    double total_pedidos_producao = 0;
                    double total_pedidos_nao_liberados = 0;
                    double total_saldo = 0;
                    double total_limite = 0;
                    int contador = 0;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Código
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <%
                          if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                            %>
                            <a href='SugestaoClientesLimiteCredito_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","codigo")%>' class="reportOrder">
                              <bean:message key="report.orderedasc"/>
                            </a>
                            <%
                          } else {
                            %>
                            <a href='SugestaoClientesLimiteCredito_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","codigo")%>' class="reportOrder">
                              <bean:message key="report.ordereddesc"/>
                            </a>
                            <%
                          }
                          %>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" width="30%" >
                        Nome
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <%
                          if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                            %>
                            <a href='SugestaoClientesLimiteCredito_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","razao")%>' class="reportOrder">
                              <bean:message key="report.orderedasc"/>
                            </a>
                            <%
                          } else {
                            %>
                            <a href='SugestaoClientesLimiteCredito_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","razao")%>' class="reportOrder">
                              <bean:message key="report.ordereddesc"/>
                            </a>
                            <%
                          }
                          %>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Tipo
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <%
                          if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                            %>
                            <a href='SugestaoClientesLimiteCredito_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","tipo")%>' class="reportOrder">
                              <bean:message key="report.orderedasc"/>
                            </a>
                            <%
                          } else {
                            %>
                            <a href='SugestaoClientesLimiteCredito_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","tipo")%>' class="reportOrder">
                              <bean:message key="report.ordereddesc"/>
                            </a>
                            <%
                          }
                          %>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Limite
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <%
                          if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                            %>
                            <a href='SugestaoClientesLimiteCredito_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","limite")%>' class="reportOrder">
                              <bean:message key="report.orderedasc"/>
                            </a>
                            <%
                          } else {
                            %>
                            <a href='SugestaoClientesLimiteCredito_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","limite")%>' class="reportOrder">
                              <bean:message key="report.ordereddesc"/>
                            </a>
                            <%
                          }
                          %>
                          <%
                        }
                        %>
                      </td>


                      <td class="columnTdHeader" style="text-align:right;" >
                        Bloqueados no Crédito
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <%
                          if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                            %>
                            <a href='SugestaoClientesLimiteCredito_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","pedidos_nao_liberados")%>' class="reportOrder">
                              <bean:message key="report.orderedasc"/>
                            </a>
                            <%
                          } else {
                            %>
                            <a href='SugestaoClientesLimiteCredito_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","pedidos_nao_liberados")%>' class="reportOrder">
                              <bean:message key="report.ordereddesc"/>
                            </a>
                            <%
                          }
                          %>
                          <%
                        }
                        %>
                      </td>



                      <td class="columnTdHeader" style="text-align:right;" >
                        Pedidos Produção
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <%
                          if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                            %>
                            <a href='SugestaoClientesLimiteCredito_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","pedidos_producao")%>' class="reportOrder">
                              <bean:message key="report.orderedasc"/>
                            </a>
                            <%
                          } else {
                            %>
                            <a href='SugestaoClientesLimiteCredito_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","pedidos_producao")%>' class="reportOrder">
                              <bean:message key="report.ordereddesc"/>
                            </a>
                            <%
                          }
                          %>
                          <%
                        }
                        %>
                      </td>



                      <td class="columnTdHeader" style="text-align:right;" >
                        Duplicatas à vencer
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <%
                          if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                            %>
                            <a href='SugestaoClientesLimiteCredito_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","p_vlr_vencer")%>' class="reportOrder">
                              <bean:message key="report.orderedasc"/>
                            </a>
                            <%
                          } else {
                            %>
                            <a href='SugestaoClientesLimiteCredito_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","p_vlr_vencer")%>' class="reportOrder">
                              <bean:message key="report.ordereddesc"/>
                            </a>
                            <%
                          }
                          %>
                          <%
                        }
                        %>
                      </td>



                      <td class="columnTdHeader" style="text-align:right;" >
                        Duplicatas Vencidas
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <%
                          if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                            %>
                            <a href='SugestaoClientesLimiteCredito_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","p_vlr_vencido")%>' class="reportOrder">
                              <bean:message key="report.orderedasc"/>
                            </a>
                            <%
                          } else {
                            %>
                            <a href='SugestaoClientesLimiteCredito_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","p_vlr_vencido")%>' class="reportOrder">
                              <bean:message key="report.ordereddesc"/>
                            </a>
                            <%
                          }
                          %>
                          <%
                        }
                        %>
                      </td>




                      <td class="columnTdHeader" style="text-align:right;" >
                        Saldo
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <%
                          if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                            %>
                            <a href='SugestaoClientesLimiteCredito_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","saldo")%>' class="reportOrder">
                              <bean:message key="report.orderedasc"/>
                            </a>
                            <%
                          } else {
                            %>
                            <a href='SugestaoClientesLimiteCredito_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","saldo")%>' class="reportOrder">
                              <bean:message key="report.ordereddesc"/>
                            </a>
                            <%
                          }
                          %>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        % Pont.
                      </td>


                    </tr>

                    <%
                    int i_bl_report_Jw_maiores_clientes_limite_credito = 0;
                    while (i_bl_report_Jw_maiores_clientes_limite_credito<res_Jw_maiores_clientes_limite_credito.size()) {
                      portalbr.dbobj.view.Jw_maiores_clientes_limite_credito t_jw_maiores_clientes_limite_credito = (portalbr.dbobj.view.Jw_maiores_clientes_limite_credito)res_Jw_maiores_clientes_limite_credito.elementAt(i_bl_report_Jw_maiores_clientes_limite_credito);
                      codigo = t_jw_maiores_clientes_limite_credito.getCodigo();
                      razao = t_jw_maiores_clientes_limite_credito.getRazao()==null?"":t_jw_maiores_clientes_limite_credito.getRazao();
                      tipo = t_jw_maiores_clientes_limite_credito.getTipo()==null?"":t_jw_maiores_clientes_limite_credito.getTipo();
                      limite = t_jw_maiores_clientes_limite_credito.getLimite();
                      pedidos_producao = t_jw_maiores_clientes_limite_credito.getPedidos_producao();
                      saldo = t_jw_maiores_clientes_limite_credito.getSaldo();
                      p_qtd_vencer = t_jw_maiores_clientes_limite_credito.getP_qtd_vencer();
                      p_vlr_vencer = t_jw_maiores_clientes_limite_credito.getP_vlr_vencer();
                      p_qtd_vencido = t_jw_maiores_clientes_limite_credito.getP_qtd_vencido();
                      p_vlr_vencido = t_jw_maiores_clientes_limite_credito.getP_vlr_vencido();
                      percentual_pontualidade = t_jw_maiores_clientes_limite_credito.getPercentual_pontualidade();
                      pedidos_nao_liberados = t_jw_maiores_clientes_limite_credito.getPedidos_nao_liberados();
                      String style_bl_report_Jw_maiores_clientes_limite_credito="";
                      if (!((i_bl_report_Jw_maiores_clientes_limite_credito%2)!=0)) {
                        style_bl_report_Jw_maiores_clientes_limite_credito="rowColor";
                      } else {
                        style_bl_report_Jw_maiores_clientes_limite_credito="rowBlank";
                      }
                      %>

                      <tr valign="top" class='<%= style_bl_report_Jw_maiores_clientes_limite_credito %>' id="TRbl_report_Jw_maiores_clientes_limite_credito<%=i_bl_report_Jw_maiores_clientes_limite_credito%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((codigo!=null)?codigo.toString():"") %>
                          <%
                          if(tipo.equals("Grupo")) {
                            %>
                            <%
                          }
                          %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= razao %>
                          <%
                          if(tipo.equals("Grupo")) {
                            %>
                            <br>
                            <br>
                            <%= query.retorna(j,"SELECT '('||rowtocol('SELECT distinct '' ''|| g.cli_cdgo||'' '' FROM grupo_economico g, cli c WHERE NVL(g.status,NULL) = ''A'' AND g.cli_cdgo = c.cli_cdgo  and nvl(c.cli_situ,null) = ''A''  AND g.gre_grupo = "+codigo+" order by 1')||')' FROM dual") %>
                            <%
                          }
                          %>
                        </td>


                        <td class="reportColumn" style="text-align:left;" >
                          <%= tipo %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(limite, "##,##0.00") %>
                          <%
                          total_limite += limite;
                          %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(pedidos_nao_liberados, "##,##0.00") %>
                          <%
                          total_pedidos_nao_liberados += pedidos_nao_liberados;
                          %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(pedidos_producao, "##,##0.00") %>
                          <%
                          total_pedidos_producao += pedidos_producao;
                          %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(p_vlr_vencer, "##,##0.00") %>
                          <%
                          total_vencer += p_vlr_vencer;
                          %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(p_vlr_vencido, "##,##0.00") %>
                          <%
                          total_vencido += p_vlr_vencido;
                          %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(saldo, "##,##0.00") %>
                          <%
                          total_saldo += saldo;
                          %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(percentual_pontualidade, "##,##0.00") %>
                          <%
                          total_percentual += percentual_pontualidade;
                          %>
                        </td>

                        <%
                        ++contador;
                        %>


                      </tr>

                      <%
                      i_bl_report_Jw_maiores_clientes_limite_credito++;
                      if (i_bl_report_Jw_maiores_clientes_limite_credito<res_Jw_maiores_clientes_limite_credito.size()) {
                        t_jw_maiores_clientes_limite_credito = (portalbr.dbobj.view.Jw_maiores_clientes_limite_credito)res_Jw_maiores_clientes_limite_credito.elementAt(i_bl_report_Jw_maiores_clientes_limite_credito);
                        codigo = t_jw_maiores_clientes_limite_credito.getCodigo();
                        razao = t_jw_maiores_clientes_limite_credito.getRazao()==null?"":t_jw_maiores_clientes_limite_credito.getRazao();
                        tipo = t_jw_maiores_clientes_limite_credito.getTipo()==null?"":t_jw_maiores_clientes_limite_credito.getTipo();
                        limite = t_jw_maiores_clientes_limite_credito.getLimite();
                        pedidos_producao = t_jw_maiores_clientes_limite_credito.getPedidos_producao();
                        p_qtd_vencer = t_jw_maiores_clientes_limite_credito.getP_qtd_vencer();
                        p_vlr_vencer = t_jw_maiores_clientes_limite_credito.getP_vlr_vencer();
                        p_qtd_vencido = t_jw_maiores_clientes_limite_credito.getP_qtd_vencido();
                        p_vlr_vencido = t_jw_maiores_clientes_limite_credito.getP_vlr_vencido();
                        saldo = t_jw_maiores_clientes_limite_credito.getSaldo();
                        percentual_pontualidade = t_jw_maiores_clientes_limite_credito.getPercentual_pontualidade();
                        pedidos_nao_liberados = t_jw_maiores_clientes_limite_credito.getPedidos_nao_liberados();
                      } else {
                      }
                    }
                    %>

                    <tr>
                      <td class="reportColumn" style="text-align:right;" >
                      </td>
                      <td class="reportColumn" style="text-align:right;" >
                      </td>
                      <td class="reportColumn" style="text-align:right;" >
                      </td>
                      <td class="reportColumn" style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(total_limite, "##,##0.00") %>
                        </b>
                      </td>
                      <td class="reportColumn" style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(total_pedidos_nao_liberados, "##,##0.00") %>
                        </b>
                      </td>
                      <td class="reportColumn" style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(total_pedidos_producao, "##,##0.00") %>
                        </b>
                      </td>
                      <td class="reportColumn" style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(total_vencer, "##,##0.00") %>
                        </b>
                      </td>
                      <td class="reportColumn" style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(total_vencido, "##,##0.00") %>
                        </b>
                      </td>
                      <td class="reportColumn" style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(total_saldo, "##,##0.00") %>
                        </b>
                      </td>
                      <td class="reportColumn" style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format((total_percentual/contador), "##,##0.00") %>
                        </b>
                      </td>
                    </tr>

                  </table>

                  <%
                }
                %>

              </form>
              <%
            } finally {
            if (j != null){ j.close();}

          }
          %>
          <html:form action="adm/SugestaoClientesLimiteCredito_rForm.do" method="post" styleClass="baseForm">
            <table class="messageTable" style='width:99%;'>
              <tr class="messageTr" >
                <td class="messageTd">
                </td>
              </tr>
            </table>

            <%
            if(!(request.getParameter("excel")+"").equals("true")){
              %>
              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:submit>
                  </td>
                </tr>
              </table>
              <%
            }
            %>

          </html:form>
        </td>
      </tr>
    </table>

  </body>
</center>
</html>

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Clientes Compras
      <%= (String)(request.getParameter("cab")+"").replace('*','&') %>
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
                  <%@ include file="../system/header_data.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(58)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Jw_clientes_atendidos" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_clientes_atendidos=0;
              {
                portalbr.dbobj.view.Jw_clientes_atendidos t_jw_clientes_atendidos = new portalbr.dbobj.view.Jw_clientes_atendidos();
                java.util.Vector res_Jw_clientes_atendidos = (java.util.Vector)session.getAttribute("res_Jw_clientes_atendidos");
                if (res_Jw_clientes_atendidos!=null && res_Jw_clientes_atendidos.size()>0) {
                  java.lang.String cli_cdgo =  null;
                  java.lang.String cli_nome =  null;
                  java.lang.String cli_rzao =  null;
                  java.lang.String cidade =  null;
                  java.lang.String email =  null;
                  java.lang.String fones =  null;
                  java.sql.Timestamp cli_dult =  null;
                  int pares =  0;
                  int pares_recolocado =  0;
                  int total_pares = 0;
                  int total_pares_recolocado = 0;
                  double valor =  0;
                  double saldo =  0;
                  double limite_credito =  0;
                  double valor_recolocado =  0;
                  double total_valor = 0;
                  double total_valor_recolocado = 0;
                  int i_bl_report_Jw_clientes_atendidos = 0;
                  t_jw_clientes_atendidos = (portalbr.dbobj.view.Jw_clientes_atendidos)res_Jw_clientes_atendidos.elementAt(i_bl_report_Jw_clientes_atendidos);
                  cli_cdgo = t_jw_clientes_atendidos.getCli_cdgo()==null?"":t_jw_clientes_atendidos.getCli_cdgo();
                  cli_nome = t_jw_clientes_atendidos.getCli_nome()==null?"":t_jw_clientes_atendidos.getCli_nome();
                  cli_rzao = t_jw_clientes_atendidos.getCli_rzao()==null?"":t_jw_clientes_atendidos.getCli_rzao();
                  cidade = t_jw_clientes_atendidos.getCidade()==null?"":t_jw_clientes_atendidos.getCidade();
                  email = t_jw_clientes_atendidos.getEmail()==null?"":t_jw_clientes_atendidos.getEmail();
                  fones = t_jw_clientes_atendidos.getFones()==null?"":t_jw_clientes_atendidos.getFones();
                  cli_dult = (java.sql.Timestamp)t_jw_clientes_atendidos.getCli_dult();
                  pares = t_jw_clientes_atendidos.getPares();
                  valor = t_jw_clientes_atendidos.getValor();
                  saldo = t_jw_clientes_atendidos.getSaldo();
                  limite_credito = t_jw_clientes_atendidos.getLimite_credito();
                  pares_recolocado = t_jw_clientes_atendidos.getPares_recolocado();
                  valor_recolocado = t_jw_clientes_atendidos.getValor_recolocado();
                  %>

                  <tr class="reportHeader" valign="bottom">
                    <td class="columnTdHeader" style="text-align: left;" colspan="7">
                    </td>
                    <td class="columnTdHeader" style="text-align: center;" colspan="2">
                      Entrada
                      <br>
                      Mês
                    </td>
                    <td class="columnTdHeader" style="text-align: center;" colspan="2">
                      Recolocados
                      <br>
                      Fora Mês
                    </td>
                    <%
                    if(((String)session.getAttribute("ca_consulta_saldo_limite_credito")).equalsIgnoreCase("S")){
                      %>
                      <td class="columnTdHeader" style="text-align: left;" colspan="2">
                      </td>
                      <%
                    }
                    %>
                  </tr>
                  <tr class="reportHeader" valign="bottom">
                    <td class="columnTdHeader" style="text-align:left;">
                      Código
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Nome
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Razão Social
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Cidade
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Email
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Fone
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <img style=cursor:pointer src=../img/ballhelp.gif border=0 onmouseout="this.src='../img/ballhelp.gif'" onmouseover="this.src='../img/ballhelp_c.gif'" onclick="javascript:window.open('../lov/HelpForm.jsp?help=Data da última compra do cliente no período, marca e linha informados; levando em consideração apenas os pedidos que não estejam cancelados. (Período com base na data de digitação dos pedidos).','def','scrollbars,height=400,width=340,TOP=0,LEFT=0')">
                        <%
                      }
                      %>
                      <br>
                      Data Última Compra
                    </td>
                    <td class="columnTdHeader" style="text-align:right;">
                      Pares
                    </td>
                    <td class="columnTdHeader" style="text-align:right;">
                      Valor
                    </td>
                    <td class="columnTdHeader" style="text-align:right;">
                      Pares
                    </td>
                    <td class="columnTdHeader" style="text-align:right;">
                      Valor
                    </td>

                    <%
                    if(((String)session.getAttribute("ca_consulta_saldo_limite_credito")).equalsIgnoreCase("S")){
                      %>

                      <td class="columnTdHeader" style="text-align:right;">
                        Saldo
                      </td>
                      <td class="columnTdHeader" style="text-align:right;">
                        Limite Crédito
                      </td>

                      <%
                    }
                    %>

                  </tr>
                  <%
                  while (i_bl_report_Jw_clientes_atendidos<res_Jw_clientes_atendidos.size()){
                    counterbl_report_Jw_clientes_atendidos++;
                    String style="";
                    if (!((i_bl_report_Jw_clientes_atendidos%2)!=0)) {
                      style="class=rowColor";
                    } else {
                      style="class=rowBlank";
                    }
                    %>
                    <tr <%= style %> id='TRbl_report_Jw_clientes_atendidos<%=counterbl_report_Jw_clientes_atendidos%>' >
                      <td class="reportColumn" style="text-align:left;">
                        <%= cli_cdgo %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= cli_nome %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= cli_rzao %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= cidade %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= email %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= fones %>
                      </td>
                      <td class="reportColumn" style="text-align:center;" >
                        <%= com.egen.util.text.FormatDate.format(cli_dult, "dd/MM/yyyy") %>
                      </td>
                      <td class="reportColumn" style="text-align:right;">
                        <%
                        total_pares += pares;
                        total_valor += valor;
                        %>
                        <%= com.egen.util.text.FormatNumber.format(pares, "###,###,##0") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;">
                        <%= com.egen.util.text.FormatNumber.format(valor, "##,##0.00") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;">
                        <%
                        total_pares_recolocado += pares_recolocado;
                        total_valor_recolocado += valor_recolocado;
                        %>
                        <%
                        if(pares_recolocado>0) {
                          %>
                          <%= com.egen.util.text.FormatNumber.format(pares_recolocado, "###,###,##0") %>
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

                      <td class="reportColumn" style="text-align:right;">
                        <%
                        if(valor_recolocado > 0) {
                          %>
                          <%= com.egen.util.text.FormatNumber.format(valor_recolocado, "##,##0.00") %>
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
                      if(((String)session.getAttribute("ca_consulta_saldo_limite_credito")).equalsIgnoreCase("S")){
                        %>

                        <td class="reportColumn" style="text-align:right;">
                          <%
                          if(saldo> 0) {
                            %>
                            <%= com.egen.util.text.FormatNumber.format(saldo, "##,##0.00") %>
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

                        <td class="reportColumn" style="text-align:right;">
                          <%
                          if(limite_credito> 0) {
                            %>
                            <%= com.egen.util.text.FormatNumber.format(limite_credito, "##,##0.00") %>
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
                      }
                      %>

                    </tr>
                    <%
                    if (++i_bl_report_Jw_clientes_atendidos >= res_Jw_clientes_atendidos.size()) {
                      break;
                    }
                    t_jw_clientes_atendidos = (portalbr.dbobj.view.Jw_clientes_atendidos)res_Jw_clientes_atendidos.elementAt(i_bl_report_Jw_clientes_atendidos);
                    cli_cdgo = t_jw_clientes_atendidos.getCli_cdgo()==null?"":t_jw_clientes_atendidos.getCli_cdgo();
                    cli_nome = t_jw_clientes_atendidos.getCli_nome()==null?"":t_jw_clientes_atendidos.getCli_nome();
                    cli_rzao = t_jw_clientes_atendidos.getCli_rzao()==null?"":t_jw_clientes_atendidos.getCli_rzao();
                    cidade = t_jw_clientes_atendidos.getCidade()==null?"":t_jw_clientes_atendidos.getCidade();
                    email = t_jw_clientes_atendidos.getEmail()==null?"":t_jw_clientes_atendidos.getEmail();
                    fones = t_jw_clientes_atendidos.getFones()==null?"":t_jw_clientes_atendidos.getFones();
                    cli_dult = (java.sql.Timestamp)t_jw_clientes_atendidos.getCli_dult();
                    pares = t_jw_clientes_atendidos.getPares();
                    valor = t_jw_clientes_atendidos.getValor();
                    saldo = t_jw_clientes_atendidos.getSaldo();
                    limite_credito = t_jw_clientes_atendidos.getLimite_credito();
                    pares_recolocado = t_jw_clientes_atendidos.getPares_recolocado();
                    valor_recolocado = t_jw_clientes_atendidos.getValor_recolocado();
                  }
                  %>
                  <td class="reportColumn" style="text-align:right;" colspan="7">
                    <b>
                      Total:
                    </b>
                  </td>
                  <td class="reportColumn" style="text-align:right;" >
                    <b>
                      <%= com.egen.util.text.FormatNumber.format(total_pares-total_pares_recolocado, "###,###,##0") %>
                    </b>
                  </td>
                  <td class="reportColumn" style="text-align:right;" >
                    <b>
                      <%= com.egen.util.text.FormatNumber.format(total_valor-total_valor_recolocado, "###,###,##0.00") %>
                    </b>
                  </td>

                  <td class="reportColumn" style="text-align:right;" >
                    <b>
                      <%= com.egen.util.text.FormatNumber.format(total_pares_recolocado, "###,###,##0") %>
                    </b>
                  </td>
                  <td class="reportColumn" style="text-align:right;" >
                    <b>
                      <%= com.egen.util.text.FormatNumber.format(total_valor_recolocado, "###,###,##0.00") %>
                    </b>
                  </td>
                </tr>

                <tr>
                  <td class="reportColumn" style="text-align:right;" colspan="7">
                    <b>
                      Total Geral:
                    </b>
                  </td>
                  <td class="reportColumn" style="text-align:right;" colspan="2" >
                    <b>
                      <%= com.egen.util.text.FormatNumber.format(total_pares+total_pares_recolocado, "###,###,##0") %>
                    </b>
                  </td>
                  <td class="reportColumn" style="text-align:right;" colspan="2" >
                    <b>
                      <%= com.egen.util.text.FormatNumber.format(total_valor+total_valor_recolocado, "###,###,##0.00") %>
                    </b>
                  </td>


                </tr>

                <%
              }
            }
            %>
          </table>
          <html:form action="adm/Clientes_comprasForm.do" method="post" styleClass="baseForm">
            <table class="messageTable" style='width:99%;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_compras"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:99%;">
              <html:hidden property="rep_cdgo"/>
              <html:hidden property="codigo_regional"/>
              <html:hidden property="codigo_marca"/>
              <html:hidden property="segmento"/>
              <html:hidden property="limite"/>
              <html:hidden property="meses"/>
            </table>

            <table class="buttonTable" style='width:99%;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <%
                  if(!(request.getParameter("excel")+"").equals("true")){
                    %>
                    <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <%
                  }
                  %>
                  <%
                  if(!(request.getParameter("excel")+"").equals("true")){
                    %>
                    <html:button accesskey="a" onclick="history.go(-1);" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:button>
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

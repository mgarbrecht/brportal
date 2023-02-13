<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Clientes Não Atendidos
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

            <table id="TRbl_report_Jw_clientes_nao_atendidos" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_clientes_nao_atendidos=0;
              %>
              <%
              {
                portalbr.dbobj.view.Jw_clientes_nao_atendidos t_jw_clientes_nao_atendidos = new portalbr.dbobj.view.Jw_clientes_nao_atendidos();
                java.util.Vector res_Jw_clientes_nao_atendidos = (java.util.Vector)session.getAttribute("res_Jw_clientes_nao_atendidos");
                if (res_Jw_clientes_nao_atendidos!=null && res_Jw_clientes_nao_atendidos.size()>0) {
                  java.lang.String cli_cdgo =  null;
                  java.lang.String cli_nome =  null;
                  java.lang.String cli_rzao =  null;
                  java.lang.String cnpj = null;
                  java.lang.String cidade =  null;
                  java.lang.String email =  null;
                  java.lang.String fones =  null;
                  java.lang.String endereco = null;
                  java.sql.Timestamp cli_dult =  null;
                  double saldo = 0;
                  double limite_credito = 0;
                  int i_bl_report_Jw_clientes_nao_atendidos = 0;
                  t_jw_clientes_nao_atendidos = (portalbr.dbobj.view.Jw_clientes_nao_atendidos)res_Jw_clientes_nao_atendidos.elementAt(i_bl_report_Jw_clientes_nao_atendidos);
                  cli_cdgo = t_jw_clientes_nao_atendidos.getCli_cdgo()==null?"":t_jw_clientes_nao_atendidos.getCli_cdgo();
                  cli_nome = t_jw_clientes_nao_atendidos.getCli_nome()==null?"":t_jw_clientes_nao_atendidos.getCli_nome();
                  cli_rzao = t_jw_clientes_nao_atendidos.getCli_rzao()==null?"":t_jw_clientes_nao_atendidos.getCli_rzao();
                  cnpj = t_jw_clientes_nao_atendidos.getCnpj()==null?" ":t_jw_clientes_nao_atendidos.getCnpj();
                  cidade = t_jw_clientes_nao_atendidos.getCidade()==null?"":t_jw_clientes_nao_atendidos.getCidade();
                  email = t_jw_clientes_nao_atendidos.getEmail()==null?"":t_jw_clientes_nao_atendidos.getEmail();
                  fones = t_jw_clientes_nao_atendidos.getFones()==null?"":t_jw_clientes_nao_atendidos.getFones();
                  endereco = t_jw_clientes_nao_atendidos.getEndereco()==null?"":t_jw_clientes_nao_atendidos.getEndereco();
                  cli_dult = (java.sql.Timestamp)t_jw_clientes_nao_atendidos.getCli_dult();
                  saldo = t_jw_clientes_nao_atendidos.getSaldo();
                  limite_credito = t_jw_clientes_nao_atendidos.getLimite_credito();
                  %>
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
                      CNPJ
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
                    <td class="columnTdHeader" style="text-align:left;">
                      Endereço
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <img style=cursor:pointer src=../img/ballhelp.gif border=0 onmouseout="this.src='../img/ballhelp.gif'" onmouseover="this.src='../img/ballhelp_c.gif'" onclick="javascript:window.open('../lov/HelpForm.jsp?help=Data da última compra do cliente, com base na data de digitação dos pedidos, levando em consideração apenas os pedidos que não estejam cancelados.','def','scrollbars,height=400,width=340,TOP=0,LEFT=0')">
                        <br>
                        <%
                      }
                      %>
                      Data Última Compra
                    </td>
                    <%
                    if(((String)session.getAttribute("ca_consulta_saldo_limite_credito")).equalsIgnoreCase("S")){
                      %>
                      <td class="columnTdHeader" style="text-align: right;">
                        Saldo
                      </td>
                      <td class="columnTdHeader" style="text-align: right;">
                        Limite Crédito
                      </td>
                      <%
                    }
                    %>
                  </tr>
                  <%
                  while (i_bl_report_Jw_clientes_nao_atendidos<res_Jw_clientes_nao_atendidos.size()){
                    counterbl_report_Jw_clientes_nao_atendidos++;
                    String style="";
                    if (!((i_bl_report_Jw_clientes_nao_atendidos%2)!=0)) {
                      style="class=rowColor";
                    } else {
                      style="class=rowBlank";
                    }
                    %>
                    <tr <%= style %> id='TRbl_report_Jw_clientes_nao_atendidos<%=counterbl_report_Jw_clientes_nao_atendidos%>' >
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
                        <%= cnpj %>
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
                      <td class="reportColumn" style="text-align:left;">
                        <%= endereco %>
                        <td class="reportColumn" style="text-align:center;">
                          <%= com.egen.util.text.FormatDate.format(cli_dult, "dd/MM/yyyy") %>
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
                      if (++i_bl_report_Jw_clientes_nao_atendidos >= res_Jw_clientes_nao_atendidos.size()) {
                        break;
                      }
                      t_jw_clientes_nao_atendidos = (portalbr.dbobj.view.Jw_clientes_nao_atendidos)res_Jw_clientes_nao_atendidos.elementAt(i_bl_report_Jw_clientes_nao_atendidos);
                      cli_cdgo = t_jw_clientes_nao_atendidos.getCli_cdgo()==null?"":t_jw_clientes_nao_atendidos.getCli_cdgo();
                      cli_nome = t_jw_clientes_nao_atendidos.getCli_nome()==null?"":t_jw_clientes_nao_atendidos.getCli_nome();
                      cli_rzao = t_jw_clientes_nao_atendidos.getCli_rzao()==null?"":t_jw_clientes_nao_atendidos.getCli_rzao();
                      cnpj = t_jw_clientes_nao_atendidos.getCnpj()==null?" ":t_jw_clientes_nao_atendidos.getCnpj();
                      cidade = t_jw_clientes_nao_atendidos.getCidade()==null?"":t_jw_clientes_nao_atendidos.getCidade();
                      email = t_jw_clientes_nao_atendidos.getEmail()==null?"":t_jw_clientes_nao_atendidos.getEmail();
                      fones = t_jw_clientes_nao_atendidos.getFones()==null?"":t_jw_clientes_nao_atendidos.getFones();
                      endereco = t_jw_clientes_nao_atendidos.getEndereco()==null?"":t_jw_clientes_nao_atendidos.getEndereco();
                      cli_dult = (java.sql.Timestamp)t_jw_clientes_nao_atendidos.getCli_dult();
                      saldo = t_jw_clientes_nao_atendidos.getSaldo();
                      limite_credito = t_jw_clientes_nao_atendidos.getLimite_credito();
                    }
                  }
                }
                %>
              </table>
              <html:form action="adm/Clientes_nao_atendidosForm.do" method="post" styleClass="baseForm">
                <table class="messageTable" style='width:99%;'>
                  <tr class="messageTr" >
                    <td class="messageTd">
                      <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_nao_atendidos"/>
                    </td>
                  </tr>
                </table>

                <table class="itemTable"  style="width:99%;">
                  <html:hidden property="rep_cdgo"/>
                  <html:hidden property="codigo_marca"/>
                  <html:hidden property="codigo_regional"/>
                  <html:hidden property="segmento"/>
                  <html:hidden property="limite"/>
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
                        <html:button onclick="history.go(-1);" styleClass="baseButton" property="back_action">
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

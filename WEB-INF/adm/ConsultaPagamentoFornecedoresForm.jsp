<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Consulta de Pagamento de Fornecedores
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(227)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="adm/ConsultaPagamentoFornecedoresForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="fornecedor"/>
                    <html:errors property="data_vencimento"/>
                    <html:errors property="data_vencimento_fim"/>
                    <html:errors property="data_pagamento"/>
                    <html:errors property="data_pagamento_fim"/>
                    <html:errors property="status"/>
                    <html:errors property="nota"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_dom_obri"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String chave = "";
                acesso.Sessao sessao = new acesso.Sessao(session);
                if(sessao.getTipoEntidadeNegocio().equals("FORNECEDOR")
                ||sessao.getTipoEntidadeNegocio().equals("ATELIER")){
                  chave = sessao.getChave();

                }
                %>

                <%
                if(chave.equals("")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Fornecedor
                      </span>
                    </td>
                    <td class="formField">


                      <html:text property="fornecedor" styleId="fornecedor" styleClass="baseField" size="22" maxlength="22"/>

                    </td>
                  </tr>

                  <%
                } else {
                  %>
                  <html:hidden property="fornecedor" value ="<%= chave %>" />
                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Período Vencimento
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_vencimento" styleId="data_vencimento" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_vencimento']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="data_vencimento_fim" styleId="data_vencimento_fim" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_vencimento_fim']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Período Pagamento
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_pagamento" styleId="data_pagamento" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_pagamento']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="data_pagamento_fim" styleId="data_pagamento_fim" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_pagamento_fim']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Status
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="status" styleId="status" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="L">
                        Liquidado
                      </html:option>
                      <html:option styleClass="baseOption" value="A">
                        Aberto
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nota Fiscal
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="nota" styleId="nota" styleClass="baseField" size="10"/>
                  </td>
                </tr>

                <%
                if(chave.equals("")){
                  %>

                  <script>
                    jQuery(document).ready(function($) {
                      $("#fornecedor").focus();
                      });
                    </script>

                    <%
                  } else {
                    %>

                    <script>
                      jQuery(document).ready(function($) {
                        $("#data_vencimento").focus();
                        });
                      </script>

                      <%
                    }
                    %>
                  </table>

                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:button accesskey="p" onclick="resetfull1_action.disabled=true;this.disabled=true;bloqueia();document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:button>
                        <script>
                          function getKeySite(keyStroke) {
                            isNetscape=(document.layers);
                            eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                            which = String.fromCharCode(eventChooser).toLowerCase();
                            keyBuffer = which;
                            if(eventChooser == 13){
                            if(document.forms[0].select1_action.disabled==true){return false;}
                            document.forms[0].select1_action.disabled=true;
                            document.forms[0].resetfull1_action.disabled=true;
                            bloqueia();
                            document.forms[0].select_action.click();
                          }
                        }
                      </script>
                      <SCRIPT>
                        document.onkeypress = getKeySite;
                        </SCRIPT><html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                        <html:submit accesskey="p" styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                        <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                        </td>
                        </tr>
                        </table>

                        <script type="text/javascript">
                        jQuery(document).ready(function($) {
                          $("#data_vencimento").mask("99/99/9999");
                          $("#data_vencimento_fim").mask("99/99/9999");
                          $("#data_pagamento").mask("99/99/9999");
                          $("#data_pagamento_fim").mask("99/99/9999");
                          });
                        </script>
                      </html:form>
                      <%
                      {
                        %>

                        <%
                        java.util.Vector res_Jw_dom_obri = (java.util.Vector)session.getAttribute("res_Jw_dom_obri");
                        %>

                        <form  name="bl_report_Jw_dom_obri" id="bl_report_Jw_dom_obri" class="baseForm" method="post" >
                          <%
                          if (res_Jw_dom_obri!=null && res_Jw_dom_obri.size()>0) {
                            %>

                            <table id="TRbl_report_Jw_dom_obri"  class="reportTable"   style="width:99%; "  border="1" >
                              <%
                              java.lang.String fil_razsoc =  null;
                              int nota =  0;
                              double valor_obrigacao =  0;
                              java.lang.String obrigacao =  null;
                              java.lang.String tipo =  null;
                              java.sql.Date data_emissao =  null;
                              java.sql.Date data_pagamento =  null;
                              java.sql.Date data_vencimento =  null;
                              double saldo_pagar =  0;
                              double pago_sem_desc =  0;
                              java.lang.String cnpj =  null;
                              double sum_valor_obrigacao_0 = 0;
                              double sum_saldo_pagar_0 = 0;
                              double sum_pago_sem_desc_0 = 0;
                              %>

                              <tr class="reportTr">
                                <td class="columnTdHeader" style="text-align:left;" >
                                  Filial
                                </td>

                                <td class="columnTdHeader" style="text-align:right;" >
                                  Nota
                                </td>

                                <td class="columnTdHeader" style="text-align:right;" >
                                  Valor nota
                                </td>

                                <td class="columnTdHeader" style="text-align:center;" >
                                  Obrigação
                                </td>

                                <td class="columnTdHeader" style="text-align:center;" >
                                  Tipo
                                </td>

                                <td class="columnTdHeader" style="text-align:center;" >
                                  Emissão
                                </td>

                                <td class="columnTdHeader" style="text-align:center;" >
                                  Data Pag
                                </td>

                                <td class="columnTdHeader" style="text-align:center;" >
                                  Data Vencimento
                                </td>

                                <td class="columnTdHeader" style="text-align:right;" >
                                  Valor a Pagar
                                </td>

                                <td class="columnTdHeader" style="text-align:right;" >
                                  Valor Pago
                                </td>

                                <td class="columnTdHeader" style="text-align:center;" >
                                  Cnpj
                                </td>

                              </tr>

                              <%
                              int i_bl_report_Jw_dom_obri = 0;
                              while (i_bl_report_Jw_dom_obri<res_Jw_dom_obri.size()) {
                                portalbr.dbobj.view.Jw_dom_obri t_jw_dom_obri = (portalbr.dbobj.view.Jw_dom_obri)res_Jw_dom_obri.elementAt(i_bl_report_Jw_dom_obri);
                                fil_razsoc = t_jw_dom_obri.getFil_razsoc()==null?"":t_jw_dom_obri.getFil_razsoc();
                                nota = t_jw_dom_obri.getNota();
                                valor_obrigacao = t_jw_dom_obri.getValor_obrigacao();
                                obrigacao = t_jw_dom_obri.getObrigacao()==null?"":t_jw_dom_obri.getObrigacao();
                                tipo = t_jw_dom_obri.getTipo()==null?"":t_jw_dom_obri.getTipo();
                                data_emissao = (java.sql.Date)t_jw_dom_obri.getData_emissao();
                                data_pagamento = (java.sql.Date)t_jw_dom_obri.getData_pagamento();
                                data_vencimento = (java.sql.Date)t_jw_dom_obri.getData_vencimento();
                                saldo_pagar = t_jw_dom_obri.getSaldo_pagar();
                                pago_sem_desc = t_jw_dom_obri.getPago_sem_desc();
                                cnpj = t_jw_dom_obri.getCnpj()==null?"":t_jw_dom_obri.getCnpj();
                                sum_valor_obrigacao_0 += valor_obrigacao;
                                sum_saldo_pagar_0 += saldo_pagar;
                                sum_pago_sem_desc_0 += pago_sem_desc;
                                String style_bl_report_Jw_dom_obri="";
                                if (!((i_bl_report_Jw_dom_obri%2)!=0)) {
                                  style_bl_report_Jw_dom_obri="rowColor";
                                } else {
                                  style_bl_report_Jw_dom_obri="rowBlank";
                                }
                                %>

                                <tr class='<%= style_bl_report_Jw_dom_obri %>' id="TRbl_report_Jw_dom_obri<%=i_bl_report_Jw_dom_obri%>" >
                                  <td class="reportColumn" style="text-align:left;" >
                                    <%= fil_razsoc %>
                                  </td>

                                  <td class="reportColumn" style="text-align:right;" >
                                    <%= nota %>
                                  </td>

                                  <td class="reportColumn" style="text-align:right;" >
                                    <%= valor_obrigacao %>
                                  </td>

                                  <td class="reportColumn" style="text-align:center;" >
                                    <%= obrigacao %>
                                  </td>

                                  <td class="reportColumn" style="text-align:center;" >
                                    <%= tipo %>
                                  </td>

                                  <td class="reportColumn" style="text-align:center;" >
                                    <%= com.egen.util.text.FormatDate.format(data_emissao, "dd/MM/yyyy") %>
                                  </td>

                                  <td class="reportColumn" style="text-align:center;" >
                                    <%= com.egen.util.text.FormatDate.format(data_pagamento, "dd/MM/yyyy") %>
                                  </td>

                                  <td class="reportColumn" style="text-align:center;" >
                                    <%= com.egen.util.text.FormatDate.format(data_vencimento, "dd/MM/yyyy") %>
                                  </td>

                                  <td class="reportColumn" style="text-align:right;" >
                                    <%= saldo_pagar %>
                                  </td>

                                  <td class="reportColumn" style="text-align:right;" >
                                    <%= pago_sem_desc %>
                                  </td>

                                  <td class="reportColumn" style="text-align:center;" >
                                    <%= cnpj %>
                                  </td>

                                </tr>

                                <%
                                i_bl_report_Jw_dom_obri++;
                                if (i_bl_report_Jw_dom_obri<res_Jw_dom_obri.size()) {
                                  t_jw_dom_obri = (portalbr.dbobj.view.Jw_dom_obri)res_Jw_dom_obri.elementAt(i_bl_report_Jw_dom_obri);
                                  fil_razsoc = t_jw_dom_obri.getFil_razsoc()==null?"":t_jw_dom_obri.getFil_razsoc();
                                  nota = t_jw_dom_obri.getNota();
                                  valor_obrigacao = t_jw_dom_obri.getValor_obrigacao();
                                  obrigacao = t_jw_dom_obri.getObrigacao()==null?"":t_jw_dom_obri.getObrigacao();
                                  tipo = t_jw_dom_obri.getTipo()==null?"":t_jw_dom_obri.getTipo();
                                  data_emissao = (java.sql.Date)t_jw_dom_obri.getData_emissao();
                                  data_pagamento = (java.sql.Date)t_jw_dom_obri.getData_pagamento();
                                  data_vencimento = (java.sql.Date)t_jw_dom_obri.getData_vencimento();
                                  saldo_pagar = t_jw_dom_obri.getSaldo_pagar();
                                  pago_sem_desc = t_jw_dom_obri.getPago_sem_desc();
                                  cnpj = t_jw_dom_obri.getCnpj()==null?"":t_jw_dom_obri.getCnpj();
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
                                <td class="totalTdColumn"  style="text-align:right; font-weight:bold;" >
                                  <%= com.egen.util.text.FormatNumber.format(sum_valor_obrigacao_0, "R$ ##,##0.00") %>
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
                                <td class="totalTdColumn"  style="text-align:right; font-weight:bold;" >
                                  <%= com.egen.util.text.FormatNumber.format(sum_saldo_pagar_0, "R$ ##,##0.00") %>
                                </td>
                                <td class="totalTdColumn"  style="text-align:right; font-weight:bold;" >
                                  <%= com.egen.util.text.FormatNumber.format(sum_pago_sem_desc_0, "R$ ##,##0.00") %>
                                </td>
                                <td>
                                  &nbsp;
                                </td>
                              </tr>

                              <%
                              %>

                            </table>

                            <%
                          }
                          %>

                          <script type="text/javascript">
                            jQuery(document).ready(function($) {
                              $("#cnpj").mask("99.999.999/9999-99");
                              });
                            </script>

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

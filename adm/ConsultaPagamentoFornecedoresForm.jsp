<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ConsultaPagamentoFornecedoresActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ConsultaPagamentoFornecedoresActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("fornecedor","Fornecedor");
    hashMapLabel.set("fornecedor_razao_social","");
    hashMapLabel.set("data_vencimento","Período Vencimento / Pagamentos Agendados");
    hashMapLabel.set("data_vencimento_fim","");
    hashMapLabel.set("data_pagamento","Período Pagamento / Pagamentos Efetuados");
    hashMapLabel.set("data_pagamento_fim","");
    hashMapLabel.set("status","Status");
    hashMapLabel.set("nota","Nota Fiscal");
    hashMapLabel.set("gerar_planilha","Gerar Planilha");
    hashMapLabel.set("free_xls","");
    hashMapLabel.set("f_focus","");
    var reportColumns = new Array(new Array("fil_razsoc","fil_cnpj","nota","valor_obrigacao","obrigacao","tipo","data_emissao","data_pagamento","data_vencimento","saldo_pagar","cnpj","pago_sem_desc","Abatimentos","fornecedor","sequencia","cd_tipo","qtd"));
  </script>
  <bean:message key="page.ajaxscript"/>
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

            <%
            util.consultas.Query query = new util.consultas.Query();
            String comunicadoGeral = "";
            boolean mostraComunicadoGeral = false;
            String mostraComunicado = query.retorna("SELECT valor FROM wbrio.parametros WHERE nome = 'mostra_comunicado_geral_consulta_fornecedores' AND par_sist_codigo = 'BRNET'");
            if(mostraComunicado.equalsIgnoreCase("S")){
              mostraComunicadoGeral = true;
              comunicadoGeral = query.retorna("SELECT valor FROM wbrio.parametros WHERE nome = 'comunicado_geral_consulta_fornecedores' AND par_sist_codigo = 'BRNET'");
            }
            %>
            <%
            if(!(request.getParameter("excel")+"").equals("true")){
              %>


              <html:form action="adm/ConsultaPagamentoFornecedoresForm.do" method="post" styleClass="baseForm">
                <table class="messageTable" style='width:99%;'>
                  <tr class="messageTr" >
                    <td class="messageTd">
                      <html:errors property="fornecedor"/>
                      <html:errors property="fornecedor_razao_social"/>
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

                <%
                if(mostraComunicadoGeral){
                  %>
                  <table border="0" style="width:99%;">
                    <tr>
                      <td style="width: 60%">
                        <%
                      }
                      %>

                      <table class="itemTable" style="width:99%;">

                        <%
                        String chave = "";
                        String descricao = "";
                        acesso.Sessao sessao = new acesso.Sessao(session);
                        if(sessao.getTipoEntidadeNegocio().equals("FORNECEDOR")
                        ||sessao.getTipoEntidadeNegocio().equals("ATELIER")){
                          chave = sessao.getChave();
                          descricao = query.retorna("SELECT for_razsoc FROM fornecedor WHERE for_codigo = " + chave);
                        }
                        %>

                        <tr class="itemTr">
                          <td class="formLabel">
                            <span class="spamFormLabel">
                              Fornecedor
                            </span>
                          </td>
                          <td class="formField">
                            <%
                            if(chave.equals("")){
                              %>
                              <html:text property="fornecedor" value="<%= chave %>" styleId="fornecedor" onblur="fillFields(0,new Array('fornecedor'),'ConsultaPagamentoFornecedoresActionForm.getFornecedor_razao_social_Ajax',new Array('fornecedor_razao_social'));" styleClass="baseField" size="10"/>
                              <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fornecedor()"  >
                              <%
                            } else {
                              %>
                              <html:text property="fornecedor" value="<%= chave %>" styleId="fornecedor" styleClass="disabled" tabindex="-1" readonly="true" size="10"/>
                              <input type="button" class="lovButton" tabindex="-1" value="..." disabled="true" >
                              <%
                            }
                            %>
                            <script type="text/javascript">
                              function lov_open_fornecedor() {
                                window.open('..//lov/LvFornecedorLov.do?resetfull_action=&returnBlock=0&return0=fornecedor&return1=fornecedor_razao_social','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                              }
                            </script>
                            <span class="spamFormLabel">
                            </span>
                            <%
                            if(chave.equals("")){
                              %>
                              <html:text property="fornecedor_razao_social" styleId="fornecedor_razao_social" styleClass="disabled" tabindex="-1" readonly="true" size="50"/>
                              <%
                            } else {
                              %>
                              <html:text property="fornecedor_razao_social" value="<%= descricao %>" styleId="fornecedor_razao_social" styleClass="disabled" tabindex="-1" readonly="true" size="50"/>
                              <%
                            }
                            %>

                          </td>
                        </tr>

                        <tr class="itemTr">
                          <td class="formLabel">
                            <span class="spamFormLabel">
                              Período Vencimento / Pagamentos Agendados
                            </span>
                          </td>
                          <td class="formField">
                            <html:text property="data_vencimento" styleId="data_vencimento" styleClass="baseField" size="10" maxlength="10"/>
                             
                            <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_vencimento']); cal1.year_scroll = true; cal1.popup();">
                              <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                            </a>
                            <span class="spamFormLabel">
                            </span>
                            <html:text property="data_vencimento_fim" styleId="data_vencimento_fim" styleClass="baseField" size="10" maxlength="10"/>
                             
                            <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_vencimento_fim']); cal1.year_scroll = true; cal1.popup();">
                              <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                            </a>
                          </td>
                        </tr>

                        <tr class="itemTr">
                          <td class="formLabel">
                            <span class="spamFormLabel">
                              Período Pagamento / Pagamentos Efetuados
                            </span>
                          </td>
                          <td class="formField">
                            <html:text property="data_pagamento" styleId="data_pagamento" styleClass="baseField" size="10" maxlength="10"/>
                             
                            <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_pagamento']); cal1.year_scroll = true; cal1.popup();">
                              <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                            </a>
                            <span class="spamFormLabel">
                            </span>
                            <html:text property="data_pagamento_fim" styleId="data_pagamento_fim" styleClass="baseField" size="10" maxlength="10"/>
                             
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

                        <tr class="itemTr">
                          <td class="formLabel">
                            <span class="spamFormLabel">
                              Gerar Planilha
                            </span>
                          </td>
                          <td class="formField">
                            <html:checkbox property="gerar_planilha" styleId="gerar_planilha" styleClass="baseField" value="1"/>
                          </td>
                        </tr>

                        <%
                        if(request.getAttribute("arquivo")!=null) {
                          %>
                          <table style=width:100%;margin-top:10;>
                            <tr>
                              <td class=columHeader style="text-align:center;">
                                <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                                  <bean:message key="report.downloadxls"/>
                                </a>
                              </td>
                            </tr>
                          </table>
                          <%
                        }
                        %>


                        <tr class="itemTr">
                          <td class="formLabel">
                          </td>
                          <td class="formField">
                            <%
                            if(request.getAttribute("mensagem") != null) {
                              %>
                              <div style="color: #ffffff; background-color: red; padding: 10px; text-align: center; font-size: 14px">
                                <%= (String)request.getAttribute("mensagem") %>
                              </div>
                              <%
                            }
                            %>
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

                          </td>
                        </tr>

                      </table>

                      <%
                      if(mostraComunicadoGeral){
                        %>
                      </td>
                      <td style="width: 40%;vertical-align: top; margin-right: 50px">
                        <table width="100%" border="1">
                          <tr>
                            <td style="color: #ffffff; background-color: red; font-size: 16px; font-height: bold; text-align: center; vertical-align: top">
                              Comunicado Geral
                            </td>
                          </tr>
                          <tr>
                            <td style="vertical-align:top; text-align: center; font-size: 14px">
                              <br>
                              <%= comunicadoGeral %>
                              <br>
                              <br>
                            </td>
                          </tr>
                        </table>

                      </td>
                    </tr>

                  </table>
                  <%
                }
                %>

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
                  }
                  %>
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
                          java.lang.String fil_cnpj =  null;
                          int nota =  0;
                          double valor_obrigacao =  0;
                          java.lang.String obrigacao =  null;
                          java.lang.String tipo =  null;
                          java.sql.Date data_emissao =  null;
                          java.sql.Date data_pagamento =  null;
                          java.sql.Date data_vencimento =  null;
                          double saldo_pagar =  0;
                          java.lang.String cnpj =  null;
                          double pago_sem_desc =  0;
                          java.lang.String Abatimentos =  null;
                          java.lang.String fornecedor =  null;
                          java.lang.String sequencia =  null;
                          java.lang.String cd_tipo =  null;
                          int qtd =  0;
                          double sum_valor_obrigacao_0 = 0;
                          double sum_saldo_pagar_0 = 0;
                          double sum_pago_sem_desc_0 = 0;
                          %>

                          <tr class="reportTr">
                            <td class="columnTdHeader" style="text-align:left;" >
                              Filial
                            </td>

                            <td class="columnTdHeader" style="text-align:left;" >
                              CNPJ Filial
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

                            <td class="columnTdHeader" style="text-align:center;" >
                              CNPJ
                            </td>

                            <td class="columnTdHeader" style="text-align:right;" >
                              Valor Pago
                            </td>

                            <td class="columnTdHeader" style="text-align:center;">
                              Abatimentos
                            </td>

                          </tr>

                          <%
                          int i_bl_report_Jw_dom_obri = 0;
                          while (i_bl_report_Jw_dom_obri<res_Jw_dom_obri.size()) {
                            portalbr.dbobj.view.Jw_dom_obri t_jw_dom_obri = (portalbr.dbobj.view.Jw_dom_obri)res_Jw_dom_obri.elementAt(i_bl_report_Jw_dom_obri);
                            fil_razsoc = t_jw_dom_obri.getFil_razsoc()==null?"":t_jw_dom_obri.getFil_razsoc();
                            fil_cnpj = t_jw_dom_obri.getFil_cnpj()==null?"":t_jw_dom_obri.getFil_cnpj();
                            nota = t_jw_dom_obri.getNota();
                            valor_obrigacao = t_jw_dom_obri.getValor_obrigacao();
                            obrigacao = t_jw_dom_obri.getObrigacao()==null?"":t_jw_dom_obri.getObrigacao();
                            tipo = t_jw_dom_obri.getTipo()==null?"":t_jw_dom_obri.getTipo();
                            data_emissao = (java.sql.Date)t_jw_dom_obri.getData_emissao();
                            data_pagamento = (java.sql.Date)t_jw_dom_obri.getData_pagamento();
                            data_vencimento = (java.sql.Date)t_jw_dom_obri.getData_vencimento();
                            saldo_pagar = t_jw_dom_obri.getSaldo_pagar();
                            cnpj = t_jw_dom_obri.getCnpj()==null?"":t_jw_dom_obri.getCnpj();
                            pago_sem_desc = t_jw_dom_obri.getPago_sem_desc();
                            fornecedor = t_jw_dom_obri.getFornecedor()==null?"":t_jw_dom_obri.getFornecedor();
                            sequencia = t_jw_dom_obri.getSequencia()==null?"":t_jw_dom_obri.getSequencia();
                            cd_tipo = t_jw_dom_obri.getCd_tipo()==null?"":t_jw_dom_obri.getCd_tipo();
                            qtd = t_jw_dom_obri.getQtd();
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
                              <td class="reportColumn" style="text-align:left;width:250px;" >
                                <%= fil_razsoc %>
                              </td>

                              <td class="reportColumn" style="text-align:left;" >
                                <%= fil_cnpj %>
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

                              <td class="reportColumn" style="text-align:center;" >
                                <%= cnpj %>
                              </td>

                              <td class="reportColumn" style="text-align:right;" >
                                <%= pago_sem_desc %>
                              </td>

                              <td class="reportColumn" style="text-align:center;">

                                <%
                                if(qtd>0) {
                                  %>
                                  <input type="button" value="Ver" onclick="wopen('../adm/ConsultaPagamentoFornecedores_aForm.do?select_action=&nm_obri=<%= obrigacao %>&cd_enti=<%= fornecedor%>&codi_tipo_ender=<%= sequencia %>&cd_tipo=<%= cd_tipo %>','_blank',800,300)" style="background-color: #C40000;color: white;font-family:verdana;font-size:11px;border-color: black;font-weight: bold;" />
                                  <%
                                }
                                %>

                              </td>

                            </tr>

                            <%
                            i_bl_report_Jw_dom_obri++;
                            if (i_bl_report_Jw_dom_obri<res_Jw_dom_obri.size()) {
                              t_jw_dom_obri = (portalbr.dbobj.view.Jw_dom_obri)res_Jw_dom_obri.elementAt(i_bl_report_Jw_dom_obri);
                              fil_razsoc = t_jw_dom_obri.getFil_razsoc()==null?"":t_jw_dom_obri.getFil_razsoc();
                              fil_cnpj = t_jw_dom_obri.getFil_cnpj()==null?"":t_jw_dom_obri.getFil_cnpj();
                              nota = t_jw_dom_obri.getNota();
                              valor_obrigacao = t_jw_dom_obri.getValor_obrigacao();
                              obrigacao = t_jw_dom_obri.getObrigacao()==null?"":t_jw_dom_obri.getObrigacao();
                              tipo = t_jw_dom_obri.getTipo()==null?"":t_jw_dom_obri.getTipo();
                              data_emissao = (java.sql.Date)t_jw_dom_obri.getData_emissao();
                              data_pagamento = (java.sql.Date)t_jw_dom_obri.getData_pagamento();
                              data_vencimento = (java.sql.Date)t_jw_dom_obri.getData_vencimento();
                              saldo_pagar = t_jw_dom_obri.getSaldo_pagar();
                              cnpj = t_jw_dom_obri.getCnpj()==null?"":t_jw_dom_obri.getCnpj();
                              pago_sem_desc = t_jw_dom_obri.getPago_sem_desc();
                              fornecedor = t_jw_dom_obri.getFornecedor()==null?"":t_jw_dom_obri.getFornecedor();
                              sequencia = t_jw_dom_obri.getSequencia()==null?"":t_jw_dom_obri.getSequencia();
                              cd_tipo = t_jw_dom_obri.getCd_tipo()==null?"":t_jw_dom_obri.getCd_tipo();
                              qtd = t_jw_dom_obri.getQtd();
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
                            <td>
                              &nbsp;
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

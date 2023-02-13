<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.titulo"/>
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
                  <%@ include file="../system/header_sem_ajuda.jsp" %>
                </td>

              </tr>

            </table>

            <html:form action="com/ConsultaPedidos_iForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                boolean mostraComissao = false;
                acesso.Sessao sessao = new acesso.Sessao(session);
                if(sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")
                ||sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")
                ){
                  mostraComissao = true;
                }
                %>
                <%
                portalbr.com.ConsultaPedidos_iActionForm pedi = (portalbr.com.ConsultaPedidos_iActionForm)session.getAttribute("ConsultaPedidos_iActionForm");
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                    <%
                    if(!pedi.getImagem().equalsIgnoreCase("")){
                      %>
                      <img src="../img/<%= pedi.getImagem() %>" width="150" height="35"/>
                      <%
                    }
                    %>
                    <html:hidden property="imagem" styleClass="baseField"/>
                  </td>
                </tr>

                <html:hidden property="p_rep"/>
                <html:hidden property="p_ped_repres"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.ped_beira_rio"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ped_beira_rio" styleClass="disabled" tabindex="-1" readonly="true" size="21" maxlength="21"/>
                    <%
                    portalbr.com.ConsultaPedidos_iActionForm ConsultaPedidos_iActionForm = (portalbr.com.ConsultaPedidos_iActionForm)session.getAttribute("ConsultaPedidos_iActionForm");
                    java.lang.String recolocado = ConsultaPedidos_iActionForm.getRecolocado();


                    if(recolocado.equals("Sim")){
                      %>
                      <span class="spamFormLabel">
                        Recolocado
                      </span>
                      <html:text property="recolocado" styleId="recolocado" style="background-color:#FF0000; font-weight:bold; color:#FFFFFF; text-align:start;" styleClass="disabled"/>
                    </td>
                  </tr>
                  <%
                }else{
                  %>
                  <html:text property="recolocado" styleId="recolocado" style="display:none" styleClass="disabled"/>
                </td>
              </tr>
              <%
            }
            %>
            <html:hidden property="czf_nmro"/>
            <tr class="itemTr">
              <td class="formLabel">
                <span class="spamFormLabel">
                  <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.tipo"/>
                </span>
              </td>
              <td class="formField">
                <html:text property="tipo" styleClass="disabled" tabindex="-1" readonly="true" size="2" maxlength="2"/>
              </td>
            </tr>

            <tr class="itemTr">
              <td class="formLabel">
                <span class="spamFormLabel">
                  <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.ped_repres"/>
                </span>
              </td>
              <td class="formField">
                <html:text property="ped_repres" styleClass="disabled" tabindex="-1" readonly="true" size="7" maxlength="7"/>
              </td>
            </tr>

            <tr class="itemTr">
              <td class="formLabel">
                <span class="spamFormLabel">
                  <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.ped_afv"/>
                </span>
              </td>
              <td class="formField">
                <html:text property="ped_afv" styleClass="disabled" tabindex="-1" readonly="true" size="15" maxlength="15"/>
              </td>
            </tr>

            <tr class="itemTr">
              <td class="formLabel">
                <span class="spamFormLabel">
                  <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.ped_cliente"/>
                </span>
              </td>
              <td class="formField">
                <html:text property="ped_cliente" styleClass="disabled" tabindex="-1" readonly="true" size="25" maxlength="20"/>
              </td>
            </tr>

            <tr class="itemTr">
              <td class="formLabel">
                <span class="spamFormLabel">
                  <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.status"/>
                </span>
              </td>
              <td class="formField">
                <html:text property="st" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10"/>
              </td>
            </tr>

            <tr class="itemTr">
              <td class="formLabel">
                <span class="spamFormLabel">
                  Fora das Normas
                </span>
              </td>
              <td class="formField">
                <html:text property="fora_normas" styleId="fora_normas" styleClass="disabled" tabindex="-1" readonly="true" size="5"/>
              </td>
            </tr>

            <tr class="itemTr">
              <td class="formLabel">
                <span class="spamFormLabel">
                  Frete Isento
                </span>
              </td>
              <td class="formField">
                <html:text property="frete_isento" styleId="frete_isento" styleClass="disabled" tabindex="-1" readonly="true" size="5"/>
              </td>
            </tr>

            <tr>
              <td class="formLabel">
                <span class="spamFormLabel" >
                </span>
              </td>
              <td class="formField">
                <%
                try {
                  portalbr.dbobj.view.Jw_consulta_pedidos_ped_ite t_jw_consulta_pedidos_ped_ite_t = new portalbr.dbobj.view.Jw_consulta_pedidos_ped_ite();
                  java.util.Vector res_Jw_consulta_pedidos_ped_ite_t = (java.util.Vector)session.getAttribute("res_Jw_consulta_pedidos_ped_ite");
                  t_jw_consulta_pedidos_ped_ite_t = (portalbr.dbobj.view.Jw_consulta_pedidos_ped_ite)res_Jw_consulta_pedidos_ped_ite_t.elementAt(0);
                  java.lang.Integer nota_t =  null;
                  nota_t = t_jw_consulta_pedidos_ped_ite_t.getNota();

                  if(nota_t!=null){

                    int counterbl_report_Jw_consulta_pedidos_ped_ite=0;
                    {
                      portalbr.dbobj.view.Jw_consulta_pedidos_ped_ite t_jw_consulta_pedidos_ped_ite = new portalbr.dbobj.view.Jw_consulta_pedidos_ped_ite();
                      java.util.Vector res_Jw_consulta_pedidos_ped_ite = (java.util.Vector)session.getAttribute("res_Jw_consulta_pedidos_ped_ite");
                      if (res_Jw_consulta_pedidos_ped_ite!=null && res_Jw_consulta_pedidos_ped_ite.size()>0) {
                        %>
                        <table id="TRbl_report_Jw_consulta_pedidos_ped_ite" class="reportTable" style="width:400px;" border="1"  >
                          <%
                          java.lang.Integer nota =  null;
                          java.lang.String serie = null;
                          java.lang.String frete = null;
                          java.lang.String fil_filial =  null;
                          java.lang.String emp_empresa =  null;
                          int i_bl_report_Jw_consulta_pedidos_ped_ite = 0;
                          t_jw_consulta_pedidos_ped_ite = (portalbr.dbobj.view.Jw_consulta_pedidos_ped_ite)res_Jw_consulta_pedidos_ped_ite.elementAt(i_bl_report_Jw_consulta_pedidos_ped_ite);
                          nota = t_jw_consulta_pedidos_ped_ite.getNota();
                          serie = t_jw_consulta_pedidos_ped_ite.getSerie();
                          fil_filial = t_jw_consulta_pedidos_ped_ite.getFil_filial()==null?"":t_jw_consulta_pedidos_ped_ite.getFil_filial();
                          emp_empresa = t_jw_consulta_pedidos_ped_ite.getEmp_empresa()==null?"":t_jw_consulta_pedidos_ped_ite.getEmp_empresa();
                          frete = t_jw_consulta_pedidos_ped_ite.getFrete()==null?"":t_jw_consulta_pedidos_ped_ite.getFrete();
                          %>
                          <tr class="reportHeader3" >
                            <td class="columnTdHeader" style="text-align:center;">
                              <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.nota_fiscal"/>
                            </td>
                            <td class="columnTdHeader" style="text-align:center;">
                              Série
                            </td>
                            <td class="columnTdHeader" style="text-align:left;">
                              Frete
                            </td>
                            <%
                            if(request.getParameter("noheader")==null){
                              %>
                              <td class="columnTdHeader" style="text-align:center;" width="1%">
                              </td>
                              <%
                            }
                            %>
                          </tr>
                          <%
                          while (i_bl_report_Jw_consulta_pedidos_ped_ite<res_Jw_consulta_pedidos_ped_ite.size()){
                            counterbl_report_Jw_consulta_pedidos_ped_ite++;
                            String style="";
                            if (!((i_bl_report_Jw_consulta_pedidos_ped_ite%2)!=0)) {
                              style="class=rowColor";
                            } else {
                              style="class=rowBlank";
                            }
                            %>
                            <tr <%= style %> id='TRbl_report_Jw_consulta_pedidos_ped_ite<%=counterbl_report_Jw_consulta_pedidos_ped_ite%>' >
                              <td class="reportColumn" style="text-align:center;">
                                <%= ((nota!=null)?nota.toString():"") %>
                              </td>
                              <td class="reportColumn" style="text-align:center;">
                                <%= ((serie!=null)?serie.toString():"")%>
                              </td>
                              <td class="reportColumn" style="text-align:left;">
                                <%= ((frete!=null)?frete.toString():"") %>
                              </td>

                              <%
                              if(request.getParameter("noheader")==null){
                                %>
                                <td class="reportColumn" style="text-align:left;">
                                  <a href="../com/NotaFiscalForm.do?select_action=&nf_nmro=<%= nota %>&nf_serie=<%= serie %>&fil_filial=<%= fil_filial %>&emp_empresa=<%= emp_empresa %>" target="_self" STYLE="cursor:hand">
                                    <input type="button" value="Ver Nota" onclick="top.location='../com/NotaFiscalForm.do?select_action=&nf_nmro=<%= nota %>&nf_serie=<%= serie %>&fil_filial=<%= fil_filial %>&emp_empresa=<%= emp_empresa %>'" />
                                  </a>
                                </td>
                                <%
                              }
                              %>

                            </tr>
                            <%
                            if (++i_bl_report_Jw_consulta_pedidos_ped_ite >= res_Jw_consulta_pedidos_ped_ite.size()) {
                              break;
                            }
                            t_jw_consulta_pedidos_ped_ite = (portalbr.dbobj.view.Jw_consulta_pedidos_ped_ite)res_Jw_consulta_pedidos_ped_ite.elementAt(i_bl_report_Jw_consulta_pedidos_ped_ite);
                            nota = t_jw_consulta_pedidos_ped_ite.getNota();
                            serie = t_jw_consulta_pedidos_ped_ite.getSerie();
                            fil_filial = t_jw_consulta_pedidos_ped_ite.getFil_filial()==null?"":t_jw_consulta_pedidos_ped_ite.getFil_filial();
                            emp_empresa = t_jw_consulta_pedidos_ped_ite.getEmp_empresa()==null?"":t_jw_consulta_pedidos_ped_ite.getEmp_empresa();
                            frete = t_jw_consulta_pedidos_ped_ite.getFrete()==null?"":t_jw_consulta_pedidos_ped_ite.getFrete();
                          }
                        }
                      }
                      %>
                    </table>

                    <%
                  }
                  %>

                  <%
                } catch (Exception e) {}
                %>


                <%
                if(request.getParameter("noheader")==null){
                  %>
                  <%
                  //Se usuário não é do Tipo: Cliente Mercado Interno então mostra
                  acesso.Usuario us = new acesso.Usuario();
                  us = (acesso.Usuario)session.getAttribute("User");
                  acesso.Sessao ses = new acesso.Sessao(session);
                  if( (!(ses.getTipoEntidadeNegocio().equals("CLIENTE MERCADO INTERNO")))){
                    %>
                    <tr>
                      <td class="formLabel">
                        <span class="spamFormLabel" >
                          <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.situacao_pedido"/>
                        </span>
                      </td>
                      <td class="formField">
                        <html:img src="../img/viewmag.png" onmouseover="this.src='../img/viewmag_s.png'" onmouseout="this.src='../img/viewmag.png'"  style="cursor:hand" onclick="window.open('PedidosSituacoesForm.do?select_action=&pedido_beira_rio='+document.forms[0].ped_beira_rio.value,'_self')"/>
                      </td>
                    </tr>
                    <%
                  }
                  %>

                  <%
                }
                %>

              </table>
              <table class="separatorTable">
                <tr class="separatorTr" align="center">
                  <td colspan="2" class="separatorTd">
                    <font size=3>
                      <b>
                        <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.informacoes"/>
                      </b>
                    </font>
                  </td>
                </tr>
                <tr class="itemTr">
                  <td class="formLabel">
                    <%
                    if(request.getParameter("noheader")==null){
                      %>
                      <html:img src="../img/viewmag.png" onmouseover="this.src='../img/viewmag_s.png'" onmouseout="this.src='../img/viewmag.png'"  style="cursor:hand" onclick="document.forms[0].clientes_action.click();"/>
                      <%
                    }
                    %>

                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.cliente"/>
                    </span>
                  </td>
                  <td  class="formField">
                    <html:text property="cliente" styleClass="disabled" tabindex="-1" readonly="true" size="55" maxlength="55"/>
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.seq"/>
                    </span>
                    <html:text property="seq" style="text-align:center;" styleClass="disabled" tabindex="-1" readonly="true" size="4" maxlength="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.representante"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="rep" styleClass="disabled" tabindex="-1" readonly="true" size="48" maxlength="41"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.transportadora"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="transportadora" styleClass="disabled" tabindex="-1" readonly="true" size="42" maxlength="35"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.consignatario"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="consignatario" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="40"/>
                  </td>
                </tr>

                <html:hidden property="bon2h"/>
                <html:hidden property="bon1h"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.bon1"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="bon1" styleClass="disabled" tabindex="-1" readonly="true" size="7" maxlength="7"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.bon2"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="bon2" styleClass="disabled" tabindex="-1" readonly="true" size="7" maxlength="7"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.desconto_public"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="desconto_public" styleClass="disabled" tabindex="-1" readonly="true" size="7" maxlength="23"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Desconto Indenização
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ped_boni_avaria" styleId="ped_boni_avaria" styleClass="disabled" readonly="true" size="10"/>
                  </td>
                </tr>

                <%
                if(mostraComissao){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Comissão Rep.
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="ped_comr" styleId="ped_comr" styleClass="disabled" tabindex="-1" readonly="true" size="7"/>
                    </td>
                  </tr>
                  <%
                } else {
                  %>

                  <html:hidden property="ped_comr" />

                  <%
                }
                %>



                <html:hidden property="corr"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.emb"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="emb" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.pino_anel"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="pino_anel" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="3"/>
                  </td>
                </tr>

                <%
                if(util.consultas.Usuario.getTipo(session).equals("CLIENTE MERCADO INTERNO") ||
                util.consultas.Usuario.getTipo(session).equals("CLIENTE MERCADO EXTERNO")){
                  %>
                  <html:hidden property="observ"/>
                  <%
                } else {
                  %>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.livro"/>
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="livro" styleClass="disabled" tabindex="-1" readonly="true" size="73" maxlength="73"/>
                    </td>
                  </tr>

                  <%
                }
                %>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.cond_pagamento"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cond_pagamento" styleClass="disabled" tabindex="-1" readonly="true" size="25" maxlength="25"/>
                  </td>
                </tr>

                <html:hidden property="dt_entrega"/>
                <html:hidden property="ped_data_faturamento"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.dt_digitacao"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_digitacao" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data de Embarque
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="previsao_faturamento" styleId="previsao_faturamento" styleClass="disabled" tabindex="-1" readonly="true" size="25"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Previsão Faturamento
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="previsao_fat" styleId="previsao_fat" styleClass="disabled" tabindex="-1" readonly="true" size="25"/>
                  </td>
                </tr>

                <%
                if(!(util.consultas.Usuario.getTipo(session).equals("REPRESENTANTE COMERCIAL") ||
                util.consultas.Usuario.getTipo(session).equals("CLIENTE MERCADO INTERNO") ||
                util.consultas.Usuario.getTipo(session).equals("REPRESENTANTE EXPORTACAO") ||
                util.consultas.Usuario.getTipo(session).equals("CLIENTE MERCADO EXTERNO") ||
                util.consultas.Usuario.getTipo(session).equals("TRANSPORTADORA") ||
                util.consultas.Usuario.getTipo(session).equals("FORNECEDOR"))){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.observ"/>
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="observ" styleClass="disabled" tabindex="-1" readonly="true" size="130" maxlength="130"/>
                    </td>
                  </tr>
                  <%
                } else {
                  %>
                  <html:hidden property="observ"/>
                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Invoice
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ped_invoice" styleId="ped_invoice" styleClass="disabled" tabindex="-1" readonly="true" size="12"/>
                  </td>
                </tr>

                <%
                if(util.consultas.Usuario.getTipo(session).equals("AREAS") || util.consultas.Usuario.getTipo(session).equals("REGIONAL DE VENDA") ||
                user.isSuperUsuario()){
                  %>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Desc. Com. Original
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="desc_com_original" styleClass="disabled" tabindex="-1" readonly="true" size="7" maxlength="7"/>
                    </td>
                  </tr>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Desc. Prom. Original
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="desc_prom_original" styleClass="disabled" tabindex="-1" readonly="true" size="7" maxlength="7"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Livro Original
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="livro_original" styleClass="disabled" tabindex="-1" readonly="true" size="7" maxlength="7"/>
                    </td>
                  </tr>

                  <%
                }
                %>
              </table>
              <table class="itemTable" style='width:99%;'>
                <html:hidden property="pedido_beira_rio"/>
                <html:hidden property="fil_filial"/>
                <html:hidden property="moeda"/>
                <html:hidden property="codigo_embalagem"/>
                <html:hidden property="codigo_corrugado"/>
                <html:hidden property="frete"/>
                <html:hidden property="item"/>
                <html:hidden property="remove"/>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit value="Cadastro Clientes" styleClass="myhidden" property="clientes_action">
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="refresh_action">
                      <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["imagem"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <style>
              @media print { .columnTdHeader { font-size: 9px; text-transform: capitalize; font-family: Arial; } .reportColumn { font-size: 9px; text-transform: capitalize; font-family: Arial; } }
            </style>


            <%
            boolean liberaEdicaoDistribuicao = false;
            if(session.getAttribute("liberaEdicaoDistribuicao")!=null){
              liberaEdicaoDistribuicao = true;
            }
            boolean liberaDistribuicaoUsuario = true;
            acesso.Sessao sessao = new acesso.Sessao(session);
            if(sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")
            ||sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")
            ||sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")
            ||user.isSuperUsuario()
            ){
              liberaDistribuicaoUsuario = true;
            }
            portalbr.com.ConsultaPedidos_iActionForm ConsultaPedidos_iActionForm = (portalbr.com.ConsultaPedidos_iActionForm)session.getAttribute("ConsultaPedidos_iActionForm");
            %>

            <%
            if(liberaDistribuicaoUsuario && liberaEdicaoDistribuicao){
              %>
              <table id="TRbl_report_Jw_consulta_pedidos_grade" class="reportTable" style=width:99%; border=0 >
                <tr>
                  <td style="text-align: right">
                    <input type="button" value="Distribuição única de caixas" onclick="wopen('../com/ConsultaPedidos_idistuForm.do?select_action=&ped_nmro=<%= ConsultaPedidos_iActionForm.getPed_beira_rio() %>','_blank',600,300)"/>
                  </td>
                </tr>
              </table>
              <%
            }
            %>


            <div style="font-size: 16px !important">
              <table id="TRbl_report_Jw_consulta_pedidos_grade" class="reportTable" style=width:99%;  border=1; frame=box>
                <%
                util.consultas.Parametros pr = new util.consultas.Parametros();
                int counterbl_report_Jw_consulta_pedidos_grade=0;
                int x=0;
                double total_geral = 0;
                double total_pares = 0;
                double total_bon1  = 0;
                double total_bon2  = 0;
                double bon1 = 0;
                double bon2 = 0;
                java.lang.String numero1 =  null;
                java.lang.Integer quantidade1 =  null;


                double valor_liquido_nf = 0.0;
                String diretorio_imagem = pr.retornaParametro("diretorio_imagens_ranking");
                portalbr.dbobj.view.Jw_saldo_estoque_grades_g t_jw_saldo_estoque_grades_g = new portalbr.dbobj.view.Jw_saldo_estoque_grades_g();
                java.util.Vector res_Jw_consulta_pedidos_grade = (java.util.Vector)session.getAttribute("res_Jw_consulta_pedidos_grade");

                if(ConsultaPedidos_iActionForm.getPed_beira_rio()!=null){
                  {

                    portalbr.dbobj.view.Jw_consulta_pedidos_grade t_jw_consulta_pedidos_grade = new portalbr.dbobj.view.Jw_consulta_pedidos_grade();
                    java.util.Vector res_Jw_saldo_estoque_grades_g = null;



                    if (res_Jw_consulta_pedidos_grade!=null && res_Jw_consulta_pedidos_grade.size()>0) {
                      Double ped_nmro              =  0d;
                      java.lang.String filial_pedido = null;
                      double quant                 =  0;
                      java.lang.Integer grade      =  null;
                      java.lang.Integer item       =  null;
                      java.lang.String refer       =  null;
                      java.lang.String imagem      =  null;
                      java.lang.String descricao   =  null;
                      java.lang.String cor         =  null;
                      java.lang.String cabedal     =  null;
                      java.lang.String ncm         =  null;
                      java.lang.Double preco       =  null;
                      java.lang.Double item_preco  =  null;
                      java.lang.Double total       =  null;
                      java.lang.Integer lin_cdgo   =  null;
                      java.lang.Integer ref_cdgo   =  null;
                      java.lang.Integer les_codigo =  null;
                      java.lang.Integer tes_codigo = null;
                      java.lang.Integer codigo_corrugado = null;
                      java.lang.String descricao_corrugado = null;
                      java.lang.Double preco_pdv   = null;
                      java.lang.String aceita_descontos = null;
                      java.lang.String ite_situ = null;
                      java.lang.String distribuicao = null;
                      java.lang.String labelBotaoDistribuicao = null;
                      int i_bl_report_Jw_consulta_pedidos_grade = 0;

                      t_jw_consulta_pedidos_grade = (portalbr.dbobj.view.Jw_consulta_pedidos_grade)res_Jw_consulta_pedidos_grade.elementAt(i_bl_report_Jw_consulta_pedidos_grade);
                      ped_nmro     = t_jw_consulta_pedidos_grade.getPed_nmro();
                      filial_pedido = t_jw_consulta_pedidos_grade.getFilial_pedido()==null?"":t_jw_consulta_pedidos_grade.getFilial_pedido();
                      grade        = t_jw_consulta_pedidos_grade.getGrade();
                      item         = t_jw_consulta_pedidos_grade.getItem();
                      refer        = t_jw_consulta_pedidos_grade.getRefer()==null?"":t_jw_consulta_pedidos_grade.getRefer();
                      descricao    = t_jw_consulta_pedidos_grade.getDescricao()==null?"":t_jw_consulta_pedidos_grade.getDescricao();
                      cor          = t_jw_consulta_pedidos_grade.getCor()==null?"":t_jw_consulta_pedidos_grade.getCor();
                      cabedal      = t_jw_consulta_pedidos_grade.getCabedal()==null?"":t_jw_consulta_pedidos_grade.getCabedal();
                      ncm          = t_jw_consulta_pedidos_grade.getNcm()==null?"":t_jw_consulta_pedidos_grade.getNcm();
                      aceita_descontos = t_jw_consulta_pedidos_grade.getAceita_descontos()==null?"":t_jw_consulta_pedidos_grade.getAceita_descontos();
                      quant        = t_jw_consulta_pedidos_grade.getQuant();
                      preco        = t_jw_consulta_pedidos_grade.getPreco();
                      item_preco   = t_jw_consulta_pedidos_grade.getItem_preco()==null?0.00:t_jw_consulta_pedidos_grade.getItem_preco();
                      imagem       = t_jw_consulta_pedidos_grade.getImagem()==null?"":t_jw_consulta_pedidos_grade.getImagem();
                      total        = t_jw_consulta_pedidos_grade.getTotal();
                      lin_cdgo     = t_jw_consulta_pedidos_grade.getLin_cdgo();
                      ref_cdgo     = t_jw_consulta_pedidos_grade.getRef_cdgo();
                      les_codigo   = t_jw_consulta_pedidos_grade.getLes_codigo();
                      tes_codigo   = t_jw_consulta_pedidos_grade.getTes_codigo();
                      codigo_corrugado = t_jw_consulta_pedidos_grade.getCodigo_corrugado();
                      descricao_corrugado = t_jw_consulta_pedidos_grade.getDescricao_corrugado()==null?"":t_jw_consulta_pedidos_grade.getDescricao_corrugado();
                      preco_pdv = t_jw_consulta_pedidos_grade.getPreco_pdv()==null?0.00:t_jw_consulta_pedidos_grade.getPreco_pdv();
                      ite_situ     = t_jw_consulta_pedidos_grade.getIte_situ()==null?"":t_jw_consulta_pedidos_grade.getIte_situ();
                      distribuicao = t_jw_consulta_pedidos_grade.getDistribuicao()==null?"":t_jw_consulta_pedidos_grade.getDistribuicao();
                      if(aceita_descontos.equalsIgnoreCase("S")){
                        aceita_descontos = "Sim";
                      } else {
                        aceita_descontos = "Não";
                      }
                      if(true){
                        //    if(distribuicao.equalsIgnoreCase("S")){
                          //       if(liberaEdicaoDistribuicao){
                            if(true) {
                              labelBotaoDistribuicao = "Ver/Alterar";
                            } else {
                              labelBotaoDistribuicao = "Ver Distribuição";
                            }
                          } else {
                            labelBotaoDistribuicao = "Distribuir";
                          }
                          total_pares += quant;
                          java.lang.Integer b0_grade =  null;
                          while (i_bl_report_Jw_consulta_pedidos_grade<res_Jw_consulta_pedidos_grade.size()){
                            counterbl_report_Jw_consulta_pedidos_grade++;

                            b0_grade = grade;
                            //------------------------------
                            {
                              com.egen.util.jdbc.JdbcUtil j2 = null;
                              try {
                                j2 = new com.egen.util.jdbc.JdbcUtil();
                                StringBuilder sb = new StringBuilder();
                                sb.append(" SELECT qtp_nume numero ");
                                sb.append("      , qtp_pars quantidade ");
                                sb.append("   FROM qtd_prg ");
                                sb.append("  WHERE ped_nmro = ").append(ped_nmro);
                                sb.append("    AND ite_seqn = ").append(item);

                                res_Jw_saldo_estoque_grades_g = j2.select(t_jw_saldo_estoque_grades_g,
                                sb.toString(),
                                null);

                              } catch (Exception e){
                              } finally {
                                if(j2!=null) {
                                  j2.close();
                                  j2 = null;
                                }
                              }
                            }
                            %>

                            <%
                            while (i_bl_report_Jw_consulta_pedidos_grade<res_Jw_consulta_pedidos_grade.size() &&  (b0_grade==null?0:b0_grade.intValue())==(grade==null?0:grade.intValue())){
                              counterbl_report_Jw_consulta_pedidos_grade++;
                              %>
                              <tr class="reportHeader" >
                                <%
                                if((session.getAttribute("mostrar_imagem")+"").equals("S")) {
                                  %>
                                  <td class="columnTdHeader" style="text-align:center;">
                                  </td>
                                  <%
                                }
                                %>
                                <td class="columnTdHeader" style="text-align:center;">
                                  <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.item"/>
                                </td>

                                <%
                                if(request.getParameter("descontos")!=null){
                                  %>
                                  <td class="columnTdHeader" style="text-align: center;">
                                    Aceita
                                    <br>
                                    Descontos
                                  </td>
                                  <%
                                }
                                %>

                                <td class="columnTdHeader" style="text-align: left;">
                                  Sit.
                                </td>

                                <td class="columnTdHeader" style="text-align:center;">
                                  <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.filial_pedido"/>
                                </td>
                                <td class="columnTdHeader" style="text-align:center;">
                                  Local
                                </td>
                                <td class="columnTdHeader" style="text-align:center;">
                                  Tipo
                                </td>
                                <td class="columnTdHeader" style="text-align: center;">
                                  <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.refer"/>
                                </td>
                                <td class="columnTdHeader" style="text-align:left;">
                                  <div id="fonte">
                                    <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.descricao"/>
                                  </div>
                                </td>
                                <td class="columnTdHeader" style="text-align:left;">
                                  <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.cabedal"/>
                                </td>
                                <td class="columnTdHeader" style="text-align:left;">
                                  Corrugado
                                </td>
                                <td class="columnTdHeader" style="text-align:left;">
                                  <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.cor"/>
                                </td>
                                <td class="columnTdHeader" style="text-align:left;">
                                  NCM
                                </td>
                                <td class="columnTdHeader" style="text-align:center;">
                                  <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.grade"/>
                                </td>


                                <%
                                for(x=0;x<res_Jw_saldo_estoque_grades_g.size();x++){

                                  t_jw_saldo_estoque_grades_g = (portalbr.dbobj.view.Jw_saldo_estoque_grades_g)res_Jw_saldo_estoque_grades_g.elementAt(x);
                                  numero1 = t_jw_saldo_estoque_grades_g.getNumero()==null?"":t_jw_saldo_estoque_grades_g.getNumero();
                                  quantidade1 = t_jw_saldo_estoque_grades_g.getQuantidade();
                                  %>

                                  <td class="columnTdHeader" style="text-align:center;">
                                    <%= numero1 %>
                                  </td>

                                  <%
                                }
                                %>

                                <td class="columnTdHeader" style="text-align:right;" colspan=<%= 10-res_Jw_saldo_estoque_grades_g.size() %>>
                                  <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.quantidade"/>
                                </td>
                                <td class="columnTdHeader" style="text-align:right;">
                                  <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.preco"/>
                                </td>
                                <td class="columnTdHeader" style="text-align:right;">
                                  Preço Venda
                                </td>
                                <td class="columnTdHeader" style="text-align:right;">
                                  Preço PDV
                                </td>
                                <td class="columnTdHeader" style="text-align:right;">
                                  <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.total"/>
                                </td>

                                <%
                                if(liberaDistribuicaoUsuario){
                                  %>
                                  <td class="columnTdHeader" style="text-align:Center;">
                                    Distribuição
                                  </td>
                                  <%
                                }
                                %>
                              </tr>
                              <%
                              String style="";
                              if (!((i_bl_report_Jw_consulta_pedidos_grade%2)!=0)) {
                                style="class=rowColor";
                              } else {
                                style="class=rowBlank";
                              }
                              if(request.getParameter("descontos")!=null){
                                if(aceita_descontos.equalsIgnoreCase("Não")){
                                  style="class=rowRed";
                                }
                              }
                              %>
                              <tr <%= style %> id='TRbl_report_Jw_consulta_pedidos_grade<%=counterbl_report_Jw_consulta_pedidos_grade%>' >
                                <%
                                if((session.getAttribute("mostrar_imagem")+"").equals("S")) {
                                  %>
                                  <td class="reportColumn" style="text-align:center;">
                                    <img src="<%= diretorio_imagem+imagem %>" width=67 height=37>
                                  </td>
                                  <%
                                }
                                %>
                                <td class="reportColumn" style="text-align:center; font-size: 10px">
                                  <%= item %>
                                </td>

                                <%
                                if(request.getParameter("descontos")!=null){
                                  %>
                                  <td class="reportColumn" style="text-align: center; font-size: 10px">
                                    <%= aceita_descontos %>
                                  </td>
                                  <%
                                }
                                %>


                                <td class="reportColumn" style="text-align: left; font-size: 10px">
                                  <%= ite_situ %>
                                </td>
                                <td class="reportColumn" style="text-align:center; font-size: 10px">
                                  <%= filial_pedido %>
                                </td>
                                <td class="reportColumn" style="text-align:center; font-size: 10px">
                                  <%= les_codigo != null ? les_codigo : "" %>
                                </td>
                                <td class="reportColumn" style="text-align:center; font-size: 10px">
                                  <%= tes_codigo != null ? tes_codigo : "" %>
                                </div>
                                <td class="reportColumn" style="text-align: center; font-size: 10px">
                                  <%= refer %>
                                  <br>
                                  <input type="button" value="Detalhes" style="font-size: 10px" onclick="wopen('../com/ConsultaPedidos_idForm.do?select_action=&codigo_corrugado=<%= ConsultaPedidos_iActionForm.getCodigo_corrugado()  %>&codigo_embalagem=<%= ConsultaPedidos_iActionForm.getCodigo_embalagem()%>&lin_cdgo=<%= lin_cdgo %>&ref_cdgo=<%= ref_cdgo %>','_blank',700,500)">
                                </td>
                                <td class="reportColumn" style="text-align:left; font-size: 10px">
                                  <%= descricao %>
                                </td>
                                <td class="reportColumn" style="text-align:left; font-size: 10px">
                                  <%= cabedal %>
                                </td>
                                <td class="reportColumn" style="text-align:left; font-size: 10px">
                                  <%= codigo_corrugado %>
                                  -
                                  <%= descricao_corrugado %>
                                </td>
                                <!--     <td class="columnTdHeader" style="text-align:left;">-->
                                <td class="reportColumn" style="text-align:left; font-size: 10px">
                                  <%= cor %>
                                </td>
                                <td class="reportColumn" style="text-align:left; font-size: 10px">
                                  <%= ncm %>
                                </td>
                                <!--     <td class="columnTdHeader" style="text-align:center;">-->
                                <td class="reportColumn" style="text-align:center; font-size: 10px">
                                  <%= grade %>
                                </td>
                                <%
                                for(x=0;x<res_Jw_saldo_estoque_grades_g.size();x++){

                                  t_jw_saldo_estoque_grades_g = (portalbr.dbobj.view.Jw_saldo_estoque_grades_g)res_Jw_saldo_estoque_grades_g.elementAt(x);
                                  numero1 = t_jw_saldo_estoque_grades_g.getNumero()==null?"":t_jw_saldo_estoque_grades_g.getNumero();
                                  quantidade1 = t_jw_saldo_estoque_grades_g.getQuantidade();
                                  %>

                                  <td class="reportColumn" style="text-align:center;">
                                    <%= com.egen.util.text.FormatNumber.format(quantidade1, "0") %>
                                  </td>

                                  <%
                                }
                                %>

                                <td class="reportColumn" style="text-align:right; font-size: 10px" colspan=<%= 10-res_Jw_saldo_estoque_grades_g.size() %> >
                                  <%= com.egen.util.text.FormatNumber.format(quant, "0") %>
                                </td>
                                <td class="reportColumn" style="text-align:right; font-size: 10px">
                                  <%= com.egen.util.text.FormatNumber.format(preco, "##,##0.00") %>
                                </td>
                                <td class="reportColumn" style="text-align:right; font-size: 10px">
                                  <%= com.egen.util.text.FormatNumber.format(item_preco, "##,##0.00") %>
                                </td>
                                <td class="reportColumn" style="text-align:right; font-size: 10px">
                                  <%= com.egen.util.text.FormatNumber.format(preco_pdv, "##,##0.00") %>
                                </td>
                                <td class="reportColumn" style="text-align:right; font-size: 10px">
                                  <%= com.egen.util.text.FormatNumber.format(total, "##,##0.00") %>
                                </td>

                                <%
                                if(liberaDistribuicaoUsuario){
                                  %>
                                  <td class="reportColumn" style="text-align:center;">
                                    <%
                                    if((!liberaEdicaoDistribuicao && distribuicao.equalsIgnoreCase("S"))
                                    || (liberaEdicaoDistribuicao)){
                                      %>
                                      <input type="button" value="<%= labelBotaoDistribuicao %>" style="font-size: 10px" onclick="wopen('../com/ConsultaPedidos_idistForm.do?select_action=&ped_nmro=<%= ped_nmro.intValue() %>&item=<%= item %>','_blank',500,400)">
                                      <%
                                    }
                                    %>
                                    <%
                                    if(distribuicao.equalsIgnoreCase("S") && liberaEdicaoDistribuicao){
                                      %>
                                      <a href="../com/ConsultaPedidos_iForm.do?select_action=&pedido_beira_rio=<%= ped_nmro.intValue() %>&item=<%= item%>&remove=s" target="_self" STYLE="cursor:hand" onclick="return confirmSubmit('');">
                                        <input type="button" value="Remover" />
                                      </a>
                                      <%
                                    }
                                    %>
                                  </td>
                                  <%
                                }
                                %>

                              </tr>
                              <%
                              total_geral += Double.parseDouble(total+"");
                              if (++i_bl_report_Jw_consulta_pedidos_grade >= res_Jw_consulta_pedidos_grade.size()) {
                                break;
                              }
                              t_jw_consulta_pedidos_grade = (portalbr.dbobj.view.Jw_consulta_pedidos_grade)res_Jw_consulta_pedidos_grade.elementAt(i_bl_report_Jw_consulta_pedidos_grade);
                              ped_nmro     = t_jw_consulta_pedidos_grade.getPed_nmro();
                              filial_pedido = t_jw_consulta_pedidos_grade.getFilial_pedido()==null?"":t_jw_consulta_pedidos_grade.getFilial_pedido();
                              grade        = t_jw_consulta_pedidos_grade.getGrade();
                              item         = t_jw_consulta_pedidos_grade.getItem();
                              refer        = t_jw_consulta_pedidos_grade.getRefer()==null?"":t_jw_consulta_pedidos_grade.getRefer();
                              descricao    = t_jw_consulta_pedidos_grade.getDescricao()==null?"":t_jw_consulta_pedidos_grade.getDescricao();
                              cor          = t_jw_consulta_pedidos_grade.getCor()==null?"":t_jw_consulta_pedidos_grade.getCor();
                              cabedal      = t_jw_consulta_pedidos_grade.getCabedal()==null?"":t_jw_consulta_pedidos_grade.getCabedal();
                              ncm          = t_jw_consulta_pedidos_grade.getNcm()==null?"":t_jw_consulta_pedidos_grade.getNcm();
                              aceita_descontos = t_jw_consulta_pedidos_grade.getAceita_descontos()==null?"":t_jw_consulta_pedidos_grade.getAceita_descontos();
                              quant        = t_jw_consulta_pedidos_grade.getQuant();
                              preco        = t_jw_consulta_pedidos_grade.getPreco();
                              item_preco   = t_jw_consulta_pedidos_grade.getItem_preco()==null?0.00:t_jw_consulta_pedidos_grade.getItem_preco();
                              total        = t_jw_consulta_pedidos_grade.getTotal();
                              imagem       = t_jw_consulta_pedidos_grade.getImagem()==null?"":t_jw_consulta_pedidos_grade.getImagem();
                              lin_cdgo     = t_jw_consulta_pedidos_grade.getLin_cdgo();
                              ref_cdgo     = t_jw_consulta_pedidos_grade.getRef_cdgo();
                              les_codigo   = t_jw_consulta_pedidos_grade.getLes_codigo();
                              tes_codigo   = t_jw_consulta_pedidos_grade.getTes_codigo();
                              codigo_corrugado = t_jw_consulta_pedidos_grade.getCodigo_corrugado();
                              descricao_corrugado = t_jw_consulta_pedidos_grade.getDescricao_corrugado()==null?"":t_jw_consulta_pedidos_grade.getDescricao_corrugado();
                              preco_pdv = t_jw_consulta_pedidos_grade.getPreco_pdv()==null?0.00:t_jw_consulta_pedidos_grade.getPreco_pdv();
                              ite_situ     = t_jw_consulta_pedidos_grade.getIte_situ()==null?"":t_jw_consulta_pedidos_grade.getIte_situ();
                              distribuicao = t_jw_consulta_pedidos_grade.getDistribuicao()==null?"":t_jw_consulta_pedidos_grade.getDistribuicao();
                              if(aceita_descontos.equalsIgnoreCase("S")){
                                aceita_descontos = "Sim";
                              } else {
                                aceita_descontos = "Não";
                              }
                              if(distribuicao.equalsIgnoreCase("S")){
                                if(liberaEdicaoDistribuicao){
                                  labelBotaoDistribuicao = "Ver/Alterar";
                                } else {
                                  labelBotaoDistribuicao = "Ver Distribuição";
                                }
                              } else {
                                labelBotaoDistribuicao = "Distribuir";
                              }
                              total_pares += quant;
                              //------------------------------
                              {
                                com.egen.util.jdbc.JdbcUtil j2 = null;
                                try {
                                  j2 = new com.egen.util.jdbc.JdbcUtil();
                                  StringBuilder sb2 = new StringBuilder();
                                  sb2.append(" SELECT qtp_nume numero ");
                                  sb2.append("      , qtp_pars quantidade ");
                                  sb2.append("   FROM qtd_prg ");
                                  sb2.append("  WHERE ped_nmro = ").append(ped_nmro);
                                  sb2.append("    AND ite_seqn = ").append(item);

                                  res_Jw_saldo_estoque_grades_g = j2.select(t_jw_saldo_estoque_grades_g,
                                  sb2.toString(),
                                  null);

                                } catch (Exception e){
                                } finally {
                                  if(j2!=null) {
                                    j2.close();
                                    j2 = null;
                                  }
                                }
                              }

                              //----------------------------------------------------------------------------------------
                            }
                          }
                        }
                      }


                      total_bon1 = total_geral-(total_geral*((double)Double.parseDouble(ConsultaPedidos_iActionForm.getBon1h()))/100);
                      total_bon2 = 100-(100*(0/100));
                      total_bon2 = total_bon1-(total_bon1*(Double.parseDouble(ConsultaPedidos_iActionForm.getBon2h()))/100);
                      util.consultas.Query query = new util.consultas.Query();
                      String valorLiquido = query.retorna("SELECT fct_valor_pedido("+ConsultaPedidos_iActionForm.getPed_beira_rio()+") FROM dual");
                      String valorNota = query.retorna("SELECT n.nfs_vltot FROM nf_saida n WHERE n.ped_nmro = "+ConsultaPedidos_iActionForm.getPed_beira_rio()+" AND n.stat_codigo IN (4, 8) AND rownum = 1");

                      if((!valorLiquido.equals("")) && (!valorLiquido.equals("null"))){
                        valor_liquido_nf  = Double.parseDouble(valorLiquido);
                      } else {
                        valor_liquido_nf  = total_bon2;
                      }
                      %>
                    </table>
                  </div>
                  <table border=0 width="99%">
                    <tr>
                      <td width="15%">
                        <b>
                          <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.total.pares"/>
                        </b>
                      </td>
                      <td width="80%">
                        <%= com.egen.util.text.FormatNumber.format(total_pares, "0") %>
                      </td>
                    </tr>
                    <tr>
                      <td width="15%">
                        <b>
                          <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.total.bruto"/>
                        </b>
                      </td>
                      <td width="80%">
                        <%= ConsultaPedidos_iActionForm.getMoeda() %>
                        <%= com.egen.util.text.FormatNumber.format(total_geral, "##,##0.00") %>
                      </td>
                    </tr>
                    <tr>
                      <td width="15%">
                        <b>
                          <bean:message bundle="ComercialResources" key="ConsultaPedidos_i.total.liquido"/>
                        </b>
                      </td>
                      <td width="80%">
                        <%= ConsultaPedidos_iActionForm.getMoeda() %>
                        <%= com.egen.util.text.FormatNumber.format(valor_liquido_nf , "##,##0.00")  %>
                      </td>
                    </tr>
                    <%
                    if(!valorNota.equals("")) {
                      %>
                      <tr>
                        <td width="15%">
                          <b>
                            Valor Nota Fiscal :
                          </b>
                        </td>
                        <td width="80%">
                          <%= ConsultaPedidos_iActionForm.getMoeda() %>
                          <%= com.egen.util.text.FormatNumber.format(Double.parseDouble(valorNota) , "##,##0.00")  %>
                        </td>
                      </tr>
                      <%
                    }
                    %>

                    <%
                  }
                  %>


                </table>
                <html:form action="com/ConsultaPedidos_iForm.do" method="post" styleClass="baseForm">
                  <table class="buttonTable" style='width:;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:submit accesskey="b" styleClass="myhidden" property="back_action">
                          <bean:message bundle="ApplicationResources" key="jsp.back"/>
                        </html:submit>
                        <%
                        if(request.getParameter("noheader")==null){
                          %>
                          <html:button accesskey="b" onclick="history.go(-1);" styleClass="baseButton" property="back1_action">
                            <bean:message bundle="ApplicationResources" key="jsp.back"/>
                          </html:button>
                          <%
                        }
                        %>
                        <%
                        if(request.getParameter("noheader")!=null){
                          %>
                          <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                            <bean:message bundle="ApplicationResources" key="jsp.close"/>
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta de Envio/Retorno Talões - Atelier Interno
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(106)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_relatorio_atelier_pre_envio_quarterizado = (java.util.Vector)session.getAttribute("res_Jw_relatorio_atelier_pre_envio_quarterizado");
              %>

              <form  name="bl_report_Jw_relatorio_atelier_pre_envio_quarterizado" id="bl_report_Jw_relatorio_atelier_pre_envio_quarterizado" class="baseForm" method="post" >
                <%
                if (res_Jw_relatorio_atelier_pre_envio_quarterizado!=null && res_Jw_relatorio_atelier_pre_envio_quarterizado.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_relatorio_atelier_pre_envio_quarterizado"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Integer fornecedor_codigo =  null;
                    java.lang.Integer fornecedor_codigo_quarterizado =  null;
                    java.lang.Integer fen_seq_quarterizado =  null;
                    java.lang.String fornecedor_razsoc =  null;
                    java.lang.Integer pro_numero =  null;
                    java.lang.String pro_nome =  null;
                    java.sql.Timestamp data_envio =  null;
                    java.sql.Timestamp data_retorno =  null;
                    java.lang.Integer rem_nro =  null;
                    java.lang.Integer tal_nro =  null;
                    java.lang.String status =  null;
                    java.lang.String status_descricao =  null;
                    java.lang.String usuario_inclusao =  null;
                    java.lang.String usuario_alteracao =  null;
                    java.sql.Timestamp data_ordenacao =  null;
                    java.lang.Integer tal_parbom =  null;
                    java.lang.Integer tal_parrej =  null;
                    java.lang.Integer lin_cdgo =  null;
                    java.lang.Integer ref_cdgo =  null;
                    java.lang.Integer cab_cdgo =  null;
                    java.lang.String cab_desc =  null;
                    java.lang.Integer cor_cdgo =  null;
                    java.lang.String cor_desc =  null;
                    java.lang.Integer tal_pares =  null;
                    java.sql.Timestamp data_corte =  null;
                    java.sql.Timestamp data_cost =  null;
                    java.sql.Timestamp data_mont =  null;
                    java.lang.String excluir =  null;
                    String _b0_control = "__";
                    String _b1_control = "__";
                    int sum_tal_pares_1 = 0;
                    int i_bl_report_Jw_relatorio_atelier_pre_envio_quarterizado = 0;
                    while (i_bl_report_Jw_relatorio_atelier_pre_envio_quarterizado<res_Jw_relatorio_atelier_pre_envio_quarterizado.size()) {
                      portalbr.dbobj.view.Jw_relatorio_atelier_pre_envio_quarterizado t_jw_relatorio_atelier_pre_envio_quarterizado = (portalbr.dbobj.view.Jw_relatorio_atelier_pre_envio_quarterizado)res_Jw_relatorio_atelier_pre_envio_quarterizado.elementAt(i_bl_report_Jw_relatorio_atelier_pre_envio_quarterizado);
                      fornecedor_codigo = t_jw_relatorio_atelier_pre_envio_quarterizado.getFornecedor_codigo();
                      fornecedor_codigo_quarterizado = t_jw_relatorio_atelier_pre_envio_quarterizado.getFornecedor_codigo_quarterizado();
                      fen_seq_quarterizado = t_jw_relatorio_atelier_pre_envio_quarterizado.getFen_seq_quarterizado();
                      fornecedor_razsoc = t_jw_relatorio_atelier_pre_envio_quarterizado.getFornecedor_razsoc()==null?"":t_jw_relatorio_atelier_pre_envio_quarterizado.getFornecedor_razsoc();
                      pro_numero = t_jw_relatorio_atelier_pre_envio_quarterizado.getPro_numero();
                      pro_nome = t_jw_relatorio_atelier_pre_envio_quarterizado.getPro_nome()==null?"":t_jw_relatorio_atelier_pre_envio_quarterizado.getPro_nome();
                      data_envio = (java.sql.Timestamp)t_jw_relatorio_atelier_pre_envio_quarterizado.getData_envio();
                      data_retorno = (java.sql.Timestamp)t_jw_relatorio_atelier_pre_envio_quarterizado.getData_retorno();
                      rem_nro = t_jw_relatorio_atelier_pre_envio_quarterizado.getRem_nro();
                      tal_nro = t_jw_relatorio_atelier_pre_envio_quarterizado.getTal_nro();
                      status = t_jw_relatorio_atelier_pre_envio_quarterizado.getStatus()==null?"":t_jw_relatorio_atelier_pre_envio_quarterizado.getStatus();
                      status_descricao = t_jw_relatorio_atelier_pre_envio_quarterizado.getStatus_descricao()==null?"":t_jw_relatorio_atelier_pre_envio_quarterizado.getStatus_descricao();
                      usuario_inclusao = t_jw_relatorio_atelier_pre_envio_quarterizado.getUsuario_inclusao()==null?"":t_jw_relatorio_atelier_pre_envio_quarterizado.getUsuario_inclusao();
                      usuario_alteracao = t_jw_relatorio_atelier_pre_envio_quarterizado.getUsuario_alteracao()==null?"":t_jw_relatorio_atelier_pre_envio_quarterizado.getUsuario_alteracao();
                      data_ordenacao = (java.sql.Timestamp)t_jw_relatorio_atelier_pre_envio_quarterizado.getData_ordenacao();
                      tal_parbom = t_jw_relatorio_atelier_pre_envio_quarterizado.getTal_parbom();
                      tal_parrej = t_jw_relatorio_atelier_pre_envio_quarterizado.getTal_parrej();
                      lin_cdgo = t_jw_relatorio_atelier_pre_envio_quarterizado.getLin_cdgo();
                      ref_cdgo = t_jw_relatorio_atelier_pre_envio_quarterizado.getRef_cdgo();
                      cab_cdgo = t_jw_relatorio_atelier_pre_envio_quarterizado.getCab_cdgo();
                      cab_desc = t_jw_relatorio_atelier_pre_envio_quarterizado.getCab_desc()==null?"":t_jw_relatorio_atelier_pre_envio_quarterizado.getCab_desc();
                      cor_cdgo = t_jw_relatorio_atelier_pre_envio_quarterizado.getCor_cdgo();
                      cor_desc = t_jw_relatorio_atelier_pre_envio_quarterizado.getCor_desc()==null?"":t_jw_relatorio_atelier_pre_envio_quarterizado.getCor_desc();
                      tal_pares = t_jw_relatorio_atelier_pre_envio_quarterizado.getTal_pares();
                      data_corte = (java.sql.Timestamp)t_jw_relatorio_atelier_pre_envio_quarterizado.getData_corte();
                      data_cost = (java.sql.Timestamp)t_jw_relatorio_atelier_pre_envio_quarterizado.getData_cost();
                      data_mont = (java.sql.Timestamp)t_jw_relatorio_atelier_pre_envio_quarterizado.getData_mont();
                      sum_tal_pares_1 += ((tal_pares!=null)?tal_pares.intValue():0);
                      String _b0_value = com.egen.util.text.FormatNumber.format(fornecedor_codigo_quarterizado) + "_" + com.egen.util.text.FormatNumber.format(fen_seq_quarterizado);
                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                        %>
                        <tr class="reportHeader2">
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <td colspan="11">
                              <%
                            } else {
                              %>
                              <td colspan="10">
                                <%
                              }
                              %>
                              <span style="text-align:right;" >
                                Fornecedor:
                                <%= ((fornecedor_codigo_quarterizado!=null)?fornecedor_codigo_quarterizado.toString():"") %>
                                -
                                <%= ((fen_seq_quarterizado!=null)?fen_seq_quarterizado.toString():"") %>
                                -
                                <%= fornecedor_razsoc %>
                              </span>
                            </td>
                          </tr>
                          <%
                        }
                        String _b1_value = com.egen.util.text.FormatNumber.format(fornecedor_codigo_quarterizado) + "_" + com.egen.util.text.FormatNumber.format(fen_seq_quarterizado) + "_" + com.egen.util.text.FormatNumber.format(pro_numero);
                        if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                          %>
                          <tr class="reportHeader">
                            <%
                            if(!(request.getParameter("excel")+"").equals("true")){
                              %>
                              <td colspan="11">
                                <%
                              } else {
                                %>
                                <td colspan="10">
                                  <%
                                }
                                %>
                                <span class="columnTdHeader" style="text-align:right;" >
                                  Processo:
                                  <%= ((pro_numero!=null)?pro_numero.toString():"") %>
                                  -
                                  <%= pro_nome %>
                                </span>
                              </td>
                            </tr>
                            <%
                            %>

                            <tr class="reportTr">
                              <td class="columnTdHeader" style="text-align:right;" >
                                Remessa
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" >
                                Talão
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" >
                                Linha
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" >
                                Ref.
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" >
                                Cab.
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" >
                                Cor
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" >
                                Pares
                              </td>

                              <td class="columnTdHeader" style="text-align:center;" >
                                Dt. Corte
                              </td>

                              <td class="columnTdHeader" style="text-align:center;" >
                                Dt. Cost
                              </td>

                              <td class="columnTdHeader" style="text-align:center;" >
                                Dt. Mont.
                              </td>

                              <%
                              if(!(request.getParameter("excel")+"").equals("true")){
                                %>
                                <td class="columnTdHeader" style="text-align:center;"  onclick="return confirmSubmit('');" >
                                  Excluir
                                </td>
                                <%
                              }
                              %>

                            </tr>

                            <%
                          }
                          String style_bl_report_Jw_relatorio_atelier_pre_envio_quarterizado="";
                          if (!((i_bl_report_Jw_relatorio_atelier_pre_envio_quarterizado%2)!=0)) {
                            style_bl_report_Jw_relatorio_atelier_pre_envio_quarterizado="rowColor";
                          } else {
                            style_bl_report_Jw_relatorio_atelier_pre_envio_quarterizado="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Jw_relatorio_atelier_pre_envio_quarterizado %>' id="TRbl_report_Jw_relatorio_atelier_pre_envio_quarterizado<%=i_bl_report_Jw_relatorio_atelier_pre_envio_quarterizado%>" >
                            <td class="reportColumn" style="text-align:right;" >
                              <%= ((rem_nro!=null)?rem_nro.toString():"") %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= ((tal_nro!=null)?tal_nro.toString():"") %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= ((lin_cdgo!=null)?lin_cdgo.toString():"") %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= ((ref_cdgo!=null)?ref_cdgo.toString():"") %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= ((cab_cdgo!=null)?cab_cdgo.toString():"") %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= ((cor_cdgo!=null)?cor_cdgo.toString():"") %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(tal_pares, "#,##0.##") %>
                            </td>

                            <td class="reportColumn" style="text-align:center;" >
                              <%= com.egen.util.text.FormatDate.format(data_corte, "dd/MM/yyyy HH:mm:ss") %>
                            </td>

                            <td class="reportColumn" style="text-align:center;" >
                              <%= com.egen.util.text.FormatDate.format(data_cost, "dd/MM/yyyy HH:mm:ss") %>
                            </td>

                            <td class="reportColumn" style="text-align:center;" >
                              <%= com.egen.util.text.FormatDate.format(data_mont, "dd/MM/yyyy HH:mm:ss") %>
                            </td>

                            <%
                            if(!(request.getParameter("excel")+"").equals("true")){
                              %>
                              <td class="reportColumn" style="text-align:center;"  onclick="return confirmSubmit('');" >
                                <a href="../ind/AtelieresQuarterizados_frForm.do?delete_action=&fornecedor_codigo=<%= fornecedor_codigo %>&fornecedor_codigo_quarterizado=<%= fornecedor_codigo_quarterizado %>&fen_seq_quarterizado=<%= fen_seq_quarterizado %>&pro_numero=<%= pro_numero %>&rem_nro=<%= rem_nro %>&tal_nro=<%= tal_nro %>" style="cursor:hand">
                                  Excluir
                                </a>
                              </td>
                              <%
                            }
                            %>
                          </tr>

                          <%
                          _b0_control = _b0_value;
                          _b1_control = _b1_value;
                          i_bl_report_Jw_relatorio_atelier_pre_envio_quarterizado++;
                          if (i_bl_report_Jw_relatorio_atelier_pre_envio_quarterizado<res_Jw_relatorio_atelier_pre_envio_quarterizado.size()) {
                            t_jw_relatorio_atelier_pre_envio_quarterizado = (portalbr.dbobj.view.Jw_relatorio_atelier_pre_envio_quarterizado)res_Jw_relatorio_atelier_pre_envio_quarterizado.elementAt(i_bl_report_Jw_relatorio_atelier_pre_envio_quarterizado);
                            fornecedor_codigo = t_jw_relatorio_atelier_pre_envio_quarterizado.getFornecedor_codigo();
                            fornecedor_codigo_quarterizado = t_jw_relatorio_atelier_pre_envio_quarterizado.getFornecedor_codigo_quarterizado();
                            fen_seq_quarterizado = t_jw_relatorio_atelier_pre_envio_quarterizado.getFen_seq_quarterizado();
                            fornecedor_razsoc = t_jw_relatorio_atelier_pre_envio_quarterizado.getFornecedor_razsoc()==null?"":t_jw_relatorio_atelier_pre_envio_quarterizado.getFornecedor_razsoc();
                            pro_numero = t_jw_relatorio_atelier_pre_envio_quarterizado.getPro_numero();
                            pro_nome = t_jw_relatorio_atelier_pre_envio_quarterizado.getPro_nome()==null?"":t_jw_relatorio_atelier_pre_envio_quarterizado.getPro_nome();
                            data_envio = (java.sql.Timestamp)t_jw_relatorio_atelier_pre_envio_quarterizado.getData_envio();
                            data_retorno = (java.sql.Timestamp)t_jw_relatorio_atelier_pre_envio_quarterizado.getData_retorno();
                            rem_nro = t_jw_relatorio_atelier_pre_envio_quarterizado.getRem_nro();
                            tal_nro = t_jw_relatorio_atelier_pre_envio_quarterizado.getTal_nro();
                            status = t_jw_relatorio_atelier_pre_envio_quarterizado.getStatus()==null?"":t_jw_relatorio_atelier_pre_envio_quarterizado.getStatus();
                            status_descricao = t_jw_relatorio_atelier_pre_envio_quarterizado.getStatus_descricao()==null?"":t_jw_relatorio_atelier_pre_envio_quarterizado.getStatus_descricao();
                            usuario_inclusao = t_jw_relatorio_atelier_pre_envio_quarterizado.getUsuario_inclusao()==null?"":t_jw_relatorio_atelier_pre_envio_quarterizado.getUsuario_inclusao();
                            usuario_alteracao = t_jw_relatorio_atelier_pre_envio_quarterizado.getUsuario_alteracao()==null?"":t_jw_relatorio_atelier_pre_envio_quarterizado.getUsuario_alteracao();
                            data_ordenacao = (java.sql.Timestamp)t_jw_relatorio_atelier_pre_envio_quarterizado.getData_ordenacao();
                            tal_parbom = t_jw_relatorio_atelier_pre_envio_quarterizado.getTal_parbom();
                            tal_parrej = t_jw_relatorio_atelier_pre_envio_quarterizado.getTal_parrej();
                            lin_cdgo = t_jw_relatorio_atelier_pre_envio_quarterizado.getLin_cdgo();
                            ref_cdgo = t_jw_relatorio_atelier_pre_envio_quarterizado.getRef_cdgo();
                            cab_cdgo = t_jw_relatorio_atelier_pre_envio_quarterizado.getCab_cdgo();
                            cab_desc = t_jw_relatorio_atelier_pre_envio_quarterizado.getCab_desc()==null?"":t_jw_relatorio_atelier_pre_envio_quarterizado.getCab_desc();
                            cor_cdgo = t_jw_relatorio_atelier_pre_envio_quarterizado.getCor_cdgo();
                            cor_desc = t_jw_relatorio_atelier_pre_envio_quarterizado.getCor_desc()==null?"":t_jw_relatorio_atelier_pre_envio_quarterizado.getCor_desc();
                            tal_pares = t_jw_relatorio_atelier_pre_envio_quarterizado.getTal_pares();
                            data_corte = (java.sql.Timestamp)t_jw_relatorio_atelier_pre_envio_quarterizado.getData_corte();
                            data_cost = (java.sql.Timestamp)t_jw_relatorio_atelier_pre_envio_quarterizado.getData_cost();
                            data_mont = (java.sql.Timestamp)t_jw_relatorio_atelier_pre_envio_quarterizado.getData_mont();
                            _b0_value = com.egen.util.text.FormatNumber.format(fornecedor_codigo_quarterizado) + "_" + com.egen.util.text.FormatNumber.format(fen_seq_quarterizado);
                            _b1_value = com.egen.util.text.FormatNumber.format(fornecedor_codigo_quarterizado) + "_" + com.egen.util.text.FormatNumber.format(fen_seq_quarterizado) + "_" + com.egen.util.text.FormatNumber.format(pro_numero);
                          } else {
                            _b0_control = "__";
                            _b1_control = "__";
                          }
                          if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                            %>

                            <tr class="totalColumn">
                              <td>
                                 
                              </td>
                              <td>
                                 
                              </td>
                              <td>
                                 
                              </td>
                              <td>
                                 
                              </td>
                              <td>
                                 
                              </td>
                              <td>
                                 
                              </td>
                              <td class="totalTdColumn"  style="text-align:right;" >
                                <b>
                                  <%= com.egen.util.text.FormatNumber.format(sum_tal_pares_1, "#,##0.##") %>
                                </b>
                              </td>
                              <td>
                                 
                              </td>
                              <td>
                                 
                              </td>
                              <td>
                                 
                              </td>

                              <%
                              if(!(request.getParameter("excel")+"").equals("true")){
                                %>

                                <td>
                                   
                                </td>
                                <%
                              }
                              %>
                            </tr>

                            <%
                            sum_tal_pares_1 = 0;
                          }
                        }
                        %>

                      </table>

                      <%
                    }
                    %>

                  </form>
                  <%
                }
                %>
                <html:form action="ind/AtelieresQuarterizados_frForm.do" method="post" styleClass="baseForm">
                  <table class="messageTable" style='width:99%;'>
                    <tr class="messageTr" >
                      <td class="messageTd">
                        <div style=font-size:11px;font-weight:normal;>

                        </div>
                        <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                      </td>
                    </tr>
                  </table>

                  <table class="itemTable"  style="width:99%;">
                    <html:hidden property="fornecedor_codigo_quarterizado"/>
                    <html:hidden property="fen_seq_quarterizado"/>
                    <html:hidden property="pro_numero"/>
                    <html:hidden property="rem_nro"/>
                    <html:hidden property="tal_nro"/>
                  </table>

                  <table class="buttonTable" style='width:99%;'>
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
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>

                          <html:submit accesskey="a" styleClass="myhidden" property="delete_action">
                            <bean:message bundle="ApplicationResources" key="jsp.delete"/>
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

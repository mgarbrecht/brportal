<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Necessidade Materiais Exportação - Acumulada/Fatura Proforma
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(163)){
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
              java.util.Vector res_Jw_necessidade_materiais = (java.util.Vector)session.getAttribute("res_Jw_necessidade_materiais");
              %>

              <form  name="bl_report_Jw_necessidade_materiais" id="bl_report_Jw_necessidade_materiais" class="baseForm" method="post" >
                <%
                if (res_Jw_necessidade_materiais!=null && res_Jw_necessidade_materiais.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_necessidade_materiais"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.String fil_filial =  null;
                    java.lang.String ped_invoice =  null;
                    java.lang.Integer ies_codigo =  null;
                    java.lang.String descricao =  null;
                    java.lang.String unm_codigo =  null;
                    java.lang.Integer cor_cdgo =  null;
                    java.lang.String cor_desc =  null;
                    java.lang.String tai_codigo =  null;
                    java.lang.Double consumo =  null;
                    String _b0_control = "__";
                    String _b1_control = "__";
                    double sum_consumo_0 = 0;
                    double sum_consumo_1 = 0;
                    double sum_consumo_2 = 0;
                    int i_bl_report_Jw_necessidade_materiais = 0;
                    while (i_bl_report_Jw_necessidade_materiais<res_Jw_necessidade_materiais.size()) {
                      portalbr.dbobj.view.Jw_necessidade_materiais t_jw_necessidade_materiais = (portalbr.dbobj.view.Jw_necessidade_materiais)res_Jw_necessidade_materiais.elementAt(i_bl_report_Jw_necessidade_materiais);
                      fil_filial = t_jw_necessidade_materiais.getFil_filial()==null?"":t_jw_necessidade_materiais.getFil_filial();
                      ped_invoice = t_jw_necessidade_materiais.getPed_invoice()==null?"":t_jw_necessidade_materiais.getPed_invoice();
                      ies_codigo = t_jw_necessidade_materiais.getIes_codigo();
                      descricao = t_jw_necessidade_materiais.getDescricao()==null?"":t_jw_necessidade_materiais.getDescricao();
                      unm_codigo = t_jw_necessidade_materiais.getUnm_codigo()==null?"":t_jw_necessidade_materiais.getUnm_codigo();
                      cor_cdgo = t_jw_necessidade_materiais.getCor_cdgo();
                      cor_desc = t_jw_necessidade_materiais.getCor_desc()==null?"":t_jw_necessidade_materiais.getCor_desc();
                      tai_codigo = t_jw_necessidade_materiais.getTai_codigo()==null?"":t_jw_necessidade_materiais.getTai_codigo();
                      consumo = t_jw_necessidade_materiais.getConsumo();
                      sum_consumo_0 += ((consumo!=null)?consumo.doubleValue():0);
                      sum_consumo_1 += ((consumo!=null)?consumo.doubleValue():0);
                      sum_consumo_2 += ((consumo!=null)?consumo.doubleValue():0);
                      String _b0_value = (fil_filial==null?"":fil_filial);
                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                        %>

                        <%
                        if(fil_filial != null && !fil_filial.equals("")) {
                          %>
                          <tr class="reportHeader3">
                            <td colspan="7">
                              <span class="columnTdHeader" style="text-align:left;" >
                                Filial:
                                <%= fil_filial %>
                              </span>
                            </td>
                          </tr>
                          <%
                        }
                        %>
                        <%
                      }
                      String _b1_value = (fil_filial==null?"":fil_filial) + "_" + (ped_invoice==null?"":ped_invoice);
                      if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                        %>
                        <%
                        if(ped_invoice != null && !ped_invoice.equals("")){
                          %>
                          <tr class="reportHeader2">
                            <td colspan="7">
                              Fatura:
                              <%= ped_invoice %>
                            </td>
                          </tr>
                          <%
                        }
                        %>
                        <%
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:right;" >
                            Material
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Descrição Material
                          </td>

                          <td class="columnTdHeader" style="text-align:center;" >
                            Unid. Medida
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Cor
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Descrição Cor
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Tamanho
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Consumo
                          </td>

                        </tr>

                        <%
                      }
                      String style_bl_report_Jw_necessidade_materiais="";
                      if (!((i_bl_report_Jw_necessidade_materiais%2)!=0)) {
                        style_bl_report_Jw_necessidade_materiais="rowColor";
                      } else {
                        style_bl_report_Jw_necessidade_materiais="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_necessidade_materiais %>' id="TRbl_report_Jw_necessidade_materiais<%=i_bl_report_Jw_necessidade_materiais%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((ies_codigo!=null)?ies_codigo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= descricao %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= unm_codigo %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((cor_cdgo!=null)?cor_cdgo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cor_desc %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= tai_codigo %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(consumo, "##0.000000") %>
                        </td>

                      </tr>

                      <%
                      _b0_control = _b0_value;
                      _b1_control = _b1_value;
                      i_bl_report_Jw_necessidade_materiais++;
                      if (i_bl_report_Jw_necessidade_materiais<res_Jw_necessidade_materiais.size()) {
                        t_jw_necessidade_materiais = (portalbr.dbobj.view.Jw_necessidade_materiais)res_Jw_necessidade_materiais.elementAt(i_bl_report_Jw_necessidade_materiais);
                        fil_filial = t_jw_necessidade_materiais.getFil_filial()==null?"":t_jw_necessidade_materiais.getFil_filial();
                        ped_invoice = t_jw_necessidade_materiais.getPed_invoice()==null?"":t_jw_necessidade_materiais.getPed_invoice();
                        ies_codigo = t_jw_necessidade_materiais.getIes_codigo();
                        descricao = t_jw_necessidade_materiais.getDescricao()==null?"":t_jw_necessidade_materiais.getDescricao();
                        unm_codigo = t_jw_necessidade_materiais.getUnm_codigo()==null?"":t_jw_necessidade_materiais.getUnm_codigo();
                        cor_cdgo = t_jw_necessidade_materiais.getCor_cdgo();
                        cor_desc = t_jw_necessidade_materiais.getCor_desc()==null?"":t_jw_necessidade_materiais.getCor_desc();
                        tai_codigo = t_jw_necessidade_materiais.getTai_codigo()==null?"":t_jw_necessidade_materiais.getTai_codigo();
                        consumo = t_jw_necessidade_materiais.getConsumo();
                        _b0_value = (fil_filial==null?"":fil_filial);
                        _b1_value = (fil_filial==null?"":fil_filial) + "_" + (ped_invoice==null?"":ped_invoice);
                      } else {
                        _b0_control = "__";
                        _b1_control = "__";
                      }
                      if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                        %>

                        <%
                        if(ped_invoice != null && !ped_invoice.equals("")){
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
                                Total Fatura:
                                <%= com.egen.util.text.FormatNumber.format(sum_consumo_1, "##0.000000") %>
                              </b>
                            </td>
                          </tr>
                          <%
                        }
                        %>

                        <%
                        sum_consumo_1 = 0;
                      }
                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                        %>


                        <%
                        if(false){
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
                              Total Filial
                              <%= com.egen.util.text.FormatNumber.format(sum_consumo_2, "##0.000000") %>
                            </td>
                          </tr>

                          <%
                        }
                        %>

                        <%
                        sum_consumo_2 = 0;
                      }
                    }
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
                          Total Geral:
                          <%= com.egen.util.text.FormatNumber.format(sum_consumo_0, "##0.000000") %>
                        </b>
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

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_necessidade_materiais_faturas = (java.util.Vector)session.getAttribute("res_Jw_necessidade_materiais_faturas");
              %>

              <form  name="bl_report_Jw_necessidade_materiais_faturas" id="bl_report_Jw_necessidade_materiais_faturas" class="baseForm" method="post" >
                <%
                if (res_Jw_necessidade_materiais_faturas!=null && res_Jw_necessidade_materiais_faturas.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_necessidade_materiais_faturas"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.String fatura =  null;
                    java.lang.Integer pares =  null;
                    int sum_pares_0 = 0;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Fatura
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Pares
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_necessidade_materiais_faturas = 0;
                    while (i_bl_report_Jw_necessidade_materiais_faturas<res_Jw_necessidade_materiais_faturas.size()) {
                      portalbr.dbobj.view.Jw_necessidade_materiais_faturas t_jw_necessidade_materiais_faturas = (portalbr.dbobj.view.Jw_necessidade_materiais_faturas)res_Jw_necessidade_materiais_faturas.elementAt(i_bl_report_Jw_necessidade_materiais_faturas);
                      fatura = t_jw_necessidade_materiais_faturas.getFatura()==null?"":t_jw_necessidade_materiais_faturas.getFatura();
                      pares = t_jw_necessidade_materiais_faturas.getPares();
                      sum_pares_0 += ((pares!=null)?pares.intValue():0);
                      String style_bl_report_Jw_necessidade_materiais_faturas="";
                      if (!((i_bl_report_Jw_necessidade_materiais_faturas%2)!=0)) {
                        style_bl_report_Jw_necessidade_materiais_faturas="rowColor";
                      } else {
                        style_bl_report_Jw_necessidade_materiais_faturas="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_necessidade_materiais_faturas %>' id="TRbl_report_Jw_necessidade_materiais_faturas<%=i_bl_report_Jw_necessidade_materiais_faturas%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= fatura %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(pares, "#,##0.##") %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_necessidade_materiais_faturas++;
                      if (i_bl_report_Jw_necessidade_materiais_faturas<res_Jw_necessidade_materiais_faturas.size()) {
                        t_jw_necessidade_materiais_faturas = (portalbr.dbobj.view.Jw_necessidade_materiais_faturas)res_Jw_necessidade_materiais_faturas.elementAt(i_bl_report_Jw_necessidade_materiais_faturas);
                        fatura = t_jw_necessidade_materiais_faturas.getFatura()==null?"":t_jw_necessidade_materiais_faturas.getFatura();
                        pares = t_jw_necessidade_materiais_faturas.getPares();
                      } else {
                      }
                    }
                    %>

                    <tr class="totalColumn">
                      <td>
                        &nbsp;
                      </td>
                      <td class="totalTdColumn"  style="text-align:right; font-weight:bold;" >
                        Total:
                        <%= com.egen.util.text.FormatNumber.format(sum_pares_0, "#,##0.##") %>
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

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_necessidade_materiais_pp = (java.util.Vector)session.getAttribute("res_Jw_necessidade_materiais_pp");
              %>

              <form  name="bl_report_Jw_necessidade_materiais_pp" id="bl_report_Jw_necessidade_materiais_pp" class="baseForm" method="post" >
                <%
                if (res_Jw_necessidade_materiais_pp!=null && res_Jw_necessidade_materiais_pp.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_necessidade_materiais_pp"  class="reportTable"   style="width:99%; "  >
                    <%
                    java.lang.Integer material =  null;
                    java.lang.String descricao1 =  null;
                    java.lang.Integer cor =  null;
                    java.lang.String descricao_cor =  null;
                    double tamanho =  0;
                    java.lang.Integer consumo1 =  null;
                    java.lang.String unidade_medida =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        material
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        descricao
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        cor
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        descricao_cor
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        tamanho
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        consumo
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        unidade_medida
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_necessidade_materiais_pp = 0;
                    while (i_bl_report_Jw_necessidade_materiais_pp<res_Jw_necessidade_materiais_pp.size()) {
                      portalbr.dbobj.view.Jw_necessidade_materiais_pp t_jw_necessidade_materiais_pp = (portalbr.dbobj.view.Jw_necessidade_materiais_pp)res_Jw_necessidade_materiais_pp.elementAt(i_bl_report_Jw_necessidade_materiais_pp);
                      material = t_jw_necessidade_materiais_pp.getMaterial();
                      descricao1 = t_jw_necessidade_materiais_pp.getDescricao()==null?"":t_jw_necessidade_materiais_pp.getDescricao();
                      cor = t_jw_necessidade_materiais_pp.getCor();
                      descricao_cor = t_jw_necessidade_materiais_pp.getDescricao_cor()==null?"":t_jw_necessidade_materiais_pp.getDescricao_cor();
                      tamanho = t_jw_necessidade_materiais_pp.getTamanho();
                      consumo1 = t_jw_necessidade_materiais_pp.getConsumo();
                      unidade_medida = t_jw_necessidade_materiais_pp.getUnidade_medida()==null?"":t_jw_necessidade_materiais_pp.getUnidade_medida();
                      String style_bl_report_Jw_necessidade_materiais_pp="";
                      if (!((i_bl_report_Jw_necessidade_materiais_pp%2)!=0)) {
                        style_bl_report_Jw_necessidade_materiais_pp="rowColor";
                      } else {
                        style_bl_report_Jw_necessidade_materiais_pp="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_necessidade_materiais_pp %>' id="TRbl_report_Jw_necessidade_materiais_pp<%=i_bl_report_Jw_necessidade_materiais_pp%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((material!=null)?material.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= descricao1 %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((cor!=null)?cor.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= descricao_cor %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= tamanho %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((consumo1!=null)?consumo1.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= unidade_medida %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_necessidade_materiais_pp++;
                      if (i_bl_report_Jw_necessidade_materiais_pp<res_Jw_necessidade_materiais_pp.size()) {
                        t_jw_necessidade_materiais_pp = (portalbr.dbobj.view.Jw_necessidade_materiais_pp)res_Jw_necessidade_materiais_pp.elementAt(i_bl_report_Jw_necessidade_materiais_pp);
                        material = t_jw_necessidade_materiais_pp.getMaterial();
                        descricao1 = t_jw_necessidade_materiais_pp.getDescricao()==null?"":t_jw_necessidade_materiais_pp.getDescricao();
                        cor = t_jw_necessidade_materiais_pp.getCor();
                        descricao_cor = t_jw_necessidade_materiais_pp.getDescricao_cor()==null?"":t_jw_necessidade_materiais_pp.getDescricao_cor();
                        tamanho = t_jw_necessidade_materiais_pp.getTamanho();
                        consumo1 = t_jw_necessidade_materiais_pp.getConsumo();
                        unidade_medida = t_jw_necessidade_materiais_pp.getUnidade_medida()==null?"":t_jw_necessidade_materiais_pp.getUnidade_medida();
                      } else {
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

            <html:form action="com/NecessidadeMateriais_rForm.do" method="post" styleClass="baseForm">

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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consumo da Composição do Item
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(275)){
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
              java.util.Vector res_Jw_consumo_composicao_item = (java.util.Vector)session.getAttribute("res_Jw_consumo_composicao_item");
              %>

              <form  name="bl_report_Jw_consumo_composicao_item" id="bl_report_Jw_consumo_composicao_item" class="baseForm" method="post" >
                <%
                if (res_Jw_consumo_composicao_item!=null && res_Jw_consumo_composicao_item.size()>0) {
                  if ( ((String)request.getParameter("_ordered"))!=null && ((String)request.getParameter("_ordered")).length()>0 ) {
                    boolean reverse = false;
                    if ( ((String)request.getParameter("_reverse"))!=null && ((String)request.getParameter("_reverse")).equals("true") ){
                      reverse = true;
                    }
                    try {
                      res_Jw_consumo_composicao_item = com.egen.util.text.Sort.execute(res_Jw_consumo_composicao_item,((String)request.getParameter("_ordered")),reverse);
                      session.setAttribute("res_Jw_consumo_composicao_item", res_Jw_consumo_composicao_item);
                    } catch (Exception e) {}
                  }
                  %>

                  <table id="TRbl_report_Jw_consumo_composicao_item"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Integer codigo =  null;
                    java.lang.String descricao =  null;
                    java.lang.Integer cor_cdgo =  null;
                    java.lang.String cor_desc =  null;
                    java.lang.Integer cod_peca =  null;
                    java.lang.String descricao_peca =  null;
                    java.lang.Integer material =  null;
                    java.lang.String descricao_material =  null;
                    java.lang.String unm_codigo =  null;
                    java.lang.Integer cor_mater =  null;
                    java.lang.String descricao_cor_material =  null;
                    java.lang.String set_cdgo =  null;
                    java.lang.Double com_consum =  null;
                    java.lang.String com_espess =  null;
                    java.lang.Double dimensao_placa =  null;
                    java.lang.Double mao_de_obra =  null;
                    java.lang.String oc =  null;
                    java.lang.String rm =  null;
                    java.lang.String destino_mat =  null;
                    java.lang.String com_compra =  null;
                    java.lang.String com_gerarm =  null;
                    java.lang.String com_destin =  null;
                    String _b0_control = "__";
                    String _b1_control = "__";
                    int i_bl_report_Jw_consumo_composicao_item = 0;
                    int contador = 0;
                    while (i_bl_report_Jw_consumo_composicao_item<res_Jw_consumo_composicao_item.size()) {
                      portalbr.dbobj.view.Jw_consumo_composicao_item t_jw_consumo_composicao_item = (portalbr.dbobj.view.Jw_consumo_composicao_item)res_Jw_consumo_composicao_item.elementAt(i_bl_report_Jw_consumo_composicao_item);
                      codigo = t_jw_consumo_composicao_item.getCodigo();
                      descricao = t_jw_consumo_composicao_item.getDescricao()==null?"":t_jw_consumo_composicao_item.getDescricao();
                      cor_cdgo = t_jw_consumo_composicao_item.getCor_cdgo();
                      cor_desc = t_jw_consumo_composicao_item.getCor_desc()==null?"":t_jw_consumo_composicao_item.getCor_desc();
                      cod_peca = t_jw_consumo_composicao_item.getCod_peca();
                      descricao_peca = t_jw_consumo_composicao_item.getDescricao_peca()==null?"":t_jw_consumo_composicao_item.getDescricao_peca();
                      material = t_jw_consumo_composicao_item.getMaterial();
                      descricao_material = t_jw_consumo_composicao_item.getDescricao_material()==null?"":t_jw_consumo_composicao_item.getDescricao_material();
                      unm_codigo = t_jw_consumo_composicao_item.getUnm_codigo()==null?"":t_jw_consumo_composicao_item.getUnm_codigo();
                      cor_mater = t_jw_consumo_composicao_item.getCor_mater();
                      descricao_cor_material = t_jw_consumo_composicao_item.getDescricao_cor_material()==null?"":t_jw_consumo_composicao_item.getDescricao_cor_material();
                      set_cdgo = t_jw_consumo_composicao_item.getSet_cdgo()==null?"":t_jw_consumo_composicao_item.getSet_cdgo();
                      com_consum = t_jw_consumo_composicao_item.getCom_consum();
                      com_espess = t_jw_consumo_composicao_item.getCom_espess()==null?"":t_jw_consumo_composicao_item.getCom_espess();
                      dimensao_placa = t_jw_consumo_composicao_item.getDimensao_placa();
                      mao_de_obra = t_jw_consumo_composicao_item.getMao_de_obra();
                      oc = t_jw_consumo_composicao_item.getOc()==null?"":t_jw_consumo_composicao_item.getOc();
                      rm = t_jw_consumo_composicao_item.getRm()==null?"":t_jw_consumo_composicao_item.getRm();
                      destino_mat = t_jw_consumo_composicao_item.getDestino_mat()==null?"":t_jw_consumo_composicao_item.getDestino_mat();
                      com_compra = t_jw_consumo_composicao_item.getCom_compra()==null?"":t_jw_consumo_composicao_item.getCom_compra();
                      com_gerarm = t_jw_consumo_composicao_item.getCom_gerarm()==null?"":t_jw_consumo_composicao_item.getCom_gerarm();
                      com_destin = t_jw_consumo_composicao_item.getCom_destin()==null?"":t_jw_consumo_composicao_item.getCom_destin();
                      contador ++;
                      String _b0_value = com.egen.util.text.FormatNumber.format(codigo);
                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                        %>
                        <%
                        if(contador>1){
                          %>
                          <tr>
                            <td colspan="18">
                              <br />
                              <br />
                            </td>
                          </tr>
                          <%
                        }
                        %>
                        <tr class="reportHeader3">
                          <td colspan="18">
                            <span class="columnTdHeader" style="text-align:right; font-size: 14px" >
                              Item:
                              <!--
                                <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","codigo")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","codigo")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %>
                              -->
                            </span>
                            <span style="text-align:right; font-size: 14px" >
                              <%= ((codigo!=null)?codigo.toString():"") %>
                            </span>
                            <span class="columnTdHeader" style="text-align:left; font-size: 14px" >
                              -
                              <!--
                                <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","descricao")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","descricao")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %>
                              -->
                            </span>
                            <span style="text-align:left; font-size: 14px" >
                              <%= descricao %>
                            </span>
                          </td>
                        </tr>
                        <%
                      }
                      String _b1_value = com.egen.util.text.FormatNumber.format(codigo) + "_" + com.egen.util.text.FormatNumber.format(cor_cdgo);
                      if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                        %>
                        <tr class="reportHeader2">
                          <td colspan="18">
                            <span style="text-align:right;" >
                              Cor:
                              <!--
                                <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","cor_cdgo")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","cor_cdgo")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %>
                              -->
                            </span>
                            <span  style="text-align:right;" >
                              <%= ((cor_cdgo!=null)?cor_cdgo.toString():"") %>
                            </span>
                            <span style="text-align:left;" >
                              -
                              <!--
                                <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","cor_desc")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","cor_desc")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %>
                              -->
                            </span>
                            <span style="text-align:left;" >
                              <%= cor_desc %>
                            </span>
                          </td>
                        </tr>
                        <%
                        %>


                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:right;" >
                            Peça
                            <!--
                              <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","cod_peca")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","cod_peca")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %>
                            -->
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Descrição Peça
                            <!--
                              <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","descricao_peca")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","descricao_peca")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %>
                            -->
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Material
                            <!--
                              <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","material")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","material")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %>
                            -->
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Descrição Material
                            <!--
                              <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","descricao_material")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","descricao_material")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %>
                            -->
                          </td>

                          <td class="columnTdHeader" style="text-align:center;" >
                            Unm.
                            <!--
                              <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","unm_codigo")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","unm_codigo")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %>
                            -->
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Cor do Material
                            <!--
                              <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","cor_mater")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","cor_mater")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %>
                            -->
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Descrição Cor
                            <!--
                              <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","descricao_cor_material")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","descricao_cor_material")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %>
                            -->
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Setor
                            <!--
                              <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","set_cdgo")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","set_cdgo")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %>
                            -->
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Cons.
                            <!--
                              <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","com_consum")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","com_consum")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %>
                            -->
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Esp.
                            <!--
                              <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","com_espess")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","com_espess")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %>
                            -->
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Dim. Placa
                            <!--
                              <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","dimensao_placa")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","dimensao_placa")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %>
                            -->
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Mão de Obra
                            <!--
                              <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","mao_de_obra")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","mao_de_obra")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %>
                            -->
                          </td>

                          <td class="columnTdHeader" style="text-align:center;" >
                            OC
                            <!--
                              <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","oc")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","oc")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %>
                            -->
                          </td>

                          <td class="columnTdHeader" style="text-align:center;" >
                            RM
                            <!--
                              <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","rm")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","rm")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %>
                            -->
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Destino Mat.
                            <!--
                              <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","destino_mat")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ConsumoComposicaoItem_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","destino_mat")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %>
                            -->
                          </td>

                        </tr>

                        <%
                      }
                      String style_bl_report_Jw_consumo_composicao_item="";
                      if (!((i_bl_report_Jw_consumo_composicao_item%2)!=0)) {
                        style_bl_report_Jw_consumo_composicao_item="rowColor";
                      } else {
                        style_bl_report_Jw_consumo_composicao_item="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_consumo_composicao_item %>' id="TRbl_report_Jw_consumo_composicao_item<%=i_bl_report_Jw_consumo_composicao_item%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((cod_peca!=null)?cod_peca.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= descricao_peca %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((material!=null)?material.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= descricao_material %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= unm_codigo %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((cor_mater!=null)?cor_mater.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= descricao_cor_material %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= set_cdgo %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(com_consum, "##,##0.000000") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= com_espess %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(dimensao_placa, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(mao_de_obra, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= oc %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= rm %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= destino_mat %>
                        </td>
                      </tr>

                      <%
                      _b0_control = _b0_value;
                      _b1_control = _b1_value;
                      i_bl_report_Jw_consumo_composicao_item++;
                      if (i_bl_report_Jw_consumo_composicao_item<res_Jw_consumo_composicao_item.size()) {
                        t_jw_consumo_composicao_item = (portalbr.dbobj.view.Jw_consumo_composicao_item)res_Jw_consumo_composicao_item.elementAt(i_bl_report_Jw_consumo_composicao_item);
                        codigo = t_jw_consumo_composicao_item.getCodigo();
                        descricao = t_jw_consumo_composicao_item.getDescricao()==null?"":t_jw_consumo_composicao_item.getDescricao();
                        cor_cdgo = t_jw_consumo_composicao_item.getCor_cdgo();
                        cor_desc = t_jw_consumo_composicao_item.getCor_desc()==null?"":t_jw_consumo_composicao_item.getCor_desc();
                        cod_peca = t_jw_consumo_composicao_item.getCod_peca();
                        descricao_peca = t_jw_consumo_composicao_item.getDescricao_peca()==null?"":t_jw_consumo_composicao_item.getDescricao_peca();
                        material = t_jw_consumo_composicao_item.getMaterial();
                        descricao_material = t_jw_consumo_composicao_item.getDescricao_material()==null?"":t_jw_consumo_composicao_item.getDescricao_material();
                        unm_codigo = t_jw_consumo_composicao_item.getUnm_codigo()==null?"":t_jw_consumo_composicao_item.getUnm_codigo();
                        cor_mater = t_jw_consumo_composicao_item.getCor_mater();
                        descricao_cor_material = t_jw_consumo_composicao_item.getDescricao_cor_material()==null?"":t_jw_consumo_composicao_item.getDescricao_cor_material();
                        set_cdgo = t_jw_consumo_composicao_item.getSet_cdgo()==null?"":t_jw_consumo_composicao_item.getSet_cdgo();
                        com_consum = t_jw_consumo_composicao_item.getCom_consum();
                        com_espess = t_jw_consumo_composicao_item.getCom_espess()==null?"":t_jw_consumo_composicao_item.getCom_espess();
                        dimensao_placa = t_jw_consumo_composicao_item.getDimensao_placa();
                        mao_de_obra = t_jw_consumo_composicao_item.getMao_de_obra();
                        oc = t_jw_consumo_composicao_item.getOc()==null?"":t_jw_consumo_composicao_item.getOc();
                        rm = t_jw_consumo_composicao_item.getRm()==null?"":t_jw_consumo_composicao_item.getRm();
                        destino_mat = t_jw_consumo_composicao_item.getDestino_mat()==null?"":t_jw_consumo_composicao_item.getDestino_mat();
                        com_compra = t_jw_consumo_composicao_item.getCom_compra()==null?"":t_jw_consumo_composicao_item.getCom_compra();
                        com_gerarm = t_jw_consumo_composicao_item.getCom_gerarm()==null?"":t_jw_consumo_composicao_item.getCom_gerarm();
                        com_destin = t_jw_consumo_composicao_item.getCom_destin()==null?"":t_jw_consumo_composicao_item.getCom_destin();
                        _b0_value = com.egen.util.text.FormatNumber.format(codigo);
                        _b1_value = com.egen.util.text.FormatNumber.format(codigo) + "_" + com.egen.util.text.FormatNumber.format(cor_cdgo);
                      } else {
                        _b0_control = "__";
                        _b1_control = "__";
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

            <html:form action="ind/ConsumoComposicaoItem_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
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

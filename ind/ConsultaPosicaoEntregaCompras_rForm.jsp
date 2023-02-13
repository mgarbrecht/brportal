<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta Posição Entrega das Compras
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(164)){
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
              java.util.Vector res_Jw_consulta_posicao_entrega_compras = (java.util.Vector)session.getAttribute("res_Jw_consulta_posicao_entrega_compras");
              %>

              <form  name="bl_report_Jw_consulta_posicao_entrega_compras" id="bl_report_Jw_consulta_posicao_entrega_compras" class="baseForm" method="post" >
                <%
                if (res_Jw_consulta_posicao_entrega_compras!=null && res_Jw_consulta_posicao_entrega_compras.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_consulta_posicao_entrega_compras"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.String fil_filial =  null;
                    java.lang.String for_codigo =  null;
                    java.lang.String fornecedor =  null;
                    java.sql.Timestamp data_compra =  null;
                    java.lang.String ies_codigo =  null;
                    java.lang.String descricao_item =  null;
                    java.lang.String cor_cdgo =  null;
                    java.lang.String cor_desc =  null;
                    java.sql.Timestamp data_entrega =  null;
                    double quant_comprada =  0;
                    double quant_recebida =  0;
                    double saldo =  0;
                    java.lang.Integer oco_numero =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Filial
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Data Compra
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Item
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição Item
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Cor
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição Cor
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Data Entrega
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Qtd. Comprada
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Qtd. Recebida
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Saldo
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Ordem de Compra
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_consulta_posicao_entrega_compras = 0;
                    while (i_bl_report_Jw_consulta_posicao_entrega_compras<res_Jw_consulta_posicao_entrega_compras.size()) {
                      portalbr.dbobj.view.Jw_consulta_posicao_entrega_compras t_jw_consulta_posicao_entrega_compras = (portalbr.dbobj.view.Jw_consulta_posicao_entrega_compras)res_Jw_consulta_posicao_entrega_compras.elementAt(i_bl_report_Jw_consulta_posicao_entrega_compras);
                      fil_filial = t_jw_consulta_posicao_entrega_compras.getFil_filial()==null?"":t_jw_consulta_posicao_entrega_compras.getFil_filial();
                      for_codigo = t_jw_consulta_posicao_entrega_compras.getFor_codigo()==null?"":t_jw_consulta_posicao_entrega_compras.getFor_codigo();
                      fornecedor = t_jw_consulta_posicao_entrega_compras.getFornecedor()==null?"":t_jw_consulta_posicao_entrega_compras.getFornecedor();
                      data_compra = (java.sql.Timestamp)t_jw_consulta_posicao_entrega_compras.getData_compra();
                      ies_codigo = t_jw_consulta_posicao_entrega_compras.getIes_codigo()==null?"":t_jw_consulta_posicao_entrega_compras.getIes_codigo();
                      descricao_item = t_jw_consulta_posicao_entrega_compras.getDescricao_item()==null?"":t_jw_consulta_posicao_entrega_compras.getDescricao_item();
                      cor_cdgo = t_jw_consulta_posicao_entrega_compras.getCor_cdgo()==null?"":t_jw_consulta_posicao_entrega_compras.getCor_cdgo();
                      cor_desc = t_jw_consulta_posicao_entrega_compras.getCor_desc()==null?"":t_jw_consulta_posicao_entrega_compras.getCor_desc();
                      data_entrega = (java.sql.Timestamp)t_jw_consulta_posicao_entrega_compras.getData_entrega();
                      quant_comprada = t_jw_consulta_posicao_entrega_compras.getQuant_comprada();
                      quant_recebida = t_jw_consulta_posicao_entrega_compras.getQuant_recebida();
                      saldo = t_jw_consulta_posicao_entrega_compras.getSaldo();
                      oco_numero = t_jw_consulta_posicao_entrega_compras.getOco_numero();
                      String style_bl_report_Jw_consulta_posicao_entrega_compras="";
                      if (!((i_bl_report_Jw_consulta_posicao_entrega_compras%2)!=0)) {
                        style_bl_report_Jw_consulta_posicao_entrega_compras="rowColor";
                      } else {
                        style_bl_report_Jw_consulta_posicao_entrega_compras="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_consulta_posicao_entrega_compras %>' id="TRbl_report_Jw_consulta_posicao_entrega_compras<%=i_bl_report_Jw_consulta_posicao_entrega_compras%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= fil_filial %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_compra, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= ies_codigo %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= descricao_item %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cor_cdgo %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cor_desc %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_entrega, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(quant_comprada, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(quant_recebida, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(saldo, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((oco_numero!=null)?oco_numero.toString():"") %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_consulta_posicao_entrega_compras++;
                      if (i_bl_report_Jw_consulta_posicao_entrega_compras<res_Jw_consulta_posicao_entrega_compras.size()) {
                        t_jw_consulta_posicao_entrega_compras = (portalbr.dbobj.view.Jw_consulta_posicao_entrega_compras)res_Jw_consulta_posicao_entrega_compras.elementAt(i_bl_report_Jw_consulta_posicao_entrega_compras);
                        fil_filial = t_jw_consulta_posicao_entrega_compras.getFil_filial()==null?"":t_jw_consulta_posicao_entrega_compras.getFil_filial();
                        for_codigo = t_jw_consulta_posicao_entrega_compras.getFor_codigo()==null?"":t_jw_consulta_posicao_entrega_compras.getFor_codigo();
                        fornecedor = t_jw_consulta_posicao_entrega_compras.getFornecedor()==null?"":t_jw_consulta_posicao_entrega_compras.getFornecedor();
                        data_compra = (java.sql.Timestamp)t_jw_consulta_posicao_entrega_compras.getData_compra();
                        ies_codigo = t_jw_consulta_posicao_entrega_compras.getIes_codigo()==null?"":t_jw_consulta_posicao_entrega_compras.getIes_codigo();
                        descricao_item = t_jw_consulta_posicao_entrega_compras.getDescricao_item()==null?"":t_jw_consulta_posicao_entrega_compras.getDescricao_item();
                        cor_cdgo = t_jw_consulta_posicao_entrega_compras.getCor_cdgo()==null?"":t_jw_consulta_posicao_entrega_compras.getCor_cdgo();
                        cor_desc = t_jw_consulta_posicao_entrega_compras.getCor_desc()==null?"":t_jw_consulta_posicao_entrega_compras.getCor_desc();
                        data_entrega = (java.sql.Timestamp)t_jw_consulta_posicao_entrega_compras.getData_entrega();
                        quant_comprada = t_jw_consulta_posicao_entrega_compras.getQuant_comprada();
                        quant_recebida = t_jw_consulta_posicao_entrega_compras.getQuant_recebida();
                        saldo = t_jw_consulta_posicao_entrega_compras.getSaldo();
                        oco_numero = t_jw_consulta_posicao_entrega_compras.getOco_numero();
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

            <html:form action="ind/ConsultaPosicaoEntregaCompras_rForm.do" method="post" styleClass="baseForm">
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

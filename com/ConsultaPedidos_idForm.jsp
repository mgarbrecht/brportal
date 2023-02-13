<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:100%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <%
            {
              %>

              <%
              java.util.Vector res_Jw_consulta_pedidos_detalhes_peso_numeros = (java.util.Vector)session.getAttribute("res_Jw_consulta_pedidos_detalhes_peso_numeros");
              %>

              <form  name="bl_report_Jw_consulta_pedidos_detalhes_peso_numeros" id="bl_report_Jw_consulta_pedidos_detalhes_peso_numeros" class="baseForm" method="post" >
                <table class="bannerTable" style="width:100%;">
                  <tr class="bannerTr">
                    <td class="bannerTd">
                      Números
                    </td>
                  </tr>
                </table>

                <%
                if (res_Jw_consulta_pedidos_detalhes_peso_numeros!=null && res_Jw_consulta_pedidos_detalhes_peso_numeros.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_consulta_pedidos_detalhes_peso_numeros"  class="reportTable"   style="width:100%; "  border="1">
                    <%
                    java.lang.Integer codigo1 =  null;
                    java.lang.String descricao1 =  null;
                    java.lang.String numero =  null;
                    java.lang.Double peso_embalagem =  null;
                    java.lang.Double peso_sapato =  null;
                    java.lang.Double peso_adicional =  null;
                    java.lang.Integer lin_cdgo =  null;
                    java.lang.Integer ref_cdgo =  null;
                    java.lang.Integer codigo_embalagem =  null;
                    String _b0_control = "__";
                    int i_bl_report_Jw_consulta_pedidos_detalhes_peso_numeros = 0;
                    while (i_bl_report_Jw_consulta_pedidos_detalhes_peso_numeros<res_Jw_consulta_pedidos_detalhes_peso_numeros.size()) {
                      portalbr.dbobj.view.Jw_consulta_pedidos_detalhes_peso_numeros t_jw_consulta_pedidos_detalhes_peso_numeros = (portalbr.dbobj.view.Jw_consulta_pedidos_detalhes_peso_numeros)res_Jw_consulta_pedidos_detalhes_peso_numeros.elementAt(i_bl_report_Jw_consulta_pedidos_detalhes_peso_numeros);
                      codigo1 = t_jw_consulta_pedidos_detalhes_peso_numeros.getCodigo();
                      descricao1 = t_jw_consulta_pedidos_detalhes_peso_numeros.getDescricao()==null?"":t_jw_consulta_pedidos_detalhes_peso_numeros.getDescricao();
                      numero = t_jw_consulta_pedidos_detalhes_peso_numeros.getNumero()==null?"":t_jw_consulta_pedidos_detalhes_peso_numeros.getNumero();
                      peso_embalagem = t_jw_consulta_pedidos_detalhes_peso_numeros.getPeso_embalagem();
                      peso_sapato = t_jw_consulta_pedidos_detalhes_peso_numeros.getPeso_sapato();
                      peso_adicional = t_jw_consulta_pedidos_detalhes_peso_numeros.getPeso_adicional();
                      lin_cdgo = t_jw_consulta_pedidos_detalhes_peso_numeros.getLin_cdgo();
                      ref_cdgo = t_jw_consulta_pedidos_detalhes_peso_numeros.getRef_cdgo();
                      codigo_embalagem = t_jw_consulta_pedidos_detalhes_peso_numeros.getCodigo_embalagem();
                      String _b0_value = com.egen.util.text.FormatNumber.format(codigo1);
                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                        %>
                        <tr class="reportHeader2">
                          <td colspan="7">
                            <span class="columnTdHeader" style="text-align:right;" >
                              Embalagem :
                              <%= ((codigo1!=null)?codigo1.toString():"") %>
                              -
                              <%= descricao1 %>
                            </span>
                          </td>
                        </tr>
                        <%
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:left;" >
                            Número
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Peso Embalagem
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Peso Sapato
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Peso Adicional
                          </td>

                        </tr>

                        <%
                      }
                      String style_bl_report_Jw_consulta_pedidos_detalhes_peso_numeros="";
                      if (!((i_bl_report_Jw_consulta_pedidos_detalhes_peso_numeros%2)!=0)) {
                        style_bl_report_Jw_consulta_pedidos_detalhes_peso_numeros="rowColor";
                      } else {
                        style_bl_report_Jw_consulta_pedidos_detalhes_peso_numeros="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_consulta_pedidos_detalhes_peso_numeros %>' id="TRbl_report_Jw_consulta_pedidos_detalhes_peso_numeros<%=i_bl_report_Jw_consulta_pedidos_detalhes_peso_numeros%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= numero %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(peso_embalagem, "##0.00000") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(peso_sapato, "##0.00000") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(peso_adicional, "##0.00000") %>
                        </td>

                      </tr>

                      <%
                      _b0_control = _b0_value;
                      i_bl_report_Jw_consulta_pedidos_detalhes_peso_numeros++;
                      if (i_bl_report_Jw_consulta_pedidos_detalhes_peso_numeros<res_Jw_consulta_pedidos_detalhes_peso_numeros.size()) {
                        t_jw_consulta_pedidos_detalhes_peso_numeros = (portalbr.dbobj.view.Jw_consulta_pedidos_detalhes_peso_numeros)res_Jw_consulta_pedidos_detalhes_peso_numeros.elementAt(i_bl_report_Jw_consulta_pedidos_detalhes_peso_numeros);
                        codigo1 = t_jw_consulta_pedidos_detalhes_peso_numeros.getCodigo();
                        descricao1 = t_jw_consulta_pedidos_detalhes_peso_numeros.getDescricao()==null?"":t_jw_consulta_pedidos_detalhes_peso_numeros.getDescricao();
                        numero = t_jw_consulta_pedidos_detalhes_peso_numeros.getNumero()==null?"":t_jw_consulta_pedidos_detalhes_peso_numeros.getNumero();
                        peso_embalagem = t_jw_consulta_pedidos_detalhes_peso_numeros.getPeso_embalagem();
                        peso_sapato = t_jw_consulta_pedidos_detalhes_peso_numeros.getPeso_sapato();
                        peso_adicional = t_jw_consulta_pedidos_detalhes_peso_numeros.getPeso_adicional();
                        lin_cdgo = t_jw_consulta_pedidos_detalhes_peso_numeros.getLin_cdgo();
                        ref_cdgo = t_jw_consulta_pedidos_detalhes_peso_numeros.getRef_cdgo();
                        codigo_embalagem = t_jw_consulta_pedidos_detalhes_peso_numeros.getCodigo_embalagem();
                        _b0_value = com.egen.util.text.FormatNumber.format(codigo1);
                      } else {
                        _b0_control = "__";
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

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_consulta_pedidos_detalhes_peso_corrugados = (java.util.Vector)session.getAttribute("res_Jw_consulta_pedidos_detalhes_peso_corrugados");
              %>

              <form  name="bl_report_Jw_consulta_pedidos_detalhes_peso_corrugados" id="bl_report_Jw_consulta_pedidos_detalhes_peso_corrugados" class="baseForm" method="post" >
                <table class="bannerTable" style="width:100%;">
                  <tr class="bannerTr">
                    <td class="bannerTd">
                      Corrugados
                    </td>
                  </tr>
                </table>

                <%
                if (res_Jw_consulta_pedidos_detalhes_peso_corrugados!=null && res_Jw_consulta_pedidos_detalhes_peso_corrugados.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_consulta_pedidos_detalhes_peso_corrugados"  class="reportTable"   style="width:100%; "  border="1" >
                    <%
                    java.lang.Integer codigo =  null;
                    java.lang.String descricao =  null;
                    java.lang.Double peso_corrug =  null;
                    java.lang.Double comprimento =  null;
                    java.lang.Double largura =  null;
                    java.lang.Double altura =  null;
                    String _b0_control = "__";
                    int i_bl_report_Jw_consulta_pedidos_detalhes_peso_corrugados = 0;
                    while (i_bl_report_Jw_consulta_pedidos_detalhes_peso_corrugados<res_Jw_consulta_pedidos_detalhes_peso_corrugados.size()) {
                      portalbr.dbobj.view.Jw_consulta_pedidos_detalhes_peso_corrugados t_jw_consulta_pedidos_detalhes_peso_corrugados = (portalbr.dbobj.view.Jw_consulta_pedidos_detalhes_peso_corrugados)res_Jw_consulta_pedidos_detalhes_peso_corrugados.elementAt(i_bl_report_Jw_consulta_pedidos_detalhes_peso_corrugados);
                      codigo = t_jw_consulta_pedidos_detalhes_peso_corrugados.getCodigo();
                      descricao = t_jw_consulta_pedidos_detalhes_peso_corrugados.getDescricao()==null?"":t_jw_consulta_pedidos_detalhes_peso_corrugados.getDescricao();
                      peso_corrug = t_jw_consulta_pedidos_detalhes_peso_corrugados.getPeso_corrug();
                      comprimento = t_jw_consulta_pedidos_detalhes_peso_corrugados.getComprimento();
                      largura = t_jw_consulta_pedidos_detalhes_peso_corrugados.getLargura();
                      altura = t_jw_consulta_pedidos_detalhes_peso_corrugados.getAltura();
                      String _b0_value = com.egen.util.text.FormatNumber.format(codigo);
                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                        %>
                        <tr class="reportHeader2">
                          <td colspan="4">
                            <span class="columnTdHeader" style="text-align:right;" >
                              Corrugado :
                              <%= ((codigo!=null)?codigo.toString():"") %>
                              -
                              <%= descricao %>
                            </span>
                          </td>
                        </tr>
                        <%
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:right;" >
                            Peso
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Comprimento
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Largura
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Altura
                          </td>

                        </tr>

                        <%
                      }
                      String style_bl_report_Jw_consulta_pedidos_detalhes_peso_corrugados="";
                      if (!((i_bl_report_Jw_consulta_pedidos_detalhes_peso_corrugados%2)!=0)) {
                        style_bl_report_Jw_consulta_pedidos_detalhes_peso_corrugados="rowColor";
                      } else {
                        style_bl_report_Jw_consulta_pedidos_detalhes_peso_corrugados="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_consulta_pedidos_detalhes_peso_corrugados %>' id="TRbl_report_Jw_consulta_pedidos_detalhes_peso_corrugados<%=i_bl_report_Jw_consulta_pedidos_detalhes_peso_corrugados%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(peso_corrug, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(comprimento, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(largura, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(altura, "##,##0.00") %>
                        </td>

                      </tr>

                      <%
                      _b0_control = _b0_value;
                      i_bl_report_Jw_consulta_pedidos_detalhes_peso_corrugados++;
                      if (i_bl_report_Jw_consulta_pedidos_detalhes_peso_corrugados<res_Jw_consulta_pedidos_detalhes_peso_corrugados.size()) {
                        t_jw_consulta_pedidos_detalhes_peso_corrugados = (portalbr.dbobj.view.Jw_consulta_pedidos_detalhes_peso_corrugados)res_Jw_consulta_pedidos_detalhes_peso_corrugados.elementAt(i_bl_report_Jw_consulta_pedidos_detalhes_peso_corrugados);
                        codigo = t_jw_consulta_pedidos_detalhes_peso_corrugados.getCodigo();
                        descricao = t_jw_consulta_pedidos_detalhes_peso_corrugados.getDescricao()==null?"":t_jw_consulta_pedidos_detalhes_peso_corrugados.getDescricao();
                        peso_corrug = t_jw_consulta_pedidos_detalhes_peso_corrugados.getPeso_corrug();
                        comprimento = t_jw_consulta_pedidos_detalhes_peso_corrugados.getComprimento();
                        largura = t_jw_consulta_pedidos_detalhes_peso_corrugados.getLargura();
                        altura = t_jw_consulta_pedidos_detalhes_peso_corrugados.getAltura();
                        _b0_value = com.egen.util.text.FormatNumber.format(codigo);
                      } else {
                        _b0_control = "__";
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

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_consulta_pedidos_detalhes_item_estoque = (java.util.Vector)session.getAttribute("res_Jw_consulta_pedidos_detalhes_item_estoque");
              %>

              <form  name="bl_report_Jw_consulta_pedidos_detalhes_item_estoque" id="bl_report_Jw_consulta_pedidos_detalhes_item_estoque" class="baseForm" method="post" >
                <table class="bannerTable" style="width:100%;">
                  <tr class="bannerTr">
                    <td class="bannerTd">
                      Item de Estoque do Corrugado
                    </td>
                  </tr>
                </table>

                <%
                if (res_Jw_consulta_pedidos_detalhes_item_estoque!=null && res_Jw_consulta_pedidos_detalhes_item_estoque.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_consulta_pedidos_detalhes_item_estoque"  class="reportTable"   style="width:100%; "  border="1" >
                    <%
                    java.lang.Integer codigo2 =  null;
                    java.lang.String descricao2 =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Código
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_consulta_pedidos_detalhes_item_estoque = 0;
                    while (i_bl_report_Jw_consulta_pedidos_detalhes_item_estoque<res_Jw_consulta_pedidos_detalhes_item_estoque.size()) {
                      portalbr.dbobj.view.Jw_consulta_pedidos_detalhes_item_estoque t_jw_consulta_pedidos_detalhes_item_estoque = (portalbr.dbobj.view.Jw_consulta_pedidos_detalhes_item_estoque)res_Jw_consulta_pedidos_detalhes_item_estoque.elementAt(i_bl_report_Jw_consulta_pedidos_detalhes_item_estoque);
                      codigo2 = t_jw_consulta_pedidos_detalhes_item_estoque.getCodigo();
                      descricao2 = t_jw_consulta_pedidos_detalhes_item_estoque.getDescricao()==null?"":t_jw_consulta_pedidos_detalhes_item_estoque.getDescricao();
                      String style_bl_report_Jw_consulta_pedidos_detalhes_item_estoque="";
                      if (!((i_bl_report_Jw_consulta_pedidos_detalhes_item_estoque%2)!=0)) {
                        style_bl_report_Jw_consulta_pedidos_detalhes_item_estoque="rowColor";
                      } else {
                        style_bl_report_Jw_consulta_pedidos_detalhes_item_estoque="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_consulta_pedidos_detalhes_item_estoque %>' id="TRbl_report_Jw_consulta_pedidos_detalhes_item_estoque<%=i_bl_report_Jw_consulta_pedidos_detalhes_item_estoque%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((codigo2!=null)?codigo2.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= descricao2 %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_consulta_pedidos_detalhes_item_estoque++;
                      if (i_bl_report_Jw_consulta_pedidos_detalhes_item_estoque<res_Jw_consulta_pedidos_detalhes_item_estoque.size()) {
                        t_jw_consulta_pedidos_detalhes_item_estoque = (portalbr.dbobj.view.Jw_consulta_pedidos_detalhes_item_estoque)res_Jw_consulta_pedidos_detalhes_item_estoque.elementAt(i_bl_report_Jw_consulta_pedidos_detalhes_item_estoque);
                        codigo2 = t_jw_consulta_pedidos_detalhes_item_estoque.getCodigo();
                        descricao2 = t_jw_consulta_pedidos_detalhes_item_estoque.getDescricao()==null?"":t_jw_consulta_pedidos_detalhes_item_estoque.getDescricao();
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

            <html:form action="com/ConsultaPedidos_idForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:100%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:100%;">
                <html:hidden property="codigo_corrugado"/>
                <html:hidden property="codigo_embalagem"/>
                <html:hidden property="lin_cdgo"/>
                <html:hidden property="ref_cdgo"/>
              </table>

              <table class="buttonTable" style='width:100%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
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

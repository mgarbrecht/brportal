<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Registros de Exportação (RE / NCM)
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(271)){
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
              java.util.List<util.consultas.com.RegistroExportacao.Registro> res_Jw_registros_exportacao = (java.util.List<util.consultas.com.RegistroExportacao.Registro>)session.getAttribute("res_Jw_registros_exportacao");
              %>

              <form  name="bl_report_Jw_registros_exportacao" id="bl_report_Jw_registros_exportacao" class="baseForm" method="post" >
                <%
                if (res_Jw_registros_exportacao!=null && res_Jw_registros_exportacao.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_registros_exportacao"  class="reportTable" style="width: 99%" border="1" >
                    <%
                    java.lang.String numero_re =  null;
                    java.lang.String numero_drawback =  null;
                    java.lang.String fil_filial =  null;
                    java.sql.Date data_embarque =  null;
                    java.sql.Date data_averbacao =  null;
                    java.lang.String fatura =  null;
                    java.lang.String ncm =  null;
                    java.lang.Integer pares =  null;
                    java.lang.Double perc_comissao =  null;
                    java.lang.Double fob =  null;
                    java.lang.Double valor_comissao =  null;
                    java.lang.Double fob_liquido =  null;
                    java.lang.String nome_despachante =  null;
                    java.lang.Double valor_unitario =  null;
                    java.lang.String dde =  null;
                    java.lang.String descricao_produto =  null;
                    java.lang.String produto =  null;
                    List<util.consultas.com.RegistroExportacao.ComponenteConsumo> rCabecalho = null;
                    for(util.consultas.com.RegistroExportacao.Registro tCabecalho : res_Jw_registros_exportacao){
                      rCabecalho = tCabecalho.getListaComponenteConsumo();
                      break;
                    }
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align: center; " >
                        Nr. Re.
                      </td>

                      <td class="columnTdHeader" style="text-align: center; " >
                        Nr. Drawback
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Dt. Embarque
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Dt. Averbação
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Fatura
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        NCM
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Pares
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Perc. Comissão
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Fob
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Vlr. Comissão
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Fob Líq.
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Filial
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Despachante
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Vlr. Unit.
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        DDE
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição Produto
                      </td>

                      <td class="columnTdHeader" style="text-align: left;">
                        <div style="width: 300px;">
                          Produto
                        </div>
                      </td>

                      <%
                      for(util.consultas.com.RegistroExportacao.ComponenteConsumo consumo : rCabecalho){
                        %>
                        <td class="columnTdHeader" style="text-align:center;" >
                          <%= consumo.getComponente() %>
                        </td>
                        <%
                      }
                      %>

                    </tr>

                    <%
                    int i_bl_report_Jw_registros_exportacao = 0;
                    for(util.consultas.com.RegistroExportacao.Registro t_jw_registros_exportacao : res_Jw_registros_exportacao){
                      numero_re = t_jw_registros_exportacao.getNumeroRe()==null?"":t_jw_registros_exportacao.getNumeroRe();
                      numero_drawback = t_jw_registros_exportacao.getNumeroDrawback()==null?"":t_jw_registros_exportacao.getNumeroDrawback();
                      fil_filial = t_jw_registros_exportacao.getFilFilial()==null?"":t_jw_registros_exportacao.getFilFilial();
                      data_embarque = (java.sql.Date)t_jw_registros_exportacao.getDataEmbarque();
                      data_averbacao = (java.sql.Date)t_jw_registros_exportacao.getDataAverbacao();
                      fatura = (t_jw_registros_exportacao.getAnoFatura())+"/"+(t_jw_registros_exportacao.getNumeroFatura());
                      ncm = t_jw_registros_exportacao.getNcm()==null?"":t_jw_registros_exportacao.getNcm();
                      pares = t_jw_registros_exportacao.getPares();
                      perc_comissao = t_jw_registros_exportacao.getPercComissao();//==null?"":t_jw_registros_exportacao.getPercComissao();
                      fob = t_jw_registros_exportacao.getFob();
                      valor_comissao = t_jw_registros_exportacao.getValorComissao();
                      fob_liquido = t_jw_registros_exportacao.getFobLiquido();
                      nome_despachante = t_jw_registros_exportacao.getNomeDespachante()==null?"":t_jw_registros_exportacao.getNomeDespachante();
                      valor_unitario = t_jw_registros_exportacao.getValorUnitario();
                      dde = t_jw_registros_exportacao.getDde()==null?"":t_jw_registros_exportacao.getDde();
                      descricao_produto = t_jw_registros_exportacao.getDescricaoProduto()==null?"":t_jw_registros_exportacao.getDescricaoProduto();
                      produto = t_jw_registros_exportacao.getProduto()==null?"":t_jw_registros_exportacao.getProduto();
                      String style_bl_report_Jw_registros_exportacao="";
                      if (!((i_bl_report_Jw_registros_exportacao%2)!=0)) {
                        style_bl_report_Jw_registros_exportacao="rowColor";
                      } else {
                        style_bl_report_Jw_registros_exportacao="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_registros_exportacao %>' id="TRbl_report_Jw_registros_exportacao<%=i_bl_report_Jw_registros_exportacao%>" >
                        <td class="reportColumn" style="text-align:center;" width="500px" >
                          <%= numero_re %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= numero_drawback %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_embarque, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_averbacao, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= fatura %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= ncm %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(pares, "##,##0") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= perc_comissao %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(fob, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(valor_comissao, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(fob_liquido, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= fil_filial %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= nome_despachante %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(valor_unitario, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= dde %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= descricao_produto %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" width="500px" >
                          <%= produto %>
                        </td>

                        <%
                        for(util.consultas.com.RegistroExportacao.ComponenteConsumo consumo : t_jw_registros_exportacao.getListaComponenteConsumo()){
                          %>
                          <td class="reportColumn" style="text-align: right;" >
                            <%= com.egen.util.text.FormatNumber.format(consumo.getConsumo(), "##,##0.000000") %>
                          </td>
                          <%
                        }
                        %>

                      </tr>

                      <%
                      i_bl_report_Jw_registros_exportacao  ++;
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

            <html:form action="com/RegistroExportacao_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
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

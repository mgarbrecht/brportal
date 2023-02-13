<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta Necessidade Líquida
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(112)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            {
              int maxPageItems = 0;
              if(!(request.getParameter("excel")+"").equals("true")){
                maxPageItems = 22;
              } else {
                maxPageItems = 99999;
              }
              %>

              <%
              java.util.Vector res_NecessidadeLiquida = (java.util.Vector)session.getAttribute("res_NecessidadeLiquida");
              portalbr.com.NecessLiquidaActionForm NecessLiquidaActionForm = (portalbr.com.NecessLiquidaActionForm)session.getAttribute("NecessLiquidaActionForm");
              %>

              <%
              if (res_NecessidadeLiquida!=null && res_NecessidadeLiquida.size()>0) {
                %>

                <pg:pager id="bl_report_NecessidadeLiquida" items="<%=res_NecessidadeLiquida.size()%>" index="center" maxPageItems="<%= maxPageItems %>" maxIndexPages="5" scope="request" export="offset,currentPageNumber=pageNumber" >
                  <table id="TRbl_report_NecessidadeLiquida"  class="reportTable"   style="width:99%; "  border="1"  frame="box">
                    <%
                    java.lang.Double ies_codigo =  null;
                    java.lang.String ies_descricao =  null;
                    java.lang.String unm_codigo =  null;
                    java.lang.Double cor_cdgo =  null;
                    java.lang.String cor_desc =  null;
                    java.lang.String tai_codigo =  null;
                    java.lang.String nomeclatura =  null;
                    java.lang.Double entrada_retroativa =  null;
                    java.lang.Double entrada_retroativa2 =  null;
                    java.lang.Double oc =  null;
                    java.lang.Double consumo =  null;
                    java.lang.String venda_dia =  null;
                    java.lang.Double consumo_anterior =  null;
                    java.lang.Double ocsemana1 =  null;
                    java.lang.Double pedsemana1 =  null;
                    java.lang.Double ocsemana2 =  null;
                    java.lang.Double pedsemana2 =  null;
                    java.lang.Double ocsemana3 =  null;
                    java.lang.Double pedsemana3 =  null;
                    java.lang.Double ocsemana4 =  null;
                    java.lang.Double pedsemana4 =  null;
                    java.lang.Double ocmes1 =  null;
                    java.lang.Double pedmes1 =  null;
                    java.lang.Double ocmes2 =  null;
                    java.lang.Double pedmes2 =  null;
                    java.lang.Double ocmes3 =  null;
                    java.lang.Double pedmes3 =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;">
                        Item
                      </td>

                      <td class="columnTdHeader" style="text-align:left;">
                      </td>
                      <td class="columnTdHeader" style="text-align:left;">
                        UM
                      </td>
                      <td class="columnTdHeader" style="text-align:right;">
                        Cor
                      </td>
                      <td class="columnTdHeader" style="text-align:left;">
                      </td>
                      <td class="columnTdHeader" style="text-align:right;">
                        Tam.
                      </td>
                      <%
                      if(NecessLiquidaActionForm.getTipo().equals("s")) {
                        %>
                        <td class="columnTdHeader" style="text-align:left;">
                          Nomenclatura
                        </td>
                        <%
                      }
                      %>
                      <td class="columnTdHeader" style="text-align:right;">
                        Média Semana1
                      </td>
                      <td class="columnTdHeader" style="text-align:right;">
                        Média Semana2
                      </td>
                      <td class="columnTdHeader" style="text-align:right;">
                        OC Geral
                      </td>
                      <td class="columnTdHeader" style="text-align:right;">
                        Pedido Geral
                      </td>
                      <td class="columnTdHeader" style="text-align:right;">
                        Venda Dia
                      </td>
                      <%
                      if(NecessLiquidaActionForm.getTipo().equals("a")) {
                        %>
                        <td class="columnTdHeader" style="text-align:right;">
                          OC Sem1
                        </td>
                        <td class="columnTdHeader" style="text-align:right;">
                          Ped. Sem1
                        </td>
                        <td class="columnTdHeader" style="text-align:right;">
                          OC Sem2
                        </td>
                        <td class="columnTdHeader" style="text-align:right;">
                          Ped. Sem2
                        </td>
                        <td class="columnTdHeader" style="text-align:right;">
                          OC Sem3
                        </td>
                        <td class="columnTdHeader" style="text-align:right;">
                          Ped. Sem3
                        </td>
                        <td class="columnTdHeader" style="text-align:right;">
                          OC Sem4
                        </td>
                        <td class="columnTdHeader" style="text-align:right;">
                          Ped. Sem4
                        </td>
                        <td class="columnTdHeader" style="text-align:right;">
                          OC Mês1
                        </td>
                        <td class="columnTdHeader" style="text-align:right;">
                          Ped. Mês1
                        </td>
                        <%
                      }
                      %>
                    </tr>

                    <%
                    int i_bl_report_NecessidadeLiquida = 0;
                    while (i_bl_report_NecessidadeLiquida<res_NecessidadeLiquida.size()) {
                      portalbr.dbobj.view.Necessidadeliquida t_necessidadeliquida = (portalbr.dbobj.view.Necessidadeliquida)res_NecessidadeLiquida.elementAt(i_bl_report_NecessidadeLiquida);
                      ies_codigo = t_necessidadeliquida.getIes_codigo();
                      ies_descricao = t_necessidadeliquida.getIes_descricao()==null?"":t_necessidadeliquida.getIes_descricao();
                      unm_codigo = t_necessidadeliquida.getUnm_codigo()==null?"":t_necessidadeliquida.getUnm_codigo();
                      cor_cdgo = t_necessidadeliquida.getCor_cdgo();
                      cor_desc = t_necessidadeliquida.getCor_desc()==null?"":t_necessidadeliquida.getCor_desc();
                      tai_codigo = t_necessidadeliquida.getTai_codigo()==null?"":t_necessidadeliquida.getTai_codigo();
                      nomeclatura = t_necessidadeliquida.getNomeclatura()==null?"":t_necessidadeliquida.getNomeclatura();
                      entrada_retroativa = t_necessidadeliquida.getEntrada_retroativa();
                      entrada_retroativa2 = t_necessidadeliquida.getEntrada_retroativa2();
                      oc = t_necessidadeliquida.getOc();
                      consumo = t_necessidadeliquida.getConsumo();
                      venda_dia = t_necessidadeliquida.getVenda_dia()==null?"":t_necessidadeliquida.getVenda_dia();
                      consumo_anterior = t_necessidadeliquida.getConsumo_anterior();
                      ocsemana1 = t_necessidadeliquida.getOcsemana1();
                      pedsemana1 = t_necessidadeliquida.getPedsemana1();
                      ocsemana2 = t_necessidadeliquida.getOcsemana2();
                      pedsemana2 = t_necessidadeliquida.getPedsemana2();
                      ocsemana3 = t_necessidadeliquida.getOcsemana3();
                      pedsemana3 = t_necessidadeliquida.getPedsemana3();
                      ocsemana4 = t_necessidadeliquida.getOcsemana4();
                      pedsemana4 = t_necessidadeliquida.getPedsemana4();
                      ocmes1 = t_necessidadeliquida.getOcmes1();
                      pedmes1 = t_necessidadeliquida.getPedmes1();
                      ocmes2 = t_necessidadeliquida.getOcmes2();
                      pedmes2 = t_necessidadeliquida.getPedmes2();
                      ocmes3 = t_necessidadeliquida.getOcmes3();
                      pedmes3 = t_necessidadeliquida.getPedmes3();
                      String style_bl_report_NecessidadeLiquida="";
                      if (!((i_bl_report_NecessidadeLiquida%2)!=0)) {
                        style_bl_report_NecessidadeLiquida="rowColor";
                      } else {
                        style_bl_report_NecessidadeLiquida="rowBlank";
                      }
                      %>

                      <pg:item>
                        <tr class='<%= style_bl_report_NecessidadeLiquida %>' id="TRbl_report_NecessidadeLiquida<%=i_bl_report_NecessidadeLiquida%>" >
                          <td class="reportColumn" style="text-align:right;font-size:9;">
                            <%= com.egen.util.text.FormatNumber.format(ies_codigo, "0") %>
                          </td>
                          <td class="reportColumn" style="text-align:left;width:220pt;font-size:9;">
                            <%= ies_descricao %>
                          </td>
                          <td class="reportColumn" style="text-align:left;font-size:9;">
                            <%= unm_codigo %>
                          </td>
                          <td class="reportColumn" style="text-align:right;font-size:9;">
                            <%= com.egen.util.text.FormatNumber.format(cor_cdgo, "0") %>
                          </td>
                          <td class="reportColumn" style="text-align:left;width:100pt;font-size:9;">
                            <%= cor_desc %>
                          </td>
                          <td class="reportColumn" style="text-align:right;font-size:9;">
                            <%= tai_codigo %>
                          </td>
                          <%
                          if(NecessLiquidaActionForm.getTipo().equals("s")) {
                            %>
                            <td class="reportColumn" style="text-align:left;font-size:9;">
                              <%= nomeclatura %>
                            </td>
                            <%
                          }
                          %>
                          <td class="reportColumn" style="text-align:right;font-size:9;">
                            <%= com.egen.util.text.FormatNumber.format(entrada_retroativa, "#,##0.##") %>
                          </td>
                          <td class="reportColumn" style="text-align:right;font-size:9;">
                            <%= com.egen.util.text.FormatNumber.format(entrada_retroativa2, "#,##0.##") %>
                          </td>
                          <td class="reportColumn" style="text-align:right;font-size:9;">
                            <%= ((oc!=null)?oc.toString():"") %>
                          </td>
                          <td class="reportColumn" style="text-align:right;font-size:9;">
                            <%= ((consumo!=null)?consumo.toString():"") %>
                          </td>
                          <td class="reportColumn" style="text-align:right;font-size:9;">
                            <%= venda_dia %>
                          </td>
                          <%
                          if(NecessLiquidaActionForm.getTipo().equals("a")) {
                            %>
                            <td class="reportColumn" style="text-align:right;font-size:9;">
                              <%= ((ocsemana1!=null)?ocsemana1.toString():"") %>
                            </td>
                            <td class="reportColumn" style="text-align:right;font-size:9;">
                              <%= ((pedsemana1!=null)?pedsemana1.toString():"") %>
                            </td>
                            <td class="reportColumn" style="text-align:right;font-size:9;">
                              <%= ((ocsemana2!=null)?ocsemana2.toString():"") %>
                            </td>
                            <td class="reportColumn" style="text-align:right;font-size:9;">
                              <%= ((pedsemana2!=null)?pedsemana2.toString():"") %>
                            </td>
                            <td class="reportColumn" style="text-align:right;font-size:9;">
                              <%= ((ocsemana3!=null)?ocsemana3.toString():"") %>
                            </td>
                            <td class="reportColumn" style="text-align:right;font-size:9;">
                              <%= ((pedsemana3!=null)?pedsemana3.toString():"") %>
                            </td>
                            <td class="reportColumn" style="text-align:right;font-size:9;">
                              <%= ((ocsemana4!=null)?ocsemana4.toString():"") %>
                            </td>
                            <td class="reportColumn" style="text-align:right;font-size:9;">
                              <%= ((pedsemana4!=null)?pedsemana4.toString():"") %>
                            </td>
                            <td class="reportColumn" style="text-align:right;font-size:9;">
                              <%= ((ocmes1!=null)?ocmes1.toString():"") %>
                            </td>
                            <td class="reportColumn" style="text-align:right;font-size:9;">
                              <%= ((pedmes1!=null)?pedmes1.toString():"") %>
                            </td>
                            <%
                          }
                          %>

                        </tr>

                      </pg:item>
                      <%
                      i_bl_report_NecessidadeLiquida++;
                      if (i_bl_report_NecessidadeLiquida<res_NecessidadeLiquida.size()) {
                        t_necessidadeliquida = (portalbr.dbobj.view.Necessidadeliquida)res_NecessidadeLiquida.elementAt(i_bl_report_NecessidadeLiquida);
                        ies_codigo = t_necessidadeliquida.getIes_codigo();
                        ies_descricao = t_necessidadeliquida.getIes_descricao()==null?"":t_necessidadeliquida.getIes_descricao();
                        unm_codigo = t_necessidadeliquida.getUnm_codigo()==null?"":t_necessidadeliquida.getUnm_codigo();
                        cor_cdgo = t_necessidadeliquida.getCor_cdgo();
                        cor_desc = t_necessidadeliquida.getCor_desc()==null?"":t_necessidadeliquida.getCor_desc();
                        tai_codigo = t_necessidadeliquida.getTai_codigo()==null?"":t_necessidadeliquida.getTai_codigo();
                        nomeclatura = t_necessidadeliquida.getNomeclatura()==null?"":t_necessidadeliquida.getNomeclatura();
                        entrada_retroativa = t_necessidadeliquida.getEntrada_retroativa();
                        entrada_retroativa2 = t_necessidadeliquida.getEntrada_retroativa2();
                        oc = t_necessidadeliquida.getOc();
                        consumo = t_necessidadeliquida.getConsumo();
                        venda_dia = t_necessidadeliquida.getVenda_dia()==null?"":t_necessidadeliquida.getVenda_dia();
                        consumo_anterior = t_necessidadeliquida.getConsumo_anterior();
                        ocsemana1 = t_necessidadeliquida.getOcsemana1();
                        pedsemana1 = t_necessidadeliquida.getPedsemana1();
                        ocsemana2 = t_necessidadeliquida.getOcsemana2();
                        pedsemana2 = t_necessidadeliquida.getPedsemana2();
                        ocsemana3 = t_necessidadeliquida.getOcsemana3();
                        pedsemana3 = t_necessidadeliquida.getPedsemana3();
                        ocsemana4 = t_necessidadeliquida.getOcsemana4();
                        pedsemana4 = t_necessidadeliquida.getPedsemana4();
                        ocmes1 = t_necessidadeliquida.getOcmes1();
                        pedmes1 = t_necessidadeliquida.getPedmes1();
                        ocmes2 = t_necessidadeliquida.getOcmes2();
                        pedmes2 = t_necessidadeliquida.getPedmes2();
                        ocmes3 = t_necessidadeliquida.getOcmes3();
                        pedmes3 = t_necessidadeliquida.getPedmes3();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <pg:index id="bl_report_NecessidadeLiquida" >
                    <table class="pageNavigatorTable" width="100%" cellpadding="2" cellspacing="0" border="0" bgcolor="#e3e9f8">
                      <tr class="pageNavigatorTr" >
                        <td class="pageNavigatorTd">
                          <font face="verdana" color="#aaaaaa" size="-1">
                            <pg:prev export="pageUrl" ifnull="<%= true %>">
                              <%
                              if (pageUrl == null) {
                                %>
                                <b>
                                  « Anterior
                                </b>
                                <%
                              } else {
                                %>
                                <font color="#ff0000">
                                  <b>
                                    «
                                  </b>
                                </font>
                                <a href="<%= pageUrl %>">
                                  <b>
                                    Anterior
                                  </b>
                                </a>
                                <%
                              }
                              %>
                            </pg:prev>
                             
                            <pg:pages export="pageUrl,firstItem,lastItem">
                              <a href="<%= pageUrl %>">
                                <b>
                                  <%= firstItem %>
                                  a
                                  <%= lastItem %>
                                </b>
                              </a>
                               
                            </pg:pages>
                             
                            <pg:next export="pageUrl" ifnull="<%= true %>">
                              <%
                              if (pageUrl == null) {
                                %>
                                <b>
                                  Próximo »
                                </b>
                                <%
                              } else {
                                %>
                                <a href="<%= pageUrl %>">
                                  <b>
                                    Próximo
                                  </b>
                                </a>
                                <font color="#ff0000">
                                  <b>
                                    »
                                  </b>
                                </font>
                                <%
                              }
                              %>
                            </pg:next>
                          </td>
                        </tr>
                      </table>

                    </pg:index>
                  </pg:pager>
                  <%
                }
                %>

                <%
              }
              %>
              <html:form action="com/NecessLiquidaReport.do" method="post" styleClass="baseForm">
                <table class="itemTable"  style=" width:;">
                  <html:hidden property="tipo"/>
                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <html:submit accesskey="a" styleClass="baseButton" property="back_sintetico_action">
                            <bean:message bundle="ApplicationResources" key="jsp.back"/>
                          </html:submit>
                          <%
                        }
                        %>
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <html:button value="Gerar Relatório Para Impressão" onclick="window.open('NecessidadeLiquidaPDFReport.do?&tipo='+tipo.value,'_blank');" styleClass="baseButton" property="imprimir_action">
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

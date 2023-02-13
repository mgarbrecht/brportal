<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Posição de Faltas do Fornecedor
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(8)){
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
              java.util.Vector res_Jw_abastecimento_materiais = (java.util.Vector)session.getAttribute("res_Jw_abastecimento_materiais");
              %>

              <form  name="bl_report_Jw_abastecimento_materiais" id="bl_report_Jw_abastecimento_materiais" class="baseForm" method="post" >
                <%
                if (res_Jw_abastecimento_materiais!=null && res_Jw_abastecimento_materiais.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_abastecimento_materiais"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Long fornecedor_codigo =  null;
                    java.lang.Integer fen_seq =  null;
                    java.lang.Long codigo =  null;
                    java.lang.String descricao =  null;
                    java.lang.String unm_codigo =  null;
                    java.lang.Integer cor_cdgo =  null;
                    java.lang.String cor_desc =  null;
                    java.lang.Double saldo =  null;
                    java.lang.String relatorio_fornecedor =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Item
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        UM
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Cor
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Saldo
                      </td>

                      <%
                      if(!(request.getParameter("excel")+"").equals("true")) {
                        %>

                        <td  class="columnTdHeader" style="text-align:left;" >
                          <!--
                            <table border="0" width="500px" class="reportTable1"> <tr class="reportTr"> <td class="columnTdHeader" width="100px" style="text-align: right"> Qtde. Trânsito </td> <td class="columnTdHeader" width="100px" style="text-align: right"> Qtde. Atraso </td> <td class="columnTdHeader" width="100px" style="text-align: center"> Dt. Entrega </td> <td class="columnTdHeader" width="200px" style="text-align: center"> </td> </tr> </table>
                          -->
                        </td>
                        <%
                      }
                      %>
                    </tr>

                    <%
                    int i_bl_report_Jw_abastecimento_materiais = 0;
                    while (i_bl_report_Jw_abastecimento_materiais<res_Jw_abastecimento_materiais.size()) {
                      portalbr.dbobj.view.Jw_abastecimento_materiais t_jw_abastecimento_materiais = (portalbr.dbobj.view.Jw_abastecimento_materiais)res_Jw_abastecimento_materiais.elementAt(i_bl_report_Jw_abastecimento_materiais);
                      fornecedor_codigo = t_jw_abastecimento_materiais.getFornecedor_codigo();
                      fen_seq = t_jw_abastecimento_materiais.getFen_seq();
                      codigo = t_jw_abastecimento_materiais.getCodigo();
                      descricao = t_jw_abastecimento_materiais.getDescricao()==null?"":t_jw_abastecimento_materiais.getDescricao();
                      unm_codigo = t_jw_abastecimento_materiais.getUnm_codigo()==null?"":t_jw_abastecimento_materiais.getUnm_codigo();
                      cor_cdgo = t_jw_abastecimento_materiais.getCor_cdgo();
                      cor_desc = t_jw_abastecimento_materiais.getCor_desc()==null?"":t_jw_abastecimento_materiais.getCor_desc();
                      saldo = t_jw_abastecimento_materiais.getSaldo();
                      String style_bl_report_Jw_abastecimento_materiais="";
                      if (!((i_bl_report_Jw_abastecimento_materiais%2)!=0)) {
                        style_bl_report_Jw_abastecimento_materiais="rowColor";
                      } else {
                        style_bl_report_Jw_abastecimento_materiais="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_abastecimento_materiais %>' id="TRbl_report_Jw_abastecimento_materiais<%=i_bl_report_Jw_abastecimento_materiais%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((codigo!=null)?codigo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= descricao %>
                        </td>

                        <td class="reportColumn" style="text-align:center;width:1%;" >
                          <%= unm_codigo %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((cor_cdgo!=null)?cor_cdgo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cor_desc %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(saldo, "##,##0.00") %>
                        </td>

                        <%
                        if(!(request.getParameter("excel")+"").equals("true")) {
                          %>
                          <td class="reportColumn" style="text-align:left;width:400px;" >
                            <div class="subReport"  id="sr_<%=i_bl_report_Jw_abastecimento_materiais%>">
                              <jsp:include flush="true" page="../ind/AbastecimentoMateriais_rfForm.jsp">
                                <jsp:param name="fornecedor_codigo" value="<%= fornecedor_codigo %>" />
                                <jsp:param name="fen_seq" value="<%= fen_seq %>" />
                                <jsp:param name="codigo" value="<%= codigo %>" />
                                <jsp:param name="cor_cdgo" value="<%= cor_cdgo %>" />
                                <jsp:param name="saldo" value="<%= saldo %>" />
                              </jsp:include>
                            </div>

                          </td>

                          <%
                        }
                        %>

                      </tr>

                      <%
                      i_bl_report_Jw_abastecimento_materiais++;
                      if (i_bl_report_Jw_abastecimento_materiais<res_Jw_abastecimento_materiais.size()) {
                        t_jw_abastecimento_materiais = (portalbr.dbobj.view.Jw_abastecimento_materiais)res_Jw_abastecimento_materiais.elementAt(i_bl_report_Jw_abastecimento_materiais);
                        fornecedor_codigo = t_jw_abastecimento_materiais.getFornecedor_codigo();
                        fen_seq = t_jw_abastecimento_materiais.getFen_seq();
                        codigo = t_jw_abastecimento_materiais.getCodigo();
                        descricao = t_jw_abastecimento_materiais.getDescricao()==null?"":t_jw_abastecimento_materiais.getDescricao();
                        unm_codigo = t_jw_abastecimento_materiais.getUnm_codigo()==null?"":t_jw_abastecimento_materiais.getUnm_codigo();
                        cor_cdgo = t_jw_abastecimento_materiais.getCor_cdgo();
                        cor_desc = t_jw_abastecimento_materiais.getCor_desc()==null?"":t_jw_abastecimento_materiais.getCor_desc();
                        saldo = t_jw_abastecimento_materiais.getSaldo();
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

            <html:form action="ind/AbastecimentoMateriais_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <html:hidden property="id"/>
                <%
                if(request.getParameter("ok") != null) {
                  %>
                  <script>
                    //   alert('Operação realizada com sucesso!');
                  </script>
                  <%
                }
                %>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:submit>
                    <html:submit accesskey="a" styleClass="myhidden" property="delete_action">
                      <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="refresh_action">
                      <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
                    </html:submit>
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

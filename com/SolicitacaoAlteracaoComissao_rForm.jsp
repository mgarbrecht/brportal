<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Solicitação de Alteração de Comissão - Relatório
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(202)){
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
              java.util.Vector res_Solicita_prorrogacao = (java.util.Vector)session.getAttribute("res_Solicita_prorrogacao");
              %>

              <form  name="bl_report_Solicita_prorrogacao" id="bl_report_Solicita_prorrogacao" class="baseForm" method="post" >
                <%
                if (res_Solicita_prorrogacao!=null && res_Solicita_prorrogacao.size()>0) {
                  %>

                  <table id="TRbl_report_Solicita_prorrogacao"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Integer id_solicitacao =  null;
                    java.lang.Integer nfs_nmro =  null;
                    java.lang.String nfs_serie =  null;
                    java.lang.String emp_empresa =  null;
                    java.lang.String fil_filial =  null;
                    java.lang.Integer nro_dias_prorrogacao =  null;
                    java.lang.Double valor_calculado =  null;
                    java.lang.Double comissao_nova =  null;
                    java.lang.Double valor_calculado1 =  null;
                    java.sql.Timestamp data_solicitacao =  null;
                    java.lang.String usuario_solicitacao =  null;
                    java.sql.Timestamp data_aprovacao =  null;
                    java.lang.String usuario_aprovacao =  null;
                    java.lang.String situacao =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        ID
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Nota
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Série
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Empresa
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Filial
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Dias Prorrogação
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Valor
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Comissão Nova
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Valor Abatimento
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Dt. Solicitação
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Usuário Solicitação
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Dt .Aprovação
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Usuário Aprovação
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Situação
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Solicita_prorrogacao = 0;
                    while (i_bl_report_Solicita_prorrogacao<res_Solicita_prorrogacao.size()) {
                      portalbr.dbobj.table.Solicita_prorrogacao t_solicita_prorrogacao = (portalbr.dbobj.table.Solicita_prorrogacao)res_Solicita_prorrogacao.elementAt(i_bl_report_Solicita_prorrogacao);
                      id_solicitacao = t_solicita_prorrogacao.getId_solicitacao();
                      nfs_nmro = t_solicita_prorrogacao.getNfs_nmro();
                      nfs_serie = t_solicita_prorrogacao.getNfs_serie()==null?"":t_solicita_prorrogacao.getNfs_serie();
                      emp_empresa = t_solicita_prorrogacao.getEmp_empresa()==null?"":t_solicita_prorrogacao.getEmp_empresa();
                      fil_filial = t_solicita_prorrogacao.getFil_filial()==null?"":t_solicita_prorrogacao.getFil_filial();
                      nro_dias_prorrogacao = t_solicita_prorrogacao.getNro_dias_prorrogacao();
                      valor_calculado = t_solicita_prorrogacao.getValor_calculado();
                      comissao_nova = t_solicita_prorrogacao.getComissao_nova();
                      valor_calculado1 = t_solicita_prorrogacao.getValor_calculado();
                      data_solicitacao = (java.sql.Timestamp)t_solicita_prorrogacao.getData_solicitacao();
                      usuario_solicitacao = t_solicita_prorrogacao.getUsuario_solicitacao()==null?"":t_solicita_prorrogacao.getUsuario_solicitacao();
                      data_aprovacao = (java.sql.Timestamp)t_solicita_prorrogacao.getData_aprovacao();
                      usuario_aprovacao = t_solicita_prorrogacao.getUsuario_aprovacao()==null?"":t_solicita_prorrogacao.getUsuario_aprovacao();
                      situacao = t_solicita_prorrogacao.getSituacao()==null?"":t_solicita_prorrogacao.getSituacao();
                      String style_bl_report_Solicita_prorrogacao="";
                      if (!((i_bl_report_Solicita_prorrogacao%2)!=0)) {
                        style_bl_report_Solicita_prorrogacao="rowColor";
                      } else {
                        style_bl_report_Solicita_prorrogacao="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Solicita_prorrogacao %>' id="TRbl_report_Solicita_prorrogacao<%=i_bl_report_Solicita_prorrogacao%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((id_solicitacao!=null)?id_solicitacao.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((nfs_nmro!=null)?nfs_nmro.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= nfs_serie %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= emp_empresa %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= fil_filial %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((nro_dias_prorrogacao!=null)?nro_dias_prorrogacao.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= nro_dias_prorrogacao==null?"":com.egen.util.text.FormatNumber.format(valor_calculado, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(comissao_nova, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= nro_dias_prorrogacao!=null?"":com.egen.util.text.FormatNumber.format(valor_calculado1, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_solicitacao, "dd/MM/yyyy HH:mm:ss") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= usuario_solicitacao %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_aprovacao, "dd/MM/yyyy HH:mm:ss") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= usuario_aprovacao %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%
                        if(situacao.equals("P")){situacao = "Pendente";}
                      if(situacao.equals("A")){situacao = "Aprovado";}
                    if(situacao.equals("R")){situacao = "Reprovado";}
                  if(situacao.equals("L")){situacao = "Lançado";}
                  %>
                  <%= situacao %>
                </td>
              </tr>

              <%
              i_bl_report_Solicita_prorrogacao++;
              if (i_bl_report_Solicita_prorrogacao<res_Solicita_prorrogacao.size()) {
                t_solicita_prorrogacao = (portalbr.dbobj.table.Solicita_prorrogacao)res_Solicita_prorrogacao.elementAt(i_bl_report_Solicita_prorrogacao);
                id_solicitacao = t_solicita_prorrogacao.getId_solicitacao();
                nfs_nmro = t_solicita_prorrogacao.getNfs_nmro();
                nfs_serie = t_solicita_prorrogacao.getNfs_serie()==null?"":t_solicita_prorrogacao.getNfs_serie();
                emp_empresa = t_solicita_prorrogacao.getEmp_empresa()==null?"":t_solicita_prorrogacao.getEmp_empresa();
                fil_filial = t_solicita_prorrogacao.getFil_filial()==null?"":t_solicita_prorrogacao.getFil_filial();
                nro_dias_prorrogacao = t_solicita_prorrogacao.getNro_dias_prorrogacao();
                valor_calculado = t_solicita_prorrogacao.getValor_calculado();
                comissao_nova = t_solicita_prorrogacao.getComissao_nova();
                valor_calculado1 = t_solicita_prorrogacao.getValor_calculado();
                data_solicitacao = (java.sql.Timestamp)t_solicita_prorrogacao.getData_solicitacao();
                usuario_solicitacao = t_solicita_prorrogacao.getUsuario_solicitacao()==null?"":t_solicita_prorrogacao.getUsuario_solicitacao();
                data_aprovacao = (java.sql.Timestamp)t_solicita_prorrogacao.getData_aprovacao();
                usuario_aprovacao = t_solicita_prorrogacao.getUsuario_aprovacao()==null?"":t_solicita_prorrogacao.getUsuario_aprovacao();
                situacao = t_solicita_prorrogacao.getSituacao()==null?"":t_solicita_prorrogacao.getSituacao();
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

    <html:form action="com/SolicitacaoAlteracaoComissao_rForm.do" method="post" styleClass="baseForm">
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
            <html:submit accesskey="b" styleClass="baseButton" property="back_action">
              <bean:message bundle="ApplicationResources" key="jsp.back"/>
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

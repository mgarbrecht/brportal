<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Aprovação de Alteração de Comissão
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
                </td>

              </tr>

            </table>

            <html:form action="com/AprovacaoAlteracaoComissao_pForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="id_solicitacao"/>
                    <html:errors property="valor_lancamento"/>
                    <html:errors property="motivo"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Solicita_prorrog_lancamentos"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String usuario = null;
                acesso.Sessao sessao = new acesso.Sessao(session);
                usuario = sessao.getUsuario();
                %>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      ID
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="id_solicitacao" styleId="id_solicitacao" styleClass="disabled" tabindex="-1" readonly="true" value="<%= request.getParameter("id_solicitacao") %>" size="10" maxlength="22"/>
                  </td>
                </tr>

                <html:hidden property="id_lancamento"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Valor
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="valor_lancamento" styleId="valor_lancamento" styleClass="baseField" size="22" maxlength="22"/>
                  </td>
                </tr>

                <html:hidden property="data_lancamento"/>
                <html:hidden property="usuario_lancamento" value="<%= usuario %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Motivo
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="motivo" styleId="motivo" styleClass="baseField" size="60" maxlength="200"/>
                  </td>
                </tr>

                <%
                if(request.getAttribute("aprovado")!= null){
                  %>
                  <script>
                    alert('Solicitação foi aprovada!');
                    opener.document.forms[1].refresh_action.click();
                    javascript:window.close();
                  </script>

                  <%
                }
                %>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="i" onclick="opener.document.forms[1].refresh_action.click();" styleClass="baseButton" property="insert_action">
                      <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="p" value="pop" styleClass="myhidden" property="pop_action">
                    </html:submit>
                    <html:button accesskey="f" onclick="opener.document.forms[1].refresh_action.click();javascript:window.close();" styleClass="baseButton" property="close1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["valor_lancamento"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Solicita_prorrog_lancamentos = null;
              portalbr.com.AprovacaoAlteracaoComissao_pActionForm AprovacaoAlteracaoComissao_pActionForm = (portalbr.com.AprovacaoAlteracaoComissao_pActionForm)session.getAttribute("AprovacaoAlteracaoComissao_pActionForm");
              if(AprovacaoAlteracaoComissao_pActionForm!=null && (AprovacaoAlteracaoComissao_pActionForm.getId_solicitacao()!=null && AprovacaoAlteracaoComissao_pActionForm.getId_solicitacao().length()>0)) {
                com.egen.util.jdbc.JdbcUtil j = null;
                try {
                  j = new com.egen.util.jdbc.JdbcUtil();
                  portalbr.dbobj.table.Solicita_prorrog_lancamentos t_solicita_prorrog_lancamentos = new portalbr.dbobj.table.Solicita_prorrog_lancamentos();
                  String[][] select = {{"id_solicitacao",null},{"id_lancamento",null},{"valor_lancamento",null},{"data_lancamento",null},{"usuario_lancamento",null},{"motivo",null},};
                  Object[][] where = null;
                  where = new Object[][]{{"id_solicitacao","=",com.egen.util.text.FormatNumber.toInteger(AprovacaoAlteracaoComissao_pActionForm.getId_solicitacao())}};
                  String[] groupby =  null;
                  String[] having =  null;
                  String[] order =  null;
                  res_Solicita_prorrog_lancamentos = j.select(t_solicita_prorrog_lancamentos,select,where,groupby,having,order);
                } catch (Exception e){
                  res_Solicita_prorrog_lancamentos = null;
                } finally {
                if(j!=null){j.close();}
              }
            } else {
              res_Solicita_prorrog_lancamentos = null;
            }
            %>

            <form  name="bl_report_Solicita_prorrog_lancamentos" id="bl_report_Solicita_prorrog_lancamentos" class="baseForm" method="post" >
              <%
              if (res_Solicita_prorrog_lancamentos!=null && res_Solicita_prorrog_lancamentos.size()>0) {
                %>

                <table id="TRbl_report_Solicita_prorrog_lancamentos"  class="reportTable"   style="width:99%; "  >
                  <%
                  java.lang.Integer id_solicitacao =  null;
                  java.lang.Integer id_lancamento =  null;
                  java.lang.Double valor_lancamento =  null;
                  java.sql.Timestamp data_lancamento =  null;
                  java.lang.String usuario_lancamento =  null;
                  java.lang.String motivo =  null;
                  double sum_valor_lancamento_0 = 0;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:right;" >
                      ID
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Valor
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      Data
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Usuário
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Motivo
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Solicita_prorrog_lancamentos = 0;
                  while (i_bl_report_Solicita_prorrog_lancamentos<res_Solicita_prorrog_lancamentos.size()) {
                    portalbr.dbobj.table.Solicita_prorrog_lancamentos t_solicita_prorrog_lancamentos = (portalbr.dbobj.table.Solicita_prorrog_lancamentos)res_Solicita_prorrog_lancamentos.elementAt(i_bl_report_Solicita_prorrog_lancamentos);
                    id_solicitacao = t_solicita_prorrog_lancamentos.getId_solicitacao();
                    id_lancamento = t_solicita_prorrog_lancamentos.getId_lancamento();
                    valor_lancamento = t_solicita_prorrog_lancamentos.getValor_lancamento();
                    data_lancamento = (java.sql.Timestamp)t_solicita_prorrog_lancamentos.getData_lancamento();
                    usuario_lancamento = t_solicita_prorrog_lancamentos.getUsuario_lancamento()==null?"":t_solicita_prorrog_lancamentos.getUsuario_lancamento();
                    motivo = t_solicita_prorrog_lancamentos.getMotivo()==null?"":t_solicita_prorrog_lancamentos.getMotivo();
                    sum_valor_lancamento_0 += ((valor_lancamento!=null)?valor_lancamento.doubleValue():0);
                    String style_bl_report_Solicita_prorrog_lancamentos="";
                    if (!((i_bl_report_Solicita_prorrog_lancamentos%2)!=0)) {
                      style_bl_report_Solicita_prorrog_lancamentos="rowColor";
                    } else {
                      style_bl_report_Solicita_prorrog_lancamentos="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Solicita_prorrog_lancamentos %>' id="TRbl_report_Solicita_prorrog_lancamentos<%=i_bl_report_Solicita_prorrog_lancamentos%>" >
                      <td class="reportColumn" style="text-align:right;" >
                        <%= ((id_lancamento!=null)?id_lancamento.toString():"") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= com.egen.util.text.FormatNumber.format(valor_lancamento, "##,##0.00") %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" >
                        <%= com.egen.util.text.FormatDate.format(data_lancamento, "dd/MM/yyyy") %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= usuario_lancamento %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= motivo %>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Solicita_prorrog_lancamentos++;
                    if (i_bl_report_Solicita_prorrog_lancamentos<res_Solicita_prorrog_lancamentos.size()) {
                      t_solicita_prorrog_lancamentos = (portalbr.dbobj.table.Solicita_prorrog_lancamentos)res_Solicita_prorrog_lancamentos.elementAt(i_bl_report_Solicita_prorrog_lancamentos);
                      id_solicitacao = t_solicita_prorrog_lancamentos.getId_solicitacao();
                      id_lancamento = t_solicita_prorrog_lancamentos.getId_lancamento();
                      valor_lancamento = t_solicita_prorrog_lancamentos.getValor_lancamento();
                      data_lancamento = (java.sql.Timestamp)t_solicita_prorrog_lancamentos.getData_lancamento();
                      usuario_lancamento = t_solicita_prorrog_lancamentos.getUsuario_lancamento()==null?"":t_solicita_prorrog_lancamentos.getUsuario_lancamento();
                      motivo = t_solicita_prorrog_lancamentos.getMotivo()==null?"":t_solicita_prorrog_lancamentos.getMotivo();
                    } else {
                    }
                  }
                  %>

                  <tr class="totalColumn">
                    <td>
                      &nbsp;
                    </td>
                    <td class="totalTdColumn"  style="text-align:right;" >
                      Total
                      <%= com.egen.util.text.FormatNumber.format(sum_valor_lancamento_0, "##,##0.00") %>
                    </td>
                    <td>
                      &nbsp;
                    </td>
                    <td>
                      &nbsp;
                    </td>
                    <td>
                      &nbsp;
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

        </td>
      </tr>
    </table>

  </body>
</center>
</html>

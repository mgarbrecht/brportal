<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Solicitação de Mailing
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(182)){
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
              java.util.Vector res_Jw_acao_mkt_solic_mailing = (java.util.Vector)session.getAttribute("res_Jw_acao_mkt_solic_mailing");
              %>

              <form  name="bl_report_Jw_acao_mkt_solic_mailing" id="bl_report_Jw_acao_mkt_solic_mailing" class="baseForm" method="post" >
                <%
                if (res_Jw_acao_mkt_solic_mailing!=null && res_Jw_acao_mkt_solic_mailing.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_acao_mkt_solic_mailing"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    int id_solicitacao =  0;
                    java.lang.String email_retorno =  null;
                    java.lang.String assunto =  null;
                    java.sql.Timestamp data_envio =  null;
                    java.lang.String nome_arquivo =  null;
                    java.lang.String situacao =  null;
                    java.lang.String situacao_desc =  null;
                    java.lang.String observacoes =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Solic.
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Email Retorno
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Assunto
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Data Envio
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Arquivo
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Situação
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Observação
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_acao_mkt_solic_mailing = 0;
                    while (i_bl_report_Jw_acao_mkt_solic_mailing<res_Jw_acao_mkt_solic_mailing.size()) {
                      portalbr.dbobj.view.Jw_acao_mkt_solic_mailing t_jw_acao_mkt_solic_mailing = (portalbr.dbobj.view.Jw_acao_mkt_solic_mailing)res_Jw_acao_mkt_solic_mailing.elementAt(i_bl_report_Jw_acao_mkt_solic_mailing);
                      id_solicitacao = t_jw_acao_mkt_solic_mailing.getId_solicitacao();
                      email_retorno = t_jw_acao_mkt_solic_mailing.getEmail_retorno()==null?"":t_jw_acao_mkt_solic_mailing.getEmail_retorno();
                      assunto = t_jw_acao_mkt_solic_mailing.getAssunto()==null?"":t_jw_acao_mkt_solic_mailing.getAssunto();
                      data_envio = (java.sql.Timestamp)t_jw_acao_mkt_solic_mailing.getData_envio();
                      nome_arquivo = t_jw_acao_mkt_solic_mailing.getNome_arquivo()==null?"":t_jw_acao_mkt_solic_mailing.getNome_arquivo();
                      situacao = t_jw_acao_mkt_solic_mailing.getSituacao()==null?"":t_jw_acao_mkt_solic_mailing.getSituacao();
                      situacao_desc = t_jw_acao_mkt_solic_mailing.getSituacao_desc()==null?"":t_jw_acao_mkt_solic_mailing.getSituacao_desc();
                      observacoes = t_jw_acao_mkt_solic_mailing.getObservacoes()==null?"":t_jw_acao_mkt_solic_mailing.getObservacoes();
                      String style_bl_report_Jw_acao_mkt_solic_mailing="";
                      if (!((i_bl_report_Jw_acao_mkt_solic_mailing%2)!=0)) {
                        style_bl_report_Jw_acao_mkt_solic_mailing="rowColor";
                      } else {
                        style_bl_report_Jw_acao_mkt_solic_mailing="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_acao_mkt_solic_mailing %>' id="TRbl_report_Jw_acao_mkt_solic_mailing<%=i_bl_report_Jw_acao_mkt_solic_mailing%>" >
                        <td class="reportColumn" style="text-align:right;width:1%;" >
                          <a href="../com/SolicitacaoMailing_aForm.do?select_action=&id_solicitacao=<%= id_solicitacao %>" style="cursor:hand">
                            <%= id_solicitacao %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= email_retorno %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= assunto %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_envio, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= nome_arquivo %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= situacao_desc %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= observacoes %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_acao_mkt_solic_mailing++;
                      if (i_bl_report_Jw_acao_mkt_solic_mailing<res_Jw_acao_mkt_solic_mailing.size()) {
                        t_jw_acao_mkt_solic_mailing = (portalbr.dbobj.view.Jw_acao_mkt_solic_mailing)res_Jw_acao_mkt_solic_mailing.elementAt(i_bl_report_Jw_acao_mkt_solic_mailing);
                        id_solicitacao = t_jw_acao_mkt_solic_mailing.getId_solicitacao();
                        email_retorno = t_jw_acao_mkt_solic_mailing.getEmail_retorno()==null?"":t_jw_acao_mkt_solic_mailing.getEmail_retorno();
                        assunto = t_jw_acao_mkt_solic_mailing.getAssunto()==null?"":t_jw_acao_mkt_solic_mailing.getAssunto();
                        data_envio = (java.sql.Timestamp)t_jw_acao_mkt_solic_mailing.getData_envio();
                        nome_arquivo = t_jw_acao_mkt_solic_mailing.getNome_arquivo()==null?"":t_jw_acao_mkt_solic_mailing.getNome_arquivo();
                        situacao = t_jw_acao_mkt_solic_mailing.getSituacao()==null?"":t_jw_acao_mkt_solic_mailing.getSituacao();
                        situacao_desc = t_jw_acao_mkt_solic_mailing.getSituacao_desc()==null?"":t_jw_acao_mkt_solic_mailing.getSituacao_desc();
                        observacoes = t_jw_acao_mkt_solic_mailing.getObservacoes()==null?"":t_jw_acao_mkt_solic_mailing.getObservacoes();
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

            <html:form action="com/SolicitacaoMailing_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="a" styleClass="baseButton" property="back_action">
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

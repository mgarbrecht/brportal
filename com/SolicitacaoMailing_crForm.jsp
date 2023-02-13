<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta de Solicitação de Mailing
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(183)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            com.egen.util.jdbc.JdbcUtil j = null;
            try {
              j = new com.egen.util.jdbc.JdbcUtil();
              util.consultas.Query qr = new util.consultas.Query();
              %>

              <%
              java.util.Vector res_Jw_acao_mkt_solic_mailing = null;
              try {
                portalbr.dbobj.view.Jw_acao_mkt_solic_mailing t_jw_acao_mkt_solic_mailing = new portalbr.dbobj.view.Jw_acao_mkt_solic_mailing();
                String[][] select = {{"id_solicitacao",null},{"email_retorno",null},{"assunto",null},{"data_envio",null},{"nome_arquivo",null},{"situacao",null},{"situacao_desc",null},{"observacoes",null},};
                Object[][] where = null;
                where = new Object[][]{{"situacao","=","S"},};
                String[] groupby =  null;
                String[] having =  null;
                String[] order = {"id_solicitacao desc"};
                res_Jw_acao_mkt_solic_mailing = j.select(t_jw_acao_mkt_solic_mailing,select,where,groupby,having,order);
              } catch (Exception e){
                session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
              } finally {
              }
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
                    java.lang.String confirmar_envio =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Solicitação
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
                        Observação
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Listas
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >

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
                        <td class="reportColumn" style="text-align:right;width:5%;" >
                          <%= id_solicitacao %>
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
                          <a href="../arquivos/mailing/<%= id_solicitacao+"_"+nome_arquivo %>">
                            <%= nome_arquivo %>
                          </a>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= observacoes %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= qr.retorna(j, "SELECT replace(rowtocol('SELECT ''- ''||nome_lista  FROM acao_mkt_solic_listas sl      ,acao_mkt_mailing_listas ml WHERE sl.id_lista = ml.id_lista   AND sl.id_solicitacao = "+id_solicitacao+"'),',','<br>') FROM dual") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" width="1%" >
                          <input type="button"  value="Confirmar Envio" onclick="if(confirm('Confirma essa operação?')){top.location='../com/SolicitacaoMailing_crForm.do?insert_action=&id_solicitacao=<%= id_solicitacao %>'}">
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
                } else {
                  %>
                  <br>
                  <h1>
                    Nenhuma solicitação pendente
                  </h1>
                  <%
                }
                %>
              </form>
              <%
            } finally {
              if (j != null){
                j.close();
              }
            }
            %>
            <html:form action="com/SolicitacaoMailing_crForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <html:hidden property="id_solicitacao"/>
                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="i" styleClass="myhidden" property="insert_action">
                        <bean:message bundle="ApplicationResources" key="jsp.insert"/>
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

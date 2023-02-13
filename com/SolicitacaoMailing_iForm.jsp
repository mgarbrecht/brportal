<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Solicitação de Mailing - Cadastro
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

            <html:form action="com/SolicitacaoMailing_iForm.do" enctype="multipart/form-data" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="data_envio"/>
                    <html:errors property="assunto"/>
                    <html:errors property="email_retorno"/>
                    <html:errors property="observacoes"/>
                    <html:errors property="listas_selecionadas"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Acao_mkt_solic_mailing"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <html:hidden property="id_solicitacao"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Envio
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="data_envio" styleId="data_envio" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_envio']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Assunto
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="assunto" styleId="assunto" styleClass="baseField" size="60" maxlength="200"/>
                  </td>
                </tr>

                <html:hidden property="situacao" value="S"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Email Retorno
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="email_retorno" styleId="email_retorno" styleClass="baseField" size="60" maxlength="65"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Arquivo
                    </span>
                  </td>
                  <td class="formField">
                    <html:file property="nome_arquivo" styleId="nome_arquivo" styleClass="baseField" maxlength="90" size="90">
                    </html:file>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Observação
                    </span>
                  </td>
                  <td class="formField">
                    <html:textarea property="observacoes" styleId="observacoes" styleClass="baseField" cols="60" rows="5"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td>
                    <%
                    {
                      %>

                      <%
                      java.util.Vector res_Acao_mkt_mailing_listas = null;
                      com.egen.util.jdbc.JdbcUtil j = null;
                      try {
                        j = new com.egen.util.jdbc.JdbcUtil();
                        portalbr.dbobj.table.Acao_mkt_mailing_listas t_acao_mkt_mailing_listas = new portalbr.dbobj.table.Acao_mkt_mailing_listas();
                        String[][] select = null;
                        Object[][] where = {{"SITUACAO_LISTA","=","A"}};
                        String[] groupby =  null;
                        String[] having =  null;
                        String[] order =  null;
                        res_Acao_mkt_mailing_listas = j.select(t_acao_mkt_mailing_listas,select,where,groupby,having,order);
                      } catch (Exception e){
                        session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                        %>
                        <jsp:forward page="/system/ErrorPage.jsp"/>
                        <%
                      } finally {
                      if(j!=null){j.close();}
                    }
                    %>

                  </td>
                  <td align="left">

                    <%
                    if (res_Acao_mkt_mailing_listas!=null && res_Acao_mkt_mailing_listas.size()>0) {
                      %>


                      <table id="TRbl_report_Acao_mkt_mailing_listas"  class="reportTable"   style="width:300px; " border=1;  >
                        <%
                        int id_lista = 0;
                        java.lang.String nome_lista =  null;
                        java.lang.String situacao_lista =  null;
                        %>

                        <tr class="reportTr">

                          <td class="columnTdHeader" style="text-align:center;" >
                            <big>
                              <b>
                                Listas
                              </b>
                            </big>
                          </td>

                        </tr>

                        <%
                        int i_bl_report_Acao_mkt_mailing_listas = 0;
                        while (i_bl_report_Acao_mkt_mailing_listas<res_Acao_mkt_mailing_listas.size()) {
                          portalbr.dbobj.table.Acao_mkt_mailing_listas t_acao_mkt_mailing_listas = (portalbr.dbobj.table.Acao_mkt_mailing_listas)res_Acao_mkt_mailing_listas.elementAt(i_bl_report_Acao_mkt_mailing_listas);
                          id_lista = t_acao_mkt_mailing_listas.getId_lista();
                          nome_lista = t_acao_mkt_mailing_listas.getNome_lista()==null?"":t_acao_mkt_mailing_listas.getNome_lista();
                          situacao_lista = t_acao_mkt_mailing_listas.getSituacao_lista()==null?"":t_acao_mkt_mailing_listas.getSituacao_lista();
                          String style_bl_report_Acao_mkt_mailing_listas="";
                          if (!((i_bl_report_Acao_mkt_mailing_listas%2)!=0)) {
                            style_bl_report_Acao_mkt_mailing_listas="rowColor";
                          } else {
                            style_bl_report_Acao_mkt_mailing_listas="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Acao_mkt_mailing_listas %>' id="TRbl_report_Acao_mkt_mailing_listas<%=i_bl_report_Acao_mkt_mailing_listas%>" >

                            <td class="reportColumn" style="text-align:left;" >
                              <input type="checkbox" name="lista" onclick="get_check_value()" value="<%= id_lista %>">
                              <%= nome_lista %>
                              <%= id_lista %>
                            </td>

                          </tr>

                          <%
                          i_bl_report_Acao_mkt_mailing_listas++;
                          if (i_bl_report_Acao_mkt_mailing_listas<res_Acao_mkt_mailing_listas.size()) {
                            t_acao_mkt_mailing_listas = (portalbr.dbobj.table.Acao_mkt_mailing_listas)res_Acao_mkt_mailing_listas.elementAt(i_bl_report_Acao_mkt_mailing_listas);
                            id_lista = t_acao_mkt_mailing_listas.getId_lista();
                            nome_lista = t_acao_mkt_mailing_listas.getNome_lista()==null?"":t_acao_mkt_mailing_listas.getNome_lista();
                            situacao_lista = t_acao_mkt_mailing_listas.getSituacao_lista()==null?"":t_acao_mkt_mailing_listas.getSituacao_lista();
                          } else {
                          }
                        }
                        %>

                      </table>

                      <%
                    }
                    %>

                    <%
                  }
                  %>
                </td>
              </tr>

              <html:hidden property="listas_selecionadas" styleId="listas_selecionadas" />
            </table>

            <table class="buttonTable" style='width:99%;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:submit accesskey="i" styleClass="baseButton" property="insert_action">
                    <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                  </html:submit>
                  <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                    <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:submit>
                  <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                    <bean:message bundle="ApplicationResources" key="jsp.back"/>
                  </html:submit>
                </td>
              </tr>
            </table>

            <script type="text/javascript">
              jQuery(document).ready(function($) {
                $("#data_envio").mask("99/99/9999");
                });

                function get_check_value(){
                  var c_value = "";
                  for (var i=0; i < document.forms[0].lista.length; i++){
                    if (document.forms[0].lista[i].checked){
                      c_value = c_value + document.forms[0].lista[i].value +" ";
                    }
                  }
                  jQuery("#listas_selecionadas").val(c_value);
                }
              </script>
            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["data_envio"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

          </td>
        </tr>
      </table>

    </body>
  </center>
</html>

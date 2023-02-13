<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Solicitação de Mailing - Alteração
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

            <html:form action="com/SolicitacaoMailing_aForm.do" enctype="multipart/form-data" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="id_solicitacao"/>
                    <html:errors property="data_envio"/>
                    <html:errors property="assunto"/>
                    <html:errors property="email_retorno"/>
                    <html:errors property="nome_arquivo"/>
                    <html:errors property="situacao_desc"/>
                    <html:errors property="observacoes"/>
                    <html:errors property="listas_selecionadas"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Acao_mkt_solic_mailing"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String situacao = "S";
                portalbr.com.SolicitacaoMailing_aActionForm solicitacaoActionForm = (portalbr.com.SolicitacaoMailing_aActionForm) session.getAttribute("SolicitacaoMailing_aActionForm");
                situacao = solicitacaoActionForm.getSituacao()+"";
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Solicitação
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="id_solicitacao" styleId="id_solicitacao" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Envio
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <%
                    if(situacao.equals("S")){
                      %>
                      <html:text property="data_envio" styleId="data_envio" styleClass="baseField" size="10" maxlength="10"/>
                       
                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_envio']); cal1.year_scroll = true; cal1.popup();">
                        <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                      </a>
                      <%
                    } else {
                      %>
                      <html:text property="data_envio" styleId="data_envio" styleClass="disabled" readonly="true" tabindex="-1" size="10" maxlength="10"/>
                      <%
                    }
                    %>
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
                    <%
                    if(situacao.equals("S")){
                      %>
                      <html:text property="assunto" styleId="assunto" styleClass="baseField" size="60"/>
                      <%
                    } else {
                      %>
                      <html:text property="assunto" styleId="assunto" styleClass="disabled" readonly="true" tabindex="-1" size="60"/>
                      <%
                    }
                    %>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Email Retorno
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <%
                    if(situacao.equals("S")){
                      %>
                      <html:text property="email_retorno" styleId="email_retorno" styleClass="baseField" size="65" maxlength="65"/>
                      <%
                    } else {
                      %>
                      <html:text property="email_retorno" styleId="email_retorno" styleClass="disabled" readonly="true" tabindex="-1" size="65" maxlength="65"/>
                      <%
                    }
                    %>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Arquivo
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="nome_arquivo" styleId="nome_arquivo" styleClass="disabled" readonly="true" tabindex="-1" size="60" maxlength="90"/>
                    <%
                    if((solicitacaoActionForm.getNome_arquivo()+"").equals("") && solicitacaoActionForm.getSituacao().equals("S")) {
                      %>
                      <html:file property="arquivo" styleId="arquivo" styleClass="baseField">
                      </html:file>
                      <%
                    } else {
                      %>
                      <%
                      if(solicitacaoActionForm.getSituacao().equals("S")) {
                        %>
                        <html:submit value="Remover Arquivo" styleClass="baseButton" property="remover_arquivo_action">
                        </html:submit>
                        <%
                      }
                      %>
                      <%
                    }
                    %>
                  </td>
                </tr>


                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                  </td>
                </tr>

                <html:hidden property="situacao"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situação
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:select property="situacao_desc" disabled="true" styleId="situacao_desc" styleClass="disabled" tabindex="-1" size="1">
                      <html:options property="situacao_descList" labelProperty="situacao_descLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Observação
                    </span>
                  </td>
                  <td class="formField">
                    <%
                    if(situacao.equals("S")){
                      %>
                      <html:textarea property="observacoes" styleId="observacoes" styleClass="baseField" cols="60" rows="5"/>
                      <%
                    } else {
                      %>
                      <html:textarea property="observacoes" styleId="observacoes" styleClass="disabled" readonly="true" tabindex="-1" cols="60" rows="5"/>
                      <%
                    }
                    %>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td align="left">
                    <!--<form>-->
                    <%
                    {
                      %>

                      <%
                      portalbr.com.SolicitacaoMailing_aActionForm SolicitacaoMailing_aActionForm = (portalbr.com.SolicitacaoMailing_aActionForm)session.getAttribute("SolicitacaoMailing_aActionForm");
                      java.util.Vector res_Acao_mkt_mailing_listas = null;
                      com.egen.util.jdbc.JdbcUtil j = null;
                      try {
                        j = new com.egen.util.jdbc.JdbcUtil();
                        portalbr.dbobj.view.Jw_listas_selecionadas t_acao_mkt_mailing_listas = new portalbr.dbobj.view.Jw_listas_selecionadas();
                        String[][] select = null;
                        Object[][] where = null;
                        String[] groupby =  null;
                        String[] having =  null;
                        String[] order =  null;
                        StringBuilder sb = new StringBuilder();
                        sb.append(" SELECT id_lista ");
                        sb.append("      , nome_lista ");
                        sb.append("      , 'N' selecionado ");
                        sb.append("   FROM acao_mkt_mailing_listas a ");
                        sb.append("  WHERE situacao_lista = 'A' ");
                        sb.append("    AND NOT EXISTS (SELECT 1 ");
                        sb.append("                      FROM acao_mkt_solic_listas l ");
                        sb.append("                     WHERE l.id_solicitacao = " + SolicitacaoMailing_aActionForm.getId_solicitacao());
                        sb.append("                       AND l.id_lista = a.id_lista) ");
                        sb.append(" UNION ");
                        sb.append(" SELECT ml.id_lista ");
                        sb.append("       ,ml.nome_lista ");
                        sb.append("       ,'S' selecionado ");
                        sb.append("   FROM acao_mkt_solic_listas sl ");
                        sb.append("       ,acao_mkt_mailing_listas ml ");
                        sb.append("  WHERE sl.id_lista = ml.id_lista ");
                        sb.append("    AND sl.id_solicitacao = "+SolicitacaoMailing_aActionForm.getId_solicitacao());
                        res_Acao_mkt_mailing_listas = j.select(t_acao_mkt_mailing_listas, sb.toString(), null);
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
                        java.lang.String id_lista =  null;
                        java.lang.String nome_lista =  null;
                        java.lang.String selecionado =  null;
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
                          portalbr.dbobj.view.Jw_listas_selecionadas t_acao_mkt_mailing_listas = (portalbr.dbobj.view.Jw_listas_selecionadas)res_Acao_mkt_mailing_listas.elementAt(i_bl_report_Acao_mkt_mailing_listas);
                          id_lista = t_acao_mkt_mailing_listas.getId_lista()+"";
                          nome_lista = t_acao_mkt_mailing_listas.getNome_lista()==null?"":t_acao_mkt_mailing_listas.getNome_lista();
                          selecionado = t_acao_mkt_mailing_listas.getSelecionado()==null?"":t_acao_mkt_mailing_listas.getSelecionado();
                          String style_bl_report_Acao_mkt_mailing_listas="";
                          if (!((i_bl_report_Acao_mkt_mailing_listas%2)!=0)) {
                            style_bl_report_Acao_mkt_mailing_listas="rowColor";
                          } else {
                            style_bl_report_Acao_mkt_mailing_listas="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Acao_mkt_mailing_listas %>' id="TRbl_report_Acao_mkt_mailing_listas<%=i_bl_report_Acao_mkt_mailing_listas%>" >

                            <td class="reportColumn" style="text-align:left;" >
                              <%
                              if(situacao.equals("S")){
                                %>
                                <%
                                if(selecionado.equals("N")){
                                  %>
                                  <input type="checkbox" name="lista" onclick="get_check_value()" value="<%= id_lista %>">
                                  <%= nome_lista %>
                                  <%= id_lista %>
                                  <%
                                } else {
                                  %>
                                  <input type="checkbox" name="lista" checked="checked" onclick="get_check_value()" value="<%= id_lista %>">
                                  <%= nome_lista %>
                                  <%= id_lista %>
                                  <%
                                }
                                %>
                                <%
                              } else {
                                %>
                                <%
                                if(selecionado.equals("N")){
                                  %>
                                  <input type="checkbox" name="lista" disabled="true" value="<%= id_lista %>">
                                  <%= nome_lista %>
                                  <%= id_lista %>
                                  <%
                                } else {
                                  %>
                                  <input type="checkbox" name="lista" disabled="true" checked="checked" value="<%= id_lista %>">
                                  <%= nome_lista %>
                                  <%= id_lista %>
                                  <%
                                }
                                %>
                                <%
                              }
                              %>
                            </td>

                          </tr>

                          <%
                          i_bl_report_Acao_mkt_mailing_listas++;
                          if (i_bl_report_Acao_mkt_mailing_listas<res_Acao_mkt_mailing_listas.size()) {
                            t_acao_mkt_mailing_listas = (portalbr.dbobj.view.Jw_listas_selecionadas)res_Acao_mkt_mailing_listas.elementAt(i_bl_report_Acao_mkt_mailing_listas);
                            id_lista = t_acao_mkt_mailing_listas.getId_lista()+"";
                            nome_lista = t_acao_mkt_mailing_listas.getNome_lista()==null?"":t_acao_mkt_mailing_listas.getNome_lista();
                            selecionado = t_acao_mkt_mailing_listas.getSelecionado()==null?"":t_acao_mkt_mailing_listas.getSelecionado();
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
                  <!--</form>-->
                </td>
              </tr>
              <html:hidden property="listas_selecionadas" styleId="listas_selecionadas" styleClass="baseField"/>

            </table>

            <table class="buttonTable" style='width:99%;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:submit styleClass="myhidden" property="select_action">
                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                  </html:submit>
                  <%
                  if(solicitacaoActionForm.getSituacao().equals("S")){
                    %>
                    <html:submit accesskey="a" onclick="get_check_value();" styleClass="baseButton" property="update_action">
                      <bean:message bundle="ApplicationResources" key="jsp.update"/>
                    </html:submit>
                    <%
                  }
                  %>
                  <%
                  if(solicitacaoActionForm.getSituacao().equals("S")){
                    %>
                    <html:submit accesskey="a" onclick="get_check_value();return confirmSubmit('');" styleClass="myhidden" property="delete_action">
                      <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                    </html:submit>
                    <%
                  }
                  %>
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
              var focusControl = document.forms[0].elements["id_solicitacao"];
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

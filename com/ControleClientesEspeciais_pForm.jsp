<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
    <bean:message key="page.scriptcalendar"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="com/ControleClientesEspeciais_pForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>

                    </div>
                    <html:errors property="dt_agendamento"/>
                    <html:errors property="etiqueta"/>
                    <html:errors property="observacao"/>
                    <html:errors property="semana_agendamento"/>
                    <html:errors property="hora"/>
                    <html:errors property="senha"/>
                    <html:errors property="certificado_origem"/>
                    <html:errors property="dt_inspecao"/>
                    <html:errors property="dt_solicitacao_alarme"/>
                    <html:errors property="filial_faturamento"/>
                    <html:errors property="modelo_alarme"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <html:hidden property="tipo"/>
                <%
                boolean mostraDataAgendamento = false;
                boolean mostraEtiqueta = false;
                boolean mostraObservacao = false;
                boolean mostraSemanaAgendamento = false;
                boolean mostraHora = false;
                boolean mostraSenha = false;
                boolean mostraModeloAlarme = false;
                boolean mostraCertificadoOrigem = false;
                boolean mostraDataInspecao = false;
                boolean mostraFilialFaturamento = false;
                boolean mostraDataSolicitacaoAlarme = false;
                portalbr.com.ControleClientesEspeciais_pActionForm controleActionForm = (portalbr.com.ControleClientesEspeciais_pActionForm)session.getAttribute("ControleClientesEspeciais_pActionForm");
                if((controleActionForm.getTipo()+"").equalsIgnoreCase("data_agendamento")){
                  mostraDataAgendamento = true;
                }
                if((controleActionForm.getTipo()+"").equalsIgnoreCase("etiqueta")){
                  mostraEtiqueta = true;
                }
                if((controleActionForm.getTipo()+"").equalsIgnoreCase("observacao")){
                  mostraObservacao = true;
                }
                if((controleActionForm.getTipo()+"").equalsIgnoreCase("semana_agendamento")){
                  mostraSemanaAgendamento = true;
                }
                if((controleActionForm.getTipo()+"").equalsIgnoreCase("hora")){
                  mostraHora = true;
                }
                if((controleActionForm.getTipo()+"").equalsIgnoreCase("senha")){
                  mostraSenha = true;
                }
                if((controleActionForm.getTipo()+"").equalsIgnoreCase("modelo_alarme")){
                  mostraModeloAlarme = true;
                }
                if((controleActionForm.getTipo()+"").equalsIgnoreCase("certificado_origem")){
                  mostraCertificadoOrigem= true;
                }
                if((controleActionForm.getTipo()+"").equalsIgnoreCase("data_inspecao")){
                  mostraDataInspecao = true;
                }
                if((controleActionForm.getTipo()+"").equalsIgnoreCase("filial_faturamento")){
                  mostraFilialFaturamento = true;
                }
                if((controleActionForm.getTipo()+"").equalsIgnoreCase("data_solicitacao_alarme")){
                  mostraDataSolicitacaoAlarme = true;
                }
                if(session.getAttribute("informou")!=null){
                  %>
                  <script>
                    opener.document.forms[0].refresh_action.click();
                    javascript:window.close();
                  </script>

                  <%
                  session.removeAttribute("informou");
                }
                %>
                <%
                if(mostraDataAgendamento){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Dt. Agendamento
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="dt_agendamento" styleId="dt_agendamento" styleClass="baseField" size="10"/>
                       
                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_agendamento']); cal1.year_scroll = true; cal1.popup();">
                        <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                      </a>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="dt_agendamento" />

                  <%
                }
                %>

                <%
                if(mostraEtiqueta){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Etiqueta
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="etiqueta" styleId="etiqueta" styleClass="baseField" size="20" maxlength="200"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="etiqueta" />

                  <%
                }
                %>

                <%
                if(mostraObservacao){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Observação
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="observacao" styleId="observacao" styleClass="baseField" size="50" maxlength="400"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="observacao" />

                  <%
                }
                %>


                <%
                if(mostraSemanaAgendamento) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Semana Agendamento
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="semana_agendamento" styleId="semana_agendamento" styleClass="baseField" size="20" maxlength="20"/>
                    </td>
                  </tr>
                  <%
                } else {
                  %>
                  <html:hidden property="semana_agendamento" />
                  <%
                }
                %>


                <%
                if(mostraHora) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Hora
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="hora" styleId="hora" styleClass="baseField" size="6" maxlength="20"/>
                    </td>
                  </tr>
                  <%
                } else {
                  %>
                  <html:hidden property="hora" />
                  <%
                }
                %>


                <%
                if(mostraSenha) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Senha
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="senha" styleId="senha" styleClass="baseField" size="10" maxlength="20"/>
                    </td>
                  </tr>
                  <%
                } else {
                  %>
                  <html:hidden property="senha" />
                  <%
                }
                %>


                <%
                if(mostraEtiqueta) {
                  %>
                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["etiqueta"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>
                  <%
                }
                %>

                <%
                if(mostraDataAgendamento) {
                  %>
                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["dt_agendamento"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>
                  <%
                }
                %>

                <%
                if(mostraObservacao) {
                  %>
                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["observacao"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>
                  <%
                }
                %>

                <%
                if(mostraSemanaAgendamento) {
                  %>
                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["semana_agendamento"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>
                  <%
                }
                %>

                <%
                if(mostraHora) {
                  %>
                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["hora"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>
                  <%
                }
                %>

                <%
                if(mostraSenha) {
                  %>
                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["senha"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>
                  <%
                }
                %>

                <%
                if(mostraCertificadoOrigem) {
                  %>
                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["certificado_origem"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>
                  <%
                }
                %>

                <%
                if(mostraCertificadoOrigem){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        certificado_origem
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="certificado_origem" styleId="certificado_origem" styleClass="baseField" size="50" maxlength="400"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="certificado_origem" />

                  <%
                }
                %>
                <%
                if(mostraDataInspecao) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Dt. Inspeção
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="dt_inspecao" styleId="dt_inspecao" styleClass="baseField" size="10" maxlength="10"/>
                       
                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_inspecao']); cal1.year_scroll = true; cal1.popup();">
                        <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                      </a>
                    </td>
                  </tr>
                  <script>
                    jQuery(document).ready(function($) {
                      $("#dt_inspecao").mask("99/99/9999");
                      });
                    </script>
                    <%
                  } else {
                    %>
                    <html:hidden property="dt_inspecao" />
                    <%
                  }
                  %>

                  <%
                  if(mostraDataSolicitacaoAlarme) {
                    %>
                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Dt. Solicitação Alarme
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="dt_solicitacao_alarme" styleId="dt_solicitacao_alarme" styleClass="baseField" size="10" maxlength="10"/>
                         
                        <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_solicitacao_alarme']); cal1.year_scroll = true; cal1.popup();">
                          <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                        </a>
                      </td>
                    </tr>
                    <script>
                      jQuery(document).ready(function($) {
                        $("#dt_solicitacao_alarme").mask("99/99/9999");
                        });
                      </script>
                      <%
                    } else {
                      %>
                      <html:hidden property="dt_solicitacao_alarme" />
                      <%
                    }
                    %>

                    <%
                    if(mostraFilialFaturamento) {
                      %>
                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Filial Faturamento
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="filial_faturamento" styleId="filial_faturamento" styleClass="baseField" size="4" maxlength="4"/>
                           
                        </td>
                      </tr>
                      <%
                    } else {
                      %>
                      <html:hidden property="filial_faturamento" />
                      <%
                    }
                    %>

                    <%
                    if(mostraModeloAlarme){
                      %>
                      <tr class="itemTr">
                        <td class="formLabel">
                          <span lass="spamFormLabel">
                            Modelo Alarme
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="modelo_alarme" styleId="modelo_alarme" styleClass="baseField" size="50" maxlength="200"/>
                        </td>
                      </tr>

                      <%
                    } else {
                      %>

                      <html:hidden property="modelo_alarme" />

                      <%
                    }
                    %>


                  </table>

                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:submit accesskey="a" value="Alterar Todos os Pedidos" styleClass="baseButton" property="update_action">
                        </html:submit>
                        <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                          <bean:message bundle="ApplicationResources" key="jsp.close"/>
                        </html:button>
                        <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                          <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                        </html:submit>
                      </td>
                    </tr>
                  </table>

                  <script type="text/javascript">
                    jQuery(document).ready(function($) {
                      $("#dt_agendamento").mask("99/99/9999");
                      });
                    </script>
                  </html:form>
                </td>
              </tr>
            </table>

          </body>
        </center>
      </html>

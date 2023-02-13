<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.scriptcalendar"/>
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

            <html:form action="com/SolicitacaoMailingForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="id_solicitacao"/>
                    <html:errors property="data_envio"/>
                    <html:errors property="data_envio_final"/>
                    <html:errors property="situacao"/>
                    <html:errors property="observacoes"/>
                    <html:errors property="assunto"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_mkt_solic_mailing"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Solicitação
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="id_solicitacao" styleId="id_solicitacao" styleClass="baseField" size="10" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Inicial
                    </span>
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
                      Data Final
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_envio_final" styleId="data_envio_final" styleClass="baseField" size="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_envio_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situação
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="situacao" styleId="situacao" styleClass="baseField" size="1">
                      <html:options property="situacaoList" labelProperty="situacaoLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Observações
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="observacoes" styleId="observacoes" styleClass="baseField" size="60" maxlength="2000"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Assunto
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="assunto" styleId="assunto" styleClass="baseField" size="60" maxlength="200"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="s" onclick="bloqueia();" styleClass="baseButton" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="i" value="Cadastrar Solicitação" styleClass="baseButton" property="insert_action">
                    </html:submit>
                    <html:submit styleClass="myhidden" property="select_session_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

              <script type="text/javascript">
                jQuery(document).ready(function($) {
                  $("#data_envio").mask("99/99/9999");
                  $("#data_envio_final").mask("99/99/9999");
                  });
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

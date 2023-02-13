<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Solicitação de Alteração de Comissão
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

            <html:form action="com/SolicitacaoAlteracaoComissaoForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="nfs_nmro"/>
                    <html:errors property="nfs_serie"/>
                    <html:errors property="emp_empresa"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="data_solicitacao"/>
                    <html:errors property="situacao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Solicita_prorrogacao"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String usuario = null;
                acesso.Sessao sessao = new acesso.Sessao(session);
                usuario = sessao.getUsuario();
                %>
                <html:hidden property="id_solicitacao"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Número
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="nfs_nmro" styleId="nfs_nmro" styleClass="baseField" size="7" maxlength="7"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Série
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="nfs_serie" styleId="nfs_serie" styleClass="baseField" size="3" maxlength="3"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Empresa
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="emp_empresa" styleId="emp_empresa" styleClass="baseField" size="3" maxlength="3"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Filial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fil_filial" styleId="fil_filial" styleClass="baseField" size="4" maxlength="4"/>
                  </td>
                </tr>

                <html:hidden property="nro_dias_prorrogacao"/>
                <html:hidden property="valor_calculado"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_solicitacao" styleId="data_solicitacao" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_solicitacao']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <html:hidden property="usuario_solicitacao" value="<%= usuario %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situação
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="situacao" styleId="situacao" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="">
                        Todas
                      </html:option>
                      <html:option styleClass="baseOption" value="P">
                        Pendente
                      </html:option>
                      <html:option styleClass="baseOption" value="A">
                        Aprovado
                      </html:option>
                      <html:option styleClass="baseOption" value="R">
                        Reprovado
                      </html:option>
                      <html:option styleClass="baseOption" value="L">
                        Lançado
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <html:hidden property="data_aprovacao"/>
                <html:hidden property="usuario_aprovacao"/>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" onclick="bloqueia();" styleClass="baseButton" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="i" value="Cadastrar Nova Solicitação" styleClass="baseButton" property="insert_action">
                    </html:submit>
                  </td>
                </tr>
              </table>

              <script type="text/javascript">
                jQuery(document).ready(function($) {
                  $("#data_solicitacao").mask("99/99/9999");
                  });
                </script>
              </html:form>
              <script type="text/javascript">
                var focusControl = document.forms[0].elements["nfs_nmro"];
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

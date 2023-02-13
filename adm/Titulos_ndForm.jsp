<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Negociação do Título
    </title>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:640;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:640" >
              <tr>

                <td class="td10">
                </td>

              </tr>

            </table>

            <html:form action="adm/Titulos_ndForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:640;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <big>
                        <b>
                          Negociação do Título
                          <%= (String)request.getParameter("titulo") %>
                        </b>
                      </big>
                    </div>
                    <html:errors property="tip_codigo"/>
                    <html:errors property="tit_datvenc"/>
                    <html:errors property="tit_valor"/>
                    <html:errors property="w_dias"/>
                    <html:errors property="juros"/>
                    <html:errors property="w_protesto"/>
                    <html:errors property="total"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_titulos_dados"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:640;">
                <html:hidden property="emp_empresa"/>
                <html:hidden property="fil_filial"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="tip_codigo" styleClass="disabled" readonly="true" size="3" maxlength="3"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Vencimento
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="tit_datvenc" styleClass="disabled" readonly="true" size="22" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Valor
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="tit_valor" styleClass="disabled" readonly="true" size="23" maxlength="23"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Dias
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="w_dias" styleClass="disabled" readonly="true" size="21" maxlength="21"/>
                  </td>
                </tr>

                <html:hidden property="titulo"/>
                <html:hidden property="dt_calculo"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Juros
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="juros" styleClass="disabled" readonly="true"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cartório
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="w_protesto" styleClass="disabled" readonly="true"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Total
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="total" styleClass="disabled" readonly="true"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:640;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:button accesskey="c" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
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

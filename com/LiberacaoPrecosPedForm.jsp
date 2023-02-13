<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:100%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="com/LiberacaoPrecosPedForm.do" method="post" styleClass="baseForm">
              <table class="bannerTable" style="width:100%;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Liberação
                  </td>
                </tr>
              </table>

              <table class="messageTable" style='width:100%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Prc_solicitacao_altera_precos"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:100%;">
                <html:hidden property="p_nmro_solicitacao"/>
                <html:hidden property="p_libera"/>
              </table>

              <table class="buttonTable" style='width:100%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit styleClass="myhidden" property="execute_action">
                      <bean:message bundle="ApplicationResources" key="jsp.execute"/>
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

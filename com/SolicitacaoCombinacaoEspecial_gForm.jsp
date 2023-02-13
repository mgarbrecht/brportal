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
            <html:form action="com/SolicitacaoCombinacaoEspecial_gGrid.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:100%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="pares"/>
                    <html:errors property="numeracao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_grade_solicitacao_especial"/>
                  </td>
                </tr>
              </table>

              <table class="itemGridTable" style='width:100px;'>

                <tr class="trGridField">
                  <logic:iterate id="bl_form_Jw_grade_solicitacao_especial_lines" name="SolicitacaoCombinacaoEspecial_gGridActionForm" property="bl_form_Jw_grade_solicitacao_especial_lines" indexId="indexId">
                    <td class="tdGridField">
                      <html:text property="numeracao" style="text-align:center" styleId="numeracao" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5" name="bl_form_Jw_grade_solicitacao_especial_lines" indexed="true"/>
                      <br>
                      <html:text property="pares" styleId="pares" style="text-align:center" styleClass="baseField" size="5" maxlength="5" name="bl_form_Jw_grade_solicitacao_especial_lines" indexed="true"/>
                    </td>

                    <html:hidden property="lin_cdgo" name="bl_form_Jw_grade_solicitacao_especial_lines" indexed="true" styleId="lin_cdgo"/>


                  </logic:iterate>
                </tr>

              </table>

              <table class="buttonTable" style='width:100%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="i" styleClass="baseButton" property="insert_action">
                      Salvar Informações
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                  </td>
                </tr>
              </table>

              <%
              if(session.getAttribute("fechar")!=null){
                session.removeAttribute("fechar");
                %>
                <script>
                  opener.document.forms[0].refresh_action.click();
                  window.close();
                </script>

                <%
              }
              %>



            </html:form>





            <html:form action="com/SolicitacaoCombinacaoEspecial_gForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <html:hidden property="lin_cdgo1"/>
                <table class="buttonTable" style='width:100%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit styleClass="myhidden" property="select1_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
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

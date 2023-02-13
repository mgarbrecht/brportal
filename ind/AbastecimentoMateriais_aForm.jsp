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
      <table class="mainTable" style='width:100%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="ind/AbastecimentoMateriais_aForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:100%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="quantidade_transito"/>
                    <html:errors property="quantidade_atraso"/>
                    <html:errors property="data_entrega"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Req_sdo_abastecimento_fornec"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:100%;">
                <%
                portalbr.ind.AbastecimentoMateriais_aActionForm AbastecimentoMateriais_aActionForm = (portalbr.ind.AbastecimentoMateriais_aActionForm)session.getAttribute("AbastecimentoMateriais_aActionForm");
                %>


                <html:hidden property="id"/>
                <html:hidden property="ies_codigo"/>
                <html:hidden property="cor_cdgo"/>
                <html:hidden property="tai_codigo"/>
                <html:hidden property="cod_min_fabr"/>
                <html:hidden property="fen_seq"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Qtde. Trânsito
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="quantidade_transito" styleId="quantidade_transito" styleClass="baseField" size="23" maxlength="23"/>
                  </td>
                </tr>

                <html:hidden property="quantidade_produzida"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Qtde. Atraso
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="quantidade_atraso" styleId="quantidade_atraso" styleClass="baseField" size="23" maxlength="23"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Dt. Entrega
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="data_entrega" styleId="data_entrega" styleClass="baseField" size="11" maxlength="11"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_entrega']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <html:hidden property="sdo_req"/>
                <html:hidden property="data_atualizacao"/>
                <html:hidden property="fornecedor_codigo"/>
                <%
                if(request.getAttribute("inseriu_ok") != null) {
                  %>
                  <script>
                    opener.location.reload(true);
                    // alert('Operação realizada com sucesso!');
                    window.open('','_self','');
                    window.close();
                  </script>
                  <%
                }
                %>

                <%
                if(request.getAttribute("atualizou_ok") != null) {
                  %>
                  <script>
                    opener.location.reload(true);
                    // alert('Operação realizada com sucesso!');
                    window.open('','_self','');
                    window.close();
                  </script>
                  <%
                }
                %>
              </table>

              <table class="buttonTable" style='width:100%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <%
                    if(AbastecimentoMateriais_aActionForm.getId()!=""){
                      %>
                      <html:submit accesskey="i" styleClass="myhidden" property="insert_action">
                        <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                      </html:submit>
                      <%
                    } else {
                      %>
                      <html:submit accesskey="i" styleClass="baseButton" property="insert_action">
                        <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                      </html:submit>
                      <%
                    }
                    %>
                    <%
                    if(AbastecimentoMateriais_aActionForm.getId()!=""){
                      %>
                      <html:submit accesskey="a" styleClass="baseButton" property="update_action">
                        <bean:message bundle="ApplicationResources" key="jsp.update"/>
                      </html:submit>
                      <%
                    } else {
                      %>
                      <html:submit accesskey="a" styleClass="myhidden" property="update_action">
                        <bean:message bundle="ApplicationResources" key="jsp.update"/>
                      </html:submit>
                      <%
                    }
                    %>

                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                    <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="p" value="pop" styleClass="myhidden" property="pop_action">
                    </html:submit>
                  </td>
                </tr>
              </table>

              <script type="text/javascript">
                jQuery(document).ready(function($) {
                  $("#data_entrega").mask("99/99/9999");
                  });
                </script>
              </html:form>
              <script type="text/javascript">
                var focusControl = document.forms[0].elements["quantidade_transito"];
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/TabelaPrecos_rcActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = TabelaPrecos_rcActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("ref_cdgo","Referência");
    hashMapLabel.set("f_refresh","");
    hashMapLabel.set("gridCheckField","");
    hashMapLabel.set("codigo_marca1","codigo_marca");
    hashMapLabel.set("descricao_marca1","descricao_marca");
    hashMapLabel.set("lin_cdgo1","lin_cdgo");
    hashMapLabel.set("ref_cdgo1","ref_cdgp");
    hashMapLabel.set("modelo","Modelo");
    hashMapLabel.set("pos","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Tabela de Preços - Exportação - Itens
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
                </td>

              </tr>

            </table>

            <html:form action="exp/TabelaPrecos_rcForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_cor"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" styleClass="baseField" size="10" maxlength="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Referência
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ref_cdgo" styleId="ref_cdgo" styleClass="baseField" size="5" maxlength="10"/>
                  </td>
                </tr>

                <%
                if(request.getAttribute("refresh")!=null) {
                  %>
                  <script>
                    opener.document.forms[0].refresh_action.click();
                  </script>
                  <%
                }
                %>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="baseButton" property="select1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["lin_cdgo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            Vector res_Jw_ref_cor = (Vector)session.getAttribute("res_Jw_ref_cor");
            if (res_Jw_ref_cor != null && res_Jw_ref_cor.size() > 0) {
              %>

              <html:form action="exp/TabelaPrecos_rcGrid.do" method="post" styleClass="baseForm">
                <table class="messageTable" style='width:99%;'>
                  <tr class="messageTr" >
                    <td class="messageTd">
                      <html:errors property="gridCheckField"/>
                      <html:errors property="modelo"/>
                      <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_cor_1"/>
                    </td>
                  </tr>
                </table>

                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit value="Pos" styleClass="myhidden" property="pos_action">
                      </html:submit>
                      <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:submit value="Adicionar Itens" styleClass="baseButton" property="selecionar_action">
                      </html:submit>
                      <html:submit value="Marcar Todos" styleClass="baseButton" property="marcar_todos_action">
                      </html:submit>
                      <html:submit value="Desmarcar Todos" styleClass="baseButton" property="desmarcar_todos_action">
                      </html:submit>
                    </td>
                  </tr>
                </table>

                <table class="itemGridTable" style='width:99%;'>
                  <tr class="trGridLabel">
                    <td class="tdGridlabel">
                      <span class="spamFormLabel">
                      </span>
                    </td>

                    <td class="tdGridlabel">
                      <span class="spamFormLabel">
                        Linha
                      </span>
                    </td>

                    <td class="tdGridlabel">
                      <span class="spamFormLabel">
                        Referência
                      </span>
                    </td>

                  </tr>

                  <logic:iterate id="bl_form_Jw_ref_cor_1_lines" name="TabelaPrecos_rcGridActionForm" property="bl_form_Jw_ref_cor_1_lines" indexId="indexId">
                    <tr class="trGridField">
                      <td class="tdGridField">
                        <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_ref_cor_1_lines" indexed="true"/>
                      </td>

                      <html:hidden property="codigo_marca1" name="bl_form_Jw_ref_cor_1_lines" indexed="true" styleId="codigo_marca1"/>
                      <html:hidden property="descricao_marca1" name="bl_form_Jw_ref_cor_1_lines" indexed="true" styleId="descricao_marca1"/>
                      <td class="tdGridField">
                        <html:text property="lin_cdgo1" styleId="modelo" styleClass="disabled" tabindex="-1" readonly="true" size="12" maxlength="30" name="bl_form_Jw_ref_cor_1_lines" indexed="true"/>
                      </td>
                      <td class="tdGridField">
                        <html:text property="ref_cdgo1" styleId="modelo" styleClass="disabled" tabindex="-1" readonly="true" size="12" maxlength="30" name="bl_form_Jw_ref_cor_1_lines" indexed="true"/>
                      </td>

                      <html:hidden property="pos" name="bl_form_Jw_ref_cor_1_lines" indexed="true" styleId="pos"/>
                    </tr>

                  </logic:iterate>

                </table>

                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit value="Pos" styleClass="myhidden" property="pos_action">
                      </html:submit>
                      <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:submit value="Adicionar Itens" styleClass="baseButton" property="selecionar_action">
                      </html:submit>
                      <html:submit value="Marcar Todos" styleClass="baseButton" property="marcar_todos_action">
                      </html:submit>
                      <html:submit value="Desmarcar Todos" styleClass="baseButton" property="desmarcar_todos_action">
                      </html:submit>
                    </td>
                  </tr>
                </table>

              </html:form>

              <%
            }
            %>
          </td>
        </tr>
      </table>

    </body>
  </center>
</html>

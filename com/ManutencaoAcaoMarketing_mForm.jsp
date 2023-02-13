<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      TÍTULO
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
                  <%
                  acesso.Usuario user = (acesso.Usuario) session.getAttribute("User");
                  if(!user.isSuperUsuario() && !user.isAutorizado(174)){
                    //   response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ManutencaoAcaoMarketing_mForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="acao_inicial"/>
                    <html:errors property="acao_final"/>
                    <html:errors property="acoes"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Ação de
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="acao_inicial" styleId="acao_inicial" styleClass="baseField" size="10"/>
                    <span class="spamFormLabel">
                      a
                    </span>
                    <html:text property="acao_final" styleId="acao_final" styleClass="baseField" size="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Ações
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="acoes" styleId="acoes" styleClass="baseField" size="40"/>
                    <span class='validateMessageuser'>
                      Separadas por vírgula
                    </span>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="baseButton" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit styleClass="myhidden" property="resetfull_ok_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:button accesskey="f" onclick="parent.tb_remove();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                  </td>
                </tr>
              </table>

              <script type="text/javascript">
                jQuery("#acao_inicial").focus();
              </script>
            </html:form>
            <%
            if(((String)session.getAttribute("mostra")+"").equals("s")){
              %>
              <html:form action="com/ManutencaoAcaoMarketing_mGrid.do" method="post" styleClass="baseForm">
                <table class="messageTable" style='width:99%;'>
                  <tr class="messageTr" >
                    <td class="messageTd">
                      <html:errors property="gridCheckField"/>
                      <html:errors property="data_entrega"/>
                      <html:errors property="data_entrada"/>
                      <html:errors property="nome_regional"/>
                      <html:errors property="acao"/>
                      <html:errors property="situacao"/>
                      <html:errors property="observacao"/>
                      <html:errors property="desc_material"/>
                      <html:errors property="descricao_marca"/>
                      <html:errors property="cracha_usuario"/>
                      <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing_1"/>
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
                        Dt.
                        <br>
                        Entrega
                      </span>
                    </td>

                    <td class="tdGridlabel">
                      <span class="spamFormLabel">
                        Dt.
                        <br>
                        Entrada
                      </span>
                    </td>

                    <td class="tdGridlabel">
                      <span class="spamFormLabel">
                        Reg.
                      </span>
                    </td>

                    <td class="tdGridlabel">
                      <span class="spamFormLabel">
                        Ação
                      </span>
                    </td>

                    <td class="tdGridlabel">
                      <span class="spamFormLabel">
                        Situação
                      </span>
                    </td>

                    <td class="tdGridlabel">
                      <span class="spamFormLabel">
                        Trabalho
                      </span>
                    </td>

                    <td class="tdGridlabel">
                      <span class="spamFormLabel">
                        Material
                      </span>
                    </td>

                    <td class="tdGridlabel">
                      <span class="spamFormLabel">
                        Marca
                      </span>
                    </td>

                    <td class="tdGridlabel">
                      <span class="spamFormLabel">
                        Crachá
                      </span>
                    </td>

                  </tr>

                  <logic:iterate id="bl_form_Jw_acao_marketing_1_lines" name="ManutencaoAcaoMarketing_mGridActionForm" property="bl_form_Jw_acao_marketing_1_lines" indexId="indexId">
                    <tr class="trGridField">
                      <td class="tdGridField">
                        <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_acao_marketing_1_lines" indexed="true"/>
                      </td>

                      <td class="tdGridField">
                        <html:text property="data_entrega" styleId="data_entrega" styleClass="baseField" size="10" maxlength="12" name="bl_form_Jw_acao_marketing_1_lines" indexed="true"/>
                      </td>

                      <td class="tdGridField">
                        <html:text property="data_entrada" styleId="data_entrada" styleClass="baseField" size="10" maxlength="12" name="bl_form_Jw_acao_marketing_1_lines" indexed="true"/>
                      </td>

                      <td class="tdGridField">
                        <html:text property="nome_regional" styleId="nome_regional" styleClass="baseField" size="3" maxlength="40" name="bl_form_Jw_acao_marketing_1_lines" indexed="true"/>
                      </td>

                      <td class="tdGridField">
                        <html:text property="acao" styleId="acao" styleClass="baseField" size="6" maxlength="-22" name="bl_form_Jw_acao_marketing_1_lines" indexed="true"/>
                      </td>

                      <td class="tdGridField">
                        <html:text property="situacao" styleId="situacao" styleClass="baseField" size="15" maxlength="1" name="bl_form_Jw_acao_marketing_1_lines" indexed="true"/>
                      </td>

                      <td class="tdGridField">
                        <html:text property="observacao" styleId="observacao" styleClass="baseField" size="35" maxlength="4000" name="bl_form_Jw_acao_marketing_1_lines" indexed="true"/>
                      </td>

                      <td class="tdGridField">
                        <html:text property="desc_material" styleId="desc_material" styleClass="baseField" size="30" maxlength="40" name="bl_form_Jw_acao_marketing_1_lines" indexed="true"/>
                      </td>

                      <html:hidden property="email" name="bl_form_Jw_acao_marketing_1_lines" indexed="true" styleId="email"/>
                      <td class="tdGridField">
                        <html:text property="descricao_marca" styleId="descricao_marca" styleClass="baseField" size="15" maxlength="30" name="bl_form_Jw_acao_marketing_1_lines" indexed="true"/>
                      </td>

                      <td class="tdGridField">
                        <html:text property="cracha_usuario" styleId="cracha_usuario" styleClass="baseField" size="10" maxlength="-22" name="bl_form_Jw_acao_marketing_1_lines" indexed="true"/>
                      </td>

                    </tr>

                  </logic:iterate>

                </table>

                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="p" styleClass="myhidden" property="select1_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:submit accesskey="p" value="Marcar Todas" styleClass="baseButton" property="marcar_action">
                      </html:submit>
                      <html:submit accesskey="a" value="Desmarcar Todas" styleClass="baseButton" property="desmarcar_action">
                      </html:submit>
                      <html:submit accesskey="a" value="Concluir Ações Selecionadas" onclick="return confirmSubmit('');" styleClass="baseButton" property="update_action">
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

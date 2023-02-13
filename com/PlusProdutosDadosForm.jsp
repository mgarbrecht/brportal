<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      PLUS Produtos - Dados do Produto
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
                  <%@ include file="../system/header_sem_ajuda.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(81)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/PlusProdutosDadosForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="referencia"/>
                    <html:errors property="descricao"/>
                    <html:errors property="status"/>
                    <html:errors property="dt_inicial"/>
                    <html:errors property="dt_final"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_linha_ref"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha - Referência
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="referencia" styleClass="disabled" tabindex="-1" readonly="true" size="44" maxlength="44"/>
                  </td>
                </tr>

                <html:hidden property="lin_cdgo"/>
                <html:hidden property="ref_cdgo"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="descricao" styleClass="disabled" tabindex="-1" readonly="true" size="53" maxlength="53"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Status
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="status" styleClass="disabled" tabindex="-1" readonly="true" size="7" maxlength="7"/>
                  </td>
                </tr>

              </table>
              <table class="separatorTable">
                <tr class="separatorTr">
                  <td colspan="2" class="separatorTd">
                    <b>
                      Administrador de Pedidos / Previsto Capacidade
                    </b>
                  </td>
                </tr>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel" style=" text-align:left; ">
                      Início
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_inicial" styleClass="baseField" size="4" maxlength="4"/>
                    <span class='validateMessageuser'>
                      <i>
                        Preencher no formato mmaa.
                      </i>
                    </span>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Fim
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_final" styleClass="baseField" size="4" maxlength="4"/>
                    <span class='validateMessageuser'>
                      <i>
                        Preencher no formato mmaa.
                      </i>
                    </span>
                  </td>
                </tr>

                <tr>
                  <td>
                  </td>
                  <td>
                    <html:button accesskey="p" onclick="this.disabled=true;select1_action.click();" styleClass="baseButton" property="selectadm_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:button>
                  </td>
                </tr>
              </table>
              <table class="itemTable" style='width:99%;'>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="b" onclick="history.go(-1)" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:button>
                    <html:submit value="Cabedais e Cores" onclick="bloqueia();" styleClass="baseButton" property="cabedal_action">
                    </html:submit>
                    <html:submit value="Disponibilidade de Vendas" styleClass="myhidden" property="disponibilidade1_action">
                    </html:submit>
                    <html:submit value="Vendas Encerradas" styleClass="myhidden" property="vendas_encerradas_action">
                    </html:submit>
                    <html:submit onclick="bloqueia();" styleClass="myhidden" property="select1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit styleClass="myhidden" property="select_action">
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="direto/CartaoCreditoForm.do" method="post" styleClass="baseForm">
              <table class="bannerTable" style="width:99%;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Processamento de Transação
                  </td>
                </tr>
              </table>

              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="negociacao"/>
                    <html:errors property="bandeira"/>
                    <html:errors property="nome_titular"/>
                    <html:errors property="numero_cartao"/>
                    <html:errors property="mes_validade"/>
                    <html:errors property="ano_validade"/>
                    <html:errors property="codigo_seguranca"/>
                    <html:errors property="valor"/>
                    <html:errors property="condicao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Dual"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                if(session.getAttribute("abrecartao")!= null){
                  session.removeAttribute("abrecartao");
                  %>
                  <script>
                    wopen('../direto/CartaoCreditoForm.jsp','_blank',640,300);
                  </script>

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Negociação
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="negociacao" styleClass="baseField" value="<%= request.getParameter("negociacao")!=null?(request.getParameter("negociacao")+""):"" %>" size="7"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Bandeira
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:select property="bandeira" styleId="bandeira" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="visa">
                        Visa
                      </html:option>
                      <html:option styleClass="baseOption" value="mastercard">
                        MasterCard
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nome do Titular
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="nome_titular" styleId="nome_titular" styleClass="baseField" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Número do Cartão
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="numero_cartao" styleId="numero_cartao" styleClass="baseField"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Mês/Ano Validade
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:select property="mes_validade" styleId="mes_validade" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="1">
                        1
                      </html:option>
                      <html:option styleClass="baseOption" value="2">
                        2
                      </html:option>
                      <html:option styleClass="baseOption" value="3">
                        3
                      </html:option>
                      <html:option styleClass="baseOption" value="4">
                        4
                      </html:option>
                      <html:option styleClass="baseOption" value="5">
                        5
                      </html:option>
                      <html:option styleClass="baseOption" value="6">
                        6
                      </html:option>
                      <html:option styleClass="baseOption" value="7">
                        7
                      </html:option>
                      <html:option styleClass="baseOption" value="8">
                        8
                      </html:option>
                      <html:option styleClass="baseOption" value="9">
                        9
                      </html:option>
                      <html:option styleClass="baseOption" value="10">
                        10
                      </html:option>
                      <html:option styleClass="baseOption" value="11">
                        11
                      </html:option>
                      <html:option styleClass="baseOption" value="12">
                        12
                      </html:option>
                    </html:select>
                    <span class="spamFormLabel">
                    </span>
                    <html:select property="ano_validade" styleId="ano_validade" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="2016">
                        2016
                      </html:option>
                      <html:option styleClass="baseOption" value="2017">
                        2017
                      </html:option>
                      <html:option styleClass="baseOption" value="2018">
                        2018
                      </html:option>
                      <html:option styleClass="baseOption" value="2019">
                        2019
                      </html:option>
                      <html:option styleClass="baseOption" value="2020">
                        2020
                      </html:option>
                      <html:option styleClass="baseOption" value="2021">
                        2021
                      </html:option>
                      <html:option styleClass="baseOption" value="2022">
                        2022
                      </html:option>
                      <html:option styleClass="baseOption" value="2023">
                        2023
                      </html:option>
                      <html:option styleClass="baseOption" value="2024">
                      </html:option>
                      <html:option styleClass="baseOption" value="2025">
                      </html:option>
                      <html:option styleClass="baseOption" value="2026">
                        2026
                      </html:option>
                      <html:option styleClass="baseOption" value="2027">
                        2027
                      </html:option>
                      <html:option styleClass="baseOption" value="2028">
                        2028
                      </html:option>
                      <html:option styleClass="baseOption" value="2029">
                        2029
                      </html:option>
                      <html:option styleClass="baseOption" value="2030">
                        2030
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Código de Segurança
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:password property="codigo_seguranca" styleId="codigo_seguranca" styleClass="baseField" size="3" maxlength="3"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Valor
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="valor" styleId="valor" styleClass="baseField" size="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Condição de Pagamento
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:select property="condicao" styleId="condicao" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="1">
                        À Vista
                      </html:option>
                      <html:option styleClass="baseOption" value="2">
                        2x vezes
                      </html:option>
                      <html:option styleClass="baseOption" value="3">
                        3x vezes
                      </html:option>
                    </html:select>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit value="Processar" onclick="this.value='Aguarde..';this.disabled=true;processar_action.click();" styleClass="baseButton" property="processar_button_action">
                    </html:submit>
                    <html:submit value="Processar" styleClass="myhidden" property="processar_action">
                    </html:submit>
                    <html:submit accesskey="r" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="s" onclick="wopen('../direto/CartaoCreditoForm.jsp','_blank',640,300)" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="r" styleClass="myhidden" property="refresh_action">
                      <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["negociacao"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <html:form action="direto/CartaoCreditoForm.do" method="post" styleClass="baseForm">
              <table class="bannerTable" style="width:99%;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Cancelamento de Transação
                  </td>
                </tr>
              </table>

              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="tid1"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Dual_1"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      TID
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="tid1" styleId="tid1" styleClass="baseField" size="25"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit value="Cancelar" styleClass="myhidden" property="cancelar_action">
                    </html:submit>
                    <html:button value="Cancelar Transação" onclick="this.value='Aguarde..';this.disabled=true;cancelar_action.click();" styleClass="baseButton" property="cancelar_button_action">
                    </html:button>
                    <html:submit accesskey="r" styleClass="baseButton" property="resetfull1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
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

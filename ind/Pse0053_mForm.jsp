<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <base target="_self">
    <title>
      Remessas/Talões
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(151)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            String tipo = (String)session.getAttribute("pse0053_tipo")+"";
            %>

            <html:form action="ind/Pse0053_mGrid.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:100%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="gridCheckField"/>
                    <html:errors property="rem_nro"/>
                    <html:errors property="tal_nro"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="pro_numero"/>
                    <html:errors property="tal_pares"/>
                    <html:errors property="data_pre_envio"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Atelier_pre_envio"/>
                  </td>
                </tr>
              </table>

              <%
              if((String)request.getAttribute("abre_automaticamente")=="N"){
                %>
                <table style=width:100%;margin-top:10;>
                  <tr>
                    <td class=columHeader style="text-align:center;">
                      <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                        <bean:message key="report.downloadxls"/>
                      </a>
                    </td>
                  </tr>
                </table>
                <%
              }
              %>


              <table class="itemGridTable" style='width:100%;'>
                <tr class="trGridLabel">
                  <%
                  if(tipo.equalsIgnoreCase("R")){
                    %>
                    <td class="tdGridlabel">
                      <span class="spamFormLabel">
                        Excluir
                      </span>
                    </td>
                    <%
                  }
                  %>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Remessa
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Talão
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Ref.
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Cabedal
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Cor
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Processo
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Pares
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Data Pre Envio
                    </span>
                  </td>

                </tr>

                <logic:iterate id="bl_form_Atelier_pre_envio_lines" name="Pse0053_mGridActionForm" property="bl_form_Atelier_pre_envio_lines" indexId="indexId">
                  <tr class="trGridField">

                    <%
                    if(tipo.equalsIgnoreCase("R")){
                      %>
                      <td class="tdGridField">
                        <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Atelier_pre_envio_lines" indexed="true"/>
                      </td>
                      <%
                    } else {
                      %>
                      <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="myhidden" value="true" name="bl_form_Atelier_pre_envio_lines" indexed="true"/>
                      <%
                    }
                    %>


                    <td class="tdGridField">
                      <html:text property="rem_nro" styleId="rem_nro" styleClass="disabled" tabindex="-1" readonly="true" size="8" maxlength="10" name="bl_form_Atelier_pre_envio_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="tal_nro" styleId="tal_nro" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="4" maxlength="4" name="bl_form_Atelier_pre_envio_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="lin_cdgo" styleId="lin_cdgo" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10" name="bl_form_Atelier_pre_envio_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="ref_cdgo" styleId="ref_cdgo" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5" name="bl_form_Atelier_pre_envio_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="cab_cdgo" styleId="cab_cdgo" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true"  size="7" maxlength="8" name="bl_form_Atelier_pre_envio_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="cor_cdgo" styleId="cor_cdgo" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="7" maxlength="8" name="bl_form_Atelier_pre_envio_lines" indexed="true"/>
                    </td>

                    <html:hidden property="for_codigo" name="bl_form_Atelier_pre_envio_lines" indexed="true" styleId="for_codigo"/>
                    <td class="tdGridField">
                      <html:text property="pro_numero" styleId="pro_numero" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true"  size="3" maxlength="3" name="bl_form_Atelier_pre_envio_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="tal_pares" styleId="tal_pares" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5" name="bl_form_Atelier_pre_envio_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="data_pre_envio" styleId="data_pre_envio" styleClass="disabled" tabindex="-1" readonly="true" size="16" maxlength="16" name="bl_form_Atelier_pre_envio_lines" indexed="true"/>
                    </td>

                    <html:hidden property="fen_seq" name="bl_form_Atelier_pre_envio_lines" indexed="true" styleId="fen_seq"/>
                    <html:hidden property="fil_filial" name="bl_form_Atelier_pre_envio_lines" indexed="true" styleId="fil_filial"/>
                  </tr>

                </logic:iterate>

              </table>

              <table class="buttonTable" style='width:100%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <%
                    if(tipo.equalsIgnoreCase("R")){
                      %>
                      <html:submit accesskey="a" styleClass="baseButton" property="delete_action">
                        <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                      </html:submit>
                      <%
                    } else {
                      %>
                      <html:submit accesskey="a" styleClass="myhidden" property="delete_action">
                        <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                      </html:submit>
                      <%
                    }
                    %>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                    <html:submit styleClass="myhidden" property="select1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit value="Gerar Planilha" styleClass="baseButton" property="gerar_planilha_action">
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body onload="if('<%= (String)request.getAttribute("selecionou_especies") %>' != 'null'){opener.document.forms[0].refresh_action.click();window.close();}">
      <table class="mainTable" style='width:600px;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvEspeciePedidoGrid.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:600px;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="itemGridTable" style='width:600px;'>
                <tr class="trGridLabel">
                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Espécie
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>

                </tr>

                <logic:iterate id="bl_form_Jw_especie_pedido_lines" name="LvEspeciePedidoGridActionForm" property="bl_form_Jw_especie_pedido_lines" indexId="indexId">
                  <tr class="trGridField">
                    <td class="tdGridField">
                      <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_especie_pedido_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="codigo" styleId="codigo" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10" name="bl_form_Jw_especie_pedido_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="descricao" styleId="descricao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="240" name="bl_form_Jw_especie_pedido_lines" indexed="true"/>
                    </td>

                    <html:hidden property="ordem" name="bl_form_Jw_especie_pedido_lines" indexed="true" styleId="ordem"/>
                    <td class="tdGridField">
                      <td class="tdGridField">
                        <td class="tdGridField">
                          <td class="tdGridField">
                            <td class="tdGridField">
                              <td class="tdGridField">
                                <td class="tdGridField">
                                  <td class="tdGridField">
                                    <td class="tdGridField">
                                      <td class="tdGridField">
                                        <td class="tdGridField">
                                          <td class="tdGridField">
                                            <td class="tdGridField">
                                              <td class="tdGridField">
                                                <td class="tdGridField">
                                                  <td class="tdGridField">
                                                    <td class="tdGridField">
                                                      <td class="tdGridField">
                                                        <td class="tdGridField">
                                                          <td class="tdGridField">
                                                            <td class="tdGridField">
                                                              <td class="tdGridField">
                                                                <td class="tdGridField">
                                                                  <td class="tdGridField">
                                                                    <td class="tdGridField">
                                                                      <td class="tdGridField">
                                                                        <td class="tdGridField">
                                                                          <td class="tdGridField">
                                                                            <td class="tdGridField">
                                                                              <td class="tdGridField">
                                                                                <td class="tdGridField">
                                                                                  <%
                                                                                  if(request.getAttribute("fechar")!= null) {
                                                                                    %>
                                                                                    <script>
                                                                                      window.close();
                                                                                    </script>
                                                                                    <%
                                                                                  }
                                                                                  %>
                                                                                </td>


                                                                              </td>


                                                                            </td>


                                                                          </td>


                                                                        </td>


                                                                      </td>


                                                                    </td>


                                                                  </td>


                                                                </td>


                                                              </td>


                                                            </td>


                                                          </td>


                                                        </td>


                                                      </td>


                                                    </td>


                                                  </td>


                                                </td>


                                              </td>


                                            </td>


                                          </td>


                                        </td>


                                      </td>


                                    </td>


                                  </td>


                                </td>


                              </td>


                            </td>


                          </td>


                        </td>


                      </td>


                    </td>

                  </tr>

                </logic:iterate>

              </table>

              <table class="buttonTable" style='width:600px;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="a" value="Selecionar" styleClass="baseButton" property="selecionar_action">
                    </html:submit>
                    <html:submit value="Marcar Todos" styleClass="baseButton" property="marcar_todos_action">
                    </html:submit>
                    <html:submit value="Desmarcar Todos" styleClass="baseButton" property="desmarcar_todos_action">
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

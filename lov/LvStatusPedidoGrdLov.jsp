<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvStatusPedidoGrdGrid.do" method="post" styleClass="baseForm">
              <table class="messageTable">
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="gridCheckField"/>
                    <html:errors property="status"/>
                    <html:errors property="descricao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_status_pedidos"/>
                  </td>
                </tr>
              </table>

              <table class="itemGridTable" style='width:;'>
                <tr class="trGridLabel">
                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Status
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>

                </tr>

                <logic:iterate id="bl_form_Jw_status_pedidos_lines" name="LvStatusPedidoGrdGridActionForm" property="bl_form_Jw_status_pedidos_lines" indexId="indexId">
                  <tr class="trGridField">
                    <td class="tdGridField">
                      <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_status_pedidos_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="status" styleId="status" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="10" name="bl_form_Jw_status_pedidos_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="descricao" styleId="descricao" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="240" name="bl_form_Jw_status_pedidos_lines" indexed="true"/>
                    </td>

                    <html:hidden property="return0" value="<%= request.getParameter("return0") %>" name="bl_form_Jw_status_pedidos_lines" indexed="true" styleId="return0"/>
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
                                                                                                                                                                                                              <td class="tdGridField">
                                                                                                                                                                                                                <td class="tdGridField">
                                                                                                                                                                                                                  <td class="tdGridField">
                                                                                                                                                                                                                    <td class="tdGridField">
                                                                                                                                                                                                                      <td class="tdGridField">
                                                                                                                                                                                                                        <%
                                                                                                                                                                                                                        if(request.getAttribute("selecionou")!=null){
                                                                                                                                                                                                                          %>

                                                                                                                                                                                                                          <script>
                                                                                                                                                                                                                            opener.document.forms[0].refresh_action.click();
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


                            </td>


                          </td>


                        </td>


                      </td>


                    </td>

                  </tr>

                </logic:iterate>

              </table>

              <table class="buttonTable" style='width:;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit value="Selecionar" styleClass="baseButton" property="selecionar_action">
                    </html:submit>
                    <html:submit value="Marcar Todos" styleClass="baseButton" property="marcar_todos_action">
                    </html:submit>
                    <html:submit value="Marcar Todos Menos C e F" styleClass="baseButton" property="marcar_cf_action">
                    </html:submit>
                    <html:submit value="Desmarcar Todos" styleClass="baseButton" property="desmarcar_todos_action">
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

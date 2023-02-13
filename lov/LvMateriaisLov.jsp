<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvMateriaisGrid.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="gridCheckField"/>
                    <html:errors property="ies_codigo"/>
                    <html:errors property="ies_descricao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_materiais_talao"/>
                  </td>
                </tr>
              </table>

              <table class="itemGridTable" style='width:500;'>
                <tr class="trGridLabel">
                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Peça
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

                <logic:iterate id="bl_form_Jw_lv_materiais_talao_lines" name="LvMateriaisGridActionForm" property="bl_form_Jw_lv_materiais_talao_lines" indexId="indexId">
                  <tr class="trGridField">
                    <td class="tdGridField">
                      <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_lv_materiais_talao_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="ies_codigo" styleId="ies_codigo" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="200" name="bl_form_Jw_lv_materiais_talao_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="ies_descricao" styleId="ies_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="100" maxlength="200" name="bl_form_Jw_lv_materiais_talao_lines" indexed="true"/>
                    </td>

                    <html:hidden property="return0" value="<%= request.getParameter("return0") %>" name="bl_form_Jw_lv_materiais_talao_lines" indexed="true" styleId="return0"/>
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
                                                                                                                                                                                                                                                                                                                            if(session.getAttribute("selecionou")!=null){
                                                                                                                                                                                                                                                                                                                              session.removeAttribute("selecionou");
                                                                                                                                                                                                                                                                                                                              %>
                                                                                                                                                                                                                                                                                                                              <script>
                                                                                                                                                                                                                                                                                                                                opener.document.forms[0].refresh_action.click();
                                                                                                                                                                                                                                                                                                                                javascript:window.close();
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

              <table class="buttonTable" style='width:500;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="a" value="Selecionar" styleClass="baseButton" property="update_action">
                    </html:submit>
                    <html:submit value="Marcar Todos" styleClass="baseButton" property="marcar_todos_action">
                    </html:submit>
                    <html:submit value="Desmarcar Todos" styleClass="baseButton" property="desmarcar_todos_action">
                    </html:submit>
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
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

            </html:form>
            <html:form action="lov/LvMateriaisLov.do" method="post" styleClass="baseForm">

              <table style="width:500;">
                <html:hidden property="forn_codigo"/>
                <html:hidden property="fil_filial"/>
                <html:hidden property="oco_numero"/>
                <html:hidden property="rem_nro"/>
                <html:hidden property="data_compra_inicial"/>
                <html:hidden property="data_compra_final"/>
                <html:hidden property="situacao"/>
              </table>

              <table style='width:500;'>
                <tr>
                  <td>
                    <html:submit accesskey="p" styleClass="myhidden" property="select1_action">
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

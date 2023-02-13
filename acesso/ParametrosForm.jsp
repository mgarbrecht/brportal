<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Manutenção de Parâmetros do Sistema
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
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario()){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="acesso/ParametrosGrid.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="gridCheckField"/>
                    <html:errors property="nome1"/>
                    <html:errors property="valor1"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Parametros_1"/>
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
                      Nome
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Valor
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>

                </tr>

                <logic:iterate id="bl_form_Parametros_1_lines" name="ParametrosGridActionForm" property="bl_form_Parametros_1_lines" indexId="indexId">
                  <tr class="trGridField">
                    <td class="tdGridField">
                      <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Parametros_1_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="nome1" styleId="nome1" styleClass="baseField" size="60" maxlength="400" name="bl_form_Parametros_1_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="valor1" styleId="valor1" styleClass="baseField" size="120" maxlength="4000" name="bl_form_Parametros_1_lines" indexed="true"/>
                    </td>

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

                    <html:hidden property="par_sist_codigo" value="BRNET" name="bl_form_Parametros_1_lines" indexed="true" styleId="par_sist_codigo"/>
                    <html:hidden property="pos1" name="bl_form_Parametros_1_lines" indexed="true" styleId="pos1"/>
                  </tr>

                </logic:iterate>

              </table>

              <table class="itemTable" style='width:99%;'>
                <%
                {
                  %>
                  <%
                  java.util.Vector res_Parametros = (java.util.Vector)session.getAttribute("res_Parametros");
                  %>
                  <%
                  String pos = "0";
                  if (res_Parametros!=null) {
                    pos = "" + res_Parametros.size();
                  }
                  %>
                </table>
                <table class="navigatorTable" style="width:99%;">
                  <tr class="navigatorTr" >
                    <td class="navigatorTd" >
                      <img border="0" style="cursor:pointer" src="../img/first.gif" title="First" onclick="javascript:new_pos0('1');" />
                      &nbsp;
                      <img border="0" style="cursor:pointer" src="../img/prev_group.gif" title="Previous" onclick="javascript:new_pos0(parseInt(document.forms[0].navigation_pos0.value)-15);" accesskey="m" />
                      &nbsp;
                      <img border="0" style="cursor:pointer" src="../img/prev.gif" title="Previous" onclick="javascript:new_pos0(parseInt(document.forms[0].navigation_pos0.value)-1);" accesskey="," />
                      &nbsp;
                      <input type="text" name="navigation_pos0" size="5" class="navigatorInput" >
                      &nbsp;
                      <img border="0" style="cursor:pointer" src="../img/next.gif" title="Next"  onclick="javascript:new_pos0(parseInt(document.forms[0].navigation_pos0.value)+1);" accesskey="." />
                      &nbsp;
                      <img border="0" style="cursor:pointer" src="../img/next_group.gif" title="Next"  onclick="javascript:new_pos0(parseInt(document.forms[0].navigation_pos0.value)+15);" accesskey=";" />
                      &nbsp;
                      <img border="0" style="cursor:pointer" src="../img/last.gif" title="Last" onclick="javascript:new_pos0(document.forms[0].navigation_max0.value);">
                      &nbsp;
                      <bean:message key="jsp.navigator.register"/>
                      :
                      <input type="text" name="navigation_max0" value="<%= pos %>" size="5" class="navigatorInput" >
                    </td>
                  </tr>
                  <script type="text/javascript">
                    if (document.forms[0].pos1[0].value!="") {
                      document.forms[0].navigation_pos0.value= parseInt(document.forms[0].pos1[0].value) + 1;
                    }
                    function new_pos0(POS) {
                      if (POS>0 && POS<=document.forms[0].navigation_max0.value ) {
                        document.forms[0].navigation_pos0.value=POS;
                        document.forms[0].pos1[0].value=parseInt(document.forms[0].navigation_pos0.value) - 1;
                        document.forms[0].pos1_action.click();
                      } else {
                        alert("<bean:message key="jsp.endregistries"/>");
                      }
                    }
                  </script>
                  <%}%>
                  </table>

                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:submit value="Pos" styleClass="myhidden" property="pos1_action">
                        </html:submit>
                        <html:submit accesskey="p" styleClass="baseButton" property="select1_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:submit>
                        <html:submit accesskey="i" styleClass="baseButton" property="insert1_action">
                          <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                        </html:submit>
                        <html:submit accesskey="a" styleClass="baseButton" property="update1_action">
                          <bean:message bundle="ApplicationResources" key="jsp.update"/>
                        </html:submit>
                        <html:submit accesskey="l" styleClass="baseButton" property="resetfull1_action">
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvUnidadeNegocioLov.do" method="post" styleClass="baseForm" target="_self">
              <table class="bannerTable" style="width:500;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Lista de Valores - Unidades de Negócio
                  </td>
                </tr>
              </table>

              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="unn_codigo"/>
                    <html:errors property="unn_descri"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Uni_negocio"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Unidade
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="unn_codigo" styleClass="baseField" size="3" maxlength="3"/>
                  </td>
                </tr>

                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="unn_descri" styleClass="baseField" size="50" maxlength="50"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:500;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="p" onclick="resetfull1_action.disabled=true;close_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:button>
                    <script>
                      function getKeySite(keyStroke) {
                        isNetscape=(document.layers);
                        eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                        which = String.fromCharCode(eventChooser).toLowerCase();
                        keyBuffer = which;
                        if(eventChooser == 13){
                        if(document.forms[0].select1_action.disabled==true){return false;}
                        document.forms[0].select1_action.disabled=true;
                        document.forms[0].resetfull1_action.disabled=true;
                        document.forms[0].close_action.disabled=true;
                        document.forms[0].select_action.click();
                      }
                    }
                  </script>
                  <SCRIPT>
                    document.onkeypress = getKeySite;
                    </SCRIPT><html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                    <html:button accesskey="c" onclick="javascript:window.close();" styleClass="baseButton" property="close_action"><bean:message bundle="ApplicationResources" key="jsp.close"/></html:button>
                    <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                    <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                    </td>
                    </tr>
                    </table>

                    </html:form><script type="text/javascript">
                    var focusControl = document.forms[0].elements["unn_codigo"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>

                  <%
                  {
                    %>

                    <%
                    java.util.Vector res_Uni_negocio = (java.util.Vector)session.getAttribute("res_Uni_negocio");
                    %>

                    <form  name="bl_report_Uni_negocio" id="bl_report_Uni_negocio" class="baseForm" method="post" >
                      <%
                      if (res_Uni_negocio!=null && res_Uni_negocio.size()>0) {
                        %>

                        <table id="TRbl_report_Uni_negocio"  class="reportTable"   style="width:500; "  >
                          <%
                          java.lang.String unn_codigo =  null;
                          java.lang.String unn_descri =  null;
                          %>

                          <tr class="reportTr">
                            <td class="columnTdHeader" style="text-align:left;" >
                              Unidade
                            </td>

                            <td class="columnTdHeader" style="text-align:left;" >
                              Descrição
                            </td>

                          </tr>

                          <%
                          int i_bl_report_Uni_negocio = 0;
                          while (i_bl_report_Uni_negocio<res_Uni_negocio.size()) {
                            portalbr.dbobj.table.Uni_negocio t_uni_negocio = (portalbr.dbobj.table.Uni_negocio)res_Uni_negocio.elementAt(i_bl_report_Uni_negocio);
                            unn_codigo = t_uni_negocio.getUnn_codigo()==null?"":t_uni_negocio.getUnn_codigo();
                            unn_descri = t_uni_negocio.getUnn_descri()==null?"":t_uni_negocio.getUnn_descri();
                            String style_bl_report_Uni_negocio="";
                            if (!((i_bl_report_Uni_negocio%2)!=0)) {
                              style_bl_report_Uni_negocio="rowColor";
                            } else {
                              style_bl_report_Uni_negocio="rowBlank";
                            }
                            %>

                            <tr class='<%= style_bl_report_Uni_negocio %>' id="TRbl_report_Uni_negocio<%=i_bl_report_Uni_negocio%>" >
                              <td class="reportColumn" style="text-align:left;" >
                                <%= unn_codigo %>
                              </td>

                              <td class="reportColumn" style="text-align:left;" >
                                <a href="javascript:setLov('<%= unn_codigo %>','<%= unn_descri %>')" style="cursor:hand">
                                  <%= unn_descri %>
                                </a>

                              </td>

                            </tr>

                            <%
                            i_bl_report_Uni_negocio++;
                            if (i_bl_report_Uni_negocio<res_Uni_negocio.size()) {
                              t_uni_negocio = (portalbr.dbobj.table.Uni_negocio)res_Uni_negocio.elementAt(i_bl_report_Uni_negocio);
                              unn_codigo = t_uni_negocio.getUnn_codigo()==null?"":t_uni_negocio.getUnn_codigo();
                              unn_descri = t_uni_negocio.getUnn_descri()==null?"":t_uni_negocio.getUnn_descri();
                            } else {
                            }
                          }
                          %>

                        </table>

                        <%
                      }
                      %>

                      <script type="text/javascript">
                        function setLov(UNN_CODIGO,UNN_DESCRI) {
                          <% {
                            String returnBlock = "0";
                            String return0 = null;
                            String return1 = null;
                            if (request.getParameter("returnBlock")!=null) {
                              returnBlock = request.getParameter("returnBlock");
                              session.setAttribute("returnBlock",returnBlock);
                              return0 = ((request.getParameter("return0")!=null)?request.getParameter("return0"):null);
                              session.setAttribute("return0",return0);
                              return1 = ((request.getParameter("return1")!=null)?request.getParameter("return1"):null);
                              session.setAttribute("return1",return1);
                              session.setAttribute("ge_LovPage", "LvUnidadeNegocioLov");
                            } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvUnidadeNegocioLov")) {
                              returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                              return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                              return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                            }
                            %>
                            returnBlock = <%= returnBlock %>;
                            <% if (return0!=null && return0.length()>0) {%>
                            if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=UNN_CODIGO; };
                            <%}%>
                            <% if (return1!=null && return1.length()>0) {%>
                            if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=UNN_DESCRI; };
                            <%}%>
                            window.close();
                          }
                          <% } %>
                        </script>

                      </form>
                      <%
                    }
                    %>

                  </td>
                </tr>
              </table>

            </body>
          </center>
        </html>

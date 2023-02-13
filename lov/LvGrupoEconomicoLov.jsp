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
            <html:form action="lov/LvGrupoEconomicoLov.do" method="post" styleClass="baseForm" target="_self">
              <table class="bannerTable" style="width:500;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Lista de Valores - Grupos Econômicos
                  </td>
                </tr>
              </table>

              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="gre_grupo"/>
                    <html:errors property="gre_descricao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Grupo_economico"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Grupo
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="gre_grupo" styleClass="baseField" size="6" maxlength="6"/>
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
                    <html:text property="gre_descricao" styleClass="baseField" size="30" maxlength="30"/>
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
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action"><bean:message bundle="ApplicationResources" key="jsp.close"/></html:button>
                    <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                    <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                    </td>
                    </tr>
                    </table>

                    </html:form><script type="text/javascript">
                    var focusControl = document.forms[0].elements["gre_grupo"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>

                  <%
                  {
                    %>

                    <%
                    java.util.Vector res_Grupo_economico = (java.util.Vector)session.getAttribute("res_Grupo_economico");
                    %>

                    <form  name="bl_report_Grupo_economico" id="bl_report_Grupo_economico" class="baseForm" method="post" >
                      <%
                      if (res_Grupo_economico!=null && res_Grupo_economico.size()>0) {
                        %>

                        <table id="TRbl_report_Grupo_economico"  class="reportTable"   style="width:500; "  >
                          <%
                          int gre_grupo =  0;
                          java.lang.String gre_descricao =  null;
                          %>

                          <tr class="reportTr">
                            <td class="columnTdHeader" style="text-align:right;" >
                              Grupo
                            </td>

                            <td class="columnTdHeader" style="text-align:left;" >
                              Descrição
                            </td>

                          </tr>

                          <%
                          int i_bl_report_Grupo_economico = 0;
                          while (i_bl_report_Grupo_economico<res_Grupo_economico.size()) {
                            portalbr.dbobj.table.Grupo_economico t_grupo_economico = (portalbr.dbobj.table.Grupo_economico)res_Grupo_economico.elementAt(i_bl_report_Grupo_economico);
                            gre_grupo = t_grupo_economico.getGre_grupo();
                            gre_descricao = t_grupo_economico.getGre_descricao()==null?"":t_grupo_economico.getGre_descricao();
                            String style_bl_report_Grupo_economico="";
                            if (!((i_bl_report_Grupo_economico%2)!=0)) {
                              style_bl_report_Grupo_economico="rowColor";
                            } else {
                              style_bl_report_Grupo_economico="rowBlank";
                            }
                            %>

                            <tr class='<%= style_bl_report_Grupo_economico %>' id="TRbl_report_Grupo_economico<%=i_bl_report_Grupo_economico%>" >
                              <td class="reportColumn" style="text-align:right;" >
                                <%= gre_grupo %>
                              </td>

                              <td class="reportColumn" style="text-align:left;" >
                                <a href="javascript:setLov('<%= gre_grupo %>','<%= gre_descricao %>')" style="cursor:hand">
                                  <%= gre_descricao %>
                                </a>

                              </td>

                            </tr>

                            <%
                            i_bl_report_Grupo_economico++;
                            if (i_bl_report_Grupo_economico<res_Grupo_economico.size()) {
                              t_grupo_economico = (portalbr.dbobj.table.Grupo_economico)res_Grupo_economico.elementAt(i_bl_report_Grupo_economico);
                              gre_grupo = t_grupo_economico.getGre_grupo();
                              gre_descricao = t_grupo_economico.getGre_descricao()==null?"":t_grupo_economico.getGre_descricao();
                            } else {
                            }
                          }
                          %>

                        </table>

                        <%
                      }
                      %>

                      <script type="text/javascript">
                        function setLov(GRE_GRUPO,GRE_DESCRICAO) {
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
                              session.setAttribute("ge_LovPage", "LvGrupoEconomicoLov");
                            } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvGrupoEconomicoLov")) {
                              returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                              return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                              return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                            }
                            %>
                            returnBlock = <%= returnBlock %>;
                            <% if (return0!=null && return0.length()>0) {%>
                            if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=GRE_GRUPO; };
                            <%}%>
                            <% if (return1!=null && return1.length()>0) {%>
                            if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=GRE_DESCRICAO; };
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

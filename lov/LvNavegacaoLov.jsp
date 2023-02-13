<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
  <bean:message key="page.script"/>
</head>
<center>
  <body>
    <table class="mainTable" style='width:500;'>
      <tr class="mainTr">
        <td class="mainTd">
          <table class="headerTable" style="width:500" >
            <tr>

              <td class="td10">
              </td>

            </tr>

          </table>

          <html:form action="lov/LvNavegacaoLov.do" method="post" styleClass="baseForm" target="_self">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Lista de Valores - Menus
                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="menu_nome"/>
                  <html:errors property="menu_texto"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Menus"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <html:hidden property="menu_id"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Nome
                  </span>
                </td>
                <td class="formField">
                  <html:text property="menu_nome" styleClass="baseField" size="60" maxlength="80"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Texto
                  </span>
                </td>
                <td class="formField">
                  <html:text property="menu_texto" styleClass="baseField" size="60" maxlength="255"/>
                </td>
              </tr>

              <html:hidden property="menu_pai_menu_id"/>
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
                  </SCRIPT><html:button accesskey="r" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                  <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action"><bean:message bundle="ApplicationResources" key="jsp.close"/></html:button>
                  <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                  <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form><script type="text/javascript">
                  var focusControl = document.forms[0].elements["menu_nome"];
                  if (focusControl.type != "hidden"){
                    focusControl.focus();
                  }
                </script>

                <%
                {
                  %>

                  <%
                  java.util.Vector res_Menus = (java.util.Vector)session.getAttribute("res_Menus");
                  %>

                  <form  name="bl_report_Menus" id="bl_report_Menus" class="baseForm" method="post" >
                    <%
                    if (res_Menus!=null && res_Menus.size()>0) {
                      %>

                      <table id="TRbl_report_Menus"  class="reportTable"   style="width:500; "  >
                        <%
                        java.lang.Integer menu_id =  null;
                        java.lang.String menu_nome =  null;
                        java.lang.String menu_texto =  null;
                        java.lang.Integer menu_pai_menu_id =  null;
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:left;" >
                            Nome
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Texto
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Pai
                          </td>

                        </tr>

                        <%
                        int i_bl_report_Menus = 0;
                        while (i_bl_report_Menus<res_Menus.size()) {
                          portalbr.dbobj.table.Menus t_menus = (portalbr.dbobj.table.Menus)res_Menus.elementAt(i_bl_report_Menus);
                          menu_id = t_menus.getMenu_id();
                          menu_nome = t_menus.getMenu_nome()==null?"":t_menus.getMenu_nome();
                          menu_texto = t_menus.getMenu_texto()==null?"":t_menus.getMenu_texto();
                          menu_pai_menu_id = t_menus.getMenu_pai_menu_id();
                          String style_bl_report_Menus="";
                          if (!((i_bl_report_Menus%2)!=0)) {
                            style_bl_report_Menus="rowColor";
                          } else {
                            style_bl_report_Menus="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Menus %>' id="TRbl_report_Menus<%=i_bl_report_Menus%>" >
                            <td class="reportColumn" style="text-align:left;" >
                              <a href="javascript:setLov('<%= menu_id %>','<%= menu_nome %>','<%= menu_texto %>','<%= menu_pai_menu_id %>')" style="cursor:hand">
                                <%= menu_nome %>
                              </a>

                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <%= menu_texto %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= ((menu_pai_menu_id!=null)?menu_pai_menu_id.toString():"") %>
                            </td>

                          </tr>

                          <%
                          i_bl_report_Menus++;
                          if (i_bl_report_Menus<res_Menus.size()) {
                            t_menus = (portalbr.dbobj.table.Menus)res_Menus.elementAt(i_bl_report_Menus);
                            menu_id = t_menus.getMenu_id();
                            menu_nome = t_menus.getMenu_nome()==null?"":t_menus.getMenu_nome();
                            menu_texto = t_menus.getMenu_texto()==null?"":t_menus.getMenu_texto();
                            menu_pai_menu_id = t_menus.getMenu_pai_menu_id();
                          } else {
                          }
                        }
                        %>

                      </table>

                      <%
                    }
                    %>

                    <script type="text/javascript">
                      function setLov(MENU_ID,MENU_NOME,MENU_TEXTO,MENU_PAI_MENU_ID) {
                        <% {
                          String returnBlock = "0";
                          String return0 = null;
                          String return1 = null;
                          String return2 = null;
                          String return3 = null;
                          if (request.getParameter("returnBlock")!=null) {
                            returnBlock = request.getParameter("returnBlock");
                            session.setAttribute("returnBlock",returnBlock);
                            return0 = ((request.getParameter("return0")!=null)?request.getParameter("return0"):null);
                            session.setAttribute("return0",return0);
                            return1 = ((request.getParameter("return1")!=null)?request.getParameter("return1"):null);
                            session.setAttribute("return1",return1);
                            return2 = ((request.getParameter("return2")!=null)?request.getParameter("return2"):null);
                            session.setAttribute("return2",return2);
                            return3 = ((request.getParameter("return3")!=null)?request.getParameter("return3"):null);
                            session.setAttribute("return3",return3);
                            session.setAttribute("ge_LovPage", "LvNavegacaoLov");
                          } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvNavegacaoLov")) {
                            returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                            return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                            return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                            return2 = ((session.getAttribute("return2")!=null)?(String)session.getAttribute("return2"):null);
                            return3 = ((session.getAttribute("return3")!=null)?(String)session.getAttribute("return3"):null);
                          }
                          %>
                          returnBlock = <%= returnBlock %>;
                          <% if (return0!=null && return0.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=MENU_ID; };
                          <%}%>
                          <% if (return1!=null && return1.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=MENU_NOME; };
                          <%}%>
                          <% if (return2!=null && return2.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return2%>!=null) { opener.document.forms[returnBlock].<%= return2 %>.value=MENU_TEXTO; };
                          <%}%>
                          <% if (return3!=null && return3.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return3%>!=null) { opener.document.forms[returnBlock].<%= return3 %>.value=MENU_PAI_MENU_ID; };
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

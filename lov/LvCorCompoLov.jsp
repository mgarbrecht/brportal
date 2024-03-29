<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
  <bean:message key="page.script"/>
</head>
<center>
  <body onload="document.forms[0].lin_cdgo.value=opener.document.forms[0].lin_cdgo.value;document.forms[0].ref_cdgo.value=opener.document.forms[0].ref_cdgo.value;document.forms[0].cab_cdgo.value=opener.document.forms[0].cab_cdgo.value;">
    <table class="mainTable" style='width:500;'>
      <tr class="mainTr">
        <td class="mainTd">
          <table class="headerTable" style="width:500" >
            <tr>

              <td class="td10">
              </td>

            </tr>

          </table>

          <html:form action="lov/LvCorCompoLov.do" method="post" styleClass="baseForm" target="_self">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Lista de Valores - Cores
                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="cor_cdgo"/>
                  <html:errors property="cor_desc"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_cor_compo"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    C�digo
                  </span>
                </td>
                <td class="formField">
                  <html:text property="cor_cdgo" styleClass="baseField" size="22" maxlength="22"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Descri��o
                  </span>
                </td>
                <td class="formField">
                  <html:text property="cor_desc" styleClass="baseField" size="30" maxlength="30"/>
                </td>
              </tr>

              <html:hidden property="lin_cdgo"/>
              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              <html:hidden property="ref_cdgo"/>
              <html:hidden property="cab_cdgo"/>
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
                  var focusControl = document.forms[0].elements["cor_cdgo"];
                  if (focusControl.type != "hidden"){
                    focusControl.focus();
                  }
                </script>

                <%
                {
                  %>

                  <%
                  java.util.Vector res_Jw_cor_compo = (java.util.Vector)session.getAttribute("res_Jw_cor_compo");
                  %>

                  <form  name="bl_report_Jw_cor_compo" id="bl_report_Jw_cor_compo" class="baseForm" method="post" >
                    <%
                    if (res_Jw_cor_compo!=null && res_Jw_cor_compo.size()>0) {
                      %>

                      <table id="TRbl_report_Jw_cor_compo"  class="reportTable"   style="width:500; "  >
                        <%
                        java.lang.Integer cor_cdgo =  null;
                        java.lang.String cor_desc =  null;
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:right;" >
                            C�digo
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Descri��o
                          </td>

                        </tr>

                        <%
                        int i_bl_report_Jw_cor_compo = 0;
                        while (i_bl_report_Jw_cor_compo<res_Jw_cor_compo.size()) {
                          portalbr.dbobj.view.Jw_cor_compo t_jw_cor_compo = (portalbr.dbobj.view.Jw_cor_compo)res_Jw_cor_compo.elementAt(i_bl_report_Jw_cor_compo);
                          cor_cdgo = t_jw_cor_compo.getCor_cdgo();
                          cor_desc = t_jw_cor_compo.getCor_desc()==null?"":t_jw_cor_compo.getCor_desc();
                          String style_bl_report_Jw_cor_compo="";
                          if (!((i_bl_report_Jw_cor_compo%2)!=0)) {
                            style_bl_report_Jw_cor_compo="rowColor";
                          } else {
                            style_bl_report_Jw_cor_compo="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Jw_cor_compo %>' id="TRbl_report_Jw_cor_compo<%=i_bl_report_Jw_cor_compo%>" >
                            <td class="reportColumn" style="text-align:right;" >
                              <%= ((cor_cdgo!=null)?cor_cdgo.toString():"") %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <a href="javascript:setLov('<%= cor_cdgo %>','<%= cor_desc %>')" style="cursor:hand">
                                <%= cor_desc %>
                              </a>

                            </td>

                          </tr>

                          <%
                          i_bl_report_Jw_cor_compo++;
                          if (i_bl_report_Jw_cor_compo<res_Jw_cor_compo.size()) {
                            t_jw_cor_compo = (portalbr.dbobj.view.Jw_cor_compo)res_Jw_cor_compo.elementAt(i_bl_report_Jw_cor_compo);
                            cor_cdgo = t_jw_cor_compo.getCor_cdgo();
                            cor_desc = t_jw_cor_compo.getCor_desc()==null?"":t_jw_cor_compo.getCor_desc();
                          } else {
                          }
                        }
                        %>

                      </table>

                      <%
                    }
                    %>

                    <script type="text/javascript">
                      function setLov(COR_CDGO,COR_DESC) {
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
                            session.setAttribute("ge_LovPage", "LvCorCompoLov");
                          } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvCorCompoLov")) {
                            returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                            return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                            return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                          }
                          %>
                          returnBlock = <%= returnBlock %>;
                          <% if (return0!=null && return0.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=COR_CDGO; };
                          <%}%>
                          <% if (return1!=null && return1.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=COR_DESC; };
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

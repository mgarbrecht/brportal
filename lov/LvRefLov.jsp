<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
  <bean:message key="page.script"/>
</head>
<center>
  <body onload="document.forms[0].lin_cdgo.value=opener.document.forms[0].lin_cdgo.value;">
    <table class="mainTable" style='width:500;'>
      <tr class="mainTr">
        <td class="mainTd">
          <table class="headerTable" style="width:500" >
            <tr>

              <td class="td10">
              </td>

            </tr>

          </table>

          <html:form action="lov/LvRefLov.do" method="post" styleClass="baseForm" target="_self">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  <bean:message bundle="LovResources" key="LvRef.titulo"/>

                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="ref_cdgo"/>
                  <html:errors property="ref_desc"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Ref"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <html:hidden property="lin_cdgo"/>
              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    <bean:message bundle="LovResources" key="LvRef.ref_cdgo"/>
                  </span>
                </td>
                <td class="formField">
                  <html:text property="ref_cdgo" styleClass="baseField" size="6"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    <bean:message bundle="LovResources" key="LvRef.ref_desc"/>
                  </span>
                </td>
                <td class="formField">
                  <html:text property="ref_desc" styleClass="baseField" size="25" maxlength="25"/>
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
                  </SCRIPT><html:button accesskey="r" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                  <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action"><bean:message bundle="ApplicationResources" key="jsp.close"/></html:button>
                  <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                  <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form><script type="text/javascript">
                  var focusControl = document.forms[0].elements["ref_cdgo"];
                  if (focusControl.type != "hidden"){
                    focusControl.focus();
                  }
                </script>

                <%
                {
                  %>

                  <%
                  java.util.Vector res_Ref = (java.util.Vector)session.getAttribute("res_Ref");
                  %>

                  <form  name="bl_report_Ref" id="bl_report_Ref" class="baseForm" method="post" >
                    <%
                    if (res_Ref!=null && res_Ref.size()>0) {
                      %>

                      <table id="TRbl_report_Ref"  class="reportTable"   style="width:500; "  >
                        <%
                        java.lang.Integer ref_cdgo =  null;
                        java.lang.String ref_desc =  null;
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:right;" >
                            <bean:message bundle="LovResources" key="LvRef.ref_cdgo"/>
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            <bean:message bundle="LovResources" key="LvRef.ref_desc"/>
                          </td>

                        </tr>

                        <%
                        int i_bl_report_Ref = 0;
                        while (i_bl_report_Ref<res_Ref.size()) {
                          portalbr.dbobj.table.Ref t_ref = (portalbr.dbobj.table.Ref)res_Ref.elementAt(i_bl_report_Ref);
                          ref_cdgo = t_ref.getRef_cdgo();
                          ref_desc = t_ref.getRef_desc()==null?"":t_ref.getRef_desc();
                          String style_bl_report_Ref="";
                          if (!((i_bl_report_Ref%2)!=0)) {
                            style_bl_report_Ref="rowColor";
                          } else {
                            style_bl_report_Ref="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Ref %>' id="TRbl_report_Ref<%=i_bl_report_Ref%>" >
                            <td class="reportColumn" style="text-align:right;" >
                              <%= ((ref_cdgo!=null)?ref_cdgo.toString():"") %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <a href="javascript:setLov('<%= ref_cdgo %>','<%= ref_desc %>')" style="cursor:hand">
                                <%= ref_desc %>
                              </a>

                            </td>

                          </tr>

                          <%
                          i_bl_report_Ref++;
                          if (i_bl_report_Ref<res_Ref.size()) {
                            t_ref = (portalbr.dbobj.table.Ref)res_Ref.elementAt(i_bl_report_Ref);
                            ref_cdgo = t_ref.getRef_cdgo();
                            ref_desc = t_ref.getRef_desc()==null?"":t_ref.getRef_desc();
                          } else {
                          }
                        }
                        %>

                      </table>

                      <%
                    }
                    %>

                    <script type="text/javascript">
                      function setLov(REF_CDGO,REF_DESC) {
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
                            session.setAttribute("ge_LovPage", "LvRefLov");
                          } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvRefLov")) {
                            returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                            return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                            return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                          }
                          %>
                          returnBlock = <%= returnBlock %>;
                          <% if (return0!=null && return0.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=REF_CDGO; };
                          <%}%>
                          <% if (return1!=null && return1.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=REF_DESC; };
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

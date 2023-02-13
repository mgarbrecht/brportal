<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
  <bean:message key="page.script"/>
</head>
<center>
  <body onload="if(opener.document.forms[0].lin_cdgo!=''){document.forms[0].lin_cdgo.value=opener.document.forms[0].lin_cdgo.value;}if(opener.document.forms[0].ref_cdgo!=''){document.forms[0].ref_cdgo.value=opener.document.forms[0].ref_cdgo.value;}">
    <table class="mainTable" style='width:500;'>
      <tr class="mainTr">
        <td class="mainTd">
          <table class="headerTable" style="width:500" >
            <tr>

              <td class="td10">
              </td>

            </tr>

          </table>

          <html:form action="lov/LvCabedalLov.do" method="post" styleClass="baseForm" target="_self">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  <bean:message bundle="LovResources" key="LvCabedal.titulo"/>

                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="cab_cdgo"/>
                  <html:errors property="cab_desc"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Cabedal"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    <bean:message bundle="LovResources" key="LvCabedal.cab_cdgo"/>
                  </span>
                </td>
                <td class="formField">
                  <html:text property="cab_cdgo" styleClass="baseField" size="4" maxlength="4"/>
                </td>
              </tr>

              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    <bean:message bundle="LovResources" key="LvCabedal.cab_desc"/>
                  </span>
                </td>
                <td class="formField">
                  <html:text property="cab_desc" styleClass="baseField" size="35" maxlength="35"/>
                </td>
              </tr>

              <html:hidden property="lin_cdgo"/>
              <html:hidden property="ref_cdgo"/>
            </table>

            <table class="buttonTable" style='width:500;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:button accesskey="P" onclick="resetfull1_action.disabled=true;close_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
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
                  var focusControl = document.forms[0].elements["cab_cdgo"];
                  if (focusControl.type != "hidden"){
                    focusControl.focus();
                  }
                </script>

                <%
                {
                  %>

                  <%
                  java.util.Vector res_Jw_lov_cabedal = (java.util.Vector)session.getAttribute("res_Jw_lov_cabedal");
                  %>

                  <form  name="bl_report_Jw_lov_cabedal" id="bl_report_Jw_lov_cabedal" class="baseForm" method="post" >
                    <%
                    if (res_Jw_lov_cabedal!=null && res_Jw_lov_cabedal.size()>0) {
                      %>

                      <table id="TRbl_report_Jw_lov_cabedal"  class="reportTable"   style="width:500; "  >
                        <%
                        java.lang.String cab_cdgo =  null;
                        java.lang.String cab_desc =  null;
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:left;" >
                            <bean:message bundle="LovResources" key="LvCabedal.cab_cdgo"/>
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            <bean:message bundle="LovResources" key="LvCabedal.cab_desc"/>
                          </td>

                        </tr>

                        <%
                        int i_bl_report_Jw_lov_cabedal = 0;
                        while (i_bl_report_Jw_lov_cabedal<res_Jw_lov_cabedal.size()) {
                          portalbr.dbobj.view.Jw_lov_cabedal t_jw_lov_cabedal = (portalbr.dbobj.view.Jw_lov_cabedal)res_Jw_lov_cabedal.elementAt(i_bl_report_Jw_lov_cabedal);
                          cab_cdgo = t_jw_lov_cabedal.getCab_cdgo()==null?"":t_jw_lov_cabedal.getCab_cdgo();
                          cab_desc = t_jw_lov_cabedal.getCab_desc()==null?"":t_jw_lov_cabedal.getCab_desc();
                          String style_bl_report_Jw_lov_cabedal="";
                          if (!((i_bl_report_Jw_lov_cabedal%2)!=0)) {
                            style_bl_report_Jw_lov_cabedal="rowColor";
                          } else {
                            style_bl_report_Jw_lov_cabedal="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Jw_lov_cabedal %>' id="TRbl_report_Jw_lov_cabedal<%=i_bl_report_Jw_lov_cabedal%>" >
                            <td class="reportColumn" style="text-align:left;" >
                              <%= cab_cdgo %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <a href="javascript:setLov('<%= cab_cdgo %>','<%= cab_desc %>')" style="cursor:hand">
                                <%= cab_desc %>
                              </a>

                            </td>

                          </tr>

                          <%
                          i_bl_report_Jw_lov_cabedal++;
                          if (i_bl_report_Jw_lov_cabedal<res_Jw_lov_cabedal.size()) {
                            t_jw_lov_cabedal = (portalbr.dbobj.view.Jw_lov_cabedal)res_Jw_lov_cabedal.elementAt(i_bl_report_Jw_lov_cabedal);
                            cab_cdgo = t_jw_lov_cabedal.getCab_cdgo()==null?"":t_jw_lov_cabedal.getCab_cdgo();
                            cab_desc = t_jw_lov_cabedal.getCab_desc()==null?"":t_jw_lov_cabedal.getCab_desc();
                          } else {
                          }
                        }
                        %>

                      </table>

                      <%
                    }
                    %>

                    <script type="text/javascript">
                      function setLov(CAB_CDGO,CAB_DESC) {
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
                            session.setAttribute("ge_LovPage", "LvCabedalLov");
                          } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvCabedalLov")) {
                            returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                            return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                            return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                          }
                          %>
                          returnBlock = <%= returnBlock %>;
                          <% if (return0!=null && return0.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CAB_CDGO; };
                          <%}%>
                          <% if (return1!=null && return1.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=CAB_DESC; };
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

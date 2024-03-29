<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
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

          <html:form action="lov/LvCorLov.do" method="post" styleClass="baseForm" target="_self">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  <bean:message bundle="LovResources" key="LvCor.titulo"/>

                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="cor_cdgo"/>
                  <html:errors property="cor_desc"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Cor"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    <bean:message bundle="LovResources" key="LvCor.cor_cdgo"/>
                  </span>
                </td>
                <td class="formField">
                  <html:text property="cor_cdgo" styleClass="baseField" size="6" maxlength="10"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    <bean:message bundle="LovResources" key="LvCor.cor_desc"/>
                  </span>
                </td>
                <td class="formField">
                  <html:text property="cor_desc" styleClass="baseField" size="30" maxlength="30"/>
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
                  var focusControl = document.forms[0].elements["cor_cdgo"];
                  if (focusControl.type != "hidden"){
                    focusControl.focus();
                  }
                </script>

                <%
                {
                  %>

                  <%
                  java.util.Vector res_Cor = (java.util.Vector)session.getAttribute("res_Cor");
                  %>

                  <form  name="bl_report_Cor" id="bl_report_Cor" class="baseForm" method="post" >
                    <%
                    if (res_Cor!=null && res_Cor.size()>0) {
                      %>

                      <table id="TRbl_report_Cor"  class="reportTable"   style="width:500; "  >
                        <%
                        int cor_cdgo =  0;
                        java.lang.String cor_desc =  null;
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:right;" >
                            <bean:message bundle="LovResources" key="LvCor.cor_cdgo"/>
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            <bean:message bundle="LovResources" key="LvCor.cor_desc"/>
                          </td>

                        </tr>

                        <%
                        int i_bl_report_Cor = 0;
                        while (i_bl_report_Cor<res_Cor.size()) {
                          portalbr.dbobj.table.Cor t_cor = (portalbr.dbobj.table.Cor)res_Cor.elementAt(i_bl_report_Cor);
                          cor_cdgo = t_cor.getCor_cdgo();
                          cor_desc = t_cor.getCor_desc()==null?"":t_cor.getCor_desc();
                          String style_bl_report_Cor="";
                          if (!((i_bl_report_Cor%2)!=0)) {
                            style_bl_report_Cor="rowColor";
                          } else {
                            style_bl_report_Cor="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Cor %>' id="TRbl_report_Cor<%=i_bl_report_Cor%>" >
                            <td class="reportColumn" style="text-align:right;" >
                              <%= cor_cdgo %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <a href="javascript:setLov('<%= cor_cdgo %>','<%= cor_desc %>')" style="cursor:hand">
                                <%= cor_desc %>
                              </a>

                            </td>

                          </tr>

                          <%
                          i_bl_report_Cor++;
                          if (i_bl_report_Cor<res_Cor.size()) {
                            t_cor = (portalbr.dbobj.table.Cor)res_Cor.elementAt(i_bl_report_Cor);
                            cor_cdgo = t_cor.getCor_cdgo();
                            cor_desc = t_cor.getCor_desc()==null?"":t_cor.getCor_desc();
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
                            session.setAttribute("ge_LovPage", "LvCorLov");
                          } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvCorLov")) {
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
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

          <html:form action="lov/LvFmaLov.do" method="post" styleClass="baseForm">
            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="fma_cdgo"/>
                  <html:errors property="fma_base"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Forma"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Forma
                  </span>
                </td>
                <td class="formField">
                  <html:text property="fma_cdgo" styleId="fma_cdgo" styleClass="baseField" size="10" maxlength="10"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Base
                  </span>
                </td>
                <td class="formField">
                  <html:text property="fma_base" styleId="fma_base" styleClass="baseField" size="50" maxlength="50"/>
                </td>
              </tr>

            </table>

            <table class="buttonTable" style='width:500;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:submit accesskey="p" styleClass="baseButton" property="select_action">
                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                  </html:submit>
                  <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                    <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:submit>
                  <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                    <bean:message bundle="ApplicationResources" key="jsp.close"/>
                  </html:button>
                </td>
              </tr>
            </table>

          </html:form>
          <script type="text/javascript">
            var focusControl = document.forms[0].elements["fma_cdgo"];
            if (focusControl.type != "hidden"){
              focusControl.focus();
            }
          </script>

          <%
          {
            %>

            <%
            java.util.Vector res_Forma = (java.util.Vector)session.getAttribute("res_Forma");
            %>

            <form  name="bl_report_Forma" id="bl_report_Forma" class="baseForm" method="post" >
              <%
              if (res_Forma!=null && res_Forma.size()>0) {
                %>

                <table id="TRbl_report_Forma"  class="reportTable"   style="width:500; "  >
                  <%
                  java.lang.String fma_cdgo =  null;
                  java.lang.String fma_base =  null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:left;" >
                      Forma
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Base
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Forma = 0;
                  while (i_bl_report_Forma<res_Forma.size()) {
                    portalbr.dbobj.table.Forma t_forma = (portalbr.dbobj.table.Forma)res_Forma.elementAt(i_bl_report_Forma);
                    fma_cdgo = t_forma.getFma_cdgo()==null?"":t_forma.getFma_cdgo();
                    fma_base = t_forma.getFma_base()==null?"":t_forma.getFma_base();
                    String style_bl_report_Forma="";
                    if (!((i_bl_report_Forma%2)!=0)) {
                      style_bl_report_Forma="rowColor";
                    } else {
                      style_bl_report_Forma="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Forma %>' id="TRbl_report_Forma<%=i_bl_report_Forma%>" >
                      <td class="reportColumn" style="text-align:left;" >
                        <a href="javascript:setLov('<%= fma_cdgo %>','<%= fma_base %>')" style="cursor:hand">
                          <%= fma_cdgo %>
                        </a>

                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= fma_base %>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Forma++;
                    if (i_bl_report_Forma<res_Forma.size()) {
                      t_forma = (portalbr.dbobj.table.Forma)res_Forma.elementAt(i_bl_report_Forma);
                      fma_cdgo = t_forma.getFma_cdgo()==null?"":t_forma.getFma_cdgo();
                      fma_base = t_forma.getFma_base()==null?"":t_forma.getFma_base();
                    } else {
                    }
                  }
                  %>

                </table>

                <%
              }
              %>

              <script type="text/javascript">
                function setLov(FMA_CDGO,FMA_BASE) {
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
                      session.setAttribute("ge_LovPage", "LvFmaLov");
                    } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvFmaLov")) {
                      returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                      return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                      return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                    }
                    %>
                    returnBlock = <%= returnBlock %>;
                    <% if (return0!=null && return0.length()>0) {%>
                    if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=FMA_CDGO; };
                    <%}%>
                    <% if (return1!=null && return1.length()>0) {%>
                    if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=FMA_BASE; };
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

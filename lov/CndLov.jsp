<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:600;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/CndLov.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:600;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      Lista de Valores - Condições de Pagamento
                    </div>
                    <html:errors property="cnd_cdgo"/>
                    <html:errors property="cnd_desc"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Cnd"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:600;">
                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Código
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cnd_cdgo" styleId="cnd_cdgo" styleClass="baseField" size="10" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cnd_desc" styleId="cnd_desc" styleClass="baseField" size="40" maxlength="100"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:600;'>
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
              var focusControl = document.forms[0].elements["cnd_cdgo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Cnd = (java.util.Vector)session.getAttribute("res_Cnd");
              %>

              <form  name="bl_report_Cnd" id="bl_report_Cnd" class="baseForm" method="post" >
                <%
                if (res_Cnd!=null && res_Cnd.size()>0) {
                  %>

                  <table id="TRbl_report_Cnd"  class="reportTable"   style="width:600; "  >
                    <%
                    java.lang.Integer cnd_cdgo =  null;
                    java.lang.String cnd_desc =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Código
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Cnd = 0;
                    while (i_bl_report_Cnd<res_Cnd.size()) {
                      portalbr.dbobj.table.Cnd t_cnd = (portalbr.dbobj.table.Cnd)res_Cnd.elementAt(i_bl_report_Cnd);
                      cnd_cdgo = t_cnd.getCnd_cdgo();
                      cnd_desc = t_cnd.getCnd_desc()==null?"":t_cnd.getCnd_desc();
                      String style_bl_report_Cnd="";
                      if (!((i_bl_report_Cnd%2)!=0)) {
                        style_bl_report_Cnd="rowColor";
                      } else {
                        style_bl_report_Cnd="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Cnd %>' id="TRbl_report_Cnd<%=i_bl_report_Cnd%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <a href="javascript:setLov('<%= cnd_cdgo %>','<%= cnd_desc %>')" style="cursor:hand">
                            <%= ((cnd_cdgo!=null)?cnd_cdgo.toString():"") %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= cnd_cdgo %>','<%= cnd_desc %>')" style="cursor:hand">
                            <%= cnd_desc %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Cnd++;
                      if (i_bl_report_Cnd<res_Cnd.size()) {
                        t_cnd = (portalbr.dbobj.table.Cnd)res_Cnd.elementAt(i_bl_report_Cnd);
                        cnd_cdgo = t_cnd.getCnd_cdgo();
                        cnd_desc = t_cnd.getCnd_desc()==null?"":t_cnd.getCnd_desc();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(CND_CDGO,CND_DESC) {
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
                        session.setAttribute("ge_LovPage", "CndLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("CndLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CND_CDGO; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=CND_DESC; };
                      <%}%>
                      window.close();
                    }
                    <% } %>

                    function setLov(CND_CDGO,CND_DESC) {
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
                          session.setAttribute("ge_LovPage", "CndLov");
                        } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("CndLov")) {
                          returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                          return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                          return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                        }
                        %>
                        returnBlock = <%= returnBlock %>;
                        <% if (return0!=null && return0.length()>0) {%>
                        if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CND_CDGO; };
                        <%}%>
                        <% if (return1!=null && return1.length()>0) {%>
                        if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=CND_DESC; };
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

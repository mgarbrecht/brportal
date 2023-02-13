<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvAtelierLov.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Atelier
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fo_codigo" styleId="fo_codigo" styleClass="baseField" size="9" maxlength="9"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Razão Social
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fo_razsoc" styleId="fo_razsoc" styleClass="baseField" size="40" maxlength="40"/>
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
              var focusControl = document.forms[0].elements["fo_codigo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Atelier_vw = (java.util.Vector)session.getAttribute("res_Atelier_vw");
              %>

              <form  name="bl_report_Atelier_vw" id="bl_report_Atelier_vw" class="baseForm" method="post" >
                <%
                if (res_Atelier_vw!=null && res_Atelier_vw.size()>0) {
                  %>

                  <table id="TRbl_report_Atelier_vw"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.Integer for_codigo =  null;
                    java.lang.String for_razsoc =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Atelier
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Razão Social
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Atelier_vw = 0;
                    while (i_bl_report_Atelier_vw<res_Atelier_vw.size()) {
                      portalbr.dbobj.table.Atelier_vw t_atelier_vw = (portalbr.dbobj.table.Atelier_vw)res_Atelier_vw.elementAt(i_bl_report_Atelier_vw);
                      for_codigo = t_atelier_vw.getFor_codigo();
                      for_razsoc = t_atelier_vw.getFor_razsoc()==null?"":t_atelier_vw.getFor_razsoc();
                      String style_bl_report_Atelier_vw="";
                      if (!((i_bl_report_Atelier_vw%2)!=0)) {
                        style_bl_report_Atelier_vw="rowColor";
                      } else {
                        style_bl_report_Atelier_vw="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Atelier_vw %>' id="TRbl_report_Atelier_vw<%=i_bl_report_Atelier_vw%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <a href="javascript:setLov('<%= for_codigo %>','<%= for_razsoc %>')" style="cursor:hand">
                            <%= ((for_codigo!=null)?for_codigo.toString():"") %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= for_codigo %>','<%= for_razsoc %>')" style="cursor:hand">
                            <%= for_razsoc %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Atelier_vw++;
                      if (i_bl_report_Atelier_vw<res_Atelier_vw.size()) {
                        t_atelier_vw = (portalbr.dbobj.table.Atelier_vw)res_Atelier_vw.elementAt(i_bl_report_Atelier_vw);
                        for_codigo = t_atelier_vw.getFor_codigo();
                        for_razsoc = t_atelier_vw.getFor_razsoc()==null?"":t_atelier_vw.getFor_razsoc();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(FOR_CODIGO,FOR_RAZSOC) {
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
                        session.setAttribute("ge_LovPage", "LvAtelierLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvAtelierLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=FOR_CODIGO; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=FOR_RAZSOC; };
                      <%}%>
                      window.close();
                    }
                    <% } %>

                    function setLov(FOR_CODIGO,FOR_RAZSOC) {
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
                          session.setAttribute("ge_LovPage", "LvAtelierLov");
                        } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvAtelierLov")) {
                          returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                          return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                          return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                        }
                        %>
                        returnBlock = <%= returnBlock %>;
                        <% if (return0!=null && return0.length()>0) {%>
                        if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=FOR_CODIGO; };
                        <%}%>
                        <% if (return1!=null && return1.length()>0) {%>
                        if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=FOR_RAZSOC; };
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

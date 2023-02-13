<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body onload="document.forms[0].linha.value=opener.document.forms[1].codigo_linha.value;document.forms[0].referencia.value=opener.document.forms[1].codigo_referencia.value;">
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvRefGdeLov.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="grade"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_gde"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Grade
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="grade" styleId="grade" styleClass="baseField" size="10" maxlength="10"/>
                  </td>
                </tr>

                <html:hidden property="linha"/>
                <html:hidden property="referencia"/>
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
              var focusControl = document.forms[0].elements["grade"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_ref_gde = (java.util.Vector)session.getAttribute("res_Jw_ref_gde");
              %>

              <form  name="bl_report_Jw_ref_gde" id="bl_report_Jw_ref_gde" class="baseForm" method="post" >
                <%
                if (res_Jw_ref_gde!=null && res_Jw_ref_gde.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_ref_gde"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.String grade =  null;
                    java.lang.String no_inicial =  null;
                    java.lang.String no_final =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Grade
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Nr. Inicial
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Nr. Final
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_ref_gde = 0;
                    while (i_bl_report_Jw_ref_gde<res_Jw_ref_gde.size()) {
                      portalbr.dbobj.view.Jw_ref_gde t_jw_ref_gde = (portalbr.dbobj.view.Jw_ref_gde)res_Jw_ref_gde.elementAt(i_bl_report_Jw_ref_gde);
                      grade = t_jw_ref_gde.getGrade()==null?"":t_jw_ref_gde.getGrade();
                      no_inicial = t_jw_ref_gde.getNo_inicial()==null?"":t_jw_ref_gde.getNo_inicial();
                      no_final = t_jw_ref_gde.getNo_final()==null?"":t_jw_ref_gde.getNo_final();
                      String style_bl_report_Jw_ref_gde="";
                      if (!((i_bl_report_Jw_ref_gde%2)!=0)) {
                        style_bl_report_Jw_ref_gde="rowColor";
                      } else {
                        style_bl_report_Jw_ref_gde="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_ref_gde %>' id="TRbl_report_Jw_ref_gde<%=i_bl_report_Jw_ref_gde%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= grade %>')" style="cursor:hand">
                            <%= grade %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= no_inicial %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= no_final %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_ref_gde++;
                      if (i_bl_report_Jw_ref_gde<res_Jw_ref_gde.size()) {
                        t_jw_ref_gde = (portalbr.dbobj.view.Jw_ref_gde)res_Jw_ref_gde.elementAt(i_bl_report_Jw_ref_gde);
                        grade = t_jw_ref_gde.getGrade()==null?"":t_jw_ref_gde.getGrade();
                        no_inicial = t_jw_ref_gde.getNo_inicial()==null?"":t_jw_ref_gde.getNo_inicial();
                        no_final = t_jw_ref_gde.getNo_final()==null?"":t_jw_ref_gde.getNo_final();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(GRADE) {
                    <% {
                      String returnBlock = "0";
                      String return0 = null;
                      if (request.getParameter("returnBlock")!=null) {
                        returnBlock = request.getParameter("returnBlock");
                        session.setAttribute("returnBlock",returnBlock);
                        return0 = ((request.getParameter("return0")!=null)?request.getParameter("return0"):null);
                        session.setAttribute("return0",return0);
                        session.setAttribute("ge_LovPage", "LvRefGdeLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvRefGdeLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=GRADE; };
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

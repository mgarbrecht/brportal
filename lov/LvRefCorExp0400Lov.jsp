<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body >
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvRefCorExp0400Lov.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="cor_cdgo"/>
                    <html:errors property="cor_desc"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_ref_cor_exp0400"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="EntPedidosForm.cor"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cor_cdgo" styleId="cor_cdgo" styleClass="baseField" size="10" maxlength="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="EntPedidosForm.descricao"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cor_desc" styleId="cor_desc" styleClass="baseField" size="60" maxlength="60"/>
                  </td>
                </tr>

                <html:hidden property="lin_cdgo" value="<%= request.getParameter("lin_cdgo") %>"/>
                <html:hidden property="ref_cdgo" value="<%= request.getParameter("ref_cdgo") %>"/>
                <html:hidden property="cab_cdgo" value="<%= request.getParameter("cab_cdgo") %>"/>
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
              var focusControl = document.forms[0].elements["cor_cdgo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_lv_ref_cor_exp0400 = (java.util.Vector)session.getAttribute("res_Jw_lv_ref_cor_exp0400");
              %>

              <form  name="bl_report_Jw_lv_ref_cor_exp0400" id="bl_report_Jw_lv_ref_cor_exp0400" class="baseForm" method="post" >
                <%
                if (res_Jw_lv_ref_cor_exp0400!=null && res_Jw_lv_ref_cor_exp0400.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_lv_ref_cor_exp0400"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.String cor_cdgo =  null;
                    java.lang.String cor_desc =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        <bean:message bundle="ComercialResources" key="EntPedidosForm.cor"/>
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        <bean:message bundle="ComercialResources" key="EntPedidosForm.descricao"/>
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_lv_ref_cor_exp0400 = 0;
                    while (i_bl_report_Jw_lv_ref_cor_exp0400<res_Jw_lv_ref_cor_exp0400.size()) {
                      portalbr.dbobj.view.Jw_lv_ref_cor_exp0400 t_jw_lv_ref_cor_exp0400 = (portalbr.dbobj.view.Jw_lv_ref_cor_exp0400)res_Jw_lv_ref_cor_exp0400.elementAt(i_bl_report_Jw_lv_ref_cor_exp0400);
                      cor_cdgo = t_jw_lv_ref_cor_exp0400.getCor_cdgo()==null?"":t_jw_lv_ref_cor_exp0400.getCor_cdgo();
                      cor_desc = t_jw_lv_ref_cor_exp0400.getCor_desc()==null?"":t_jw_lv_ref_cor_exp0400.getCor_desc();
                      String style_bl_report_Jw_lv_ref_cor_exp0400="";
                      if (!((i_bl_report_Jw_lv_ref_cor_exp0400%2)!=0)) {
                        style_bl_report_Jw_lv_ref_cor_exp0400="rowColor";
                      } else {
                        style_bl_report_Jw_lv_ref_cor_exp0400="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_lv_ref_cor_exp0400 %>' id="TRbl_report_Jw_lv_ref_cor_exp0400<%=i_bl_report_Jw_lv_ref_cor_exp0400%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= cor_cdgo %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= cor_cdgo %>','<%= cor_desc %>')" style="cursor:hand">
                            <%= cor_desc %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_lv_ref_cor_exp0400++;
                      if (i_bl_report_Jw_lv_ref_cor_exp0400<res_Jw_lv_ref_cor_exp0400.size()) {
                        t_jw_lv_ref_cor_exp0400 = (portalbr.dbobj.view.Jw_lv_ref_cor_exp0400)res_Jw_lv_ref_cor_exp0400.elementAt(i_bl_report_Jw_lv_ref_cor_exp0400);
                        cor_cdgo = t_jw_lv_ref_cor_exp0400.getCor_cdgo()==null?"":t_jw_lv_ref_cor_exp0400.getCor_cdgo();
                        cor_desc = t_jw_lv_ref_cor_exp0400.getCor_desc()==null?"":t_jw_lv_ref_cor_exp0400.getCor_desc();
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
                        session.setAttribute("ge_LovPage", "LvRefCorExp0400Lov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvRefCorExp0400Lov")) {
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

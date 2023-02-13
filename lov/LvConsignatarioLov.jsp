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
            <html:form action="lov/LvConsignatarioLov.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="tra_cdgo"/>
                    <html:errors property="tra_rzao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_consignatario"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Código
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="tra_cdgo" styleId="tra_cdgo" styleClass="baseField" size="22" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="tra_rzao" styleId="tra_rzao" styleClass="baseField" size="35" maxlength="35"/>
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
              var focusControl = document.forms[0].elements["tra_cdgo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_consignatario = (java.util.Vector)session.getAttribute("res_Jw_consignatario");
              %>

              <form  name="bl_report_Jw_consignatario" id="bl_report_Jw_consignatario" class="baseForm" method="post" >
                <%
                if (res_Jw_consignatario!=null && res_Jw_consignatario.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_consignatario"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.Integer tra_cdgo =  null;
                    java.lang.String tra_rzao =  null;
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
                    int i_bl_report_Jw_consignatario = 0;
                    while (i_bl_report_Jw_consignatario<res_Jw_consignatario.size()) {
                      portalbr.dbobj.view.Jw_consignatario t_jw_consignatario = (portalbr.dbobj.view.Jw_consignatario)res_Jw_consignatario.elementAt(i_bl_report_Jw_consignatario);
                      tra_cdgo = t_jw_consignatario.getTra_cdgo();
                      tra_rzao = t_jw_consignatario.getTra_rzao()==null?"":t_jw_consignatario.getTra_rzao();
                      String style_bl_report_Jw_consignatario="";
                      if (!((i_bl_report_Jw_consignatario%2)!=0)) {
                        style_bl_report_Jw_consignatario="rowColor";
                      } else {
                        style_bl_report_Jw_consignatario="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_consignatario %>' id="TRbl_report_Jw_consignatario<%=i_bl_report_Jw_consignatario%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((tra_cdgo!=null)?tra_cdgo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= tra_cdgo %>','<%= tra_rzao %>')" style="cursor:hand">
                            <%= tra_rzao %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_consignatario++;
                      if (i_bl_report_Jw_consignatario<res_Jw_consignatario.size()) {
                        t_jw_consignatario = (portalbr.dbobj.view.Jw_consignatario)res_Jw_consignatario.elementAt(i_bl_report_Jw_consignatario);
                        tra_cdgo = t_jw_consignatario.getTra_cdgo();
                        tra_rzao = t_jw_consignatario.getTra_rzao()==null?"":t_jw_consignatario.getTra_rzao();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(TRA_CDGO,TRA_RZAO) {
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
                        session.setAttribute("ge_LovPage", "LvConsignatarioLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvConsignatarioLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=TRA_CDGO; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=TRA_RZAO; };
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

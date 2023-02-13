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
            <html:form action="lov/LvSetorLov.do" method="post" styleClass="baseForm">
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
                      Setor
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="set_cdgo" styleId="set_cdgo" styleClass="baseField" size="5" maxlength="5"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nome
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="set_nome" styleId="set_nome" styleClass="baseField" size="40" maxlength="40"/>
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
              var focusControl = document.forms[0].elements["set_cdgo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Setor = (java.util.Vector)session.getAttribute("res_Setor");
              %>

              <form  name="bl_report_Setor" id="bl_report_Setor" class="baseForm" method="post" >
                <%
                if (res_Setor!=null && res_Setor.size()>0) {
                  %>

                  <table id="TRbl_report_Setor"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.String set_cdgo =  null;
                    java.lang.String set_nome =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Setor
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Nome
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Setor = 0;
                    while (i_bl_report_Setor<res_Setor.size()) {
                      portalbr.dbobj.table.Setor t_setor = (portalbr.dbobj.table.Setor)res_Setor.elementAt(i_bl_report_Setor);
                      set_cdgo = t_setor.getSet_cdgo()==null?"":t_setor.getSet_cdgo();
                      set_nome = t_setor.getSet_nome()==null?"":t_setor.getSet_nome();
                      String style_bl_report_Setor="";
                      if (!((i_bl_report_Setor%2)!=0)) {
                        style_bl_report_Setor="rowColor";
                      } else {
                        style_bl_report_Setor="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Setor %>' id="TRbl_report_Setor<%=i_bl_report_Setor%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= set_cdgo %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= set_cdgo %>','<%= set_nome %>')" style="cursor:hand">
                            <%= set_nome %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Setor++;
                      if (i_bl_report_Setor<res_Setor.size()) {
                        t_setor = (portalbr.dbobj.table.Setor)res_Setor.elementAt(i_bl_report_Setor);
                        set_cdgo = t_setor.getSet_cdgo()==null?"":t_setor.getSet_cdgo();
                        set_nome = t_setor.getSet_nome()==null?"":t_setor.getSet_nome();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(SET_CDGO,SET_NOME) {
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
                        session.setAttribute("ge_LovPage", "LvSetorLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvSetorLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=SET_CDGO; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=SET_NOME; };
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

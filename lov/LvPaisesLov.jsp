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
            <html:form action="lov/LvPaisesLov.do" method="post" styleClass="baseForm">
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
                      Descrição
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="descricao" styleId="descricao" styleClass="baseField" size="50" maxlength="50"/>
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
              var focusControl = document.forms[0].elements["descricao"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_paises = (java.util.Vector)session.getAttribute("res_Jw_paises");
              %>

              <form  name="bl_report_Jw_paises" id="bl_report_Jw_paises" class="baseForm" method="post" >
                <%
                if (res_Jw_paises!=null && res_Jw_paises.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_paises"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.String descricao =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_paises = 0;
                    while (i_bl_report_Jw_paises<res_Jw_paises.size()) {
                      portalbr.dbobj.view.Jw_paises t_jw_paises = (portalbr.dbobj.view.Jw_paises)res_Jw_paises.elementAt(i_bl_report_Jw_paises);
                      descricao = t_jw_paises.getDescricao()==null?"":t_jw_paises.getDescricao();
                      String style_bl_report_Jw_paises="";
                      if (!((i_bl_report_Jw_paises%2)!=0)) {
                        style_bl_report_Jw_paises="rowColor";
                      } else {
                        style_bl_report_Jw_paises="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_paises %>' id="TRbl_report_Jw_paises<%=i_bl_report_Jw_paises%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= descricao %>')" style="cursor:hand">
                            <%= descricao %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_paises++;
                      if (i_bl_report_Jw_paises<res_Jw_paises.size()) {
                        t_jw_paises = (portalbr.dbobj.view.Jw_paises)res_Jw_paises.elementAt(i_bl_report_Jw_paises);
                        descricao = t_jw_paises.getDescricao()==null?"":t_jw_paises.getDescricao();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(DESCRICAO) {
                    <% {
                      String returnBlock = "0";
                      String return0 = null;
                      if (request.getParameter("returnBlock")!=null) {
                        returnBlock = request.getParameter("returnBlock");
                        session.setAttribute("returnBlock",returnBlock);
                        return0 = ((request.getParameter("return0")!=null)?request.getParameter("return0"):null);
                        session.setAttribute("return0",return0);
                        session.setAttribute("ge_LovPage", "LvPaisesLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvPaisesLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=DESCRICAO; };
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

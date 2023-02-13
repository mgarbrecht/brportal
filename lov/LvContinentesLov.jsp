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
            <html:form action="lov/LvContinentesLov.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="con_codigo"/>
                    <html:errors property="con_descricao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_continentes"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Código
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="con_codigo" styleId="con_codigo" styleClass="baseField" size="4" maxlength="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="con_descricao" styleId="con_descricao" styleClass="baseField" size="40" maxlength="240"/>
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
              var focusControl = document.forms[0].elements["con_codigo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_continentes = (java.util.Vector)session.getAttribute("res_Jw_continentes");
              %>

              <form  name="bl_report_Jw_continentes" id="bl_report_Jw_continentes" class="baseForm" method="post" >
                <%
                if (res_Jw_continentes!=null && res_Jw_continentes.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_continentes"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.String con_codigo =  null;
                    java.lang.String con_descricao =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Código
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_continentes = 0;
                    while (i_bl_report_Jw_continentes<res_Jw_continentes.size()) {
                      portalbr.dbobj.view.Jw_continentes t_jw_continentes = (portalbr.dbobj.view.Jw_continentes)res_Jw_continentes.elementAt(i_bl_report_Jw_continentes);
                      con_codigo = t_jw_continentes.getCon_codigo()==null?"":t_jw_continentes.getCon_codigo();
                      con_descricao = t_jw_continentes.getCon_descricao()==null?"":t_jw_continentes.getCon_descricao();
                      String style_bl_report_Jw_continentes="";
                      if (!((i_bl_report_Jw_continentes%2)!=0)) {
                        style_bl_report_Jw_continentes="rowColor";
                      } else {
                        style_bl_report_Jw_continentes="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_continentes %>' id="TRbl_report_Jw_continentes<%=i_bl_report_Jw_continentes%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= con_codigo %>','<%= con_descricao %>')" style="cursor:hand">
                            <%= con_codigo %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= con_codigo %>','<%= con_descricao %>')" style="cursor:hand">
                            <%= con_descricao %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_continentes++;
                      if (i_bl_report_Jw_continentes<res_Jw_continentes.size()) {
                        t_jw_continentes = (portalbr.dbobj.view.Jw_continentes)res_Jw_continentes.elementAt(i_bl_report_Jw_continentes);
                        con_codigo = t_jw_continentes.getCon_codigo()==null?"":t_jw_continentes.getCon_codigo();
                        con_descricao = t_jw_continentes.getCon_descricao()==null?"":t_jw_continentes.getCon_descricao();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(CON_CODIGO,CON_DESCRICAO) {
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
                        session.setAttribute("ge_LovPage", "LvContinentesLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvContinentesLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CON_CODIGO; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=CON_DESCRICAO; };
                      <%}%>
                      window.close();
                    }
                    <% } %>

                    function setLov(CON_CODIGO,CON_DESCRICAO) {
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
                          session.setAttribute("ge_LovPage", "LvContinentesLov");
                        } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvContinentesLov")) {
                          returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                          return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                          return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                        }
                        %>
                        returnBlock = <%= returnBlock %>;
                        <% if (return0!=null && return0.length()>0) {%>
                        if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CON_CODIGO; };
                        <%}%>
                        <% if (return1!=null && return1.length()>0) {%>
                        if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=CON_DESCRICAO; };
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvTipoMidiaLov.do" method="post" styleClass="baseForm">
              <table class="bannerTable" style="width:500;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Lista de Valores - Tipo Material
                  </td>
                </tr>
              </table>

              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="cdgo_tmidia"/>
                    <html:errors property="desc_tmidia"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Tipo_midia"/>
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
                    <html:text property="cdgo_tmidia" styleId="cdgo_tmidia" styleClass="baseField" size="2" maxlength="2"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="desc_tmidia" styleId="desc_tmidia" styleClass="baseField" size="40" maxlength="40"/>
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
              var focusControl = document.forms[0].elements["cdgo_tmidia"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Tipo_midia = (java.util.Vector)session.getAttribute("res_Tipo_midia");
              %>

              <form  name="bl_report_Tipo_midia" id="bl_report_Tipo_midia" class="baseForm" method="post" >
                <%
                if (res_Tipo_midia!=null && res_Tipo_midia.size()>0) {
                  %>

                  <table id="TRbl_report_Tipo_midia"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.Integer cdgo_tmidia =  null;
                    java.lang.String desc_tmidia =  null;
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
                    int i_bl_report_Tipo_midia = 0;
                    while (i_bl_report_Tipo_midia<res_Tipo_midia.size()) {
                      portalbr.dbobj.table.Tipo_midia t_tipo_midia = (portalbr.dbobj.table.Tipo_midia)res_Tipo_midia.elementAt(i_bl_report_Tipo_midia);
                      cdgo_tmidia = t_tipo_midia.getCdgo_tmidia();
                      desc_tmidia = t_tipo_midia.getDesc_tmidia()==null?"":t_tipo_midia.getDesc_tmidia();
                      String style_bl_report_Tipo_midia="";
                      if (!((i_bl_report_Tipo_midia%2)!=0)) {
                        style_bl_report_Tipo_midia="rowColor";
                      } else {
                        style_bl_report_Tipo_midia="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Tipo_midia %>' id="TRbl_report_Tipo_midia<%=i_bl_report_Tipo_midia%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((cdgo_tmidia!=null)?cdgo_tmidia.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= cdgo_tmidia %>','<%= desc_tmidia %>')" style="cursor:hand">
                            <%= desc_tmidia %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Tipo_midia++;
                      if (i_bl_report_Tipo_midia<res_Tipo_midia.size()) {
                        t_tipo_midia = (portalbr.dbobj.table.Tipo_midia)res_Tipo_midia.elementAt(i_bl_report_Tipo_midia);
                        cdgo_tmidia = t_tipo_midia.getCdgo_tmidia();
                        desc_tmidia = t_tipo_midia.getDesc_tmidia()==null?"":t_tipo_midia.getDesc_tmidia();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(CDGO_TMIDIA,DESC_TMIDIA) {
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
                        session.setAttribute("ge_LovPage", "LvTipoMidiaLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvTipoMidiaLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CDGO_TMIDIA; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=DESC_TMIDIA; };
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

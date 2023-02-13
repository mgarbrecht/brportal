<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
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

          <html:form action="lov/LvRegiaoLov.do" method="post" styleClass="baseForm">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Lista de Valores - Microrregiões
                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="reg_cdgo"/>
                  <html:errors property="reg_nome"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Reg"/>
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
                  <html:text property="reg_cdgo" styleId="reg_cdgo" styleClass="baseField" size="3" maxlength="3"/>
                </td>
              </tr>

              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Microrregião
                  </span>
                </td>
                <td class="formField">
                  <html:text property="reg_nome" styleId="reg_nome" styleClass="baseField" size="30" maxlength="30"/>
                </td>
              </tr>

            </table>

            <table class="buttonTable" style='width:500;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:button accesskey="p" onclick="resetfull1_action.disabled=true;close_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                  </html:button>
                  <script>
                    function getKeySite(keyStroke) {
                      isNetscape=(document.layers);
                      eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                      which = String.fromCharCode(eventChooser).toLowerCase();
                      keyBuffer = which;
                      if(eventChooser == 13){
                      if(document.forms[0].select1_action.disabled==true){return false;}
                      document.forms[0].select1_action.disabled=true;
                      document.forms[0].resetfull1_action.disabled=true;
                      document.forms[0].close_action.disabled=true;
                      document.forms[0].select_action.click();
                    }
                  }
                </script>
                <SCRIPT>
                  document.onkeypress = getKeySite;
                  </SCRIPT><html:button accesskey="r" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                  <html:button accesskey="f" onclick="javascript:window.close();" styleClass="myhidden" property="close_action"><bean:message bundle="ApplicationResources" key="jsp.close"/></html:button>
                  <html:submit accesskey="s" styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                  <html:submit accesskey="r" styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form>
                  <%
                  {
                    %>

                    <%
                    java.util.Vector res_Reg = (java.util.Vector)session.getAttribute("res_Reg");
                    %>

                    <form  name="bl_report_Reg" id="bl_report_Reg" class="baseForm" method="post" >
                    <%
                    if (res_Reg!=null && res_Reg.size()>0) {
                      %>

                      <table id="TRbl_report_Reg"  class="reportTable"   style="width:500; "  >
                      <%
                      java.lang.String reg_cdgo =  null;
                      java.lang.String reg_nome =  null;
                      %>

                      <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                      Código
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                      Nome
                      </td>

                      </tr>

                      <%
                      int i_bl_report_Reg = 0;
                      while (i_bl_report_Reg<res_Reg.size()) {
                        portalbr.dbobj.table.Reg t_reg = (portalbr.dbobj.table.Reg)res_Reg.elementAt(i_bl_report_Reg);
                        reg_cdgo = t_reg.getReg_cdgo()==null?"":t_reg.getReg_cdgo();
                        reg_nome = t_reg.getReg_nome()==null?"":t_reg.getReg_nome();
                        String style_bl_report_Reg="";
                        if (!((i_bl_report_Reg%2)!=0)) {
                          style_bl_report_Reg="rowColor";
                        } else {
                          style_bl_report_Reg="rowBlank";
                        }
                        %>

                        <tr class='<%= style_bl_report_Reg %>' id="TRbl_report_Reg<%=i_bl_report_Reg%>" >
                        <td class="reportColumn" style="text-align:right;" >
                        <%= reg_cdgo %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                        <a href="javascript:setLov('<%= reg_cdgo %>','<%= reg_nome %>')" style="cursor:hand">
                        <%= reg_nome %>
                        </a>

                        </td>

                        </tr>

                        <%
                        i_bl_report_Reg++;
                        if (i_bl_report_Reg<res_Reg.size()) {
                          t_reg = (portalbr.dbobj.table.Reg)res_Reg.elementAt(i_bl_report_Reg);
                          reg_cdgo = t_reg.getReg_cdgo()==null?"":t_reg.getReg_cdgo();
                          reg_nome = t_reg.getReg_nome()==null?"":t_reg.getReg_nome();
                        } else {
                        }
                      }
                      %>

                      </table>

                      <%
                    }
                    %>

                    <script type="text/javascript">
                    function setLov(REG_CDGO,REG_NOME) {
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
                          session.setAttribute("ge_LovPage", "LvRegiaoLov");
                        } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvRegiaoLov")) {
                          returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                          return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                          return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                        }
                        %>
                        returnBlock = <%= returnBlock %>;
                        <% if (return0!=null && return0.length()>0) {%>
                        if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=REG_CDGO; };
                        <%}%>
                        <% if (return1!=null && return1.length()>0) {%>
                        if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=REG_NOME; };
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
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

          <html:form action="lov/LvTransportadoraLov.do" method="post" styleClass="baseForm" target="_self">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Lista de Valores - Transportadoras
                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="tra_cdgo"/>
                  <html:errors property="tra_nome"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Tra"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Cód. Transp.
                  </span>
                </td>
                <td class="formField">
                  <html:text property="tra_cdgo" styleClass="baseField" size="4" maxlength="4"/>
                </td>
              </tr>

              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Transp. Nome
                  </span>
                </td>
                <td class="formField">
                  <html:text property="tra_nome" styleClass="baseField" size="35" maxlength="35"/>
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
                  </SCRIPT><html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                  <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action"><bean:message bundle="ApplicationResources" key="jsp.close"/></html:button>
                  <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                  <html:submit accesskey="p" styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form><script type="text/javascript">
                  var focusControl = document.forms[0].elements["tra_cdgo"];
                  if (focusControl.type != "hidden"){
                    focusControl.focus();
                  }
                </script>

                <%
                {
                  %>

                  <%
                  java.util.Vector res_Tra = (java.util.Vector)session.getAttribute("res_Tra");
                  %>

                  <form  name="bl_report_Tra" id="bl_report_Tra" class="baseForm" method="post" >
                    <%
                    if (res_Tra!=null && res_Tra.size()>0) {
                      %>

                      <table id="TRbl_report_Tra"  class="reportTable"   style="width:500; "  >
                        <%
                        int tra_cdgo =  0;
                        java.lang.String tra_nome =  null;
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
                        int i_bl_report_Tra = 0;
                        while (i_bl_report_Tra<res_Tra.size()) {
                          portalbr.dbobj.table.Tra t_tra = (portalbr.dbobj.table.Tra)res_Tra.elementAt(i_bl_report_Tra);
                          tra_cdgo = t_tra.getTra_cdgo();
                          tra_nome = t_tra.getTra_nome()==null?"":t_tra.getTra_nome();
                          String style_bl_report_Tra="";
                          if (!((i_bl_report_Tra%2)!=0)) {
                            style_bl_report_Tra="rowColor";
                          } else {
                            style_bl_report_Tra="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Tra %>' id="TRbl_report_Tra<%=i_bl_report_Tra%>" >
                            <td class="reportColumn" style="text-align:right;" >
                              <%= tra_cdgo %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <a href="javascript:setLov('<%= tra_cdgo %>','<%= tra_nome %>')" style="cursor:hand">
                                <%= tra_nome %>
                              </a>

                            </td>

                          </tr>

                          <%
                          i_bl_report_Tra++;
                          if (i_bl_report_Tra<res_Tra.size()) {
                            t_tra = (portalbr.dbobj.table.Tra)res_Tra.elementAt(i_bl_report_Tra);
                            tra_cdgo = t_tra.getTra_cdgo();
                            tra_nome = t_tra.getTra_nome()==null?"":t_tra.getTra_nome();
                          } else {
                          }
                        }
                        %>

                      </table>

                      <%
                    }
                    %>

                    <script type="text/javascript">
                      function setLov(TRA_CDGO,TRA_NOME) {
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
                            session.setAttribute("ge_LovPage", "LvTransportadoraLov");
                          } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvTransportadoraLov")) {
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
                          if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=TRA_NOME; };
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

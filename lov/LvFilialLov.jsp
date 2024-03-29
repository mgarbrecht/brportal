<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
  <bean:message key="page.script"/>
</head>
<center>
  <body onload="document.forms[0].emp_empresa.value=opener.document.forms[0].emp_empresa.value">
    <table class="mainTable" style='width:500;'>
      <tr class="mainTr">
        <td class="mainTd">
          <table class="headerTable" style="width:500" >
            <tr>

              <td class="td10">
              </td>

            </tr>

          </table>

          <html:form action="lov/LvFilialLov.do" method="post" styleClass="baseForm" target="_self">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Lista de Valores - Filiais
                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="fil_filial"/>
                  <html:errors property="fil_razsoc"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Filial"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Filial
                  </span>
                </td>
                <td class="formField">
                  <html:text property="fil_filial" styleClass="baseField" size="4" maxlength="4"/>
                </td>
              </tr>

              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Raz�o Social
                  </span>
                </td>
                <td class="formField">
                  <html:text property="fil_razsoc" styleClass="baseField" size="50" maxlength="50"/>
                </td>
              </tr>

              <html:hidden property="emp_empresa" value="<%= (String)request.getParameter("emp_empresa") %>"/>
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
                  </SCRIPT>
                  <html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                  <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:button>
                  <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                  <bean:message bundle="ApplicationResources" key="jsp.close"/>
                  </html:button>
                  <html:submit styleClass="myhidden" property="select_action">
                  <bean:message bundle="ApplicationResources" key="jsp.select"/>
                  </html:submit>
                  <html:submit styleClass="myhidden" property="resetfull_action">
                  <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form>
                  <script type="text/javascript">
                  var focusControl = document.forms[0].elements["fil_filial"];
                  if (focusControl.type != "hidden"){
                    focusControl.focus();
                  }
                </script>

                <%
                {
                  %>

                  <%
                  java.util.Vector res_Filial = (java.util.Vector)session.getAttribute("res_Filial");
                  %>

                  <form  name="bl_report_Filial" id="bl_report_Filial" class="baseForm" method="post" >
                    <%
                    if (res_Filial!=null && res_Filial.size()>0) {
                      %>

                      <table id="TRbl_report_Filial"  class="reportTable"   style="width:500; "  >
                        <%
                        java.lang.String emp_empresa =  null;
                        java.lang.String fil_filial =  null;
                        java.lang.String fil_razsoc =  null;
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:left;" >
                            Empresa
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Filial
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Raz�o Social
                          </td>

                        </tr>

                        <%
                        int i_bl_report_Filial = 0;
                        while (i_bl_report_Filial<res_Filial.size()) {
                          portalbr.dbobj.table.Filial t_filial = (portalbr.dbobj.table.Filial)res_Filial.elementAt(i_bl_report_Filial);
                          emp_empresa = t_filial.getEmp_empresa()==null?"":t_filial.getEmp_empresa();
                          fil_filial = t_filial.getFil_filial()==null?"":t_filial.getFil_filial();
                          fil_razsoc = t_filial.getFil_razsoc()==null?"":t_filial.getFil_razsoc();
                          String style_bl_report_Filial="";
                          if (!((i_bl_report_Filial%2)!=0)) {
                            style_bl_report_Filial="rowColor";
                          } else {
                            style_bl_report_Filial="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Filial %>' id="TRbl_report_Filial<%=i_bl_report_Filial%>" >
                            <td class="reportColumn" style="text-align:left;" >
                              <%= emp_empresa %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <%= fil_filial %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <a href="javascript:setLov('<%= fil_filial %>','<%= fil_razsoc %>')" style="cursor:hand">
                                <%= fil_razsoc %>
                              </a>

                            </td>

                          </tr>

                          <%
                          i_bl_report_Filial++;
                          if (i_bl_report_Filial<res_Filial.size()) {
                            t_filial = (portalbr.dbobj.table.Filial)res_Filial.elementAt(i_bl_report_Filial);
                            emp_empresa = t_filial.getEmp_empresa()==null?"":t_filial.getEmp_empresa();
                            fil_filial = t_filial.getFil_filial()==null?"":t_filial.getFil_filial();
                            fil_razsoc = t_filial.getFil_razsoc()==null?"":t_filial.getFil_razsoc();
                          } else {
                          }
                        }
                        %>

                      </table>

                      <%
                    }
                    %>

                    <script type="text/javascript">
                      function setLov(FIL_FILIAL,FIL_RAZSOC) {
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
                            session.setAttribute("ge_LovPage", "LvFilialLov");
                          } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvFilialLov")) {
                            returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                            return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                            return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                          }
                          %>
                          returnBlock = <%= returnBlock %>;
                          <% if (return0!=null && return0.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=FIL_FILIAL; };
                          <%}%>
                          <% if (return1!=null && return1.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=FIL_RAZSOC; };
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

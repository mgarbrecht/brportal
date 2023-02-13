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

          <html:form action="lov/LvEstadosLov.do" method="post" styleClass="baseForm" target="_self">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Lista de Valores - Estados
                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="est_unifed"/>
                  <html:errors property="est_descri"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_estados"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    UF
                  </span>
                </td>
                <td class="formField">
                  <html:text property="est_unifed" styleClass="baseField" size="2" maxlength="2"/>
                </td>
              </tr>

              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Descrição
                  </span>
                </td>
                <td class="formField">
                  <html:text property="est_descri" styleClass="baseField" size="30" maxlength="30"/>
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
                  var focusControl = document.forms[0].elements["est_unifed"];
                  if (focusControl.type != "hidden"){
                    focusControl.focus();
                  }
                </script>

                <%
                {
                  %>

                  <%
                  java.util.Vector res_Jw_lv_estados = (java.util.Vector)session.getAttribute("res_Jw_lv_estados");
                  %>

                  <form  name="bl_report_Jw_lv_estados" id="bl_report_Jw_lv_estados" class="baseForm" method="post" >
                    <%
                    if (res_Jw_lv_estados!=null && res_Jw_lv_estados.size()>0) {
                      %>

                      <table id="TRbl_report_Jw_lv_estados"  class="reportTable"   style="width:500; "  >
                        <%
                        java.lang.String est_unifed =  null;
                        java.lang.String est_descri =  null;
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:left;" >
                            UF
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Descrição
                          </td>

                        </tr>

                        <%
                        int i_bl_report_Jw_lv_estados = 0;
                        while (i_bl_report_Jw_lv_estados<res_Jw_lv_estados.size()) {
                          portalbr.dbobj.view.Jw_lv_estados t_jw_lv_estados = (portalbr.dbobj.view.Jw_lv_estados)res_Jw_lv_estados.elementAt(i_bl_report_Jw_lv_estados);
                          est_unifed = t_jw_lv_estados.getEst_unifed()==null?"":t_jw_lv_estados.getEst_unifed();
                          est_descri = t_jw_lv_estados.getEst_descri()==null?"":t_jw_lv_estados.getEst_descri();
                          String style_bl_report_Jw_lv_estados="";
                          if (!((i_bl_report_Jw_lv_estados%2)!=0)) {
                            style_bl_report_Jw_lv_estados="rowColor";
                          } else {
                            style_bl_report_Jw_lv_estados="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Jw_lv_estados %>' id="TRbl_report_Jw_lv_estados<%=i_bl_report_Jw_lv_estados%>" >
                            <td class="reportColumn" style="text-align:left;" >
                              <%= est_unifed %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <a href="javascript:setLov('<%= est_unifed %>','<%= est_descri %>')" style="cursor:hand">
                                <%= est_descri %>
                              </a>

                            </td>

                          </tr>

                          <%
                          i_bl_report_Jw_lv_estados++;
                          if (i_bl_report_Jw_lv_estados<res_Jw_lv_estados.size()) {
                            t_jw_lv_estados = (portalbr.dbobj.view.Jw_lv_estados)res_Jw_lv_estados.elementAt(i_bl_report_Jw_lv_estados);
                            est_unifed = t_jw_lv_estados.getEst_unifed()==null?"":t_jw_lv_estados.getEst_unifed();
                            est_descri = t_jw_lv_estados.getEst_descri()==null?"":t_jw_lv_estados.getEst_descri();
                          } else {
                          }
                        }
                        %>

                      </table>

                      <%
                    }
                    %>

                    <script type="text/javascript">
                      function setLov(EST_UNIFED,EST_DESCRI) {
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
                            session.setAttribute("ge_LovPage", "LvEstadosLov");
                          } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvEstadosLov")) {
                            returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                            return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                            return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                          }
                          %>
                          returnBlock = <%= returnBlock %>;
                          <% if (return0!=null && return0.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=EST_UNIFED; };
                          <%}%>
                          <% if (return1!=null && return1.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=EST_DESCRI; };
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body onload="document.forms[0].codigo_marca.value=opener.document.forms[0].codigo_marca.value;">
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvLinhaRefLov.do" method="post" styleClass="baseForm" target="_self">
              <table class="bannerTable" style="width:500;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Lista de Valores - Linhas
                  </td>
                </tr>
              </table>

              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_lin_ref"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleClass="baseField" size="22" maxlength="22"/>
                  </td>
                </tr>

                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nome
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_nome" styleClass="baseField" size="25" maxlength="25"/>
                  </td>
                </tr>

                <html:hidden property="codigo_marca"/>
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
                    <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                    <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                    </td>
                    </tr>
                    </table>

                    </html:form><script type="text/javascript">
                    var focusControl = document.forms[0].elements["lin_cdgo"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>

                  <%
                  {
                    %>

                    <%
                    java.util.Vector res_Jw_lv_lin_ref = (java.util.Vector)session.getAttribute("res_Jw_lv_lin_ref");
                    %>

                    <form  name="bl_report_Jw_lv_lin_ref" id="bl_report_Jw_lv_lin_ref" class="baseForm" method="post" >
                      <%
                      if (res_Jw_lv_lin_ref!=null && res_Jw_lv_lin_ref.size()>0) {
                        %>

                        <pg:pager id="bl_report_Jw_lv_lin_ref" items="<%=res_Jw_lv_lin_ref.size()%>" index="center" maxPageItems="18" maxIndexPages="5" scope="request" export="offset,currentPageNumber=pageNumber" >
                          <table id="TRbl_report_Jw_lv_lin_ref"  class="reportTable"   style="width:500; "  >
                            <%
                            java.lang.String lin_cdgo =  null;
                            java.lang.String lin_nome =  null;
                            %>

                            <tr class="reportTr">
                              <td class="columnTdHeader" style="text-align:left;" >
                                Linha
                              </td>

                              <td class="columnTdHeader" style="text-align:left;" >
                                Nome
                              </td>

                            </tr>

                            <%
                            int i_bl_report_Jw_lv_lin_ref = 0;
                            while (i_bl_report_Jw_lv_lin_ref<res_Jw_lv_lin_ref.size()) {
                              portalbr.dbobj.view.Jw_lv_lin_ref t_jw_lv_lin_ref = (portalbr.dbobj.view.Jw_lv_lin_ref)res_Jw_lv_lin_ref.elementAt(i_bl_report_Jw_lv_lin_ref);
                              lin_cdgo = t_jw_lv_lin_ref.getLin_cdgo()==null?"":t_jw_lv_lin_ref.getLin_cdgo();
                              lin_nome = t_jw_lv_lin_ref.getLin_nome()==null?"":t_jw_lv_lin_ref.getLin_nome();
                              String style_bl_report_Jw_lv_lin_ref="";
                              if (!((i_bl_report_Jw_lv_lin_ref%2)!=0)) {
                                style_bl_report_Jw_lv_lin_ref="rowColor";
                              } else {
                                style_bl_report_Jw_lv_lin_ref="rowBlank";
                              }
                              %>

                              <pg:item>
                                <tr class='<%= style_bl_report_Jw_lv_lin_ref %>' id="TRbl_report_Jw_lv_lin_ref<%=i_bl_report_Jw_lv_lin_ref%>" >
                                  <td class="reportColumn" style="text-align:left;" >
                                    <%= lin_cdgo %>
                                  </td>

                                  <td class="reportColumn" style="text-align:left;" >
                                    <a href="javascript:setLov('<%= lin_cdgo %>','<%= lin_nome %>')" style="cursor:hand">
                                      <%= lin_nome %>
                                    </a>

                                  </td>

                                </tr>

                              </pg:item>
                              <%
                              i_bl_report_Jw_lv_lin_ref++;
                              if (i_bl_report_Jw_lv_lin_ref<res_Jw_lv_lin_ref.size()) {
                                t_jw_lv_lin_ref = (portalbr.dbobj.view.Jw_lv_lin_ref)res_Jw_lv_lin_ref.elementAt(i_bl_report_Jw_lv_lin_ref);
                                lin_cdgo = t_jw_lv_lin_ref.getLin_cdgo()==null?"":t_jw_lv_lin_ref.getLin_cdgo();
                                lin_nome = t_jw_lv_lin_ref.getLin_nome()==null?"":t_jw_lv_lin_ref.getLin_nome();
                              } else {
                              }
                            }
                            %>

                          </table>

                          <pg:index id="bl_report_Jw_lv_lin_ref" >
                            <table class="pageNavigatorTable" width="100%" cellpadding="2" cellspacing="0" border="0" bgcolor="#e3e9f8">
                              <tr class="pageNavigatorTr" >
                                <td class="pageNavigatorTd">
                                  <font face="verdana" color="#aaaaaa" size="-1">
                                    <pg:prev export="pageUrl" ifnull="<%= true %>">
                                      <%
                                      if (pageUrl == null) {
                                        %>
                                        <b>
                                          &laquo; Anterior
                                        </b>
                                        <%
                                      } else {
                                        %>
                                        <font color="#ff0000">
                                          <b>
                                            &laquo;
                                          </b>
                                        </font>
                                        <a href="<%= pageUrl %>">
                                          <b>
                                            Anterior
                                          </b>
                                        </a>
                                        <%
                                      }
                                      %>
                                    </pg:prev>
                                    &nbsp;
                                    <pg:pages export="pageUrl,firstItem,lastItem">
                                      <a href="<%= pageUrl %>">
                                        <b>
                                          <%= firstItem %>
                                          a
                                          <%= lastItem %>
                                        </b>
                                      </a>
                                      &nbsp;
                                    </pg:pages>
                                    &nbsp;
                                    <pg:next export="pageUrl" ifnull="<%= true %>">
                                      <%
                                      if (pageUrl == null) {
                                        %>
                                        <b>
                                          Next &raquo;
                                        </b>
                                        <%
                                      } else {
                                        %>
                                        <a href="<%= pageUrl %>">
                                          <b>
                                            Próximo
                                          </b>
                                        </a>
                                        <font color="#ff0000">
                                          <b>
                                            &raquo;
                                          </b>
                                        </font>
                                        <%
                                      }
                                      %>
                                    </pg:next>
                                  </td>
                                </tr>
                              </table>

                            </pg:index>
                          </pg:pager>
                          <%
                        }
                        %>

                        <script type="text/javascript">
                          function setLov(LIN_CDGO,LIN_NOME) {
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
                                session.setAttribute("ge_LovPage", "LvLinhaRefLov");
                              } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvLinhaRefLov")) {
                                returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                                return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                                return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                              }
                              %>
                              returnBlock = <%= returnBlock %>;
                              <% if (return0!=null && return0.length()>0) {%>
                              if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=LIN_CDGO; };
                              <%}%>
                              <% if (return1!=null && return1.length()>0) {%>
                              if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=LIN_NOME; };
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

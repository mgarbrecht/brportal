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

          <html:form action="lov/LvEmpresaLov.do" method="post" styleClass="baseForm" target="_self">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Lista de Valores - Empresas
                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="emp_empresa"/>
                  <html:errors property="emp_razsoc"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Empresa"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Empresa
                  </span>
                </td>
                <td class="formField">
                  <html:text property="emp_empresa" styleClass="baseField" size="3" maxlength="3"/>
                </td>
              </tr>

              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Razão Social
                  </span>
                </td>
                <td class="formField">
                  <html:text property="emp_razsoc" styleClass="baseField" size="50" maxlength="50"/>
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
                  <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action"><bean:message bundle="ApplicationResources" key="jsp.close"/></html:button>
                  <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                  <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form><script type="text/javascript">
                  var focusControl = document.forms[0].elements["emp_empresa"];
                  if (focusControl.type != "hidden"){
                    focusControl.focus();
                  }
                </script>

                <%
                {
                  %>

                  <%
                  java.util.Vector res_Empresa = (java.util.Vector)session.getAttribute("res_Empresa");
                  %>

                  <form  name="bl_report_Empresa" id="bl_report_Empresa" class="baseForm" method="post" >
                    <%
                    if (res_Empresa!=null && res_Empresa.size()>0) {
                      %>

                      <pg:pager id="bl_report_Empresa" items="<%=res_Empresa.size()%>" index="center" maxPageItems="18" maxIndexPages="5" scope="request" export="offset,currentPageNumber=pageNumber" >
                        <table id="TRbl_report_Empresa"  class="reportTable"   style="width:500; "  >
                          <%
                          java.lang.String emp_empresa =  null;
                          java.lang.String emp_razsoc =  null;
                          %>

                          <tr class="reportTr">
                            <td class="columnTdHeader" style="text-align:left;" >
                              Empresa
                            </td>

                            <td class="columnTdHeader" style="text-align:left;" >
                              Razão Social
                            </td>

                          </tr>

                          <%
                          int i_bl_report_Empresa = 0;
                          while (i_bl_report_Empresa<res_Empresa.size()) {
                            portalbr.dbobj.table.Empresa t_empresa = (portalbr.dbobj.table.Empresa)res_Empresa.elementAt(i_bl_report_Empresa);
                            emp_empresa = t_empresa.getEmp_empresa()==null?"":t_empresa.getEmp_empresa();
                            emp_razsoc = t_empresa.getEmp_razsoc()==null?"":t_empresa.getEmp_razsoc();
                            String style_bl_report_Empresa="";
                            if (!((i_bl_report_Empresa%2)!=0)) {
                              style_bl_report_Empresa="rowColor";
                            } else {
                              style_bl_report_Empresa="rowBlank";
                            }
                            %>

                            <pg:item>
                              <tr class='<%= style_bl_report_Empresa %>' id="TRbl_report_Empresa<%=i_bl_report_Empresa%>" >
                                <td class="reportColumn" style="text-align:left;" >
                                  <%= emp_empresa %>
                                </td>

                                <td class="reportColumn" style="text-align:left;" >
                                  <a href="javascript:setLov('<%= emp_empresa %>','<%= emp_razsoc %>')" style="cursor:hand">
                                    <%= emp_razsoc %>
                                  </a>

                                </td>

                              </tr>

                            </pg:item>
                            <%
                            i_bl_report_Empresa++;
                            if (i_bl_report_Empresa<res_Empresa.size()) {
                              t_empresa = (portalbr.dbobj.table.Empresa)res_Empresa.elementAt(i_bl_report_Empresa);
                              emp_empresa = t_empresa.getEmp_empresa()==null?"":t_empresa.getEmp_empresa();
                              emp_razsoc = t_empresa.getEmp_razsoc()==null?"":t_empresa.getEmp_razsoc();
                            } else {
                            }
                          }
                          %>

                        </table>

                        <pg:index id="bl_report_Empresa" >
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
                        function setLov(EMP_EMPRESA,EMP_RAZSOC) {
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
                              session.setAttribute("ge_LovPage", "LvEmpresaLov");
                            } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvEmpresaLov")) {
                              returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                              return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                              return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                            }
                            %>
                            returnBlock = <%= returnBlock %>;
                            <% if (return0!=null && return0.length()>0) {%>
                            if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=EMP_EMPRESA; };
                            <%}%>
                            <% if (return1!=null && return1.length()>0) {%>
                            if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=EMP_RAZSOC; };
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

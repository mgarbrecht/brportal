<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
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
            <html:form action="lov/LvClienteSeqLov.do" method="post" styleClass="baseForm" target="_self">
              <table class="bannerTable" style="width:500;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Lista de Valores - Clientes
                  </td>
                </tr>
              </table>

              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_clientes"/>
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
                    <html:text property="cli_cdgo" styleClass="baseField"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Razão Social
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="cli_rzao" styleClass="baseField" size="35" maxlength="35"/>
                  </td>
                </tr>

                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
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
                    <html:button accesskey="c" onclick="javascript:window.close();" styleClass="baseButton" property="close_action"><bean:message bundle="ApplicationResources" key="jsp.close"/></html:button>
                    <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                    <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                    </td>
                    </tr>
                    </table>

                    </html:form><script type="text/javascript">
                    var focusControl = document.forms[0].elements["cli_cdgo"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>

                  <%
                  {
                    %>

                    <%
                    java.util.Vector res_Jw_lv_clientes = (java.util.Vector)session.getAttribute("res_Jw_lv_clientes");
                    %>

                    <form  name="bl_report_Jw_lv_clientes" id="bl_report_Jw_lv_clientes" class="baseForm" method="post" >
                      <%
                      if (res_Jw_lv_clientes!=null && res_Jw_lv_clientes.size()>0) {
                        %>

                        <table id="TRbl_report_Jw_lv_clientes"  class="reportTable"   style="width:500; "  >
                          <%
                          java.lang.String codigo =  null;
                          java.lang.String cli_rzao =  null;
                          java.lang.String cid_est =  null;
                          java.lang.Integer esc_seqn =  null;
                          java.lang.Integer cli_cdgo =  null;
                          %>

                          <tr class="reportTr">
                            <td class="columnTdHeader" style="text-align:left;" >
                              Código
                            </td>

                            <td class="columnTdHeader" style="text-align:left;" >
                              Razão Social
                            </td>

                            <td class="columnTdHeader" style="text-align:left;" >
                              Cidade - UF
                            </td>

                          </tr>

                          <%
                          int i_bl_report_Jw_lv_clientes = 0;
                          while (i_bl_report_Jw_lv_clientes<res_Jw_lv_clientes.size()) {
                            portalbr.dbobj.view.Jw_lv_clientes t_jw_lv_clientes = (portalbr.dbobj.view.Jw_lv_clientes)res_Jw_lv_clientes.elementAt(i_bl_report_Jw_lv_clientes);
                            codigo = t_jw_lv_clientes.getCodigo()==null?"":t_jw_lv_clientes.getCodigo();
                            cli_rzao = t_jw_lv_clientes.getCli_rzao()==null?"":t_jw_lv_clientes.getCli_rzao();
                            cid_est = t_jw_lv_clientes.getCid_est()==null?"":t_jw_lv_clientes.getCid_est();
                            esc_seqn = t_jw_lv_clientes.getEsc_seqn();
                            cli_cdgo = t_jw_lv_clientes.getCli_cdgo();
                            String style_bl_report_Jw_lv_clientes="";
                            if (!((i_bl_report_Jw_lv_clientes%2)!=0)) {
                              style_bl_report_Jw_lv_clientes="rowColor";
                            } else {
                              style_bl_report_Jw_lv_clientes="rowBlank";
                            }
                            %>

                            <tr class='<%= style_bl_report_Jw_lv_clientes %>' id="TRbl_report_Jw_lv_clientes<%=i_bl_report_Jw_lv_clientes%>" >
                              <td class="reportColumn" style="text-align:left;" >
                                <%= codigo %>
                              </td>

                              <td class="reportColumn" style="text-align:left;" >
                                <a href="javascript:setLov('<%= cli_rzao %>','<%= esc_seqn %>','<%= cli_cdgo %>')" style="cursor:hand">
                                  <%= cli_rzao %>
                                </a>

                              </td>

                              <td class="reportColumn" style="text-align:left;" >
                                <%= cid_est %>
                              </td>

                            </tr>

                            <%
                            i_bl_report_Jw_lv_clientes++;
                            if (i_bl_report_Jw_lv_clientes<res_Jw_lv_clientes.size()) {
                              t_jw_lv_clientes = (portalbr.dbobj.view.Jw_lv_clientes)res_Jw_lv_clientes.elementAt(i_bl_report_Jw_lv_clientes);
                              codigo = t_jw_lv_clientes.getCodigo()==null?"":t_jw_lv_clientes.getCodigo();
                              cli_rzao = t_jw_lv_clientes.getCli_rzao()==null?"":t_jw_lv_clientes.getCli_rzao();
                              cid_est = t_jw_lv_clientes.getCid_est()==null?"":t_jw_lv_clientes.getCid_est();
                              esc_seqn = t_jw_lv_clientes.getEsc_seqn();
                              cli_cdgo = t_jw_lv_clientes.getCli_cdgo();
                            } else {
                            }
                          }
                          %>

                        </table>

                        <%
                      }
                      %>

                      <script type="text/javascript">
                        function setLov(CLI_RZAO,ESC_SEQN,CLI_CDGO) {
                          <% {
                            String returnBlock = "0";
                            String return0 = null;
                            String return1 = null;
                            String return2 = null;
                            if (request.getParameter("returnBlock")!=null) {
                              returnBlock = request.getParameter("returnBlock");
                              session.setAttribute("returnBlock",returnBlock);
                              return0 = ((request.getParameter("return0")!=null)?request.getParameter("return0"):null);
                              session.setAttribute("return0",return0);
                              return1 = ((request.getParameter("return1")!=null)?request.getParameter("return1"):null);
                              session.setAttribute("return1",return1);
                              return2 = ((request.getParameter("return2")!=null)?request.getParameter("return2"):null);
                              session.setAttribute("return2",return2);
                              session.setAttribute("ge_LovPage", "LvClienteSeqLov");
                            } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvClienteSeqLov")) {
                              returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                              return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                              return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                              return2 = ((session.getAttribute("return2")!=null)?(String)session.getAttribute("return2"):null);
                            }
                            %>
                            returnBlock = <%= returnBlock %>;
                            <% if (return0!=null && return0.length()>0) {%>
                            if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CLI_RZAO; };
                            <%}%>
                            <% if (return1!=null && return1.length()>0) {%>
                            if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=ESC_SEQN; };
                            <%}%>
                            <% if (return2!=null && return2.length()>0) {%>
                            if (opener.document.forms[returnBlock].<%= return2%>!=null) { opener.document.forms[returnBlock].<%= return2 %>.value=CLI_CDGO; };
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

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

          <html:form action="lov/LvClienteLov.do" method="POST"  styleClass="baseForm" target="_self">
            <table class="bannerTable" style='width:500;'>
              <tr>
                <td class=tableHeader>
                  <bean:message bundle="LovResources" key="LvCliente.titulo"/>
                </td>
              </tr>
            </table>
            <table class="messageTable" style='width:500;'>
              <tr>
                <td class="messageHeader">
                  <div style=font-size:11px;font-weight:normal;>
                    <div class\='div10l'>
                      Um dos campos com
                      <img src='../img/opcional.gif' border\='0' title\='Opcional' style\='cursor\:pointer'>
                      deve ser preenchido.
                    </div>
                  </div>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Cli"/>
                </td>
              </tr>
            </table>
            <table class="itemTable" style='width:500;'>
              <html:hidden property="cli_cdgo_sessao" />
              <html:hidden property="cli_rzao_sessao" />
              <tr>
                <td class="formLabel">
                  <span class="spamFormLabel" >
                    <bean:message bundle="LovResources" key="LvCliente.cli_cdgo"/>
                  </span>
                  <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                </td>
                <td class="formField">
                  <html:text property="cli_cdgo" styleClass="baseField" size="10" maxlength="22"/>
                </td>
              </tr>
              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              <tr>
                <td class="formLabel">
                  <span class="spamFormLabel" >
                    <bean:message bundle="LovResources" key="LvCliente.cli_rzao"/>
                  </span>
                  <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                </td>
                <td class="formField">
                  <html:text property="cli_rzao" styleClass="baseField" size="35" maxlength="35"/>
                </td>
              </tr>
            </table>
            <table class="buttonTable" style='width:500;'>
              <tr>
                <td class="buttonItem">
                  <%
                  String styleResetfull;
                  String styleResetfullsessao;
                  if(session.getAttribute("lista_de_valores_manter_sessao") != null) {
                    styleResetfullsessao = "baseButton";
                    styleResetfull = "myhidden";
                  } else {
                    styleResetfullsessao = "myhidden";
                    styleResetfull = "baseButton";
                  }
                  %>
                  <html:button accesskey="p" onclick="resetfull1_action.disabled=true;close_action.disabled=true;this.disabled=true;select_action.click();" styleClass="baseButton" property="select1_action">
                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                  </html:button>
                  <html:button accesskey="l" onclick="resetfull_action.click();" styleClass="<%= styleResetfullsessao %>" property="resetfull2_action">
                    <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:button>
                  <html:button onclick="resetfull_sessao_action.click();" styleClass="<%= styleResetfull  %>" property="resetfull1_action">
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
                  <html:submit styleClass="myhidden" property="setar_sessao_action">
                    <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:submit>
                  <html:submit styleClass="myhidden" property="resetfull_sessao_action">
                    <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:submit>
                </td>
              </tr>
            </table>
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
        </html:form>
        <script type="text/javascript" language="JavaScript">
          <!--
          var focusControl = document.forms[0].elements["cli_cdgo"];
          if (focusControl.type != "hidden") {
            focusControl.focus();
          }
        // -->
        </script>

        <%
        {
          %>

          <%
          java.util.Vector res_Cli = (java.util.Vector)session.getAttribute("res_Cli");
          %>

          <form  name="bl_report_Cli" id="bl_report_Cli" class="baseForm" method="post" >
            <%
            if (res_Cli!=null && res_Cli.size()>0) {
              %>

              <table id="TRbl_report_Cli"  class="reportTable"   style="width:500; "  >
                <%
                int cli_cdgo =  0;
                java.lang.String cli_rzao =  null;
                %>

                <tr class="reportTr">
                  <td class="columnTdHeader" style="text-align:right;" >
                    <bean:message bundle="LovResources" key="LvCliente.cli_cdgo"/>
                  </td>

                  <td class="columnTdHeader" style="text-align:left;" >
                    <bean:message bundle="LovResources" key="LvCliente.cli_rzao"/>
                  </td>

                </tr>

                <%
                int i_bl_report_Cli = 0;
                while (i_bl_report_Cli<res_Cli.size()) {
                  portalbr.dbobj.table.Cli t_cli = (portalbr.dbobj.table.Cli)res_Cli.elementAt(i_bl_report_Cli);
                  cli_cdgo = t_cli.getCli_cdgo();
                  cli_rzao = t_cli.getCli_rzao()==null?"":t_cli.getCli_rzao();
                  String style_bl_report_Cli="";
                  if (!((i_bl_report_Cli%2)!=0)) {
                    style_bl_report_Cli="rowColor";
                  } else {
                    style_bl_report_Cli="rowBlank";
                  }
                  %>

                  <tr class='<%= style_bl_report_Cli %>' id="TRbl_report_Cli<%=i_bl_report_Cli%>" >
                    <td class="reportColumn" style="text-align:right;" >
                      <%= cli_cdgo %>
                    </td>

                    <td class="reportColumn" style="text-align:left;" >

                      <%
                      if(session.getAttribute("lista_de_valores_manter_sessao") == null) {
                        %>
                        <a href="javascript:setLov('<%= cli_cdgo %>','<%= cli_rzao %>')" style="cursor:hand">
                          <%= cli_rzao %>
                        </a>

                        <%
                      } else {
                        %>
                        <a href="javascript:setLovSessao('<%= cli_cdgo %>','<%= cli_rzao %>')" style="cursor:hand">
                          <%= cli_rzao %>
                        </a>

                        <%
                      }
                      %>

                    </td>

                  </tr>

                  <%
                  i_bl_report_Cli++;
                  if (i_bl_report_Cli<res_Cli.size()) {
                    t_cli = (portalbr.dbobj.table.Cli)res_Cli.elementAt(i_bl_report_Cli);
                    cli_cdgo = t_cli.getCli_cdgo();
                    cli_rzao = t_cli.getCli_rzao()==null?"":t_cli.getCli_rzao();
                  } else {
                  }
                }
                %>

              </table>

              <%
            }
            %>

            <script type="text/javascript">
              function setLov(CLI_CDGO,CLI_RZAO) {
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
                    session.setAttribute("ge_LovPage", "LvClienteLov");
                  } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvClienteLov")) {
                    returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                    return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                    return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                  }
                  %>
                  returnBlock = <%= returnBlock %>;
                  <% if (return0!=null && return0.length()>0) {%>
                  if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CLI_CDGO; };
                  <%}%>
                  <% if (return1!=null && return1.length()>0) {%>
                  if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=CLI_RZAO; };
                  <%}%>
                  window.close();
                }
                <% } %>
              </script>

              <script type="text/javascript">
                function setLovSessao(CLI_CDGO,CLI_RZAO) {
                  jQuery.post('LvClienteLov.do?setar_sessao_action=&cli_cdgo_sessao='+CLI_CDGO+'&cli_rzao_sessao='+CLI_RZAO);
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
                      session.setAttribute("ge_LovPage", "LvClienteLov");
                    } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvClienteLov")) {
                      returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                      return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                      return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                    }
                    %>
                    returnBlock = <%= returnBlock %>;
                    <% if (return0!=null && return0.length()>0) {%>
                    if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CLI_CDGO; };
                    <%}%>
                    <% if (return1!=null && return1.length()>0) {%>
                    if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=CLI_RZAO; };
                    <%}%>
                    opener.document.forms[0].refresh_action.click();
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

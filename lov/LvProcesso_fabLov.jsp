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
                <bean:message key="page.title"/>
              </td>
            </td>

          </tr>

        </table>

        <html:form action="lov/LvProcesso_fabLov.do" method="post" styleClass="baseForm">
          <table class="bannerTable" style="width:500;">
            <tr class="bannerTr">
              <td class="bannerTd">
                Lista de Valores - Processos
              </td>
            </tr>
          </table>

          <table class="messageTable" style='width:500;'>
            <tr class="messageTr" >
              <td class="messageTd">
                <html:errors property="pro_numero"/>
                <html:errors property="pro_nome"/>
                <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Processo_fab"/>
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
                <html:text property="pro_numero" styleId="pro_numero" styleClass="baseField" size="3" maxlength="3"/>
              </td>
            </tr>

            <tr class="itemTr">
              <td class="formLabel">
                <span class="spamFormLabel">
                  Nome
                </span>
              </td>
              <td class="formField">
                <html:text property="pro_nome" styleId="pro_nome" styleClass="baseField" size="40" maxlength="40"/>
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
          var focusControl = document.forms[0].elements["pro_numero"];
          if (focusControl.type != "hidden"){
            focusControl.focus();
          }
        </script>

        <%
        {
          %>

          <%
          java.util.Vector res_Processo_fab = (java.util.Vector)session.getAttribute("res_Processo_fab");
          %>

          <form  name="bl_report_Processo_fab" id="bl_report_Processo_fab" class="baseForm" method="post" >
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Processos
                </td>
              </tr>
            </table>

            <%
            if (res_Processo_fab!=null && res_Processo_fab.size()>0) {
              %>

              <table id="TRbl_report_Processo_fab"  class="reportTable"   style="width:500; "  >
                <%
                java.lang.Integer pro_numero =  null;
                java.lang.String pro_nome =  null;
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
                int i_bl_report_Processo_fab = 0;
                while (i_bl_report_Processo_fab<res_Processo_fab.size()) {
                  portalbr.dbobj.table.Processo_fab t_processo_fab = (portalbr.dbobj.table.Processo_fab)res_Processo_fab.elementAt(i_bl_report_Processo_fab);
                  pro_numero = t_processo_fab.getPro_numero();
                  pro_nome = t_processo_fab.getPro_nome()==null?"":t_processo_fab.getPro_nome();
                  String style_bl_report_Processo_fab="";
                  if (!((i_bl_report_Processo_fab%2)!=0)) {
                    style_bl_report_Processo_fab="rowColor";
                  } else {
                    style_bl_report_Processo_fab="rowBlank";
                  }
                  %>

                  <tr class='<%= style_bl_report_Processo_fab %>' id="TRbl_report_Processo_fab<%=i_bl_report_Processo_fab%>" >
                    <td class="reportColumn" style="text-align:right;" >
                      <%= ((pro_numero!=null)?pro_numero.toString():"") %>
                    </td>

                    <td class="reportColumn" style="text-align:left;" >
                      <a href="javascript:setLov('<%= pro_numero %>','<%= pro_nome %>')" style="cursor:hand">
                        <%= pro_nome %>
                      </a>

                    </td>

                  </tr>

                  <%
                  i_bl_report_Processo_fab++;
                  if (i_bl_report_Processo_fab<res_Processo_fab.size()) {
                    t_processo_fab = (portalbr.dbobj.table.Processo_fab)res_Processo_fab.elementAt(i_bl_report_Processo_fab);
                    pro_numero = t_processo_fab.getPro_numero();
                    pro_nome = t_processo_fab.getPro_nome()==null?"":t_processo_fab.getPro_nome();
                  } else {
                  }
                }
                %>

              </table>

              <%
            }
            %>

            <script type="text/javascript">
              function setLov(PRO_NUMERO,PRO_NOME) {
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
                    session.setAttribute("ge_LovPage", "LvProcesso_fabLov");
                  } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvProcesso_fabLov")) {
                    returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                    return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                    return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                  }
                  %>
                  returnBlock = <%= returnBlock %>;
                  <% if (return0!=null && return0.length()>0) {%>
                  if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=PRO_NUMERO; };
                  <%}%>
                  <% if (return1!=null && return1.length()>0) {%>
                  if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=PRO_NOME; };
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

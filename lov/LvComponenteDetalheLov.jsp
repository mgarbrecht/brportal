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

          <html:form action="lov/LvComponenteDetalheLov.do" method="post" styleClass="baseForm">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  <b>
                    Lista de Valores - Componentes
                  </b>

                </td>

              </tr>

            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="cmp_cdgo"/>
                  <html:errors property="cmp_desc"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Componente_detalhe"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Componente
                  </span>
                </td>
                <td class="formField">
                  <html:text property="cmp_cdgo" styleId="cmp_cdgo" styleClass="baseField" size="5" maxlength="5"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Descrição
                  </span>
                </td>
                <td class="formField">
                  <html:text property="cmp_desc" styleId="cmp_desc" styleClass="baseField" size="40" maxlength="40"/>
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
                  <html:button accesskey="f" onclick="javascript:window.close();" styleClass="myhidden" property="close_action">
                    <bean:message bundle="ApplicationResources" key="jsp.close"/>
                  </html:button>
                </td>
              </tr>
            </table>

          </html:form>
          <script type="text/javascript">
            var focusControl = document.forms[0].elements["cmp_cdgo"];
            if (focusControl.type != "hidden"){
              focusControl.focus();
            }
          </script>

          <%
          {
            %>

            <%
            java.util.Vector res_Componente_detalhe = (java.util.Vector)session.getAttribute("res_Componente_detalhe");
            %>

            <form  name="bl_report_Componente_detalhe" id="bl_report_Componente_detalhe" class="baseForm" method="post" >
              <table class="bannerTable" style="width:500;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Componente
                  </td>
                </tr>
              </table>

              <%
              if (res_Componente_detalhe!=null && res_Componente_detalhe.size()>0) {
                %>

                <table id="TRbl_report_Componente_detalhe"  class="reportTable"   style="width:500; "  >
                  <%
                  java.lang.Integer cmp_cdgo =  null;
                  java.lang.String cmp_desc =  null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:right;" >
                      Componente
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Descrição
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Componente_detalhe = 0;
                  while (i_bl_report_Componente_detalhe<res_Componente_detalhe.size()) {
                    portalbr.dbobj.table.Componente_detalhe t_componente_detalhe = (portalbr.dbobj.table.Componente_detalhe)res_Componente_detalhe.elementAt(i_bl_report_Componente_detalhe);
                    cmp_cdgo = t_componente_detalhe.getCmp_cdgo();
                    cmp_desc = t_componente_detalhe.getCmp_desc()==null?"":t_componente_detalhe.getCmp_desc();
                    String style_bl_report_Componente_detalhe="";
                    if (!((i_bl_report_Componente_detalhe%2)!=0)) {
                      style_bl_report_Componente_detalhe="rowColor";
                    } else {
                      style_bl_report_Componente_detalhe="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Componente_detalhe %>' id="TRbl_report_Componente_detalhe<%=i_bl_report_Componente_detalhe%>" >
                      <td class="reportColumn" style="text-align:right;" >
                        <%= ((cmp_cdgo!=null)?cmp_cdgo.toString():"") %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <a href="javascript:setLov('<%= cmp_cdgo %>','<%= cmp_desc %>')" style="cursor:hand">
                          <%= cmp_desc %>
                        </a>

                      </td>

                    </tr>

                    <%
                    i_bl_report_Componente_detalhe++;
                    if (i_bl_report_Componente_detalhe<res_Componente_detalhe.size()) {
                      t_componente_detalhe = (portalbr.dbobj.table.Componente_detalhe)res_Componente_detalhe.elementAt(i_bl_report_Componente_detalhe);
                      cmp_cdgo = t_componente_detalhe.getCmp_cdgo();
                      cmp_desc = t_componente_detalhe.getCmp_desc()==null?"":t_componente_detalhe.getCmp_desc();
                    } else {
                    }
                  }
                  %>

                </table>

                <%
              }
              %>

              <script type="text/javascript">
                function setLov(CMP_CDGO,CMP_DESC) {
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
                      session.setAttribute("ge_LovPage", "LvComponenteDetalheLov");
                    } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvComponenteDetalheLov")) {
                      returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                      return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                      return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                    }
                    %>
                    returnBlock = <%= returnBlock %>;
                    <% if (return0!=null && return0.length()>0) {%>
                    if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CMP_CDGO; };
                    <%}%>
                    <% if (return1!=null && return1.length()>0) {%>
                    if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=CMP_DESC; };
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

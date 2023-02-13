<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      TÍTULO
    </title>
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

            <html:form action="lov/LvProjetosLov.do" method="post" styleClass="baseForm">
              <table class="bannerTable" style="width:500;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    <b>
                      Lista de Valores - Projetos
                    </b>

                  </td>

                </tr>

              </table>

              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="projeto_cdgo"/>
                    <html:errors property="projeto_desc"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Projetos"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Projeto
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="projeto_cdgo" styleId="projeto_cdgo" styleClass="baseField" size="15" maxlength="15"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="projeto_desc" styleId="projeto_desc" styleClass="baseField" size="30" maxlength="30"/>
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
              var focusControl = document.forms[0].elements["projeto_cdgo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Projetos = (java.util.Vector)session.getAttribute("res_Projetos");
              %>

              <form  name="bl_report_Projetos" id="bl_report_Projetos" class="baseForm" method="post" >
                <%
                if (res_Projetos!=null && res_Projetos.size()>0) {
                  %>

                  <table id="TRbl_report_Projetos"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.String projeto_cdgo =  null;
                    java.lang.String projeto_desc =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Projeto
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Projetos = 0;
                    while (i_bl_report_Projetos<res_Projetos.size()) {
                      portalbr.dbobj.table.Projetos t_projetos = (portalbr.dbobj.table.Projetos)res_Projetos.elementAt(i_bl_report_Projetos);
                      projeto_cdgo = t_projetos.getProjeto_cdgo()==null?"":t_projetos.getProjeto_cdgo();
                      projeto_desc = t_projetos.getProjeto_desc()==null?"":t_projetos.getProjeto_desc();
                      String style_bl_report_Projetos="";
                      if (!((i_bl_report_Projetos%2)!=0)) {
                        style_bl_report_Projetos="rowColor";
                      } else {
                        style_bl_report_Projetos="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Projetos %>' id="TRbl_report_Projetos<%=i_bl_report_Projetos%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= projeto_cdgo %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= projeto_cdgo %>','<%= projeto_desc %>')" style="cursor:hand">
                            <%= projeto_desc %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Projetos++;
                      if (i_bl_report_Projetos<res_Projetos.size()) {
                        t_projetos = (portalbr.dbobj.table.Projetos)res_Projetos.elementAt(i_bl_report_Projetos);
                        projeto_cdgo = t_projetos.getProjeto_cdgo()==null?"":t_projetos.getProjeto_cdgo();
                        projeto_desc = t_projetos.getProjeto_desc()==null?"":t_projetos.getProjeto_desc();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(PROJETO_CDGO,PROJETO_DESC) {
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
                        session.setAttribute("ge_LovPage", "LvProjetosLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvProjetosLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=PROJETO_CDGO; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=PROJETO_DESC; };
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

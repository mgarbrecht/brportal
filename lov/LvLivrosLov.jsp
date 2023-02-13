<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
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
            <html:form action="lov/LvLivrosLov.do" method="post" styleClass="baseForm">
              <table class="bannerTable" style="width:500;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Lista de Valores - Livros
                  </td>
                </tr>
              </table>

              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="liv_codigo"/>
                    <html:errors property="liv_descri"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_livros"/>
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
                    <html:text property="liv_codigo" styleId="liv_codigo" styleClass="baseField" size="10" maxlength="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="liv_descri" styleId="liv_descri" styleClass="baseField" size="30" maxlength="30"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:500;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="s" styleClass="baseButton" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="r" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:button accesskey="c" onclick="javascript:window.close();" styleClass="myhidden" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["liv_codigo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_livros = (java.util.Vector)session.getAttribute("res_Jw_livros");
              %>

              <form  name="bl_report_Jw_livros" id="bl_report_Jw_livros" class="baseForm" method="post" >
                <table class="bannerTable" style="width:500;">
                  <tr class="bannerTr">
                    <td class="bannerTd">
                      Livros
                    </td>
                  </tr>
                </table>

                <%
                if (res_Jw_livros!=null && res_Jw_livros.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_livros"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.Integer liv_codigo =  null;
                    java.lang.String liv_descri =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Livro
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_livros = 0;
                    while (i_bl_report_Jw_livros<res_Jw_livros.size()) {
                      portalbr.dbobj.view.Jw_livros t_jw_livros = (portalbr.dbobj.view.Jw_livros)res_Jw_livros.elementAt(i_bl_report_Jw_livros);
                      liv_codigo = t_jw_livros.getLiv_codigo();
                      liv_descri = t_jw_livros.getLiv_descri()==null?"":t_jw_livros.getLiv_descri();
                      String style_bl_report_Jw_livros="";
                      if (!((i_bl_report_Jw_livros%2)!=0)) {
                        style_bl_report_Jw_livros="rowColor";
                      } else {
                        style_bl_report_Jw_livros="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_livros %>' id="TRbl_report_Jw_livros<%=i_bl_report_Jw_livros%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((liv_codigo!=null)?liv_codigo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= liv_codigo %>','<%= liv_descri %>')" style="cursor:hand">
                            <%= liv_descri %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_livros++;
                      if (i_bl_report_Jw_livros<res_Jw_livros.size()) {
                        t_jw_livros = (portalbr.dbobj.view.Jw_livros)res_Jw_livros.elementAt(i_bl_report_Jw_livros);
                        liv_codigo = t_jw_livros.getLiv_codigo();
                        liv_descri = t_jw_livros.getLiv_descri()==null?"":t_jw_livros.getLiv_descri();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(LIV_CODIGO,LIV_DESCRI) {
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
                        session.setAttribute("ge_LovPage", "LvLivrosLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvLivrosLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=LIV_CODIGO; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=LIV_DESCRI; };
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

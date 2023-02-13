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
            <html:form action="lov/LvUsuariosLojaLov.do" method="post" styleClass="baseForm">
              <table class="bannerTable" style="width:500;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Lista de Valores - Usuários
                  </td>
                </tr>
              </table>

              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="cracha"/>
                    <html:errors property="nome"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Usuarios_loja_vw"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Crachá
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cracha" styleId="cracha" styleClass="baseField" size="10" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nome
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="nome" styleId="nome" styleClass="baseField" size="60" maxlength="101"/>
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
              var focusControl = document.forms[0].elements["cracha"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Usuarios_loja_vw = (java.util.Vector)session.getAttribute("res_Usuarios_loja_vw");
              %>

              <form  name="bl_report_Usuarios_loja_vw" id="bl_report_Usuarios_loja_vw" class="baseForm" method="post" >
                <%
                if (res_Usuarios_loja_vw!=null && res_Usuarios_loja_vw.size()>0) {
                  %>

                  <table id="TRbl_report_Usuarios_loja_vw"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.String cracha =  null;
                    java.lang.String nome =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Crachá
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Nome
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Usuarios_loja_vw = 0;
                    while (i_bl_report_Usuarios_loja_vw<res_Usuarios_loja_vw.size()) {
                      portalbr.dbobj.table.Usuarios_loja_vw t_usuarios_loja_vw = (portalbr.dbobj.table.Usuarios_loja_vw)res_Usuarios_loja_vw.elementAt(i_bl_report_Usuarios_loja_vw);
                      cracha = t_usuarios_loja_vw.getCracha()==null?"":t_usuarios_loja_vw.getCracha();
                      nome = t_usuarios_loja_vw.getNome()==null?"":t_usuarios_loja_vw.getNome();
                      String style_bl_report_Usuarios_loja_vw="";
                      if (!((i_bl_report_Usuarios_loja_vw%2)!=0)) {
                        style_bl_report_Usuarios_loja_vw="rowColor";
                      } else {
                        style_bl_report_Usuarios_loja_vw="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Usuarios_loja_vw %>' id="TRbl_report_Usuarios_loja_vw<%=i_bl_report_Usuarios_loja_vw%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= cracha %>','<%= nome %>')" style="cursor:hand">
                            <%= cracha %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= nome %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Usuarios_loja_vw++;
                      if (i_bl_report_Usuarios_loja_vw<res_Usuarios_loja_vw.size()) {
                        t_usuarios_loja_vw = (portalbr.dbobj.table.Usuarios_loja_vw)res_Usuarios_loja_vw.elementAt(i_bl_report_Usuarios_loja_vw);
                        cracha = t_usuarios_loja_vw.getCracha()==null?"":t_usuarios_loja_vw.getCracha();
                        nome = t_usuarios_loja_vw.getNome()==null?"":t_usuarios_loja_vw.getNome();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(CRACHA,NOME) {
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
                        session.setAttribute("ge_LovPage", "LvUsuariosLojaLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvUsuariosLojaLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CRACHA; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=NOME; };
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

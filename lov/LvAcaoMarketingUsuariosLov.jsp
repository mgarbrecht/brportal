<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvAcaoMarketingUsuariosLov.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
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
                    <html:text property="cracha" styleId="cracha" styleClass="baseField" size="22" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nome
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="nome" styleId="nome" styleClass="baseField" size="40" maxlength="40"/>
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
                    <html:button accesskey="c" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
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
              java.util.Vector res_Jw_acao_marketing_usuarios = (java.util.Vector)session.getAttribute("res_Jw_acao_marketing_usuarios");
              %>

              <form  name="bl_report_Jw_acao_marketing_usuarios" id="bl_report_Jw_acao_marketing_usuarios" class="baseForm" method="post" >
                <%
                if (res_Jw_acao_marketing_usuarios!=null && res_Jw_acao_marketing_usuarios.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_acao_marketing_usuarios"  class="reportTable"   style="width:500; "  >
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
                    int i_bl_report_Jw_acao_marketing_usuarios = 0;
                    while (i_bl_report_Jw_acao_marketing_usuarios<res_Jw_acao_marketing_usuarios.size()) {
                      portalbr.dbobj.view.Jw_acao_marketing_usuarios t_jw_acao_marketing_usuarios = (portalbr.dbobj.view.Jw_acao_marketing_usuarios)res_Jw_acao_marketing_usuarios.elementAt(i_bl_report_Jw_acao_marketing_usuarios);
                      cracha = t_jw_acao_marketing_usuarios.getCracha()==null?"":t_jw_acao_marketing_usuarios.getCracha();
                      nome = t_jw_acao_marketing_usuarios.getNome()==null?"":t_jw_acao_marketing_usuarios.getNome();
                      String style_bl_report_Jw_acao_marketing_usuarios="";
                      if (!((i_bl_report_Jw_acao_marketing_usuarios%2)!=0)) {
                        style_bl_report_Jw_acao_marketing_usuarios="rowColor";
                      } else {
                        style_bl_report_Jw_acao_marketing_usuarios="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_acao_marketing_usuarios %>' id="TRbl_report_Jw_acao_marketing_usuarios<%=i_bl_report_Jw_acao_marketing_usuarios%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= cracha %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= cracha %>','<%= nome %>')" style="cursor:hand">
                            <%= nome %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_acao_marketing_usuarios++;
                      if (i_bl_report_Jw_acao_marketing_usuarios<res_Jw_acao_marketing_usuarios.size()) {
                        t_jw_acao_marketing_usuarios = (portalbr.dbobj.view.Jw_acao_marketing_usuarios)res_Jw_acao_marketing_usuarios.elementAt(i_bl_report_Jw_acao_marketing_usuarios);
                        cracha = t_jw_acao_marketing_usuarios.getCracha()==null?"":t_jw_acao_marketing_usuarios.getCracha();
                        nome = t_jw_acao_marketing_usuarios.getNome()==null?"":t_jw_acao_marketing_usuarios.getNome();
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
                        session.setAttribute("ge_LovPage", "LvAcaoMarketingUsuariosLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvAcaoMarketingUsuariosLov")) {
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

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
            <html:form action="lov/LvFornecedorAtelierLov.do" method="post" styleClass="baseForm">
              <table class="bannerTable" style="width:500;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Lista de Valores - Fornecedores
                  </td>
                </tr>
              </table>

              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="codigo"/>
                    <html:errors property="fornecedor"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_fornecedores_atelier"/>
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
                    <html:text property="codigo" styleId="codigo" styleClass="baseField" size="30" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Fornecedor
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fornecedor" styleId="fornecedor" styleClass="baseField" size="40" maxlength="40"/>
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
              var focusControl = document.forms[0].elements["codigo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_fornecedores_atelier = (java.util.Vector)session.getAttribute("res_Jw_fornecedores_atelier");
              %>

              <form  name="bl_report_Jw_fornecedores_atelier" id="bl_report_Jw_fornecedores_atelier" class="baseForm" method="post" >
                <table class="bannerTable" style="width:500;">
                  <tr class="bannerTr">
                    <td class="bannerTd">
                      Fornecedores
                    </td>
                  </tr>
                </table>

                <%
                if (res_Jw_fornecedores_atelier!=null && res_Jw_fornecedores_atelier.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_fornecedores_atelier"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.String usua_usuario =  null;
                    java.lang.String usua_nome =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Código
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Fornecedor
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_fornecedores_atelier = 0;
                    while (i_bl_report_Jw_fornecedores_atelier<res_Jw_fornecedores_atelier.size()) {
                      portalbr.dbobj.view.Jw_fornecedores_atelier t_jw_fornecedores_atelier = (portalbr.dbobj.view.Jw_fornecedores_atelier)res_Jw_fornecedores_atelier.elementAt(i_bl_report_Jw_fornecedores_atelier);
                      usua_usuario = t_jw_fornecedores_atelier.getUsua_usuario()==null?"":t_jw_fornecedores_atelier.getUsua_usuario();
                      usua_nome = t_jw_fornecedores_atelier.getUsua_nome()==null?"":t_jw_fornecedores_atelier.getUsua_nome();
                      String style_bl_report_Jw_fornecedores_atelier="";
                      if (!((i_bl_report_Jw_fornecedores_atelier%2)!=0)) {
                        style_bl_report_Jw_fornecedores_atelier="rowColor";
                      } else {
                        style_bl_report_Jw_fornecedores_atelier="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_fornecedores_atelier %>' id="TRbl_report_Jw_fornecedores_atelier<%=i_bl_report_Jw_fornecedores_atelier%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= usua_usuario %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= usua_usuario %>','<%= usua_nome %>')" style="cursor:hand">
                            <%= usua_nome %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_fornecedores_atelier++;
                      if (i_bl_report_Jw_fornecedores_atelier<res_Jw_fornecedores_atelier.size()) {
                        t_jw_fornecedores_atelier = (portalbr.dbobj.view.Jw_fornecedores_atelier)res_Jw_fornecedores_atelier.elementAt(i_bl_report_Jw_fornecedores_atelier);
                        usua_usuario = t_jw_fornecedores_atelier.getUsua_usuario()==null?"":t_jw_fornecedores_atelier.getUsua_usuario();
                        usua_nome = t_jw_fornecedores_atelier.getUsua_nome()==null?"":t_jw_fornecedores_atelier.getUsua_nome();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(USUA_USUARIO,USUA_NOME) {
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
                        session.setAttribute("ge_LovPage", "LvFornecedorAtelierLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvFornecedorAtelierLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=USUA_USUARIO; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=USUA_NOME; };
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

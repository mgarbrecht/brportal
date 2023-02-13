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
            <html:form action="lov/LvTabelaPrecoMercadoExternoLov.do" method="post" styleClass="baseForm">
              <table class="bannerTable" style="width:500;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Lista de Valores - Versões
                  </td>
                </tr>
              </table>

              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="codigo_livro"/>
                    <html:errors property="versao_tabela"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_tabela_preco_mercado_externo"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Livro
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_livro" styleId="codigo_livro" styleClass="baseField" size="4" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Versão
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="versao_tabela" styleId="versao_tabela" styleClass="baseField" size="19" maxlength="19"/>
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
              var focusControl = document.forms[0].elements["codigo_livro"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_tabela_preco_mercado_externo = (java.util.Vector)session.getAttribute("res_Jw_tabela_preco_mercado_externo");
              %>

              <form  name="bl_report_Jw_tabela_preco_mercado_externo" id="bl_report_Jw_tabela_preco_mercado_externo" class="baseForm" method="post" >
                <%
                if (res_Jw_tabela_preco_mercado_externo!=null && res_Jw_tabela_preco_mercado_externo.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_tabela_preco_mercado_externo"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.Integer codigo_livro =  null;
                    java.sql.Timestamp versao_tabela =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Livro
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Versão Tabela
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_tabela_preco_mercado_externo = 0;
                    while (i_bl_report_Jw_tabela_preco_mercado_externo<res_Jw_tabela_preco_mercado_externo.size()) {
                      portalbr.dbobj.view.Jw_tabela_preco_mercado_externo t_jw_tabela_preco_mercado_externo = (portalbr.dbobj.view.Jw_tabela_preco_mercado_externo)res_Jw_tabela_preco_mercado_externo.elementAt(i_bl_report_Jw_tabela_preco_mercado_externo);
                      codigo_livro = t_jw_tabela_preco_mercado_externo.getCodigo_livro();
                      versao_tabela = (java.sql.Timestamp)t_jw_tabela_preco_mercado_externo.getVersao_tabela();
                      String style_bl_report_Jw_tabela_preco_mercado_externo="";
                      if (!((i_bl_report_Jw_tabela_preco_mercado_externo%2)!=0)) {
                        style_bl_report_Jw_tabela_preco_mercado_externo="rowColor";
                      } else {
                        style_bl_report_Jw_tabela_preco_mercado_externo="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_tabela_preco_mercado_externo %>' id="TRbl_report_Jw_tabela_preco_mercado_externo<%=i_bl_report_Jw_tabela_preco_mercado_externo%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <a href="javascript:setLov('<%= codigo_livro %>','<%= com.egen.util.text.FormatDate.format(versao_tabela, "dd/MM/yyyy HH:mm:ss") %>')" style="cursor:hand">
                            <%= ((codigo_livro!=null)?codigo_livro.toString():"") %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <a href="javascript:setLov('<%= codigo_livro %>','<%= com.egen.util.text.FormatDate.format(versao_tabela, "dd/MM/yyyy HH:mm:ss") %>')" style="cursor:hand">
                            <%= com.egen.util.text.FormatDate.format(versao_tabela, "dd/MM/yyyy HH:mm:ss") %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_tabela_preco_mercado_externo++;
                      if (i_bl_report_Jw_tabela_preco_mercado_externo<res_Jw_tabela_preco_mercado_externo.size()) {
                        t_jw_tabela_preco_mercado_externo = (portalbr.dbobj.view.Jw_tabela_preco_mercado_externo)res_Jw_tabela_preco_mercado_externo.elementAt(i_bl_report_Jw_tabela_preco_mercado_externo);
                        codigo_livro = t_jw_tabela_preco_mercado_externo.getCodigo_livro();
                        versao_tabela = (java.sql.Timestamp)t_jw_tabela_preco_mercado_externo.getVersao_tabela();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(CODIGO_LIVRO,VERSAO_TABELA) {
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
                        session.setAttribute("ge_LovPage", "LvTabelaPrecoMercadoExternoLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvTabelaPrecoMercadoExternoLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CODIGO_LIVRO; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=VERSAO_TABELA; };
                      <%}%>
                      window.close();
                    }
                    <% } %>

                    function setLov(CODIGO_LIVRO,VERSAO_TABELA) {
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
                          session.setAttribute("ge_LovPage", "LvTabelaPrecoMercadoExternoLov");
                        } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvTabelaPrecoMercadoExternoLov")) {
                          returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                          return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                          return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                        }
                        %>
                        returnBlock = <%= returnBlock %>;
                        <% if (return0!=null && return0.length()>0) {%>
                        if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CODIGO_LIVRO; };
                        <%}%>
                        <% if (return1!=null && return1.length()>0) {%>
                        if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=VERSAO_TABELA; };
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

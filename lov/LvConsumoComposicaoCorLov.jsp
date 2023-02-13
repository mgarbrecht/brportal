<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body onload="document.forms[0].ies_codigo.value=opener.document.forms[0].codigo.value;">
      <table class="mainTable" style='width:600;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvConsumoComposicaoCorLov.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:600;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      Lista de Valores - Cores
                    </div>
                    <html:errors property="cor_cdgo"/>
                    <html:errors property="cor_desc"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_consumo_composicao_cor"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:600;">
                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cor
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cor_cdgo" styleId="cor_cdgo" styleClass="baseField" size="10" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cor_desc" styleId="cor_desc" styleClass="baseField" size="60" maxlength="400"/>
                  </td>
                </tr>

                <html:hidden property="ies_codigo"/>
              </table>

              <table class="buttonTable" style='width:600;'>
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
              var focusControl = document.forms[0].elements["cor_cdgo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_consumo_composicao_cor = (java.util.Vector)session.getAttribute("res_Jw_consumo_composicao_cor");
              %>

              <form  name="bl_report_Jw_consumo_composicao_cor" id="bl_report_Jw_consumo_composicao_cor" class="baseForm" method="post" >
                <%
                if (res_Jw_consumo_composicao_cor!=null && res_Jw_consumo_composicao_cor.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_consumo_composicao_cor"  class="reportTable"   style="width:600; "  >
                    <%
                    java.lang.Integer cor_cdgo =  null;
                    java.lang.String cor_desc =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Cor
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_consumo_composicao_cor = 0;
                    while (i_bl_report_Jw_consumo_composicao_cor<res_Jw_consumo_composicao_cor.size()) {
                      portalbr.dbobj.view.Jw_consumo_composicao_cor t_jw_consumo_composicao_cor = (portalbr.dbobj.view.Jw_consumo_composicao_cor)res_Jw_consumo_composicao_cor.elementAt(i_bl_report_Jw_consumo_composicao_cor);
                      cor_cdgo = t_jw_consumo_composicao_cor.getCor_cdgo();
                      cor_desc = t_jw_consumo_composicao_cor.getCor_desc()==null?"":t_jw_consumo_composicao_cor.getCor_desc();
                      String style_bl_report_Jw_consumo_composicao_cor="";
                      if (!((i_bl_report_Jw_consumo_composicao_cor%2)!=0)) {
                        style_bl_report_Jw_consumo_composicao_cor="rowColor";
                      } else {
                        style_bl_report_Jw_consumo_composicao_cor="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_consumo_composicao_cor %>' id="TRbl_report_Jw_consumo_composicao_cor<%=i_bl_report_Jw_consumo_composicao_cor%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((cor_cdgo!=null)?cor_cdgo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= cor_cdgo %>','<%= cor_desc %>')" style="cursor:hand">
                            <%= cor_desc %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_consumo_composicao_cor++;
                      if (i_bl_report_Jw_consumo_composicao_cor<res_Jw_consumo_composicao_cor.size()) {
                        t_jw_consumo_composicao_cor = (portalbr.dbobj.view.Jw_consumo_composicao_cor)res_Jw_consumo_composicao_cor.elementAt(i_bl_report_Jw_consumo_composicao_cor);
                        cor_cdgo = t_jw_consumo_composicao_cor.getCor_cdgo();
                        cor_desc = t_jw_consumo_composicao_cor.getCor_desc()==null?"":t_jw_consumo_composicao_cor.getCor_desc();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(COR_CDGO,COR_DESC) {
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
                        session.setAttribute("ge_LovPage", "LvConsumoComposicaoCorLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvConsumoComposicaoCorLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=COR_CDGO; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=COR_DESC; };
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

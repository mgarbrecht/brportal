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
            <html:form action="lov/LvDespachanteLov.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      Lista de Valores - Despachantes
                    </div>
                    <html:errors property="codigo_pessoa"/>
                    <html:errors property="nome_pessoa"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_despachante"/>
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
                    <html:text property="codigo_pessoa" styleId="codigo_pessoa" styleClass="baseField" size="10" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nome
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="nome_pessoa" styleId="nome_pessoa" styleClass="baseField" size="60" maxlength="400"/>
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
              var focusControl = document.forms[0].elements["codigo_pessoa"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_despachante = (java.util.Vector)session.getAttribute("res_Jw_despachante");
              %>

              <form  name="bl_report_Jw_despachante" id="bl_report_Jw_despachante" class="baseForm" method="post" >
                <%
                if (res_Jw_despachante!=null && res_Jw_despachante.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_despachante"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.Integer codigo_pessoa =  null;
                    java.lang.String nome_pessoa =  null;
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
                    int i_bl_report_Jw_despachante = 0;
                    while (i_bl_report_Jw_despachante<res_Jw_despachante.size()) {
                      portalbr.dbobj.view.Jw_despachante t_jw_despachante = (portalbr.dbobj.view.Jw_despachante)res_Jw_despachante.elementAt(i_bl_report_Jw_despachante);
                      codigo_pessoa = t_jw_despachante.getCodigo_pessoa();
                      nome_pessoa = t_jw_despachante.getNome_pessoa()==null?"":t_jw_despachante.getNome_pessoa();
                      String style_bl_report_Jw_despachante="";
                      if (!((i_bl_report_Jw_despachante%2)!=0)) {
                        style_bl_report_Jw_despachante="rowColor";
                      } else {
                        style_bl_report_Jw_despachante="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_despachante %>' id="TRbl_report_Jw_despachante<%=i_bl_report_Jw_despachante%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((codigo_pessoa!=null)?codigo_pessoa.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= codigo_pessoa %>','<%= nome_pessoa %>')" style="cursor:hand">
                            <%= nome_pessoa %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_despachante++;
                      if (i_bl_report_Jw_despachante<res_Jw_despachante.size()) {
                        t_jw_despachante = (portalbr.dbobj.view.Jw_despachante)res_Jw_despachante.elementAt(i_bl_report_Jw_despachante);
                        codigo_pessoa = t_jw_despachante.getCodigo_pessoa();
                        nome_pessoa = t_jw_despachante.getNome_pessoa()==null?"":t_jw_despachante.getNome_pessoa();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(CODIGO_PESSOA,NOME_PESSOA) {
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
                        session.setAttribute("ge_LovPage", "LvDespachanteLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvDespachanteLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CODIGO_PESSOA; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=NOME_PESSOA; };
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

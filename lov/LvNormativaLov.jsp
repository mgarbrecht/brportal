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
            <html:form action="lov/LvNormativaLov.do" method="post" styleClass="baseForm">
              <table class="bannerTable" style="width:500;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Lista de valores - Normativas
                  </td>
                </tr>
              </table>

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
                      Normativa
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="nro_normativa" styleId="nro_normativa" styleClass="baseField" size="10" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="descricao" styleId="descricao" styleClass="baseField" size="80" maxlength="100"/>
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
              var focusControl = document.forms[0].elements["nro_normativa"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Normativa = (java.util.Vector)session.getAttribute("res_Normativa");
              %>

              <form  name="bl_report_Normativa" id="bl_report_Normativa" class="baseForm" method="post" >
                <table class="bannerTable" style="width:500;">
                  <tr class="bannerTr">
                    <td class="bannerTd">
                      Normativas
                    </td>
                  </tr>
                </table>

                <%
                if (res_Normativa!=null && res_Normativa.size()>0) {
                  %>

                  <table id="TRbl_report_Normativa"  class="reportTable"   style="width:500; "  >
                    <%
                    int nro_normativa =  0;
                    java.lang.String descricao =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Normativa
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Normativa = 0;
                    while (i_bl_report_Normativa<res_Normativa.size()) {
                      portalbr.dbobj.table.Normativa t_normativa = (portalbr.dbobj.table.Normativa)res_Normativa.elementAt(i_bl_report_Normativa);
                      nro_normativa = t_normativa.getNro_normativa();
                      descricao = t_normativa.getDescricao()==null?"":t_normativa.getDescricao();
                      String style_bl_report_Normativa="";
                      if (!((i_bl_report_Normativa%2)!=0)) {
                        style_bl_report_Normativa="rowColor";
                      } else {
                        style_bl_report_Normativa="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Normativa %>' id="TRbl_report_Normativa<%=i_bl_report_Normativa%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= nro_normativa %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= nro_normativa %>','<%= descricao %>')" style="cursor:hand">
                            <%= descricao %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Normativa++;
                      if (i_bl_report_Normativa<res_Normativa.size()) {
                        t_normativa = (portalbr.dbobj.table.Normativa)res_Normativa.elementAt(i_bl_report_Normativa);
                        nro_normativa = t_normativa.getNro_normativa();
                        descricao = t_normativa.getDescricao()==null?"":t_normativa.getDescricao();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(NRO_NORMATIVA,DESCRICAO) {
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
                        session.setAttribute("ge_LovPage", "LvNormativaLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvNormativaLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=NRO_NORMATIVA; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=DESCRICAO; };
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

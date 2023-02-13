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
            <html:form action="lov/LvItemEstoqueLov.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <div class\='div10l'>
                        Um dos campos com
                        <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        deve ser preenchido.
                      </div>
                    </div>
                    <html:errors property="codigo"/>
                    <html:errors property="descricao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Dom_item_estoque"/>
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
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="codigo" styleId="codigo" styleClass="baseField" size="22" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="descricao" styleId="descricao" styleClass="baseField" size="50" maxlength="100"/>
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
              var focusControl = document.forms[0].elements["codigo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Dom_item_estoque = (java.util.Vector)session.getAttribute("res_Dom_item_estoque");
              %>

              <form  name="bl_report_Dom_item_estoque" id="bl_report_Dom_item_estoque" class="baseForm" method="post" >
                <%
                if (res_Dom_item_estoque!=null && res_Dom_item_estoque.size()>0) {
                  %>

                  <table id="TRbl_report_Dom_item_estoque"  class="reportTable"   style="width:500; "  >
                    <%
                    int codigo =  0;
                    java.lang.String descricao =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Código
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Dom_item_estoque = 0;
                    while (i_bl_report_Dom_item_estoque<res_Dom_item_estoque.size()) {
                      portalbr.dbobj.table.Dom_item_estoque t_dom_item_estoque = (portalbr.dbobj.table.Dom_item_estoque)res_Dom_item_estoque.elementAt(i_bl_report_Dom_item_estoque);
                      codigo = t_dom_item_estoque.getCodigo();
                      descricao = t_dom_item_estoque.getDescricao()==null?"":t_dom_item_estoque.getDescricao();
                      String style_bl_report_Dom_item_estoque="";
                      if (!((i_bl_report_Dom_item_estoque%2)!=0)) {
                        style_bl_report_Dom_item_estoque="rowColor";
                      } else {
                        style_bl_report_Dom_item_estoque="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Dom_item_estoque %>' id="TRbl_report_Dom_item_estoque<%=i_bl_report_Dom_item_estoque%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= codigo %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= codigo %>','<%= descricao %>')" style="cursor:hand">
                            <%= descricao %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Dom_item_estoque++;
                      if (i_bl_report_Dom_item_estoque<res_Dom_item_estoque.size()) {
                        t_dom_item_estoque = (portalbr.dbobj.table.Dom_item_estoque)res_Dom_item_estoque.elementAt(i_bl_report_Dom_item_estoque);
                        codigo = t_dom_item_estoque.getCodigo();
                        descricao = t_dom_item_estoque.getDescricao()==null?"":t_dom_item_estoque.getDescricao();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(CODIGO,DESCRICAO) {
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
                        session.setAttribute("ge_LovPage", "LvItemEstoqueLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvItemEstoqueLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CODIGO; };
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

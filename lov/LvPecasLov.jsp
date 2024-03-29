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
            <html:form action="lov/LvPecasLov.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="codigo"/>
                    <html:errors property="descricao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Pecas"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      C�digo
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo" styleId="codigo" styleClass="baseField" size="22" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descri��o
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="descricao" styleId="descricao" styleClass="baseField" size="25" maxlength="25"/>
                  </td>
                </tr>

                <html:hidden property="cmp_cdgo" value="<%= request.getParameter("cmp_cdgo") %>"/>
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
              java.util.Vector res_Pecas = (java.util.Vector)session.getAttribute("res_Pecas");
              %>

              <form  name="bl_report_Pecas" id="bl_report_Pecas" class="baseForm" method="post" >
                <%
                if (res_Pecas!=null && res_Pecas.size()>0) {
                  %>

                  <table id="TRbl_report_Pecas"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.Integer codigo =  null;
                    java.lang.String descricao =  null;
                    java.lang.Double conver =  null;
                    java.lang.Integer cmp_cdgo =  null;
                    java.lang.String grupo_sola =  null;
                    java.lang.String set_cdgo =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        C�digo
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descri��o
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Pecas = 0;
                    while (i_bl_report_Pecas<res_Pecas.size()) {
                      portalbr.dbobj.table.Pecas t_pecas = (portalbr.dbobj.table.Pecas)res_Pecas.elementAt(i_bl_report_Pecas);
                      codigo = t_pecas.getCodigo();
                      descricao = t_pecas.getDescricao()==null?"":t_pecas.getDescricao();
                      conver = t_pecas.getConver();
                      cmp_cdgo = t_pecas.getCmp_cdgo();
                      grupo_sola = t_pecas.getGrupo_sola()==null?"":t_pecas.getGrupo_sola();
                      set_cdgo = t_pecas.getSet_cdgo()==null?"":t_pecas.getSet_cdgo();
                      String style_bl_report_Pecas="";
                      if (!((i_bl_report_Pecas%2)!=0)) {
                        style_bl_report_Pecas="rowColor";
                      } else {
                        style_bl_report_Pecas="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Pecas %>' id="TRbl_report_Pecas<%=i_bl_report_Pecas%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((codigo!=null)?codigo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= codigo %>','<%= descricao %>')" style="cursor:hand">
                            <%= descricao %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Pecas++;
                      if (i_bl_report_Pecas<res_Pecas.size()) {
                        t_pecas = (portalbr.dbobj.table.Pecas)res_Pecas.elementAt(i_bl_report_Pecas);
                        codigo = t_pecas.getCodigo();
                        descricao = t_pecas.getDescricao()==null?"":t_pecas.getDescricao();
                        conver = t_pecas.getConver();
                        cmp_cdgo = t_pecas.getCmp_cdgo();
                        grupo_sola = t_pecas.getGrupo_sola()==null?"":t_pecas.getGrupo_sola();
                        set_cdgo = t_pecas.getSet_cdgo()==null?"":t_pecas.getSet_cdgo();
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
                        session.setAttribute("ge_LovPage", "LvPecasLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvPecasLov")) {
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
  <bean:message key="page.script"/>
</head>
<center>
  <body>
    <table class="mainTable" style='width:500;'>
      <tr class="mainTr">
        <td class="mainTd">
          <table class="headerTable" style="width:500" >
            <tr>

              <td class="td10">
              </td>

            </tr>

          </table>

          <html:form action="lov/LvTipoEstoqueLov.do" method="post" styleClass="baseForm">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  <b>
                    Tipo Estoque
                  </b>

                </td>

              </tr>

            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <div style=font-size:11px;font-weight:normal;>

                  </div>
                  <html:errors property="codigo"/>
                  <html:errors property="descricao"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_tipo_estoque"/>
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
                  <html:text property="codigo" styleId="codigo" styleClass="baseField" size="22" maxlength="22"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Descrição
                  </span>
                </td>
                <td class="formField">
                  <html:text property="descricao" styleId="descricao" styleClass="baseField" size="40" maxlength="40"/>
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
            var focusControl = document.forms[0].elements["codigo"];
            if (focusControl.type != "hidden"){
              focusControl.focus();
            }
          </script>

          <%
          {
            %>

            <%
            java.util.Vector res_Jw_tipo_estoque = (java.util.Vector)session.getAttribute("res_Jw_tipo_estoque");
            %>

            <form  name="bl_report_Jw_tipo_estoque" id="bl_report_Jw_tipo_estoque" class="baseForm" method="post" >
              <table class="bannerTable" style="width:500;">
                <tr class="bannerTr">
                  <td class="bannerTd">

                  </td>
                </tr>
              </table>

              <%
              if (res_Jw_tipo_estoque!=null && res_Jw_tipo_estoque.size()>0) {
                %>

                <table id="TRbl_report_Jw_tipo_estoque"  class="reportTable"   style="width:500; "  >
                  <%
                  int cODIGO =  0;
                  java.lang.String dESCRICAO =  null;
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
                  int i_bl_report_Jw_tipo_estoque = 0;
                  while (i_bl_report_Jw_tipo_estoque<res_Jw_tipo_estoque.size()) {
                    portalbr.dbobj.view.Jw_tipo_estoque t_jw_tipo_estoque = (portalbr.dbobj.view.Jw_tipo_estoque)res_Jw_tipo_estoque.elementAt(i_bl_report_Jw_tipo_estoque);
                    cODIGO = t_jw_tipo_estoque.getCodigo();
                    dESCRICAO = t_jw_tipo_estoque.getDescricao()==null?"":t_jw_tipo_estoque.getDescricao();
                    String style_bl_report_Jw_tipo_estoque="";
                    if (!((i_bl_report_Jw_tipo_estoque%2)!=0)) {
                      style_bl_report_Jw_tipo_estoque="rowColor";
                    } else {
                      style_bl_report_Jw_tipo_estoque="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Jw_tipo_estoque %>' id="TRbl_report_Jw_tipo_estoque<%=i_bl_report_Jw_tipo_estoque%>" >
                      <td class="reportColumn" style="text-align:right;" >
                        <%= com.egen.util.text.FormatNumber.format(cODIGO, "0") %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <a href="javascript:setLov('<%= cODIGO %>','<%= dESCRICAO %>')" style="cursor:hand">
                          <%= dESCRICAO %>
                        </a>

                      </td>

                    </tr>

                    <%
                    i_bl_report_Jw_tipo_estoque++;
                    if (i_bl_report_Jw_tipo_estoque<res_Jw_tipo_estoque.size()) {
                      t_jw_tipo_estoque = (portalbr.dbobj.view.Jw_tipo_estoque)res_Jw_tipo_estoque.elementAt(i_bl_report_Jw_tipo_estoque);
                      cODIGO = t_jw_tipo_estoque.getCodigo();
                      dESCRICAO = t_jw_tipo_estoque.getDescricao()==null?"":t_jw_tipo_estoque.getDescricao();
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
                      session.setAttribute("ge_LovPage", "LvTipoEstoqueLov");
                    } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvTipoEstoqueLov")) {
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

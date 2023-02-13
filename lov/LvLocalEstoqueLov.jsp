<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
  <bean:message key="page.script"/>
</head>
<center>
  <body onload="document.forms[0].fil_filial.value=opener.document.forms[0].fil_filial.value">
    <table class="mainTable" style='width:500;'>
      <tr class="mainTr">
        <td class="mainTd">
          <table class="headerTable" style="width:500" >
            <tr>

              <td class="td10">
              </td>

            </tr>

          </table>

          <html:form action="lov/LvLocalEstoqueLov.do" method="post" styleClass="baseForm">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  <b>
                    <bean:message bundle="LovResources" key="LvLocalEstoque.titulo"/>
                  </b>

                </td>

              </tr>

            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="fil_filial"/>
                  <html:errors property="codigo"/>
                  <html:errors property="descricao"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_localestoque"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                  </span>
                </td>
                <td class="formField">
                  <html:text property="fil_filial" styleId="fil_filial" styleClass="myhidden" size="4" maxlength="4"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    <bean:message bundle="LovResources" key="LvLocalEstoque.codigo"/>
                  </span>
                </td>
                <td class="formField">
                  <html:text property="codigo" styleId="codigo" styleClass="baseField" size="5" maxlength="22"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    <bean:message bundle="LovResources" key="LvLocalEstoque.descricao"/>
                  </span>
                </td>
                <td class="formField">
                  <html:text property="descricao" styleId="descricao" styleClass="baseField" size="20" maxlength="40"/>
                </td>
              </tr>

            </table>

            <table class="buttonTable" style='width:500;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:button accesskey="p" onclick="this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                  </html:button>
                  <script>
                    function getKeySite(keyStroke) {
                      isNetscape=(document.layers);
                      eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                      which = String.fromCharCode(eventChooser).toLowerCase();
                      keyBuffer = which;
                      if(eventChooser == 13){
                      if(document.forms[0].select1_action.disabled==true){return false;}
                      document.forms[0].select1_action.disabled=true;
                      document.forms[0].resetfull1_action.disabled=true;
                      document.forms[0].close_action.disabled=true;
                      document.forms[0].select_action.click();
                    }
                  }
                </script>
                <SCRIPT>
                  document.onkeypress = getKeySite;
                  </SCRIPT><html:button accesskey="l" onclick="document.forms[0].resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                  <html:button accesskey="c" onclick="javascript:window.close();" styleClass="baseButton" property="close_action"><bean:message bundle="ApplicationResources" key="jsp.close"/></html:button>
                  <html:submit accesskey="p" styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                  <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form>
                  <%
                  {
                    %>

                    <%
                    java.util.Vector res_Jw_localestoque = (java.util.Vector)session.getAttribute("res_Jw_localestoque");
                    %>

                    <form  name="bl_report_Jw_localestoque" id="bl_report_Jw_localestoque" class="baseForm" method="post" >
                    <%
                    if (res_Jw_localestoque!=null && res_Jw_localestoque.size()>0) {
                      %>

                      <table id="TRbl_report_Jw_localestoque"  class="reportTable"   style="width:500; "  >
                      <%
                      java.lang.String fIL_FILIAL =  null;
                      int cODIGO =  0;
                      java.lang.String dESCRICAO =  null;
                      %>

                      <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                      </td>

                      </tr>

                      <%
                      int i_bl_report_Jw_localestoque = 0;
                      while (i_bl_report_Jw_localestoque<res_Jw_localestoque.size()) {
                        portalbr.dbobj.view.Jw_localestoque t_jw_localestoque = (portalbr.dbobj.view.Jw_localestoque)res_Jw_localestoque.elementAt(i_bl_report_Jw_localestoque);
                        fIL_FILIAL = t_jw_localestoque.getFil_filial()==null?"":t_jw_localestoque.getFil_filial();
                        cODIGO = t_jw_localestoque.getCodigo();
                        dESCRICAO = t_jw_localestoque.getDescricao()==null?"":t_jw_localestoque.getDescricao();
                        String style_bl_report_Jw_localestoque="";
                        if (!((i_bl_report_Jw_localestoque%2)!=0)) {
                          style_bl_report_Jw_localestoque="rowColor";
                        } else {
                          style_bl_report_Jw_localestoque="rowBlank";
                        }
                        %>

                        <tr class='<%= style_bl_report_Jw_localestoque %>' id="TRbl_report_Jw_localestoque<%=i_bl_report_Jw_localestoque%>" >
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
                        i_bl_report_Jw_localestoque++;
                        if (i_bl_report_Jw_localestoque<res_Jw_localestoque.size()) {
                          t_jw_localestoque = (portalbr.dbobj.view.Jw_localestoque)res_Jw_localestoque.elementAt(i_bl_report_Jw_localestoque);
                          fIL_FILIAL = t_jw_localestoque.getFil_filial()==null?"":t_jw_localestoque.getFil_filial();
                          cODIGO = t_jw_localestoque.getCodigo();
                          dESCRICAO = t_jw_localestoque.getDescricao()==null?"":t_jw_localestoque.getDescricao();
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
                          session.setAttribute("ge_LovPage", "LvLocalEstoqueLov");
                        } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvLocalEstoqueLov")) {
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

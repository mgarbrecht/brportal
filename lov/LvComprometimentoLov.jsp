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

          <html:form action="lov/LvComprometimentoLov.do" method="post" styleClass="baseForm">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  <b>
                    <bean:message bundle="LovResources" key="LvComprometimento.titulo"/>
                  </b>

                </td>

              </tr>

            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="codigo"/>
                  <html:errors property="descricao"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_comprometimentos"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    <bean:message bundle="LovResources" key="LvComprometimento.codigo"/>
                  </span>
                </td>
                <td class="formField">
                  <html:text property="codigo" styleId="codigo" styleClass="baseField" size="22" maxlength="22"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    <bean:message bundle="LovResources" key="LvComprometimento.descricao"/>
                  </span>
                </td>
                <td class="formField">
                  <html:text property="descricao" styleId="descricao" styleClass="baseField" size="41" maxlength="41"/>
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
                  </SCRIPT>
                  <html:button accesskey="l" onclick="this.disabled=true;document.forms[0].resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                  <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:button>
                  <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                  <bean:message bundle="ApplicationResources" key="jsp.close"/>
                  </html:button>
                  <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                  <bean:message bundle="ApplicationResources" key="jsp.select"/>
                  </html:submit>
                  <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                  <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form>
                  <%
                  {
                    %>

                    <%
                    java.util.Vector res_Jw_comprometimentos = (java.util.Vector)session.getAttribute("res_Jw_comprometimentos");
                    %>

                    <form  name="bl_report_Jw_comprometimentos" id="bl_report_Jw_comprometimentos" class="baseForm" method="post" >
                    <%
                    if (res_Jw_comprometimentos!=null && res_Jw_comprometimentos.size()>0) {
                      %>

                      <table id="TRbl_report_Jw_comprometimentos"  class="reportTable"   style="width:500; "  >
                      <%
                      int cODIGO =  0;
                      java.lang.String dESCRICAO =  null;
                      %>

                      <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                      <bean:message bundle="LovResources" key="LvComprometimento.codigo"/>
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                      <bean:message bundle="LovResources" key="LvComprometimento.descricao"/>
                      </td>

                      </tr>

                      <%
                      int i_bl_report_Jw_comprometimentos = 0;
                      while (i_bl_report_Jw_comprometimentos<res_Jw_comprometimentos.size()) {
                        portalbr.dbobj.view.Jw_comprometimentos t_jw_comprometimentos = (portalbr.dbobj.view.Jw_comprometimentos)res_Jw_comprometimentos.elementAt(i_bl_report_Jw_comprometimentos);
                        cODIGO = t_jw_comprometimentos.getCodigo();
                        dESCRICAO = t_jw_comprometimentos.getDescricao()==null?"":t_jw_comprometimentos.getDescricao();
                        String style_bl_report_Jw_comprometimentos="";
                        if (!((i_bl_report_Jw_comprometimentos%2)!=0)) {
                          style_bl_report_Jw_comprometimentos="rowColor";
                        } else {
                          style_bl_report_Jw_comprometimentos="rowBlank";
                        }
                        %>

                        <tr class='<%= style_bl_report_Jw_comprometimentos %>' id="TRbl_report_Jw_comprometimentos<%=i_bl_report_Jw_comprometimentos%>" >
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
                        i_bl_report_Jw_comprometimentos++;
                        if (i_bl_report_Jw_comprometimentos<res_Jw_comprometimentos.size()) {
                          t_jw_comprometimentos = (portalbr.dbobj.view.Jw_comprometimentos)res_Jw_comprometimentos.elementAt(i_bl_report_Jw_comprometimentos);
                          cODIGO = t_jw_comprometimentos.getCodigo();
                          dESCRICAO = t_jw_comprometimentos.getDescricao()==null?"":t_jw_comprometimentos.getDescricao();
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
                          session.setAttribute("ge_LovPage", "LvComprometimentoLov");
                        } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvComprometimentoLov")) {
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

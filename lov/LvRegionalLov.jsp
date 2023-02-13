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

          <html:form action="lov/LvRegionalLov.do" method="post" styleClass="baseForm" target="_self">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Lista de Valores - Regionais
                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="codigo_regional"/>
                  <html:errors property="nome_regional"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Regionais_vendas"/>
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
                  <html:text property="codigo_regional" styleClass="baseField" size="3" maxlength="3"/>
                </td>
              </tr>

              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Nome
                  </span>
                </td>
                <td class="formField">
                  <html:text property="nome_regional" styleClass="baseField" size="40" maxlength="40"/>
                </td>
              </tr>

            </table>

            <table class="buttonTable" style='width:500;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:button accesskey="p" onclick="resetfull1_action.disabled=true;close_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
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
                  </SCRIPT><html:button accesskey="r" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                  <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action"><bean:message bundle="ApplicationResources" key="jsp.close"/></html:button>
                  <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                  <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form><script type="text/javascript">
                  var focusControl = document.forms[0].elements["codigo_regional"];
                  if (focusControl.type != "hidden"){
                    focusControl.focus();
                  }
                </script>

                <%
                {
                  %>

                  <%
                  java.util.Vector res_Regionais_vendas = (java.util.Vector)session.getAttribute("res_Regionais_vendas");
                  %>

                  <form  name="bl_report_Regionais_vendas" id="bl_report_Regionais_vendas" class="baseForm" method="post" >
                    <%
                    if (res_Regionais_vendas!=null && res_Regionais_vendas.size()>0) {
                      %>

                      <table id="TRbl_report_Regionais_vendas"  class="reportTable"   style="width:500; "  >
                        <%
                        int codigo_regional =  0;
                        java.lang.String nome_regional =  null;
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
                        int i_bl_report_Regionais_vendas = 0;
                        while (i_bl_report_Regionais_vendas<res_Regionais_vendas.size()) {
                          portalbr.dbobj.table.Regionais_vendas t_regionais_vendas = (portalbr.dbobj.table.Regionais_vendas)res_Regionais_vendas.elementAt(i_bl_report_Regionais_vendas);
                          codigo_regional = t_regionais_vendas.getCodigo_regional();
                          nome_regional = t_regionais_vendas.getNome_regional()==null?"":t_regionais_vendas.getNome_regional();
                          String style_bl_report_Regionais_vendas="";
                          if (!((i_bl_report_Regionais_vendas%2)!=0)) {
                            style_bl_report_Regionais_vendas="rowColor";
                          } else {
                            style_bl_report_Regionais_vendas="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Regionais_vendas %>' id="TRbl_report_Regionais_vendas<%=i_bl_report_Regionais_vendas%>" >
                            <td class="reportColumn" style="text-align:right;" >
                              <%= codigo_regional %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <a href="javascript:setLov('<%= codigo_regional %>','<%= nome_regional %>')" style="cursor:hand">
                                <%= nome_regional %>
                              </a>

                            </td>

                          </tr>

                          <%
                          i_bl_report_Regionais_vendas++;
                          if (i_bl_report_Regionais_vendas<res_Regionais_vendas.size()) {
                            t_regionais_vendas = (portalbr.dbobj.table.Regionais_vendas)res_Regionais_vendas.elementAt(i_bl_report_Regionais_vendas);
                            codigo_regional = t_regionais_vendas.getCodigo_regional();
                            nome_regional = t_regionais_vendas.getNome_regional()==null?"":t_regionais_vendas.getNome_regional();
                          } else {
                          }
                        }
                        %>

                      </table>

                      <%
                    }
                    %>

                    <script type="text/javascript">
                      function setLov(CODIGO_REGIONAL,NOME_REGIONAL) {
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
                            session.setAttribute("ge_LovPage", "LvRegionalLov");
                          } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvRegionalLov")) {
                            returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                            return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                            return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                          }
                          %>
                          returnBlock = <%= returnBlock %>;
                          <% if (return0!=null && return0.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CODIGO_REGIONAL; };
                          <%}%>
                          <% if (return1!=null && return1.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=NOME_REGIONAL; };
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

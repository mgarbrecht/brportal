<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
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

          <html:form action="lov/LvDocumentoInterfaceLov.do" method="post" styleClass="baseForm" target="_self">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Lista de Valores - Documento/Interface
                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="doin_nome"/>
                  <html:errors property="doin_descricao"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Documentos_interfaces"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Nome
                  </span>
                </td>
                <td class="formField">
                  <html:text property="doin_nome" styleClass="baseField" size="60" maxlength="80"/>
                </td>
              </tr>

              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Descrição
                  </span>
                </td>
                <td class="formField">
                  <html:text property="doin_descricao" styleClass="baseField" size="60" maxlength="512"/>
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
                  var focusControl = document.forms[0].elements["doin_nome"];
                  if (focusControl.type != "hidden"){
                    focusControl.focus();
                  }
                </script>

                <%
                {
                  %>

                  <%
                  java.util.Vector res_Documentos_interfaces = (java.util.Vector)session.getAttribute("res_Documentos_interfaces");
                  %>

                  <form  name="bl_report_Documentos_interfaces" id="bl_report_Documentos_interfaces" class="baseForm" method="post" >
                    <%
                    if (res_Documentos_interfaces!=null && res_Documentos_interfaces.size()>0) {
                      %>

                      <table id="TRbl_report_Documentos_interfaces"  class="reportTable"   style="width:500; "  >
                        <%
                        java.lang.Integer doin_id =  null;
                        java.lang.String doin_nome =  null;
                        java.lang.String doin_descricao =  null;
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:left;" >
                            Nome
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Descrição
                          </td>

                        </tr>

                        <%
                        int i_bl_report_Documentos_interfaces = 0;
                        while (i_bl_report_Documentos_interfaces<res_Documentos_interfaces.size()) {
                          portalbr.dbobj.table.Documentos_interfaces t_documentos_interfaces = (portalbr.dbobj.table.Documentos_interfaces)res_Documentos_interfaces.elementAt(i_bl_report_Documentos_interfaces);
                          doin_id = t_documentos_interfaces.getDoin_id();
                          doin_nome = t_documentos_interfaces.getDoin_nome()==null?"":t_documentos_interfaces.getDoin_nome();
                          doin_descricao = t_documentos_interfaces.getDoin_descricao()==null?"":t_documentos_interfaces.getDoin_descricao();
                          String style_bl_report_Documentos_interfaces="";
                          if (!((i_bl_report_Documentos_interfaces%2)!=0)) {
                            style_bl_report_Documentos_interfaces="rowColor";
                          } else {
                            style_bl_report_Documentos_interfaces="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Documentos_interfaces %>' id="TRbl_report_Documentos_interfaces<%=i_bl_report_Documentos_interfaces%>" >
                            <td class="reportColumn" style="text-align:left;" >
                              <a href="javascript:setLov('<%= doin_id %>','<%= doin_nome %>','<%= doin_descricao %>')" style="cursor:hand">
                                <%= doin_nome %>
                              </a>

                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <%= doin_descricao %>
                            </td>

                          </tr>

                          <%
                          i_bl_report_Documentos_interfaces++;
                          if (i_bl_report_Documentos_interfaces<res_Documentos_interfaces.size()) {
                            t_documentos_interfaces = (portalbr.dbobj.table.Documentos_interfaces)res_Documentos_interfaces.elementAt(i_bl_report_Documentos_interfaces);
                            doin_id = t_documentos_interfaces.getDoin_id();
                            doin_nome = t_documentos_interfaces.getDoin_nome()==null?"":t_documentos_interfaces.getDoin_nome();
                            doin_descricao = t_documentos_interfaces.getDoin_descricao()==null?"":t_documentos_interfaces.getDoin_descricao();
                          } else {
                          }
                        }
                        %>

                      </table>

                      <%
                    }
                    %>

                    <script type="text/javascript">
                      function setLov(DOIN_ID,DOIN_NOME,DOIN_DESCRICAO) {
                        <% {
                          String returnBlock = "0";
                          String return0 = null;
                          String return1 = null;
                          String return2 = null;
                          if (request.getParameter("returnBlock")!=null) {
                            returnBlock = request.getParameter("returnBlock");
                            session.setAttribute("returnBlock",returnBlock);
                            return0 = ((request.getParameter("return0")!=null)?request.getParameter("return0"):null);
                            session.setAttribute("return0",return0);
                            return1 = ((request.getParameter("return1")!=null)?request.getParameter("return1"):null);
                            session.setAttribute("return1",return1);
                            return2 = ((request.getParameter("return2")!=null)?request.getParameter("return2"):null);
                            session.setAttribute("return2",return2);
                            session.setAttribute("ge_LovPage", "LvDocumentoInterfaceLov");
                          } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvDocumentoInterfaceLov")) {
                            returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                            return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                            return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                            return2 = ((session.getAttribute("return2")!=null)?(String)session.getAttribute("return2"):null);
                          }
                          %>
                          returnBlock = <%= returnBlock %>;
                          <% if (return0!=null && return0.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=DOIN_ID; };
                          <%}%>
                          <% if (return1!=null && return1.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=DOIN_NOME; };
                          <%}%>
                          <% if (return2!=null && return2.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return2%>!=null) { opener.document.forms[returnBlock].<%= return2 %>.value=DOIN_DESCRICAO; };
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

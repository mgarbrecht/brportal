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

          <html:form action="lov/LvUsuarioLov.do" method="post" styleClass="baseForm" target="_self">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  <bean:message bundle="LovResources" key="LvUsuario.titulo"/>

                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="usua_usuario"/>
                  <html:errors property="usua_nome"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Usuarios"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    <bean:message bundle="LovResources" key="LvUsuario.usua_usuario"/>
                  </span>
                </td>
                <td class="formField">
                  <html:text property="usua_usuario" styleClass="baseField" size="30" maxlength="30"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    <bean:message bundle="LovResources" key="LvUsuario.usua_nome"/>
                  </span>
                </td>
                <td class="formField">
                  <html:text property="usua_nome" styleClass="baseField" size="40" maxlength="40"/>
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
                  var focusControl = document.forms[0].elements["usua_usuario"];
                  if (focusControl.type != "hidden"){
                    focusControl.focus();
                  }
                </script>

                <%
                {
                  %>

                  <%
                  java.util.Vector res_Usuarios = (java.util.Vector)session.getAttribute("res_Usuarios");
                  %>

                  <form  name="bl_report_Usuarios" id="bl_report_Usuarios" class="baseForm" method="post" >
                    <%
                    if (res_Usuarios!=null && res_Usuarios.size()>0) {
                      %>

                      <table id="TRbl_report_Usuarios"  class="reportTable"   style="width:500; "  >
                        <%
                        java.lang.Integer usua_id =  null;
                        java.lang.String usua_nome =  null;
                        java.lang.String usua_usuario =  null;
                        java.lang.String situacao =  null;
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:left;" >
                            <bean:message bundle="LovResources" key="LvUsuario.usua_nome"/>
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            <bean:message bundle="LovResources" key="LvUsuario.usua_usuario"/>
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Situação
                          </td>

                        </tr>

                        <%
                        int i_bl_report_Usuarios = 0;
                        while (i_bl_report_Usuarios<res_Usuarios.size()) {
                          portalbr.dbobj.table.Usuarios t_usuarios = (portalbr.dbobj.table.Usuarios)res_Usuarios.elementAt(i_bl_report_Usuarios);
                          usua_id = t_usuarios.getUsua_id();
                          usua_nome = t_usuarios.getUsua_nome()==null?"":t_usuarios.getUsua_nome();
                          usua_usuario = t_usuarios.getUsua_usuario()==null?"":t_usuarios.getUsua_usuario();
                          situacao = t_usuarios.getSituacao()==null?"":t_usuarios.getSituacao();
                          String style_bl_report_Usuarios="";
                          if (!((i_bl_report_Usuarios%2)!=0)) {
                            style_bl_report_Usuarios="rowColor";
                          } else {
                            style_bl_report_Usuarios="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Usuarios %>' id="TRbl_report_Usuarios<%=i_bl_report_Usuarios%>" >
                            <td class="reportColumn" style="text-align:left;" >
                              <a href="javascript:setLov('<%= usua_id %>','<%= usua_nome %>','<%= usua_usuario %>','<%= situacao.equalsIgnoreCase("A")?"Ativo":"Bloqueado" %>')" style="cursor:hand">
                                <%= usua_nome %>
                              </a>

                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <%= usua_usuario %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <%= situacao.equalsIgnoreCase("A")?"Ativo":"Bloqueado" %>
                            </td>

                          </tr>

                          <%
                          i_bl_report_Usuarios++;
                          if (i_bl_report_Usuarios<res_Usuarios.size()) {
                            t_usuarios = (portalbr.dbobj.table.Usuarios)res_Usuarios.elementAt(i_bl_report_Usuarios);
                            usua_id = t_usuarios.getUsua_id();
                            usua_nome = t_usuarios.getUsua_nome()==null?"":t_usuarios.getUsua_nome();
                            usua_usuario = t_usuarios.getUsua_usuario()==null?"":t_usuarios.getUsua_usuario();
                            situacao = t_usuarios.getSituacao()==null?"":t_usuarios.getSituacao();
                          } else {
                          }
                        }
                        %>

                      </table>

                      <%
                    }
                    %>

                    <script type="text/javascript">
                      function setLov(USUA_ID,USUA_NOME,USUA_USUARIO,SITUACAO) {
                        <% {
                          String returnBlock = "0";
                          String return0 = null;
                          String return1 = null;
                          String return2 = null;
                          String return3 = null;
                          if (request.getParameter("returnBlock")!=null) {
                            returnBlock = request.getParameter("returnBlock");
                            session.setAttribute("returnBlock",returnBlock);
                            return0 = ((request.getParameter("return0")!=null)?request.getParameter("return0"):null);
                            session.setAttribute("return0",return0);
                            return1 = ((request.getParameter("return1")!=null)?request.getParameter("return1"):null);
                            session.setAttribute("return1",return1);
                            return2 = ((request.getParameter("return2")!=null)?request.getParameter("return2"):null);
                            session.setAttribute("return2",return2);
                            return3 = ((request.getParameter("return3")!=null)?request.getParameter("return3"):null);
                            session.setAttribute("return3",return3);
                            session.setAttribute("ge_LovPage", "LvUsuarioLov");
                          } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvUsuarioLov")) {
                            returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                            return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                            return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                            return2 = ((session.getAttribute("return2")!=null)?(String)session.getAttribute("return2"):null);
                            return3 = ((session.getAttribute("return3")!=null)?(String)session.getAttribute("return3"):null);
                          }
                          %>
                          returnBlock = <%= returnBlock %>;
                          <% if (return0!=null && return0.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=USUA_ID; };
                          <%}%>
                          <% if (return1!=null && return1.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=USUA_NOME; };
                          <%}%>
                          <% if (return2!=null && return2.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return2%>!=null) { opener.document.forms[returnBlock].<%= return2 %>.value=USUA_USUARIO; };
                          <%}%>
                          <% if (return3!=null && return3.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return3%>!=null) { opener.document.forms[returnBlock].<%= return3 %>.value=SITUACAO; };
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

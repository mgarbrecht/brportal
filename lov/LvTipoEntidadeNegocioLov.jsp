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

          <html:form action="lov/LvTipoEntidadeNegocioLov.do" method="post" styleClass="baseForm" target="_self">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Lista de Valores - Tipo de Entidades de Negócio
                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="tien_id"/>
                  <html:errors property="tien_tipo"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Tipos_entidade_negocio"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Id
                  </span>
                </td>
                <td class="formField">
                  <html:text property="tien_id" styleClass="baseField" size="10" maxlength="10"/>
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
                  <html:text property="tien_tipo" styleClass="baseField" size="40" maxlength="40"/>
                </td>
              </tr>

            </table>

            <table class="buttonTable" style='width:500;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:button accesskey="s" onclick="this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
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
                      document.forms[0].select_action.click();
                    }
                  }
                </script>
                <SCRIPT>
                  document.onkeypress = getKeySite;
                  </SCRIPT>
                  <html:button accesskey="r" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                  <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:button>
                  <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                  <bean:message bundle="ApplicationResources" key="jsp.close"/>
                  </html:button>
                  <html:submit styleClass="myhidden" property="select_action">
                  <bean:message bundle="ApplicationResources" key="jsp.select"/>
                  </html:submit>
                  <html:submit styleClass="myhidden" property="resetfull_action">
                  <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form>
                  <script type="text/javascript">
                  var focusControl = document.forms[0].elements["tien_id"];
                  if (focusControl.type != "hidden"){
                    focusControl.focus();
                  }
                </script>

                <%
                {
                  %>

                  <%
                  java.util.Vector res_Tipos_entidade_negocio = (java.util.Vector)session.getAttribute("res_Tipos_entidade_negocio");
                  %>

                  <form  name="bl_report_Tipos_entidade_negocio" id="bl_report_Tipos_entidade_negocio" class="baseForm" method="post" >
                    <%
                    if (res_Tipos_entidade_negocio!=null && res_Tipos_entidade_negocio.size()>0) {
                      %>

                      <table id="TRbl_report_Tipos_entidade_negocio"  class="reportTable"   style="width:500; "  >
                        <%
                        java.lang.Integer tien_id =  null;
                        java.lang.String tien_tipo =  null;
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:right;" >
                            Id
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Descrição
                          </td>

                        </tr>

                        <%
                        int i_bl_report_Tipos_entidade_negocio = 0;
                        while (i_bl_report_Tipos_entidade_negocio<res_Tipos_entidade_negocio.size()) {
                          portalbr.dbobj.table.Tipos_entidade_negocio t_tipos_entidade_negocio = (portalbr.dbobj.table.Tipos_entidade_negocio)res_Tipos_entidade_negocio.elementAt(i_bl_report_Tipos_entidade_negocio);
                          tien_id = t_tipos_entidade_negocio.getTien_id();
                          tien_tipo = t_tipos_entidade_negocio.getTien_tipo()==null?"":t_tipos_entidade_negocio.getTien_tipo();
                          String style_bl_report_Tipos_entidade_negocio="";
                          if (!((i_bl_report_Tipos_entidade_negocio%2)!=0)) {
                            style_bl_report_Tipos_entidade_negocio="rowColor";
                          } else {
                            style_bl_report_Tipos_entidade_negocio="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Tipos_entidade_negocio %>' id="TRbl_report_Tipos_entidade_negocio<%=i_bl_report_Tipos_entidade_negocio%>" >
                            <td class="reportColumn" style="text-align:right;" >
                              <%= ((tien_id!=null)?tien_id.toString():"") %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <a href="javascript:setLov('<%= tien_id %>','<%= tien_tipo %>')" style="cursor:hand">
                                <%= tien_tipo %>
                              </a>

                            </td>

                          </tr>

                          <%
                          i_bl_report_Tipos_entidade_negocio++;
                          if (i_bl_report_Tipos_entidade_negocio<res_Tipos_entidade_negocio.size()) {
                            t_tipos_entidade_negocio = (portalbr.dbobj.table.Tipos_entidade_negocio)res_Tipos_entidade_negocio.elementAt(i_bl_report_Tipos_entidade_negocio);
                            tien_id = t_tipos_entidade_negocio.getTien_id();
                            tien_tipo = t_tipos_entidade_negocio.getTien_tipo()==null?"":t_tipos_entidade_negocio.getTien_tipo();
                          } else {
                          }
                        }
                        %>

                      </table>

                      <%
                    }
                    %>

                    <script type="text/javascript">
                      function setLov(TIEN_ID,TIEN_TIPO) {
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
                            session.setAttribute("ge_LovPage", "LvTipoEntidadeNegocioLov");
                          } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvTipoEntidadeNegocioLov")) {
                            returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                            return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                            return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                          }
                          %>
                          returnBlock = <%= returnBlock %>;
                          <% if (return0!=null && return0.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=TIEN_ID; };
                          <%}%>
                          <% if (return1!=null && return1.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=TIEN_TIPO; };
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

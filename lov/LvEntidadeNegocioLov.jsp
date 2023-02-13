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

          <html:form action="lov/LvEntidadeNegocioLov.do" method="post" styleClass="baseForm" target="_self">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Lista de Valores - Entidades Negócio
                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="enne_id"/>
                  <html:errors property="enne_descricao"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_entidades_negocio"/>
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
                  <html:text property="enne_id" styleClass="baseField" size="10" maxlength="10"/>
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
                  <html:text property="enne_descricao" styleClass="baseField" size="60" maxlength="255"/>
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
                  </SCRIPT><html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                  <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action"><bean:message bundle="ApplicationResources" key="jsp.close"/></html:button>
                  <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                  <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form><script type="text/javascript">
                  var focusControl = document.forms[0].elements["enne_id"];
                  if (focusControl.type != "hidden"){
                    focusControl.focus();
                  }
                </script>

                <%
                {
                  %>

                  <%
                  java.util.Vector res_Jw_entidades_negocio = (java.util.Vector)session.getAttribute("res_Jw_entidades_negocio");
                  %>

                  <form  name="bl_report_Jw_entidades_negocio" id="bl_report_Jw_entidades_negocio" class="baseForm" method="post" >
                    <%
                    if (res_Jw_entidades_negocio!=null && res_Jw_entidades_negocio.size()>0) {
                      %>

                      <table id="TRbl_report_Jw_entidades_negocio"  class="reportTable"   style="width:500; "  >
                        <%
                        java.lang.Integer enne_id =  null;
                        java.lang.String enne_descricao =  null;
                        java.lang.String enne_chave =  null;
                        java.lang.Integer enne_tien_id =  null;
                        java.lang.Integer tien_dias_consulta_retroativa =  null;
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
                        int i_bl_report_Jw_entidades_negocio = 0;
                        while (i_bl_report_Jw_entidades_negocio<res_Jw_entidades_negocio.size()) {
                          portalbr.dbobj.view.Jw_entidades_negocio t_jw_entidades_negocio = (portalbr.dbobj.view.Jw_entidades_negocio)res_Jw_entidades_negocio.elementAt(i_bl_report_Jw_entidades_negocio);
                          enne_id = t_jw_entidades_negocio.getEnne_id();
                          enne_descricao = t_jw_entidades_negocio.getEnne_descricao()==null?"":t_jw_entidades_negocio.getEnne_descricao();
                          enne_chave = t_jw_entidades_negocio.getEnne_chave()==null?"":t_jw_entidades_negocio.getEnne_chave();
                          enne_tien_id = t_jw_entidades_negocio.getEnne_tien_id();
                          tien_dias_consulta_retroativa = t_jw_entidades_negocio.getTien_dias_consulta_retroativa();
                          String style_bl_report_Jw_entidades_negocio="";
                          if (!((i_bl_report_Jw_entidades_negocio%2)!=0)) {
                            style_bl_report_Jw_entidades_negocio="rowColor";
                          } else {
                            style_bl_report_Jw_entidades_negocio="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Jw_entidades_negocio %>' id="TRbl_report_Jw_entidades_negocio<%=i_bl_report_Jw_entidades_negocio%>" >
                            <td class="reportColumn" style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(enne_id, "0") %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <a href="javascript:setLov('<%= enne_id %>','<%= enne_descricao %>','<%= enne_tien_id %>','<%= tien_dias_consulta_retroativa %>')" style="cursor:hand">
                                <%= enne_descricao %>
                              </a>

                            </td>

                          </tr>

                          <%
                          i_bl_report_Jw_entidades_negocio++;
                          if (i_bl_report_Jw_entidades_negocio<res_Jw_entidades_negocio.size()) {
                            t_jw_entidades_negocio = (portalbr.dbobj.view.Jw_entidades_negocio)res_Jw_entidades_negocio.elementAt(i_bl_report_Jw_entidades_negocio);
                            enne_id = t_jw_entidades_negocio.getEnne_id();
                            enne_descricao = t_jw_entidades_negocio.getEnne_descricao()==null?"":t_jw_entidades_negocio.getEnne_descricao();
                            enne_chave = t_jw_entidades_negocio.getEnne_chave()==null?"":t_jw_entidades_negocio.getEnne_chave();
                            enne_tien_id = t_jw_entidades_negocio.getEnne_tien_id();
                            tien_dias_consulta_retroativa = t_jw_entidades_negocio.getTien_dias_consulta_retroativa();
                          } else {
                          }
                        }
                        %>

                      </table>

                      <%
                    }
                    %>

                    <script type="text/javascript">
                      function setLov(ENNE_ID,ENNE_DESCRICAO,ENNE_TIEN_ID,TIEN_DIAS_CONSULTA_RETROATIVA) {
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
                            session.setAttribute("ge_LovPage", "LvEntidadeNegocioLov");
                          } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvEntidadeNegocioLov")) {
                            returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                            return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                            return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                            return2 = ((session.getAttribute("return2")!=null)?(String)session.getAttribute("return2"):null);
                            return3 = ((session.getAttribute("return3")!=null)?(String)session.getAttribute("return3"):null);
                          }
                          %>
                          returnBlock = <%= returnBlock %>;
                          <% if (return0!=null && return0.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=ENNE_ID; };
                          <%}%>
                          <% if (return1!=null && return1.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=ENNE_DESCRICAO; };
                          <%}%>
                          <% if (return2!=null && return2.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return2%>!=null) { opener.document.forms[returnBlock].<%= return2 %>.value=ENNE_TIEN_ID; };
                          <%}%>
                          <% if (return3!=null && return3.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return3%>!=null) { opener.document.forms[returnBlock].<%= return3 %>.value=TIEN_DIAS_CONSULTA_RETROATIVA; };
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

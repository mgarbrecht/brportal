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

          <html:form action="lov/LvMarcaLov.do" method="post" styleClass="baseForm">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  <b>
                    <bean:message bundle="LovResources" key="LvMarca.titulo"/>
                  </b>

                </td>

              </tr>

            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="codigo_marca"/>
                  <html:errors property="descricao_marca"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_marcas"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    <bean:message bundle="LovResources" key="LvMarca.codigo_marca"/>
                  </span>
                </td>
                <td class="formField">
                  <html:text property="codigo_marca" styleId="codigo_marca" styleClass="baseField" size="22" maxlength="22"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    <bean:message bundle="LovResources" key="LvMarca.descricao_marca"/>
                  </span>
                </td>
                <td class="formField">
                  <html:text property="descricao_marca" styleId="descricao_marca" styleClass="baseField" size="30" maxlength="30"/>
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
                  </SCRIPT>

                  <html:button accesskey="r" onclick="document.forms[0].resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                  <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:button>
                  <html:button accesskey="c" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                  <bean:message bundle="ApplicationResources" key="jsp.close"/>
                  </html:button>
                  <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                  <bean:message bundle="ApplicationResources" key="jsp.select"/>
                  </html:submit>
                  <html:submit accesskey="r" styleClass="myhidden" property="resetfull_action">
                  <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form>
                  <script type="text/javascript">
                  var focusControl = document.forms[0].elements["codigo_marca"];
                  if (focusControl.type != "hidden"){
                    focusControl.focus();
                  }
                </script>

                <%
                {
                  %>

                  <%
                  java.util.Vector res_Jw_marcas = (java.util.Vector)session.getAttribute("res_Jw_marcas");
                  %>

                  <form  name="bl_report_Jw_marcas" id="bl_report_Jw_marcas" class="baseForm" method="post" >
                    <%
                    if (res_Jw_marcas!=null && res_Jw_marcas.size()>0) {
                      %>

                      <table id="TRbl_report_Jw_marcas"  class="reportTable"   style="width:500; "  >
                        <%
                        int codigo_marca =  0;
                        java.lang.String descricao_marca =  null;
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:right;" >
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                          </td>

                        </tr>

                        <%
                        int i_bl_report_Jw_marcas = 0;
                        while (i_bl_report_Jw_marcas<res_Jw_marcas.size()) {
                          portalbr.dbobj.view.Jw_marcas t_jw_marcas = (portalbr.dbobj.view.Jw_marcas)res_Jw_marcas.elementAt(i_bl_report_Jw_marcas);
                          codigo_marca = t_jw_marcas.getCodigo_marca();
                          descricao_marca = t_jw_marcas.getDescricao_marca()==null?"":t_jw_marcas.getDescricao_marca();
                          String style_bl_report_Jw_marcas="";
                          if (!((i_bl_report_Jw_marcas%2)!=0)) {
                            style_bl_report_Jw_marcas="rowColor";
                          } else {
                            style_bl_report_Jw_marcas="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Jw_marcas %>' id="TRbl_report_Jw_marcas<%=i_bl_report_Jw_marcas%>" >
                            <td class="reportColumn" style="text-align:right;" >
                              <%= codigo_marca %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <a href="javascript:setLov('<%= codigo_marca %>','<%= descricao_marca %>')" style="cursor:hand">
                                <%= descricao_marca %>
                              </a>

                            </td>

                          </tr>

                          <%
                          i_bl_report_Jw_marcas++;
                          if (i_bl_report_Jw_marcas<res_Jw_marcas.size()) {
                            t_jw_marcas = (portalbr.dbobj.view.Jw_marcas)res_Jw_marcas.elementAt(i_bl_report_Jw_marcas);
                            codigo_marca = t_jw_marcas.getCodigo_marca();
                            descricao_marca = t_jw_marcas.getDescricao_marca()==null?"":t_jw_marcas.getDescricao_marca();
                          } else {
                          }
                        }
                        %>

                      </table>

                      <%
                    }
                    %>

                    <script type="text/javascript">
                      function setLov(CODIGO_MARCA,DESCRICAO_MARCA) {
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
                            session.setAttribute("ge_LovPage", "LvMarcaLov");
                          } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvMarcaLov")) {
                            returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                            return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                            return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                          }
                          %>
                          returnBlock = <%= returnBlock %>;
                          <% if (return0!=null && return0.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CODIGO_MARCA; };
                          <%}%>
                          <% if (return1!=null && return1.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=DESCRICAO_MARCA; };
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

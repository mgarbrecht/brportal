<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvGrupoMaterialLov.do" method="post" styleClass="baseForm">
              <table class="bannerTable" style="width:500;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Grupos de Material
                  </td>
                </tr>
              </table>

              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="gpo_mater_cdgo"/>
                    <html:errors property="gpo_mater_desc"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Dom_grupo_material"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Grupo
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="gpo_mater_cdgo" styleId="gpo_mater_cdgo" styleClass="baseField" size="6" maxlength="6"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="gpo_mater_desc" styleId="gpo_mater_desc" styleClass="baseField" size="40" maxlength="40"/>
                  </td>
                </tr>

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
              var focusControl = document.forms[0].elements["gpo_mater_cdgo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Dom_grupo_material = (java.util.Vector)session.getAttribute("res_Dom_grupo_material");
              %>

              <form  name="bl_report_Dom_grupo_material" id="bl_report_Dom_grupo_material" class="baseForm" method="post" >
                <%
                if (res_Dom_grupo_material!=null && res_Dom_grupo_material.size()>0) {
                  %>

                  <table id="TRbl_report_Dom_grupo_material"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.Integer gpo_mater_cdgo =  null;
                    java.lang.String gpo_mater_desc =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Grupo
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Dom_grupo_material = 0;
                    while (i_bl_report_Dom_grupo_material<res_Dom_grupo_material.size()) {
                      portalbr.dbobj.table.Dom_grupo_material t_dom_grupo_material = (portalbr.dbobj.table.Dom_grupo_material)res_Dom_grupo_material.elementAt(i_bl_report_Dom_grupo_material);
                      gpo_mater_cdgo = t_dom_grupo_material.getGpo_mater_cdgo();
                      gpo_mater_desc = t_dom_grupo_material.getGpo_mater_desc()==null?"":t_dom_grupo_material.getGpo_mater_desc();
                      String style_bl_report_Dom_grupo_material="";
                      if (!((i_bl_report_Dom_grupo_material%2)!=0)) {
                        style_bl_report_Dom_grupo_material="rowColor";
                      } else {
                        style_bl_report_Dom_grupo_material="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Dom_grupo_material %>' id="TRbl_report_Dom_grupo_material<%=i_bl_report_Dom_grupo_material%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <a href="javascript:setLov('<%= gpo_mater_cdgo %>','<%= gpo_mater_desc %>')" style="cursor:hand">
                            <%= ((gpo_mater_cdgo!=null)?gpo_mater_cdgo.toString():"") %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= gpo_mater_cdgo %>','<%= gpo_mater_desc %>')" style="cursor:hand">
                            <%= gpo_mater_desc %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Dom_grupo_material++;
                      if (i_bl_report_Dom_grupo_material<res_Dom_grupo_material.size()) {
                        t_dom_grupo_material = (portalbr.dbobj.table.Dom_grupo_material)res_Dom_grupo_material.elementAt(i_bl_report_Dom_grupo_material);
                        gpo_mater_cdgo = t_dom_grupo_material.getGpo_mater_cdgo();
                        gpo_mater_desc = t_dom_grupo_material.getGpo_mater_desc()==null?"":t_dom_grupo_material.getGpo_mater_desc();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(GPO_MATER_CDGO,GPO_MATER_DESC) {
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
                        session.setAttribute("ge_LovPage", "LvGrupoMaterialLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvGrupoMaterialLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=GPO_MATER_CDGO; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=GPO_MATER_DESC; };
                      <%}%>
                      window.close();
                    }
                    <% } %>

                    function setLov(GPO_MATER_CDGO,GPO_MATER_DESC) {
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
                          session.setAttribute("ge_LovPage", "LvGrupoMaterialLov");
                        } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvGrupoMaterialLov")) {
                          returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                          return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                          return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                        }
                        %>
                        returnBlock = <%= returnBlock %>;
                        <% if (return0!=null && return0.length()>0) {%>
                        if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=GPO_MATER_CDGO; };
                        <%}%>
                        <% if (return1!=null && return1.length()>0) {%>
                        if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=GPO_MATER_DESC; };
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

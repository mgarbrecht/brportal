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
            <html:form action="lov/LvMunicipiosLov.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      UF
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="est_unifed" styleId="est_unifed" styleClass="baseField" size="2" maxlength="2"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Municipio
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="descricao" styleId="descricao" styleClass="baseField" size="60" maxlength="60"/>
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
              var focusControl = document.forms[0].elements["est_unifed"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_municipios = (java.util.Vector)session.getAttribute("res_Jw_municipios");
              %>

              <form  name="bl_report_Jw_municipios" id="bl_report_Jw_municipios" class="baseForm" method="post" >
                <%
                if (res_Jw_municipios!=null && res_Jw_municipios.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_municipios"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.Integer codigo =  null;
                    java.lang.String descricao =  null;
                    java.lang.String codigo_ibge =  null;
                    java.lang.String est_unifed =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Código
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Municipio
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        UF
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_municipios = 0;
                    while (i_bl_report_Jw_municipios<res_Jw_municipios.size()) {
                      portalbr.dbobj.view.Jw_municipios t_jw_municipios = (portalbr.dbobj.view.Jw_municipios)res_Jw_municipios.elementAt(i_bl_report_Jw_municipios);
                      codigo = t_jw_municipios.getCodigo();
                      descricao = t_jw_municipios.getDescricao()==null?"":t_jw_municipios.getDescricao();
                      codigo_ibge = t_jw_municipios.getCodigo_ibge()==null?"":t_jw_municipios.getCodigo_ibge();
                      est_unifed = t_jw_municipios.getEst_unifed()==null?"":t_jw_municipios.getEst_unifed();
                      String style_bl_report_Jw_municipios="";
                      if (!((i_bl_report_Jw_municipios%2)!=0)) {
                        style_bl_report_Jw_municipios="rowColor";
                      } else {
                        style_bl_report_Jw_municipios="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_municipios %>' id="TRbl_report_Jw_municipios<%=i_bl_report_Jw_municipios%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((codigo!=null)?codigo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= codigo %>','<%= descricao %>','<%= codigo_ibge %>','<%= est_unifed %>')" style="cursor:hand">
                            <%= descricao %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= est_unifed %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_municipios++;
                      if (i_bl_report_Jw_municipios<res_Jw_municipios.size()) {
                        t_jw_municipios = (portalbr.dbobj.view.Jw_municipios)res_Jw_municipios.elementAt(i_bl_report_Jw_municipios);
                        codigo = t_jw_municipios.getCodigo();
                        descricao = t_jw_municipios.getDescricao()==null?"":t_jw_municipios.getDescricao();
                        codigo_ibge = t_jw_municipios.getCodigo_ibge()==null?"":t_jw_municipios.getCodigo_ibge();
                        est_unifed = t_jw_municipios.getEst_unifed()==null?"":t_jw_municipios.getEst_unifed();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(CODIGO,DESCRICAO,CODIGO_IBGE,EST_UNIFED) {
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
                        session.setAttribute("ge_LovPage", "LvMunicipiosLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvMunicipiosLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                        return2 = ((session.getAttribute("return2")!=null)?(String)session.getAttribute("return2"):null);
                        return3 = ((session.getAttribute("return3")!=null)?(String)session.getAttribute("return3"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CODIGO; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=DESCRICAO; };
                      <%}%>
                      <% if (return2!=null && return2.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return2%>!=null) { opener.document.forms[returnBlock].<%= return2 %>.value=CODIGO_IBGE; };
                      <%}%>
                      <% if (return3!=null && return3.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return3%>!=null) { opener.document.forms[returnBlock].<%= return3 %>.value=EST_UNIFED; };
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

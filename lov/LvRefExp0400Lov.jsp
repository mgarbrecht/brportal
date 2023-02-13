<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body >
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvRefExp0400Lov.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="ref_descricao_exportacao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_ref_exp0400"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <html:hidden property="lin_cdgo" value="<%= request.getParameter("lin_cdgo") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="EntPedidosForm.ref"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ref_cdgo" styleId="ref_cdgo" styleClass="baseField" size="10" maxlength="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="EntPedidosForm.descricao"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ref_descricao_exportacao" styleId="ref_descricao_exportacao" styleClass="baseField" size="50" maxlength="100"/>
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
              var focusControl = document.forms[0].elements["ref_cdgo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_lv_ref_exp0400 = (java.util.Vector)session.getAttribute("res_Jw_lv_ref_exp0400");
              portalbr.lov.LvRefExp0400ActionForm LvRefExp0400ActionForm = (portalbr.lov.LvRefExp0400ActionForm)session.getAttribute("LvRefExp0400ActionForm");
              %>

              <form  name="bl_report_Jw_lv_ref_exp0400" id="bl_report_Jw_lv_ref_exp0400" class="baseForm" method="post" >
                <%
                if (res_Jw_lv_ref_exp0400!=null && res_Jw_lv_ref_exp0400.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_lv_ref_exp0400"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.String lin_cdgo = LvRefExp0400ActionForm.getLin_cdgo();
                    java.lang.String ref_cdgo =  null;
                    java.lang.String ref_descricao_exportacao =  null;
                    java.lang.String imagem = null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        <bean:message bundle="ComercialResources" key="EntPedidosForm.ref"/>
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        <bean:message bundle="ComercialResources" key="EntPedidosForm.descricao"/>
                      </td>
                      <td width="1%">
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_lv_ref_exp0400 = 0;
                    while (i_bl_report_Jw_lv_ref_exp0400<res_Jw_lv_ref_exp0400.size()) {
                      portalbr.dbobj.view.Jw_lv_ref_exp0400 t_jw_lv_ref_exp0400 = (portalbr.dbobj.view.Jw_lv_ref_exp0400)res_Jw_lv_ref_exp0400.elementAt(i_bl_report_Jw_lv_ref_exp0400);
                      ref_cdgo = t_jw_lv_ref_exp0400.getRef_cdgo()==null?"":t_jw_lv_ref_exp0400.getRef_cdgo();
                      ref_descricao_exportacao = t_jw_lv_ref_exp0400.getRef_descricao_exportacao()==null?"":t_jw_lv_ref_exp0400.getRef_descricao_exportacao();
                      String style_bl_report_Jw_lv_ref_exp0400="";
                      imagem = lin_cdgo+"-"+ref_cdgo+".gif";
                      if (!((i_bl_report_Jw_lv_ref_exp0400%2)!=0)) {
                        style_bl_report_Jw_lv_ref_exp0400="rowColor";
                      } else {
                        style_bl_report_Jw_lv_ref_exp0400="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_lv_ref_exp0400 %>' id="TRbl_report_Jw_lv_ref_exp0400<%=i_bl_report_Jw_lv_ref_exp0400%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= ref_cdgo %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= ref_cdgo %>','<%= ref_descricao_exportacao %>')" style="cursor:hand">
                            <%= ref_descricao_exportacao %>
                          </a>

                        </td>

                        <td>
                          <img src="../com/ranking_img/<%= imagem%>">
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_lv_ref_exp0400++;
                      if (i_bl_report_Jw_lv_ref_exp0400<res_Jw_lv_ref_exp0400.size()) {
                        t_jw_lv_ref_exp0400 = (portalbr.dbobj.view.Jw_lv_ref_exp0400)res_Jw_lv_ref_exp0400.elementAt(i_bl_report_Jw_lv_ref_exp0400);
                        ref_cdgo = t_jw_lv_ref_exp0400.getRef_cdgo()==null?"":t_jw_lv_ref_exp0400.getRef_cdgo();
                        ref_descricao_exportacao = t_jw_lv_ref_exp0400.getRef_descricao_exportacao()==null?"":t_jw_lv_ref_exp0400.getRef_descricao_exportacao();
                        imagem = lin_cdgo+"-"+ref_cdgo+".gif";
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(REF_CDGO,REF_DESCRICAO_EXPORTACAO) {
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
                        session.setAttribute("ge_LovPage", "LvRefExp0400Lov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvRefExp0400Lov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=REF_CDGO; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=REF_DESCRICAO_EXPORTACAO; };
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

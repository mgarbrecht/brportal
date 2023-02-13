<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:600;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvMixMateriaisDiaLov.do" method="post" styleClass="baseForm">
              <table class="bannerTable" style="width:600;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Lista de Valores - Materiais
                  </td>
                </tr>
              </table>

              <table class="messageTable" style='width:600;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:600;">
                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="codigo_marca" styleId="codigo_marca" styleClass="baseField" size="1">
                      <html:options property="codigo_marcaList" labelProperty="codigo_marcaLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Material
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="descricao_material" styleId="descricao_material" styleClass="baseField" size="40" maxlength="240"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:600;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="s" styleClass="baseButton" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="r" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:button accesskey="c" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                  </td>
                </tr>
              </table>

            </html:form>
            <%
            {
              %>

              <%
              java.util.Vector res_Jw_mix_materiais_dia = (java.util.Vector)session.getAttribute("res_Jw_mix_materiais_dia");
              %>

              <form  name="bl_report_Jw_mix_materiais_dia" id="bl_report_Jw_mix_materiais_dia" class="baseForm" method="post" >
                <%
                if (res_Jw_mix_materiais_dia!=null && res_Jw_mix_materiais_dia.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_mix_materiais_dia"  class="reportTable"   style="width:600; "  >
                    <%
                    java.lang.Integer codigo_material =  null;
                    java.lang.String descricao_material =  null;
                    java.lang.Integer codigo_marca =  null;
                    java.lang.String descricao_marca =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Material
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Marca
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_mix_materiais_dia = 0;
                    while (i_bl_report_Jw_mix_materiais_dia<res_Jw_mix_materiais_dia.size()) {
                      portalbr.dbobj.view.Jw_mix_materiais_dia t_jw_mix_materiais_dia = (portalbr.dbobj.view.Jw_mix_materiais_dia)res_Jw_mix_materiais_dia.elementAt(i_bl_report_Jw_mix_materiais_dia);
                      codigo_material = t_jw_mix_materiais_dia.getCodigo_material();
                      descricao_material = t_jw_mix_materiais_dia.getDescricao_material()==null?"":t_jw_mix_materiais_dia.getDescricao_material();
                      codigo_marca = t_jw_mix_materiais_dia.getCodigo_marca();
                      descricao_marca = t_jw_mix_materiais_dia.getDescricao_marca()==null?"":t_jw_mix_materiais_dia.getDescricao_marca();
                      String style_bl_report_Jw_mix_materiais_dia="";
                      if (!((i_bl_report_Jw_mix_materiais_dia%2)!=0)) {
                        style_bl_report_Jw_mix_materiais_dia="rowColor";
                      } else {
                        style_bl_report_Jw_mix_materiais_dia="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_mix_materiais_dia %>' id="TRbl_report_Jw_mix_materiais_dia<%=i_bl_report_Jw_mix_materiais_dia%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= codigo_material %>','<%= descricao_material %>')" style="cursor:hand">
                            <%= descricao_material %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= descricao_marca %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_mix_materiais_dia++;
                      if (i_bl_report_Jw_mix_materiais_dia<res_Jw_mix_materiais_dia.size()) {
                        t_jw_mix_materiais_dia = (portalbr.dbobj.view.Jw_mix_materiais_dia)res_Jw_mix_materiais_dia.elementAt(i_bl_report_Jw_mix_materiais_dia);
                        codigo_material = t_jw_mix_materiais_dia.getCodigo_material();
                        descricao_material = t_jw_mix_materiais_dia.getDescricao_material()==null?"":t_jw_mix_materiais_dia.getDescricao_material();
                        codigo_marca = t_jw_mix_materiais_dia.getCodigo_marca();
                        descricao_marca = t_jw_mix_materiais_dia.getDescricao_marca()==null?"":t_jw_mix_materiais_dia.getDescricao_marca();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(CODIGO_MATERIAL,DESCRICAO_MATERIAL) {
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
                        session.setAttribute("ge_LovPage", "LvMixMateriaisDiaLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvMixMateriaisDiaLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CODIGO_MATERIAL; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=DESCRICAO_MATERIAL; };
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

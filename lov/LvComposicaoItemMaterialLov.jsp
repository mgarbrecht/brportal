<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvComposicaoItemMaterialLov.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      Lista de Valores - Materiais
                    </div>
                    <html:errors property="codigo"/>
                    <html:errors property="descricao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_consumo_composicao_item"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Material
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo" styleId="codigo" styleClass="baseField" size="22" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="descricao" styleId="descricao" styleClass="baseField" size="80" maxlength="400"/>
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
              var focusControl = document.forms[0].elements["codigo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_consumo_composicao_material = (java.util.Vector)session.getAttribute("res_Jw_consumo_composicao_material");
              %>

              <form  name="bl_report_Jw_consumo_composicao_material" id="bl_report_Jw_consumo_composicao_material" class="baseForm" method="post" >
                <table class="bannerTable" style="width:500;">
                  <tr class="bannerTr">
                    <td class="bannerTd">
                      Materiais
                    </td>
                  </tr>
                </table>

                <%
                if (res_Jw_consumo_composicao_material!=null && res_Jw_consumo_composicao_material.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_consumo_composicao_material"  class="reportTable"   style="width:500; "  border="1" >
                    <%
                    java.lang.Integer mat_nro =  null;
                    java.lang.String descricao =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Material
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_consumo_composicao_material = 0;
                    while (i_bl_report_Jw_consumo_composicao_material<res_Jw_consumo_composicao_material.size()) {
                      portalbr.dbobj.view.Jw_consumo_composicao_material t_jw_consumo_composicao_material = (portalbr.dbobj.view.Jw_consumo_composicao_material)res_Jw_consumo_composicao_material.elementAt(i_bl_report_Jw_consumo_composicao_material);
                      mat_nro = t_jw_consumo_composicao_material.getMat_nro();
                      descricao = t_jw_consumo_composicao_material.getDescricao()==null?"":t_jw_consumo_composicao_material.getDescricao();
                      String style_bl_report_Jw_consumo_composicao_material="";
                      if (!((i_bl_report_Jw_consumo_composicao_material%2)!=0)) {
                        style_bl_report_Jw_consumo_composicao_material="rowColor";
                      } else {
                        style_bl_report_Jw_consumo_composicao_material="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_consumo_composicao_material %>' id="TRbl_report_Jw_consumo_composicao_material<%=i_bl_report_Jw_consumo_composicao_material%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((mat_nro!=null)?mat_nro.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= descricao %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_consumo_composicao_material++;
                      if (i_bl_report_Jw_consumo_composicao_material<res_Jw_consumo_composicao_material.size()) {
                        t_jw_consumo_composicao_material = (portalbr.dbobj.view.Jw_consumo_composicao_material)res_Jw_consumo_composicao_material.elementAt(i_bl_report_Jw_consumo_composicao_material);
                        mat_nro = t_jw_consumo_composicao_material.getMat_nro();
                        descricao = t_jw_consumo_composicao_material.getDescricao()==null?"":t_jw_consumo_composicao_material.getDescricao();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

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

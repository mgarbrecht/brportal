<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Informe de Pedidos em Show Room
    </title>
  </head>
  <center>
    <body >
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%
                  acesso.Usuario user = (acesso.Usuario) session.getAttribute("User");
                  if(!user.isSuperUsuario() && !user.isAutorizado(190)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>



                </td>

              </tr>

            </table>

            <html:form action="com/PedidosShowRoom_aForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="id_showroom"/>
                    <html:errors property="dt_showroom"/>
                    <html:errors property="ped_nmro"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Ped_inf_adicionais"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Showroom
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="id_showroom" styleId="id_showroom" styleClass="disabled" tabindex="-1" readonly="true" value="<%= request.getParameter("id_showroom") %>" size="20" maxlength="20"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_showroom" styleId="dt_showroom" styleClass="disabled" tabindex="-1" readonly="true" value="<%= request.getParameter("dt_showroom") %>" size="19" maxlength="19"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Pedido
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="ped_nmro" styleId="ped_nmro" styleClass="baseField" size="7" maxlength="7"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="i" styleClass="baseButton" property="insert_action">
                      <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                    </html:submit>
                    <html:button accesskey="f" onclick="opener.document.forms[1].refresh_action.click();javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                    <html:submit styleClass="myhidden" property="delete_action">
                      <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["ped_nmro"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Ped_inf_adicionais = (java.util.Vector)session.getAttribute("res_Ped_inf_adicionais");
              %>

              <form  name="bl_report_Ped_inf_adicionais" id="bl_report_Ped_inf_adicionais" class="baseForm" method="post" >
                <%
                if (res_Ped_inf_adicionais!=null && res_Ped_inf_adicionais.size()>0) {
                  %>

                  <table id="TRbl_report_Ped_inf_adicionais"  class="reportTable"   style="width:99%; "  >
                    <%
                    java.lang.Integer ped_nmro =  null;
                    java.lang.String excluir =  null;
                    java.lang.String id_showroom =  null;
                    java.sql.Date dt_showroom =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Pedido
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Excluir
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Ped_inf_adicionais = 0;
                    while (i_bl_report_Ped_inf_adicionais<res_Ped_inf_adicionais.size()) {
                      portalbr.dbobj.table.Ped_inf_adicionais t_ped_inf_adicionais = (portalbr.dbobj.table.Ped_inf_adicionais)res_Ped_inf_adicionais.elementAt(i_bl_report_Ped_inf_adicionais);
                      ped_nmro = t_ped_inf_adicionais.getPed_nmro();
                      id_showroom = t_ped_inf_adicionais.getId_showroom()==null?"":t_ped_inf_adicionais.getId_showroom();
                      dt_showroom = (java.sql.Date)t_ped_inf_adicionais.getDt_showroom();
                      String style_bl_report_Ped_inf_adicionais="";
                      if (!((i_bl_report_Ped_inf_adicionais%2)!=0)) {
                        style_bl_report_Ped_inf_adicionais="rowColor";
                      } else {
                        style_bl_report_Ped_inf_adicionais="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Ped_inf_adicionais %>' id="TRbl_report_Ped_inf_adicionais<%=i_bl_report_Ped_inf_adicionais%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((ped_nmro!=null)?ped_nmro.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >


                          <a href="../com/PedidosShowRoom_aForm.do?delete_action=&ped_nmro=<%= ped_nmro %>&id_showroom=<%= id_showroom %>&dt_showroom=<%= com.egen.util.text.FormatDate.format(dt_showroom, "dd/MM/yyyy") %>" onclick="if(!confirm('Confirma a exclusão?')){return false;};" style="cursor:hand">
                            <img src="../img/remover_item.gif" style="width:15px">
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Ped_inf_adicionais++;
                      if (i_bl_report_Ped_inf_adicionais<res_Ped_inf_adicionais.size()) {
                        t_ped_inf_adicionais = (portalbr.dbobj.table.Ped_inf_adicionais)res_Ped_inf_adicionais.elementAt(i_bl_report_Ped_inf_adicionais);
                        ped_nmro = t_ped_inf_adicionais.getPed_nmro();
                        id_showroom = t_ped_inf_adicionais.getId_showroom()==null?"":t_ped_inf_adicionais.getId_showroom();
                        dt_showroom = (java.sql.Date)t_ped_inf_adicionais.getDt_showroom();
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/AcessosTrocaIdentidade_rActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = AcessosTrocaIdentidade_rActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("gridCheckField","");
    hashMapLabel.set("atid_usua_id","atid_usua_id");
    hashMapLabel.set("usua_usuario","usua_usuario");
    hashMapLabel.set("usua_nome","usua_nome");
    hashMapLabel.set("atid_tien_id","atid_tien_id");
    hashMapLabel.set("tien_tipo","tien_tipo");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Troca de Identidade - Liberação de Acessos - Listagem
    </title>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(282)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            java.util.Vector res_Jw_acessos_troca_identidade = (java.util.Vector)session.getAttribute("res_Jw_acessos_troca_identidade");
            %>


            <html:form action="acesso/AcessosTrocaIdentidade_rGrid.do" method="post" styleClass="baseForm">

              <%
              if(res_Jw_acessos_troca_identidade != null && res_Jw_acessos_troca_identidade.size() > 0){
                %>
                <table id="TRbl_report_Jw_acessos_troca_identidade"  class="reportTable"   style="width:99%; "  border="1" >
                  <tr class="reportTr">
                    <td style="text-align: center;">
                    </td>

                    <td class="columnTdHeader" style="text-align: right;">
                      ID Usuário
                    </td>

                    <td class="columnTdHeader" style="text-align: left;">
                      Usuário
                    </td>

                    <td class="columnTdHeader" style="text-align: left;">
                      Nome
                    </td>

                    <td class="columnTdHeader" style="text-align: right;">
                      ID Tipo Entidade
                    </td>

                    <td class="columnTdHeader" style="text-align: left;">
                      Tipo Entidade
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Jw_acessos_troca_identidade = 0;
                  String style_bl_report_Jw_acessos_troca_identidade="";
                  %>
                  <logic:iterate id="bl_form_Jw_acessos_troca_identidade_lines" name="AcessosTrocaIdentidade_rGridActionForm" property="bl_form_Jw_acessos_troca_identidade_lines" indexId="indexId">
                    <%
                    portalbr.dbobj.view.Jw_acessos_troca_identidade t_jw_acessos_troca_identidade = (portalbr.dbobj.view.Jw_acessos_troca_identidade)res_Jw_acessos_troca_identidade.elementAt(i_bl_report_Jw_acessos_troca_identidade);
                    if (!((i_bl_report_Jw_acessos_troca_identidade%2)!=0)) {
                      style_bl_report_Jw_acessos_troca_identidade="rowColor";
                    } else {
                      style_bl_report_Jw_acessos_troca_identidade="rowBlank";
                    }
                    %>
                    <tr class='<%= style_bl_report_Jw_acessos_troca_identidade %>' id="TRbl_report_Jw_acessos_troca_identidade<%=i_bl_report_Jw_acessos_troca_identidade%>" >
                      <td class="reportColumn" style="text-align:center;" >
                        <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_acessos_troca_identidade_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align: right;" >
                        <html:hidden property="atid_usua_id" name="bl_form_Jw_acessos_troca_identidade_lines" indexed="true"/>
                        <%= t_jw_acessos_troca_identidade.getAtid_usua_id() %>
                      </td>

                      <td class="reportColumn" style="text-align: left;" >
                        <html:hidden property="usua_usuario" name="bl_form_Jw_acessos_troca_identidade_lines" indexed="true"/>
                        <%= t_jw_acessos_troca_identidade.getUsua_usuario()==null?"":t_jw_acessos_troca_identidade.getUsua_usuario() %>
                      </td>

                      <td class="reportColumn" style="text-align: left;" >
                        <html:hidden property="usua_nome" name="bl_form_Jw_acessos_troca_identidade_lines" indexed="true"/>
                        <%= t_jw_acessos_troca_identidade.getUsua_nome()==null?"":t_jw_acessos_troca_identidade.getUsua_nome() %>
                      </td>

                      <td class="reportColumn" style="text-align: right;" >
                        <html:hidden property="atid_tien_id" name="bl_form_Jw_acessos_troca_identidade_lines" indexed="true"/>
                        <%= t_jw_acessos_troca_identidade.getAtid_tien_id() %>
                      </td>

                      <td class="reportColumn" style="text-align: left" >
                        <html:hidden property="tien_tipo" name="bl_form_Jw_acessos_troca_identidade_lines" indexed="true"/>
                        <%= t_jw_acessos_troca_identidade.getTien_tipo()==null?"":t_jw_acessos_troca_identidade.getTien_tipo() %>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Jw_acessos_troca_identidade++;
                    %>
                  </logic:iterate>

                </table>

                <%
              }
              %>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>

                    <%
                    if(res_Jw_acessos_troca_identidade != null && res_Jw_acessos_troca_identidade.size() > 0){
                      %>

                      <html:submit accesskey="a" styleClass="baseButton" property="delete_action">
                        <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                      </html:submit>
                      <html:submit value="Marcar Todos" styleClass="baseButton" property="marcar_todos_action">
                      </html:submit>
                      <html:submit value="Desmarcar Todos" styleClass="baseButton" property="desmarcar_todos_action">
                      </html:submit>

                      <%
                    }
                    %>

                    <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
          </td>
        </tr>
      </table>

    </body>
  </center>
</html>

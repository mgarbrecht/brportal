<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta de Permissões
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
                  if(!user.isSuperUsuario()){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_consulta_permissoes = (java.util.Vector)session.getAttribute("res_Jw_consulta_permissoes");
              %>

              <form  name="bl_report_Jw_consulta_permissoes" id="bl_report_Jw_consulta_permissoes" class="baseForm" method="post" >
                <%
                if (res_Jw_consulta_permissoes!=null && res_Jw_consulta_permissoes.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_consulta_permissoes"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    int doin_id =  0;
                    java.lang.String doin_descricao =  null;
                    java.lang.String doin_nome =  null;
                    int dias_consulta_retroativa =  0;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Nome
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Dias Consulta Retroativa
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_consulta_permissoes = 0;
                    while (i_bl_report_Jw_consulta_permissoes<res_Jw_consulta_permissoes.size()) {
                      portalbr.dbobj.view.Jw_consulta_permissoes t_jw_consulta_permissoes = (portalbr.dbobj.view.Jw_consulta_permissoes)res_Jw_consulta_permissoes.elementAt(i_bl_report_Jw_consulta_permissoes);
                      doin_id = t_jw_consulta_permissoes.getDoin_id();
                      doin_descricao = t_jw_consulta_permissoes.getDoin_descricao()==null?"":t_jw_consulta_permissoes.getDoin_descricao();
                      doin_nome = t_jw_consulta_permissoes.getDoin_nome()==null?"":t_jw_consulta_permissoes.getDoin_nome();
                      dias_consulta_retroativa = t_jw_consulta_permissoes.getDias_consulta_retroativa();
                      String style_bl_report_Jw_consulta_permissoes="";
                      if (!((i_bl_report_Jw_consulta_permissoes%2)!=0)) {
                        style_bl_report_Jw_consulta_permissoes="rowColor";
                      } else {
                        style_bl_report_Jw_consulta_permissoes="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_consulta_permissoes %>' id="TRbl_report_Jw_consulta_permissoes<%=i_bl_report_Jw_consulta_permissoes%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= doin_descricao %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= doin_nome %>
                        </td>

                        <td class="reportColumn" style="text-align:center;width:1%;" >
                          <%= dias_consulta_retroativa %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_consulta_permissoes++;
                      if (i_bl_report_Jw_consulta_permissoes<res_Jw_consulta_permissoes.size()) {
                        t_jw_consulta_permissoes = (portalbr.dbobj.view.Jw_consulta_permissoes)res_Jw_consulta_permissoes.elementAt(i_bl_report_Jw_consulta_permissoes);
                        doin_id = t_jw_consulta_permissoes.getDoin_id();
                        doin_descricao = t_jw_consulta_permissoes.getDoin_descricao()==null?"":t_jw_consulta_permissoes.getDoin_descricao();
                        doin_nome = t_jw_consulta_permissoes.getDoin_nome()==null?"":t_jw_consulta_permissoes.getDoin_nome();
                        dias_consulta_retroativa = t_jw_consulta_permissoes.getDias_consulta_retroativa();
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

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_consulta_permissoes_documentos_interfaces = (java.util.Vector)session.getAttribute("res_Jw_consulta_permissoes_documentos_interfaces");
              %>

              <form  name="bl_report_Jw_consulta_permissoes_documentos_interfaces" id="bl_report_Jw_consulta_permissoes_documentos_interfaces" class="baseForm" method="post" >
                <%
                if (res_Jw_consulta_permissoes_documentos_interfaces!=null && res_Jw_consulta_permissoes_documentos_interfaces.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_consulta_permissoes_documentos_interfaces"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    double doin_id1 =  0;
                    java.lang.String doin_nome1 =  null;
                    java.lang.String quebra =  null;
                    java.lang.String descricao =  null;
                    String _b0_control = "__";
                    String _b1_control = "__";
                    int i_bl_report_Jw_consulta_permissoes_documentos_interfaces = 0;
                    while (i_bl_report_Jw_consulta_permissoes_documentos_interfaces<res_Jw_consulta_permissoes_documentos_interfaces.size()) {
                      portalbr.dbobj.view.Jw_consulta_permissoes_documentos_interfaces t_jw_consulta_permissoes_documentos_interfaces = (portalbr.dbobj.view.Jw_consulta_permissoes_documentos_interfaces)res_Jw_consulta_permissoes_documentos_interfaces.elementAt(i_bl_report_Jw_consulta_permissoes_documentos_interfaces);
                      doin_id1 = t_jw_consulta_permissoes_documentos_interfaces.getDoin_id();
                      doin_nome1 = t_jw_consulta_permissoes_documentos_interfaces.getDoin_nome()==null?"":t_jw_consulta_permissoes_documentos_interfaces.getDoin_nome();
                      quebra = t_jw_consulta_permissoes_documentos_interfaces.getQuebra()==null?"":t_jw_consulta_permissoes_documentos_interfaces.getQuebra();
                      descricao = t_jw_consulta_permissoes_documentos_interfaces.getDescricao()==null?"":t_jw_consulta_permissoes_documentos_interfaces.getDescricao();
                      String _b0_value = com.egen.util.text.FormatNumber.format(doin_id1,"##,##0.00");
                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                        %>
                        <tr class="reportHeader3">
                          <td colspan="1">
                            Documento/Interface:
                            <%= com.egen.util.text.FormatNumber.format(doin_id1, "##,##0") %>
                            -
                            <%= doin_nome1 %>
                          </td>
                        </tr>
                        <%
                      }
                      String _b1_value = com.egen.util.text.FormatNumber.format(doin_id1,"##,##0.00") + "_" + (quebra==null?"":quebra);
                      if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                        %>
                        <tr class="reportHeader2">
                          <td colspan="1">
                            TIPO:
                            <%= quebra %>
                          </td>
                        </tr>
                        <%
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:left;" >
                            Descrição
                          </td>

                        </tr>

                        <%
                      }
                      String style_bl_report_Jw_consulta_permissoes_documentos_interfaces="";
                      if (!((i_bl_report_Jw_consulta_permissoes_documentos_interfaces%2)!=0)) {
                        style_bl_report_Jw_consulta_permissoes_documentos_interfaces="rowColor";
                      } else {
                        style_bl_report_Jw_consulta_permissoes_documentos_interfaces="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_consulta_permissoes_documentos_interfaces %>' id="TRbl_report_Jw_consulta_permissoes_documentos_interfaces<%=i_bl_report_Jw_consulta_permissoes_documentos_interfaces%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= descricao %>
                        </td>

                      </tr>

                      <%
                      _b0_control = _b0_value;
                      _b1_control = _b1_value;
                      i_bl_report_Jw_consulta_permissoes_documentos_interfaces++;
                      if (i_bl_report_Jw_consulta_permissoes_documentos_interfaces<res_Jw_consulta_permissoes_documentos_interfaces.size()) {
                        t_jw_consulta_permissoes_documentos_interfaces = (portalbr.dbobj.view.Jw_consulta_permissoes_documentos_interfaces)res_Jw_consulta_permissoes_documentos_interfaces.elementAt(i_bl_report_Jw_consulta_permissoes_documentos_interfaces);
                        doin_id1 = t_jw_consulta_permissoes_documentos_interfaces.getDoin_id();
                        doin_nome1 = t_jw_consulta_permissoes_documentos_interfaces.getDoin_nome()==null?"":t_jw_consulta_permissoes_documentos_interfaces.getDoin_nome();
                        quebra = t_jw_consulta_permissoes_documentos_interfaces.getQuebra()==null?"":t_jw_consulta_permissoes_documentos_interfaces.getQuebra();
                        descricao = t_jw_consulta_permissoes_documentos_interfaces.getDescricao()==null?"":t_jw_consulta_permissoes_documentos_interfaces.getDescricao();
                        _b0_value = com.egen.util.text.FormatNumber.format(doin_id1,"##,##0.00");
                        _b1_value = com.egen.util.text.FormatNumber.format(doin_id1,"##,##0.00") + "_" + (quebra==null?"":quebra);
                      } else {
                        _b0_control = "__";
                        _b1_control = "__";
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
            <html:form action="acesso/Permissoes_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
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

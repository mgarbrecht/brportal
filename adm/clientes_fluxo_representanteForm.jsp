<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Sumário de Clientes
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
                  <%@ include file="../system/header_data.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(58)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="adm/Clientes_fluxo_representanteForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <html:hidden property="dt_inicial"/>
                <html:hidden property="dt_final"/>
                <html:hidden property="codigo_regional"/>
                <html:hidden property="codigo_marca"/>
                <html:hidden property="lin_cdgo"/>
                <html:hidden property="situacao_representante"/>
                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:submit accesskey="r" styleClass="myhidden" property="resetfull_action">
                        <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:submit>
                      <html:submit accesskey="b" styleClass="baseButton" property="back_action">
                        <bean:message bundle="ApplicationResources" key="jsp.back"/>
                      </html:submit>
                    </td>
                  </tr>
                </table>

              </html:form>
              <%
              {
                %>

                <%
                java.util.Vector res_Jw_fluxo_representante = (java.util.Vector)session.getAttribute("res_clientes_fluxo_representante");
                %>

                <form  name="bl_report_Jw_fluxo_representante" id="bl_report_Jw_fluxo_representante" class="baseForm" method="post" >

                  <%
                  if (res_Jw_fluxo_representante!=null && res_Jw_fluxo_representante.size()>0) {
                    %>

                    <table id="TRbl_report_Jw_fluxo_representante"  class="reportTable"   style="width:99%; "  border="1" >
                      <%
                      java.lang.Integer codigo_regional =  null;
                      java.lang.String nome_regional =  null;
                      java.lang.String rep_cdgo =  null;
                      java.lang.String rep_rzao =  null;
                      java.lang.Integer quantidade_meses =  null;
                      java.lang.String descricao_quantidade_meses =  null;
                      java.lang.Integer clientes =  null;
                      String _b0_control = "__";
                      String _b1_control = "__";
                      int i_bl_report_Jw_fluxo_representante = 0;
                      while (i_bl_report_Jw_fluxo_representante<res_Jw_fluxo_representante.size()) {
                        portalbr.dbobj.view.Jw_fluxo_representante t_jw_fluxo_representante = (portalbr.dbobj.view.Jw_fluxo_representante)res_Jw_fluxo_representante.elementAt(i_bl_report_Jw_fluxo_representante);
                        codigo_regional = t_jw_fluxo_representante.getCodigo_regional();
                        nome_regional = t_jw_fluxo_representante.getNome_regional()==null?"":t_jw_fluxo_representante.getNome_regional();
                        rep_cdgo = t_jw_fluxo_representante.getRep_cdgo()==null?"":t_jw_fluxo_representante.getRep_cdgo();
                        rep_rzao = t_jw_fluxo_representante.getRep_rzao()==null?"":t_jw_fluxo_representante.getRep_rzao();
                        quantidade_meses = t_jw_fluxo_representante.getQuantidade_meses();
                        descricao_quantidade_meses = t_jw_fluxo_representante.getDescricao_quantidade_meses()==null?"":t_jw_fluxo_representante.getDescricao_quantidade_meses();
                        clientes = t_jw_fluxo_representante.getClientes();
                        String _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional);
                        if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                          %>
                          <tr class="reportHeader3">
                            <td colspan="2">
                              <span class="columnTdHeader" style="text-align:right;" >
                                Regional:
                                <%= nome_regional %>
                              </span>
                            </td>
                          </tr>
                          <%
                        }
                        String _b1_value = com.egen.util.text.FormatNumber.format(codigo_regional) + "_" + (rep_cdgo==null?"":rep_cdgo);
                        if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                          %>
                          <tr class="reportHeader2">
                            <td colspan="2">
                              <span class="columnTdHeader" style="text-align:left; color: #000000" >
                                Representante:
                                <%= rep_cdgo %>
                                -
                                <%= rep_rzao %>
                              </span>
                            </td>
                          </tr>
                          <%
                          %>

                          <tr class="reportTr">
                            <td class="columnTdHeader" style="text-align:left;" >
                              Número Meses
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Clientes Compras
                            </td>

                          </tr>

                          <%
                        }
                        String style_bl_report_Jw_fluxo_representante="";
                        if (!((i_bl_report_Jw_fluxo_representante%2)!=0)) {
                          style_bl_report_Jw_fluxo_representante="rowColor";
                        } else {
                          style_bl_report_Jw_fluxo_representante="rowBlank";
                        }
                        %>

                        <tr class='<%= style_bl_report_Jw_fluxo_representante %>' id="TRbl_report_Jw_fluxo_representante<%=i_bl_report_Jw_fluxo_representante%>" >
                          <td class="reportColumn" style="text-align:left;" >
                            <%= ((descricao_quantidade_meses!=null)?descricao_quantidade_meses.toString():"") %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" title="Clientes Compras do Representante: <%=rep_cdgo%>-<%= rep_rzao %>">
                            <%
                            if(!(request.getParameter("excel")+"").equals("true")){
                              %>
                              <a href="../adm/Clientes_comprasForm.do?select_action=&meses=<%= quantidade_meses %>&codigo_regional=<%= codigo_regional %>&rep_cdgo=<%= rep_cdgo %>&cab=do Representante :<%= rep_rzao.replace('&','*') %>" target="_self" STYLE="cursor:hand">
                                <%= com.egen.util.text.FormatNumber.format(clientes, "#,##0.##") %>
                              </a>
                              <%
                            } else {
                              %>
                              <%= com.egen.util.text.FormatNumber.format(clientes, "#,##0.##") %>
                              <%
                            }
                            %>
                          </td>

                        </tr>

                        <%
                        _b0_control = _b0_value;
                        _b1_control = _b1_value;
                        i_bl_report_Jw_fluxo_representante++;
                        if (i_bl_report_Jw_fluxo_representante<res_Jw_fluxo_representante.size()) {
                          t_jw_fluxo_representante = (portalbr.dbobj.view.Jw_fluxo_representante)res_Jw_fluxo_representante.elementAt(i_bl_report_Jw_fluxo_representante);
                          codigo_regional = t_jw_fluxo_representante.getCodigo_regional();
                          nome_regional = t_jw_fluxo_representante.getNome_regional()==null?"":t_jw_fluxo_representante.getNome_regional();
                          rep_cdgo = t_jw_fluxo_representante.getRep_cdgo()==null?"":t_jw_fluxo_representante.getRep_cdgo();
                          rep_rzao = t_jw_fluxo_representante.getRep_rzao()==null?"":t_jw_fluxo_representante.getRep_rzao();
                          quantidade_meses = t_jw_fluxo_representante.getQuantidade_meses();
                          descricao_quantidade_meses = t_jw_fluxo_representante.getDescricao_quantidade_meses()==null?"":t_jw_fluxo_representante.getDescricao_quantidade_meses();
                          clientes = t_jw_fluxo_representante.getClientes();
                          _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional);
                          _b1_value = com.egen.util.text.FormatNumber.format(codigo_regional) + "_" + (rep_cdgo==null?"":rep_cdgo);
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

            </td>
          </tr>
        </table>

      </body>
    </center>
  </html>

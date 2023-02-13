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

            <html:form action="adm/Clientes_fluxo_regionalForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <html:hidden property="dt_inicial"/>
                <html:hidden property="dt_final"/>
                <html:hidden property="codigo_regional"/>
                <html:hidden property="codigo_marca"/>
                <html:hidden property="lin_cdgo"/>
                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:submit>
                        <%
                      }
                      %>
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <html:submit accesskey="r" styleClass="myhidden" property="resetfull_action">
                          <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                        </html:submit>
                        <%
                      }
                      %>
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <html:submit accesskey="b" styleClass="baseButton" property="back_action">
                          <bean:message bundle="ApplicationResources" key="jsp.back"/>
                        </html:submit>
                        <%
                      }
                      %>
                    </td>
                  </tr>
                </table>

              </html:form>
              <%
              {
                %>

                <%
                java.util.Vector res_Jw_fluxo_regional = (java.util.Vector)session.getAttribute("res_Clientes_fluxo_regional");
                %>

                <form  name="bl_report_Jw_fluxo_regional" id="bl_report_Jw_fluxo_regional" class="baseForm" method="post" >

                  <%
                  if (res_Jw_fluxo_regional!=null && res_Jw_fluxo_regional.size()>0) {
                    %>

                    <table id="TRbl_report_Jw_fluxo_regional" border="1" class="reportTable" style="width:99%;">
                      <%
                      java.lang.Integer codigo_regional =  null;
                      java.lang.String nome_regional =  null;
                      java.lang.Integer quantidade_meses =  null;
                      java.lang.String descricao_quantidade_meses =  null;
                      java.lang.Integer clientes =  null;
                      String _b0_control = "__";
                      int i_bl_report_Jw_fluxo_regional = 0;
                      while (i_bl_report_Jw_fluxo_regional<res_Jw_fluxo_regional.size()) {
                        portalbr.dbobj.view.Jw_fluxo_regional t_jw_fluxo_regional = (portalbr.dbobj.view.Jw_fluxo_regional)res_Jw_fluxo_regional.elementAt(i_bl_report_Jw_fluxo_regional);
                        codigo_regional = t_jw_fluxo_regional.getCodigo_regional();
                        nome_regional = t_jw_fluxo_regional.getNome_regional()==null?"":t_jw_fluxo_regional.getNome_regional();
                        quantidade_meses = t_jw_fluxo_regional.getQuantidade_meses();
                        descricao_quantidade_meses = t_jw_fluxo_regional.getDescricao_quantidade_meses()==null?"":t_jw_fluxo_regional.getDescricao_quantidade_meses();
                        clientes = t_jw_fluxo_regional.getClientes();
                        String _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional);
                        if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                          %>
                          <tr class="reportHeader2">
                            <td colspan="2">
                              <span class="columnTdHeader" style="text-align:left; color: #000000" >
                                Regional:
                                <%= nome_regional %>
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
                        String style_bl_report_Jw_fluxo_regional="";
                        if (!((i_bl_report_Jw_fluxo_regional%2)!=0)) {
                          style_bl_report_Jw_fluxo_regional="rowColor";
                        } else {
                          style_bl_report_Jw_fluxo_regional="rowBlank";
                        }
                        %>

                        <tr class='<%= style_bl_report_Jw_fluxo_regional %>' id="TRbl_report_Jw_fluxo_regional<%=i_bl_report_Jw_fluxo_regional%>" >
                          <td class="reportColumn" style="text-align:left;" >
                            <%= ((descricao_quantidade_meses!=null)?descricao_quantidade_meses.toString():"") %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" title="Clientes Compras da Regional: <%= nome_regional %>">
                            <%
                            if(!(request.getParameter("excel")+"").equals("true")){
                              %>
                              <a href="../adm/Clientes_comprasForm.do?select_action=&meses=<%= quantidade_meses %>&codigo_regional=<%= codigo_regional %>&cab=da Regional : <%= nome_regional %>" target="_self" STYLE="cursor:hand">
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
                        i_bl_report_Jw_fluxo_regional++;
                        if (i_bl_report_Jw_fluxo_regional<res_Jw_fluxo_regional.size()) {
                          t_jw_fluxo_regional = (portalbr.dbobj.view.Jw_fluxo_regional)res_Jw_fluxo_regional.elementAt(i_bl_report_Jw_fluxo_regional);
                          codigo_regional = t_jw_fluxo_regional.getCodigo_regional();
                          nome_regional = t_jw_fluxo_regional.getNome_regional()==null?"":t_jw_fluxo_regional.getNome_regional();
                          quantidade_meses = t_jw_fluxo_regional.getQuantidade_meses();
                          descricao_quantidade_meses = t_jw_fluxo_regional.getDescricao_quantidade_meses()==null?"":t_jw_fluxo_regional.getDescricao_quantidade_meses();
                          clientes = t_jw_fluxo_regional.getClientes();
                          _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional);
                        } else {
                          _b0_control = "__";
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

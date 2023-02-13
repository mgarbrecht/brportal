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

            <%
            {
              %>

              <%
              java.util.Vector res_Clientes_representante = (java.util.Vector)session.getAttribute("res_Clientes_quantidade_atendimentos_representante");
              %>

              <%
              if (res_Clientes_representante!=null && res_Clientes_representante.size()>0) {
                %>

                <table id="TRbl_report_Clientes_quantidade_atendimentos_representante"  class="reportTable"   style="width:99%; "  border="1" >
                  <%
                  java.lang.Integer codigo_regional =  null;
                  java.lang.String nome_regional =  null;
                  java.lang.String rep_cdgo =  null;
                  java.lang.String rep_rzao =  null;
                  java.lang.Integer atendimentos =  null;
                  java.lang.Integer clientes =  null;
                  String _b0_control = "__";
                  String _b1_control = "__";
                  int i_bl_report_Clientes_quantidade_atendimentos_representante = 0;
                  while (i_bl_report_Clientes_quantidade_atendimentos_representante<res_Clientes_representante.size()) {
                    portalbr.dbobj.view.Jw_clientes_quantidade_atendimentos_representante t_clientes_representante = (portalbr.dbobj.view.Jw_clientes_quantidade_atendimentos_representante)res_Clientes_representante.elementAt(i_bl_report_Clientes_quantidade_atendimentos_representante);
                    codigo_regional = t_clientes_representante.getCodigo_regional();
                    nome_regional = t_clientes_representante.getNome_regional();
                    rep_cdgo = t_clientes_representante.getRep_cdgo();
                    rep_rzao = t_clientes_representante.getRep_rzao();
                    atendimentos = t_clientes_representante.getAtendimentos();
                    clientes = t_clientes_representante.getClientes();
                    String _b0_value = (codigo_regional==null?"":codigo_regional+"");
                    if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                      %>
                      <tr class="reportHeader3">
                        <td colspan="2">
                          <span class="reportColumn" style="text-align:left; color: white; font-size: 14px" >
                            Regional:
                            <%= codigo_regional %>
                            -
                            <%= nome_regional %>
                          </span>
                        </td>
                      </tr>
                      <%
                    }
                    String _b1_value = (codigo_regional==null?"":codigo_regional+"") + "_" + (rep_cdgo==null?"":rep_cdgo);
                    if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                      %>
                      <tr class="reportHeader2">
                        <td colspan="2">
                          <span class="reportColumn" style="text-align:left; color: black;" >
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
                          Atendimentos
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Clientes
                        </td>

                      </tr>

                      <%
                    }
                    String style_bl_report_Clientes_quantidade_atendimentos_representante="";
                    if (!((i_bl_report_Clientes_quantidade_atendimentos_representante%2)!=0)) {
                      style_bl_report_Clientes_quantidade_atendimentos_representante="rowColor";
                    } else {
                      style_bl_report_Clientes_quantidade_atendimentos_representante="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Clientes_quantidade_atendimentos_representante %>' id="TRbl_report_Clientes_quantidade_atendimentos_regional<%=i_bl_report_Clientes_quantidade_atendimentos_representante%>" >
                      <td class="reportColumn" style="text-align:left;" >
                        <%= com.egen.util.text.FormatNumber.format(atendimentos, "##,##0.##")  %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <a href="../adm/Clientes_atend_quantidadeForm.do?select_action=&atendimentos=<%= atendimentos %>&codigo_regional=<%= codigo_regional %>&rep_cdgo=<%= rep_cdgo %>" target="_self" STYLE="cursor:hand">
                          <%= com.egen.util.text.FormatNumber.format(clientes, "##,##0.##")  %>
                        </a>
                      </td>

                      <%
                      _b0_control = _b0_value;
                      _b1_control = _b1_value;
                      i_bl_report_Clientes_quantidade_atendimentos_representante++;
                      if (i_bl_report_Clientes_quantidade_atendimentos_representante<res_Clientes_representante.size()) {
                        t_clientes_representante = (portalbr.dbobj.view.Jw_clientes_quantidade_atendimentos_representante)res_Clientes_representante.elementAt(i_bl_report_Clientes_quantidade_atendimentos_representante);
                        codigo_regional = t_clientes_representante.getCodigo_regional();
                        nome_regional = t_clientes_representante.getNome_regional();
                        rep_cdgo = t_clientes_representante.getRep_cdgo();
                        rep_rzao = t_clientes_representante.getRep_rzao();
                        atendimentos = t_clientes_representante.getAtendimentos();
                        clientes = t_clientes_representante.getClientes();
                        _b0_value = (codigo_regional==null?"":codigo_regional+"");
                        _b1_value = (codigo_regional==null?"":codigo_regional+"") + "_" + (rep_cdgo==null?"":rep_cdgo);
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

                <%
              }
              %>

              <html:form action="adm/Clientes_quantidade_atendimentos_representanteForm.do" method="post" styleClass="baseForm">
                <table class="itemTable"  style=" width:;">
                  <html:hidden property="dt_inicial"/>
                  <html:hidden property="dt_final"/>
                  <html:hidden property="codigo_representante"/>
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
              </td>
            </tr>
          </table>

        </body>
      </center>
    </html>

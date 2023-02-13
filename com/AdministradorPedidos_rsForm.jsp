<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Administrador de Pedidos - Previsto / Capacidade
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
                  <%@ include file="../system/header_excel.jsp" %>
                </td>

              </tr>

            </table>

            <%
            com.egen.util.jdbc.JdbcUtil j = null;
            java.util.Vector res_Jw_administrador_pedidos_periodos = null;
            portalbr.dbobj.view.Jw_administrador_pedidos_periodos t_jw_administrador_pedidos_periodos = null;
            int contador = 0;
            double disponivel = 0.0;
            util.consultas.com.AdministradorPedidos administrador = new util.consultas.com.AdministradorPedidos();
            try {
              j = new com.egen.util.jdbc.JdbcUtil();
              %>

              <%
              java.util.Vector res_Jw_web_poi_filtro = (java.util.Vector)session.getAttribute("res_Jw_web_poi_filtro");
              %>

              <form  name="bl_report_Jw_web_poi_filtro" id="bl_report_Jw_web_poi_filtro" class="baseForm" method="post" >
                <%
                if (res_Jw_web_poi_filtro!=null && res_Jw_web_poi_filtro.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_web_poi_filtro"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Integer ano =  null;
                    java.lang.Integer mes =  null;
                    java.lang.String lin_ref =  null;
                    java.lang.Integer linha =  null;
                    java.lang.String ref_codigo =  null;
                    java.lang.String lin_nome =  null;
                    java.lang.Integer periodos =  null;

                    String _b0_control = "__";
                    String _b1_control = "__";
                    int i_bl_report_Jw_web_poi_filtro = 0;
                    while (i_bl_report_Jw_web_poi_filtro<res_Jw_web_poi_filtro.size()) {
                      portalbr.dbobj.view.Jw_web_poi_filtro t_jw_web_poi_filtro = (portalbr.dbobj.view.Jw_web_poi_filtro)res_Jw_web_poi_filtro.elementAt(i_bl_report_Jw_web_poi_filtro);
                      ano = t_jw_web_poi_filtro.getAno();
                      mes = t_jw_web_poi_filtro.getMes();
                      lin_ref = t_jw_web_poi_filtro.getLin_ref()==null?"":t_jw_web_poi_filtro.getLin_ref();
                      linha = t_jw_web_poi_filtro.getLinha();
                      ref_codigo = t_jw_web_poi_filtro.getRef_codigo()==null?"":t_jw_web_poi_filtro.getRef_codigo();
                      lin_nome = t_jw_web_poi_filtro.getLin_nome()==null?"":t_jw_web_poi_filtro.getLin_nome();
                      periodos = t_jw_web_poi_filtro.getPeriodos();
                      String _b0_value = com.egen.util.text.FormatNumber.format(ano);
                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                        %>
                        <tr class="reportHeader">
                          <td colspan="6">
                            <span class="columnTdHeader" style="text-align:right;" >
                              Ano:
                              <%= ((ano!=null)?ano.toString():"") %>
                            </span>
                          </td>
                        </tr>
                        <%
                      }
                      String _b1_value = com.egen.util.text.FormatNumber.format(ano) + "_" + com.egen.util.text.FormatNumber.format(mes);
                      if (_b1_control != null && !_b1_control.equals(_b1_value)) {

                        t_jw_administrador_pedidos_periodos = new portalbr.dbobj.view.Jw_administrador_pedidos_periodos();
                        String[][] select = null;
                        Object[][] where = {{"ano","=", ano},{"mes","=",mes}};
                        res_Jw_administrador_pedidos_periodos = j.select(t_jw_administrador_pedidos_periodos,select,where,null,null,null);
                        %>
                        <tr class="reportHeader">
                          <td colspan="6">
                            <span class="columnTdHeader" style="text-align:right;" >
                              Mês:
                              <%= ((mes!=null)?mes.toString():"") %>
                            </span>
                          </td>
                        </tr>
                        <%
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:left;" >
                            Linha
                          </td>

                          <%
                          contador = 0;
                          while (contador <res_Jw_administrador_pedidos_periodos.size()) {
                            t_jw_administrador_pedidos_periodos = (portalbr.dbobj.view.Jw_administrador_pedidos_periodos)res_Jw_administrador_pedidos_periodos.elementAt(contador);
                            %>
                            <td class="columnTdHeader" style="text-align:center;" >
                              De
                              <%= com.egen.util.text.FormatDate.format(((java.sql.Date)t_jw_administrador_pedidos_periodos.getData_inicial()), "dd/MM/yyyy") %>
                              <br>
                              a
                              <%= com.egen.util.text.FormatDate.format(((java.sql.Date)t_jw_administrador_pedidos_periodos.getData_final()), "dd/MM/yyyy") %>
                            </td>

                            <%
                            contador ++;
                          }
                          %>

                        </tr>

                        <%
                      }
                      String style_bl_report_Jw_web_poi_filtro="";
                      if (!((i_bl_report_Jw_web_poi_filtro%2)!=0)) {
                        style_bl_report_Jw_web_poi_filtro="rowColor";
                      } else {
                        style_bl_report_Jw_web_poi_filtro="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_web_poi_filtro %>' id="TRbl_report_Jw_web_poi_filtro<%=i_bl_report_Jw_web_poi_filtro%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= lin_ref %>
                          -
                          <%= lin_nome %>
                        </td>


                        <%
                        contador = 0;
                        while (contador <res_Jw_administrador_pedidos_periodos.size()) {
                          t_jw_administrador_pedidos_periodos = (portalbr.dbobj.view.Jw_administrador_pedidos_periodos)res_Jw_administrador_pedidos_periodos.elementAt(contador);
                          %>
                          <td class="reportColumn" style="text-align:center;" >
                            <%
                            disponivel = administrador.getQuantidadeDisponivel(j, ano, mes, t_jw_administrador_pedidos_periodos.getPeriodo(), linha);
                            %>
                            <%
                            if(disponivel==0){
                              %>
                              <font color="gray">
                                <%= com.egen.util.text.FormatNumber.format(disponivel, "##,##0") %>
                              </font>
                              <%
                            } else {
                              %>
                              <%= com.egen.util.text.FormatNumber.format(disponivel, "##,##0") %>
                              <%
                            }
                            %>
                          </td>

                          <%
                          contador ++;
                        }
                        %>



                      </tr>

                      <%
                      _b0_control = _b0_value;
                      _b1_control = _b1_value;
                      i_bl_report_Jw_web_poi_filtro++;
                      if (i_bl_report_Jw_web_poi_filtro<res_Jw_web_poi_filtro.size()) {
                        t_jw_web_poi_filtro = (portalbr.dbobj.view.Jw_web_poi_filtro)res_Jw_web_poi_filtro.elementAt(i_bl_report_Jw_web_poi_filtro);
                        ano = t_jw_web_poi_filtro.getAno();
                        mes = t_jw_web_poi_filtro.getMes();
                        lin_ref = t_jw_web_poi_filtro.getLin_ref()==null?"":t_jw_web_poi_filtro.getLin_ref();
                        linha = t_jw_web_poi_filtro.getLinha();
                        ref_codigo = t_jw_web_poi_filtro.getRef_codigo()==null?"":t_jw_web_poi_filtro.getRef_codigo();
                        lin_nome = t_jw_web_poi_filtro.getLin_nome()==null?"":t_jw_web_poi_filtro.getLin_nome();
                        periodos = t_jw_web_poi_filtro.getPeriodos();
                        _b0_value = com.egen.util.text.FormatNumber.format(ano);
                        _b1_value = com.egen.util.text.FormatNumber.format(ano) + "_" + com.egen.util.text.FormatNumber.format(mes);
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
            } finally {
              if(j!=null){
                j.close();
              }
            }
            %>
            <html:form action="com/AdministradorPedidos_rsForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <html:hidden property="quebra"/>
                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:button accesskey="b" onclick="history.go(-1);" styleClass="baseButton" property="back_action">
                        <bean:message bundle="ApplicationResources" key="jsp.back"/>
                      </html:button>
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

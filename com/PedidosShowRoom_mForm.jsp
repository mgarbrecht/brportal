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
    <body>
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(190)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            com.egen.util.jdbc.JdbcUtil j = null;
            int idDiv = 0;
            String dia;
            try {
              j = new com.egen.util.jdbc.JdbcUtil();
              util.consultas.Query query = new util.consultas.Query();
              %>

              <%
              java.util.Vector res_Jw_acao_mkt_showroom = (java.util.Vector)session.getAttribute("res_Jw_acao_mkt_showroom");
              %>

              <form  name="bl_report_Jw_acao_mkt_showroom" id="bl_report_Jw_acao_mkt_showroom" class="baseForm" method="post" >
                <%
                if (res_Jw_acao_mkt_showroom!=null && res_Jw_acao_mkt_showroom.size()>0) {
                  %>

                  <%
                  java.lang.String auxData = null;
                  java.sql.Date dt_periodo_fim =  null;
                  java.sql.Date dt_periodo_ini =  null;
                  java.lang.Integer codigo_regional =  null;
                  java.lang.String nome_regional =  null;
                  java.lang.Integer id_showroom =  null;
                  java.lang.String evento =  null;
                  String _b0_control = "__";
                  String _b1_control = "__";
                  int i_bl_report_Jw_acao_mkt_showroom = 0;
                  while (i_bl_report_Jw_acao_mkt_showroom<res_Jw_acao_mkt_showroom.size()) {
                    portalbr.dbobj.view.Jw_acao_mkt_showroom t_jw_acao_mkt_showroom = (portalbr.dbobj.view.Jw_acao_mkt_showroom)res_Jw_acao_mkt_showroom.elementAt(i_bl_report_Jw_acao_mkt_showroom);
                    dt_periodo_fim = (java.sql.Date)t_jw_acao_mkt_showroom.getDt_periodo_fim();
                    dt_periodo_ini = (java.sql.Date)t_jw_acao_mkt_showroom.getDt_periodo_ini();
                    codigo_regional = t_jw_acao_mkt_showroom.getCodigo_regional();
                    nome_regional = t_jw_acao_mkt_showroom.getNome_regional()==null?"":t_jw_acao_mkt_showroom.getNome_regional();
                    id_showroom = t_jw_acao_mkt_showroom.getId_showroom();
                    evento = t_jw_acao_mkt_showroom.getEvento()==null?"":t_jw_acao_mkt_showroom.getEvento();
                    String _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional);
                    if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                      %>
                      <table id="TRbl_report_Jw_acao_mkt_showroom"  class="reportTable"   style="width:99%;" border=1;  >
                        <tr class="reportHeader3">
                          <td colspan="2">
                            <span class="columnTdHeader" style="text-align:right;" >
                              <big>
                                Regional :
                                <%= ((codigo_regional!=null)?codigo_regional.toString():"") %>
                                -
                                <%= nome_regional %>
                              </big>
                            </span>
                          </td>
                        </tr>
                        <%
                      }
                      String _b1_value = com.egen.util.text.FormatNumber.format(codigo_regional) + "_" + com.egen.util.text.FormatNumber.format(id_showroom);
                      if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                        %>

                        <tr class="reportHeader2">
                          <td colspan="2">
                            <span class="reportColumn" style="text-align:right;" >
                              Show Room :
                              <%= ((id_showroom!=null)?id_showroom.toString():"") %>
                              -
                              <%= evento %>
                            </span>
                          </td>
                        </tr>
                        <%
                        %>

                        <%
                      }
                      String style_bl_report_Jw_acao_mkt_showroom="";
                      if (!((i_bl_report_Jw_acao_mkt_showroom%2)!=0)) {
                        style_bl_report_Jw_acao_mkt_showroom="rowColor";
                      } else {
                        style_bl_report_Jw_acao_mkt_showroom="rowBlank";
                      }
                      %>


                      <tr class='<%= style_bl_report_Jw_acao_mkt_showroom %>' id="TRbl_report_Jw_acao_mkt_showroom<%=i_bl_report_Jw_acao_mkt_showroom%>" >
                        <td colspan="2">
                          <table border="1" width="100%">
                            <tr>

                              <%
                              int qtd_dias = Integer.parseInt(query.retorna(j, "SELECT TRUNC(to_date('"+com.egen.util.text.FormatDate.format(dt_periodo_fim, "dd/MM/yyyy")+"','dd/mm/yyyy')) - TRUNC(to_date('"+com.egen.util.text.FormatDate.format(dt_periodo_ini, "dd/MM/yyyy")+"','dd/mm/yyyy')) FROM dual"));
                              for(int x=0;x<=qtd_dias;x++){
                                %>
                                <td align="center">
                                  <b>
                                    <%= query.retorna(j,"SELECT to_char((TRUNC(to_date('"+com.egen.util.text.FormatDate.format(dt_periodo_ini, "dd/MM/yyyy")+"','dd/mm/yyyy')) + "+x+"),'dd/mm/yyyy') FROM dual") %>
                                  </b>
                                </td>
                                <%
                              }
                              %>
                            </td>
                          </tr>


                          <tr valign="top">
                            <%
                            for(int x=0;x<=qtd_dias;x++){
                              idDiv++;
                              %>
                              <td align="center">
                                <div id="<%= idDiv %>">
                                  <%= query.retorna(j, "SELECT nvl(replace(rowtocol('SELECT ped_nmro FROM brio.ped_inf_adicionais p WHERE p.id_showroom = "+id_showroom +" and p.dt_showroom = to_date(''"+query.retorna(j,"SELECT to_char((TRUNC(to_date('"+com.egen.util.text.FormatDate.format(dt_periodo_ini, "dd/MM/yyyy")+"','dd/mm/yyyy')) + "+x+"),'dd/mm/yyyy') FROM dual")+"'',''dd/mm/yyyy'')'),',','<br>'),'-') FROM dual") %>
                                </div>
                              </td>
                              <%
                            }
                            %>

                          </tr>

                          <tr valign="top">
                            <%
                            for(int x=0;x<=qtd_dias;x++){
                              %>
                              <td align="center">
                                <a href="#" onclick="window.open('../com/PedidosShowRoom_aForm.do?&select_action=&id_showroom=<%= id_showroom %>&dt_showroom=<%= query.retorna(j,"SELECT to_char((TRUNC(to_date('"+com.egen.util.text.FormatDate.format(dt_periodo_ini, "dd/MM/yyyy")+"','dd/mm/yyyy')) + "+x+"),'dd/mm/yyyy') FROM dual") %>','_blank','width:800px;height:200px')">
                                  <font color="gray">
                                    <small>
                                      Alterar Pedidos
                                    </small>
                                  </font>
                                </a>
                              </td>
                              <%
                            }
                            %>

                          </tr>




                        </table>
                      </td>
                    </tr>

                    <%
                    _b0_control = _b0_value;
                    _b1_control = _b1_value;
                    i_bl_report_Jw_acao_mkt_showroom++;
                    if (i_bl_report_Jw_acao_mkt_showroom<res_Jw_acao_mkt_showroom.size()) {
                      t_jw_acao_mkt_showroom = (portalbr.dbobj.view.Jw_acao_mkt_showroom)res_Jw_acao_mkt_showroom.elementAt(i_bl_report_Jw_acao_mkt_showroom);
                      dt_periodo_fim = (java.sql.Date)t_jw_acao_mkt_showroom.getDt_periodo_fim();
                      dt_periodo_ini = (java.sql.Date)t_jw_acao_mkt_showroom.getDt_periodo_ini();
                      codigo_regional = t_jw_acao_mkt_showroom.getCodigo_regional();
                      nome_regional = t_jw_acao_mkt_showroom.getNome_regional()==null?"":t_jw_acao_mkt_showroom.getNome_regional();
                      id_showroom = t_jw_acao_mkt_showroom.getId_showroom();
                      evento = t_jw_acao_mkt_showroom.getEvento()==null?"":t_jw_acao_mkt_showroom.getEvento();
                      _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional);
                      _b1_value = com.egen.util.text.FormatNumber.format(codigo_regional) + "_" + com.egen.util.text.FormatNumber.format(id_showroom);
                    } else {
                      _b0_control = "__";
                      _b1_control = "__";
                    }
                  }
                  %>

                </table>
                <br>
                <br>
                <br>
                <br>
                <br>

                <%
              }
              %>

            </form>
            <%
          } finally {
            if (j != null) {
              j.close();
            }
          }
          %>
          <html:form action="com/PedidosShowRoom_mForm.do" method="post" styleClass="baseForm">


            <table >
              <tr >
                <td >
                  <html:submit styleClass="myhidden" property="refresh_action">
                    <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
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

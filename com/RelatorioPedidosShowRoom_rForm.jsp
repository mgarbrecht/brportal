<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Relatório de Vendas em Show Room
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
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(191)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            com.egen.util.jdbc.JdbcUtil j = null;
            int qtd_dias = 0;
            try {
              j = new com.egen.util.jdbc.JdbcUtil();
              util.consultas.Query query = new util.consultas.Query();
              %>
              <%
              java.util.Vector res_Jw_acao_mkt_relatorio_showroom = (java.util.Vector)session.getAttribute("res_Jw_acao_mkt_relatorio_showroom");
              %>

              <form  name="bl_report_Jw_acao_mkt_relatorio_showroom" id="bl_report_Jw_acao_mkt_relatorio_showroom" class="baseForm" method="post" >
                <%
                if (res_Jw_acao_mkt_relatorio_showroom!=null && res_Jw_acao_mkt_relatorio_showroom.size()>0) {
                  %>
                  <%
                  java.lang.Integer codigo_regional =  null;
                  java.lang.String nome_regional =  null;
                  java.lang.Integer id_showroom =  null;
                  java.lang.Integer id_showroom_atual =  null;
                  java.lang.String evento =  null;
                  java.lang.Integer mun_codigo =  null;
                  java.lang.String mun_nome =  null;
                  java.lang.String est_unifed =  null;
                  java.lang.String est_descricao =  null;
                  java.lang.Integer est_pais_codigo =  null;
                  java.lang.String pais_nome =  null;
                  java.sql.Date dt_periodo_ini =  null;
                  java.sql.Date dt_periodo_fim =  null;
                  java.lang.String rep_cdgo =  null;
                  java.lang.String rep_rzao =  null;
                  java.lang.Integer codigo_marca =  null;
                  java.lang.String descricao_marca =  null;
                  java.lang.Integer clientes_atendidos =  null;
                  java.lang.Integer pares =  null;
                  String _b0_control = "__";
                  String _b1_control = "__";
                  int sum_pares_0 = 0;
                  int sum_pares_1 = 0;
                  int i_bl_report_Jw_acao_mkt_relatorio_showroom = 0;
                  while (i_bl_report_Jw_acao_mkt_relatorio_showroom<res_Jw_acao_mkt_relatorio_showroom.size()) {
                    portalbr.dbobj.view.Jw_acao_mkt_relatorio_showroom t_jw_acao_mkt_relatorio_showroom = (portalbr.dbobj.view.Jw_acao_mkt_relatorio_showroom)res_Jw_acao_mkt_relatorio_showroom.elementAt(i_bl_report_Jw_acao_mkt_relatorio_showroom);
                    codigo_regional = t_jw_acao_mkt_relatorio_showroom.getCodigo_regional();
                    nome_regional = t_jw_acao_mkt_relatorio_showroom.getNome_regional()==null?"":t_jw_acao_mkt_relatorio_showroom.getNome_regional();
                    id_showroom = t_jw_acao_mkt_relatorio_showroom.getId_showroom();
                    id_showroom_atual = id_showroom;
                    evento = t_jw_acao_mkt_relatorio_showroom.getEvento()==null?"":t_jw_acao_mkt_relatorio_showroom.getEvento();
                    mun_codigo = t_jw_acao_mkt_relatorio_showroom.getMun_codigo();
                    mun_nome = t_jw_acao_mkt_relatorio_showroom.getMun_nome()==null?"":t_jw_acao_mkt_relatorio_showroom.getMun_nome();
                    est_unifed = t_jw_acao_mkt_relatorio_showroom.getEst_unifed()==null?"":t_jw_acao_mkt_relatorio_showroom.getEst_unifed();
                    est_descricao = t_jw_acao_mkt_relatorio_showroom.getEst_descricao()==null?"":t_jw_acao_mkt_relatorio_showroom.getEst_descricao();
                    est_pais_codigo = t_jw_acao_mkt_relatorio_showroom.getEst_pais_codigo();
                    pais_nome = t_jw_acao_mkt_relatorio_showroom.getPais_nome()==null?"":t_jw_acao_mkt_relatorio_showroom.getPais_nome();
                    dt_periodo_ini = (java.sql.Date)t_jw_acao_mkt_relatorio_showroom.getDt_periodo_ini();
                    dt_periodo_fim = (java.sql.Date)t_jw_acao_mkt_relatorio_showroom.getDt_periodo_fim();
                    rep_cdgo = t_jw_acao_mkt_relatorio_showroom.getRep_cdgo()==null?"":t_jw_acao_mkt_relatorio_showroom.getRep_cdgo();
                    rep_rzao = t_jw_acao_mkt_relatorio_showroom.getRep_rzao()==null?"":t_jw_acao_mkt_relatorio_showroom.getRep_rzao();
                    codigo_marca = t_jw_acao_mkt_relatorio_showroom.getCodigo_marca();
                    descricao_marca = t_jw_acao_mkt_relatorio_showroom.getDescricao_marca()==null?"":t_jw_acao_mkt_relatorio_showroom.getDescricao_marca();
                    clientes_atendidos = t_jw_acao_mkt_relatorio_showroom.getClientes_atendidos();
                    pares = t_jw_acao_mkt_relatorio_showroom.getPares();
                    sum_pares_0 += ((pares!=null)?pares.intValue():0);
                    sum_pares_1 += ((pares!=null)?pares.intValue():0);
                    String _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional);
                    if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                      %>
                      <table id="TRbl_report_Jw_acao_mkt_relatorio_showroom"  class="reportTable"   style="width:99%; "  border="1" >
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
                        <tr class="reportHeader">
                          <td>
                            <span class="columnTdHeader" style="text-align:right;" >
                              ShowRoom :
                              <%= ((id_showroom!=null)?id_showroom.toString():"") %>
                              -
                              <%= evento %>
                            </span>
                          </td>
                          <td>
                            <span class="columnTdHeader" style="text-align:left;" >
                              <%= mun_nome %>
                              -
                              <%= est_unifed %>
                            </span>
                            <span class="columnTdHeader" style="text-align:center;" >
                              de
                              <%= com.egen.util.text.FormatDate.format(dt_periodo_ini, "dd/MM/yyyy") %>
                              a
                              <%= com.egen.util.text.FormatDate.format(dt_periodo_fim, "dd/MM/yyyy") %>
                            </span>
                          </td>
                        </tr>
                        <%
                        %>
                      </table>
                      <table id="TRbl_report_Jw_acao_mkt_relatorio_showroom"  class="reportTable"   style="width:99%; "  border="1" >
                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:left;" >
                            Representante
                          </td>

                          <td class="columnTdHeader" style="text-align:center;" width="1%" >
                            Marca
                          </td>

                          <td class="columnTdHeader" style="text-align:center;" width="1%" >
                            Clientes Atendidos
                          </td>

                          <%
                          qtd_dias = Integer.parseInt(query.retorna(j, "SELECT TRUNC(to_date('"+com.egen.util.text.FormatDate.format(dt_periodo_fim, "dd/MM/yyyy")+"','dd/mm/yyyy')) - TRUNC(to_date('"+com.egen.util.text.FormatDate.format(dt_periodo_ini, "dd/MM/yyyy")+"','dd/mm/yyyy')) FROM dual"));
                          %>

                          <%
                          for(int x=0;x<=qtd_dias;x++){
                            %>
                            <td class="columnTdHeader" style="text-align:center;" >
                              <small>
                                <%= query.retorna(j,"SELECT to_char((TRUNC(to_date('"+com.egen.util.text.FormatDate.format(dt_periodo_ini, "dd/MM/yyyy")+"','dd/mm/yyyy')) + "+x+"),'dd/mm/yyyy') FROM dual") %>
                              </small>
                            </td>
                            <%
                          }
                          %>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Total
                          </td>

                        </tr>


                        <%
                      }
                      String style_bl_report_Jw_acao_mkt_relatorio_showroom="";
                      if (!((i_bl_report_Jw_acao_mkt_relatorio_showroom%2)!=0)) {
                        style_bl_report_Jw_acao_mkt_relatorio_showroom="rowColor";
                      } else {
                        style_bl_report_Jw_acao_mkt_relatorio_showroom="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_acao_mkt_relatorio_showroom %>' id="TRbl_report_Jw_acao_mkt_relatorio_showroom<%=i_bl_report_Jw_acao_mkt_relatorio_showroom%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= rep_cdgo %>
                          -
                          <%= rep_rzao %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= descricao_marca %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= ((clientes_atendidos!=null)?clientes_atendidos.toString():"") %>
                        </td>

                        <%
                        for(int x=0;x<=qtd_dias;x++){
                          %>
                          <td class="reportColumn" style="text-align:center;" >
                            <%= query.retorna(j, "SELECT nvl(sum(pck_pedidos.get_pares(p.ped_nmro)),'') pares FROM brio.ped_inf_adicionais p, brio.acao_mkt_showroom a WHERE p.dt_showroom IS NOT NULL AND p.id_showroom = "+id_showroom+" AND a.id_showroom = p.id_showroom AND pck_pedidos.get_rep(p.ped_nmro) = "+rep_cdgo+"  AND dt_showroom-a.dt_periodo_ini = "+x + " HAVING sum(pck_pedidos.get_pares(p.ped_nmro)) >0") %>
                          </td>
                          <%
                        }
                        %>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((pares!=null)?pares.toString():"") %>
                        </td>

                      </tr>
                      <%
                      _b0_control = _b0_value;
                      _b1_control = _b1_value;
                      i_bl_report_Jw_acao_mkt_relatorio_showroom++;
                      if (i_bl_report_Jw_acao_mkt_relatorio_showroom<res_Jw_acao_mkt_relatorio_showroom.size()) {
                        t_jw_acao_mkt_relatorio_showroom = (portalbr.dbobj.view.Jw_acao_mkt_relatorio_showroom)res_Jw_acao_mkt_relatorio_showroom.elementAt(i_bl_report_Jw_acao_mkt_relatorio_showroom);
                        codigo_regional = t_jw_acao_mkt_relatorio_showroom.getCodigo_regional();
                        nome_regional = t_jw_acao_mkt_relatorio_showroom.getNome_regional()==null?"":t_jw_acao_mkt_relatorio_showroom.getNome_regional();
                        id_showroom = t_jw_acao_mkt_relatorio_showroom.getId_showroom();
                        evento = t_jw_acao_mkt_relatorio_showroom.getEvento()==null?"":t_jw_acao_mkt_relatorio_showroom.getEvento();
                        mun_codigo = t_jw_acao_mkt_relatorio_showroom.getMun_codigo();
                        mun_nome = t_jw_acao_mkt_relatorio_showroom.getMun_nome()==null?"":t_jw_acao_mkt_relatorio_showroom.getMun_nome();
                        est_unifed = t_jw_acao_mkt_relatorio_showroom.getEst_unifed()==null?"":t_jw_acao_mkt_relatorio_showroom.getEst_unifed();
                        est_descricao = t_jw_acao_mkt_relatorio_showroom.getEst_descricao()==null?"":t_jw_acao_mkt_relatorio_showroom.getEst_descricao();
                        est_pais_codigo = t_jw_acao_mkt_relatorio_showroom.getEst_pais_codigo();
                        pais_nome = t_jw_acao_mkt_relatorio_showroom.getPais_nome()==null?"":t_jw_acao_mkt_relatorio_showroom.getPais_nome();
                        dt_periodo_ini = (java.sql.Date)t_jw_acao_mkt_relatorio_showroom.getDt_periodo_ini();
                        dt_periodo_fim = (java.sql.Date)t_jw_acao_mkt_relatorio_showroom.getDt_periodo_fim();
                        rep_cdgo = t_jw_acao_mkt_relatorio_showroom.getRep_cdgo()==null?"":t_jw_acao_mkt_relatorio_showroom.getRep_cdgo();
                        rep_rzao = t_jw_acao_mkt_relatorio_showroom.getRep_rzao()==null?"":t_jw_acao_mkt_relatorio_showroom.getRep_rzao();
                        codigo_marca = t_jw_acao_mkt_relatorio_showroom.getCodigo_marca();
                        descricao_marca = t_jw_acao_mkt_relatorio_showroom.getDescricao_marca()==null?"":t_jw_acao_mkt_relatorio_showroom.getDescricao_marca();
                        clientes_atendidos = t_jw_acao_mkt_relatorio_showroom.getClientes_atendidos();
                        pares = t_jw_acao_mkt_relatorio_showroom.getPares();
                        _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional);
                        _b1_value = com.egen.util.text.FormatNumber.format(codigo_regional) + "_" + com.egen.util.text.FormatNumber.format(id_showroom);
                      } else {
                        _b0_control = "__";
                        _b1_control = "__";
                      }
                      if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                        %>
                        <tr class="totalColumn" >
                          <td colspan="<%= qtd_dias+4 %>" style="text-align:right;">
                            <b>
                              Total :
                            </b>
                          </td>

                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= sum_pares_1 + "" %>
                            </b>
                          </td>
                        </tr>

                        <%
                        sum_pares_1 = 0;
                      }
                    }
                    %>
                    <tr class="totalColumn">
                      <td colspan="<%= qtd_dias+4 %> " style="text-align:right;">
                        <b>
                          Total Geral:
                        </b>
                      </td>

                    </td>
                    <td class="totalTdColumn"  style="text-align:right;" >
                      <b>
                        <%= sum_pares_0 + "" %>
                      </b>
                    </td>
                  </tr>

                  <%
                  %>

                </table>

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

          <html:form action="com/RelatorioPedidosShowRoom_rForm.do" method="post" styleClass="baseForm">
            <table class="messageTable" style='width:99%;'>
              <tr class="messageTr" >
                <td class="messageTd">
                </td>
              </tr>
            </table>

            <table class="buttonTable" style='width:99%;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <%
                  if(!(request.getParameter("excel")+"").equals("true")){
                    %>
                    <html:submit accesskey="a" styleClass="baseButton" property="back_action">
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

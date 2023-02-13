<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta de Pedidos Fora das Normas
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(74)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Jw_pedidos_fora_normas" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_pedidos_fora_normas=0;
              {
                portalbr.dbobj.view.Jw_pedidos_fora_normas t_jw_pedidos_fora_normas = new portalbr.dbobj.view.Jw_pedidos_fora_normas();
                java.util.Vector res_Jw_pedidos_fora_normas = (java.util.Vector)session.getAttribute("res_Jw_pedidos_fora_normas");
                if (res_Jw_pedidos_fora_normas!=null && res_Jw_pedidos_fora_normas.size()>0) {
                  java.lang.String ped_nmro      =  null;
                  java.lang.String ped_rep       =  null;
                  java.lang.String rep_codigo    =  null;
                  java.lang.String ped_stat      =  null;
                  java.lang.String ped_stat_real =  null;
                  java.sql.Timestamp ped_data    =  null;
                  java.sql.Timestamp ped_det     =  null;
                  java.sql.Timestamp ped_emb     =  null;
                  java.lang.String cod_lin       =  null;
                  java.lang.String nome_lin      =  null;
                  java.lang.String nome_linha    =  null;
                  int i_bl_report_Jw_pedidos_fora_normas = 0;

                  t_jw_pedidos_fora_normas = (portalbr.dbobj.view.Jw_pedidos_fora_normas)res_Jw_pedidos_fora_normas.elementAt(i_bl_report_Jw_pedidos_fora_normas);
                  ped_nmro      = t_jw_pedidos_fora_normas.getPed_nmro()==null?"":t_jw_pedidos_fora_normas.getPed_nmro();
                  ped_rep       = t_jw_pedidos_fora_normas.getPed_rep()==null?"":t_jw_pedidos_fora_normas.getPed_rep();
                  rep_codigo    = t_jw_pedidos_fora_normas.getRep_codigo()==null?"":t_jw_pedidos_fora_normas.getRep_codigo();
                  ped_stat      = t_jw_pedidos_fora_normas.getPed_stat()==null?"":t_jw_pedidos_fora_normas.getPed_stat();
                  ped_stat_real = t_jw_pedidos_fora_normas.getPed_stat_real()==null?"":t_jw_pedidos_fora_normas.getPed_stat_real();
                  ped_data      = (java.sql.Timestamp)t_jw_pedidos_fora_normas.getPed_data();
                  ped_det       = (java.sql.Timestamp)t_jw_pedidos_fora_normas.getPed_det();
                  ped_emb       = (java.sql.Timestamp)t_jw_pedidos_fora_normas.getPed_emb();
                  cod_lin       = t_jw_pedidos_fora_normas.getCod_lin()==null?"":t_jw_pedidos_fora_normas.getCod_lin();
                  nome_lin      = t_jw_pedidos_fora_normas.getNome_lin()==null?"":t_jw_pedidos_fora_normas.getNome_lin();
                  nome_linha    = cod_lin +" - "+nome_lin;
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:center;">
                      Pedido
                      <br>
                      Beira Rio
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Pedido
                      <br>
                      Cliente
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Rep.
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Status
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Status
                      <br>
                      Real
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Data
                      <br>
                      Digitação
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Data
                      <br>
                      Entrega
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Data
                      <br>
                      Embarque
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Nome da Linha
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Jw_pedidos_fora_normas<res_Jw_pedidos_fora_normas.size()){
                    counterbl_report_Jw_pedidos_fora_normas++;
                    String style="";
                    if (!((i_bl_report_Jw_pedidos_fora_normas%2)!=0)) {
                      style="class=rowColor";
                    } else {
                      style="class=rowBlank";
                    }
                    %>
                    <tr <%= style %> id='TRbl_report_Jw_pedidos_fora_normas<%=counterbl_report_Jw_pedidos_fora_normas%>' >
                      <td title="Itens do Pedido: <%= ped_nmro %>" class="reportColumn" style="text-align:center;">
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <a href="../com/ConsultaPedidos_iForm.do?select_action=&pedido_beira_rio=<%= ped_nmro %>" target="_self" STYLE="cursor:hand">
                            <%= ped_nmro %>
                          </a>
                          <%
                        } else {
                          %>
                          <%= ped_nmro %>
                          <%
                        }
                        %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= ped_rep %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= rep_codigo %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= ped_stat %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= ped_stat_real %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= com.egen.util.text.FormatDate.format(ped_data, "dd/MM/yyyy") %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= com.egen.util.text.FormatDate.format(ped_det, "dd/MM/yyyy") %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= com.egen.util.text.FormatDate.format(ped_emb, "dd/MM/yyyy") %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= nome_linha %>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Jw_pedidos_fora_normas >= res_Jw_pedidos_fora_normas.size()) {
                      break;
                    }
                    t_jw_pedidos_fora_normas = (portalbr.dbobj.view.Jw_pedidos_fora_normas)res_Jw_pedidos_fora_normas.elementAt(i_bl_report_Jw_pedidos_fora_normas);
                    ped_nmro      = t_jw_pedidos_fora_normas.getPed_nmro()==null?"":t_jw_pedidos_fora_normas.getPed_nmro();
                    ped_rep       = t_jw_pedidos_fora_normas.getPed_rep()==null?"":t_jw_pedidos_fora_normas.getPed_rep();
                    rep_codigo    = t_jw_pedidos_fora_normas.getRep_codigo()==null?"":t_jw_pedidos_fora_normas.getRep_codigo();
                    ped_stat      = t_jw_pedidos_fora_normas.getPed_stat()==null?"":t_jw_pedidos_fora_normas.getPed_stat();
                    ped_stat_real = t_jw_pedidos_fora_normas.getPed_stat_real()==null?"":t_jw_pedidos_fora_normas.getPed_stat_real();
                    ped_data      = (java.sql.Timestamp)t_jw_pedidos_fora_normas.getPed_data();
                    ped_det       = (java.sql.Timestamp)t_jw_pedidos_fora_normas.getPed_det();
                    ped_emb       = (java.sql.Timestamp)t_jw_pedidos_fora_normas.getPed_emb();
                    cod_lin       = t_jw_pedidos_fora_normas.getCod_lin()==null?"":t_jw_pedidos_fora_normas.getCod_lin();
                    nome_lin      = t_jw_pedidos_fora_normas.getNome_lin()==null?"":t_jw_pedidos_fora_normas.getNome_lin();
                    nome_linha    = cod_lin +" - "+nome_lin;
                  }
                }
              }
              %>
            </table>
            <html:form action="com/ConsultaPedidosForaNormas_rForm.do" method="post" styleClass="baseForm">
              <table class="buttonTable" style='width:;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <%
                    if(!(request.getParameter("excel")+"").equals("true")){
                      %>
                      <html:submit styleClass="baseButton" property="back_action">
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

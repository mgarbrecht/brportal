<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta de Pedidos Bloqueados - Crédito
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

            <b>
              <big>
                Período:
                <%= session.getAttribute("parametro1") %>
                à
                <%= session.getAttribute("parametro2") %>
              </big>
            </b>
            <%
            int counterbl_report_Jw_pedidos_bloqueados=0;
            {
              portalbr.dbobj.view.Jw_pedidos_bloqueados t_jw_pedidos_bloqueados = new portalbr.dbobj.view.Jw_pedidos_bloqueados();
              java.util.Vector res_Jw_pedidos_bloqueados = (java.util.Vector)session.getAttribute("res_Jw_pedidos_bloqueados");
              if (res_Jw_pedidos_bloqueados!=null && res_Jw_pedidos_bloqueados.size()>0) {
                java.lang.String representante        =  null;
                java.sql.Timestamp entrega            =  null;
                java.lang.String digitacao            =  null;
                java.lang.String cli_cdgo             =  null;
                java.lang.String cli_rzao             =  null;
                java.lang.String ped_nmro             =  null;
                java.lang.String tipo                 =  null;
                java.lang.String ped_nped             =  null;
                java.lang.String b0_representante     =  null;
                int i_bl_report_Jw_pedidos_bloqueados = 0;

                t_jw_pedidos_bloqueados = (portalbr.dbobj.view.Jw_pedidos_bloqueados)res_Jw_pedidos_bloqueados.elementAt(i_bl_report_Jw_pedidos_bloqueados);
                representante = t_jw_pedidos_bloqueados.getRepresentante()==null?"":t_jw_pedidos_bloqueados.getRepresentante();
                entrega       = (java.sql.Timestamp)t_jw_pedidos_bloqueados.getEntrega();
                digitacao     = t_jw_pedidos_bloqueados.getDigitacao()==null?"":t_jw_pedidos_bloqueados.getDigitacao();
                cli_cdgo      = t_jw_pedidos_bloqueados.getCli_cdgo()==null?"":t_jw_pedidos_bloqueados.getCli_cdgo();
                cli_rzao      = t_jw_pedidos_bloqueados.getCli_rzao()==null?"":t_jw_pedidos_bloqueados.getCli_rzao();
                ped_nmro      = t_jw_pedidos_bloqueados.getPed_nmro()==null?"":t_jw_pedidos_bloqueados.getPed_nmro();
                tipo          = t_jw_pedidos_bloqueados.getTipo()==null?"":t_jw_pedidos_bloqueados.getTipo();
                ped_nped      = t_jw_pedidos_bloqueados.getPed_nped()==null?"":t_jw_pedidos_bloqueados.getPed_nped();

                while (i_bl_report_Jw_pedidos_bloqueados<res_Jw_pedidos_bloqueados.size()){
                  counterbl_report_Jw_pedidos_bloqueados++;
                  %>
                  <table id="TRbl_report_Jw_pedidos_bloqueados" class="reportTable" style=width:99%;  border=1  frame=box>
                    <tr class="reportHeader2" >
                      <td colspan=7>
                        <%= representante %>
                      </td>
                    </tr>
                    <%
                    b0_representante = representante;
                    %>
                    <tr class="reportHeader" >
                      <td class="columnTdHeader" style="text-align:center;">
                        Entrega
                      </td>
                      <td class="columnTdHeader" style="text-align:center;">
                        Digitação
                      </td>
                      <td class="columnTdHeader" style="text-align:center;">
                        Cliente
                      </td>
                      <td class="columnTdHeader" style="text-align:left;">
                        Razão Social
                      </td>
                      <td class="columnTdHeader" style="text-align:center;">
                        Pedido
                      </td>
                      <td class="columnTdHeader" style="text-align:center;">
                        Tipo
                      </td>
                      <td class="columnTdHeader" style="text-align:center;">
                        Ped. Cli.
                      </td>
                    </tr>
                    <%
                    while (i_bl_report_Jw_pedidos_bloqueados<res_Jw_pedidos_bloqueados.size() &&  (b0_representante==null?"":b0_representante).equals((representante==null?"":representante))){
                      counterbl_report_Jw_pedidos_bloqueados++;
                      String style="";
                      if (!((i_bl_report_Jw_pedidos_bloqueados%2)!=0)) {
                        style="rowColor";
                      } else {
                        style="rowBlank";
                      }
                      %>
                      <tr class=<%= style %> id='TRbl_report_Jw_pedidos_bloqueados<%=counterbl_report_Jw_pedidos_bloqueados%>' >
                        <td class="reportColumn" style="text-align:center;width:100;">
                          <%= com.egen.util.text.FormatDate.format(entrega, "dd/MM/yyyy") %>
                        </td>
                        <td class="reportColumn" style="text-align:center;width:100;">
                          <%= digitacao %>
                        </td>
                        <td title="Análise de Crédito do Cliente: <%= cli_rzao %>" class="reportColumn" style="text-align:center;width:80;">
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <a href="../adm/AnaliseCreditoForm.do?resetfull=&cli_cdgo=<%= cli_cdgo %>" target="_self" STYLE="cursor:hand">
                              <%= cli_cdgo %>
                            </a>
                            <%
                          } else {
                            %>
                            <%= cli_cdgo %>
                            <%
                          }
                          %>
                        </td>
                        <td class="reportColumn" style="text-align:left;width:400;">
                          <%= cli_rzao %>
                        </td>
                        <td title="Itens do Pedido: <%= ped_nmro %>" class="reportColumn" style="text-align:center;width:100;">
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <a href="../com/ConsultaPedidos_iForm.do?select_action=&pedido_beira_rio=<%= ped_nmro %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
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
                        <td class="reportColumn" style="text-align:center;width:100;">
                          <%= tipo %>
                        </td>
                        <td class="reportColumn" style="text-align:center;width:100;">
                          <%= ped_nped %>
                        </td>
                      </tr>
                      <%
                      if (++i_bl_report_Jw_pedidos_bloqueados >= res_Jw_pedidos_bloqueados.size()) {
                        break;
                      }
                      t_jw_pedidos_bloqueados = (portalbr.dbobj.view.Jw_pedidos_bloqueados)res_Jw_pedidos_bloqueados.elementAt(i_bl_report_Jw_pedidos_bloqueados);
                      representante = t_jw_pedidos_bloqueados.getRepresentante()==null?"":t_jw_pedidos_bloqueados.getRepresentante();
                      entrega       = (java.sql.Timestamp)t_jw_pedidos_bloqueados.getEntrega();
                      digitacao     = t_jw_pedidos_bloqueados.getDigitacao()==null?"":t_jw_pedidos_bloqueados.getDigitacao();
                      cli_cdgo      = t_jw_pedidos_bloqueados.getCli_cdgo()==null?"":t_jw_pedidos_bloqueados.getCli_cdgo();
                      cli_rzao      = t_jw_pedidos_bloqueados.getCli_rzao()==null?"":t_jw_pedidos_bloqueados.getCli_rzao();
                      ped_nmro      = t_jw_pedidos_bloqueados.getPed_nmro()==null?"":t_jw_pedidos_bloqueados.getPed_nmro();
                      tipo          = t_jw_pedidos_bloqueados.getTipo()==null?"":t_jw_pedidos_bloqueados.getTipo();
                      ped_nped      = t_jw_pedidos_bloqueados.getPed_nped()==null?"":t_jw_pedidos_bloqueados.getPed_nped();
                    }
                  }
                }
              }
              %>
            </table>
            <html:form action="adm/PedidosBloqueados_rForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <html:hidden property="dt_final"/>
                <html:hidden property="dt_inicial"/>
                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <html:submit onclick="history.go(-1);" styleClass="myhidden" property="back_action">
                          <bean:message bundle="ApplicationResources" key="jsp.back"/>
                        </html:submit>
                        <%
                      }
                      %>
                      <html:button onclick="history.go(-1);" styleClass="baseButton" property="back1_action">
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

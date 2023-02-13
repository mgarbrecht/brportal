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
            //------------------------------------------------------------------------------------------
            // Autor             : Mateus Garbrecht (TechnoCorp)
            // Data de Criação   : 12/04/2006
            // Objetivo          : Relatório que mostra os registros retornados pela consulta da tela:
            //                     /com/AdministradorPedidosForm.jsp
            //------------------------------------------------------------------------------------------
            // Data de Alteração :
            // Descrição         :
            //------------------------------------------------------------------------------------------
            %>
            <table id="TRbl_report_Jw_web_poi" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_web_poi=0;
              {
                portalbr.dbobj.view.Jw_web_poi t_jw_web_poi = new portalbr.dbobj.view.Jw_web_poi();
                java.util.Vector res_Jw_web_poi = (java.util.Vector)session.getAttribute("res_Jw_web_poi");
                if (res_Jw_web_poi!=null && res_Jw_web_poi.size()>0) {
                  java.lang.String lin_ref              =  null;
                  java.lang.String linha                =  null;
                  java.lang.String lin_nome             =  null;
                  java.lang.String mes_ano_venda        =  null;
                  java.lang.String mes_ano_venda_format =  null;
                  java.lang.String dt                   =  null;
                  java.lang.String ref_codigo           =  null;
                  double total_pares_venda              =  0;
                  double capacidade                     =  0;
                  double vendas                         =  0;
                  double disponivel                     =  0;
                  double pares_ret_credito              =  0;
                  int i_bl_report_Jw_web_poi            =  0;
                  java.sql.Date data_inicial            =  null;
                  java.sql.Date data_final              =  null;
                  t_jw_web_poi = (portalbr.dbobj.view.Jw_web_poi)res_Jw_web_poi.elementAt(i_bl_report_Jw_web_poi);
                  lin_ref           = t_jw_web_poi.getLin_ref()==null?"":t_jw_web_poi.getLin_ref();
                  linha             = t_jw_web_poi.getLinha()==null?"":t_jw_web_poi.getLinha();
                  lin_nome          = t_jw_web_poi.getLin_nome()==null?"":t_jw_web_poi.getLin_nome();
                  mes_ano_venda     = t_jw_web_poi.getMes_ano_venda()==null?"":t_jw_web_poi.getMes_ano_venda();
                  ref_codigo        = t_jw_web_poi.getRef_codigo();
                  total_pares_venda = t_jw_web_poi.getTotal_pares_venda();
                  capacidade        = t_jw_web_poi.getCapacidade();
                  vendas            = t_jw_web_poi.getVendas();
                  disponivel        = t_jw_web_poi.getDisponivel();
                  pares_ret_credito = t_jw_web_poi.getPares_ret_credito();
                  data_inicial      = (java.sql.Date)t_jw_web_poi.getData_inicial();
                  data_final        = (java.sql.Date)t_jw_web_poi.getData_final();

                  //-----------------------------------------------
                  if(Integer.parseInt(mes_ano_venda.substring(2,4))>90){
                    mes_ano_venda_format = (mes_ano_venda.substring(0,2)+"/19"+mes_ano_venda.substring(2,4));
                  } else {
                    mes_ano_venda_format = (mes_ano_venda.substring(0,2)+"/20"+mes_ano_venda.substring(2,4));
                  }
                  //-----------------------------------------------
                  dt="01/"+mes_ano_venda_format;
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:left;">
                      Código
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Nome
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Período
                    </td>
                    <td class="columnTdHeader" style="text-align:right;">
                      Capacidade
                    </td>
                    <td class="columnTdHeader" style="text-align:right;">
                      Vendido
                    </td>
                    <td class="columnTdHeader" style="text-align:right;">
                      Disponível
                    </td>
                    <td class="columnTdHeader" style="text-align:right;">
                      Bloq. Crédito
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Jw_web_poi<res_Jw_web_poi.size()){
                    counterbl_report_Jw_web_poi++;
                    String style="";
                    if (!((i_bl_report_Jw_web_poi%2)!=0)) {
                      style="rowColor";
                    } else {
                      style="rowBlank";
                    }
                    %>
                    <tr class=<%= style %> id='TRbl_report_Jw_web_poi<%=counterbl_report_Jw_web_poi%>' >
                      <td class="reportColumn" style="text-align:left;">
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <a href="../com/AdministradorPedidos_dForm.do?select_action=&linha=<%= linha %>&ref_cdgo=<%= ref_codigo %>&dt=<%= dt %>&data=<%= mes_ano_venda_format %>&prev=<%= com.egen.util.text.FormatNumber.format(total_pares_venda, "##,##0.00") %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                            <%= lin_ref %>
                          </a>
                          <%
                        } else {
                          %>
                          <%= lin_ref %>
                          <%
                        }
                        %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= lin_nome %>
                      </td>

                      <td class="reportColumn" style="text-align:center;">
                        <%= com.egen.util.text.FormatDate.format(data_inicial, "dd/MM/yyyy") %>
                        a
                        <%= com.egen.util.text.FormatDate.format(data_final, "dd/MM/yyyy") %>
                      </td>


                      <td class="reportColumn" style="text-align:right;">
                        <%= com.egen.util.text.FormatNumber.format(capacidade, "##,##0") %>
                      </td>
                      <td class="reportColumn" style="text-align:right;">
                        <%= com.egen.util.text.FormatNumber.format(vendas, "##,##0") %>
                      </td>
                      <td class="reportColumn" style="text-align:right;">
                        <%= com.egen.util.text.FormatNumber.format(disponivel, "##,##0") %>
                      </td>
                      <td class="reportColumn" style="text-align:right;">
                        <%= com.egen.util.text.FormatNumber.format(pares_ret_credito, "##,##0.00") %>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Jw_web_poi >= res_Jw_web_poi.size()) {
                      break;
                    }
                    t_jw_web_poi = (portalbr.dbobj.view.Jw_web_poi)res_Jw_web_poi.elementAt(i_bl_report_Jw_web_poi);
                    lin_ref           = t_jw_web_poi.getLin_ref()==null?"":t_jw_web_poi.getLin_ref();
                    linha             = t_jw_web_poi.getLinha()==null?"":t_jw_web_poi.getLinha();
                    lin_nome          = t_jw_web_poi.getLin_nome()==null?"":t_jw_web_poi.getLin_nome();
                    mes_ano_venda     = t_jw_web_poi.getMes_ano_venda()==null?"":t_jw_web_poi.getMes_ano_venda();
                    ref_codigo        = t_jw_web_poi.getRef_codigo();
                    total_pares_venda = t_jw_web_poi.getTotal_pares_venda();
                    capacidade        = t_jw_web_poi.getCapacidade();
                    vendas            = t_jw_web_poi.getVendas();
                    disponivel        = t_jw_web_poi.getDisponivel();
                    pares_ret_credito = t_jw_web_poi.getPares_ret_credito();
                    data_inicial      = (java.sql.Date)t_jw_web_poi.getData_inicial();
                    data_final        = (java.sql.Date)t_jw_web_poi.getData_final();

                    //-----------------------------------------------
                    if(Integer.parseInt(mes_ano_venda.substring(2,4))>90){
                      mes_ano_venda_format = (mes_ano_venda.substring(0,2)+"/19"+mes_ano_venda.substring(2,4));
                    } else {
                      mes_ano_venda_format = (mes_ano_venda.substring(0,2)+"/20"+mes_ano_venda.substring(2,4));
                    }
                    dt="01/"+mes_ano_venda_format;
                    //-----------------------------------------------
                  }
                }
              }
              %>
            </table>
            <html:form action="com/AdministradorPedidos_rForm.do" method="post" styleClass="baseForm">
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

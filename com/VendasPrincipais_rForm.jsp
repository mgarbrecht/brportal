<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Vendas Principais Clientes
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
            //---------------------------------------------------------------------------------------
            // Autor             : Mateus Garbrecht (TechnoCorp)
            // Data de Criação   : 06/03/2006
            // Objetivo          : Relatório com as vendas principais / clientes
            //----------------------------------------------------------------------------------------
            // Data de Alteração :
            // Descrição         :
            //----------------------------------------------------------------------------------------
            int counterbl_report_Jw_vendas_principais=0;
            {
              portalbr.dbobj.view.Jw_vendas_principais t_jw_vendas_principais = new portalbr.dbobj.view.Jw_vendas_principais();
              java.util.Vector res_Jw_vendas_principais = (java.util.Vector)session.getAttribute("res_Jw_vendas_principais");
              if (res_Jw_vendas_principais!=null && res_Jw_vendas_principais.size()>0) {
                java.lang.String marca     =  null;
                java.lang.String b0_marca  =  null;
                java.lang.String periodo   =  null;
                StringBuilder cabecalho = new StringBuilder();
                int pares                  =  0;
                int sum_pares_0            =  0;
                double valor               =  0;
                double sum_valor_0         =  0;
                int i_bl_report_Jw_vendas_principais = 0;
                t_jw_vendas_principais = (portalbr.dbobj.view.Jw_vendas_principais)res_Jw_vendas_principais.elementAt(i_bl_report_Jw_vendas_principais);
                marca   = t_jw_vendas_principais.getMarca()==null?"":t_jw_vendas_principais.getMarca();
                periodo = t_jw_vendas_principais.getPeriodo()==null?"":t_jw_vendas_principais.getPeriodo();
                pares   = t_jw_vendas_principais.getPares();
                valor   = t_jw_vendas_principais.getValor();

                //-----------------------------------
                //  if(request.getParameter("t").equals("g")){
                  if((session.getAttribute("parametro1")+"").equals("g")){
                    com.egen.util.jdbc.JdbcUtil j = null;
                    try {
                      j = new com.egen.util.jdbc.JdbcUtil();
                      portalbr.dbobj.table.Grupo_economico table_grupo_economico = new portalbr.dbobj.table.Grupo_economico();
                      String[][] selectg = null;
                      Object[][] whereg  = {
                      {"gre_grupo","=",session.getAttribute("parametro2")+""}
                      };
                      Vector res_Grupo_economico = j.select(table_grupo_economico, selectg, whereg, null, null, null);
                      if (res_Grupo_economico != null && res_Grupo_economico.size() > 0) {
                        portalbr.dbobj.table.Grupo_economico r = (portalbr.dbobj.table.Grupo_economico) res_Grupo_economico.elementAt(0);
                        cabecalho.append("Grupo : ").append(session.getAttribute("parametro2")).append(" - ").append(r.getGre_descricao());
                      }
                    } finally {
                      if(j!=null) {
                        j.close();
                        j = null;
                      }
                    }
                  } else {
                    //-------------------------------------------------------------------
                    com.egen.util.jdbc.JdbcUtil j = null;
                    try{
                      j = new com.egen.util.jdbc.JdbcUtil();
                      portalbr.dbobj.table.Cli table_cli = new portalbr.dbobj.table.Cli();
                      String[][] selectc = null;
                      Object[][] wherec  = {
                      {"cli_cdgo","=",session.getAttribute("parametro2")+""}
                      };
                      Vector res_Cli = j.select(table_cli, selectc, wherec, null, null, null);
                      if (res_Cli != null && res_Cli.size() > 0) {
                        portalbr.dbobj.table.Cli rc = (portalbr.dbobj.table.Cli) res_Cli.elementAt(0);
                        cabecalho.append("Cliente : ").append(session.getAttribute("parametro2")).append(" - ").append(rc.getCli_rzao());
                      }

                    } finally {
                      if(j!=null) {
                        j.close();
                        j = null;
                      }
                    }
                  }
                  %>
                  <table class="reportTable" style=width:99%;  border=1  frame=box>
                    <tr class="reportHeader3">
                      <td>
                        <big>
                          <%= cabecalho.toString() %>
                        </big>
                      </td>
                    </tr>
                  </table>
                  <table id="TRbl_report_Jw_vendas_principais" class="reportTable" style=width:99%;  border=1  frame=box>
                    <%
                    //-----------------------------------
                    while (i_bl_report_Jw_vendas_principais<res_Jw_vendas_principais.size()){
                      counterbl_report_Jw_vendas_principais++;
                      %>
                      <tr class="reportHeader2" >
                        <td colspan=3>
                          Marca
                          <%= marca %>
                        </td>
                      </tr>
                      <%
                      int sum_pares_1    = 0;
                      double sum_valor_1 = 0;
                      b0_marca           = marca;
                      %>
                      <tr class="reportHeader" >
                        <td class="columnTdHeader" style="text-align:left;">
                          Período
                        </td>
                        <td class="columnTdHeader" style="text-align:right;">
                          Pares
                        </td>
                        <td class="columnTdHeader" style="text-align:right;">
                          Valor
                        </td>
                      </tr>
                      <%
                      while (i_bl_report_Jw_vendas_principais<res_Jw_vendas_principais.size() &&  (b0_marca==null?"":b0_marca).equals((marca==null?"":marca))){
                        counterbl_report_Jw_vendas_principais++;
                        String style="";
                        if (!((i_bl_report_Jw_vendas_principais%2)!=0)) {
                          style="class=rowColor";
                        } else {
                          style="class=rowBlank";
                        }
                        %>
                        <tr <%= style %> id='TRbl_report_Jw_vendas_principais<%=counterbl_report_Jw_vendas_principais%>' >
                          <td class="reportColumn" style="text-align:left;">
                            <%= periodo %>
                          </td>
                          <td class="reportColumn" style="text-align:right;">
                            <%= com.egen.util.text.FormatNumber.format(pares, "##,##0.##") %>
                          </td>
                          <td class="reportColumn" style="text-align:right;">
                            <%= com.egen.util.text.FormatNumber.format(valor, "##,##0.00") %>
                          </td>
                        </tr>
                        <%
                        sum_pares_1 += pares;
                        sum_pares_0 += pares;
                        sum_valor_1 += valor;
                        sum_valor_0 += valor;
                        if (++i_bl_report_Jw_vendas_principais >= res_Jw_vendas_principais.size()) {
                          break;
                        }
                        t_jw_vendas_principais = (portalbr.dbobj.view.Jw_vendas_principais)res_Jw_vendas_principais.elementAt(i_bl_report_Jw_vendas_principais);
                        marca   = t_jw_vendas_principais.getMarca()==null?"":t_jw_vendas_principais.getMarca();
                        periodo = t_jw_vendas_principais.getPeriodo()==null?"":t_jw_vendas_principais.getPeriodo();
                        pares   = t_jw_vendas_principais.getPares();
                        valor   = t_jw_vendas_principais.getValor();
                      }
                      %>
                      <tr class="totalColumn">
                        <td style="text-align:right;">
                          <b>
                            Total :
                          </b>
                        </td>
                        <td class="totalTdColumn"  style="text-align:right;">
                          <%= com.egen.util.text.FormatNumber.format(sum_pares_1, "##,##0.##")  %>
                        </td>
                        <td class="totalTdColumn"  style="text-align:right;">
                          <%=  com.egen.util.text.FormatNumber.format(sum_valor_1, "##,##0.00") %>
                        </td>
                      </tr>
                      <%
                    }
                    %>
                    <tr class="totalColumn">
                      <td style="text-align:right;">
                        <b>
                          Total Geral :
                        </b>
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;">
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(sum_pares_0, "##,##0.##") %>
                        </b>
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;">
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(sum_valor_0, "##,##0.00") %>
                        </b>
                      </td>
                    </tr>
                    <%
                  }
                }
                %>
              </table>
              <html:form action="com/VendasPrincipais_rForm.do" method="post" styleClass="baseForm">
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

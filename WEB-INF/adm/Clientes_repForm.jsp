<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <title>
      <bean:message key="page.title"/>
    </title>

    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:800;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable">
              <tr class="headerTr">
                <td class="headerTd">
                  <bean:message key="page.title"/>
                </td>
                <td>
                  <div class='div10'>
                    <jsp:useBean id="now" class="java.util.Date" />
                    <fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss" value="${now}" />
                  </div>
                </td>
              </tr>
            </table>

            <table id="TRbl_report_Clientes_representante" class="reportTable" style=width:800;  >
              <%
              int counterbl_report_Clientes_representante = 0;
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                j = new com.egen.util.jdbc.JdbcUtil();
                portalbr.dbobj.view.Clientes_representante t_clientes_representante = new portalbr.dbobj.view.Clientes_representante();
                java.util.Vector res_Clientes_representante = (java.util.Vector)session.getAttribute("res_Clientes_representante");
                if (res_Clientes_representante!=null && res_Clientes_representante.size()>0) {
                  java.lang.String rep_cdgo  =  null;
                  java.lang.String rep_nome  =  null;
                  java.lang.String cli_ati   =  null;
                  int clientes_ativos        =  0;
                  int clientes_atendidos     =  0;
                  int clientes_nao_atendidos =  0;
                  int pares                  =  0;
                  double valor               =  0;
                  int i_bl_report_Clientes_representante = 0;
                  t_clientes_representante = (portalbr.dbobj.view.Clientes_representante)res_Clientes_representante.elementAt(i_bl_report_Clientes_representante);
                  rep_cdgo = t_clientes_representante.getRep_cdgo()==null?"":t_clientes_representante.getRep_cdgo();
                  clientes_ativos = t_clientes_representante.getClientes_ativos();
                  clientes_atendidos = t_clientes_representante.getClientes_atendidos();
                  clientes_nao_atendidos = t_clientes_representante.getClientes_nao_atendidos();
                  pares = t_clientes_representante.getPares();
                  valor = t_clientes_representante.getValor();
                  rep_nome = "";
                  {
                    if(rep_cdgo!=null && rep_cdgo.length()>0) {
                      portalbr.dbobj.table.Rep cr_db_object = new portalbr.dbobj.table.Rep();
                      Object[][] where = {
                      {"rep_cdgo","like",rep_cdgo}
                      };
                      java.util.Vector results = j.select(cr_db_object, where, null);
                      if (results!=null && results.size()>0) {
                        cr_db_object = (portalbr.dbobj.table.Rep)results.elementAt(0);
                        rep_nome = ((cr_db_object.getRep_nome()!=null)?cr_db_object.getRep_nome():"");
                      }
                    }
                    };
                    cli_ati = "";
                    {
                      com.egen.util.jdbc.JdbcUtil j1 = null;
                      j1 = new com.egen.util.jdbc.JdbcUtil();
                      if(rep_cdgo!=null && rep_cdgo.length()>0) {
                        portalbr.dbobj.view.Cli_ati_representantes cr_db_object = new portalbr.dbobj.view.Cli_ati_representantes();
                        Object[][] where = {
                        {"rep_cdgo","like",rep_cdgo}
                        };
                        java.util.Vector results = j1.select(cr_db_object, where, null);
                        if (results!=null && results.size()>0) {
                          cr_db_object = (portalbr.dbobj.view.Cli_ati_representantes)results.elementAt(0);
                          cli_ati = ((cr_db_object.getCli_ati()!=null)?cr_db_object.getCli_ati():"");
                        } else { cli_ati="0";}
                      }
                      if (j1 != null) {
                        j1.close();
                        j1 = null;
                      }
                    }

                    ;
                    while (i_bl_report_Clientes_representante<res_Clientes_representante.size()){
                      counterbl_report_Clientes_representante++;
                      %>
                      <tr class="reportHeader" >
                        <td colspan=7>
                        </td>
                      </tr>
                      <%
                      %>
                      <tr class="reportHeader" >
                        <td class="columnTdHeader" style="text-align:left;">
                          Representante
                        </td>
                        <td class="columnTdHeader" style="text-align:left;">
                        </td>
                        <td class="columnTdHeader" style="text-align:left;">
                          Clientes Ativos
                        </td>
                        <td class="columnTdHeader" style="text-align:right;">
                          Clientes Atendidos
                        </td>
                        <td class="columnTdHeader" style="text-align:right;">
                          Clientes Não Atendidos
                        </td>
                        <td class="columnTdHeader" style="text-align:right;">
                          Pares
                        </td>
                        <td class="columnTdHeader" style="text-align:right;">
                          Valor
                        </td>
                      </tr>
                      <%
                      while (i_bl_report_Clientes_representante<res_Clientes_representante.size()){
                        counterbl_report_Clientes_representante++;
                        String style="";
                        if (!((i_bl_report_Clientes_representante%2)!=0)) {
                          style="class=rowColor";
                        } else {
                          style="class=rowBlank";
                        }
                        %>
                        <tr <%= style %> id='TRbl_report_Clientes_representante<%=counterbl_report_Clientes_representante%>' >
                          <td class="reportColumn" style="text-align:left;">
                            <%= rep_cdgo %>
                          </td>
                          <td class="reportColumn" style="text-align:left;">
                            <%= rep_nome %>
                          </td>
                          <td class="reportColumn" style="text-align:left;">
                            <a href="../adm/Clientes_ativos_representanteForm.do?select_action=&rep_cdgo=<%= rep_cdgo %>" target="_self" STYLE="cursor:hand">
                              <%= cli_ati %>
                            </a>
                          </td>
                          <td class="reportColumn" style="text-align:right;">
                            <a href="../adm/Clientes_atendidos_representanteForm.do?select_action=&rep_cdgo=<%= rep_cdgo %>" target="_self" STYLE="cursor:hand">
                              <%= clientes_atendidos %>
                            </a>
                          </td>
                          <td class="reportColumn" style="text-align:right;">
                            <%= clientes_nao_atendidos %>
                          </td>
                          <td class="reportColumn" style="text-align:right;">
                            <%= pares %>
                          </td>
                          <td class="reportColumn" style="text-align:right;">
                            <%= com.egen.util.text.FormatNumber.format(valor, "##,##0.00") %>
                          </td>
                        </tr>
                        <%
                        if (++i_bl_report_Clientes_representante >= res_Clientes_representante.size()) {
                          break;
                        }
                        t_clientes_representante = (portalbr.dbobj.view.Clientes_representante)res_Clientes_representante.elementAt(i_bl_report_Clientes_representante);
                        rep_cdgo = t_clientes_representante.getRep_cdgo()==null?"":t_clientes_representante.getRep_cdgo();
                        clientes_ativos = t_clientes_representante.getClientes_ativos();
                        clientes_atendidos = t_clientes_representante.getClientes_atendidos();
                        clientes_nao_atendidos = t_clientes_representante.getClientes_nao_atendidos();
                        pares = t_clientes_representante.getPares();
                        valor = t_clientes_representante.getValor();
                        rep_nome = "";
                        {
                          if(rep_cdgo!=null && rep_cdgo.length()>0) {
                            portalbr.dbobj.table.Rep cr_db_object = new portalbr.dbobj.table.Rep();
                            Object[][] where = {
                            {"rep_cdgo","like",rep_cdgo}
                            };
                            java.util.Vector results = j.select(cr_db_object, where, null);
                            if (results!=null && results.size()>0) {
                              cr_db_object = (portalbr.dbobj.table.Rep)results.elementAt(0);
                              rep_nome = ((cr_db_object.getRep_nome()!=null)?cr_db_object.getRep_nome():"");
                            }
                          }
                          };
                          cli_ati = "";
                          {  com.egen.util.jdbc.JdbcUtil j1 = null;
                          j1 = new com.egen.util.jdbc.JdbcUtil();
                          if(rep_cdgo!=null && rep_cdgo.length()>0) {
                            portalbr.dbobj.view.Cli_ati_representantes cr_db_object = new portalbr.dbobj.view.Cli_ati_representantes();
                            Object[][] where = {
                            {"rep_cdgo","like",rep_cdgo}
                            };
                            java.util.Vector results = j1.select(cr_db_object, where, null);
                            if (results!=null && results.size()>0) {
                              cr_db_object = (portalbr.dbobj.view.Cli_ati_representantes)results.elementAt(0);
                              cli_ati = ((cr_db_object.getCli_ati()!=null)?cr_db_object.getCli_ati():"");
                            } else { cli_ati="0";}
                          }
                          if (j1 != null) {
                            j1.close();
                            j1 = null;
                          }
                        }

                        ;
                      }
                    }
                  }
                } catch (Exception e) {
                  session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                } finally {
                  if(j!=null){
                    j.close();
                    j = null;
                  }
                }
                %>
              </table>
              <html:form action="adm/Clientes_repForm.do" method="post" styleClass="baseForm">
                <table class="itemTable"  style=" width:;">
                  <html:hidden property="dt_inicial"/>
                  <html:hidden property="dt_final"/>
                  <html:hidden property="codigo_regional"/>
                  <html:hidden property="codigo_marca"/>
                  <html:hidden property="lin_cdgo"/>
                  <table class="buttonTable" style='width:800;'>
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
              </td>
            </tr>
          </table>

        </body>
      </center>
    </html>

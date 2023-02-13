<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta de Pedidos
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
                  <%@ include file="../system/header_sem_ajuda.jsp" %>
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Ped" class="reportTable" style=width:500;  >
              <%
              int counterbl_report_Ped=0;
              {
                portalbr.dbobj.table.Ped t_ped = new portalbr.dbobj.table.Ped();
                java.util.Vector res_Ped = (java.util.Vector)session.getAttribute("res_Ped");
                if (res_Ped!=null && res_Ped.size()>0) {
                  java.lang.String ped_nped =  null;
                  java.lang.String ped_stat =  null;
                  int cli_cdgo        =  0;
                  int ped_nmro        =  0;
                  int i_bl_report_Ped =  0;
                  t_ped = (portalbr.dbobj.table.Ped)res_Ped.elementAt(i_bl_report_Ped);
                  ped_nped = t_ped.getPed_nped()==null?"":t_ped.getPed_nped();
                  ped_stat = t_ped.getPed_stat()==null?"":t_ped.getPed_stat();
                  cli_cdgo = t_ped.getCli_cdgo();
                  ped_nmro = t_ped.getPed_nmro();
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:left;">
                      Número Pedido
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Status
                    </td>
                    <td class="columnTdHeader" style="text-align:right;">
                      Cliente
                    </td>
                    <td class="columnTdHeader" style="text-align:right;">
                      Pedido Beira Rio
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Ped<res_Ped.size()){
                    counterbl_report_Ped++;
                    String style="";
                    if (!((i_bl_report_Ped%2)!=0)) {
                      style="class=rowColor";
                    } else {
                      style="class=rowBlank";
                    }
                    %>
                    <tr <%= style %> id='TRbl_report_Ped<%=counterbl_report_Ped%>' >
                      <td class="reportColumn" style="text-align:left;">
                        <%= ped_nped %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= ped_stat %>
                      </td>
                      <td class="reportColumn" style="text-align:right;">
                        <a href="../com/ConsultaPedidos_iForm.do?select_action=&pedido_beira_rio=<%= ped_nmro %>" target="_self" STYLE="cursor:hand">
                          <%= cli_cdgo %>
                        </a>
                      </td>
                      <td class="reportColumn" style="text-align:right;">
                        <%= ped_nmro %>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Ped >= res_Ped.size()) {
                      break;
                    }
                    t_ped = (portalbr.dbobj.table.Ped)res_Ped.elementAt(i_bl_report_Ped);
                    ped_nped = t_ped.getPed_nped()==null?"":t_ped.getPed_nped();
                    ped_stat = t_ped.getPed_stat()==null?"":t_ped.getPed_stat();
                    cli_cdgo = t_ped.getCli_cdgo();
                    ped_nmro = t_ped.getPed_nmro();
                  }
                }
              }
              %>
            </table>
            <html:form action="com/ConsultaPedidos_dForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <html:hidden property="rep_cdgo"/>
                <html:hidden property="ped_nped"/>
                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
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

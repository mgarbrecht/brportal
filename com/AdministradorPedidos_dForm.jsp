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
                  <%@ include file="../system/header_sem_ajuda.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(59)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/AdministradorPedidos_dForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="data"/>
                    <html:errors property="prev"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_web_poi_detalhes"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleClass="disabled" tabindex="-1" readonly="true" size="8" maxlength="8"/>
                  </td>
                </tr>

                <html:hidden property="linha"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nome
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="28" maxlength="28"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Mês/Ano
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data" styleClass="disabled" tabindex="-1" readonly="true" size="8" maxlength="8"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Total Previsto no Mês
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="prev" styleClass="disabled" tabindex="-1" readonly="true"/>
                  </td>
                </tr>

                <html:hidden property="dt"/>
                <html:hidden property="ref_cdgo"/>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <%
            //---------------------------------------------------------------------------------------
            // Autor             : Mateus Garbrecht (TechnoCorp)
            // Data de Criação   : 13/04/2006
            // Objetivo          : Relatório com os detalhes dos registros mostrados no relatório:
            //                     /com/AdministradorPedidos_rForm.jsp
            //----------------------------------------------------------------------------------------
            // Data de Alteração :
            // Descrição         :
            //----------------------------------------------------------------------------------------
            %>
            <table id="TRbl_report_Jw_web_poi_detalhes" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_web_poi_detalhes=0;
              double total_capacidade = 0;
              double total_vendido    = 0;
              double total_disponivel = 0;
              double total_bloq       = 0;
              {
                portalbr.dbobj.view.Jw_web_poi_detalhes t_jw_web_poi_detalhes = new portalbr.dbobj.view.Jw_web_poi_detalhes();
                portalbr.com.AdministradorPedidos_dActionForm AdministradorPedidos_dActionForm = (portalbr.com.AdministradorPedidos_dActionForm)session.getAttribute("AdministradorPedidos_dActionForm");
                java.util.Vector res_Jw_web_poi_detalhes = (java.util.Vector)session.getAttribute("res_Jw_web_poi_detalhes");
                if (res_Jw_web_poi_detalhes!=null && res_Jw_web_poi_detalhes.size()>0) {
                  java.lang.String fil                =  null;
                  java.lang.String dt                 =  null;
                  java.lang.String dtf                =  null;
                  java.lang.String situacao           =  null;
                  double capacidade                   =  0;
                  double vendido                      =  0;
                  double disponivel                   =  0;
                  double bloq                         =  0;
                  int i_bl_report_Jw_web_poi_detalhes =  0;

                  t_jw_web_poi_detalhes = (portalbr.dbobj.view.Jw_web_poi_detalhes)res_Jw_web_poi_detalhes.elementAt(i_bl_report_Jw_web_poi_detalhes);
                  fil        = t_jw_web_poi_detalhes.getFil()==null?"":t_jw_web_poi_detalhes.getFil();
                  dt         = t_jw_web_poi_detalhes.getDt()==null?"":t_jw_web_poi_detalhes.getDt();
                  dtf        = t_jw_web_poi_detalhes.getDtf()==null?"":t_jw_web_poi_detalhes.getDtf();
                  situacao   = t_jw_web_poi_detalhes.getSituacao()==null?"":t_jw_web_poi_detalhes.getSituacao();
                  capacidade = t_jw_web_poi_detalhes.getCapacidade();
                  vendido    = t_jw_web_poi_detalhes.getVendido();
                  bloq       = t_jw_web_poi_detalhes.getBloq();
                  disponivel = capacidade-vendido;
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:left;">
                      Filial
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Dt. Inicial
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Dt. Final
                    </td>
                    <!--
                      <td class="columnTdHeader" style="text-align:left;"> Situação </td>
                    -->
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
                  while (i_bl_report_Jw_web_poi_detalhes<res_Jw_web_poi_detalhes.size()){
                    counterbl_report_Jw_web_poi_detalhes++;
                    String style="";
                    if (!((i_bl_report_Jw_web_poi_detalhes%2)!=0)) {
                      style="class=rowColor";
                    } else {
                      style="class=rowBlank";
                    }
                    total_capacidade += capacidade;
                    total_vendido    += vendido;
                    total_disponivel += disponivel;
                    total_bloq       += bloq;
                    %>
                    <tr <%= style %> id='TRbl_report_Jw_web_poi_detalhes<%=counterbl_report_Jw_web_poi_detalhes%>' >
                      <td class="reportColumn" style="text-align:left;">
                        <%= fil %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= dt %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= dtf %>
                      </td>
                      <!--
                        <td class="reportColumn" style="text-align:left;"> <%= situacao %> </td>
                      -->
                      <td class="reportColumn" style="text-align:right;">
                        <%= com.egen.util.text.FormatNumber.format(capacidade, "##,##0") %>
                      </td>
                      <td class="reportColumn" style="text-align:right;">
                        <%= com.egen.util.text.FormatNumber.format(vendido, "##,##0") %>
                      </td>
                      <td class="reportColumn" style="text-align:right;">
                        <%= com.egen.util.text.FormatNumber.format(disponivel, "##,##0") %>
                      </td>
                      <td class="reportColumn" style="text-align:right;">
                        <%= com.egen.util.text.FormatNumber.format(bloq, "##,##0.00") %>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Jw_web_poi_detalhes >= res_Jw_web_poi_detalhes.size()) {
                      break;
                    }
                    t_jw_web_poi_detalhes = (portalbr.dbobj.view.Jw_web_poi_detalhes)res_Jw_web_poi_detalhes.elementAt(i_bl_report_Jw_web_poi_detalhes);
                    fil        = t_jw_web_poi_detalhes.getFil()==null?"":t_jw_web_poi_detalhes.getFil();
                    dt         = t_jw_web_poi_detalhes.getDt()==null?"":t_jw_web_poi_detalhes.getDt();
                    dtf        = t_jw_web_poi_detalhes.getDtf()==null?"":t_jw_web_poi_detalhes.getDtf();
                    situacao   = t_jw_web_poi_detalhes.getSituacao()==null?"":t_jw_web_poi_detalhes.getSituacao();
                    capacidade = t_jw_web_poi_detalhes.getCapacidade();
                    vendido    = t_jw_web_poi_detalhes.getVendido();
                    bloq       = t_jw_web_poi_detalhes.getBloq();
                    disponivel = capacidade-vendido;
                  }
                }
                %>
                <tr>
                  <td class="reportColumn" style="text-align:right;" colspan=3;>
                    <b>
                      Totais :
                    </b>
                  </td>
                  <td class="reportColumn" style="text-align:right;">
                    <b>
                      <%= com.egen.util.text.FormatNumber.format(total_capacidade, "##,##0") %>
                    </b>
                  </td>
                  <td class="reportColumn" style="text-align:right;">
                    <b>
                      <%= com.egen.util.text.FormatNumber.format(total_vendido, "##,##0") %>
                    </b>
                  </td>
                  <td class="reportColumn" style="text-align:right;">
                    <b>
                      <%= com.egen.util.text.FormatNumber.format(total_disponivel, "##,##0") %>
                    </b>
                  </td>
                  <td class="reportColumn" style="text-align:right;">
                    <b>
                      <%= com.egen.util.text.FormatNumber.format(total_bloq, "##,##0.00") %>
                    </b>
                  </td>

                </tr>

                <%
              }
              %>
            </table>
            <html:form action="com/AdministradorPedidos_dForm.do" method="post" styleClass="baseForm">
              <table class="buttonTable" style='width:;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button onclick="history.go(-1);" styleClass="baseButton" property="back_action">
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

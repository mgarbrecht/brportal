<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      <bean:message bundle="ComercialResources" key="PedidosSituacoes.titulo"/>
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
                </td>

              </tr>

            </table>

            <html:form action="com/PedidosSituacoesForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="pedido_beira_rio"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_situacoes_pedido"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="PedidosSituacoes.pedido_beira_rio"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="pedido_beira_rio" styleClass="disabled" tabindex="-1" readonly="true"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <%
            {
              %>

              <%
              java.util.Vector res_Jw_situacoes_pedido = (java.util.Vector)session.getAttribute("res_Jw_situacoes_pedido");
              %>

              <%
              if (res_Jw_situacoes_pedido!=null && res_Jw_situacoes_pedido.size()>0) {
                %>

                <table id="TRbl_report_Jw_situacoes_pedido"  class="reportTable"   style="width:99%; "  border="1"  frame="box">
                  <%
                  java.lang.String dt =  null;
                  java.lang.String hora =  null;
                  java.lang.String nome =  null;
                  java.lang.String descricao =  null;
                  java.lang.String obs_sit =  null;
                  java.lang.String obs_lib =  null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:left;" >
                      <bean:message bundle="ComercialResources" key="PedidosSituacoes.dt"/>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      <bean:message bundle="ComercialResources" key="PedidosSituacoes.hora"/>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      <bean:message bundle="ComercialResources" key="PedidosSituacoes.nome"/>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      <bean:message bundle="ComercialResources" key="PedidosSituacoes.descricao"/>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      <bean:message bundle="ComercialResources" key="PedidosSituacoes.obs_sit"/>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      <bean:message bundle="ComercialResources" key="PedidosSituacoes.obs_lib"/>
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Jw_situacoes_pedido = 0;
                  while (i_bl_report_Jw_situacoes_pedido<res_Jw_situacoes_pedido.size()) {
                    portalbr.dbobj.view.Jw_situacoes_pedido t_jw_situacoes_pedido = (portalbr.dbobj.view.Jw_situacoes_pedido)res_Jw_situacoes_pedido.elementAt(i_bl_report_Jw_situacoes_pedido);
                    dt = t_jw_situacoes_pedido.getDt()==null?"":t_jw_situacoes_pedido.getDt();
                    hora = t_jw_situacoes_pedido.getHora()==null?"":t_jw_situacoes_pedido.getHora();
                    nome = t_jw_situacoes_pedido.getNome()==null?"":t_jw_situacoes_pedido.getNome();
                    descricao = t_jw_situacoes_pedido.getDescricao()==null?"":t_jw_situacoes_pedido.getDescricao();
                    obs_sit = t_jw_situacoes_pedido.getObs_sit()==null?"":t_jw_situacoes_pedido.getObs_sit();
                    obs_lib = t_jw_situacoes_pedido.getObs_lib()==null?"":t_jw_situacoes_pedido.getObs_lib();
                    String style_bl_report_Jw_situacoes_pedido="";
                    if (!((i_bl_report_Jw_situacoes_pedido%2)!=0)) {
                      style_bl_report_Jw_situacoes_pedido="rowColor";
                    } else {
                      style_bl_report_Jw_situacoes_pedido="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Jw_situacoes_pedido %>' id="TRbl_report_Jw_situacoes_pedido<%=i_bl_report_Jw_situacoes_pedido%>" >
                      <td class="reportColumn" style="text-align:left;" >
                        <%= dt %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= hora %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= nome %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= descricao %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= obs_sit %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= obs_lib %>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Jw_situacoes_pedido++;
                    if (i_bl_report_Jw_situacoes_pedido<res_Jw_situacoes_pedido.size()) {
                      t_jw_situacoes_pedido = (portalbr.dbobj.view.Jw_situacoes_pedido)res_Jw_situacoes_pedido.elementAt(i_bl_report_Jw_situacoes_pedido);
                      dt = t_jw_situacoes_pedido.getDt()==null?"":t_jw_situacoes_pedido.getDt();
                      hora = t_jw_situacoes_pedido.getHora()==null?"":t_jw_situacoes_pedido.getHora();
                      nome = t_jw_situacoes_pedido.getNome()==null?"":t_jw_situacoes_pedido.getNome();
                      descricao = t_jw_situacoes_pedido.getDescricao()==null?"":t_jw_situacoes_pedido.getDescricao();
                      obs_sit = t_jw_situacoes_pedido.getObs_sit()==null?"":t_jw_situacoes_pedido.getObs_sit();
                      obs_lib = t_jw_situacoes_pedido.getObs_lib()==null?"":t_jw_situacoes_pedido.getObs_lib();
                    } else {
                    }
                  }
                  %>

                </table>

                <%
              }
              %>

              <%
            }
            %>

            <html:form action="com/PedidosSituacoesForm.do" method="post" styleClass="baseForm">
              <table class="buttonTable" style='width:;'>
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

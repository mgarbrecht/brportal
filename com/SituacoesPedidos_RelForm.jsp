<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      <bean:message bundle="ComercialResources" key="SituacoesPedidos_Rel.titulo"/>
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

            <table id="TRbl_report_Jw_situacoes_pedidos" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_situacoes_pedidos=0;
              {
                portalbr.dbobj.view.Jw_situacoes_pedidos t_jw_situacoes_pedidos = new portalbr.dbobj.view.Jw_situacoes_pedidos();
                java.util.Vector res_Jw_situacoes_pedidos = (java.util.Vector)session.getAttribute("res_Jw_situacoes_pedidos");
                if (res_Jw_situacoes_pedidos!=null && res_Jw_situacoes_pedidos.size()>0) {
                  java.lang.String descricao_situacao  = null;
                  java.sql.Timestamp dt_cad_situacao   = null;
                  java.lang.String usuario_situacao    = null;
                  java.lang.String observ_situacao     = null;
                  java.lang.String observ_liberacao    = null;
                  java.lang.String nome_usuario        = null;
                  java.lang.Long ped_nmro              = null;
                  java.lang.String situacao            = null;
                  int blo_codigo_bloqueio              = 0;
                  int ts_codigo_situacao               = 0;
                  int i_bl_report_Jw_situacoes_pedidos = 0;
                  t_jw_situacoes_pedidos = (portalbr.dbobj.view.Jw_situacoes_pedidos)res_Jw_situacoes_pedidos.elementAt(i_bl_report_Jw_situacoes_pedidos);
                  ped_nmro            = t_jw_situacoes_pedidos.getPed_nmro();
                  ts_codigo_situacao  = t_jw_situacoes_pedidos.getTs_codigo_situacao();
                  descricao_situacao  = t_jw_situacoes_pedidos.getDescricao_situacao()==null?"":t_jw_situacoes_pedidos.getDescricao_situacao();
                  dt_cad_situacao     = (java.sql.Timestamp)t_jw_situacoes_pedidos.getDt_cad_situacao();
                  usuario_situacao    = t_jw_situacoes_pedidos.getUsuario_situacao()==null?"":t_jw_situacoes_pedidos.getUsuario_situacao();
                  observ_situacao     = t_jw_situacoes_pedidos.getObserv_situacao()==null?"":t_jw_situacoes_pedidos.getObserv_situacao();
                  observ_liberacao    = t_jw_situacoes_pedidos.getObserv_liberacao()==null?"":t_jw_situacoes_pedidos.getObserv_liberacao();
                  blo_codigo_bloqueio = t_jw_situacoes_pedidos.getBlo_codigo_bloqueio();
                  nome_usuario        = t_jw_situacoes_pedidos.getNome_usuario()==null?"":t_jw_situacoes_pedidos.getNome_usuario();
                  situacao            = ts_codigo_situacao + " - " + descricao_situacao;
                  java.lang.Long b0_ped_nmro =  null;
                  while (i_bl_report_Jw_situacoes_pedidos<res_Jw_situacoes_pedidos.size()){
                    counterbl_report_Jw_situacoes_pedidos++;
                    %>
                    <tr class="reportHeader2" >
                      <td colspan=5>
                        <bean:message bundle="ComercialResources" key="SituacoesPedidos_Rel.ped_nmro"/>
                        <%= ((ped_nmro!=null)?ped_nmro.toString():"") %>
                      </td>
                    </tr>
                    <%
                    b0_ped_nmro = ped_nmro;
                    %>
                    <tr class="reportHeader" >
                      <td class="columnTdHeader" style="text-align:left;">
                        <bean:message bundle="ComercialResources" key="SituacoesPedidos_Rel.situacao"/>
                      </td>
                      <td class="columnTdHeader" style="text-align:center;">
                        <bean:message bundle="ComercialResources" key="SituacoesPedidos_Rel.data_situacao"/>
                      </td>
                      <td class="columnTdHeader" style="text-align:left;">
                        <bean:message bundle="ComercialResources" key="SituacoesPedidos_Rel.obs_situacao"/>
                      </td>
                      <td class="columnTdHeader" style="text-align:left;">
                        <bean:message bundle="ComercialResources" key="SituacoesPedidos_Rel.obs_liberacao"/>
                      </td>
                      <td class="columnTdHeader" style="text-align:left;">
                        <bean:message bundle="ComercialResources" key="SituacoesPedidos_Rel.usuario"/>
                      </td>
                    </tr>
                    <%
                    while (i_bl_report_Jw_situacoes_pedidos<res_Jw_situacoes_pedidos.size() &&  (b0_ped_nmro==null?0:b0_ped_nmro.longValue())==(ped_nmro==null?0:ped_nmro.longValue())){
                      counterbl_report_Jw_situacoes_pedidos++;
                      String style="";
                      if (!((i_bl_report_Jw_situacoes_pedidos%2)!=0)) {
                        style="class=rowColor";
                      } else {
                        style="class=rowBlank";
                      }
                      %>
                      <tr <%= style %> id='TRbl_report_Jw_situacoes_pedidos<%=counterbl_report_Jw_situacoes_pedidos%>' >
                        <td class="reportColumn" style="text-align:left;">
                          <%= situacao %>
                        </td>
                        <td class="reportColumn" style="text-align:center;">
                          <%= com.egen.util.text.FormatDate.format(dt_cad_situacao, "dd/MM/yyyy HH:mm:ss") %>
                        </td>
                        <td class="reportColumn" style="text-align:left;">
                          <%= observ_situacao %>
                        </td>
                        <td class="reportColumn" style="text-align:left;">
                          <%= observ_liberacao %>
                        </td>
                        <td class="reportColumn" style="text-align:left;">
                          <%= nome_usuario %>
                        </td>
                      </tr>
                      <%
                      if (++i_bl_report_Jw_situacoes_pedidos >= res_Jw_situacoes_pedidos.size()) {
                        break;
                      }
                      t_jw_situacoes_pedidos = (portalbr.dbobj.view.Jw_situacoes_pedidos)res_Jw_situacoes_pedidos.elementAt(i_bl_report_Jw_situacoes_pedidos);
                      ped_nmro            = t_jw_situacoes_pedidos.getPed_nmro();
                      ts_codigo_situacao  = t_jw_situacoes_pedidos.getTs_codigo_situacao();
                      descricao_situacao  = t_jw_situacoes_pedidos.getDescricao_situacao()==null?"":t_jw_situacoes_pedidos.getDescricao_situacao();
                      dt_cad_situacao     = (java.sql.Timestamp)t_jw_situacoes_pedidos.getDt_cad_situacao();
                      usuario_situacao    = t_jw_situacoes_pedidos.getUsuario_situacao()==null?"":t_jw_situacoes_pedidos.getUsuario_situacao();
                      observ_situacao     = t_jw_situacoes_pedidos.getObserv_situacao()==null?"":t_jw_situacoes_pedidos.getObserv_situacao();
                      observ_liberacao    = t_jw_situacoes_pedidos.getObserv_liberacao()==null?"":t_jw_situacoes_pedidos.getObserv_liberacao();
                      blo_codigo_bloqueio = t_jw_situacoes_pedidos.getBlo_codigo_bloqueio();
                      nome_usuario        = t_jw_situacoes_pedidos.getNome_usuario()==null?"":t_jw_situacoes_pedidos.getNome_usuario();
                      situacao            = ts_codigo_situacao + " - " + descricao_situacao;
                    }
                  }
                }
              }
              %>
            </table>
            <html:form action="com/SituacoesPedidos_RelForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <%
            {
              %>

              <%
              boolean montouCabecalho = false;
              java.util.Vector res_Interface_arq_compra_oc_log = (java.util.Vector)session.getAttribute("res_Interface_arq_compra_oc_log");
              %>

              <form  name="bl_report_Interface_arq_compra_oc_log" id="bl_report_Interface_arq_compra_oc_log" class="baseForm" method="post" >
                <%
                if (res_Interface_arq_compra_oc_log!=null && res_Interface_arq_compra_oc_log.size()>0) {
                  %>

                  <table id="TRbl_report_Interface_arq_compra_oc_log"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.String situacao =  null;
                    java.lang.String descricaoSituacao = null;
                    java.lang.Integer interface_arq_compra_id =  null;
                    java.lang.Integer oco_numero =  null;
                    java.sql.Timestamp data_transacao =  null;
                    java.lang.String usuario =  null;
                    String _b0_control = "__";
                    int i_bl_report_Interface_arq_compra_oc_log = 0;
                    while (i_bl_report_Interface_arq_compra_oc_log<res_Interface_arq_compra_oc_log.size()) {
                      portalbr.dbobj.table.Interface_arq_compra_oc_log t_interface_arq_compra_oc_log = (portalbr.dbobj.table.Interface_arq_compra_oc_log)res_Interface_arq_compra_oc_log.elementAt(i_bl_report_Interface_arq_compra_oc_log);
                      situacao = t_interface_arq_compra_oc_log.getSituacao()==null?"":t_interface_arq_compra_oc_log.getSituacao();
                      if(situacao.equals("P")){
                        descricaoSituacao="Publicado";
                      } else if(situacao.equals("C")){
                        descricaoSituacao="Última Consulta Realizada:";
                      } else if(situacao.equals("G")){
                        descricaoSituacao="Última Geração:";
                      } else if(situacao.equals("V")){
                        descricaoSituacao="Visualizações:";
                      }
                      interface_arq_compra_id = t_interface_arq_compra_oc_log.getInterface_arq_compra_id();
                      oco_numero = t_interface_arq_compra_oc_log.getOco_numero();
                      data_transacao = (java.sql.Timestamp)t_interface_arq_compra_oc_log.getData_transacao();
                      usuario = t_interface_arq_compra_oc_log.getUsuario()==null?"":t_interface_arq_compra_oc_log.getUsuario();
                      String _b0_value = (situacao==null?"":situacao);
                      if(!montouCabecalho){
                        %>
                        <tr class="reportHeader3">
                          <td colspan="5">
                            <big>
                              Ordem de Compra:
                              <%= oco_numero %>
                            </big>
                          </td>
                        </tr>
                        <%
                      montouCabecalho = true; }
                      %>
                      <%
                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                        %>
                        <tr class="reportHeader2">
                          <td colspan="4">
                            <%= descricaoSituacao %>
                          </td>
                        </tr>
                        <%
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:center;" >
                            Data
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Usuário
                          </td>

                        </tr>

                        <%
                      }
                      String style_bl_report_Interface_arq_compra_oc_log="";
                      if (!((i_bl_report_Interface_arq_compra_oc_log%2)!=0)) {
                        style_bl_report_Interface_arq_compra_oc_log="rowColor";
                      } else {
                        style_bl_report_Interface_arq_compra_oc_log="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Interface_arq_compra_oc_log %>' id="TRbl_report_Interface_arq_compra_oc_log<%=i_bl_report_Interface_arq_compra_oc_log%>" >
                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_transacao, "dd/MM/yyyy HH:mm:ss") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= usuario %>
                        </td>

                      </tr>

                      <%
                      _b0_control = _b0_value;
                      i_bl_report_Interface_arq_compra_oc_log++;
                      if (i_bl_report_Interface_arq_compra_oc_log<res_Interface_arq_compra_oc_log.size()) {
                        t_interface_arq_compra_oc_log = (portalbr.dbobj.table.Interface_arq_compra_oc_log)res_Interface_arq_compra_oc_log.elementAt(i_bl_report_Interface_arq_compra_oc_log);
                        situacao = t_interface_arq_compra_oc_log.getSituacao()==null?"":t_interface_arq_compra_oc_log.getSituacao();
                        if(situacao.equals("P")){
                          descricaoSituacao="Publicado";
                        } else if(situacao.equals("C")){
                          descricaoSituacao="Última Consulta Realizada:";
                        } else if(situacao.equals("G")){
                          descricaoSituacao="Última Geração:";
                        } else if(situacao.equals("V")){
                          descricaoSituacao="Visualizações:";
                        }
                        interface_arq_compra_id = t_interface_arq_compra_oc_log.getInterface_arq_compra_id();
                        oco_numero = t_interface_arq_compra_oc_log.getOco_numero();
                        data_transacao = (java.sql.Timestamp)t_interface_arq_compra_oc_log.getData_transacao();
                        usuario = t_interface_arq_compra_oc_log.getUsuario()==null?"":t_interface_arq_compra_oc_log.getUsuario();
                        _b0_value = (situacao==null?"":situacao);
                      } else {
                        _b0_control = "__";
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

              </form>
              <%
            }
            %>

            <html:form action="com/ArquivosOrdemCompra_lForm.do" method="post" styleClass="baseForm">

              <table style="width:99%;">
                <html:hidden property="interface_arq_compra_id"/>
                <html:hidden property="oco_numero"/>
                <html:hidden property="situacao"/>
                <html:hidden property="data_transacao"/>
                <html:hidden property="usuario"/>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
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

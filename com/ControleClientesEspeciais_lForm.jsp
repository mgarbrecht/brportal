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
              java.util.Vector res_Jw_controle_clientes_especiais_log = (java.util.Vector)session.getAttribute("res_Jw_controle_clientes_especiais_log");
              %>

              <form  name="bl_report_Jw_controle_clientes_especiais_log" id="bl_report_Jw_controle_clientes_especiais_log" class="baseForm" method="post" >
                <%
                if (res_Jw_controle_clientes_especiais_log!=null && res_Jw_controle_clientes_especiais_log.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_controle_clientes_especiais_log"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.sql.Timestamp data_log =  null;
                    java.lang.String usuario =  null;
                    java.lang.String acao =  null;
                    java.lang.String nome_coluna =  null;
                    java.lang.String old_value =  null;
                    java.lang.String new_value =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:center;" >
                        Data
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Usuário
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Ação
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Nome da Coluna
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Valor Antigo
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Valor Novo
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_controle_clientes_especiais_log = 0;
                    while (i_bl_report_Jw_controle_clientes_especiais_log<res_Jw_controle_clientes_especiais_log.size()) {
                      portalbr.dbobj.view.Jw_controle_clientes_especiais_log t_jw_controle_clientes_especiais_log = (portalbr.dbobj.view.Jw_controle_clientes_especiais_log)res_Jw_controle_clientes_especiais_log.elementAt(i_bl_report_Jw_controle_clientes_especiais_log);
                      data_log = (java.sql.Timestamp)t_jw_controle_clientes_especiais_log.getData_log();
                      usuario = t_jw_controle_clientes_especiais_log.getUsuario()==null?"":t_jw_controle_clientes_especiais_log.getUsuario();
                      acao = t_jw_controle_clientes_especiais_log.getAcao()==null?"":t_jw_controle_clientes_especiais_log.getAcao();
                      nome_coluna = t_jw_controle_clientes_especiais_log.getNome_coluna()==null?"":t_jw_controle_clientes_especiais_log.getNome_coluna();
                      old_value = t_jw_controle_clientes_especiais_log.getOld_value()==null?"":t_jw_controle_clientes_especiais_log.getOld_value();
                      new_value = t_jw_controle_clientes_especiais_log.getNew_value()==null?"":t_jw_controle_clientes_especiais_log.getNew_value();
                      String style_bl_report_Jw_controle_clientes_especiais_log="";
                      if (!((i_bl_report_Jw_controle_clientes_especiais_log%2)!=0)) {
                        style_bl_report_Jw_controle_clientes_especiais_log="rowColor";
                      } else {
                        style_bl_report_Jw_controle_clientes_especiais_log="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_controle_clientes_especiais_log %>' id="TRbl_report_Jw_controle_clientes_especiais_log<%=i_bl_report_Jw_controle_clientes_especiais_log%>" >
                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_log, "dd/MM/yyyy HH:mm:ss") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= usuario %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= acao %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= nome_coluna %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= old_value %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= new_value %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_controle_clientes_especiais_log++;
                      if (i_bl_report_Jw_controle_clientes_especiais_log<res_Jw_controle_clientes_especiais_log.size()) {
                        t_jw_controle_clientes_especiais_log = (portalbr.dbobj.view.Jw_controle_clientes_especiais_log)res_Jw_controle_clientes_especiais_log.elementAt(i_bl_report_Jw_controle_clientes_especiais_log);
                        data_log = (java.sql.Timestamp)t_jw_controle_clientes_especiais_log.getData_log();
                        usuario = t_jw_controle_clientes_especiais_log.getUsuario()==null?"":t_jw_controle_clientes_especiais_log.getUsuario();
                        acao = t_jw_controle_clientes_especiais_log.getAcao()==null?"":t_jw_controle_clientes_especiais_log.getAcao();
                        nome_coluna = t_jw_controle_clientes_especiais_log.getNome_coluna()==null?"":t_jw_controle_clientes_especiais_log.getNome_coluna();
                        old_value = t_jw_controle_clientes_especiais_log.getOld_value()==null?"":t_jw_controle_clientes_especiais_log.getOld_value();
                        new_value = t_jw_controle_clientes_especiais_log.getNew_value()==null?"":t_jw_controle_clientes_especiais_log.getNew_value();
                      } else {
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

            <html:form action="com/ControleClientesEspeciais_lForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <html:hidden property="ped_nmro"/>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
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

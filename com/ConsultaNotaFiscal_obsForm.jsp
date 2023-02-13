<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Observações
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
                </td>

              </tr>

            </table>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_nf_observacao = (java.util.Vector)session.getAttribute("res_Jw_nf_observacao");
              %>

              <form  name="bl_report_Jw_nf_observacao" id="bl_report_Jw_nf_observacao" class="baseForm" method="post" >
                <%
                if (res_Jw_nf_observacao!=null && res_Jw_nf_observacao.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_nf_observacao"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.String observacao =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Observação
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_nf_observacao = 0;
                    while (i_bl_report_Jw_nf_observacao<res_Jw_nf_observacao.size()) {
                      portalbr.dbobj.view.Jw_nf_observacao t_jw_nf_observacao = (portalbr.dbobj.view.Jw_nf_observacao)res_Jw_nf_observacao.elementAt(i_bl_report_Jw_nf_observacao);
                      observacao = t_jw_nf_observacao.getObservacao()==null?"":t_jw_nf_observacao.getObservacao();
                      String style_bl_report_Jw_nf_observacao="";
                      if (!((i_bl_report_Jw_nf_observacao%2)!=0)) {
                        style_bl_report_Jw_nf_observacao="rowColor";
                      } else {
                        style_bl_report_Jw_nf_observacao="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_nf_observacao %>' id="TRbl_report_Jw_nf_observacao<%=i_bl_report_Jw_nf_observacao%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= observacao %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_nf_observacao++;
                      if (i_bl_report_Jw_nf_observacao<res_Jw_nf_observacao.size()) {
                        t_jw_nf_observacao = (portalbr.dbobj.view.Jw_nf_observacao)res_Jw_nf_observacao.elementAt(i_bl_report_Jw_nf_observacao);
                        observacao = t_jw_nf_observacao.getObservacao()==null?"":t_jw_nf_observacao.getObservacao();
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

            <html:form action="com/ConsultaNotaFiscal_obsForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <html:hidden property="emp_empresa"/>
                <html:hidden property="fil_filial"/>
                <html:hidden property="nfs_nmro"/>
                <html:hidden property="nfs_serie"/>
                <html:hidden property="observacao"/>
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

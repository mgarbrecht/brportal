<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:100%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <%
            {
              %>

              <%
              java.util.Vector res_Jw_conhecimentos_fretes = (java.util.Vector)session.getAttribute("res_Jw_conhecimentos_fretes");
              %>

              <form  name="bl_report_Jw_conhecimentos_fretes" id="bl_report_Jw_conhecimentos_fretes" class="baseForm" method="post" >
                <%
                if (res_Jw_conhecimentos_fretes!=null && res_Jw_conhecimentos_fretes.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_conhecimentos_fretes"  class="reportTable"   style="width:100%; "  >
                    <%
                    java.sql.Date data_ocorrencia =  null;
                    java.lang.String descricao =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:center;" >
                        Data Ocorrência
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Ocorrência
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_conhecimentos_fretes = 0;
                    while (i_bl_report_Jw_conhecimentos_fretes<res_Jw_conhecimentos_fretes.size()) {
                      portalbr.dbobj.view.Jw_conhecimentos_fretes t_jw_conhecimentos_fretes = (portalbr.dbobj.view.Jw_conhecimentos_fretes)res_Jw_conhecimentos_fretes.elementAt(i_bl_report_Jw_conhecimentos_fretes);
                      data_ocorrencia = (java.sql.Date)t_jw_conhecimentos_fretes.getData_ocorrencia();
                      descricao = t_jw_conhecimentos_fretes.getDescricao()==null?"":t_jw_conhecimentos_fretes.getDescricao();
                      String style_bl_report_Jw_conhecimentos_fretes="";
                      if (!((i_bl_report_Jw_conhecimentos_fretes%2)!=0)) {
                        style_bl_report_Jw_conhecimentos_fretes="rowColor";
                      } else {
                        style_bl_report_Jw_conhecimentos_fretes="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_conhecimentos_fretes %>' id="TRbl_report_Jw_conhecimentos_fretes<%=i_bl_report_Jw_conhecimentos_fretes%>" >
                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_ocorrencia, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= descricao %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_conhecimentos_fretes++;
                      if (i_bl_report_Jw_conhecimentos_fretes<res_Jw_conhecimentos_fretes.size()) {
                        t_jw_conhecimentos_fretes = (portalbr.dbobj.view.Jw_conhecimentos_fretes)res_Jw_conhecimentos_fretes.elementAt(i_bl_report_Jw_conhecimentos_fretes);
                        data_ocorrencia = (java.sql.Date)t_jw_conhecimentos_fretes.getData_ocorrencia();
                        descricao = t_jw_conhecimentos_fretes.getDescricao()==null?"":t_jw_conhecimentos_fretes.getDescricao();
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

            <html:form action="com/ConsultaNotaFiscal_oForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:100%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:100%;">
                <html:hidden property="emp_empresa"/>
                <html:hidden property="fil_filial"/>
                <html:hidden property="nfs_nmro"/>
                <html:hidden property="nfs_serie"/>
              </table>

              <table class="buttonTable" style='width:100%;'>
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

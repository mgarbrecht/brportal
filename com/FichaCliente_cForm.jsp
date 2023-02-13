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
              java.util.Vector res_Jw_ficha_cliente_contatos = (java.util.Vector)session.getAttribute("res_Jw_ficha_cliente_contatos");
              %>

              <form  name="bl_report_Jw_ficha_cliente_contatos" id="bl_report_Jw_ficha_cliente_contatos" class="baseForm" method="post" >
                <table class="bannerTable" style="width:99%;">
                  <tr class="bannerTr">
                    <td class="bannerTd">
                      Contatos
                    </td>
                  </tr>
                </table>

                <%
                if (res_Jw_ficha_cliente_contatos!=null && res_Jw_ficha_cliente_contatos.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_ficha_cliente_contatos"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.String nome =  null;
                    java.lang.String email =  null;
                    java.lang.String tipo =  null;
                    java.sql.Date data_nascimento =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Nome
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        e-Mail
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Tipo
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Data Nascimento
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_ficha_cliente_contatos = 0;
                    while (i_bl_report_Jw_ficha_cliente_contatos<res_Jw_ficha_cliente_contatos.size()) {
                      portalbr.dbobj.view.Jw_ficha_cliente_contatos t_jw_ficha_cliente_contatos = (portalbr.dbobj.view.Jw_ficha_cliente_contatos)res_Jw_ficha_cliente_contatos.elementAt(i_bl_report_Jw_ficha_cliente_contatos);
                      nome = t_jw_ficha_cliente_contatos.getNome()==null?"":t_jw_ficha_cliente_contatos.getNome();
                      email = t_jw_ficha_cliente_contatos.getEmail()==null?"":t_jw_ficha_cliente_contatos.getEmail();
                      tipo = t_jw_ficha_cliente_contatos.getTipo()==null?"":t_jw_ficha_cliente_contatos.getTipo();
                      data_nascimento = (java.sql.Date)t_jw_ficha_cliente_contatos.getData_nascimento();
                      String style_bl_report_Jw_ficha_cliente_contatos="";
                      if (!((i_bl_report_Jw_ficha_cliente_contatos%2)!=0)) {
                        style_bl_report_Jw_ficha_cliente_contatos="rowColor";
                      } else {
                        style_bl_report_Jw_ficha_cliente_contatos="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_ficha_cliente_contatos %>' id="TRbl_report_Jw_ficha_cliente_contatos<%=i_bl_report_Jw_ficha_cliente_contatos%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= nome %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= email %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= tipo %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_nascimento, "dd/MM/yyyy") %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_ficha_cliente_contatos++;
                      if (i_bl_report_Jw_ficha_cliente_contatos<res_Jw_ficha_cliente_contatos.size()) {
                        t_jw_ficha_cliente_contatos = (portalbr.dbobj.view.Jw_ficha_cliente_contatos)res_Jw_ficha_cliente_contatos.elementAt(i_bl_report_Jw_ficha_cliente_contatos);
                        nome = t_jw_ficha_cliente_contatos.getNome()==null?"":t_jw_ficha_cliente_contatos.getNome();
                        email = t_jw_ficha_cliente_contatos.getEmail()==null?"":t_jw_ficha_cliente_contatos.getEmail();
                        tipo = t_jw_ficha_cliente_contatos.getTipo()==null?"":t_jw_ficha_cliente_contatos.getTipo();
                        data_nascimento = (java.sql.Date)t_jw_ficha_cliente_contatos.getData_nascimento();
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
            <html:form action="com/FichaCliente_cForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:100%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="buttonTable" style='width:100%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
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

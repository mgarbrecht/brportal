<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <link href="../css/style_relatorio.css" rel="stylesheet" type="text/css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Grade
    </title>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:640;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:640" >
              <tr>

                <td class="td10">
                </td>

              </tr>

            </table>

            <div align="center">
              <table id="TRbl_report_Jw_saldo_estoque_grades_g" border=1 style="background-color:#d0e1f4;" frame=box>
                <%
                int counterbl_report_Jw_saldo_estoque_grades_g=0;
                int contador =0;
                {
                  portalbr.dbobj.view.Jw_saldo_estoque_grades_g t_jw_saldo_estoque_grades_g = new portalbr.dbobj.view.Jw_saldo_estoque_grades_g();
                  java.util.Vector res_Jw_saldo_estoque_grades_g = (java.util.Vector)session.getAttribute("res_Jw_saldo_estoque_grades_g");
                  if (res_Jw_saldo_estoque_grades_g!=null && res_Jw_saldo_estoque_grades_g.size()>0) {
                    java.lang.String numero =  null;
                    java.lang.Integer quantidade =  null;
                    int i_bl_report_Jw_saldo_estoque_grades_g = 0;

                    t_jw_saldo_estoque_grades_g = (portalbr.dbobj.view.Jw_saldo_estoque_grades_g)res_Jw_saldo_estoque_grades_g.elementAt(0);
                    numero = t_jw_saldo_estoque_grades_g.getNumero()==null?"":t_jw_saldo_estoque_grades_g.getNumero();
                    if(numero.equals("0")){
                      %>
                      <h5>
                        Grade não Disponível
                      </h5>
                      <%
                    }else {
                      %>
                      <tr  style="class=rowColor">
                        <td class="reportColumn" width="20%">
                          <b>
                            Tamanho
                          </b>
                        </td>
                        <%
                        for(int x=0;x<res_Jw_saldo_estoque_grades_g.size();x++){
                          t_jw_saldo_estoque_grades_g = (portalbr.dbobj.view.Jw_saldo_estoque_grades_g)res_Jw_saldo_estoque_grades_g.elementAt(x);
                          numero = t_jw_saldo_estoque_grades_g.getNumero()==null?"":t_jw_saldo_estoque_grades_g.getNumero();
                          quantidade = t_jw_saldo_estoque_grades_g.getQuantidade();
                          %>
                          <td class="reportColumn" style="text-align:center;" width="12%">
                            <%= numero %>
                          </td>
                          <%
                        }
                        %>
                        <td class="reportColumn" style="text-align:center;"  >
                          <b>
                            Total
                          </b>
                        </td>
                      </tr>
                      <tr style="class=rowColor">
                        <td class="reportColumn" width="20%">
                          <b>
                            Quantidade
                          </b>
                        </td>
                        <%
                        for(int x=0;x<res_Jw_saldo_estoque_grades_g.size();x++){
                          t_jw_saldo_estoque_grades_g = (portalbr.dbobj.view.Jw_saldo_estoque_grades_g)res_Jw_saldo_estoque_grades_g.elementAt(x);
                          numero = t_jw_saldo_estoque_grades_g.getNumero()==null?"":t_jw_saldo_estoque_grades_g.getNumero();
                          quantidade = t_jw_saldo_estoque_grades_g.getQuantidade();
                          %>
                          <td class="reportColumn" style="text-align:center;" width="12%">
                            <%
                            contador += Integer.parseInt(quantidade+"");
                            %>
                            <%= ((quantidade!=null)?quantidade.toString():"") %>
                          </td>
                          <%
                        }
                        %>
                        <td class="reportColumn" style="text-align:center;" width="20%" >
                          <b>
                            <%= contador %>
                          </b>
                        </td>
                        <%
                      }
                    }
                    %>
                  </tr>
                  <%
                }
                %>
              </table>
            </div>
            <html:form action="com/Saldo_estoque_grades_gForm.do" method="POST" styleClass="baseForm">
              <table class="itemTable" style='width:640;'>
                <tr class="itemTableTr">
                  <td class="itemTableTd">
                    <table class="itemTable" style='width:100%;'>
                      <html:hidden property="numero"/>
                      <html:hidden property="quantidade"/>
                      <html:hidden property="emp_empresa"/>
                      <html:hidden property="fil_filial"/>
                      <html:hidden property="unn_codigo"/>
                      <html:hidden property="les_codigo"/>
                      <html:hidden property="tes_codigo"/>
                      <html:hidden property="tco_codigo"/>
                      <html:hidden property="gde_codigo"/>
                      <html:hidden property="lin_cdgo"/>
                      <html:hidden property="ref_cdgo"/>
                      <html:hidden property="cab_cdgo"/>
                      <html:hidden property="cor_cdgo"/>
                    </table>
                  </td>
                  <td>
                    <table style='width:640;'>
                      <tr align="center" >
                        <td align="center">
                          <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                            <bean:message bundle="ApplicationResources" key="jsp.close"/>
                          </html:button>
                        </td>
                      </tr>
                    </table>
                  </td>
                </tr>
              </table>
              <table style='width:640;'>
                <tr>
                  <td>
                    <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
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

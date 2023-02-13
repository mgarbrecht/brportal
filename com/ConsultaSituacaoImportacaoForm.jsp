<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta Situação da Importação
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
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(268)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_consulta_situacao_importacao = null;
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                j = new com.egen.util.jdbc.JdbcUtil();
                portalbr.dbobj.view.Jw_consulta_situacao_importacao t_jw_consulta_situacao_importacao = new portalbr.dbobj.view.Jw_consulta_situacao_importacao();
                String[][] select = {{"tipo",null},{"pares",null},{"valor",null},};
                Object[][] where = null;
                String[] groupby =  null;
                String[] having =  null;
                String[] order =  null;
                res_Jw_consulta_situacao_importacao = j.select(t_jw_consulta_situacao_importacao,select,where,groupby,having,order);
              } catch (Exception e){
                session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                %>
                <jsp:forward page="/system/ErrorPage.jsp"/>
                <%
              } finally {
              if(j!=null){j.close();}
            }
            %>

            <form  name="bl_report_Jw_consulta_situacao_importacao" id="bl_report_Jw_consulta_situacao_importacao" class="baseForm" method="post" >
              <%
              if (res_Jw_consulta_situacao_importacao!=null && res_Jw_consulta_situacao_importacao.size()>0) {
                %>

                <table id="TRbl_report_Jw_consulta_situacao_importacao"  class="reportTable"   style="width:99%; "  border="1" >
                  <%
                  java.lang.String tipo =  null;
                  java.lang.Integer pares =  null;
                  double valor =  0;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:left;" >
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Pares
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Valor
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Jw_consulta_situacao_importacao = 0;
                  while (i_bl_report_Jw_consulta_situacao_importacao<res_Jw_consulta_situacao_importacao.size()) {
                    portalbr.dbobj.view.Jw_consulta_situacao_importacao t_jw_consulta_situacao_importacao = (portalbr.dbobj.view.Jw_consulta_situacao_importacao)res_Jw_consulta_situacao_importacao.elementAt(i_bl_report_Jw_consulta_situacao_importacao);
                    tipo = t_jw_consulta_situacao_importacao.getTipo()==null?"":t_jw_consulta_situacao_importacao.getTipo();
                    pares = t_jw_consulta_situacao_importacao.getPares();
                    valor = t_jw_consulta_situacao_importacao.getValor();
                    String style_bl_report_Jw_consulta_situacao_importacao="";
                    if (!((i_bl_report_Jw_consulta_situacao_importacao%2)!=0)) {
                      style_bl_report_Jw_consulta_situacao_importacao="rowColor";
                    } else {
                      style_bl_report_Jw_consulta_situacao_importacao="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Jw_consulta_situacao_importacao %>' id="TRbl_report_Jw_consulta_situacao_importacao<%=i_bl_report_Jw_consulta_situacao_importacao%>" >
                      <td class="reportColumn" style="text-align:left;" >
                        <%= tipo %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= com.egen.util.text.FormatNumber.format(pares, "##,##0") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= com.egen.util.text.FormatNumber.format(valor, "##,##0.00") %>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Jw_consulta_situacao_importacao++;
                    if (i_bl_report_Jw_consulta_situacao_importacao<res_Jw_consulta_situacao_importacao.size()) {
                      t_jw_consulta_situacao_importacao = (portalbr.dbobj.view.Jw_consulta_situacao_importacao)res_Jw_consulta_situacao_importacao.elementAt(i_bl_report_Jw_consulta_situacao_importacao);
                      tipo = t_jw_consulta_situacao_importacao.getTipo()==null?"":t_jw_consulta_situacao_importacao.getTipo();
                      pares = t_jw_consulta_situacao_importacao.getPares();
                      valor = t_jw_consulta_situacao_importacao.getValor();
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

        </td>
      </tr>
    </table>

  </body>
</center>
</html>

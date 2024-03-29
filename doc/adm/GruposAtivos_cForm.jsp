<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page  extends='acesso.web.HttpJspSessao' %>
<html>
  <head>

    <title>
      Clientes do Grupo :
      <%= request.getParameter("grupo") %>
    </title>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:99%;'>
        <tr>
          <td>
            <table   class="headerTable" style="width:99%" >
              <tr>
                <td class='td10'>
                  <%@ include file="../system/header_data.jsp" %>
                </td>
              </tr>
            </table>
            <%
            {
              %>
              <form class="baseForm" >
                <table id="TRbl_report_Jw_clientes_por_grupo" class="reportTable" style=width:99%;  border=1  frame=box>
                  <%
                  int counterbl_report_Jw_clientes_por_grupo=0;
                  com.egen.util.jdbc.JdbcUtil j = null;
                  try {
                    j = new com.egen.util.jdbc.JdbcUtil("wbrio","wbrio",util.rdb.ConnectionJDBC.getJdbcURL("orasco"),util.rdb.ConnectionJDBC.getJdbcDriver("orasco"));
                    portalbr.dbobj.view.Jw_clientes_por_grupo t_jw_clientes_por_grupo = new portalbr.dbobj.view.Jw_clientes_por_grupo();
                    java.util.Vector res_Jw_clientes_por_grupo = (java.util.Vector)session.getAttribute("res_Jw_clientes_por_grupo");
                    if (res_Jw_clientes_por_grupo!=null && res_Jw_clientes_por_grupo.size()>0) {
                      java.lang.String cli_cdgo =  null;
                      java.lang.String cli_nome =  null;
                      java.lang.String cli_rzao =  null;
                      java.lang.String data_ultima_compra =  null;
                      int i_bl_report_Jw_clientes_por_grupo = 0;
                      t_jw_clientes_por_grupo = (portalbr.dbobj.view.Jw_clientes_por_grupo)res_Jw_clientes_por_grupo.elementAt(i_bl_report_Jw_clientes_por_grupo);
                      cli_cdgo = t_jw_clientes_por_grupo.getCli_cdgo()==null?"":t_jw_clientes_por_grupo.getCli_cdgo();
                      cli_nome = t_jw_clientes_por_grupo.getCli_nome()==null?"":t_jw_clientes_por_grupo.getCli_nome();
                      cli_rzao = t_jw_clientes_por_grupo.getCli_rzao()==null?"":t_jw_clientes_por_grupo.getCli_rzao();
                      data_ultima_compra = t_jw_clientes_por_grupo.getData_ultima_compra()==null?"":t_jw_clientes_por_grupo.getData_ultima_compra();
                      portalbr.adm.Cidades cid = new portalbr.adm.Cidades();
                      %>
                      <tr class="reportHeader3" >
                        <td class="columnTdHeader" style="text-align:left;">
                          C�digo
                        </td>
                        <td class="columnTdHeader" style="text-align:left;">
                          Nome
                        </td>
                        <td class="columnTdHeader" style="text-align:left;">
                          Raz�o Social
                        </td>
                        <td class="columnTdHeader" style="text-align:left;">
                          Cidade
                        </td>
                        <td class="columnTdHeader" style="text-align:center;">
                          Data �ltima Compra
                        </td>
                      </tr>
                      <%
                      while (i_bl_report_Jw_clientes_por_grupo<res_Jw_clientes_por_grupo.size()){
                        counterbl_report_Jw_clientes_por_grupo++;
                        String style="";
                        if (!((i_bl_report_Jw_clientes_por_grupo%2)!=0)) {
                          style="class=rowColor";
                        } else {
                          style="class=rowBlank";
                        }
                        %>
                        <tr <%= style %> id='TRbl_report_Jw_clientes_por_grupo<%=counterbl_report_Jw_clientes_por_grupo%>' >
                          <td class="reportColumn" style="text-align:left;">
                            <%= cli_cdgo %>
                          </td>
                          <td class="reportColumn" style="text-align:left;">
                            <%= cli_nome %>
                          </td>
                          <td class="reportColumn" style="text-align:left;">
                            <%= cli_rzao %>
                          </td>
                          <td class="reportColumn" style="text-align:left;">
                            <%= cid.retornaCidades(cli_cdgo+"",j.getConn()) %>
                          </td>
                          <td class="reportColumn" style="text-align:center;">
                            <%= data_ultima_compra %>
                          </td>
                        </tr>
                        <%
                        if (++i_bl_report_Jw_clientes_por_grupo >= res_Jw_clientes_por_grupo.size()) {
                          break;
                        }
                        t_jw_clientes_por_grupo = (portalbr.dbobj.view.Jw_clientes_por_grupo)res_Jw_clientes_por_grupo.elementAt(i_bl_report_Jw_clientes_por_grupo);
                        cli_cdgo = t_jw_clientes_por_grupo.getCli_cdgo()==null?"":t_jw_clientes_por_grupo.getCli_cdgo();
                        cli_nome = t_jw_clientes_por_grupo.getCli_nome()==null?"":t_jw_clientes_por_grupo.getCli_nome();
                        cli_rzao = t_jw_clientes_por_grupo.getCli_rzao()==null?"":t_jw_clientes_por_grupo.getCli_rzao();
                        data_ultima_compra = t_jw_clientes_por_grupo.getData_ultima_compra()==null?"":t_jw_clientes_por_grupo.getData_ultima_compra();
                      }
                    }
                  } finally {
                  if(j!=null){j.close();}
                }
                %>
              </table>
            </form>
            <%
          }
          %>
          <html:form action="adm/GruposAtivos_cForm.do" method="POST" styleClass="baseForm">
            <table class="itemTable" style='width:;'>
              <%
              com.egen.util.jdbc.JdbcUtil connection = null;
              try {
                if(!user.isSuperUsuario()){
                  connection = new com.egen.util.jdbc.JdbcUtil("wbrio","wbrio",util.rdb.ConnectionJDBC.getJdbcURL("orasco"),util.rdb.ConnectionJDBC.getJdbcDriver("orasco"));
                  portalbr.dbobj.view.Jw_permissoes table = new portalbr.dbobj.view.Jw_permissoes();
                  String[][] select = null;
                  Object[][] where = {
                    {"Usua_usuario","like", user.getUsuario()},
                  {"Acdi_doin_id","=","58"}
                  };
                  Vector res_Jw_permissoes = connection.select(table, select, where, null, null, null);
                  if (res_Jw_permissoes != null && res_Jw_permissoes.size() == 0) {
                    %>
                    <script>
                      top.location='../system/Error.jsp';
                    </script>
                    <%
                  }
                }

              } catch (Exception e) {
                throw e;
              } finally {
                if (connection != null) {
                  connection.close();
                }
              }
              %>
              <html:hidden property="gre_grupo"/>
              <html:hidden property="grupo"/>
            </table>
            <table class="buttonTable" style='width:99%;'>
              <tr>
                <td class="buttonItem">
                  <html:submit styleClass="myhidden" property="select_action">
                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                  </html:submit>
                  <html:button accesskey="a" onclick="history.go(-1);" styleClass="baseButton" property="back_action">
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

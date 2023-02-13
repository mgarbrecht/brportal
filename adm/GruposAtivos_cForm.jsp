<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Clientes do Grupo :
      <%=(String)(request.getParameter("grupo")+"").replace('*','&') %>
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
                  <%@ include file="../system/header_data.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(58)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Jw_clientes_por_grupo" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_clientes_por_grupo=0;
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                j = new com.egen.util.jdbc.JdbcUtil();
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
                  util.consultas.Cidades cid = new util.consultas.Cidades();
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:left;">
                      Código
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Nome
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Razão Social
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Cidade
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Data Última Compra
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
                        <%= cid.retornaCidades(cli_cdgo+"") %>
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
                if(j!=null){
                  j.close();
                  j = null;
                }
              }
              %>
            </table>
            <html:form action="adm/GruposAtivos_cForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <html:hidden property="gre_grupo"/>
                <html:hidden property="grupo"/>
                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
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

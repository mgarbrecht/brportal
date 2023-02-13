<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Clientes Ativos
      <%= (String)(request.getParameter("cab")+"").replace('*','&') %>
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

            <table id="TRbl_report_Jw_clientes_ativos" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_clientes_ativos=0;
              {
                portalbr.dbobj.view.Jw_clientes_ativos t_jw_clientes_ativos = new portalbr.dbobj.view.Jw_clientes_ativos();
                java.util.Vector res_Jw_clientes_ativos = (java.util.Vector)session.getAttribute("res_Jw_clientes_ativos");
                if (res_Jw_clientes_ativos!=null && res_Jw_clientes_ativos.size()>0) {
                  java.lang.String cli_cdgo =  null;
                  java.lang.String cli_nome =  null;
                  java.lang.String cli_rzao =  null;
                  java.lang.String cidade =  null;
                  java.lang.String email =  null;
                  int i_bl_report_Jw_clientes_ativos = 0;
                  t_jw_clientes_ativos = (portalbr.dbobj.view.Jw_clientes_ativos)res_Jw_clientes_ativos.elementAt(i_bl_report_Jw_clientes_ativos);
                  cli_cdgo = t_jw_clientes_ativos.getCli_cdgo()==null?"":t_jw_clientes_ativos.getCli_cdgo();
                  cli_nome = t_jw_clientes_ativos.getCli_nome()==null?"":t_jw_clientes_ativos.getCli_nome();
                  cli_rzao = t_jw_clientes_ativos.getCli_rzao()==null?"":t_jw_clientes_ativos.getCli_rzao();
                  cidade = t_jw_clientes_ativos.getCidade()==null?"":t_jw_clientes_ativos.getCidade();
                  email = t_jw_clientes_ativos.getEmail()==null?"":t_jw_clientes_ativos.getEmail();
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
                    <td class="columnTdHeader" style="text-align:left;">
                      Email
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Jw_clientes_ativos<res_Jw_clientes_ativos.size()){
                    counterbl_report_Jw_clientes_ativos++;
                    String style="";
                    if (!((i_bl_report_Jw_clientes_ativos%2)!=0)) {
                      style="class=rowColor";
                    } else {
                      style="class=rowBlank";
                    }
                    %>
                    <tr <%= style %> id='TRbl_report_Jw_clientes_ativos<%=counterbl_report_Jw_clientes_ativos%>' >
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
                        <%= cidade %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= email %>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Jw_clientes_ativos >= res_Jw_clientes_ativos.size()) {
                      break;
                    }
                    t_jw_clientes_ativos = (portalbr.dbobj.view.Jw_clientes_ativos)res_Jw_clientes_ativos.elementAt(i_bl_report_Jw_clientes_ativos);
                    cli_cdgo = t_jw_clientes_ativos.getCli_cdgo()==null?"":t_jw_clientes_ativos.getCli_cdgo();
                    cli_nome = t_jw_clientes_ativos.getCli_nome()==null?"":t_jw_clientes_ativos.getCli_nome();
                    cli_rzao = t_jw_clientes_ativos.getCli_rzao()==null?"":t_jw_clientes_ativos.getCli_rzao();
                    cidade = t_jw_clientes_ativos.getCidade()==null?"":t_jw_clientes_ativos.getCidade();
                    email = t_jw_clientes_ativos.getEmail()==null?"":t_jw_clientes_ativos.getEmail();
                  }
                }
              }
              %>
            </table>
            <html:form action="adm/Clientes_ativosForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <html:hidden property="cli_cdgo"/>
                <html:hidden property="rep_cdgo"/>
                <html:hidden property="codigo_regional"/>
                <html:hidden property="codigo_marca"/>
                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <html:submit styleClass="myhidden" property="select_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:submit>
                        <%
                      }
                      %>
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <html:button accesskey="b" onclick="history.go(-1);" styleClass="baseButton" property="back_action">
                          <bean:message bundle="ApplicationResources" key="jsp.back"/>
                        </html:button>
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

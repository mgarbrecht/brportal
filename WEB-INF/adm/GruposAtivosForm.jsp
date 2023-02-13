<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Grupos Ativos
      <%= (String)(request.getParameter("grupo")+"").replace('*','&') %>
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

            <table id="TRbl_report_Jw_grupos_ativos" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_grupos_ativos=0;
              {
                portalbr.dbobj.view.Jw_grupos_ativos t_jw_grupos_ativos = new portalbr.dbobj.view.Jw_grupos_ativos();
                java.util.Vector res_Jw_grupos_ativos = (java.util.Vector)session.getAttribute("res_Jw_grupos_ativos");
                if (res_Jw_grupos_ativos!=null && res_Jw_grupos_ativos.size()>0) {
                  java.lang.String gre_grupo       =  null;
                  java.lang.String gre_descricao   =  null;
                  int i_bl_report_Jw_grupos_ativos =  0;

                  t_jw_grupos_ativos = (portalbr.dbobj.view.Jw_grupos_ativos)res_Jw_grupos_ativos.elementAt(i_bl_report_Jw_grupos_ativos);
                  gre_grupo     = t_jw_grupos_ativos.getGre_grupo()==null?"":t_jw_grupos_ativos.getGre_grupo();
                  gre_descricao = t_jw_grupos_ativos.getGre_descricao()==null?"":t_jw_grupos_ativos.getGre_descricao();
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:left;">
                      Código
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Descrição
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Jw_grupos_ativos<res_Jw_grupos_ativos.size()){
                    counterbl_report_Jw_grupos_ativos++;
                    String style="";
                    if (!((i_bl_report_Jw_grupos_ativos%2)!=0)) {
                      style="class=rowColor";
                    } else {
                      style="class=rowBlank";
                    }
                    %>
                    <tr <%= style %> id='TRbl_report_Jw_grupos_ativos<%=counterbl_report_Jw_grupos_ativos%>' >
                      <td class="reportColumn" style="text-align:left;">
                        <%= gre_grupo %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <a href="../adm/GruposAtivos_cForm.do?select_action=&gre_grupo=<%= gre_grupo %>&grupo=<%= gre_grupo %>-<%= gre_descricao %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                            <%= gre_descricao %>
                          </a>
                          <%
                        } else {
                          %>
                          <%= gre_descricao %>
                          <%
                        }
                        %>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Jw_grupos_ativos >= res_Jw_grupos_ativos.size()) {
                      break;
                    }
                    t_jw_grupos_ativos = (portalbr.dbobj.view.Jw_grupos_ativos)res_Jw_grupos_ativos.elementAt(i_bl_report_Jw_grupos_ativos);
                    gre_grupo     = t_jw_grupos_ativos.getGre_grupo()==null?"":t_jw_grupos_ativos.getGre_grupo();
                    gre_descricao = t_jw_grupos_ativos.getGre_descricao()==null?"":t_jw_grupos_ativos.getGre_descricao();
                  }
                }
              }
              %>
            </table>
            <html:form action="adm/GruposAtivosForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <html:hidden property="cod_marca"/>
                <html:hidden property="cod_regional"/>
                <html:hidden property="cod_rep"/>
                <html:hidden property="grupo"/>
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
                      <html:button accesskey="b" onclick="history.go(-1);" styleClass="baseButton" property="back_action">
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

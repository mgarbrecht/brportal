<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta Alteração de Usuários
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
                  <%@ include file="../system/header_excel.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(254)){
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
              java.util.Vector res_Jw_usuarios_alteracao = (java.util.Vector)session.getAttribute("res_Jw_usuarios_alteracao");
              %>

              <form  name="bl_report_Jw_usuarios_alteracao" id="bl_report_Jw_usuarios_alteracao" class="baseForm" method="post" >
                <%
                if (res_Jw_usuarios_alteracao!=null && res_Jw_usuarios_alteracao.size()>0) {
                  if ( ((String)request.getParameter("_ordered"))!=null && ((String)request.getParameter("_ordered")).length()>0 ) {
                    boolean reverse = false;
                    if ( ((String)request.getParameter("_reverse"))!=null && ((String)request.getParameter("_reverse")).equals("true") ){
                      reverse = true;
                    }
                    try {
                      res_Jw_usuarios_alteracao = com.egen.util.text.Sort.execute(res_Jw_usuarios_alteracao,((String)request.getParameter("_ordered")),reverse);
                      session.setAttribute("res_Jw_usuarios_alteracao", res_Jw_usuarios_alteracao);
                    } catch (Exception e) {}
                  }
                  %>

                  <table id="TRbl_report_Jw_usuarios_alteracao"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.String usuario =  null;
                    java.lang.String nome =  null;
                    java.sql.Timestamp data_alteracao =  null;
                    java.lang.String usuario_alteracao =  null;
                    %>

                    <%
                    if(!(request.getParameter("excel")+"").equals("true")){
                      %>
                      <tr class="reportTr">
                        <td class="columnTdHeader" style="text-align:left;" >
                          Usuário
                          <%
                          if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                            %>
                            <a href='ConsultaUsuariosAlteracao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","usuario")%>' class="reportOrder">
                              <bean:message key="report.orderedasc"/>
                            </a>
                            <%
                          } else {
                            %>
                            <a href='ConsultaUsuariosAlteracao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","usuario")%>' class="reportOrder">
                              <bean:message key="report.ordereddesc"/>
                            </a>
                            <%
                          }
                          %>
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Nome
                          <%
                          if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                            %>
                            <a href='ConsultaUsuariosAlteracao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","nome")%>' class="reportOrder">
                              <bean:message key="report.orderedasc"/>
                            </a>
                            <%
                          } else {
                            %>
                            <a href='ConsultaUsuariosAlteracao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","nome")%>' class="reportOrder">
                              <bean:message key="report.ordereddesc"/>
                            </a>
                            <%
                          }
                          %>
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Dt. Alteração
                          <%
                          if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                            %>
                            <a href='ConsultaUsuariosAlteracao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","data_alteracao")%>' class="reportOrder">
                              <bean:message key="report.orderedasc"/>
                            </a>
                            <%
                          } else {
                            %>
                            <a href='ConsultaUsuariosAlteracao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","data_alteracao")%>' class="reportOrder">
                              <bean:message key="report.ordereddesc"/>
                            </a>
                            <%
                          }
                          %>
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Usuário Alteração
                          <%
                          if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                            %>
                            <a href='ConsultaUsuariosAlteracao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","usuario_alteracao")%>' class="reportOrder">
                              <bean:message key="report.orderedasc"/>
                            </a>
                            <%
                          } else {
                            %>
                            <a href='ConsultaUsuariosAlteracao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","usuario_alteracao")%>' class="reportOrder">
                              <bean:message key="report.ordereddesc"/>
                            </a>
                            <%
                          }
                          %>
                        </td>

                      </tr>
                      <%
                    } else {
                      %>

                      <tr class="reportTr">
                        <td class="columnTdHeader" style="text-align:left;" >
                          Usuário
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Nome
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Dt. Alteração
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Usuário Alteração
                        </td>

                      </tr>


                      <%
                    }
                    %>

                    <%
                    int i_bl_report_Jw_usuarios_alteracao = 0;
                    while (i_bl_report_Jw_usuarios_alteracao<res_Jw_usuarios_alteracao.size()) {
                      portalbr.dbobj.view.Jw_usuarios_alteracao t_jw_usuarios_alteracao = (portalbr.dbobj.view.Jw_usuarios_alteracao)res_Jw_usuarios_alteracao.elementAt(i_bl_report_Jw_usuarios_alteracao);
                      usuario = t_jw_usuarios_alteracao.getUsuario()==null?"":t_jw_usuarios_alteracao.getUsuario();
                      nome = t_jw_usuarios_alteracao.getNome()==null?"":t_jw_usuarios_alteracao.getNome();
                      data_alteracao = (java.sql.Timestamp)t_jw_usuarios_alteracao.getData_alteracao();
                      usuario_alteracao = t_jw_usuarios_alteracao.getUsuario_alteracao()==null?"":t_jw_usuarios_alteracao.getUsuario_alteracao();
                      String style_bl_report_Jw_usuarios_alteracao="";
                      if (!((i_bl_report_Jw_usuarios_alteracao%2)!=0)) {
                        style_bl_report_Jw_usuarios_alteracao="rowColor";
                      } else {
                        style_bl_report_Jw_usuarios_alteracao="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_usuarios_alteracao %>' id="TRbl_report_Jw_usuarios_alteracao<%=i_bl_report_Jw_usuarios_alteracao%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= usuario %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= nome %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_alteracao, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= usuario_alteracao %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_usuarios_alteracao++;
                      if (i_bl_report_Jw_usuarios_alteracao<res_Jw_usuarios_alteracao.size()) {
                        t_jw_usuarios_alteracao = (portalbr.dbobj.view.Jw_usuarios_alteracao)res_Jw_usuarios_alteracao.elementAt(i_bl_report_Jw_usuarios_alteracao);
                        usuario = t_jw_usuarios_alteracao.getUsuario()==null?"":t_jw_usuarios_alteracao.getUsuario();
                        nome = t_jw_usuarios_alteracao.getNome()==null?"":t_jw_usuarios_alteracao.getNome();
                        data_alteracao = (java.sql.Timestamp)t_jw_usuarios_alteracao.getData_alteracao();
                        usuario_alteracao = t_jw_usuarios_alteracao.getUsuario_alteracao()==null?"":t_jw_usuarios_alteracao.getUsuario_alteracao();
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

            <html:form action="acesso/ConsultaUsuariosAlteracao_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <%
                    if(!(request.getParameter("excel")+"").equals("true")){
                      %>
                      <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                        <bean:message bundle="ApplicationResources" key="jsp.back"/>
                      </html:submit>
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

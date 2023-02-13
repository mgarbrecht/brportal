<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta dos Últimos Acessos dos Analistas de Mercado
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
                  <%@ include file="../system/header_sem_ajuda.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(101)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/UltimoAcessoAnalistaForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="situacao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_ultimo_acesso_analista"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situação
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="situacao" onchange="select_action.click();" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="null">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="A">
                        Ativos
                      </html:option>
                      <html:option styleClass="baseOption" value="I">
                        Inativos
                      </html:option>
                    </html:select>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit onclick="bloqueia();" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <%
            {
              %>

              <%
              java.util.Vector res_Jw_ultimo_acesso_analista = (java.util.Vector)session.getAttribute("res_Jw_ultimo_acesso_analista");
              %>

              <%
              if (res_Jw_ultimo_acesso_analista!=null && res_Jw_ultimo_acesso_analista.size()>0) {
                %>

                <table id="TRbl_report_Jw_ultimo_acesso_analista"  class="reportTable"   style="width:99%; "  border="1"  frame="box">
                  <%
                  java.lang.String rep_cdgo =  null;
                  java.lang.String rep_rzao =  null;
                  java.sql.Timestamp data_ultimo_acesso =  null;
                  java.lang.String rep_situ =  null;
                  java.lang.String situacao =  null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:left;" >
                      Código
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Nome
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      Data Último Acesso
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      Situação
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Jw_ultimo_acesso_analista = 0;
                  while (i_bl_report_Jw_ultimo_acesso_analista<res_Jw_ultimo_acesso_analista.size()) {
                    portalbr.dbobj.view.Jw_ultimo_acesso_analista t_jw_ultimo_acesso_analista = (portalbr.dbobj.view.Jw_ultimo_acesso_analista)res_Jw_ultimo_acesso_analista.elementAt(i_bl_report_Jw_ultimo_acesso_analista);
                    rep_cdgo = t_jw_ultimo_acesso_analista.getRep_cdgo()==null?"":t_jw_ultimo_acesso_analista.getRep_cdgo();
                    rep_rzao = t_jw_ultimo_acesso_analista.getRep_rzao()==null?"":t_jw_ultimo_acesso_analista.getRep_rzao();
                    data_ultimo_acesso = (java.sql.Timestamp)t_jw_ultimo_acesso_analista.getData_ultimo_acesso();
                    rep_situ = t_jw_ultimo_acesso_analista.getRep_situ()==null?"":t_jw_ultimo_acesso_analista.getRep_situ();
                    situacao = ""; if(rep_situ.equals("A")){situacao="Ativo";}else{situacao="Inativo";};
                    String style_bl_report_Jw_ultimo_acesso_analista="";
                    if (!((i_bl_report_Jw_ultimo_acesso_analista%2)!=0)) {
                      style_bl_report_Jw_ultimo_acesso_analista="rowColor";
                    } else {
                      style_bl_report_Jw_ultimo_acesso_analista="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Jw_ultimo_acesso_analista %>' id="TRbl_report_Jw_ultimo_acesso_analista<%=i_bl_report_Jw_ultimo_acesso_analista%>" >
                      <td class="reportColumn" style="text-align:left;" >
                        <%= rep_cdgo %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= rep_rzao %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" >
                        <%= com.egen.util.text.FormatDate.format(data_ultimo_acesso, "dd/MM/yyyy HH:mm") %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" >
                        <%= situacao %>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Jw_ultimo_acesso_analista++;
                    if (i_bl_report_Jw_ultimo_acesso_analista<res_Jw_ultimo_acesso_analista.size()) {
                      t_jw_ultimo_acesso_analista = (portalbr.dbobj.view.Jw_ultimo_acesso_analista)res_Jw_ultimo_acesso_analista.elementAt(i_bl_report_Jw_ultimo_acesso_analista);
                      rep_cdgo = t_jw_ultimo_acesso_analista.getRep_cdgo()==null?"":t_jw_ultimo_acesso_analista.getRep_cdgo();
                      rep_rzao = t_jw_ultimo_acesso_analista.getRep_rzao()==null?"":t_jw_ultimo_acesso_analista.getRep_rzao();
                      data_ultimo_acesso = (java.sql.Timestamp)t_jw_ultimo_acesso_analista.getData_ultimo_acesso();
                      rep_situ = t_jw_ultimo_acesso_analista.getRep_situ()==null?"":t_jw_ultimo_acesso_analista.getRep_situ();
                      situacao = ""; if(rep_situ.equals("A")){situacao="Ativo";}else{situacao="Inativo";};
                    } else {
                    }
                  }
                  %>

                </table>

                <%
              }
              %>

              <%
            }
            %>

          </td>
        </tr>
      </table>

    </body>
  </center>
</html>

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta dos Últimos Acessos dos Clientes
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(102)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/UltimoAcessoForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="situacao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_ultimo_acesso"/>
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
              java.util.Vector res_Jw_ultimo_acesso = (java.util.Vector)session.getAttribute("res_Jw_ultimo_acesso");
              %>

              <%
              if (res_Jw_ultimo_acesso!=null && res_Jw_ultimo_acesso.size()>0) {
                %>

                <table id="TRbl_report_Jw_ultimo_acesso"  class="reportTable"   style="width:99%; "  border="1"  frame="box">
                  <%
                  java.lang.Integer cli =  null;
                  java.lang.String razao =  null;
                  java.sql.Timestamp data_ultimo =  null;
                  java.lang.String cli_situ =  null;
                  java.lang.String situacao =  null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:right;" >
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
                  int i_bl_report_Jw_ultimo_acesso = 0;
                  while (i_bl_report_Jw_ultimo_acesso<res_Jw_ultimo_acesso.size()) {
                    portalbr.dbobj.view.Jw_ultimo_acesso t_jw_ultimo_acesso = (portalbr.dbobj.view.Jw_ultimo_acesso)res_Jw_ultimo_acesso.elementAt(i_bl_report_Jw_ultimo_acesso);
                    cli = t_jw_ultimo_acesso.getCli();
                    razao = t_jw_ultimo_acesso.getRazao()==null?"":t_jw_ultimo_acesso.getRazao();
                    data_ultimo = (java.sql.Timestamp)t_jw_ultimo_acesso.getData_ultimo();
                    cli_situ = t_jw_ultimo_acesso.getCli_situ()==null?"":t_jw_ultimo_acesso.getCli_situ();
                    situacao = "";if(cli_situ.equals("A")){situacao="Ativo";}else{situacao="Inativo";};
                    String style_bl_report_Jw_ultimo_acesso="";
                    if (!((i_bl_report_Jw_ultimo_acesso%2)!=0)) {
                      style_bl_report_Jw_ultimo_acesso="rowColor";
                    } else {
                      style_bl_report_Jw_ultimo_acesso="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Jw_ultimo_acesso %>' id="TRbl_report_Jw_ultimo_acesso<%=i_bl_report_Jw_ultimo_acesso%>" >
                      <td class="reportColumn" style="text-align:right;" >
                        <%= ((cli!=null)?cli.toString():"") %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= razao %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" >
                        <%= com.egen.util.text.FormatDate.format(data_ultimo, "dd/MM/yyyy HH:mm:ss") %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" >
                        <%= situacao %>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Jw_ultimo_acesso++;
                    if (i_bl_report_Jw_ultimo_acesso<res_Jw_ultimo_acesso.size()) {
                      t_jw_ultimo_acesso = (portalbr.dbobj.view.Jw_ultimo_acesso)res_Jw_ultimo_acesso.elementAt(i_bl_report_Jw_ultimo_acesso);
                      cli = t_jw_ultimo_acesso.getCli();
                      razao = t_jw_ultimo_acesso.getRazao()==null?"":t_jw_ultimo_acesso.getRazao();
                      data_ultimo = (java.sql.Timestamp)t_jw_ultimo_acesso.getData_ultimo();
                      cli_situ = t_jw_ultimo_acesso.getCli_situ()==null?"":t_jw_ultimo_acesso.getCli_situ();
                      situacao = "";if(cli_situ.equals("A")){situacao="Ativo";}else{situacao="Inativo";};
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

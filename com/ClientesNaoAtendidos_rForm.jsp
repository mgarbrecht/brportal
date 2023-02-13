<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Relatório de Clientes Não Atendidos
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(155)){
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
              java.util.Vector res_Jw_consulta_clientes_nao_atendidos = (java.util.Vector)session.getAttribute("res_Jw_consulta_clientes_nao_atendidos");
              %>

              <form  name="bl_report_Jw_consulta_clientes_nao_atendidos" id="bl_report_Jw_consulta_clientes_nao_atendidos" class="baseForm" method="post" >
                <%
                if (res_Jw_consulta_clientes_nao_atendidos!=null && res_Jw_consulta_clientes_nao_atendidos.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_consulta_clientes_nao_atendidos"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    int cli_cdgo =  0;
                    int esc_seqn =  0;
                    java.lang.String cli_nome =  null;
                    java.lang.String cli_rzao =  null;
                    java.lang.String cnpj =  null;
                    java.lang.String cidade =  null;
                    java.lang.String uf =  null;
                    java.lang.String endereco =  null;
                    java.sql.Timestamp cli_dult =  null;
                    double limite_credito =  0;
                    java.lang.String fone =  null;
                    java.lang.String esc_email =  null;
                    java.lang.String grupo_economico =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Código
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Seq
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Nome
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Rzão Social
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        CNPJ
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Cidade
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        UF
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Endereço
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Última Compra
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Limite Crédito
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Fone
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        E-mail
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Grupo Econômico
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_consulta_clientes_nao_atendidos = 0;
                    while (i_bl_report_Jw_consulta_clientes_nao_atendidos<res_Jw_consulta_clientes_nao_atendidos.size()) {
                      portalbr.dbobj.view.Jw_consulta_clientes_nao_atendidos t_jw_consulta_clientes_nao_atendidos = (portalbr.dbobj.view.Jw_consulta_clientes_nao_atendidos)res_Jw_consulta_clientes_nao_atendidos.elementAt(i_bl_report_Jw_consulta_clientes_nao_atendidos);
                      cli_cdgo = t_jw_consulta_clientes_nao_atendidos.getCli_cdgo();
                      esc_seqn = t_jw_consulta_clientes_nao_atendidos.getEsc_seqn();
                      cli_nome = t_jw_consulta_clientes_nao_atendidos.getCli_nome()==null?"":t_jw_consulta_clientes_nao_atendidos.getCli_nome();
                      cli_rzao = t_jw_consulta_clientes_nao_atendidos.getCli_rzao()==null?"":t_jw_consulta_clientes_nao_atendidos.getCli_rzao();
                      cnpj = t_jw_consulta_clientes_nao_atendidos.getCnpj()==null?"":t_jw_consulta_clientes_nao_atendidos.getCnpj();
                      cidade = t_jw_consulta_clientes_nao_atendidos.getCidade()==null?"":t_jw_consulta_clientes_nao_atendidos.getCidade();
                      uf = t_jw_consulta_clientes_nao_atendidos.getUf()==null?"":t_jw_consulta_clientes_nao_atendidos.getUf();
                      endereco = t_jw_consulta_clientes_nao_atendidos.getEndereco()==null?"":t_jw_consulta_clientes_nao_atendidos.getEndereco();
                      cli_dult = (java.sql.Timestamp)t_jw_consulta_clientes_nao_atendidos.getCli_dult();
                      limite_credito = t_jw_consulta_clientes_nao_atendidos.getLimite_credito();
                      fone = t_jw_consulta_clientes_nao_atendidos.getFone()==null?"":t_jw_consulta_clientes_nao_atendidos.getFone();
                      esc_email = t_jw_consulta_clientes_nao_atendidos.getEsc_email()==null?"":t_jw_consulta_clientes_nao_atendidos.getEsc_email();
                      grupo_economico = t_jw_consulta_clientes_nao_atendidos.getGrupo_economico()==null?"":t_jw_consulta_clientes_nao_atendidos.getGrupo_economico();
                      String style_bl_report_Jw_consulta_clientes_nao_atendidos="";
                      if (!((i_bl_report_Jw_consulta_clientes_nao_atendidos%2)!=0)) {
                        style_bl_report_Jw_consulta_clientes_nao_atendidos="rowColor";
                      } else {
                        style_bl_report_Jw_consulta_clientes_nao_atendidos="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_consulta_clientes_nao_atendidos %>' id="TRbl_report_Jw_consulta_clientes_nao_atendidos<%=i_bl_report_Jw_consulta_clientes_nao_atendidos%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= cli_cdgo %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= esc_seqn %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cli_nome %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cli_rzao %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cnpj %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cidade %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= uf %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= endereco %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(cli_dult, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(limite_credito, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= fone %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= esc_email %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= grupo_economico %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_consulta_clientes_nao_atendidos++;
                      if (i_bl_report_Jw_consulta_clientes_nao_atendidos<res_Jw_consulta_clientes_nao_atendidos.size()) {
                        t_jw_consulta_clientes_nao_atendidos = (portalbr.dbobj.view.Jw_consulta_clientes_nao_atendidos)res_Jw_consulta_clientes_nao_atendidos.elementAt(i_bl_report_Jw_consulta_clientes_nao_atendidos);
                        cli_cdgo = t_jw_consulta_clientes_nao_atendidos.getCli_cdgo();
                        esc_seqn = t_jw_consulta_clientes_nao_atendidos.getEsc_seqn();
                        cli_nome = t_jw_consulta_clientes_nao_atendidos.getCli_nome()==null?"":t_jw_consulta_clientes_nao_atendidos.getCli_nome();
                        cli_rzao = t_jw_consulta_clientes_nao_atendidos.getCli_rzao()==null?"":t_jw_consulta_clientes_nao_atendidos.getCli_rzao();
                        cnpj = t_jw_consulta_clientes_nao_atendidos.getCnpj()==null?"":t_jw_consulta_clientes_nao_atendidos.getCnpj();
                        cidade = t_jw_consulta_clientes_nao_atendidos.getCidade()==null?"":t_jw_consulta_clientes_nao_atendidos.getCidade();
                        uf = t_jw_consulta_clientes_nao_atendidos.getUf()==null?"":t_jw_consulta_clientes_nao_atendidos.getUf();
                        endereco = t_jw_consulta_clientes_nao_atendidos.getEndereco()==null?"":t_jw_consulta_clientes_nao_atendidos.getEndereco();
                        cli_dult = (java.sql.Timestamp)t_jw_consulta_clientes_nao_atendidos.getCli_dult();
                        limite_credito = t_jw_consulta_clientes_nao_atendidos.getLimite_credito();
                        fone = t_jw_consulta_clientes_nao_atendidos.getFone()==null?"":t_jw_consulta_clientes_nao_atendidos.getFone();
                        esc_email = t_jw_consulta_clientes_nao_atendidos.getEsc_email()==null?"":t_jw_consulta_clientes_nao_atendidos.getEsc_email();
                        grupo_economico = t_jw_consulta_clientes_nao_atendidos.getGrupo_economico()==null?"":t_jw_consulta_clientes_nao_atendidos.getGrupo_economico();
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

            <html:form action="com/ClientesNaoAtendidos_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>

                    </div>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
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

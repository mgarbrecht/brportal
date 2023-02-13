<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Solicitações de coletas cadastradas
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(301)){
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
              java.util.Vector res_Jw_coletas_solicitacoes = (java.util.Vector)session.getAttribute("res_Jw_coletas_solicitacoes");
              %>

              <form  name="bl_report_Jw_coletas_solicitacoes" id="bl_report_Jw_coletas_solicitacoes" class="baseForm" method="post" >
                <%
                if (res_Jw_coletas_solicitacoes!=null && res_Jw_coletas_solicitacoes.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_coletas_solicitacoes"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Integer id_solicitacao_coleta =  null;
                    java.lang.String fil_filial =  null;
                    java.sql.Timestamp data_solicitacao =  null;
                    java.lang.String solicitante =  null;
                    java.lang.Integer tra_cdgo =  null;
                    java.lang.String tra_nome =  null;
                    java.lang.String tipo_caminhao =  null;
                    double quantidade_volumes =  0;
                    double quantidade_cubica =  0;
                    java.lang.String especie =  null;
                    java.lang.String observacoes =  null;
                    java.sql.Timestamp data_atendi_solicitacao =  null;
                    java.lang.String emp_empresa =  null;
                    java.lang.String emp_razsoc =  null;
                    java.lang.String fil_filial_descricao =  null;
                    java.lang.String fil_filial_destino =  null;
                    java.lang.String fil_filial_destino_descricao =  null;
                    java.lang.String usuario_inclusao =  null;
                    java.sql.Timestamp dthr_inclusao =  null;
                    java.lang.String usuario_alteracao =  null;
                    java.sql.Timestamp dthr_alteracao =  null;
                    java.lang.String tipo_solicitacao =  null;
                    java.lang.String descricao_tipo_solicitacao =  null;
                    java.lang.String status =  null;
                    java.lang.String status_descricao =  null;
                    java.lang.String email_enviado =  null;
                    java.lang.String email_enviado_descricao =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Nr. Solicitação
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Filial
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Data Solicitação
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Solicitante
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Transportadora
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Tipo de Caminhão
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Quantidade de Volumes
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Quantidade Cúbica
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Espécie
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Observações
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_coletas_solicitacoes = 0;
                    while (i_bl_report_Jw_coletas_solicitacoes<res_Jw_coletas_solicitacoes.size()) {
                      portalbr.dbobj.view.Jw_coletas_solicitacoes t_jw_coletas_solicitacoes = (portalbr.dbobj.view.Jw_coletas_solicitacoes)res_Jw_coletas_solicitacoes.elementAt(i_bl_report_Jw_coletas_solicitacoes);
                      id_solicitacao_coleta = t_jw_coletas_solicitacoes.getId_solicitacao_coleta();
                      fil_filial = t_jw_coletas_solicitacoes.getFil_filial()==null?"":t_jw_coletas_solicitacoes.getFil_filial();
                      data_solicitacao = (java.sql.Timestamp)t_jw_coletas_solicitacoes.getData_solicitacao();
                      solicitante = t_jw_coletas_solicitacoes.getSolicitante()==null?"":t_jw_coletas_solicitacoes.getSolicitante();
                      tra_cdgo = t_jw_coletas_solicitacoes.getTra_cdgo();
                      tra_nome = t_jw_coletas_solicitacoes.getTra_nome()==null?"":t_jw_coletas_solicitacoes.getTra_nome();
                      tipo_caminhao = t_jw_coletas_solicitacoes.getTipo_caminhao()==null?"":t_jw_coletas_solicitacoes.getTipo_caminhao();
                      quantidade_volumes = t_jw_coletas_solicitacoes.getQuantidade_volumes();
                      quantidade_cubica = t_jw_coletas_solicitacoes.getQuantidade_cubica();
                      especie = t_jw_coletas_solicitacoes.getEspecie()==null?"":t_jw_coletas_solicitacoes.getEspecie();
                      observacoes = t_jw_coletas_solicitacoes.getObservacoes()==null?"":t_jw_coletas_solicitacoes.getObservacoes();
                      data_atendi_solicitacao = (java.sql.Timestamp)t_jw_coletas_solicitacoes.getData_atendi_solicitacao();
                      emp_empresa = t_jw_coletas_solicitacoes.getEmp_empresa()==null?"":t_jw_coletas_solicitacoes.getEmp_empresa();
                      emp_razsoc = t_jw_coletas_solicitacoes.getEmp_razsoc()==null?"":t_jw_coletas_solicitacoes.getEmp_razsoc();
                      fil_filial_descricao = t_jw_coletas_solicitacoes.getFil_filial_descricao()==null?"":t_jw_coletas_solicitacoes.getFil_filial_descricao();
                      fil_filial_destino = t_jw_coletas_solicitacoes.getFil_filial_destino()==null?"":t_jw_coletas_solicitacoes.getFil_filial_destino();
                      fil_filial_destino_descricao = t_jw_coletas_solicitacoes.getFil_filial_destino_descricao()==null?"":t_jw_coletas_solicitacoes.getFil_filial_destino_descricao();
                      usuario_inclusao = t_jw_coletas_solicitacoes.getUsuario_inclusao()==null?"":t_jw_coletas_solicitacoes.getUsuario_inclusao();
                      dthr_inclusao = (java.sql.Timestamp)t_jw_coletas_solicitacoes.getDthr_inclusao();
                      usuario_alteracao = t_jw_coletas_solicitacoes.getUsuario_alteracao()==null?"":t_jw_coletas_solicitacoes.getUsuario_alteracao();
                      dthr_alteracao = (java.sql.Timestamp)t_jw_coletas_solicitacoes.getDthr_alteracao();
                      tipo_solicitacao = t_jw_coletas_solicitacoes.getTipo_solicitacao()==null?"":t_jw_coletas_solicitacoes.getTipo_solicitacao();
                      descricao_tipo_solicitacao = t_jw_coletas_solicitacoes.getDescricao_tipo_solicitacao()==null?"":t_jw_coletas_solicitacoes.getDescricao_tipo_solicitacao();
                      status = t_jw_coletas_solicitacoes.getStatus()==null?"":t_jw_coletas_solicitacoes.getStatus();
                      status_descricao = t_jw_coletas_solicitacoes.getStatus_descricao()==null?"":t_jw_coletas_solicitacoes.getStatus_descricao();
                      email_enviado = t_jw_coletas_solicitacoes.getEmail_enviado()==null?"":t_jw_coletas_solicitacoes.getEmail_enviado();
                      email_enviado_descricao = t_jw_coletas_solicitacoes.getEmail_enviado_descricao()==null?"":t_jw_coletas_solicitacoes.getEmail_enviado_descricao();
                      String style_bl_report_Jw_coletas_solicitacoes="";
                      if (!((i_bl_report_Jw_coletas_solicitacoes%2)!=0)) {
                        style_bl_report_Jw_coletas_solicitacoes="rowColor";
                      } else {
                        style_bl_report_Jw_coletas_solicitacoes="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_coletas_solicitacoes %>' id="TRbl_report_Jw_coletas_solicitacoes<%=i_bl_report_Jw_coletas_solicitacoes%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((id_solicitacao_coleta!=null)?id_solicitacao_coleta.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= fil_filial %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_solicitacao, "dd/MM/yyyy HH:mm:ss") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= solicitante %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= ((tra_cdgo!=null)?tra_cdgo.toString():"") %>
                          -
                          <%= ((tra_nome!=null)?tra_nome:"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= tipo_caminhao %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(quantidade_volumes, "0") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(quantidade_cubica, "0") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= especie %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= observacoes %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_coletas_solicitacoes++;
                      if (i_bl_report_Jw_coletas_solicitacoes<res_Jw_coletas_solicitacoes.size()) {
                        t_jw_coletas_solicitacoes = (portalbr.dbobj.view.Jw_coletas_solicitacoes)res_Jw_coletas_solicitacoes.elementAt(i_bl_report_Jw_coletas_solicitacoes);
                        id_solicitacao_coleta = t_jw_coletas_solicitacoes.getId_solicitacao_coleta();
                        fil_filial = t_jw_coletas_solicitacoes.getFil_filial()==null?"":t_jw_coletas_solicitacoes.getFil_filial();
                        data_solicitacao = (java.sql.Timestamp)t_jw_coletas_solicitacoes.getData_solicitacao();
                        solicitante = t_jw_coletas_solicitacoes.getSolicitante()==null?"":t_jw_coletas_solicitacoes.getSolicitante();
                        tra_cdgo = t_jw_coletas_solicitacoes.getTra_cdgo();
                        tra_nome = t_jw_coletas_solicitacoes.getTra_nome()==null?"":t_jw_coletas_solicitacoes.getTra_nome();
                        tipo_caminhao = t_jw_coletas_solicitacoes.getTipo_caminhao()==null?"":t_jw_coletas_solicitacoes.getTipo_caminhao();
                        quantidade_volumes = t_jw_coletas_solicitacoes.getQuantidade_volumes();
                        quantidade_cubica = t_jw_coletas_solicitacoes.getQuantidade_cubica();
                        especie = t_jw_coletas_solicitacoes.getEspecie()==null?"":t_jw_coletas_solicitacoes.getEspecie();
                        observacoes = t_jw_coletas_solicitacoes.getObservacoes()==null?"":t_jw_coletas_solicitacoes.getObservacoes();
                        data_atendi_solicitacao = (java.sql.Timestamp)t_jw_coletas_solicitacoes.getData_atendi_solicitacao();
                        emp_empresa = t_jw_coletas_solicitacoes.getEmp_empresa()==null?"":t_jw_coletas_solicitacoes.getEmp_empresa();
                        emp_razsoc = t_jw_coletas_solicitacoes.getEmp_razsoc()==null?"":t_jw_coletas_solicitacoes.getEmp_razsoc();
                        fil_filial_descricao = t_jw_coletas_solicitacoes.getFil_filial_descricao()==null?"":t_jw_coletas_solicitacoes.getFil_filial_descricao();
                        fil_filial_destino = t_jw_coletas_solicitacoes.getFil_filial_destino()==null?"":t_jw_coletas_solicitacoes.getFil_filial_destino();
                        fil_filial_destino_descricao = t_jw_coletas_solicitacoes.getFil_filial_destino_descricao()==null?"":t_jw_coletas_solicitacoes.getFil_filial_destino_descricao();
                        usuario_inclusao = t_jw_coletas_solicitacoes.getUsuario_inclusao()==null?"":t_jw_coletas_solicitacoes.getUsuario_inclusao();
                        dthr_inclusao = (java.sql.Timestamp)t_jw_coletas_solicitacoes.getDthr_inclusao();
                        usuario_alteracao = t_jw_coletas_solicitacoes.getUsuario_alteracao()==null?"":t_jw_coletas_solicitacoes.getUsuario_alteracao();
                        dthr_alteracao = (java.sql.Timestamp)t_jw_coletas_solicitacoes.getDthr_alteracao();
                        tipo_solicitacao = t_jw_coletas_solicitacoes.getTipo_solicitacao()==null?"":t_jw_coletas_solicitacoes.getTipo_solicitacao();
                        descricao_tipo_solicitacao = t_jw_coletas_solicitacoes.getDescricao_tipo_solicitacao()==null?"":t_jw_coletas_solicitacoes.getDescricao_tipo_solicitacao();
                        status = t_jw_coletas_solicitacoes.getStatus()==null?"":t_jw_coletas_solicitacoes.getStatus();
                        status_descricao = t_jw_coletas_solicitacoes.getStatus_descricao()==null?"":t_jw_coletas_solicitacoes.getStatus_descricao();
                        email_enviado = t_jw_coletas_solicitacoes.getEmail_enviado()==null?"":t_jw_coletas_solicitacoes.getEmail_enviado();
                        email_enviado_descricao = t_jw_coletas_solicitacoes.getEmail_enviado_descricao()==null?"":t_jw_coletas_solicitacoes.getEmail_enviado_descricao();
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

            <html:form action="ind/SolicitacaoColetas_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
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

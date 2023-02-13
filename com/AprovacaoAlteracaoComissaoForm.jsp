<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Aprovação de Alteração de Comissão
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(201)){
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
              java.util.Vector res_Jw_aprovacao_alteracao_comissao = null;
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                j = new com.egen.util.jdbc.JdbcUtil();
                portalbr.dbobj.view.Jw_aprovacao_alteracao_comissao t_jw_aprovacao_alteracao_comissao = new portalbr.dbobj.view.Jw_aprovacao_alteracao_comissao();
                String[][] select = {{"id_solicitacao",null},{"usuario_solicitacao",null},{"data_solicitacao",null},{"rep_cdgo",null},{"rep_rzao",null},{"cli_cdgo",null},{"esc_seqn",null},{"cli_rzao",null},{"emp_empresa",null},{"fil_filial",null},{"nfs_nmro",null},{"nfs_serie",null},{"valor_total",null},{"valor_calculado",null},{"motivo",null},{"valor_aprovado_parcial",null},};
                Object[][] where = null;
                String[] groupby =  null;
                String[] having =  null;
                String[] order =  null;
                res_Jw_aprovacao_alteracao_comissao = j.select(t_jw_aprovacao_alteracao_comissao,select,where,groupby,having,order);
              } catch (Exception e){
                session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                %>
                <jsp:forward page="/system/ErrorPage.jsp"/>
                <%
              } finally {
              if(j!=null){j.close();}
            }
            %>

            <form  name="bl_report_Jw_aprovacao_alteracao_comissao" id="bl_report_Jw_aprovacao_alteracao_comissao" class="baseForm" method="post" >
              <%
              if (res_Jw_aprovacao_alteracao_comissao!=null && res_Jw_aprovacao_alteracao_comissao.size()>0) {
                %>

                <table id="TRbl_report_Jw_aprovacao_alteracao_comissao"  class="reportTable"   style="width:99%; "  border="1" >
                  <%
                  java.lang.Integer id_solicitacao =  null;
                  java.lang.String usuario_solicitacao =  null;
                  java.sql.Timestamp data_solicitacao =  null;
                  java.lang.String rep_cdgo =  null;
                  java.lang.String rep_rzao =  null;
                  java.lang.Integer cli_cdgo =  null;
                  java.lang.Integer esc_seqn =  null;
                  java.lang.String cli_rzao =  null;
                  java.lang.String emp_empresa =  null;
                  java.lang.String fil_filial =  null;
                  java.lang.Integer nfs_nmro =  null;
                  java.lang.String nfs_serie =  null;
                  java.lang.Double valor_total =  null;
                  java.lang.Double valor_calculado =  null;
                  java.lang.String motivo =  null;
                  java.lang.Double valor_aprovado_parcial =  null;
                  java.lang.String aprovar =  null;
                  java.lang.String recusar =  null;
                  java.lang.String aprovar_parcial =  null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:right;" >
                      ID
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Usuário
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      Data
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Representante
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Cliente
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Emp.
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Filial
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Nota
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Valor NF
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Valor
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Motivo
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Vlr. Aprovado Parcial
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      Aprovar
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      Recusar
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      Aprovar Parcial
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Jw_aprovacao_alteracao_comissao = 0;
                  while (i_bl_report_Jw_aprovacao_alteracao_comissao<res_Jw_aprovacao_alteracao_comissao.size()) {
                    portalbr.dbobj.view.Jw_aprovacao_alteracao_comissao t_jw_aprovacao_alteracao_comissao = (portalbr.dbobj.view.Jw_aprovacao_alteracao_comissao)res_Jw_aprovacao_alteracao_comissao.elementAt(i_bl_report_Jw_aprovacao_alteracao_comissao);
                    id_solicitacao = t_jw_aprovacao_alteracao_comissao.getId_solicitacao();
                    usuario_solicitacao = t_jw_aprovacao_alteracao_comissao.getUsuario_solicitacao()==null?"":t_jw_aprovacao_alteracao_comissao.getUsuario_solicitacao();
                    data_solicitacao = (java.sql.Timestamp)t_jw_aprovacao_alteracao_comissao.getData_solicitacao();
                    rep_cdgo = t_jw_aprovacao_alteracao_comissao.getRep_cdgo()==null?"":t_jw_aprovacao_alteracao_comissao.getRep_cdgo();
                    rep_rzao = t_jw_aprovacao_alteracao_comissao.getRep_rzao()==null?"":t_jw_aprovacao_alteracao_comissao.getRep_rzao();
                    cli_cdgo = t_jw_aprovacao_alteracao_comissao.getCli_cdgo();
                    esc_seqn = t_jw_aprovacao_alteracao_comissao.getEsc_seqn();
                    cli_rzao = t_jw_aprovacao_alteracao_comissao.getCli_rzao()==null?"":t_jw_aprovacao_alteracao_comissao.getCli_rzao();
                    emp_empresa = t_jw_aprovacao_alteracao_comissao.getEmp_empresa()==null?"":t_jw_aprovacao_alteracao_comissao.getEmp_empresa();
                    fil_filial = t_jw_aprovacao_alteracao_comissao.getFil_filial()==null?"":t_jw_aprovacao_alteracao_comissao.getFil_filial();
                    nfs_nmro = t_jw_aprovacao_alteracao_comissao.getNfs_nmro();
                    nfs_serie = t_jw_aprovacao_alteracao_comissao.getNfs_serie()==null?"":t_jw_aprovacao_alteracao_comissao.getNfs_serie();
                    valor_total = t_jw_aprovacao_alteracao_comissao.getValor_total();
                    valor_calculado = t_jw_aprovacao_alteracao_comissao.getValor_calculado();
                    motivo = t_jw_aprovacao_alteracao_comissao.getMotivo()==null?"":t_jw_aprovacao_alteracao_comissao.getMotivo();
                    valor_aprovado_parcial = t_jw_aprovacao_alteracao_comissao.getValor_aprovado_parcial();
                    String style_bl_report_Jw_aprovacao_alteracao_comissao="";
                    if (!((i_bl_report_Jw_aprovacao_alteracao_comissao%2)!=0)) {
                      style_bl_report_Jw_aprovacao_alteracao_comissao="rowColor";
                    } else {
                      style_bl_report_Jw_aprovacao_alteracao_comissao="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Jw_aprovacao_alteracao_comissao %>' id="TRbl_report_Jw_aprovacao_alteracao_comissao<%=i_bl_report_Jw_aprovacao_alteracao_comissao%>" >
                      <td class="reportColumn" style="text-align:right;" >
                        <%= ((id_solicitacao!=null)?id_solicitacao.toString():"") %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= usuario_solicitacao %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" >
                        <%= com.egen.util.text.FormatDate.format(data_solicitacao, "dd/MM/yyyy") %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= rep_cdgo %>
                        -
                        <%= rep_rzao %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= ((cli_cdgo!=null)?cli_cdgo.toString():"") %>
                        -
                        <%= esc_seqn %>
                        -
                        <%= cli_rzao %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= emp_empresa %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= fil_filial %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= ((nfs_nmro!=null)?nfs_nmro.toString():"") %>
                        -
                        <%= nfs_serie %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= com.egen.util.text.FormatNumber.format(valor_total, "##,##0.00") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= com.egen.util.text.FormatNumber.format(valor_calculado, "##,##0.00") %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= motivo %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= com.egen.util.text.FormatNumber.format(valor_aprovado_parcial, "##,##0.00") %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" >
                        <%
                        if(valor_aprovado_parcial==null){
                          %>
                          <a href="../com/AprovacaoAlteracaoComissaoForm.do?aprovar_action=&id_solicitacao=<%= id_solicitacao %>" style="cursor:hand">
                            <input type="button" value="Aprovar" onclick="return confirmSubmit('');" />
                          </a>
                          <%
                        }
                        %>

                      </td>

                      <td class="reportColumn" style="text-align:center;" >
                        <%
                        if(valor_aprovado_parcial==null){
                          %>
                          <a href="../com/AprovacaoAlteracaoComissaoForm.do?recusar_action=&id_solicitacao=<%= id_solicitacao %>" style="cursor:hand">
                            <input type="button" value="Recusar" onclick="return confirmSubmit('');" />
                          </a>
                          <%
                        }
                        %>

                      </td>

                      <td class="reportColumn" style="text-align:center;" >
                        <input type="button" value="Aprovar Parcial" onclick="window.open('../com/AprovacaoAlteracaoComissao_pForm.do?pos_action=&id_solicitacao=<%= id_solicitacao %>','','scrollbars,height=510,width=730,top=0,left=0,')"/>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Jw_aprovacao_alteracao_comissao++;
                    if (i_bl_report_Jw_aprovacao_alteracao_comissao<res_Jw_aprovacao_alteracao_comissao.size()) {
                      t_jw_aprovacao_alteracao_comissao = (portalbr.dbobj.view.Jw_aprovacao_alteracao_comissao)res_Jw_aprovacao_alteracao_comissao.elementAt(i_bl_report_Jw_aprovacao_alteracao_comissao);
                      id_solicitacao = t_jw_aprovacao_alteracao_comissao.getId_solicitacao();
                      usuario_solicitacao = t_jw_aprovacao_alteracao_comissao.getUsuario_solicitacao()==null?"":t_jw_aprovacao_alteracao_comissao.getUsuario_solicitacao();
                      data_solicitacao = (java.sql.Timestamp)t_jw_aprovacao_alteracao_comissao.getData_solicitacao();
                      rep_cdgo = t_jw_aprovacao_alteracao_comissao.getRep_cdgo()==null?"":t_jw_aprovacao_alteracao_comissao.getRep_cdgo();
                      rep_rzao = t_jw_aprovacao_alteracao_comissao.getRep_rzao()==null?"":t_jw_aprovacao_alteracao_comissao.getRep_rzao();
                      cli_cdgo = t_jw_aprovacao_alteracao_comissao.getCli_cdgo();
                      esc_seqn = t_jw_aprovacao_alteracao_comissao.getEsc_seqn();
                      cli_rzao = t_jw_aprovacao_alteracao_comissao.getCli_rzao()==null?"":t_jw_aprovacao_alteracao_comissao.getCli_rzao();
                      emp_empresa = t_jw_aprovacao_alteracao_comissao.getEmp_empresa()==null?"":t_jw_aprovacao_alteracao_comissao.getEmp_empresa();
                      fil_filial = t_jw_aprovacao_alteracao_comissao.getFil_filial()==null?"":t_jw_aprovacao_alteracao_comissao.getFil_filial();
                      nfs_nmro = t_jw_aprovacao_alteracao_comissao.getNfs_nmro();
                      nfs_serie = t_jw_aprovacao_alteracao_comissao.getNfs_serie()==null?"":t_jw_aprovacao_alteracao_comissao.getNfs_serie();
                      valor_total = t_jw_aprovacao_alteracao_comissao.getValor_total();
                      valor_calculado = t_jw_aprovacao_alteracao_comissao.getValor_calculado();
                      motivo = t_jw_aprovacao_alteracao_comissao.getMotivo()==null?"":t_jw_aprovacao_alteracao_comissao.getMotivo();
                      valor_aprovado_parcial = t_jw_aprovacao_alteracao_comissao.getValor_aprovado_parcial();
                    } else {
                    }
                  }
                  %>

                </table>

                <%
              } else {
                %>

                <table style="width:100%" border="0">
                  <tr align="center">
                    <br>
                    <td>
                      <h1>
                        <b>
                          Nenhum registro encontrado!
                        </b>
                      </h1>
                    </td>
                  </tr>
                </table>
                <%
              }
              %>

            </form>
            <%
          }
          %>

          <html:form action="com/AprovacaoAlteracaoComissaoForm.do" method="post" styleClass="baseForm">
            <table class="messageTable" style='width:99%;'>
              <tr class="messageTr" >
                <td class="messageTd">
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:99%;">
              <html:hidden property="id_solicitacao"/>
            </table>

            <table class="buttonTable" style='width:99%;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:submit accesskey="a" styleClass="myhidden" property="aprovar_action">
                    <bean:message bundle="ApplicationResources" key="jsp.update"/>
                  </html:submit>
                  <html:submit accesskey="a" styleClass="myhidden" property="recusar_action">
                    <bean:message bundle="ApplicationResources" key="jsp.update"/>
                  </html:submit>
                  <html:submit styleClass="myhidden" property="refresh_action">
                    <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Pauta Diária de Trabalho - Criação
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(160)){
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
              java.util.Vector res_Jw_acao_marketing = (java.util.Vector)session.getAttribute("res_Jw_acao_marketing");
              util.consultas.Query query = new util.consultas.Query();
              %>

              <form  name="bl_report_Jw_acao_marketing" id="bl_report_Jw_acao_marketing" class="baseForm" method="post" >
                <%
                if (res_Jw_acao_marketing!=null && res_Jw_acao_marketing.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_acao_marketing"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.sql.Date data_entrega =  null;
                    java.sql.Date data_entrada =  null;
                    int acao =  0;
                    int codigo_material =  0;
                    int codigo_regional = 0;
                    int codigo_marca = 0;
                    java.lang.String descricao_marca =  null;
                    java.lang.String nome_regional =  null;
                    java.lang.String desc_material =  null;
                    java.lang.String observacao = null;
                    java.lang.String email = null;
                    java.lang.String situacao =  null;
                    java.lang.String cracha_usuario = null;
                    java.lang.String competencia = null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:center;" >
                        Data Entrega
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Data Entrada
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Competência
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" width="1%" >
                        Reg.
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Ação
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Situação
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Trabalho
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Material
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" width="1%" >
                        Solicitante
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Marca
                      </td>

                      <%
                      if(user.isSuperUsuario()) {
                        %>
                        <td class="columnTdHeader" style="text-align:center;" >
                          Crachá
                        </td>
                        <%
                      }
                      %>

                    </tr>

                    <%
                    int i_bl_report_Jw_acao_marketing = 0;
                    while (i_bl_report_Jw_acao_marketing<res_Jw_acao_marketing.size()) {
                      portalbr.dbobj.view.Jw_acao_marketing t_jw_acao_marketing = (portalbr.dbobj.view.Jw_acao_marketing)res_Jw_acao_marketing.elementAt(i_bl_report_Jw_acao_marketing);
                      data_entrega = (java.sql.Date)t_jw_acao_marketing.getData_entrega();
                      data_entrada = (java.sql.Date)t_jw_acao_marketing.getData_entrada();
                      competencia = t_jw_acao_marketing.getCompetencia()==null?"":t_jw_acao_marketing.getCompetencia();
                      acao = t_jw_acao_marketing.getAcao();
                      codigo_material = t_jw_acao_marketing.getCodigo_material();
                      desc_material = t_jw_acao_marketing.getDesc_material()==null?"":t_jw_acao_marketing.getDesc_material();
                      codigo_marca = t_jw_acao_marketing.getCodigo_marca();
                      descricao_marca = t_jw_acao_marketing.getDescricao_marca()==null?"":t_jw_acao_marketing.getDescricao_marca();
                      codigo_regional = t_jw_acao_marketing.getCodigo_regional();
                      nome_regional = t_jw_acao_marketing.getNome_regional()==null?"":t_jw_acao_marketing.getNome_regional();
                      observacao = t_jw_acao_marketing.getObservacao()==null?"":t_jw_acao_marketing.getObservacao();
                      email = t_jw_acao_marketing.getEmail()==null?"":t_jw_acao_marketing.getEmail();
                      cracha_usuario = t_jw_acao_marketing.getCracha_usuario()==null?"":t_jw_acao_marketing.getCracha_usuario();
                      situacao = t_jw_acao_marketing.getSituacao()==null?"":t_jw_acao_marketing.getSituacao();
                      String style_bl_report_Jw_acao_marketing="";
                      if (!((i_bl_report_Jw_acao_marketing%2)!=0)) {
                        style_bl_report_Jw_acao_marketing="rowColor";
                      } else {
                        style_bl_report_Jw_acao_marketing="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_acao_marketing %>' id="TRbl_report_Jw_acao_marketing<%=i_bl_report_Jw_acao_marketing%>" >
                        <td class="reportColumn" style="text-align:center;width:1%;" >
                          <%= com.egen.util.text.FormatDate.format(data_entrega, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;width:1%;" >
                          <%= com.egen.util.text.FormatDate.format(data_entrada, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" width="1%">
                          <%= competencia %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" width="1%">
                          <%= nome_regional %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <a href="../com/ManutencaoAcaoMarketingEventosForm.do?select_action=&acao=<%= acao %>" style="cursor:hand">
                            <%= acao %>
                          </a>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%
                          String desc_situacao = null;
                          desc_situacao = query.retorna("SELECT descricao FROM acao_marketing_situacoes WHERE codigo = "+situacao);
                          %>
                          <%= desc_situacao %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= observacao.substring(0,observacao.length()>30?30:observacao.length())+"..." %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= codigo_material %>
                          -
                          <%= desc_material %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= email %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= descricao_marca %>
                        </td>

                        <%
                        if(user.isSuperUsuario()) {
                          %>
                          <td class="reportColumn" style="text-align:center;" >
                            <%= cracha_usuario %>
                          </td>
                          <%
                        }
                        %>

                      </tr>

                      <%
                      i_bl_report_Jw_acao_marketing++;
                      if (i_bl_report_Jw_acao_marketing<res_Jw_acao_marketing.size()) {
                        t_jw_acao_marketing = (portalbr.dbobj.view.Jw_acao_marketing)res_Jw_acao_marketing.elementAt(i_bl_report_Jw_acao_marketing);
                        data_entrega = (java.sql.Date)t_jw_acao_marketing.getData_entrega();
                        data_entrada = (java.sql.Date)t_jw_acao_marketing.getData_entrada();
                        competencia = t_jw_acao_marketing.getCompetencia()==null?"":t_jw_acao_marketing.getCompetencia();
                        acao = t_jw_acao_marketing.getAcao();
                        codigo_material = t_jw_acao_marketing.getCodigo_material();
                        desc_material = t_jw_acao_marketing.getDesc_material()==null?"":t_jw_acao_marketing.getDesc_material();
                        codigo_marca = t_jw_acao_marketing.getCodigo_marca();
                        descricao_marca = t_jw_acao_marketing.getDescricao_marca()==null?"":t_jw_acao_marketing.getDescricao_marca();
                        codigo_regional = t_jw_acao_marketing.getCodigo_regional();
                        nome_regional = t_jw_acao_marketing.getNome_regional()==null?"":t_jw_acao_marketing.getNome_regional();
                        observacao = t_jw_acao_marketing.getObservacao()==null?"":t_jw_acao_marketing.getObservacao();
                        email = t_jw_acao_marketing.getEmail()==null?"":t_jw_acao_marketing.getEmail();
                        cracha_usuario = t_jw_acao_marketing.getCracha_usuario()==null?"":t_jw_acao_marketing.getCracha_usuario();
                        situacao = t_jw_acao_marketing.getSituacao()==null?"":t_jw_acao_marketing.getSituacao();
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
            <html:form action="com/ManutencaoAcaoMarketing_rForm.do" method="post" styleClass="baseForm">
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

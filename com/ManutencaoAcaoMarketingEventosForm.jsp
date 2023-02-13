<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Pauta Diária de Trabalho - Criação - Eventos
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
              java.util.Vector res_Jw_acao_marketing_eventos = (java.util.Vector)session.getAttribute("res_Jw_acao_marketing_eventos");
              util.consultas.Query query = new util.consultas.Query();
              %>

              <form  name="bl_report_Jw_acao_marketing_eventos" id="bl_report_Jw_acao_marketing_eventos" class="baseForm" method="post" >
                <%
                if (res_Jw_acao_marketing_eventos!=null && res_Jw_acao_marketing_eventos.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_acao_marketing_eventos"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.sql.Date data_entrega =  null;
                    int acao =  0;
                    int seq =  0;
                    int codigo_material =  0;
                    int codigo_marca =  0;
                    java.lang.String cli_cdgo = null;
                    java.lang.String cli_rzao = null;
                    java.lang.String desc_situacao = null;
                    java.lang.String desc_material =  null;
                    java.lang.String descricao_marca =  null;
                    java.lang.String situacao =  null;
                    java.lang.String imagem =  null;
                    java.lang.String formato =  null;
                    java.lang.String observacao =  null;
                    java.lang.String email =  null;
                    java.lang.String obs_evento =  null;
                    java.sql.Date data_transacao =  null;
                    java.lang.String usuario_transacao =  null;
                    int cracha_usuario =  0;
                    String _b0_control = "__";
                    int i_bl_report_Jw_acao_marketing_eventos = 0;
                    while (i_bl_report_Jw_acao_marketing_eventos<res_Jw_acao_marketing_eventos.size()) {
                      portalbr.dbobj.view.Jw_acao_marketing_eventos t_jw_acao_marketing_eventos = (portalbr.dbobj.view.Jw_acao_marketing_eventos)res_Jw_acao_marketing_eventos.elementAt(i_bl_report_Jw_acao_marketing_eventos);
                      data_entrega = (java.sql.Date)t_jw_acao_marketing_eventos.getData_entrega();
                      acao = t_jw_acao_marketing_eventos.getAcao();
                      seq = t_jw_acao_marketing_eventos.getSeq();

                      cli_cdgo = t_jw_acao_marketing_eventos.getCli_cdgo()==null?"":t_jw_acao_marketing_eventos.getCli_cdgo();
                      cli_rzao = t_jw_acao_marketing_eventos.getCli_rzao()==null?"":t_jw_acao_marketing_eventos.getCli_rzao();

                      codigo_material = t_jw_acao_marketing_eventos.getCodigo_material();
                      codigo_marca = t_jw_acao_marketing_eventos.getCodigo_marca();
                      desc_material = t_jw_acao_marketing_eventos.getDesc_material()==null?"":t_jw_acao_marketing_eventos.getDesc_material();
                      descricao_marca = t_jw_acao_marketing_eventos.getDescricao_marca()==null?"":t_jw_acao_marketing_eventos.getDescricao_marca();
                      situacao = t_jw_acao_marketing_eventos.getSituacao()==null?"":t_jw_acao_marketing_eventos.getSituacao();
                      imagem = t_jw_acao_marketing_eventos.getImagem()==null?"":t_jw_acao_marketing_eventos.getImagem();
                      formato = t_jw_acao_marketing_eventos.getFormato()==null?"":t_jw_acao_marketing_eventos.getFormato();
                      observacao = t_jw_acao_marketing_eventos.getObservacao()==null?"":t_jw_acao_marketing_eventos.getObservacao();
                      email = t_jw_acao_marketing_eventos.getEmail()==null?"":t_jw_acao_marketing_eventos.getEmail();
                      obs_evento = t_jw_acao_marketing_eventos.getObs_evento()==null?"":t_jw_acao_marketing_eventos.getObs_evento();
                      data_transacao = (java.sql.Date)t_jw_acao_marketing_eventos.getData_transacao();
                      usuario_transacao = t_jw_acao_marketing_eventos.getUsuario_transacao()==null?"":t_jw_acao_marketing_eventos.getUsuario_transacao();
                      cracha_usuario = t_jw_acao_marketing_eventos.getCracha_usuario();
                      String _b0_value = com.egen.util.text.FormatNumber.format(acao);
                      query.retorna("SELECT descricao FROM acao_marketing_situacoes WHERE codigo = "+situacao);
                      session.setAttribute("ManutencaoAcaoMarketingEventosSituacaoAnterior", situacao);
                      desc_situacao = query.retorna("SELECT descricao FROM acao_marketing_situacoes WHERE codigo = "+situacao);

                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                        %>
                        <tr class="reportHeader2">
                          <td colspan="9">
                            <b>
                              Ação:
                            </b>
                            <%= acao %>
                            <br>
                            <%
                            if(cli_cdgo!="") {
                              %>
                              <b>
                                Cliente:
                              </b>
                              <%= cli_cdgo %>
                              -
                              <%= cli_rzao %>
                              <br>
                              <%
                            }
                            %>
                            <b>
                              Data de Entrega:
                            </b>
                            <%= com.egen.util.text.FormatDate.format(data_entrega, "dd/MM/yyyy") %>
                            <br>
                            <b>
                              Data de Cadastro:
                            </b>
                            <%= com.egen.util.text.FormatDate.format(data_transacao, "dd/MM/yyyy") %>
                            <br>
                            <b>
                              Situação:
                            </b>
                            <%= situacao %>
                            -
                            <%= desc_situacao %>
                            <br>
                            <b>
                              Marca:
                            </b>
                            <%= codigo_marca %>
                            -
                            <%= descricao_marca %>
                            <br>
                            <b>
                              Material:
                            </b>
                            <%= codigo_material %>
                            -
                            <%= desc_material %>
                            <br>
                            <b>
                              Imagem:
                            </b>
                            <%= imagem %>
                            <br>
                            <b>
                              Formato:
                            </b>
                            <%= formato %>
                            <br>
                            <b>
                              Observação:
                            </b>
                            <%= observacao %>
                            <br>



                            <%
                            java.util.Vector res_Jw_complementos_acao_mkt = null;
                            com.egen.util.jdbc.JdbcUtil j = null;
                            int acao1 =  0;
                            java.lang.String tipo_complemento =  null;
                            java.lang.String complemento =  null;
                            try {
                              j = new com.egen.util.jdbc.JdbcUtil();
                              portalbr.dbobj.view.Jw_complementos_acao_mkt t_jw_complementos_acao_mkt = new portalbr.dbobj.view.Jw_complementos_acao_mkt();
                              String[][] select = null;
                              Object[][] where = {{"acao","=",acao}};
                              res_Jw_complementos_acao_mkt = j.select(t_jw_complementos_acao_mkt,select,where,null,null,null);
                            } catch (Exception e){
                            } finally {
                            if(j!=null){j.close();}
                          }

                          if (res_Jw_complementos_acao_mkt!=null && res_Jw_complementos_acao_mkt.size()>0) {

                            for(int x=0;x<res_Jw_complementos_acao_mkt.size();x++) {
                              portalbr.dbobj.view.Jw_complementos_acao_mkt t_jw_complementos_acao_mkt = (portalbr.dbobj.view.Jw_complementos_acao_mkt)res_Jw_complementos_acao_mkt.elementAt(x);
                              acao1 = t_jw_complementos_acao_mkt.getAcao();
                              tipo_complemento = t_jw_complementos_acao_mkt.getTipo_complemento()==null?"":t_jw_complementos_acao_mkt.getTipo_complemento();
                              complemento = t_jw_complementos_acao_mkt.getComplemento()==null?"":t_jw_complementos_acao_mkt.getComplemento();
                              %>
                              <b>
                                <%= tipo_complemento %>
                                :
                                <%= complemento %>
                              </b>
                              <br>
                              <%
                            }

                          }
                          %>


                        </td>
                      </tr>
                      <%
                      %>

                      <tr class="reportTr">
                        <td class="columnTdHeader" style="text-align:center;" >
                          Seq.
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          e-Mail
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Observação Evento
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Data Evento
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Usuário Transação
                        </td>

                      </tr>

                      <%
                    }
                    String style_bl_report_Jw_acao_marketing_eventos="";
                    if (!((i_bl_report_Jw_acao_marketing_eventos%2)!=0)) {
                      style_bl_report_Jw_acao_marketing_eventos="rowColor";
                    } else {
                      style_bl_report_Jw_acao_marketing_eventos="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Jw_acao_marketing_eventos %>' id="TRbl_report_Jw_acao_marketing_eventos<%=i_bl_report_Jw_acao_marketing_eventos%>" >
                      <td class="reportColumn" style="text-align:center;" >
                        <%= seq %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= email %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= obs_evento %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" >
                        <%= com.egen.util.text.FormatDate.format(data_transacao, "dd/MM/yyyy") %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= usuario_transacao %>
                      </td>

                    </tr>

                    <%
                    _b0_control = _b0_value;
                    i_bl_report_Jw_acao_marketing_eventos++;
                    if (i_bl_report_Jw_acao_marketing_eventos<res_Jw_acao_marketing_eventos.size()) {
                      t_jw_acao_marketing_eventos = (portalbr.dbobj.view.Jw_acao_marketing_eventos)res_Jw_acao_marketing_eventos.elementAt(i_bl_report_Jw_acao_marketing_eventos);
                      data_entrega = (java.sql.Date)t_jw_acao_marketing_eventos.getData_entrega();
                      acao = t_jw_acao_marketing_eventos.getAcao();
                      seq = t_jw_acao_marketing_eventos.getSeq();

                      cli_cdgo = t_jw_acao_marketing_eventos.getCli_cdgo()==null?"":t_jw_acao_marketing_eventos.getCli_cdgo();
                      cli_rzao = t_jw_acao_marketing_eventos.getCli_rzao()==null?"":t_jw_acao_marketing_eventos.getCli_rzao();

                      codigo_material = t_jw_acao_marketing_eventos.getCodigo_material();
                      codigo_marca = t_jw_acao_marketing_eventos.getCodigo_marca();
                      desc_material = t_jw_acao_marketing_eventos.getDesc_material()==null?"":t_jw_acao_marketing_eventos.getDesc_material();
                      descricao_marca = t_jw_acao_marketing_eventos.getDescricao_marca()==null?"":t_jw_acao_marketing_eventos.getDescricao_marca();
                      situacao = t_jw_acao_marketing_eventos.getSituacao()==null?"":t_jw_acao_marketing_eventos.getSituacao();
                      imagem = t_jw_acao_marketing_eventos.getImagem()==null?"":t_jw_acao_marketing_eventos.getImagem();
                      formato = t_jw_acao_marketing_eventos.getFormato()==null?"":t_jw_acao_marketing_eventos.getFormato();
                      observacao = t_jw_acao_marketing_eventos.getObservacao()==null?"":t_jw_acao_marketing_eventos.getObservacao();
                      email = t_jw_acao_marketing_eventos.getEmail()==null?"":t_jw_acao_marketing_eventos.getEmail();
                      obs_evento = t_jw_acao_marketing_eventos.getObs_evento()==null?"":t_jw_acao_marketing_eventos.getObs_evento();
                      data_transacao = (java.sql.Date)t_jw_acao_marketing_eventos.getData_transacao();
                      usuario_transacao = t_jw_acao_marketing_eventos.getUsuario_transacao()==null?"":t_jw_acao_marketing_eventos.getUsuario_transacao();
                      cracha_usuario = t_jw_acao_marketing_eventos.getCracha_usuario();
                      _b0_value = com.egen.util.text.FormatNumber.format(acao);
                      desc_situacao = query.retorna("SELECT descricao FROM acao_marketing_situacoes WHERE codigo = "+situacao);
                      session.setAttribute("ManutencaoAcaoMarketingEventosSituacaoAnterior", situacao);
                    } else {
                      _b0_control = "__";
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
          <html:form action="com/ManutencaoAcaoMarketingEventosForm.do" method="post" styleClass="baseForm">
            <table class="itemTable"  style=" width:;">
              <html:hidden property="acao"/>
              <html:hidden property="cracha_alterar"/>
              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:submit>
                    <html:submit accesskey="i" value="Registrar Novo Evento" styleClass="baseButton" property="insert_action">
                    </html:submit>
                    <%
                    String situacao = (String)session.getAttribute("ManutencaoAcaoMarketingEventosSituacao");
                    %>
                    <html:button accesskey="a" onclick="manutencao()" value="Alterar Situação" styleClass="baseButton" property="update_action">
                    </html:button>
                    <html:submit styleClass="myhidden" property="update1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.update"/>
                    </html:submit>
                    <html:submit styleClass="myhidden" property="trocar_cracha_action">
                      <bean:message bundle="ApplicationResources" key="jsp.update"/>
                    </html:submit>
                    <%
                    util.consultas.Query qr = new util.consultas.Query();
                    String chave = null;
                    acesso.Sessao se = new acesso.Sessao(session);
                    String tipo = se.getTipoEntidadeNegocio();
                    String coordenador = null;
                    if(tipo.equals("AREAS")){
                      chave = se.getUsuario();
                    }
                    coordenador = qr.retorna("SELECT coordenador FROM acao_marketing_usuarios where cracha = "+chave);
                    if(coordenador.equals("S")){
                      %>
                      <html:button accesskey="a" onclick="manutencao2()" value="Alterar Usuário" styleClass="baseButton" property="troca_action">
                      </html:button>
                      <html:button accesskey="a" onclick="" value="Alterar Usuário" styleClass="myhidden" property="troca_action">
                      </html:button>
                      <%
                    } else {
                      %>

                      <%
                    }
                    %>


                    <script>
                      function manutencao2(){
                        wopen('../com/ManutencaoAcaoMarketingEventos_acForm.jsp','_blank',600,200);
                      }
                    </script>
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

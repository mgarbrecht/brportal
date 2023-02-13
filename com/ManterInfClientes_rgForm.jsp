<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Manter Informações de Clientes - Relatório
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(200)){
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
              java.util.Vector res_Cli_inf_adicionais_vw = (java.util.Vector)session.getAttribute("res_Cli_inf_adicionais_vw");
              %>

              <form  name="bl_report_Cli_inf_adicionais_vw" id="bl_report_Cli_inf_adicionais_vw" class="baseForm" method="post" >
                <%
                if (res_Cli_inf_adicionais_vw!=null && res_Cli_inf_adicionais_vw.size()>0) {
                  %>

                  <table id="TRbl_report_Cli_inf_adicionais_vw"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Integer gre_grupo =  null;
                    java.lang.String gre_descricao =  null;
                    java.lang.Integer cli_cdgo =  null;
                    java.lang.String cli_rzao =  null;
                    java.lang.Integer esc_seqn =  null;
                    java.lang.Integer cli_cdgo_sucessor =  null;
                    java.lang.Integer esc_seqn_sucessor =  null;
                    java.lang.String sistema_ri =  null;
                    java.lang.String ordem_compra =  null;
                    java.lang.String dt_agendamento =  null;
                    java.lang.String horario_entrega =  null;
                    java.lang.String senha_entrega =  null;
                    java.lang.String data_emissao =  null;
                    java.lang.String filial =  null;
                    java.lang.String nf_nmro =  null;
                    java.lang.String nro_volumes =  null;
                    java.lang.String cliente_mi =  null;
                    java.lang.String possui_carimbo =  null;
                    java.lang.String somente_etiqueta =  null;
                    String _b0_control = "__";
                    int i_bl_report_Cli_inf_adicionais_vw = 0;
                    while (i_bl_report_Cli_inf_adicionais_vw<res_Cli_inf_adicionais_vw.size()) {
                      portalbr.dbobj.view.Cli_inf_adicionais_vw t_cli_inf_adicionais_vw = (portalbr.dbobj.view.Cli_inf_adicionais_vw)res_Cli_inf_adicionais_vw.elementAt(i_bl_report_Cli_inf_adicionais_vw);
                      gre_grupo = t_cli_inf_adicionais_vw.getGre_grupo();
                      gre_descricao = t_cli_inf_adicionais_vw.getGre_descricao()==null?"":t_cli_inf_adicionais_vw.getGre_descricao();
                      cli_cdgo = t_cli_inf_adicionais_vw.getCli_cdgo();
                      cli_rzao = t_cli_inf_adicionais_vw.getCli_rzao()==null?"":t_cli_inf_adicionais_vw.getCli_rzao();
                      esc_seqn = t_cli_inf_adicionais_vw.getEsc_seqn();
                      cli_cdgo_sucessor = t_cli_inf_adicionais_vw.getCli_cdgo_sucessor();
                      esc_seqn_sucessor = t_cli_inf_adicionais_vw.getEsc_seqn_sucessor();
                      sistema_ri = t_cli_inf_adicionais_vw.getSistema_ri()==null?"":t_cli_inf_adicionais_vw.getSistema_ri();
                      ordem_compra = t_cli_inf_adicionais_vw.getOrdem_compra()==null?"":t_cli_inf_adicionais_vw.getOrdem_compra();
                      dt_agendamento = t_cli_inf_adicionais_vw.getDt_agendamento()==null?"":t_cli_inf_adicionais_vw.getDt_agendamento();
                      horario_entrega = t_cli_inf_adicionais_vw.getHorario_entrega()==null?"":t_cli_inf_adicionais_vw.getHorario_entrega();
                      senha_entrega = t_cli_inf_adicionais_vw.getSenha_entrega()==null?"":t_cli_inf_adicionais_vw.getSenha_entrega();
                      data_emissao = t_cli_inf_adicionais_vw.getData_emissao()==null?"":t_cli_inf_adicionais_vw.getData_emissao();
                      filial = t_cli_inf_adicionais_vw.getFilial()==null?"":t_cli_inf_adicionais_vw.getFilial();
                      nf_nmro = t_cli_inf_adicionais_vw.getNf_nmro()==null?"":t_cli_inf_adicionais_vw.getNf_nmro();
                      nro_volumes = t_cli_inf_adicionais_vw.getNro_volumes()==null?"":t_cli_inf_adicionais_vw.getNro_volumes();
                      cliente_mi = t_cli_inf_adicionais_vw.getCliente_mi()==null?"":t_cli_inf_adicionais_vw.getCliente_mi();
                      possui_carimbo = t_cli_inf_adicionais_vw.getPossui_carimbo()==null?"":t_cli_inf_adicionais_vw.getPossui_carimbo();
                      somente_etiqueta = t_cli_inf_adicionais_vw.getSomente_etiqueta()==null?"":t_cli_inf_adicionais_vw.getSomente_etiqueta();
                      String _b0_value = com.egen.util.text.FormatNumber.format(gre_grupo);
                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                        %>
                        <tr class="reportHeader">
                          <td colspan="17">
                            <span class="columnTdHeader" style="text-align:right;" >
                              Grupo Econômico :
                              <%= ((gre_grupo!=null)?gre_grupo.toString():"") %>
                              -
                              <%= gre_descricao %>
                            </span>
                          </td>
                        </tr>
                        <%
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:right;" >
                            Código
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Razão Social
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Seq.
                          </td>

                          <td class="columnTdHeader" style="text-align:center;" >
                            Obriga Etiqueta
                          </td>

                        </tr>

                        <%
                      }
                      String style_bl_report_Cli_inf_adicionais_vw="";
                      if (!((i_bl_report_Cli_inf_adicionais_vw%2)!=0)) {
                        style_bl_report_Cli_inf_adicionais_vw="rowColor";
                      } else {
                        style_bl_report_Cli_inf_adicionais_vw="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Cli_inf_adicionais_vw %>' id="TRbl_report_Cli_inf_adicionais_vw<%=i_bl_report_Cli_inf_adicionais_vw%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((cli_cdgo!=null)?cli_cdgo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="../com/ManterInfClientes_aForm.do?select_action=&cli_cdgo=<%= cli_cdgo %>&esc_seqn=<%= esc_seqn %>" style="cursor:hand">
                            <%= cli_rzao %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((esc_seqn!=null)?esc_seqn.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;width:10%;" >
                          <%= somente_etiqueta %>
                        </td>

                      </tr>

                      <%
                      _b0_control = _b0_value;
                      i_bl_report_Cli_inf_adicionais_vw++;
                      if (i_bl_report_Cli_inf_adicionais_vw<res_Cli_inf_adicionais_vw.size()) {
                        t_cli_inf_adicionais_vw = (portalbr.dbobj.view.Cli_inf_adicionais_vw)res_Cli_inf_adicionais_vw.elementAt(i_bl_report_Cli_inf_adicionais_vw);
                        gre_grupo = t_cli_inf_adicionais_vw.getGre_grupo();
                        gre_descricao = t_cli_inf_adicionais_vw.getGre_descricao()==null?"":t_cli_inf_adicionais_vw.getGre_descricao();
                        cli_cdgo = t_cli_inf_adicionais_vw.getCli_cdgo();
                        cli_rzao = t_cli_inf_adicionais_vw.getCli_rzao()==null?"":t_cli_inf_adicionais_vw.getCli_rzao();
                        esc_seqn = t_cli_inf_adicionais_vw.getEsc_seqn();
                        cli_cdgo_sucessor = t_cli_inf_adicionais_vw.getCli_cdgo_sucessor();
                        esc_seqn_sucessor = t_cli_inf_adicionais_vw.getEsc_seqn_sucessor();
                        sistema_ri = t_cli_inf_adicionais_vw.getSistema_ri()==null?"":t_cli_inf_adicionais_vw.getSistema_ri();
                        ordem_compra = t_cli_inf_adicionais_vw.getOrdem_compra()==null?"":t_cli_inf_adicionais_vw.getOrdem_compra();
                        dt_agendamento = t_cli_inf_adicionais_vw.getDt_agendamento()==null?"":t_cli_inf_adicionais_vw.getDt_agendamento();
                        horario_entrega = t_cli_inf_adicionais_vw.getHorario_entrega()==null?"":t_cli_inf_adicionais_vw.getHorario_entrega();
                        senha_entrega = t_cli_inf_adicionais_vw.getSenha_entrega()==null?"":t_cli_inf_adicionais_vw.getSenha_entrega();
                        data_emissao = t_cli_inf_adicionais_vw.getData_emissao()==null?"":t_cli_inf_adicionais_vw.getData_emissao();
                        filial = t_cli_inf_adicionais_vw.getFilial()==null?"":t_cli_inf_adicionais_vw.getFilial();
                        nf_nmro = t_cli_inf_adicionais_vw.getNf_nmro()==null?"":t_cli_inf_adicionais_vw.getNf_nmro();
                        nro_volumes = t_cli_inf_adicionais_vw.getNro_volumes()==null?"":t_cli_inf_adicionais_vw.getNro_volumes();
                        cliente_mi = t_cli_inf_adicionais_vw.getCliente_mi()==null?"":t_cli_inf_adicionais_vw.getCliente_mi();
                        possui_carimbo = t_cli_inf_adicionais_vw.getPossui_carimbo()==null?"":t_cli_inf_adicionais_vw.getPossui_carimbo();
                        somente_etiqueta = t_cli_inf_adicionais_vw.getSomente_etiqueta()==null?"":t_cli_inf_adicionais_vw.getSomente_etiqueta();
                        _b0_value = com.egen.util.text.FormatNumber.format(gre_grupo);
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

            <html:form action="com/ManterInfClientes_rgForm.do" method="post" styleClass="baseForm">
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

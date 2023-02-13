<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta Posição Talões
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(226)){
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
              java.util.Vector res_Jw_consulta_posicao_taloes = (java.util.Vector)session.getAttribute("res_Jw_consulta_posicao_taloes");
              %>

              <form  name="bl_report_Jw_consulta_posicao_taloes" id="bl_report_Jw_consulta_posicao_taloes" class="baseForm" method="post" >
                <%
                if (res_Jw_consulta_posicao_taloes!=null && res_Jw_consulta_posicao_taloes.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_consulta_posicao_taloes"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.String fil_filial =  null;
                    java.lang.Integer remessa =  null;
                    java.lang.Integer talao =  null;
                    java.lang.String atualiza_controle_producao =  null;
                    java.lang.Integer forn_codigo =  null;
                    java.lang.String fornecedor =  null;
                    java.lang.Integer fen_seq =  null;
                    java.lang.Integer processo =  null;
                    java.lang.String status =  null;
                    java.lang.Integer pares =  null;
                    java.sql.Timestamp dt_envio =  null;
                    java.sql.Timestamp dt_retorno =  null;
                    java.lang.Integer oc =  null;
                    java.lang.String situacao_oc =  null;
                    java.lang.String nota_fiscal =  null;
                    java.lang.Integer lin_cdgo =  null;
                    java.lang.Integer ref_cdgo =  null;
                    java.lang.Integer cab_cdgo =  null;
                    java.lang.Integer cor_cdgo =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Remessa
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Talão
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        ACP
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Fornecedor
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Seq. Fornec.
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Processo
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Status
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Pares
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Dt. Envio
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Dt. Retorno
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        OC
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Situação
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        NF/Série
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Linha
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Ref.
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Cab.
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Cor
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_consulta_posicao_taloes = 0;
                    while (i_bl_report_Jw_consulta_posicao_taloes<res_Jw_consulta_posicao_taloes.size()) {
                      portalbr.dbobj.view.Jw_consulta_posicao_taloes t_jw_consulta_posicao_taloes = (portalbr.dbobj.view.Jw_consulta_posicao_taloes)res_Jw_consulta_posicao_taloes.elementAt(i_bl_report_Jw_consulta_posicao_taloes);
                      fil_filial = t_jw_consulta_posicao_taloes.getFil_filial()==null?"":t_jw_consulta_posicao_taloes.getFil_filial();
                      remessa = t_jw_consulta_posicao_taloes.getRemessa();
                      talao = t_jw_consulta_posicao_taloes.getTalao();
                      atualiza_controle_producao = t_jw_consulta_posicao_taloes.getAtualiza_controle_producao()==null?"":t_jw_consulta_posicao_taloes.getAtualiza_controle_producao();
                      forn_codigo = t_jw_consulta_posicao_taloes.getForn_codigo();
                      fornecedor = t_jw_consulta_posicao_taloes.getFornecedor()==null?"":t_jw_consulta_posicao_taloes.getFornecedor();
                      fen_seq = t_jw_consulta_posicao_taloes.getFen_seq();
                      processo = t_jw_consulta_posicao_taloes.getProcesso();
                      status = t_jw_consulta_posicao_taloes.getStatus()==null?"":t_jw_consulta_posicao_taloes.getStatus();
                      pares = t_jw_consulta_posicao_taloes.getPares();
                      dt_envio = (java.sql.Timestamp)t_jw_consulta_posicao_taloes.getDt_envio();
                      dt_retorno = (java.sql.Timestamp)t_jw_consulta_posicao_taloes.getDt_retorno();
                      oc = t_jw_consulta_posicao_taloes.getOc();
                      situacao_oc = t_jw_consulta_posicao_taloes.getSituacao_oc()==null?"":t_jw_consulta_posicao_taloes.getSituacao_oc();
                      nota_fiscal = t_jw_consulta_posicao_taloes.getNota_fiscal()==null?"":t_jw_consulta_posicao_taloes.getNota_fiscal();
                      lin_cdgo = t_jw_consulta_posicao_taloes.getLin_cdgo();
                      ref_cdgo = t_jw_consulta_posicao_taloes.getRef_cdgo();
                      cab_cdgo = t_jw_consulta_posicao_taloes.getCab_cdgo();
                      cor_cdgo = t_jw_consulta_posicao_taloes.getCor_cdgo();
                      String style_bl_report_Jw_consulta_posicao_taloes="";
                      if (!((i_bl_report_Jw_consulta_posicao_taloes%2)!=0)) {
                        style_bl_report_Jw_consulta_posicao_taloes="rowColor";
                      } else {
                        style_bl_report_Jw_consulta_posicao_taloes="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_consulta_posicao_taloes %>' id="TRbl_report_Jw_consulta_posicao_taloes<%=i_bl_report_Jw_consulta_posicao_taloes%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((remessa!=null)?remessa.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((talao!=null)?talao.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= atualiza_controle_producao %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= fornecedor %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= ((fen_seq!=null)?fen_seq.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((processo!=null)?processo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= status %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((pares!=null)?pares.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(dt_envio, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(dt_retorno, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((oc!=null)?oc.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= situacao_oc %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= nota_fiscal %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((lin_cdgo!=null)?lin_cdgo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((ref_cdgo!=null)?ref_cdgo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((cab_cdgo!=null)?cab_cdgo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((cor_cdgo!=null)?cor_cdgo.toString():"") %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_consulta_posicao_taloes++;
                      if (i_bl_report_Jw_consulta_posicao_taloes<res_Jw_consulta_posicao_taloes.size()) {
                        t_jw_consulta_posicao_taloes = (portalbr.dbobj.view.Jw_consulta_posicao_taloes)res_Jw_consulta_posicao_taloes.elementAt(i_bl_report_Jw_consulta_posicao_taloes);
                        fil_filial = t_jw_consulta_posicao_taloes.getFil_filial()==null?"":t_jw_consulta_posicao_taloes.getFil_filial();
                        remessa = t_jw_consulta_posicao_taloes.getRemessa();
                        talao = t_jw_consulta_posicao_taloes.getTalao();
                        atualiza_controle_producao = t_jw_consulta_posicao_taloes.getAtualiza_controle_producao()==null?"":t_jw_consulta_posicao_taloes.getAtualiza_controle_producao();
                        forn_codigo = t_jw_consulta_posicao_taloes.getForn_codigo();
                        fornecedor = t_jw_consulta_posicao_taloes.getFornecedor()==null?"":t_jw_consulta_posicao_taloes.getFornecedor();
                        fen_seq = t_jw_consulta_posicao_taloes.getFen_seq();
                        processo = t_jw_consulta_posicao_taloes.getProcesso();
                        status = t_jw_consulta_posicao_taloes.getStatus()==null?"":t_jw_consulta_posicao_taloes.getStatus();
                        pares = t_jw_consulta_posicao_taloes.getPares();
                        dt_envio = (java.sql.Timestamp)t_jw_consulta_posicao_taloes.getDt_envio();
                        dt_retorno = (java.sql.Timestamp)t_jw_consulta_posicao_taloes.getDt_retorno();
                        oc = t_jw_consulta_posicao_taloes.getOc();
                        situacao_oc = t_jw_consulta_posicao_taloes.getSituacao_oc()==null?"":t_jw_consulta_posicao_taloes.getSituacao_oc();
                        nota_fiscal = t_jw_consulta_posicao_taloes.getNota_fiscal()==null?"":t_jw_consulta_posicao_taloes.getNota_fiscal();
                        lin_cdgo = t_jw_consulta_posicao_taloes.getLin_cdgo();
                        ref_cdgo = t_jw_consulta_posicao_taloes.getRef_cdgo();
                        cab_cdgo = t_jw_consulta_posicao_taloes.getCab_cdgo();
                        cor_cdgo = t_jw_consulta_posicao_taloes.getCor_cdgo();
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

            <html:form action="ind/ConsultaPosicaoTaloes_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
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

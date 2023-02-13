<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta Situação Ação Marketing
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(175)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <script type="text/javascript" src="../script/jquery.blockUI.js">
            </script>

            <%
            com.egen.util.jdbc.JdbcUtil j = null;
            try {
              j = new com.egen.util.jdbc.JdbcUtil();
              util.consultas.Query qr = new util.consultas.Query();
              %>

              <%
              java.util.Vector res_Jw_situacao_acao_marketing = (java.util.Vector)session.getAttribute("res_Jw_situacao_acao_marketing");
              %>

              <form  name="bl_report_Jw_situacao_acao_marketing" id="bl_report_Jw_situacao_acao_marketing" class="baseForm" method="post" >
                <%
                if (res_Jw_situacao_acao_marketing!=null && res_Jw_situacao_acao_marketing.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_situacao_acao_marketing"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Integer codigo_regional =  null;
                    java.lang.String nome_regional =  null;
                    java.lang.String sigla_uf =  null;
                    java.lang.Integer codigo_marca =  null;
                    java.lang.String descricao_marca =  null;
                    java.lang.Integer acao =  null;
                    java.sql.Date data_transacao =  null;
                    java.lang.Integer cdgo_tmidia =  null;
                    java.lang.String desc_tmidia =  null;
                    java.lang.Integer cli_cdgo =  null;
                    java.lang.String cli_rzao =  null;
                    java.lang.String rep_cdgo =  null;
                    java.lang.String rep_rzao =  null;
                    java.lang.String estagios =  null;
                    java.lang.String estagios_marcados =  null;
                    String[] estagios_split = null;
                    java.lang.String estagios_codigos =  null;
                    String[] estagios_codigos_split = null;
                    java.lang.Integer codigo_situacao =  null;
                    java.lang.String descricao_situacao =  null;
                    String sit_aprovado = "";
                    String sit_pendente = "";
                    String sit_aguarimg = "";
                    String sit_prodinst = "";
                    String sit_concluido = "";
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:center;" width="1%" colspan="7">
                      </td>
                      <td class="columnTdHeader" style="text-align:center;" width="1%" colspan="3">
                        <b>
                          Situação do Layout
                        </td>
                        <td class="columnTdHeader" style="text-align:center;" width="1%" colspan="6">
                        </td>

                      </tr>

                      <tr class="reportTr">

                        <td class="columnTdHeader" style="text-align:center;" width="1%">
                          Reg.
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Marca
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Representante
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Ação
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Cliente
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" width="1%">
                          Data
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Material
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Situação da Ação
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" width="1%">
                          Pendente
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" width="1%">
                          Aguar. Img.
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" width="1%">
                          Concluído
                        </td>

                        <%
                        estagios = qr.retorna(j, "SELECT rowtocol('SELECT initcap(descricao) FROM brio.acao_marketing_estagios order by ordem') FROM dual");
                        estagios_split = estagios.split(",");
                        for(int x=0;x<estagios_split.length;x++){
                          %>
                          <td class="columnTdHeader" style="text-align:center;" width="1%" >
                            <%= estagios_split[x] %>
                          </td>
                          <%
                        }
                        %>

                        <%
                        estagios_codigos = qr.retorna(j, "SELECT rowtocol('select estagio_cdgo FROM brio.acao_marketing_estagios order by ordem') FROM dual");
                        estagios_codigos_split = estagios_codigos.split(",");
                        %>

                      </tr>

                      <%
                      int i_bl_report_Jw_situacao_acao_marketing = 0;
                      while (i_bl_report_Jw_situacao_acao_marketing<res_Jw_situacao_acao_marketing.size()) {
                        portalbr.dbobj.view.Jw_situacao_acao_marketing t_jw_situacao_acao_marketing = (portalbr.dbobj.view.Jw_situacao_acao_marketing)res_Jw_situacao_acao_marketing.elementAt(i_bl_report_Jw_situacao_acao_marketing);
                        codigo_regional = t_jw_situacao_acao_marketing.getCodigo_regional();
                        nome_regional = t_jw_situacao_acao_marketing.getNome_regional()==null?"":t_jw_situacao_acao_marketing.getNome_regional();
                        sigla_uf = t_jw_situacao_acao_marketing.getSigla_uf()==null?"":t_jw_situacao_acao_marketing.getSigla_uf();
                        codigo_marca = t_jw_situacao_acao_marketing.getCodigo_marca();
                        descricao_marca = t_jw_situacao_acao_marketing.getDescricao_marca()==null?"":t_jw_situacao_acao_marketing.getDescricao_marca();
                        cli_cdgo = t_jw_situacao_acao_marketing.getCli_cdgo();
                        cli_rzao = t_jw_situacao_acao_marketing.getCli_rzao()==null?"":t_jw_situacao_acao_marketing.getCli_rzao();
                        acao = t_jw_situacao_acao_marketing.getAcao();
                        rep_cdgo = t_jw_situacao_acao_marketing.getRep_cdgo()==null?"":t_jw_situacao_acao_marketing.getRep_cdgo();
                        rep_rzao = t_jw_situacao_acao_marketing.getRep_rzao()==null?"":t_jw_situacao_acao_marketing.getRep_rzao();
                        data_transacao = (java.sql.Date)t_jw_situacao_acao_marketing.getData_transacao();
                        cdgo_tmidia = t_jw_situacao_acao_marketing.getCdgo_tmidia();
                        desc_tmidia = t_jw_situacao_acao_marketing.getDesc_tmidia()==null?"":t_jw_situacao_acao_marketing.getDesc_tmidia();
                        codigo_situacao = t_jw_situacao_acao_marketing.getCodigo_situacao();
                        descricao_situacao = t_jw_situacao_acao_marketing.getDescricao_situacao()==null?"":t_jw_situacao_acao_marketing.getDescricao_situacao();
                        estagios_marcados = t_jw_situacao_acao_marketing.getEstagios_marcados()==null?"":t_jw_situacao_acao_marketing.getEstagios_marcados();
                        String style_bl_report_Jw_situacao_acao_marketing="";
                        sit_aprovado = "";
                        sit_pendente = "";
                        sit_aguarimg = "";
                        sit_prodinst = "";
                        sit_concluido = "";
                        //-----------------------------------------
                        if(codigo_situacao==2){
                          sit_aprovado = "X";
                        }
                        if(codigo_situacao==4){
                          sit_aprovado = "X";
                          sit_pendente = "X";
                        }
                        if(codigo_situacao==5){
                          sit_aprovado = "X";
                          sit_pendente = "X";
                          sit_aguarimg = "X";
                        }
                        if(codigo_situacao==8){
                          sit_aprovado = "X";
                          sit_pendente = "X";
                          sit_aguarimg = "X";
                          sit_prodinst = "X";
                        }
                        if(codigo_situacao==10){
                          sit_aprovado = "X";
                          sit_pendente = "X";
                          sit_aguarimg = "X";
                          sit_prodinst = "X";
                          sit_concluido = "X";
                        }
                        //-----------------------------------------
                        if (!((i_bl_report_Jw_situacao_acao_marketing%2)!=0)) {
                          style_bl_report_Jw_situacao_acao_marketing="rowColor";
                        } else {
                          style_bl_report_Jw_situacao_acao_marketing="rowBlank";
                        }
                        %>

                        <tr class='<%= style_bl_report_Jw_situacao_acao_marketing %>' id="TRbl_report_Jw_situacao_acao_marketing<%=i_bl_report_Jw_situacao_acao_marketing%>" >
                          <td class="reportColumn" style="text-align:center;" >
                            <%= sigla_uf %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= ((codigo_marca!=null)?codigo_marca.toString():"") %>
                            -
                            <%= descricao_marca %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= ((rep_cdgo!=null)?rep_cdgo.toString():"") %>
                            -
                            <%= rep_rzao %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= ((acao!=null)?acao.toString():"") %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= ((cli_cdgo!=null)?cli_cdgo.toString():"") %>
                            -
                            <%= cli_rzao %>
                          </td>

                          <td class="reportColumn" style="text-align:center;width:1%;" >
                            <%= com.egen.util.text.FormatDate.format(data_transacao, "dd/MM/yyyy") %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= ((cdgo_tmidia!=null)?cdgo_tmidia.toString():"") %>
                            -
                            <%= desc_tmidia %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= descricao_situacao %>
                          </td>

                          <td class="columnTdHeader" style="text-align:center;" width="1%">
                            <%
                            if(sit_pendente.equals("X")) {
                              %>
                              <%
                              if(!(request.getParameter("excel")+"").equals("true")){
                                %>
                                <img src="../img/cb_checked.png" />
                                <%
                              } else {
                                %>
                                <b>
                                  x
                                </b>
                                <%
                              }
                              %>
                              <%
                            } else {
                              %>
                              <%
                              if(!(request.getParameter("excel")+"").equals("true")){
                                %>
                                <img src="../img/cb_unchecked.png" />
                                <%
                              }
                              %>
                              <%
                            }
                            %>
                          </td>

                          <td class="columnTdHeader" style="text-align:center;" width="1%">
                            <%
                            if(sit_aguarimg.equals("X")) {
                              %>
                              <%
                              if(!(request.getParameter("excel")+"").equals("true")){
                                %>
                                <img src="../img/cb_checked.png" />
                                <%
                              } else {
                                %>
                                <b>
                                  x
                                </b>
                                <%
                              }
                              %>
                              <%
                            } else {
                              %>
                              <%
                              if(!(request.getParameter("excel")+"").equals("true")){
                                %>
                                <img src="../img/cb_unchecked.png" />
                                <%
                              }
                              %>
                              <%
                            }
                            %>
                          </td>

                          <td class="columnTdHeader" style="text-align:center;" width="1%">
                            <%
                            if(sit_concluido.equals("X")) {
                              %>
                              <%
                              if(!(request.getParameter("excel")+"").equals("true")){
                                %>
                                <img src="../img/cb_checked.png" />
                                <%
                              } else {
                                %>
                                <b>
                                  x
                                </b>
                                <%
                              }
                              %>
                              <%
                            } else {
                              %>
                              <%
                              if(!(request.getParameter("excel")+"").equals("true")){
                                %>
                                <img src="../img/cb_unchecked.png" />
                                <%
                              }
                              %>
                              <%
                            }
                            %>
                          </td>


                          <%
                          for(int x=0;x<estagios_split.length;x++){
                            %>
                            <td class="reportColumn" style="text-align:center;" width="1%" >
                              <%
                              if(estagios_marcados.indexOf(estagios_codigos_split[x])!=-1){
                                %>
                                <%
                                if(!(request.getParameter("excel")+"").equals("true")){
                                  %>
                                  <img src="../img/cb_checked.png" style="cursor:hand;border:'red'" onclick=""/>
                                  <br>
                                  <div style="font-family:arial, verdana;font-size:0.8em">
                                    <%= qr.retorna(j,"SELECT to_char(data_transacao,'dd/mm/yyyy hh:mi:ss') FROM brio.acao_marketing_estagios_status WHERE seq_acao_mkt = "+acao+" and estagio_cdgo = "+estagios_codigos_split[x]) %>
                                  </div>

                                  <%
                                } else {
                                  %>
                                  <b>
                                    x
                                  </b>
                                  <%
                                }
                                %>
                                <%
                              } else {
                                %>
                                <%
                                if(!(request.getParameter("excel")+"").equals("true")){
                                  %>
                                  <img src="../img/cb_unchecked.png" style="cursor:hand;border:'red'" onclick=""/>
                                  <%
                                }
                                %>
                                <%
                              }
                              %>
                            </td>
                            <%
                          }
                          %>




                        </tr>

                        <%
                        i_bl_report_Jw_situacao_acao_marketing++;
                        if (i_bl_report_Jw_situacao_acao_marketing<res_Jw_situacao_acao_marketing.size()) {
                          t_jw_situacao_acao_marketing = (portalbr.dbobj.view.Jw_situacao_acao_marketing)res_Jw_situacao_acao_marketing.elementAt(i_bl_report_Jw_situacao_acao_marketing);
                          codigo_regional = t_jw_situacao_acao_marketing.getCodigo_regional();
                          nome_regional = t_jw_situacao_acao_marketing.getNome_regional()==null?"":t_jw_situacao_acao_marketing.getNome_regional();
                          sigla_uf = t_jw_situacao_acao_marketing.getSigla_uf()==null?"":t_jw_situacao_acao_marketing.getSigla_uf();
                          codigo_marca = t_jw_situacao_acao_marketing.getCodigo_marca();
                          descricao_marca = t_jw_situacao_acao_marketing.getDescricao_marca()==null?"":t_jw_situacao_acao_marketing.getDescricao_marca();
                          acao = t_jw_situacao_acao_marketing.getAcao();
                          cli_cdgo = t_jw_situacao_acao_marketing.getCli_cdgo();
                          cli_rzao = t_jw_situacao_acao_marketing.getCli_rzao()==null?"":t_jw_situacao_acao_marketing.getCli_rzao();
                          rep_cdgo = t_jw_situacao_acao_marketing.getRep_cdgo()==null?"":t_jw_situacao_acao_marketing.getRep_cdgo();
                          rep_rzao = t_jw_situacao_acao_marketing.getRep_rzao()==null?"":t_jw_situacao_acao_marketing.getRep_rzao();
                          data_transacao = (java.sql.Date)t_jw_situacao_acao_marketing.getData_transacao();
                          cdgo_tmidia = t_jw_situacao_acao_marketing.getCdgo_tmidia();
                          desc_tmidia = t_jw_situacao_acao_marketing.getDesc_tmidia()==null?"":t_jw_situacao_acao_marketing.getDesc_tmidia();
                          codigo_situacao = t_jw_situacao_acao_marketing.getCodigo_situacao();
                          descricao_situacao = t_jw_situacao_acao_marketing.getDescricao_situacao()==null?"":t_jw_situacao_acao_marketing.getDescricao_situacao();
                          estagios_marcados = t_jw_situacao_acao_marketing.getEstagios_marcados()==null?"":t_jw_situacao_acao_marketing.getEstagios_marcados();
                          sit_aprovado = "";
                          sit_pendente = "";
                          sit_aguarimg = "";
                          sit_prodinst = "";
                          sit_concluido = "";
                          //-----------------------------------------
                          if(codigo_situacao==2){
                            sit_aprovado = "X";
                          }
                          if(codigo_situacao==4){
                            sit_aprovado = "X";
                            sit_pendente = "X";
                          }
                          if(codigo_situacao==5){
                            sit_aprovado = "X";
                            sit_pendente = "X";
                            sit_aguarimg = "X";
                          }
                          if(codigo_situacao==8){
                            sit_aprovado = "X";
                            sit_pendente = "X";
                            sit_aguarimg = "X";
                            sit_prodinst = "X";
                          }
                          if(codigo_situacao==10){
                            sit_aprovado = "X";
                            sit_pendente = "X";
                            sit_aguarimg = "X";
                            sit_prodinst = "X";
                            sit_concluido = "X";
                          }
                          //-----------------------------------------
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
              } finally {
                if (j != null) {
                  j.close();
                }
              }
              %>
              <html:form action="com/SituacaoAcaoMarketing_rForm.do" method="post" styleClass="baseForm">
                <table class="messageTable" style='width:99%;'>
                  <tr class="messageTr" >
                    <td class="messageTd">
                      <div style=font-size:11px;font-weight:normal;>

                      </div>
                      <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                    </td>
                  </tr>
                </table>

                <table class="itemTable"  style="width:99%;">
                  <html:hidden property="acao"/>
                  <html:hidden property="estagio"/>
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
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <html:submit accesskey="i" styleClass="myhidden" property="check_action">
                          <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                        </html:submit>
                        <%
                      }
                      %>
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <html:submit value="Blank" styleClass="myhidden" property="uncheck_action">
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

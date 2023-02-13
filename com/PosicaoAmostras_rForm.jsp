<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Posição de Entregas de Amostras
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(179)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <script type="text/javascript" src="../script/jquery.js">
            </script>
            <script type="text/javascript" src="../script/thickbox.js">
            </script>

            <%
            com.egen.util.jdbc.JdbcUtil j = null;
            try {
              j = new com.egen.util.jdbc.JdbcUtil();
              %>

              <%
              java.util.Vector res_Ped_amostra_rep_vw = (java.util.Vector)session.getAttribute("res_Ped_amostra_rep_vw");
              %>

              <form  name="bl_report_Ped_amostra_rep_vw" id="bl_report_Ped_amostra_rep_vw" class="baseForm" method="post" >
                <%
                if (res_Ped_amostra_rep_vw!=null && res_Ped_amostra_rep_vw.size()>0) {
                  %>

                  <table id="TRbl_report_Ped_amostra_rep_vw"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Integer nfs_nmro =  null;
                    java.lang.Integer ped_nmro =  null;
                    java.lang.Integer lin_cdgo =  null;
                    java.lang.String tipo_produto =  null;
                    java.lang.String rep =  null;
                    java.lang.String regional =  null;
                    java.lang.String cliente =  null;
                    java.lang.String observacao =  null;
                    java.lang.String obs_atendente =  null;
                    java.lang.String usuario_data_inclusao =  null;
                    java.lang.String tra =  null;
                    java.lang.String consig =  null;
                    java.lang.Integer regional_cdgo =  null;
                    java.lang.String rep_cdgo =  null;
                    java.lang.Integer cli_cdgo =  null;
                    java.sql.Date ped_dadg =  null;
                    java.lang.String estagios =  null;
                    java.lang.String estagios_marcados =  null;
                    String[] estagios_split = null;
                    java.lang.String estagios_codigos =  null;
                    String[] estagios_codigos_split = null;
                    java.lang.Integer id_situacao =  null;
                    int posicao = 0;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:center;" >
                        Nota Fiscal
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Pedido
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Linha
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Representante
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Regional
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Cliente
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Transportadora
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Consig.
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Data
                      </td>

                      <td class="columnTdHeader" style="text-align:center;"  >
                        Usuário /
                        <br>
                        Data Inclusão
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Recebido
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Observação
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Obs. Atendente
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Ped_amostra_rep_vw = 0;
                    while (i_bl_report_Ped_amostra_rep_vw<res_Ped_amostra_rep_vw.size()) {
                      portalbr.dbobj.table.Ped_amostra_rep_vw t_ped_amostra_rep_vw = (portalbr.dbobj.table.Ped_amostra_rep_vw)res_Ped_amostra_rep_vw.elementAt(i_bl_report_Ped_amostra_rep_vw);
                      nfs_nmro = t_ped_amostra_rep_vw.getNfs_nmro();
                      ped_nmro = t_ped_amostra_rep_vw.getPed_nmro();
                      rep = t_ped_amostra_rep_vw.getRep()==null?"":t_ped_amostra_rep_vw.getRep();
                      regional = t_ped_amostra_rep_vw.getRegional()==null?"":t_ped_amostra_rep_vw.getRegional();
                      cliente = t_ped_amostra_rep_vw.getCliente()==null?"":t_ped_amostra_rep_vw.getCliente();
                      tra = t_ped_amostra_rep_vw.getTra()==null?"":t_ped_amostra_rep_vw.getTra();
                      consig = t_ped_amostra_rep_vw.getConsig()==null?"":t_ped_amostra_rep_vw.getConsig();
                      regional_cdgo = t_ped_amostra_rep_vw.getRegional_cdgo();
                      rep_cdgo = t_ped_amostra_rep_vw.getRep_cdgo()==null?"":t_ped_amostra_rep_vw.getRep_cdgo();
                      cli_cdgo = t_ped_amostra_rep_vw.getCli_cdgo();
                      lin_cdgo = t_ped_amostra_rep_vw.getLin_cdgo();
                      tipo_produto = t_ped_amostra_rep_vw.getTipo_produto()==null?"":t_ped_amostra_rep_vw.getTipo_produto();
                      ped_dadg = (java.sql.Date)t_ped_amostra_rep_vw.getPed_dadg();
                      estagios_marcados = t_ped_amostra_rep_vw.getEstagios_marcados()==null?"":t_ped_amostra_rep_vw.getEstagios_marcados();
                      usuario_data_inclusao= t_ped_amostra_rep_vw.getUsuario_data_inclusao()==null?"":t_ped_amostra_rep_vw.getUsuario_data_inclusao();
                      observacao = t_ped_amostra_rep_vw.getObservacao()==null?"":t_ped_amostra_rep_vw.getObservacao();
                      obs_atendente = t_ped_amostra_rep_vw.getObs_atendente()==null?"":t_ped_amostra_rep_vw.getObs_atendente();
                      id_situacao = t_ped_amostra_rep_vw.getId_situacao();
                      String style_bl_report_Ped_amostra_rep_vw="";
                      if (!((i_bl_report_Ped_amostra_rep_vw%2)!=0)) {
                        style_bl_report_Ped_amostra_rep_vw="rowColor";
                      } else {
                        style_bl_report_Ped_amostra_rep_vw="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Ped_amostra_rep_vw %>' id="TRbl_report_Ped_amostra_rep_vw<%=i_bl_report_Ped_amostra_rep_vw%>" >
                        <td class="reportColumn" style="text-align:center;" >
                          <%= ((nfs_nmro!=null)?nfs_nmro.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <a href="../com/ConsultaPedidos_iForm.do?select_action=&pedido_beira_rio=<%= ped_nmro %>" target="_self" STYLE="cursor:hand">
                              <%= ((ped_nmro!=null)?ped_nmro.toString():"") %>
                            </a>
                            <%
                          } else {
                            %>
                            <%= ((ped_nmro!=null)?ped_nmro.toString():"") %>
                            <%
                          }
                          %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= lin_cdgo %>
                          -
                          <%= tipo_produto %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= rep %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= regional %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cliente %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= tra %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= consig %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(ped_dadg, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <small>
                            <%= usuario_data_inclusao %>
                          </small>
                        </td>


                        <td class="reportColumn" style="text-align:center;" width="1%" >
                          <%
                          if(estagios_marcados.equals("1")){
                            %>
                            <%
                            if(!(request.getParameter("excel")+"").equals("true")){
                              %>
                              <img src="../img/cb_checked.png" style="cursor:hand;border:'red'" onclick="if(this.src.indexOf('cb_checked.png')!=-1){jQuery.post('PosicaoAmostras_rForm.do?uncheck_action=&ped_nmro=<%= ped_nmro %>&indice=<%= posicao %>',function(){alert('Registro salvo com sucesso!')});this.src='../img/cb_unchecked.png';}else{jQuery.post('PosicaoAmostras_rForm.do?check_action=&ped_nmro=<%= ped_nmro %>&indice=<%= posicao %>',function(){alert('Registro salvo com sucesso!')});this.src='../img/cb_checked.png';}"/>
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
                              <img src="../img/cb_unchecked.png" style="cursor:hand;border:'red'" onclick="if(this.src.indexOf('cb_unchecked.png')!=-1){jQuery.post('PosicaoAmostras_rForm.do?check_action=&ped_nmro=<%= ped_nmro %>&indice=<%= posicao %>',function(){alert('Registro salvo com sucesso!')});this.src='../img/cb_checked.png';}else{jQuery.post('PosicaoAmostras_rForm.do?uncheck_action=&ped_nmro=<%= ped_nmro %>&indice=<%= posicao %>',function(){alert('Registro salvo com sucesso!')});this.src='../img/cb_unchecked.png';}"/>
                              <%
                            }
                            %>
                            <%
                          }
                          %>
                        </td>


                        <td class="reportColumn" style="text-align:left;" >
                          <%
                          if(observacao.equals("")){
                            %>
                            <%
                            if(!(request.getParameter("excel")+"").equals("true")){
                              %>
                              <a href='../com/PosicaoAmostras_iForm.do?select_action=&ped_nmro=<%= ped_nmro %>&posicao=<%= posicao %>&?keepThis=true&TB_iframe=true&height=280&width=600' title='Observação' class='thickbox'>
<div id="<%= ped_nmro %>" <font color="red" style="cursor:hand">Adicionar Observação</font> </div> </a> <% } else { %> <font color="red" style="cursor:hand">Adicionar Observação</font> <% } %> <% } else { %> <% if(!(request.getParameter("excel")+"").equals("true")){ %> <a href='../com/PosicaoAmostras_iForm.do?select_action=&ped_nmro=<%= ped_nmro %>&posicao=<%= posicao %>&?keepThis=true&TB_iframe=true&height=280&width=600' title='Observação' class='thickbox'> <div id="<%= ped_nmro %>"> <font style="cursor:hand"><%= observacao %></font> </div> </a> <% } else { %> <font style="cursor:hand"><%= observacao %></font> <% } %> <% } %> </td>    <td class="reportColumn" style="text-align:left;" > <% if(obs_atendente.equals("")){ %> <% if(!(request.getParameter("excel")+"").equals("true")){ %> <a href='../com/PosicaoAmostras_oForm.do?select_action=&ped_nmro=<%= ped_nmro %>&posicao=<%= posicao %>&?keepThis=true&TB_iframe=true&height=280&width=600' title='Observação Atendente' class='thickbox'> <div id="obs<%= ped_nmro %>" <font color="red" style="cursor:hand">Adicionar Observação</font> </div> </a> <% } else { %> <font color="red" style="cursor:hand">Adicionar Observação</font> <% } %> <% } else { %> <% if(!(request.getParameter("excel")+"").equals("true")){ %> <a href='../com/PosicaoAmostras_oForm.do?select_action=&ped_nmro=<%= ped_nmro %>&posicao=<%= posicao %>&?keepThis=true&TB_iframe=true&height=280&width=600' title='Observação Atendente' class='thickbox'> <div id="obs<%= ped_nmro %>"> <font style="cursor:hand"><%= obs_atendente %></font> </div> </a> <% } else { %> <font style="cursor:hand"><%= obs_atendente %></font> <% } %> <% } %> </td>   </tr> <% ++posicao; %>  <% i_bl_report_Ped_amostra_rep_vw++; if (i_bl_report_Ped_amostra_rep_vw<res_Ped_amostra_rep_vw.size()) { t_ped_amostra_rep_vw = (portalbr.dbobj.table.Ped_amostra_rep_vw)res_Ped_amostra_rep_vw.elementAt(i_bl_report_Ped_amostra_rep_vw); nfs_nmro = t_ped_amostra_rep_vw.getNfs_nmro(); ped_nmro = t_ped_amostra_rep_vw.getPed_nmro(); rep = t_ped_amostra_rep_vw.getRep()==null?"":t_ped_amostra_rep_vw.getRep(); regional = t_ped_amostra_rep_vw.getRegional()==null?"":t_ped_amostra_rep_vw.getRegional(); cliente = t_ped_amostra_rep_vw.getCliente()==null?"":t_ped_amostra_rep_vw.getCliente(); tra = t_ped_amostra_rep_vw.getTra()==null?"":t_ped_amostra_rep_vw.getTra(); consig = t_ped_amostra_rep_vw.getConsig()==null?"":t_ped_amostra_rep_vw.getConsig(); regional_cdgo = t_ped_amostra_rep_vw.getRegional_cdgo(); rep_cdgo = t_ped_amostra_rep_vw.getRep_cdgo()==null?"":t_ped_amostra_rep_vw.getRep_cdgo(); cli_cdgo = t_ped_amostra_rep_vw.getCli_cdgo(); lin_cdgo = t_ped_amostra_rep_vw.getLin_cdgo(); tipo_produto = t_ped_amostra_rep_vw.getTipo_produto()==null?"":t_ped_amostra_rep_vw.getTipo_produto(); ped_dadg = (java.sql.Date)t_ped_amostra_rep_vw.getPed_dadg(); estagios_marcados = t_ped_amostra_rep_vw.getEstagios_marcados()==null?"":t_ped_amostra_rep_vw.getEstagios_marcados(); observacao = t_ped_amostra_rep_vw.getObservacao()==null?"":t_ped_amostra_rep_vw.getObservacao(); obs_atendente = t_ped_amostra_rep_vw.getObs_atendente()==null?"":t_ped_amostra_rep_vw.getObs_atendente(); usuario_data_inclusao= t_ped_amostra_rep_vw.getUsuario_data_inclusao()==null?"":t_ped_amostra_rep_vw.getUsuario_data_inclusao(); id_situacao = t_ped_amostra_rep_vw.getId_situacao(); } else { } } %>  </table>  <% } %>  </form> <% } finally { if (j != null) { j.close(); } } %>  <script> function atualiza(pedido, valor){ jQuery('#'+pedido).html(valor); }  function atualizaobservacao(pedido, valor){ jQuery('#obs'+pedido).html(valor); } </script>  <html:form action="com/PosicaoAmostras_rForm.do" method="post" styleClass="baseForm"> <table class="messageTable" style='width:99%;'> <tr class="messageTr" > <td class="messageTd"> </td> </tr> </table>  <table class="itemTable"  style="width:99%;"> <html:hidden property="ped_nmro"/> <html:hidden property="estagio"/> <html:hidden property="indice"/> </table>  <table class="buttonTable" style='width:99%;'> <tr class="buttonTr"> <td class="buttonTd"> <% if(!(request.getParameter("excel")+"").equals("true")){ %> <html:submit accesskey="a" styleClass="baseButton" property="back_action"> <bean:message bundle="ApplicationResources" key="jsp.back"/> </html:submit> <% } %> <% if(!(request.getParameter("excel")+"").equals("true")){ %> <html:submit value="check" styleClass="myhidden" property="check_action"> </html:submit> <% } %> <% if(!(request.getParameter("excel")+"").equals("true")){ %> <html:submit value="uncheck" styleClass="myhidden" property="uncheck_action"> </html:submit> <% } %> </td> </tr> </table>  </html:form> </td> </tr> </table>  </body> </center> </html>

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Verificação Caixas Individuais X Corrugados
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(165)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/VerificacaoCaixasIndividuaisCorrugadosForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="rotulo"/>
                    <html:errors property="mensagem"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Rótulo
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="rotulo" styleId="rotulo" onblur="if(this.value!=''){execute_action.click();}" styleClass="baseField"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                    <%
                    String estilo = "";
                    String mensagem = (String)request.getAttribute("mensagem")+"";
                    if(mensagem.equalsIgnoreCase("null")){
                      mensagem = "";
                    }
                    if(mensagem.equalsIgnoreCase("Caixa OK!")){
                      estilo = "background-color:transparent; height: 25px; border-style:none; color:red; font-size:20px; background-color:transparent; border-style:none; cursor:default; text-align:start;";
                    } else {
                      estilo = "background-color:transparent; height: 25px; border-style:none; color:blue; font-size: 16px; background-color:transparent; border-style:none; cursor:default; text-align:start;";
                    }
                    %>
                    <html:text property="mensagem" styleId="mensagem" style="<%= estilo %>"  tabindex="-1" readonly="true" value="<%= mensagem %>" size="100"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit value="Execute" styleClass="myhidden" property="execute_action">
                    </html:submit>
                    <html:submit styleClass="baseButton" property="resetfull_action">
                      Limpar
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["rotulo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_verif_caixas_corrugados = (java.util.Vector)session.getAttribute("res_Jw_verif_caixas_corrugados");
              %>

              <form  name="bl_report_Jw_verif_caixas_corrugados" id="bl_report_Jw_verif_caixas_corrugados" class="baseForm" method="post" >

                <%
                if (res_Jw_verif_caixas_corrugados!=null && res_Jw_verif_caixas_corrugados.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_verif_caixas_corrugados"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Integer rem_nro =  null;
                    java.lang.Integer seq_rotulo =  null;
                    java.lang.Integer ped_nmro =  null;
                    java.lang.Integer lin_cdgo =  null;
                    java.lang.Integer ref_cdgo =  null;
                    java.lang.Integer cab_cdgo =  null;
                    java.lang.Integer cor_cdgo =  null;
                    java.lang.String qtt_nume =  null;
                    java.lang.String produto =  null;
                    java.lang.String processou =  null;
                    java.lang.Integer qtt_pars =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Remessa
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Caixa
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Pedido
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Linha
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Referência
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Cabedal
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Cor
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Tamanho
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Qtd.
                      </td>
                      <td class="columnTdHeader" style="text-align:center; width=1%" >
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_verif_caixas_corrugados = 0;
                    while (i_bl_report_Jw_verif_caixas_corrugados<res_Jw_verif_caixas_corrugados.size()) {
                      portalbr.dbobj.view.Jw_verif_caixas_corrugados t_jw_verif_caixas_corrugados = (portalbr.dbobj.view.Jw_verif_caixas_corrugados)res_Jw_verif_caixas_corrugados.elementAt(i_bl_report_Jw_verif_caixas_corrugados);
                      rem_nro = t_jw_verif_caixas_corrugados.getRem_nro();
                      seq_rotulo = t_jw_verif_caixas_corrugados.getSeq_rotulo();
                      ped_nmro = t_jw_verif_caixas_corrugados.getPed_nmro();
                      lin_cdgo = t_jw_verif_caixas_corrugados.getLin_cdgo();
                      ref_cdgo = t_jw_verif_caixas_corrugados.getRef_cdgo();
                      cab_cdgo = t_jw_verif_caixas_corrugados.getCab_cdgo();
                      cor_cdgo = t_jw_verif_caixas_corrugados.getCor_cdgo();
                      qtt_nume = t_jw_verif_caixas_corrugados.getQtt_nume()==null?"":t_jw_verif_caixas_corrugados.getQtt_nume();
                      produto = t_jw_verif_caixas_corrugados.getProduto()==null?"":t_jw_verif_caixas_corrugados.getProduto();
                      processou = t_jw_verif_caixas_corrugados.getProcessou()==null?"":t_jw_verif_caixas_corrugados.getProcessou();
                      qtt_pars = t_jw_verif_caixas_corrugados.getQtt_pars();
                      String style_bl_report_Jw_verif_caixas_corrugados="";
                      if(qtt_pars == 0){
                        if (!((i_bl_report_Jw_verif_caixas_corrugados%2)!=0)) {
                          style_bl_report_Jw_verif_caixas_corrugados="rowColor";
                        } else {
                          style_bl_report_Jw_verif_caixas_corrugados="rowBlank";
                        }
                      } else {
                        style_bl_report_Jw_verif_caixas_corrugados="rowRed";
                      }

                      if(qtt_pars == 0){
                        style_bl_report_Jw_verif_caixas_corrugados = "rowGreen";
                      } else {
                        if(processou.equals("S")){
                          style_bl_report_Jw_verif_caixas_corrugados = "rowYellow";
                        } else {
                          style_bl_report_Jw_verif_caixas_corrugados = "rowRed";
                        } }
                        %>

                        <tr class='<%= style_bl_report_Jw_verif_caixas_corrugados %>' id="TRbl_report_Jw_verif_caixas_corrugados<%=i_bl_report_Jw_verif_caixas_corrugados%>" >
                          <td class="reportColumn" style="text-align:right;" >
                            <%= ((rem_nro!=null)?rem_nro.toString():"") %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= ((seq_rotulo!=null)?seq_rotulo.toString():"") %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= ((ped_nmro!=null)?ped_nmro.toString():"") %>
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

                          <td class="reportColumn" style="text-align:left;" >
                            <%= qtt_nume %>
                          </td>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= ((qtt_pars!=null)?qtt_pars.toString():"") %>
                          </td>

                          <td class="columnTdHeader" style="text-align:center; width=1%" >
                            <%
                            if(qtt_pars == 0){
                              %>
                              <img src="../img/green.gif" />
                              <%
                            } else {
                              if(processou.equals("S")){
                                %>
                                <img src="../img/yellow.gif" />
                                <%
                              } else {
                                %>
                                <img src="../img/red.gif" />
                                <%
                              } }
                              %>
                            </td>

                          </tr>

                          <%
                          i_bl_report_Jw_verif_caixas_corrugados++;
                          if (i_bl_report_Jw_verif_caixas_corrugados<res_Jw_verif_caixas_corrugados.size()) {
                            t_jw_verif_caixas_corrugados = (portalbr.dbobj.view.Jw_verif_caixas_corrugados)res_Jw_verif_caixas_corrugados.elementAt(i_bl_report_Jw_verif_caixas_corrugados);
                            rem_nro = t_jw_verif_caixas_corrugados.getRem_nro();
                            seq_rotulo = t_jw_verif_caixas_corrugados.getSeq_rotulo();
                            ped_nmro = t_jw_verif_caixas_corrugados.getPed_nmro();
                            lin_cdgo = t_jw_verif_caixas_corrugados.getLin_cdgo();
                            ref_cdgo = t_jw_verif_caixas_corrugados.getRef_cdgo();
                            cab_cdgo = t_jw_verif_caixas_corrugados.getCab_cdgo();
                            cor_cdgo = t_jw_verif_caixas_corrugados.getCor_cdgo();
                            qtt_nume = t_jw_verif_caixas_corrugados.getQtt_nume()==null?"":t_jw_verif_caixas_corrugados.getQtt_nume();
                            produto = t_jw_verif_caixas_corrugados.getProduto()==null?"":t_jw_verif_caixas_corrugados.getProduto();
                            processou = t_jw_verif_caixas_corrugados.getProcessou()==null?"":t_jw_verif_caixas_corrugados.getProcessou();
                            qtt_pars = t_jw_verif_caixas_corrugados.getQtt_pars();
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

              </td>
            </tr>
          </table>

        </body>
      </center>
    </html>

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Relatório Apontamento Caixas Corrugadas
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(329)){
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
              java.util.Vector res_Jw_apontamento_caixas_corrugadas = (java.util.Vector)session.getAttribute("res_Jw_apontamento_caixas_corrugadas");
              %>

              <form  name="bl_report_Jw_apontamento_caixas_corrugadas_1" id="bl_report_Jw_apontamento_caixas_corrugadas_1" class="baseForm" method="post" >
                <%
                if (res_Jw_apontamento_caixas_corrugadas!=null && res_Jw_apontamento_caixas_corrugadas.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_apontamento_caixas_corrugadas_1"  class="reportTable"   style="width:99%; "  border="1"  frame="box">
                    <%
                    java.lang.String emp_empresa1 =  null;
                    java.lang.String fil_filial1 =  null;
                    java.lang.Integer codigo_marca1 =  null;
                    java.lang.String descricao_marca1 =  null;
                    java.lang.Integer cli_cdgo1 =  null;
                    java.lang.String cli_desc1 =  null;
                    java.lang.String apont1 =  null;
                    java.sql.Timestamp data_apont1 =  null;
                    java.lang.String usuario_apont1 =  null;
                    java.sql.Timestamp data_alteracao1 =  null;
                    java.lang.String usuario_alteracao1 =  null;
                    java.lang.String ped_invoice1 =  null;
                    java.lang.Integer normativa1 =  null;
                    java.lang.Integer tra_cdgo1 =  null;
                    java.lang.Integer rem_nro1 =  null;
                    java.lang.Integer seq_rotulo1 =  null;
                    java.lang.Integer ped_nmro1 =  null;
                    java.lang.Integer ite_seqn1 =  null;
                    java.lang.Integer lin_cdgo1 =  null;
                    java.lang.Integer ref_cdgo1 =  null;
                    java.lang.Integer cab_cdgo1 =  null;
                    java.lang.Integer cor_cdgo1 =  null;
                    java.lang.Integer qtde1 =  null;
                    int sum_qtde1_0 = 0;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:center;" >
                        Emp.
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Filial
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Marca
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Cliente
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Apont.
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Data Apont.
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Usuário Apont.
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Dt. Alteração
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Usuário Alteração
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Invoice
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Norm.
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Tra.
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Remessa
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Caixa
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Pedido
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Item
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Linha
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Ref.
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Cab.
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Cor
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Qtde.
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_apontamento_caixas_corrugadas_1 = 0;
                    while (i_bl_report_Jw_apontamento_caixas_corrugadas_1<res_Jw_apontamento_caixas_corrugadas.size()) {
                      portalbr.dbobj.view.Jw_apontamento_caixas_corrugadas t_jw_apontamento_caixas_corrugadas = (portalbr.dbobj.view.Jw_apontamento_caixas_corrugadas)res_Jw_apontamento_caixas_corrugadas.elementAt(i_bl_report_Jw_apontamento_caixas_corrugadas_1);
                      emp_empresa1 = t_jw_apontamento_caixas_corrugadas.getEmp_empresa()==null?"":t_jw_apontamento_caixas_corrugadas.getEmp_empresa();
                      fil_filial1 = t_jw_apontamento_caixas_corrugadas.getFil_filial()==null?"":t_jw_apontamento_caixas_corrugadas.getFil_filial();
                      codigo_marca1 = t_jw_apontamento_caixas_corrugadas.getCodigo_marca();
                      descricao_marca1 = t_jw_apontamento_caixas_corrugadas.getDescricao_marca()==null?"":t_jw_apontamento_caixas_corrugadas.getDescricao_marca();
                      cli_cdgo1 = t_jw_apontamento_caixas_corrugadas.getCli_cdgo();
                      cli_desc1 = t_jw_apontamento_caixas_corrugadas.getCli_desc()==null?"":t_jw_apontamento_caixas_corrugadas.getCli_desc();
                      apont1 = t_jw_apontamento_caixas_corrugadas.getApont()==null?"":t_jw_apontamento_caixas_corrugadas.getApont();
                      data_apont1 = (java.sql.Timestamp)t_jw_apontamento_caixas_corrugadas.getData_apont();
                      usuario_apont1 = t_jw_apontamento_caixas_corrugadas.getUsuario_apont()==null?"":t_jw_apontamento_caixas_corrugadas.getUsuario_apont();
                      data_alteracao1 = (java.sql.Timestamp)t_jw_apontamento_caixas_corrugadas.getData_alteracao();
                      usuario_alteracao1 = t_jw_apontamento_caixas_corrugadas.getUsuario_alteracao()==null?"":t_jw_apontamento_caixas_corrugadas.getUsuario_alteracao();
                      ped_invoice1 = t_jw_apontamento_caixas_corrugadas.getPed_invoice()==null?"":t_jw_apontamento_caixas_corrugadas.getPed_invoice();
                      normativa1 = t_jw_apontamento_caixas_corrugadas.getNormativa();
                      tra_cdgo1 = t_jw_apontamento_caixas_corrugadas.getTra_cdgo();
                      rem_nro1 = t_jw_apontamento_caixas_corrugadas.getRem_nro();
                      seq_rotulo1 = t_jw_apontamento_caixas_corrugadas.getSeq_rotulo();
                      ped_nmro1 = t_jw_apontamento_caixas_corrugadas.getPed_nmro();
                      ite_seqn1 = t_jw_apontamento_caixas_corrugadas.getIte_seqn();
                      lin_cdgo1 = t_jw_apontamento_caixas_corrugadas.getLin_cdgo();
                      ref_cdgo1 = t_jw_apontamento_caixas_corrugadas.getRef_cdgo();
                      cab_cdgo1 = t_jw_apontamento_caixas_corrugadas.getCab_cdgo();
                      cor_cdgo1 = t_jw_apontamento_caixas_corrugadas.getCor_cdgo();
                      qtde1 = t_jw_apontamento_caixas_corrugadas.getQtde();
                      sum_qtde1_0 += ((qtde1!=null)?qtde1.intValue():0);
                      String style_bl_report_Jw_apontamento_caixas_corrugadas_1="";
                      if (!((i_bl_report_Jw_apontamento_caixas_corrugadas_1%2)!=0)) {
                        style_bl_report_Jw_apontamento_caixas_corrugadas_1="rowColor";
                      } else {
                        style_bl_report_Jw_apontamento_caixas_corrugadas_1="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_apontamento_caixas_corrugadas_1 %>' id="TRbl_report_Jw_apontamento_caixas_corrugadas_1<%=i_bl_report_Jw_apontamento_caixas_corrugadas_1%>" >
                        <td class="reportColumn" style="text-align:center;" >
                          <%= emp_empresa1 %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= fil_filial1 %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((codigo_marca1!=null)?codigo_marca1.toString():"") %>
                          -
                          <%= descricao_marca1 %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= ((cli_cdgo1!=null)?cli_cdgo1.toString():"") %>
                          -
                          <%= cli_desc1 %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= apont1 %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_apont1, "dd/MM/yyyy HH:mm:ss") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= usuario_apont1 %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_alteracao1, "dd/MM/yyyy HH:mm:ss") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= usuario_alteracao1 %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= ped_invoice1 %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((normativa1!=null)?normativa1.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((tra_cdgo1!=null)?tra_cdgo1.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= ((rem_nro1!=null)?rem_nro1.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= ((seq_rotulo1!=null)?seq_rotulo1.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= ((ped_nmro1!=null)?ped_nmro1.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= ((ite_seqn1!=null)?ite_seqn1.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= ((lin_cdgo1!=null)?lin_cdgo1.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= ((ref_cdgo1!=null)?ref_cdgo1.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((cab_cdgo1!=null)?cab_cdgo1.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= ((cor_cdgo1!=null)?cor_cdgo1.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((qtde1!=null)?qtde1.toString():"") %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_apontamento_caixas_corrugadas_1++;
                      if (i_bl_report_Jw_apontamento_caixas_corrugadas_1<res_Jw_apontamento_caixas_corrugadas.size()) {
                        t_jw_apontamento_caixas_corrugadas = (portalbr.dbobj.view.Jw_apontamento_caixas_corrugadas)res_Jw_apontamento_caixas_corrugadas.elementAt(i_bl_report_Jw_apontamento_caixas_corrugadas_1);
                        emp_empresa1 = t_jw_apontamento_caixas_corrugadas.getEmp_empresa()==null?"":t_jw_apontamento_caixas_corrugadas.getEmp_empresa();
                        fil_filial1 = t_jw_apontamento_caixas_corrugadas.getFil_filial()==null?"":t_jw_apontamento_caixas_corrugadas.getFil_filial();
                        codigo_marca1 = t_jw_apontamento_caixas_corrugadas.getCodigo_marca();
                        descricao_marca1 = t_jw_apontamento_caixas_corrugadas.getDescricao_marca()==null?"":t_jw_apontamento_caixas_corrugadas.getDescricao_marca();
                        cli_cdgo1 = t_jw_apontamento_caixas_corrugadas.getCli_cdgo();
                        cli_desc1 = t_jw_apontamento_caixas_corrugadas.getCli_desc()==null?"":t_jw_apontamento_caixas_corrugadas.getCli_desc();
                        apont1 = t_jw_apontamento_caixas_corrugadas.getApont()==null?"":t_jw_apontamento_caixas_corrugadas.getApont();
                        data_apont1 = (java.sql.Timestamp)t_jw_apontamento_caixas_corrugadas.getData_apont();
                        usuario_apont1 = t_jw_apontamento_caixas_corrugadas.getUsuario_apont()==null?"":t_jw_apontamento_caixas_corrugadas.getUsuario_apont();
                        data_alteracao1 = (java.sql.Timestamp)t_jw_apontamento_caixas_corrugadas.getData_alteracao();
                        usuario_alteracao1 = t_jw_apontamento_caixas_corrugadas.getUsuario_alteracao()==null?"":t_jw_apontamento_caixas_corrugadas.getUsuario_alteracao();
                        ped_invoice1 = t_jw_apontamento_caixas_corrugadas.getPed_invoice()==null?"":t_jw_apontamento_caixas_corrugadas.getPed_invoice();
                        normativa1 = t_jw_apontamento_caixas_corrugadas.getNormativa();
                        tra_cdgo1 = t_jw_apontamento_caixas_corrugadas.getTra_cdgo();
                        rem_nro1 = t_jw_apontamento_caixas_corrugadas.getRem_nro();
                        seq_rotulo1 = t_jw_apontamento_caixas_corrugadas.getSeq_rotulo();
                        ped_nmro1 = t_jw_apontamento_caixas_corrugadas.getPed_nmro();
                        ite_seqn1 = t_jw_apontamento_caixas_corrugadas.getIte_seqn();
                        lin_cdgo1 = t_jw_apontamento_caixas_corrugadas.getLin_cdgo();
                        ref_cdgo1 = t_jw_apontamento_caixas_corrugadas.getRef_cdgo();
                        cab_cdgo1 = t_jw_apontamento_caixas_corrugadas.getCab_cdgo();
                        cor_cdgo1 = t_jw_apontamento_caixas_corrugadas.getCor_cdgo();
                        qtde1 = t_jw_apontamento_caixas_corrugadas.getQtde();
                      } else {
                      }
                    }
                    %>

                    <tr class="totalColumn">
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td>
                        &nbsp;
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <%= sum_qtde1_0 + "" %>
                      </td>
                    </tr>

                    <%
                    %>

                  </table>

                  <%
                }
                %>

              </form>
              <%
            }
            %>

            <br />
            <%
            {
              %>

              <%
              java.util.Vector res_Jw_apontamento_caixas_corrugadas_resumo = (java.util.Vector)session.getAttribute("res_Jw_apontamento_caixas_corrugadas_resumo");
              %>

              <form  name="bl_report_Jw_apontamento_caixas_corrugadas_resumo" id="bl_report_Jw_apontamento_caixas_corrugadas_resumo" class="baseForm" method="post" >
                <%
                if (res_Jw_apontamento_caixas_corrugadas_resumo!=null && res_Jw_apontamento_caixas_corrugadas_resumo.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_apontamento_caixas_corrugadas_resumo"  class="reportTable"   style="width:30%; "  border="1"  frame="box">
                    <%
                    java.lang.Integer lin_cdgo =  null;
                    java.lang.Integer total_caixas =  null;
                    java.lang.Integer caixas_pendentes =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Linha
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Total de Caixas
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Caixas Pendentes
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_apontamento_caixas_corrugadas_resumo = 0;
                    while (i_bl_report_Jw_apontamento_caixas_corrugadas_resumo<res_Jw_apontamento_caixas_corrugadas_resumo.size()) {
                      portalbr.dbobj.view.Jw_apontamento_caixas_corrugadas_resumo t_jw_apontamento_caixas_corrugadas_resumo = (portalbr.dbobj.view.Jw_apontamento_caixas_corrugadas_resumo)res_Jw_apontamento_caixas_corrugadas_resumo.elementAt(i_bl_report_Jw_apontamento_caixas_corrugadas_resumo);
                      lin_cdgo = t_jw_apontamento_caixas_corrugadas_resumo.getLin_cdgo();
                      total_caixas = t_jw_apontamento_caixas_corrugadas_resumo.getTotal_caixas();
                      caixas_pendentes = t_jw_apontamento_caixas_corrugadas_resumo.getCaixas_pendentes();
                      String style_bl_report_Jw_apontamento_caixas_corrugadas_resumo="";
                      if (!((i_bl_report_Jw_apontamento_caixas_corrugadas_resumo%2)!=0)) {
                        style_bl_report_Jw_apontamento_caixas_corrugadas_resumo="rowColor";
                      } else {
                        style_bl_report_Jw_apontamento_caixas_corrugadas_resumo="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_apontamento_caixas_corrugadas_resumo %>' id="TRbl_report_Jw_apontamento_caixas_corrugadas_resumo<%=i_bl_report_Jw_apontamento_caixas_corrugadas_resumo%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((lin_cdgo!=null)?lin_cdgo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((total_caixas!=null)?total_caixas.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((caixas_pendentes!=null)?caixas_pendentes.toString():"") %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_apontamento_caixas_corrugadas_resumo++;
                      if (i_bl_report_Jw_apontamento_caixas_corrugadas_resumo<res_Jw_apontamento_caixas_corrugadas_resumo.size()) {
                        t_jw_apontamento_caixas_corrugadas_resumo = (portalbr.dbobj.view.Jw_apontamento_caixas_corrugadas_resumo)res_Jw_apontamento_caixas_corrugadas_resumo.elementAt(i_bl_report_Jw_apontamento_caixas_corrugadas_resumo);
                        lin_cdgo = t_jw_apontamento_caixas_corrugadas_resumo.getLin_cdgo();
                        total_caixas = t_jw_apontamento_caixas_corrugadas_resumo.getTotal_caixas();
                        caixas_pendentes = t_jw_apontamento_caixas_corrugadas_resumo.getCaixas_pendentes();
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

            <html:form action="com/RelatorioApontamentoCaixas_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_apontamento_caixas_corrugadas"/>
                  </td>
                </tr>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="b" styleClass="baseButton" property="back_action">
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

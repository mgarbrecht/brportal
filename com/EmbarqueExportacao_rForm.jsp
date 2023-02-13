<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Embarque Exportação
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(291)){
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
              java.util.Vector res_Jw_embarque_exportacao = (java.util.Vector)session.getAttribute("res_Jw_embarque_exportacao");
              %>

              <form  name="bl_report_Jw_embarque_exportacao" id="bl_report_Jw_embarque_exportacao" class="baseForm" method="post" >
                <%
                if (res_Jw_embarque_exportacao!=null && res_Jw_embarque_exportacao.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_embarque_exportacao"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Integer rEM_NRO =  null;
                    java.lang.Integer pED_NMRO =  null;
                    java.lang.String pED_INVOICE =  null;
                    int iTE_SEQN =  0;
                    java.lang.Integer lIN_CDGO =  null;
                    java.lang.Integer rEF_CDGO =  null;
                    java.lang.Integer cAB_CDGO =  null;
                    java.lang.Integer cOR_CDGO =  null;
                    java.lang.String nUMERACAO_INTERNA =  null;
                    java.lang.String nUMERACAO_EXTERNA =  null;
                    int pARES =  0;
                    java.lang.String lOJA_CLIENTE =  null;
                    java.lang.String cAIXA =  null;
                    int tOTAL_ROTULOS_PED =  0;
                    int tOTAL_ROTULOS =  0;
                    int sEQ_ROTULO =  0;
                    java.lang.Integer sEQ_ROTULO_FATURA =  null;
                    java.lang.Integer tOTAL_ROTULOS_FATURA =  null;
                    java.lang.String bAR =  null;
                    int nFS_NMRO =  0;
                    java.lang.String nFS_SERIE =  null;
                    java.lang.Integer rEQNF_NUMERO =  null;
                    int nFS_QTDVOL =  0;
                    java.lang.String fil_filial =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Remessa
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Pedido
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Invoice
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Seqn.
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

                      <td class="columnTdHeader" style="text-align:right;" >
                        Pares
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Loja Cliente
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Caixa
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Total Rótulos Ped
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Total Rótulos
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Seq. Rótulo
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Seq. Rótulo Fatura
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Total Rótulos Fatura
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Cod. Barra
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Nfs. Nmro
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Nfs. Série
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Req.Nf. Número
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Nfs. Qtd. Vol.
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Filial
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_embarque_exportacao = 0;
                    while (i_bl_report_Jw_embarque_exportacao<res_Jw_embarque_exportacao.size()) {
                      portalbr.dbobj.view.Jw_embarque_exportacao t_jw_embarque_exportacao = (portalbr.dbobj.view.Jw_embarque_exportacao)res_Jw_embarque_exportacao.elementAt(i_bl_report_Jw_embarque_exportacao);
                      rEM_NRO = t_jw_embarque_exportacao.getRem_nro();
                      pED_NMRO = t_jw_embarque_exportacao.getPed_nmro();
                      pED_INVOICE = t_jw_embarque_exportacao.getPed_invoice()==null?"":t_jw_embarque_exportacao.getPed_invoice();
                      iTE_SEQN = t_jw_embarque_exportacao.getIte_seqn();
                      lIN_CDGO = t_jw_embarque_exportacao.getLin_cdgo();
                      rEF_CDGO = t_jw_embarque_exportacao.getRef_cdgo();
                      cAB_CDGO = t_jw_embarque_exportacao.getCab_cdgo();
                      cOR_CDGO = t_jw_embarque_exportacao.getCor_cdgo();
                      nUMERACAO_INTERNA = t_jw_embarque_exportacao.getNumeracao_interna()==null?"":t_jw_embarque_exportacao.getNumeracao_interna();
                      nUMERACAO_EXTERNA = t_jw_embarque_exportacao.getNumeracao_externa()==null?"":t_jw_embarque_exportacao.getNumeracao_externa();
                      pARES = t_jw_embarque_exportacao.getPares();
                      lOJA_CLIENTE = t_jw_embarque_exportacao.getLoja_cliente()==null?"":t_jw_embarque_exportacao.getLoja_cliente();
                      cAIXA = t_jw_embarque_exportacao.getCaixa()==null?"":t_jw_embarque_exportacao.getCaixa();
                      tOTAL_ROTULOS_PED = t_jw_embarque_exportacao.getTotal_rotulos_ped();
                      tOTAL_ROTULOS = t_jw_embarque_exportacao.getTotal_rotulos();
                      sEQ_ROTULO = t_jw_embarque_exportacao.getSeq_rotulo();
                      sEQ_ROTULO_FATURA = t_jw_embarque_exportacao.getSeq_rotulo_fatura();
                      tOTAL_ROTULOS_FATURA = t_jw_embarque_exportacao.getTotal_rotulos_fatura();
                      bAR = t_jw_embarque_exportacao.getBar()==null?"":t_jw_embarque_exportacao.getBar();
                      nFS_NMRO = t_jw_embarque_exportacao.getNfs_nmro();
                      nFS_SERIE = t_jw_embarque_exportacao.getNfs_serie()==null?"":t_jw_embarque_exportacao.getNfs_serie();
                      rEQNF_NUMERO = t_jw_embarque_exportacao.getReqnf_numero();
                      nFS_QTDVOL = t_jw_embarque_exportacao.getNfs_qtdvol();
                      fil_filial = t_jw_embarque_exportacao.getFil_filial()==null?"":t_jw_embarque_exportacao.getFil_filial();
                      String style_bl_report_Jw_embarque_exportacao="";
                      if (!((i_bl_report_Jw_embarque_exportacao%2)!=0)) {
                        style_bl_report_Jw_embarque_exportacao="rowColor";
                      } else {
                        style_bl_report_Jw_embarque_exportacao="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_embarque_exportacao %>' id="TRbl_report_Jw_embarque_exportacao<%=i_bl_report_Jw_embarque_exportacao%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((rEM_NRO!=null)?rEM_NRO.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((pED_NMRO!=null)?pED_NMRO.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= pED_INVOICE %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= iTE_SEQN %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((lIN_CDGO!=null)?lIN_CDGO.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((rEF_CDGO!=null)?rEF_CDGO.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((cAB_CDGO!=null)?cAB_CDGO.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((cOR_CDGO!=null)?cOR_CDGO.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= pARES %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= lOJA_CLIENTE %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cAIXA %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= tOTAL_ROTULOS_PED %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= tOTAL_ROTULOS %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= sEQ_ROTULO %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((sEQ_ROTULO_FATURA!=null)?sEQ_ROTULO_FATURA.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((tOTAL_ROTULOS_FATURA!=null)?tOTAL_ROTULOS_FATURA.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= bAR %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= nFS_NMRO %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= nFS_SERIE %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((rEQNF_NUMERO!=null)?rEQNF_NUMERO.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= nFS_QTDVOL %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= fil_filial %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_embarque_exportacao++;
                      if (i_bl_report_Jw_embarque_exportacao<res_Jw_embarque_exportacao.size()) {
                        t_jw_embarque_exportacao = (portalbr.dbobj.view.Jw_embarque_exportacao)res_Jw_embarque_exportacao.elementAt(i_bl_report_Jw_embarque_exportacao);
                        rEM_NRO = t_jw_embarque_exportacao.getRem_nro();
                        pED_NMRO = t_jw_embarque_exportacao.getPed_nmro();
                        pED_INVOICE = t_jw_embarque_exportacao.getPed_invoice()==null?"":t_jw_embarque_exportacao.getPed_invoice();
                        iTE_SEQN = t_jw_embarque_exportacao.getIte_seqn();
                        lIN_CDGO = t_jw_embarque_exportacao.getLin_cdgo();
                        rEF_CDGO = t_jw_embarque_exportacao.getRef_cdgo();
                        cAB_CDGO = t_jw_embarque_exportacao.getCab_cdgo();
                        cOR_CDGO = t_jw_embarque_exportacao.getCor_cdgo();
                        nUMERACAO_INTERNA = t_jw_embarque_exportacao.getNumeracao_interna()==null?"":t_jw_embarque_exportacao.getNumeracao_interna();
                        nUMERACAO_EXTERNA = t_jw_embarque_exportacao.getNumeracao_externa()==null?"":t_jw_embarque_exportacao.getNumeracao_externa();
                        pARES = t_jw_embarque_exportacao.getPares();
                        lOJA_CLIENTE = t_jw_embarque_exportacao.getLoja_cliente()==null?"":t_jw_embarque_exportacao.getLoja_cliente();
                        cAIXA = t_jw_embarque_exportacao.getCaixa()==null?"":t_jw_embarque_exportacao.getCaixa();
                        tOTAL_ROTULOS_PED = t_jw_embarque_exportacao.getTotal_rotulos_ped();
                        tOTAL_ROTULOS = t_jw_embarque_exportacao.getTotal_rotulos();
                        sEQ_ROTULO = t_jw_embarque_exportacao.getSeq_rotulo();
                        sEQ_ROTULO_FATURA = t_jw_embarque_exportacao.getSeq_rotulo_fatura();
                        tOTAL_ROTULOS_FATURA = t_jw_embarque_exportacao.getTotal_rotulos_fatura();
                        bAR = t_jw_embarque_exportacao.getBar()==null?"":t_jw_embarque_exportacao.getBar();
                        nFS_NMRO = t_jw_embarque_exportacao.getNfs_nmro();
                        nFS_SERIE = t_jw_embarque_exportacao.getNfs_serie()==null?"":t_jw_embarque_exportacao.getNfs_serie();
                        rEQNF_NUMERO = t_jw_embarque_exportacao.getReqnf_numero();
                        nFS_QTDVOL = t_jw_embarque_exportacao.getNfs_qtdvol();
                        fil_filial = t_jw_embarque_exportacao.getFil_filial()==null?"":t_jw_embarque_exportacao.getFil_filial();
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

            <html:form action="com/EmbarqueExportacao_rForm.do" method="post" styleClass="baseForm">
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

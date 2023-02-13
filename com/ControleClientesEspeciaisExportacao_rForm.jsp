<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Followup
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(259)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            {
              java.util.Vector res_Jw_controle_clientes_especiais_exportacao = (java.util.Vector)session.getAttribute("res_Jw_controle_clientes_especiais_exportacao");
              java.util.Vector res_Jw_controle_clientes_especiais_exportacao_filiais = (java.util.Vector)session.getAttribute("res_Jw_controle_clientes_especiais_exportacao_filiais");
              %>

              <form  name="bl_report_Jw_controle_clientes_especiais_exportacao" id="bl_report_Jw_controle_clientes_especiais_exportacao" class="baseForm" method="post" >
                <%
                if (res_Jw_controle_clientes_especiais_exportacao!=null && res_Jw_controle_clientes_especiais_exportacao.size()>0) {
                  if ( ((String)request.getParameter("_ordered"))!=null && ((String)request.getParameter("_ordered")).length()>0 ) {
                    boolean reverse = false;
                    if ( ((String)request.getParameter("_reverse"))!=null && ((String)request.getParameter("_reverse")).equals("true") ){
                      reverse = true;
                    }
                    try {
                      res_Jw_controle_clientes_especiais_exportacao = com.egen.util.text.Sort.execute(res_Jw_controle_clientes_especiais_exportacao,((String)request.getParameter("_ordered")),reverse);
                      session.setAttribute("res_Jw_controle_clientes_especiais_exportacao", res_Jw_controle_clientes_especiais_exportacao);
                    } catch (Exception e) {}
                  }
                  %>

                  <table id="TRbl_report_Jw_controle_clientes_especiais_exportacao"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.sql.Timestamp data_entrega_fatura =  null;
                    java.lang.Integer numero_fatura_proforma =  null;
                    java.lang.Integer ano_fatura_proforma =  null;
                    java.lang.String empresa_fatura_proforma = null;
                    java.lang.Integer codigo_cliente = null;
                    java.lang.Integer estabelecimento_cliente = null;
                    java.lang.String razao_cliente = null;
                    java.lang.String codigo_regional = null;
                    java.lang.String nome_regional = null;
                    java.lang.String codigo_representante = null;
                    java.lang.String razao_representante = null;
                    java.lang.String codigo_transportadora = null;
                    java.lang.String razao_transportadora = null;
                    java.lang.String especie_fatura =  null;
                    java.lang.String descricao_especie_fatura = null;
                    java.lang.String status_fatura = null;
                    java.lang.String data_fatura = null;
                    java.lang.String data_prev_faturamento = null;
                    java.lang.String data_prev_embarque = null;
                    java.lang.String data_deposito = null;
                    java.lang.String data_embarque = null;
                    java.lang.String dias_deposito = null;
                    java.lang.String descricao_status_fatura =  null;
                    java.lang.String pais =  null;
                    java.lang.Integer pares =  null;
                    java.lang.Double valor =  null;
                    java.util.List<util.consultas.com.ControleClientesEspeciaisExportacao.FaturaFilialStatus> listaFaturaFilialStatus;
                    java.lang.String etiquetas =  null;
                    java.lang.String dt_entrega_etiqueta =  null;
                    java.lang.String dt_rec_etiqueta_filial =  null;
                    java.lang.String obs_fatura =  null;
                    java.lang.Object filiais =  null;
                    java.lang.String dt_inspecao=  null;
                    java.lang.String data_embarque_cargovision = null;
                    int totalPares = 0;
                    double totalValor = 0.0;
                    java.lang.String status = null;

                    int columnCount = 0;

                    if(session.getAttribute("cb_data_entrega_fatura")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_numero_fatura_proforma")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_especie_fatura")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_status_fatura")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_cliente")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_regional")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_representante")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_transportadora")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_pais")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_pares")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_valor")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_data_entrada_fatura")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_dt_prev_fat")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_dt_prev_emb")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_dt_entrada_deposito")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_data_embarque")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_dias_deposito")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_etiquetas")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_dt_entrega_etiqueta")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_dt_rec_etiqueta_fil")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_dt_inspecao")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_dt_emb_cargovision")!=null){
                      columnCount++;
                    }
                    if(session.getAttribute("cb_obs_fatura")!=null){
                      columnCount++;
                    }
                    %>

                    <tr class="reportTr" >
                      <td class="columnTdHeader" style="text-align:center;" colspan="<%= columnCount %>">
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" colspan="<%= res_Jw_controle_clientes_especiais_exportacao_filiais.size() %>" >
                        Filiais
                      </td>

                    </tr>
                    <tr class="reportTr">

                      <%
                      if(session.getAttribute("cb_data_entrega_fatura")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align:center;" >
                          Data Entrega Fatura
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","data_entrega_fatura")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","data_entrega_fatura")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_numero_fatura_proforma")!=null){
                        %>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Número Fatura
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","numero_fatura_proforma")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","numero_fatura_proforma")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_especie_fatura")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align: center;" >
                          Espécie Fatura
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","especie_fatura")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","especie_fatura")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_status_fatura")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align: center;" >
                          Status Fatura
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","status_fatura")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","status_fatura")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_cliente")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align:left;" >
                          Cliente
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","codigo_cliente")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","codigo_cliente")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_regional")!=null){
                        %>



                        <td class="columnTdHeader" style="text-align:left;" >
                          Regional
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","codigo_regional")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","codigo_regional")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_representante")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align:left;" >
                          Representante
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","codigo_representante")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","codigo_representante")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_transportadora")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align:left;" >
                          Transportadora
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","codigo_transportadora")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","codigo_transportadora")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_pais")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align:left;" >
                          País
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","pais")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","pais")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_pares")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align:right;" >
                          Pares
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","pares")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","pares")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_valor")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align:right;" >
                          Valor
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","valor")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","valor")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_data_entrada_fatura")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align:left;" >
                          Data Entrada
                          <br>
                          Fatura
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","data_fatura")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","data_fatura")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_dt_prev_fat")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align:left;" >
                          Data Previsão
                          <br>
                          Faturamento
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","data_prev_faturamento")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","data_prev_faturamento")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_dt_prev_emb")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align:left;" >
                          Data Previsão
                          <br>
                          Embarque
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","data_prev_embarque")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","data_prev_embarque")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_dt_entrada_deposito")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align:left;" >
                          Data Entrada
                          <br>
                          Depósito
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","data_deposito")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","data_deposito")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_data_embarque")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align:left;" >
                          Data Embarque
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","data_embarque")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","data_embarque")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_dias_deposito")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align:left;" >
                          Dias Depósito
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","dias_deposito")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","dias_deposito")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_etiquetas")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align:left;" >
                          Etiquetas
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","etiquetas")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","etiquetas")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_dt_entrega_etiqueta")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align:left;" >
                          Data Entrega
                          <br>
                          Etiqueta
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","dt_entrega_etiqueta")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","dt_entrega_etiqueta")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_dt_rec_etiqueta_fil")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align:left;" >
                          Dt. Rec. Etiqueta Filial
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","dt_rec_etiqueta_filial")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","dt_rec_etiqueta_filial")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_dt_inspecao")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align:center;" >
                          Data
                          <br>
                          Inspeção
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","dt_inspecao")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","dt_inspecao")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_dt_emb_cargovision")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align:center;" >
                          Data Embarque
                          <br>

                          Cargovision
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","data_embarque_cargovision")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","data_embarque_cargovision")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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
                      <%
                      if(session.getAttribute("cb_obs_fatura")!=null){
                        %>


                        <td class="columnTdHeader" style="text-align:left;" >
                          Obs. Fatura
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%
                            if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","obs_fatura")%>' class="reportOrder">
                                <bean:message key="report.orderedasc"/>
                              </a>
                              <%
                            } else {
                              %>
                              <a href='ControleClientesEspeciaisExportacao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","obs_fatura")%>' class="reportOrder">
                                <bean:message key="report.ordereddesc"/>
                              </a>
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



                      <%
                      int i_bl_report_Jw_controle_clientes_especiais_exportacao_filiais = 0;
                      while (i_bl_report_Jw_controle_clientes_especiais_exportacao_filiais <res_Jw_controle_clientes_especiais_exportacao_filiais.size()) {
                        portalbr.dbobj.view.Jw_controle_clientes_especiais_exportacao_filiais t_jw_controle_clientes_especiais_exportacao_filiais = (portalbr.dbobj.view.Jw_controle_clientes_especiais_exportacao_filiais)res_Jw_controle_clientes_especiais_exportacao_filiais.elementAt(i_bl_report_Jw_controle_clientes_especiais_exportacao_filiais);
                        %>
                        <td class="columnTdHeader" style="text-align:center; width: 30px" >
                          <%= t_jw_controle_clientes_especiais_exportacao_filiais.getFilial() %>
                        </td>
                        <%
                        i_bl_report_Jw_controle_clientes_especiais_exportacao_filiais++;
                      }
                      %>
                    </tr>

                    <%
                    int i_bl_report_Jw_controle_clientes_especiais_exportacao = 0;
                    while (i_bl_report_Jw_controle_clientes_especiais_exportacao<res_Jw_controle_clientes_especiais_exportacao.size()) {
                      portalbr.dbobj.view.Jw_controle_clientes_especiais_exportacao t_jw_controle_clientes_especiais_exportacao = (portalbr.dbobj.view.Jw_controle_clientes_especiais_exportacao)res_Jw_controle_clientes_especiais_exportacao.elementAt(i_bl_report_Jw_controle_clientes_especiais_exportacao);
                      data_entrega_fatura = (java.sql.Timestamp)t_jw_controle_clientes_especiais_exportacao.getData_entrega_fatura();
                      numero_fatura_proforma = t_jw_controle_clientes_especiais_exportacao.getNumero_fatura_proforma();
                      ano_fatura_proforma = t_jw_controle_clientes_especiais_exportacao.getAno_fatura_proforma();
                      codigo_cliente = t_jw_controle_clientes_especiais_exportacao.getCodigo_cliente();
                      codigo_regional = t_jw_controle_clientes_especiais_exportacao.getCodigo_regional();
                      codigo_representante = t_jw_controle_clientes_especiais_exportacao.getCodigo_representante();
                      razao_representante = t_jw_controle_clientes_especiais_exportacao.getRazao_representante()==null?"":t_jw_controle_clientes_especiais_exportacao.getRazao_representante();
                      codigo_transportadora = t_jw_controle_clientes_especiais_exportacao.getCodigo_transportadora();
                      razao_transportadora = t_jw_controle_clientes_especiais_exportacao.getRazao_transportadora()==null?"":t_jw_controle_clientes_especiais_exportacao.getRazao_transportadora();
                      estabelecimento_cliente = t_jw_controle_clientes_especiais_exportacao.getEstabelecimento_cliente();
                      razao_cliente = t_jw_controle_clientes_especiais_exportacao.getRazao_cliente()==null?"":t_jw_controle_clientes_especiais_exportacao.getRazao_cliente();
                      nome_regional = t_jw_controle_clientes_especiais_exportacao.getNome_regional()==null?"":t_jw_controle_clientes_especiais_exportacao.getNome_regional();
                      especie_fatura = t_jw_controle_clientes_especiais_exportacao.getEspecie_fatura()==null?"":t_jw_controle_clientes_especiais_exportacao.getEspecie_fatura();
                      descricao_especie_fatura = t_jw_controle_clientes_especiais_exportacao.getDescricao_especie_fatura()==null?"":t_jw_controle_clientes_especiais_exportacao.getDescricao_especie_fatura();
                      status_fatura = t_jw_controle_clientes_especiais_exportacao.getStatus_fatura()==null?"":t_jw_controle_clientes_especiais_exportacao.getStatus_fatura();
                      descricao_status_fatura = t_jw_controle_clientes_especiais_exportacao.getDescricao_status_fatura()==null?"":t_jw_controle_clientes_especiais_exportacao.getDescricao_status_fatura();
                      pais = t_jw_controle_clientes_especiais_exportacao.getPais()==null?"":t_jw_controle_clientes_especiais_exportacao.getPais();
                      pares = t_jw_controle_clientes_especiais_exportacao.getPares();
                      valor = t_jw_controle_clientes_especiais_exportacao.getValor();
                      data_fatura = t_jw_controle_clientes_especiais_exportacao.getData_fatura()==null?"":t_jw_controle_clientes_especiais_exportacao.getData_fatura();
                      data_prev_faturamento = t_jw_controle_clientes_especiais_exportacao.getData_prev_faturamento()==null?"":t_jw_controle_clientes_especiais_exportacao.getData_prev_faturamento();
                      data_prev_embarque = t_jw_controle_clientes_especiais_exportacao.getData_prev_embarque()==null?"":t_jw_controle_clientes_especiais_exportacao.getData_prev_embarque();
                      data_deposito = t_jw_controle_clientes_especiais_exportacao.getData_deposito()==null?"":t_jw_controle_clientes_especiais_exportacao.getData_deposito();
                      data_embarque = t_jw_controle_clientes_especiais_exportacao.getData_embarque()==null?"":t_jw_controle_clientes_especiais_exportacao.getData_embarque();
                      dias_deposito = t_jw_controle_clientes_especiais_exportacao.getDias_deposito()==null?"":t_jw_controle_clientes_especiais_exportacao.getDias_deposito();
                      etiquetas = t_jw_controle_clientes_especiais_exportacao.getEtiquetas()==null?"":t_jw_controle_clientes_especiais_exportacao.getEtiquetas();
                      listaFaturaFilialStatus = (java.util.List<util.consultas.com.ControleClientesEspeciaisExportacao.FaturaFilialStatus>)t_jw_controle_clientes_especiais_exportacao.getFiliais();
                      dt_rec_etiqueta_filial = t_jw_controle_clientes_especiais_exportacao.getDt_rec_etiqueta_filial()==null?"":t_jw_controle_clientes_especiais_exportacao.getDt_rec_etiqueta_filial();
                      obs_fatura = t_jw_controle_clientes_especiais_exportacao.getObs_fatura()==null?"":t_jw_controle_clientes_especiais_exportacao.getObs_fatura();
                      dt_entrega_etiqueta = t_jw_controle_clientes_especiais_exportacao.getDt_entrega_etiqueta()==null?"":t_jw_controle_clientes_especiais_exportacao.getDt_entrega_etiqueta();
                      dt_inspecao = t_jw_controle_clientes_especiais_exportacao.getDt_inspecao()==null?"":t_jw_controle_clientes_especiais_exportacao.getDt_inspecao();
                      data_embarque_cargovision = t_jw_controle_clientes_especiais_exportacao.getData_embarque_cargovision()==null?"":t_jw_controle_clientes_especiais_exportacao.getData_embarque_cargovision();
                      String style_bl_report_Jw_controle_clientes_especiais_exportacao="";
                      if (!((i_bl_report_Jw_controle_clientes_especiais_exportacao%2)!=0)) {
                        style_bl_report_Jw_controle_clientes_especiais_exportacao="rowColor";
                      } else {
                        style_bl_report_Jw_controle_clientes_especiais_exportacao="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_controle_clientes_especiais_exportacao %>' id="TRbl_report_Jw_controle_clientes_especiais_exportacao<%=i_bl_report_Jw_controle_clientes_especiais_exportacao%>" >

                        <%
                        if(session.getAttribute("cb_data_entrega_fatura")!=null){
                          %>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= com.egen.util.text.FormatDate.format(data_entrega_fatura, "dd/MM/yyyy") %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_numero_fatura_proforma")!=null){
                          %>

                          <td class="reportColumn" style="text-align: center;" >
                            <%= ((numero_fatura_proforma!=null)?numero_fatura_proforma.toString():"") %>
                            <%= ((ano_fatura_proforma!=null)?("/" + ano_fatura_proforma.toString()):"") %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_especie_fatura")!=null){
                          %>

                          <td class="reportColumn" style="text-align: center;" >
                            <%= ((especie_fatura!=null)?especie_fatura.toString():"") %>
                            <%= ((descricao_especie_fatura!=null)?(" - " + descricao_especie_fatura.toString()):"") %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_status_fatura")!=null){
                          %>

                          <td class="reportColumn" style="text-align: center;" >
                            <%= ((status_fatura!=null)?status_fatura.toString():"") %>
                            <%= ((descricao_status_fatura!=null)?(" - " + descricao_status_fatura.toString()):"") %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_cliente")!=null){
                          %>

                          <td class="reportColumn" style="text-align: left;" >
                            <%= ((codigo_cliente!=null)?codigo_cliente.toString():"") %>
                            -
                            <%= estabelecimento_cliente %>
                            -
                            <%= razao_cliente %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_regional")!=null){
                          %>

                          <td class="reportColumn" style="text-align: left;" >
                            <%= ((codigo_regional!=null)?codigo_regional.toString():"") %>
                            -
                            <%= nome_regional %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_representante")!=null){
                          %>

                          <td class="reportColumn" style="text-align: left;" >
                            <%= ((codigo_representante!=null)?codigo_representante.toString():"") %>
                            -
                            <%= razao_representante %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_transportadora")!=null){
                          %>

                          <td class="reportColumn" style="text-align: left;" >
                            <%= ((codigo_transportadora!=null)?codigo_transportadora.toString():"") %>
                            -
                            <%= razao_transportadora %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_pais")!=null){
                          %>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= pais %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_pares")!=null){
                          %>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(pares, "##,##0") %>
                            <%
                            totalPares += pares;
                            %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_valor")!=null){
                          %>

                          <td class="reportColumn" style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(valor, "##,##0.00") %>
                            <%
                            totalValor += valor;
                            %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_data_entrada_fatura")!=null){
                          %>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= data_fatura %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_dt_prev_fat")!=null){
                          %>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= data_prev_faturamento %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_dt_prev_emb")!=null){
                          %>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= data_prev_embarque %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_dt_entrada_deposito")!=null){
                          %>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= data_deposito %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_data_embarque")!=null){
                          %>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= data_embarque %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_dias_deposito")!=null){
                          %>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= dias_deposito %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_etiquetas")!=null){
                          %>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= etiquetas %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_dt_entrega_etiqueta")!=null){
                          %>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= dt_entrega_etiqueta %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_dt_rec_etiqueta_fil")!=null){
                          %>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= dt_rec_etiqueta_filial %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_dt_inspecao")!=null){
                          %>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= dt_inspecao %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_dt_emb_cargovision")!=null){
                          %>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= data_embarque_cargovision %>
                          </td>

                          <%
                        }
                        %>
                        <%
                        if(session.getAttribute("cb_obs_fatura")!=null){
                          %>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= obs_fatura %>
                          </td>

                          <%
                        }
                        %>

                        <%
                        i_bl_report_Jw_controle_clientes_especiais_exportacao_filiais = 0;
                        while (i_bl_report_Jw_controle_clientes_especiais_exportacao_filiais <res_Jw_controle_clientes_especiais_exportacao_filiais.size()) {
                          portalbr.dbobj.view.Jw_controle_clientes_especiais_exportacao_filiais t_jw_controle_clientes_especiais_exportacao_filiais = (portalbr.dbobj.view.Jw_controle_clientes_especiais_exportacao_filiais)res_Jw_controle_clientes_especiais_exportacao_filiais.elementAt(i_bl_report_Jw_controle_clientes_especiais_exportacao_filiais);
                          boolean sinaliza = false;
                          for(util.consultas.com.ControleClientesEspeciaisExportacao.FaturaFilialStatus f : listaFaturaFilialStatus){
                            if(f.getFilial().equalsIgnoreCase(t_jw_controle_clientes_especiais_exportacao_filiais.getFilial())){
                              sinaliza = true;
                              status = f.getStatus();
                            }
                          }
                          %>
                          <td class="reportColumn" style="text-align:center;" >

                            <%
                            if(sinaliza){
                              %>
                              <%
                              if(status.equalsIgnoreCase("__")){
                                %>
                                <font color="gray">
                                  __
                                </font>
                                <%
                              } else {
                                %>
                                <%= status %>
                                <%
                              }
                              %>
                              <%
                            } else {
                              %>
                              <font color="gray">
                              </font>
                              <%
                            }
                            %>
                          </td>
                          <%
                          i_bl_report_Jw_controle_clientes_especiais_exportacao_filiais++;
                        }
                        %>

                      </tr>

                      <%
                      i_bl_report_Jw_controle_clientes_especiais_exportacao++;
                      if (i_bl_report_Jw_controle_clientes_especiais_exportacao<res_Jw_controle_clientes_especiais_exportacao.size()) {
                        t_jw_controle_clientes_especiais_exportacao = (portalbr.dbobj.view.Jw_controle_clientes_especiais_exportacao)res_Jw_controle_clientes_especiais_exportacao.elementAt(i_bl_report_Jw_controle_clientes_especiais_exportacao);
                        data_entrega_fatura = (java.sql.Timestamp)t_jw_controle_clientes_especiais_exportacao.getData_entrega_fatura();
                        numero_fatura_proforma = t_jw_controle_clientes_especiais_exportacao.getNumero_fatura_proforma();
                        ano_fatura_proforma = t_jw_controle_clientes_especiais_exportacao.getAno_fatura_proforma();
                        codigo_cliente = t_jw_controle_clientes_especiais_exportacao.getCodigo_cliente();
                        codigo_regional = t_jw_controle_clientes_especiais_exportacao.getCodigo_regional();
                        codigo_representante = t_jw_controle_clientes_especiais_exportacao.getCodigo_representante();
                        razao_representante = t_jw_controle_clientes_especiais_exportacao.getRazao_representante()==null?"":t_jw_controle_clientes_especiais_exportacao.getRazao_representante();
                        codigo_transportadora = t_jw_controle_clientes_especiais_exportacao.getCodigo_transportadora();
                        razao_transportadora = t_jw_controle_clientes_especiais_exportacao.getRazao_transportadora()==null?"":t_jw_controle_clientes_especiais_exportacao.getRazao_transportadora();
                        estabelecimento_cliente = t_jw_controle_clientes_especiais_exportacao.getEstabelecimento_cliente();
                        razao_cliente = t_jw_controle_clientes_especiais_exportacao.getRazao_cliente()==null?"":t_jw_controle_clientes_especiais_exportacao.getRazao_cliente();
                        nome_regional = t_jw_controle_clientes_especiais_exportacao.getNome_regional()==null?"":t_jw_controle_clientes_especiais_exportacao.getNome_regional();
                        especie_fatura = t_jw_controle_clientes_especiais_exportacao.getEspecie_fatura()==null?"":t_jw_controle_clientes_especiais_exportacao.getEspecie_fatura();
                        descricao_especie_fatura = t_jw_controle_clientes_especiais_exportacao.getDescricao_especie_fatura()==null?"":t_jw_controle_clientes_especiais_exportacao.getDescricao_especie_fatura();
                        status_fatura = t_jw_controle_clientes_especiais_exportacao.getStatus_fatura()==null?"":t_jw_controle_clientes_especiais_exportacao.getStatus_fatura();
                        descricao_status_fatura = t_jw_controle_clientes_especiais_exportacao.getDescricao_status_fatura()==null?"":t_jw_controle_clientes_especiais_exportacao.getDescricao_status_fatura();
                        pais = t_jw_controle_clientes_especiais_exportacao.getPais()==null?"":t_jw_controle_clientes_especiais_exportacao.getPais();
                        pares = t_jw_controle_clientes_especiais_exportacao.getPares();
                        valor = t_jw_controle_clientes_especiais_exportacao.getValor();
                        data_fatura = t_jw_controle_clientes_especiais_exportacao.getData_fatura()==null?"":t_jw_controle_clientes_especiais_exportacao.getData_fatura();
                        data_prev_faturamento = t_jw_controle_clientes_especiais_exportacao.getData_prev_faturamento()==null?"":t_jw_controle_clientes_especiais_exportacao.getData_prev_faturamento();
                        data_prev_embarque = t_jw_controle_clientes_especiais_exportacao.getData_prev_embarque()==null?"":t_jw_controle_clientes_especiais_exportacao.getData_prev_embarque();
                        data_deposito = t_jw_controle_clientes_especiais_exportacao.getData_deposito()==null?"":t_jw_controle_clientes_especiais_exportacao.getData_deposito();
                        data_embarque = t_jw_controle_clientes_especiais_exportacao.getData_embarque()==null?"":t_jw_controle_clientes_especiais_exportacao.getData_embarque();
                        dias_deposito = t_jw_controle_clientes_especiais_exportacao.getDias_deposito()==null?"":t_jw_controle_clientes_especiais_exportacao.getDias_deposito();
                        listaFaturaFilialStatus = (java.util.List<util.consultas.com.ControleClientesEspeciaisExportacao.FaturaFilialStatus>)t_jw_controle_clientes_especiais_exportacao.getFiliais();
                        etiquetas = t_jw_controle_clientes_especiais_exportacao.getEtiquetas()==null?"":t_jw_controle_clientes_especiais_exportacao.getEtiquetas();
                        dt_rec_etiqueta_filial = t_jw_controle_clientes_especiais_exportacao.getDt_rec_etiqueta_filial()==null?"":t_jw_controle_clientes_especiais_exportacao.getDt_rec_etiqueta_filial();
                        obs_fatura = t_jw_controle_clientes_especiais_exportacao.getObs_fatura()==null?"":t_jw_controle_clientes_especiais_exportacao.getObs_fatura();
                        dt_entrega_etiqueta = t_jw_controle_clientes_especiais_exportacao.getDt_entrega_etiqueta()==null?"":t_jw_controle_clientes_especiais_exportacao.getDt_entrega_etiqueta();
                        dt_inspecao = t_jw_controle_clientes_especiais_exportacao.getDt_inspecao()==null?"":t_jw_controle_clientes_especiais_exportacao.getDt_inspecao();
                        data_embarque_cargovision = t_jw_controle_clientes_especiais_exportacao.getData_embarque_cargovision()==null?"":t_jw_controle_clientes_especiais_exportacao.getData_embarque_cargovision();
                      } else {
                      }
                    }
                    %>

                    <tr class="totalColumn">
                      <%
                      if(session.getAttribute("cb_data_entrega_fatura")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_numero_fatura_proforma")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_especie_fatura")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_status_fatura")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_cliente")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_regional")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_representante")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_transportadora")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_pais")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>

                      <%
                      if(session.getAttribute("cb_pares")!=null){
                        %>
                        <td class="totalTdColumn"  style="text-align:right;" >
                          <b>
                            <%= com.egen.util.text.FormatNumber.format(totalPares, "##,##0") %>
                          </b>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_valor")!=null){
                        %>
                        <td class="totalTdColumn"  style="text-align:right;" >
                          <b>
                            <%= com.egen.util.text.FormatNumber.format(totalValor, "##,##0.00") %>
                          </b>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_data_entrada_fatura")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_dt_prev_fat")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_dt_prev_emb")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_dt_entrada_deposito")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_data_embarque")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_dias_deposito")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_etiquetas")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_dt_entrega_etiqueta")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_dt_rec_etiqueta_fil")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_dt_inspecao")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_dt_emb_cargovision")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("cb_obs_fatura")!=null){
                        %>
                        <td>
                        </td>
                        <%
                      }
                      %>

                      <%
                      i_bl_report_Jw_controle_clientes_especiais_exportacao_filiais = 0;
                      while (i_bl_report_Jw_controle_clientes_especiais_exportacao_filiais <res_Jw_controle_clientes_especiais_exportacao_filiais.size()) {
                        %>
                        <td>
                        </td>
                        <%
                        i_bl_report_Jw_controle_clientes_especiais_exportacao_filiais++;
                      }
                      %>
                    </tr>


                    <tr class="reportTr1" >
                      <td class="columnTdHeader1" style="text-align:center;" colspan="<%= columnCount %>">
                      </td>

                      <td class="columnTdHeader1" style="text-align: left;" colspan="<%= res_Jw_controle_clientes_especiais_exportacao_filiais.size() %>" >
                        <table>
                          <tr>
                            <td colspan="2">
                              <b>
                                Legenda:
                              </b>
                            </td>
                          </tr>
                          <tr>
                            <td>
                              B: 
                            </td>
                            <td>
                              Bloqueado
                            </td>
                          </tr>
                          <tr>
                            <td>
                              A: 
                            </td>
                            <td>
                              Liberado para Produzir
                            </td>
                          </tr>
                          <tr>
                            <td>
                              P: 
                            </td>
                            <td>
                              Em Produção
                            </td>
                          </tr>
                          <tr>
                            <td>
                              E: 
                            </td>
                            <td>
                              Produzido
                            </td>
                          </tr>
                          <tr>
                            <td>
                              L: 
                            </td>
                            <td>
                              Liberado para Faturar
                            </td>
                          </tr>
                          <tr>
                            <td>
                              F: 
                            </td>
                            <td>
                              Faturado
                            </td>
                          </tr>
                          <tr>
                            <td>
                              T: 
                            </td>
                            <td>
                              Transferência
                            </td>
                          </tr>
                        </table>
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
            <html:form action="com/ControleClientesEspeciaisExportacao_rForm.do" method="post" styleClass="baseForm">
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

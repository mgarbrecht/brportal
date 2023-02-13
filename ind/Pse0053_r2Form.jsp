<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta de Talões a Enviar/Receber por Fornecedor
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(151)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/Pse0053_r2Form.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="tipo" styleId="tipo" styleClass="disabled" tabindex="-1" readonly="true" value="<%= (String)session.getAttribute("pse0053_r_tipo") %>" size="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Filial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="filial" styleId="filial" styleClass="disabled" tabindex="-1" readonly="true" value="<%= (String)session.getAttribute("pse0053_r_filial") %>" size="60"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Período de
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_inicial" styleId="dt_inicial" styleClass="disabled" tabindex="-1" readonly="true" value="<%= (String)session.getAttribute("pse0053_dt_inicial") %>" size="11"/>
                    <span class="spamFormLabel">
                      a
                    </span>
                    <html:text property="dt_final" styleId="dt_final" styleClass="disabled" tabindex="-1" readonly="true" value="<%= (String)session.getAttribute("pse0053_dt_final") %>" size="11"/>
                  </td>
                </tr>

                <%
                if((String)request.getAttribute("abre_automaticamente")=="N"){
                  %>
                  <table style=width:100%;margin-top:10;>
                    <tr>
                      <td class=columHeader style="text-align:center;">
                        <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                          <bean:message key="report.downloadxls"/>
                        </a>
                      </td>
                    </tr>
                  </table>
                  <%
                }
                %>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <%
                    boolean mostraBotao = true;
                    java.util.Vector vquantidade = null;
                    if(session.getAttribute("res_Jw_pse0053_forn")!=null){
                      vquantidade = (java.util.Vector)session.getAttribute("res_Jw_pse0053_forn");
                    }
                    String tipo = (String)session.getAttribute("pse0053_tipo");
                    if(tipo.equalsIgnoreCase("E")){
                      if(vquantidade != null && vquantidade.size()>1){
                        mostraBotao = false;
                      }
                    }
                    if(mostraBotao){
                      %>

                      <html:submit value="Gerar Planilha" styleClass="baseButton" property="blank_action">
                      </html:submit>

                      <%
                    }
                    %>
                  </td>
                </tr>
              </table>

            </html:form>
            <%
            brportal.ind.Pse0053 p = new brportal.ind.Pse0053();
            int contador2 = 0;
            {
              java.util.Vector res_Jw_pse0053_total_fechado = (java.util.Vector)session.getAttribute("res_Jw_pse0053_total_fechado");
              %>
              <form  name="bl_report_Jw_pse0053_total_fechado" id="bl_report_Jw_pse0053_total_fechado" class="baseForm" method="post" >

                <%
                if (res_Jw_pse0053_total_fechado!=null && res_Jw_pse0053_total_fechado.size()>0) {
                  %>
                  <table id="TRbl_report_Jw_pse0053_total_fechado"  class="reportTable"   style="width:50%; "  border="1" >

                    <%
                    String tipo = (String)session.getAttribute("pse0053_tipo");
                    java.lang.Double totalPares = 0.0;
                    java.lang.Double totalValor = 0.0;
                    java.lang.Integer pro_numero =  null;
                    java.lang.Integer pro_numero_sub_processo =  null;
                    java.lang.String pro_nome_sub_processo =  null;
                    java.lang.String pro_nome =  null;
                    java.lang.Double pares =  null;
                    java.lang.Double preco =  null;
                    java.lang.Double total =  null;
                    java.lang.String filial = null;
                    java.lang.Double valor_total_nota = 0.0;
                    filial = (String)session.getAttribute("pse0053_filial");
                    String _b0_control = "__";
                    double sum_pares_1 = 0.0;
                    int i_bl_report_Jw_pse0053_total_fechado = 0;
                    while (i_bl_report_Jw_pse0053_total_fechado<res_Jw_pse0053_total_fechado.size()) {
                      portalbr.dbobj.view.Jw_pse0053_total_fechado t_jw_pse0053_total_fechado = (portalbr.dbobj.view.Jw_pse0053_total_fechado)res_Jw_pse0053_total_fechado.elementAt(i_bl_report_Jw_pse0053_total_fechado);
                      pro_numero = t_jw_pse0053_total_fechado.getPro_numero();
                      pro_nome = t_jw_pse0053_total_fechado.getPro_nome();
                      pares = t_jw_pse0053_total_fechado.getPares()!=null?t_jw_pse0053_total_fechado.getPares():0.0;
                      preco = t_jw_pse0053_total_fechado.getPreco()!=null?t_jw_pse0053_total_fechado.getPreco():0.0;
                      total = t_jw_pse0053_total_fechado.getTotal()!=null?t_jw_pse0053_total_fechado.getTotal():0.0;
                      sum_pares_1 += ((pares!=null)?pares.intValue():0.0);
                      String _b0_value = com.egen.util.text.FormatNumber.format(pro_numero);
                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                        %>

                        <tr class="reportHeader2">
                          <td style="text-align: center;" colspan="4" >
                            <big>
                              Resumo geral da mão de obra
                            </big>
                          </td>
                        </tr>


                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align: left;" colspan="4" >
                            <table width="100%">
                              <tr>
                                <td class="columnTdHeader" style="text-align: left; font-weight: bold" >
                                  Processo:
                                  <%
                                  pro_numero_sub_processo = pro_numero;
                                  pro_nome_sub_processo = pro_nome;
                                  %>
                                  <%= ((pro_numero!=null)?pro_numero.toString():"") %>
                                  -
                                  <%= ((pro_nome!=null)?pro_nome.toString():"") %>
                                </td>
                                <td style="text-align: right">
                                  <input type="button" value="Ver Remessa/Talões" onclick="wopen('../ind/Pse0053_mGrid.do?select_action=&pro_numero=<%= pro_numero %>&fil_filial=<%= filial %>','_blank',800,500)" style="background-color: #C40000;color: white;font-family:verdana;font-size:11px;border-color: black;font-weight: bold;" />
                                </td>
                              </tr>
                            </table>
                          </td>

                        </tr>
                        <%
                        %>
                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:right;" colspan="2" >
                            Pares
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Preço MO.
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Total
                          </td>
                        </tr>
                        <%
                      }
                      String style_bl_report_Jw_pse0053_total_fechado="";
                      if (!((i_bl_report_Jw_pse0053_total_fechado%2)!=0)) {
                        style_bl_report_Jw_pse0053_total_fechado="rowColor";
                      } else {
                        style_bl_report_Jw_pse0053_total_fechado="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_pse0053_total_fechado %>' id="TRbl_report_Jw_pse0053_total_fechado<%=i_bl_report_Jw_pse0053_total_fechado%>" >
                        <td class="reportColumn" style="text-align:right;" colspan="2" >
                          <%= com.egen.util.text.FormatNumber.format(pares, "##,##0") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(preco, "##,##0.0000") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(total, "##,##0.0000") %>
                          <%
                          //                 valor_total_nota += total;
                          %>
                        </td>

                      </tr>

                      <%
                      _b0_control = _b0_value;
                      i_bl_report_Jw_pse0053_total_fechado++;
                      if (i_bl_report_Jw_pse0053_total_fechado<res_Jw_pse0053_total_fechado.size()) {
                        t_jw_pse0053_total_fechado = (portalbr.dbobj.view.Jw_pse0053_total_fechado)res_Jw_pse0053_total_fechado.elementAt(i_bl_report_Jw_pse0053_total_fechado);
                        pro_numero = t_jw_pse0053_total_fechado.getPro_numero();
                        pro_nome = t_jw_pse0053_total_fechado.getPro_nome();
                        pares = t_jw_pse0053_total_fechado.getPares();
                        preco = t_jw_pse0053_total_fechado.getPreco();
                        total = t_jw_pse0053_total_fechado.getTotal();
                        _b0_value = com.egen.util.text.FormatNumber.format(pro_numero);
                        contador2 ++;
                      } else {
                        _b0_control = "__";
                      }
                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                        %>


                        <%
                        if(tipo.equalsIgnoreCase("R")){
                          %>

                          <tr class="reportHeader2">
                            <td style="text-align: center;" colspan="4" >
                              Valor do retorno simbólico
                            </td>
                          </tr>


                          <tr class="reportTr">

                            <td class="columnTdHeader" style="text-align: left;" >
                              Processo
                            </td>

                            <td class="columnTdHeader" style="text-align: right;" >
                              Quantidade
                            </td>

                            <td class="columnTdHeader" style="text-align: right;" >
                              Valor Processo
                            </td>

                            <td class="columnTdHeader" style="text-align: right;" >
                              Total
                            </td>
                          </tr>

                          <tr class="totalColumn">

                            <td class="totalTdColumn"  style="text-align:left;" >
                              <%= pro_numero_sub_processo %>
                              -
                              <%= pro_nome_sub_processo %>
                            </td>


                            <td class="totalTdColumn"  style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(sum_pares_1 , "##,##0.0000") %>
                              <%
                              totalPares += sum_pares_1;
                              %>
                            </td>
                            <td class="totalTdColumn"  style="text-align:right;" >
                               
                              <%= com.egen.util.text.FormatNumber.format(p.getProcesso_fab_custo(pro_numero_sub_processo +"", filial), "##,##0.0000") %>
                            </td>
                            <td class="totalTdColumn"  style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format((sum_pares_1 * p.getProcesso_fab_custo(pro_numero_sub_processo +"",filial)), "##,##0.0000") %>
                              <%
                              valor_total_nota += sum_pares_1 * p.getProcesso_fab_custo(pro_numero_sub_processo +"",filial);
                              totalValor += sum_pares_1 * p.getProcesso_fab_custo(pro_numero_sub_processo +"",filial);
                              %>
                            </td>
                          </tr>

                          <%
                        }
                        %>



                        <%
                        java.util.Vector res_Jw_processo_fab_sub_processo = null;
                        com.egen.util.jdbc.JdbcUtil j = null;
                        try {
                          j = new com.egen.util.jdbc.JdbcUtil();
                          portalbr.dbobj.view.Jw_processo_fab_sub_processo t_jw_processo_fab_sub_processo = new portalbr.dbobj.view.Jw_processo_fab_sub_processo();
                          String[][] select = {{"pro_numero",null},{"pro_numero_sub_processo",null},{"pro_nome",null},};
                          Object[][] where = {{"pro_numero","=",pro_numero_sub_processo}};
                          res_Jw_processo_fab_sub_processo = j.select(t_jw_processo_fab_sub_processo,select,where,null,null,null);
                          session.setAttribute("res_Jw_processo_fab_sub_processo", res_Jw_processo_fab_sub_processo );
                        } catch (Exception e){
                        } finally {
                        if(j!=null){j.close();}
                      }


                      int i_sub_processo = 0;
                      while (i_sub_processo <res_Jw_processo_fab_sub_processo.size()) {
                        portalbr.dbobj.view.Jw_processo_fab_sub_processo t_jw_sub_processo = (portalbr.dbobj.view.Jw_processo_fab_sub_processo)res_Jw_processo_fab_sub_processo.elementAt(i_sub_processo);
                        i_sub_processo ++;
                        %>


                        <%
                        if(tipo.equalsIgnoreCase("R")){
                          %>

                          <tr class="totalColumn">

                            <td class="totalTdColumn"  style="text-align:left;" >
                              <%= t_jw_sub_processo.getPro_numero_sub_processo() %>
                              -
                              <%= t_jw_sub_processo.getPro_nome() %>
                            </td>


                            <td class="totalTdColumn"  style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(sum_pares_1 , "##,##0.0000") %>
                              <%
                              totalPares += sum_pares_1;
                              %>
                            </td>
                            <td class="totalTdColumn"  style="text-align:right;" >
                               
                              <%= com.egen.util.text.FormatNumber.format(p.getProcesso_fab_custo(t_jw_sub_processo.getPro_numero_sub_processo()+"", filial), "##,##0.0000") %>
                            </td>
                            <td class="totalTdColumn"  style="text-align:right;" >
                              <%
                              totalValor += sum_pares_1 * p.getProcesso_fab_custo(t_jw_sub_processo.getPro_numero_sub_processo()+"",filial);
                              %>
                              <%= com.egen.util.text.FormatNumber.format((sum_pares_1 * p.getProcesso_fab_custo(t_jw_sub_processo.getPro_numero_sub_processo()+"",filial)), "##,##0.0000") %>
                              <%
                              valor_total_nota += (sum_pares_1 * p.getProcesso_fab_custo(t_jw_sub_processo.getPro_numero_sub_processo()+"",filial));
                              %>
                            </td>
                          </tr>

                          <%
                        }
                        %>

                        <%
                      }


                      java.util.Vector res_Jw_pse0053_total_fechado_itens = null;
                      if(session.getAttribute("pse0053_resumo")!=null) {
                        res_Jw_pse0053_total_fechado_itens  = p.getRetorno_simbolico_itens_resumo(pro_numero_sub_processo , filial, session);
                      } else {
                        res_Jw_pse0053_total_fechado_itens = p.getRetorno_simbolico_itens(pro_numero_sub_processo , filial, session);
                      }
                      int i_bl_report_Jw_pse0053_total_fechado_itens = 0;
                      while(i_bl_report_Jw_pse0053_total_fechado_itens <res_Jw_pse0053_total_fechado_itens.size()) {
                        portalbr.dbobj.view.Jw_pse0053_total_fechado t_jw_pse0053_total_fechado_itens = (portalbr.dbobj.view.Jw_pse0053_total_fechado)res_Jw_pse0053_total_fechado_itens.elementAt(i_bl_report_Jw_pse0053_total_fechado_itens);
                        pro_numero = t_jw_pse0053_total_fechado_itens.getPro_numero();
                        pro_nome = t_jw_pse0053_total_fechado_itens.getPro_nome();
                        pares = t_jw_pse0053_total_fechado_itens.getPares();
                        preco = t_jw_pse0053_total_fechado_itens.getPreco();
                        total = t_jw_pse0053_total_fechado_itens.getTotal();
                        %>

                        <%
                        if(tipo.equalsIgnoreCase("R")){
                          %>

                          <tr class="totalColumn">

                            <td class="totalTdColumn"  style="text-align:left;" >
                              <%= pro_numero %>
                              -
                              <%= pro_nome %>
                            </td>


                            <td class="totalTdColumn"  style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(pares, "##,##0.0000") %>
                              <%
                              totalPares += pares;
                              %>
                            </td>
                            <td class="totalTdColumn"  style="text-align:right;" >
                               
                              <%= com.egen.util.text.FormatNumber.format(preco, "##,##0.0000") %>
                            </td>
                            <td class="totalTdColumn"  style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(total, "##,##0.0000") %>
                              <%
                              valor_total_nota += total;
                              totalValor += total;
                              %>
                            </td>
                          </tr>

                          <%
                        }
                        %>


                        <%
                        i_bl_report_Jw_pse0053_total_fechado_itens++;
                      }
                      %>

                      <%
                      if(tipo.equalsIgnoreCase("R")){
                        %>

                        <tr class="totalColumn">

                          <td class="totalTdColumn"  style="text-align:left;" >
                            <b>
                              Total
                            </b>
                          </td>


                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(totalPares, "##,##0.0000") %>
                            </b>
                          </td>

                          <td class="totalTdColumn"  style="text-align:right;" >
                          </td>

                          <td class="totalTdColumn"  style="text-align:right;" >
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(totalValor, "##,##0.0000") %>
                            </b>
                            <%
                            //                  valor_total_nota = totalValor;
                            session.setAttribute("valor_total_nota_" + pro_numero_sub_processo , valor_total_nota);
                            %>
                          </td>
                        </tr>

                        <%
                      }
                      %>


                      <%
                      totalValor = 0d;
                      totalPares = 0d;
                      sum_pares_1 = 0.0;
                    }
                  }
                  %>

                </table>

                <%
                java.util.Vector res_Jw_pse0053_total_fechado_itens = p.getDescontos(pro_numero_sub_processo , filial, session);
                if (res_Jw_pse0053_total_fechado_itens!=null && res_Jw_pse0053_total_fechado_itens.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_pse0053_total_fechado"  class="reportTable"   style="width:50%; "  border="1" >
                    <tr class="reportHeader2">
                      <td style="text-align: center;" colspan="4" >
                        Valor dos descontos
                      </td>
                    </tr>


                    <tr class="reportTr">

                      <td class="columnTdHeader" style="text-align: left;" >
                        Processo
                      </td>

                      <td class="columnTdHeader" style="text-align: right;" >
                        Quantidade
                      </td>

                      <td class="columnTdHeader" style="text-align: right;" >
                        Valor Processo
                      </td>

                      <td class="columnTdHeader" style="text-align: right;" >
                        Total
                      </td>
                    </tr>



                    <%
                    int i_bl_report_Jw_pse0053_total_fechado_itens = 0;
                    while(i_bl_report_Jw_pse0053_total_fechado_itens <res_Jw_pse0053_total_fechado_itens.size()) {
                      portalbr.dbobj.view.Jw_pse0053_total_fechado t_jw_pse0053_total_fechado_itens = (portalbr.dbobj.view.Jw_pse0053_total_fechado)res_Jw_pse0053_total_fechado_itens.elementAt(i_bl_report_Jw_pse0053_total_fechado_itens);
                      pro_numero = t_jw_pse0053_total_fechado_itens.getPro_numero();
                      pro_nome = t_jw_pse0053_total_fechado_itens.getPro_nome();
                      pares = t_jw_pse0053_total_fechado_itens.getPares();
                      preco = t_jw_pse0053_total_fechado_itens.getPreco();
                      total = t_jw_pse0053_total_fechado_itens.getTotal();
                      %>

                      <%
                      if(tipo.equalsIgnoreCase("R")){
                        %>

                        <tr class="totalColumn">

                          <td class="totalTdColumn"  style="text-align:left;" >
                            <%= pro_numero %>
                            -
                            <%= pro_nome %>
                          </td>


                          <td class="totalTdColumn"  style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(pares, "##,##0.0000") %>
                            <%
                            totalPares += pares;
                            %>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                             
                            <%= com.egen.util.text.FormatNumber.format(preco, "##,##0.0000") %>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(total, "##,##0.0000") %>
                            <%
                            valor_total_nota -= total;
                            session.setAttribute("valor_total_nota_" + pro_numero_sub_processo , valor_total_nota);
                            totalValor += total;
                            %>
                          </td>
                        </tr>

                        <%
                      }
                      %>


                      <%
                      i_bl_report_Jw_pse0053_total_fechado_itens++;
                    }
                    %>



                    <tr class="totalColumn">

                      <td class="totalTdColumn"  style="text-align:left;" >
                        <b>
                          Total
                        </b>
                      </td>


                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(totalPares, "##,##0.0000") %>
                        </b>
                      </td>

                      <td class="totalTdColumn"  style="text-align:right;" >
                      </td>

                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(totalValor, "##,##0.0000") %>
                        </b>
                        <%
                        //                    valor_total_nota = totalValor;
                        //                    session.setAttribute("valor_total_nota_" + pro_numero_sub_processo , valor_total_nota);
                        %>
                      </td>
                    </tr>






                    <%
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



          <br>
          <%
          {
            %>

            <%
            java.util.Vector res_Jw_pse0053_total_aberto = (java.util.Vector)session.getAttribute("res_Jw_pse0053_total_aberto");
            String tipo = (String)session.getAttribute("pse0053_tipo");
            %>

            <form  name="bl_report_Jw_pse0053_total_aberto" id="bl_report_Jw_pse0053_total_aberto" class="baseForm" method="post" >

              <%
              if (res_Jw_pse0053_total_aberto!=null && res_Jw_pse0053_total_aberto.size()>0) {
                %>

                <table id="TRbl_report_Jw_pse0053_total_aberto"  class="reportTable"   style="width:50%; "  border="1" >
                  <%
                  java.lang.Integer pro_numero_atual =  null;
                  java.lang.Integer pro_numero1 =  null;
                  java.lang.Integer codigo_item =  null;
                  java.lang.String descricao_produtos =  null;
                  java.lang.String pro_nome1 =  null;
                  java.lang.Integer linha =  null;
                  java.lang.Integer referencia =  null;
                  java.lang.Integer cabedal =  null;
                  java.lang.Integer pares1 =  null;
                  java.lang.Double preco1 =  null;
                  java.lang.Double total1 =  null;
                  String _b0_control = "__";
                  int sum_pares1_1 = 0;
                  double sum_valor1_1 = 0.0;
                  int i_bl_report_Jw_pse0053_total_aberto = 0;
                  while (i_bl_report_Jw_pse0053_total_aberto<res_Jw_pse0053_total_aberto.size()) {
                    portalbr.dbobj.view.Jw_pse0053_total_aberto t_jw_pse0053_total_aberto = (portalbr.dbobj.view.Jw_pse0053_total_aberto)res_Jw_pse0053_total_aberto.elementAt(i_bl_report_Jw_pse0053_total_aberto);
                    pro_numero1 = t_jw_pse0053_total_aberto.getPro_numero();
                    codigo_item = t_jw_pse0053_total_aberto.getCodigo_item();
                    descricao_produtos = t_jw_pse0053_total_aberto.getDescricao_produtos();
                    pro_nome1 = t_jw_pse0053_total_aberto.getPro_nome();
                    linha = t_jw_pse0053_total_aberto.getLinha();
                    referencia = t_jw_pse0053_total_aberto.getReferencia();
                    cabedal = t_jw_pse0053_total_aberto.getCabedal();
                    pares1 = t_jw_pse0053_total_aberto.getPares()!=null?t_jw_pse0053_total_aberto.getPares():0;
                    preco1 = t_jw_pse0053_total_aberto.getPreco()!=null?t_jw_pse0053_total_aberto.getPreco():0.0;
                    total1 = t_jw_pse0053_total_aberto.getTotal()!=null?t_jw_pse0053_total_aberto.getTotal():0.0;
                    sum_pares1_1 += ((pares1!=null)?pares1.intValue():0);
                    sum_valor1_1 += total1;
                    String _b0_value = com.egen.util.text.FormatNumber.format(pro_numero1);
                    if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                      %>
                      <tr class="reportHeader2">
                        <td style="text-align: center;" colspan="8" >
                          <big>
                            Resumo da mão de obra por modelo
                          </big>
                        </td>
                      </tr>

                      <tr class="reportTr">
                        <td class="columnTdHeader" style="text-align: left" colspan="8">
                          Processo :
                          <%
                          pro_numero_atual  = pro_numero1;
                          %>
                          <%= ((pro_numero1!=null)?pro_numero1.toString():"") %>
                          -
                          <%= ((pro_nome1!=null)?pro_nome1.toString():"") %>
                        </td>
                      </tr>
                      <%
                      %>

                      <tr class="reportTr">
                        <td class="columnTdHeader" style="text-align:right;" >
                          Codigo do Item
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Descrição dos Produtos
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Linha
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Ref.
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Cabedal
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Pares
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Preço MO.
                        </td>

                        <td class="columnTdHeader" style="text-align:right;" >
                          Total
                        </td>

                      </tr>

                      <%
                    }
                    String style_bl_report_Jw_pse0053_total_aberto="";
                    if (!((i_bl_report_Jw_pse0053_total_aberto%2)!=0)) {
                      style_bl_report_Jw_pse0053_total_aberto="rowColor";
                    } else {
                      style_bl_report_Jw_pse0053_total_aberto="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Jw_pse0053_total_aberto %>' id="TRbl_report_Jw_pse0053_total_aberto<%=i_bl_report_Jw_pse0053_total_aberto%>" >
                      <td class="reportColumn" style="text-align:right;" >
                        <%= ((codigo_item!=null)?codigo_item.toString():"") %>
                      </td>
                      <td class="reportColumn" style="text-align:left;" >
                        <%= ((descricao_produtos!=null)?descricao_produtos.toString():"") %>
                      </td>
                      <td class="reportColumn" style="text-align:right;" >
                        <%= ((linha!=null)?linha.toString():"") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= ((referencia!=null)?referencia.toString():"") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= ((cabedal!=null)?cabedal.toString():"") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= ((pares1!=null)?pares1.toString():"") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= com.egen.util.text.FormatNumber.format(preco1, "##,##0.0000") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= com.egen.util.text.FormatNumber.format(total1, "##,##0.0000") %>
                      </td>

                    </tr>

                    <%
                    _b0_control = _b0_value;
                    i_bl_report_Jw_pse0053_total_aberto++;
                    if (i_bl_report_Jw_pse0053_total_aberto<res_Jw_pse0053_total_aberto.size()) {
                      t_jw_pse0053_total_aberto = (portalbr.dbobj.view.Jw_pse0053_total_aberto)res_Jw_pse0053_total_aberto.elementAt(i_bl_report_Jw_pse0053_total_aberto);
                      pro_numero1 = t_jw_pse0053_total_aberto.getPro_numero();
                      pro_nome1 = t_jw_pse0053_total_aberto.getPro_nome();
                      linha = t_jw_pse0053_total_aberto.getLinha();
                      referencia = t_jw_pse0053_total_aberto.getReferencia();
                      cabedal = t_jw_pse0053_total_aberto.getCabedal();
                      pares1 = t_jw_pse0053_total_aberto.getPares()!=null?t_jw_pse0053_total_aberto.getPares():0;
                      preco1 = t_jw_pse0053_total_aberto.getPreco()!=null?t_jw_pse0053_total_aberto.getPreco():0.0;
                      total1 = t_jw_pse0053_total_aberto.getTotal()!=null?t_jw_pse0053_total_aberto.getTotal():0.0;
                      _b0_value = com.egen.util.text.FormatNumber.format(pro_numero1);
                    } else {
                      _b0_control = "__";
                    }
                    if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                      %>

                      <tr class="totalColumn">
                        <td>
                           
                        </td>
                        <td>
                           
                        </td>
                        <td>
                           
                        </td>
                        <td>
                           
                        </td>
                        <td>
                           
                        </td>
                        <td class="totalTdColumn"  style="text-align:right;" >
                          <b>
                            Total :
                            <%= com.egen.util.text.FormatNumber.format(sum_pares1_1, "##,##0") %>
                          </b>
                        </td>
                        <td>
                           
                        </td>
                        <td class="totalTdColumn"  style="text-align:right;" >
                          <b>
                            Total :
                            <%= com.egen.util.text.FormatNumber.format(sum_valor1_1, "##,##0.0000") %>
                          </b>
                          <%
                          if(tipo.equalsIgnoreCase("R")){
                            Double valorTotalNota = (Double)session.getAttribute("valor_total_nota_" + pro_numero_atual);
                            valorTotalNota += sum_valor1_1;
                            session.setAttribute("valor_total_nota_" + pro_numero_atual  , valorTotalNota);
                          }
                          %>
                        </td>
                      </tr>

                      <%
                      sum_pares1_1 = 0;
                      sum_valor1_1 = 0.0;
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
          <%
          {
            java.util.Vector res_Jw_pse0053_notas_fiscais = (java.util.Vector)session.getAttribute("res_Jw_pse0053_notas_fiscais");
            String totalNotas = null;
            %>

            <form  name="bl_report_Jw_pse0053_notas_fiscais" id="bl_report_Jw_pse0053_notas_fiscais" class="baseForm" method="post" >

              <%
              if (res_Jw_pse0053_notas_fiscais!=null && res_Jw_pse0053_notas_fiscais.size()>0) {
                %>

                <table id="TRbl_report_Jw_pse0053_notas_fiscais"  class="reportTable"   style="width:50%; "  border="1" >
                  <tr class="reportHeader2">
                    <td style="text-align: center;" colspan="5" >
                      <big>
                        Notas fiscais de origem Calçados Beira Rio
                      </big>
                    </td>
                  </tr>

                  <%
                  java.lang.Integer pro_numero_atual = null;
                  java.lang.Integer pro_numero2 = null;
                  java.lang.String pro_nome2 = null;
                  java.lang.String fil_filial = null;
                  java.lang.Integer nfs_nmro = null;
                  java.lang.String nfs_serie = null;
                  java.lang.String remessas = null;
                  java.lang.String oc = null;
                  java.lang.String total_notas =  null;
                  String _b0_control = "__";
                  int i_bl_report_Jw_pse0053_notas_fiscais = 0;
                  while (i_bl_report_Jw_pse0053_notas_fiscais<res_Jw_pse0053_notas_fiscais.size()) {
                    portalbr.dbobj.view.Jw_pse0053_notas_fiscais t_jw_pse0053_notas_fiscais = (portalbr.dbobj.view.Jw_pse0053_notas_fiscais)res_Jw_pse0053_notas_fiscais.elementAt(i_bl_report_Jw_pse0053_notas_fiscais);
                    pro_numero2 = t_jw_pse0053_notas_fiscais.getPro_numero();
                    pro_nome2 = t_jw_pse0053_notas_fiscais.getPro_nome();
                    fil_filial = t_jw_pse0053_notas_fiscais.getFil_filial()==null?"":t_jw_pse0053_notas_fiscais.getFil_filial();
                    nfs_nmro = t_jw_pse0053_notas_fiscais.getNfs_nmro();
                    nfs_serie = t_jw_pse0053_notas_fiscais.getNfs_serie()==null?"":t_jw_pse0053_notas_fiscais.getNfs_serie();
                    remessas = t_jw_pse0053_notas_fiscais.getRemessas()==null?"":t_jw_pse0053_notas_fiscais.getRemessas();
                    oc = t_jw_pse0053_notas_fiscais.getOc()==null?"":t_jw_pse0053_notas_fiscais.getOc();
                    String _b0_value = com.egen.util.text.FormatNumber.format(pro_numero2);
                    if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                      %>
                      <tr class="reportHeader">
                        <td class="columnTdHeader" style="text-align: left" colspan="5">
                          Processo :
                          <%
                          pro_numero_atual = pro_numero2;
                          %>
                          <%= ((pro_numero2!=null)?pro_numero2.toString():"") %>
                          -
                          <%= ((pro_nome2!=null)?pro_nome2.toString():"") %>
                          <%
                          totalNotas = com.egen.util.text.FormatNumber.format(p.getTotal_notas(pro_numero2+"",fil_filial+"",(String)session.getAttribute("pse0053_fornecedor"), (String)session.getAttribute("pse0053_dt_inicial") ,(String)session.getAttribute("pse0053_dt_final"), (String)session.getAttribute("pse0053_tipo")), "##,##0.0000");
                          %>
                        </span>
                      </td>
                    </tr>
                    <%
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Filial
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Nota Fiscal
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Série
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Remessas
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        OC
                      </td>

                    </tr>

                    <%
                  }
                  String style_bl_report_Jw_pse0053_notas_fiscais="";
                  if (!((i_bl_report_Jw_pse0053_notas_fiscais%2)!=0)) {
                    style_bl_report_Jw_pse0053_notas_fiscais="rowColor";
                  } else {
                    style_bl_report_Jw_pse0053_notas_fiscais="rowBlank";
                  }
                  %>

                  <tr class='<%= style_bl_report_Jw_pse0053_notas_fiscais %>' id="TRbl_report_Jw_pse0053_notas_fiscais<%=i_bl_report_Jw_pse0053_notas_fiscais%>" >
                    <td class="reportColumn" style="text-align:left;" >
                      <%= fil_filial %>
                    </td>

                    <td class="reportColumn" style="text-align:right;" >
                      <%= ((nfs_nmro!=null)?nfs_nmro.toString():"") %>
                    </td>

                    <td class="reportColumn" style="text-align:left;" >
                      <%= nfs_serie %>
                    </td>

                    <td class="reportColumn" style="text-align:left;" >
                      <%= remessas %>
                    </td>

                    <td class="reportColumn" style="text-align:left;" >
                      <%= oc%>
                    </td>

                  </tr>

                  <%
                  _b0_control = _b0_value;
                  i_bl_report_Jw_pse0053_notas_fiscais++;
                  if (i_bl_report_Jw_pse0053_notas_fiscais<res_Jw_pse0053_notas_fiscais.size()) {
                    t_jw_pse0053_notas_fiscais = (portalbr.dbobj.view.Jw_pse0053_notas_fiscais)res_Jw_pse0053_notas_fiscais.elementAt(i_bl_report_Jw_pse0053_notas_fiscais);
                    pro_numero2 = t_jw_pse0053_notas_fiscais.getPro_numero();
                    pro_nome2 = t_jw_pse0053_notas_fiscais.getPro_nome();
                    fil_filial = t_jw_pse0053_notas_fiscais.getFil_filial()==null?"":t_jw_pse0053_notas_fiscais.getFil_filial();
                    nfs_nmro = t_jw_pse0053_notas_fiscais.getNfs_nmro();
                    nfs_serie = t_jw_pse0053_notas_fiscais.getNfs_serie()==null?"":t_jw_pse0053_notas_fiscais.getNfs_serie();
                    remessas = t_jw_pse0053_notas_fiscais.getRemessas()==null?"":t_jw_pse0053_notas_fiscais.getRemessas();
                    oc = t_jw_pse0053_notas_fiscais.getOc()==null?"":t_jw_pse0053_notas_fiscais.getOc();
                    _b0_value = com.egen.util.text.FormatNumber.format(pro_numero2);
                  } else {
                    _b0_control = "__";
                  }
                  if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                    %>

                    <tr class="totalColumn">
                      <td>
                         
                      </td>
                      <td>
                         
                      </td>
                      <td>

                      </td>
                      <td>
                         
                      </td>
                      <td class="totalTdColumn"  style="text-align: right;" >

                        <%
                        Double valorTotalNota = (Double)session.getAttribute("valor_total_nota_" + pro_numero_atual );
                        %>
                        <b>
                          Total Nota :
                          <%= com.egen.util.text.FormatNumber.format(valorTotalNota, "##,##0.0000") %>
                        </b>
                      </td>
                    </tr>


                    <%
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
        <html:form action="ind/Pse0053_r2Form.do" method="post" styleClass="baseForm">
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

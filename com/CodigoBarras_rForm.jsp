<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Relatório de Códigos de Barras - EAN13 / DUN14 / SSCC
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(68)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <style>
              .text{ mso-number-format:"\@";/*force text*/ }
            </style>
            <%
            {
              %>

              <%
              acesso.Sessao sessao = new acesso.Sessao(session);
              java.util.Vector res_Jw_cod_barra = (java.util.Vector)session.getAttribute("res_Jw_cod_barra");
              boolean exibeNumeroExterior = false;
              boolean organizarPorLoja = false;
              boolean exibeQuantidades = false;
              boolean exibePrecos = false;
              boolean agruparModelo = false;
              boolean informouPedidos = false;
              if(session.getAttribute("res_Jw_cod_barra_agrupar_modelo") != null){
                agruparModelo = true;
              }
              if(session.getAttribute("codigo_barras_exibe_quantidade_pares") != null){
                exibeQuantidades = true;
              }
              if(session.getAttribute("codigo_barras_exibe_precos") != null){
                exibePrecos = true;
              }
              if(session.getAttribute("codigo_barras_exibe_numero_exterior") != null){
                exibeNumeroExterior = true;
              }
              if(session.getAttribute("organizarPorLoja") != null){
                organizarPorLoja = true;
              }
              if(session.getAttribute("codigo_barras_informou_pedidos") != null){
                informouPedidos = true;
              }
              %>

              <%
              if (res_Jw_cod_barra!=null && res_Jw_cod_barra.size()>0) {
                %>

                <table id="TRbl_report_Jw_cod_barra"  class="reportTable"   style="width:99%; "  border="1"  frame="box">
                  <%
                  java.lang.String linha_ref = null;
                  java.lang.String linha_ref_cab = null;
                  java.lang.String ref_desc = null;
                  java.lang.String cabedal = null;
                  java.lang.String cor =  null;
                  java.lang.String grade =  null;
                  java.lang.String grade_ext = null;
                  java.lang.String loja = null;
                  java.lang.String cod_barra = null;
                  java.lang.String status = null;
                  java.lang.Integer codigo_marca = null;
                  java.lang.Integer cor_cdgo = null;
                  java.lang.Integer cab_cdgo = null;
                  java.lang.Integer pares = null;
                  java.lang.Integer pares_ean13 = null;
                  java.lang.Double preco_unitario = null;
                  java.lang.String descricao_marca = null;
                  java.lang.String cor_desc = null;
                  java.lang.String cab_desc = null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:center; width:1%" >
                      Marca
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Descrição Marca
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      <%
                      if(agruparModelo) {
                        %>
                        <bean:message bundle="ComercialResources" key="CodigoBarra_r.linha_ref_cab"/>
                        <%
                      } else {
                        %>
                        <bean:message bundle="ComercialResources" key="CodigoBarra_r.linha_ref"/>
                        <%
                      }
                      %>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Descrição Referência
                    </td>

                    <%
                    if(!agruparModelo) {
                      %>
                      <td class="columnTdHeader" style="text-align:left;" >
                        <bean:message bundle="ComercialResources" key="CodigoBarra_r.cabedal"/>
                      </td>
                      <%
                    }
                    %>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Descrição Cabedal
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      <bean:message bundle="ComercialResources" key="CodigoBarra_r.cor"/>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Descrição Cor
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Numeração Int.
                    </td>

                    <%
                    if(exibeNumeroExterior){
                      %>
                      <td class="columnTdHeader" style="text-align:left;" >
                        Numeração Ext.
                      </td>
                      <%
                    }
                    %>


                    <%
                    if(exibeQuantidades){
                      %>
                      <td class="columnTdHeader" style="text-align:left;" >
                        Qtd. Pares
                      </td>
                      <%
                    }
                    %>

                    <%
                    if(exibePrecos){
                      %>
                      <td class="columnTdHeader" style="text-align:left;" >
                        Preço Unit.
                      </td>
                      <%
                    }
                    %>

                    <%
                    if(organizarPorLoja){
                      %>
                      <td class="columnTdHeader" style="text-align:left;" >
                        Loja
                      </td>
                      <%
                    }
                    %>

                    <td class="columnTdHeader" style="text-align:center;" >
                      <bean:message bundle="ComercialResources" key="CodigoBarra_r.cod_barra"/>
                    </td>

                    <%
                    if(informouPedidos) {
                      %>
                      <td class="columnTdHeader" style="text-align:center;" >
                        Qtd. Pares
                      </td>
                      <%
                    }
                    %>

                    <td class="columnTdHeader" style="text-align:center;" >
                      <bean:message bundle="ComercialResources" key="CodigoBarra_r.status"/>
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Jw_cod_barra = 0;
                  while (i_bl_report_Jw_cod_barra<res_Jw_cod_barra.size()) {
                    portalbr.dbobj.view.Jw_cod_barra t_jw_cod_barra = (portalbr.dbobj.view.Jw_cod_barra)res_Jw_cod_barra.elementAt(i_bl_report_Jw_cod_barra);
                    linha_ref = t_jw_cod_barra.getLinha_ref()==null?"":t_jw_cod_barra.getLinha_ref();
                    linha_ref_cab = t_jw_cod_barra.getLinha_ref()==null?"":(t_jw_cod_barra.getLinha_ref()+"."+t_jw_cod_barra.getCab_cdgo());
                    ref_desc = t_jw_cod_barra.getRef_desc()==null?"":t_jw_cod_barra.getRef_desc();
                    cabedal = t_jw_cod_barra.getCabedal()==null?"":t_jw_cod_barra.getCabedal();
                    cor = t_jw_cod_barra.getCor()==null?"":t_jw_cod_barra.getCor();
                    grade = t_jw_cod_barra.getGrade()==null?"":t_jw_cod_barra.getGrade();
                    grade_ext = t_jw_cod_barra.getGrade_ext()==null?"":t_jw_cod_barra.getGrade_ext();
                    loja = t_jw_cod_barra.getLoja()==null?"":t_jw_cod_barra.getLoja();
                    cod_barra = t_jw_cod_barra.getCod_barra()==null?"":t_jw_cod_barra.getCod_barra();
                    status = t_jw_cod_barra.getStatus()==null?"":t_jw_cod_barra.getStatus();
                    codigo_marca = t_jw_cod_barra.getCodigo_marca();
                    pares = t_jw_cod_barra.getPares();
                    pares_ean13 = t_jw_cod_barra.getPares_ean13();
                    preco_unitario = t_jw_cod_barra.getPreco_unitario();
                    cor_cdgo = t_jw_cod_barra.getCor_cdgo();
                    cab_cdgo = t_jw_cod_barra.getCab_cdgo();
                    descricao_marca = t_jw_cod_barra.getDescricao_marca()==null?"":t_jw_cod_barra.getDescricao_marca();
                    cor_desc = t_jw_cod_barra.getCor_desc()==null?"":t_jw_cod_barra.getCor_desc();
                    cab_desc = t_jw_cod_barra.getCab_desc()==null?"":t_jw_cod_barra.getCab_desc();
                    if(status.equals("A")){
                      status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.ativas");
                    } else {
                      status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.inativas");
                    }
                    ;
                    String style_bl_report_Jw_cod_barra="";
                    if (!((i_bl_report_Jw_cod_barra%2)!=0)) {
                      style_bl_report_Jw_cod_barra="rowColor";
                    } else {
                      style_bl_report_Jw_cod_barra="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Jw_cod_barra %>' id="TRbl_report_Jw_cod_barra<%=i_bl_report_Jw_cod_barra%>" >

                      <td class="reportColumn" style="text-align:center;" >
                        <%= codigo_marca %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= descricao_marca %>
                      </td>


                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <td class="reportColumn" style="text-align:left;" >
                          <%
                          if(agruparModelo) {
                            %>

                            <%= linha_ref_cab %>
                            <%
                          } else {
                            %>
                            <%
                            if(!(request.getParameter("excel")+"").equals("true")){
                              %>
                              <%= linha_ref %>
                              <%
                            } else {
                              %>
                              <%= linha_ref %>
                               
                              <%
                            }
                            %>
                            <%
                          }
                          %>
                        </td>

                        <%
                      } else {
                        %>
                        <td class="reportColumn" style="text-align:left;mso-number-format:'\@';" >
                          <%
                          if(agruparModelo) {
                            %>

                            <%= linha_ref_cab %>
                            <%
                          } else {
                            %>
                            <%
                            if(!(request.getParameter("excel")+"").equals("true")){
                              %>
                              <%= linha_ref %>
                              <%
                            } else {
                              %>
                              <%= linha_ref %>
                               
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

                      <td class="reportColumn" style="text-align:left;" >
                        <%= ref_desc %>
                      </td>

                      <%
                      if(!agruparModelo) {
                        %>
                        <td class="reportColumn" style="text-align:left;" >
                          <%= cab_cdgo %>
                        </td>
                        <%
                      }
                      %>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= cab_desc %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= cor_cdgo %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= cor_desc %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= grade %>
                      </td>

                      <%
                      if(exibeNumeroExterior){
                        %>
                        <td class="reportColumn" style="text-align:left;" >
                          <%= grade_ext %>
                        </td>
                        <%
                      }
                      %>

                      <%
                      if(exibeQuantidades){
                        %>
                        <td class="reportColumn" style="text-align:left;" >
                          <%= pares %>
                        </td>
                        <%
                      }
                      %>

                      <%
                      if(exibePrecos){
                        %>
                        <td class="reportColumn" style="text-align:left;" >
                          <%= com.egen.util.text.FormatNumber.format(preco_unitario, "##,##0.00") %>
                        </td>
                        <%
                      }
                      %>

                      <%
                      if(organizarPorLoja){
                        %>
                        <td class="reportColumn" style="text-align:left;" >
                          <%= loja %>
                        </td>
                        <%
                      }
                      %>

                      <td class="reportColumn" style="text-align:center;" >
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <%= cod_barra %>
                          <%
                        } else {
                          %>
                          <%= cod_barra %>
                           
                          <%
                        }
                        %>
                      </td>


                      <%
                      if(informouPedidos) {
                        %>
                        <td class="reportColumn" style="text-align:center;" >
                          <%= pares_ean13 %>
                        </td>
                        <%
                      }
                      %>

                      <td class="reportColumn" style="text-align:center;" >
                        <%= status %>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Jw_cod_barra++;
                    if (i_bl_report_Jw_cod_barra<res_Jw_cod_barra.size()) {
                      t_jw_cod_barra = (portalbr.dbobj.view.Jw_cod_barra)res_Jw_cod_barra.elementAt(i_bl_report_Jw_cod_barra);
                      linha_ref = t_jw_cod_barra.getLinha_ref()==null?"":t_jw_cod_barra.getLinha_ref();
                      linha_ref_cab = t_jw_cod_barra.getLinha_ref()==null?"":(t_jw_cod_barra.getLinha_ref()+"."+t_jw_cod_barra.getCab_cdgo());
                      ref_desc = t_jw_cod_barra.getRef_desc()==null?"":t_jw_cod_barra.getRef_desc();
                      cabedal = t_jw_cod_barra.getCabedal()==null?"":t_jw_cod_barra.getCabedal();
                      cor = t_jw_cod_barra.getCor()==null?"":t_jw_cod_barra.getCor();
                      grade = t_jw_cod_barra.getGrade()==null?"":t_jw_cod_barra.getGrade();
                      grade_ext = t_jw_cod_barra.getGrade_ext()==null?"":t_jw_cod_barra.getGrade_ext();
                      loja = t_jw_cod_barra.getLoja()==null?"":t_jw_cod_barra.getLoja();
                      cod_barra = t_jw_cod_barra.getCod_barra()==null?"":t_jw_cod_barra.getCod_barra();
                      status = t_jw_cod_barra.getStatus()==null?"":t_jw_cod_barra.getStatus();
                      codigo_marca = t_jw_cod_barra.getCodigo_marca();
                      pares = t_jw_cod_barra.getPares();
                      pares_ean13 = t_jw_cod_barra.getPares_ean13();
                      preco_unitario = t_jw_cod_barra.getPreco_unitario();
                      cor_cdgo = t_jw_cod_barra.getCor_cdgo();
                      cab_cdgo = t_jw_cod_barra.getCab_cdgo();
                      descricao_marca = t_jw_cod_barra.getDescricao_marca()==null?"":t_jw_cod_barra.getDescricao_marca();
                      cor_desc = t_jw_cod_barra.getCor_desc()==null?"":t_jw_cod_barra.getCor_desc();
                      cab_desc = t_jw_cod_barra.getCab_desc()==null?"":t_jw_cod_barra.getCab_desc();
                      if(status.equals("A")){
                        status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.ativas");
                      } else {
                        status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.inativas");
                      }

                      ;
                    } else {
                    }
                  }
                  %>

                </table>

                <%
              }
              %>

              <%
            }
            %>






            <%
            {
              %>

              <%
              java.util.Vector res_Jw_cod_barra_dum14 = (java.util.Vector)session.getAttribute("res_Jw_cod_barra_dum14");
              boolean organizarPorLoja = false;
              boolean agruparModelo = false;
              boolean exibePrecos = false;
              if(session.getAttribute("codigo_barras_exibe_precos") != null){
                exibePrecos = true;
              }
              if(session.getAttribute("res_Jw_cod_barra_agrupar_modelo") != null){
                agruparModelo = true;
              }
              if(session.getAttribute("organizarPorLoja") != null){
                organizarPorLoja = true;
              }
              %>

              <%
              if (res_Jw_cod_barra_dum14!=null && res_Jw_cod_barra_dum14.size()>0) {
                %>

                <table id="TRbl_report_Jw_cod_barra_dum14"  class="reportTable"   style="width:99%; "  border="1"  frame="box">
                  <%
                  java.lang.String linha_ref = null;
                  java.lang.String linha_ref_cab = null;
                  java.lang.String ref_desc = null;
                  java.lang.Integer cab_cdgo = null;
                  java.lang.String cabedal = null;
                  java.lang.Integer cor_cdgo = null;
                  java.lang.String cor =  null;
                  java.lang.String gde_cdgo = null;
                  java.lang.String loja =  null;
                  java.lang.Integer qtd_pares = null;
                  java.lang.Double preco_unitario2 = null;
                  java.lang.String cod_dum14 = null;
                  java.lang.String status = null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:center;" >
                      <%
                      if(agruparModelo) {
                        %>
                        <bean:message bundle="ComercialResources" key="CodigoBarraDun14_r.linha_ref_cab"/>
                        <%
                      } else {
                        %>
                        <bean:message bundle="ComercialResources" key="CodigoBarraDun14_r.linha_ref"/>
                        <%
                      }
                      %>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Descrição Referência
                    </td>

                    <%
                    if(!agruparModelo) {
                      %>
                      <td class="columnTdHeader" style="text-align:left;" >
                        <bean:message bundle="ComercialResources" key="CodigoBarraDun14_r.cabedal"/>
                      </td>
                      <%
                    }
                    %>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Descrição Cabedal
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Cor
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Descrição Cor
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      <bean:message bundle="ComercialResources" key="CodigoBarraDun14_r.gde_cdgo"/>
                    </td>

                    <%
                    if(organizarPorLoja){
                      %>
                      <td class="columnTdHeader" style="text-align:left;" >
                        Loja
                      </td>
                      <%
                    }
                    %>

                    <td class="columnTdHeader" style="text-align:center;" >
                      <bean:message bundle="ComercialResources" key="CodigoBarraDun14_r.qtd_pares"/>
                    </td>

                    <%
                    if(exibePrecos){
                      %>
                      <td class="columnTdHeader" style="text-align:center;" >
                        Preço Unit.
                      </td>
                      <%
                    }
                    %>

                    <td class="columnTdHeader" style="text-align:center;" >
                      <bean:message bundle="ComercialResources" key="CodigoBarraDun14_r.cod_dum14"/>
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      <bean:message bundle="ComercialResources" key="CodigoBarraDun14_r.status"/>
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Jw_cod_barra_dum14 = 0;
                  while (i_bl_report_Jw_cod_barra_dum14<res_Jw_cod_barra_dum14.size()) {
                    portalbr.dbobj.view.Jw_cod_barra_dum14 t_jw_cod_barra_dum14 = (portalbr.dbobj.view.Jw_cod_barra_dum14)res_Jw_cod_barra_dum14.elementAt(i_bl_report_Jw_cod_barra_dum14);
                    linha_ref = t_jw_cod_barra_dum14.getLinha_ref()==null?"":t_jw_cod_barra_dum14.getLinha_ref();
                    linha_ref_cab = t_jw_cod_barra_dum14.getLinha_ref()==null?"":(t_jw_cod_barra_dum14.getLinha_ref()+"."+t_jw_cod_barra_dum14.getCab_cdgo());
                    ref_desc = t_jw_cod_barra_dum14.getRef_desc()==null?"":t_jw_cod_barra_dum14.getRef_desc();
                    cab_cdgo = t_jw_cod_barra_dum14.getCab_cdgo();
                    cabedal = t_jw_cod_barra_dum14.getCabedal()==null?"":t_jw_cod_barra_dum14.getCabedal();
                    cor_cdgo = t_jw_cod_barra_dum14.getCor_cdgo();
                    cor = t_jw_cod_barra_dum14.getCor()==null?"":t_jw_cod_barra_dum14.getCor();
                    gde_cdgo = t_jw_cod_barra_dum14.getGde_cdgo()==null?"":t_jw_cod_barra_dum14.getGde_cdgo();
                    loja = t_jw_cod_barra_dum14.getLoja()==null?"":t_jw_cod_barra_dum14.getLoja();
                    qtd_pares = t_jw_cod_barra_dum14.getQtd_pares();
                    preco_unitario2 = t_jw_cod_barra_dum14.getPreco_unitario();
                    cod_dum14 = t_jw_cod_barra_dum14.getCod_dum14()==null?"":t_jw_cod_barra_dum14.getCod_dum14();
                    status = t_jw_cod_barra_dum14.getStatus()==null?"":t_jw_cod_barra_dum14.getStatus();

                    if(status.equals("A")){
                      status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.ativas");
                    } else {
                      status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.inativas");
                      };
                      String style_bl_report_Jw_cod_barra_dum14="";
                      if (!((i_bl_report_Jw_cod_barra_dum14%2)!=0)) {
                        style_bl_report_Jw_cod_barra_dum14="rowColor";
                      } else {
                        style_bl_report_Jw_cod_barra_dum14="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_cod_barra_dum14 %>' id="TRbl_report_Jw_cod_barra_dum14<%=i_bl_report_Jw_cod_barra_dum14%>" >
                        <td class="reportColumn" style="text-align:center;" >
                          <%
                          if(agruparModelo) {
                            %>
                            <%= linha_ref_cab %>
                            <%
                          } else {
                            %>
                            <%
                            if(!(request.getParameter("excel")+"").equals("true")){
                              %>
                              <%= linha_ref %>
                              <%
                            } else {
                              %>
                              <%= linha_ref %>
                               
                              <%
                            }
                            %>
                            <%
                          }
                          %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= ref_desc %>
                        </td>

                        <%
                        if(!agruparModelo) {
                          %>
                          <td class="reportColumn" style="text-align:left;" >
                            <%= ((cab_cdgo!=null)?cab_cdgo.toString():"") %>
                          </td>
                          <%
                        }
                        %>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cabedal %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= ((cor_cdgo!=null)?cor_cdgo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cor %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= gde_cdgo %>
                        </td>

                        <%
                        if(organizarPorLoja){
                          %>
                          <td class="reportColumn" style="text-align:left;" >
                            <%= loja %>
                          </td>
                          <%
                        }
                        %>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= ((qtd_pares!=null)?qtd_pares.toString():"") %>
                        </td>

                        <%
                        if(exibePrecos){
                          %>
                          <td class="reportColumn" style="text-align:center;" >
                            <%= com.egen.util.text.FormatNumber.format(preco_unitario2, "##,##0.00") %>
                          </td>
                          <%
                        }
                        %>

                        <td class="reportColumn" style="text-align:center;" >
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%= cod_dum14 %>
                            <%
                          } else {
                            %>
                            <%= Long.parseLong(cod_dum14) %>
                             
                            <%
                          }
                          %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= status %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_cod_barra_dum14++;
                      if (i_bl_report_Jw_cod_barra_dum14<res_Jw_cod_barra_dum14.size()) {
                        t_jw_cod_barra_dum14 = (portalbr.dbobj.view.Jw_cod_barra_dum14)res_Jw_cod_barra_dum14.elementAt(i_bl_report_Jw_cod_barra_dum14);
                        linha_ref = t_jw_cod_barra_dum14.getLinha_ref()==null?"":t_jw_cod_barra_dum14.getLinha_ref();
                        linha_ref_cab = t_jw_cod_barra_dum14.getLinha_ref()==null?"":(t_jw_cod_barra_dum14.getLinha_ref()+"."+t_jw_cod_barra_dum14.getCab_cdgo());
                        ref_desc = t_jw_cod_barra_dum14.getRef_desc()==null?"":t_jw_cod_barra_dum14.getRef_desc();
                        cab_cdgo = t_jw_cod_barra_dum14.getCab_cdgo();
                        cabedal = t_jw_cod_barra_dum14.getCabedal()==null?"":t_jw_cod_barra_dum14.getCabedal();
                        cor_cdgo = t_jw_cod_barra_dum14.getCor_cdgo();
                        cor = t_jw_cod_barra_dum14.getCor()==null?"":t_jw_cod_barra_dum14.getCor();
                        gde_cdgo = t_jw_cod_barra_dum14.getGde_cdgo()==null?"":t_jw_cod_barra_dum14.getGde_cdgo();
                        loja = t_jw_cod_barra_dum14.getLoja()==null?"":t_jw_cod_barra_dum14.getLoja();
                        qtd_pares = t_jw_cod_barra_dum14.getQtd_pares();
                        preco_unitario2 = t_jw_cod_barra_dum14.getPreco_unitario();
                        cod_dum14 = t_jw_cod_barra_dum14.getCod_dum14()==null?"":t_jw_cod_barra_dum14.getCod_dum14();
                        status = t_jw_cod_barra_dum14.getStatus()==null?"":t_jw_cod_barra_dum14.getStatus();

                        if(status.equals("A")){
                          status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.ativas");
                        } else {
                          status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.inativas");
                          };
                        } else {
                        }
                      }
                      %>

                    </table>

                    <%
                  }
                  %>

                  <%
                }
                %>











                <%
                {
                  %>

                  <%
                  java.util.Vector res_Jw_cod_barra_sscc = (java.util.Vector)session.getAttribute("res_Jw_cod_barra_sscc");
                  boolean organizarPorLoja = false;
                  boolean agruparModelo = false;
                  if(session.getAttribute("res_Jw_cod_barra_agrupar_modelo") != null){
                    agruparModelo = true;
                  }
                  if(session.getAttribute("organizarPorLoja") != null){
                    organizarPorLoja = true;
                  }
                  %>

                  <%
                  if (res_Jw_cod_barra_sscc != null && res_Jw_cod_barra_sscc.size()>0) {
                    %>

                    <table id="TRbl_report_Jw_cod_barra_sscc"  class="reportTable"   style="width:99%; "  border="1"  frame="box">
                      <%
                      java.lang.Integer codigo_marca = null;
                      java.lang.String descricao_marca = null;
                      java.lang.String linha_ref = null;
                      java.lang.String linha_ref_cab = null;
                      java.lang.String ref_desc = null;
                      java.lang.Integer lin_cdgo = null;
                      java.lang.Integer ref_cdgo = null;
                      java.lang.Integer cab_cdgo = null;
                      java.lang.Integer cor_cdgo = null;
                      java.lang.String cab_desc = null;
                      java.lang.String cor_desc = null;
                      java.lang.String numero = null;
                      java.lang.String numero_externo = null;
                      java.lang.String loja = null;
                      java.lang.Integer qtd_pares = null;
                      java.lang.String sscc = null;
                      java.lang.String status = null;
                      %>

                      <tr class="reportTr">

                        <td class="columnTdHeader" style="text-align:center;" >
                          <%
                          if(agruparModelo) {
                            %>
                            <bean:message bundle="ComercialResources" key="CodigoBarraDun14_r.linha_ref_cab"/>
                            <%
                          } else {
                            %>
                            <bean:message bundle="ComercialResources" key="CodigoBarraDun14_r.linha_ref"/>
                            <%
                          }
                          %>
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Descrição Referência
                        </td>

                        <%
                        if(!agruparModelo) {
                          %>
                          <td class="columnTdHeader" style="text-align:left;" >
                            <bean:message bundle="ComercialResources" key="CodigoBarraDun14_r.cabedal"/>
                          </td>
                          <%
                        }
                        %>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Descrição Cabedal
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Cor
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Descrição Cor
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Numeração Int.
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Numeração Ext.
                        </td>

                        <%
                        if(organizarPorLoja){
                          %>
                          <td class="columnTdHeader" style="text-align:left;" >
                            Loja
                          </td>
                          <%
                        }
                        %>

                        <td class="columnTdHeader" style="text-align:center;" >
                          <bean:message bundle="ComercialResources" key="CodigoBarraDun14_r.qtd_pares"/>
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          SSCC
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          <bean:message bundle="ComercialResources" key="CodigoBarraDun14_r.status"/>
                        </td>

                      </tr>

                      <%
                      int i_bl_report_Jw_cod_barra_sscc = 0;
                      while (i_bl_report_Jw_cod_barra_sscc < res_Jw_cod_barra_sscc.size()) {
                        portalbr.dbobj.view.Jw_cod_barra_sscc t_jw_cod_barra_sscc = (portalbr.dbobj.view.Jw_cod_barra_sscc)res_Jw_cod_barra_sscc.elementAt(i_bl_report_Jw_cod_barra_sscc);
                        codigo_marca = t_jw_cod_barra_sscc.getCodigo_marca();
                        descricao_marca = t_jw_cod_barra_sscc.getDescricao_marca()==null?"":t_jw_cod_barra_sscc.getDescricao_marca();
                        linha_ref = t_jw_cod_barra_sscc.getLinha_ref()==null?"":t_jw_cod_barra_sscc.getLinha_ref();
                        linha_ref_cab = t_jw_cod_barra_sscc.getLinha_ref()==null?"":(t_jw_cod_barra_sscc.getLinha_ref()+"."+t_jw_cod_barra_sscc.getCab_cdgo());
                        ref_desc = t_jw_cod_barra_sscc.getRef_desc()==null?"":t_jw_cod_barra_sscc.getRef_desc();
                        lin_cdgo = t_jw_cod_barra_sscc.getLin_cdgo();
                        ref_cdgo = t_jw_cod_barra_sscc.getRef_cdgo();
                        cab_cdgo = t_jw_cod_barra_sscc.getCab_cdgo();
                        cor_cdgo = t_jw_cod_barra_sscc.getCor_cdgo();
                        cab_desc = t_jw_cod_barra_sscc.getCab_desc()==null?"":t_jw_cod_barra_sscc.getCab_desc();
                        cor_desc = t_jw_cod_barra_sscc.getCor_desc()==null?"":t_jw_cod_barra_sscc.getCor_desc();
                        numero = t_jw_cod_barra_sscc.getNumero()==null?"":t_jw_cod_barra_sscc.getNumero();
                        numero_externo = t_jw_cod_barra_sscc.getNumero_externo()==null?"":t_jw_cod_barra_sscc.getNumero_externo();
                        loja = t_jw_cod_barra_sscc.getLoja()==null?"":t_jw_cod_barra_sscc.getLoja();
                        qtd_pares = t_jw_cod_barra_sscc.getQtd_pares();
                        sscc = t_jw_cod_barra_sscc.getSscc()==null?"":t_jw_cod_barra_sscc.getSscc();
                        status = t_jw_cod_barra_sscc.getStatus()==null?"":t_jw_cod_barra_sscc.getStatus();

                        if(status.equals("A")){
                          status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.ativas");
                        } else {
                          status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.inativas");
                          };

                          String style_bl_report_Jw_cod_barra_sscc="";
                          if (!((i_bl_report_Jw_cod_barra_sscc%2)!=0)) {
                            style_bl_report_Jw_cod_barra_sscc="rowColor";
                          } else {
                            style_bl_report_Jw_cod_barra_sscc="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Jw_cod_barra_sscc %>' id="TRbl_report_Jw_cod_barra_dum14<%=i_bl_report_Jw_cod_barra_sscc%>" >

                            <td class="reportColumn" style="text-align:center;" >
                              <%
                              if(agruparModelo) {
                                %>
                                <%= linha_ref_cab %>
                                <%
                              } else {
                                %>
                                <%
                                if(!(request.getParameter("excel")+"").equals("true")){
                                  %>
                                  <%= linha_ref %>
                                  <%
                                } else {
                                  %>
                                  <%= linha_ref %>
                                   
                                  <%
                                }
                                %>
                                <%
                              }
                              %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <%= ref_desc %>
                            </td>

                            <%
                            if(!agruparModelo) {
                              %>
                              <td class="reportColumn" style="text-align:left;" >
                                <%= ((cab_cdgo!=null)?cab_cdgo.toString():"") %>
                              </td>
                              <%
                            }
                            %>

                            <td class="reportColumn" style="text-align:left;" >
                              <%= cab_desc %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <%= ((cor_cdgo!=null)?cor_cdgo.toString():"") %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <%= cor_desc %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <%= ((numero!=null)?numero.toString():"") %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <%= ((numero_externo!=null)?numero_externo.toString():"") %>
                            </td>

                            <%
                            if(organizarPorLoja){
                              %>
                              <td class="reportColumn" style="text-align:left;" >
                                <%= loja %>
                              </td>
                              <%
                            }
                            %>

                            <td class="reportColumn" style="text-align:left;" >
                              <%= qtd_pares %>
                            </td>

                            <td class="reportColumn" style="text-align:center;" >
                              <%
                              if(!(request.getParameter("excel")+"").equals("true")){
                                %>
                                <%= sscc %>
                                <%
                              } else {
                                %>
                                <%= sscc %>
                                 
                                <%
                              }
                              %>
                            </td>

                            <td class="reportColumn" style="text-align:center;" >
                              <%= status %>
                            </td>

                          </tr>

                          <%
                          i_bl_report_Jw_cod_barra_sscc++;
                          if (i_bl_report_Jw_cod_barra_sscc<res_Jw_cod_barra_sscc.size()) {
                            t_jw_cod_barra_sscc = (portalbr.dbobj.view.Jw_cod_barra_sscc)res_Jw_cod_barra_sscc.elementAt(i_bl_report_Jw_cod_barra_sscc);
                            codigo_marca = t_jw_cod_barra_sscc.getCodigo_marca();
                            descricao_marca = t_jw_cod_barra_sscc.getDescricao_marca()==null?"":t_jw_cod_barra_sscc.getDescricao_marca();
                            linha_ref = t_jw_cod_barra_sscc.getLinha_ref()==null?"":t_jw_cod_barra_sscc.getLinha_ref();
                            linha_ref_cab = t_jw_cod_barra_sscc.getLinha_ref()==null?"":(t_jw_cod_barra_sscc.getLinha_ref()+"."+t_jw_cod_barra_sscc.getCab_cdgo());
                            ref_desc = t_jw_cod_barra_sscc.getRef_desc()==null?"":t_jw_cod_barra_sscc.getRef_desc();
                            lin_cdgo = t_jw_cod_barra_sscc.getLin_cdgo();
                            ref_cdgo = t_jw_cod_barra_sscc.getRef_cdgo();
                            cab_cdgo = t_jw_cod_barra_sscc.getCab_cdgo();
                            cor_cdgo = t_jw_cod_barra_sscc.getCor_cdgo();
                            cab_desc = t_jw_cod_barra_sscc.getCab_desc()==null?"":t_jw_cod_barra_sscc.getCab_desc();
                            cor_desc = t_jw_cod_barra_sscc.getCor_desc()==null?"":t_jw_cod_barra_sscc.getCor_desc();
                            numero = t_jw_cod_barra_sscc.getNumero()==null?"":t_jw_cod_barra_sscc.getNumero();
                            numero_externo = t_jw_cod_barra_sscc.getNumero_externo()==null?"":t_jw_cod_barra_sscc.getNumero_externo();
                            qtd_pares = t_jw_cod_barra_sscc.getQtd_pares();
                            sscc = t_jw_cod_barra_sscc.getSscc()==null?"":t_jw_cod_barra_sscc.getSscc();
                            status = t_jw_cod_barra_sscc.getStatus()==null?"":t_jw_cod_barra_sscc.getStatus();

                            if(status.equals("A")){
                              status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.ativas");
                            } else {
                              status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.inativas");
                              };
                            } else {
                            }
                          }
                          %>

                        </table>

                        <%
                      }
                      %>

                      <%
                    }
                    %>



                    <%
                    {
                      %>

                      <%
                      java.util.Vector res_Jw_cod_barra_ambos = (java.util.Vector)session.getAttribute("res_Jw_cod_barra_ambos");
                      boolean exibeNumeroExterior = false;
                      boolean organizarPorLoja = false;
                      boolean agruparModelo = false;
                      boolean exibePrecos = false;
                      if(session.getAttribute("codigo_barras_exibe_precos") != null){
                        exibePrecos = true;
                      }
                      if(session.getAttribute("res_Jw_cod_barra_agrupar_modelo") != null){
                        agruparModelo = true;
                      }
                      if(session.getAttribute("codigo_barras_exibe_numero_exterior") != null){
                        exibeNumeroExterior = true;
                      }
                      if(session.getAttribute("organizarPorLoja") != null){
                        organizarPorLoja = true;
                      }
                      %>

                      <form  name="bl_report_Jw_cod_barra_ambos" id="bl_report_Jw_cod_barra_ambos" class="baseForm" method="post" >
                        <%
                        if (res_Jw_cod_barra_ambos!=null && res_Jw_cod_barra_ambos.size()>0) {
                          %>

                          <table id="TRbl_report_Jw_cod_barra_ambos"  class="reportTable"   style="width:99%; "  border="1" >
                            <%
                            java.lang.Integer codigo_marca1 = null;
                            java.lang.String descricao_marca1 = null;
                            java.lang.String linha_ref1 = null;
                            java.lang.String linha_ref_cab1 = null;
                            java.lang.Integer lin_cdgo = null;
                            java.lang.Integer ref_cdgo = null;
                            java.lang.String ref_desc = null;
                            java.lang.Integer cab_cdgo1 = null;
                            java.lang.String cabedal1 = null;
                            java.lang.Integer cor_cdgo1 = null;
                            java.lang.String cor1 = null;
                            java.lang.String numero = null;
                            java.lang.String numero_externo = null;
                            java.lang.String loja = null;
                            java.lang.String ean13 = null;
                            java.lang.Integer gde_cdgo = null;
                            java.lang.Integer qtd_pares = null;
                            java.lang.String cod_dun14 = null;
                            java.lang.String status1 = null;
                            java.lang.Double preco_unitario1 = null;
                            %>

                            <tr class="reportTr">
                              <td class="columnTdHeader" style="text-align:right;" >
                                Marca
                              </td>

                              <td class="columnTdHeader" style="text-align:left;" >
                                Descrição Marca
                              </td>

                              <td class="columnTdHeader" style="text-align:left;" >
                                <%
                                if(agruparModelo) {
                                  %>
                                  Lin/Ref/Cab
                                  <%
                                } else {
                                  %>
                                  Lin/Ref
                                  <%
                                }
                                %>
                              </td>

                              <td class="columnTdHeader" style="text-align:left;" >
                                Descrição Referência
                              </td>

                              <%
                              if(!agruparModelo) {
                                %>
                                <td class="columnTdHeader" style="text-align:right;" >
                                  Cabedal
                                </td>
                                <%
                              }
                              %>

                              <td class="columnTdHeader" style="text-align:left;" >
                                Descrição Cabedal
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" >
                                Cor
                              </td>

                              <td class="columnTdHeader" style="text-align:left;" >
                                Descrição Cor
                              </td>

                              <td class="columnTdHeader" style="text-align:left;" >
                                Número Int.
                              </td>

                              <%
                              if(exibeNumeroExterior){
                                %>
                                <td class="columnTdHeader" style="text-align:left;" >
                                  Número Ext.
                                </td>
                                <%
                              }
                              %>

                              <%
                              if(organizarPorLoja){
                                %>
                                <td class="columnTdHeader" style="text-align:left;" >
                                  Loja
                                </td>
                                <%
                              }
                              %>

                              <td class="columnTdHeader" style="text-align:left;" >
                                Ean13
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" >
                                Grade
                              </td>

                              <td class="columnTdHeader" style="text-align:right;" >
                                Qtd. Pares
                              </td>

                              <%
                              if(exibePrecos){
                                %>
                                <td class="columnTdHeader" style="text-align:right;" >
                                  Preço Unit.
                                </td>
                                <%
                              }
                              %>

                              <td class="columnTdHeader" style="text-align:left;" >
                                Dun14
                              </td>

                              <td class="columnTdHeader" style="text-align:center;" >
                                Status
                              </td>



                            </tr>

                            <%
                            int i_bl_report_Jw_cod_barra_ambos = 0;
                            while (i_bl_report_Jw_cod_barra_ambos<res_Jw_cod_barra_ambos.size()) {
                              portalbr.dbobj.view.Jw_cod_barra_ambos t_jw_cod_barra_ambos = (portalbr.dbobj.view.Jw_cod_barra_ambos)res_Jw_cod_barra_ambos.elementAt(i_bl_report_Jw_cod_barra_ambos);
                              codigo_marca1 = t_jw_cod_barra_ambos.getCodigo_marca();
                              descricao_marca1 = t_jw_cod_barra_ambos.getDescricao_marca()==null?"":t_jw_cod_barra_ambos.getDescricao_marca();
                              linha_ref1 = t_jw_cod_barra_ambos.getLinha_ref()==null?"":t_jw_cod_barra_ambos.getLinha_ref();
                              linha_ref_cab1 = t_jw_cod_barra_ambos.getLinha_ref()==null?"":(t_jw_cod_barra_ambos.getLinha_ref()+"."+t_jw_cod_barra_ambos.getCab_cdgo());
                              lin_cdgo = t_jw_cod_barra_ambos.getLin_cdgo();
                              preco_unitario1 = t_jw_cod_barra_ambos.getPreco_unitario();
                              ref_cdgo = t_jw_cod_barra_ambos.getRef_cdgo();
                              ref_desc = t_jw_cod_barra_ambos.getRef_desc()==null?"":t_jw_cod_barra_ambos.getRef_desc();
                              cab_cdgo1 = t_jw_cod_barra_ambos.getCab_cdgo();
                              cabedal1 = t_jw_cod_barra_ambos.getCabedal()==null?"":t_jw_cod_barra_ambos.getCabedal();
                              cor_cdgo1 = t_jw_cod_barra_ambos.getCor_cdgo();
                              cor1 = t_jw_cod_barra_ambos.getCor()==null?"":t_jw_cod_barra_ambos.getCor();
                              numero = t_jw_cod_barra_ambos.getNumero()==null?"":t_jw_cod_barra_ambos.getNumero();
                              numero_externo = t_jw_cod_barra_ambos.getNumero_externo()==null?"":t_jw_cod_barra_ambos.getNumero_externo();
                              loja = t_jw_cod_barra_ambos.getLoja()==null?"":t_jw_cod_barra_ambos.getLoja();
                              ean13 = t_jw_cod_barra_ambos.getEan13()==null?"":t_jw_cod_barra_ambos.getEan13();
                              gde_cdgo = t_jw_cod_barra_ambos.getGde_cdgo();
                              qtd_pares = t_jw_cod_barra_ambos.getQtd_pares();
                              cod_dun14 = t_jw_cod_barra_ambos.getCod_dun14()==null?"":t_jw_cod_barra_ambos.getCod_dun14();
                              status1 = t_jw_cod_barra_ambos.getStatus()==null?"":t_jw_cod_barra_ambos.getStatus();
                              String style_bl_report_Jw_cod_barra_ambos="";
                              if (!((i_bl_report_Jw_cod_barra_ambos%2)!=0)) {
                                style_bl_report_Jw_cod_barra_ambos="rowColor";
                              } else {
                                style_bl_report_Jw_cod_barra_ambos="rowBlank";
                              }
                              %>

                              <tr class='<%= style_bl_report_Jw_cod_barra_ambos %>' id="TRbl_report_Jw_cod_barra_ambos<%=i_bl_report_Jw_cod_barra_ambos%>" >
                                <td class="reportColumn" style="text-align:right;" >
                                  <%= ((codigo_marca1!=null)?codigo_marca1.toString():"") %>
                                </td>

                                <td class="reportColumn" style="text-align:left;" >
                                  <%= descricao_marca1 %>
                                </td>

                                <td class="reportColumn" style="text-align:left;" >
                                  <%
                                  if(agruparModelo) {
                                    %>
                                    <%= linha_ref_cab1 %>
                                    <%
                                  } else {
                                    %>
                                    <%
                                    if(!(request.getParameter("excel")+"").equals("true")){
                                      %>
                                      <%= linha_ref1 %>
                                      <%
                                    } else {
                                      %>
                                      <%= linha_ref1 %>
                                       
                                      <%
                                    }
                                    %>
                                    <%
                                  }
                                  %>
                                </td>

                                <td class="reportColumn" style="text-align:left;" >
                                  <%= ref_desc %>
                                </td>

                                <%
                                if(!agruparModelo) {
                                  %>
                                  <td class="reportColumn" style="text-align:right;" >
                                    <%= ((cab_cdgo1!=null)?cab_cdgo1.toString():"") %>
                                  </td>
                                  <%
                                }
                                %>

                                <td class="reportColumn" style="text-align:left;" >
                                  <%= cabedal1 %>
                                </td>

                                <td class="reportColumn" style="text-align:right;" >
                                  <%= ((cor_cdgo1!=null)?cor_cdgo1.toString():"") %>
                                </td>

                                <td class="reportColumn" style="text-align:left;" >
                                  <%= cor1 %>
                                </td>

                                <td class="reportColumn" style="text-align:left;" >
                                  <%= numero %>
                                </td>

                                <%
                                if(exibeNumeroExterior){
                                  %>
                                  <td class="reportColumn" style="text-align:left;" >
                                    <%= numero_externo %>
                                  </td>
                                  <%
                                }
                                %>

                                <%
                                if(organizarPorLoja){
                                  %>
                                  <td class="reportColumn" style="text-align:left;" >
                                    <%= loja %>
                                  </td>
                                  <%
                                }
                                %>

                                <td class="reportColumn" style="text-align:left;" >
                                  <%= ean13 %>
                                </td>

                                <td class="reportColumn" style="text-align:right;" >
                                  <%= ((gde_cdgo!=null)?gde_cdgo.toString():"") %>
                                </td>

                                <td class="reportColumn" style="text-align:right;" >
                                  <%= ((qtd_pares!=null)?qtd_pares.toString():"") %>
                                </td>

                                <%
                                if(exibePrecos){
                                  %>
                                  <td class="reportColumn" style="text-align:right;" >
                                    <%= com.egen.util.text.FormatNumber.format(preco_unitario1, "##,##0.00") %>
                                  </td>
                                  <%
                                }
                                %>

                                <td class="reportColumn" style="text-align:left;" >
                                  <%= cod_dun14 %>
                                </td>

                                <td class="reportColumn" style="text-align:center;" >
                                  <%= status1 %>
                                </td>


                              </tr>

                              <%
                              i_bl_report_Jw_cod_barra_ambos++;
                              if (i_bl_report_Jw_cod_barra_ambos<res_Jw_cod_barra_ambos.size()) {
                                t_jw_cod_barra_ambos = (portalbr.dbobj.view.Jw_cod_barra_ambos)res_Jw_cod_barra_ambos.elementAt(i_bl_report_Jw_cod_barra_ambos);
                                codigo_marca1 = t_jw_cod_barra_ambos.getCodigo_marca();
                                descricao_marca1 = t_jw_cod_barra_ambos.getDescricao_marca()==null?"":t_jw_cod_barra_ambos.getDescricao_marca();
                                linha_ref1 = t_jw_cod_barra_ambos.getLinha_ref()==null?"":t_jw_cod_barra_ambos.getLinha_ref();
                                linha_ref_cab1 = t_jw_cod_barra_ambos.getLinha_ref()==null?"":(t_jw_cod_barra_ambos.getLinha_ref()+"."+t_jw_cod_barra_ambos.getCab_cdgo());
                                lin_cdgo = t_jw_cod_barra_ambos.getLin_cdgo();
                                ref_cdgo = t_jw_cod_barra_ambos.getRef_cdgo();
                                ref_desc = t_jw_cod_barra_ambos.getRef_desc()==null?"":t_jw_cod_barra_ambos.getRef_desc();
                                cab_cdgo1 = t_jw_cod_barra_ambos.getCab_cdgo();
                                cabedal1 = t_jw_cod_barra_ambos.getCabedal()==null?"":t_jw_cod_barra_ambos.getCabedal();
                                cor_cdgo1 = t_jw_cod_barra_ambos.getCor_cdgo();
                                cor1 = t_jw_cod_barra_ambos.getCor()==null?"":t_jw_cod_barra_ambos.getCor();
                                numero = t_jw_cod_barra_ambos.getNumero()==null?"":t_jw_cod_barra_ambos.getNumero();
                                numero_externo = t_jw_cod_barra_ambos.getNumero_externo()==null?"":t_jw_cod_barra_ambos.getNumero_externo();
                                loja = t_jw_cod_barra_ambos.getLoja()==null?"":t_jw_cod_barra_ambos.getLoja();
                                ean13 = t_jw_cod_barra_ambos.getEan13()==null?"":t_jw_cod_barra_ambos.getEan13();
                                gde_cdgo = t_jw_cod_barra_ambos.getGde_cdgo();
                                preco_unitario1 = t_jw_cod_barra_ambos.getPreco_unitario();
                                qtd_pares = t_jw_cod_barra_ambos.getQtd_pares();
                                cod_dun14 = t_jw_cod_barra_ambos.getCod_dun14()==null?"":t_jw_cod_barra_ambos.getCod_dun14();
                                status1 = t_jw_cod_barra_ambos.getStatus()==null?"":t_jw_cod_barra_ambos.getStatus();
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

                    <html:form action="com/CodigoBarras_rForm.do" method="post" styleClass="baseForm">
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

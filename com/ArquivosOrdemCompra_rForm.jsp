<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Arquivos Ordem Compra
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(252)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ArquivosOrdemCompra_rGrid.do" method="post" styleClass="baseForm">
              <%
              acesso.Sessao sessao = new acesso.Sessao(session);
              %>
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="gridCheckField"/>
                    <html:errors property="forn_codigo"/>
                    <html:errors property="amostra"/>
                    <html:errors property="oco_numero"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="data_emissao"/>
                    <html:errors property="cond_pagto"/>
                    <html:errors property="arquivo_edi"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_ordem_compra"/>
                    <%
                    if(request.getAttribute("arquivo")!=null){
                      String arquivo = (String)request.getAttribute("arquivo");
                      %>






                      <table style=width:100%;margin-top:10;>
                        <tr>
                          <td class=columHeader style="text-align:center;">
                            <%
                            if(arquivo.indexOf(".zip")!=-1){
                              %>
                              <a href="<%= arquivo %>" target="_blank">
                                Clique para baixar o arquivo
                                <img src="../img/rar.gif" />
                              </a>
                              <%
                            } else {
                              %>
                              <a href="<%= arquivo %>" target="_blank" onclick="jQuery.post('ArquivosOrdemCompra_gForm.do?update_action=&tipo=l');">
                                <bean:message key="report.downloadpdf"/>
                              </a>
                              <%
                            }
                            %>
                          </td>
                        </tr>
                      </table>
                      <%
                    }
                    %>
                  </td>
                </tr>
              </table>
              <%
              java.util.Vector res_Jw_arquivos_ordem_compra = null;
              if(session.getAttribute("res_Jw_arquivos_ordem_compra")!=null){
                res_Jw_arquivos_ordem_compra = (java.util.Vector)session.getAttribute("res_Jw_arquivos_ordem_compra");
              }
              if(res_Jw_arquivos_ordem_compra != null && res_Jw_arquivos_ordem_compra.size()>0){
                %>

                <%
                if (((String)request.getParameter("_ordered"))!=null && ((String)request.getParameter("_ordered")).length()>0 ) {
                  boolean reverse = false;
                  if ( ((String)request.getParameter("_reverse"))!=null && ((String)request.getParameter("_reverse")).equals("true") ){
                    reverse = true;
                  }
                  try {
                    res_Jw_arquivos_ordem_compra = com.egen.util.text.Sort.execute(res_Jw_arquivos_ordem_compra ,((String)request.getParameter("_ordered")),reverse);
                  } catch (Exception e) {}
                }
                %>

                <%
                if(res_Jw_arquivos_ordem_compra != null && res_Jw_arquivos_ordem_compra.size()>10){
                  %>

                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:submit>
                        <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                          <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                        </html:submit>
                        <html:submit value="Marcar Todos" styleClass="baseButton" property="marcar_todos_action">
                        </html:submit>
                        <html:submit value="Desmarcar Todos" styleClass="baseButton" property="desmarcar_todos_action">
                        </html:submit>
                        <html:submit accesskey="u" styleClass="baseButton" property="update_action">
                          Gerar PDF - Grade
                        </html:submit>
                        <html:submit accesskey="a" styleClass="baseButton" property="update1_action">
                          Gerar PDF - Remessa
                        </html:submit>
                        <html:submit accesskey="a" styleClass="baseButton" property="update2_action">
                          Gerar Arquivo
                        </html:submit>
                        <html:submit accesskey="a" styleClass="baseButton" property="update3_action">
                          Salvar Alterações
                        </html:submit>
                        <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                          Voltar
                        </html:submit>
                      </td>
                    </tr>
                  </table>


                  <%
                }
                %>




                <table id="TRbl_report_Jw_consulta_titulos" class="reportTable" style=width:99%;  border=1  frame=box>
                  <tr class="reportHeader">
                    <td class="columnTdHeader">
                      <span class="spamFormLabel">
                      </span>
                    </td>

                    <td class="columnTdHeader" style="text-align: center">
                      Gerar OC
                    </td>

                    <td class="columnTdHeader" style="text-align: center">
                      <span class="spamFormLabel">
                        Ordem de Compra
                      </span>
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ArquivosOrdemCompra_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","oco_numero")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ArquivosOrdemCompra_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","oco_numero")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>



                    <td class="columnTdHeader" style="text-align: center">
                      <span class="spamFormLabel">
                        Amostra
                      </span>
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ArquivosOrdemCompra_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","amostra")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ArquivosOrdemCompra_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","amostra")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>



                    <td class="columnTdHeader" style="text-align: center">
                      <span class="spamFormLabel">
                        Filial
                      </span>
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ArquivosOrdemCompra_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","fil_filial")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ArquivosOrdemCompra_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","fil_filial")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>



                    <%
                    if(!sessao.isFornecedorAtelier()){
                      %>
                      <td>
                        Fornecedor
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='ArquivosOrdemCompra_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","forn_codigo")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='ArquivosOrdemCompra_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","forn_codigo")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>
                      <%
                    }
                    %>


                    <td class="columnTdHeader" style="text-align: center">
                      <span class="spamFormLabel">
                        Data Emissão
                      </span>
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ArquivosOrdemCompra_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","data_emissao")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ArquivosOrdemCompra_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","data_emissao")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                    <td class="columnTdHeader" style="text-align: center">
                      <span class="spamFormLabel">
                        Data Entrega
                      </span>

                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ArquivosOrdemCompra_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","data_entrega")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ArquivosOrdemCompra_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","data_entrega")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                    <td class="columnTdHeader" style="text-align: center">
                      <span class="spamFormLabel">
                        Data Entrega Forn.
                      </span>
                    </td>

                    <td class="columnTdHeader" style="text-align: center">
                      <span class="spamFormLabel">
                        Cond. Pagto.
                      </span>
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ArquivosOrdemCompra_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","cond_pagto")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ArquivosOrdemCompra_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","cond_pagto")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                    <td class="columnTdHeader" style="text-align: center;">
                      Situação
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ArquivosOrdemCompra_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","descricao_situacao")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ArquivosOrdemCompra_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","descricao_situacao")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>


                    <!--
                      <td class="columnTdHeader" style="text-align: center; width: 1%"> <span class="spamFormLabel"> Arquivo </span> <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ArquivosOrdemCompra_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","arquivo_edi")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ArquivosOrdemCompra_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","arquivo_edi")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %> </td>
                    -->

                    <td class="columnTdHeader" style="text-align: center; width: 1%">
                    </td>

                  </tr>

                  <%
                  String style="";
                  int contador = 0;
                  %>
                  <logic:iterate id="bl_form_Jw_arquivos_ordem_compra_lines" name="ArquivosOrdemCompra_rGridActionForm" property="bl_form_Jw_arquivos_ordem_compra_lines" indexId="indexId">
                    <%
                    Jw_arquivos_ordem_compra arquivosOrdemCompra = (Jw_arquivos_ordem_compra)res_Jw_arquivos_ordem_compra.elementAt(contador++);
                    if (!((contador%2)!=0)) {
                      style="rowColor";
                    } else {
                      style="rowBlank";
                    }
                    if(arquivosOrdemCompra.getSituacao().equalsIgnoreCase("G")){
                      style="rowYellow";
                    }
                    if(arquivosOrdemCompra.getSituacao().equalsIgnoreCase("V")){
                      style="rowGreen";
                    }
                    %>
                    <tr class=<%= style %> >
                      <td class="reportColumn" style="text-align: center">
                        <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_arquivos_ordem_compra_lines" indexed="true"/>
                      </td>

                      <td style="width: 150px; text-align: center">

                        <input style="width: 70px;" type="button" value="Grade" onclick="wopen('../com/ArquivosOrdemCompra_gForm.do?update_action=&oco_numero=<%= arquivosOrdemCompra.getOco_numero() %>&tipo=g&interface_arq_compra_id=<%= arquivosOrdemCompra.getInterface_arq_compra_id() %>','_blank',600,100)" />
                        <input style="width: 70px;" type="button" value="Remessa" onclick="wopen('../com/ArquivosOrdemCompra_gForm.do?update_action=&oco_numero=<%= arquivosOrdemCompra.getOco_numero() %>&tipo=r&interface_arq_compra_id=<%= arquivosOrdemCompra.getInterface_arq_compra_id() %>','_blank',600,100)" />

                      </td>

                      <html:hidden property="forn_codigo" styleId="forn_codigo" name="bl_form_Jw_arquivos_ordem_compra_lines" indexed="true"/>
                      <html:hidden property="interface_arq_compra_id" name="bl_form_Jw_arquivos_ordem_compra_lines" indexed="true" styleId="interface_arq_compra_id"/>
                      <html:hidden property="situacao_ordem_compra" styleId="situacao_ordem_compra" name="bl_form_Jw_arquivos_ordem_compra_lines" indexed="true"/>

                      <td class="reportColumn" style="text-align: center">
                        <html:hidden property="oco_numero" styleId="oco_numero" name="bl_form_Jw_arquivos_ordem_compra_lines" indexed="true"/>
                        <%= arquivosOrdemCompra.getOco_numero() %>
                      </td>

                      <td class="reportColumn" style="text-align: center">
                        <html:hidden property="amostra" styleId="oco_numero" name="bl_form_Jw_arquivos_ordem_compra_lines" indexed="true"/>
                        <%
                        if(arquivosOrdemCompra.getAmostra().equalsIgnoreCase("S")){
                          %>
                          <img src=../img/mark.gif>
                          <%
                        }
                        %>
                      </td>


                      <td class="reportColumn" style="text-align: center">
                        <html:hidden property="fil_filial" styleId="fil_filial" name="bl_form_Jw_arquivos_ordem_compra_lines" indexed="true"/>
                        <%= arquivosOrdemCompra.getFil_filial() %>
                      </td>

                      <%
                      if(!sessao.isFornecedorAtelier()){
                        %>
                        <td class="reportColumn" style="text-align: left">
                          <html:hidden property="forn_razsoc" styleId="fil_filial" name="bl_form_Jw_arquivos_ordem_compra_lines" indexed="true"/>
                          <%= arquivosOrdemCompra.getForn_codigo() %>
                          -
                          <%= arquivosOrdemCompra.getForn_razsoc() %>
                        </td>
                        <%
                      }
                      %>

                      <td class="reportColumn" style="text-align: center">
                        <html:hidden property="data_emissao" styleId="data_emissao" name="bl_form_Jw_arquivos_ordem_compra_lines" indexed="true"/>
                        <%= com.egen.util.text.FormatDate.format(arquivosOrdemCompra.getData_emissao(), "dd/MM/yyyy") %>
                      </td>

                      <td class="reportColumn" style="text-align: center">
                        <html:hidden property="data_entrega" styleId="data_emissao" name="bl_form_Jw_arquivos_ordem_compra_lines" indexed="true"/>
                        <%= com.egen.util.text.FormatDate.format(arquivosOrdemCompra.getData_entrega(), "dd/MM/yyyy") %>
                      </td>


                      <td class="reportColumn" style="text-align: center">

                        <html:hidden property="alterado" name="bl_form_Jw_arquivos_ordem_compra_lines" indexed="true" styleId="alterado"/>

                        <%
                        if(arquivosOrdemCompra.getAmostra().equalsIgnoreCase("S") && sessao.isFornecedorAtelier() && arquivosOrdemCompra.getSituacao_ordem_compra() == 0){
                          %>

                          <html:text property="data_entrega_fornecedor" onchange="setarAlterado(this.name, 0, event); " onkeypress="setarAlterado(this.name, 0, event);" styleId="data_entrega_fornecedor" styleClass="baseFieldData" size="11" maxlength="11" name="bl_form_Jw_arquivos_ordem_compra_lines" indexed="true"/>
                          <%
                          if(res_Jw_arquivos_ordem_compra.size()==1) {
                            %>
                            <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_entrega_fornecedor']); cal1.year_scroll = true; cal1.popup();">
                              <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                            </a>
                            <%
                          } else {
                            %>
                            <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_entrega_fornecedor'][<%= indexId %>]); cal1.year_scroll = true; cal1.popup();">
                              <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                            </a>
                            <%
                          }
                          %>
                          <%
                        } else {
                          %>
                          <html:hidden property="data_entrega_fornecedor" styleId="data_entrega_fornecedor" name="bl_form_Jw_arquivos_ordem_compra_lines" indexed="true"/>
                          <%= com.egen.util.text.FormatDate.format(arquivosOrdemCompra.getData_entrega_fornecedor(), "dd/MM/yyyy") %>
                          <%
                        }
                        %>

                      </td>



                      <td class="reportColumn" style="text-align: center">
                        <html:hidden property="cond_pagto" styleId="cond_pagto" name="bl_form_Jw_arquivos_ordem_compra_lines" indexed="true"/>
                        <%= arquivosOrdemCompra.getCond_pagto() %>
                      </td>

                      <td class="reportColumn" style="text-align: center">
                        <html:hidden property="descricao_situacao" styleId="descricao_situacao" name="bl_form_Jw_arquivos_ordem_compra_lines" indexed="true"/>
                        <%= arquivosOrdemCompra.getDescricao_situacao() %>
                        <img src="../img/viewmag.png" style="cursor:hand" onclick="wopen('../com/ArquivosOrdemCompra_lForm.do?select_action=&interface_arq_compra_id=<%= arquivosOrdemCompra.getInterface_arq_compra_id() %>&oco_numero=<%= arquivosOrdemCompra.getOco_numero() %>','_blank',640,300)">
                      </td>
                      <html:hidden property="arquivo_edi" styleId="arquivo_edi" name="bl_form_Jw_arquivos_ordem_compra_lines" indexed="true"/>

                      <td class="reportColumn" align="center">
                        <input type="button" value="Baixar arquivo" onclick="wopen('../com/ArquivosOrdemCompra_gForm.do?update_action=&forn_codigo=<%= arquivosOrdemCompra.getForn_codigo() %>&oco_numero=<%= arquivosOrdemCompra.getOco_numero() %>&tipo=a&interface_arq_compra_id=<%= arquivosOrdemCompra.getInterface_arq_compra_id() %>&arquivo=<%= arquivosOrdemCompra.getArquivo_edi() %>','_blank',600,100)" />
                      </td>

                    </tr>

                  </logic:iterate>

                </table>

                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                        <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:submit>
                      <html:submit value="Marcar Todos" styleClass="baseButton" property="marcar_todos_action">
                      </html:submit>
                      <html:submit value="Desmarcar Todos" styleClass="baseButton" property="desmarcar_todos_action">
                      </html:submit>
                      <html:submit accesskey="u" styleClass="baseButton" property="update_action">
                        Gerar PDF - Grade
                      </html:submit>
                      <html:submit accesskey="a" styleClass="baseButton" property="update1_action">
                        Gerar PDF - Remessa
                      </html:submit>
                      <html:submit accesskey="a" styleClass="baseButton" property="update2_action">
                        Gerar Arquivo
                      </html:submit>
                      <html:submit accesskey="a" styleClass="baseButton" property="update3_action">
                        Salvar Alterações
                      </html:submit>
                      <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                        Voltar
                      </html:submit>
                    </td>
                  </tr>
                </table>

                <%
              } else {
                %>


                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                        Voltar
                      </html:submit>
                    </td>
                  </tr>
                </table>



                <%
              }
              %>
              <script>
                jQuery(document).ready(function($) {
                  $(".baseFieldData").mask("99/99/9999");
                  });
                </script>

              </html:form>
            </td>
          </tr>
        </table>

      </body>
    </center>
  </html>

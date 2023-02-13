<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Arquivos Talão
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(253)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ArquivosTalao_rGrid.do" method="post" styleClass="baseForm">
              <%
              acesso.Sessao sessao = new acesso.Sessao(session);
              %>


              <table border=1 width="100%">
                <tr align="center" width="100%">

                  <td align="left">
                    <font color="" size=2>

                      <%
                      if(session.getAttribute("arquivos_talao_filtro_fornecedor")!=null){
                        %>
                        <font color="">
                          <b>
                            Fornecedor:
                          </b>
                        </font>
                        <font color="#C40000" size=1>
                          <b>
                            <%= (String) session.getAttribute("arquivos_talao_filtro_fornecedor") %>
                          </b>
                        </font>
                        <%
                      }
                      %>

                      <%
                      if(session.getAttribute("arquivos_talao_filtro_filial")!=null){
                        %>
                        <font color="">
                          <br>
                          <b>
                            Filial:
                          </b>
                        </font>
                        <font color="#C40000" size=1>
                          <b>
                            <%= (String)session.getAttribute("arquivos_talao_filtro_filial") %>
                          </b>
                        </font>
                        <%
                      }
                      %>

                      <%
                      if(session.getAttribute("arquivos_talao_filtro_situacao")!=null){
                        %>
                        <font color="">
                          <br>
                          <b>
                            Situação:
                          </b>
                        </font>
                        <font color="#C40000" size=1>
                          <b>
                            <%= (String)session.getAttribute("arquivos_talao_filtro_situacao") %>
                          </b>
                        </font>
                        <%
                      }
                      %>

                      <%
                      if(session.getAttribute("arquivos_talao_filtro_ordem_compra")!=null){
                        %>
                        <font color="">
                          <br>
                          <b>
                            Ordem de Compra:
                          </b>
                        </font>
                        <font color="#C40000" size=1>
                          <b>
                            <%= (String)session.getAttribute("arquivos_talao_filtro_ordem_compra") %>
                          </b>
                        </font>
                        <%
                      }
                      %>

                      <%
                      if(session.getAttribute("arquivos_talao_filtro_remessa")!=null){
                        %>
                        <font color="">
                          <br>
                          <b>
                            Remessa:
                          </b>
                        </font>
                        <font color="#C40000" size=1>
                          <b>
                            <%= (String)session.getAttribute("arquivos_talao_filtro_remessa") %>
                          </b>
                        </font>
                        <%
                      }
                      %>

                      <%
                      if(session.getAttribute("arquivos_talao_filtro_datas")!=null){
                        %>
                        <font color="">
                          <br>
                          <b>
                            Período:
                          </b>
                        </font>
                        <font color="#C40000" size=1>
                          <b>
                            <%= (String)session.getAttribute("arquivos_talao_filtro_datas") %>
                          </b>
                        </font>
                        <%
                      }
                      %>

                      <%
                      if(session.getAttribute("arquivos_talao_filtro_materiais")!=null){
                        %>
                        <font color="">
                          <br>
                          <b>
                            Peças:
                          </b>
                        </font>
                        <font color="#C40000" size=1>
                          <b>
                            <%= (String)session.getAttribute("arquivos_talao_filtro_materiais") %>
                          </b>
                        </font>
                        <%
                      }
                      %>

                      <%
                      if(session.getAttribute("arquivos_talao_filtro_espacamento")!=null){
                        %>
                        <font color="">
                          <br>
                          <b>
                            Espaçamento:
                          </b>
                        </font>
                        <font color="#C40000" size=1>
                          <b>
                            <%= (String)session.getAttribute("arquivos_talao_filtro_espacamento") %>
                            milímetros
                          </b>
                        </font>
                        <%
                      }
                      %>

                    </td>
                  </tr>
                </table>


                <table class="messageTable" style='width:99%;'>
                  <tr class="messageTr" >
                    <td class="messageTd">
                      <html:errors property="gridCheckField"/>
                      <html:errors property="forn_codigo"/>
                      <html:errors property="oco_numero"/>
                      <html:errors property="rem_nro"/>
                      <html:errors property="fil_filial"/>
                      <html:errors property="arquivo_edi"/>
                      <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_talao"/>

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
                                <a href="<%= arquivo %>" target="_blank" onclick="jQuery.post('ArquivosTalao_gForm.do?update_action=&tipo=l');">
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
                java.util.Vector res_Jw_arquivos_talao = null;
                if(session.getAttribute("res_Jw_arquivos_talao")!=null){
                  res_Jw_arquivos_talao = (java.util.Vector)session.getAttribute("res_Jw_arquivos_talao");
                }
                if(res_Jw_arquivos_talao != null && res_Jw_arquivos_talao.size()>0){
                  %>



                  <%
                  if(res_Jw_arquivos_talao != null && res_Jw_arquivos_talao.size()>10){
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
                            Gerar PDF
                          </html:submit>
                          <html:submit accesskey="u" styleClass="baseButton" property="update1_action">
                            Gerar Arquivos
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




                  <%
                  if (((String)request.getParameter("_ordered"))!=null && ((String)request.getParameter("_ordered")).length()>0 ) {
                    boolean reverse = false;
                    if ( ((String)request.getParameter("_reverse"))!=null && ((String)request.getParameter("_reverse")).equals("true") ){
                      reverse = true;
                    }
                    try {
                      res_Jw_arquivos_talao = com.egen.util.text.Sort.execute(res_Jw_arquivos_talao ,((String)request.getParameter("_ordered")),reverse);
                    } catch (Exception e) {}
                  }
                  %>

                  <table id="TRbl_report_Jw_consulta_titulos" class="reportTable" style=width:99%;  border=1  frame=box>
                    <tr class="reportHeader">
                      <td class="columnTdHeader">
                        <span class="spamFormLabel">
                        </span>
                      </td>

                      <td class="columnTdHeader" style="text-align: center">
                        Gerar Talão
                      </td>

                      <td class="columnTdHeader" style="text-align: center">
                        <span class="spamFormLabel">
                          Ordem de Compra
                        </span>
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='ArquivosTalao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","oco_numero")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='ArquivosTalao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","oco_numero")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align: center">
                        <span class="spamFormLabel">
                          Data Compra
                        </span>
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='ArquivosTalao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","data_compra")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='ArquivosTalao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","data_compra")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>


                      <td class="columnTdHeader" style="text-align: center">
                        <span class="spamFormLabel">
                          Remessa
                        </span>
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='ArquivosTalao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","rem_nro")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='ArquivosTalao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","rem_nro")%>' class="reportOrder">
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
                          <a href='ArquivosTalao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","fil_filial")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='ArquivosTalao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","fil_filial")%>' class="reportOrder">
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
                            <a href='ArquivosTalao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","forn_codigo")%>' class="reportOrder">
                              <bean:message key="report.orderedasc"/>
                            </a>
                            <%
                          } else {
                            %>
                            <a href='ArquivosTalao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","forn_codigo")%>' class="reportOrder">
                              <bean:message key="report.ordereddesc"/>
                            </a>
                            <%
                          }
                          %>
                        </td>
                        <%
                      }
                      %>


                      <td class="columnTdHeader" style="text-align: center;">
                        Situação
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='ArquivosTalao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","descricao_situacao")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='ArquivosTalao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","descricao_situacao")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <!--
                        <td class="columnTdHeader" style="text-align: center; width: 1%"> <span class="spamFormLabel"> Arquivo </span> <% if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){ %> <a href='ArquivosTalao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","arquivo_edi")%>' class="reportOrder"> <bean:message key="report.orderedasc"/> </a> <% } else { %> <a href='ArquivosTalao_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","arquivo_edi")%>' class="reportOrder"> <bean:message key="report.ordereddesc"/> </a> <% } %> </td>
                      -->

                      <td class="columnTdHeader" style="text-align: center; width: 1%">
                      </td>

                    </tr>

                    <%
                    String style="";
                    int contador = 0;
                    %>
                    <logic:iterate id="bl_form_Jw_arquivos_talao_lines" name="ArquivosTalao_rGridActionForm" property="bl_form_Jw_arquivos_talao_lines" indexId="indexId">
                      <%
                      Jw_arquivos_talao arquivosTalao = (Jw_arquivos_talao)res_Jw_arquivos_talao.elementAt(contador++);
                      if (!((contador%2)!=0)) {
                        style="rowColor";
                      } else {
                        style="rowBlank";
                      }
                      if(arquivosTalao.getSituacao().equalsIgnoreCase("G")){
                        style="rowYellow";
                      }
                      if(arquivosTalao.getSituacao().equalsIgnoreCase("V")){
                        style="rowGreen";
                      }
                      %>
                      <tr class=<%= style %> >
                        <td class="reportColumn" style="text-align: center">
                          <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_arquivos_talao_lines" indexed="true"/>
                        </td>

                        <td style="width: 80px; text-align: center">
                          <input style="width: 70px;" type="button" value="Gerar" onclick="wopen('../com/ArquivosTalao_gForm.do?update_action=&oco_numero=<%= arquivosTalao.getOco_numero() %>&rem_nro=<%= arquivosTalao.getRem_nro() %>&tipo=r&interface_arq_compra_id=<%= arquivosTalao.getInterface_arq_compra_id() %>','_blank',600,100)" />

                        </td>

                        <html:hidden property="forn_codigo" styleId="forn_codigo" name="bl_form_Jw_arquivos_talao_lines" indexed="true"/>
                        <html:hidden property="interface_arq_compra_id" name="bl_form_Jw_arquivos_talao_lines" indexed="true" styleId="interface_arq_compra_id"/>

                        <td class="reportColumn" style="text-align: center">
                          <html:hidden property="oco_numero" styleId="oco_numero" name="bl_form_Jw_arquivos_talao_lines" indexed="true"/>
                          <%= arquivosTalao.getOco_numero() %>
                        </td>

                        <td class="reportColumn" style="text-align: center">
                          <html:hidden property="data_compra" styleId="data_compra" name="bl_form_Jw_arquivos_talao_lines" indexed="true"/>
                          <%= com.egen.util.text.FormatDate.format(arquivosTalao.getData_compra(), "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align: center">
                          <html:hidden property="rem_nro" styleId="rem_nro" name="bl_form_Jw_arquivos_talao_lines" indexed="true"/>
                          <%= arquivosTalao.getRem_nro() %>
                        </td>

                        <td class="reportColumn" style="text-align: center">
                          <html:hidden property="fil_filial" styleId="fil_filial" name="bl_form_Jw_arquivos_talao_lines" indexed="true"/>
                          <%= arquivosTalao.getFil_filial() %>
                        </td>

                        <%
                        if(!sessao.isFornecedorAtelier()){
                          %>
                          <td class="reportColumn" style="text-align: left">
                            <html:hidden property="forn_razsoc" styleId="fil_filial" name="bl_form_Jw_arquivos_talao_lines" indexed="true"/>
                            <%= arquivosTalao.getForn_codigo() %>
                            -
                            <%= arquivosTalao.getForn_razsoc() %>
                          </td>
                          <%
                        }
                        %>


                        <td class="reportColumn" style="text-align: center">
                          <html:hidden property="descricao_situacao" styleId="descricao_situacao" name="bl_form_Jw_arquivos_talao_lines" indexed="true"/>
                          <%= arquivosTalao.getDescricao_situacao() %>
                          <img src="../img/viewmag.png" style="cursor:hand" onclick="wopen('../com/ArquivosTalao_lForm.do?select_action=&interface_arq_compra_id=<%= arquivosTalao.getInterface_arq_compra_id() %>&rem_nro=<%= arquivosTalao.getRem_nro() %>&oco_numero=<%= arquivosTalao.getOco_numero() %>','_blank',640,300)">
                        </td>


                        <!--
                          <td class="reportColumn" style="text-align: left"> <html:hidden property="arquivo_edi" styleId="arquivo_edi" name="bl_form_Jw_arquivos_talao_lines" indexed="true"/> <%= arquivosTalao.getArquivo_edi() %> </td>
                        -->

                        <td class="reportColumn" align="center">
                          <input type="button" value="Baixar arquivo" onclick="wopen('../com/ArquivosTalao_gForm.do?update_action=&oco_numero=<%= arquivosTalao.getOco_numero() %>&forn_codigo=<%= arquivosTalao.getForn_codigo() %>&tipo=a&interface_arq_compra_id=<%= arquivosTalao.getInterface_arq_compra_id() %>&arquivo=<%= arquivosTalao.getArquivo_edi() %>','_blank',600,100)" />
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
                          Gerar PDF
                        </html:submit>
                        <html:submit accesskey="u" styleClass="baseButton" property="update1_action">
                          Gerar Arquivos
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

              </html:form>
            </td>
          </tr>
        </table>

      </body>
    </center>
  </html>

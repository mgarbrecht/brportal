<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Download de Imagens
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(208)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            if(request.getAttribute("arquivo")!=null){
              %>
              <table style=width:100%;margin-top:10;>
                <tr>
                  <td class=columHeader style="text-align:center;">
                    <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                      Clique para baixar o arquivo
                      <img src="../img/rar.gif" />
                    </a>
                  </td>
                </tr>
              </table>
              <%
            }
            %>

            <%
            if(session.getAttribute("lista_imagens_inexistentes")!=null) {
              %>

              <script>
                wopen('../com/DownloadImagens_iForm.jsp','_blank',1000,500);
              </script>
              <%
            }
            %>

            <%
            String tamanhoImagens = null;
            if(session.getAttribute("download_imagens_tamanho_imagem")!= null) {
              tamanhoImagens = (String)session.getAttribute("download_imagens_tamanho_imagem");
            }
            boolean desabilita = false;
            java.util.List<String> listaImagens = new java.util.ArrayList<String>();
            if(session.getAttribute("listaImagens")!=null){
              listaImagens = (java.util.List<String>)session.getAttribute("listaImagens");
            }

            java.util.Vector res_Jw_cat_produtos = null;
            if(session.getAttribute("res_Jw_cat_produtos")!=null){
              res_Jw_cat_produtos = (java.util.Vector)session.getAttribute("res_Jw_cat_produtos");
            }
            String labelBotao = "Baixar " + listaImagens.size() + " Imagens Selecionadas";
            %>

            <html:form action="com/DownloadImagens_rGrid.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="gridCheckField"/>
                    <html:errors property="marca"/>
                    <html:errors property="linha"/>
                    <html:errors property="referencia"/>
                    <html:errors property="cabedal"/>
                    <html:errors property="cor"/>
                    <html:errors property="imagem"/>
                    <html:errors property="venda_exportacao"/>
                    <html:errors property="categoria_produto"/>
                    <html:errors property="descricao_categoria_produto"/>
                    <html:errors property="tipo"/>
                    <html:errors property="descricao_tipo"/>
                    <html:errors property="descricao_produto"/>
                    <html:errors property="sequencial_angulo"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_cat_produtos"/>
                  </td>
                </tr>
              </table>

              <%
              if(res_Jw_cat_produtos!=null && res_Jw_cat_produtos.size()>0){
                %>

                <table id="TRbl_report_Jw_consulta_titulos" class="reportTable" style=width:99%;  border=1  frame=box>
                  <tr class="reportHeader" >

                    <td class="columnTdHeader" style="text-align:center; " width:50px;>
                    </td>

                    <td class="columnTdHeader" style="text-align:right;">
                      Linha
                    </td>

                    <td class="columnTdHeader" style="text-align:right;">
                      Referência
                    </td>

                    <%
                    if(!tamanhoImagens.equals("N")) {
                      %>

                      <td class="columnTdHeader" style="text-align:right;">
                        Cabedal
                      </td>

                      <td class="columnTdHeader" style="text-align:left;">
                        Descrição Cabedal
                      </td>

                      <td class="columnTdHeader" style="text-align:right;">
                        Cor
                      </td>

                      <td class="columnTdHeader" style="text-align:left;">
                        Descrição Cor
                      </td>
                      <%
                    }
                    %>

                    <%
                    if(tamanhoImagens.equals("N")) {
                      %>
                      <td class="columnTdHeader" style="text-align:center;">
                        Ângulo
                      </td>
                      <%
                    }
                    %>

                    <td class="columnTdHeader" style="text-align:right;width:1%;">
                      Imagem
                    </td>

                    <td class="columnTdHeader" style="text-align:right;width:1%;">
                      Selecionado
                    </td>

                  </tr>


                  <%
                  String style="";
                  int contador = 0;
                  %>

                  <logic:iterate id="bl_form_Jw_cat_produtos_lines" name="DownloadImagens_rGridActionForm" property="bl_form_Jw_cat_produtos_lines" indexId="indexId">
                    <%
                    Jw_cat_produtos catProdutos = (Jw_cat_produtos)res_Jw_cat_produtos.elementAt(contador);
                    if(catProdutos.getImagem().equals("default.gif")){
                      desabilita = true;
                    } else {
                      desabilita = false;
                    }
                    if(listaImagens.contains(catProdutos.getImagem())){
                      if (!((contador%2)!=0)) {
                        style="rowGreenBlank";
                      } else {
                        style="rowGreenBlank";
                      }
                    } else {
                      if (!((contador%2)!=0)) {
                        style="rowColor";
                      } else {
                        style="rowBlank";
                      }
                    }
                    %>

                    <tr class=<%= style %> >
                      <td class="reportColumn" style="text-align:center; width: 50px; ">
                        <html:checkbox property="gridCheckField" styleId="gridCheckField" disabled="<%= desabilita %>" styleClass="baseField" value="true" name="bl_form_Jw_cat_produtos_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn">
                        <html:hidden property="linha" styleId="linha" name="bl_form_Jw_cat_produtos_lines" indexed="true"/>
                        <%= catProdutos.getLinha() %>
                      </td>

                      <td class="reportColumn">
                        <html:hidden property="referencia" styleId="referencia" name="bl_form_Jw_cat_produtos_lines" indexed="true"/>
                        <%= catProdutos.getReferencia() %>
                      </td>


                      <%
                      if(!tamanhoImagens.equals("N")) {
                        %>

                        <td class="reportColumn">
                          <html:hidden property="cabedal" styleId="cabedal" name="bl_form_Jw_cat_produtos_lines" indexed="true"/>
                          <%= catProdutos.getCabedal() %>
                        </td>

                        <td class="reportColumn" style="text-align: left">
                          <%= catProdutos.getDescricao_cabedal() %>
                        </td>

                        <td class="reportColumn">
                          <html:hidden property="cor" styleId="cor" name="bl_form_Jw_cat_produtos_lines" indexed="true"/>
                          <%= catProdutos.getCor() %>
                        </td>

                        <td class="reportColumn" style="text-align: left">
                          <%= catProdutos.getDescricao_cor() %>
                        </td>

                        <%
                      }
                      %>

                      <%
                      if(tamanhoImagens.equals("N")) {
                        %>
                        <td class="reportColumn" style="text-align: center">
                          <%= catProdutos.getSequencial_angulo() %>
                        </td>
                        <%
                      }
                      %>
                      <td class="reportColumn">
                        <html:hidden property="imagem" styleId="imagem" name="bl_form_Jw_cat_produtos_lines" indexed="true"/>
                        <%
                        if(tamanhoImagens.equals("N")) {
                          %>
                          <img src="https://s3-sa-east-1.amazonaws.com/imagens.catalogobeirario.com.br/angulos_produtos/<%= catProdutos.getImagem() %>" width="120" height="82" />
                          <%
                        } else {
                          %>
                          <img src="http://brportal.beirario.com.br/brportal/imagens/pequenas/<%= catProdutos.getImagem() %>" width="120" height="82" />
                          <%
                        }
                        %>
                      </td>

                      <td class="reportColumn" style="text-align:center">
                        <%
                        if(listaImagens.contains(catProdutos.getImagem())){
                          %>
                          <img src="../img/checks.gif" />
                          <%
                        }
                        %>
                      </td>

                      <html:hidden property="marca" styleId="marca" name="bl_form_Jw_cat_produtos_lines" indexed="true"/>
                      <html:hidden property="venda_exportacao" styleId="venda_exportacao" name="bl_form_Jw_cat_produtos_lines" indexed="true"/>
                      <html:hidden property="categoria_produto" styleId="categoria_produto" name="bl_form_Jw_cat_produtos_lines" indexed="true"/>
                      <html:hidden property="descricao_categoria_produto" styleId="descricao_categoria_produto" name="bl_form_Jw_cat_produtos_lines" indexed="true"/>
                      <html:hidden property="tipo" styleId="tipo" name="bl_form_Jw_cat_produtos_lines" indexed="true"/>
                      <html:hidden property="descricao_tipo" styleId="descricao_tipo" name="bl_form_Jw_cat_produtos_lines" indexed="true"/>
                      <html:hidden property="descricao_produto" styleId="descricao_produto" name="bl_form_Jw_cat_produtos_lines" indexed="true"/>
                      <html:hidden property="descricao_cabedal" styleId="descricao_cabedal" name="bl_form_Jw_cat_produtos_lines" indexed="true"/>
                      <html:hidden property="descricao_cor" styleId="descricao_cor" name="bl_form_Jw_cat_produtos_lines" indexed="true"/>

                    </tr>

                    <%
                    contador ++;
                    %>
                  </logic:iterate>

                </table>

                <%
              }
              %>


              <table class="buttonTable" style='width:99%;'>

                <%
                if(res_Jw_cat_produtos!=null && res_Jw_cat_produtos.size()>0){
                  %>

                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit value="Marcar Todas" styleClass="baseButton" property="marcar_todos_action">
                      </html:submit>
                      <html:submit value="Desmarcar Todas" styleClass="baseButton" property="desmarcar_todos_action">
                      </html:submit>
                    </td>
                  </tr>


                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:submit accesskey="a" styleClass="baseButton" property="update_action">
                        Selecionar Imagens Marcadas
                      </html:submit>
                      <html:submit accesskey="a" styleClass="baseButton" property="update1_action">
                        Remover Imagens Marcadas
                      </html:submit>
                      <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                        <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:submit>
                      <html:submit accesskey="l" styleClass="myhidden" property="download_alta_action">
                        <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:submit>
                    </td>
                  </tr>


                  <%
                  if (listaImagens!=null && listaImagens.size()>0){
                    %>

                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:submit accesskey="a" styleClass="baseButton" property="download_action">
                          <%
                          if(listaImagens.size()==1){
                            %>
                            Baixar Imagem Selecionada
                            <%
                          } else {
                            %>
                            <%= labelBotao %>
                            <%
                          }
                          %>
                        </html:submit>
                        <input type="button" value="Enviar por email" styleClass="baseButton" onclick="wopen('../com/DownloadImagens_eForm.jsp','_blank',800,80)" />
                        <html:submit accesskey="a" styleClass="baseButton" property="remover_action">
                          Remover Imagens Selecionadas
                        </html:submit>
                        <%
                      }
                      %>

                    </td>
                  </tr>

                  <%
                }
                %>


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

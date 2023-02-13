<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Solicitação de Combinações Especiais
    </title>
    <style>
      .imgprodp {
        color: white;
        border: none;
        width: 50px;
        height: 30px;
      }
      .imgprodg {
        color: white;
        border: none;
        width: 500px;
        height: 300px;
      }
  
      .dropdown {
        position: relative;
        display: inline-block;
      }
    
      .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f1f1f1;
        width: 500px;
        height: 300px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
        transition:1;
      }
    
      .dropdown-content a {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
      }
    
      .dropdown-content a:hover {background-color: #ddd;}
    
      .dropdown:hover .dropdown-content {display: inline-block;}
    
    .dropdown:hover .imgprod {background-color: #3e8e41;}
    </style>
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(203)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/SolicitacaoCombinacaoEspecial_rGrid.do" method="post" styleClass="baseForm">

              <%
              java.util.Vector res_Jw_ref_combinacao_especial = (java.util.Vector)session.getAttribute("res_Jw_ref_combinacao_especial");
              %>

              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="gridCheckField"/>
                    <html:errors property="id_solicitacao"/>
                    <html:errors property="imagem"/>
                    <html:errors property="data_solicitacao"/>
                    <html:errors property="nome_marca"/>
                    <html:errors property="regional"/>
                    <html:errors property="material"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="cab_cdgo"/>
                    <html:errors property="cor_cdgo"/>
                    <html:errors property="cliente_grupo_economico"/>
                    <html:errors property="pares_alteracao"/>
                    <html:errors property="pares_vendidos"/>
                    <html:errors property="situacao_solicitacao_desc"/>
                    <html:errors property="data_aprovacao"/>
                    <html:errors property="preco_liguido"/>
                    <html:errors property="ll_alteracao_solicitada"/>
                    <html:errors property="desc_solicitacao_comb_especial"/>
                    <html:errors property="desc_subtipo_comb_espec"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_ref_combinacao_especial"/>
                  </td>
                </tr>
              </table>

              <%
/*
              if ( ((String)request.getParameter("_ordered"))!=null && ((String)request.getParameter("_ordered")).length()>0 ) {
                boolean reverse = false;
                if ( ((String)request.getParameter("_reverse"))!=null && ((String)request.getParameter("_reverse")).equals("true") ){
                  reverse = true;
                }
                try {
                  res_Jw_ref_combinacao_especial = com.egen.util.text.Sort.execute(res_Jw_ref_combinacao_especial,((String)request.getParameter("_ordered")),reverse);
                  session.setAttribute("res_Jw_ref_combinacao_especial", res_Jw_ref_combinacao_especial);
                } catch (Exception e) {}
              }
*/
              %>


              <table class="reportTable"   style="width:99%; "  border="1">
                <tr class="reportTr">
                  <td class="reportTr">
                    <span class="spamFormLabel">
                    </span>
                  </td>

                  <td class="reportTr" style="text-align:center;">
                    <span class="spamFormLabel">
                      Imagem
                    </span>
                  </td>

                  <td class="reportTr" style="text-align:center;">
                    <%
                    if(!(request.getParameter("excel")+"").equals("true")){
                      %>
                      ID
                      <%
  /*
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='SolicitacaoCombinacaoEspecial_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","id_solicitacao")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='SolicitacaoCombinacaoEspecial_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","id_solicitacao")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
*/
                      %>
                      <%
                    } else {
                      %>
                      ID
                      <%
                    }
                    %>
                  </td>

                  <td class="reportTr" style="text-align:center;">
                    <%
                    if(!(request.getParameter("excel")+"").equals("true")){
                      %>
                      Data
                      <%
/*
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='SolicitacaoCombinacaoEspecial_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","data_solicitacao")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='SolicitacaoCombinacaoEspecial_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","data_solicitacao")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }*/
                      %>
                      <%
                    } else {
                      %>
                      Data
                      <%
                    }
                    %>
                  </td>


                  <td class="reportTr" style="text-align:center;">
                    <span class="spamFormLabel">
                      Data Mov. Situação
                    </span>
                  </td>

                  <td class="reportTr" style="text-align:center;">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                  </td>

                  <td class="reportTr" style="text-align:center;">
                    <span class="spamFormLabel">
                      Regional
                    </span>
                  </td>

                  <td class="reportTr" style="text-align:center;">
                    <span class="spamFormLabel" style="text-align:center;">
                      Material
                    </span>
                  </td>

                  <td class="reportTr" style="text-align:center;">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>

                  <td class="reportTr" style="text-align:center;">
                    <span class="spamFormLabel">
                      Ref.
                    </span>
                  </td>

                  <td class="reportTr" style="text-align:center;">
                    <span class="spamFormLabel">
                      Cabedal
                    </span>
                  </td>

                  <td class="reportTr" style="text-align:center;">
                    <span class="spamFormLabel">
                      Cor
                    </span>
                  </td>

                  <td class="reportTr" style="text-align:left; width:350px;">
                    <span class="spamFormLabel">
                      Cliente / Grupo Econômico
                    </span>
                  </td>

                  <td class="reportTr" style="text-align:right;">
                    <span class="spamFormLabel">
                      Pares Solicitados
                    </span>
                  </td>

                  <td class="reportTr" style="text-align:right;">
                    <span class="spamFormLabel">
                      Pares Vendidos
                    </span>
                  </td>

                  <td class="reportTr" style="text-align:center;">
                    <span class="spamFormLabel">
                      Situação
                    </span>
                  </td>

                  <td class="reportTr" style="text-align:center;">
                    <span class="spamFormLabel">
                      Data de Aprovação
                    </span>
                  </td>

                  <td class="reportTr" style="text-align:right;">
                    <span class="spamFormLabel">
                      Preço Liquido
                    </span>
                  </td>

                  <td class="reportTr" style="text-align:center;">
                    <span class="spamFormLabel">
                      LL
                    </span>
                  </td>

                  <td class="reportTr" style="text-align:center;">
                    <span class="spamFormLabel">
                      Tipo da Solicitação
                    </span>
                  </td>

                  <td class="reportTr" style="text-align:center;">
                    <span class="spamFormLabel">
                      Subtipo
                    </span>
                  </td>

                </tr>

                <%
                String style = "";
                int sum_pares_alteracao = 0;
                int i_bl_report_Jw_ref_combinacao_especial_lista = 0;
                %>

                <logic:iterate id="bl_form_Jw_ref_combinacao_especial_lines" name="SolicitacaoCombinacaoEspecial_rGridActionForm" property="bl_form_Jw_ref_combinacao_especial_lines" indexId="indexId">

                  <%
                  Jw_ref_combinacao_especial lista = (Jw_ref_combinacao_especial) res_Jw_ref_combinacao_especial.elementAt(i_bl_report_Jw_ref_combinacao_especial_lista);

                  if ((i_bl_report_Jw_ref_combinacao_especial_lista%2) == 0){
                    style = "rowColor";
                  }
                  else{
                    style = "rowBlank";
                  }
                  %>

                  <tr class=<%= style %> >

                    <td class="reportColumn" style="text-align:center;">
                      <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                    </td>

                    <td class="reportColumn" style="text-align:center;">
                      <div class="center">
                        <html:hidden property="imagem" styleId="imagem" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </div>
                      <div class="dropdown">
                        <img src=<%= "http://brportal.beirario.com.br/brportal/arquivos/solicitacao_especial/" + ((lista.getImagem() != null)?lista.getImagem().replace(" ", "%20"):"sol_comb_r_default_prod.jpg") %> class="imgprodp" >
                        <div class="dropdown-content">
                          <img src=<%= "http://brportal.beirario.com.br/brportal/arquivos/solicitacao_especial/" + ((lista.getImagem() != null)?lista.getImagem().replace(" ", "%20"):"sol_comb_r_default_prod.jpg") %> class="imgprodg">
                        </div>
                      </div>
                    </td>

                    <td class="reportColumn" style="text-align:center;">
                      <a href="../com/SolicitacaoCombinacaoEspecial_aForm.do?select_action=&id_solicitacao=<%= lista.getId_solicitacao() %>&tipo_solicitacao=<%= lista.getTipo_solicitacao_comb_especial() %>" style="cursor:hand" onclick="bloqueia();">
                        <%= lista.getId_solicitacao() %>
                        <html:hidden property="id_solicitacao" styleId="id_solicitacao" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align:center;">
                        <%= com.egen.util.text.FormatDate.format(lista.getData_solicitacao(), "dd/MM/yyyy HH:mm:ss") %>
                        <html:hidden property="data_solicitacao" styleId="data_solicitacao" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align:center;">
                        <%= com.egen.util.text.FormatDate.format(lista.getData_manipulacao(), "dd/MM/yyyy HH:mm:ss") %>
                        <html:hidden property="data_manipulacao" styleId="data_manipulacao" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align:center;">
                        <%= ((lista.getNome_marca() != null)?lista.getNome_marca():"") %>
                        <html:hidden property="nome_marca" styleId="nome_marca" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align:center;">
                        <%= ((lista.getRegional() != null)?lista.getRegional():"") %>
                        <html:hidden property="regional" styleId="regional" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align:center;">
                        <%
                        String materialDesc = "";
                        %>
                        <%
                        if(lista.getMaterial()!=null && lista.getMaterial().equalsIgnoreCase("M")){
                          materialDesc = "Mix";
                        }
                        if(lista.getMaterial()!=null && lista.getMaterial().equalsIgnoreCase("D")){
                          materialDesc = "Desenvolvimento";
                        }
                        %>

                        <%= materialDesc %>
                        <html:hidden property="material" styleId="material" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align:center;">
                        <%= lista.getLin_cdgo() %>
                        <html:hidden property="lin_cdgo" styleId="lin_cdgo" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align:center;">
                        <%= ((lista.getRef_cdgo()!=null)?lista.getRef_cdgo():"") %>
                        <html:hidden property="ref_cdgo" styleId="ref_cdgo" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align:center;">
                        <%= ((lista.getCab_cdgo()!=null)?lista.getCab_cdgo():"") %>
                        <html:hidden property="cab_cdgo" styleId="cab_cdgo" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align:center;">
                        <%= ((lista.getCor_cdgo()!=null)?lista.getCor_cdgo():"") %>
                        <html:hidden property="cor_cdgo" styleId="cor_cdgo" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align:left; width:350px;">
                        <%= lista.getCliente_grupo_economico() %>
                        <html:hidden property="cliente_grupo_economico" styleId="cliente_grupo_economico" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align:right;">
                        <%= ((lista.getPares_alteracao()!=null)?lista.getPares_alteracao():"") %>
                        <html:hidden property="pares_alteracao" styleId="pares_alteracao" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align:right;">
                        <%= ((lista.getPares_vendidos()!=null)?lista.getPares_vendidos():"") %>
                        <html:hidden property="pares_vendidos" styleId="pares_vendidos" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </td>

                      <html:hidden property="situacao_solicitacao" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true" styleId="situacao_solicitacao"/>

                      <td class="reportColumn" style="text-align:center;">
                        <%= lista.getSituacao_solicitacao_desc() %>
                        <html:hidden property="situacao_solicitacao_desc" styleId="situacao_solicitacao_desc" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align:center;">
                        <%= com.egen.util.text.FormatDate.format(lista.getData_aprovacao(), "dd/MM/yyyy HH:mm:ss") %>
                        <html:hidden property="data_aprovacao" styleId="data_aprovacao" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align:right;">
                        <%= com.egen.util.text.FormatNumber.format(lista.getPreco_liguido(), "##,##0.00") %>
                        <html:hidden property="preco_liguido" styleId="preco_liguido" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align:right;">
                        <%= com.egen.util.text.FormatNumber.format(lista.getLl_alteracao_solicitada(), "##,##0.00") %>
                        <html:hidden property="ll_alteracao_solicitada" styleId="ll_alteracao_solicitada" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </td>

                      <html:hidden property="tipo_solicitacao_comb_especial" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true" styleId="tipo_solicitacao_comb_especial"/>
                      <td class="reportColumn" style="text-align:center;">
                        <%= lista.getDesc_solicitacao_comb_especial() %>
                        <html:hidden property="desc_solicitacao_comb_especial" styleId="desc_solicitacao_comb_especial" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </td>

                      <html:hidden property="subtipo_solicitacao_comb_espec" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true" styleId="subtipo_solicitacao_comb_espec"/>
                      <td class="reportColumn" style="text-align:center;">
                        <%= ((lista.getDesc_subtipo_comb_espec()!=null)?lista.getDesc_subtipo_comb_espec():"") %>
                        <html:hidden property="desc_subtipo_comb_espec" styleId="desc_subtipo_comb_espec" styleClass="baseField" name="bl_form_Jw_ref_combinacao_especial_lines" indexed="true"/>
                      </td>

                      <%
                      sum_pares_alteracao += ((lista.getPares_alteracao() != null)?lista.getPares_alteracao():0);
                      i_bl_report_Jw_ref_combinacao_especial_lista++;
                      %>

                    </tr>

                  </logic:iterate>

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
                    <td>
                       
                    </td>
                    <td>
                       
                    </td>
                    <td>
                       
                    </td>



                    <td class="totalTdColumn"  style="text-align:right; font-weight:bold;" >
                      Total:
                      <%= com.egen.util.text.FormatNumber.format(sum_pares_alteracao, "#,##0.##") %>
                    </td>

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
                    <td>
                       
                    </td>
                    <td>
                       
                    </td>
                  </tr>
                </table>

                <%
                String styleForaMix = "";
                %>

                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="u" styleClass="baseButton" property="update_action">
                        <bean:message bundle="ApplicationResources" key="jsp.update"/>
                      </html:submit>
                      <html:submit accesskey="r" styleClass="myHidden" property="resetfull_action">
                        <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:submit>
                      <html:submit accesskey="p" styleClass="myHidden" property="select_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:submit accesskey="s" styleClass="baseButton" property="marca_todos_action">
                        Marcar Todos
                      </html:submit>
                      <html:submit accesskey="t" styleClass="baseButton" property="desmarcar_todos_action">
                        Desmarcar Todos
                      </html:submit>
                      <html:submit accesskey="i" styleClass="baseButton" property="gerar_relatorio_action">
                        Gerar Relatorio
                      </html:submit>
                    </td>
                  </tr>
                </table>
                <%
                if((String)request.getAttribute("abre_automaticamente")=="N"){
                  %>
                  <table style=width:100%;margin-top:10;>
                    <tr>
                      <td class=columHeader style="text-align:center;">
                        <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                          <bean:message key="report.downloadpdf"/>
                        </a>
                      </td>
                    </tr>
                  </table>
                  <%
                }
                %>

              </html:form>
              <html:form action="com/SolicitacaoCombinacaoEspecial_rForm.do" method="post" styleClass="baseForm">
                <table class="messageTable" style='width:99%;'>
                  <tr class="messageTr" >
                    <td class="messageTd">
                      <html:errors property="situacao_solicitacao1"/>
                      <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                    </td>
                  </tr>
                </table>

                <table class="itemTable"  style="width:99%;">
                  <%
                  String styleForaMix = "";
                  %>

                  <tr class="itemTr baseButton">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Alterar Situação
                      </span>
                    </td>
                    <td class="formField">
                      <html:select property="situacao_solicitacao1" styleId="situacao_solicitacao1" onchange="jQuery.post('SolicitacaoCombinacaoEspecial_rForm.do?sessao_action=&situacao_solicitacao1='+document.forms[1].situacao_solicitacao1.value)" styleClass="baseField" size="1">
                        <html:options property="situacao_solicitacao1List" labelProperty="situacao_solicitacao1LabelList" styleClass="baseOptions"/>
                      </html:select>
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
                      <html:submit value="Blank" styleClass="myhidden" property="sessao_action">
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

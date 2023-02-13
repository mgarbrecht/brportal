<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/Est102ActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = Est102ActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("emp_empresa","Empresa");
    hashMapLabel.set("emp_desc","");
    hashMapLabel.set("fil_filial","Filial");
    hashMapLabel.set("fil_desc","");
    hashMapLabel.set("local_est","Local Estoque");
    hashMapLabel.set("local_estoque_desc","");
    hashMapLabel.set("comp","Comprometimento");
    hashMapLabel.set("comp_desc","");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_desc","");
    hashMapLabel.set("ref_cdgo","Ref");
    hashMapLabel.set("ref_desc","");
    hashMapLabel.set("cab_cdgo","Cabedal");
    hashMapLabel.set("cab_desc","");
    hashMapLabel.set("item_est","Item Estoque");
    hashMapLabel.set("cor_cdgo","Cor");
    hashMapLabel.set("cor_desc","");
    hashMapLabel.set("marca_cdgo","Marca");
    hashMapLabel.set("marca_desc","");
    hashMapLabel.set("marcas","marcas");
    hashMapLabel.set("marcas_lista","marcas_lista");
    hashMapLabel.set("tipo_prod","Tipo Produto");
    hashMapLabel.set("tipo_prod_desc","");
    hashMapLabel.set("con_codigo","Mostrar numeração do continente");
    hashMapLabel.set("con_descricao","");
    hashMapLabel.set("grade","Grades");
    hashMapLabel.set("linhas_desconsiderar","Linhas a desconsiderar");
    hashMapLabel.set("linhas_considerar","Linhas a considerar");
    hashMapLabel.set("tipo_produtos","");
    hashMapLabel.set("tipos_produtos_lista","");
    hashMapLabel.set("tipo_estoque","");
    hashMapLabel.set("tipos_estoques","");
    hashMapLabel.set("mix","Mix / Fora mix");
    hashMapLabel.set("cb_img_prod","Imprimir Imagem Produto");
    hashMapLabel.set("cb_img_cores","Imprimir Imagens Cores Produto");
    hashMapLabel.set("cb_transito","Considera Trânsito");
    hashMapLabel.set("cb_preco","Mostrar Preço");
    hashMapLabel.set("cb_grade_quebrada","Somente Grade Quebrada");
    hashMapLabel.set("liv_codigo","Livro");
    hashMapLabel.set("liv_descri","");
    hashMapLabel.set("cb_ignorar_95","Ignorar Livro 95");
    hashMapLabel.set("cb_ignorar_grade_99","Ignorar Grade 99");
    hashMapLabel.set("qtde_ini","Qtde Inicial");
    hashMapLabel.set("qtde_fim","Qtde Final&nbsp");
    hashMapLabel.set("valor_inicial","Valor Inicial");
    hashMapLabel.set("valor_final","Valor Final");
    hashMapLabel.set("data_inicial","Data Inicial");
    hashMapLabel.set("data_final","Data Final");
    hashMapLabel.set("data_est_inicial","Data Est. Inicial");
    hashMapLabel.set("data_est_final","Data Est. Final");
    hashMapLabel.set("ordenacao","Ordenar por");
    hashMapLabel.set("qtde_itens","Qtde. Itens");
    hashMapLabel.set("layout","Tipo de Relatório");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Saldos de Estoque em Grades - Planilha
    </title>
  </head>
  <center>
    <body >
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(159)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/Est102Form.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="emp_empresa"/>
                    <html:errors property="emp_desc"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="fil_desc"/>
                    <html:errors property="local_est"/>
                    <html:errors property="local_estoque_desc"/>
                    <html:errors property="comp"/>
                    <html:errors property="comp_desc"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_desc"/>
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="ref_desc"/>
                    <html:errors property="cab_cdgo"/>
                    <html:errors property="cab_desc"/>
                    <html:errors property="item_est"/>
                    <html:errors property="cor_cdgo"/>
                    <html:errors property="cor_desc"/>
                    <html:errors property="marca_cdgo"/>
                    <html:errors property="marca_desc"/>
                    <html:errors property="tipo_prod"/>
                    <html:errors property="tipo_prod_desc"/>
                    <html:errors property="con_codigo"/>
                    <html:errors property="con_descricao"/>
                    <html:errors property="grade"/>
                    <html:errors property="linhas_desconsiderar"/>
                    <html:errors property="linhas_considerar"/>
                    <html:errors property="tipo_estoque"/>
                    <html:errors property="mix"/>
                    <html:errors property="cb_img_prod"/>
                    <html:errors property="cb_img_cores"/>
                    <html:errors property="cb_transito"/>
                    <html:errors property="cb_preco"/>
                    <html:errors property="cb_grade_quebrada"/>
                    <html:errors property="liv_codigo"/>
                    <html:errors property="liv_descri"/>
                    <html:errors property="cb_ignorar_95"/>
                    <html:errors property="cb_ignorar_grade_99"/>
                    <html:errors property="qtde_ini"/>
                    <html:errors property="qtde_fim"/>
                    <html:errors property="valor_inicial"/>
                    <html:errors property="valor_final"/>
                    <html:errors property="data_inicial"/>
                    <html:errors property="data_final"/>
                    <html:errors property="data_est_inicial"/>
                    <html:errors property="data_est_final"/>
                    <html:errors property="ordenacao"/>
                    <html:errors property="qtde_itens"/>
                    <html:errors property="layout"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Empresa
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="emp_empresa" styleId="emp_empresa" onblur="fillFields(0,new Array('emp_empresa'),'Est102ActionForm.getEmp_desc_Ajax',new Array('emp_desc'));" styleClass="baseField" size="4"/>
                    <input type="button" class="lovButton" tabindex=-1 value="..."  onclick="javascript:lov_open_emp_empresa()"  >
                    <script type="text/javascript">
                      function lov_open_emp_empresa() {
                        window.open('..//lov/LvEmpresaLov.do?resetfull_action=&returnBlock=0&return0=emp_empresa&return1=emp_desc','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="emp_desc" styleId="emp_desc" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Filial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fil_filial" styleId="fil_filial" onblur="fillFields(0,new Array('fil_filial'),'Est102ActionForm.getFil_desc_Ajax',new Array('fil_desc'));" styleClass="baseField" size="4"/>
                    <input type="button" class="lovButton" tabindex=-1 value="..."  onclick="javascript:lov_open_fil_filial()"  >
                    <script type="text/javascript">
                      function lov_open_fil_filial() {
                        window.open('..//lov/LvFilialLov.do?resetfull_action=&returnBlock=0&return0=fil_filial&return1=fil_desc','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="fil_desc" styleId="fil_desc" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Local Estoque
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="local_est" styleId="local_est" onblur="fillFields(0,new Array('fil_filial','local_est'),'Est102ActionForm.getLocal_estoque_desc_Ajax',new Array('local_estoque_desc'));" styleClass="baseField" size="4"/>
                    <input type="button" class="lovButton" tabindex=-1 value="..."  onclick="javascript:lov_open_local_est()"  >
                    <script type="text/javascript">
                      function lov_open_local_est() {
                        window.open('..//lov/LvLocalEstoqueLov.do?resetfull_action=&returnBlock=0&return0=local_est','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="local_estoque_desc" styleId="local_estoque_desc" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Comprometimento
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="comp" styleId="comp" onblur="fillFields(0,new Array('comp'),'Est102ActionForm.getComp_desc_Ajax',new Array('comp_desc'));" styleClass="baseField" size="4"/>
                    <input type="button" class="lovButton" tabindex=-1 value="..."  onclick="javascript:lov_open_comp()"  >
                    <script type="text/javascript">
                      function lov_open_comp() {
                        window.open('..//lov/LvComprometimentoLov.do?resetfull_action=&returnBlock=0&return0=comp&return1=comp_desc','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="comp_desc" styleId="comp_desc" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" onblur="fillFields(0,new Array('lin_cdgo'),'Est102ActionForm.getLin_desc_Ajax',new Array('lin_desc'));" styleClass="baseField" size="4"/>
                    <input type="button" class="lovButton" tabindex=-1 value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('..//lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_desc','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_desc" styleId="lin_desc" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Ref
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ref_cdgo" styleId="ref_cdgo" onblur="fillFields(0,new Array('lin_cdgo','ref_cdgo'),'Est102ActionForm.getRef_desc_Ajax',new Array('ref_desc'));" styleClass="baseField" size="4"/>
                    <input type="button" class="lovButton" tabindex=-1 value="..."  onclick="javascript:lov_open_ref_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_ref_cdgo() {
                        window.open('..//lov/LvRefLov.do?resetfull_action=&returnBlock=0&return0=ref_cdgo&return1=ref_desc','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="ref_desc" styleId="ref_desc" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cabedal
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cab_cdgo" styleId="cab_cdgo" onblur="fillFields(0,new Array('cab_cdgo'),'Est102ActionForm.getCab_desc_Ajax',new Array('cab_desc'));" styleClass="baseField" size="4"/>
                    <input type="button" class="lovButton" tabindex=-1 value="..."  onclick="javascript:lov_open_cab_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_cab_cdgo() {
                        window.open('..//lov/LvCabedalLov.do?resetfull_action=&returnBlock=0&return0=cab_cdgo&return1=cab_desc','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cab_desc" styleId="cab_desc" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Item Estoque
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="item_est" styleId="item_est" styleClass="baseField" size="30"/>
                    <span class='validateMessageuser'>
                      Separados por vírgula
                    </span>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cor
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cor_cdgo" styleId="cor_cdgo" onblur="fillFields(0,new Array('cor_cdgo'),'Est102ActionForm.getCor_desc_Ajax',new Array('cor_desc'));" styleClass="baseField" size="4"/>
                    <input type="button" class="lovButton" tabindex=-1 value="..."  onclick="javascript:lov_open_cor_cdgo()"  >
                    <script type="text/javascript">
                      <script type="text/javascript">
                      function lov_open_cor_cdgo() {
                        window.open('..//lov/LvCorLov.do?resetfull_action=&returnBlock=0&return0=cor_cdgo&return1=cor_desc','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>



                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cor_desc" styleId="cor_desc" onblur="fillFields(0,new Array('cor_cdgo','cor_desc'),'Est102ActionForm.getCor_cdgo_Ajax',new Array());" styleClass="disabled" tabindex="-1" readonly="true" size="28"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="marca_cdgo" styleId="marca_cdgo" onblur="fillFields(0,new Array('marca_cdgo'),'Est102ActionForm.getMarca_desc_Ajax',new Array('marca_desc'));" styleClass="baseField" size="4"/>
                    <input type="button" class="lovButton" tabindex=-1 value="..."  onclick="javascript:lov_open_marca_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_marca_cdgo() {
                        window.open('..//lov/LvMarcaLov.do?resetfull_action=&returnBlock=0&return0=marca_cdgo&return1=marca_desc','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="marca_desc" styleId="marca_desc" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                    <input type="button" class="lovButton"  value="Selecionar Marcas" onclick="javascript:lov_open_marcas()">
                    <script type="text/javascript">
                      function lov_open_marcas() {
                        window.open('..//lov/LvMarcaGrdGrid.do?select_action','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                    </span>
                  </td>
                  <td class="formField">
                    <%
                    int counterbl_report_Marcas =0;
                    int i_bl_report_Marcas =0;
                    java.util.Vector res_Marcas = (java.util.Vector)session.getAttribute("est102_marcas_selecionadas_vetor");
                    if (res_Marcas!=null && res_Marcas.size()>0) {
                      %>
                      <table id="TRbl_report_Jw_tipos_produtos" class="reportTable" style=width:340px; border=1; >
                        <tr class="reportHeader" >
                          <td align="center">
                            Marcas Selecionadas
                          </td>
                        </tr>
                        <%
                        for (int x=0;x<res_Marcas.size(); x++){
                          counterbl_report_Marcas++;
                          String style="";
                          if (!((i_bl_report_Marcas%2)!=0)) {
                            style="class=rowColor";
                          } else {
                            style="class=rowBlank";
                          }
                          %>
                          <tr <%= style %> id='TRbl_report_Jw_tipos_produtos<%= counterbl_report_Marcas %>' >
                            <td class="reportColumn" style="text-align:left;">
                              <%= res_Marcas.elementAt(x) %>
                            </td>
                          </tr>
                          <%
                        }
                        %>
                      </table>

                      <%
                    }
                    %>

                  </td>
                </tr>
                <html:hidden property="tipo_prod" />
                <html:hidden property="tipo_prod_desc" />
                <%
                if(false) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Tipo Produto
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="tipo_prod" styleId="tipo_prod" onblur="fillFields(0,new Array('tipo_prod'),'Est102ActionForm.getTipo_prod_desc_Ajax',new Array('tipo_prod_desc'));" styleClass="baseField" size="4"/>
                      <input type="button" class="lovButton" tabindex=-1 value="..."  onclick="javascript:lov_open_tipo_prod()"  >
                      <script type="text/javascript">
                        function lov_open_tipo_prod() {
                          window.open('..//lov/LvTipoProdutoLov.do?resetfull_action=&returnBlock=0&return0=tipo_prod&return1=tipo_prod_desc','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="tipo_prod_desc" styleId="tipo_prod_desc" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                    </td>
                  </tr>

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Mostrar numeração do continente
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="con_codigo" styleId="con_codigo" onblur="javascript:toUpperCase(this);fillFields(0,new Array('con_codigo'),'Est102ActionForm.getCon_descricao_Ajax',new Array('con_descricao'));" styleClass="baseField" size="4"/>
                    <input type="button" class="lovButton"  value="..." tabindex="-1" onclick="javascript:lov_open_con_codigo()"  >
                    <script type="text/javascript">
                      function lov_open_con_codigo() {
                        window.open('..//lov/LvContinentesLov.do?resetfull_action=&returnBlock=0&return0=con_codigo&return1=con_descricao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="con_descricao" styleId="con_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="50" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Grades
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="grade" styleId="grade" styleClass="baseField"/>
                    <span class='validateMessageuser'>
                      Grades separadas por vírgula
                    </span>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linhas a desconsiderar
                    </span>
                  </td>
                  <td class="formField">
                    <html:textarea property="linhas_desconsiderar" styleId="linhas_desconsiderar" styleClass="baseField" cols="60" rows="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linhas a considerar
                    </span>
                  </td>
                  <td class="formField">
                    <html:textarea property="linhas_considerar" styleId="linhas_considerar" styleClass="baseField" cols="60" rows="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                    <input type="button" class="lovButton"  value="Tipo de Produto"  onclick="javascript:lov_open_tipo_produto()"  >
                    <script type="text/javascript">
                      function lov_open_tipo_produto() {
                        window.open('..//lov/LvTipoProdutoGrdGrid.do?select_action','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                    </span>
                  </td>
                  <td class="formField">
                    <%
                    int counterbl_report_Jw_tipos_produtos =0;
                    int i_bl_report_Jw_tipos_produtos =0;
                    java.util.Vector res_Jw_tipos_produtos = (java.util.Vector)session.getAttribute("tipos_produtos_selecionados_vetor");
                    if (res_Jw_tipos_produtos!=null && res_Jw_tipos_produtos.size()>0) {
                      %>
                      <table id="TRbl_report_Jw_tipos_produtos" class="reportTable" style=width:340px; border=1;  >
                        <tr class="reportHeader" >
                          <td align="center">
                            Tipo Produtos Selecionados
                          </td>
                        </tr>
                        <%
                        for (int x=0;x<res_Jw_tipos_produtos.size(); x++){
                          counterbl_report_Jw_tipos_produtos++;
                          String style="";
                          if (!((i_bl_report_Jw_tipos_produtos%2)!=0)) {
                            style="class=rowColor";
                          } else {
                            style="class=rowBlank";
                          }
                          %>
                          <tr <%= style %> id='TRbl_report_Jw_tipos_produtos<%=counterbl_report_Jw_tipos_produtos%>' >
                            <td class="reportColumn" style="text-align:left;">
                              <%= res_Jw_tipos_produtos.elementAt(x) %>
                            </td>
                          </tr>
                          <%
                        }
                        %>
                      </table>
                      <%
                    }
                    %>



                  </td>
                </tr>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="tipo_estoque" disabled="true" styleId="tipo_estoque" styleClass="myhidden"/>
                    <input type="button" class="lovButton"  value="Tipo de Estoque"  onclick="javascript:lov_open_tipo_estoque()"  >
                    <script type="text/javascript">
                      function lov_open_tipo_estoque() {
                        //   window.open('..//lov/LvTipoEstoqueGrdLov.jsp?returnBlock=0&return0=tipo_estoque','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                        window.open('..//lov/LvTipoEstoqueGrdGrid.do?select_action=&opener=est102','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                    </span>
                  </td>
                  <td class="formField">
                    <%
                    int counterbl_report_Jw_clientes_enderecos =0;
                    int i_bl_report_Jw_clientes_enderecos =0;
                    java.util.Vector res_Jw_clientes_grupos_economicos = (java.util.Vector)session.getAttribute("tipos_estoque");
                    if (res_Jw_clientes_grupos_economicos!=null && res_Jw_clientes_grupos_economicos.size()>0) {
                      %>
                      <table id="TRbl_report_Jw_clientes_enderecos" class="reportTable" style=width:340px; border=1;  >
                        <tr class="reportHeader" >
                          <td align="center">
                            Tipo Estoque selecionados
                          </td>
                        </tr>
                        <%
                        for (int x=0;x<res_Jw_clientes_grupos_economicos.size(); x++){
                          counterbl_report_Jw_clientes_enderecos++;
                          String style="";
                          if (!((i_bl_report_Jw_clientes_enderecos%2)!=0)) {
                            style="class=rowColor";
                          } else {
                            style="class=rowBlank";
                          }
                          %>
                          <tr <%= style %> id='TRbl_report_Jw_clientes_enderecos<%=counterbl_report_Jw_clientes_enderecos%>' >
                            <td class="reportColumn" style="text-align:left;">
                              <%= res_Jw_clientes_grupos_economicos.elementAt(x) %>
                            </td>
                          </tr>
                          <%
                        }
                        %>
                      </table>
                      <%
                    }
                    %>



                  </td>
                </tr>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Mix / Fora mix
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="mix" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="T">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="M">
                        No Mix
                      </html:option>
                      <html:option styleClass="baseOption" value="F">
                        Fora Mix
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Imprimir Imagem Produto
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_img_prod" styleClass="baseField" value="checked"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Imprimir Imagens Cores Produto
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_img_cores" styleId="cb_img_cores" styleClass="baseField" value="1"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Considera Trânsito
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_transito" styleId="cb_transito" styleClass="baseField" value="checked"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Mostrar Preço
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_preco" styleId="cb_preco" styleClass="baseField" value="checked"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Somente Grade Quebrada
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_grade_quebrada" styleId="cb_grade_quebrada" styleClass="baseField" value="checked"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Livro
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="liv_codigo" styleId="liv_codigo" onblur="fillFields(0,new Array('liv_codigo'),'Est102ActionForm.getLiv_descri_Ajax',new Array('liv_descri'));" styleClass="baseField" size="3"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="liv_descri" styleId="liv_descri" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Ignorar Livro 95
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_ignorar_95" styleId="cb_ignorar_95" styleClass="baseField" value="1"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Ignorar Grade 99
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_ignorar_grade_99" styleId="cb_ignorar_grade_99" styleClass="baseField" value="1"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Qtde Inicial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="qtde_ini" styleId="qtde_ini" styleClass="baseField" size="20"/>
                    <span class="spamFormLabel">
                      Qtde Final&nbsp
                    </span>
                    <html:text property="qtde_fim" styleId="qtde_fim" styleClass="baseField" size="20"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Valor Inicial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="valor_inicial" styleId="valor_inicial" styleClass="baseField"/>
                    <span class="spamFormLabel">
                      Valor Final
                    </span>
                    <html:text property="valor_final" styleId="valor_final" styleClass="baseField"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Inicial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_inicial" styleId="data_inicial" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_inicial']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Final
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_final" styleId="data_final" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Est. Inicial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_est_inicial" styleId="data_est_inicial" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_est_inicial']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Est. Final
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_est_final" styleId="data_est_final" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_est_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Ordenar por
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="ordenacao" styleId="ordenacao" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="les_lin_ref">
                        Local/Linha/Ref
                      </html:option>
                      <html:option styleClass="baseOption" value="normal">
                        Emp/Fil/Les/Tes/Tco/Modelo
                      </html:option>
                      <html:option styleClass="baseOption" value="linha">
                        Linha/Ref
                      </html:option>
                      <html:option styleClass="baseOption" value="les">
                        Les/Tes/Tco/Modelo
                      </html:option>
                      <html:option styleClass="baseOption" value="fil_lin_ref">
                        Filial/Linha/Ref
                      </html:option>
                      <html:option styleClass="baseOption" value="qtd_les_lin_ref">
                        Quantidade/Local/Linha/Ref
                      </html:option>
                      <html:option styleClass="baseOption" value="data_les_lin_ref">
                        Data/Local/Linha/Ref
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Qtde. Itens
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="qtde_itens" styleId="qtde_itens" styleClass="baseField" size="5"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo de Relatório
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="layout" styleId="layout" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="1">
                        Padrão
                      </html:option>
                      <html:option styleClass="baseOption" value="2">
                        Resumo
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <%
                session.setAttribute("opener", "est102");
                %>

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
                    <html:button accesskey="s" value="Gerar Planilha" onclick="bloqueia();this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                    </html:button>
                    <html:button accesskey="r" onclick="document.forms[0].resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:button>
                    <html:submit accesskey="s" value="Gerar Planilha" onclick="bloqueia();" styleClass="myhidden" property="select_action">
                    </html:submit>
                    <html:submit accesskey="r" styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="refresh_action">
                      <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

              <script type="text/javascript">
                jQuery(document).ready(function($) {
                  $("#data_inicial").mask("99/99/9999");
                  $("#data_final").mask("99/99/9999");
                  $("#data_est_inicial").mask("99/99/9999");
                  $("#data_est_final").mask("99/99/9999");
                  });


                  jQuery("#cb_ignorar_95").attr('checked', true);
                </script>
              </html:form>
              <script type="text/javascript">
                var focusControl = document.forms[0].elements["emp_empresa"];
                if (focusControl.type != "hidden"){
                  focusControl.focus();
                }
              </script>

            </td>
          </tr>
        </table>

      </body>
    </center>
  </html>

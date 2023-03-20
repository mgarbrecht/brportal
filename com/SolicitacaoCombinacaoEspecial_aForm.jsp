<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/SolicitacaoCombinacaoEspecial_aActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = SolicitacaoCombinacaoEspecial_aActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("id_solicitacao","ID");
    hashMapLabel.set("data_solicitacao","Data");
    hashMapLabel.set("usuario_solicitacao","Usuário");
    hashMapLabel.set("tipo_solicitacao","Tipo de solicitação");
    hashMapLabel.set("subtipo_solicitacao_comb_espec","Subtipo");
    hashMapLabel.set("codigo_marca","Marca");
    hashMapLabel.set("material","Material");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("linha_mix","");
    hashMapLabel.set("f_imagens_produto","");
    hashMapLabel.set("f_grade","");
    hashMapLabel.set("ref_cdgo","Ref.");
    hashMapLabel.set("ref_desc","");
    hashMapLabel.set("cab_cdgo","Cabedal");
    hashMapLabel.set("cab_desc","");
    hashMapLabel.set("cor_cdgo","Cor");
    hashMapLabel.set("cor_desc","");
    hashMapLabel.set("data_entrega_amostra","Data Embarque Amostra");
    hashMapLabel.set("observacao","Observação");
    hashMapLabel.set("material_cor1","Material e cor (Cabedal 1)");
    hashMapLabel.set("material_cor2","Material e cor (Cabedal 2)");
    hashMapLabel.set("material_cor3","Material e cor (Cabedal 3)");
    hashMapLabel.set("material_cor4","Material e cor (Cabedal 4)");
    hashMapLabel.set("material_cor5","Material e cor (Cabedal 5)");
    hashMapLabel.set("material_cor6","Material e cor (Cabedal 6)");
    hashMapLabel.set("material_cor7","Material e cor (Cabedal 7)");
    hashMapLabel.set("material_cor8","Material e cor (Cabedal 8)");
    hashMapLabel.set("material_cor9","Material e cor (Cabedal 9)");
    hashMapLabel.set("material_cor10","Material e cor (Cabedal 10)");
    hashMapLabel.set("biqueira_debrum","Debrum (Cabedal)");
    hashMapLabel.set("capa_palmilha","Palmilha");
    hashMapLabel.set("taloneira","Gota/taloneira");
    hashMapLabel.set("enfeite","Enfeites");
    hashMapLabel.set("metais","Metais");
    hashMapLabel.set("cepa","Cepa");
    hashMapLabel.set("salto","Salto");
    hashMapLabel.set("sola","Sola");
    hashMapLabel.set("cacharel","Cacharel");
    hashMapLabel.set("forro","Forro");
    hashMapLabel.set("atacador","Atacador");
    hashMapLabel.set("carimbo_etiqueta","Carimbo/etiqueta");
    hashMapLabel.set("cli_cdgo","Cliente <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("codigo_regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("gre_grupo","Grupo Econômico <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>");
    hashMapLabel.set("gre_descricao","");
    hashMapLabel.set("prs_negociacao","Pares Negociação");
    hashMapLabel.set("pares_linha","Pares Linha");
    hashMapLabel.set("pares_alteracao","Pares Solicitados");
    hashMapLabel.set("preco_liguido","Preço Liquido");
    hashMapLabel.set("ll_alteracao_solicitada","LL Alteração Solicitada");
    hashMapLabel.set("valor_fabricacao","CTF");
    hashMapLabel.set("preco_vendor","Preço Vendor");
    hashMapLabel.set("arquivo","Imagem");
    hashMapLabel.set("situacao_solicitacao","Situação");
    hashMapLabel.set("data_aceite","Data_aceite");
    hashMapLabel.set("usuario_aceite","Usuario_aceite");
    hashMapLabel.set("imagem_produto","Imagem Produto");
    hashMapLabel.set("pedido","Pedido (opcional)");
    hashMapLabel.set("item","Item");
    hashMapLabel.set("item_desc","");
    hashMapLabel.set("f_pdf","");
    hashMapLabel.set("f_duplicacao","");
    hashMapLabel.set("id_solicitacao_delete","");
    hashMapLabel.set("data_aprovacao","Data_aprovacao");
    hashMapLabel.set("ref_grupo_posicao_fab","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Solicitação de Combinações Especiais - Alteração
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(203)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/SolicitacaoCombinacaoEspecial_aForm.do" enctype="multipart/form-data" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <div class\='div10l'>
                        Um dos campos com
                        <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        deve ser preenchido.
                      </div>
                      <div class\='div10l'>
                        Todos os campos com
                        <img src='../img/required.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        devem ser preenchidos.
                      </div>
                    </div>
                    <html:errors property="id_solicitacao"/>
                    <html:errors property="data_solicitacao"/>
                    <html:errors property="usuario_solicitacao"/>
                    <html:errors property="tipo_solicitacao"/>
                    <html:errors property="subtipo_solicitacao_comb_espec"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="material"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="linha_mix"/>
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="ref_desc"/>
                    <html:errors property="cab_cdgo"/>
                    <html:errors property="cab_desc"/>
                    <html:errors property="cor_cdgo"/>
                    <html:errors property="cor_desc"/>
                    <html:errors property="data_entrega_amostra"/>
                    <html:errors property="observacao"/>
                    <html:errors property="material_cor1"/>
                    <html:errors property="material_cor2"/>
                    <html:errors property="material_cor3"/>
                    <html:errors property="material_cor4"/>
                    <html:errors property="material_cor5"/>
                    <html:errors property="material_cor6"/>
                    <html:errors property="material_cor7"/>
                    <html:errors property="material_cor8"/>
                    <html:errors property="material_cor9"/>
                    <html:errors property="material_cor10"/>
                    <html:errors property="biqueira_debrum"/>
                    <html:errors property="capa_palmilha"/>
                    <html:errors property="taloneira"/>
                    <html:errors property="enfeite"/>
                    <html:errors property="metais"/>
                    <html:errors property="cepa"/>
                    <html:errors property="salto"/>
                    <html:errors property="sola"/>
                    <html:errors property="forro"/>
                    <html:errors property="atacador"/>
                    <html:errors property="carimbo_etiqueta"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="codigo_regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="gre_grupo"/>
                    <html:errors property="gre_descricao"/>
                    <html:errors property="prs_negociacao"/>
                    <html:errors property="pares_linha"/>
                    <html:errors property="pares_alteracao"/>
                    <html:errors property="preco_liguido"/>
                    <html:errors property="ll_alteracao_solicitada"/>
                    <html:errors property="valor_fabricacao"/>
                    <html:errors property="preco_vendor"/>
                    <html:errors property="situacao_solicitacao"/>
                    <html:errors property="pedido"/>
                    <html:errors property="item"/>
                    <html:errors property="item_desc"/>
                    <html:errors property="ref_grupo_posicao_fab"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                util.consultas.Query qr = new util.consultas.Query();
                acesso.Sessao sessao = new acesso.Sessao(session);
                boolean liberaAlteracaoSolicitada = false;
                util.consultas.DiasUteis diasUteis = new util.consultas.DiasUteis();
                String dias5 = diasUteis.buscar(5);
                String dias10 = diasUteis.buscar(10);
                String dataAtual = qr.retorna("SELECT to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') FROM dual");
                String dataAtual24horas = qr.retorna("SELECT to_char(SYSDATE+1,'dd/mm/yyyy hh24:mi:ss') FROM dual");
                String dataAtual5dias = dias5;
                String usuario = sessao.getUsuario().toUpperCase();

                if(sessao.getTipoEntidadeNegocio().equals("AREAS") || user.isSuperUsuario()){
                  liberaAlteracaoSolicitada = true;
                }
                portalbr.com.SolicitacaoCombinacaoEspecial_aActionForm solicitacaoActionForm = (portalbr.com.SolicitacaoCombinacaoEspecial_aActionForm)session.getAttribute("SolicitacaoCombinacaoEspecial_aActionForm");
                %>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      ID
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="id_solicitacao" styleId="id_solicitacao" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="22"/>
                    <span class="spamFormLabel">
                      Data
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                    <html:text property="data_solicitacao" styleId="data_solicitacao" styleClass="disabled" tabindex="-1" readonly="true" size="22" maxlength="22"/>
                    <span class="spamFormLabel">
                      Usuário
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                    <html:text property="usuario_solicitacao" styleId="usuario_solicitacao" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo de solicitação
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:select property="tipo_solicitacao" styleId="tipo_solicitacao" onchange="refresh_action.click();" styleClass="baseField" size="1">
                      <html:options property="tipo_solicitacaoList" labelProperty="tipo_solicitacaoLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Subtipo
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="subtipo_solicitacao_comb_espec" styleId="subtipo_solicitacao_comb_espec" styleClass="baseField">
                      <html:options property="subtipo_solicitacao_comb_especList" labelProperty="subtipo_solicitacao_comb_especLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="codigo_marca" styleId="codigo_marca" onblur="fillFields(0,new Array('cli_cdgo','codigo_marca'),'SolicitacaoCombinacaoEspecial_aActionForm.getCli_rzao_Ajax',new Array('rep_cdgo','rep_rzao','cli_rzao'));" styleClass="baseField" size="1">
                      <html:options property="codigo_marcaList" labelProperty="codigo_marcaLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Material
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="material" styleId="material" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="">
                        Selecionar
                      </html:option>
                      <html:option styleClass="baseOption" value="M">
                        Mix
                      </html:option>
                      <html:option styleClass="baseOption" value="D">
                        Desenvolvimento
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" onblur="fillFields(0,new Array('lin_cdgo'),'SolicitacaoCombinacaoEspecial_aActionForm.getLin_nome_Ajax',new Array('lin_nome'));" styleClass="baseField" size="7" maxlength="22"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('..//lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_nome" styleId="lin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="25"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="linha_mix" styleId="linha_mix" style="font-weight:bold; text-align:start;" styleClass="disabled" tabindex="-1" readonly="true" size="10"/>
                    <span class="spamFormLabel">
                    </span>
                    <input type="button" class="lovButton" value="Fotos Linha" onclick="if(document.forms[0].lin_cdgo.value==''){alert('Informe a linha!');}else{wopen('../ind/FotosLinhaResumoForm.do?select_action=&lin_cdgo='+document.forms[0].lin_cdgo.value,'_blank',800,500)}">
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    Grade
                  </td>
                  <td class="formField">
                    <%
                    if(session.getAttribute("v_numeracao")==null){
                      %>
                      <input type="button" class="lovButton" tabindex="-1" value="Informar Grade"  onclick="if(document.forms[0].lin_cdgo.value==''){alert('Informe a linha!');}else{wopen('../com/SolicitacaoCombinacaoEspecial_gForm.do?select1_action=&lin_cdgo1='+document.forms[0].lin_cdgo.value,'_blank',640,110)}"  >
                      <%
                    }
                    %>
                    <%
                    if(session.getAttribute("v_numeracao")!=null){
                      %>

                      <table>
                        <tr>
                          <td>

                            <table border="2" class="grade">
                              <tr style="background-color:lightblue">
                                <%
                                for (Object a: ((Vector)session.getAttribute("v_numeracao")).toArray()){
                                  String[] s = ((String)a).split("#");
                                  %>
                                  <td style="width:30px;text-align:center">
                                    <b>
                                      <%= s[0] %>
                                    </b>
                                  </td>
                                  <%
                                }
                                %>

                              </tr>
                              <tr>
                                <%
                                for (Object a: ((Vector)session.getAttribute("v_numeracao")).toArray()){
                                  String[] s = ((String)a).split("#");
                                  %>
                                  <td style="width:30px;text-align:center">
                                    <b>
                                      <%= s[1] %>
                                    </b>
                                  </td>
                                  <%
                                }
                                %>

                              </table>
                            </td>
                            <td>
                              <input type="button" class="lovButton" tabindex="-1" value="Alterar Grade"  onclick="if(document.forms[0].lin_cdgo.value==''){alert('Informe a linha!');}else{wopen('../com/SolicitacaoCombinacaoEspecial_gForm.do?select1_action=&lin_cdgo1='+document.forms[0].lin_cdgo.value,'_blank',640,110)}"  >
                              <%
                              if(session.getAttribute("v_numeracao")!=null){
                                %>
                                <input type="button" class="lovButton" tabindex="-1" value="Limpar Grade" onclick="jQuery.post('SolicitacaoCombinacaoEspecial_aForm.do?delete_grade_action=&id_solicitacao_delete='+document.forms[0].id_solicitacao.value);refresh_action.click();" >
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

                  <tr class="itemTr">
                    <td class="formLabel">
                      <%
                      if((solicitacaoActionForm.getTipo_solicitacao()+"").equals("3")) {
                        %>
                        <span class="spamFormLabel">
                          Ref.
                          <img src='../img/required.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        </span>
                        <%
                      } else {
                        %>
                        <span class="spamFormLabel">
                          Ref.
                        </span>
                        <%
                      }
                      %>
                    </td>
                    <td class="formField">
                      <html:text property="ref_cdgo" styleId="ref_cdgo" onblur="if(this.value!=''){fillFields(0,new Array('lin_cdgo','ref_cdgo'),'SolicitacaoCombinacaoEspecial_aActionForm.getRef_desc_Ajax',new Array('ref_desc'));} else {document.forms[0].ref_desc.value='';}" styleClass="baseField" size="6"/>
                      <input type="button" class="lovButton" tabindex="-1"  value="..."  onclick="javascript:lov_open_ref_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_ref_cdgo() {
                          window.open('..//lov/LvLinhaRefLov.do?resetfull_action=&returnBlock=0&return0=ref_cdgo&return1=ref_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="ref_desc" styleId="ref_desc" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="25"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Cabedal
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="cab_cdgo" styleId="cab_cdgo" onblur="fillFields(0,new Array('cab_cdgo'),'SolicitacaoCombinacaoEspecial_aActionForm.getCab_desc_Ajax',new Array('cab_desc'));" styleClass="baseField" size="5" maxlength="22"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cab_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_cab_cdgo() {
                          window.open('..//lov/LvCabedalLov.do?resetfull_action=&returnBlock=0&return0=cab_cdgo&return1=cab_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="cab_desc" styleId="cab_desc" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Cor
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="cor_cdgo" styleId="cor_cdgo" onblur="fillFields(0,new Array('cor_cdgo'),'SolicitacaoCombinacaoEspecial_aActionForm.getCor_desc_Ajax',new Array('cor_desc'));" styleClass="baseField" size="6" maxlength="22"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cor_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_cor_cdgo() {
                          window.open('..//lov/LvCorLov.do?resetfull_action=&returnBlock=0&return0=cor_cdgo&return1=cor_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="cor_desc" styleId="cor_desc" styleClass="disabled" tabindex="-1" readonly="true" size="65" maxlength="60"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Data Embarque Amostra
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="data_entrega_amostra" styleId="data_entrega_amostra" styleClass="baseField" size="10" maxlength="10"/>
                      &nbsp;
                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_entrega_amostra']); cal1.year_scroll = true; cal1.popup();">
                        <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                      </a>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Observação
                      </span>
                    </td>
                    <td class="formField">
                      <html:textarea property="observacao" styleId="observacao" styleClass="baseField" cols="150" rows="22"/>
                    </td>
                  </tr>

                </table>
                <br>
                <div style="border:2px solid #dec693">
                  <table class="itemTable"  style="width:99%;">



                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Material e cor (Cabedal 1)
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="material_cor1" styleId="material_cor1" styleClass="baseField" size="80" maxlength="2000"/>
                        <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_material_cor1()"  >
                        <script type="text/javascript">
                          function lov_open_material_cor1() {
                            window.open('..//lov/LvMixMateriaisDiaLov.do?resetfull_action=&returnBlock=0&return1=material_cor1','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                          }
                        </script>

                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Material e cor (Cabedal 2)
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="material_cor2" styleId="material_cor2" styleClass="baseField" size="80" maxlength="2000"/>
                          <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_material_cor2()"  >
                          <script type="text/javascript">
                            function lov_open_material_cor2() {
                              window.open('..//lov/LvMixMateriaisDiaLov.do?resetfull_action=&returnBlock=0&return1=material_cor2','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                            }
                          </script>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Material e cor (Cabedal 3)
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="material_cor3" styleId="material_cor3" styleClass="baseField" size="80" maxlength="2000"/>
                          <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_material_cor3()"  >
                          <script type="text/javascript">
                            function lov_open_material_cor3() {
                              window.open('..//lov/LvMixMateriaisDiaLov.do?resetfull_action=&returnBlock=0&return1=material_cor3','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                            }
                          </script>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Material e cor (Cabedal 4)
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="material_cor4" styleId="material_cor4" styleClass="baseField" size="80" maxlength="2000"/>
                          <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_material_cor4()"  >
                          <script type="text/javascript">
                            function lov_open_material_cor4() {
                              window.open('..//lov/LvMixMateriaisDiaLov.do?resetfull_action=&returnBlock=0&return1=material_cor4','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                            }
                          </script>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Material e cor (Cabedal 5)
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="material_cor5" styleId="material_cor5" styleClass="baseField" size="80" maxlength="2000"/>
                          <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_material_cor5()"  >
                          <script type="text/javascript">
                            function lov_open_material_cor5() {
                              window.open('..//lov/LvMixMateriaisDiaLov.do?resetfull_action=&returnBlock=0&return1=material_cor5','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                            }
                          </script>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Material e cor (Cabedal 6)
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="material_cor6" styleId="material_cor6" styleClass="baseField" size="80" maxlength="2000"/>
                          <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_material_cor6()"  >
                          <script type="text/javascript">
                            function lov_open_material_cor6() {
                              window.open('..//lov/LvMixMateriaisDiaLov.do?resetfull_action=&returnBlock=0&return1=material_cor6','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                            }
                          </script>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Material e cor (Cabedal 7)
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="material_cor7" styleId="material_cor7" styleClass="baseField" size="80" maxlength="2000"/>
                          <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_material_cor7()"  >
                          <script type="text/javascript">
                            function lov_open_material_cor7() {
                              window.open('..//lov/LvMixMateriaisDiaLov.do?resetfull_action=&returnBlock=0&return1=material_cor7','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                            }
                          </script>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Material e cor (Cabedal 8)
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="material_cor8" styleId="material_cor8" styleClass="baseField" size="80" maxlength="2000"/>
                          <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_material_cor8()"  >
                          <script type="text/javascript">
                            function lov_open_material_cor8() {
                              window.open('..//lov/LvMixMateriaisDiaLov.do?resetfull_action=&returnBlock=0&return1=material_cor8','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                            }
                          </script>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Material e cor (Cabedal 9)
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="material_cor9" styleId="material_cor9" styleClass="baseField" size="80" maxlength="2000"/>
                          <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_material_cor9()"  >
                          <script type="text/javascript">
                            function lov_open_material_cor9() {
                              window.open('..//lov/LvMixMateriaisDiaLov.do?resetfull_action=&returnBlock=0&return1=material_cor9','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                            }
                          </script>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Material e cor (Cabedal 10)
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="material_cor10" styleId="material_cor10" styleClass="baseField" size="80" maxlength="2000"/>
                          <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_material_cor10()"  >
                          <script type="text/javascript">
                            function lov_open_material_cor10() {
                              window.open('..//lov/LvMixMateriaisDiaLov.do?resetfull_action=&returnBlock=0&return1=material_cor10','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                            }
                          </script>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Debrum (Cabedal)
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="biqueira_debrum" styleId="biqueira_debrum" styleClass="baseField" size="80" maxlength="2000"/>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Palmilha
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="capa_palmilha" styleClass="baseField" size="80"/>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Gota/taloneira
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="taloneira" styleId="taloneira" styleClass="baseField" size="50" maxlength="2000"/>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Enfeites
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="enfeite" styleId="enfeite" styleClass="baseField" size="50" maxlength="2000"/>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Metais
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="metais" styleClass="baseField" size="50"/>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Cepa
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="cepa" styleId="cepa" styleClass="baseField" size="50" maxlength="2000"/>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Salto
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="salto" styleClass="baseField" size="50"/>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Sola
                          </span>
                          <bean:message key="jsp.fieldnotnull"/>
                        </td>
                        <td class="formField">
                          <html:text property="sola" styleId="sola" styleClass="baseField" size="50" maxlength="2000"/>
                        </td>
                      </tr>

                      <html:hidden property="cacharel"/>
                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Forro
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="forro" styleId="forro" styleClass="baseField" size="50" maxlength="2000"/>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Atacador
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="atacador" styleId="atacador" styleClass="baseField" size="50" maxlength="2000"/>
                        </td>
                      </tr>



                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Carimbo/etiqueta
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="carimbo_etiqueta" styleId="carimbo_etiqueta" styleClass="baseField" size="100" maxlength="2000"/>
                        </td>
                      </tr>
                    </table>
                    <br>
                  </div>

                  <br>
                  <div style="border:2px solid #dec693">
                    <table class="itemTable"  style="width:99%;">
                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Cliente
                            <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="cli_cdgo" styleId="cli_cdgo" onblur="fillFields(0,new Array('cli_cdgo','codigo_marca','ref_grupo_posicao_fab'),'SolicitacaoCombinacaoEspecial_aActionForm.getCli_rzao_Ajax',new Array('cli_rzao','rep_cdgo','rep_rzao'));" styleClass="baseField" size="10" maxlength="22"/>
                          <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cli_cdgo()"  >
                          <script type="text/javascript">
                            function lov_open_cli_cdgo() {
                              window.open('..//lov/LvClienteLov.do?resetfull_action=&returnBlock=0&return0=cli_cdgo&return1=cli_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                            }
                          </script>
                          <span class="spamFormLabel">
                          </span>
                          <html:text property="cli_rzao" styleId="cli_rzao" onblur="fillFields(0,new Array('cli_cdgo','codigo_marca','ref_grupo_posicao_fab'),'SolicitacaoCombinacaoEspecial_aActionForm.getCli_rzao_Ajax',new Array('cli_rzao','rep_cdgo','rep_rzao'));" styleClass="disabled" tabindex="-1" readonly="true" size="55" maxlength="50"/>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Representante
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="rep_cdgo" styleId="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'SolicitacaoCombinacaoEspecial_aActionForm.getRep_rzao_Ajax',new Array('rep_rzao')); fillFields(0,new Array('rep_cdgo'),'SolicitacaoCombinacaoEspecial_aActionForm.getCodigo_regional_Ajax',new Array('codigo_regional'));" styleClass="baseField" size="5"/>
                          <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                          <script type="text/javascript">
                            function lov_open_rep_cdgo() {
                              window.open('..//lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                            }
                          </script>
                          <span class="spamFormLabel">
                          </span>
                          <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Regional
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="codigo_regional" styleId="codigo_regional" onblur="fillFields(0,new Array('codigo_regional'),'SolicitacaoCombinacaoEspecial_aActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="disabled" tabindex="-1" readonly="true" size="5"/>
                          <span class="spamFormLabel">
                          </span>
                          <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Grupo Econômico
                            <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="gre_grupo" styleId="gre_grupo" onblur="fillFields(0,new Array('gre_grupo'),'SolicitacaoCombinacaoEspecial_aActionForm.getGre_descricao_Ajax',new Array('gre_descricao'));" styleClass="baseField" size="6" maxlength="6"/>
                          <input type="button" class="lovButton"  value="..." tabindex="-1" onclick="javascript:lov_open_gre_grupo()"  >
                          <script type="text/javascript">
                            function lov_open_gre_grupo() {
                              window.open('..//lov/LvGrupoEconomicoLov.do?resetfull_action=&returnBlock=0&return0=gre_grupo&return1=gre_descricao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                            }
                          </script>
                          <span class="spamFormLabel">
                          </span>
                          <html:text property="gre_descricao" styleId="gre_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="30"/>
                        </td>
                      </tr>

                    </table>
                    <br>
                  </div>

                  <table class="itemTable"  style="width:99%;">
                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Pares Negociação
                        </span>
                        <%
                        if((solicitacaoActionForm.getTipo_solicitacao()+"").equals("5")||(solicitacaoActionForm.getTipo_solicitacao()+"").equals("2")||(solicitacaoActionForm.getTipo_solicitacao()+"").equals("3")) {
                          %>
                          <bean:message key="jsp.fieldnotnull"/>
                          <%
                        }
                        %>
                      </td>
                      <td class="formField">
                        <html:text property="prs_negociacao" styleId="prs_negociacao" styleClass="baseField" size="10" maxlength="22"/>
                        <span class="spamFormLabel">
                          Pares Linha
                        </span>
                        <%
                        if((solicitacaoActionForm.getTipo_solicitacao()+"").equals("5")||(solicitacaoActionForm.getTipo_solicitacao()+"").equals("2")||(solicitacaoActionForm.getTipo_solicitacao()+"").equals("3")) {
                          %>
                          <bean:message key="jsp.fieldnotnull"/>
                          <%
                        }
                        %>
                        <html:text property="pares_linha" styleId="pares_linha" styleClass="baseField" size="10" maxlength="22"/>
                        <span class="spamFormLabel">
                          Pares Solicitados
                        </span>
                        <%
                        if((solicitacaoActionForm.getTipo_solicitacao()+"").equals("5")||(solicitacaoActionForm.getTipo_solicitacao()+"").equals("2")||(solicitacaoActionForm.getTipo_solicitacao()+"").equals("3")) {
                          %>
                          <bean:message key="jsp.fieldnotnull"/>
                          <%
                        }
                        %>
                        <html:text property="pares_alteracao" styleId="pares_alteracao" styleClass="baseField" size="10" maxlength="22"/>
                        <span class="spamFormLabel">
                          Preço Liquido
                        </span>
                        <%
                        if((solicitacaoActionForm.getTipo_solicitacao()+"").equals("5")||(solicitacaoActionForm.getTipo_solicitacao()+"").equals("2")||(solicitacaoActionForm.getTipo_solicitacao()+"").equals("3")) {
                          %>
                          <bean:message key="jsp.fieldnotnull"/>
                          <%
                        }
                        %>
                        <html:text property="preco_liguido" styleId="preco_liguido" styleClass="baseField" size="10" maxlength="22"/>
                      </td>
                    </tr>

                    <%
                    if(liberaAlteracaoSolicitada){
                      %>
                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            LL Alteração Solicitada
                          </span>
                          <%
                          if((solicitacaoActionForm.getTipo_solicitacao()+"").equals("5")||(solicitacaoActionForm.getTipo_solicitacao()+"").equals("2")||(solicitacaoActionForm.getTipo_solicitacao()+"").equals("3")) {
                            %>
                            <bean:message key="jsp.fieldnotnull"/>
                            <%
                          }
                          %>
                        </td>
                        <td class="formField">
                          <html:text property="ll_alteracao_solicitada" styleId="ll_alteracao_solicitada" styleClass="baseField" size="22" maxlength="22"/>
                        </td>
                      </tr>

                      <%
                    } else {
                      %>

                      <html:hidden property="ll_alteracao_solicitada" />

                      <%
                    }
                    %>
                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          CTF
                        </span>
                        <%
                        if((solicitacaoActionForm.getTipo_solicitacao()+"").equals("5")||(solicitacaoActionForm.getTipo_solicitacao()+"").equals("2")||(solicitacaoActionForm.getTipo_solicitacao()+"").equals("3")) {
                          %>
                          <bean:message key="jsp.fieldnotnull"/>
                          <%
                        }
                        %>
                      </td>
                      <td class="formField">
                        <html:text property="valor_fabricacao" styleId="valor_fabricacao" styleClass="baseField" size="10" maxlength="22"/>
                        <span class="spamFormLabel">
                          Preço Vendor
                        </span>
                        <%
                        if((solicitacaoActionForm.getTipo_solicitacao()+"").equals("5")||(solicitacaoActionForm.getTipo_solicitacao()+"").equals("2")||(solicitacaoActionForm.getTipo_solicitacao()+"").equals("3")) {
                          %>
                          <bean:message key="jsp.fieldnotnull"/>
                          <%
                        }
                        %>
                        <html:text property="preco_vendor" styleId="preco_vendor" styleClass="baseField" size="10" maxlength="22"/>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Imagem
                        </span>
                      </td>
                      <td class="formField">
                        <%
                        if(!(solicitacaoActionForm.getImagem_produto()+"").equals("")){
                          %>
                          <img src='../arquivos/solicitacao_especial/<%= solicitacaoActionForm.getImagem_produto() %>' style='cursor:pointer;width:100px;height:100px'  onclick="wopen('../com/SolicitacaoCombinacaoEspecial_imgForm.do?select_action=&id_solicitacao=<%= solicitacaoActionForm.getId_solicitacao() %>','_blank',800,600)" />
                          <br>
                          <%
                        }
                        %>
                        <html:file property="arquivo" styleId="arquivo" styleClass="baseField">
                        </html:file>
                        Tamanho máximo: 500kb
                      </td>
                    </tr>
                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Situação
                        </span>
                      </td>
                      <td class="formField">
                        <html:select property="situacao_solicitacao" styleId="situacao_solicitacao" styleClass="baseField" size="1">
                          <html:options property="situacao_solicitacaoList" labelProperty="situacao_solicitacaoLabelList" styleClass="baseOptions"/>
                        </html:select>
                      </td>
                    </tr>

                    <html:hidden property="data_aceite"/>
                    <html:hidden property="usuario_aceite"/>
                    <html:hidden property="imagem_produto"/>
                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Pedido (opcional)
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="pedido" styleId="pedido" styleClass="baseField"/>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Item
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="item" styleId="item" styleClass="disabled"/>
                        <input type="button" class="lovButton"  value="..."  onclick="if(document.forms[0].pedido.value==''){alert('Informe o Pedido');}else{javascript:lov_open_item()}"  >
                        <script type="text/javascript">
                          function lov_open_item() {
                            window.open('..//lov/LvItemPedidoLov.do?resetfull_action=&returnBlock=0&return0=item&return1=item_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                          }
                        </script>
                        <span class="spamFormLabel">
                        </span>
                        <html:text property="item_desc" styleId="item_desc" styleClass="disabled" readonly="true" size="100"/>
                      </td>
                    </tr>

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
                    <%
                    if(request.getAttribute("solicitacao")!=null){
                      %>
                      <script>
                        alert('A solicitação foi duplicada com sucesso! Novo ID gerado = <%= request.getAttribute("solicitacao") %>');
                      </script>

                      <%
                    }
                    %>
                    <html:hidden property="id_solicitacao_delete"/>
                    <html:hidden property="data_aprovacao"/>
                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="ref_grupo_posicao_fab" styleId="ref_grupo_posicao_fab" onblur="fillFields(0,new Array('cli_cdgo','codigo_marca','ref_grupo_posicao_fab'),'SolicitacaoCombinacaoEspecial_aActionForm.getCli_rzao_Ajax',new Array('cli_rzao','rep_cdgo','rep_rzao'));" style="visibility:hidden; height:0; line-height:0; max-height:0; max-width:0; min-height:0; min-width:0; width:0; z-index:-1000; text-align:start;" styleClass="baseField"/>
                      </td>
                    </tr>

                  </table>

                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:submit>
                        <html:submit accesskey="a" styleClass="baseButton" property="update_action">
                          <bean:message bundle="ApplicationResources" key="jsp.update"/>
                        </html:submit>

                        <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                          <bean:message bundle="ApplicationResources" key="jsp.back"/>
                        </html:submit>
                        <html:submit accesskey="l" styleClass="myhidden" property="refresh_action">
                          <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
                        </html:submit>
                        <html:submit value="Gerar Relatório" onclick="bloqueia();" styleClass="baseButton" property="relatorio_action">
                        </html:submit>
                        <html:submit accesskey="a" value="Duplicar Solicitação" onclick="return confirmSubmit('');" styleClass="baseButton" property="duplicar_action">
                        </html:submit>
                        <html:submit accesskey="a" styleClass="myhidden" property="delete_grade_action">
                          <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                        </html:submit>
                      </td>
                    </tr>
                  </table>

                  <script type="text/javascript">
                    jQuery(document).ready(function($) {
                      $("#data_aceite").mask("99/99/9999");
                      $("#data_entrega_amostra").mask("99/99/9999");
                      });
                    </script>
                  </html:form>
                </td>
              </tr>
            </table>

          </body>
        </center>
      </html>

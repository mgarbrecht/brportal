<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/DiarioCombinacaoEspecial_iActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = DiarioCombinacaoEspecial_iActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("id_solicitacao","ID");
    hashMapLabel.set("data_solicitacao","Data Solicitação");
    hashMapLabel.set("tipo_solicitacao","Tipo de solicitação");
    hashMapLabel.set("usuario_solicitacao","Usuário");
    hashMapLabel.set("codigo_marca","Marca");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("f_grade","");
    hashMapLabel.set("ref_cdgo","Ref.");
    hashMapLabel.set("ref_desc","");
    hashMapLabel.set("cab_cdgo","Cabedal");
    hashMapLabel.set("cab_desc","");
    hashMapLabel.set("cor_cdgo","Cor");
    hashMapLabel.set("cor_desc","");
    hashMapLabel.set("descricao","Descrição");
    hashMapLabel.set("observacao","Observação");
    hashMapLabel.set("material_cor1","Material e cor (Cabedal 1)");
    hashMapLabel.set("material_cor2","Material e cor (Cabedal 2)");
    hashMapLabel.set("material_cor3","Material e cor (Cabedal 3)");
    hashMapLabel.set("biqueira_debrum","Biqueira/debrum");
    hashMapLabel.set("capa_palmilha","Capa da Palmilha");
    hashMapLabel.set("cacharel","Cacharel");
    hashMapLabel.set("forro","Forro");
    hashMapLabel.set("metais","Metais");
    hashMapLabel.set("taloneira","Taloneira");
    hashMapLabel.set("salto","Salto");
    hashMapLabel.set("enfeite","Enfeite");
    hashMapLabel.set("carimbo_etiqueta","Carimbo/etiqueta");
    hashMapLabel.set("cli_cdgo","Cliente");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("gre_grupo","Grupo Econômico");
    hashMapLabel.set("gre_descricao","");
    hashMapLabel.set("prs_negociacao","Pares Negociação");
    hashMapLabel.set("pares_linha","Pares Linha");
    hashMapLabel.set("valor_pdv","PDV");
    hashMapLabel.set("preco_vendor","PV");
    hashMapLabel.set("pares_alteracao","Pares Alteração");
    hashMapLabel.set("preco_liguido","Preço Liquido");
    hashMapLabel.set("ll_alteracao_solicitada","LL Alteração Solicitada");
    hashMapLabel.set("valor_fabricacao","CTF");
    hashMapLabel.set("arquivo","Imagem");
    hashMapLabel.set("data_aceite","Data_aceite");
    hashMapLabel.set("usuario_aceite","Usuario_aceite");
    hashMapLabel.set("ll_0","LL Para Cliente 0%");
    hashMapLabel.set("ll_1","1%");
    hashMapLabel.set("ll_2","2%");
    hashMapLabel.set("ll_3","3%");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Diário de Combinações Especiais - Cadastro
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(138)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/DiarioCombinacaoEspecial_iForm.do" enctype="multipart/form-data" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <div class\='div10l'>
                        Todos os campos com
                        <img src='../img/required.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        devem ser preenchidos.
                      </div>
                    </div>
                    <html:errors property="data_solicitacao"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="ref_desc"/>
                    <html:errors property="cab_cdgo"/>
                    <html:errors property="cab_desc"/>
                    <html:errors property="cor_cdgo"/>
                    <html:errors property="cor_desc"/>
                    <html:errors property="descricao"/>
                    <html:errors property="observacao"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="gre_grupo"/>
                    <html:errors property="gre_descricao"/>
                    <html:errors property="prs_negociacao"/>
                    <html:errors property="valor_pdv"/>
                    <html:errors property="preco_vendor"/>
                    <html:errors property="preco_liguido"/>
                    <html:errors property="ll_alteracao_solicitada"/>
                    <html:errors property="valor_fabricacao"/>
                    <html:errors property="ll_0"/>
                    <html:errors property="ll_1"/>
                    <html:errors property="ll_2"/>
                    <html:errors property="ll_3"/>
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
                %>
                <html:hidden property="id_solicitacao"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Solicitação
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_solicitacao" styleClass="disabled" tabindex="-1" readonly="true" value="<%= dataAtual %>"/>
                  </td>
                </tr>

                <html:hidden property="tipo_solicitacao" value="11"/>
                <html:hidden property="usuario_solicitacao" value="<%= usuario %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="codigo_marca" styleId="codigo_marca" styleClass="baseField" size="1">
                      <html:options property="codigo_marcaList" labelProperty="codigo_marcaLabelList" styleClass="baseOptions"/>
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

                    <html:text property="lin_cdgo" styleId="lin_cdgo" onblur="fillFields(0,new Array('lin_cdgo'),'DiarioCombinacaoEspecial_iActionForm.getLin_nome_Ajax',new Array('lin_nome'));" styleClass="baseField" size="7" maxlength="22"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_lin_cdgo()"  >

                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('..//lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>




                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_nome" styleId="lin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="25"/>
                  </td>
                </tr>

                <%
                if(false){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      Grade
                    </td>
                    <td class="formField">
                      <%
                      if(session.getAttribute("v_numeracao")==null){
                        %>
                        <input type="button" class="lovButton" value="Informar Grade"  onclick="if(document.forms[0].lin_cdgo.value==''){alert('Informe a linha!');}else{wopen('../com/DiarioCombinacaoEspecial_gForm.do?select1_action=&lin_cdgo1='+document.forms[0].lin_cdgo.value,'_blank',640,110)}"  >
                        <%
                      }
                      %>
                      <%
                      if(session.getAttribute("v_numeracao")!=null){
                        %>

                        <table>
                          <tr>
                            <td>

                              <table border="2">
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
                                <input type="button" class="lovButton" tabindex="-1" value="Alterar Grade"  onclick="if(document.forms[0].lin_cdgo.value==''){alert('Informe a linha!');}else{wopen('../com/DiarioCombinacaoEspecial_gForm.do?select1_action=&lin_cdgo1='+document.forms[0].lin_cdgo.value,'_blank',640,110)}"  >
                              </td>
                            </tr>
                          </table>
                          <%
                        }
                        %>


                      </td>
                    </tr>


                    <%
                  }
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Ref.
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="ref_cdgo" styleId="ref_cdgo" onblur="fillFields(0,new Array('lin_cdgo','ref_cdgo'),'DiarioCombinacaoEspecial_iActionForm.getRef_desc_Ajax',new Array('ref_desc'));" styleClass="baseField" size="6"/>
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
                      <html:text property="cab_cdgo" styleId="cab_cdgo" onblur="fillFields(0,new Array('cab_cdgo'),'DiarioCombinacaoEspecial_iActionForm.getCab_desc_Ajax',new Array('cab_desc'));" styleClass="baseField" size="5" maxlength="22"/>
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
                      <html:text property="cor_cdgo" styleId="cor_cdgo" onblur="fillFields(0,new Array('cor_cdgo'),'DiarioCombinacaoEspecial_iActionForm.getCor_desc_Ajax',new Array('cor_desc'));" styleClass="baseField" size="6" maxlength="22"/>
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
                        Descrição
                      </span>
                    </td>
                    <td class="formField">
                      <html:textarea property="descricao" styleId="descricao" styleClass="baseField" cols="50" rows="2"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Observação
                      </span>
                    </td>
                    <td class="formField">
                      <html:textarea property="observacao" styleId="observacao" styleClass="baseField" cols="80" rows="5"/>
                    </td>
                  </tr>

                  <html:hidden property="material_cor1"/>
                  <html:hidden property="material_cor2"/>
                  <html:hidden property="material_cor3"/>
                  <html:hidden property="biqueira_debrum"/>
                  <html:hidden property="capa_palmilha"/>
                  <html:hidden property="cacharel"/>
                  <html:hidden property="forro"/>
                  <html:hidden property="metais"/>
                  <html:hidden property="taloneira"/>
                  <html:hidden property="salto"/>
                  <html:hidden property="enfeite"/>
                  <html:hidden property="carimbo_etiqueta"/>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Cliente
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="cli_cdgo" styleId="cli_cdgo" onblur="fillFields(0,new Array('cli_cdgo'),'DiarioCombinacaoEspecial_iActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));" styleClass="baseField" size="10" maxlength="22"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cli_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_cli_cdgo() {
                          window.open('..//lov/LvClienteLov.do?resetfull_action=&returnBlock=0&return0=cli_cdgo&return1=cli_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="cli_rzao" styleId="cli_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="55" maxlength="50"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Representante
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="rep_cdgo" styleId="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'DiarioCombinacaoEspecial_iActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="5"/>
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
                        Grupo Econômico
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="gre_grupo" styleId="gre_grupo" onblur="fillFields(0,new Array('gre_grupo'),'DiarioCombinacaoEspecial_iActionForm.getGre_descricao_Ajax',new Array('gre_descricao'));" styleClass="baseField" size="6" maxlength="6"/>
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

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Pares Negociação
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="prs_negociacao" styleId="prs_negociacao" styleClass="baseField" size="10" maxlength="22"/>
                      <html:hidden property="pares_linha"/>
                      <span class="spamFormLabel">
                        PDV
                      </span>
                      <html:text property="valor_pdv" styleId="valor_pdv" styleClass="baseField" size="10" maxlength="22"/>
                      <span class="spamFormLabel">
                        PV
                      </span>
                      <html:text property="preco_vendor" styleId="preco_vendor" styleClass="baseField" size="10" maxlength="22"/>
                      <html:hidden property="pares_alteracao"/>
                      <span class="spamFormLabel">
                        Preço Liquido
                      </span>
                      <html:text property="preco_liguido" styleId="preco_liguido" styleClass="baseField" size="10" maxlength="22"/>
                    </td>
                  </tr>

                  <%
                  if(false){
                    // if(liberaAlteracaoSolicitada){
                      %>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            LL Alteração Solicitada
                          </span>
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
                      </td>
                      <td class="formField">
                        <html:text property="valor_fabricacao" styleId="valor_fabricacao" styleClass="baseField" size="10" maxlength="22"/>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Imagem
                        </span>
                      </td>
                      <td class="formField">
                        <html:file property="arquivo" styleId="arquivo" styleClass="baseField">
                        </html:file>
                        <span class='validateMessageuser'>
                          Tamanho máximo: 500kb
                        </span>
                      </td>
                    </tr>

                    <html:hidden property="data_aceite"/>
                    <html:hidden property="usuario_aceite"/>
                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          LL Para Cliente 0%
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="ll_0" styleId="ll_0" styleClass="baseField" size="10" maxlength="22"/>
                        <span class="spamFormLabel">
                          1%
                        </span>
                        <html:text property="ll_1" styleId="ll_1" styleClass="baseField" size="10" maxlength="22"/>
                        <span class="spamFormLabel">
                          2%
                        </span>
                        <html:text property="ll_2" styleId="ll_2" styleClass="baseField" size="10" maxlength="22"/>
                        <span class="spamFormLabel">
                          3%
                        </span>
                        <html:text property="ll_3" styleId="ll_3" styleClass="baseField" size="10" maxlength="22"/>
                      </td>
                    </tr>

                  </table>

                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:submit accesskey="i" styleClass="baseButton" property="insert_action">
                          <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                        </html:submit>
                        <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                          <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                        </html:submit>
                        <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                          <bean:message bundle="ApplicationResources" key="jsp.back"/>
                        </html:submit>
                        <html:submit styleClass="myhidden" property="refresh_action">
                          <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
                        </html:submit>
                      </td>
                    </tr>
                  </table>

                  <script type="text/javascript">
                    jQuery(document).ready(function($) {
                      $("#data_solicitacao").mask("99/99/9999");
                      $("#data_aceite").mask("99/99/9999");
                      });
                    </script>
                  </html:form>
                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["lin_cdgo"];
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

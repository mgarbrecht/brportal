<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/Dev0002ActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = Dev0002ActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("f_free","");
    hashMapLabel.set("situacao","Situação");
    hashMapLabel.set("marca","Marca");
    hashMapLabel.set("tipo_preco","Tipo de Preço");
    hashMapLabel.set("nfs_nmro","Nota Fiscal");
    hashMapLabel.set("fil_filial","Filial");
    hashMapLabel.set("fil_razsoc","");
    hashMapLabel.set("livro_alternativo","Usar Livro Alternativo?");
    hashMapLabel.set("atraso_fim","Nro Dias na Transp. (Mín)");
    hashMapLabel.set("atraso","Nro Dias na Transp. (Max)");
    hashMapLabel.set("f_regi","");
    hashMapLabel.set("reg","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("f_regf","");
    hashMapLabel.set("f_repi","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("f_repif","");
    hashMapLabel.set("unn_codigo","Unid. Negócio");
    hashMapLabel.set("unn_descri","");
    hashMapLabel.set("cli_cdgo","Cliente");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("gre_grupo","Grupo Econômico");
    hashMapLabel.set("gre_descricao","");
    hashMapLabel.set("exibe_cliente","Cliente/Rep.");
    hashMapLabel.set("exibe_rep","");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("aberto_fechado","Aberto/Fechado");
    hashMapLabel.set("tra_cdgo","Transportadora");
    hashMapLabel.set("tra_nome","");
    hashMapLabel.set("tipo_relatorio","Tipo Relatório");
    hashMapLabel.set("cb_agrupado","Agrupado");
    hashMapLabel.set("abre_automaticamente","Abre o Relatório Automaticamente");
    hashMapLabel.set("mensagem","");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Relatório de Mercadoria na Transportadora
    </title>
  </head>
  <center>
    <body onload="if('<%= (String)request.getAttribute("arquivo") %>' == 'null'){document.forms[0].abre_automaticamente.checked=false;document.forms[0].mensagem.value='';}if(document.forms[0].abre_automaticamente.checked==true){if('<%= (String)request.getAttribute("arquivo") %>' != 'null'){window.open('<%= (String)request.getAttribute("arquivo") %>','_blank');}};document.forms[0].cb_agrupado.checked=false;document.forms[0].cb_agrupado.disabled=true;">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(141)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/Dev0002Form.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="situacao"/>
                    <html:errors property="marca"/>
                    <html:errors property="tipo_preco"/>
                    <html:errors property="nfs_nmro"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="fil_razsoc"/>
                    <html:errors property="livro_alternativo"/>
                    <html:errors property="atraso_fim"/>
                    <html:errors property="atraso"/>
                    <html:errors property="reg"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="unn_codigo"/>
                    <html:errors property="unn_descri"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="gre_grupo"/>
                    <html:errors property="gre_descricao"/>
                    <html:errors property="exibe_cliente"/>
                    <html:errors property="exibe_rep"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="aberto_fechado"/>
                    <html:errors property="tra_cdgo"/>
                    <html:errors property="tra_nome"/>
                    <html:errors property="tipo_relatorio"/>
                    <html:errors property="cb_agrupado"/>
                    <html:errors property="abre_automaticamente"/>
                    <html:errors property="mensagem"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String codigo_regional="";
                String codigo_representante="";
                String tipo="";
                acesso.Usuario u = new acesso.Usuario();
                u = (acesso.Usuario)session.getAttribute("User");
                acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
                acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

                if(!(u.getEntidadeNegocio()==null)){
                  ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                  tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
                  tipo = tipoent.getTipo()+"";
                  if(tipo.equals("REGIONAL DE VENDA")){
                    codigo_regional = ent.getChave()+"";
                  }
                  if((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))){
                    codigo_representante = ent.getChave()+"";
                  }

                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situação
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="situacao" styleClass="baseField" size="1">
                      <html:options property="situacaoList" labelProperty="situacaoLabelList" styleClass="baseOptions"/>
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
                    <html:select property="marca" styleClass="baseField" size="1">
                      <html:options property="marcaList" labelProperty="marcaLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo de Preço
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo_preco" styleClass="baseField" size="1">
                      <html:options property="tipo_precoList" labelProperty="tipo_precoLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nota Fiscal
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="nfs_nmro" styleId="nfs_nmro" styleClass="baseField" size="20"/>
                    <span class='validateMessageuser'>
                      Separadas por vírgula
                    </span>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Filial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fil_filial" styleId="fil_filial" onblur="fillFields(0,new Array('fil_filial'),'Dev0002ActionForm.getFil_razsoc_Ajax',new Array('fil_razsoc'));" styleClass="baseField" size="4"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fil_filial()"  >
                    <script type="text/javascript">
                      function lov_open_fil_filial() {
                        window.open('..//lov/LvFilialLov.do?resetfull_action=&returnBlock=0&return0=fil_filial&return1=fil_razsoc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="fil_razsoc" styleId="fil_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="50" maxlength="50"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Usar Livro Alternativo?
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="livro_alternativo" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="94">
                        Sim
                      </html:option>
                      <html:option styleClass="baseOption" value="0">
                        Não
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nro Dias na Transp. (Mín)
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="atraso_fim" styleClass="baseField" value="0" size="5"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nro Dias na Transp. (Max)
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="atraso" styleClass="baseField" value="30" size="5"/>
                  </td>
                </tr>

                <%
                if(codigo_regional.equals("")) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Regional
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="reg" onblur="fillFields(0,new Array('reg'),'Dev0002ActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="baseField" size="3" maxlength="3"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_reg()"  >
                      <script type="text/javascript">
                        function lov_open_reg() {
                          window.open('../lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=reg&return1=nome_regional','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="reg" value="<%= codigo_regional %>"/>

                  <%
                }
                %>
                <%
                if(codigo_representante.equals("")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Representante
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'Dev0002ActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="5" maxlength="5"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_rep_cdgo() {
                          window.open('../lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="38" maxlength="35"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="rep_cdgo" value="<%= codigo_representante %>"/>
                  <html:hidden property="rep_rzao"/>

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Unid. Negócio
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="unn_codigo" onblur="fillFields(0,new Array('unn_codigo'),'Dev0002ActionForm.getUnn_descri_Ajax',new Array('unn_descri'));" styleClass="baseField" size="3" maxlength="3"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_unn_codigo()"  >
                    <script type="text/javascript">
                      function lov_open_unn_codigo() {
                        window.open('../lov/LvUnidadeNegocioLov.do?resetfull_action=&returnBlock=0&return0=unn_codigo&return1=unn_descri','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="unn_descri" styleId="unn_descri" styleClass="disabled" tabindex="-1" readonly="true" size="50" maxlength="50"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cliente
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_cdgo" onblur="fillFields(0,new Array('cli_cdgo'),'Dev0002ActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));" styleClass="baseField" size="10" maxlength="22"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cli_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_cli_cdgo() {
                        window.open('../lov/LvClienteLov.do?resetfull_action=&returnBlock=0&return0=cli_cdgo&return1=cli_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cli_rzao" styleId="cli_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Grupo Econômico
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="gre_grupo" onblur="fillFields(0,new Array('gre_grupo'),'Dev0002ActionForm.getGre_descricao_Ajax',new Array('gre_descricao'));" styleClass="baseField" size="6" maxlength="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_gre_grupo()"  >
                    <script type="text/javascript">
                      function lov_open_gre_grupo() {
                        window.open('../lov/LvGrupoEconomicoLov.do?resetfull_action=&returnBlock=0&return0=gre_grupo&return1=gre_descricao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
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
                      Cliente/Rep.
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="exibe_cliente" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="S">
                        Sim
                      </html:option>
                      <html:option styleClass="baseOption" value="N">
                        Não
                      </html:option>
                    </html:select>
                    <span class="spamFormLabel">
                    </span>
                    <html:select property="exibe_rep" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="S">
                        Sim
                      </html:option>
                      <html:option styleClass="baseOption" value="N">
                        Não
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" onblur="fillFields(0,new Array('lin_cdgo'),'Dev0002ActionForm.getLin_nome_Ajax',new Array('lin_nome'));" styleClass="baseField" size="6" maxlength="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('../lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_nome" styleId="lin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="25"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Aberto/Fechado
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="aberto_fechado" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="t">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="a">
                        Aberto
                      </html:option>
                      <html:option styleClass="baseOption" value="f">
                        Fechado
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Transportadora
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="tra_cdgo" onblur="fillFields(0,new Array('tra_cdgo'),'Dev0002ActionForm.getTra_nome_Ajax',new Array('tra_nome'));" styleClass="baseField" size="4" maxlength="4"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_tra_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_tra_cdgo() {
                        window.open('../lov/LvTransportadoraLov.do?resetfull_action=&returnBlock=0&return0=tra_cdgo&return1=tra_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="tra_nome" styleId="tra_nome" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo Relatório
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo_relatorio" styleId="tipo_relatorio" onchange="if(this.value=='pdf'){document.forms[0].cb_agrupado.checked=false;document.forms[0].cb_agrupado.disabled=true;}else{document.forms[0].cb_agrupado.disabled=false;}" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="pdf">
                        PDF
                      </html:option>
                      <html:option styleClass="baseOption" value="excel">
                        EXCEL
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Agrupado
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_agrupado" styleId="cb_agrupado" styleClass="baseField" value="checked"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Abre o Relatório Automaticamente
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="abre_automaticamente" onclick="if(this.checked==true){mensagem.value='Obs.: Uma nova janela será aberta para a visualização do relatório.';}else{mensagem.value='';}" styleClass="baseField" value="checked"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="mensagem" style="background-color:transparent; border-style:none; color:red; background-color:transparent; border-style:none; cursor:default; text-align:start;" styleClass="baseField" readonly="true" size="70" maxlength="70"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
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
                    if((String)request.getAttribute("abre_automaticamente")=="X"){
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
                        <html:button accesskey="p" onclick="bloqueia();resetfull1_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:button>
                        <script>
                          function getKeySite(keyStroke) {
                            isNetscape=(document.layers);
                            eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                            which = String.fromCharCode(eventChooser).toLowerCase();
                            keyBuffer = which;
                            if(eventChooser == 13){ bloqueia();
                          if(document.forms[0].select1_action.disabled==true){return false;}
                          document.forms[0].select1_action.disabled=true;
                          document.forms[0].resetfull1_action.disabled=true;
                          document.forms[0].select_action.click();
                        }
                      }
                    </script>
                    <SCRIPT>
                      document.onkeypress = getKeySite;
                      </SCRIPT><html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                      <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                      <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                      </td>
                      </tr>
                      </table>

                      </html:form><script type="text/javascript">
                      var focusControl = document.forms[0].elements["situacao"];
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/CodigoBarrasActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = CodigoBarrasActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("tipo","Tipo");
    hashMapLabel.set("codigo_marca","Marca");
    hashMapLabel.set("descricao_marca","");
    hashMapLabel.set("lin_cdgo","CodigoBarra.lin_cdgo");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("cod_refer","CodigoBarra.cod_refer");
    hashMapLabel.set("ref_desc","");
    hashMapLabel.set("cabedal","CodigoBarra.cabedal");
    hashMapLabel.set("cab_desc","");
    hashMapLabel.set("cor","CodigoBarra.cor");
    hashMapLabel.set("cor_desc","");
    hashMapLabel.set("cli_cdgo","Cliente");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("ean13","EAN13");
    hashMapLabel.set("grade","Grade");
    hashMapLabel.set("status","CodigoBarra.status");
    hashMapLabel.set("ref_cdgo","");
    hashMapLabel.set("ano_fatura_proforma","Ano Fatura Proforma");
    hashMapLabel.set("numero_fatura_proforma","Número Fatura Proforma");
    hashMapLabel.set("trazer_pares","Trazer Pares Fatura");
    hashMapLabel.set("trazer_precos","Trazer Preços Fatura");
    hashMapLabel.set("f_amostra_i","");
    hashMapLabel.set("ano_fatura_amostra","Ano Fatura Amostra");
    hashMapLabel.set("numero_fatura_amostra","Número Fatura Amostra");
    hashMapLabel.set("f_amostra_f","");
    hashMapLabel.set("pedido","Pedido<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("lote","Lote<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("organizar_loja","Organizar por Loja");
    hashMapLabel.set("organizar_produto_grade","Organizar por Produto e Grade");
    hashMapLabel.set("focus","");
    hashMapLabel.set("gerarImagem","Gerar Imagem?");
    hashMapLabel.set("agrupar_modelo","Agrupar Lin/Ref/Cabedal?");
    hashMapLabel.set("excel","f_excel");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
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
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(262)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/CodigoBarrasForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <div class\='div10l'>
                        Um dos campos com
                        <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        deve ser preenchido.
                      </div>
                    </div>
                    <html:errors property="tipo"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="descricao_marca"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="cod_refer"/>
                    <html:errors property="ref_desc"/>
                    <html:errors property="cabedal"/>
                    <html:errors property="cab_desc"/>
                    <html:errors property="cor"/>
                    <html:errors property="cor_desc"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="ean13"/>
                    <html:errors property="grade"/>
                    <html:errors property="status"/>
                    <html:errors property="ano_fatura_proforma"/>
                    <html:errors property="numero_fatura_proforma"/>
                    <html:errors property="trazer_pares"/>
                    <html:errors property="trazer_precos"/>
                    <html:errors property="ano_fatura_amostra"/>
                    <html:errors property="numero_fatura_amostra"/>
                    <html:errors property="pedido"/>
                    <html:errors property="lote"/>
                    <html:errors property="organizar_loja"/>
                    <html:errors property="organizar_produto_grade"/>
                    <html:errors property="gerarImagem"/>
                    <html:errors property="agrupar_modelo"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_cod_barra"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String tipo = null;
                boolean liberarTrazerPares = false;
                boolean liberarTrazerPrecos = false;
                portalbr.com.CodigoBarrasActionForm codigoBarrasActionForm = (portalbr.com.CodigoBarrasActionForm)session.getAttribute("CodigoBarrasActionForm");
                tipo = codigoBarrasActionForm.getTipo()!=null?codigoBarrasActionForm.getTipo():"ean13";
                acesso.Sessao sessao = new acesso.Sessao(session);
                util.consultas.Query query = new util.consultas.Query();
                String liberar = query.retorna("select 1 from wbrio.parametros where par_sist_codigo = 'BRNET' and nome = 'usuario_trazer_pares_ean13'and valor = '"+sessao.getUsuario()+"'");
                String liberarPrecos = query.retorna("select 1 from wbrio.parametros where par_sist_codigo = 'BRNET' and nome = 'usuario_trazer_precos_ean13'and valor = '"+sessao.getUsuario()+"'");
                //   if(liberar.equals("1")) {
                  liberarTrazerPares = true;
                //   }
                //   if(liberarPrecos.equals("1")) {
                  liberarTrazerPrecos = true;
                //   }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo" styleId="tipo" onchange="refresh_action.click();" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="ean13">
                        EAN13
                      </html:option>
                      <html:option styleClass="baseOption" value="dun14">
                        DUN14
                      </html:option>
                      <html:option styleClass="baseOption" value="sscc">
                        SSCC
                      </html:option>
                      <html:option styleClass="baseOption" value="ambos">
                        EAN13 + DUN14
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <%
                if(tipo.equalsIgnoreCase("ean13")||tipo.equalsIgnoreCase("ambos")){
                  %>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Marca
                      </span>
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </td>
                    <td class="formField">
                      <html:text property="codigo_marca" styleId="codigo_marca" onblur="fillFields(0,new Array('codigo_marca'),'CodigoBarrasActionForm.getDescricao_marca_Ajax',new Array('descricao_marca'));" styleClass="baseField" size="3"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_marca()"  >
                      <script type="text/javascript">
                        function lov_open_codigo_marca() {
                          window.open('..//lov/LvMarcaLov.do?resetfull_action=&returnBlock=0&return0=codigo_marca&return1=descricao_marca','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>

                      <%
                    } else {
                      %>

                      <html:hidden property="codigo_marca" />

                      <%
                    }
                    %>
                    <%
                    if(tipo.equalsIgnoreCase("ean13")||tipo.equalsIgnoreCase("ambos")){
                      %>

                      <span class="spamFormLabel">
                      </span>
                      <html:text property="descricao_marca" styleId="descricao_marca" styleClass="disabled" tabindex="-1" readonly="true" size="35"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="descricao_marca" />

                  <%
                }
                %>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="CodigoBarra.lin_cdgo"/>
                    </span>

                    <%
                    if(!tipo.equals("sscc")){
                      %>
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      <%
                    }
                    %>


                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" onblur="if(this.value!=''){fillFields(0,new Array('lin_cdgo'),'CodigoBarrasActionForm.getLin_nome_Ajax',new Array('lin_nome'))}else{lin_nome.value=''};" styleClass="baseField" size="7" />
                    <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('../lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_nome" styleId="lin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="28" maxlength="25"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="CodigoBarra.cod_refer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cod_refer" onblur="if(this.value!=''){fillFields(0,new Array('lin_cdgo','cod_refer'),'CodigoBarrasActionForm.getRef_desc_Ajax',new Array('ref_desc'))}else{ref_desc.value=''};" styleClass="baseField" size="7"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cod_refer()"  >
                    <script type="text/javascript">
                      function lov_open_cod_refer() {
                        window.open('../lov/LvRefLov.do?resetfull_action=&returnBlock=0&return0=cod_refer&return1=ref_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="ref_desc" styleId="ref_desc" onblur="fillFields(0,new Array('lin_cdgo','ref_desc'),'CodigoBarrasActionForm.getRef_desc_Ajax',new Array('ref_desc'));" styleClass="disabled" tabindex="-1" readonly="true" size="28" maxlength="25"/>
                  </td>
                </tr>

                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      <bean:message bundle="ComercialResources" key="CodigoBarra.cabedal"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cabedal" styleClass="baseField" onblur="if(this.value!=''){fillFields(0,new Array('cabedal'),'CodigoBarrasActionForm.getCab_desc_Ajax',new Array('cab_desc'))}else{cab_desc.value=''};" size="7" />
                    <input type="button" class="lovButton" value="..." tabindex="-1" onclick="ref_cdgo.value=cod_refer.value;window.open('../lov/LvCabedalLov.do?resetfull_action=&returnBlock=0&return0=cabedal&return1=cab_desc','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cab_desc" styleId="cab_desc" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="CodigoBarra.cor"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cor" onblur="if(this.value!=''){fillFields(0,new Array('cor'),'CodigoBarrasActionForm.getCor_desc_Ajax',new Array('cor_desc'))}else{cor_desc.value=''};" styleClass="baseField" size="7"/>
                    <input type="button" class="lovButton"  value="..." tabindex="-1" onclick="javascript:lov_open_cor()"  >
                    <script type="text/javascript">
                      function lov_open_cor() {
                        window.open('../lov/LvCorLov.do?resetfull_action=&returnBlock=0&return0=cor&return1=cor_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cor_desc" styleId="cor_desc" styleClass="disabled" tabindex="-1" readonly="true" size="33" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cliente
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_cdgo" styleId="cli_cdgo" onblur="fillFields(0,new Array('cli_cdgo'),'CodigoBarrasActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));" styleClass="baseField" size="7"/>
                    <input type="button" class="lovButton"  value="..." tabindex="-1" onclick="javascript:lov_open_cli_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_cli_cdgo() {
                        window.open('..//lov/LvClienteLov.do?resetfull_action=&returnBlock=0&return0=cli_cdgo&return1=cli_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cli_rzao" styleId="cli_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="50"/>
                  </td>
                </tr>

                <%
                if(tipo.equals("ean13")) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        EAN13
                      </span>
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </td>
                    <td class="formField">
                      <html:text property="ean13" styleId="ean13" styleClass="baseField"/>
                    </td>
                  </tr>
                  <%
                } else {
                  %>
                  <html:hidden property="ean13" />
                  <%
                }
                %>

                <%
                if(tipo.equalsIgnoreCase("dun14")){
                  %>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Grade
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="grade" styleId="grade" styleClass="baseField" size="3"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="grade" />

                  <%
                }
                %>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="CodigoBarra.status"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="status" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="">
                        <bean:message bundle="ComercialResources" key="CodigoBarra.todas"/>
                      </html:option>
                      <html:option styleClass="baseOption" value="A">
                        <bean:message bundle="ComercialResources" key="CodigoBarra.ativas"/>
                      </html:option>
                      <html:option styleClass="baseOption" value="I">
                        <bean:message bundle="ComercialResources" key="CodigoBarra.inativas"/>
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <html:hidden property="ref_cdgo"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Ano Fatura Proforma
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="ano_fatura_proforma" styleId="ano_fatura_proforma" styleClass="baseField" size="4"/>
                  </td>
                </tr>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Número Fatura Proforma
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="numero_fatura_proforma" styleId="numero_fatura_proforma" styleClass="baseField" size="4"/>
                  </td>
                </tr>

                <%
                if(tipo.equalsIgnoreCase("ean13") && liberarTrazerPares) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Trazer Pares Fatura
                      </span>
                    </td>
                    <td class="formField">
                      <html:checkbox property="trazer_pares" styleId="trazer_pares" styleClass="baseField" value="1"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="trazer_pares" value="0" />

                  <%
                }
                %>
                <%
                if((tipo.equalsIgnoreCase("dun14") || tipo.equalsIgnoreCase("ean13") || tipo.equalsIgnoreCase("ambos")) && liberarTrazerPrecos) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Trazer Preços Fatura
                      </span>
                    </td>
                    <td class="formField">
                      <html:checkbox property="trazer_precos" styleId="trazer_precos" styleClass="baseField" value="1"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="trazer_precos" value="0" />

                  <%
                }
                %>
                <%
                if(!tipo.equalsIgnoreCase("sscc")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Ano Fatura Amostra
                      </span>
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </td>
                    <td class="formField">
                      <html:text property="ano_fatura_amostra" styleId="ano_fatura_amostra" styleClass="baseField" size="4"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Número Fatura Amostra
                      </span>
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </td>
                    <td class="formField">
                      <html:text property="numero_fatura_amostra" styleId="numero_fatura_amostra" styleClass="baseField" size="4"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="ano_fatura_amostra" />
                  <html:hidden property="numero_fatura_amostra" />

                  <%
                }
                %>
                <%
                if(tipo.equalsIgnoreCase("sscc")||tipo.equalsIgnoreCase("ean13")||tipo.equalsIgnoreCase("dun14")||tipo.equalsIgnoreCase("ambos")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Pedido
                        <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      </span>
                    </td>
                    <td class="formField">
                      <html:textarea property="pedido" styleId="pedido" styleClass="baseField" cols="60" rows="4"/>
                    </td>
                  </tr>
                  <%
                } else {
                  %>

                  <html:hidden property="pedido" />

                  <%
                }
                %>


                <%
                if(tipo.equalsIgnoreCase("ean13")) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Lote
                        <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="lote" styleId="lote" styleClass="baseField" size="10"/>
                    </td>
                  </tr>
                  <%
                } else {
                  %>

                  <html:hidden property="lote" />

                  <%
                }
                %>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Organizar por Loja
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="organizar_loja" styleId="organizar_loja" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="N\"selected='selected'">
                        Não
                      </html:option>
                      <html:option styleClass="baseOption" value="S">
                        Sim
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Organizar por Produto e Grade
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="organizar_produto_grade" styleId="organizar_produto_grade" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="N">
                        Não
                      </html:option>
                      <html:option styleClass="baseOption" value="S">
                        Sim
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <%
                if(tipo.equalsIgnoreCase("dun14")) {
                  %>

                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["lin_cdgo"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>

                  <%
                } else {
                  %>

                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["codigo_marca"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>

                  <%
                }
                %>
                <%
                if(!tipo.equalsIgnoreCase("sscc")) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Gerar Imagem?
                      </span>
                    </td>
                    <td class="formField">
                      <html:checkbox property="gerarImagem" styleId="gerarImagem" styleClass="baseField" value="checked"/>
                    </td>
                  </tr>


                  <%
                } else {
                  %>

                  <html:hidden property="gerarImagem" />

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Agrupar Lin/Ref/Cabedal?
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="agrupar_modelo" styleId="agrupar_modelo" styleClass="baseField" value="checked"/>
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
                  <html:submit accesskey="l" styleClass="myhidden" property="refresh_action"><bean:message bundle="ApplicationResources" key="jsp.refresh"/></html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form><script type="text/javascript">
                  var focusControl = document.forms[0].elements["tipo"];
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

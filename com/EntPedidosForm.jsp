<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/EntPedidosActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = EntPedidosActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("numero_pedido","EntPedidosForm.numero_pedido");
    hashMapLabel.set("codigo_cliente","Cliente");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("estabelecimento_cliente","Estabelecimento_cliente");
    hashMapLabel.set("data_pedido","Data pedido");
    hashMapLabel.set("nome_planilha","Observação");
    hashMapLabel.set("status","Status");
    hashMapLabel.set("tem_alteracao","");
    hashMapLabel.set("pos","");
    hashMapLabel.set("_ge_navigator","");
    hashMapLabel.set("gridCheckField","");
    hashMapLabel.set("numero_pedido1","Numero_pedido");
    hashMapLabel.set("numero_item","Seq.");
    hashMapLabel.set("codigo_linha","Linha");
    hashMapLabel.set("codigo_referencia","Ref.");
    hashMapLabel.set("codigo_corrugado","Codigo_corrugado");
    hashMapLabel.set("codigo_cabedal","Cabedal");
    hashMapLabel.set("descricao_item","Descrição");
    hashMapLabel.set("codigo_cor","Cor");
    hashMapLabel.set("codigo_grade","Grade");
    hashMapLabel.set("quantidade_pares","Qtd. Pares");
    hashMapLabel.set("preco_unitario","Preco");
    hashMapLabel.set("registro_banco","registro_banco");
    hashMapLabel.set("registro_alterado","");
    hashMapLabel.set("loja_cliente","loja_cliente");
    hashMapLabel.set("descricao_erro","Descricao_erro");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Entrada de Pedidos
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
                  <script type="text/javascript" src="../script/thickbox.js">
                  </script>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(172)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>


                </td>

              </tr>

            </table>

            <link type="text/css" href="../css/jquery-ui-1.7.1.custom.css" rel="Stylesheet" />
            <script type="text/javascript" src="../script/jquery-ui-1.7.1.custom.min.js">
            </script>

            <style type="text/css">






              .fg-button { outline: 0; margin:0 4px 0 0; padding: .4em 1em; text-decoration:none !important; cursor:pointer; position: relative; text-align: center; zoom: 1; } .fg-button .ui-icon { position: absolute; top: 50%; margin-top: -8px; left: 50%; margin-left: -8px; } a.fg-button { float:left; } /* remove extra button width in IE */ button.fg-button { width:auto; overflow:visible; } .fg-button-icon-left { padding-left: 2.1em; } .fg-button-icon-right { padding-right: 2.1em; } .fg-button-icon-left .ui-icon { right: auto; left: .2em; margin-left: 0; } .fg-button-icon-right .ui-icon { left: auto; right: .2em; margin-left: 0; } .fg-button-icon-solo { display:block; width:8px; text-indent: -9999px; } /* solo icon buttons must have block properties for the text-indent to work */ .fg-buttonset { float:left; } .fg-buttonset .fg-button { float: left; } .fg-buttonset-single .fg-button, .fg-buttonset-multi .fg-button { margin-right: -1px;} .fg-toolbar { padding: .5em; margin: 0; } .fg-toolbar .fg-buttonset { margin-right:1.5em; padding-left: 1px; } .fg-toolbar .fg-button { font-size: 1em; } /*demo page css*/ h2 { clear: both; padding-top:1.5em; margin-top:0; } .strike { text-decoration: line-through; }
            </style>


            <script type="text/javascript">
              jQuery(function(){
                //all hover and click logic for buttons
                jQuery(".fg-button:not(.ui-state-disabled)")
                .hover(
                function(){
                  jQuery(this).addClass("ui-state-hover");
                  },
                  function(){
                    jQuery(this).removeClass("ui-state-hover");
                  }
                  )
                  .mousedown(function(){
                    jQuery(this).parents('.fg-buttonset-single:first').find(".fg-button.ui-state-active").removeClass("ui-state-active");
                  if( jQuery(this).is('.ui-state-active.fg-button-toggleable, .fg-buttonset-multi .ui-state-active') ){ $(this).removeClass("ui-state-active"); }
                else { jQuery(this).addClass("ui-state-active"); }
                })
                .mouseup(function(){
                  if(! jQuery(this).is('.fg-button-toggleable, .fg-buttonset-single .fg-button,  .fg-buttonset-multi .fg-button') ){
                    jQuery(this).removeClass("ui-state-active");
                  }
                  });
                  });
                </script>

                <html:form action="com/EntPedidosForm.do" method="post" styleClass="baseForm">
                  <table class="messageTable" style='width:99%;'>
                    <tr class="messageTr" >
                      <td class="messageTd">
                        <bean:message key="div.campos*"/>
                        <html:errors property="numero_pedido"/>
                        <html:errors property="codigo_cliente"/>
                        <html:errors property="cli_rzao"/>
                        <html:errors property="data_pedido"/>
                        <html:errors property="nome_planilha"/>
                        <html:errors property="status"/>
                        <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Emula_faturas_proformas"/>
                      </td>
                    </tr>
                  </table>

                  <table class="itemTable"  style="width:99%;">
                    <%
                    acesso.Sessao se = new acesso.Sessao(session);
                    String cliente = "";
                    if(se.getTipoEntidadeNegocio().equals("CLIENTE MERCADO EXTERNO")){
                      cliente = se.getChave();
                    }
                    %>
                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          <bean:message bundle="ComercialResources" key="EntPedidosForm.numero_pedido"/>
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="numero_pedido" styleId="numero_pedido" styleClass="baseField" size="6" maxlength="6"/>

                        <span class="spamFormLabel">
                          <bean:message bundle="ComercialResources" key="EntPedidosForm.status"/>
                        </span>
                        <html:select property="status" tabindex="-1" styleClass="baseField" size="1">
                          <html:option styleClass="baseOption" value="">
                            <bean:message bundle="ComercialResources" key="EntPedidosForm.all"/>
                          </html:option>
                          <html:option styleClass="baseOption" value="O">
                            <bean:message bundle="ComercialResources" key="EntPedidosForm.open"/>
                          </html:option>
                          <html:option styleClass="baseOption" value="C">
                            <bean:message bundle="ComercialResources" key="EntPedidosForm.completed"/>
                          </html:option>
                        </html:select>

                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          <bean:message bundle="ComercialResources" key="EntPedidosForm.codigo_cliente"/>
                        </span>
                        <bean:message key="jsp.fieldnotnull"/>
                      </td>
                      <td class="formField">

                        <%
                        if(cliente.equals("")){
                          %>
                          <%
                          if(session.getAttribute("entrada_pedidos_codigo_cliente")!=null){
                            %>
                            <html:text property="codigo_cliente" value="<%= (String)session.getAttribute("entrada_pedidos_codigo_cliente") %>" styleId="codigo_cliente" onblur="jQuery.post('EntPedidosForm.do?sessao_action=&numero_pedido='+document.forms[0].numero_pedido.value+'&data_pedido='+document.forms[0].data_pedido.value+'&nome_planilha='+document.forms[0].nome_planilha.value);if(this.value!=''){fillFields(0,new Array('codigo_cliente'),'EntPedidosActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));}else{cli_rzao.value='';}" styleClass="baseField" size="5" maxlength="5"/>
                            <%
                          } else {
                            %>
                            <html:text property="codigo_cliente" styleId="codigo_cliente" onblur="if(this.value!=''){jQuery.post('EntPedidosForm.do?sessao_action=&numero_pedido='+document.forms[0].numero_pedido.value+'&data_pedido='+document.forms[0].data_pedido.value+'&nome_planilha='+document.forms[0].nome_planilha.value);fillFields(0,new Array('codigo_cliente'),'EntPedidosActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));}else{cli_rzao.value='';}" styleClass="baseField" size="5" maxlength="5"/>
                            <%
                          }
                          %>
                          <input type="button" tabindex="-1" value="..." onclick="javascript:lov_open_codigo_cliente()"  >
                          <%
                        } else {
                          %>
                          <html:text property="codigo_cliente" value="<%= cliente %>" styleId="codigo_cliente" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                          <input type="button" class="lovButton" tabindex="-1" value="..." disabled="true"  >
                          <script>
                            fillFields(0,new Array('codigo_cliente'),'EntPedidosActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));
                          </script>
                          <%
                        }
                        %>
                        <script type="text/javascript">
                          function lov_open_codigo_cliente() {
                            window.open('..//lov/LvClienteLov.do?resetfull_action=&returnBlock=0&return0=codigo_cliente&return1=cli_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                          }
                        </script>
                        <span class="spamFormLabel">
                        </span>

                        <%
                        if(session.getAttribute("entrada_pedidos_cli_rzao")!=null){
                          %>
                          <html:text property="cli_rzao" styleId="cli_rzao" value="<%= (String)session.getAttribute("entrada_pedidos_cli_rzao") %>"  styleClass="disabled" tabindex="-1" readonly="true" size="50" maxlength="50"/>
                          <%
                        } else {
                          %>
                          <html:text property="cli_rzao" styleId="cli_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="50" maxlength="50"/>
                          <%
                        }
                        %>

                      </td>
                    </tr>

                    <html:hidden property="estabelecimento_cliente" value="1"/>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          <bean:message bundle="ComercialResources" key="EntPedidosForm.data_pedido"/>
                        </span>
                        <bean:message key="jsp.fieldnotnull"/>
                      </td>
                      <td class="formField">

                        <%
                        if(session.getAttribute("entrada_pedidos_data_pedido")!=null){
                          %>
                          <html:text property="data_pedido" onblur="jQuery.post('EntPedidosForm.do?sessao_action=&numero_pedido='+document.forms[0].numero_pedido.value+'&data_pedido='+document.forms[0].data_pedido.value+'&nome_planilha='+document.forms[0].nome_planilha.value);" styleId="data_pedido" value="<%= (String)session.getAttribute("entrada_pedidos_data_pedido") %>" styleClass="baseField" size="10" maxlength="10"/>
                          <%
                        } else {
                          %>
                          <html:text property="data_pedido" onblur="jQuery.post('EntPedidosForm.do?sessao_action=&numero_pedido='+document.forms[0].numero_pedido.value+'&data_pedido='+document.forms[0].data_pedido.value+'&nome_planilha='+document.forms[0].nome_planilha.value);" styleId="data_pedido" styleClass="baseField" size="10" maxlength="10"/>
                          <%
                        }
                        %>

                         
                        <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_pedido']); cal1.year_scroll = true; cal1.popup();">
                          <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                        </a>

                        <span class="spamFormLabel">
                          <bean:message bundle="ComercialResources" key="EntPedidosForm.observacao"/>
                        </span>
                        <%
                        if(session.getAttribute("entrada_pedidos_codigo_cliente")!=null){
                          %>
                          <html:text property="nome_planilha" onblur="jQuery.post('EntPedidosForm.do?sessao_action=&numero_pedido='+document.forms[0].numero_pedido.value+'&data_pedido='+document.forms[0].data_pedido.value+'&nome_planilha='+document.forms[0].nome_planilha.value);" styleId="nome_planilha" value="<%= (String)session.getAttribute("entrada_pedidos_codigo_cliente") %>" styleClass="baseField" size="30" maxlength="30"/>
                          <%
                        } else {
                          %>
                          <html:text property="nome_planilha" onblur="jQuery.post('EntPedidosForm.do?sessao_action=&numero_pedido='+document.forms[0].numero_pedido.value+'&data_pedido='+document.forms[0].data_pedido.value+'&nome_planilha='+document.forms[0].nome_planilha.value);" styleId="nome_planilha" styleClass="baseField" size="30" maxlength="30"/>
                          <%
                        }
                        %>

                      </td>
                    </tr>

                    <html:hidden property="tem_alteracao"/>
                    <html:hidden property="pos"/>
                    <%
                    {
                      %>
                      <%
                      java.util.Vector res_Emula_faturas_proformas = (java.util.Vector)session.getAttribute("res_Emula_faturas_proformas");
                      %>
                      <%
                      String pos = "0";
                      if (res_Emula_faturas_proformas!=null) {
                        pos = "" + res_Emula_faturas_proformas.size();
                      }
                      %>
                    </table>

                    <table class="navigatorTable" style="width:99%;">
                      <tr class="navigatorTr" >
                        <td class="navigatorTd" >
                          <img border="0" style="cursor:pointer" src="../img/first.gif" title="<bean:message bundle="ApplicationResources" key="navigator.first"/>" onclick="javascript:new_pos0('1');" />
                           
                          <img border="0" style="cursor:pointer" src="../img/prev.gif" title="<bean:message bundle="ApplicationResources" key="navigator.previous"/>" onclick="javascript:new_pos0(parseInt(document.forms[0].navigation_pos0.value)-1);" accesskey="," />
                           
                          <input type="text" name="navigation_pos0" size="5" class="navigatorInput" >
                           
                          <img border="0" style="cursor:pointer" src="../img/next.gif" title="<bean:message bundle="ApplicationResources" key="navigator.next"/>"  onclick="javascript:new_pos0(parseInt(document.forms[0].navigation_pos0.value)+1);" accesskey="." />
                           
                          <img border="0" style="cursor:pointer" src="../img/last.gif" title="<bean:message bundle="ApplicationResources" key="navigator.last"/>" onclick="javascript:new_pos0(document.forms[0].navigation_max0.value);">
                           
                          <bean:message key="jsp.navigator.register"/>
                          :
                          <input type="text" name="navigation_max0" value="<%= pos %>" size="5" class="navigatorInput" >
                        </td>
                      </tr>
                      <script type="text/javascript">
                        if (document.forms[0].pos.value!="") {
                          document.forms[0].navigation_pos0.value= parseInt(document.forms[0].pos.value) + 1;
                        }
                        function new_pos0(POS) {
                          if (POS>0 && POS<=document.forms[0].navigation_max0.value ) {
                          if(document.forms[0].tem_alteracao.value=='s'){if(confirma_alteracao()){}else{return false;};}
                          document.forms[0].tem_alteracao.value='';
                          document.forms[0].navigation_pos0.value=POS;
                          document.forms[0].pos.value=parseInt(document.forms[0].navigation_pos0.value) - 1;
                          document.forms[0].pos_action.click();
                        } else {
                          alert("<bean:message key="jsp.endregistries"/>");
                        }
                      }
                    </script>
                    <%}%>

                    </table>

                    <%
                    portalbr.com.EntPedidosActionForm entped = (portalbr.com.EntPedidosActionForm)session.getAttribute("EntPedidosActionForm");
                    %>

                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                    </html:submit>
                    <html:submit accesskey="i" onclick="if(document.forms[0].tem_alteracao.value=='s'){if(confirma_alteracao()){return true;}else{return false;};}" styleClass="myhidden" property="insert_action">
                    </html:submit>
                    <html:submit accesskey="a" onclick="if(document.forms[0].tem_alteracao.value=='s'){if(confirma_alteracao()){return true;}else{return false;};}" styleClass="myhidden" property="update_action">
                    </html:submit>
                    <html:submit accesskey="a" onclick="return confirma_submit();" styleClass="myhidden" property="delete_action">
                    </html:submit>
                    <html:submit accesskey="l" onclick="if(document.forms[0].tem_alteracao.value=='s'){if(confirma_alteracao()){return true;}else{return false;};}" styleClass="myhidden" property="resetfull_action">
                    </html:submit>
                    <html:submit value="Pos" styleClass="myhidden" property="pos_action">
                    </html:submit>
                    <html:submit value="Finalizar Pedido" onclick="if(document.forms[0].tem_alteracao.value=='s'){if(confirma_alteracao()){return true;}else{return false;};}return confirma_submit();" styleClass="myhidden" property="finalizar_action">
                    </html:submit>


                    <div class="fg-toolbar ui-widget-header ui-corner-all ui-helper-clearfix">
                      <div class="fg-buttonset ui-helper-clearfix">
                        <a href="#" onclick="document.forms[0].select_action.click();" class="fg-button ui-state-default fg-button-icon-right ui-corner-all">
                          <span class="ui-icon ui-icon-zoomin">
                          </span>
                          <bean:message bundle="ComercialResources" key="EntPedidosForm.pesquisar"/>
                        </a>
                        <%
                        if((entped.getStatus()+"").equals("C") || (entped.getStatus()+"").equals("O")){
                          %>
                          <%
                        } else {
                          %>
                          <a href="#" onclick="document.forms[0].insert_action.click();" class="fg-button ui-state-default fg-button-icon-right ui-corner-all">
                            <span class="ui-icon ui-icon-plusthick">
                            </span>
                            <bean:message bundle="ComercialResources" key="EntPedidosForm.inserir"/>
                          </a>
                          <%
                        }
                        %>

                        <%
                        if((entped.getStatus()+"").equals("C")){
                          %>
                          <%
                        } else if((entped.getStatus()+"").equals("O")){
                          %>
                          <a href="#" onclick="document.forms[1].insert1_action.click();" class="fg-button ui-state-default fg-button-icon-right ui-corner-all">
                            <span class="ui-icon ui-icon-disk">
                            </span>
                            <bean:message bundle="ComercialResources" key="EntPedidosForm.salvar_alteracoes"/>
                          </a>
                          <%
                        }
                        %>
                        <%
                        if((entped.getStatus()+"").equals("C")){
                          %>
                          <%
                        } else if((entped.getStatus()+"").equals("O")){
                          %>
                          <a href="#" onclick="document.forms[0].delete_action.click();" class="fg-button ui-state-default fg-button-icon-right ui-corner-all">
                            <span class="ui-icon ui-icon-closethick">
                            </span>
                            <bean:message bundle="ComercialResources" key="EntPedidosForm.excluir_pedido"/>
                          </a>
                          <%
                        }
                        %>
                        <a href="#" onclick="document.forms[0].resetfull_action.click();" class="fg-button ui-state-default fg-button-icon-right ui-corner-all">
                          <span class="ui-icon ui-icon-refresh">
                          </span>
                          <bean:message bundle="ComercialResources" key="EntPedidosForm.limpar"/>
                        </a>
                        <%
                        if((entped.getStatus()+"").equals("O")){
                          %>
                          <%
                          if(session.getAttribute("pedido_tem_erros")==null){
                            %>
                            <a href="#" onclick="document.forms[0].finalizar_action.click();" class="fg-button ui-state-default fg-button-icon-right ui-corner-all">
                              <span class="ui-icon ui-icon-check">
                              </span>
                              <bean:message bundle="ComercialResources" key="EntPedidosForm.finalizar_pedido"/>
                            </a>
                            <%
                          }
                          %>
                          <a href="#" onclick="document.forms[1].adicionar_item_action.click();" class="fg-button ui-state-default fg-button-icon-right ui-corner-all">
                            <span class="ui-icon ui-icon-plusthick">
                            </span>
                            <bean:message bundle="ComercialResources" key="EntPedidosForm.adicionar_item"/>
                          </a>
                          <a href="#" onclick="document.forms[1].adicionar_itens_normas_action.click();" class="fg-button ui-state-default fg-button-icon-right ui-corner-all">
                            <span class="ui-icon ui-icon-contact">
                            </span>
                            <bean:message bundle="ComercialResources" key="EntPedidosForm.adicionar_item_norma"/>
                          </a>
                          <%
                        }
                        %>
                        <a href="#" onclick="document.forms[1].pdf.click();" class="fg-button ui-state-default fg-button-icon-right ui-corner-all">
                          <span class="ui-icon ui-icon-print">
                          </span>
                          Imprimir
                        </a>

                      </div>
                    </div>


                    <script type="text/javascript">
                      jQuery(document).ready(function($) {
                        $("#data_pedido").mask("99/99/9999");
                        });
                      </script>
                    </html:form>
                    <script type="text/javascript">
                      var focusControl = document.forms[0].elements["numero_pedido"];
                      if (focusControl.type != "hidden"){
                        focusControl.focus();
                      }
                    </script>




                    <script>
                      function getKeySite(keyStroke) {
                        isNetscape=(document.layers);
                        eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                        which = String.fromCharCode(eventChooser).toLowerCase();
                        keyBuffer = which;
                        if(eventChooser == 13){
                          document.forms[0].select_action.click();
                        }
                      }
                    </script>
                    <SCRIPT>
                      document.onkeypress = getKeySite;
                    </SCRIPT>


                    <script language="javascript">
                      function confirma_alteracao() {
                        var msg = "<bean:message bundle="ComercialResources" key="EntPedidosForm.alteracoes_nao_salvas_item"/>";
                        return confirm(msg);
                      }

                      function confirma_submit() {
                        var msg="<bean:message bundle="ComercialResources" key="EntPedidosForm.confirma_operacao"/>";
                        return confirm(msg);
                      }
                    </script>



                    <%
                    if(session.getAttribute("adicionou_item")!=null) {
                      %>
                      <script>
                        document.forms[0].select_action.click();
                      </script>
                      <%
                      session.removeAttribute("adicionou_item");
                    }
                    %>
                    <%
                    //  response.setHeader("Cache-Control","no-cache");
                    //  response.setDateHeader ("Expires", 0);
                    %>
                    <%
                    if(session.getAttribute("numero_pedido")!=null) {
                      portalbr.dbobj.table.Emula_itens_faturas_proformas t_itens = null;
                      com.egen.util.jdbc.JdbcUtil j = null;
                      try {
                        j = new com.egen.util.jdbc.JdbcUtil();

                        String height = (String)session.getAttribute("height");
                        String width = (String)session.getAttribute("width");

                        String registro_erro = "9999999";
                        if(session.getAttribute("registro_erro")!=null){
                          registro_erro = (String)session.getAttribute("registro_erro");
                          session.removeAttribute("registro_erro");
                        }
                        String status_pedido = "O";
                        if(session.getAttribute("status_pedido")!=null){
                          status_pedido = (String)session.getAttribute("status_pedido");
                        }
                        int qtde_registros = 0;
                        java.util.Vector res_Emula_itens_faturas_proformas = (java.util.Vector)session.getAttribute("res_Emula_itens_faturas_proformas");
                        if (res_Emula_itens_faturas_proformas!=null && res_Emula_itens_faturas_proformas.size()>0) {
                          qtde_registros = res_Emula_itens_faturas_proformas.size();
                        }
                        util.consultas.Query query = new util.consultas.Query();
                        int max_numero_item = Integer.parseInt(query.retorna(j,"SELECT nvl(max(numero_item),0) FROM emula_itens_faturas_proformas WHERE numero_pedido = "+(String)session.getAttribute("numero_pedido")));
                        %>
                        <script type="text/javascript" src="../script/jquery.alphanumeric.js">
                        </script>
                        <script type="text/javascript" src="../script/jquery.smoothscroll.js">
                        </script>

                        <html:form action="com/EntPedidosGrid.do" method="post" styleClass="baseForm">

                          <a href="#rodape">
                            <input type="button" id="btrodape" value="xxx" style="visibility:hidden">
                          </a>

                          <div class="scroll">


                            <div id="carregando" class="scrolltable">
                              <table border = "0" style="height: 99%;width:99%;border:0">
                                <tr>
                                  <td align="center">
                                    <img src="../img/loading.gif" alt="" title="" />
                                  </td>
                                </tr>
                              </table>
                            </div>










                            <div id="divitens" class="myhidden">

                              <table class="itemGridTable" style='width:99%;' border=0>
                                <tr class="trGridLabel">

                                  <%
                                  if(!status_pedido.equals("C")) {
                                    %>
                                    <td class="tdGridlabel" align="center">
                                      <span class="spamFormLabel">
                                        <img src="../img/lixeira.png" title="<bean:message bundle="ComercialResources" key="EntPedidosForm.excluir"/>" onmouseover="this.src='../img/lixeira_s.png'" onmouseout="this.src='../img/lixeira.png'" onclick="if(confirmSubmit('')){document.forms[1].delete1_action.click();}" style="cursor:hand"/>
                                      </td>
                                      <%
                                    }
                                    %>

                                    <td class="tdGridlabel">
                                      <span class="spamFormLabel">
                                        <bean:message bundle="ComercialResources" key="EntPedidosForm.seq"/>
                                      </span>
                                    </td>

                                    <td class="tdGridlabel">
                                      <span class="spamFormLabel">
                                        <bean:message bundle="ComercialResources" key="EntPedidosForm.linha"/>
                                        <bean:message key="jsp.fieldnotnull"/>
                                      </span>
                                    </td>

                                    <td class="tdGridlabel">
                                      <span class="spamFormLabel">
                                        <bean:message bundle="ComercialResources" key="EntPedidosForm.ref"/>
                                        <bean:message key="jsp.fieldnotnull"/>
                                      </span>
                                    </td>

                                    <td class="tdGridlabel">
                                      <span class="spamFormLabel">
                                        <bean:message bundle="ComercialResources" key="EntPedidosForm.corrugado"/>
                                        <bean:message key="jsp.fieldnotnull"/>
                                      </span>
                                    </td>

                                    <td class="tdGridlabel">
                                      <span class="spamFormLabel">
                                        <bean:message bundle="ComercialResources" key="EntPedidosForm.cabedal"/>
                                        <bean:message key="jsp.fieldnotnull"/>
                                      </span>
                                    </td>

                                    <td class="tdGridlabel">
                                      <span class="spamFormLabel">
                                        <bean:message bundle="ComercialResources" key="EntPedidosForm.descricao"/>
                                      </span>
                                    </td>

                                    <td class="tdGridlabel">
                                      <span class="spamFormLabel">
                                        <bean:message bundle="ComercialResources" key="EntPedidosForm.cor"/>
                                        <bean:message key="jsp.fieldnotnull"/>
                                      </span>
                                    </td>

                                    <td class="tdGridlabel">
                                      <span class="spamFormLabel">
                                        <bean:message bundle="ComercialResources" key="EntPedidosForm.grade"/>
                                        <bean:message key="jsp.fieldnotnull"/>
                                      </span>
                                    </td>

                                    <td class="tdGridlabel">
                                      <span class="spamFormLabel">
                                        <bean:message bundle="ComercialResources" key="EntPedidosForm.quantidade_pares"/>
                                        <bean:message key="jsp.fieldnotnull"/>
                                      </span>
                                    </td>

                                    <td class="tdGridlabel">
                                      <span class="spamFormLabel">
                                        <bean:message bundle="ComercialResources" key="EntPedidosForm.loja_cliente"/>
                                      </span>
                                    </td>

                                  </tr>






                                  <%
                                  int contador = 0;
                                  int contador_nao_base_table = 0;
                                  boolean registro_banco = false;
                                  %>
                                  <logic:iterate id="bl_form_Emula_itens_faturas_proformas_lines" name="EntPedidosGridActionForm" property="bl_form_Emula_itens_faturas_proformas_lines" indexId="indexId">

                                    <%
                                    if(res_Emula_itens_faturas_proformas!=null){
                                      try {
                                        t_itens = (portalbr.dbobj.table.Emula_itens_faturas_proformas)res_Emula_itens_faturas_proformas.elementAt(contador);
                                        registro_banco = true;
                                      } catch (Exception e){
                                        registro_banco = false;
                                        contador_nao_base_table ++;
                                      }
                                    } else {
                                      contador_nao_base_table ++;
                                    }
                                    %>


                                    <%
                                    if((!(t_itens.getDescricao_erro()+"").equals("null")) && (status_pedido.equals("O"))){
                                      %>
                                      <tr style="background-color:red">
                                        <%
                                      } else {
                                        %>
                                        <tr class="trGridField">
                                          <%
                                        }
                                        %>




                                        <%
                                        if(!status_pedido.equals("C")) {
                                          %>
                                          <td class="tdGridField" align="center" style="background-color:white">

                                            <%
                                            if(registro_banco){
                                              %>
                                              <%
                                              if(qtde_registros == 1){
                                                %>
                                                <!--
                                                  <img src="../img/remover_item.gif" onclick="if(confirmSubmit('')){document.forms[1].gridCheckField.checked=true;document.forms[1].delete1_action.click();}" style="cursor:hand" />
                                                -->
                                                <%
                                              } else {
                                                %>
                                                <!--
                                                  <img src="../img/remover_item.gif" onclick="if(confirmSubmit('')){document.forms[1].elements['gridCheckField'][<%= indexId %>].checked=true;document.forms[1].delete1_action.click();}" style="cursor:hand" />
                                                -->
                                                <%
                                              }
                                              %>
                                              <%
                                            } else {
                                              %>
                                              <!--
                                                <img src="../img/remover_item_branco.gif"
                                              -->
                                              <%
                                            }
                                            %>
                                            <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                          </td>
                                          <%
                                        }
                                        %>

                                        <html:hidden property="numero_pedido1" value="<%= (String)session.getAttribute("numero_pedido") %>" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true" styleId="numero_pedido1"/>
                                        <td class="tdGridField">
                                          <%
                                          //if(registro_banco){
                                            if(true){
                                              %>
                                              <html:text property="numero_item" style="text-align:center" styleId="numero_item" styleClass="disabled" tabindex="-1" readonly="true" size="4" maxlength="4" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                              <%
                                            } else {
                                              %>
                                              <html:text property="numero_item" value="<%= max_numero_item+contador_nao_base_table+""  %>" style="text-align:center" styleId="numero_item" styleClass="disabled" tabindex="-1" readonly="true" size="4" maxlength="4" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                              <%
                                            }
                                            %>
                                            <html:text property="registro_banco" styleId="registro_banco" styleClass="myhidden" size="4" maxlength="4" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                            <html:text property="registro_alterado" styleId="registro_alterado" styleClass="myhidden" size="4" maxlength="4" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                          </td>

                                          <td class="tdGridField">
                                            <%
                                            if(status_pedido.equals("O")){
                                              %>
                                              <html:text property="codigo_linha" onkeydown="posicionaItem(this.name, event);" onchange="setarAlterado(this.name);" styleId="codigo_linha" styleClass="numerico" size="7" maxlength="22" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                              <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_linha<%= indexId %>()"  >
                                              <%
                                            } else {
                                              %>
                                              <html:text property="codigo_linha" styleId="codigo_linha" styleClass="disabled" tabindex="-1" readonly="true" size="7" maxlength="22" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                              <input type="button" class="lovButton" tabindex="-1" value="..." disabled="true" >
                                              <%
                                            }
                                            %>
                                            <script type="text/javascript">
                                              function lov_open_codigo_linha<%= indexId %>() {
                                                <% if(qtde_registros == 1){ %>
                                                window.open('..//lov/LvLinExp0400Lov.do?resetfull_action=&returnBlock=1&return0=codigo_linha','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                                                <% } else { %>
                                                window.open('..//lov/LvLinExp0400Lov.do?resetfull_action=&returnBlock=1&return0=codigo_linha[<%= indexId %>]','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                                                <% } %>
                                              }
                                            </script>
                                          </td>

                                          <td class="tdGridField">
                                            <%
                                            if(status_pedido.equals("O")){
                                              %>
                                              <html:text property="codigo_referencia" onkeydown="posicionaItem(this.name, event);" onchange="setarAlterado(this.name);" styleId="codigo_referencia" styleClass="numerico" size="3" maxlength="3" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                              <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_referencia<%= indexId %>()"  >
                                              <%
                                            } else {
                                              %>
                                              <html:text property="codigo_referencia" tabindex="-1" readonly="true" styleId="codigo_referencia" styleClass="disabled" size="3" maxlength="3" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                              <input type="button" class="lovButton" tabindex="-1" value="..." disabled="true"  >
                                              <%
                                            }
                                            %>
                                            <script type="text/javascript">
                                              function lov_open_codigo_referencia<%= indexId %>() {
                                                <% if(qtde_registros == 1){ %>
                                                window.open('..//lov/LvRefExp0400Lov.do?select_action=&lin_cdgo='+document.forms[1].codigo_linha.value+'&returnBlock=1&return0=codigo_referencia','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                                                <% } else { %>
                                                window.open('..//lov/LvRefExp0400Lov.do?select_action=&lin_cdgo='+document.forms[1].codigo_linha[<%= indexId %>].value+'&returnBlock=1&return0=codigo_referencia[<%= indexId %>]','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                                                <% } %>
                                              }
                                            </script>
                                          </td>



                                          <td class="tdGridField">
                                            <%
                                            if(status_pedido.equals("O")){
                                              %>
                                              <html:text property="codigo_corrugado" onkeydown="posicionaItem(this.name, event);" onchange="setarAlterado(this.name);" styleId="codigo_corrugado" styleClass="numerico" size="3" maxlength="3" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                              <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_corrugado<%= indexId %>()"  >
                                              <%
                                            } else {
                                              %>
                                              <html:text property="codigo_corrugado" tabindex="-1" readonly="true" styleId="codigo_corrugado" styleClass="disabled" size="3" maxlength="3" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                              <input type="button" class="lovButton" tabindex="-1" value="..." disabled="true"  >
                                              <%
                                            }
                                            %>
                                            <script type="text/javascript">
                                              function lov_open_codigo_corrugado<%= indexId %>() {
                                                <% if(qtde_registros == 1){ %>
                                                window.open('..//lov/LvCorrugadoExp0400Lov.do?select_action=&lin_cdgo='+document.forms[1].codigo_linha.value+'&ref_cdgo='+document.forms[1].codigo_referencia.value+'&returnBlock=1&return0=codigo_corrugado','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                                                <% } else { %>
                                                window.open('..//lov/LvCorrugadoExp0400Lov.do?select_action=&lin_cdgo='+document.forms[1].codigo_linha[<%= indexId %>].value+'&ref_cdgo='+document.forms[1].codigo_referencia[<%= indexId %>].value+'&returnBlock=1&return0=codigo_corrugado[<%= indexId %>]','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                                                <% } %>
                                              }
                                            </script>
                                          </td>




                                          <td class="tdGridField">
                                            <%
                                            if(status_pedido.equals("O")){
                                              %>
                                              <html:text property="codigo_cabedal" onkeydown="posicionaItem(this.name, event);" onblur="descajax(this.name);" onchange="setarAlterado(this.name);" styleId="codigo_cabedal" styleClass="numerico" size="6" maxlength="22" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true" />
                                              <input type="button" class="lovButton" tabindex="-1" value="..." onclick="javascript:lov_open_codigo_cabedal<%= indexId %>()"  >
                                              <%
                                            } else {
                                              %>
                                              <html:text property="codigo_cabedal" styleId="codigo_cabedal" styleClass="disabled" tabindex="-1" readonly="true" size="6" maxlength="22" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true" />
                                              <input type="button" class="lovButton" tabindex="-1" value="..." disabled="true">
                                              <%
                                            }
                                            %>
                                            <script type="text/javascript">
                                              function lov_open_codigo_cabedal<%= indexId %>() {
                                                <% if(qtde_registros == 1){ %>
                                                window.open('..//lov/LvRefCabExp0400Lov.do?select_action=&lin_cdgo='+document.forms[1].codigo_linha.value+'&ref_cdgo='+document.forms[1].codigo_referencia.value+'&returnBlock=1&return0=codigo_cabedal&return2=codigo_linha','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                                                <% } else { %>
                                                window.open('..//lov/LvRefCabExp0400Lov.do?select_action=&lin_cdgo='+document.forms[1].codigo_linha[<%= indexId %>].value+'&ref_cdgo='+document.forms[1].codigo_referencia[<%= indexId %>].value+'&returnBlock=1&return0=codigo_cabedal[<%= indexId %>]&return2=codigo_linha[<%= indexId %>]','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                                                <% } %>
                                              }
                                            </script>
                                          </td>



                                          <td class="tdGridField">
                                            <html:text property="descricao_item" styleId="descricao_item" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="70" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                          </td>

                                          <td class="tdGridField">
                                            <%
                                            if(status_pedido.equals("O")){
                                              %>
                                              <html:text property="codigo_cor" styleId="codigo_cor" onkeydown="posicionaItem(this.name, event);" onchange="setarAlterado(this.name);" styleClass="numerico" size="7" maxlength="22" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                              <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_cor<%= indexId %>()"  >
                                              <%
                                            } else {
                                              %>
                                              <html:text property="codigo_cor" styleId="codigo_cor" tabindex="-1" readonly="true" styleClass="disabled" size="7" maxlength="22" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                              <input type="button" class="lovButton" tabindex="-1" value="..." tabindex="-1" disabled="true"  >
                                              <%
                                            }
                                            %>
                                            <script type="text/javascript">
                                              function lov_open_codigo_cor<%= indexId %>() {
                                                <% if(qtde_registros == 1){ %>
                                                window.open('..//lov/LvRefCorExp0400Lov.do?select_action=&lin_cdgo='+document.forms[1].codigo_linha.value+'&ref_cdgo='+document.forms[1].codigo_referencia.value+'&cab_cdgo='+document.forms[1].codigo_cabedal.value+'&returnBlock=1&return0=codigo_cor','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                                                <% } else { %>
                                                window.open('..//lov/LvRefCorExp0400Lov.do?select_action=&lin_cdgo='+document.forms[1].codigo_linha[<%= indexId %>].value+'&ref_cdgo='+document.forms[1].codigo_referencia[<%= indexId %>].value+'&cab_cdgo='+document.forms[1].codigo_cabedal[<%= indexId %>].value+'&returnBlock=1&return0=codigo_cor[<%= indexId %>]','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                                                <% } %>
                                              }
                                            </script>
                                          </td>

                                          <td class="tdGridField">



                                            <%
                                            if(status_pedido.equals("O")){
                                              %>
                                              <html:text property="codigo_grade" onkeydown="posicionaItem(this.name, event);" onchange="if(this.value!=''){setarAlterado(this.name);buscaParesGrade(this.name);abreGrade(this.name);};" styleId="codigo_grade" styleClass="numerico" size="3" maxlength="22" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                              <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_grade<%= indexId %>()"  >
                                              <%
                                            } else {
                                              %>
                                              <html:text property="codigo_grade" tabindex="-1" readonly="true" styleId="codigo_grade" styleClass="disabled" size="3" maxlength="22" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                              <input type="button" class="lovButton" tabindex="-1" value="..." tabindex="-1" disabled="true"  >
                                              <%
                                            }
                                            %>

                                            <input type="button" class="lovButton" name="botao[<%= indexId %>]" tabindex="-1" value="<bean:message bundle="ComercialResources" key="EntPedidosForm.ver_grade"/>"  onclick="setarAlterado(this.name);abreGradeBotao(this.name, this);"  >
                                            <script type="text/javascript">
                                              function lov_open_codigo_grade<%= indexId %>() {
                                                <% if(qtde_registros == 1){ %>
                                                window.open('..//lov/LvRefGdeExp0400Lov.do?select_action=&lin_cdgo='+document.forms[1].codigo_linha.value+'&ref_cdgo='+document.forms[1].codigo_referencia.value+'&codigo_corrug='+document.forms[1].codigo_corrugado.value+'&returnBlock=1&return0=codigo_grade&return1=codigo_linha','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                                                <% } else { %>
                                                window.open('..//lov/LvRefGdeExp0400Lov.do?select_action=&lin_cdgo='+document.forms[1].codigo_linha[<%= indexId %>].value+'&ref_cdgo='+document.forms[1].codigo_referencia[<%= indexId %>].value+'&codigo_corrug='+document.forms[1].codigo_corrugado[<%= indexId %>].value+'&returnBlock=1&return0=codigo_grade[<%= indexId %>]&return1=codigo_linha[<%= indexId %>]','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                                                <% } %>
                                              }
                                            </script>

                                          </td>

                                          <td class="tdGridField">
                                            <%
                                            if(status_pedido.equals("O") && (!((t_itens==null?"nulo":t_itens.getCodigo_grade())+"").equals("99"))){
                                              %>
                                              <html:text property="quantidade_pares" onkeydown="posicionaItem(this.name, event);" onchange="setarAlterado(this.name);" styleId="quantidade_pares" styleClass="numerico" size="10" maxlength="15" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                              <%
                                            } else {
                                              %>
                                              <html:text property="quantidade_pares" tabindex="-1" readonly="true" styleId="quantidade_pares" styleClass="disabled" size="10" maxlength="15" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                              <%
                                            }
                                            %>
                                          </td>


                                          <td class="tdGridField">
                                            <%
                                            if(status_pedido.equals("O")){
                                              %>
                                              <html:text property="loja_cliente" onkeydown="posicionaItem(this.name, event);" onchange="setarAlterado(this.name);" styleClass="alfanumerico" styleId="loja_cliente" size="10" maxlength="25" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                              <%
                                            } else {
                                              %>
                                              <html:text property="loja_cliente" tabindex="-1" readonly="true" styleId="loja_cliente" styleClass="disabled" size="10" maxlength="25" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true"/>
                                              <%
                                            }
                                            %>
                                            <%
                                            if((!(t_itens.getDescricao_erro()+"").equals("null")) && (status_pedido.equals("O"))){
                                              %>

                                              <a href="../com/EntPedidosAvisoErroForm.do?select_action=&numero_pedido=<%= t_itens.getNumero_pedido()%>&numero_item=<%= t_itens.getNumero_item() %>&=?keepThis=true&TB_iframe=true&height=200&width=500" title="Erro" class="thickbox">
                                                <img src="../img/botao_ajuda.gif">
                                              </a>
                                              <%
                                            } else {
                                              %>
                                              <img src="../img/transparente.png" width="16" height="16">
                                              <%
                                            }
                                            %>
                                          </td>

                                          <html:hidden property="preco_unitario" name="bl_form_Emula_itens_faturas_proformas_lines" indexed="true" styleId="preco_unitario"/>
                                        </tr>

                                        <tr>
                                          <td colspan="10" align="center">
                                            <div id="grade<%=indexId%>" class="grade">
                                            </div>
                                          </td>
                                        </tr>


                                        <tr>
                                          <%
                                          if(status_pedido.equals("O")){
                                            %>
                                            <td colspan="11">
                                              <%
                                            } else {
                                              %>
                                              <td colspan="10">
                                                <%
                                              }
                                              %>
                                              <table class="lineTable" style='width:100%;'>
                                                <tr>
                                                  <td>
                                                  </td>
                                                </tr>
                                              </table>
                                            </td>
                                          </tr>

                                          <%
                                          contador++;
                                          %>

                                        </logic:iterate>


                                        <%
                                        if(status_pedido.equals("O")){
                                          %>
                                          <tr>
                                            <td colspan="9" align="right">
                                              <b>
                                                Total :
                                              </b>
                                            </td>
                                            <td colspan="2">
                                              <input type="text" size="10" class="disabled" tabindex="-1" readonly="true" value="<%= ((String)session.getAttribute("total_pares")+"") %>">
                                            </td>
                                          </tr>
                                          <%
                                        } else {
                                          %>

                                          <tr>
                                            <td colspan="8" align="right">
                                              <b>
                                                Total :
                                              </b>
                                            </td>
                                            <td colspan="2">
                                              <input type="text" size="11" class="disabled" tabindex="-1" readonly="true" value="<%= ((String)session.getAttribute("total_pares")+"") %>">
                                            </td>
                                          </tr>

                                          <%
                                        }
                                        %>



                                      </table>

                                    </div>

                                  </div>



                                  <%
                                  if(session.getAttribute("adicionou_item")!=null) {
                                    %>
                                    <script>
                                      document.forms[1].codigo_linha[<%= contador-1 %>].focus();
                                    </script>
                                    <%
                                  }
                                  %>

                                  <!--
                                    <div class="fg-toolbar ui-widget-header ui-corner-all ui-helper-clearfix"> <div class="fg-buttonset ui-helper-clearfix">
                                  -->

                                  <html:submit accesskey="p" styleClass="myhidden" property="select1_action">
                                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                                  </html:submit>

                                  <!--
                                    <a href="#" onclick="document.forms[1].select1_action.click();" class="fg-button ui-state-default fg-button-icon-right ui-corner-all"><span class="ui-icon ui-icon-zoomin"></span><bean:message bundle="ComercialResources" key="EntPedidosForm.pesquisar"/></a>
                                  -->

                                  <%
                                  if(!status_pedido.equals("C")) {
                                    %>

                                    <html:submit accesskey="i" styleClass="myhidden" property="insert1_action">
                                      <bean:message bundle="ComercialResources" key="EntPedidosForm.salvar_alteracoes"/>
                                    </html:submit>
                                    <!--
                                      <a href="#" onclick="document.forms[1].insert1_action.click();" class="fg-button ui-state-default fg-button-icon-right ui-corner-all"><span class="ui-icon ui-icon-disk"></span><bean:message bundle="ComercialResources" key="EntPedidosForm.salvar_alteracoes"/></a>
                                    -->


                                    <%
                                  }
                                  %>
                                  <html:submit accesskey="a" styleClass="myhidden" property="update1_action">
                                    <bean:message bundle="ComercialResources" key="EntPedidosForm.pesquisar"/>
                                  </html:submit>
                                  <html:submit styleClass="myhidden" property="delete1_action">
                                    <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                                  </html:submit>
                                  <!--
                                    <html:submit accesskey="l" onclick="if(document.forms[0].tem_alteracao.value=='s'){if(confirma_alteracao()){return true;}else{return false;};}" styleClass="myhidden" property="resetfull1_action"> <bean:message bundle="ApplicationResources" key="jsp.reset"/> </html:submit> <a href="#" onclick="document.forms[1].resetfull1_action.click();" class="fg-button ui-state-default fg-button-icon-right ui-corner-all"><span class="ui-icon ui-icon-refresh"></span><bean:message bundle="ComercialResources" key="EntPedidosForm.limpar"/></a>
                                  -->
                                  <%
                                  if(!status_pedido.equals("C")) {
                                    %>

                                    <html:submit accesskey="p" value="Adicionar Item" onclick="if(document.forms[0].tem_alteracao.value=='s'){if(confirma_alteracao()){return true;}else{return false;};}" styleClass="myhidden" property="adicionar_item_action">
                                    </html:submit>

                                    <%
                                    if(contador>12) {
                                      %>
                                      <!--
                                        <a href="#" onclick="document.forms[1].adicionar_item_action.click();" class="fg-button ui-state-default fg-button-icon-right ui-corner-all"><span class="ui-icon ui-icon-plusthick"></span><bean:message bundle="ComercialResources" key="EntPedidosForm.adicionar_item"/></a> <a href="#" onclick="document.forms[1].adicionar_itens_normas_action.click();" class="fg-button ui-state-default fg-button-icon-right ui-corner-all"><span class="ui-icon ui-icon-contact"></span><bean:message bundle="ComercialResources" key="EntPedidosForm.adicionar_item_norma"/></a>
                                      -->
                                      <%
                                    }
                                    %>


                                    <a href="../com/FiltroForm.do?resetfull_action=?keepThis=true&TB_iframe=true&height=<%= height %>&width=<%= width %>" title="Normas de venda" class="thickbox">
                                      <html:button value="Adicionar Itens por Norma de Venda"  styleClass="myhidden" property="adicionar_itens_normas_action">
                                      </html:button>
                                    </a>

                                    <%
                                  }
                                  %>


                                  <a href="../com/EntPedidosPDFForm.do?select_action=?keepThis=true&TB_iframe=true&height=150&width=600" title="Imprimir PDF" class="thickbox">
                                    <html:button value="pdf"  styleClass="myhidden" property="pdf">
                                    </html:button>
                                  </a>
                                  <!--
                                    </div> </div>
                                  -->

                                  <script type="text/javascript">
                                    function descajax(nome){
                                      indice = nome.substring(nome.indexOf('[')+1,nome.indexOf(']'));
                                      var retorno = '';
                                      <% if(((String)session.getAttribute("qtd_itens")).equals("1")){ %>
                                      linha=document.forms[1].codigo_linha.value;
                                      referencia=document.forms[1].codigo_referencia.value;
                                      cabedal=document.forms[1].codigo_cabedal.value;
                                      <% } else { %>
                                      linha=document.forms[1].codigo_linha[indice].value;
                                      referencia=document.forms[1].codigo_referencia[indice].value;
                                      cabedal=document.forms[1].codigo_cabedal[indice].value;
                                      <% } %>
                                      jQuery.ajax({
                                        type: 		"get",
                                        url: 		"Sql2Form.do?select_action=&query=SELECT ref_desc descricao FROM REF WHERE lin_cdgo = "+linha+" AND ref_cdgo = "+referencia,
                                        data: 		"number=1",
                                        success:	function(msg) {
                                          retorno = (msg.substring(msg.indexOf('<inicio>')+8,msg.indexOf('<fim>')));
                                          <% if(((String)session.getAttribute("qtd_itens")).equals("1")){ %>
                                          document.forms[1].descricao_item.value = retorno;
                                          <% } else { %>
                                          document.forms[1].descricao_item[indice].value = retorno;
                                          <% } %>
                                        }
                                        });
                                      }



                                      function buscaParesGrade(nome){

                                        indice = nome.substring(nome.indexOf('[')+1,nome.indexOf(']'));
                                        var retorno = '';
                                        <% if(((String)session.getAttribute("qtd_itens")).equals("1")){ %>
                                        grade=document.forms[1].codigo_grade.value;
                                        <% } else { %>
                                        grade=document.forms[1].codigo_grade[indice].value;
                                        <% } %>

                                        if(grade!='99'){
                                          jQuery.ajax({
                                            type: 		"get",
                                            url: 		"Sql2Form.do?select_action=&query=SELECT SUM(qtd_pars) pares FROM qtd WHERE gde_Cdgo = "+grade,
                                            data: 		"number=1",
                                            success:	function(msg) {
                                              retorno = (msg.substring(msg.indexOf('<inicio>')+8,msg.indexOf('<fim>')));
                                              <% if(((String)session.getAttribute("qtd_itens")).equals("1")){ %>
                                              document.forms[1].quantidade_pares.value = retorno;
                                              <% } else { %>
                                              document.forms[1].quantidade_pares[indice].value = retorno;
                                              <% } %>
                                            }
                                            });
                                          }
                                        }


                                        function abreGrade(nome){
                                          indice = nome.substring(nome.indexOf('[')+1,nome.indexOf(']'));
                                          jQuery('div.grade').hide();
                                          jQuery('div.grade').html('');
                                          <% if(qtde_registros == 1){ %>
                                          if(document.forms[1].codigo_grade.value==99){
                                            jQuery('#grade0').load('EntPedidosGradeForm.do?select_action=&atualiza=s&numero_item='+document.forms[1].numero_item.value+'&lin_cdgo='+document.forms[1].codigo_linha.value+'&ref_cdgo='+document.forms[1].codigo_referencia.value+'&gde_cdgo='+document.forms[1].codigo_grade.value+'&indice='+indice,function(){jQuery(document.forms[1].quantidade_pares).addClass('disabled');document.forms[1].quantidade_pares.readOnly=true;document.forms[1].quantidade_pares.tabIndex='-1';}).fadeIn('slow');
                                          } else {
                                            jQuery('#grade0').load('EntPedidosGradeForm.do?select_action=&atualiza=s&numero_item='+document.forms[1].numero_item.value+'&lin_cdgo='+document.forms[1].codigo_linha.value+'&ref_cdgo='+document.forms[1].codigo_referencia.value+'&gde_cdgo='+document.forms[1].codigo_grade.value+'&indice='+indice,function(){jQuery(document.forms[1].quantidade_pares).removeClass('disabled');document.forms[1].quantidade_pares.readOnly=false;document.forms[1].quantidade_pares.tabIndex='-1';}).fadeIn('slow');
                                          }
                                          <% } else { %>
                                          if(document.forms[1].codigo_grade[indice].value==99){
                                            jQuery('#grade'+indice).load('EntPedidosGradeForm.do?select_action=&atualiza=s&numero_item='+document.forms[1].numero_item[indice].value+'&lin_cdgo='+document.forms[1].codigo_linha[indice].value+'&ref_cdgo='+document.forms[1].codigo_referencia[indice].value+'&gde_cdgo='+document.forms[1].codigo_grade[indice].value+'&indice='+indice,function(){jQuery(document.forms[1].quantidade_pares[indice]).addClass('disabled');document.forms[1].quantidade_pares[indice].readOnly=true;document.forms[1].quantidade_pares[indice].tabIndex='-1';}).fadeIn('slow');
                                          } else {
                                            jQuery('#grade'+indice).load('EntPedidosGradeForm.do?select_action=&atualiza=s&numero_item='+document.forms[1].numero_item[indice].value+'&lin_cdgo='+document.forms[1].codigo_linha[indice].value+'&ref_cdgo='+document.forms[1].codigo_referencia[indice].value+'&gde_cdgo='+document.forms[1].codigo_grade[indice].value+'&indice='+indice,function(){jQuery(document.forms[1].quantidade_pares[indice]).removeClass('disabled');document.forms[1].quantidade_pares[indice].readOnly=false;document.forms[1].quantidade_pares[indice].tabIndex='-1';}).fadeIn('slow');
                                          }
                                          <% } %>
                                        }


                                        function abreGradeBotao(nome,e){
                                          indice = nome.substring(nome.indexOf('[')+1,nome.indexOf(']'));
                                          jQuery('div.grade').hide();
                                          jQuery('div.grade').html('');
                                          <% if(qtde_registros == 1){ %>
                                          if(document.forms[1].codigo_grade.value){
                                            e.disabled = true;
                                            e.value = ' Aguarde ';
                                            jQuery('#grade0').load('EntPedidosGradeForm.do?select_action=&atualiza=n&numero_item='+document.forms[1].numero_item.value+'&lin_cdgo='+document.forms[1].codigo_linha.value+'&ref_cdgo='+document.forms[1].codigo_referencia.value+'&gde_cdgo='+document.forms[1].codigo_grade.value+'&indice='+indice,function(){e.disabled=false;e.value='<bean:message bundle="ComercialResources" key="EntPedidosForm.ver_grade"/>';}).fadeIn('slow');
                                          }
                                          <% } else { %>
                                          if(document.forms[1].codigo_grade[indice].value){
                                            e.disabled = true;
                                            e.value = ' Aguarde ';
                                            jQuery('#grade'+indice).load('EntPedidosGradeForm.do?select_action=&atualiza=n&numero_item='+document.forms[1].numero_item[indice].value+'&lin_cdgo='+document.forms[1].codigo_linha[indice].value+'&ref_cdgo='+document.forms[1].codigo_referencia[indice].value+'&gde_cdgo='+document.forms[1].codigo_grade[indice].value+'&indice='+indice,function(){e.disabled=false;e.value='<bean:message bundle="ComercialResources" key="EntPedidosForm.ver_grade"/>';}).fadeIn('slow');
                                          }
                                          <% } %>
                                        }


                                        function setarAlterado(nome){
                                          indice = nome.substring(nome.indexOf('[')+1,nome.indexOf(']'));
                                          <% if(((String)session.getAttribute("qtd_itens")).equals("1")){ %>
                                          document.forms[1].registro_alterado.value='a';
                                          document.forms[0].tem_alteracao.value='s';
                                          if(document.forms[1].codigo_linha.value=='' &&
                                          document.forms[1].codigo_referencia.value=='' &&
                                          document.forms[1].codigo_cabedal.value=='' &&
                                          document.forms[1].codigo_cor.value=='' &&
                                          document.forms[1].codigo_grade.value=='' &&
                                          document.forms[1].quantidade_pares.value=='' &&
                                          document.forms[1].registro_banco.value==''){
                                            document.forms[1].registro_alterado.value='';
                                          }
                                          <% } else { %>
                                          document.forms[0].tem_alteracao.value='s';
                                          document.forms[1].registro_alterado[indice].value='a';
                                          if(document.forms[1].codigo_linha[indice].value=='' &&
                                          document.forms[1].codigo_referencia[indice].value=='' &&
                                          document.forms[1].codigo_cabedal[indice].value=='' &&
                                          document.forms[1].codigo_cor[indice].value=='' &&
                                          document.forms[1].codigo_grade[indice].value=='' &&
                                          document.forms[1].quantidade_pares[indice].value=='' &&
                                          document.forms[1].registro_banco[indice].value==''){
                                            document.forms[1].registro_alterado[indice].value='';
                                          }

                                          <% } %>
                                        }



                                        jQuery('.numerico').numeric();
                                      </script>


                                      <script type="text/javascript">
                                        //  jQuery(function($){
                                          //    $("a[href^=#rodape]").smoothScroll(100,10,20,20);
                                          //  });
                                          jQuery(document).ready(function() {

                                            //    document.forms[1].btrodape.click();
                                            jQuery("#divitens").removeClass("myhidden");
                                            jQuery("#carregando").hide();

                                            });
                                          </script>


                                        </html:form>

                                        <%
                                      } finally {
                                      if(j!=null){j.close();}
                                    }
                                    %>



                                    <div id="rodape">
                                    </div>
                                    <%
                                  }
                                  %>
                                  <table class="footerTable" style="width:99%" >
                                    <tr>

                                      <td>

                                        <%
                                        String titulo = null;
                                        String mensagem = null;
                                        String foco = null;
                                        if(session.getAttribute("foco")!=null){
                                          foco = (String)session.getAttribute("foco");
                                        }
                                        if(session.getAttribute("mensagem")!=null){
                                          mensagem = (String)session.getAttribute("mensagem");
                                          titulo = (String)session.getAttribute("titulo");
                                          %>


                                          <LINK rel=stylesheet type=text/css href="../css/dlg.css">
                                          <SCRIPT type=text/javascript src="../script/jquery-1.4.2.min.js">
                                          </SCRIPT>
                                          <SCRIPT type=text/javascript src="../script/jquery.dlg.min.js">
                                          </SCRIPT>
                                          <SCRIPT type=text/javascript src="../script/jquery.easing.js">
                                          </SCRIPT>
                                          <SCRIPT type=text/javascript src="../script/jquery.ui.all.js">
                                          </SCRIPT>

                                          <SCRIPT language=javascript>
                                            $(document).ready(function(){

                                              $(function(){
                                                $.dlg({
                                                  content: '<%= mensagem %>',
                                                  title: '<%= titulo %>',
                                                  drag: true,
                                                  speedIn : 1,
                                                  speedOut : 1,
                                                  onComplete: function(response){
                                                    <% if(session.getAttribute("foco")!=null){ %>
                                                    $('#<%= foco %>').focus();
                                                    <% } %>
                                                  }
                                                  });
                                                  });

                                                  });
                                                </script>
                                                <%
                                                session.removeAttribute("mensagem");
                                                session.removeAttribute("titulo");
                                                session.removeAttribute("foco");
                                                session.removeAttribute("inseriu_item");
                                              } else if (session.getAttribute("inseriu_item")!=null) {
                                                %>
                                                <script>
                                                  document.forms[0].update_action.click();
                                                </script>
                                                <%
                                                session.removeAttribute("inseriu_item");
                                              }
                                              %>
                                            </td>

                                          </tr>

                                        </table>

                                      </td>
                                    </tr>
                                  </table>

                                </body>
                              </center>
                            </html>

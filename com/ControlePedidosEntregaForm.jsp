<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ControlePedidosEntregaActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ControlePedidosEntregaActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("cli_cdgo","Cliente");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("gre_grupo","Grupo Econômico");
    hashMapLabel.set("gre_descricao","");
    hashMapLabel.set("codigo_marca","Marca");
    hashMapLabel.set("ped_stat","Situação Pedido");
    hashMapLabel.set("dt_inicial","Data Inicial");
    hashMapLabel.set("dt_final","Data Final");
    hashMapLabel.set("reg","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Controle de Pedidos p/ Entrega
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(189)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ControlePedidosEntregaForm.do" method="post" styleClass="baseForm">
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
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="gre_grupo"/>
                    <html:errors property="gre_descricao"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="ped_stat"/>
                    <html:errors property="dt_inicial"/>
                    <html:errors property="dt_final"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String codigo_regional = null;
                acesso.Usuario us = new acesso.Usuario();
                us = (acesso.Usuario)session.getAttribute("User");
                acesso.Sessao ses = new acesso.Sessao(session);

                if(!us.isSuperUsuario()){
                  if(ses.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")){
                    codigo_regional = ses.getChave();
                  }
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Representante
                    </span>
                  </span>
                  <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                </td>
                <td class="formField">
                  <html:text property="rep_cdgo" styleId="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'ControlePedidosEntregaActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="5" maxlength="5"/>
                  <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                  <script type="text/javascript">
                    function lov_open_rep_cdgo() {
                      window.open('..//lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                    }
                  </script>
                  <span class="spamFormLabel">
                  </span>
                  <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Cliente
                  </span>
                </span>
                <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
              </td>
              <td class="formField">
                <html:text property="cli_cdgo" styleId="cli_cdgo" onblur="fillFields(0,new Array('cli_cdgo'),'ControlePedidosEntregaActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));" styleClass="baseField" size="10" maxlength="22"/>
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
                  Grupo Econômico
                </span>
                <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
              </td>
              <td class="formField">
                <html:text property="gre_grupo" styleId="gre_grupo" onblur="fillFields(0,new Array('gre_grupo'),'ControlePedidosEntregaActionForm.getGre_descricao_Ajax',new Array('gre_descricao'));" styleClass="baseField" size="6"/>
                <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_gre_grupo()"  >
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
                  Situação Pedido
                </span>
              </td>
              <td class="formField">
                <html:select property="ped_stat" styleId="ped_stat" styleClass="baseField" size="1">
                  <html:option styleClass="baseOption" value="">
                    Todas
                  </html:option>
                  <html:option styleClass="baseOption" value="A">
                    A-Aberto
                  </html:option>
                  <html:option styleClass="baseOption" value="B">
                    B-Bloqueado Vendas
                  </html:option>
                  <html:option styleClass="baseOption" value="C">
                    C-Cancelado
                  </html:option>
                  <html:option styleClass="baseOption" value="F">
                    F-Faturado
                  </html:option>
                  <html:option styleClass="baseOption" value="L">
                    L-Liberado
                  </html:option>
                  <html:option styleClass="baseOption" value="P">
                    P-Bloqueado Crédito
                  </html:option>
                  <html:option styleClass="baseOption" value="PF">
                    PF-Parcialmente Faturado
                  </html:option>
                  <html:option styleClass="baseOption" value="R">
                    R-Análise Comercial
                  </html:option>
                  <html:option styleClass="baseOption" value="T">
                    T-Trancado
                  </html:option>
                </html:select>
              </td>
            </tr>

            <tr class="itemTr">
              <td class="formLabel">
                <span class="spamFormLabel">
                  Data Inicial
                </span>
                <bean:message key="jsp.fieldnotnull"/>
              </td>
              <td class="formField">
                <html:text property="dt_inicial" styleId="dt_inicial" styleClass="baseField" size="10" maxlength="10"/>
                &nbsp;
                <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_inicial']); cal1.year_scroll = true; cal1.popup();">
                  <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                </a>
              </td>
            </tr>

            <tr class="itemTr">
              <td class="formLabel">
                <span class="spamFormLabel">
                  Data Final
                </span>
                <bean:message key="jsp.fieldnotnull"/>
              </td>
              <td class="formField">
                <html:text property="dt_final" styleId="dt_final" styleClass="baseField" size="10"/>
                &nbsp;
                <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_final']); cal1.year_scroll = true; cal1.popup();">
                  <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                </a>
              </td>
            </tr>

            <html:hidden property="reg" value="<%= codigo_regional %>"/>
          </table>

          <table class="buttonTable" style='width:99%;'>
            <tr class="buttonTr">
              <td class="buttonTd">
                <html:button accesskey="p" onclick="resetfull1_action.disabled=true;bloqueia();this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                  <bean:message bundle="ApplicationResources" key="jsp.select"/>
                </html:button>
                <script>
                  function getKeySite(keyStroke) {
                    isNetscape=(document.layers);
                    eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                    which = String.fromCharCode(eventChooser).toLowerCase();
                    keyBuffer = which;
                    if(eventChooser == 13){
                    if(document.forms[0].select1_action.disabled==true){return false;}
                    document.forms[0].select1_action.disabled=true;
                    document.forms[0].resetfull1_action.disabled=true;
                    bloqueia();
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

                <script type="text/javascript">
                jQuery(document).ready(function($) {
                  $("#dt_inicial").mask("99/99/9999");
                  $("#dt_final").mask("99/99/9999");
                  });
                </script>
              </html:form>
              <script type="text/javascript">
                var focusControl = document.forms[0].elements["rep_cdgo"];
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/TitulosActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = TitulosActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("representante","representante");
    hashMapLabel.set("regional","regional");
    hashMapLabel.set("cli_rzao","Nome");
    hashMapLabel.set("cli_cdgo","Código");
    hashMapLabel.set("esc_seqn","Seq.");
    hashMapLabel.set("cgc","CGC");
    hashMapLabel.set("reunir","Reunir todos seqüenciais");
    hashMapLabel.set("f_mercado_interno","");
    hashMapLabel.set("emp_empresa","Empresa");
    hashMapLabel.set("dt_vencimento","Data Vencimento");
    hashMapLabel.set("situacao","Situação");
    hashMapLabel.set("f_tituloi","Consulta Direta");
    hashMapLabel.set("tit_codigo","Título");
    hashMapLabel.set("f_titulof","");
    hashMapLabel.set("codigo","");
    hashMapLabel.set("nome","");
    hashMapLabel.set("bairro","");
    hashMapLabel.set("cidade_uf","");
    hashMapLabel.set("cliente_mercado_externo","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Consulta de Duplicatas
    </title>
  </head>
  <center>
    <body onload="if(document.forms[0].cliente_mercado_externo.value!=''){document.forms[0].dt_vencimento.focus();}else{document.forms[0].cli_rzao.focus();}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(83)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="adm/TitulosForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <div class\='div10l'>
                        Um dos campos com
                        <img src='../img/opcional.gif' border\='0' title\='Opcional' style\='cursor\:pointer'>
                        deve ser preenchido.
                      </div>
                    </div>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="esc_seqn"/>
                    <html:errors property="cgc"/>
                    <html:errors property="reunir"/>
                    <html:errors property="emp_empresa"/>
                    <html:errors property="dt_vencimento"/>
                    <html:errors property="situacao"/>
                    <html:errors property="tit_codigo"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_titulos"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String codigo_regional="";
                String codigo_representante="";
                String tipo="";
                String cliente_mercado_externo="";
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
                  if(tipo.equals("CLIENTE MERCADO INTERNO")){
                    cliente_mercado_externo = ent.getChave()+"";
                  }
                }

                if(cliente_mercado_externo.equals("")){
                  %>
                  <html:hidden property="representante" value="<%= codigo_representante %>"/>
                  <html:hidden property="regional" value="<%= codigo_regional %>"/>
                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Nome
                      </span>
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </td>
                    <td class="formField">
                      <html:text property="cli_rzao" styleClass="baseField" size="35" maxlength="35"/>
                    </td>
                  </tr>
                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Código
                      </span>
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </td>
                    <td class="formField">
                      <html:text property="cli_cdgo" styleClass="baseField" size="10" maxlength="22"/>
                      <span class="spamFormLabel">
                        Seq.
                      </span>
                      <html:text property="esc_seqn" styleClass="baseField" size="4" maxlength="4"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        CGC
                        <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="cgc" styleId="cgc" styleClass="baseField"/>
                    </td>
                  </tr>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Reunir todos seqüenciais
                      </span>
                    </td>
                    <td class="formField">
                      <html:checkbox property="reunir" styleClass="baseField" value="1"/>
                    </td>
                  </tr>

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Empresa
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="emp_empresa" styleId="emp_empresa" onblur="fillFields(0,new Array('emp_empresa'),'TitulosActionForm.getEmp_razsoc_Ajax',new Array('emp_razsoc'));" styleClass="baseField" size="1">
                      <html:options property="emp_empresaList" labelProperty="emp_empresaLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Vencimento
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_vencimento" styleId="dt_vencimento" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_vencimento']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situação
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="situacao" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="T\"selected='selected'">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="A">
                        Abertos
                      </html:option>
                      <html:option styleClass="baseOption" value="L">
                        Liquidados
                      </html:option>
                      <html:option styleClass="baseOption" value="C">
                        Cancelados
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <%
                if(cliente_mercado_externo.equals("")) {
                  %>
                </table>
                <table class="separatorTable">
                  <tr class="separatorTr">
                    <td colspan="2" class="separatorTd">
                      Consulta Direta
                    </td>
                  </tr>
                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Título
                      </span>
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </td>
                    <td class="formField">
                      <html:text property="tit_codigo" styleClass="baseField" size="8" maxlength="8"/>
                      <html:button value="Consulta Título" onclick="this.disabled=true;select2_action.click();" styleClass="baseButton" property="select1_action">
                      </html:button>
                    </td>
                  </tr>
                </table>
                <table class="itemTable" style='width:100%;'>
                  <%
                }
                %>
                <html:hidden property="codigo"/>
                <html:hidden property="nome"/>
                <html:hidden property="bairro"/>
                <html:hidden property="cidade_uf"/>
                <html:hidden property="cliente_mercado_externo" value="<%= cliente_mercado_externo %>"/>
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
                  </SCRIPT>
                  <html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                  <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:button>
                  <html:submit styleClass="myhidden" property="select_action">
                  <bean:message bundle="ApplicationResources" key="jsp.select"/>
                  </html:submit>
                  <html:submit styleClass="myhidden" property="resetfull_action">
                  <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:submit>
                  <html:submit value="Consulta Título" styleClass="myhidden" property="select2_action">
                  </html:submit>
                  </td>
                  </tr>
                  </table>

                  <script type="text/javascript">
                  jQuery(document).ready(function($) {
                    $("#dt_vencimento").mask("99/99/9999");
                    });
                  </script>
                </html:form>
              </td>
            </tr>
          </table>

        </body>
      </center>
    </html>

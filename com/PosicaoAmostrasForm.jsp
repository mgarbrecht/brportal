<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/PosicaoAmostrasActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = PosicaoAmostrasActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("nfs_nmro","Nota Fiscal");
    hashMapLabel.set("ped_nmro","Pedido");
    hashMapLabel.set("ped_nmro_final","até ");
    hashMapLabel.set("ped_dadg","Período");
    hashMapLabel.set("ped_dadg_final","até ");
    hashMapLabel.set("f_regional_i","");
    hashMapLabel.set("regional_cdgo","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("f_regional_f","");
    hashMapLabel.set("f_rep_i","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("f_rep_f","");
    hashMapLabel.set("codigo_marca","Marca");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Posição de Entregas de Amostras
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(179)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/PosicaoAmostrasForm.do" method="post" styleClass="baseForm">
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
                    <html:errors property="nfs_nmro"/>
                    <html:errors property="ped_nmro"/>
                    <html:errors property="ped_nmro_final"/>
                    <html:errors property="ped_dadg"/>
                    <html:errors property="ped_dadg_final"/>
                    <html:errors property="regional_cdgo"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Ped_amostra_rep_vw"/>
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
                      Nota Fiscal
                    </span>
                    <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                  </td>
                  <td class="formField">
                    <html:text property="nfs_nmro" styleId="nfs_nmro" styleClass="baseField" size="7" maxlength="7"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Pedido
                    </span>
                    <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                  </td>
                  <td class="formField">
                    <html:text property="ped_nmro" styleId="ped_nmro" onblur="if(this.value!=''){document.forms[0].ped_nmro_final.value=this.value;}" styleClass="baseField" size="7" maxlength="7"/>
                    <span class="spamFormLabel">
                      até
                    </span>
                    <html:text property="ped_nmro_final" styleId="ped_nmro_final" styleClass="baseField" size="7" maxlength="7"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Período
                    </span>
                    <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                  </td>
                  <td class="formField">
                    <html:text property="ped_dadg" styleId="ped_dadg" onblur="if(this.value!=''){document.forms[0].ped_dadg_final.value=this.value;}" styleClass="date" size="10" maxlength="10"/>
                     
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['ped_dadg']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                      até
                    </span>
                    <html:text property="ped_dadg_final" styleId="ped_dadg_final" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['ped_dadg_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <%
                if(codigo_regional.equals("")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Regional
                      </span>
                      <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                    </td>
                    <td class="formField">
                      <html:text property="regional_cdgo" styleId="regional_cdgo" onblur="fillFields(0,new Array('regional_cdgo'),'PosicaoAmostrasActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="baseField" size="3" maxlength="4"/>
                      <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_regional_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_regional_cdgo() {
                          window.open('..//lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=regional_cdgo&return1=nome_regional','','scrollbars=yes,height=510,width=600,top=0,left=0,');
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

                  <html:hidden property="regional_cdgo" styleId="regional_cdgo" value="<%= codigo_regional %>"/>

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
                      <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                    </td>
                    <td class="formField">
                      <html:text property="rep_cdgo" styleId="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'PosicaoAmostrasActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="5" maxlength="22"/>
                      <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
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

                  <%
                } else {
                  %>

                  <html:hidden property="rep_cdgo" styleId="rep_cdgo" value="<%= codigo_representante %>"/>

                  <%
                }
                %>
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
                  </td>
                  </tr>
                  </table>

                  <script type="text/javascript">
                  jQuery(document).ready(function($) {
                    $("#ped_dadg").mask("99/99/9999");
                    $("#ped_dadg_final").mask("99/99/9999");
                    });
                  </script>
                </html:form>
                <script type="text/javascript">
                  var focusControl = document.forms[0].elements["nfs_nmro"];
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

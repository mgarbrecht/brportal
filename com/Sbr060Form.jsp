<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/Sbr060ActionForm.js">
  </script>
 
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>


 <script type="text/javascript">
    var ActionFormClass = Sbr060ActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("permissao","");
    hashMapLabel.set("free","");
    hashMapLabel.set("f_regi","");
    hashMapLabel.set("regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("f_regf","");
    hashMapLabel.set("pf_ped_dadg_ini","Data Inicial");
    hashMapLabel.set("pf_ped_dadg_fim","Data Final");
    hashMapLabel.set("pf_1","Unid. Negócio");
    hashMapLabel.set("pf_tipo_mercado","Tipo de Mercado");

    hashMapLabel.set("pf_marca_ini","Marca Inicial");
    hashMapLabel.set("descricao_marca","");
    hashMapLabel.set("pf_marca_fim","Marca Final");
    hashMapLabel.set("descricao_marca1","");
    hashMapLabel.set("pf_qtd_linhas","Quantidade de linhas mais vendidas");
//    hashMapLabel.set("pf_2","Somente linhas do "MIX"");
    hashMapLabel.set("reg","");
    hashMapLabel.set("abre_automaticamente","Abre o Relatório Automaticamente");
    hashMapLabel.set("mensagem","");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array();   
       
   
  </script>

  <head>
    <title>
      Linhas mais vendidas por regional
    </title>
  </head>
  <center>
    <body onload="if('<%= (String)request.getAttribute("arquivo") %>' == 'null'){document.forms[0].abre_automaticamente.checked=false;document.forms[0].mensagem.value='';}if(document.forms[0].reg.value==''){document.forms[0].regional.focus();}if(document.forms[0].abre_automaticamente.checked==true){if('<%= (String)request.getAttribute("arquivo") %>' != 'null'){window.open('<%= (String)request.getAttribute("arquivo") %>','_blank');}}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                </td>

              </tr>

            </table>

            <html:form action="com/Sbr060Form.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="pf_ped_dadg_ini"/>
                    <html:errors property="pf_ped_dadg_fim"/>
                    <html:errors property="pf_1"/>
                    <html:errors property="pf_tipo_mercado"/>
                    <html:errors property="pf_marca_ini"/>
                    <html:errors property="descricao_marca"/>
                    <html:errors property="pf_marca_fim"/>
                    <html:errors property="descricao_marca1"/>
                    <html:errors property="pf_qtd_linhas"/>
                    <html:errors property="pf_2"/>
                    <html:errors property="abre_automaticamente"/>
                    <html:errors property="mensagem"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
<%
if(!user.isSuperUsuario() && !user.isAutorizado(90)){
   response.sendRedirect("../system/Error.jsp");
}
%>                


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
                <%
                if(codigo_regional.equals("")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Regional
                      </span>
                      <bean:message key="jsp.fieldnotnull"/>
                    </td>
                    <td class="formField">
                      <html:text property="regional" onblur="fillFields(0,new Array('regional'),'Sbr060ActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="baseField" size="3" maxlength="3"/>
                      <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_regional()"  >
                      <script type="text/javascript">
                        function lov_open_regional() {
                          window.open('../lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=regional&return1=nome_regional','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>
                    </td>
                  </tr>

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Inicial
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="pf_ped_dadg_ini" styleId="pf_ped_dadg_ini" styleClass="baseField" size="10" maxlength="10"/>
                     
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['pf_ped_dadg_ini']); cal1.year_scroll = true; cal1.popup();">
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
                    <html:text property="pf_ped_dadg_fim" styleId="pf_ped_dadg_fim" styleClass="baseField" size="10" maxlength="10"/>
                     
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['pf_ped_dadg_fim']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Unid. Negócio
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="pf_1" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="000">
                        Todas
                      </html:option>
                      <html:option styleClass="baseOption" value="01">
                        01 - Manufaturados
                      </html:option>
                      <html:option styleClass="baseOption" value="02">
                        02 - Expandidos
                      </html:option>
                      <html:option styleClass="baseOption" value="03">
                        03 - Injeção direta
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo de Mercado
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="pf_tipo_mercado" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="MI">
                        MI
                      </html:option>
                      <html:option styleClass="baseOption" value="ME">
                        ME
                      </html:option>
                      <html:option styleClass="baseOption" value="Todos">
                        Todos
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca Inicial
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="pf_marca_ini" onblur="fillFields(0,new Array('pf_marca_ini'),'Sbr060ActionForm.getDescricao_marca_Ajax',new Array('descricao_marca'));" styleClass="baseField" size="3" maxlength="3"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_pf_marca_ini()"  >
                    <script type="text/javascript">
                      function lov_open_pf_marca_ini() {
                        window.open('../lov/LvMarcaLov.do?resetfull_action=&returnBlock=0&return0=pf_marca_ini&return1=descricao_marca','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="descricao_marca" styleId="descricao_marca" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca Final
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="pf_marca_fim" onblur="fillFields(0,new Array('pf_marca_fim'),'Sbr060ActionForm.getDescricao_marca1_Ajax',new Array('descricao_marca1'));" styleClass="baseField" size="3" maxlength="3"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_pf_marca_fim()"  >
                    <script type="text/javascript">
                      function lov_open_pf_marca_fim() {
                        window.open('../lov/LvMarcaLov.do?resetfull_action=&returnBlock=0&return0=pf_marca_fim&return1=descricao_marca1','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="descricao_marca1" styleId="descricao_marca1" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Quantidade de linhas mais vendidas
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="pf_qtd_linhas" styleClass="baseField" size="5" maxlength="5"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Somente linhas do "MIX"
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="pf_2" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="S">
                        Sim
                      </html:option>
                      <html:option styleClass="baseOption" value="T">
                        Todas
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <html:hidden property="reg" value="<%= codigo_regional %>"/>
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
                    <html:text property="mensagem" style="background-color:transparent; border-style:none; color:red; background-color:transparent; border-style:none; cursor:default; text-align:start;" styleClass="baseField" readonly="true" size="90" maxlength="90"/>
                  </td>
                </tr>
<tr class="itemTr">
<td class="formLabel"><span class="spamFormLabel"></span>
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
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="p" onclick="resetfull1_action.disabled=true;this.disabled=true;bloqueia();document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
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

                    </html:form>
                    <script type="text/javascript">
                    var focusControl = document.forms[0].elements["pf_ped_dadg_ini"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>

                </td>
              </tr>
            </table>

          </body>
        </center>
<script>
jQuery(document).ready(function($) {
   $("#pf_ped_dadg_ini").mask("99/99/9999");
   $("#pf_ped_dadg_fim").mask("99/99/9999");
});
</script>
      </html>

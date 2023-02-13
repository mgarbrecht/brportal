<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ClientesNovosAntigosActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ClientesNovosAntigosActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("p_dt_inicial","Data Inicial");
    hashMapLabel.set("p_dt_final","Data Final");
    hashMapLabel.set("codigo_marca","Marca");
    hashMapLabel.set("descricao_marca","");
    hashMapLabel.set("f_regi","");
    hashMapLabel.set("reg","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("f_regf","");
    hashMapLabel.set("f_repi","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("f_repf","");
    hashMapLabel.set("clientes","Clientes");
    hashMapLabel.set("cb_quebra_regional","Quebra por Regional");
    hashMapLabel.set("cb_somente_resumo","Somente Resumo");
    hashMapLabel.set("cb_resumo_geral","Geral");
    hashMapLabel.set("cb_resumo_marca","Marca");
    hashMapLabel.set("cb_resumo_regional","Regional");
    hashMapLabel.set("cb_resumo_representante","Representante");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Consulta de Clientes Novos/Antigos/Reativados
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
                  <%@ include file="../system/header_sem_ajuda.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(149)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ClientesNovosAntigosForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="p_dt_inicial"/>
                    <html:errors property="p_dt_final"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="descricao_marca"/>
                    <html:errors property="reg"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="clientes"/>
                    <html:errors property="cb_quebra_regional"/>
                    <html:errors property="cb_somente_resumo"/>
                    <html:errors property="cb_resumo_geral"/>
                    <html:errors property="cb_resumo_marca"/>
                    <html:errors property="cb_resumo_regional"/>
                    <html:errors property="cb_resumo_representante"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_novos_antigos"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String codigo_regional="";
                String codigo_representante="";
                //   String codigo_analista="";
                String tipo="";
                //   String cliente="";
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
                  //        if(tipo.equals("ANALISTA REGIONAL")){
                    //          codigo_analista = ent.getChave()+"";
                  //        }
                  //        if(tipo.equals("CLIENTE MERCADO EXTERNO")){
                    //          cliente = ent.getChave()+"";
                  //        }
                  //        if(tipo.equals("CLIENTE MERCADO INTERNO")){
                    //          cliente = ent.getChave()+"";
                  //        }
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
                    <html:text property="p_dt_inicial" styleId="p_dt_inicial" styleClass="baseField" size="10" maxlength="10"/>
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
                    <html:text property="p_dt_final" styleId="p_dt_final" styleClass="baseField" size="10" maxlength="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_marca" styleId="codigo_marca" onblur="if(this.value!=''){fillFields(0,new Array('codigo_marca'),'ClientesNovosAntigosActionForm.getDescricao_marca_Ajax',new Array('descricao_marca'))}else{descricao_marca.value='';};" styleClass="baseField" size="3" maxlength="3"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_marca()"  >
                    <script type="text/javascript">
                      function lov_open_codigo_marca() {
                        window.open('..//lov/LvMarcaLov.do?resetfull_action=&returnBlock=0&return0=codigo_marca&return1=descricao_marca','','scrollbars=yes,height=600,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="descricao_marca" styleId="descricao_marca" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="30"/>
                  </td>
                </tr>

                <%
                if(codigo_regional.equals("")
                && codigo_representante.equals("")
                ){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Regional
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="reg" styleId="reg" onblur="if(this.value!=''){fillFields(0,new Array('reg'),'ClientesNovosAntigosActionForm.getNome_regional_Ajax',new Array('nome_regional'))}else{nome_regional.value='';};" styleClass="baseField" size="3" maxlength="3"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_reg()"  >
                      <script type="text/javascript">
                        function lov_open_reg() {
                          window.open('..//lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=reg&return1=nome_regional','','scrollbars=yes,height=600,width=730,top=0,left=0,');
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
                if(codigo_representante.equals("")) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Representante
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="rep_cdgo" styleId="rep_cdgo" onblur="if(this.value!=''){fillFields(0,new Array('rep_cdgo'),'ClientesNovosAntigosActionForm.getRep_rzao_Ajax',new Array('rep_rzao'))}else{rep_rzao.value='';};" styleClass="baseField" size="5" maxlength="5"/>
                      <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_rep_cdgo() {
                          window.open('..//lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=600,width=730,top=0,left=0,');
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
                  <html:hidden property="rep_cdgo" value="<%= codigo_representante %>"/>
                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Clientes
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="clientes" styleId="clientes" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="Antigos">
                        Antigos
                      </html:option>
                      <html:option styleClass="baseOption" value="Novos">
                        Novos
                      </html:option>
                      <html:option styleClass="baseOption" value="Reativados">
                        Reativados
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Quebra por Regional
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_quebra_regional" styleId="cb_quebra_regional" styleClass="baseField" value="S"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Somente Resumo
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_somente_resumo" styleId="cb_somente_resumo" styleClass="baseField" value="S"/>
                  </td>
                </tr>

                <tr  class="itemTr">
                  <td  class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
<td <br> <table border=1 style="border-color:#f4c5a2"> <tr> <td align="center" colspan=4><b>Resumos</b></td> </tr>  <tr> <td align="center"><font color="white">...</font>Geral<font color="white">...</font></td> <td align="center"><font color="white">...</font>Por Marca<font color="white">...</font></td> <td align="center"><font color="white">...</font>Por Regional<font color="white">...</font></td> <td align="center"><font color="white">...</font>Por Representante<font color="white">...</font></td> </tr> <tr> <td align="center"> <html:checkbox property="cb_resumo_geral" styleClass="baseField" value="S"/> </td> <td align="center"> <html:checkbox property="cb_resumo_marca" styleClass="baseField" value="S"/> </td> <td align="center"> <html:checkbox property="cb_resumo_regional" styleClass="baseField" value="S"/> </td> <td align="center"> <html:checkbox property="cb_resumo_representante" styleClass="baseField" value="S"/> </td> </tr> </table>  </td> </tr>  </table>  <table class="buttonTable" style='width:99%;'><tr class="buttonTr"> <td class="buttonTd"> <html:button accesskey="p" onclick="bloqueia();resetfull1_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:button> <script> function getKeySite(keyStroke) { isNetscape=(document.layers); eventChooser = (isNetscape) ? keyStroke.which : event.keyCode; which = String.fromCharCode(eventChooser).toLowerCase(); keyBuffer = which; if(eventChooser == 13){ bloqueia(); if(document.forms[0].select1_action.disabled==true){return false;} document.forms[0].select1_action.disabled=true; document.forms[0].resetfull1_action.disabled=true; document.forms[0].select_action.click(); } } </script> <SCRIPT> document.onkeypress = getKeySite; </SCRIPT><html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button> <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit> <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit> </td> </tr> </table>  <script type="text/javascript"> jQuery(document).ready(function($) { $("#p_dt_inicial").mask("99/99/9999"); $("#p_dt_final").mask("99/99/9999"); }); </script> </html:form><script type="text/javascript"> var focusControl = document.forms[0].elements["p_dt_inicial"]; if (focusControl.type != "hidden"){ focusControl.focus(); } </script> </td> </tr> </table>  </body> </center> </html>

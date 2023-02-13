<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/Sbr080ActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = Sbr080ActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("reg","");
    hashMapLabel.set("regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("dt_inicial","Data Inicial");
    hashMapLabel.set("dt_final","Data Final");
    hashMapLabel.set("marca_inicial","Marca Inicial");
    hashMapLabel.set("marca_final","Marca Final");
    hashMapLabel.set("abre_automaticamente","Abre o Relatório Automaticamente");
    hashMapLabel.set("mensagem","");
    hashMapLabel.set("f_pdf","");
    hashMapLabel.set("rep","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Relatório de Cadastramento de Clientes
    </title>
  </head>
  <center>
    <body onload="if(document.forms[0].reg.value!=''){document.forms[0].rep_cdgo.focus();}if(document.forms[0].rep.value!=''){document.forms[0].dt_inicial.focus();}if('<%= (String)request.getAttribute("arquivo") %>' == 'null'){document.forms[0].abre_automaticamente.checked=false;document.forms[0].mensagem.value='';}if(document.forms[0].abre_automaticamente.checked==true){if('<%= (String)request.getAttribute("arquivo") %>' != 'null'){window.open('<%= (String)request.getAttribute("arquivo") %>','_blank');}}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(94)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/Sbr080Form.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <%
                    String codigo_regional = ""; String codigo_representante = ""; String tipo = ""; acesso.Usuario u = new acesso.Usuario();u = (acesso.Usuario)session.getAttribute("User");acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();if(!(u.getEntidadeNegocio()==null)){ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();tipo = tipoent.getTipo()+"";if(tipo.equals("REGIONAL DE VENDA")){codigo_regional = ent.getChave()+"";}if((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))){codigo_representante = ent.getChave()+"";}}
                    %>
                    <%
                    if(codigo_regional.equals("") && codigo_representante.equals("")) {
                      %>
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
                      <%
                    } else {
                      %>
                      <div class\='div10l'>
                        Todos os campos com
                        <img src='../img/required.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        devem ser preenchidos.
                      </div>
                      <%
                    }
                    %>
                  </div>
                  <html:errors property="regional"/>
                  <html:errors property="nome_regional"/>
                  <html:errors property="rep_cdgo"/>
                  <html:errors property="rep_rzao"/>
                  <html:errors property="dt_inicial"/>
                  <html:errors property="dt_final"/>
                  <html:errors property="marca_inicial"/>
                  <html:errors property="marca_final"/>
                  <html:errors property="abre_automaticamente"/>
                  <html:errors property="mensagem"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:99%;">
              <html:hidden property="reg" value="<%= codigo_regional %>"/>
              <%
              if(codigo_regional.equals("") && codigo_representante.equals("")){
                %>

                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Regional
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="regional" styleClass="baseField" onblur="fillFields(0,new Array('regional'),'Sbr080ActionForm.getNome_regional_Ajax',new Array('nome_regional'));" size="3" maxlength="3"/>
                    <input type="button" class="lovButton" value="..." tabindex="-1" onclick="window.open('../lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=regional&return1=nome_regional','','scrollbars,height=510,width=600,top=0,left=0,')"/>

                    <%
                  }  else {
                    %>

                    <html:hidden property="regional" value="<%= codigo_regional %>"/>

                    <%
                  }
                  %>
                  <%
                  if(codigo_regional.equals("") && codigo_representante.equals("")){
                    %>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="43" maxlength="40"/>
                  </td>
                </tr>
                <%
              }
              %>
              <%
              if(!codigo_regional.equals("")){
                %>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Representante
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="rep_cdgo" styleClass="baseField" onblur="fillFields(0,new Array('rep_cdgo'),'Sbr080ActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" size="5" maxlength="5"/>
                    <input type="button" class="lovButton" value="..." tabindex="-1" onclick="window.open('../lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                    <%
                  } else if (codigo_regional.equals("") && codigo_representante.equals("")){
                    %>
                    <tr>
                      <td class="formLabel">
                        <span class="spamFormLabel" >
                          Representante
                        </span>
                        <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      </td>
                      <td class="formField">
                        <html:text property="rep_cdgo" styleClass="baseField" onblur="fillFields(0,new Array('rep_cdgo'),'Sbr080ActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" size="5" maxlength="5"/>
                        <input type="button" class="lovButton" value="..." tabindex="-1" onclick="window.open('../lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                        <%
                      } else {
                        %>
                        <html:hidden property="rep_cdgo" value="<%= codigo_representante %>"/>
                        <%
                      }
                      %>
                      <%
                      if(codigo_representante.equals("")){
                        %>
                        <span class="spamFormLabel" >
                        </span>
                        <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
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
                      <html:text property="dt_final" styleId="dt_final" styleClass="baseField" size="10" maxlength="10"/>
                      &nbsp;
                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_final']); cal1.year_scroll = true; cal1.popup();">
                        <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                      </a>
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
                      <html:text property="marca_inicial" styleClass="baseField" size="3" maxlength="3"/>
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
                      <html:text property="marca_final" styleClass="baseField" size="3" maxlength="3"/>
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
                      <html:text property="mensagem" style="background-color:transparent; border-style:none; color:red; background-color:transparent; border-style:none; cursor:default; text-align:start;" styleClass="baseField" readonly="true" size="90" maxlength="90"/>
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
                      <html:hidden property="rep" value="<%= codigo_representante %>"/>
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

                        <script type="text/javascript">
                        jQuery(document).ready(function($) {
                          $("#dt_inicial").mask("99/99/9999");
                          $("#dt_final").mask("99/99/9999");
                          });
                        </script>
                      </html:form>
                      <script type="text/javascript">
                        var focusControl = document.forms[0].elements["regional"];
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

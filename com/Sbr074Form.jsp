<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/Sbr074ActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = Sbr074ActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("dt_inicial","Data Inicial");
    hashMapLabel.set("dt_final","Data Final");
    hashMapLabel.set("f_regi","");
    hashMapLabel.set("regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("f_regf","");
    hashMapLabel.set("f_repi","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("f_repf","");
    hashMapLabel.set("codigo_marca","Marca");
    hashMapLabel.set("descricao_marca","");
    hashMapLabel.set("indicador","Indicador");
    hashMapLabel.set("mercado","Mercado");
    hashMapLabel.set("mix","Modelos do Mix");
    hashMapLabel.set("abre_automaticamente","Abre o Relatório Automaticamente");
    hashMapLabel.set("mensagem","");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Clientes Atendidos por Representante e Linha
    </title>
  </head>
  <center>
    <body onload="if('<%= (String)request.getAttribute("arquivo") %>' == 'null'){document.forms[0].abre_automaticamente.checked=false;document.forms[0].mensagem.value='';}if(document.forms[0].abre_automaticamente.checked==true){if('<%= (String)request.getAttribute("arquivo") %>' != 'null'){window.open('<%= (String)request.getAttribute("arquivo") %>','_blank');}}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(93)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/Sbr074Form.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="dt_inicial"/>
                    <html:errors property="dt_final"/>
                    <html:errors property="regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="descricao_marca"/>
                    <html:errors property="indicador"/>
                    <html:errors property="mercado"/>
                    <html:errors property="mix"/>
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
                String codigo_analista="";
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
                  if(tipo.equals("ANALISTA REGIONAL")){
                    codigo_analista= ent.getChave()+"";
                  }

                }

                if(tipo.equals("ANALISTA REGIONAL")){
                  com.egen.util.jdbc.JdbcUtil j = null;
                  try{
                    j = new com.egen.util.jdbc.JdbcUtil();
                    portalbr.dbobj.view.Jw_regional_analista table = new portalbr.dbobj.view.Jw_regional_analista();
                    String[][] select = null;
                    Object[][] where = {{"codigo_gerente","=",codigo_analista} };
                    Vector res_Jw_regional_analista = j.select(table, select, where, null, null, null);
                    if (res_Jw_regional_analista != null && res_Jw_regional_analista.size() > 0) {
                      portalbr.dbobj.view.Jw_regional_analista r = (portalbr.dbobj.view.Jw_regional_analista) res_Jw_regional_analista.elementAt(0);
                      codigo_regional = r.getCodigo_regional();
                    }

                  } finally {
                  if(j!=null) {j.close();}
                }
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

              <%
              if((codigo_regional.equals("")) && (codigo_representante.equals(""))){
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Regional
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="regional" onblur="fillFields(0,new Array('regional'),'Sbr074ActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="baseField" size="3" maxlength="3"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_regional()"  >
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
              }else{
                %>
                <html:hidden property="regional" value="<%= codigo_regional %>"/>
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
                    <html:text property="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'Sbr074ActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="5" maxlength="5"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_rep_cdgo() {
                        window.open('../lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                  </td>
                </tr>

                <%
              }else {
                %>
                <html:hidden property="rep_cdgo" value="<%= codigo_representante %>"/>
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
                  <html:text property="codigo_marca" onblur="fillFields(0,new Array('codigo_marca'),'Sbr074ActionForm.getDescricao_marca_Ajax',new Array('descricao_marca'));" styleClass="baseField" size="3" maxlength="3"/>
                  <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_marca()"  >
                  <script type="text/javascript">
                    function lov_open_codigo_marca() {
                      window.open('../lov/LvMarcaLov.do?resetfull_action=&returnBlock=0&return0=codigo_marca&return1=descricao_marca','','scrollbars=yes,height=510,width=600,top=0,left=0,');
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
                    Indicador
                  </span>
                </td>
                <td class="formField">
                  <html:select property="indicador" styleClass="baseField" size="1">
                    <html:option styleClass="baseOption" value="A">
                      Aberto
                    </html:option>
                    <html:option styleClass="baseOption" value="F">
                      Fechado
                    </html:option>
                    <html:option styleClass="baseOption" value="T">
                      Todos
                    </html:option>
                  </html:select>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Mercado
                  </span>
                </td>
                <td class="formField">
                  <html:select property="mercado" styleClass="baseField" size="1">
                    <html:option styleClass="baseOption" value="MI">
                      Interno
                    </html:option>
                    <html:option styleClass="baseOption" value="ME">
                      Externo
                    </html:option>
                    <html:option styleClass="baseOption" value="T">
                      Todos
                    </html:option>
                  </html:select>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Modelos do Mix
                  </span>
                </td>
                <td class="formField">
                  <html:select property="mix" styleClass="baseField" size="1">
                    <html:option styleClass="baseOption" value="N">
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
                      $("#dt_inicial").mask("99/99/9999");
                      $("#dt_final").mask("99/99/9999");
                      });
                    </script>
                  </html:form>
                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["dt_inicial"];
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

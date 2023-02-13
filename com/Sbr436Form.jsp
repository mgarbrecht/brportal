<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/Sbr436ActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = Sbr436ActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("dia_inicial","Dia Inicial");
    hashMapLabel.set("f_regi","");
    hashMapLabel.set("codigo_regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("f_regf","");
    hashMapLabel.set("situacaoERC","");
    hashMapLabel.set("f_repi","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("f_repf","");
    hashMapLabel.set("codigo_marca","Marca");
    hashMapLabel.set("unn_codigo","Unidade Negócio");
    hashMapLabel.set("unn_descri","");
    hashMapLabel.set("tipo","Tipo");
    hashMapLabel.set("tipo_diario_semanal","");
    hashMapLabel.set("f_venda_i","");
    hashMapLabel.set("venda","Venda");
    hashMapLabel.set("f_venda_f","");
    hashMapLabel.set("f_resumo_i","");
    hashMapLabel.set("resumo","Somente Resumo");
    hashMapLabel.set("f_resumo_f","");
    hashMapLabel.set("tipo_pedido","Tipo Pedido");
    hashMapLabel.set("ind_aberto_fechado","Tipo Negócio");
    hashMapLabel.set("cli_antigos","Clientes Novos/Antigos");
    hashMapLabel.set("cb_marca_rep","Por Representante");
    hashMapLabel.set("abre_unidade","Abrir Por Unid. Negócio");
    hashMapLabel.set("abre_automaticamente","Abre o Relatório Automaticamente");
    hashMapLabel.set("mensagem1","");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Entrada de Pedidos Semanal
    </title>
  </head>
  <center>
    <body onload="document.forms[0].abre_unidade.checked=true;if('<%= (String)request.getAttribute("arquivo") %>' == 'null'){document.forms[0].abre_automaticamente.checked=false;document.forms[0].mensagem1.value='';}if(document.forms[0].abre_automaticamente.checked==true){if('<%= (String)request.getAttribute("arquivo") %>' != 'null'){window.open('<%= (String)request.getAttribute("arquivo") %>','_blank');}}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(114)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/Sbr436Form.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="dia_inicial"/>
                    <html:errors property="codigo_regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="situacaoERC"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="unn_codigo"/>
                    <html:errors property="unn_descri"/>
                    <html:errors property="tipo"/>
                    <html:errors property="tipo_diario_semanal"/>
                    <html:errors property="venda"/>
                    <html:errors property="resumo"/>
                    <html:errors property="tipo_pedido"/>
                    <html:errors property="ind_aberto_fechado"/>
                    <html:errors property="cli_antigos"/>
                    <html:errors property="cb_marca_rep"/>
                    <html:errors property="abre_unidade"/>
                    <html:errors property="abre_automaticamente"/>
                    <html:errors property="mensagem1"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String codigo_regional       = "";
                String codigo_representante  = "";
                String codigo_analista       = "";
                String tipo                  = "";
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

                if(tipo.equals("ANALISTA REGIONAL")) {
                  com.egen.util.jdbc.JdbcUtil j = null;
                  try {
                    j = new com.egen.util.jdbc.JdbcUtil();
                    portalbr.dbobj.view.Jw_regional_analista table = new portalbr.dbobj.view.Jw_regional_analista();
                    String[][] select = null;
                    Object[][] where  = {
                    {"codigo_gerente","=",codigo_analista}
                    };
                    Vector res_Jw_regional_analista = j.select(table, select, where, null, null, null);
                    if (res_Jw_regional_analista != null && res_Jw_regional_analista.size() > 0) {
                      portalbr.dbobj.view.Jw_regional_analista r = (portalbr.dbobj.view.Jw_regional_analista) res_Jw_regional_analista.elementAt(0);
                      codigo_regional = r.getCodigo_regional();
                    }
                  } finally {
                    if(j!=null) {
                      j.close();
                      j = null;
                    }
                  }
                }
                %>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Dia Inicial
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="dia_inicial" styleId="dia_inicial" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dia_inicial']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <%
                if(codigo_regional.equals("")&&codigo_representante.equals("")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Regional
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="codigo_regional" onblur="fillFields(0,new Array('codigo_regional'),'Sbr436ActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="baseField" size="3" maxlength="3"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..." onclick="javascript:lov_open_codigo_regional()"  >
                      <script type="text/javascript">
                        function lov_open_codigo_regional() {
                          window.open('../lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=codigo_regional&return1=nome_regional','','scrollbars=yes,height=510,width=600,top=0,left=0,');
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
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="situacaoERC" style="display:none; text-align:start;" styleClass="baseField">
                      <html:option styleClass="baseOption" value="t">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="a">
                        Ativos
                      </html:option>
                      <html:option styleClass="baseOption" value="i">
                        Inativos
                      </html:option>
                    </html:select>
                  </td>
                </tr>

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
                      <html:text property="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'Sbr436ActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="5" maxlength="5"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_rep_cdgo() {
                          window.open('../lov/LvRepresentanteLov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
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
                      Marca
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="codigo_marca" styleId="codigo_marca" styleClass="baseField">
                      <html:option styleClass="baseOption" value="\"selected='selected'">
                        TODAS
                      </html:option>
                      <html:option styleClass="baseOption" value="3">
                        BEIRA RIO
                      </html:option>
                      <html:option styleClass="baseOption" value="9">
                        MODARE
                      </html:option>
                      <html:option styleClass="baseOption" value="18">
                        BRSPORT
                      </html:option>
                      <html:option styleClass="baseOption" value="16">
                        MOLECA
                      </html:option>
                      <html:option styleClass="baseOption" value="17">
                        MOLEKINHA
                      </html:option>
                      <html:option styleClass="baseOption" value="19">
                        MOLEKINHO
                      </html:option>
                      <html:option styleClass="baseOption" value="16,17">
                        MOLECA + MOLEKINHA
                      </html:option>
                      <html:option styleClass="baseOption" value="20">
                        ACTVITTA
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Unidade Negócio
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="unn_codigo" onblur="fillFields(0,new Array('unn_codigo'),'Sbr436ActionForm.getUnn_descri_Ajax',new Array('unn_descri'));" styleClass="baseField" size="3" maxlength="3"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_unn_codigo()"  >
                    <script type="text/javascript">
                      function lov_open_unn_codigo() {
                        window.open('../lov/LvUnidadeNegocioLov.do?resetfull_action=&returnBlock=0&return0=unn_codigo','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="unn_descri" styleId="unn_descri" styleClass="disabled" tabindex="-1" readonly="true" size="55" maxlength="50"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="m">
                        Marca
                      </html:option>
                      <html:option styleClass="baseOption" value="r">
                        Regional
                      </html:option>
                    </html:select>
                    <span class="spamFormLabel">
                    </span>
                    <html:select property="tipo_diario_semanal" onchange="refresh_action.click();" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="D">
                        Diário
                      </html:option>
                      <html:option styleClass="baseOption" value="S">
                        Semanal
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <%
                portalbr.com.Sbr436ActionForm sbr = (portalbr.com.Sbr436ActionForm) session.getAttribute("Sbr436ActionForm");
                String tipo_diario_semanal = sbr.getTipo_diario_semanal();
                if(
                ((tipo_diario_semanal+"").equals("D")) || tipo_diario_semanal == null

                ){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Venda
                      </span>
                    </td>
                    <td class="formField">
                      <html:select property="venda" styleId="venda" onchange="refresh_action.click();" styleClass="baseField" size="1">
                        <html:option styleClass="baseOption" value="a">
                          Ambos
                        </html:option>
                        <html:option styleClass="baseOption" value="cv">
                          Com Venda
                        </html:option>
                        <html:option styleClass="baseOption" value="sv">
                          Sem Venda
                        </html:option>
                      </html:select>
                      <%
                    } else {
                      %>
                      <html:hidden property="venda" value="a"/>
                      <%
                    }
                    %>
                    <%
                    portalbr.com.Sbr436ActionForm f = (portalbr.com.Sbr436ActionForm) session.getAttribute("Sbr436ActionForm");
                    String opcao = f.getVenda()+"";

                    if(opcao.toUpperCase().equals("SV")){
                      %>
                      <html:checkbox property="resumo" styleId="resumo" styleClass="baseField" value="checked"/>
                      <span class="spamFormLabel">
                        Somente Resumo
                      </span>
                    </td>
                  </tr>

                  <%
                }else{
                  %>
                  <br />
                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo Pedido
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo_pedido" styleId="tipo_pedido" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="T">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="pp">
                        PP
                      </html:option>
                      <html:option styleClass="baseOption" value="pg">
                        PG
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo Negócio
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="ind_aberto_fechado" styleId="ind_aberto_fechado" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="@M@">
                        Manufaturados
                      </html:option>
                      <html:option styleClass="baseOption" value="@E@R@">
                        Injetados
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Clientes Novos/Antigos
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cli_antigos" styleClass="baseField" value="S"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Por Representante
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_marca_rep" styleId="cb_marca_rep" styleClass="baseField" value="checked"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Abrir Por Unid. Negócio
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="abre_unidade" styleId="abre_unidade" styleClass="baseField" value="S"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Abre o Relatório Automaticamente
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="abre_automaticamente" onclick="if(this.checked==true){mensagem1.value='Obs.: Uma nova janela será aberta para a visualização do relatório.';}else{mensagem1.value='';}" styleClass="baseField" value="checked"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="mensagem1" style="background-color:transparent; border-style:none; color:red; background-color:transparent; border-style:none; cursor:default; text-align:start;" styleClass="baseField" readonly="true" size="90" maxlength="90"/>
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
                      </SCRIPT><html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                      <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                      <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                      <html:submit accesskey="l" styleClass="myhidden" property="refresh_action"><bean:message bundle="ApplicationResources" key="jsp.refresh"/></html:submit>
                      </td>
                      </tr>
                      </table>

                      <script type="text/javascript">
                      jQuery(document).ready(function($) {
                        $("#dia_inicial").mask("99/99/9999");
                        });
                      </script>
                    </html:form>
                    <script type="text/javascript">
                      var focusControl = document.forms[0].elements["dia_inicial"];
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

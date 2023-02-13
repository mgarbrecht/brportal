<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/SugestaoClientesLimiteCreditoActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = SugestaoClientesLimiteCreditoActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("f_regi","");
    hashMapLabel.set("codigo_regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("f_regf","");
    hashMapLabel.set("f_repi","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("f_repf","");
    hashMapLabel.set("gre_grupo","Grupo Econômico");
    hashMapLabel.set("gre_descricao","");
    hashMapLabel.set("cli_cdgo","Cliente");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("descricao_cidade1","");
    hashMapLabel.set("descricao_cidade2","");
    hashMapLabel.set("descricao_cidade3","");
    hashMapLabel.set("descricao_cidade4","");
    hashMapLabel.set("descricao_cidade5","");
    hashMapLabel.set("codigo_cidade1","Cidade");
    hashMapLabel.set("codigo_cidade2","Cidade");
    hashMapLabel.set("codigo_cidade3","Cidade");
    hashMapLabel.set("codigo_cidade4","Cidade");
    hashMapLabel.set("codigo_cidade5","Cidade");
    hashMapLabel.set("tipo_mercado","Tipo de Mercado");
    hashMapLabel.set("quantidade","Qtde.");
    hashMapLabel.set("meses","Meses atrás");
    hashMapLabel.set("ordenacao","Ordenar por");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Sugestão de Clientes com Limite de Crédito Disponível para Venda
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(199)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="adm/SugestaoClientesLimiteCreditoForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="codigo_regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="gre_grupo"/>
                    <html:errors property="gre_descricao"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="descricao_cidade1"/>
                    <html:errors property="descricao_cidade2"/>
                    <html:errors property="descricao_cidade3"/>
                    <html:errors property="descricao_cidade4"/>
                    <html:errors property="descricao_cidade5"/>
                    <html:errors property="tipo_mercado"/>
                    <html:errors property="quantidade"/>
                    <html:errors property="meses"/>
                    <html:errors property="ordenacao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_maiores_clientes_limite_credito"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String regional = "";
                String representante = "";
                String analista = "";
                util.consultas.Query query = new util.consultas.Query();
                acesso.Sessao sessao = new acesso.Sessao(session);
                if(sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")){
                  regional = sessao.getChave();
                }
                if((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO"))){
                  representante = sessao.getChave();
                }
                if(sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")){
                  analista = sessao.getChave();
                  regional = query.retorna("select codigo_regional FROM gerentes_regionais_vendas g WHERE g.situacao_gerente = 'A' AND g.codigo_gerente = " + analista);
                }
                %>
                <%
                if(regional.equals("") && representante.equals("")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Regional
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="codigo_regional" styleId="codigo_regional" onblur="fillFields(0,new Array('codigo_regional'),'SugestaoClientesLimiteCreditoActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="baseField" size="3"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_regional()"  >
                      <script type="text/javascript">
                        function lov_open_codigo_regional() {
                          window.open('..//lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=codigo_regional&return1=nome_regional','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="codigo_regional" value="<%= regional %>"/>
                  <html:hidden property="nome_regional"/>

                  <%
                }
                %>
                <%
                if(representante.equals("")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Representante
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="rep_cdgo" styleId="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'SugestaoClientesLimiteCreditoActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="5"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_rep_cdgo() {
                          window.open('..//lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="rep_cdgo" value="<%= representante %>"/>
                  <html:hidden property="rep_rzao"/>

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Grupo Econômico
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="gre_grupo" styleId="gre_grupo" onblur="if(this.value!=''){fillFields(0,new Array('gre_grupo'),'SugestaoClientesLimiteCreditoActionForm.getGre_descricao_Ajax',new Array('gre_descricao'));}else{gre_descricao.value='';}" styleClass="baseField" size="6" maxlength="10"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_gre_grupo()"  >
                    <script type="text/javascript">
                      function lov_open_gre_grupo() {
                        window.open('..//lov/LvGrupoEconomicoLov.do?resetfull_action=&returnBlock=0&return0=gre_grupo&return1=gre_descricao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="gre_descricao" styleId="gre_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cliente
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_cdgo" styleId="cli_cdgo" onblur="if(this.value!=''){fillFields(0,new Array('cli_cdgo'),'SugestaoClientesLimiteCreditoActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));}else{cli_rzao.value='';}" styleClass="baseField" size="10" maxlength="22"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cli_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_cli_cdgo() {
                        window.open('..//lov/LvClienteLov.do?resetfull_action=&returnBlock=0&return0=cli_cdgo&return1=cli_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cli_rzao" styleId="cli_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="55" maxlength="55"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                  </td>
                  <td class="formField">
                    <input type="button" value="Cidades" onclick="jQuery('#cidades').toggle('fast');"/>
                    <table border="0" id="cidades" style="display:none" width="700px">
                      <tr>
                        <td>

                          <html:text property="descricao_cidade1" styleId="descricao_cidade1" styleClass="disabled" tabindex="-1" readonly="true" size="50"/>
                          <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_descricao_cidade1()"  >
                          <script type="text/javascript">
                            function lov_open_descricao_cidade1() {
                              window.open('..//lov/LvMunicipiosLov.do?resetfull_action=&returnBlock=0&return0=codigo_cidade1&return1=descricao_cidade1','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                            }
                          </script>

                        </td>
                      </tr>
                      <tr>
                        <td>
                          <html:text property="descricao_cidade2" styleId="descricao_cidade2" styleClass="disabled" readonly="true" tabindex="-1" size="50"/>
                          <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_descricao_cidade2()"  >
                          <script type="text/javascript">
                            function lov_open_descricao_cidade2() {
                              window.open('..//lov/LvMunicipiosLov.do?resetfull_action=&returnBlock=0&return1=descricao_cidade2&return0=codigo_cidade2','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                            }
                          </script>
                        </td>
                      </tr>

                      <tr>
                        <td>
                          <html:text property="descricao_cidade3" styleId="descricao_cidade3" styleClass="disabled" tabindex="-1" readonly="true" size="50"/>
                          <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_descricao_cidade3()"  >
                          <script type="text/javascript">
                            function lov_open_descricao_cidade3() {
                              window.open('..//lov/LvMunicipiosLov.do?resetfull_action=&returnBlock=0&return1=descricao_cidade3&return0=codigo_cidade3','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                            }
                          </script>
                        </td>
                      </td>
                    </tr>

                    <tr>
                      <td>
                        <html:text property="descricao_cidade4" styleId="descricao_cidade4" styleClass="disabled" tabindex="-1" readonly="true" size="50"/>
                        <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_descricao_cidade4()"  >
                        <script type="text/javascript">
                          function lov_open_descricao_cidade4() {
                            window.open('..//lov/LvMunicipiosLov.do?resetfull_action=&returnBlock=0&return1=descricao_cidade4&return0=codigo_cidade4','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                          }
                        </script>
                      </td>
                    </tr>

                    <tr>
                      <td>
                        <html:text property="descricao_cidade5" styleId="descricao_cidade5" styleClass="disabled" tabindex="-1" readonly="true" size="50"/>
                        <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_descricao_cidade5()"  >
                        <script type="text/javascript">
                          function lov_open_descricao_cidade5() {
                            window.open('..//lov/LvMunicipiosLov.do?resetfull_action=&returnBlock=0&return1=descricao_cidade5&return0=codigo_cidade5','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                          }
                        </script>
                      </td>
                    </tr>

                  </table>
                </td>
              </tr>



              <html:hidden property="codigo_cidade1"/>
              <html:hidden property="codigo_cidade2"/>
              <html:hidden property="codigo_cidade3"/>
              <html:hidden property="codigo_cidade4"/>
              <html:hidden property="codigo_cidade5"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Tipo de Mercado
                  </span>
                </td>
                <td class="formField">
                  <html:select property="tipo_mercado" styleId="tipo_mercado" styleClass="baseField" size="1">
                    <html:option styleClass="baseOption" value="null">
                      Todos
                    </html:option>
                    <html:option styleClass="baseOption" value="'MI'">
                      Mercado Interno
                    </html:option>
                    <html:option styleClass="baseOption" value="'EX'">
                      Mercado Externo
                    </html:option>
                  </html:select>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Qtde.
                  </span>
                </td>
                <td class="formField">
                  <html:select property="quantidade" styleId="quantidade" styleClass="baseField" size="1">
                    <html:option styleClass="baseOption" value="10">
                      10
                    </html:option>
                    <html:option styleClass="baseOption" value="50\"selected='selected'">
                      50
                    </html:option>
                    <html:option styleClass="baseOption" value="100">
                      100
                    </html:option>
                  </html:select>
                  <span class='validateMessageuser'>
                    maiores clientes/grupos
                  </span>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Meses atrás
                  </span>
                  <bean:message key="jsp.fieldnotnull"/>
                </td>
                <td class="formField">
                  <html:text property="meses" styleId="meses" styleClass="baseField" value="12" size="2" maxlength="2"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Ordenar por
                  </span>
                </td>
                <td class="formField">
                  <html:select property="ordenacao" styleId="ordenacao" styleClass="baseField" size="1">
                    <html:option styleClass="baseOption" value="l">
                      Limite
                    </html:option>
                    <html:option styleClass="baseOption" value="s">
                      Saldo
                    </html:option>
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
                </SCRIPT><html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                </td>
                </tr>
                </table>

                </html:form><script type="text/javascript">
                var focusControl = document.forms[0].elements["codigo_regional"];
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

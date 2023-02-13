<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/Sbr0101ActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = Sbr0101ActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("f_free","");
    hashMapLabel.set("periodo","Período");
    hashMapLabel.set("abertura","Abertura");
    hashMapLabel.set("tipo_mercado","");
    hashMapLabel.set("codigo_regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("rep_cdgo","ERC");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("cli_cdgo","Cliente");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("pais","País");
    hashMapLabel.set("abre_marca","Tipo Quebra Marca");
    hashMapLabel.set("cb_somente_pp","Somente PP");
    hashMapLabel.set("objetivo","Objetivo");
    hashMapLabel.set("visao","");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Desempenho Semanal por Regional/ERCs
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(255)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/Sbr0101Form.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="periodo"/>
                    <html:errors property="abertura"/>
                    <html:errors property="tipo_mercado"/>
                    <html:errors property="codigo_regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="pais"/>
                    <html:errors property="abre_marca"/>
                    <html:errors property="cb_somente_pp"/>
                    <html:errors property="objetivo"/>
                    <html:errors property="visao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Dual"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String tipo_mercado = null;
                String representante = null;
                String regional = null;
                boolean abertura_marca = true;
                portalbr.com.Sbr0101ActionForm sbr0101ActionForm = (portalbr.com.Sbr0101ActionForm)session.getAttribute("Sbr0101ActionForm");
                if(sbr0101ActionForm!=null && sbr0101ActionForm.getPeriodo()==null){
                  util.consultas.Query query = new util.consultas.Query();
                  sbr0101ActionForm.setPeriodo(query.retorna("select to_char(sysdate,'mm/yyyy') from dual"));
                }

                if(sbr0101ActionForm.getTipo_mercado()==null){
                  sbr0101ActionForm.setTipo_mercado("ME_VENDA");
                }

                if(sbr0101ActionForm.getAbertura()==null){
                  sbr0101ActionForm.setAbertura("REG");
                }


                if(sbr0101ActionForm != null && (sbr0101ActionForm.getAbertura()+"").equalsIgnoreCase("REP")){
                  abertura_marca = false;
                }


                acesso.Sessao sessao = new acesso.Sessao(session);
                if(sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")
                ||sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")){
                  representante = sessao.getChave();
                }

                if(sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")){
                  regional = sessao.getChave();
                }


                if(sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")){
                  com.egen.util.jdbc.JdbcUtil j = null;
                  try{
                    j = new com.egen.util.jdbc.JdbcUtil();
                    portalbr.dbobj.view.Jw_regional_analista table = new portalbr.dbobj.view.Jw_regional_analista();
                    String[][] select = null;
                    Object[][] where = {
                    {"codigo_gerente","=", sessao.getChave()}
                    };
                    Vector res_Jw_regional_analista = j.select(table, select, where, null, null, null);
                    if (res_Jw_regional_analista != null && res_Jw_regional_analista.size() > 0) {
                      portalbr.dbobj.view.Jw_regional_analista r = (portalbr.dbobj.view.Jw_regional_analista) res_Jw_regional_analista.elementAt(0);
                      regional = r.getCodigo_regional();
                    }
                  } finally {
                    if(j!=null) {
                      j.close();
                      j = null;
                    }
                  }
                }


                if(representante != null){
                  abertura_marca = false;
                }

                if((sbr0101ActionForm.getVisao()+"").equalsIgnoreCase("null")){
                  %>
                  <script>
                    jQuery(document).ready(function($) {
                      $("#visao").attr('checked', 'checked');
                      });
                    </script>
                    <%
                  }
                  if(sbr0101ActionForm.getTipo_mercado().equalsIgnoreCase("MI")){
                    %>
                    <script>
                      jQuery(document).ready(function($) {
                        $("#tipo_mercado1").attr('checked', 'checked');
                        });
                      </script>
                      <%
                    }

                    tipo_mercado = sbr0101ActionForm.getTipo_mercado();
                    %>
                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Período
                        </span>
                        <bean:message key="jsp.fieldnotnull"/>
                      </td>
                      <td class="formField">
                        <html:text property="periodo" styleId="periodo" styleClass="baseField" size="7" maxlength="7"/>
                      </td>
                    </tr>

                    <%
                    if(false){
                      %>

                      <%
                      if(representante==null){
                        %>

                        <tr class="itemTr">
                          <td class="formLabel">
                            <span class="spamFormLabel">
                              Abertura
                            </span>
                          </td>
                          <td class="formField">
                            <html:select property="abertura" styleId="abertura" onchange="refresh_action.click();" styleClass="baseField" size="1">
                              <html:option styleClass="baseOption" value="REG">
                                Regional
                              </html:option>
                              <html:option styleClass="baseOption" value="REP">
                                ERCs
                              </html:option>
                            </html:select>
                          </td>
                        </tr>

                        <%
                      } else {
                        %>

                        <html:hidden property="abertura" value="REP" />

                        <%
                      }
                      %>

                      <%
                    } else {
                      %>

                      <html:hidden property="abertura" value="" />


                      <%
                    }
                    %>
                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                        </span>
                      </td>
                      <td class="formField">
                        <!--
                          <html:radio property="tipo_mercado" styleId="tipo_mercado1" onchange="refresh_action.click();" styleClass="baseField" value="MI"/> Mercado Interno<br /> <html:radio property="tipo_mercado" styleId="tipo_mercado2" onchange="refresh_action.click();" styleClass="baseField" value="ME"/> Mercado Externo<br />
                        -->
                        <html:radio  property="tipo_mercado" styleId="tipo_mercado1" onchange="refresh_action.click();" styleClass="baseField" value="ME_VENDA"/>
                        Venda Mensal/Acumulada por País EX
                        <br />
                      </td>
                    </tr>

                    <%
                    if(regional == null && representante == null && tipo_mercado.equals("ME_VENDA")){
                      %>
                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Regional
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="codigo_regional" styleId="codigo_regional" onblur="fillFields(0,new Array('codigo_regional'),'Sbr0101ActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="baseField" size="3"/>
                          <input type="button" class="lovButton" tabindex="-1"  value="..."  onclick="javascript:lov_open_codigo_regional()"  >
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

                      <%
                      if(regional != null) {
                        %>
                        <html:hidden property="codigo_regional" value="<%= regional %>" />
                        <html:hidden property="nome_regional" />
                        <%
                      } else {
                        %>
                        <html:hidden property="codigo_regional" />
                        <html:hidden property="nome_regional" />
                        <%
                      }
                      %>

                      <%
                    }
                    %>
                    <%
                    if(representante == null && tipo_mercado.equals("ME_VENDA")) {
                      %>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            ERC
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="rep_cdgo" styleId="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'Sbr0101ActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="5"/>
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

                      <html:hidden property="rep_cdgo" value="<%= representante %>" />
                      <html:hidden property="rep_rzao" />


                      <%
                    }
                    %>
                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Cliente
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="cli_cdgo" styleId="cli_cdgo" onblur="fillFields(0,new Array('cli_cdgo'),'Sbr0101ActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));" styleClass="baseField" size="6"/>
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
                          País
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="pais" styleId="pais" styleClass="baseField" size="50" maxlength="50"/>
                        <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_pais()"  >
                        <script type="text/javascript">
                          function lov_open_pais() {
                            window.open('..//lov/LvPaisesLov.do?resetfull_action=&returnBlock=0&return0=pais','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                          }
                        </script>
                      </td>
                    </tr>

                    <%
                    if(false){
                      %>

                      <%
                      if(abertura_marca){
                        %>
                        <tr class="itemTr">
                          <td class="formLabel">
                            <span class="spamFormLabel">
                              Tipo Quebra Marca
                            </span>
                          </td>
                          <td class="formField">
                            <html:select property="abre_marca" styleId="abre_marca" styleClass="baseField" size="1">
                              <html:option styleClass="baseOption" value="S">
                                Somente quebra por Marcas
                              </html:option>
                              <html:option styleClass="baseOption" value="N\"selected='selected'">
                                Sem quebra por Marcas
                              </html:option>
                              <html:option styleClass="baseOption" value="T">
                                Ambos
                              </html:option>
                            </html:select>
                          </td>
                        </tr>

                        <%
                      } else {
                        %>

                        <html:hidden property="abre_marca" />

                        <%
                      }
                      %>


                      <%
                    } else {
                      %>

                      <html:hidden property="abre_marca" />

                      <%
                    }
                    %>
                    <%
                    if(false){
                      %>
                      <tr class="itemTr">
                        <td class="formLabel">
                        </td>
                        <td class="formField">
                          <html:checkbox property="cb_somente_pp" styleId="cb_somente_pp" styleClass="baseField" value="1"/>
                          <span class="spamFormLabel">
                            Somente PP
                          </span>
                        </td>
                      </tr>

                      <%
                    } else {
                      %>

                      <html:hidden property="cb_somente_pp" />

                      <%
                    }
                    %>

                    <%
                    if(false){
                      %>
                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Objetivo
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="objetivo" styleId="objetivo" styleClass="baseField" size="6" maxlength="30"/>
                          <span class='validateMessageuser'>
                            BI
                          </span>
                        </td>
                      </tr>

                      <%
                    } else {
                      %>

                      <html:hidden property="objetivo" />

                      <%
                    }
                    %>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                        </span>
                      </td>
                      <td class="formField">
                        <html:radio  property="visao" styleId="visao" styleClass="baseField" value="GERAL"/>
                        Geral
                        <html:radio  property="visao" styleId="visao" styleClass="baseField" value="REP"/>
                        Erc
                        <html:radio  property="visao" styleId="visao" styleClass="baseField" value="PAIS"/>
                        Países
                        <html:radio  property="visao" styleId="visao" styleClass="baseField" value="CLIENTE"/>
                        Cliente
                      </td>
                    </tr>

                    <%
                    if(request.getAttribute("arquivo")!=null){
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
                        <html:button accesskey="p" onclick="resetfull1_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
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
                        <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:submit>
                        <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                        <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                        </html:submit>
                        <html:submit accesskey="l" styleClass="myhidden" property="refresh_action">
                        <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
                        </html:submit>
                        </td>
                        </tr>
                        </table>

                        <script type="text/javascript">
                        jQuery(document).ready(function($) {
                          $("#periodo").mask("99/9999");
                          });
                        </script>
                      </html:form>
                      <script type="text/javascript">
                        var focusControl = document.forms[0].elements["periodo"];
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

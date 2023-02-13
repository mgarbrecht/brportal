<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/PedidosIndenizadosDescontos_fActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = PedidosIndenizadosDescontos_fActionForm;
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
    hashMapLabel.set("cli_cdgo","Cliente");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("gre_grupo","Grupo Econômico");
    hashMapLabel.set("gre_descricao","");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_descricao","");
    hashMapLabel.set("ref_cdgo","Referência");
    hashMapLabel.set("ref_descricao","");
    hashMapLabel.set("cab_cdgo","Cabedal");
    hashMapLabel.set("cab_descricao","");
    hashMapLabel.set("data_inicial","Dt. Digitação Inicial");
    hashMapLabel.set("data_final","Dt. Digitação Final");
    hashMapLabel.set("marcas","Marca");
    hashMapLabel.set("situacao","Situação");
    hashMapLabel.set("status","Status Pedido");
    hashMapLabel.set("f_foco","");
    hashMapLabel.set("cb_faturados","Somente Faturados");
    hashMapLabel.set("ped_nmro","Pedido");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Pedidos Indenizados / Descontos
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(184)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/PedidosIndenizadosDescontos_fForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="codigo_regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="gre_grupo"/>
                    <html:errors property="gre_descricao"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_descricao"/>
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="ref_descricao"/>
                    <html:errors property="cab_cdgo"/>
                    <html:errors property="cab_descricao"/>
                    <html:errors property="data_inicial"/>
                    <html:errors property="data_final"/>
                    <html:errors property="marcas"/>
                    <html:errors property="situacao"/>
                    <html:errors property="status"/>
                    <html:errors property="cb_faturados"/>
                    <html:errors property="ped_nmro"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Parametros"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String data_inicial;
                String data_final;
                String codigo_regional="";
                String codigo_representante="";
                String tipo="";
                util.consultas.Query query = new util.consultas.Query();
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

                data_inicial = query.retorna("SELECT to_char(TRUNC(SYSDATE,'mm'),'dd/mm/yyyy') FROM dual");
                data_final = query.retorna("SELECT to_char(last_day(TRUNC(SYSDATE,'mm')),'dd/mm/yyyy') FROM dual");
                %>
                <%
                if(codigo_regional.equals("") && codigo_representante.equals("")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Regional
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="codigo_regional" styleId="codigo_regional" onblur="fillFields(0,new Array('codigo_regional'),'PedidosIndenizadosDescontos_fActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="baseField" size="3"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_regional()"  >
                      <script type="text/javascript">
                        function lov_open_codigo_regional() {
                          window.open('..//lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=codigo_regional&return1=nome_regional','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="50" maxlength="40"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="codigo_regional" value="<%= codigo_regional %>"/>
                  <html:hidden property="nome_regional"/>

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
                      <html:text property="rep_cdgo" styleId="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'PedidosIndenizadosDescontos_fActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="5"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_rep_cdgo() {
                          window.open('..//lov/LvRepresentanteLov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
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
                  <html:hidden property="rep_rzao"/>

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
                    <html:text property="cli_cdgo" styleId="cli_cdgo" onblur="fillFields(0,new Array('cli_cdgo'),'PedidosIndenizadosDescontos_fActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));" styleClass="baseField" size="10" maxlength="22"/>
                    <input type="button" class="lovButton" tabindex="-1"  value="..."  onclick="javascript:lov_open_cli_cdgo()"  >
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
                  </td>
                  <td class="formField">
                    <html:text property="gre_grupo" styleId="gre_grupo" onblur="fillFields(0,new Array('gre_grupo'),'PedidosIndenizadosDescontos_fActionForm.getGre_descricao_Ajax',new Array('gre_descricao'));" styleClass="baseField" size="7"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_gre_grupo()"  >
                    <script type="text/javascript">
                      function lov_open_gre_grupo() {
                        window.open('..//lov/LvGrupoEconomicoLov.do?resetfull_action=&returnBlock=0&return0=gre_grupo&return1=gre_descricao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="gre_descricao" styleId="gre_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="35"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" onblur="fillFields(0,new Array('lin_cdgo'),'PedidosIndenizadosDescontos_fActionForm.getLin_descricao_Ajax',new Array('lin_descricao'));" styleClass="baseField" size="7"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('..//lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_descricao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_descricao" styleId="lin_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="35"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Referência
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ref_cdgo" styleId="ref_cdgo" onblur="fillFields(0,new Array('lin_cdgo','ref_cdgo'),'PedidosIndenizadosDescontos_fActionForm.getRef_descricao_Ajax',new Array('ref_descricao'));" styleClass="baseField" size="7"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_ref_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_ref_cdgo() {
                        window.open('..//lov/LvRefLov.do?resetfull_action=&returnBlock=0&return0=ref_cdgo&return1=ref_descricao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="ref_descricao" disabled="true" styleId="ref_descricao" styleClass="baseField" tabindex="-1" readonly="true" size="35"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cabedal
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cab_cdgo" styleId="cab_cdgo" onblur="fillFields(0,new Array('cab_cdgo'),'PedidosIndenizadosDescontos_fActionForm.getCab_descricao_Ajax',new Array('cab_descricao'));" styleClass="baseField" size="7"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cab_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_cab_cdgo() {
                        window.open('..//lov/LvCabedalLov.do?resetfull_action=&returnBlock=0&return0=cab_cdgo&return1=cab_descricao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cab_descricao" disabled="true" styleId="cab_descricao" styleClass="baseField" tabindex="-1" readonly="true" size="35"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Dt. Digitação Inicial
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="data_inicial" styleId="data_inicial" styleClass="baseField" value="<%= data_inicial %>" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_inicial']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Dt. Digitação Final
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="data_final" styleId="data_final" styleClass="baseField" value="<%= data_final %>" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="marcas" styleId="marcas" styleClass="baseField" size="1">
                      <html:options property="marcasList" labelProperty="marcasLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situação
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:select property="situacao" styleId="situacao" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="N">
                        Não Indenizados
                      </html:option>
                      <html:option styleClass="baseOption" value="A">
                        Indenizados
                      </html:option>
                      <html:option styleClass="baseOption" value="F">
                        Confirmado
                      </html:option>
                      <html:option styleClass="baseOption" value="C">
                        Cancelado
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Status Pedido
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="status" styleId="status" styleClass="baseField" size="1">
                      <html:options property="statusList" labelProperty="statusLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <script>
                  <% if(!codigo_representante.equals("")){ %>

                  jQuery(document).ready(function($) {
                    $("#cli_cdgo").focus();
                    });

                    <% } %>


                    <% if(!codigo_regional.equals("")){ %>

                    jQuery(document).ready(function($) {
                      $("#rep_cdgo").focus();
                      });

                      <% } %>


                      <% if(codigo_regional.equals("") && codigo_representante.equals("")){ %>

                      jQuery(document).ready(function($) {
                        $("#codigo_regional").focus();
                        });

                        <% } %>
                      </script>
                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Somente Faturados
                          </span>
                        </td>
                        <td class="formField">
                          <html:checkbox property="cb_faturados" styleId="cb_faturados" styleClass="baseField" value="checked"/>
                        </td>
                      </tr>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Pedido
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="ped_nmro" styleId="ped_nmro" styleClass="baseField" size="10" maxlength="22"/>
                        </td>
                      </tr>

                    </table>

                    <table class="buttonTable" style='width:99%;'>
                      <tr class="buttonTr">
                        <td class="buttonTd">
                          <html:submit accesskey="p" onclick="bloqueia();" styleClass="baseButton" property="select_action">
                            <bean:message bundle="ApplicationResources" key="jsp.select"/>
                          </html:submit>
                          <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                            <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                          </html:submit>
                          <html:submit value="Blank" styleClass="myhidden" property="blank_action">
                          </html:submit>
                        </td>
                      </tr>
                    </table>

                    <script type="text/javascript">
                      jQuery(document).ready(function($) {
                        $("#data_inicial").mask("99/99/9999");
                        $("#data_final").mask("99/99/9999");
                        });
                      </script>
                    </html:form>
                  </td>
                </tr>
              </table>

            </body>
          </center>
        </html>

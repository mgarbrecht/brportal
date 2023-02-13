<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ImpressaoDuplicatasNVActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ImpressaoDuplicatasNVActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("banco","Banco");
    hashMapLabel.set("representante","representante");
    hashMapLabel.set("regional","regional");
    hashMapLabel.set("cli_rzao","Nome");
    hashMapLabel.set("cli_cdgo","Código");
    hashMapLabel.set("esc_seqn","Seq.");
    hashMapLabel.set("cgc","CGC");
    hashMapLabel.set("mostrar_grupo","Grupo Econômico");
    hashMapLabel.set("reunir","Reunir todos seqüenciais");
    hashMapLabel.set("f_mercado_interno","");
    hashMapLabel.set("emp_empresa","Empresa");
    hashMapLabel.set("emp_razsoc","");
    hashMapLabel.set("dt_vencimento","Data Vencimento");
    hashMapLabel.set("situacao","Situação");
    hashMapLabel.set("duplicatas","Duplicatas");
    hashMapLabel.set("notas_fiscais","Notas Fiscais");
    hashMapLabel.set("f_tituloi","Consulta Direta");
    hashMapLabel.set("tit_codigo","Título");
    hashMapLabel.set("f_titulof","");
    hashMapLabel.set("codigo","");
    hashMapLabel.set("nome","");
    hashMapLabel.set("bairro","");
    hashMapLabel.set("cidade_uf","");
    hashMapLabel.set("cliente_mercado_externo","");
    hashMapLabel.set("gridCheckField","");
    hashMapLabel.set("cliente","cliente");
    hashMapLabel.set("razao","razao");
    hashMapLabel.set("br","br");
    hashMapLabel.set("cid_est","cid_est");
    hashMapLabel.set("esc_seqn1","esc_seqn");
    hashMapLabel.set("cli_cdgo1","cli_cdgo");
    hashMapLabel.set("codigo_sucessor","codigo_sucessor");
    hashMapLabel.set("sequencial_sucessor","sequencial_sucessor");
    hashMapLabel.set("razao_social_sucessor","razao_social_sucessor");
    hashMapLabel.set("cid_uf_sucessor","cid_uf_sucessor");
    hashMapLabel.set("br_sucessor","br_sucessor");
    hashMapLabel.set("esc_cgc","esc_cgc");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Impressão de Duplicatas
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(12)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            if(!((acesso.Usuario)session.getAttribute("User")).isTipo("CLIENTE MERCADO INTERNO")) {
              %>

              <html:form action="adm/ImpressaoDuplicatasNVForm.do" method="post" styleClass="baseForm" target="_self">
                <table class="messageTable" style='width:99%;'>
                  <tr class="messageTr" >
                    <td class="messageTd">
                      <div style=font-size:11px;font-weight:normal;>
                        <%
                        if(((acesso.Usuario)session.getAttribute("User")).isTipo("CLIENTE MERCADO INTERNO")||((acesso.Usuario)session.getAttribute("User")).isTipo("CLIENTE MERCADO EXTERNO")){
                          %>
                          <%} else { %>
                            <div class\='div10l'>
                              Um dos campos com
                              <img src='../img/opcional.gif' border\='0' title\='Opcional' style\='cursor\:pointer'>
                              deve ser preenchido.
                            </div>
                            <%} %>
                            </div>
                            <html:errors property="banco"/>
                            <html:errors property="cli_rzao"/>
                            <html:errors property="cli_cdgo"/>
                            <html:errors property="esc_seqn"/>
                            <html:errors property="cgc"/>
                            <html:errors property="mostrar_grupo"/>
                            <html:errors property="reunir"/>
                            <html:errors property="emp_empresa"/>
                            <html:errors property="emp_razsoc"/>
                            <html:errors property="dt_vencimento"/>
                            <html:errors property="duplicatas"/>
                            <html:errors property="notas_fiscais"/>
                            <html:errors property="tit_codigo"/>
                            <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_titulos"/>
                          </td>
                        </tr>
                      </table>

                      <table class="itemTable"  style="width:99%;">
                        <%
                        acesso.Sessao sessao = new acesso.Sessao(session);
                        boolean liberaBanrisul = true;
                        boolean liberaBradesco = false;
                        if(sessao.getUsuario().equalsIgnoreCase("ADMIN") || sessao.getUsuario().equalsIgnoreCase("151231")){
                          liberaBradesco = true;
                        }
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
                          <tr class="itemTr">
                            <td class="formLabel">
                              <span class="spamFormLabel">
                                Banco
                              </span>
                            </td>
                            <td class="formField">
                              <html:select property="banco" styleId="banco" styleClass="baseField" size="1">
                                <html:option styleClass="baseOption" value="T">
                                  Todos
                                </html:option>
                                <html:option styleClass="baseOption" value="001">
                                  Banco do Brasil
                                </html:option>
                                <html:option styleClass="baseOption" value="033">
                                  Banco Santander
                                </html:option>
                                <%
                                if(liberaBradesco) {
                                  %>
                                  <html:option styleClass="baseOption" value="237">
                                    Bradesco
                                  </html:option>
                                  <%
                                }
                                %>
                                <%
                                if(liberaBanrisul) {
                                  %>
                                  <html:option styleClass="baseOption" value="041">
                                    Banrisul
                                  </html:option>
                                  <%
                                }
                                %>
                              </html:select>
                            </td>
                          </tr>

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
                              <%
                              if(user.isTipo("AREAS") || user.isSuperUsuario()){
                                %>
                                Abrir Grupo Econômico
                                <html:checkbox property="mostrar_grupo" styleId="mostrar_grupo" styleClass="baseField" value="S"/>
                                <%
                              } else {
                                %>
                                <html:hidden property="mostrar_grupo" value="N"/>
                                <%
                              }
                              %>

                            </td>
                          </tr>
                          <tr class="itemTr">
                            <td class="formLabel">
                              <span class="spamFormLabel">
                                Reunir todos seqüenciais
                              </span>
                            </td>
                            <td class="formField">
                              <html:checkbox property="reunir" styleClass="baseField" styleId="reunir" value="1"/>
                            </td>
                          </tr>

                          <%
                        }
                        %>
                        <%
                        if(cliente_mercado_externo.equals("")){
                          %>

                          <tr class="itemTr">
                            <td class="formLabel">
                              <span class="spamFormLabel">
                                Empresa
                              </span>
                            </td>
                            <td class="formField">
                              <html:text property="emp_empresa" styleId="emp_empresa" onblur="fillFields(0,new Array('emp_empresa'),'ImpressaoDuplicatasActionNVForm.getEmp_razsoc_Ajax',new Array('emp_razsoc'));" styleClass="baseField" size="3"/>
                              <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_emp_empresa()"  >
                              <script type="text/javascript">
                                function lov_open_emp_empresa() {
                                  window.open('..//lov/LvEmpresaLov.do?resetfull_action=&returnBlock=0&return0=emp_empresa&return1=emp_razsoc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                                }
                              </script>


                              <%
                            } else {
                              %>

                              <html:hidden property="emp_empresa" />

                              <%
                            }
                            %>
                            <%
                            if(cliente_mercado_externo.equals("")){
                              %>

                              <span class="spamFormLabel">
                              </span>
                              <html:text property="emp_razsoc" styleId="emp_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="50"/>
                            </td>
                          </tr>

                          <%
                        } else {
                          %>

                          <html:hidden property="emp_razsoc" />

                          <%
                        }
                        %>

                        <tr class="itemTr">
                          <td class="formLabel">
                            <span class="spamFormLabel">
                              Data Vencimento
                            </span>
                          </td>
                          <td class="formField">
                            <html:text property="dt_vencimento" styleId="dt_vencimento" styleClass="baseField" size="10" maxlength="10"/>
                             
                            <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_vencimento']); cal1.year_scroll = true; cal1.popup();">
                              <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                            </a>
                          </td>
                        </tr>

                        <html:hidden property="situacao" value="A"/>
                        <%
                        if(((acesso.Usuario)session.getAttribute("User")).isTipo("AREAS") || user.isSuperUsuario()) {
                          %>

                          <tr class="itemTr">
                            <td class="formLabel">
                              <span class="spamFormLabel">
                                Duplicatas
                              </span>
                            </td>
                            <td class="formField">
                              <html:textarea property="duplicatas" styleId="duplicatas" styleClass="baseField" cols="10" rows="5"/>
                              <span class="spamFormLabel">
                                Notas Fiscais
                              </span>
                              <html:textarea property="notas_fiscais" styleId="notas_fiscais" styleClass="baseField" cols="10" rows="5"/>
                            </td>
                          </tr>

                          <%
                        } else {
                          %>

                          <html:hidden property="duplicatas" />
                          <html:hidden property="notas_fiscais" />

                          <%
                        }
                        %>
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
                            <html:button accesskey="p" onclick="         bloqueia();resetfull1_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                              <bean:message bundle="ApplicationResources" key="jsp.select"/>
                            </html:button>
                            <script>
                              function getKeySite(keyStroke) {
                                isNetscape=(document.layers);
                                eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                                which = String.fromCharCode(eventChooser).toLowerCase();
                                keyBuffer = which;
                                if(eventChooser == 13){          bloqueia();
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
                            $("#reunir").attr('checked', true);
                            });
                          </script>
                        </html:form>

                        <%
                      }
                      %>
                      <%
                      if(((acesso.Usuario)session.getAttribute("User")).isTipo("CLIENTE MERCADO INTERNO")) {
                        %>

                        <html:form action="adm/ImpressaoDuplicatasNVGrid.do" method="post" styleClass="baseForm">

                          <%
                          java.util.Vector res_Jw_consulta_titulos = (java.util.Vector)session.getAttribute("res_Jw_consulta_titulos");
                          %>
                          <table class="messageTable" style='width:99%;'>
                            <tr class="messageTr" >
                              <td class="messageTd">
                                <html:errors property="gridCheckField"/>
                                <html:errors property="cliente"/>
                                <html:errors property="razao"/>
                                <html:errors property="br"/>
                                <html:errors property="cid_est"/>
                                <html:errors property="esc_seqn1"/>
                                <html:errors property="cli_cdgo1"/>
                                <html:errors property="codigo_sucessor"/>
                                <html:errors property="sequencial_sucessor"/>
                                <html:errors property="razao_social_sucessor"/>
                                <html:errors property="cid_uf_sucessor"/>
                                <html:errors property="br_sucessor"/>
                                <html:errors property="esc_cgc"/>
                                <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_titulos_1"/>
                              </td>
                            </tr>
                          </table>

                          <table id="TRbl_report_Jw_consulta_titulos" class="reportTable" style=width:99%;  border=1  frame=box>
                            <tr class="reportHeader" >
                              <td class="columnTdHeader" style="text-align:left;" >
                              </td>
                              <td class="columnTdHeader" style="text-align:left;" >
                                Cliente
                              </td>
                              <td class="columnTdHeader" style="text-align:left;">
                                CGC
                              </td>
                              <td class="columnTdHeader" style="text-align:left;">
                                Razão Social
                              </td>
                              <td class="columnTdHeader" style="text-align:left;">
                                Bairro
                              </td>
                              <td class="columnTdHeader" style="text-align:left;">
                                Cidade - UF
                              </td>
                            </tr>

                            <%
                            String style="";
                            int contador = 0;
                            %>

                            <logic:iterate id="bl_form_Jw_consulta_titulos_1_lines" name="ImpressaoDuplicatasNVGridActionForm" property="bl_form_Jw_consulta_titulos_1_lines" indexId="indexId">
                              <%
                              Jw_consulta_titulos consultaTitulos = (Jw_consulta_titulos)res_Jw_consulta_titulos.elementAt(contador);
                              if (!((contador%2)!=0)) {
                                style="rowColor";
                              } else {
                                style="rowBlank";
                              }
                              %>
                              <tr class=<%= style %> >
                                <td class="reportColumn" style="text-align:center;">
                                  <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_consulta_titulos_1_lines" indexed="true"/>
                                </td>

                                <td class="reportColumn" style="text-align:left;">
                                  <html:hidden property="cliente" name="bl_form_Jw_consulta_titulos_1_lines" indexed="true" styleId="cliente"/>
                                  <%= consultaTitulos.getCliente() %>
                                </td>

                                <td class="reportColumn" style="text-align:left;">
                                  <html:hidden property="esc_cgc" name="bl_form_Jw_consulta_titulos_1_lines" indexed="true" styleId="esc_cgc"/>
                                  <%= consultaTitulos.getEsc_cgc() %>
                                </td>

                                <td class="reportColumn" style="text-align:left;">
                                  <html:hidden property="razao" name="bl_form_Jw_consulta_titulos_1_lines" indexed="true" styleId="razao"/>
                                  <%= consultaTitulos.getRazao() %>
                                </td>

                                <td class="reportColumn" style="text-align:left;">
                                  <html:hidden property="br" name="bl_form_Jw_consulta_titulos_1_lines" indexed="true" styleId="br"/>
                                  <%= consultaTitulos.getBr() %>
                                </td>

                                <td class="reportColumn" style="text-align:left;">
                                  <html:hidden property="cid_est" name="bl_form_Jw_consulta_titulos_1_lines" indexed="true" styleId="cid_est"/>
                                  <%= consultaTitulos.getCid_est() %>
                                </td>

                                <html:hidden property="esc_seqn1" name="bl_form_Jw_consulta_titulos_1_lines" indexed="true" styleId="esc_seqn1"/>
                                <html:hidden property="cli_cdgo1" name="bl_form_Jw_consulta_titulos_1_lines" indexed="true" styleId="cli_cdgo1"/>
                                <html:hidden property="codigo_sucessor" name="bl_form_Jw_consulta_titulos_1_lines" indexed="true" styleId="codigo_sucessor"/>
                                <html:hidden property="sequencial_sucessor" name="bl_form_Jw_consulta_titulos_1_lines" indexed="true" styleId="sequencial_sucessor"/>
                                <html:hidden property="razao_social_sucessor" name="bl_form_Jw_consulta_titulos_1_lines" indexed="true" styleId="razao_social_sucessor"/>
                                <html:hidden property="cid_uf_sucessor" name="bl_form_Jw_consulta_titulos_1_lines" indexed="true" styleId="cid_uf_sucessor"/>
                                <html:hidden property="br_sucessor" name="bl_form_Jw_consulta_titulos_1_lines" indexed="true" styleId="br_sucessor"/>
                                <%
                                contador ++;
                                %>
                              </tr>

                            </logic:iterate>

                          </table>

                          <table class="buttonTable" style='width:99%;'>
                            <tr class="buttonTr">
                              <td class="buttonTd">
                                <html:submit accesskey="p" styleClass="myhidden" property="selectc_action">
                                  <bean:message bundle="ApplicationResources" key="jsp.select"/>
                                </html:submit>
                                <html:submit accesskey="a" styleClass="baseButton" property="update_action">
                                  Consultar Duplicatas
                                </html:submit>
                                <html:submit value="Marcar Todos" styleClass="baseButton" property="marcar_todos_action">
                                </html:submit>
                                <html:submit value="Desmarcar Todos" styleClass="baseButton" property="desmarcar_todos_action">
                                </html:submit>
                              </td>
                            </tr>
                          </table>

                        </html:form>

                        <%
                      }
                      %>
                    </td>
                  </tr>
                </table>

              </body>
            </center>
          </html>

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/AdministradorPedidosActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = AdministradorPedidosActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("tipo","Tipo");
    hashMapLabel.set("codigo_marca","Marca");
    hashMapLabel.set("descricao_marca","");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("free_ai","");
    hashMapLabel.set("ref_cdgo","Referência");
    hashMapLabel.set("ref_desc","");
    hashMapLabel.set("disponibilidade","Disponibilidade");
    hashMapLabel.set("somente_disponivel","Somente Disponível");
    hashMapLabel.set("mes_ano_i","<b>Mês/Ano</b>");
    hashMapLabel.set("dt_inicial","Inicial");
    hashMapLabel.set("dt_final","Final");
    hashMapLabel.set("mes_ano_f","");
    hashMapLabel.set("free_af","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Administrador de Pedidos - Consulta Previsto / Capacidade
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(59)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/AdministradorPedidosForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <div class\='div10l'>
                        Um dos campos com
                        <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        deve ser preenchido.
                      </div>
                      <div class\='div10l'>
                      </div>
                    </div>
                    <html:errors property="tipo"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="descricao_marca"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="ref_desc"/>
                    <html:errors property="disponibilidade"/>
                    <html:errors property="somente_disponivel"/>
                    <html:errors property="dt_inicial"/>
                    <html:errors property="dt_final"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_web_poi"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                acesso.Sessao ses = new acesso.Sessao(session);
                portalbr.com.AdministradorPedidosActionForm administradorPedidosForm = (portalbr.com.AdministradorPedidosActionForm)session.getAttribute("AdministradorPedidosActionForm");
                boolean acessoRepresentante = false;
                String tipo = "A";
                if(administradorPedidosForm.getTipo() != null) {
                  tipo = administradorPedidosForm.getTipo();
                }
                if(ses.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")
                ||ses.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")){
                  tipo = "S";
                  acessoRepresentante = true;
                }
                %>
                <%
                if(!acessoRepresentante) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Tipo
                      </span>
                    </td>
                    <td class="formField">
                      <html:select property="tipo" styleId="tipo" onchange="refresh_action.click();" styleClass="baseField" size="1">
                        <html:option styleClass="baseOption" value="A">
                          Analítico - Previsto / Capacidade
                        </html:option>
                        <html:option styleClass="baseOption" value="S">
                          Sintético - Datas de Disponibilidade
                        </html:option>
                      </html:select>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="tipo" value="S"/>

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
                    <html:text property="codigo_marca" onblur="fillFields(0,new Array('codigo_marca'),'AdministradorPedidosActionForm.getDescricao_marca_Ajax',new Array('descricao_marca'));" styleClass="baseField" size="3" maxlength="3"/>
                    <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_codigo_marca()"  >
                    <script type="text/javascript">
                      function lov_open_codigo_marca() {
                        window.open('../lov/LvMarcaLov.do?resetfull_action=&returnBlock=0&return0=codigo_marca&return1=descricao_marca','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="descricao_marca" styleId="descricao_marca" styleClass="disabled" tabindex="-1" readonly="true" size="33" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" onblur="fillFields(0,new Array('lin_cdgo'),'AdministradorPedidosActionForm.getLin_nome_Ajax',new Array('lin_nome'));" styleClass="baseField" size="6" maxlength="6"/>
                    <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('../lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_nome" styleId="lin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="28" maxlength="25"/>
                  </td>
                </tr>

                <%
                if(tipo.equalsIgnoreCase("A")) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Referência
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="ref_cdgo" onblur="fillFields(0,new Array('lin_cdgo','ref_cdgo'),'AdministradorPedidosActionForm.getRef_desc_Ajax',new Array('ref_desc'));" styleClass="baseField" size="6"/>
                      <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_ref_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_ref_cdgo() {
                          window.open('../lov/LvRefLov.do?resetfull_action=&returnBlock=0&return0=ref_cdgo&return1=ref_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="ref_desc" styleId="ref_desc" styleClass="disabled" tabindex="-1" readonly="true" size="28" maxlength="25"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Disponibilidade
                      </span>
                    </td>
                    <td class="formField">
                      <html:select property="disponibilidade" styleClass="baseField" size="1">
                        <html:option styleClass="baseOption" value="g">
                          Geral
                        </html:option>
                        <html:option styleClass="baseOption" value="f">
                          Fechadas
                        </html:option>
                        <html:option styleClass="baseOption" value="s">
                          Com Saldo
                        </html:option>
                      </html:select>
                    </td>
                  </tr>

                  <%
                  acesso.Sessao sessao = new acesso.Sessao(session);
                  if(sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")
                  ||sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")
                  ||sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")
                  ){
                    %>

                    <html:hidden property="somente_disponivel" value="S" />

                    <%
                  } else {
                    %>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Somente Disponível
                        </span>
                      </td>
                      <td class="formField">
                        <html:select property="somente_disponivel" styleId="somente_disponivel" styleClass="baseField" size="1">
                          <html:option styleClass="baseOption" value="N">
                            Não
                          </html:option>
                          <html:option styleClass="baseOption" value="S">
                            Sim
                          </html:option>
                        </html:select>
                      </td>
                    </tr>

                    <%
                  }
                  %>


                </table>
                <table class="separatorTable">
                  <tr class="separatorTr">
                    <td colspan="2" class="separatorTd">
                      <b>
                        Mês/Ano
                      </b>
                    </td>
                  </tr>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Inicial
                      </span>
                    </span>
                    <img src="../img/opcional.gif" border="0" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="dt_inicial" styleId="dt_inicial" styleClass="baseField" size="4" maxlength="4"/>
                    <span class='validateMessageuser'>
                      <i>
                        Preencher com o formato mmaa.
                      </i>
                    </span>
                  </td>
                </tr>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Final
                    </span>
                  </span>
                  <img src="../img/opcional.gif" border="0" style="cursor:pointer"/>
                </td>
                <td class="formField">
                  <html:text property="dt_final" styleId="dt_final" styleClass="baseField" size="4" maxlength="4"/>
                  <span class='validateMessageuser'>
                    <i>
                      Preencher com o formato mmaa.
                    </i>
                  </span>
                </td>
              </tr>
            </table>
            <table class="itemTable" style='width:99%;'>
              <%
            } else {
              %>

              <html:hidden property="ref_cdgo" />
              <html:hidden property="ref_desc" />
              <html:hidden property="disponibilidade" />
              <html:hidden property="somente_disponivel" />

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Dt. Inicial
                  </span>
                </td>
                <td class="formField">
                  <html:text property="dt_inicial" styleId="dt_inicial" styleClass="baseField" size="4" maxlength="4"/>
                  <span class='validateMessageuser'>
                    <i>
                      Preencher com o formato mmaa.
                    </i>
                  </span>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Dt. Final
                  </span>
                </td>
                <td class="formField">
                  <html:text property="dt_final" styleId="dt_final" styleClass="baseField" size="4" maxlength="4"/>
                  <span class='validateMessageuser'>
                    <i>
                      Preencher com o formato mmaa.
                    </i>
                  </span>
                </td>
              </tr>



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
                $("#dt_inicial").mask("9999");
                $("#dt_final").mask("9999");
                });
              </script>
            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["codigo_marca"];
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

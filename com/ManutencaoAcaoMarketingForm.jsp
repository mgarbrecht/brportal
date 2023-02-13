<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ManutencaoAcaoMarketingActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ManutencaoAcaoMarketingActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("data_entrega","Data Entrega");
    hashMapLabel.set("acao","Ação");
    hashMapLabel.set("marca","Marca");
    hashMapLabel.set("codigo_material","Código Material");
    hashMapLabel.set("descricao_material","");
    hashMapLabel.set("situacao","Situação");
    hashMapLabel.set("cracha_usuario","Crachá");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Pauta Diária de Trabalho - Criação
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(160)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ManutencaoAcaoMarketingForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="data_entrega"/>
                    <html:errors property="acao"/>
                    <html:errors property="marca"/>
                    <html:errors property="codigo_material"/>
                    <html:errors property="descricao_material"/>
                    <html:errors property="situacao"/>
                    <html:errors property="cracha_usuario"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <script type="text/javascript" src="../script/thickbox.js">
                </script>

                <%
                util.consultas.Query q = new util.consultas.Query();
                String chave = null;
                acesso.Sessao se = new acesso.Sessao(session);
                String tipo = se.getTipoEntidadeNegocio();
                String coordenador = null;
                if(tipo.equals("AREAS")){
                  chave = se.getUsuario();
                }
                coordenador = q.retorna("SELECT coordenador FROM acao_marketing_usuarios where cracha = "+chave);
                if(coordenador.equals("S")){
                  chave = "";
                }

                // teste mateus   chave = "151707";
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Entrega
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_entrega" styleId="data_entrega" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_entrega']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Ação
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="acao" styleId="acao" styleClass="baseField" size="5" maxlength="22"/>
                  </td>
                </tr>

                <%
                if(!(coordenador.equals("N"))) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Marca
                      </span>
                    </td>
                    <td class="formField">
                      <html:select property="marca" styleId="marca" styleClass="baseField" size="1">
                        <html:options property="marcaList" labelProperty="marcaLabelList" styleClass="baseOptions"/>
                      </html:select>
                    </td>
                  </tr>
                  <%
                } else {
                  %>
                  <html:hidden property="marca"/>
                  <%
                }
                %>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Código Material
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_material" styleId="codigo_material" onblur="fillFields(0,new Array('codigo_material'),'ManutencaoAcaoMarketingActionForm.getDescricao_material_Ajax',new Array('descricao_material'));" styleClass="baseField" size="3" maxlength="22"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_material()"  >
                    <script type="text/javascript">
                      function lov_open_codigo_material() {
                        window.open('..//lov/LvTipoMidiaLov.do?resetfull_action=&returnBlock=0&return0=codigo_material&return1=descricao_material','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="descricao_material" styleId="descricao_material" styleClass="disabled" tabindex="-1" readonly="true" size="44" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situação
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="situacao" styleId="situacao" styleClass="baseField" size="1">
                      <html:options property="situacaoList" labelProperty="situacaoLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <%
                if(chave==null){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Crachá
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="cracha_usuario" styleId="cracha_usuario" styleClass="baseField" size="10" maxlength="22"/>
                    </td>
                  </tr>
                  <%
                } else {
                  %>
                  <html:hidden property="cracha_usuario" value="<%= chave %>"/>
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
                    <html:submit styleClass="myhidden" property="select_action">
                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit styleClass="myhidden" property="resetfull_action">
                    <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="p" styleClass="myhidden" property="select_session_action">
                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <%
                    String height = (String)session.getAttribute("height");
                    String width = (String)session.getAttribute("width");
                    %>

                    <%
                    if(chave!=null){
                      %>

                      <a href="../com/ManutencaoAcaoMarketing_mForm.do?resetfull_action=?keepThis=true&TB_iframe=true&height=<%= height %>&width=<%= width %>" title="Concluir Grupo de Ações" class="thickbox">
                      <html:button value="Concluir Grupo de Ações" styleClass="baseButton" property="concluir_acoes_action">
                      </html:button>
                      </a>

                      <%
                    }
                    %>






                    </td>
                    </tr>
                    </table>

                    <script type="text/javascript">
                    jQuery(document).ready(function($) {
                      $("#data_entrega").mask("99/99/9999");
                      });
                    </script>
                  </html:form>
                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["data_entrega"];
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ConsultaPosicaoTaloesActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ConsultaPosicaoTaloesActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("fil_filial","Filial");
    hashMapLabel.set("fil_razsoc","");
    hashMapLabel.set("remessa","Remessa<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("forn_codigo","Fornecedor");
    hashMapLabel.set("fornecedor","");
    hashMapLabel.set("fen_seq","Seq. Fornec.");
    hashMapLabel.set("talao","Talão");
    hashMapLabel.set("f_pi","");
    hashMapLabel.set("processo","Processo");
    hashMapLabel.set("pro_nome","");
    hashMapLabel.set("f_pf","");
    hashMapLabel.set("oc","OC<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("dt_envio_inicial","Dt. Envio Inicial<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("dt_envio_final","Dt. Envio Final<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Consulta Posição Talões
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(226)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/ConsultaPosicaoTaloesForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <div class\='div10l'>
                        Um dos campos com
                        <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        deve ser preenchido.
                      </div>
                    </div>
                    <html:errors property="fil_filial"/>
                    <html:errors property="fil_razsoc"/>
                    <html:errors property="remessa"/>
                    <html:errors property="forn_codigo"/>
                    <html:errors property="fornecedor"/>
                    <html:errors property="fen_seq"/>
                    <html:errors property="talao"/>
                    <html:errors property="processo"/>
                    <html:errors property="pro_nome"/>
                    <html:errors property="oc"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="dt_envio_inicial"/>
                    <html:errors property="dt_envio_final"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_posicao_taloes"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String atelier = null;
                acesso.Sessao sessao = new acesso.Sessao(session);
                if(sessao.getTipoEntidadeNegocio().equals("ATELIER")){
                  atelier = sessao.getChave();
                }
                %>
                <%
                if(false){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Filial
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="fil_filial" styleId="fil_filial" onblur="fillFields(0,new Array('fil_filial'),'ConsultaPosicaoTaloesActionForm.getFil_razsoc_Ajax',new Array('fil_razsoc'));" styleClass="baseField" size="4"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fil_filial()"  >
                      <script type="text/javascript">
                        function lov_open_fil_filial() {
                          window.open('..//lov/LvFilialLov.do?resetfull_action=&returnBlock=0&return0=fil_filial&return1=fil_razsoc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="fil_razsoc" styleId="fil_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="55" maxlength="50"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="fil_filial" />
                  <html:hidden property="fil_razsoc" />
                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Remessa
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="remessa" styleId="remessa" styleClass="baseField" size="10" maxlength="22"/>
                  </td>
                </tr>

                <%
                if(atelier == null){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Fornecedor
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="forn_codigo" styleId="forn_codigo" onblur="fillFields(0,new Array('forn_codigo'),'ConsultaPosicaoTaloesActionForm.getFornecedor_Ajax',new Array('fornecedor'));" styleClass="baseField" size="10" maxlength="22"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_forn_codigo()"  >
                      <script type="text/javascript">
                        function lov_open_forn_codigo() {
                          window.open('..//lov/LvFornecedorLov.do?resetfull_action=&returnBlock=0&return0=forn_codigo&return1=fornecedor','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>


                      <span class="spamFormLabel">
                      </span>
                      <html:text property="fornecedor" styleId="fornecedor" styleClass="disabled" tabindex="-1" readonly="true" size="80" maxlength="240"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="forn_codigo" value="<%= atelier %>" />
                  <html:hidden property="fornecedor" />

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Seq. Fornec.
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fen_seq" styleId="fen_seq" styleClass="baseField" size="3"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Talão
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="talao" styleId="talao" styleClass="baseField" size="5" maxlength="22"/>
                  </td>
                </tr>

                <%
                if(false){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Processo
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="processo" styleId="processo" onblur="fillFields(0,new Array('processo'),'ConsultaPosicaoTaloesActionForm.getPro_nome_Ajax',new Array('pro_nome'));" styleClass="baseField" size="3" maxlength="22"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_processo()"  >
                      <script type="text/javascript">
                        function lov_open_processo() {
                          window.open('..//lov/LvProcesso_fabLov.do?resetfull_action=&returnBlock=0&return0=processo&return1=pro_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="pro_nome" styleId="pro_nome" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>
                    </td>
                  </tr>

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      OC
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="oc" styleId="oc" styleClass="baseField" size="10" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" styleClass="baseField" size="10" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Dt. Envio Inicial
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_envio_inicial" styleId="dt_envio_inicial" styleClass="baseField" size="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_envio_inicial']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Dt. Envio Final
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_envio_final" styleId="dt_envio_final" styleClass="baseField" size="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_envio_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

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
                    </SCRIPT><html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                    </td>
                    </tr>
                    </table>

                    <script type="text/javascript">
                    jQuery(document).ready(function($) {
                      $("#dt_envio_inicial").mask("99/99/9999");
                      $("#dt_envio_final").mask("99/99/9999");
                      });
                    </script>
                  </html:form>
                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["remessa"];
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

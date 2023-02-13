<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/SolicitacaoColetasActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = SolicitacaoColetasActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("id_solicitacao_coleta","Nr. Solicitação");
    hashMapLabel.set("f_i","");
    hashMapLabel.set("tra_cdgo","Transportadora");
    hashMapLabel.set("tra_nome","");
    hashMapLabel.set("f_f","");
    hashMapLabel.set("fil_filial","Filial");
    hashMapLabel.set("fil_filial_descricao","");
    hashMapLabel.set("data_solicitacao","Data Inicial");
    hashMapLabel.set("hora_inicial","Hora");
    hashMapLabel.set("data_solicitacao_final","Data Final");
    hashMapLabel.set("hora_final","Hora");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Solicitações de coletas cadastradas
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(301)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/SolicitacaoColetasForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="id_solicitacao_coleta"/>
                    <html:errors property="tra_cdgo"/>
                    <html:errors property="tra_nome"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="fil_filial_descricao"/>
                    <html:errors property="data_solicitacao"/>
                    <html:errors property="hora_inicial"/>
                    <html:errors property="data_solicitacao_final"/>
                    <html:errors property="hora_final"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_coletas_solicitacoes"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String transportadora = "";
                acesso.Sessao sessao = new acesso.Sessao(session);
                if(sessao.getTipoEntidadeNegocio().equals("TRANSPORTADORA")){
                  transportadora = sessao.getChave();
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nr. Solicitação
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="id_solicitacao_coleta" styleId="id_solicitacao_coleta" styleClass="baseField" size="10" maxlength="22"/>
                  </td>
                </tr>

                <%
                if(transportadora.equals("")) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Transportadora
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="tra_cdgo" styleId="tra_cdgo" onblur="fillFields(0,new Array('tra_cdgo'),'SolicitacaoColetasActionForm.getTra_nome_Ajax',new Array('tra_nome'));" styleClass="baseField" size="10" maxlength="22"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_tra_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_tra_cdgo() {
                          window.open('..//lov/LvTransportadoraLov.do?resetfull_action=&returnBlock=0&return0=tra_cdgo&return1=tra_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="tra_nome" styleId="tra_nome" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="200"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Transportadora
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="tra_cdgo" styleId="tra_cdgo" value="<%= transportadora %>" styleClass="disabled" tabindex="-1" readonly="true" size="10"/>
                    </td>
                  </tr>


                  <hidden:text property="tra_nome" />

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Filial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fil_filial" styleId="fil_filial" onblur="fillFields(0,new Array('fil_filial'),'SolicitacaoColetasActionForm.getFil_filial_descricao_Ajax',new Array('fil_filial_descricao'));" styleClass="baseField" size="10" maxlength="10"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fil_filial()"  >
                    <script type="text/javascript">
                      function lov_open_fil_filial() {
                        window.open('..//lov/LvFilialLov.do?resetfull_action=&returnBlock=0&return0=fil_filial&return1=fil_filial_descricao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="fil_filial_descricao" styleId="fil_filial_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="60" maxlength="200"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Inicial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_solicitacao" styleId="data_solicitacao" styleClass="baseField" size="10" maxlength="10"/>
                    <span class="spamFormLabel">
                      Hora
                    </span>
                    <html:text property="hora_inicial" styleId="hora_inicial" styleClass="baseField" size="5" maxlength="5"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Final
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_solicitacao_final" styleId="data_solicitacao_final" styleClass="baseField" size="10" maxlength="10"/>
                    <span class="spamFormLabel">
                      Hora
                    </span>
                    <html:text property="hora_final" styleId="hora_final" styleClass="baseField" size="5" maxlength="5"/>
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
                    </SCRIPT><html:button accesskey="l" onclick="resetfull_action.click()" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                    </td>
                    </tr>
                    </table>

                    <script type="text/javascript">
                    jQuery(document).ready(function($) {
                      $("#data_solicitacao").mask("99/99/9999");
                      $("#data_solicitacao_final").mask("99/99/9999");
                      $("#hora_inicial").mask("99:99");
                      $("#hora_final").mask("99:99");
                      });
                    </script>
                  </html:form>
                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["id_solicitacao_coleta"];
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

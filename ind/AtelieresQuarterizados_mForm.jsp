<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/AtelieresQuarterizados_mActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = AtelieresQuarterizados_mActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("f_atelieri","");
    hashMapLabel.set("fo_codigo","Atelier");
    hashMapLabel.set("fo_razsoc1","");
    hashMapLabel.set("f_atelierf","");
    hashMapLabel.set("fo_codigo_quarterizado","Fornecedor Quarterizado");
    hashMapLabel.set("fen_seq_quarterizado","Seq. Quarterizado");
    hashMapLabel.set("fo_razsoc","Razão Social");
    hashMapLabel.set("fo_fant","Nome Fantasia");
    hashMapLabel.set("fen_cgc_quarterizado","CGC");
    hashMapLabel.set("fen_cep_quarterizado","CEP");
    hashMapLabel.set("fen_cidade_quarterizado","Cidade");
    hashMapLabel.set("est_unifed_quarterizado","UF");
    hashMapLabel.set("fen_rua_quarterizado","Rua");
    hashMapLabel.set("fen_nro_quarterizado","Nro.");
    hashMapLabel.set("fen_compto_quarterizado","Compto.");
    hashMapLabel.set("fen_bairro_quarterizado","Bairro");
    hashMapLabel.set("fen_insmun_quarterizado","Insc. Munic.");
    hashMapLabel.set("fen_insest_quarterizado","Insc. Est.");
    hashMapLabel.set("fen_ativo_quarterizado","Ativo");
    hashMapLabel.set("fen_email_quarterizado","Email");
    hashMapLabel.set("fen_gln_quarterizado","Fen_gln_quarterizado");
    hashMapLabel.set("tipo_log_quarterizado","Tipo_log_quarterizado");
    hashMapLabel.set("fen_observacao_quarterizado","Obs.");
    hashMapLabel.set("dthr_inclusao","Dthr_inclusao");
    hashMapLabel.set("dthr_alteracao","Dthr_alteracao");
    hashMapLabel.set("usuario_inclusao","Usuario_inclusao");
    hashMapLabel.set("usuario_alteracao","Usuario_alteracao");
    hashMapLabel.set("f_foco","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Cadastro de Atelieres - Manutenção
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(89)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/AtelieresQuarterizados_mForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="fo_codigo"/>
                    <html:errors property="fo_razsoc1"/>
                    <html:errors property="fo_codigo_quarterizado"/>
                    <html:errors property="fen_seq_quarterizado"/>
                    <html:errors property="fo_razsoc"/>
                    <html:errors property="fo_fant"/>
                    <html:errors property="fen_cgc_quarterizado"/>
                    <html:errors property="fen_cep_quarterizado"/>
                    <html:errors property="fen_cidade_quarterizado"/>
                    <html:errors property="est_unifed_quarterizado"/>
                    <html:errors property="fen_rua_quarterizado"/>
                    <html:errors property="fen_nro_quarterizado"/>
                    <html:errors property="fen_compto_quarterizado"/>
                    <html:errors property="fen_bairro_quarterizado"/>
                    <html:errors property="fen_insmun_quarterizado"/>
                    <html:errors property="fen_insest_quarterizado"/>
                    <html:errors property="fen_email_quarterizado"/>
                    <html:errors property="fen_observacao_quarterizado"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_For_endere_quarterizado"/>
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
                if(atelier == null){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Atelier
                      </span>
                      <bean:message key="jsp.fieldnotnull"/>
                    </td>
                    <td class="formField">
                      <html:text property="fo_codigo" styleId="fo_codigo" onblur="fillFields(0,new Array('fo_codigo'),'AtelieresQuarterizados_mActionForm.getFo_razsoc1_Ajax',new Array('fo_razsoc1'));" styleClass="baseField" size="9"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fo_codigo()"  >
                      <script type="text/javascript">
                        function lov_open_fo_codigo() {
                          window.open('..//lov/LvAtelierLov.do?resetfull_action=&returnBlock=0&return0=fo_codigo&return1=fo_razsoc1','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="fo_razsoc1" styleId="fo_razsoc1" styleClass="disabled" tabindex="-1" readonly="true" size="50" maxlength="40"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="fo_codigo" value="<%= atelier %>"/>
                  <html:hidden property="fo_razsoc1"/>

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Fornecedor Quarterizado
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="fo_codigo_quarterizado" styleId="fo_codigo_quarterizado" styleClass="baseField" size="9" maxlength="9"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Seq. Quarterizado
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="fen_seq_quarterizado" styleId="fen_seq_quarterizado" styleClass="baseField" size="4" maxlength="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Razão Social
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="fo_razsoc" styleId="fo_razsoc" styleClass="baseField" size="40" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nome Fantasia
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fo_fant" styleId="fo_fant" styleClass="baseField" size="40" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      CGC
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fen_cgc_quarterizado" styleId="fen_cgc_quarterizado" styleClass="baseField" size="15" maxlength="14"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      CEP
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fen_cep_quarterizado" styleId="fen_cep_quarterizado" onblur="fillFieldsBlank(0,new Array('fen_cep_quarterizado'),'AtelieresQuarterizados_mActionForm.getFen_cep_quarterizado_Ajax',new Array('fen_rua_quarterizado','fen_cidade_quarterizado','fen_bairro_quarterizado','est_unifed_quarterizado'));" styleClass="baseField" size="8" maxlength="8"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cidade
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fen_cidade_quarterizado" styleId="fen_cidade_quarterizado" styleClass="disabled" tabindex="-1" readonly="true" size="60" maxlength="60"/>
                    <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_fen_cidade_quarterizado()"  >
                    <script type="text/javascript">
                      function lov_open_fen_cidade_quarterizado() {
                        window.open('..//lov/LvMunicipiosLov.do?resetfull_action=&returnBlock=0&return1=fen_cidade_quarterizado&return3=est_unifed_quarterizado','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      UF
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="est_unifed_quarterizado" disabled="true" styleId="est_unifed_quarterizado" styleClass="disabled" tabindex="-1" size="1">
                      <html:options property="est_unifed_quarterizadoList" labelProperty="est_unifed_quarterizadoLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Rua
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fen_rua_quarterizado" styleId="fen_rua_quarterizado" styleClass="baseField" size="25" maxlength="25"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nro.
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fen_nro_quarterizado" styleId="fen_nro_quarterizado" styleClass="baseField" size="5" maxlength="5"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Compto.
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fen_compto_quarterizado" styleId="fen_compto_quarterizado" styleClass="baseField" size="10" maxlength="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Bairro
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fen_bairro_quarterizado" styleId="fen_bairro_quarterizado" styleClass="baseField" size="30" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Insc. Munic.
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fen_insmun_quarterizado" styleId="fen_insmun_quarterizado" styleClass="baseField" size="15" maxlength="15"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Insc. Est.
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fen_insest_quarterizado" styleId="fen_insest_quarterizado" styleClass="baseField" size="15" maxlength="15"/>
                  </td>
                </tr>

                <html:hidden property="fen_ativo_quarterizado"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Email
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fen_email_quarterizado" styleId="fen_email_quarterizado" styleClass="baseField" size="100" maxlength="100"/>
                  </td>
                </tr>

                <html:hidden property="fen_gln_quarterizado"/>
                <html:hidden property="tipo_log_quarterizado"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Obs.
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fen_observacao_quarterizado" styleId="fen_observacao_quarterizado" styleClass="baseField" size="100" maxlength="100"/>
                  </td>
                </tr>

                <html:hidden property="dthr_inclusao"/>
                <html:hidden property="dthr_alteracao"/>
                <html:hidden property="usuario_inclusao"/>
                <html:hidden property="usuario_alteracao"/>
                <%
                if(sessao.getTipoEntidadeNegocio().equals("ATELIER")){
                  %>
                  <script>
                    jQuery("#fo_codigo_quarterizado").focus();
                  </script>
                  <%
                } else {
                  %>
                  <script>
                    jQuery("#fo_codigo").focus();
                  </script>
                  <%
                }
                %>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="i" styleClass="baseButton" property="insert_action">
                      <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                    </html:submit>
                    <html:submit accesskey="a" styleClass="baseButton" property="update_action">
                      <bean:message bundle="ApplicationResources" key="jsp.update"/>
                    </html:submit>
                    <html:submit accesskey="a" onclick="return confirmSubmit('');" styleClass="baseButton" property="delete_action">
                      <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="a" value="Voltar" styleClass="baseButton" property="back_action">
                    </html:submit>
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
          </td>
        </tr>
      </table>

    </body>
  </center>
</html>

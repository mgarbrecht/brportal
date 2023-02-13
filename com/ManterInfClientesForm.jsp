<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ManterInfClientesActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ManterInfClientesActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("gre_grupo","Grupo Econômico");
    hashMapLabel.set("gre_descricao","");
    hashMapLabel.set("cli_cdgo","Cliente");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("esc_seqn","Seq.");
    hashMapLabel.set("somente_etiqueta","Etiqueta");
    hashMapLabel.set("cb_agrupar_grupo","Agrupar Por Grupo Econômico");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Manter Informações de Clientes
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(200)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ManterInfClientesForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="gre_grupo"/>
                    <html:errors property="gre_descricao"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="esc_seqn"/>
                    <html:errors property="somente_etiqueta"/>
                    <html:errors property="cb_agrupar_grupo"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Cli_inf_adicionais_vw"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Grupo Econômico
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="gre_grupo" styleId="gre_grupo" onblur="fillFields(0,new Array('gre_grupo'),'ManterInfClientesActionForm.getGre_descricao_Ajax',new Array('gre_descricao'));" styleClass="baseField" size="6" maxlength="6"/>
                    <input type="button" class="lovButton"  value="..." tabindex="-1" onclick="javascript:lov_open_gre_grupo()"  >
                    <script type="text/javascript">
                      function lov_open_gre_grupo() {
                        window.open('..//lov/LvGrupoEconomicoLov.do?resetfull_action=&returnBlock=0&return0=gre_grupo&return1=gre_descricao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="gre_descricao" styleId="gre_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cliente
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_cdgo" styleId="cli_cdgo" onblur="fillFields(0,new Array('cli_cdgo'),'ManterInfClientesActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));" styleClass="baseField" size="10" maxlength="22"/>
                    <input type="button" class="lovButton"  value="..." tabindex="-1" onclick="javascript:lov_open_cli_cdgo()"  >
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
                      Seq.
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="esc_seqn" styleId="esc_seqn" styleClass="baseField" size="4" maxlength="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Etiqueta
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="somente_etiqueta" styleId="somente_etiqueta" styleClass="baseField">
                      <html:option styleClass="baseOption" value="">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="Sim">
                        Sim
                      </html:option>
                      <html:option styleClass="baseOption" value="Não">
                        Não
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Agrupar Por Grupo Econômico
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_agrupar_grupo" styleId="cb_agrupar_grupo" styleClass="baseField" value="S"/>
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
                    <html:submit accesskey="p" styleClass="myhidden" property="select_session_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="i" value="Cadastrar Informações" styleClass="baseButton" property="insert_action">
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["gre_grupo"];
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

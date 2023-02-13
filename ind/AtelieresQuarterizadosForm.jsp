<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/AtelieresQuarterizadosActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = AtelieresQuarterizadosActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free1","");
    hashMapLabel.set("forn_i","");
    hashMapLabel.set("fo_codigo","Fornecedor");
    hashMapLabel.set("fo_razsoc","");
    hashMapLabel.set("forn_f","");
    hashMapLabel.set("fo_codigo_quarterizado","Fornecedor Quarterizado");
    hashMapLabel.set("fen_seq_quarterizado","Seq.");
    hashMapLabel.set("fen_cgc_quarterizado","CGC");
    hashMapLabel.set("f_razsoc","Razão Social");
    hashMapLabel.set("est_unifed_quarterizado","UF");
    hashMapLabel.set("fen_cidade_quarterizado","Cidade");
    hashMapLabel.set("free","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Cadastro de Atelieres
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(87)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/AtelieresQuarterizadosForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="fo_codigo"/>
                    <html:errors property="fo_razsoc"/>
                    <html:errors property="fo_codigo_quarterizado"/>
                    <html:errors property="fen_seq_quarterizado"/>
                    <html:errors property="fen_cgc_quarterizado"/>
                    <html:errors property="f_razsoc"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_For_endere_quarterizado"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String fornecedor = null;
                acesso.Sessao sessao = new acesso.Sessao(session);
                if(sessao.getTipoEntidadeNegocio().equals("ATELIER")){
                  fornecedor = sessao.getChave();
                }
                %>
                <%
                if(fornecedor == null){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Fornecedor
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="fo_codigo" styleId="fo_codigo" onblur="fillFields(0,new Array('fo_codigo'),'AtelieresQuarterizadosActionForm.getFo_razsoc_Ajax',new Array('fo_razsoc'));" styleClass="baseField" size="9" maxlength="9"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fo_codigo()"  >
                      <script type="text/javascript">
                        function lov_open_fo_codigo() {
                          window.open('..//lov/LvAtelierLov.do?resetfull_action=&returnBlock=0&return0=fo_codigo&return1=fo_razsoc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="fo_razsoc" styleId="fo_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="fo_codigo" value="<%= fornecedor %>"/>
                  <html:hidden property="fo_razsoc" />


                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Fornecedor Quarterizado
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fo_codigo_quarterizado" styleId="fo_codigo_quarterizado" styleClass="baseField" size="9" maxlength="9"/>
                    <span class="spamFormLabel">
                      Seq.
                    </span>
                    <html:text property="fen_seq_quarterizado" styleId="fen_seq_quarterizado" styleClass="baseField" size="4" maxlength="4"/>
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
                      Razão Social
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="f_razsoc" styleId="f_razsoc" styleClass="baseField" size="40" maxlength="40"/>
                  </td>
                </tr>

                <html:hidden property="est_unifed_quarterizado"/>
                <html:hidden property="fen_cidade_quarterizado"/>
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
                    <html:button accesskey="p" onclick="bloqueia();cadastrar1_action.disabled=true;resetfull1_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:button>
                    <script>
                      function getKeySite(keyStroke) {
                        isNetscape=(document.layers);
                        eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                        which = String.fromCharCode(eventChooser).toLowerCase();
                        keyBuffer = which;
                        if(eventChooser == 13){
                          bloqueia();
                        if(document.forms[0].select1_action.disabled==true){return false;}
                        document.forms[0].select1_action.disabled=true;
                        document.forms[0].resetfull1_action.disabled=true;
                        document.forms[0].cadastrar1_action.disabled=true;
                        document.forms[0].select_action.click();
                      }
                    }
                  </script>
                  <SCRIPT>
    document.onkeypress = getKeySite;
</SCRIPT><html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
<html:button accesskey="p" value="Cadastrar Novo Atelier" onclick="cadastrar_action.click();" styleClass="baseButton" property="cadastrar1_action"></html:button>
<html:submit accesskey="p" styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
<html:submit accesskey="l" styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
<html:submit value="Cadastrar Novo Atelier Quarterizado" styleClass="myhidden" property="cadastrar_action"></html:submit>
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

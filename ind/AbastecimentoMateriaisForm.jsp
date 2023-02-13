<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/AbastecimentoMateriaisActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = AbastecimentoMateriaisActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("f_fi","");
    hashMapLabel.set("fornecedor","Fornecedor");
    hashMapLabel.set("fdesc","");
    hashMapLabel.set("f_ff","");
    hashMapLabel.set("ies_codigo","Item");
    hashMapLabel.set("item_desc","");
    hashMapLabel.set("cor_cdgo","Cor");
    hashMapLabel.set("cor_desc","");
    hashMapLabel.set("fil_filial","Filial");
    hashMapLabel.set("fil_razsoc","");
    hashMapLabel.set("gpo_mater_cdgo","Grupo Material");
    hashMapLabel.set("gpo_mater_desc","");
    hashMapLabel.set("tipo","Tipo de consulta");
    hashMapLabel.set("free_focus","");
    hashMapLabel.set("dt_entrega","Data Entrega");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Posição de Faltas do Fornecedor
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(8)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/AbastecimentoMateriaisForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="fornecedor"/>
                    <html:errors property="fdesc"/>
                    <html:errors property="ies_codigo"/>
                    <html:errors property="item_desc"/>
                    <html:errors property="cor_cdgo"/>
                    <html:errors property="cor_desc"/>
                    <html:errors property="gpo_mater_cdgo"/>
                    <html:errors property="gpo_mater_desc"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_abastecimento_materiais"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String fornecedor = "";
                acesso.Sessao sessao = new acesso.Sessao(session);
                if(sessao.getTipoEntidadeNegocio().equals("FORNECEDOR")){
                  fornecedor = sessao.getChave();
                }
                %>
                <%
                if(fornecedor.equals("")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Fornecedor
                      </span>
                      <bean:message key="jsp.fieldnotnull"/>
                    </td>
                    <td class="formField">
                      <html:text property="fornecedor" styleId="fornecedor" onblur="fillFields(0,new Array('fornecedor'),'AbastecimentoMateriaisActionForm.getFdesc_Ajax',new Array('fdesc'));" styleClass="baseField" size="10"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fornecedor()"  >
                      <script type="text/javascript">
                        function lov_open_fornecedor() {
                          window.open('..//lov/LvCorFornecedorLov.do?resetfull_action=&returnBlock=0&return0=fornecedor&return1=for_razsoc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="fdesc" styleId="fdesc" styleClass="disabled" tabindex="-1" readonly="true" size="50"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="fornecedor" value="<%= fornecedor %>"/>
                  <html:hidden property="fdesc" />

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Item
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ies_codigo" styleId="ies_codigo" onblur="fillFields(0,new Array('ies_codigo'),'AbastecimentoMateriaisActionForm.getItem_desc_Ajax',new Array('item_desc'));" styleClass="baseField" size="10"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_ies_codigo()"  >
                    <script type="text/javascript">
                      function lov_open_ies_codigo() {
                        window.open('..//lov/ItemLov.do?resetfull_action=&returnBlock=0&return0=ies_codigo','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="item_desc" styleId="item_desc" styleClass="disabled" tabindex="-1" readonly="true" size="100"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cor
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cor_cdgo" styleId="cor_cdgo" onblur="fillFields(0,new Array('cor_cdgo'),'AbastecimentoMateriaisActionForm.getCor_desc_Ajax',new Array('cor_desc'));" styleClass="baseField" size="10"/>
                    <input type="button" class="lovButton" tabindex="-1"  value="..."  onclick="javascript:lov_open_cor_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_cor_cdgo() {
                        window.open('..//lov/LvCorFornecedorLov.do?resetfull_action=&returnBlock=0&return0=cor_cdgo','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cor_desc" styleId="cor_desc" styleClass="disabled" tabindex="-1" readonly="true" size="70"/>
                  </td>
                </tr>

                <html:hidden property="fil_filial"/>
                <html:hidden property="fil_razsoc"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Grupo Material
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="gpo_mater_cdgo" styleId="gpo_mater_cdgo" onblur="fillFields(0,new Array('gpo_mater_cdgo'),'AbastecimentoMateriaisActionForm.getGpo_mater_desc_Ajax',new Array('gpo_mater_desc'));" styleClass="baseField" size="7"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_gpo_mater_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_gpo_mater_cdgo() {
                        window.open('..//lov/LvGrupoMaterialLov.do?resetfull_action=&returnBlock=0&return0=gpo_mater_cdgo&return1=gpo_mater_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="gpo_mater_desc" styleId="gpo_mater_desc" styleClass="disabled" tabindex="-1" readonly="true" size="50"/>
                  </td>
                </tr>

                <html:hidden property="tipo" value="falta"/>
                <%
                if(sessao.getTipoEntidadeNegocio().equals("FORNECEDOR")){
                  %>
                  <script>
                    var focusControl = document.forms[0].elements["ies_codigo"];
                    focusControl.focus();
                  </script>
                  <%
                } else {
                  %>
                  <script>
                    var focusControl = document.forms[0].elements["fornecedor"];
                    focusControl.focus();
                  </script>
                  <%
                }
                %>
                <html:hidden property="dt_entrega"/>
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
<html:submit accesskey="p" styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
<html:submit accesskey="l" styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
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

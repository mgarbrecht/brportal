<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/MaioresClientesVencidosActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = MaioresClientesVencidosActionForm;
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
    hashMapLabel.set("quantidade","Quantidade");
    hashMapLabel.set("dias_vencidos","Dias Vencidos");
    hashMapLabel.set("acumular_pendencia","Acumular Pendência");
    hashMapLabel.set("reg","");
    hashMapLabel.set("rep","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Consulta de Maiores Clientes Vencidos
    </title>
  </head>
  <center>
    <body onload="if(document.forms[0].reg.value!=''){document.forms[0].rep_cdgo.focus();}if(document.forms[0].rep.value!=''){document.forms[0].quantidade.focus();}if(document.forms[0].rep.value=='' && document.forms[0].reg.value==''){document.forms[0].codigo_regional.focus();}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(77)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="adm/MaioresClientesVencidosForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="codigo_regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="quantidade"/>
                    <html:errors property="dias_vencidos"/>
                    <html:errors property="acumular_pendencia"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_maiores_clientes_vencidos"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String codigo_regional="";
                String codigo_representante="";
                String tipo="";
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
                %>
                <%
                if((codigo_regional.equals("")) && (codigo_representante.equals(""))) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Regional
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="codigo_regional" onblur="reg.value=this.value;if(this.value!=''){fillFields(0,new Array('codigo_regional'),'MaioresClientesVencidosActionForm.getNome_regional_Ajax',new Array('nome_regional'))}else{nome_regional.value=''};" styleClass="baseField" size="3" maxlength="3"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_regional()"  >
                      <script type="text/javascript">
                        function lov_open_codigo_regional() {
                          window.open('../lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=codigo_regional&return1=nome_regional','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="43"/>
                    </td>
                  </tr>

                  <%
                }
                %>
                <%
                if((!(codigo_regional.equals("")))
                ||
                ((codigo_regional.equals("")) && (codigo_representante.equals("")))
                ){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Representante
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="rep_cdgo" onblur="if(this.value!=''){fillFields(0,new Array('rep_cdgo'),'MaioresClientesVencidosActionForm.getRep_rzao_Ajax',new Array('rep_rzao'))}else{rep_rzao.value=''};" styleClass="baseField" size="5" maxlength="5"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_rep_cdgo() {
                          window.open('../lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                    </td>
                  </tr>

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Quantidade
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="quantidade" styleClass="baseField" size="4" maxlength="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Dias Vencidos
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="dias_vencidos" styleClass="baseField" size="3" maxlength="3"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Acumular Pendência
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="acumular_pendencia" styleId="acumular_pendencia" styleClass="baseField" value="true"/>
                  </td>
                </tr>

                <html:hidden property="reg" value="<%= codigo_regional %>"/>
                <html:hidden property="rep" value="<%= codigo_representante %>"/>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="p" onclick="resetfull1_action.disabled=true;this.disabled=true;bloqueia();document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
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
                        bloqueia();
                        document.forms[0].select_action.click();
                      }
                    }
                  </script>
                  <SCRIPT>
    document.onkeypress = getKeySite;
</SCRIPT><html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
<html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
<html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/CodigoBarraDun14ActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = CodigoBarraDun14ActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("cod_linha","CodigoBarraDun14.cod_linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("cod_refer","CodigoBarraDun14.cod_refer");
    hashMapLabel.set("ref_desc","");
    hashMapLabel.set("cabedal","CodigoBarraDun14.cabedal");
    hashMapLabel.set("cab_desc","");
    hashMapLabel.set("cor","CodigoBarraDun14.cor");
    hashMapLabel.set("cor_desc","");
    hashMapLabel.set("gde_cdgo","CodigoBarraDun14.gde_cdgo");
    hashMapLabel.set("status","CodigoBarraDun14.status");
    hashMapLabel.set("lin_cdgo","lin_cdgo");
    hashMapLabel.set("ref_cdgo","");
    hashMapLabel.set("ano_fatura_proforma","Ano Fatura Proforma");
    hashMapLabel.set("numero_fatura_proforma","Número Fatura Proforma");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      <bean:message bundle="ComercialResources" key="CodigoBarraDun14.titulo"/>
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(67)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/CodigoBarraDun14Form.do" method="post" styleClass="baseForm" target="_self">
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
                    <html:errors property="cod_linha"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="cod_refer"/>
                    <html:errors property="ref_desc"/>
                    <html:errors property="cabedal"/>
                    <html:errors property="cab_desc"/>
                    <html:errors property="cor"/>
                    <html:errors property="cor_desc"/>
                    <html:errors property="gde_cdgo"/>
                    <html:errors property="status"/>
                    <html:errors property="ano_fatura_proforma"/>
                    <html:errors property="numero_fatura_proforma"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_cod_barra_dum14_1"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="CodigoBarraDun14.cod_linha"/>
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="cod_linha" onblur="lin_cdgo.value=this.value;fillFields(0,new Array('cod_linha'),'CodigoBarraDun14ActionForm.getLin_nome_Ajax',new Array('lin_nome'));" styleClass="baseField" size="6" maxlength="6"/>
                    <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_cod_linha()"  >
                    <script type="text/javascript">
                      function lov_open_cod_linha() {
                        window.open('../lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=cod_linha&return1=lin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_nome" styleId="lin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="28" maxlength="25"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="CodigoBarraDun14.cod_refer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cod_refer" onblur="ref_cdgo.value=this.value;fillFields(0,new Array('cod_linha','cod_refer'),'CodigoBarraDun14ActionForm.getRef_desc_Ajax',new Array('ref_desc'));" styleClass="baseField" size="6"/>
                    <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_cod_refer()"  >
                    <script type="text/javascript">
                      function lov_open_cod_refer() {
                        window.open('../lov/LvRefLov.do?resetfull_action=&returnBlock=0&return0=cod_refer&return1=ref_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="ref_desc" styleId="ref_desc" styleClass="disabled" tabindex="-1" readonly="true" size="28" maxlength="25"/>
                  </td>
                </tr>

                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      <bean:message bundle="ComercialResources" key="CodigoBarraDun14.cabedal"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cabedal" styleClass="baseField" size="4" onblur="fillFields(0,new Array('cabedal'),'CodigoBarraDun14ActionForm.getCab_desc_Ajax',new Array('cab_desc'));" maxlength="4"/>
                    <input type="button" class="lovButton" value="..." tabindex="-1" onclick="ref_cdgo.value=cod_refer.value;lin_cdgo.value=cod_linha.value;window.open('../lov/LvCabedalLov.do?resetfull_action=&returnBlock=0&return0=cabedal&return1=cab_desc','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cab_desc" styleId="cab_desc" styleClass="disabled" tabindex="-1" readonly="true" size="42" maxlength="35"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="CodigoBarraDun14.cor"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cor" onblur="fillFields(0,new Array('cor'),'CodigoBarraDun14ActionForm.getCor_desc_Ajax',new Array('cor_desc'));" styleClass="baseField" size="5" maxlength="10"/>
                    <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_cor()"  >
                    <script type="text/javascript">
                      function lov_open_cor() {
                        window.open('../lov/LvCorLov.do?resetfull_action=&returnBlock=0&return0=cor&return1=cor_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cor_desc" styleId="cor_desc" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="CodigoBarraDun14.gde_cdgo"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="gde_cdgo" styleClass="baseField" size="3" maxlength="3"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="CodigoBarraDun14.status"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="status" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="A">
                        <bean:message bundle="ComercialResources" key="CodigoBarraDun14.ativas"/>
                      </html:option>
                      <html:option styleClass="baseOption" value="I">
                        <bean:message bundle="ComercialResources" key="CodigoBarraDun14.inativas"/>
                      </html:option>
                      <html:option styleClass="baseOption" value="">
                        <bean:message bundle="ComercialResources" key="CodigoBarraDun14.todas"/>
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <html:hidden property="lin_cdgo"/>
                <html:hidden property="ref_cdgo"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Ano Fatura Proforma
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="ano_fatura_proforma" styleId="ano_fatura_proforma" styleClass="baseField" size="4" maxlength="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Número Fatura Proforma
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="numero_fatura_proforma" styleId="numero_fatura_proforma" styleClass="baseField" size="4"/>
                  </td>
                </tr>

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
                        if(eventChooser == 13){
                          bloqueia();
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
                    </td>
                    </tr>
                    </table>

                    </html:form>
                    <script type="text/javascript">
                    var focusControl = document.forms[0].elements["cod_linha"];
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

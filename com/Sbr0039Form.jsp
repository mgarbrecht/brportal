<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/Sbr0039ActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = Sbr0039ActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("marca","Marca");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("ref_cdgo","Referência");
    hashMapLabel.set("ref_desc","");
    hashMapLabel.set("tipo_tabela","Tipo de Tabela");
    hashMapLabel.set("abre_automaticamente","Abre o Relatório Automaticamente");
    hashMapLabel.set("mensagem","");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Tabela de Preços
    </title>
  </head>
  <center>
    <body onload="if('<%= (String)request.getAttribute("arquivo") %>' == 'null'){document.forms[0].abre_automaticamente.checked=false;document.forms[0].mensagem.value='';}if(document.forms[0].abre_automaticamente.checked==true){if('<%= (String)request.getAttribute("arquivo") %>' != 'null'){window.open('<%= (String)request.getAttribute("arquivo") %>','_blank');}}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(167)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/Sbr0039Form.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="marca"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="ref_desc"/>
                    <html:errors property="tipo_tabela"/>
                    <html:errors property="abre_automaticamente"/>
                    <html:errors property="mensagem"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
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

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" onblur="fillFields(0,new Array('lin_cdgo'),'Sbr0039ActionForm.getLin_nome_Ajax',new Array('lin_nome'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('..//lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_nome" styleId="lin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="25"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Referência
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ref_cdgo" styleId="ref_cdgo" onblur="fillFields(0,new Array('lin_cdgo','ref_cdgo'),'Sbr0039ActionForm.getRef_desc_Ajax',new Array('ref_desc'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_ref_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_ref_cdgo() {
                        window.open('..//lov/LvLinhaRefLov.do?resetfull_action=&returnBlock=0&return0=ref_cdgo&return1=ref_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="ref_desc" styleId="ref_desc" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="25"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo de Tabela
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo_tabela" styleId="tipo_tabela" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="AMBAS">
                        AMBAS
                      </html:option>
                      <html:option styleClass="baseOption" value="VENDOR">
                        VENDOR
                      </html:option>
                      <html:option styleClass="baseOption" value="BEIRARIO">
                        BEIRARIO
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Abre o Relatório Automaticamente
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="abre_automaticamente" styleId="abre_automaticamente" onclick="if(this.checked==true){mensagem.value='Obs.: Uma nova janela será aberta para a visualização do relatório.';}else{mensagem.value='';}" styleClass="baseField" value="checked"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="mensagem" styleId="mensagem" style="background-color:transparent; border-style:none; color:red; background-color:transparent; border-style:none; cursor:default; text-align:start;" styleClass="baseField" size="90"/>
                  </td>
                </tr>

                <%
                if((String)request.getAttribute("abre_automaticamente")=="N"){
                  %>
                  <table style=width:100%;margin-top:10;>
                    <tr>
                      <td class=columHeader style="text-align:center;">
                        <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                          <bean:message key="report.downloadpdf"/>
                        </a>
                      </td>
                    </tr>
                  </table>
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ClassificacaoFiscalAction.js">
  </script>
  <script type="text/javascript" src="../dwr/interface/ClassificacaoFiscalActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionClass = ClassificacaoFiscalAction;
    var ActionFormClass = ClassificacaoFiscalActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("codigo_marca","Marca");
    hashMapLabel.set("marca_nome","");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("ref_cdgo","Ref.");
    hashMapLabel.set("ref_desc","");
    hashMapLabel.set("cab_cdgo","Cabedal");
    hashMapLabel.set("cab_desc","");
    hashMapLabel.set("situacao","Situação");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Classificação Fiscal
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(119)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/ClassificacaoFiscalForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <div class\='div10l'>
                        Um dos campos com
                        <img src='../img/opcional.gif' border\='0' title\='Opcional' style\='cursor\:pointer'>
                        deve ser preenchido.
                      </div>
                    </div>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="marca_nome"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="ref_desc"/>
                    <html:errors property="cab_cdgo"/>
                    <html:errors property="cab_desc"/>
                    <html:errors property="situacao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_ncm"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_marca" styleId="codigo_marca" onblur="fillFields(0,new Array('codigo_marca'),'ClassificacaoFiscalActionForm.getMarca_nome_Ajax',new Array('marca_nome'));" styleClass="baseField" size="3" maxlength="3"/>
                    <input type="button" class="lovButton"  tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_marca()"  >
                    <script type="text/javascript">
                      function lov_open_codigo_marca() {
                        window.open('..//lov/LvMarcaLov.jsp?returnBlock=0&return0=codigo_marca&return1=marca_nome','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="marca_nome" disabled="true" styleId="marca_nome" styleClass="disabled" size="30" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" onblur="fillFields(0,new Array('lin_cdgo'),'ClassificacaoFiscalActionForm.getLin_nome_Ajax',new Array('lin_nome'));" styleClass="baseField" size="7" />
                    <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('../lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
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
                      Ref.
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ref_cdgo" onblur="fillFields(0,new Array('lin_cdgo','ref_cdgo'),'ClassificacaoFiscalActionForm.getRef_desc_Ajax',new Array('ref_desc'));" styleClass="baseField" size="7" />
                    <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_ref_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_ref_cdgo() {
                        window.open('../lov/LvRefLov.do?resetfull_action=&returnBlock=0&return0=ref_cdgo&return1=ref_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
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
                      Cabedal
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cab_cdgo" onblur="fillFields(0,new Array('cab_cdgo'),'ClassificacaoFiscalActionForm.getCab_desc_Ajax',new Array('cab_desc'));" styleClass="baseField" size="7" />
                    <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_cab_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_cab_cdgo() {
                        window.open('../lov/LvCabedalLov.do?resetfull_action=&returnBlock=0&return0=cab_cdgo&return1=cab_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cab_desc" styleId="cab_desc" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
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
                      <html:option styleClass="baseOption" value="A">
                        Ativos
                      </html:option>
                      <html:option styleClass="baseOption" value="I">
                        Inativos
                      </html:option>
                      <html:option styleClass="baseOption" value="">
                        Todos
                      </html:option>
                    </html:select>
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
                    </SCRIPT><html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                    <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                    <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                    </td>
                    </tr>
                    </table>

                    </html:form><script type="text/javascript">
                    var focusControl = document.forms[0].elements["codigo_marca"];
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

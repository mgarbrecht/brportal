<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/RelatorioApontamentoCaixasActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = RelatorioApontamentoCaixasActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("tipo","Tipo Relatório");
    hashMapLabel.set("rem_nro","Remessas<img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>");
    hashMapLabel.set("ped_nmro","Pedidos<img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>");
    hashMapLabel.set("f_fornecedor_i","");
    hashMapLabel.set("fornecedor","Fornecedor");
    hashMapLabel.set("fornecedor_razao","");
    hashMapLabel.set("f_fornecedor_f","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Relatório Apontamento Caixas Corrugadas
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(329)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/RelatorioApontamentoCaixasForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      Um dos campos com
                      <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                      deve ser preenchido.
                    </div>
                    <html:errors property="tipo"/>
                    <html:errors property="rem_nro"/>
                    <html:errors property="ped_nmro"/>
                    <html:errors property="fornecedor"/>
                    <html:errors property="fornecedor_razao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_apontamento_caixas_corrugadas"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String for_codigo="";
                String tipo="";
                acesso.Usuario u = new acesso.Usuario();
                u = (acesso.Usuario)session.getAttribute("User");
                acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
                acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

                if(!(u.getEntidadeNegocio()==null)){
                  ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                  tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
                  tipo = tipoent.getTipo()+"";
                  if(tipo.equals("ATELIER")){
                    for_codigo = ent.getChave()+"";
                  }
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo Relatório
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo" styleId="tipo" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="T">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="A">
                        Apontados
                      </html:option>
                      <html:option styleClass="baseOption" value="N">
                        Não Apontados
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Remessas
                      <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                    </span>
                  </td>
                  <td class="formField">
                    <html:textarea property="rem_nro" styleId="rem_nro" styleClass="baseField" cols="60" rows="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Pedidos
                      <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                    </span>
                  </td>
                  <td class="formField">
                    <html:textarea property="ped_nmro" styleId="ped_nmro" styleClass="baseField" cols="60" rows="4"/>
                  </td>
                </tr>

                <%
                if(for_codigo.equals("")) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Fornecedor
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="fornecedor" styleId="fornecedor" onblur="fillFields(0,new Array('fornecedor'),'RelatorioApontamentoCaixasActionForm.getFornecedor_razao_Ajax',new Array('fornecedor_razao'));" styleClass="baseField" size="10" maxlength="10"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fornecedor()"  >
                      <script type="text/javascript">
                        function lov_open_fornecedor() {
                          window.open('..//lov/LvFornecedorLov.jsp?returnBlock=0&return0=fornecedor&return1=fornecedor_razao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="fornecedor_razao" styleId="fornecedor_razao" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="45"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>
                  <html:hidden property="fornecedor" value="<%= for_codigo %>"/>
                  <html:hidden property="fornecedor_razao" />

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
                  <html:submit accesskey="p" styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                  <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form><script type="text/javascript">
                  var focusControl = document.forms[0].elements["rem_nro"];
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

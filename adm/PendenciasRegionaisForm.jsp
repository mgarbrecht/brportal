<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/PendenciasRegionaisActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = PendenciasRegionaisActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("reg","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("rep","Representante");
    hashMapLabel.set("rep_nome","");
    hashMapLabel.set("situacao_rep","Situação Representantes");
    hashMapLabel.set("cb_clientes","Exibir Clientes");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Pendências de Clientes
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(148)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="adm/PendenciasRegionaisForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="reg"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="rep"/>
                    <html:errors property="rep_nome"/>
                    <html:errors property="situacao_rep"/>
                    <html:errors property="cb_clientes"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_pendencias_regionais"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String codigo_regional = null;
                String nome_regional = null;
                String codigo_representante = null;
                String nome_representante = null;

                acesso.Sessao se = new acesso.Sessao(session);
                String tipo = se.getTipoEntidadeNegocio();
                if(tipo.equals("REGIONAL DE VENDA")){
                  codigo_regional = se.getChave();
                  nome_regional   = se.getDescricao();
                } else {
                  codigo_regional = "";
                  nome_regional   = "";
                }
                if((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))){
                  codigo_representante = se.getChave();
                  nome_representante   = se.getDescricao();
                } else {
                  codigo_representante = "";
                  nome_representante   = "";
                }
                %>
                <%
                if(codigo_representante.equals("")) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Regional
                      </span>
                    </td>
                    <td class="formField">
                      <%
                      if(codigo_regional.equals("")){
                        %>
                        <html:text property="reg" styleId="reg" onblur="fillFields(0,new Array('reg'),'PendenciasRegionaisActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="baseField" value="<%= codigo_regional %>" size="3" maxlength="3"/>
                        <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_reg()"  >
                        <%
                      } else {
                        %>
                        <html:text property="reg" styleId="reg" readonly="true" styleClass="disabled" value="<%= codigo_regional %>" size="3" maxlength="3"/>
                        <%
                      }
                      %>
                      <script type="text/javascript">
                        function lov_open_reg() {
                          window.open('..//lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=reg&return1=nome_regional','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                        }
                      </script>
                      <%
                    } else {
                      %>
                      <html:hidden property="reg" value="<%= codigo_regional %>"/>
                      <%
                    }
                    %>
                    <span class="spamFormLabel">
                    </span>
                    <%
                    if(codigo_representante.equals("")) {
                      %>
                      <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" value="<%= nome_regional %>" size="40" maxlength="40"/>
                      <%
                    } else {
                      %>
                      <html:hidden property="nome_regional"/>
                      <%
                    }
                    %>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Representante
                    </span>
                  </td>
                  <td class="formField">
                    <%
                    if(codigo_representante.equals("")) {
                      %>
                      <html:text property="rep" styleId="rep" onblur="fillFields(0,new Array('rep'),'PendenciasRegionaisActionForm.getRep_nome_Ajax',new Array('rep_nome'));" styleClass="baseField" value="<%= codigo_representante %>" size="5" maxlength="5"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep()"  >
                      <%
                    } else {
                      %>
                      <html:text property="rep" styleId="rep" readonly="true" styleClass="disabled" value="<%= codigo_representante %>" size="5" maxlength="5"/>
                      <%
                    }
                    %>
                    <script type="text/javascript">
                      function lov_open_rep() {
                        window.open('..//lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep&return1=rep_nome','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="rep_nome" styleId="rep_nome" styleClass="disabled" tabindex="-1" readonly="true" value="<%= nome_representante %>" size="42" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situação Representantes
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="situacao_rep" styleId="situacao_rep" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="A">
                        Ativos
                      </html:option>
                      <html:option styleClass="baseOption" value="I">
                        Inativos
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Exibir Clientes
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_clientes" styleId="cb_clientes" styleClass="baseField" value="true"/>
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
                  </SCRIPT>

                  <html:button accesskey="r" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
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
                  var focusControl = document.forms[0].elements["reg"];
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

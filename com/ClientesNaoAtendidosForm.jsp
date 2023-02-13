<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Clientes Não Atendidos por Regionais e Representantes
    </title>
  </head>
  <center>
    <body onload="document.forms[0].data_ini.focus();">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(155)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ClientesNaoAtendidosForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <bean:message key="div.campos*"/>
                      <div class\='div10l'>
                        Um dos campos com
                        <img src='../img/opcional.gif' border\='0' title\='Opcional' style\='cursor\:pointer'>
                        deve ser preenchido.
                      </div>
                    </div>
                    <html:errors property="data_ini"/>
                    <html:errors property="data_fim"/>
                    <html:errors property="reg_cdgo"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_situ"/>
                    <html:errors property="cli_rep_situ"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_clientes_nao_atendidos"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String codigo_regional="";
                String codigo_representante="";
                String codigo_analista="";
                String codigo_cliente="";
                acesso.Sessao se = new acesso.Sessao(session);
                String tipo = se.getTipoEntidadeNegocio();

                if(tipo.equals("REGIONAL DE VENDA")){
                  codigo_regional = se.getChave();
                }
                if((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))){
                  codigo_representante = se.getChave();
                }
                if(tipo.equals("ANALISTA REGIONAL")){
                  codigo_analista = se.getChave();
                }
                if(tipo.equals("CLIENTE MERCADO INTERNO")){
                  codigo_cliente = se.getChave();
                }

                if(tipo.equals("ANALISTA REGIONAL")){
                  com.egen.util.jdbc.JdbcUtil j = null;
                  try {
                    j = new com.egen.util.jdbc.JdbcUtil();
                    portalbr.dbobj.view.Jw_regional_analista table = new portalbr.dbobj.view.Jw_regional_analista();
                    String[][] select = null;
                    Object[][] where = {{"codigo_gerente","=",codigo_analista} };
                    Vector res_Jw_regional_analista = j.select(table, select, where, null, null, null);
                    if (res_Jw_regional_analista != null && res_Jw_regional_analista.size() > 0) {
                      portalbr.dbobj.view.Jw_regional_analista r = (portalbr.dbobj.view.Jw_regional_analista) res_Jw_regional_analista.elementAt(0);
                      codigo_regional = r.getCodigo_regional();
                    }
                  } finally {
                    if(j!=null){
                      j.close();
                      j = null;
                    }
                  }
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Inicial
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="data_ini" styleId="data_ini" styleClass="baseField" size="11"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Final
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="data_fim" styleId="data_fim" styleClass="baseField" size="11"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Regionais
                    </span>
                    <img src="../img/opcional.gif">
                  </img>
                </td>
                <td class="formField">
                  <%
                  if(codigo_regional.equals("")){
                    %>
                    <html:text property="reg_cdgo" styleId="reg_cdgo" styleClass="baseField"/>
                    <%
                  } else {
                    %>
                    <html:text property="reg_cdgo" styleId="reg_cdgo" value="<%= codigo_regional %>" tabindex="-1" readonly="true" styleClass="disabled"/>
                    <%
                  }
                  %>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Representantes
                  </span>
                  <img src="../img/opcional.gif">
                </img>
              </td>
              <td class="formField">
                <html:text property="rep_cdgo" styleId="rep_cdgo" styleClass="baseField"/>
              </td>
            </tr>

            <tr class="itemTr">
              <td class="formLabel">
                <span class="spamFormLabel">
                  Situação Representante
                </span>
              </td>
              <td class="formField">
                <html:select property="rep_situ" styleId="rep_situ" styleClass="baseField" size="1">
                  <html:option styleClass="baseOption" value="">
                    Todos
                  </html:option>
                  <html:option styleClass="baseOption" value="'A'">
                    Ativos
                  </html:option>
                  <html:option styleClass="baseOption" value="'I'">
                    Inativos
                  </html:option>
                </html:select>
              </td>
            </tr>

            <tr class="itemTr">
              <td class="formLabel">
                <span class="spamFormLabel">
                  Situação Cliente/Representante
                </span>
              </td>
              <td class="formField">
                <html:select property="cli_rep_situ" styleId="cli_rep_situ" styleClass="baseField" size="1">
                  <html:option styleClass="baseOption" value="">
                    Todos
                  </html:option>
                  <html:option styleClass="baseOption" value="'A'">
                    Ativos
                  </html:option>
                  <html:option styleClass="baseOption" value="'I'">
                    Inativos
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
              </SCRIPT><html:submit accesskey="s" styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
              <html:submit accesskey="r" styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
              <html:button accesskey="r" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
              </td>
              </tr>
              </table>

              <script type="text/javascript">
              jQuery(document).ready(function($) {
                $("#data_ini").mask("99/99/9999");
                $("#data_fim").mask("99/99/9999");
                });
              </script>
            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["data_ini"];
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

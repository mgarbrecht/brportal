<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Sumário de Clientes Atendidos / Não Atendidos
    </title>
  </head>
  <center>
    <body onload="if(document.forms[0].ordenacao.value=='0'){document.forms[0].select1_action.disabled=true;}else{document.forms[0].select1_action.disabled=false;};document.forms[0].cb_consulta_clientes.checked=true;document.forms[0].cb_consulta_grupos.checked=true;document.forms[0].cb_consulta_cidades.checked=true;document.forms[0].cb_saldo_limite_credito.checked=false;">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(58)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="adm/Clientes_atendidosForm.do" method="POST"  styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Resumo_ped"/>
                  </td>
                </tr>
              </table>
              <table class="itemTable" style='width:99%;'>

                <script>
                  jQuery(document).ready(function($) {
                    $("#dt_inicial").mask("99/99/9999");
                    $("#dt_final").mask("99/99/9999");
                    });
                  </script>

                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(58)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>

                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Data Inicial
                      </span>
                      <bean:message key="jsp.fieldnotnull"/>
                    </td>
                    <td class="formField">
                      <html:text property="dt_inicial" styleId="dt_inicial" styleClass="baseField" size="10" maxlength="10"/>

                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_inicial']); cal1.year_scroll = true; cal1.popup();">
                        <img src="../img/calendar.gif" width="16" height="16" border="0">
                      </a>
                    </td>
                  </tr>
                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Data Final
                      </span>
                      <bean:message key="jsp.fieldnotnull"/>
                    </td>
                    <td class="formField">
                      <html:text property="dt_final" styleId="dt_final" styleClass="baseField" size="10" maxlength="10"/>

                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_final']); cal1.year_scroll = true; cal1.popup();">
                        <img src="../img/calendar.gif" width="16" height="16" border="0">
                      </a>
                    </td>
                  </tr>
                  <%
                  String regional="";
                  String codigo_representante="";
                  String tipo="";
                  acesso.Usuario u = new acesso.Usuario();
                  u = (acesso.Usuario)session.getAttribute("User");
                  acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
                  acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
                  session.setAttribute("codigo_representante","null");
                  if(!(u.getEntidadeNegocio()==null)){
                    ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                    tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
                    tipo = tipoent.getTipo()+"";
                    if(tipo.equals("REGIONAL DE VENDA")){
                      regional = ent.getChave()+"";
                    }


                    if (tipo.equals("ANALISTA REGIONAL")) {
                      com.egen.util.jdbc.JdbcUtil ja = null;
                      try {
                        ja = new com.egen.util.jdbc.JdbcUtil();
                        portalbr.dbobj.view.Jw_regional_analista tablea = new portalbr.dbobj.view.Jw_regional_analista();
                        String[][] select = null;
                        Object[][] where = { {"codigo_gerente","=",ent.getChave()+""} };
                        Vector res_Jw_regional_analista = ja.select(tablea, select, where, null, null, null);
                        if (res_Jw_regional_analista != null && res_Jw_regional_analista.size() > 0) {
                          portalbr.dbobj.view.Jw_regional_analista r = (portalbr.dbobj.view.Jw_regional_analista) res_Jw_regional_analista.elementAt(0);
                          regional = r.getCodigo_regional();
                        }
                      }
                      finally {
                        if (ja != null) {
                          ja.close();
                          ja = null;
                        }
                      }
                    }





                    if((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))){
                      codigo_representante = ent.getChave()+"";
                      session.setAttribute("codigo_representante",codigo_representante);
                    }
                  }
                  %>
                  <%
                  if((regional.equals(""))&&(codigo_representante.equals(""))) {
                    %>
                    <tr>
                      <td class="formLabel">
                        <span class="spamFormLabel" >
                          Regional
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="codigo_regional" onblur="if(this.value=='')nome_regional.value='';" styleClass="baseField" size="3" maxlength="3"/>
                        <input type="button" tabindex="-1" class="lovButton" value="..." onclick="window.open('../lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=codigo_regional&return1=nome_regional','','scrollbars,height=510,width=600,top=100,left=180,')"/>
                        <%
                      }
                      %>
                      <%
                      if((regional.equals(""))&&(codigo_representante.equals(""))) {
                        %>
                        <span class="spamFormLabel" >
                        </span>
                        <html:text property="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="40"/>
                      </td>
                    </tr>
                    <%
                  }
                  %>
                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Marca
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="codigo_marca" onblur="if(this.value=='')descricao_marca.value='';" styleClass="baseField" size="3" maxlength="3"/>
                      <input type="button" tabindex="-1" class="lovButton" value="..." onclick="window.open('../lov/LvMarcaLov.do?resetfull_action=&returnBlock=0&return0=codigo_marca&return1=descricao_marca','','scrollbars,height=510,width=600,top=100,left=180,channelmode=no,directories=no,fullscreen=no,location=no,menubar=no,resizable=no,status=no,titlebar=no,toolbar=no,')"/>
                      <span class="spamFormLabel" >
                      </span>
                      <html:text property="descricao_marca" tabindex="-1" styleClass="disabled" readonly="true" size="30" maxlength="30"/>
                    </td>
                  </tr>
                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Linha
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="lin_cdgo" onblur="if(this.value=='')lin_nome.value='';" styleClass="baseField" size="6" maxlength="6"/>
                      <input type="button" tabindex="-1" class="lovButton" value="..." onclick="window.open('../lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_nome','','scrollbars,height=510,width=600,top=100,left=180,')"/>
                      <span class="spamFormLabel" >
                      </span>
                      <html:text property="lin_nome" tabindex="-1" styleClass="disabled" readonly="true" size="25"/>
                    </td>
                  </tr>
                  <%
                  if(codigo_representante.equals("")){
                    %>
                    <tr>
                      <td class="formLabel">
                        <span class="spamFormLabel" >
                          Tipo
                        </span>
                        <bean:message key="jsp.fieldnotnull"/>
                      </td>
                      <td class="formField">
                        <html:select property="ordenacao" onchange="refresh_action.click();" styleClass="baseField" size="1">
                          <html:option styleClass="baseOption" value="0">
                            ---Selecione---
                          </html:option>
                          <html:option styleClass="baseOption" value="1">
                            Por Regional
                          </html:option>
                          <html:option styleClass="baseOption" value="2">
                            Por Marca
                          </html:option>
                        </html:select>
                      </td>
                    </tr>
                    <tr>
                      <%
                    }else{
                      %>
                      <html:hidden property="ordenacao" value="9"/>
                      <%
                    }
                    %>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                      </span>
                    </td>
                    <td class="formField">
                      <html:checkbox property="check_rep" styleClass="myhidden" value="0"/>
                    </td>
                  </tr>
                  <%
                  portalbr.adm.Clientes_atendidosActionForm cliActionForm = (portalbr.adm.Clientes_atendidosActionForm) session.getAttribute("Clientes_atendidosActionForm");

                  String opcao = cliActionForm.getOrdenacao()+"";
                  String mar   = cliActionForm.getCheck_reg()+"";

                  if(opcao.equals("1")){
                    %>
                    <tr>
                      <td class="formLabel">
                        <span class="spamFormLabel" >
                          Lista Representante?
                        </span>
                      </td>
                      <td class="formField">
                        <html:checkbox property="check_rep" styleClass="baseField" value="1"/>
                      </td>
                    </tr>
                    <%}  if(opcao.equals("2")){ %>
                      <tr>
                        <td class="formLabel">
                          <span class="spamFormLabel" >
                            Lista Regionais?
                          </span>
                        </td>
                        <td class="formField">
                          <html:checkbox property="check_reg" onclick="refresh_action.click();" styleClass="baseField" value="1"/>
                        </td>
                      </tr>
                      <%
                      if(mar.equals("1")){
                        %>
                        <tr>
                          <td class="formLabel">
                            <span class="spamFormLabel" >
                              Lista Representante?
                            </span>
                          </td>
                          <td class="formField">
                            <html:checkbox property="check_mar" onclick="refresh_action.click();" styleClass="baseField" value="1"/>
                          </td>
                        </tr>
                        <%}    }         %>
                          <tr>
                            <td class="myhidden">
                              <span class="myhidden" >
                              </span>
                            </td>
                            <td class="formField">
                              <html:checkbox property="check_mar" styleClass="myhidden" value="0"/>
                            </td>
                          </tr>
                          <tr>
                            <td class="myhidden">
                              <span class="myhidden" >
                              </span>
                            </td>
                            <td class="formField">
                              <html:checkbox property="check_reg" styleClass="myhidden" value="0"/>
                            </td>
                          </tr>

                          <%
                          if((!opcao.equals("null"))&&(!(opcao.equals("0")))||
                          (!(codigo_representante.equals("")))){
                            %>
                            <tr>
                              <td class="formLabel">
                                <span class="spamFormLabel" >
                                </span>
                              </td>
                              <td class="formField">
                                <table border=1 style="border-color:#f4c5a2">
                                  <tr>
                                    <td align="center">
                                      <b>
                                        Situação
                                      </b>
                                      <br>
                                      <font color="white">
                                        ...
                                      </font>
                                      <b>
                                        Representante
                                      </b>
                                      <font color="white">
                                        ...
                                      </font>
                                    </td>
                                    <td align="center">
                                      <b>
                                        Situação
                                      </b>
                                      <br>
                                      <font color="white">
                                        ...
                                      </font>
                                      <b>
                                        Cliente/Representante
                                      </b>
                                      <font color="white">
                                        ...
                                      </font>
                                    </td>
                                    <td align="center">
                                      <b>
                                        Situação
                                      </b>
                                      <br>
                                      <font color="white">
                                        ...
                                      </font>
                                      <b>
                                        Representante/Marca
                                      </b>
                                      <font color="white">
                                        ...
                                      </font>
                                    </td>
                                  </tr>
                                  <tr>
                                    <td align="center">
                                      <html:select property="situacao_representante" styleClass="baseField">
                                        <html:option styleClass="baseOption" value="A">
                                          Ativo
                                        </html:option>
                                        <html:option styleClass="baseOption" value="I">
                                          Inativo
                                        </html:option>
                                        <html:option styleClass="baseOption" value="null">
                                          Todos
                                        </html:option>
                                      </html:select>
                                    </td>

                                    <td align="center">
                                      <html:select property="situacao_cliente_representante" styleClass="baseField">
                                        <html:option styleClass="baseOption" value="A">
                                          Ativo
                                        </html:option>
                                        <html:option styleClass="baseOption" value="I">
                                          Inativo
                                        </html:option>
                                        <html:option styleClass="baseOption" value="null">
                                          Todos
                                        </html:option>
                                      </html:select>
                                    </td>

                                    <td align="center">
                                      <html:select property="situacao_representante_marca" styleClass="baseField">
                                        <html:option styleClass="baseOption" value="A">
                                          Ativo
                                        </html:option>
                                        <html:option styleClass="baseOption" value="I">
                                          Inativo
                                        </html:option>
                                        <html:option styleClass="baseOption" value="null">
                                          Todos
                                        </html:option>
                                      </html:select>
                                    </td>
                                  </tr>
                                </table>
                                <br>
                                <table border=1 style="border-color:#f4c5a2">
                                  <tr>
                                    <td align="center" colspan=6>
                                      <b>
                                        Visualizar
                                      </b>
                                    </td>
                                  </tr>

                                  <tr>
                                    <td align="center">
                                      <font color="white">
                                        ...
                                      </font>
                                      Clientes
                                      <font color="white">
                                        ...
                                      </font>
                                    </td>
                                    <td align="center">
                                      <font color="white">
                                        ...
                                      </font>
                                      Grupos
                                      <font color="white">
                                        ...
                                      </font>
                                    </td>
                                    <td align="center">
                                      <font color="white">
                                        ...
                                      </font>
                                      Cidades
                                      <font color="white">
                                        ...
                                      </font>
                                    </td>
                                    <td align="center">
                                      <font color="white">
                                        ...
                                      </font>
                                      Saldo/Limite de Crédito
                                      <font color="white">
                                        ...
                                      </font>
                                    </td>
                                    <td align="center">
                                      <font color="white">
                                        ...
                                      </font>
                                      Segmento/Limite Crédito
                                      <font color="white">
                                        ...
                                      </font>
                                    </td>
                                    <td align="center">
                                      <font color="white">
                                        ...
                                      </font>
                                      Regionais/Limite Crédito
                                      <font color="white">
                                        ...
                                      </font>
                                    </td>
                                  </tr>
                                  <tr>
                                    <td align="center">
                                      <html:checkbox property="cb_consulta_clientes" styleClass="baseField" value="S"/>
                                    </td>
                                    <td align="center">
                                      <html:checkbox property="cb_consulta_grupos" styleClass="baseField" value="S"/>
                                    </td>
                                    <td align="center">
                                      <html:checkbox property="cb_consulta_cidades" styleClass="baseField" value="S"/>
                                    </td>
                                    <td align="center">
                                      <html:checkbox property="cb_saldo_limite_credito" styleClass="baseField" value="S"/>
                                    </td>
                                    <td align="center">
                                      <html:checkbox property="cb_consulta_segmentos" styleClass="baseField" value="S"/>
                                    </td>
                                    <td align="center">
                                      <html:checkbox property="cb_consulta_regionais" styleClass="baseField" value="S"/>
                                    </td>
                                  </tr>
                                </table>

                              </td>
                            </tr>

                          </table>
                          <%
                        } else {
                          %>

                          <html:checkbox property="cb_consulta_cidades" styleClass="myhidden" value="N"/>
                          <html:checkbox property="cb_consulta_clientes" styleClass="myhidden" value="N"/>
                          <html:checkbox property="cb_consulta_grupos" styleClass="myhidden" value="N"/>

                          <%
                        }
                        %>
                        <html:hidden property="reg" value="<%= regional %>"/>
                        <html:hidden property="representante" value="<%= codigo_representante %>"/>

                        <table class="buttonTable" style='width:99%;'>
                          <tr class="buttonTr">
                            <td class="buttonTd">
                              <html:button accesskey="p" onclick="bloqueia();this.disabled=true;resetfull1_action.disabled=true;select_action.click();" styleClass="baseButton" property="select1_action">
                                <bean:message bundle="ApplicationResources" key="jsp.select"/>
                              </html:button>
                              <html:button accesskey="r" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                                <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                              </html:button>

                              <html:submit styleClass="myhidden" property="select_action">
                                <bean:message bundle="ApplicationResources" key="jsp.select"/>
                              </html:submit>
                              <html:submit  styleClass="myhidden" property="resetfull_action">
                                <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                              </html:submit>
                              <html:submit styleClass="myhidden" property="refresh_action">
                                <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
                              </html:submit>
                            </td>
                          </tr>
                        </table>
                      </html:form>

                      <script type="text/javascript" language="JavaScript">
                        <!--
                        var focusControl = document.forms[0].elements["dt_inicial"];
                        if (focusControl.type != "hidden") {
                          focusControl.focus();
                        }
                      // -->
                      </script>



                      <script>
                        function getKeySite(keyStroke) {
                          isNetscape=(document.layers);
                          eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                          which = String.fromCharCode(eventChooser).toLowerCase();
                          keyBuffer = which;
                          if(eventChooser == 13){
                            if(document.forms[0].select1_action.disabled==true){
                              return false;
                            }
                            document.forms[0].select1_action.disabled=true;
                            document.forms[0].resetfull1_action.disabled=true;
                            bloqueia();
                            document.forms[0].select_action.click();
                          }
                        }
                      </script>
                      <SCRIPT>
                        document.onkeypress = getKeySite;
                      </SCRIPT>



                      <table class="footerTable" style="width:99%" >
                        <tr>

                          <td>

                          </td>

                        </tr>

                      </table>

                    </td>
                  </tr>
                </table>

              </body>
            </center>
          </html>

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/AcompanhamentoDiarioVendasActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = AcompanhamentoDiarioVendasActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("codigo_marca","Marca");
    hashMapLabel.set("descricao_marca","");
    hashMapLabel.set("f_regionali","");
    hashMapLabel.set("codigo_regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("f_regionalf","");
    hashMapLabel.set("f_repi","");
    hashMapLabel.set("rep_cdgo","ERC");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("f_repf","");
    hashMapLabel.set("situacao_representantes","Situação ERC");
    hashMapLabel.set("data_inicial","Período ano atual de");
    hashMapLabel.set("data_final"," a ");
    hashMapLabel.set("data_anterior_inicial","Período ano anterior de");
    hashMapLabel.set("data_anterior_final"," a");
    hashMapLabel.set("cb_somente_marcas_ativas","Somente Marcas Ativas");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Acompanhamento Diário de Vendas
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(31)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/AcompanhamentoDiarioVendasForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="descricao_marca"/>
                    <html:errors property="codigo_regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="situacao_representantes"/>
                    <html:errors property="data_inicial"/>
                    <html:errors property="data_final"/>
                    <html:errors property="data_anterior_inicial"/>
                    <html:errors property="data_anterior_final"/>
                    <html:errors property="cb_somente_marcas_ativas"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_acompanhamento_diario_vendas"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String diaInicial = "";
                String diaFinal = "";
                String diaInicialAnterior = "";
                String diaFinalAnterior = "";
                String codigoRegional = null;
                String codigoRepresentante = null;
                acesso.Sessao sessao = new acesso.Sessao(session);
                if(sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")){
                  codigoRepresentante = sessao.getChave();
                }
                if(sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")){
                  codigoRepresentante = sessao.getChave();
                }
                if(sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")){
                  codigoRegional = sessao.getChave();
                }
                if(sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")){
                  com.egen.util.jdbc.JdbcUtil j = null;
                  try {
                    j = new com.egen.util.jdbc.JdbcUtil();
                    portalbr.dbobj.view.Jw_regional_analista table = new portalbr.dbobj.view.Jw_regional_analista();
                    String[][] select = null;
                    Object[][] where = {{"codigo_gerente","=", sessao.getChave()} };
                    Vector res_Jw_regional_analista = j.select(table, select, where, null, null, null);
                    if (res_Jw_regional_analista != null && res_Jw_regional_analista.size() > 0) {
                      portalbr.dbobj.view.Jw_regional_analista r = (portalbr.dbobj.view.Jw_regional_analista) res_Jw_regional_analista.elementAt(0);
                      codigoRegional = r.getCodigo_regional();
                    }
                  } finally {
                    if(j!=null) {
                      j.close();
                      j = null;
                    }
                  }
                }
                %>



                <%
                if(sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")||
                sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")){
                  java.sql.PreparedStatement pstm = null;
                  java.sql.ResultSet rset = null;
                  com.egen.util.jdbc.JdbcUtil j = null;
                  try {
                    j = new com.egen.util.jdbc.JdbcUtil();
                    StringBuilder query = new StringBuilder();
                    query.append(" SELECT to_char(TRUNC(SYSDATE, 'mm'),'dd/mm/yyyy') dia_inicial ");
                    query.append("      , to_char(TRUNC(LAST_DAY(SYSDATE)),'dd/mm/yyyy') ultimo_dia ");
                    query.append("      , to_char(ADD_MONTHS(TRUNC(SYSDATE, 'mm'), -12),'dd/mm/yyyy') dia_inicial_anterior ");
                    query.append("      , to_char(ADD_MONTHS(TRUNC(LAST_DAY(SYSDATE)), -12),'dd/mm/yyyy') ultimo_dia_anterior ");
                    query.append("   FROM dual ");
                    pstm = j.getConn().prepareStatement(query.toString());
                    rset = pstm.executeQuery();
                    if (rset.next()) {
                      diaInicial = rset.getString("dia_inicial");
                      diaFinal = rset.getString("ultimo_dia");
                      diaInicialAnterior = rset.getString("dia_inicial_anterior");
                      diaFinalAnterior = rset.getString("ultimo_dia_anterior");
                    }
                  } catch (Exception e) {
                    e.printStackTrace();
                  } finally {
                    try {
                      if (rset != null) {
                        rset.close();
                      }
                    } catch (Exception e) {
                    }
                    try {
                      if (pstm != null) {
                        pstm.close();
                      }
                    } catch (Exception e) {
                    }
                    if (j != null) {
                      j.close();
                    }
                  }
                }
                %>






                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_marca" styleId="codigo_marca" onblur="fillFields(0,new Array('codigo_marca'),'AcompanhamentoDiarioVendasActionForm.getDescricao_marca_Ajax',new Array('descricao_marca'));" styleClass="baseField" size="3"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_marca()"  >
                    <script type="text/javascript">
                      function lov_open_codigo_marca() {
                        window.open('..//lov/LvMarcaLov.do?resetfull_action=&returnBlock=0&return0=codigo_marca&return1=descricao_marca','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="descricao_marca" styleId="descricao_marca" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                  </td>
                </tr>

                <%
                if(codigoRegional == null && codigoRepresentante == null) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Regional
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="codigo_regional" styleId="codigo_regional" onblur="fillFields(0,new Array('codigo_regional'),'AcompanhamentoDiarioVendasActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="baseField" size="3" maxlength="3"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_regional()"  >
                      <script type="text/javascript">
                        function lov_open_codigo_regional() {
                          window.open('..//lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=codigo_regional&return1=nome_regional','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="codigo_regional" value="<%= codigoRegional %>" />
                  <html:hidden property="nome_regional" />

                  <%
                }
                %>
                <%
                if(codigoRepresentante == null){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        ERC
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="rep_cdgo" styleId="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'AcompanhamentoDiarioVendasActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="5" maxlength="5"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_rep_cdgo() {
                          window.open('..//lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="rep_cdgo" value="<%= codigoRepresentante %>" />
                  <html:hidden property="rep_rzao" />

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situação ERC
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="situacao_representantes" styleId="situacao_representantes" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="T">
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
                      Período ano atual de
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <%
                    if(!diaInicial.equals("")){
                      %>
                      <html:text property="data_inicial" value="<%= diaInicial %>" styleId="data_inicial" styleClass="baseField" size="10" maxlength="10"/>
                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_inicial']); cal1.year_scroll = true; cal1.popup();">
                        <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                      </a>
                      <%
                    } else {
                      %>
                      <html:text property="data_inicial" styleId="data_inicial" styleClass="baseField" size="10" maxlength="10"/>
                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_inicial']); cal1.year_scroll = true; cal1.popup();">
                        <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                      </a>
                      <%
                    }
                    %>
                    <span class="spamFormLabel">
                      a
                    </span>
                    <%
                    if(!diaInicial.equals("")) {
                      %>

                      <html:text property="data_final" value="<%= diaFinal %>" styleId="data_final" styleClass="baseField" size="10" maxlength="10"/>
                       
                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_final']); cal1.year_scroll = true; cal1.popup();">
                        <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                      </a>

                      <%
                    } else {
                      %>

                      <html:text property="data_final" styleId="data_final" styleClass="baseField" size="10" maxlength="10"/>
                       
                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_final']); cal1.year_scroll = true; cal1.popup();">
                        <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                      </a>

                      <%
                    }
                    %>

                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Período ano anterior de
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <%
                    if(!diaInicial.equals("")) {
                      %>
                      <html:text property="data_anterior_inicial" value="<%= diaInicialAnterior %>" styleId="data_anterior_inicial" styleClass="baseField" size="10" maxlength="10"/>
                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_anterior_inicial']); cal1.year_scroll = true; cal1.popup();">
                        <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                      </a>
                      <%
                    } else {
                      %>
                      <html:text property="data_anterior_inicial" styleId="data_anterior_inicial" styleClass="baseField" size="10" maxlength="10"/>
                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_anterior_inicial']); cal1.year_scroll = true; cal1.popup();">
                        <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                      </a>
                      <%
                    }
                    %>
                    <span class="spamFormLabel">
                      a
                    </span>

                    <%
                    if(!diaInicial.equals("")){
                      %>

                      <html:text property="data_anterior_final" value="<%= diaFinalAnterior %>" styleId="data_anterior_final" styleClass="baseField" size="10" maxlength="10"/>
                       
                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_anterior_final']); cal1.year_scroll = true; cal1.popup();">
                        <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                      </a>
                      <%
                    } else {
                      %>

                      <html:text property="data_anterior_final" styleId="data_anterior_final" styleClass="baseField" size="10" maxlength="10"/>
                       
                      <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_anterior_final']); cal1.year_scroll = true; cal1.popup();">
                        <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                      </a>

                      <%
                    }
                    %>

                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Somente Marcas Ativas
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_somente_marcas_ativas" styleId="cb_somente_marcas_ativas" styleClass="baseField" value="S"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="r" styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
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
                  </td>
                  </tr>
                  </table>

                  <script type="text/javascript">
                  jQuery(document).ready(function($) {
                    $("#data_inicial").mask("99/99/9999");
                    $("#data_final").mask("99/99/9999");
                    $("#data_anterior_inicial").mask("99/99/9999");
                    $("#data_anterior_final").mask("99/99/9999");
                    });
                  </script>
                </html:form>
                <script type="text/javascript">
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

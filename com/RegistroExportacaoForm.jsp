<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/RegistroExportacaoActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = RegistroExportacaoActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("emp_empresa","Empresa<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("emp_razsoc","");
    hashMapLabel.set("fil_filial","Filial");
    hashMapLabel.set("fil_razsoc","");
    hashMapLabel.set("codigo_pessoa","Despachante");
    hashMapLabel.set("nome_pessoa","");
    hashMapLabel.set("ano_fatura","Ano Fatura<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("numero_fatura","Número Fatura<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("nro_drawback","Nro. Drawback<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("data_averbacao_inicial","Período Averbação de<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("data_averbacao_final","a");
    hashMapLabel.set("data_re_inicial","Período RE de<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("data_re_final","a");
    hashMapLabel.set("gerar_planilha","Gerar Planilha");
    hashMapLabel.set("f_excel","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Registros de Exportação (RE / NCM)
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(271)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/RegistroExportacaoForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <div class\='div10l'>
                        A fatura ou o período devem ser informados.
                      </div>
                    </div>
                    <html:errors property="emp_empresa"/>
                    <html:errors property="emp_razsoc"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="fil_razsoc"/>
                    <html:errors property="codigo_pessoa"/>
                    <html:errors property="nome_pessoa"/>
                    <html:errors property="ano_fatura"/>
                    <html:errors property="numero_fatura"/>
                    <html:errors property="nro_drawback"/>
                    <html:errors property="data_averbacao_inicial"/>
                    <html:errors property="data_averbacao_final"/>
                    <html:errors property="data_re_inicial"/>
                    <html:errors property="data_re_final"/>
                    <html:errors property="gerar_planilha"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_registros_exportacao"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Empresa
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="emp_empresa" styleId="emp_empresa" onblur="fillFields(0,new Array('emp_empresa'),'RegistroExportacaoActionForm.getEmp_razsoc_Ajax',new Array('emp_razsoc'));" styleClass="baseField" size="3"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_emp_empresa()"  >
                    <script type="text/javascript">
                      function lov_open_emp_empresa() {
                        window.open('..//lov/LvEmpresaLov.do?resetfull_action=&returnBlock=0&return0=emp_empresa&return1=emp_razsoc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="emp_razsoc" styleId="emp_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="60"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Filial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fil_filial" styleId="fil_filial" onblur="fillFields(0,new Array('fil_filial','emp_empresa'),'RegistroExportacaoActionForm.getFil_razsoc_Ajax',new Array('fil_razsoc'));" styleClass="baseField" size="4"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fil_filial()"  >
                    <script type="text/javascript">
                      function lov_open_fil_filial() {
                        window.open('..//lov/LvFilialLov.do?resetfull_action=&returnBlock=0&return0=fil_filial&return1=fil_razsoc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="fil_razsoc" styleId="fil_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="55" maxlength="50"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Despachante
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_pessoa" styleId="codigo_pessoa" onblur="fillFields(0,new Array('codigo_pessoa'),'RegistroExportacaoActionForm.getNome_pessoa_Ajax',new Array('nome_pessoa'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_pessoa()"  >
                    <script type="text/javascript">
                      function lov_open_codigo_pessoa() {
                        window.open('..//lov/LvDespachanteLov.do?resetfull_action=&returnBlock=0&return0=codigo_pessoa&return1=nome_pessoa','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="nome_pessoa" styleId="nome_pessoa" styleClass="disabled" tabindex="-1" readonly="true" size="80"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Ano Fatura
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ano_fatura" styleId="ano_fatura" styleClass="baseField" size="5"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Número Fatura
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="numero_fatura" styleId="numero_fatura" styleClass="baseField" size="5"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nro. Drawback
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="nro_drawback" styleId="nro_drawback" styleClass="baseField" size="11"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Período Averbação de
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_averbacao_inicial" styleId="data_averbacao_inicial" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_averbacao_inicial']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                      a
                    </span>
                    <html:text property="data_averbacao_final" styleId="data_averbacao_final" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_averbacao_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Período RE de
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_re_inicial" styleId="data_re_inicial" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_re_inicial']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                      a
                    </span>
                    <html:text property="data_re_final" styleId="data_re_final" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_re_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Gerar Planilha
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="gerar_planilha" styleId="gerar_planilha" styleClass="baseField" value="1"/>
                  </td>
                </tr>

                <%
                if(session.getAttribute("arquivo")!=null){
                  %>
                  <table style=width:100%;margin-top:10;>
                    <tr>
                      <td class=columHeader style="text-align:center;">
                        <a href="<%= (String)session.getAttribute("arquivo") %>" target="_blank">
                          <bean:message key="report.downloadxls"/>
                        </a>
                      </td>
                    </tr>
                  </table>
                  <%
                }
                session.removeAttribute("arquivo");
                %>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="p" onclick="resetfull1_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
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

                    <script type="text/javascript">
                    jQuery(document).ready(function($) {
                      $("#data_averbacao_inicial").mask("99/99/9999");
                      $("#data_averbacao_final").mask("99/99/9999");
                      $("#data_re_inicial").mask("99/99/9999");
                      $("#data_re_final").mask("99/99/9999");
                      });
                    </script>
                  </html:form>
                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["emp_empresa"];
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ComparativoVendasActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ComparativoVendasActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("dt_inicial","Data Inicial");
    hashMapLabel.set("dt_final","Data Final");
    hashMapLabel.set("codigo_marca","Marca");
    hashMapLabel.set("descricao_marca","");
    hashMapLabel.set("p_clientes","Clientes");
    hashMapLabel.set("p_grupos","Grupos");
    hashMapLabel.set("abre_automaticamente","Abre o Relatório Automaticamente");
    hashMapLabel.set("mensagem","");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Comparativo de Vendas
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(123)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ComparativoVendasForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <div class\='div10l'>
                        Um dos campos com
                        <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        deve ser preenchido.
                      </div>
                      <div class\='div10l'>
                        Todos os campos com
                        <img src='../img/required.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        devem ser preenchidos.
                      </div>
                    </div>
                    <html:errors property="dt_inicial"/>
                    <html:errors property="dt_final"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="descricao_marca"/>
                    <html:errors property="p_clientes"/>
                    <html:errors property="p_grupos"/>
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
                      Data Inicial
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="dt_inicial" styleId="dt_inicial" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_inicial']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
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
                    <html:text property="dt_final" styleId="dt_final" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_marca" onblur="fillFields(0,new Array('codigo_marca'),'ComparativoVendasActionForm.getDescricao_marca_Ajax',new Array('descricao_marca'));" styleClass="baseField" size="3" maxlength="3"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_marca()"  >
                    <script type="text/javascript">
                      function lov_open_codigo_marca() {
                        window.open('../lov/LvMarcaLov.do?resetfull_action=&returnBlock=0&return0=codigo_marca&return1=descricao_marca','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="descricao_marca" styleId="descricao_marca" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="30"/>
                  </td>
                </tr>

                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Cliente(s)
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="p_clientes" styleClass="baseField"/>
                    <span class='validateMessageuser'>
                      Obs: Clientes separados por vírgula
                    </span>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Grupo(s)
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="p_grupos" styleClass="baseField"/>
                    <span class='validateMessageuser'>
                      Obs: Grupos separados por vírgula
                    </span>
                  </td>
                </tr>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Abre o Relatório Automaticamente
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="abre_automaticamente" onclick="if(this.checked==true){mensagem.value='Obs.: Uma nova janela será aberta para a visualização do relatório.';}else{mensagem.value='';}" styleClass="baseField" value="checked"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="mensagem" style="background-color:transparent; border-style:none; color:red; background-color:transparent; border-style:none; cursor:default; text-align:start;" styleClass="baseField" tabindex="-1" readonly="true" size="70"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
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

                      <script type="text/javascript">
                      jQuery(document).ready(function($) {
                        $("#dt_inicial").mask("99/99/9999");
                        $("#dt_final").mask("99/99/9999");
                        });
                      </script>
                    </html:form>
                    <script type="text/javascript">
                      var focusControl = document.forms[0].elements["dt_inicial"];
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

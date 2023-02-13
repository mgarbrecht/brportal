<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/PedidosShowRoomActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = PedidosShowRoomActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("id_showroom","Showroom");
    hashMapLabel.set("codigo_regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("dt_periodo_ini","Data Inicial");
    hashMapLabel.set("dt_periodo_fim","Data Final");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Informe de Pedidos em Show Room
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(190)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/PedidosShowRoomForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="id_showroom"/>
                    <html:errors property="codigo_regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="dt_periodo_ini"/>
                    <html:errors property="dt_periodo_fim"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_mkt_showroom"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Showroom
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="id_showroom" styleId="id_showroom" styleClass="baseField" size="5" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Regional
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_regional" styleId="codigo_regional" onblur="fillFields(0,new Array('codigo_regional'),'PedidosShowRoomActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="baseField" size="5" maxlength="22"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_regional()"  >
                    <script type="text/javascript">
                      function lov_open_codigo_regional() {
                        window.open('..//lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=codigo_regional&return1=nome_regional','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="60" maxlength="100"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Inicial
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="dt_periodo_ini" styleId="dt_periodo_ini" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_periodo_ini']); cal1.year_scroll = true; cal1.popup();">
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
                    <html:text property="dt_periodo_fim" styleId="dt_periodo_fim" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_periodo_fim']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="baseButton" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

              <script type="text/javascript">
                jQuery(document).ready(function($) {
                  $("#dt_periodo_ini").mask("99/99/9999");
                  $("#dt_periodo_fim").mask("99/99/9999");
                  });
                </script>
              </html:form>
              <script type="text/javascript">
                var focusControl = document.forms[0].elements["id_showroom"];
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

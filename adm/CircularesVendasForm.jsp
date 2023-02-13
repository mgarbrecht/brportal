<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Circulares Beira Rio
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(64)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="adm/CircularesVendasForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="numero"/>
                    <html:errors property="data"/>
                    <html:errors property="remetente"/>
                    <html:errors property="assunto"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Circulares_vendas"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Número
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="numero" styleClass="baseField" size="7" maxlength="7"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data" styleId="data" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Remetente
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="remetente" styleClass="baseField" size="20" maxlength="20"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Assunto
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="assunto" styleClass="baseField" size="30" maxlength="30"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="p" onclick="insert1_action.disabled=true;resetfull1_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
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
                        document.forms[0].insert1_action.disabled=true;
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
                    <html:button accesskey="i" value="Cadastrar Nova Circular" onclick="insert_action.click();" styleClass="baseButton" property="insert1_action">
                    </html:button>
                    <html:submit styleClass="myhidden" property="select_action">
                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit styleClass="myhidden" property="resetfull_action">
                    <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit value="Cadastrar Nova Circular" styleClass="myhidden" property="insert_action">
                    </html:submit>
                    </td>
                    </tr>
                    </table>

                    <script type="text/javascript">
                    jQuery(document).ready(function($) {
                      $("#data").mask("99/99/9999");
                      });
                    </script>
                  </html:form>
                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["numero"];
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

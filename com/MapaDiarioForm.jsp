<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/MapaDiarioActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = MapaDiarioActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("f_reg_i","");
    hashMapLabel.set("codigo_regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("f_reg_f","");
    hashMapLabel.set("data","Data");
    hashMapLabel.set("abre_automaticamente","Abre o Relatório Automaticamente");
    hashMapLabel.set("mensagem","");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Mapa Diário
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(161)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/MapaDiarioForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="codigo_regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="data"/>
                    <html:errors property="abre_automaticamente"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                util.consultas.Query query = new util.consultas.Query();
                String dataAtual = null;
                String chave = null;
                acesso.Sessao se = new acesso.Sessao(session);
                String tipo = se.getTipoEntidadeNegocio();
                if(tipo.equals("REGIONAL DE VENDA")){
                  chave = se.getChave();
                }
                dataAtual = query.retorna("SELECT to_char(sysdate,'dd/mm/yyyy') FROM dual");
                %>
                <%
                if(chave==null) {
                  %>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Regional
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="codigo_regional" styleId="codigo_regional" onblur="fillFields(0,new Array('codigo_regional'),'MapaDiarioActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="baseField" size="3" maxlength="3"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_regional()"  >
                      <script type="text/javascript">
                        function lov_open_codigo_regional() {
                          window.open('..//lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=codigo_regional&return1=nome_regional','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="40"/>
                    </td>
                  </tr>

                  <script>
                    //   document.forms[0].codigo_regional.focus();
                  </script>
                  <%
                } else {
                  %>
                  <html:hidden property="codigo_regional" value="<%= chave %>"/>
                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="data" styleId="data" styleClass="baseField" value="<%= dataAtual %>" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Abre o Relatório Automaticamente
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="abre_automaticamente" styleId="abre_automaticamente" styleClass="baseField" value="checked"/>
                    <html:hidden property="mensagem"/>
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
                        <html:button accesskey="p" onclick="resetfull1_action.disabled=true;bloqueia();this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
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
                            bloqueia();
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
                          $("#data").mask("99/99/9999");
                          });
                        </script>
                      </html:form>
                    </td>
                  </tr>
                </table>

              </body>
            </center>
          </html>

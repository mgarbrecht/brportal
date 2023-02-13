<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Solicitação de Cadastro
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
                </td>

              </tr>

            </table>

            <html:form action="acesso/SolicitacaoUsuarioForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>

              </table>

              <table class="itemTable" border="0"  style="width:99%;">
                <tr class="messageTr" >
                  <td class="messageTd" >
                    <bean:message key="div.campos*"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formField">
                    <br/>
                    CNPJ
                    <bean:message key="jsp.fieldnotnull"/>
                    <br/>
                    <html:text property="cnpj" styleId="cnpj" styleClass="baseField" size="15" maxlength="14"/>
                    <br/>
                    <br/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formField">
                    <span class="spamFormLabel">
                      E-Mail
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                    <br/>
                    <html:text property="email" styleId="email" styleClass="baseField" size="60"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formField">
                    <%
                    if(session.getAttribute("mensagem_erro")!=null){
                      %>
                      <html:hidden property="sucesso" />
                      <br/>
                      <div style="border-color: red; text-align: center; background-color: #d30000; color: white; font-size: 12px; font-weight: bold; height: 35px">
                        <%= (String)session.getAttribute("mensagem_erro") %>
                      </div>
                      <br/>
                    </td>
                    <%
                  }
                  session.removeAttribute("mensagem_erro");
                  %>
                  <%
                  if(session.getAttribute("mensagem_sucesso")!=null){
                    %>
                    <html:hidden property="sucesso" />
                    <br/>
                    <div style="border-color: green; text-align: center; background-color: #008c46; color: white; font-size: 12px; font-weight: bold; height: 35px">
                      <%= (String)session.getAttribute("mensagem_sucesso") %>
                    </div>
                    <br/>
                  </td>

                  <%
                }
                session.removeAttribute("mensagem_sucesso");
                %>
              </td>
            </tr>

            <!--
              </table>
            -->
            <!--
              <table class="buttonTable" style='width:99%;'>
            -->
            <tr class="buttonTr">
              <td class="buttonTd">
                <br/>

                <html:button accesskey="p" onclick="resetfull1_action.disabled=true;this.disabled=true;document.forms[0].criar_acesso_action.click();" styleClass="baseButton" property="criar_acesso1_action">
                  Criar meu acesso
                </html:button>
                <script>
                  function getKeySite(keyStroke) {
                    isNetscape=(document.layers);
                    eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                    which = String.fromCharCode(eventChooser).toLowerCase();
                    keyBuffer = which;
                    if(eventChooser == 13){
                    if(document.forms[0].criar_acesso1_action.disabled==true){return false;}
                    document.forms[0].criar_acesso1_action.disabled=true;
                    document.forms[0].resetfull1_action.disabled=true;
                    document.forms[0].criar_acesso_action.click();
                  }
                }
              </script>
              <SCRIPT>
                document.onkeypress = getKeySite;
                </SCRIPT>
                <html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                </html:button>
                <html:submit value="Criar meu acesso" styleClass="myhidden" property="criar_acesso_action">
                </html:submit>
                <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                </html:submit>
                <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                <bean:message bundle="ApplicationResources" key="jsp.close"/>
                </html:button>
                </td>
                </tr>
                </table>

                </html:form>
                <script type="text/javascript">
                var focusControl = document.forms[0].elements["cnpj"];
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

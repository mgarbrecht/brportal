<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Mapa Diário - Upload de Arquivos
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(188)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/UploadMapaDiarioForm.do" enctype="multipart/form-data" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="observacao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Arquivo
                    </span>
                  </td>
                  <td class="formField">
                    <html:file property="arquivo" styleClass="baseField">
                    </html:file>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Obs:
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="observacao" styleId="observacao" styleClass="disabled" tabindex="-1" readonly="true" value="O nome do arquivo deve seguir o padrão : MapaDiario_01062011_COM_RS.pdf" size="80"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button value="Upload" accesskey="u" onclick="upload1_action.disabled=true;resetfull1_action.disabled=true;this.disabled=true;document.forms[0].upload_action.click();" styleClass="baseButton" property="upload1_action">
                    </html:button>
                    <script>
                      function getKeySite(keyStroke) {
                        isNetscape=(document.layers);
                        eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                        which = String.fromCharCode(eventChooser).toLowerCase();
                        keyBuffer = which;
                        if(eventChooser == 13){
                          if(document.forms[0].upload1_action.disabled==true){
                            return false;
                          }
                          document.forms[0].upload1_action.disabled=true;
                          document.forms[0].resetfull1_action.disabled=true;
                          document.forms[0].upload_action.click();
                        }
                      }
                    </script>
                    <SCRIPT>
                      document.onkeypress = getKeySite;
                      </SCRIPT>
                      <html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:button>
                      <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:submit>
                      <html:submit value="Upload" styleClass="myhidden" property="upload_action">
                      </html:submit>
                      </td>
                      </tr>
                      </table>

                      </html:form>
                      <script type="text/javascript">
                      var focusControl = document.forms[0].elements["arquivo"];
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

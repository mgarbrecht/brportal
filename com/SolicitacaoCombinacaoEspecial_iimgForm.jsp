<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:100%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="com/SolicitacaoCombinacaoEspecial_iimgForm.do" enctype="multipart/form-data" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:100%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="descricao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial_img"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:100%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Imagem
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:file property="imagem" styleId="imagem" styleClass="baseField">
                    </html:file>
                  </td>
                </tr>

                <html:hidden property="id_solicitacao"/>
                <html:hidden property="id_imagem"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>
                  <td class="formField">
                    <html:textarea property="descricao" styleId="descricao" styleClass="baseField" cols="50" rows="2"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:100%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit value="Enviar Imagem" onclick="opener.document.forms[0].refresh_action.click();" styleClass="baseButton" property="upload_action">
                    </html:submit>
                    <html:button accesskey="f" onclick="opener.document.forms[0].refresh_action.click();javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                  </td>
                </tr>
              </table>

            </html:form>
          </td>
        </tr>
      </table>

    </body>
  </center>
</html>

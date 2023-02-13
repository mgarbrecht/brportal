<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:800px;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="com/SolicitacaoCombinacaoEspecial_imgForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:800px;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:800px;">
                <html:hidden property="id_solicitacao"/>
                <html:hidden property="id_imagem"/>
                <%
                portalbr.com.SolicitacaoCombinacaoEspecial_imgActionForm solicitacaoActionForm = (portalbr.com.SolicitacaoCombinacaoEspecial_imgActionForm)session.getAttribute("SolicitacaoCombinacaoEspecial_imgActionForm");
                %>

                <img src="http://brportal.beirario.com.br/brportal/arquivos/solicitacao_especial/<%= solicitacaoActionForm.getImagem()%> " />
                <html:hidden property="descricao_imagem"/>
              </table>

              <table class="buttonTable" style='width:800px;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
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

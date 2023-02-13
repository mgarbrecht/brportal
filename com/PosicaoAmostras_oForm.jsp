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
            <html:form action="com/PosicaoAmostras_oForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:100%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="observacao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Ped_amostra_situacoes_estagios"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:100%;">
                <%
                if(((String)session.getAttribute("fechar")+"").equalsIgnoreCase("S")){
                  session.removeAttribute("fechar");
                  %>
                  <script>
                    parent.tb_remove();
                  </script>
                  <%
                }
                %>
                <html:hidden property="ped_nmro" styleId="ped_nmro"/>
                <html:hidden property="id_situacao"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Observação Atendente
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:textarea property="observacao" styleId="observacao" styleClass="baseField" cols="60" rows="10"/>
                  </td>
                </tr>

                <html:hidden property="posicao"/>
              </table>

              <table class="buttonTable" style='width:100%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="i" value="Salvar Observação" styleClass="baseButton" property="insert_action">
                    </html:submit>
                    <html:button accesskey="f" onclick="parent.tb_remove();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                  </td>
                </tr>
              </table>

              <script type="text/javascript">
                jQuery("#observacao").focus();

                if(jQuery("#observacao").val()!=""){
                  parent.atualizaobservacao(jQuery("#ped_nmro").val(), jQuery("#observacao").val());
                }
              </script>
            </html:form>
          </td>
        </tr>
      </table>

    </body>
  </center>
</html>

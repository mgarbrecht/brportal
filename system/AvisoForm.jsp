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
            <%
            acesso.Sessao sessao = new acesso.Sessao(session);
            %>

            <html:form action="system/AvisoForm.do" method="post" styleClass="baseForm">

              <table style="width:100%;">

                <tr>
                  <td>
                    <center>
                      <img src="../img/logo_beira_rio_aviso.jpg" />
                      <big>
                        <br>
                        <br>
                        <div style="font-size:16px;font-weight:bold">
                          Cartilha de relacionamento com o fornecedor
                        </div>
                        <br>
                        - Nossos pagamentos são efetuados via depósito, nas terças e sextas de cada semana, preferencialmente nos bancos Bradesco, Brasil, Banrisul e Caixa Econômica Federal.
                        <br>
                        <br>
                        - Os dados bancários devem estar devidamente atualizados com o CNPJ do fornecedor conforme a nota de venda ou de serviço.
                        <br>
                        <br>
                        - É vedado ao fornecedor da Calçados Beira Rio S.A. dar em garantia a bancos, instituições financeiras ou terceiros as faturas, duplicatas ou boletos bancários emitidos.
                        <br>
                      </br>
                      - Caso o pagamento não seja localizado no prazo acordado, entrar em contato diretamente com o comprador ou setor fiscal para qual a nota foi faturada e, se ainda necessário, com o setor de contas a pagar pelo fone:
                      <b>
                        51 3584-2200
                      </b>
                      ou e-mail
                      <b>
                        contasapagar@beirario.com.br
                      </b>
                    </big>
                  </center>
                </td>
              </tr>
            </table>

            <!--
              <table class="itemTable" style="width:100%;"> <tr class="itemTr"> <td class="formLabel"> <span class="spamFormLabel"> </span> </td> <td class="formField"> <html:checkbox property="aceito" styleId="aceito" styleClass="baseField" value="1"/> <span class='validateMessageuser'> Li e concordo com as condições acima. </span> </td> </tr> </table>
            -->
            <br>

            <table  style='width:100%;'>
              <tr align="center">
                <td class="buttonTd" align="center">
                  <div align="center">
                    <!--
                      <html:button accesskey="f" onclick="if(jQuery('#aceito').attr('checked')){parent.tb_remove();}else{alert('Você precisa aceitar a condição acima para continuar!');}" styleClass="baseButton" property="close_action"> Continuar </html:button>
                    -->
                    <html:button accesskey="f" onclick="parent.tb_remove();" styleClass="baseButton" property="close_action">
                      Continuar
                    </html:button>
                  </div>
                </td>
              </tr>

              <%
              session.removeAttribute("mostracartilha");
              %>

            </html:form>
          </td>
        </tr>
      </table>

    </body>
  </center>
</html>

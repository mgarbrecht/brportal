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
                        - Nossos pagamentos s�o efetuados via dep�sito, nas ter�as e sextas de cada semana, preferencialmente nos bancos Bradesco, Brasil, Banrisul e Caixa Econ�mica Federal.
                        <br>
                        <br>
                        - Os dados banc�rios devem estar devidamente atualizados com o CNPJ do fornecedor conforme a nota de venda ou de servi�o.
                        <br>
                        <br>
                        - � vedado ao fornecedor da Cal�ados Beira Rio S.A. dar em garantia a bancos, institui��es financeiras ou terceiros as faturas, duplicatas ou boletos banc�rios emitidos.
                        <br>
                      </br>
                      - Caso o pagamento n�o seja localizado no prazo acordado, entrar em contato diretamente com o comprador ou setor fiscal para qual a nota foi faturada e, se ainda necess�rio, com o setor de contas a pagar pelo fone:
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
              <table class="itemTable" style="width:100%;"> <tr class="itemTr"> <td class="formLabel"> <span class="spamFormLabel"> </span> </td> <td class="formField"> <html:checkbox property="aceito" styleId="aceito" styleClass="baseField" value="1"/> <span class='validateMessageuser'> Li e concordo com as condi��es acima. </span> </td> </tr> </table>
            -->
            <br>

            <table  style='width:100%;'>
              <tr align="center">
                <td class="buttonTd" align="center">
                  <div align="center">
                    <!--
                      <html:button accesskey="f" onclick="if(jQuery('#aceito').attr('checked')){parent.tb_remove();}else{alert('Voc� precisa aceitar a condi��o acima para continuar!');}" styleClass="baseButton" property="close_action"> Continuar </html:button>
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

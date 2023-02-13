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

            <html:form action="system/MensagemForm.do" method="post" styleClass="baseForm">

              <table style="width:100%;">

                <tr>
                  <td>
                    <center>
                      <img src="../img/3Bilhoes.jpg" />
                    </center>
                  </td>
                </tr>
              </table>

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

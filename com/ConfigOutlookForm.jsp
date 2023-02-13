<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Configuração do Outlook
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
                  <%@ include file="../system/header_sem_ajuda.jsp" %>
                </td>

              </tr>

            </table>

            <TABLE border=2 borderColor=#ff0000 width="100%" align="center">

              <TR>
                <TD vAlign=center align=middle>
                  <FONT color=#000000 size=-1 face="arial, helvetica">
                    Siga os passos descritos abaixo para ler e enviar e-mails através do Outlook Express:
                    <BR>
                    <BR>
                    Após abrir o programa, entre em Ferramentas > Contas:
                    <BR>
                    <IMG border=0 src="../img/outlook01.jpg">
                    <BR>
                    <BR>
                    Agora vá em Propriedades:
                    <BR>
                    <IMG border=0 src="../img/outlook02.jpg">
                    <BR>
                    <BR>
                    Verifique se o campo
                    <U>
                      P
                    </U>
                    OP3 está com
                    <B>
                      pop.beirario.com.br
                    </B>
                    e se o campo
                    <U>
                      S
                    </U>
                    MTP está com
                    <B>
                      smtp.beirario.com.br
                    </B>
                    .
                    <BR>
                    O Nome da Conta para o Servidor de entrada de emails deve ser
                    <B>
                      brrepXXX@beirario.com.br
                    </B>
                    , onde o XXX deve ser substituído pelo seu código de representante.
                    <BR>
                    Após isso marque as opções
                    <B>
                      Lembrar senha
                    </B>
                    ,
                    <B>
                      Meu servidor requer autenticação
                    </B>
                    e finalmente clique em
                    <B>
                      <U>
                        C
                      </U>
                      onfigurações
                    </B>
                    .
                    <BR>
                    <IMG border=0 src="../img/outlook03.jpg">
                    <BR>
                    <BR>
                    Nas informações de logon, marque a opção
                    <B>
                      Fazer
                      <U>
                        l
                      </U>
                      ogon usando
                    </B>
                    . O
                    <U>
                      N
                    </U>
                    ome da conta deve ser
                    <B>
                      brrep
                    </B>
                    e a senha
                    <B>
                      beira773@!
                    </B>
                    <BR>
                    Deixar marcadas a opção
                    <B>
                      Lembrar senha
                    </B>
                    . Clique
                    <B>
                      OK
                    </B>
                    <P>
                      <IMG border=0 src="../img/outlook04.jpg">
                      <BR>
                      <BR>
                      Agora clique na guia
                      <B>
                        Avançado
                      </B>
                      . Altere a porta dos emails de saida (SMTP) para 26, conforme figura abaixo.
                      <BR>
                      <BR>
                      <IMG border=0 src="../img/outlook05.jpg">
                      <BR>
                      <BR>
                      <BR>
                      Clique em
                      <B>
                        OK
                      </B>
                      , na próxima tela clique em
                      <B>
                        OK
                      </B>
                      novamente e finalmente
                      <B>
                        Fechar
                      </B>
                      .
                    </FONT>
                  </P>
                </TD>
              </TR>
            </TABLE>
          </td>
        </tr>
      </table>

    </body>
  </center>
</html>

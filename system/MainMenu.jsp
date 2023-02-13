<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      <bean:message bundle="ApplicationResources" key="jsp.menu"/>
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
                  <%@ include file="../system/header_menu.jsp" %>
                </td>

              </tr>

            </table>

            <%
            acesso.Sessao sessao = new acesso.Sessao(session);
            %>
            <html:form action="system/MainMenu.do" method="POST" >
              <html:submit value="logout" styleClass="myhidden" property="logout_action">
                <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                  <bean:message bundle="ApplicationResources" key="jsp.select"/>
                </html:submit>
                <html:submit styleClass="myhidden" property="refresh_action">
                  <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
                </html:submit>


              </html:submit>

            </html:form>
            <script type="text/javascript" src="../script/util.js">
            </script>
            <script type="text/javascript" src="../script/jquery-1.4.2.min.js">
            </script>
            <script type="text/javascript" src="../script/thickbox-compressed.js">
            </script>




            <script>
              function ShowWindow(){
                $("#TB_overlay").unbind("click",tb_remove);
                $(document).ready(function(){
                  //tb_show("Cartilha de relacionamento com o fornecedor","../system/AvisoForm.jsp?KeepThis=true&TB_iframe=true&height=450&width=700",null);
                  tb_show("Parabéns","../system/MensagemForm.jsp?KeepThis=true&TB_iframe=true&height=620&width=710",null);
                  });
                }
              </script>

              <%
              //if(sessao.getTipoEntidadeNegocio().equalsIgnoreCase("fornecedor")
              //&& session.getAttribute("mostracartilha") != null
              if(session.getAttribute("mostra3bilhoes") != null
              ){

                session.removeAttribute("mostra3bilhoes");
                %>
                <script>
                  ShowWindow();
                </script>
                <%
              }
              %>
              <jsp:include page="../system/tree_acesso_usuario.jsp"/>
            </td>
          </tr>
        </table>

      </body>
    </center>
  </html>

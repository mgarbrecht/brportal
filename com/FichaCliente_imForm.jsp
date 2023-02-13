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
            {
              %>

              <%
              util.consultas.com.FichaCliente ficha = new util.consultas.com.FichaCliente(request);
              if(session.getAttribute("cli_cdgo")!=null){
                ficha.setTipoConsulta("C");
                ficha.setChave(Integer.parseInt((String)session.getAttribute("cli_cdgo")));
                ficha.setSequencial(Integer.parseInt((String)session.getAttribute("esc_seqn")));
              } else {
                ficha.setTipoConsulta("G");
                ficha.setChave(Integer.parseInt((String)session.getAttribute("gre_grupo")));
              }

              java.util.Vector res_Acao_marketing = (java.util.Vector)session.getAttribute("res_Acao_marketing");
              %>

              <form  name="bl_report_Acao_marketing" id="bl_report_Acao_marketing" class="baseForm" method="post" >

                <table id="TRbl_report_Acao_marketing"  class="reportTable"   style="width:100%; "  >
                  <%
                  for(String imagem : ficha.getImagensAcaoMarketing()){
                    %>
                    <tr>
                      <td style="text-align:center">
                        <img src="../imagens/acoes_cooperadas/<%= imagem %>" >
                      </td>
                    </tr>
                    <%
                  }
                  %>
                  <tr>
                  </tr>

                </table>


              </form>
              <%
            }
            %>
            <html:form action="com/FichaCliente_imForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:100%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="buttonTable" style='width:100%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
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

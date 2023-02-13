<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Circulares Beira Rio
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(64)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="adm/CircularesVendas_dForm.do" method="POST" styleClass="baseForm">
              <table class="itemTable" style='width:60%;'>
              </table>
              <table class="separatorTable" style='width:60%;'>
                <%
                com.egen.util.jdbc.JdbcUtil connection = null;
                try {
                  if(!user.isSuperUsuario()){
                    connection = new com.egen.util.jdbc.JdbcUtil();
                    portalbr.dbobj.view.Jw_permissoes table = new portalbr.dbobj.view.Jw_permissoes();
                    String[][] select = null;
                    Object[][] where = {
                      {"Usua_usuario","like", user.getUsuario()},
                    {"Acdi_doin_id","=","64"}
                    };
                    Vector res_Jw_permissoes = connection.select(table, select, where, null, null, null);
                    if (res_Jw_permissoes != null && res_Jw_permissoes.size() == 0) {
                      response.sendRedirect("../system/Error.jsp");
                    }
                  }

                } catch (Exception e) {
                  throw e;
                } finally {
                  if (connection != null) {
                    connection.close();
                  }
                }
                %>
                <tr class="separatorTr">
                  <td colspan="2" class="separatorTd" align="center">
                    <b>
                      Circular
                    </b>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Número
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="numero" styleClass="disabled" tabindex="-1" readonly="true" size="7" maxlength="7"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Data
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Remetente
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="remetente" styleClass="disabled" tabindex="-1" readonly="true" size="20" maxlength="20"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Destinatário
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="destinatario" styleClass="disabled" tabindex="-1" readonly="true" size="32" maxlength="32"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Assunto
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="assunto" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="30"/>
                  </td>
                </tr>
              </table>
              <table class="itemTable" style='width:60%;'>
              </table>
              <table class="separatorTable" style='width:60%;'>
                <tr class="separatorTr">
                  <td colspan="2" class="separatorTd" align="center">
                    <b>
                      Texto
                    </b>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                    </span>
                  </td>
                  <td class="formField">
                    <html:textarea property="texto" styleClass="baseField" readonly="true" cols="80" rows="15"/>
                    <!--T-->
                  </td>
                </tr>
              </table>
              <table class="itemTable" style='width:100%;'>
              </table>
              <table class="buttonTable" style='width:99%;'>
                <tr>
                  <td class="buttonItem">
                    <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:submit>
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

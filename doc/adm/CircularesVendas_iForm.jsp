<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page  extends='acesso.web.HttpJspSessao' %>
<html>
  <head>

    <title>
      Circulares Beira Rio
    </title>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
    <bean:message key="page.scriptcalendar"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:99%;'>
        <tr>
          <td>
            <table   class="headerTable" style="width:99%" >
              <tr>
                <td class='td10'>
                  <%@ include file="../system/header.jsp" %>
                </td>
              </tr>
            </table>
            <html:form action="adm/CircularesVendas_iForm.do" method="POST" scope="session" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr>
                  <td class="messageHeader">
                    <bean:message key="div.campos*"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Circulares_vendas"/>
                  </td>
                </tr>
              </table>
              <table class="itemTable" style='width:99%;'>
                <%
                com.egen.util.jdbc.JdbcUtil connection = null;
                try {
                  if(!user.isSuperUsuario()){
                    connection = new com.egen.util.jdbc.JdbcUtil("wbrio","wbrio",util.rdb.ConnectionJDBC.getJdbcURL("orasco"),util.rdb.ConnectionJDBC.getJdbcDriver("orasco"));
                    portalbr.dbobj.view.Jw_permissoes table = new portalbr.dbobj.view.Jw_permissoes();
                    String[][] select = null;
                    Object[][] where = {
                      {"Usua_usuario","like", user.getUsuario()},
                    {"Acdi_doin_id","=","64"}
                    };
                    Vector res_Jw_permissoes = connection.select(table, select, where, null, null, null);
                    if (res_Jw_permissoes != null && res_Jw_permissoes.size() == 0) {
                      %>
                      <script>
                        top.location='../system/Error.jsp';
                      </script>
                      <%
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
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Número
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="numero" styleClass="baseField" size="7" maxlength="7"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Data
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="data" onkeypress="FormataData(this,event);" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" border="0">
                    </a>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Remetente
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="remetente" styleClass="baseField" size="20" maxlength="20"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Destinatário
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:select property="destinatario" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="1">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="2">
                        Representantes Riva Bianca
                      </html:option>
                      <html:option styleClass="baseOption" value="3">
                        Representantes Vizzano
                      </html:option>
                      <html:option styleClass="baseOption" value="4">
                        Analistas e Repres. Riva Bianca
                      </html:option>
                      <html:option styleClass="baseOption" value="5">
                        Todos Representantes
                      </html:option>
                      <html:option styleClass="baseOption" value="6">
                        Analistas Regionais de Vendas
                      </html:option>
                      <html:option styleClass="baseOption" value="7">
                        Analistas e Repres. Beira Rio
                      </html:option>
                      <html:option styleClass="baseOption" value="8">
                        Analistas e Repres. Vizzano
                      </html:option>
                    </html:select>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Assunto
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="assunto" styleClass="baseField" size="30" maxlength="30"/>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Texto
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:textarea property="texto" styleClass="baseField" cols="80" rows="15"/>
                    <!--T-->
                  </td>
                </tr>
                <html:hidden property="status" value="A"/>
              </table>
              <table class="buttonTable" style='width:99%;'>
                <tr>
                  <td class="buttonItem">
                    <html:submit accesskey="i" styleClass="baseButton" property="insert_action">
                      <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                    </html:submit>
                    <html:submit accesskey="r" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:submit>
                  </td>
                </tr>
              </table>
            </html:form>
            <script type="text/javascript" language="JavaScript">
              <!--
              var focusControl = document.forms[0].elements["numero"];
              if (focusControl.type != "hidden") {
                focusControl.focus();
              }
            // -->
            </script>

          </td>
        </tr>
      </table>
    </body>
  </center>
</html>

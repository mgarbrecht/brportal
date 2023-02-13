<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Negociação do Título
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
                </td>

              </tr>

            </table>

            <html:form action="adm/Titulos_nForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <big>
                        <b>
                          Negociação do Título
                          <%= (String)request.getParameter("titulo") %>
                        </b>
                      </big>
                    </div>
                    <html:errors property="dt_calculo"/>
                    <html:errors property="juros"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                java.util.Date data = new java.util.Date();
                java.text.SimpleDateFormat fData = new java.text.SimpleDateFormat("dd/MM/yyyy");
                String dt_atual = fData.format(data);
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Cálculo de Juros
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_calculo" styleClass="baseField" value="<%= dt_atual %>" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_calculo']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Taxa de Juros
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="juros" styleClass="baseField" value="6" size="5"/>
                    <span class='validateMessageuser'>
                      %
                    </span>
                  </td>
                </tr>

                <html:hidden property="titulo" value="<%= (String)request.getParameter("titulo") %>"/>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="s" value="Calcular" styleClass="baseButton" property="select_action">
                    </html:submit>
                    <html:submit accesskey="r" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["dt_calculo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

          </td>
        </tr>
      </table>

    </body>
  </center>
</html>

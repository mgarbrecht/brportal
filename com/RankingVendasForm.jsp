<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Relatório de Ranking de Vendas
    </title>
  </head>
  <center>
    <body onload="if('<%= (String)request.getAttribute("arquivo") %>' == 'null'){document.forms[0].abre_automaticamente.checked=false;document.forms[0].mensagem.value='';}if(document.forms[0].abre_automaticamente.checked==true){abreRelatorioPDF('<%= (String)request.getAttribute("arquivo") %>');}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(128)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/RankingVendasForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="dt_inicio"/>
                    <html:errors property="dt_fim"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="unn_codigo"/>
                    <html:errors property="dias_semana"/>
                    <html:errors property="tipo"/>
                    <html:errors property="abre_automaticamente"/>
                    <html:errors property="mensagem"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                com.egen.util.jdbc.JdbcUtil j = null;
                java.sql.Connection conn = null;
                String data_inicial = null;
                String data_final   = null;
                String data_final_j = null;
                try {
                  j = new com.egen.util.jdbc.JdbcUtil();
                  java.sql.PreparedStatement pstm = j.getConn().prepareStatement(
                  //              " SELECT to_char(TRUNC((sysdate-7) - decode(TO_CHAR((sysdate-7),'D'),2,3, 3,4, 4,5, 5,6, 6,0,7,1, 1,2) ,'DD'),'dd/mm/yyyy'), to_char(TRUNC((sysdate-7) - decode(TO_CHAR((sysdate-7),'D'),2,3, 3,4, 4,5, 5,6, 6,0,7,1, 1,2) ,'DD')+6,'dd/mm/yyyy'), to_char(sysdate,'dd/mm/yyyy') FROM DUAL  "
                  " SELECT to_char(TRUNC(SYSDATE,'WW'),'dd/mm/yyyy'), to_char(TRUNC(SYSDATE,'WW')+6,'dd/mm/yyyy'), to_char(sysdate,'dd/mm/yyyy') FROM DUAL  "
                  );

                  // 2a - domingo " select to_char(TRUNC(SYSDATE,'WW'),'dd/mm/yyyy'),to_char(TRUNC(SYSDATE,'WW')+6,'dd/mm/yyyy') from dual "

                  java.sql.ResultSet rset = pstm.executeQuery();
                  if(rset.next()){
                    data_inicial = rset.getString(1);
                    data_final   = rset.getString(2);
                    data_final_j = rset.getString(3);
                  }
                  rset.close();
                  pstm.close();
                } catch (Exception e) {}
                finally {
                  if (j != null) {
                    j.close();
                    j = null;
                  }
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Inicial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_inicio" styleId="dt_inicio" styleClass="baseField" value="<%= data_inicial %>" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_inicio']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Final
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_fim" styleId="dt_fim" styleClass="baseField" value="<%= data_final %>" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_fim']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="codigo_marca" styleClass="baseField" size="1">
                      <html:options property="codigo_marcaList" labelProperty="codigo_marcaLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Unid. Negócio
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="unn_codigo" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="\"selected='selected'">
                        TODOS
                      </html:option>
                      <html:option styleClass="baseOption" value="01">
                        MANUFATURADOS
                      </html:option>
                      <html:option styleClass="baseOption" value="02">
                        ASSANDALIADOS
                      </html:option>
                      <html:option styleClass="baseOption" value="03">
                        INJECAO DIRETA
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Dias Semana
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="dias_semana" styleClass="baseField">
                      <html:option styleClass="baseOption" value="1">
                        1
                      </html:option>
                      <html:option styleClass="baseOption" value="2">
                        2
                      </html:option>
                      <html:option styleClass="baseOption" value="3">
                        3
                      </html:option>
                      <html:option styleClass="baseOption" value="4">
                        4
                      </html:option>
                      <html:option styleClass="baseOption" value="5\"selected='selected'">
                        5
                      </html:option>
                      <html:option styleClass="baseOption" value="6">
                        6
                      </html:option>
                      <html:option styleClass="baseOption" value="7">
                        7
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo Relatório
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="S">
                        Semanal
                      </html:option>
                      <html:option styleClass="baseOption" value="D">
                        Diário
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Abre Automaticamente
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="abre_automaticamente" onclick="if(this.checked==true){mensagem.value='Obs.: Uma nova janela será aberta para a visualização do relatório.';}else{mensagem.value='';}" styleClass="baseField" value="checked"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="mensagem" style="background-color:transparent; border-style:none; color:red; background-color:transparent; border-style:none; cursor:default;text-align:start;" styleClass="baseField" tabindex="-1" readonly="true" size="70" maxlength="70"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                    <%
                    if((String)request.getAttribute("abre_automaticamente")=="N"){
                      %>
                      <table style=width:100%;margin-top:10;>
                        <tr>
                          <td class=columHeader style="text-align:center;">
                            <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                              <bean:message key="report.downloadpdf"/>
                            </a>
                          </td>
                        </tr>
                      </table>
                      <%
                    }
                    %>
                  </table>

                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:button accesskey="p" onclick="bloqueia();;resetfull1_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:button>
                        <script>
                          function getKeySite(keyStroke) {
                            isNetscape=(document.layers);
                            eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                            which = String.fromCharCode(eventChooser).toLowerCase();
                            keyBuffer = which;
                            if(eventChooser == 13){ bloqueia();
                          if(document.forms[0].select1_action.disabled==true){return false;}
                          document.forms[0].select1_action.disabled=true;
                          document.forms[0].resetfull1_action.disabled=true;
                          document.forms[0].select_action.click();
                        }
                      }
                    </script>
                    <SCRIPT>
                      document.onkeypress = getKeySite;
                      </SCRIPT>

                      <html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:button>
                      <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:submit styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:submit>
                      </td>
                      </tr>
                      </table>

                      <script type="text/javascript">
                      jQuery(document).ready(function($) {
                        $("#dt_inicio").mask("99/99/9999");
                        $("#dt_fim").mask("99/99/9999");
                        });
                      </script>
                    </html:form>
                    <script type="text/javascript">
                      var focusControl = document.forms[0].elements["codigo_marca"];
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

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
    <bean:message key="page.dwrscripts"/>
    <script type="text/javascript" src="../dwr/interface/ConsultaNotaFiscal_tActionForm.js">
    </script>
    <script type="text/javascript">
      var ActionFormClass = ConsultaNotaFiscal_tActionForm;
      var hashMapLabel = new HashMap();
      hashMapLabel.set("codigo","Codigo");
      hashMapLabel.set("descricao","Descricao");
      var reportColumns = new Array();
    </script>
    <bean:message key="page.ajaxscript"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:100%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <%
            if(request.getAttribute("fechar")!=null){
              %>

              <script>
                opener.document.forms[0].refresh_action.click()
                javascript:window.close();
              </script>
              <%
            }
            %>


            <html:form action="com/ConsultaNotaFiscal_tGrid.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:100%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="codigo"/>
                    <html:errors property="descricao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Tipo_ocorrencia"/>
                  </td>
                </tr>
              </table>

              <table class="itemGridTable" style='width:100%;'>
                <tr class="trGridLabel">
                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Codigo
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Descricao
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>

                </tr>

                <logic:iterate id="bl_form_Tipo_ocorrencia_lines" name="ConsultaNotaFiscal_tGridActionForm" property="bl_form_Tipo_ocorrencia_lines" indexId="indexId">
                  <tr class="trGridField">
                    <td class="tdGridField">
                      <html:text property="codigo" styleId="codigo" onblur="fillFieldsGrid(this, 0,new Array('codigo'),'ConsultaNotaFiscal_tActionForm.getDescricao_Ajax',new Array('descricao'));" styleClass="baseField" size="10" maxlength="10" name="bl_form_Tipo_ocorrencia_lines" indexed="true"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo<%= indexId %>()"  >
                      <script type="text/javascript">
                        function lov_open_codigo<%= indexId %>() {
                          window.open('..//lov/LvTipoOcorrenciasLov.do?resetfull_action=&returnBlock=0&return0=codigo[<%= indexId %>]&return1=descricao[<%= indexId %>]','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                    </td>

                    <td class="tdGridField">
                      <html:text property="descricao" styleId="descricao" styleClass="disabled" tabindex="-1" readonly="true" size="80" maxlength="255" name="bl_form_Tipo_ocorrencia_lines" indexed="true"/>
                    </td>

                  </tr>

                </logic:iterate>

              </table>

              <table class="buttonTable" style='width:100%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" value="Selecionar" styleClass="baseButton" property="select_action">
                    </html:submit>
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
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

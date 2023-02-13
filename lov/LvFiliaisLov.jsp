<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
    <bean:message key="page.dwrscripts"/>
    <script type="text/javascript" src="../dwr/interface/LvFiliaisActionForm.js">
    </script>
    <script type="text/javascript">
      var ActionFormClass = LvFiliaisActionForm;
      var hashMapLabel = new HashMap();
      hashMapLabel.set("fil_filial","Filial");
      hashMapLabel.set("fil_razsoc","");
      hashMapLabel.set("return0","");
      hashMapLabel.set("return03","");
      var reportColumns = new Array();
    </script>
    <bean:message key="page.ajaxscript"/>
  </head>
  <center>
    <body onload="if('<%= (String)request.getAttribute("filiais") %>' != 'null'){opener.document.forms[0].filiais.value='<%= (String)request.getAttribute("filiais") %>';opener.document.forms[0].refresh_action.click();window.close();}">
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvFiliaisGrid.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="itemGridTable" style='width:500;'>
                <tr class="trGridLabel">
                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Filial
                    </span>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>

                </tr>

                <logic:iterate id="bl_form_Filial_lines" name="LvFiliaisGridActionForm" property="bl_form_Filial_lines" indexId="indexId">
                  <tr class="trGridField">
                    <td class="tdGridField">
                      <html:text property="fil_filial" styleClass="baseField" size="4" maxlength="4" name="bl_form_Filial_lines" indexed="true" styleId="fil_filial"/>
                      <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_fil_filial<%= indexId %>()"  >
                      <script type="text/javascript">
                        function lov_open_fil_filial<%= indexId %>() {
                          window.open('../lov/LvFilialLov.do?resetfull_action=&returnBlock=0&return0=fil_filial[<%= indexId %>]&return1=fil_razsoc[<%= indexId %>]','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                    </td>

                    <td class="tdGridField">
                      <html:text property="fil_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="50" maxlength="50" name="bl_form_Filial_lines" indexed="true" styleId="fil_razsoc"/>
                    </td>

                    <html:hidden property="return0" value="<%= request.getParameter("return0") %>" name="bl_form_Filial_lines" indexed="true" styleId="return0"/>
                    <html:hidden property="return0" name="bl_form_Filial_lines" indexed="true" styleId="return03"/>
                  </tr>

                </logic:iterate>

              </table>

              <table class="buttonTable" style='width:500;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" value="Selecionar Filiais" styleClass="baseButton" property="select_action">
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["fil_filial"][0];
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

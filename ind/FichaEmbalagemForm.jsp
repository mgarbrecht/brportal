<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/FichaEmbalagemActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = FichaEmbalagemActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("ref_cdgo_inicial","Ref.");
    hashMapLabel.set("ref_cdgo_final","a");
    hashMapLabel.set("codigo_corrugado","Corrugado");
    hashMapLabel.set("descricao_corrugado","");
    hashMapLabel.set("mix","Mix / Fora Mix");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Ficha Embalagem
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(194)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/FichaEmbalagemForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="ref_cdgo_inicial"/>
                    <html:errors property="ref_cdgo_final"/>
                    <html:errors property="codigo_corrugado"/>
                    <html:errors property="descricao_corrugado"/>
                    <html:errors property="mix"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_ficha_embalagem"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" onblur="fillFields(0,new Array('lin_cdgo'),'FichaEmbalagemActionForm.getLin_nome_Ajax',new Array('lin_nome'));" styleClass="baseField" size="6" maxlength="22"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('..//lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_nome" styleId="lin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="25" maxlength="25"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Ref.
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ref_cdgo_inicial" styleId="ref_cdgo_inicial" styleClass="baseField" value="0" size="5" maxlength="5"/>
                    <span class="spamFormLabel">
                      a
                    </span>
                    <html:text property="ref_cdgo_final" styleId="ref_cdgo_final" styleClass="baseField" value="99999" size="5" maxlength="5"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Corrugado
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_corrugado" styleId="codigo_corrugado" onblur="fillFields(0,new Array('codigo_corrugado'),'FichaEmbalagemActionForm.getDescricao_corrugado_Ajax',new Array('descricao_corrugado'));" styleClass="baseField" size="2" maxlength="22"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_corrugado()"  >
                    <script type="text/javascript">
                      function lov_open_codigo_corrugado() {
                        window.open('..//lov/LvCorrugadoLov.do?resetfull_action=&returnBlock=0&return0=codigo_corrugado&return1=descricao_corrugado','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="descricao_corrugado" styleId="descricao_corrugado" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Mix / Fora Mix
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="mix" styleId="mix" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="null">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="'M'">
                        No Mix
                      </html:option>
                      <html:option styleClass="baseOption" value="'F'">
                        Fora Mix
                      </html:option>
                    </html:select>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="s" onclick="bloqueia();" styleClass="baseButton" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="r" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["lin_cdgo"];
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

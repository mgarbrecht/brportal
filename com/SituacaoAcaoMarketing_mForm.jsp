<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Cadastro de Estágios
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(176)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/SituacaoAcaoMarketing_mGrid.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="descricao"/>
                    <html:errors property="ordem"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Acao_marketing_estagios"/>
                  </td>
                </tr>
              </table>

              <table class="itemGridTable" style='width:99%;'>
                <tr class="trGridLabel">
                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>

                  <td class="tdGridlabel">
                    <span class="spamFormLabel">
                      Ordem
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>

                </tr>

                <logic:iterate id="bl_form_Acao_marketing_estagios_lines" name="SituacaoAcaoMarketing_mGridActionForm" property="bl_form_Acao_marketing_estagios_lines" indexId="indexId">
                  <tr class="trGridField">
                    <html:hidden property="excluir" value="1" name="bl_form_Acao_marketing_estagios_lines" indexed="true" styleId="excluir"/>
                    <html:hidden property="estagio_cdgo" name="bl_form_Acao_marketing_estagios_lines" indexed="true" styleId="estagio_cdgo"/>
                    <td class="tdGridField">
                      <html:text property="descricao" styleId="descricao" onchange="setarAlterado(this.name,0,event);" onkeydown="setarAlterado(this.name,0,event);" onkeypress="setarAlterado(this.name,0,event);" styleClass="baseField" size="60" maxlength="60" name="bl_form_Acao_marketing_estagios_lines" indexed="true"/>
                    </td>

                    <td class="tdGridField">
                      <html:text property="ordem" styleId="ordem" onchange="setarAlterado(this.name,0,event);" onkeydown="setarAlterado(this.name,0,event);" onkeypress="setarAlterado(this.name,0,event);" styleClass="baseField" size="22" maxlength="22" name="bl_form_Acao_marketing_estagios_lines" indexed="true"/>
                    </td>

                    <html:hidden property="banco" name="bl_form_Acao_marketing_estagios_lines" indexed="true" styleId="banco"/>
                    <html:hidden property="alterado" name="bl_form_Acao_marketing_estagios_lines" indexed="true" styleId="alterado"/>
                    <html:hidden property="pos" name="bl_form_Acao_marketing_estagios_lines" indexed="true" styleId="pos"/>
                  </tr>

                </logic:iterate>

              </table>

              <table class="itemTable" style='width:99%;'>
                <%
                {
                  %>
                  <%
                  java.util.Vector res_Acao_marketing_estagios = (java.util.Vector)session.getAttribute("res_Acao_marketing_estagios");
                  %>
                  <%
                  String pos = "0";
                  if (res_Acao_marketing_estagios!=null) {
                    pos = "" + res_Acao_marketing_estagios.size();
                  }
                  %>
                </table>
                <table class="navigatorTable" style="width:99%;">
                  <tr class="navigatorTr" >
                    <td class="navigatorTd" >
                      <img border="0" style="cursor:pointer" src="../img/first.gif" title="Primeiro" onclick="javascript:new_pos0('1');" />
                       
                      <img border="0" style="cursor:pointer" src="../img/prev_group.gif" title="Anterior" onclick="javascript:new_pos0(parseInt(document.forms[0].navigation_pos0.value)-10);" accesskey="m" />
                       
                      <img border="0" style="cursor:pointer" src="../img/prev.gif" title="Anterior" onclick="javascript:new_pos0(parseInt(document.forms[0].navigation_pos0.value)-1);" accesskey="," />
                       
                      <input type="text" name="navigation_pos0" size="5" class="navigatorInput" >
                       
                      <img border="0" style="cursor:pointer" src="../img/next.gif" title="Próximo"  onclick="javascript:new_pos0(parseInt(document.forms[0].navigation_pos0.value)+1);" accesskey="." />
                       
                      <img border="0" style="cursor:pointer" src="../img/next_group.gif" title="Próximo"  onclick="javascript:new_pos0(parseInt(document.forms[0].navigation_pos0.value)+10);" accesskey=";" />
                       
                      <img border="0" style="cursor:pointer" src="../img/last.gif" title="Último" onclick="javascript:new_pos0(document.forms[0].navigation_max0.value);">
                       
                      <bean:message key="jsp.navigator.register"/>
                      :
                      <input type="text" name="navigation_max0" value="<%= pos %>" size="5" class="navigatorInput" >
                      <input type="text" name="bloqueia_navegador" style="visibility:hidden" >
                    </td>
                  </tr>
                  <script type="text/javascript">
                    if (document.forms[0].pos[0].value!="") {
                      document.forms[0].navigation_pos0.value= parseInt(document.forms[0].pos[0].value) + 1;
                    }
                    function new_pos0(POS) {
                      if(document.forms[0].bloqueia_navegador.value!=''){
                        alert('Conclua a alteração da tela');
                        return;
                      }
                      if (POS>0 && POS<=document.forms[0].navigation_max0.value ) {
                        document.forms[0].navigation_pos0.value=POS;
                        document.forms[0].pos[0].value=parseInt(document.forms[0].navigation_pos0.value) - 1;
                        document.forms[0].pos_action.click();
                      } else {
                        alert("<bean:message key="jsp.endregistries"/>");
                      }
                    }
                  </script>
                  <%}%>
                  </table>

                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:submit value="Pos" styleClass="myhidden" property="pos_action">
                        </html:submit>
                        <html:submit accesskey="p" styleClass="baseButton" property="select_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:submit>
                        <html:submit accesskey="i" disabled="true" styleClass="baseButton" property="insert_action">
                          <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                        </html:submit>
                        <html:submit accesskey="a" disabled="true" styleClass="baseButton" property="update_action">
                          <bean:message bundle="ApplicationResources" key="jsp.update"/>
                        </html:submit>
                        <html:submit disabled="true" styleClass="myhidden" property="delete_action">
                          <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                        </html:submit>
                        <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                          <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                        </html:submit>
                      </td>
                    </tr>
                  </table>

                </html:form>
                <script type="text/javascript">
                  var focusControl = document.forms[0].elements["excluir"][0];
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

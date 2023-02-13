<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/SolicitacaoAlteracaoComissao_iActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = SolicitacaoAlteracaoComissao_iActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("tipo","Tipo");
    hashMapLabel.set("id_solicitacao","Id_solicitacao");
    hashMapLabel.set("nfs_nmro","Nota");
    hashMapLabel.set("nfs_serie","Série");
    hashMapLabel.set("emp_empresa","Empresa");
    hashMapLabel.set("fil_filial","Filial");
    hashMapLabel.set("valor_nota","Valor Nota");
    hashMapLabel.set("qtd_duplicatas","Qtd. Duplicatas");
    hashMapLabel.set("f_prorrogacao_i","");
    hashMapLabel.set("valor_calculado","Custo Total de Prorrogação");
    hashMapLabel.set("nro_dias_prorrogacao","Nro. Dias Prorrogação");
    hashMapLabel.set("f_prorrogacao_f","");
    hashMapLabel.set("data_solicitacao","Data_solicitacao");
    hashMapLabel.set("usuario_solicitacao","Usuario_solicitacao");
    hashMapLabel.set("situacao","Situacao");
    hashMapLabel.set("f_desconto_i","");
    hashMapLabel.set("ped_boni","Percentual Desconto");
    hashMapLabel.set("ped_comr","Comissão Pedido");
    hashMapLabel.set("comissao_nova","Comissão Nova");
    hashMapLabel.set("valor_calculado1","Valor Abatimento");
    hashMapLabel.set("f_desconto_f","");
    hashMapLabel.set("motivo","Motivo");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Solicitação de Alteração de Comissão - Cadastro
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(202)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/SolicitacaoAlteracaoComissao_iForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="tipo"/>
                    <html:errors property="nfs_nmro"/>
                    <html:errors property="nfs_serie"/>
                    <html:errors property="emp_empresa"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="valor_nota"/>
                    <html:errors property="qtd_duplicatas"/>
                    <html:errors property="valor_calculado"/>
                    <html:errors property="nro_dias_prorrogacao"/>
                    <html:errors property="ped_boni"/>
                    <html:errors property="ped_comr"/>
                    <html:errors property="comissao_nova"/>
                    <html:errors property="valor_calculado1"/>
                    <html:errors property="motivo"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Solicita_prorrogacao"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String usuario = null;
                String funcao = null;
                acesso.Sessao sessao = new acesso.Sessao(session);
                usuario = sessao.getUsuario();
                util.consultas.Parametros parametros = new util.consultas.Parametros();
                funcao = parametros.retornaParametro("formula_custo_total_prorrogacao");
                portalbr.com.SolicitacaoAlteracaoComissao_iActionForm solicitacao = (portalbr.com.SolicitacaoAlteracaoComissao_iActionForm)session.getAttribute("SolicitacaoAlteracaoComissao_iActionForm");
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo" styleId="tipo" onchange="blank_action.click();" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="P">
                        Prorrogação
                      </html:option>
                      <html:option styleClass="baseOption" value="D">
                        Desconto não concedido
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <html:hidden property="id_solicitacao"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nota
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="nfs_nmro" styleId="nfs_nmro" styleClass="disabled" tabindex="-1" readonly="true" size="7" maxlength="7"/>
                    <input type="button" class="lovButton" tabindex="-1" value="Selecionar Nota Fiscal"  onclick="javascript:lov_open_nfs_nmro();"  >
                    <script type="text/javascript">
                      function lov_open_nfs_nmro() {
                        window.open('..//lov/LvNotaFiscalLov.do?blank_action=&returnBlock=0&return0=emp_empresa&return1=fil_filial&return2=nfs_nmro&return3=nfs_serie&return4=valor_nota&return5=qtd_duplicatas&return6=ped_boni&return7=ped_comr','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Série
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="nfs_serie" styleId="nfs_serie" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="3"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Empresa
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="emp_empresa" styleId="emp_empresa" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="3"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Filial
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="fil_filial" styleId="fil_filial" styleClass="disabled" tabindex="-1" readonly="true" size="4" maxlength="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Valor Nota
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="valor_nota" styleId="valor_nota" onblur="fillFields(0,new Array('valor_nota','qtd_duplicatas','nro_dias_prorrogacao'),'SolicitacaoAlteracaoComissao_iActionForm.getValor_calculado_Ajax',new Array());" styleClass="disabled" tabindex="-1" readonly="true" size="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Qtd. Duplicatas
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="qtd_duplicatas" styleId="qtd_duplicatas" onblur="fillFields(0,new Array('valor_nota','qtd_duplicatas','nro_dias_prorrogacao'),'SolicitacaoAlteracaoComissao_iActionForm.getValor_calculado_Ajax',new Array());" styleClass="disabled" tabindex="-1" readonly="true" size="5"/>
                  </td>
                </tr>

                <%
                if(solicitacao.getTipo()==null || solicitacao.getTipo().equals("P")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Custo Total de Prorrogação
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="valor_calculado" styleId="valor_calculado" styleClass="disabled" tabindex="-1" readonly="true" size="22" maxlength="22"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Nro. Dias Prorrogação
                      </span>
                      <bean:message key="jsp.fieldnotnull"/>
                    </td>
                    <td class="formField">
                      <html:text property="nro_dias_prorrogacao" styleId="nro_dias_prorrogacao" onblur="if(document.forms[0].nfs_nmro.value!=''){fillFields(0,new Array('valor_nota','qtd_duplicatas','nro_dias_prorrogacao'),'SolicitacaoAlteracaoComissao_iActionForm.getValor_calculado_Ajax',new Array('valor_calculado'));}else{if(document.forms[0].nro_dias_prorrogacao.value!=''){alert('Informe a Nota Fiscal!');};}" styleClass="baseField" size="2" maxlength="2"/>
                    </td>
                  </tr>

                  <%
                }
                %>
                <html:hidden property="data_solicitacao"/>
                <html:hidden property="usuario_solicitacao" value="<%= usuario %>"/>
                <html:hidden property="situacao" value="P"/>
                <%
                if(solicitacao.getTipo()!=null && solicitacao.getTipo().equals("D")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Percentual Desconto
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="ped_boni" styleId="ped_boni" styleClass="disabled" tabindex="-1" readonly="true"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Comissão Pedido
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="ped_comr" styleId="ped_comr" styleClass="disabled" tabindex="-1" readonly="true"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Comissão Nova
                      </span>
                      <bean:message key="jsp.fieldnotnull"/>
                    </td>
                    <td class="formField">
                      <html:text property="comissao_nova" styleId="comissao_nova" styleClass="baseField" size="10" maxlength="22"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Valor Abatimento
                      </span>
                      <bean:message key="jsp.fieldnotnull"/>
                    </td>
                    <td class="formField">
                      <html:text property="valor_calculado1" styleId="valor_calculado1" styleClass="baseField" size="10" maxlength="22"/>
                    </td>
                  </tr>

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Motivo
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="motivo" styleId="motivo" onblur="javascript:toUpperCase(this);" styleClass="baseField" size="80" maxlength="200"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="i" styleClass="baseButton" property="insert_action">
                      <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:submit>
                    <html:submit value="Blank" styleClass="myhidden" property="blank_action">
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["nfs_nmro"];
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

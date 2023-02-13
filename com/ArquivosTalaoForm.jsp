<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ArquivosTalaoActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ArquivosTalaoActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("forn_i","");
    hashMapLabel.set("forn_codigo","Fornecedor");
    hashMapLabel.set("forn_razsoc","");
    hashMapLabel.set("forn_f","");
    hashMapLabel.set("fil_filial","Filial");
    hashMapLabel.set("fil_razsoc","");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("oco_numero","Ordem de Compra<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("rem_nro","Remessa<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("free_end","");
    hashMapLabel.set("data_compra_inicial","Data Compra de<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("data_compra_final"," a ");
    hashMapLabel.set("situacao","Situação");
    hashMapLabel.set("espacamento","Espaçamento do Relatório");
    hashMapLabel.set("botao_lov_materiais","");
    hashMapLabel.set("lista_materiais","");
    hashMapLabel.set("ordenacao","Ordenação");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Arquivos Talão
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(253)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ArquivosTalaoForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="forn_codigo"/>
                    <html:errors property="forn_razsoc"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="fil_razsoc"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="oco_numero"/>
                    <html:errors property="rem_nro"/>
                    <html:errors property="data_compra_inicial"/>
                    <html:errors property="data_compra_final"/>
                    <html:errors property="situacao"/>
                    <html:errors property="espacamento"/>
                    <html:errors property="ordenacao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_talao"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String fornecedor = null;
                acesso.Sessao sessao = new acesso.Sessao(session);
                if(sessao.isFornecedorAtelier()){
                  fornecedor = sessao.getChave();
                }
                %>
                <%
                if(fornecedor == null) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Fornecedor
                      </span>
                      <bean:message key="jsp.fieldnotnull"/>
                    </td>
                    <td class="formField">
                      <html:text property="forn_codigo" styleId="forn_codigo" onblur="fillFields(0,new Array('forn_codigo'),'ArquivosTalaoActionForm.getForn_razsoc_Ajax',new Array('forn_razsoc'));" styleClass="baseField" size="10" maxlength="22"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_forn_codigo()"  >
                      <script type="text/javascript">
                        function lov_open_forn_codigo() {
                          window.open('..//lov/LvFornecedorLov.do?resetfull_action=&returnBlock=0&return0=forn_codigo&return1=forn_razsoc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="forn_razsoc" styleId="forn_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="forn_codigo" value="<%= fornecedor %>" />
                  <html:hidden property="forn_razsoc"/>

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Filial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fil_filial" styleId="fil_filial" onblur="fillFields(0,new Array('fil_filial'),'ArquivosTalaoActionForm.getFil_razsoc_Ajax',new Array('fil_razsoc'));" styleClass="baseField" size="4" maxlength="10"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fil_filial()"  >
                    <script type="text/javascript">
                      function lov_open_fil_filial() {
                        window.open('..//lov/LvFilialLov.do?resetfull_action=&returnBlock=0&return0=fil_filial&return1=fil_razsoc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="fil_razsoc" styleId="fil_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="50"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" onblur="fillFields(0,new Array('lin_cdgo'),'ArquivosTalaoActionForm.getLin_nome_Ajax',new Array('lin_nome'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('..//lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_nome" styleId="lin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Ordem de Compra
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="oco_numero" styleId="oco_numero" styleClass="baseField" size="10" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Remessa
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="rem_nro" styleId="rem_nro" styleClass="baseField" size="10" maxlength="22"/>
                  </td>
                </tr>

                <%
                if(fornecedor == null){
                  %>
                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["forn_codigo"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>
                  <%
                } else {
                  %>
                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["fil_filial"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>


                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Compra de
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_compra_inicial" styleId="data_compra_inicial" styleClass="baseField" size="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_compra_inicial']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                      a
                    </span>
                    <html:text property="data_compra_final" styleId="data_compra_final" styleClass="baseField" size="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_compra_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situação
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="situacao" styleId="situacao" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="T">
                        Todas
                      </html:option>
                      <html:option styleClass="baseOption" value="C">
                        Consultado
                      </html:option>
                      <html:option styleClass="baseOption" value="G">
                        Gerado
                      </html:option>
                      <html:option styleClass="baseOption" value="V">
                        Visualizado
                      </html:option>
                      <html:option styleClass="baseOption" value="P">
                        Publicado
                      </html:option>
                      <html:option styleClass="baseOption" value="NV">
                        Não Visualizado
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Espaçamento do Relatório
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="espacamento" styleId="espacamento" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="3">
                        3 milímetros
                      </html:option>
                      <html:option styleClass="baseOption" value="7">
                        7 milímetros
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <%
                java.util.Vector res_Jw_materiaisb = (java.util.Vector)session.getAttribute("materiais");
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                    <input type="button" class="lovButton" value="Selecionar Peças" onclick="if(testaParametrosAberturaLov()){lov_open_tipo_produto()}">
                    <%
                    if (res_Jw_materiaisb!=null && res_Jw_materiaisb.size()>0) {
                      %>
                      <input type="button" class="lovButton" value="Limpar Peças Selecionadas" onclick="document.forms[0].limpar_materiais_action.click();">
                      <%
                    }
                    %>

                    <script type="text/javascript">
                      function lov_open_tipo_produto() {
                        window.open('..//lov/LvMateriaisLov.do?select1_action=&forn_codigo='+document.forms[0].forn_codigo.value+'&fil_filial='+document.forms[0].fil_filial.value+'&oco_numero='+document.forms[0].oco_numero.value+'&rem_nro='+document.forms[0].rem_nro.value+'&data_compra_inicial='+document.forms[0].data_compra_inicial.value+'&data_compra_final='+document.forms[0].data_compra_final.value+'&situacao='+document.forms[0].situacao.value+'','','scrollbars=yes,height=510,width=800,top=0,left=0,');
                      }
                      function testaParametrosAberturaLov(){
                        if(document.forms[0].forn_codigo.value == ''){
                          alert('O fornecedor deve ser informado!');
                          return false;
                        }
                        if(
                        document.forms[0].oco_numero.value == '' && document.forms[0].rem_nro.value == '' &&
                        (document.forms[0].data_compra_inicial.value == '' || document.forms[0].data_compra_final.value == '')
                        ){
                          alert('Um dos parâmetros devem ser preenchidos!');
                          return false;
                        }

                        return true;
                      }
                    </script>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                    </span>
                  </td>
                  <td class="formField">
                    <%
                    int counterbl_report_Jw_materiais =0;
                    int i_bl_report_Jw_materiais =0;
                    java.util.Vector res_Jw_materiais = (java.util.Vector)session.getAttribute("materiais");
                    if (res_Jw_materiais!=null && res_Jw_materiais.size()>0) {
                      %>
                      <table id="TRbl_report_Jw_tipos_produtos" class="reportTable" style=width:500px; border=1;  >
                        <tr class="reportHeader" >
                          <td align="center">
                            Materiais Selecionados
                          </td>
                        </tr>
                        <%
                        for (int x=0;x<res_Jw_materiais.size(); x++){
                          counterbl_report_Jw_materiais++;
                          String style="";
                          if (!((i_bl_report_Jw_materiais%2)!=0)) {
                            style="class=rowColor";
                          } else {
                            style="class=rowBlank";
                          }
                          %>
                          <tr <%= style %> id='TRbl_report_Jw_tipos_produtos<%=counterbl_report_Jw_materiais%>' >
                            <td class="reportColumn" style="text-align:left;">
                              <%= res_Jw_materiais.elementAt(x) %>
                            </td>
                          </tr>
                          <%
                        }
                        %>
                      </table>
                      <%
                    }
                    %>

                  </td>
                </tr>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Ordenação
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="ordenacao" styleId="ordenacao" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="1">
                        Por Talão
                      </html:option>
                      <html:option styleClass="baseOption" value="2">
                        Por Material e Cor
                      </html:option>
                    </html:select>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="p" onclick="resetfull1_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:button>
                    <script>
                      function getKeySite(keyStroke) {
                        isNetscape=(document.layers);
                        eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                        which = String.fromCharCode(eventChooser).toLowerCase();
                        keyBuffer = which;
                        if(eventChooser == 13){
                        if(document.forms[0].select1_action.disabled==true){return false;}
                        document.forms[0].select1_action.disabled=true;
                        document.forms[0].resetfull1_action.disabled=true;
                        document.forms[0].select_action.click();
                      }
                    }
                  </script>
                  <SCRIPT>
                    document.onkeypress = getKeySite;
                    </SCRIPT><html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="refresh_action"><bean:message bundle="ApplicationResources" key="jsp.refresh"/></html:submit>
                    <html:submit value="limpar_materiais" styleClass="myhidden" property="limpar_materiais_action"></html:submit>
                    </td>
                    </tr>
                    </table>

                    <script type="text/javascript">
                    jQuery(document).ready(function($) {
                      $("#data_compra_inicial").mask("99/99/9999");
                      $("#data_compra_final").mask("99/99/9999");
                      });
                    </script>
                  </html:form>
                </td>
              </tr>
            </table>

          </body>
        </center>
      </html>

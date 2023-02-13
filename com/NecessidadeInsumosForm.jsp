<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/NecessidadeInsumosActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = NecessidadeInsumosActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("f_free","");
    hashMapLabel.set("forn_codigo","Fornecedor");
    hashMapLabel.set("forn_razsoc","");
    hashMapLabel.set("fil_filial","Filial");
    hashMapLabel.set("fil_razsoc","");
    hashMapLabel.set("gpo_mater_cdgo","Grupo de Material");
    hashMapLabel.set("gpo_mater_desc","");
    hashMapLabel.set("codigo_material","Material");
    hashMapLabel.set("descricao_material","");
    hashMapLabel.set("cor_cdgo","Cor");
    hashMapLabel.set("cor_desc","");
    hashMapLabel.set("numero","Ordem de Compra<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("data_inicial","Data Inicial<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("data_final","Data Final<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("somente_primeiro_nivel","Somente Primeiro Nível");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Necessidade de Insumos
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(256)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/NecessidadeInsumosForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <div class\='div10l'>
                        Um dos campos com
                        <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        deve ser preenchido.
                      </div>
                    </div>
                    <html:errors property="forn_codigo"/>
                    <html:errors property="forn_razsoc"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="fil_razsoc"/>
                    <html:errors property="gpo_mater_cdgo"/>
                    <html:errors property="gpo_mater_desc"/>
                    <html:errors property="codigo_material"/>
                    <html:errors property="descricao_material"/>
                    <html:errors property="cor_cdgo"/>
                    <html:errors property="cor_desc"/>
                    <html:errors property="numero"/>
                    <html:errors property="data_inicial"/>
                    <html:errors property="data_final"/>
                    <html:errors property="somente_primeiro_nivel"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_dom_ordem_compra"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String fornecedor = null;
                acesso.Sessao sessao = new acesso.Sessao(session);
                if(sessao.getTipoEntidadeNegocio().equals("FORNECEDOR")){
                  fornecedor = sessao.getChave();
                }
                %>


                <%
                if(fornecedor==null){
                  %>
                  <script>
                    jQuery(document).ready(function($) {
                      $("#forn_codigo").focus();
                      });
                    </script>
                    <%
                  } else {
                    %>
                    <script>
                      jQuery(document).ready(function($) {
                        $("#numero").focus();
                        });
                      </script>
                      <%
                    }
                    %>
                    <%
                    if(fornecedor==null){
                      %>
                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Fornecedor
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="forn_codigo" styleId="forn_codigo" onblur="fillFields(0,new Array('forn_codigo'),'NecessidadeInsumosActionForm.getForn_razsoc_Ajax',new Array('forn_razsoc'));" styleClass="baseField" size="10"/>
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

                      <html:hidden property="forn_codigo" value="<%= fornecedor %>"/>
                      <html:hidden property="forn_razsoc" />

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
                        <html:text property="fil_filial" styleId="fil_filial" onblur="javascript:toUpperCase(this);fillFields(0,new Array('fil_filial'),'NecessidadeInsumosActionForm.getFil_razsoc_Ajax',new Array('fil_razsoc'));" styleClass="baseField" size="5"/>
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
                          Grupo de Material
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="gpo_mater_cdgo" styleId="gpo_mater_cdgo" onblur="fillFields(0,new Array('gpo_mater_cdgo'),'NecessidadeInsumosActionForm.getGpo_mater_desc_Ajax',new Array('gpo_mater_desc'));" styleClass="baseField" size="7"/>
                        <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_gpo_mater_cdgo()"  >
                        <script type="text/javascript">
                          function lov_open_gpo_mater_cdgo() {
                            window.open('..//lov/LvGrupoMaterialLov.do?resetfull_action=&returnBlock=0&return0=gpo_mater_cdgo&return1=gpo_mater_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                          }
                        </script>
                        <span class="spamFormLabel">
                        </span>
                        <html:text property="gpo_mater_desc" styleId="gpo_mater_desc" styleClass="disabled" tabindex="-1" readonly="true" size="45"/>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Material
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="codigo_material" styleId="codigo_material" onblur="fillFields(0,new Array('codigo_material'),'NecessidadeInsumosActionForm.getDescricao_material_Ajax',new Array('descricao_material'));" styleClass="baseField" size="12"/>
                        <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_material()"  >
                        <script type="text/javascript">
                          function lov_open_codigo_material() {
                            window.open('..//lov/ItemLov.do?resetfull_action=&returnBlock=0&return0=codigo_material&return1=descricao_material','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                          }
                        </script>
                        <span class="spamFormLabel">
                        </span>
                        <html:text property="descricao_material" styleId="descricao_material" styleClass="disabled" tabindex="-1" readonly="true" size="100"/>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Cor
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="cor_cdgo" styleId="cor_cdgo" onblur="fillFields(0,new Array('cor_cdgo'),'NecessidadeInsumosActionForm.getCor_desc_Ajax',new Array('cor_desc'));" styleClass="baseField" size="8"/>
                        <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cor_cdgo()"  >
                        <script type="text/javascript">
                          function lov_open_cor_cdgo() {
                            window.open('..//lov/LvCorLov.do?resetfull_action=&returnBlock=0&return0=cor_cdgo&return1=cor_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                          }
                        </script>
                        <span class="spamFormLabel">
                        </span>
                        <html:text property="cor_desc" styleId="cor_desc" styleClass="disabled" tabindex="-1" readonly="true" size="60"/>
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
                        <html:text property="numero" styleId="numero" styleClass="baseField" size="22" maxlength="22"/>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Data Inicial
                          <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="data_inicial" styleId="data_inicial" styleClass="baseField" size="10"/>
                        &nbsp;
                        <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_inicial']); cal1.year_scroll = true; cal1.popup();">
                          <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                        </a>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Data Final
                          <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="data_final" styleId="data_final" styleClass="baseField" size="10"/>
                        &nbsp;
                        <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_final']); cal1.year_scroll = true; cal1.popup();">
                          <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                        </a>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Somente Primeiro Nível
                        </span>
                      </td>
                      <td class="formField">
                        <html:select property="somente_primeiro_nivel" styleId="somente_primeiro_nivel" styleClass="baseField" size="1">
                          <html:option styleClass="baseOption" value="N">
                            Não
                          </html:option>
                          <html:option styleClass="baseOption" value="S">
                            Sim
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
                        </td>
                        </tr>
                        </table>

                        <script type="text/javascript">
                        jQuery(document).ready(function($) {
                          $("#data_inicial").mask("99/99/9999");
                          $("#data_final").mask("99/99/9999");
                          });
                        </script>
                      </html:form>
                    </td>
                  </tr>
                </table>

              </body>
            </center>
          </html>

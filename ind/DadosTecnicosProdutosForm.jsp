<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/DadosTecnicosProdutosActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = DadosTecnicosProdutosActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("tipo_relatorio","Tipo de Relatório");
    hashMapLabel.set("f_catalogoi","");
    hashMapLabel.set("gre_grupo","Grupo Econômico");
    hashMapLabel.set("gre_descricao","");
    hashMapLabel.set("cli_cdgo","Cliente");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("f_catalogof","");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("ref_cdgo","Ref.");
    hashMapLabel.set("ref_desc","");
    hashMapLabel.set("cab_cdgo","Cabedal");
    hashMapLabel.set("cab_desc","");
    hashMapLabel.set("cor_cdgo","Cor");
    hashMapLabel.set("cor_desc","");
    hashMapLabel.set("mix_produtos","Mix Produtos");
    hashMapLabel.set("marca","Marca");
    hashMapLabel.set("f_catalogodi","");
    hashMapLabel.set("tipo","Tipo");
    hashMapLabel.set("ped_dadg_inicial","Período de");
    hashMapLabel.set("ped_dadg_final","a");
    hashMapLabel.set("ano_fatura","Ano da Fatura");
    hashMapLabel.set("numero_fatura","Número da Fatura");
    hashMapLabel.set("f_i","	");
    hashMapLabel.set("pedidos","Pedidos");
    hashMapLabel.set("ocs","OCs");
    hashMapLabel.set("cb_tamanhos_pedidos","Somente tamanhos existentes nos pedidos");
    hashMapLabel.set("f_f","");
    hashMapLabel.set("f_catalogodf","");
    hashMapLabel.set("gerar_planilha","Gerar Planilha");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Consulta Dados Técnicos dos Produtos
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(228)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/DadosTecnicosProdutosForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <div class\='div10l'>
                        Um dos campos com
                        <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        deve ser preenchido.
                      </div>
                      <div class\='div10l'>
                        Todos os campos com
                        <img src='../img/required.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        devem ser preenchidos.
                      </div>
                    </div>
                    <html:errors property="tipo_relatorio"/>
                    <html:errors property="gre_grupo"/>
                    <html:errors property="gre_descricao"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="ref_desc"/>
                    <html:errors property="cab_cdgo"/>
                    <html:errors property="cab_desc"/>
                    <html:errors property="cor_cdgo"/>
                    <html:errors property="cor_desc"/>
                    <html:errors property="mix_produtos"/>
                    <html:errors property="marca"/>
                    <html:errors property="tipo"/>
                    <html:errors property="ped_dadg_inicial"/>
                    <html:errors property="ped_dadg_final"/>
                    <html:errors property="ano_fatura"/>
                    <html:errors property="numero_fatura"/>
                    <html:errors property="pedidos"/>
                    <html:errors property="ocs"/>
                    <html:errors property="cb_tamanhos_pedidos"/>
                    <html:errors property="gerar_planilha"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_dados_tecnicos_produtos"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                portalbr.ind.DadosTecnicosProdutosActionForm dadosTecnicosProdutosActionForm = (portalbr.ind.DadosTecnicosProdutosActionForm)session.getAttribute("DadosTecnicosProdutosActionForm");
                String tipoRelatorio = dadosTecnicosProdutosActionForm.getTipo_relatorio()+"";
                String codigoCliente = "";
                String codigoGrupoEconomico = null;
                acesso.Sessao sessao = new acesso.Sessao(session);
                if(sessao.getTipoEntidadeNegocio().equals("CLIENTE MERCADO INTERNO") ||sessao.getTipoEntidadeNegocio().equals("CLIENTE MERCADO EXTERNO")){
                  codigoCliente = sessao.getChave();
                }
                if(sessao.getTipoEntidadeNegocio().equals("GRUPO ECONOMICO")){
                  codigoGrupoEconomico = sessao.getChave();
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo de Relatório
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo_relatorio" styleId="tipo_relatorio" onchange="refresh_action.click();" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="produto">
                        Por Produto
                      </html:option>
                      <html:option styleClass="baseOption" value="pedido">
                        Por Pedido
                      </html:option>

                      <%
                      if(codigoGrupoEconomico == null) {
                        %>
                        <html:option styleClass="baseOption" value="catalogo">
                          Por Catálogo
                        </html:option>
                        <%
                      }
                      %>

                      <html:option styleClass="baseOption" value="fatura">
                        Por Fatura
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <%
                if(!tipoRelatorio.equalsIgnoreCase("catalogo")){
                  %>
                  <%
                  if(codigoCliente.equals("") && codigoGrupoEconomico == null){
                    %>
                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Grupo Econômico
                        </span>
                        <%
                        if(!(dadosTecnicosProdutosActionForm.getTipo_relatorio()+"").equalsIgnoreCase("fatura")){
                          %>
                          <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                          <%
                        }
                        %>
                      </td>
                      <td class="formField">
                        <html:text property="gre_grupo" styleId="gre_grupo" onblur="fillFields(0,new Array('gre_grupo'),'DadosTecnicosProdutosActionForm.getGre_descricao_Ajax',new Array('gre_descricao'));" styleClass="baseField" size="6"/>
                        <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_gre_grupo()"  >
                        <script type="text/javascript">
                          function lov_open_gre_grupo() {
                            window.open('..//lov/LvGrupoEconomicoLov.do?resetfull_action=&returnBlock=0&return0=gre_grupo&return1=gre_descricao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                          }
                        </script>
                        <span class="spamFormLabel">
                        </span>
                        <html:text property="gre_descricao" styleId="gre_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="30"/>
                      </td>
                    </tr>

                    <%
                  } else {
                    %>

                    <%
                    if(codigoGrupoEconomico != null) {
                      %>
                      <html:hidden property="gre_grupo" value="<%= codigoGrupoEconomico %>"/>
                      <html:hidden property="gre_descricao"  />
                      <%
                    } else {
                      %>
                      <html:hidden property="gre_grupo" />
                      <html:hidden property="gre_descricao"  />
                      <%
                    }
                    %>
                    <%
                  }
                  %>
                  <%
                  if(codigoCliente.equals("")){
                    %>
                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Cliente
                        </span>
                        <%
                        if(!(dadosTecnicosProdutosActionForm.getTipo_relatorio()+"").equalsIgnoreCase("fatura")){
                          %>
                          <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                          <%
                        }
                        %>
                      </td>
                      <td class="formField">
                        <html:text property="cli_cdgo" styleId="cli_cdgo" onblur="fillFields(0,new Array('cli_cdgo'),'DadosTecnicosProdutosActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));" styleClass="baseField" size="10"/>
                        <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cli_cdgo()"  >
                        <script type="text/javascript">
                          function lov_open_cli_cdgo() {
                            window.open('..//lov/LvClienteLov.do?resetfull_action=&returnBlock=0&return0=cli_cdgo&return1=cli_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                          }
                        </script>
                        <span class="spamFormLabel">
                        </span>
                        <html:text property="cli_rzao" styleId="cli_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="55" maxlength="50"/>
                      </td>
                    </tr>

                    <%
                  } else {
                    %>

                    <html:hidden property="cli_cdgo" value="<%= codigoCliente %>"/>
                    <html:hidden property="cli_rzao" />

                    <%
                  }
                  %>
                  <%
                } else {
                  %>

                  <html:hidden property="gre_grupo" value="" />
                  <html:hidden property="gre_descricao" value=""/>
                  <html:hidden property="cli_cdgo" value=""/>
                  <html:hidden property="cli_rzao" value=""/>


                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                    <%
                    if(!(dadosTecnicosProdutosActionForm.getTipo_relatorio()+"").equalsIgnoreCase("fatura")){
                      %>
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      <%
                    }
                    %>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" onblur="fillFields(0,new Array('lin_cdgo'),'DadosTecnicosProdutosActionForm.getLin_nome_Ajax',new Array('lin_nome'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('..//lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_nome" styleId="lin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="25"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Ref.
                    </span>
                    <%
                    if(!(dadosTecnicosProdutosActionForm.getTipo_relatorio()+"").equalsIgnoreCase("fatura")){
                      %>
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      <%
                    }
                    %>
                  </td>
                  <td class="formField">
                    <html:text property="ref_cdgo" styleId="ref_cdgo" onblur="fillFields(0,new Array('lin_cdgo','ref_cdgo'),'DadosTecnicosProdutosActionForm.getRef_desc_Ajax',new Array('ref_desc'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_ref_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_ref_cdgo() {
                        window.open('..//lov/LvRefLov.do?resetfull_action=&returnBlock=0&return0=ref_cdgo','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="ref_desc" styleId="ref_desc" styleClass="disabled" tabindex="-1" readonly="true" size="25"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cabedal
                    </span>
                    <%
                    if(!(dadosTecnicosProdutosActionForm.getTipo_relatorio()+"").equalsIgnoreCase("fatura")){
                      %>
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      <%
                    }
                    %>
                  </td>
                  <td class="formField">
                    <html:text property="cab_cdgo" styleId="cab_cdgo" onblur="fillFields(0,new Array('cab_cdgo'),'DadosTecnicosProdutosActionForm.getCab_desc_Ajax',new Array('cab_desc'));" styleClass="baseField" size="5"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cab_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_cab_cdgo() {
                        window.open('..//lov/LvCabedalLov.do?resetfull_action=&returnBlock=0&return0=cab_cdgo&return1=cab_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cab_desc" styleId="cab_desc" styleClass="disabled" tabindex="-1" readonly="true" size="45"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cor
                    </span>
                    <%
                    if(!(dadosTecnicosProdutosActionForm.getTipo_relatorio()+"").equalsIgnoreCase("fatura")){
                      %>
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      <%
                    }
                    %>
                  </td>
                  <td class="formField">
                    <html:text property="cor_cdgo" styleId="cor_cdgo" onblur="fillFields(0,new Array('cor_cdgo'),'DadosTecnicosProdutosActionForm.getCor_desc_Ajax',new Array('cor_desc'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cor_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_cor_cdgo() {
                        window.open('..//lov/LvCorLov.do?resetfull_action=&returnBlock=0&return0=cor_cdgo&return1=cor_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cor_desc" styleId="cor_desc" styleClass="disabled" tabindex="-1" readonly="true" size="65"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Mix Produtos
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="mix_produtos" styleId="mix_produtos" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="T">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="M">
                        Sim
                      </html:option>
                      <html:option styleClass="baseOption" value="F">
                        Não
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                    <%
                    if(!(dadosTecnicosProdutosActionForm.getTipo_relatorio()+"").equalsIgnoreCase("fatura")){
                      %>
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      <%
                    }
                    %>
                  </td>
                  <td class="formField">
                    <html:select property="marca" styleId="marca" styleClass="baseField" size="1">
                      <html:options property="marcaList" labelProperty="marcaLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <%
                if(!tipoRelatorio.equalsIgnoreCase("catalogo")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Tipo de Produto
                      </span>
                      <%
                      if(!(dadosTecnicosProdutosActionForm.getTipo_relatorio()+"").equalsIgnoreCase("fatura")){
                        %>
                        <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                        <%
                      }
                      %>

                    </td>
                    <td class="formField">
                      <html:select property="tipo" styleId="tipo" styleClass="baseField" size="1">
                        <html:options property="tipoList" labelProperty="tipoLabelList" styleClass="baseOptions"/>
                      </html:select>
                    </td>
                  </tr>

                  <%
                  if(!(dadosTecnicosProdutosActionForm.getTipo_relatorio()+"").equalsIgnoreCase("fatura")){
                    %>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Período de
                        </span>
                        <bean:message key="jsp.fieldnotnull"/>
                      </td>
                      <td class="formField">
                        <html:text property="ped_dadg_inicial" styleId="ped_dadg_inicial" styleClass="baseField" size="10"/>
                         
                        <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['ped_dadg_inicial']); cal1.year_scroll = true; cal1.popup();">
                          <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                        </a>

                        <%
                      } else {
                        %>

                        <html:hidden property="ped_dadg_inicial" />

                        <%
                      }
                      %>
                      <%
                      if(!(dadosTecnicosProdutosActionForm.getTipo_relatorio()+"").equalsIgnoreCase("fatura")){
                        %>
                        <span class="spamFormLabel">
                          a
                        </span>
                        <html:text property="ped_dadg_final" styleId="ped_dadg_final" styleClass="baseField" size="10"/>
                         
                        <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['ped_dadg_final']); cal1.year_scroll = true; cal1.popup();">
                          <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                        </a>
                        <b>
                          <font color="red">
                            <i>
                              Obrigatório ao informar grupo econômico, cliente ou tipo de relatório por pedido
                            </i>
                            <font>
                            </b>
                          </td>
                        </tr>
                        <%
                      } else {
                        %>

                        <html:hidden property="ped_dadg_final" />

                        <%
                      }
                      %>

                      <%
                      if((dadosTecnicosProdutosActionForm.getTipo_relatorio()+"").equalsIgnoreCase("fatura")){
                        %>
                        <tr class="itemTr">
                          <td class="formLabel">
                            <span class="spamFormLabel">
                              Ano da Fatura
                            </span>
                            <bean:message key="jsp.fieldnotnull"/>
                          </td>
                          <td class="formField">
                            <html:text property="ano_fatura" styleId="ano_fatura" styleClass="baseField" size="4"/>
                          </td>
                        </tr>

                        <%
                      } else {
                        %>

                        <html:hidden property="ano_fatura" />

                        <%
                      }
                      %>

                      <%
                      if((dadosTecnicosProdutosActionForm.getTipo_relatorio()+"").equalsIgnoreCase("fatura")){
                        %>
                        <tr class="itemTr">
                          <td class="formLabel">
                            <span class="spamFormLabel">
                              Número da Fatura
                            </span>
                            <bean:message key="jsp.fieldnotnull"/>
                          </td>
                          <td class="formField">
                            <html:text property="numero_fatura" styleId="numero_fatura" styleClass="baseField" size="5"/>
                          </td>
                        </tr>
                        <%
                      } else {
                        %>

                        <html:hidden property="numero_fatura" />

                        <%
                      }
                      %>
                    </table>

                    <%
                    if(!(dadosTecnicosProdutosActionForm.getTipo_relatorio()+"").equalsIgnoreCase("fatura")){
                      %>

                      <table class="separatorTable">
                        <tr class="separatorTr">
                          <td colspan="2" class="separatorTd">
                            Consulta Direta
                          </td>
                        </tr>
                        <tr class="itemTr">
                          <td class="formLabel">
                            <span class="spamFormLabel">
                              Pedidos
                            </span>
                          </td>
                          <td class="formField">
                            <html:textarea property="pedidos" styleId="pedidos" styleClass="baseField" cols="60" rows="4"/>
                          </td>
                        </tr>

                        <tr class="itemTr">
                          <td class="formLabel">
                            <span  class="spamFormLabel">
                              OCs
                            </span>
                          </td>
                          <td class="formField">
                            <html:textarea property="ocs" styleId="ocs" styleClass="baseField" cols="60" rows="4"/>
                          </td>
                        </tr>
                        <tr class="itemTr">
                          <td class="formLabel">
                            <span class="spamFormLabel">
                              Somente tamanhos existentes nos pedidos
                            </span>
                          </td>
                          <td class="formField">
                            <html:checkbox property="cb_tamanhos_pedidos" styleId="cb_tamanhos_pedidos" styleClass="baseField" value="1"/>
                          </td>
                        </tr>

                      </table>
                      <%
                    } else {
                      %>

                      <html:hidden property="cb_tamanhos_pedidos" />
                      <html:hidden property="pedidos" />
                      <html:hidden property="ocs" />

                      <%
                    }
                    %>
                    <table class="itemTable" style='width:99%;'>
                      <%
                    } else {
                      %>

                      <html:hidden property="tipo" value=""/>
                      <html:hidden property="ped_dadg_inicial" value=""/>
                      <html:hidden property="ped_dadg_final" value=""/>
                      <html:hidden property="pedidos" value=""/>


                      <%
                    }
                    %>
                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Gerar Planilha
                        </span>
                      </td>
                      <td class="formField">
                        <html:checkbox property="gerar_planilha" styleId="gerar_planilha" styleClass="baseField" value="S"/>
                      </td>
                    </tr>

                    <%
                    if((String)request.getAttribute("abre_automaticamente")=="N"){
                      %>
                      <%
                      if(request.getAttribute("arquivo")!=null){
                        %>
                        <table style=width:100%;margin-top:10;>
                          <tr>
                            <td class=columHeader style="text-align:center;">
                              <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                                <bean:message key="report.downloadxls"/>
                              </a>
                            </td>
                          </tr>
                        </table>
                        <%
                      }
                      %>
                      <%
                    }
                    %>
                  </table>

                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:button accesskey="p" onclick="bloqueia();resetfull1_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
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
                      </SCRIPT><html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                      <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key=""/></html:submit>
                      <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                      <html:submit accesskey="l" styleClass="myhidden" property="refresh_action"><bean:message bundle="ApplicationResources" key="jsp.refresh"/></html:submit>
                      </td>
                      </tr>
                      </table>

                      <script type="text/javascript">
                      jQuery(document).ready(function($) {
                        $("#ped_dadg_inicial").mask("99/99/9999");
                        $("#ped_dadg_final").mask("99/99/9999");
                        });
                      </script>
                    </html:form>
                    <script type="text/javascript">
                      var focusControl = document.forms[0].elements["gre_grupo"];
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

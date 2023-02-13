<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/FichaClienteActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = FichaClienteActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("cli_cdgo1","Código do Cliente");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("situacao_cliente","Situação Cliente");
    hashMapLabel.set("cnpj","CNPJ do Cliente");
    hashMapLabel.set("razao_social","Razão Social");
    hashMapLabel.set("cidade","Cidade do Cliente");
    hashMapLabel.set("gre_grupo","Grupo Econômico");
    hashMapLabel.set("gre_descricao","");
    hashMapLabel.set("codigo_regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("marca","Marca");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("limite_inicial","Limite de");
    hashMapLabel.set("limite_final"," a ");
    hashMapLabel.set("data_inicial","Data Inicial");
    hashMapLabel.set("data_final","Data Final");
    var reportColumns = new Array(new Array("gre_grupo","gre_descricao","cli_cdgo","esc_seqn","cli_rzao","cnpj","cidade"));
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Ficha do Cliente
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(5)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/FichaClienteForm.do" method="post" styleClass="baseForm">
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
                    <html:errors property="cli_cdgo1"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="situacao_cliente"/>
                    <html:errors property="cnpj"/>
                    <html:errors property="razao_social"/>
                    <html:errors property="cidade"/>
                    <html:errors property="gre_grupo"/>
                    <html:errors property="gre_descricao"/>
                    <html:errors property="codigo_regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="marca"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="limite_inicial"/>
                    <html:errors property="limite_final"/>
                    <html:errors property="data_inicial"/>
                    <html:errors property="data_final"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_ficha_cliente"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String regional = "";
                String regional_descricao = "";
                String representante = "";
                String representante_descricao = "";
                String cliente = "";
                String analista = "";
                util.consultas.Query qr = new util.consultas.Query();
                java.util.Date dataAno = new java.util.Date();
                java.text.SimpleDateFormat fDataAno = new java.text.SimpleDateFormat("yyyy");
                String ano = fDataAno.format(dataAno);
                acesso.Sessao sessao = new acesso.Sessao(session);

                if(sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")){
                  regional = sessao.getChave();
                  regional_descricao = qr.retorna("SELECT nome_regional FROM regionais_vendas WHERE codigo_regional = " + regional);
                }

                if((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")){
                  representante = sessao.getChave();
                  representante_descricao = qr.retorna("SELECT rep_rzao from rep WHERE rep_cdgo = '"+representante+"'");
                }

                if(sessao.getTipoEntidadeNegocio().equals("CLIENTE MERCADO INTERNO")){
                  cliente = sessao.getChave();
                }

                if(sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")){
                  regional  = qr.retorna("SELECT codigo_regional FROM analistas_regionais WHERE codigo_gerente = " + sessao.getChave());
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Código do Cliente
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="cli_cdgo1" styleId="cli_cdgo1" onblur="fillFields(0,new Array('cli_cdgo1'),'FichaClienteActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));" styleClass="baseField" size="10"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cli_cdgo1()"  >
                    <script type="text/javascript">
                      function lov_open_cli_cdgo1() {
                        window.open('..//lov/LvClienteLov.do?resetfull_action=&returnBlock=0&return0=cli_cdgo1','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cli_rzao" styleId="cli_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="43"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situação Cliente
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="situacao_cliente" styleId="situacao_cliente" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="A">
                        Ativo
                      </html:option>
                      <html:option styleClass="baseOption" value="I">
                        Inativo
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      CNPJ do Cliente
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="cnpj" styleId="cnpj" styleClass="baseField" size="16"/>
                  </td>
                </tr>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Razão Social
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="razao_social" styleId="razao_social" styleClass="baseField" size="40"/>
                  </td>
                </tr>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cidade do Cliente
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="cidade" styleId="cidade" styleClass="baseField" size="25"/>
                  </td>
                </tr>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Grupo Econômico
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="gre_grupo" styleId="gre_grupo" onblur="fillFields(0,new Array('gre_grupo'),'FichaClienteActionForm.getGre_descricao_Ajax',new Array('gre_descricao'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_gre_grupo()"  >
                    <script type="text/javascript">
                      function lov_open_gre_grupo() {
                        window.open('..//lov/LvGrupoEconomicoLov.do?resetfull_action=&returnBlock=0&return0=gre_grupo&return1=gre_descricao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="gre_descricao" styleId="gre_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="65" maxlength="60"/>
                  </td>
                </tr>

                <%
                if(regional.equals("")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Regional
                      </span>
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </td>
                    <td class="formField">
                      <html:text property="codigo_regional" styleId="codigo_regional" onblur="fillFields(0,new Array('codigo_regional'),'FichaClienteActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="baseField" size="3"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_regional()"  >
                      <%
                    } else {
                      %>
                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Regional
                          </span>
                          <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                        </td>
                        <td class="formField">
                          <html:text property="codigo_regional" value="<%= regional %>" styleId="codigo_regional" tabindex="-1" readonly="true" styleClass="disabled" size="3"/>
                          <input type="button" class="lovButton" tabindex="-1" value="..." disabled="true"  >

                          <%
                        }
                        %>


                        <script type="text/javascript">
                          function lov_open_codigo_regional() {
                            window.open('..//lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=codigo_regional&return1=nome_regional','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                          }
                        </script>
                        <%
                        if(regional.equals("")){
                          %>
                          <span class="spamFormLabel">
                          </span>
                          <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>
                        </td>
                      </tr>

                      <%
                    } else {
                      %>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="nome_regional" value="<%= regional_descricao %>" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>
                    </td>
                  </tr>
                  <%
                }
                %>
                <%
                if(representante.equals("")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Representante
                      </span>
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </td>
                    <td class="formField">
                      <html:text property="rep_cdgo" styleId="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'FichaClienteActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="5"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                      <%
                    } else {
                      %>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Representante
                          </span>
                          <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                        </td>
                        <td class="formField">
                          <html:text property="rep_cdgo" value="<%= representante %>" styleId="rep_cdgo"  styleClass="disabled" readonly="true" tabindex="-1" size="5"/>
                          <input type="button" class="lovButton" tabindex="-1" value="..." disabled="true"  >

                          <%
                        }
                        %>

                        <script type="text/javascript">
                          function lov_open_rep_cdgo() {
                            window.open('..//lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                          }
                        </script>
                        <%
                        if(representante.equals("")){
                          %>
                          <span class="spamFormLabel">
                          </span>
                          <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                        </td>
                      </tr>
                      <%
                    } else {
                      %>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="rep_rzao" value="<%= representante_descricao %>" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                    </td>
                  </tr>
                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="marca" styleId="marca" styleClass="baseField" size="1">
                      <html:options property="marcaList" labelProperty="marcaLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" onblur="fillFields(0,new Array('lin_cdgo'),'FichaClienteActionForm.getLin_nome_Ajax',new Array('lin_nome'));" styleClass="baseField" size="7"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('..//lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_nome" styleId="lin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="25"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Limite de
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="limite_inicial" styleId="limite_inicial" styleClass="baseField" size="10"/>
                    <span class="spamFormLabel">
                      a
                    </span>
                    <html:text property="limite_final" styleId="limite_final" styleClass="baseField" size="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Inicial
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="data_inicial" styleId="data_inicial" styleClass="baseField" size="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_inicial']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr2">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Final
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField2">
                    <html:text property="data_final" styleId="data_final" styleClass="baseField" size="10"/>
                     
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                    OBS: O intervalo de datas não pode ser maior que 12 meses!
                  </td>
                </tr>
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
                  <html:submit onclick="populaDatas();" styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                  <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                  </td>
                  </tr>
                  </table>

                  <script type="text/javascript">
                  jQuery(document).ready(function($) {
                    $("#data_inicial").mask("99/99/9999");
                    $("#data_final").mask("99/99/9999");
                    });


                    function populaDatas(){
                      hoje = new Date();
                      ano = hoje.getFullYear();
                      data_inicial = '01/01/'+ano;
                      data_final = '31/12/'+ano;

                      if(document.forms[0].data_inicial.value==''){
                        document.forms[0].data_inicial.value=data_inicial;
                      }
                      if(document.forms[0].data_final.value==''){
                        document.forms[0].data_final.value=data_final;
                      }
                    }


                    populaDatas();
                  </script>
                </html:form>
                <script type="text/javascript">
                  var focusControl = document.forms[0].elements["cli_cdgo1"];
                  if (focusControl.type != "hidden"){
                    focusControl.focus();
                  }
                </script>

                <%
                {
                  %>

                  <%
                  java.util.Vector res_Jw_clientes_ficha_cliente = (java.util.Vector)session.getAttribute("res_Jw_clientes_ficha_cliente");
                  %>

                  <form  name="bl_report_Jw_clientes_ficha_cliente" id="bl_report_Jw_clientes_ficha_cliente" class="baseForm" method="post" >
                    <%
                    if (res_Jw_clientes_ficha_cliente!=null && res_Jw_clientes_ficha_cliente.size()>0) {
                      %>

                      <table id="TRbl_report_Jw_clientes_ficha_cliente"  class="reportTable"   style="width:99%; "  border="1" >
                        <%
                        java.lang.Integer gre_grupo =  null;
                        java.lang.String gre_descricao =  null;
                        java.lang.Integer cli_cdgo =  null;
                        java.lang.Integer esc_seqn =  null;
                        java.lang.String cli_rzao =  null;
                        java.lang.String cnpj =  null;
                        java.lang.String cidade =  null;
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:right;" >
                            Grupo
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Descrição
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Cliente
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Seq.
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Razão Social
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            CNPJ
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Cidade
                          </td>

                        </tr>

                        <%
                        int i_bl_report_Jw_clientes_ficha_cliente = 0;
                        while (i_bl_report_Jw_clientes_ficha_cliente<res_Jw_clientes_ficha_cliente.size()) {
                          portalbr.dbobj.view.Jw_clientes_ficha_cliente t_jw_clientes_ficha_cliente = (portalbr.dbobj.view.Jw_clientes_ficha_cliente)res_Jw_clientes_ficha_cliente.elementAt(i_bl_report_Jw_clientes_ficha_cliente);
                          gre_grupo = t_jw_clientes_ficha_cliente.getGre_grupo();
                          gre_descricao = t_jw_clientes_ficha_cliente.getGre_descricao()==null?"":t_jw_clientes_ficha_cliente.getGre_descricao();
                          cli_cdgo = t_jw_clientes_ficha_cliente.getCli_cdgo();
                          esc_seqn = t_jw_clientes_ficha_cliente.getEsc_seqn();
                          cli_rzao = t_jw_clientes_ficha_cliente.getCli_rzao()==null?"":t_jw_clientes_ficha_cliente.getCli_rzao();
                          cnpj = t_jw_clientes_ficha_cliente.getCnpj()==null?"":t_jw_clientes_ficha_cliente.getCnpj();
                          cidade = t_jw_clientes_ficha_cliente.getCidade()==null?"":t_jw_clientes_ficha_cliente.getCidade();
                          String style_bl_report_Jw_clientes_ficha_cliente="";
                          if (!((i_bl_report_Jw_clientes_ficha_cliente%2)!=0)) {
                            style_bl_report_Jw_clientes_ficha_cliente="rowColor";
                          } else {
                            style_bl_report_Jw_clientes_ficha_cliente="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Jw_clientes_ficha_cliente %>' id="TRbl_report_Jw_clientes_ficha_cliente<%=i_bl_report_Jw_clientes_ficha_cliente%>" >
                            <td class="reportColumn" style="text-align:right;" >
                              <a href="../com/FichaCliente_dForm.do?select_action=&gre_grupo=<%= gre_grupo %>" style="cursor:hand" onclick="bloqueia();">
                                <%= ((gre_grupo!=null)?gre_grupo.toString():"") %>
                              </a>

                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <a href="../com/FichaCliente_dForm.do?select_action=&gre_grupo=<%= gre_grupo %>" style="cursor:hand" onclick="bloqueia();">
                                <%= gre_descricao %>
                              </a>

                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <a href="../com/FichaCliente_dForm.do?select_action=&cli_cdgo=<%= cli_cdgo %>&esc_seqn=<%= esc_seqn %>" style="cursor:hand" onclick="bloqueia();">
                                <%= ((cli_cdgo!=null)?cli_cdgo.toString():"") %>
                              </a>

                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= ((esc_seqn!=null)?esc_seqn.toString():"") %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <a href="../com/FichaCliente_dForm.do?select_action=&cli_cdgo=<%= cli_cdgo %>&esc_seqn=<%= esc_seqn %>" style="cursor:hand" onclick="bloqueia();">
                                <%= cli_rzao %>
                              </a>

                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <%= cnpj %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <%= cidade %>
                            </td>

                          </tr>

                          <%
                          i_bl_report_Jw_clientes_ficha_cliente++;
                          if (i_bl_report_Jw_clientes_ficha_cliente<res_Jw_clientes_ficha_cliente.size()) {
                            t_jw_clientes_ficha_cliente = (portalbr.dbobj.view.Jw_clientes_ficha_cliente)res_Jw_clientes_ficha_cliente.elementAt(i_bl_report_Jw_clientes_ficha_cliente);
                            gre_grupo = t_jw_clientes_ficha_cliente.getGre_grupo();
                            gre_descricao = t_jw_clientes_ficha_cliente.getGre_descricao()==null?"":t_jw_clientes_ficha_cliente.getGre_descricao();
                            cli_cdgo = t_jw_clientes_ficha_cliente.getCli_cdgo();
                            esc_seqn = t_jw_clientes_ficha_cliente.getEsc_seqn();
                            cli_rzao = t_jw_clientes_ficha_cliente.getCli_rzao()==null?"":t_jw_clientes_ficha_cliente.getCli_rzao();
                            cnpj = t_jw_clientes_ficha_cliente.getCnpj()==null?"":t_jw_clientes_ficha_cliente.getCnpj();
                            cidade = t_jw_clientes_ficha_cliente.getCidade()==null?"":t_jw_clientes_ficha_cliente.getCidade();
                          } else {
                          }
                        }
                        %>

                      </table>

                      <%
                    }
                    %>

                  </form>
                  <%
                }
                %>

              </td>
            </tr>
          </table>

        </body>
      </center>
    </html>

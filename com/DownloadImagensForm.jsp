<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/DownloadImagensActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = DownloadImagensActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("marca","Marca<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("descricao_marca","");
    hashMapLabel.set("lin_cdgo","Linha<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("ref_cdgo","Referência");
    hashMapLabel.set("ref_desc","");
    hashMapLabel.set("cab_cdgo","Cabedal");
    hashMapLabel.set("cab_desc","");
    hashMapLabel.set("cor_cdgo","Cor");
    hashMapLabel.set("cor_desc","");
    hashMapLabel.set("oc","OC<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("invoice","Invoice<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("lotes","Lotes<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("pedido","Pedidos<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("status_pedido","");
    hashMapLabel.set("situacao_pedido","");
    hashMapLabel.set("gre_grupo","Grupo Econômico<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("gre_descricao","");
    hashMapLabel.set("cli_cdgo","Cliente<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("dt_inicial","Dt. Digit. Inicial<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("dt_final","Dt. Digit. Final<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    hashMapLabel.set("tamanho_imagens","Tamanho das Imagens");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Download de Imagens
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(208)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/DownloadImagensForm.do" method="post" styleClass="baseForm">
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
                    <html:errors property="marca"/>
                    <html:errors property="descricao_marca"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="ref_desc"/>
                    <html:errors property="cab_cdgo"/>
                    <html:errors property="cab_desc"/>
                    <html:errors property="cor_cdgo"/>
                    <html:errors property="cor_desc"/>
                    <html:errors property="oc"/>
                    <html:errors property="invoice"/>
                    <html:errors property="lotes"/>
                    <html:errors property="pedido"/>
                    <html:errors property="gre_grupo"/>
                    <html:errors property="gre_descricao"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="dt_inicial"/>
                    <html:errors property="dt_final"/>
                    <html:errors property="tamanho_imagens"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_cat_produtos"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String codigoCliente = null;
                String codigoGrupoEconomico = null;
                acesso.Sessao sessao = new acesso.Sessao(session);
                if(sessao.getTipoEntidadeNegocio().equals("CLIENTE MERCADO EXTERNO") ||sessao.getTipoEntidadeNegocio().equals("CLIENTE MERCADO INTERNO")){
                  codigoCliente = sessao.getChave();
                }
                if(sessao.getTipoEntidadeNegocio().equals("GRUPO ECONOMICO")){
                  codigoGrupoEconomico = sessao.getChave();
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="marca" styleId="marca" onblur="fillFields(0,new Array('marca'),'DownloadImagensActionForm.getDescricao_marca_Ajax',new Array('descricao_marca'));" styleClass="baseField" size="3" maxlength="22"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_marca()"  >
                    <script type="text/javascript">
                      function lov_open_marca() {
                        window.open('..//lov/LvMarcaLov.do?resetfull_action=&returnBlock=0&return0=marca&return1=descricao_marca','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="descricao_marca" styleId="descricao_marca" styleClass="disabled" tabindex="-1" readonly="true" size="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" onblur="fillFields(0,new Array('lin_cdgo'),'DownloadImagensActionForm.getLin_nome_Ajax',new Array('lin_nome'));" styleClass="baseField" size="10"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('..//lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_nome" styleId="lin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Referência
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ref_cdgo" styleId="ref_cdgo" onblur="fillFields(0,new Array('lin_cdgo','ref_cdgo'),'DownloadImagensActionForm.getRef_desc_Ajax',new Array('ref_desc'));" styleClass="baseField" size="10"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_ref_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_ref_cdgo() {
                        window.open('..//lov/LvLinhaRefLov.do?resetfull_action=&returnBlock=0&return0=ref_cdgo&return1=ref_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="ref_desc" styleId="ref_desc" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cabedal
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cab_cdgo" styleId="cab_cdgo" onblur="fillFields(0,new Array('cab_cdgo'),'DownloadImagensActionForm.getCab_desc_Ajax',new Array('cab_desc'));" styleClass="baseField" size="10"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cab_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_cab_cdgo() {
                        window.open('..//lov/LvCabedalLov.do?resetfull_action=&returnBlock=0&return0=cab_cdgo&return1=cab_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cab_desc" styleId="cab_desc" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cor
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cor_cdgo" styleId="cor_cdgo" onblur="fillFields(0,new Array('cor_cdgo'),'DownloadImagensActionForm.getCor_desc_Ajax',new Array('cor_desc'));" styleClass="baseField" size="10"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cor_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_cor_cdgo() {
                        window.open('..//lov/LvCorLov.do?resetfull_action=&returnBlock=0&return0=cor_cdgo&return1=cor_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cor_desc" styleId="cor_desc" styleClass="disabled" tabindex="-1" readonly="true" size="70" maxlength="60"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      OC
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="oc" styleId="oc" styleClass="baseField" size="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Invoice
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="invoice" styleId="invoice" styleClass="baseField" size="11"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Lotes
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:textarea property="lotes" styleId="lotes" styleClass="baseField" cols="40" rows="3"/>
                    <span class='validateMessageuser'>
                      <br />
                    </span>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Pedidos
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:textarea property="pedido" styleId="pedido" styleClass="baseField" cols="60" rows="4"/>
                  </td>
                </tr>

                <%
                java.util.Vector res_Jw_clientes_grupos_economicos = (java.util.Vector)session.getAttribute("res_status_pedido");
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                    <input type="button" class="lovButton"  value="Status do Pedido"  onclick="javascript:lov_open_status()" >
                    <%
                    if (res_Jw_clientes_grupos_economicos!=null && res_Jw_clientes_grupos_economicos.size()>0) {
                      %>
                      <input type="button" class="lovButton"  value="Limpar Filtro" onclick="limpar_status_action.click();" >
                      <%
                    }
                    %>

                    <script type="text/javascript">
                      function lov_open_status() {
                        window.open('..//lov/LvStatusPedidoGrdGrid.do?select_action=','','scrollbars=yes,height=510,width=730,top=0,left=0,');
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
                    int counterbl_report_Jw_clientes_enderecos =0;
                    int i_bl_report_Jw_clientes_enderecos =0;
                    if (res_Jw_clientes_grupos_economicos!=null && res_Jw_clientes_grupos_economicos.size()>0) {
                      %>
                      <table id="TRbl_report_Jw_clientes_enderecos" class="reportTable" style=width:340px; border=1;  >
                        <tr class="reportHeader" >
                          <td align="center">
                            Status Selecionados
                          </td>
                        </tr>
                        <%
                        for (int x=0;x<res_Jw_clientes_grupos_economicos.size(); x++){
                          counterbl_report_Jw_clientes_enderecos++;
                          String style="";
                          if (!((i_bl_report_Jw_clientes_enderecos%2)!=0)) {
                            style="class=rowColor";
                          } else {
                            style="class=rowBlank";
                          }
                          %>
                          <tr <%= style %> id='TRbl_report_Jw_clientes_enderecos<%=counterbl_report_Jw_clientes_enderecos%>' >
                            <td class="reportColumn" style="text-align:left;">
                              <%= res_Jw_clientes_grupos_economicos.elementAt(x) %>
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
                <%
                java.util.Vector res_Jw_clientes_grupos_economicos2 = (java.util.Vector)session.getAttribute("res_situacao_pedido");
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">

                    <input type="button" class="lovButton"  value="Situação do Pedido"  onclick="javascript:lov_open_situacao()"  >

                    <%
                    if (res_Jw_clientes_grupos_economicos2 !=null && res_Jw_clientes_grupos_economicos2.size()>0) {
                      %>
                      <input type="button" class="lovButton"  value="Limpar Filtro" onclick="limpar_situacao_action.click();" >
                      <%
                    }
                    %>
                    <script type="text/javascript">
                      function lov_open_situacao() {
                        window.open('..//lov/LvSituacaoPedidoGrdGrid.do?select_action=','','scrollbars=yes,height=510,width=730,top=0,left=0,');
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
                    int counterbl_report_Jw_clientes_enderecos2 =0;
                    int i_bl_report_Jw_clientes_enderecos2 =0;
                    if (res_Jw_clientes_grupos_economicos2!=null && res_Jw_clientes_grupos_economicos2.size()>0) {
                      %>
                      <table id="TRbl_report_Jw_clientes_enderecos" class="reportTable" style=width:340px; border=1;  >
                        <tr class="reportHeader" >
                          <td align="center">
                            Situações Selecionadas
                          </td>
                        </tr>
                        <%
                        for (int x=0;x<res_Jw_clientes_grupos_economicos2.size(); x++){
                          counterbl_report_Jw_clientes_enderecos2++;
                          String style2="";
                          if (!((i_bl_report_Jw_clientes_enderecos2%2)!=0)) {
                            style2="class=rowColor";
                          } else {
                            style2="class=rowBlank";
                          }
                          %>
                          <tr <%= style2 %> id='TRbl_report_Jw_clientes_enderecos<%=counterbl_report_Jw_clientes_enderecos2%>' >
                            <td class="reportColumn" style="text-align:left;">
                              <%= res_Jw_clientes_grupos_economicos2.elementAt(x) %>
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
                <%
                if(codigoGrupoEconomico == null) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Grupo Econômico
                        <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="gre_grupo" styleId="gre_grupo" onblur="fillFields(0,new Array('gre_grupo'),'DownloadImagensActionForm.getGre_descricao_Ajax',new Array('gre_descricao'));" styleClass="baseField" size="6"/>
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

                  <html:hidden property="gre_grupo" value="<%= codigoGrupoEconomico %>" />
                  <html:hidden property="gre_descricao" />

                  <%
                }
                %>

                <%
                if(codigoCliente==null){
                  %>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Cliente
                        <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="cli_cdgo" styleId="cli_cdgo" onblur="fillFields(0,new Array('cli_cdgo'),'DownloadImagensActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));" styleClass="baseField" size="6"/>
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

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Cliente
                        <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="cli_cdgo" styleId="cli_cdgo" value="<%= codigoCliente %>" styleClass="disabled" readonly="true" tabindex="-1" size="6"/>
                      <html:hidden property="cli_rzao" />

                      <%
                    }
                    %>
                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Dt. Digit. Inicial
                          <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="dt_inicial" styleId="dt_inicial" styleClass="baseField" size="10" maxlength="10"/>
                        &nbsp;
                        <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_inicial']); cal1.year_scroll = true; cal1.popup();">
                          <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                        </a>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Dt. Digit. Final
                          <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="dt_final" styleId="dt_final" styleClass="baseField" size="10" maxlength="10"/>
                        &nbsp;
                        <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_final']); cal1.year_scroll = true; cal1.popup();">
                          <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                        </a>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Tamanho das Imagens
                        </span>
                      </td>
                      <td class="formField">
                        <html:select property="tamanho_imagens" styleId="tamanho_imagens" styleClass="baseField" size="1">
                          <html:option styleClass="baseOption" value="P">
                            Pequena
                          </html:option>
                          <html:option styleClass="baseOption" value="M">
                            Média
                          </html:option>
                          <html:option styleClass="baseOption" value="G\"selected='selected'">
                            Grande
                          </html:option>
                          <html:option styleClass="baseOption" value="A">
                            Alta
                          </html:option>
                          <html:option styleClass="baseOption" value="N">
                            Ângulos
                          </html:option>
                        </html:select>
                      </td>
                    </tr>

                  </table>

                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:submit accesskey="s" styleClass="baseButton" property="select_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:submit>
                        <html:submit accesskey="r" styleClass="baseButton" property="resetfull_action">
                          <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                        </html:submit>
                        <html:submit accesskey="l" styleClass="myhidden" property="refresh_action">
                          <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
                        </html:submit>
                        <html:submit accesskey="p" styleClass="myhidden" property="limpar_status_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:submit>
                        <html:submit value="limpar_situacao" styleClass="myhidden" property="limpar_situacao_action">
                        </html:submit>
                      </td>
                    </tr>
                  </table>

                  <script type="text/javascript">
                    jQuery(document).ready(function($) {
                      $("#dt_inicial").mask("99/99/9999");
                      $("#dt_final").mask("99/99/9999");
                      });
                    </script>
                  </html:form>
                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["marca"];
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

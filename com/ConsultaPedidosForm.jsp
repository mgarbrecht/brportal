<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ConsultaPedidosActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ConsultaPedidosActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("f_cliente1_i","");
    hashMapLabel.set("no_cliente","Nome Cliente");
    hashMapLabel.set("cli_cdgo","Código Cliente");
    hashMapLabel.set("seq","Seq.");
    hashMapLabel.set("esc_cgc","CNPJ do Cliente");
    hashMapLabel.set("f_cliente1_f","");
    hashMapLabel.set("f_areas_i","");
    hashMapLabel.set("rep_cdgo1","Representante");
    hashMapLabel.set("rep_rzao1","");
    hashMapLabel.set("agrupar_clientes","Agrupar Clientes do Rep.");
    hashMapLabel.set("f_areas_f","");
    hashMapLabel.set("situacao","Status");
    hashMapLabel.set("situacao_ped","");
    hashMapLabel.set("tipo_pedido","Tipo de Pedido");
    hashMapLabel.set("cnd_cdgo","Cond. Pagto.");
    hashMapLabel.set("cnd_desc","");
    hashMapLabel.set("codigo_marca","ConsultaPedidos.codigo_marca");
    hashMapLabel.set("descricao_marca","");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("ref_cdgo","Ref.");
    hashMapLabel.set("ref_desc","");
    hashMapLabel.set("cab_cdgo","Cabedal");
    hashMapLabel.set("cab_desc","");
    hashMapLabel.set("cor_cdgo","Cor");
    hashMapLabel.set("cor_desc","");
    hashMapLabel.set("tipo_produto","Tipo de Produto");
    hashMapLabel.set("f_cliente2_i","");
    hashMapLabel.set("grup_economico","Grupo Econômico");
    hashMapLabel.set("gre_descricao","");
    hashMapLabel.set("f_cliente2_f","");
    hashMapLabel.set("dt_entrega","Data Entrega de");
    hashMapLabel.set("dt_entrega_fim1"," até");
    hashMapLabel.set("dt_entrada_ini","Data Entrada de");
    hashMapLabel.set("dt_entrada_fim","até");
    hashMapLabel.set("dt_emissao_ini1","Data Emissão de");
    hashMapLabel.set("dt_emissao_fim1","até");
    hashMapLabel.set("dt_faturamento_ini","Data Faturamento de");
    hashMapLabel.set("dt_faturamento_fim","até");
    hashMapLabel.set("representante","representante");
    hashMapLabel.set("regional","regional");
    hashMapLabel.set("codigo","");
    hashMapLabel.set("razao_social","");
    hashMapLabel.set("cid_uf","");
    hashMapLabel.set("mostrar_imagem","ConsultaPedidos.mostrar_imagem");
    hashMapLabel.set("f_imagem","");
    hashMapLabel.set("reg","");
    hashMapLabel.set("invoice","Invoice");
    hashMapLabel.set("cb_somente_entrada","Somente Entrada");
    hashMapLabel.set("cb_fora_normas","Somente Pedidos Fora das Normas");
    hashMapLabel.set("cb_nao_imprimir_linhas","Não imprimir linhas");
    hashMapLabel.set("cb_somente_indenizados","Somente Indenizados");
    hashMapLabel.set("ordenacao","Ordenação");
    hashMapLabel.set("mix","Mix");
    hashMapLabel.set("free_i","<b>Consulta Direta</b>");
    hashMapLabel.set("nr_pedido1","Número do Pedido");
    hashMapLabel.set("pedido_afv1","Pedido AFV");
    hashMapLabel.set("ped_ped_cliente","OC");
    hashMapLabel.set("free_f","");
    hashMapLabel.set("pedido_sites","Pedido Sites");
    hashMapLabel.set("pedido_catalogo","Pedido Catálogo");
    hashMapLabel.set("ordenacao1","");
    hashMapLabel.set("f_i","");
    hashMapLabel.set("f_regi","");
    hashMapLabel.set("codigo_regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("f_regf","");
    hashMapLabel.set("f_repi","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("f_repf","");
    hashMapLabel.set("dt_entrega_ini","Dt. Entrega de");
    hashMapLabel.set("dt_entrega_fim","até");
    hashMapLabel.set("dt_emissao_ini","Dt. Emissão de");
    hashMapLabel.set("dt_emissao_fim","até");
    hashMapLabel.set("nr_pedido","Nr. Pedido");
    hashMapLabel.set("pedido_afv","Pedido AFV");
    hashMapLabel.set("cliente","Cliente");
    hashMapLabel.set("cli_seq","Seq.");
    hashMapLabel.set("situacao1","Situação");
    hashMapLabel.set("tp_pedido","Tp. de Pedido");
    hashMapLabel.set("abre_automaticamente","Abre o Relatório Automaticamente");
    hashMapLabel.set("mensagem","");
    hashMapLabel.set("f_pdf","");
    hashMapLabel.set("f_f","");
    hashMapLabel.set("pedido_sites1","Pedido Sites");
    hashMapLabel.set("pedido_catalogo1","Pedido Catálogo");
    hashMapLabel.set("free_i1","<b>Consulta por Número de Pedido do Representante</b>");
    hashMapLabel.set("cod_representante","Código do Represent.");
    hashMapLabel.set("nr_pedido_rep1","Número do Pedido");
    hashMapLabel.set("free_f1","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      <bean:message bundle="ComercialResources" key="ConsultaPedidos.titulo"/>
    </title>
  </head>
  <center>
    <body onload="if(document.forms[0].codigo.value==''){document.forms[0].no_cliente.focus();}else{document.forms[0].codigo_marca.focus();}if('<%= (String)request.getAttribute("arquivo") %>' == 'null'){document.forms[3].abre_automaticamente.checked=true;document.forms[3].mensagem.value='Obs.: Uma nova janela será aberta para a visualização do relatório.';}if(document.forms[3].abre_automaticamente.checked==true){if('<%= (String)request.getAttribute("arquivo") %>' != 'null'){window.open('<%= (String)request.getAttribute("arquivo") %>','_blank');}}" onkeypress="getKeySite();">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(75)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                  <%
                  String tipo_cab="";
                  String cliente_cab="";
                  acesso.Usuario u_cab = new acesso.Usuario();
                  u_cab = (acesso.Usuario)session.getAttribute("User");
                  acesso.EntidadeNegocio ent_cab = new acesso.EntidadeNegocio();
                  acesso.TipoEntidadeNegocio tipoent_cab = new acesso.TipoEntidadeNegocio();

                  if(!(u_cab.getEntidadeNegocio()==null)){
                    ent_cab = (acesso.EntidadeNegocio) u_cab.getEntidadeNegocio();
                    tipoent_cab = (acesso.TipoEntidadeNegocio) ent_cab.getTipoEntidadeNegocio();
                    tipo_cab = tipoent_cab.getTipo()+"";
                    if(tipo_cab.equals("CLIENTE MERCADO EXTERNO")){
                      cliente_cab = ent_cab.getChave()+"";
                    }
                    if(tipo_cab.equals("CLIENTE MERCADO INTERNO")){
                      cliente_cab = ent_cab.getChave()+"";
                    }
                  }
                  %>

                </td>

              </tr>

            </table>

            <html:form action="com/ConsultaPedidosForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <%
                      if(cliente_cab.equals("")){
                        %>
                        <div class\='div10l'>
                          Um dos campos com
                          <img src='../img/opcional.gif' border\='0' title\='Opcional' style\='cursor\:pointer'>
                          deve ser preenchido.
                        </div>
                        <%
                      }
                      %>
                    </div>
                    <html:errors property="no_cliente"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="seq"/>
                    <html:errors property="esc_cgc"/>
                    <html:errors property="rep_cdgo1"/>
                    <html:errors property="rep_rzao1"/>
                    <html:errors property="agrupar_clientes"/>
                    <html:errors property="situacao"/>
                    <html:errors property="tipo_pedido"/>
                    <html:errors property="cnd_cdgo"/>
                    <html:errors property="cnd_desc"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="descricao_marca"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="ref_desc"/>
                    <html:errors property="cab_cdgo"/>
                    <html:errors property="cab_desc"/>
                    <html:errors property="cor_cdgo"/>
                    <html:errors property="cor_desc"/>
                    <html:errors property="tipo_produto"/>
                    <html:errors property="grup_economico"/>
                    <html:errors property="gre_descricao"/>
                    <html:errors property="dt_entrega"/>
                    <html:errors property="dt_entrega_fim1"/>
                    <html:errors property="dt_entrada_ini"/>
                    <html:errors property="dt_entrada_fim"/>
                    <html:errors property="dt_emissao_ini1"/>
                    <html:errors property="dt_emissao_fim1"/>
                    <html:errors property="dt_faturamento_ini"/>
                    <html:errors property="dt_faturamento_fim"/>
                    <html:errors property="mostrar_imagem"/>
                    <html:errors property="invoice"/>
                    <html:errors property="cb_somente_entrada"/>
                    <html:errors property="cb_fora_normas"/>
                    <html:errors property="cb_nao_imprimir_linhas"/>
                    <html:errors property="cb_somente_indenizados"/>
                    <html:errors property="ordenacao"/>
                    <html:errors property="mix"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                session.setAttribute("consulta_pedidos_back_action", "/com/ConsultaPedidos_rForm.jsp");
                String codigo_regional="";
                String codigo_representante="";
                String codigo_analista="";
                String grupo_economico="";
                String tipo="";
                String cliente="";
                acesso.Usuario u = new acesso.Usuario();
                u = (acesso.Usuario)session.getAttribute("User");
                acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
                acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

                if(!(u.getEntidadeNegocio()==null)){
                  ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                  tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
                  tipo = tipoent.getTipo()+"";
                  if(tipo.equals("REGIONAL DE VENDA")){
                    codigo_regional = ent.getChave()+"";
                  }
                  if((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))){
                    codigo_representante = ent.getChave()+"";
                  }
                  if(tipo.equals("ANALISTA REGIONAL")){
                    codigo_analista = ent.getChave()+"";
                  }
                  if(tipo.equals("GRUPO ECONOMICO")){
                    grupo_economico = ent.getChave()+"";
                  }
                  if(tipo.equals("CLIENTE MERCADO EXTERNO")){
                    cliente = ent.getChave()+"";
                  }
                  if(tipo.equals("CLIENTE MERCADO INTERNO")){
                    cliente = ent.getChave()+"";
                  }
                }

                if(tipo.equals("ANALISTA REGIONAL")){
                  com.egen.util.jdbc.JdbcUtil j = null;
                  try{
                    j = new com.egen.util.jdbc.JdbcUtil();
                    portalbr.dbobj.view.Jw_regional_analista table = new portalbr.dbobj.view.Jw_regional_analista();
                    String[][] select = null;
                    Object[][] where = {
                    {"codigo_gerente","=",codigo_analista}
                    };
                    Vector res_Jw_regional_analista = j.select(table, select, where, null, null, null);
                    if (res_Jw_regional_analista != null && res_Jw_regional_analista.size() > 0) {
                      portalbr.dbobj.view.Jw_regional_analista r = (portalbr.dbobj.view.Jw_regional_analista) res_Jw_regional_analista.elementAt(0);
                      codigo_regional = r.getCodigo_regional();
                    }
                  } finally {
                    if(j!=null) {
                      j.close();
                      j = null;
                    }
                  }
                }
                %>
                <%
                if(cliente.equals("")){
                  %>
                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Nome Cliente
                      </span>
                      <%
                      if(codigo_representante.equals("")){
                        %>
                        <img src="../img/opcional.gif" border="0"/>
                        <%
                      }
                      %>
                    </td>
                    <td class="formField">
                      <html:text property="no_cliente" styleClass="baseField" size="38" maxlength="35"/>
                    </td>
                  </tr>

                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Código Cliente
                      </span>
                      <%
                      if(codigo_representante.equals("")){
                        %>
                        <img src="../img/opcional.gif" border="0"/>
                        <%
                      }
                      %>
                    </td>
                    <td class="formField">
                      <html:text property="cli_cdgo" styleClass="baseField" size="10" maxlength="22"/>
                      <span class="spamFormLabel">
                        Seq.
                      </span>
                      <html:text property="seq" styleClass="baseField" size="3" maxlength="3"/>
                    </td>
                  </tr>

                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        CNPJ do Cliente
                      </span>
                      <%
                      if(codigo_representante.equals("")){
                        %>
                        <img src="../img/opcional.gif" border="0"/>
                        <%
                      }
                      %>
                    </td>
                    <td class="formField">
                      <html:text property="esc_cgc" styleClass="baseField" size="16" maxlength="14"/>
                    </td>
                  </tr>
                  <%
                }
                %>
                <%
                if(tipo.equals("AREAS") || user.isSuperUsuario() || tipo.equals("REGIONAL DE VENDA")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Representante
                      </span>
                      <img src="../img/opcional.gif" border="0"/>
                    </td>
                    <td class="formField">
                      <html:text property="rep_cdgo1" styleId="rep_cdgo1" onblur="fillFields(0,new Array('rep_cdgo1'),'ConsultaPedidosActionForm.getRep_rzao1_Ajax',new Array('rep_rzao1'));" styleClass="baseField" size="5"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep_cdgo1()"  >
                      <script type="text/javascript">
                        function lov_open_rep_cdgo1() {
                          window.open('..//lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo1&return1=rep_rzao1','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="rep_rzao1" styleId="rep_rzao1" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Agrupar Clientes do Rep.
                      </span>
                    </td>
                    <td class="formField">
                      <html:select property="agrupar_clientes" styleId="agrupar_clientes" styleClass="baseField" size="1">
                        <html:option styleClass="baseOption" value="N">
                          Não
                        </html:option>
                        <html:option styleClass="baseOption" value="S">
                          Sim
                        </html:option>
                      </html:select>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="rep_cdgo1" value="<%= codigo_representante %>" />
                  <html:hidden property="rep_rzao1" />
                  <html:hidden property="agrupar_clientes" />

                  <%
                }
                %>
                <%
                java.util.Vector res_Jw_clientes_grupos_economicos = (java.util.Vector)session.getAttribute("res_status_pedido");
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="situacao" disabled="true" styleId="situacao" styleClass="myhidden"/>
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
                    <html:text property="situacao_ped" disabled="true" styleId="situacao_ped" styleClass="myhidden"/>
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
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo de Pedido
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo_pedido" styleId="tipo_pedido" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="null">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="'EX'">
                        EX
                      </html:option>
                      <html:option styleClass="baseOption" value="'PG'">
                        PG
                      </html:option>
                      <html:option styleClass="baseOption" value="'PP'">
                        PP
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cond. Pagto.
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cnd_cdgo" styleId="cnd_cdgo" onblur="fillFields(0,new Array('cnd_cdgo'),'ConsultaPedidosActionForm.getCnd_desc_Ajax',new Array('cnd_desc'));" styleClass="baseField" size="5"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cnd_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_cnd_cdgo() {
                        window.open('..//lov/CndLov.do?resetfull_action=&returnBlock=0&return0=cnd_cdgo&return1=cnd_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cnd_desc" styleId="cnd_desc" styleClass="disabled" tabindex="-1" readonly="true" size="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos.codigo_marca"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_marca" onblur="fillFields(0,new Array('codigo_marca'),'ConsultaPedidosActionForm.getDescricao_marca_Ajax',new Array('descricao_marca'));" styleClass="baseField" size="3" maxlength="3"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_marca()"  >
                    <script type="text/javascript">
                      function lov_open_codigo_marca() {
                        window.open('../lov/LvMarcaLov.do?resetfull_action=&returnBlock=0&return0=codigo_marca&return1=descricao_marca','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="descricao_marca" styleId="descricao_marca" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" onblur="fillFields(0,new Array('lin_cdgo'),'ConsultaPedidosActionForm.getLin_nome_Ajax',new Array('lin_nome'));" styleClass="baseField" size="8"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('..//lov/LvLinhaRefLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
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
                      Ref.
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ref_cdgo" styleId="ref_cdgo" onblur="fillFields(0,new Array('lin_cdgo','ref_cdgo'),'ConsultaPedidosActionForm.getRef_desc_Ajax',new Array('ref_desc'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_ref_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_ref_cdgo() {
                        window.open('..//lov/LvRefLov.do?resetfull_action=&returnBlock=0&return0=ref_cdgo&return1=ref_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="ref_desc" styleId="ref_desc" styleClass="disabled" tabindex="-1" readonly="true" size="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cabedal
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cab_cdgo" styleId="cab_cdgo" onblur="fillFields(0,new Array('cab_cdgo'),'ConsultaPedidosActionForm.getCab_desc_Ajax',new Array('cab_desc'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cab_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_cab_cdgo() {
                        window.open('..//lov/LvCabedalLov.do?resetfull_action=&returnBlock=0&return0=cab_cdgo&return1=cab_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cab_desc" styleId="cab_desc" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cor
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cor_cdgo" styleId="cor_cdgo" onblur="fillFields(0,new Array('cor_cdgo'),'ConsultaPedidosActionForm.getCor_desc_Ajax',new Array('cor_desc'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cor_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_cor_cdgo() {
                        window.open('..//lov/LvCorLov.do?resetfull_action=&returnBlock=0&return0=cor_cdgo&return1=cor_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cor_desc" styleId="cor_desc" styleClass="disabled" tabindex="-1" readonly="true" size="70"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo de Produto
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo_produto" styleId="tipo_produto" styleClass="baseField" size="1">
                      <html:options property="tipo_produtoList" labelProperty="tipo_produtoLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <%
                if(cliente.equals("")){
                  %>
                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Grupo Econômico
                      </span>
                      <%
                      if(codigo_representante.equals("")){
                        %>
                        <img src="../img/opcional.gif" border="0"/>
                        <%
                      }
                      %>
                    </td>
                    <td class="formField">

                      <%
                      if(grupo_economico.equals("")){
                        %>
                        <html:text property="grup_economico" onblur="fillFields(0,new Array('grup_economico'),'ConsultaPedidosActionForm.getGre_descricao_Ajax',new Array('gre_descricao'));" styleClass="baseField" size="3"/>
                        <input type="button" class="lovButton" tabindex="-1" value="..." onclick="window.open('../lov/LvGrupoEconomicoLov.jsp?returnBlock=0&return0=grup_economico&return1=gre_descricao','','scrollbars,height=510,width=730,top=0,left=0,')"/>
                        <%
                      } else {
                        %>

                        <html:text property="grup_economico" value="<%= grupo_economico %>" readonly="true" tabindex="-1" styleClass="disabled" size="3"/>
                        <input type="button" class="lovButton" disabled="true" tabindex="-1" value="..." onclick="window.open('../lov/LvGrupoEconomicoLov.jsp?returnBlock=0&return0=grup_economico&return1=gre_descricao','','scrollbars,height=510,width=730,top=0,left=0,')"/>
                        <script>
                          fillFields(0,new Array('grup_economico'),'ConsultaPedidosActionForm.getGre_descricao_Ajax',new Array('gre_descricao'));
                        </script>
                        <%
                      }
                      %>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="gre_descricao" styleId="gre_descricao" style="-color:#A9A9A9; text-align:start;" styleClass="disabled" tabindex="-1" readonly="true" size="30"/>
                    </td>
                  </tr>

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Entrega de
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_entrega" styleId="dt_entrega" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_entrega']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                      até
                    </span>
                    <html:text property="dt_entrega_fim1" styleId="dt_entrega_fim1" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_entrega_fim1']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Entrada de
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_entrada_ini" styleId="dt_entrada_ini" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_entrada_ini']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                      até
                    </span>
                    <html:text property="dt_entrada_fim" styleId="dt_entrada_fim" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_entrada_fim']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Emissão de
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_emissao_ini1" styleId="dt_emissao_ini1" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_emissao_ini1']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                      até
                    </span>
                    <html:text property="dt_emissao_fim1" styleId="dt_emissao_fim1" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_emissao_fim1']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Faturamento de
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_faturamento_ini" styleId="dt_faturamento_ini" styleClass="baseField" size="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_faturamento_ini']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                      até
                    </span>
                    <html:text property="dt_faturamento_fim" styleId="dt_faturamento_fim" styleClass="baseField" size="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_faturamento_fim']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <html:hidden property="representante" value="<%= codigo_representante %>"/>
                <html:hidden property="regional" value="<%= codigo_regional %>"/>
                <html:hidden property="codigo" value="<%= cliente %>"/>
                <html:hidden property="razao_social"/>
                <html:hidden property="cid_uf"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos.mostrar_imagem"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="mostrar_imagem" onchange="refresh_action.click();" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="S\"selected='selected'">
                        Sim
                      </html:option>
                      <html:option styleClass="baseOption" value="N">
                        Não
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <%
                portalbr.com.ConsultaPedidosActionForm pedidosActionForm = (portalbr.com.ConsultaPedidosActionForm) session.getAttribute("ConsultaPedidosActionForm");
                session.setAttribute("mostrar_imagem",pedidosActionForm.getMostrar_imagem()==null?"S":pedidosActionForm.getMostrar_imagem()+"");
                %>
                <html:hidden property="reg" value="<%= codigo_regional %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Invoice
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="invoice" styleId="invoice" styleClass="baseField" size="12" maxlength="11"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Somente Entrada
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_somente_entrada" styleId="cb_somente_entrada" styleClass="baseField" value="1"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Somente Pedidos Fora das Normas
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_fora_normas" styleId="cb_fora_normas" styleClass="baseField" value="1"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Não imprimir linhas
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_nao_imprimir_linhas" styleId="cb_nao_imprimir_linhas" styleClass="baseField" value="1"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Somente Indenizados
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_somente_indenizados" styleId="cb_somente_indenizados" styleClass="baseField" value="1"/>
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
                      <html:option styleClass="baseOption" value="C">
                        Crescente
                      </html:option>
                      <html:option styleClass="baseOption" value="D">
                        Decrescente
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Mix
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="mix" styleId="mix" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="T">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="M">
                        Mix
                      </html:option>
                      <html:option styleClass="baseOption" value="F">
                        Fora Mix
                      </html:option>
                    </html:select>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="p" onclick="bloqueia();resetfull1_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:button>

                    <html:button accesskey="r" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:button>
                    <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit styleClass="myhidden" property="refresh_action">
                      <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
                    </html:submit>
                    <html:submit value="limpar_situacao_action" styleClass="myhidden" property="limpar_situacao_action">
                    </html:submit>
                    <html:submit value="limpar_status_action" styleClass="myhidden" property="limpar_status_action">
                    </html:submit>
                  </td>
                </tr>
              </table>

              <script type="text/javascript">
                function mostra(){

                  for(var i=0;i<document.forms.length; i++){

                    for(var b=0;i<document.forms[i].elements.length; b++){
                      if(document.forms[i].elements[b].type=='select-one'){
                        if(teste==0){
                          document.forms[i].elements[b].style.display='inline';
                        }
                        if(teste==1){
                          document.forms[i].elements[b].style.display='none';
                        }

                      }
                    }
                  }
                }




                function getKeySite(keyStroke) {
                  isNetscape=(document.layers);
                  eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                  which = String.fromCharCode(eventChooser).toLowerCase();
                  keyBuffer = which;
                  if(eventChooser == 13){

                    document.forms[0].select1_action.click();
                  }
                }



                jQuery(document).ready(function($) {
                  $("#dt_entrega").mask("99/99/9999");
                  $("#dt_entrega_fim1").mask("99/99/9999");
                  $("#data_emissao").mask("99/99/9999");
                  $("#dt_entrega_ini").mask("99/99/9999");
                  $("#dt_entrega_fim").mask("99/99/9999");
                  $("#dt_emissao_ini").mask("99/99/9999");
                  $("#dt_emissao_fim").mask("99/99/9999");
                  $("#dt_emissao_ini1").mask("99/99/9999");
                  $("#dt_emissao_fim1").mask("99/99/9999");
                  $("#dt_entrada_ini").mask("99/99/9999");
                  $("#dt_entrada_fim").mask("99/99/9999");
                  $("#dt_faturamento_ini").mask("99/99/9999");
                  $("#dt_faturamento_fim").mask("99/99/9999");
                  });
                </script>
              </html:form>
              <table border=0 width="100%" style="color:gray">
                <tr valign="top">
                  <td align="top">
                    <%
                    String cliente="";
                    String tipo="";
                    acesso.Usuario u = new acesso.Usuario();
                    u = (acesso.Usuario)session.getAttribute("User");
                    acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
                    acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

                    if(!(u.getEntidadeNegocio()==null)){
                      ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                      tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
                      tipo = tipoent.getTipo()+"";
                      if(tipo.equals("CLIENTE MERCADO EXTERNO")){
                        cliente = ent.getChave()+"";
                      }
                      if(tipo.equals("CLIENTE MERCADO INTERNO")){
                        cliente = ent.getChave()+"";
                      }
                    }

                    if(cliente.equals("")){
                      %>
                      <html:form action="com/ConsultaPedidosForm.do" method="POST" styleClass="baseForm">
                        <table style='width:99%;'>
                          <tr>
                            <td>
                              <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                            </td>
                          </tr>
                        </table>
                        <!--
                          <table class="itemTable" style='width:99%;' border=0> </table>
                        -->
                        <table class="separatorTable">
                          <tr >
                            <td colspan="2" class="separatorTd">
                              <b>
                                Consulta Direta
                              </b>
                            </td>
                          </tr>

                          <tr>
                            <td class="formLabel">
                              <span class="spamFormLabel" >
                                Pedidos
                              </span>
                              <img src="../img/opcional.gif" border="0"/>
                            </td>
                            <td class="formField">
                              <html:textarea property="nr_pedido1" styleId="nr_pedido1" styleClass="baseField" cols="60" rows="4" onblur="this.value = this.value.replace(/^\s+|\s+$/g,'');"/>
                            </td>
                          </tr>

                          <tr>
                            <td class="formLabel">
                              <span class="spamFormLabel" >
                                Pedido AFV
                              </span>
                              <img src="../img/opcional.gif" border="0"/>
                            </td>
                            <td class="formField">
                              <html:text property="pedido_afv1" styleClass="baseField" onblur="this.value = this.value.replace(/^\s+|\s+$/g,'');"/>
                            </td>
                          </tr>


                          <html:hidden property="ordenacao1"/>

                          <tr>
                            <td class="formLabel">
                              <span class="spamFormLabel" >
                                Ordem de Compra
                              </span>
                              <img src="../img/opcional.gif" border="0"/>
                            </td>
                            <td class="formField">
                              <html:text property="ped_ped_cliente" styleClass="baseField" onblur="this.value = this.value.replace(/^\s+|\s+$/g,'');"/>
                              <html:submit accesskey="s" styleClass="baseButton" property="select3_action" onclick="document.forms[1].ordenacao1.value = document.forms[0].ordenacao.value;bloqueia();">
                                <bean:message bundle="ApplicationResources" key="jsp.select"/>
                              </html:submit>
                            </td>
                          </tr>
                          <tr>

                            <tr>
                              <td class="formLabel">
                                <span class="spamFormLabel" >
                                  Pedido Sites
                                </span>
                                <img src="../img/opcional.gif" border="0"/>
                              </td>
                              <td class="formField">
                                <html:text property="pedido_sites" styleClass="baseField" onblur="this.value = this.value.replace(/^\s+|\s+$/g,'');" />
                              </td>
                            </tr>

                            <tr>
                              <td class="formLabel">
                                <span class="spamFormLabel" >
                                  Pedido Catálogo
                                </span>
                                <img src="../img/opcional.gif" border="0"/>
                              </td>
                              <td class="formField">
                                <html:text property="pedido_catalogo" styleClass="baseField" onblur="this.value = this.value.replace(/^\s+|\s+$/g,'');" />
                              </td>
                            </tr>

                            <!-- <html:hidden property="ped_ped_cliente"/> -->

                          </table>

                          <!--
                            <table style='width:99%;'> <tr> <td class="buttonItem">
                          -->
                          <html:submit accesskey="s" styleClass="myhidden" property="select3_action" >
                            <bean:message bundle="ApplicationResources" key="jsp.select"/>
                          </html:submit>
                          <!--
                            </td> </tr> </table>
                          -->
                        </html:form>

                        <%
                      }
                      %>

                      <br>

                      <%
                      String cliente3="";
                      String tipo3="";
                      acesso.Usuario u3 = new acesso.Usuario();
                      u3 = (acesso.Usuario)session.getAttribute("User");
                      acesso.EntidadeNegocio ent3 = new acesso.EntidadeNegocio();
                      acesso.TipoEntidadeNegocio tipoent3= new acesso.TipoEntidadeNegocio();

                      if(!(u3.getEntidadeNegocio()==null)){
                        ent3= (acesso.EntidadeNegocio) u3.getEntidadeNegocio();
                        tipoent3= (acesso.TipoEntidadeNegocio) ent3.getTipoEntidadeNegocio();
                        tipo3= tipoent3.getTipo()+"";
                        if(tipo3.equals("CLIENTE MERCADO EXTERNO")){
                          cliente3= ent3.getChave()+"";
                        }
                        if(tipo3.equals("CLIENTE MERCADO INTERNO")){
                          cliente3= ent3.getChave()+"";
                        }
                      }

                      if(cliente3.equals("")){
                        %>
                        <html:form action="com/ConsultaPedidosForm.do" method="POST" styleClass="baseForm">
                          <table  style='width:99%;' >
                            <tr>
                              <td>
                                <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_1"/>
                              </td>
                            </tr>
                          </table>
                          <!--
                            <table class="itemTable" style='width:99%;'> </table>
                          -->
                          <table class="separatorTable" >
                            <tr>
                              <td colspan="2" class="separatorTd">
                                <b>
                                  Consulta por Número de Pedido do Representante
                                </b>
                              </td>
                            </tr>
                            <tr>
                              <td class="formLabel">
                                <span class="spamFormLabel" >
                                  Código do Represent.
                                </span>
                                <img src="../img/opcional.gif" border="0"/>
                              </td>
                              <td class="formField">
                                <html:text property="cod_representante" onblur="this.value = this.value.replace(/^\s+|\s+$/g,'');" styleClass="baseField"/>
                              </td>
                            </tr>
                            <tr>
                              <td class="formLabel">
                                <span class="spamFormLabel" >
                                  Número do Pedido
                                </span>
                                <img src="../img/opcional.gif" border="0"/>
                              </td>
                              <td class="formField">
                                <html:text property="nr_pedido_rep1" onblur="this.value = this.value.replace(/^\s+|\s+$/g,'');" styleClass="baseField"/>
                                <html:submit styleClass="baseButton" property="select2_action" onclick="bloqueia();">
                                  <bean:message bundle="ApplicationResources" key="jsp.select"/>
                                </html:submit>
                              </td>
                            </tr>
                          </table>
                          <!--
                            <table class="itemTable" style='width:100%;'> </table> <table class="buttonTable" style='width:99%;'> <tr> <td class="buttonItem">
                          -->
                          <html:submit styleClass="myhidden" property="select2_action">
                            <bean:message bundle="ApplicationResources" key="jsp.select"/>
                          </html:submit>
                          <!--
                            </td> </tr> </table>
                          -->
                        </html:form>
                        <%
                      }
                      %>




                    </td>
                    <td align="top">
                      <html:form action="com/ConsultaPedidosForm.do" method="post" styleClass="baseForm" styleId="formPedido">


                        <%
                        acesso.Sessao se = new acesso.Sessao(session);
                        //   if(user.isSuperUsuario()
                        //  || tipo.equals("REPRESENTANTE COMERCIAL")
                        //    || tipo.equals("AREAS")
                        //    || tipo.equals("REGIONAL DE VENDA")
                        //      || se.getUsuario().equals("150057")
                        //      || se.getUsuario().equals("151398")
                        //      || se.getUsuario().equals("151169")
                        //      || se.getUsuario().equals("151368")
                        //      || se.getUsuario().equals("150849")
                        //      || se.getUsuario().equals("151402")
                        //      || se.getUsuario().equals("151397")
                        //      || se.getUsuario().equals("151180")
                        //      || se.getUsuario().equals("151373")
                        //      || se.getUsuario().equals("EMILIA_GLASENAPP")
                        if(true){
                          %>
                          <table style='width:99%;'>
                            <tr>
                              <td>
                                <html:errors property="codigo_regional"/>
                                <html:errors property="nome_regional"/>
                                <html:errors property="rep_cdgo"/>
                                <html:errors property="rep_rzao"/>
                                <html:errors property="dt_entrega_ini"/>
                                <html:errors property="dt_entrega_fim"/>
                                <html:errors property="dt_emissao_ini"/>
                                <html:errors property="dt_emissao_fim"/>
                                <html:errors property="nr_pedido"/>
                                <html:errors property="pedido_afv"/>
                                <html:errors property="cliente"/>
                                <html:errors property="cli_seq"/>
                                <html:errors property="situacao1"/>
                                <html:errors property="tp_pedido"/>
                                <html:errors property="abre_automaticamente"/>
                                <html:errors property="mensagem"/>
                                <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_2"/>
                              </td>
                            </tr>
                          </table>
                          <table class="separatorTable">
                            <tr class="separatorTr">
                              <td colspan="2" class="separatorTd" >
                                <b>
                                  Impressão de Pedidos - Utilize os parâmetros somente para a impressão dos pedidos
                                </b>
                              </td>
                            </tr>
                            <tr>
                              <td class="messageTd" colspan=3>
                                <!--<bean:message key="div.campos*"/>-->
                                <div class\='div10l'>
                                  Um dos campos com
                                  <img src='../img/opcional.gif' border\='0' title\='Opcional' style\='cursor\:pointer'>
                                  deve ser preenchido.
                                </div>
                              </td>
                            </tr>

                            <tr class="itemTr">
                              <td class="formLabel">
                                <span class="spamFormLabel">
                                  Nr. Pedido
                                </span>
                                <img src="../img/opcional.gif" border="0"/>
                              </td>
                              <td class="formField">
                                <html:text property="nr_pedido" styleId="nr_pedido" styleClass="baseField"/>
                              </td>
                            </tr>

                            <tr class="itemTr">
                              <td class="formLabel">
                                <span class="spamFormLabel">
                                  Pedido Sites
                                </span>
                                <img src="../img/opcional.gif" border="0"/>
                              </td>
                              <td class="formField">
                                <html:text property="pedido_sites1" styleId="pedido_sites1" styleClass="baseField"/>
                              </td>
                            </tr>

                            <tr class="itemTr">
                              <td class="formLabel">
                                <span class="spamFormLabel">
                                  Pedido Catálogo
                                </span>
                                <img src="../img/opcional.gif" border="0"/>
                              </td>
                              <td class="formField">
                                <html:text property="pedido_catalogo1" styleId="pedido_catalogo1" styleClass="baseField"/>
                              </td>
                            </tr>
                            <tr class="itemTr">
                              <td class="formLabel">
                                <span class="spamFormLabel">
                                  Pedido AFV
                                </span>
                                <img src="../img/opcional.gif" border="0"/>
                              </td>
                              <td class="formField">
                                <html:text property="pedido_afv" styleId="pedido_afv" styleClass="baseField"/>
                              </td>
                            </tr>


                            <%
                            String codigo_regional="";
                            String codigo_representante="";
                            String codigo_cliente="";

                            String tipo_pdf="";
                            acesso.Usuario u_pdf = new acesso.Usuario();
                            u_pdf = (acesso.Usuario)session.getAttribute("User");
                            acesso.EntidadeNegocio ent_pdf = new acesso.EntidadeNegocio();
                            acesso.TipoEntidadeNegocio tipoent_pdf = new acesso.TipoEntidadeNegocio();

                            if(!(u_pdf.getEntidadeNegocio()==null)){
                              ent_pdf = (acesso.EntidadeNegocio) u_pdf.getEntidadeNegocio();
                              tipoent_pdf = (acesso.TipoEntidadeNegocio) ent_pdf.getTipoEntidadeNegocio();
                              tipo_pdf = tipoent_pdf.getTipo()+"";
                              if(tipo_pdf.equals("REGIONAL DE VENDA")){
                                codigo_regional = ent_pdf.getChave()+"";
                              }
                              if((tipo_pdf.equals("REPRESENTANTE COMERCIAL")) || tipo_pdf.equals("REPRESENTANTE EXPORTACAO")){
                                codigo_representante = ent_pdf.getChave()+"";
                              }
                              if(tipo_pdf.equals("CLIENTE MERCADO EXTERNO")){
                                codigo_cliente = ent_pdf.getChave()+"";
                              }
                              if(tipo_pdf.equals("CLIENTE MERCADO INTERNO")){
                                codigo_cliente = ent_pdf.getChave()+"";
                              }
                            }

                            if(codigo_regional.equals("") && codigo_representante.equals("") && codigo_cliente.equals("")){
                              %>
                              <tr class="itemTr">
                                <td class="formLabel">
                                  <span class="spamFormLabel">
                                    Regional
                                  </span>
                                </td>
                                <td class="formField">
                                  <html:text property="codigo_regional" styleId="codigo_regional" onblur="if(this.value!=''){fillFields(3,new Array('codigo_regional'),'ConsultaPedidosActionForm.getNome_regional_Ajax',new Array('nome_regional'))}else{nome_regional.value='';}" styleClass="baseField" size="3" maxlength="3"/>
                                  <input type="button" class="lovButton" tabindex="-1" value="..." onclick="javascript:lov_open_codigo_regional()"  >
                                  <script type="text/javascript">
                                    function lov_open_codigo_regional() {
                                      window.open('..//lov/LvRegionalLov.do?resetfull_action=&returnBlock=3&return0=codigo_regional&return1=nome_regional','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                                    }
                                  </script>
                                  <span class="spamFormLabel">
                                  </span>
                                  <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>
                                </td>
                              </tr>


                              <%
                            } else {
                              %>
                              <html:hidden property="codigo_regional" value="<%= codigo_regional %>"/>
                              <%
                            }
                            %>

                            <%
                            if(codigo_representante.equals("") && codigo_cliente.equals("")){
                              %>
                              <tr class="itemTr">
                                <td class="formLabel">
                                  <span class="spamFormLabel">
                                    Representante
                                  </span>
                                </td>
                                <td class="formField">
                                  <html:text property="rep_cdgo" styleId="rep_cdgo" onblur="if(this.value!=''){fillFields(3,new Array('rep_cdgo'),'ConsultaPedidosActionForm.getRep_rzao_Ajax',new Array('rep_rzao'))}else{rep_rzao.value='';}" styleClass="baseField" size="5" maxlength="5"/>
                                  <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                                  <script type="text/javascript">
                                    function lov_open_rep_cdgo() {
                                      document.forms[0].reg.value=document.forms[3].codigo_regional.value;
                                      window.open('..//lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=3&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                                    }
                                  </script>
                                  <span class="spamFormLabel">
                                  </span>
                                  <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                                </td>
                              </tr>


                              <%
                            } else {
                              %>
                              <html:hidden property="rep_cdgo" value="<%= codigo_representante %>"/>
                              <%
                            }
                            %>

                            <%
                            if(codigo_cliente.equals("")){
                              %>

                              <tr class="itemTr">
                                <td class="formLabel">
                                  <span class="spamFormLabel">
                                    Cliente
                                  </span>
                                </td>
                                <td class="formField">
                                  <html:text property="cliente" styleId="cliente" styleClass="baseField" size="10" maxlength="22"/>
                                  <span class="spamFormLabel">
                                    Seq.
                                  </span>
                                  <html:text property="cli_seq" styleId="cli_seq" styleClass="baseField" size="4" maxlength="5"/>
                                </td>
                              </tr>

                              <%
                            } else {
                              %>
                              <html:hidden property="cliente" value="<%= codigo_cliente %>"/>
                              <html:hidden property="cli_seq" />
                              <%
                            }
                            %>

                            <tr class="itemTr">
                              <td class="formLabel">
                                <span class="spamFormLabel">
                                  Dt. Entrega de
                                </span>
                              </td>
                              <td class="formField">
                                <html:text property="dt_entrega_ini" styleId="dt_entrega_ini"  styleClass="baseField" size="10" maxlength="10"/>

                                <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['formPedido'].dt_entrega_ini); cal1.year_scroll = true; cal1.popup();">
                                  <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                                </a>
                                <span class="spamFormLabel">
                                  até
                                </span>
                                <html:text property="dt_entrega_fim" styleId="dt_entrega_fim"  styleClass="baseField" size="10" maxlength="10"/>
                                <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['formPedido'].dt_entrega_fim); cal1.year_scroll = true; cal1.popup();">
                                  <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                                </a>
                              </td>
                            </tr>

                            <tr class="itemTr">
                              <td class="formLabel">
                                <span class="spamFormLabel">
                                  Dt. Emissão de
                                </span>
                                <img src="../img/opcional.gif" border="0"/>
                              </td>
                              <td class="formField">
                                <html:text property="dt_emissao_ini" styleId="dt_emissao_ini"  styleClass="baseField" size="10" maxlength="10"/>
                                <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['formPedido'].dt_emissao_ini); cal1.year_scroll = true; cal1.popup();">
                                  <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                                </a>
                                <span class="spamFormLabel">
                                  até
                                </span>
                                <img src="../img/opcional.gif" border="0"/>
                                <html:text property="dt_emissao_fim" styleId="dt_emissao_fim"  styleClass="baseField" size="10" maxlength="10"/>
                                <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['formPedido'].dt_emissao_fim); cal1.year_scroll = true; cal1.popup();">
                                  <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
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
                                <html:select property="situacao1" styleId="situacao1" styleClass="baseField" size="1">
                                  <html:option styleClass="baseOption" value="A">
                                    Aberto
                                  </html:option>
                                  <html:option styleClass="baseOption" value="B">
                                    Bloqueado venda
                                  </html:option>
                                  <html:option styleClass="baseOption" value="C">
                                    Cancelado
                                  </html:option>
                                  <html:option styleClass="baseOption" value="L">
                                    Liberado
                                  </html:option>
                                  <html:option styleClass="baseOption" value="P">
                                    Bloqueado crédito
                                  </html:option>
                                  <html:option styleClass="baseOption" value="PF">
                                    Parcialmente faturado
                                  </html:option>
                                  <html:option styleClass="baseOption" value="R">
                                    Reanálise
                                  </html:option>
                                  <html:option styleClass="baseOption" value="T">
                                    Bloqueado comercial
                                  </html:option>
                                  <html:option styleClass="baseOption" value="F">
                                    Faturado
                                  </html:option>
                                  <html:option styleClass="baseOption" value="\"selected='selected'">
                                    Todos
                                  </html:option>
                                </html:select>
                                <span class="spamFormLabel">
                                  Tp. de Pedido
                                </span>
                                <html:select property="tp_pedido" styleId="tp_pedido" styleClass="baseField" size="1">
                                  <html:option styleClass="baseOption" value="\"selected='selected'">
                                    Todos
                                  </html:option>
                                  <html:option styleClass="baseOption" value="'EX'">
                                    EX
                                  </html:option>
                                  <html:option styleClass="baseOption" value="'PE'">
                                    PE
                                  </html:option>
                                  <html:option styleClass="baseOption" value="'PG'">
                                    PG
                                  </html:option>
                                  <html:option styleClass="baseOption" value="'PP'">
                                    PP
                                  </html:option>
                                </html:select>
                                <html:submit styleClass="myhidden" property="imprimir_action">
                                  <bean:message bundle="ApplicationResources" key="jsp.select"/>
                                </html:submit>

                              </td>
                            </tr>

                            <tr class="itemTr">
                              <td class="formLabel">
                                <span class="spamFormLabel">
                                  Abre o Relatório Automaticamente
                                </span>
                              </td>
                              <td class="formField">
                                <html:checkbox property="abre_automaticamente" styleId="abre_automaticamente" onclick="if(this.checked==true){mensagem.value='Obs.: Uma nova janela será aberta para a visualização do relatório.';}else{mensagem.value='';}" styleClass="baseField" value="checked"/>
                                <span class="spamFormLabel">
                                </span>
                                <html:text property="mensagem" styleId="mensagem" style="background-color:transparent; border-style:none; color:red; background-color:transparent; border-style:none; cursor:default; text-align:start;" styleClass="baseField" readonly="true" size="90" maxlength="90"/>
                              </td>
                            </tr>

                            <%
                            if((String)request.getAttribute("abre_automaticamente")=="N"){
                              %>
                              <table style=width:100%;margin-top:10;>
                                <tr>
                                  <td class=columHeader style="text-align:center;">
                                    <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                                      <bean:message key="report.downloadpdf"/>
                                    </a>
                                  </td>
                                </tr>
                              </table>
                              <%
                            }
                            %>
                            <tr class="itemTr">
                              <td class="formLabel">
                                <span class="spamFormLabel">
                                </span>
                              </td>
                              <td class="formField">
                                <html:button onclick="bloqueia();imprimir_action.click();this.disabled=true;" styleClass="baseButton" property="imprimir1_action">
                                  <bean:message bundle="ApplicationResources" key="jsp.select"/>
                                </html:button>
                                <input type="button" value=<bean:message bundle="ApplicationResources" key="jsp.reset"/> onclick="limpar();">

                                <script>
                                  function limpar(){
                                    document.forms[3].codigo_regional.value='';
                                    document.forms[3].nome_regional.value='';
                                    document.forms[3].rep_cdgo.value='';
                                    document.forms[3].rep_rzao.value='';
                                    document.forms[3].dt_entrega_ini.value='';
                                    document.forms[3].dt_entrega_fim.value='';
                                    document.forms[3].dt_emissao_ini.value='';
                                    document.forms[3].dt_emissao_fim.value='';
                                    document.forms[3].nr_pedido.value='';
                                    document.forms[3].pedido_afv.value='';
                                    document.forms[3].cliente.value='';
                                    document.forms[3].cli_seq.value='';
                                    document.forms[3].tp_pedido.value='';
                                    document.forms[3].situacao1.value='';
                                    document.forms[3].pedido_sites1.value='';
                                    document.forms[3].pedido_catalogo1.value='';
                                  }
                                </script>
                              </td>
                            </tr>
                          </table>
                          <%
                        } else {
                          %>
                          <html:hidden property="abre_automaticamente"/>
                          <html:hidden property="mensagem"/>
                          <%
                        }
                        %>






                      </html:form>
                    </td>
                  </tr>
                </table>
                <%
                %>
              </td>
            </tr>
          </table>

        </body>
      </center>
    </html>

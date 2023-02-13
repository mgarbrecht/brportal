<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ConsultaNotaFiscalActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ConsultaNotaFiscalActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("nfs_nmro","Número");
    hashMapLabel.set("emp_empresa","Empresa");
    hashMapLabel.set("emp_razsoc","");
    hashMapLabel.set("f_filial_i","");
    hashMapLabel.set("fil_filial","Filial");
    hashMapLabel.set("fil_razsoc","");
    hashMapLabel.set("f_filial_f","");
    hashMapLabel.set("codigo_regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("est_unifed","UF");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("f_cli_i","");
    hashMapLabel.set("cli_cdgo","Cliente");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("f_cli_f","");
    hashMapLabel.set("f_esc_seqn_i","");
    hashMapLabel.set("esc_seqn","Seqüencial");
    hashMapLabel.set("f_esc_seqn_f","");
    hashMapLabel.set("f_gre_grupo_i","");
    hashMapLabel.set("gre_grupo","Grupo Econômico");
    hashMapLabel.set("gre_descricao","");
    hashMapLabel.set("f_gre_grupo_f","");
    hashMapLabel.set("codigo_marca","Marca");
    hashMapLabel.set("descricao_marca","");
    hashMapLabel.set("tra_cdgo","Transportadora");
    hashMapLabel.set("desc_tra","");
    hashMapLabel.set("sigla_transportadora","Sigla Transp.");
    hashMapLabel.set("nfs_cons","Consignatário");
    hashMapLabel.set("nfs_cons_desc","");
    hashMapLabel.set("ano_fatura","Ano da Fatura");
    hashMapLabel.set("numero_fatura","Número da Fatura");
    hashMapLabel.set("dt_inicial","Data Inicial");
    hashMapLabel.set("dt_final","Data Final");
    hashMapLabel.set("especie","Espécie");
    hashMapLabel.set("reg","");
    hashMapLabel.set("rep","");
    hashMapLabel.set("filial","");
    hashMapLabel.set("tipo_estoque","");
    hashMapLabel.set("nro_romaneio","Romaneio");
    hashMapLabel.set("cb_notas_fretes","Notas Fretes");
    hashMapLabel.set("cb_notas_remessa","Notas Remessa");
    hashMapLabel.set("cb_amostra","Amostra");
    hashMapLabel.set("cb_brindes","Brindes");
    hashMapLabel.set("cb_sem_ocorrencia_entrega","Sem Ocorrência Entrega");
    hashMapLabel.set("cb_notas_em_devolucao","Notas em Devolução");
    hashMapLabel.set("romaneio","Romaneio");
    hashMapLabel.set("desconsidera_notas_entrada","Desconsidera Notas Entrada");
    hashMapLabel.set("gera_excel","Gera Arquivo Excel");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Consulta de Notas Fiscais
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(72)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ConsultaNotaFiscalForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <%
                      if(!((acesso.Usuario)session.getAttribute("User")).isTipo("DESPACHANTE")){
                        %>
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
                        <%
                      } else {
                        %>
                        <div class\='div10l'>
                          Um dos campos com
                          <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                          deve ser preenchido.
                        </div>
                        <%
                      }
                      %>
                    </div>
                    <html:errors property="nfs_nmro"/>
                    <html:errors property="emp_empresa"/>
                    <html:errors property="emp_razsoc"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="fil_razsoc"/>
                    <html:errors property="codigo_regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="est_unifed"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="esc_seqn"/>
                    <html:errors property="gre_grupo"/>
                    <html:errors property="gre_descricao"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="descricao_marca"/>
                    <html:errors property="tra_cdgo"/>
                    <html:errors property="desc_tra"/>
                    <html:errors property="sigla_transportadora"/>
                    <html:errors property="nfs_cons"/>
                    <html:errors property="nfs_cons_desc"/>
                    <html:errors property="ano_fatura"/>
                    <html:errors property="numero_fatura"/>
                    <html:errors property="dt_inicial"/>
                    <html:errors property="dt_final"/>
                    <html:errors property="especie"/>
                    <html:errors property="nro_romaneio"/>
                    <html:errors property="cb_notas_fretes"/>
                    <html:errors property="cb_notas_remessa"/>
                    <html:errors property="cb_amostra"/>
                    <html:errors property="cb_brindes"/>
                    <html:errors property="cb_sem_ocorrencia_entrega"/>
                    <html:errors property="cb_notas_em_devolucao"/>
                    <html:errors property="romaneio"/>
                    <html:errors property="desconsidera_notas_entrada"/>
                    <html:errors property="gera_excel"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                util.consultas.Query query = new util.consultas.Query();
                boolean bloqueiaConsignatario = false;
                boolean libera_fatura = false;
                String codigo_regional="";
                String codigo_representante="";
                String codigo_analista="";
                String codigo_cliente="";
                String grupo_economico="";
                String transportadora="";
                String consignatario="";
                boolean despachante = false;
                acesso.Sessao se = new acesso.Sessao(session);
                String tipo = se.getTipoEntidadeNegocio();

                if(user.isSuperUsuario()){
                  libera_fatura = true;
                }
                if(tipo.equals("DESPACHANTE")) {
                  despachante = true;
                  libera_fatura = true;
                }
                if(tipo.equals("AREAS")){
                  libera_fatura = true;
                }
                if(tipo.equals("CONSIGNATARIO")) {
                  consignatario = se.getChave();
                }
                if(tipo.equals("TRANSPORTADORA")) {
                  String csg = query.retorna("SELECT t.tra_trans_consig from tra t where t.tra_cdgo = " + se.getChave());
                  if(csg.equalsIgnoreCase("S")){
                    bloqueiaConsignatario = true;
                  }
                  libera_fatura = true;
                  transportadora = se.getChave();
                }
                if(tipo.equals("REGIONAL DE VENDA")){
                  codigo_regional = se.getChave();
                }
                if((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))){
                  codigo_representante = se.getChave();
                }
                if(tipo.equals("ANALISTA REGIONAL")){
                  codigo_analista = se.getChave();
                }
                if(tipo.equals("CLIENTE MERCADO INTERNO")){
                  codigo_cliente = se.getChave();
                }
                if(tipo.equals("GRUPO ECONOMICO")){
                  grupo_economico = se.getChave();
                }

                if(tipo.equals("ANALISTA REGIONAL")) {
                  com.egen.util.jdbc.JdbcUtil j = null;
                  try {
                    j = new com.egen.util.jdbc.JdbcUtil();
                    portalbr.dbobj.view.Jw_regional_analista table = new portalbr.dbobj.view.Jw_regional_analista();
                    String[][] select = null;
                    Object[][] where = {{"codigo_gerente","=",codigo_analista} };
                    Vector res_Jw_regional_analista = j.select(table, select, where, null, null, null);
                    if (res_Jw_regional_analista != null && res_Jw_regional_analista.size() > 0) {
                      portalbr.dbobj.view.Jw_regional_analista r = (portalbr.dbobj.view.Jw_regional_analista) res_Jw_regional_analista.elementAt(0);
                      codigo_regional = r.getCodigo_regional();
                    }
                  } finally {
                    if(j!=null){
                      j.close();
                      j = null;
                    }
                  }
                }
                %>
                <%
                if(!despachante){
                  %>
                  <%
                  if(codigo_cliente.equals("")){
                    %>
                    <tr>
                      <td class="formLabel">
                        <span class="spamFormLabel" >
                          Número
                        </span>
                        <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      </td>
                      <td class="formField">
                        <html:text property="nfs_nmro" styleClass="baseField" size="7" maxlength="7"/>
                      </td>
                    </tr>
                    <%
                  } else {
                    %>
                    <tr>
                      <td class="formLabel">
                        <span class="spamFormLabel" >
                          Número
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="nfs_nmro" styleClass="baseField" size="6" maxlength="6"/>
                      </td>
                    </tr>
                    <%
                  }
                  %>
                  <%
                } else {
                  %>
                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Número
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="nfs_nmro" styleClass="baseField" size="6" maxlength="6"/>
                    </td>
                  </tr>
                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Empresa
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="emp_empresa" styleId="emp_empresa" onblur="fillFields(0,new Array('emp_empresa'),'ConsultaNotaFiscalActionForm.getEmp_razsoc_Ajax',new Array('emp_razsoc'));" styleClass="baseField" size="3"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_emp_empresa()"  >
                    <script type="text/javascript">
                      function lov_open_emp_empresa() {
                        window.open('..//lov/LvEmpresaLov.do?resetfull_action=&returnBlock=0&return0=emp_empresa&return1=emp_razsoc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="emp_razsoc" styleId="emp_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="50"/>
                  </td>
                </tr>

                <%
                if(codigo_cliente.equals("")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Filial
                      </span>
                      <%
                      if(!despachante) {
                        %>
                        <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                        <%
                      }
                      %>
                    </td>
                    <td class="formField">
                      <html:text property="fil_filial" onblur="fillFields(0,new Array('fil_filial'),'ConsultaNotaFiscalActionForm.getFil_razsoc_Ajax',new Array('fil_razsoc'));" styleClass="baseField" size="4" maxlength="4"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fil_filial()"  >
                      <script type="text/javascript">
                        function lov_open_fil_filial() {
                          window.open('../lov/LvFilialLov.jsp?returnBlock=0&return0=fil_filial','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="fil_razsoc" styleId="fil_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="55" maxlength="50"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>
                  <html:hidden property="fil_filial"/>
                  <html:hidden property="fil_razsoc"/>
                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Regional
                    </span>
                    <%
                    if(!despachante) {
                      %>
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      <%
                    }
                    %>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_regional" styleId="codigo_regional" onblur="fillFields(0,new Array('codigo_regional'),'ConsultaNotaFiscalActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="baseField" size="3"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_regional()"  >
                    <script type="text/javascript">
                      function lov_open_codigo_regional() {
                        window.open('..//lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=codigo_regional&return1=nome_regional','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      UF
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="est_unifed" styleId="est_unifed" styleClass="baseField" size="2"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Representante
                    </span>
                    <%
                    if(!despachante) {
                      %>
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      <%
                    }
                    %>
                  </td>
                  <td class="formField">
                    <html:text property="rep_cdgo" styleId="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'ConsultaNotaFiscalActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="5"/>
                    <input type="button" class="lovButton" tabindex="-1"  value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_rep_cdgo() {
                        window.open('..//lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="42" maxlength="35"/>
                  </td>
                </tr>

                <%
                if(codigo_cliente.equals("")){
                  %>
                  <%
                  if(!despachante) {
                    %>
                    <tr>
                      <td class="formLabel">
                        <span class="spamFormLabel" >
                          Cliente
                        </span>
                        <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      </td>
                      <td class="formField">
                        <html:text property="cli_cdgo" onblur="fillFields(0,new Array('cli_cdgo'),'ConsultaNotaFiscalActionForm.getCli_cdgo_Ajax',new Array('cli_rzao'));" styleClass="baseField" size="10" maxlength="22"/>
                        <input type="button" class="lovButton" value="..." tabindex="-1" onclick="window.open('../lov/LvClienteSeqLov.do?resetfull_action=&returnBlock=0&return2=cli_cdgo&return0=cli_rzao&return1=esc_seqn','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                        <%
                      } else {
                        %>
                        <tr>
                          <td class="formLabel">
                            <span class="spamFormLabel" >
                              Cliente
                            </span>
                          </td>
                          <td class="formField">
                            <html:text property="cli_cdgo" onblur="fillFields(0,new Array('cli_cdgo'),'ConsultaNotaFiscalActionForm.getCli_cdgo_Ajax',new Array('cli_rzao'));" styleClass="baseField" size="10" maxlength="22"/>
                            <input type="button" class="lovButton" value="..." tabindex="-1" onclick="window.open('../lov/LvClienteSeqLov.do?resetfull_action=&returnBlock=0&return2=cli_cdgo&return0=cli_rzao&return1=esc_seqn','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                            <%
                          }
                          %>
                          <span class="spamFormLabel">
                          </span>
                          <html:text property="cli_rzao" styleId="cli_rzao" styleClass="disabled" tabindex="-1" size="40" maxlength="35"/>
                        </td>
                      </tr>

                      <%
                    } else {
                      %>
                      <html:hidden property="cli_cdgo" value="<%= codigo_cliente %>"/>
                      <html:hidden property="cli_rzao"/>
                      <%
                    }
                    %>
                    <%
                    if(codigo_cliente.equals("")){
                      %>
                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Seqüencial
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="esc_seqn" styleClass="baseField" size="4" maxlength="4"/>
                        </td>
                      </tr>

                      <%
                    } else {
                      %>
                      <html:hidden property="esc_seqn" />
                      <%
                    }
                    %>
                    <%
                    if(codigo_cliente.equals("")){
                      %>
                      <tr>
                        <td class="formLabel">
                          <span class="spamFormLabel" >
                            Grupo Econômico
                          </span>
                          <%
                          if(!despachante) {
                            %>
                            <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                            <%
                          }
                          %>
                        </td>
                        <td class="formField">
                          <%
                          if(grupo_economico.equals("")) {
                            %>
                            <html:text property="gre_grupo" onblur="fillFields(0,new Array('gre_grupo'),'ConsultaNotaFiscalActionForm.getGre_descricao_Ajax',new Array('gre_descricao'));" styleClass="baseField" size="6" maxlength="6"/>
                            <input type="button" class="lovButton" value="..." tabindex="-1" onclick="window.open('../lov/LvGrupoEconomicoLov.do?resetfull_action=&returnBlock=0&return0=gre_grupo&return1=gre_descricao','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                            <%
                          } else {
                            %>
                            <html:text property="gre_grupo" value="<%= grupo_economico %>" styleClass="disabled" readonly="true" tabindex="-1" size="6" maxlength="6"/>
                            <input type="button" class="lovButton" disabled="true" value="..." tabindex="-1" onclick="window.open('../lov/LvGrupoEconomicoLov.do?resetfull_action=&returnBlock=0&return0=gre_grupo&return1=gre_descricao','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                            <script>
                              fillFields(0,new Array('gre_grupo'),'ConsultaNotaFiscalActionForm.getGre_descricao_Ajax',new Array('gre_descricao'));
                            </script>
                            <%
                          }
                          %>
                          <span class="spamFormLabel">
                          </span>
                          <html:text property="gre_descricao" styleId="gre_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="30"/>
                        </td>
                      </tr>

                      <%
                    } else {
                      %>
                      <html:hidden property="gre_grupo"/>
                      <html:hidden property="gre_descricao"/>
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
                        <html:text property="codigo_marca" styleId="codigo_marca" onblur="fillFields(0,new Array('codigo_marca'),'ConsultaNotaFiscalActionForm.getDescricao_marca_Ajax',new Array('descricao_marca'));" styleClass="baseField" size="3" maxlength="3"/>
                        <input type="button" class="lovButton"  tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_marca()"  >
                        <script type="text/javascript">
                          function lov_open_codigo_marca() {
                            window.open('..//lov/LvMarcaLov.do?resetfull_action=&returnBlock=0&return0=codigo_marca&return1=descricao_marca','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                          }
                        </script>
                        <span class="spamFormLabel">
                        </span>
                        <html:text property="descricao_marca" styleId="descricao_marca" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="30"/>
                      </td>
                    </tr>

                    <%
                    if(transportadora.equals("")){
                      %>

                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Transportadora
                          </span>
                          <%
                          if(!despachante) {
                            %>
                            <img src="../img/opcional.gif" border="0"/>
                            <%
                          }
                          %>
                        </td>
                        <td class="formField">
                          <html:text property="tra_cdgo" styleId="tra_cdgo" onblur="fillFields(0,new Array('tra_cdgo'),'ConsultaNotaFiscalActionForm.getDesc_tra_Ajax',new Array('desc_tra'));" styleClass="baseField" size="6"/>
                          <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_tra_cdgo()"  >
                          <script type="text/javascript">
                            function lov_open_tra_cdgo() {
                            window.open('..//lov/LvTransportadoraLov.do?select_action=&returnBlock=0&return0=tra_cdgo','','scrollbars=yes,height=510,width=730,top=0,left=0,');}
                          </script>
                          <span class="spamFormLabel">
                          </span>
                          <html:text property="desc_tra" styleId="desc_tra" readonly="true" styleClass="disabled" tabindex="-1" size="45" maxlength="40"/>
                        </td>
                      </tr>

                      <%
                    } else {
                      %>


                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Transportadora
                          </span>
                          <img src="../img/opcional.gif" border="0"/>
                        </td>
                        <td class="formField">
                          <html:text property="tra_cdgo" styleId="tra_cdgo" value="<%= transportadora %>" styleClass="disabled" size="6" tabindex="-1" readonly="true"/>
                          <html:text property="desc_tra" styleId="desc_tra" styleClass="disabled" tabindex="-1" size="45" readonly="true"/>
                        </td>
                      </tr>

                      <%
                    }
                    %>
                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Sigla Transp.
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="sigla_transportadora" styleId="sigla_transportadora" styleClass="baseField" size="6"/>
                      </td>
                    </tr>

                    <%
                    if(!bloqueiaConsignatario){
                      %>

                      <%
                      if(consignatario.equals("")) {
                        %>
                        <tr class="itemTr">
                          <td class="formLabel">
                            <span class="spamFormLabel">
                              Consignatário
                            </span>
                            <%
                            if(!despachante) {
                              %>
                              <img src="../img/opcional.gif" border="0"/>
                              <%
                            }
                            %>
                          </td>
                          <td class="formField">
                            <html:text property="nfs_cons" styleId="nfs_cons" onblur="fillFields(0,new Array('nfs_cons'),'ConsultaNotaFiscalActionForm.getNfs_cons_desc_Ajax',new Array('nfs_cons_desc'));" styleClass="baseField" size="6"/>
                            <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_nfs_cons()"  >
                            <script type="text/javascript">
                              function lov_open_nfs_cons() {
                                window.open('..//lov/LvConsignatarioLov.do?resetfull_action=&returnBlock=0&return0=nfs_cons&return1=nfs_cons_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                              }
                            </script>

                            <span class="spamFormLabel">
                            </span>
                            <html:text property="nfs_cons_desc" styleId="nfs_cons_desc" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>
                          </td>
                        </tr>

                        <%
                      } else {
                        %>


                        <tr class="itemTr">
                          <td class="formLabel">
                            <span class="spamFormLabel">
                              Consignatário
                            </span>
                            <img src="../img/opcional.gif" border="0"/>
                          </td>
                          <td class="formField">


                            <html:text property="nfs_cons" value="<%= consignatario %>" tabindex="-1" readonly="true" styleId="nfs_cons" styleClass="disabled" size="6"/>
                            <html:text property="nfs_cons_desc" styleId="nfs_cons_desc" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>


                          </td>
                        </tr>

                        <%
                      }
                      %>

                      <%
                    } else {
                      %>

                      <html:hidden property="nfs_cons" />
                      <html:hidden property="nfs_cons_desc" />

                      <%
                    }
                    %>
                    <%
                    if(libera_fatura) {
                      %>
                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Ano da Fatura
                          </span>
                          <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                        </td>
                        <td class="formField">
                          <html:text property="ano_fatura" styleId="ano_fatura" styleClass="baseField" size="4"/>
                        </td>
                      </tr>
                      <%
                    } else {
                      %>
                      <html:hidden property="ano_fatura"/>
                      <%
                    }
                    %>

                    <%
                    if(libera_fatura) {
                      %>
                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Número da Fatura
                          </span>
                          <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                        </td>
                        <td class="formField">
                          <html:text property="numero_fatura" styleId="numero_fatura" styleClass="baseField" size="5"/>
                        </td>
                      </tr>
                      <%
                    } else {
                      %>
                      <html:hidden property="numero_fatura"/>
                      <%
                    }
                    %>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Data Inicial
                        </span>
                        <%
                        if(!despachante) {
                          %>
                          <bean:message key="jsp.fieldnotnull"/>
                          <%
                        } else {
                          %>
                          <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                          <%
                        }
                        %>
                      </td>
                      <td class="formField">
                        <html:text property="dt_inicial" styleId="dt_inicial" styleClass="baseField" size="10" maxlength="10"/>
                         
                        <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_inicial']); cal1.year_scroll = true; cal1.popup();">
                          <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                        </a>
                        <%
                        if(!despachante) {
                          %>
                          <font color="red">
                            <i>
                              Obrigatório caso a nota ou o romaneio não sejam informados
                            </i>
                          </font>
                          <%
                        }
                        %>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Data Final
                        </span>
                        <%
                        if(!despachante) {
                          %>
                          <bean:message key="jsp.fieldnotnull"/>
                          <%
                        } else {
                          %>
                          <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                          <%
                        }
                        %>
                      </td>
                      <td class="formField">
                        <html:text property="dt_final" styleId="dt_final" styleClass="baseField" size="10" maxlength="10"/>
                         
                        <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_final']); cal1.year_scroll = true; cal1.popup();">
                          <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                        </a>
                        <%
                        if(!despachante) {
                          %>
                          <font color="red">
                            <i>
                              Obrigatório caso a nota ou o romaneio não sejam informados
                            </i>
                          </font>
                          <%
                        }
                        %>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Espécie Pedido
                        </span>
                        <%
                        if(!despachante) {
                          %>
                          <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                          <%
                        }
                        %>
                      </td>
                      <td class="formField">
                        <input type="button" class="lovButton" tabindex="-1" value="Selecionar espécies"  onclick="javascript:lov_open_especie()"  >

                        <script type="text/javascript">
                          function lov_open_especie() {
                            window.open('..//lov/LvEspeciePedidoGrid.do?select_action=','','scrollbars=yes,height=510,width=600,top=0,left=0,');
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
                        int counterbl_report_Jw_tipos_produtos2 =0;
                        int i_bl_report_Jw_tipos_produtos2 =0;
                        java.util.Vector res_Jw_especies = (java.util.Vector)session.getAttribute("listaEspecies");
                        if (res_Jw_especies !=null && res_Jw_especies.size()>0) {
                          %>
                          <table id="TRbl_report_Jw_tipos_produtos" class="reportTable" style=width:340px; border=1;  >
                            <tr class="reportHeader" >
                              <td align="center">
                                Espécies Selecionadas
                              </td>
                            </tr>
                            <%
                            for (int x=0;x<res_Jw_especies.size(); x++){
                              counterbl_report_Jw_tipos_produtos2++;
                              String style="";
                              if (!((i_bl_report_Jw_tipos_produtos2%2)!=0)) {
                                style="class=rowColor";
                              } else {
                                style="class=rowBlank";
                              }
                              %>
                              <tr <%= style %> >
                                <td class="reportColumn" style="text-align:left;">
                                  <%= res_Jw_especies.elementAt(x) %>
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



                    <html:hidden property="reg" value="<%= codigo_regional %>"/>
                    <html:hidden property="rep" value="<%= codigo_representante %>"/>
                    <html:hidden property="filial"/>
                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Tipo de Ocorrência
                        </span>
                      </td>
                      <td class="formField">

                        <input type="button" class="lovButton"  value="Selecionar"  onclick="javascript:lov_open_tipo_estoque()"  >
                        <script type="text/javascript">
                          function lov_open_tipo_estoque() {
                            window.open('..//com/ConsultaNotaFiscal_tForm.jsp','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                          }
                        </script>
                      </td>
                    </tr>

                    <%
                    if(session.getAttribute("listaTipoOcorrenciasDescricao")!=null){
                      %>
                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                          </span>
                        </td>
                        <td class="formField">

                          <%
                          String style_bl_report_Cabedal="";
                          int i_bl_report_Cabedal = 0;
                          java.util.List<String> tipoOcorrencias = (java.util.List<String>)session.getAttribute("listaTipoOcorrenciasDescricao");
                          %>

                          <form  name="bl_report_Cabedal" id="bl_report_Cabedal" class="baseForm" method="post" >

                            <table id="TRbl_report_Cabedal"  class="reportTable"   style="width:300px; "  border="1" >
                              <%
                              java.lang.Integer codigo =  null;
                              java.lang.String descricao =  null;
                              %>

                              <tr class="reportTr">
                                <td class="columnTdHeader" style="text-align:left;" >
                                  Tipo de Ocorrência
                                </td>
                              </tr>


                              <%
                              for(String s : tipoOcorrencias){

                                if (!((i_bl_report_Cabedal%2)!=0)) {
                                  style_bl_report_Cabedal="rowColor";
                                } else {
                                  style_bl_report_Cabedal="rowBlank";
                                }
                                %>
                                <tr class='<%= style_bl_report_Cabedal %>' id="TRbl_report_Cabedal<%=i_bl_report_Cabedal%>" >
                                  <td class="reportColumn" style="text-align:left;" >
                                    <%= s %>
                                  </td>
                                </tr>
                                <%
                                i_bl_report_Cabedal++;
                              }
                              %>



                            </table>


                          </form>



                        </td>
                      </tr>
                      <%
                    }
                    %>


                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Romaneio
                        </span>
                        <%
                        if(!despachante) {
                          %>
                          <img src="../img/opcional.gif" border="0"/>
                        </td>
                        <%
                      }
                      %>
                      <td class="formField">
                        <html:text property="nro_romaneio" styleId="nro_romaneio" styleClass="baseField" size="7"/>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Notas Fretes
                        </span>
                      </td>
                      <td class="formField">
                        <html:checkbox property="cb_notas_fretes" styleId="cb_notas_fretes" styleClass="baseField" value="checked"/>
                        <img style=cursor:pointer src=../img/ballhelp.png border=0 onclick="javascript:window.open('../lov/HelpForm.jsp?help=Natureza Operação : 1,28,29,276,359 e notas diferentes de refaturamento.','def','scrollbars,height=400,width=340,TOP=0,LEFT=0')">
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Notas Remessa
                        </span>
                      </td>
                      <td class="formField">
                        <html:checkbox property="cb_notas_remessa" styleId="cb_notas_remessa" styleClass="baseField" value="checked"/>
                        <img style=cursor:pointer src=../img/ballhelp.png border=0 onclick="javascript:window.open('../lov/HelpForm.jsp?help=Natureza Operação : 505','def','scrollbars,height=400,width=340,TOP=0,LEFT=0')">
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Amostra
                        </span>
                      </td>
                      <td class="formField">
                        <html:checkbox property="cb_amostra" styleId="cb_amostra" styleClass="baseField" value="checked"/>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Brindes
                        </span>
                      </td>
                      <td class="formField">
                        <html:checkbox property="cb_brindes" styleId="cb_brindes" styleClass="baseField" value="checked"/>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Sem Ocorrência Entrega
                        </span>
                      </td>
                      <td class="formField">
                        <html:checkbox property="cb_sem_ocorrencia_entrega" styleId="cb_sem_ocorrencia_entrega" styleClass="baseField" value="checked"/>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Notas em Devolução
                        </span>
                      </td>
                      <td class="formField">
                        <html:checkbox property="cb_notas_em_devolucao" styleId="cb_notas_em_devolucao" styleClass="baseField" value="checked"/>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Romaneio
                        </span>
                      </td>
                      <td class="formField">
                        <html:select property="romaneio" styleId="romaneio" styleClass="baseField" size="1">
                          <html:option styleClass="baseOption" value="T">
                            Todos
                          </html:option>
                          <html:option styleClass="baseOption" value="S">
                            Sim
                          </html:option>
                          <html:option styleClass="baseOption" value="N">
                            Não
                          </html:option>
                        </html:select>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Desconsidera Notas Entrada
                        </span>
                      </td>
                      <td class="formField">
                        <html:select property="desconsidera_notas_entrada" styleId="desconsidera_notas_entrada" styleClass="baseField" size="1">
                          <html:option styleClass="baseOption" value="N">
                            Não
                          </html:option>
                          <html:option styleClass="baseOption" value="S">
                            Sim
                          </html:option>
                        </html:select>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Gera Arquivo Excel
                        </span>
                      </td>
                      <td class="formField">
                        <html:select property="gera_excel" styleId="gera_excel" styleClass="baseField">
                          <html:option styleClass="baseOption" value="N">
                            Não
                          </html:option>
                          <html:option styleClass="baseOption" value="S">
                            Sim
                          </html:option>
                          <html:option styleClass="baseOption" value="R">
                            Resumido
                          </html:option>
                          <html:option styleClass="baseOption" value="ID">
                            Abertura ID do Produto
                          </html:option>
                          <html:option styleClass="baseOption" value="NF">
                            NF
                          </html:option>
                        </html:select>
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
                      <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                      <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                      <html:submit accesskey="r" styleClass="myhidden" property="refresh_action"><bean:message bundle="ApplicationResources" key="jsp.refresh"/></html:submit>
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

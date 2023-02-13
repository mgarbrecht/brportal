<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/Saldo_estoque_gradesActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = Saldo_estoque_gradesActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("ref_cdgo","Referência");
    hashMapLabel.set("ref_desc","");
    hashMapLabel.set("cab_cdgo","Cabedal");
    hashMapLabel.set("cab_desc","");
    hashMapLabel.set("mix","Mix/Fora Mix");
    hashMapLabel.set("comp","Compr.");
    hashMapLabel.set("tipo_estoque","tipo_estoque");
    hashMapLabel.set("tipos_estoques","tipos_estoques");
    hashMapLabel.set("mostrar_imagem","Mostrar Imagem");
    hashMapLabel.set("cb_ignorar_grade_99","Ignorar Grade 99");
    var reportColumns = new Array(new Array("cab_cdgo","ref_cdgo","cor_cdgo","cor_desc","lin_cdgo","compr"),new Array("lin_cdgo2","gde_cdgo","total1"));
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Saldo Em Estoque Por Grade
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(86)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/Saldo_estoque_gradesForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="ref_desc"/>
                    <html:errors property="cab_cdgo"/>
                    <html:errors property="cab_desc"/>
                    <html:errors property="mix"/>
                    <html:errors property="comp"/>
                    <html:errors property="tipo_estoque"/>
                    <html:errors property="mostrar_imagem"/>
                    <html:errors property="cb_ignorar_grade_99"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_saldo_estoque_cores"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                session.setAttribute("opener", "saldo_estoque_grade");
                if(session.getAttribute("tipos_estoque")==null){
                  com.egen.util.jdbc.JdbcUtil j = null;
                  try {
                    j = new com.egen.util.jdbc.JdbcUtil();
                    java.util.Vector v = new java.util.Vector();
                    Jw_saldo_estoque_grade_tipo_estoque table = new Jw_saldo_estoque_grade_tipo_estoque();
                    String[][] select = null;
                    Object[][] where = null;
                    Vector res_Jw_saldo_estoque_grade_tipo_estoque = j.select(table, select, where, null, null, null);
                    session.setAttribute("res_Jw_saldo_estoque_grade_tipo_estoque",res_Jw_saldo_estoque_grade_tipo_estoque);
                    if (res_Jw_saldo_estoque_grade_tipo_estoque != null && res_Jw_saldo_estoque_grade_tipo_estoque.size() > 0) {
                      int contador = 0;
                      while (contador<res_Jw_saldo_estoque_grade_tipo_estoque.size()){
                        Jw_saldo_estoque_grade_tipo_estoque r = (Jw_saldo_estoque_grade_tipo_estoque) res_Jw_saldo_estoque_grade_tipo_estoque.elementAt(contador);
                        v.add(r.getCodigo()+"-"+r.getDescricao());
                        contador++;
                      }
                    }
                    session.setAttribute("tipos_estoque", v);
                  } finally {
                    if (j != null) {
                      j.close();
                      j = null;
                    }
                  }
                }
                if(session.getAttribute("codigos_estoque")==null){
                  util.consultas.Query query = new util.consultas.Query();
                  session.setAttribute("codigos_estoque", query.retorna("select rowtocol('SELECT codigo FROM dom_tipo_estoque WHERE codigo IN (SELECT to_number(valor) FROM wbrio.parametros WHERE par_sist_codigo = ''BRNET'' AND nome = ''saldo_estoque_grade_tipo_estoque'')') from dual"));
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" onblur="fillFields(0,new Array('lin_cdgo'),'Saldo_estoque_gradesActionForm.getLin_nome_Ajax',new Array('lin_nome'));" styleClass="baseField" tabindex="1" size="7"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('../lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_nome" styleId="lin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="28" maxlength="25"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Referência
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ref_cdgo" onblur="fillFields(0,new Array('lin_cdgo','ref_cdgo'),'Saldo_estoque_gradesActionForm.getRef_desc_Ajax',new Array('ref_desc'));" styleClass="baseField" tabindex="2" size="7"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_ref_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_ref_cdgo() {
                        window.open('../lov/LvRefLov.do?resetfull_action=&returnBlock=0&return0=ref_cdgo&return1=ref_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="ref_desc" styleId="ref_desc" styleClass="disabled" tabindex="-1" readonly="true" size="28" maxlength="25"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cabedal
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cab_cdgo" onblur="fillFields(0,new Array('cab_cdgo'),'Saldo_estoque_gradesActionForm.getCab_desc_Ajax',new Array('cab_desc'));" styleClass="baseField" tabindex="3" size="7"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cab_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_cab_cdgo() {
                        window.open('../lov/LvCabedalLov.do?resetfull_action=&returnBlock=0&return0=cab_cdgo&return1=cab_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
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
                      Mix/Fora Mix
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="mix" styleId="mix" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="T\"selected='selected'">
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

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Compr.
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="comp" styleClass="baseField" tabindex="4" size="1">
                      <html:option styleClass="baseOption" value="1">
                        Disponível
                      </html:option>
                      <html:option styleClass="baseOption" value="2">
                        Empenhado
                      </html:option>
                      <html:option styleClass="baseOption" value="null">
                        Todos
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="tipo_estoque" disabled="true" styleId="tipo_estoque" styleClass="myhidden"/>
                    <input type="button" class="lovButton"  value="Tipo de Estoque"  onclick="javascript:lov_open_tipo_estoque()"  >
                    <script type="text/javascript">
                      function lov_open_tipo_estoque() {
                        window.open('..//lov/LvTipoEstoqueGrdGrid.do?select_action=&opener=saldo_estoque_grade','','scrollbars=yes,height=510,width=730,top=0,left=0,');
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
                    java.util.Vector res_Jw_clientes_grupos_economicos = (java.util.Vector)session.getAttribute("tipos_estoque");
                    if (res_Jw_clientes_grupos_economicos!=null && res_Jw_clientes_grupos_economicos.size()>0) {
                      %>
                      <table id="TRbl_report_Jw_clientes_enderecos" class="reportTable" style=width:340px; border=1;  >
                        <tr class="reportHeader" >
                          <td align="center">
                            Tipo Estoque selecionados
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
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Mostrar Imagem
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="mostrar_imagem" onchange="refresh_action.click();" styleClass="baseField" size="1">
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
                      Ignorar Grade 99
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_ignorar_grade_99" styleId="cb_ignorar_grade_99" styleClass="baseField" value="1"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="p" tabindex="6" onclick="bloqueia();resetfull1_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
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
                  <html:submit styleClass="myhidden" property="refresh_action"><bean:message bundle="ApplicationResources" key="jsp.refresh"/></html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form><script type="text/javascript">
                  var focusControl = document.forms[0].elements["lin_cdgo"];
                  if (focusControl.type != "hidden"){
                    focusControl.focus();
                  }
                </script>

                <%
                //-------------------------------------------------------------------------------------------
                // Autor             : Mateus Garbrecht (TechnoCorp)
                // Data de Criação   : 23/02/2006
                // Objetivo          : Relatório que mostra os registros retornados pela consulta na java view:
                //                     portalbr.dbobj.view.Jw_saldo_estoque_cores.
                //                     Para cada registro retornado, é feito uma consulta na java view:
                //                     portalbr.dbobj.view.Jw_saldo_estoque_grades_dados, pra mostrar os
                //                     detalhes.
                //-------------------------------------------------------------------------------------------
                %>
                <%
                session.setAttribute("saldo","N");
                int counterbl_report_Jw_saldo_estoque_cores=0;
                util.consultas.Parametros parametros = new util.consultas.Parametros();
                String diretorio_imagem = parametros.retornaParametro("diretorio_imagens_ranking");
                String ignorarGrade99 = "N";
                if(session.getAttribute("attr_ignorar_grade_99") != null) {
                  ignorarGrade99 = (String)session.getAttribute("attr_ignorar_grade_99");
                }
                {
                  com.egen.util.jdbc.JdbcUtil j = null;
                  try{
                    j = new com.egen.util.jdbc.JdbcUtil();
                    util.consultas.Query qr = new util.consultas.Query();
                    portalbr.com.Saldo_estoque_gradesActionForm Saldo_estoque_gradesActionForm = (portalbr.com.Saldo_estoque_gradesActionForm)session.getAttribute("Saldo_estoque_gradesActionForm");
                    portalbr.dbobj.view.Jw_saldo_estoque_grades_dados table = new portalbr.dbobj.view.Jw_saldo_estoque_grades_dados();
                    portalbr.dbobj.view.Jw_saldo_estoque_cores t_jw_saldo_estoque_cores = new portalbr.dbobj.view.Jw_saldo_estoque_cores();
                    java.util.Vector res_Jw_saldo_estoque_cores = (java.util.Vector)session.getAttribute("res_Jw_saldo_estoque_cores");
                    if (res_Jw_saldo_estoque_cores!=null && res_Jw_saldo_estoque_cores.size()>0) {
                      java.lang.Integer cab_cdgo  = null;
                      java.lang.String cab_desc   = null;
                      java.lang.Integer ref_cdgo  = null;
                      java.lang.Integer cor_cdgo  = null;
                      java.lang.String cor_desc   = null;
                      java.lang.Integer lin_cdgo  = null;
                      java.lang.String referencia = null;
                      StringBuilder imagem = new StringBuilder();

                      int i_bl_report_Jw_saldo_estoque_cores = 0;

                      t_jw_saldo_estoque_cores = (portalbr.dbobj.view.Jw_saldo_estoque_cores)res_Jw_saldo_estoque_cores.elementAt(i_bl_report_Jw_saldo_estoque_cores);
                      cab_cdgo = t_jw_saldo_estoque_cores.getCab_cdgo();
                      ref_cdgo = t_jw_saldo_estoque_cores.getRef_cdgo();
                      cor_cdgo = t_jw_saldo_estoque_cores.getCor_cdgo();
                      cor_desc = t_jw_saldo_estoque_cores.getCor_desc()==null?"":t_jw_saldo_estoque_cores.getCor_desc();
                      cab_desc = t_jw_saldo_estoque_cores.getCab_desc()==null?"":t_jw_saldo_estoque_cores.getCab_desc();
                      lin_cdgo = t_jw_saldo_estoque_cores.getLin_cdgo();
                      referencia = ref_cdgo+"";

                      if ((ref_cdgo+"").length()==1){
                        referencia = "00" + ref_cdgo;
                      }
                      if ((ref_cdgo+"").length()==2){
                        referencia = "0" + ref_cdgo;
                      }

                      imagem = new StringBuilder(diretorio_imagem).append(qr.retorna("SELECT fct_retorna_fit_imagem("+lin_cdgo+","+referencia+","+cab_cdgo+","+cor_cdgo+") FROM dual"));

                      while (i_bl_report_Jw_saldo_estoque_cores<res_Jw_saldo_estoque_cores.size()){
                        counterbl_report_Jw_saldo_estoque_cores++;
                        String style="";
                        if (!((i_bl_report_Jw_saldo_estoque_cores%2)!=0)) {
                          style="class=rowColor";
                        } else {
                          style="class=rowBlank";
                        }
                        %>
                        <table id="TRbl_report_Jw_saldo_estoque_cores" class="reportTable" style=width:99%;  border=1  frame=box>
                          <tr class="reportHeader2" >
                            <%
                            if(Saldo_estoque_gradesActionForm.getMostrar_imagem().equals("S")){
                              %>
                              <td class="reportColumn" style="text-align:center;" width=1>
                              </td>
                              <%
                            }
                            %>
                            <td class="columnTdHeader" style="text-align:left;" width="20%";>
                              Referência
                            </td>
                            <td class="columnTdHeader" style="text-align:left;" >
                              Cabedal
                            </td>
                            <td class="columnTdHeader" style="text-align:left;" >
                              Cor
                            </td>
                          </tr>
                          <%
                          //-----------------------------------------------------------------------------------
                          StringBuilder query = new StringBuilder();
                          query.append(" SELECT /*+ all_rows */ ");
                          query.append("        d.emp_empresa ");
                          query.append("      , d.fil_filial ");
                          query.append("      , d.unn_codigo ");
                          query.append("      , d.les_codigo ");
                          query.append("      , l.descricao dsp_les_codigo ");
                          query.append("      , d.tes_codigo ");
                          query.append("      , d.tco_codigo ");
                          query.append("      , d.gde_cdgo gde_codigo ");
                          query.append("      , g.gde_tota ");
                          query.append("      , (sum(d.qtde_atual) / g.gde_tota) caixas ");
                          query.append("      , sum(d.qtde_atual) quantidade ");
                          query.append("      , dte.descricao tes_descricao ");
                          query.append("      , dtc.descricao tco_descricao ");
                          query.append("   FROM dom_local_item_estoque_gre d ");
                          query.append("      , gre g ");
                          query.append("      , dom_local_estoque l ");
                          query.append("      , dom_tipo_estoque dte ");
                          query.append("      , dom_tipo_comprometimento dtc ");
                          query.append("  WHERE d.gde_cdgo   = g.gde_cdgo ");
                          query.append("    AND dtc.codigo   = d.tco_codigo ");
                          query.append("    AND dte.codigo   = d.tes_codigo ");
                          query.append("    AND d.gde_cdgo   is not null ");
                          query.append("    AND l.codigo     = d.les_codigo ");
                          query.append("    AND d.ies_codigo = fct_ies_codigo(").append(lin_cdgo).append(",").append(ref_cdgo).append(",").append(cab_cdgo).append(") ");
                          query.append("    AND d.cor_cdgo   = ").append(cor_cdgo);
                          query.append("    AND d.tco_codigo = nvl(").append(Saldo_estoque_gradesActionForm.getComp()).append(",d.tco_codigo) ");
                          query.append("    AND (NVL('"+(String)session.getAttribute("attr_mix")+"', 'T') = 'T' OR fct_mix_produto(").append(lin_cdgo).append(",").append(ref_cdgo).append(") = '"+(String)session.getAttribute("attr_mix")+"') ");
                          query.append("    AND d.gde_cdgo not in (90, 99) ");
                          if(ignorarGrade99.equals("S")) {
                            query.append(" AND d.gde_cdgo <> 99 ");
                          }
                          query.append("    AND d.tes_codigo in ("+(String)session.getAttribute("codigos_estoque")+") ");
                          query.append("  GROUP BY d.emp_empresa ");
                          query.append("         , d.fil_filial ");
                          query.append("         , d.unn_codigo ");
                          query.append("         , d.les_codigo ");
                          query.append("         , l.descricao ");
                          query.append("         , d.tes_codigo ");
                          query.append("         , d.tco_codigo ");
                          query.append("         , d.gde_cdgo ");
                          query.append("         , g.gde_tota ");
                          query.append("         , dte.descricao ");
                          query.append("         , dtc.descricao ");
                          query.append(" HAVING SUM(d.qtde_atual) > 0 ");
                          query.append(" UNION ");
                          query.append(" ( SELECT d.emp_empresa ");
                          query.append("        , d.fil_filial ");
                          query.append("        , d.unn_codigo ");
                          query.append("        , d.les_codigo ");
                          query.append("        , l.descricao ");
                          query.append("        , d.tes_codigo ");
                          query.append("        , d.tco_codigo ");
                          query.append("        , d.gde_cdgo ");
                          query.append("        , 0 gde_tota ");
                          query.append("        , sum(0) caixas ");
                          query.append("        , sum(d.qtde_atual) total_pares ");
                          query.append("        , dte.descricao tes_descricao ");
                          query.append("        , dtc.descricao tco_descricao ");
                          query.append("     FROM dom_local_item_estoque_gre d ");
                          query.append("        , dom_local_estoque l ");
                          query.append("        , dom_tipo_estoque dte ");
                          query.append("        , dom_tipo_comprometimento dtc ");
                          query.append("    WHERE d.gde_cdgo   is not null ");
                          query.append("      AND dtc.codigo   = d.tco_codigo ");
                          query.append("      AND dte.codigo   = d.tes_codigo ");
                          query.append("      AND l.codigo     = d.les_codigo ");
                          query.append("      AND d.ies_codigo = fct_ies_codigo(").append(lin_cdgo).append(",").append(ref_cdgo).append(",").append(cab_cdgo).append(") ");
                          query.append("      AND d.cor_cdgo   = ").append(cor_cdgo);
                          query.append("      AND d.tco_codigo = nvl(").append(Saldo_estoque_gradesActionForm.getComp()).append(",d.tco_codigo) ");
                          query.append("      AND d.gde_cdgo in (90, 99) ");
                          if(ignorarGrade99.equals("S")) {
                            query.append(" AND d.gde_cdgo <> 99 ");
                          }
                          query.append("      AND d.tes_codigo in ("+(String)session.getAttribute("codigos_estoque")+") ");
                          query.append("    GROUP BY d.emp_empresa ");
                          query.append("           , d.fil_filial ");
                          query.append("           , d.unn_codigo ");
                          query.append("           , d.les_codigo ");
                          query.append("           , l.descricao ");
                          query.append("           , d.tes_codigo ");
                          query.append("           , d.tco_codigo ");
                          query.append("           , d.gde_cdgo ");
                          query.append("           , 0 ");
                          query.append("           , dte.descricao ");
                          query.append("           , dtc.descricao ");
                          query.append("    HAVING sum(d.qtde_atual)> 0) ");
                          query.append("     ORDER BY emp_empresa ");
                          query.append("            , fil_filial ");
                          query.append("            , dsp_les_codigo ");
                          query.append("            , tes_codigo ");
                          query.append("            , tco_codigo ");
                          query.append("            , gde_codigo ");

                          Vector res_Jw_saldo_estoque_grades_dados = j.select(table,
                          query.toString(),
                          null);

                          //------------------------------------------------------------------------------------
                          %>
                          <tr <%= style %> id='TRbl_report_Jw_saldo_estoque_cores<%=counterbl_report_Jw_saldo_estoque_cores%>' >
                            <%
                            if(Saldo_estoque_gradesActionForm.getMostrar_imagem().equals("S")){
                              %>
                              <td class="reportColumn" style="text-align:center;" width=1>
                                <img src="<%= imagem.toString() %>" width=67 height=37>
                              </td>
                              <%
                            }
                            %>
                            <td class="reportColumn" style="text-align:left;">
                              <%= ((ref_cdgo!=null)?ref_cdgo.toString():"") %>
                            </td>
                            <td class="reportColumn" style="text-align:left;" >
                              <%= ((cab_cdgo!=null)?cab_cdgo.toString():"") %>
                              -
                              <%= cab_desc %>
                            </td>
                            <td class="reportColumn" style="text-align:left;">
                              <%= ((cor_cdgo!=null)?cor_cdgo.toString():"") %>
                              -
                              <%= cor_desc %>
                            </td>
                          </tr>
                        </table>

                        <table id="TRbl_report_Jw_saldo_estoque_grades_dados" class="reportTable" style=width:99%;  border=1  frame=box>
                          <%
                          int counterbl_report_Jw_saldo_estoque_grades_dados=0;
                          {

                            portalbr.dbobj.view.Jw_saldo_estoque_grades_dados t_jw_saldo_estoque_grades_dados = new portalbr.dbobj.view.Jw_saldo_estoque_grades_dados();

                            if (res_Jw_saldo_estoque_grades_dados!=null && res_Jw_saldo_estoque_grades_dados.size()>0) {
                              session.setAttribute("saldo","S");
                              java.lang.String emp_empresa    =  null;
                              java.lang.String fil_filial     =  null;
                              java.lang.String unn_codigo     =  null;
                              java.lang.String dsp_les_codigo =  null;
                              java.lang.String tco_descricao  =  null;
                              java.lang.String tes_descricao  =  null;
                              double les_codigo =  0;
                              double tes_codigo =  0;
                              double tco_codigo =  0;
                              double gde_codigo =  0;
                              double gde_tota   =  0;
                              double caixas     =  0;
                              double quantidade =  0;
                              int i_bl_report_Jw_saldo_estoque_grades_dados = 0;
                              t_jw_saldo_estoque_grades_dados = (portalbr.dbobj.view.Jw_saldo_estoque_grades_dados)res_Jw_saldo_estoque_grades_dados.elementAt(i_bl_report_Jw_saldo_estoque_grades_dados);
                              emp_empresa    = t_jw_saldo_estoque_grades_dados.getEmp_empresa()==null?"":t_jw_saldo_estoque_grades_dados.getEmp_empresa();
                              fil_filial     = t_jw_saldo_estoque_grades_dados.getFil_filial()==null?"":t_jw_saldo_estoque_grades_dados.getFil_filial();
                              tes_descricao  = t_jw_saldo_estoque_grades_dados.getTes_descricao()==null?"":t_jw_saldo_estoque_grades_dados.getTes_descricao();
                              tco_descricao  = t_jw_saldo_estoque_grades_dados.getTco_descricao()==null?"":t_jw_saldo_estoque_grades_dados.getTco_descricao();
                              unn_codigo     = t_jw_saldo_estoque_grades_dados.getUnn_codigo()==null?"":t_jw_saldo_estoque_grades_dados.getUnn_codigo();
                              les_codigo     = t_jw_saldo_estoque_grades_dados.getLes_codigo();
                              dsp_les_codigo = t_jw_saldo_estoque_grades_dados.getDsp_les_codigo()==null?"":t_jw_saldo_estoque_grades_dados.getDsp_les_codigo();
                              tes_codigo     = t_jw_saldo_estoque_grades_dados.getTes_codigo();
                              tco_codigo     = t_jw_saldo_estoque_grades_dados.getTco_codigo();
                              gde_codigo     = t_jw_saldo_estoque_grades_dados.getGde_codigo();
                              gde_tota       = t_jw_saldo_estoque_grades_dados.getGde_tota();
                              caixas         = t_jw_saldo_estoque_grades_dados.getCaixas();
                              quantidade     = t_jw_saldo_estoque_grades_dados.getQuantidade();
                              %>
                              <tr class="reportHeader" >
                                <td class="columnTdHeader" style="text-align:left;" width="5%";>
                                  Empresa
                                </td>
                                <td class="columnTdHeader" style="text-align:left;" width="5%";>
                                  Filial
                                </td>
                                <td class="columnTdHeader" style="text-align:left;" width="5%";>
                                  Unn
                                </td>
                                <td class="columnTdHeader" style="text-align:left;">
                                  Local
                                </td>
                                <td class="columnTdHeader" style="text-align:left;" >
                                  Tes
                                </td>
                                <td class="columnTdHeader" style="text-align:left;" >
                                  Tco
                                </td>
                                <td class="columnTdHeader" style="text-align:right;" width="5%";>
                                  Gde
                                </td>
                                <td class="columnTdHeader" style="text-align:right;" width="5%";>
                                  Caixas
                                </td>
                                <td class="columnTdHeader" style="text-align:right;" width="10%";>
                                  Quantidade
                                </td>
                                <td class="columnTdHeader" style="text-align:center;" width="5%";>
                                  Ver Grade
                                </td>
                              </tr>
                              <%
                              while (i_bl_report_Jw_saldo_estoque_grades_dados<res_Jw_saldo_estoque_grades_dados.size()){
                                counterbl_report_Jw_saldo_estoque_grades_dados++;

                                if (!((i_bl_report_Jw_saldo_estoque_grades_dados%2)!=0)) {
                                  style="class=rowColor";
                                } else {
                                  style="class=rowBlank";
                                }
                                %>
                                <tr <%= style %> id='TRbl_report_Jw_saldo_estoque_grades_dados<%=counterbl_report_Jw_saldo_estoque_grades_dados%>' >
                                  <td class="reportColumn" style="text-align:left;" width="5%";>
                                    <%= emp_empresa %>
                                  </td>
                                  <td class="reportColumn" style="text-align:left;" width="5%";>
                                    <%= fil_filial %>
                                  </td>
                                  <td class="reportColumn" style="text-align:left;" width="5%";>
                                    <%= unn_codigo %>
                                  </td>
                                  <td class="reportColumn" style="text-align:left;">
                                    <%= com.egen.util.text.FormatNumber.format(les_codigo, "0") %>
                                    -
                                    <%= dsp_les_codigo %>
                                  </td>
                                  <td class="reportColumn" style="text-align:left;" >
                                    <%= com.egen.util.text.FormatNumber.format(tes_codigo, "0") %>
                                    -
                                    <%= tes_descricao %>
                                  </td>
                                  <td class="reportColumn" style="text-align:left;">
                                    <%= com.egen.util.text.FormatNumber.format(tco_codigo, "0") %>
                                    -
                                    <%= tco_descricao %>
                                  </td>
                                  <td class="reportColumn" style="text-align:right;" width="5%";>
                                    <%= com.egen.util.text.FormatNumber.format(gde_codigo, "0") %>
                                  </td>
                                  <td class="reportColumn" style="text-align:right;" width="5%";>
                                    <%= com.egen.util.text.FormatNumber.format(caixas, "0") %>
                                  </td>
                                  <td class="reportColumn" style="text-align:right;" width="10%";>
                                    <%= com.egen.util.text.FormatNumber.format(quantidade, "##,##0.00") %>
                                  </td>
                                  <td class="reportColumn" style="text-align:center;" width="5%"; title="Ver Grade: <%= com.egen.util.text.FormatNumber.format(gde_codigo, "0") %>">
                                    <img src="../img/viewmag.png" name="imagem" onmouseover="this.src='../img/viewmag_s.png'" onmouseout="this.src='../img/viewmag.png'" onclick="wopen('../com/Saldo_estoque_grades_gForm.do?select_action=&emp_empresa=<%= emp_empresa %>&fil_filial=<%= fil_filial %>&unn_codigo=<%= unn_codigo %>&les_codigo=<%= com.egen.util.text.FormatNumber.format(les_codigo, "0") %>&tes_codigo=<%= com.egen.util.text.FormatNumber.format(tes_codigo, "0") %>&tco_codigo=<%= com.egen.util.text.FormatNumber.format(tco_codigo, "0") %>&gde_codigo=<%= com.egen.util.text.FormatNumber.format(gde_codigo, "0") %>&lin_cdgo=<%= lin_cdgo %>&ref_cdgo=<%= ref_cdgo %>&cab_cdgo=<%= cab_cdgo %>&cor_cdgo=<%= cor_cdgo %>','_blank',640,60)" STYLE="cursor:hand">
                                  </td>
                                </tr>

                                <%
                                if (++i_bl_report_Jw_saldo_estoque_grades_dados >= res_Jw_saldo_estoque_grades_dados.size()) {
                                  break;
                                }
                                t_jw_saldo_estoque_grades_dados = (portalbr.dbobj.view.Jw_saldo_estoque_grades_dados)res_Jw_saldo_estoque_grades_dados.elementAt(i_bl_report_Jw_saldo_estoque_grades_dados);
                                emp_empresa    = t_jw_saldo_estoque_grades_dados.getEmp_empresa()==null?"":t_jw_saldo_estoque_grades_dados.getEmp_empresa();
                                fil_filial     = t_jw_saldo_estoque_grades_dados.getFil_filial()==null?"":t_jw_saldo_estoque_grades_dados.getFil_filial();
                                tes_descricao  = t_jw_saldo_estoque_grades_dados.getTes_descricao()==null?"":t_jw_saldo_estoque_grades_dados.getTes_descricao();
                                tco_descricao  = t_jw_saldo_estoque_grades_dados.getTco_descricao()==null?"":t_jw_saldo_estoque_grades_dados.getTco_descricao();
                                unn_codigo     = t_jw_saldo_estoque_grades_dados.getUnn_codigo()==null?"":t_jw_saldo_estoque_grades_dados.getUnn_codigo();
                                les_codigo     = t_jw_saldo_estoque_grades_dados.getLes_codigo();
                                dsp_les_codigo = t_jw_saldo_estoque_grades_dados.getDsp_les_codigo()==null?"":t_jw_saldo_estoque_grades_dados.getDsp_les_codigo();
                                tes_codigo     = t_jw_saldo_estoque_grades_dados.getTes_codigo();
                                tco_codigo     = t_jw_saldo_estoque_grades_dados.getTco_codigo();
                                gde_codigo     = t_jw_saldo_estoque_grades_dados.getGde_codigo();
                                gde_tota       = t_jw_saldo_estoque_grades_dados.getGde_tota();
                                caixas         = t_jw_saldo_estoque_grades_dados.getCaixas();
                                quantidade     = t_jw_saldo_estoque_grades_dados.getQuantidade();
                              }
                            }
                          }
                          %>
                        </table>
                        <br>
                        <br>
                        <br>
                        <br>

                        <%
                        if (++i_bl_report_Jw_saldo_estoque_cores >= res_Jw_saldo_estoque_cores.size()) {
                          break;
                        }
                        t_jw_saldo_estoque_cores = (portalbr.dbobj.view.Jw_saldo_estoque_cores)res_Jw_saldo_estoque_cores.elementAt(i_bl_report_Jw_saldo_estoque_cores);
                        cab_cdgo = t_jw_saldo_estoque_cores.getCab_cdgo();
                        ref_cdgo = t_jw_saldo_estoque_cores.getRef_cdgo();
                        cor_cdgo = t_jw_saldo_estoque_cores.getCor_cdgo();
                        cor_desc = t_jw_saldo_estoque_cores.getCor_desc()==null?"":t_jw_saldo_estoque_cores.getCor_desc();
                        cab_desc = t_jw_saldo_estoque_cores.getCab_desc()==null?"":t_jw_saldo_estoque_cores.getCab_desc();
                        lin_cdgo = t_jw_saldo_estoque_cores.getLin_cdgo();
                        referencia = ref_cdgo+"";
                        if ((ref_cdgo+"").length()==1){
                          referencia = "00" + ref_cdgo;
                        }
                        if ((ref_cdgo+"").length()==2){
                          referencia = "0" + ref_cdgo;
                        }
                        imagem = new StringBuilder(diretorio_imagem).append(qr.retorna("SELECT fct_retorna_fit_imagem("+lin_cdgo+","+referencia+","+cab_cdgo+","+cor_cdgo+") FROM dual"));
                      }
                    }

                  } catch (Exception e){
                  } finally {
                    if(j!=null){
                      j.close();
                      j=null;
                    }
                  }
                }
                %>
                <%
                if((session.getAttribute("saldo")+"").equals("S")){
                  %>
                  <table border=0 width="100%">
                    <tr valign="top">
                      <td width="50%">
                        <%
                        double total1_geral = 0;
                        double total_geral = 0;
                        %>
                        <table id="TRbl_report_Jw_saldo_estoque_grade_total_linha" class="reportTable" style=width:99%; border=1 >
                          <%
                          int counterbl_report_Jw_saldo_estoque_grade_total_linha=0;
                          {
                            portalbr.dbobj.view.Jw_saldo_estoque_grade_total_linha t_jw_saldo_estoque_grade_total_linha = new portalbr.dbobj.view.Jw_saldo_estoque_grade_total_linha();
                            portalbr.com.Saldo_estoque_gradesActionForm Saldo_estoque_gradesActionForm = (portalbr.com.Saldo_estoque_gradesActionForm)session.getAttribute("Saldo_estoque_gradesActionForm");
                            java.util.Vector res_Jw_saldo_estoque_grade_total_linha = null;
                            com.egen.util.jdbc.JdbcUtil j = null;
                            ignorarGrade99 = "N";
                            if(session.getAttribute("attr_ignorar_grade_99") != null) {
                              ignorarGrade99 = (String)session.getAttribute("attr_ignorar_grade_99");
                            }

                            try {
                              j = new com.egen.util.jdbc.JdbcUtil();
                              String[][] select =  null;
                              Object[][] where = null;
                              String[] groupby =  null;
                              String[] having =  null;
                              String[] order = {};
                              //    res_Jw_saldo_estoque_grade_total_linha = j.select(t_jw_saldo_estoque_grade_total_linha,select,where,groupby,having,order);


                              String cab_cdgo = "null";
                              String ref_cdgo = "null";
                              if((!((Saldo_estoque_gradesActionForm.getRef_cdgo()+"").equals("")))){
                                ref_cdgo = Saldo_estoque_gradesActionForm.getRef_cdgo()+"";
                              }
                              if((!((Saldo_estoque_gradesActionForm.getCab_cdgo()+"").equals("")))){
                                cab_cdgo = Saldo_estoque_gradesActionForm.getCab_cdgo()+"";
                              }


                              StringBuilder query1 = new StringBuilder();
                              query1.append(" SELECT /*+ all_rows */ ");
                              query1.append("        DISTINCT ");
                              query1.append("        i.lin_cdgo ");
                              query1.append("      , l.gde_cdgo ");
                              query1.append("      , sum(l.qtde_atual) total ");
                              query1.append("   FROM cor                         c ");
                              query1.append("      , cabedal                     ca ");
                              query1.append("      , dom_local_item_estoque_gre  l ");
                              query1.append("      , dom_item_estoque            i ");
                              query1.append("  WHERE l.cor_cdgo            = c.cor_cdgo  ");
                              query1.append("    AND ca.cab_cdgo           = i.cab_cdgo  ");
                              query1.append("    AND l.ies_codigo          = i.codigo ");
                              query1.append("    AND l.tco_codigo          = nvl(").append(Saldo_estoque_gradesActionForm.getComp()).append(", l.tco_codigo)  ");
                              query1.append("    AND nvl(i.tipo, null)     = 'A' ");
                              query1.append("    AND l.tes_codigo         in ("+(String)session.getAttribute("codigos_estoque")+") ");
                              query1.append("    AND l.qtde_atual          > 0 ");
                              query1.append("    AND i.lin_cdgo            = ").append(Saldo_estoque_gradesActionForm.getLin_cdgo());
                              query1.append("    AND i.ref_cdgo            = nvl(").append(ref_cdgo).append(",i.ref_cdgo) ");
                              query1.append("    AND i.cab_cdgo            = nvl(").append(cab_cdgo).append(",i.cab_cdgo) ");
                              query1.append("    AND (NVL('"+(String)session.getAttribute("attr_mix")+"', 'T') = 'T' OR fct_mix_produto(i.lin_cdgo,i.ref_cdgo) = '"+(String)session.getAttribute("attr_mix")+"') ");
                              if(ignorarGrade99.equals("S")) {
                                query1.append(" AND l.gde_cdgo <> 99 ");
                              }
                              query1.append("  GROUP BY i.lin_cdgo ");
                              query1.append("         , l.gde_cdgo ");

                              res_Jw_saldo_estoque_grade_total_linha = j.select(t_jw_saldo_estoque_grade_total_linha,
                              query1.toString(),
                              null);

                            } catch (Exception e){
                              session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                              %>
                              <jsp:forward page="/system/ErrorPage.jsp"/>
                              <%
                            } finally {
                              if(j!=null){
                                j.close();
                                j = null;
                              }
                            }

                            if (res_Jw_saldo_estoque_grade_total_linha!=null && res_Jw_saldo_estoque_grade_total_linha.size()>0) {
                              int lin_cdgo2 =  0;
                              int gde_cdgo  =  0;
                              double total1 =  0;
                              int i_bl_report_Jw_saldo_estoque_grade_total_linha = 0;
                              t_jw_saldo_estoque_grade_total_linha = (portalbr.dbobj.view.Jw_saldo_estoque_grade_total_linha)res_Jw_saldo_estoque_grade_total_linha.elementAt(i_bl_report_Jw_saldo_estoque_grade_total_linha);
                              lin_cdgo2 = t_jw_saldo_estoque_grade_total_linha.getLin_cdgo();
                              gde_cdgo = t_jw_saldo_estoque_grade_total_linha.getGde_cdgo();
                              total1 = t_jw_saldo_estoque_grade_total_linha.getTotal();
                              %>
                              <tr class="reportHeader3" >
                                <td class="columnTdHeader" style="text-align:left;" colspan = 4>
                                  <big>
                                    Total da linha por Grade
                                  </td>
                                </tr>
                                <tr class="reportHeader" >
                                  <td class="columnTdHeader" style="text-align:right;" width="40%">
                                    Grade
                                  </td>
                                  <td class="columnTdHeader" style="text-align:right;">
                                    Total
                                  </td>
                                </tr>
                                <%
                                while (i_bl_report_Jw_saldo_estoque_grade_total_linha<res_Jw_saldo_estoque_grade_total_linha.size()){
                                  counterbl_report_Jw_saldo_estoque_grade_total_linha++;
                                  String style="";
                                  if (!((i_bl_report_Jw_saldo_estoque_grade_total_linha%2)!=0)) {
                                    style="class=rowColor";
                                  } else {
                                    style="class=rowBlank";
                                  }
                                  %>
                                  <tr <%= style %> id='TRbl_report_Jw_saldo_estoque_grade_total_linha<%=counterbl_report_Jw_saldo_estoque_grade_total_linha%>' >
                                    <td class="reportColumn" style="text-align:right;" width="40%">
                                      <%= gde_cdgo %>
                                    </td>
                                    <td class="reportColumn" style="text-align:right;">
                                      <%= com.egen.util.text.FormatNumber.format(total1, "##,##0.00") %>
                                      <%
                                      total1_geral += total1;
                                      %>
                                    </td>
                                  </tr>
                                  <%
                                  if (++i_bl_report_Jw_saldo_estoque_grade_total_linha >= res_Jw_saldo_estoque_grade_total_linha.size()) {
                                    break;
                                  }
                                  t_jw_saldo_estoque_grade_total_linha = (portalbr.dbobj.view.Jw_saldo_estoque_grade_total_linha)res_Jw_saldo_estoque_grade_total_linha.elementAt(i_bl_report_Jw_saldo_estoque_grade_total_linha);
                                  lin_cdgo2 = t_jw_saldo_estoque_grade_total_linha.getLin_cdgo();
                                  gde_cdgo = t_jw_saldo_estoque_grade_total_linha.getGde_cdgo();
                                  total1 = t_jw_saldo_estoque_grade_total_linha.getTotal();
                                }
                              }
                            }
                            %>
                          </table>

                        </td>
                        <td width="50%">

                          <table id="TRbl_report_Jw_saldo_estoque_grade_total_tamanho" class="reportTable" style=width:100%; border=1; >
                            <%
                            int counterbl_report_Jw_saldo_estoque_grade_total_tamanho=0;
                            {
                              portalbr.dbobj.view.Jw_saldo_estoque_grade_total_tamanho t_jw_saldo_estoque_grade_total_tamanho = new portalbr.dbobj.view.Jw_saldo_estoque_grade_total_tamanho();
                              portalbr.com.Saldo_estoque_gradesActionForm Saldo_estoque_gradesActionForm = (portalbr.com.Saldo_estoque_gradesActionForm)session.getAttribute("Saldo_estoque_gradesActionForm");
                              java.util.Vector res_Jw_saldo_estoque_grade_total_tamanho = null;
                              com.egen.util.jdbc.JdbcUtil j = null;
                              ignorarGrade99 = "N";
                              if(session.getAttribute("attr_ignorar_grade_99") != null) {
                                ignorarGrade99 = (String)session.getAttribute("attr_ignorar_grade_99");
                              }
                              try {
                                j = new com.egen.util.jdbc.JdbcUtil();
                                String cab_cdgo = "null";
                                String ref_cdgo = "null";
                                if((!((Saldo_estoque_gradesActionForm.getRef_cdgo()+"").equals("")))){
                                  ref_cdgo = Saldo_estoque_gradesActionForm.getRef_cdgo()+"";
                                }
                                if((!((Saldo_estoque_gradesActionForm.getCab_cdgo()+"").equals("")))){
                                  cab_cdgo = Saldo_estoque_gradesActionForm.getCab_cdgo()+"";
                                }

                                StringBuilder query2 = new StringBuilder();
                                query2.append(" SELECT /*+ all_rows */ ");
                                query2.append("        DISTINCT ");
                                query2.append("        l.tai_codigo ");
                                query2.append("      , i.lin_cdgo ");
                                query2.append("      , sum(l.qtde_atual) total ");
                                query2.append("   FROM dom_local_item_estoque_gre l ");
                                query2.append("      , dom_item_estoque           i ");
                                query2.append("      , cor                        c ");
                                query2.append("      , cabedal                    ca ");
                                query2.append("  WHERE l.cor_cdgo            = c.cor_cdgo ");
                                query2.append("    AND ca.cab_cdgo           = i.cab_cdgo ");
                                query2.append("    AND l.ies_codigo          = i.codigo ");
                                query2.append("    AND nvl(i.tipo, null)     = 'A'");
                                query2.append("    AND l.tes_codigo         in ("+(String)session.getAttribute("codigos_estoque")+")");
                                query2.append("    AND l.tco_codigo          = nvl(").append(Saldo_estoque_gradesActionForm.getComp()).append(", l.tco_codigo)  ");
                                query2.append("    AND l.qtde_atual          > 0");
                                if(ignorarGrade99.equals("S")) {
                                  query2.append(" AND l.gde_cdgo <> 99 ");
                                }
                                query2.append("    AND i.lin_cdgo            = ").append(Saldo_estoque_gradesActionForm.getLin_cdgo());
                                query2.append("    AND i.ref_cdgo            = nvl(").append(ref_cdgo).append(", i.ref_cdgo)  ");
                                query2.append("    AND i.cab_cdgo            = nvl(").append(cab_cdgo).append(", i.cab_cdgo)  ");
                                query2.append("    AND (NVL('"+(String)session.getAttribute("attr_mix")+"', 'T') = 'T' OR fct_mix_produto(i.lin_cdgo,i.ref_cdgo) = '"+(String)session.getAttribute("attr_mix")+"') ");
                                query2.append("  GROUP BY i.lin_cdgo ");
                                query2.append("         , l.tai_codigo ");



                                res_Jw_saldo_estoque_grade_total_tamanho = j.select(t_jw_saldo_estoque_grade_total_tamanho,
                                query2.toString(),
                                null);

                              } catch (Exception e){
                                session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                                %>
                                <jsp:forward page="/system/ErrorPage.jsp"/>
                                <%
                              } finally {
                                if(j!=null){
                                  j.close();
                                  j = null;
                                }
                              }
                              %>
                              <%
                              if(res_Jw_saldo_estoque_grade_total_tamanho.size()>0){
                                %>
                                <table width="100%">
                                  <tr class="reportHeader3" >
                                    <td class="columnTdHeader" style="text-align:left;">
                                      <big>
                                        Total da linha por Tamanho
                                      </big>
                                    </td>
                                  </tr>
                                </table>
                                <%
                              }
                              %>
                              <table border=1 width="100%">
                                <tr class=rowBlank>
                                  <%
                                  for(int x=0;x<res_Jw_saldo_estoque_grade_total_tamanho.size();x++){
                                    t_jw_saldo_estoque_grade_total_tamanho = (portalbr.dbobj.view.Jw_saldo_estoque_grade_total_tamanho)res_Jw_saldo_estoque_grade_total_tamanho.elementAt(x);
                                    %>
                                    <td class="reportColumn" style="text-align:center;" width="12%">
                                      <%=  t_jw_saldo_estoque_grade_total_tamanho.getTai_codigo() %>
                                    </td>
                                    <%
                                  }
                                  %>
                                </tr>
                                <tr class=rowColor>
                                  <%
                                  for(int x=0;x<res_Jw_saldo_estoque_grade_total_tamanho.size();x++){
                                    t_jw_saldo_estoque_grade_total_tamanho = (portalbr.dbobj.view.Jw_saldo_estoque_grade_total_tamanho)res_Jw_saldo_estoque_grade_total_tamanho.elementAt(x);
                                    %>
                                    <td class="reportColumn" style="text-align:center;" width="12%">
                                      <%=   com.egen.util.text.FormatNumber.format(t_jw_saldo_estoque_grade_total_tamanho.getTotal(), "##,##0.00")  %>
                                      <%
                                      total_geral += t_jw_saldo_estoque_grade_total_tamanho.getTotal();
                                      %>

                                    </td>
                                    <%
                                  }
                                  %>
                                </tr>
                              </table>


                            </td>
                          </tr>
                        </table>


                        <%
                        if(total_geral>0) {
                          %>
                          <table width="100%" border=1;>
                            <tr class="reportHeader2" >
                              <td width="50%">
                                <table width="99%">
                                  <tr>
                                    <td>
                                      <big>
                                        <b>
                                          Total:
                                        </b>
                                      </big>
                                    </td>
                                    <td align="right">
                                      <big>
                                        <b>
                                          <%= com.egen.util.text.FormatNumber.format(total1_geral, "##,##0.00") %>
                                        </b>
                                      </big>
                                    </td>
                                  </tr>
                                </table>
                              </td>
                              <td>
                                <table width="100%">
                                  <tr>
                                    <td>
                                      <big>
                                        <b>
                                          Total:
                                        </b>
                                      </big>
                                    </td>
                                    <td align="right">
                                      <big>
                                        <b>
                                          <%= com.egen.util.text.FormatNumber.format(total_geral, "##,##0.00") %>
                                        </b>
                                      </big>
                                    </td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                          </table>
                          <%
                        }
                        %>

                        <%
                      }
                      %>

                      <table>
                        <tr>
                          <td>
                            <br>
                          </td>
                        </tr>
                      </table>

                      <%
                    }
                    %>
                  </td>
                </tr>
              </table>

            </body>
          </center>
        </html>

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Cadastro de Clientes
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
                  <%@ include file="../system/header_sem_ajuda.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(62)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Jw_clientes_cad_dados" class="reportTable" style=width:99%; border=1; >
              <%
              StringBuilder telefones = new StringBuilder();
              int counterbl_report_Jw_clientes_cad_dados=0;
              portalbr.adm.CadastroClientes_dActionForm CadastroClientes_dActionForm = (portalbr.adm.CadastroClientes_dActionForm)session.getAttribute("CadastroClientes_dActionForm");
              portalbr.dbobj.view.Jw_clientes_cad_dados t_jw_clientes_cad_dados = new portalbr.dbobj.view.Jw_clientes_cad_dados();
              portalbr.dbobj.view.Jw_representantes_fones  t_jw_representantes_fones = new portalbr.dbobj.view.Jw_representantes_fones();
              java.util.Vector res_Jw_representantes_fones = null;
              java.util.Vector res_Jw_clientes_cad_dados = null;
              com.egen.util.jdbc.JdbcUtil j_report = null;
              try {
                j_report = new com.egen.util.jdbc.JdbcUtil();
                if(!(CadastroClientes_dActionForm.getCli_cdgo()+"").equals("null")){

                  StringBuilder query1 = new StringBuilder();
                  query1.append(" SELECT  DISTINCT ");
                  query1.append("         cr.codigo_representante, ");
                  query1.append("         cr.codigo_representante || '-' || r.rep_nome representante, ");
                  //    query1.append("         decode(r.rep_tipo_marca,'V','Rep. Vizzano','Rep. Beira Rio') marca, ");
                  query1.append(" decode(r.rep_tipo_marca,'V','Rep. Vizzano'   , 'B','Rep. Beira Rio' ");
                  query1.append("                        ,'P','Rep. Peddy'     , 'R','Rep. Riva Bianca' ");
                  query1.append("                        ,'X','Rep. Axis'      , 'M','Rep. Moleca' ");
                  query1.append("                        ,'T','Rep. Toccado'   , 'A','') marca,");
                  query1.append("         decode(cr.situacao, 'A', 'Ativo', 'Inativo') sit_cli_rep ");
                  query1.append("        ,(SELECT replace(rowtocol('SELECT mp.descricao_marca ");
                  query1.append("  FROM representante_marca rm ");
                  query1.append("      ,marcas_produtos mp ");
                  query1.append(" WHERE mp.codigo_marca = rm.marca_produto ");
                  query1.append("   AND rm.codigo_representante = '''||cr.codigo_representante||''' ");
                  query1.append("   AND situacao = ''A'''),',',', ') FROM dual) marcas ");
                  query1.append("   FROM  cliente_representante cr, ");
                  query1.append("         rep r ");
                  query1.append("  WHERE  cr.codigo_representante = r.rep_cdgo ");
                  query1.append("    AND  rep_situ                = 'A' ");
                  query1.append("    AND  cr.codigo_cliente       = ").append(CadastroClientes_dActionForm.getCli_cdgo());
                  query1.append("    AND  cr.codigo_sequencial    = ").append(CadastroClientes_dActionForm.getEsc_seqn());
                  query1.append("    AND  cr.codigo_cliente       > 0 ");

                  res_Jw_clientes_cad_dados = j_report.select(t_jw_clientes_cad_dados,
                  query1.toString(),
                  null);

                }

                if (res_Jw_clientes_cad_dados!=null && res_Jw_clientes_cad_dados.size()>0) {
                  java.lang.String marca                =  null;
                  java.lang.String marcas               =  null;
                  java.lang.String representante        =  null;
                  java.lang.String codigo_representante =  null;
                  java.lang.String sit_cli_rep          =  null;
                  int i_bl_report_Jw_clientes_cad_dados = 0;

                  t_jw_clientes_cad_dados = (portalbr.dbobj.view.Jw_clientes_cad_dados)res_Jw_clientes_cad_dados.elementAt(i_bl_report_Jw_clientes_cad_dados);
                  marca                   = t_jw_clientes_cad_dados.getMarca()==null?"":t_jw_clientes_cad_dados.getMarca();
                  marcas                  = t_jw_clientes_cad_dados.getMarcas()==null?"":t_jw_clientes_cad_dados.getMarcas();
                  codigo_representante    = t_jw_clientes_cad_dados.getCodigo_representante()==null?"":t_jw_clientes_cad_dados.getCodigo_representante();
                  representante           = t_jw_clientes_cad_dados.getRepresentante()==null?"":t_jw_clientes_cad_dados.getRepresentante();
                  sit_cli_rep             = t_jw_clientes_cad_dados.getSit_cli_rep()==null?"":t_jw_clientes_cad_dados.getSit_cli_rep();
                  //------------- consulta os telefones ----------------------
                  StringBuilder query2 = new StringBuilder();
                  //    query2.append(" SELECT  DECODE(SubStr(lpad(ffs_ddd, 3, '0')||lpad(ffs_nmro, 7, '0'), Length(lpad(ffs_ddd, 3, '0')||lpad(ffs_nmro, 7, '0'))-9,1), '0', ");
                  //    query2.append("                SubStr(lpad(ffs_ddd, 3, '0'),1, 3)||'-'||SubStr(lpad(ffs_ddd, 3, '0')||lpad(ffs_nmro, 7, '0'), Length(lpad(ffs_ddd, 3, '0')||lpad(ffs_nmro, 7, '0'))-6  ), ");
                  //    query2.append("                SubStr(lpad(ffs_ddd, 3, '0'),1, 2)||'-'||SubStr(lpad(ffs_ddd, 3, '0')||lpad(ffs_nmro, 7, '0'), Length(lpad(ffs_ddd, 3, '0')||lpad(ffs_nmro, 7, '0'))-7 )) fone ");
                  query2.append(" SELECT lpad(ffs_ddd,3,'0') ||'-'|| ffs_nmro fone");
                  query2.append("   FROM  fax_fon ");
                  query2.append("  WHERE  rep_cdgo  = ").append(codigo_representante);
                  query2.append("    AND  rep_cdgo  > 0 ");
                  query2.append("    AND  (ffs_tipo = 7 or ffs_tipo = 1) ");

                  res_Jw_representantes_fones  = j_report.select(t_jw_representantes_fones,
                  query2.toString(),
                  null);

                  if (res_Jw_representantes_fones!=null && res_Jw_representantes_fones.size()>0) {
                    telefones = new StringBuilder();
                    for(int x=0;x<res_Jw_representantes_fones.size();x++){
                      t_jw_representantes_fones = (portalbr.dbobj.view.Jw_representantes_fones)res_Jw_representantes_fones.elementAt(x);
                      if(x==0){
                        telefones.append(t_jw_representantes_fones.getFone());
                      }else{
                        telefones.append("  ,  ").append(t_jw_representantes_fones.getFone());
                      }
                    }
                  }
                  //-----------------------------------------------------------
                  %>
                  <tr class="reportHeader2" >
                    <td colspan=4;>
                      <big>
                        Dados do Cliente
                      </big>
                    </td>
                  </tr>

                  <tr class="reportHeader" >
                    <td class="reportColumn" style="text-align:left;" >
                      <font color="white">
                        Representante
                      </font>
                    </td>
                    <td class="reportColumn" style="text-align:left;">
                      <font color="white">
                        Telefones
                      </font>
                    </td>
                    <td class="reportColumn" style="text-align:left;">
                      <font color="white">
                        Situação
                      </font>
                    </td>
                    <td class="reportColumn" style="text-align:left;">
                      <font color="white">
                        Marcas
                      </font>
                    </td>
                  </tr>

                  <%
                  while (i_bl_report_Jw_clientes_cad_dados<res_Jw_clientes_cad_dados.size()){
                    counterbl_report_Jw_clientes_cad_dados++;
                    String style="";
                    if (!((i_bl_report_Jw_clientes_cad_dados%2)!=0)) {
                      style="class=rowColor";
                    } else {
                      style="class=rowBlank";
                    }
                    %>
                    <tr <%= style %> id='TRbl_report_Jw_clientes_cad_dados<%=counterbl_report_Jw_clientes_cad_dados%>' >
                      <%
                      %>
                      <td class="reportColumn" style="text-align:left;">
                        <%= representante %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= telefones.toString() %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= sit_cli_rep %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= marcas %>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Jw_clientes_cad_dados >= res_Jw_clientes_cad_dados.size()) {
                      break;
                    }
                    t_jw_clientes_cad_dados = (portalbr.dbobj.view.Jw_clientes_cad_dados)res_Jw_clientes_cad_dados.elementAt(i_bl_report_Jw_clientes_cad_dados);
                    marca                 = t_jw_clientes_cad_dados.getMarca()==null?"":t_jw_clientes_cad_dados.getMarca();
                    marcas                = t_jw_clientes_cad_dados.getMarcas()==null?"":t_jw_clientes_cad_dados.getMarcas();
                    representante         = t_jw_clientes_cad_dados.getRepresentante()==null?"":t_jw_clientes_cad_dados.getRepresentante();
                    codigo_representante  = t_jw_clientes_cad_dados.getCodigo_representante()==null?"":t_jw_clientes_cad_dados.getCodigo_representante();
                    sit_cli_rep           = t_jw_clientes_cad_dados.getSit_cli_rep()==null?"":t_jw_clientes_cad_dados.getSit_cli_rep();
                    //------------- consulta os telefones ----------------------
                    StringBuilder query3 = new StringBuilder();
                    //      query3.append(" SELECT decode(SubStr(lpad(ffs_ddd, 3, '0')||lpad(ffs_nmro, 7, '0'), Length(lpad(ffs_ddd, 3, '0')||lpad(ffs_nmro, 7, '0'))-9,1), '0', ");
                    //      query3.append("               SubStr(lpad(ffs_ddd, 3, '0'),1, 3)||'-'||SubStr(lpad(ffs_ddd, 3, '0')||lpad(ffs_nmro, 7, '0'), Length(lpad(ffs_ddd, 3, '0')||lpad(ffs_nmro, 7, '0'))-6  ), ");
                    //      query3.append("               SubStr(lpad(ffs_ddd, 3, '0'),1, 2)||'-'||SubStr(lpad(ffs_ddd, 3, '0')||lpad(ffs_nmro, 7, '0'), Length(lpad(ffs_ddd, 3, '0')||lpad(ffs_nmro, 7, '0'))-7 )) fone ");
                    query3.append(" SELECT lpad(ffs_ddd,3,'0') ||'-'|| ffs_nmro fone");
                    query3.append("   FROM fax_fon ");
                    query3.append("  WHERE rep_cdgo = ").append(codigo_representante);
                    query3.append("    AND rep_cdgo > 0 ");
                    query3.append("    AND (ffs_tipo = 7 or ffs_tipo = 1) ");

                    res_Jw_representantes_fones  = j_report.select(t_jw_representantes_fones,
                    query3.toString(),
                    null);
                    if (res_Jw_representantes_fones!=null && res_Jw_representantes_fones.size()>0) {
                      telefones = new StringBuilder();
                      for(int x=0;x<res_Jw_representantes_fones.size();x++){
                        t_jw_representantes_fones = (portalbr.dbobj.view.Jw_representantes_fones)res_Jw_representantes_fones.elementAt(x);
                        if(x==0){
                          telefones.append(t_jw_representantes_fones.getFone());
                        }else{
                          telefones.append("  ,  ").append(t_jw_representantes_fones.getFone());
                        }
                      }
                    }

                    //-----------------------------------------------------------
                  }
                }

              } catch (Exception e){
                session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
              } finally {
                if(j_report!=null){
                  j_report.close();
                  j_report=null;
                }
              }
              %>
            </table>
            <html:form action="adm/CadastroClientes_dForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String codigo_regional="";
                String codigo_representante="";
                String tipo="";
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

                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Código
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cliente" styleClass="disabled" tabindex="-1" readonly="true" size="12" maxlength="12"/>
                    <span class="spamFormLabel">
                      Cliente Desde
                    </span>
                    <html:text property="cliente_desde" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situação do Cliente
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="situacao_cliente" styleClass="disabled" tabindex="-1" readonly="true" size="42" maxlength="38"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situação da Loja
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="situacao_loja" styleClass="disabled" tabindex="-1" readonly="true" size="7" maxlength="7"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Razão Social
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="43" maxlength="35"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nome Fantasia
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_nome" styleClass="disabled" tabindex="-1" readonly="true" size="43" maxlength="35"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Segmento
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="seg_desc" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      CNPJ
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cgc" styleClass="disabled" tabindex="-1" readonly="true"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Inscrição Estadual
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="inscricao" styleClass="disabled" tabindex="-1" readonly="true"/>
                  </td>
                </tr>

                <html:hidden property="endereco"/>
                <html:hidden property="bairro_cidade_uf"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      E-Mail
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="esc_email" styleClass="disabled" readonly="true" size="35" maxlength="35"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Transportadora
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="transportadora" styleClass="disabled" readonly="true" size="45" maxlength="35"/>
                  </td>
                </tr>
                <html:hidden property="cli_cdgo"/>
                <html:hidden property="esc_seqn"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Protestar
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="protestar" styleClass="disabled" tabindex="-1" readonly="true"/>
                    <span class="spamFormLabel">
                      Nro. Dias
                    </span>
                    <html:text property="nro_dias" styleClass="disabled" tabindex="-1" readonly="true"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Grupo Econômico
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="grupo_economico" styleId="grupo_economico" styleClass="disabled" tabindex="-1" readonly="true" size="120"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Aceita Antec. Vizzano
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_aceita_antecipacao" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="3"/>
                    <span class="spamFormLabel">
                      Aceita Antec. Beira Rio
                    </span>
                    <html:text property="cli_aceita_antecipacao_allegro" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="3"/>
                    <span class="spamFormLabel">
                      Aceita Antec. Toccado
                    </span>
                    <html:text property="cli_aceita_antecipacao_riva" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="3"/>
                    <%
                    if(!codigo_regional.equals("")){
                      %>
                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Vendor
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="vendor" styleClass="disabled" tabindex="-1" readonly="true"/>
                        </td>
                      </tr>

                      <%
                    }
                    %>
                    <tr>
                      <td class="formLabel">
                        <span class="spamFormLabel" >
                        </span>
                      </td>
                      <td class="formField">


                        <table border=0 style=width:80%;>
                          <tr>
                            <td>

                              <table id="TRbl_report_Jw_clientes_contatos" class="reportTable" style=width:99%; border=1; >
                                <%
                                int counterbl_report_Jw_clientes_contatos=0;
                                {
                                  portalbr.dbobj.view.Jw_clientes_contatos t_jw_clientes_contatos = new portalbr.dbobj.view.Jw_clientes_contatos();
                                  java.util.Vector res_Jw_clientes_contatos = (java.util.Vector)session.getAttribute("res_Jw_clientes_contatos");
                                  if (res_Jw_clientes_contatos!=null && res_Jw_clientes_contatos.size()>0) {
                                    java.lang.String pec_nome =  null;
                                    java.lang.String pec_cpf =  null;
                                    int i_bl_report_Jw_clientes_contatos = 0;
                                    t_jw_clientes_contatos = (portalbr.dbobj.view.Jw_clientes_contatos)res_Jw_clientes_contatos.elementAt(i_bl_report_Jw_clientes_contatos);
                                    pec_nome = t_jw_clientes_contatos.getPec_nome()==null?"":t_jw_clientes_contatos.getPec_nome();
                                    pec_cpf = t_jw_clientes_contatos.getPec_cpf()==null?"":t_jw_clientes_contatos.getPec_cpf();
                                    %>
                                    <tr class="reportHeader3" >
                                      <td class="columnTdHeader" style="text-align:center;" colspan="2">
                                        Contatos
                                      </td>
                                    </tr>
                                    <tr class="reportHeader" >
                                      <td class="columnTdHeader" style="text-align:left;">
                                        Nome
                                      </td>
                                      <td class="columnTdHeader" style="text-align:left;">
                                        CPF
                                      </td>
                                    </tr>
                                    <%
                                    while (i_bl_report_Jw_clientes_contatos<res_Jw_clientes_contatos.size()){
                                      counterbl_report_Jw_clientes_contatos++;
                                      String style="";
                                      if (!((i_bl_report_Jw_clientes_contatos%2)!=0)) {
                                        style="class=rowColor";
                                      } else {
                                        style="class=rowBlank";
                                      }
                                      %>
                                      <tr <%= style %> id='TRbl_report_Jw_clientes_contatos<%=counterbl_report_Jw_clientes_contatos%>' >
                                        <td class="reportColumn" style="text-align:left;">
                                          <%= pec_nome %>
                                        </td>
                                        <td class="reportColumn" style="text-align:left;">
                                          <%= pec_cpf %>
                                        </td>
                                      </tr>
                                      <%
                                      if (++i_bl_report_Jw_clientes_contatos >= res_Jw_clientes_contatos.size()) {
                                        break;
                                      }
                                      t_jw_clientes_contatos = (portalbr.dbobj.view.Jw_clientes_contatos)res_Jw_clientes_contatos.elementAt(i_bl_report_Jw_clientes_contatos);
                                      pec_nome = t_jw_clientes_contatos.getPec_nome()==null?"":t_jw_clientes_contatos.getPec_nome();
                                      pec_cpf = t_jw_clientes_contatos.getPec_cpf()==null?"":t_jw_clientes_contatos.getPec_cpf();
                                    }
                                  }
                                }
                                %>
                              </table>
                            </td>
                            <td valign="top" align="left" width="40%">

                              <table id="TRbl_report_Jw_clientes_fones" class="reportTable" style=width:99%; border=1;  >
                                <%
                                int counterbl_report_Jw_clientes_fones=0;
                                {
                                  portalbr.dbobj.view.Jw_clientes_fones t_jw_clientes_fones = new portalbr.dbobj.view.Jw_clientes_fones();
                                  java.util.Vector res_Jw_clientes_fones = (java.util.Vector)session.getAttribute("res_Jw_clientes_fones");
                                  if (res_Jw_clientes_fones!=null && res_Jw_clientes_fones.size()>0) {
                                    java.lang.String fone =  null;
                                    int i_bl_report_Jw_clientes_fones = 0;
                                    t_jw_clientes_fones = (portalbr.dbobj.view.Jw_clientes_fones)res_Jw_clientes_fones.elementAt(i_bl_report_Jw_clientes_fones);
                                    fone = t_jw_clientes_fones.getFone()==null?"":t_jw_clientes_fones.getFone();
                                    %>
                                    <tr class="reportHeader3" >
                                      <td class="columnTdHeader" style="text-align:center;">
                                        Fones
                                      </td>
                                    </tr>
                                    <tr class="reportHeader" >
                                      <td class="columnTdHeader" style="text-align:left;">
                                        Fone
                                      </td>
                                    </tr>
                                    <%
                                    while (i_bl_report_Jw_clientes_fones<res_Jw_clientes_fones.size()){
                                      counterbl_report_Jw_clientes_fones++;
                                      String style="";
                                      if (!((i_bl_report_Jw_clientes_fones%2)!=0)) {
                                        style="class=rowColor";
                                      } else {
                                        style="class=rowBlank";
                                      }
                                      %>
                                      <tr <%= style %> id='TRbl_report_Jw_clientes_fones<%=counterbl_report_Jw_clientes_fones%>' >
                                        <td class="reportColumn" style="text-align:left;">
                                          <%= fone %>
                                        </td>
                                      </tr>
                                      <%
                                      if (++i_bl_report_Jw_clientes_fones >= res_Jw_clientes_fones.size()) {
                                        break;
                                      }
                                      t_jw_clientes_fones = (portalbr.dbobj.view.Jw_clientes_fones)res_Jw_clientes_fones.elementAt(i_bl_report_Jw_clientes_fones);
                                      fone = t_jw_clientes_fones.getFone()==null?"":t_jw_clientes_fones.getFone();
                                    }
                                  }
                                }
                                %>
                              </table>
                            </td>
                          </tr>
                        </table>


                      </td>

                    </tr>

                    <tr>
                      <td class="formLabel">
                        <span class="spamFormLabel" >
                        </span>
                      </td>
                      <td class="formField">
                        <table id="TRbl_report_Jw_clientes_enderecos" class="reportTable" style=width:90%; border=1;  >
                          <%
                          int counterbl_report_Jw_clientes_enderecos=0;
                          {
                            portalbr.dbobj.view.Jw_clientes_enderecos t_jw_clientes_enderecos = new portalbr.dbobj.view.Jw_clientes_enderecos();
                            java.util.Vector res_Jw_clientes_enderecos = null;
                            if(CadastroClientes_dActionForm!=null && (CadastroClientes_dActionForm.getCli_cdgo()!=null && CadastroClientes_dActionForm.getCli_cdgo().length()>0 && CadastroClientes_dActionForm.getEsc_seqn()!=null && CadastroClientes_dActionForm.getEsc_seqn().length()>0)) {
                              com.egen.util.jdbc.JdbcUtil j = null;
                              try {
                                j = new com.egen.util.jdbc.JdbcUtil();
                                StringBuilder query = new StringBuilder();
                                query.append(" SELECT DISTINCT ");
                                query.append("        a.cli_cdgo, ");
                                query.append("        b.esc_seqn, ");
                                query.append("        c.ned_cdgo, ");
                                query.append("        c.ecl_nome||' , '||c.ecl_nmro || decode(c.ecl_cpto,null,'',' - '||c.ecl_cpto) endereco, ");
                                query.append("        substr(c.ecl_cep,1,5)||'-'||substr(c.ecl_cep, 6,3) cep, ");
                                query.append("        c.ecl_bair||' - '||c.ecl_cdad||'/'||c.est_unifed bairro_cidade ");
                                query.append("   FROM brio.cli a, ");
                                query.append("        brio.esc b, ");
                                query.append("        brio.ecl c, ");
                                query.append("        cliente_representante cr ");
                                query.append("  WHERE b.esc_seqn           = c.esc_seqn ");
                                query.append("    AND a.cli_cdgo           = b.cli_cdgo ");
                                query.append("    AND b.cli_cdgo           = c.cli_cdgo ");
                                query.append("    AND cr.codigo_cliente    = a.cli_cdgo ");
                                query.append("    AND cr.codigo_sequencial = b.esc_seqn ");
                                query.append("    AND a.cli_cdgo           = ").append(CadastroClientes_dActionForm.getCli_cdgo());
                                query.append("    AND b.esc_seqn           = ").append(CadastroClientes_dActionForm.getEsc_seqn());

                                res_Jw_clientes_enderecos = j.select(t_jw_clientes_enderecos,
                                query.toString(),
                                null);
                              } catch (Exception e){
                                res_Jw_clientes_enderecos = null;
                              } finally {
                                if(j!=null){
                                  j.close();
                                  j = null;
                                }
                              }
                            } else {
                              res_Jw_clientes_enderecos = null;
                            }
                            if (res_Jw_clientes_enderecos!=null && res_Jw_clientes_enderecos.size()>0) {
                              java.lang.String ned_cdgo =  null;
                              java.lang.String endereco =  null;
                              java.lang.String cep =  null;
                              java.lang.String bairro_cidade =  null;
                              java.lang.String cli_cdgo =  null;
                              java.lang.String esc_seqn =  null;
                              int i_bl_report_Jw_clientes_enderecos = 0;
                              t_jw_clientes_enderecos = (portalbr.dbobj.view.Jw_clientes_enderecos)res_Jw_clientes_enderecos.elementAt(i_bl_report_Jw_clientes_enderecos);
                              ned_cdgo = t_jw_clientes_enderecos.getNed_cdgo()==null?"":t_jw_clientes_enderecos.getNed_cdgo();
                              endereco = t_jw_clientes_enderecos.getEndereco()==null?"":t_jw_clientes_enderecos.getEndereco();
                              cep = t_jw_clientes_enderecos.getCep()==null?"":t_jw_clientes_enderecos.getCep();
                              bairro_cidade = t_jw_clientes_enderecos.getBairro_cidade()==null?"":t_jw_clientes_enderecos.getBairro_cidade();
                              cli_cdgo = t_jw_clientes_enderecos.getCli_cdgo()==null?"":t_jw_clientes_enderecos.getCli_cdgo();
                              esc_seqn = t_jw_clientes_enderecos.getEsc_seqn()==null?"":t_jw_clientes_enderecos.getEsc_seqn();
                              %>
                              <tr class="reportHeader3" colspan="4"; >
                                <td class="columnTdHeader" style="text-align:center;" colspan=4>
                                  Endereços
                                </td>
                              </tr>
                              <tr class="reportHeader" >
                                <td class="columnTdHeader" style="text-align:left;">
                                  Tipo
                                </td>
                                <td class="columnTdHeader" style="text-align:left;">
                                  Endereço
                                </td>
                                <td class="columnTdHeader" style="text-align:left;">
                                  CEP
                                </td>
                                <td class="columnTdHeader" style="text-align:left;">
                                  Bairro/Cidade
                                </td>
                              </tr>
                              <%
                              while (i_bl_report_Jw_clientes_enderecos<res_Jw_clientes_enderecos.size()){
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
                                    <%= ned_cdgo %>
                                  </td>
                                  <td class="reportColumn" style="text-align:left;">
                                    <%= endereco %>
                                  </td>
                                  <td class="reportColumn" style="text-align:left;">
                                    <%= cep %>
                                  </td>
                                  <td class="reportColumn" style="text-align:left;">
                                    <%= bairro_cidade %>
                                  </td>
                                </tr>
                                <%
                                if (++i_bl_report_Jw_clientes_enderecos >= res_Jw_clientes_enderecos.size()) {
                                  break;
                                }
                                t_jw_clientes_enderecos = (portalbr.dbobj.view.Jw_clientes_enderecos)res_Jw_clientes_enderecos.elementAt(i_bl_report_Jw_clientes_enderecos);
                                ned_cdgo = t_jw_clientes_enderecos.getNed_cdgo()==null?"":t_jw_clientes_enderecos.getNed_cdgo();
                                endereco = t_jw_clientes_enderecos.getEndereco()==null?"":t_jw_clientes_enderecos.getEndereco();
                                cep = t_jw_clientes_enderecos.getCep()==null?"":t_jw_clientes_enderecos.getCep();
                                bairro_cidade = t_jw_clientes_enderecos.getBairro_cidade()==null?"":t_jw_clientes_enderecos.getBairro_cidade();
                                cli_cdgo = t_jw_clientes_enderecos.getCli_cdgo()==null?"":t_jw_clientes_enderecos.getCli_cdgo();
                                esc_seqn = t_jw_clientes_enderecos.getEsc_seqn()==null?"":t_jw_clientes_enderecos.getEsc_seqn();
                              }
                            }
                          }
                          %>
                        </table>


                      </td>
                    </tr>


                  </table>

                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:submit styleClass="myhidden" property="select_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:submit>
                        <html:button accesskey="b" onclick="history.go(-1);" styleClass="baseButton" property="back_action">
                          <bean:message bundle="ApplicationResources" key="jsp.back"/>
                        </html:button>
                      </td>
                    </tr>
                  </table>

                </html:form>
              </td>
            </tr>
          </table>

        </body>
      </center>
    </html>

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      PLUS Clientes
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(80)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/PlusClientes_dForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="codigo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="cli_nome"/>
                    <html:errors property="seg_desc"/>
                    <html:errors property="cgc"/>
                    <html:errors property="inscricao"/>
                    <html:errors property="cli_situ"/>
                    <html:errors property="esc_situacao"/>
                    <html:errors property="cli_dtin"/>
                    <html:errors property="cli_exige_pc"/>
                    <html:errors property="cli_agrupa_notas"/>
                    <html:errors property="cli_aceita_antecipacao"/>
                    <html:errors property="situacao"/>
                    <html:errors property="dt_entrega"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_plus_clientes"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Código
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo" styleClass="disabled" tabindex="-1" readonly="true"/>
                  </td>
                </tr>

                <html:hidden property="cli_cdgo"/>
                <html:hidden property="esc_seqn"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Razão Social
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nome Fantasia
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_nome" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Segmento
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="seg_desc" styleClass="disabled" tabindex="-1" readonly="true" size="33" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      CNPJ
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cgc" styleClass="disabled" tabindex="-1" readonly="true" size="18" maxlength="18"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Inscrição Estadual
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="inscricao" styleClass="disabled" tabindex="-1" readonly="true" size="18" maxlength="18"/>
                  </td>
                </tr>

                <html:hidden property="bairro_cidade"/>
                <html:hidden property="ender"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situação Cliente
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_situ" styleClass="disabled" tabindex="-1" readonly="true"/>
                    <span class="spamFormLabel">
                      Situação Seqüencial
                    </span>
                    <html:text property="esc_situacao" styleClass="disabled" tabindex="-1" readonly="true" size="7" maxlength="7"/>
                    <span class="spamFormLabel">
                      Cliente desde
                    </span>
                    <html:text property="cli_dtin" styleClass="disabled" tabindex="-1" readonly="true" size="10" maxlength="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Exige PC
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_exige_pc" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="3"/>
                    <span class="spamFormLabel">
                      Agrupa NF
                    </span>
                    <html:text property="cli_agrupa_notas" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="3"/>
                    <span class="spamFormLabel">
                      Aceita Antecipação
                    </span>
                    <html:text property="cli_aceita_antecipacao" styleClass="disabled" tabindex="-1" readonly="true" size="3" maxlength="3"/>
                  </td>
                </tr>

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
                                int i_bl_report_Jw_clientes_contatos = 0;
                                t_jw_clientes_contatos = (portalbr.dbobj.view.Jw_clientes_contatos)res_Jw_clientes_contatos.elementAt(i_bl_report_Jw_clientes_contatos);
                                pec_nome = t_jw_clientes_contatos.getPec_nome()==null?"":t_jw_clientes_contatos.getPec_nome();
                                %>
                                <tr class="reportHeader3" >
                                  <td class="columnTdHeader" style="text-align:center;">
                                    Contatos
                                  </td>
                                </tr>
                                <tr class="reportHeader" >
                                  <td class="columnTdHeader" style="text-align:left;">
                                    Nome
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
                                  </tr>
                                  <%
                                  if (++i_bl_report_Jw_clientes_contatos >= res_Jw_clientes_contatos.size()) {
                                    break;
                                  }
                                  t_jw_clientes_contatos = (portalbr.dbobj.view.Jw_clientes_contatos)res_Jw_clientes_contatos.elementAt(i_bl_report_Jw_clientes_contatos);
                                  pec_nome = t_jw_clientes_contatos.getPec_nome()==null?"":t_jw_clientes_contatos.getPec_nome();
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
                        portalbr.com.PlusClientes_dActionForm PlusClientes_dActionForm = (portalbr.com.PlusClientes_dActionForm)session.getAttribute("PlusClientes_dActionForm");
                        if(PlusClientes_dActionForm!=null && (PlusClientes_dActionForm.getCli_cdgo()!=null && PlusClientes_dActionForm.getCli_cdgo().length()>0 && PlusClientes_dActionForm.getEsc_seqn()!=null && PlusClientes_dActionForm.getEsc_seqn().length()>0)) {
                          com.egen.util.jdbc.JdbcUtil j = null;
                          try {
                            j = new com.egen.util.jdbc.JdbcUtil();
                            StringBuilder query = new StringBuilder();
                            query.append(" SELECT DISTINCT a.cli_cdgo ");
                            query.append("      , b.esc_seqn ");
                            query.append("      , c.ned_cdgo ");
                            query.append("      , c.ecl_nome||' , '||c.ecl_nmro || decode(c.ecl_cpto,null,'',' - '||c.ecl_cpto) endereco ");
                            query.append("      , substr(c.ecl_cep,1,5)||'-'||substr(c.ecl_cep, 6,3) cep ");
                            query.append("      , c.ecl_bair||' - '||c.ecl_cdad||'/'||c.est_unifed bairro_cidade ");
                            query.append("      , p.descricao pais ");
                            query.append("   FROM brio.cli a ");
                            query.append("      , brio.esc b ");
                            query.append("      , brio.ecl c ");
                            query.append("      , cliente_representante cr ");
                            query.append("      , estados e ");
                            query.append("      , paises p ");
                            query.append("  WHERE b.esc_seqn           = c.esc_seqn ");
                            query.append("    AND a.cli_cdgo           = b.cli_cdgo ");
                            query.append("    AND b.cli_cdgo           = c.cli_cdgo ");
                            query.append("    AND cr.codigo_cliente    = a.cli_cdgo ");
                            query.append("    AND cr.codigo_sequencial = b.esc_seqn ");
                            query.append("    AND e.est_unifed         = c.est_unifed ");
                            query.append("    AND p.codigo             = e.pais_codigo ");
                            query.append("    AND a.cli_cdgo           = "+PlusClientes_dActionForm.getCli_cdgo());
                            query.append("    AND b.esc_seqn           = "+PlusClientes_dActionForm.getEsc_seqn());

                            res_Jw_clientes_enderecos = j.select(t_jw_clientes_enderecos,
                            query.toString(),
                            null);
                          } catch (Exception e){
                            res_Jw_clientes_enderecos = null;
                          } finally {
                          if(j!=null){j.close();}
                        }
                      } else {
                        res_Jw_clientes_enderecos = null;
                      }
                      if (res_Jw_clientes_enderecos!=null && res_Jw_clientes_enderecos.size()>0) {
                        java.lang.String ned_cdgo      =  null;
                        java.lang.String endereco      =  null;
                        java.lang.String cep           =  null;
                        java.lang.String bairro_cidade =  null;
                        java.lang.String pais          =  null;
                        java.lang.String cli_cdgo      =  null;
                        java.lang.String esc_seqn      =  null;
                        int i_bl_report_Jw_clientes_enderecos = 0;
                        t_jw_clientes_enderecos = (portalbr.dbobj.view.Jw_clientes_enderecos)res_Jw_clientes_enderecos.elementAt(i_bl_report_Jw_clientes_enderecos);
                        ned_cdgo      = t_jw_clientes_enderecos.getNed_cdgo()==null?"":t_jw_clientes_enderecos.getNed_cdgo();
                        endereco      = t_jw_clientes_enderecos.getEndereco()==null?"":t_jw_clientes_enderecos.getEndereco();
                        cep           = t_jw_clientes_enderecos.getCep()==null?"":t_jw_clientes_enderecos.getCep();
                        bairro_cidade = t_jw_clientes_enderecos.getBairro_cidade()==null?"":t_jw_clientes_enderecos.getBairro_cidade();
                        pais          = t_jw_clientes_enderecos.getPais()==null?"":t_jw_clientes_enderecos.getPais();
                        cli_cdgo      = t_jw_clientes_enderecos.getCli_cdgo()==null?"":t_jw_clientes_enderecos.getCli_cdgo();
                        esc_seqn      = t_jw_clientes_enderecos.getEsc_seqn()==null?"":t_jw_clientes_enderecos.getEsc_seqn();
                        %>
                        <tr class="reportHeader" colspan="5"; >
                          <td class="columnTdHeader" style="text-align:center;" colspan=5>
                            Endereços
                          </td>
                        </tr>
                        <tr class="reportHeader3" >
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
                          <td class="columnTdHeader" style="text-align:left;">
                            País
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
                            <td class="reportColumn" style="text-align:left;">
                              <%= pais %>
                            </td>
                          </tr>
                          <%
                          if (++i_bl_report_Jw_clientes_enderecos >= res_Jw_clientes_enderecos.size()) {
                            break;
                          }
                          t_jw_clientes_enderecos = (portalbr.dbobj.view.Jw_clientes_enderecos)res_Jw_clientes_enderecos.elementAt(i_bl_report_Jw_clientes_enderecos);
                          ned_cdgo      = t_jw_clientes_enderecos.getNed_cdgo()==null?"":t_jw_clientes_enderecos.getNed_cdgo();
                          endereco      = t_jw_clientes_enderecos.getEndereco()==null?"":t_jw_clientes_enderecos.getEndereco();
                          cep           = t_jw_clientes_enderecos.getCep()==null?"":t_jw_clientes_enderecos.getCep();
                          bairro_cidade = t_jw_clientes_enderecos.getBairro_cidade()==null?"":t_jw_clientes_enderecos.getBairro_cidade();
                          pais          = t_jw_clientes_enderecos.getPais()==null?"":t_jw_clientes_enderecos.getPais();
                          cli_cdgo      = t_jw_clientes_enderecos.getCli_cdgo()==null?"":t_jw_clientes_enderecos.getCli_cdgo();
                          esc_seqn      = t_jw_clientes_enderecos.getEsc_seqn()==null?"":t_jw_clientes_enderecos.getEsc_seqn();
                        }
                      }
                    }
                    %>
                  </table>

                </td>
              </tr>


              <tr>
                <td class="formLabel">
                  <span class="spamFormLabel" >
                  </span>
                </td>
                <td class="formField">
                  <%
                  int counterbl_report_Jw_cliente_representante=0;
                  %>
                  <%
                  {
                    portalbr.dbobj.view.Jw_cliente_representante t_jw_cliente_representante = new portalbr.dbobj.view.Jw_cliente_representante();
                    java.util.Vector res_Jw_cliente_representante = null;
                    portalbr.com.PlusClientes_dActionForm PlusClientes_dActionForm = (portalbr.com.PlusClientes_dActionForm)session.getAttribute("PlusClientes_dActionForm");
                    if(PlusClientes_dActionForm!=null && (PlusClientes_dActionForm.getCli_cdgo()!=null && PlusClientes_dActionForm.getCli_cdgo().length()>0 && PlusClientes_dActionForm.getEsc_seqn()!=null && PlusClientes_dActionForm.getEsc_seqn().length()>0)) {
                      com.egen.util.jdbc.JdbcUtil j = null;
                      try {
                        j = new com.egen.util.jdbc.JdbcUtil();
                        String[][] select =  null;
                        Object[][] where = null;
                        where = new Object[][] {{"codigo_cliente","=",PlusClientes_dActionForm.getCli_cdgo()},{"esc_seqn","=",PlusClientes_dActionForm.getEsc_seqn()}};
                        String[] groupby =  null;
                        String[] having =  null;
                        String[] order = {};
                        res_Jw_cliente_representante = j.select(t_jw_cliente_representante,select,where,groupby,having,order);
                      } catch (Exception e){
                        res_Jw_cliente_representante = null;
                      } finally {
                      if(j!=null){j.close();}
                    }
                  } else {
                    res_Jw_cliente_representante = null;
                  }
                  if (res_Jw_cliente_representante!=null && res_Jw_cliente_representante.size()>0) {
                    java.lang.String codigo_cliente =  null;
                    java.lang.String esc_seqn =  null;
                    java.lang.String codigo_representante =  null;
                    java.lang.String rep_rzao =  null;
                    int i_bl_report_Jw_cliente_representante = 0;
                    t_jw_cliente_representante = (portalbr.dbobj.view.Jw_cliente_representante)res_Jw_cliente_representante.elementAt(i_bl_report_Jw_cliente_representante);
                    codigo_cliente = t_jw_cliente_representante.getCodigo_cliente()==null?"":t_jw_cliente_representante.getCodigo_cliente();
                    esc_seqn = t_jw_cliente_representante.getEsc_seqn()==null?"":t_jw_cliente_representante.getEsc_seqn();
                    codigo_representante = t_jw_cliente_representante.getCodigo_representante()==null?"":t_jw_cliente_representante.getCodigo_representante();
                    rep_rzao = t_jw_cliente_representante.getRep_rzao()==null?"":t_jw_cliente_representante.getRep_rzao();
                    %>
                    <table id="TRbl_report_Jw_cliente_representante" class="reportTable" style=width:50%; border=1;  >
                      <tr class="reportHeader2" colspan="2"; >
                        <td class="columnTdHeader" style="text-align:center;" colspan=2>
                          Representantes
                        </td>
                      </tr>
                      <tr class="reportHeader" >
                        <td class="columnTdHeader" style="text-align:left;">
                          Código
                        </td>
                        <td class="columnTdHeader" style="text-align:left;">
                          Razão Social
                        </td>
                      </tr>
                      <%
                      while (i_bl_report_Jw_cliente_representante<res_Jw_cliente_representante.size()){
                        counterbl_report_Jw_cliente_representante++;
                        String style="";
                        if (!((i_bl_report_Jw_cliente_representante%2)!=0)) {
                          style="class=rowColor";
                        } else {
                          style="class=rowBlank";
                        }
                        %>
                        <tr <%= style %> id='TRbl_report_Jw_cliente_representante<%=counterbl_report_Jw_cliente_representante%>' >
                          <td class="reportColumn" style="text-align:left;">
                            <%= codigo_representante %>
                          </td>
                          <td class="reportColumn" style="text-align:left;">
                            <%= rep_rzao %>
                          </td>
                        </tr>
                        <%
                        if (++i_bl_report_Jw_cliente_representante >= res_Jw_cliente_representante.size()) {
                          break;
                        }
                        t_jw_cliente_representante = (portalbr.dbobj.view.Jw_cliente_representante)res_Jw_cliente_representante.elementAt(i_bl_report_Jw_cliente_representante);
                        codigo_cliente = t_jw_cliente_representante.getCodigo_cliente()==null?"":t_jw_cliente_representante.getCodigo_cliente();
                        esc_seqn = t_jw_cliente_representante.getEsc_seqn()==null?"":t_jw_cliente_representante.getEsc_seqn();
                        codigo_representante = t_jw_cliente_representante.getCodigo_representante()==null?"":t_jw_cliente_representante.getCodigo_representante();
                        rep_rzao = t_jw_cliente_representante.getRep_rzao()==null?"":t_jw_cliente_representante.getRep_rzao();
                      }
                    }
                  }
                  %>
                </table>
              </td>
            </tr>


          </table>
          <table class="separatorTable">
            <tr class="separatorTr">
              <td colspan="2" class="separatorTd">
                <b>
                  Consulta de Pedidos
                </b>
              </td>
            </tr>
            <tr>
              <td class="formLabel">
                <span class="spamFormLabel" >
                  Situação dos Pedidos
                </span>
              </td>
              <td class="formField">
                <html:select property="situacao" styleClass="baseField" size="1">
                  <html:option styleClass="baseOption" value="T">
                    Todas as Situações
                  </html:option>
                  <html:option styleClass="baseOption" value="A">
                    Pedidos Abertos/Cancelados
                  </html:option>
                  <html:option styleClass="baseOption" value="F">
                    Pedidos Faturados
                  </html:option>
                </html:select>
                <html:button value="Consultar Pedidos" onclick="this.disabled=true;consultar_pedidos_action.click();" styleClass="baseButton" property="consultar_pedidos1_action">
                </html:button>
              </td>
            </tr>
            <tr class="itemTr">
              <td class="formLabel">
                <span class="spamFormLabel">
                  Data de Entrega
                </span>
                <bean:message key="jsp.fieldnotnull"/>
              </td>
              <td class="formField">
                <html:text property="dt_entrega" onkeypress="FormataData(this,event);" styleClass="baseField" size="10" maxlength="10"/>
                &nbsp;
                <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_entrega']); cal1.year_scroll = true; cal1.popup();">
                  <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                </a>
              </td>
            </tr>

          </table>
          <table class="itemTable" style='width:99%;'>
            <html:hidden property="cid_uf"/>
          </table>

          <table class="buttonTable" style='width:99%;'>
            <tr class="buttonTr">
              <td class="buttonTd">
                <html:submit styleClass="baseButton" property="back_action">
                  <bean:message bundle="ApplicationResources" key="jsp.back"/>
                </html:submit>
                <html:button value="Analisar Crédito" onclick="this.disabled=true;analisar_credito_action.click();" styleClass="baseButton" property="analisar_credito1_action">
                </html:button>
                <html:submit value="Analisar Crédito" styleClass="myhidden" property="analisar_credito_action">
                </html:submit>
                <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                  <bean:message bundle="ApplicationResources" key="jsp.select"/>
                </html:submit>
                <html:submit value="Consultar Pedidos" styleClass="myhidden" property="consultar_pedidos_action">
                </html:submit>
              </td>
            </tr>
          </table>

        </html:form>
        <script type="text/javascript">
          var focusControl = document.forms[0].elements["dt_entrega"];
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

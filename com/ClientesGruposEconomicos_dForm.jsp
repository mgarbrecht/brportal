<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Clientes por Grupo Econômico - Dados do Cliente
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(116)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ClientesGruposEconomicos_dForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="cliente"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="cli_nome"/>
                    <html:errors property="seg_desc"/>
                    <html:errors property="cgc"/>
                    <html:errors property="inscricao"/>
                    <html:errors property="contato"/>
                    <html:errors property="cli_situ"/>
                    <html:errors property="esc_situacao"/>
                    <html:errors property="cli_dtin"/>
                    <html:errors property="cli_exige_pc"/>
                    <html:errors property="cli_agrupa_notas"/>
                    <html:errors property="cli_aceita_antecipacao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_plus_clientes"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cliente
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cliente" styleClass="disabled" tabindex="-1" readonly="true"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Razão Social
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nome Fantasia
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_nome" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="35"/>
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

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Contato
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="contato" styleClass="disabled" tabindex="-1" readonly="true" size="70" maxlength="70"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situação Cliente
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_situ" styleClass="disabled" tabindex="-1" readonly="true" size="7" maxlength="7"/>
                    <span class="spamFormLabel">
                      Situação Seqüencial
                    </span>
                    <html:text property="esc_situacao" styleClass="disabled" tabindex="-1" readonly="true" size="7" maxlength="7"/>
                    <span class="spamFormLabel">
                      Cliente Desde
                    </span>
                    <html:text property="cli_dtin" styleClass="disabled" tabindex="-1" readonly="true" size="11" maxlength="11"/>
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

                <html:hidden property="ender"/>
                <html:hidden property="bairro_cidade"/>
                <html:hidden property="cid_uf"/>
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
                        portalbr.com.ClientesGruposEconomicos_dActionForm ClientesGruposEconomicos_dActionForm = (portalbr.com.ClientesGruposEconomicos_dActionForm)session.getAttribute("ClientesGruposEconomicos_dActionForm");
                        if(ClientesGruposEconomicos_dActionForm!=null && (ClientesGruposEconomicos_dActionForm.getCli_cdgo()!=null && ClientesGruposEconomicos_dActionForm.getCli_cdgo().length()>0 && ClientesGruposEconomicos_dActionForm.getEsc_seqn()!=null && ClientesGruposEconomicos_dActionForm.getEsc_seqn().length()>0)) {
                          com.egen.util.jdbc.JdbcUtil j = null;
                          try {
                            j = new com.egen.util.jdbc.JdbcUtil();
                            res_Jw_clientes_enderecos = j.select(t_jw_clientes_enderecos,
                            " SELECT DISTINCT a.cli_cdgo, "+
                            "        b.esc_seqn, "+
                            "        c.ned_cdgo, "+
                            "        c.ecl_nome||' , '||c.ecl_nmro || decode(c.ecl_cpto,null,'',' - '||c.ecl_cpto) endereco, "+
                            "        substr(c.ecl_cep,1,5)||'-'||substr(c.ecl_cep, 6,3) cep, "+
                            "        c.ecl_bair||' - '||c.ecl_cdad||'/'||c.est_unifed bairro_cidade "+
                            "   FROM brio.cli a, "+
                            "        brio.esc b, "+
                            "        brio.ecl c, "+
                            "        cliente_representante cr "+
                            "  WHERE b.esc_seqn           = c.esc_seqn "+
                            "    AND a.cli_cdgo           = b.cli_cdgo "+
                            "    AND b.cli_cdgo           = c.cli_cdgo "+
                            "    AND cr.codigo_cliente    = a.cli_cdgo "+
                            "    AND cr.codigo_sequencial = b.esc_seqn "+
                            "    AND a.cli_cdgo           = "+ClientesGruposEconomicos_dActionForm.getCli_cdgo()+
                            "    AND b.esc_seqn           = "+ClientesGruposEconomicos_dActionForm.getEsc_seqn()
                            , null);
                          } catch (Exception e){
                            res_Jw_clientes_enderecos = null;
                          } finally {
                          if(j!=null){j.close();}
                          j = null;
                        }
                      } else {
                        res_Jw_clientes_enderecos = null;
                      }
                      if (res_Jw_clientes_enderecos!=null && res_Jw_clientes_enderecos.size()>0) {
                        java.lang.String ned_cdgo      =  null;
                        java.lang.String endereco      =  null;
                        java.lang.String cep           =  null;
                        java.lang.String bairro_cidade =  null;
                        java.lang.String cli_cdgo      =  null;
                        java.lang.String esc_seqn      =  null;
                        int i_bl_report_Jw_clientes_enderecos = 0;
                        t_jw_clientes_enderecos = (portalbr.dbobj.view.Jw_clientes_enderecos)res_Jw_clientes_enderecos.elementAt(i_bl_report_Jw_clientes_enderecos);
                        ned_cdgo      = t_jw_clientes_enderecos.getNed_cdgo()==null?"":t_jw_clientes_enderecos.getNed_cdgo();
                        endereco      = t_jw_clientes_enderecos.getEndereco()==null?"":t_jw_clientes_enderecos.getEndereco();
                        cep           = t_jw_clientes_enderecos.getCep()==null?"":t_jw_clientes_enderecos.getCep();
                        bairro_cidade = t_jw_clientes_enderecos.getBairro_cidade()==null?"":t_jw_clientes_enderecos.getBairro_cidade();
                        cli_cdgo      = t_jw_clientes_enderecos.getCli_cdgo()==null?"":t_jw_clientes_enderecos.getCli_cdgo();
                        esc_seqn      = t_jw_clientes_enderecos.getEsc_seqn()==null?"":t_jw_clientes_enderecos.getEsc_seqn();
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
                          ned_cdgo      = t_jw_clientes_enderecos.getNed_cdgo()==null?"":t_jw_clientes_enderecos.getNed_cdgo();
                          endereco      = t_jw_clientes_enderecos.getEndereco()==null?"":t_jw_clientes_enderecos.getEndereco();
                          cep           = t_jw_clientes_enderecos.getCep()==null?"":t_jw_clientes_enderecos.getCep();
                          bairro_cidade = t_jw_clientes_enderecos.getBairro_cidade()==null?"":t_jw_clientes_enderecos.getBairro_cidade();
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
                    portalbr.com.ClientesGruposEconomicos_dActionForm ClientesGruposEconomicos_dActionForm = (portalbr.com.ClientesGruposEconomicos_dActionForm)session.getAttribute("ClientesGruposEconomicos_dActionForm");
                    if(ClientesGruposEconomicos_dActionForm!=null && (ClientesGruposEconomicos_dActionForm.getCli_cdgo()!=null && ClientesGruposEconomicos_dActionForm.getCli_cdgo().length()>0 && ClientesGruposEconomicos_dActionForm.getEsc_seqn()!=null && ClientesGruposEconomicos_dActionForm.getEsc_seqn().length()>0)) {
                      com.egen.util.jdbc.JdbcUtil j = null;
                      try {
                        j = new com.egen.util.jdbc.JdbcUtil();
                        String[][] select =  null;
                        Object[][] where = null;
                        where = new Object[][] {{"codigo_cliente","=",ClientesGruposEconomicos_dActionForm.getCli_cdgo()},{"esc_seqn","=",ClientesGruposEconomicos_dActionForm.getEsc_seqn()}};
                        res_Jw_cliente_representante = j.select(t_jw_cliente_representante,select,where,null,null,null);
                      } catch (Exception e){
                        res_Jw_cliente_representante = null;
                      } finally {
                      if(j!=null){j.close();}
                      j = null;
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


            <html:hidden property="esc_seqn" value="1"/>
            <html:hidden property="cli_cdgo"/>
          </table>

          <table class="buttonTable" style='width:99%;'>
            <tr class="buttonTr">
              <td class="buttonTd">
                <html:submit styleClass="myhidden" property="select_action">
                  <bean:message bundle="ApplicationResources" key="jsp.select"/>
                </html:submit>
                <html:button onclick="history.go(-1);" styleClass="baseButton" property="back_action">
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

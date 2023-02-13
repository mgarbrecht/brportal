<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      <bean:message bundle="ComercialResources" key="ConsultaPedidos_p.titulo"/>
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
                  <%@ include file="../system/header_excel.jsp" %>
                </td>

              </tr>

            </table>

            <html:form action="com/ConsultaPedidos_pForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="codigo"/>
                    <html:errors property="razao_social"/>
                    <html:errors property="cid_uf"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <html:hidden property="ped_"/>
                <%
                portalbr.com.ConsultaPedidos_pActionForm pedActionForm  = (portalbr.com.ConsultaPedidos_pActionForm) session.getAttribute("ConsultaPedidos_pActionForm");
                String ped = ""+pedActionForm.getPed_();
                if(ped.equals("")){
                  %>

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

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Razão Social
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="razao_social" styleClass="disabled" tabindex="-1" readonly="true" size="38" maxlength="35"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Cidade - UF
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="cid_uf" styleClass="disabled" tabindex="-1" readonly="true" size="65" maxlength="65"/>
                    </td>
                  </tr>

                  <html:hidden property="cliente1"/>
                  <html:hidden property="marca"/>
                  <%
                }
                %>
                <html:hidden property="tipo_pedido"/>
              </table>

            </html:form>
            <%
            if(request.getAttribute("arquivo")!=null){
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


            <table class="messageTable1" style='width:99%;'>
              <tr class="messageTr1" >
                <td class="messageTd1">
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_ped_1"/>
                </td>
              </tr>
            </table>


            <%
            portalbr.com.ConsultaPedidos_pActionForm ConsultaPedidos_pActionForm = (portalbr.com.ConsultaPedidos_pActionForm)session.getAttribute("ConsultaPedidos_pActionForm");
            util.consultas.Query query = new util.consultas.Query();
            %>

            <%
            if(session.getAttribute("consulta_pedidos_agrupa_cliente")==null){
              %>

              <%
              if(ConsultaPedidos_pActionForm.getCodigo()!=null){
                %>
                <table id="TRbl_report_Jw_consulta_pedidos_ped" class="reportTable" style=width:99%;  border=1  frame=box>
                  <tr class="reportHeader2" >
                    <td class="columnTdHeader" style="text-align:left;">
                      Código
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Razão Social
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Cidade - UF
                    </td>
                  </tr>
                  <tr class="rowColor" >
                    <td style="text-align:left;">
                      <%= ConsultaPedidos_pActionForm.getCodigo() %>
                    </td>
                    <td style="text-align:left;">
                      <%= ConsultaPedidos_pActionForm.getRazao_social() %>
                    </td>
                    <td style="text-align:left;">
                      <%= ConsultaPedidos_pActionForm.getCid_uf() %>
                    </td>
                  </tr>
                </table>
                <%
              }
              %>

              <%
            }
            %>

            <table id="TRbl_report_Jw_consulta_pedidos_ped" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int total_pares = 0;
              double total_pedido = 0;
              int counterbl_report_Jw_consulta_pedidos_ped=0;
              com.egen.util.jdbc.JdbcUtil j = null;
              try
              {

                j = new com.egen.util.jdbc.JdbcUtil();
                portalbr.dbobj.view.Jw_consulta_pedidos_ped t_jw_consulta_pedidos_ped = new portalbr.dbobj.view.Jw_consulta_pedidos_ped();
                java.util.Vector res_Jw_consulta_pedidos_ped = (java.util.Vector)session.getAttribute("res_Jw_consulta_pedidos_ped");
                if (res_Jw_consulta_pedidos_ped!=null && res_Jw_consulta_pedidos_ped.size()>0 && false) {
                  java.lang.Integer pedido_beira_rio =  null;
                  java.lang.String pedido_cliente    =  null;
                  int qtde_pares                     =  0;
                  java.lang.String rep               =  null;
                  java.lang.String status            =  null;
                  java.lang.String pt                =  null;
                  java.sql.Timestamp dt_digitacao    =  null;
                  java.sql.Timestamp dt_entrega      =  null;
                  java.lang.String dt_embarque     =  null;
                  java.lang.String nome_linha        =  null;
                  java.lang.String marca             =  null;
                  java.lang.String filial_pedido     =  null;
                  java.lang.String cliente           =  null;
                  java.lang.String emp_empresa       =  null;
                  java.lang.String ped_tipo          =  null;
                  java.lang.String periodo_entrega   =  null;
                  java.lang.String descricao_livro   =  null;
                  java.lang.Double valor_pedido      =  0.0;
                  java.lang.String recolocado        =  "";
                  java.lang.String fora_normas       =  "";
                  java.lang.String remessa           =  "";
                  java.lang.String previsao_faturamento =  "";
                  java.lang.String valor_indenizado =  "";
                  int i_bl_report_Jw_consulta_pedidos_ped = 0;
                  t_jw_consulta_pedidos_ped = (portalbr.dbobj.view.Jw_consulta_pedidos_ped)res_Jw_consulta_pedidos_ped.elementAt(i_bl_report_Jw_consulta_pedidos_ped);
                  pedido_beira_rio = t_jw_consulta_pedidos_ped.getPedido_beira_rio();
                  qtde_pares       = t_jw_consulta_pedidos_ped.getQtde_pares();
                  pedido_cliente   = t_jw_consulta_pedidos_ped.getPedido_cliente()==null?"":t_jw_consulta_pedidos_ped.getPedido_cliente();
                  remessa          = t_jw_consulta_pedidos_ped.getRemessa()==null?"":t_jw_consulta_pedidos_ped.getRemessa();
                  rep              = t_jw_consulta_pedidos_ped.getRep()==null?"":t_jw_consulta_pedidos_ped.getRep();
                  status           = t_jw_consulta_pedidos_ped.getStatus()==null?"":t_jw_consulta_pedidos_ped.getStatus();
                  pt               = t_jw_consulta_pedidos_ped.getPt()==null?"":t_jw_consulta_pedidos_ped.getPt();
                  filial_pedido    = t_jw_consulta_pedidos_ped.getFilial_pedido()==null?"":t_jw_consulta_pedidos_ped.getFilial_pedido();
                  dt_digitacao     = (java.sql.Timestamp)t_jw_consulta_pedidos_ped.getDt_digitacao();
                  dt_entrega       = (java.sql.Timestamp)t_jw_consulta_pedidos_ped.getDt_entrega();
                  dt_embarque      = t_jw_consulta_pedidos_ped.getDt_embarque()==null?"":t_jw_consulta_pedidos_ped.getDt_embarque();
                  nome_linha       = t_jw_consulta_pedidos_ped.getNome_linha()==null?"":t_jw_consulta_pedidos_ped.getNome_linha();
                  marca            = t_jw_consulta_pedidos_ped.getMarca()==null?"":t_jw_consulta_pedidos_ped.getMarca();
                  cliente          = t_jw_consulta_pedidos_ped.getCliente()==null?"":t_jw_consulta_pedidos_ped.getCliente();
                  emp_empresa      = t_jw_consulta_pedidos_ped.getEmp_empresa()==null?"":t_jw_consulta_pedidos_ped.getEmp_empresa();
                  ped_tipo         = t_jw_consulta_pedidos_ped.getPed_tipo()==null?"":t_jw_consulta_pedidos_ped.getPed_tipo();
                  periodo_entrega  = t_jw_consulta_pedidos_ped.getPeriodo_entrega()==null?"":t_jw_consulta_pedidos_ped.getPeriodo_entrega();
                  previsao_faturamento = t_jw_consulta_pedidos_ped.getPrevisao_faturamento()==null?"":t_jw_consulta_pedidos_ped.getPrevisao_faturamento();
                  descricao_livro  = t_jw_consulta_pedidos_ped.getDescricao_livro()==null?"":t_jw_consulta_pedidos_ped.getDescricao_livro();
                  valor_pedido     = t_jw_consulta_pedidos_ped.getValor_pedido();
                  recolocado       = t_jw_consulta_pedidos_ped.getRecolocado();
                  fora_normas      = t_jw_consulta_pedidos_ped.getFora_normas();
                  valor_indenizado = t_jw_consulta_pedidos_ped.getValor_indenizado()==null?"":t_jw_consulta_pedidos_ped.getValor_indenizado()+"";
                  total_pares += qtde_pares;
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:center;">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_p.pedido_beira_rio"/>
                    </td>

                    <%
                    if(((ConsultaPedidos_pActionForm.getCod()+"").indexOf("g")!=-1)||(session.getAttribute("consulta_pedidos_agrupa_cliente")!=null)){
                      %>
                      <td class="columnTdHeader" style="text-align:left;">
                        Cliente
                      </td>
                      <%
                    }
                    %>

                    <td class="columnTdHeader" style="text-align:center;">
                      Pares
                    </td>

                    <td class="columnTdHeader" style="text-align:center;">
                      Valor
                      <br>
                      Líquido
                    </td>

                    <td class="columnTdHeader" style="text-align:center;">
                      Tipo
                      <br>
                      de Pedido
                    </td>

                    <td class="columnTdHeader" style="text-align:center;">
                      Livro
                    </td>

                    <%
                    if(session.getAttribute("consulta_pedidos_somente_indenizados")!=null || session.getAttribute("consulta_pedidos_somente_indenizados") == "s" ){
                      %>
                      <td class="columnTdHeader" style="text-align:left;">
                        Valor
                        <br>
                        Indenizado
                      </td>
                      <%
                    }
                    %>
                    <td class="columnTdHeader" style="text-align:center;">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_p.nota_fiscal"/>
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Filial Pedido
                    </td>
                    <td class="columnTdHeader" style="text-align:center;" size=1;>
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_p.pedido_cliente"/>
                    </td>
                    <td class="columnTdHeader" style="text-align:center;" size=1;>
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_p.remessa"/>
                    </td>
                    <%
                    if((!((ConsultaPedidos_pActionForm.getCliente()+"").equals("s")))){
                      %>
                      <td class="columnTdHeader" style="text-align:center;">
                        Rep.
                      </td>
                      <%
                    }
                    %>
                    <td class="columnTdHeader" style="text-align:center;">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_p.status"/>
                    </td>
                    <%
                    if((!((ConsultaPedidos_pActionForm.getCliente()+"").equals("s")))){
                      %>
                      <!--
                        <td class="columnTdHeader" style="text-align:center;"> Status Real </td>
                      -->
                      <%
                    }
                    %>
                    <td class="columnTdHeader" style="text-align:center;">
                      Data
                      <br>
                      Digitação
                    </td>
                    <!--
                      <td class="columnTdHeader" style="text-align:center;"> <bean:message bundle="ComercialResources" key="ConsultaPedidos_p.dt_entrega"/> </td>
                    -->
                    <td class="columnTdHeader" style="text-align:center;">
                      Previsão de Faturamento
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_p.dt_embarque"/>
                    </td>
                    <%
                    if(session.getAttribute("consulta_pedidos_nao_mostra_linhas")==null){
                      %>
                      <td class="columnTdHeader" style="text-align:left;">
                        <bean:message bundle="ComercialResources" key="ConsultaPedidos_p.nome_linha"/>
                      </td>
                      <%
                    }
                    %>
                    <td class="columnTdHeader" style="text-align:left;">
                      <bean:message bundle="ComercialResources" key="ConsultaPedidos_p.marca"/>
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Recolocado
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Fora Normas
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Valor Indenizado
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Jw_consulta_pedidos_ped<res_Jw_consulta_pedidos_ped.size()){
                    counterbl_report_Jw_consulta_pedidos_ped++;
                    String style="";
                    if (!((i_bl_report_Jw_consulta_pedidos_ped%2)!=0)) {
                      style="rowColor";
                    } else {
                      style="rowBlank";
                    }
                    %>
                    <tr class=<%= style %> id='TRbl_report_Jw_consulta_pedidos_ped<%=counterbl_report_Jw_consulta_pedidos_ped%>'  >
                      <td class="reportColumn" style="text-align:center;" title="Itens do Pedido: <%= pedido_beira_rio %>">
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <a href="../com/ConsultaPedidos_iForm.do?select_action=&pedido_beira_rio=<%= pedido_beira_rio %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                            <%= ((pedido_beira_rio!=null)?pedido_beira_rio.toString():"") %>
                          </a>
                          <%
                        } else {
                          %>
                          <%= ((pedido_beira_rio!=null)?pedido_beira_rio.toString():"") %>
                          <%
                        }
                        %>
                      </td>

                      <%
                      if(((ConsultaPedidos_pActionForm.getCod()+"").indexOf("g")!=-1)||(session.getAttribute("consulta_pedidos_agrupa_cliente")!=null)){
                        %>
                        <td class="reportColumn" style="text-align: left;" size=1;>
                          <%= cliente %>
                        </td>
                        <%
                      }
                      %>

                      <td class="reportColumn" style="text-align:center;" size=1;>
                        <%= qtde_pares %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" size=1;>
                        <%
                        total_pedido += valor_pedido;
                        %>
                        <%= com.egen.util.text.FormatNumber.format(valor_pedido,"##,##0.00") %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" size=1;>
                        <%= ped_tipo %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" size=1;>
                        <%= descricao_livro %>
                      </td>

                      <td class="reportColumn" style="text-align:center;">
                        <%
                        StringBuilder sb = new StringBuilder();
                        sb.append(" SELECT nfs_nmro ");
                        sb.append("      , nfs_serie ");
                        sb.append("      , fil_filial ");
                        sb.append("   FROM notas_fiscais_saida_ped_venda ");
                        sb.append("  WHERE ped_nmro = ? ");

                        java.sql.PreparedStatement pstm = null;
                        java.sql.ResultSet rset = null;
                        try {
                          pstm = j.getConn().prepareStatement(sb.toString());
                          pstm.setString(1, pedido_beira_rio.toString());
                          rset = pstm.executeQuery();
                          int contador = 1;
                          while (rset.next()) {
                            if((contador>1) && (contador <rset.getFetchSize())){
                              %>
                              <br>
                              <%
                            }
                            %>
                            <%
                            if(!(request.getParameter("excel")+"").equals("true")){
                              %>
                              <a href="../com/NotaFiscalForm.do?select_action=&emp_empresa=<%= emp_empresa %>&nf_nmro=<%= rset.getString(1) %>&nf_serie=<%= rset.getString(2) %>&fil_filial=<%= rset.getString(3) %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                <%= rset.getString(1)+"" %>
                                -
                                <%= rset.getString(2)+"" %>
                              </a>
                              <%
                            } else {
                              %>
                              <%= rset.getString(1)+"" %>
                              -
                              <%= rset.getString(2)+"" %>
                              <%
                            }
                            %>
                            <%
                            contador ++;
                          }
                        } finally {
                          if(rset != null){
                            rset.close();
                          }
                          if(pstm != null){
                            pstm.close();
                          }
                        }
                        %>

                      </td>
                      <td class="reportColumn" style="text-align:center;" size=1;>
                        <%= filial_pedido %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" size=1;>
                        <%= valor_indenizado %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" size=1;>
                        <%= pedido_cliente %>
                      </td>
                      <td class="reportColumn" style="text-align:center;" size=1;>
                        <%= remessa %>
                      </td>
                      <%
                      if((!((ConsultaPedidos_pActionForm.getCliente()+"").equals("s")))){
                        %>
                        <td class="reportColumn" style="text-align:center;">
                          <%= rep %>
                        </td>
                        <%
                      }
                      %>
                      <td class="reportColumn" style="text-align:center;">
                        <%= status %>
                      </td>
                      <%
                      if((!((ConsultaPedidos_pActionForm.getCliente()+"").equals("s")))){
                        %>
                        <!--
                          <td class="reportColumn" style="text-align:center;"> <%= pt %> </td>
                        -->
                        <%
                      }
                      %>
                      <td class="reportColumn" style="text-align:center;">
                        <%= com.egen.util.text.FormatDate.format(dt_digitacao, "dd/MM/yyyy") %>
                      </td>

                      <!--
                        <td class="reportColumn" style="text-align:center;"> <%= periodo_entrega %> </td>
                      -->
                      <td class="reportColumn" style="text-align:center;">
                        <%= previsao_faturamento %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= dt_embarque %>
                      </td>
                      <%
                      if(session.getAttribute("consulta_pedidos_nao_mostra_linhas")==null){
                        %>
                        <td class="reportColumn" style="text-align:left;">
                          <%= nome_linha %>
                        </td>
                        <%
                      }
                      %>
                      <td class="reportColumn" style="text-align:left;">
                        <%= marca %>
                      </td>
                      <td class="reportColumn" style="text-align:left; <% if(recolocado.equals("Sim")){ %>color:red;font-weight:bold;<% } %>">
                        <%= recolocado %>
                      </td>
                      <td class="reportColumn" style="text-align:left; <% if(fora_normas.equals("Sim")){ %>color:red;font-weight:bold;<% } %>">
                        <%= fora_normas %>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Jw_consulta_pedidos_ped >= res_Jw_consulta_pedidos_ped.size()) {
                      break;
                    }
                    t_jw_consulta_pedidos_ped = (portalbr.dbobj.view.Jw_consulta_pedidos_ped)res_Jw_consulta_pedidos_ped.elementAt(i_bl_report_Jw_consulta_pedidos_ped);
                    pedido_beira_rio = t_jw_consulta_pedidos_ped.getPedido_beira_rio();
                    qtde_pares       = t_jw_consulta_pedidos_ped.getQtde_pares();
                    pedido_cliente   = t_jw_consulta_pedidos_ped.getPedido_cliente()==null?"":t_jw_consulta_pedidos_ped.getPedido_cliente();
                    remessa          = t_jw_consulta_pedidos_ped.getRemessa()==null?"":t_jw_consulta_pedidos_ped.getRemessa();
                    rep              = t_jw_consulta_pedidos_ped.getRep()==null?"":t_jw_consulta_pedidos_ped.getRep();
                    status           = t_jw_consulta_pedidos_ped.getStatus()==null?"":t_jw_consulta_pedidos_ped.getStatus();
                    pt               = t_jw_consulta_pedidos_ped.getPt()==null?"":t_jw_consulta_pedidos_ped.getPt();
                    dt_digitacao     = (java.sql.Timestamp)t_jw_consulta_pedidos_ped.getDt_digitacao();
                    filial_pedido    = t_jw_consulta_pedidos_ped.getFilial_pedido()==null?"":t_jw_consulta_pedidos_ped.getFilial_pedido();
                    dt_entrega       = (java.sql.Timestamp)t_jw_consulta_pedidos_ped.getDt_entrega();
                    dt_embarque      = t_jw_consulta_pedidos_ped.getDt_embarque()==null?"":t_jw_consulta_pedidos_ped.getDt_embarque();
                    nome_linha       = t_jw_consulta_pedidos_ped.getNome_linha()==null?"":t_jw_consulta_pedidos_ped.getNome_linha();
                    marca            = t_jw_consulta_pedidos_ped.getMarca()==null?"":t_jw_consulta_pedidos_ped.getMarca();
                    cliente          = t_jw_consulta_pedidos_ped.getCliente()==null?"":t_jw_consulta_pedidos_ped.getCliente();
                    emp_empresa      = t_jw_consulta_pedidos_ped.getEmp_empresa()==null?"":t_jw_consulta_pedidos_ped.getEmp_empresa();
                    ped_tipo         = t_jw_consulta_pedidos_ped.getPed_tipo()==null?"":t_jw_consulta_pedidos_ped.getPed_tipo();
                    periodo_entrega  = t_jw_consulta_pedidos_ped.getPeriodo_entrega()==null?"":t_jw_consulta_pedidos_ped.getPeriodo_entrega();
                    descricao_livro  = t_jw_consulta_pedidos_ped.getDescricao_livro()==null?"":t_jw_consulta_pedidos_ped.getDescricao_livro();
                    previsao_faturamento = t_jw_consulta_pedidos_ped.getPrevisao_faturamento()==null?"":t_jw_consulta_pedidos_ped.getPrevisao_faturamento();
                    valor_pedido     = t_jw_consulta_pedidos_ped.getValor_pedido();
                    recolocado       = t_jw_consulta_pedidos_ped.getRecolocado();
                    fora_normas      = t_jw_consulta_pedidos_ped.getFora_normas();
                    total_pares += qtde_pares;
                  }
                }else {
                  %>
                  <%
                }}



                catch (Exception e){
                  e.printStackTrace();
                }
                finally {
                  if(j!=null){
                    j.close();
                    j=null;
                  }
                }
                %>

              </table>
              <%
              boolean excel = false;
              if((request.getParameter("excel")+"").equals("true")){
                excel = true;
              }
              portalbr.dbobj.view.Jw_consulta_pedidos_ped t_consulta_pedidos = new portalbr.dbobj.view.Jw_consulta_pedidos_ped();
              java.util.Vector res_consulta_pedidos = (java.util.Vector)session.getAttribute("res_Jw_consulta_pedidos_ped");
              com.egen.util.jdbc.JdbcUtil j2 = null;
              int total_pares_s = 0;
              double total_pedido_s = 0;
              try {
                j2 = new com.egen.util.jdbc.JdbcUtil();
                %>

                <html:form action="com/ConsultaPedidos_pGrid.do" method="post" styleClass="baseForm">

                  <table class="itemGridTable" style='width:99%;'  border=1  frame=box>

                    <tr class="reportHeader">
                      <td class="columnTdHeader" style="text-align: center;">
                      </td>
                      <td class="columnTdHeader" style="text-align: center;">
                        <bean:message bundle="ComercialResources" key="ConsultaPedidos_p.pedido_beira_rio"/>
                      </td>

                      <%
                      if(((ConsultaPedidos_pActionForm.getCod()+"").indexOf("g")!=-1)||(session.getAttribute("consulta_pedidos_agrupa_cliente")!=null)){
                        %>
                        <td class="columnTdHeader" style="text-align:left;">
                          Cliente
                        </td>
                        <%
                      }
                      %>

                      <td class="columnTdHeader" style="text-align: center;">
                        Pares
                      </td>

                      <td class="columnTdHeader" style="text-align: center;">
                        Valor
                        <br>
                        Bruto
                      </td>

                      <td class="columnTdHeader" style="text-align: center;">
                        Valor
                        <br>
                        Líquido
                      </td>

                      <td class="columnTdHeader" style="text-align: center;">
                        Valor
                        <br>
                        Nota Fiscal
                      </td>

                      <td class="columnTdHeader" style="text-align: center;">
                        Tipo
                        <br>
                        de Pedido
                      </td>

                      <td class="columnTdHeader" style="text-align: center;">
                        Livro
                      </td>

                      <td class="columnTdHeader" style="text-align: center;">
                        Condição
                        <br>
                        de Pagamento
                      </td>

                      <td class="columnTdHeader" style="text-align:center;">
                        <bean:message bundle="ComercialResources" key="ConsultaPedidos_p.nota_fiscal"/>
                      </td>

                      <%if(session.getAttribute("consulta_pedidos_somente_indenizados") == "s"){ %>
                        <td class="columnTdHeader" style="text-align: center;">
                          Valor
                          <br>
                          Indenizado
                        </td>
                        <%
                      }
                      %>

                      <td class="columnTdHeader" style="text-align:center;">
                        Filial Pedido
                      </td>

                      <td class="columnTdHeader" style="text-align:center;">
                        <bean:message bundle="ComercialResources" key="ConsultaPedidos_p.pedido_cliente"/>
                      </td>

                      <td class="columnTdHeader" style="text-align:center;">
                        <bean:message bundle="ComercialResources" key="ConsultaPedidos_p.remessa"/>
                      </td>

                      <%
                      if((!((ConsultaPedidos_pActionForm.getCliente()+"").equals("s")))){
                        %>
                        <td class="columnTdHeader" style="text-align:center;">
                          Rep.
                        </td>
                        <%
                      }
                      %>

                      <td class="columnTdHeader" style="text-align:center;">
                        <bean:message bundle="ComercialResources" key="ConsultaPedidos_p.status"/>
                      </td>

                      <td class="columnTdHeader" style="text-align:center;">
                        Data
                        <br>
                        Digitação
                      </td>

                      <td class="columnTdHeader" style="text-align:center;">
                        Previsão de Faturamento
                      </td>
                      <td class="columnTdHeader" style="text-align:center;">
                        <bean:message bundle="ComercialResources" key="ConsultaPedidos_p.dt_embarque"/>
                      </td>
                      <%
                      if(session.getAttribute("consulta_pedidos_nao_mostra_linhas")==null){
                        %>
                        <td class="columnTdHeader" style="text-align:left;">
                          <bean:message bundle="ComercialResources" key="ConsultaPedidos_p.nome_linha"/>
                        </td>
                        <%
                      }
                      %>
                      <td class="columnTdHeader" style="text-align:left;">
                        <bean:message bundle="ComercialResources" key="ConsultaPedidos_p.marca"/>
                      </td>
                      <td class="columnTdHeader" style="text-align: center;">
                        Recolocado
                      </td>
                      <td class="columnTdHeader" style="text-align: center;">
                        Fora Normas
                      </td>
                    </tr>

                    <%
                    int contadorRegistros = 0;
                    %>
                    <logic:iterate id="bl_form_Jw_consulta_pedidos_ped_1_lines" name="ConsultaPedidos_pGridActionForm" property="bl_form_Jw_consulta_pedidos_ped_1_lines" indexId="indexId">
                      <%
                      t_consulta_pedidos = (portalbr.dbobj.view.Jw_consulta_pedidos_ped)res_consulta_pedidos.elementAt(contadorRegistros++);
                      String style="";
                      if (!((contadorRegistros%2)!=0)) {
                        style="rowColor";
                      } else {
                        style="rowBlank";
                      }
                      %>

                      <tr class="<%= style %>" >
                        <td class="reportColumn" style="text-align: center;">
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                            <%
                          }
                          %>
                        </td>

                        <%
                        if(!excel){
                          %>
                          <td class="reportColumn" style="text-align: center;">
                            <%
                          } else {
                            %>
                            <td style="text-align: center;">
                              <%
                            }
                            %>
                            <%
                            if(!excel){
                              %>
                              <html:hidden property="pedido_beira_rio" styleId="pedido_beira_rio" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                              <%
                            }
                            %>
                            <%
                            if(!(request.getParameter("excel")+"").equals("true")){
                              %>
                              <a href="../com/ConsultaPedidos_iForm.do?select_action=&pedido_beira_rio=<%= t_consulta_pedidos.getPedido_beira_rio() %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                <%= ((t_consulta_pedidos.getPedido_beira_rio()!=null)?t_consulta_pedidos.getPedido_beira_rio():"") %>
                              </a>
                              <%
                            } else {
                              %>
                              <%= ((t_consulta_pedidos.getPedido_beira_rio()!=null)?t_consulta_pedidos.getPedido_beira_rio():"") %>
                              <%
                            }
                            %>

                          </td>

                          <%
                          if(((ConsultaPedidos_pActionForm.getCod()+"").indexOf("g")!=-1)||(session.getAttribute("consulta_pedidos_agrupa_cliente")!=null)){
                            %>
                            <td class="reportColumn" >
                              <%= t_consulta_pedidos.getCliente() %>
                            </td>
                            <%
                          }
                          %>

                          <%
                          if(!excel){
                            %>
                            <td class="reportColumn" >
                              <%
                            } else {
                              %>
                              <td>
                                <%
                              }
                              %>
                              <%
                              if(!excel){
                                %>
                                <html:hidden property="qtde_pares" styleId="qtde_pares" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                <%
                              }
                              %>
                              <%= t_consulta_pedidos.getQtde_pares() %>
                              <%
                              total_pares_s += t_consulta_pedidos.getQtde_pares();
                              %>
                            </td>

                            <%
                            if(!excel){
                              %>
                              <td class="reportColumn">
                                <%
                              } else {
                                %>
                                <td>
                                  <%
                                }
                                %>
                                <%
                                if(!excel){
                                  %>
                                  <html:hidden property="valor_bruto" styleId="valor_pedido" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                  <%
                                }
                                %>
                                <%= com.egen.util.text.FormatNumber.format(t_consulta_pedidos.getValor_bruto(), "##,##0.00") %>
                              </td>

                              <%
                              if(!excel){
                                %>
                                <td class="reportColumn">
                                  <%
                                } else {
                                  %>
                                  <td>
                                    <%
                                  }
                                  %>
                                  <%
                                  if(!excel){
                                    %>
                                    <html:hidden property="valor_pedido" styleId="valor_pedido" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                    <%
                                  }
                                  %>
                                  <%= com.egen.util.text.FormatNumber.format(t_consulta_pedidos.getValor_pedido(), "##,##0.00") %>
                                  <%
                                  total_pedido_s += t_consulta_pedidos.getValor_pedido();
                                  %>
                                </td>

                                <%
                                if(!excel){
                                  %>
                                  <td class="reportColumn">
                                    <%
                                  } else {
                                    %>
                                    <td>
                                      <%
                                    }
                                    %>
                                    <%
                                    if(!excel){
                                      %>
                                      <html:hidden property="valor_nota" styleId="valor_nota" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                      <%
                                    }
                                    %>
                                    <%= com.egen.util.text.FormatNumber.format(t_consulta_pedidos.getValor_nota(), "##,##0.00") %>
                                  </td>


                                  <%
                                  if(!excel){
                                    %>
                                    <td class="reportColumn" style="text-align: center;">
                                      <%
                                    } else {
                                      %>
                                      <td style="text-align: center;">
                                        <%
                                      }
                                      %>
                                      <%
                                      if(!excel){
                                        %>
                                        <html:hidden property="ped_tipo" styleId="ped_tipo" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                        <%
                                      }
                                      %>
                                      <%= t_consulta_pedidos.getPed_tipo()!=null?t_consulta_pedidos.getPed_tipo():"" %>
                                    </td>

                                    <%
                                    if(!excel){
                                      %>
                                      <td class="reportColumn" style="text-align: center;">
                                        <%
                                      } else {
                                        %>
                                        <td style="text-align: center;">
                                          <%
                                        }
                                        %>
                                        <%
                                        if(!excel){
                                          %>
                                          <html:hidden property="descricao_livro" styleId="ped_tipo" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                          <%
                                        }
                                        %>
                                        <%= t_consulta_pedidos.getDescricao_livro()!=null?t_consulta_pedidos.getDescricao_livro():"" %>
                                      </td>


                                      <%
                                      if(!excel){
                                        %>
                                        <td class="reportColumn" style="text-align: center;">
                                          <%
                                        } else {
                                          %>
                                          <td style="text-align: center;">
                                            <%
                                          }
                                          %>
                                          <%
                                          if(!excel){
                                            %>
                                            <html:hidden property="condicao_pagamento" styleId="condicao_pagamento" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                            <%
                                          }
                                          %>
                                          <%= t_consulta_pedidos.getCondicao_pagamento()!=null?t_consulta_pedidos.getCondicao_pagamento():"" %>
                                        </td>

                                        <%
                                        if(!excel){
                                          %>
                                          <td class="reportColumn" style="text-align:center;">
                                            <%
                                          } else {
                                            %>
                                            <td style="text-align:center;">
                                              <%
                                            }
                                            %>
                                            <%
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(" SELECT nfs_nmro ");
                                            sb.append("      , nfs_serie ");
                                            sb.append("      , fil_filial ");
                                            sb.append("   FROM notas_fiscais_saida_ped_venda ");
                                            sb.append("  WHERE ped_nmro = ? ");

                                            java.sql.PreparedStatement pstm = null;
                                            java.sql.ResultSet rset = null;
                                            try {
                                              pstm = j2.getConn().prepareStatement(sb.toString());
                                              pstm.setString(1, t_consulta_pedidos.getPedido_beira_rio().toString());
                                              rset = pstm.executeQuery();
                                              int contador = 1;
                                              while (rset.next()) {
                                                if((contador>1) && (contador <rset.getFetchSize())){
                                                  %>
                                                  <br>
                                                  <%
                                                }
                                                if(!(request.getParameter("excel")+"").equals("true")){
                                                  %>
                                                  <a href="../com/NotaFiscalForm.do?select_action=&emp_empresa=<%= t_consulta_pedidos.getEmp_empresa() %>&nf_nmro=<%= rset.getString(1) %>&nf_serie=<%= rset.getString(2) %>&fil_filial=<%= rset.getString(3) %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                                    <%= rset.getString(1)+"" %>
                                                    -
                                                    <%= rset.getString(2)+"" %>
                                                  </a>
                                                  <%
                                                } else {
                                                  %>
                                                  <%= rset.getString(1)+"" %>
                                                  -
                                                  <%= rset.getString(2)+"" %>
                                                  <%
                                                }
                                                %>
                                                <%
                                                contador ++;

                                              }

                                            } finally {
                                              if(rset != null){
                                                rset.close();
                                              }
                                              if(pstm != null){
                                                pstm.close();
                                              }
                                            }
                                            %>
                                          </td>
                                          <%if(session.getAttribute("consulta_pedidos_somente_indenizados") == "s"){ %>
                                            <%
                                            if(!excel){
                                              %>
                                              <td class="reportColumn" style="text-align: center;">
                                                <%
                                              } else {
                                                %>
                                                <td style="text-align: center;">
                                                  <%
                                                }
                                                %>
                                                <%
                                                if(!excel){
                                                  %>
                                                  <html:hidden property="valor_indenizado" styleId="valor_indenizado" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                                  <%
                                                }
                                                %>
                                                <%= t_consulta_pedidos.getValor_indenizado()!=null?t_consulta_pedidos.getValor_indenizado()+"":"" %>
                                              </td>
                                              <%
                                            }
                                            %>
                                            <%
                                            if(!excel){
                                              %>
                                              <td class="reportColumn" style="text-align: center;">
                                                <%
                                              } else {
                                                %>
                                                <td style="text-align: center;">
                                                  <%
                                                }
                                                %>
                                                <%
                                                if(!excel){
                                                  %>
                                                  <html:hidden property="filial_pedido" styleId="filial_pedido" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                                  <%
                                                }
                                                %>
                                                <%= t_consulta_pedidos.getFilial_pedido()!=null?t_consulta_pedidos.getFilial_pedido():"" %>
                                              </td>

                                              <%
                                              if(!excel){
                                                %>
                                                <td class="reportColumn" style="text-align: center;">
                                                  <%
                                                } else {
                                                  %>
                                                  <td style="text-align: center;">
                                                    <%
                                                  }
                                                  %>
                                                  <%
                                                  if(!excel){
                                                    %>
                                                    <html:hidden property="pedido_cliente" styleId="pedido_cliente" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                                    <%
                                                  }
                                                  %>
                                                  <%= t_consulta_pedidos.getPedido_cliente()!=null?t_consulta_pedidos.getPedido_cliente():"" %>
                                                </td>

                                                <%
                                                if(!excel){
                                                  %>
                                                  <td class="reportColumn" style="text-align: center;">
                                                    <%
                                                  } else {
                                                    %>
                                                    <td style="text-align: center;">
                                                      <%
                                                    }
                                                    %>
                                                    <%
                                                    if(!excel){
                                                      %>
                                                      <html:hidden property="remessa" styleId="remessa" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                                      <%
                                                    }
                                                    %>
                                                    <%= t_consulta_pedidos.getRemessa()!=null?t_consulta_pedidos.getRemessa():"" %>
                                                  </td>

                                                  <%
                                                  if((!((ConsultaPedidos_pActionForm.getCliente()+"").equals("s")))){
                                                    %>
                                                    <td class="reportColumn" style="text-align:center;">
                                                      <%
                                                      if(!excel){
                                                        %>
                                                        <html:hidden property="rep" styleId="rep" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                                        <%
                                                      }
                                                      %>
                                                      <%= t_consulta_pedidos.getRep()!=null?t_consulta_pedidos.getRep():"" %>
                                                    </td>
                                                    <%
                                                  }
                                                  %>

                                                  <%
                                                  if(!excel){
                                                    %>
                                                    <td class="reportColumn">
                                                      <%
                                                    } else {
                                                      %>
                                                      <td>
                                                        <%
                                                      }
                                                      %>
                                                      <%
                                                      if(!excel){
                                                        %>
                                                        <html:hidden property="status" styleId="status" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                                        <%
                                                      }
                                                      %>
                                                      <%= t_consulta_pedidos.getStatus()!=null?t_consulta_pedidos.getStatus():"" %>
                                                    </td>

                                                    <td class="reportColumn" style="text-align:center;">
                                                      <%
                                                      if(!excel){
                                                        %>
                                                        <html:hidden property="dt_digitacao" styleId="dt_digitacao" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                                        <%
                                                      }
                                                      %>
                                                      <%= com.egen.util.text.FormatDate.format(t_consulta_pedidos.getDt_digitacao(), "dd/MM/yyyy") %>
                                                    </td>

                                                    <td class="reportColumn" style="text-align:center;">
                                                      <%
                                                      if(!excel){
                                                        %>
                                                        <html:hidden property="previsao_faturamento" styleId="previsao_faturamento" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                                        <%
                                                      }
                                                      %>
                                                      <%= t_consulta_pedidos.getPrevisao_faturamento()!=null?t_consulta_pedidos.getPrevisao_faturamento():"" %>
                                                    </td>

                                                    <%
                                                    if(!excel){
                                                      %>
                                                      <td class="reportColumn" style="text-align:center;">
                                                        <%
                                                      } else {
                                                        %>
                                                        <td style="text-align:center;">
                                                          <%
                                                        }
                                                        %>
                                                        <%
                                                        if(!excel){
                                                          %>
                                                          <html:hidden property="dt_embarque" styleId="dt_embarque" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                                          <%
                                                        }
                                                        %>
                                                        <%= t_consulta_pedidos.getDt_embarque()!=null?t_consulta_pedidos.getDt_embarque():"" %>
                                                      </td>

                                                      <%
                                                      if(session.getAttribute("consulta_pedidos_nao_mostra_linhas")==null){
                                                        %>
                                                        <%
                                                        if(!excel){
                                                          %>
                                                          <td class="reportColumn" style="text-align:left;">
                                                            <%
                                                          } else {
                                                            %>
                                                            <td style="text-align:left;">
                                                              <%
                                                            }
                                                            %>
                                                            <%
                                                            if(!excel){
                                                              %>
                                                              <html:hidden property="nome_linha" styleId="nome_linha" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                                              <%
                                                            }
                                                            %>
                                                            <%= t_consulta_pedidos.getNome_linha()!=null?t_consulta_pedidos.getNome_linha():"" %>
                                                          </td>
                                                          <%
                                                        }
                                                        %>

                                                        <%
                                                        if(!excel){
                                                          %>
                                                          <td class="reportColumn" style="text-align:left;">
                                                            <%
                                                          } else {
                                                            %>
                                                            <td style="text-align:left;">
                                                              <%
                                                            }
                                                            %>
                                                            <%
                                                            if(!excel){
                                                              %>
                                                              <html:hidden property="marca1" styleId="marca1" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                                              <%
                                                            }
                                                            %>
                                                            <%= t_consulta_pedidos.getMarca()!=null?t_consulta_pedidos.getMarca():"" %>
                                                          </td>

                                                          <td class="reportColumn" style="text-align:center; <% if(t_consulta_pedidos.getRecolocado().equals("Sim")){ %>color:red;font-weight:bold;<% } %>">
                                                            <%
                                                            if(!excel){
                                                              %>
                                                              <html:hidden property="recolocado" styleId="recolocado" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                                              <%
                                                            }
                                                            %>
                                                            <%= t_consulta_pedidos.getRecolocado()!=null?t_consulta_pedidos.getRecolocado():"" %>
                                                          </td>

                                                          <td class="reportColumn" style="text-align:center; <% if(t_consulta_pedidos.getFora_normas().equals("Sim")){ %>color:red;font-weight:bold;<% } %>">
                                                            <%
                                                            if(!excel){
                                                              %>
                                                              <html:hidden property="fora_normas" styleId="fora_normas" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                                              <%
                                                            }
                                                            %>
                                                            <%= t_consulta_pedidos.getFora_normas()!=null?t_consulta_pedidos.getFora_normas():"" %>
                                                          </td>

                                                          <%
                                                          if(!excel){
                                                            %>
                                                            <html:hidden property="pt" styleId="pt" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                                            <html:hidden property="dt_entrega1" styleId="dt_entrega1" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                                            <html:hidden property="cliente2" styleId="cliente2" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                                            <html:hidden property="emp_empresa" styleId="emp_empresa" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                                            <html:hidden property="periodo_entrega" styleId="periodo_entrega" name="bl_form_Jw_consulta_pedidos_ped_1_lines" indexed="true"/>
                                                            <%
                                                          }
                                                          %>
                                                        </tr>
                                                      </logic:iterate>


                                                      <%if (total_pares_s >
                                                        0) { %>
                                                        <tr>
                                                          <td>
                                                          </td>
                                                          <td style="text-align: right;">
                                                            <b>
                                                              Total:
                                                            </b>
                                                          </td>

                                                          <%
                                                          if(((ConsultaPedidos_pActionForm.getCod()+"").indexOf("g")!=-1)||(session.getAttribute("consulta_pedidos_agrupa_cliente")!=null)){
                                                            %>
                                                            <td>
                                                            </td>
                                                            <%
                                                          }
                                                          %>

                                                          <td class="reportColumn" style="text-align: right;">
                                                            <b>
                                                              <%= com.egen.util.text.FormatNumber.format(Double.parseDouble(total_pares_s+""),"##,##0")%>
                                                            </b>
                                                          </td>

                                                          <td class="reportColumn" style="text-align: right;">
                                                            <b>
                                                              <%= com.egen.util.text.FormatNumber.format(Double.parseDouble(total_pedido_s+""),"##,##0.00")%>
                                                            </b>
                                                          </td>

                                                          <%
                                                          if((ConsultaPedidos_pActionForm.getCod()+"").indexOf("g")!=-1){
                                                            %>
                                                            <td style="text-align:center;" colspan=17>
                                                              <%
                                                            } else {
                                                              %>
                                                              <td style="text-align:center;" colspan=16>
                                                                <%
                                                              }
                                                              %>
                                                            </td>
                                                          </tr>
                                                          <%} %>



                                                          </table>

                                                          <table class="buttonTable" style='width:99%;'>
                                                            <tr class="buttonTr">
                                                              <td class="buttonTd">

                                                                <%
                                                                if(!(request.getParameter("excel")+"").equals("true")){
                                                                  %>

                                                                  <html:submit accesskey="p" styleClass="myhidden" property="select1_action">
                                                                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                                                                  </html:submit>
                                                                  <html:submit value="Marcar Todos" styleClass="baseButton" property="marcar_todos_action">
                                                                  </html:submit>
                                                                  <html:submit value="Desmarcar Todos" styleClass="baseButton" property="desmarcar_todos_action">
                                                                  </html:submit>
                                                                  <html:submit value="Gerar Relatório" styleClass="baseButton" property="imprimir_action">
                                                                  </html:submit>

                                                                  <%
                                                                  if(((acesso.Usuario)session.getAttribute("User")).isTipo("AREAS") || ((acesso.Usuario)session.getAttribute("User")).isTipo("REGIONAL DE VENDA") || ((acesso.Usuario)session.getAttribute("User")).isTipo("REPRESENTANTE COMERCIAL") || user.isSuperUsuario()) {
                                                                    %>
                                                                    <html:submit value="Gerar Relatório Interno" styleClass="baseButton" property="imprimir_interno_action">
                                                                    </html:submit>
                                                                    <%
                                                                  }
                                                                  %>
                                                                  <html:button accesskey="b" onclick="history.go(-1);" styleClass="baseButton" property="back2_action">
                                                                    <bean:message bundle="ApplicationResources" key="jsp.back"/>
                                                                  </html:button>

                                                                  <%
                                                                }
                                                                %>

                                                              </td>
                                                            </tr>
                                                          </table>

                                                        </html:form>

                                                        <%
                                                      }  catch (Exception e){
                                                        e.printStackTrace();
                                                      }
                                                      finally {
                                                        if(j2!=null){
                                                          j2.close();
                                                          j2=null;
                                                        }
                                                      }
                                                      %>
                                                      <html:form action="com/ConsultaPedidos_pForm.do" method="post" styleClass="baseForm">

                                                        <table style="width:99%;">
                                                          <html:hidden property="cod"/>
                                                          <html:hidden property="seqn"/>
                                                          <html:hidden property="situacao"/>
                                                          <html:hidden property="dt_entrega"/>
                                                          <html:hidden property="cliente"/>
                                                          <html:hidden property="ped_ped_cliente"/>
                                                        </table>

                                                        <table style='width:99%;'>
                                                          <tr >
                                                            <td >
                                                              <%
                                                              if(!(request.getParameter("excel")+"").equals("true")){
                                                                %>
                                                                <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                                                                  <bean:message bundle="ApplicationResources" key="jsp.select"/>
                                                                </html:submit>
                                                                <%
                                                              }
                                                              %>
                                                              <%
                                                              if(!(request.getParameter("excel")+"").equals("true")){
                                                                %>
                                                                <html:submit accesskey="b" styleClass="myhidden" property="back_action">
                                                                  <bean:message bundle="ApplicationResources" key="jsp.back"/>
                                                                </html:submit>
                                                                <%
                                                              }
                                                              %>
                                                              <html:button accesskey="b" onclick="history.go(-1);" styleClass="myhidden" property="back1_action">
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
